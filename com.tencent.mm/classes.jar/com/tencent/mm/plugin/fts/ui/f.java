package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.view.View;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/fts/ui/FTSBizDetailAdapter;", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseAdapter;", "Lcom/tencent/mm/plugin/fts/api/ui/IFTSUIUnit$UIUnitDataReadyCallback;", "ftsBaseUIComponent", "Lcom/tencent/mm/plugin/fts/ui/FTSBaseUIComponent;", "searchScene", "", "(Lcom/tencent/mm/plugin/fts/ui/FTSBaseUIComponent;I)V", "TAG", "", "bizUIUnit", "Lcom/tencent/mm/plugin/fts/api/ui/IFTSUIUnit;", "searchHandler", "Lcom/tencent/mm/sdk/platformtools/MMHandler;", "getSearchScene", "()I", "createDataItem", "Lcom/tencent/mm/plugin/fts/api/ui/item/FTSDataItem;", "position", "doSearch", "", "handleItemClick", "", "view", "Landroid/view/View;", "ftsDataItem", "isHandled", "onDataReady", "unit", "query", "isSuccess", "onScroll", "Landroid/widget/AbsListView;", "firstVisibleItem", "visibleItemCount", "totalItemCount", "ui-fts_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends d
  implements e.b
{
  private final MMHandler HwY;
  private com.tencent.mm.plugin.fts.a.d.e Hyl;
  private final String TAG;
  private final int syO;
  
  public f(e parame)
  {
    super(parame);
    AppMethodBeat.i(265588);
    this.syO = 5;
    this.TAG = "MicroMsg.FTS.FTSBizDetailAdapter";
    parame = ((n)h.az(n.class)).createFTSUIUnit(4208, getContext(), (e.b)this, this.syO);
    s.s(parame, "plugin(IPluginFTS::class…ntext, this, searchScene)");
    this.Hyl = parame;
    this.HwY = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(265588);
  }
  
  protected final a Wj(int paramInt)
  {
    AppMethodBeat.i(265591);
    a locala = this.Hyl.Wj(paramInt);
    s.s(locala, "bizUIUnit.createDataItem(position)");
    AppMethodBeat.o(265591);
    return locala;
  }
  
  public final void a(com.tencent.mm.plugin.fts.a.d.e parame, String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(265606);
    setCount(this.Hyl.Wi(0));
    notifyDataSetChanged();
    aZ(getCount(), true);
    AppMethodBeat.o(265606);
  }
  
  protected final boolean a(View paramView, a parama, boolean paramBoolean)
  {
    AppMethodBeat.i(265601);
    paramBoolean = this.Hyl.a(paramView, parama, paramBoolean);
    AppMethodBeat.o(265601);
    return paramBoolean;
  }
  
  protected final void fyd()
  {
    AppMethodBeat.i(265595);
    this.Hyl.a(getQuery(), this.HwY, new HashSet());
    AppMethodBeat.o(265595);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(265611);
    super.onScroll(paramAbsListView, paramInt1, paramInt2, paramInt3);
    if ((fyi() instanceof FTSBizDetailUI))
    {
      e locale = fyi();
      if (locale == null)
      {
        paramAbsListView = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.fts.ui.FTSBizDetailUI");
        AppMethodBeat.o(265611);
        throw paramAbsListView;
      }
      ((FTSBizDetailUI)locale).a(paramAbsListView);
    }
    AppMethodBeat.o(265611);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.f
 * JD-Core Version:    0.7.0.1
 */