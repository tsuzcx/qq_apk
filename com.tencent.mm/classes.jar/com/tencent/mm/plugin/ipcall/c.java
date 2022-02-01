package com.tencent.mm.plugin.ipcall;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.v4.app.s.c;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.ipcall.model.IPCallForegroundService;
import com.tencent.mm.plugin.ipcall.model.a.a.b;
import com.tencent.mm.plugin.ipcall.model.c.a.1;
import com.tencent.mm.plugin.ipcall.model.d.a.a;
import com.tencent.mm.plugin.ipcall.model.f;
import com.tencent.mm.plugin.ipcall.model.g;
import com.tencent.mm.plugin.ipcall.model.g.a;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.h.l;
import com.tencent.mm.plugin.ipcall.model.i;
import com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI;
import com.tencent.mm.plugin.ipcall.ui.j;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.r.a;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
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

public final class c
  implements a.a, g.a, r.a
{
  private static MMHandler hAk;
  private PhoneStateListener mtH;
  private Object taa;
  private MTimerHandler timer;
  public e yof;
  private k yog;
  private boolean yoh;
  private TelephonyManager yoi;
  private boolean yoj;
  private IListener yok;
  private Runnable yol;
  private Runnable yom;
  private boolean yon;
  private com.tencent.mm.plugin.voip.ui.a yoo;
  private long yop;
  
  static
  {
    AppMethodBeat.i(25324);
    hAk = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(25324);
  }
  
  public c()
  {
    AppMethodBeat.i(25294);
    this.yoh = false;
    this.yoj = false;
    this.taa = new Object();
    this.mtH = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(25288);
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        Log.d("MicroMsg.IPCallManager", "onCallStateChanged ".concat(String.valueOf(paramAnonymousInt)));
        if (paramAnonymousInt == 2)
        {
          Log.i("MicroMsg.IPCallManager", "system phone call state offhook, stop call");
          c.this.gP(0, 0);
        }
        AppMethodBeat.o(25288);
      }
    };
    this.yok = new c.2(this);
    this.yol = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25289);
        if (!i.eaw().eao())
        {
          Log.i("MicroMsg.IPCallManager", "timeout! still not accept!");
          if (c.this.gP(9, 12)) {
            c.this.g(9, null, MMApplicationContext.getContext().getString(2131756927), 2);
          }
        }
        AppMethodBeat.o(25289);
      }
    };
    this.yom = new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore_1
        //   2: iconst_1
        //   3: istore 4
        //   5: iconst_1
        //   6: istore_3
        //   7: sipush 25290
        //   10: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   13: invokestatic 33	com/tencent/mm/plugin/ipcall/model/i:eaC	()Lcom/tencent/mm/plugin/voip/video/e;
        //   16: astore 6
        //   18: aload 6
        //   20: iconst_0
        //   21: putfield 39	com/tencent/mm/plugin/voip/video/e:Hjf	I
        //   24: ldc2_w 40
        //   27: ldc2_w 42
        //   30: lcmp
        //   31: ifeq +240 -> 271
        //   34: invokestatic 49	com/tencent/mm/sdk/platformtools/MMApplicationContext:isMMProcess	()Z
        //   37: ifeq +255 -> 292
        //   40: invokestatic 55	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
        //   43: invokevirtual 61	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
        //   46: ldc 62
        //   48: getstatic 68	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
        //   51: invokevirtual 74	com/tencent/mm/storage/ao:get	(ILjava/lang/Object;)Ljava/lang/Object;
        //   54: checkcast 64	java/lang/Boolean
        //   57: invokevirtual 77	java/lang/Boolean:booleanValue	()Z
        //   60: istore_2
        //   61: ldc 79
        //   63: ldc 81
        //   65: iconst_3
        //   66: anewarray 4	java/lang/Object
        //   69: dup
        //   70: iconst_0
        //   71: iload_2
        //   72: invokestatic 85	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   75: aastore
        //   76: dup
        //   77: iconst_1
        //   78: invokestatic 90	com/tencent/mm/n/b:apR	()Z
        //   81: invokestatic 85	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   84: aastore
        //   85: dup
        //   86: iconst_2
        //   87: getstatic 68	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
        //   90: aastore
        //   91: invokestatic 95	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   94: iload_3
        //   95: istore_2
        //   96: iload_2
        //   97: ifeq +167 -> 264
        //   100: aload 6
        //   102: getfield 99	com/tencent/mm/plugin/voip/video/e:isStarted	Z
        //   105: ifne +159 -> 264
        //   108: aload 6
        //   110: invokestatic 105	java/lang/System:currentTimeMillis	()J
        //   113: putfield 109	com/tencent/mm/plugin/voip/video/e:Hjg	J
        //   116: aload 6
        //   118: new 111	com/tencent/mm/compatible/b/k
        //   121: dup
        //   122: invokespecial 112	com/tencent/mm/compatible/b/k:<init>	()V
        //   125: putfield 116	com/tencent/mm/plugin/voip/video/e:Hje	Landroid/media/MediaPlayer;
        //   128: ldc 79
        //   130: ldc 118
        //   132: iconst_2
        //   133: anewarray 4	java/lang/Object
        //   136: dup
        //   137: iconst_0
        //   138: invokestatic 123	com/tencent/mm/plugin/audio/c/a:ceb	()Z
        //   141: invokestatic 85	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   144: aastore
        //   145: dup
        //   146: iconst_1
        //   147: invokestatic 126	com/tencent/mm/plugin/audio/c/a:cdW	()Z
        //   150: invokestatic 85	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   153: aastore
        //   154: invokestatic 129	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   157: getstatic 135	com/tencent/mm/compatible/deviceinfo/ae:gKu	Lcom/tencent/mm/compatible/deviceinfo/b;
        //   160: getfield 140	com/tencent/mm/compatible/deviceinfo/b:gEk	I
        //   163: iflt +10 -> 173
        //   166: getstatic 135	com/tencent/mm/compatible/deviceinfo/ae:gKu	Lcom/tencent/mm/compatible/deviceinfo/b;
        //   169: getfield 140	com/tencent/mm/compatible/deviceinfo/b:gEk	I
        //   172: istore_1
        //   173: aload 6
        //   175: iconst_0
        //   176: invokevirtual 144	com/tencent/mm/plugin/voip/video/e:xw	(Z)V
        //   179: aload 6
        //   181: ldc 145
        //   183: ldc2_w 40
        //   186: iconst_1
        //   187: iload_1
        //   188: invokevirtual 149	com/tencent/mm/plugin/voip/video/e:a	(IJZI)V
        //   191: aload 6
        //   193: iconst_1
        //   194: putfield 99	com/tencent/mm/plugin/voip/video/e:isStarted	Z
        //   197: sipush 25290
        //   200: invokestatic 152	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   203: return
        //   204: astore 5
        //   206: iload 4
        //   208: istore_2
        //   209: ldc 79
        //   211: new 154	java/lang/StringBuilder
        //   214: dup
        //   215: ldc 156
        //   217: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   220: aload 5
        //   222: invokevirtual 163	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   225: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   228: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   231: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   234: goto -138 -> 96
        //   237: astore 5
        //   239: ldc 79
        //   241: new 154	java/lang/StringBuilder
        //   244: dup
        //   245: ldc 176
        //   247: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   250: aload 5
        //   252: invokevirtual 177	java/lang/Exception:toString	()Ljava/lang/String;
        //   255: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   258: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   261: invokestatic 174	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   264: sipush 25290
        //   267: invokestatic 152	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   270: return
        //   271: aload 6
        //   273: ldc 145
        //   275: iconst_2
        //   276: iconst_1
        //   277: invokevirtual 181	com/tencent/mm/plugin/voip/video/e:F	(IIZ)V
        //   280: sipush 25290
        //   283: invokestatic 152	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   286: return
        //   287: astore 5
        //   289: goto -80 -> 209
        //   292: iconst_1
        //   293: istore_2
        //   294: goto -233 -> 61
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	297	0	this	4
        //   1	187	1	i	int
        //   60	234	2	bool1	boolean
        //   6	89	3	bool2	boolean
        //   3	204	4	bool3	boolean
        //   204	17	5	localException1	Exception
        //   237	14	5	localException2	Exception
        //   287	1	5	localException3	Exception
        //   16	256	6	locale	com.tencent.mm.plugin.voip.video.e
        // Exception table:
        //   from	to	target	type
        //   34	61	204	java/lang/Exception
        //   108	157	237	java/lang/Exception
        //   157	173	237	java/lang/Exception
        //   173	197	237	java/lang/Exception
        //   61	94	287	java/lang/Exception
      }
    };
    this.yoo = new com.tencent.mm.plugin.voip.ui.a()
    {
      public final void a(Intent paramAnonymousIntent, BaseSmallView paramAnonymousBaseSmallView)
      {
        AppMethodBeat.i(179650);
        if (!i.eaw().eao())
        {
          paramAnonymousBaseSmallView.aGx(MMApplicationContext.getContext().getString(2131763321));
          AppMethodBeat.o(179650);
          return;
        }
        int i = c.this.dZU();
        paramAnonymousBaseSmallView.aGy(String.format("%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
        AppMethodBeat.o(179650);
      }
      
      public final boolean dZV()
      {
        AppMethodBeat.i(25291);
        if (i.eaw().eal())
        {
          AppMethodBeat.o(25291);
          return true;
        }
        AppMethodBeat.o(25291);
        return false;
      }
    };
    this.yop = 0L;
    AppMethodBeat.o(25294);
  }
  
  public static boolean aBQ(String paramString)
  {
    AppMethodBeat.i(25298);
    Log.d("MicroMsg.IPCallManager", "dialWhenTalking, dialButton: %s", new Object[] { paramString });
    if (!i.eaw().eao())
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
        paramString = i.eat();
        Log.d("MicroMsg.IPCallEngineManager", "sendDTMF: %d", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.ipcall.model.d.b localb = i.eau();
        localb.yrm += 1;
        Log.i("MicroMsg.IPCallReportHelper", "now addCallClickCnt %d", new Object[] { Integer.valueOf(localb.yrm) });
        i = paramString.yqF.SendDTMF(i);
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
  private boolean al(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: sipush 25297
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eas	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   9: getfield 210	com/tencent/mm/plugin/ipcall/model/g:yoW	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   12: astore 15
    //   14: invokestatic 124	com/tencent/mm/plugin/ipcall/model/i:eaw	()Lcom/tencent/mm/plugin/ipcall/model/f;
    //   17: iload_1
    //   18: invokevirtual 214	com/tencent/mm/plugin/ipcall/model/f:OZ	(I)Z
    //   21: ifne +93 -> 114
    //   24: ldc 110
    //   26: ldc 216
    //   28: iconst_1
    //   29: anewarray 4	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: invokestatic 124	com/tencent/mm/plugin/ipcall/model/i:eaw	()Lcom/tencent/mm/plugin/ipcall/model/f;
    //   37: getfield 219	com/tencent/mm/plugin/ipcall/model/f:mAT	I
    //   40: invokestatic 223	com/tencent/mm/plugin/ipcall/model/f:stateToString	(I)Ljava/lang/String;
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
    //   64: getfield 230	com/tencent/mm/plugin/ipcall/model/b/c:ypJ	I
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
    //   131: getfield 230	com/tencent/mm/plugin/ipcall/model/b/c:ypJ	I
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
    //   173: invokestatic 239	com/tencent/mm/plugin/ipcall/model/i:eaC	()Lcom/tencent/mm/plugin/voip/video/e;
    //   176: invokevirtual 244	com/tencent/mm/plugin/voip/video/e:stop	()V
    //   179: invokestatic 239	com/tencent/mm/plugin/ipcall/model/i:eaC	()Lcom/tencent/mm/plugin/voip/video/e;
    //   182: astore 15
    //   184: invokestatic 248	com/tencent/mm/plugin/ipcall/model/i:eav	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   187: getfield 254	com/tencent/mm/plugin/ipcall/model/c/b:yqo	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   190: invokevirtual 259	com/tencent/mm/plugin/ipcall/model/a/a:isSpeakerphoneOn	()Z
    //   193: istore 8
    //   195: aload 15
    //   197: getfield 263	com/tencent/mm/plugin/voip/video/e:mContext	Landroid/content/Context;
    //   200: invokestatic 269	com/tencent/mm/sdk/platformtools/MMApplicationContext:getDefaultPreferencePath	()Ljava/lang/String;
    //   203: iconst_0
    //   204: invokevirtual 275	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   207: ldc_w 277
    //   210: iconst_1
    //   211: invokeinterface 283 3 0
    //   216: pop
    //   217: ldc_w 285
    //   220: invokestatic 291	com/tencent/mm/plugin/audio/c/a:agr	(Ljava/lang/String;)Lcom/tencent/mm/plugin/audio/b/a;
    //   223: iload 8
    //   225: invokevirtual 297	com/tencent/mm/plugin/audio/b/a:cV	(Z)V
    //   228: iload 8
    //   230: ifeq +1475 -> 1705
    //   233: iconst_0
    //   234: invokestatic 300	com/tencent/mm/plugin/audio/c/a:setMode	(I)V
    //   237: ldc_w 302
    //   240: ldc_w 304
    //   243: iconst_3
    //   244: anewarray 4	java/lang/Object
    //   247: dup
    //   248: iconst_0
    //   249: getstatic 310	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   252: aastore
    //   253: dup
    //   254: iconst_1
    //   255: iload 8
    //   257: invokestatic 313	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   260: aastore
    //   261: dup
    //   262: iconst_2
    //   263: iconst_2
    //   264: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   267: aastore
    //   268: invokestatic 180	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: aload 15
    //   273: invokestatic 319	java/lang/System:currentTimeMillis	()J
    //   276: putfield 322	com/tencent/mm/plugin/voip/video/e:Hjh	J
    //   279: new 324	com/tencent/mm/compatible/b/k
    //   282: dup
    //   283: invokespecial 325	com/tencent/mm/compatible/b/k:<init>	()V
    //   286: astore 16
    //   288: aload 16
    //   290: aload 15
    //   292: getfield 263	com/tencent/mm/plugin/voip/video/e:mContext	Landroid/content/Context;
    //   295: new 327	java/lang/StringBuilder
    //   298: dup
    //   299: ldc_w 329
    //   302: invokespecial 332	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   305: aload 15
    //   307: getfield 263	com/tencent/mm/plugin/voip/video/e:mContext	Landroid/content/Context;
    //   310: invokevirtual 335	android/content/Context:getPackageName	()Ljava/lang/String;
    //   313: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc_w 341
    //   319: invokevirtual 339	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 350	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   328: invokevirtual 356	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   331: aload 16
    //   333: new 358	com/tencent/mm/plugin/voip/video/e$7
    //   336: dup
    //   337: aload 15
    //   339: invokespecial 361	com/tencent/mm/plugin/voip/video/e$7:<init>	(Lcom/tencent/mm/plugin/voip/video/e;)V
    //   342: invokevirtual 365	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   345: aload 16
    //   347: new 367	com/tencent/mm/plugin/voip/video/e$8
    //   350: dup
    //   351: aload 15
    //   353: invokespecial 368	com/tencent/mm/plugin/voip/video/e$8:<init>	(Lcom/tencent/mm/plugin/voip/video/e;)V
    //   356: invokevirtual 372	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   359: invokestatic 375	com/tencent/mm/plugin/audio/c/a:ceb	()Z
    //   362: ifne +1992 -> 2354
    //   365: iload 8
    //   367: ifne +1345 -> 1712
    //   370: goto +1984 -> 2354
    //   373: aload 16
    //   375: iload 5
    //   377: invokevirtual 378	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   380: aload 16
    //   382: invokevirtual 381	android/media/MediaPlayer:prepare	()V
    //   385: aload 16
    //   387: iconst_0
    //   388: invokevirtual 384	android/media/MediaPlayer:setLooping	(Z)V
    //   391: aload 16
    //   393: invokevirtual 387	android/media/MediaPlayer:start	()V
    //   396: invokestatic 319	java/lang/System:currentTimeMillis	()J
    //   399: aload 15
    //   401: getfield 322	com/tencent/mm/plugin/voip/video/e:Hjh	J
    //   404: lsub
    //   405: ldc2_w 388
    //   408: lcmp
    //   409: ifle +10 -> 419
    //   412: aload 15
    //   414: bipush 7
    //   416: putfield 392	com/tencent/mm/plugin/voip/video/e:Hjf	I
    //   419: ldc 110
    //   421: ldc_w 394
    //   424: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   427: invokestatic 400	com/tencent/mm/plugin/voip/model/r:fHo	()Lcom/tencent/mm/plugin/voip/model/r;
    //   430: invokevirtual 403	com/tencent/mm/plugin/voip/model/r:fHq	()V
    //   433: invokestatic 400	com/tencent/mm/plugin/voip/model/r:fHo	()Lcom/tencent/mm/plugin/voip/model/r;
    //   436: aconst_null
    //   437: invokevirtual 406	com/tencent/mm/plugin/voip/model/r:a	(Lcom/tencent/mm/plugin/voip/model/r$a;)V
    //   440: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eau	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   443: astore 15
    //   445: invokestatic 248	com/tencent/mm/plugin/ipcall/model/i:eav	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   448: getfield 254	com/tencent/mm/plugin/ipcall/model/c/b:yqo	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   451: getfield 410	com/tencent/mm/plugin/ipcall/model/a/a:ypB	Lcom/tencent/mm/plugin/ipcall/model/c/c;
    //   454: astore 16
    //   456: aload 16
    //   458: ifnull +1306 -> 1764
    //   461: aload 16
    //   463: getfield 416	com/tencent/mm/plugin/ipcall/model/c/c:yqu	Lcom/tencent/mm/audio/b/c;
    //   466: ifnull +1292 -> 1758
    //   469: aload 16
    //   471: getfield 416	com/tencent/mm/plugin/ipcall/model/c/c:yqu	Lcom/tencent/mm/audio/b/c;
    //   474: getfield 421	com/tencent/mm/audio/b/c:dyZ	I
    //   477: istore 5
    //   479: aload 15
    //   481: getfield 424	com/tencent/mm/plugin/ipcall/model/d/b:yrj	I
    //   484: ifne +10 -> 494
    //   487: aload 15
    //   489: iload 5
    //   491: putfield 424	com/tencent/mm/plugin/ipcall/model/d/b:yrj	I
    //   494: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eau	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   497: astore 15
    //   499: invokestatic 248	com/tencent/mm/plugin/ipcall/model/i:eav	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   502: getfield 254	com/tencent/mm/plugin/ipcall/model/c/b:yqo	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   505: getfield 428	com/tencent/mm/plugin/ipcall/model/a/a:ypA	Lcom/tencent/mm/plugin/ipcall/model/c/a;
    //   508: astore 16
    //   510: aload 16
    //   512: ifnull +1264 -> 1776
    //   515: aload 16
    //   517: getfield 434	com/tencent/mm/plugin/ipcall/model/c/a:qrz	Lcom/tencent/mm/plugin/voip/model/c;
    //   520: ifnull +1250 -> 1770
    //   523: ldc_w 436
    //   526: new 327	java/lang/StringBuilder
    //   529: dup
    //   530: ldc_w 438
    //   533: invokespecial 332	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   536: aload 16
    //   538: getfield 434	com/tencent/mm/plugin/ipcall/model/c/a:qrz	Lcom/tencent/mm/plugin/voip/model/c;
    //   541: invokevirtual 443	com/tencent/mm/plugin/voip/model/c:fFs	()I
    //   544: invokevirtual 446	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   547: invokevirtual 344	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokestatic 448	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   553: aload 16
    //   555: getfield 434	com/tencent/mm/plugin/ipcall/model/c/a:qrz	Lcom/tencent/mm/plugin/voip/model/c;
    //   558: invokevirtual 443	com/tencent/mm/plugin/voip/model/c:fFs	()I
    //   561: istore 5
    //   563: aload 15
    //   565: getfield 451	com/tencent/mm/plugin/ipcall/model/d/b:yrk	I
    //   568: ifne +10 -> 578
    //   571: aload 15
    //   573: iload 5
    //   575: putfield 451	com/tencent/mm/plugin/ipcall/model/d/b:yrk	I
    //   578: invokestatic 248	com/tencent/mm/plugin/ipcall/model/i:eav	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   581: astore 15
    //   583: invokestatic 154	com/tencent/mm/plugin/ipcall/model/i:eat	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   586: astore 16
    //   588: aload 15
    //   590: getfield 254	com/tencent/mm/plugin/ipcall/model/c/b:yqo	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   593: astore 17
    //   595: aload 17
    //   597: getfield 428	com/tencent/mm/plugin/ipcall/model/a/a:ypA	Lcom/tencent/mm/plugin/ipcall/model/c/a;
    //   600: astore 18
    //   602: aload 18
    //   604: ifnull +1184 -> 1788
    //   607: aload 18
    //   609: getfield 434	com/tencent/mm/plugin/ipcall/model/c/a:qrz	Lcom/tencent/mm/plugin/voip/model/c;
    //   612: ifnull +1170 -> 1782
    //   615: aload 18
    //   617: getfield 454	com/tencent/mm/plugin/ipcall/model/c/a:isStart	Z
    //   620: ifeq +1162 -> 1782
    //   623: aload 18
    //   625: getfield 434	com/tencent/mm/plugin/ipcall/model/c/a:qrz	Lcom/tencent/mm/plugin/voip/model/c;
    //   628: invokevirtual 457	com/tencent/mm/plugin/voip/model/c:bhV	()I
    //   631: istore 5
    //   633: iload 5
    //   635: iconst_m1
    //   636: if_icmpne +1158 -> 1794
    //   639: iconst_0
    //   640: istore 5
    //   642: aload 16
    //   644: getfield 186	com/tencent/mm/plugin/ipcall/model/d/a:yqF	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   647: iload 5
    //   649: putfield 460	com/tencent/mm/plugin/voip/model/v2protocal:HaY	I
    //   652: aload 15
    //   654: aconst_null
    //   655: putfield 464	com/tencent/mm/plugin/ipcall/model/c/b:gte	Lcom/tencent/mm/ui/MMActivity;
    //   658: aload 15
    //   660: getfield 254	com/tencent/mm/plugin/ipcall/model/c/b:yqo	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   663: astore 17
    //   665: aload 17
    //   667: getfield 428	com/tencent/mm/plugin/ipcall/model/a/a:ypA	Lcom/tencent/mm/plugin/ipcall/model/c/a;
    //   670: astore 18
    //   672: aload 18
    //   674: ifnull +65 -> 739
    //   677: aload 18
    //   679: getfield 454	com/tencent/mm/plugin/ipcall/model/c/a:isStart	Z
    //   682: ifeq +57 -> 739
    //   685: ldc_w 436
    //   688: ldc_w 466
    //   691: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   694: aload 18
    //   696: getfield 469	com/tencent/mm/plugin/ipcall/model/c/a:yql	Ljava/lang/Object;
    //   699: astore 16
    //   701: aload 16
    //   703: monitorenter
    //   704: new 471	com/tencent/mm/plugin/ipcall/model/c/a$a
    //   707: dup
    //   708: aload 18
    //   710: aload 18
    //   712: getfield 434	com/tencent/mm/plugin/ipcall/model/c/a:qrz	Lcom/tencent/mm/plugin/voip/model/c;
    //   715: invokespecial 474	com/tencent/mm/plugin/ipcall/model/c/a$a:<init>	(Lcom/tencent/mm/plugin/ipcall/model/c/a;Lcom/tencent/mm/plugin/voip/model/c;)V
    //   718: ldc_w 476
    //   721: invokestatic 482	com/tencent/mm/sdk/thread/ThreadPool:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   724: aload 18
    //   726: iconst_0
    //   727: putfield 454	com/tencent/mm/plugin/ipcall/model/c/a:isStart	Z
    //   730: aload 18
    //   732: aconst_null
    //   733: putfield 434	com/tencent/mm/plugin/ipcall/model/c/a:qrz	Lcom/tencent/mm/plugin/voip/model/c;
    //   736: aload 16
    //   738: monitorexit
    //   739: aload 17
    //   741: ldc_w 484
    //   744: invokevirtual 487	com/tencent/mm/plugin/ipcall/model/a/a:agq	(Ljava/lang/String;)V
    //   747: aload 17
    //   749: aconst_null
    //   750: putfield 491	com/tencent/mm/plugin/ipcall/model/a/a:ypz	Lcom/tencent/mm/plugin/ipcall/model/a/a$b;
    //   753: aload 17
    //   755: getfield 495	com/tencent/mm/plugin/ipcall/model/a/a:jvG	Lcom/tencent/mm/compatible/util/b;
    //   758: invokevirtual 500	com/tencent/mm/compatible/util/b:apm	()Z
    //   761: pop
    //   762: aload 15
    //   764: aconst_null
    //   765: putfield 504	com/tencent/mm/plugin/ipcall/model/c/b:yqs	Lcom/tencent/mm/plugin/ipcall/ui/j;
    //   768: invokestatic 248	com/tencent/mm/plugin/ipcall/model/i:eav	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   771: astore 16
    //   773: aload 16
    //   775: getfield 254	com/tencent/mm/plugin/ipcall/model/c/b:yqo	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   778: getfield 410	com/tencent/mm/plugin/ipcall/model/a/a:ypB	Lcom/tencent/mm/plugin/ipcall/model/c/c;
    //   781: astore 17
    //   783: aload 17
    //   785: ifnull +79 -> 864
    //   788: aload 17
    //   790: getfield 505	com/tencent/mm/plugin/ipcall/model/c/c:isStart	Z
    //   793: ifeq +71 -> 864
    //   796: ldc_w 507
    //   799: ldc_w 509
    //   802: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   805: aload 17
    //   807: getfield 512	com/tencent/mm/plugin/ipcall/model/c/c:yqv	Ljava/lang/Object;
    //   810: astore 15
    //   812: aload 15
    //   814: monitorenter
    //   815: aload 17
    //   817: getfield 416	com/tencent/mm/plugin/ipcall/model/c/c:yqu	Lcom/tencent/mm/audio/b/c;
    //   820: ifnull +41 -> 861
    //   823: new 514	com/tencent/mm/plugin/ipcall/model/c/c$a
    //   826: dup
    //   827: aload 17
    //   829: aload 17
    //   831: getfield 416	com/tencent/mm/plugin/ipcall/model/c/c:yqu	Lcom/tencent/mm/audio/b/c;
    //   834: invokespecial 517	com/tencent/mm/plugin/ipcall/model/c/c$a:<init>	(Lcom/tencent/mm/plugin/ipcall/model/c/c;Lcom/tencent/mm/audio/b/c;)V
    //   837: ldc_w 519
    //   840: invokestatic 482	com/tencent/mm/sdk/thread/ThreadPool:post	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   843: aload 17
    //   845: aconst_null
    //   846: putfield 416	com/tencent/mm/plugin/ipcall/model/c/c:yqu	Lcom/tencent/mm/audio/b/c;
    //   849: aload 17
    //   851: iconst_0
    //   852: putfield 505	com/tencent/mm/plugin/ipcall/model/c/c:isStart	Z
    //   855: aload 17
    //   857: iconst_0
    //   858: putfield 522	com/tencent/mm/plugin/ipcall/model/c/c:guh	Z
    //   861: aload 15
    //   863: monitorexit
    //   864: aload 16
    //   866: aconst_null
    //   867: putfield 464	com/tencent/mm/plugin/ipcall/model/c/b:gte	Lcom/tencent/mm/ui/MMActivity;
    //   870: invokestatic 154	com/tencent/mm/plugin/ipcall/model/i:eat	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   873: astore 15
    //   875: ldc 156
    //   877: ldc_w 524
    //   880: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   883: aload 15
    //   885: getfield 186	com/tencent/mm/plugin/ipcall/model/d/a:yqF	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   888: iconst_1
    //   889: invokevirtual 528	com/tencent/mm/plugin/voip/model/v2protocal:xh	(Z)Ljava/lang/String;
    //   892: pop
    //   893: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eau	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   896: astore 16
    //   898: aload 16
    //   900: getfield 532	com/tencent/mm/plugin/ipcall/model/d/b:yre	Ljava/lang/String;
    //   903: invokestatic 140	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   906: ifeq +279 -> 1185
    //   909: aload 16
    //   911: getfield 535	com/tencent/mm/plugin/ipcall/model/d/b:yrd	Ljava/lang/String;
    //   914: invokestatic 140	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   917: ifeq +268 -> 1185
    //   920: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eas	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   923: getfield 210	com/tencent/mm/plugin/ipcall/model/g:yoW	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   926: astore 18
    //   928: invokestatic 154	com/tencent/mm/plugin/ipcall/model/i:eat	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   931: getfield 186	com/tencent/mm/plugin/ipcall/model/d/a:yqF	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   934: astore 17
    //   936: aload 16
    //   938: getfield 538	com/tencent/mm/plugin/ipcall/model/d/b:yqT	I
    //   941: iconst_1
    //   942: if_icmpne +911 -> 1853
    //   945: iconst_1
    //   946: istore 5
    //   948: aload 18
    //   950: getfield 541	com/tencent/mm/plugin/ipcall/model/b/c:yqc	I
    //   953: istore 6
    //   955: aload 17
    //   957: getfield 545	com/tencent/mm/plugin/voip/model/v2protocal:Hcs	[B
    //   960: astore 18
    //   962: aload 17
    //   964: getfield 545	com/tencent/mm/plugin/voip/model/v2protocal:Hcs	[B
    //   967: arraylength
    //   968: istore 7
    //   970: iload 5
    //   972: ifeq +887 -> 1859
    //   975: iconst_1
    //   976: istore 5
    //   978: aload 17
    //   980: aload 18
    //   982: iload 7
    //   984: iload 5
    //   986: iload 6
    //   988: invokevirtual 549	com/tencent/mm/plugin/voip/model/v2protocal:getPstnChannelInfo	([BIII)I
    //   991: pop
    //   992: ldc_w 551
    //   995: ldc_w 553
    //   998: iconst_1
    //   999: anewarray 4	java/lang/Object
    //   1002: dup
    //   1003: iconst_0
    //   1004: aload 17
    //   1006: getfield 556	com/tencent/mm/plugin/voip/model/v2protocal:field_pstnChannelInfoLength	I
    //   1009: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1012: aastore
    //   1013: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1016: aload 16
    //   1018: new 142	java/lang/String
    //   1021: dup
    //   1022: aload 17
    //   1024: getfield 545	com/tencent/mm/plugin/voip/model/v2protocal:Hcs	[B
    //   1027: iconst_0
    //   1028: aload 17
    //   1030: getfield 556	com/tencent/mm/plugin/voip/model/v2protocal:field_pstnChannelInfoLength	I
    //   1033: invokespecial 559	java/lang/String:<init>	([BII)V
    //   1036: putfield 532	com/tencent/mm/plugin/ipcall/model/d/b:yre	Ljava/lang/String;
    //   1039: invokestatic 154	com/tencent/mm/plugin/ipcall/model/i:eat	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   1042: getfield 186	com/tencent/mm/plugin/ipcall/model/d/a:yqF	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1045: astore 17
    //   1047: aload 17
    //   1049: aload 17
    //   1051: getfield 562	com/tencent/mm/plugin/voip/model/v2protocal:Hct	[B
    //   1054: aload 17
    //   1056: getfield 562	com/tencent/mm/plugin/voip/model/v2protocal:Hct	[B
    //   1059: arraylength
    //   1060: invokevirtual 566	com/tencent/mm/plugin/voip/model/v2protocal:getPstnEngineInfo	([BI)I
    //   1063: pop
    //   1064: ldc_w 551
    //   1067: ldc_w 568
    //   1070: iconst_1
    //   1071: anewarray 4	java/lang/Object
    //   1074: dup
    //   1075: iconst_0
    //   1076: aload 17
    //   1078: getfield 571	com/tencent/mm/plugin/voip/model/v2protocal:field_pstnEngineInfoLength	I
    //   1081: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1084: aastore
    //   1085: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1088: aload 16
    //   1090: new 142	java/lang/String
    //   1093: dup
    //   1094: aload 17
    //   1096: getfield 562	com/tencent/mm/plugin/voip/model/v2protocal:Hct	[B
    //   1099: iconst_0
    //   1100: aload 17
    //   1102: getfield 571	com/tencent/mm/plugin/voip/model/v2protocal:field_pstnEngineInfoLength	I
    //   1105: invokespecial 559	java/lang/String:<init>	([BII)V
    //   1108: putfield 535	com/tencent/mm/plugin/ipcall/model/d/b:yrd	Ljava/lang/String;
    //   1111: aload 16
    //   1113: invokestatic 154	com/tencent/mm/plugin/ipcall/model/i:eat	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   1116: getfield 186	com/tencent/mm/plugin/ipcall/model/d/a:yqF	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1119: invokevirtual 574	com/tencent/mm/plugin/voip/model/v2protocal:fIY	()Ljava/lang/String;
    //   1122: putfield 577	com/tencent/mm/plugin/ipcall/model/d/b:yrf	Ljava/lang/String;
    //   1125: ldc 176
    //   1127: ldc_w 579
    //   1130: iconst_1
    //   1131: anewarray 4	java/lang/Object
    //   1134: dup
    //   1135: iconst_0
    //   1136: aload 16
    //   1138: getfield 532	com/tencent/mm/plugin/ipcall/model/d/b:yre	Ljava/lang/String;
    //   1141: aastore
    //   1142: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1145: ldc 176
    //   1147: ldc_w 581
    //   1150: iconst_1
    //   1151: anewarray 4	java/lang/Object
    //   1154: dup
    //   1155: iconst_0
    //   1156: aload 16
    //   1158: getfield 535	com/tencent/mm/plugin/ipcall/model/d/b:yrd	Ljava/lang/String;
    //   1161: aastore
    //   1162: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1165: ldc 176
    //   1167: ldc_w 583
    //   1170: iconst_1
    //   1171: anewarray 4	java/lang/Object
    //   1174: dup
    //   1175: iconst_0
    //   1176: aload 16
    //   1178: getfield 577	com/tencent/mm/plugin/ipcall/model/d/b:yrf	Ljava/lang/String;
    //   1181: aastore
    //   1182: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1185: aload 15
    //   1187: getfield 186	com/tencent/mm/plugin/ipcall/model/d/a:yqF	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1190: invokevirtual 586	com/tencent/mm/plugin/voip/model/v2protocal:reset	()V
    //   1193: aload 15
    //   1195: invokevirtual 589	com/tencent/mm/plugin/ipcall/model/d/a:resetStatus	()V
    //   1198: getstatic 69	com/tencent/mm/plugin/ipcall/c:hAk	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   1201: aload_0
    //   1202: getfield 97	com/tencent/mm/plugin/ipcall/c:yom	Ljava/lang/Runnable;
    //   1205: invokevirtual 593	com/tencent/mm/sdk/platformtools/MMHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1208: getstatic 69	com/tencent/mm/plugin/ipcall/c:hAk	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   1211: aload_0
    //   1212: getfield 94	com/tencent/mm/plugin/ipcall/c:yol	Ljava/lang/Runnable;
    //   1215: invokevirtual 593	com/tencent/mm/sdk/platformtools/MMHandler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1218: aload_0
    //   1219: getfield 595	com/tencent/mm/plugin/ipcall/c:timer	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   1222: ifnull +15 -> 1237
    //   1225: aload_0
    //   1226: getfield 595	com/tencent/mm/plugin/ipcall/c:timer	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   1229: invokevirtual 600	com/tencent/mm/sdk/platformtools/MTimerHandler:stopTimer	()V
    //   1232: aload_0
    //   1233: aconst_null
    //   1234: putfield 595	com/tencent/mm/plugin/ipcall/c:timer	Lcom/tencent/mm/sdk/platformtools/MTimerHandler;
    //   1237: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eau	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1240: iload_3
    //   1241: putfield 603	com/tencent/mm/plugin/ipcall/model/d/b:yqV	I
    //   1244: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eau	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1247: astore 15
    //   1249: ldc 176
    //   1251: ldc_w 605
    //   1254: invokestatic 448	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1257: aload 15
    //   1259: getfield 608	com/tencent/mm/plugin/ipcall/model/d/b:yrc	J
    //   1262: lconst_0
    //   1263: lcmp
    //   1264: ifne +64 -> 1328
    //   1267: aload 15
    //   1269: getfield 611	com/tencent/mm/plugin/ipcall/model/d/b:yrb	J
    //   1272: lconst_0
    //   1273: lcmp
    //   1274: ifeq +54 -> 1328
    //   1277: aload 15
    //   1279: invokestatic 319	java/lang/System:currentTimeMillis	()J
    //   1282: putfield 608	com/tencent/mm/plugin/ipcall/model/d/b:yrc	J
    //   1285: aload 15
    //   1287: aload 15
    //   1289: getfield 608	com/tencent/mm/plugin/ipcall/model/d/b:yrc	J
    //   1292: aload 15
    //   1294: getfield 611	com/tencent/mm/plugin/ipcall/model/d/b:yrb	J
    //   1297: lsub
    //   1298: ldc2_w 612
    //   1301: ldiv
    //   1302: putfield 616	com/tencent/mm/plugin/ipcall/model/d/b:yqU	J
    //   1305: ldc 176
    //   1307: ldc_w 618
    //   1310: iconst_1
    //   1311: anewarray 4	java/lang/Object
    //   1314: dup
    //   1315: iconst_0
    //   1316: aload 15
    //   1318: getfield 616	com/tencent/mm/plugin/ipcall/model/d/b:yqU	J
    //   1321: invokestatic 623	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1324: aastore
    //   1325: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1328: iload_1
    //   1329: bipush 8
    //   1331: if_icmpne +534 -> 1865
    //   1334: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eas	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1337: invokevirtual 626	com/tencent/mm/plugin/ipcall/model/g:eap	()V
    //   1340: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eau	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1343: invokevirtual 629	com/tencent/mm/plugin/ipcall/model/d/b:eaP	()V
    //   1346: aload_0
    //   1347: getfield 631	com/tencent/mm/plugin/ipcall/c:yog	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1350: astore 15
    //   1352: aload 15
    //   1354: ifnull +53 -> 1407
    //   1357: ldc_w 633
    //   1360: ldc_w 635
    //   1363: iconst_1
    //   1364: anewarray 4	java/lang/Object
    //   1367: dup
    //   1368: iconst_0
    //   1369: aload 15
    //   1371: getfield 640	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   1374: invokestatic 623	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1377: aastore
    //   1378: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1381: aload 15
    //   1383: getfield 640	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   1386: ldc2_w 641
    //   1389: lcmp
    //   1390: ifeq +17 -> 1407
    //   1393: aload 15
    //   1395: iconst_2
    //   1396: putfield 645	com/tencent/mm/plugin/ipcall/model/h/k:field_status	I
    //   1399: invokestatic 649	com/tencent/mm/plugin/ipcall/model/i:eaz	()Lcom/tencent/mm/plugin/ipcall/model/h/l;
    //   1402: aload 15
    //   1404: invokevirtual 654	com/tencent/mm/plugin/ipcall/model/h/l:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)V
    //   1407: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eas	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1410: getfield 657	com/tencent/mm/plugin/ipcall/model/g:dWM	Z
    //   1413: ifeq +186 -> 1599
    //   1416: aload_0
    //   1417: getfield 659	com/tencent/mm/plugin/ipcall/c:yon	Z
    //   1420: ifne +891 -> 2311
    //   1423: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eas	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1426: getfield 210	com/tencent/mm/plugin/ipcall/model/g:yoW	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   1429: getfield 233	com/tencent/mm/plugin/ipcall/model/b/c:roomId	I
    //   1432: ifeq +879 -> 2311
    //   1435: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eas	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1438: getfield 210	com/tencent/mm/plugin/ipcall/model/g:yoW	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   1441: getfield 662	com/tencent/mm/plugin/ipcall/model/b/c:ypI	J
    //   1444: lconst_0
    //   1445: lcmp
    //   1446: ifeq +865 -> 2311
    //   1449: invokestatic 666	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1452: astore 15
    //   1454: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eas	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1457: getfield 210	com/tencent/mm/plugin/ipcall/model/g:yoW	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   1460: getfield 233	com/tencent/mm/plugin/ipcall/model/b/c:roomId	I
    //   1463: istore_2
    //   1464: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eas	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1467: getfield 210	com/tencent/mm/plugin/ipcall/model/g:yoW	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   1470: getfield 662	com/tencent/mm/plugin/ipcall/model/b/c:ypI	J
    //   1473: lstore 9
    //   1475: ldc_w 668
    //   1478: ldc_w 670
    //   1481: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1484: invokestatic 675	com/tencent/mm/plugin/ipcall/d:dZW	()Z
    //   1487: ifeq +112 -> 1599
    //   1490: invokestatic 681	com/tencent/mm/n/h:aqJ	()Lcom/tencent/mm/n/f;
    //   1493: ldc_w 683
    //   1496: iconst_0
    //   1497: invokevirtual 689	com/tencent/mm/n/f:getInt	(Ljava/lang/String;I)I
    //   1500: istore_3
    //   1501: invokestatic 695	com/tencent/mm/model/bg:aVF	()Lcom/tencent/mm/model/c;
    //   1504: pop
    //   1505: invokestatic 701	com/tencent/mm/model/c:azQ	()Lcom/tencent/mm/storage/ao;
    //   1508: getstatic 707	com/tencent/mm/storage/ar$a:NVG	Lcom/tencent/mm/storage/ar$a;
    //   1511: iconst_0
    //   1512: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1515: invokevirtual 713	com/tencent/mm/storage/ao:get	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   1518: checkcast 160	java/lang/Integer
    //   1521: invokevirtual 716	java/lang/Integer:intValue	()I
    //   1524: istore_1
    //   1525: invokestatic 695	com/tencent/mm/model/bg:aVF	()Lcom/tencent/mm/model/c;
    //   1528: pop
    //   1529: invokestatic 701	com/tencent/mm/model/c:azQ	()Lcom/tencent/mm/storage/ao;
    //   1532: getstatic 719	com/tencent/mm/storage/ar$a:NVF	Lcom/tencent/mm/storage/ar$a;
    //   1535: lconst_0
    //   1536: invokestatic 623	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1539: invokevirtual 713	com/tencent/mm/storage/ao:get	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   1542: checkcast 620	java/lang/Long
    //   1545: invokevirtual 722	java/lang/Long:longValue	()J
    //   1548: lstore 11
    //   1550: invokestatic 725	com/tencent/mm/sdk/platformtools/Util:nowSecond	()J
    //   1553: lstore 13
    //   1555: lload 13
    //   1557: lload 11
    //   1559: lsub
    //   1560: ldc2_w 726
    //   1563: lcmp
    //   1564: ifle +787 -> 2351
    //   1567: iconst_0
    //   1568: istore_1
    //   1569: ldc_w 668
    //   1572: ldc_w 729
    //   1575: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1578: iload_1
    //   1579: iload_3
    //   1580: if_icmplt +624 -> 2204
    //   1583: ldc_w 668
    //   1586: ldc_w 731
    //   1589: iload_3
    //   1590: invokestatic 733	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1593: invokevirtual 737	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1596: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1599: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eas	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1602: aconst_null
    //   1603: putfield 741	com/tencent/mm/plugin/ipcall/model/g:yoN	Lcom/tencent/mm/plugin/ipcall/model/g$a;
    //   1606: invokestatic 154	com/tencent/mm/plugin/ipcall/model/i:eat	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   1609: aconst_null
    //   1610: putfield 745	com/tencent/mm/plugin/ipcall/model/d/a:yqK	Lcom/tencent/mm/plugin/ipcall/model/d/a$a;
    //   1613: invokestatic 124	com/tencent/mm/plugin/ipcall/model/i:eaw	()Lcom/tencent/mm/plugin/ipcall/model/f;
    //   1616: iconst_m1
    //   1617: putfield 219	com/tencent/mm/plugin/ipcall/model/f:mAT	I
    //   1620: invokestatic 749	com/tencent/mm/plugin/ipcall/model/i:eaq	()Lcom/tencent/mm/plugin/ipcall/model/i;
    //   1623: pop
    //   1624: invokestatic 752	com/tencent/mm/plugin/ipcall/model/a/a:unInit	()V
    //   1627: aload_0
    //   1628: iconst_1
    //   1629: invokevirtual 755	com/tencent/mm/plugin/ipcall/c:qm	(Z)V
    //   1632: aload_0
    //   1633: invokespecial 758	com/tencent/mm/plugin/ipcall/c:removeListener	()V
    //   1636: ldc 110
    //   1638: ldc_w 760
    //   1641: iconst_0
    //   1642: anewarray 4	java/lang/Object
    //   1645: invokestatic 763	com/tencent/mm/sdk/platformtools/Log:printInfoStack	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1648: bipush 26
    //   1650: invokestatic 768	com/tencent/mm/compatible/util/d:oD	(I)Z
    //   1653: ifeq +44 -> 1697
    //   1656: new 770	android/content/Intent
    //   1659: dup
    //   1660: invokespecial 771	android/content/Intent:<init>	()V
    //   1663: astore 15
    //   1665: aload 15
    //   1667: invokestatic 666	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1670: ldc_w 773
    //   1673: invokevirtual 777	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   1676: pop
    //   1677: invokestatic 666	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   1680: aload 15
    //   1682: invokevirtual 781	android/content/Context:stopService	(Landroid/content/Intent;)Z
    //   1685: pop
    //   1686: iconst_1
    //   1687: istore_1
    //   1688: iload_1
    //   1689: ifeq +8 -> 1697
    //   1692: aload_0
    //   1693: iconst_0
    //   1694: putfield 79	com/tencent/mm/plugin/ipcall/c:yoj	Z
    //   1697: sipush 25297
    //   1700: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1703: iconst_1
    //   1704: ireturn
    //   1705: iconst_2
    //   1706: invokestatic 300	com/tencent/mm/plugin/audio/c/a:setMode	(I)V
    //   1709: goto -1472 -> 237
    //   1712: iconst_2
    //   1713: istore 5
    //   1715: goto -1342 -> 373
    //   1718: astore 17
    //   1720: ldc_w 302
    //   1723: ldc_w 783
    //   1726: iconst_1
    //   1727: anewarray 4	java/lang/Object
    //   1730: dup
    //   1731: iconst_0
    //   1732: aload 17
    //   1734: aastore
    //   1735: invokestatic 786	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1738: aload 15
    //   1740: bipush 6
    //   1742: putfield 392	com/tencent/mm/plugin/voip/video/e:Hjf	I
    //   1745: aload 16
    //   1747: invokevirtual 787	android/media/MediaPlayer:stop	()V
    //   1750: aload 16
    //   1752: invokevirtual 790	android/media/MediaPlayer:release	()V
    //   1755: goto -1336 -> 419
    //   1758: iconst_0
    //   1759: istore 5
    //   1761: goto -1282 -> 479
    //   1764: iconst_0
    //   1765: istore 5
    //   1767: goto -1288 -> 479
    //   1770: iconst_0
    //   1771: istore 5
    //   1773: goto -1210 -> 563
    //   1776: iconst_0
    //   1777: istore 5
    //   1779: goto -1216 -> 563
    //   1782: iconst_m1
    //   1783: istore 5
    //   1785: goto -1152 -> 633
    //   1788: iconst_0
    //   1789: istore 5
    //   1791: goto -1158 -> 633
    //   1794: aload 17
    //   1796: iload 5
    //   1798: invokevirtual 793	com/tencent/mm/plugin/ipcall/model/a/a:getStreamMaxVolume	(I)I
    //   1801: i2f
    //   1802: fstore 4
    //   1804: aload 17
    //   1806: iload 5
    //   1808: invokevirtual 796	com/tencent/mm/plugin/ipcall/model/a/a:getStreamVolume	(I)I
    //   1811: i2f
    //   1812: fload 4
    //   1814: fdiv
    //   1815: ldc_w 797
    //   1818: fmul
    //   1819: f2i
    //   1820: istore 5
    //   1822: goto -1180 -> 642
    //   1825: astore 15
    //   1827: aload 16
    //   1829: monitorexit
    //   1830: sipush 25297
    //   1833: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1836: aload 15
    //   1838: athrow
    //   1839: astore 16
    //   1841: aload 15
    //   1843: monitorexit
    //   1844: sipush 25297
    //   1847: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1850: aload 16
    //   1852: athrow
    //   1853: iconst_0
    //   1854: istore 5
    //   1856: goto -908 -> 948
    //   1859: iconst_0
    //   1860: istore 5
    //   1862: goto -884 -> 978
    //   1865: iload_1
    //   1866: bipush 12
    //   1868: if_icmpne +97 -> 1965
    //   1871: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eas	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1874: invokevirtual 626	com/tencent/mm/plugin/ipcall/model/g:eap	()V
    //   1877: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eau	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1880: invokevirtual 629	com/tencent/mm/plugin/ipcall/model/d/b:eaP	()V
    //   1883: iload_2
    //   1884: bipush 11
    //   1886: if_icmpne +14 -> 1900
    //   1889: aload_0
    //   1890: getfield 631	com/tencent/mm/plugin/ipcall/c:yog	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1893: invokestatic 803	com/tencent/mm/plugin/ipcall/model/h/m:b	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1896: pop
    //   1897: goto -490 -> 1407
    //   1900: aload_0
    //   1901: getfield 631	com/tencent/mm/plugin/ipcall/c:yog	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1904: astore 15
    //   1906: aload 15
    //   1908: ifnull -501 -> 1407
    //   1911: ldc_w 633
    //   1914: ldc_w 805
    //   1917: iconst_1
    //   1918: anewarray 4	java/lang/Object
    //   1921: dup
    //   1922: iconst_0
    //   1923: aload 15
    //   1925: getfield 640	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   1928: invokestatic 623	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1931: aastore
    //   1932: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1935: aload 15
    //   1937: getfield 640	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   1940: ldc2_w 641
    //   1943: lcmp
    //   1944: ifeq -537 -> 1407
    //   1947: aload 15
    //   1949: bipush 6
    //   1951: putfield 645	com/tencent/mm/plugin/ipcall/model/h/k:field_status	I
    //   1954: invokestatic 649	com/tencent/mm/plugin/ipcall/model/i:eaz	()Lcom/tencent/mm/plugin/ipcall/model/h/l;
    //   1957: aload 15
    //   1959: invokevirtual 654	com/tencent/mm/plugin/ipcall/model/h/l:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)V
    //   1962: goto -555 -> 1407
    //   1965: iload_1
    //   1966: bipush 9
    //   1968: if_icmpne +33 -> 2001
    //   1971: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eas	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1974: iconst_1
    //   1975: invokevirtual 808	com/tencent/mm/plugin/ipcall/model/g:Pb	(I)V
    //   1978: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eau	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1981: invokevirtual 811	com/tencent/mm/plugin/ipcall/model/d/b:eaO	()V
    //   1984: aload_0
    //   1985: getfield 631	com/tencent/mm/plugin/ipcall/c:yog	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1988: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eau	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1991: getfield 616	com/tencent/mm/plugin/ipcall/model/d/b:yqU	J
    //   1994: invokestatic 814	com/tencent/mm/plugin/ipcall/model/h/m:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;J)Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1997: pop
    //   1998: goto -591 -> 1407
    //   2001: iload_1
    //   2002: bipush 10
    //   2004: if_icmpne +116 -> 2120
    //   2007: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eas	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   2010: iconst_1
    //   2011: invokevirtual 808	com/tencent/mm/plugin/ipcall/model/g:Pb	(I)V
    //   2014: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eau	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   2017: astore 15
    //   2019: ldc 176
    //   2021: ldc_w 816
    //   2024: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2027: aload 15
    //   2029: iconst_1
    //   2030: putfield 819	com/tencent/mm/plugin/ipcall/model/d/b:yqO	I
    //   2033: aload_0
    //   2034: getfield 631	com/tencent/mm/plugin/ipcall/c:yog	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2037: astore 15
    //   2039: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eau	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   2042: getfield 616	com/tencent/mm/plugin/ipcall/model/d/b:yqU	J
    //   2045: lstore 9
    //   2047: aload 15
    //   2049: ifnull -642 -> 1407
    //   2052: ldc_w 633
    //   2055: ldc_w 821
    //   2058: iconst_2
    //   2059: anewarray 4	java/lang/Object
    //   2062: dup
    //   2063: iconst_0
    //   2064: aload 15
    //   2066: getfield 640	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   2069: invokestatic 623	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2072: aastore
    //   2073: dup
    //   2074: iconst_1
    //   2075: lload 9
    //   2077: invokestatic 623	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2080: aastore
    //   2081: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2084: aload 15
    //   2086: getfield 640	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   2089: ldc2_w 641
    //   2092: lcmp
    //   2093: ifeq -686 -> 1407
    //   2096: aload 15
    //   2098: iconst_5
    //   2099: putfield 645	com/tencent/mm/plugin/ipcall/model/h/k:field_status	I
    //   2102: aload 15
    //   2104: lload 9
    //   2106: putfield 824	com/tencent/mm/plugin/ipcall/model/h/k:field_duration	J
    //   2109: invokestatic 649	com/tencent/mm/plugin/ipcall/model/i:eaz	()Lcom/tencent/mm/plugin/ipcall/model/h/l;
    //   2112: aload 15
    //   2114: invokevirtual 654	com/tencent/mm/plugin/ipcall/model/h/l:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)V
    //   2117: goto -710 -> 1407
    //   2120: iload_1
    //   2121: bipush 11
    //   2123: if_icmpne -716 -> 1407
    //   2126: iload_2
    //   2127: iconst_5
    //   2128: if_icmpne +33 -> 2161
    //   2131: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eas	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   2134: iconst_3
    //   2135: invokevirtual 808	com/tencent/mm/plugin/ipcall/model/g:Pb	(I)V
    //   2138: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eau	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   2141: invokevirtual 811	com/tencent/mm/plugin/ipcall/model/d/b:eaO	()V
    //   2144: iload_2
    //   2145: bipush 11
    //   2147: if_icmpne +40 -> 2187
    //   2150: aload_0
    //   2151: getfield 631	com/tencent/mm/plugin/ipcall/c:yog	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2154: invokestatic 803	com/tencent/mm/plugin/ipcall/model/h/m:b	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2157: pop
    //   2158: goto -751 -> 1407
    //   2161: iload_2
    //   2162: bipush 11
    //   2164: if_icmpne +13 -> 2177
    //   2167: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eas	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   2170: iconst_1
    //   2171: invokevirtual 808	com/tencent/mm/plugin/ipcall/model/g:Pb	(I)V
    //   2174: goto -36 -> 2138
    //   2177: invokestatic 204	com/tencent/mm/plugin/ipcall/model/i:eas	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   2180: iconst_2
    //   2181: invokevirtual 808	com/tencent/mm/plugin/ipcall/model/g:Pb	(I)V
    //   2184: goto -46 -> 2138
    //   2187: aload_0
    //   2188: getfield 631	com/tencent/mm/plugin/ipcall/c:yog	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2191: invokestatic 168	com/tencent/mm/plugin/ipcall/model/i:eau	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   2194: getfield 616	com/tencent/mm/plugin/ipcall/model/d/b:yqU	J
    //   2197: invokestatic 814	com/tencent/mm/plugin/ipcall/model/h/m:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;J)Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2200: pop
    //   2201: goto -794 -> 1407
    //   2204: lload 13
    //   2206: lload 11
    //   2208: lsub
    //   2209: ldc2_w 825
    //   2212: lcmp
    //   2213: ifge +15 -> 2228
    //   2216: ldc_w 668
    //   2219: ldc_w 828
    //   2222: invokestatic 135	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2225: goto -626 -> 1599
    //   2228: invokestatic 695	com/tencent/mm/model/bg:aVF	()Lcom/tencent/mm/model/c;
    //   2231: pop
    //   2232: invokestatic 701	com/tencent/mm/model/c:azQ	()Lcom/tencent/mm/storage/ao;
    //   2235: getstatic 707	com/tencent/mm/storage/ar$a:NVG	Lcom/tencent/mm/storage/ar$a;
    //   2238: iload_1
    //   2239: iconst_1
    //   2240: iadd
    //   2241: invokestatic 164	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2244: invokevirtual 832	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   2247: invokestatic 695	com/tencent/mm/model/bg:aVF	()Lcom/tencent/mm/model/c;
    //   2250: pop
    //   2251: invokestatic 701	com/tencent/mm/model/c:azQ	()Lcom/tencent/mm/storage/ao;
    //   2254: getstatic 719	com/tencent/mm/storage/ar$a:NVF	Lcom/tencent/mm/storage/ar$a;
    //   2257: lload 13
    //   2259: invokestatic 623	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2262: invokevirtual 832	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
    //   2265: new 770	android/content/Intent
    //   2268: dup
    //   2269: invokespecial 771	android/content/Intent:<init>	()V
    //   2272: astore 16
    //   2274: aload 16
    //   2276: ldc_w 834
    //   2279: iload_2
    //   2280: invokevirtual 838	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2283: pop
    //   2284: aload 16
    //   2286: ldc_w 840
    //   2289: lload 9
    //   2291: invokevirtual 843	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   2294: pop
    //   2295: aload 15
    //   2297: ldc_w 484
    //   2300: ldc_w 845
    //   2303: aload 16
    //   2305: invokestatic 850	com/tencent/mm/br/c:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   2308: goto -709 -> 1599
    //   2311: ldc 110
    //   2313: ldc_w 852
    //   2316: invokestatic 855	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2319: goto -720 -> 1599
    //   2322: astore 15
    //   2324: ldc 110
    //   2326: aload 15
    //   2328: ldc_w 857
    //   2331: iconst_1
    //   2332: anewarray 4	java/lang/Object
    //   2335: dup
    //   2336: iconst_0
    //   2337: aload 15
    //   2339: invokevirtual 860	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2342: aastore
    //   2343: invokestatic 864	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2346: iconst_0
    //   2347: istore_1
    //   2348: goto -660 -> 1688
    //   2351: goto -773 -> 1578
    //   2354: iconst_0
    //   2355: istore 5
    //   2357: goto -1984 -> 373
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2360	0	this	c
    //   0	2360	1	paramInt1	int
    //   0	2360	2	paramInt2	int
    //   0	2360	3	paramInt3	int
    //   1802	11	4	f	float
    //   375	1981	5	i	int
    //   953	34	6	j	int
    //   968	15	7	k	int
    //   193	173	8	bool	boolean
    //   1473	817	9	l1	long
    //   1548	659	11	l2	long
    //   1553	705	13	l3	long
    //   1825	17	15	localObject2	Object
    //   1904	392	15	localObject3	Object
    //   2322	16	15	localException	Exception
    //   1839	12	16	localObject5	Object
    //   2272	32	16	localIntent	Intent
    //   593	508	17	localObject6	Object
    //   1718	87	17	localThrowable	java.lang.Throwable
    //   600	381	18	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   288	365	1718	java/lang/Throwable
    //   373	419	1718	java/lang/Throwable
    //   704	739	1825	finally
    //   1827	1830	1825	finally
    //   815	861	1839	finally
    //   861	864	1839	finally
    //   1841	1844	1839	finally
    //   1656	1686	2322	java/lang/Exception
  }
  
  private void bpu()
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
          c.this.dZT();
          if ((i.eaw().eao()) && (c.a(c.this) != null)) {
            c.a(c.this).eaa();
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
    if (this.yoi != null)
    {
      TelephonyManager localTelephonyManager = this.yoi;
      Object localObject = this.mtH;
      localObject = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localTelephonyManager, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/ipcall/IPCallManager", "removeListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      localTelephonyManager.listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(1)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(localTelephonyManager, "com/tencent/mm/plugin/ipcall/IPCallManager", "removeListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
      this.yoi = null;
    }
    EventCenter.instance.removeListener(this.yok);
    AppMethodBeat.o(25295);
  }
  
  public final void OX(int paramInt)
  {
    AppMethodBeat.i(25315);
    Log.i("MicroMsg.IPCallManager", "onChannelConnectFailed, currentState: %s", new Object[] { f.stateToString(i.eaw().mAT) });
    if (i.eat().yqI)
    {
      Log.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel already connected");
      if (gP(5, paramInt))
      {
        g(5, null, MMApplicationContext.getContext().getString(2131756921), 1);
        AppMethodBeat.o(25315);
      }
    }
    else
    {
      Log.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel not connet, may be request connect failed");
      if (gP(4, paramInt)) {
        g(4, null, MMApplicationContext.getContext().getString(2131756921), 1);
      }
    }
    AppMethodBeat.o(25315);
  }
  
  public final void X(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(25300);
    Log.i("MicroMsg.IPCallManager", "onInviteFailed, currentState: %s", new Object[] { f.stateToString(i.eaw().mAT) });
    if (gP(2, 0)) {
      g(2, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(25300);
  }
  
  public final void Y(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(25309);
    Log.i("MicroMsg.IPCallManager", "onAccountOverdue, currentState: %s", new Object[] { f.stateToString(i.eaw().mAT) });
    if (gP(8, 9)) {
      g(8, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(25309);
  }
  
  public final void Z(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(25310);
    Log.i("MicroMsg.IPCallManager", "onCallRestricted, currentState: %s", new Object[] { f.stateToString(i.eaw().mAT) });
    if (gP(10, 0)) {
      g(10, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(25310);
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25296);
    if (i.eaw().eal())
    {
      Log.i("MicroMsg.IPCallManager", "startIPCall, already start!");
      AppMethodBeat.o(25296);
      return false;
    }
    Log.i("MicroMsg.IPCallManager", "startIPCall");
    i.eas().yoN = this;
    i.eat().yqK = this;
    i.eaw().mAT = -1;
    removeListener();
    this.yoi = ((TelephonyManager)MMApplicationContext.getContext().getSystemService("phone"));
    Object localObject1 = this.yoi;
    Object localObject2 = this.mtH;
    localObject2 = com.tencent.mm.hellhoundlib.b.c.a(32, new com.tencent.mm.hellhoundlib.b.a()).bl(localObject2);
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/ipcall/IPCallManager", "addListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    ((TelephonyManager)localObject1).listen((PhoneStateListener)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0), ((Integer)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(1)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/ipcall/IPCallManager", "addListener", "()V", "android/telephony/TelephonyManager_EXEC_", "listen", "(Landroid/telephony/PhoneStateListener;I)V");
    EventCenter.instance.addListener(this.yok);
    Log.d("MicroMsg.IPCallRecordStorageLogic", "recordStartCall, phoneNumber: %s, contactId: %s", new Object[] { paramString4, paramString5 });
    localObject1 = new k();
    ((k)localObject1).field_phonenumber = paramString4;
    if (!Util.isNullOrNil(paramString5))
    {
      localObject2 = i.eay().aBV(paramString5);
      if ((localObject2 != null) && (((com.tencent.mm.plugin.ipcall.model.h.c)localObject2).systemRowid != -1L))
      {
        ((k)localObject1).field_addressId = ((com.tencent.mm.plugin.ipcall.model.h.c)localObject2).systemRowid;
        if (paramInt1 == -1) {
          break label960;
        }
        ((k)localObject1).field_phoneType = paramInt1;
        label296:
        ((k)localObject1).field_calltime = Util.nowMilliSecond();
        ((k)localObject1).field_status = 1;
        if (!i.eaz().insert((IAutoDBItem)localObject1)) {
          break label969;
        }
        label321:
        this.yog = ((k)localObject1);
        hAk.postDelayed(this.yom, 1754L);
        this.yoh = false;
        localObject1 = i.eau();
        Log.d("MicroMsg.IPCallReportHelper", "reset");
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yqM = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yqN = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yqO = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yqP = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yqQ = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yqR = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yqS = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yqT = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yqU = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yqV = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).roomId = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).ypH = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yqW = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).kik = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yqX = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yqY = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yra = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yqZ = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yop = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yrb = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yrc = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yrh = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yrg = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yrd = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yre = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).countryCode = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yri = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yrj = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yrk = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yrl = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject1).yrm = 0;
        i.eaw().mAT = -1;
        Log.d("MicroMsg.IPCallManager", "startIPCall, username: %s, phoneNumber: %s", new Object[] { paramString3, paramString4 });
        localObject1 = i.eas();
        Log.d("MicroMsg.IPCallSvrLogic", "startIPCall, toUsername: %s, toPhoneNumber: %s", new Object[] { paramString3, paramString4 });
        ((g)localObject1).dWM = false;
        ((g)localObject1).yoX = false;
        ((g)localObject1).yoI = 0;
        ((g)localObject1).yoJ = 0;
        ((g)localObject1).yoK = 0;
        ((g)localObject1).yoL = false;
        ((g)localObject1).yoM = false;
        ((g)localObject1).yoY = false;
        ((g)localObject1).yoW = new com.tencent.mm.plugin.ipcall.model.b.c();
        ((g)localObject1).yoW.nickname = paramString1;
        ((g)localObject1).yoW.yqh = paramString2;
        ((g)localObject1).yoW.edf = paramString5;
        ((g)localObject1).yoW.yqi = paramString4;
        ((g)localObject1).yoW.dkV = paramString3;
        ((g)localObject1).yoW.ypJ = ((int)System.currentTimeMillis());
        ((g)localObject1).yoW.ypK = paramInt2;
        ((g)localObject1).yoW.ypL = paramInt3;
        ((g)localObject1).yoW.phoneType = paramInt1;
        ((g)localObject1).yoO.a(((g)localObject1).yoW);
        ((g)localObject1).yoT.a(((g)localObject1).yoW);
        Log.i("MicroMsg.IPCallSvrLogic", "startIPCallInternal, inviteId: %d", new Object[] { Integer.valueOf(((g)localObject1).yoW.ypJ) });
        i.eaw().OZ(1);
        paramString1 = i.eat();
        if (!paramString1.yqJ) {
          break label975;
        }
        Log.d("MicroMsg.IPCallEngineManager", "already start engine");
      }
    }
    for (;;)
    {
      hAk.removeCallbacks(this.yol);
      hAk.postDelayed(this.yol, 60000L);
      Log.printInfoStack("MicroMsg.IPCallManager", "bindIPCallForegroundIfNeed", new Object[0]);
      if ((com.tencent.mm.compatible.util.d.oD(26)) && (!this.yoj))
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
        this.yoj = true;
      }
      AppMethodBeat.o(25296);
      return true;
      ((k)localObject1).field_addressId = -1L;
      break;
      ((k)localObject1).field_addressId = -1L;
      break;
      label960:
      ((k)localObject1).field_phoneType = -1;
      break label296;
      label969:
      localObject1 = null;
      break label321;
      label975:
      paramString1.resetStatus();
      Log.i("MicroMsg.IPCallEngineManager", "start engine");
      if (paramString1.yqF.fIZ())
      {
        paramString1.yqF.xh(false);
        paramString1.yqF.reset();
      }
      paramString1.yqF.Hav = 1;
      l = System.currentTimeMillis();
      paramInt1 = paramString1.yqF.fJb();
      Log.d("MicroMsg.IPCallEngineManager", "protocal init finish, ret: %d, used %dms", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() - l) });
      if ((paramString1.yqF.field_capInfo != null) && (paramString1.yqF.exchangeCabInfo(paramString1.yqF.field_capInfo, paramString1.yqF.field_capInfo.length) < 0))
      {
        Log.e("MicroMsg.IPCallEngineManager", "exchangeCabInfo failed");
        i.eau().yqV = 24;
      }
      if (paramInt1 < 0) {
        Log.e("MicroMsg.IPCallEngineManager", "engine init failed!");
      }
      paramString1.yqF.Hav = 1;
      paramString1.yqJ = true;
    }
  }
  
  public final void aa(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(25311);
    Log.i("MicroMsg.IPCallManager", "onCallPhoneNumberInvalid, currentState: %s", new Object[] { f.stateToString(i.eaw().mAT) });
    if (gP(11, 0)) {
      g(11, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(25311);
  }
  
  public final void dZI()
  {
    AppMethodBeat.i(25299);
    Log.i("MicroMsg.IPCallManager", "onInviteSuccess");
    if (!i.eaw().OZ(3))
    {
      AppMethodBeat.o(25299);
      return;
    }
    Object localObject = i.eau();
    Log.d("MicroMsg.IPCallReportHelper", "markStartInvite");
    if (((com.tencent.mm.plugin.ipcall.model.d.b)localObject).yqZ == 0L) {
      ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).yqZ = System.currentTimeMillis();
    }
    localObject = i.eas().yoW;
    com.tencent.mm.plugin.ipcall.model.d.b localb = i.eau();
    int i = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).ypJ;
    String str1 = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).dkV;
    String str2 = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).yqi;
    int j = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).roomId;
    long l1 = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).ypH;
    long l2 = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).ypI;
    localb.ypJ = i;
    localb.yqY = str1;
    localb.kik = str2;
    localb.roomId = j;
    localb.ypH = l1;
    localb.yqW = l2;
    if (this.yof != null) {
      this.yof.dZI();
    }
    AppMethodBeat.o(25299);
  }
  
  public final void dZJ()
  {
    AppMethodBeat.i(25301);
    Log.i("MicroMsg.IPCallManager", "onStartRing, currentState: %s", new Object[] { f.stateToString(i.eaw().mAT) });
    if (!i.eaw().OZ(4))
    {
      AppMethodBeat.o(25301);
      return;
    }
    com.tencent.mm.plugin.ipcall.model.d.b localb = i.eau();
    Log.d("MicroMsg.IPCallReportHelper", "markStartRing");
    if (localb.yra == 0L)
    {
      localb.yra = System.currentTimeMillis();
      localb.yqR = (localb.yra - localb.yqZ);
      Log.d("MicroMsg.IPCallReportHelper", "ringTime: %d", new Object[] { Long.valueOf(localb.yqR) });
    }
    i.eat().eaN();
    localb = i.eau();
    Log.i("MicroMsg.IPCallReportHelper", "startRing");
    localb.yqM = 1;
    if (this.yof != null) {
      this.yof.dZJ();
    }
    AppMethodBeat.o(25301);
  }
  
  public final void dZK()
  {
    AppMethodBeat.i(25302);
    Log.i("MicroMsg.IPCallManager", "onAccept, currentState: %s", new Object[] { f.stateToString(i.eaw().mAT) });
    if (!i.eaw().OZ(5))
    {
      AppMethodBeat.o(25302);
      return;
    }
    com.tencent.mm.plugin.ipcall.model.d.b localb = i.eau();
    Log.d("MicroMsg.IPCallReportHelper", "markUserAccept");
    if (localb.yop == 0L)
    {
      localb.yop = System.currentTimeMillis();
      localb.yqS = (localb.yop - localb.yqZ);
      Log.d("MicroMsg.IPCallReportHelper", "answerTime: %d", new Object[] { Long.valueOf(localb.yqS) });
    }
    i.eat().eaN();
    localb = i.eau();
    Log.i("MicroMsg.IPCallReportHelper", "userAccept");
    localb.yqN = 1;
    hAk.removeCallbacks(this.yol);
    i.eaC().stop();
    hAk.removeCallbacks(this.yom);
    i.eav().yqo.bFT();
    if ((i.eat().yqI) && (!this.yoh))
    {
      i.eau().eaQ();
      i.eau().eaT();
      this.yoh = true;
      this.yop = Util.nowSecond();
      bpu();
      i.eat().eaM();
      if (this.yof != null) {
        this.yof.dZX();
      }
      i.eau().eaS();
      r.fHo().fHp();
      r.fHo().a(this);
    }
    AppMethodBeat.o(25302);
  }
  
  public final void dZL()
  {
    AppMethodBeat.i(25306);
    Log.i("MicroMsg.IPCallManager", "onShutdownByOtherSide, currentState: %s", new Object[] { f.stateToString(i.eaw().mAT) });
    if (al(10, 0, 32))
    {
      if (this.yof != null)
      {
        this.yof.dZY();
        AppMethodBeat.o(25306);
        return;
      }
      Toast.makeText(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131761945), 1).show();
    }
    AppMethodBeat.o(25306);
  }
  
  public final void dZM()
  {
    AppMethodBeat.i(25308);
    Log.i("MicroMsg.IPCallManager", "onHeartbeatFailed");
    if (gP(7, 29)) {
      g(7, null, MMApplicationContext.getContext().getString(2131756921), 1);
    }
    AppMethodBeat.o(25308);
  }
  
  public final void dZN()
  {
    AppMethodBeat.i(25312);
    do
    {
      Log.i("MicroMsg.IPCallManager", "onDisasterHappen, currentState: %s", new Object[] { f.stateToString(i.eaw().mAT) });
    } while (gP(12, 0));
    AppMethodBeat.o(25312);
  }
  
  public final void dZO()
  {
    AppMethodBeat.i(25313);
    Log.i("MicroMsg.IPCallManager", "onStartEngineFailed, currentState: %s", new Object[] { f.stateToString(i.eaw().mAT) });
    if (gP(6, 0)) {
      g(6, null, MMApplicationContext.getContext().getString(2131756927), 1);
    }
    AppMethodBeat.o(25313);
  }
  
  public final void dZP()
  {
    AppMethodBeat.i(25314);
    Log.i("MicroMsg.IPCallManager", "onChannelConnected, currentState: %s", new Object[] { f.stateToString(i.eaw().mAT) });
    i.eaC().stop();
    hAk.removeCallbacks(this.yom);
    Object localObject1;
    Object localObject2;
    if (i.eaw().eam())
    {
      localObject1 = i.eav();
      ((com.tencent.mm.plugin.ipcall.model.c.b)localObject1).yqo.b("ipcall", Integer.valueOf(4));
      Log.d("MicroMsg.IPCallDeviceManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.ipcall.model.a.a.AY(3)), Boolean.valueOf(com.tencent.mm.plugin.ipcall.model.a.a.AY(4)) });
      localObject1 = ((com.tencent.mm.plugin.ipcall.model.c.b)localObject1).yqo;
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).ypA;
      if (localObject2 != null)
      {
        if (!((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).isStart) {
          break label345;
        }
        Log.d("MicroMsg.IPCallAudioPlayer", "startPlay, already start");
      }
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).ypz;
      if (localObject2 != null)
      {
        if (((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).cdY() != 3) {
          break label452;
        }
        bool = true;
        label156:
        ((a.b)localObject2).qu(bool);
      }
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).ypz;
      if (localObject2 != null) {
        if (((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).cdY() != 4) {
          break label457;
        }
      }
    }
    label452:
    label457:
    for (boolean bool = true;; bool = false)
    {
      ((a.b)localObject2).qv(bool);
      i.eau().eaQ();
      i.eav().yqo.bFT();
      if ((i.eaw().eao()) && (!this.yoh))
      {
        i.eau().eaT();
        i.eat().eaM();
        this.yoh = true;
        this.yop = Util.nowSecond();
        bpu();
        if (this.yof != null) {
          this.yof.dZX();
        }
        localObject1 = this.yog;
        if (localObject1 != null)
        {
          Log.d("MicroMsg.IPCallRecordStorageLogic", "recordStartTalk, localId: %d", new Object[] { Long.valueOf(((k)localObject1).systemRowid) });
          if (((k)localObject1).systemRowid != -1L)
          {
            ((k)localObject1).field_status = 3;
            i.eaz().a((k)localObject1);
          }
        }
        i.eau().eaS();
        r.fHo().fHp();
        r.fHo().a(this);
      }
      AppMethodBeat.o(25314);
      return;
      label345:
      Log.i("MicroMsg.IPCallAudioPlayer", "startPlay");
      if (((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).qrz == null)
      {
        ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).qrz = new com.tencent.mm.plugin.voip.model.c();
        ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).qrz.N(v2protocal.VOICE_SAMPLERATE, 1, 20, 1);
      }
      ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).yqm = ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).qrz.F(MMApplicationContext.getContext(), false);
      ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).qrz.GTi = new a.1((com.tencent.mm.plugin.ipcall.model.c.a)localObject2);
      if (((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).qrz.fFp() <= 0) {
        i.eau().eaR();
      }
      ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).yqo.cV(((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).yqn);
      ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).isStart = true;
      break;
      bool = false;
      break label156;
    }
  }
  
  public final void dZQ() {}
  
  public final void dZR()
  {
    AppMethodBeat.i(25318);
    if (i.eaw().mAT != 5)
    {
      Log.i("MicroMsg.IPCallManager", "onResumeGoodNetStatus currentState != accept:%d", new Object[] { Integer.valueOf(i.eaw().mAT) });
      AppMethodBeat.o(25318);
      return;
    }
    com.tencent.mm.plugin.ipcall.model.c.b localb = i.eav();
    Log.i("MicroMsg.IPCallDeviceManager", "onResumeGoodNetStatus");
    if (localb.yqs != null) {
      localb.yqs.ebH();
    }
    AppMethodBeat.o(25318);
  }
  
  public final void dZS()
  {
    AppMethodBeat.i(25319);
    synchronized (this.taa)
    {
      if (i.eaw().eal())
      {
        if (this.yon)
        {
          dZT();
          AppMethodBeat.o(25319);
          return;
        }
        this.yon = true;
        Toast.makeText(MMApplicationContext.getContext(), 2131763281, 0).show();
        Intent localIntent = new Intent();
        localIntent.setFlags(268435456);
        localIntent.setClass(MMApplicationContext.getContext(), IPCallTalkUI.class);
        localIntent.putExtra("IPCallTalkUI_isFromMiniNotification", true);
        com.tencent.mm.plugin.voip.c.fFh().a(localIntent, false, this.yoo);
        dZT();
        if (this.yof != null) {
          this.yof.dZZ();
        }
      }
      AppMethodBeat.o(25319);
      return;
    }
  }
  
  public final void dZT()
  {
    AppMethodBeat.i(25320);
    if (com.tencent.mm.compatible.util.d.oE(26)) {
      if (!i.eaw().eao()) {
        break label249;
      }
    }
    label249:
    for (Object localObject1 = MMApplicationContext.getContext().getString(2131761904, new Object[] { String.format("%02d:%02d", new Object[] { Long.valueOf(Util.secondsToNow(this.yop) / 60L), Long.valueOf(Util.secondsToNow(this.yop) % 60L) }) });; localObject1 = MMApplicationContext.getContext().getString(2131761903))
    {
      Object localObject2 = new Intent(MMApplicationContext.getContext(), IPCallTalkUI.class);
      ((Intent)localObject2).putExtra("IPCallTalkUI_isFromMiniNotification", true);
      localObject2 = PendingIntent.getActivity(MMApplicationContext.getContext(), 42, (Intent)localObject2, 134217728);
      int i = 2131234305;
      if (com.tencent.mm.compatible.util.d.oE(19)) {
        i = 2131234303;
      }
      localObject1 = com.tencent.mm.bq.a.cd(MMApplicationContext.getContext(), "reminder_channel_id").i(MMApplicationContext.getContext().getString(2131761903)).i(System.currentTimeMillis()).f(MMApplicationContext.getContext().getString(2131761893)).g((CharSequence)localObject1);
      ((s.c)localObject1).Hv = ((PendingIntent)localObject2);
      localObject1 = ((s.c)localObject1).build();
      ((Notification)localObject1).icon = i;
      ((Notification)localObject1).flags |= 0x20;
      bg.getNotification().a(42, (Notification)localObject1, false);
      if (i.eaw().eao()) {
        break;
      }
      com.tencent.mm.plugin.voip.c.fFh().aGx(MMApplicationContext.getContext().getString(2131763321));
      AppMethodBeat.o(25320);
      return;
    }
    com.tencent.mm.plugin.voip.c.fFh().xv(dZU());
    AppMethodBeat.o(25320);
  }
  
  public final int dZU()
  {
    AppMethodBeat.i(25322);
    int i = (int)Util.secondsToNow(this.yop);
    if (i > 0)
    {
      AppMethodBeat.o(25322);
      return i;
    }
    AppMethodBeat.o(25322);
    return 0;
  }
  
  public final void ep(String paramString, int paramInt)
  {
    AppMethodBeat.i(25304);
    Log.i("MicroMsg.IPCallManager", "onUnAvaliable, currentState: %s", new Object[] { f.stateToString(i.eaw().mAT) });
    if (gP(3, 5)) {
      g(3, null, paramString, paramInt);
    }
    AppMethodBeat.o(25304);
  }
  
  public final void eq(String paramString, int paramInt)
  {
    AppMethodBeat.i(25305);
    Log.i("MicroMsg.IPCallManager", "onBusy, currentState: %s", new Object[] { f.stateToString(i.eaw().mAT) });
    if (gP(1, 4)) {
      g(1, null, paramString, paramInt);
    }
    AppMethodBeat.o(25305);
  }
  
  public final void er(String paramString, int paramInt)
  {
    AppMethodBeat.i(25307);
    Log.i("MicroMsg.IPCallManager", "onSyncFailed");
    if (gP(7, 35)) {
      g(7, null, paramString, paramInt);
    }
    AppMethodBeat.o(25307);
  }
  
  public final void g(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(25303);
    if (this.yof != null)
    {
      this.yof.g(paramInt1, paramString1, paramString2, paramInt2);
      AppMethodBeat.o(25303);
      return;
    }
    Toast.makeText(MMApplicationContext.getContext(), paramString2, 1).show();
    AppMethodBeat.o(25303);
  }
  
  public final boolean gP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(25316);
    if (i.eaw().eao())
    {
      if (paramInt1 == 0)
      {
        bool = al(9, paramInt1, paramInt2);
        AppMethodBeat.o(25316);
        return bool;
      }
      bool = al(11, paramInt1, paramInt2);
      AppMethodBeat.o(25316);
      return bool;
    }
    if (paramInt1 == 0)
    {
      bool = al(8, paramInt1, paramInt2);
      AppMethodBeat.o(25316);
      return bool;
    }
    boolean bool = al(12, paramInt1, paramInt2);
    AppMethodBeat.o(25316);
    return bool;
  }
  
  public final void ql(boolean paramBoolean)
  {
    AppMethodBeat.i(25317);
    if (i.eaw().mAT != 5)
    {
      Log.i("MicroMsg.IPCallManager", "onBadNetStatus currentState != accept:%d", new Object[] { Integer.valueOf(i.eaw().mAT) });
      AppMethodBeat.o(25317);
      return;
    }
    com.tencent.mm.plugin.ipcall.model.c.b localb = i.eav();
    Log.i("MicroMsg.IPCallDeviceManager", "onBadNetStatus");
    if (localb.yqs != null)
    {
      j localj = localb.yqs;
      if (localj.yzB != null) {
        localj.yzB.setVisibility(0);
      }
      if (localj.yzC != null) {
        localj.yzC.setVisibility(0);
      }
    }
    if (!localb.yqo.isSpeakerphoneOn())
    {
      long l = System.currentTimeMillis();
      if (l - localb.yqt > 30000L)
      {
        localb.yqt = l;
        com.tencent.mm.plugin.voip.c.fFg().GYS.fIA();
      }
    }
    AppMethodBeat.o(25317);
  }
  
  public final void qm(boolean paramBoolean)
  {
    AppMethodBeat.i(185745);
    synchronized (this.taa)
    {
      this.yon = false;
      com.tencent.mm.plugin.voip.c.fFh().rX(paramBoolean);
      ((NotificationManager)MMApplicationContext.getContext().getSystemService("notification")).cancel(42);
      AppMethodBeat.o(185745);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.c
 * JD-Core Version:    0.7.0.1
 */