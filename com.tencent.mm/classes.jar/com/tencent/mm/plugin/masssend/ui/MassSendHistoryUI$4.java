package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.masssend.a.a;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.ui.base.o.g;

final class MassSendHistoryUI$4
  implements o.g
{
  MassSendHistoryUI$4(MassSendHistoryUI paramMassSendHistoryUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(26419);
    Object localObject1;
    Object localObject2;
    if (paramMenuItem.getItemId() == 1)
    {
      localObject1 = (a)MassSendHistoryUI.b(this.zoi).getItem(paramMenuItem.getGroupId());
      if (localObject1 == null)
      {
        AppMethodBeat.o(26419);
        return;
      }
      if (((a)localObject1).ehw().equals(MassSendHistoryUI.b(this.zoi).znR)) {
        MassSendHistoryUI.h(this.zoi);
      }
      paramMenuItem = com.tencent.mm.plugin.masssend.a.h.ehF();
      localObject1 = ((a)localObject1).ehw();
      localObject2 = paramMenuItem.iFy.rawQuery("select * from massendinfo ORDER BY createtime DESC  limit 2", null);
      if (localObject2 != null)
      {
        if (((Cursor)localObject2).getCount() != 0) {
          break label153;
        }
        ((Cursor)localObject2).close();
      }
    }
    for (;;)
    {
      if (paramMenuItem.iFy.delete("massendinfo", "clientid= ?", new String[] { String.valueOf(localObject1) }) > 0) {
        paramMenuItem.doNotify();
      }
      AppMethodBeat.o(26419);
      return;
      label153:
      a locala;
      if (((Cursor)localObject2).getCount() == 1)
      {
        ((Cursor)localObject2).moveToFirst();
        locala = new a();
        locala.convertFrom((Cursor)localObject2);
        ((Cursor)localObject2).close();
        localObject2 = new az();
        ((az)localObject2).setUsername("masssendapp");
        ((az)localObject2).setContent(MMApplicationContext.getContext().getResources().getString(2131757953));
        ((az)localObject2).yA(locala.createTime);
        ((az)localObject2).nv(0);
        ((az)localObject2).nt(0);
        bg.aVF();
        com.tencent.mm.model.c.aST().a((az)localObject2, "masssendapp");
      }
      else
      {
        ((Cursor)localObject2).moveToPosition(1);
        locala = new a();
        locala.convertFrom((Cursor)localObject2);
        ((Cursor)localObject2).close();
        localObject2 = new az();
        ((az)localObject2).setUsername("masssendapp");
        ((az)localObject2).setContent(b.a(locala));
        ((az)localObject2).yA(locala.createTime);
        ((az)localObject2).nv(0);
        ((az)localObject2).nt(0);
        bg.aVF();
        com.tencent.mm.model.c.aST().a((az)localObject2, "masssendapp");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.4
 * JD-Core Version:    0.7.0.1
 */