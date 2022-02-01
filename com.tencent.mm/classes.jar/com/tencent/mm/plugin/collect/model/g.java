package com.tencent.mm.plugin.collect.model;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.f.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.g.a.ci;
import com.tencent.mm.g.a.ci.a;
import com.tencent.mm.g.b.a.ku;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.collect.model.voice.a.c;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.vx;
import com.tencent.mm.protocal.protobuf.wg;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class g
  extends IListener<ci>
  implements com.tencent.mm.ak.i, a.c
{
  private static final com.tencent.mm.bw.b qvJ;
  private static HandlerThread qvU;
  private boolean gVd;
  private MediaPlayer qvK;
  private MediaPlayer qvL;
  public ConcurrentLinkedQueue<c> qvM;
  private int qvN;
  private int qvO;
  private long qvP;
  private WeakReference<ArrayList<String>> qvQ;
  private ku qvR;
  private Map<String, ci> qvS;
  private final long qvT;
  
  static
  {
    AppMethodBeat.i(63818);
    qvJ = com.tencent.mm.bw.b.bfZ("元");
    qvU = d.hB("syncCreatePlayer", 5);
    AppMethodBeat.o(63818);
  }
  
  public g()
  {
    AppMethodBeat.i(63797);
    this.gVd = false;
    this.qvS = new HashMap();
    this.qvT = 10000L;
    this.__eventId = ci.class.getName().hashCode();
    AppMethodBeat.o(63797);
  }
  
  private static int Fc(int paramInt)
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
    this.qvR = new ku();
    this.qvR.erW = paramInt1;
    this.qvR.ym(paramString1);
    if (!Util.isEqual(paramInt4, 0)) {
      this.qvR.eXr = paramInt4;
    }
    this.qvR.evl = paramInt2;
    this.qvR.yn(paramString2);
    this.qvR.eXv = paramInt3;
    if (Util.isEqual(paramInt1, 6)) {
      this.qvR.yo(paramString3);
    }
    this.qvR.bfK();
    AppMethodBeat.o(63810);
  }
  
  private void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(63807);
    Object localObject = new com.tencent.mm.vfs.o(czz());
    if ((!((com.tencent.mm.vfs.o)localObject).exists()) && (!((com.tencent.mm.vfs.o)localObject).mkdirs()))
    {
      Log.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
      AppMethodBeat.o(63807);
      return;
    }
    localObject = czz() + UUID.randomUUID().toString() + ".tmp";
    Log.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", new Object[] { localObject });
    if (m((String)localObject, paramArrayOfByte))
    {
      paramArrayOfByte = new c((byte)0);
      paramArrayOfByte.fileName = ((String)localObject);
      paramArrayOfByte.dLt = paramInt2;
      paramArrayOfByte.qwa = paramInt1;
      paramArrayOfByte.dFw = paramString;
      paramArrayOfByte.qwb = paramInt3;
      paramArrayOfByte.qwc = paramBoolean;
      this.qvM.add(paramArrayOfByte);
      czw();
      AppMethodBeat.o(63807);
      return;
    }
    Log.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
    AppMethodBeat.o(63807);
  }
  
  private void a(ci paramci, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(63798);
    Log.i("MicroMsg.F2fRcvVoiceListener", "callbackImp() tradeNo:%s useOffline:%s", new Object[] { paramci.dFt.dFw, Boolean.valueOf(paramBoolean1) });
    long l = paramci.dFt.gY;
    if (paramci.dFt.dFx.equals("wx_f2f"))
    {
      com.tencent.mm.plugin.collect.a.a.czp();
      boolean bool = com.tencent.mm.plugin.collect.a.a.czr();
      Log.i("MicroMsg.F2fRcvVoiceListener", "on recv, fee: %s, voice open: %B", new Object[] { Integer.valueOf(paramci.dFt.dFu), Boolean.valueOf(bool) });
      if ((paramBoolean2) || (!akL(paramci.dFt.dFw)))
      {
        if (paramci.dFt.source == 0) {
          h.CyF.idkeyStat(699L, 8L, 1L, false);
        }
        for (;;)
        {
          if ((paramBoolean1) && (!com.tencent.mm.plugin.collect.model.voice.a.qwT) && (!Util.isNullOrNil(paramci.dFt.dFy)))
          {
            Log.i("MicroMsg.F2fRcvVoiceListener", "init tts");
            com.tencent.mm.plugin.collect.model.voice.a.czG().kN(false);
          }
          if ((!paramBoolean1) || (!com.tencent.mm.plugin.collect.model.voice.a.qwT) || (Util.isNullOrNil(paramci.dFt.dFy))) {
            break;
          }
          Log.i("MicroMsg.F2fRcvVoiceListener", "useOffline");
          this.qvS.put(paramci.dFt.dFw, paramci);
          com.tencent.mm.plugin.collect.model.voice.a.czG().a(paramci);
          AppMethodBeat.o(63798);
          return;
          h.CyF.idkeyStat(699L, 9L, 1L, false);
        }
        Log.i("MicroMsg.F2fRcvVoiceListener", "useOnline");
        paramci = new i(paramci.dFt.dFu, qvJ, paramci.dFt.dFw, paramci.dFt.source, l);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(paramci, 0);
      }
      AppMethodBeat.o(63798);
      return;
    }
    if (paramci.dFt.dFx.equals("wx_md"))
    {
      if ((paramBoolean1) && (com.tencent.mm.plugin.collect.model.voice.a.qwT) && (!Util.isNullOrNil(paramci.dFt.dFy)))
      {
        this.qvS.put(paramci.dFt.dFw, paramci);
        com.tencent.mm.plugin.collect.model.voice.a.czG().a(paramci);
        AppMethodBeat.o(63798);
        return;
      }
      paramci = new o(paramci.dFt.dFu, qvJ, paramci.dFt.dFw);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAg().hqi.a(paramci, 0);
      AppMethodBeat.o(63798);
      return;
    }
    Log.w("MicroMsg.F2fRcvVoiceListener", "unknown type: %s", new Object[] { paramci.dFt.dFx });
    AppMethodBeat.o(63798);
  }
  
  private void a(final c paramc)
  {
    AppMethodBeat.i(63804);
    this.qvL = a.a(paramc.fileName, new MediaPlayer.OnCompletionListener()new MediaPlayer.OnErrorListener
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
        g.czA();
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
        h.CyF.a(14404, new Object[] { Integer.valueOf(3), paramc.dFw, Integer.valueOf(7), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramc.qwa) });
        g.f(g.this);
        if (!g.g(g.this).isEmpty()) {
          g.h(g.this);
        }
        for (;;)
        {
          AppMethodBeat.o(63790);
          return false;
          g.czA();
        }
      }
    }, new b()
    {
      public final void czC()
      {
        AppMethodBeat.i(213145);
        h.CyF.idkeyStat(1143L, 41L, 1L, false);
        if (com.tencent.mm.plugin.collect.a.a.czp().qvz)
        {
          Log.i("MicroMsg.F2fRcvVoiceListener", "play isForground");
          if (paramc.qwc)
          {
            h.CyF.a(14404, new Object[] { Integer.valueOf(1), paramc.dFw, "", "", Integer.valueOf(paramc.qwa), "", "", "", com.tencent.mm.plugin.collect.model.voice.a.czG().czN() });
            AppMethodBeat.o(213145);
            return;
          }
          h.CyF.a(14404, new Object[] { Integer.valueOf(1), paramc.dFw, "", "", Integer.valueOf(paramc.qwa) });
          AppMethodBeat.o(213145);
          return;
        }
        Log.i("MicroMsg.F2fRcvVoiceListener", "play isBackground");
        if (paramc.qwc)
        {
          h.CyF.a(14404, new Object[] { Integer.valueOf(2), paramc.dFw, "", "", Integer.valueOf(paramc.qwa), "", "", "", com.tencent.mm.plugin.collect.model.voice.a.czG().czN() });
          AppMethodBeat.o(213145);
          return;
        }
        h.CyF.a(14404, new Object[] { Integer.valueOf(2), paramc.dFw, "", "", Integer.valueOf(paramc.qwa) });
        AppMethodBeat.o(213145);
      }
    });
    AppMethodBeat.o(63804);
  }
  
  private void aO(int paramInt, String paramString)
  {
    AppMethodBeat.i(63808);
    Log.i("MicroMsg.F2fRcvVoiceListener", "play default sound only");
    c localc = new c((byte)0);
    localc.qwa = paramInt;
    localc.dFw = paramString;
    this.qvM.add(localc);
    czw();
    AppMethodBeat.o(63808);
  }
  
  private boolean akL(String paramString)
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
        List localList = czu();
        Iterator localIterator = czu().iterator();
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
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ogj, Util.listToString(paramString, ","));
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
  
  private static int akM(String paramString)
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
  
  private List<String> czu()
  {
    AppMethodBeat.i(63799);
    if ((this.qvQ == null) || (this.qvQ.get() == null))
    {
      Log.i("MicroMsg.F2fRcvVoiceListener", "refer is null");
      this.qvQ = new WeakReference(new ArrayList(Util.stringToList((String)com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.Ogj, ""), ",")));
    }
    List localList = (List)this.qvQ.get();
    AppMethodBeat.o(63799);
    return localList;
  }
  
  public static boolean czv()
  {
    AppMethodBeat.i(63802);
    Log.i("MicroMsg.F2fRcvVoiceListener", "delete files");
    boolean bool = s.dy(czz(), true);
    AppMethodBeat.o(63802);
    return bool;
  }
  
  private void czw()
  {
    for (;;)
    {
      final c localc;
      try
      {
        AppMethodBeat.i(63803);
        long l1 = System.currentTimeMillis();
        long l2 = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.skA, 10000L);
        Log.i("MicroMsg.F2fRcvVoiceListener", "voiceOvertime: %s", new Object[] { Long.valueOf(l2) });
        if ((this.gVd) && (l1 - this.qvP > l2))
        {
          Log.i("MicroMsg.F2fRcvVoiceListener", "last has outdate: %s", new Object[] { Long.valueOf(this.qvP) });
          h.CyF.idkeyStat(1143L, 42L, 1L, false);
          this.gVd = false;
        }
        if (this.gVd)
        {
          Log.i("MicroMsg.F2fRcvVoiceListener", "is playing, return");
          AppMethodBeat.o(63803);
          return;
        }
        this.gVd = true;
        this.qvP = System.currentTimeMillis();
        localc = (c)this.qvM.poll();
        i = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(3);
        this.qvN = com.tencent.mm.plugin.audio.c.a.getStreamVolume(3);
        this.qvO = Math.round(i * 0.5F);
        Log.i("MicroMsg.F2fRcvVoiceListener", "curVol: %s, maxVol: %s, minVol: %s", new Object[] { Integer.valueOf(this.qvN), Integer.valueOf(i), Integer.valueOf(this.qvO) });
        if (Build.VERSION.SDK_INT < 23) {
          break label686;
        }
        bool = com.tencent.mm.plugin.audio.c.a.cef();
        Log.i("MicroMsg.F2fRcvVoiceListener", "isMute: %s", new Object[] { Boolean.valueOf(bool) });
        if ((this.qvN == 0) || (bool))
        {
          Log.i("MicroMsg.F2fRcvVoiceListener", "music channel is mute");
          if (localc != null)
          {
            i = localc.qwa;
            h localh = h.CyF;
            if (localc == null) {
              break label468;
            }
            String str1 = localc.dFw;
            localh.a(14404, new Object[] { Integer.valueOf(3), str1, Integer.valueOf(5), "", Integer.valueOf(i) });
          }
        }
        else
        {
          if ((this.qvN > 0) && (this.qvN < this.qvO) && (!bool)) {
            com.tencent.mm.plugin.audio.c.a.eQ(3, this.qvO);
          }
          if (localc == null) {
            break label672;
          }
          Log.i("MicroMsg.F2fRcvVoiceListener", "holder.offLine = %s", new Object[] { Boolean.valueOf(localc.qwc) });
          if (!localc.qwc) {
            break label493;
          }
          a(localc);
          if ((!this.gVd) || (this.qvL != null)) {
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
      int i = localc.qwa;
      if (!Util.isNullOrNil(localc.fileName))
      {
        Log.i("MicroMsg.F2fRcvVoiceListener", "play prefix voice: %d", new Object[] { Integer.valueOf(i) });
        this.qvK = a.a(MMApplicationContext.getContext(), new MediaPlayer.OnCompletionListener()new MediaPlayer.OnErrorListener
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
            h.CyF.a(14404, new Object[] { Integer.valueOf(3), localc.dFw, Integer.valueOf(7), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(localc.qwa) });
            if (!g.g(g.this).isEmpty()) {
              g.h(g.this);
            }
            for (;;)
            {
              AppMethodBeat.o(63785);
              return false;
              g.czA();
            }
          }
        });
        if (this.qvK != null)
        {
          i = this.qvK.getDuration();
          Log.i("MicroMsg.F2fRcvVoiceListener", "prefix duration: %s", new Object[] { Integer.valueOf(i) });
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(63786);
              if ((g.a(g.this) != null) && (g.b(g.this)) && (g.c(g.this) == null))
              {
                Log.i("MicroMsg.F2fRcvVoiceListener", "this play may error");
                h.CyF.idkeyStat(699L, 1L, 1L, false);
              }
              AppMethodBeat.o(63786);
            }
          }, i + 1000);
          AppMethodBeat.o(63803);
        }
      }
      else
      {
        this.qvK = a.a(MMApplicationContext.getContext(), new MediaPlayer.OnCompletionListener()new MediaPlayer.OnErrorListener
        {
          public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            AppMethodBeat.i(63787);
            Log.i("MicroMsg.F2fRcvVoiceListener", "no need to play money this time");
            g.f(g.this);
            g.e(g.this);
            g.d(g.this);
            com.tencent.mm.plugin.collect.a.a.czp();
            h.CyF.a(14404, new Object[] { Integer.valueOf(4), localc.dFw, "", "", Integer.valueOf(localc.qwa) });
            if (!g.g(g.this).isEmpty())
            {
              g.h(g.this);
              AppMethodBeat.o(63787);
              return;
            }
            g.czA();
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
            h.CyF.a(14404, new Object[] { Integer.valueOf(3), localc.dFw, Integer.valueOf(7), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(localc.qwa) });
            AppMethodBeat.o(63788);
            return false;
          }
        });
        h.CyF.idkeyStat(699L, 2L, 1L, false);
      }
      AppMethodBeat.o(63803);
      continue;
      label672:
      this.gVd = false;
      AppMethodBeat.o(63803);
      continue;
      label686:
      boolean bool = false;
    }
  }
  
  private static MediaPlayer czx()
  {
    AppMethodBeat.i(213148);
    final Object localObject1 = Looper.myLooper();
    Log.i("MicroMsg.F2fRcvVoiceListener", "[syncCreatePlayer] %s", new Object[] { localObject1 });
    if ((localObject1 != null) && (localObject1 != Looper.getMainLooper()) && (localObject1 != qvU.getLooper()))
    {
      if (!qvU.isAlive()) {
        qvU.start();
      }
      MMHandler localMMHandler = new MMHandler(qvU.getLooper());
      localObject1 = new Object();
      MediaPlayer[] arrayOfMediaPlayer = new MediaPlayer[1];
      arrayOfMediaPlayer[0] = null;
      try
      {
        localMMHandler.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(213146);
            this.qvX[0] = new k();
            try
            {
              synchronized (localObject1)
              {
                localObject1.notify();
                AppMethodBeat.o(213146);
                return;
              }
              return;
            }
            catch (Exception localException)
            {
              Log.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", localException, "", new Object[0]);
              AppMethodBeat.o(213146);
            }
          }
        });
        try
        {
          localObject1.wait();
          localObject1 = arrayOfMediaPlayer[0];
          AppMethodBeat.o(213148);
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
        AppMethodBeat.o(213148);
      }
    }
    AppMethodBeat.o(213148);
    return localObject1;
  }
  
  private static int czy()
  {
    AppMethodBeat.i(63811);
    if (com.tencent.mm.plugin.audio.c.a.ceb())
    {
      AppMethodBeat.o(63811);
      return 1;
    }
    AppMethodBeat.o(63811);
    return 0;
  }
  
  private static String czz()
  {
    AppMethodBeat.i(63812);
    String str = com.tencent.mm.loader.j.b.aKJ() + "wallet/voice/";
    AppMethodBeat.o(63812);
    return str;
  }
  
  private static boolean m(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63801);
    com.tencent.mm.kernel.g.aAi();
    if (!com.tencent.mm.kernel.g.aAh().isSDCardAvailable())
    {
      Log.i("MicroMsg.F2fRcvVoiceListener", "sd card not available");
      AppMethodBeat.o(63801);
      return false;
    }
    if (s.f(paramString, paramArrayOfByte, paramArrayOfByte.length) == 0)
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
    int i = akM(paramString2);
    paramString2 = (ci)this.qvS.remove(paramString1);
    if (paramInt1 < 0)
    {
      if (paramString2 != null) {
        if (paramString2.dFt.dFA) {
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
        aO(i, paramString1);
      }
    }
    a(i, paramArrayOfByte, 1, paramString1, 0, true);
    a(5, paramString1, i, paramString3, paramInt2, paramString4, 0);
    AppMethodBeat.o(63806);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63805);
    Log.i("MicroMsg.F2fRcvVoiceListener", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramq.getType());
    if ((paramq instanceof i))
    {
      paramq = (i)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i("MicroMsg.F2fRcvVoiceListener", "overtime: %s retcode: %s", new Object[] { Integer.valueOf(paramq.qwf.Lhe), Integer.valueOf(paramq.qwf.dDN) });
        if (paramq.qwf.Lhe == 1)
        {
          Log.w("MicroMsg.F2fRcvVoiceListener", "skip over 10min: %s", new Object[] { Long.valueOf(paramq.gY) });
          h.CyF.a(14404, new Object[] { Integer.valueOf(3), paramq.dFw, Integer.valueOf(1), "", Integer.valueOf(1) });
          AppMethodBeat.o(63805);
          return;
        }
        if ((paramq.qwf.dDN == 0) && (paramq.qwf.Lhd != null))
        {
          a(1, paramq.qwf.Lhd.zy, paramq.qwf.Lba, paramq.dFw, paramq.qwf.Lhe, false);
          h.CyF.a(15763, new Object[] { paramq.dFw, Integer.valueOf(1), Integer.valueOf(Fc(paramq.source)), Long.valueOf(paramq.qwg), Integer.valueOf(czy()) });
          AppMethodBeat.o(63805);
          return;
        }
        if (paramq.qwf.dDN <= 100)
        {
          paramInt1 = paramq.qwf.dDN;
          if (paramq.qwf.Lhd == null) {}
          for (paramString = "null";; paramString = "not null")
          {
            Log.i("MicroMsg.F2fRcvVoiceListener", "play default sound only %s %s", new Object[] { Integer.valueOf(paramInt1), paramString });
            aO(1, paramq.dFw);
            h.CyF.a(15763, new Object[] { paramq.dFw, Integer.valueOf(2), Integer.valueOf(Fc(paramq.source)), Long.valueOf(paramq.qwg), Integer.valueOf(czy()) });
            AppMethodBeat.o(63805);
            return;
          }
        }
        Log.w("MicroMsg.F2fRcvVoiceListener", "retcode > 100, don't play");
        h.CyF.a(14404, new Object[] { Integer.valueOf(3), paramq.dFw, Integer.valueOf(2), "", Integer.valueOf(1) });
        h.CyF.a(15763, new Object[] { paramq.dFw, Integer.valueOf(2), Integer.valueOf(Fc(paramq.source)), Long.valueOf(paramq.qwg), Integer.valueOf(czy()) });
        AppMethodBeat.o(63805);
        return;
      }
      Log.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", new Object[] { paramq });
      aO(1, paramq.dFw);
      h.CyF.a(15763, new Object[] { paramq.dFw, Integer.valueOf(2), Integer.valueOf(Fc(paramq.source)), Long.valueOf(paramq.qwg), Integer.valueOf(czy()) });
      h.CyF.a(14404, new Object[] { Integer.valueOf(3), paramq.dFw, Integer.valueOf(3), "", Integer.valueOf(1) });
      AppMethodBeat.o(63805);
      return;
    }
    if ((paramq instanceof o))
    {
      paramString = (o)paramq;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.qwA.dDN == 0)
        {
          paramq = new com.tencent.mm.vfs.o(czz());
          if ((!paramq.exists()) && (!paramq.mkdirs()))
          {
            Log.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
            AppMethodBeat.o(63805);
            return;
          }
          paramq = czz() + UUID.randomUUID().toString() + ".tmp";
          Log.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", new Object[] { paramq });
          if (m(paramq, paramString.qwA.Lhd.zy))
          {
            c localc = new c((byte)0);
            localc.fileName = paramq;
            localc.dLt = paramString.qwA.Lba;
            localc.qwa = 2;
            this.qvM.add(localc);
            czw();
            AppMethodBeat.o(63805);
            return;
          }
          Log.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
          AppMethodBeat.o(63805);
          return;
        }
        h.CyF.a(14404, new Object[] { Integer.valueOf(3), paramString.dFw, Integer.valueOf(2), "", Integer.valueOf(2) });
        AppMethodBeat.o(63805);
        return;
      }
      Log.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", new Object[] { paramString });
      h.CyF.a(14404, new Object[] { Integer.valueOf(3), paramString.dFw, Integer.valueOf(3), "", Integer.valueOf(2) });
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
      //   29: invokestatic 44	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   32: ldc 21
      //   34: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   37: aconst_null
      //   38: areturn
      //   39: aload_0
      //   40: ldc 32
      //   42: invokevirtual 53	android/content/Context:getString	(I)Ljava/lang/String;
      //   45: astore 8
      //   47: invokestatic 57	com/tencent/mm/plugin/collect/model/g:czB	()Landroid/media/MediaPlayer;
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
      //   94: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   230: invokestatic 70	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   271: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   304: invokestatic 44	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   307: ldc 29
      //   309: aload_1
      //   310: ldc 144
      //   312: iconst_0
      //   313: anewarray 4	java/lang/Object
      //   316: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   354: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   388: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
      AppMethodBeat.i(213147);
      final MediaPlayer localMediaPlayer = g.czB();
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
        paramb.czC();
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
          AppMethodBeat.o(213147);
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
        AppMethodBeat.o(213147);
      }
    }
  }
  
  static abstract interface b<T>
  {
    public abstract void czC();
  }
  
  final class c
  {
    String dFw;
    int dLt;
    String fileName;
    int qwa;
    int qwb = 0;
    boolean qwc = false;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.g
 * JD-Core Version:    0.7.0.1
 */