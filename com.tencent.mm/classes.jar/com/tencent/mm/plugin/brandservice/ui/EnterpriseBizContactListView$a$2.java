package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import java.lang.ref.WeakReference;

final class EnterpriseBizContactListView$a$2
  implements n.d
{
  EnterpriseBizContactListView$a$2(EnterpriseBizContactListView.a parama) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(13959);
    if (bo.isNullOrNil(this.jUs.jUp))
    {
      AppMethodBeat.o(13959);
      return;
    }
    if (paramMenuItem.getItemId() == 1)
    {
      paramMenuItem = this.jUs;
      String str = this.jUs.jUp;
      Object localObject = (EnterpriseBizContactListView)paramMenuItem.jUr.get();
      if (localObject != null)
      {
        localObject = ((EnterpriseBizContactListView)localObject).getContext();
        h.d((Context)localObject, ((Context)localObject).getString(2131299308), "", ((Context)localObject).getString(2131299307), ((Context)localObject).getString(2131296888), new EnterpriseBizContactListView.a.3(paramMenuItem, str, (Context)localObject), null);
      }
    }
    AppMethodBeat.o(13959);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.a.2
 * JD-Core Version:    0.7.0.1
 */