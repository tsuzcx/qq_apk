package com.tencent.mm.plugin.address.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.address.model.RcptItem;
import com.tencent.mm.view.recyclerview.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/address/ui/SelectAddressDialog$AddressItem;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "item", "Lcom/tencent/mm/plugin/address/model/RcptItem;", "(Lcom/tencent/mm/plugin/address/model/RcptItem;)V", "getItem", "()Lcom/tencent/mm/plugin/address/model/RcptItem;", "setItem", "getItemId", "", "getItemType", "", "toString", "", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b
  implements a
{
  RcptItem qkd;
  
  public a$b(RcptItem paramRcptItem)
  {
    AppMethodBeat.i(267141);
    this.qkd = paramRcptItem;
    AppMethodBeat.o(267141);
  }
  
  public final long bZA()
  {
    AppMethodBeat.i(267144);
    long l = hashCode();
    AppMethodBeat.o(267144);
    return l;
  }
  
  public final int bZB()
  {
    return 1;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(267147);
    String str = super.toString();
    AppMethodBeat.o(267147);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.a.b
 * JD-Core Version:    0.7.0.1
 */