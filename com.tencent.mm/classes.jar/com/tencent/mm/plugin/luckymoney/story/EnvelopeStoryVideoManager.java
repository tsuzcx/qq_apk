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
import com.tencent.mm.i.h.a;
import com.tencent.mm.modelvideo.b.a;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.pluginsdk.ui.h.b;
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
  private static Set<String> tiG;
  private boolean cSW;
  private boolean fqj;
  private com.tencent.mm.compatible.util.b hDB;
  MMActivity nqA;
  private int tiE;
  Map<Integer, c> tiF;
  
  static
  {
    AppMethodBeat.i(163670);
    tiG = new HashSet();
    AppMethodBeat.o(163670);
  }
  
  public EnvelopeStoryVideoManager()
  {
    AppMethodBeat.i(163655);
    this.tiE = -1;
    this.fqj = true;
    this.hDB = new com.tencent.mm.compatible.util.b(aj.getContext());
    this.cSW = false;
    this.tiF = new HashMap();
    AppMethodBeat.o(163655);
  }
  
  public static ax Km()
  {
    AppMethodBeat.i(201265);
    ax localax = ax.aFC(cMf());
    AppMethodBeat.o(201265);
    return localax;
  }
  
  private void a(Context paramContext, FrameLayout paramFrameLayout, ImageView paramImageView, ProgressBar paramProgressBar, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(174360);
    ad.i("MicroMsg.EnvelopeStoryVideoManager", "preapre video view");
    final c localc = (c)this.tiF.get(Integer.valueOf(paramInt3));
    if ((localc == null) || (localc.tiX == null))
    {
      localc = new c();
      localc.tiX = new EnvelopeStoryVideoView(paramContext);
      localc.url = paramString;
      localc.sessionId = UUID.randomUUID().toString();
      localc.pev = paramImageView;
      localc.tja = paramProgressBar;
      localc.tiY = ((ViewGroup)paramFrameLayout.findViewById(2131301966));
      localc.kth = ((ImageView)paramFrameLayout.findViewById(2131301967));
      localc.kty = ((ImageView)paramFrameLayout.findViewById(2131301784));
      localc.tiZ = ((ViewGroup)paramFrameLayout.findViewById(2131301782));
      localc.tiX.setIsShowBasicControls(false);
      localc.tiX.tjd = new EnvelopeStoryVideoView.a()
      {
        public final void a(EnvelopeStoryVideoView paramAnonymousEnvelopeStoryVideoView)
        {
          AppMethodBeat.i(182457);
          int i = localc.tiW.addAndGet(1);
          localc.tiV = paramAnonymousEnvelopeStoryVideoView.getVideoDurationSec();
          ad.i("MicroMsg.EnvelopeStoryVideoManager", "sessionId: %s, current loop count: %s", new Object[] { localc.sessionId, Integer.valueOf(i) });
          AppMethodBeat.o(182457);
        }
      };
      localc.tiX.setIMMVideoViewCallback(new h.b()
      {
        public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(182459);
          ad.e("MicroMsg.EnvelopeStoryVideoManager", "onError: %s, %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2, paramAnonymousString3 });
          com.tencent.mm.plugin.report.service.h.vKh.f(19228, new Object[] { localc.url, Integer.valueOf(localc.tiX.getVideoDurationSec()), Integer.valueOf(2), Integer.valueOf(localc.tiS), Integer.valueOf(localc.tiX.getRealPlayDurationSec()), Integer.valueOf(localc.rzE), Integer.valueOf(0), Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(182459);
        }
        
        public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final void db(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182460);
          ad.i("MicroMsg.EnvelopeStoryVideoManager", "on prepared: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          localc.tiV = localc.tiX.getVideoDurationSec();
          aq.n(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(182458);
              if (EnvelopeStoryVideoManager.6.this.tiI.tja != null) {
                EnvelopeStoryVideoManager.6.this.tiI.tja.setVisibility(8);
              }
              if (EnvelopeStoryVideoManager.6.this.tiI.tiX.getParent() != null) {
                ((ViewGroup)EnvelopeStoryVideoManager.6.this.tiI.tiX.getParent()).bringToFront();
              }
              EnvelopeStoryVideoManager.6.this.tiI.kty.setVisibility(0);
              AppMethodBeat.o(182458);
            }
          }, 10L);
          AppMethodBeat.o(182460);
        }
        
        public final void dc(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182461);
          ad.i("MicroMsg.EnvelopeStoryVideoManager", "on video end: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(182461);
        }
        
        public final void dd(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182462);
          ad.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoPause: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(182462);
        }
        
        public final void de(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182463);
          ad.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoPlay: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(182463);
        }
        
        public final void dg(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182464);
          ad.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoWaiting: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          localc.tiR = ((int)SystemClock.elapsedRealtime() / 1000);
          if (localc.tja != null)
          {
            localc.tja.bringToFront();
            localc.tja.setVisibility(0);
          }
          AppMethodBeat.o(182464);
        }
        
        public final void dh(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182465);
          ad.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoWaitingEnd: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          if (localc.tiR > 0)
          {
            paramAnonymousString1 = localc;
            paramAnonymousString1.rzE = ((int)(paramAnonymousString1.rzE + (SystemClock.elapsedRealtime() / 1000L - localc.tiR)));
            localc.tiR = 0;
          }
          if (localc.tja != null) {
            localc.tja.setVisibility(8);
          }
          AppMethodBeat.o(182465);
        }
        
        public final void jw(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(201263);
          ad.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoFirstFrameDraw: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(201263);
        }
      });
      localc.kth.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(174356);
          ad.i("MicroMsg.EnvelopeStoryVideoManager", "click play btn");
          if ((localc.tiX != null) && (localc.tiX.isPlaying()))
          {
            AppMethodBeat.o(174356);
            return;
          }
          localc.kth.setVisibility(4);
          EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this, localc);
          AppMethodBeat.o(174356);
        }
      });
      localc.tiX.setMute(this.fqj);
      a(localc);
      localc.tiY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(182466);
          boolean bool1;
          if ((EnvelopeStoryVideoManager.b(EnvelopeStoryVideoManager.this) != -1) && (localc.tiX != null))
          {
            boolean bool2 = localc.tiX.tjb;
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
            localc.tiX.setMute(false);
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
              EnvelopeStoryVideoManager.c(EnvelopeStoryVideoManager.this).XF();
              EnvelopeStoryVideoManager.b(EnvelopeStoryVideoManager.this, false);
            }
            localc.tiX.setMute(true);
          }
        }
      });
      paramContext = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      paramContext.gravity = 17;
      paramFrameLayout.addView(localc.tiX, 0, paramContext);
      localc.tiY.setLayoutParams(paramContext);
      this.tiF.put(Integer.valueOf(paramInt3), localc);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174345);
          EnvelopeStoryVideoManager.d(localc);
          AppMethodBeat.o(174345);
        }
      });
      localc.tiX.setSessionId(localc.sessionId);
      localc.tiX.setIOnlineVideoProxy(new b(localc));
      localc.tiX.c(false, localc.url, 0);
      localc.hxP = localc.tiX.getMediaId();
      b(localc);
      AppMethodBeat.o(174360);
      return;
    }
    localc.tiX.setMute(this.fqj);
    a(localc);
    aq.n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174346);
        if ((localc.aUR) && (localc.tiX.Nb()))
        {
          localc.tiX.onUIResume();
          localc.tiT = localc.tiX.getCurrPosSec();
          localc.tiU = 0L;
        }
        for (;;)
        {
          localc.tiW.set(1);
          AppMethodBeat.o(174346);
          return;
          if (localc.tiX.isPlaying())
          {
            ad.w("MicroMsg.EnvelopeStoryVideoManager", "resume fail, restart play");
            localc.tiX.stop();
            localc.tiX.start();
            localc.tiT = 0L;
            localc.tiU = 0L;
          }
        }
      }
    }, 200L);
    AppMethodBeat.o(174360);
  }
  
  private static void a(c paramc)
  {
    AppMethodBeat.i(174361);
    if (paramc.tiX.tjb)
    {
      paramc.kty.setImageResource(2131690762);
      AppMethodBeat.o(174361);
      return;
    }
    paramc.kty.setImageResource(2131690768);
    AppMethodBeat.o(174361);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, g.a parama, h.a parama1)
  {
    int i = 2;
    AppMethodBeat.i(174367);
    ad.i("MicroMsg.EnvelopeStoryVideoManager", "trigger download video: %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    long l = SystemClock.elapsedRealtime();
    com.tencent.mm.i.h localh = new com.tencent.mm.i.h();
    localh.field_mediaId = paramString1;
    localh.field_fileId = paramString1;
    localh.url = paramString3;
    if (paramBoolean)
    {
      localh.foc = i;
      localh.field_preloadRatio = 20;
      localh.fnY = new EnvelopeStoryVideoManager.10(paramString3, l);
      if (parama == null) {
        break label212;
      }
    }
    label212:
    for (localh.fnH = parama;; localh.fnH = new EnvelopeStoryVideoManager.2(paramString2))
    {
      localh.fnX = 3;
      localh.field_fullpath = paramString2;
      localh.field_filemd5 = paramString4;
      localh.allow_mobile_net_download = true;
      localh.foj = parama1;
      localh.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
      localh.field_requestVideoFormat = 1;
      localh.fnW = localh.foc;
      if (!paramBoolean) {
        break label255;
      }
      if (!tiG.contains(paramString1)) {
        break label228;
      }
      ad.w("MicroMsg.EnvelopeStoryVideoManager", "contains preload task: %s", new Object[] { paramString1 });
      AppMethodBeat.o(174367);
      return;
      i = 1;
      break;
    }
    label228:
    tiG.add(paramString1);
    f.awL().b(localh, -1);
    AppMethodBeat.o(174367);
    return;
    label255:
    if (tiG.contains(paramString1))
    {
      ad.i("MicroMsg.EnvelopeStoryVideoManager", "need cancel preload task");
      f.awL().xL(paramString1);
    }
    o.aCJ().a(localh);
    AppMethodBeat.o(174367);
  }
  
  public static String afr(String paramString)
  {
    AppMethodBeat.i(163663);
    paramString = "MMVideo_" + paramString.hashCode();
    AppMethodBeat.o(163663);
    return paramString;
  }
  
  public static String afs(String paramString)
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
      paramc.tiX.setLocal(true);
    }
    paramc.pev.bringToFront();
    if (paramc.tiQ > 0)
    {
      ad.d("MicroMsg.EnvelopeStoryVideoManager", "start play: %s", new Object[] { Integer.valueOf(paramc.tiQ) });
      paramc.tiX.c(paramc.tiQ, true);
      paramc.tiT = paramc.tiQ;
    }
    for (paramc.tiU = 0L;; paramc.tiU = 0L)
    {
      paramc.tiW.set(1);
      if (!this.cSW)
      {
        this.hDB.requestFocus();
        this.cSW = true;
      }
      paramc.aUR = true;
      a.tjg += 1;
      a.tjf.add(paramc.url);
      AppMethodBeat.o(174362);
      return;
      paramc.tiX.start();
      paramc.tiT = 0L;
    }
  }
  
  private static boolean c(c paramc)
  {
    AppMethodBeat.i(174363);
    boolean bool2 = i.eK(afs(paramc.url));
    if (ax.aFC(cMf()).getInt(paramc.hxP, 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      ad.i("MicroMsg.EnvelopeStoryVideoManager", "can play local: %s, %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((!bool2) || (!bool1)) {
        break;
      }
      paramc.tiS = 1;
      AppMethodBeat.o(174363);
      return true;
    }
    if (bool2) {}
    for (paramc.tiS = 3;; paramc.tiS = 2)
    {
      ax.aFC(cMf()).putInt(paramc.hxP, 0);
      AppMethodBeat.o(174363);
      return false;
    }
  }
  
  private c cMe()
  {
    AppMethodBeat.i(174366);
    c localc = (c)this.tiF.get(Integer.valueOf(this.tiE));
    AppMethodBeat.o(174366);
    return localc;
  }
  
  private static String cMf()
  {
    AppMethodBeat.i(163666);
    String str = aj.getPackageName() + "_luckymoney_story_video";
    AppMethodBeat.o(163666);
    return str;
  }
  
  public final void a(Context paramContext, FrameLayout paramFrameLayout, ImageView paramImageView, ProgressBar paramProgressBar, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    AppMethodBeat.i(174364);
    ad.i("MicroMsg.EnvelopeStoryVideoManager", "update position: %s, %s, %s", new Object[] { Integer.valueOf(this.tiE), Integer.valueOf(paramInt3), paramString });
    if (paramInt3 != this.tiE)
    {
      c localc = (c)this.tiF.get(Integer.valueOf(this.tiE));
      if (localc != null)
      {
        ad.i("MicroMsg.EnvelopeStoryVideoManager", "pause previous video");
        if (localc.aUR)
        {
          localc.tiU = localc.tiX.getCurrPosSec();
          localc.tiX.onUIPause();
        }
      }
      this.tiE = paramInt3;
      if (paramBoolean) {
        a(paramContext, paramFrameLayout, paramImageView, paramProgressBar, paramString, paramInt1, paramInt2, paramInt3);
      }
      AppMethodBeat.o(174364);
      return;
    }
    ad.w("MicroMsg.EnvelopeStoryVideoManager", "skip same position");
    AppMethodBeat.o(174364);
  }
  
  public final void cMd()
  {
    AppMethodBeat.i(174365);
    ad.i("MicroMsg.EnvelopeStoryVideoManager", "release video view: %s", new Object[] { Integer.valueOf(this.tiF.size()) });
    if (this.cSW)
    {
      this.hDB.XF();
      this.cSW = false;
    }
    Iterator localIterator = this.tiF.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      ad.d("MicroMsg.EnvelopeStoryVideoManager", "do stop");
      c localc = (c)localEntry.getValue();
      if (localc.tiR > 0) {
        localc.rzE = ((int)(localc.rzE + (SystemClock.elapsedRealtime() / 1000L - localc.tiR)));
      }
      com.tencent.mm.plugin.report.service.h.vKh.f(19228, new Object[] { localc.url, Integer.valueOf(localc.tiX.getVideoDurationSec()), Integer.valueOf(1), Integer.valueOf(localc.tiS), Integer.valueOf(localc.tiX.getRealPlayDurationSec()), Integer.valueOf(localc.rzE), Integer.valueOf(0), Integer.valueOf(0) });
      if (((c)localEntry.getValue()).tiX.getParent() != null)
      {
        ((ViewGroup)((c)localEntry.getValue()).tiX.getParent()).removeView(((c)localEntry.getValue()).tiX);
        localc.tiX.stop();
      }
    }
    this.tiF.clear();
    this.tiE = -1;
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
    if (this.cSW)
    {
      this.hDB.XF();
      this.cSW = false;
    }
    c localc = cMe();
    if (localc != null) {
      localc.tiX.onUIPause();
    }
    AppMethodBeat.o(163660);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  public void onUIResume()
  {
    AppMethodBeat.i(163659);
    c localc = cMe();
    if (localc != null)
    {
      localc.tiX.onUIResume();
      if (localc.tiX.isPlaying())
      {
        this.hDB.requestFocus();
        this.cSW = true;
      }
    }
    AppMethodBeat.o(163659);
  }
  
  public final class a
    implements h.a
  {
    EnvelopeStoryVideoManager.c tiM;
    
    public a(EnvelopeStoryVideoManager.c paramc)
    {
      this.tiM = paramc;
    }
    
    public final void a(String paramString, int paramInt, d paramd)
    {
      AppMethodBeat.i(163648);
      if ((paramd != null) && (paramd.field_retCode == 0))
      {
        ad.i("MicroMsg.EnvelopeStoryVideoManager", "download finish: %s", new Object[] { paramString });
        EnvelopeStoryVideoManager.Km().putInt(paramString, 1).commit();
      }
      this.tiM.tiX.am(paramString, paramInt);
      AppMethodBeat.o(163648);
    }
    
    public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
    {
      AppMethodBeat.i(201264);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(163644);
          EnvelopeStoryVideoManager.a.this.tiM.tiX.Bl(paramLong1);
          AppMethodBeat.o(163644);
        }
      });
      AppMethodBeat.o(201264);
    }
    
    public final void k(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(163647);
      this.tiM.tiX.k(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(163647);
    }
    
    public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(163646);
      this.tiM.tiX.onDataAvailable(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(163646);
    }
  }
  
  final class b
    implements com.tencent.mm.modelvideo.b
  {
    EnvelopeStoryVideoManager.c tiM;
    
    public b(EnvelopeStoryVideoManager.c paramc)
    {
      this.tiM = paramc;
    }
    
    public final void a(b.a parama) {}
    
    public final void fy(String paramString)
    {
      AppMethodBeat.i(163652);
      o.aCJ().j(paramString, null);
      AppMethodBeat.o(163652);
    }
    
    public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(163654);
      boolean bool = o.aCJ().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(163654);
      return bool;
    }
    
    public final void q(String paramString1, final String paramString2, final String paramString3)
    {
      AppMethodBeat.i(163651);
      EnvelopeStoryVideoManager.a locala = new EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this, this.tiM);
      EnvelopeStoryVideoManager.a(paramString1, paramString2, paramString3, this.tiM.md5, false, new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(163650);
          ad.i("MicroMsg.EnvelopeStoryVideoManager", "cdn callback: %s, %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt != 0)
          {
            i.deleteFile(paramString2);
            if (EnvelopeStoryVideoManager.b.this.tiM.hxP.equals(paramAnonymousString))
            {
              ad.w("MicroMsg.EnvelopeStoryVideoManager", "download video fail: %s", new Object[] { paramString3 });
              EnvelopeStoryVideoManager.b.this.tiM.tiZ.setVisibility(0);
              EnvelopeStoryVideoManager.b.this.tiM.tiZ.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(163649);
                  ad.i("MicroMsg.EnvelopeStoryVideoManager", "click retry btn");
                  EnvelopeStoryVideoManager.b.this.tiM.sessionId = UUID.randomUUID().toString();
                  EnvelopeStoryVideoManager.b.this.tiM.tiX.setSessionId(EnvelopeStoryVideoManager.b.this.tiM.sessionId);
                  EnvelopeStoryVideoManager.b.this.tiM.tiX.setLocal(false);
                  EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this, EnvelopeStoryVideoManager.b.this.tiM);
                  AppMethodBeat.o(163649);
                }
              });
              com.tencent.mm.plugin.report.service.h.vKh.f(19228, new Object[] { EnvelopeStoryVideoManager.b.this.tiM.url, Integer.valueOf(EnvelopeStoryVideoManager.b.this.tiM.tiX.getVideoDurationSec()), Integer.valueOf(2), Integer.valueOf(EnvelopeStoryVideoManager.b.this.tiM.tiS), Integer.valueOf(EnvelopeStoryVideoManager.b.this.tiM.tiX.getRealPlayDurationSec()), Integer.valueOf(EnvelopeStoryVideoManager.b.this.tiM.rzE), Integer.valueOf(0), Integer.valueOf(-9999) });
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
      o.aCJ();
      e.q(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(163653);
    }
  }
  
  public static final class c
  {
    boolean aUR;
    boolean fqj;
    String hxP;
    ImageView kth;
    ImageView kty;
    String md5;
    ImageView pev;
    int rzE;
    String sessionId;
    int tiQ;
    int tiR;
    int tiS;
    long tiT;
    long tiU;
    long tiV;
    AtomicInteger tiW;
    EnvelopeStoryVideoView tiX;
    ViewGroup tiY;
    ViewGroup tiZ;
    ProgressBar tja;
    String url;
    
    public c()
    {
      AppMethodBeat.i(182469);
      this.fqj = true;
      this.aUR = false;
      this.tiR = 0;
      this.rzE = 0;
      this.tiW = new AtomicInteger(1);
      AppMethodBeat.o(182469);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager
 * JD-Core Version:    0.7.0.1
 */