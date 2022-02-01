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
import androidx.core.app.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.ipcall.model.IPCallForegroundService;
import com.tencent.mm.plugin.ipcall.model.a.a.b;
import com.tencent.mm.plugin.ipcall.model.c.a.1;
import com.tencent.mm.plugin.ipcall.model.d.a.a;
import com.tencent.mm.plugin.ipcall.model.g;
import com.tencent.mm.plugin.ipcall.model.g.a;
import com.tencent.mm.plugin.ipcall.model.h.l;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI;
import com.tencent.mm.plugin.ipcall.ui.j;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.r.a;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.ao;

public final class c
  implements a.a, g.a, r.a
{
  private static MMHandler knk;
  public e DOh;
  private com.tencent.mm.plugin.ipcall.model.h.k DOi;
  private boolean DOj;
  private TelephonyManager DOk;
  private boolean DOl;
  private IListener DOm;
  private Runnable DOn;
  private Runnable DOo;
  private boolean DOp;
  private com.tencent.mm.plugin.voip.ui.a DOq;
  private long DOr;
  private PhoneStateListener prS;
  private MTimerHandler timer;
  private Object wGe;
  
  static
  {
    AppMethodBeat.i(25324);
    knk = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(25324);
  }
  
  public c()
  {
    AppMethodBeat.i(25294);
    this.DOj = false;
    this.DOl = false;
    this.wGe = new Object();
    this.prS = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(25288);
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        Log.d("MicroMsg.IPCallManager", "onCallStateChanged ".concat(String.valueOf(paramAnonymousInt)));
        if (paramAnonymousInt == 2)
        {
          Log.i("MicroMsg.IPCallManager", "system phone call state offhook, stop call");
          c.this.hT(0, 0);
        }
        AppMethodBeat.o(25288);
      }
    };
    this.DOm = new c.2(this);
    this.DOn = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25289);
        if (!i.eJu().eJm())
        {
          Log.i("MicroMsg.IPCallManager", "timeout! still not accept!");
          if (c.this.hT(9, 12)) {
            c.this.g(9, null, MMApplicationContext.getContext().getString(R.l.etF), 2);
          }
        }
        AppMethodBeat.o(25289);
      }
    };
    this.DOo = new Runnable()
    {
      public final void run()
      {
        int i = 0;
        boolean bool3 = true;
        boolean bool2 = true;
        AppMethodBeat.i(25290);
        com.tencent.mm.plugin.voip.video.e locale = i.eJA();
        int j = R.k.ipcall_phonering;
        locale.NZT = 0;
        if (j == 0)
        {
          locale.Bp(true);
          AppMethodBeat.o(25290);
          return;
        }
        if (3500L != -1L) {}
        for (;;)
        {
          try
          {
            if (!MMApplicationContext.isMMProcess()) {
              break label313;
            }
            bool1 = ((Boolean)h.aHG().aHp().b(73218, Boolean.TRUE)).booleanValue();
            Log.e("MicroMsg.RingPlayer", "get voip sound failed: " + localException1.getMessage());
          }
          catch (Exception localException1)
          {
            for (;;)
            {
              try
              {
                Log.i("MicroMsg.RingPlayer", "startPlayCustomRingWithCustomInterval, voipSound: %s, msgSound: %s, isCallingParty: %s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(com.tencent.mm.n.b.awk()), Boolean.TRUE });
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
                locale.NZU = System.currentTimeMillis();
                locale.NZS = new com.tencent.mm.compatible.b.k();
                Log.d("MicroMsg.RingPlayer", "isBluetoothOn: %b, isHeadsetPlugged: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.cro()), Boolean.valueOf(com.tencent.mm.plugin.audio.c.a.crh()) });
                if (af.juI.jou >= 0) {
                  i = af.juI.jou;
                }
                locale.Bo(false);
                locale.a(j, 3500L, true, i);
                locale.isStarted = true;
                AppMethodBeat.o(25290);
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
          AppMethodBeat.o(25290);
          return;
          locale.L(j, 2, true);
          AppMethodBeat.o(25290);
          return;
          label313:
          boolean bool1 = true;
        }
      }
    };
    this.DOq = new com.tencent.mm.plugin.voip.ui.a()
    {
      public final void a(Intent paramAnonymousIntent, BaseSmallView paramAnonymousBaseSmallView)
      {
        AppMethodBeat.i(179650);
        if (!i.eJu().eJm())
        {
          paramAnonymousBaseSmallView.aQM(MMApplicationContext.getContext().getString(R.l.multitalk_waiting_wording));
          AppMethodBeat.o(179650);
          return;
        }
        int i = c.this.eIS();
        paramAnonymousBaseSmallView.aQN(String.format("%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
        AppMethodBeat.o(179650);
      }
      
      public final boolean eIT()
      {
        AppMethodBeat.i(25291);
        if (i.eJu().eJj())
        {
          AppMethodBeat.o(25291);
          return true;
        }
        AppMethodBeat.o(25291);
        return false;
      }
    };
    this.DOr = 0L;
    AppMethodBeat.o(25294);
  }
  
  public static boolean aLX(String paramString)
  {
    AppMethodBeat.i(25298);
    Log.d("MicroMsg.IPCallManager", "dialWhenTalking, dialButton: %s", new Object[] { paramString });
    if (!i.eJu().eJm())
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
        paramString = i.eJr();
        Log.d("MicroMsg.IPCallEngineManager", "sendDTMF: %d", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.ipcall.model.d.b localb = i.eJs();
        localb.DRo += 1;
        Log.i("MicroMsg.IPCallReportHelper", "now addCallClickCnt %d", new Object[] { Integer.valueOf(localb.DRo) });
        i = paramString.DQH.SendDTMF(i);
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
  private boolean aq(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: sipush 25297
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eJq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   9: getfield 210	com/tencent/mm/plugin/ipcall/model/g:DOY	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   12: astore 15
    //   14: invokestatic 124	com/tencent/mm/plugin/ipcall/model/i:eJu	()Lcom/tencent/mm/plugin/ipcall/model/f;
    //   17: iload_1
    //   18: invokevirtual 214	com/tencent/mm/plugin/ipcall/model/f:Vh	(I)Z
    //   21: ifne +93 -> 114
    //   24: ldc 110
    //   26: ldc 216
    //   28: iconst_1
    //   29: anewarray 4	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: invokestatic 124	com/tencent/mm/plugin/ipcall/model/i:eJu	()Lcom/tencent/mm/plugin/ipcall/model/f;
    //   37: getfield 219	com/tencent/mm/plugin/ipcall/model/f:pzp	I
    //   40: invokestatic 223	com/tencent/mm/plugin/ipcall/model/f:Vj	(I)Ljava/lang/String;
    //   43: aastore
    //   44: invokestatic 180	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: aload 15
    //   49: ifnull +57 -> 106
    //   52: ldc 110
    //   54: ldc 225
    //   56: iconst_5
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload 15
    //   64: getfield 230	com/tencent/mm/plugin/ipcall/model/b/c:DPL	I
    //   67: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: aload 15
    //   75: getfield 233	com/tencent/mm/plugin/ipcall/model/b/c:roomId	I
    //   78: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: aastore
    //   82: dup
    //   83: iconst_2
    //   84: iload_1
    //   85: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: aastore
    //   89: dup
    //   90: iconst_3
    //   91: iload_2
    //   92: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   95: aastore
    //   96: dup
    //   97: iconst_4
    //   98: iload_3
    //   99: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: invokestatic 180	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: sipush 25297
    //   109: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: iconst_0
    //   113: ireturn
    //   114: aload 15
    //   116: ifnull +57 -> 173
    //   119: ldc 110
    //   121: ldc 235
    //   123: iconst_5
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: aload 15
    //   131: getfield 230	com/tencent/mm/plugin/ipcall/model/b/c:DPL	I
    //   134: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: aastore
    //   138: dup
    //   139: iconst_1
    //   140: aload 15
    //   142: getfield 233	com/tencent/mm/plugin/ipcall/model/b/c:roomId	I
    //   145: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: aastore
    //   149: dup
    //   150: iconst_2
    //   151: iload_1
    //   152: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   155: aastore
    //   156: dup
    //   157: iconst_3
    //   158: iload_2
    //   159: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: aastore
    //   163: dup
    //   164: iconst_4
    //   165: iload_3
    //   166: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   169: aastore
    //   170: invokestatic 180	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: invokestatic 239	com/tencent/mm/plugin/ipcall/model/i:eJA	()Lcom/tencent/mm/plugin/voip/video/e;
    //   176: invokevirtual 244	com/tencent/mm/plugin/voip/video/e:stop	()V
    //   179: invokestatic 239	com/tencent/mm/plugin/ipcall/model/i:eJA	()Lcom/tencent/mm/plugin/voip/video/e;
    //   182: astore 15
    //   184: getstatic 249	com/tencent/mm/R$k:close_lower_volume	I
    //   187: istore 5
    //   189: invokestatic 253	com/tencent/mm/plugin/ipcall/model/i:eJt	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   192: getfield 259	com/tencent/mm/plugin/ipcall/model/c/b:DQq	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   195: invokevirtual 264	com/tencent/mm/plugin/ipcall/model/a/a:crl	()Z
    //   198: istore 8
    //   200: aload 15
    //   202: getfield 268	com/tencent/mm/plugin/voip/video/e:mContext	Landroid/content/Context;
    //   205: invokestatic 274	com/tencent/mm/sdk/platformtools/MMApplicationContext:getDefaultPreferencePath	()Ljava/lang/String;
    //   208: iconst_0
    //   209: invokevirtual 280	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   212: ldc_w 282
    //   215: iconst_1
    //   216: invokeinterface 288 3 0
    //   221: pop
    //   222: ldc_w 290
    //   225: invokestatic 296	com/tencent/mm/plugin/audio/c/a:anV	(Ljava/lang/String;)Lcom/tencent/mm/plugin/audio/b/a;
    //   228: iload 8
    //   230: invokevirtual 302	com/tencent/mm/plugin/audio/b/a:ds	(Z)V
    //   233: iload 8
    //   235: ifeq +1480 -> 1715
    //   238: iconst_0
    //   239: invokestatic 305	com/tencent/mm/plugin/audio/c/a:setMode	(I)V
    //   242: ldc_w 307
    //   245: ldc_w 309
    //   248: iconst_3
    //   249: anewarray 4	java/lang/Object
    //   252: dup
    //   253: iconst_0
    //   254: getstatic 315	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   257: aastore
    //   258: dup
    //   259: iconst_1
    //   260: iload 8
    //   262: invokestatic 318	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   265: aastore
    //   266: dup
    //   267: iconst_2
    //   268: iconst_2
    //   269: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   272: aastore
    //   273: invokestatic 180	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   276: aload 15
    //   278: invokestatic 324	java/lang/System:currentTimeMillis	()J
    //   281: putfield 327	com/tencent/mm/plugin/voip/video/e:NZV	J
    //   284: new 329	com/tencent/mm/compatible/b/k
    //   287: dup
    //   288: invokespecial 330	com/tencent/mm/compatible/b/k:<init>	()V
    //   291: astore 16
    //   293: aload 16
    //   295: aload 15
    //   297: getfield 268	com/tencent/mm/plugin/voip/video/e:mContext	Landroid/content/Context;
    //   300: new 332	java/lang/StringBuilder
    //   303: dup
    //   304: ldc_w 334
    //   307: invokespecial 337	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   310: aload 15
    //   312: getfield 268	com/tencent/mm/plugin/voip/video/e:mContext	Landroid/content/Context;
    //   315: invokevirtual 340	android/content/Context:getPackageName	()Ljava/lang/String;
    //   318: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: ldc_w 346
    //   324: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   327: iload 5
    //   329: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   332: invokevirtual 352	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   335: invokestatic 358	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   338: invokevirtual 364	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   341: aload 16
    //   343: new 366	com/tencent/mm/plugin/voip/video/e$7
    //   346: dup
    //   347: aload 15
    //   349: invokespecial 369	com/tencent/mm/plugin/voip/video/e$7:<init>	(Lcom/tencent/mm/plugin/voip/video/e;)V
    //   352: invokevirtual 373	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   355: aload 16
    //   357: new 375	com/tencent/mm/plugin/voip/video/e$8
    //   360: dup
    //   361: aload 15
    //   363: invokespecial 376	com/tencent/mm/plugin/voip/video/e$8:<init>	(Lcom/tencent/mm/plugin/voip/video/e;)V
    //   366: invokevirtual 380	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   369: invokestatic 383	com/tencent/mm/plugin/audio/c/a:cro	()Z
    //   372: ifne +1992 -> 2364
    //   375: iload 8
    //   377: ifne +1345 -> 1722
    //   380: goto +1984 -> 2364
    //   383: aload 16
    //   385: iload 5
    //   387: invokevirtual 386	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   390: aload 16
    //   392: invokevirtual 389	android/media/MediaPlayer:prepare	()V
    //   395: aload 16
    //   397: iconst_0
    //   398: invokevirtual 392	android/media/MediaPlayer:setLooping	(Z)V
    //   401: aload 16
    //   403: invokevirtual 395	android/media/MediaPlayer:start	()V
    //   406: invokestatic 324	java/lang/System:currentTimeMillis	()J
    //   409: aload 15
    //   411: getfield 327	com/tencent/mm/plugin/voip/video/e:NZV	J
    //   414: lsub
    //   415: ldc2_w 396
    //   418: lcmp
    //   419: ifle +10 -> 429
    //   422: aload 15
    //   424: bipush 7
    //   426: putfield 400	com/tencent/mm/plugin/voip/video/e:NZT	I
    //   429: ldc 110
    //   431: ldc_w 402
    //   434: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   437: invokestatic 408	com/tencent/mm/plugin/voip/model/r:gzC	()Lcom/tencent/mm/plugin/voip/model/r;
    //   440: invokevirtual 411	com/tencent/mm/plugin/voip/model/r:gzE	()V
    //   443: invokestatic 408	com/tencent/mm/plugin/voip/model/r:gzC	()Lcom/tencent/mm/plugin/voip/model/r;
    //   446: aconst_null
    //   447: invokevirtual 414	com/tencent/mm/plugin/voip/model/r:a	(Lcom/tencent/mm/plugin/voip/model/r$a;)V
    //   450: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eJs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   453: astore 15
    //   455: invokestatic 253	com/tencent/mm/plugin/ipcall/model/i:eJt	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   458: getfield 259	com/tencent/mm/plugin/ipcall/model/c/b:DQq	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   461: getfield 418	com/tencent/mm/plugin/ipcall/model/a/a:DPD	Lcom/tencent/mm/plugin/ipcall/model/c/c;
    //   464: astore 16
    //   466: aload 16
    //   468: ifnull +1306 -> 1774
    //   471: aload 16
    //   473: getfield 424	com/tencent/mm/plugin/ipcall/model/c/c:DQw	Lcom/tencent/mm/audio/b/c;
    //   476: ifnull +1292 -> 1768
    //   479: aload 16
    //   481: getfield 424	com/tencent/mm/plugin/ipcall/model/c/c:DQw	Lcom/tencent/mm/audio/b/c;
    //   484: getfield 429	com/tencent/mm/audio/b/c:frO	I
    //   487: istore 5
    //   489: aload 15
    //   491: getfield 432	com/tencent/mm/plugin/ipcall/model/d/b:DRl	I
    //   494: ifne +10 -> 504
    //   497: aload 15
    //   499: iload 5
    //   501: putfield 432	com/tencent/mm/plugin/ipcall/model/d/b:DRl	I
    //   504: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eJs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   507: astore 15
    //   509: invokestatic 253	com/tencent/mm/plugin/ipcall/model/i:eJt	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   512: getfield 259	com/tencent/mm/plugin/ipcall/model/c/b:DQq	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   515: getfield 436	com/tencent/mm/plugin/ipcall/model/a/a:DPC	Lcom/tencent/mm/plugin/ipcall/model/c/a;
    //   518: astore 16
    //   520: aload 16
    //   522: ifnull +1264 -> 1786
    //   525: aload 16
    //   527: getfield 442	com/tencent/mm/plugin/ipcall/model/c/a:tQh	Lcom/tencent/mm/plugin/voip/model/c;
    //   530: ifnull +1250 -> 1780
    //   533: ldc_w 444
    //   536: new 332	java/lang/StringBuilder
    //   539: dup
    //   540: ldc_w 446
    //   543: invokespecial 337	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   546: aload 16
    //   548: getfield 442	com/tencent/mm/plugin/ipcall/model/c/a:tQh	Lcom/tencent/mm/plugin/voip/model/c;
    //   551: invokevirtual 451	com/tencent/mm/plugin/voip/model/c:gxE	()I
    //   554: invokevirtual 349	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   557: invokevirtual 352	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   560: invokestatic 453	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   563: aload 16
    //   565: getfield 442	com/tencent/mm/plugin/ipcall/model/c/a:tQh	Lcom/tencent/mm/plugin/voip/model/c;
    //   568: invokevirtual 451	com/tencent/mm/plugin/voip/model/c:gxE	()I
    //   571: istore 5
    //   573: aload 15
    //   575: getfield 456	com/tencent/mm/plugin/ipcall/model/d/b:DRm	I
    //   578: ifne +10 -> 588
    //   581: aload 15
    //   583: iload 5
    //   585: putfield 456	com/tencent/mm/plugin/ipcall/model/d/b:DRm	I
    //   588: invokestatic 253	com/tencent/mm/plugin/ipcall/model/i:eJt	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   591: astore 15
    //   593: invokestatic 154	com/tencent/mm/plugin/ipcall/model/i:eJr	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   596: astore 16
    //   598: aload 15
    //   600: getfield 259	com/tencent/mm/plugin/ipcall/model/c/b:DQq	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   603: astore 17
    //   605: aload 17
    //   607: getfield 436	com/tencent/mm/plugin/ipcall/model/a/a:DPC	Lcom/tencent/mm/plugin/ipcall/model/c/a;
    //   610: astore 18
    //   612: aload 18
    //   614: ifnull +1184 -> 1798
    //   617: aload 18
    //   619: getfield 442	com/tencent/mm/plugin/ipcall/model/c/a:tQh	Lcom/tencent/mm/plugin/voip/model/c;
    //   622: ifnull +1170 -> 1792
    //   625: aload 18
    //   627: getfield 459	com/tencent/mm/plugin/ipcall/model/c/a:isStart	Z
    //   630: ifeq +1162 -> 1792
    //   633: aload 18
    //   635: getfield 442	com/tencent/mm/plugin/ipcall/model/c/a:tQh	Lcom/tencent/mm/plugin/voip/model/c;
    //   638: invokevirtual 462	com/tencent/mm/plugin/voip/model/c:gxF	()I
    //   641: istore 5
    //   643: iload 5
    //   645: iconst_m1
    //   646: if_icmpne +1158 -> 1804
    //   649: iconst_0
    //   650: istore 5
    //   652: aload 16
    //   654: getfield 186	com/tencent/mm/plugin/ipcall/model/d/a:DQH	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   657: iload 5
    //   659: putfield 465	com/tencent/mm/plugin/voip/model/v2protocal:NRk	I
    //   662: aload 15
    //   664: aconst_null
    //   665: putfield 469	com/tencent/mm/plugin/ipcall/model/c/b:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   668: aload 15
    //   670: getfield 259	com/tencent/mm/plugin/ipcall/model/c/b:DQq	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   673: astore 17
    //   675: aload 17
    //   677: getfield 436	com/tencent/mm/plugin/ipcall/model/a/a:DPC	Lcom/tencent/mm/plugin/ipcall/model/c/a;
    //   680: astore 18
    //   682: aload 18
    //   684: ifnull +65 -> 749
    //   687: aload 18
    //   689: getfield 459	com/tencent/mm/plugin/ipcall/model/c/a:isStart	Z
    //   692: ifeq +57 -> 749
    //   695: ldc_w 444
    //   698: ldc_w 471
    //   701: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   704: aload 18
    //   706: getfield 474	com/tencent/mm/plugin/ipcall/model/c/a:DQn	Ljava/lang/Object;
    //   709: astore 16
    //   711: aload 16
    //   713: monitorenter
    //   714: new 476	com/tencent/mm/plugin/ipcall/model/c/a$a
    //   717: dup
    //   718: aload 18
    //   720: aload 18
    //   722: getfield 442	com/tencent/mm/plugin/ipcall/model/c/a:tQh	Lcom/tencent/mm/plugin/voip/model/c;
    //   725: invokespecial 479	com/tencent/mm/plugin/ipcall/model/c/a$a:<init>	(Lcom/tencent/mm/plugin/ipcall/model/c/a;Lcom/tencent/mm/plugin/voip/model/c;)V
    //   728: ldc_w 481
    //   731: invokestatic 487	com/tencent/mm/sdk/thread/ThreadPool:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   734: aload 18
    //   736: iconst_0
    //   737: putfield 459	com/tencent/mm/plugin/ipcall/model/c/a:isStart	Z
    //   740: aload 18
    //   742: aconst_null
    //   743: putfield 442	com/tencent/mm/plugin/ipcall/model/c/a:tQh	Lcom/tencent/mm/plugin/voip/model/c;
    //   746: aload 16
    //   748: monitorexit
    //   749: aload 17
    //   751: ldc_w 489
    //   754: invokevirtual 492	com/tencent/mm/plugin/ipcall/model/a/a:anT	(Ljava/lang/String;)V
    //   757: aload 17
    //   759: aconst_null
    //   760: putfield 496	com/tencent/mm/plugin/ipcall/model/a/a:DPB	Lcom/tencent/mm/plugin/ipcall/model/a/a$b;
    //   763: aload 17
    //   765: getfield 500	com/tencent/mm/plugin/ipcall/model/a/a:mlj	Lcom/tencent/mm/compatible/util/b;
    //   768: invokevirtual 505	com/tencent/mm/compatible/util/b:avz	()Z
    //   771: pop
    //   772: aload 15
    //   774: aconst_null
    //   775: putfield 509	com/tencent/mm/plugin/ipcall/model/c/b:DQu	Lcom/tencent/mm/plugin/ipcall/ui/j;
    //   778: invokestatic 253	com/tencent/mm/plugin/ipcall/model/i:eJt	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   781: astore 16
    //   783: aload 16
    //   785: getfield 259	com/tencent/mm/plugin/ipcall/model/c/b:DQq	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   788: getfield 418	com/tencent/mm/plugin/ipcall/model/a/a:DPD	Lcom/tencent/mm/plugin/ipcall/model/c/c;
    //   791: astore 17
    //   793: aload 17
    //   795: ifnull +79 -> 874
    //   798: aload 17
    //   800: getfield 510	com/tencent/mm/plugin/ipcall/model/c/c:isStart	Z
    //   803: ifeq +71 -> 874
    //   806: ldc_w 512
    //   809: ldc_w 514
    //   812: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   815: aload 17
    //   817: getfield 517	com/tencent/mm/plugin/ipcall/model/c/c:DQx	Ljava/lang/Object;
    //   820: astore 15
    //   822: aload 15
    //   824: monitorenter
    //   825: aload 17
    //   827: getfield 424	com/tencent/mm/plugin/ipcall/model/c/c:DQw	Lcom/tencent/mm/audio/b/c;
    //   830: ifnull +41 -> 871
    //   833: new 519	com/tencent/mm/plugin/ipcall/model/c/c$a
    //   836: dup
    //   837: aload 17
    //   839: aload 17
    //   841: getfield 424	com/tencent/mm/plugin/ipcall/model/c/c:DQw	Lcom/tencent/mm/audio/b/c;
    //   844: invokespecial 522	com/tencent/mm/plugin/ipcall/model/c/c$a:<init>	(Lcom/tencent/mm/plugin/ipcall/model/c/c;Lcom/tencent/mm/audio/b/c;)V
    //   847: ldc_w 524
    //   850: invokestatic 487	com/tencent/mm/sdk/thread/ThreadPool:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   853: aload 17
    //   855: aconst_null
    //   856: putfield 424	com/tencent/mm/plugin/ipcall/model/c/c:DQw	Lcom/tencent/mm/audio/b/c;
    //   859: aload 17
    //   861: iconst_0
    //   862: putfield 510	com/tencent/mm/plugin/ipcall/model/c/c:isStart	Z
    //   865: aload 17
    //   867: iconst_0
    //   868: putfield 527	com/tencent/mm/plugin/ipcall/model/c/c:iYs	Z
    //   871: aload 15
    //   873: monitorexit
    //   874: aload 16
    //   876: aconst_null
    //   877: putfield 469	com/tencent/mm/plugin/ipcall/model/c/b:iXq	Lcom/tencent/mm/ui/MMActivity;
    //   880: invokestatic 154	com/tencent/mm/plugin/ipcall/model/i:eJr	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   883: astore 15
    //   885: ldc 156
    //   887: ldc_w 529
    //   890: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   893: aload 15
    //   895: getfield 186	com/tencent/mm/plugin/ipcall/model/d/a:DQH	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   898: iconst_1
    //   899: invokevirtual 533	com/tencent/mm/plugin/voip/model/v2protocal:AZ	(Z)Ljava/lang/String;
    //   902: pop
    //   903: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eJs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   906: astore 16
    //   908: aload 16
    //   910: getfield 537	com/tencent/mm/plugin/ipcall/model/d/b:DRg	Ljava/lang/String;
    //   913: invokestatic 140	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   916: ifeq +279 -> 1195
    //   919: aload 16
    //   921: getfield 540	com/tencent/mm/plugin/ipcall/model/d/b:DRf	Ljava/lang/String;
    //   924: invokestatic 140	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   927: ifeq +268 -> 1195
    //   930: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eJq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   933: getfield 210	com/tencent/mm/plugin/ipcall/model/g:DOY	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   936: astore 18
    //   938: invokestatic 154	com/tencent/mm/plugin/ipcall/model/i:eJr	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   941: getfield 186	com/tencent/mm/plugin/ipcall/model/d/a:DQH	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   944: astore 17
    //   946: aload 16
    //   948: getfield 543	com/tencent/mm/plugin/ipcall/model/d/b:DQV	I
    //   951: iconst_1
    //   952: if_icmpne +911 -> 1863
    //   955: iconst_1
    //   956: istore 5
    //   958: aload 18
    //   960: getfield 546	com/tencent/mm/plugin/ipcall/model/b/c:DQe	I
    //   963: istore 6
    //   965: aload 17
    //   967: getfield 550	com/tencent/mm/plugin/voip/model/v2protocal:NSE	[B
    //   970: astore 18
    //   972: aload 17
    //   974: getfield 550	com/tencent/mm/plugin/voip/model/v2protocal:NSE	[B
    //   977: arraylength
    //   978: istore 7
    //   980: iload 5
    //   982: ifeq +887 -> 1869
    //   985: iconst_1
    //   986: istore 5
    //   988: aload 17
    //   990: aload 18
    //   992: iload 7
    //   994: iload 5
    //   996: iload 6
    //   998: invokevirtual 554	com/tencent/mm/plugin/voip/model/v2protocal:getPstnChannelInfo	([BIII)I
    //   1001: pop
    //   1002: ldc_w 556
    //   1005: ldc_w 558
    //   1008: iconst_1
    //   1009: anewarray 4	java/lang/Object
    //   1012: dup
    //   1013: iconst_0
    //   1014: aload 17
    //   1016: getfield 561	com/tencent/mm/plugin/voip/model/v2protocal:field_pstnChannelInfoLength	I
    //   1019: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1022: aastore
    //   1023: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1026: aload 16
    //   1028: new 142	java/lang/String
    //   1031: dup
    //   1032: aload 17
    //   1034: getfield 550	com/tencent/mm/plugin/voip/model/v2protocal:NSE	[B
    //   1037: iconst_0
    //   1038: aload 17
    //   1040: getfield 561	com/tencent/mm/plugin/voip/model/v2protocal:field_pstnChannelInfoLength	I
    //   1043: invokespecial 564	java/lang/String:<init>	([BII)V
    //   1046: putfield 537	com/tencent/mm/plugin/ipcall/model/d/b:DRg	Ljava/lang/String;
    //   1049: invokestatic 154	com/tencent/mm/plugin/ipcall/model/i:eJr	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   1052: getfield 186	com/tencent/mm/plugin/ipcall/model/d/a:DQH	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1055: astore 17
    //   1057: aload 17
    //   1059: aload 17
    //   1061: getfield 567	com/tencent/mm/plugin/voip/model/v2protocal:NSF	[B
    //   1064: aload 17
    //   1066: getfield 567	com/tencent/mm/plugin/voip/model/v2protocal:NSF	[B
    //   1069: arraylength
    //   1070: invokevirtual 571	com/tencent/mm/plugin/voip/model/v2protocal:getPstnEngineInfo	([BI)I
    //   1073: pop
    //   1074: ldc_w 556
    //   1077: ldc_w 573
    //   1080: iconst_1
    //   1081: anewarray 4	java/lang/Object
    //   1084: dup
    //   1085: iconst_0
    //   1086: aload 17
    //   1088: getfield 576	com/tencent/mm/plugin/voip/model/v2protocal:field_pstnEngineInfoLength	I
    //   1091: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1094: aastore
    //   1095: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1098: aload 16
    //   1100: new 142	java/lang/String
    //   1103: dup
    //   1104: aload 17
    //   1106: getfield 567	com/tencent/mm/plugin/voip/model/v2protocal:NSF	[B
    //   1109: iconst_0
    //   1110: aload 17
    //   1112: getfield 576	com/tencent/mm/plugin/voip/model/v2protocal:field_pstnEngineInfoLength	I
    //   1115: invokespecial 564	java/lang/String:<init>	([BII)V
    //   1118: putfield 540	com/tencent/mm/plugin/ipcall/model/d/b:DRf	Ljava/lang/String;
    //   1121: aload 16
    //   1123: invokestatic 154	com/tencent/mm/plugin/ipcall/model/i:eJr	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   1126: getfield 186	com/tencent/mm/plugin/ipcall/model/d/a:DQH	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1129: invokevirtual 579	com/tencent/mm/plugin/voip/model/v2protocal:gBn	()Ljava/lang/String;
    //   1132: putfield 582	com/tencent/mm/plugin/ipcall/model/d/b:DRh	Ljava/lang/String;
    //   1135: ldc 176
    //   1137: ldc_w 584
    //   1140: iconst_1
    //   1141: anewarray 4	java/lang/Object
    //   1144: dup
    //   1145: iconst_0
    //   1146: aload 16
    //   1148: getfield 537	com/tencent/mm/plugin/ipcall/model/d/b:DRg	Ljava/lang/String;
    //   1151: aastore
    //   1152: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1155: ldc 176
    //   1157: ldc_w 586
    //   1160: iconst_1
    //   1161: anewarray 4	java/lang/Object
    //   1164: dup
    //   1165: iconst_0
    //   1166: aload 16
    //   1168: getfield 540	com/tencent/mm/plugin/ipcall/model/d/b:DRf	Ljava/lang/String;
    //   1171: aastore
    //   1172: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1175: ldc 176
    //   1177: ldc_w 588
    //   1180: iconst_1
    //   1181: anewarray 4	java/lang/Object
    //   1184: dup
    //   1185: iconst_0
    //   1186: aload 16
    //   1188: getfield 582	com/tencent/mm/plugin/ipcall/model/d/b:DRh	Ljava/lang/String;
    //   1191: aastore
    //   1192: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1195: aload 15
    //   1197: getfield 186	com/tencent/mm/plugin/ipcall/model/d/a:DQH	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1200: invokevirtual 591	com/tencent/mm/plugin/voip/model/v2protocal:reset	()V
    //   1203: aload 15
    //   1205: invokevirtual 594	com/tencent/mm/plugin/ipcall/model/d/a:resetStatus	()V
    //   1208: getstatic 69	com/tencent/mm/plugin/ipcall/c:knk	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   1211: aload_0
    //   1212: getfield 97	com/tencent/mm/plugin/ipcall/c:DOo	Ljava/lang/Runnable;
    //   1215: invokevirtual 598	com/tencent/mm/sdk/platformtools/MMHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1218: getstatic 69	com/tencent/mm/plugin/ipcall/c:knk	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   1221: aload_0
    //   1222: getfield 94	com/tencent/mm/plugin/ipcall/c:DOn	Ljava/lang/Runnable;
    //   1225: invokevirtual 598	com/tencent/mm/sdk/platformtools/MMHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1228: aload_0
    //   1229: getfield 600	com/tencent/mm/plugin/ipcall/c:timer	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   1232: ifnull +15 -> 1247
    //   1235: aload_0
    //   1236: getfield 600	com/tencent/mm/plugin/ipcall/c:timer	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   1239: invokevirtual 605	com/tencent/mm/sdk/platformtools/MTimerHandler:stopTimer	()V
    //   1242: aload_0
    //   1243: aconst_null
    //   1244: putfield 600	com/tencent/mm/plugin/ipcall/c:timer	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   1247: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eJs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1250: iload_3
    //   1251: putfield 608	com/tencent/mm/plugin/ipcall/model/d/b:DQX	I
    //   1254: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eJs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1257: astore 15
    //   1259: ldc 176
    //   1261: ldc_w 610
    //   1264: invokestatic 453	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1267: aload 15
    //   1269: getfield 613	com/tencent/mm/plugin/ipcall/model/d/b:DRe	J
    //   1272: lconst_0
    //   1273: lcmp
    //   1274: ifne +64 -> 1338
    //   1277: aload 15
    //   1279: getfield 616	com/tencent/mm/plugin/ipcall/model/d/b:DRd	J
    //   1282: lconst_0
    //   1283: lcmp
    //   1284: ifeq +54 -> 1338
    //   1287: aload 15
    //   1289: invokestatic 324	java/lang/System:currentTimeMillis	()J
    //   1292: putfield 613	com/tencent/mm/plugin/ipcall/model/d/b:DRe	J
    //   1295: aload 15
    //   1297: aload 15
    //   1299: getfield 613	com/tencent/mm/plugin/ipcall/model/d/b:DRe	J
    //   1302: aload 15
    //   1304: getfield 616	com/tencent/mm/plugin/ipcall/model/d/b:DRd	J
    //   1307: lsub
    //   1308: ldc2_w 617
    //   1311: ldiv
    //   1312: putfield 621	com/tencent/mm/plugin/ipcall/model/d/b:DQW	J
    //   1315: ldc 176
    //   1317: ldc_w 623
    //   1320: iconst_1
    //   1321: anewarray 4	java/lang/Object
    //   1324: dup
    //   1325: iconst_0
    //   1326: aload 15
    //   1328: getfield 621	com/tencent/mm/plugin/ipcall/model/d/b:DQW	J
    //   1331: invokestatic 628	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1334: aastore
    //   1335: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1338: iload_1
    //   1339: bipush 8
    //   1341: if_icmpne +534 -> 1875
    //   1344: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eJq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1347: invokevirtual 631	com/tencent/mm/plugin/ipcall/model/g:eJn	()V
    //   1350: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eJs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1353: invokevirtual 634	com/tencent/mm/plugin/ipcall/model/d/b:eJN	()V
    //   1356: aload_0
    //   1357: getfield 636	com/tencent/mm/plugin/ipcall/c:DOi	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1360: astore 15
    //   1362: aload 15
    //   1364: ifnull +53 -> 1417
    //   1367: ldc_w 638
    //   1370: ldc_w 640
    //   1373: iconst_1
    //   1374: anewarray 4	java/lang/Object
    //   1377: dup
    //   1378: iconst_0
    //   1379: aload 15
    //   1381: getfield 645	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   1384: invokestatic 628	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1387: aastore
    //   1388: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1391: aload 15
    //   1393: getfield 645	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   1396: ldc2_w 646
    //   1399: lcmp
    //   1400: ifeq +17 -> 1417
    //   1403: aload 15
    //   1405: iconst_2
    //   1406: putfield 650	com/tencent/mm/plugin/ipcall/model/h/k:field_status	I
    //   1409: invokestatic 654	com/tencent/mm/plugin/ipcall/model/i:eJx	()Lcom/tencent/mm/plugin/ipcall/model/h/l;
    //   1412: aload 15
    //   1414: invokevirtual 659	com/tencent/mm/plugin/ipcall/model/h/l:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)V
    //   1417: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eJq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1420: getfield 662	com/tencent/mm/plugin/ipcall/model/g:fQy	Z
    //   1423: ifeq +186 -> 1609
    //   1426: aload_0
    //   1427: getfield 664	com/tencent/mm/plugin/ipcall/c:DOp	Z
    //   1430: ifne +891 -> 2321
    //   1433: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eJq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1436: getfield 210	com/tencent/mm/plugin/ipcall/model/g:DOY	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   1439: getfield 233	com/tencent/mm/plugin/ipcall/model/b/c:roomId	I
    //   1442: ifeq +879 -> 2321
    //   1445: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eJq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1448: getfield 210	com/tencent/mm/plugin/ipcall/model/g:DOY	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   1451: getfield 667	com/tencent/mm/plugin/ipcall/model/b/c:DPK	J
    //   1454: lconst_0
    //   1455: lcmp
    //   1456: ifeq +865 -> 2321
    //   1459: invokestatic 671	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1462: astore 15
    //   1464: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eJq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1467: getfield 210	com/tencent/mm/plugin/ipcall/model/g:DOY	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   1470: getfield 233	com/tencent/mm/plugin/ipcall/model/b/c:roomId	I
    //   1473: istore_2
    //   1474: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eJq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1477: getfield 210	com/tencent/mm/plugin/ipcall/model/g:DOY	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   1480: getfield 667	com/tencent/mm/plugin/ipcall/model/b/c:DPK	J
    //   1483: lstore 9
    //   1485: ldc_w 673
    //   1488: ldc_w 675
    //   1491: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1494: invokestatic 680	com/tencent/mm/plugin/ipcall/d:eIU	()Z
    //   1497: ifeq +112 -> 1609
    //   1500: invokestatic 686	com/tencent/mm/n/h:axc	()Lcom/tencent/mm/n/f;
    //   1503: ldc_w 688
    //   1506: iconst_0
    //   1507: invokevirtual 694	com/tencent/mm/n/f:getInt	(Ljava/lang/String;I)I
    //   1510: istore_3
    //   1511: invokestatic 700	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
    //   1514: pop
    //   1515: invokestatic 706	com/tencent/mm/model/c:aHp	()Lcom/tencent/mm/storage/ao;
    //   1518: getstatic 712	com/tencent/mm/storage/ar$a:VjG	Lcom/tencent/mm/storage/ar$a;
    //   1521: iconst_0
    //   1522: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1525: invokevirtual 718	com/tencent/mm/storage/ao:get	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   1528: checkcast 160	java/lang/Integer
    //   1531: invokevirtual 721	java/lang/Integer:intValue	()I
    //   1534: istore_1
    //   1535: invokestatic 700	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
    //   1538: pop
    //   1539: invokestatic 706	com/tencent/mm/model/c:aHp	()Lcom/tencent/mm/storage/ao;
    //   1542: getstatic 724	com/tencent/mm/storage/ar$a:VjF	Lcom/tencent/mm/storage/ar$a;
    //   1545: lconst_0
    //   1546: invokestatic 628	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1549: invokevirtual 718	com/tencent/mm/storage/ao:get	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   1552: checkcast 625	java/lang/Long
    //   1555: invokevirtual 727	java/lang/Long:longValue	()J
    //   1558: lstore 11
    //   1560: invokestatic 730	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   1563: lstore 13
    //   1565: lload 13
    //   1567: lload 11
    //   1569: lsub
    //   1570: ldc2_w 731
    //   1573: lcmp
    //   1574: ifle +787 -> 2361
    //   1577: iconst_0
    //   1578: istore_1
    //   1579: ldc_w 673
    //   1582: ldc_w 734
    //   1585: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1588: iload_1
    //   1589: iload_3
    //   1590: if_icmplt +624 -> 2214
    //   1593: ldc_w 673
    //   1596: ldc_w 736
    //   1599: iload_3
    //   1600: invokestatic 738	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1603: invokevirtual 742	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1606: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1609: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eJq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1612: aconst_null
    //   1613: putfield 746	com/tencent/mm/plugin/ipcall/model/g:DOP	Lcom/tencent/mm/plugin/ipcall/model/g$a;
    //   1616: invokestatic 154	com/tencent/mm/plugin/ipcall/model/i:eJr	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   1619: aconst_null
    //   1620: putfield 750	com/tencent/mm/plugin/ipcall/model/d/a:DQM	Lcom/tencent/mm/plugin/ipcall/model/d/a$a;
    //   1623: invokestatic 124	com/tencent/mm/plugin/ipcall/model/i:eJu	()Lcom/tencent/mm/plugin/ipcall/model/f;
    //   1626: iconst_m1
    //   1627: putfield 219	com/tencent/mm/plugin/ipcall/model/f:pzp	I
    //   1630: invokestatic 754	com/tencent/mm/plugin/ipcall/model/i:eJo	()Lcom/tencent/mm/plugin/ipcall/model/i;
    //   1633: pop
    //   1634: invokestatic 757	com/tencent/mm/plugin/ipcall/model/a/a:unInit	()V
    //   1637: aload_0
    //   1638: iconst_1
    //   1639: invokevirtual 760	com/tencent/mm/plugin/ipcall/c:to	(Z)V
    //   1642: aload_0
    //   1643: invokespecial 763	com/tencent/mm/plugin/ipcall/c:removeListener	()V
    //   1646: ldc 110
    //   1648: ldc_w 765
    //   1651: iconst_0
    //   1652: anewarray 4	java/lang/Object
    //   1655: invokestatic 768	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1658: bipush 26
    //   1660: invokestatic 773	com/tencent/mm/compatible/util/d:qV	(I)Z
    //   1663: ifeq +44 -> 1707
    //   1666: new 775	android/content/Intent
    //   1669: dup
    //   1670: invokespecial 776	android/content/Intent:<init>	()V
    //   1673: astore 15
    //   1675: aload 15
    //   1677: invokestatic 671	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1680: ldc_w 778
    //   1683: invokevirtual 782	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   1686: pop
    //   1687: invokestatic 671	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1690: aload 15
    //   1692: invokevirtual 786	android/content/Context:stopService	(Landroid/content/Intent;)Z
    //   1695: pop
    //   1696: iconst_1
    //   1697: istore_1
    //   1698: iload_1
    //   1699: ifeq +8 -> 1707
    //   1702: aload_0
    //   1703: iconst_0
    //   1704: putfield 79	com/tencent/mm/plugin/ipcall/c:DOl	Z
    //   1707: sipush 25297
    //   1710: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1713: iconst_1
    //   1714: ireturn
    //   1715: iconst_2
    //   1716: invokestatic 305	com/tencent/mm/plugin/audio/c/a:setMode	(I)V
    //   1719: goto -1477 -> 242
    //   1722: iconst_2
    //   1723: istore 5
    //   1725: goto -1342 -> 383
    //   1728: astore 17
    //   1730: ldc_w 307
    //   1733: ldc_w 788
    //   1736: iconst_1
    //   1737: anewarray 4	java/lang/Object
    //   1740: dup
    //   1741: iconst_0
    //   1742: aload 17
    //   1744: aastore
    //   1745: invokestatic 791	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1748: aload 15
    //   1750: bipush 6
    //   1752: putfield 400	com/tencent/mm/plugin/voip/video/e:NZT	I
    //   1755: aload 16
    //   1757: invokevirtual 792	android/media/MediaPlayer:stop	()V
    //   1760: aload 16
    //   1762: invokevirtual 795	android/media/MediaPlayer:release	()V
    //   1765: goto -1336 -> 429
    //   1768: iconst_0
    //   1769: istore 5
    //   1771: goto -1282 -> 489
    //   1774: iconst_0
    //   1775: istore 5
    //   1777: goto -1288 -> 489
    //   1780: iconst_0
    //   1781: istore 5
    //   1783: goto -1210 -> 573
    //   1786: iconst_0
    //   1787: istore 5
    //   1789: goto -1216 -> 573
    //   1792: iconst_m1
    //   1793: istore 5
    //   1795: goto -1152 -> 643
    //   1798: iconst_0
    //   1799: istore 5
    //   1801: goto -1158 -> 643
    //   1804: aload 17
    //   1806: iload 5
    //   1808: invokevirtual 798	com/tencent/mm/plugin/ipcall/model/a/a:getStreamMaxVolume	(I)I
    //   1811: i2f
    //   1812: fstore 4
    //   1814: aload 17
    //   1816: iload 5
    //   1818: invokevirtual 801	com/tencent/mm/plugin/ipcall/model/a/a:getStreamVolume	(I)I
    //   1821: i2f
    //   1822: fload 4
    //   1824: fdiv
    //   1825: ldc_w 802
    //   1828: fmul
    //   1829: f2i
    //   1830: istore 5
    //   1832: goto -1180 -> 652
    //   1835: astore 15
    //   1837: aload 16
    //   1839: monitorexit
    //   1840: sipush 25297
    //   1843: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1846: aload 15
    //   1848: athrow
    //   1849: astore 16
    //   1851: aload 15
    //   1853: monitorexit
    //   1854: sipush 25297
    //   1857: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1860: aload 16
    //   1862: athrow
    //   1863: iconst_0
    //   1864: istore 5
    //   1866: goto -908 -> 958
    //   1869: iconst_0
    //   1870: istore 5
    //   1872: goto -884 -> 988
    //   1875: iload_1
    //   1876: bipush 12
    //   1878: if_icmpne +97 -> 1975
    //   1881: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eJq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1884: invokevirtual 631	com/tencent/mm/plugin/ipcall/model/g:eJn	()V
    //   1887: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eJs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1890: invokevirtual 634	com/tencent/mm/plugin/ipcall/model/d/b:eJN	()V
    //   1893: iload_2
    //   1894: bipush 11
    //   1896: if_icmpne +14 -> 1910
    //   1899: aload_0
    //   1900: getfield 636	com/tencent/mm/plugin/ipcall/c:DOi	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1903: invokestatic 808	com/tencent/mm/plugin/ipcall/model/h/m:b	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1906: pop
    //   1907: goto -490 -> 1417
    //   1910: aload_0
    //   1911: getfield 636	com/tencent/mm/plugin/ipcall/c:DOi	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1914: astore 15
    //   1916: aload 15
    //   1918: ifnull -501 -> 1417
    //   1921: ldc_w 638
    //   1924: ldc_w 810
    //   1927: iconst_1
    //   1928: anewarray 4	java/lang/Object
    //   1931: dup
    //   1932: iconst_0
    //   1933: aload 15
    //   1935: getfield 645	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   1938: invokestatic 628	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1941: aastore
    //   1942: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1945: aload 15
    //   1947: getfield 645	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   1950: ldc2_w 646
    //   1953: lcmp
    //   1954: ifeq -537 -> 1417
    //   1957: aload 15
    //   1959: bipush 6
    //   1961: putfield 650	com/tencent/mm/plugin/ipcall/model/h/k:field_status	I
    //   1964: invokestatic 654	com/tencent/mm/plugin/ipcall/model/i:eJx	()Lcom/tencent/mm/plugin/ipcall/model/h/l;
    //   1967: aload 15
    //   1969: invokevirtual 659	com/tencent/mm/plugin/ipcall/model/h/l:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)V
    //   1972: goto -555 -> 1417
    //   1975: iload_1
    //   1976: bipush 9
    //   1978: if_icmpne +33 -> 2011
    //   1981: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eJq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1984: iconst_1
    //   1985: invokevirtual 813	com/tencent/mm/plugin/ipcall/model/g:Vk	(I)V
    //   1988: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eJs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1991: invokevirtual 816	com/tencent/mm/plugin/ipcall/model/d/b:eJM	()V
    //   1994: aload_0
    //   1995: getfield 636	com/tencent/mm/plugin/ipcall/c:DOi	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1998: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eJs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   2001: getfield 621	com/tencent/mm/plugin/ipcall/model/d/b:DQW	J
    //   2004: invokestatic 819	com/tencent/mm/plugin/ipcall/model/h/m:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;J)Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2007: pop
    //   2008: goto -591 -> 1417
    //   2011: iload_1
    //   2012: bipush 10
    //   2014: if_icmpne +116 -> 2130
    //   2017: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eJq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   2020: iconst_1
    //   2021: invokevirtual 813	com/tencent/mm/plugin/ipcall/model/g:Vk	(I)V
    //   2024: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eJs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   2027: astore 15
    //   2029: ldc 176
    //   2031: ldc_w 821
    //   2034: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2037: aload 15
    //   2039: iconst_1
    //   2040: putfield 824	com/tencent/mm/plugin/ipcall/model/d/b:DQQ	I
    //   2043: aload_0
    //   2044: getfield 636	com/tencent/mm/plugin/ipcall/c:DOi	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2047: astore 15
    //   2049: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eJs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   2052: getfield 621	com/tencent/mm/plugin/ipcall/model/d/b:DQW	J
    //   2055: lstore 9
    //   2057: aload 15
    //   2059: ifnull -642 -> 1417
    //   2062: ldc_w 638
    //   2065: ldc_w 826
    //   2068: iconst_2
    //   2069: anewarray 4	java/lang/Object
    //   2072: dup
    //   2073: iconst_0
    //   2074: aload 15
    //   2076: getfield 645	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   2079: invokestatic 628	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2082: aastore
    //   2083: dup
    //   2084: iconst_1
    //   2085: lload 9
    //   2087: invokestatic 628	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2090: aastore
    //   2091: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2094: aload 15
    //   2096: getfield 645	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   2099: ldc2_w 646
    //   2102: lcmp
    //   2103: ifeq -686 -> 1417
    //   2106: aload 15
    //   2108: iconst_5
    //   2109: putfield 650	com/tencent/mm/plugin/ipcall/model/h/k:field_status	I
    //   2112: aload 15
    //   2114: lload 9
    //   2116: putfield 829	com/tencent/mm/plugin/ipcall/model/h/k:field_duration	J
    //   2119: invokestatic 654	com/tencent/mm/plugin/ipcall/model/i:eJx	()Lcom/tencent/mm/plugin/ipcall/model/h/l;
    //   2122: aload 15
    //   2124: invokevirtual 659	com/tencent/mm/plugin/ipcall/model/h/l:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)V
    //   2127: goto -710 -> 1417
    //   2130: iload_1
    //   2131: bipush 11
    //   2133: if_icmpne -716 -> 1417
    //   2136: iload_2
    //   2137: iconst_5
    //   2138: if_icmpne +33 -> 2171
    //   2141: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eJq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   2144: iconst_3
    //   2145: invokevirtual 813	com/tencent/mm/plugin/ipcall/model/g:Vk	(I)V
    //   2148: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eJs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   2151: invokevirtual 816	com/tencent/mm/plugin/ipcall/model/d/b:eJM	()V
    //   2154: iload_2
    //   2155: bipush 11
    //   2157: if_icmpne +40 -> 2197
    //   2160: aload_0
    //   2161: getfield 636	com/tencent/mm/plugin/ipcall/c:DOi	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2164: invokestatic 808	com/tencent/mm/plugin/ipcall/model/h/m:b	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2167: pop
    //   2168: goto -751 -> 1417
    //   2171: iload_2
    //   2172: bipush 11
    //   2174: if_icmpne +13 -> 2187
    //   2177: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eJq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   2180: iconst_1
    //   2181: invokevirtual 813	com/tencent/mm/plugin/ipcall/model/g:Vk	(I)V
    //   2184: goto -36 -> 2148
    //   2187: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eJq	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   2190: iconst_2
    //   2191: invokevirtual 813	com/tencent/mm/plugin/ipcall/model/g:Vk	(I)V
    //   2194: goto -46 -> 2148
    //   2197: aload_0
    //   2198: getfield 636	com/tencent/mm/plugin/ipcall/c:DOi	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2201: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eJs	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   2204: getfield 621	com/tencent/mm/plugin/ipcall/model/d/b:DQW	J
    //   2207: invokestatic 819	com/tencent/mm/plugin/ipcall/model/h/m:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;J)Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2210: pop
    //   2211: goto -794 -> 1417
    //   2214: lload 13
    //   2216: lload 11
    //   2218: lsub
    //   2219: ldc2_w 830
    //   2222: lcmp
    //   2223: ifge +15 -> 2238
    //   2226: ldc_w 673
    //   2229: ldc_w 833
    //   2232: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2235: goto -626 -> 1609
    //   2238: invokestatic 700	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
    //   2241: pop
    //   2242: invokestatic 706	com/tencent/mm/model/c:aHp	()Lcom/tencent/mm/storage/ao;
    //   2245: getstatic 712	com/tencent/mm/storage/ar$a:VjG	Lcom/tencent/mm/storage/ar$a;
    //   2248: iload_1
    //   2249: iconst_1
    //   2250: iadd
    //   2251: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2254: invokevirtual 837	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   2257: invokestatic 700	com/tencent/mm/model/bh:beI	()Lcom/tencent/mm/model/c;
    //   2260: pop
    //   2261: invokestatic 706	com/tencent/mm/model/c:aHp	()Lcom/tencent/mm/storage/ao;
    //   2264: getstatic 724	com/tencent/mm/storage/ar$a:VjF	Lcom/tencent/mm/storage/ar$a;
    //   2267: lload 13
    //   2269: invokestatic 628	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2272: invokevirtual 837	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   2275: new 775	android/content/Intent
    //   2278: dup
    //   2279: invokespecial 776	android/content/Intent:<init>	()V
    //   2282: astore 16
    //   2284: aload 16
    //   2286: ldc_w 839
    //   2289: iload_2
    //   2290: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2293: pop
    //   2294: aload 16
    //   2296: ldc_w 845
    //   2299: lload 9
    //   2301: invokevirtual 848	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   2304: pop
    //   2305: aload 15
    //   2307: ldc_w 489
    //   2310: ldc_w 850
    //   2313: aload 16
    //   2315: invokestatic 855	com/tencent/mm/by/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   2318: goto -709 -> 1609
    //   2321: ldc 110
    //   2323: ldc_w 857
    //   2326: invokestatic 860	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2329: goto -720 -> 1609
    //   2332: astore 15
    //   2334: ldc 110
    //   2336: aload 15
    //   2338: ldc_w 862
    //   2341: iconst_1
    //   2342: anewarray 4	java/lang/Object
    //   2345: dup
    //   2346: iconst_0
    //   2347: aload 15
    //   2349: invokevirtual 865	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2352: aastore
    //   2353: invokestatic 869	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2356: iconst_0
    //   2357: istore_1
    //   2358: goto -660 -> 1698
    //   2361: goto -773 -> 1588
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
    //   963	34	6	j	int
    //   978	15	7	k	int
    //   198	178	8	bool	boolean
    //   1483	817	9	l1	long
    //   1558	659	11	l2	long
    //   1563	705	13	l3	long
    //   1835	17	15	localObject2	Object
    //   1914	392	15	localObject3	Object
    //   2332	16	15	localException	Exception
    //   1849	12	16	localObject5	Object
    //   2282	32	16	localIntent	Intent
    //   603	508	17	localObject6	Object
    //   1728	87	17	localThrowable	java.lang.Throwable
    //   610	381	18	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   293	375	1728	java/lang/Throwable
    //   383	429	1728	java/lang/Throwable
    //   714	749	1835	finally
    //   825	871	1849	finally
    //   871	874	1849	finally
    //   1666	1696	2332	java/lang/Exception
  }
  
  private void bzG()
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
          AppMethodBeat.i(25293);
          c.this.eIR();
          if ((i.eJu().eJm()) && (c.a(c.this) != null)) {
            c.a(c.this).eIY();
          }
          AppMethodBeat.o(25293);
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
    if (this.DOk != null)
    {
      TelephonyManager localTelephonyManager = this.DOk;
      Object localObject = this.prS;
      localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject);
      com.tencent.mm.hellhoundlib.a.a.b(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/ipcall/IPCallManager", "removeListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.c(localTelephonyManager, "com/tencent/mm/plugin/ipcall/IPCallManager", "removeListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      this.DOk = null;
    }
    EventCenter.instance.removeListener(this.DOm);
    AppMethodBeat.o(25295);
  }
  
  public final void Vf(int paramInt)
  {
    AppMethodBeat.i(25315);
    Log.i("MicroMsg.IPCallManager", "onChannelConnectFailed, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Vj(i.eJu().pzp) });
    if (i.eJr().DQK)
    {
      Log.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel already connected");
      if (hT(5, paramInt))
      {
        g(5, null, MMApplicationContext.getContext().getString(R.l.etC), 1);
        AppMethodBeat.o(25315);
      }
    }
    else
    {
      Log.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel not connet, may be request connect failed");
      if (hT(4, paramInt)) {
        g(4, null, MMApplicationContext.getContext().getString(R.l.etC), 1);
      }
    }
    AppMethodBeat.o(25315);
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25296);
    if (i.eJu().eJj())
    {
      Log.i("MicroMsg.IPCallManager", "startIPCall, already start!");
      AppMethodBeat.o(25296);
      return false;
    }
    Log.i("MicroMsg.IPCallManager", "startIPCall");
    i.eJq().DOP = this;
    i.eJr().DQM = this;
    i.eJu().pzp = -1;
    removeListener();
    this.DOk = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
    Object localObject1 = this.DOk;
    Object localObject2 = this.prS;
    localObject2 = com.tencent.mm.hellhoundlib.b.c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bm(localObject2);
    com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aFh(), "com/tencent/mm/plugin/ipcall/IPCallManager", "addListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).sf(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/ipcall/IPCallManager", "addListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    EventCenter.instance.addListener(this.DOm);
    Log.d("MicroMsg.IPCallRecordStorageLogic", "recordStartCall, phoneNumber: %s, contactId: %s", new Object[] { paramString4, paramString5 });
    localObject1 = new com.tencent.mm.plugin.ipcall.model.h.k();
    ((com.tencent.mm.plugin.ipcall.model.h.k)localObject1).field_phonenumber = paramString4;
    if (!Util.isNullOrNil(paramString5))
    {
      localObject2 = i.eJw().aMc(paramString5);
      if ((localObject2 != null) && (((com.tencent.mm.plugin.ipcall.model.h.c)localObject2).systemRowid != -1L))
      {
        ((com.tencent.mm.plugin.ipcall.model.h.k)localObject1).field_addressId = ((com.tencent.mm.plugin.ipcall.model.h.c)localObject2).systemRowid;
        if (paramInt1 == -1) {
          break label960;
        }
        ((com.tencent.mm.plugin.ipcall.model.h.k)localObject1).field_phoneType = paramInt1;
        label296:
        ((com.tencent.mm.plugin.ipcall.model.h.k)localObject1).field_calltime = Util.nowMilliSecond();
        ((com.tencent.mm.plugin.ipcall.model.h.k)localObject1).field_status = 1;
        if (!i.eJx().insert((IAutoDBItem)localObject1)) {
          break label969;
        }
        label321:
        this.DOi = ((com.tencent.mm.plugin.ipcall.model.h.k)localObject1);
        knk.postDelayed(this.DOo, 1754L);
        this.DOj = false;
        localObject1 = i.eJs();
        Log.d("MicroMsg.IPCallReportHelper", "reset");
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DQO = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DQP = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DQQ = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DQR = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DQS = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DQT = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DQU = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DQV = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DQW = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DQX = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).roomId = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DPJ = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DQY = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).mZK = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DQZ = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DRa = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DRc = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DRb = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DOr = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DRd = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DRe = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DRj = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DRi = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DRf = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DRg = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).countryCode = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DRk = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DRl = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DRm = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DRn = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).DRo = 0;
        i.eJu().pzp = -1;
        Log.d("MicroMsg.IPCallManager", "startIPCall, username: %s, phoneNumber: %s", new Object[] { paramString3, paramString4 });
        localObject1 = i.eJq();
        Log.d("MicroMsg.IPCallSvrLogic", "startIPCall, toUsername: %s, toPhoneNumber: %s", new Object[] { paramString3, paramString4 });
        ((g)localObject1).fQy = false;
        ((g)localObject1).DOZ = false;
        ((g)localObject1).DOK = 0;
        ((g)localObject1).DOL = 0;
        ((g)localObject1).DOM = 0;
        ((g)localObject1).DON = false;
        ((g)localObject1).DOO = false;
        ((g)localObject1).DPa = false;
        ((g)localObject1).DOY = new com.tencent.mm.plugin.ipcall.model.b.c();
        ((g)localObject1).DOY.nickname = paramString1;
        ((g)localObject1).DOY.DQj = paramString2;
        ((g)localObject1).DOY.fXl = paramString5;
        ((g)localObject1).DOY.DQk = paramString4;
        ((g)localObject1).DOY.fcD = paramString3;
        ((g)localObject1).DOY.DPL = ((int)System.currentTimeMillis());
        ((g)localObject1).DOY.DPM = paramInt2;
        ((g)localObject1).DOY.DPN = paramInt3;
        ((g)localObject1).DOY.phoneType = paramInt1;
        ((g)localObject1).DOQ.a(((g)localObject1).DOY);
        ((g)localObject1).DOV.a(((g)localObject1).DOY);
        Log.i("MicroMsg.IPCallSvrLogic", "startIPCallInternal, inviteId: %d", new Object[] { Integer.valueOf(((g)localObject1).DOY.DPL) });
        i.eJu().Vh(1);
        paramString1 = i.eJr();
        if (!paramString1.DQL) {
          break label975;
        }
        Log.d("MicroMsg.IPCallEngineManager", "already start engine");
      }
    }
    for (;;)
    {
      knk.removeCallbacks(this.DOn);
      knk.postDelayed(this.DOn, 60000L);
      Log.printInfoStack("MicroMsg.IPCallManager", "bindIPCallForegroundIfNeed", new Object[0]);
      if ((com.tencent.mm.compatible.util.d.qV(26)) && (!this.DOl))
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
        this.DOl = true;
      }
      AppMethodBeat.o(25296);
      return true;
      ((com.tencent.mm.plugin.ipcall.model.h.k)localObject1).field_addressId = -1L;
      break;
      ((com.tencent.mm.plugin.ipcall.model.h.k)localObject1).field_addressId = -1L;
      break;
      label960:
      ((com.tencent.mm.plugin.ipcall.model.h.k)localObject1).field_phoneType = -1;
      break label296;
      label969:
      localObject1 = null;
      break label321;
      label975:
      paramString1.resetStatus();
      Log.i("MicroMsg.IPCallEngineManager", "start engine");
      if (paramString1.DQH.gBo())
      {
        paramString1.DQH.AZ(false);
        paramString1.DQH.reset();
      }
      paramString1.DQH.NQH = 1;
      l = System.currentTimeMillis();
      paramInt1 = paramString1.DQH.gBq();
      Log.d("MicroMsg.IPCallEngineManager", "protocal init finish, ret: %d, used %dms", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() - l) });
      if ((paramString1.DQH.field_capInfo != null) && (paramString1.DQH.exchangeCabInfo(paramString1.DQH.field_capInfo, paramString1.DQH.field_capInfo.length) < 0))
      {
        Log.e("MicroMsg.IPCallEngineManager", "exchangeCabInfo failed");
        i.eJs().DQX = 24;
      }
      if (paramInt1 < 0) {
        Log.e("MicroMsg.IPCallEngineManager", "engine init failed!");
      }
      paramString1.DQH.NQH = 1;
      paramString1.DQL = true;
    }
  }
  
  public final void ab(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(25300);
    Log.i("MicroMsg.IPCallManager", "onInviteFailed, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Vj(i.eJu().pzp) });
    if (hT(2, 0)) {
      g(2, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(25300);
  }
  
  public final void ac(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(25309);
    Log.i("MicroMsg.IPCallManager", "onAccountOverdue, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Vj(i.eJu().pzp) });
    if (hT(8, 9)) {
      g(8, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(25309);
  }
  
  public final void ad(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(25310);
    Log.i("MicroMsg.IPCallManager", "onCallRestricted, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Vj(i.eJu().pzp) });
    if (hT(10, 0)) {
      g(10, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(25310);
  }
  
  public final void ae(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(25311);
    Log.i("MicroMsg.IPCallManager", "onCallPhoneNumberInvalid, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Vj(i.eJu().pzp) });
    if (hT(11, 0)) {
      g(11, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(25311);
  }
  
  public final void eIF()
  {
    AppMethodBeat.i(25299);
    Log.i("MicroMsg.IPCallManager", "onInviteSuccess");
    if (!i.eJu().Vh(3))
    {
      AppMethodBeat.o(25299);
      return;
    }
    Object localObject = i.eJs();
    Log.d("MicroMsg.IPCallReportHelper", "markStartInvite");
    if (((com.tencent.mm.plugin.ipcall.model.d.b)localObject).DRb == 0L) {
      ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).DRb = System.currentTimeMillis();
    }
    localObject = i.eJq().DOY;
    com.tencent.mm.plugin.ipcall.model.d.b localb = i.eJs();
    int i = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).DPL;
    String str1 = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).fcD;
    String str2 = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).DQk;
    int j = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).roomId;
    long l1 = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).DPJ;
    long l2 = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).DPK;
    localb.DPL = i;
    localb.DRa = str1;
    localb.mZK = str2;
    localb.roomId = j;
    localb.DPJ = l1;
    localb.DQY = l2;
    if (this.DOh != null) {
      this.DOh.eIF();
    }
    AppMethodBeat.o(25299);
  }
  
  public final void eIG()
  {
    AppMethodBeat.i(25301);
    Log.i("MicroMsg.IPCallManager", "onStartRing, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Vj(i.eJu().pzp) });
    if (!i.eJu().Vh(4))
    {
      AppMethodBeat.o(25301);
      return;
    }
    com.tencent.mm.plugin.ipcall.model.d.b localb = i.eJs();
    Log.d("MicroMsg.IPCallReportHelper", "markStartRing");
    if (localb.DRc == 0L)
    {
      localb.DRc = System.currentTimeMillis();
      localb.DQT = (localb.DRc - localb.DRb);
      Log.d("MicroMsg.IPCallReportHelper", "ringTime: %d", new Object[] { Long.valueOf(localb.DQT) });
    }
    i.eJr().eJL();
    localb = i.eJs();
    Log.i("MicroMsg.IPCallReportHelper", "startRing");
    localb.DQO = 1;
    if (this.DOh != null) {
      this.DOh.eIG();
    }
    AppMethodBeat.o(25301);
  }
  
  public final void eIH()
  {
    AppMethodBeat.i(25302);
    Log.i("MicroMsg.IPCallManager", "onAccept, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Vj(i.eJu().pzp) });
    if (!i.eJu().Vh(5))
    {
      AppMethodBeat.o(25302);
      return;
    }
    com.tencent.mm.plugin.ipcall.model.d.b localb = i.eJs();
    Log.d("MicroMsg.IPCallReportHelper", "markUserAccept");
    if (localb.DOr == 0L)
    {
      localb.DOr = System.currentTimeMillis();
      localb.DQU = (localb.DOr - localb.DRb);
      Log.d("MicroMsg.IPCallReportHelper", "answerTime: %d", new Object[] { Long.valueOf(localb.DQU) });
    }
    i.eJr().eJL();
    localb = i.eJs();
    Log.i("MicroMsg.IPCallReportHelper", "userAccept");
    localb.DQP = 1;
    knk.removeCallbacks(this.DOn);
    i.eJA().stop();
    knk.removeCallbacks(this.DOo);
    i.eJt().DQq.bRC();
    if ((i.eJr().DQK) && (!this.DOj))
    {
      i.eJs().eJO();
      i.eJs().eJR();
      this.DOj = true;
      this.DOr = Util.nowSecond();
      bzG();
      i.eJr().eJK();
      if (this.DOh != null) {
        this.DOh.eIV();
      }
      i.eJs().eJQ();
      r.gzC().gzD();
      r.gzC().a(this);
    }
    AppMethodBeat.o(25302);
  }
  
  public final void eII()
  {
    AppMethodBeat.i(25306);
    Log.i("MicroMsg.IPCallManager", "onShutdownByOtherSide, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Vj(i.eJu().pzp) });
    if (aq(10, 0, 32))
    {
      if (this.DOh != null)
      {
        this.DOh.eIW();
        AppMethodBeat.o(25306);
        return;
      }
      Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(R.l.eJv), 1).show();
    }
    AppMethodBeat.o(25306);
  }
  
  public final void eIJ()
  {
    AppMethodBeat.i(25308);
    Log.i("MicroMsg.IPCallManager", "onHeartbeatFailed");
    if (hT(7, 29)) {
      g(7, null, MMApplicationContext.getContext().getString(R.l.etC), 1);
    }
    AppMethodBeat.o(25308);
  }
  
  public final void eIK()
  {
    AppMethodBeat.i(25312);
    do
    {
      Log.i("MicroMsg.IPCallManager", "onDisasterHappen, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Vj(i.eJu().pzp) });
    } while (hT(12, 0));
    AppMethodBeat.o(25312);
  }
  
  public final void eIL()
  {
    AppMethodBeat.i(25313);
    Log.i("MicroMsg.IPCallManager", "onStartEngineFailed, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Vj(i.eJu().pzp) });
    if (hT(6, 0)) {
      g(6, null, MMApplicationContext.getContext().getString(R.l.etF), 1);
    }
    AppMethodBeat.o(25313);
  }
  
  public final void eIM()
  {
    AppMethodBeat.i(25314);
    Log.i("MicroMsg.IPCallManager", "onChannelConnected, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Vj(i.eJu().pzp) });
    i.eJA().stop();
    knk.removeCallbacks(this.DOo);
    Object localObject1;
    Object localObject2;
    if (i.eJu().eJk())
    {
      localObject1 = i.eJt();
      ((com.tencent.mm.plugin.ipcall.model.c.b)localObject1).DQq.b("ipcall", Integer.valueOf(4));
      Log.d("MicroMsg.IPCallDeviceManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.ipcall.model.a.a.Ez(3)), Boolean.valueOf(com.tencent.mm.plugin.ipcall.model.a.a.Ez(4)) });
      localObject1 = ((com.tencent.mm.plugin.ipcall.model.c.b)localObject1).DQq;
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).DPC;
      if (localObject2 != null)
      {
        if (!((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).isStart) {
          break label345;
        }
        Log.d("MicroMsg.IPCallAudioPlayer", "startPlay, already start");
      }
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).DPB;
      if (localObject2 != null)
      {
        if (((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).crj() != 3) {
          break label452;
        }
        bool = true;
        label156:
        ((a.b)localObject2).tw(bool);
      }
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).DPB;
      if (localObject2 != null) {
        if (((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).crj() != 4) {
          break label457;
        }
      }
    }
    label452:
    label457:
    for (boolean bool = true;; bool = false)
    {
      ((a.b)localObject2).tx(bool);
      i.eJs().eJO();
      i.eJt().DQq.bRC();
      if ((i.eJu().eJm()) && (!this.DOj))
      {
        i.eJs().eJR();
        i.eJr().eJK();
        this.DOj = true;
        this.DOr = Util.nowSecond();
        bzG();
        if (this.DOh != null) {
          this.DOh.eIV();
        }
        localObject1 = this.DOi;
        if (localObject1 != null)
        {
          Log.d("MicroMsg.IPCallRecordStorageLogic", "recordStartTalk, localId: %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.ipcall.model.h.k)localObject1).systemRowid) });
          if (((com.tencent.mm.plugin.ipcall.model.h.k)localObject1).systemRowid != -1L)
          {
            ((com.tencent.mm.plugin.ipcall.model.h.k)localObject1).field_status = 3;
            i.eJx().a((com.tencent.mm.plugin.ipcall.model.h.k)localObject1);
          }
        }
        i.eJs().eJQ();
        r.gzC().gzD();
        r.gzC().a(this);
      }
      AppMethodBeat.o(25314);
      return;
      label345:
      Log.i("MicroMsg.IPCallAudioPlayer", "startPlay");
      if (((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).tQh == null)
      {
        ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).tQh = new com.tencent.mm.plugin.voip.model.c();
        ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).tQh.S(v2protocal.VOICE_SAMPLERATE, 1, 20, 1);
      }
      ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).DQo = ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).tQh.K(MMApplicationContext.getContext(), false);
      ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).tQh.NJt = new a.1((com.tencent.mm.plugin.ipcall.model.c.a)localObject2);
      if (((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).tQh.gxB() <= 0) {
        i.eJs().eJP();
      }
      ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).DQq.ds(((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).DQp);
      ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).isStart = true;
      break;
      bool = false;
      break label156;
    }
  }
  
  public final void eIN() {}
  
  public final void eIO() {}
  
  public final void eIP()
  {
    AppMethodBeat.i(25318);
    if (i.eJu().pzp != 5)
    {
      Log.i("MicroMsg.IPCallManager", "onResumeGoodNetStatus currentState != accept:%d", new Object[] { Integer.valueOf(i.eJu().pzp) });
      AppMethodBeat.o(25318);
      return;
    }
    com.tencent.mm.plugin.ipcall.model.c.b localb = i.eJt();
    Log.i("MicroMsg.IPCallDeviceManager", "onResumeGoodNetStatus");
    if (localb.DQu != null) {
      localb.DQu.eKF();
    }
    AppMethodBeat.o(25318);
  }
  
  public final void eIQ()
  {
    AppMethodBeat.i(25319);
    synchronized (this.wGe)
    {
      if (i.eJu().eJj())
      {
        if (this.DOp)
        {
          eIR();
          AppMethodBeat.o(25319);
          return;
        }
        this.DOp = true;
        Toast.makeText(MMApplicationContext.getContext(), R.l.multitalk_mini_toast, 0).show();
        Intent localIntent = new Intent();
        localIntent.setFlags(268435456);
        localIntent.setClass(MMApplicationContext.getContext(), IPCallTalkUI.class);
        localIntent.putExtra("IPCallTalkUI_isFromMiniNotification", true);
        com.tencent.mm.plugin.voip.c.gxt().a(localIntent, false, this.DOq);
        eIR();
        if (this.DOh != null) {
          this.DOh.eIX();
        }
      }
      AppMethodBeat.o(25319);
      return;
    }
  }
  
  public final void eIR()
  {
    AppMethodBeat.i(25320);
    if (com.tencent.mm.compatible.util.d.qW(26)) {
      if (!i.eJu().eJm()) {
        break label249;
      }
    }
    label249:
    for (Object localObject1 = MMApplicationContext.getContext().getString(R.l.eIS, new Object[] { String.format("%02d:%02d", new Object[] { Long.valueOf(Util.secondsToNow(this.DOr) / 60L), Long.valueOf(Util.secondsToNow(this.DOr) % 60L) }) });; localObject1 = MMApplicationContext.getContext().getString(R.l.eIR))
    {
      Object localObject2 = new Intent(MMApplicationContext.getContext(), IPCallTalkUI.class);
      ((Intent)localObject2).putExtra("IPCallTalkUI_isFromMiniNotification", true);
      localObject2 = PendingIntent.getActivity(MMApplicationContext.getContext(), 42, (Intent)localObject2, 134217728);
      int i = R.g.notification_icon_gray;
      if (com.tencent.mm.compatible.util.d.qW(19)) {
        i = R.g.notification_icon;
      }
      localObject1 = com.tencent.mm.bx.a.cp(MMApplicationContext.getContext(), "reminder_channel_id").n(MMApplicationContext.getContext().getString(R.l.eIR)).e(System.currentTimeMillis()).k(MMApplicationContext.getContext().getString(R.l.ip_call_func_name)).l((CharSequence)localObject1);
      ((e.d)localObject1).Ip = ((PendingIntent)localObject2);
      localObject1 = ((e.d)localObject1).gr();
      ((Notification)localObject1).icon = i;
      ((Notification)localObject1).flags |= 0x20;
      bh.getNotification().a(42, (Notification)localObject1, false);
      if (i.eJu().eJm()) {
        break;
      }
      com.tencent.mm.plugin.voip.c.gxt().aQM(MMApplicationContext.getContext().getString(R.l.multitalk_waiting_wording));
      AppMethodBeat.o(25320);
      return;
    }
    com.tencent.mm.plugin.voip.c.gxt().AS(eIS());
    AppMethodBeat.o(25320);
  }
  
  public final int eIS()
  {
    AppMethodBeat.i(25322);
    int i = (int)Util.secondsToNow(this.DOr);
    if (i > 0)
    {
      AppMethodBeat.o(25322);
      return i;
    }
    AppMethodBeat.o(25322);
    return 0;
  }
  
  public final void eP(String paramString, int paramInt)
  {
    AppMethodBeat.i(25304);
    Log.i("MicroMsg.IPCallManager", "onUnAvaliable, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Vj(i.eJu().pzp) });
    if (hT(3, 5)) {
      g(3, null, paramString, paramInt);
    }
    AppMethodBeat.o(25304);
  }
  
  public final void eQ(String paramString, int paramInt)
  {
    AppMethodBeat.i(25305);
    Log.i("MicroMsg.IPCallManager", "onBusy, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.model.f.Vj(i.eJu().pzp) });
    if (hT(1, 4)) {
      g(1, null, paramString, paramInt);
    }
    AppMethodBeat.o(25305);
  }
  
  public final void eR(String paramString, int paramInt)
  {
    AppMethodBeat.i(25307);
    Log.i("MicroMsg.IPCallManager", "onSyncFailed");
    if (hT(7, 35)) {
      g(7, null, paramString, paramInt);
    }
    AppMethodBeat.o(25307);
  }
  
  public final void g(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(25303);
    if (this.DOh != null)
    {
      this.DOh.g(paramInt1, paramString1, paramString2, paramInt2);
      AppMethodBeat.o(25303);
      return;
    }
    Toast.makeText(MMApplicationContext.getContext(), paramString2, 1).show();
    AppMethodBeat.o(25303);
  }
  
  public final boolean hT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(25316);
    if (i.eJu().eJm())
    {
      if (paramInt1 == 0)
      {
        bool = aq(9, paramInt1, paramInt2);
        AppMethodBeat.o(25316);
        return bool;
      }
      bool = aq(11, paramInt1, paramInt2);
      AppMethodBeat.o(25316);
      return bool;
    }
    if (paramInt1 == 0)
    {
      bool = aq(8, paramInt1, paramInt2);
      AppMethodBeat.o(25316);
      return bool;
    }
    boolean bool = aq(12, paramInt1, paramInt2);
    AppMethodBeat.o(25316);
    return bool;
  }
  
  public final void tn(boolean paramBoolean)
  {
    AppMethodBeat.i(25317);
    if (i.eJu().pzp != 5)
    {
      Log.i("MicroMsg.IPCallManager", "onBadNetStatus currentState != accept:%d", new Object[] { Integer.valueOf(i.eJu().pzp) });
      AppMethodBeat.o(25317);
      return;
    }
    com.tencent.mm.plugin.ipcall.model.c.b localb = i.eJt();
    Log.i("MicroMsg.IPCallDeviceManager", "onBadNetStatus");
    if (localb.DQu != null)
    {
      j localj = localb.DQu;
      if (localj.DZt != null) {
        localj.DZt.setVisibility(0);
      }
      if (localj.DZu != null) {
        localj.DZu.setVisibility(0);
      }
    }
    if (!localb.DQq.crl())
    {
      long l = System.currentTimeMillis();
      if (l - localb.DQv > 30000L)
      {
        localb.DQv = l;
        com.tencent.mm.plugin.voip.c.gxs().akY(R.k.close_lower_volume);
      }
    }
    AppMethodBeat.o(25317);
  }
  
  public final void to(boolean paramBoolean)
  {
    AppMethodBeat.i(185745);
    synchronized (this.wGe)
    {
      this.DOp = false;
      com.tencent.mm.plugin.voip.c.gxt().ic(paramBoolean);
      ((NotificationManager)MMApplicationContext.getContext().getSystemService("notification")).cancel(42);
      AppMethodBeat.o(185745);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.c
 * JD-Core Version:    0.7.0.1
 */