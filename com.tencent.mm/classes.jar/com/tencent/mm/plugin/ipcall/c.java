package com.tencent.mm.plugin.ipcall;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Looper;
import android.support.v4.app.s.c;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.an;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.ipcall.a.b.a.1;
import com.tencent.mm.plugin.ipcall.a.b.b.a;
import com.tencent.mm.plugin.ipcall.a.b.c.a;
import com.tencent.mm.plugin.ipcall.a.f;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI;
import com.tencent.mm.plugin.ipcall.ui.j;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a;
import com.tencent.mm.plugin.voip.model.q;
import com.tencent.mm.plugin.voip.model.q.a;
import com.tencent.mm.plugin.voip.model.t;
import com.tencent.mm.plugin.voip.model.u;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.h;
import com.tencent.mm.plugin.voip.video.h.7;
import com.tencent.mm.plugin.voip.video.h.8;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class c
  implements com.tencent.mm.plugin.ipcall.a.c.a.a, com.tencent.mm.plugin.ipcall.a.g.a, q.a
{
  private static ak faV;
  private ap caS;
  public Object iiG;
  public e nLC;
  private com.tencent.mm.plugin.ipcall.a.g.k nLD;
  private boolean nLE;
  private TelephonyManager nLF;
  private PhoneStateListener nLG;
  private com.tencent.mm.sdk.b.c nLH;
  private Runnable nLI;
  private Runnable nLJ;
  public boolean nLK;
  public com.tencent.mm.plugin.voip.ui.a nLL;
  private long nLM;
  
  static
  {
    AppMethodBeat.i(21701);
    faV = new ak(Looper.getMainLooper());
    AppMethodBeat.o(21701);
  }
  
  public c()
  {
    AppMethodBeat.i(21672);
    this.nLE = false;
    this.iiG = new Object();
    this.nLG = new c.1(this);
    this.nLH = new c.2(this);
    this.nLI = new c.3(this);
    this.nLJ = new Runnable()
    {
      /* Error */
      public final void run()
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore_1
        //   2: iconst_1
        //   3: istore_3
        //   4: sipush 21668
        //   7: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   10: invokestatic 33	com/tencent/mm/plugin/ipcall/a/i:bJx	()Lcom/tencent/mm/plugin/voip/video/h;
        //   13: astore 5
        //   15: aload 5
        //   17: iconst_0
        //   18: putfield 39	com/tencent/mm/plugin/voip/video/h:tHo	I
        //   21: ldc2_w 40
        //   24: ldc2_w 42
        //   27: lcmp
        //   28: ifeq +239 -> 267
        //   31: invokestatic 49	com/tencent/mm/kernel/g:RL	()Lcom/tencent/mm/kernel/e;
        //   34: invokevirtual 55	com/tencent/mm/kernel/e:Ru	()Lcom/tencent/mm/storage/z;
        //   37: ldc 56
        //   39: getstatic 62	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
        //   42: invokevirtual 68	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
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
        //   69: invokestatic 85	com/tencent/mm/m/a:MB	()Z
        //   72: invokestatic 80	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   75: aastore
        //   76: dup
        //   77: iconst_2
        //   78: getstatic 62	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
        //   81: aastore
        //   82: invokestatic 90	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   85: iload_3
        //   86: istore_2
        //   87: iload_2
        //   88: ifeq +172 -> 260
        //   91: aload 5
        //   93: getfield 94	com/tencent/mm/plugin/voip/video/h:bVD	Z
        //   96: ifne +164 -> 260
        //   99: aload 5
        //   101: invokestatic 100	java/lang/System:currentTimeMillis	()J
        //   104: putfield 104	com/tencent/mm/plugin/voip/video/h:tHp	J
        //   107: aload 5
        //   109: new 106	com/tencent/mm/compatible/b/k
        //   112: dup
        //   113: invokespecial 107	com/tencent/mm/compatible/b/k:<init>	()V
        //   116: putfield 111	com/tencent/mm/plugin/voip/video/h:tHn	Landroid/media/MediaPlayer;
        //   119: ldc 74
        //   121: ldc 113
        //   123: iconst_2
        //   124: anewarray 4	java/lang/Object
        //   127: dup
        //   128: iconst_0
        //   129: invokestatic 119	com/tencent/mm/compatible/b/g:KC	()Lcom/tencent/mm/compatible/b/g;
        //   132: invokevirtual 122	com/tencent/mm/compatible/b/g:KH	()Z
        //   135: invokestatic 80	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   138: aastore
        //   139: dup
        //   140: iconst_1
        //   141: invokestatic 119	com/tencent/mm/compatible/b/g:KC	()Lcom/tencent/mm/compatible/b/g;
        //   144: invokevirtual 125	com/tencent/mm/compatible/b/g:KN	()Z
        //   147: invokestatic 80	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
        //   150: aastore
        //   151: invokestatic 128	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   154: getstatic 134	com/tencent/mm/compatible/e/ac:erv	Lcom/tencent/mm/compatible/e/b;
        //   157: getfield 139	com/tencent/mm/compatible/e/b:enk	I
        //   160: iflt +10 -> 170
        //   163: getstatic 134	com/tencent/mm/compatible/e/ac:erv	Lcom/tencent/mm/compatible/e/b;
        //   166: getfield 139	com/tencent/mm/compatible/e/b:enk	I
        //   169: istore_1
        //   170: aload 5
        //   172: iconst_0
        //   173: invokevirtual 143	com/tencent/mm/plugin/voip/video/h:nf	(Z)V
        //   176: aload 5
        //   178: ldc 144
        //   180: ldc2_w 40
        //   183: iconst_1
        //   184: iload_1
        //   185: invokevirtual 148	com/tencent/mm/plugin/voip/video/h:a	(IJZI)V
        //   188: aload 5
        //   190: iconst_1
        //   191: putfield 94	com/tencent/mm/plugin/voip/video/h:bVD	Z
        //   194: sipush 21668
        //   197: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   200: return
        //   201: astore 4
        //   203: iconst_1
        //   204: istore_2
        //   205: ldc 74
        //   207: new 153	java/lang/StringBuilder
        //   210: dup
        //   211: ldc 155
        //   213: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   216: aload 4
        //   218: invokevirtual 162	java/lang/Exception:getMessage	()Ljava/lang/String;
        //   221: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   224: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   227: invokestatic 173	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   230: goto -143 -> 87
        //   233: astore 4
        //   235: ldc 74
        //   237: new 153	java/lang/StringBuilder
        //   240: dup
        //   241: ldc 175
        //   243: invokespecial 158	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   246: aload 4
        //   248: invokevirtual 176	java/lang/Exception:toString	()Ljava/lang/String;
        //   251: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   254: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   257: invokestatic 173	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
        //   260: sipush 21668
        //   263: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   266: return
        //   267: aload 5
        //   269: ldc 144
        //   271: iconst_2
        //   272: iconst_1
        //   273: invokevirtual 180	com/tencent/mm/plugin/voip/video/h:q	(IIZ)V
        //   276: sipush 21668
        //   279: invokestatic 151	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   282: return
        //   283: astore 4
        //   285: goto -80 -> 205
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	288	0	this	4
        //   1	184	1	i	int
        //   51	154	2	bool1	boolean
        //   3	83	3	bool2	boolean
        //   201	16	4	localException1	java.lang.Exception
        //   233	14	4	localException2	java.lang.Exception
        //   283	1	4	localException3	java.lang.Exception
        //   13	255	5	localh	h
        // Exception table:
        //   from	to	target	type
        //   31	52	201	java/lang/Exception
        //   99	154	233	java/lang/Exception
        //   154	170	233	java/lang/Exception
        //   170	194	233	java/lang/Exception
        //   52	85	283	java/lang/Exception
      }
    };
    this.nLL = new com.tencent.mm.plugin.voip.ui.a()
    {
      public final void a(Intent paramAnonymousIntent, com.tencent.mm.plugin.voip.ui.e paramAnonymouse)
      {
        AppMethodBeat.i(21670);
        if (!i.bJr().bJk())
        {
          paramAnonymouse.aeI(ah.getContext().getString(2131301716));
          AppMethodBeat.o(21670);
          return;
        }
        int i = c.this.bIR();
        paramAnonymouse.aeJ(String.format("%02d:%02d", new Object[] { Integer.valueOf(i / 60), Integer.valueOf(i % 60) }));
        AppMethodBeat.o(21670);
      }
      
      public final boolean bIS()
      {
        AppMethodBeat.i(21669);
        if (i.bJr().bJh())
        {
          AppMethodBeat.o(21669);
          return true;
        }
        AppMethodBeat.o(21669);
        return false;
      }
    };
    this.nLM = 0L;
    AppMethodBeat.o(21672);
  }
  
  public static boolean QV(String paramString)
  {
    AppMethodBeat.i(21676);
    ab.d("MicroMsg.IPCallManager", "dialWhenTalking, dialButton: %s", new Object[] { paramString });
    if (!i.bJr().bJk())
    {
      ab.i("MicroMsg.IPCallManager", "ipcall not connect, cannot call dialWhenTalking now");
      AppMethodBeat.o(21676);
      return false;
    }
    if ((!bo.isNullOrNil(paramString)) && (paramString.length() == 1))
    {
      int i;
      if ((!bo.isNullOrNil(paramString)) && (paramString.length() == 1))
      {
        i = paramString.charAt(0);
        if ((i >= 48) && (i <= 57)) {
          i -= 48;
        }
      }
      while (i != -1)
      {
        paramString = i.bJo();
        ab.d("MicroMsg.IPCallEngineManager", "sendDTMF: %d", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.ipcall.a.c.b localb = i.bJp();
        localb.nOJ += 1;
        ab.i("MicroMsg.IPCallReportHelper", "now addCallClickCnt %d", new Object[] { Integer.valueOf(localb.nOJ) });
        i = paramString.nOc.SendDTMF(i);
        if (i < 0) {
          ab.i("MicroMsg.IPCallEngineManager", "sendDTMF failed, ret: %d", new Object[] { Integer.valueOf(i) });
        }
        AppMethodBeat.o(21676);
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
    AppMethodBeat.o(21676);
    return false;
  }
  
  private boolean X(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(21675);
    ??? = i.bJn().nMs;
    if (!i.bJr().xF(paramInt1))
    {
      ab.i("MicroMsg.IPCallManager", "finishIPCall, cannot finish now, currentState: %s", new Object[] { f.stateToString(i.bJr().mCurrentState) });
      if (??? != null) {
        ab.i("MicroMsg.IPCallManager", "finishIPCall, cannot finish now inviteId:%d, roomId:%d, state:%d,errStatus:%d, pstnErrCode:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.a.c)???).nNc), Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.a.c)???).nMZ), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      }
      AppMethodBeat.o(21675);
      return false;
    }
    if (??? != null) {
      ab.i("MicroMsg.IPCallManager", "finishIPCall inviteId:%d, roomId:%d, state:%d, errStatus:%d, pstnErrCode:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.a.c)???).nNc), Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.a.c)???).nMZ), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    ab.i("MicroMsg.IPCallManager", "closeDeviceEngine");
    q.cNr().cNt();
    q.cNr().a(null);
    ??? = i.bJp();
    ??? = i.bJq();
    label324:
    Object localObject6;
    if (((com.tencent.mm.plugin.ipcall.a.b.b)???).nNL != null)
    {
      ??? = ((com.tencent.mm.plugin.ipcall.a.b.b)???).nNL;
      if (((com.tencent.mm.plugin.ipcall.a.b.c)???).nNR != null)
      {
        i = ((com.tencent.mm.plugin.ipcall.a.b.c)???).nNR.cjh;
        if (((com.tencent.mm.plugin.ipcall.a.c.b)???).nOG == 0) {
          ((com.tencent.mm.plugin.ipcall.a.c.b)???).nOG = i;
        }
        ??? = i.bJp();
        ??? = i.bJq();
        if (((com.tencent.mm.plugin.ipcall.a.b.b)???).nNK == null) {
          break label1664;
        }
        ??? = ((com.tencent.mm.plugin.ipcall.a.b.b)???).nNK;
        if (((com.tencent.mm.plugin.ipcall.a.b.a)???).kJR == null) {
          break label1658;
        }
        ab.d("MicroMsg.IPCallAudioPlayer", "AudioPlayer  mAudioPlayErrState:" + ((com.tencent.mm.plugin.ipcall.a.b.a)???).kJR.cLK());
        i = ((com.tencent.mm.plugin.ipcall.a.b.a)???).kJR.cLK();
        if (((com.tencent.mm.plugin.ipcall.a.c.b)???).nOH == 0) {
          ((com.tencent.mm.plugin.ipcall.a.c.b)???).nOH = i;
        }
        ??? = i.bJq();
        ??? = i.bJo();
        i = 0;
        if (((com.tencent.mm.plugin.ipcall.a.b.b)???).nNK != null)
        {
          localObject6 = ((com.tencent.mm.plugin.ipcall.a.b.b)???).nNK;
          if ((((com.tencent.mm.plugin.ipcall.a.b.a)localObject6).kJR == null) || (!((com.tencent.mm.plugin.ipcall.a.b.a)localObject6).isStart)) {
            break label1670;
          }
          i = ((com.tencent.mm.plugin.ipcall.a.b.a)localObject6).kJR.cLL();
        }
        label393:
        if (i != -1) {
          break label1676;
        }
        i = 0;
        label402:
        ((com.tencent.mm.plugin.ipcall.a.c.a)???).nOc.tAC = i;
        ((com.tencent.mm.plugin.ipcall.a.b.b)???).gaP.Mh();
        localObject6 = ((com.tencent.mm.plugin.ipcall.a.b.b)???).nNK;
        if (((com.tencent.mm.plugin.ipcall.a.b.a)localObject6).isStart) {
          ab.i("MicroMsg.IPCallAudioPlayer", "stopPlay");
        }
        synchronized (((com.tencent.mm.plugin.ipcall.a.b.a)localObject6).nNF)
        {
          com.tencent.mm.sdk.g.d.post(new com.tencent.mm.plugin.ipcall.a.b.a.a((com.tencent.mm.plugin.ipcall.a.b.a)localObject6, ((com.tencent.mm.plugin.ipcall.a.b.a)localObject6).kJR), "IPCallAudioPlayer_stop");
          ((com.tencent.mm.plugin.ipcall.a.b.a)localObject6).isStart = false;
          ((com.tencent.mm.plugin.ipcall.a.b.a)localObject6).kJR = null;
          ((com.tencent.mm.plugin.ipcall.a.b.b)???).cmc = null;
          ((com.tencent.mm.plugin.ipcall.a.b.b)???).kJT.fg(ah.getContext());
          aw.aaA().KF();
          aw.aaA().b((com.tencent.mm.compatible.b.g.a)???);
          ((com.tencent.mm.plugin.ipcall.a.b.b)???).nNP = null;
          ((com.tencent.mm.plugin.ipcall.a.b.b)???).nNN = null;
          ??? = i.bJq();
          localObject6 = ((com.tencent.mm.plugin.ipcall.a.b.b)???).nNL;
          if (((com.tencent.mm.plugin.ipcall.a.b.c)localObject6).isStart) {
            ab.i("MicroMsg.IPCallRecorder", "stop record");
          }
        }
      }
    }
    for (;;)
    {
      synchronized (((com.tencent.mm.plugin.ipcall.a.b.c)localObject6).nNS)
      {
        if (((com.tencent.mm.plugin.ipcall.a.b.c)localObject6).nNR != null)
        {
          com.tencent.mm.sdk.g.d.post(new c.a((com.tencent.mm.plugin.ipcall.a.b.c)localObject6, ((com.tencent.mm.plugin.ipcall.a.b.c)localObject6).nNR), "IPCallRecorder_stopRecord");
          ((com.tencent.mm.plugin.ipcall.a.b.c)localObject6).nNR = null;
          ((com.tencent.mm.plugin.ipcall.a.b.c)localObject6).isStart = false;
          ((com.tencent.mm.plugin.ipcall.a.b.c)localObject6).efg = false;
        }
        ((com.tencent.mm.plugin.ipcall.a.b.b)???).cmc = null;
        ??? = i.bJo();
        ab.i("MicroMsg.IPCallEngineManager", "close engine");
        ((com.tencent.mm.plugin.ipcall.a.c.a)???).nOc.mX(true);
        ??? = i.bJp();
        boolean bool;
        if ((bo.isNullOrNil(((com.tencent.mm.plugin.ipcall.a.c.b)???).nOB)) && (bo.isNullOrNil(((com.tencent.mm.plugin.ipcall.a.c.b)???).nOA)))
        {
          Object localObject7 = i.bJn().nMs;
          localObject6 = i.bJo().nOc;
          if (((com.tencent.mm.plugin.ipcall.a.c.b)???).nOq == 1)
          {
            i = 1;
            int j = ((com.tencent.mm.plugin.ipcall.a.a.c)localObject7).nNv;
            localObject7 = ((v2protocal)localObject6).tBJ;
            int k = ((v2protocal)localObject6).tBJ.length;
            if (i == 0) {
              break label1743;
            }
            i = 1;
            ((v2protocal)localObject6).getPstnChannelInfo((byte[])localObject7, k, i, j);
            ab.d("MicroMsg.Voip", "field_pstnChannelInfoLength: %d", new Object[] { Integer.valueOf(((v2protocal)localObject6).field_pstnChannelInfoLength) });
            ((com.tencent.mm.plugin.ipcall.a.c.b)???).nOB = new String(((v2protocal)localObject6).tBJ, 0, ((v2protocal)localObject6).field_pstnChannelInfoLength);
            localObject6 = i.bJo().nOc;
            ((v2protocal)localObject6).getPstnEngineInfo(((v2protocal)localObject6).tBK, ((v2protocal)localObject6).tBK.length);
            ab.d("MicroMsg.Voip", "field_pstnEngineInfoLength: %d", new Object[] { Integer.valueOf(((v2protocal)localObject6).field_pstnEngineInfoLength) });
            ((com.tencent.mm.plugin.ipcall.a.c.b)???).nOA = new String(((v2protocal)localObject6).tBK, 0, ((v2protocal)localObject6).field_pstnEngineInfoLength);
            ((com.tencent.mm.plugin.ipcall.a.c.b)???).nOC = i.bJo().nOc.cOF();
            ab.d("MicroMsg.IPCallReportHelper", "nativeChannelReportString: %s", new Object[] { ((com.tencent.mm.plugin.ipcall.a.c.b)???).nOB });
            ab.d("MicroMsg.IPCallReportHelper", "nativeEngineReportString: %s", new Object[] { ((com.tencent.mm.plugin.ipcall.a.c.b)???).nOA });
            ab.d("MicroMsg.IPCallReportHelper", "clientReportExString: %s", new Object[] { ((com.tencent.mm.plugin.ipcall.a.c.b)???).nOC });
          }
        }
        else
        {
          ((com.tencent.mm.plugin.ipcall.a.c.a)???).nOc.reset();
          ((com.tencent.mm.plugin.ipcall.a.c.a)???).aEa();
          i.bJx().stop();
          ??? = i.bJx();
          i.bJq();
          bool = aw.aaA().elW.isSpeakerphoneOn();
          ((h)???).mContext.getSharedPreferences(ah.dsP(), 0).getBoolean("settings_shake", true);
          com.tencent.mm.compatible.b.g.KC().setSpeakerphoneOn(bool);
          if (!bool) {
            break label1749;
          }
          com.tencent.mm.compatible.b.g.KC().setMode(0);
          ab.i("MicroMsg.RingPlayer", "playSound, shake: %s, isSpeakerOn: %s, type: %s", new Object[] { Boolean.FALSE, Boolean.valueOf(bool), Integer.valueOf(2) });
          ((h)???).tHq = System.currentTimeMillis();
          ??? = new com.tencent.mm.compatible.b.k();
        }
        try
        {
          ((MediaPlayer)???).setDataSource(((h)???).mContext, Uri.parse("android.resource://" + ((h)???).mContext.getPackageName() + "/2131231865"));
          ((MediaPlayer)???).setOnCompletionListener(new h.7((h)???));
          ((MediaPlayer)???).setOnErrorListener(new h.8((h)???));
          if (com.tencent.mm.compatible.b.g.KC().KH()) {
            break label2265;
          }
          if (bool) {
            break label1759;
          }
        }
        catch (Throwable localThrowable)
        {
          long l2;
          long l3;
          float f;
          ab.w("MicroMsg.RingPlayer", "playSound Failed Throwable t = ", new Object[] { localThrowable });
          localObject2.tHo = 6;
          localObject5.stop();
          localObject5.release();
          continue;
          if (paramInt1 != 12) {
            break label1905;
          }
          i.bJn().bJl();
          i.bJp().bJK();
          if (paramInt2 != 11) {
            break label1840;
          }
          m.b(this.nLD);
          continue;
          Object localObject3 = this.nLD;
          if (localObject3 == null) {
            continue;
          }
          ab.d("MicroMsg.IPCallRecordStorageLogic", "recordCallFailed, localId: %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.ipcall.a.g.k)localObject3).systemRowid) });
          if (((com.tencent.mm.plugin.ipcall.a.g.k)localObject3).systemRowid == -1L) {
            continue;
          }
          ((com.tencent.mm.plugin.ipcall.a.g.k)localObject3).field_status = 6;
          i.bJu().a((com.tencent.mm.plugin.ipcall.a.g.k)localObject3);
          continue;
          if (paramInt1 != 9) {
            break label1941;
          }
          i.bJn().xH(1);
          i.bJp().bJJ();
          m.a(this.nLD, i.bJp().nOr);
          continue;
          if (paramInt1 != 10) {
            break label2060;
          }
          i.bJn().xH(1);
          localObject3 = i.bJp();
          ab.i("MicroMsg.IPCallReportHelper", "otherSideUserShutdown");
          ((com.tencent.mm.plugin.ipcall.a.c.b)localObject3).nOl = 1;
          localObject3 = this.nLD;
          long l1 = i.bJp().nOr;
          if (localObject3 == null) {
            continue;
          }
          ab.d("MicroMsg.IPCallRecordStorageLogic", "recordOthersideShutdownCall, localId: %d, talkTime: %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.ipcall.a.g.k)localObject3).systemRowid), Long.valueOf(l1) });
          if (((com.tencent.mm.plugin.ipcall.a.g.k)localObject3).systemRowid == -1L) {
            continue;
          }
          ((com.tencent.mm.plugin.ipcall.a.g.k)localObject3).field_status = 5;
          ((com.tencent.mm.plugin.ipcall.a.g.k)localObject3).field_duration = l1;
          i.bJu().a((com.tencent.mm.plugin.ipcall.a.g.k)localObject3);
          continue;
          if (paramInt1 != 11) {
            continue;
          }
          if (paramInt2 != 5) {
            break label2101;
          }
          i.bJn().xH(3);
          for (;;)
          {
            i.bJp().bJJ();
            if (paramInt2 != 11) {
              break label2127;
            }
            m.b(this.nLD);
            break;
            if (paramInt2 == 11) {
              i.bJn().xH(1);
            } else {
              i.bJn().xH(2);
            }
          }
          m.a(this.nLD, i.bJp().nOr);
          continue;
          if (l3 - l2 >= 1800L) {
            break label2168;
          }
          ab.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog not reach INTERVAL_TIMES_TRY_SHOW_WCO_FEEDBACK_MAIN");
          continue;
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yAE, Integer.valueOf(paramInt1 + 1));
          aw.aaz();
          com.tencent.mm.model.c.Ru().set(ac.a.yAD, Long.valueOf(l3));
          Intent localIntent = new Intent();
          localIntent.putExtra("IPCallFeedbackDialogUI_KRoomId", paramInt2);
          localIntent.putExtra("IPCallFeedbackDialogUI_KCallseq", l1);
          com.tencent.mm.bq.d.b((Context)localObject3, "ipcall", ".ui.IPCallFeedbackDialogUI", localIntent);
          continue;
          ab.e("MicroMsg.IPCallManager", "roomId = 0,ignore feedback");
          continue;
          continue;
          i = 0;
          continue;
        }
        ((MediaPlayer)???).setAudioStreamType(i);
        ((MediaPlayer)???).prepare();
        ((MediaPlayer)???).setLooping(false);
        ((MediaPlayer)???).start();
        if (System.currentTimeMillis() - ((h)???).tHq > 2000L) {
          ((h)???).tHo = 7;
        }
        faV.removeCallbacks(this.nLJ);
        faV.removeCallbacks(this.nLI);
        if (this.caS != null)
        {
          this.caS.stopTimer();
          this.caS = null;
        }
        i.bJp().nOs = paramInt3;
        ??? = i.bJp();
        ab.d("MicroMsg.IPCallReportHelper", "markEndTalk");
        if ((((com.tencent.mm.plugin.ipcall.a.c.b)???).nOz == 0L) && (((com.tencent.mm.plugin.ipcall.a.c.b)???).nOy != 0L))
        {
          ((com.tencent.mm.plugin.ipcall.a.c.b)???).nOz = System.currentTimeMillis();
          ((com.tencent.mm.plugin.ipcall.a.c.b)???).nOr = ((((com.tencent.mm.plugin.ipcall.a.c.b)???).nOz - ((com.tencent.mm.plugin.ipcall.a.c.b)???).nOy) / 1000L);
          ab.d("MicroMsg.IPCallReportHelper", "callTime: %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.ipcall.a.c.b)???).nOr) });
        }
        if (paramInt1 != 8) {
          break label1805;
        }
        i.bJn().bJl();
        i.bJp().bJK();
        ??? = this.nLD;
        if (??? != null)
        {
          ab.d("MicroMsg.IPCallRecordStorageLogic", "recordCancelCall, localId: %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.ipcall.a.g.k)???).systemRowid) });
          if (((com.tencent.mm.plugin.ipcall.a.g.k)???).systemRowid != -1L)
          {
            ((com.tencent.mm.plugin.ipcall.a.g.k)???).field_status = 2;
            i.bJu().a((com.tencent.mm.plugin.ipcall.a.g.k)???);
          }
        }
        if (i.bJn().cDO)
        {
          if ((this.nLK) || (i.bJn().nMs.nMZ == 0) || (i.bJn().nMs.nNb == 0L)) {
            break label2251;
          }
          ??? = ah.getContext();
          paramInt2 = i.bJn().nMs.nMZ;
          l1 = i.bJn().nMs.nNb;
          ab.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog");
          if (d.bIT())
          {
            paramInt3 = com.tencent.mm.m.g.Nq().getInt("WCOMaxTimesForShowFeedback", 0);
            aw.aaz();
            paramInt1 = ((Integer)com.tencent.mm.model.c.Ru().get(ac.a.yAE, Integer.valueOf(0))).intValue();
            aw.aaz();
            l2 = ((Long)com.tencent.mm.model.c.Ru().get(ac.a.yAD, Long.valueOf(0L))).longValue();
            l3 = bo.aox();
            if (l3 - l2 <= 86400L) {
              break label2262;
            }
            paramInt1 = 0;
            ab.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog reset time");
            if (paramInt1 < paramInt3) {
              break label2144;
            }
            ab.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog reach max time".concat(String.valueOf(paramInt3)));
          }
        }
        i.bJn().nMj = null;
        i.bJo().nOh = null;
        i.bJr().mCurrentState = -1;
        bIQ();
        removeListener();
        AppMethodBeat.o(21675);
        return true;
        i = 0;
        break;
        i = 0;
        break;
        label1658:
        i = 0;
        break label324;
        label1664:
        i = 0;
        break label324;
        label1670:
        i = -1;
        break label393;
        label1676:
        f = aw.aaA().getStreamMaxVolume(i);
        i = (int)(aw.aaA().getStreamVolume(i) / f * 100.0F);
        break label402;
        localObject2 = finally;
        AppMethodBeat.o(21675);
        throw localObject2;
      }
      i = 0;
      continue;
      label1743:
      i = 0;
      continue;
      label1749:
      com.tencent.mm.compatible.b.g.KC().setMode(2);
      continue;
      label1759:
      i = 2;
    }
  }
  
  private void arF()
  {
    AppMethodBeat.i(21700);
    ab.i("MicroMsg.IPCallManager", "startTimeCount");
    if (this.caS != null)
    {
      this.caS.stopTimer();
      AppMethodBeat.o(21700);
      return;
    }
    if (this.caS == null) {
      this.caS = new ap(Looper.getMainLooper(), new ap.a()
      {
        public final boolean onTimerExpired()
        {
          AppMethodBeat.i(21671);
          c.this.bIP();
          if ((i.bJr().bJk()) && (c.a(c.this) != null)) {
            c.a(c.this).bIX();
          }
          AppMethodBeat.o(21671);
          return true;
        }
      }, true);
    }
    this.caS.ag(1000L, 1000L);
    AppMethodBeat.o(21700);
  }
  
  private void removeListener()
  {
    AppMethodBeat.i(21673);
    if (this.nLF != null)
    {
      this.nLF.listen(this.nLG, 0);
      this.nLF = null;
    }
    com.tencent.mm.sdk.b.a.ymk.d(this.nLH);
    AppMethodBeat.o(21673);
  }
  
  public final void F(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(21678);
    ab.i("MicroMsg.IPCallManager", "onInviteFailed, currentState: %s", new Object[] { f.stateToString(i.bJr().mCurrentState) });
    if (ex(2, 0)) {
      d(2, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(21678);
  }
  
  public final void G(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(21687);
    ab.i("MicroMsg.IPCallManager", "onAccountOverdue, currentState: %s", new Object[] { f.stateToString(i.bJr().mCurrentState) });
    if (ex(8, 9)) {
      d(8, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(21687);
  }
  
  public final void H(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(21688);
    ab.i("MicroMsg.IPCallManager", "onCallRestricted, currentState: %s", new Object[] { f.stateToString(i.bJr().mCurrentState) });
    if (ex(10, 0)) {
      d(10, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(21688);
  }
  
  public final void I(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(21689);
    ab.i("MicroMsg.IPCallManager", "onCallPhoneNumberInvalid, currentState: %s", new Object[] { f.stateToString(i.bJr().mCurrentState) });
    if (ex(11, 0)) {
      d(11, paramString1, paramString2, paramInt);
    }
    AppMethodBeat.o(21689);
  }
  
  public final boolean a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(21674);
    if (i.bJr().bJh())
    {
      ab.i("MicroMsg.IPCallManager", "startIPCall, already start!");
      AppMethodBeat.o(21674);
      return false;
    }
    ab.i("MicroMsg.IPCallManager", "startIPCall");
    i.bJn().nMj = this;
    i.bJo().nOh = this;
    i.bJr().mCurrentState = -1;
    removeListener();
    this.nLF = ((TelephonyManager)ah.getContext().getSystemService("phone"));
    this.nLF.listen(this.nLG, 32);
    com.tencent.mm.sdk.b.a.ymk.c(this.nLH);
    ab.d("MicroMsg.IPCallRecordStorageLogic", "recordStartCall, phoneNumber: %s, contactId: %s", new Object[] { paramString4, paramString5 });
    Object localObject = new com.tencent.mm.plugin.ipcall.a.g.k();
    ((com.tencent.mm.plugin.ipcall.a.g.k)localObject).field_phonenumber = paramString4;
    if (!bo.isNullOrNil(paramString5))
    {
      com.tencent.mm.plugin.ipcall.a.g.c localc = i.bJt().Ra(paramString5);
      if ((localc != null) && (localc.systemRowid != -1L))
      {
        ((com.tencent.mm.plugin.ipcall.a.g.k)localObject).field_addressId = localc.systemRowid;
        if (paramInt1 == -1) {
          break label798;
        }
        ((com.tencent.mm.plugin.ipcall.a.g.k)localObject).field_phoneType = paramInt1;
        label201:
        ((com.tencent.mm.plugin.ipcall.a.g.k)localObject).field_calltime = bo.aoy();
        ((com.tencent.mm.plugin.ipcall.a.g.k)localObject).field_status = 1;
        if (!i.bJu().insert((com.tencent.mm.sdk.e.c)localObject)) {
          break label807;
        }
        label226:
        this.nLD = ((com.tencent.mm.plugin.ipcall.a.g.k)localObject);
        faV.postDelayed(this.nLJ, 1754L);
        this.nLE = false;
        localObject = i.bJp();
        ab.d("MicroMsg.IPCallReportHelper", "reset");
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOj = 0;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOk = 0;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOl = 0;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOm = 0;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOn = 0;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOo = 0L;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOp = 0L;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOq = 0;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOr = 0L;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOs = 0;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nMZ = 0;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nNa = 0L;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOt = 0L;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).gAF = "";
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOu = 0;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOv = "";
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOx = 0L;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOw = 0L;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nLM = 0L;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOy = 0L;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOz = 0L;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOE = 0L;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOD = 0L;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOA = "";
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOB = "";
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).countryCode = "";
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOF = 0L;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOG = 0;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOH = 0;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOI = 0;
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOJ = 0;
        i.bJr().mCurrentState = -1;
        ab.d("MicroMsg.IPCallManager", "startIPCall, username: %s, phoneNumber: %s", new Object[] { paramString3, paramString4 });
        localObject = i.bJn();
        ab.d("MicroMsg.IPCallSvrLogic", "startIPCall, toUsername: %s, toPhoneNumber: %s", new Object[] { paramString3, paramString4 });
        ((com.tencent.mm.plugin.ipcall.a.g)localObject).cDO = false;
        ((com.tencent.mm.plugin.ipcall.a.g)localObject).nMt = false;
        ((com.tencent.mm.plugin.ipcall.a.g)localObject).nMe = 0;
        ((com.tencent.mm.plugin.ipcall.a.g)localObject).nMf = 0;
        ((com.tencent.mm.plugin.ipcall.a.g)localObject).nMg = 0;
        ((com.tencent.mm.plugin.ipcall.a.g)localObject).nMh = false;
        ((com.tencent.mm.plugin.ipcall.a.g)localObject).nMi = false;
        ((com.tencent.mm.plugin.ipcall.a.g)localObject).nMu = false;
        ((com.tencent.mm.plugin.ipcall.a.g)localObject).nMs = new com.tencent.mm.plugin.ipcall.a.a.c();
        ((com.tencent.mm.plugin.ipcall.a.g)localObject).nMs.nickname = paramString1;
        ((com.tencent.mm.plugin.ipcall.a.g)localObject).nMs.nNA = paramString2;
        ((com.tencent.mm.plugin.ipcall.a.g)localObject).nMs.cJk = paramString5;
        ((com.tencent.mm.plugin.ipcall.a.g)localObject).nMs.nNB = paramString4;
        ((com.tencent.mm.plugin.ipcall.a.g)localObject).nMs.cGY = paramString3;
        ((com.tencent.mm.plugin.ipcall.a.g)localObject).nMs.nNc = ((int)System.currentTimeMillis());
        ((com.tencent.mm.plugin.ipcall.a.g)localObject).nMs.nNd = paramInt2;
        ((com.tencent.mm.plugin.ipcall.a.g)localObject).nMs.nNe = paramInt3;
        ((com.tencent.mm.plugin.ipcall.a.g)localObject).nMs.nND = paramInt1;
        ((com.tencent.mm.plugin.ipcall.a.g)localObject).nMk.a(((com.tencent.mm.plugin.ipcall.a.g)localObject).nMs);
        ((com.tencent.mm.plugin.ipcall.a.g)localObject).nMp.a(((com.tencent.mm.plugin.ipcall.a.g)localObject).nMs);
        ab.i("MicroMsg.IPCallSvrLogic", "startIPCallInternal, inviteId: %d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.g)localObject).nMs.nNc) });
        i.bJr().xF(1);
        paramString1 = i.bJo();
        if (!paramString1.nOg) {
          break label813;
        }
        ab.d("MicroMsg.IPCallEngineManager", "already start engine");
      }
    }
    for (;;)
    {
      faV.removeCallbacks(this.nLI);
      faV.postDelayed(this.nLI, 60000L);
      AppMethodBeat.o(21674);
      return true;
      ((com.tencent.mm.plugin.ipcall.a.g.k)localObject).field_addressId = -1L;
      break;
      ((com.tencent.mm.plugin.ipcall.a.g.k)localObject).field_addressId = -1L;
      break;
      label798:
      ((com.tencent.mm.plugin.ipcall.a.g.k)localObject).field_phoneType = -1;
      break label201;
      label807:
      localObject = null;
      break label226;
      label813:
      paramString1.aEa();
      ab.i("MicroMsg.IPCallEngineManager", "start engine");
      if (paramString1.nOc.cOG())
      {
        paramString1.nOc.mX(false);
        paramString1.nOc.reset();
      }
      paramString1.nOc.tAa = 1;
      long l = System.currentTimeMillis();
      paramInt1 = paramString1.nOc.cOI();
      ab.d("MicroMsg.IPCallEngineManager", "protocal init finish, ret: %d, used %dms", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() - l) });
      if ((paramString1.nOc.field_capInfo != null) && (paramString1.nOc.exchangeCabInfo(paramString1.nOc.field_capInfo, paramString1.nOc.field_capInfo.length) < 0))
      {
        ab.e("MicroMsg.IPCallEngineManager", "exchangeCabInfo failed");
        i.bJp().nOs = 24;
      }
      if (paramInt1 < 0) {
        ab.e("MicroMsg.IPCallEngineManager", "engine init failed!");
      }
      paramString1.nOc.tAa = 1;
      paramString1.nOg = true;
    }
  }
  
  public final void bIG()
  {
    AppMethodBeat.i(21677);
    ab.i("MicroMsg.IPCallManager", "onInviteSuccess");
    if (!i.bJr().xF(3))
    {
      AppMethodBeat.o(21677);
      return;
    }
    Object localObject = i.bJp();
    ab.d("MicroMsg.IPCallReportHelper", "markStartInvite");
    if (((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOw == 0L) {
      ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).nOw = System.currentTimeMillis();
    }
    localObject = i.bJn().nMs;
    com.tencent.mm.plugin.ipcall.a.c.b localb = i.bJp();
    int i = ((com.tencent.mm.plugin.ipcall.a.a.c)localObject).nNc;
    String str1 = ((com.tencent.mm.plugin.ipcall.a.a.c)localObject).cGY;
    String str2 = ((com.tencent.mm.plugin.ipcall.a.a.c)localObject).nNB;
    int j = ((com.tencent.mm.plugin.ipcall.a.a.c)localObject).nMZ;
    long l1 = ((com.tencent.mm.plugin.ipcall.a.a.c)localObject).nNa;
    long l2 = ((com.tencent.mm.plugin.ipcall.a.a.c)localObject).nNb;
    localb.nNc = i;
    localb.nOv = str1;
    localb.gAF = str2;
    localb.nMZ = j;
    localb.nNa = l1;
    localb.nOt = l2;
    if (this.nLC != null) {
      this.nLC.bIG();
    }
    AppMethodBeat.o(21677);
  }
  
  public final void bIH()
  {
    AppMethodBeat.i(21679);
    ab.i("MicroMsg.IPCallManager", "onStartRing, currentState: %s", new Object[] { f.stateToString(i.bJr().mCurrentState) });
    if (!i.bJr().xF(4))
    {
      AppMethodBeat.o(21679);
      return;
    }
    com.tencent.mm.plugin.ipcall.a.c.b localb = i.bJp();
    ab.d("MicroMsg.IPCallReportHelper", "markStartRing");
    if (localb.nOx == 0L)
    {
      localb.nOx = System.currentTimeMillis();
      localb.nOo = (localb.nOx - localb.nOw);
      ab.d("MicroMsg.IPCallReportHelper", "ringTime: %d", new Object[] { Long.valueOf(localb.nOo) });
    }
    i.bJo().bJI();
    localb = i.bJp();
    ab.i("MicroMsg.IPCallReportHelper", "startRing");
    localb.nOj = 1;
    if (this.nLC != null) {
      this.nLC.bIH();
    }
    AppMethodBeat.o(21679);
  }
  
  public final void bII()
  {
    AppMethodBeat.i(21680);
    ab.i("MicroMsg.IPCallManager", "onAccept, currentState: %s", new Object[] { f.stateToString(i.bJr().mCurrentState) });
    if (!i.bJr().xF(5))
    {
      AppMethodBeat.o(21680);
      return;
    }
    com.tencent.mm.plugin.ipcall.a.c.b localb = i.bJp();
    ab.d("MicroMsg.IPCallReportHelper", "markUserAccept");
    if (localb.nLM == 0L)
    {
      localb.nLM = System.currentTimeMillis();
      localb.nOp = (localb.nLM - localb.nOw);
      ab.d("MicroMsg.IPCallReportHelper", "answerTime: %d", new Object[] { Long.valueOf(localb.nOp) });
    }
    i.bJo().bJI();
    localb = i.bJp();
    ab.i("MicroMsg.IPCallReportHelper", "userAccept");
    localb.nOk = 1;
    faV.removeCallbacks(this.nLI);
    i.bJx().stop();
    faV.removeCallbacks(this.nLJ);
    i.bJq().nNL.aCJ();
    if ((i.bJo().nOf) && (!this.nLE))
    {
      i.bJp().bJL();
      i.bJp().bJO();
      this.nLE = true;
      this.nLM = bo.aox();
      arF();
      i.bJo().bJH();
      if (this.nLC != null) {
        this.nLC.bIU();
      }
      i.bJp().bJN();
      q.cNr().cNs();
      q.cNr().a(this);
    }
    AppMethodBeat.o(21680);
  }
  
  public final void bIJ()
  {
    AppMethodBeat.i(21684);
    ab.i("MicroMsg.IPCallManager", "onShutdownByOtherSide, currentState: %s", new Object[] { f.stateToString(i.bJr().mCurrentState) });
    if (X(10, 0, 32))
    {
      if (this.nLC != null)
      {
        this.nLC.bIV();
        AppMethodBeat.o(21684);
        return;
      }
      Toast.makeText(ah.getContext(), ah.getContext().getString(2131300899), 1).show();
    }
    AppMethodBeat.o(21684);
  }
  
  public final void bIK()
  {
    AppMethodBeat.i(21686);
    ab.i("MicroMsg.IPCallManager", "onHeartbeatFailed");
    if (ex(7, 29)) {
      d(7, null, ah.getContext().getString(2131297829), 1);
    }
    AppMethodBeat.o(21686);
  }
  
  public final void bIL()
  {
    AppMethodBeat.i(21690);
    do
    {
      ab.i("MicroMsg.IPCallManager", "onDisasterHappen, currentState: %s", new Object[] { f.stateToString(i.bJr().mCurrentState) });
    } while (ex(12, 0));
    AppMethodBeat.o(21690);
  }
  
  public final void bIM()
  {
    AppMethodBeat.i(21691);
    ab.i("MicroMsg.IPCallManager", "onStartEngineFailed, currentState: %s", new Object[] { f.stateToString(i.bJr().mCurrentState) });
    if (ex(6, 0)) {
      d(6, null, ah.getContext().getString(2131297835), 1);
    }
    AppMethodBeat.o(21691);
  }
  
  public final void bIN()
  {
    AppMethodBeat.i(21692);
    ab.i("MicroMsg.IPCallManager", "onChannelConnected, currentState: %s", new Object[] { f.stateToString(i.bJr().mCurrentState) });
    i.bJx().stop();
    faV.removeCallbacks(this.nLJ);
    Object localObject;
    com.tencent.mm.plugin.ipcall.a.b.a locala;
    if (i.bJr().bJi())
    {
      localObject = i.bJq();
      ((com.tencent.mm.plugin.ipcall.a.b.b)localObject).kJT.a(ah.getContext(), (HeadsetPlugReceiver.a)localObject);
      aw.aaA().a((com.tencent.mm.compatible.b.g.a)localObject);
      aw.aaA().KE();
      ((com.tencent.mm.plugin.ipcall.a.b.b)localObject).kJU = aw.aaA().KN();
      ((com.tencent.mm.plugin.ipcall.a.b.b)localObject).kJV = aw.aaA().KH();
      ab.d("MicroMsg.IPCallDeviceManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.ipcall.a.b.b)localObject).kJU), Boolean.valueOf(((com.tencent.mm.plugin.ipcall.a.b.b)localObject).kJV) });
      ((com.tencent.mm.plugin.ipcall.a.b.b)localObject).gaP.requestFocus();
      locala = ((com.tencent.mm.plugin.ipcall.a.b.b)localObject).nNK;
      if (!locala.isStart) {
        break label384;
      }
      ab.d("MicroMsg.IPCallAudioPlayer", "startPlay, already start");
    }
    for (;;)
    {
      if ((((com.tencent.mm.plugin.ipcall.a.b.b)localObject).kJU) && (!((com.tencent.mm.plugin.ipcall.a.b.b)localObject).kJV) && (((com.tencent.mm.plugin.ipcall.a.b.b)localObject).nNP != null)) {
        ((com.tencent.mm.plugin.ipcall.a.b.b)localObject).nNP.iH(true);
      }
      if ((((com.tencent.mm.plugin.ipcall.a.b.b)localObject).kJV) && (!((com.tencent.mm.plugin.ipcall.a.b.b)localObject).kJU) && (((com.tencent.mm.plugin.ipcall.a.b.b)localObject).nNP != null)) {
        ((com.tencent.mm.plugin.ipcall.a.b.b)localObject).nNP.iI(true);
      }
      i.bJp().bJL();
      i.bJq().nNL.aCJ();
      if ((i.bJr().bJk()) && (!this.nLE))
      {
        i.bJp().bJO();
        i.bJo().bJH();
        this.nLE = true;
        this.nLM = bo.aox();
        arF();
        if (this.nLC != null) {
          this.nLC.bIU();
        }
        localObject = this.nLD;
        if (localObject != null)
        {
          ab.d("MicroMsg.IPCallRecordStorageLogic", "recordStartTalk, localId: %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.ipcall.a.g.k)localObject).systemRowid) });
          if (((com.tencent.mm.plugin.ipcall.a.g.k)localObject).systemRowid != -1L)
          {
            ((com.tencent.mm.plugin.ipcall.a.g.k)localObject).field_status = 3;
            i.bJu().a((com.tencent.mm.plugin.ipcall.a.g.k)localObject);
          }
        }
        i.bJp().bJN();
        q.cNr().cNs();
        q.cNr().a(this);
      }
      AppMethodBeat.o(21692);
      return;
      label384:
      ab.i("MicroMsg.IPCallAudioPlayer", "startPlay");
      if (locala.kJR == null)
      {
        locala.kJR = new com.tencent.mm.plugin.voip.model.c();
        locala.kJR.F(v2protocal.VOICE_SAMPLERATE, 1, 20, 1);
      }
      locala.nNG = locala.kJR.x(ah.getContext(), false);
      locala.kJR.ttu = new a.1(locala);
      if (locala.kJR.cLH() <= 0) {
        i.bJp().bJM();
      }
      locala.iE(locala.nNH);
      locala.isStart = true;
    }
  }
  
  public final void bIO()
  {
    AppMethodBeat.i(21696);
    if (i.bJr().mCurrentState != 5)
    {
      ab.i("MicroMsg.IPCallManager", "onResumeGoodNetStatus currentState != accept:%d", new Object[] { Integer.valueOf(i.bJr().mCurrentState) });
      AppMethodBeat.o(21696);
      return;
    }
    com.tencent.mm.plugin.ipcall.a.b.b localb = i.bJq();
    ab.i("MicroMsg.IPCallDeviceManager", "onResumeGoodNetStatus");
    if (localb.nNN != null) {
      localb.nNN.bKF();
    }
    AppMethodBeat.o(21696);
  }
  
  public final void bIP()
  {
    AppMethodBeat.i(21697);
    if (i.bJr().bJk()) {}
    for (Object localObject1 = ah.getContext().getString(2131300858, new Object[] { String.format("%02d:%02d", new Object[] { Long.valueOf(bo.gz(this.nLM) / 60L), Long.valueOf(bo.gz(this.nLM) % 60L) }) });; localObject1 = ah.getContext().getString(2131300857))
    {
      Object localObject2 = new Intent(ah.getContext(), IPCallTalkUI.class);
      ((Intent)localObject2).putExtra("IPCallTalkUI_isFromMiniNotification", true);
      localObject2 = PendingIntent.getActivity(ah.getContext(), 42, (Intent)localObject2, 134217728);
      int i = 2130839847;
      if (com.tencent.mm.compatible.util.d.fw(19)) {
        i = 2130839845;
      }
      localObject1 = com.tencent.mm.bp.a.br(ah.getContext(), "reminder_channel_id").h(ah.getContext().getString(2131300857)).g(System.currentTimeMillis()).e(ah.getContext().getString(2131300847)).f((CharSequence)localObject1);
      ((s.c)localObject1).ya = ((PendingIntent)localObject2);
      localObject1 = ((s.c)localObject1).build();
      ((Notification)localObject1).icon = i;
      ((Notification)localObject1).flags |= 0x20;
      aw.getNotification().a(42, (Notification)localObject1, false);
      if (i.bJr().bJk()) {
        break;
      }
      com.tencent.mm.plugin.voip.b.cLD().aeI(ah.getContext().getString(2131301716));
      AppMethodBeat.o(21697);
      return;
    }
    com.tencent.mm.plugin.voip.b.cLD().Ef(bIR());
    AppMethodBeat.o(21697);
  }
  
  public final void bIQ()
  {
    AppMethodBeat.i(21698);
    synchronized (this.iiG)
    {
      this.nLK = false;
      com.tencent.mm.plugin.voip.b.cLD().dismiss();
      ((NotificationManager)ah.getContext().getSystemService("notification")).cancel(42);
      AppMethodBeat.o(21698);
      return;
    }
  }
  
  public final int bIR()
  {
    AppMethodBeat.i(21699);
    int i = (int)bo.gz(this.nLM);
    if (i > 0)
    {
      AppMethodBeat.o(21699);
      return i;
    }
    AppMethodBeat.o(21699);
    return 0;
  }
  
  public final void cv(String paramString, int paramInt)
  {
    AppMethodBeat.i(21682);
    ab.i("MicroMsg.IPCallManager", "onUnAvaliable, currentState: %s", new Object[] { f.stateToString(i.bJr().mCurrentState) });
    if (ex(3, 5)) {
      d(3, null, paramString, paramInt);
    }
    AppMethodBeat.o(21682);
  }
  
  public final void cw(String paramString, int paramInt)
  {
    AppMethodBeat.i(21683);
    ab.i("MicroMsg.IPCallManager", "onBusy, currentState: %s", new Object[] { f.stateToString(i.bJr().mCurrentState) });
    if (ex(1, 4)) {
      d(1, null, paramString, paramInt);
    }
    AppMethodBeat.o(21683);
  }
  
  public final void cx(String paramString, int paramInt)
  {
    AppMethodBeat.i(21685);
    ab.i("MicroMsg.IPCallManager", "onSyncFailed");
    if (ex(7, 35)) {
      d(7, null, paramString, paramInt);
    }
    AppMethodBeat.o(21685);
  }
  
  public final void d(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    AppMethodBeat.i(21681);
    if (this.nLC != null)
    {
      this.nLC.d(paramInt1, paramString1, paramString2, paramInt2);
      AppMethodBeat.o(21681);
      return;
    }
    Toast.makeText(ah.getContext(), paramString2, 1).show();
    AppMethodBeat.o(21681);
  }
  
  public final boolean ex(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(21694);
    if (i.bJr().bJk())
    {
      if (paramInt1 == 0)
      {
        bool = X(9, paramInt1, paramInt2);
        AppMethodBeat.o(21694);
        return bool;
      }
      bool = X(11, paramInt1, paramInt2);
      AppMethodBeat.o(21694);
      return bool;
    }
    if (paramInt1 == 0)
    {
      bool = X(8, paramInt1, paramInt2);
      AppMethodBeat.o(21694);
      return bool;
    }
    boolean bool = X(12, paramInt1, paramInt2);
    AppMethodBeat.o(21694);
    return bool;
  }
  
  public final void iw(boolean paramBoolean)
  {
    AppMethodBeat.i(21695);
    if (i.bJr().mCurrentState != 5)
    {
      ab.i("MicroMsg.IPCallManager", "onBadNetStatus currentState != accept:%d", new Object[] { Integer.valueOf(i.bJr().mCurrentState) });
      AppMethodBeat.o(21695);
      return;
    }
    com.tencent.mm.plugin.ipcall.a.b.b localb = i.bJq();
    ab.i("MicroMsg.IPCallDeviceManager", "onBadNetStatus");
    if (localb.nNN != null)
    {
      j localj = localb.nNN;
      if (localj.nXc != null) {
        localj.nXc.setVisibility(0);
      }
      if (localj.nXd != null) {
        localj.nXd.setVisibility(0);
      }
    }
    if (!aw.aaA().elW.isSpeakerphoneOn())
    {
      long l = System.currentTimeMillis();
      if (l - localb.nNQ > 30000L)
      {
        localb.nNQ = l;
        com.tencent.mm.plugin.voip.b.cLC().tyR.cOl();
      }
    }
    AppMethodBeat.o(21695);
  }
  
  public final void xD(int paramInt)
  {
    AppMethodBeat.i(21693);
    ab.i("MicroMsg.IPCallManager", "onChannelConnectFailed, currentState: %s", new Object[] { f.stateToString(i.bJr().mCurrentState) });
    if (i.bJo().nOf)
    {
      ab.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel already connected");
      if (ex(5, paramInt))
      {
        d(5, null, ah.getContext().getString(2131297829), 1);
        AppMethodBeat.o(21693);
      }
    }
    else
    {
      ab.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel not connet, may be request connect failed");
      if (ex(4, paramInt)) {
        d(4, null, ah.getContext().getString(2131297829), 1);
      }
    }
    AppMethodBeat.o(21693);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.c
 * JD-Core Version:    0.7.0.1
 */