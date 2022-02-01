package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.v;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.a.c;
import com.tencent.mm.plugin.appbrand.appusage.a.d;
import com.tencent.mm.plugin.appbrand.appusage.a.d.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.protocal.protobuf.chm;
import d.f;
import d.g.a.m;
import d.g.b.u;
import d.g.b.w;
import d.l;
import d.v;
import d.y;
import java.text.DecimalFormat;
import java.util.LinkedList;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "df", "Ljava/text/DecimalFormat;", "getDf", "()Ljava/text/DecimalFormat;", "setDf", "(Ljava/text/DecimalFormat;)V", "isEmptyList", "", "()Z", "onBindView", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "", "", "getOnBindView", "()Lkotlin/jvm/functions/Function2;", "setOnBindView", "(Lkotlin/jvm/functions/Function2;)V", "onClickContent", "getOnClickContent", "setOnClickContent", "onClickFooter", "getOnClickFooter", "setOnClickFooter", "wxaList", "Ljava/util/LinkedList;", "getWxaList", "()Ljava/util/LinkedList;", "wxaList$delegate", "Lkotlin/Lazy;", "appendData", "data", "getData", "position", "getItemCount", "getItemId", "", "getItemViewType", "getRecommendStatObj", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandRecommendStatObj;", "attr", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "itemData", "pos", "jumpProfile", "context", "Landroid/content/Context;", "fromFooter", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAppNameViewMargin", "view", "Landroid/view/View;", "alignTop", "setData", "AppRecommendViewHolder", "AudioRecommendViewHolder", "BaseRecommendViewHolder", "BigVideoRecommendViewHolder", "Companion", "GoodsAppRecommendViewHolder", "ImageTextRecommendViewHolder", "VideoRecommendViewHolder", "WithContentDescViewHolder", "WithFooterViewHolder", "plugin-appbrand-integration_release"})
public final class a
  extends RecyclerView.a<c>
{
  public static final a.e lKc;
  final Activity activity;
  private DecimalFormat df;
  private final f lJY;
  m<? super chm, ? super Integer, y> lJZ;
  m<? super chm, ? super Integer, y> lKa;
  m<? super chm, ? super Integer, y> lKb;
  
  static
  {
    AppMethodBeat.i(51338);
    $$delegatedProperties = new d.l.k[] { (d.l.k)w.a(new u(w.bk(a.class), "wxaList", "getWxaList()Ljava/util/LinkedList;")) };
    lKc = new a.e((byte)0);
    AppMethodBeat.o(51338);
  }
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(51347);
    this.activity = paramActivity;
    this.lJY = d.g.E((d.g.a.a)a.r.lKx);
    this.lJZ = ((m)a.k.lKq);
    this.lKa = ((m)a.q.lKw);
    this.lKb = ((m)a.p.lKv);
    this.df = new DecimalFormat("0.00");
    AppMethodBeat.o(51347);
  }
  
  public static AppBrandRecommendStatObj a(WxaAttributes paramWxaAttributes, chm paramchm, int paramInt)
  {
    AppMethodBeat.i(51345);
    d.g.b.k.h(paramchm, "itemData");
    AppBrandRecommendStatObj localAppBrandRecommendStatObj = new AppBrandRecommendStatObj();
    localAppBrandRecommendStatObj.username = paramchm.DHP;
    localAppBrandRecommendStatObj.lpv = paramchm.lpv;
    localAppBrandRecommendStatObj.lpw = paramchm.lpw;
    if (paramWxaAttributes != null) {
      localAppBrandRecommendStatObj.dlB = paramWxaAttributes.field_appId;
    }
    localAppBrandRecommendStatObj.lpx = paramchm.lpx;
    localAppBrandRecommendStatObj.lpy = paramchm.lpy;
    localAppBrandRecommendStatObj.lpz = paramchm.lpz;
    localAppBrandRecommendStatObj.lpA = paramchm.lpA;
    localAppBrandRecommendStatObj.position = (paramInt + 1);
    localAppBrandRecommendStatObj.dqQ = c.aSm();
    localAppBrandRecommendStatObj.dpb = c.aSm();
    localAppBrandRecommendStatObj.sessionId = d.iWH.aSu().sessionId;
    AppMethodBeat.o(51345);
    return localAppBrandRecommendStatObj;
  }
  
  private static void a(Context paramContext, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(51343);
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramView, "view");
    Object localObject;
    if ((paramView instanceof TextView))
    {
      localObject = paramView.getLayoutParams();
      if (localObject == null)
      {
        paramContext = new v("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
        AppMethodBeat.o(51343);
        throw paramContext;
      }
      localObject = (ConstraintLayout.LayoutParams)localObject;
      if (localObject != null) {
        if (!paramBoolean) {
          break label97;
        }
      }
    }
    label97:
    for (((ConstraintLayout.LayoutParams)localObject).topMargin = paramContext.getResources().getDimensionPixelOffset(2131165837);; ((ConstraintLayout.LayoutParams)localObject).topMargin = paramContext.getResources().getDimensionPixelOffset(2131165836))
    {
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(51343);
      return;
    }
  }
  
  public final void a(Context paramContext, WxaAttributes paramWxaAttributes, chm paramchm, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(51344);
    d.g.b.k.h(paramContext, "context");
    d.g.b.k.h(paramchm, "itemData");
    String str = paramchm.lpv;
    if (!TextUtils.isEmpty((CharSequence)paramchm.lpw)) {
      str = paramchm.lpv + ":" + paramchm.lpw.toString();
    }
    WxaExposedParams.a locala = new WxaExposedParams.a();
    if (paramWxaAttributes != null)
    {
      locala.Gy(paramWxaAttributes.field_appId);
      locala.GA(paramWxaAttributes.field_nickname);
    }
    locala.Gz(paramchm.DHP);
    locala.GB(paramchm.Edb);
    locala.qT(12);
    paramWxaAttributes = a(paramWxaAttributes, paramchm, paramInt);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_recommend_stat_obj", (Parcelable)paramWxaAttributes);
    AppBrandProfileUI.a(paramContext, paramchm.DHP, 7, str, locala.aTV(), localBundle, null);
    if (paramBoolean)
    {
      this.lKa.n(paramchm, Integer.valueOf(paramInt));
      AppMethodBeat.o(51344);
      return;
    }
    this.lKb.n(paramchm, Integer.valueOf(paramInt));
    AppMethodBeat.o(51344);
  }
  
  final LinkedList<chm> bpS()
  {
    AppMethodBeat.i(51339);
    LinkedList localLinkedList = (LinkedList)this.lJY.getValue();
    AppMethodBeat.o(51339);
    return localLinkedList;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(51346);
    int i = bpS().size();
    AppMethodBeat.o(51346);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(51341);
    paramInt = ((chm)bpS().get(paramInt)).lpz;
    AppMethodBeat.o(51341);
    return paramInt;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AppRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "appName", "Landroid/widget/TextView;", "getAppName", "()Landroid/widget/TextView;", "contentDesc", "getContentDesc", "plugin-appbrand-integration_release"})
  public final class a
    extends a.c
  {
    final TextView lKd;
    final TextView lKe;
    
    public a()
    {
      super(localObject);
      AppMethodBeat.i(51317);
      this$1 = localObject.findViewById(2131296807);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…d_recommend_content_desc)");
      this.lKd = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296811);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…ecommend_footer_app_name)");
      this.lKe = ((TextView)a.this);
      AppMethodBeat.o(51317);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AudioRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "audioIcon", "Landroid/widget/ImageView;", "getAudioIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
  public class b
    extends a.i
  {
    final ImageView lKg;
    
    public b()
    {
      super(localObject);
      AppMethodBeat.i(51318);
      this$1 = localObject.findViewById(2131296816);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…rand_recommend_play_icon)");
      this.lKg = ((ImageView)a.this);
      AppMethodBeat.o(51318);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "content", "Landroid/view/ViewGroup;", "getContent", "()Landroid/view/ViewGroup;", "contentIcon", "Landroid/widget/ImageView;", "getContentIcon", "()Landroid/widget/ImageView;", "recommendReasonTv", "Landroid/widget/TextView;", "getRecommendReasonTv", "()Landroid/widget/TextView;", "plugin-appbrand-integration_release"})
  public class c
    extends RecyclerView.v
  {
    final ImageView lKh;
    final TextView lKi;
    final ViewGroup lKj;
    
    public c()
    {
      super();
      AppMethodBeat.i(51319);
      this$1 = localObject.findViewById(2131296808);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…d_recommend_content_icon)");
      this.lKh = ((ImageView)a.this);
      this$1 = localObject.findViewById(2131296818);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…p_brand_recommend_reason)");
      this.lKi = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296806);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…_brand_recommend_content)");
      this.lKj = ((ViewGroup)a.this);
      AppMethodBeat.o(51319);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BigVideoRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AudioRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "plugin-appbrand-integration_release"})
  public final class d
    extends a.b
  {
    public d()
    {
      super(localObject);
      AppMethodBeat.i(51320);
      AppMethodBeat.o(51320);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$GoodsAppRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "discountPrice", "Landroid/widget/TextView;", "getDiscountPrice", "()Landroid/widget/TextView;", "goodsName", "getGoodsName", "originPrice", "getOriginPrice", "plugin-appbrand-integration_release"})
  public final class f
    extends a.j
  {
    final TextView lKk;
    final TextView lKl;
    final TextView lKm;
    
    public f()
    {
      super(localObject);
      AppMethodBeat.i(51321);
      this$1 = localObject.findViewById(2131296814);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…and_recommend_goods_name)");
      this.lKk = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296809);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…recommend_discount_price)");
      this.lKl = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296815);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…d_recommend_origin_price)");
      this.lKm = ((TextView)a.this);
      AppMethodBeat.o(51321);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$ImageTextRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "plugin-appbrand-integration_release"})
  public final class g
    extends a.i
  {
    public g()
    {
      super(localObject);
      AppMethodBeat.i(51322);
      AppMethodBeat.o(51322);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$VideoRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "videoIcon", "Landroid/widget/ImageView;", "getVideoIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
  public final class h
    extends a.i
  {
    final ImageView lvj;
    
    public h()
    {
      super(localObject);
      AppMethodBeat.i(51323);
      this$1 = localObject.findViewById(2131296816);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…rand_recommend_play_icon)");
      this.lvj = ((ImageView)a.this);
      AppMethodBeat.o(51323);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "contentDesc", "Landroid/widget/TextView;", "getContentDesc", "()Landroid/widget/TextView;", "plugin-appbrand-integration_release"})
  public class i
    extends a.j
  {
    final TextView lKd;
    
    public i()
    {
      super(localObject);
      AppMethodBeat.i(51324);
      this$1 = localObject.findViewById(2131296807);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…d_recommend_content_desc)");
      this.lKd = ((TextView)a.this);
      AppMethodBeat.o(51324);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "footer", "Landroid/view/ViewGroup;", "getFooter", "()Landroid/view/ViewGroup;", "footerAppName", "Landroid/widget/TextView;", "getFooterAppName", "()Landroid/widget/TextView;", "footerIcon", "Landroid/widget/ImageView;", "getFooterIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
  public class j
    extends a.c
  {
    final ImageView lKn;
    final TextView lKo;
    final ViewGroup lKp;
    
    public j()
    {
      super(localObject);
      AppMethodBeat.i(51325);
      this$1 = localObject.findViewById(2131296813);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…nd_recommend_footer_icon)");
      this.lKn = ((ImageView)a.this);
      this$1 = localObject.findViewById(2131296811);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…ecommend_footer_app_name)");
      this.lKo = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296810);
      d.g.b.k.g(a.this, "itemView.findViewById(R.…p_brand_recommend_footer)");
      this.lKp = ((ViewGroup)a.this);
      AppMethodBeat.o(51325);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$1"})
  static final class l
    implements View.OnClickListener
  {
    l(a.c paramc, a parama, chm paramchm, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(51328);
      paramView = this.lKf;
      Object localObject = this.lKr.arI;
      d.g.b.k.g(localObject, "baseViewHolder.itemView");
      localObject = ((View)localObject).getContext();
      d.g.b.k.g(localObject, "baseViewHolder.itemView.context");
      paramView.a((Context)localObject, this.lKt, this.lKs, this.lKu, true);
      AppMethodBeat.o(51328);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$5"})
  static final class n
    implements View.OnClickListener
  {
    n(a.c paramc, a parama, chm paramchm, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(51330);
      if (this.lKs.lpz == 4)
      {
        paramView = this.lKf;
        localObject1 = this.lKr.arI;
        d.g.b.k.g(localObject1, "baseViewHolder.itemView");
        localObject1 = ((View)localObject1).getContext();
        d.g.b.k.g(localObject1, "baseViewHolder.itemView.context");
        paramView.a((Context)localObject1, this.lKt, this.lKs, this.lKu, false);
        AppMethodBeat.o(51330);
        return;
      }
      Object localObject1 = this.lKs.lpx;
      paramView = (View)localObject1;
      Object localObject2;
      if (this.lKs.lpy != null)
      {
        localObject2 = this.lKs.lpy;
        d.g.b.k.g(localObject2, "itemData.page_param");
        paramView = (View)localObject1;
        if (!d.n.n.aC((CharSequence)localObject2)) {
          paramView = (String)localObject1 + "?" + this.lKs.lpy;
        }
      }
      localObject1 = new AppBrandStatObject();
      ((AppBrandStatObject)localObject1).scene = 1118;
      ((AppBrandStatObject)localObject1).dzS = 14;
      if (!TextUtils.isEmpty((CharSequence)this.lKs.lpw)) {
        ((AppBrandStatObject)localObject1).dbt = (this.lKs.lpv + ":" + this.lKs.lpw.toString());
      }
      for (((AppBrandStatObject)localObject1).dzT = (this.lKs.lpv + ":" + this.lKs.lpw.toString());; ((AppBrandStatObject)localObject1).dzT = this.lKs.lpv)
      {
        ((AppBrandStatObject)localObject1).lpN = a.a(this.lKt, this.lKs, this.lKu);
        if (this.lKt != null)
        {
          localObject2 = this.lKt;
          if (localObject2 != null)
          {
            localObject2 = ((WxaAttributes)localObject2).aTP();
            if (localObject2 != null)
            {
              int i = ((WxaAttributes.WxaVersionInfo)localObject2).aAS;
              ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.appbrand.service.n.class)).a(this.gxK, this.lKs.DHP, this.lKt.field_appId, 0, i, paramView, (AppBrandStatObject)localObject1);
            }
          }
        }
        this.lKf.lKb.n(this.lKs, Integer.valueOf(this.lKu));
        AppMethodBeat.o(51330);
        return;
        ((AppBrandStatObject)localObject1).dbt = this.lKs.lpv;
      }
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$6"})
  static final class o
    implements View.OnLongClickListener
  {
    o(a parama, chm paramchm, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(51331);
      com.tencent.mm.pluginsdk.g.a.b((CharSequence)"", (CharSequence)(this.lKs.lpv.toString() + "," + this.lKs.Eda + "," + this.lKs.DHP));
      AppMethodBeat.o(51331);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.a
 * JD-Core Version:    0.7.0.1
 */