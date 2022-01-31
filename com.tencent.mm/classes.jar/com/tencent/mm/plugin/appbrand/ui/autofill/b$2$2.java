package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.mm.protocal.c.ex;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;
import java.util.LinkedList;

final class b$2$2
  implements n.d
{
  b$2$2(b.2 param2) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    ex localex = (ex)b.b(this.hfs.hfr).syD.get(paramMenuItem.getItemId());
    if (localex == null)
    {
      y.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "not find phone_id, menuItem id :%d", new Object[] { Integer.valueOf(paramMenuItem.getItemId()) });
      return;
    }
    y.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "select menuItem id:%d, phone_id:%s, show_phone:%s, bank_type:%s", new Object[] { Integer.valueOf(paramMenuItem.getItemId()), localex.syB, localex.syC, localex.mOb });
    b.a(this.hfs.hfr, localex);
    b.c(this.hfs.hfr).setText(localex.syC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.b.2.2
 * JD-Core Version:    0.7.0.1
 */