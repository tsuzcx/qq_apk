package com.tencent.mm.plugin.collect.model;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.cv;
import com.tencent.mm.autogen.a.cv.a;
import com.tencent.mm.autogen.mmdata.rpt.ri;
import com.tencent.mm.compatible.b.k;
import com.tencent.mm.plugin.collect.model.voice.a.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.xr;
import com.tencent.mm.protocal.protobuf.ya;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.c.d;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;

public class F2fRcvVoiceListener
  extends IListener<cv>
  implements com.tencent.mm.am.h, a.c
{
  private static final com.tencent.mm.bx.b wYe;
  private static HandlerThread wYp;
  private boolean hLy;
  private MediaPlayer wYf;
  private MediaPlayer wYg;
  public ConcurrentLinkedQueue<c> wYh;
  private int wYi;
  private int wYj;
  private long wYk;
  private WeakReference<ArrayList<String>> wYl;
  private ri wYm;
  private Map<String, cv> wYn;
  private final long wYo;
  
  static
  {
    AppMethodBeat.i(63818);
    wYe = com.tencent.mm.bx.b.bsj("元");
    wYp = d.jx("syncCreatePlayer", 5);
    AppMethodBeat.o(63818);
  }
  
  public F2fRcvVoiceListener()
  {
    super(com.tencent.mm.app.f.hfK);
    AppMethodBeat.i(63797);
    this.hLy = false;
    this.wYn = new HashMap();
    this.wYo = 10000L;
    this.__eventId = cv.class.getName().hashCode();
    AppMethodBeat.o(63797);
  }
  
  private static int Jn(int paramInt)
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
    this.wYm = new ri();
    this.wYm.iqr = paramInt1;
    this.wYm.ym(paramString1);
    if (!Util.isEqual(paramInt4, 0)) {
      this.wYm.jvG = paramInt4;
    }
    this.wYm.ixD = paramInt2;
    paramString1 = paramString2;
    if (paramString2.contains(",")) {
      paramString1 = paramString2.replaceAll(",", "").trim();
    }
    this.wYm.yn(paramString1);
    this.wYm.jvK = paramInt3;
    if (Util.isEqual(paramInt1, 6)) {
      this.wYm.yo(paramString3);
    }
    this.wYm.bMH();
    AppMethodBeat.o(63810);
  }
  
  private void a(int paramInt1, byte[] paramArrayOfByte, int paramInt2, String paramString, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(63807);
    Object localObject = new u(drE());
    if ((!((u)localObject).jKS()) && (!((u)localObject).jKY()))
    {
      Log.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
      AppMethodBeat.o(63807);
      return;
    }
    localObject = drE() + UUID.randomUUID().toString() + ".tmp";
    Log.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", new Object[] { localObject });
    if (s((String)localObject, paramArrayOfByte))
    {
      paramArrayOfByte = new c((byte)0);
      paramArrayOfByte.fileName = ((String)localObject);
      paramArrayOfByte.hIY = paramInt2;
      paramArrayOfByte.wYv = paramInt1;
      paramArrayOfByte.hCI = paramString;
      paramArrayOfByte.wYw = paramInt3;
      paramArrayOfByte.wYx = paramBoolean;
      this.wYh.add(paramArrayOfByte);
      drB();
      AppMethodBeat.o(63807);
      return;
    }
    Log.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
    AppMethodBeat.o(63807);
  }
  
  private void a(cv paramcv, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(63798);
    Log.i("MicroMsg.F2fRcvVoiceListener", "callbackImp() tradeNo:%s useOffline:%s", new Object[] { paramcv.hCG.hCI, Boolean.valueOf(paramBoolean1) });
    long l = paramcv.hCG.delay;
    if (paramcv.hCG.hCJ.equals("wx_f2f"))
    {
      com.tencent.mm.plugin.collect.app.a.dru();
      boolean bool = com.tencent.mm.plugin.collect.app.a.drw();
      Log.i("MicroMsg.F2fRcvVoiceListener", "on recv, fee: %s, voice open: %B", new Object[] { Integer.valueOf(paramcv.hCG.fee), Boolean.valueOf(bool) });
      if ((paramBoolean2) || (!amf(paramcv.hCG.hCI)))
      {
        if (paramcv.hCG.source == 0) {
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(699L, 8L, 1L, false);
        }
        for (;;)
        {
          if ((paramBoolean1) && (!com.tencent.mm.plugin.collect.model.voice.a.wZn) && (!Util.isNullOrNil(paramcv.hCG.hCK)))
          {
            Log.i("MicroMsg.F2fRcvVoiceListener", "init tts");
            com.tencent.mm.plugin.collect.model.voice.a.drL().nu(false);
          }
          if ((!paramBoolean1) || (!com.tencent.mm.plugin.collect.model.voice.a.wZn) || (Util.isNullOrNil(paramcv.hCG.hCK))) {
            break;
          }
          Log.i("MicroMsg.F2fRcvVoiceListener", "useOffline");
          this.wYn.put(paramcv.hCG.hCI, paramcv);
          com.tencent.mm.plugin.collect.model.voice.a.drL().a(paramcv);
          AppMethodBeat.o(63798);
          return;
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(699L, 9L, 1L, false);
        }
        Log.i("MicroMsg.F2fRcvVoiceListener", "useOnline");
        paramcv = new h(paramcv.hCG.fee, wYe, paramcv.hCG.hCI, paramcv.hCG.source, l);
        com.tencent.mm.kernel.h.baF();
        com.tencent.mm.kernel.h.baD().mCm.a(paramcv, 0);
      }
      AppMethodBeat.o(63798);
      return;
    }
    if (paramcv.hCG.hCJ.equals("wx_md"))
    {
      if ((paramBoolean1) && (com.tencent.mm.plugin.collect.model.voice.a.wZn) && (!Util.isNullOrNil(paramcv.hCG.hCK)))
      {
        this.wYn.put(paramcv.hCG.hCI, paramcv);
        com.tencent.mm.plugin.collect.model.voice.a.drL().a(paramcv);
        AppMethodBeat.o(63798);
        return;
      }
      paramcv = new n(paramcv.hCG.fee, wYe, paramcv.hCG.hCI);
      com.tencent.mm.kernel.h.baF();
      com.tencent.mm.kernel.h.baD().mCm.a(paramcv, 0);
      AppMethodBeat.o(63798);
      return;
    }
    Log.w("MicroMsg.F2fRcvVoiceListener", "unknown type: %s", new Object[] { paramcv.hCG.hCJ });
    AppMethodBeat.o(63798);
  }
  
  private void a(final c paramc)
  {
    AppMethodBeat.i(63804);
    this.wYg = F2fRcvVoiceListener.a.a(paramc.fileName, new MediaPlayer.OnCompletionListener()new MediaPlayer.OnErrorListener
    {
      public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
      {
        AppMethodBeat.i(63789);
        Log.i("MicroMsg.F2fRcvVoiceListener", "play done");
        F2fRcvVoiceListener.e(F2fRcvVoiceListener.this);
        F2fRcvVoiceListener.i(F2fRcvVoiceListener.this);
        F2fRcvVoiceListener.f(F2fRcvVoiceListener.this);
        if (!F2fRcvVoiceListener.g(F2fRcvVoiceListener.this).isEmpty())
        {
          F2fRcvVoiceListener.h(F2fRcvVoiceListener.this);
          AppMethodBeat.o(63789);
          return;
        }
        F2fRcvVoiceListener.drF();
        AppMethodBeat.o(63789);
      }
    }, new MediaPlayer.OnErrorListener()new F2fRcvVoiceListener.b
    {
      public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(63790);
        Log.e("MicroMsg.F2fRcvVoiceListener", "play money error: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        F2fRcvVoiceListener.e(F2fRcvVoiceListener.this);
        F2fRcvVoiceListener.i(F2fRcvVoiceListener.this);
        com.tencent.mm.plugin.report.service.h.OAn.b(14404, new Object[] { Integer.valueOf(3), paramc.hCI, Integer.valueOf(7), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramc.wYv) });
        F2fRcvVoiceListener.f(F2fRcvVoiceListener.this);
        if (!F2fRcvVoiceListener.g(F2fRcvVoiceListener.this).isEmpty()) {
          F2fRcvVoiceListener.h(F2fRcvVoiceListener.this);
        }
        for (;;)
        {
          AppMethodBeat.o(63790);
          return false;
          F2fRcvVoiceListener.drF();
        }
      }
    }, new F2fRcvVoiceListener.b()
    {
      public final void drH()
      {
        AppMethodBeat.i(293520);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1143L, 41L, 1L, false);
        if (com.tencent.mm.plugin.collect.app.a.dru().wXU)
        {
          Log.i("MicroMsg.F2fRcvVoiceListener", "play isForground");
          if (paramc.wYx)
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(14404, new Object[] { Integer.valueOf(1), paramc.hCI, "", "", Integer.valueOf(paramc.wYv), "", "", "", com.tencent.mm.plugin.collect.model.voice.a.drL().drS() });
            AppMethodBeat.o(293520);
            return;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(14404, new Object[] { Integer.valueOf(1), paramc.hCI, "", "", Integer.valueOf(paramc.wYv) });
          AppMethodBeat.o(293520);
          return;
        }
        Log.i("MicroMsg.F2fRcvVoiceListener", "play isBackground");
        if (paramc.wYx)
        {
          com.tencent.mm.plugin.report.service.h.OAn.b(14404, new Object[] { Integer.valueOf(2), paramc.hCI, "", "", Integer.valueOf(paramc.wYv), "", "", "", com.tencent.mm.plugin.collect.model.voice.a.drL().drS() });
          AppMethodBeat.o(293520);
          return;
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(14404, new Object[] { Integer.valueOf(2), paramc.hCI, "", "", Integer.valueOf(paramc.wYv) });
        AppMethodBeat.o(293520);
      }
    });
    AppMethodBeat.o(63804);
  }
  
  private boolean amf(String paramString)
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
        List localList = drz();
        Iterator localIterator = drz().iterator();
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
            com.tencent.mm.kernel.h.baE().ban().set(at.a.acWi, Util.listToString(paramString, ","));
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
  
  private static int amg(String paramString)
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
  
  private void ba(int paramInt, String paramString)
  {
    AppMethodBeat.i(63808);
    Log.i("MicroMsg.F2fRcvVoiceListener", "play default sound only");
    c localc = new c((byte)0);
    localc.wYv = paramInt;
    localc.hCI = paramString;
    this.wYh.add(localc);
    drB();
    AppMethodBeat.o(63808);
  }
  
  public static boolean drA()
  {
    AppMethodBeat.i(63802);
    Log.i("MicroMsg.F2fRcvVoiceListener", "delete files");
    boolean bool = y.ew(drE(), true);
    AppMethodBeat.o(63802);
    return bool;
  }
  
  private void drB()
  {
    for (;;)
    {
      final c localc;
      try
      {
        AppMethodBeat.i(63803);
        long l1 = System.currentTimeMillis();
        long l2 = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.znD, 10000L);
        Log.i("MicroMsg.F2fRcvVoiceListener", "voiceOvertime: %s", new Object[] { Long.valueOf(l2) });
        if ((this.hLy) && (l1 - this.wYk > l2))
        {
          Log.i("MicroMsg.F2fRcvVoiceListener", "last has outdate: %s", new Object[] { Long.valueOf(this.wYk) });
          com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(1143L, 42L, 1L, false);
          this.hLy = false;
        }
        if (this.hLy)
        {
          Log.i("MicroMsg.F2fRcvVoiceListener", "is playing, return");
          AppMethodBeat.o(63803);
          return;
        }
        this.hLy = true;
        this.wYk = System.currentTimeMillis();
        localc = (c)this.wYh.poll();
        i = com.tencent.mm.plugin.audio.c.a.getStreamMaxVolume(3);
        this.wYi = com.tencent.mm.plugin.audio.c.a.getStreamVolume(3);
        this.wYj = Math.round(i * 0.5F);
        Log.i("MicroMsg.F2fRcvVoiceListener", "curVol: %s, maxVol: %s, minVol: %s", new Object[] { Integer.valueOf(this.wYi), Integer.valueOf(i), Integer.valueOf(this.wYj) });
        if (Build.VERSION.SDK_INT < 23) {
          break label699;
        }
        bool = com.tencent.mm.plugin.audio.c.a.cUb();
        Log.i("MicroMsg.F2fRcvVoiceListener", "isMute: %s", new Object[] { Boolean.valueOf(bool) });
        if ((this.wYi == 0) || (bool))
        {
          Log.i("MicroMsg.F2fRcvVoiceListener", "music channel is mute");
          if (localc != null)
          {
            i = localc.wYv;
            com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
            if (localc == null) {
              break label467;
            }
            String str1 = localc.hCI;
            localh.b(14404, new Object[] { Integer.valueOf(3), str1, Integer.valueOf(5), "", Integer.valueOf(i) });
          }
        }
        else
        {
          if ((this.wYi > 0) && (this.wYi < this.wYj) && (!bool)) {
            com.tencent.mm.plugin.audio.c.a.gi(3, this.wYj);
          }
          if (localc == null) {
            break label685;
          }
          Log.i("MicroMsg.F2fRcvVoiceListener", "holder.offLine = %s", new Object[] { Boolean.valueOf(localc.wYx) });
          if (!localc.wYx) {
            break label491;
          }
          a(localc);
          if ((!this.hLy) || (this.wYg != null)) {
            break label474;
          }
          Log.i("MicroMsg.F2fRcvVoiceListener", "isPlaying && moneyPlayer == null");
          AppMethodBeat.o(63803);
          continue;
        }
        i = 1;
      }
      finally {}
      continue;
      label467:
      String str2 = "";
      continue;
      label474:
      Log.i("MicroMsg.F2fRcvVoiceListener", "has played");
      AppMethodBeat.o(63803);
      continue;
      label491:
      int i = a.i.collect_prefix_voice;
      int j = localc.wYv;
      if (j == 2) {
        i = a.i.collect_prefix_voice;
      }
      if (!Util.isNullOrNil(localc.fileName))
      {
        Log.i("MicroMsg.F2fRcvVoiceListener", "play prefix voice: %d", new Object[] { Integer.valueOf(j) });
        this.wYf = F2fRcvVoiceListener.a.a(MMApplicationContext.getContext(), i, new MediaPlayer.OnCompletionListener()new MediaPlayer.OnErrorListener
        {
          public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            AppMethodBeat.i(63784);
            Log.i("MicroMsg.F2fRcvVoiceListener", "start play money");
            if ((F2fRcvVoiceListener.a(F2fRcvVoiceListener.this) != null) && (F2fRcvVoiceListener.b(F2fRcvVoiceListener.this)) && (F2fRcvVoiceListener.c(F2fRcvVoiceListener.this) == null)) {
              F2fRcvVoiceListener.a(F2fRcvVoiceListener.this, localc);
            }
            for (;;)
            {
              F2fRcvVoiceListener.d(F2fRcvVoiceListener.this);
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
            F2fRcvVoiceListener.e(F2fRcvVoiceListener.this);
            F2fRcvVoiceListener.d(F2fRcvVoiceListener.this);
            F2fRcvVoiceListener.f(F2fRcvVoiceListener.this);
            com.tencent.mm.plugin.report.service.h.OAn.b(14404, new Object[] { Integer.valueOf(3), localc.hCI, Integer.valueOf(7), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(localc.wYv) });
            if (!F2fRcvVoiceListener.g(F2fRcvVoiceListener.this).isEmpty()) {
              F2fRcvVoiceListener.h(F2fRcvVoiceListener.this);
            }
            for (;;)
            {
              AppMethodBeat.o(63785);
              return false;
              F2fRcvVoiceListener.drF();
            }
          }
        });
        if (this.wYf != null)
        {
          i = this.wYf.getDuration();
          Log.i("MicroMsg.F2fRcvVoiceListener", "prefix duration: %s", new Object[] { Integer.valueOf(i) });
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(63786);
              if ((F2fRcvVoiceListener.a(F2fRcvVoiceListener.this) != null) && (F2fRcvVoiceListener.b(F2fRcvVoiceListener.this)) && (F2fRcvVoiceListener.c(F2fRcvVoiceListener.this) == null))
              {
                Log.i("MicroMsg.F2fRcvVoiceListener", "this play may error");
                com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(699L, 1L, 1L, false);
              }
              AppMethodBeat.o(63786);
            }
          }, i + 1000);
          AppMethodBeat.o(63803);
        }
      }
      else
      {
        this.wYf = F2fRcvVoiceListener.a.a(MMApplicationContext.getContext(), i, new MediaPlayer.OnCompletionListener()new MediaPlayer.OnErrorListener
        {
          public final void onCompletion(MediaPlayer paramAnonymousMediaPlayer)
          {
            AppMethodBeat.i(63787);
            Log.i("MicroMsg.F2fRcvVoiceListener", "no need to play money this time");
            F2fRcvVoiceListener.f(F2fRcvVoiceListener.this);
            F2fRcvVoiceListener.e(F2fRcvVoiceListener.this);
            F2fRcvVoiceListener.d(F2fRcvVoiceListener.this);
            com.tencent.mm.plugin.collect.app.a.dru();
            com.tencent.mm.plugin.report.service.h.OAn.b(14404, new Object[] { Integer.valueOf(4), localc.hCI, "", "", Integer.valueOf(localc.wYv) });
            if (!F2fRcvVoiceListener.g(F2fRcvVoiceListener.this).isEmpty())
            {
              F2fRcvVoiceListener.h(F2fRcvVoiceListener.this);
              AppMethodBeat.o(63787);
              return;
            }
            F2fRcvVoiceListener.drF();
            AppMethodBeat.o(63787);
          }
        }, new MediaPlayer.OnErrorListener()
        {
          public final boolean onError(MediaPlayer paramAnonymousMediaPlayer, int paramAnonymousInt1, int paramAnonymousInt2)
          {
            AppMethodBeat.i(63788);
            Log.e("MicroMsg.F2fRcvVoiceListener", "no need play money error");
            F2fRcvVoiceListener.f(F2fRcvVoiceListener.this);
            F2fRcvVoiceListener.e(F2fRcvVoiceListener.this);
            F2fRcvVoiceListener.d(F2fRcvVoiceListener.this);
            com.tencent.mm.plugin.report.service.h.OAn.b(14404, new Object[] { Integer.valueOf(3), localc.hCI, Integer.valueOf(7), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(localc.wYv) });
            AppMethodBeat.o(63788);
            return false;
          }
        });
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(699L, 2L, 1L, false);
      }
      AppMethodBeat.o(63803);
      continue;
      label685:
      this.hLy = false;
      AppMethodBeat.o(63803);
      continue;
      label699:
      boolean bool = false;
    }
  }
  
  private static MediaPlayer drC()
  {
    AppMethodBeat.i(293599);
    Object localObject1 = Looper.myLooper();
    Log.i("MicroMsg.F2fRcvVoiceListener", "[syncCreatePlayer] %s", new Object[] { localObject1 });
    if ((localObject1 != null) && (localObject1 != Looper.getMainLooper()) && (localObject1 != wYp.getLooper()))
    {
      if (!wYp.isAlive()) {
        wYp.start();
      }
      MMHandler localMMHandler = new MMHandler(wYp.getLooper());
      localObject1 = new Object();
      MediaPlayer[] arrayOfMediaPlayer = new MediaPlayer[1];
      arrayOfMediaPlayer[0] = null;
      try
      {
        localMMHandler.post(new F2fRcvVoiceListener.9(arrayOfMediaPlayer, localObject1));
        try
        {
          localObject1.wait();
          localObject1 = arrayOfMediaPlayer[0];
          AppMethodBeat.o(293599);
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
        AppMethodBeat.o(293599);
      }
    }
    AppMethodBeat.o(293599);
    return localObject1;
  }
  
  private static int drD()
  {
    AppMethodBeat.i(63811);
    if (com.tencent.mm.plugin.audio.c.a.cTX())
    {
      AppMethodBeat.o(63811);
      return 1;
    }
    AppMethodBeat.o(63811);
    return 0;
  }
  
  private static String drE()
  {
    AppMethodBeat.i(63812);
    String str = com.tencent.mm.loader.i.b.bmz() + "wallet/voice/";
    AppMethodBeat.o(63812);
    return str;
  }
  
  private List<String> drz()
  {
    AppMethodBeat.i(63799);
    if ((this.wYl == null) || (this.wYl.get() == null))
    {
      Log.i("MicroMsg.F2fRcvVoiceListener", "refer is null");
      this.wYl = new WeakReference(new ArrayList(Util.stringToList((String)com.tencent.mm.kernel.h.baE().ban().get(at.a.acWi, ""), ",")));
    }
    List localList = (List)this.wYl.get();
    AppMethodBeat.o(63799);
    return localList;
  }
  
  private static boolean s(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(63801);
    com.tencent.mm.kernel.h.baF();
    if (!com.tencent.mm.kernel.h.baE().isSDCardAvailable())
    {
      Log.i("MicroMsg.F2fRcvVoiceListener", "sd card not available");
      AppMethodBeat.o(63801);
      return false;
    }
    if (y.f(paramString, paramArrayOfByte, paramArrayOfByte.length) == 0)
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
    int i = amg(paramString2);
    paramString2 = (cv)this.wYn.remove(paramString1);
    if (paramInt1 < 0)
    {
      if (paramString2 != null) {
        if (paramString2.hCG.hCM) {
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
        ba(i, paramString1);
      }
    }
    a(i, paramArrayOfByte, 1, paramString1, 0, true);
    a(5, paramString1, i, paramString3, paramInt2, paramString4, 0);
    AppMethodBeat.o(63806);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(63805);
    Log.i("MicroMsg.F2fRcvVoiceListener", "errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " scenetype:" + paramp.getType());
    if ((paramp instanceof h))
    {
      paramp = (h)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Log.i("MicroMsg.F2fRcvVoiceListener", "overtime: %s retcode: %s", new Object[] { Integer.valueOf(paramp.wYA.Zgy), Integer.valueOf(paramp.wYA.hAV) });
        if (paramp.wYA.Zgy == 1)
        {
          Log.w("MicroMsg.F2fRcvVoiceListener", "skip over 10min: %s", new Object[] { Long.valueOf(paramp.delay) });
          com.tencent.mm.plugin.report.service.h.OAn.b(14404, new Object[] { Integer.valueOf(3), paramp.hCI, Integer.valueOf(1), "", Integer.valueOf(1) });
          AppMethodBeat.o(63805);
          return;
        }
        if ((paramp.wYA.hAV == 0) && (paramp.wYA.Zgx != null))
        {
          a(1, paramp.wYA.Zgx.Op, paramp.wYA.Zae, paramp.hCI, paramp.wYA.Zgy, false);
          com.tencent.mm.plugin.report.service.h.OAn.b(15763, new Object[] { paramp.hCI, Integer.valueOf(1), Integer.valueOf(Jn(paramp.source)), Long.valueOf(paramp.wYB), Integer.valueOf(drD()) });
          AppMethodBeat.o(63805);
          return;
        }
        if (paramp.wYA.hAV <= 100)
        {
          paramInt1 = paramp.wYA.hAV;
          if (paramp.wYA.Zgx == null) {}
          for (paramString = "null";; paramString = "not null")
          {
            Log.i("MicroMsg.F2fRcvVoiceListener", "play default sound only %s %s", new Object[] { Integer.valueOf(paramInt1), paramString });
            ba(1, paramp.hCI);
            com.tencent.mm.plugin.report.service.h.OAn.b(15763, new Object[] { paramp.hCI, Integer.valueOf(2), Integer.valueOf(Jn(paramp.source)), Long.valueOf(paramp.wYB), Integer.valueOf(drD()) });
            AppMethodBeat.o(63805);
            return;
          }
        }
        Log.i("MicroMsg.F2fRcvVoiceListener", "retcode > 100, still play default sound");
        ba(1, paramp.hCI);
        com.tencent.mm.plugin.report.service.h.OAn.b(14404, new Object[] { Integer.valueOf(3), paramp.hCI, Integer.valueOf(2), "", Integer.valueOf(1) });
        com.tencent.mm.plugin.report.service.h.OAn.b(15763, new Object[] { paramp.hCI, Integer.valueOf(2), Integer.valueOf(Jn(paramp.source)), Long.valueOf(paramp.wYB), Integer.valueOf(drD()) });
        AppMethodBeat.o(63805);
        return;
      }
      Log.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", new Object[] { paramp });
      ba(1, paramp.hCI);
      com.tencent.mm.plugin.report.service.h.OAn.b(15763, new Object[] { paramp.hCI, Integer.valueOf(2), Integer.valueOf(Jn(paramp.source)), Long.valueOf(paramp.wYB), Integer.valueOf(drD()) });
      com.tencent.mm.plugin.report.service.h.OAn.b(14404, new Object[] { Integer.valueOf(3), paramp.hCI, Integer.valueOf(3), "", Integer.valueOf(1) });
      AppMethodBeat.o(63805);
      return;
    }
    if ((paramp instanceof n))
    {
      paramString = (n)paramp;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.wYV.hAV == 0)
        {
          paramp = new u(drE());
          if ((!paramp.jKS()) && (!paramp.jKY()))
          {
            Log.i("MicroMsg.F2fRcvVoiceListener", "mk dir fail");
            AppMethodBeat.o(63805);
            return;
          }
          paramp = drE() + UUID.randomUUID().toString() + ".tmp";
          Log.i("MicroMsg.F2fRcvVoiceListener", "fileName: %s", new Object[] { paramp });
          if (s(paramp, paramString.wYV.Zgx.Op))
          {
            c localc = new c((byte)0);
            localc.fileName = paramp;
            localc.hIY = paramString.wYV.Zae;
            localc.wYv = 2;
            this.wYh.add(localc);
            drB();
            AppMethodBeat.o(63805);
            return;
          }
          Log.i("MicroMsg.F2fRcvVoiceListener", "save file fail");
          AppMethodBeat.o(63805);
          return;
        }
        com.tencent.mm.plugin.report.service.h.OAn.b(14404, new Object[] { Integer.valueOf(3), paramString.hCI, Integer.valueOf(2), "", Integer.valueOf(2) });
        AppMethodBeat.o(63805);
        return;
      }
      Log.e("MicroMsg.F2fRcvVoiceListener", "net error: %s", new Object[] { paramString });
      com.tencent.mm.plugin.report.service.h.OAn.b(14404, new Object[] { Integer.valueOf(3), paramString.hCI, Integer.valueOf(3), "", Integer.valueOf(2) });
    }
    AppMethodBeat.o(63805);
  }
  
  final class c
  {
    String fileName;
    String hCI;
    int hIY;
    int wYv;
    int wYw = 0;
    boolean wYx = false;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.model.F2fRcvVoiceListener
 * JD-Core Version:    0.7.0.1
 */