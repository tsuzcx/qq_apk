package com.tencent.mm.plugin.ipcall;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.autogen.a.ah;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.ipcall.model.IPCallForegroundService;
import com.tencent.mm.plugin.ipcall.model.a.a.b;
import com.tencent.mm.plugin.ipcall.model.c.a.1;
import com.tencent.mm.plugin.ipcall.model.d.a.a;
import com.tencent.mm.plugin.ipcall.model.g;
import com.tencent.mm.plugin.ipcall.model.g.a;
import com.tencent.mm.plugin.ipcall.model.h.l;
import com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI;
import com.tencent.mm.plugin.ipcall.ui.i;
import com.tencent.mm.plugin.voip.SubCoreVoip;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.r.a;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.ui.j;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.aq;

public final class c
  implements a.a, g.a, r.a
{
  private static MMHandler mRi;
  private Object Acn;
  private boolean JFA;
  private IListener JFB;
  private Runnable JFC;
  private Runnable JFD;
  private boolean JFE;
  private com.tencent.mm.plugin.voip.ui.a JFF;
  private long JFG;
  public e JFw;
  private com.tencent.mm.plugin.ipcall.model.h.k JFx;
  private boolean JFy;
  private TelephonyManager JFz;
  private PhoneStateListener swG;
  private MTimerHandler timer;
  private IListener<ah> viz;
  
  static
  {
    AppMethodBeat.i(25324);
    mRi = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(25324);
  }
  
  public c()
  {
    AppMethodBeat.i(25294);
    this.JFy = false;
    this.JFA = false;
    this.Acn = new Object();
    this.swG = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(25288);
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        Log.d("MicroMsg.IPCallManager", "onCallStateChanged ".concat(String.valueOf(paramAnonymousInt)));
        if (paramAnonymousInt == 2)
        {
          Log.i("MicroMsg.IPCallManager", "system phone call state offhook, stop call");
          c.this.jx(0, 0);
        }
        AppMethodBeat.o(25288);
      }
    };
    this.viz = new IPCallManager.2(this, com.tencent.mm.app.f.hfK);
    this.JFB = new IPCallManager.3(this, com.tencent.mm.app.f.hfK);
    this.JFC = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25290);
        if (!com.tencent.mm.plugin.ipcall.model.h.fRu().fRm())
        {
          Log.i("MicroMsg.IPCallManager", "timeout! still not accept!");
          if (c.this.jx(9, 12)) {
            c.this.f(9, null, MMApplicationContext.getContext().getString(R.l.gwb), 2);
          }
        }
        AppMethodBeat.o(25290);
      }
    };
    this.JFD = new Runnable()
    {
      public final void run()
      {
        int i = 0;
        boolean bool3 = true;
        boolean bool2 = true;
        AppMethodBeat.i(303657);
        com.tencent.mm.plugin.voip.video.e locale = com.tencent.mm.plugin.ipcall.model.h.fRA();
        int j = R.k.ipcall_phonering;
        locale.UNQ = 0;
        if (j == 0)
        {
          locale.GS(true);
          AppMethodBeat.o(303657);
          return;
        }
        if (3500L != -1L) {}
        for (;;)
        {
          try
          {
            if (!MMApplicationContext.isMMProcess()) {
              break label308;
            }
            bool1 = ((Boolean)com.tencent.mm.kernel.h.baE().ban().d(73218, Boolean.TRUE)).booleanValue();
            Log.e("MicroMsg.RingPlayer", "get voip sound failed: " + localException1.getMessage());
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              try
              {
                Log.i("MicroMsg.RingPlayer", "startPlayCustomRingWithCustomInterval, voipSound: %s, msgSound: %s, isCallingParty: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(com.tencent.mm.k.b.aQL()), Boolean.TRUE });
                bool1 = bool2;
                if ((!bool1) || (locale.isStarted)) {
                  continue;
                }
              }
              catch (Exception localException3)
              {
                continue;
              }
              try
              {
                locale.UNR = System.currentTimeMillis();
                locale.UNP = new com.tencent.mm.compatible.b.k();
                Log.d("MicroMsg.RingPlayer", "isBluetoothOn: %b, isHeadsetPlugged: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.cTX()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.cTQ()) });
                if (af.lXZ.lRC >= 0) {
                  i = af.lXZ.lRC;
                }
                locale.BN(false);
                locale.b(j, 3500L, true, i);
                locale.isStarted = true;
                AppMethodBeat.o(303657);
                return;
              }
              catch (Exception localException2)
              {
                Log.e("MicroMsg.RingPlayer", "new MediaPlayer failed, " + localException2.toString());
              }
            }
            localException1 = localException1;
            bool1 = bool3;
          }
          continue;
          AppMethodBeat.o(303657);
          return;
          locale.R(j, 2, true);
          AppMethodBeat.o(303657);
          return;
          label308:
          boolean bool1 = true;
        }
      }
    };
    this.JFF = new com.tencent.mm.plugin.voip.ui.a()
    {
      public final void a(Intent paramAnonymousIntent, BaseSmallView paramAnonymousBaseSmallView)
      {
        AppMethodBeat.i(303659);
        if (!com.tencent.mm.plugin.ipcall.model.h.fRu().fRm())
        {
          paramAnonymousBaseSmallView.updateText(MMApplicationContext.getContext().getString(R.l.multitalk_waiting_wording));
          AppMethodBeat.o(303659);
          return;
        }
        int i = c.this.fQR();
        paramAnonymousBaseSmallView.aNF(String.format("%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
        AppMethodBeat.o(303659);
      }
      
      public final boolean fQS()
      {
        AppMethodBeat.i(303655);
        if (com.tencent.mm.plugin.ipcall.model.h.fRu().fRj())
        {
          AppMethodBeat.o(303655);
          return true;
        }
        AppMethodBeat.o(303655);
        return false;
      }
      
      public final void fQT() {}
      
      public final void fQU() {}
    };
    this.JFG = 0L;
    AppMethodBeat.o(25294);
  }
  
  public static boolean aIR(String paramString)
  {
    AppMethodBeat.i(25298);
    Log.d("MicroMsg.IPCallManager", "dialWhenTalking, dialButton: %s", new Object[] { paramString });
    if (!com.tencent.mm.plugin.ipcall.model.h.fRu().fRm())
    {
      Log.i("MicroMsg.IPCallManager", "ipcall not connect, cannot call dialWhenTalking now");
      AppMethodBeat.o(25298);
      return false;
    }
    if ((!Util.isNullOrNil(paramString)) && (paramString.length() == 1))
    {
      int i;
      if ((!Util.isNullOrNil(paramString)) && (paramString.length() == 1))
      {
        i = paramString.charAt(0);
        if ((i >= 48) && (i <= 57)) {
          i -= 48;
        }
      }
      while (i != -1)
      {
        paramString = com.tencent.mm.plugin.ipcall.model.h.fRr();
        Log.d("MicroMsg.IPCallEngineManager", "sendDTMF: %d", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.ipcall.model.d.b localb = com.tencent.mm.plugin.ipcall.model.h.fRs();
        localb.JIy += 1;
        Log.i("MicroMsg.IPCallReportHelper", "now addCallClickCnt %d", new Object[] { Integer.valueOf(localb.JIy) });
        i = paramString.JHR.SendDTMF(i);
        if (i < 0) {
          Log.i("MicroMsg.IPCallEngineManager", "sendDTMF failed, ret: %d", new Object[] { Integer.valueOf(i) });
        }
        AppMethodBeat.o(25298);
        return true;
        if (i == 42) {
          i = 10;
        } else if (i == 35) {
          i = 11;
        } else if ((i >= 65) && (i <= 68)) {
          i = i - 65 + 12;
        } else {
          i = -1;
        }
      }
    }
    AppMethodBeat.o(25298);
    return false;
  }
  
  /* Error */
  private boolean aN(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: sipush 25297
    //   3: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 219	com/tencent/mm/plugin/ipcall/model/h:fRq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   9: getfield 225	com/tencent/mm/plugin/ipcall/model/g:JGn	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   12: astore 15
    //   14: invokestatic 141	com/tencent/mm/plugin/ipcall/model/h:fRu	()Lcom/tencent/mm/plugin/ipcall/model/f;
    //   17: iload_1
    //   18: invokevirtual 229	com/tencent/mm/plugin/ipcall/model/f:Zc	(I)Z
    //   21: ifne +93 -> 114
    //   24: ldc 127
    //   26: ldc 231
    //   28: iconst_1
    //   29: anewarray 4	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: invokestatic 141	com/tencent/mm/plugin/ipcall/model/h:fRu	()Lcom/tencent/mm/plugin/ipcall/model/f;
    //   37: getfield 234	com/tencent/mm/plugin/ipcall/model/f:sEu	I
    //   40: invokestatic 238	com/tencent/mm/plugin/ipcall/model/f:Ze	(I)Ljava/lang/String;
    //   43: aastore
    //   44: invokestatic 197	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: aload 15
    //   49: ifnull +57 -> 106
    //   52: ldc 127
    //   54: ldc 240
    //   56: iconst_5
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload 15
    //   64: getfield 245	com/tencent/mm/plugin/ipcall/model/b/c:JGW	I
    //   67: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: aload 15
    //   75: getfield 248	com/tencent/mm/plugin/ipcall/model/b/c:roomId	I
    //   78: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: aastore
    //   82: dup
    //   83: iconst_2
    //   84: iload_1
    //   85: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: aastore
    //   89: dup
    //   90: iconst_3
    //   91: iload_2
    //   92: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   95: aastore
    //   96: dup
    //   97: iconst_4
    //   98: iload_3
    //   99: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: invokestatic 197	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: sipush 25297
    //   109: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: iconst_0
    //   113: ireturn
    //   114: aload 15
    //   116: ifnull +57 -> 173
    //   119: ldc 127
    //   121: ldc 250
    //   123: iconst_5
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: aload 15
    //   131: getfield 245	com/tencent/mm/plugin/ipcall/model/b/c:JGW	I
    //   134: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: aastore
    //   138: dup
    //   139: iconst_1
    //   140: aload 15
    //   142: getfield 248	com/tencent/mm/plugin/ipcall/model/b/c:roomId	I
    //   145: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: aastore
    //   149: dup
    //   150: iconst_2
    //   151: iload_1
    //   152: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   155: aastore
    //   156: dup
    //   157: iconst_3
    //   158: iload_2
    //   159: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: aastore
    //   163: dup
    //   164: iconst_4
    //   165: iload_3
    //   166: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   169: aastore
    //   170: invokestatic 197	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: invokestatic 254	com/tencent/mm/plugin/ipcall/model/h:fRA	()Lcom/tencent/mm/plugin/voip/video/e;
    //   176: invokevirtual 259	com/tencent/mm/plugin/voip/video/e:stop	()V
    //   179: invokestatic 254	com/tencent/mm/plugin/ipcall/model/h:fRA	()Lcom/tencent/mm/plugin/voip/video/e;
    //   182: astore 15
    //   184: getstatic 264	com/tencent/mm/R$k:close_lower_volume	I
    //   187: istore 5
    //   189: invokestatic 268	com/tencent/mm/plugin/ipcall/model/h:fRt	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   192: getfield 274	com/tencent/mm/plugin/ipcall/model/c/b:JHB	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   195: invokevirtual 279	com/tencent/mm/plugin/ipcall/model/a/a:cTU	()Z
    //   198: istore 8
    //   200: aload 15
    //   202: getfield 283	com/tencent/mm/plugin/voip/video/e:mContext	Landroid/content/Context;
    //   205: invokestatic 289	com/tencent/mm/sdk/platformtools/MMApplicationContext:getDefaultPreferencePath	()Ljava/lang/String;
    //   208: iconst_0
    //   209: invokevirtual 295	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   212: ldc_w 297
    //   215: iconst_1
    //   216: invokeinterface 303 3 0
    //   221: pop
    //   222: ldc_w 305
    //   225: invokestatic 311	com/tencent/mm/plugin/audio/c/a:ahs	(Ljava/lang/String;)Lcom/tencent/mm/plugin/audio/b/a;
    //   228: iload 8
    //   230: invokevirtual 317	com/tencent/mm/plugin/audio/b/a:ee	(Z)V
    //   233: iload 8
    //   235: ifeq +1469 -> 1704
    //   238: iconst_0
    //   239: invokestatic 320	com/tencent/mm/plugin/audio/c/a:setMode	(I)V
    //   242: ldc_w 322
    //   245: ldc_w 324
    //   248: iconst_3
    //   249: anewarray 4	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: getstatic 330	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   257: aastore
    //   258: dup
    //   259: iconst_1
    //   260: iload 8
    //   262: invokestatic 333	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   265: aastore
    //   266: dup
    //   267: iconst_2
    //   268: iconst_2
    //   269: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   272: aastore
    //   273: invokestatic 197	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   276: aload 15
    //   278: invokestatic 339	java/lang/System:currentTimeMillis	()J
    //   281: putfield 342	com/tencent/mm/plugin/voip/video/e:UNS	J
    //   284: new 344	com/tencent/mm/compatible/b/k
    //   287: dup
    //   288: invokespecial 345	com/tencent/mm/compatible/b/k:<init>	()V
    //   291: astore 16
    //   293: aload 16
    //   295: aload 15
    //   297: getfield 283	com/tencent/mm/plugin/voip/video/e:mContext	Landroid/content/Context;
    //   300: new 347	java/lang/StringBuilder
    //   303: dup
    //   304: ldc_w 349
    //   307: invokespecial 352	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   310: aload 15
    //   312: getfield 283	com/tencent/mm/plugin/voip/video/e:mContext	Landroid/content/Context;
    //   315: invokevirtual 355	android/content/Context:getPackageName	()Ljava/lang/String;
    //   318: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: ldc_w 361
    //   324: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: iload 5
    //   329: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 373	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   338: invokevirtual 379	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   341: aload 16
    //   343: new 381	com/tencent/mm/plugin/voip/video/e$7
    //   346: dup
    //   347: aload 15
    //   349: invokespecial 384	com/tencent/mm/plugin/voip/video/e$7:<init>	(Lcom/tencent/mm/plugin/voip/video/e;)V
    //   352: invokevirtual 388	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   355: aload 16
    //   357: new 390	com/tencent/mm/plugin/voip/video/e$8
    //   360: dup
    //   361: aload 15
    //   363: invokespecial 391	com/tencent/mm/plugin/voip/video/e$8:<init>	(Lcom/tencent/mm/plugin/voip/video/e;)V
    //   366: invokevirtual 395	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   369: invokestatic 398	com/tencent/mm/plugin/audio/c/a:cTX	()Z
    //   372: ifne +1992 -> 2364
    //   375: iload 8
    //   377: ifne +1334 -> 1711
    //   380: goto +1984 -> 2364
    //   383: aload 16
    //   385: iload 5
    //   387: invokevirtual 401	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   390: aload 16
    //   392: invokevirtual 404	android/media/MediaPlayer:prepare	()V
    //   395: aload 16
    //   397: iconst_0
    //   398: invokevirtual 407	android/media/MediaPlayer:setLooping	(Z)V
    //   401: aload 16
    //   403: invokevirtual 410	android/media/MediaPlayer:start	()V
    //   406: invokestatic 339	java/lang/System:currentTimeMillis	()J
    //   409: aload 15
    //   411: getfield 342	com/tencent/mm/plugin/voip/video/e:UNS	J
    //   414: lsub
    //   415: ldc2_w 411
    //   418: lcmp
    //   419: ifle +10 -> 429
    //   422: aload 15
    //   424: bipush 7
    //   426: putfield 415	com/tencent/mm/plugin/voip/video/e:UNQ	I
    //   429: ldc 127
    //   431: ldc_w 417
    //   434: invokestatic 152	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   437: invokestatic 423	com/tencent/mm/plugin/voip/model/r:hXJ	()Lcom/tencent/mm/plugin/voip/model/r;
    //   440: invokevirtual 426	com/tencent/mm/plugin/voip/model/r:hXL	()V
    //   443: invokestatic 423	com/tencent/mm/plugin/voip/model/r:hXJ	()Lcom/tencent/mm/plugin/voip/model/r;
    //   446: aconst_null
    //   447: invokevirtual 429	com/tencent/mm/plugin/voip/model/r:a	(Lcom/tencent/mm/plugin/voip/model/r$a;)V
    //   450: invokestatic 185	com/tencent/mm/plugin/ipcall/model/h:fRs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   453: astore 15
    //   455: invokestatic 268	com/tencent/mm/plugin/ipcall/model/h:fRt	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   458: getfield 274	com/tencent/mm/plugin/ipcall/model/c/b:JHB	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   461: getfield 433	com/tencent/mm/plugin/ipcall/model/a/a:JGQ	Lcom/tencent/mm/plugin/ipcall/model/c/c;
    //   464: astore 16
    //   466: aload 16
    //   468: ifnull +1289 -> 1757
    //   471: aload 16
    //   473: getfield 439	com/tencent/mm/plugin/ipcall/model/c/c:JHH	Lcom/tencent/mm/audio/b/c;
    //   476: ifnull +1281 -> 1757
    //   479: aload 16
    //   481: getfield 439	com/tencent/mm/plugin/ipcall/model/c/c:JHH	Lcom/tencent/mm/audio/b/c;
    //   484: getfield 444	com/tencent/mm/audio/b/c:hwc	I
    //   487: istore 5
    //   489: aload 15
    //   491: getfield 447	com/tencent/mm/plugin/ipcall/model/d/b:JIv	I
    //   494: ifne +10 -> 504
    //   497: aload 15
    //   499: iload 5
    //   501: putfield 447	com/tencent/mm/plugin/ipcall/model/d/b:JIv	I
    //   504: invokestatic 185	com/tencent/mm/plugin/ipcall/model/h:fRs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   507: astore 15
    //   509: invokestatic 268	com/tencent/mm/plugin/ipcall/model/h:fRt	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   512: getfield 274	com/tencent/mm/plugin/ipcall/model/c/b:JHB	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   515: getfield 451	com/tencent/mm/plugin/ipcall/model/a/a:JGP	Lcom/tencent/mm/plugin/ipcall/model/c/a;
    //   518: astore 16
    //   520: aload 16
    //   522: ifnull +1241 -> 1763
    //   525: aload 16
    //   527: getfield 457	com/tencent/mm/plugin/ipcall/model/c/a:wTy	Lcom/tencent/mm/plugin/voip/model/c;
    //   530: ifnull +1233 -> 1763
    //   533: ldc_w 459
    //   536: new 347	java/lang/StringBuilder
    //   539: dup
    //   540: ldc_w 461
    //   543: invokespecial 352	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   546: aload 16
    //   548: getfield 457	com/tencent/mm/plugin/ipcall/model/c/a:wTy	Lcom/tencent/mm/plugin/voip/model/c;
    //   551: invokevirtual 466	com/tencent/mm/plugin/voip/model/c:hVG	()I
    //   554: invokevirtual 364	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   557: invokevirtual 367	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokestatic 468	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   563: aload 16
    //   565: getfield 457	com/tencent/mm/plugin/ipcall/model/c/a:wTy	Lcom/tencent/mm/plugin/voip/model/c;
    //   568: invokevirtual 466	com/tencent/mm/plugin/voip/model/c:hVG	()I
    //   571: istore 5
    //   573: aload 15
    //   575: getfield 471	com/tencent/mm/plugin/ipcall/model/d/b:JIw	I
    //   578: ifne +10 -> 588
    //   581: aload 15
    //   583: iload 5
    //   585: putfield 471	com/tencent/mm/plugin/ipcall/model/d/b:JIw	I
    //   588: invokestatic 268	com/tencent/mm/plugin/ipcall/model/h:fRt	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   591: astore 15
    //   593: invokestatic 171	com/tencent/mm/plugin/ipcall/model/h:fRr	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   596: astore 16
    //   598: aload 15
    //   600: getfield 274	com/tencent/mm/plugin/ipcall/model/c/b:JHB	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   603: astore 17
    //   605: aload 17
    //   607: getfield 451	com/tencent/mm/plugin/ipcall/model/a/a:JGP	Lcom/tencent/mm/plugin/ipcall/model/c/a;
    //   610: astore 18
    //   612: aload 18
    //   614: ifnonnull +1155 -> 1769
    //   617: iconst_0
    //   618: istore 5
    //   620: iload 5
    //   622: iconst_m1
    //   623: if_icmpne +1181 -> 1804
    //   626: iconst_0
    //   627: istore 5
    //   629: aload 16
    //   631: getfield 203	com/tencent/mm/plugin/ipcall/model/d/a:JHR	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   634: iload 5
    //   636: putfield 474	com/tencent/mm/plugin/voip/model/v2protocal:UEe	I
    //   639: aload 15
    //   641: aconst_null
    //   642: putfield 478	com/tencent/mm/plugin/ipcall/model/c/b:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   645: aload 15
    //   647: getfield 274	com/tencent/mm/plugin/ipcall/model/c/b:JHB	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   650: astore 17
    //   652: aload 17
    //   654: getfield 451	com/tencent/mm/plugin/ipcall/model/a/a:JGP	Lcom/tencent/mm/plugin/ipcall/model/c/a;
    //   657: astore 18
    //   659: aload 18
    //   661: ifnull +65 -> 726
    //   664: aload 18
    //   666: getfield 481	com/tencent/mm/plugin/ipcall/model/c/a:isStart	Z
    //   669: ifeq +57 -> 726
    //   672: ldc_w 459
    //   675: ldc_w 483
    //   678: invokestatic 152	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   681: aload 18
    //   683: getfield 486	com/tencent/mm/plugin/ipcall/model/c/a:JHy	Ljava/lang/Object;
    //   686: astore 16
    //   688: aload 16
    //   690: monitorenter
    //   691: new 488	com/tencent/mm/plugin/ipcall/model/c/a$a
    //   694: dup
    //   695: aload 18
    //   697: aload 18
    //   699: getfield 457	com/tencent/mm/plugin/ipcall/model/c/a:wTy	Lcom/tencent/mm/plugin/voip/model/c;
    //   702: invokespecial 491	com/tencent/mm/plugin/ipcall/model/c/a$a:<init>	(Lcom/tencent/mm/plugin/ipcall/model/c/a;Lcom/tencent/mm/plugin/voip/model/c;)V
    //   705: ldc_w 493
    //   708: invokestatic 499	com/tencent/mm/sdk/thread/ThreadPool:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   711: aload 18
    //   713: iconst_0
    //   714: putfield 481	com/tencent/mm/plugin/ipcall/model/c/a:isStart	Z
    //   717: aload 18
    //   719: aconst_null
    //   720: putfield 457	com/tencent/mm/plugin/ipcall/model/c/a:wTy	Lcom/tencent/mm/plugin/voip/model/c;
    //   723: aload 16
    //   725: monitorexit
    //   726: aload 17
    //   728: ldc_w 501
    //   731: invokevirtual 504	com/tencent/mm/plugin/ipcall/model/a/a:ahq	(Ljava/lang/String;)V
    //   734: aload 17
    //   736: aconst_null
    //   737: putfield 508	com/tencent/mm/plugin/ipcall/model/a/a:JGO	Lcom/tencent/mm/plugin/ipcall/model/a/a$b;
    //   740: aload 17
    //   742: getfield 512	com/tencent/mm/plugin/ipcall/model/a/a:peV	Lcom/tencent/mm/compatible/util/b;
    //   745: invokevirtual 517	com/tencent/mm/compatible/util/b:aPS	()Z
    //   748: pop
    //   749: aload 15
    //   751: aconst_null
    //   752: putfield 521	com/tencent/mm/plugin/ipcall/model/c/b:JHF	Lcom/tencent/mm/plugin/ipcall/ui/i;
    //   755: invokestatic 268	com/tencent/mm/plugin/ipcall/model/h:fRt	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   758: astore 16
    //   760: aload 16
    //   762: getfield 274	com/tencent/mm/plugin/ipcall/model/c/b:JHB	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   765: getfield 433	com/tencent/mm/plugin/ipcall/model/a/a:JGQ	Lcom/tencent/mm/plugin/ipcall/model/c/c;
    //   768: astore 17
    //   770: aload 17
    //   772: ifnull +79 -> 851
    //   775: aload 17
    //   777: getfield 522	com/tencent/mm/plugin/ipcall/model/c/c:isStart	Z
    //   780: ifeq +71 -> 851
    //   783: ldc_w 524
    //   786: ldc_w 526
    //   789: invokestatic 152	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   792: aload 17
    //   794: getfield 529	com/tencent/mm/plugin/ipcall/model/c/c:hvC	Ljava/lang/Object;
    //   797: astore 15
    //   799: aload 15
    //   801: monitorenter
    //   802: aload 17
    //   804: getfield 439	com/tencent/mm/plugin/ipcall/model/c/c:JHH	Lcom/tencent/mm/audio/b/c;
    //   807: ifnull +41 -> 848
    //   810: new 531	com/tencent/mm/plugin/ipcall/model/c/c$a
    //   813: dup
    //   814: aload 17
    //   816: aload 17
    //   818: getfield 439	com/tencent/mm/plugin/ipcall/model/c/c:JHH	Lcom/tencent/mm/audio/b/c;
    //   821: invokespecial 534	com/tencent/mm/plugin/ipcall/model/c/c$a:<init>	(Lcom/tencent/mm/plugin/ipcall/model/c/c;Lcom/tencent/mm/audio/b/c;)V
    //   824: ldc_w 536
    //   827: invokestatic 499	com/tencent/mm/sdk/thread/ThreadPool:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   830: aload 17
    //   832: aconst_null
    //   833: putfield 439	com/tencent/mm/plugin/ipcall/model/c/c:JHH	Lcom/tencent/mm/audio/b/c;
    //   836: aload 17
    //   838: iconst_0
    //   839: putfield 522	com/tencent/mm/plugin/ipcall/model/c/c:isStart	Z
    //   842: aload 17
    //   844: iconst_0
    //   845: putfield 539	com/tencent/mm/plugin/ipcall/model/c/c:lAj	Z
    //   848: aload 15
    //   850: monitorexit
    //   851: aload 16
    //   853: aconst_null
    //   854: putfield 478	com/tencent/mm/plugin/ipcall/model/c/b:lzt	Lcom/tencent/mm/ui/MMActivity;
    //   857: invokestatic 171	com/tencent/mm/plugin/ipcall/model/h:fRr	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   860: astore 15
    //   862: ldc 173
    //   864: ldc_w 541
    //   867: invokestatic 152	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   870: aload 15
    //   872: getfield 203	com/tencent/mm/plugin/ipcall/model/d/a:JHR	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   875: iconst_1
    //   876: invokevirtual 545	com/tencent/mm/plugin/voip/model/v2protocal:Gw	(Z)Ljava/lang/String;
    //   879: pop
    //   880: invokestatic 185	com/tencent/mm/plugin/ipcall/model/h:fRs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   883: astore 16
    //   885: aload 16
    //   887: getfield 549	com/tencent/mm/plugin/ipcall/model/d/b:JIq	Ljava/lang/String;
    //   890: invokestatic 157	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   893: ifeq +279 -> 1172
    //   896: aload 16
    //   898: getfield 552	com/tencent/mm/plugin/ipcall/model/d/b:JIp	Ljava/lang/String;
    //   901: invokestatic 157	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   904: ifeq +268 -> 1172
    //   907: invokestatic 219	com/tencent/mm/plugin/ipcall/model/h:fRq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   910: getfield 225	com/tencent/mm/plugin/ipcall/model/g:JGn	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   913: astore 18
    //   915: invokestatic 171	com/tencent/mm/plugin/ipcall/model/h:fRr	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   918: getfield 203	com/tencent/mm/plugin/ipcall/model/d/a:JHR	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   921: astore 17
    //   923: aload 16
    //   925: getfield 555	com/tencent/mm/plugin/ipcall/model/d/b:JIf	I
    //   928: iconst_1
    //   929: if_icmpne +934 -> 1863
    //   932: iconst_1
    //   933: istore 5
    //   935: aload 18
    //   937: getfield 558	com/tencent/mm/plugin/ipcall/model/b/c:JHp	I
    //   940: istore 6
    //   942: aload 17
    //   944: getfield 562	com/tencent/mm/plugin/voip/model/v2protocal:UFJ	[B
    //   947: astore 18
    //   949: aload 17
    //   951: getfield 562	com/tencent/mm/plugin/voip/model/v2protocal:UFJ	[B
    //   954: arraylength
    //   955: istore 7
    //   957: iload 5
    //   959: ifeq +910 -> 1869
    //   962: iconst_1
    //   963: istore 5
    //   965: aload 17
    //   967: aload 18
    //   969: iload 7
    //   971: iload 5
    //   973: iload 6
    //   975: invokevirtual 566	com/tencent/mm/plugin/voip/model/v2protocal:getPstnChannelInfo	([BIII)I
    //   978: pop
    //   979: ldc_w 568
    //   982: ldc_w 570
    //   985: iconst_1
    //   986: anewarray 4	java/lang/Object
    //   989: dup
    //   990: iconst_0
    //   991: aload 17
    //   993: getfield 573	com/tencent/mm/plugin/voip/model/v2protocal:field_pstnChannelInfoLength	I
    //   996: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   999: aastore
    //   1000: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1003: aload 16
    //   1005: new 159	java/lang/String
    //   1008: dup
    //   1009: aload 17
    //   1011: getfield 562	com/tencent/mm/plugin/voip/model/v2protocal:UFJ	[B
    //   1014: iconst_0
    //   1015: aload 17
    //   1017: getfield 573	com/tencent/mm/plugin/voip/model/v2protocal:field_pstnChannelInfoLength	I
    //   1020: invokespecial 576	java/lang/String:<init>	([BII)V
    //   1023: putfield 549	com/tencent/mm/plugin/ipcall/model/d/b:JIq	Ljava/lang/String;
    //   1026: invokestatic 171	com/tencent/mm/plugin/ipcall/model/h:fRr	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   1029: getfield 203	com/tencent/mm/plugin/ipcall/model/d/a:JHR	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1032: astore 17
    //   1034: aload 17
    //   1036: aload 17
    //   1038: getfield 579	com/tencent/mm/plugin/voip/model/v2protocal:UFK	[B
    //   1041: aload 17
    //   1043: getfield 579	com/tencent/mm/plugin/voip/model/v2protocal:UFK	[B
    //   1046: arraylength
    //   1047: invokevirtual 583	com/tencent/mm/plugin/voip/model/v2protocal:getPstnEngineInfo	([BI)I
    //   1050: pop
    //   1051: ldc_w 568
    //   1054: ldc_w 585
    //   1057: iconst_1
    //   1058: anewarray 4	java/lang/Object
    //   1061: dup
    //   1062: iconst_0
    //   1063: aload 17
    //   1065: getfield 588	com/tencent/mm/plugin/voip/model/v2protocal:field_pstnEngineInfoLength	I
    //   1068: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1071: aastore
    //   1072: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1075: aload 16
    //   1077: new 159	java/lang/String
    //   1080: dup
    //   1081: aload 17
    //   1083: getfield 579	com/tencent/mm/plugin/voip/model/v2protocal:UFK	[B
    //   1086: iconst_0
    //   1087: aload 17
    //   1089: getfield 588	com/tencent/mm/plugin/voip/model/v2protocal:field_pstnEngineInfoLength	I
    //   1092: invokespecial 576	java/lang/String:<init>	([BII)V
    //   1095: putfield 552	com/tencent/mm/plugin/ipcall/model/d/b:JIp	Ljava/lang/String;
    //   1098: aload 16
    //   1100: invokestatic 171	com/tencent/mm/plugin/ipcall/model/h:fRr	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   1103: getfield 203	com/tencent/mm/plugin/ipcall/model/d/a:JHR	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1106: invokevirtual 591	com/tencent/mm/plugin/voip/model/v2protocal:hZl	()Ljava/lang/String;
    //   1109: putfield 594	com/tencent/mm/plugin/ipcall/model/d/b:JIr	Ljava/lang/String;
    //   1112: ldc 193
    //   1114: ldc_w 596
    //   1117: iconst_1
    //   1118: anewarray 4	java/lang/Object
    //   1121: dup
    //   1122: iconst_0
    //   1123: aload 16
    //   1125: getfield 549	com/tencent/mm/plugin/ipcall/model/d/b:JIq	Ljava/lang/String;
    //   1128: aastore
    //   1129: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1132: ldc 193
    //   1134: ldc_w 598
    //   1137: iconst_1
    //   1138: anewarray 4	java/lang/Object
    //   1141: dup
    //   1142: iconst_0
    //   1143: aload 16
    //   1145: getfield 552	com/tencent/mm/plugin/ipcall/model/d/b:JIp	Ljava/lang/String;
    //   1148: aastore
    //   1149: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1152: ldc 193
    //   1154: ldc_w 600
    //   1157: iconst_1
    //   1158: anewarray 4	java/lang/Object
    //   1161: dup
    //   1162: iconst_0
    //   1163: aload 16
    //   1165: getfield 594	com/tencent/mm/plugin/ipcall/model/d/b:JIr	Ljava/lang/String;
    //   1168: aastore
    //   1169: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1172: aload 15
    //   1174: getfield 203	com/tencent/mm/plugin/ipcall/model/d/a:JHR	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1177: invokevirtual 603	com/tencent/mm/plugin/voip/model/v2protocal:reset	()V
    //   1180: aload 15
    //   1182: invokevirtual 606	com/tencent/mm/plugin/ipcall/model/d/a:resetStatus	()V
    //   1185: getstatic 73	com/tencent/mm/plugin/ipcall/c:mRi	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   1188: aload_0
    //   1189: getfield 114	com/tencent/mm/plugin/ipcall/c:JFD	Ljava/lang/Runnable;
    //   1192: invokevirtual 610	com/tencent/mm/sdk/platformtools/MMHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1195: getstatic 73	com/tencent/mm/plugin/ipcall/c:mRi	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   1198: aload_0
    //   1199: getfield 111	com/tencent/mm/plugin/ipcall/c:JFC	Ljava/lang/Runnable;
    //   1202: invokevirtual 610	com/tencent/mm/sdk/platformtools/MMHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1205: aload_0
    //   1206: getfield 612	com/tencent/mm/plugin/ipcall/c:timer	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   1209: ifnull +15 -> 1224
    //   1212: aload_0
    //   1213: getfield 612	com/tencent/mm/plugin/ipcall/c:timer	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   1216: invokevirtual 617	com/tencent/mm/sdk/platformtools/MTimerHandler:stopTimer	()V
    //   1219: aload_0
    //   1220: aconst_null
    //   1221: putfield 612	com/tencent/mm/plugin/ipcall/c:timer	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   1224: invokestatic 185	com/tencent/mm/plugin/ipcall/model/h:fRs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1227: iload_3
    //   1228: putfield 620	com/tencent/mm/plugin/ipcall/model/d/b:JIh	I
    //   1231: invokestatic 185	com/tencent/mm/plugin/ipcall/model/h:fRs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1234: astore 15
    //   1236: ldc 193
    //   1238: ldc_w 622
    //   1241: invokestatic 468	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1244: aload 15
    //   1246: getfield 625	com/tencent/mm/plugin/ipcall/model/d/b:JIo	J
    //   1249: lconst_0
    //   1250: lcmp
    //   1251: ifne +64 -> 1315
    //   1254: aload 15
    //   1256: getfield 628	com/tencent/mm/plugin/ipcall/model/d/b:JIn	J
    //   1259: lconst_0
    //   1260: lcmp
    //   1261: ifeq +54 -> 1315
    //   1264: aload 15
    //   1266: invokestatic 339	java/lang/System:currentTimeMillis	()J
    //   1269: putfield 625	com/tencent/mm/plugin/ipcall/model/d/b:JIo	J
    //   1272: aload 15
    //   1274: aload 15
    //   1276: getfield 625	com/tencent/mm/plugin/ipcall/model/d/b:JIo	J
    //   1279: aload 15
    //   1281: getfield 628	com/tencent/mm/plugin/ipcall/model/d/b:JIn	J
    //   1284: lsub
    //   1285: ldc2_w 629
    //   1288: ldiv
    //   1289: putfield 633	com/tencent/mm/plugin/ipcall/model/d/b:JIg	J
    //   1292: ldc 193
    //   1294: ldc_w 635
    //   1297: iconst_1
    //   1298: anewarray 4	java/lang/Object
    //   1301: dup
    //   1302: iconst_0
    //   1303: aload 15
    //   1305: getfield 633	com/tencent/mm/plugin/ipcall/model/d/b:JIg	J
    //   1308: invokestatic 640	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1311: aastore
    //   1312: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1315: iload_1
    //   1316: bipush 8
    //   1318: if_icmpne +557 -> 1875
    //   1321: invokestatic 219	com/tencent/mm/plugin/ipcall/model/h:fRq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1324: invokevirtual 643	com/tencent/mm/plugin/ipcall/model/g:fRn	()V
    //   1327: invokestatic 185	com/tencent/mm/plugin/ipcall/model/h:fRs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1330: invokevirtual 646	com/tencent/mm/plugin/ipcall/model/d/b:fRN	()V
    //   1333: aload_0
    //   1334: getfield 648	com/tencent/mm/plugin/ipcall/c:JFx	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1337: astore 15
    //   1339: aload 15
    //   1341: ifnull +53 -> 1394
    //   1344: ldc_w 650
    //   1347: ldc_w 652
    //   1350: iconst_1
    //   1351: anewarray 4	java/lang/Object
    //   1354: dup
    //   1355: iconst_0
    //   1356: aload 15
    //   1358: getfield 657	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   1361: invokestatic 640	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1364: aastore
    //   1365: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1368: aload 15
    //   1370: getfield 657	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   1373: ldc2_w 658
    //   1376: lcmp
    //   1377: ifeq +17 -> 1394
    //   1380: aload 15
    //   1382: iconst_2
    //   1383: putfield 662	com/tencent/mm/plugin/ipcall/model/h/k:field_status	I
    //   1386: invokestatic 666	com/tencent/mm/plugin/ipcall/model/h:fRx	()Lcom/tencent/mm/plugin/ipcall/model/h/l;
    //   1389: aload 15
    //   1391: invokevirtual 671	com/tencent/mm/plugin/ipcall/model/h/l:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)V
    //   1394: invokestatic 219	com/tencent/mm/plugin/ipcall/model/h:fRq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1397: getfield 674	com/tencent/mm/plugin/ipcall/model/g:hWt	Z
    //   1400: ifeq +186 -> 1586
    //   1403: aload_0
    //   1404: getfield 676	com/tencent/mm/plugin/ipcall/c:JFE	Z
    //   1407: ifne +914 -> 2321
    //   1410: invokestatic 219	com/tencent/mm/plugin/ipcall/model/h:fRq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1413: getfield 225	com/tencent/mm/plugin/ipcall/model/g:JGn	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   1416: getfield 248	com/tencent/mm/plugin/ipcall/model/b/c:roomId	I
    //   1419: ifeq +902 -> 2321
    //   1422: invokestatic 219	com/tencent/mm/plugin/ipcall/model/h:fRq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1425: getfield 225	com/tencent/mm/plugin/ipcall/model/g:JGn	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   1428: getfield 679	com/tencent/mm/plugin/ipcall/model/b/c:JGV	J
    //   1431: lconst_0
    //   1432: lcmp
    //   1433: ifeq +888 -> 2321
    //   1436: invokestatic 683	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1439: astore 15
    //   1441: invokestatic 219	com/tencent/mm/plugin/ipcall/model/h:fRq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1444: getfield 225	com/tencent/mm/plugin/ipcall/model/g:JGn	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   1447: getfield 248	com/tencent/mm/plugin/ipcall/model/b/c:roomId	I
    //   1450: istore_2
    //   1451: invokestatic 219	com/tencent/mm/plugin/ipcall/model/h:fRq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1454: getfield 225	com/tencent/mm/plugin/ipcall/model/g:JGn	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   1457: getfield 679	com/tencent/mm/plugin/ipcall/model/b/c:JGV	J
    //   1460: lstore 9
    //   1462: ldc_w 685
    //   1465: ldc_w 687
    //   1468: invokestatic 152	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1471: invokestatic 692	com/tencent/mm/plugin/ipcall/d:fQV	()Z
    //   1474: ifeq +112 -> 1586
    //   1477: invokestatic 698	com/tencent/mm/k/i:aRC	()Lcom/tencent/mm/k/f;
    //   1480: ldc_w 700
    //   1483: iconst_0
    //   1484: invokevirtual 706	com/tencent/mm/k/f:getInt	(Ljava/lang/String;I)I
    //   1487: istore_3
    //   1488: invokestatic 712	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   1491: pop
    //   1492: invokestatic 718	com/tencent/mm/model/c:ban	()Lcom/tencent/mm/storage/aq;
    //   1495: getstatic 724	com/tencent/mm/storage/at$a:acLa	Lcom/tencent/mm/storage/at$a;
    //   1498: iconst_0
    //   1499: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1502: invokevirtual 730	com/tencent/mm/storage/aq:get	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   1505: checkcast 177	java/lang/Integer
    //   1508: invokevirtual 733	java/lang/Integer:intValue	()I
    //   1511: istore_1
    //   1512: invokestatic 712	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   1515: pop
    //   1516: invokestatic 718	com/tencent/mm/model/c:ban	()Lcom/tencent/mm/storage/aq;
    //   1519: getstatic 736	com/tencent/mm/storage/at$a:acKZ	Lcom/tencent/mm/storage/at$a;
    //   1522: lconst_0
    //   1523: invokestatic 640	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1526: invokevirtual 730	com/tencent/mm/storage/aq:get	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   1529: checkcast 637	java/lang/Long
    //   1532: invokevirtual 739	java/lang/Long:longValue	()J
    //   1535: lstore 11
    //   1537: invokestatic 742	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   1540: lstore 13
    //   1542: lload 13
    //   1544: lload 11
    //   1546: lsub
    //   1547: ldc2_w 743
    //   1550: lcmp
    //   1551: ifle +810 -> 2361
    //   1554: iconst_0
    //   1555: istore_1
    //   1556: ldc_w 685
    //   1559: ldc_w 746
    //   1562: invokestatic 152	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1565: iload_1
    //   1566: iload_3
    //   1567: if_icmplt +647 -> 2214
    //   1570: ldc_w 685
    //   1573: ldc_w 748
    //   1576: iload_3
    //   1577: invokestatic 750	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1580: invokevirtual 754	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1583: invokestatic 152	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1586: invokestatic 219	com/tencent/mm/plugin/ipcall/model/h:fRq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1589: aconst_null
    //   1590: putfield 758	com/tencent/mm/plugin/ipcall/model/g:JGe	Lcom/tencent/mm/plugin/ipcall/model/g$a;
    //   1593: invokestatic 171	com/tencent/mm/plugin/ipcall/model/h:fRr	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   1596: aconst_null
    //   1597: putfield 762	com/tencent/mm/plugin/ipcall/model/d/a:JHW	Lcom/tencent/mm/plugin/ipcall/model/d/a$a;
    //   1600: invokestatic 141	com/tencent/mm/plugin/ipcall/model/h:fRu	()Lcom/tencent/mm/plugin/ipcall/model/f;
    //   1603: iconst_m1
    //   1604: putfield 234	com/tencent/mm/plugin/ipcall/model/f:sEu	I
    //   1607: invokestatic 766	com/tencent/mm/plugin/ipcall/model/h:fRo	()Lcom/tencent/mm/plugin/ipcall/model/h;
    //   1610: pop
    //   1611: invokestatic 769	com/tencent/mm/plugin/ipcall/model/a/a:unInit	()V
    //   1614: getstatic 775	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   1617: new 20	com/tencent/mm/plugin/ipcall/c$5
    //   1620: dup
    //   1621: aload_0
    //   1622: invokespecial 776	com/tencent/mm/plugin/ipcall/c$5:<init>	(Lcom/tencent/mm/plugin/ipcall/c;)V
    //   1625: invokeinterface 782 2 0
    //   1630: pop
    //   1631: aload_0
    //   1632: invokespecial 785	com/tencent/mm/plugin/ipcall/c:removeListener	()V
    //   1635: ldc 127
    //   1637: ldc_w 787
    //   1640: iconst_0
    //   1641: anewarray 4	java/lang/Object
    //   1644: invokestatic 790	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1647: bipush 26
    //   1649: invokestatic 795	com/tencent/mm/compatible/util/d:rb	(I)Z
    //   1652: ifeq +44 -> 1696
    //   1655: new 797	android/content/Intent
    //   1658: dup
    //   1659: invokespecial 798	android/content/Intent:<init>	()V
    //   1662: astore 15
    //   1664: aload 15
    //   1666: invokestatic 683	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1669: ldc_w 800
    //   1672: invokevirtual 804	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   1675: pop
    //   1676: invokestatic 683	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1679: aload 15
    //   1681: invokevirtual 808	android/content/Context:stopService	(Landroid/content/Intent;)Z
    //   1684: pop
    //   1685: iconst_1
    //   1686: istore_1
    //   1687: iload_1
    //   1688: ifeq +8 -> 1696
    //   1691: aload_0
    //   1692: iconst_0
    //   1693: putfield 83	com/tencent/mm/plugin/ipcall/c:JFA	Z
    //   1696: sipush 25297
    //   1699: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1702: iconst_1
    //   1703: ireturn
    //   1704: iconst_2
    //   1705: invokestatic 320	com/tencent/mm/plugin/audio/c/a:setMode	(I)V
    //   1708: goto -1466 -> 242
    //   1711: iconst_2
    //   1712: istore 5
    //   1714: goto -1331 -> 383
    //   1717: astore 17
    //   1719: ldc_w 322
    //   1722: ldc_w 810
    //   1725: iconst_1
    //   1726: anewarray 4	java/lang/Object
    //   1729: dup
    //   1730: iconst_0
    //   1731: aload 17
    //   1733: aastore
    //   1734: invokestatic 813	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1737: aload 15
    //   1739: bipush 6
    //   1741: putfield 415	com/tencent/mm/plugin/voip/video/e:UNQ	I
    //   1744: aload 16
    //   1746: invokevirtual 814	android/media/MediaPlayer:stop	()V
    //   1749: aload 16
    //   1751: invokevirtual 817	android/media/MediaPlayer:release	()V
    //   1754: goto -1325 -> 429
    //   1757: iconst_0
    //   1758: istore 5
    //   1760: goto -1271 -> 489
    //   1763: iconst_0
    //   1764: istore 5
    //   1766: goto -1193 -> 573
    //   1769: aload 18
    //   1771: getfield 457	com/tencent/mm/plugin/ipcall/model/c/a:wTy	Lcom/tencent/mm/plugin/voip/model/c;
    //   1774: ifnull +24 -> 1798
    //   1777: aload 18
    //   1779: getfield 481	com/tencent/mm/plugin/ipcall/model/c/a:isStart	Z
    //   1782: ifeq +16 -> 1798
    //   1785: aload 18
    //   1787: getfield 457	com/tencent/mm/plugin/ipcall/model/c/a:wTy	Lcom/tencent/mm/plugin/voip/model/c;
    //   1790: invokevirtual 820	com/tencent/mm/plugin/voip/model/c:gdZ	()I
    //   1793: istore 5
    //   1795: goto -1175 -> 620
    //   1798: iconst_m1
    //   1799: istore 5
    //   1801: goto -1181 -> 620
    //   1804: aload 17
    //   1806: iload 5
    //   1808: invokevirtual 823	com/tencent/mm/plugin/ipcall/model/a/a:getStreamMaxVolume	(I)I
    //   1811: i2f
    //   1812: fstore 4
    //   1814: aload 17
    //   1816: iload 5
    //   1818: invokevirtual 826	com/tencent/mm/plugin/ipcall/model/a/a:getStreamVolume	(I)I
    //   1821: i2f
    //   1822: fload 4
    //   1824: fdiv
    //   1825: ldc_w 827
    //   1828: fmul
    //   1829: f2i
    //   1830: istore 5
    //   1832: goto -1203 -> 629
    //   1835: astore 15
    //   1837: aload 16
    //   1839: monitorexit
    //   1840: sipush 25297
    //   1843: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1846: aload 15
    //   1848: athrow
    //   1849: astore 16
    //   1851: aload 15
    //   1853: monitorexit
    //   1854: sipush 25297
    //   1857: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1860: aload 16
    //   1862: athrow
    //   1863: iconst_0
    //   1864: istore 5
    //   1866: goto -931 -> 935
    //   1869: iconst_0
    //   1870: istore 5
    //   1872: goto -907 -> 965
    //   1875: iload_1
    //   1876: bipush 12
    //   1878: if_icmpne +97 -> 1975
    //   1881: invokestatic 219	com/tencent/mm/plugin/ipcall/model/h:fRq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1884: invokevirtual 643	com/tencent/mm/plugin/ipcall/model/g:fRn	()V
    //   1887: invokestatic 185	com/tencent/mm/plugin/ipcall/model/h:fRs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1890: invokevirtual 646	com/tencent/mm/plugin/ipcall/model/d/b:fRN	()V
    //   1893: iload_2
    //   1894: bipush 11
    //   1896: if_icmpne +14 -> 1910
    //   1899: aload_0
    //   1900: getfield 648	com/tencent/mm/plugin/ipcall/c:JFx	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1903: invokestatic 833	com/tencent/mm/plugin/ipcall/model/h/m:b	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1906: pop
    //   1907: goto -513 -> 1394
    //   1910: aload_0
    //   1911: getfield 648	com/tencent/mm/plugin/ipcall/c:JFx	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1914: astore 15
    //   1916: aload 15
    //   1918: ifnull -524 -> 1394
    //   1921: ldc_w 650
    //   1924: ldc_w 835
    //   1927: iconst_1
    //   1928: anewarray 4	java/lang/Object
    //   1931: dup
    //   1932: iconst_0
    //   1933: aload 15
    //   1935: getfield 657	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   1938: invokestatic 640	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1941: aastore
    //   1942: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1945: aload 15
    //   1947: getfield 657	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   1950: ldc2_w 658
    //   1953: lcmp
    //   1954: ifeq -560 -> 1394
    //   1957: aload 15
    //   1959: bipush 6
    //   1961: putfield 662	com/tencent/mm/plugin/ipcall/model/h/k:field_status	I
    //   1964: invokestatic 666	com/tencent/mm/plugin/ipcall/model/h:fRx	()Lcom/tencent/mm/plugin/ipcall/model/h/l;
    //   1967: aload 15
    //   1969: invokevirtual 671	com/tencent/mm/plugin/ipcall/model/h/l:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)V
    //   1972: goto -578 -> 1394
    //   1975: iload_1
    //   1976: bipush 9
    //   1978: if_icmpne +33 -> 2011
    //   1981: invokestatic 219	com/tencent/mm/plugin/ipcall/model/h:fRq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1984: iconst_1
    //   1985: invokevirtual 838	com/tencent/mm/plugin/ipcall/model/g:Zf	(I)V
    //   1988: invokestatic 185	com/tencent/mm/plugin/ipcall/model/h:fRs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1991: invokevirtual 841	com/tencent/mm/plugin/ipcall/model/d/b:fRM	()V
    //   1994: aload_0
    //   1995: getfield 648	com/tencent/mm/plugin/ipcall/c:JFx	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1998: invokestatic 185	com/tencent/mm/plugin/ipcall/model/h:fRs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   2001: getfield 633	com/tencent/mm/plugin/ipcall/model/d/b:JIg	J
    //   2004: invokestatic 844	com/tencent/mm/plugin/ipcall/model/h/m:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;J)Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2007: pop
    //   2008: goto -614 -> 1394
    //   2011: iload_1
    //   2012: bipush 10
    //   2014: if_icmpne +116 -> 2130
    //   2017: invokestatic 219	com/tencent/mm/plugin/ipcall/model/h:fRq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   2020: iconst_1
    //   2021: invokevirtual 838	com/tencent/mm/plugin/ipcall/model/g:Zf	(I)V
    //   2024: invokestatic 185	com/tencent/mm/plugin/ipcall/model/h:fRs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   2027: astore 15
    //   2029: ldc 193
    //   2031: ldc_w 846
    //   2034: invokestatic 152	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2037: aload 15
    //   2039: iconst_1
    //   2040: putfield 849	com/tencent/mm/plugin/ipcall/model/d/b:JIa	I
    //   2043: aload_0
    //   2044: getfield 648	com/tencent/mm/plugin/ipcall/c:JFx	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2047: astore 15
    //   2049: invokestatic 185	com/tencent/mm/plugin/ipcall/model/h:fRs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   2052: getfield 633	com/tencent/mm/plugin/ipcall/model/d/b:JIg	J
    //   2055: lstore 9
    //   2057: aload 15
    //   2059: ifnull -665 -> 1394
    //   2062: ldc_w 650
    //   2065: ldc_w 851
    //   2068: iconst_2
    //   2069: anewarray 4	java/lang/Object
    //   2072: dup
    //   2073: iconst_0
    //   2074: aload 15
    //   2076: getfield 657	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   2079: invokestatic 640	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2082: aastore
    //   2083: dup
    //   2084: iconst_1
    //   2085: lload 9
    //   2087: invokestatic 640	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2090: aastore
    //   2091: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2094: aload 15
    //   2096: getfield 657	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   2099: ldc2_w 658
    //   2102: lcmp
    //   2103: ifeq -709 -> 1394
    //   2106: aload 15
    //   2108: iconst_5
    //   2109: putfield 662	com/tencent/mm/plugin/ipcall/model/h/k:field_status	I
    //   2112: aload 15
    //   2114: lload 9
    //   2116: putfield 854	com/tencent/mm/plugin/ipcall/model/h/k:field_duration	J
    //   2119: invokestatic 666	com/tencent/mm/plugin/ipcall/model/h:fRx	()Lcom/tencent/mm/plugin/ipcall/model/h/l;
    //   2122: aload 15
    //   2124: invokevirtual 671	com/tencent/mm/plugin/ipcall/model/h/l:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)V
    //   2127: goto -733 -> 1394
    //   2130: iload_1
    //   2131: bipush 11
    //   2133: if_icmpne -739 -> 1394
    //   2136: iload_2
    //   2137: iconst_5
    //   2138: if_icmpne +33 -> 2171
    //   2141: invokestatic 219	com/tencent/mm/plugin/ipcall/model/h:fRq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   2144: iconst_3
    //   2145: invokevirtual 838	com/tencent/mm/plugin/ipcall/model/g:Zf	(I)V
    //   2148: invokestatic 185	com/tencent/mm/plugin/ipcall/model/h:fRs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   2151: invokevirtual 841	com/tencent/mm/plugin/ipcall/model/d/b:fRM	()V
    //   2154: iload_2
    //   2155: bipush 11
    //   2157: if_icmpne +40 -> 2197
    //   2160: aload_0
    //   2161: getfield 648	com/tencent/mm/plugin/ipcall/c:JFx	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2164: invokestatic 833	com/tencent/mm/plugin/ipcall/model/h/m:b	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2167: pop
    //   2168: goto -774 -> 1394
    //   2171: iload_2
    //   2172: bipush 11
    //   2174: if_icmpne +13 -> 2187
    //   2177: invokestatic 219	com/tencent/mm/plugin/ipcall/model/h:fRq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   2180: iconst_1
    //   2181: invokevirtual 838	com/tencent/mm/plugin/ipcall/model/g:Zf	(I)V
    //   2184: goto -36 -> 2148
    //   2187: invokestatic 219	com/tencent/mm/plugin/ipcall/model/h:fRq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   2190: iconst_2
    //   2191: invokevirtual 838	com/tencent/mm/plugin/ipcall/model/g:Zf	(I)V
    //   2194: goto -46 -> 2148
    //   2197: aload_0
    //   2198: getfield 648	com/tencent/mm/plugin/ipcall/c:JFx	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2201: invokestatic 185	com/tencent/mm/plugin/ipcall/model/h:fRs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   2204: getfield 633	com/tencent/mm/plugin/ipcall/model/d/b:JIg	J
    //   2207: invokestatic 844	com/tencent/mm/plugin/ipcall/model/h/m:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;J)Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2210: pop
    //   2211: goto -817 -> 1394
    //   2214: lload 13
    //   2216: lload 11
    //   2218: lsub
    //   2219: ldc2_w 855
    //   2222: lcmp
    //   2223: ifge +15 -> 2238
    //   2226: ldc_w 685
    //   2229: ldc_w 858
    //   2232: invokestatic 152	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2235: goto -649 -> 1586
    //   2238: invokestatic 712	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   2241: pop
    //   2242: invokestatic 718	com/tencent/mm/model/c:ban	()Lcom/tencent/mm/storage/aq;
    //   2245: getstatic 724	com/tencent/mm/storage/at$a:acLa	Lcom/tencent/mm/storage/at$a;
    //   2248: iload_1
    //   2249: iconst_1
    //   2250: iadd
    //   2251: invokestatic 181	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2254: invokevirtual 862	com/tencent/mm/storage/aq:set	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)V
    //   2257: invokestatic 712	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
    //   2260: pop
    //   2261: invokestatic 718	com/tencent/mm/model/c:ban	()Lcom/tencent/mm/storage/aq;
    //   2264: getstatic 736	com/tencent/mm/storage/at$a:acKZ	Lcom/tencent/mm/storage/at$a;
    //   2267: lload 13
    //   2269: invokestatic 640	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2272: invokevirtual 862	com/tencent/mm/storage/aq:set	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)V
    //   2275: new 797	android/content/Intent
    //   2278: dup
    //   2279: invokespecial 798	android/content/Intent:<init>	()V
    //   2282: astore 16
    //   2284: aload 16
    //   2286: ldc_w 864
    //   2289: iload_2
    //   2290: invokevirtual 868	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2293: pop
    //   2294: aload 16
    //   2296: ldc_w 870
    //   2299: lload 9
    //   2301: invokevirtual 873	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   2304: pop
    //   2305: aload 15
    //   2307: ldc_w 501
    //   2310: ldc_w 875
    //   2313: aload 16
    //   2315: invokestatic 880	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   2318: goto -732 -> 1586
    //   2321: ldc 127
    //   2323: ldc_w 882
    //   2326: invokestatic 885	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2329: goto -743 -> 1586
    //   2332: astore 15
    //   2334: ldc 127
    //   2336: aload 15
    //   2338: ldc_w 887
    //   2341: iconst_1
    //   2342: anewarray 4	java/lang/Object
    //   2345: dup
    //   2346: iconst_0
    //   2347: aload 15
    //   2349: invokevirtual 890	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2352: aastore
    //   2353: invokestatic 894	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2356: iconst_0
    //   2357: istore_1
    //   2358: goto -671 -> 1687
    //   2361: goto -796 -> 1565
    //   2364: iconst_0
    //   2365: istore 5
    //   2367: goto -1984 -> 383
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2370	0	this	c
    //   0	2370	1	paramInt1	int
    //   0	2370	2	paramInt2	int
    //   0	2370	3	paramInt3	int
    //   1812	11	4	f	float
    //   187	2179	5	i	int
    //   940	34	6	j	int
    //   955	15	7	k	int
    //   198	178	8	bool	boolean
    //   1460	840	9	l1	long
    //   1535	682	11	l2	long
    //   1540	728	13	l3	long
    //   1835	17	15	localObject2	Object
    //   1914	392	15	localObject3	Object
    //   2332	16	15	localException	Exception
    //   1849	12	16	localObject5	Object
    //   2282	32	16	localIntent	Intent
    //   603	485	17	localObject6	Object
    //   1717	98	17	localObject7	Object
    //   610	1176	18	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   293	375	1717	finally
    //   383	429	1717	finally
    //   691	726	1835	finally
    //   802	848	1849	finally
    //   848	851	1849	finally
    //   1655	1685	2332	java/lang/Exception
  }
  
  private void bYv()
  {
    AppMethodBeat.i(25323);
    Log.i("MicroMsg.IPCallManager", "startTimeCount");
    if (this.timer != null)
    {
      this.timer.stopTimer();
      AppMethodBeat.o(25323);
      return;
    }
    if (this.timer == null) {
      this.timer = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(303660);
          c.this.fQQ();
          if ((com.tencent.mm.plugin.ipcall.model.h.fRu().fRm()) && (c.a(c.this) != null)) {
            c.a(c.this).fQZ();
          }
          AppMethodBeat.o(303660);
          return true;
        }
      }, true);
    }
    this.timer.startTimer(1000L);
    AppMethodBeat.o(25323);
  }
  
  private void removeListener()
  {
    AppMethodBeat.i(25295);
    if (this.JFz != null)
    {
      TelephonyManager localTelephonyManager = this.JFz;
      Object localObject = this.swG;
      localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/ipcall/IPCallManager", "removeListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localTelephonyManager, "com/tencent/mm/plugin/ipcall/IPCallManager", "removeListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      this.JFz = null;
    }
    this.JFB.dead();
    this.viz.dead();
    AppMethodBeat.o(25295);
  }
  
  public final void Za(int paramInt)
  {
    AppMethodBeat.i(25315);
    Log.i("MicroMsg.IPCallManager", "onChannelConnectFailed, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Ze(com.tencent.mm.plugin.ipcall.model.h.fRu().sEu) });
    if (com.tencent.mm.plugin.ipcall.model.h.fRr().JHU)
    {
      Log.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel already connected");
      if (jx(5, paramInt))
      {
        f(5, null, MMApplicationContext.getContext().getString(R.l.gvY), 1);
        AppMethodBeat.o(25315);
      }
    }
    else
    {
      Log.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel not connet, may be request connect failed");
      if (jx(4, paramInt)) {
        f(4, null, MMApplicationContext.getContext().getString(R.l.gvY), 1);
      }
    }
    AppMethodBeat.o(25315);
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25296);
    if (com.tencent.mm.plugin.ipcall.model.h.fRu().fRj())
    {
      Log.i("MicroMsg.IPCallManager", "startIPCall, already start!");
      AppMethodBeat.o(25296);
      return false;
    }
    Log.i("MicroMsg.IPCallManager", "startIPCall");
    com.tencent.mm.plugin.ipcall.model.h.fRq().JGe = this;
    com.tencent.mm.plugin.ipcall.model.h.fRr().JHW = this;
    com.tencent.mm.plugin.ipcall.model.h.fRu().sEu = -1;
    removeListener();
    this.JFz = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
    Object localObject1 = this.JFz;
    Object localObject2 = this.swG;
    localObject2 = com.tencent.mm.hellhoundlib.b.c.a(32, new com.tencent.mm.hellhoundlib.b.a()).cG(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/ipcall/IPCallManager", "addListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/ipcall/IPCallManager", "addListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    this.JFB.alive();
    this.viz.alive();
    Log.d("MicroMsg.IPCallRecordStorageLogic", "recordStartCall, phoneNumber: %s, contactId: %s", new Object[] { paramString4, paramString5 });
    localObject1 = new com.tencent.mm.plugin.ipcall.model.h.k();
    ((com.tencent.mm.plugin.ipcall.model.h.k)localObject1).field_phonenumber = paramString4;
    if (!Util.isNullOrNil(paramString5))
    {
      localObject2 = com.tencent.mm.plugin.ipcall.model.h.fRw().aIW(paramString5);
      if ((localObject2 != null) && (((com.tencent.mm.plugin.ipcall.model.h.c)localObject2).systemRowid != -1L))
      {
        ((com.tencent.mm.plugin.ipcall.model.h.k)localObject1).field_addressId = ((com.tencent.mm.plugin.ipcall.model.h.c)localObject2).systemRowid;
        if (paramInt1 == -1) {
          break label963;
        }
        ((com.tencent.mm.plugin.ipcall.model.h.k)localObject1).field_phoneType = paramInt1;
        label299:
        ((com.tencent.mm.plugin.ipcall.model.h.k)localObject1).field_calltime = Util.nowMilliSecond();
        ((com.tencent.mm.plugin.ipcall.model.h.k)localObject1).field_status = 1;
        if (!com.tencent.mm.plugin.ipcall.model.h.fRx().insert((IAutoDBItem)localObject1)) {
          break label972;
        }
        label324:
        this.JFx = ((com.tencent.mm.plugin.ipcall.model.h.k)localObject1);
        mRi.postDelayed(this.JFD, 1754L);
        this.JFy = false;
        localObject1 = com.tencent.mm.plugin.ipcall.model.h.fRs();
        Log.d("MicroMsg.IPCallReportHelper", "reset");
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JHY = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JHZ = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JIa = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JIb = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JIc = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JId = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JIe = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JIf = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JIg = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JIh = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).roomId = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).Hnt = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JIi = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).pWt = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JIj = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JIk = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JIm = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JIl = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JFG = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JIn = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JIo = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JIt = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JIs = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JIp = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JIq = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).countryCode = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JIu = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JIv = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JIw = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JIx = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).JIy = 0;
        com.tencent.mm.plugin.ipcall.model.h.fRu().sEu = -1;
        Log.d("MicroMsg.IPCallManager", "startIPCall, username: %s, phoneNumber: %s", new Object[] { paramString3, paramString4 });
        localObject1 = com.tencent.mm.plugin.ipcall.model.h.fRq();
        Log.d("MicroMsg.IPCallSvrLogic", "startIPCall, toUsername: %s, toPhoneNumber: %s", new Object[] { paramString3, paramString4 });
        ((g)localObject1).hWt = false;
        ((g)localObject1).JGo = false;
        ((g)localObject1).JFZ = 0;
        ((g)localObject1).JGa = 0;
        ((g)localObject1).JGb = 0;
        ((g)localObject1).JGc = false;
        ((g)localObject1).JGd = false;
        ((g)localObject1).JGp = false;
        ((g)localObject1).JGn = new com.tencent.mm.plugin.ipcall.model.b.c();
        ((g)localObject1).JGn.nickname = paramString1;
        ((g)localObject1).JGn.JHu = paramString2;
        ((g)localObject1).JGn.idl = paramString5;
        ((g)localObject1).JGn.JHv = paramString4;
        ((g)localObject1).JGn.hgl = paramString3;
        ((g)localObject1).JGn.JGW = ((int)System.currentTimeMillis());
        ((g)localObject1).JGn.JGX = paramInt2;
        ((g)localObject1).JGn.JGY = paramInt3;
        ((g)localObject1).JGn.phoneType = paramInt1;
        ((g)localObject1).JGf.a(((g)localObject1).JGn);
        ((g)localObject1).JGk.a(((g)localObject1).JGn);
        Log.i("MicroMsg.IPCallSvrLogic", "startIPCallInternal, inviteId: %d", new Object[] { Integer.valueOf(((g)localObject1).JGn.JGW) });
        com.tencent.mm.plugin.ipcall.model.h.fRu().Zc(1);
        paramString1 = com.tencent.mm.plugin.ipcall.model.h.fRr();
        if (!paramString1.JHV) {
          break label978;
        }
        Log.d("MicroMsg.IPCallEngineManager", "already start engine");
      }
    }
    for (;;)
    {
      mRi.removeCallbacks(this.JFC);
      mRi.postDelayed(this.JFC, 60000L);
      Log.printInfoStack("MicroMsg.IPCallManager", "bindIPCallForegroundIfNeed", new Object[0]);
      if ((com.tencent.mm.compatible.util.d.rb(26)) && (!this.JFA))
      {
        paramString1 = new Intent();
        paramString1.setClass(MMApplicationContext.getContext(), IPCallForegroundService.class);
      }
      try
      {
        MMApplicationContext.getContext().startService(paramString1);
        paramInt1 = 1;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          long l;
          Log.printErrStackTrace("MicroMsg.IPCallManager", paramString2, "using start service to bindIPCallForegroundIfNeed error: %s", new Object[] { paramString2.getMessage() });
          try
          {
            MMApplicationContext.getContext().startForegroundService(paramString1);
            paramInt1 = 0;
          }
          catch (Exception paramString1)
          {
            Log.printErrStackTrace("MicroMsg.IPCallManager", paramString1, "using start foreground service to bindIPCallForegroundIfNeed error: %s", new Object[] { paramString1.getMessage() });
            paramInt1 = 0;
          }
        }
      }
      if (paramInt1 != 0) {
        this.JFA = true;
      }
      AppMethodBeat.o(25296);
      return true;
      ((com.tencent.mm.plugin.ipcall.model.h.k)localObject1).field_addressId = -1L;
      break;
      ((com.tencent.mm.plugin.ipcall.model.h.k)localObject1).field_addressId = -1L;
      break;
      label963:
      ((com.tencent.mm.plugin.ipcall.model.h.k)localObject1).field_phoneType = -1;
      break label299;
      label972:
      localObject1 = null;
      break label324;
      label978:
      paramString1.resetStatus();
      Log.i("MicroMsg.IPCallEngineManager", "start engine");
      if (paramString1.JHR.hZm())
      {
        paramString1.JHR.Gw(false);
        paramString1.JHR.reset();
      }
      paramString1.JHR.UDt = 1;
      l = System.currentTimeMillis();
      paramInt1 = paramString1.JHR.hZo();
      Log.d("MicroMsg.IPCallEngineManager", "protocal init finish, ret: %d, used %dms", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() - l) });
      if ((paramString1.JHR.field_capInfo != null) && (paramString1.JHR.exchangeCabInfo(paramString1.JHR.field_capInfo, paramString1.JHR.field_capInfo.length) < 0))
      {
        Log.e("MicroMsg.IPCallEngineManager", "exchangeCabInfo failed");
        com.tencent.mm.plugin.ipcall.model.h.fRs().JIh = 24;
      }
      if (paramInt1 < 0) {
        Log.e("MicroMsg.IPCallEngineManager", "engine init failed!");
      }
      paramString1.JHR.UDt = 1;
      paramString1.JHV = true;
    }
  }
  
  public final void ai(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(25300);
    Log.i("MicroMsg.IPCallManager", "onInviteFailed, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Ze(com.tencent.mm.plugin.ipcall.model.h.fRu().sEu) });
    if (jx(2, 0)) {
      f(2, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(25300);
  }
  
  public final void aj(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(25309);
    Log.i("MicroMsg.IPCallManager", "onAccountOverdue, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Ze(com.tencent.mm.plugin.ipcall.model.h.fRu().sEu) });
    if (jx(8, 9)) {
      f(8, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(25309);
  }
  
  public final void ak(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(25310);
    Log.i("MicroMsg.IPCallManager", "onCallRestricted, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Ze(com.tencent.mm.plugin.ipcall.model.h.fRu().sEu) });
    if (jx(10, 0)) {
      f(10, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(25310);
  }
  
  public final void al(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(25311);
    Log.i("MicroMsg.IPCallManager", "onCallPhoneNumberInvalid, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Ze(com.tencent.mm.plugin.ipcall.model.h.fRu().sEu) });
    if (jx(11, 0)) {
      f(11, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(25311);
  }
  
  public final void f(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(25303);
    if (this.JFw != null)
    {
      this.JFw.f(paramInt1, paramString1, paramString2, paramInt2);
      AppMethodBeat.o(25303);
      return;
    }
    Toast.makeText(MMApplicationContext.getContext(), paramString2, 1).show();
    AppMethodBeat.o(25303);
  }
  
  public final void fH(String paramString, int paramInt)
  {
    AppMethodBeat.i(25304);
    Log.i("MicroMsg.IPCallManager", "onUnAvaliable, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Ze(com.tencent.mm.plugin.ipcall.model.h.fRu().sEu) });
    if (jx(3, 5)) {
      f(3, null, paramString, paramInt);
    }
    AppMethodBeat.o(25304);
  }
  
  public final void fI(String paramString, int paramInt)
  {
    AppMethodBeat.i(25305);
    Log.i("MicroMsg.IPCallManager", "onBusy, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Ze(com.tencent.mm.plugin.ipcall.model.h.fRu().sEu) });
    if (jx(1, 4)) {
      f(1, null, paramString, paramInt);
    }
    AppMethodBeat.o(25305);
  }
  
  public final void fJ(String paramString, int paramInt)
  {
    AppMethodBeat.i(25307);
    Log.i("MicroMsg.IPCallManager", "onSyncFailed");
    if (jx(7, 35)) {
      f(7, null, paramString, paramInt);
    }
    AppMethodBeat.o(25307);
  }
  
  public final void fQG()
  {
    AppMethodBeat.i(25299);
    Log.i("MicroMsg.IPCallManager", "onInviteSuccess");
    if (!com.tencent.mm.plugin.ipcall.model.h.fRu().Zc(3))
    {
      AppMethodBeat.o(25299);
      return;
    }
    Object localObject = com.tencent.mm.plugin.ipcall.model.h.fRs();
    Log.d("MicroMsg.IPCallReportHelper", "markStartInvite");
    if (((com.tencent.mm.plugin.ipcall.model.d.b)localObject).JIl == 0L) {
      ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).JIl = System.currentTimeMillis();
    }
    localObject = com.tencent.mm.plugin.ipcall.model.h.fRq().JGn;
    com.tencent.mm.plugin.ipcall.model.d.b localb = com.tencent.mm.plugin.ipcall.model.h.fRs();
    int i = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).JGW;
    String str1 = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).hgl;
    String str2 = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).JHv;
    int j = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).roomId;
    long l1 = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).Hnt;
    long l2 = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).JGV;
    localb.JGW = i;
    localb.JIk = str1;
    localb.pWt = str2;
    localb.roomId = j;
    localb.Hnt = l1;
    localb.JIi = l2;
    if (this.JFw != null) {
      this.JFw.fQG();
    }
    AppMethodBeat.o(25299);
  }
  
  public final void fQH()
  {
    AppMethodBeat.i(25301);
    Log.i("MicroMsg.IPCallManager", "onStartRing, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Ze(com.tencent.mm.plugin.ipcall.model.h.fRu().sEu) });
    if (!com.tencent.mm.plugin.ipcall.model.h.fRu().Zc(4))
    {
      AppMethodBeat.o(25301);
      return;
    }
    com.tencent.mm.plugin.ipcall.model.d.b localb = com.tencent.mm.plugin.ipcall.model.h.fRs();
    Log.d("MicroMsg.IPCallReportHelper", "markStartRing");
    if (localb.JIm == 0L)
    {
      localb.JIm = System.currentTimeMillis();
      localb.JId = (localb.JIm - localb.JIl);
      Log.d("MicroMsg.IPCallReportHelper", "ringTime: %d", new Object[] { Long.valueOf(localb.JId) });
    }
    com.tencent.mm.plugin.ipcall.model.h.fRr().fRL();
    localb = com.tencent.mm.plugin.ipcall.model.h.fRs();
    Log.i("MicroMsg.IPCallReportHelper", "startRing");
    localb.JHY = 1;
    if (this.JFw != null) {
      this.JFw.fQH();
    }
    AppMethodBeat.o(25301);
  }
  
  public final void fQI()
  {
    AppMethodBeat.i(25306);
    Log.i("MicroMsg.IPCallManager", "onShutdownByOtherSide, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Ze(com.tencent.mm.plugin.ipcall.model.h.fRu().sEu) });
    if (aN(10, 0, 32))
    {
      if (this.JFw != null)
      {
        this.JFw.fQX();
        AppMethodBeat.o(25306);
        return;
      }
      Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.l.gLc), 1).show();
    }
    AppMethodBeat.o(25306);
  }
  
  public final void fQJ()
  {
    AppMethodBeat.i(25308);
    Log.i("MicroMsg.IPCallManager", "onHeartbeatFailed");
    if (jx(7, 29)) {
      f(7, null, MMApplicationContext.getContext().getString(R.l.gvY), 1);
    }
    AppMethodBeat.o(25308);
  }
  
  public final void fQK()
  {
    AppMethodBeat.i(25312);
    do
    {
      Log.i("MicroMsg.IPCallManager", "onDisasterHappen, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Ze(com.tencent.mm.plugin.ipcall.model.h.fRu().sEu) });
    } while (jx(12, 0));
    AppMethodBeat.o(25312);
  }
  
  public final void fQL()
  {
    AppMethodBeat.i(25313);
    Log.i("MicroMsg.IPCallManager", "onStartEngineFailed, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Ze(com.tencent.mm.plugin.ipcall.model.h.fRu().sEu) });
    if (jx(6, 0)) {
      f(6, null, MMApplicationContext.getContext().getString(R.l.gwb), 1);
    }
    AppMethodBeat.o(25313);
  }
  
  public final void fQM()
  {
    AppMethodBeat.i(25314);
    Log.i("MicroMsg.IPCallManager", "onChannelConnected, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Ze(com.tencent.mm.plugin.ipcall.model.h.fRu().sEu) });
    com.tencent.mm.plugin.ipcall.model.h.fRA().stop();
    mRi.removeCallbacks(this.JFD);
    Object localObject1;
    Object localObject2;
    if (com.tencent.mm.plugin.ipcall.model.h.fRu().fRk())
    {
      localObject1 = com.tencent.mm.plugin.ipcall.model.h.fRt();
      ((com.tencent.mm.plugin.ipcall.model.c.b)localObject1).JHB.b("ipcall", Integer.valueOf(4));
      Log.d("MicroMsg.IPCallDeviceManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.ipcall.model.a.a.Fa(3)), Boolean.valueOf(com.tencent.mm.plugin.ipcall.model.a.a.Fa(4)) });
      localObject1 = ((com.tencent.mm.plugin.ipcall.model.c.b)localObject1).JHB;
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).JGP;
      if (localObject2 != null)
      {
        if (!((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).isStart) {
          break label345;
        }
        Log.d("MicroMsg.IPCallAudioPlayer", "startPlay, already start");
      }
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).JGO;
      if (localObject2 != null)
      {
        if (((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).cTS() != 3) {
          break label452;
        }
        bool = true;
        label156:
        ((a.b)localObject2).xH(bool);
      }
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).JGO;
      if (localObject2 != null) {
        if (((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).cTS() != 4) {
          break label457;
        }
      }
    }
    label452:
    label457:
    for (boolean bool = true;; bool = false)
    {
      ((a.b)localObject2).xI(bool);
      com.tencent.mm.plugin.ipcall.model.h.fRs().fRO();
      com.tencent.mm.plugin.ipcall.model.h.fRt().JHB.dpe();
      if ((com.tencent.mm.plugin.ipcall.model.h.fRu().fRm()) && (!this.JFy))
      {
        com.tencent.mm.plugin.ipcall.model.h.fRs().fRR();
        com.tencent.mm.plugin.ipcall.model.h.fRr().fRK();
        this.JFy = true;
        this.JFG = Util.nowSecond();
        bYv();
        if (this.JFw != null) {
          this.JFw.fQW();
        }
        localObject1 = this.JFx;
        if (localObject1 != null)
        {
          Log.d("MicroMsg.IPCallRecordStorageLogic", "recordStartTalk, localId: %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.ipcall.model.h.k)localObject1).systemRowid) });
          if (((com.tencent.mm.plugin.ipcall.model.h.k)localObject1).systemRowid != -1L)
          {
            ((com.tencent.mm.plugin.ipcall.model.h.k)localObject1).field_status = 3;
            com.tencent.mm.plugin.ipcall.model.h.fRx().a((com.tencent.mm.plugin.ipcall.model.h.k)localObject1);
          }
        }
        com.tencent.mm.plugin.ipcall.model.h.fRs().fRQ();
        r.hXJ().hXK();
        r.hXJ().a(this);
      }
      AppMethodBeat.o(25314);
      return;
      label345:
      Log.i("MicroMsg.IPCallAudioPlayer", "startPlay");
      if (((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).wTy == null)
      {
        ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).wTy = new com.tencent.mm.plugin.voip.model.c();
        ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).wTy.ac(v2protocal.VOICE_SAMPLERATE, 1, 20, 1);
      }
      ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).JHz = ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).wTy.R(MMApplicationContext.getContext(), false);
      ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).wTy.UvX = new a.1((com.tencent.mm.plugin.ipcall.model.c.a)localObject2);
      if (((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).wTy.hVD() <= 0) {
        com.tencent.mm.plugin.ipcall.model.h.fRs().fRP();
      }
      ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).JHB.ee(((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).JHA);
      ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).isStart = true;
      break;
      bool = false;
      break label156;
    }
  }
  
  public final void fQN() {}
  
  public final void fQO()
  {
    AppMethodBeat.i(25318);
    if (com.tencent.mm.plugin.ipcall.model.h.fRu().sEu != 5)
    {
      Log.i("MicroMsg.IPCallManager", "onResumeGoodNetStatus currentState != accept:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.ipcall.model.h.fRu().sEu) });
      AppMethodBeat.o(25318);
      return;
    }
    com.tencent.mm.plugin.ipcall.model.c.b localb = com.tencent.mm.plugin.ipcall.model.h.fRt();
    Log.i("MicroMsg.IPCallDeviceManager", "onResumeGoodNetStatus");
    if (localb.JHF != null) {
      localb.JHF.fww();
    }
    AppMethodBeat.o(25318);
  }
  
  public final void fQP()
  {
    AppMethodBeat.i(25319);
    synchronized (this.Acn)
    {
      if (com.tencent.mm.plugin.ipcall.model.h.fRu().fRj())
      {
        if (this.JFE)
        {
          fQQ();
          AppMethodBeat.o(25319);
          return;
        }
        this.JFE = true;
        Toast.makeText(MMApplicationContext.getContext(), R.l.multitalk_mini_toast, 0).show();
        Intent localIntent = new Intent();
        localIntent.setFlags(268435456);
        localIntent.setClass(MMApplicationContext.getContext(), IPCallTalkUI.class);
        localIntent.putExtra("IPCallTalkUI_isFromMiniNotification", true);
        SubCoreVoip.hVq().a(localIntent, false, this.JFF);
        fQQ();
        if (this.JFw != null) {
          this.JFw.fQY();
        }
      }
      AppMethodBeat.o(25319);
      return;
    }
  }
  
  public final void fQQ()
  {
    AppMethodBeat.i(25320);
    if (com.tencent.mm.compatible.util.d.rc(26)) {
      if (!com.tencent.mm.plugin.ipcall.model.h.fRu().fRm()) {
        break label249;
      }
    }
    label249:
    for (Object localObject1 = MMApplicationContext.getContext().getString(R.l.gKz, new Object[] { String.format("%02d:%02d", new Object[] { Long.valueOf(Util.secondsToNow(this.JFG) / 60L), Long.valueOf(Util.secondsToNow(this.JFG) % 60L) }) });; localObject1 = MMApplicationContext.getContext().getString(R.l.gKy))
    {
      Object localObject2 = new Intent(MMApplicationContext.getContext(), IPCallTalkUI.class);
      ((Intent)localObject2).putExtra("IPCallTalkUI_isFromMiniNotification", true);
      localObject2 = PendingIntent.getActivity(MMApplicationContext.getContext(), 42, (Intent)localObject2, 134217728);
      int i = R.g.notification_icon_gray;
      if (com.tencent.mm.compatible.util.d.rc(19)) {
        i = R.g.notification_icon;
      }
      localObject1 = com.tencent.mm.bq.a.cA(MMApplicationContext.getContext(), "reminder_channel_id").o(MMApplicationContext.getContext().getString(R.l.gKy)).bt(System.currentTimeMillis()).l(MMApplicationContext.getContext().getString(R.l.ip_call_func_name)).m((CharSequence)localObject1);
      ((f.d)localObject1).bor = ((PendingIntent)localObject2);
      localObject1 = ((f.d)localObject1).DA();
      ((Notification)localObject1).icon = i;
      ((Notification)localObject1).flags |= 0x20;
      bh.getNotification().a(42, (Notification)localObject1, false);
      if (com.tencent.mm.plugin.ipcall.model.h.fRu().fRm()) {
        break;
      }
      SubCoreVoip.hVq().updateText(MMApplicationContext.getContext().getString(R.l.multitalk_waiting_wording));
      AppMethodBeat.o(25320);
      return;
    }
    SubCoreVoip.hVq().Bh(fQR());
    AppMethodBeat.o(25320);
  }
  
  public final int fQR()
  {
    AppMethodBeat.i(25322);
    int i = (int)Util.secondsToNow(this.JFG);
    if (i > 0)
    {
      AppMethodBeat.o(25322);
      return i;
    }
    AppMethodBeat.o(25322);
    return 0;
  }
  
  public final void fwj()
  {
    AppMethodBeat.i(25302);
    Log.i("MicroMsg.IPCallManager", "onAccept, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Ze(com.tencent.mm.plugin.ipcall.model.h.fRu().sEu) });
    if (!com.tencent.mm.plugin.ipcall.model.h.fRu().Zc(5))
    {
      AppMethodBeat.o(25302);
      return;
    }
    com.tencent.mm.plugin.ipcall.model.d.b localb = com.tencent.mm.plugin.ipcall.model.h.fRs();
    Log.d("MicroMsg.IPCallReportHelper", "markUserAccept");
    if (localb.JFG == 0L)
    {
      localb.JFG = System.currentTimeMillis();
      localb.JIe = (localb.JFG - localb.JIl);
      Log.d("MicroMsg.IPCallReportHelper", "answerTime: %d", new Object[] { Long.valueOf(localb.JIe) });
    }
    com.tencent.mm.plugin.ipcall.model.h.fRr().fRL();
    localb = com.tencent.mm.plugin.ipcall.model.h.fRs();
    Log.i("MicroMsg.IPCallReportHelper", "userAccept");
    localb.JHZ = 1;
    mRi.removeCallbacks(this.JFC);
    com.tencent.mm.plugin.ipcall.model.h.fRA().stop();
    mRi.removeCallbacks(this.JFD);
    com.tencent.mm.plugin.ipcall.model.h.fRt().JHB.dpe();
    if ((com.tencent.mm.plugin.ipcall.model.h.fRr().JHU) && (!this.JFy))
    {
      com.tencent.mm.plugin.ipcall.model.h.fRs().fRO();
      com.tencent.mm.plugin.ipcall.model.h.fRs().fRR();
      this.JFy = true;
      this.JFG = Util.nowSecond();
      bYv();
      com.tencent.mm.plugin.ipcall.model.h.fRr().fRK();
      if (this.JFw != null) {
        this.JFw.fQW();
      }
      com.tencent.mm.plugin.ipcall.model.h.fRs().fRQ();
      r.hXJ().hXK();
      r.hXJ().a(this);
    }
    AppMethodBeat.o(25302);
  }
  
  public final void fwx() {}
  
  public final boolean jx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(25316);
    if (com.tencent.mm.plugin.ipcall.model.h.fRu().fRm())
    {
      if (paramInt1 == 0)
      {
        bool = aN(9, paramInt1, paramInt2);
        AppMethodBeat.o(25316);
        return bool;
      }
      bool = aN(11, paramInt1, paramInt2);
      AppMethodBeat.o(25316);
      return bool;
    }
    if (paramInt1 == 0)
    {
      bool = aN(8, paramInt1, paramInt2);
      AppMethodBeat.o(25316);
      return bool;
    }
    boolean bool = aN(12, paramInt1, paramInt2);
    AppMethodBeat.o(25316);
    return bool;
  }
  
  public final void xy(boolean paramBoolean)
  {
    AppMethodBeat.i(25317);
    if (com.tencent.mm.plugin.ipcall.model.h.fRu().sEu != 5)
    {
      Log.i("MicroMsg.IPCallManager", "onBadNetStatus currentState != accept:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.ipcall.model.h.fRu().sEu) });
      AppMethodBeat.o(25317);
      return;
    }
    Object localObject = com.tencent.mm.plugin.ipcall.model.h.fRt();
    Log.i("MicroMsg.IPCallDeviceManager", "onBadNetStatus");
    if (((com.tencent.mm.plugin.ipcall.model.c.b)localObject).JHF != null)
    {
      i locali = ((com.tencent.mm.plugin.ipcall.model.c.b)localObject).JHF;
      if (locali.JQB != null) {
        locali.JQB.setVisibility(0);
      }
      if (locali.JQC != null) {
        locali.JQC.setVisibility(0);
      }
    }
    if (!((com.tencent.mm.plugin.ipcall.model.c.b)localObject).JHB.cTU())
    {
      long l = System.currentTimeMillis();
      if (l - ((com.tencent.mm.plugin.ipcall.model.c.b)localObject).JHG > 30000L)
      {
        ((com.tencent.mm.plugin.ipcall.model.c.b)localObject).JHG = l;
        localObject = SubCoreVoip.hVp();
        int i = R.k.close_lower_volume;
        localObject = ((u)localObject).UBE;
        if ((((v)localObject).wVi != null) && (i > 0)) {
          ((v)localObject).wVi.a(i, false, 0, false);
        }
      }
    }
    AppMethodBeat.o(25317);
  }
  
  public final void xz(boolean paramBoolean)
  {
    AppMethodBeat.i(185745);
    synchronized (this.Acn)
    {
      this.JFE = false;
      SubCoreVoip.hVq().jb(paramBoolean);
      ((NotificationManager)MMApplicationContext.getContext().getSystemService("notification")).cancel(42);
      AppMethodBeat.o(185745);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.c
 * JD-Core Version:    0.7.0.1
 */