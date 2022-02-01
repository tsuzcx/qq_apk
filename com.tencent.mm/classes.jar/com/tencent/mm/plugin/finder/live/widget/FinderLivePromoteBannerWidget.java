package com.tencent.mm.plugin.finder.live.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.ViewFlipper;
import com.tencent.d.a.a.a.b.a.f;
import com.tencent.d.a.a.a.b.a.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.p.a;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.NativeInfo;
import com.tencent.mm.protocal.protobuf.bfn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import com.tencent.mm.ui.widget.RoundedCornerFrameLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.an;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePromoteBannerWidget;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "bitmapCache", "Ljava/util/HashMap;", "Landroid/graphics/Bitmap;", "Lkotlin/collections/HashMap;", "getBitmapCache", "()Ljava/util/HashMap;", "setBitmapCache", "(Ljava/util/HashMap;)V", "jumpInfo", "Lcom/tencent/mm/plugin/finder/live/model/FinderBannerJumpInfo;", "getJumpInfo", "()Lcom/tencent/mm/plugin/finder/live/model/FinderBannerJumpInfo;", "setJumpInfo", "(Lcom/tencent/mm/plugin/finder/live/model/FinderBannerJumpInfo;)V", "listener", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePromoteBannerWidget$OnClickListener;", "getListener", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePromoteBannerWidget$OnClickListener;", "setListener", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePromoteBannerWidget$OnClickListener;)V", "loopBannerViewFlipper", "Landroid/widget/ViewFlipper;", "getLoopBannerViewFlipper", "()Landroid/widget/ViewFlipper;", "setLoopBannerViewFlipper", "(Landroid/widget/ViewFlipper;)V", "loopDataList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLoopDataList", "()Ljava/util/ArrayList;", "setLoopDataList", "(Ljava/util/ArrayList;)V", "sidebarLayout", "Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;", "getSidebarLayout", "()Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;", "setSidebarLayout", "(Lcom/tencent/mm/ui/widget/RoundedCornerFrameLayout;)V", "sidebarTv", "Landroid/widget/TextView;", "getSidebarTv", "()Landroid/widget/TextView;", "setSidebarTv", "(Landroid/widget/TextView;)V", "status", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePromoteBannerWidget$LoopBannerStatus;", "getStatus", "()Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePromoteBannerWidget$LoopBannerStatus;", "setStatus", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePromoteBannerWidget$LoopBannerStatus;)V", "viewHolderCache", "Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePromoteBannerWidget$LoopBannerViewHolder;", "getViewHolderCache", "setViewHolderCache", "clear", "", "clearCache", "createLoopBannerView", "bannerId", "doDislikeBanner", "loop", "", "getLoopDisplayIndex", "initLoopBannerFlipper", "initView", "isLandscape", "isShowing", "keepFlipping", "pauseFlipping", "removeJumpInfoFromList", "resetLoopBanner", "stopFlipping", "updateBanner", "updateData", "data", "updateLoopBannerItem", "viewHolder", "LoopBannerStatus", "LoopBannerViewHolder", "OnClickListener", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLivePromoteBannerWidget
  extends FrameLayout
{
  private c Eto;
  private com.tencent.mm.plugin.finder.live.model.b Etp;
  private ArrayList<com.tencent.mm.plugin.finder.live.model.b> Etq;
  private ViewFlipper Etr;
  public HashMap<String, b> Ets;
  private FinderLivePromoteBannerWidget.a Ett;
  private RoundedCornerFrameLayout Etu;
  private TextView Etv;
  public HashMap<String, Bitmap> Etw;
  public final String TAG;
  
  public FinderLivePromoteBannerWidget(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(362128);
    this.TAG = "Finder.FinderLivePromoteBannerWidget";
    this.Etq = new ArrayList();
    this.Ets = new HashMap();
    this.Ett = FinderLivePromoteBannerWidget.a.Etz;
    this.Etw = new HashMap();
    initView();
    AppMethodBeat.o(362128);
  }
  
  public FinderLivePromoteBannerWidget(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(362134);
    this.TAG = "Finder.FinderLivePromoteBannerWidget";
    this.Etq = new ArrayList();
    this.Ets = new HashMap();
    this.Ett = FinderLivePromoteBannerWidget.a.Etz;
    this.Etw = new HashMap();
    initView();
    AppMethodBeat.o(362134);
  }
  
  private final void a(com.tencent.mm.plugin.finder.live.model.b paramb, b paramb1)
  {
    Object localObject3 = null;
    AppMethodBeat.i(362163);
    Object localObject1;
    Object localObject2;
    if (paramb1 == null)
    {
      localObject1 = null;
      if (paramb != null) {
        break label143;
      }
      localObject2 = null;
      label21:
      if (!s.p(localObject1, localObject2))
      {
        if (paramb1 != null) {
          break label170;
        }
        localObject2 = localObject3;
        label38:
        if (localObject2 != null)
        {
          if (paramb != null) {
            break label179;
          }
          localObject1 = (CharSequence)"";
          label53:
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      localObject2 = new ah.f();
      if (paramb != null) {
        break label223;
      }
      paramb = "";
    }
    for (;;)
    {
      ((ah.f)localObject2).aqH = paramb;
      if (!TextUtils.isEmpty((CharSequence)((ah.f)localObject2).aqH)) {
        d.a(100L, (kotlin.g.a.a)new g(paramb1, this, (ah.f)localObject2));
      }
      AppMethodBeat.o(362163);
      return;
      localObject1 = paramb1.pJJ;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = ((TextView)localObject1).getText();
      break;
      label143:
      localObject2 = paramb.CDz;
      if (localObject2 == null)
      {
        localObject2 = null;
        break label21;
      }
      localObject2 = ((FinderJumpInfo)localObject2).wording;
      break label21;
      label170:
      localObject2 = paramb1.pJJ;
      break label38;
      label179:
      localObject1 = paramb.CDz;
      if (localObject1 == null)
      {
        localObject1 = (CharSequence)"";
        break label53;
      }
      localObject1 = ((FinderJumpInfo)localObject1).wording;
      if (localObject1 == null)
      {
        localObject1 = (CharSequence)"";
        break label53;
      }
      localObject1 = (CharSequence)localObject1;
      break label53;
      label223:
      paramb = paramb.CDz;
      if (paramb == null)
      {
        paramb = "";
      }
      else
      {
        localObject1 = paramb.icon_url;
        paramb = (com.tencent.mm.plugin.finder.live.model.b)localObject1;
        if (localObject1 == null) {
          paramb = "";
        }
      }
    }
  }
  
  private static final void a(FinderLivePromoteBannerWidget paramFinderLivePromoteBannerWidget, View paramView)
  {
    AppMethodBeat.i(362172);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLivePromoteBannerWidget);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLivePromoteBannerWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLivePromoteBannerWidget, "this$0");
    if ((paramFinderLivePromoteBannerWidget.getListener() != null) && (paramFinderLivePromoteBannerWidget.getJumpInfo() != null))
    {
      paramView = paramFinderLivePromoteBannerWidget.getListener();
      if (paramView != null)
      {
        paramFinderLivePromoteBannerWidget = paramFinderLivePromoteBannerWidget.getJumpInfo();
        if (paramFinderLivePromoteBannerWidget == null)
        {
          paramFinderLivePromoteBannerWidget = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.live.model.FinderBannerJumpInfo");
          AppMethodBeat.o(362172);
          throw paramFinderLivePromoteBannerWidget;
        }
        paramView.a(paramFinderLivePromoteBannerWidget);
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLivePromoteBannerWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(362172);
      return;
      if ((paramFinderLivePromoteBannerWidget.getListener() != null) && (paramFinderLivePromoteBannerWidget.getLoopDataList().size() > 0))
      {
        int i = paramFinderLivePromoteBannerWidget.getLoopDisplayIndex();
        paramView = new ArrayList();
        paramView.addAll((Collection)paramFinderLivePromoteBannerWidget.getLoopDataList());
        if ((i >= 0) && (i < paramView.size()))
        {
          paramFinderLivePromoteBannerWidget = paramFinderLivePromoteBannerWidget.getListener();
          if (paramFinderLivePromoteBannerWidget != null)
          {
            paramView = paramView.get(i);
            s.s(paramView, "tempList[index]");
            paramFinderLivePromoteBannerWidget.a((com.tencent.mm.plugin.finder.live.model.b)paramView);
          }
        }
      }
    }
  }
  
  private static final void a(FinderLivePromoteBannerWidget paramFinderLivePromoteBannerWidget, com.tencent.mm.plugin.finder.live.model.b paramb, View paramView)
  {
    AppMethodBeat.i(362180);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLivePromoteBannerWidget);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLivePromoteBannerWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLivePromoteBannerWidget, "this$0");
    s.u(paramb, "$jumpInfo");
    if (paramFinderLivePromoteBannerWidget.getListener() != null)
    {
      paramFinderLivePromoteBannerWidget = paramFinderLivePromoteBannerWidget.getListener();
      if (paramFinderLivePromoteBannerWidget != null) {
        paramFinderLivePromoteBannerWidget.a(paramb);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLivePromoteBannerWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(362180);
  }
  
  private final void a(String paramString, com.tencent.mm.plugin.finder.live.model.b paramb)
  {
    AppMethodBeat.i(362156);
    Object localObject1 = LayoutInflater.from(getContext()).inflate(p.f.Cfo, null, false);
    if (localObject1 == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(362156);
      throw paramString;
    }
    localObject1 = (FrameLayout)localObject1;
    b localb = new b();
    localb.lBX = ((View)localObject1);
    Object localObject2 = ((FrameLayout)localObject1).findViewById(p.e.BYF);
    if (localObject2 == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(362156);
      throw paramString;
    }
    localb.EtB = ((View)localObject2);
    localObject2 = ((FrameLayout)localObject1).findViewById(p.e.BRt);
    if (localObject2 == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(362156);
      throw paramString;
    }
    localb.Api = ((LinearLayout)localObject2);
    localObject2 = ((FrameLayout)localObject1).findViewById(p.e.BRu);
    if (localObject2 == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(362156);
      throw paramString;
    }
    localb.pJJ = ((TextView)localObject2);
    localObject2 = localb.pJJ;
    if (localObject2 != null) {
      ((TextView)localObject2).setTextSize(0, com.tencent.mm.cd.a.fromDPToPix(((FrameLayout)localObject1).getContext(), 12));
    }
    localObject2 = ((FrameLayout)localObject1).findViewById(p.e.BRr);
    if (localObject2 == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.widget.MMRoundCornerImageView");
      AppMethodBeat.o(362156);
      throw paramString;
    }
    localb.EtC = ((MMRoundCornerImageView)localObject2);
    localObject2 = ((FrameLayout)localObject1).findViewById(p.e.BRs);
    if (localObject2 == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
      AppMethodBeat.o(362156);
      throw paramString;
    }
    localb.EtD = ((LinearLayout)localObject2);
    this.Ets.put(paramString, localb);
    ((FrameLayout)localObject1).setOnClickListener(new FinderLivePromoteBannerWidget..ExternalSyntheticLambda1(this, paramb));
    ((FrameLayout)localObject1).setOnLongClickListener(new FinderLivePromoteBannerWidget..ExternalSyntheticLambda2(this, paramb));
    paramString = new FrameLayout.LayoutParams(-2, -2, 5);
    localObject2 = this.Etr;
    if (localObject2 != null) {
      ((ViewFlipper)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)paramString);
    }
    a(paramb, localb);
    AppMethodBeat.o(362156);
  }
  
  private static final boolean b(FinderLivePromoteBannerWidget paramFinderLivePromoteBannerWidget, com.tencent.mm.plugin.finder.live.model.b paramb, View paramView)
  {
    AppMethodBeat.i(362186);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLivePromoteBannerWidget);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/widget/FinderLivePromoteBannerWidget", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    s.u(paramFinderLivePromoteBannerWidget, "this$0");
    s.u(paramb, "$jumpInfo");
    paramFinderLivePromoteBannerWidget.eBv();
    if (paramFinderLivePromoteBannerWidget.getListener() != null)
    {
      paramFinderLivePromoteBannerWidget = paramFinderLivePromoteBannerWidget.getListener();
      if (paramFinderLivePromoteBannerWidget != null) {
        paramFinderLivePromoteBannerWidget.b(paramb);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(true, new Object(), "com/tencent/mm/plugin/finder/live/widget/FinderLivePromoteBannerWidget", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(362186);
    return true;
  }
  
  private final void eBw()
  {
    AppMethodBeat.i(362145);
    Object localObject1 = this.Etr;
    if (localObject1 != null) {
      ((ViewFlipper)localObject1).setFlipInterval(5000);
    }
    Object localObject2 = AnimationUtils.loadAnimation(getContext(), p.a.ByG);
    localObject1 = AnimationUtils.loadAnimation(getContext(), p.a.ByH);
    ((Animation)localObject2).setAnimationListener((Animation.AnimationListener)new e(this));
    ((Animation)localObject1).setAnimationListener((Animation.AnimationListener)new f());
    ViewFlipper localViewFlipper = this.Etr;
    if (localViewFlipper != null) {
      localViewFlipper.setInAnimation((Animation)localObject2);
    }
    localObject2 = this.Etr;
    if (localObject2 != null) {
      ((ViewFlipper)localObject2).setOutAnimation((Animation)localObject1);
    }
    AppMethodBeat.o(362145);
  }
  
  private final void eBx()
  {
    AppMethodBeat.i(362153);
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll((Collection)this.Etq);
    Iterator localIterator = localArrayList.iterator();
    Object localObject1;
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.finder.live.model.b localb = (com.tencent.mm.plugin.finder.live.model.b)localIterator.next();
      localObject1 = com.tencent.mm.plugin.finder.live.sidebar.a.DGm;
      localObject1 = com.tencent.mm.plugin.finder.live.sidebar.a.axE(localb.CDz.ext_info);
      if (localObject1 == null) {
        localObject1 = "";
      }
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break label120;
        }
        Log.e(this.TAG, "id is empty!!");
        break;
        localObject2 = ((bfn)localObject1).id;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
      label120:
      Object localObject2 = (b)this.Ets.get(localObject1);
      if (localObject2 == null)
      {
        s.s(localb, "jumpInfo");
        a((String)localObject1, localb);
      }
      else
      {
        s.s(localb, "jumpInfo");
        a(localb, (b)localObject2);
      }
    }
    Log.i(this.TAG, "size is %d", new Object[] { Integer.valueOf(localArrayList.size()) });
    if (localArrayList.size() == 1)
    {
      if (this.Ett == FinderLivePromoteBannerWidget.a.Etx)
      {
        localObject1 = this.Etr;
        if (localObject1 != null) {
          ((ViewFlipper)localObject1).stopFlipping();
        }
      }
      this.Ett = FinderLivePromoteBannerWidget.a.Etz;
      AppMethodBeat.o(362153);
      return;
    }
    if (!((Collection)localArrayList).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      if (this.Ett != FinderLivePromoteBannerWidget.a.Etz) {
        break label362;
      }
      localObject1 = this.Etr;
      if (localObject1 != null) {
        ((ViewFlipper)localObject1).startFlipping();
      }
      this.Ett = FinderLivePromoteBannerWidget.a.Etx;
      AppMethodBeat.o(362153);
      return;
    }
    if (localArrayList.isEmpty())
    {
      if (this.Ett == FinderLivePromoteBannerWidget.a.Etx)
      {
        localObject1 = this.Etr;
        if (localObject1 != null) {
          ((ViewFlipper)localObject1).stopFlipping();
        }
      }
      this.Ett = FinderLivePromoteBannerWidget.a.Etz;
      localObject1 = this.Etr;
      if (localObject1 != null) {
        ((ViewFlipper)localObject1).removeAllViews();
      }
      this.Ets.clear();
    }
    label362:
    AppMethodBeat.o(362153);
  }
  
  private final void initView()
  {
    AppMethodBeat.i(362139);
    Object localObject = LayoutInflater.from(getContext()).inflate(p.f.Cfn, null, false);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout");
      AppMethodBeat.o(362139);
      throw ((Throwable)localObject);
    }
    localObject = (FrameLayout)localObject;
    this.Etr = ((ViewFlipper)((FrameLayout)localObject).findViewById(p.e.BXl));
    eBw();
    this.Etu = ((RoundedCornerFrameLayout)((FrameLayout)localObject).findViewById(p.e.Cbd));
    this.Etv = ((TextView)((FrameLayout)localObject).findViewById(p.e.Cbe));
    setVisibility(4);
    addView((View)localObject);
    ((FrameLayout)localObject).setOnClickListener(new FinderLivePromoteBannerWidget..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(362139);
  }
  
  public final void ar(ArrayList<com.tencent.mm.plugin.finder.live.model.b> paramArrayList)
  {
    AppMethodBeat.i(362339);
    s.u(paramArrayList, "data");
    this.Etq.clear();
    this.Etq.addAll((Collection)paramArrayList);
    AppMethodBeat.o(362339);
  }
  
  public final void ayD(String paramString)
  {
    AppMethodBeat.i(362358);
    s.u(paramString, "bannerId");
    Object localObject = new ArrayList();
    ((ArrayList)localObject).addAll((Collection)this.Etq);
    Iterator localIterator = ((ArrayList)localObject).iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.finder.live.model.b localb = (com.tencent.mm.plugin.finder.live.model.b)localIterator.next();
      localObject = com.tencent.mm.plugin.finder.live.sidebar.a.DGm;
      localObject = com.tencent.mm.plugin.finder.live.sidebar.a.axE(localb.CDz.ext_info);
      if (localObject == null) {
        localObject = "";
      }
      for (;;)
      {
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break label124;
        }
        Log.e(this.TAG, "id is empty!!");
        break;
        String str = ((bfn)localObject).id;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
      }
      label124:
      if (((String)localObject).equals(paramString))
      {
        Log.i(this.TAG, "removeJumpInfoFromList bannerId:%s", new Object[] { paramString });
        this.Etq.remove(localb);
        AppMethodBeat.o(362358);
        return;
      }
    }
    AppMethodBeat.o(362358);
  }
  
  public final void eBs()
  {
    AppMethodBeat.i(362330);
    eBu();
    ViewFlipper localViewFlipper = this.Etr;
    if (localViewFlipper != null) {
      localViewFlipper.removeAllViews();
    }
    this.Ets.clear();
    AppMethodBeat.o(362330);
  }
  
  public final void eBt()
  {
    AppMethodBeat.i(362366);
    if (((this.Ett == FinderLivePromoteBannerWidget.a.Etz) || (this.Ett == FinderLivePromoteBannerWidget.a.Ety)) && (this.Etq.size() > 1))
    {
      this.Ett = FinderLivePromoteBannerWidget.a.Etx;
      ViewFlipper localViewFlipper = this.Etr;
      if (localViewFlipper != null) {
        localViewFlipper.startFlipping();
      }
      localViewFlipper = this.Etr;
      if (localViewFlipper != null) {
        localViewFlipper.showNext();
      }
    }
    AppMethodBeat.o(362366);
  }
  
  public final void eBu()
  {
    AppMethodBeat.i(362374);
    if ((this.Ett == FinderLivePromoteBannerWidget.a.Etx) || (this.Ett == FinderLivePromoteBannerWidget.a.Ety))
    {
      ViewFlipper localViewFlipper = this.Etr;
      if (localViewFlipper != null) {
        localViewFlipper.stopFlipping();
      }
    }
    this.Ett = FinderLivePromoteBannerWidget.a.Etz;
    AppMethodBeat.o(362374);
  }
  
  public final void eBv()
  {
    AppMethodBeat.i(362380);
    if (this.Ett == FinderLivePromoteBannerWidget.a.Etx)
    {
      this.Ett = FinderLivePromoteBannerWidget.a.Ety;
      ViewFlipper localViewFlipper = this.Etr;
      if (localViewFlipper != null) {
        localViewFlipper.stopFlipping();
      }
    }
    AppMethodBeat.o(362380);
  }
  
  public final void ery()
  {
    Object localObject3 = null;
    AppMethodBeat.i(362351);
    if ((this.Etp == null) && (this.Etq.isEmpty()))
    {
      Log.i(this.TAG, "jumpInfo is null and loopDataList is empty");
      AppMethodBeat.o(362351);
      return;
    }
    setVisibility(0);
    Object localObject1 = getParent();
    label71:
    label83:
    Object localObject4;
    int i;
    if ((localObject1 instanceof View))
    {
      localObject1 = (View)localObject1;
      if (localObject1 != null) {
        break label356;
      }
      localObject1 = null;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        break label364;
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      localObject4 = this.Etp;
      if (localObject4 == null) {
        break label369;
      }
      localObject4 = ((com.tencent.mm.plugin.finder.live.model.b)localObject4).CDz;
      if (localObject4 == null) {
        break label369;
      }
      localObject4 = ((FinderJumpInfo)localObject4).native_info;
      if ((localObject4 == null) || (((NativeInfo)localObject4).native_type != 9)) {
        break label369;
      }
      i = 1;
      label130:
      if (i == 0) {
        break label504;
      }
      eBs();
      localObject4 = this.Etr;
      if (localObject4 != null) {
        ((ViewFlipper)localObject4).setVisibility(8);
      }
      localObject4 = this.Etu;
      if (localObject4 != null) {
        ((RoundedCornerFrameLayout)localObject4).setVisibility(0);
      }
      if (localObject1 != null) {
        ((RelativeLayout.LayoutParams)localObject1).setMarginEnd(0);
      }
      localObject4 = this.Etv;
      if (localObject4 != null)
      {
        localObject1 = this.Etp;
        if (localObject1 != null) {
          break label374;
        }
        localObject1 = null;
        label204:
        if (localObject1 != null) {
          break label396;
        }
        localObject1 = (CharSequence)getContext().getString(p.h.CsU);
        label222:
        ((TextView)localObject4).setText((CharSequence)localObject1);
      }
      float f = getContext().getResources().getDimension(p.c.Edge_1_5_A);
      localObject1 = this.Etu;
      if (localObject1 != null) {
        ((RoundedCornerFrameLayout)localObject1).A(f, 0.0F, f, 0.0F);
      }
      localObject1 = com.tencent.mm.plugin.finder.live.sidebar.a.DGm;
      localObject1 = this.Etp;
      if (localObject1 != null) {
        break label404;
      }
      localObject1 = localObject3;
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.finder.live.sidebar.a.axE((String)localObject1);
      if (localObject1 == null) {
        break label471;
      }
      i = ((bfn)localObject1).ZPv;
      localObject3 = a.f.ahmZ;
      if (i != a.f.a.jVh()) {
        break label471;
      }
      try
      {
        localObject4 = this.Etu;
        if (localObject4 == null) {
          break label565;
        }
        localObject3 = ((bfn)localObject1).background_color;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        ((RoundedCornerFrameLayout)localObject4).setBackgroundColor(Color.parseColor(s.X("#80", localObject1)));
        AppMethodBeat.o(362351);
        return;
      }
      finally
      {
        label356:
        label364:
        Log.i(this.TAG, "color invalid");
        localRoundedCornerFrameLayout = this.Etu;
        if (localRoundedCornerFrameLayout == null) {
          break label565;
        }
      }
      localObject1 = null;
      break;
      localObject1 = ((View)localObject1).getLayoutParams();
      break label71;
      localObject1 = null;
      break label83;
      label369:
      i = 0;
      break label130;
      label374:
      localObject1 = ((com.tencent.mm.plugin.finder.live.model.b)localObject1).CDz;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label204;
      }
      localObject1 = ((FinderJumpInfo)localObject1).wording;
      break label204;
      label396:
      localObject1 = (CharSequence)localObject1;
      break label222;
      label404:
      localObject4 = ((com.tencent.mm.plugin.finder.live.model.b)localObject1).CDz;
      localObject1 = localObject3;
      if (localObject4 != null) {
        localObject1 = ((FinderJumpInfo)localObject4).ext_info;
      }
    }
    localRoundedCornerFrameLayout.setBackgroundColor(getContext().getResources().getColor(p.b.BW_0_Alpha_0_1_5));
    AppMethodBeat.o(362351);
    return;
    label471:
    RoundedCornerFrameLayout localRoundedCornerFrameLayout = this.Etu;
    if (localRoundedCornerFrameLayout != null)
    {
      localRoundedCornerFrameLayout.setBackgroundColor(getContext().getResources().getColor(p.b.BW_0_Alpha_0_1_5));
      AppMethodBeat.o(362351);
      return;
      label504:
      localObject3 = this.Etr;
      if (localObject3 != null) {
        ((ViewFlipper)localObject3).setVisibility(0);
      }
      localObject3 = this.Etu;
      if (localObject3 != null) {
        ((RoundedCornerFrameLayout)localObject3).setVisibility(8);
      }
      if (localRoundedCornerFrameLayout != null) {
        localRoundedCornerFrameLayout.setMarginEnd((int)getContext().getResources().getDimension(p.c.Edge_2A));
      }
      eBx();
    }
    label565:
    AppMethodBeat.o(362351);
  }
  
  public final HashMap<String, Bitmap> getBitmapCache()
  {
    return this.Etw;
  }
  
  public final com.tencent.mm.plugin.finder.live.model.b getJumpInfo()
  {
    return this.Etp;
  }
  
  public final c getListener()
  {
    return this.Eto;
  }
  
  public final ViewFlipper getLoopBannerViewFlipper()
  {
    return this.Etr;
  }
  
  public final ArrayList<com.tencent.mm.plugin.finder.live.model.b> getLoopDataList()
  {
    return this.Etq;
  }
  
  public final int getLoopDisplayIndex()
  {
    AppMethodBeat.i(362387);
    if (this.Etq.isEmpty())
    {
      AppMethodBeat.o(362387);
      return -1;
    }
    if (this.Etq.size() == 1)
    {
      AppMethodBeat.o(362387);
      return 0;
    }
    if (this.Etr != null)
    {
      Object localObject = this.Etr;
      if (localObject == null) {}
      for (localObject = null; localObject == null; localObject = Integer.valueOf(((ViewFlipper)localObject).getDisplayedChild()))
      {
        localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(362387);
        throw ((Throwable)localObject);
      }
      int i = ((Integer)localObject).intValue();
      AppMethodBeat.o(362387);
      return i;
    }
    AppMethodBeat.o(362387);
    return -1;
  }
  
  public final RoundedCornerFrameLayout getSidebarLayout()
  {
    return this.Etu;
  }
  
  public final TextView getSidebarTv()
  {
    return this.Etv;
  }
  
  public final FinderLivePromoteBannerWidget.a getStatus()
  {
    return this.Ett;
  }
  
  public final HashMap<String, b> getViewHolderCache()
  {
    return this.Ets;
  }
  
  public final void setBitmapCache(HashMap<String, Bitmap> paramHashMap)
  {
    AppMethodBeat.i(362325);
    s.u(paramHashMap, "<set-?>");
    this.Etw = paramHashMap;
    AppMethodBeat.o(362325);
  }
  
  public final void setJumpInfo(com.tencent.mm.plugin.finder.live.model.b paramb)
  {
    this.Etp = paramb;
  }
  
  public final void setListener(c paramc)
  {
    this.Eto = paramc;
  }
  
  public final void setLoopBannerViewFlipper(ViewFlipper paramViewFlipper)
  {
    this.Etr = paramViewFlipper;
  }
  
  public final void setLoopDataList(ArrayList<com.tencent.mm.plugin.finder.live.model.b> paramArrayList)
  {
    AppMethodBeat.i(362249);
    s.u(paramArrayList, "<set-?>");
    this.Etq = paramArrayList;
    AppMethodBeat.o(362249);
  }
  
  public final void setSidebarLayout(RoundedCornerFrameLayout paramRoundedCornerFrameLayout)
  {
    this.Etu = paramRoundedCornerFrameLayout;
  }
  
  public final void setSidebarTv(TextView paramTextView)
  {
    this.Etv = paramTextView;
  }
  
  public final void setStatus(FinderLivePromoteBannerWidget.a parama)
  {
    AppMethodBeat.i(362294);
    s.u(parama, "<set-?>");
    this.Ett = parama;
    AppMethodBeat.o(362294);
  }
  
  public final void setViewHolderCache(HashMap<String, b> paramHashMap)
  {
    AppMethodBeat.i(362277);
    s.u(paramHashMap, "<set-?>");
    this.Ets = paramHashMap;
    AppMethodBeat.o(362277);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePromoteBannerWidget$LoopBannerViewHolder;", "", "(Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePromoteBannerWidget;)V", "bgImg", "Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "getBgImg", "()Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;", "setBgImg", "(Lcom/tencent/mm/ui/widget/MMRoundCornerImageView;)V", "container", "Landroid/widget/LinearLayout;", "getContainer", "()Landroid/widget/LinearLayout;", "setContainer", "(Landroid/widget/LinearLayout;)V", "dislikeContainer", "getDislikeContainer", "setDislikeContainer", "normalLayout", "Landroid/view/View;", "getNormalLayout", "()Landroid/view/View;", "setNormalLayout", "(Landroid/view/View;)V", "root", "getRoot", "setRoot", "titleTV", "Landroid/widget/TextView;", "getTitleTV", "()Landroid/widget/TextView;", "setTitleTV", "(Landroid/widget/TextView;)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
  {
    public LinearLayout Api;
    public View EtB;
    MMRoundCornerImageView EtC;
    public LinearLayout EtD;
    View lBX;
    TextView pJJ;
    
    public b()
    {
      AppMethodBeat.i(361500);
      AppMethodBeat.o(361500);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/widget/FinderLivePromoteBannerWidget$OnClickListener;", "", "onClick", "", "jumpInfo", "Lcom/tencent/mm/plugin/finder/live/model/FinderBannerJumpInfo;", "onDislike", "onFlipperToIndex", "index", "", "onLongClick", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface c
  {
    public abstract void a(com.tencent.mm.plugin.finder.live.model.b paramb);
    
    public abstract void a(com.tencent.mm.plugin.finder.live.model.b paramb, int paramInt);
    
    public abstract void b(com.tencent.mm.plugin.finder.live.model.b paramb);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLivePromoteBannerWidget$doDislikeBanner$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "p0", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements Animation.AnimationListener
  {
    public d(FinderLivePromoteBannerWidget.b paramb, FinderLivePromoteBannerWidget paramFinderLivePromoteBannerWidget, com.tencent.mm.plugin.finder.live.model.b paramb1, ah.f<String> paramf, boolean paramBoolean) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(361481);
      paramAnimation = this.EtF;
      if (paramAnimation == null) {}
      com.tencent.mm.plugin.finder.live.model.b localb;
      for (paramAnimation = null;; paramAnimation = paramAnimation.lBX)
      {
        if (paramAnimation != null) {
          paramAnimation.setVisibility(8);
        }
        paramAnimation = (Collection)this.EtE.getLoopDataList();
        localb = this.DhU;
        if (paramAnimation != null) {
          break;
        }
        paramAnimation = new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
        AppMethodBeat.o(361481);
        throw paramAnimation;
      }
      if (!an.hA(paramAnimation).remove(localb)) {
        this.EtE.ayD((String)this.vVc.aqH);
      }
      if (this.EtE.getLoopDataList().size() >= 2) {
        if (this.EtG) {
          this.EtE.eBt();
        }
      }
      for (;;)
      {
        d.a(2000L, (kotlin.g.a.a)new a(this.EtE, this.EtF));
        AppMethodBeat.o(361481);
        return;
        if (this.EtE.getLoopDataList().size() == 1)
        {
          paramAnimation = this.EtE.getLoopBannerViewFlipper();
          if (paramAnimation != null) {
            paramAnimation.showNext();
          }
          this.EtE.setStatus(FinderLivePromoteBannerWidget.a.Etz);
        }
      }
    }
    
    public final void onAnimationRepeat(Animation paramAnimation) {}
    
    public final void onAnimationStart(Animation paramAnimation) {}
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(FinderLivePromoteBannerWidget paramFinderLivePromoteBannerWidget, FinderLivePromoteBannerWidget.b paramb)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLivePromoteBannerWidget$initLoopBannerFlipper$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "p0", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements Animation.AnimationListener
  {
    e(FinderLivePromoteBannerWidget paramFinderLivePromoteBannerWidget) {}
    
    public final void onAnimationEnd(Animation paramAnimation)
    {
      AppMethodBeat.i(361460);
      int i = this.EtE.getLoopDisplayIndex();
      if ((this.EtE.getListener() != null) && (i < this.EtE.getLoopDataList().size()) && (i >= 0))
      {
        paramAnimation = this.EtE.getListener();
        if (paramAnimation != null)
        {
          Object localObject = this.EtE.getLoopDataList().get(i);
          s.s(localObject, "loopDataList[index]");
          paramAnimation.a((com.tencent.mm.plugin.finder.live.model.b)localObject, i);
        }
      }
      AppMethodBeat.o(361460);
    }
    
    public final void onAnimationRepeat(Animation paramAnimation) {}
    
    public final void onAnimationStart(Animation paramAnimation) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/widget/FinderLivePromoteBannerWidget$initLoopBannerFlipper$2", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "p0", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements Animation.AnimationListener
  {
    public final void onAnimationEnd(Animation paramAnimation) {}
    
    public final void onAnimationRepeat(Animation paramAnimation) {}
    
    public final void onAnimationStart(Animation paramAnimation) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(FinderLivePromoteBannerWidget.b paramb, FinderLivePromoteBannerWidget paramFinderLivePromoteBannerWidget, ah.f<String> paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.widget.FinderLivePromoteBannerWidget
 * JD-Core Version:    0.7.0.1
 */