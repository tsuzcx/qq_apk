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
import com.tencent.mm.protocal.protobuf.aqq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.z;
import com.tencent.mm.view.MediaBanner;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import d.g.b.p;
import d.l;
import java.util.Timer;
import java.util.TimerTask;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/FinderMediaBanner;", "Lcom/tencent/mm/view/MediaBanner;", "Lcom/tencent/mm/ui/base/adapter/ViewWrapper;", "Lcom/tencent/mm/plugin/finder/view/FinderViewPager$CheckScrollHorizontally;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "hideTextTimer", "Ljava/util/Timer;", "value", "", "isFrozenRecyclerView", "()Z", "setFrozenRecyclerView", "(Z)V", "refDeleteTip", "Landroid/widget/TextView;", "refDeleteTipLayout", "Landroid/view/View;", "Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "refFeedInfo", "getRefFeedInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;", "setRefFeedInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderObjectRefInfo;)V", "refFromTv", "refLayout", "spaceView", "getSpaceView", "()Landroid/view/View;", "topLayer", "typeIconIv", "Landroid/widget/ImageView;", "getTypeIconIv", "()Landroid/widget/ImageView;", "warnContainer", "canScrollHorizontally", "direction", "parent", "Landroid/view/ViewGroup;", "x", "", "y", "refreshRefUI", "", "plugin-finder_release"})
public final class FinderMediaBanner
  extends MediaBanner<com.tencent.mm.ui.base.a.b>
  implements FinderViewPager.a
{
  private final String TAG;
  private aqq sOX;
  private final View tgh;
  private final View tgi;
  private final View tgj;
  private final TextView tgk;
  private final View tgl;
  private final TextView tgm;
  private Timer tgn;
  private final ImageView tgo;
  private final View tgp;
  private boolean tgq;
  
  public FinderMediaBanner(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(168377);
    this.TAG = "Finder.FinderMediaBanner";
    paramContext = LayoutInflater.from(getContext()).inflate(2131494034, null);
    p.g(paramContext, "LayoutInflater.from(cont…d_banner_top_layer, null)");
    this.tgh = paramContext;
    paramContext = LayoutInflater.from(getContext()).inflate(2131496194, null);
    p.g(paramContext, "LayoutInflater.from(cont…eed_warn_container, null)");
    this.tgi = paramContext;
    this.tgo = new ImageView(getContext());
    this.tgp = new View(getContext());
    addView(this.tgh, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext = this.tgh.findViewById(2131304093);
    p.g(paramContext, "topLayer.findViewById(R.id.reprint_layout)");
    this.tgj = paramContext;
    setId(2131302203);
    paramContext = this.tgh.findViewById(2131304091);
    p.g(paramContext, "topLayer.findViewById(R.id.reprint_from_tv)");
    this.tgk = ((TextView)paramContext);
    paramContext = this.tgh.findViewById(2131298993);
    p.g(paramContext, "topLayer.findViewById(R.id.deleted_tips_layout)");
    this.tgl = paramContext;
    paramContext = this.tgh.findViewById(2131298994);
    p.g(paramContext, "topLayer.findViewById(R.id.deleted_tips_tv)");
    this.tgm = ((TextView)paramContext);
    cQf();
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
    this.tgo.setVisibility(8);
    addView((View)this.tgo, (ViewGroup.LayoutParams)paramContext);
    paramContext = getContext();
    p.g(paramContext, "context");
    paramContext = new FinderVideoSeekBar(paramContext);
    paramContext.setVisibility(8);
    addView((View)paramContext);
    paramContext = z.jV(getContext()).inflate(2131496186, null);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 80;
    getPagerViewContainer().addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    this.tgp.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 10)));
    paramContext = getContainer();
    if (paramContext != null) {
      paramContext.addView(this.tgp);
    }
    paramContext = getContainer();
    if (paramContext != null)
    {
      paramContext.addView(this.tgi, 1);
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
    this.tgh = paramContext;
    paramContext = LayoutInflater.from(getContext()).inflate(2131496194, null);
    p.g(paramContext, "LayoutInflater.from(cont…eed_warn_container, null)");
    this.tgi = paramContext;
    this.tgo = new ImageView(getContext());
    this.tgp = new View(getContext());
    addView(this.tgh, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramContext = this.tgh.findViewById(2131304093);
    p.g(paramContext, "topLayer.findViewById(R.id.reprint_layout)");
    this.tgj = paramContext;
    setId(2131302203);
    paramContext = this.tgh.findViewById(2131304091);
    p.g(paramContext, "topLayer.findViewById(R.id.reprint_from_tv)");
    this.tgk = ((TextView)paramContext);
    paramContext = this.tgh.findViewById(2131298993);
    p.g(paramContext, "topLayer.findViewById(R.id.deleted_tips_layout)");
    this.tgl = paramContext;
    paramContext = this.tgh.findViewById(2131298994);
    p.g(paramContext, "topLayer.findViewById(R.id.deleted_tips_tv)");
    this.tgm = ((TextView)paramContext);
    cQf();
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
    this.tgo.setVisibility(8);
    addView((View)this.tgo, (ViewGroup.LayoutParams)paramContext);
    paramContext = getContext();
    p.g(paramContext, "context");
    paramContext = new FinderVideoSeekBar(paramContext);
    paramContext.setVisibility(8);
    addView((View)paramContext);
    paramContext = z.jV(getContext()).inflate(2131496186, null);
    paramAttributeSet = new FrameLayout.LayoutParams(-1, -2);
    paramAttributeSet.gravity = 80;
    getPagerViewContainer().addView(paramContext, (ViewGroup.LayoutParams)paramAttributeSet);
    this.tgp.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(0, com.tencent.mm.cb.a.fromDPToPix(getContext(), 10)));
    paramContext = getContainer();
    if (paramContext != null) {
      paramContext.addView(this.tgp);
    }
    paramContext = getContainer();
    if (paramContext != null)
    {
      paramContext.addView(this.tgi, 1);
      AppMethodBeat.o(168378);
      return;
    }
    AppMethodBeat.o(168378);
  }
  
  private void cQf()
  {
    AppMethodBeat.i(168374);
    Object localObject1 = this.tgn;
    if (localObject1 != null) {
      ((Timer)localObject1).cancel();
    }
    Object localObject2 = this.TAG;
    localObject1 = new StringBuilder("refreshRefUI ");
    boolean bool;
    if (this.sOX == null)
    {
      bool = true;
      Object localObject3 = ((StringBuilder)localObject1).append(bool).append(' ');
      localObject1 = this.sOX;
      if (localObject1 == null) {
        break label190;
      }
      localObject1 = ((aqq)localObject1).refObjectContact;
      label70:
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(' ');
      localObject3 = this.sOX;
      if ((localObject3 == null) || (((aqq)localObject3).refObjectFlag != 0L)) {
        break label195;
      }
      bool = true;
      label105:
      ae.i((String)localObject2, bool);
      if (this.sOX != null)
      {
        localObject1 = this.sOX;
        if (localObject1 == null) {
          break label200;
        }
      }
    }
    label190:
    label195:
    label200:
    for (localObject1 = ((aqq)localObject1).refObjectContact;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = this.sOX;
        if ((localObject1 == null) || (((aqq)localObject1).refObjectFlag != 0L)) {
          break label205;
        }
      }
      this.tgj.setVisibility(8);
      this.tgl.setVisibility(8);
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
    this.tgj.setVisibility(0);
    localObject2 = getContext();
    localObject1 = this.sOX;
    if (localObject1 == null) {
      p.gkB();
    }
    localObject1 = ((aqq)localObject1).refObjectContact;
    if (localObject1 != null)
    {
      localObject1 = ((FinderContact)localObject1).nickname;
      if (localObject1 == null) {}
    }
    for (localObject1 = (CharSequence)localObject1;; localObject1 = (CharSequence)"")
    {
      localObject1 = k.c((Context)localObject2, (CharSequence)localObject1);
      localObject2 = getContext().getString(2131759329, new Object[] { localObject1 });
      this.tgk.setText((CharSequence)localObject2);
      this.tgk.setVisibility(0);
      localObject2 = new Timer();
      ((Timer)localObject2).schedule((TimerTask)new b(this), 3000L);
      this.tgn = ((Timer)localObject2);
      localObject2 = this.sOX;
      if (localObject2 == null) {
        p.gkB();
      }
      if (((aqq)localObject2).refObjectFlag != 2L) {
        break;
      }
      this.tgl.setVisibility(0);
      this.tgj.setVisibility(8);
      this.tgm.setText((CharSequence)localObject1);
      this.tgl.setOnClickListener((View.OnClickListener)new c(this));
      AppMethodBeat.o(168374);
      return;
    }
    this.tgl.setVisibility(8);
    this.tgj.setOnClickListener((View.OnClickListener)new d(this));
    AppMethodBeat.o(168374);
  }
  
  public final boolean a(int paramInt, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(205800);
    p.h(paramViewGroup, "parent");
    if (!getManager().kc())
    {
      AppMethodBeat.o(205800);
      return false;
    }
    if (getManager().getItemCount() <= 1)
    {
      paramViewGroup = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cIQ().value()).intValue() != 1)
      {
        AppMethodBeat.o(205800);
        return true;
      }
      AppMethodBeat.o(205800);
      return false;
    }
    if ((paramInt > 0) && (getManager().kp() == getManager().getItemCount() - 1))
    {
      paramViewGroup = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cIQ().value()).intValue() != 1)
      {
        AppMethodBeat.o(205800);
        return true;
      }
      AppMethodBeat.o(205800);
      return false;
    }
    if ((paramInt < 0) && (getManager().km() == 0) && (getManager().kn() == 0))
    {
      paramViewGroup = com.tencent.mm.plugin.finder.storage.b.sHP;
      if (((Number)com.tencent.mm.plugin.finder.storage.b.cIQ().value()).intValue() != 1)
      {
        AppMethodBeat.o(205800);
        return true;
      }
      AppMethodBeat.o(205800);
      return false;
    }
    AppMethodBeat.o(205800);
    return true;
  }
  
  public final aqq getRefFeedInfo()
  {
    return this.sOX;
  }
  
  public final View getSpaceView()
  {
    return this.tgp;
  }
  
  public final ImageView getTypeIconIv()
  {
    return this.tgo;
  }
  
  public final void setFrozenRecyclerView(final boolean paramBoolean)
  {
    AppMethodBeat.i(205799);
    this.tgq = paramBoolean;
    String str = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder("[SET] isPassTouchEvent=").append(paramBoolean).append(" isInLayout=");
    Object localObject = getParentRecyclerView();
    if (localObject != null) {}
    for (localObject = Boolean.valueOf(((RecyclerView)localObject).isInLayout());; localObject = null)
    {
      ae.i(str, localObject);
      localObject = getParentRecyclerView();
      if ((localObject == null) || (((RecyclerView)localObject).isInLayout() != true)) {
        break label130;
      }
      localObject = getParentRecyclerView();
      if (localObject == null) {
        break;
      }
      ((RecyclerView)localObject).post((Runnable)new a(this, paramBoolean));
      AppMethodBeat.o(205799);
      return;
    }
    AppMethodBeat.o(205799);
    return;
    label130:
    localObject = getParentRecyclerView();
    if (localObject != null)
    {
      ((RecyclerView)localObject).setLayoutFrozen(paramBoolean);
      AppMethodBeat.o(205799);
      return;
    }
    AppMethodBeat.o(205799);
  }
  
  public final void setRefFeedInfo(aqq paramaqq)
  {
    AppMethodBeat.i(168373);
    this.sOX = paramaqq;
    cQf();
    AppMethodBeat.o(168373);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(FinderMediaBanner paramFinderMediaBanner, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(205798);
      RecyclerView localRecyclerView = this.tgr.getParentRecyclerView();
      if (localRecyclerView != null)
      {
        localRecyclerView.setLayoutFrozen(paramBoolean);
        AppMethodBeat.o(205798);
        return;
      }
      AppMethodBeat.o(205798);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$1$1", "Ljava/util/TimerTask;", "run", "", "plugin-finder_release"})
  public static final class b
    extends TimerTask
  {
    b(FinderMediaBanner paramFinderMediaBanner) {}
    
    public final void run()
    {
      AppMethodBeat.i(168370);
      this.tgr.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(168369);
          FinderMediaBanner.a(this.tgt.tgr).setVisibility(8);
          AppMethodBeat.o(168369);
        }
      });
      AppMethodBeat.o(168370);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderMediaBanner paramFinderMediaBanner) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168371);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      Intent localIntent = new Intent();
      paramView = this.tgr.getRefFeedInfo();
      if (paramView == null) {
        p.gkB();
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
      paramView = FinderReporterUIC.tnG;
      paramView = this.tgr.getContext();
      p.g(paramView, "context");
      FinderReporterUIC.a.a(paramView, localIntent, 0L, 0, false, 124);
      paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
      paramView = this.tgr.getContext();
      p.g(paramView, "context");
      com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramView, localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168371);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderMediaBanner paramFinderMediaBanner) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(168372);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      Intent localIntent = new Intent();
      paramView = this.tgr.getRefFeedInfo();
      if (paramView == null) {
        p.gkB();
      }
      localIntent.putExtra("KEY_REF_OBJ_ID", paramView.refObjectId);
      paramView = this.tgr.getRefFeedInfo();
      if (paramView == null) {
        p.gkB();
      }
      localIntent.putExtra("KEY_REF_OBJ_NONCE_ID", paramView.refObjectNonceId);
      paramView = this.tgr.getRefFeedInfo();
      if (paramView == null) {
        p.gkB();
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
      paramView = this.tgr.getRefFeedInfo();
      if (paramView == null) {
        p.gkB();
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
      paramView = com.tencent.mm.plugin.finder.utils.a.sVQ;
      paramView = this.tgr.getContext();
      p.g(paramView, "context");
      com.tencent.mm.plugin.finder.utils.a.E(paramView, localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/view/FinderMediaBanner$refreshRefUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(168372);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.FinderMediaBanner
 * JD-Core Version:    0.7.0.1
 */