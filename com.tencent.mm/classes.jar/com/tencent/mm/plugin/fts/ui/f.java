package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.protocal.protobuf.amw;
import com.tencent.mm.protocal.protobuf.dir;
import com.tencent.mm.protocal.protobuf.epl;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/fts/ui/FTSBizDetailAdapter;", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseAdapter;", "Lcom/tencent/mm/plugin/fts/api/ui/IFTSUIUnit$UIUnitDataReadyCallback;", "ftsBaseUIComponent", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseUIComponent;", "searchScene", "", "(Lcom/tencent/mm/plugin/fts/ui/FTSBaseUIComponent;I)V", "TAG", "", "bizUIUnit", "Lcom/tencent/mm/plugin/fts/api/ui/IFTSUIUnit;", "searchHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getSearchScene", "()I", "createDataItem", "Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;", "position", "doSearch", "", "handleItemClick", "", "view", "Landroid/view/View;", "ftsDataItem", "isHandled", "onDataReady", "unit", "query", "isSuccess", "onScroll", "Landroid/widget/AbsListView;", "firstVisibleItem", "visibleItemCount", "totalItemCount", "ui-fts_release"})
public final class f
  extends d
  implements e.b
{
  private com.tencent.mm.plugin.fts.a.d.e BMU;
  private final MMHandler BMc;
  private final String TAG;
  private final int ptD;
  
  public f(e parame)
  {
    super(parame);
    AppMethodBeat.i(194068);
    this.ptD = 5;
    this.TAG = "MicroMsg.FTS.FTSBizDetailAdapter";
    parame = ((n)h.ag(n.class)).createFTSUIUnit(4208, getContext(), (e.b)this, this.ptD);
    p.j(parame, "MMKernel.plugin(IPluginF…ntext, this, searchScene)");
    this.BMU = parame;
    this.BMc = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(194068);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a SC(int paramInt)
  {
    AppMethodBeat.i(194048);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.BMU.SC(paramInt);
    p.j(locala, "bizUIUnit.createDataItem(position)");
    AppMethodBeat.o(194048);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(194053);
    setCount(this.BMU.SB(0));
    notifyDataSetChanged();
    aB(getCount(), true);
    AppMethodBeat.o(194053);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(194052);
    paramBoolean = this.BMU.a(paramView, parama, paramBoolean);
    AppMethodBeat.o(194052);
    return paramBoolean;
  }
  
  protected final void erv()
  {
    AppMethodBeat.i(194050);
    this.BMU.a(getQuery(), this.BMc, new HashSet(), 0L);
    AppMethodBeat.o(194050);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(194064);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if ((erB() instanceof FTSBizDetailUI))
    {
      Object localObject1 = erB();
      if (localObject1 == null)
      {
        paramAbsListView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.fts.ui.FTSBizDetailUI");
        AppMethodBeat.o(194064);
        throw paramAbsListView;
      }
      localObject1 = (FTSBizDetailUI)localObject1;
      if (paramAbsListView == null)
      {
        paramAbsListView = new t("null cannot be cast to non-null type android.widget.ListView");
        AppMethodBeat.o(194064);
        throw paramAbsListView;
      }
      paramInt1 = ((ListView)paramAbsListView).getHeaderViewsCount();
      Object localObject3 = ((FTSBizDetailUI)localObject1).BMV;
      dir localdir = ((FTSBizDetailUI)localObject1).BNd;
      if ((localObject3 != null) && (localdir != null))
      {
        Object localObject2 = ((FTSBizDetailUI)localObject1).BMY;
        if ((localObject2 != null) && (paramAbsListView.getLastVisiblePosition() >= ((f)localObject3).getCount() + paramInt1) && (((View)localObject2).getVisibility() == 0) && (((FTSBizDetailUI)localObject1).BMs == 1))
        {
          paramInt2 = com.tencent.mm.ci.a.ks((Context)localObject1);
          int[] arrayOfInt = new int[2];
          ((View)localObject2).getLocationOnScreen(arrayOfInt);
          if (((View)localObject2).getMeasuredHeight() + arrayOfInt[1] <= paramInt2)
          {
            ((FTSBizDetailUI)localObject1).BMs = 2;
            ((FTSBizDetailUI)localObject1).a(localdir, 2);
          }
        }
        localObject2 = ((FTSBizDetailUI)localObject1).BNa;
        if (localObject2 != null)
        {
          if ((paramAbsListView.getLastVisiblePosition() >= paramInt1 + ((f)localObject3).getCount()) && (((LinearLayout)localObject2).getVisibility() == 0))
          {
            paramInt2 = com.tencent.mm.ci.a.ks((Context)localObject1);
            paramInt3 = ((LinearLayout)localObject2).getChildCount();
            paramInt1 = 0;
            while (paramInt1 < paramInt3)
            {
              paramAbsListView = ((LinearLayout)localObject2).getChildAt(paramInt1);
              localObject3 = new int[2];
              paramAbsListView.getLocationOnScreen((int[])localObject3);
              p.j(paramAbsListView, "childView");
              int i = paramAbsListView.getMeasuredHeight();
              int j = localObject3[1];
              paramAbsListView = paramAbsListView.getTag();
              if (paramAbsListView == null)
              {
                paramAbsListView = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FTSRelatedSugItem");
                AppMethodBeat.o(194064);
                throw paramAbsListView;
              }
              paramAbsListView = (amw)paramAbsListView;
              if ((j + i <= paramInt2) && (((FTSBizDetailUI)localObject1).BNg.add(paramAbsListView.SwV.TPZ))) {
                ((FTSBizDetailUI)localObject1).a(paramAbsListView, localdir, 2);
              }
              paramInt1 += 1;
            }
          }
          AppMethodBeat.o(194064);
          return;
        }
      }
    }
    AppMethodBeat.o(194064);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.f
 * JD-Core Version:    0.7.0.1
 */