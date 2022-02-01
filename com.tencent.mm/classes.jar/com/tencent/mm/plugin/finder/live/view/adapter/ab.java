package com.tencent.mm.plugin.finder.live.view.adapter;

import android.app.Activity;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.a.a;
import com.tencent.mm.ui.contact.q;
import com.tencent.mm.ui.contact.u;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveSearchRoomAdapter;", "Lcom/tencent/mm/ui/contact/MMSearchContactAdapter;", "selectContactUI", "Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;", "blockList", "", "", "isMultiSelect", "", "(Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;Ljava/util/List;Z)V", "createChatroomDataItem", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "position", "", "createHeaderPosition", "resource", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
  extends u
{
  public ab(MMBaseSelectContactUI paramMMBaseSelectContactUI)
  {
    super(paramMMBaseSelectContactUI, null, true, 0);
    AppMethodBeat.i(358823);
    AppMethodBeat.o(358823);
  }
  
  public final a Py(int paramInt)
  {
    AppMethodBeat.i(358833);
    int i = this.afbN;
    Object localObject = new y(paramInt);
    ((a)localObject).query = this.query;
    ((y)localObject).rpp = ((com.tencent.mm.plugin.fts.a.a.o)this.Hwr.get(paramInt - i - 1));
    ((a)localObject).afey = gZe();
    localObject = (a)localObject;
    AppMethodBeat.o(358833);
    return localObject;
  }
  
  public final a hM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(358841);
    Object localObject = new s(paramInt2);
    ((s)localObject).header = this.afex.getActivity().getResources().getString(paramInt1);
    localObject = (a)localObject;
    AppMethodBeat.o(358841);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.ab
 * JD-Core Version:    0.7.0.1
 */