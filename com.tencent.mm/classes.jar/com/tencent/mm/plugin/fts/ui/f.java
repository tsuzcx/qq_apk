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
import com.tencent.mm.protocal.protobuf.ajh;
import com.tencent.mm.protocal.protobuf.ciy;
import com.tencent.mm.protocal.protobuf.dlx;
import com.tencent.mm.sdk.platformtools.aq;
import d.g.b.p;
import d.l;
import d.v;
import java.util.HashSet;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/fts/ui/FTSBizDetailAdapter;", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseAdapter;", "Lcom/tencent/mm/plugin/fts/api/ui/IFTSUIUnit$UIUnitDataReadyCallback;", "ftsBaseUIComponent", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseUIComponent;", "searchScene", "", "(Lcom/tencent/mm/plugin/fts/ui/FTSBaseUIComponent;I)V", "TAG", "", "bizUIUnit", "Lcom/tencent/mm/plugin/fts/api/ui/IFTSUIUnit;", "searchHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getSearchScene", "()I", "createDataItem", "Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;", "position", "doSearch", "", "handleItemClick", "", "view", "Landroid/view/View;", "ftsDataItem", "isHandled", "onDataReady", "unit", "query", "isSuccess", "onScroll", "Landroid/widget/AbsListView;", "firstVisibleItem", "visibleItemCount", "totalItemCount", "ui-fts_release"})
public final class f
  extends d
  implements e.b
{
  private final String TAG;
  private final int lox;
  private com.tencent.mm.plugin.fts.a.d.e tJV;
  private final aq tJe;
  
  public f(e parame)
  {
    super(parame);
    AppMethodBeat.i(194895);
    this.lox = 5;
    this.TAG = "MicroMsg.FTS.FTSBizDetailAdapter";
    parame = ((n)g.ad(n.class)).createFTSUIUnit(4208, getContext(), (e.b)this, this.lox);
    p.g(parame, "MMKernel.plugin(IPluginF…ntext, this, searchScene)");
    this.tJV = parame;
    this.tJe = new aq(Looper.getMainLooper());
    AppMethodBeat.o(194895);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a Ho(int paramInt)
  {
    AppMethodBeat.i(194890);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.tJV.Ho(paramInt);
    p.g(locala, "bizUIUnit.createDataItem(position)");
    AppMethodBeat.o(194890);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(194893);
    setCount(this.tJV.Hn(0));
    notifyDataSetChanged();
    ao(getCount(), true);
    AppMethodBeat.o(194893);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(194892);
    paramBoolean = this.tJV.a(paramView, parama, paramBoolean);
    AppMethodBeat.o(194892);
    return paramBoolean;
  }
  
  protected final void cVS()
  {
    AppMethodBeat.i(194891);
    this.tJV.a(getQuery(), this.tJe, new HashSet(), 0L);
    AppMethodBeat.o(194891);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(194894);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if ((cVX() instanceof FTSBizDetailUI))
    {
      Object localObject1 = cVX();
      if (localObject1 == null)
      {
        paramAbsListView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.fts.ui.FTSBizDetailUI");
        AppMethodBeat.o(194894);
        throw paramAbsListView;
      }
      localObject1 = (FTSBizDetailUI)localObject1;
      if (paramAbsListView == null)
      {
        paramAbsListView = new v("null cannot be cast to non-null type android.widget.ListView");
        AppMethodBeat.o(194894);
        throw paramAbsListView;
      }
      paramInt1 = ((ListView)paramAbsListView).getHeaderViewsCount();
      Object localObject3 = ((FTSBizDetailUI)localObject1).tJW;
      ciy localciy = ((FTSBizDetailUI)localObject1).tKe;
      if ((localObject3 != null) && (localciy != null))
      {
        Object localObject2 = ((FTSBizDetailUI)localObject1).tJZ;
        if ((localObject2 != null) && (paramAbsListView.getLastVisiblePosition() >= ((f)localObject3).getCount() + paramInt1) && (((View)localObject2).getVisibility() == 0) && (((FTSBizDetailUI)localObject1).tJu == 1))
        {
          paramInt2 = com.tencent.mm.cb.a.iv((Context)localObject1);
          int[] arrayOfInt = new int[2];
          ((View)localObject2).getLocationOnScreen(arrayOfInt);
          if (((View)localObject2).getMeasuredHeight() + arrayOfInt[1] <= paramInt2)
          {
            ((FTSBizDetailUI)localObject1).tJu = 2;
            ((FTSBizDetailUI)localObject1).a(localciy, 2);
          }
        }
        localObject2 = ((FTSBizDetailUI)localObject1).tKb;
        if (localObject2 != null)
        {
          if ((paramAbsListView.getLastVisiblePosition() >= paramInt1 + ((f)localObject3).getCount()) && (((LinearLayout)localObject2).getVisibility() == 0))
          {
            paramInt2 = com.tencent.mm.cb.a.iv((Context)localObject1);
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
                paramAbsListView = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FTSRelatedSugItem");
                AppMethodBeat.o(194894);
                throw paramAbsListView;
              }
              paramAbsListView = (ajh)paramAbsListView;
              if ((j + i <= paramInt2) && (((FTSBizDetailUI)localObject1).tKh.add(paramAbsListView.GyJ.Hvr))) {
                ((FTSBizDetailUI)localObject1).a(paramAbsListView, localciy, 2);
              }
              paramInt1 += 1;
            }
          }
          AppMethodBeat.o(194894);
          return;
        }
      }
    }
    AppMethodBeat.o(194894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.f
 * JD-Core Version:    0.7.0.1
 */