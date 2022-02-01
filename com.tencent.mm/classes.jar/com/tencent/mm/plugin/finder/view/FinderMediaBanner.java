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
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.aqb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.z;
import com.tencent.mm.view.MediaBanner;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import d.g.b.p;
import d.l;
import java.util.Timer;
import java.util.TimerTask;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "Lcom/tencent/mm/view/MediaBanner;", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "hideTextTimer", "Ljava/util/Timer;", "value", "", "isFrozenRecyclerView", "()Z", "setFrozenRecyclerView", "(Z)V", "refDeleteTip", "Landroid/widget/TextView;", "refDeleteTipLayout", "Landroid/view/View;", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "refFeedInfo", "getRefFeedInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeedInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "refFromTv", "refLayout", "spaceView", "getSpaceView", "()Landroid/view/View;", "topLayer", "typeIconIv", "Landroid/widget/ImageView;", "getTypeIconIv", "()Landroid/widget/ImageView;", "warnContainer", "canScrollHorizontally", "direction", "parent", "Landroid/view/ViewGroup;", "x", "", "y", "refreshRefUI", "", "plugin-finder_release"})
public final class FinderMediaBanner
  extends MediaBanner<com.tencent.mm.ui.base.a.b>
  implements FinderViewPager.a
{
  private final String TAG;
  private aqb sDY;
  private final View sUS;
  private final View sUT;
  private final View sUU;
  private final TextView sUV;
  private final View sUW;
  private final TextView sUX;
  private Timer sUY;
  private final ImageView sUZ;
  private final View sVa;
  private boolean sVb;
  
  public FinderMediaBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168377);
    this.TAG = "Finder.FinderMediaBanner";
    paramContext = LayoutInflater.from(getContext()).inflate(2131494034, null);
    p.g(paramContext, "LayoutInflater.from(cont…d_banner_top_layer, null)");
    this.sUS = paramContext;
    paramContext = LayoutInflater.from(getContext()).inflate(2131496194, null);
    p.g(paramContext, "LayoutInflater.from(cont…eed_warn_container, null)");
    this.sUT = paramContext;
    this.sUZ = new ImageView(getContext());
    this.sVa = new View(getContext());
    addView(this.sUS, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext = this.sUS.findViewById(2131304093);
    p.g(paramContext, "topLayer.findViewById(R.id.reprint_layout)");
    this.sUU = paramContext;
    setId(2131302203);
    paramContext = this.sUS.findViewById(2131304091);
    p.g(paramContext, "topLayer.findViewById(R.id.reprint_from_tv)");
    this.sUV = ((TextView)paramContext);
    paramContext = this.sUS.findViewById(2131298993);
    p.g(paramContext, "topLayer.findViewById(R.id.deleted_tips_layout)");
    this.sUW = paramContext;
    paramContext = this.sUS.findViewById(2131298994);
    p.g(paramContext, "topLayer.findViewById(R.id.deleted_tips_tv)");
    this.sUX = ((TextView)paramContext);
    cNv();
    getPagerView().setOverScrollMode(0);
    getPagerView().setNestedScrollingEnabled(false);
    paramContext = getContext();
    p.g(paramContext, "context");
    int i = (int)paramContext.getResources().getDimension(2131165292);
    paramContext = getContext();
    p.g(paramContext, "context");
    paramContext = new FrameLayout.LayoutParams(i, (int)paramContext.getResources().getDimension(2131165292));
    paramAttributeSet = getContext();
    p.g(paramAttributeSet, "context");
    float f = paramAttributeSet.getResources().getDimension(2131165289);
    paramAttributeSet = getContext();
    p.g(paramAttributeSet, "context");
    i = (int)(f + paramAttributeSet.getResources().getDimension(2131165274));
    paramContext.rightMargin = i;
    paramContext.topMargin = i;
    paramContext.gravity = 53;
    this.sUZ.setVisibility(8);
    addView((View)this.sUZ, (ViewGroup.LayoutParams)paramContext);
    paramContext = getContext();
    p.g(paramContext, "context");
    paramContext = new FinderVideoSeekBar(paramContext);
    paramContext.setVisibility(8);
    addView((View)paramContext);
    paramContext = z.jO(getContext()).inflate(2131496186, null);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 80;
    getPagerViewContainer().addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    this.sVa.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(0, com.tencent.mm.cc.a.fromDPToPix(getContext(), 10)));
    paramContext = getContainer();
    if (paramContext != null) {
      paramContext.addView(this.sVa);
    }
    paramContext = getContainer();
    if (paramContext != null)
    {
      paramContext.addView(this.sUT, 1);
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
    p.g(paramContext, "LayoutInflater.from(cont…d_banner_top_layer, null)");
    this.sUS = paramContext;
    paramContext = LayoutInflater.from(getContext()).inflate(2131496194, null);
    p.g(paramContext, "LayoutInflater.from(cont…eed_warn_container, null)");
    this.sUT = paramContext;
    this.sUZ = new ImageView(getContext());
    this.sVa = new View(getContext());
    addView(this.sUS, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext = this.sUS.findViewById(2131304093);
    p.g(paramContext, "topLayer.findViewById(R.id.reprint_layout)");
    this.sUU = paramContext;
    setId(2131302203);
    paramContext = this.sUS.findViewById(2131304091);
    p.g(paramContext, "topLayer.findViewById(R.id.reprint_from_tv)");
    this.sUV = ((TextView)paramContext);
    paramContext = this.sUS.findViewById(2131298993);
    p.g(paramContext, "topLayer.findViewById(R.id.deleted_tips_layout)");
    this.sUW = paramContext;
    paramContext = this.sUS.findViewById(2131298994);
    p.g(paramContext, "topLayer.findViewById(R.id.deleted_tips_tv)");
    this.sUX = ((TextView)paramContext);
    cNv();
    getPagerView().setOverScrollMode(0);
    getPagerView().setNestedScrollingEnabled(false);
    paramContext = getContext();
    p.g(paramContext, "context");
    paramInt = (int)paramContext.getResources().getDimension(2131165292);
    paramContext = getContext();
    p.g(paramContext, "context");
    paramContext = new FrameLayout.LayoutParams(paramInt, (int)paramContext.getResources().getDimension(2131165292));
    paramAttributeSet = getContext();
    p.g(paramAttributeSet, "context");
    float f = paramAttributeSet.getResources().getDimension(2131165289);
    paramAttributeSet = getContext();
    p.g(paramAttributeSet, "context");
    paramInt = (int)(f + paramAttributeSet.getResources().getDimension(2131165274));
    paramContext.rightMargin = paramInt;
    paramContext.topMargin = paramInt;
    paramContext.gravity = 53;
    this.sUZ.setVisibility(8);
    addView((View)this.sUZ, (ViewGroup.LayoutParams)paramContext);
    paramContext = getContext();
    p.g(paramContext, "context");
    paramContext = new FinderVideoSeekBar(paramContext);
    paramContext.setVisibility(8);
    addView((View)paramContext);
    paramContext = z.jO(getContext()).inflate(2131496186, null);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 80;
    getPagerViewContainer().addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    this.sVa.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(0, com.tencent.mm.cc.a.fromDPToPix(getContext(), 10)));
    paramContext = getContainer();
    if (paramContext != null) {
      paramContext.addView(this.sVa);
    }
    paramContext = getContainer();
    if (paramContext != null)
    {
      paramContext.addView(this.sUT, 1);
      AppMethodBeat.o(168378);
      return;
    }
    AppMethodBeat.o(168378);
  }
  
  private void cNv()
  {
    AppMethodBeat.i(168374);
    Object localObject1 = this.sUY;
    if (localObject1 != null) {
      ((Timer)localObject1).cancel();
    }
    Object localObject2 = this.TAG;
    localObject1 = new StringBuilder("refreshRefUI ");
    boolean bool;
    if (this.sDY == null)
    {
      bool = true;
      Object localObject3 = ((StringBuilder)localObject1).append(bool).append(' ');
      localObject1 = this.sDY;
      if (localObject1 == null) {
        break label190;
      }
      localObject1 = ((aqb)localObject1).refObjectContact;
      label70:
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(' ');
      localObject3 = this.sDY;
      if ((localObject3 == null) || (((aqb)localObject3).refObjectFlag != 0L)) {
        break label195;
      }
      bool = true;
      label105:
      ad.i((String)localObject2, bool);
      if (this.sDY != null)
      {
        localObject1 = this.sDY;
        if (localObject1 == null) {
          break label200;
        }
      }
    }
    label190:
    label195:
    label200:
    for (localObject1 = ((aqb)localObject1).refObjectContact;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = this.sDY;
        if ((localObject1 == null) || (((aqb)localObject1).refObjectFlag != 0L)) {
          break label205;
        }
      }
      this.sUU.setVisibility(8);
      this.sUW.setVisibility(8);
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
    this.sUU.setVisibility(0);
    localObject1 = getContext();
    localObject2 = this.sDY;
    if (localObject2 == null) {
      p.gfZ();
    }
    localObject1 = k.c((Context)localObject1, (CharSequence)((aqb)localObject2).refObjectContact.nickname);
    localObject2 = getContext().getString(2131759329, new Object[] { localObject1 });
    this.sUV.setText((CharSequence)localObject2);
    this.sUV.setVisibility(0);
    localObject2 = new Timer();
    ((Timer)localObject2).schedule((TimerTask)new a(this), 3000L);
    this.sUY = ((Timer)localObject2);
    localObject2 = this.sDY;
    if (localObject2 == null) {
      p.gfZ();
    }
    if (((aqb)localObject2).refObjectFlag == 2L)
    {
      this.sUW.setVisibility(0);
      this.sUU.setVisibility(8);
      this.sUX.setText((CharSequence)localObject1);
      this.sUW.setOnClickListener((View.OnClickListener)new b(this));
      AppMethodBeat.o(168374);
      return;
    }
    this.sUW.setVisibility(8);
    this.sUU.setOnClickListener((View.OnClickListener)new c(this));
    AppMethodBeat.o(168374);
  }
  
  public final boolean a(int paramInt, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(205164);
    p.h(paramViewGroup, "parent");
    if (!getManager().kc())
    {
      AppMethodBeat.o(205164);
      return false;
    }
    if (getManager().getItemCount() <= 1)
    {
      paramViewGroup = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cGR().value()).intValue() != 1)
      {
        AppMethodBeat.o(205164);
        return true;
      }
      AppMethodBeat.o(205164);
      return false;
    }
    if ((paramInt > 0) && (getManager().kp() == getManager().getItemCount() - 1))
    {
      paramViewGroup = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cGR().value()).intValue() != 1)
      {
        AppMethodBeat.o(205164);
        return true;
      }
      AppMethodBeat.o(205164);
      return false;
    }
    if ((paramInt < 0) && (getManager().km() == 0) && (getManager().kn() == 0))
    {
      paramViewGroup = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cGR().value()).intValue() != 1)
      {
        AppMethodBeat.o(205164);
        return true;
      }
      AppMethodBeat.o(205164);
      return false;
    }
    AppMethodBeat.o(205164);
    return true;
  }
  
  public final aqb getRefFeedInfo()
  {
    return this.sDY;
  }
  
  public final View getSpaceView()
  {
    return this.sVa;
  }
  
  public final ImageView getTypeIconIv()
  {
    return this.sUZ;
  }
  
  public final void setFrozenRecyclerView(boolean paramBoolean)
  {
    AppMethodBeat.i(205163);
    this.sVb = paramBoolean;
    ad.i(this.TAG, "[SET] isPassTouchEvent=".concat(String.valueOf(paramBoolean)));
    RecyclerView localRecyclerView = getParentRecyclerView();
    if (localRecyclerView != null)
    {
      localRecyclerView.setLayoutFrozen(paramBoolean);
      AppMethodBeat.o(205163);
      return;
    }
    AppMethodBeat.o(205163);
  }
  
  public final void setRefFeedInfo(aqb paramaqb)
  {
    AppMethodBeat.i(168373);
    this.sDY = paramaqb;
    cNv();
    AppMethodBeat.o(168373);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$1$1", "Ljava/util/TimerTask;", "run", "", "plugin-finder_release"})
  public static final class a
    extends TimerTask
  {
    a(FinderMediaBanner paramFinderMediaBanner) {}
    
    public final void run()
    {
      AppMethodBeat.i(168370);
      this.sVc.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(168369);
          FinderMediaBanner.a(this.sVd.sVc).setVisibility(8);
          AppMethodBeat.o(168369);
        }
      });
      AppMethodBeat.o(168370);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderMediaBanner paramFinderMediaBanner) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168371);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      Intent localIntent = new Intent();
      paramView = this.sVc.getRefFeedInfo();
      if (paramView == null) {
        p.gfZ();
      }
      localObject = paramView.refObjectContact.username;
      paramView = (View)localObject;
      if (localObject == null) {
        paramView = "";
      }
      localIntent.putExtra("finder_username", paramView);
      paramView = FinderReporterUIC.tcM;
      paramView = this.sVc.getContext();
      p.g(paramView, "context");
      FinderReporterUIC.a.a(paramView, localIntent, 0L, 0, false, 124);
      paramView = com.tencent.mm.plugin.finder.utils.a.sKD;
      paramView = this.sVc.getContext();
      p.g(paramView, "context");
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramView, localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168371);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderMediaBanner paramFinderMediaBanner) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168372);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
      Intent localIntent = new Intent();
      paramView = this.sVc.getRefFeedInfo();
      if (paramView == null) {
        p.gfZ();
      }
      localIntent.putExtra("KEY_REF_OBJ_ID", paramView.refObjectId);
      paramView = this.sVc.getRefFeedInfo();
      if (paramView == null) {
        p.gfZ();
      }
      localIntent.putExtra("KEY_REF_OBJ_NONCE_ID", paramView.refObjectNonceId);
      paramView = this.sVc.getRefFeedInfo();
      if (paramView == null) {
        p.gfZ();
      }
      localObject = paramView.refObjectContact.username;
      paramView = (View)localObject;
      if (localObject == null) {
        paramView = "";
      }
      localIntent.putExtra("KEY_TARGET_USERNAME", paramView);
      paramView = this.sVc.getRefFeedInfo();
      if (paramView == null) {
        p.gfZ();
      }
      localObject = paramView.refObjectContact.nickname;
      paramView = (View)localObject;
      if (localObject == null) {
        paramView = "";
      }
      localIntent.putExtra("KEY_TARGET_NICKNAME", paramView);
      paramView = com.tencent.mm.plugin.finder.utils.a.sKD;
      paramView = this.sVc.getContext();
      p.g(paramView, "context");
      com.tencent.mm.plugin.finder.utils.a.E(paramView, localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168372);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderMediaBanner
 * JD-Core Version:    0.7.0.1
 */