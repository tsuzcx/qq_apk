package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.fts.a.d.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.protocal.protobuf.eba;
import com.tencent.mm.protocal.protobuf.ebb;
import com.tencent.mm.protocal.protobuf.eqy;
import com.tencent.mm.protocal.protobuf.fkk;
import com.tencent.mm.protocal.protobuf.fkl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.search.FTSEditTextView;
import com.tencent.mm.ui.search.FTSSearchView;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.am;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/FTSBizDetailUI;", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "currentSearchId", "", "getCurrentSearchId", "()J", "setCurrentSearchId", "(J)V", "detailAdapter", "Lcom/tencent/mm/plugin/fts/ui/FTSBizDetailAdapter;", "exposeSugSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "pardusNetScene", "Lcom/tencent/mm/plugin/websearch/api/NetScenePardusSearch;", "relevantSearchLayout", "Landroid/widget/LinearLayout;", "searchResponse", "Lcom/tencent/mm/protocal/protobuf/PardusSearchResponse;", "sessionId", "getSessionId", "setSessionId", "showWebEntry", "", "webSearchBarLayout", "Landroid/view/View;", "webSearchDescTV", "Landroid/widget/TextView;", "webSearchDivider", "webSearchFooter", "webSearchLayout", "webSearchTitleTV", "createFTSBaseAdapter", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseAdapter;", "uiComponent", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseUIComponent;", "getFooterView", "getHint", "getLayoutId", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onEnd", "resultCount", "isFinished", "", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onScroll", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "visibleItemCount", "totalItemCount", "reportSugAction", "relatedSugItem", "Lcom/tencent/mm/protocal/protobuf/FTSRelatedSugItem;", "response", "type", "reportWebSearchBarAction", "resetUI", "setNoResultView", "startPardusSearch", "startSearch", "startWebSearch", "query", "stopSearch", "updateFooterView", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FTSBizDetailUI
  extends FTSBaseUI
  implements com.tencent.mm.am.h
{
  private int Hxo;
  private f Hym;
  private View Hyn;
  private View Hyo;
  private View Hyp;
  private View Hyq;
  private LinearLayout Hyr;
  private TextView Hys;
  private TextView Hyt;
  private ebb Hyu;
  private v Hyv;
  private long Hyw;
  private HashSet<String> Hyx;
  private final String TAG;
  private long sessionId;
  
  public FTSBizDetailUI()
  {
    AppMethodBeat.i(265548);
    this.TAG = "MicroMsg.FTS.FTSBizDetailUI";
    this.sessionId = com.tencent.mm.plugin.fts.a.d.Wd(69);
    this.Hyx = new HashSet();
    this.Hxo = 1;
    AppMethodBeat.o(265548);
  }
  
  private static final void a(FTSBizDetailUI paramFTSBizDetailUI, View paramView)
  {
    AppMethodBeat.i(265572);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFTSBizDetailUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/FTSBizDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFTSBizDetailUI, "this$0");
    paramFTSBizDetailUI.aEK(paramFTSBizDetailUI.query);
    paramView = paramFTSBizDetailUI.Hyu;
    if (paramView != null) {
      paramFTSBizDetailUI.a(paramView, 3);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/fts/ui/FTSBizDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(265572);
  }
  
  private final void a(aqp paramaqp, ebb paramebb, int paramInt)
  {
    AppMethodBeat.i(265566);
    eqy localeqy = new eqy();
    localeqy.abuE = ("bizsugresultreport=1&searchid=" + paramebb.aayf + "&query=" + r.as(this.query, "utf8") + "&scene=69&businesstype=1&type=" + paramInt + "&clienttimestamp=" + cn.bDw() + "&docid=" + paramaqp.ZxJ.abgw + "&sugpos=" + (paramaqp.crs + 1) + "&iss1sitem=0&sugresult=" + r.as(paramaqp.ZxJ.abiz, "utf8"));
    Log.i(this.TAG, kotlin.g.b.s.X("reportSugAction ", localeqy.abuE));
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)new ae(localeqy), 0);
    AppMethodBeat.o(265566);
  }
  
  private final void a(ebb paramebb, int paramInt)
  {
    AppMethodBeat.i(265560);
    eqy localeqy = new eqy();
    localeqy.abuE = ("bizsugresultreport=1&searchid=" + paramebb.aayf + "&query=" + r.as(this.query, "utf8") + "&scene=69&businesstype=1&type=" + paramInt + "&clienttimestamp=" + cn.bDw() + "&iss1sitem=1&docid=" + r.as(this.query, "utf8"));
    Log.i(this.TAG, kotlin.g.b.s.X("reportWebSearchBarAction ", localeqy.abuE));
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)new ae(localeqy), 0);
    AppMethodBeat.o(265560);
  }
  
  private final void aEK(String paramString)
  {
    AppMethodBeat.i(265551);
    long l = com.tencent.mm.plugin.fts.a.e.HrM;
    HashMap localHashMap = new HashMap();
    ((Map)localHashMap).put("sceneActionType", "1");
    ((Map)localHashMap).put("isHomePage", "0");
    ((Map)localHashMap).put("needCameraIcon", "0");
    Map localMap = (Map)localHashMap;
    Object localObject = am.aixg;
    localObject = this.Hyu;
    if (localObject == null) {
      localObject = "";
    }
    for (;;)
    {
      localObject = String.format("%s:%s:%s:%s", Arrays.copyOf(new Object[] { Integer.valueOf(35), localObject, paramString, Long.valueOf(this.Hyw) }, 4));
      kotlin.g.b.s.s(localObject, "java.lang.String.format(format, *args)");
      localMap.put("parentSearchID", localObject);
      ((Map)localHashMap).put("businessType", "1");
      ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).a((Context)this, 69, paramString, String.valueOf(l), false, (Map)localHashMap, 1);
      AppMethodBeat.o(265551);
      return;
      String str = ((ebb)localObject).aayf;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
  }
  
  private static final void b(FTSBizDetailUI paramFTSBizDetailUI, View paramView)
  {
    AppMethodBeat.i(265577);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFTSBizDetailUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/FTSBizDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFTSBizDetailUI, "this$0");
    paramView = paramView.getTag();
    if ((paramView != null) && ((paramView instanceof aqp)))
    {
      paramFTSBizDetailUI.aEK(((aqp)paramView).ZxJ.abiz);
      localObject = paramFTSBizDetailUI.Hyu;
      if (localObject != null) {
        paramFTSBizDetailUI.a((aqp)paramView, (ebb)localObject, 3);
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/fts/ui/FTSBizDetailUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(265577);
  }
  
  private final void dBz()
  {
    AppMethodBeat.i(265557);
    if (aj.aBu())
    {
      AppMethodBeat.o(265557);
      return;
    }
    Object localObject1 = this.Hyr;
    if (localObject1 != null) {
      ((LinearLayout)localObject1).removeAllViews();
    }
    localObject1 = this.Hyo;
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = this.Hyp;
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = this.Hys;
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)com.tencent.mm.plugin.fts.a.f.a(getString(p.g.fts_on_search_network), getString(p.g.fts_header_recommend_biz), (CharSequence)kotlin.g.b.s.X(this.query, "  ")));
    }
    localObject1 = this.Hyu;
    if (localObject1 != null)
    {
      localObject1 = ((ebb)localObject1).abgF;
      if (localObject1 != null)
      {
        localObject1 = ((fkl)localObject1).YIB;
        if (localObject1 != null)
        {
          int i;
          if (((LinkedList)localObject1).size() > 0)
          {
            i = 1;
            if (i == 0) {
              break label330;
            }
          }
          for (;;)
          {
            label146:
            if (localObject1 != null)
            {
              localObject1 = ((Iterable)localObject1).iterator();
              i = 0;
              for (;;)
              {
                if (((Iterator)localObject1).hasNext())
                {
                  Object localObject2 = ((Iterator)localObject1).next();
                  if (i < 0) {
                    kotlin.a.p.kkW();
                  }
                  Object localObject3 = (fkk)localObject2;
                  localObject2 = getLayoutInflater().inflate(p.e.fts_websearch_relevant_item, (ViewGroup)this.Hyr, false);
                  ((View)localObject2).setOnClickListener(new FTSBizDetailUI..ExternalSyntheticLambda1(this));
                  Object localObject4 = (TextView)((View)localObject2).findViewById(p.d.content);
                  ((TextView)localObject4).setText((CharSequence)((fkk)localObject3).abiz);
                  ((TextView)localObject4).setContentDescription((CharSequence)kotlin.g.b.s.X(((fkk)localObject3).abiz, getResources().getString(p.g.fts_search_biz_btn)));
                  localObject4 = new aqp();
                  ((aqp)localObject4).ZxJ = ((fkk)localObject3);
                  ((aqp)localObject4).crs = i;
                  ((View)localObject2).setTag(localObject4);
                  localObject3 = this.Hyr;
                  if (localObject3 != null) {
                    ((LinearLayout)localObject3).addView((View)localObject2);
                  }
                  i += 1;
                  continue;
                  i = 0;
                  break;
                  label330:
                  localObject1 = null;
                  break label146;
                }
              }
              localObject1 = this.Hyr;
              if (localObject1 != null) {
                ((LinearLayout)localObject1).setVisibility(0);
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(265557);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  protected final d a(e parame)
  {
    AppMethodBeat.i(265600);
    parame = this.Hym;
    if (parame != null)
    {
      parame = (d)parame;
      AppMethodBeat.o(265600);
      return parame;
    }
    parame = (FTSBizDetailUI)this;
    f localf = new f((e)this);
    parame.Hym = localf;
    parame = (d)localf;
    AppMethodBeat.o(265600);
    return parame;
  }
  
  public final void a(AbsListView paramAbsListView)
  {
    AppMethodBeat.i(265639);
    if (paramAbsListView == null)
    {
      paramAbsListView = new NullPointerException("null cannot be cast to non-null type android.widget.ListView");
      AppMethodBeat.o(265639);
      throw paramAbsListView;
    }
    int i = ((ListView)paramAbsListView).getHeaderViewsCount();
    Object localObject2 = this.Hym;
    ebb localebb = this.Hyu;
    Object localObject1;
    int j;
    int k;
    int m;
    if ((localObject2 != null) && (localebb != null))
    {
      localObject1 = this.Hyp;
      if ((localObject1 != null) && (((ListView)paramAbsListView).getLastVisiblePosition() >= ((f)localObject2).getCount() + i) && (((View)localObject1).getVisibility() == 0) && (this.Hxo == 1))
      {
        j = com.tencent.mm.cd.a.mt((Context)this);
        int[] arrayOfInt = new int[2];
        ((View)localObject1).getLocationOnScreen(arrayOfInt);
        if (((View)localObject1).getMeasuredHeight() + arrayOfInt[1] <= j)
        {
          this.Hxo = 2;
          a(localebb, 2);
        }
      }
      localObject1 = this.Hyr;
      if ((localObject1 != null) && (((ListView)paramAbsListView).getLastVisiblePosition() >= i + ((f)localObject2).getCount()) && (((LinearLayout)localObject1).getVisibility() == 0))
      {
        k = com.tencent.mm.cd.a.mt((Context)this);
        i = 0;
        m = ((LinearLayout)localObject1).getChildCount();
        if (m <= 0) {}
      }
    }
    for (;;)
    {
      j = i + 1;
      paramAbsListView = ((LinearLayout)localObject1).getChildAt(i);
      localObject2 = new int[2];
      paramAbsListView.getLocationOnScreen((int[])localObject2);
      i = paramAbsListView.getMeasuredHeight();
      int n = localObject2[1];
      paramAbsListView = paramAbsListView.getTag();
      if (paramAbsListView == null)
      {
        paramAbsListView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FTSRelatedSugItem");
        AppMethodBeat.o(265639);
        throw paramAbsListView;
      }
      paramAbsListView = (aqp)paramAbsListView;
      if ((n + i <= k) && (this.Hyx.add(paramAbsListView.ZxJ.abgw))) {
        a(paramAbsListView, localebb, 2);
      }
      if (j >= m)
      {
        AppMethodBeat.o(265639);
        return;
      }
      i = j;
    }
  }
  
  public final void ba(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(265616);
    super.ba(paramInt, paramBoolean);
    dBz();
    AppMethodBeat.o(265616);
  }
  
  protected final void eui()
  {
    AppMethodBeat.i(265624);
    super.eui();
    this.Hxo = 1;
    this.Hyu = null;
    View localView = this.Hyo;
    if (localView != null) {
      localView.setVisibility(8);
    }
    localView = this.Hyp;
    if (localView != null) {
      localView.setVisibility(8);
    }
    this.Hyx.clear();
    if (this.Hyv != null)
    {
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)this.Hyv);
      this.Hyv = null;
    }
    AppMethodBeat.o(265624);
  }
  
  protected final void fye()
  {
    AppMethodBeat.i(265619);
    super.fye();
    if (this.Hyv != null)
    {
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)this.Hyv);
      this.Hyv = null;
    }
    this.Hyw = com.tencent.mm.plugin.fts.a.d.Wd(69);
    Object localObject = new eba();
    ((eba)localObject).YWK = this.query;
    ((eba)localObject).SessionId = String.valueOf(this.sessionId);
    ((eba)localObject).aaye = String.valueOf(this.Hyw);
    ((eba)localObject).IJG = 69;
    ((eba)localObject).IKW = 1;
    ((eba)localObject).abgA = aj.asY(0);
    localObject = new v((eba)localObject);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localObject, 0);
    ah localah = ah.aiuX;
    this.Hyv = ((v)localObject);
    AppMethodBeat.o(265619);
  }
  
  protected final void fyp()
  {
    AppMethodBeat.i(265605);
    super.fyp();
    TextView localTextView = ePp();
    if (localTextView != null) {
      localTextView.setText((CharSequence)getString(p.g.contact_no_result));
    }
    fyy().setVisibility(0);
    AppMethodBeat.o(265605);
  }
  
  protected final View getFooterView()
  {
    AppMethodBeat.i(265614);
    this.Hyn = getLayoutInflater().inflate(p.e.fts_web_search_footer, null, false);
    Object localObject = this.Hyn;
    if (localObject != null)
    {
      this.Hyp = ((View)localObject).findViewById(p.d.web_search_bar_layout);
      this.Hyo = ((View)localObject).findViewById(p.d.web_search_layout);
      this.Hyq = ((View)localObject).findViewById(p.d.web_search_divider);
      this.Hys = ((TextView)((View)localObject).findViewById(p.d.web_search_title_tv));
      this.Hyt = ((TextView)((View)localObject).findViewById(p.d.web_search_desc_tv));
      this.Hyr = ((LinearLayout)((View)localObject).findViewById(p.d.relevant_search_layout));
    }
    localObject = this.Hyq;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.Hyt;
    if (localObject != null) {
      ((TextView)localObject).setVisibility(8);
    }
    localObject = this.Hyp;
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new FTSBizDetailUI..ExternalSyntheticLambda0(this));
    }
    localObject = this.Hyn;
    AppMethodBeat.o(265614);
    return localObject;
  }
  
  public final String getHint()
  {
    AppMethodBeat.i(265610);
    String str = getString(p.g.search_detail_page_hint, new Object[] { getString(p.g.fts_header_biz) });
    kotlin.g.b.s.s(str, "getString(R.string.searc…R.string.fts_header_biz))");
    AppMethodBeat.o(265610);
    return str;
  }
  
  public final int getLayoutId()
  {
    return p.e.fts_biz_detail_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(265586);
    super.onCreate(paramBundle);
    ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSImageLoader().fxg();
    com.tencent.mm.kernel.h.aZW().a(1076, (com.tencent.mm.am.h)this);
    this.Hye.getFtsEditText().jBL();
    this.Hye.getFtsEditText().aWT();
    this.Hye.getFtsEditText().aWS();
    AppMethodBeat.o(265586);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(265590);
    com.tencent.mm.kernel.h.aZW().b(1076, (com.tencent.mm.am.h)this);
    ((n)com.tencent.mm.kernel.h.az(n.class)).getFTSImageLoader().fxe();
    f localf = this.Hym;
    if (localf != null) {
      localf.finish();
    }
    super.onDestroy();
    AppMethodBeat.o(265590);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    Object localObject1 = null;
    AppMethodBeat.i(265630);
    paramString = this.Hyv;
    StringBuilder localStringBuilder;
    if (paramString != null)
    {
      if (!kotlin.g.b.s.p(paramp, paramString)) {
        break label119;
      }
      if (paramString != null)
      {
        this.Hyu = paramString.WnZ;
        paramp = this.TAG;
        localStringBuilder = new StringBuilder("onSceneEnd searchResponse GuideText:");
        paramString = this.Hyu;
        if (paramString != null) {
          break label124;
        }
        paramString = null;
        label68:
        localStringBuilder = localStringBuilder.append(paramString).append(" size:");
        paramString = this.Hyu;
        if (paramString != null) {
          break label132;
        }
        paramString = localObject1;
      }
    }
    for (;;)
    {
      Log.i(paramp, paramString);
      dBz();
      AppMethodBeat.o(265630);
      return;
      label119:
      paramString = null;
      break;
      label124:
      paramString = paramString.abgD;
      break label68;
      label132:
      Object localObject2 = paramString.abgF;
      paramString = localObject1;
      if (localObject2 != null)
      {
        localObject2 = ((fkl)localObject2).YIB;
        paramString = localObject1;
        if (localObject2 != null) {
          paramString = Integer.valueOf(((LinkedList)localObject2).size());
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSBizDetailUI
 * JD-Core Version:    0.7.0.1
 */