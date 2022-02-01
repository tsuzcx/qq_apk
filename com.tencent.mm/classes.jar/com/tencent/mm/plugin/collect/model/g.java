package com.tencent.mm.plugin.collect.model;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.e.c.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.g.a.cd;
import com.tencent.mm.g.a.cd.a;
import com.tencent.mm.g.b.a.fy;
import com.tencent.mm.plugin.collect.model.voice.a.c;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.st;
import com.tencent.mm.protocal.protobuf.tc;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
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
  implements com.tencent.mm.ak.g, a.c
{
  private static HandlerThread owK;
  private static final com.tencent.mm.bw.b owz;
  private boolean lrL;
  private MediaPlayer owA;
  private MediaPlayer owB;
  public ConcurrentLinkedQueue<c> owC;
  private int owD;
  private int owE;
  private long owF;
  private WeakReference<ArrayList<String>> owG;
  private fy owH;
  private Map<String, cd> owI;
  private final long owJ;
  
  static
  {
    AppMethodBeat.i(63818);
    owz = com.tencent.mm.bw.b.aIw("元");
    owK = d.gA("syncCreatePlayer", 5);
    AppMethodBeat.o(63818);
  }
  
  public g()
  {
    AppMethodBeat.i(63797);
    this.lrL = false;
    this.owI = new HashMap();
    this.owJ = 10000L;
    this.__eventId = cd.class.getName().hashCode();
    AppMethodBeat.o(63797);
  }
  
  private static int Az(int paramInt)
  {
    int i = 2;
    if (paramInt == 1) {
      i = 3;
    }
    return i;
  }
  
  private boolean Wh(String paramString)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(63800);
        boolean bool;
        if (bs.isNullOrNil(paramString))
        {
          ac.w("MicroMsg.F2fRcvVoiceListener", "illegal no: %s, not do play", new Object[] { paramString });
          AppMethodBeat.o(63800);
          bool = true;
          return bool;
        }
        List localList = bVI();
        Iterator localIterator = bVI().iterator();
        if (localIterator.hasNext())
        {
          if (((String)localIterator.next()).equals(paramString))
          {
            ac.i("MicroMsg.F2fRcvVoiceListener", "has played tradeno: %s", new Object[] { paramString });
            AppMethodBeat.o(63800);
            bool = true;
          }
        }
        else
        {
          localList.add(paramString);
          if (localList.size() > 10)
          {
            ac.i("MicroMsg.F2fRcvVoiceListener", "over max size, do remove");
            int i = localList.size();
            paramString = localList.subList(i - 10, i);
            com.tencent.mm.kernel.g.agR().agA().set(ah.a.GQP, bs.n(paramString, ","));
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
  
  private static int Wi(String paramString)
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
    this.owH = new fy();
    this.owH.dHY = paramInt1;
    this.owH.ny(paramString1);
    if (!bs.jl(paramInt4, 0)) {
      this.owH.eaW = paramInt4;
    }
    this.owH.eaY = paramInt2;
    this.owH.nz(paramString2);
    this.owH.ebb = paramInt3;
    if (bs.jl(paramInt1, 6)) {
      this.owH.nA(paramString3);
    }
    this.owH.aHZ();
    AppMethodBeat.o(63810);
  }
  
  private void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(63807);
    Object localObject = new com.tencent.mm.vfs.e(bVN());
    if ((!((com.tencent.mm.vfs.e)localObject).exists()) && (!((com.tencent.mm.vfs.e)localObject).mkdirs()))
    {
      ac.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
      AppMethodBeat.o(63807);
      return;
    }
    localObject = bVN() + UUID.randomUUID().toString() + ".tmp";
    ac.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", new Object[] { localObject });
    if (m((String)localObject, paramArrayOfByte))
    {
      paramArrayOfByte = new c((byte)0);
      paramArrayOfByte.fileName = ((String)localObject);
      paramArrayOfByte.dhE = paramInt2;
      paramArrayOfByte.owS = paramInt1;
      paramArrayOfByte.dbJ = paramString;
      paramArrayOfByte.owT = paramInt3;
      paramArrayOfByte.owU = paramBoolean;
      this.owC.add(paramArrayOfByte);
      bVK();
      AppMethodBeat.o(63807);
      return;
    }
    ac.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
    AppMethodBeat.o(63807);
  }
  
  private void a(cd paramcd, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(63798);
    ac.i("MicroMsg.F2fRcvVoiceListener", "callbackImp() tradeNo:%s useOffline:%s", new Object[] { paramcd.dbG.dbJ, Boolean.valueOf(paramBoolean1) });
    long l = paramcd.dbG.fe;
    if (paramcd.dbG.dbK.equals("wx_f2f"))
    {
      com.tencent.mm.plugin.collect.a.a.bVD();
      boolean bool = com.tencent.mm.plugin.collect.a.a.bVF();
      ac.i("MicroMsg.F2fRcvVoiceListener", "on recv, fee: %s, voice open: %B", new Object[] { Integer.valueOf(paramcd.dbG.dbH), Boolean.valueOf(bool) });
      if ((paramBoolean2) || (!Wh(paramcd.dbG.dbJ)))
      {
        if (paramcd.dbG.dbL == 0) {
          h.wUl.idkeyStat(699L, 8L, 1L, false);
        }
        for (;;)
        {
          if ((paramBoolean1) && (!com.tencent.mm.plugin.collect.model.voice.a.oxK) && (!bs.isNullOrNil(paramcd.dbG.dbM)))
          {
            ac.i("MicroMsg.F2fRcvVoiceListener", "init tts");
            com.tencent.mm.plugin.collect.model.voice.a.bVU().jA(false);
          }
          if ((!paramBoolean1) || (!com.tencent.mm.plugin.collect.model.voice.a.oxK) || (bs.isNullOrNil(paramcd.dbG.dbM))) {
            break;
          }
          ac.i("MicroMsg.F2fRcvVoiceListener", "useOffline");
          this.owI.put(paramcd.dbG.dbJ, paramcd);
          com.tencent.mm.plugin.collect.model.voice.a.bVU().a(paramcd);
          AppMethodBeat.o(63798);
          return;
          h.wUl.idkeyStat(699L, 9L, 1L, false);
        }
        ac.i("MicroMsg.F2fRcvVoiceListener", "useOnline");
        paramcd = new i(paramcd.dbG.dbH, owz, paramcd.dbG.dbJ, paramcd.dbG.dbL, l);
        com.tencent.mm.kernel.g.agS();
        com.tencent.mm.kernel.g.agQ().ghe.a(paramcd, 0);
      }
      AppMethodBeat.o(63798);
      return;
    }
    if (paramcd.dbG.dbK.equals("wx_md"))
    {
      if ((paramBoolean1) && (com.tencent.mm.plugin.collect.model.voice.a.oxK) && (!bs.isNullOrNil(paramcd.dbG.dbM)))
      {
        this.owI.put(paramcd.dbG.dbJ, paramcd);
        com.tencent.mm.plugin.collect.model.voice.a.bVU().a(paramcd);
        AppMethodBeat.o(63798);
        return;
      }
      paramcd = new o(paramcd.dbG.dbH, owz, paramcd.dbG.dbJ);
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.agQ().ghe.a(paramcd, 0);
      AppMethodBeat.o(63798);
      return;
    }
    ac.w("MicroMsg.F2fRcvVoiceListener", "unknown type: %s", new Object[] { paramcd.dbG.dbK });
    AppMethodBeat.o(63798);
  }
  
  private void a(final c paramc)
  {
    AppMethodBeat.i(63804);
    this.owB = g.a.a(paramc.fileName, new MediaPlayer.OnCompletionListener()new MediaPlayer.OnErrorListener
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(63789);
        ac.i("MicroMsg.F2fRcvVoiceListener", "play done");
        g.e(g.this);
        g.i(g.this);
        g.f(g.this);
        if (!g.g(g.this).isEmpty())
        {
          g.h(g.this);
          AppMethodBeat.o(63789);
          return;
        }
        g.bVO();
        AppMethodBeat.o(63789);
      }
    }, new MediaPlayer.OnErrorListener()new g.b
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(63790);
        ac.e("MicroMsg.F2fRcvVoiceListener", "play money error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        g.e(g.this);
        g.i(g.this);
        h.wUl.f(14404, new Object[] { Integer.valueOf(3), paramc.dbJ, Integer.valueOf(7), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramc.owS) });
        g.f(g.this);
        if (!g.g(g.this).isEmpty()) {
          g.h(g.this);
        }
        for (;;)
        {
          AppMethodBeat.o(63790);
          return false;
          g.bVO();
        }
      }
    }, new g.b()
    {
      public final void bVQ()
      {
        AppMethodBeat.i(207038);
        h.wUl.idkeyStat(1143L, 41L, 1L, false);
        if (com.tencent.mm.plugin.collect.a.a.bVD().owp)
        {
          ac.i("MicroMsg.F2fRcvVoiceListener", "play isForground");
          if (paramc.owU)
          {
            h.wUl.f(14404, new Object[] { Integer.valueOf(1), paramc.dbJ, "", "", Integer.valueOf(paramc.owS), "", "", "", com.tencent.mm.plugin.collect.model.voice.a.bVU().bWb() });
            AppMethodBeat.o(207038);
            return;
          }
          h.wUl.f(14404, new Object[] { Integer.valueOf(1), paramc.dbJ, "", "", Integer.valueOf(paramc.owS) });
          AppMethodBeat.o(207038);
          return;
        }
        ac.i("MicroMsg.F2fRcvVoiceListener", "play isBackground");
        if (paramc.owU)
        {
          h.wUl.f(14404, new Object[] { Integer.valueOf(2), paramc.dbJ, "", "", Integer.valueOf(paramc.owS), "", "", "", com.tencent.mm.plugin.collect.model.voice.a.bVU().bWb() });
          AppMethodBeat.o(207038);
          return;
        }
        h.wUl.f(14404, new Object[] { Integer.valueOf(2), paramc.dbJ, "", "", Integer.valueOf(paramc.owS) });
        AppMethodBeat.o(207038);
      }
    });
    AppMethodBeat.o(63804);
  }
  
  private void aH(int paramInt, String paramString)
  {
    AppMethodBeat.i(63808);
    ac.i("MicroMsg.F2fRcvVoiceListener", "play default sound only");
    c localc = new c((byte)0);
    localc.owS = paramInt;
    localc.dbJ = paramString;
    this.owC.add(localc);
    bVK();
    AppMethodBeat.o(63808);
  }
  
  private List<String> bVI()
  {
    AppMethodBeat.i(63799);
    if ((this.owG == null) || (this.owG.get() == null))
    {
      ac.i("MicroMsg.F2fRcvVoiceListener", "refer is null");
      this.owG = new WeakReference(new ArrayList(bs.lp((String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GQP, ""), ",")));
    }
    List localList = (List)this.owG.get();
    AppMethodBeat.o(63799);
    return localList;
  }
  
  public static boolean bVJ()
  {
    AppMethodBeat.i(63802);
    ac.i("MicroMsg.F2fRcvVoiceListener", "delete files");
    boolean bool = com.tencent.mm.vfs.i.cU(bVN(), true);
    AppMethodBeat.o(63802);
    return bool;
  }
  
  private void bVK()
  {
    for (;;)
    {
      final c localc;
      try
      {
        AppMethodBeat.i(63803);
        long l1 = System.currentTimeMillis();
        long l2 = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.qaA, 10000L);
        ac.i("MicroMsg.F2fRcvVoiceListener", "voiceOvertime: %s", new Object[] { Long.valueOf(l2) });
        if (l1 - this.owF > l2)
        {
          ac.i("MicroMsg.F2fRcvVoiceListener", "last has outdate: %s", new Object[] { Long.valueOf(this.owF) });
          h.wUl.idkeyStat(1143L, 42L, 1L, false);
          this.lrL = false;
        }
        if (this.lrL)
        {
          ac.i("MicroMsg.F2fRcvVoiceListener", "is playing, return");
          AppMethodBeat.o(63803);
          return;
        }
        this.lrL = true;
        this.owF = System.currentTimeMillis();
        localc = (c)this.owC.poll();
        i = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(3);
        this.owD = com.tencent.mm.plugin.audio.c.a.getStreamVolume(3);
        this.owE = Math.round(i * 0.5F);
        ac.i("MicroMsg.F2fRcvVoiceListener", "curVol: %s, maxVol: %s, minVol: %s", new Object[] { Integer.valueOf(this.owD), Integer.valueOf(i), Integer.valueOf(this.owE) });
        if (Build.VERSION.SDK_INT < 23) {
          break label679;
        }
        bool = com.tencent.mm.plugin.audio.c.a.bCB();
        ac.i("MicroMsg.F2fRcvVoiceListener", "isMute: %s", new Object[] { Boolean.valueOf(bool) });
        if ((this.owD == 0) || (bool))
        {
          ac.i("MicroMsg.F2fRcvVoiceListener", "music channel is mute");
          if (localc != null)
          {
            i = localc.owS;
            h localh = h.wUl;
            if (localc == null) {
              break label461;
            }
            String str1 = localc.dbJ;
            localh.f(14404, new Object[] { Integer.valueOf(3), str1, Integer.valueOf(5), "", Integer.valueOf(i) });
          }
        }
        else
        {
          if ((this.owD > 0) && (this.owD < this.owE) && (!bool)) {
            com.tencent.mm.plugin.audio.c.a.eA(3, this.owE);
          }
          if (localc == null) {
            break label665;
          }
          ac.i("MicroMsg.F2fRcvVoiceListener", "holder.offLine = %s", new Object[] { Boolean.valueOf(localc.owU) });
          if (!localc.owU) {
            break label486;
          }
          a(localc);
          if ((!this.lrL) || (this.owB != null)) {
            break label469;
          }
          ac.i("MicroMsg.F2fRcvVoiceListener", "isPlaying && moneyPlayer == null");
          AppMethodBeat.o(63803);
          continue;
        }
        i = 1;
      }
      finally {}
      continue;
      label461:
      String str2 = "";
      continue;
      label469:
      ac.i("MicroMsg.F2fRcvVoiceListener", "has played");
      AppMethodBeat.o(63803);
      continue;
      label486:
      int i = localc.owS;
      if (!bs.isNullOrNil(localc.fileName))
      {
        ac.i("MicroMsg.F2fRcvVoiceListener", "play prefix voice: %d", new Object[] { Integer.valueOf(i) });
        this.owA = g.a.a(ai.getContext(), new MediaPlayer.OnCompletionListener()new MediaPlayer.OnErrorListener
        {
          public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            AppMethodBeat.i(63784);
            ac.i("MicroMsg.F2fRcvVoiceListener", "start play money");
            if ((g.a(g.this) != null) && (g.b(g.this)) && (g.c(g.this) == null)) {
              g.a(g.this, localc);
            }
            for (;;)
            {
              g.d(g.this);
              AppMethodBeat.o(63784);
              return;
              ac.i("MicroMsg.F2fRcvVoiceListener", "has played");
            }
          }
        }, new MediaPlayer.OnErrorListener()
        {
          public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(63785);
            ac.e("MicroMsg.F2fRcvVoiceListener", "prefix play error");
            g.e(g.this);
            g.d(g.this);
            g.f(g.this);
            h.wUl.f(14404, new Object[] { Integer.valueOf(3), localc.dbJ, Integer.valueOf(7), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(localc.owS) });
            if (!g.g(g.this).isEmpty()) {
              g.h(g.this);
            }
            for (;;)
            {
              AppMethodBeat.o(63785);
              return false;
              g.bVO();
            }
          }
        });
        if (this.owA != null)
        {
          i = this.owA.getDuration();
          ac.i("MicroMsg.F2fRcvVoiceListener", "prefix duration: %s", new Object[] { Integer.valueOf(i) });
          ap.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(63786);
              if ((g.a(g.this) != null) && (g.b(g.this)) && (g.c(g.this) == null))
              {
                ac.i("MicroMsg.F2fRcvVoiceListener", "this play may error");
                h.wUl.idkeyStat(699L, 1L, 1L, false);
              }
              AppMethodBeat.o(63786);
            }
          }, i + 1000);
          AppMethodBeat.o(63803);
        }
      }
      else
      {
        this.owA = g.a.a(ai.getContext(), new MediaPlayer.OnCompletionListener()new MediaPlayer.OnErrorListener
        {
          public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            AppMethodBeat.i(63787);
            ac.i("MicroMsg.F2fRcvVoiceListener", "no need to play money this time");
            g.f(g.this);
            g.e(g.this);
            g.d(g.this);
            com.tencent.mm.plugin.collect.a.a.bVD();
            h.wUl.f(14404, new Object[] { Integer.valueOf(4), localc.dbJ, "", "", Integer.valueOf(localc.owS) });
            if (!g.g(g.this).isEmpty())
            {
              g.h(g.this);
              AppMethodBeat.o(63787);
              return;
            }
            g.bVO();
            AppMethodBeat.o(63787);
          }
        }, new MediaPlayer.OnErrorListener()
        {
          public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(63788);
            ac.e("MicroMsg.F2fRcvVoiceListener", "no need play money error");
            g.f(g.this);
            g.e(g.this);
            g.d(g.this);
            h.wUl.f(14404, new Object[] { Integer.valueOf(3), localc.dbJ, Integer.valueOf(7), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(localc.owS) });
            AppMethodBeat.o(63788);
            return false;
          }
        });
        h.wUl.idkeyStat(699L, 2L, 1L, false);
      }
      AppMethodBeat.o(63803);
      continue;
      label665:
      this.lrL = false;
      AppMethodBeat.o(63803);
      continue;
      label679:
      boolean bool = false;
    }
  }
  
  private static MediaPlayer bVL()
  {
    AppMethodBeat.i(207041);
    Object localObject1 = Looper.myLooper();
    ac.i("MicroMsg.F2fRcvVoiceListener", "[syncCreatePlayer] %s", new Object[] { localObject1 });
    if ((localObject1 != null) && (localObject1 != Looper.getMainLooper()) && (localObject1 != owK.getLooper()))
    {
      if (!owK.isAlive()) {
        owK.start();
      }
      ao localao = new ao(owK.getLooper());
      localObject1 = new Object();
      MediaPlayer[] arrayOfMediaPlayer = new MediaPlayer[1];
      arrayOfMediaPlayer[0] = null;
      try
      {
        localao.post(new g.9(arrayOfMediaPlayer, localObject1));
        try
        {
          localObject1.wait();
          localObject1 = arrayOfMediaPlayer[0];
          AppMethodBeat.o(207041);
          return localObject1;
        }
        catch (InterruptedException localInterruptedException)
        {
          for (;;)
          {
            ac.printErrStackTrace("MicroMsg.F2fRcvVoiceListener", localInterruptedException, "", new Object[0]);
          }
        }
        localObject1 = new k();
      }
      finally
      {
        AppMethodBeat.o(207041);
      }
    }
    AppMethodBeat.o(207041);
    return localObject1;
  }
  
  private static int bVM()
  {
    AppMethodBeat.i(63811);
    if (com.tencent.mm.plugin.audio.c.a.bCy())
    {
      AppMethodBeat.o(63811);
      return 1;
    }
    AppMethodBeat.o(63811);
    return 0;
  }
  
  private static String bVN()
  {
    AppMethodBeat.i(63812);
    String str = com.tencent.mm.loader.j.b.aph() + "wallet/voice/";
    AppMethodBeat.o(63812);
    return str;
  }
  
  private static boolean m(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63801);
    com.tencent.mm.kernel.g.agS();
    if (!com.tencent.mm.kernel.g.agR().isSDCardAvailable())
    {
      ac.i("MicroMsg.F2fRcvVoiceListener", "sd card not available");
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
  
  public final void a(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, String paramString4, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63806);
    ac.i("MicroMsg.F2fRcvVoiceListener", "errorCode:%s outTradeNo:%s type:%s content:%s packId:%s overtimeFlag:%s", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, paramString3, paramString4, Integer.valueOf(0) });
    int i = Wi(paramString2);
    paramString2 = (cd)this.owI.remove(paramString1);
    if (paramInt1 < 0)
    {
      if (paramString2 != null) {
        if (paramString2.dbG.dbO) {
          a(paramString2, false, true);
        }
      }
      for (;;)
      {
        a(6, paramString1, i, paramString3, paramInt2, paramString4, 9);
        AppMethodBeat.o(63806);
        return;
        ac.i("MicroMsg.F2fRcvVoiceListener", "onGetResult() needFailover:false");
        continue;
        aH(i, paramString1);
      }
    }
    a(i, paramArrayOfByte, 1, paramString1, 0, true);
    a(5, paramString1, i, paramString3, paramInt2, paramString4, 0);
    AppMethodBeat.o(63806);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(63805);
    ac.i("MicroMsg.F2fRcvVoiceListener", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramn.getType());
    if ((paramn instanceof i))
    {
      paramn = (i)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        ac.i("MicroMsg.F2fRcvVoiceListener", "overtime: %s retcode: %s", new Object[] { Integer.valueOf(paramn.owX.EmS), Integer.valueOf(paramn.owX.dae) });
        if (paramn.owX.EmS == 1)
        {
          ac.w("MicroMsg.F2fRcvVoiceListener", "skip over 10min: %s", new Object[] { Long.valueOf(paramn.fe) });
          h.wUl.f(14404, new Object[] { Integer.valueOf(3), paramn.dbJ, Integer.valueOf(1), "", Integer.valueOf(1) });
          AppMethodBeat.o(63805);
          return;
        }
        if ((paramn.owX.dae == 0) && (paramn.owX.EmR != null))
        {
          a(1, paramn.owX.EmR.xy, paramn.owX.EgR, paramn.dbJ, paramn.owX.EmS, false);
          h.wUl.f(15763, new Object[] { paramn.dbJ, Integer.valueOf(1), Integer.valueOf(Az(paramn.dbL)), Long.valueOf(paramn.owY), Integer.valueOf(bVM()) });
          AppMethodBeat.o(63805);
          return;
        }
        if (paramn.owX.dae <= 100)
        {
          paramInt1 = paramn.owX.dae;
          if (paramn.owX.EmR == null) {}
          for (paramString = "null";; paramString = "not null")
          {
            ac.i("MicroMsg.F2fRcvVoiceListener", "play default sound only %s %s", new Object[] { Integer.valueOf(paramInt1), paramString });
            aH(1, paramn.dbJ);
            h.wUl.f(15763, new Object[] { paramn.dbJ, Integer.valueOf(2), Integer.valueOf(Az(paramn.dbL)), Long.valueOf(paramn.owY), Integer.valueOf(bVM()) });
            AppMethodBeat.o(63805);
            return;
          }
        }
        ac.w("MicroMsg.F2fRcvVoiceListener", "retcode > 100, don't play");
        h.wUl.f(14404, new Object[] { Integer.valueOf(3), paramn.dbJ, Integer.valueOf(2), "", Integer.valueOf(1) });
        h.wUl.f(15763, new Object[] { paramn.dbJ, Integer.valueOf(2), Integer.valueOf(Az(paramn.dbL)), Long.valueOf(paramn.owY), Integer.valueOf(bVM()) });
        AppMethodBeat.o(63805);
        return;
      }
      ac.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", new Object[] { paramn });
      aH(1, paramn.dbJ);
      h.wUl.f(15763, new Object[] { paramn.dbJ, Integer.valueOf(2), Integer.valueOf(Az(paramn.dbL)), Long.valueOf(paramn.owY), Integer.valueOf(bVM()) });
      h.wUl.f(14404, new Object[] { Integer.valueOf(3), paramn.dbJ, Integer.valueOf(3), "", Integer.valueOf(1) });
      AppMethodBeat.o(63805);
      return;
    }
    if ((paramn instanceof o))
    {
      paramString = (o)paramn;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.oxs.dae == 0)
        {
          paramn = new com.tencent.mm.vfs.e(bVN());
          if ((!paramn.exists()) && (!paramn.mkdirs()))
          {
            ac.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
            AppMethodBeat.o(63805);
            return;
          }
          paramn = bVN() + UUID.randomUUID().toString() + ".tmp";
          ac.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", new Object[] { paramn });
          if (m(paramn, paramString.oxs.EmR.xy))
          {
            c localc = new c((byte)0);
            localc.fileName = paramn;
            localc.dhE = paramString.oxs.EgR;
            localc.owS = 2;
            this.owC.add(localc);
            bVK();
            AppMethodBeat.o(63805);
            return;
          }
          ac.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
          AppMethodBeat.o(63805);
          return;
        }
        h.wUl.f(14404, new Object[] { Integer.valueOf(3), paramString.dbJ, Integer.valueOf(2), "", Integer.valueOf(2) });
        AppMethodBeat.o(63805);
        return;
      }
      ac.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", new Object[] { paramString });
      h.wUl.f(14404, new Object[] { Integer.valueOf(3), paramString.dbJ, Integer.valueOf(3), "", Integer.valueOf(2) });
    }
    AppMethodBeat.o(63805);
  }
  
  final class c
  {
    String dbJ;
    int dhE;
    String fileName;
    int owS;
    int owT = 0;
    boolean owU = false;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.g
 * JD-Core Version:    0.7.0.1
 */