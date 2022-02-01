package com.tencent.mm.plugin.finder.live.view.adapter;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.contact.MMBaseSelectContactUI;
import com.tencent.mm.ui.contact.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomAdapter;", "Lcom/tencent/mm/ui/contact/MMInitContactAdapter;", "selectContactUI", "Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;", "blockList", "", "", "disableBiz", "", "canSendToBiz", "(Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;Ljava/util/List;ZZ)V", "isMutliSelect", "selectType", "", "(Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;Ljava/util/List;ZZZI)V", "dataCursor", "Landroid/database/Cursor;", "dataList", "", "createChatRoomDataItem", "Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveMultiChatRoomDataItem;", "position", "contact", "Lcom/tencent/mm/storage/Contact;", "createDataItem", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "getCount", "resetData", "", "Companion", "plugin-finder_release"})
public final class r
  extends com.tencent.mm.ui.contact.r
{
  public static final r.a yZa;
  private final List<String> dataList;
  private Cursor mNt;
  
  static
  {
    AppMethodBeat.i(289032);
    yZa = new r.a((byte)0);
    AppMethodBeat.o(289032);
  }
  
  private r(MMBaseSelectContactUI paramMMBaseSelectContactUI)
  {
    super((o)paramMMBaseSelectContactUI, null, true, true);
    AppMethodBeat.i(289031);
    this.dataList = ((List)new ArrayList());
    Log.i("MicroMsg.FinderLiveMultiChatRoomAdapter", "create!");
    ate();
    AppMethodBeat.o(289031);
  }
  
  public r(MMBaseSelectContactUI paramMMBaseSelectContactUI, byte paramByte)
  {
    this(paramMMBaseSelectContactUI);
  }
  
  public final void ate()
  {
    AppMethodBeat.i(289029);
    Log.i("MicroMsg.FinderLiveMultiChatRoomAdapter", "resetData");
    Object localObject = h.ae(n.class);
    p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    this.mNt = ((n)localObject).bbR().a(5, csq(), com.tencent.mm.o.a.jxD, hVe(), "");
    clearCache();
    localObject = this.mNt;
    if (localObject != null)
    {
      while (((Cursor)localObject).moveToNext())
      {
        String str = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("username"));
        if (!this.dataList.contains(str)) {
          this.dataList.add(str);
        }
      }
      AppMethodBeat.o(289029);
      return;
    }
    AppMethodBeat.o(289029);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(289030);
    int i = this.dataList.size();
    AppMethodBeat.o(289030);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a ye(int paramInt)
  {
    AppMethodBeat.i(289028);
    String str = (String)this.dataList.get(paramInt);
    Object localObject1 = h.ae(n.class);
    p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    Object localObject2 = ((n)localObject1).bbL().bwc(str);
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = h.ae(n.class);
      p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
      localObject1 = ((n)localObject1).bbL().bwh(str);
    }
    localObject2 = new s(paramInt);
    ((s)localObject2).aF((as)localObject1);
    ((s)localObject2).GR(fJk());
    localObject1 = (com.tencent.mm.ui.contact.a.a)localObject2;
    AppMethodBeat.o(289028);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.r
 * JD-Core Version:    0.7.0.1
 */