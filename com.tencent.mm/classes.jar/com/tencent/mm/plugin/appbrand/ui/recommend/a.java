package com.tencent.mm.plugin.appbrand.ui.recommend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.appusage.a.c;
import com.tencent.mm.plugin.appbrand.appusage.a.d;
import com.tencent.mm.plugin.appbrand.appusage.a.d.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.service.o;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.protocal.protobuf.crr;
import d.f;
import d.g.a.m;
import d.g.b.p;
import d.l;
import d.n.n;
import d.v;
import d.z;
import java.text.DecimalFormat;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "df", "Ljava/text/DecimalFormat;", "getDf", "()Ljava/text/DecimalFormat;", "setDf", "(Ljava/text/DecimalFormat;)V", "isEmptyList", "", "()Z", "onBindView", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "", "", "getOnBindView", "()Lkotlin/jvm/functions/Function2;", "setOnBindView", "(Lkotlin/jvm/functions/Function2;)V", "onClickContent", "getOnClickContent", "setOnClickContent", "onClickFooter", "getOnClickFooter", "setOnClickFooter", "wxaList", "Ljava/util/LinkedList;", "getWxaList", "()Ljava/util/LinkedList;", "wxaList$delegate", "Lkotlin/Lazy;", "appendData", "data", "getData", "position", "getItemCount", "getItemId", "", "getItemViewType", "getRecommendStatObj", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandRecommendStatObj;", "attr", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "itemData", "pos", "jumpProfile", "context", "Landroid/content/Context;", "fromFooter", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAppNameViewMargin", "view", "Landroid/view/View;", "alignTop", "setData", "AppRecommendViewHolder", "AudioRecommendViewHolder", "BaseRecommendViewHolder", "BigVideoRecommendViewHolder", "Companion", "GoodsAppRecommendViewHolder", "ImageTextRecommendViewHolder", "VideoRecommendViewHolder", "WithContentDescViewHolder", "WithFooterViewHolder", "plugin-appbrand-integration_release"})
public final class a
  extends RecyclerView.a<c>
{
  public static final a.e mMB;
  final Activity activity;
  private DecimalFormat df;
  m<? super crr, ? super Integer, z> mMA;
  private final f mMx;
  m<? super crr, ? super Integer, z> mMy;
  m<? super crr, ? super Integer, z> mMz;
  
  static
  {
    AppMethodBeat.i(51338);
    mMB = new a.e((byte)0);
    AppMethodBeat.o(51338);
  }
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(51347);
    this.activity = paramActivity;
    this.mMx = d.g.O((d.g.a.a)a.r.mMW);
    this.mMy = ((m)a.k.mMP);
    this.mMz = ((m)a.q.mMV);
    this.mMA = ((m)a.p.mMU);
    this.df = new DecimalFormat("0.00");
    AppMethodBeat.o(51347);
  }
  
  public static AppBrandRecommendStatObj a(WxaAttributes paramWxaAttributes, crr paramcrr, int paramInt)
  {
    AppMethodBeat.i(51345);
    p.h(paramcrr, "itemData");
    AppBrandRecommendStatObj localAppBrandRecommendStatObj = new AppBrandRecommendStatObj();
    localAppBrandRecommendStatObj.username = paramcrr.GMM;
    localAppBrandRecommendStatObj.mrh = paramcrr.mrh;
    localAppBrandRecommendStatObj.mri = paramcrr.mri;
    if (paramWxaAttributes != null) {
      localAppBrandRecommendStatObj.duW = paramWxaAttributes.field_appId;
    }
    localAppBrandRecommendStatObj.mrj = paramcrr.mrj;
    localAppBrandRecommendStatObj.mrk = paramcrr.mrk;
    localAppBrandRecommendStatObj.mrl = paramcrr.mrl;
    localAppBrandRecommendStatObj.mrm = paramcrr.mrm;
    localAppBrandRecommendStatObj.position = (paramInt + 1);
    localAppBrandRecommendStatObj.dAp = c.bcH();
    localAppBrandRecommendStatObj.dyz = c.bcH();
    localAppBrandRecommendStatObj.sessionId = d.jQT.bcP().sessionId;
    AppMethodBeat.o(51345);
    return localAppBrandRecommendStatObj;
  }
  
  private static void a(Context paramContext, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(51343);
    p.h(paramContext, "context");
    p.h(paramView, "view");
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
  
  public final void a(Context paramContext, WxaAttributes paramWxaAttributes, crr paramcrr, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(51344);
    p.h(paramContext, "context");
    p.h(paramcrr, "itemData");
    String str = paramcrr.mrh;
    if (!TextUtils.isEmpty((CharSequence)paramcrr.mri)) {
      str = paramcrr.mrh + ":" + paramcrr.mri.toString();
    }
    WxaExposedParams.a locala = new WxaExposedParams.a();
    if (paramWxaAttributes != null)
    {
      locala.NV(paramWxaAttributes.field_appId);
      locala.NX(paramWxaAttributes.field_nickname);
    }
    locala.NW(paramcrr.GMM);
    locala.NY(paramcrr.Hkh);
    locala.si(12);
    paramWxaAttributes = a(paramWxaAttributes, paramcrr, paramInt);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_recommend_stat_obj", (Parcelable)paramWxaAttributes);
    AppBrandProfileUI.a(paramContext, paramcrr.GMM, 7, str, locala.bet(), localBundle, null);
    if (paramBoolean)
    {
      this.mMz.p(paramcrr, Integer.valueOf(paramInt));
      AppMethodBeat.o(51344);
      return;
    }
    this.mMA.p(paramcrr, Integer.valueOf(paramInt));
    AppMethodBeat.o(51344);
  }
  
  final LinkedList<crr> bAV()
  {
    AppMethodBeat.i(51339);
    LinkedList localLinkedList = (LinkedList)this.mMx.getValue();
    AppMethodBeat.o(51339);
    return localLinkedList;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(51346);
    int i = bAV().size();
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
    paramInt = ((crr)bAV().get(paramInt)).mrl;
    AppMethodBeat.o(51341);
    return paramInt;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AppRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "appName", "Landroid/widget/TextView;", "getAppName", "()Landroid/widget/TextView;", "contentDesc", "getContentDesc", "plugin-appbrand-integration_release"})
  public final class a
    extends a.c
  {
    final TextView mMC;
    final TextView mMD;
    
    public a()
    {
      super(localObject);
      AppMethodBeat.i(51317);
      this$1 = localObject.findViewById(2131296807);
      p.g(a.this, "itemView.findViewById(R.…d_recommend_content_desc)");
      this.mMC = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296811);
      p.g(a.this, "itemView.findViewById(R.…ecommend_footer_app_name)");
      this.mMD = ((TextView)a.this);
      AppMethodBeat.o(51317);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AudioRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "audioIcon", "Landroid/widget/ImageView;", "getAudioIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
  public class b
    extends a.i
  {
    final ImageView mMF;
    
    public b()
    {
      super(localObject);
      AppMethodBeat.i(51318);
      this$1 = localObject.findViewById(2131296816);
      p.g(a.this, "itemView.findViewById(R.…rand_recommend_play_icon)");
      this.mMF = ((ImageView)a.this);
      AppMethodBeat.o(51318);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "content", "Landroid/view/ViewGroup;", "getContent", "()Landroid/view/ViewGroup;", "contentIcon", "Landroid/widget/ImageView;", "getContentIcon", "()Landroid/widget/ImageView;", "recommendReasonTv", "Landroid/widget/TextView;", "getRecommendReasonTv", "()Landroid/widget/TextView;", "plugin-appbrand-integration_release"})
  public class c
    extends RecyclerView.w
  {
    final ImageView mMG;
    final TextView mMH;
    final ViewGroup mMI;
    
    public c()
    {
      super();
      AppMethodBeat.i(51319);
      this$1 = localObject.findViewById(2131296808);
      p.g(a.this, "itemView.findViewById(R.…d_recommend_content_icon)");
      this.mMG = ((ImageView)a.this);
      this$1 = localObject.findViewById(2131296818);
      p.g(a.this, "itemView.findViewById(R.…p_brand_recommend_reason)");
      this.mMH = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296806);
      p.g(a.this, "itemView.findViewById(R.…_brand_recommend_content)");
      this.mMI = ((ViewGroup)a.this);
      AppMethodBeat.o(51319);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BigVideoRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$AudioRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "plugin-appbrand-integration_release"})
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$GoodsAppRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "discountPrice", "Landroid/widget/TextView;", "getDiscountPrice", "()Landroid/widget/TextView;", "goodsName", "getGoodsName", "originPrice", "getOriginPrice", "plugin-appbrand-integration_release"})
  public final class f
    extends a.j
  {
    final TextView mMJ;
    final TextView mMK;
    final TextView mML;
    
    public f()
    {
      super(localObject);
      AppMethodBeat.i(51321);
      this$1 = localObject.findViewById(2131296814);
      p.g(a.this, "itemView.findViewById(R.…and_recommend_goods_name)");
      this.mMJ = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296809);
      p.g(a.this, "itemView.findViewById(R.…recommend_discount_price)");
      this.mMK = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296815);
      p.g(a.this, "itemView.findViewById(R.…d_recommend_origin_price)");
      this.mML = ((TextView)a.this);
      AppMethodBeat.o(51321);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$ImageTextRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "plugin-appbrand-integration_release"})
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$VideoRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "videoIcon", "Landroid/widget/ImageView;", "getVideoIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
  public final class h
    extends a.i
  {
    final ImageView mwS;
    
    public h()
    {
      super(localObject);
      AppMethodBeat.i(51323);
      this$1 = localObject.findViewById(2131296816);
      p.g(a.this, "itemView.findViewById(R.…rand_recommend_play_icon)");
      this.mwS = ((ImageView)a.this);
      AppMethodBeat.o(51323);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithContentDescViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "contentDesc", "Landroid/widget/TextView;", "getContentDesc", "()Landroid/widget/TextView;", "plugin-appbrand-integration_release"})
  public class i
    extends a.j
  {
    final TextView mMC;
    
    public i()
    {
      super(localObject);
      AppMethodBeat.i(51324);
      this$1 = localObject.findViewById(2131296807);
      p.g(a.this, "itemView.findViewById(R.…d_recommend_content_desc)");
      this.mMC = ((TextView)a.this);
      AppMethodBeat.o(51324);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$WithFooterViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "itemView", "Landroid/view/View;", "(Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;Landroid/view/View;)V", "footer", "Landroid/view/ViewGroup;", "getFooter", "()Landroid/view/ViewGroup;", "footerAppName", "Landroid/widget/TextView;", "getFooterAppName", "()Landroid/widget/TextView;", "footerIcon", "Landroid/widget/ImageView;", "getFooterIcon", "()Landroid/widget/ImageView;", "plugin-appbrand-integration_release"})
  public class j
    extends a.c
  {
    final ImageView mMM;
    final TextView mMN;
    final ViewGroup mMO;
    
    public j()
    {
      super(localObject);
      AppMethodBeat.i(51325);
      this$1 = localObject.findViewById(2131296813);
      p.g(a.this, "itemView.findViewById(R.…nd_recommend_footer_icon)");
      this.mMM = ((ImageView)a.this);
      this$1 = localObject.findViewById(2131296811);
      p.g(a.this, "itemView.findViewById(R.…ecommend_footer_app_name)");
      this.mMN = ((TextView)a.this);
      this$1 = localObject.findViewById(2131296810);
      p.g(a.this, "itemView.findViewById(R.…p_brand_recommend_footer)");
      this.mMO = ((ViewGroup)a.this);
      AppMethodBeat.o(51325);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$1"})
  static final class l
    implements View.OnClickListener
  {
    l(a.c paramc, a parama, crr paramcrr, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(51328);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
      paramView = this.mME;
      localObject = this.mMQ.auu;
      p.g(localObject, "baseViewHolder.itemView");
      localObject = ((View)localObject).getContext();
      p.g(localObject, "baseViewHolder.itemView.context");
      paramView.a((Context)localObject, this.mMS, this.mMR, this.mMT, true);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(51328);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$4"})
  static final class m
    implements View.OnClickListener
  {
    m(a parama, crr paramcrr, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(51329);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
      localObject = new Intent((Context)this.mME.activity, AppBrandRecommendVideoUI.class);
      ((Intent)localObject).putExtra("1", this.mMR.Hkb);
      paramView = this.mME.activity;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      this.mME.mMA.p(this.mMR, Integer.valueOf(this.mMT));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(51329);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$5"})
  static final class n
    implements View.OnClickListener
  {
    n(a.c paramc, a parama, crr paramcrr, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(51330);
      Object localObject1 = new b();
      ((b)localObject1).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).ahq());
      if (this.mMR.mrl == 4)
      {
        paramView = this.mME;
        localObject1 = this.mMQ.auu;
        p.g(localObject1, "baseViewHolder.itemView");
        localObject1 = ((View)localObject1).getContext();
        p.g(localObject1, "baseViewHolder.itemView.context");
        paramView.a((Context)localObject1, this.mMS, this.mMR, this.mMT, false);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(51330);
        return;
      }
      localObject1 = this.mMR.mrj;
      paramView = (View)localObject1;
      Object localObject2;
      if (this.mMR.mrk != null)
      {
        localObject2 = this.mMR.mrk;
        p.g(localObject2, "itemData.page_param");
        paramView = (View)localObject1;
        if (!n.aE((CharSequence)localObject2)) {
          paramView = (String)localObject1 + "?" + this.mMR.mrk;
        }
      }
      localObject1 = new AppBrandStatObject();
      ((AppBrandStatObject)localObject1).scene = 1118;
      ((AppBrandStatObject)localObject1).dJQ = 14;
      if (!TextUtils.isEmpty((CharSequence)this.mMR.mri)) {
        ((AppBrandStatObject)localObject1).dkh = (this.mMR.mrh + ":" + this.mMR.mri.toString());
      }
      for (((AppBrandStatObject)localObject1).dJR = (this.mMR.mrh + ":" + this.mMR.mri.toString());; ((AppBrandStatObject)localObject1).dJR = this.mMR.mrh)
      {
        ((AppBrandStatObject)localObject1).mrz = a.a(this.mMS, this.mMR, this.mMT);
        if (this.mMS != null)
        {
          localObject2 = this.mMS;
          if (localObject2 != null)
          {
            localObject2 = ((WxaAttributes)localObject2).ben();
            if (localObject2 != null)
            {
              int i = ((WxaAttributes.WxaVersionInfo)localObject2).aDD;
              ((o)com.tencent.mm.kernel.g.ab(o.class)).a(this.hqo, this.mMR.GMM, this.mMS.field_appId, 0, i, paramView, (AppBrandStatObject)localObject1);
            }
          }
        }
        this.mME.mMA.p(this.mMR, Integer.valueOf(this.mMT));
        break;
        ((AppBrandStatObject)localObject1).dkh = this.mMR.mrh;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick", "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$1$6"})
  static final class o
    implements View.OnLongClickListener
  {
    o(a parama, crr paramcrr, WxaAttributes paramWxaAttributes, int paramInt, Context paramContext) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(51331);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
      com.tencent.mm.pluginsdk.i.a.b((CharSequence)"", (CharSequence)(this.mMR.mrh.toString() + "," + this.mMR.Hkg + "," + this.mMR.GMM));
      com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$onBindViewHolder$$inlined$let$lambda$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(51331);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.a
 * JD-Core Version:    0.7.0.1
 */