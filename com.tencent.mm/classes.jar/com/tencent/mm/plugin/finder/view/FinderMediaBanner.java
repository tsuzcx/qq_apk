package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar;
import com.tencent.mm.plugin.finder.video.FinderVideoSeekBar;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.azy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.MediaBanner;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "Lcom/tencent/mm/view/MediaBanner;", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "hideTextTimer", "Ljava/util/Timer;", "value", "", "isFrozenRecyclerView", "()Z", "setFrozenRecyclerView", "(Z)V", "isNeedSpaceView", "setNeedSpaceView", "longVideoSeekBar", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "getLongVideoSeekBar", "()Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "setLongVideoSeekBar", "(Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;)V", "refDeleteTip", "Landroid/widget/TextView;", "refDeleteTipLayout", "Landroid/view/View;", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "refFeedInfo", "getRefFeedInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeedInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "refFromTv", "refLayout", "seekBarLayout", "Lcom/tencent/mm/plugin/finder/video/FinderVideoSeekBar;", "spaceView", "getSpaceView", "()Landroid/view/View;", "topLayer", "typeIconIv", "Landroid/widget/ImageView;", "getTypeIconIv", "()Landroid/widget/ImageView;", "warnContainer", "canScrollHorizontally", "direction", "parent", "Landroid/view/ViewGroup;", "x", "", "y", "getLinearLayoutManager", "Landroid/support/v7/widget/LinearLayoutManager;", "refreshRefUI", "", "removeSeekBar", "startLoopPlay", "stopLoopPlay", "plugin-finder_release"})
public final class FinderMediaBanner
  extends MediaBanner<com.tencent.mm.ui.base.a.b>
  implements FinderViewPager.a
{
  private final String TAG;
  private azy vMc;
  private FinderLongVideoPlayerSeekBar wfr;
  private final View wnX;
  private final View wnY;
  private final View wnZ;
  private final TextView woa;
  private final View wob;
  private final TextView woc;
  private Timer wod;
  private final ImageView woe;
  private final View wof;
  public final FinderVideoSeekBar wog;
  private boolean woh;
  private boolean woi;
  
  public FinderMediaBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168377);
    this.TAG = "Finder.FinderMediaBanner";
    paramContext = LayoutInflater.from(getContext()).inflate(2131494253, null);
    p.g(paramContext, "LayoutInflater.from(cont…d_banner_top_layer, null)");
    this.wnX = paramContext;
    paramContext = LayoutInflater.from(getContext()).inflate(2131494307, null);
    p.g(paramContext, "LayoutInflater.from(cont…eed_warn_container, null)");
    this.wnY = paramContext;
    this.woe = new ImageView(getContext());
    this.wof = new View(getContext());
    paramContext = getContext();
    p.g(paramContext, "context");
    this.wog = new FinderVideoSeekBar(paramContext);
    this.woh = true;
    addView(this.wnX, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext = this.wnX.findViewById(2131306959);
    p.g(paramContext, "topLayer.findViewById(R.id.reprint_layout)");
    this.wnZ = paramContext;
    setId(2131304549);
    paramContext = this.wnX.findViewById(2131306957);
    p.g(paramContext, "topLayer.findViewById(R.id.reprint_from_tv)");
    this.woa = ((TextView)paramContext);
    paramContext = this.wnX.findViewById(2131299492);
    p.g(paramContext, "topLayer.findViewById(R.id.deleted_tips_layout)");
    this.wob = paramContext;
    paramContext = this.wnX.findViewById(2131299493);
    p.g(paramContext, "topLayer.findViewById(R.id.deleted_tips_tv)");
    this.woc = ((TextView)paramContext);
    dGX();
    getPagerView().setOverScrollMode(0);
    getPagerView().setNestedScrollingEnabled(false);
    paramContext = getContext();
    p.g(paramContext, "context");
    int i = (int)paramContext.getResources().getDimension(2131165299);
    paramContext = getContext();
    p.g(paramContext, "context");
    paramContext = new FrameLayout.LayoutParams(i, (int)paramContext.getResources().getDimension(2131165299));
    paramAttributeSet = getContext();
    p.g(paramAttributeSet, "context");
    float f = paramAttributeSet.getResources().getDimension(2131165296);
    paramAttributeSet = getContext();
    p.g(paramAttributeSet, "context");
    i = (int)(f + paramAttributeSet.getResources().getDimension(2131165277));
    paramContext.rightMargin = i;
    paramContext.topMargin = i;
    paramContext.gravity = 53;
    this.woe.setVisibility(8);
    addView((View)this.woe, (ViewGroup.LayoutParams)paramContext);
    this.wog.setVisibility(8);
    addView((View)this.wog);
    paramContext = aa.jQ(getContext()).inflate(2131494259, null);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 80;
    getPagerViewContainer().addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    if (this.woh)
    {
      this.wof.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 10)));
      paramContext = getContainer();
      if (paramContext != null) {
        paramContext.addView(this.wof);
      }
      paramContext = getContainer();
      if (paramContext != null)
      {
        paramContext.addView(this.wnY, 1);
        AppMethodBeat.o(168377);
        return;
      }
      AppMethodBeat.o(168377);
      return;
    }
    paramContext = getContainer();
    if (paramContext != null)
    {
      paramContext.addView(this.wnY);
      AppMethodBeat.o(168377);
      return;
    }
    AppMethodBeat.o(168377);
  }
  
  public FinderMediaBanner(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(168378);
    this.TAG = "Finder.FinderMediaBanner";
    paramContext = LayoutInflater.from(getContext()).inflate(2131494253, null);
    p.g(paramContext, "LayoutInflater.from(cont…d_banner_top_layer, null)");
    this.wnX = paramContext;
    paramContext = LayoutInflater.from(getContext()).inflate(2131494307, null);
    p.g(paramContext, "LayoutInflater.from(cont…eed_warn_container, null)");
    this.wnY = paramContext;
    this.woe = new ImageView(getContext());
    this.wof = new View(getContext());
    paramContext = getContext();
    p.g(paramContext, "context");
    this.wog = new FinderVideoSeekBar(paramContext);
    this.woh = true;
    addView(this.wnX, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext = this.wnX.findViewById(2131306959);
    p.g(paramContext, "topLayer.findViewById(R.id.reprint_layout)");
    this.wnZ = paramContext;
    setId(2131304549);
    paramContext = this.wnX.findViewById(2131306957);
    p.g(paramContext, "topLayer.findViewById(R.id.reprint_from_tv)");
    this.woa = ((TextView)paramContext);
    paramContext = this.wnX.findViewById(2131299492);
    p.g(paramContext, "topLayer.findViewById(R.id.deleted_tips_layout)");
    this.wob = paramContext;
    paramContext = this.wnX.findViewById(2131299493);
    p.g(paramContext, "topLayer.findViewById(R.id.deleted_tips_tv)");
    this.woc = ((TextView)paramContext);
    dGX();
    getPagerView().setOverScrollMode(0);
    getPagerView().setNestedScrollingEnabled(false);
    paramContext = getContext();
    p.g(paramContext, "context");
    paramInt = (int)paramContext.getResources().getDimension(2131165299);
    paramContext = getContext();
    p.g(paramContext, "context");
    paramContext = new FrameLayout.LayoutParams(paramInt, (int)paramContext.getResources().getDimension(2131165299));
    paramAttributeSet = getContext();
    p.g(paramAttributeSet, "context");
    float f = paramAttributeSet.getResources().getDimension(2131165296);
    paramAttributeSet = getContext();
    p.g(paramAttributeSet, "context");
    paramInt = (int)(f + paramAttributeSet.getResources().getDimension(2131165277));
    paramContext.rightMargin = paramInt;
    paramContext.topMargin = paramInt;
    paramContext.gravity = 53;
    this.woe.setVisibility(8);
    addView((View)this.woe, (ViewGroup.LayoutParams)paramContext);
    this.wog.setVisibility(8);
    addView((View)this.wog);
    paramContext = aa.jQ(getContext()).inflate(2131494259, null);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 80;
    getPagerViewContainer().addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    if (this.woh)
    {
      this.wof.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 10)));
      paramContext = getContainer();
      if (paramContext != null) {
        paramContext.addView(this.wof);
      }
      paramContext = getContainer();
      if (paramContext != null)
      {
        paramContext.addView(this.wnY, 1);
        AppMethodBeat.o(168378);
        return;
      }
      AppMethodBeat.o(168378);
      return;
    }
    paramContext = getContainer();
    if (paramContext != null)
    {
      paramContext.addView(this.wnY);
      AppMethodBeat.o(168378);
      return;
    }
    AppMethodBeat.o(168378);
  }
  
  private void dGX()
  {
    AppMethodBeat.i(168374);
    Object localObject1 = this.wod;
    if (localObject1 != null) {
      ((Timer)localObject1).cancel();
    }
    Object localObject2 = this.TAG;
    localObject1 = new StringBuilder("refreshRefUI ");
    boolean bool;
    if (this.vMc == null)
    {
      bool = true;
      Object localObject3 = ((StringBuilder)localObject1).append(bool).append(' ');
      localObject1 = this.vMc;
      if (localObject1 == null) {
        break label190;
      }
      localObject1 = ((azy)localObject1).refObjectContact;
      label70:
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(' ');
      localObject3 = this.vMc;
      if ((localObject3 == null) || (((azy)localObject3).refObjectFlag != 0L)) {
        break label195;
      }
      bool = true;
      label105:
      Log.i((String)localObject2, bool);
      if (this.vMc != null)
      {
        localObject1 = this.vMc;
        if (localObject1 == null) {
          break label200;
        }
      }
    }
    label190:
    label195:
    label200:
    for (localObject1 = ((azy)localObject1).refObjectContact;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = this.vMc;
        if ((localObject1 == null) || (((azy)localObject1).refObjectFlag != 0L)) {
          break label205;
        }
      }
      this.wnZ.setVisibility(8);
      this.wob.setVisibility(8);
      AppMethodBeat.o(168374);
      return;
      bool = false;
      break;
      localObject1 = null;
      break label70;
      bool = false;
      break label105;
    }
    label205:
    this.wnZ.setVisibility(0);
    localObject2 = getContext();
    localObject1 = this.vMc;
    if (localObject1 == null) {
      p.hyc();
    }
    localObject1 = ((azy)localObject1).refObjectContact;
    if (localObject1 != null)
    {
      localObject1 = ((FinderContact)localObject1).nickname;
      if (localObject1 == null) {}
    }
    for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
    {
      localObject1 = com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject2, (CharSequence)localObject1);
      localObject2 = getContext().getString(2131760516, new Object[] { localObject1 });
      p.g(localObject2, "context.getString(R.stri…r_reprint_from, fromName)");
      this.woa.setText((CharSequence)localObject2);
      this.woa.setVisibility(0);
      localObject2 = new Timer();
      ((Timer)localObject2).schedule((TimerTask)new b(this), 3000L);
      this.wod = ((Timer)localObject2);
      localObject2 = this.vMc;
      if (localObject2 == null) {
        p.hyc();
      }
      if (((azy)localObject2).refObjectFlag != 2L) {
        break;
      }
      this.wob.setVisibility(0);
      this.wnZ.setVisibility(8);
      this.woc.setText((CharSequence)localObject1);
      this.wob.setOnClickListener((View.OnClickListener)new c(this));
      AppMethodBeat.o(168374);
      return;
    }
    this.wob.setVisibility(8);
    this.wnZ.setOnClickListener((View.OnClickListener)new d(this));
    AppMethodBeat.o(168374);
  }
  
  public final boolean a(int paramInt, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(254888);
    p.h(paramViewGroup, "parent");
    paramViewGroup = c.vCb;
    if (((Number)c.dsw().value()).intValue() == 1)
    {
      AppMethodBeat.o(254888);
      return false;
    }
    if (!getManager().canScrollHorizontally())
    {
      AppMethodBeat.o(254888);
      return false;
    }
    if (getManager().getItemCount() <= 1)
    {
      paramViewGroup = c.vCb;
      if (((Number)c.dsw().value()).intValue() != 1)
      {
        AppMethodBeat.o(254888);
        return true;
      }
      AppMethodBeat.o(254888);
      return false;
    }
    if ((paramInt > 0) && (getManager().kv() == getManager().getItemCount() - 1))
    {
      paramViewGroup = c.vCb;
      if (((Number)c.dsw().value()).intValue() != 1)
      {
        AppMethodBeat.o(254888);
        return true;
      }
      AppMethodBeat.o(254888);
      return false;
    }
    if ((paramInt < 0) && (getManager().ks() == 0) && (getManager().kt() == 0))
    {
      paramViewGroup = c.vCb;
      if (((Number)c.dsw().value()).intValue() != 1)
      {
        AppMethodBeat.o(254888);
        return true;
      }
      AppMethodBeat.o(254888);
      return false;
    }
    AppMethodBeat.o(254888);
    return true;
  }
  
  public final void dGY()
  {
    AppMethodBeat.i(254889);
    super.dGY();
    setKeepScreenOn(true);
    AppMethodBeat.o(254889);
  }
  
  public final void dGZ()
  {
    AppMethodBeat.i(254890);
    super.dGZ();
    setKeepScreenOn(false);
    AppMethodBeat.o(254890);
  }
  
  public final LinearLayoutManager fF(Context paramContext)
  {
    AppMethodBeat.i(254887);
    p.h(paramContext, "context");
    paramContext = new FinderLinearLayoutManager(paramContext);
    paramContext.wsx = 50.0F;
    paramContext = (LinearLayoutManager)paramContext;
    AppMethodBeat.o(254887);
    return paramContext;
  }
  
  public final FinderLongVideoPlayerSeekBar getLongVideoSeekBar()
  {
    return this.wfr;
  }
  
  public final azy getRefFeedInfo()
  {
    return this.vMc;
  }
  
  public final View getSpaceView()
  {
    return this.wof;
  }
  
  public final ImageView getTypeIconIv()
  {
    return this.woe;
  }
  
  public final void setFrozenRecyclerView(final boolean paramBoolean)
  {
    AppMethodBeat.i(254886);
    this.woi = paramBoolean;
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[SET] isPassTouchEvent=").append(paramBoolean).append(" isInLayout=");
    Object localObject = getParentRecyclerView();
    if (localObject != null) {}
    for (localObject = Boolean.valueOf(((RecyclerView)localObject).isInLayout());; localObject = null)
    {
      Log.i(str, localObject);
      localObject = getParentRecyclerView();
      if ((localObject == null) || (((RecyclerView)localObject).isInLayout() != true)) {
        break label130;
      }
      localObject = getParentRecyclerView();
      if (localObject == null) {
        break;
      }
      ((RecyclerView)localObject).post((Runnable)new a(this, paramBoolean));
      AppMethodBeat.o(254886);
      return;
    }
    AppMethodBeat.o(254886);
    return;
    label130:
    localObject = getParentRecyclerView();
    if (localObject != null)
    {
      ((RecyclerView)localObject).setLayoutFrozen(paramBoolean);
      AppMethodBeat.o(254886);
      return;
    }
    AppMethodBeat.o(254886);
  }
  
  public final void setLongVideoSeekBar(FinderLongVideoPlayerSeekBar paramFinderLongVideoPlayerSeekBar)
  {
    this.wfr = paramFinderLongVideoPlayerSeekBar;
  }
  
  public final void setNeedSpaceView(boolean paramBoolean)
  {
    AppMethodBeat.i(254885);
    this.woh = paramBoolean;
    if (!paramBoolean)
    {
      LinearLayout localLinearLayout = getContainer();
      if (localLinearLayout != null)
      {
        localLinearLayout.removeView(this.wof);
        AppMethodBeat.o(254885);
        return;
      }
    }
    AppMethodBeat.o(254885);
  }
  
  public final void setRefFeedInfo(azy paramazy)
  {
    AppMethodBeat.i(168373);
    this.vMc = paramazy;
    dGX();
    AppMethodBeat.o(168373);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(FinderMediaBanner paramFinderMediaBanner, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(254884);
      RecyclerView localRecyclerView = this.woj.getParentRecyclerView();
      if (localRecyclerView != null)
      {
        localRecyclerView.setLayoutFrozen(paramBoolean);
        AppMethodBeat.o(254884);
        return;
      }
      AppMethodBeat.o(254884);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$1$1", "Ljava/util/TimerTask;", "run", "", "plugin-finder_release"})
  public static final class b
    extends TimerTask
  {
    b(FinderMediaBanner paramFinderMediaBanner) {}
    
    public final void run()
    {
      AppMethodBeat.i(168370);
      this.woj.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(168369);
          FinderMediaBanner.a(this.wol.woj).setVisibility(8);
          AppMethodBeat.o(168369);
        }
      });
      AppMethodBeat.o(168370);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderMediaBanner paramFinderMediaBanner) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168371);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      Intent localIntent = new Intent();
      paramView = this.woj.getRefFeedInfo();
      if (paramView == null) {
        p.hyc();
      }
      paramView = paramView.refObjectContact;
      if (paramView != null)
      {
        localObject = paramView.username;
        paramView = (View)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramView = "";
      }
      localObject = paramView;
      if (paramView == null) {
        localObject = "";
      }
      localIntent.putExtra("finder_username", (String)localObject);
      paramView = FinderReporterUIC.wzC;
      paramView = this.woj.getContext();
      p.g(paramView, "context");
      FinderReporterUIC.a.a(paramView, localIntent, 0L, 0, false, 124);
      paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
      paramView = this.woj.getContext();
      p.g(paramView, "context");
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramView, localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168371);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderMediaBanner paramFinderMediaBanner) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168372);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      Intent localIntent = new Intent();
      paramView = this.woj.getRefFeedInfo();
      if (paramView == null) {
        p.hyc();
      }
      localIntent.putExtra("KEY_REF_OBJ_ID", paramView.refObjectId);
      paramView = this.woj.getRefFeedInfo();
      if (paramView == null) {
        p.hyc();
      }
      localIntent.putExtra("KEY_REF_OBJ_NONCE_ID", paramView.refObjectNonceId);
      paramView = this.woj.getRefFeedInfo();
      if (paramView == null) {
        p.hyc();
      }
      paramView = paramView.refObjectContact;
      if (paramView != null)
      {
        localObject = paramView.username;
        paramView = (View)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramView = "";
      }
      localObject = paramView;
      if (paramView == null) {
        localObject = "";
      }
      localIntent.putExtra("KEY_TARGET_USERNAME", (String)localObject);
      paramView = this.woj.getRefFeedInfo();
      if (paramView == null) {
        p.hyc();
      }
      paramView = paramView.refObjectContact;
      if (paramView != null)
      {
        localObject = paramView.nickname;
        paramView = (View)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramView = "";
      }
      localObject = paramView;
      if (paramView == null) {
        localObject = "";
      }
      localIntent.putExtra("KEY_TARGET_NICKNAME", (String)localObject);
      paramView = com.tencent.mm.plugin.finder.utils.a.vUU;
      paramView = this.woj.getContext();
      p.g(paramView, "context");
      com.tencent.mm.plugin.finder.utils.a.H(paramView, localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168372);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderMediaBanner
 * JD-Core Version:    0.7.0.1
 */