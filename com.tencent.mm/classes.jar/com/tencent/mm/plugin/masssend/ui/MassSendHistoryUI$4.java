package com.tencent.mm.plugin.masssend.ui;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.view.MenuItem;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.masssend.a.a;
import com.tencent.mm.plugin.masssend.a.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.be;
import com.tencent.mm.ui.base.n.d;

final class MassSendHistoryUI$4
  implements n.d
{
  MassSendHistoryUI$4(MassSendHistoryUI paramMassSendHistoryUI) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    Object localObject1;
    if (paramMenuItem.getItemId() == 1)
    {
      localObject1 = (a)MassSendHistoryUI.b(this.mbC).getItem(paramMenuItem.getGroupId());
      if (localObject1 != null) {
        break label35;
      }
    }
    for (;;)
    {
      return;
      label35:
      if (((a)localObject1).bgV().equals(MassSendHistoryUI.b(this.mbC).mbj)) {
        MassSendHistoryUI.h(this.mbC);
      }
      paramMenuItem = com.tencent.mm.plugin.masssend.a.h.bhd();
      localObject1 = ((a)localObject1).bgV();
      Object localObject2 = paramMenuItem.dXo.a("select * from massendinfo ORDER BY createtime DESC  limit 2", null, 0);
      if (localObject2 != null)
      {
        if (((Cursor)localObject2).getCount() != 0) {
          break label133;
        }
        ((Cursor)localObject2).close();
      }
      while (paramMenuItem.dXo.delete("massendinfo", "clientid= ?", new String[] { localObject1 }) > 0)
      {
        paramMenuItem.doNotify();
        return;
        label133:
        a locala;
        if (((Cursor)localObject2).getCount() == 1)
        {
          ((Cursor)localObject2).moveToFirst();
          locala = new a();
          locala.d((Cursor)localObject2);
          ((Cursor)localObject2).close();
          localObject2 = new ak();
          ((ak)localObject2).setUsername("masssendapp");
          ((ak)localObject2).setContent(ae.getContext().getResources().getString(R.l.contact_info_masssend_tip));
          ((ak)localObject2).ba(locala.createTime);
          ((ak)localObject2).fA(0);
          ((ak)localObject2).fy(0);
          au.Hx();
          com.tencent.mm.model.c.FB().a((ak)localObject2, "masssendapp");
        }
        else
        {
          ((Cursor)localObject2).moveToPosition(1);
          locala = new a();
          locala.d((Cursor)localObject2);
          ((Cursor)localObject2).close();
          localObject2 = new ak();
          ((ak)localObject2).setUsername("masssendapp");
          ((ak)localObject2).setContent(b.a(locala));
          ((ak)localObject2).ba(locala.createTime);
          ((ak)localObject2).fA(0);
          ((ak)localObject2).fy(0);
          au.Hx();
          com.tencent.mm.model.c.FB().a((ak)localObject2, "masssendapp");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendHistoryUI.4
 * JD-Core Version:    0.7.0.1
 */