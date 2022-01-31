package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.view.MenuItem;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.gb;
import com.tencent.mm.protocal.protobuf.gc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;
import java.util.LinkedList;

final class AppBrandIDCardVerifyPwdFrag$2$2
  implements n.d
{
  AppBrandIDCardVerifyPwdFrag$2$2(AppBrandIDCardVerifyPwdFrag.2 param2) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(133251);
    gb localgb = (gb)AppBrandIDCardVerifyPwdFrag.b(this.iQG.iQF).wsl.get(paramMenuItem.getItemId());
    if (localgb == null)
    {
      ab.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "not find phone_id, menuItem id :%d", new Object[] { Integer.valueOf(paramMenuItem.getItemId()) });
      AppMethodBeat.o(133251);
      return;
    }
    ab.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "select menuItem id:%d, phone_id:%s, show_phone:%s, bank_type:%s", new Object[] { Integer.valueOf(paramMenuItem.getItemId()), localgb.wsj, localgb.wsk, localgb.poq });
    AppBrandIDCardVerifyPwdFrag.a(this.iQG.iQF, localgb);
    AppBrandIDCardVerifyPwdFrag.c(this.iQG.iQF).setText(localgb.wsk);
    AppMethodBeat.o(133251);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag.2.2
 * JD-Core Version:    0.7.0.1
 */