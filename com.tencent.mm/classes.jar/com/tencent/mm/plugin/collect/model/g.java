package com.tencent.mm.plugin.collect.model;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.g.a.cd;
import com.tencent.mm.g.a.cd.a;
import com.tencent.mm.g.b.a.ei;
import com.tencent.mm.plugin.collect.model.voice.a.c;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.sj;
import com.tencent.mm.protocal.protobuf.ss;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class g
  extends c<cd>
  implements com.tencent.mm.al.g, a.c
{
  private static final com.tencent.mm.bx.b nTe;
  private static HandlerThread nTp;
  private boolean kQm;
  private MediaPlayer nTf;
  private MediaPlayer nTg;
  public ConcurrentLinkedQueue<c> nTh;
  private int nTi;
  private int nTj;
  private long nTk;
  private WeakReference<ArrayList<String>> nTl;
  private ei nTm;
  private Map<String, cd> nTn;
  private final long nTo;
  
  static
  {
    AppMethodBeat.i(63818);
    nTe = com.tencent.mm.bx.b.aDf("元");
    nTp = d.gw("syncCreatePlayer", 5);
    AppMethodBeat.o(63818);
  }
  
  public g()
  {
    AppMethodBeat.i(63797);
    this.kQm = false;
    this.nTn = new HashMap();
    this.nTo = 10000L;
    this.__eventId = cd.class.getName().hashCode();
    AppMethodBeat.o(63797);
  }
  
  private boolean RV(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(63800);
        boolean bool;
        if (bt.isNullOrNil(paramString))
        {
          ad.w("MicroMsg.F2fRcvVoiceListener", "illegal no: %s, not do play", new Object[] { paramString });
          AppMethodBeat.o(63800);
          bool = true;
          return bool;
        }
        List localList = bOs();
        Iterator localIterator = bOs().iterator();
        if (localIterator.hasNext())
        {
          if (((String)localIterator.next()).equals(paramString))
          {
            ad.i("MicroMsg.F2fRcvVoiceListener", "has played tradeno: %s", new Object[] { paramString });
            AppMethodBeat.o(63800);
            bool = true;
          }
        }
        else
        {
          localList.add(paramString);
          if (localList.size() > 10)
          {
            ad.i("MicroMsg.F2fRcvVoiceListener", "over max size, do remove");
            int i = localList.size();
            paramString = localList.subList(i - 10, i);
            com.tencent.mm.kernel.g.afB().afk().set(ae.a.FsW, bt.n(paramString, ","));
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
  
  private static int RW(String paramString)
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
  
  private void a(int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3, String paramString3, int paramInt4)
  {
    AppMethodBeat.i(63810);
    this.nTm = new ei();
    this.nTm.dKe = paramInt1;
    this.nTm.kG(paramString1);
    if (!bt.iY(paramInt4, 0)) {
      this.nTm.dZe = paramInt4;
    }
    this.nTm.dZg = paramInt2;
    this.nTm.kH(paramString2);
    this.nTm.dZj = paramInt3;
    if (bt.iY(paramInt1, 6)) {
      this.nTm.kI(paramString3);
    }
    this.nTm.aBj();
    AppMethodBeat.o(63810);
  }
  
  private void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(63807);
    Object localObject = new com.tencent.mm.vfs.e(bOx());
    if ((!((com.tencent.mm.vfs.e)localObject).exists()) && (!((com.tencent.mm.vfs.e)localObject).mkdirs()))
    {
      ad.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
      AppMethodBeat.o(63807);
      return;
    }
    localObject = bOx() + UUID.randomUUID().toString() + ".tmp";
    ad.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", new Object[] { localObject });
    if (m((String)localObject, paramArrayOfByte))
    {
      paramArrayOfByte = new c((byte)0);
      paramArrayOfByte.fileName = ((String)localObject);
      paramArrayOfByte.dkj = paramInt2;
      paramArrayOfByte.nTx = paramInt1;
      paramArrayOfByte.den = paramString;
      paramArrayOfByte.nTy = paramInt3;
      paramArrayOfByte.nTz = paramBoolean;
      this.nTh.add(paramArrayOfByte);
      bOu();
      AppMethodBeat.o(63807);
      return;
    }
    ad.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
    AppMethodBeat.o(63807);
  }
  
  private void a(cd paramcd, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(63798);
    ad.i("MicroMsg.F2fRcvVoiceListener", "callbackImp() tradeNo:%s useOffline:%s", new Object[] { paramcd.dek.den, Boolean.valueOf(paramBoolean1) });
    long l = paramcd.dek.ed;
    if (paramcd.dek.deo.equals("wx_f2f"))
    {
      com.tencent.mm.plugin.collect.a.a.bOn();
      boolean bool = com.tencent.mm.plugin.collect.a.a.bOp();
      ad.i("MicroMsg.F2fRcvVoiceListener", "on recv, fee: %s, voice open: %B", new Object[] { Integer.valueOf(paramcd.dek.del), Boolean.valueOf(bool) });
      if ((paramBoolean2) || (!RV(paramcd.dek.den)))
      {
        if (paramcd.dek.dep == 0) {
          h.vKh.idkeyStat(699L, 8L, 1L, false);
        }
        for (;;)
        {
          if ((paramBoolean1) && (!com.tencent.mm.plugin.collect.model.voice.a.nUp) && (!bt.isNullOrNil(paramcd.dek.deq)))
          {
            ad.i("MicroMsg.F2fRcvVoiceListener", "init tts");
            com.tencent.mm.plugin.collect.model.voice.a.bOE().iX(false);
          }
          if ((!paramBoolean1) || (!com.tencent.mm.plugin.collect.model.voice.a.nUp) || (bt.isNullOrNil(paramcd.dek.deq))) {
            break;
          }
          ad.i("MicroMsg.F2fRcvVoiceListener", "useOffline");
          this.nTn.put(paramcd.dek.den, paramcd);
          com.tencent.mm.plugin.collect.model.voice.a.bOE().a(paramcd);
          AppMethodBeat.o(63798);
          return;
          h.vKh.idkeyStat(699L, 9L, 1L, false);
        }
        ad.i("MicroMsg.F2fRcvVoiceListener", "useOnline");
        paramcd = new i(paramcd.dek.del, nTe, paramcd.dek.den, paramcd.dek.dep, l);
        com.tencent.mm.kernel.g.afC();
        com.tencent.mm.kernel.g.afA().gcy.a(paramcd, 0);
      }
      AppMethodBeat.o(63798);
      return;
    }
    if (paramcd.dek.deo.equals("wx_md"))
    {
      if ((paramBoolean1) && (com.tencent.mm.plugin.collect.model.voice.a.nUp) && (!bt.isNullOrNil(paramcd.dek.deq)))
      {
        this.nTn.put(paramcd.dek.den, paramcd);
        com.tencent.mm.plugin.collect.model.voice.a.bOE().a(paramcd);
        AppMethodBeat.o(63798);
        return;
      }
      paramcd = new o(paramcd.dek.del, nTe, paramcd.dek.den);
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.afA().gcy.a(paramcd, 0);
      AppMethodBeat.o(63798);
      return;
    }
    ad.w("MicroMsg.F2fRcvVoiceListener", "unknown type: %s", new Object[] { paramcd.dek.deo });
    AppMethodBeat.o(63798);
  }
  
  private void a(final c paramc)
  {
    AppMethodBeat.i(63804);
    this.nTg = a.a(paramc.fileName, new MediaPlayer.OnCompletionListener()new MediaPlayer.OnErrorListener
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(63789);
        ad.i("MicroMsg.F2fRcvVoiceListener", "play done");
        g.e(g.this);
        g.i(g.this);
        g.f(g.this);
        if (!g.g(g.this).isEmpty())
        {
          g.h(g.this);
          AppMethodBeat.o(63789);
          return;
        }
        g.bOy();
        AppMethodBeat.o(63789);
      }
    }, new MediaPlayer.OnErrorListener()new b
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(63790);
        ad.e("MicroMsg.F2fRcvVoiceListener", "play money error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        g.e(g.this);
        g.i(g.this);
        h.vKh.f(14404, new Object[] { Integer.valueOf(3), paramc.den, Integer.valueOf(7), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramc.nTx) });
        g.f(g.this);
        if (!g.g(g.this).isEmpty()) {
          g.h(g.this);
        }
        for (;;)
        {
          AppMethodBeat.o(63790);
          return false;
          g.bOy();
        }
      }
    }, new b()
    {
      public final void bOA()
      {
        AppMethodBeat.i(186982);
        if (com.tencent.mm.plugin.collect.a.a.bOn().nSU)
        {
          ad.i("MicroMsg.F2fRcvVoiceListener", "play isForground");
          if (paramc.nTz)
          {
            h.vKh.f(14404, new Object[] { Integer.valueOf(1), paramc.den, "", "", Integer.valueOf(paramc.nTx), "", "", "", com.tencent.mm.plugin.collect.model.voice.a.bOE().bOL() });
            AppMethodBeat.o(186982);
            return;
          }
          h.vKh.f(14404, new Object[] { Integer.valueOf(1), paramc.den, "", "", Integer.valueOf(paramc.nTx) });
          AppMethodBeat.o(186982);
          return;
        }
        ad.i("MicroMsg.F2fRcvVoiceListener", "play isBackground");
        if (paramc.nTz)
        {
          h.vKh.f(14404, new Object[] { Integer.valueOf(2), paramc.den, "", "", Integer.valueOf(paramc.nTx), "", "", "", com.tencent.mm.plugin.collect.model.voice.a.bOE().bOL() });
          AppMethodBeat.o(186982);
          return;
        }
        h.vKh.f(14404, new Object[] { Integer.valueOf(2), paramc.den, "", "", Integer.valueOf(paramc.nTx) });
        AppMethodBeat.o(186982);
      }
    });
    AppMethodBeat.o(63804);
  }
  
  private void aF(int paramInt, String paramString)
  {
    AppMethodBeat.i(63808);
    ad.i("MicroMsg.F2fRcvVoiceListener", "play default sound only");
    c localc = new c((byte)0);
    localc.nTx = paramInt;
    localc.den = paramString;
    this.nTh.add(localc);
    bOu();
    AppMethodBeat.o(63808);
  }
  
  private List<String> bOs()
  {
    AppMethodBeat.i(63799);
    if ((this.nTl == null) || (this.nTl.get() == null))
    {
      ad.i("MicroMsg.F2fRcvVoiceListener", "refer is null");
      this.nTl = new WeakReference(new ArrayList(bt.kS((String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.FsW, ""), ",")));
    }
    List localList = (List)this.nTl.get();
    AppMethodBeat.o(63799);
    return localList;
  }
  
  public static boolean bOt()
  {
    AppMethodBeat.i(63802);
    ad.i("MicroMsg.F2fRcvVoiceListener", "delete files");
    boolean bool = com.tencent.mm.vfs.i.cO(bOx(), true);
    AppMethodBeat.o(63802);
    return bool;
  }
  
  private void bOu()
  {
    for (;;)
    {
      final c localc;
      try
      {
        AppMethodBeat.i(63803);
        long l1 = System.currentTimeMillis();
        long l2 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pwm, 10000L);
        ad.i("MicroMsg.F2fRcvVoiceListener", "voiceOvertime: %s", new Object[] { Long.valueOf(l2) });
        if (l1 - this.nTk > l2)
        {
          ad.i("MicroMsg.F2fRcvVoiceListener", "last has outdate: %s", new Object[] { Long.valueOf(this.nTk) });
          this.kQm = false;
        }
        if (this.kQm)
        {
          ad.i("MicroMsg.F2fRcvVoiceListener", "is playing, return");
          AppMethodBeat.o(63803);
          return;
        }
        this.kQm = true;
        this.nTk = System.currentTimeMillis();
        localc = (c)this.nTh.poll();
        i = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(3);
        this.nTi = com.tencent.mm.plugin.audio.c.a.getStreamVolume(3);
        this.nTj = Math.round(i * 0.5F);
        ad.i("MicroMsg.F2fRcvVoiceListener", "curVol: %s, maxVol: %s, minVol: %s", new Object[] { Integer.valueOf(this.nTi), Integer.valueOf(i), Integer.valueOf(this.nTj) });
        if (Build.VERSION.SDK_INT < 23) {
          break label665;
        }
        bool = com.tencent.mm.plugin.audio.c.a.bvF();
        ad.i("MicroMsg.F2fRcvVoiceListener", "isMute: %s", new Object[] { Boolean.valueOf(bool) });
        if ((this.nTi == 0) || (bool))
        {
          ad.i("MicroMsg.F2fRcvVoiceListener", "music channel is mute");
          if (localc != null)
          {
            i = localc.nTx;
            h localh = h.vKh;
            if (localc == null) {
              break label447;
            }
            String str1 = localc.den;
            localh.f(14404, new Object[] { Integer.valueOf(3), str1, Integer.valueOf(5), "", Integer.valueOf(i) });
          }
        }
        else
        {
          if ((this.nTi > 0) && (this.nTi < this.nTj) && (!bool)) {
            com.tencent.mm.plugin.audio.c.a.ex(3, this.nTj);
          }
          if (localc == null) {
            break label651;
          }
          ad.i("MicroMsg.F2fRcvVoiceListener", "holder.offLine = %s", new Object[] { Boolean.valueOf(localc.nTz) });
          if (!localc.nTz) {
            break label472;
          }
          a(localc);
          if ((!this.kQm) || (this.nTg != null)) {
            break label455;
          }
          ad.i("MicroMsg.F2fRcvVoiceListener", "isPlaying && moneyPlayer == null");
          AppMethodBeat.o(63803);
          continue;
        }
        i = 1;
      }
      finally {}
      continue;
      label447:
      String str2 = "";
      continue;
      label455:
      ad.i("MicroMsg.F2fRcvVoiceListener", "has played");
      AppMethodBeat.o(63803);
      continue;
      label472:
      int i = localc.nTx;
      if (!bt.isNullOrNil(localc.fileName))
      {
        ad.i("MicroMsg.F2fRcvVoiceListener", "play prefix voice: %d", new Object[] { Integer.valueOf(i) });
        this.nTf = a.a(aj.getContext(), new MediaPlayer.OnCompletionListener()new MediaPlayer.OnErrorListener
        {
          public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            AppMethodBeat.i(63784);
            ad.i("MicroMsg.F2fRcvVoiceListener", "start play money");
            if ((g.a(g.this) != null) && (g.b(g.this)) && (g.c(g.this) == null)) {
              g.a(g.this, localc);
            }
            for (;;)
            {
              g.d(g.this);
              AppMethodBeat.o(63784);
              return;
              ad.i("MicroMsg.F2fRcvVoiceListener", "has played");
            }
          }
        }, new MediaPlayer.OnErrorListener()
        {
          public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(63785);
            ad.e("MicroMsg.F2fRcvVoiceListener", "prefix play error");
            g.e(g.this);
            g.d(g.this);
            g.f(g.this);
            h.vKh.f(14404, new Object[] { Integer.valueOf(3), localc.den, Integer.valueOf(7), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(localc.nTx) });
            if (!g.g(g.this).isEmpty()) {
              g.h(g.this);
            }
            for (;;)
            {
              AppMethodBeat.o(63785);
              return false;
              g.bOy();
            }
          }
        });
        if (this.nTf != null)
        {
          i = this.nTf.getDuration();
          ad.i("MicroMsg.F2fRcvVoiceListener", "prefix duration: %s", new Object[] { Integer.valueOf(i) });
          aq.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(63786);
              if ((g.a(g.this) != null) && (g.b(g.this)) && (g.c(g.this) == null))
              {
                ad.i("MicroMsg.F2fRcvVoiceListener", "this play may error");
                h.vKh.idkeyStat(699L, 1L, 1L, false);
              }
              AppMethodBeat.o(63786);
            }
          }, i + 1000);
          AppMethodBeat.o(63803);
        }
      }
      else
      {
        this.nTf = a.a(aj.getContext(), new MediaPlayer.OnCompletionListener()new MediaPlayer.OnErrorListener
        {
          public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            AppMethodBeat.i(63787);
            ad.i("MicroMsg.F2fRcvVoiceListener", "no need to play money this time");
            g.f(g.this);
            g.e(g.this);
            g.d(g.this);
            com.tencent.mm.plugin.collect.a.a.bOn();
            h.vKh.f(14404, new Object[] { Integer.valueOf(4), localc.den, "", "", Integer.valueOf(localc.nTx) });
            if (!g.g(g.this).isEmpty())
            {
              g.h(g.this);
              AppMethodBeat.o(63787);
              return;
            }
            g.bOy();
            AppMethodBeat.o(63787);
          }
        }, new MediaPlayer.OnErrorListener()
        {
          public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(63788);
            ad.e("MicroMsg.F2fRcvVoiceListener", "no need play money error");
            g.f(g.this);
            g.e(g.this);
            g.d(g.this);
            h.vKh.f(14404, new Object[] { Integer.valueOf(3), localc.den, Integer.valueOf(7), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(localc.nTx) });
            AppMethodBeat.o(63788);
            return false;
          }
        });
        h.vKh.idkeyStat(699L, 2L, 1L, false);
      }
      AppMethodBeat.o(63803);
      continue;
      label651:
      this.kQm = false;
      AppMethodBeat.o(63803);
      continue;
      label665:
      boolean bool = false;
    }
  }
  
  private static MediaPlayer bOv()
  {
    AppMethodBeat.i(186985);
    final Object localObject1 = Looper.myLooper();
    ad.i("MicroMsg.F2fRcvVoiceListener", "[syncCreatePlayer] %s", new Object[] { localObject1 });
    if ((localObject1 != null) && (localObject1 != Looper.getMainLooper()) && (localObject1 != nTp.getLooper()))
    {
      if (!nTp.isAlive()) {
        nTp.start();
      }
      ap localap = new ap(nTp.getLooper());
      localObject1 = new Object();
      MediaPlayer[] arrayOfMediaPlayer = new MediaPlayer[1];
      arrayOfMediaPlayer[0] = null;
      try
      {
        localap.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(186983);
            this.nTs[0] = new k();
            try
            {
              synchronized (localObject1)
              {
                localObject1.notify();
                AppMethodBeat.o(186983);
                return;
              }
              return;
            }
            catch (Exception localException)
            {
              ad.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", localException, "", new Object[0]);
              AppMethodBeat.o(186983);
            }
          }
        });
        try
        {
          localObject1.wait();
          localObject1 = arrayOfMediaPlayer[0];
          AppMethodBeat.o(186985);
          return localObject1;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            ad.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", localInterruptedException, "", new Object[0]);
          }
        }
        localObject1 = new k();
      }
      finally
      {
        AppMethodBeat.o(186985);
      }
    }
    AppMethodBeat.o(186985);
    return localObject1;
  }
  
  private static int bOw()
  {
    AppMethodBeat.i(63811);
    if (com.tencent.mm.plugin.audio.c.a.bvC())
    {
      AppMethodBeat.o(63811);
      return 1;
    }
    AppMethodBeat.o(63811);
    return 0;
  }
  
  private static String bOx()
  {
    AppMethodBeat.i(63812);
    String str = com.tencent.mm.loader.j.b.aih() + "wallet/voice/";
    AppMethodBeat.o(63812);
    return str;
  }
  
  private static boolean m(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63801);
    com.tencent.mm.kernel.g.afC();
    if (!com.tencent.mm.kernel.g.afB().isSDCardAvailable())
    {
      ad.i("MicroMsg.F2fRcvVoiceListener", "sd card not available");
      AppMethodBeat.o(63801);
      return false;
    }
    if (com.tencent.mm.vfs.i.f(paramString, paramArrayOfByte, paramArrayOfByte.length) == 0)
    {
      AppMethodBeat.o(63801);
      return true;
    }
    AppMethodBeat.o(63801);
    return false;
  }
  
  private static int zH(int paramInt)
  {
    int i = 2;
    if (paramInt == 1) {
      i = 3;
    }
    return i;
  }
  
  public final void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63806);
    ad.i("MicroMsg.F2fRcvVoiceListener", "errorCode:%s outTradeNo:%s type:%s content:%s packId:%s overtimeFlag:%s", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, paramString4, Integer.valueOf(0) });
    int i = RW(paramString2);
    paramString2 = (cd)this.nTn.remove(paramString1);
    if (paramInt1 < 0)
    {
      if (paramString2 != null) {
        if (paramString2.dek.des) {
          a(paramString2, false, true);
        }
      }
      for (;;)
      {
        a(6, paramString1, i, paramString3, paramInt2, paramString4, 9);
        AppMethodBeat.o(63806);
        return;
        ad.i("MicroMsg.F2fRcvVoiceListener", "onGetResult() needFailover:false");
        continue;
        aF(i, paramString1);
      }
    }
    a(i, paramArrayOfByte, 1, paramString1, 0, true);
    a(5, paramString1, i, paramString3, paramInt2, paramString4, 0);
    AppMethodBeat.o(63806);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(63805);
    ad.i("MicroMsg.F2fRcvVoiceListener", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramn instanceof i))
    {
      paramn = (i)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ad.i("MicroMsg.F2fRcvVoiceListener", "overtime: %s retcode: %s", new Object[] { Integer.valueOf(paramn.nTC.CUi), Integer.valueOf(paramn.nTC.dcG) });
        if (paramn.nTC.CUi == 1)
        {
          ad.w("MicroMsg.F2fRcvVoiceListener", "skip over 10min: %s", new Object[] { Long.valueOf(paramn.ed) });
          h.vKh.f(14404, new Object[] { Integer.valueOf(3), paramn.den, Integer.valueOf(1), "", Integer.valueOf(1) });
          AppMethodBeat.o(63805);
          return;
        }
        if ((paramn.nTC.dcG == 0) && (paramn.nTC.CUh != null))
        {
          a(1, paramn.nTC.CUh.wA, paramn.nTC.CUg, paramn.den, paramn.nTC.CUi, false);
          h.vKh.f(15763, new Object[] { paramn.den, Integer.valueOf(1), Integer.valueOf(zH(paramn.dep)), Long.valueOf(paramn.nTD), Integer.valueOf(bOw()) });
          AppMethodBeat.o(63805);
          return;
        }
        if (paramn.nTC.dcG <= 100)
        {
          paramInt1 = paramn.nTC.dcG;
          if (paramn.nTC.CUh == null) {}
          for (paramString = "null";; paramString = "not null")
          {
            ad.i("MicroMsg.F2fRcvVoiceListener", "play default sound only %s %s", new Object[] { Integer.valueOf(paramInt1), paramString });
            aF(1, paramn.den);
            h.vKh.f(15763, new Object[] { paramn.den, Integer.valueOf(2), Integer.valueOf(zH(paramn.dep)), Long.valueOf(paramn.nTD), Integer.valueOf(bOw()) });
            AppMethodBeat.o(63805);
            return;
          }
        }
        ad.w("MicroMsg.F2fRcvVoiceListener", "retcode > 100, don't play");
        h.vKh.f(14404, new Object[] { Integer.valueOf(3), paramn.den, Integer.valueOf(2), "", Integer.valueOf(1) });
        h.vKh.f(15763, new Object[] { paramn.den, Integer.valueOf(2), Integer.valueOf(zH(paramn.dep)), Long.valueOf(paramn.nTD), Integer.valueOf(bOw()) });
        AppMethodBeat.o(63805);
        return;
      }
      ad.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", new Object[] { paramn });
      aF(1, paramn.den);
      h.vKh.f(15763, new Object[] { paramn.den, Integer.valueOf(2), Integer.valueOf(zH(paramn.dep)), Long.valueOf(paramn.nTD), Integer.valueOf(bOw()) });
      h.vKh.f(14404, new Object[] { Integer.valueOf(3), paramn.den, Integer.valueOf(3), "", Integer.valueOf(1) });
      AppMethodBeat.o(63805);
      return;
    }
    if ((paramn instanceof o))
    {
      paramString = (o)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.nTX.dcG == 0)
        {
          paramn = new com.tencent.mm.vfs.e(bOx());
          if ((!paramn.exists()) && (!paramn.mkdirs()))
          {
            ad.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
            AppMethodBeat.o(63805);
            return;
          }
          paramn = bOx() + UUID.randomUUID().toString() + ".tmp";
          ad.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", new Object[] { paramn });
          if (m(paramn, paramString.nTX.CUh.wA))
          {
            c localc = new c((byte)0);
            localc.fileName = paramn;
            localc.dkj = paramString.nTX.CUg;
            localc.nTx = 2;
            this.nTh.add(localc);
            bOu();
            AppMethodBeat.o(63805);
            return;
          }
          ad.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
          AppMethodBeat.o(63805);
          return;
        }
        h.vKh.f(14404, new Object[] { Integer.valueOf(3), paramString.den, Integer.valueOf(2), "", Integer.valueOf(2) });
        AppMethodBeat.o(63805);
        return;
      }
      ad.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", new Object[] { paramString });
      h.vKh.f(14404, new Object[] { Integer.valueOf(3), paramString.den, Integer.valueOf(3), "", Integer.valueOf(2) });
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
      //   29: invokestatic 44	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   32: ldc 21
      //   34: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   37: aconst_null
      //   38: areturn
      //   39: aload_0
      //   40: ldc 32
      //   42: invokevirtual 53	android/content/Context:getString	(I)Ljava/lang/String;
      //   45: astore 8
      //   47: invokestatic 57	com/tencent/mm/plugin/collect/model/g:bOz	()Landroid/media/MediaPlayer;
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
      //   94: invokestatic 70	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   230: invokestatic 70	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   271: invokestatic 148	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   304: invokestatic 44	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   307: ldc 29
      //   309: aload_1
      //   310: ldc 144
      //   312: iconst_0
      //   313: anewarray 4	java/lang/Object
      //   316: invokestatic 148	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   354: invokestatic 148	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
      //   388: invokestatic 148	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
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
      AppMethodBeat.i(186984);
      final MediaPlayer localMediaPlayer = g.bOz();
      localMediaPlayer.setAudioStreamType(3);
      ad.i("MicroMsg.F2fRcvVoiceListener", "play start mp:%d path:%s", new Object[] { Integer.valueOf(localMediaPlayer.hashCode()), paramString });
      try
      {
        localMediaPlayer.setDataSource(paramString);
        localMediaPlayer.setLooping(false);
        localMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener()
        {
          public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(63793);
            ad.i("MicroMsg.F2fRcvVoiceListener", "onError, what: %d, extra: %d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
            if (paramAnonymousMediaPlayer != null) {}
            try
            {
              paramAnonymousMediaPlayer.release();
              if (this.nTu != null) {
                this.nTu.release();
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
              ad.i("MicroMsg.F2fRcvVoiceListener", "play completion mp:%d  path:%s", new Object[] { Integer.valueOf(i), this.val$path });
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
        paramb.bOA();
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
          ad.i("MicroMsg.F2fRcvVoiceListener", "play start mp finish [%d], myLooper[%b] mainLooper[%b]", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          AppMethodBeat.o(186984);
          return localMediaPlayer;
          bool1 = false;
          break;
        }
        return null;
      }
      catch (Exception paramOnCompletionListener)
      {
        ad.e("MicroMsg.F2fRcvVoiceListener", "play failed path:%s e:%s", new Object[] { paramString, paramOnCompletionListener.getMessage() });
        ad.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", paramOnCompletionListener, "", new Object[0]);
        if (localMediaPlayer != null) {
          localMediaPlayer.release();
        }
        AppMethodBeat.o(186984);
      }
    }
  }
  
  static abstract interface b<T>
  {
    public abstract void bOA();
  }
  
  final class c
  {
    String den;
    int dkj;
    String fileName;
    int nTx;
    int nTy = 0;
    boolean nTz = false;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.g
 * JD-Core Version:    0.7.0.1
 */