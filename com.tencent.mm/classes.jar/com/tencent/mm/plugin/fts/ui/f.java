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
import com.tencent.mm.protocal.protobuf.aix;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.protocal.protobuf.dla;
import com.tencent.mm.sdk.platformtools.ap;
import d.g.b.p;
import d.l;
import d.v;
import java.util.HashSet;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/fts/ui/FTSBizDetailAdapter;", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseAdapter;", "Lcom/tencent/mm/plugin/fts/api/ui/IFTSUIUnit$UIUnitDataReadyCallback;", "ftsBaseUIComponent", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseUIComponent;", "searchScene", "", "(Lcom/tencent/mm/plugin/fts/ui/FTSBaseUIComponent;I)V", "TAG", "", "bizUIUnit", "Lcom/tencent/mm/plugin/fts/api/ui/IFTSUIUnit;", "searchHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getSearchScene", "()I", "createDataItem", "Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;", "position", "doSearch", "", "handleItemClick", "", "view", "Landroid/view/View;", "ftsDataItem", "isHandled", "onDataReady", "unit", "query", "isSuccess", "onScroll", "Landroid/widget/AbsListView;", "firstVisibleItem", "visibleItemCount", "totalItemCount", "ui-fts_release"})
public final class f
  extends d
  implements e.b
{
  private final String TAG;
  private final int ljZ;
  private final ap tyn;
  private com.tencent.mm.plugin.fts.a.d.e tze;
  
  public f(e parame)
  {
    super(parame);
    AppMethodBeat.i(219355);
    this.ljZ = 5;
    this.TAG = "MicroMsg.FTS.FTSBizDetailAdapter";
    parame = ((n)g.ad(n.class)).createFTSUIUnit(4208, getContext(), (e.b)this, this.ljZ);
    p.g(parame, "MMKernel.plugin(IPluginF…ntext, this, searchScene)");
    this.tze = parame;
    this.tyn = new ap(Looper.getMainLooper());
    AppMethodBeat.o(219355);
  }
  
  protected final com.tencent.mm.plugin.fts.a.d.a.a GR(int paramInt)
  {
    AppMethodBeat.i(219350);
    com.tencent.mm.plugin.fts.a.d.a.a locala = this.tze.GR(paramInt);
    p.g(locala, "bizUIUnit.createDataItem(position)");
    AppMethodBeat.o(219350);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString)
  {
    AppMethodBeat.i(219353);
    setCount(this.tze.GQ(0));
    notifyDataSetChanged();
    al(getCount(), true);
    AppMethodBeat.o(219353);
  }
  
  protected final boolean a(View paramView, com.tencent.mm.plugin.fts.a.d.a.a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(219352);
    paramBoolean = this.tze.a(paramView, parama, paramBoolean);
    AppMethodBeat.o(219352);
    return paramBoolean;
  }
  
  protected final void cTn()
  {
    AppMethodBeat.i(219351);
    this.tze.a(getQuery(), this.tyn, new HashSet(), 0L);
    AppMethodBeat.o(219351);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(219354);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if ((cTs() instanceof FTSBizDetailUI))
    {
      Object localObject1 = cTs();
      if (localObject1 == null)
      {
        paramAbsListView = new v("null cannot be cast to non-null type com.tencent.mm.plugin.fts.ui.FTSBizDetailUI");
        AppMethodBeat.o(219354);
        throw paramAbsListView;
      }
      localObject1 = (FTSBizDetailUI)localObject1;
      if (paramAbsListView == null)
      {
        paramAbsListView = new v("null cannot be cast to non-null type android.widget.ListView");
        AppMethodBeat.o(219354);
        throw paramAbsListView;
      }
      paramInt1 = ((ListView)paramAbsListView).getHeaderViewsCount();
      Object localObject3 = ((FTSBizDetailUI)localObject1).tzf;
      cie localcie = ((FTSBizDetailUI)localObject1).tzn;
      if ((localObject3 != null) && (localcie != null))
      {
        Object localObject2 = ((FTSBizDetailUI)localObject1).tzi;
        if ((localObject2 != null) && (paramAbsListView.getLastVisiblePosition() >= ((f)localObject3).getCount() + paramInt1) && (((View)localObject2).getVisibility() == 0) && (((FTSBizDetailUI)localObject1).tyD == 1))
        {
          paramInt2 = com.tencent.mm.cc.a.iq((Context)localObject1);
          int[] arrayOfInt = new int[2];
          ((View)localObject2).getLocationOnScreen(arrayOfInt);
          if (((View)localObject2).getMeasuredHeight() + arrayOfInt[1] <= paramInt2)
          {
            ((FTSBizDetailUI)localObject1).tyD = 2;
            ((FTSBizDetailUI)localObject1).a(localcie, 2);
          }
        }
        localObject2 = ((FTSBizDetailUI)localObject1).tzk;
        if (localObject2 != null)
        {
          if ((paramAbsListView.getLastVisiblePosition() >= paramInt1 + ((f)localObject3).getCount()) && (((LinearLayout)localObject2).getVisibility() == 0))
          {
            paramInt2 = com.tencent.mm.cc.a.iq((Context)localObject1);
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
                AppMethodBeat.o(219354);
                throw paramAbsListView;
              }
              paramAbsListView = (aix)paramAbsListView;
              if ((j + i <= paramInt2) && (((FTSBizDetailUI)localObject1).tzq.add(paramAbsListView.Gga.HbR))) {
                ((FTSBizDetailUI)localObject1).a(paramAbsListView, localcie, 2);
              }
              paramInt1 += 1;
            }
          }
          AppMethodBeat.o(219354);
          return;
        }
      }
    }
    AppMethodBeat.o(219354);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.f
 * JD-Core Version:    0.7.0.1
 */