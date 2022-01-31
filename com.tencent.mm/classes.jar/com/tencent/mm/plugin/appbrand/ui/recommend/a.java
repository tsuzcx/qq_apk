package com.tencent.mm.plugin.appbrand.ui.recommend;

import a.f;
import a.f.a.m;
import a.f.b.j;
import a.f.b.t;
import a.g;
import a.j.k;
import a.l;
import a.y;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.a.c;
import com.tencent.mm.plugin.appbrand.appusage.a.d;
import com.tencent.mm.plugin.appbrand.appusage.a.d.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandRecommendStatObj;
import com.tencent.mm.plugin.appbrand.ui.AppBrandProfileUI;
import com.tencent.mm.protocal.protobuf.bsi;
import java.text.DecimalFormat;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/plugin/appbrand/ui/recommend/AppBrandRecommendAdapter$BaseRecommendViewHolder;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "df", "Ljava/text/DecimalFormat;", "getDf", "()Ljava/text/DecimalFormat;", "setDf", "(Ljava/text/DecimalFormat;)V", "isEmptyList", "", "()Z", "onBindView", "Lkotlin/Function2;", "Lcom/tencent/mm/protocal/protobuf/RecommendCard;", "", "", "getOnBindView", "()Lkotlin/jvm/functions/Function2;", "setOnBindView", "(Lkotlin/jvm/functions/Function2;)V", "onClickContent", "getOnClickContent", "setOnClickContent", "onClickFooter", "getOnClickFooter", "setOnClickFooter", "wxaList", "Ljava/util/LinkedList;", "getWxaList", "()Ljava/util/LinkedList;", "wxaList$delegate", "Lkotlin/Lazy;", "appendData", "data", "getData", "position", "getItemCount", "getItemId", "", "getItemViewType", "getRecommendStatObj", "Lcom/tencent/mm/plugin/appbrand/report/AppBrandRecommendStatObj;", "attr", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "itemData", "pos", "jumpProfile", "context", "Landroid/content/Context;", "fromFooter", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setAppNameViewMargin", "view", "Landroid/view/View;", "alignTop", "setData", "AppRecommendViewHolder", "AudioRecommendViewHolder", "BaseRecommendViewHolder", "BigVideoRecommendViewHolder", "Companion", "GoodsAppRecommendViewHolder", "ImageTextRecommendViewHolder", "VideoRecommendViewHolder", "WithContentDescViewHolder", "WithFooterViewHolder", "plugin-appbrand-integration_release"})
public final class a
  extends RecyclerView.a<a.c>
{
  public static final a.e iVQ;
  final Activity activity;
  private DecimalFormat df;
  private final f iVM;
  m<? super bsi, ? super Integer, y> iVN;
  m<? super bsi, ? super Integer, y> iVO;
  m<? super bsi, ? super Integer, y> iVP;
  
  static
  {
    AppMethodBeat.i(135172);
    eOJ = new k[] { (k)a.f.b.v.a(new t(a.f.b.v.aG(a.class), "wxaList", "getWxaList()Ljava/util/LinkedList;")) };
    iVQ = new a.e((byte)0);
    AppMethodBeat.o(135172);
  }
  
  public a(Activity paramActivity)
  {
    AppMethodBeat.i(135181);
    this.activity = paramActivity;
    this.iVM = g.j((a.f.a.a)a.r.iWl);
    this.iVN = ((m)a.k.iWe);
    this.iVO = ((m)a.q.iWk);
    this.iVP = ((m)a.p.iWj);
    this.df = new DecimalFormat("0.00");
    AppMethodBeat.o(135181);
  }
  
  public static AppBrandRecommendStatObj a(WxaAttributes paramWxaAttributes, bsi parambsi, int paramInt)
  {
    AppMethodBeat.i(135179);
    j.q(parambsi, "itemData");
    AppBrandRecommendStatObj localAppBrandRecommendStatObj = new AppBrandRecommendStatObj();
    localAppBrandRecommendStatObj.username = parambsi.xFL;
    localAppBrandRecommendStatObj.iFH = parambsi.iFH;
    localAppBrandRecommendStatObj.iFI = parambsi.iFI;
    if (paramWxaAttributes != null) {
      localAppBrandRecommendStatObj.cwc = paramWxaAttributes.field_appId;
    }
    localAppBrandRecommendStatObj.iFJ = parambsi.iFJ;
    localAppBrandRecommendStatObj.iFK = parambsi.iFK;
    localAppBrandRecommendStatObj.iFL = parambsi.iFL;
    localAppBrandRecommendStatObj.iFM = parambsi.iFM;
    localAppBrandRecommendStatObj.position = (paramInt + 1);
    localAppBrandRecommendStatObj.cAH = c.getLongitude();
    localAppBrandRecommendStatObj.cyV = c.getLongitude();
    localAppBrandRecommendStatObj.sessionId = d.hdr.axR().sessionId;
    AppMethodBeat.o(135179);
    return localAppBrandRecommendStatObj;
  }
  
  private static void a(Context paramContext, View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(135177);
    j.q(paramContext, "context");
    j.q(paramView, "view");
    Object localObject;
    if ((paramView instanceof TextView))
    {
      localObject = paramView.getLayoutParams();
      if (localObject == null)
      {
        paramContext = new a.v("null cannot be cast to non-null type android.support.constraint.ConstraintLayout.LayoutParams");
        AppMethodBeat.o(135177);
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
    for (((ConstraintLayout.LayoutParams)localObject).topMargin = paramContext.getResources().getDimensionPixelOffset(2131428064);; ((ConstraintLayout.LayoutParams)localObject).topMargin = paramContext.getResources().getDimensionPixelOffset(2131428063))
    {
      paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(135177);
      return;
    }
  }
  
  public final void a(Context paramContext, WxaAttributes paramWxaAttributes, bsi parambsi, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(138703);
    j.q(paramContext, "context");
    j.q(parambsi, "itemData");
    String str = parambsi.iFH;
    if (!TextUtils.isEmpty((CharSequence)parambsi.iFI)) {
      str = parambsi.iFH + ":" + parambsi.iFI.toString();
    }
    WxaExposedParams.a locala = new WxaExposedParams.a();
    if (paramWxaAttributes != null)
    {
      locala.AG(paramWxaAttributes.field_appId);
      locala.AI(paramWxaAttributes.field_nickname);
    }
    locala.AH(parambsi.xFL);
    locala.AJ(parambsi.xFS);
    locala.nz(12);
    paramWxaAttributes = a(paramWxaAttributes, parambsi, paramInt);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("key_recommend_stat_obj", (Parcelable)paramWxaAttributes);
    AppBrandProfileUI.a(paramContext, parambsi.xFL, 7, str, locala.ayJ(), localBundle, null);
    if (paramBoolean)
    {
      this.iVO.h(parambsi, Integer.valueOf(paramInt));
      AppMethodBeat.o(138703);
      return;
    }
    this.iVP.h(parambsi, Integer.valueOf(paramInt));
    AppMethodBeat.o(138703);
  }
  
  final LinkedList<bsi> aNz()
  {
    AppMethodBeat.i(135173);
    LinkedList localLinkedList = (LinkedList)this.iVM.getValue();
    AppMethodBeat.o(135173);
    return localLinkedList;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(135180);
    int i = aNz().size();
    AppMethodBeat.o(135180);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(135175);
    paramInt = ((bsi)aNz().get(paramInt)).iFL;
    AppMethodBeat.o(135175);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.recommend.a
 * JD-Core Version:    0.7.0.1
 */