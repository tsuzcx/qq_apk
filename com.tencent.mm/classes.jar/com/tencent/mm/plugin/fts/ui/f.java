package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.protocal.protobuf.czf;
import com.tencent.mm.protocal.protobuf.efk;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/fts/ui/FTSBizDetailAdapter;", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseAdapter;", "Lcom/tencent/mm/plugin/fts/api/ui/IFTSUIUnit$UIUnitDataReadyCallback;", "ftsBaseUIComponent", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseUIComponent;", "searchScene", "", "(Lcom/tencent/mm/plugin/fts/ui/FTSBaseUIComponent;I)V", "TAG", "", "bizUIUnit", "Lcom/tencent/mm/plugin/fts/api/ui/IFTSUIUnit;", "searchHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getSearchScene", "()I", "createDataItem", "Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;", "position", "doSearch", "", "handleItemClick", "", "view", "Landroid/view/View;", "ftsDataItem", "isHandled", "onDataReady", "unit", "query", "isSuccess", "onScroll", "Landroid/widget/AbsListView;", "firstVisibleItem", "visibleItemCount", "totalItemCount", "ui-fts_release"})
public final class f
  extends d
  implements e.b
{
  private final String TAG;
  private final int mve;
  private com.tencent.mm.plugin.fts.a.d.e xaU;
  private final MMHandler xad;
  
  public f(e parame)
  {
    super(parame);
    AppMethodBeat.i(235424);
    this.mve = 5;
    this.TAG = "MicroMsg.FTS.FTSBizDetailAdapter";
    parame = ((n)g.ah(n.class)).createFTSUIUnit(4208, getContext(), (e.b)this, this.mve);
    p.g(parame, "MMKernel.plugin(IPluginF…ntext, this, searchScene)");
    this.xaU = parame;
    this.xad = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(235424);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a No(int paramInt)
  {
    AppMethodBeat.i(235419);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.xaU.No(paramInt);
    p.g(locala, "bizUIUnit.createDataItem(position)");
    AppMethodBeat.o(235419);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(235422);
    setCount(this.xaU.Nn(0));
    notifyDataSetChanged();
    ax(getCount(), true);
    AppMethodBeat.o(235422);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(235421);
    paramBoolean = this.xaU.a(paramView, parama, paramBoolean);
    AppMethodBeat.o(235421);
    return paramBoolean;
  }
  
  protected final void dPb()
  {
    AppMethodBeat.i(235420);
    this.xaU.a(getQuery(), this.xad, new HashSet(), 0L);
    AppMethodBeat.o(235420);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(235423);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if ((dPg() instanceof FTSBizDetailUI))
    {
      Object localObject1 = dPg();
      if (localObject1 == null)
      {
        paramAbsListView = new t("null cannot be cast to non-null type com.tencent.mm.plugin.fts.ui.FTSBizDetailUI");
        AppMethodBeat.o(235423);
        throw paramAbsListView;
      }
      localObject1 = (FTSBizDetailUI)localObject1;
      if (paramAbsListView == null)
      {
        paramAbsListView = new t("null cannot be cast to non-null type android.widget.ListView");
        AppMethodBeat.o(235423);
        throw paramAbsListView;
      }
      paramInt1 = ((ListView)paramAbsListView).getHeaderViewsCount();
      Object localObject3 = ((FTSBizDetailUI)localObject1).xaV;
      czf localczf = ((FTSBizDetailUI)localObject1).xbd;
      if ((localObject3 != null) && (localczf != null))
      {
        Object localObject2 = ((FTSBizDetailUI)localObject1).xaY;
        if ((localObject2 != null) && (paramAbsListView.getLastVisiblePosition() >= ((f)localObject3).getCount() + paramInt1) && (((View)localObject2).getVisibility() == 0) && (((FTSBizDetailUI)localObject1).xat == 1))
        {
          paramInt2 = com.tencent.mm.cb.a.jo((Context)localObject1);
          int[] arrayOfInt = new int[2];
          ((View)localObject2).getLocationOnScreen(arrayOfInt);
          if (((View)localObject2).getMeasuredHeight() + arrayOfInt[1] <= paramInt2)
          {
            ((FTSBizDetailUI)localObject1).xat = 2;
            ((FTSBizDetailUI)localObject1).a(localczf, 2);
          }
        }
        localObject2 = ((FTSBizDetailUI)localObject1).xba;
        if (localObject2 != null)
        {
          if ((paramAbsListView.getLastVisiblePosition() >= paramInt1 + ((f)localObject3).getCount()) && (((LinearLayout)localObject2).getVisibility() == 0))
          {
            paramInt2 = com.tencent.mm.cb.a.jo((Context)localObject1);
            paramInt3 = ((LinearLayout)localObject2).getChildCount();
            paramInt1 = 0;
            while (paramInt1 < paramInt3)
            {
              paramAbsListView = ((LinearLayout)localObject2).getChildAt(paramInt1);
              localObject3 = new int[2];
              paramAbsListView.getLocationOnScreen((int[])localObject3);
              p.g(paramAbsListView, "childView");
              int i = paramAbsListView.getMeasuredHeight();
              int j = localObject3[1];
              paramAbsListView = paramAbsListView.getTag();
              if (paramAbsListView == null)
              {
                paramAbsListView = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FTSRelatedSugItem");
                AppMethodBeat.o(235423);
                throw paramAbsListView;
              }
              paramAbsListView = (alv)paramAbsListView;
              if ((j + i <= paramInt2) && (((FTSBizDetailUI)localObject1).xbg.add(paramAbsListView.Lux.MEq))) {
                ((FTSBizDetailUI)localObject1).a(paramAbsListView, localczf, 2);
              }
              paramInt1 += 1;
            }
          }
          AppMethodBeat.o(235423);
          return;
        }
      }
    }
    AppMethodBeat.o(235423);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.f
 * JD-Core Version:    0.7.0.1
 */