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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;

public final class c
  implements a.a, g.a, r.a
{
  private static ao gox;
  private au cLS;
  private PhoneStateListener kMN;
  private Object qIi;
  public e tHe;
  private k tHf;
  private boolean tHg;
  private TelephonyManager tHh;
  private boolean tHi;
  private com.tencent.mm.sdk.b.c tHj;
  private Runnable tHk;
  private Runnable tHl;
  private boolean tHm;
  private com.tencent.mm.plugin.voip.ui.a tHn;
  private long tHo;
  
  static
  {
    AppMethodBeat.i(25324);
    gox = new ao(Looper.getMainLooper());
    AppMethodBeat.o(25324);
  }
  
  public c()
  {
    AppMethodBeat.i(25294);
    this.tHg = false;
    this.tHi = false;
    this.qIi = new Object();
    this.kMN = new PhoneStateListener()
    {
      public final void onCallStateChanged(int paramAnonymousInt, String paramAnonymousString)
      {
        AppMethodBeat.i(25288);
        super.onCallStateChanged(paramAnonymousInt, paramAnonymousString);
        ac.d("MicroMsg.IPCallManager", "onCallStateChanged ".concat(String.valueOf(paramAnonymousInt)));
        if (paramAnonymousInt == 2)
        {
          ac.i("MicroMsg.IPCallManager", "system phone call state offhook, stop call");
          c.this.ga(0, 0);
        }
        AppMethodBeat.o(25288);
      }
    };
    this.tHj = new c.2(this);
    this.tHk = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(25289);
        if (!com.tencent.mm.plugin.ipcall.model.i.cUz().cUr())
        {
          ac.i("MicroMsg.IPCallManager", "timeout! still not accept!");
          if (c.this.ga(9, 12)) {
            c.this.g(9, null, ai.getContext().getString(2131756764), 2);
          }
        }
        AppMethodBeat.o(25289);
      }
    };
    this.tHl = new Runnable()
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
        //   13: invokestatic 33	com/tencent/mm/plugin/ipcall/model/i:cUF	()Lcom/tencent/mm/plugin/voip/video/i;
        //   16: astore 6
        //   18: aload 6
        //   20: iconst_0
        //   21: putfield 39	com/tencent/mm/plugin/voip/video/i:AOS	I
        //   24: ldc2_w 40
        //   27: ldc2_w 42
        //   30: lcmp
        //   31: ifeq +240 -> 271
        //   34: invokestatic 49	com/tencent/mm/sdk/platformtools/ai:ciE	()Z
        //   37: ifeq +255 -> 292
        //   40: invokestatic 55	com/tencent/mm/kernel/g:agR	()Lcom/tencent/mm/kernel/e;
        //   43: invokevirtual 61	com/tencent/mm/kernel/e:agA	()Lcom/tencent/mm/storage/ae;
        //   46: ldc 62
        //   48: getstatic 68	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
        //   51: invokevirtual 74	com/tencent/mm/storage/ae:get	(ILjava/lang/Object;)Ljava/lang/Object;
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
        //   78: invokestatic 90	com/tencent/mm/m/a:Zj	()Z
        //   81: invokestatic 85	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   84: aastore
        //   85: dup
        //   86: iconst_2
        //   87: getstatic 68	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
        //   90: aastore
        //   91: invokestatic 95	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   94: iload_3
        //   95: istore_2
        //   96: iload_2
        //   97: ifeq +167 -> 264
        //   100: aload 6
        //   102: getfield 99	com/tencent/mm/plugin/voip/video/i:aKd	Z
        //   105: ifne +159 -> 264
        //   108: aload 6
        //   110: invokestatic 105	java/lang/System:currentTimeMillis	()J
        //   113: putfield 109	com/tencent/mm/plugin/voip/video/i:AOT	J
        //   116: aload 6
        //   118: new 111	com/tencent/mm/compatible/b/k
        //   121: dup
        //   122: invokespecial 112	com/tencent/mm/compatible/b/k:<init>	()V
        //   125: putfield 116	com/tencent/mm/plugin/voip/video/i:AOR	Landroid/media/MediaPlayer;
        //   128: ldc 79
        //   130: ldc 118
        //   132: iconst_2
        //   133: anewarray 4	java/lang/Object
        //   136: dup
        //   137: iconst_0
        //   138: invokestatic 123	com/tencent/mm/plugin/audio/c/a:bCy	()Z
        //   141: invokestatic 85	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   144: aastore
        //   145: dup
        //   146: iconst_1
        //   147: invokestatic 126	com/tencent/mm/plugin/audio/c/a:bCs	()Z
        //   150: invokestatic 85	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   153: aastore
        //   154: invokestatic 129	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   157: getstatic 135	com/tencent/mm/compatible/deviceinfo/ae:fJe	Lcom/tencent/mm/compatible/deviceinfo/b;
        //   160: getfield 140	com/tencent/mm/compatible/deviceinfo/b:fDz	I
        //   163: iflt +10 -> 173
        //   166: getstatic 135	com/tencent/mm/compatible/deviceinfo/ae:fJe	Lcom/tencent/mm/compatible/deviceinfo/b;
        //   169: getfield 140	com/tencent/mm/compatible/deviceinfo/b:fDz	I
        //   172: istore_1
        //   173: aload 6
        //   175: iconst_0
        //   176: invokevirtual 144	com/tencent/mm/plugin/voip/video/i:sX	(Z)V
        //   179: aload 6
        //   181: ldc 145
        //   183: ldc2_w 40
        //   186: iconst_1
        //   187: iload_1
        //   188: invokevirtual 149	com/tencent/mm/plugin/voip/video/i:a	(IJZI)V
        //   191: aload 6
        //   193: iconst_1
        //   194: putfield 99	com/tencent/mm/plugin/voip/video/i:aKd	Z
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
        //   231: invokestatic 174	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
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
        //   261: invokestatic 174	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   264: sipush 25290
        //   267: invokestatic 152	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   270: return
        //   271: aload 6
        //   273: ldc 145
        //   275: iconst_2
        //   276: iconst_1
        //   277: invokevirtual 181	com/tencent/mm/plugin/voip/video/i:A	(IIZ)V
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
        //   16	256	6	locali	com.tencent.mm.plugin.voip.video.i
        // Exception table:
        //   from	to	target	type
        //   34	61	204	java/lang/Exception
        //   108	157	237	java/lang/Exception
        //   157	173	237	java/lang/Exception
        //   173	197	237	java/lang/Exception
        //   61	94	287	java/lang/Exception
      }
    };
    this.tHn = new com.tencent.mm.plugin.voip.ui.a()
    {
      public final void a(Intent paramAnonymousIntent, BaseSmallView paramAnonymousBaseSmallView)
      {
        AppMethodBeat.i(179650);
        if (!com.tencent.mm.plugin.ipcall.model.i.cUz().cUr())
        {
          paramAnonymousBaseSmallView.ayC(ai.getContext().getString(2131761459));
          AppMethodBeat.o(179650);
          return;
        }
        int i = c.this.cTX();
        paramAnonymousBaseSmallView.ayB(String.format("%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
        AppMethodBeat.o(179650);
      }
      
      public final boolean cTY()
      {
        AppMethodBeat.i(25291);
        if (com.tencent.mm.plugin.ipcall.model.i.cUz().cUo())
        {
          AppMethodBeat.o(25291);
          return true;
        }
        AppMethodBeat.o(25291);
        return false;
      }
    };
    this.tHo = 0L;
    AppMethodBeat.o(25294);
  }
  
  private void aQW()
  {
    AppMethodBeat.i(25323);
    ac.i("MicroMsg.IPCallManager", "startTimeCount");
    if (this.cLS != null)
    {
      this.cLS.stopTimer();
      AppMethodBeat.o(25323);
      return;
    }
    if (this.cLS == null) {
      this.cLS = new au(Looper.getMainLooper(), new au.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(25293);
          c.this.cTW();
          if ((com.tencent.mm.plugin.ipcall.model.i.cUz().cUr()) && (c.a(c.this) != null)) {
            c.a(c.this).cUd();
          }
          AppMethodBeat.o(25293);
          return true;
        }
      }, true);
    }
    this.cLS.au(1000L, 1000L);
    AppMethodBeat.o(25323);
  }
  
  /* Error */
  private boolean ag(int paramInt1, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: sipush 25297
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: invokestatic 145	com/tencent/mm/plugin/ipcall/model/i:cUv	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   9: getfield 151	com/tencent/mm/plugin/ipcall/model/g:tHV	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   12: astore 15
    //   14: invokestatic 155	com/tencent/mm/plugin/ipcall/model/i:cUz	()Lcom/tencent/mm/plugin/ipcall/model/f;
    //   17: iload_1
    //   18: invokevirtual 161	com/tencent/mm/plugin/ipcall/model/f:Hc	(I)Z
    //   21: ifne +93 -> 114
    //   24: ldc 109
    //   26: ldc 163
    //   28: iconst_1
    //   29: anewarray 4	java/lang/Object
    //   32: dup
    //   33: iconst_0
    //   34: invokestatic 155	com/tencent/mm/plugin/ipcall/model/i:cUz	()Lcom/tencent/mm/plugin/ipcall/model/f;
    //   37: getfield 167	com/tencent/mm/plugin/ipcall/model/f:kTr	I
    //   40: invokestatic 171	com/tencent/mm/plugin/ipcall/model/f:stateToString	(I)Ljava/lang/String;
    //   43: aastore
    //   44: invokestatic 174	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   47: aload 15
    //   49: ifnull +57 -> 106
    //   52: ldc 109
    //   54: ldc 176
    //   56: iconst_5
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: aload 15
    //   64: getfield 181	com/tencent/mm/plugin/ipcall/model/b/c:tII	I
    //   67: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   70: aastore
    //   71: dup
    //   72: iconst_1
    //   73: aload 15
    //   75: getfield 190	com/tencent/mm/plugin/ipcall/model/b/c:roomId	I
    //   78: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   81: aastore
    //   82: dup
    //   83: iconst_2
    //   84: iload_1
    //   85: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   88: aastore
    //   89: dup
    //   90: iconst_3
    //   91: iload_2
    //   92: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   95: aastore
    //   96: dup
    //   97: iconst_4
    //   98: iload_3
    //   99: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   102: aastore
    //   103: invokestatic 174	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: sipush 25297
    //   109: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   112: iconst_0
    //   113: ireturn
    //   114: aload 15
    //   116: ifnull +57 -> 173
    //   119: ldc 109
    //   121: ldc 192
    //   123: iconst_5
    //   124: anewarray 4	java/lang/Object
    //   127: dup
    //   128: iconst_0
    //   129: aload 15
    //   131: getfield 181	com/tencent/mm/plugin/ipcall/model/b/c:tII	I
    //   134: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   137: aastore
    //   138: dup
    //   139: iconst_1
    //   140: aload 15
    //   142: getfield 190	com/tencent/mm/plugin/ipcall/model/b/c:roomId	I
    //   145: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   148: aastore
    //   149: dup
    //   150: iconst_2
    //   151: iload_1
    //   152: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   155: aastore
    //   156: dup
    //   157: iconst_3
    //   158: iload_2
    //   159: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   162: aastore
    //   163: dup
    //   164: iconst_4
    //   165: iload_3
    //   166: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   169: aastore
    //   170: invokestatic 174	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   173: invokestatic 196	com/tencent/mm/plugin/ipcall/model/i:cUF	()Lcom/tencent/mm/plugin/voip/video/i;
    //   176: invokevirtual 201	com/tencent/mm/plugin/voip/video/i:stop	()V
    //   179: invokestatic 196	com/tencent/mm/plugin/ipcall/model/i:cUF	()Lcom/tencent/mm/plugin/voip/video/i;
    //   182: astore 15
    //   184: invokestatic 205	com/tencent/mm/plugin/ipcall/model/i:cUy	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   187: getfield 211	com/tencent/mm/plugin/ipcall/model/c/b:tJo	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   190: invokevirtual 217	com/tencent/mm/plugin/ipcall/model/a/a:isSpeakerphoneOn	()Z
    //   193: istore 8
    //   195: aload 15
    //   197: getfield 221	com/tencent/mm/plugin/voip/video/i:mContext	Landroid/content/Context;
    //   200: invokestatic 227	com/tencent/mm/sdk/platformtools/ai:eUX	()Ljava/lang/String;
    //   203: iconst_0
    //   204: invokevirtual 233	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   207: ldc 235
    //   209: iconst_1
    //   210: invokeinterface 241 3 0
    //   215: pop
    //   216: ldc 243
    //   218: invokestatic 249	com/tencent/mm/plugin/audio/c/a:Sm	(Ljava/lang/String;)Lcom/tencent/mm/plugin/audio/b/a;
    //   221: iload 8
    //   223: invokevirtual 255	com/tencent/mm/plugin/audio/b/a:cm	(Z)V
    //   226: iload 8
    //   228: ifeq +1481 -> 1709
    //   231: iconst_0
    //   232: invokestatic 258	com/tencent/mm/plugin/audio/c/a:setMode	(I)V
    //   235: ldc_w 260
    //   238: ldc_w 262
    //   241: iconst_3
    //   242: anewarray 4	java/lang/Object
    //   245: dup
    //   246: iconst_0
    //   247: getstatic 268	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   250: aastore
    //   251: dup
    //   252: iconst_1
    //   253: iload 8
    //   255: invokestatic 271	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   258: aastore
    //   259: dup
    //   260: iconst_2
    //   261: iconst_2
    //   262: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   265: aastore
    //   266: invokestatic 174	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   269: aload 15
    //   271: invokestatic 277	java/lang/System:currentTimeMillis	()J
    //   274: putfield 280	com/tencent/mm/plugin/voip/video/i:AOU	J
    //   277: new 282	com/tencent/mm/compatible/b/k
    //   280: dup
    //   281: invokespecial 283	com/tencent/mm/compatible/b/k:<init>	()V
    //   284: astore 16
    //   286: aload 16
    //   288: aload 15
    //   290: getfield 221	com/tencent/mm/plugin/voip/video/i:mContext	Landroid/content/Context;
    //   293: new 285	java/lang/StringBuilder
    //   296: dup
    //   297: ldc_w 287
    //   300: invokespecial 290	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   303: aload 15
    //   305: getfield 221	com/tencent/mm/plugin/voip/video/i:mContext	Landroid/content/Context;
    //   308: invokevirtual 293	android/content/Context:getPackageName	()Ljava/lang/String;
    //   311: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: ldc_w 299
    //   317: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   323: invokestatic 308	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   326: invokevirtual 314	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   329: aload 16
    //   331: new 316	com/tencent/mm/plugin/voip/video/i$7
    //   334: dup
    //   335: aload 15
    //   337: invokespecial 319	com/tencent/mm/plugin/voip/video/i$7:<init>	(Lcom/tencent/mm/plugin/voip/video/i;)V
    //   340: invokevirtual 323	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
    //   343: aload 16
    //   345: new 325	com/tencent/mm/plugin/voip/video/i$8
    //   348: dup
    //   349: aload 15
    //   351: invokespecial 326	com/tencent/mm/plugin/voip/video/i$8:<init>	(Lcom/tencent/mm/plugin/voip/video/i;)V
    //   354: invokevirtual 330	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
    //   357: invokestatic 333	com/tencent/mm/plugin/audio/c/a:bCy	()Z
    //   360: ifne +1999 -> 2359
    //   363: iload 8
    //   365: ifne +1351 -> 1716
    //   368: goto +1991 -> 2359
    //   371: aload 16
    //   373: iload 5
    //   375: invokevirtual 336	android/media/MediaPlayer:setAudioStreamType	(I)V
    //   378: aload 16
    //   380: invokevirtual 339	android/media/MediaPlayer:prepare	()V
    //   383: aload 16
    //   385: iconst_0
    //   386: invokevirtual 342	android/media/MediaPlayer:setLooping	(Z)V
    //   389: aload 16
    //   391: invokevirtual 345	android/media/MediaPlayer:start	()V
    //   394: invokestatic 277	java/lang/System:currentTimeMillis	()J
    //   397: aload 15
    //   399: getfield 280	com/tencent/mm/plugin/voip/video/i:AOU	J
    //   402: lsub
    //   403: ldc2_w 346
    //   406: lcmp
    //   407: ifle +10 -> 417
    //   410: aload 15
    //   412: bipush 7
    //   414: putfield 350	com/tencent/mm/plugin/voip/video/i:AOS	I
    //   417: ldc 109
    //   419: ldc_w 352
    //   422: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   425: invokestatic 358	com/tencent/mm/plugin/voip/model/r:ejf	()Lcom/tencent/mm/plugin/voip/model/r;
    //   428: invokevirtual 361	com/tencent/mm/plugin/voip/model/r:ejh	()V
    //   431: invokestatic 358	com/tencent/mm/plugin/voip/model/r:ejf	()Lcom/tencent/mm/plugin/voip/model/r;
    //   434: aconst_null
    //   435: invokevirtual 364	com/tencent/mm/plugin/voip/model/r:a	(Lcom/tencent/mm/plugin/voip/model/r$a;)V
    //   438: invokestatic 368	com/tencent/mm/plugin/ipcall/model/i:cUx	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   441: astore 15
    //   443: invokestatic 205	com/tencent/mm/plugin/ipcall/model/i:cUy	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   446: getfield 211	com/tencent/mm/plugin/ipcall/model/c/b:tJo	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   449: getfield 372	com/tencent/mm/plugin/ipcall/model/a/a:tIA	Lcom/tencent/mm/plugin/ipcall/model/c/c;
    //   452: astore 16
    //   454: aload 16
    //   456: ifnull +1312 -> 1768
    //   459: aload 16
    //   461: getfield 378	com/tencent/mm/plugin/ipcall/model/c/c:tJu	Lcom/tencent/mm/audio/b/c;
    //   464: ifnull +1298 -> 1762
    //   467: aload 16
    //   469: getfield 378	com/tencent/mm/plugin/ipcall/model/c/c:tJu	Lcom/tencent/mm/audio/b/c;
    //   472: getfield 383	com/tencent/mm/audio/b/c:cVv	I
    //   475: istore 5
    //   477: aload 15
    //   479: getfield 388	com/tencent/mm/plugin/ipcall/model/d/b:tKj	I
    //   482: ifne +10 -> 492
    //   485: aload 15
    //   487: iload 5
    //   489: putfield 388	com/tencent/mm/plugin/ipcall/model/d/b:tKj	I
    //   492: invokestatic 368	com/tencent/mm/plugin/ipcall/model/i:cUx	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   495: astore 15
    //   497: invokestatic 205	com/tencent/mm/plugin/ipcall/model/i:cUy	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   500: getfield 211	com/tencent/mm/plugin/ipcall/model/c/b:tJo	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   503: getfield 392	com/tencent/mm/plugin/ipcall/model/a/a:tIz	Lcom/tencent/mm/plugin/ipcall/model/c/a;
    //   506: astore 16
    //   508: aload 16
    //   510: ifnull +1270 -> 1780
    //   513: aload 16
    //   515: getfield 398	com/tencent/mm/plugin/ipcall/model/c/a:osB	Lcom/tencent/mm/plugin/voip/model/c;
    //   518: ifnull +1256 -> 1774
    //   521: ldc_w 400
    //   524: new 285	java/lang/StringBuilder
    //   527: dup
    //   528: ldc_w 402
    //   531: invokespecial 290	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   534: aload 16
    //   536: getfield 398	com/tencent/mm/plugin/ipcall/model/c/a:osB	Lcom/tencent/mm/plugin/voip/model/c;
    //   539: invokevirtual 408	com/tencent/mm/plugin/voip/model/c:ehj	()I
    //   542: invokevirtual 411	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   545: invokevirtual 302	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: invokestatic 414	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   551: aload 16
    //   553: getfield 398	com/tencent/mm/plugin/ipcall/model/c/a:osB	Lcom/tencent/mm/plugin/voip/model/c;
    //   556: invokevirtual 408	com/tencent/mm/plugin/voip/model/c:ehj	()I
    //   559: istore 5
    //   561: aload 15
    //   563: getfield 417	com/tencent/mm/plugin/ipcall/model/d/b:tKk	I
    //   566: ifne +10 -> 576
    //   569: aload 15
    //   571: iload 5
    //   573: putfield 417	com/tencent/mm/plugin/ipcall/model/d/b:tKk	I
    //   576: invokestatic 205	com/tencent/mm/plugin/ipcall/model/i:cUy	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   579: astore 15
    //   581: invokestatic 421	com/tencent/mm/plugin/ipcall/model/i:cUw	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   584: astore 16
    //   586: aload 15
    //   588: getfield 211	com/tencent/mm/plugin/ipcall/model/c/b:tJo	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   591: astore 17
    //   593: aload 17
    //   595: getfield 392	com/tencent/mm/plugin/ipcall/model/a/a:tIz	Lcom/tencent/mm/plugin/ipcall/model/c/a;
    //   598: astore 18
    //   600: aload 18
    //   602: ifnull +1190 -> 1792
    //   605: aload 18
    //   607: getfield 398	com/tencent/mm/plugin/ipcall/model/c/a:osB	Lcom/tencent/mm/plugin/voip/model/c;
    //   610: ifnull +1176 -> 1786
    //   613: aload 18
    //   615: getfield 424	com/tencent/mm/plugin/ipcall/model/c/a:isStart	Z
    //   618: ifeq +1168 -> 1786
    //   621: aload 18
    //   623: getfield 398	com/tencent/mm/plugin/ipcall/model/c/a:osB	Lcom/tencent/mm/plugin/voip/model/c;
    //   626: invokevirtual 427	com/tencent/mm/plugin/voip/model/c:aKj	()I
    //   629: istore 5
    //   631: iload 5
    //   633: iconst_m1
    //   634: if_icmpne +1164 -> 1798
    //   637: iconst_0
    //   638: istore 5
    //   640: aload 16
    //   642: getfield 433	com/tencent/mm/plugin/ipcall/model/d/a:tJF	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   645: iload 5
    //   647: putfield 438	com/tencent/mm/plugin/voip/model/v2protocal:AGI	I
    //   650: aload 15
    //   652: aconst_null
    //   653: putfield 442	com/tencent/mm/plugin/ipcall/model/c/b:iMV	Lcom/tencent/mm/ui/MMActivity;
    //   656: aload 15
    //   658: getfield 211	com/tencent/mm/plugin/ipcall/model/c/b:tJo	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   661: astore 17
    //   663: aload 17
    //   665: getfield 392	com/tencent/mm/plugin/ipcall/model/a/a:tIz	Lcom/tencent/mm/plugin/ipcall/model/c/a;
    //   668: astore 18
    //   670: aload 18
    //   672: ifnull +65 -> 737
    //   675: aload 18
    //   677: getfield 424	com/tencent/mm/plugin/ipcall/model/c/a:isStart	Z
    //   680: ifeq +57 -> 737
    //   683: ldc_w 400
    //   686: ldc_w 444
    //   689: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   692: aload 18
    //   694: getfield 447	com/tencent/mm/plugin/ipcall/model/c/a:tJl	Ljava/lang/Object;
    //   697: astore 16
    //   699: aload 16
    //   701: monitorenter
    //   702: new 449	com/tencent/mm/plugin/ipcall/model/c/a$a
    //   705: dup
    //   706: aload 18
    //   708: aload 18
    //   710: getfield 398	com/tencent/mm/plugin/ipcall/model/c/a:osB	Lcom/tencent/mm/plugin/voip/model/c;
    //   713: invokespecial 452	com/tencent/mm/plugin/ipcall/model/c/a$a:<init>	(Lcom/tencent/mm/plugin/ipcall/model/c/a;Lcom/tencent/mm/plugin/voip/model/c;)V
    //   716: ldc_w 454
    //   719: invokestatic 460	com/tencent/mm/sdk/g/b:c	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   722: aload 18
    //   724: iconst_0
    //   725: putfield 424	com/tencent/mm/plugin/ipcall/model/c/a:isStart	Z
    //   728: aload 18
    //   730: aconst_null
    //   731: putfield 398	com/tencent/mm/plugin/ipcall/model/c/a:osB	Lcom/tencent/mm/plugin/voip/model/c;
    //   734: aload 16
    //   736: monitorexit
    //   737: aload 17
    //   739: ldc_w 462
    //   742: invokevirtual 465	com/tencent/mm/plugin/ipcall/model/a/a:Sl	(Ljava/lang/String;)V
    //   745: aload 17
    //   747: aconst_null
    //   748: putfield 469	com/tencent/mm/plugin/ipcall/model/a/a:tIy	Lcom/tencent/mm/plugin/ipcall/model/a/a$b;
    //   751: aload 17
    //   753: getfield 473	com/tencent/mm/plugin/ipcall/model/a/a:ied	Lcom/tencent/mm/compatible/util/b;
    //   756: invokevirtual 478	com/tencent/mm/compatible/util/b:YC	()Z
    //   759: pop
    //   760: aload 15
    //   762: aconst_null
    //   763: putfield 482	com/tencent/mm/plugin/ipcall/model/c/b:tJs	Lcom/tencent/mm/plugin/ipcall/ui/j;
    //   766: invokestatic 205	com/tencent/mm/plugin/ipcall/model/i:cUy	()Lcom/tencent/mm/plugin/ipcall/model/c/b;
    //   769: astore 16
    //   771: aload 16
    //   773: getfield 211	com/tencent/mm/plugin/ipcall/model/c/b:tJo	Lcom/tencent/mm/plugin/ipcall/model/a/a;
    //   776: getfield 372	com/tencent/mm/plugin/ipcall/model/a/a:tIA	Lcom/tencent/mm/plugin/ipcall/model/c/c;
    //   779: astore 17
    //   781: aload 17
    //   783: ifnull +79 -> 862
    //   786: aload 17
    //   788: getfield 483	com/tencent/mm/plugin/ipcall/model/c/c:isStart	Z
    //   791: ifeq +71 -> 862
    //   794: ldc_w 485
    //   797: ldc_w 487
    //   800: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   803: aload 17
    //   805: getfield 490	com/tencent/mm/plugin/ipcall/model/c/c:tJv	Ljava/lang/Object;
    //   808: astore 15
    //   810: aload 15
    //   812: monitorenter
    //   813: aload 17
    //   815: getfield 378	com/tencent/mm/plugin/ipcall/model/c/c:tJu	Lcom/tencent/mm/audio/b/c;
    //   818: ifnull +41 -> 859
    //   821: new 492	com/tencent/mm/plugin/ipcall/model/c/c$a
    //   824: dup
    //   825: aload 17
    //   827: aload 17
    //   829: getfield 378	com/tencent/mm/plugin/ipcall/model/c/c:tJu	Lcom/tencent/mm/audio/b/c;
    //   832: invokespecial 495	com/tencent/mm/plugin/ipcall/model/c/c$a:<init>	(Lcom/tencent/mm/plugin/ipcall/model/c/c;Lcom/tencent/mm/audio/b/c;)V
    //   835: ldc_w 497
    //   838: invokestatic 460	com/tencent/mm/sdk/g/b:c	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   841: aload 17
    //   843: aconst_null
    //   844: putfield 378	com/tencent/mm/plugin/ipcall/model/c/c:tJu	Lcom/tencent/mm/audio/b/c;
    //   847: aload 17
    //   849: iconst_0
    //   850: putfield 483	com/tencent/mm/plugin/ipcall/model/c/c:isStart	Z
    //   853: aload 17
    //   855: iconst_0
    //   856: putfield 500	com/tencent/mm/plugin/ipcall/model/c/c:ftN	Z
    //   859: aload 15
    //   861: monitorexit
    //   862: aload 16
    //   864: aconst_null
    //   865: putfield 442	com/tencent/mm/plugin/ipcall/model/c/b:iMV	Lcom/tencent/mm/ui/MMActivity;
    //   868: invokestatic 421	com/tencent/mm/plugin/ipcall/model/i:cUw	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   871: astore 15
    //   873: ldc_w 502
    //   876: ldc_w 504
    //   879: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   882: aload 15
    //   884: getfield 433	com/tencent/mm/plugin/ipcall/model/d/a:tJF	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   887: iconst_1
    //   888: invokevirtual 508	com/tencent/mm/plugin/voip/model/v2protocal:sH	(Z)Ljava/lang/String;
    //   891: pop
    //   892: invokestatic 368	com/tencent/mm/plugin/ipcall/model/i:cUx	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   895: astore 16
    //   897: aload 16
    //   899: getfield 512	com/tencent/mm/plugin/ipcall/model/d/b:tKe	Ljava/lang/String;
    //   902: invokestatic 518	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   905: ifeq +282 -> 1187
    //   908: aload 16
    //   910: getfield 521	com/tencent/mm/plugin/ipcall/model/d/b:tKd	Ljava/lang/String;
    //   913: invokestatic 518	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   916: ifeq +271 -> 1187
    //   919: invokestatic 145	com/tencent/mm/plugin/ipcall/model/i:cUv	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   922: getfield 151	com/tencent/mm/plugin/ipcall/model/g:tHV	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   925: astore 18
    //   927: invokestatic 421	com/tencent/mm/plugin/ipcall/model/i:cUw	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   930: getfield 433	com/tencent/mm/plugin/ipcall/model/d/a:tJF	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   933: astore 17
    //   935: aload 16
    //   937: getfield 524	com/tencent/mm/plugin/ipcall/model/d/b:tJT	I
    //   940: iconst_1
    //   941: if_icmpne +916 -> 1857
    //   944: iconst_1
    //   945: istore 5
    //   947: aload 18
    //   949: getfield 527	com/tencent/mm/plugin/ipcall/model/b/c:tJb	I
    //   952: istore 6
    //   954: aload 17
    //   956: getfield 531	com/tencent/mm/plugin/voip/model/v2protocal:AIb	[B
    //   959: astore 18
    //   961: aload 17
    //   963: getfield 531	com/tencent/mm/plugin/voip/model/v2protocal:AIb	[B
    //   966: arraylength
    //   967: istore 7
    //   969: iload 5
    //   971: ifeq +892 -> 1863
    //   974: iconst_1
    //   975: istore 5
    //   977: aload 17
    //   979: aload 18
    //   981: iload 7
    //   983: iload 5
    //   985: iload 6
    //   987: invokevirtual 535	com/tencent/mm/plugin/voip/model/v2protocal:getPstnChannelInfo	([BIII)I
    //   990: pop
    //   991: ldc_w 537
    //   994: ldc_w 539
    //   997: iconst_1
    //   998: anewarray 4	java/lang/Object
    //   1001: dup
    //   1002: iconst_0
    //   1003: aload 17
    //   1005: getfield 542	com/tencent/mm/plugin/voip/model/v2protocal:field_pstnChannelInfoLength	I
    //   1008: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1011: aastore
    //   1012: invokestatic 544	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1015: aload 16
    //   1017: new 546	java/lang/String
    //   1020: dup
    //   1021: aload 17
    //   1023: getfield 531	com/tencent/mm/plugin/voip/model/v2protocal:AIb	[B
    //   1026: iconst_0
    //   1027: aload 17
    //   1029: getfield 542	com/tencent/mm/plugin/voip/model/v2protocal:field_pstnChannelInfoLength	I
    //   1032: invokespecial 549	java/lang/String:<init>	([BII)V
    //   1035: putfield 512	com/tencent/mm/plugin/ipcall/model/d/b:tKe	Ljava/lang/String;
    //   1038: invokestatic 421	com/tencent/mm/plugin/ipcall/model/i:cUw	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   1041: getfield 433	com/tencent/mm/plugin/ipcall/model/d/a:tJF	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1044: astore 17
    //   1046: aload 17
    //   1048: aload 17
    //   1050: getfield 552	com/tencent/mm/plugin/voip/model/v2protocal:AIc	[B
    //   1053: aload 17
    //   1055: getfield 552	com/tencent/mm/plugin/voip/model/v2protocal:AIc	[B
    //   1058: arraylength
    //   1059: invokevirtual 556	com/tencent/mm/plugin/voip/model/v2protocal:getPstnEngineInfo	([BI)I
    //   1062: pop
    //   1063: ldc_w 537
    //   1066: ldc_w 558
    //   1069: iconst_1
    //   1070: anewarray 4	java/lang/Object
    //   1073: dup
    //   1074: iconst_0
    //   1075: aload 17
    //   1077: getfield 561	com/tencent/mm/plugin/voip/model/v2protocal:field_pstnEngineInfoLength	I
    //   1080: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1083: aastore
    //   1084: invokestatic 544	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1087: aload 16
    //   1089: new 546	java/lang/String
    //   1092: dup
    //   1093: aload 17
    //   1095: getfield 552	com/tencent/mm/plugin/voip/model/v2protocal:AIc	[B
    //   1098: iconst_0
    //   1099: aload 17
    //   1101: getfield 561	com/tencent/mm/plugin/voip/model/v2protocal:field_pstnEngineInfoLength	I
    //   1104: invokespecial 549	java/lang/String:<init>	([BII)V
    //   1107: putfield 521	com/tencent/mm/plugin/ipcall/model/d/b:tKd	Ljava/lang/String;
    //   1110: aload 16
    //   1112: invokestatic 421	com/tencent/mm/plugin/ipcall/model/i:cUw	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   1115: getfield 433	com/tencent/mm/plugin/ipcall/model/d/a:tJF	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1118: invokevirtual 564	com/tencent/mm/plugin/voip/model/v2protocal:ekL	()Ljava/lang/String;
    //   1121: putfield 567	com/tencent/mm/plugin/ipcall/model/d/b:tKf	Ljava/lang/String;
    //   1124: ldc_w 569
    //   1127: ldc_w 571
    //   1130: iconst_1
    //   1131: anewarray 4	java/lang/Object
    //   1134: dup
    //   1135: iconst_0
    //   1136: aload 16
    //   1138: getfield 512	com/tencent/mm/plugin/ipcall/model/d/b:tKe	Ljava/lang/String;
    //   1141: aastore
    //   1142: invokestatic 544	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1145: ldc_w 569
    //   1148: ldc_w 573
    //   1151: iconst_1
    //   1152: anewarray 4	java/lang/Object
    //   1155: dup
    //   1156: iconst_0
    //   1157: aload 16
    //   1159: getfield 521	com/tencent/mm/plugin/ipcall/model/d/b:tKd	Ljava/lang/String;
    //   1162: aastore
    //   1163: invokestatic 544	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1166: ldc_w 569
    //   1169: ldc_w 575
    //   1172: iconst_1
    //   1173: anewarray 4	java/lang/Object
    //   1176: dup
    //   1177: iconst_0
    //   1178: aload 16
    //   1180: getfield 567	com/tencent/mm/plugin/ipcall/model/d/b:tKf	Ljava/lang/String;
    //   1183: aastore
    //   1184: invokestatic 544	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1187: aload 15
    //   1189: getfield 433	com/tencent/mm/plugin/ipcall/model/d/a:tJF	Lcom/tencent/mm/plugin/voip/model/v2protocal;
    //   1192: invokevirtual 578	com/tencent/mm/plugin/voip/model/v2protocal:reset	()V
    //   1195: aload 15
    //   1197: invokevirtual 581	com/tencent/mm/plugin/ipcall/model/d/a:resetStatus	()V
    //   1200: getstatic 69	com/tencent/mm/plugin/ipcall/c:gox	Lcom/tencent/mm/sdk/platformtools/ao;
    //   1203: aload_0
    //   1204: getfield 97	com/tencent/mm/plugin/ipcall/c:tHl	Ljava/lang/Runnable;
    //   1207: invokevirtual 585	com/tencent/mm/sdk/platformtools/ao:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1210: getstatic 69	com/tencent/mm/plugin/ipcall/c:gox	Lcom/tencent/mm/sdk/platformtools/ao;
    //   1213: aload_0
    //   1214: getfield 94	com/tencent/mm/plugin/ipcall/c:tHk	Ljava/lang/Runnable;
    //   1217: invokevirtual 585	com/tencent/mm/sdk/platformtools/ao:removeCallbacks	(Ljava/lang/Runnable;)V
    //   1220: aload_0
    //   1221: getfield 118	com/tencent/mm/plugin/ipcall/c:cLS	Lcom/tencent/mm/sdk/platformtools/au;
    //   1224: ifnull +15 -> 1239
    //   1227: aload_0
    //   1228: getfield 118	com/tencent/mm/plugin/ipcall/c:cLS	Lcom/tencent/mm/sdk/platformtools/au;
    //   1231: invokevirtual 123	com/tencent/mm/sdk/platformtools/au:stopTimer	()V
    //   1234: aload_0
    //   1235: aconst_null
    //   1236: putfield 118	com/tencent/mm/plugin/ipcall/c:cLS	Lcom/tencent/mm/sdk/platformtools/au;
    //   1239: invokestatic 368	com/tencent/mm/plugin/ipcall/model/i:cUx	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1242: iload_3
    //   1243: putfield 588	com/tencent/mm/plugin/ipcall/model/d/b:tJV	I
    //   1246: invokestatic 368	com/tencent/mm/plugin/ipcall/model/i:cUx	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1249: astore 15
    //   1251: ldc_w 569
    //   1254: ldc_w 590
    //   1257: invokestatic 414	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1260: aload 15
    //   1262: getfield 593	com/tencent/mm/plugin/ipcall/model/d/b:tKc	J
    //   1265: lconst_0
    //   1266: lcmp
    //   1267: ifne +65 -> 1332
    //   1270: aload 15
    //   1272: getfield 596	com/tencent/mm/plugin/ipcall/model/d/b:tKb	J
    //   1275: lconst_0
    //   1276: lcmp
    //   1277: ifeq +55 -> 1332
    //   1280: aload 15
    //   1282: invokestatic 277	java/lang/System:currentTimeMillis	()J
    //   1285: putfield 593	com/tencent/mm/plugin/ipcall/model/d/b:tKc	J
    //   1288: aload 15
    //   1290: aload 15
    //   1292: getfield 593	com/tencent/mm/plugin/ipcall/model/d/b:tKc	J
    //   1295: aload 15
    //   1297: getfield 596	com/tencent/mm/plugin/ipcall/model/d/b:tKb	J
    //   1300: lsub
    //   1301: ldc2_w 128
    //   1304: ldiv
    //   1305: putfield 599	com/tencent/mm/plugin/ipcall/model/d/b:tJU	J
    //   1308: ldc_w 569
    //   1311: ldc_w 601
    //   1314: iconst_1
    //   1315: anewarray 4	java/lang/Object
    //   1318: dup
    //   1319: iconst_0
    //   1320: aload 15
    //   1322: getfield 599	com/tencent/mm/plugin/ipcall/model/d/b:tJU	J
    //   1325: invokestatic 606	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1328: aastore
    //   1329: invokestatic 544	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1332: iload_1
    //   1333: bipush 8
    //   1335: if_icmpne +534 -> 1869
    //   1338: invokestatic 145	com/tencent/mm/plugin/ipcall/model/i:cUv	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1341: invokevirtual 609	com/tencent/mm/plugin/ipcall/model/g:cUs	()V
    //   1344: invokestatic 368	com/tencent/mm/plugin/ipcall/model/i:cUx	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1347: invokevirtual 612	com/tencent/mm/plugin/ipcall/model/d/b:cUS	()V
    //   1350: aload_0
    //   1351: getfield 614	com/tencent/mm/plugin/ipcall/c:tHf	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1354: astore 15
    //   1356: aload 15
    //   1358: ifnull +53 -> 1411
    //   1361: ldc_w 616
    //   1364: ldc_w 618
    //   1367: iconst_1
    //   1368: anewarray 4	java/lang/Object
    //   1371: dup
    //   1372: iconst_0
    //   1373: aload 15
    //   1375: getfield 623	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   1378: invokestatic 606	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1381: aastore
    //   1382: invokestatic 544	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1385: aload 15
    //   1387: getfield 623	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   1390: ldc2_w 624
    //   1393: lcmp
    //   1394: ifeq +17 -> 1411
    //   1397: aload 15
    //   1399: iconst_2
    //   1400: putfield 628	com/tencent/mm/plugin/ipcall/model/h/k:field_status	I
    //   1403: invokestatic 632	com/tencent/mm/plugin/ipcall/model/i:cUC	()Lcom/tencent/mm/plugin/ipcall/model/h/l;
    //   1406: aload 15
    //   1408: invokevirtual 637	com/tencent/mm/plugin/ipcall/model/h/l:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)V
    //   1411: invokestatic 145	com/tencent/mm/plugin/ipcall/model/i:cUv	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1414: getfield 640	com/tencent/mm/plugin/ipcall/model/g:dsb	Z
    //   1417: ifeq +186 -> 1603
    //   1420: aload_0
    //   1421: getfield 642	com/tencent/mm/plugin/ipcall/c:tHm	Z
    //   1424: ifne +892 -> 2316
    //   1427: invokestatic 145	com/tencent/mm/plugin/ipcall/model/i:cUv	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1430: getfield 151	com/tencent/mm/plugin/ipcall/model/g:tHV	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   1433: getfield 190	com/tencent/mm/plugin/ipcall/model/b/c:roomId	I
    //   1436: ifeq +880 -> 2316
    //   1439: invokestatic 145	com/tencent/mm/plugin/ipcall/model/i:cUv	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1442: getfield 151	com/tencent/mm/plugin/ipcall/model/g:tHV	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   1445: getfield 645	com/tencent/mm/plugin/ipcall/model/b/c:tIH	J
    //   1448: lconst_0
    //   1449: lcmp
    //   1450: ifeq +866 -> 2316
    //   1453: invokestatic 649	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   1456: astore 15
    //   1458: invokestatic 145	com/tencent/mm/plugin/ipcall/model/i:cUv	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1461: getfield 151	com/tencent/mm/plugin/ipcall/model/g:tHV	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   1464: getfield 190	com/tencent/mm/plugin/ipcall/model/b/c:roomId	I
    //   1467: istore_2
    //   1468: invokestatic 145	com/tencent/mm/plugin/ipcall/model/i:cUv	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1471: getfield 151	com/tencent/mm/plugin/ipcall/model/g:tHV	Lcom/tencent/mm/plugin/ipcall/model/b/c;
    //   1474: getfield 645	com/tencent/mm/plugin/ipcall/model/b/c:tIH	J
    //   1477: lstore 9
    //   1479: ldc_w 651
    //   1482: ldc_w 653
    //   1485: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1488: invokestatic 658	com/tencent/mm/plugin/ipcall/d:cTZ	()Z
    //   1491: ifeq +112 -> 1603
    //   1494: invokestatic 664	com/tencent/mm/m/g:ZY	()Lcom/tencent/mm/m/e;
    //   1497: ldc_w 666
    //   1500: iconst_0
    //   1501: invokevirtual 672	com/tencent/mm/m/e:getInt	(Ljava/lang/String;I)I
    //   1504: istore_3
    //   1505: invokestatic 678	com/tencent/mm/model/az:ayM	()Lcom/tencent/mm/model/c;
    //   1508: pop
    //   1509: invokestatic 684	com/tencent/mm/model/c:agA	()Lcom/tencent/mm/storage/ae;
    //   1512: getstatic 690	com/tencent/mm/storage/ah$a:GGP	Lcom/tencent/mm/storage/ah$a;
    //   1515: iconst_0
    //   1516: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1519: invokevirtual 696	com/tencent/mm/storage/ae:get	(Lcom/tencent/mm/storage/ah$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   1522: checkcast 183	java/lang/Integer
    //   1525: invokevirtual 699	java/lang/Integer:intValue	()I
    //   1528: istore_1
    //   1529: invokestatic 678	com/tencent/mm/model/az:ayM	()Lcom/tencent/mm/model/c;
    //   1532: pop
    //   1533: invokestatic 684	com/tencent/mm/model/c:agA	()Lcom/tencent/mm/storage/ae;
    //   1536: getstatic 702	com/tencent/mm/storage/ah$a:GGO	Lcom/tencent/mm/storage/ah$a;
    //   1539: lconst_0
    //   1540: invokestatic 606	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1543: invokevirtual 696	com/tencent/mm/storage/ae:get	(Lcom/tencent/mm/storage/ah$a;Ljava/lang/Object;)Ljava/lang/Object;
    //   1546: checkcast 603	java/lang/Long
    //   1549: invokevirtual 705	java/lang/Long:longValue	()J
    //   1552: lstore 11
    //   1554: invokestatic 708	com/tencent/mm/sdk/platformtools/bs:aNx	()J
    //   1557: lstore 13
    //   1559: lload 13
    //   1561: lload 11
    //   1563: lsub
    //   1564: ldc2_w 709
    //   1567: lcmp
    //   1568: ifle +788 -> 2356
    //   1571: iconst_0
    //   1572: istore_1
    //   1573: ldc_w 651
    //   1576: ldc_w 712
    //   1579: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1582: iload_1
    //   1583: iload_3
    //   1584: if_icmplt +625 -> 2209
    //   1587: ldc_w 651
    //   1590: ldc_w 714
    //   1593: iload_3
    //   1594: invokestatic 716	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1597: invokevirtual 720	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   1600: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   1603: invokestatic 145	com/tencent/mm/plugin/ipcall/model/i:cUv	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1606: aconst_null
    //   1607: putfield 724	com/tencent/mm/plugin/ipcall/model/g:tHM	Lcom/tencent/mm/plugin/ipcall/model/g$a;
    //   1610: invokestatic 421	com/tencent/mm/plugin/ipcall/model/i:cUw	()Lcom/tencent/mm/plugin/ipcall/model/d/a;
    //   1613: aconst_null
    //   1614: putfield 728	com/tencent/mm/plugin/ipcall/model/d/a:tJK	Lcom/tencent/mm/plugin/ipcall/model/d/a$a;
    //   1617: invokestatic 155	com/tencent/mm/plugin/ipcall/model/i:cUz	()Lcom/tencent/mm/plugin/ipcall/model/f;
    //   1620: iconst_m1
    //   1621: putfield 167	com/tencent/mm/plugin/ipcall/model/f:kTr	I
    //   1624: invokestatic 732	com/tencent/mm/plugin/ipcall/model/i:cUt	()Lcom/tencent/mm/plugin/ipcall/model/i;
    //   1627: pop
    //   1628: invokestatic 735	com/tencent/mm/plugin/ipcall/model/a/a:unInit	()V
    //   1631: aload_0
    //   1632: iconst_1
    //   1633: invokevirtual 738	com/tencent/mm/plugin/ipcall/c:nf	(Z)V
    //   1636: aload_0
    //   1637: invokespecial 741	com/tencent/mm/plugin/ipcall/c:removeListener	()V
    //   1640: ldc 109
    //   1642: ldc_w 743
    //   1645: iconst_0
    //   1646: anewarray 4	java/lang/Object
    //   1649: invokestatic 746	com/tencent/mm/sdk/platformtools/ac:m	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1652: bipush 26
    //   1654: invokestatic 751	com/tencent/mm/compatible/util/d:kZ	(I)Z
    //   1657: ifeq +44 -> 1701
    //   1660: new 753	android/content/Intent
    //   1663: dup
    //   1664: invokespecial 754	android/content/Intent:<init>	()V
    //   1667: astore 15
    //   1669: aload 15
    //   1671: invokestatic 649	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   1674: ldc_w 756
    //   1677: invokevirtual 760	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   1680: pop
    //   1681: invokestatic 649	com/tencent/mm/sdk/platformtools/ai:getContext	()Landroid/content/Context;
    //   1684: aload 15
    //   1686: invokevirtual 764	android/content/Context:stopService	(Landroid/content/Intent;)Z
    //   1689: pop
    //   1690: iconst_1
    //   1691: istore_1
    //   1692: iload_1
    //   1693: ifeq +8 -> 1701
    //   1696: aload_0
    //   1697: iconst_0
    //   1698: putfield 79	com/tencent/mm/plugin/ipcall/c:tHi	Z
    //   1701: sipush 25297
    //   1704: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1707: iconst_1
    //   1708: ireturn
    //   1709: iconst_2
    //   1710: invokestatic 258	com/tencent/mm/plugin/audio/c/a:setMode	(I)V
    //   1713: goto -1478 -> 235
    //   1716: iconst_2
    //   1717: istore 5
    //   1719: goto -1348 -> 371
    //   1722: astore 17
    //   1724: ldc_w 260
    //   1727: ldc_w 766
    //   1730: iconst_1
    //   1731: anewarray 4	java/lang/Object
    //   1734: dup
    //   1735: iconst_0
    //   1736: aload 17
    //   1738: aastore
    //   1739: invokestatic 769	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1742: aload 15
    //   1744: bipush 6
    //   1746: putfield 350	com/tencent/mm/plugin/voip/video/i:AOS	I
    //   1749: aload 16
    //   1751: invokevirtual 770	android/media/MediaPlayer:stop	()V
    //   1754: aload 16
    //   1756: invokevirtual 773	android/media/MediaPlayer:release	()V
    //   1759: goto -1342 -> 417
    //   1762: iconst_0
    //   1763: istore 5
    //   1765: goto -1288 -> 477
    //   1768: iconst_0
    //   1769: istore 5
    //   1771: goto -1294 -> 477
    //   1774: iconst_0
    //   1775: istore 5
    //   1777: goto -1216 -> 561
    //   1780: iconst_0
    //   1781: istore 5
    //   1783: goto -1222 -> 561
    //   1786: iconst_m1
    //   1787: istore 5
    //   1789: goto -1158 -> 631
    //   1792: iconst_0
    //   1793: istore 5
    //   1795: goto -1164 -> 631
    //   1798: aload 17
    //   1800: iload 5
    //   1802: invokevirtual 777	com/tencent/mm/plugin/ipcall/model/a/a:getStreamMaxVolume	(I)I
    //   1805: i2f
    //   1806: fstore 4
    //   1808: aload 17
    //   1810: iload 5
    //   1812: invokevirtual 780	com/tencent/mm/plugin/ipcall/model/a/a:getStreamVolume	(I)I
    //   1815: i2f
    //   1816: fload 4
    //   1818: fdiv
    //   1819: ldc_w 781
    //   1822: fmul
    //   1823: f2i
    //   1824: istore 5
    //   1826: goto -1186 -> 640
    //   1829: astore 15
    //   1831: aload 16
    //   1833: monitorexit
    //   1834: sipush 25297
    //   1837: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1840: aload 15
    //   1842: athrow
    //   1843: astore 16
    //   1845: aload 15
    //   1847: monitorexit
    //   1848: sipush 25297
    //   1851: invokestatic 72	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   1854: aload 16
    //   1856: athrow
    //   1857: iconst_0
    //   1858: istore 5
    //   1860: goto -913 -> 947
    //   1863: iconst_0
    //   1864: istore 5
    //   1866: goto -889 -> 977
    //   1869: iload_1
    //   1870: bipush 12
    //   1872: if_icmpne +97 -> 1969
    //   1875: invokestatic 145	com/tencent/mm/plugin/ipcall/model/i:cUv	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1878: invokevirtual 609	com/tencent/mm/plugin/ipcall/model/g:cUs	()V
    //   1881: invokestatic 368	com/tencent/mm/plugin/ipcall/model/i:cUx	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1884: invokevirtual 612	com/tencent/mm/plugin/ipcall/model/d/b:cUS	()V
    //   1887: iload_2
    //   1888: bipush 11
    //   1890: if_icmpne +14 -> 1904
    //   1893: aload_0
    //   1894: getfield 614	com/tencent/mm/plugin/ipcall/c:tHf	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1897: invokestatic 787	com/tencent/mm/plugin/ipcall/model/h/m:b	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1900: pop
    //   1901: goto -490 -> 1411
    //   1904: aload_0
    //   1905: getfield 614	com/tencent/mm/plugin/ipcall/c:tHf	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1908: astore 15
    //   1910: aload 15
    //   1912: ifnull -501 -> 1411
    //   1915: ldc_w 616
    //   1918: ldc_w 789
    //   1921: iconst_1
    //   1922: anewarray 4	java/lang/Object
    //   1925: dup
    //   1926: iconst_0
    //   1927: aload 15
    //   1929: getfield 623	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   1932: invokestatic 606	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1935: aastore
    //   1936: invokestatic 544	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   1939: aload 15
    //   1941: getfield 623	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   1944: ldc2_w 624
    //   1947: lcmp
    //   1948: ifeq -537 -> 1411
    //   1951: aload 15
    //   1953: bipush 6
    //   1955: putfield 628	com/tencent/mm/plugin/ipcall/model/h/k:field_status	I
    //   1958: invokestatic 632	com/tencent/mm/plugin/ipcall/model/i:cUC	()Lcom/tencent/mm/plugin/ipcall/model/h/l;
    //   1961: aload 15
    //   1963: invokevirtual 637	com/tencent/mm/plugin/ipcall/model/h/l:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)V
    //   1966: goto -555 -> 1411
    //   1969: iload_1
    //   1970: bipush 9
    //   1972: if_icmpne +33 -> 2005
    //   1975: invokestatic 145	com/tencent/mm/plugin/ipcall/model/i:cUv	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   1978: iconst_1
    //   1979: invokevirtual 792	com/tencent/mm/plugin/ipcall/model/g:He	(I)V
    //   1982: invokestatic 368	com/tencent/mm/plugin/ipcall/model/i:cUx	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1985: invokevirtual 795	com/tencent/mm/plugin/ipcall/model/d/b:cUR	()V
    //   1988: aload_0
    //   1989: getfield 614	com/tencent/mm/plugin/ipcall/c:tHf	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   1992: invokestatic 368	com/tencent/mm/plugin/ipcall/model/i:cUx	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   1995: getfield 599	com/tencent/mm/plugin/ipcall/model/d/b:tJU	J
    //   1998: invokestatic 798	com/tencent/mm/plugin/ipcall/model/h/m:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;J)Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2001: pop
    //   2002: goto -591 -> 1411
    //   2005: iload_1
    //   2006: bipush 10
    //   2008: if_icmpne +117 -> 2125
    //   2011: invokestatic 145	com/tencent/mm/plugin/ipcall/model/i:cUv	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   2014: iconst_1
    //   2015: invokevirtual 792	com/tencent/mm/plugin/ipcall/model/g:He	(I)V
    //   2018: invokestatic 368	com/tencent/mm/plugin/ipcall/model/i:cUx	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   2021: astore 15
    //   2023: ldc_w 569
    //   2026: ldc_w 800
    //   2029: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2032: aload 15
    //   2034: iconst_1
    //   2035: putfield 803	com/tencent/mm/plugin/ipcall/model/d/b:tJO	I
    //   2038: aload_0
    //   2039: getfield 614	com/tencent/mm/plugin/ipcall/c:tHf	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2042: astore 15
    //   2044: invokestatic 368	com/tencent/mm/plugin/ipcall/model/i:cUx	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   2047: getfield 599	com/tencent/mm/plugin/ipcall/model/d/b:tJU	J
    //   2050: lstore 9
    //   2052: aload 15
    //   2054: ifnull -643 -> 1411
    //   2057: ldc_w 616
    //   2060: ldc_w 805
    //   2063: iconst_2
    //   2064: anewarray 4	java/lang/Object
    //   2067: dup
    //   2068: iconst_0
    //   2069: aload 15
    //   2071: getfield 623	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   2074: invokestatic 606	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2077: aastore
    //   2078: dup
    //   2079: iconst_1
    //   2080: lload 9
    //   2082: invokestatic 606	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2085: aastore
    //   2086: invokestatic 544	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2089: aload 15
    //   2091: getfield 623	com/tencent/mm/plugin/ipcall/model/h/k:systemRowid	J
    //   2094: ldc2_w 624
    //   2097: lcmp
    //   2098: ifeq -687 -> 1411
    //   2101: aload 15
    //   2103: iconst_5
    //   2104: putfield 628	com/tencent/mm/plugin/ipcall/model/h/k:field_status	I
    //   2107: aload 15
    //   2109: lload 9
    //   2111: putfield 808	com/tencent/mm/plugin/ipcall/model/h/k:field_duration	J
    //   2114: invokestatic 632	com/tencent/mm/plugin/ipcall/model/i:cUC	()Lcom/tencent/mm/plugin/ipcall/model/h/l;
    //   2117: aload 15
    //   2119: invokevirtual 637	com/tencent/mm/plugin/ipcall/model/h/l:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)V
    //   2122: goto -711 -> 1411
    //   2125: iload_1
    //   2126: bipush 11
    //   2128: if_icmpne -717 -> 1411
    //   2131: iload_2
    //   2132: iconst_5
    //   2133: if_icmpne +33 -> 2166
    //   2136: invokestatic 145	com/tencent/mm/plugin/ipcall/model/i:cUv	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   2139: iconst_3
    //   2140: invokevirtual 792	com/tencent/mm/plugin/ipcall/model/g:He	(I)V
    //   2143: invokestatic 368	com/tencent/mm/plugin/ipcall/model/i:cUx	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   2146: invokevirtual 795	com/tencent/mm/plugin/ipcall/model/d/b:cUR	()V
    //   2149: iload_2
    //   2150: bipush 11
    //   2152: if_icmpne +40 -> 2192
    //   2155: aload_0
    //   2156: getfield 614	com/tencent/mm/plugin/ipcall/c:tHf	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2159: invokestatic 787	com/tencent/mm/plugin/ipcall/model/h/m:b	(Lcom/tencent/mm/plugin/ipcall/model/h/k;)Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2162: pop
    //   2163: goto -752 -> 1411
    //   2166: iload_2
    //   2167: bipush 11
    //   2169: if_icmpne +13 -> 2182
    //   2172: invokestatic 145	com/tencent/mm/plugin/ipcall/model/i:cUv	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   2175: iconst_1
    //   2176: invokevirtual 792	com/tencent/mm/plugin/ipcall/model/g:He	(I)V
    //   2179: goto -36 -> 2143
    //   2182: invokestatic 145	com/tencent/mm/plugin/ipcall/model/i:cUv	()Lcom/tencent/mm/plugin/ipcall/model/g;
    //   2185: iconst_2
    //   2186: invokevirtual 792	com/tencent/mm/plugin/ipcall/model/g:He	(I)V
    //   2189: goto -46 -> 2143
    //   2192: aload_0
    //   2193: getfield 614	com/tencent/mm/plugin/ipcall/c:tHf	Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2196: invokestatic 368	com/tencent/mm/plugin/ipcall/model/i:cUx	()Lcom/tencent/mm/plugin/ipcall/model/d/b;
    //   2199: getfield 599	com/tencent/mm/plugin/ipcall/model/d/b:tJU	J
    //   2202: invokestatic 798	com/tencent/mm/plugin/ipcall/model/h/m:a	(Lcom/tencent/mm/plugin/ipcall/model/h/k;J)Lcom/tencent/mm/plugin/ipcall/model/h/k;
    //   2205: pop
    //   2206: goto -795 -> 1411
    //   2209: lload 13
    //   2211: lload 11
    //   2213: lsub
    //   2214: ldc2_w 809
    //   2217: lcmp
    //   2218: ifge +15 -> 2233
    //   2221: ldc_w 651
    //   2224: ldc_w 812
    //   2227: invokestatic 116	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   2230: goto -627 -> 1603
    //   2233: invokestatic 678	com/tencent/mm/model/az:ayM	()Lcom/tencent/mm/model/c;
    //   2236: pop
    //   2237: invokestatic 684	com/tencent/mm/model/c:agA	()Lcom/tencent/mm/storage/ae;
    //   2240: getstatic 690	com/tencent/mm/storage/ah$a:GGP	Lcom/tencent/mm/storage/ah$a;
    //   2243: iload_1
    //   2244: iconst_1
    //   2245: iadd
    //   2246: invokestatic 187	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2249: invokevirtual 816	com/tencent/mm/storage/ae:set	(Lcom/tencent/mm/storage/ah$a;Ljava/lang/Object;)V
    //   2252: invokestatic 678	com/tencent/mm/model/az:ayM	()Lcom/tencent/mm/model/c;
    //   2255: pop
    //   2256: invokestatic 684	com/tencent/mm/model/c:agA	()Lcom/tencent/mm/storage/ae;
    //   2259: getstatic 702	com/tencent/mm/storage/ah$a:GGO	Lcom/tencent/mm/storage/ah$a;
    //   2262: lload 13
    //   2264: invokestatic 606	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2267: invokevirtual 816	com/tencent/mm/storage/ae:set	(Lcom/tencent/mm/storage/ah$a;Ljava/lang/Object;)V
    //   2270: new 753	android/content/Intent
    //   2273: dup
    //   2274: invokespecial 754	android/content/Intent:<init>	()V
    //   2277: astore 16
    //   2279: aload 16
    //   2281: ldc_w 818
    //   2284: iload_2
    //   2285: invokevirtual 822	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   2288: pop
    //   2289: aload 16
    //   2291: ldc_w 824
    //   2294: lload 9
    //   2296: invokevirtual 827	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   2299: pop
    //   2300: aload 15
    //   2302: ldc_w 462
    //   2305: ldc_w 829
    //   2308: aload 16
    //   2310: invokestatic 834	com/tencent/mm/br/d:b	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/content/Intent;)V
    //   2313: goto -710 -> 1603
    //   2316: ldc 109
    //   2318: ldc_w 836
    //   2321: invokestatic 839	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   2324: goto -721 -> 1603
    //   2327: astore 15
    //   2329: ldc 109
    //   2331: aload 15
    //   2333: ldc_w 841
    //   2336: iconst_1
    //   2337: anewarray 4	java/lang/Object
    //   2340: dup
    //   2341: iconst_0
    //   2342: aload 15
    //   2344: invokevirtual 844	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2347: aastore
    //   2348: invokestatic 848	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   2351: iconst_0
    //   2352: istore_1
    //   2353: goto -661 -> 1692
    //   2356: goto -774 -> 1582
    //   2359: iconst_0
    //   2360: istore 5
    //   2362: goto -1991 -> 371
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2365	0	this	c
    //   0	2365	1	paramInt1	int
    //   0	2365	2	paramInt2	int
    //   0	2365	3	paramInt3	int
    //   1806	11	4	f	float
    //   373	1988	5	i	int
    //   952	34	6	j	int
    //   967	15	7	k	int
    //   193	171	8	bool	boolean
    //   1477	818	9	l1	long
    //   1552	660	11	l2	long
    //   1557	706	13	l3	long
    //   1829	17	15	localObject2	Object
    //   1908	393	15	localObject3	Object
    //   2327	16	15	localException	Exception
    //   1843	12	16	localObject5	Object
    //   2277	32	16	localIntent	Intent
    //   591	509	17	localObject6	Object
    //   1722	87	17	localThrowable	java.lang.Throwable
    //   598	382	18	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   286	363	1722	java/lang/Throwable
    //   371	417	1722	java/lang/Throwable
    //   702	737	1829	finally
    //   1831	1834	1829	finally
    //   813	859	1843	finally
    //   859	862	1843	finally
    //   1845	1848	1843	finally
    //   1660	1690	2327	java/lang/Exception
  }
  
  public static boolean aiH(String paramString)
  {
    AppMethodBeat.i(25298);
    ac.d("MicroMsg.IPCallManager", "dialWhenTalking, dialButton: %s", new Object[] { paramString });
    if (!com.tencent.mm.plugin.ipcall.model.i.cUz().cUr())
    {
      ac.i("MicroMsg.IPCallManager", "ipcall not connect, cannot call dialWhenTalking now");
      AppMethodBeat.o(25298);
      return false;
    }
    if ((!bs.isNullOrNil(paramString)) && (paramString.length() == 1))
    {
      int i;
      if ((!bs.isNullOrNil(paramString)) && (paramString.length() == 1))
      {
        i = paramString.charAt(0);
        if ((i >= 48) && (i <= 57)) {
          i -= 48;
        }
      }
      while (i != -1)
      {
        paramString = com.tencent.mm.plugin.ipcall.model.i.cUw();
        ac.d("MicroMsg.IPCallEngineManager", "sendDTMF: %d", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.ipcall.model.d.b localb = com.tencent.mm.plugin.ipcall.model.i.cUx();
        localb.tKm += 1;
        ac.i("MicroMsg.IPCallReportHelper", "now addCallClickCnt %d", new Object[] { Integer.valueOf(localb.tKm) });
        i = paramString.tJF.SendDTMF(i);
        if (i < 0) {
          ac.i("MicroMsg.IPCallEngineManager", "sendDTMF failed, ret: %d", new Object[] { Integer.valueOf(i) });
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
  
  private void removeListener()
  {
    AppMethodBeat.i(25295);
    if (this.tHh != null)
    {
      this.tHh.listen(this.kMN, 0);
      this.tHh = null;
    }
    com.tencent.mm.sdk.b.a.GpY.d(this.tHj);
    AppMethodBeat.o(25295);
  }
  
  public final void Ha(int paramInt)
  {
    AppMethodBeat.i(25315);
    ac.i("MicroMsg.IPCallManager", "onChannelConnectFailed, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cUz().kTr) });
    if (com.tencent.mm.plugin.ipcall.model.i.cUw().tJI)
    {
      ac.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel already connected");
      if (ga(5, paramInt))
      {
        g(5, null, ai.getContext().getString(2131756758), 1);
        AppMethodBeat.o(25315);
      }
    }
    else
    {
      ac.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel not connet, may be request connect failed");
      if (ga(4, paramInt)) {
        g(4, null, ai.getContext().getString(2131756758), 1);
      }
    }
    AppMethodBeat.o(25315);
  }
  
  public final void S(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(25300);
    ac.i("MicroMsg.IPCallManager", "onInviteFailed, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cUz().kTr) });
    if (ga(2, 0)) {
      g(2, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(25300);
  }
  
  public final void T(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(25309);
    ac.i("MicroMsg.IPCallManager", "onAccountOverdue, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cUz().kTr) });
    if (ga(8, 9)) {
      g(8, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(25309);
  }
  
  public final void U(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(25310);
    ac.i("MicroMsg.IPCallManager", "onCallRestricted, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cUz().kTr) });
    if (ga(10, 0)) {
      g(10, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(25310);
  }
  
  public final void V(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(25311);
    ac.i("MicroMsg.IPCallManager", "onCallPhoneNumberInvalid, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cUz().kTr) });
    if (ga(11, 0)) {
      g(11, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(25311);
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(25296);
    if (com.tencent.mm.plugin.ipcall.model.i.cUz().cUo())
    {
      ac.i("MicroMsg.IPCallManager", "startIPCall, already start!");
      AppMethodBeat.o(25296);
      return false;
    }
    ac.i("MicroMsg.IPCallManager", "startIPCall");
    com.tencent.mm.plugin.ipcall.model.i.cUv().tHM = this;
    com.tencent.mm.plugin.ipcall.model.i.cUw().tJK = this;
    com.tencent.mm.plugin.ipcall.model.i.cUz().kTr = -1;
    removeListener();
    this.tHh = ((TelephonyManager)ai.getContext().getSystemService("phone"));
    this.tHh.listen(this.kMN, 32);
    com.tencent.mm.sdk.b.a.GpY.c(this.tHj);
    ac.d("MicroMsg.IPCallRecordStorageLogic", "recordStartCall, phoneNumber: %s, contactId: %s", new Object[] { paramString4, paramString5 });
    Object localObject = new k();
    ((k)localObject).field_phonenumber = paramString4;
    if (!bs.isNullOrNil(paramString5))
    {
      com.tencent.mm.plugin.ipcall.model.h.c localc = com.tencent.mm.plugin.ipcall.model.i.cUB().aiM(paramString5);
      if ((localc != null) && (localc.systemRowid != -1L))
      {
        ((k)localObject).field_addressId = localc.systemRowid;
        if (paramInt1 == -1) {
          break label867;
        }
        ((k)localObject).field_phoneType = paramInt1;
        label201:
        ((k)localObject).field_calltime = bs.eWj();
        ((k)localObject).field_status = 1;
        if (!com.tencent.mm.plugin.ipcall.model.i.cUC().insert((com.tencent.mm.sdk.e.c)localObject)) {
          break label876;
        }
        label226:
        this.tHf = ((k)localObject);
        gox.postDelayed(this.tHl, 1754L);
        this.tHg = false;
        localObject = com.tencent.mm.plugin.ipcall.model.i.cUx();
        ac.d("MicroMsg.IPCallReportHelper", "reset");
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tJM = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tJN = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tJO = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tJP = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tJQ = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tJR = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tJS = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tJT = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tJU = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tJV = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).roomId = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tIG = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tJW = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).iOg = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tJX = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tJY = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tKa = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tJZ = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tHo = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tKb = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tKc = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tKh = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tKg = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tKd = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tKe = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).countryCode = "";
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tKi = 0L;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tKj = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tKk = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tKl = 0;
        ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tKm = 0;
        com.tencent.mm.plugin.ipcall.model.i.cUz().kTr = -1;
        ac.d("MicroMsg.IPCallManager", "startIPCall, username: %s, phoneNumber: %s", new Object[] { paramString3, paramString4 });
        localObject = com.tencent.mm.plugin.ipcall.model.i.cUv();
        ac.d("MicroMsg.IPCallSvrLogic", "startIPCall, toUsername: %s, toPhoneNumber: %s", new Object[] { paramString3, paramString4 });
        ((g)localObject).dsb = false;
        ((g)localObject).tHW = false;
        ((g)localObject).tHH = 0;
        ((g)localObject).tHI = 0;
        ((g)localObject).tHJ = 0;
        ((g)localObject).tHK = false;
        ((g)localObject).tHL = false;
        ((g)localObject).tHX = false;
        ((g)localObject).tHV = new com.tencent.mm.plugin.ipcall.model.b.c();
        ((g)localObject).tHV.nickname = paramString1;
        ((g)localObject).tHV.tJg = paramString2;
        ((g)localObject).tHV.dxO = paramString5;
        ((g)localObject).tHV.tJh = paramString4;
        ((g)localObject).tHV.dvw = paramString3;
        ((g)localObject).tHV.tII = ((int)System.currentTimeMillis());
        ((g)localObject).tHV.tIJ = paramInt2;
        ((g)localObject).tHV.tIK = paramInt3;
        ((g)localObject).tHV.tJj = paramInt1;
        ((g)localObject).tHN.a(((g)localObject).tHV);
        ((g)localObject).tHS.a(((g)localObject).tHV);
        ac.i("MicroMsg.IPCallSvrLogic", "startIPCallInternal, inviteId: %d", new Object[] { Integer.valueOf(((g)localObject).tHV.tII) });
        com.tencent.mm.plugin.ipcall.model.i.cUz().Hc(1);
        paramString1 = com.tencent.mm.plugin.ipcall.model.i.cUw();
        if (!paramString1.tJJ) {
          break label882;
        }
        ac.d("MicroMsg.IPCallEngineManager", "already start engine");
      }
    }
    for (;;)
    {
      gox.removeCallbacks(this.tHk);
      gox.postDelayed(this.tHk, 60000L);
      ac.m("MicroMsg.IPCallManager", "bindIPCallForegroundIfNeed", new Object[0]);
      if ((com.tencent.mm.compatible.util.d.kZ(26)) && (!this.tHi))
      {
        paramString1 = new Intent();
        paramString1.setClass(ai.getContext(), IPCallForegroundService.class);
      }
      try
      {
        ai.getContext().startService(paramString1);
        paramInt1 = 1;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          long l;
          ac.printErrStackTrace("MicroMsg.IPCallManager", paramString2, "using start service to bindIPCallForegroundIfNeed error: %s", new Object[] { paramString2.getMessage() });
          try
          {
            ai.getContext().startForegroundService(paramString1);
            paramInt1 = 0;
          }
          catch (Exception paramString1)
          {
            ac.printErrStackTrace("MicroMsg.IPCallManager", paramString1, "using start foreground service to bindIPCallForegroundIfNeed error: %s", new Object[] { paramString1.getMessage() });
            paramInt1 = 0;
          }
        }
      }
      if (paramInt1 != 0) {
        this.tHi = true;
      }
      AppMethodBeat.o(25296);
      return true;
      ((k)localObject).field_addressId = -1L;
      break;
      ((k)localObject).field_addressId = -1L;
      break;
      label867:
      ((k)localObject).field_phoneType = -1;
      break label201;
      label876:
      localObject = null;
      break label226;
      label882:
      paramString1.resetStatus();
      ac.i("MicroMsg.IPCallEngineManager", "start engine");
      if (paramString1.tJF.ekM())
      {
        paramString1.tJF.sH(false);
        paramString1.tJF.reset();
      }
      paramString1.tJF.AGf = 1;
      l = System.currentTimeMillis();
      paramInt1 = paramString1.tJF.ekO();
      ac.d("MicroMsg.IPCallEngineManager", "protocal init finish, ret: %d, used %dms", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() - l) });
      if ((paramString1.tJF.field_capInfo != null) && (paramString1.tJF.exchangeCabInfo(paramString1.tJF.field_capInfo, paramString1.tJF.field_capInfo.length) < 0))
      {
        ac.e("MicroMsg.IPCallEngineManager", "exchangeCabInfo failed");
        com.tencent.mm.plugin.ipcall.model.i.cUx().tJV = 24;
      }
      if (paramInt1 < 0) {
        ac.e("MicroMsg.IPCallEngineManager", "engine init failed!");
      }
      paramString1.tJF.AGf = 1;
      paramString1.tJJ = true;
    }
  }
  
  public final void cTL()
  {
    AppMethodBeat.i(25299);
    ac.i("MicroMsg.IPCallManager", "onInviteSuccess");
    if (!com.tencent.mm.plugin.ipcall.model.i.cUz().Hc(3))
    {
      AppMethodBeat.o(25299);
      return;
    }
    Object localObject = com.tencent.mm.plugin.ipcall.model.i.cUx();
    ac.d("MicroMsg.IPCallReportHelper", "markStartInvite");
    if (((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tJZ == 0L) {
      ((com.tencent.mm.plugin.ipcall.model.d.b)localObject).tJZ = System.currentTimeMillis();
    }
    localObject = com.tencent.mm.plugin.ipcall.model.i.cUv().tHV;
    com.tencent.mm.plugin.ipcall.model.d.b localb = com.tencent.mm.plugin.ipcall.model.i.cUx();
    int i = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).tII;
    String str1 = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).dvw;
    String str2 = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).tJh;
    int j = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).roomId;
    long l1 = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).tIG;
    long l2 = ((com.tencent.mm.plugin.ipcall.model.b.c)localObject).tIH;
    localb.tII = i;
    localb.tJY = str1;
    localb.iOg = str2;
    localb.roomId = j;
    localb.tIG = l1;
    localb.tJW = l2;
    if (this.tHe != null) {
      this.tHe.cTL();
    }
    AppMethodBeat.o(25299);
  }
  
  public final void cTM()
  {
    AppMethodBeat.i(25301);
    ac.i("MicroMsg.IPCallManager", "onStartRing, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cUz().kTr) });
    if (!com.tencent.mm.plugin.ipcall.model.i.cUz().Hc(4))
    {
      AppMethodBeat.o(25301);
      return;
    }
    com.tencent.mm.plugin.ipcall.model.d.b localb = com.tencent.mm.plugin.ipcall.model.i.cUx();
    ac.d("MicroMsg.IPCallReportHelper", "markStartRing");
    if (localb.tKa == 0L)
    {
      localb.tKa = System.currentTimeMillis();
      localb.tJR = (localb.tKa - localb.tJZ);
      ac.d("MicroMsg.IPCallReportHelper", "ringTime: %d", new Object[] { Long.valueOf(localb.tJR) });
    }
    com.tencent.mm.plugin.ipcall.model.i.cUw().cUQ();
    localb = com.tencent.mm.plugin.ipcall.model.i.cUx();
    ac.i("MicroMsg.IPCallReportHelper", "startRing");
    localb.tJM = 1;
    if (this.tHe != null) {
      this.tHe.cTM();
    }
    AppMethodBeat.o(25301);
  }
  
  public final void cTN()
  {
    AppMethodBeat.i(25302);
    ac.i("MicroMsg.IPCallManager", "onAccept, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cUz().kTr) });
    if (!com.tencent.mm.plugin.ipcall.model.i.cUz().Hc(5))
    {
      AppMethodBeat.o(25302);
      return;
    }
    com.tencent.mm.plugin.ipcall.model.d.b localb = com.tencent.mm.plugin.ipcall.model.i.cUx();
    ac.d("MicroMsg.IPCallReportHelper", "markUserAccept");
    if (localb.tHo == 0L)
    {
      localb.tHo = System.currentTimeMillis();
      localb.tJS = (localb.tHo - localb.tJZ);
      ac.d("MicroMsg.IPCallReportHelper", "answerTime: %d", new Object[] { Long.valueOf(localb.tJS) });
    }
    com.tencent.mm.plugin.ipcall.model.i.cUw().cUQ();
    localb = com.tencent.mm.plugin.ipcall.model.i.cUx();
    ac.i("MicroMsg.IPCallReportHelper", "userAccept");
    localb.tJN = 1;
    gox.removeCallbacks(this.tHk);
    com.tencent.mm.plugin.ipcall.model.i.cUF().stop();
    gox.removeCallbacks(this.tHl);
    com.tencent.mm.plugin.ipcall.model.i.cUy().tJo.bgk();
    if ((com.tencent.mm.plugin.ipcall.model.i.cUw().tJI) && (!this.tHg))
    {
      com.tencent.mm.plugin.ipcall.model.i.cUx().cUT();
      com.tencent.mm.plugin.ipcall.model.i.cUx().cUW();
      this.tHg = true;
      this.tHo = bs.aNx();
      aQW();
      com.tencent.mm.plugin.ipcall.model.i.cUw().cUP();
      if (this.tHe != null) {
        this.tHe.cUa();
      }
      com.tencent.mm.plugin.ipcall.model.i.cUx().cUV();
      r.ejf().ejg();
      r.ejf().a(this);
    }
    AppMethodBeat.o(25302);
  }
  
  public final void cTO()
  {
    AppMethodBeat.i(25306);
    ac.i("MicroMsg.IPCallManager", "onShutdownByOtherSide, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cUz().kTr) });
    if (ag(10, 0, 32))
    {
      if (this.tHe != null)
      {
        this.tHe.cUb();
        AppMethodBeat.o(25306);
        return;
      }
      Toast.makeText(ai.getContext(), ai.getContext().getString(2131760500), 1).show();
    }
    AppMethodBeat.o(25306);
  }
  
  public final void cTP()
  {
    AppMethodBeat.i(25308);
    ac.i("MicroMsg.IPCallManager", "onHeartbeatFailed");
    if (ga(7, 29)) {
      g(7, null, ai.getContext().getString(2131756758), 1);
    }
    AppMethodBeat.o(25308);
  }
  
  public final void cTQ()
  {
    AppMethodBeat.i(25312);
    do
    {
      ac.i("MicroMsg.IPCallManager", "onDisasterHappen, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cUz().kTr) });
    } while (ga(12, 0));
    AppMethodBeat.o(25312);
  }
  
  public final void cTR()
  {
    AppMethodBeat.i(25313);
    ac.i("MicroMsg.IPCallManager", "onStartEngineFailed, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cUz().kTr) });
    if (ga(6, 0)) {
      g(6, null, ai.getContext().getString(2131756764), 1);
    }
    AppMethodBeat.o(25313);
  }
  
  public final void cTS()
  {
    AppMethodBeat.i(25314);
    ac.i("MicroMsg.IPCallManager", "onChannelConnected, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cUz().kTr) });
    com.tencent.mm.plugin.ipcall.model.i.cUF().stop();
    gox.removeCallbacks(this.tHl);
    Object localObject1;
    Object localObject2;
    if (com.tencent.mm.plugin.ipcall.model.i.cUz().cUp())
    {
      localObject1 = com.tencent.mm.plugin.ipcall.model.i.cUy();
      ((com.tencent.mm.plugin.ipcall.model.c.b)localObject1).tJo.b("ipcall", Integer.valueOf(4));
      ac.d("MicroMsg.IPCallDeviceManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b", new Object[] { Boolean.valueOf(com.tencent.mm.plugin.ipcall.model.a.a.wH(3)), Boolean.valueOf(com.tencent.mm.plugin.ipcall.model.a.a.wH(4)) });
      localObject1 = ((com.tencent.mm.plugin.ipcall.model.c.b)localObject1).tJo;
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).tIz;
      if (localObject2 != null)
      {
        if (!((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).isStart) {
          break label345;
        }
        ac.d("MicroMsg.IPCallAudioPlayer", "startPlay, already start");
      }
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).tIy;
      if (localObject2 != null)
      {
        if (((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).bCu() != 3) {
          break label452;
        }
        bool = true;
        label156:
        ((a.b)localObject2).nn(bool);
      }
      localObject2 = ((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).tIy;
      if (localObject2 != null) {
        if (((com.tencent.mm.plugin.ipcall.model.a.a)localObject1).bCu() != 4) {
          break label457;
        }
      }
    }
    label452:
    label457:
    for (boolean bool = true;; bool = false)
    {
      ((a.b)localObject2).no(bool);
      com.tencent.mm.plugin.ipcall.model.i.cUx().cUT();
      com.tencent.mm.plugin.ipcall.model.i.cUy().tJo.bgk();
      if ((com.tencent.mm.plugin.ipcall.model.i.cUz().cUr()) && (!this.tHg))
      {
        com.tencent.mm.plugin.ipcall.model.i.cUx().cUW();
        com.tencent.mm.plugin.ipcall.model.i.cUw().cUP();
        this.tHg = true;
        this.tHo = bs.aNx();
        aQW();
        if (this.tHe != null) {
          this.tHe.cUa();
        }
        localObject1 = this.tHf;
        if (localObject1 != null)
        {
          ac.d("MicroMsg.IPCallRecordStorageLogic", "recordStartTalk, localId: %d", new Object[] { Long.valueOf(((k)localObject1).systemRowid) });
          if (((k)localObject1).systemRowid != -1L)
          {
            ((k)localObject1).field_status = 3;
            com.tencent.mm.plugin.ipcall.model.i.cUC().a((k)localObject1);
          }
        }
        com.tencent.mm.plugin.ipcall.model.i.cUx().cUV();
        r.ejf().ejg();
        r.ejf().a(this);
      }
      AppMethodBeat.o(25314);
      return;
      label345:
      ac.i("MicroMsg.IPCallAudioPlayer", "startPlay");
      if (((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).osB == null)
      {
        ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).osB = new com.tencent.mm.plugin.voip.model.c();
        ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).osB.M(v2protocal.VOICE_SAMPLERATE, 1, 20, 1);
      }
      ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).tJm = ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).osB.A(ai.getContext(), false);
      ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).osB.Ayq = new a.1((com.tencent.mm.plugin.ipcall.model.c.a)localObject2);
      if (((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).osB.ehg() <= 0) {
        com.tencent.mm.plugin.ipcall.model.i.cUx().cUU();
      }
      ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).tJo.cm(((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).tJn);
      ((com.tencent.mm.plugin.ipcall.model.c.a)localObject2).isStart = true;
      break;
      bool = false;
      break label156;
    }
  }
  
  public final void cTT() {}
  
  public final void cTU()
  {
    AppMethodBeat.i(25318);
    if (com.tencent.mm.plugin.ipcall.model.i.cUz().kTr != 5)
    {
      ac.i("MicroMsg.IPCallManager", "onResumeGoodNetStatus currentState != accept:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.ipcall.model.i.cUz().kTr) });
      AppMethodBeat.o(25318);
      return;
    }
    com.tencent.mm.plugin.ipcall.model.c.b localb = com.tencent.mm.plugin.ipcall.model.i.cUy();
    ac.i("MicroMsg.IPCallDeviceManager", "onResumeGoodNetStatus");
    if (localb.tJs != null) {
      localb.tJs.cVN();
    }
    AppMethodBeat.o(25318);
  }
  
  public final void cTV()
  {
    AppMethodBeat.i(25319);
    synchronized (this.qIi)
    {
      if (com.tencent.mm.plugin.ipcall.model.i.cUz().cUo())
      {
        if (this.tHm)
        {
          cTW();
          AppMethodBeat.o(25319);
          return;
        }
        this.tHm = true;
        Toast.makeText(ai.getContext(), 2131761425, 0).show();
        Intent localIntent = new Intent();
        localIntent.setFlags(268435456);
        localIntent.setClass(ai.getContext(), IPCallTalkUI.class);
        localIntent.putExtra("IPCallTalkUI_isFromMiniNotification", true);
        com.tencent.mm.plugin.voip.c.ehc().a(localIntent, false, true, this.tHn);
        cTW();
        if (this.tHe != null) {
          this.tHe.cUc();
        }
      }
      AppMethodBeat.o(25319);
      return;
    }
  }
  
  public final void cTW()
  {
    AppMethodBeat.i(25320);
    if (com.tencent.mm.compatible.util.d.la(26)) {
      if (!com.tencent.mm.plugin.ipcall.model.i.cUz().cUr()) {
        break label249;
      }
    }
    label249:
    for (Object localObject1 = ai.getContext().getString(2131760459, new Object[] { String.format("%02d:%02d", new Object[] { Long.valueOf(bs.pN(this.tHo) / 60L), Long.valueOf(bs.pN(this.tHo) % 60L) }) });; localObject1 = ai.getContext().getString(2131760458))
    {
      Object localObject2 = new Intent(ai.getContext(), IPCallTalkUI.class);
      ((Intent)localObject2).putExtra("IPCallTalkUI_isFromMiniNotification", true);
      localObject2 = PendingIntent.getActivity(ai.getContext(), 42, (Intent)localObject2, 134217728);
      int i = 2131233502;
      if (com.tencent.mm.compatible.util.d.la(19)) {
        i = 2131233500;
      }
      localObject1 = com.tencent.mm.bq.a.bE(ai.getContext(), "reminder_channel_id").i(ai.getContext().getString(2131760458)).i(System.currentTimeMillis()).f(ai.getContext().getString(2131760448)).g((CharSequence)localObject1);
      ((s.c)localObject1).Fu = ((PendingIntent)localObject2);
      localObject1 = ((s.c)localObject1).build();
      ((Notification)localObject1).icon = i;
      ((Notification)localObject1).flags |= 0x20;
      az.getNotification().a(42, (Notification)localObject1, false);
      if (com.tencent.mm.plugin.ipcall.model.i.cUz().cUr()) {
        break;
      }
      com.tencent.mm.plugin.voip.c.ehc().ayC(ai.getContext().getString(2131761459));
      AppMethodBeat.o(25320);
      return;
    }
    com.tencent.mm.plugin.voip.c.ehc().sQ(cTX());
    AppMethodBeat.o(25320);
  }
  
  public final int cTX()
  {
    AppMethodBeat.i(25322);
    int i = (int)bs.pN(this.tHo);
    if (i > 0)
    {
      AppMethodBeat.o(25322);
      return i;
    }
    AppMethodBeat.o(25322);
    return 0;
  }
  
  public final void dD(String paramString, int paramInt)
  {
    AppMethodBeat.i(25304);
    ac.i("MicroMsg.IPCallManager", "onUnAvaliable, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cUz().kTr) });
    if (ga(3, 5)) {
      g(3, null, paramString, paramInt);
    }
    AppMethodBeat.o(25304);
  }
  
  public final void dE(String paramString, int paramInt)
  {
    AppMethodBeat.i(25305);
    ac.i("MicroMsg.IPCallManager", "onBusy, currentState: %s", new Object[] { f.stateToString(com.tencent.mm.plugin.ipcall.model.i.cUz().kTr) });
    if (ga(1, 4)) {
      g(1, null, paramString, paramInt);
    }
    AppMethodBeat.o(25305);
  }
  
  public final void dF(String paramString, int paramInt)
  {
    AppMethodBeat.i(25307);
    ac.i("MicroMsg.IPCallManager", "onSyncFailed");
    if (ga(7, 35)) {
      g(7, null, paramString, paramInt);
    }
    AppMethodBeat.o(25307);
  }
  
  public final void g(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(25303);
    if (this.tHe != null)
    {
      this.tHe.g(paramInt1, paramString1, paramString2, paramInt2);
      AppMethodBeat.o(25303);
      return;
    }
    Toast.makeText(ai.getContext(), paramString2, 1).show();
    AppMethodBeat.o(25303);
  }
  
  public final boolean ga(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(25316);
    if (com.tencent.mm.plugin.ipcall.model.i.cUz().cUr())
    {
      if (paramInt1 == 0)
      {
        bool = ag(9, paramInt1, paramInt2);
        AppMethodBeat.o(25316);
        return bool;
      }
      bool = ag(11, paramInt1, paramInt2);
      AppMethodBeat.o(25316);
      return bool;
    }
    if (paramInt1 == 0)
    {
      bool = ag(8, paramInt1, paramInt2);
      AppMethodBeat.o(25316);
      return bool;
    }
    boolean bool = ag(12, paramInt1, paramInt2);
    AppMethodBeat.o(25316);
    return bool;
  }
  
  public final void ne(boolean paramBoolean)
  {
    AppMethodBeat.i(25317);
    if (com.tencent.mm.plugin.ipcall.model.i.cUz().kTr != 5)
    {
      ac.i("MicroMsg.IPCallManager", "onBadNetStatus currentState != accept:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.ipcall.model.i.cUz().kTr) });
      AppMethodBeat.o(25317);
      return;
    }
    com.tencent.mm.plugin.ipcall.model.c.b localb = com.tencent.mm.plugin.ipcall.model.i.cUy();
    ac.i("MicroMsg.IPCallDeviceManager", "onBadNetStatus");
    if (localb.tJs != null)
    {
      j localj = localb.tJs;
      if (localj.tSC != null) {
        localj.tSC.setVisibility(0);
      }
      if (localj.tSD != null) {
        localj.tSD.setVisibility(0);
      }
    }
    if (!localb.tJo.isSpeakerphoneOn())
    {
      long l = System.currentTimeMillis();
      if (l - localb.tJt > 30000L)
      {
        localb.tJt = l;
        com.tencent.mm.plugin.voip.c.ehb().AEF.ekn();
      }
    }
    AppMethodBeat.o(25317);
  }
  
  public final void nf(boolean paramBoolean)
  {
    AppMethodBeat.i(185745);
    synchronized (this.qIi)
    {
      this.tHm = false;
      com.tencent.mm.plugin.voip.c.ehc().qD(paramBoolean);
      ((NotificationManager)ai.getContext().getSystemService("notification")).cancel(42);
      AppMethodBeat.o(185745);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.c
 * JD-Core Version:    0.7.0.1
 */