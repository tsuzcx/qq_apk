package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.masssend.a.a;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.n.d;

final class MassSendHistoryUI$4
  implements n.d
{
  MassSendHistoryUI$4(MassSendHistoryUI paramMassSendHistoryUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(22797);
    Object localObject1;
    Object localObject2;
    if (paramMenuItem.getItemId() == 1)
    {
      localObject1 = (a)MassSendHistoryUI.b(this.oCd).getItem(paramMenuItem.getGroupId());
      if (localObject1 == null)
      {
        AppMethodBeat.o(22797);
        return;
      }
      if (((a)localObject1).bOT().equals(MassSendHistoryUI.b(this.oCd).oBL)) {
        MassSendHistoryUI.h(this.oCd);
      }
      paramMenuItem = com.tencent.mm.plugin.masssend.a.h.bPc();
      localObject1 = ((a)localObject1).bOT();
      localObject2 = paramMenuItem.fnw.a("select * from massendinfo ORDER BY createtime DESC  limit 2", null, 0);
      if (localObject2 != null)
      {
        if (((Cursor)localObject2).getCount() != 0) {
          break label154;
        }
        ((Cursor)localObject2).close();
      }
    }
    for (;;)
    {
      if (paramMenuItem.fnw.delete("massendinfo", "clientid= ?", new String[] { String.valueOf(localObject1) }) > 0) {
        paramMenuItem.doNotify();
      }
      AppMethodBeat.o(22797);
      return;
      label154:
      a locala;
      if (((Cursor)localObject2).getCount() == 1)
      {
        ((Cursor)localObject2).moveToFirst();
        locala = new a();
        locala.convertFrom((Cursor)localObject2);
        ((Cursor)localObject2).close();
        localObject2 = new ak();
        ((ak)localObject2).setUsername("masssendapp");
        ((ak)localObject2).setContent(ah.getContext().getResources().getString(2131298661));
        ((ak)localObject2).fK(locala.createTime);
        ((ak)localObject2).hL(0);
        ((ak)localObject2).hJ(0);
        aw.aaz();
        com.tencent.mm.model.c.YF().a((ak)localObject2, "masssendapp");
      }
      else
      {
        ((Cursor)localObject2).moveToPosition(1);
        locala = new a();
        locala.convertFrom((Cursor)localObject2);
        ((Cursor)localObject2).close();
        localObject2 = new ak();
        ((ak)localObject2).setUsername("masssendapp");
        ((ak)localObject2).setContent(b.a(locala));
        ((ak)localObject2).fK(locala.createTime);
        ((ak)localObject2).hL(0);
        ((ak)localObject2).hJ(0);
        aw.aaz();
        com.tencent.mm.model.c.YF().a((ak)localObject2, "masssendapp");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.4
 * JD-Core Version:    0.7.0.1
 */