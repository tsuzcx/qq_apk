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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cf;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.aix;
import com.tencent.mm.protocal.protobuf.cid;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.cup;
import com.tencent.mm.protocal.protobuf.dla;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.search.FTSEditTextView;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/fts/ui/FTSBizDetailUI;", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "currentSearchId", "", "getCurrentSearchId", "()J", "setCurrentSearchId", "(J)V", "detailAdapter", "Lcom/tencent/mm/plugin/fts/ui/FTSBizDetailAdapter;", "exposeSugSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "pardusNetScene", "Lcom/tencent/mm/plugin/websearch/api/NetScenePardusSearch;", "relevantSearchLayout", "Landroid/widget/LinearLayout;", "searchResponse", "Lcom/tencent/mm/protocal/protobuf/PardusSearchResponse;", "sessionId", "getSessionId", "setSessionId", "showWebEntry", "", "webSearchBarLayout", "Landroid/view/View;", "webSearchDescTV", "Landroid/widget/TextView;", "webSearchDivider", "webSearchFooter", "webSearchLayout", "webSearchTitleTV", "createFTSBaseAdapter", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseAdapter;", "uiComponent", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseUIComponent;", "getFooterView", "getHint", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEnd", "resultCount", "isFinished", "", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onScroll", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "visibleItemCount", "totalItemCount", "reportSugAction", "relatedSugItem", "Lcom/tencent/mm/protocal/protobuf/FTSRelatedSugItem;", "response", "type", "reportWebSearchBarAction", "resetUI", "setNoResultView", "startPardusSearch", "startSearch", "startWebSearch", "query", "stopSearch", "updateFooterView", "ui-fts_release"})
public final class FTSBizDetailUI
  extends FTSBaseUI
  implements com.tencent.mm.al.f
{
  private final String TAG;
  private long sessionId;
  int tyD;
  f tzf;
  private View tzg;
  private View tzh;
  View tzi;
  private View tzj;
  LinearLayout tzk;
  private TextView tzl;
  private TextView tzm;
  cie tzn;
  private r tzo;
  private long tzp;
  HashSet<String> tzq;
  
  public FTSBizDetailUI()
  {
    AppMethodBeat.i(219371);
    this.TAG = "MicroMsg.FTS.FTSBizDetailUI";
    this.sessionId = com.tencent.mm.plugin.fts.a.d.GM(69);
    this.tzq = new HashSet();
    this.tyD = 1;
    AppMethodBeat.o(219371);
  }
  
  private final void chU()
  {
    AppMethodBeat.i(219364);
    Object localObject1 = this.tzk;
    if (localObject1 != null) {
      ((LinearLayout)localObject1).removeAllViews();
    }
    localObject1 = this.tzh;
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = this.tzi;
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = this.tzl;
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.plugin.fts.a.f.a(getString(2131759714), getString(2131759695), (CharSequence)(getQuery() + "  ")));
    }
    localObject1 = this.tzn;
    if (localObject1 != null)
    {
      localObject1 = ((cie)localObject1).Hcb;
      if (localObject1 != null)
      {
        localObject1 = ((dlb)localObject1).Fys;
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
              j.gfB();
            }
            Object localObject3 = (dla)localObject2;
            localObject2 = getLayoutInflater().inflate(2131494228, (ViewGroup)this.tzk, false);
            ((View)localObject2).setOnClickListener((View.OnClickListener)new b(this));
            Object localObject4 = (TextView)((View)localObject2).findViewById(2131298739);
            p.g(localObject4, "contentTV");
            ((TextView)localObject4).setText((CharSequence)((dla)localObject3).HdP);
            localObject4 = new aix();
            ((aix)localObject4).Gga = ((dla)localObject3);
            ((aix)localObject4).FCk = i;
            p.g(localObject2, "relatedItemView");
            ((View)localObject2).setTag(localObject4);
            localObject3 = this.tzk;
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
          localObject1 = this.tzk;
          if (localObject1 != null)
          {
            ((LinearLayout)localObject1).setVisibility(0);
            AppMethodBeat.o(219364);
            return;
          }
          AppMethodBeat.o(219364);
          return;
        }
      }
    }
    label367:
    AppMethodBeat.o(219364);
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(219360);
    parame = this.tzf;
    if (parame != null)
    {
      parame = (d)parame;
      AppMethodBeat.o(219360);
      return parame;
    }
    parame = (FTSBizDetailUI)this;
    f localf = new f((e)this);
    parame.tzf = localf;
    parame = (d)localf;
    AppMethodBeat.o(219360);
    return parame;
  }
  
  final void a(aix paramaix, cie paramcie, int paramInt)
  {
    AppMethodBeat.i(219370);
    cup localcup = new cup();
    localcup.Hmu = ("bizsugresultreport=1&searchid=" + paramcie.GRx + "&query=" + com.tencent.mm.compatible.util.q.encode(getQuery(), "utf8") + "&scene=69&businesstype=1&type=" + paramInt + "&clienttimestamp=" + cf.aCM() + "&docid=" + paramaix.Gga.HbR + "&sugpos=" + (paramaix.FCk + 1) + "&iss1sitem=0&sugresult=" + com.tencent.mm.compatible.util.q.encode(paramaix.Gga.HdP, "utf8"));
    ad.i(this.TAG, "reportSugAction " + localcup.Hmu);
    g.aiU().b((com.tencent.mm.al.n)new z(localcup));
    AppMethodBeat.o(219370);
  }
  
  final void a(cie paramcie, int paramInt)
  {
    AppMethodBeat.i(219369);
    cup localcup = new cup();
    localcup.Hmu = ("bizsugresultreport=1&searchid=" + paramcie.GRx + "&query=" + com.tencent.mm.compatible.util.q.encode(getQuery(), "utf8") + "&scene=69&businesstype=1&type=" + paramInt + "&clienttimestamp=" + cf.aCM() + "&iss1sitem=1&docid=" + com.tencent.mm.compatible.util.q.encode(getQuery(), "utf8"));
    ad.i(this.TAG, "reportWebSearchBarAction " + localcup.Hmu);
    g.aiU().b((com.tencent.mm.al.n)new z(localcup));
    AppMethodBeat.o(219369);
  }
  
  public final void am(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(219365);
    super.am(paramInt, paramBoolean);
    chU();
    AppMethodBeat.o(219365);
  }
  
  protected final void cTo()
  {
    AppMethodBeat.i(219366);
    super.cTo();
    if (this.tzo != null)
    {
      g.aiU().a((com.tencent.mm.al.n)this.tzo);
      this.tzo = null;
    }
    this.tzp = com.tencent.mm.plugin.fts.a.d.GM(69);
    Object localObject = new cid();
    ((cid)localObject).FKK = getQuery();
    ((cid)localObject).FxN = String.valueOf(this.sessionId);
    ((cid)localObject).HbT = String.valueOf(this.tzp);
    ((cid)localObject).Scene = 69;
    ((cid)localObject).FAh = 1;
    localObject = new r((cid)localObject);
    g.aiU().b((com.tencent.mm.al.n)localObject);
    this.tzo = ((r)localObject);
    AppMethodBeat.o(219366);
  }
  
  protected final void cTw()
  {
    AppMethodBeat.i(219361);
    super.cTw();
    Object localObject = cTA();
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)getString(2131757915));
    }
    localObject = cTu();
    p.g(localObject, "searchResultLV");
    ((ListView)localObject).setVisibility(0);
    AppMethodBeat.o(219361);
  }
  
  protected final View getFooterView()
  {
    AppMethodBeat.i(219363);
    this.tzg = getLayoutInflater().inflate(2131494224, null, false);
    Object localObject = this.tzg;
    if (localObject != null)
    {
      this.tzi = ((View)localObject).findViewById(2131306903);
      this.tzh = ((View)localObject).findViewById(2131306906);
      this.tzj = ((View)localObject).findViewById(2131306905);
      this.tzl = ((TextView)((View)localObject).findViewById(2131306907));
      this.tzm = ((TextView)((View)localObject).findViewById(2131306904));
      this.tzk = ((LinearLayout)((View)localObject).findViewById(2131303971));
    }
    localObject = this.tzj;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.tzm;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.tzi;
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)new a(this));
    }
    localObject = this.tzg;
    AppMethodBeat.o(219363);
    return localObject;
  }
  
  public final String getHint()
  {
    AppMethodBeat.i(219362);
    String str = getString(2131762937, new Object[] { getString(2131759679) });
    p.g(str, "getString(R.string.searc…R.string.fts_header_biz))");
    AppMethodBeat.o(219362);
    return str;
  }
  
  public final int getLayoutId()
  {
    return 2131496401;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(219358);
    super.onCreate(paramBundle);
    paramBundle = g.ad(com.tencent.mm.plugin.fts.a.n.class);
    p.g(paramBundle, "MMKernel.plugin(IPluginFTS::class.java)");
    ((com.tencent.mm.plugin.fts.a.n)paramBundle).getFTSImageLoader().cSz();
    g.aiU().a(1076, (com.tencent.mm.al.f)this);
    paramBundle = cTz();
    p.g(paramBundle, "ftsSearchView");
    paramBundle.getFtsEditText().fJP();
    paramBundle = cTz();
    p.g(paramBundle, "ftsSearchView");
    paramBundle.getFtsEditText().fJS();
    paramBundle = cTz();
    p.g(paramBundle, "ftsSearchView");
    paramBundle.getFtsEditText().fJR();
    AppMethodBeat.o(219358);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(219359);
    g.aiU().b(1076, (com.tencent.mm.al.f)this);
    Object localObject = g.ad(com.tencent.mm.plugin.fts.a.n.class);
    p.g(localObject, "MMKernel.plugin(IPluginFTS::class.java)");
    ((com.tencent.mm.plugin.fts.a.n)localObject).getFTSImageLoader().cSx();
    localObject = this.tzf;
    if (localObject != null) {
      ((f)localObject).finish();
    }
    super.onDestroy();
    AppMethodBeat.o(219359);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    Object localObject1 = null;
    AppMethodBeat.i(219368);
    paramString = this.tzo;
    if (paramString != null)
    {
      StringBuilder localStringBuilder;
      if (p.i(paramn, paramString))
      {
        if (paramString == null) {
          break label173;
        }
        this.tzn = paramString.eLV();
        paramn = this.TAG;
        localStringBuilder = new StringBuilder("onSceneEnd searchResponse GuideText:");
        paramString = this.tzn;
        if (paramString == null) {
          break label168;
        }
      }
      label168:
      for (paramString = paramString.HbZ;; paramString = null)
      {
        localStringBuilder = localStringBuilder.append(paramString).append(" size:");
        Object localObject2 = this.tzn;
        paramString = localObject1;
        if (localObject2 != null)
        {
          localObject2 = ((cie)localObject2).Hcb;
          paramString = localObject1;
          if (localObject2 != null)
          {
            localObject2 = ((dlb)localObject2).Fys;
            paramString = localObject1;
            if (localObject2 != null) {
              paramString = Integer.valueOf(((LinkedList)localObject2).size());
            }
          }
        }
        ad.i(paramn, paramString);
        chU();
        AppMethodBeat.o(219368);
        return;
        paramString = null;
        break;
      }
    }
    label173:
    AppMethodBeat.o(219368);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void stopSearch()
  {
    AppMethodBeat.i(219367);
    super.stopSearch();
    this.tyD = 1;
    this.tzn = null;
    View localView = this.tzh;
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = this.tzi;
    if (localView != null) {
      localView.setVisibility(8);
    }
    this.tzq.clear();
    if (this.tzo != null)
    {
      g.aiU().a((com.tencent.mm.al.n)this.tzo);
      this.tzo = null;
    }
    AppMethodBeat.o(219367);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FTSBizDetailUI paramFTSBizDetailUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(219356);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$getFooterView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      FTSBizDetailUI.a(this.tzr, this.tzr.getQuery());
      paramView = FTSBizDetailUI.a(this.tzr);
      if (paramView != null) {
        FTSBizDetailUI.a(this.tzr, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$getFooterView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(219356);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$updateFooterView$2$1$1", "com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$$special$$inlined$forEachIndexed$lambda$1"})
  static final class b
    implements View.OnClickListener
  {
    b(FTSBizDetailUI paramFTSBizDetailUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(219357);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$updateFooterView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
      p.g(paramView, "it");
      paramView = paramView.getTag();
      if ((paramView != null) && ((paramView instanceof aix)))
      {
        FTSBizDetailUI.a(this.tzr, ((aix)paramView).Gga.HdP);
        localObject = FTSBizDetailUI.a(this.tzr);
        if (localObject != null) {
          FTSBizDetailUI.a(this.tzr, (aix)paramView, (cie)localObject);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$updateFooterView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(219357);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBizDetailUI
 * JD-Core Version:    0.7.0.1
 */