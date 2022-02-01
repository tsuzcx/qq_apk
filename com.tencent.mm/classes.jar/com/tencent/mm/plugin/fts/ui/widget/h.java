package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.b;
import com.tencent.mm.plugin.fts.ui.FTSMainUI;
import com.tencent.mm.plugin.fts.ui.c.c;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.protocal.protobuf.cgf;
import com.tencent.mm.protocal.protobuf.efk;
import com.tencent.mm.protocal.protobuf.efl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.g.a.a;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/fts/ui/widget/KeyboardSugLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "ftsMainUI", "Lcom/tencent/mm/plugin/fts/ui/FTSMainUI;", "(Lcom/tencent/mm/plugin/fts/ui/FTSMainUI;)V", "TAG", "", "clickListener", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/OnItemClickListener;", "getClickListener", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/OnItemClickListener;", "currentQuery", "getCurrentQuery", "()Ljava/lang/String;", "setCurrentQuery", "(Ljava/lang/String;)V", "currentSearchId", "getCurrentSearchId", "setCurrentSearchId", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/fts/ui/widget/KeyboardSugItem;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "getFtsMainUI", "()Lcom/tencent/mm/plugin/fts/ui/FTSMainUI;", "isKeyboardShow", "", "isScrolled", "()Z", "setScrolled", "(Z)V", "lastStartTime", "", "netSceneKeyboardSug", "Lcom/tencent/mm/plugin/fts/ui/model/NetSceneKeyboardSug;", "getNetSceneKeyboardSug", "()Lcom/tencent/mm/plugin/fts/ui/model/NetSceneKeyboardSug;", "setNetSceneKeyboardSug", "(Lcom/tencent/mm/plugin/fts/ui/model/NetSceneKeyboardSug;)V", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "response", "Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchResponse;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchResponse;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchResponse;)V", "scrollListener", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "getScrollListener", "()Lcom/tencent/mm/view/recyclerview/WxRVListener;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "destroy", "", "onKeyboardHide", "onKeyboardShow", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportSugAction", "sugItem", "Lcom/tencent/mm/protocal/protobuf/FTSRelatedSugItem;", "action", "clickType", "reset", "startSearch", "query", "searchId", "startWebSearch", "stopSearch", "updateView", "ui-fts_release"})
public final class h
  implements i
{
  private final String TAG;
  ArrayList<g> kgc;
  long mZq;
  public WxRecyclerView ufR;
  final b xfK;
  boolean xfO;
  private final com.tencent.mm.view.recyclerview.l xfP;
  public String xfQ;
  public cgf xfR;
  public c xfS;
  public String xfT;
  public boolean xfU;
  final FTSMainUI xfV;
  
  public h(FTSMainUI paramFTSMainUI)
  {
    AppMethodBeat.i(235467);
    this.xfV = paramFTSMainUI;
    this.TAG = "MicroMsg.FTS.KeyboardSugLogic";
    paramFTSMainUI = this.xfV.findViewById(2131301809);
    p.g(paramFTSMainUI, "ftsMainUI.findViewById(R.id.fts_keyboard_sug_rv)");
    this.ufR = ((WxRecyclerView)paramFTSMainUI);
    this.kgc = new ArrayList();
    this.xfP = ((com.tencent.mm.view.recyclerview.l)new d(this));
    this.xfK = ((b)new b(this));
    com.tencent.mm.kernel.g.azz().a(4591, (i)this);
    paramFTSMainUI = this.ufR;
    this.xfV.getContext();
    paramFTSMainUI.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(0, false));
    paramFTSMainUI = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new a(this), this.kgc, true);
    this.ufR.setAdapter((RecyclerView.a)paramFTSMainUI);
    paramFTSMainUI.RrA = this.xfP;
    this.xfQ = "";
    this.xfT = "";
    AppMethodBeat.o(235467);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(235465);
    Object localObject1 = this.xfR;
    if (localObject1 != null)
    {
      localObject1 = ((cgf)localObject1).MlS;
      if (localObject1 != null)
      {
        localObject1 = ((efl)localObject1).KKx;
        if (localObject1 != null)
        {
          this.kgc.clear();
          this.kgc.add(new g());
          localObject1 = ((Iterable)localObject1).iterator();
          int i = 0;
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = ((Iterator)localObject1).next();
            if (i < 0) {
              kotlin.a.j.hxH();
            }
            localObject2 = (efk)localObject2;
            localObject2 = new g(i + 1L, 1, (efk)localObject2);
            this.kgc.add(localObject2);
            i += 1;
          }
          if (!this.xfU) {
            break label187;
          }
          this.ufR.setVisibility(0);
          localObject1 = this.ufR.getAdapter();
          if (localObject1 == null) {
            break label199;
          }
          ((RecyclerView.a)localObject1).notifyDataSetChanged();
        }
      }
    }
    label187:
    label199:
    for (localObject1 = x.SXb;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        ((h)this).ufR.setVisibility(8);
        localObject1 = x.SXb;
      }
      AppMethodBeat.o(235465);
      return;
      this.ufR.setVisibility(8);
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    Object localObject = null;
    AppMethodBeat.i(235466);
    Log.i(this.TAG, "onSceneEnd " + paramInt1 + ' ' + paramInt2 + ' ' + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.fts.ui.model.NetSceneKeyboardSug");
        AppMethodBeat.o(235466);
        throw paramString;
      }
      paramq = ((c)paramq).iUB;
      paramString = localObject;
      if (paramq != null) {
        paramString = paramq.aYK();
      }
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.KeyBoardSugSearchResponse");
        AppMethodBeat.o(235466);
        throw paramString;
      }
      this.xfR = ((cgf)paramString);
      updateView();
      AppMethodBeat.o(235466);
      return;
    }
    this.xfR = null;
    AppMethodBeat.o(235466);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(235464);
    this.xfO = false;
    this.xfR = null;
    this.xfQ = "";
    this.xfT = "";
    c localc = this.xfS;
    if (localc != null)
    {
      com.tencent.mm.kernel.g.azz().a((q)localc);
      this.xfS = null;
    }
    com.tencent.mm.ac.d.h((a)new h.c(this));
    AppMethodBeat.o(235464);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/fts/ui/widget/KeyboardSugLogic$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "ui-fts_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> EC(int paramInt)
    {
      AppMethodBeat.i(235460);
      switch (paramInt)
      {
      default: 
        locale = (com.tencent.mm.view.recyclerview.e)new e(this.xfW.xfK);
        AppMethodBeat.o(235460);
        return locale;
      }
      com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)new f();
      AppMethodBeat.o(235460);
      return locale;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "position", "", "id", "", "onItemClick"})
  static final class b
    implements b
  {
    b(h paramh) {}
    
    public final void Q(View paramView, int paramInt)
    {
      AppMethodBeat.i(235461);
      paramView = this.xfW.kgc.get(paramInt);
      p.g(paramView, "dataList[position]");
      paramView = ((g)paramView).xfN;
      if (paramView != null)
      {
        this.xfW.xfV.hideVKB();
        alv localalv = new alv();
        localalv.xuA = paramInt;
        localalv.Lux = paramView;
        Object localObject2 = this.xfW;
        p.h(localalv, "sugItem");
        String str = localalv.Lux.MGp;
        ((h)localObject2).xfV.dPv().dPu();
        paramView = (CharSequence)str;
        ag localag;
        if ((paramView == null) || (paramView.length() == 0))
        {
          paramInt = 1;
          if ((paramInt == 0) && (System.currentTimeMillis() - ((h)localObject2).mZq > 1000L))
          {
            ((h)localObject2).mZq = System.currentTimeMillis();
            localag = new ag();
            localag.context = ((Context)((h)localObject2).xfV.getContext());
            localag.scene = 74;
            localag.sessionId = String.valueOf(com.tencent.mm.plugin.fts.a.e.wVm);
            localag.query = str;
            localag.IEk = true;
            Object localObject1 = localalv.Lux.NfG;
            paramView = (View)localObject1;
            if (localObject1 == null) {
              paramView = "";
            }
            localag.IEq = paramView;
            paramView = ((h)localObject2).xfR;
            if (paramView != null)
            {
              localObject1 = ae.SYK;
              paramView = String.format("%s:%s:%s:%s", Arrays.copyOf(new Object[] { Integer.valueOf(20), paramView.Mbb, str, ((h)localObject2).xfT }, 4));
              p.g(paramView, "java.lang.String.format(format, *args)");
              localag.IEr = paramView;
              localObject2 = localag.dVU;
              p.g(localObject2, "params.extParams");
              localObject1 = localalv.Lux.MEq;
              paramView = (View)localObject1;
              if (localObject1 == null) {
                paramView = "";
              }
              ((Map)localObject2).put("sugId", paramView);
              paramView = localag.dVU;
              p.g(paramView, "params.extParams");
              paramView.put("isSug", "1");
              paramView = localag.dVU;
              p.g(paramView, "params.extParams");
              paramView.put("prefixSug", str);
              paramView = localag.dVU;
              p.g(paramView, "params.extParams");
              paramView.put("sceneActionType", "6");
              paramView = (CharSequence)localag.IEq;
              if ((paramView != null) && (paramView.length() != 0)) {
                break label497;
              }
            }
          }
        }
        label497:
        for (paramInt = 1;; paramInt = 0)
        {
          if (paramInt == 0)
          {
            paramView = localag.dVU;
            p.g(paramView, "params.extParams");
            paramView.put("hasCacheJsonResult", "1");
          }
          ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.websearch.api.h.class)).a(localag);
          h.a(this.xfW, localalv, 2, 1);
          AppMethodBeat.o(235461);
          return;
          paramInt = 0;
          break;
        }
      }
      AppMethodBeat.o(235461);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/fts/ui/widget/KeyboardSugLogic$scrollListener$1", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "ui-fts_release"})
  public static final class d
    implements com.tencent.mm.view.recyclerview.l
  {
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj)
    {
      AppMethodBeat.i(235463);
      p.h(paramRecyclerView, "recyclerView");
      p.h(paramj, "data");
      if (paramj.state == 1) {
        this.xfW.xfO = true;
      }
      paramRecyclerView = ((Iterable)paramj.Rro).iterator();
      int i = 0;
      while (paramRecyclerView.hasNext())
      {
        paramj = paramRecyclerView.next();
        int j = i + 1;
        if (i < 0) {
          kotlin.a.j.hxH();
        }
        paramj = ((com.tencent.mm.view.recyclerview.k)paramj).Rrp;
        if (paramj == null)
        {
          paramRecyclerView = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.fts.ui.widget.KeyboardSugItem");
          AppMethodBeat.o(235463);
          throw paramRecyclerView;
        }
        Object localObject = ((g)paramj).xfN;
        if (localObject != null)
        {
          paramj = new alv();
          paramj.xuA = i;
          paramj.Lux = ((efk)localObject);
          localObject = this.xfW;
          if (this.xfW.xfO) {}
          for (i = 2;; i = 0)
          {
            h.a((h)localObject, paramj, 1, i);
            i = j;
            break;
          }
        }
        i = j;
      }
      AppMethodBeat.o(235463);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.h
 * JD-Core Version:    0.7.0.1
 */