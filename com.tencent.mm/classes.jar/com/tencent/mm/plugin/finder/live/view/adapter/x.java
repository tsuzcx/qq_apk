package com.tencent.mm.plugin.finder.live.view.adapter;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.o;
import com.tencent.mm.ui.contact.r;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomAdapter;", "Lcom/tencent/mm/ui/contact/MMInitContactAdapter;", "selectContactUI", "Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;", "blockList", "", "", "disableBiz", "", "canSendToBiz", "(Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;Ljava/util/List;ZZ)V", "isMutliSelect", "selectType", "", "(Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;Ljava/util/List;ZZZI)V", "dataCursor", "Landroid/database/Cursor;", "dataList", "", "createChatRoomDataItem", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem;", "position", "contact", "Lcom/tencent/mm/storage/Contact;", "createDataItem", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "getCount", "resetData", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class x
  extends r
{
  public static final x.a DSv;
  private final List<String> dataList;
  private Cursor pKb;
  
  static
  {
    AppMethodBeat.i(358732);
    DSv = new x.a((byte)0);
    AppMethodBeat.o(358732);
  }
  
  private x(MMBaseSelectContactUI paramMMBaseSelectContactUI)
  {
    super((o)paramMMBaseSelectContactUI, null, true, true);
    AppMethodBeat.i(358714);
    this.dataList = ((List)new ArrayList());
    Log.i("MicroMsg.FinderLiveMultiChatRoomAdapter", "create!");
    aNm();
    AppMethodBeat.o(358714);
  }
  
  public x(MMBaseSelectContactUI paramMMBaseSelectContactUI, byte paramByte)
  {
    this(paramMMBaseSelectContactUI);
  }
  
  public final void aNm()
  {
    AppMethodBeat.i(358749);
    Log.i("MicroMsg.FinderLiveMultiChatRoomAdapter", "resetData");
    this.pKb = ((n)h.ax(n.class)).bzG().a(5, cVa(), com.tencent.mm.l.a.maX, jyS(), "");
    clearCache();
    Cursor localCursor = this.pKb;
    if (localCursor != null) {
      while (localCursor.moveToNext())
      {
        String str = localCursor.getString(localCursor.getColumnIndex("username"));
        if (!this.dataList.contains(str)) {
          this.dataList.add(str);
        }
      }
    }
    AppMethodBeat.o(358749);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(358755);
    int i = this.dataList.size();
    AppMethodBeat.o(358755);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a yk(int paramInt)
  {
    AppMethodBeat.i(358740);
    String str = (String)this.dataList.get(paramInt);
    Object localObject2 = ((n)h.ax(n.class)).bzA().bxq(str);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = ((n)h.ax(n.class)).bzA().bxv(str);
    }
    localObject2 = new y(paramInt);
    ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((au)localObject1);
    ((com.tencent.mm.ui.contact.a.a)localObject2).afey = gZe();
    localObject1 = (com.tencent.mm.ui.contact.a.a)localObject2;
    AppMethodBeat.o(358740);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.x
 * JD-Core Version:    0.7.0.1
 */