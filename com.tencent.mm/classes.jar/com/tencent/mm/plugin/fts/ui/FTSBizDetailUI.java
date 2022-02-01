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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.u;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.protocal.protobuf.cze;
import com.tencent.mm.protocal.protobuf.czf;
import com.tencent.mm.protocal.protobuf.doc;
import com.tencent.mm.protocal.protobuf.efk;
import com.tencent.mm.protocal.protobuf.efl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.search.FTSEditTextView;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/fts/ui/FTSBizDetailUI;", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "currentSearchId", "", "getCurrentSearchId", "()J", "setCurrentSearchId", "(J)V", "detailAdapter", "Lcom/tencent/mm/plugin/fts/ui/FTSBizDetailAdapter;", "exposeSugSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "pardusNetScene", "Lcom/tencent/mm/plugin/websearch/api/NetScenePardusSearch;", "relevantSearchLayout", "Landroid/widget/LinearLayout;", "searchResponse", "Lcom/tencent/mm/protocal/protobuf/PardusSearchResponse;", "sessionId", "getSessionId", "setSessionId", "showWebEntry", "", "webSearchBarLayout", "Landroid/view/View;", "webSearchDescTV", "Landroid/widget/TextView;", "webSearchDivider", "webSearchFooter", "webSearchLayout", "webSearchTitleTV", "createFTSBaseAdapter", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseAdapter;", "uiComponent", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseUIComponent;", "getFooterView", "getHint", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEnd", "resultCount", "isFinished", "", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onScroll", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "visibleItemCount", "totalItemCount", "reportSugAction", "relatedSugItem", "Lcom/tencent/mm/protocal/protobuf/FTSRelatedSugItem;", "response", "type", "reportWebSearchBarAction", "resetUI", "setNoResultView", "startPardusSearch", "startSearch", "startWebSearch", "query", "stopSearch", "updateFooterView", "ui-fts_release"})
public final class FTSBizDetailUI
  extends FTSBaseUI
  implements i
{
  private final String TAG;
  private long sessionId;
  f xaV;
  private View xaW;
  private View xaX;
  View xaY;
  private View xaZ;
  int xat;
  LinearLayout xba;
  private TextView xbb;
  private TextView xbc;
  czf xbd;
  private u xbe;
  private long xbf;
  HashSet<String> xbg;
  
  public FTSBizDetailUI()
  {
    AppMethodBeat.i(235440);
    this.TAG = "MicroMsg.FTS.FTSBizDetailUI";
    this.sessionId = com.tencent.mm.plugin.fts.a.d.Ni(69);
    this.xbg = new HashSet();
    this.xat = 1;
    AppMethodBeat.o(235440);
  }
  
  private final void cHi()
  {
    AppMethodBeat.i(235433);
    Object localObject1 = this.xba;
    if (localObject1 != null) {
      ((LinearLayout)localObject1).removeAllViews();
    }
    localObject1 = this.xaX;
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = this.xaY;
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = this.xbb;
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.plugin.fts.a.f.a(getString(2131761035), getString(2131761016), (CharSequence)(getQuery() + "  ")));
    }
    localObject1 = this.xbd;
    if (localObject1 != null)
    {
      localObject1 = ((czf)localObject1).MEy;
      if (localObject1 != null)
      {
        localObject1 = ((efl)localObject1).KKx;
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
              j.hxH();
            }
            Object localObject3 = (efk)localObject2;
            localObject2 = getLayoutInflater().inflate(2131494784, (ViewGroup)this.xba, false);
            ((View)localObject2).setOnClickListener((View.OnClickListener)new b(this));
            Object localObject4 = (TextView)((View)localObject2).findViewById(2131299180);
            p.g(localObject4, "contentTV");
            ((TextView)localObject4).setText((CharSequence)((efk)localObject3).MGp);
            localObject4 = new alv();
            ((alv)localObject4).Lux = ((efk)localObject3);
            ((alv)localObject4).xuA = i;
            p.g(localObject2, "relatedItemView");
            ((View)localObject2).setTag(localObject4);
            localObject3 = this.xba;
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
          localObject1 = this.xba;
          if (localObject1 != null)
          {
            ((LinearLayout)localObject1).setVisibility(0);
            AppMethodBeat.o(235433);
            return;
          }
          AppMethodBeat.o(235433);
          return;
        }
      }
    }
    label367:
    AppMethodBeat.o(235433);
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(235429);
    parame = this.xaV;
    if (parame != null)
    {
      parame = (d)parame;
      AppMethodBeat.o(235429);
      return parame;
    }
    parame = (FTSBizDetailUI)this;
    f localf = new f((e)this);
    parame.xaV = localf;
    parame = (d)localf;
    AppMethodBeat.o(235429);
    return parame;
  }
  
  final void a(alv paramalv, czf paramczf, int paramInt)
  {
    AppMethodBeat.i(235439);
    doc localdoc = new doc();
    localdoc.MRe = ("bizsugresultreport=1&searchid=" + paramczf.Mbb + "&query=" + com.tencent.mm.compatible.util.q.encode(getQuery(), "utf8") + "&scene=69&businesstype=1&type=" + paramInt + "&clienttimestamp=" + cl.aWA() + "&docid=" + paramalv.Lux.MEq + "&sugpos=" + (paramalv.xuA + 1) + "&iss1sitem=0&sugresult=" + com.tencent.mm.compatible.util.q.encode(paramalv.Lux.MGp, "utf8"));
    Log.i(this.TAG, "reportSugAction " + localdoc.MRe);
    g.azz().b((com.tencent.mm.ak.q)new ad(localdoc));
    AppMethodBeat.o(235439);
  }
  
  final void a(czf paramczf, int paramInt)
  {
    AppMethodBeat.i(235438);
    doc localdoc = new doc();
    localdoc.MRe = ("bizsugresultreport=1&searchid=" + paramczf.Mbb + "&query=" + com.tencent.mm.compatible.util.q.encode(getQuery(), "utf8") + "&scene=69&businesstype=1&type=" + paramInt + "&clienttimestamp=" + cl.aWA() + "&iss1sitem=1&docid=" + com.tencent.mm.compatible.util.q.encode(getQuery(), "utf8"));
    Log.i(this.TAG, "reportWebSearchBarAction " + localdoc.MRe);
    g.azz().b((com.tencent.mm.ak.q)new ad(localdoc));
    AppMethodBeat.o(235438);
  }
  
  public final void ay(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(235434);
    super.ay(paramInt, paramBoolean);
    cHi();
    AppMethodBeat.o(235434);
  }
  
  protected final void dPc()
  {
    AppMethodBeat.i(235435);
    super.dPc();
    if (this.xbe != null)
    {
      g.azz().a((com.tencent.mm.ak.q)this.xbe);
      this.xbe = null;
    }
    this.xbf = com.tencent.mm.plugin.fts.a.d.Ni(69);
    Object localObject = new cze();
    ((cze)localObject).KXA = getQuery();
    ((cze)localObject).SessionId = String.valueOf(this.sessionId);
    ((cze)localObject).Mba = String.valueOf(this.xbf);
    ((cze)localObject).Scene = 69;
    ((cze)localObject).xMB = 1;
    localObject = new u((cze)localObject);
    g.azz().b((com.tencent.mm.ak.q)localObject);
    this.xbe = ((u)localObject);
    AppMethodBeat.o(235435);
  }
  
  protected final void dPk()
  {
    AppMethodBeat.i(235430);
    super.dPk();
    Object localObject = dPo();
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)getString(2131758155));
    }
    localObject = dPi();
    p.g(localObject, "searchResultLV");
    ((ListView)localObject).setVisibility(0);
    AppMethodBeat.o(235430);
  }
  
  protected final View getFooterView()
  {
    AppMethodBeat.i(235432);
    this.xaW = getLayoutInflater().inflate(2131494780, null, false);
    Object localObject = this.xaW;
    if (localObject != null)
    {
      this.xaY = ((View)localObject).findViewById(2131310374);
      this.xaX = ((View)localObject).findViewById(2131310377);
      this.xaZ = ((View)localObject).findViewById(2131310376);
      this.xbb = ((TextView)((View)localObject).findViewById(2131310378));
      this.xbc = ((TextView)((View)localObject).findViewById(2131310375));
      this.xba = ((LinearLayout)((View)localObject).findViewById(2131306825));
    }
    localObject = this.xaZ;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.xbc;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.xaY;
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)new a(this));
    }
    localObject = this.xaW;
    AppMethodBeat.o(235432);
    return localObject;
  }
  
  public final String getHint()
  {
    AppMethodBeat.i(235431);
    String str = getString(2131765073, new Object[] { getString(2131761000) });
    p.g(str, "getString(R.string.searc…R.string.fts_header_biz))");
    AppMethodBeat.o(235431);
    return str;
  }
  
  public final int getLayoutId()
  {
    return 2131494742;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(235427);
    super.onCreate(paramBundle);
    paramBundle = g.ah(n.class);
    p.g(paramBundle, "MMKernel.plugin(IPluginFTS::class.java)");
    ((n)paramBundle).getFTSImageLoader().dOn();
    g.azz().a(1076, (i)this);
    paramBundle = dPn();
    p.g(paramBundle, "ftsSearchView");
    paramBundle.getFtsEditText().gWY();
    paramBundle = dPn();
    p.g(paramBundle, "ftsSearchView");
    paramBundle.getFtsEditText().awD();
    paramBundle = dPn();
    p.g(paramBundle, "ftsSearchView");
    paramBundle.getFtsEditText().awC();
    AppMethodBeat.o(235427);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(235428);
    g.azz().b(1076, (i)this);
    Object localObject = g.ah(n.class);
    p.g(localObject, "MMKernel.plugin(IPluginFTS::class.java)");
    ((n)localObject).getFTSImageLoader().dOl();
    localObject = this.xaV;
    if (localObject != null) {
      ((f)localObject).finish();
    }
    super.onDestroy();
    AppMethodBeat.o(235428);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    Object localObject1 = null;
    AppMethodBeat.i(235437);
    paramString = this.xbe;
    if (paramString != null)
    {
      StringBuilder localStringBuilder;
      if (p.j(paramq, paramString))
      {
        if (paramString == null) {
          break label173;
        }
        this.xbd = paramString.fXO();
        paramq = this.TAG;
        localStringBuilder = new StringBuilder("onSceneEnd searchResponse GuideText:");
        paramString = this.xbd;
        if (paramString == null) {
          break label168;
        }
      }
      label168:
      for (paramString = paramString.MEw;; paramString = null)
      {
        localStringBuilder = localStringBuilder.append(paramString).append(" size:");
        Object localObject2 = this.xbd;
        paramString = localObject1;
        if (localObject2 != null)
        {
          localObject2 = ((czf)localObject2).MEy;
          paramString = localObject1;
          if (localObject2 != null)
          {
            localObject2 = ((efl)localObject2).KKx;
            paramString = localObject1;
            if (localObject2 != null) {
              paramString = Integer.valueOf(((LinkedList)localObject2).size());
            }
          }
        }
        Log.i(paramq, paramString);
        cHi();
        AppMethodBeat.o(235437);
        return;
        paramString = null;
        break;
      }
    }
    label173:
    AppMethodBeat.o(235437);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void stopSearch()
  {
    AppMethodBeat.i(235436);
    super.stopSearch();
    this.xat = 1;
    this.xbd = null;
    View localView = this.xaX;
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = this.xaY;
    if (localView != null) {
      localView.setVisibility(8);
    }
    this.xbg.clear();
    if (this.xbe != null)
    {
      g.azz().a((com.tencent.mm.ak.q)this.xbe);
      this.xbe = null;
    }
    AppMethodBeat.o(235436);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FTSBizDetailUI paramFTSBizDetailUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(235425);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$getFooterView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FTSBizDetailUI.a(this.xbh, this.xbh.getQuery());
      paramView = FTSBizDetailUI.a(this.xbh);
      if (paramView != null) {
        FTSBizDetailUI.a(this.xbh, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$getFooterView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(235425);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$updateFooterView$2$1$1", "com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$$special$$inlined$forEachIndexed$lambda$1"})
  static final class b
    implements View.OnClickListener
  {
    b(FTSBizDetailUI paramFTSBizDetailUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(235426);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$updateFooterView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      p.g(paramView, "it");
      paramView = paramView.getTag();
      if ((paramView != null) && ((paramView instanceof alv)))
      {
        FTSBizDetailUI.a(this.xbh, ((alv)paramView).Lux.MGp);
        localObject = FTSBizDetailUI.a(this.xbh);
        if (localObject != null) {
          FTSBizDetailUI.a(this.xbh, (alv)paramView, (czf)localObject);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$updateFooterView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(235426);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBizDetailUI
 * JD-Core Version:    0.7.0.1
 */