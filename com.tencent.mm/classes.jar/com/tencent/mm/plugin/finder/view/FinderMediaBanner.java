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
import com.tencent.mm.plugin.finder.video.FinderVideoSeekBar;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.amq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.z;
import com.tencent.mm.view.MediaBanner;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import d.l;
import java.util.Timer;
import java.util.TimerTask;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "Lcom/tencent/mm/view/MediaBanner;", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "hideTextTimer", "Ljava/util/Timer;", "value", "", "isFrozenRecyclerView", "()Z", "setFrozenRecyclerView", "(Z)V", "refDeleteTip", "Landroid/widget/TextView;", "refDeleteTipLayout", "Landroid/view/View;", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "refFeedInfo", "getRefFeedInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeedInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "refFromTv", "refLayout", "topLayer", "typeIconIv", "Landroid/widget/ImageView;", "getTypeIconIv", "()Landroid/widget/ImageView;", "warnContainer", "canScrollHorizontally", "direction", "parent", "Landroid/view/ViewGroup;", "x", "", "y", "refreshRefUI", "", "plugin-finder_release"})
public final class FinderMediaBanner
  extends MediaBanner<com.tencent.mm.ui.base.a.b>
  implements FinderViewPager.a
{
  private final String TAG;
  private amq rJa;
  private final View rXY;
  private final View rXZ;
  private final View rYa;
  private final TextView rYb;
  private final View rYc;
  private final TextView rYd;
  private Timer rYe;
  private final ImageView rYf;
  private boolean rYg;
  
  public FinderMediaBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168377);
    this.TAG = "Finder.FinderMediaBanner";
    paramContext = LayoutInflater.from(getContext()).inflate(2131494034, null);
    d.g.b.k.g(paramContext, "LayoutInflater.from(cont…d_banner_top_layer, null)");
    this.rXY = paramContext;
    paramContext = LayoutInflater.from(getContext()).inflate(2131496194, null);
    d.g.b.k.g(paramContext, "LayoutInflater.from(cont…eed_warn_container, null)");
    this.rXZ = paramContext;
    this.rYf = new ImageView(getContext());
    addView(this.rXY, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext = this.rXY.findViewById(2131304093);
    d.g.b.k.g(paramContext, "topLayer.findViewById(R.id.reprint_layout)");
    this.rYa = paramContext;
    setId(2131302203);
    paramContext = this.rXY.findViewById(2131304091);
    d.g.b.k.g(paramContext, "topLayer.findViewById(R.id.reprint_from_tv)");
    this.rYb = ((TextView)paramContext);
    paramContext = this.rXY.findViewById(2131298993);
    d.g.b.k.g(paramContext, "topLayer.findViewById(R.id.deleted_tips_layout)");
    this.rYc = paramContext;
    paramContext = this.rXY.findViewById(2131298994);
    d.g.b.k.g(paramContext, "topLayer.findViewById(R.id.deleted_tips_tv)");
    this.rYd = ((TextView)paramContext);
    cFb();
    getPagerView().setOverScrollMode(0);
    getPagerView().setNestedScrollingEnabled(false);
    paramContext = getContext();
    d.g.b.k.g(paramContext, "context");
    int i = (int)paramContext.getResources().getDimension(2131165292);
    paramContext = getContext();
    d.g.b.k.g(paramContext, "context");
    paramContext = new FrameLayout.LayoutParams(i, (int)paramContext.getResources().getDimension(2131165292));
    paramAttributeSet = getContext();
    d.g.b.k.g(paramAttributeSet, "context");
    float f = paramAttributeSet.getResources().getDimension(2131165289);
    paramAttributeSet = getContext();
    d.g.b.k.g(paramAttributeSet, "context");
    i = (int)(f + paramAttributeSet.getResources().getDimension(2131165274));
    paramContext.rightMargin = i;
    paramContext.topMargin = i;
    paramContext.gravity = 53;
    this.rYf.setVisibility(8);
    addView((View)this.rYf, (ViewGroup.LayoutParams)paramContext);
    paramContext = getContext();
    d.g.b.k.g(paramContext, "context");
    paramContext = new FinderVideoSeekBar(paramContext);
    paramContext.setVisibility(8);
    addView((View)paramContext);
    paramContext = z.jD(getContext()).inflate(2131496186, null);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 80;
    getPagerViewContainer().addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    paramContext = new View(getContext());
    paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(0, com.tencent.mm.cc.a.fromDPToPix(getContext(), 10)));
    paramAttributeSet = getContainer();
    if (paramAttributeSet != null) {
      paramAttributeSet.addView(paramContext);
    }
    paramContext = getContainer();
    if (paramContext != null)
    {
      paramContext.addView(this.rXZ, 1);
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
    paramContext = LayoutInflater.from(getContext()).inflate(2131494034, null);
    d.g.b.k.g(paramContext, "LayoutInflater.from(cont…d_banner_top_layer, null)");
    this.rXY = paramContext;
    paramContext = LayoutInflater.from(getContext()).inflate(2131496194, null);
    d.g.b.k.g(paramContext, "LayoutInflater.from(cont…eed_warn_container, null)");
    this.rXZ = paramContext;
    this.rYf = new ImageView(getContext());
    addView(this.rXY, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext = this.rXY.findViewById(2131304093);
    d.g.b.k.g(paramContext, "topLayer.findViewById(R.id.reprint_layout)");
    this.rYa = paramContext;
    setId(2131302203);
    paramContext = this.rXY.findViewById(2131304091);
    d.g.b.k.g(paramContext, "topLayer.findViewById(R.id.reprint_from_tv)");
    this.rYb = ((TextView)paramContext);
    paramContext = this.rXY.findViewById(2131298993);
    d.g.b.k.g(paramContext, "topLayer.findViewById(R.id.deleted_tips_layout)");
    this.rYc = paramContext;
    paramContext = this.rXY.findViewById(2131298994);
    d.g.b.k.g(paramContext, "topLayer.findViewById(R.id.deleted_tips_tv)");
    this.rYd = ((TextView)paramContext);
    cFb();
    getPagerView().setOverScrollMode(0);
    getPagerView().setNestedScrollingEnabled(false);
    paramContext = getContext();
    d.g.b.k.g(paramContext, "context");
    paramInt = (int)paramContext.getResources().getDimension(2131165292);
    paramContext = getContext();
    d.g.b.k.g(paramContext, "context");
    paramContext = new FrameLayout.LayoutParams(paramInt, (int)paramContext.getResources().getDimension(2131165292));
    paramAttributeSet = getContext();
    d.g.b.k.g(paramAttributeSet, "context");
    float f = paramAttributeSet.getResources().getDimension(2131165289);
    paramAttributeSet = getContext();
    d.g.b.k.g(paramAttributeSet, "context");
    paramInt = (int)(f + paramAttributeSet.getResources().getDimension(2131165274));
    paramContext.rightMargin = paramInt;
    paramContext.topMargin = paramInt;
    paramContext.gravity = 53;
    this.rYf.setVisibility(8);
    addView((View)this.rYf, (ViewGroup.LayoutParams)paramContext);
    paramContext = getContext();
    d.g.b.k.g(paramContext, "context");
    paramContext = new FinderVideoSeekBar(paramContext);
    paramContext.setVisibility(8);
    addView((View)paramContext);
    paramContext = z.jD(getContext()).inflate(2131496186, null);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 80;
    getPagerViewContainer().addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    paramContext = new View(getContext());
    paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(0, com.tencent.mm.cc.a.fromDPToPix(getContext(), 10)));
    paramAttributeSet = getContainer();
    if (paramAttributeSet != null) {
      paramAttributeSet.addView(paramContext);
    }
    paramContext = getContainer();
    if (paramContext != null)
    {
      paramContext.addView(this.rXZ, 1);
      AppMethodBeat.o(168378);
      return;
    }
    AppMethodBeat.o(168378);
  }
  
  private void cFb()
  {
    AppMethodBeat.i(168374);
    Object localObject1 = this.rYe;
    if (localObject1 != null) {
      ((Timer)localObject1).cancel();
    }
    Object localObject2 = this.TAG;
    localObject1 = new StringBuilder("refreshRefUI ");
    boolean bool;
    if (this.rJa == null)
    {
      bool = true;
      Object localObject3 = ((StringBuilder)localObject1).append(bool).append(' ');
      localObject1 = this.rJa;
      if (localObject1 == null) {
        break label190;
      }
      localObject1 = ((amq)localObject1).refObjectContact;
      label70:
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(' ');
      localObject3 = this.rJa;
      if ((localObject3 == null) || (((amq)localObject3).refObjectFlag != 0L)) {
        break label195;
      }
      bool = true;
      label105:
      ac.i((String)localObject2, bool);
      if (this.rJa != null)
      {
        localObject1 = this.rJa;
        if (localObject1 == null) {
          break label200;
        }
      }
    }
    label190:
    label195:
    label200:
    for (localObject1 = ((amq)localObject1).refObjectContact;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = this.rJa;
        if ((localObject1 == null) || (((amq)localObject1).refObjectFlag != 0L)) {
          break label205;
        }
      }
      this.rYa.setVisibility(8);
      this.rYc.setVisibility(8);
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
    this.rYa.setVisibility(0);
    localObject1 = getContext();
    localObject2 = this.rJa;
    if (localObject2 == null) {
      d.g.b.k.fOy();
    }
    localObject1 = com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject1, (CharSequence)((amq)localObject2).refObjectContact.nickname);
    localObject2 = getContext().getString(2131759329, new Object[] { localObject1 });
    this.rYb.setText((CharSequence)localObject2);
    this.rYb.setVisibility(0);
    localObject2 = new Timer();
    ((Timer)localObject2).schedule((TimerTask)new a(this), 3000L);
    this.rYe = ((Timer)localObject2);
    localObject2 = this.rJa;
    if (localObject2 == null) {
      d.g.b.k.fOy();
    }
    if (((amq)localObject2).refObjectFlag == 2L)
    {
      this.rYc.setVisibility(0);
      this.rYa.setVisibility(8);
      this.rYd.setText((CharSequence)localObject1);
      this.rYc.setOnClickListener((View.OnClickListener)new b(this));
      AppMethodBeat.o(168374);
      return;
    }
    this.rYc.setVisibility(8);
    this.rYa.setOnClickListener((View.OnClickListener)new c(this));
    AppMethodBeat.o(168374);
  }
  
  public final boolean a(int paramInt, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(204186);
    d.g.b.k.h(paramViewGroup, "parent");
    if (!getManager().jM())
    {
      AppMethodBeat.o(204186);
      return false;
    }
    if (getManager().getItemCount() <= 1)
    {
      paramViewGroup = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (!com.tencent.mm.plugin.finder.storage.b.czR())
      {
        AppMethodBeat.o(204186);
        return true;
      }
      AppMethodBeat.o(204186);
      return false;
    }
    if ((paramInt > 0) && (getManager().jZ() == getManager().getItemCount() - 1))
    {
      paramViewGroup = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (!com.tencent.mm.plugin.finder.storage.b.czR())
      {
        AppMethodBeat.o(204186);
        return true;
      }
      AppMethodBeat.o(204186);
      return false;
    }
    if ((paramInt < 0) && (getManager().jW() == 0) && (getManager().jX() == 0))
    {
      paramViewGroup = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (!com.tencent.mm.plugin.finder.storage.b.czR())
      {
        AppMethodBeat.o(204186);
        return true;
      }
      AppMethodBeat.o(204186);
      return false;
    }
    AppMethodBeat.o(204186);
    return true;
  }
  
  public final amq getRefFeedInfo()
  {
    return this.rJa;
  }
  
  public final ImageView getTypeIconIv()
  {
    return this.rYf;
  }
  
  public final void setFrozenRecyclerView(boolean paramBoolean)
  {
    AppMethodBeat.i(204185);
    this.rYg = paramBoolean;
    ac.i(this.TAG, "[SET] isPassTouchEvent=".concat(String.valueOf(paramBoolean)));
    RecyclerView localRecyclerView = getParentRecyclerView();
    if (localRecyclerView != null)
    {
      localRecyclerView.setLayoutFrozen(paramBoolean);
      AppMethodBeat.o(204185);
      return;
    }
    AppMethodBeat.o(204185);
  }
  
  public final void setRefFeedInfo(amq paramamq)
  {
    AppMethodBeat.i(168373);
    this.rJa = paramamq;
    cFb();
    AppMethodBeat.o(168373);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$1$1", "Ljava/util/TimerTask;", "run", "", "plugin-finder_release"})
  public static final class a
    extends TimerTask
  {
    a(FinderMediaBanner paramFinderMediaBanner) {}
    
    public final void run()
    {
      AppMethodBeat.i(168370);
      this.rYh.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(168369);
          FinderMediaBanner.a(this.rYi.rYh).setVisibility(8);
          AppMethodBeat.o(168369);
        }
      });
      AppMethodBeat.o(168370);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderMediaBanner paramFinderMediaBanner) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168371);
      Intent localIntent = new Intent();
      paramView = this.rYh.getRefFeedInfo();
      if (paramView == null) {
        d.g.b.k.fOy();
      }
      String str = paramView.refObjectContact.username;
      paramView = str;
      if (str == null) {
        paramView = "";
      }
      localIntent.putExtra("finder_username", paramView);
      paramView = FinderReporterUIC.seQ;
      paramView = this.rYh.getContext();
      d.g.b.k.g(paramView, "context");
      FinderReporterUIC.a.a(paramView, localIntent, 0L, 0, false, 124);
      paramView = com.tencent.mm.plugin.finder.utils.a.rOv;
      paramView = this.rYh.getContext();
      d.g.b.k.g(paramView, "context");
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramView, localIntent);
      AppMethodBeat.o(168371);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderMediaBanner paramFinderMediaBanner) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168372);
      Intent localIntent = new Intent();
      paramView = this.rYh.getRefFeedInfo();
      if (paramView == null) {
        d.g.b.k.fOy();
      }
      localIntent.putExtra("KEY_REF_OBJ_ID", paramView.refObjectId);
      paramView = this.rYh.getRefFeedInfo();
      if (paramView == null) {
        d.g.b.k.fOy();
      }
      localIntent.putExtra("KEY_REF_OBJ_NONCE_ID", paramView.refObjectNonceId);
      paramView = this.rYh.getRefFeedInfo();
      if (paramView == null) {
        d.g.b.k.fOy();
      }
      String str = paramView.refObjectContact.username;
      paramView = str;
      if (str == null) {
        paramView = "";
      }
      localIntent.putExtra("KEY_TARGET_USERNAME", paramView);
      paramView = this.rYh.getRefFeedInfo();
      if (paramView == null) {
        d.g.b.k.fOy();
      }
      str = paramView.refObjectContact.nickname;
      paramView = str;
      if (str == null) {
        paramView = "";
      }
      localIntent.putExtra("KEY_TARGET_NICKNAME", paramView);
      paramView = com.tencent.mm.plugin.finder.utils.a.rOv;
      paramView = this.rYh.getContext();
      d.g.b.k.g(paramView, "context");
      com.tencent.mm.plugin.finder.utils.a.D(paramView, localIntent);
      AppMethodBeat.o(168372);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderMediaBanner
 * JD-Core Version:    0.7.0.1
 */