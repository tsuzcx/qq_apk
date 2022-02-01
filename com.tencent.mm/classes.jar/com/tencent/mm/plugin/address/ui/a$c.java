package com.tencent.mm.plugin.address.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.address.model.RcptItem;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/address/ui/SelectAddressDialog$Companion;", "", "()V", "TAG", "", "placeHold", "Lcom/tencent/mm/plugin/address/model/RcptItem;", "getPlaceHold", "()Lcom/tencent/mm/plugin/address/model/RcptItem;", "setPlaceHold", "(Lcom/tencent/mm/plugin/address/model/RcptItem;)V", "selectAddrPath", "", "getSelectAddrPath", "()Ljava/util/List;", "setSelectAddrPath", "(Ljava/util/List;)V", "tabCount", "", "getTabCount", "()I", "setTabCount", "(I)V", "app_release"})
public final class a$c
{
  public static List<RcptItem> bAN()
  {
    AppMethodBeat.i(293217);
    List localList = a.bAM();
    if (localList == null) {
      p.bGy("selectAddrPath");
    }
    AppMethodBeat.o(293217);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.a.c
 * JD-Core Version:    0.7.0.1
 */