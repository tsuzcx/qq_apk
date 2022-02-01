package com.tencent.mm.plugin.finder.live.view.adapter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.u;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomSearchAdapter;", "Lcom/tencent/mm/ui/contact/MMSearchContactAdapter;", "selectContactUI", "Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;", "blockList", "", "", "isMultiSelect", "", "(Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;Ljava/util/List;Z)V", "createChatroomDataItem", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "position", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
  extends u
{
  public z(MMBaseSelectContactUI paramMMBaseSelectContactUI)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
  }
  
  public final a Py(int paramInt)
  {
    AppMethodBeat.i(358753);
    int i = this.afbN;
    Object localObject = new y(paramInt);
    ((a)localObject).query = this.query;
    ((y)localObject).rpp = ((o)this.Hwr.get(paramInt - i - 1));
    ((a)localObject).afey = gZe();
    localObject = (a)localObject;
    AppMethodBeat.o(358753);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.z
 * JD-Core Version:    0.7.0.1
 */