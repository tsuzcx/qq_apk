package com.tencent.mm.plugin.finder.live.view.adapter;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.u;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveSearchRoomAdapter;", "Lcom/tencent/mm/ui/contact/MMSearchContactAdapter;", "selectContactUI", "Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;", "blockList", "", "", "isMultiSelect", "", "(Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;Ljava/util/List;Z)V", "createChatroomDataItem", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "position", "", "createHeaderPosition", "resource", "plugin-finder_release"})
public final class v
  extends u
{
  public v(MMBaseSelectContactUI paramMMBaseSelectContactUI)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    AppMethodBeat.i(251292);
    AppMethodBeat.o(251292);
  }
  
  public final a NO(int paramInt)
  {
    AppMethodBeat.i(251289);
    int i = this.Xqk;
    Object localObject = new s(paramInt);
    ((s)localObject).aIh(this.query);
    ((s)localObject).olG = ((com.tencent.mm.plugin.fts.a.a.m)this.BLv.get(paramInt - i - 1));
    ((s)localObject).GR(fJk());
    localObject = (a)localObject;
    AppMethodBeat.o(251289);
    return localObject;
  }
  
  public final a gJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251291);
    Object localObject1 = new m(paramInt2);
    Object localObject2 = hUM();
    p.j(localObject2, "selectContactUI");
    localObject2 = ((o)localObject2).getActivity();
    p.j(localObject2, "selectContactUI.activity");
    ((m)localObject1).header = ((Activity)localObject2).getResources().getString(paramInt1);
    localObject1 = (a)localObject1;
    AppMethodBeat.o(251291);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.v
 * JD-Core Version:    0.7.0.1
 */