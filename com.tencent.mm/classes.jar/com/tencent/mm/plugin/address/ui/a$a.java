package com.tencent.mm.plugin.address.ui;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/address/ui/SelectAddressDialog$AddressConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/address/ui/SelectAddressDialog$AddressItem;", "(Lcom/tencent/mm/plugin/address/ui/SelectAddressDialog;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "addressItem", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
  extends f<a.b>
{
  public a$a()
  {
    AppMethodBeat.i(267161);
    AppMethodBeat.o(267161);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(267163);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(267163);
  }
  
  public final int getLayoutId()
  {
    return R.i.gnN;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.a.a
 * JD-Core Version:    0.7.0.1
 */