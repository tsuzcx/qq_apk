package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.c.c;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.b;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.ui.FTSBaseMainUI;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.websearch.api.ae;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.protocal.protobuf.aqp;
import com.tencent.mm.protocal.protobuf.dfv;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.eqy;
import com.tencent.mm.protocal.protobuf.fkk;
import com.tencent.mm.protocal.protobuf.fkl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.m;
import com.tencent.mm.view.recyclerview.n;
import com.tencent.mm.view.recyclerview.o;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.am;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/widget/KeyboardSugLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "ftsMainUI", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseMainUI;", "(Lcom/tencent/mm/plugin/fts/ui/FTSBaseMainUI;)V", "TAG", "", "clickListener", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/OnItemClickListener;", "getClickListener", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/OnItemClickListener;", "currentQuery", "getCurrentQuery", "()Ljava/lang/String;", "setCurrentQuery", "(Ljava/lang/String;)V", "currentSearchId", "getCurrentSearchId", "setCurrentSearchId", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/fts/ui/widget/KeyboardSugItem;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "getFtsMainUI", "()Lcom/tencent/mm/plugin/fts/ui/FTSBaseMainUI;", "isKeyboardShow", "", "isScrolled", "()Z", "setScrolled", "(Z)V", "lastStartTime", "", "netSceneKeyboardSug", "Lcom/tencent/mm/plugin/fts/ui/model/NetSceneKeyboardSug;", "getNetSceneKeyboardSug", "()Lcom/tencent/mm/plugin/fts/ui/model/NetSceneKeyboardSug;", "setNetSceneKeyboardSug", "(Lcom/tencent/mm/plugin/fts/ui/model/NetSceneKeyboardSug;)V", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "response", "Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchResponse;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchResponse;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchResponse;)V", "scrollListener", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "getScrollListener", "()Lcom/tencent/mm/view/recyclerview/WxRVListener;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "destroy", "", "onKeyboardHide", "onKeyboardShow", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportSugAction", "sugItem", "Lcom/tencent/mm/protocal/protobuf/FTSRelatedSugItem;", "action", "clickType", "reset", "startSearch", "query", "searchId", "startWebSearch", "stopSearch", "updateView", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  implements com.tencent.mm.am.h
{
  public WxRecyclerView AZd;
  final b HDF;
  private final FTSBaseMainUI HDH;
  boolean HDI;
  private final o HDJ;
  public String HDK;
  public dfv HDL;
  public com.tencent.mm.plugin.fts.ui.d.c HDM;
  public String HDN;
  public boolean HDO;
  private final String TAG;
  private ArrayList<i> pUj;
  private long teM;
  
  public j(FTSBaseMainUI paramFTSBaseMainUI)
  {
    AppMethodBeat.i(265884);
    this.HDH = paramFTSBaseMainUI;
    this.TAG = "MicroMsg.FTS.KeyboardSugLogic";
    this.AZd = ((WxRecyclerView)this.HDH.findViewById(p.d.fts_keyboard_sug_rv));
    this.pUj = new ArrayList();
    this.HDJ = ((o)new c(this));
    this.HDF = new j..ExternalSyntheticLambda0(this);
    com.tencent.mm.kernel.h.aZW().a(4591, (com.tencent.mm.am.h)this);
    paramFTSBaseMainUI = this.AZd;
    this.HDH.getContext();
    paramFTSBaseMainUI.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(0, false));
    paramFTSBaseMainUI = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.g)new a(this), this.pUj, true);
    this.AZd.setAdapter((RecyclerView.a)paramFTSBaseMainUI);
    paramFTSBaseMainUI.agOS = this.HDJ;
    this.HDK = "";
    this.HDN = "";
    AppMethodBeat.o(265884);
  }
  
  private static final void a(j paramj, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(265904);
    kotlin.g.b.s.u(paramj, "this$0");
    paramView = paramj.pUj.get(paramInt);
    kotlin.g.b.s.s(paramView, "dataList[position]");
    paramView = ((i)paramView).HDG;
    aqp localaqp;
    com.tencent.mm.plugin.websearch.api.ah localah;
    if (paramView != null)
    {
      paramj.HDH.hideVKB();
      localaqp = new aqp();
      localaqp.crs = paramInt;
      localaqp.ZxJ = paramView;
      kotlin.g.b.s.u(localaqp, "sugItem");
      String str = localaqp.ZxJ.abiz;
      paramj.HDH.HxP.HyQ = true;
      paramView = (CharSequence)str;
      if ((paramView != null) && (paramView.length() != 0)) {
        break label502;
      }
      paramInt = 1;
      if ((paramInt == 0) && (System.currentTimeMillis() - paramj.teM > 1000L))
      {
        paramj.teM = System.currentTimeMillis();
        localah = new com.tencent.mm.plugin.websearch.api.ah();
        localah.context = ((Context)paramj.HDH.getContext());
        localah.scene = 74;
        localah.sessionId = String.valueOf(e.HrM);
        localah.query = str;
        localah.WoH = true;
        Object localObject = localaqp.ZxJ.abLm;
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = "";
        }
        localah.WoO = paramView;
        paramView = paramj.HDL;
        if (paramView != null)
        {
          localObject = am.aixg;
          paramView = String.format("%s:%s:%s:%s", Arrays.copyOf(new Object[] { Integer.valueOf(36), paramView.aayf, str, paramj.HDN }, 4));
          kotlin.g.b.s.s(paramView, "java.lang.String.format(format, *args)");
          localah.WoP = paramView;
          Map localMap = localah.hVt;
          kotlin.g.b.s.s(localMap, "params.extParams");
          localObject = localaqp.ZxJ.abgw;
          paramView = (View)localObject;
          if (localObject == null) {
            paramView = "";
          }
          localMap.put("sugId", paramView);
          paramView = localah.hVt;
          kotlin.g.b.s.s(paramView, "params.extParams");
          paramView.put("isSug", "1");
          paramView = localah.hVt;
          kotlin.g.b.s.s(paramView, "params.extParams");
          paramView.put("prefixSug", str);
          paramView = localah.hVt;
          kotlin.g.b.s.s(paramView, "params.extParams");
          paramView.put("sceneActionType", "6");
          paramView = (CharSequence)localah.WoO;
          if ((paramView != null) && (paramView.length() != 0)) {
            break label507;
          }
        }
      }
    }
    label502:
    label507:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0)
      {
        paramView = localah.hVt;
        kotlin.g.b.s.s(paramView, "params.extParams");
        paramView.put("hasCacheJsonResult", "1");
      }
      ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.websearch.api.h.class)).a(localah);
      paramj.a(localaqp, 2, 1);
      AppMethodBeat.o(265904);
      return;
      paramInt = 0;
      break;
    }
  }
  
  private final void a(aqp paramaqp, int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    AppMethodBeat.i(265900);
    Object localObject2 = this.HDL;
    eqy localeqy;
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    if (localObject2 != null)
    {
      localeqy = new eqy();
      localStringBuilder1 = new StringBuilder();
      localStringBuilder2 = localStringBuilder1.append("iskeyboardsug=1&searchid=").append(((dfv)localObject2).aayf).append("&query=").append(r.as(this.HDK, "utf8")).append("&action=").append(paramInt1).append("&scene=74&clienttimestamp=").append(cn.bDw()).append("&docid=").append(paramaqp.ZxJ.abgw).append("&resultcount=");
      localObject2 = ((dfv)localObject2).aaLt;
      if (localObject2 != null) {
        break label304;
      }
      paramInt1 = 0;
      localStringBuilder2 = localStringBuilder2.append(paramInt1).append("&words=").append(r.as(paramaqp.ZxJ.abiz, "utf8")).append("&requestId=").append(this.HDN).append("&longitude=");
      paramaqp = aj.dch();
      if (paramaqp != null) {
        break label330;
      }
      paramaqp = null;
      label192:
      localStringBuilder2 = localStringBuilder2.append(paramaqp).append("&latitude=");
      paramaqp = aj.dch();
      if (paramaqp != null) {
        break label341;
      }
    }
    label304:
    label330:
    label341:
    for (paramaqp = localObject1;; paramaqp = Float.valueOf(paramaqp.ZaH))
    {
      localStringBuilder2.append(paramaqp).append("&sessionid=").append(e.HrM).append("&clicktype=");
      localStringBuilder1.append(paramInt2);
      localeqy.abuE = localStringBuilder1.toString();
      Log.i(this.TAG, kotlin.g.b.s.X("reportSugAction ", localeqy.abuE));
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)new ae(localeqy), 0);
      AppMethodBeat.o(265900);
      return;
      localObject2 = ((fkl)localObject2).YIB;
      if (localObject2 == null)
      {
        paramInt1 = 0;
        break;
      }
      paramInt1 = ((LinkedList)localObject2).size();
      break;
      paramaqp = Float.valueOf(paramaqp.ZaG);
      break label192;
    }
  }
  
  private void updateView()
  {
    AppMethodBeat.i(265893);
    Object localObject1 = this.HDL;
    if (localObject1 == null) {
      localObject1 = null;
    }
    for (;;)
    {
      if (localObject1 == null) {
        ((j)this).AZd.setVisibility(8);
      }
      AppMethodBeat.o(265893);
      return;
      localObject1 = ((dfv)localObject1).aaLt;
      if (localObject1 == null)
      {
        localObject1 = null;
      }
      else
      {
        localObject1 = ((fkl)localObject1).YIB;
        if (localObject1 == null)
        {
          localObject1 = null;
        }
        else
        {
          this.pUj.clear();
          this.pUj.add(new i());
          localObject1 = ((Iterable)localObject1).iterator();
          int i = 0;
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = ((Iterator)localObject1).next();
            if (i < 0) {
              kotlin.a.p.kkW();
            }
            localObject2 = (fkk)localObject2;
            localObject2 = new i(i + 1L, 1, (fkk)localObject2);
            this.pUj.add(localObject2);
            i += 1;
          }
          if (this.HDO) {
            this.AZd.setVisibility(0);
          }
          for (;;)
          {
            localObject1 = this.AZd.getAdapter();
            if (localObject1 != null) {
              break label204;
            }
            localObject1 = null;
            break;
            this.AZd.setVisibility(8);
          }
          label204:
          ((RecyclerView.a)localObject1).bZE.notifyChanged();
          localObject1 = kotlin.ah.aiuX;
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    Object localObject = null;
    AppMethodBeat.i(265915);
    Log.i(this.TAG, "onSceneEnd " + paramInt1 + ' ' + paramInt2 + ' ' + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.fts.ui.model.NetSceneKeyboardSug");
        AppMethodBeat.o(265915);
        throw paramString;
      }
      paramString = ((com.tencent.mm.plugin.fts.ui.d.c)paramp).oDw;
      if (paramString == null) {}
      for (paramString = localObject; paramString == null; paramString = c.c.b(paramString.otC))
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.KeyBoardSugSearchResponse");
        AppMethodBeat.o(265915);
        throw paramString;
      }
      this.HDL = ((dfv)paramString);
      updateView();
      AppMethodBeat.o(265915);
      return;
    }
    this.HDL = null;
    AppMethodBeat.o(265915);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(265911);
    this.HDI = false;
    this.HDL = null;
    this.HDK = "";
    this.HDN = "";
    com.tencent.mm.plugin.fts.ui.d.c localc = this.HDM;
    if (localc != null)
    {
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localc);
      this.HDM = null;
    }
    d.uiThread((a)new j.b(this));
    AppMethodBeat.o(265911);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/fts/ui/widget/KeyboardSugLogic$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.mm.view.recyclerview.g
  {
    a(j paramj) {}
    
    public final f<?> yF(int paramInt)
    {
      AppMethodBeat.i(265923);
      if (paramInt == 0)
      {
        localf = (f)new h();
        AppMethodBeat.o(265923);
        return localf;
      }
      f localf = (f)new g(this.HDP.HDF);
      AppMethodBeat.o(265923);
      return localf;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/fts/ui/widget/KeyboardSugLogic$scrollListener$1", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements o
  {
    c(j paramj) {}
    
    public final void a(RecyclerView paramRecyclerView, m paramm)
    {
      AppMethodBeat.i(265927);
      kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
      kotlin.g.b.s.u(paramm, "data");
      if (paramm.state == 1) {
        this.HDP.HDI = true;
      }
      paramm = (Iterable)paramm.agOF;
      paramRecyclerView = this.HDP;
      paramm = paramm.iterator();
      int i = 0;
      if (paramm.hasNext())
      {
        Object localObject = paramm.next();
        if (i < 0) {
          kotlin.a.p.kkW();
        }
        localObject = ((i)((n)localObject).agOG).HDG;
        aqp localaqp;
        if (localObject != null)
        {
          localaqp = new aqp();
          localaqp.crs = i;
          localaqp.ZxJ = ((fkk)localObject);
          if (!paramRecyclerView.HDI) {
            break label147;
          }
        }
        label147:
        for (int j = 2;; j = 0)
        {
          j.a(paramRecyclerView, localaqp, j);
          i += 1;
          break;
        }
      }
      AppMethodBeat.o(265927);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.j
 * JD-Core Version:    0.7.0.1
 */