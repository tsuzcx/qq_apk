package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.ui.FinderPoiFeedUI;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC.a;
import com.tencent.mm.protocal.protobuf.dck;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout.c;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import kotlin.a.j;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiFeedUI;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/plugin/finder/feed/ui/FinderPoiFeedUI;IIZ)V", "dynamicState", "", "getDynamicState", "()J", "setDynamicState", "(J)V", "poiCategories", "", "getPoiCategories", "()Ljava/lang/String;", "setPoiCategories", "(Ljava/lang/String;)V", "poiDetailReportStr", "getPoiDetailReportStr", "setPoiDetailReportStr", "poiHeader", "Landroid/view/View;", "poiSourceFlag", "getPoiSourceFlag", "()I", "setPoiSourceFlag", "(I)V", "configureTextView", "", "textView", "Landroid/widget/TextView;", "info", "resId", "onClick", "Lkotlin/Function0;", "(Landroid/widget/TextView;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "generatePhoneTextView", "phone", "tvTel", "getActivity", "Lcom/tencent/mm/ui/MMActivity;", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "Landroid/content/Context;", "getTitleStringId", "onGridItemClick", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "position", "onItemDelete", "refreshHeader", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "setClickSpan", "tv", "strAll", "strHighLight", "showHeaderOnDataEmpty", "Companion", "plugin-finder_release"})
public final class z$b
  extends c.b
{
  public static final a tPe;
  View tOZ;
  public String tPa;
  int tPb;
  public long tPc;
  public String tPd;
  
  static
  {
    AppMethodBeat.i(244035);
    tPe = new a((byte)0);
    AppMethodBeat.o(244035);
  }
  
  private z$b(FinderPoiFeedUI paramFinderPoiFeedUI, int paramInt)
  {
    super((MMActivity)paramFinderPoiFeedUI, 2, 81, false);
    AppMethodBeat.i(244034);
    this.tPa = "";
    this.tPd = "";
    AppMethodBeat.o(244034);
  }
  
  static void a(final TextView paramTextView, String paramString1, String paramString2, kotlin.g.a.a<x> parama)
  {
    int i = 0;
    AppMethodBeat.i(244033);
    int k = n.a((CharSequence)paramString1, paramString2, 0, false, 6);
    int j = paramString2.length() + k;
    if ((k <= 0) || (j > paramString1.length())) {
      j = paramString1.length();
    }
    for (;;)
    {
      paramString1 = new SpannableString((CharSequence)paramString1);
      paramString1.setSpan(new g(parama, paramTextView), i, j, 33);
      paramString2 = paramTextView.getContext();
      p.g(paramString2, "tv.context");
      paramTextView.setHighlightColor(paramString2.getResources().getColor(17170445));
      paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
      paramTextView.setText((CharSequence)paramString1);
      AppMethodBeat.o(244033);
      return;
      i = k;
    }
  }
  
  public final void a(RecyclerView.a<?> parama, View paramView, int paramInt)
  {
    AppMethodBeat.i(244024);
    p.h(parama, "adapter");
    p.h(paramView, "view");
    paramInt -= ((g)parama).RqM.size();
    if ((paramInt >= 0) && (paramInt < dcq().tFM.getSize()))
    {
      parama = (bo)dcq().tFM.getDataListJustForAdapter().get(paramInt);
      if (!(parama instanceof BaseFinderFeed))
      {
        AppMethodBeat.o(244024);
        return;
      }
      Log.i("Finder.FinderPoiFeedUIContract.PoiFeedViewCallback", "onClick " + paramInt + " id:" + ((BaseFinderFeed)parama).feedObject.getId() + ", pos:" + paramInt + ", nonceId:" + ((BaseFinderFeed)parama).feedObject.getObjectNonceId());
      paramView = new Intent();
      paramView.putExtra("FEED_ID", ((BaseFinderFeed)parama).feedObject.getId());
      paramView.putExtra("FEED_NONCE_ID", ((BaseFinderFeed)parama).feedObject.getObjectNonceId());
      paramView.putExtra("TITLE_WORDING", "");
      paramView.putExtra("GET_REL_SCENE", 17);
      BaseFeedLoader.saveCacheToIntent$default(dcq().tFM, paramView, j.listOf(parama), dcq().tFM.getLastBuffer(), 0, null, 16, null);
      Object localObject = com.tencent.mm.plugin.finder.utils.a.vUU;
      com.tencent.mm.plugin.finder.utils.a.W((Context)this.gte, paramView);
      paramView = FinderReporterUIC.wzC;
      paramView = FinderReporterUIC.a.fH((Context)this.gte);
      if (paramView != null)
      {
        paramView = paramView.dIx();
        if (paramView != null)
        {
          localObject = k.vfA;
          k.a(paramView, ((BaseFinderFeed)parama).feedObject.getId(), this.tLS.getRecyclerView());
          AppMethodBeat.o(244024);
          return;
        }
      }
    }
    AppMethodBeat.o(244024);
  }
  
  final void a(TextView paramTextView, String paramString, Integer paramInteger, kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(244031);
    if (Util.isNullOrNil(paramString))
    {
      if (paramTextView != null)
      {
        paramTextView.setVisibility(8);
        AppMethodBeat.o(244031);
        return;
      }
      AppMethodBeat.o(244031);
      return;
    }
    if (paramTextView != null) {
      paramTextView.setVisibility(0);
    }
    if (paramTextView != null)
    {
      if (paramInteger == null) {
        break label129;
      }
      int i = ((Number)paramInteger).intValue();
      paramInteger = this.gte.getString(i, new Object[] { paramString });
      if (paramInteger == null) {
        break label129;
      }
    }
    label129:
    for (paramInteger = (CharSequence)paramInteger;; paramInteger = (CharSequence)paramString)
    {
      paramTextView.setText(paramInteger);
      if (parama == null) {
        break;
      }
      if ((paramTextView != null) && (paramString != null)) {
        a(paramTextView, paramTextView.getText().toString(), paramString, parama);
      }
      AppMethodBeat.o(244031);
      return;
    }
    AppMethodBeat.o(244031);
  }
  
  public final String b(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(244029);
    p.h(paramc, "reason");
    AppMethodBeat.o(244029);
    return null;
  }
  
  public final String c(RefreshLoadMoreLayout.c<Object> paramc)
  {
    AppMethodBeat.i(244030);
    p.h(paramc, "reason");
    AppMethodBeat.o(244030);
    return null;
  }
  
  public final boolean dcu()
  {
    return true;
  }
  
  public final void dcv() {}
  
  public final RecyclerView.LayoutManager eS(Context paramContext)
  {
    AppMethodBeat.i(244025);
    p.h(paramContext, "context");
    paramContext = dcs().eS(paramContext);
    AppMethodBeat.o(244025);
    return paramContext;
  }
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(244027);
    View localView = this.gte.findViewById(2131300111);
    AppMethodBeat.o(244027);
    return localView;
  }
  
  public final View getHeaderView()
  {
    AppMethodBeat.i(244028);
    this.tOZ = View.inflate((Context)this.gte, 2131494558, null);
    View localView = this.tOZ;
    AppMethodBeat.o(244028);
    return localView;
  }
  
  public final RecyclerView.h getItemDecoration()
  {
    AppMethodBeat.i(244026);
    RecyclerView.h localh = dcs().getItemDecoration();
    AppMethodBeat.o(244026);
    return localh;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$refreshHeader$1$addressOnClickListener$1"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(z.b paramb, IResponse paramIResponse)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "phone", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$refreshHeader$1$phoneOnClickListener$1"})
  static final class c
    extends q
    implements b<String, x>
  {
    c(z.b paramb, IResponse paramIResponse)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$refreshHeader$1$3$1", "com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$$special$$inlined$forEach$lambda$1"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(String paramString, TextView paramTextView, LinearLayout paramLinearLayout, b paramb, z.b paramb1, IResponse paramIResponse)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(b paramb, dck paramdck)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/FinderPoiFeedUIContract$PoiFeedViewCallback$setClickSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "plugin-finder_release"})
  public static final class g
    extends ClickableSpan
  {
    g(kotlin.g.a.a parama, TextView paramTextView) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(244022);
      p.h(paramView, "widget");
      this.tPo.invoke();
      AppMethodBeat.o(244022);
    }
    
    public final void updateDrawState(TextPaint paramTextPaint)
    {
      AppMethodBeat.i(244023);
      p.h(paramTextPaint, "ds");
      Context localContext = paramTextView.getContext();
      p.g(localContext, "tv.context");
      paramTextPaint.setColor(localContext.getResources().getColor(2131099784));
      paramTextPaint.setUnderlineText(false);
      paramTextPaint.clearShadowLayer();
      AppMethodBeat.o(244023);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.z.b
 * JD-Core Version:    0.7.0.1
 */