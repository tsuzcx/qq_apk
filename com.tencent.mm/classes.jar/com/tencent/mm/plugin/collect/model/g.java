package com.tencent.mm.plugin.collect.model;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.f.a.cm;
import com.tencent.mm.f.a.cm.a;
import com.tencent.mm.f.b.a.nq;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.collect.model.voice.a.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.vz;
import com.tencent.mm.protocal.protobuf.wi;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class g
  extends IListener<cm>
  implements com.tencent.mm.an.i, a.c
{
  private static final com.tencent.mm.cd.b tUI;
  private static HandlerThread tUT;
  private boolean fGh;
  private MediaPlayer tUJ;
  private MediaPlayer tUK;
  public ConcurrentLinkedQueue<c> tUL;
  private int tUM;
  private int tUN;
  private long tUO;
  private WeakReference<ArrayList<String>> tUP;
  private nq tUQ;
  private Map<String, cm> tUR;
  private final long tUS;
  
  static
  {
    AppMethodBeat.i(63818);
    tUI = com.tencent.mm.cd.b.bss("元");
    tUT = d.il("syncCreatePlayer", 5);
    AppMethodBeat.o(63818);
  }
  
  public g()
  {
    AppMethodBeat.i(63797);
    this.fGh = false;
    this.tUR = new HashMap();
    this.tUS = 10000L;
    this.__eventId = cm.class.getName().hashCode();
    AppMethodBeat.o(63797);
  }
  
  private static int IK(int paramInt)
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
    this.tUQ = new nq();
    this.tUQ.gnP = paramInt1;
    this.tUQ.EE(paramString1);
    if (!Util.isEqual(paramInt4, 0)) {
      this.tUQ.gZW = paramInt4;
    }
    this.tUQ.grp = paramInt2;
    this.tUQ.EF(paramString2);
    this.tUQ.haa = paramInt3;
    if (Util.isEqual(paramInt1, 6)) {
      this.tUQ.EG(paramString3);
    }
    this.tUQ.bpa();
    AppMethodBeat.o(63810);
  }
  
  private void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(63807);
    Object localObject = new com.tencent.mm.vfs.q(cNZ());
    if ((!((com.tencent.mm.vfs.q)localObject).ifE()) && (!((com.tencent.mm.vfs.q)localObject).ifL()))
    {
      Log.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
      AppMethodBeat.o(63807);
      return;
    }
    localObject = cNZ() + UUID.randomUUID().toString() + ".tmp";
    Log.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", new Object[] { localObject });
    if (p((String)localObject, paramArrayOfByte))
    {
      paramArrayOfByte = new c((byte)0);
      paramArrayOfByte.fileName = ((String)localObject);
      paramArrayOfByte.fEi = paramInt2;
      paramArrayOfByte.tUZ = paramInt1;
      paramArrayOfByte.fyd = paramString;
      paramArrayOfByte.tVa = paramInt3;
      paramArrayOfByte.tVb = paramBoolean;
      this.tUL.add(paramArrayOfByte);
      cNW();
      AppMethodBeat.o(63807);
      return;
    }
    Log.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
    AppMethodBeat.o(63807);
  }
  
  private void a(cm paramcm, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(63798);
    Log.i("MicroMsg.F2fRcvVoiceListener", "callbackImp() tradeNo:%s useOffline:%s", new Object[] { paramcm.fyb.fyd, Boolean.valueOf(paramBoolean1) });
    long l = paramcm.fyb.delay;
    if (paramcm.fyb.fye.equals("wx_f2f"))
    {
      com.tencent.mm.plugin.collect.a.a.cNP();
      boolean bool = com.tencent.mm.plugin.collect.a.a.cNR();
      Log.i("MicroMsg.F2fRcvVoiceListener", "on recv, fee: %s, voice open: %B", new Object[] { Integer.valueOf(paramcm.fyb.fee), Boolean.valueOf(bool) });
      if ((paramBoolean2) || (!asA(paramcm.fyb.fyd)))
      {
        if (paramcm.fyb.source == 0) {
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(699L, 8L, 1L, false);
        }
        for (;;)
        {
          if ((paramBoolean1) && (!com.tencent.mm.plugin.collect.model.voice.a.tVT) && (!Util.isNullOrNil(paramcm.fyb.fyf)))
          {
            Log.i("MicroMsg.F2fRcvVoiceListener", "init tts");
            com.tencent.mm.plugin.collect.model.voice.a.cOg().lZ(false);
          }
          if ((!paramBoolean1) || (!com.tencent.mm.plugin.collect.model.voice.a.tVT) || (Util.isNullOrNil(paramcm.fyb.fyf))) {
            break;
          }
          Log.i("MicroMsg.F2fRcvVoiceListener", "useOffline");
          this.tUR.put(paramcm.fyb.fyd, paramcm);
          com.tencent.mm.plugin.collect.model.voice.a.cOg().a(paramcm);
          AppMethodBeat.o(63798);
          return;
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(699L, 9L, 1L, false);
        }
        Log.i("MicroMsg.F2fRcvVoiceListener", "useOnline");
        paramcm = new i(paramcm.fyb.fee, tUI, paramcm.fyb.fyd, paramcm.fyb.source, l);
        com.tencent.mm.kernel.h.aHH();
        com.tencent.mm.kernel.h.aHF().kcd.a(paramcm, 0);
      }
      AppMethodBeat.o(63798);
      return;
    }
    if (paramcm.fyb.fye.equals("wx_md"))
    {
      if ((paramBoolean1) && (com.tencent.mm.plugin.collect.model.voice.a.tVT) && (!Util.isNullOrNil(paramcm.fyb.fyf)))
      {
        this.tUR.put(paramcm.fyb.fyd, paramcm);
        com.tencent.mm.plugin.collect.model.voice.a.cOg().a(paramcm);
        AppMethodBeat.o(63798);
        return;
      }
      paramcm = new p(paramcm.fyb.fee, tUI, paramcm.fyb.fyd);
      com.tencent.mm.kernel.h.aHH();
      com.tencent.mm.kernel.h.aHF().kcd.a(paramcm, 0);
      AppMethodBeat.o(63798);
      return;
    }
    Log.w("MicroMsg.F2fRcvVoiceListener", "unknown type: %s", new Object[] { paramcm.fyb.fye });
    AppMethodBeat.o(63798);
  }
  
  private void a(final c paramc)
  {
    AppMethodBeat.i(63804);
    this.tUK = a.a(paramc.fileName, new MediaPlayer.OnCompletionListener()new MediaPlayer.OnErrorListener
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(63789);
        Log.i("MicroMsg.F2fRcvVoiceListener", "play done");
        g.e(g.this);
        g.i(g.this);
        g.f(g.this);
        if (!g.g(g.this).isEmpty())
        {
          g.h(g.this);
          AppMethodBeat.o(63789);
          return;
        }
        g.cOa();
        AppMethodBeat.o(63789);
      }
    }, new MediaPlayer.OnErrorListener()new b
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(63790);
        Log.e("MicroMsg.F2fRcvVoiceListener", "play money error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        g.e(g.this);
        g.i(g.this);
        com.tencent.mm.plugin.report.service.h.IzE.a(14404, new Object[] { Integer.valueOf(3), paramc.fyd, Integer.valueOf(7), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramc.tUZ) });
        g.f(g.this);
        if (!g.g(g.this).isEmpty()) {
          g.h(g.this);
        }
        for (;;)
        {
          AppMethodBeat.o(63790);
          return false;
          g.cOa();
        }
      }
    }, new b()
    {
      public final void cOc()
      {
        AppMethodBeat.i(276111);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1143L, 41L, 1L, false);
        if (com.tencent.mm.plugin.collect.a.a.cNP().tUy)
        {
          Log.i("MicroMsg.F2fRcvVoiceListener", "play isForground");
          if (paramc.tVb)
          {
            com.tencent.mm.plugin.report.service.h.IzE.a(14404, new Object[] { Integer.valueOf(1), paramc.fyd, "", "", Integer.valueOf(paramc.tUZ), "", "", "", com.tencent.mm.plugin.collect.model.voice.a.cOg().cOn() });
            AppMethodBeat.o(276111);
            return;
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(14404, new Object[] { Integer.valueOf(1), paramc.fyd, "", "", Integer.valueOf(paramc.tUZ) });
          AppMethodBeat.o(276111);
          return;
        }
        Log.i("MicroMsg.F2fRcvVoiceListener", "play isBackground");
        if (paramc.tVb)
        {
          com.tencent.mm.plugin.report.service.h.IzE.a(14404, new Object[] { Integer.valueOf(2), paramc.fyd, "", "", Integer.valueOf(paramc.tUZ), "", "", "", com.tencent.mm.plugin.collect.model.voice.a.cOg().cOn() });
          AppMethodBeat.o(276111);
          return;
        }
        com.tencent.mm.plugin.report.service.h.IzE.a(14404, new Object[] { Integer.valueOf(2), paramc.fyd, "", "", Integer.valueOf(paramc.tUZ) });
        AppMethodBeat.o(276111);
      }
    });
    AppMethodBeat.o(63804);
  }
  
  private void aN(int paramInt, String paramString)
  {
    AppMethodBeat.i(63808);
    Log.i("MicroMsg.F2fRcvVoiceListener", "play default sound only");
    c localc = new c((byte)0);
    localc.tUZ = paramInt;
    localc.fyd = paramString;
    this.tUL.add(localc);
    cNW();
    AppMethodBeat.o(63808);
  }
  
  private boolean asA(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(63800);
        boolean bool;
        if (Util.isNullOrNil(paramString))
        {
          Log.w("MicroMsg.F2fRcvVoiceListener", "illegal no: %s, not do play", new Object[] { paramString });
          AppMethodBeat.o(63800);
          bool = true;
          return bool;
        }
        List localList = cNU();
        Iterator localIterator = cNU().iterator();
        if (localIterator.hasNext())
        {
          if (((String)localIterator.next()).equals(paramString))
          {
            Log.i("MicroMsg.F2fRcvVoiceListener", "has played tradeno: %s", new Object[] { paramString });
            AppMethodBeat.o(63800);
            bool = true;
          }
        }
        else
        {
          localList.add(paramString);
          if (localList.size() > 10)
          {
            Log.i("MicroMsg.F2fRcvVoiceListener", "over max size, do remove");
            int i = localList.size();
            paramString = localList.subList(i - 10, i);
            com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vuz, Util.listToString(paramString, ","));
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
  
  private static int asB(String paramString)
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
  
  private List<String> cNU()
  {
    AppMethodBeat.i(63799);
    if ((this.tUP == null) || (this.tUP.get() == null))
    {
      Log.i("MicroMsg.F2fRcvVoiceListener", "refer is null");
      this.tUP = new WeakReference(new ArrayList(Util.stringToList((String)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.Vuz, ""), ",")));
    }
    List localList = (List)this.tUP.get();
    AppMethodBeat.o(63799);
    return localList;
  }
  
  public static boolean cNV()
  {
    AppMethodBeat.i(63802);
    Log.i("MicroMsg.F2fRcvVoiceListener", "delete files");
    boolean bool = u.deleteDir(cNZ());
    AppMethodBeat.o(63802);
    return bool;
  }
  
  private void cNW()
  {
    for (;;)
    {
      final c localc;
      try
      {
        AppMethodBeat.i(63803);
        long l1 = System.currentTimeMillis();
        long l2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vUZ, 10000L);
        Log.i("MicroMsg.F2fRcvVoiceListener", "voiceOvertime: %s", new Object[] { Long.valueOf(l2) });
        if ((this.fGh) && (l1 - this.tUO > l2))
        {
          Log.i("MicroMsg.F2fRcvVoiceListener", "last has outdate: %s", new Object[] { Long.valueOf(this.tUO) });
          com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(1143L, 42L, 1L, false);
          this.fGh = false;
        }
        if (this.fGh)
        {
          Log.i("MicroMsg.F2fRcvVoiceListener", "is playing, return");
          AppMethodBeat.o(63803);
          return;
        }
        this.fGh = true;
        this.tUO = System.currentTimeMillis();
        localc = (c)this.tUL.poll();
        i = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(3);
        this.tUM = com.tencent.mm.plugin.audio.c.a.getStreamVolume(3);
        this.tUN = Math.round(i * 0.5F);
        Log.i("MicroMsg.F2fRcvVoiceListener", "curVol: %s, maxVol: %s, minVol: %s", new Object[] { Integer.valueOf(this.tUM), Integer.valueOf(i), Integer.valueOf(this.tUN) });
        if (Build.VERSION.SDK_INT < 23) {
          break label701;
        }
        bool = com.tencent.mm.plugin.audio.c.a.crs();
        Log.i("MicroMsg.F2fRcvVoiceListener", "isMute: %s", new Object[] { Boolean.valueOf(bool) });
        if ((this.tUM == 0) || (bool))
        {
          Log.i("MicroMsg.F2fRcvVoiceListener", "music channel is mute");
          if (localc != null)
          {
            i = localc.tUZ;
            com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
            if (localc == null) {
              break label468;
            }
            String str1 = localc.fyd;
            localh.a(14404, new Object[] { Integer.valueOf(3), str1, Integer.valueOf(5), "", Integer.valueOf(i) });
          }
        }
        else
        {
          if ((this.tUM > 0) && (this.tUM < this.tUN) && (!bool)) {
            com.tencent.mm.plugin.audio.c.a.fp(3, this.tUN);
          }
          if (localc == null) {
            break label687;
          }
          Log.i("MicroMsg.F2fRcvVoiceListener", "holder.offLine = %s", new Object[] { Boolean.valueOf(localc.tVb) });
          if (!localc.tVb) {
            break label493;
          }
          a(localc);
          if ((!this.fGh) || (this.tUK != null)) {
            break label476;
          }
          Log.i("MicroMsg.F2fRcvVoiceListener", "isPlaying && moneyPlayer == null");
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
      Log.i("MicroMsg.F2fRcvVoiceListener", "has played");
      AppMethodBeat.o(63803);
      continue;
      label493:
      int i = a.i.collect_prefix_voice;
      int j = localc.tUZ;
      if (j == 2) {
        i = a.i.collect_prefix_voice;
      }
      if (!Util.isNullOrNil(localc.fileName))
      {
        Log.i("MicroMsg.F2fRcvVoiceListener", "play prefix voice: %d", new Object[] { Integer.valueOf(j) });
        this.tUJ = a.a(MMApplicationContext.getContext(), i, new MediaPlayer.OnCompletionListener()new MediaPlayer.OnErrorListener
        {
          public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            AppMethodBeat.i(63784);
            Log.i("MicroMsg.F2fRcvVoiceListener", "start play money");
            if ((g.a(g.this) != null) && (g.b(g.this)) && (g.c(g.this) == null)) {
              g.a(g.this, localc);
            }
            for (;;)
            {
              g.d(g.this);
              AppMethodBeat.o(63784);
              return;
              Log.i("MicroMsg.F2fRcvVoiceListener", "has played");
            }
          }
        }, new MediaPlayer.OnErrorListener()
        {
          public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(63785);
            Log.e("MicroMsg.F2fRcvVoiceListener", "prefix play error");
            g.e(g.this);
            g.d(g.this);
            g.f(g.this);
            com.tencent.mm.plugin.report.service.h.IzE.a(14404, new Object[] { Integer.valueOf(3), localc.fyd, Integer.valueOf(7), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(localc.tUZ) });
            if (!g.g(g.this).isEmpty()) {
              g.h(g.this);
            }
            for (;;)
            {
              AppMethodBeat.o(63785);
              return false;
              g.cOa();
            }
          }
        });
        if (this.tUJ != null)
        {
          i = this.tUJ.getDuration();
          Log.i("MicroMsg.F2fRcvVoiceListener", "prefix duration: %s", new Object[] { Integer.valueOf(i) });
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(63786);
              if ((g.a(g.this) != null) && (g.b(g.this)) && (g.c(g.this) == null))
              {
                Log.i("MicroMsg.F2fRcvVoiceListener", "this play may error");
                com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(699L, 1L, 1L, false);
              }
              AppMethodBeat.o(63786);
            }
          }, i + 1000);
          AppMethodBeat.o(63803);
        }
      }
      else
      {
        this.tUJ = a.a(MMApplicationContext.getContext(), i, new MediaPlayer.OnCompletionListener()new MediaPlayer.OnErrorListener
        {
          public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            AppMethodBeat.i(63787);
            Log.i("MicroMsg.F2fRcvVoiceListener", "no need to play money this time");
            g.f(g.this);
            g.e(g.this);
            g.d(g.this);
            com.tencent.mm.plugin.collect.a.a.cNP();
            com.tencent.mm.plugin.report.service.h.IzE.a(14404, new Object[] { Integer.valueOf(4), localc.fyd, "", "", Integer.valueOf(localc.tUZ) });
            if (!g.g(g.this).isEmpty())
            {
              g.h(g.this);
              AppMethodBeat.o(63787);
              return;
            }
            g.cOa();
            AppMethodBeat.o(63787);
          }
        }, new MediaPlayer.OnErrorListener()
        {
          public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(63788);
            Log.e("MicroMsg.F2fRcvVoiceListener", "no need play money error");
            g.f(g.this);
            g.e(g.this);
            g.d(g.this);
            com.tencent.mm.plugin.report.service.h.IzE.a(14404, new Object[] { Integer.valueOf(3), localc.fyd, Integer.valueOf(7), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(localc.tUZ) });
            AppMethodBeat.o(63788);
            return false;
          }
        });
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(699L, 2L, 1L, false);
      }
      AppMethodBeat.o(63803);
      continue;
      label687:
      this.fGh = false;
      AppMethodBeat.o(63803);
      continue;
      label701:
      boolean bool = false;
    }
  }
  
  private static MediaPlayer cNX()
  {
    AppMethodBeat.i(277255);
    final Object localObject1 = Looper.myLooper();
    Log.i("MicroMsg.F2fRcvVoiceListener", "[syncCreatePlayer] %s", new Object[] { localObject1 });
    if ((localObject1 != null) && (localObject1 != Looper.getMainLooper()) && (localObject1 != tUT.getLooper()))
    {
      if (!tUT.isAlive()) {
        tUT.start();
      }
      MMHandler localMMHandler = new MMHandler(tUT.getLooper());
      localObject1 = new Object();
      MediaPlayer[] arrayOfMediaPlayer = new MediaPlayer[1];
      arrayOfMediaPlayer[0] = null;
      try
      {
        localMMHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(261910);
            this.tUW[0] = new k();
            try
            {
              synchronized (localObject1)
              {
                localObject1.notify();
                AppMethodBeat.o(261910);
                return;
              }
              return;
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", localException, "", new Object[0]);
              AppMethodBeat.o(261910);
            }
          }
        });
        try
        {
          localObject1.wait();
          localObject1 = arrayOfMediaPlayer[0];
          AppMethodBeat.o(277255);
          return localObject1;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            Log.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", localInterruptedException, "", new Object[0]);
          }
        }
        localObject1 = new k();
      }
      finally
      {
        AppMethodBeat.o(277255);
      }
    }
    AppMethodBeat.o(277255);
    return localObject1;
  }
  
  private static int cNY()
  {
    AppMethodBeat.i(63811);
    if (com.tencent.mm.plugin.audio.c.a.cro())
    {
      AppMethodBeat.o(63811);
      return 1;
    }
    AppMethodBeat.o(63811);
    return 0;
  }
  
  private static String cNZ()
  {
    AppMethodBeat.i(63812);
    String str = com.tencent.mm.loader.j.b.aSL() + "wallet/voice/";
    AppMethodBeat.o(63812);
    return str;
  }
  
  private static boolean p(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63801);
    com.tencent.mm.kernel.h.aHH();
    if (!com.tencent.mm.kernel.h.aHG().isSDCardAvailable())
    {
      Log.i("MicroMsg.F2fRcvVoiceListener", "sd card not available");
      AppMethodBeat.o(63801);
      return false;
    }
    if (u.H(paramString, paramArrayOfByte) == 0)
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
    Log.i("MicroMsg.F2fRcvVoiceListener", "errorCode:%s outTradeNo:%s type:%s content:%s packId:%s overtimeFlag:%s", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, paramString4, Integer.valueOf(0) });
    int i = asB(paramString2);
    paramString2 = (cm)this.tUR.remove(paramString1);
    if (paramInt1 < 0)
    {
      if (paramString2 != null) {
        if (paramString2.fyb.fyh) {
          a(paramString2, false, true);
        }
      }
      for (;;)
      {
        a(6, paramString1, i, paramString3, paramInt2, paramString4, 9);
        AppMethodBeat.o(63806);
        return;
        Log.i("MicroMsg.F2fRcvVoiceListener", "onGetResult() needFailover:false");
        continue;
        aN(i, paramString1);
      }
    }
    a(i, paramArrayOfByte, 1, paramString1, 0, true);
    a(5, paramString1, i, paramString3, paramInt2, paramString4, 0);
    AppMethodBeat.o(63806);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(63805);
    Log.i("MicroMsg.F2fRcvVoiceListener", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    if ((paramq instanceof i))
    {
      paramq = (i)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i("MicroMsg.F2fRcvVoiceListener", "overtime: %s retcode: %s", new Object[] { Integer.valueOf(paramq.tVe.Sis), Integer.valueOf(paramq.tVe.fwx) });
        if (paramq.tVe.Sis == 1)
        {
          Log.w("MicroMsg.F2fRcvVoiceListener", "skip over 10min: %s", new Object[] { Long.valueOf(paramq.delay) });
          com.tencent.mm.plugin.report.service.h.IzE.a(14404, new Object[] { Integer.valueOf(3), paramq.fyd, Integer.valueOf(1), "", Integer.valueOf(1) });
          AppMethodBeat.o(63805);
          return;
        }
        if ((paramq.tVe.fwx == 0) && (paramq.tVe.Sir != null))
        {
          a(1, paramq.tVe.Sir.UH, paramq.tVe.Scm, paramq.fyd, paramq.tVe.Sis, false);
          com.tencent.mm.plugin.report.service.h.IzE.a(15763, new Object[] { paramq.fyd, Integer.valueOf(1), Integer.valueOf(IK(paramq.source)), Long.valueOf(paramq.tVf), Integer.valueOf(cNY()) });
          AppMethodBeat.o(63805);
          return;
        }
        if (paramq.tVe.fwx <= 100)
        {
          paramInt1 = paramq.tVe.fwx;
          if (paramq.tVe.Sir == null) {}
          for (paramString = "null";; paramString = "not null")
          {
            Log.i("MicroMsg.F2fRcvVoiceListener", "play default sound only %s %s", new Object[] { Integer.valueOf(paramInt1), paramString });
            aN(1, paramq.fyd);
            com.tencent.mm.plugin.report.service.h.IzE.a(15763, new Object[] { paramq.fyd, Integer.valueOf(2), Integer.valueOf(IK(paramq.source)), Long.valueOf(paramq.tVf), Integer.valueOf(cNY()) });
            AppMethodBeat.o(63805);
            return;
          }
        }
        Log.i("MicroMsg.F2fRcvVoiceListener", "retcode > 100, still play default sound");
        aN(1, paramq.fyd);
        com.tencent.mm.plugin.report.service.h.IzE.a(14404, new Object[] { Integer.valueOf(3), paramq.fyd, Integer.valueOf(2), "", Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.h.IzE.a(15763, new Object[] { paramq.fyd, Integer.valueOf(2), Integer.valueOf(IK(paramq.source)), Long.valueOf(paramq.tVf), Integer.valueOf(cNY()) });
        AppMethodBeat.o(63805);
        return;
      }
      Log.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", new Object[] { paramq });
      aN(1, paramq.fyd);
      com.tencent.mm.plugin.report.service.h.IzE.a(15763, new Object[] { paramq.fyd, Integer.valueOf(2), Integer.valueOf(IK(paramq.source)), Long.valueOf(paramq.tVf), Integer.valueOf(cNY()) });
      com.tencent.mm.plugin.report.service.h.IzE.a(14404, new Object[] { Integer.valueOf(3), paramq.fyd, Integer.valueOf(3), "", Integer.valueOf(1) });
      AppMethodBeat.o(63805);
      return;
    }
    if ((paramq instanceof p))
    {
      paramString = (p)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.tVB.fwx == 0)
        {
          paramq = new com.tencent.mm.vfs.q(cNZ());
          if ((!paramq.ifE()) && (!paramq.ifL()))
          {
            Log.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
            AppMethodBeat.o(63805);
            return;
          }
          paramq = cNZ() + UUID.randomUUID().toString() + ".tmp";
          Log.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", new Object[] { paramq });
          if (p(paramq, paramString.tVB.Sir.UH))
          {
            c localc = new c((byte)0);
            localc.fileName = paramq;
            localc.fEi = paramString.tVB.Scm;
            localc.tUZ = 2;
            this.tUL.add(localc);
            cNW();
            AppMethodBeat.o(63805);
            return;
          }
          Log.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
          AppMethodBeat.o(63805);
          return;
        }
        com.tencent.mm.plugin.report.service.h.IzE.a(14404, new Object[] { Integer.valueOf(3), paramString.fyd, Integer.valueOf(2), "", Integer.valueOf(2) });
        AppMethodBeat.o(63805);
        return;
      }
      Log.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.h.IzE.a(14404, new Object[] { Integer.valueOf(3), paramString.fyd, Integer.valueOf(3), "", Integer.valueOf(2) });
    }
    AppMethodBeat.o(63805);
  }
  
  static final class a
  {
    /* Error */
    public static MediaPlayer a(android.content.Context paramContext, int paramInt, final MediaPlayer.OnCompletionListener paramOnCompletionListener, final MediaPlayer.OnErrorListener paramOnErrorListener)
    {
      // Byte code:
      //   0: ldc 21
      //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: ifnonnull +32 -> 38
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
      //   23: iload_1
      //   24: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   27: aastore
      //   28: invokestatic 43	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   31: ldc 21
      //   33: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   36: aconst_null
      //   37: areturn
      //   38: aload_0
      //   39: iload_1
      //   40: invokevirtual 52	android/content/Context:getString	(I)Ljava/lang/String;
      //   43: astore 9
      //   45: invokestatic 56	com/tencent/mm/plugin/collect/model/g:cOb	()Landroid/media/MediaPlayer;
      //   48: astore 8
      //   50: aload 8
      //   52: iconst_3
      //   53: invokevirtual 61	android/media/MediaPlayer:setAudioStreamType	(I)V
      //   56: ldc 29
      //   58: ldc 63
      //   60: iconst_4
      //   61: anewarray 4	java/lang/Object
      //   64: dup
      //   65: iconst_0
      //   66: aload 8
      //   68: invokevirtual 67	java/lang/Object:hashCode	()I
      //   71: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   74: aastore
      //   75: dup
      //   76: iconst_1
      //   77: aload 9
      //   79: aastore
      //   80: dup
      //   81: iconst_2
      //   82: aload_0
      //   83: aastore
      //   84: dup
      //   85: iconst_3
      //   86: iload_1
      //   87: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   90: aastore
      //   91: invokestatic 69	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   94: aconst_null
      //   95: astore 7
      //   97: aload_0
      //   98: invokevirtual 73	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
      //   101: aload 9
      //   103: invokevirtual 79	android/content/res/AssetManager:openFd	(Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
      //   106: astore_0
      //   107: aload 8
      //   109: aload_0
      //   110: invokevirtual 85	android/content/res/AssetFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
      //   113: aload_0
      //   114: invokevirtual 89	android/content/res/AssetFileDescriptor:getStartOffset	()J
      //   117: aload_0
      //   118: invokevirtual 92	android/content/res/AssetFileDescriptor:getLength	()J
      //   121: invokevirtual 96	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;JJ)V
      //   124: aload 8
      //   126: iconst_0
      //   127: invokevirtual 100	android/media/MediaPlayer:setLooping	(Z)V
      //   130: aload 8
      //   132: new 9	com/tencent/mm/plugin/collect/model/g$a$1
      //   135: dup
      //   136: aload 8
      //   138: aload_3
      //   139: invokespecial 104	com/tencent/mm/plugin/collect/model/g$a$1:<init>	(Landroid/media/MediaPlayer;Landroid/media/MediaPlayer$OnErrorListener;)V
      //   142: invokevirtual 108	android/media/MediaPlayer:setOnErrorListener	(Landroid/media/MediaPlayer$OnErrorListener;)V
      //   145: aload 8
      //   147: new 11	com/tencent/mm/plugin/collect/model/g$a$2
      //   150: dup
      //   151: aload 9
      //   153: aload 8
      //   155: aload_2
      //   156: invokespecial 111	com/tencent/mm/plugin/collect/model/g$a$2:<init>	(Ljava/lang/String;Landroid/media/MediaPlayer;Landroid/media/MediaPlayer$OnCompletionListener;)V
      //   159: invokevirtual 115	android/media/MediaPlayer:setOnCompletionListener	(Landroid/media/MediaPlayer$OnCompletionListener;)V
      //   162: aload 8
      //   164: invokevirtual 119	android/media/MediaPlayer:prepare	()V
      //   167: aload 8
      //   169: invokevirtual 122	android/media/MediaPlayer:start	()V
      //   172: aload 8
      //   174: invokevirtual 67	java/lang/Object:hashCode	()I
      //   177: istore 4
      //   179: invokestatic 128	android/os/Looper:myLooper	()Landroid/os/Looper;
      //   182: ifnull +66 -> 248
      //   185: iconst_1
      //   186: istore 5
      //   188: invokestatic 131	android/os/Looper:getMainLooper	()Landroid/os/Looper;
      //   191: ifnull +63 -> 254
      //   194: iconst_1
      //   195: istore 6
      //   197: ldc 29
      //   199: ldc 133
      //   201: iconst_3
      //   202: anewarray 4	java/lang/Object
      //   205: dup
      //   206: iconst_0
      //   207: iload 4
      //   209: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   212: aastore
      //   213: dup
      //   214: iconst_1
      //   215: iload 5
      //   217: invokestatic 138	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   220: aastore
      //   221: dup
      //   222: iconst_2
      //   223: iload 6
      //   225: invokestatic 138	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   228: aastore
      //   229: invokestatic 69	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   232: aload_0
      //   233: ifnull +7 -> 240
      //   236: aload_0
      //   237: invokevirtual 141	android/content/res/AssetFileDescriptor:close	()V
      //   240: ldc 21
      //   242: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   245: aload 8
      //   247: areturn
      //   248: iconst_0
      //   249: istore 5
      //   251: goto -63 -> 188
      //   254: iconst_0
      //   255: istore 6
      //   257: goto -60 -> 197
      //   260: astore_0
      //   261: ldc 29
      //   263: aload_0
      //   264: ldc 143
      //   266: iconst_0
      //   267: anewarray 4	java/lang/Object
      //   270: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   273: goto -33 -> 240
      //   276: astore_2
      //   277: aload 7
      //   279: astore_0
      //   280: ldc 29
      //   282: ldc 149
      //   284: iconst_2
      //   285: anewarray 4	java/lang/Object
      //   288: dup
      //   289: iconst_0
      //   290: iload_1
      //   291: invokestatic 37	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   294: aastore
      //   295: dup
      //   296: iconst_1
      //   297: aload_2
      //   298: invokevirtual 153	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   301: aastore
      //   302: invokestatic 43	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   305: ldc 29
      //   307: aload_2
      //   308: ldc 143
      //   310: iconst_0
      //   311: anewarray 4	java/lang/Object
      //   314: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   317: aload 8
      //   319: ifnull +8 -> 327
      //   322: aload 8
      //   324: invokevirtual 156	android/media/MediaPlayer:release	()V
      //   327: aload_0
      //   328: ifnull +7 -> 335
      //   331: aload_0
      //   332: invokevirtual 141	android/content/res/AssetFileDescriptor:close	()V
      //   335: ldc 21
      //   337: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   340: aconst_null
      //   341: areturn
      //   342: astore_0
      //   343: ldc 29
      //   345: aload_0
      //   346: ldc 143
      //   348: iconst_0
      //   349: anewarray 4	java/lang/Object
      //   352: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   355: goto -20 -> 335
      //   358: astore_2
      //   359: aconst_null
      //   360: astore_0
      //   361: aload_0
      //   362: ifnull +7 -> 369
      //   365: aload_0
      //   366: invokevirtual 141	android/content/res/AssetFileDescriptor:close	()V
      //   369: ldc 21
      //   371: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   374: aload_2
      //   375: athrow
      //   376: astore_0
      //   377: ldc 29
      //   379: aload_0
      //   380: ldc 143
      //   382: iconst_0
      //   383: anewarray 4	java/lang/Object
      //   386: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
      //   389: goto -20 -> 369
      //   392: astore_2
      //   393: goto -32 -> 361
      //   396: astore_2
      //   397: goto -36 -> 361
      //   400: astore_2
      //   401: goto -121 -> 280
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	404	0	paramContext	android.content.Context
      //   0	404	1	paramInt	int
      //   0	404	2	paramOnCompletionListener	MediaPlayer.OnCompletionListener
      //   0	404	3	paramOnErrorListener	MediaPlayer.OnErrorListener
      //   177	31	4	i	int
      //   186	64	5	bool1	boolean
      //   195	61	6	bool2	boolean
      //   95	183	7	localObject	Object
      //   48	275	8	localMediaPlayer	MediaPlayer
      //   43	109	9	str	String
      // Exception table:
      //   from	to	target	type
      //   236	240	260	java/io/IOException
      //   97	107	276	java/lang/Exception
      //   331	335	342	java/io/IOException
      //   97	107	358	finally
      //   365	369	376	java/io/IOException
      //   107	185	392	finally
      //   188	194	392	finally
      //   197	232	392	finally
      //   280	317	396	finally
      //   322	327	396	finally
      //   107	185	400	java/lang/Exception
      //   188	194	400	java/lang/Exception
      //   197	232	400	java/lang/Exception
    }
    
    public static MediaPlayer a(String paramString, final MediaPlayer.OnCompletionListener paramOnCompletionListener, final MediaPlayer.OnErrorListener paramOnErrorListener, g.b paramb)
    {
      AppMethodBeat.i(277090);
      final MediaPlayer localMediaPlayer = g.cOb();
      localMediaPlayer.setAudioStreamType(3);
      Log.i("MicroMsg.F2fRcvVoiceListener", "play start mp:%d path:%s", new Object[] { Integer.valueOf(localMediaPlayer.hashCode()), paramString });
      try
      {
        localMediaPlayer.setDataSource(paramString);
        localMediaPlayer.setLooping(false);
        localMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener()
        {
          public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(63793);
            Log.i("MicroMsg.F2fRcvVoiceListener", "onError, what: %d, extra: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            if (paramAnonymousMediaPlayer != null) {}
            try
            {
              paramAnonymousMediaPlayer.release();
              if (this.val$player != null) {
                this.val$player.release();
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
              Log.i("MicroMsg.F2fRcvVoiceListener", "play completion mp:%d  path:%s", new Object[] { Integer.valueOf(i), this.val$path });
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
        paramb.cOc();
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
          Log.i("MicroMsg.F2fRcvVoiceListener", "play start mp finish [%d], myLooper[%b] mainLooper[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          AppMethodBeat.o(277090);
          return localMediaPlayer;
          bool1 = false;
          break;
        }
        return null;
      }
      catch (Exception paramOnCompletionListener)
      {
        Log.e("MicroMsg.F2fRcvVoiceListener", "play failed path:%s e:%s", new Object[] { paramString, paramOnCompletionListener.getMessage() });
        Log.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", paramOnCompletionListener, "", new Object[0]);
        if (localMediaPlayer != null) {
          localMediaPlayer.release();
        }
        AppMethodBeat.o(277090);
      }
    }
  }
  
  static abstract interface b<T>
  {
    public abstract void cOc();
  }
  
  final class c
  {
    int fEi;
    String fileName;
    String fyd;
    int tUZ;
    int tVa = 0;
    boolean tVb = false;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.g
 * JD-Core Version:    0.7.0.1
 */