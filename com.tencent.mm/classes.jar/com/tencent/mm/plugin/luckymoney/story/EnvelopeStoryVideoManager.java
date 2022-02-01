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
import com.tencent.mm.ao.e;
import com.tencent.mm.ao.f;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ax;
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
  private static Set<String> vtA;
  private boolean dbJ;
  private boolean fMP;
  private com.tencent.mm.compatible.util.b ixy;
  MMActivity owV;
  private int vty;
  Map<Integer, c> vtz;
  
  static
  {
    AppMethodBeat.i(163670);
    vtA = new HashSet();
    AppMethodBeat.o(163670);
  }
  
  public EnvelopeStoryVideoManager()
  {
    AppMethodBeat.i(163655);
    this.vty = -1;
    this.fMP = true;
    this.ixy = new com.tencent.mm.compatible.util.b(aj.getContext());
    this.dbJ = false;
    this.vtz = new HashMap();
    AppMethodBeat.o(163655);
  }
  
  public static ax Lv()
  {
    AppMethodBeat.i(221330);
    ax localax = ax.aQz(diX());
    AppMethodBeat.o(221330);
    return localax;
  }
  
  private void a(Context paramContext, FrameLayout paramFrameLayout, ImageView paramImageView, ProgressBar paramProgressBar, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(174360);
    ad.i("MicroMsg.EnvelopeStoryVideoManager", "preapre video view");
    final c localc = (c)this.vtz.get(Integer.valueOf(paramInt3));
    if ((localc == null) || (localc.vtR == null))
    {
      localc = new c();
      localc.vtR = new EnvelopeStoryVideoView(paramContext);
      localc.url = paramString;
      localc.sessionId = UUID.randomUUID().toString();
      localc.qll = paramImageView;
      localc.vtU = paramProgressBar;
      localc.vtS = ((ViewGroup)paramFrameLayout.findViewById(2131301966));
      localc.lru = ((ImageView)paramFrameLayout.findViewById(2131301967));
      localc.lrL = ((ImageView)paramFrameLayout.findViewById(2131301784));
      localc.vtT = ((ViewGroup)paramFrameLayout.findViewById(2131301782));
      localc.vtR.setIsShowBasicControls(false);
      localc.vtR.vtX = new EnvelopeStoryVideoView.a()
      {
        public final void a(EnvelopeStoryVideoView paramAnonymousEnvelopeStoryVideoView)
        {
          AppMethodBeat.i(182457);
          int i = localc.vtQ.addAndGet(1);
          localc.vtP = paramAnonymousEnvelopeStoryVideoView.getVideoDurationSec();
          ad.i("MicroMsg.EnvelopeStoryVideoManager", "sessionId: %s, current loop count: %s", new Object[] { localc.sessionId, Integer.valueOf(i) });
          AppMethodBeat.o(182457);
        }
      };
      localc.vtR.setIMMVideoViewCallback(new i.b()
      {
        public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(182459);
          ad.e("MicroMsg.EnvelopeStoryVideoManager", "onError: %s, %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2, paramAnonymousString3 });
          g.yhR.f(19228, new Object[] { localc.url, Integer.valueOf(localc.vtR.getVideoDurationSec()), Integer.valueOf(2), Integer.valueOf(localc.vtM), Integer.valueOf(localc.vtR.getRealPlayDurationSec()), Integer.valueOf(localc.tFh), Integer.valueOf(0), Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(182459);
        }
        
        public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final void dq(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182460);
          ad.i("MicroMsg.EnvelopeStoryVideoManager", "on prepared: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          localc.vtP = localc.vtR.getVideoDurationSec();
          aq.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(182458);
              if (EnvelopeStoryVideoManager.6.this.vtC.vtU != null) {
                EnvelopeStoryVideoManager.6.this.vtC.vtU.setVisibility(8);
              }
              if (EnvelopeStoryVideoManager.6.this.vtC.vtR.getParent() != null) {
                ((ViewGroup)EnvelopeStoryVideoManager.6.this.vtC.vtR.getParent()).bringToFront();
              }
              EnvelopeStoryVideoManager.6.this.vtC.lrL.setVisibility(0);
              AppMethodBeat.o(182458);
            }
          }, 10L);
          AppMethodBeat.o(182460);
        }
        
        public final void dr(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182461);
          ad.i("MicroMsg.EnvelopeStoryVideoManager", "on video end: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(182461);
        }
        
        public final void ds(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182462);
          ad.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoPause: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(182462);
        }
        
        public final void dt(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182463);
          ad.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoPlay: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(182463);
        }
        
        public final void du(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182464);
          ad.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoWaiting: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          localc.vtL = ((int)SystemClock.elapsedRealtime() / 1000);
          if (localc.vtU != null)
          {
            localc.vtU.bringToFront();
            localc.vtU.setVisibility(0);
          }
          AppMethodBeat.o(182464);
        }
        
        public final void dv(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182465);
          ad.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoWaitingEnd: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          if (localc.vtL > 0)
          {
            paramAnonymousString1 = localc;
            paramAnonymousString1.tFh = ((int)(paramAnonymousString1.tFh + (SystemClock.elapsedRealtime() / 1000L - localc.vtL)));
            localc.vtL = 0;
          }
          if (localc.vtU != null) {
            localc.vtU.setVisibility(8);
          }
          AppMethodBeat.o(182465);
        }
        
        public final void eT(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(199010);
          ad.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoFirstFrameDraw: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(199010);
        }
      });
      localc.lru.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(174356);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          ad.i("MicroMsg.EnvelopeStoryVideoManager", "click play btn");
          if ((localc.vtR != null) && (localc.vtR.isPlaying()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(174356);
            return;
          }
          localc.lru.setVisibility(4);
          EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this, localc);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(174356);
        }
      });
      localc.vtR.setMute(this.fMP);
      a(localc);
      localc.vtS.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(182466);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          boolean bool1;
          if ((EnvelopeStoryVideoManager.b(EnvelopeStoryVideoManager.this) != -1) && (localc.vtR != null))
          {
            boolean bool2 = localc.vtR.vtV;
            paramAnonymousView = EnvelopeStoryVideoManager.this;
            if (bool2) {
              break label146;
            }
            bool1 = true;
            EnvelopeStoryVideoManager.a(paramAnonymousView, bool1);
            if (!bool2) {
              break label151;
            }
            EnvelopeStoryVideoManager.c(EnvelopeStoryVideoManager.this).requestFocus();
            EnvelopeStoryVideoManager.b(EnvelopeStoryVideoManager.this, true);
            localc.vtR.setMute(false);
          }
          for (;;)
          {
            EnvelopeStoryVideoManager.e(localc);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(182466);
            return;
            label146:
            bool1 = false;
            break;
            label151:
            if (EnvelopeStoryVideoManager.d(EnvelopeStoryVideoManager.this))
            {
              EnvelopeStoryVideoManager.c(EnvelopeStoryVideoManager.this).abe();
              EnvelopeStoryVideoManager.b(EnvelopeStoryVideoManager.this, false);
            }
            localc.vtR.setMute(true);
          }
        }
      });
      paramContext = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      paramContext.gravity = 17;
      paramFrameLayout.addView(localc.vtR, 0, paramContext);
      localc.vtS.setLayoutParams(paramContext);
      this.vtz.put(Integer.valueOf(paramInt3), localc);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174345);
          EnvelopeStoryVideoManager.d(localc);
          AppMethodBeat.o(174345);
        }
      });
      localc.vtR.setSessionId(localc.sessionId);
      localc.vtR.setIOnlineVideoProxy(new b(localc));
      localc.vtR.c(false, localc.url, 0);
      localc.irM = localc.vtR.getMediaId();
      b(localc);
      AppMethodBeat.o(174360);
      return;
    }
    localc.vtR.setMute(this.fMP);
    a(localc);
    aq.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174346);
        if ((localc.bfZ) && (localc.vtR.OI()))
        {
          localc.vtR.onUIResume();
          localc.vtN = localc.vtR.getCurrPosSec();
          localc.vtO = 0L;
        }
        for (;;)
        {
          localc.vtQ.set(1);
          AppMethodBeat.o(174346);
          return;
          if (localc.vtR.isPlaying())
          {
            ad.w("MicroMsg.EnvelopeStoryVideoManager", "resume fail, restart play");
            localc.vtR.stop();
            localc.vtR.start();
            localc.vtN = 0L;
            localc.vtO = 0L;
          }
        }
      }
    }, 200L);
    AppMethodBeat.o(174360);
  }
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(174361);
    if (paramc.vtR.vtV)
    {
      paramc.lrL.setImageResource(2131690762);
      AppMethodBeat.o(174361);
      return;
    }
    paramc.lrL.setImageResource(2131690768);
    AppMethodBeat.o(174361);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, g.a parama, h.a parama1)
  {
    int i = 2;
    AppMethodBeat.i(174367);
    ad.i("MicroMsg.EnvelopeStoryVideoManager", "trigger download video: %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    final long l = SystemClock.elapsedRealtime();
    h localh = new h();
    localh.fJi = "task_EnvelopeStoryVideoManager";
    localh.field_mediaId = paramString1;
    localh.field_fileId = paramString1;
    localh.url = paramString3;
    if (paramBoolean)
    {
      localh.fJF = i;
      localh.field_preloadRatio = 20;
      localh.fJB = new g.b()
      {
        public final void b(String paramAnonymousString, d paramAnonymousd)
        {
          AppMethodBeat.i(182468);
          ad.i("MicroMsg.EnvelopeStoryVideoManager", "preload complete: %s %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode) });
          EnvelopeStoryVideoManager.diY().remove(paramAnonymousString);
          g.yhR.f(19228, new Object[] { this.val$url, Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf((SystemClock.elapsedRealtime() - l) / 1000L), Integer.valueOf(0) });
          AppMethodBeat.o(182468);
        }
      };
      if (parama == null) {
        break label220;
      }
    }
    label220:
    for (localh.fJj = parama;; localh.fJj = new EnvelopeStoryVideoManager.2(paramString2))
    {
      localh.fJA = 3;
      localh.field_fullpath = paramString2;
      localh.field_filemd5 = paramString4;
      localh.allow_mobile_net_download = true;
      localh.fJN = parama1;
      localh.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
      localh.field_requestVideoFormat = 1;
      localh.fJz = localh.fJF;
      if (!paramBoolean) {
        break label263;
      }
      if (!vtA.contains(paramString1)) {
        break label236;
      }
      ad.w("MicroMsg.EnvelopeStoryVideoManager", "contains preload task: %s", new Object[] { paramString1 });
      AppMethodBeat.o(174367);
      return;
      i = 1;
      break;
    }
    label236:
    vtA.add(paramString1);
    f.aGI().b(localh, -1);
    AppMethodBeat.o(174367);
    return;
    label263:
    if (vtA.contains(paramString1))
    {
      ad.i("MicroMsg.EnvelopeStoryVideoManager", "need cancel preload task");
      f.aGI().EQ(paramString1);
    }
    o.aMK().a(localh);
    AppMethodBeat.o(174367);
  }
  
  public static String aoY(String paramString)
  {
    AppMethodBeat.i(163663);
    paramString = "MMVideo_" + paramString.hashCode();
    AppMethodBeat.o(163663);
    return paramString;
  }
  
  public static String aoZ(String paramString)
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
      paramc.vtR.setLocal(true);
    }
    paramc.qll.bringToFront();
    if (paramc.vtK > 0)
    {
      ad.d("MicroMsg.EnvelopeStoryVideoManager", "start play: %s", new Object[] { Integer.valueOf(paramc.vtK) });
      paramc.vtR.c(paramc.vtK, true);
      paramc.vtN = paramc.vtK;
    }
    for (paramc.vtO = 0L;; paramc.vtO = 0L)
    {
      paramc.vtQ.set(1);
      if (!this.dbJ)
      {
        this.ixy.requestFocus();
        this.dbJ = true;
      }
      paramc.bfZ = true;
      b.vuc += 1;
      b.vub.add(paramc.url);
      AppMethodBeat.o(174362);
      return;
      paramc.vtR.start();
      paramc.vtN = 0L;
    }
  }
  
  private static boolean c(c paramc)
  {
    AppMethodBeat.i(174363);
    boolean bool2 = i.fv(aoZ(paramc.url));
    if (ax.aQz(diX()).getInt(paramc.irM, 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.i("MicroMsg.EnvelopeStoryVideoManager", "can play local: %s, %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((!bool2) || (!bool1)) {
        break;
      }
      paramc.vtM = 1;
      AppMethodBeat.o(174363);
      return true;
    }
    if (bool2) {}
    for (paramc.vtM = 3;; paramc.vtM = 2)
    {
      ax.aQz(diX()).putInt(paramc.irM, 0);
      AppMethodBeat.o(174363);
      return false;
    }
  }
  
  private c diW()
  {
    AppMethodBeat.i(174366);
    c localc = (c)this.vtz.get(Integer.valueOf(this.vty));
    AppMethodBeat.o(174366);
    return localc;
  }
  
  private static String diX()
  {
    AppMethodBeat.i(163666);
    String str = aj.getPackageName() + "_luckymoney_story_video";
    AppMethodBeat.o(163666);
    return str;
  }
  
  public final void a(Context paramContext, FrameLayout paramFrameLayout, ImageView paramImageView, ProgressBar paramProgressBar, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(174364);
    ad.i("MicroMsg.EnvelopeStoryVideoManager", "update position: %s, %s, %s", new Object[] { Integer.valueOf(this.vty), Integer.valueOf(paramInt3), paramString });
    if (paramInt3 != this.vty)
    {
      c localc = (c)this.vtz.get(Integer.valueOf(this.vty));
      if (localc != null)
      {
        ad.i("MicroMsg.EnvelopeStoryVideoManager", "pause previous video");
        if (localc.bfZ)
        {
          localc.vtO = localc.vtR.getCurrPosSec();
          localc.vtR.onUIPause();
        }
      }
      this.vty = paramInt3;
      if (paramBoolean) {
        a(paramContext, paramFrameLayout, paramImageView, paramProgressBar, paramString, paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(174364);
      return;
    }
    ad.w("MicroMsg.EnvelopeStoryVideoManager", "skip same position");
    AppMethodBeat.o(174364);
  }
  
  public final void diV()
  {
    AppMethodBeat.i(174365);
    ad.i("MicroMsg.EnvelopeStoryVideoManager", "release video view: %s", new Object[] { Integer.valueOf(this.vtz.size()) });
    if (this.dbJ)
    {
      this.ixy.abe();
      this.dbJ = false;
    }
    Iterator localIterator = this.vtz.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ad.d("MicroMsg.EnvelopeStoryVideoManager", "do stop");
      c localc = (c)localEntry.getValue();
      if (localc.vtL > 0) {
        localc.tFh = ((int)(localc.tFh + (SystemClock.elapsedRealtime() / 1000L - localc.vtL)));
      }
      g.yhR.f(19228, new Object[] { localc.url, Integer.valueOf(localc.vtR.getVideoDurationSec()), Integer.valueOf(1), Integer.valueOf(localc.vtM), Integer.valueOf(localc.vtR.getRealPlayDurationSec()), Integer.valueOf(localc.tFh), Integer.valueOf(0), Integer.valueOf(0) });
      if (((c)localEntry.getValue()).vtR.getParent() != null)
      {
        ((ViewGroup)((c)localEntry.getValue()).vtR.getParent()).removeView(((c)localEntry.getValue()).vtR);
        localc.vtR.stop();
      }
    }
    this.vtz.clear();
    this.vty = -1;
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
    if (this.dbJ)
    {
      this.ixy.abe();
      this.dbJ = false;
    }
    c localc = diW();
    if (localc != null) {
      localc.vtR.onUIPause();
    }
    AppMethodBeat.o(163660);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public void onUIResume()
  {
    AppMethodBeat.i(163659);
    c localc = diW();
    if (localc != null)
    {
      localc.vtR.onUIResume();
      if (localc.vtR.isPlaying())
      {
        this.ixy.requestFocus();
        this.dbJ = true;
      }
    }
    AppMethodBeat.o(163659);
  }
  
  public final class a
    implements h.a
  {
    EnvelopeStoryVideoManager.c vtG;
    
    public a(EnvelopeStoryVideoManager.c paramc)
    {
      this.vtG = paramc;
    }
    
    public final void a(String paramString, int paramInt, d paramd)
    {
      AppMethodBeat.i(163648);
      if ((paramd != null) && (paramd.field_retCode == 0))
      {
        ad.i("MicroMsg.EnvelopeStoryVideoManager", "download finish: %s", new Object[] { paramString });
        EnvelopeStoryVideoManager.Lv().putInt(paramString, 1).commit();
      }
      this.vtG.vtR.as(paramString, paramInt);
      AppMethodBeat.o(163648);
    }
    
    public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
    {
      AppMethodBeat.i(199011);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(163644);
          EnvelopeStoryVideoManager.a.this.vtG.vtR.sp(paramLong1);
          AppMethodBeat.o(163644);
        }
      });
      AppMethodBeat.o(199011);
    }
    
    public final void i(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(163647);
      this.vtG.vtR.i(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(163647);
    }
    
    public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(163646);
      this.vtG.vtR.onDataAvailable(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(163646);
    }
  }
  
  final class b
    implements com.tencent.mm.modelvideo.b
  {
    EnvelopeStoryVideoManager.c vtG;
    
    public b(EnvelopeStoryVideoManager.c paramc)
    {
      this.vtG = paramc;
    }
    
    public final void a(b.a parama) {}
    
    public final void gj(String paramString)
    {
      AppMethodBeat.i(163652);
      o.aMK().l(paramString, null);
      AppMethodBeat.o(163652);
    }
    
    public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(163654);
      boolean bool = o.aMK().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(163654);
      return bool;
    }
    
    public final void p(String paramString1, final String paramString2, final String paramString3)
    {
      AppMethodBeat.i(163651);
      EnvelopeStoryVideoManager.a locala = new EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this, this.vtG);
      EnvelopeStoryVideoManager.a(paramString1, paramString2, paramString3, this.vtG.md5, false, new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(163650);
          ad.i("MicroMsg.EnvelopeStoryVideoManager", "cdn callback: %s, %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt != 0)
          {
            i.deleteFile(paramString2);
            if (EnvelopeStoryVideoManager.b.this.vtG.irM.equals(paramAnonymousString))
            {
              ad.w("MicroMsg.EnvelopeStoryVideoManager", "download video fail: %s", new Object[] { paramString3 });
              EnvelopeStoryVideoManager.b.this.vtG.vtT.setVisibility(0);
              EnvelopeStoryVideoManager.b.this.vtG.vtT.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(163649);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$EnvelopeStoryVideoProxy$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                  ad.i("MicroMsg.EnvelopeStoryVideoManager", "click retry btn");
                  EnvelopeStoryVideoManager.b.this.vtG.sessionId = UUID.randomUUID().toString();
                  EnvelopeStoryVideoManager.b.this.vtG.vtR.setSessionId(EnvelopeStoryVideoManager.b.this.vtG.sessionId);
                  EnvelopeStoryVideoManager.b.this.vtG.vtR.setLocal(false);
                  EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this, EnvelopeStoryVideoManager.b.this.vtG);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$EnvelopeStoryVideoProxy$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(163649);
                }
              });
              g.yhR.f(19228, new Object[] { EnvelopeStoryVideoManager.b.this.vtG.url, Integer.valueOf(EnvelopeStoryVideoManager.b.this.vtG.vtR.getVideoDurationSec()), Integer.valueOf(2), Integer.valueOf(EnvelopeStoryVideoManager.b.this.vtG.vtM), Integer.valueOf(EnvelopeStoryVideoManager.b.this.vtG.vtR.getRealPlayDurationSec()), Integer.valueOf(EnvelopeStoryVideoManager.b.this.vtG.tFh), Integer.valueOf(0), Integer.valueOf(-9999) });
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
      ad.d("MicroMsg.EnvelopeStoryVideoManager", "request video data: %s", new Object[] { paramString });
      o.aMK();
      e.r(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(163653);
    }
  }
  
  public static final class c
  {
    boolean bfZ;
    boolean fMP;
    String irM;
    ImageView lrL;
    ImageView lru;
    String md5;
    ImageView qll;
    String sessionId;
    int tFh;
    String url;
    int vtK;
    int vtL;
    int vtM;
    long vtN;
    long vtO;
    long vtP;
    AtomicInteger vtQ;
    EnvelopeStoryVideoView vtR;
    ViewGroup vtS;
    ViewGroup vtT;
    ProgressBar vtU;
    
    public c()
    {
      AppMethodBeat.i(182469);
      this.fMP = true;
      this.bfZ = false;
      this.vtL = 0;
      this.tFh = 0;
      this.vtQ = new AtomicInteger(1);
      AppMethodBeat.o(182469);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager
 * JD-Core Version:    0.7.0.1
 */