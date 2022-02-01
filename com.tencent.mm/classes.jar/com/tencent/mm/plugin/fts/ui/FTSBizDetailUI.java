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
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.plugin.websearch.api.z;
import com.tencent.mm.protocal.protobuf.ajh;
import com.tencent.mm.protocal.protobuf.cix;
import com.tencent.mm.protocal.protobuf.ciy;
import com.tencent.mm.protocal.protobuf.cvj;
import com.tencent.mm.protocal.protobuf.dlx;
import com.tencent.mm.protocal.protobuf.dly;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.search.FTSEditTextView;
import d.a.j;
import d.g.b.p;
import d.l;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/fts/ui/FTSBizDetailUI;", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "currentSearchId", "", "getCurrentSearchId", "()J", "setCurrentSearchId", "(J)V", "detailAdapter", "Lcom/tencent/mm/plugin/fts/ui/FTSBizDetailAdapter;", "exposeSugSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "pardusNetScene", "Lcom/tencent/mm/plugin/websearch/api/NetScenePardusSearch;", "relevantSearchLayout", "Landroid/widget/LinearLayout;", "searchResponse", "Lcom/tencent/mm/protocal/protobuf/PardusSearchResponse;", "sessionId", "getSessionId", "setSessionId", "showWebEntry", "", "webSearchBarLayout", "Landroid/view/View;", "webSearchDescTV", "Landroid/widget/TextView;", "webSearchDivider", "webSearchFooter", "webSearchLayout", "webSearchTitleTV", "createFTSBaseAdapter", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseAdapter;", "uiComponent", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseUIComponent;", "getFooterView", "getHint", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEnd", "resultCount", "isFinished", "", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onScroll", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "visibleItemCount", "totalItemCount", "reportSugAction", "relatedSugItem", "Lcom/tencent/mm/protocal/protobuf/FTSRelatedSugItem;", "response", "type", "reportWebSearchBarAction", "resetUI", "setNoResultView", "startPardusSearch", "startSearch", "startWebSearch", "query", "stopSearch", "updateFooterView", "ui-fts_release"})
public final class FTSBizDetailUI
  extends FTSBaseUI
  implements com.tencent.mm.ak.f
{
  private final String TAG;
  private long sessionId;
  f tJW;
  private View tJX;
  private View tJY;
  View tJZ;
  int tJu;
  private View tKa;
  LinearLayout tKb;
  private TextView tKc;
  private TextView tKd;
  ciy tKe;
  private r tKf;
  private long tKg;
  HashSet<String> tKh;
  
  public FTSBizDetailUI()
  {
    AppMethodBeat.i(194911);
    this.TAG = "MicroMsg.FTS.FTSBizDetailUI";
    this.sessionId = com.tencent.mm.plugin.fts.a.d.Hj(69);
    this.tKh = new HashSet();
    this.tJu = 1;
    AppMethodBeat.o(194911);
  }
  
  private final void cjk()
  {
    AppMethodBeat.i(194904);
    Object localObject1 = this.tKb;
    if (localObject1 != null) {
      ((LinearLayout)localObject1).removeAllViews();
    }
    localObject1 = this.tJY;
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = this.tJZ;
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = this.tKc;
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.plugin.fts.a.f.a(getString(2131759714), getString(2131759695), (CharSequence)(getQuery() + "  ")));
    }
    localObject1 = this.tKe;
    if (localObject1 != null)
    {
      localObject1 = ((ciy)localObject1).HvB;
      if (localObject1 != null)
      {
        localObject1 = ((dly)localObject1).FQQ;
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
              j.gkd();
            }
            Object localObject3 = (dlx)localObject2;
            localObject2 = getLayoutInflater().inflate(2131494228, (ViewGroup)this.tKb, false);
            ((View)localObject2).setOnClickListener((View.OnClickListener)new b(this));
            Object localObject4 = (TextView)((View)localObject2).findViewById(2131298739);
            p.g(localObject4, "contentTV");
            ((TextView)localObject4).setText((CharSequence)((dlx)localObject3).Hxp);
            localObject4 = new ajh();
            ((ajh)localObject4).GyJ = ((dlx)localObject3);
            ((ajh)localObject4).FUF = i;
            p.g(localObject2, "relatedItemView");
            ((View)localObject2).setTag(localObject4);
            localObject3 = this.tKb;
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
          localObject1 = this.tKb;
          if (localObject1 != null)
          {
            ((LinearLayout)localObject1).setVisibility(0);
            AppMethodBeat.o(194904);
            return;
          }
          AppMethodBeat.o(194904);
          return;
        }
      }
    }
    label367:
    AppMethodBeat.o(194904);
  }
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(194900);
    parame = this.tJW;
    if (parame != null)
    {
      parame = (d)parame;
      AppMethodBeat.o(194900);
      return parame;
    }
    parame = (FTSBizDetailUI)this;
    f localf = new f((e)this);
    parame.tJW = localf;
    parame = (d)localf;
    AppMethodBeat.o(194900);
    return parame;
  }
  
  final void a(ajh paramajh, ciy paramciy, int paramInt)
  {
    AppMethodBeat.i(194910);
    cvj localcvj = new cvj();
    localcvj.HFU = ("bizsugresultreport=1&searchid=" + paramciy.HkY + "&query=" + com.tencent.mm.compatible.util.q.encode(getQuery(), "utf8") + "&scene=69&businesstype=1&type=" + paramInt + "&clienttimestamp=" + ch.aDc() + "&docid=" + paramajh.GyJ.Hvr + "&sugpos=" + (paramajh.FUF + 1) + "&iss1sitem=0&sugresult=" + com.tencent.mm.compatible.util.q.encode(paramajh.GyJ.Hxp, "utf8"));
    ae.i(this.TAG, "reportSugAction " + localcvj.HFU);
    g.ajj().b((com.tencent.mm.ak.n)new z(localcvj));
    AppMethodBeat.o(194910);
  }
  
  final void a(ciy paramciy, int paramInt)
  {
    AppMethodBeat.i(194909);
    cvj localcvj = new cvj();
    localcvj.HFU = ("bizsugresultreport=1&searchid=" + paramciy.HkY + "&query=" + com.tencent.mm.compatible.util.q.encode(getQuery(), "utf8") + "&scene=69&businesstype=1&type=" + paramInt + "&clienttimestamp=" + ch.aDc() + "&iss1sitem=1&docid=" + com.tencent.mm.compatible.util.q.encode(getQuery(), "utf8"));
    ae.i(this.TAG, "reportWebSearchBarAction " + localcvj.HFU);
    g.ajj().b((com.tencent.mm.ak.n)new z(localcvj));
    AppMethodBeat.o(194909);
  }
  
  public final void ap(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(194905);
    super.ap(paramInt, paramBoolean);
    cjk();
    AppMethodBeat.o(194905);
  }
  
  protected final void cVT()
  {
    AppMethodBeat.i(194906);
    super.cVT();
    if (this.tKf != null)
    {
      g.ajj().a((com.tencent.mm.ak.n)this.tKf);
      this.tKf = null;
    }
    this.tKg = com.tencent.mm.plugin.fts.a.d.Hj(69);
    Object localObject = new cix();
    ((cix)localObject).Gdj = getQuery();
    ((cix)localObject).FQl = String.valueOf(this.sessionId);
    ((cix)localObject).Hvt = String.valueOf(this.tKg);
    ((cix)localObject).Scene = 69;
    ((cix)localObject).uuz = 1;
    localObject = new r((cix)localObject);
    g.ajj().b((com.tencent.mm.ak.n)localObject);
    this.tKf = ((r)localObject);
    AppMethodBeat.o(194906);
  }
  
  protected final void cWb()
  {
    AppMethodBeat.i(194901);
    super.cWb();
    Object localObject = cWf();
    if (localObject != null) {
      ((TextView)localObject).setText((CharSequence)getString(2131757915));
    }
    localObject = cVZ();
    p.g(localObject, "searchResultLV");
    ((ListView)localObject).setVisibility(0);
    AppMethodBeat.o(194901);
  }
  
  protected final View getFooterView()
  {
    AppMethodBeat.i(194903);
    this.tJX = getLayoutInflater().inflate(2131494224, null, false);
    Object localObject = this.tJX;
    if (localObject != null)
    {
      this.tJZ = ((View)localObject).findViewById(2131306903);
      this.tJY = ((View)localObject).findViewById(2131306906);
      this.tKa = ((View)localObject).findViewById(2131306905);
      this.tKc = ((TextView)((View)localObject).findViewById(2131306907));
      this.tKd = ((TextView)((View)localObject).findViewById(2131306904));
      this.tKb = ((LinearLayout)((View)localObject).findViewById(2131303971));
    }
    localObject = this.tKa;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.tKd;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.tJZ;
    if (localObject != null) {
      ((View)localObject).setOnClickListener((View.OnClickListener)new a(this));
    }
    localObject = this.tJX;
    AppMethodBeat.o(194903);
    return localObject;
  }
  
  public final String getHint()
  {
    AppMethodBeat.i(194902);
    String str = getString(2131762937, new Object[] { getString(2131759679) });
    p.g(str, "getString(R.string.searc…R.string.fts_header_biz))");
    AppMethodBeat.o(194902);
    return str;
  }
  
  public final int getLayoutId()
  {
    return 2131496401;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(194898);
    super.onCreate(paramBundle);
    paramBundle = g.ad(com.tencent.mm.plugin.fts.a.n.class);
    p.g(paramBundle, "MMKernel.plugin(IPluginFTS::class.java)");
    ((com.tencent.mm.plugin.fts.a.n)paramBundle).getFTSImageLoader().cVe();
    g.ajj().a(1076, (com.tencent.mm.ak.f)this);
    paramBundle = cWe();
    p.g(paramBundle, "ftsSearchView");
    paramBundle.getFtsEditText().fOg();
    paramBundle = cWe();
    p.g(paramBundle, "ftsSearchView");
    paramBundle.getFtsEditText().fOj();
    paramBundle = cWe();
    p.g(paramBundle, "ftsSearchView");
    paramBundle.getFtsEditText().fOi();
    AppMethodBeat.o(194898);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(194899);
    g.ajj().b(1076, (com.tencent.mm.ak.f)this);
    Object localObject = g.ad(com.tencent.mm.plugin.fts.a.n.class);
    p.g(localObject, "MMKernel.plugin(IPluginFTS::class.java)");
    ((com.tencent.mm.plugin.fts.a.n)localObject).getFTSImageLoader().cVc();
    localObject = this.tJW;
    if (localObject != null) {
      ((f)localObject).finish();
    }
    super.onDestroy();
    AppMethodBeat.o(194899);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    Object localObject1 = null;
    AppMethodBeat.i(194908);
    paramString = this.tKf;
    if (paramString != null)
    {
      StringBuilder localStringBuilder;
      if (p.i(paramn, paramString))
      {
        if (paramString == null) {
          break label173;
        }
        this.tKe = paramString.ePE();
        paramn = this.TAG;
        localStringBuilder = new StringBuilder("onSceneEnd searchResponse GuideText:");
        paramString = this.tKe;
        if (paramString == null) {
          break label168;
        }
      }
      label168:
      for (paramString = paramString.Hvz;; paramString = null)
      {
        localStringBuilder = localStringBuilder.append(paramString).append(" size:");
        Object localObject2 = this.tKe;
        paramString = localObject1;
        if (localObject2 != null)
        {
          localObject2 = ((ciy)localObject2).HvB;
          paramString = localObject1;
          if (localObject2 != null)
          {
            localObject2 = ((dly)localObject2).FQQ;
            paramString = localObject1;
            if (localObject2 != null) {
              paramString = Integer.valueOf(((LinkedList)localObject2).size());
            }
          }
        }
        ae.i(paramn, paramString);
        cjk();
        AppMethodBeat.o(194908);
        return;
        paramString = null;
        break;
      }
    }
    label173:
    AppMethodBeat.o(194908);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void stopSearch()
  {
    AppMethodBeat.i(194907);
    super.stopSearch();
    this.tJu = 1;
    this.tKe = null;
    View localView = this.tJY;
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = this.tJZ;
    if (localView != null) {
      localView.setVisibility(8);
    }
    this.tKh.clear();
    if (this.tKf != null)
    {
      g.ajj().a((com.tencent.mm.ak.n)this.tKf);
      this.tKf = null;
    }
    AppMethodBeat.o(194907);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class a
    implements View.OnClickListener
  {
    a(FTSBizDetailUI paramFTSBizDetailUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(194896);
      b localb = new b();
      localb.bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$getFooterView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      FTSBizDetailUI.a(this.tKi, this.tKi.getQuery());
      paramView = FTSBizDetailUI.a(this.tKi);
      if (paramView != null) {
        FTSBizDetailUI.a(this.tKi, paramView);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$getFooterView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(194896);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$updateFooterView$2$1$1", "com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$$special$$inlined$forEachIndexed$lambda$1"})
  static final class b
    implements View.OnClickListener
  {
    b(FTSBizDetailUI paramFTSBizDetailUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(194897);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$updateFooterView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      p.g(paramView, "it");
      paramView = paramView.getTag();
      if ((paramView != null) && ((paramView instanceof ajh)))
      {
        FTSBizDetailUI.a(this.tKi, ((ajh)paramView).GyJ.Hxp);
        localObject = FTSBizDetailUI.a(this.tKi);
        if (localObject != null) {
          FTSBizDetailUI.a(this.tKi, (ajh)paramView, (ciy)localObject);
        }
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/FTSBizDetailUI$updateFooterView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(194897);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBizDetailUI
 * JD-Core Version:    0.7.0.1
 */