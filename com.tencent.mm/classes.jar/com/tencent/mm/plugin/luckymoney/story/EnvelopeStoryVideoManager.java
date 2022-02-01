package com.tencent.mm.plugin.luckymoney.story;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.s;
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
  private static Set<String> zaF;
  private boolean dtC;
  private boolean guh;
  private com.tencent.mm.compatible.util.b jvG;
  MMActivity pRg;
  private int zaD;
  Map<Integer, c> zaE;
  
  static
  {
    AppMethodBeat.i(163670);
    zaF = new HashSet();
    AppMethodBeat.o(163670);
  }
  
  public EnvelopeStoryVideoManager()
  {
    AppMethodBeat.i(163655);
    this.zaD = -1;
    this.guh = true;
    this.jvG = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    this.dtC = false;
    this.zaE = new HashMap();
    AppMethodBeat.o(163655);
  }
  
  public static MultiProcessMMKV VQ()
  {
    AppMethodBeat.i(258345);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(efR());
    AppMethodBeat.o(258345);
    return localMultiProcessMMKV;
  }
  
  private void a(Context paramContext, FrameLayout paramFrameLayout, ImageView paramImageView, ProgressBar paramProgressBar, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(174360);
    Log.i("MicroMsg.EnvelopeStoryVideoManager", "preapre video view");
    final c localc = (c)this.zaE.get(Integer.valueOf(paramInt3));
    if ((localc == null) || (localc.zaV == null))
    {
      localc = new c();
      localc.zaV = new EnvelopeStoryVideoView(paramContext);
      localc.url = paramString;
      localc.sessionId = UUID.randomUUID().toString();
      localc.rIY = paramImageView;
      localc.zaY = paramProgressBar;
      localc.zaW = ((ViewGroup)paramFrameLayout.findViewById(2131304292));
      localc.mCP = ((ImageView)paramFrameLayout.findViewById(2131304293));
      localc.mDh = ((ImageView)paramFrameLayout.findViewById(2131304089));
      localc.zaX = ((ViewGroup)paramFrameLayout.findViewById(2131304087));
      localc.zaV.setIsShowBasicControls(false);
      localc.zaV.zbb = new EnvelopeStoryVideoView.a()
      {
        public final void a(EnvelopeStoryVideoView paramAnonymousEnvelopeStoryVideoView)
        {
          AppMethodBeat.i(182457);
          int i = localc.zaU.addAndGet(1);
          localc.pLQ = paramAnonymousEnvelopeStoryVideoView.getVideoDurationSec();
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "sessionId: %s, current loop count: %s", new Object[] { localc.sessionId, Integer.valueOf(i) });
          AppMethodBeat.o(182457);
        }
      };
      localc.zaV.setIMMVideoViewCallback(new i.b()
      {
        public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(182459);
          Log.e("MicroMsg.EnvelopeStoryVideoManager", "onError: %s, %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2, paramAnonymousString3 });
          com.tencent.mm.plugin.report.service.h.CyF.a(19228, new Object[] { localc.url, Integer.valueOf(localc.zaV.getVideoDurationSec()), Integer.valueOf(2), Integer.valueOf(localc.zaR), Integer.valueOf(localc.zaV.getRealPlayDurationSec()), Integer.valueOf(localc.xhl), Integer.valueOf(0), Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(182459);
        }
        
        public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final void dH(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182460);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "on prepared: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          localc.pLQ = localc.zaV.getVideoDurationSec();
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(182458);
              if (EnvelopeStoryVideoManager.6.this.zaH.zaY != null) {
                EnvelopeStoryVideoManager.6.this.zaH.zaY.setVisibility(8);
              }
              if (EnvelopeStoryVideoManager.6.this.zaH.zaV.getParent() != null) {
                ((ViewGroup)EnvelopeStoryVideoManager.6.this.zaH.zaV.getParent()).bringToFront();
              }
              EnvelopeStoryVideoManager.6.this.zaH.mDh.setVisibility(0);
              AppMethodBeat.o(182458);
            }
          }, 10L);
          AppMethodBeat.o(182460);
        }
        
        public final void dI(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182461);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "on video end: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(182461);
        }
        
        public final void dJ(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182462);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoPause: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(182462);
        }
        
        public final void dK(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182463);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoPlay: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(182463);
        }
        
        public final void dL(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182464);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoWaiting: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          localc.zaQ = ((int)SystemClock.elapsedRealtime() / 1000);
          if (localc.zaY != null)
          {
            localc.zaY.bringToFront();
            localc.zaY.setVisibility(0);
          }
          AppMethodBeat.o(182464);
        }
        
        public final void dM(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182465);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoWaitingEnd: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          if (localc.zaQ > 0)
          {
            paramAnonymousString1 = localc;
            paramAnonymousString1.xhl = ((int)(paramAnonymousString1.xhl + (SystemClock.elapsedRealtime() / 1000L - localc.zaQ)));
            localc.zaQ = 0;
          }
          if (localc.zaY != null) {
            localc.zaY.setVisibility(8);
          }
          AppMethodBeat.o(182465);
        }
        
        public final void fo(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(213347);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoFirstFrameDraw: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(213347);
        }
      });
      localc.mCP.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(174356);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "click play btn");
          if ((localc.zaV != null) && (localc.zaV.isPlaying()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(174356);
            return;
          }
          localc.mCP.setVisibility(4);
          EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this, localc);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(174356);
        }
      });
      localc.zaV.setMute(this.guh);
      a(localc);
      localc.zaW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(182466);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          boolean bool1;
          if ((EnvelopeStoryVideoManager.b(EnvelopeStoryVideoManager.this) != -1) && (localc.zaV != null))
          {
            boolean bool2 = localc.zaV.zaZ;
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
            localc.zaV.setMute(false);
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
              EnvelopeStoryVideoManager.c(EnvelopeStoryVideoManager.this).apm();
              EnvelopeStoryVideoManager.b(EnvelopeStoryVideoManager.this, false);
            }
            localc.zaV.setMute(true);
          }
        }
      });
      paramContext = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      paramContext.gravity = 17;
      paramFrameLayout.addView(localc.zaV, 0, paramContext);
      localc.zaW.setLayoutParams(paramContext);
      this.zaE.put(Integer.valueOf(paramInt3), localc);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174345);
          EnvelopeStoryVideoManager.d(localc);
          AppMethodBeat.o(174345);
        }
      });
      localc.zaV.setSessionId(localc.sessionId);
      localc.zaV.setIOnlineVideoProxy(new b(localc));
      localc.zaV.c(false, localc.url, 0);
      localc.jpT = localc.zaV.getMediaId();
      b(localc);
      AppMethodBeat.o(174360);
      return;
    }
    localc.zaV.setMute(this.guh);
    a(localc);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174346);
        if ((localc.bfW) && (localc.zaV.YY()))
        {
          localc.zaV.onUIResume();
          localc.zaS = localc.zaV.getCurrPosSec();
          localc.zaT = 0L;
        }
        for (;;)
        {
          localc.zaU.set(1);
          AppMethodBeat.o(174346);
          return;
          if (localc.zaV.isPlaying())
          {
            Log.w("MicroMsg.EnvelopeStoryVideoManager", "resume fail, restart play");
            localc.zaV.stop();
            localc.zaV.start();
            localc.zaS = 0L;
            localc.zaT = 0L;
          }
        }
      }
    }, 200L);
    AppMethodBeat.o(174360);
  }
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(174361);
    if (paramc.zaV.zaZ)
    {
      paramc.mDh.setImageResource(2131691046);
      AppMethodBeat.o(174361);
      return;
    }
    paramc.mDh.setImageResource(2131691052);
    AppMethodBeat.o(174361);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, g.a parama, h.a parama1)
  {
    int i = 2;
    AppMethodBeat.i(174367);
    Log.i("MicroMsg.EnvelopeStoryVideoManager", "trigger download video: %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    long l = SystemClock.elapsedRealtime();
    com.tencent.mm.i.h localh = new com.tencent.mm.i.h();
    localh.taskName = "task_EnvelopeStoryVideoManager";
    localh.field_mediaId = paramString1;
    localh.field_fileId = paramString1;
    localh.url = paramString3;
    if (paramBoolean)
    {
      localh.gqU = i;
      localh.field_preloadRatio = 20;
      localh.gqQ = new EnvelopeStoryVideoManager.10(paramString3, l);
      if (parama == null) {
        break label220;
      }
    }
    label220:
    for (localh.gqy = parama;; localh.gqy = new EnvelopeStoryVideoManager.2(paramString2))
    {
      localh.gqP = 3;
      localh.field_fullpath = paramString2;
      localh.field_filemd5 = paramString4;
      localh.allow_mobile_net_download = true;
      localh.gre = parama1;
      localh.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
      localh.field_requestVideoFormat = 1;
      localh.gqO = localh.gqU;
      if (!paramBoolean) {
        break label263;
      }
      if (!zaF.contains(paramString1)) {
        break label236;
      }
      Log.w("MicroMsg.EnvelopeStoryVideoManager", "contains preload task: %s", new Object[] { paramString1 });
      AppMethodBeat.o(174367);
      return;
      i = 1;
      break;
    }
    label236:
    zaF.add(paramString1);
    f.baQ().b(localh, -1);
    AppMethodBeat.o(174367);
    return;
    label263:
    if (zaF.contains(paramString1))
    {
      Log.i("MicroMsg.EnvelopeStoryVideoManager", "need cancel preload task");
      f.baQ().Oc(paramString1);
    }
    o.bhk().e(localh);
    AppMethodBeat.o(174367);
  }
  
  public static String aDA(String paramString)
  {
    AppMethodBeat.i(163664);
    paramString = EnvelopeStoryVideoView.ROOT_PATH + "MMVideo_" + paramString.hashCode() + ".mp4";
    AppMethodBeat.o(163664);
    return paramString;
  }
  
  public static String aDz(String paramString)
  {
    AppMethodBeat.i(163663);
    paramString = "MMVideo_" + paramString.hashCode();
    AppMethodBeat.o(163663);
    return paramString;
  }
  
  private void b(c paramc)
  {
    AppMethodBeat.i(174362);
    if (c(paramc)) {
      paramc.zaV.setLocal(true);
    }
    paramc.rIY.bringToFront();
    if (paramc.zaP > 0)
    {
      Log.d("MicroMsg.EnvelopeStoryVideoManager", "start play: %s", new Object[] { Integer.valueOf(paramc.zaP) });
      paramc.zaV.c(paramc.zaP, true);
      paramc.zaS = paramc.zaP;
    }
    for (paramc.zaT = 0L;; paramc.zaT = 0L)
    {
      paramc.zaU.set(1);
      if (!this.dtC)
      {
        this.jvG.requestFocus();
        this.dtC = true;
      }
      paramc.bfW = true;
      b.zbg += 1;
      b.zbf.add(paramc.url);
      AppMethodBeat.o(174362);
      return;
      paramc.zaV.start();
      paramc.zaS = 0L;
    }
  }
  
  private static boolean c(c paramc)
  {
    AppMethodBeat.i(174363);
    boolean bool2 = s.YS(aDA(paramc.url));
    if (MultiProcessMMKV.getMMKV(efR()).getInt(paramc.jpT, 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.EnvelopeStoryVideoManager", "can play local: %s, %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((!bool2) || (!bool1)) {
        break;
      }
      paramc.zaR = 1;
      AppMethodBeat.o(174363);
      return true;
    }
    if (bool2) {}
    for (paramc.zaR = 3;; paramc.zaR = 2)
    {
      MultiProcessMMKV.getMMKV(efR()).putInt(paramc.jpT, 0);
      AppMethodBeat.o(174363);
      return false;
    }
  }
  
  private c efQ()
  {
    AppMethodBeat.i(174366);
    c localc = (c)this.zaE.get(Integer.valueOf(this.zaD));
    AppMethodBeat.o(174366);
    return localc;
  }
  
  private static String efR()
  {
    AppMethodBeat.i(163666);
    String str = MMApplicationContext.getPackageName() + "_luckymoney_story_video";
    AppMethodBeat.o(163666);
    return str;
  }
  
  public final void a(Context paramContext, FrameLayout paramFrameLayout, ImageView paramImageView, ProgressBar paramProgressBar, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(174364);
    Log.i("MicroMsg.EnvelopeStoryVideoManager", "update position: %s, %s, %s", new Object[] { Integer.valueOf(this.zaD), Integer.valueOf(paramInt3), paramString });
    if (paramInt3 != this.zaD)
    {
      c localc = (c)this.zaE.get(Integer.valueOf(this.zaD));
      if (localc != null)
      {
        Log.i("MicroMsg.EnvelopeStoryVideoManager", "pause previous video");
        if (localc.bfW)
        {
          localc.zaT = localc.zaV.getCurrPosSec();
          localc.zaV.onUIPause();
        }
      }
      this.zaD = paramInt3;
      if (paramBoolean) {
        a(paramContext, paramFrameLayout, paramImageView, paramProgressBar, paramString, paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(174364);
      return;
    }
    Log.w("MicroMsg.EnvelopeStoryVideoManager", "skip same position");
    AppMethodBeat.o(174364);
  }
  
  public final void efP()
  {
    AppMethodBeat.i(174365);
    Log.i("MicroMsg.EnvelopeStoryVideoManager", "release video view: %s", new Object[] { Integer.valueOf(this.zaE.size()) });
    if (this.dtC)
    {
      this.jvG.apm();
      this.dtC = false;
    }
    Iterator localIterator = this.zaE.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Log.d("MicroMsg.EnvelopeStoryVideoManager", "do stop");
      c localc = (c)localEntry.getValue();
      if (localc.zaQ > 0) {
        localc.xhl = ((int)(localc.xhl + (SystemClock.elapsedRealtime() / 1000L - localc.zaQ)));
      }
      com.tencent.mm.plugin.report.service.h.CyF.a(19228, new Object[] { localc.url, Integer.valueOf(localc.zaV.getVideoDurationSec()), Integer.valueOf(1), Integer.valueOf(localc.zaR), Integer.valueOf(localc.zaV.getRealPlayDurationSec()), Integer.valueOf(localc.xhl), Integer.valueOf(0), Integer.valueOf(0) });
      if (((c)localEntry.getValue()).zaV.getParent() != null)
      {
        ((ViewGroup)((c)localEntry.getValue()).zaV.getParent()).removeView(((c)localEntry.getValue()).zaV);
        localc.zaV.stop();
      }
    }
    this.zaE.clear();
    this.zaD = -1;
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
    if (this.dtC)
    {
      this.jvG.apm();
      this.dtC = false;
    }
    c localc = efQ();
    if (localc != null) {
      localc.zaV.onUIPause();
    }
    AppMethodBeat.o(163660);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public void onUIResume()
  {
    AppMethodBeat.i(163659);
    c localc = efQ();
    if (localc != null)
    {
      localc.zaV.onUIResume();
      if (localc.zaV.isPlaying())
      {
        this.jvG.requestFocus();
        this.dtC = true;
      }
    }
    AppMethodBeat.o(163659);
  }
  
  final class b
    implements com.tencent.mm.modelvideo.b
  {
    EnvelopeStoryVideoManager.c zaL;
    
    public b(EnvelopeStoryVideoManager.c paramc)
    {
      this.zaL = paramc;
    }
    
    public final void a(b.a parama) {}
    
    public final void he(String paramString)
    {
      AppMethodBeat.i(163652);
      o.bhk().l(paramString, null);
      AppMethodBeat.o(163652);
    }
    
    public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(163654);
      boolean bool = o.bhk().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(163654);
      return bool;
    }
    
    public final void p(String paramString1, final String paramString2, final String paramString3)
    {
      AppMethodBeat.i(163651);
      EnvelopeStoryVideoManager.a locala = new EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this, this.zaL);
      EnvelopeStoryVideoManager.a(paramString1, paramString2, paramString3, this.zaL.md5, false, new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(163650);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "cdn callback: %s, %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt != 0)
          {
            s.deleteFile(paramString2);
            if (EnvelopeStoryVideoManager.b.this.zaL.jpT.equals(paramAnonymousString))
            {
              Log.w("MicroMsg.EnvelopeStoryVideoManager", "download video fail: %s", new Object[] { paramString3 });
              EnvelopeStoryVideoManager.b.this.zaL.zaX.setVisibility(0);
              EnvelopeStoryVideoManager.b.this.zaL.zaX.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(163649);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bm(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$EnvelopeStoryVideoProxy$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                  Log.i("MicroMsg.EnvelopeStoryVideoManager", "click retry btn");
                  EnvelopeStoryVideoManager.b.this.zaL.sessionId = UUID.randomUUID().toString();
                  EnvelopeStoryVideoManager.b.this.zaL.zaV.setSessionId(EnvelopeStoryVideoManager.b.this.zaL.sessionId);
                  EnvelopeStoryVideoManager.b.this.zaL.zaV.setLocal(false);
                  EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this, EnvelopeStoryVideoManager.b.this.zaL);
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$EnvelopeStoryVideoProxy$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(163649);
                }
              });
              com.tencent.mm.plugin.report.service.h.CyF.a(19228, new Object[] { EnvelopeStoryVideoManager.b.this.zaL.url, Integer.valueOf(EnvelopeStoryVideoManager.b.this.zaL.zaV.getVideoDurationSec()), Integer.valueOf(2), Integer.valueOf(EnvelopeStoryVideoManager.b.this.zaL.zaR), Integer.valueOf(EnvelopeStoryVideoManager.b.this.zaL.zaV.getRealPlayDurationSec()), Integer.valueOf(EnvelopeStoryVideoManager.b.this.zaL.xhl), Integer.valueOf(0), Integer.valueOf(-9999) });
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
      Log.d("MicroMsg.EnvelopeStoryVideoManager", "request video data: %s", new Object[] { paramString });
      o.bhk();
      e.r(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(163653);
    }
  }
  
  public static final class c
  {
    boolean bfW;
    boolean guh;
    String jpT;
    ImageView mCP;
    ImageView mDh;
    String md5;
    long pLQ;
    ImageView rIY;
    String sessionId;
    String url;
    int xhl;
    int zaP;
    int zaQ;
    int zaR;
    long zaS;
    long zaT;
    AtomicInteger zaU;
    EnvelopeStoryVideoView zaV;
    ViewGroup zaW;
    ViewGroup zaX;
    ProgressBar zaY;
    
    public c()
    {
      AppMethodBeat.i(182469);
      this.guh = true;
      this.bfW = false;
      this.zaQ = 0;
      this.xhl = 0;
      this.zaU = new AtomicInteger(1);
      AppMethodBeat.o(182469);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager
 * JD-Core Version:    0.7.0.1
 */