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
import com.tencent.mm.ui.contact.r;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveRoomAdapter;", "Lcom/tencent/mm/ui/contact/MMInitContactAdapter;", "selectContactUI", "Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;", "blockList", "", "", "disableBiz", "", "canSendToBiz", "(Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;Ljava/util/List;ZZ)V", "dataCursor", "Landroid/database/Cursor;", "dataList", "Ljava/util/ArrayList;", "createDataItem", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "position", "", "getCount", "resetData", "", "Companion", "plugin-finder_release"})
public final class u
  extends r
{
  private static final String TAG = "Finder.FinderLiveRoomAdapter";
  public static final u.a yZi;
  private Cursor mNt;
  private final ArrayList<String> mXB;
  
  static
  {
    AppMethodBeat.i(226003);
    yZi = new u.a((byte)0);
    TAG = "Finder.FinderLiveRoomAdapter";
    AppMethodBeat.o(226003);
  }
  
  public u(MMBaseSelectContactUI paramMMBaseSelectContactUI)
  {
    super((o)paramMMBaseSelectContactUI, null, true, false);
    AppMethodBeat.i(226001);
    this.mXB = new ArrayList();
    ate();
    AppMethodBeat.o(226001);
  }
  
  public final void ate()
  {
    AppMethodBeat.i(226000);
    Log.i(TAG, "resetData");
    if (this.mNt != null)
    {
      localObject = this.mNt;
      if (localObject != null) {
        ((Cursor)localObject).close();
      }
      this.mNt = null;
    }
    Object localObject = h.ae(n.class);
    p.j(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    this.mNt = ((n)localObject).bbR().a(5, csq(), com.tencent.mm.o.a.jxD, hVe(), "");
    localObject = this.mNt;
    if (localObject != null)
    {
      while (((Cursor)localObject).moveToNext())
      {
        String str = ((Cursor)localObject).getString(((Cursor)localObject).getColumnIndex("username"));
        p.j(str, "it.getString(it.getColumnIndex(\"username\"))");
        if (!this.mXB.contains(str)) {
          this.mXB.add(str);
        }
      }
      ((Cursor)localObject).close();
      AppMethodBeat.o(226000);
      return;
    }
    AppMethodBeat.o(226000);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(225995);
    int i = this.mXB.size();
    AppMethodBeat.o(225995);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a ye(int paramInt)
  {
    AppMethodBeat.i(225998);
    Object localObject1 = this.mXB.get(paramInt);
    p.j(localObject1, "dataList[position]");
    String str = (String)localObject1;
    localObject1 = h.ae(n.class);
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
    AppMethodBeat.o(225998);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.u
 * JD-Core Version:    0.7.0.1
 */