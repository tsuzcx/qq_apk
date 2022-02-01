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
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.i.g.b;
import com.tencent.mm.i.h;
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.ui.MMActivity;
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
  private static Set<String> vFF;
  private boolean dcL;
  private boolean fOX;
  private com.tencent.mm.compatible.util.b iAr;
  MMActivity oDx;
  private int vFD;
  Map<Integer, c> vFE;
  
  static
  {
    AppMethodBeat.i(163670);
    vFF = new HashSet();
    AppMethodBeat.o(163670);
  }
  
  public EnvelopeStoryVideoManager()
  {
    AppMethodBeat.i(163655);
    this.vFD = -1;
    this.fOX = true;
    this.iAr = new com.tencent.mm.compatible.util.b(ak.getContext());
    this.dcL = false;
    this.vFE = new HashMap();
    AppMethodBeat.o(163655);
  }
  
  public static ay LD()
  {
    AppMethodBeat.i(224230);
    ay localay = ay.aRW(dlW());
    AppMethodBeat.o(224230);
    return localay;
  }
  
  private void a(Context paramContext, FrameLayout paramFrameLayout, ImageView paramImageView, ProgressBar paramProgressBar, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(174360);
    ae.i("MicroMsg.EnvelopeStoryVideoManager", "preapre video view");
    final c localc = (c)this.vFE.get(Integer.valueOf(paramInt3));
    if ((localc == null) || (localc.vFV == null))
    {
      localc = new c();
      localc.vFV = new EnvelopeStoryVideoView(paramContext);
      localc.url = paramString;
      localc.sessionId = UUID.randomUUID().toString();
      localc.qrQ = paramImageView;
      localc.vFY = paramProgressBar;
      localc.vFW = ((ViewGroup)paramFrameLayout.findViewById(2131301966));
      localc.lvU = ((ImageView)paramFrameLayout.findViewById(2131301967));
      localc.lwl = ((ImageView)paramFrameLayout.findViewById(2131301784));
      localc.vFX = ((ViewGroup)paramFrameLayout.findViewById(2131301782));
      localc.vFV.setIsShowBasicControls(false);
      localc.vFV.vGb = new EnvelopeStoryVideoView.a()
      {
        public final void a(EnvelopeStoryVideoView paramAnonymousEnvelopeStoryVideoView)
        {
          AppMethodBeat.i(182457);
          int i = localc.vFU.addAndGet(1);
          localc.oym = paramAnonymousEnvelopeStoryVideoView.getVideoDurationSec();
          ae.i("MicroMsg.EnvelopeStoryVideoManager", "sessionId: %s, current loop count: %s", new Object[] { localc.sessionId, Integer.valueOf(i) });
          AppMethodBeat.o(182457);
        }
      };
      localc.vFV.setIMMVideoViewCallback(new i.b()
      {
        public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(182459);
          ae.e("MicroMsg.EnvelopeStoryVideoManager", "onError: %s, %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2, paramAnonymousString3 });
          g.yxI.f(19228, new Object[] { localc.url, Integer.valueOf(localc.vFV.getVideoDurationSec()), Integer.valueOf(2), Integer.valueOf(localc.vFR), Integer.valueOf(localc.vFV.getRealPlayDurationSec()), Integer.valueOf(localc.tPY), Integer.valueOf(0), Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(182459);
        }
        
        public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final void ds(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182460);
          ae.i("MicroMsg.EnvelopeStoryVideoManager", "on prepared: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          localc.oym = localc.vFV.getVideoDurationSec();
          ar.o(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(182458);
              if (EnvelopeStoryVideoManager.6.this.vFH.vFY != null) {
                EnvelopeStoryVideoManager.6.this.vFH.vFY.setVisibility(8);
              }
              if (EnvelopeStoryVideoManager.6.this.vFH.vFV.getParent() != null) {
                ((ViewGroup)EnvelopeStoryVideoManager.6.this.vFH.vFV.getParent()).bringToFront();
              }
              EnvelopeStoryVideoManager.6.this.vFH.lwl.setVisibility(0);
              AppMethodBeat.o(182458);
            }
          }, 10L);
          AppMethodBeat.o(182460);
        }
        
        public final void dt(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182461);
          ae.i("MicroMsg.EnvelopeStoryVideoManager", "on video end: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(182461);
        }
        
        public final void du(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182462);
          ae.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoPause: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(182462);
        }
        
        public final void dv(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182463);
          ae.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoPlay: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(182463);
        }
        
        public final void dw(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182464);
          ae.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoWaiting: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          localc.vFQ = ((int)SystemClock.elapsedRealtime() / 1000);
          if (localc.vFY != null)
          {
            localc.vFY.bringToFront();
            localc.vFY.setVisibility(0);
          }
          AppMethodBeat.o(182464);
        }
        
        public final void dx(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182465);
          ae.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoWaitingEnd: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          if (localc.vFQ > 0)
          {
            paramAnonymousString1 = localc;
            paramAnonymousString1.tPY = ((int)(paramAnonymousString1.tPY + (SystemClock.elapsedRealtime() / 1000L - localc.vFQ)));
            localc.vFQ = 0;
          }
          if (localc.vFY != null) {
            localc.vFY.setVisibility(8);
          }
          AppMethodBeat.o(182465);
        }
        
        public final void eX(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(189845);
          ae.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoFirstFrameDraw: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(189845);
        }
      });
      localc.lvU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(174356);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.i("MicroMsg.EnvelopeStoryVideoManager", "click play btn");
          if ((localc.vFV != null) && (localc.vFV.isPlaying()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(174356);
            return;
          }
          localc.lvU.setVisibility(4);
          EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this, localc);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(174356);
        }
      });
      localc.vFV.setMute(this.fOX);
      a(localc);
      localc.vFW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(182466);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          boolean bool1;
          if ((EnvelopeStoryVideoManager.b(EnvelopeStoryVideoManager.this) != -1) && (localc.vFV != null))
          {
            boolean bool2 = localc.vFV.vFZ;
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
            localc.vFV.setMute(false);
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
              EnvelopeStoryVideoManager.c(EnvelopeStoryVideoManager.this).abn();
              EnvelopeStoryVideoManager.b(EnvelopeStoryVideoManager.this, false);
            }
            localc.vFV.setMute(true);
          }
        }
      });
      paramContext = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      paramContext.gravity = 17;
      paramFrameLayout.addView(localc.vFV, 0, paramContext);
      localc.vFW.setLayoutParams(paramContext);
      this.vFE.put(Integer.valueOf(paramInt3), localc);
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174345);
          EnvelopeStoryVideoManager.d(localc);
          AppMethodBeat.o(174345);
        }
      });
      localc.vFV.setSessionId(localc.sessionId);
      localc.vFV.setIOnlineVideoProxy(new b(localc));
      localc.vFV.c(false, localc.url, 0);
      localc.iuG = localc.vFV.getMediaId();
      b(localc);
      AppMethodBeat.o(174360);
      return;
    }
    localc.vFV.setMute(this.fOX);
    a(localc);
    ar.o(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174346);
        if ((localc.bfZ) && (localc.vFV.OG()))
        {
          localc.vFV.onUIResume();
          localc.vFS = localc.vFV.getCurrPosSec();
          localc.vFT = 0L;
        }
        for (;;)
        {
          localc.vFU.set(1);
          AppMethodBeat.o(174346);
          return;
          if (localc.vFV.isPlaying())
          {
            ae.w("MicroMsg.EnvelopeStoryVideoManager", "resume fail, restart play");
            localc.vFV.stop();
            localc.vFV.start();
            localc.vFS = 0L;
            localc.vFT = 0L;
          }
        }
      }
    }, 200L);
    AppMethodBeat.o(174360);
  }
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(174361);
    if (paramc.vFV.vFZ)
    {
      paramc.lwl.setImageResource(2131690762);
      AppMethodBeat.o(174361);
      return;
    }
    paramc.lwl.setImageResource(2131690768);
    AppMethodBeat.o(174361);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, g.a parama, h.a parama1)
  {
    int i = 2;
    AppMethodBeat.i(174367);
    ae.i("MicroMsg.EnvelopeStoryVideoManager", "trigger download video: %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    final long l = SystemClock.elapsedRealtime();
    h localh = new h();
    localh.fLl = "task_EnvelopeStoryVideoManager";
    localh.field_mediaId = paramString1;
    localh.field_fileId = paramString1;
    localh.url = paramString3;
    if (paramBoolean)
    {
      localh.fLI = i;
      localh.field_preloadRatio = 20;
      localh.fLE = new g.b()
      {
        public final void b(String paramAnonymousString, d paramAnonymousd)
        {
          AppMethodBeat.i(182468);
          ae.i("MicroMsg.EnvelopeStoryVideoManager", "preload complete: %s %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousd.field_retCode) });
          EnvelopeStoryVideoManager.dlX().remove(paramAnonymousString);
          g.yxI.f(19228, new Object[] { this.val$url, Integer.valueOf(0), Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf((SystemClock.elapsedRealtime() - l) / 1000L), Integer.valueOf(0) });
          AppMethodBeat.o(182468);
        }
      };
      if (parama == null) {
        break label220;
      }
    }
    label220:
    for (localh.fLm = parama;; localh.fLm = new EnvelopeStoryVideoManager.2(paramString2))
    {
      localh.fLD = 3;
      localh.field_fullpath = paramString2;
      localh.field_filemd5 = paramString4;
      localh.allow_mobile_net_download = true;
      localh.fLQ = parama1;
      localh.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
      localh.field_requestVideoFormat = 1;
      localh.fLC = localh.fLI;
      if (!paramBoolean) {
        break label263;
      }
      if (!vFF.contains(paramString1)) {
        break label236;
      }
      ae.w("MicroMsg.EnvelopeStoryVideoManager", "contains preload task: %s", new Object[] { paramString1 });
      AppMethodBeat.o(174367);
      return;
      i = 1;
      break;
    }
    label236:
    vFF.add(paramString1);
    f.aGZ().b(localh, -1);
    AppMethodBeat.o(174367);
    return;
    label263:
    if (vFF.contains(paramString1))
    {
      ae.i("MicroMsg.EnvelopeStoryVideoManager", "need cancel preload task");
      f.aGZ().Fs(paramString1);
    }
    com.tencent.mm.modelvideo.o.aNi().a(localh);
    AppMethodBeat.o(174367);
  }
  
  public static String aqd(String paramString)
  {
    AppMethodBeat.i(163663);
    paramString = "MMVideo_" + paramString.hashCode();
    AppMethodBeat.o(163663);
    return paramString;
  }
  
  public static String aqe(String paramString)
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
      paramc.vFV.setLocal(true);
    }
    paramc.qrQ.bringToFront();
    if (paramc.vFP > 0)
    {
      ae.d("MicroMsg.EnvelopeStoryVideoManager", "start play: %s", new Object[] { Integer.valueOf(paramc.vFP) });
      paramc.vFV.c(paramc.vFP, true);
      paramc.vFS = paramc.vFP;
    }
    for (paramc.vFT = 0L;; paramc.vFT = 0L)
    {
      paramc.vFU.set(1);
      if (!this.dcL)
      {
        this.iAr.requestFocus();
        this.dcL = true;
      }
      paramc.bfZ = true;
      b.vGg += 1;
      b.vGf.add(paramc.url);
      AppMethodBeat.o(174362);
      return;
      paramc.vFV.start();
      paramc.vFS = 0L;
    }
  }
  
  private static boolean c(c paramc)
  {
    AppMethodBeat.i(174363);
    boolean bool2 = com.tencent.mm.vfs.o.fB(aqe(paramc.url));
    if (ay.aRW(dlW()).getInt(paramc.iuG, 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ae.i("MicroMsg.EnvelopeStoryVideoManager", "can play local: %s, %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((!bool2) || (!bool1)) {
        break;
      }
      paramc.vFR = 1;
      AppMethodBeat.o(174363);
      return true;
    }
    if (bool2) {}
    for (paramc.vFR = 3;; paramc.vFR = 2)
    {
      ay.aRW(dlW()).putInt(paramc.iuG, 0);
      AppMethodBeat.o(174363);
      return false;
    }
  }
  
  private c dlV()
  {
    AppMethodBeat.i(174366);
    c localc = (c)this.vFE.get(Integer.valueOf(this.vFD));
    AppMethodBeat.o(174366);
    return localc;
  }
  
  private static String dlW()
  {
    AppMethodBeat.i(163666);
    String str = ak.getPackageName() + "_luckymoney_story_video";
    AppMethodBeat.o(163666);
    return str;
  }
  
  public final void a(Context paramContext, FrameLayout paramFrameLayout, ImageView paramImageView, ProgressBar paramProgressBar, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(174364);
    ae.i("MicroMsg.EnvelopeStoryVideoManager", "update position: %s, %s, %s", new Object[] { Integer.valueOf(this.vFD), Integer.valueOf(paramInt3), paramString });
    if (paramInt3 != this.vFD)
    {
      c localc = (c)this.vFE.get(Integer.valueOf(this.vFD));
      if (localc != null)
      {
        ae.i("MicroMsg.EnvelopeStoryVideoManager", "pause previous video");
        if (localc.bfZ)
        {
          localc.vFT = localc.vFV.getCurrPosSec();
          localc.vFV.onUIPause();
        }
      }
      this.vFD = paramInt3;
      if (paramBoolean) {
        a(paramContext, paramFrameLayout, paramImageView, paramProgressBar, paramString, paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(174364);
      return;
    }
    ae.w("MicroMsg.EnvelopeStoryVideoManager", "skip same position");
    AppMethodBeat.o(174364);
  }
  
  public final void dlU()
  {
    AppMethodBeat.i(174365);
    ae.i("MicroMsg.EnvelopeStoryVideoManager", "release video view: %s", new Object[] { Integer.valueOf(this.vFE.size()) });
    if (this.dcL)
    {
      this.iAr.abn();
      this.dcL = false;
    }
    Iterator localIterator = this.vFE.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ae.d("MicroMsg.EnvelopeStoryVideoManager", "do stop");
      c localc = (c)localEntry.getValue();
      if (localc.vFQ > 0) {
        localc.tPY = ((int)(localc.tPY + (SystemClock.elapsedRealtime() / 1000L - localc.vFQ)));
      }
      g.yxI.f(19228, new Object[] { localc.url, Integer.valueOf(localc.vFV.getVideoDurationSec()), Integer.valueOf(1), Integer.valueOf(localc.vFR), Integer.valueOf(localc.vFV.getRealPlayDurationSec()), Integer.valueOf(localc.tPY), Integer.valueOf(0), Integer.valueOf(0) });
      if (((c)localEntry.getValue()).vFV.getParent() != null)
      {
        ((ViewGroup)((c)localEntry.getValue()).vFV.getParent()).removeView(((c)localEntry.getValue()).vFV);
        localc.vFV.stop();
      }
    }
    this.vFE.clear();
    this.vFD = -1;
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
    if (this.dcL)
    {
      this.iAr.abn();
      this.dcL = false;
    }
    c localc = dlV();
    if (localc != null) {
      localc.vFV.onUIPause();
    }
    AppMethodBeat.o(163660);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public void onUIResume()
  {
    AppMethodBeat.i(163659);
    c localc = dlV();
    if (localc != null)
    {
      localc.vFV.onUIResume();
      if (localc.vFV.isPlaying())
      {
        this.iAr.requestFocus();
        this.dcL = true;
      }
    }
    AppMethodBeat.o(163659);
  }
  
  public final class a
    implements h.a
  {
    EnvelopeStoryVideoManager.c vFL;
    
    public a(EnvelopeStoryVideoManager.c paramc)
    {
      this.vFL = paramc;
    }
    
    public final void a(String paramString, int paramInt, d paramd)
    {
      AppMethodBeat.i(163648);
      if ((paramd != null) && (paramd.field_retCode == 0))
      {
        ae.i("MicroMsg.EnvelopeStoryVideoManager", "download finish: %s", new Object[] { paramString });
        EnvelopeStoryVideoManager.LD().putInt(paramString, 1).commit();
      }
      this.vFL.vFV.at(paramString, paramInt);
      AppMethodBeat.o(163648);
    }
    
    public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
    {
      AppMethodBeat.i(189846);
      ar.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(163644);
          EnvelopeStoryVideoManager.a.this.vFL.vFV.sC(paramLong1);
          AppMethodBeat.o(163644);
        }
      });
      AppMethodBeat.o(189846);
    }
    
    public final void i(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(163647);
      this.vFL.vFV.i(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(163647);
    }
    
    public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(163646);
      this.vFL.vFV.onDataAvailable(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(163646);
    }
  }
  
  final class b
    implements com.tencent.mm.modelvideo.b
  {
    EnvelopeStoryVideoManager.c vFL;
    
    public b(EnvelopeStoryVideoManager.c paramc)
    {
      this.vFL = paramc;
    }
    
    public final void a(b.a parama) {}
    
    public final void gp(String paramString)
    {
      AppMethodBeat.i(163652);
      com.tencent.mm.modelvideo.o.aNi().l(paramString, null);
      AppMethodBeat.o(163652);
    }
    
    public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(163654);
      boolean bool = com.tencent.mm.modelvideo.o.aNi().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(163654);
      return bool;
    }
    
    public final void p(String paramString1, final String paramString2, final String paramString3)
    {
      AppMethodBeat.i(163651);
      EnvelopeStoryVideoManager.a locala = new EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this, this.vFL);
      EnvelopeStoryVideoManager.a(paramString1, paramString2, paramString3, this.vFL.md5, false, new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(163650);
          ae.i("MicroMsg.EnvelopeStoryVideoManager", "cdn callback: %s, %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt != 0)
          {
            com.tencent.mm.vfs.o.deleteFile(paramString2);
            if (EnvelopeStoryVideoManager.b.this.vFL.iuG.equals(paramAnonymousString))
            {
              ae.w("MicroMsg.EnvelopeStoryVideoManager", "download video fail: %s", new Object[] { paramString3 });
              EnvelopeStoryVideoManager.b.this.vFL.vFX.setVisibility(0);
              EnvelopeStoryVideoManager.b.this.vFL.vFX.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(163649);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bd(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$EnvelopeStoryVideoProxy$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                  ae.i("MicroMsg.EnvelopeStoryVideoManager", "click retry btn");
                  EnvelopeStoryVideoManager.b.this.vFL.sessionId = UUID.randomUUID().toString();
                  EnvelopeStoryVideoManager.b.this.vFL.vFV.setSessionId(EnvelopeStoryVideoManager.b.this.vFL.sessionId);
                  EnvelopeStoryVideoManager.b.this.vFL.vFV.setLocal(false);
                  EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this, EnvelopeStoryVideoManager.b.this.vFL);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$EnvelopeStoryVideoProxy$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(163649);
                }
              });
              g.yxI.f(19228, new Object[] { EnvelopeStoryVideoManager.b.this.vFL.url, Integer.valueOf(EnvelopeStoryVideoManager.b.this.vFL.vFV.getVideoDurationSec()), Integer.valueOf(2), Integer.valueOf(EnvelopeStoryVideoManager.b.this.vFL.vFR), Integer.valueOf(EnvelopeStoryVideoManager.b.this.vFL.vFV.getRealPlayDurationSec()), Integer.valueOf(EnvelopeStoryVideoManager.b.this.vFL.tPY), Integer.valueOf(0), Integer.valueOf(-9999) });
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
      ae.d("MicroMsg.EnvelopeStoryVideoManager", "request video data: %s", new Object[] { paramString });
      com.tencent.mm.modelvideo.o.aNi();
      e.r(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(163653);
    }
  }
  
  public static final class c
  {
    boolean bfZ;
    boolean fOX;
    String iuG;
    ImageView lvU;
    ImageView lwl;
    String md5;
    long oym;
    ImageView qrQ;
    String sessionId;
    int tPY;
    String url;
    int vFP;
    int vFQ;
    int vFR;
    long vFS;
    long vFT;
    AtomicInteger vFU;
    EnvelopeStoryVideoView vFV;
    ViewGroup vFW;
    ViewGroup vFX;
    ProgressBar vFY;
    
    public c()
    {
      AppMethodBeat.i(182469);
      this.fOX = true;
      this.bfZ = false;
      this.vFQ = 0;
      this.tPY = 0;
      this.vFU = new AtomicInteger(1);
      AppMethodBeat.o(182469);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager
 * JD-Core Version:    0.7.0.1
 */