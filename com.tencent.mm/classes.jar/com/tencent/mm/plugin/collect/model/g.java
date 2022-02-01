package com.tencent.mm.plugin.collect.model;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.g.a.cg.a;
import com.tencent.mm.g.b.a.hd;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.collect.model.voice.a.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.protocal.protobuf.uq;
import com.tencent.mm.protocal.protobuf.uz;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class g
  extends c<cg>
  implements f, a.c
{
  private static HandlerThread pgJ;
  private static final com.tencent.mm.bw.b pgy;
  private boolean lVw;
  private MediaPlayer pgA;
  public ConcurrentLinkedQueue<c> pgB;
  private int pgC;
  private int pgD;
  private long pgE;
  private WeakReference<ArrayList<String>> pgF;
  private hd pgG;
  private Map<String, cg> pgH;
  private final long pgI;
  private MediaPlayer pgz;
  
  static
  {
    AppMethodBeat.i(63818);
    pgy = com.tencent.mm.bw.b.aPw("元");
    pgJ = d.hh("syncCreatePlayer", 5);
    AppMethodBeat.o(63818);
  }
  
  public g()
  {
    AppMethodBeat.i(63797);
    this.lVw = false;
    this.pgH = new HashMap();
    this.pgI = 10000L;
    this.__eventId = cg.class.getName().hashCode();
    AppMethodBeat.o(63797);
  }
  
  private static int Bu(int paramInt)
  {
    int i = 2;
    if (paramInt == 1) {
      i = 3;
    }
    return i;
  }
  
  private void a(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3, String paramString3, int paramInt4)
  {
    AppMethodBeat.i(63810);
    this.pgG = new hd();
    this.pgG.dWt = paramInt1;
    this.pgG.qs(paramString1);
    if (!bu.jB(paramInt4, 0)) {
      this.pgG.etl = paramInt4;
    }
    this.pgG.ebQ = paramInt2;
    this.pgG.qt(paramString2);
    this.pgG.etp = paramInt3;
    if (bu.jB(paramInt1, 6)) {
      this.pgG.qu(paramString3);
    }
    this.pgG.aLH();
    AppMethodBeat.o(63810);
  }
  
  private void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(63807);
    Object localObject = new com.tencent.mm.vfs.k(cbF());
    if ((!((com.tencent.mm.vfs.k)localObject).exists()) && (!((com.tencent.mm.vfs.k)localObject).mkdirs()))
    {
      ae.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
      AppMethodBeat.o(63807);
      return;
    }
    localObject = cbF() + UUID.randomUUID().toString() + ".tmp";
    ae.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", new Object[] { localObject });
    if (n((String)localObject, paramArrayOfByte))
    {
      paramArrayOfByte = new c((byte)0);
      paramArrayOfByte.fileName = ((String)localObject);
      paramArrayOfByte.dui = paramInt2;
      paramArrayOfByte.pgR = paramInt1;
      paramArrayOfByte.doh = paramString;
      paramArrayOfByte.pgS = paramInt3;
      paramArrayOfByte.pgT = paramBoolean;
      this.pgB.add(paramArrayOfByte);
      cbC();
      AppMethodBeat.o(63807);
      return;
    }
    ae.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
    AppMethodBeat.o(63807);
  }
  
  private void a(cg paramcg, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(63798);
    ae.i("MicroMsg.F2fRcvVoiceListener", "callbackImp() tradeNo:%s useOffline:%s", new Object[] { paramcg.doe.doh, Boolean.valueOf(paramBoolean1) });
    long l = paramcg.doe.gW;
    if (paramcg.doe.doi.equals("wx_f2f"))
    {
      com.tencent.mm.plugin.collect.a.a.cbv();
      boolean bool = com.tencent.mm.plugin.collect.a.a.cbx();
      ae.i("MicroMsg.F2fRcvVoiceListener", "on recv, fee: %s, voice open: %B", new Object[] { Integer.valueOf(paramcg.doe.dof), Boolean.valueOf(bool) });
      if ((paramBoolean2) || (!aaF(paramcg.doe.doh)))
      {
        if (paramcg.doe.doj == 0) {
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(699L, 8L, 1L, false);
        }
        for (;;)
        {
          if ((paramBoolean1) && (!com.tencent.mm.plugin.collect.model.voice.a.phJ) && (!bu.isNullOrNil(paramcg.doe.dok)))
          {
            ae.i("MicroMsg.F2fRcvVoiceListener", "init tts");
            com.tencent.mm.plugin.collect.model.voice.a.cbM().jK(false);
          }
          if ((!paramBoolean1) || (!com.tencent.mm.plugin.collect.model.voice.a.phJ) || (bu.isNullOrNil(paramcg.doe.dok))) {
            break;
          }
          ae.i("MicroMsg.F2fRcvVoiceListener", "useOffline");
          this.pgH.put(paramcg.doe.doh, paramcg);
          com.tencent.mm.plugin.collect.model.voice.a.cbM().a(paramcg);
          AppMethodBeat.o(63798);
          return;
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(699L, 9L, 1L, false);
        }
        ae.i("MicroMsg.F2fRcvVoiceListener", "useOnline");
        paramcg = new i(paramcg.doe.dof, pgy, paramcg.doe.doh, paramcg.doe.doj, l);
        com.tencent.mm.kernel.g.ajS();
        com.tencent.mm.kernel.g.ajQ().gDv.a(paramcg, 0);
      }
      AppMethodBeat.o(63798);
      return;
    }
    if (paramcg.doe.doi.equals("wx_md"))
    {
      if ((paramBoolean1) && (com.tencent.mm.plugin.collect.model.voice.a.phJ) && (!bu.isNullOrNil(paramcg.doe.dok)))
      {
        this.pgH.put(paramcg.doe.doh, paramcg);
        com.tencent.mm.plugin.collect.model.voice.a.cbM().a(paramcg);
        AppMethodBeat.o(63798);
        return;
      }
      paramcg = new o(paramcg.doe.dof, pgy, paramcg.doe.doh);
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.ajQ().gDv.a(paramcg, 0);
      AppMethodBeat.o(63798);
      return;
    }
    ae.w("MicroMsg.F2fRcvVoiceListener", "unknown type: %s", new Object[] { paramcg.doe.doi });
    AppMethodBeat.o(63798);
  }
  
  private void a(final c paramc)
  {
    AppMethodBeat.i(63804);
    this.pgA = a.a(paramc.fileName, new MediaPlayer.OnCompletionListener()new MediaPlayer.OnErrorListener
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(63789);
        ae.i("MicroMsg.F2fRcvVoiceListener", "play done");
        g.e(g.this);
        g.i(g.this);
        g.f(g.this);
        if (!g.g(g.this).isEmpty())
        {
          g.h(g.this);
          AppMethodBeat.o(63789);
          return;
        }
        g.cbG();
        AppMethodBeat.o(63789);
      }
    }, new MediaPlayer.OnErrorListener()new b
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(63790);
        ae.e("MicroMsg.F2fRcvVoiceListener", "play money error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        g.e(g.this);
        g.i(g.this);
        com.tencent.mm.plugin.report.service.g.yxI.f(14404, new Object[] { Integer.valueOf(3), paramc.doh, Integer.valueOf(7), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramc.pgR) });
        g.f(g.this);
        if (!g.g(g.this).isEmpty()) {
          g.h(g.this);
        }
        for (;;)
        {
          AppMethodBeat.o(63790);
          return false;
          g.cbG();
        }
      }
    }, new b()
    {
      public final void cbI()
      {
        AppMethodBeat.i(189776);
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1143L, 41L, 1L, false);
        if (com.tencent.mm.plugin.collect.a.a.cbv().pgo)
        {
          ae.i("MicroMsg.F2fRcvVoiceListener", "play isForground");
          if (paramc.pgT)
          {
            com.tencent.mm.plugin.report.service.g.yxI.f(14404, new Object[] { Integer.valueOf(1), paramc.doh, "", "", Integer.valueOf(paramc.pgR), "", "", "", com.tencent.mm.plugin.collect.model.voice.a.cbM().cbT() });
            AppMethodBeat.o(189776);
            return;
          }
          com.tencent.mm.plugin.report.service.g.yxI.f(14404, new Object[] { Integer.valueOf(1), paramc.doh, "", "", Integer.valueOf(paramc.pgR) });
          AppMethodBeat.o(189776);
          return;
        }
        ae.i("MicroMsg.F2fRcvVoiceListener", "play isBackground");
        if (paramc.pgT)
        {
          com.tencent.mm.plugin.report.service.g.yxI.f(14404, new Object[] { Integer.valueOf(2), paramc.doh, "", "", Integer.valueOf(paramc.pgR), "", "", "", com.tencent.mm.plugin.collect.model.voice.a.cbM().cbT() });
          AppMethodBeat.o(189776);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yxI.f(14404, new Object[] { Integer.valueOf(2), paramc.doh, "", "", Integer.valueOf(paramc.pgR) });
        AppMethodBeat.o(189776);
      }
    });
    AppMethodBeat.o(63804);
  }
  
  private void aJ(int paramInt, String paramString)
  {
    AppMethodBeat.i(63808);
    ae.i("MicroMsg.F2fRcvVoiceListener", "play default sound only");
    c localc = new c((byte)0);
    localc.pgR = paramInt;
    localc.doh = paramString;
    this.pgB.add(localc);
    cbC();
    AppMethodBeat.o(63808);
  }
  
  private boolean aaF(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(63800);
        boolean bool;
        if (bu.isNullOrNil(paramString))
        {
          ae.w("MicroMsg.F2fRcvVoiceListener", "illegal no: %s, not do play", new Object[] { paramString });
          AppMethodBeat.o(63800);
          bool = true;
          return bool;
        }
        List localList = cbA();
        Iterator localIterator = cbA().iterator();
        if (localIterator.hasNext())
        {
          if (((String)localIterator.next()).equals(paramString))
          {
            ae.i("MicroMsg.F2fRcvVoiceListener", "has played tradeno: %s", new Object[] { paramString });
            AppMethodBeat.o(63800);
            bool = true;
          }
        }
        else
        {
          localList.add(paramString);
          if (localList.size() > 10)
          {
            ae.i("MicroMsg.F2fRcvVoiceListener", "over max size, do remove");
            int i = localList.size();
            paramString = localList.subList(i - 10, i);
            com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXM, bu.m(paramString, ","));
            AppMethodBeat.o(63800);
            bool = false;
          }
          else
          {
            paramString = localList;
          }
        }
      }
      finally {}
    }
  }
  
  private static int aaG(String paramString)
  {
    AppMethodBeat.i(63809);
    int i = 0;
    if (paramString.equals("wx_f2f")) {
      i = 1;
    }
    for (;;)
    {
      AppMethodBeat.o(63809);
      return i;
      if (paramString.equals("wx_md")) {
        i = 2;
      }
    }
  }
  
  private List<String> cbA()
  {
    AppMethodBeat.i(63799);
    if ((this.pgF == null) || (this.pgF.get() == null))
    {
      ae.i("MicroMsg.F2fRcvVoiceListener", "refer is null");
      this.pgF = new WeakReference(new ArrayList(bu.lV((String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IXM, ""), ",")));
    }
    List localList = (List)this.pgF.get();
    AppMethodBeat.o(63799);
    return localList;
  }
  
  public static boolean cbB()
  {
    AppMethodBeat.i(63802);
    ae.i("MicroMsg.F2fRcvVoiceListener", "delete files");
    boolean bool = com.tencent.mm.vfs.o.dd(cbF(), true);
    AppMethodBeat.o(63802);
    return bool;
  }
  
  private void cbC()
  {
    for (;;)
    {
      final c localc;
      try
      {
        AppMethodBeat.i(63803);
        long l1 = System.currentTimeMillis();
        long l2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qNC, 10000L);
        ae.i("MicroMsg.F2fRcvVoiceListener", "voiceOvertime: %s", new Object[] { Long.valueOf(l2) });
        if ((this.lVw) && (l1 - this.pgE > l2))
        {
          ae.i("MicroMsg.F2fRcvVoiceListener", "last has outdate: %s", new Object[] { Long.valueOf(this.pgE) });
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1143L, 42L, 1L, false);
          this.lVw = false;
        }
        if (this.lVw)
        {
          ae.i("MicroMsg.F2fRcvVoiceListener", "is playing, return");
          AppMethodBeat.o(63803);
          return;
        }
        this.lVw = true;
        this.pgE = System.currentTimeMillis();
        localc = (c)this.pgB.poll();
        i = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(3);
        this.pgC = com.tencent.mm.plugin.audio.c.a.getStreamVolume(3);
        this.pgD = Math.round(i * 0.5F);
        ae.i("MicroMsg.F2fRcvVoiceListener", "curVol: %s, maxVol: %s, minVol: %s", new Object[] { Integer.valueOf(this.pgC), Integer.valueOf(i), Integer.valueOf(this.pgD) });
        if (Build.VERSION.SDK_INT < 23) {
          break label686;
        }
        bool = com.tencent.mm.plugin.audio.c.a.bHD();
        ae.i("MicroMsg.F2fRcvVoiceListener", "isMute: %s", new Object[] { Boolean.valueOf(bool) });
        if ((this.pgC == 0) || (bool))
        {
          ae.i("MicroMsg.F2fRcvVoiceListener", "music channel is mute");
          if (localc != null)
          {
            i = localc.pgR;
            com.tencent.mm.plugin.report.service.g localg = com.tencent.mm.plugin.report.service.g.yxI;
            if (localc == null) {
              break label468;
            }
            String str1 = localc.doh;
            localg.f(14404, new Object[] { Integer.valueOf(3), str1, Integer.valueOf(5), "", Integer.valueOf(i) });
          }
        }
        else
        {
          if ((this.pgC > 0) && (this.pgC < this.pgD) && (!bool)) {
            com.tencent.mm.plugin.audio.c.a.eD(3, this.pgD);
          }
          if (localc == null) {
            break label672;
          }
          ae.i("MicroMsg.F2fRcvVoiceListener", "holder.offLine = %s", new Object[] { Boolean.valueOf(localc.pgT) });
          if (!localc.pgT) {
            break label493;
          }
          a(localc);
          if ((!this.lVw) || (this.pgA != null)) {
            break label476;
          }
          ae.i("MicroMsg.F2fRcvVoiceListener", "isPlaying && moneyPlayer == null");
          AppMethodBeat.o(63803);
          continue;
        }
        i = 1;
      }
      finally {}
      continue;
      label468:
      String str2 = "";
      continue;
      label476:
      ae.i("MicroMsg.F2fRcvVoiceListener", "has played");
      AppMethodBeat.o(63803);
      continue;
      label493:
      int i = localc.pgR;
      if (!bu.isNullOrNil(localc.fileName))
      {
        ae.i("MicroMsg.F2fRcvVoiceListener", "play prefix voice: %d", new Object[] { Integer.valueOf(i) });
        this.pgz = a.a(ak.getContext(), new MediaPlayer.OnCompletionListener()new MediaPlayer.OnErrorListener
        {
          public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            AppMethodBeat.i(63784);
            ae.i("MicroMsg.F2fRcvVoiceListener", "start play money");
            if ((g.a(g.this) != null) && (g.b(g.this)) && (g.c(g.this) == null)) {
              g.a(g.this, localc);
            }
            for (;;)
            {
              g.d(g.this);
              AppMethodBeat.o(63784);
              return;
              ae.i("MicroMsg.F2fRcvVoiceListener", "has played");
            }
          }
        }, new MediaPlayer.OnErrorListener()
        {
          public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(63785);
            ae.e("MicroMsg.F2fRcvVoiceListener", "prefix play error");
            g.e(g.this);
            g.d(g.this);
            g.f(g.this);
            com.tencent.mm.plugin.report.service.g.yxI.f(14404, new Object[] { Integer.valueOf(3), localc.doh, Integer.valueOf(7), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(localc.pgR) });
            if (!g.g(g.this).isEmpty()) {
              g.h(g.this);
            }
            for (;;)
            {
              AppMethodBeat.o(63785);
              return false;
              g.cbG();
            }
          }
        });
        if (this.pgz != null)
        {
          i = this.pgz.getDuration();
          ae.i("MicroMsg.F2fRcvVoiceListener", "prefix duration: %s", new Object[] { Integer.valueOf(i) });
          ar.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(63786);
              if ((g.a(g.this) != null) && (g.b(g.this)) && (g.c(g.this) == null))
              {
                ae.i("MicroMsg.F2fRcvVoiceListener", "this play may error");
                com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(699L, 1L, 1L, false);
              }
              AppMethodBeat.o(63786);
            }
          }, i + 1000);
          AppMethodBeat.o(63803);
        }
      }
      else
      {
        this.pgz = a.a(ak.getContext(), new MediaPlayer.OnCompletionListener()new MediaPlayer.OnErrorListener
        {
          public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            AppMethodBeat.i(63787);
            ae.i("MicroMsg.F2fRcvVoiceListener", "no need to play money this time");
            g.f(g.this);
            g.e(g.this);
            g.d(g.this);
            com.tencent.mm.plugin.collect.a.a.cbv();
            com.tencent.mm.plugin.report.service.g.yxI.f(14404, new Object[] { Integer.valueOf(4), localc.doh, "", "", Integer.valueOf(localc.pgR) });
            if (!g.g(g.this).isEmpty())
            {
              g.h(g.this);
              AppMethodBeat.o(63787);
              return;
            }
            g.cbG();
            AppMethodBeat.o(63787);
          }
        }, new MediaPlayer.OnErrorListener()
        {
          public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(63788);
            ae.e("MicroMsg.F2fRcvVoiceListener", "no need play money error");
            g.f(g.this);
            g.e(g.this);
            g.d(g.this);
            com.tencent.mm.plugin.report.service.g.yxI.f(14404, new Object[] { Integer.valueOf(3), localc.doh, Integer.valueOf(7), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(localc.pgR) });
            AppMethodBeat.o(63788);
            return false;
          }
        });
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(699L, 2L, 1L, false);
      }
      AppMethodBeat.o(63803);
      continue;
      label672:
      this.lVw = false;
      AppMethodBeat.o(63803);
      continue;
      label686:
      boolean bool = false;
    }
  }
  
  private static MediaPlayer cbD()
  {
    AppMethodBeat.i(189779);
    final Object localObject1 = Looper.myLooper();
    ae.i("MicroMsg.F2fRcvVoiceListener", "[syncCreatePlayer] %s", new Object[] { localObject1 });
    if ((localObject1 != null) && (localObject1 != Looper.getMainLooper()) && (localObject1 != pgJ.getLooper()))
    {
      if (!pgJ.isAlive()) {
        pgJ.start();
      }
      aq localaq = new aq(pgJ.getLooper());
      localObject1 = new Object();
      MediaPlayer[] arrayOfMediaPlayer = new MediaPlayer[1];
      arrayOfMediaPlayer[0] = null;
      try
      {
        localaq.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(189777);
            this.pgM[0] = new com.tencent.mm.compatible.b.k();
            try
            {
              synchronized (localObject1)
              {
                localObject1.notify();
                AppMethodBeat.o(189777);
                return;
              }
              return;
            }
            catch (Exception localException)
            {
              ae.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", localException, "", new Object[0]);
              AppMethodBeat.o(189777);
            }
          }
        });
        try
        {
          localObject1.wait();
          localObject1 = arrayOfMediaPlayer[0];
          AppMethodBeat.o(189779);
          return localObject1;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            ae.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", localInterruptedException, "", new Object[0]);
          }
        }
        localObject1 = new com.tencent.mm.compatible.b.k();
      }
      finally
      {
        AppMethodBeat.o(189779);
      }
    }
    AppMethodBeat.o(189779);
    return localObject1;
  }
  
  private static int cbE()
  {
    AppMethodBeat.i(63811);
    if (com.tencent.mm.plugin.audio.c.a.bHz())
    {
      AppMethodBeat.o(63811);
      return 1;
    }
    AppMethodBeat.o(63811);
    return 0;
  }
  
  private static String cbF()
  {
    AppMethodBeat.i(63812);
    String str = com.tencent.mm.loader.j.b.asj() + "wallet/voice/";
    AppMethodBeat.o(63812);
    return str;
  }
  
  private static boolean n(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63801);
    com.tencent.mm.kernel.g.ajS();
    if (!com.tencent.mm.kernel.g.ajR().isSDCardAvailable())
    {
      ae.i("MicroMsg.F2fRcvVoiceListener", "sd card not available");
      AppMethodBeat.o(63801);
      return false;
    }
    if (com.tencent.mm.vfs.o.f(paramString, paramArrayOfByte, paramArrayOfByte.length) == 0)
    {
      AppMethodBeat.o(63801);
      return true;
    }
    AppMethodBeat.o(63801);
    return false;
  }
  
  public final void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63806);
    ae.i("MicroMsg.F2fRcvVoiceListener", "errorCode:%s outTradeNo:%s type:%s content:%s packId:%s overtimeFlag:%s", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, paramString4, Integer.valueOf(0) });
    int i = aaG(paramString2);
    paramString2 = (cg)this.pgH.remove(paramString1);
    if (paramInt1 < 0)
    {
      if (paramString2 != null) {
        if (paramString2.doe.dom) {
          a(paramString2, false, true);
        }
      }
      for (;;)
      {
        a(6, paramString1, i, paramString3, paramInt2, paramString4, 9);
        AppMethodBeat.o(63806);
        return;
        ae.i("MicroMsg.F2fRcvVoiceListener", "onGetResult() needFailover:false");
        continue;
        aJ(i, paramString1);
      }
    }
    a(i, paramArrayOfByte, 1, paramString1, 0, true);
    a(5, paramString1, i, paramString3, paramInt2, paramString4, 0);
    AppMethodBeat.o(63806);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(63805);
    ae.i("MicroMsg.F2fRcvVoiceListener", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramn instanceof i))
    {
      paramn = (i)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ae.i("MicroMsg.F2fRcvVoiceListener", "overtime: %s retcode: %s", new Object[] { Integer.valueOf(paramn.pgW.GmA), Integer.valueOf(paramn.pgW.dmy) });
        if (paramn.pgW.GmA == 1)
        {
          ae.w("MicroMsg.F2fRcvVoiceListener", "skip over 10min: %s", new Object[] { Long.valueOf(paramn.gW) });
          com.tencent.mm.plugin.report.service.g.yxI.f(14404, new Object[] { Integer.valueOf(3), paramn.doh, Integer.valueOf(1), "", Integer.valueOf(1) });
          AppMethodBeat.o(63805);
          return;
        }
        if ((paramn.pgW.dmy == 0) && (paramn.pgW.Gmz != null))
        {
          a(1, paramn.pgW.Gmz.zr, paramn.pgW.Ggx, paramn.doh, paramn.pgW.GmA, false);
          com.tencent.mm.plugin.report.service.g.yxI.f(15763, new Object[] { paramn.doh, Integer.valueOf(1), Integer.valueOf(Bu(paramn.doj)), Long.valueOf(paramn.pgX), Integer.valueOf(cbE()) });
          AppMethodBeat.o(63805);
          return;
        }
        if (paramn.pgW.dmy <= 100)
        {
          paramInt1 = paramn.pgW.dmy;
          if (paramn.pgW.Gmz == null) {}
          for (paramString = "null";; paramString = "not null")
          {
            ae.i("MicroMsg.F2fRcvVoiceListener", "play default sound only %s %s", new Object[] { Integer.valueOf(paramInt1), paramString });
            aJ(1, paramn.doh);
            com.tencent.mm.plugin.report.service.g.yxI.f(15763, new Object[] { paramn.doh, Integer.valueOf(2), Integer.valueOf(Bu(paramn.doj)), Long.valueOf(paramn.pgX), Integer.valueOf(cbE()) });
            AppMethodBeat.o(63805);
            return;
          }
        }
        ae.w("MicroMsg.F2fRcvVoiceListener", "retcode > 100, don't play");
        com.tencent.mm.plugin.report.service.g.yxI.f(14404, new Object[] { Integer.valueOf(3), paramn.doh, Integer.valueOf(2), "", Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.g.yxI.f(15763, new Object[] { paramn.doh, Integer.valueOf(2), Integer.valueOf(Bu(paramn.doj)), Long.valueOf(paramn.pgX), Integer.valueOf(cbE()) });
        AppMethodBeat.o(63805);
        return;
      }
      ae.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", new Object[] { paramn });
      aJ(1, paramn.doh);
      com.tencent.mm.plugin.report.service.g.yxI.f(15763, new Object[] { paramn.doh, Integer.valueOf(2), Integer.valueOf(Bu(paramn.doj)), Long.valueOf(paramn.pgX), Integer.valueOf(cbE()) });
      com.tencent.mm.plugin.report.service.g.yxI.f(14404, new Object[] { Integer.valueOf(3), paramn.doh, Integer.valueOf(3), "", Integer.valueOf(1) });
      AppMethodBeat.o(63805);
      return;
    }
    if ((paramn instanceof o))
    {
      paramString = (o)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.phr.dmy == 0)
        {
          paramn = new com.tencent.mm.vfs.k(cbF());
          if ((!paramn.exists()) && (!paramn.mkdirs()))
          {
            ae.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
            AppMethodBeat.o(63805);
            return;
          }
          paramn = cbF() + UUID.randomUUID().toString() + ".tmp";
          ae.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", new Object[] { paramn });
          if (n(paramn, paramString.phr.Gmz.zr))
          {
            c localc = new c((byte)0);
            localc.fileName = paramn;
            localc.dui = paramString.phr.Ggx;
            localc.pgR = 2;
            this.pgB.add(localc);
            cbC();
            AppMethodBeat.o(63805);
            return;
          }
          ae.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
          AppMethodBeat.o(63805);
          return;
        }
        com.tencent.mm.plugin.report.service.g.yxI.f(14404, new Object[] { Integer.valueOf(3), paramString.doh, Integer.valueOf(2), "", Integer.valueOf(2) });
        AppMethodBeat.o(63805);
        return;
      }
      ae.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.g.yxI.f(14404, new Object[] { Integer.valueOf(3), paramString.doh, Integer.valueOf(3), "", Integer.valueOf(2) });
    }
    AppMethodBeat.o(63805);
  }
  
  static final class a
  {
    /* Error */
    public static MediaPlayer a(android.content.Context paramContext, final MediaPlayer.OnCompletionListener paramOnCompletionListener, final MediaPlayer.OnErrorListener paramOnErrorListener)
    {
      // Byte code:
      //   0: ldc 21
      //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: ifnonnull +33 -> 39
      //   9: ldc 29
      //   11: ldc 31
      //   13: iconst_2
      //   14: anewarray 4	java/lang/Object
      //   17: dup
      //   18: iconst_0
      //   19: aload_0
      //   20: aastore
      //   21: dup
      //   22: iconst_1
      //   23: ldc 32
      //   25: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   28: aastore
      //   29: invokestatic 44	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   32: ldc 21
      //   34: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   37: aconst_null
      //   38: areturn
      //   39: aload_0
      //   40: ldc 32
      //   42: invokevirtual 53	android/content/Context:getString	(I)Ljava/lang/String;
      //   45: astore 8
      //   47: invokestatic 57	com/tencent/mm/plugin/collect/model/g:cbH	()Landroid/media/MediaPlayer;
      //   50: astore 7
      //   52: aload 7
      //   54: iconst_3
      //   55: invokevirtual 62	android/media/MediaPlayer:setAudioStreamType	(I)V
      //   58: ldc 29
      //   60: ldc 64
      //   62: iconst_4
      //   63: anewarray 4	java/lang/Object
      //   66: dup
      //   67: iconst_0
      //   68: aload 7
      //   70: invokevirtual 68	java/lang/Object:hashCode	()I
      //   73: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   76: aastore
      //   77: dup
      //   78: iconst_1
      //   79: aload 8
      //   81: aastore
      //   82: dup
      //   83: iconst_2
      //   84: aload_0
      //   85: aastore
      //   86: dup
      //   87: iconst_3
      //   88: ldc 32
      //   90: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   93: aastore
      //   94: invokestatic 70	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   97: aconst_null
      //   98: astore 6
      //   100: aload_0
      //   101: invokevirtual 74	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
      //   104: aload 8
      //   106: invokevirtual 80	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
      //   109: astore_0
      //   110: aload 7
      //   112: aload_0
      //   113: invokevirtual 86	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
      //   116: aload_0
      //   117: invokevirtual 90	android/content/res/AssetFileDescriptor:getStartOffset	()J
      //   120: aload_0
      //   121: invokevirtual 93	android/content/res/AssetFileDescriptor:getLength	()J
      //   124: invokevirtual 97	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
      //   127: aload 7
      //   129: iconst_0
      //   130: invokevirtual 101	android/media/MediaPlayer:setLooping	(Z)V
      //   133: aload 7
      //   135: new 9	com/tencent/mm/plugin/collect/model/g$a$1
      //   138: dup
      //   139: aload 7
      //   141: aload_2
      //   142: invokespecial 105	com/tencent/mm/plugin/collect/model/g$a$1:<init>	(Landroid/media/MediaPlayer;Landroid/media/MediaPlayer$OnErrorListener;)V
      //   145: invokevirtual 109	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
      //   148: aload 7
      //   150: new 11	com/tencent/mm/plugin/collect/model/g$a$2
      //   153: dup
      //   154: aload 8
      //   156: aload 7
      //   158: aload_1
      //   159: invokespecial 112	com/tencent/mm/plugin/collect/model/g$a$2:<init>	(Ljava/lang/String;Landroid/media/MediaPlayer;Landroid/media/MediaPlayer$OnCompletionListener;)V
      //   162: invokevirtual 116	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
      //   165: aload 7
      //   167: invokevirtual 120	android/media/MediaPlayer:prepare	()V
      //   170: aload 7
      //   172: invokevirtual 123	android/media/MediaPlayer:start	()V
      //   175: aload 7
      //   177: invokevirtual 68	java/lang/Object:hashCode	()I
      //   180: istore_3
      //   181: invokestatic 129	android/os/Looper:myLooper	()Landroid/os/Looper;
      //   184: ifnull +65 -> 249
      //   187: iconst_1
      //   188: istore 4
      //   190: invokestatic 132	android/os/Looper:getMainLooper	()Landroid/os/Looper;
      //   193: ifnull +62 -> 255
      //   196: iconst_1
      //   197: istore 5
      //   199: ldc 29
      //   201: ldc 134
      //   203: iconst_3
      //   204: anewarray 4	java/lang/Object
      //   207: dup
      //   208: iconst_0
      //   209: iload_3
      //   210: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   213: aastore
      //   214: dup
      //   215: iconst_1
      //   216: iload 4
      //   218: invokestatic 139	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   221: aastore
      //   222: dup
      //   223: iconst_2
      //   224: iload 5
      //   226: invokestatic 139	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   229: aastore
      //   230: invokestatic 70	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   233: aload_0
      //   234: ifnull +7 -> 241
      //   237: aload_0
      //   238: invokevirtual 142	android/content/res/AssetFileDescriptor:close	()V
      //   241: ldc 21
      //   243: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   246: aload 7
      //   248: areturn
      //   249: iconst_0
      //   250: istore 4
      //   252: goto -62 -> 190
      //   255: iconst_0
      //   256: istore 5
      //   258: goto -59 -> 199
      //   261: astore_0
      //   262: ldc 29
      //   264: aload_0
      //   265: ldc 144
      //   267: iconst_0
      //   268: anewarray 4	java/lang/Object
      //   271: invokestatic 148	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   274: goto -33 -> 241
      //   277: astore_1
      //   278: aload 6
      //   280: astore_0
      //   281: ldc 29
      //   283: ldc 150
      //   285: iconst_2
      //   286: anewarray 4	java/lang/Object
      //   289: dup
      //   290: iconst_0
      //   291: ldc 32
      //   293: invokestatic 38	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   296: aastore
      //   297: dup
      //   298: iconst_1
      //   299: aload_1
      //   300: invokevirtual 154	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   303: aastore
      //   304: invokestatic 44	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   307: ldc 29
      //   309: aload_1
      //   310: ldc 144
      //   312: iconst_0
      //   313: anewarray 4	java/lang/Object
      //   316: invokestatic 148	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   319: aload 7
      //   321: ifnull +8 -> 329
      //   324: aload 7
      //   326: invokevirtual 157	android/media/MediaPlayer:release	()V
      //   329: aload_0
      //   330: ifnull +7 -> 337
      //   333: aload_0
      //   334: invokevirtual 142	android/content/res/AssetFileDescriptor:close	()V
      //   337: ldc 21
      //   339: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   342: aconst_null
      //   343: areturn
      //   344: astore_0
      //   345: ldc 29
      //   347: aload_0
      //   348: ldc 144
      //   350: iconst_0
      //   351: anewarray 4	java/lang/Object
      //   354: invokestatic 148	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   357: goto -20 -> 337
      //   360: astore_1
      //   361: aconst_null
      //   362: astore_0
      //   363: aload_0
      //   364: ifnull +7 -> 371
      //   367: aload_0
      //   368: invokevirtual 142	android/content/res/AssetFileDescriptor:close	()V
      //   371: ldc 21
      //   373: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   376: aload_1
      //   377: athrow
      //   378: astore_0
      //   379: ldc 29
      //   381: aload_0
      //   382: ldc 144
      //   384: iconst_0
      //   385: anewarray 4	java/lang/Object
      //   388: invokestatic 148	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   391: goto -20 -> 371
      //   394: astore_1
      //   395: goto -32 -> 363
      //   398: astore_1
      //   399: goto -36 -> 363
      //   402: astore_1
      //   403: goto -122 -> 281
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	406	0	paramContext	android.content.Context
      //   0	406	1	paramOnCompletionListener	MediaPlayer.OnCompletionListener
      //   0	406	2	paramOnErrorListener	MediaPlayer.OnErrorListener
      //   180	30	3	i	int
      //   188	63	4	bool1	boolean
      //   197	60	5	bool2	boolean
      //   98	181	6	localObject	Object
      //   50	275	7	localMediaPlayer	MediaPlayer
      //   45	110	8	str	String
      // Exception table:
      //   from	to	target	type
      //   237	241	261	java/io/IOException
      //   100	110	277	java/lang/Exception
      //   333	337	344	java/io/IOException
      //   100	110	360	finally
      //   367	371	378	java/io/IOException
      //   110	187	394	finally
      //   190	196	394	finally
      //   199	233	394	finally
      //   281	319	398	finally
      //   324	329	398	finally
      //   110	187	402	java/lang/Exception
      //   190	196	402	java/lang/Exception
      //   199	233	402	java/lang/Exception
    }
    
    public static MediaPlayer a(String paramString, final MediaPlayer.OnCompletionListener paramOnCompletionListener, final MediaPlayer.OnErrorListener paramOnErrorListener, g.b paramb)
    {
      AppMethodBeat.i(189778);
      final MediaPlayer localMediaPlayer = g.cbH();
      localMediaPlayer.setAudioStreamType(3);
      ae.i("MicroMsg.F2fRcvVoiceListener", "play start mp:%d path:%s", new Object[] { Integer.valueOf(localMediaPlayer.hashCode()), paramString });
      try
      {
        localMediaPlayer.setDataSource(paramString);
        localMediaPlayer.setLooping(false);
        localMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener()
        {
          public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(63793);
            ae.i("MicroMsg.F2fRcvVoiceListener", "onError, what: %d, extra: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            if (paramAnonymousMediaPlayer != null) {}
            try
            {
              paramAnonymousMediaPlayer.release();
              if (this.pgO != null) {
                this.pgO.release();
              }
            }
            catch (Exception localException)
            {
              label52:
              break label52;
            }
            if (paramOnErrorListener != null) {
              paramOnErrorListener.onError(paramAnonymousMediaPlayer, paramAnonymousInt1, paramAnonymousInt2);
            }
            AppMethodBeat.o(63793);
            return false;
          }
        });
        localMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
          public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            AppMethodBeat.i(63794);
            if (paramAnonymousMediaPlayer == null) {}
            for (int i = -1;; i = paramAnonymousMediaPlayer.hashCode())
            {
              ae.i("MicroMsg.F2fRcvVoiceListener", "play completion mp:%d  path:%s", new Object[] { Integer.valueOf(i), this.val$path });
              if (paramAnonymousMediaPlayer != null) {
                paramAnonymousMediaPlayer.release();
              }
              if (localMediaPlayer != null) {
                localMediaPlayer.release();
              }
              if (paramOnCompletionListener != null) {
                paramOnCompletionListener.onCompletion(paramAnonymousMediaPlayer);
              }
              AppMethodBeat.o(63794);
              return;
            }
          }
        });
        localMediaPlayer.prepare();
        localMediaPlayer.start();
        paramb.cbI();
        int i = localMediaPlayer.hashCode();
        boolean bool1;
        if (Looper.myLooper() != null)
        {
          bool1 = true;
          if (Looper.getMainLooper() == null) {
            break label175;
          }
        }
        label175:
        for (boolean bool2 = true;; bool2 = false)
        {
          ae.i("MicroMsg.F2fRcvVoiceListener", "play start mp finish [%d], myLooper[%b] mainLooper[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          AppMethodBeat.o(189778);
          return localMediaPlayer;
          bool1 = false;
          break;
        }
        return null;
      }
      catch (Exception paramOnCompletionListener)
      {
        ae.e("MicroMsg.F2fRcvVoiceListener", "play failed path:%s e:%s", new Object[] { paramString, paramOnCompletionListener.getMessage() });
        ae.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", paramOnCompletionListener, "", new Object[0]);
        if (localMediaPlayer != null) {
          localMediaPlayer.release();
        }
        AppMethodBeat.o(189778);
      }
    }
  }
  
  static abstract interface b<T>
  {
    public abstract void cbI();
  }
  
  final class c
  {
    String doh;
    int dui;
    String fileName;
    int pgR;
    int pgS = 0;
    boolean pgT = false;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.g
 * JD-Core Version:    0.7.0.1
 */