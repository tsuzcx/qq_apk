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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/view/adapter/FinderLiveRoomAdapter;", "Lcom/tencent/mm/ui/contact/MMInitContactAdapter;", "selectContactUI", "Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;", "blockList", "", "", "disableBiz", "", "canSendToBiz", "(Lcom/tencent/mm/ui/contact/MMBaseSelectContactUI;Ljava/util/List;ZZ)V", "dataCursor", "Landroid/database/Cursor;", "dataList", "Ljava/util/ArrayList;", "createDataItem", "Lcom/tencent/mm/ui/contact/item/BaseContactDataItem;", "position", "", "getCount", "resetData", "", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
  extends r
{
  public static final aa.a DSD;
  private static final String TAG;
  private Cursor pKb;
  private final ArrayList<String> pUj;
  
  static
  {
    AppMethodBeat.i(358831);
    DSD = new aa.a((byte)0);
    TAG = "Finder.FinderLiveRoomAdapter";
    AppMethodBeat.o(358831);
  }
  
  public aa(MMBaseSelectContactUI paramMMBaseSelectContactUI)
  {
    super((o)paramMMBaseSelectContactUI, null, true, false);
    AppMethodBeat.i(358824);
    this.pUj = new ArrayList();
    aNm();
    AppMethodBeat.o(358824);
  }
  
  public final void aNm()
  {
    AppMethodBeat.i(358856);
    Log.i(TAG, "resetData");
    if (this.pKb != null)
    {
      localCursor = this.pKb;
      if (localCursor != null) {
        localCursor.close();
      }
      this.pKb = null;
    }
    this.pKb = ((n)h.ax(n.class)).bzG().a(5, cVa(), com.tencent.mm.l.a.maX, jyS(), "");
    Cursor localCursor = this.pKb;
    if (localCursor != null)
    {
      while (localCursor.moveToNext())
      {
        String str = localCursor.getString(localCursor.getColumnIndex("username"));
        s.s(str, "it.getString(it.getColumnIndex(\"username\"))");
        if (!this.pUj.contains(str)) {
          this.pUj.add(str);
        }
      }
      localCursor.close();
    }
    AppMethodBeat.o(358856);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(358838);
    int i = this.pUj.size();
    AppMethodBeat.o(358838);
    return i;
  }
  
  public final com.tencent.mm.ui.contact.a.a yk(int paramInt)
  {
    AppMethodBeat.i(358848);
    Object localObject1 = this.pUj.get(paramInt);
    s.s(localObject1, "dataList[position]");
    String str = (String)localObject1;
    Object localObject2 = ((n)h.ax(n.class)).bzA().bxq(str);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = ((n)h.ax(n.class)).bzA().bxv(str);
    }
    localObject2 = new y(paramInt);
    ((com.tencent.mm.ui.contact.a.a)localObject2).contact = ((au)localObject1);
    ((com.tencent.mm.ui.contact.a.a)localObject2).afey = gZe();
    localObject1 = (com.tencent.mm.ui.contact.a.a)localObject2;
    AppMethodBeat.o(358848);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.adapter.aa
 * JD-Core Version:    0.7.0.1
 */