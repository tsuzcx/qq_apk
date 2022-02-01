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
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.ipcall.model.IPCallForegroundService;
import com.tencent.mm.plugin.ipcall.model.a.a.b;
import com.tencent.mm.plugin.ipcall.model.c.a.1;
import com.tencent.mm.plugin.ipcall.model.d.a.a;
import com.tencent.mm.plugin.ipcall.model.f;
import com.tencent.mm.plugin.ipcall.model.g;
import com.tencent.mm.plugin.ipcall.model.g.a;
import com.tencent.mm.plugin.ipcall.model.h.k;
import com.tencent.mm.plugin.ipcall.model.h.l;
import com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI;
import com.tencent.mm.plugin.ipcall.ui.j;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.r.a;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.widget.BaseSmallView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;

public final class c
  implements a.a, g.a, r.a
{
  private static ap gAC;
  private av cOx;
  private PhoneStateListener klv;
  private Object pZB;
  private Runnable szA;
  private Runnable szB;
  private boolean szC;
  private com.tencent.mm.plugin.voip.ui.a szD;
  private long szE;
  public e szu;
  private k szv;
  private boolean szw;
  private TelephonyManager szx;
  private boolean szy;
  private com.tencent.mm.sdk.b.c szz;
  
  static
  {
    AppMethodBeat.i(25324);
    gAC = new ap(Looper.getMainLooper());
    AppMethodBeat.o(25324);
  }
  
  public c()
  {
    AppMethodBeat.i(25294);
    this.szw = false;
    this.szy = false;
    this.pZB = new Object();
    this.klv = new c.1(this);
    this.szz = new c.2(this);
    this.szA = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25289);
        if (!com.tencent.mm.plugin.ipcall.model.i.cHo().cHg())
        {
          ad.i("MicroMsg.IPCallManager", "timeout! still not accept!");
          if (c.this.fT(9, 12)) {
            c.this.f(9, null, aj.getContext().getString(2131756764), 2);
          }
        }
        AppMethodBeat.o(25289);
      }
    };
    this.szB = new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore_1
        //   2: iconst_1
        //   3: istore_3
        //   4: sipush 25290
        //   7: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   10: invokestatic 33	com/tencent/mm/plugin/ipcall/model/i:cHu	()Lcom/tencent/mm/plugin/voip/video/i;
        //   13: astore 5
        //   15: aload 5
        //   17: iconst_0
        //   18: putfield 39	com/tencent/mm/plugin/voip/video/i:zwb	I
        //   21: ldc2_w 40
        //   24: ldc2_w 42
        //   27: lcmp
        //   28: ifeq +233 -> 261
        //   31: invokestatic 49	com/tencent/mm/kernel/g:afB	()Lcom/tencent/mm/kernel/e;
        //   34: invokevirtual 55	com/tencent/mm/kernel/e:afk	()Lcom/tencent/mm/storage/ab;
        //   37: ldc 56
        //   39: getstatic 62	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
        //   42: invokevirtual 68	com/tencent/mm/storage/ab:get	(ILjava/lang/Object;)Ljava/lang/Object;
        //   45: checkcast 58	java/lang/Boolean
        //   48: invokevirtual 72	java/lang/Boolean:booleanValue	()Z
        //   51: istore_2
        //   52: ldc 74
        //   54: ldc 76
        //   56: iconst_3
        //   57: anewarray 4	java/lang/Object
        //   60: dup
        //   61: iconst_0
        //   62: iload_2
        //   63: invokestatic 80	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   66: aastore
        //   67: dup
        //   68: iconst_1
        //   69: invokestatic 85	com/tencent/mm/m/a:Ym	()Z
        //   72: invokestatic 80	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   75: aastore
        //   76: dup
        //   77: iconst_2
        //   78: getstatic 62	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
        //   81: aastore
        //   82: invokestatic 90	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   85: iload_3
        //   86: istore_2
        //   87: iload_2
        //   88: ifeq +166 -> 254
        //   91: aload 5
        //   93: getfield 94	com/tencent/mm/plugin/voip/video/i:aJn	Z
        //   96: ifne +158 -> 254
        //   99: aload 5
        //   101: invokestatic 100	java/lang/System:currentTimeMillis	()J
        //   104: putfield 104	com/tencent/mm/plugin/voip/video/i:zwc	J
        //   107: aload 5
        //   109: new 106	com/tencent/mm/compatible/b/k
        //   112: dup
        //   113: invokespecial 107	com/tencent/mm/compatible/b/k:<init>	()V
        //   116: putfield 111	com/tencent/mm/plugin/voip/video/i:zwa	Landroid/media/MediaPlayer;
        //   119: ldc 74
        //   121: ldc 113
        //   123: iconst_2
        //   124: anewarray 4	java/lang/Object
        //   127: dup
        //   128: iconst_0
        //   129: invokestatic 118	com/tencent/mm/plugin/audio/c/a:bvC	()Z
        //   132: invokestatic 80	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   135: aastore
        //   136: dup
        //   137: iconst_1
        //   138: invokestatic 121	com/tencent/mm/plugin/audio/c/a:bvw	()Z
        //   141: invokestatic 80	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   144: aastore
        //   145: invokestatic 124	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   148: getstatic 130	com/tencent/mm/compatible/deviceinfo/ae:fFx	Lcom/tencent/mm/compatible/deviceinfo/b;
        //   151: getfield 135	com/tencent/mm/compatible/deviceinfo/b:fzS	I
        //   154: iflt +10 -> 164
        //   157: getstatic 130	com/tencent/mm/compatible/deviceinfo/ae:fFx	Lcom/tencent/mm/compatible/deviceinfo/b;
        //   160: getfield 135	com/tencent/mm/compatible/deviceinfo/b:fzS	I
        //   163: istore_1
        //   164: aload 5
        //   166: iconst_0
        //   167: invokevirtual 139	com/tencent/mm/plugin/voip/video/i:rW	(Z)V
        //   170: aload 5
        //   172: ldc 140
        //   174: ldc2_w 40
        //   177: iconst_1
        //   178: iload_1
        //   179: invokevirtual 144	com/tencent/mm/plugin/voip/video/i:a	(IJZI)V
        //   182: aload 5
        //   184: iconst_1
        //   185: putfield 94	com/tencent/mm/plugin/voip/video/i:aJn	Z
        //   188: sipush 25290
        //   191: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   194: return
        //   195: astore 4
        //   197: iconst_1
        //   198: istore_2
        //   199: ldc 74
        //   201: new 149	java/lang/StringBuilder
        //   204: dup
        //   205: ldc 151
        //   207: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   210: aload 4
        //   212: invokevirtual 158	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   215: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   218: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   221: invokestatic 169	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   224: goto -137 -> 87
        //   227: astore 4
        //   229: ldc 74
        //   231: new 149	java/lang/StringBuilder
        //   234: dup
        //   235: ldc 171
        //   237: invokespecial 154	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   240: aload 4
        //   242: invokevirtual 172	java/lang/Exception:toString	()Ljava/lang/String;
        //   245: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   248: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   251: invokestatic 169	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   254: sipush 25290
        //   257: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   260: return
        //   261: aload 5
        //   263: ldc 140
        //   265: iconst_2
        //   266: iconst_1
        //   267: invokevirtual 176	com/tencent/mm/plugin/voip/video/i:A	(IIZ)V
        //   270: sipush 25290
        //   273: invokestatic 147	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   276: return
        //   277: astore 4
        //   279: goto -80 -> 199
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	282	0	this	4
        //   1	178	1	i	int
        //   51	148	2	bool1	boolean
        //   3	83	3	bool2	boolean
        //   195	16	4	localException1	Exception
        //   227	14	4	localException2	Exception
        //   277	1	4	localException3	Exception
        //   13	249	5	locali	com.tencent.mm.plugin.voip.video.i
        // Exception table:
        //   from	to	target	type
        //   31	52	195	java/lang/Exception
        //   99	148	227	java/lang/Exception
        //   148	164	227	java/lang/Exception
        //   164	188	227	java/lang/Exception
        //   52	85	277	java/lang/Exception
      }
    };
    this.szD = new com.tencent.mm.plugin.voip.ui.a()
    {
      public final void a(Intent paramAnonymousIntent, BaseSmallView paramAnonymousBaseSmallView)
      {
        AppMethodBeat.i(179650);
        if (!com.tencent.mm.plugin.ipcall.model.i.cHo().cHg())
        {
          paramAnonymousBaseSmallView.atl(aj.getContext().getString(2131761459));
          AppMethodBeat.o(179650);
          return;
        }
        int i = c.this.cGM();
        paramAnonymousBaseSmallView.atk(String.format("%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
        AppMethodBeat.o(179650);
      }
      
      public final boolean cGN()
      {
        AppMethodBeat.i(25291);
        if (com.tencent.mm.plugin.ipcall.model.i.cHo().cHd())
        {
          AppMethodBeat.o(25291);
          return true;
        }
        AppMethodBeat.o(25291);
        return false;
      }
    };
    this.szE = 0L;
    AppMethodBeat.o(25294);
  }
  
  private void aKf()
  {
    AppMethodBeat.i(25323);
    ad.i("MicroMsg.IPCallManager", "startTimeCount");
    if (this.cOx != null)
    {
      this.cOx.stopTimer();
      AppMethodBeat.o(25323);
      return;
    }
    if (this.cOx == null) {
      this.cOx = new av(Looper.getMainLooper(), new av.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(25293);
          c.this.cGL();
          if ((com.tencent.mm.plugin.ipcall.model.i.cHo().cHg()) && (c.a(c.this) != null)) {
            c.a(c.this).cGS();
          }
          AppMethodBeat.o(25293);
          return true;
        }
      }, true);
    }
    this.cOx.av(1000L, 1000L);
    AppMethodBeat.o(25323);
  }
  
  public static boolean adP(String paramString)
  {
    AppMethodBeat.i(25298);
    ad.d("MicroMsg.IPCallManager", "dialWhenTalking, dialButton: %s", new Object[] { paramString });
    if (!com.tencent.mm.plugin.ipcall.model.i.cHo().cHg())
    {
      ad.i("MicroMsg.IPCallManager", "ipcall not connect, cannot call dialWhenTalking now");
      AppMethodBeat.o(25298);
      return false;
    }
    if ((!bt.isNullOrNil(paramString)) && (paramString.length() == 1))
    {
      int i;
      if ((!bt.isNullOrNil(paramString)) && (paramString.length() == 1))
      {
        i = paramString.charAt(0);
        if ((i >= 48) && (i <= 57)) {
          i -= 48;
        }
      }
      while (i != -1)
      {
        paramString = com.tencent.mm.plugin.ipcall.model.i.cHl();
        ad.d("MicroMsg.IPCallEngineManager", "sendDTMF: %d", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.ipcall.model.d.b localb = com.tencent.mm.plugin.ipcall.model.i.cHm();
        localb.sCE += 1;
        ad.i("MicroMsg.IPCallReportHelper", "now addCallClickCnt %d", new Object[] { Integer.valueOf(localb.sCE) });
        i = paramString.sBX.SendDTMF(i);
        if (i < 0) {
          ad.i("MicroMsg.IPCallEngineManager", "sendDTMF failed, ret: %d", new Object[] { Integer.valueOf(i) });
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
  private boolean af(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: sipush 25297
    //   3: invokestatic 53	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 224	com/tencent/mm/plugin/ipcall/model/i:cHk	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   9: getfield 230	com/tencent/mm/plugin/ipcall/model/g:sAl	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   12: astore 15
    //   14: invokestatic 147	com/tencent/mm/plugin/ipcall/model/i:cHo	()Lcom/tencent/mm/plugin/ipcall/model/f;
    //   17: iload_1
    //   18: invokevirtual 234	com/tencent/mm/plugin/ipcall/model/f:Fh	(I)Z
    //   21: ifne +93 -> 114
    //   24: ldc 109
    //   26: ldc 236
    //   28: iconst_1
    //   29: anewarray 4	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: invokestatic 147	com/tencent/mm/plugin/ipcall/model/i:cHo	()Lcom/tencent/mm/plugin/ipcall/model/f;
    //   37: getfield 239	com/tencent/mm/plugin/ipcall/model/f:ksb	I
    //   40: invokestatic 243	com/tencent/mm/plugin/ipcall/model/f:stateToString	(I)Ljava/lang/String;
    //   43: aastore
    //   44: invokestatic 200	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: aload 15
    //   49: ifnull +57 -> 106
    //   52: ldc 109
    //   54: ldc 245
    //   56: iconst_5
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload 15
    //   64: getfield 250	com/tencent/mm/plugin/ipcall/model/b/c:sBa	I
    //   67: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: aload 15
    //   75: getfield 253	com/tencent/mm/plugin/ipcall/model/b/c:roomId	I
    //   78: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: aastore
    //   82: dup
    //   83: iconst_2
    //   84: iload_1
    //   85: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: aastore
    //   89: dup
    //   90: iconst_3
    //   91: iload_2
    //   92: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   95: aastore
    //   96: dup
    //   97: iconst_4
    //   98: iload_3
    //   99: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: invokestatic 200	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: sipush 25297
    //   109: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: iconst_0
    //   113: ireturn
    //   114: aload 15
    //   116: ifnull +57 -> 173
    //   119: ldc 109
    //   121: ldc 255
    //   123: iconst_5
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: aload 15
    //   131: getfield 250	com/tencent/mm/plugin/ipcall/model/b/c:sBa	I
    //   134: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: aastore
    //   138: dup
    //   139: iconst_1
    //   140: aload 15
    //   142: getfield 253	com/tencent/mm/plugin/ipcall/model/b/c:roomId	I
    //   145: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: aastore
    //   149: dup
    //   150: iconst_2
    //   151: iload_1
    //   152: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   155: aastore
    //   156: dup
    //   157: iconst_3
    //   158: iload_2
    //   159: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: aastore
    //   163: dup
    //   164: iconst_4
    //   165: iload_3
    //   166: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   169: aastore
    //   170: invokestatic 200	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: invokestatic 259	com/tencent/mm/plugin/ipcall/model/i:cHu	()Lcom/tencent/mm/plugin/voip/video/i;
    //   176: invokevirtual 264	com/tencent/mm/plugin/voip/video/i:stop	()V
    //   179: invokestatic 259	com/tencent/mm/plugin/ipcall/model/i:cHu	()Lcom/tencent/mm/plugin/voip/video/i;
    //   182: astore 15
    //   184: invokestatic 268	com/tencent/mm/plugin/ipcall/model/i:cHn	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   187: getfield 274	com/tencent/mm/plugin/ipcall/model/c/b:sBG	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   190: invokevirtual 279	com/tencent/mm/plugin/ipcall/model/a/a:isSpeakerphoneOn	()Z
    //   193: istore 8
    //   195: aload 15
    //   197: getfield 283	com/tencent/mm/plugin/voip/video/i:mContext	Landroid/content/Context;
    //   200: invokestatic 289	com/tencent/mm/sdk/platformtools/aj:eFD	()Ljava/lang/String;
    //   203: iconst_0
    //   204: invokevirtual 295	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   207: ldc_w 297
    //   210: iconst_1
    //   211: invokeinterface 303 3 0
    //   216: pop
    //   217: ldc_w 305
    //   220: invokestatic 311	com/tencent/mm/plugin/audio/c/a:Od	(Ljava/lang/String;)Lcom/tencent/mm/plugin/audio/b/a;
    //   223: iload 8
    //   225: invokevirtual 317	com/tencent/mm/plugin/audio/b/a:ck	(Z)V
    //   228: iload 8
    //   230: ifeq +1475 -> 1705
    //   233: iconst_0
    //   234: invokestatic 320	com/tencent/mm/plugin/audio/c/a:setMode	(I)V
    //   237: ldc_w 322
    //   240: ldc_w 324
    //   243: iconst_3
    //   244: anewarray 4	java/lang/Object
    //   247: dup
    //   248: iconst_0
    //   249: getstatic 330	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   252: aastore
    //   253: dup
    //   254: iconst_1
    //   255: iload 8
    //   257: invokestatic 333	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   260: aastore
    //   261: dup
    //   262: iconst_2
    //   263: iconst_2
    //   264: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   267: aastore
    //   268: invokestatic 200	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: aload 15
    //   273: invokestatic 339	java/lang/System:currentTimeMillis	()J
    //   276: putfield 342	com/tencent/mm/plugin/voip/video/i:zwd	J
    //   279: new 344	com/tencent/mm/compatible/b/k
    //   282: dup
    //   283: invokespecial 345	com/tencent/mm/compatible/b/k:<init>	()V
    //   286: astore 16
    //   288: aload 16
    //   290: aload 15
    //   292: getfield 283	com/tencent/mm/plugin/voip/video/i:mContext	Landroid/content/Context;
    //   295: new 347	java/lang/StringBuilder
    //   298: dup
    //   299: ldc_w 349
    //   302: invokespecial 352	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   305: aload 15
    //   307: getfield 283	com/tencent/mm/plugin/voip/video/i:mContext	Landroid/content/Context;
    //   310: invokevirtual 355	android/content/Context:getPackageName	()Ljava/lang/String;
    //   313: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc_w 361
    //   319: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   322: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokestatic 370	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   328: invokevirtual 376	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   331: aload 16
    //   333: new 378	com/tencent/mm/plugin/voip/video/i$7
    //   336: dup
    //   337: aload 15
    //   339: invokespecial 381	com/tencent/mm/plugin/voip/video/i$7:<init>	(Lcom/tencent/mm/plugin/voip/video/i;)V
    //   342: invokevirtual 385	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   345: aload 16
    //   347: new 387	com/tencent/mm/plugin/voip/video/i$8
    //   350: dup
    //   351: aload 15
    //   353: invokespecial 388	com/tencent/mm/plugin/voip/video/i$8:<init>	(Lcom/tencent/mm/plugin/voip/video/i;)V
    //   356: invokevirtual 392	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   359: invokestatic 395	com/tencent/mm/plugin/audio/c/a:bvC	()Z
    //   362: ifne +1992 -> 2354
    //   365: iload 8
    //   367: ifne +1345 -> 1712
    //   370: goto +1984 -> 2354
    //   373: aload 16
    //   375: iload 5
    //   377: invokevirtual 398	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   380: aload 16
    //   382: invokevirtual 401	android/media/MediaPlayer:prepare	()V
    //   385: aload 16
    //   387: iconst_0
    //   388: invokevirtual 404	android/media/MediaPlayer:setLooping	(Z)V
    //   391: aload 16
    //   393: invokevirtual 407	android/media/MediaPlayer:start	()V
    //   396: invokestatic 339	java/lang/System:currentTimeMillis	()J
    //   399: aload 15
    //   401: getfield 342	com/tencent/mm/plugin/voip/video/i:zwd	J
    //   404: lsub
    //   405: ldc2_w 408
    //   408: lcmp
    //   409: ifle +10 -> 419
    //   412: aload 15
    //   414: bipush 7
    //   416: putfield 412	com/tencent/mm/plugin/voip/video/i:zwb	I
    //   419: ldc 109
    //   421: ldc_w 414
    //   424: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   427: invokestatic 420	com/tencent/mm/plugin/voip/model/r:dTT	()Lcom/tencent/mm/plugin/voip/model/r;
    //   430: invokevirtual 423	com/tencent/mm/plugin/voip/model/r:dTV	()V
    //   433: invokestatic 420	com/tencent/mm/plugin/voip/model/r:dTT	()Lcom/tencent/mm/plugin/voip/model/r;
    //   436: aconst_null
    //   437: invokevirtual 426	com/tencent/mm/plugin/voip/model/r:a	(Lcom/tencent/mm/plugin/voip/model/r$a;)V
    //   440: invokestatic 188	com/tencent/mm/plugin/ipcall/model/i:cHm	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   443: astore 15
    //   445: invokestatic 268	com/tencent/mm/plugin/ipcall/model/i:cHn	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   448: getfield 274	com/tencent/mm/plugin/ipcall/model/c/b:sBG	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   451: getfield 430	com/tencent/mm/plugin/ipcall/model/a/a:sAR	Lcom/tencent/mm/plugin/ipcall/model/c/c;
    //   454: astore 16
    //   456: aload 16
    //   458: ifnull +1306 -> 1764
    //   461: aload 16
    //   463: getfield 436	com/tencent/mm/plugin/ipcall/model/c/c:sBM	Lcom/tencent/mm/audio/b/c;
    //   466: ifnull +1292 -> 1758
    //   469: aload 16
    //   471: getfield 436	com/tencent/mm/plugin/ipcall/model/c/c:sBM	Lcom/tencent/mm/audio/b/c;
    //   474: getfield 441	com/tencent/mm/audio/b/c:cXZ	I
    //   477: istore 5
    //   479: aload 15
    //   481: getfield 444	com/tencent/mm/plugin/ipcall/model/d/b:sCB	I
    //   484: ifne +10 -> 494
    //   487: aload 15
    //   489: iload 5
    //   491: putfield 444	com/tencent/mm/plugin/ipcall/model/d/b:sCB	I
    //   494: invokestatic 188	com/tencent/mm/plugin/ipcall/model/i:cHm	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   497: astore 15
    //   499: invokestatic 268	com/tencent/mm/plugin/ipcall/model/i:cHn	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   502: getfield 274	com/tencent/mm/plugin/ipcall/model/c/b:sBG	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   505: getfield 448	com/tencent/mm/plugin/ipcall/model/a/a:sAQ	Lcom/tencent/mm/plugin/ipcall/model/c/a;
    //   508: astore 16
    //   510: aload 16
    //   512: ifnull +1264 -> 1776
    //   515: aload 16
    //   517: getfield 454	com/tencent/mm/plugin/ipcall/model/c/a:nPx	Lcom/tencent/mm/plugin/voip/model/c;
    //   520: ifnull +1250 -> 1770
    //   523: ldc_w 456
    //   526: new 347	java/lang/StringBuilder
    //   529: dup
    //   530: ldc_w 458
    //   533: invokespecial 352	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   536: aload 16
    //   538: getfield 454	com/tencent/mm/plugin/ipcall/model/c/a:nPx	Lcom/tencent/mm/plugin/voip/model/c;
    //   541: invokevirtual 463	com/tencent/mm/plugin/voip/model/c:dRX	()I
    //   544: invokevirtual 466	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   547: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   550: invokestatic 468	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   553: aload 16
    //   555: getfield 454	com/tencent/mm/plugin/ipcall/model/c/a:nPx	Lcom/tencent/mm/plugin/voip/model/c;
    //   558: invokevirtual 463	com/tencent/mm/plugin/voip/model/c:dRX	()I
    //   561: istore 5
    //   563: aload 15
    //   565: getfield 471	com/tencent/mm/plugin/ipcall/model/d/b:sCC	I
    //   568: ifne +10 -> 578
    //   571: aload 15
    //   573: iload 5
    //   575: putfield 471	com/tencent/mm/plugin/ipcall/model/d/b:sCC	I
    //   578: invokestatic 268	com/tencent/mm/plugin/ipcall/model/i:cHn	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   581: astore 15
    //   583: invokestatic 174	com/tencent/mm/plugin/ipcall/model/i:cHl	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   586: astore 16
    //   588: aload 15
    //   590: getfield 274	com/tencent/mm/plugin/ipcall/model/c/b:sBG	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   593: astore 17
    //   595: aload 17
    //   597: getfield 448	com/tencent/mm/plugin/ipcall/model/a/a:sAQ	Lcom/tencent/mm/plugin/ipcall/model/c/a;
    //   600: astore 18
    //   602: aload 18
    //   604: ifnull +1184 -> 1788
    //   607: aload 18
    //   609: getfield 454	com/tencent/mm/plugin/ipcall/model/c/a:nPx	Lcom/tencent/mm/plugin/voip/model/c;
    //   612: ifnull +1170 -> 1782
    //   615: aload 18
    //   617: getfield 474	com/tencent/mm/plugin/ipcall/model/c/a:isStart	Z
    //   620: ifeq +1162 -> 1782
    //   623: aload 18
    //   625: getfield 454	com/tencent/mm/plugin/ipcall/model/c/a:nPx	Lcom/tencent/mm/plugin/voip/model/c;
    //   628: invokevirtual 477	com/tencent/mm/plugin/voip/model/c:aDs	()I
    //   631: istore 5
    //   633: iload 5
    //   635: iconst_m1
    //   636: if_icmpne +1158 -> 1794
    //   639: iconst_0
    //   640: istore 5
    //   642: aload 16
    //   644: getfield 206	com/tencent/mm/plugin/ipcall/model/d/a:sBX	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   647: iload 5
    //   649: putfield 480	com/tencent/mm/plugin/voip/model/v2protocal:znU	I
    //   652: aload 15
    //   654: aconst_null
    //   655: putfield 484	com/tencent/mm/plugin/ipcall/model/c/b:imP	Lcom/tencent/mm/ui/MMActivity;
    //   658: aload 15
    //   660: getfield 274	com/tencent/mm/plugin/ipcall/model/c/b:sBG	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   663: astore 17
    //   665: aload 17
    //   667: getfield 448	com/tencent/mm/plugin/ipcall/model/a/a:sAQ	Lcom/tencent/mm/plugin/ipcall/model/c/a;
    //   670: astore 18
    //   672: aload 18
    //   674: ifnull +65 -> 739
    //   677: aload 18
    //   679: getfield 474	com/tencent/mm/plugin/ipcall/model/c/a:isStart	Z
    //   682: ifeq +57 -> 739
    //   685: ldc_w 456
    //   688: ldc_w 486
    //   691: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   694: aload 18
    //   696: getfield 489	com/tencent/mm/plugin/ipcall/model/c/a:sBD	Ljava/lang/Object;
    //   699: astore 16
    //   701: aload 16
    //   703: monitorenter
    //   704: new 491	com/tencent/mm/plugin/ipcall/model/c/a$a
    //   707: dup
    //   708: aload 18
    //   710: aload 18
    //   712: getfield 454	com/tencent/mm/plugin/ipcall/model/c/a:nPx	Lcom/tencent/mm/plugin/voip/model/c;
    //   715: invokespecial 494	com/tencent/mm/plugin/ipcall/model/c/a$a:<init>	(Lcom/tencent/mm/plugin/ipcall/model/c/a;Lcom/tencent/mm/plugin/voip/model/c;)V
    //   718: ldc_w 496
    //   721: invokestatic 502	com/tencent/mm/sdk/g/b:c	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   724: aload 18
    //   726: iconst_0
    //   727: putfield 474	com/tencent/mm/plugin/ipcall/model/c/a:isStart	Z
    //   730: aload 18
    //   732: aconst_null
    //   733: putfield 454	com/tencent/mm/plugin/ipcall/model/c/a:nPx	Lcom/tencent/mm/plugin/voip/model/c;
    //   736: aload 16
    //   738: monitorexit
    //   739: aload 17
    //   741: ldc_w 504
    //   744: invokevirtual 507	com/tencent/mm/plugin/ipcall/model/a/a:Oc	(Ljava/lang/String;)V
    //   747: aload 17
    //   749: aconst_null
    //   750: putfield 511	com/tencent/mm/plugin/ipcall/model/a/a:sAP	Lcom/tencent/mm/plugin/ipcall/model/a/a$b;
    //   753: aload 17
    //   755: getfield 515	com/tencent/mm/plugin/ipcall/model/a/a:hDB	Lcom/tencent/mm/compatible/util/b;
    //   758: invokevirtual 520	com/tencent/mm/compatible/util/b:XF	()Z
    //   761: pop
    //   762: aload 15
    //   764: aconst_null
    //   765: putfield 524	com/tencent/mm/plugin/ipcall/model/c/b:sBK	Lcom/tencent/mm/plugin/ipcall/ui/j;
    //   768: invokestatic 268	com/tencent/mm/plugin/ipcall/model/i:cHn	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   771: astore 16
    //   773: aload 16
    //   775: getfield 274	com/tencent/mm/plugin/ipcall/model/c/b:sBG	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   778: getfield 430	com/tencent/mm/plugin/ipcall/model/a/a:sAR	Lcom/tencent/mm/plugin/ipcall/model/c/c;
    //   781: astore 17
    //   783: aload 17
    //   785: ifnull +79 -> 864
    //   788: aload 17
    //   790: getfield 525	com/tencent/mm/plugin/ipcall/model/c/c:isStart	Z
    //   793: ifeq +71 -> 864
    //   796: ldc_w 527
    //   799: ldc_w 529
    //   802: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   805: aload 17
    //   807: getfield 532	com/tencent/mm/plugin/ipcall/model/c/c:sBN	Ljava/lang/Object;
    //   810: astore 15
    //   812: aload 15
    //   814: monitorenter
    //   815: aload 17
    //   817: getfield 436	com/tencent/mm/plugin/ipcall/model/c/c:sBM	Lcom/tencent/mm/audio/b/c;
    //   820: ifnull +41 -> 861
    //   823: new 534	com/tencent/mm/plugin/ipcall/model/c/c$a
    //   826: dup
    //   827: aload 17
    //   829: aload 17
    //   831: getfield 436	com/tencent/mm/plugin/ipcall/model/c/c:sBM	Lcom/tencent/mm/audio/b/c;
    //   834: invokespecial 537	com/tencent/mm/plugin/ipcall/model/c/c$a:<init>	(Lcom/tencent/mm/plugin/ipcall/model/c/c;Lcom/tencent/mm/audio/b/c;)V
    //   837: ldc_w 539
    //   840: invokestatic 502	com/tencent/mm/sdk/g/b:c	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   843: aload 17
    //   845: aconst_null
    //   846: putfield 436	com/tencent/mm/plugin/ipcall/model/c/c:sBM	Lcom/tencent/mm/audio/b/c;
    //   849: aload 17
    //   851: iconst_0
    //   852: putfield 525	com/tencent/mm/plugin/ipcall/model/c/c:isStart	Z
    //   855: aload 17
    //   857: iconst_0
    //   858: putfield 542	com/tencent/mm/plugin/ipcall/model/c/c:fqj	Z
    //   861: aload 15
    //   863: monitorexit
    //   864: aload 16
    //   866: aconst_null
    //   867: putfield 484	com/tencent/mm/plugin/ipcall/model/c/b:imP	Lcom/tencent/mm/ui/MMActivity;
    //   870: invokestatic 174	com/tencent/mm/plugin/ipcall/model/i:cHl	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   873: astore 15
    //   875: ldc 176
    //   877: ldc_w 544
    //   880: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   883: aload 15
    //   885: getfield 206	com/tencent/mm/plugin/ipcall/model/d/a:sBX	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   888: iconst_1
    //   889: invokevirtual 548	com/tencent/mm/plugin/voip/model/v2protocal:rG	(Z)Ljava/lang/String;
    //   892: pop
    //   893: invokestatic 188	com/tencent/mm/plugin/ipcall/model/i:cHm	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   896: astore 16
    //   898: aload 16
    //   900: getfield 552	com/tencent/mm/plugin/ipcall/model/d/b:sCw	Ljava/lang/String;
    //   903: invokestatic 160	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   906: ifeq +279 -> 1185
    //   909: aload 16
    //   911: getfield 555	com/tencent/mm/plugin/ipcall/model/d/b:sCv	Ljava/lang/String;
    //   914: invokestatic 160	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   917: ifeq +268 -> 1185
    //   920: invokestatic 224	com/tencent/mm/plugin/ipcall/model/i:cHk	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   923: getfield 230	com/tencent/mm/plugin/ipcall/model/g:sAl	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   926: astore 18
    //   928: invokestatic 174	com/tencent/mm/plugin/ipcall/model/i:cHl	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   931: getfield 206	com/tencent/mm/plugin/ipcall/model/d/a:sBX	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   934: astore 17
    //   936: aload 16
    //   938: getfield 558	com/tencent/mm/plugin/ipcall/model/d/b:sCl	I
    //   941: iconst_1
    //   942: if_icmpne +911 -> 1853
    //   945: iconst_1
    //   946: istore 5
    //   948: aload 18
    //   950: getfield 561	com/tencent/mm/plugin/ipcall/model/b/c:sBt	I
    //   953: istore 6
    //   955: aload 17
    //   957: getfield 565	com/tencent/mm/plugin/voip/model/v2protocal:zpm	[B
    //   960: astore 18
    //   962: aload 17
    //   964: getfield 565	com/tencent/mm/plugin/voip/model/v2protocal:zpm	[B
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
    //   988: invokevirtual 569	com/tencent/mm/plugin/voip/model/v2protocal:getPstnChannelInfo	([BIII)I
    //   991: pop
    //   992: ldc_w 571
    //   995: ldc_w 573
    //   998: iconst_1
    //   999: anewarray 4	java/lang/Object
    //   1002: dup
    //   1003: iconst_0
    //   1004: aload 17
    //   1006: getfield 576	com/tencent/mm/plugin/voip/model/v2protocal:field_pstnChannelInfoLength	I
    //   1009: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1012: aastore
    //   1013: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1016: aload 16
    //   1018: new 162	java/lang/String
    //   1021: dup
    //   1022: aload 17
    //   1024: getfield 565	com/tencent/mm/plugin/voip/model/v2protocal:zpm	[B
    //   1027: iconst_0
    //   1028: aload 17
    //   1030: getfield 576	com/tencent/mm/plugin/voip/model/v2protocal:field_pstnChannelInfoLength	I
    //   1033: invokespecial 579	java/lang/String:<init>	([BII)V
    //   1036: putfield 552	com/tencent/mm/plugin/ipcall/model/d/b:sCw	Ljava/lang/String;
    //   1039: invokestatic 174	com/tencent/mm/plugin/ipcall/model/i:cHl	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   1042: getfield 206	com/tencent/mm/plugin/ipcall/model/d/a:sBX	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1045: astore 17
    //   1047: aload 17
    //   1049: aload 17
    //   1051: getfield 582	com/tencent/mm/plugin/voip/model/v2protocal:zpn	[B
    //   1054: aload 17
    //   1056: getfield 582	com/tencent/mm/plugin/voip/model/v2protocal:zpn	[B
    //   1059: arraylength
    //   1060: invokevirtual 586	com/tencent/mm/plugin/voip/model/v2protocal:getPstnEngineInfo	([BI)I
    //   1063: pop
    //   1064: ldc_w 571
    //   1067: ldc_w 588
    //   1070: iconst_1
    //   1071: anewarray 4	java/lang/Object
    //   1074: dup
    //   1075: iconst_0
    //   1076: aload 17
    //   1078: getfield 591	com/tencent/mm/plugin/voip/model/v2protocal:field_pstnEngineInfoLength	I
    //   1081: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1084: aastore
    //   1085: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1088: aload 16
    //   1090: new 162	java/lang/String
    //   1093: dup
    //   1094: aload 17
    //   1096: getfield 582	com/tencent/mm/plugin/voip/model/v2protocal:zpn	[B
    //   1099: iconst_0
    //   1100: aload 17
    //   1102: getfield 591	com/tencent/mm/plugin/voip/model/v2protocal:field_pstnEngineInfoLength	I
    //   1105: invokespecial 579	java/lang/String:<init>	([BII)V
    //   1108: putfield 555	com/tencent/mm/plugin/ipcall/model/d/b:sCv	Ljava/lang/String;
    //   1111: aload 16
    //   1113: invokestatic 174	com/tencent/mm/plugin/ipcall/model/i:cHl	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   1116: getfield 206	com/tencent/mm/plugin/ipcall/model/d/a:sBX	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1119: invokevirtual 594	com/tencent/mm/plugin/voip/model/v2protocal:dVz	()Ljava/lang/String;
    //   1122: putfield 597	com/tencent/mm/plugin/ipcall/model/d/b:sCx	Ljava/lang/String;
    //   1125: ldc 196
    //   1127: ldc_w 599
    //   1130: iconst_1
    //   1131: anewarray 4	java/lang/Object
    //   1134: dup
    //   1135: iconst_0
    //   1136: aload 16
    //   1138: getfield 552	com/tencent/mm/plugin/ipcall/model/d/b:sCw	Ljava/lang/String;
    //   1141: aastore
    //   1142: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1145: ldc 196
    //   1147: ldc_w 601
    //   1150: iconst_1
    //   1151: anewarray 4	java/lang/Object
    //   1154: dup
    //   1155: iconst_0
    //   1156: aload 16
    //   1158: getfield 555	com/tencent/mm/plugin/ipcall/model/d/b:sCv	Ljava/lang/String;
    //   1161: aastore
    //   1162: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1165: ldc 196
    //   1167: ldc_w 603
    //   1170: iconst_1
    //   1171: anewarray 4	java/lang/Object
    //   1174: dup
    //   1175: iconst_0
    //   1176: aload 16
    //   1178: getfield 597	com/tencent/mm/plugin/ipcall/model/d/b:sCx	Ljava/lang/String;
    //   1181: aastore
    //   1182: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1185: aload 15
    //   1187: getfield 206	com/tencent/mm/plugin/ipcall/model/d/a:sBX	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1190: invokevirtual 606	com/tencent/mm/plugin/voip/model/v2protocal:reset	()V
    //   1193: aload 15
    //   1195: invokevirtual 609	com/tencent/mm/plugin/ipcall/model/d/a:resetStatus	()V
    //   1198: getstatic 67	com/tencent/mm/plugin/ipcall/c:gAC	Lcom/tencent/mm/sdk/platformtools/ap;
    //   1201: aload_0
    //   1202: getfield 97	com/tencent/mm/plugin/ipcall/c:szB	Ljava/lang/Runnable;
    //   1205: invokevirtual 613	com/tencent/mm/sdk/platformtools/ap:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1208: getstatic 67	com/tencent/mm/plugin/ipcall/c:gAC	Lcom/tencent/mm/sdk/platformtools/ap;
    //   1211: aload_0
    //   1212: getfield 94	com/tencent/mm/plugin/ipcall/c:szA	Ljava/lang/Runnable;
    //   1215: invokevirtual 613	com/tencent/mm/sdk/platformtools/ap:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1218: aload_0
    //   1219: getfield 118	com/tencent/mm/plugin/ipcall/c:cOx	Lcom/tencent/mm/sdk/platformtools/av;
    //   1222: ifnull +15 -> 1237
    //   1225: aload_0
    //   1226: getfield 118	com/tencent/mm/plugin/ipcall/c:cOx	Lcom/tencent/mm/sdk/platformtools/av;
    //   1229: invokevirtual 123	com/tencent/mm/sdk/platformtools/av:stopTimer	()V
    //   1232: aload_0
    //   1233: aconst_null
    //   1234: putfield 118	com/tencent/mm/plugin/ipcall/c:cOx	Lcom/tencent/mm/sdk/platformtools/av;
    //   1237: invokestatic 188	com/tencent/mm/plugin/ipcall/model/i:cHm	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1240: iload_3
    //   1241: putfield 616	com/tencent/mm/plugin/ipcall/model/d/b:sCn	I
    //   1244: invokestatic 188	com/tencent/mm/plugin/ipcall/model/i:cHm	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1247: astore 15
    //   1249: ldc 196
    //   1251: ldc_w 618
    //   1254: invokestatic 468	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1257: aload 15
    //   1259: getfield 621	com/tencent/mm/plugin/ipcall/model/d/b:sCu	J
    //   1262: lconst_0
    //   1263: lcmp
    //   1264: ifne +64 -> 1328
    //   1267: aload 15
    //   1269: getfield 624	com/tencent/mm/plugin/ipcall/model/d/b:sCt	J
    //   1272: lconst_0
    //   1273: lcmp
    //   1274: ifeq +54 -> 1328
    //   1277: aload 15
    //   1279: invokestatic 339	java/lang/System:currentTimeMillis	()J
    //   1282: putfield 621	com/tencent/mm/plugin/ipcall/model/d/b:sCu	J
    //   1285: aload 15
    //   1287: aload 15
    //   1289: getfield 621	com/tencent/mm/plugin/ipcall/model/d/b:sCu	J
    //   1292: aload 15
    //   1294: getfield 624	com/tencent/mm/plugin/ipcall/model/d/b:sCt	J
    //   1297: lsub
    //   1298: ldc2_w 128
    //   1301: ldiv
    //   1302: putfield 627	com/tencent/mm/plugin/ipcall/model/d/b:sCm	J
    //   1305: ldc 196
    //   1307: ldc_w 629
    //   1310: iconst_1
    //   1311: anewarray 4	java/lang/Object
    //   1314: dup
    //   1315: iconst_0
    //   1316: aload 15
    //   1318: getfield 627	com/tencent/mm/plugin/ipcall/model/d/b:sCm	J
    //   1321: invokestatic 634	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1324: aastore
    //   1325: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1328: iload_1
    //   1329: bipush 8
    //   1331: if_icmpne +534 -> 1865
    //   1334: invokestatic 224	com/tencent/mm/plugin/ipcall/model/i:cHk	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1337: invokevirtual 637	com/tencent/mm/plugin/ipcall/model/g:cHh	()V
    //   1340: invokestatic 188	com/tencent/mm/plugin/ipcall/model/i:cHm	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1343: invokevirtual 640	com/tencent/mm/plugin/ipcall/model/d/b:cHH	()V
    //   1346: aload_0
    //   1347: getfield 642	com/tencent/mm/plugin/ipcall/c:szv	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1350: astore 15
    //   1352: aload 15
    //   1354: ifnull +53 -> 1407
    //   1357: ldc_w 644
    //   1360: ldc_w 646
    //   1363: iconst_1
    //   1364: anewarray 4	java/lang/Object
    //   1367: dup
    //   1368: iconst_0
    //   1369: aload 15
    //   1371: getfield 651	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   1374: invokestatic 634	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1377: aastore
    //   1378: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1381: aload 15
    //   1383: getfield 651	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   1386: ldc2_w 652
    //   1389: lcmp
    //   1390: ifeq +17 -> 1407
    //   1393: aload 15
    //   1395: iconst_2
    //   1396: putfield 656	com/tencent/mm/plugin/ipcall/model/h/k:field_status	I
    //   1399: invokestatic 660	com/tencent/mm/plugin/ipcall/model/i:cHr	()Lcom/tencent/mm/plugin/ipcall/model/h/l;
    //   1402: aload 15
    //   1404: invokevirtual 665	com/tencent/mm/plugin/ipcall/model/h/l:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)V
    //   1407: invokestatic 224	com/tencent/mm/plugin/ipcall/model/i:cHk	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1410: getfield 668	com/tencent/mm/plugin/ipcall/model/g:duq	Z
    //   1413: ifeq +186 -> 1599
    //   1416: aload_0
    //   1417: getfield 670	com/tencent/mm/plugin/ipcall/c:szC	Z
    //   1420: ifne +891 -> 2311
    //   1423: invokestatic 224	com/tencent/mm/plugin/ipcall/model/i:cHk	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1426: getfield 230	com/tencent/mm/plugin/ipcall/model/g:sAl	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   1429: getfield 253	com/tencent/mm/plugin/ipcall/model/b/c:roomId	I
    //   1432: ifeq +879 -> 2311
    //   1435: invokestatic 224	com/tencent/mm/plugin/ipcall/model/i:cHk	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1438: getfield 230	com/tencent/mm/plugin/ipcall/model/g:sAl	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   1441: getfield 673	com/tencent/mm/plugin/ipcall/model/b/c:sAZ	J
    //   1444: lconst_0
    //   1445: lcmp
    //   1446: ifeq +865 -> 2311
    //   1449: invokestatic 677	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   1452: astore 15
    //   1454: invokestatic 224	com/tencent/mm/plugin/ipcall/model/i:cHk	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1457: getfield 230	com/tencent/mm/plugin/ipcall/model/g:sAl	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   1460: getfield 253	com/tencent/mm/plugin/ipcall/model/b/c:roomId	I
    //   1463: istore_2
    //   1464: invokestatic 224	com/tencent/mm/plugin/ipcall/model/i:cHk	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1467: getfield 230	com/tencent/mm/plugin/ipcall/model/g:sAl	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   1470: getfield 673	com/tencent/mm/plugin/ipcall/model/b/c:sAZ	J
    //   1473: lstore 9
    //   1475: ldc_w 679
    //   1478: ldc_w 681
    //   1481: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1484: invokestatic 686	com/tencent/mm/plugin/ipcall/d:cGO	()Z
    //   1487: ifeq +112 -> 1599
    //   1490: invokestatic 692	com/tencent/mm/m/g:Zd	()Lcom/tencent/mm/m/e;
    //   1493: ldc_w 694
    //   1496: iconst_0
    //   1497: invokevirtual 700	com/tencent/mm/m/e:getInt	(Ljava/lang/String;I)I
    //   1500: istore_3
    //   1501: invokestatic 706	com/tencent/mm/model/az:arV	()Lcom/tencent/mm/model/c;
    //   1504: pop
    //   1505: invokestatic 712	com/tencent/mm/model/c:afk	()Lcom/tencent/mm/storage/ab;
    //   1508: getstatic 718	com/tencent/mm/storage/ae$a:Fja	Lcom/tencent/mm/storage/ae$a;
    //   1511: iconst_0
    //   1512: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1515: invokevirtual 724	com/tencent/mm/storage/ab:get	(Lcom/tencent/mm/storage/ae$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   1518: checkcast 180	java/lang/Integer
    //   1521: invokevirtual 727	java/lang/Integer:intValue	()I
    //   1524: istore_1
    //   1525: invokestatic 706	com/tencent/mm/model/az:arV	()Lcom/tencent/mm/model/c;
    //   1528: pop
    //   1529: invokestatic 712	com/tencent/mm/model/c:afk	()Lcom/tencent/mm/storage/ab;
    //   1532: getstatic 730	com/tencent/mm/storage/ae$a:FiZ	Lcom/tencent/mm/storage/ae$a;
    //   1535: lconst_0
    //   1536: invokestatic 634	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1539: invokevirtual 724	com/tencent/mm/storage/ab:get	(Lcom/tencent/mm/storage/ae$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   1542: checkcast 631	java/lang/Long
    //   1545: invokevirtual 733	java/lang/Long:longValue	()J
    //   1548: lstore 11
    //   1550: invokestatic 736	com/tencent/mm/sdk/platformtools/bt:aGK	()J
    //   1553: lstore 13
    //   1555: lload 13
    //   1557: lload 11
    //   1559: lsub
    //   1560: ldc2_w 737
    //   1563: lcmp
    //   1564: ifle +787 -> 2351
    //   1567: iconst_0
    //   1568: istore_1
    //   1569: ldc_w 679
    //   1572: ldc_w 740
    //   1575: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1578: iload_1
    //   1579: iload_3
    //   1580: if_icmplt +624 -> 2204
    //   1583: ldc_w 679
    //   1586: ldc_w 742
    //   1589: iload_3
    //   1590: invokestatic 744	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1593: invokevirtual 748	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1596: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1599: invokestatic 224	com/tencent/mm/plugin/ipcall/model/i:cHk	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1602: aconst_null
    //   1603: putfield 752	com/tencent/mm/plugin/ipcall/model/g:sAc	Lcom/tencent/mm/plugin/ipcall/model/g$a;
    //   1606: invokestatic 174	com/tencent/mm/plugin/ipcall/model/i:cHl	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   1609: aconst_null
    //   1610: putfield 756	com/tencent/mm/plugin/ipcall/model/d/a:sCc	Lcom/tencent/mm/plugin/ipcall/model/d/a$a;
    //   1613: invokestatic 147	com/tencent/mm/plugin/ipcall/model/i:cHo	()Lcom/tencent/mm/plugin/ipcall/model/f;
    //   1616: iconst_m1
    //   1617: putfield 239	com/tencent/mm/plugin/ipcall/model/f:ksb	I
    //   1620: invokestatic 760	com/tencent/mm/plugin/ipcall/model/i:cHi	()Lcom/tencent/mm/plugin/ipcall/model/i;
    //   1623: pop
    //   1624: invokestatic 763	com/tencent/mm/plugin/ipcall/model/a/a:NX	()V
    //   1627: aload_0
    //   1628: iconst_1
    //   1629: invokevirtual 766	com/tencent/mm/plugin/ipcall/c:mm	(Z)V
    //   1632: aload_0
    //   1633: invokespecial 769	com/tencent/mm/plugin/ipcall/c:removeListener	()V
    //   1636: ldc 109
    //   1638: ldc_w 771
    //   1641: iconst_0
    //   1642: anewarray 4	java/lang/Object
    //   1645: invokestatic 774	com/tencent/mm/sdk/platformtools/ad:m	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1648: bipush 26
    //   1650: invokestatic 779	com/tencent/mm/compatible/util/d:lf	(I)Z
    //   1653: ifeq +44 -> 1697
    //   1656: new 781	android/content/Intent
    //   1659: dup
    //   1660: invokespecial 782	android/content/Intent:<init>	()V
    //   1663: astore 15
    //   1665: aload 15
    //   1667: invokestatic 677	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   1670: ldc_w 784
    //   1673: invokevirtual 788	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   1676: pop
    //   1677: invokestatic 677	com/tencent/mm/sdk/platformtools/aj:getContext	()Landroid/content/Context;
    //   1680: aload 15
    //   1682: invokevirtual 792	android/content/Context:stopService	(Landroid/content/Intent;)Z
    //   1685: pop
    //   1686: iconst_1
    //   1687: istore_1
    //   1688: iload_1
    //   1689: ifeq +8 -> 1697
    //   1692: aload_0
    //   1693: iconst_0
    //   1694: putfield 77	com/tencent/mm/plugin/ipcall/c:szy	Z
    //   1697: sipush 25297
    //   1700: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1703: iconst_1
    //   1704: ireturn
    //   1705: iconst_2
    //   1706: invokestatic 320	com/tencent/mm/plugin/audio/c/a:setMode	(I)V
    //   1709: goto -1472 -> 237
    //   1712: iconst_2
    //   1713: istore 5
    //   1715: goto -1342 -> 373
    //   1718: astore 17
    //   1720: ldc_w 322
    //   1723: ldc_w 794
    //   1726: iconst_1
    //   1727: anewarray 4	java/lang/Object
    //   1730: dup
    //   1731: iconst_0
    //   1732: aload 17
    //   1734: aastore
    //   1735: invokestatic 797	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1738: aload 15
    //   1740: bipush 6
    //   1742: putfield 412	com/tencent/mm/plugin/voip/video/i:zwb	I
    //   1745: aload 16
    //   1747: invokevirtual 798	android/media/MediaPlayer:stop	()V
    //   1750: aload 16
    //   1752: invokevirtual 801	android/media/MediaPlayer:release	()V
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
    //   1798: invokevirtual 804	com/tencent/mm/plugin/ipcall/model/a/a:getStreamMaxVolume	(I)I
    //   1801: i2f
    //   1802: fstore 4
    //   1804: aload 17
    //   1806: iload 5
    //   1808: invokevirtual 807	com/tencent/mm/plugin/ipcall/model/a/a:getStreamVolume	(I)I
    //   1811: i2f
    //   1812: fload 4
    //   1814: fdiv
    //   1815: ldc_w 808
    //   1818: fmul
    //   1819: f2i
    //   1820: istore 5
    //   1822: goto -1180 -> 642
    //   1825: astore 15
    //   1827: aload 16
    //   1829: monitorexit
    //   1830: sipush 25297
    //   1833: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1836: aload 15
    //   1838: athrow
    //   1839: astore 16
    //   1841: aload 15
    //   1843: monitorexit
    //   1844: sipush 25297
    //   1847: invokestatic 70	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   1871: invokestatic 224	com/tencent/mm/plugin/ipcall/model/i:cHk	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1874: invokevirtual 637	com/tencent/mm/plugin/ipcall/model/g:cHh	()V
    //   1877: invokestatic 188	com/tencent/mm/plugin/ipcall/model/i:cHm	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1880: invokevirtual 640	com/tencent/mm/plugin/ipcall/model/d/b:cHH	()V
    //   1883: iload_2
    //   1884: bipush 11
    //   1886: if_icmpne +14 -> 1900
    //   1889: aload_0
    //   1890: getfield 642	com/tencent/mm/plugin/ipcall/c:szv	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1893: invokestatic 814	com/tencent/mm/plugin/ipcall/model/h/m:b	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1896: pop
    //   1897: goto -490 -> 1407
    //   1900: aload_0
    //   1901: getfield 642	com/tencent/mm/plugin/ipcall/c:szv	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1904: astore 15
    //   1906: aload 15
    //   1908: ifnull -501 -> 1407
    //   1911: ldc_w 644
    //   1914: ldc_w 816
    //   1917: iconst_1
    //   1918: anewarray 4	java/lang/Object
    //   1921: dup
    //   1922: iconst_0
    //   1923: aload 15
    //   1925: getfield 651	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   1928: invokestatic 634	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1931: aastore
    //   1932: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1935: aload 15
    //   1937: getfield 651	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   1940: ldc2_w 652
    //   1943: lcmp
    //   1944: ifeq -537 -> 1407
    //   1947: aload 15
    //   1949: bipush 6
    //   1951: putfield 656	com/tencent/mm/plugin/ipcall/model/h/k:field_status	I
    //   1954: invokestatic 660	com/tencent/mm/plugin/ipcall/model/i:cHr	()Lcom/tencent/mm/plugin/ipcall/model/h/l;
    //   1957: aload 15
    //   1959: invokevirtual 665	com/tencent/mm/plugin/ipcall/model/h/l:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)V
    //   1962: goto -555 -> 1407
    //   1965: iload_1
    //   1966: bipush 9
    //   1968: if_icmpne +33 -> 2001
    //   1971: invokestatic 224	com/tencent/mm/plugin/ipcall/model/i:cHk	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1974: iconst_1
    //   1975: invokevirtual 819	com/tencent/mm/plugin/ipcall/model/g:Fj	(I)V
    //   1978: invokestatic 188	com/tencent/mm/plugin/ipcall/model/i:cHm	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1981: invokevirtual 822	com/tencent/mm/plugin/ipcall/model/d/b:cHG	()V
    //   1984: aload_0
    //   1985: getfield 642	com/tencent/mm/plugin/ipcall/c:szv	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1988: invokestatic 188	com/tencent/mm/plugin/ipcall/model/i:cHm	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1991: getfield 627	com/tencent/mm/plugin/ipcall/model/d/b:sCm	J
    //   1994: invokestatic 825	com/tencent/mm/plugin/ipcall/model/h/m:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;J)Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1997: pop
    //   1998: goto -591 -> 1407
    //   2001: iload_1
    //   2002: bipush 10
    //   2004: if_icmpne +116 -> 2120
    //   2007: invokestatic 224	com/tencent/mm/plugin/ipcall/model/i:cHk	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   2010: iconst_1
    //   2011: invokevirtual 819	com/tencent/mm/plugin/ipcall/model/g:Fj	(I)V
    //   2014: invokestatic 188	com/tencent/mm/plugin/ipcall/model/i:cHm	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   2017: astore 15
    //   2019: ldc 196
    //   2021: ldc_w 827
    //   2024: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2027: aload 15
    //   2029: iconst_1
    //   2030: putfield 830	com/tencent/mm/plugin/ipcall/model/d/b:sCg	I
    //   2033: aload_0
    //   2034: getfield 642	com/tencent/mm/plugin/ipcall/c:szv	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2037: astore 15
    //   2039: invokestatic 188	com/tencent/mm/plugin/ipcall/model/i:cHm	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   2042: getfield 627	com/tencent/mm/plugin/ipcall/model/d/b:sCm	J
    //   2045: lstore 9
    //   2047: aload 15
    //   2049: ifnull -642 -> 1407
    //   2052: ldc_w 644
    //   2055: ldc_w 832
    //   2058: iconst_2
    //   2059: anewarray 4	java/lang/Object
    //   2062: dup
    //   2063: iconst_0
    //   2064: aload 15
    //   2066: getfield 651	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   2069: invokestatic 634	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2072: aastore
    //   2073: dup
    //   2074: iconst_1
    //   2075: lload 9
    //   2077: invokestatic 634	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2080: aastore
    //   2081: invokestatic 141	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2084: aload 15
    //   2086: getfield 651	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   2089: ldc2_w 652
    //   2092: lcmp
    //   2093: ifeq -686 -> 1407
    //   2096: aload 15
    //   2098: iconst_5
    //   2099: putfield 656	com/tencent/mm/plugin/ipcall/model/h/k:field_status	I
    //   2102: aload 15
    //   2104: lload 9
    //   2106: putfield 835	com/tencent/mm/plugin/ipcall/model/h/k:field_duration	J
    //   2109: invokestatic 660	com/tencent/mm/plugin/ipcall/model/i:cHr	()Lcom/tencent/mm/plugin/ipcall/model/h/l;
    //   2112: aload 15
    //   2114: invokevirtual 665	com/tencent/mm/plugin/ipcall/model/h/l:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)V
    //   2117: goto -710 -> 1407
    //   2120: iload_1
    //   2121: bipush 11
    //   2123: if_icmpne -716 -> 1407
    //   2126: iload_2
    //   2127: iconst_5
    //   2128: if_icmpne +33 -> 2161
    //   2131: invokestatic 224	com/tencent/mm/plugin/ipcall/model/i:cHk	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   2134: iconst_3
    //   2135: invokevirtual 819	com/tencent/mm/plugin/ipcall/model/g:Fj	(I)V
    //   2138: invokestatic 188	com/tencent/mm/plugin/ipcall/model/i:cHm	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   2141: invokevirtual 822	com/tencent/mm/plugin/ipcall/model/d/b:cHG	()V
    //   2144: iload_2
    //   2145: bipush 11
    //   2147: if_icmpne +40 -> 2187
    //   2150: aload_0
    //   2151: getfield 642	com/tencent/mm/plugin/ipcall/c:szv	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2154: invokestatic 814	com/tencent/mm/plugin/ipcall/model/h/m:b	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2157: pop
    //   2158: goto -751 -> 1407
    //   2161: iload_2
    //   2162: bipush 11
    //   2164: if_icmpne +13 -> 2177
    //   2167: invokestatic 224	com/tencent/mm/plugin/ipcall/model/i:cHk	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   2170: iconst_1
    //   2171: invokevirtual 819	com/tencent/mm/plugin/ipcall/model/g:Fj	(I)V
    //   2174: goto -36 -> 2138
    //   2177: invokestatic 224	com/tencent/mm/plugin/ipcall/model/i:cHk	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   2180: iconst_2
    //   2181: invokevirtual 819	com/tencent/mm/plugin/ipcall/model/g:Fj	(I)V
    //   2184: goto -46 -> 2138
    //   2187: aload_0
    //   2188: getfield 642	com/tencent/mm/plugin/ipcall/c:szv	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2191: invokestatic 188	com/tencent/mm/plugin/ipcall/model/i:cHm	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   2194: getfield 627	com/tencent/mm/plugin/ipcall/model/d/b:sCm	J
    //   2197: invokestatic 825	com/tencent/mm/plugin/ipcall/model/h/m:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;J)Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2200: pop
    //   2201: goto -794 -> 1407
    //   2204: lload 13
    //   2206: lload 11
    //   2208: lsub
    //   2209: ldc2_w 836
    //   2212: lcmp
    //   2213: ifge +15 -> 2228
    //   2216: ldc_w 679
    //   2219: ldc_w 839
    //   2222: invokestatic 116	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2225: goto -626 -> 1599
    //   2228: invokestatic 706	com/tencent/mm/model/az:arV	()Lcom/tencent/mm/model/c;
    //   2231: pop
    //   2232: invokestatic 712	com/tencent/mm/model/c:afk	()Lcom/tencent/mm/storage/ab;
    //   2235: getstatic 718	com/tencent/mm/storage/ae$a:Fja	Lcom/tencent/mm/storage/ae$a;
    //   2238: iload_1
    //   2239: iconst_1
    //   2240: iadd
    //   2241: invokestatic 184	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2244: invokevirtual 843	com/tencent/mm/storage/ab:set	(Lcom/tencent/mm/storage/ae$a;Ljava/lang/Object;)V
    //   2247: invokestatic 706	com/tencent/mm/model/az:arV	()Lcom/tencent/mm/model/c;
    //   2250: pop
    //   2251: invokestatic 712	com/tencent/mm/model/c:afk	()Lcom/tencent/mm/storage/ab;
    //   2254: getstatic 730	com/tencent/mm/storage/ae$a:FiZ	Lcom/tencent/mm/storage/ae$a;
    //   2257: lload 13
    //   2259: invokestatic 634	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2262: invokevirtual 843	com/tencent/mm/storage/ab:set	(Lcom/tencent/mm/storage/ae$a;Ljava/lang/Object;)V
    //   2265: new 781	android/content/Intent
    //   2268: dup
    //   2269: invokespecial 782	android/content/Intent:<init>	()V
    //   2272: astore 16
    //   2274: aload 16
    //   2276: ldc_w 845
    //   2279: iload_2
    //   2280: invokevirtual 849	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2283: pop
    //   2284: aload 16
    //   2286: ldc_w 851
    //   2289: lload 9
    //   2291: invokevirtual 854	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   2294: pop
    //   2295: aload 15
    //   2297: ldc_w 504
    //   2300: ldc_w 856
    //   2303: aload 16
    //   2305: invokestatic 861	com/tencent/mm/bs/d:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   2308: goto -709 -> 1599
    //   2311: ldc 109
    //   2313: ldc_w 863
    //   2316: invokestatic 866	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2319: goto -720 -> 1599
    //   2322: astore 15
    //   2324: ldc 109
    //   2326: aload 15
    //   2328: ldc_w 868
    //   2331: iconst_1
    //   2332: anewarray 4	java/lang/Object
    //   2335: dup
    //   2336: iconst_0
    //   2337: aload 15
    //   2339: invokevirtual 871	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2342: aastore
    //   2343: invokestatic 875	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
  
  private void removeListener()
  {
    AppMethodBeat.i(25295);
    if (this.szx != null)
    {
      this.szx.listen(this.klv, 0);
      this.szx = null;
    }
    com.tencent.mm.sdk.b.a.ESL.d(this.szz);
    AppMethodBeat.o(25295);
  }
  
  public final void Ff(int paramInt)
  {
    AppMethodBeat.i(25315);
    ad.i("MicroMsg.IPCallManager", "onChannelConnectFailed, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cHo().ksb) });
    if (com.tencent.mm.plugin.ipcall.model.i.cHl().sCa)
    {
      ad.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel already connected");
      if (fT(5, paramInt))
      {
        f(5, null, aj.getContext().getString(2131756758), 1);
        AppMethodBeat.o(25315);
      }
    }
    else
    {
      ad.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel not connet, may be request connect failed");
      if (fT(4, paramInt)) {
        f(4, null, aj.getContext().getString(2131756758), 1);
      }
    }
    AppMethodBeat.o(25315);
  }
  
  public final void R(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(25300);
    ad.i("MicroMsg.IPCallManager", "onInviteFailed, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cHo().ksb) });
    if (fT(2, 0)) {
      f(2, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(25300);
  }
  
  public final void S(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(25309);
    ad.i("MicroMsg.IPCallManager", "onAccountOverdue, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cHo().ksb) });
    if (fT(8, 9)) {
      f(8, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(25309);
  }
  
  public final void T(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(25310);
    ad.i("MicroMsg.IPCallManager", "onCallRestricted, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cHo().ksb) });
    if (fT(10, 0)) {
      f(10, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(25310);
  }
  
  public final void U(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(25311);
    ad.i("MicroMsg.IPCallManager", "onCallPhoneNumberInvalid, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cHo().ksb) });
    if (fT(11, 0)) {
      f(11, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(25311);
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25296);
    if (com.tencent.mm.plugin.ipcall.model.i.cHo().cHd())
    {
      ad.i("MicroMsg.IPCallManager", "startIPCall, already start!");
      AppMethodBeat.o(25296);
      return false;
    }
    ad.i("MicroMsg.IPCallManager", "startIPCall");
    com.tencent.mm.plugin.ipcall.model.i.cHk().sAc = this;
    com.tencent.mm.plugin.ipcall.model.i.cHl().sCc = this;
    com.tencent.mm.plugin.ipcall.model.i.cHo().ksb = -1;
    removeListener();
    this.szx = ((TelephonyManager)aj.getContext().getSystemService("phone"));
    this.szx.listen(this.klv, 32);
    com.tencent.mm.sdk.b.a.ESL.c(this.szz);
    ad.d("MicroMsg.IPCallRecordStorageLogic", "recordStartCall, phoneNumber: %s, contactId: %s", new Object[] { paramString4, paramString5 });
    Object localObject = new k();
    ((k)localObject).field_phonenumber = paramString4;
    if (!bt.isNullOrNil(paramString5))
    {
      com.tencent.mm.plugin.ipcall.model.h.c localc = com.tencent.mm.plugin.ipcall.model.i.cHq().adU(paramString5);
      if ((localc != null) && (localc.systemRowid != -1L))
      {
        ((k)localObject).field_addressId = localc.systemRowid;
        if (paramInt1 == -1) {
          break label865;
        }
        ((k)localObject).field_phoneType = paramInt1;
        label201:
        ((k)localObject).field_calltime = bt.eGO();
        ((k)localObject).field_status = 1;
        if (!com.tencent.mm.plugin.ipcall.model.i.cHr().insert((com.tencent.mm.sdk.e.c)localObject)) {
          break label874;
        }
        label226:
        this.szv = ((k)localObject);
        gAC.postDelayed(this.szB, 1754L);
        this.szw = false;
        localObject = com.tencent.mm.plugin.ipcall.model.i.cHm();
        ad.d("MicroMsg.IPCallReportHelper", "reset");
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCe = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCf = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCg = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCh = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCi = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCj = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCk = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCl = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCm = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCn = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).roomId = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sAY = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCo = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).ioa = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCp = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCq = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCs = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCr = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).szE = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCt = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCu = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCz = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCy = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCv = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCw = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).countryCode = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCA = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCB = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCC = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCD = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCE = 0;
        com.tencent.mm.plugin.ipcall.model.i.cHo().ksb = -1;
        ad.d("MicroMsg.IPCallManager", "startIPCall, username: %s, phoneNumber: %s", new Object[] { paramString3, paramString4 });
        localObject = com.tencent.mm.plugin.ipcall.model.i.cHk();
        ad.d("MicroMsg.IPCallSvrLogic", "startIPCall, toUsername: %s, toPhoneNumber: %s", new Object[] { paramString3, paramString4 });
        ((g)localObject).duq = false;
        ((g)localObject).sAm = false;
        ((g)localObject).szX = 0;
        ((g)localObject).szY = 0;
        ((g)localObject).szZ = 0;
        ((g)localObject).sAa = false;
        ((g)localObject).sAb = false;
        ((g)localObject).sAn = false;
        ((g)localObject).sAl = new com.tencent.mm.plugin.ipcall.model.b.c();
        ((g)localObject).sAl.nickname = paramString1;
        ((g)localObject).sAl.sBy = paramString2;
        ((g)localObject).sAl.dAc = paramString5;
        ((g)localObject).sAl.sBz = paramString4;
        ((g)localObject).sAl.dxK = paramString3;
        ((g)localObject).sAl.sBa = ((int)System.currentTimeMillis());
        ((g)localObject).sAl.sBb = paramInt2;
        ((g)localObject).sAl.sBc = paramInt3;
        ((g)localObject).sAl.sBB = paramInt1;
        ((g)localObject).sAd.a(((g)localObject).sAl);
        ((g)localObject).sAi.a(((g)localObject).sAl);
        ad.i("MicroMsg.IPCallSvrLogic", "startIPCallInternal, inviteId: %d", new Object[] { Integer.valueOf(((g)localObject).sAl.sBa) });
        com.tencent.mm.plugin.ipcall.model.i.cHo().Fh(1);
        paramString1 = com.tencent.mm.plugin.ipcall.model.i.cHl();
        if (!paramString1.sCb) {
          break label880;
        }
        ad.d("MicroMsg.IPCallEngineManager", "already start engine");
      }
    }
    for (;;)
    {
      gAC.removeCallbacks(this.szA);
      gAC.postDelayed(this.szA, 60000L);
      ad.m("MicroMsg.IPCallManager", "bindIPCallForegroundIfNeed", new Object[0]);
      if ((com.tencent.mm.compatible.util.d.lf(26)) && (!this.szy))
      {
        paramString1 = new Intent();
        paramString1.setClass(aj.getContext(), IPCallForegroundService.class);
      }
      try
      {
        aj.getContext().startService(paramString1);
        paramInt1 = 1;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          long l;
          ad.printErrStackTrace("MicroMsg.IPCallManager", paramString2, "using start service to bindIPCallForegroundIfNeed error: %s", new Object[] { paramString2.getMessage() });
          try
          {
            aj.getContext().startForegroundService(paramString1);
            paramInt1 = 0;
          }
          catch (Exception paramString1)
          {
            ad.printErrStackTrace("MicroMsg.IPCallManager", paramString1, "using start foreground service to bindIPCallForegroundIfNeed error: %s", new Object[] { paramString1.getMessage() });
            paramInt1 = 0;
          }
        }
      }
      if (paramInt1 != 0) {
        this.szy = true;
      }
      AppMethodBeat.o(25296);
      return true;
      ((k)localObject).field_addressId = -1L;
      break;
      ((k)localObject).field_addressId = -1L;
      break;
      label865:
      ((k)localObject).field_phoneType = -1;
      break label201;
      label874:
      localObject = null;
      break label226;
      label880:
      paramString1.resetStatus();
      ad.i("MicroMsg.IPCallEngineManager", "start engine");
      if (paramString1.sBX.dVA())
      {
        paramString1.sBX.rG(false);
        paramString1.sBX.reset();
      }
      paramString1.sBX.znr = 1;
      l = System.currentTimeMillis();
      paramInt1 = paramString1.sBX.dVC();
      ad.d("MicroMsg.IPCallEngineManager", "protocal init finish, ret: %d, used %dms", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() - l) });
      if ((paramString1.sBX.field_capInfo != null) && (paramString1.sBX.exchangeCabInfo(paramString1.sBX.field_capInfo, paramString1.sBX.field_capInfo.length) < 0))
      {
        ad.e("MicroMsg.IPCallEngineManager", "exchangeCabInfo failed");
        com.tencent.mm.plugin.ipcall.model.i.cHm().sCn = 24;
      }
      if (paramInt1 < 0) {
        ad.e("MicroMsg.IPCallEngineManager", "engine init failed!");
      }
      paramString1.sBX.znr = 1;
      paramString1.sCb = true;
    }
  }
  
  public final void cGB()
  {
    AppMethodBeat.i(25299);
    ad.i("MicroMsg.IPCallManager", "onInviteSuccess");
    if (!com.tencent.mm.plugin.ipcall.model.i.cHo().Fh(3))
    {
      AppMethodBeat.o(25299);
      return;
    }
    Object localObject = com.tencent.mm.plugin.ipcall.model.i.cHm();
    ad.d("MicroMsg.IPCallReportHelper", "markStartInvite");
    if (((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCr == 0L) {
      ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).sCr = System.currentTimeMillis();
    }
    localObject = com.tencent.mm.plugin.ipcall.model.i.cHk().sAl;
    com.tencent.mm.plugin.ipcall.model.d.b localb = com.tencent.mm.plugin.ipcall.model.i.cHm();
    int i = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).sBa;
    String str1 = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).dxK;
    String str2 = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).sBz;
    int j = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).roomId;
    long l1 = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).sAY;
    long l2 = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).sAZ;
    localb.sBa = i;
    localb.sCq = str1;
    localb.ioa = str2;
    localb.roomId = j;
    localb.sAY = l1;
    localb.sCo = l2;
    if (this.szu != null) {
      this.szu.cGB();
    }
    AppMethodBeat.o(25299);
  }
  
  public final void cGC()
  {
    AppMethodBeat.i(25301);
    ad.i("MicroMsg.IPCallManager", "onStartRing, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cHo().ksb) });
    if (!com.tencent.mm.plugin.ipcall.model.i.cHo().Fh(4))
    {
      AppMethodBeat.o(25301);
      return;
    }
    com.tencent.mm.plugin.ipcall.model.d.b localb = com.tencent.mm.plugin.ipcall.model.i.cHm();
    ad.d("MicroMsg.IPCallReportHelper", "markStartRing");
    if (localb.sCs == 0L)
    {
      localb.sCs = System.currentTimeMillis();
      localb.sCj = (localb.sCs - localb.sCr);
      ad.d("MicroMsg.IPCallReportHelper", "ringTime: %d", new Object[] { Long.valueOf(localb.sCj) });
    }
    com.tencent.mm.plugin.ipcall.model.i.cHl().cHF();
    localb = com.tencent.mm.plugin.ipcall.model.i.cHm();
    ad.i("MicroMsg.IPCallReportHelper", "startRing");
    localb.sCe = 1;
    if (this.szu != null) {
      this.szu.cGC();
    }
    AppMethodBeat.o(25301);
  }
  
  public final void cGD()
  {
    AppMethodBeat.i(25302);
    ad.i("MicroMsg.IPCallManager", "onAccept, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cHo().ksb) });
    if (!com.tencent.mm.plugin.ipcall.model.i.cHo().Fh(5))
    {
      AppMethodBeat.o(25302);
      return;
    }
    com.tencent.mm.plugin.ipcall.model.d.b localb = com.tencent.mm.plugin.ipcall.model.i.cHm();
    ad.d("MicroMsg.IPCallReportHelper", "markUserAccept");
    if (localb.szE == 0L)
    {
      localb.szE = System.currentTimeMillis();
      localb.sCk = (localb.szE - localb.sCr);
      ad.d("MicroMsg.IPCallReportHelper", "answerTime: %d", new Object[] { Long.valueOf(localb.sCk) });
    }
    com.tencent.mm.plugin.ipcall.model.i.cHl().cHF();
    localb = com.tencent.mm.plugin.ipcall.model.i.cHm();
    ad.i("MicroMsg.IPCallReportHelper", "userAccept");
    localb.sCf = 1;
    gAC.removeCallbacks(this.szA);
    com.tencent.mm.plugin.ipcall.model.i.cHu().stop();
    gAC.removeCallbacks(this.szB);
    com.tencent.mm.plugin.ipcall.model.i.cHn().sBG.aZs();
    if ((com.tencent.mm.plugin.ipcall.model.i.cHl().sCa) && (!this.szw))
    {
      com.tencent.mm.plugin.ipcall.model.i.cHm().cHI();
      com.tencent.mm.plugin.ipcall.model.i.cHm().cHL();
      this.szw = true;
      this.szE = bt.aGK();
      aKf();
      com.tencent.mm.plugin.ipcall.model.i.cHl().cHE();
      if (this.szu != null) {
        this.szu.cGP();
      }
      com.tencent.mm.plugin.ipcall.model.i.cHm().cHK();
      r.dTT().dTU();
      r.dTT().a(this);
    }
    AppMethodBeat.o(25302);
  }
  
  public final void cGE()
  {
    AppMethodBeat.i(25306);
    ad.i("MicroMsg.IPCallManager", "onShutdownByOtherSide, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cHo().ksb) });
    if (af(10, 0, 32))
    {
      if (this.szu != null)
      {
        this.szu.cGQ();
        AppMethodBeat.o(25306);
        return;
      }
      Toast.makeText(aj.getContext(), aj.getContext().getString(2131760500), 1).show();
    }
    AppMethodBeat.o(25306);
  }
  
  public final void cGF()
  {
    AppMethodBeat.i(25308);
    ad.i("MicroMsg.IPCallManager", "onHeartbeatFailed");
    if (fT(7, 29)) {
      f(7, null, aj.getContext().getString(2131756758), 1);
    }
    AppMethodBeat.o(25308);
  }
  
  public final void cGG()
  {
    AppMethodBeat.i(25312);
    do
    {
      ad.i("MicroMsg.IPCallManager", "onDisasterHappen, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cHo().ksb) });
    } while (fT(12, 0));
    AppMethodBeat.o(25312);
  }
  
  public final void cGH()
  {
    AppMethodBeat.i(25313);
    ad.i("MicroMsg.IPCallManager", "onStartEngineFailed, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cHo().ksb) });
    if (fT(6, 0)) {
      f(6, null, aj.getContext().getString(2131756764), 1);
    }
    AppMethodBeat.o(25313);
  }
  
  public final void cGI()
  {
    AppMethodBeat.i(25314);
    ad.i("MicroMsg.IPCallManager", "onChannelConnected, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cHo().ksb) });
    com.tencent.mm.plugin.ipcall.model.i.cHu().stop();
    gAC.removeCallbacks(this.szB);
    Object localObject1;
    Object localObject2;
    if (com.tencent.mm.plugin.ipcall.model.i.cHo().cHe())
    {
      localObject1 = com.tencent.mm.plugin.ipcall.model.i.cHn();
      ((com.tencent.mm.plugin.ipcall.model.c.b)localObject1).sBG.b("ipcall", Integer.valueOf(4));
      ad.d("MicroMsg.IPCallDeviceManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.ipcall.model.a.a.vQ(3)), Boolean.valueOf(com.tencent.mm.plugin.ipcall.model.a.a.vQ(4)) });
      localObject1 = ((com.tencent.mm.plugin.ipcall.model.c.b)localObject1).sBG;
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).sAQ;
      if (localObject2 != null)
      {
        if (!((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).isStart) {
          break label345;
        }
        ad.d("MicroMsg.IPCallAudioPlayer", "startPlay, already start");
      }
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).sAP;
      if (localObject2 != null)
      {
        if (((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).bvy() != 3) {
          break label452;
        }
        bool = true;
        label156:
        ((a.b)localObject2).mu(bool);
      }
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).sAP;
      if (localObject2 != null) {
        if (((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).bvy() != 4) {
          break label457;
        }
      }
    }
    label452:
    label457:
    for (boolean bool = true;; bool = false)
    {
      ((a.b)localObject2).mv(bool);
      com.tencent.mm.plugin.ipcall.model.i.cHm().cHI();
      com.tencent.mm.plugin.ipcall.model.i.cHn().sBG.aZs();
      if ((com.tencent.mm.plugin.ipcall.model.i.cHo().cHg()) && (!this.szw))
      {
        com.tencent.mm.plugin.ipcall.model.i.cHm().cHL();
        com.tencent.mm.plugin.ipcall.model.i.cHl().cHE();
        this.szw = true;
        this.szE = bt.aGK();
        aKf();
        if (this.szu != null) {
          this.szu.cGP();
        }
        localObject1 = this.szv;
        if (localObject1 != null)
        {
          ad.d("MicroMsg.IPCallRecordStorageLogic", "recordStartTalk, localId: %d", new Object[] { Long.valueOf(((k)localObject1).systemRowid) });
          if (((k)localObject1).systemRowid != -1L)
          {
            ((k)localObject1).field_status = 3;
            com.tencent.mm.plugin.ipcall.model.i.cHr().a((k)localObject1);
          }
        }
        com.tencent.mm.plugin.ipcall.model.i.cHm().cHK();
        r.dTT().dTU();
        r.dTT().a(this);
      }
      AppMethodBeat.o(25314);
      return;
      label345:
      ad.i("MicroMsg.IPCallAudioPlayer", "startPlay");
      if (((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).nPx == null)
      {
        ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).nPx = new com.tencent.mm.plugin.voip.model.c();
        ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).nPx.K(v2protocal.VOICE_SAMPLERATE, 1, 20, 1);
      }
      ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).sBE = ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).nPx.z(aj.getContext(), false);
      ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).nPx.zfJ = new a.1((com.tencent.mm.plugin.ipcall.model.c.a)localObject2);
      if (((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).nPx.dRU() <= 0) {
        com.tencent.mm.plugin.ipcall.model.i.cHm().cHJ();
      }
      ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).sBG.ck(((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).sBF);
      ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).isStart = true;
      break;
      bool = false;
      break label156;
    }
  }
  
  public final void cGJ()
  {
    AppMethodBeat.i(25318);
    if (com.tencent.mm.plugin.ipcall.model.i.cHo().ksb != 5)
    {
      ad.i("MicroMsg.IPCallManager", "onResumeGoodNetStatus currentState != accept:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.ipcall.model.i.cHo().ksb) });
      AppMethodBeat.o(25318);
      return;
    }
    com.tencent.mm.plugin.ipcall.model.c.b localb = com.tencent.mm.plugin.ipcall.model.i.cHn();
    ad.i("MicroMsg.IPCallDeviceManager", "onResumeGoodNetStatus");
    if (localb.sBK != null) {
      localb.sBK.cIC();
    }
    AppMethodBeat.o(25318);
  }
  
  public final void cGK()
  {
    AppMethodBeat.i(25319);
    synchronized (this.pZB)
    {
      if (com.tencent.mm.plugin.ipcall.model.i.cHo().cHd())
      {
        if (this.szC)
        {
          cGL();
          AppMethodBeat.o(25319);
          return;
        }
        this.szC = true;
        Toast.makeText(aj.getContext(), 2131761425, 0).show();
        Intent localIntent = new Intent();
        localIntent.setFlags(268435456);
        localIntent.setClass(aj.getContext(), IPCallTalkUI.class);
        localIntent.putExtra("IPCallTalkUI_isFromMiniNotification", true);
        com.tencent.mm.plugin.voip.c.dRR().a(localIntent, false, true, this.szD);
        cGL();
        if (this.szu != null) {
          this.szu.cGR();
        }
      }
      AppMethodBeat.o(25319);
      return;
    }
  }
  
  public final void cGL()
  {
    AppMethodBeat.i(25320);
    if (com.tencent.mm.compatible.util.d.lg(26)) {
      if (!com.tencent.mm.plugin.ipcall.model.i.cHo().cHg()) {
        break label249;
      }
    }
    label249:
    for (Object localObject1 = aj.getContext().getString(2131760459, new Object[] { String.format("%02d:%02d", new Object[] { Long.valueOf(bt.lZ(this.szE) / 60L), Long.valueOf(bt.lZ(this.szE) % 60L) }) });; localObject1 = aj.getContext().getString(2131760458))
    {
      Object localObject2 = new Intent(aj.getContext(), IPCallTalkUI.class);
      ((Intent)localObject2).putExtra("IPCallTalkUI_isFromMiniNotification", true);
      localObject2 = PendingIntent.getActivity(aj.getContext(), 42, (Intent)localObject2, 134217728);
      int i = 2131233502;
      if (com.tencent.mm.compatible.util.d.lg(19)) {
        i = 2131233500;
      }
      localObject1 = com.tencent.mm.br.a.bD(aj.getContext(), "reminder_channel_id").i(aj.getContext().getString(2131760458)).g(System.currentTimeMillis()).f(aj.getContext().getString(2131760448)).g((CharSequence)localObject1);
      ((s.c)localObject1).Ew = ((PendingIntent)localObject2);
      localObject1 = ((s.c)localObject1).build();
      ((Notification)localObject1).icon = i;
      ((Notification)localObject1).flags |= 0x20;
      az.getNotification().a(42, (Notification)localObject1, false);
      if (com.tencent.mm.plugin.ipcall.model.i.cHo().cHg()) {
        break;
      }
      com.tencent.mm.plugin.voip.c.dRR().atl(aj.getContext().getString(2131761459));
      AppMethodBeat.o(25320);
      return;
    }
    com.tencent.mm.plugin.voip.c.dRR().sa(cGM());
    AppMethodBeat.o(25320);
  }
  
  public final int cGM()
  {
    AppMethodBeat.i(25322);
    int i = (int)bt.lZ(this.szE);
    if (i > 0)
    {
      AppMethodBeat.o(25322);
      return i;
    }
    AppMethodBeat.o(25322);
    return 0;
  }
  
  public final void dx(String paramString, int paramInt)
  {
    AppMethodBeat.i(25304);
    ad.i("MicroMsg.IPCallManager", "onUnAvaliable, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cHo().ksb) });
    if (fT(3, 5)) {
      f(3, null, paramString, paramInt);
    }
    AppMethodBeat.o(25304);
  }
  
  public final void dy(String paramString, int paramInt)
  {
    AppMethodBeat.i(25305);
    ad.i("MicroMsg.IPCallManager", "onBusy, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cHo().ksb) });
    if (fT(1, 4)) {
      f(1, null, paramString, paramInt);
    }
    AppMethodBeat.o(25305);
  }
  
  public final void dz(String paramString, int paramInt)
  {
    AppMethodBeat.i(25307);
    ad.i("MicroMsg.IPCallManager", "onSyncFailed");
    if (fT(7, 35)) {
      f(7, null, paramString, paramInt);
    }
    AppMethodBeat.o(25307);
  }
  
  public final void f(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(25303);
    if (this.szu != null)
    {
      this.szu.f(paramInt1, paramString1, paramString2, paramInt2);
      AppMethodBeat.o(25303);
      return;
    }
    Toast.makeText(aj.getContext(), paramString2, 1).show();
    AppMethodBeat.o(25303);
  }
  
  public final boolean fT(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(25316);
    if (com.tencent.mm.plugin.ipcall.model.i.cHo().cHg())
    {
      if (paramInt1 == 0)
      {
        bool = af(9, paramInt1, paramInt2);
        AppMethodBeat.o(25316);
        return bool;
      }
      bool = af(11, paramInt1, paramInt2);
      AppMethodBeat.o(25316);
      return bool;
    }
    if (paramInt1 == 0)
    {
      bool = af(8, paramInt1, paramInt2);
      AppMethodBeat.o(25316);
      return bool;
    }
    boolean bool = af(12, paramInt1, paramInt2);
    AppMethodBeat.o(25316);
    return bool;
  }
  
  public final void ml(boolean paramBoolean)
  {
    AppMethodBeat.i(25317);
    if (com.tencent.mm.plugin.ipcall.model.i.cHo().ksb != 5)
    {
      ad.i("MicroMsg.IPCallManager", "onBadNetStatus currentState != accept:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.ipcall.model.i.cHo().ksb) });
      AppMethodBeat.o(25317);
      return;
    }
    com.tencent.mm.plugin.ipcall.model.c.b localb = com.tencent.mm.plugin.ipcall.model.i.cHn();
    ad.i("MicroMsg.IPCallDeviceManager", "onBadNetStatus");
    if (localb.sBK != null)
    {
      j localj = localb.sBK;
      if (localj.sKW != null) {
        localj.sKW.setVisibility(0);
      }
      if (localj.sKX != null) {
        localj.sKX.setVisibility(0);
      }
    }
    if (!localb.sBG.isSpeakerphoneOn())
    {
      long l = System.currentTimeMillis();
      if (l - localb.sBL > 30000L)
      {
        localb.sBL = l;
        com.tencent.mm.plugin.voip.c.dRQ().zlR.dVb();
      }
    }
    AppMethodBeat.o(25317);
  }
  
  public final void mm(boolean paramBoolean)
  {
    AppMethodBeat.i(185745);
    synchronized (this.pZB)
    {
      this.szC = false;
      com.tencent.mm.plugin.voip.c.dRR().pE(paramBoolean);
      ((NotificationManager)aj.getContext().getSystemService("notification")).cancel(42);
      AppMethodBeat.o(185745);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.c
 * JD-Core Version:    0.7.0.1
 */