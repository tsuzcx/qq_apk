package com.tencent.mm.plugin.luckymoney.story;

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
import androidx.lifecycle.k;
import androidx.lifecycle.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.e;
import com.tencent.mm.i.c;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.modelvideo.f.a;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.vfs.u;
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
  implements k
{
  private static Set<String> EFa;
  Map<Integer, c> EEZ;
  private boolean fmk;
  private boolean iYs;
  private com.tencent.mm.compatible.util.b mlj;
  MMActivity tnf;
  int zrB;
  
  static
  {
    AppMethodBeat.i(163670);
    EFa = new HashSet();
    AppMethodBeat.o(163670);
  }
  
  public EnvelopeStoryVideoManager()
  {
    AppMethodBeat.i(163655);
    this.zrB = -1;
    this.iYs = false;
    this.mlj = new com.tencent.mm.compatible.util.b(MMApplicationContext.getContext());
    this.fmk = false;
    this.EEZ = new HashMap();
    AppMethodBeat.o(163655);
  }
  
  private void a(Context paramContext, FrameLayout paramFrameLayout, ImageView paramImageView, ProgressBar paramProgressBar, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(218966);
    Log.i("MicroMsg.EnvelopeStoryVideoManager", "preapre video view: %s", new Object[] { Boolean.valueOf(paramBoolean1) });
    final c localc = (c)this.EEZ.get(Integer.valueOf(paramInt3));
    if ((localc == null) || (localc.EFr == null))
    {
      localc = new c();
      localc.EFr = new EnvelopeStoryVideoView(paramContext);
      localc.url = paramString;
      localc.sessionId = UUID.randomUUID().toString();
      localc.voG = paramImageView;
      localc.EFu = paramProgressBar;
      localc.EFl = paramBoolean1;
      localc.isPreview = paramBoolean2;
      localc.EFs = ((ViewGroup)paramFrameLayout.findViewById(a.f.lukcy_money_detail_story_item_video_control_layout));
      localc.pCc = ((ImageView)paramFrameLayout.findViewById(a.f.lukcy_money_detail_story_item_video_play_iv));
      localc.pCt = ((ImageView)paramFrameLayout.findViewById(a.f.lucky_money_detail_story_mute_iv));
      localc.EFt = ((ViewGroup)paramFrameLayout.findViewById(a.f.lucky_money_detail_story_item_retry_layout));
      localc.EFr.setIsShowBasicControls(false);
      localc.EFr.EFx = new EnvelopeStoryVideoView.a()
      {
        public final void a(EnvelopeStoryVideoView paramAnonymousEnvelopeStoryVideoView)
        {
          AppMethodBeat.i(182457);
          int i = localc.EFq.addAndGet(1);
          localc.sTg = paramAnonymousEnvelopeStoryVideoView.getVideoDurationSec();
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "sessionId: %s, current loop count: %s", new Object[] { localc.sessionId, Integer.valueOf(i) });
          AppMethodBeat.o(182457);
        }
      };
      localc.EFr.setIMMVideoViewCallback(new i.b()
      {
        public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(182459);
          Log.e("MicroMsg.EnvelopeStoryVideoManager", "onError: %s, %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2, paramAnonymousString3 });
          com.tencent.mm.plugin.report.service.h.IzE.a(19228, new Object[] { localc.url, Integer.valueOf(localc.EFr.getVideoDurationSec()), Integer.valueOf(2), Integer.valueOf(localc.EFn), Integer.valueOf(localc.EFr.getRealPlayDurationSec()), Integer.valueOf(localc.BTy), Integer.valueOf(0), Integer.valueOf(paramAnonymousInt1) });
          AppMethodBeat.o(182459);
        }
        
        public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2) {}
        
        public final void dS(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182460);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "on prepared: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          localc.sTg = localc.EFr.getVideoDurationSec();
          MMHandlerThread.postToMainThreadDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(182458);
              if (EnvelopeStoryVideoManager.6.this.EFc.EFu != null) {
                EnvelopeStoryVideoManager.6.this.EFc.EFu.setVisibility(8);
              }
              if (EnvelopeStoryVideoManager.6.this.EFc.EFr.getParent() != null) {
                ((ViewGroup)EnvelopeStoryVideoManager.6.this.EFc.EFr.getParent()).bringToFront();
              }
              if (!EnvelopeStoryVideoManager.6.this.EFc.isPreview) {
                EnvelopeStoryVideoManager.6.this.EFc.pCt.setVisibility(0);
              }
              AppMethodBeat.o(182458);
            }
          }, 10L);
          AppMethodBeat.o(182460);
        }
        
        public final void dT(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182461);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "on video end: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(182461);
        }
        
        public final void dU(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182462);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoPause: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(182462);
        }
        
        public final void dV(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182463);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoPlay: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(182463);
        }
        
        public final void dW(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182464);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoWaiting: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          localc.EFm = ((int)SystemClock.elapsedRealtime() / 1000);
          if (localc.EFu != null)
          {
            localc.EFu.bringToFront();
            localc.EFu.setVisibility(0);
          }
          AppMethodBeat.o(182464);
        }
        
        public final void dX(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(182465);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoWaitingEnd: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          if (localc.EFm > 0)
          {
            paramAnonymousString1 = localc;
            paramAnonymousString1.BTy = ((int)(paramAnonymousString1.BTy + (SystemClock.elapsedRealtime() / 1000L - localc.EFm)));
            localc.EFm = 0;
          }
          if (localc.EFu != null) {
            localc.EFu.setVisibility(8);
          }
          AppMethodBeat.o(182465);
        }
        
        public final void fC(String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(216097);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "onVideoFirstFrameDraw: %s, %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
          AppMethodBeat.o(216097);
        }
      });
      localc.pCc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(174356);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "click play btn");
          if ((localc.EFr != null) && (localc.EFr.isPlaying()))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(174356);
            return;
          }
          localc.pCc.setVisibility(4);
          EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this, localc);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(174356);
        }
      });
      localc.EFs.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(182466);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          if ((EnvelopeStoryVideoManager.b(EnvelopeStoryVideoManager.this) != -1) && (localc.EFr != null)) {
            EnvelopeStoryVideoManager.b(EnvelopeStoryVideoManager.this, localc);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(182466);
        }
      });
      paramContext = new FrameLayout.LayoutParams(paramInt1, paramInt2);
      paramContext.gravity = 17;
      paramFrameLayout.addView(localc.EFr, 0, paramContext);
      localc.EFs.setLayoutParams(paramContext);
      this.EEZ.put(Integer.valueOf(paramInt3), localc);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174345);
          EnvelopeStoryVideoManager.f(localc);
          AppMethodBeat.o(174345);
        }
      });
      localc.EFr.setSessionId(localc.sessionId);
      localc.EFr.setIOnlineVideoProxy(new b(localc));
      localc.EFr.setLocalPreDownloadVideo(localc.EFl);
      localc.EFr.c(false, localc.url, 0);
      localc.mfu = localc.EFr.getMediaId();
      c(localc);
      b(localc);
      d(localc);
      AppMethodBeat.o(218966);
      return;
    }
    localc.isPreview = paramBoolean2;
    c(localc);
    b(localc);
    MMHandlerThread.postToMainThreadDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174346);
        if ((localc.aPw) && (localc.EFr.adH()))
        {
          localc.EFr.onUIResume();
          localc.EFo = localc.EFr.getCurrPosSec();
          localc.EFp = 0L;
        }
        for (;;)
        {
          localc.EFq.set(1);
          AppMethodBeat.o(174346);
          return;
          if (localc.EFr.isPlaying())
          {
            Log.w("MicroMsg.EnvelopeStoryVideoManager", "resume fail, restart play");
            localc.EFr.stop();
            localc.EFr.start();
            localc.EFo = 0L;
            localc.EFp = 0L;
          }
        }
      }
    }, 200L);
    AppMethodBeat.o(218966);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, g.a parama, com.tencent.mm.i.h.a parama1)
  {
    AppMethodBeat.i(174367);
    Log.i("MicroMsg.EnvelopeStoryVideoManager", "trigger download video: %s, %s, %s", new Object[] { paramString1, paramString2, paramString3 });
    int i;
    if (paramBoolean)
    {
      if (((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHq, 1) == 0) {
        Log.i("MicroMsg.EnvelopeStoryVideoManager", "can not preload video");
      }
      for (i = 0; i == 0; i = 1)
      {
        AppMethodBeat.o(174367);
        return;
      }
    }
    long l = SystemClock.elapsedRealtime();
    com.tencent.mm.i.h localh = new com.tencent.mm.i.h();
    localh.taskName = "task_EnvelopeStoryVideoManager";
    localh.field_mediaId = paramString1;
    localh.field_fileId = paramString1;
    localh.url = paramString3;
    if (paramBoolean)
    {
      i = 2;
      localh.iVd = i;
      localh.field_preloadRatio = 20;
      localh.iUY = new EnvelopeStoryVideoManager.10(paramString3, l);
      if (parama == null) {
        break label275;
      }
    }
    label275:
    for (localh.iUG = parama;; localh.iUG = new EnvelopeStoryVideoManager.2(paramString2))
    {
      localh.iUX = 3;
      localh.field_fullpath = paramString2;
      localh.field_filemd5 = paramString4;
      localh.allow_mobile_net_download = true;
      localh.iVn = parama1;
      localh.field_fileType = com.tencent.mm.i.a.MediaType_VIDEO;
      localh.field_requestVideoFormat = 1;
      localh.iUW = localh.iVd;
      if (!paramBoolean) {
        break label318;
      }
      if (!EFa.contains(paramString1)) {
        break label291;
      }
      Log.w("MicroMsg.EnvelopeStoryVideoManager", "contains preload task: %s", new Object[] { paramString1 });
      AppMethodBeat.o(174367);
      return;
      i = 1;
      break;
    }
    label291:
    EFa.add(paramString1);
    com.tencent.mm.aq.f.bkg().b(localh, -1);
    AppMethodBeat.o(174367);
    return;
    label318:
    if (EFa.contains(paramString1))
    {
      Log.i("MicroMsg.EnvelopeStoryVideoManager", "need cancel preload task");
      com.tencent.mm.aq.f.bkg().Vz(paramString1);
    }
    s.bqC().e(localh);
    AppMethodBeat.o(174367);
  }
  
  public static String aNI(String paramString)
  {
    AppMethodBeat.i(163663);
    paramString = "MMVideo_" + paramString.hashCode();
    AppMethodBeat.o(163663);
    return paramString;
  }
  
  public static String aNJ(String paramString)
  {
    AppMethodBeat.i(163664);
    paramString = EnvelopeStoryVideoView.ROOT_PATH + "MMVideo_" + paramString.hashCode() + ".mp4";
    AppMethodBeat.o(163664);
    return paramString;
  }
  
  public static MultiProcessMMKV aal()
  {
    AppMethodBeat.i(293084);
    MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV(ePt());
    AppMethodBeat.o(293084);
    return localMultiProcessMMKV;
  }
  
  private static void b(c paramc)
  {
    AppMethodBeat.i(218974);
    if (paramc.EFr.EFv)
    {
      paramc.pCt.setImageResource(a.h.lucky_money_mute_icon);
      AppMethodBeat.o(218974);
      return;
    }
    paramc.pCt.setImageResource(a.h.lucky_money_unmute_icon);
    AppMethodBeat.o(218974);
  }
  
  public static boolean bB(int paramInt, String paramString)
  {
    AppMethodBeat.i(219020);
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHm, true);
    Log.i("MicroMsg.EnvelopeStoryVideoManager", "[static luckymoney resource switch] canGetLuckyMoneyEnvelopeLocalVideoRes ：%s", new Object[] { Boolean.valueOf(bool) });
    if ((paramInt > 0) && (!Util.isNullOrNil(paramString)) && (u.agG(paramString)) && (bool))
    {
      bool = true;
      if (!bool) {
        break label104;
      }
      Log.i("MicroMsg.EnvelopeStoryVideoManager", "[static luckymoney resource] use local：LuckyMoneyEnvelopeLocalVideoRes：%s", new Object[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      AppMethodBeat.o(219020);
      return bool;
      bool = false;
      break;
      label104:
      Log.i("MicroMsg.EnvelopeStoryVideoManager", "[static luckymoney resource] use net: LuckyMoneyEnvelopeLocalVideoRes:%s", new Object[] { Integer.valueOf(paramInt) });
    }
  }
  
  private void c(c paramc)
  {
    AppMethodBeat.i(218979);
    if (paramc.isPreview)
    {
      paramc.pCt.setVisibility(4);
      paramc.EFr.setMute(true);
      AppMethodBeat.o(218979);
      return;
    }
    paramc.pCt.setVisibility(0);
    paramc.EFr.setMute(this.iYs);
    AppMethodBeat.o(218979);
  }
  
  private void d(c paramc)
  {
    AppMethodBeat.i(174362);
    if ((!paramc.EFl) && (e(paramc))) {
      paramc.EFr.setLocal(true);
    }
    paramc.voG.bringToFront();
    if (paramc.EFk > 0)
    {
      Log.d("MicroMsg.EnvelopeStoryVideoManager", "start play: %s", new Object[] { Integer.valueOf(paramc.EFk) });
      paramc.EFr.a(paramc.EFk, true);
      paramc.EFo = paramc.EFk;
    }
    for (paramc.EFp = 0L;; paramc.EFp = 0L)
    {
      paramc.EFq.set(1);
      if (!this.fmk)
      {
        this.mlj.avy();
        this.fmk = true;
      }
      paramc.aPw = true;
      b.EFD += 1;
      b.EFC.add(paramc.url);
      AppMethodBeat.o(174362);
      return;
      paramc.EFr.start();
      paramc.EFo = 0L;
    }
  }
  
  private static boolean e(c paramc)
  {
    AppMethodBeat.i(174363);
    boolean bool2 = u.agG(aNJ(paramc.url));
    if (MultiProcessMMKV.getMMKV(ePt()).getInt(paramc.mfu, 0) == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      Log.i("MicroMsg.EnvelopeStoryVideoManager", "can play local: %s, %s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
      if ((!bool2) || (!bool1)) {
        break;
      }
      paramc.EFn = 1;
      AppMethodBeat.o(174363);
      return true;
    }
    if (bool2) {}
    for (paramc.EFn = 3;; paramc.EFn = 2)
    {
      MultiProcessMMKV.getMMKV(ePt()).putInt(paramc.mfu, 0);
      AppMethodBeat.o(174363);
      return false;
    }
  }
  
  private c ePs()
  {
    AppMethodBeat.i(174366);
    c localc = (c)this.EEZ.get(Integer.valueOf(this.zrB));
    AppMethodBeat.o(174366);
    return localc;
  }
  
  private static String ePt()
  {
    AppMethodBeat.i(163666);
    String str = MMApplicationContext.getPackageName() + "_luckymoney_story_video";
    AppMethodBeat.o(163666);
    return str;
  }
  
  public final void a(Context paramContext, FrameLayout paramFrameLayout, ImageView paramImageView, ProgressBar paramProgressBar, String paramString, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(218990);
    Log.i("MicroMsg.EnvelopeStoryVideoManager", "update position: %s, %s, %s, %s", new Object[] { Integer.valueOf(this.zrB), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean3), paramString });
    c localc = (c)this.EEZ.get(Integer.valueOf(paramInt3));
    if (localc != null)
    {
      localc.isPreview = paramBoolean3;
      c(localc);
      b(localc);
    }
    if (paramInt3 != this.zrB)
    {
      localc = (c)this.EEZ.get(Integer.valueOf(this.zrB));
      if (localc != null)
      {
        Log.i("MicroMsg.EnvelopeStoryVideoManager", "pause previous video");
        if (localc.aPw)
        {
          localc.EFp = localc.EFr.getCurrPosSec();
          localc.EFr.onUIPause();
        }
      }
      this.zrB = paramInt3;
      if (paramBoolean1) {
        a(paramContext, paramFrameLayout, paramImageView, paramProgressBar, paramString, paramInt1, paramInt2, paramInt3, paramBoolean2, paramBoolean3);
      }
      AppMethodBeat.o(218990);
      return;
    }
    Log.w("MicroMsg.EnvelopeStoryVideoManager", "skip same position");
    AppMethodBeat.o(218990);
  }
  
  final void a(c paramc)
  {
    AppMethodBeat.i(174361);
    if (paramc.EFr == null)
    {
      AppMethodBeat.o(174361);
      return;
    }
    boolean bool;
    if (!paramc.EFr.EFv)
    {
      bool = true;
      this.iYs = bool;
      Log.i("MicroMsg.EnvelopeStoryVideoManager", "click to mute: %s", new Object[] { Boolean.valueOf(this.iYs) });
      paramc.EFr.setMute(this.iYs);
      if (this.iYs) {
        break label106;
      }
      this.mlj.avy();
      this.fmk = true;
    }
    for (;;)
    {
      b(paramc);
      AppMethodBeat.o(174361);
      return;
      bool = false;
      break;
      label106:
      if (this.fmk)
      {
        this.mlj.avz();
        this.fmk = false;
      }
    }
  }
  
  public final void ePr()
  {
    AppMethodBeat.i(174365);
    Log.i("MicroMsg.EnvelopeStoryVideoManager", "release video view: %s, %s", new Object[] { Integer.valueOf(this.EEZ.size()), Util.getStack() });
    if (this.fmk)
    {
      this.mlj.avz();
      this.fmk = false;
    }
    Iterator localIterator = this.EEZ.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      Log.d("MicroMsg.EnvelopeStoryVideoManager", "do stop");
      c localc = (c)localEntry.getValue();
      if (localc.EFm > 0) {
        localc.BTy = ((int)(localc.BTy + (SystemClock.elapsedRealtime() / 1000L - localc.EFm)));
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(19228, new Object[] { localc.url, Integer.valueOf(localc.EFr.getVideoDurationSec()), Integer.valueOf(1), Integer.valueOf(localc.EFn), Integer.valueOf(localc.EFr.getRealPlayDurationSec()), Integer.valueOf(localc.BTy), Integer.valueOf(0), Integer.valueOf(0) });
      if (((c)localEntry.getValue()).EFr.getParent() != null)
      {
        ((ViewGroup)((c)localEntry.getValue()).EFr.getParent()).removeView(((c)localEntry.getValue()).EFr);
        localc.EFr.stop();
      }
    }
    this.EEZ.clear();
    this.zrB = -1;
    AppMethodBeat.o(174365);
  }
  
  @t(jl=androidx.lifecycle.h.a.ON_DESTROY)
  public void onUIDestroy()
  {
    AppMethodBeat.i(163661);
    AppMethodBeat.o(163661);
  }
  
  @t(jl=androidx.lifecycle.h.a.ON_PAUSE)
  public void onUIPause()
  {
    AppMethodBeat.i(163660);
    if (this.fmk)
    {
      this.mlj.avz();
      this.fmk = false;
    }
    c localc = ePs();
    if (localc != null) {
      localc.EFr.onUIPause();
    }
    AppMethodBeat.o(163660);
  }
  
  @t(jl=androidx.lifecycle.h.a.ON_RESUME)
  public void onUIResume()
  {
    AppMethodBeat.i(163659);
    c localc = ePs();
    if (localc != null)
    {
      localc.EFr.onUIResume();
      if (localc.EFr.isPlaying())
      {
        this.mlj.avy();
        this.fmk = true;
      }
    }
    AppMethodBeat.o(163659);
  }
  
  public final class a
    implements com.tencent.mm.i.h.a
  {
    private EnvelopeStoryVideoManager.c EFg;
    
    public a(EnvelopeStoryVideoManager.c paramc)
    {
      this.EFg = paramc;
    }
    
    public final void Kj(String paramString) {}
    
    public final void a(String paramString, int paramInt, d paramd)
    {
      AppMethodBeat.i(163648);
      if ((paramd != null) && (paramd.field_retCode == 0))
      {
        Log.i("MicroMsg.EnvelopeStoryVideoManager", "download finish: %s", new Object[] { paramString });
        EnvelopeStoryVideoManager.aal().putInt(paramString, 1).commit();
      }
      this.EFg.EFr.aP(paramString, paramInt);
      AppMethodBeat.o(163648);
    }
    
    public final void a(final String paramString1, final long paramLong1, long paramLong2, final String paramString2)
    {
      AppMethodBeat.i(221622);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(163644);
          EnvelopeStoryVideoManager.a.a(EnvelopeStoryVideoManager.a.this).EFr.GQ(paramLong1);
          AppMethodBeat.o(163644);
        }
      });
      AppMethodBeat.o(221622);
    }
    
    public final void h(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(163647);
      this.EFg.EFr.h(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(163647);
    }
    
    public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(163646);
      this.EFg.EFr.onDataAvailable(paramString, paramLong1, paramLong2);
      AppMethodBeat.o(163646);
    }
  }
  
  final class b
    implements com.tencent.mm.modelvideo.f
  {
    private EnvelopeStoryVideoManager.c EFg;
    
    public b(EnvelopeStoryVideoManager.c paramc)
    {
      this.EFg = paramc;
    }
    
    public final void a(f.a parama) {}
    
    public final void hR(String paramString)
    {
      AppMethodBeat.i(163652);
      s.bqC().k(paramString, null);
      AppMethodBeat.o(163652);
    }
    
    public final boolean isVideoDataAvailable(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(163654);
      boolean bool = s.bqC().isVideoDataAvailable(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(163654);
      return bool;
    }
    
    public final void requestVideoData(String paramString, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(163653);
      Log.d("MicroMsg.EnvelopeStoryVideoManager", "request video data: %s", new Object[] { paramString });
      s.bqC();
      e.s(paramString, paramInt1, paramInt2);
      AppMethodBeat.o(163653);
    }
    
    public final void s(String paramString1, final String paramString2, final String paramString3)
    {
      AppMethodBeat.i(163651);
      EnvelopeStoryVideoManager.a locala = new EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this, this.EFg);
      EnvelopeStoryVideoManager.a(paramString1, paramString2, paramString3, this.EFg.md5, false, new g.a()
      {
        public final int a(String paramAnonymousString, int paramAnonymousInt, c paramAnonymousc, d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(163650);
          Log.i("MicroMsg.EnvelopeStoryVideoManager", "cdn callback: %s, %s", new Object[] { paramAnonymousString, Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt != 0)
          {
            u.deleteFile(paramString2);
            if (EnvelopeStoryVideoManager.b.a(EnvelopeStoryVideoManager.b.this).mfu.equals(paramAnonymousString))
            {
              Log.w("MicroMsg.EnvelopeStoryVideoManager", "download video fail: %s", new Object[] { paramString3 });
              EnvelopeStoryVideoManager.b.a(EnvelopeStoryVideoManager.b.this).EFt.setVisibility(0);
              EnvelopeStoryVideoManager.b.a(EnvelopeStoryVideoManager.b.this).EFt.setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymous2View)
                {
                  AppMethodBeat.i(163649);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymous2View);
                  com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$EnvelopeStoryVideoProxy$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  Log.i("MicroMsg.EnvelopeStoryVideoManager", "click retry btn");
                  EnvelopeStoryVideoManager.b.a(EnvelopeStoryVideoManager.b.this).sessionId = UUID.randomUUID().toString();
                  EnvelopeStoryVideoManager.b.a(EnvelopeStoryVideoManager.b.this).EFr.setSessionId(EnvelopeStoryVideoManager.b.a(EnvelopeStoryVideoManager.b.this).sessionId);
                  EnvelopeStoryVideoManager.b.a(EnvelopeStoryVideoManager.b.this).EFr.setLocal(false);
                  EnvelopeStoryVideoManager.a(EnvelopeStoryVideoManager.this, EnvelopeStoryVideoManager.b.a(EnvelopeStoryVideoManager.b.this));
                  com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeStoryVideoManager$EnvelopeStoryVideoProxy$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(163649);
                }
              });
              com.tencent.mm.plugin.report.service.h.IzE.a(19228, new Object[] { EnvelopeStoryVideoManager.b.a(EnvelopeStoryVideoManager.b.this).url, Integer.valueOf(EnvelopeStoryVideoManager.b.a(EnvelopeStoryVideoManager.b.this).EFr.getVideoDurationSec()), Integer.valueOf(2), Integer.valueOf(EnvelopeStoryVideoManager.b.a(EnvelopeStoryVideoManager.b.this).EFn), Integer.valueOf(EnvelopeStoryVideoManager.b.a(EnvelopeStoryVideoManager.b.this).EFr.getRealPlayDurationSec()), Integer.valueOf(EnvelopeStoryVideoManager.b.a(EnvelopeStoryVideoManager.b.this).BTy), Integer.valueOf(0), Integer.valueOf(-9999) });
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
  }
  
  public static final class c
  {
    int BTy;
    int EFk;
    boolean EFl;
    int EFm;
    int EFn;
    long EFo;
    long EFp;
    AtomicInteger EFq;
    EnvelopeStoryVideoView EFr;
    ViewGroup EFs;
    ViewGroup EFt;
    ProgressBar EFu;
    boolean aPw;
    boolean isPreview;
    String md5;
    String mfu;
    ImageView pCc;
    ImageView pCt;
    long sTg;
    String sessionId;
    String url;
    ImageView voG;
    
    public c()
    {
      AppMethodBeat.i(182469);
      this.aPw = false;
      this.isPreview = false;
      this.EFm = 0;
      this.BTy = 0;
      this.EFq = new AtomicInteger(1);
      AppMethodBeat.o(182469);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeStoryVideoManager
 * JD-Core Version:    0.7.0.1
 */