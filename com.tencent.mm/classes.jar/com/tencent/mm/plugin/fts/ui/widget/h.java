package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.b;
import com.tencent.mm.plugin.fts.ui.FTSMainUI;
import com.tencent.mm.plugin.fts.ui.c.c;
import com.tencent.mm.plugin.fts.ui.k;
import com.tencent.mm.plugin.fts.ui.o.d;
import com.tencent.mm.plugin.websearch.api.ag;
import com.tencent.mm.protocal.protobuf.amw;
import com.tencent.mm.protocal.protobuf.cpb;
import com.tencent.mm.protocal.protobuf.epl;
import com.tencent.mm.protocal.protobuf.epm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import kotlin.a.j;
import kotlin.g.a.a;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/fts/ui/widget/KeyboardSugLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "ftsMainUI", "Lcom/tencent/mm/plugin/fts/ui/FTSMainUI;", "(Lcom/tencent/mm/plugin/fts/ui/FTSMainUI;)V", "TAG", "", "clickListener", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/OnItemClickListener;", "getClickListener", "()Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/OnItemClickListener;", "currentQuery", "getCurrentQuery", "()Ljava/lang/String;", "setCurrentQuery", "(Ljava/lang/String;)V", "currentSearchId", "getCurrentSearchId", "setCurrentSearchId", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/fts/ui/widget/KeyboardSugItem;", "Lkotlin/collections/ArrayList;", "getDataList", "()Ljava/util/ArrayList;", "setDataList", "(Ljava/util/ArrayList;)V", "getFtsMainUI", "()Lcom/tencent/mm/plugin/fts/ui/FTSMainUI;", "isKeyboardShow", "", "isScrolled", "()Z", "setScrolled", "(Z)V", "lastStartTime", "", "netSceneKeyboardSug", "Lcom/tencent/mm/plugin/fts/ui/model/NetSceneKeyboardSug;", "getNetSceneKeyboardSug", "()Lcom/tencent/mm/plugin/fts/ui/model/NetSceneKeyboardSug;", "setNetSceneKeyboardSug", "(Lcom/tencent/mm/plugin/fts/ui/model/NetSceneKeyboardSug;)V", "recyclerView", "Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "getRecyclerView", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerView;", "setRecyclerView", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerView;)V", "response", "Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchResponse;", "getResponse", "()Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchResponse;", "setResponse", "(Lcom/tencent/mm/protocal/protobuf/KeyBoardSugSearchResponse;)V", "scrollListener", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "getScrollListener", "()Lcom/tencent/mm/view/recyclerview/WxRVListener;", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "destroy", "", "onKeyboardHide", "onKeyboardShow", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportSugAction", "sugItem", "Lcom/tencent/mm/protocal/protobuf/FTSRelatedSugItem;", "action", "clickType", "reset", "startSearch", "query", "searchId", "startWebSearch", "stopSearch", "updateView", "ui-fts_release"})
public final class h
  implements i
{
  final b BRV;
  boolean BRZ;
  private final m BSa;
  public String BSb;
  public cpb BSc;
  public c BSd;
  public String BSe;
  public boolean BSf;
  final FTSMainUI BSg;
  private final String TAG;
  ArrayList<g> mXB;
  long pZO;
  public WxRecyclerView xUj;
  
  public h(FTSMainUI paramFTSMainUI)
  {
    AppMethodBeat.i(192810);
    this.BSg = paramFTSMainUI;
    this.TAG = "MicroMsg.FTS.KeyboardSugLogic";
    paramFTSMainUI = this.BSg.findViewById(o.d.fts_keyboard_sug_rv);
    p.j(paramFTSMainUI, "ftsMainUI.findViewById(R.id.fts_keyboard_sug_rv)");
    this.xUj = ((WxRecyclerView)paramFTSMainUI);
    this.mXB = new ArrayList();
    this.BSa = ((m)new h.d(this));
    this.BRV = ((b)new b(this));
    com.tencent.mm.kernel.h.aGY().a(4591, (i)this);
    paramFTSMainUI = this.xUj;
    this.BSg.getContext();
    paramFTSMainUI.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(0, false));
    paramFTSMainUI = new WxRecyclerAdapter((com.tencent.mm.view.recyclerview.f)new a(this), this.mXB, true);
    this.xUj.setAdapter((RecyclerView.a)paramFTSMainUI);
    paramFTSMainUI.YTa = this.BSa;
    this.BSb = "";
    this.BSe = "";
    AppMethodBeat.o(192810);
  }
  
  private void updateView()
  {
    AppMethodBeat.i(192794);
    Object localObject1 = this.BSc;
    if (localObject1 != null)
    {
      localObject1 = ((cpb)localObject1).TwM;
      if (localObject1 != null)
      {
        localObject1 = ((epm)localObject1).RLp;
        if (localObject1 != null)
        {
          this.mXB.clear();
          this.mXB.add(new g());
          localObject1 = ((Iterable)localObject1).iterator();
          int i = 0;
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = ((Iterator)localObject1).next();
            if (i < 0) {
              j.iBO();
            }
            localObject2 = (epl)localObject2;
            localObject2 = new g(i + 1L, 1, (epl)localObject2);
            this.mXB.add(localObject2);
            i += 1;
          }
          if (!this.BSf) {
            break label187;
          }
          this.xUj.setVisibility(0);
          localObject1 = this.xUj.getAdapter();
          if (localObject1 == null) {
            break label199;
          }
          ((RecyclerView.a)localObject1).notifyDataSetChanged();
        }
      }
    }
    label187:
    label199:
    for (localObject1 = x.aazN;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        ((h)this).xUj.setVisibility(8);
        localObject1 = x.aazN;
      }
      AppMethodBeat.o(192794);
      return;
      this.xUj.setVisibility(8);
      break;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    Object localObject = null;
    AppMethodBeat.i(192802);
    Log.i(this.TAG, "onSceneEnd " + paramInt1 + ' ' + paramInt2 + ' ' + paramString);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.fts.ui.model.NetSceneKeyboardSug");
        AppMethodBeat.o(192802);
        throw paramString;
      }
      paramq = ((c)paramq).lKU;
      paramString = localObject;
      if (paramq != null) {
        paramString = paramq.bhY();
      }
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.KeyBoardSugSearchResponse");
        AppMethodBeat.o(192802);
        throw paramString;
      }
      this.BSc = ((cpb)paramString);
      updateView();
      AppMethodBeat.o(192802);
      return;
    }
    this.BSc = null;
    AppMethodBeat.o(192802);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(192780);
    this.BRZ = false;
    this.BSc = null;
    this.BSb = "";
    this.BSe = "";
    c localc = this.BSd;
    if (localc != null)
    {
      com.tencent.mm.kernel.h.aGY().a((q)localc);
      this.BSd = null;
    }
    com.tencent.mm.ae.d.uiThread((a)new h.c(this));
    AppMethodBeat.o(192780);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/fts/ui/widget/KeyboardSugLogic$buildItemCoverts$1", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvert", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "type", "", "ui-fts_release"})
  public static final class a
    implements com.tencent.mm.view.recyclerview.f
  {
    public final com.tencent.mm.view.recyclerview.e<?> yx(int paramInt)
    {
      AppMethodBeat.i(190950);
      switch (paramInt)
      {
      default: 
        locale = (com.tencent.mm.view.recyclerview.e)new e(this.BSh.BRV);
        AppMethodBeat.o(190950);
        return locale;
      }
      com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)new f();
      AppMethodBeat.o(190950);
      return locale;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "position", "", "id", "", "onItemClick"})
  static final class b
    implements b
  {
    b(h paramh) {}
    
    public final void S(View paramView, int paramInt)
    {
      AppMethodBeat.i(192503);
      paramView = this.BSh.mXB.get(paramInt);
      p.j(paramView, "dataList[position]");
      paramView = ((g)paramView).BRY;
      if (paramView != null)
      {
        this.BSh.BSg.hideVKB();
        amw localamw = new amw();
        localamw.CqR = paramInt;
        localamw.SwV = paramView;
        Object localObject2 = this.BSh;
        p.k(localamw, "sugItem");
        String str = localamw.SwV.TSb;
        ((h)localObject2).BSg.erR().erQ();
        paramView = (CharSequence)str;
        ag localag;
        if ((paramView == null) || (paramView.length() == 0))
        {
          paramInt = 1;
          if ((paramInt == 0) && (System.currentTimeMillis() - ((h)localObject2).pZO > 1000L))
          {
            ((h)localObject2).pZO = System.currentTimeMillis();
            localag = new ag();
            localag.context = ((Context)((h)localObject2).BSg.getContext());
            localag.scene = 74;
            localag.sessionId = String.valueOf(com.tencent.mm.plugin.fts.a.e.BHi);
            localag.query = str;
            localag.PyA = true;
            Object localObject1 = localamw.SwV.Usj;
            paramView = (View)localObject1;
            if (localObject1 == null) {
              paramView = "";
            }
            localag.PyH = paramView;
            paramView = ((h)localObject2).BSc;
            if (paramView != null)
            {
              localObject1 = af.aaBG;
              paramView = String.format("%s:%s:%s:%s", Arrays.copyOf(new Object[] { Integer.valueOf(36), paramView.Tky, str, ((h)localObject2).BSe }, 4));
              p.j(paramView, "java.lang.String.format(format, *args)");
              localag.PyI = paramView;
              localObject2 = localag.fPy;
              p.j(localObject2, "params.extParams");
              localObject1 = localamw.SwV.TPZ;
              paramView = (View)localObject1;
              if (localObject1 == null) {
                paramView = "";
              }
              ((Map)localObject2).put("sugId", paramView);
              paramView = localag.fPy;
              p.j(paramView, "params.extParams");
              paramView.put("isSug", "1");
              paramView = localag.fPy;
              p.j(paramView, "params.extParams");
              paramView.put("prefixSug", str);
              paramView = localag.fPy;
              p.j(paramView, "params.extParams");
              paramView.put("sceneActionType", "6");
              paramView = (CharSequence)localag.PyH;
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
            paramView = localag.fPy;
            p.j(paramView, "params.extParams");
            paramView.put("hasCacheJsonResult", "1");
          }
          ((com.tencent.mm.plugin.websearch.api.h)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.websearch.api.h.class)).a(localag);
          h.a(this.BSh, localamw, 2, 1);
          AppMethodBeat.o(192503);
          return;
          paramInt = 0;
          break;
        }
      }
      AppMethodBeat.o(192503);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.h
 * JD-Core Version:    0.7.0.1
 */