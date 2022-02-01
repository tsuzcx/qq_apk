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
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.y;
import com.tencent.mm.view.MediaBanner;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import d.l;
import java.util.Timer;
import java.util.TimerTask;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "Lcom/tencent/mm/view/MediaBanner;", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "hideTextTimer", "Ljava/util/Timer;", "value", "", "isFrozenRecyclerView", "()Z", "setFrozenRecyclerView", "(Z)V", "refDeleteTip", "Landroid/widget/TextView;", "refDeleteTipLayout", "Landroid/view/View;", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "refFeedInfo", "getRefFeedInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeedInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "refFromTv", "refLayout", "topLayer", "typeIconIv", "Landroid/widget/ImageView;", "getTypeIconIv", "()Landroid/widget/ImageView;", "warnContainer", "canScrollHorizontally", "direction", "parent", "Landroid/view/ViewGroup;", "x", "", "y", "refreshRefUI", "", "plugin-finder_release"})
public final class FinderMediaBanner
  extends MediaBanner<com.tencent.mm.ui.base.a.b>
  implements FinderViewPager.a
{
  private final View Lff;
  private boolean Lfg;
  private final String TAG;
  private akf qNC;
  private final View qXs;
  private final View qXt;
  private final TextView qXu;
  private final View qXv;
  private final TextView qXw;
  private Timer qXx;
  private final ImageView qXy;
  
  public FinderMediaBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168377);
    this.TAG = "Finder.FinderMediaBanner";
    paramContext = LayoutInflater.from(getContext()).inflate(2131494034, null);
    d.g.b.k.g(paramContext, "LayoutInflater.from(cont…d_banner_top_layer, null)");
    this.qXs = paramContext;
    paramContext = LayoutInflater.from(getContext()).inflate(2131496193, null);
    d.g.b.k.g(paramContext, "LayoutInflater.from(cont…eed_warn_container, null)");
    this.Lff = paramContext;
    this.qXy = new ImageView(getContext());
    addView(this.qXs, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext = this.qXs.findViewById(2131304093);
    d.g.b.k.g(paramContext, "topLayer.findViewById(R.id.reprint_layout)");
    this.qXt = paramContext;
    setId(2131302203);
    paramContext = this.qXs.findViewById(2131304091);
    d.g.b.k.g(paramContext, "topLayer.findViewById(R.id.reprint_from_tv)");
    this.qXu = ((TextView)paramContext);
    paramContext = this.qXs.findViewById(2131298993);
    d.g.b.k.g(paramContext, "topLayer.findViewById(R.id.deleted_tips_layout)");
    this.qXv = paramContext;
    paramContext = this.qXs.findViewById(2131298994);
    d.g.b.k.g(paramContext, "topLayer.findViewById(R.id.deleted_tips_tv)");
    this.qXw = ((TextView)paramContext);
    csR();
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
    this.qXy.setVisibility(8);
    addView((View)this.qXy, (ViewGroup.LayoutParams)paramContext);
    paramContext = getContext();
    d.g.b.k.g(paramContext, "context");
    paramContext = new FinderVideoSeekBar(paramContext);
    paramContext.setVisibility(8);
    addView((View)paramContext);
    paramContext = y.js(getContext()).inflate(2131496185, null);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 80;
    getPagerViewContainer().addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    paramContext = new View(getContext());
    paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(0, com.tencent.mm.cd.a.fromDPToPix(getContext(), 10)));
    paramAttributeSet = getContainer();
    if (paramAttributeSet != null) {
      paramAttributeSet.addView(paramContext);
    }
    paramContext = getContainer();
    if (paramContext != null)
    {
      paramContext.addView(this.Lff, 1);
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
    this.qXs = paramContext;
    paramContext = LayoutInflater.from(getContext()).inflate(2131496193, null);
    d.g.b.k.g(paramContext, "LayoutInflater.from(cont…eed_warn_container, null)");
    this.Lff = paramContext;
    this.qXy = new ImageView(getContext());
    addView(this.qXs, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext = this.qXs.findViewById(2131304093);
    d.g.b.k.g(paramContext, "topLayer.findViewById(R.id.reprint_layout)");
    this.qXt = paramContext;
    setId(2131302203);
    paramContext = this.qXs.findViewById(2131304091);
    d.g.b.k.g(paramContext, "topLayer.findViewById(R.id.reprint_from_tv)");
    this.qXu = ((TextView)paramContext);
    paramContext = this.qXs.findViewById(2131298993);
    d.g.b.k.g(paramContext, "topLayer.findViewById(R.id.deleted_tips_layout)");
    this.qXv = paramContext;
    paramContext = this.qXs.findViewById(2131298994);
    d.g.b.k.g(paramContext, "topLayer.findViewById(R.id.deleted_tips_tv)");
    this.qXw = ((TextView)paramContext);
    csR();
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
    this.qXy.setVisibility(8);
    addView((View)this.qXy, (ViewGroup.LayoutParams)paramContext);
    paramContext = getContext();
    d.g.b.k.g(paramContext, "context");
    paramContext = new FinderVideoSeekBar(paramContext);
    paramContext.setVisibility(8);
    addView((View)paramContext);
    paramContext = y.js(getContext()).inflate(2131496185, null);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 80;
    getPagerViewContainer().addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    paramContext = new View(getContext());
    paramContext.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(0, com.tencent.mm.cd.a.fromDPToPix(getContext(), 10)));
    paramAttributeSet = getContainer();
    if (paramAttributeSet != null) {
      paramAttributeSet.addView(paramContext);
    }
    paramContext = getContainer();
    if (paramContext != null)
    {
      paramContext.addView(this.Lff, 1);
      AppMethodBeat.o(168378);
      return;
    }
    AppMethodBeat.o(168378);
  }
  
  private void csR()
  {
    AppMethodBeat.i(168374);
    Object localObject1 = this.qXx;
    if (localObject1 != null) {
      ((Timer)localObject1).cancel();
    }
    Object localObject2 = this.TAG;
    localObject1 = new StringBuilder("refreshRefUI ");
    boolean bool;
    if (this.qNC == null)
    {
      bool = true;
      Object localObject3 = ((StringBuilder)localObject1).append(bool).append(' ');
      localObject1 = this.qNC;
      if (localObject1 == null) {
        break label190;
      }
      localObject1 = ((akf)localObject1).refObjectContact;
      label70:
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(' ');
      localObject3 = this.qNC;
      if ((localObject3 == null) || (((akf)localObject3).refObjectFlag != 0L)) {
        break label195;
      }
      bool = true;
      label105:
      ad.i((String)localObject2, bool);
      if (this.qNC != null)
      {
        localObject1 = this.qNC;
        if (localObject1 == null) {
          break label200;
        }
      }
    }
    label190:
    label195:
    label200:
    for (localObject1 = ((akf)localObject1).refObjectContact;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = this.qNC;
        if ((localObject1 == null) || (((akf)localObject1).refObjectFlag != 0L)) {
          break label205;
        }
      }
      this.qXt.setVisibility(8);
      this.qXv.setVisibility(8);
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
    this.qXt.setVisibility(0);
    localObject1 = getContext();
    localObject2 = this.qNC;
    if (localObject2 == null) {
      d.g.b.k.fvU();
    }
    localObject1 = com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject1, (CharSequence)((akf)localObject2).refObjectContact.nickname);
    localObject2 = getContext().getString(2131759329, new Object[] { localObject1 });
    this.qXu.setText((CharSequence)localObject2);
    this.qXu.setVisibility(0);
    localObject2 = new Timer();
    ((Timer)localObject2).schedule((TimerTask)new a(this), 3000L);
    this.qXx = ((Timer)localObject2);
    localObject2 = this.qNC;
    if (localObject2 == null) {
      d.g.b.k.fvU();
    }
    if (((akf)localObject2).refObjectFlag == 2L)
    {
      this.qXv.setVisibility(0);
      this.qXt.setVisibility(8);
      this.qXw.setText((CharSequence)localObject1);
      this.qXv.setOnClickListener((View.OnClickListener)new b(this));
      AppMethodBeat.o(168374);
      return;
    }
    this.qXv.setVisibility(8);
    this.qXt.setOnClickListener((View.OnClickListener)new c(this));
    AppMethodBeat.o(168374);
  }
  
  public final boolean a(int paramInt, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(200116);
    d.g.b.k.h(paramViewGroup, "parent");
    if (!getManager().jE())
    {
      AppMethodBeat.o(200116);
      return false;
    }
    if (getManager().getItemCount() <= 1)
    {
      paramViewGroup = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (!com.tencent.mm.plugin.finder.storage.b.fUu())
      {
        AppMethodBeat.o(200116);
        return true;
      }
      AppMethodBeat.o(200116);
      return false;
    }
    if ((paramInt > 0) && (getManager().jR() == getManager().getItemCount() - 1))
    {
      paramViewGroup = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (!com.tencent.mm.plugin.finder.storage.b.fUu())
      {
        AppMethodBeat.o(200116);
        return true;
      }
      AppMethodBeat.o(200116);
      return false;
    }
    if ((paramInt < 0) && (getManager().jO() == 0) && (getManager().jP() == 0))
    {
      paramViewGroup = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (!com.tencent.mm.plugin.finder.storage.b.fUu())
      {
        AppMethodBeat.o(200116);
        return true;
      }
      AppMethodBeat.o(200116);
      return false;
    }
    AppMethodBeat.o(200116);
    return true;
  }
  
  public final akf getRefFeedInfo()
  {
    return this.qNC;
  }
  
  public final ImageView getTypeIconIv()
  {
    return this.qXy;
  }
  
  public final void setFrozenRecyclerView(boolean paramBoolean)
  {
    AppMethodBeat.i(200115);
    this.Lfg = paramBoolean;
    ad.i(this.TAG, "[SET] isPassTouchEvent=".concat(String.valueOf(paramBoolean)));
    RecyclerView localRecyclerView = getParentRecyclerView();
    if (localRecyclerView != null)
    {
      localRecyclerView.setLayoutFrozen(paramBoolean);
      AppMethodBeat.o(200115);
      return;
    }
    AppMethodBeat.o(200115);
  }
  
  public final void setRefFeedInfo(akf paramakf)
  {
    AppMethodBeat.i(168373);
    this.qNC = paramakf;
    csR();
    AppMethodBeat.o(168373);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$1$1", "Ljava/util/TimerTask;", "run", "", "plugin-finder_release"})
  public static final class a
    extends TimerTask
  {
    a(FinderMediaBanner paramFinderMediaBanner) {}
    
    public final void run()
    {
      AppMethodBeat.i(168370);
      this.qXA.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(168369);
          FinderMediaBanner.a(this.qXB.qXA).setVisibility(8);
          AppMethodBeat.o(168369);
        }
      });
      AppMethodBeat.o(168370);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderMediaBanner paramFinderMediaBanner) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168371);
      Intent localIntent = new Intent();
      paramView = this.qXA.getRefFeedInfo();
      if (paramView == null) {
        d.g.b.k.fvU();
      }
      String str = paramView.refObjectContact.username;
      paramView = str;
      if (str == null) {
        paramView = "";
      }
      localIntent.putExtra("finder_username", paramView);
      paramView = FinderReporterUIC.Ljl;
      paramView = this.qXA.getContext();
      d.g.b.k.g(paramView, "context");
      FinderReporterUIC.a.a(paramView, localIntent, 0L, 0, false, 124);
      paramView = com.tencent.mm.plugin.finder.utils.a.qSb;
      paramView = this.qXA.getContext();
      d.g.b.k.g(paramView, "context");
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramView, localIntent);
      AppMethodBeat.o(168371);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderMediaBanner paramFinderMediaBanner) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168372);
      Intent localIntent = new Intent();
      paramView = this.qXA.getRefFeedInfo();
      if (paramView == null) {
        d.g.b.k.fvU();
      }
      localIntent.putExtra("KEY_REF_OBJ_ID", paramView.refObjectId);
      paramView = this.qXA.getRefFeedInfo();
      if (paramView == null) {
        d.g.b.k.fvU();
      }
      localIntent.putExtra("KEY_REF_OBJ_NONCE_ID", paramView.refObjectNonceId);
      paramView = this.qXA.getRefFeedInfo();
      if (paramView == null) {
        d.g.b.k.fvU();
      }
      String str = paramView.refObjectContact.username;
      paramView = str;
      if (str == null) {
        paramView = "";
      }
      localIntent.putExtra("KEY_TARGET_USERNAME", paramView);
      paramView = this.qXA.getRefFeedInfo();
      if (paramView == null) {
        d.g.b.k.fvU();
      }
      str = paramView.refObjectContact.nickname;
      paramView = str;
      if (str == null) {
        paramView = "";
      }
      localIntent.putExtra("KEY_TARGET_NICKNAME", paramView);
      paramView = com.tencent.mm.plugin.finder.utils.a.qSb;
      paramView = this.qXA.getContext();
      d.g.b.k.g(paramView, "context");
      com.tencent.mm.plugin.finder.utils.a.A(paramView, localIntent);
      AppMethodBeat.o(168372);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderMediaBanner
 * JD-Core Version:    0.7.0.1
 */