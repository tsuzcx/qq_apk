package com.tencent.mm.plugin.fts.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.u;
import com.tencent.mm.protocal.protobuf.amw;
import com.tencent.mm.protocal.protobuf.diq;
import com.tencent.mm.protocal.protobuf.dir;
import com.tencent.mm.protocal.protobuf.dxu;
import com.tencent.mm.protocal.protobuf.epl;
import com.tencent.mm.protocal.protobuf.epm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.search.FTSEditTextView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/fts/ui/FTSBizDetailUI;", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "currentSearchId", "", "getCurrentSearchId", "()J", "setCurrentSearchId", "(J)V", "detailAdapter", "Lcom/tencent/mm/plugin/fts/ui/FTSBizDetailAdapter;", "exposeSugSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "pardusNetScene", "Lcom/tencent/mm/plugin/websearch/api/NetScenePardusSearch;", "relevantSearchLayout", "Landroid/widget/LinearLayout;", "searchResponse", "Lcom/tencent/mm/protocal/protobuf/PardusSearchResponse;", "sessionId", "getSessionId", "setSessionId", "showWebEntry", "", "webSearchBarLayout", "Landroid/view/View;", "webSearchDescTV", "Landroid/widget/TextView;", "webSearchDivider", "webSearchFooter", "webSearchLayout", "webSearchTitleTV", "createFTSBaseAdapter", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseAdapter;", "uiComponent", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseUIComponent;", "getFooterView", "getHint", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEnd", "resultCount", "isFinished", "", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onScroll", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "visibleItemCount", "totalItemCount", "reportSugAction", "relatedSugItem", "Lcom/tencent/mm/protocal/protobuf/FTSRelatedSugItem;", "response", "type", "reportWebSearchBarAction", "resetUI", "setNoResultView", "startPardusSearch", "startSearch", "startWebSearch", "query", "stopSearch", "updateFooterView", "ui-fts_release"})
public final class FTSBizDetailUI
  extends FTSBaseUI
  implements i
{
  f BMV;
  private View BMW;
  private View BMX;
  View BMY;
  private View BMZ;
  int BMs;
  LinearLayout BNa;
  private TextView BNb;
  private TextView BNc;
  dir BNd;
  private u BNe;
  private long BNf;
  HashSet<String> BNg;
  private final String TAG;
  private long sessionId;
  
  public FTSBizDetailUI()
  {
    AppMethodBeat.i(189426);
    this.TAG = "MicroMsg.FTS.FTSBizDetailUI";
    this.sessionId = com.tencent.mm.plugin.fts.a.d.Sw(69);
    this.BNg = new HashSet();
    this.BMs = 1;
    AppMethodBeat.o(189426);
  }
  
  private final void cVU()
  {
    AppMethodBeat.i(189403);
    Object localObject1 = this.BNa;
    if (localObject1 != null) {
      ((LinearLayout)localObject1).removeAllViews();
    }
    localObject1 = this.BMX;
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = this.BMY;
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = this.BNb;
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.plugin.fts.a.f.a(getString(o.g.fts_on_search_network), getString(o.g.fts_header_recommend_biz), (CharSequence)(getQuery() + "  ")));
    }
    localObject1 = this.BNd;
    if (localObject1 != null)
    {
      localObject1 = ((dir)localObject1).TQh;
      if (localObject1 != null)
      {
        localObject1 = ((epm)localObject1).RLp;
        if (localObject1 != null)
        {
          int i;
          if (((LinkedList)localObject1).size() > 0)
          {
            i = 1;
            if (i == 0) {
              break label331;
            }
            label145:
            if (localObject1 == null) {
              break label367;
            }
            localObject1 = ((Iterable)localObject1).iterator();
            i = 0;
          }
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label341;
            }
            Object localObject2 = ((Iterator)localObject1).next();
            int j = i + 1;
            if (i < 0) {
              j.iBO();
            }
            Object localObject3 = (epl)localObject2;
            localObject2 = getLayoutInflater().inflate(o.e.fts_websearch_relevant_item, (ViewGroup)this.BNa, false);
            ((View)localObject2).setOnClickListener((View.OnClickListener)new b(this));
            Object localObject4 = (TextView)((View)localObject2).findViewById(o.d.content);
            p.j(localObject4, "contentTV");
            ((TextView)localObject4).setText((CharSequence)((epl)localObject3).TSb);
            localObject4 = new amw();
            ((amw)localObject4).SwV = ((epl)localObject3);
            ((amw)localObject4).CqR = i;
            p.j(localObject2, "relatedItemView");
            ((View)localObject2).setTag(localObject4);
            localObject3 = this.BNa;
            if (localObject3 != null)
            {
              ((LinearLayout)localObject3).addView((View)localObject2);
              i = j;
              continue;
              i = 0;
              break;
              label331:
              localObject1 = null;
              break label145;
            }
            i = j;
          }
          label341:
          localObject1 = this.BNa;
          if (localObject1 != null)
          {
            ((LinearLayout)localObject1).setVisibility(0);
            AppMethodBeat.o(189403);
            return;
          }
          AppMethodBeat.o(189403);
          return;
        }
      }
    }
    label367:
    AppMethodBeat.o(189403);
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(189370);
    parame = this.BMV;
    if (parame != null)
    {
      parame = (d)parame;
      AppMethodBeat.o(189370);
      return parame;
    }
    parame = (FTSBizDetailUI)this;
    f localf = new f((e)this);
    parame.BMV = localf;
    parame = (d)localf;
    AppMethodBeat.o(189370);
    return parame;
  }
  
  final void a(amw paramamw, dir paramdir, int paramInt)
  {
    AppMethodBeat.i(189423);
    dxu localdxu = new dxu();
    localdxu.Udk = ("bizsugresultreport=1&searchid=" + paramdir.Tky + "&query=" + com.tencent.mm.compatible.util.q.an(getQuery(), "utf8") + "&scene=69&businesstype=1&type=" + paramInt + "&clienttimestamp=" + cm.bfE() + "&docid=" + paramamw.SwV.TPZ + "&sugpos=" + (paramamw.CqR + 1) + "&iss1sitem=0&sugresult=" + com.tencent.mm.compatible.util.q.an(paramamw.SwV.TSb, "utf8"));
    Log.i(this.TAG, "reportSugAction " + localdxu.Udk);
    h.aGY().b((com.tencent.mm.an.q)new ad(localdxu));
    AppMethodBeat.o(189423);
  }
  
  final void a(dir paramdir, int paramInt)
  {
    AppMethodBeat.i(189420);
    dxu localdxu = new dxu();
    localdxu.Udk = ("bizsugresultreport=1&searchid=" + paramdir.Tky + "&query=" + com.tencent.mm.compatible.util.q.an(getQuery(), "utf8") + "&scene=69&businesstype=1&type=" + paramInt + "&clienttimestamp=" + cm.bfE() + "&iss1sitem=1&docid=" + com.tencent.mm.compatible.util.q.an(getQuery(), "utf8"));
    Log.i(this.TAG, "reportWebSearchBarAction " + localdxu.Udk);
    h.aGY().b((com.tencent.mm.an.q)new ad(localdxu));
    AppMethodBeat.o(189420);
  }
  
  public final void aC(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(189407);
    super.aC(paramInt, paramBoolean);
    cVU();
    AppMethodBeat.o(189407);
  }
  
  protected final void erG()
  {
    AppMethodBeat.i(189375);
    super.erG();
    Object localObject = erK();
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)getString(o.g.contact_no_result));
    }
    localObject = erE();
    p.j(localObject, "searchResultLV");
    ((ListView)localObject).setVisibility(0);
    AppMethodBeat.o(189375);
  }
  
  protected final void erw()
  {
    AppMethodBeat.i(189411);
    super.erw();
    if (this.BNe != null)
    {
      h.aGY().a((com.tencent.mm.an.q)this.BNe);
      this.BNe = null;
    }
    this.BNf = com.tencent.mm.plugin.fts.a.d.Sw(69);
    Object localObject = new diq();
    ((diq)localObject).RYJ = getQuery();
    ((diq)localObject).SessionId = String.valueOf(this.sessionId);
    ((diq)localObject).Tkx = String.valueOf(this.BNf);
    ((diq)localObject).CPw = 69;
    ((diq)localObject).CQK = 1;
    localObject = new u((diq)localObject);
    h.aGY().b((com.tencent.mm.an.q)localObject);
    this.BNe = ((u)localObject);
    AppMethodBeat.o(189411);
  }
  
  protected final void erx()
  {
    AppMethodBeat.i(189413);
    super.erx();
    this.BMs = 1;
    this.BNd = null;
    View localView = this.BMX;
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = this.BMY;
    if (localView != null) {
      localView.setVisibility(8);
    }
    this.BNg.clear();
    if (this.BNe != null)
    {
      h.aGY().a((com.tencent.mm.an.q)this.BNe);
      this.BNe = null;
    }
    AppMethodBeat.o(189413);
  }
  
  protected final View getFooterView()
  {
    AppMethodBeat.i(189385);
    this.BMW = getLayoutInflater().inflate(o.e.fts_web_search_footer, null, false);
    Object localObject = this.BMW;
    if (localObject != null)
    {
      this.BMY = ((View)localObject).findViewById(o.d.web_search_bar_layout);
      this.BMX = ((View)localObject).findViewById(o.d.web_search_layout);
      this.BMZ = ((View)localObject).findViewById(o.d.web_search_divider);
      this.BNb = ((TextView)((View)localObject).findViewById(o.d.web_search_title_tv));
      this.BNc = ((TextView)((View)localObject).findViewById(o.d.web_search_desc_tv));
      this.BNa = ((LinearLayout)((View)localObject).findViewById(o.d.relevant_search_layout));
    }
    localObject = this.BMZ;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.BNc;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.BMY;
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)new a(this));
    }
    localObject = this.BMW;
    AppMethodBeat.o(189385);
    return localObject;
  }
  
  public final String getHint()
  {
    AppMethodBeat.i(189378);
    String str = getString(o.g.search_detail_page_hint, new Object[] { getString(o.g.fts_header_biz) });
    p.j(str, "getString(R.string.searc…R.string.fts_header_biz))");
    AppMethodBeat.o(189378);
    return str;
  }
  
  public final int getLayoutId()
  {
    return o.e.fts_biz_detail_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(189362);
    super.onCreate(paramBundle);
    paramBundle = h.ag(n.class);
    p.j(paramBundle, "MMKernel.plugin(IPluginFTS::class.java)");
    ((n)paramBundle).getFTSImageLoader().eqB();
    h.aGY().a(1076, (i)this);
    paramBundle = erJ();
    p.j(paramBundle, "ftsSearchView");
    paramBundle.getFtsEditText().hXB();
    paramBundle = erJ();
    p.j(paramBundle, "ftsSearchView");
    paramBundle.getFtsEditText().aDU();
    paramBundle = erJ();
    p.j(paramBundle, "ftsSearchView");
    paramBundle.getFtsEditText().aDT();
    AppMethodBeat.o(189362);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(189366);
    h.aGY().b(1076, (i)this);
    Object localObject = h.ag(n.class);
    p.j(localObject, "MMKernel.plugin(IPluginFTS::class.java)");
    ((n)localObject).getFTSImageLoader().eqz();
    localObject = this.BMV;
    if (localObject != null) {
      ((f)localObject).finish();
    }
    super.onDestroy();
    AppMethodBeat.o(189366);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    Object localObject1 = null;
    AppMethodBeat.i(189417);
    paramString = this.BNe;
    if (paramString != null)
    {
      StringBuilder localStringBuilder;
      if (p.h(paramq, paramString))
      {
        if (paramString == null) {
          break label173;
        }
        this.BNd = paramString.gQz();
        paramq = this.TAG;
        localStringBuilder = new StringBuilder("onSceneEnd searchResponse GuideText:");
        paramString = this.BNd;
        if (paramString == null) {
          break label168;
        }
      }
      label168:
      for (paramString = paramString.TQf;; paramString = null)
      {
        localStringBuilder = localStringBuilder.append(paramString).append(" size:");
        Object localObject2 = this.BNd;
        paramString = localObject1;
        if (localObject2 != null)
        {
          localObject2 = ((dir)localObject2).TQh;
          paramString = localObject1;
          if (localObject2 != null)
          {
            localObject2 = ((epm)localObject2).RLp;
            paramString = localObject1;
            if (localObject2 != null) {
              paramString = Integer.valueOf(((LinkedList)localObject2).size());
            }
          }
        }
        Log.i(paramq, paramString);
        cVU();
        AppMethodBeat.o(189417);
        return;
        paramString = null;
        break;
      }
    }
    label173:
    AppMethodBeat.o(189417);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FTSBizDetailUI paramFTSBizDetailUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190080);
      b localb = new b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$getFooterView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      FTSBizDetailUI.a(this.BNh, this.BNh.getQuery());
      paramView = FTSBizDetailUI.a(this.BNh);
      if (paramView != null) {
        FTSBizDetailUI.a(this.BNh, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$getFooterView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(190080);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$updateFooterView$2$1$1", "com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$$special$$inlined$forEachIndexed$lambda$1"})
  static final class b
    implements View.OnClickListener
  {
    b(FTSBizDetailUI paramFTSBizDetailUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(189698);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$updateFooterView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      p.j(paramView, "it");
      paramView = paramView.getTag();
      if ((paramView != null) && ((paramView instanceof amw)))
      {
        FTSBizDetailUI.a(this.BNh, ((amw)paramView).SwV.TSb);
        localObject = FTSBizDetailUI.a(this.BNh);
        if (localObject != null) {
          FTSBizDetailUI.a(this.BNh, (amw)paramView, (dir)localObject);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$updateFooterView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(189698);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBizDetailUI
 * JD-Core Version:    0.7.0.1
 */