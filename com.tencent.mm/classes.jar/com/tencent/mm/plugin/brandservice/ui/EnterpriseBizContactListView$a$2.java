package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import java.lang.ref.WeakReference;

final class EnterpriseBizContactListView$a$2
  implements n.d
{
  EnterpriseBizContactListView$a$2(EnterpriseBizContactListView.a parama) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    if (bk.bl(this.idE.idB)) {}
    String str;
    do
    {
      do
      {
        return;
      } while (paramMenuItem.getItemId() != 1);
      paramMenuItem = this.idE;
      str = this.idE.idB;
      localObject = (EnterpriseBizContactListView)paramMenuItem.idD.get();
    } while (localObject == null);
    Object localObject = ((EnterpriseBizContactListView)localObject).getContext();
    h.a((Context)localObject, ((Context)localObject).getString(b.h.enterprise_contact_info_disable_sub_confirm), "", ((Context)localObject).getString(b.h.enterprise_contact_info_disable_sub), ((Context)localObject).getString(b.h.app_cancel), new EnterpriseBizContactListView.a.3(paramMenuItem, str, (Context)localObject), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.a.2
 * JD-Core Version:    0.7.0.1
 */