package com.tencent.mm.plugin.finder.live.plugin;

import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.live.b.b.c;
import com.tencent.mm.plugin.finder.live.model.q;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.recovery.util.Util;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import org.libpag.PAGFile;
import org.libpag.PAGView;
import org.libpag.PAGView.PAGViewListener;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPlayPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "animLoopTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "curGiftId", "", "giftHideTipGroup", "Landroid/view/View;", "giftHideTipGroupAnim", "Landroid/view/ViewPropertyAnimator;", "giftPlayView", "Lorg/libpag/PAGView;", "canClearScreen", "", "hideGift", "", "hideSingleGift", "playGiftAnimation", "isForceReplace", "isFromSelf", "setVisible", "visible", "", "showGift", "giftId", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "tryShowHideTip", "unMount", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class av
  extends b
{
  public static final av.a DaH;
  private static final String TAG;
  private final PAGView DaI;
  private final View DaJ;
  private ViewPropertyAnimator DaK;
  private final MTimerHandler DaL;
  private String Dap;
  private final com.tencent.mm.live.b.b nfT;
  
  static
  {
    AppMethodBeat.i(354962);
    DaH = new av.a((byte)0);
    TAG = "Finder.FinderLiveGiftPlayPlugin";
    AppMethodBeat.o(354962);
  }
  
  public av(ViewGroup paramViewGroup, com.tencent.mm.live.b.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(354902);
    this.nfT = paramb;
    paramb = paramViewGroup.findViewById(p.e.BLS);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.finder_live_gift_play_view)");
    this.DaI = ((PAGView)paramb);
    paramb = paramViewGroup.findViewById(p.e.BLy);
    kotlin.g.b.s.s(paramb, "root.findViewById(R.id.f…live_gift_hide_tip_group)");
    this.DaJ = paramb;
    this.DaL = new MTimerHandler(TAG, new av..ExternalSyntheticLambda1(this), true);
    this.DaJ.getLayoutParams().height = ((int)(bf.bf(paramViewGroup.getContext()).y * 0.16F) + bf.bk(paramViewGroup.getContext()));
    this.DaJ.setPadding(0, 0, 0, bd.fromDPToPix(paramViewGroup.getContext(), 48) + bf.bk(paramViewGroup.getContext()));
    paramViewGroup = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (!com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      this.DaI.setClickable(true);
      this.DaI.setOnClickListener(new av..ExternalSyntheticLambda0(this));
    }
    for (;;)
    {
      this.DaI.addListener((PAGView.PAGViewListener)new PAGView.PAGViewListener()
      {
        public final void onAnimationCancel(PAGView paramAnonymousPAGView)
        {
          AppMethodBeat.i(353427);
          Log.i(av.access$getTAG$cp(), "onAnimationCancel");
          AppMethodBeat.o(353427);
        }
        
        public final void onAnimationEnd(PAGView paramAnonymousPAGView)
        {
          AppMethodBeat.i(353422);
          Log.i(av.access$getTAG$cp(), "onAnimationEnd");
          AppMethodBeat.o(353422);
        }
        
        public final void onAnimationRepeat(PAGView paramAnonymousPAGView)
        {
          AppMethodBeat.i(353417);
          Log.i(av.access$getTAG$cp(), "onAnimationRepeat");
          AppMethodBeat.o(353417);
        }
        
        public final void onAnimationStart(PAGView paramAnonymousPAGView)
        {
          AppMethodBeat.i(353431);
          Log.i(av.access$getTAG$cp(), "onAnimationStart");
          av.c(this.DaM).setVisibility(0);
          AppMethodBeat.o(353431);
        }
      });
      AppMethodBeat.o(354902);
      return;
      this.DaI.setOnClickListener(null);
      this.DaI.setClickable(false);
    }
  }
  
  private static final void a(av paramav, View paramView)
  {
    AppMethodBeat.i(354918);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramav);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPlayPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramav, "this$0");
    paramav.DaI.setAlpha(0.0F);
    paramav.DaI.setClickable(false);
    paramav.DaJ.setVisibility(8);
    paramav.DaJ.setAlpha(0.0F);
    paramav = paramav.DaK;
    if (paramav != null) {
      paramav.cancel();
    }
    h.baE().ban().set(at.a.adeT, Boolean.TRUE);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/plugin/FinderLiveGiftPlayPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(354918);
  }
  
  private static final boolean a(av paramav)
  {
    AppMethodBeat.i(354909);
    kotlin.g.b.s.u(paramav, "this$0");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new c(paramav));
    AppMethodBeat.o(354909);
    return true;
  }
  
  private static final void b(av paramav)
  {
    AppMethodBeat.i(354930);
    kotlin.g.b.s.u(paramav, "this$0");
    PAGView localPAGView = paramav.DaI;
    Object localObject = q.CFU;
    String str = q.aww(paramav.Dap);
    localObject = str;
    if (str == null) {
      localObject = "";
    }
    localPAGView.setFile(PAGFile.Load((String)localObject));
    paramav.DaI.setScaleMode(3);
    paramav.DaI.setRepeatCount(0);
    paramav.DaI.play();
    paramav.DaI.flush();
    localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (!com.tencent.mm.plugin.finder.live.utils.a.bUx())
    {
      paramav.DaL.stopTimer();
      paramav.DaL.startTimer(paramav.DaI.duration() / 1000L);
      localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      boolean bool = com.tencent.mm.plugin.finder.live.utils.a.euS();
      if (bool) {
        com.tencent.mm.ae.d.a(1000L, (kotlin.g.a.a)new d(paramav));
      }
      Log.i(TAG, kotlin.g.b.s.X("tryShowHideTip showGiftTip:", Boolean.valueOf(bool)));
    }
    Log.i(TAG, kotlin.g.b.s.X("playGiftAnimation launch timer by ", Long.valueOf(paramav.DaI.duration() / 1000L)));
    AppMethodBeat.o(354930);
  }
  
  public final boolean eoI()
  {
    return true;
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(355013);
    kotlin.g.b.s.u(paramc, "status");
    switch (b.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(355013);
      return;
      boolean bool1;
      label65:
      boolean bool2;
      if (paramBundle == null)
      {
        bool1 = false;
        if (paramBundle != null) {
          break label293;
        }
        paramc = "";
        if (paramBundle != null) {
          break label315;
        }
        bool2 = false;
      }
      for (;;)
      {
        if (paramc != null)
        {
          paramBundle = q.CFU;
          paramBundle = q.awx(paramc);
          if ((paramBundle != null) && (!Util.isNullOrNil(paramBundle.field_animationPagUrl)))
          {
            Log.i(TAG, "show full screen gift,id:" + paramc + ", info:" + paramBundle + ",isForceReplace:" + bool2);
            this.Dap = paramc;
            tO(0);
            boolean bool3 = ((e)business(e.class)).EeM;
            paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
            boolean bool4 = com.tencent.mm.plugin.finder.live.utils.a.bUx();
            Log.i(TAG, "playGiftAnimation playViewIsPlaying:" + this.DaI.isPlaying() + ", isForceReplace:" + bool2 + ", isLandscape:" + isLandscape() + ", effectOff:" + bool3 + ", isAnchor:" + bool4);
            if (((this.DaI.isPlaying()) && (!bool2)) || (isLandscape()))
            {
              AppMethodBeat.o(355013);
              return;
              bool1 = paramBundle.getBoolean("PARAM_LIVE_GIFT_IS_FROM_SELF", false);
              break;
              label293:
              paramc = paramBundle.getString("PARAM_LIVE_GIFT_INFO");
              if (paramc == null)
              {
                paramc = "";
                break label65;
              }
              break label65;
              label315:
              bool2 = paramBundle.getBoolean("PARAM_LIVE_GIFT_IS_FORCE_REPLACE", false);
              continue;
            }
            if ((bool4) || (!bool3) || (bool1)) {
              this.DaI.post(new av..ExternalSyntheticLambda2(this));
            }
            AppMethodBeat.o(355013);
            return;
          }
          Log.i(TAG, "skip show full screen gift id:" + paramc + ", giftPath is null");
        }
      }
      AppMethodBeat.o(355013);
      return;
      Log.i(TAG, kotlin.g.b.s.X("hide full screen gift, id:", this.Dap));
      tO(8);
      this.DaI.setVisibility(8);
      this.DaI.stop();
      this.DaI.setAlpha(1.0F);
      paramc = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      if (!com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
        this.DaI.setClickable(true);
      }
      this.DaL.stopTimer();
      this.DaJ.setVisibility(8);
      this.DaJ.setAlpha(0.0F);
      paramc = this.DaK;
      if (paramc != null) {
        paramc.cancel();
      }
    }
  }
  
  public final void tO(int paramInt)
  {
    AppMethodBeat.i(371433);
    if (((com.tencent.mm.plugin.finder.live.viewmodel.data.business.s)business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.s.class)).kLm())
    {
      super.tO(8);
      AppMethodBeat.o(371433);
      return;
    }
    super.tO(paramInt);
    AppMethodBeat.o(371433);
  }
  
  public final void unMount()
  {
    AppMethodBeat.i(355021);
    super.unMount();
    this.DaI.setAlpha(1.0F);
    Object localObject = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    if (!com.tencent.mm.plugin.finder.live.utils.a.bUx()) {
      this.DaI.setClickable(true);
    }
    this.DaL.stopTimer();
    this.DaJ.setVisibility(8);
    this.DaJ.setAlpha(0.0F);
    localObject = this.DaK;
    if (localObject != null) {
      ((ViewPropertyAnimator)localObject).cancel();
    }
    AppMethodBeat.o(355021);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(av paramav)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(av paramav)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.av
 * JD-Core Version:    0.7.0.1
 */