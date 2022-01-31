package com.tencent.mm.plugin.ipcall;

import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Looper;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.compatible.b.f.a;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.b.a.1;
import com.tencent.mm.plugin.ipcall.a.b.b.a;
import com.tencent.mm.plugin.ipcall.a.b.c.a;
import com.tencent.mm.plugin.ipcall.a.g.a;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.l;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.plugin.ipcall.ui.IPCallTalkUI;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver;
import com.tencent.mm.plugin.voip.HeadsetPlugReceiver.a;
import com.tencent.mm.plugin.voip.model.p;
import com.tencent.mm.plugin.voip.model.p.a;
import com.tencent.mm.plugin.voip.model.r;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.plugin.voip.video.i.7;
import com.tencent.mm.plugin.voip.video.i.8;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

public final class c
  implements com.tencent.mm.plugin.ipcall.a.c.a.a, g.a, p.a
{
  public static ah dPi = new ah(Looper.getMainLooper());
  private am byQ;
  public Object jYz = new Object();
  public e lof;
  public k loh;
  public boolean loi = false;
  public TelephonyManager loj;
  public PhoneStateListener lok = new c.1(this);
  public com.tencent.mm.sdk.b.c lol = new c.2(this);
  public Runnable lom = new c.3(this);
  public Runnable lon = new Runnable()
  {
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: iconst_1
      //   3: istore 4
      //   5: invokestatic 27	com/tencent/mm/plugin/ipcall/a/i:bcq	()Lcom/tencent/mm/plugin/voip/video/i;
      //   8: astore 6
      //   10: getstatic 33	com/tencent/mm/R$k:ipcall_phonering	I
      //   13: istore_2
      //   14: aload 6
      //   16: iconst_0
      //   17: putfield 38	com/tencent/mm/plugin/voip/video/i:qbC	I
      //   20: iload_2
      //   21: ifne +10 -> 31
      //   24: aload 6
      //   26: iconst_1
      //   27: invokevirtual 42	com/tencent/mm/plugin/voip/video/i:kh	(Z)V
      //   30: return
      //   31: ldc2_w 43
      //   34: ldc2_w 45
      //   37: lcmp
      //   38: ifeq +229 -> 267
      //   41: invokestatic 52	com/tencent/mm/kernel/g:DP	()Lcom/tencent/mm/kernel/e;
      //   44: invokevirtual 58	com/tencent/mm/kernel/e:Dz	()Lcom/tencent/mm/storage/z;
      //   47: ldc 59
      //   49: iconst_1
      //   50: invokestatic 65	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   53: invokevirtual 71	com/tencent/mm/storage/z:get	(ILjava/lang/Object;)Ljava/lang/Object;
      //   56: checkcast 61	java/lang/Boolean
      //   59: invokevirtual 75	java/lang/Boolean:booleanValue	()Z
      //   62: istore_3
      //   63: ldc 77
      //   65: ldc 79
      //   67: iconst_3
      //   68: anewarray 4	java/lang/Object
      //   71: dup
      //   72: iconst_0
      //   73: iload_3
      //   74: invokestatic 65	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   77: aastore
      //   78: dup
      //   79: iconst_1
      //   80: invokestatic 84	com/tencent/mm/m/a:zT	()Z
      //   83: invokestatic 65	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   86: aastore
      //   87: dup
      //   88: iconst_2
      //   89: iconst_1
      //   90: invokestatic 65	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   93: aastore
      //   94: invokestatic 90	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   97: iload 4
      //   99: istore_3
      //   100: iload_3
      //   101: ifeq -71 -> 30
      //   104: aload 6
      //   106: getfield 94	com/tencent/mm/plugin/voip/video/i:bus	Z
      //   109: ifne -79 -> 30
      //   112: aload 6
      //   114: invokestatic 100	java/lang/System:currentTimeMillis	()J
      //   117: putfield 104	com/tencent/mm/plugin/voip/video/i:qbD	J
      //   120: aload 6
      //   122: new 106	com/tencent/mm/compatible/b/j
      //   125: dup
      //   126: invokespecial 107	com/tencent/mm/compatible/b/j:<init>	()V
      //   129: putfield 111	com/tencent/mm/plugin/voip/video/i:qbB	Landroid/media/MediaPlayer;
      //   132: ldc 77
      //   134: ldc 113
      //   136: iconst_2
      //   137: anewarray 4	java/lang/Object
      //   140: dup
      //   141: iconst_0
      //   142: invokestatic 119	com/tencent/mm/compatible/b/f:yi	()Lcom/tencent/mm/compatible/b/f;
      //   145: invokevirtual 122	com/tencent/mm/compatible/b/f:yn	()Z
      //   148: invokestatic 65	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   151: aastore
      //   152: dup
      //   153: iconst_1
      //   154: invokestatic 119	com/tencent/mm/compatible/b/f:yi	()Lcom/tencent/mm/compatible/b/f;
      //   157: invokevirtual 125	com/tencent/mm/compatible/b/f:yt	()Z
      //   160: invokestatic 65	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   163: aastore
      //   164: invokestatic 128	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   167: getstatic 134	com/tencent/mm/compatible/e/q:dye	Lcom/tencent/mm/compatible/e/b;
      //   170: getfield 139	com/tencent/mm/compatible/e/b:dvt	I
      //   173: iflt +10 -> 183
      //   176: getstatic 134	com/tencent/mm/compatible/e/q:dye	Lcom/tencent/mm/compatible/e/b;
      //   179: getfield 139	com/tencent/mm/compatible/e/b:dvt	I
      //   182: istore_1
      //   183: aload 6
      //   185: iconst_0
      //   186: invokevirtual 142	com/tencent/mm/plugin/voip/video/i:kg	(Z)V
      //   189: aload 6
      //   191: iload_2
      //   192: ldc2_w 43
      //   195: iconst_1
      //   196: iload_1
      //   197: invokevirtual 146	com/tencent/mm/plugin/voip/video/i:a	(IJZI)V
      //   200: aload 6
      //   202: iconst_1
      //   203: putfield 94	com/tencent/mm/plugin/voip/video/i:bus	Z
      //   206: return
      //   207: astore 5
      //   209: ldc 77
      //   211: new 148	java/lang/StringBuilder
      //   214: dup
      //   215: ldc 150
      //   217: invokespecial 153	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   220: aload 5
      //   222: invokevirtual 157	java/lang/Exception:toString	()Ljava/lang/String;
      //   225: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   228: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   231: invokestatic 166	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   234: return
      //   235: astore 5
      //   237: iconst_1
      //   238: istore_3
      //   239: ldc 77
      //   241: new 148	java/lang/StringBuilder
      //   244: dup
      //   245: ldc 168
      //   247: invokespecial 153	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   250: aload 5
      //   252: invokevirtual 171	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   255: invokevirtual 161	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   258: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   261: invokestatic 166	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   264: goto -164 -> 100
      //   267: aload 6
      //   269: iload_2
      //   270: iconst_2
      //   271: iconst_1
      //   272: invokevirtual 175	com/tencent/mm/plugin/voip/video/i:m	(IIZ)V
      //   275: return
      //   276: astore 5
      //   278: goto -39 -> 239
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	281	0	this	4
      //   1	196	1	i	int
      //   13	257	2	j	int
      //   62	177	3	bool1	boolean
      //   3	95	4	bool2	boolean
      //   207	14	5	localException1	java.lang.Exception
      //   235	16	5	localException2	java.lang.Exception
      //   276	1	5	localException3	java.lang.Exception
      //   8	260	6	locali	com.tencent.mm.plugin.voip.video.i
      // Exception table:
      //   from	to	target	type
      //   112	167	207	java/lang/Exception
      //   167	183	207	java/lang/Exception
      //   183	206	207	java/lang/Exception
      //   41	63	235	java/lang/Exception
      //   63	97	276	java/lang/Exception
    }
  };
  public boolean loo;
  public com.tencent.mm.plugin.voip.ui.a lop = new c.5(this);
  private long loq = 0L;
  
  public static boolean Fw(String paramString)
  {
    y.d("MicroMsg.IPCallManager", "dialWhenTalking, dialButton: %s", new Object[] { paramString });
    if (!com.tencent.mm.plugin.ipcall.a.i.bck().bcd()) {
      y.i("MicroMsg.IPCallManager", "ipcall not connect, cannot call dialWhenTalking now");
    }
    for (;;)
    {
      return false;
      if ((!bk.bl(paramString)) && (paramString.length() == 1))
      {
        int i;
        if ((!bk.bl(paramString)) && (paramString.length() == 1))
        {
          i = paramString.charAt(0);
          if ((i >= 48) && (i <= 57)) {
            i -= 48;
          }
        }
        while (i != -1)
        {
          paramString = com.tencent.mm.plugin.ipcall.a.i.bch();
          y.d("MicroMsg.IPCallEngineManager", "sendDTMF: %d", new Object[] { Integer.valueOf(i) });
          com.tencent.mm.plugin.ipcall.a.c.b localb = com.tencent.mm.plugin.ipcall.a.i.bci();
          localb.lrn += 1;
          y.i("MicroMsg.IPCallReportHelper", "now addCallClickCnt %d", new Object[] { Integer.valueOf(localb.lrn) });
          i = paramString.lqG.SendDTMF(i);
          if (i < 0) {
            y.i("MicroMsg.IPCallEngineManager", "sendDTMF failed, ret: %d", new Object[] { Integer.valueOf(i) });
          }
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
    }
  }
  
  private boolean L(int paramInt1, int paramInt2, int paramInt3)
  {
    ??? = com.tencent.mm.plugin.ipcall.a.i.bcg().loW;
    if (!com.tencent.mm.plugin.ipcall.a.i.bck().sF(paramInt1))
    {
      y.i("MicroMsg.IPCallManager", "finishIPCall, cannot finish now, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.a.f.stateToString(com.tencent.mm.plugin.ipcall.a.i.bck().mCurrentState) });
      if (??? != null) {
        y.i("MicroMsg.IPCallManager", "finishIPCall, cannot finish now inviteId:%d, roomId:%d, state:%d,errStatus:%d, pstnErrCode:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.a.c)???).lpG), Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.a.c)???).lpD), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
      }
      return false;
    }
    if (??? != null) {
      y.i("MicroMsg.IPCallManager", "finishIPCall inviteId:%d, roomId:%d, state:%d, errStatus:%d, pstnErrCode:%d", new Object[] { Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.a.c)???).lpG), Integer.valueOf(((com.tencent.mm.plugin.ipcall.a.a.c)???).lpD), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3) });
    }
    y.i("MicroMsg.IPCallManager", "closeDeviceEngine");
    p.bQU().bQW();
    p.bQU().pTc = null;
    ??? = com.tencent.mm.plugin.ipcall.a.i.bci();
    ??? = com.tencent.mm.plugin.ipcall.a.i.bcj();
    label312:
    Object localObject6;
    if (((com.tencent.mm.plugin.ipcall.a.b.b)???).lqp != null)
    {
      ??? = ((com.tencent.mm.plugin.ipcall.a.b.b)???).lqp;
      if (((com.tencent.mm.plugin.ipcall.a.b.c)???).lqv != null)
      {
        i = ((com.tencent.mm.plugin.ipcall.a.b.c)???).lqv.bCt;
        if (((com.tencent.mm.plugin.ipcall.a.c.b)???).lrk == 0) {
          ((com.tencent.mm.plugin.ipcall.a.c.b)???).lrk = i;
        }
        ??? = com.tencent.mm.plugin.ipcall.a.i.bci();
        ??? = com.tencent.mm.plugin.ipcall.a.i.bcj();
        if (((com.tencent.mm.plugin.ipcall.a.b.b)???).lqo == null) {
          break label1735;
        }
        ??? = ((com.tencent.mm.plugin.ipcall.a.b.b)???).lqo;
        if (((com.tencent.mm.plugin.ipcall.a.b.a)???).iEF == null) {
          break label1729;
        }
        y.d("MicroMsg.IPCallAudioPlayer", "AudioPlayer  mAudioPlayErrState:" + ((com.tencent.mm.plugin.ipcall.a.b.a)???).iEF.bPG());
        i = ((com.tencent.mm.plugin.ipcall.a.b.a)???).iEF.bPG();
        if (((com.tencent.mm.plugin.ipcall.a.c.b)???).lrl == 0) {
          ((com.tencent.mm.plugin.ipcall.a.c.b)???).lrl = i;
        }
        ??? = com.tencent.mm.plugin.ipcall.a.i.bcj();
        ??? = com.tencent.mm.plugin.ipcall.a.i.bch();
        i = 0;
        if (((com.tencent.mm.plugin.ipcall.a.b.b)???).lqo != null)
        {
          localObject6 = ((com.tencent.mm.plugin.ipcall.a.b.b)???).lqo;
          if ((((com.tencent.mm.plugin.ipcall.a.b.a)localObject6).iEF == null) || (!((com.tencent.mm.plugin.ipcall.a.b.a)localObject6).bSr)) {
            break label1741;
          }
          i = ((com.tencent.mm.plugin.ipcall.a.b.a)localObject6).iEF.bPH();
        }
        label381:
        if (i != -1) {
          break label1747;
        }
        i = 0;
        label390:
        ((com.tencent.mm.plugin.ipcall.a.c.a)???).lqG.pVa = i;
        ((com.tencent.mm.plugin.ipcall.a.b.b)???).eLi.zE();
        localObject6 = ((com.tencent.mm.plugin.ipcall.a.b.b)???).lqo;
        if (((com.tencent.mm.plugin.ipcall.a.b.a)localObject6).bSr) {
          y.i("MicroMsg.IPCallAudioPlayer", "stopPlay");
        }
        synchronized (((com.tencent.mm.plugin.ipcall.a.b.a)localObject6).lqj)
        {
          com.tencent.mm.sdk.f.e.post(new com.tencent.mm.plugin.ipcall.a.b.a.a((com.tencent.mm.plugin.ipcall.a.b.a)localObject6, ((com.tencent.mm.plugin.ipcall.a.b.a)localObject6).iEF), "IPCallAudioPlayer_stop");
          ((com.tencent.mm.plugin.ipcall.a.b.a)localObject6).bSr = false;
          ((com.tencent.mm.plugin.ipcall.a.b.a)localObject6).iEF = null;
          ((com.tencent.mm.plugin.ipcall.a.b.b)???).bER = null;
          ((com.tencent.mm.plugin.ipcall.a.b.b)???).iEH.ek(ae.getContext());
          au.Hy().yl();
          au.Hy().b((f.a)???);
          ((com.tencent.mm.plugin.ipcall.a.b.b)???).lqt = null;
          ((com.tencent.mm.plugin.ipcall.a.b.b)???).lqr = null;
          ??? = com.tencent.mm.plugin.ipcall.a.i.bcj();
          localObject6 = ((com.tencent.mm.plugin.ipcall.a.b.b)???).lqp;
          if (((com.tencent.mm.plugin.ipcall.a.b.c)localObject6).bSr) {
            y.i("MicroMsg.IPCallRecorder", "stop record");
          }
        }
      }
    }
    for (;;)
    {
      synchronized (((com.tencent.mm.plugin.ipcall.a.b.c)localObject6).lqw)
      {
        if (((com.tencent.mm.plugin.ipcall.a.b.c)localObject6).lqv != null)
        {
          com.tencent.mm.sdk.f.e.post(new c.a((com.tencent.mm.plugin.ipcall.a.b.c)localObject6, ((com.tencent.mm.plugin.ipcall.a.b.c)localObject6).lqv), "IPCallRecorder_stopRecord");
          ((com.tencent.mm.plugin.ipcall.a.b.c)localObject6).lqv = null;
          ((com.tencent.mm.plugin.ipcall.a.b.c)localObject6).bSr = false;
          ((com.tencent.mm.plugin.ipcall.a.b.c)localObject6).dnJ = false;
        }
        ((com.tencent.mm.plugin.ipcall.a.b.b)???).bER = null;
        ??? = com.tencent.mm.plugin.ipcall.a.i.bch();
        y.i("MicroMsg.IPCallEngineManager", "close engine");
        ((com.tencent.mm.plugin.ipcall.a.c.a)???).lqG.kb(true);
        ??? = com.tencent.mm.plugin.ipcall.a.i.bci();
        boolean bool;
        if ((bk.bl(((com.tencent.mm.plugin.ipcall.a.c.b)???).lrf)) && (bk.bl(((com.tencent.mm.plugin.ipcall.a.c.b)???).lre)))
        {
          Object localObject7 = com.tencent.mm.plugin.ipcall.a.i.bcg().loW;
          localObject6 = com.tencent.mm.plugin.ipcall.a.i.bch().lqG;
          if (((com.tencent.mm.plugin.ipcall.a.c.b)???).lqU == 1)
          {
            i = 1;
            int j = ((com.tencent.mm.plugin.ipcall.a.a.c)localObject7).lpZ;
            localObject7 = ((v2protocal)localObject6).pWe;
            int k = ((v2protocal)localObject6).pWe.length;
            if (i == 0) {
              break label1802;
            }
            i = 1;
            ((v2protocal)localObject6).getPstnChannelInfo((byte[])localObject7, k, i, j);
            y.d("MicroMsg.Voip", "field_pstnChannelInfoLength: %d", new Object[] { Integer.valueOf(((v2protocal)localObject6).field_pstnChannelInfoLength) });
            ((com.tencent.mm.plugin.ipcall.a.c.b)???).lrf = new String(((v2protocal)localObject6).pWe, 0, ((v2protocal)localObject6).field_pstnChannelInfoLength);
            localObject6 = com.tencent.mm.plugin.ipcall.a.i.bch().lqG;
            ((v2protocal)localObject6).getPstnEngineInfo(((v2protocal)localObject6).pWf, ((v2protocal)localObject6).pWf.length);
            y.d("MicroMsg.Voip", "field_pstnEngineInfoLength: %d", new Object[] { Integer.valueOf(((v2protocal)localObject6).field_pstnEngineInfoLength) });
            ((com.tencent.mm.plugin.ipcall.a.c.b)???).lre = new String(((v2protocal)localObject6).pWf, 0, ((v2protocal)localObject6).field_pstnEngineInfoLength);
            localObject6 = com.tencent.mm.plugin.ipcall.a.i.bch().lqG;
            i = v2protocal.cpuFlag0;
            ((com.tencent.mm.plugin.ipcall.a.c.b)???).lrg = (v2protocal.bRE() + "," + ((v2protocal)localObject6).pVb + "," + (i & 0xFF) + ((v2protocal)localObject6).bRJ() + "," + ((v2protocal)localObject6).pVa);
            y.d("MicroMsg.IPCallReportHelper", "nativeChannelReportString: %s", new Object[] { ((com.tencent.mm.plugin.ipcall.a.c.b)???).lrf });
            y.d("MicroMsg.IPCallReportHelper", "nativeEngineReportString: %s", new Object[] { ((com.tencent.mm.plugin.ipcall.a.c.b)???).lre });
            y.d("MicroMsg.IPCallReportHelper", "clientReportExString: %s", new Object[] { ((com.tencent.mm.plugin.ipcall.a.c.b)???).lrg });
          }
        }
        else
        {
          ((com.tencent.mm.plugin.ipcall.a.c.a)???).lqG.reset();
          ((com.tencent.mm.plugin.ipcall.a.c.a)???).bcB();
          com.tencent.mm.plugin.ipcall.a.i.bcq().stop();
          ??? = com.tencent.mm.plugin.ipcall.a.i.bcq();
          i = R.k.playend;
          com.tencent.mm.plugin.ipcall.a.i.bcj();
          bool = au.Hy().dui.isSpeakerphoneOn();
          ((com.tencent.mm.plugin.voip.video.i)???).mContext.getSharedPreferences(ae.cqR(), 0).getBoolean("settings_shake", true);
          com.tencent.mm.compatible.b.f.yi().setSpeakerphoneOn(bool);
          if (!bool) {
            break label1808;
          }
          com.tencent.mm.compatible.b.f.yi().setMode(0);
          y.i("MicroMsg.RingPlayer", "playSound, shake: %s, isSpeakerOn: %s, type: %s", new Object[] { Boolean.valueOf(false), Boolean.valueOf(bool), Integer.valueOf(2) });
          ((com.tencent.mm.plugin.voip.video.i)???).qbE = System.currentTimeMillis();
          ??? = new com.tencent.mm.compatible.b.j();
        }
        try
        {
          ((MediaPlayer)???).setDataSource(((com.tencent.mm.plugin.voip.video.i)???).mContext, Uri.parse("android.resource://" + ((com.tencent.mm.plugin.voip.video.i)???).mContext.getPackageName() + "/" + i));
          ((MediaPlayer)???).setOnCompletionListener(new i.7((com.tencent.mm.plugin.voip.video.i)???));
          ((MediaPlayer)???).setOnErrorListener(new i.8((com.tencent.mm.plugin.voip.video.i)???));
          if (com.tencent.mm.compatible.b.f.yi().yn()) {
            break label2324;
          }
          if (bool) {
            break label1818;
          }
        }
        catch (Throwable localThrowable)
        {
          long l2;
          long l3;
          float f;
          y.w("MicroMsg.RingPlayer", "playSound Failed Throwable t = ", new Object[] { localThrowable });
          localObject2.qbC = 6;
          localObject5.stop();
          localObject5.release();
          continue;
          if (paramInt1 != 12) {
            break label1964;
          }
          com.tencent.mm.plugin.ipcall.a.i.bcg().bce();
          com.tencent.mm.plugin.ipcall.a.i.bci().bcD();
          if (paramInt2 != 11) {
            break label1899;
          }
          m.b(this.loh);
          continue;
          Object localObject3 = this.loh;
          if (localObject3 == null) {
            continue;
          }
          y.d("MicroMsg.IPCallRecordStorageLogic", "recordCallFailed, localId: %d", new Object[] { Long.valueOf(((k)localObject3).ujK) });
          if (((k)localObject3).ujK == -1L) {
            continue;
          }
          ((k)localObject3).field_status = 6;
          com.tencent.mm.plugin.ipcall.a.i.bcn().a((k)localObject3);
          continue;
          if (paramInt1 != 9) {
            break label2000;
          }
          com.tencent.mm.plugin.ipcall.a.i.bcg().sG(1);
          com.tencent.mm.plugin.ipcall.a.i.bci().bcC();
          m.a(this.loh, com.tencent.mm.plugin.ipcall.a.i.bci().lqV);
          continue;
          if (paramInt1 != 10) {
            break label2119;
          }
          com.tencent.mm.plugin.ipcall.a.i.bcg().sG(1);
          localObject3 = com.tencent.mm.plugin.ipcall.a.i.bci();
          y.i("MicroMsg.IPCallReportHelper", "otherSideUserShutdown");
          ((com.tencent.mm.plugin.ipcall.a.c.b)localObject3).lqP = 1;
          localObject3 = this.loh;
          long l1 = com.tencent.mm.plugin.ipcall.a.i.bci().lqV;
          if (localObject3 == null) {
            continue;
          }
          y.d("MicroMsg.IPCallRecordStorageLogic", "recordOthersideShutdownCall, localId: %d, talkTime: %d", new Object[] { Long.valueOf(((k)localObject3).ujK), Long.valueOf(l1) });
          if (((k)localObject3).ujK == -1L) {
            continue;
          }
          ((k)localObject3).field_status = 5;
          ((k)localObject3).field_duration = l1;
          com.tencent.mm.plugin.ipcall.a.i.bcn().a((k)localObject3);
          continue;
          if (paramInt1 != 11) {
            continue;
          }
          if (paramInt2 != 5) {
            break label2160;
          }
          com.tencent.mm.plugin.ipcall.a.i.bcg().sG(3);
          for (;;)
          {
            com.tencent.mm.plugin.ipcall.a.i.bci().bcC();
            if (paramInt2 != 11) {
              break label2186;
            }
            m.b(this.loh);
            break;
            if (paramInt2 == 11) {
              com.tencent.mm.plugin.ipcall.a.i.bcg().sG(1);
            } else {
              com.tencent.mm.plugin.ipcall.a.i.bcg().sG(2);
            }
          }
          m.a(this.loh, com.tencent.mm.plugin.ipcall.a.i.bci().lqV);
          continue;
          if (l3 - l2 >= 1800L) {
            break label2227;
          }
          y.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog not reach INTERVAL_TIMES_TRY_SHOW_WCO_FEEDBACK_MAIN");
          continue;
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uqE, Integer.valueOf(paramInt1 + 1));
          au.Hx();
          com.tencent.mm.model.c.Dz().c(ac.a.uqD, Long.valueOf(l3));
          Intent localIntent = new Intent();
          localIntent.putExtra("IPCallFeedbackDialogUI_KRoomId", paramInt2);
          localIntent.putExtra("IPCallFeedbackDialogUI_KCallseq", l1);
          com.tencent.mm.br.d.b((Context)localObject3, "ipcall", ".ui.IPCallFeedbackDialogUI", localIntent);
          continue;
          y.e("MicroMsg.IPCallManager", "roomId = 0,ignore feedback");
          continue;
          continue;
          i = 0;
          continue;
        }
        ((MediaPlayer)???).setAudioStreamType(i);
        ((MediaPlayer)???).prepare();
        ((MediaPlayer)???).setLooping(false);
        ((MediaPlayer)???).start();
        if (System.currentTimeMillis() - ((com.tencent.mm.plugin.voip.video.i)???).qbE > 2000L) {
          ((com.tencent.mm.plugin.voip.video.i)???).qbC = 7;
        }
        dPi.removeCallbacks(this.lon);
        dPi.removeCallbacks(this.lom);
        if (this.byQ != null)
        {
          this.byQ.stopTimer();
          this.byQ = null;
        }
        com.tencent.mm.plugin.ipcall.a.i.bci().lqW = paramInt3;
        ??? = com.tencent.mm.plugin.ipcall.a.i.bci();
        y.d("MicroMsg.IPCallReportHelper", "markEndTalk");
        if ((((com.tencent.mm.plugin.ipcall.a.c.b)???).lrd == 0L) && (((com.tencent.mm.plugin.ipcall.a.c.b)???).lrc != 0L))
        {
          ((com.tencent.mm.plugin.ipcall.a.c.b)???).lrd = System.currentTimeMillis();
          ((com.tencent.mm.plugin.ipcall.a.c.b)???).lqV = ((((com.tencent.mm.plugin.ipcall.a.c.b)???).lrd - ((com.tencent.mm.plugin.ipcall.a.c.b)???).lrc) / 1000L);
          y.d("MicroMsg.IPCallReportHelper", "callTime: %d", new Object[] { Long.valueOf(((com.tencent.mm.plugin.ipcall.a.c.b)???).lqV) });
        }
        if (paramInt1 != 8) {
          break label1864;
        }
        com.tencent.mm.plugin.ipcall.a.i.bcg().bce();
        com.tencent.mm.plugin.ipcall.a.i.bci().bcD();
        ??? = this.loh;
        if (??? != null)
        {
          y.d("MicroMsg.IPCallRecordStorageLogic", "recordCancelCall, localId: %d", new Object[] { Long.valueOf(((k)???).ujK) });
          if (((k)???).ujK != -1L)
          {
            ((k)???).field_status = 2;
            com.tencent.mm.plugin.ipcall.a.i.bcn().a((k)???);
          }
        }
        if (com.tencent.mm.plugin.ipcall.a.i.bcg().bWb)
        {
          if ((this.loo) || (com.tencent.mm.plugin.ipcall.a.i.bcg().loW.lpD == 0) || (com.tencent.mm.plugin.ipcall.a.i.bcg().loW.lpF == 0L)) {
            break label2310;
          }
          ??? = ae.getContext();
          paramInt2 = com.tencent.mm.plugin.ipcall.a.i.bcg().loW.lpD;
          l1 = com.tencent.mm.plugin.ipcall.a.i.bcg().loW.lpF;
          y.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog");
          if (d.bbM())
          {
            paramInt3 = com.tencent.mm.m.g.AA().getInt("WCOMaxTimesForShowFeedback", 0);
            au.Hx();
            paramInt1 = ((Integer)com.tencent.mm.model.c.Dz().get(ac.a.uqE, Integer.valueOf(0))).intValue();
            au.Hx();
            l2 = ((Long)com.tencent.mm.model.c.Dz().get(ac.a.uqD, Long.valueOf(0L))).longValue();
            l3 = bk.UX();
            if (l3 - l2 <= 86400L) {
              break label2321;
            }
            paramInt1 = 0;
            y.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog reset time");
            if (paramInt1 < paramInt3) {
              break label2203;
            }
            y.i("MicroMsg.IPCallPluginUtil", "tryShowFeedbackDialog reach max time" + paramInt3);
          }
        }
        com.tencent.mm.plugin.ipcall.a.i.bcg().loN = null;
        com.tencent.mm.plugin.ipcall.a.i.bch().lqL = null;
        com.tencent.mm.plugin.ipcall.a.i.bck().mCurrentState = -1;
        bbJ();
        ch();
        return true;
        i = 0;
        break;
        i = 0;
        break;
        label1729:
        i = 0;
        break label312;
        label1735:
        i = 0;
        break label312;
        label1741:
        i = -1;
        break label381;
        label1747:
        f = au.Hy().getStreamMaxVolume(i);
        i = (int)(au.Hy().getStreamVolume(i) / f * 100.0F);
        break label390;
        localObject2 = finally;
        throw localObject2;
      }
      i = 0;
      continue;
      label1802:
      i = 0;
      continue;
      label1808:
      com.tencent.mm.compatible.b.f.yi().setMode(2);
      continue;
      label1818:
      i = 2;
    }
  }
  
  private void XW()
  {
    y.i("MicroMsg.IPCallManager", "startTimeCount");
    if (this.byQ != null)
    {
      this.byQ.stopTimer();
      return;
    }
    if (this.byQ == null) {
      this.byQ = new am(Looper.getMainLooper(), new c.6(this), true);
    }
    this.byQ.S(1000L, 1000L);
  }
  
  public final void A(String paramString1, String paramString2, int paramInt)
  {
    y.i("MicroMsg.IPCallManager", "onCallRestricted, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.a.f.stateToString(com.tencent.mm.plugin.ipcall.a.i.bck().mCurrentState) });
    if (da(10, 0)) {
      d(10, paramString1, paramString2, paramInt);
    }
  }
  
  public final void B(String paramString1, String paramString2, int paramInt)
  {
    y.i("MicroMsg.IPCallManager", "onCallPhoneNumberInvalid, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.a.f.stateToString(com.tencent.mm.plugin.ipcall.a.i.bck().mCurrentState) });
    if (da(11, 0)) {
      d(11, paramString1, paramString2, paramInt);
    }
  }
  
  public final void bI(String paramString, int paramInt)
  {
    y.i("MicroMsg.IPCallManager", "onUnAvaliable, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.a.f.stateToString(com.tencent.mm.plugin.ipcall.a.i.bck().mCurrentState) });
    if (da(3, 5)) {
      d(3, null, paramString, paramInt);
    }
  }
  
  public final void bJ(String paramString, int paramInt)
  {
    y.i("MicroMsg.IPCallManager", "onBusy, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.a.f.stateToString(com.tencent.mm.plugin.ipcall.a.i.bck().mCurrentState) });
    if (da(1, 4)) {
      d(1, null, paramString, paramInt);
    }
  }
  
  public final void bK(String paramString, int paramInt)
  {
    y.i("MicroMsg.IPCallManager", "onSyncFailed");
    if (da(7, 35)) {
      d(7, null, paramString, paramInt);
    }
  }
  
  public final void bbA()
  {
    y.i("MicroMsg.IPCallManager", "onAccept, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.a.f.stateToString(com.tencent.mm.plugin.ipcall.a.i.bck().mCurrentState) });
    if (!com.tencent.mm.plugin.ipcall.a.i.bck().sF(5)) {}
    do
    {
      return;
      com.tencent.mm.plugin.ipcall.a.c.b localb = com.tencent.mm.plugin.ipcall.a.i.bci();
      y.d("MicroMsg.IPCallReportHelper", "markUserAccept");
      if (localb.loq == 0L)
      {
        localb.loq = System.currentTimeMillis();
        localb.lqT = (localb.loq - localb.lra);
        y.d("MicroMsg.IPCallReportHelper", "answerTime: %d", new Object[] { Long.valueOf(localb.lqT) });
      }
      com.tencent.mm.plugin.ipcall.a.i.bch().bcA();
      localb = com.tencent.mm.plugin.ipcall.a.i.bci();
      y.i("MicroMsg.IPCallReportHelper", "userAccept");
      localb.lqO = 1;
      dPi.removeCallbacks(this.lom);
      com.tencent.mm.plugin.ipcall.a.i.bcq().stop();
      dPi.removeCallbacks(this.lon);
      com.tencent.mm.plugin.ipcall.a.i.bcj().startRecord();
    } while ((!com.tencent.mm.plugin.ipcall.a.i.bch().lqJ) || (this.loi));
    com.tencent.mm.plugin.ipcall.a.i.bci().bcE();
    com.tencent.mm.plugin.ipcall.a.i.bci().bcH();
    this.loi = true;
    this.loq = bk.UX();
    XW();
    com.tencent.mm.plugin.ipcall.a.i.bch().bcz();
    if (this.lof != null) {
      this.lof.bbN();
    }
    com.tencent.mm.plugin.ipcall.a.i.bci().bcG();
    p.bQU().bQV();
    p.bQU().pTc = this;
  }
  
  public final void bbB()
  {
    y.i("MicroMsg.IPCallManager", "onShutdownByOtherSide, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.a.f.stateToString(com.tencent.mm.plugin.ipcall.a.i.bck().mCurrentState) });
    if (L(10, 0, 32))
    {
      if (this.lof != null) {
        this.lof.bbO();
      }
    }
    else {
      return;
    }
    Toast.makeText(ae.getContext(), ae.getContext().getString(R.l.ip_call_status_other_side_shutdown), 1).show();
  }
  
  public final void bbC()
  {
    y.i("MicroMsg.IPCallManager", "onHeartbeatFailed");
    if (da(7, 29)) {
      d(7, null, ae.getContext().getString(R.l.calling_failed_network), 1);
    }
  }
  
  public final void bbD()
  {
    do
    {
      y.i("MicroMsg.IPCallManager", "onDisasterHappen, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.a.f.stateToString(com.tencent.mm.plugin.ipcall.a.i.bck().mCurrentState) });
    } while (da(12, 0));
  }
  
  public final void bbE()
  {
    y.i("MicroMsg.IPCallManager", "onStartEngineFailed, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.a.f.stateToString(com.tencent.mm.plugin.ipcall.a.i.bck().mCurrentState) });
    if (da(6, 0)) {
      d(6, null, ae.getContext().getString(R.l.callout_failed_network), 1);
    }
  }
  
  public final void bbF()
  {
    y.i("MicroMsg.IPCallManager", "onChannelConnected, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.a.f.stateToString(com.tencent.mm.plugin.ipcall.a.i.bck().mCurrentState) });
    com.tencent.mm.plugin.ipcall.a.i.bcq().stop();
    dPi.removeCallbacks(this.lon);
    Object localObject;
    com.tencent.mm.plugin.ipcall.a.b.a locala;
    if (com.tencent.mm.plugin.ipcall.a.i.bck().bcb())
    {
      localObject = com.tencent.mm.plugin.ipcall.a.i.bcj();
      ((com.tencent.mm.plugin.ipcall.a.b.b)localObject).iEH.a(ae.getContext(), (HeadsetPlugReceiver.a)localObject);
      au.Hy().a((f.a)localObject);
      au.Hy().yk();
      ((com.tencent.mm.plugin.ipcall.a.b.b)localObject).iEI = au.Hy().yt();
      ((com.tencent.mm.plugin.ipcall.a.b.b)localObject).iEJ = au.Hy().yn();
      y.d("MicroMsg.IPCallDeviceManager", "startPlay, isHeadsetPlugged: %b, isBluetoothConnected: %b", new Object[] { Boolean.valueOf(((com.tencent.mm.plugin.ipcall.a.b.b)localObject).iEI), Boolean.valueOf(((com.tencent.mm.plugin.ipcall.a.b.b)localObject).iEJ) });
      ((com.tencent.mm.plugin.ipcall.a.b.b)localObject).eLi.requestFocus();
      locala = ((com.tencent.mm.plugin.ipcall.a.b.b)localObject).lqo;
      if (!locala.bSr) {
        break label369;
      }
      y.d("MicroMsg.IPCallAudioPlayer", "startPlay, already start");
    }
    for (;;)
    {
      if ((((com.tencent.mm.plugin.ipcall.a.b.b)localObject).iEI) && (!((com.tencent.mm.plugin.ipcall.a.b.b)localObject).iEJ) && (((com.tencent.mm.plugin.ipcall.a.b.b)localObject).lqt != null)) {
        ((com.tencent.mm.plugin.ipcall.a.b.b)localObject).lqt.gX(true);
      }
      if ((((com.tencent.mm.plugin.ipcall.a.b.b)localObject).iEJ) && (!((com.tencent.mm.plugin.ipcall.a.b.b)localObject).iEI) && (((com.tencent.mm.plugin.ipcall.a.b.b)localObject).lqt != null)) {
        ((com.tencent.mm.plugin.ipcall.a.b.b)localObject).lqt.gY(true);
      }
      com.tencent.mm.plugin.ipcall.a.i.bci().bcE();
      com.tencent.mm.plugin.ipcall.a.i.bcj().startRecord();
      if ((com.tencent.mm.plugin.ipcall.a.i.bck().bcd()) && (!this.loi))
      {
        com.tencent.mm.plugin.ipcall.a.i.bci().bcH();
        com.tencent.mm.plugin.ipcall.a.i.bch().bcz();
        this.loi = true;
        this.loq = bk.UX();
        XW();
        if (this.lof != null) {
          this.lof.bbN();
        }
        localObject = this.loh;
        if (localObject != null)
        {
          y.d("MicroMsg.IPCallRecordStorageLogic", "recordStartTalk, localId: %d", new Object[] { Long.valueOf(((k)localObject).ujK) });
          if (((k)localObject).ujK != -1L)
          {
            ((k)localObject).field_status = 3;
            com.tencent.mm.plugin.ipcall.a.i.bcn().a((k)localObject);
          }
        }
        com.tencent.mm.plugin.ipcall.a.i.bci().bcG();
        p.bQU().bQV();
        p.bQU().pTc = this;
      }
      return;
      label369:
      y.i("MicroMsg.IPCallAudioPlayer", "startPlay");
      if (locala.iEF == null)
      {
        locala.iEF = new com.tencent.mm.plugin.voip.model.b();
        locala.iEF.z(v2protocal.VOICE_SAMPLERATE, 1, 20, 1);
      }
      locala.lqk = locala.iEF.t(ae.getContext(), false);
      locala.iEF.pNy = new a.1(locala);
      if (locala.iEF.bPD() <= 0) {
        com.tencent.mm.plugin.ipcall.a.i.bci().bcF();
      }
      locala.gV(locala.lql);
      locala.bSr = true;
    }
  }
  
  public final void bbG()
  {
    if (com.tencent.mm.plugin.ipcall.a.i.bck().mCurrentState != 5) {
      y.i("MicroMsg.IPCallManager", "onBadNetStatus currentState != accept:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.ipcall.a.i.bck().mCurrentState) });
    }
    com.tencent.mm.plugin.ipcall.a.b.b localb;
    long l;
    do
    {
      do
      {
        return;
        localb = com.tencent.mm.plugin.ipcall.a.i.bcj();
        y.i("MicroMsg.IPCallDeviceManager", "onBadNetStatus");
        if (localb.lqr != null)
        {
          com.tencent.mm.plugin.ipcall.ui.j localj = localb.lqr;
          if (localj.lzQ != null) {
            localj.lzQ.setVisibility(0);
          }
          if (localj.lzR != null) {
            localj.lzR.setVisibility(0);
          }
        }
      } while (au.Hy().dui.isSpeakerphoneOn());
      l = System.currentTimeMillis();
    } while (l - localb.lqu <= 30000L);
    localb.lqu = l;
    com.tencent.mm.plugin.voip.b.bPx().Al(R.k.voip_bad_netstatus_hint);
  }
  
  public final void bbH()
  {
    if (com.tencent.mm.plugin.ipcall.a.i.bck().mCurrentState != 5) {
      y.i("MicroMsg.IPCallManager", "onResumeGoodNetStatus currentState != accept:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.ipcall.a.i.bck().mCurrentState) });
    }
    com.tencent.mm.plugin.ipcall.a.b.b localb;
    do
    {
      return;
      localb = com.tencent.mm.plugin.ipcall.a.i.bcj();
      y.i("MicroMsg.IPCallDeviceManager", "onResumeGoodNetStatus");
    } while (localb.lqr == null);
    localb.lqr.bdl();
  }
  
  public final void bbI()
  {
    if (com.tencent.mm.plugin.ipcall.a.i.bck().bcd()) {}
    for (Object localObject1 = ae.getContext().getString(R.l.ip_call_minimize_wording_with_time, new Object[] { String.format("%02d:%02d", new Object[] { Long.valueOf(bk.cn(this.loq) / 60L), Long.valueOf(bk.cn(this.loq) % 60L) }) });; localObject1 = ae.getContext().getString(R.l.ip_call_minimize_wording))
    {
      Object localObject2 = new Intent(ae.getContext(), IPCallTalkUI.class);
      ((Intent)localObject2).putExtra("IPCallTalkUI_isFromMiniNotification", true);
      localObject2 = PendingIntent.getActivity(ae.getContext(), 42, (Intent)localObject2, 134217728);
      int i = R.g.notification_icon_gray;
      if (com.tencent.mm.compatible.util.d.gG(19)) {
        i = R.g.notification_icon;
      }
      localObject1 = new Notification.Builder(ae.getContext()).setTicker(ae.getContext().getString(R.l.ip_call_minimize_wording)).setWhen(System.currentTimeMillis()).setContentTitle(ae.getContext().getString(R.l.ip_call_func_name)).setContentText((CharSequence)localObject1).setContentIntent((PendingIntent)localObject2).getNotification();
      ((Notification)localObject1).icon = i;
      ((Notification)localObject1).flags |= 0x20;
      au.getNotification().a(42, (Notification)localObject1, false);
      if (com.tencent.mm.plugin.ipcall.a.i.bck().bcd()) {
        break;
      }
      com.tencent.mm.plugin.voip.b.bPy().Qb(ae.getContext().getString(R.l.multitalk_waiting_wording));
      return;
    }
    com.tencent.mm.plugin.voip.b.bPy().yg(bbK());
  }
  
  public final void bbJ()
  {
    synchronized (this.jYz)
    {
      this.loo = false;
      com.tencent.mm.plugin.voip.b.bPy().dismiss();
      ((NotificationManager)ae.getContext().getSystemService("notification")).cancel(42);
      return;
    }
  }
  
  public final int bbK()
  {
    int i = (int)bk.cn(this.loq);
    if (i > 0) {
      return i;
    }
    return 0;
  }
  
  public final void bby()
  {
    y.i("MicroMsg.IPCallManager", "onInviteSuccess");
    if (!com.tencent.mm.plugin.ipcall.a.i.bck().sF(3)) {}
    do
    {
      return;
      Object localObject = com.tencent.mm.plugin.ipcall.a.i.bci();
      y.d("MicroMsg.IPCallReportHelper", "markStartInvite");
      if (((com.tencent.mm.plugin.ipcall.a.c.b)localObject).lra == 0L) {
        ((com.tencent.mm.plugin.ipcall.a.c.b)localObject).lra = System.currentTimeMillis();
      }
      localObject = com.tencent.mm.plugin.ipcall.a.i.bcg().loW;
      com.tencent.mm.plugin.ipcall.a.c.b localb = com.tencent.mm.plugin.ipcall.a.i.bci();
      int i = ((com.tencent.mm.plugin.ipcall.a.a.c)localObject).lpG;
      String str1 = ((com.tencent.mm.plugin.ipcall.a.a.c)localObject).bYR;
      String str2 = ((com.tencent.mm.plugin.ipcall.a.a.c)localObject).lqf;
      int j = ((com.tencent.mm.plugin.ipcall.a.a.c)localObject).lpD;
      long l1 = ((com.tencent.mm.plugin.ipcall.a.a.c)localObject).lpE;
      long l2 = ((com.tencent.mm.plugin.ipcall.a.a.c)localObject).lpF;
      localb.lpG = i;
      localb.lqZ = str1;
      localb.fjn = str2;
      localb.lpD = j;
      localb.lpE = l1;
      localb.lqX = l2;
    } while (this.lof == null);
    this.lof.bby();
  }
  
  public final void bbz()
  {
    y.i("MicroMsg.IPCallManager", "onStartRing, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.a.f.stateToString(com.tencent.mm.plugin.ipcall.a.i.bck().mCurrentState) });
    if (!com.tencent.mm.plugin.ipcall.a.i.bck().sF(4)) {}
    do
    {
      return;
      com.tencent.mm.plugin.ipcall.a.c.b localb = com.tencent.mm.plugin.ipcall.a.i.bci();
      y.d("MicroMsg.IPCallReportHelper", "markStartRing");
      if (localb.lrb == 0L)
      {
        localb.lrb = System.currentTimeMillis();
        localb.lqS = (localb.lrb - localb.lra);
        y.d("MicroMsg.IPCallReportHelper", "ringTime: %d", new Object[] { Long.valueOf(localb.lqS) });
      }
      com.tencent.mm.plugin.ipcall.a.i.bch().bcA();
      localb = com.tencent.mm.plugin.ipcall.a.i.bci();
      y.i("MicroMsg.IPCallReportHelper", "startRing");
      localb.lqN = 1;
    } while (this.lof == null);
    this.lof.bbz();
  }
  
  public final void ch()
  {
    if (this.loj != null)
    {
      this.loj.listen(this.lok, 0);
      this.loj = null;
    }
    com.tencent.mm.sdk.b.a.udP.d(this.lol);
  }
  
  public final void d(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    if (this.lof != null)
    {
      this.lof.d(paramInt1, paramString1, paramString2, paramInt2);
      return;
    }
    Toast.makeText(ae.getContext(), paramString2, 1).show();
  }
  
  public final boolean da(int paramInt1, int paramInt2)
  {
    if (com.tencent.mm.plugin.ipcall.a.i.bck().bcd())
    {
      if (paramInt1 == 0) {
        return L(9, paramInt1, paramInt2);
      }
      return L(11, paramInt1, paramInt2);
    }
    if (paramInt1 == 0) {
      return L(8, paramInt1, paramInt2);
    }
    return L(12, paramInt1, paramInt2);
  }
  
  public final void sD(int paramInt)
  {
    y.i("MicroMsg.IPCallManager", "onChannelConnectFailed, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.a.f.stateToString(com.tencent.mm.plugin.ipcall.a.i.bck().mCurrentState) });
    if (com.tencent.mm.plugin.ipcall.a.i.bch().lqJ)
    {
      y.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel already connected");
      if (da(5, paramInt)) {
        d(5, null, ae.getContext().getString(R.l.calling_failed_network), 1);
      }
    }
    do
    {
      return;
      y.i("MicroMsg.IPCallManager", "onChannelConnectFailed, channel not connet, may be request connect failed");
    } while (!da(4, paramInt));
    d(4, null, ae.getContext().getString(R.l.calling_failed_network), 1);
  }
  
  public final void y(String paramString1, String paramString2, int paramInt)
  {
    y.i("MicroMsg.IPCallManager", "onInviteFailed, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.a.f.stateToString(com.tencent.mm.plugin.ipcall.a.i.bck().mCurrentState) });
    if (da(2, 0)) {
      d(2, paramString1, paramString2, paramInt);
    }
  }
  
  public final void z(String paramString1, String paramString2, int paramInt)
  {
    y.i("MicroMsg.IPCallManager", "onAccountOverdue, currentState: %s", new Object[] { com.tencent.mm.plugin.ipcall.a.f.stateToString(com.tencent.mm.plugin.ipcall.a.i.bck().mCurrentState) });
    if (da(8, 9)) {
      d(8, paramString1, paramString2, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.c
 * JD-Core Version:    0.7.0.1
 */