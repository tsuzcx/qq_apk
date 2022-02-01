package com.tencent.mm.plugin.luckymoney.story;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.e;
import com.tencent.mm.an.f;
import com.tencent.mm.i.a;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.i;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class EnvelopeStoryVideoManager
  implements LifecycleObserver
{
  private static Set<String> uqV;
  private boolean cQt;
  private boolean ftN;
  private com.tencent.mm.compatible.util.b ied;
  MMActivity nTA;
  private int uqT;
  Map<Integer, c> uqU;
  
  static
  {
    AppMethodBeat.i(163670);
    uqV = new HashSet();
    AppMethodBeat.o(163670);
  }
  
  public EnvelopeStoryVideoManager()
  {
    AppMethodBeat.i(163655);
    this.uqT = -1;
    this.ftN = true;
    this.ied = new com.tencent.mm.compatible.util.b(ai.getContext());
    this.cQt = false;
    this.uqU = new HashMap();
    AppMethodBeat.o(163655);
  }
  
  public static aw JW()
  {
    AppMethodBeat.i(210290);
    aw localaw = aw.aKT(cZL());
    AppMethodBeat.o(210290);
    return localaw;
  }
  
  private void a(Context paramContext, FrameLayout paramFrameLayout, ImageView paramImageView, ProgressBar paramProgressBar, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(174360);
    ac.i("MicroMsg.EnvelopeStoryVideoManager", "preapre video view");
    final c localc = (c)this.uqU.get(Integer.valueOf(paramInt3));
    if ((localc == null) || (localc.uro == null))
    {
      localc = new c();
      localc.uro = new EnvelopeStoryVideoView(paramContext);
      localc.url = paramString;
      localc.sessionId = UUID.randomUUID().toString();
      localc.pHG = paramImageView;
      localc.urr = paramProgressBar;
      localc.urp = ((ViewGroup)paramFrameLayout.findViewById(2131301966));
      localc.kUw = ((ImageView)paramFrameLayout.findViewById(2131301967));
      localc.kUN = ((ImageView)paramFrameLayout.findViewById(2131301784));
      localc.urq = ((ViewGroup)paramFrameLayout.findViewById(2131301782));
      localc.uro.setIsShowBasicControls(false);
      localc.uro.uru = new EnvelopeStoryVideoView.a()
      {
        public final void a(EnvelopeStoryVideoView paramAnonymousEnvelopeStoryVideoView)
        {
          AppMethodBeat.i(182457);
          int i = localc.urn.addAndGet(1);
          localc.urm = paramAnonymousEnvelopeStoryVideoView.getVideoDurationSec();
          ac.i("MicroMsg.EnvelopeStoryVideoManager", "sessionId: %s, current loop count: %s", new Object[] { localc.sessionId, Integer.valueOf(i) });
          AppMethodBeat.o(182457);
        }
      };
      localc.uro.setIMMVideoViewCallback(new h.b()
      {
        public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(182459);
          ac.e("MicroMsg.EnvelopeStoryVideoManager", "onError: %s, %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2, paramAnonymousString3 });
          com.tencent.mm.plugin.report.service.h.wUl.f(19228, new Object[] { localc.url, Integer.valueOf(localc.uro.getVideoDurationSec()), Integer.valueOf(2), Integer.valueOf(localc.urh), Integer.valueOf(localc.uro.getRealPlayDurationSec()), Integer.valueOf(localc.sIw), Integer.valueOf(0), Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(182459);
        }
        
        public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final void jdMethod_do(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182460);
          ac.i("MicroMsg.EnvelopeStoryVideoManager", "on prepared: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          localc.urm = localc.uro.getVideoDurationSec();
          ap.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(182458);
              if (EnvelopeStoryVideoManager.6.this.uqX.urr != null) {
                EnvelopeStoryVideoManager.6.this.uqX.urr.setVisibility(8);
              }
              if (EnvelopeStoryVideoManager.6.this.uqX.uro.getParent() != null) {
                ((ViewGroup)EnvelopeStoryVideoManager.6.this.uqX.uro.getParent()).bringToFront();
              }
              EnvelopeStoryVideoManager.6.this.uqX.kUN.setVisibility(0);
              AppMethodBeat.o(182458);
            }
          }, 10L);
          AppMethodBeat.o(182460);
        }
        
        public final void dp(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182461);
          ac.i("MicroMsg.EnvelopeStoryVideoManager", "on video end: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(182461);
        }
        
        public final void dq(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182462);
          ac.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoPause: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(182462);
        }
        
        public final void dr(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182463);
          ac.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoPlay: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(182463);
        }
        
        public final void ds(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182464);
          ac.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoWaiting: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          localc.urg = ((int)SystemClock.elapsedRealtime() / 1000);
          if (localc.urr != null)
          {
            localc.urr.bringToFront();
            localc.urr.setVisibility(0);
          }
          AppMethodBeat.o(182464);
        }
        
        public final void dt(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182465);
          ac.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoWaitingEnd: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          if (localc.urg > 0)
          {
            paramAnonymousString1 = localc;
            paramAnonymousString1.sIw = ((int)(paramAnonymousString1.sIw + (SystemClock.elapsedRealtime() / 1000L - localc.urg)));
            localc.urg = 0;
          }
          if (localc.urr != null) {
            localc.urr.setVisibility(8);
          }
          AppMethodBeat.o(182465);
        }
        
        public final void eJ(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(207104);
          ac.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoFirstFrameDraw: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(207104);
        }
      });
      localc.kUw.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(174356);
          ac.i("MicroMsg.EnvelopeStoryVideoManager", "click play btn");
          if ((localc.uro != null) && (localc.uro.isPlaying()))
          {
            AppMethodBeat.o(174356);
            return;
          }
          localc.kUw.setVisibility(4);
          EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this, localc);
          AppMethodBeat.o(174356);
        }
      });
      localc.uro.setMute(this.ftN);
      a(localc);
      localc.urp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(182466);
          boolean bool1;
          if ((EnvelopeStoryVideoManager.b(EnvelopeStoryVideoManager.this) != -1) && (localc.uro != null))
          {
            boolean bool2 = localc.uro.urs;
            paramAnonymousView = EnvelopeStoryVideoManager.this;
            if (bool2) {
              break label102;
            }
            bool1 = true;
            EnvelopeStoryVideoManager.a(paramAnonymousView, bool1);
            if (!bool2) {
              break label107;
            }
            EnvelopeStoryVideoManager.c(EnvelopeStoryVideoManager.this).requestFocus();
            EnvelopeStoryVideoManager.b(EnvelopeStoryVideoManager.this, true);
            localc.uro.setMute(false);
          }
          for (;;)
          {
            EnvelopeStoryVideoManager.e(localc);
            AppMethodBeat.o(182466);
            return;
            label102:
            bool1 = false;
            break;
            label107:
            if (EnvelopeStoryVideoManager.d(EnvelopeStoryVideoManager.this))
            {
              EnvelopeStoryVideoManager.c(EnvelopeStoryVideoManager.this).YC();
              EnvelopeStoryVideoManager.b(EnvelopeStoryVideoManager.this, false);
            }
            localc.uro.setMute(true);
          }
        }
      });
      paramContext = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      paramContext.gravity = 17;
      paramFrameLayout.addView(localc.uro, 0, paramContext);
      localc.urp.setLayoutParams(paramContext);
      this.uqU.put(Integer.valueOf(paramInt3), localc);
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174345);
          EnvelopeStoryVideoManager.d(localc);
          AppMethodBeat.o(174345);
        }
      });
      localc.uro.setSessionId(localc.sessionId);
      localc.uro.setIOnlineVideoProxy(new b(localc));
      localc.uro.c(false, localc.url, 0);
      localc.hYq = localc.uro.getMediaId();
      b(localc);
      AppMethodBeat.o(174360);
      return;
    }
    localc.uro.setMute(this.ftN);
    a(localc);
    ap.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174346);
        if ((localc.aVE) && (localc.uro.MZ()))
        {
          localc.uro.onUIResume();
          localc.urj = localc.uro.getCurrPosSec();
          localc.urk = 0L;
        }
        for (;;)
        {
          localc.urn.set(1);
          AppMethodBeat.o(174346);
          return;
          if (localc.uro.isPlaying())
          {
            ac.w("MicroMsg.EnvelopeStoryVideoManager", "resume fail, restart play");
            localc.uro.stop();
            localc.uro.start();
            localc.urj = 0L;
            localc.urk = 0L;
          }
        }
      }
    }, 200L);
    AppMethodBeat.o(174360);
  }
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(174361);
    if (paramc.uro.urs)
    {
      paramc.kUN.setImageResource(2131690762);
      AppMethodBeat.o(174361);
      return;
    }
    paramc.kUN.setImageResource(2131690768);
    AppMethodBeat.o(174361);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, g.a parama, h.a parama1)
  {
    int i = 2;
    AppMethodBeat.i(174367);
    ac.i("MicroMsg.EnvelopeStoryVideoManager", "trigger download video: %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    long l = SystemClock.elapsedRealtime();
    com.tencent.mm.i.h localh = new com.tencent.mm.i.h();
    localh.field_mediaId = paramString1;
    localh.field_fileId = paramString1;
    localh.url = paramString3;
    if (paramBoolean)
    {
      localh.frw = i;
      localh.field_preloadRatio = 20;
      localh.frs = new EnvelopeStoryVideoManager.10(paramString3, l);
      if (parama == null) {
        break label212;
      }
    }
    label212:
    for (localh.frb = parama;; localh.frb = new EnvelopeStoryVideoManager.2(paramString2))
    {
      localh.frr = 3;
      localh.field_fullpath = paramString2;
      localh.field_filemd5 = paramString4;
      localh.allow_mobile_net_download = true;
      localh.frE = parama1;
      localh.field_fileType = a.MediaType_VIDEO;
      localh.field_requestVideoFormat = 1;
      localh.frq = localh.frw;
      if (!paramBoolean) {
        break label255;
      }
      if (!uqV.contains(paramString1)) {
        break label228;
      }
      ac.w("MicroMsg.EnvelopeStoryVideoManager", "contains preload task: %s", new Object[] { paramString1 });
      AppMethodBeat.o(174367);
      return;
      i = 1;
      break;
    }
    label228:
    uqV.add(paramString1);
    f.aDD().b(localh, -1);
    AppMethodBeat.o(174367);
    return;
    label255:
    if (uqV.contains(paramString1))
    {
      ac.i("MicroMsg.EnvelopeStoryVideoManager", "need cancel preload task");
      f.aDD().BR(paramString1);
    }
    o.aJz().a(localh);
    AppMethodBeat.o(174367);
  }
  
  public static String akl(String paramString)
  {
    AppMethodBeat.i(163663);
    paramString = "MMVideo_" + paramString.hashCode();
    AppMethodBeat.o(163663);
    return paramString;
  }
  
  public static String akm(String paramString)
  {
    AppMethodBeat.i(163664);
    paramString = EnvelopeStoryVideoView.ROOT_PATH + "MMVideo_" + paramString.hashCode() + ".mp4";
    AppMethodBeat.o(163664);
    return paramString;
  }
  
  private void b(c paramc)
  {
    AppMethodBeat.i(174362);
    if (c(paramc)) {
      paramc.uro.setLocal(true);
    }
    paramc.pHG.bringToFront();
    if (paramc.urf > 0)
    {
      ac.d("MicroMsg.EnvelopeStoryVideoManager", "start play: %s", new Object[] { Integer.valueOf(paramc.urf) });
      paramc.uro.c(paramc.urf, true);
      paramc.urj = paramc.urf;
    }
    for (paramc.urk = 0L;; paramc.urk = 0L)
    {
      paramc.urn.set(1);
      if (!this.cQt)
      {
        this.ied.requestFocus();
        this.cQt = true;
      }
      paramc.aVE = true;
      b.urz += 1;
      b.ury.add(paramc.url);
      AppMethodBeat.o(174362);
      return;
      paramc.uro.start();
      paramc.urj = 0L;
    }
  }
  
  private static boolean c(c paramc)
  {
    AppMethodBeat.i(174363);
    boolean bool2 = i.eA(akm(paramc.url));
    if (aw.aKT(cZL()).getInt(paramc.hYq, 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ac.i("MicroMsg.EnvelopeStoryVideoManager", "can play local: %s, %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((!bool2) || (!bool1)) {
        break;
      }
      paramc.urh = 1;
      AppMethodBeat.o(174363);
      return true;
    }
    if (bool2) {}
    for (paramc.urh = 3;; paramc.urh = 2)
    {
      aw.aKT(cZL()).putInt(paramc.hYq, 0);
      AppMethodBeat.o(174363);
      return false;
    }
  }
  
  private c cZK()
  {
    AppMethodBeat.i(174366);
    c localc = (c)this.uqU.get(Integer.valueOf(this.uqT));
    AppMethodBeat.o(174366);
    return localc;
  }
  
  private static String cZL()
  {
    AppMethodBeat.i(163666);
    String str = ai.getPackageName() + "_luckymoney_story_video";
    AppMethodBeat.o(163666);
    return str;
  }
  
  public final void a(Context paramContext, FrameLayout paramFrameLayout, ImageView paramImageView, ProgressBar paramProgressBar, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(174364);
    ac.i("MicroMsg.EnvelopeStoryVideoManager", "update position: %s, %s, %s", new Object[] { Integer.valueOf(this.uqT), Integer.valueOf(paramInt3), paramString });
    if (paramInt3 != this.uqT)
    {
      c localc = (c)this.uqU.get(Integer.valueOf(this.uqT));
      if (localc != null)
      {
        ac.i("MicroMsg.EnvelopeStoryVideoManager", "pause previous video");
        if (localc.aVE)
        {
          localc.urk = localc.uro.getCurrPosSec();
          localc.uro.onUIPause();
        }
      }
      this.uqT = paramInt3;
      if (paramBoolean) {
        a(paramContext, paramFrameLayout, paramImageView, paramProgressBar, paramString, paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(174364);
      return;
    }
    ac.w("MicroMsg.EnvelopeStoryVideoManager", "skip same position");
    AppMethodBeat.o(174364);
  }
  
  public final void cZJ()
  {
    AppMethodBeat.i(174365);
    ac.i("MicroMsg.EnvelopeStoryVideoManager", "release video view: %s", new Object[] { Integer.valueOf(this.uqU.size()) });
    if (this.cQt)
    {
      this.ied.YC();
      this.cQt = false;
    }
    Iterator localIterator = this.uqU.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ac.d("MicroMsg.EnvelopeStoryVideoManager", "do stop");
      c localc = (c)localEntry.getValue();
      if (localc.urg > 0) {
        localc.sIw = ((int)(localc.sIw + (SystemClock.elapsedRealtime() / 1000L - localc.urg)));
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(19228, new Object[] { localc.url, Integer.valueOf(localc.uro.getVideoDurationSec()), Integer.valueOf(1), Integer.valueOf(localc.urh), Integer.valueOf(localc.uro.getRealPlayDurationSec()), Integer.valueOf(localc.sIw), Integer.valueOf(0), Integer.valueOf(0) });
      if (((c)localEntry.getValue()).uro.getParent() != null)
      {
        ((ViewGroup)((c)localEntry.getValue()).uro.getParent()).removeView(((c)localEntry.getValue()).uro);
        localc.uro.stop();
      }
    }
    this.uqU.clear();
    this.uqT = -1;
    AppMethodBeat.o(174365);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onUIDestroy()
  {
    AppMethodBeat.i(163661);
    AppMethodBeat.o(163661);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void onUIPause()
  {
    AppMethodBeat.i(163660);
    if (this.cQt)
    {
      this.ied.YC();
      this.cQt = false;
    }
    c localc = cZK();
    if (localc != null) {
      localc.uro.onUIPause();
    }
    AppMethodBeat.o(163660);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public void onUIResume()
  {
    AppMethodBeat.i(163659);
    c localc = cZK();
    if (localc != null)
    {
      localc.uro.onUIResume();
      if (localc.uro.isPlaying())
      {
        this.ied.requestFocus();
        this.cQt = true;
      }
    }
    AppMethodBeat.o(163659);
  }
  
  public final class a
    implements h.a
  {
    EnvelopeStoryVideoManager.c urb;
    
    public a(EnvelopeStoryVideoManager.c paramc)
    {
      this.urb = paramc;
    }
    
    public final void a(String paramString, int paramInt, d paramd)
    {
      AppMethodBeat.i(163648);
      if ((paramd != null) && (paramd.field_retCode == 0))
      {
        ac.i("MicroMsg.EnvelopeStoryVideoManager", "download finish: %s", new Object[] { paramString });
        EnvelopeStoryVideoManager.JW().putInt(paramString, 1).commit();
      }
      this.urb.uro.aq(paramString, paramInt);
      AppMethodBeat.o(163648);
    }
    
    public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
    {
      AppMethodBeat.i(207105);
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(163644);
          EnvelopeStoryVideoManager.a.this.urb.uro.qq(paramLong1);
          AppMethodBeat.o(163644);
        }
      });
      AppMethodBeat.o(207105);
    }
    
    public final void i(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(163647);
      this.urb.uro.i(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(163647);
    }
    
    public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(163646);
      this.urb.uro.onDataAvailable(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(163646);
    }
  }
  
  final class b
    implements com.tencent.mm.modelvideo.b
  {
    EnvelopeStoryVideoManager.c urb;
    
    public b(EnvelopeStoryVideoManager.c paramc)
    {
      this.urb = paramc;
    }
    
    public final void a(b.a parama) {}
    
    public final void fo(String paramString)
    {
      AppMethodBeat.i(163652);
      o.aJz().j(paramString, null);
      AppMethodBeat.o(163652);
    }
    
    public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(163654);
      boolean bool = o.aJz().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(163654);
      return bool;
    }
    
    public final void q(String paramString1, final String paramString2, final String paramString3)
    {
      AppMethodBeat.i(163651);
      EnvelopeStoryVideoManager.a locala = new EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this, this.urb);
      EnvelopeStoryVideoManager.a(paramString1, paramString2, paramString3, this.urb.md5, false, new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(163650);
          ac.i("MicroMsg.EnvelopeStoryVideoManager", "cdn callback: %s, %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt != 0)
          {
            i.deleteFile(paramString2);
            if (EnvelopeStoryVideoManager.b.this.urb.hYq.equals(paramAnonymousString))
            {
              ac.w("MicroMsg.EnvelopeStoryVideoManager", "download video fail: %s", new Object[] { paramString3 });
              EnvelopeStoryVideoManager.b.this.urb.urq.setVisibility(0);
              EnvelopeStoryVideoManager.b.this.urb.urq.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(163649);
                  ac.i("MicroMsg.EnvelopeStoryVideoManager", "click retry btn");
                  EnvelopeStoryVideoManager.b.this.urb.sessionId = UUID.randomUUID().toString();
                  EnvelopeStoryVideoManager.b.this.urb.uro.setSessionId(EnvelopeStoryVideoManager.b.this.urb.sessionId);
                  EnvelopeStoryVideoManager.b.this.urb.uro.setLocal(false);
                  EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this, EnvelopeStoryVideoManager.b.this.urb);
                  AppMethodBeat.o(163649);
                }
              });
              com.tencent.mm.plugin.report.service.h.wUl.f(19228, new Object[] { EnvelopeStoryVideoManager.b.this.urb.url, Integer.valueOf(EnvelopeStoryVideoManager.b.this.urb.uro.getVideoDurationSec()), Integer.valueOf(2), Integer.valueOf(EnvelopeStoryVideoManager.b.this.urb.urh), Integer.valueOf(EnvelopeStoryVideoManager.b.this.urb.uro.getRealPlayDurationSec()), Integer.valueOf(EnvelopeStoryVideoManager.b.this.urb.sIw), Integer.valueOf(0), Integer.valueOf(-9999) });
            }
          }
          AppMethodBeat.o(163650);
          return 0;
        }
        
        public final void a(String paramAnonymousString, ByteArrayOutputStream paramAnonymousByteArrayOutputStream) {}
        
        public final byte[] f(String paramAnonymousString, byte[] paramAnonymousArrayOfByte)
        {
          return new byte[0];
        }
      }, locala);
      AppMethodBeat.o(163651);
    }
    
    public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(163653);
      ac.d("MicroMsg.EnvelopeStoryVideoManager", "request video data: %s", new Object[] { paramString });
      o.aJz();
      e.p(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(163653);
    }
  }
  
  public static final class c
  {
    boolean aVE;
    boolean ftN;
    String hYq;
    ImageView kUN;
    ImageView kUw;
    String md5;
    ImageView pHG;
    int sIw;
    String sessionId;
    int urf;
    int urg;
    int urh;
    long urj;
    long urk;
    String url;
    long urm;
    AtomicInteger urn;
    EnvelopeStoryVideoView uro;
    ViewGroup urp;
    ViewGroup urq;
    ProgressBar urr;
    
    public c()
    {
      AppMethodBeat.i(182469);
      this.ftN = true;
      this.aVE = false;
      this.urg = 0;
      this.sIw = 0;
      this.urn = new AtomicInteger(1);
      AppMethodBeat.o(182469);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager
 * JD-Core Version:    0.7.0.1
 */