package com.tencent.mm.plugin.appbrand.ui.autofill;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.gb;
import com.tencent.mm.protocal.protobuf.gc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;
import java.util.LinkedList;

final class AppBrandIDCardVerifyPwdFrag$2$1
  implements n.c
{
  AppBrandIDCardVerifyPwdFrag$2$1(AppBrandIDCardVerifyPwdFrag.2 param2) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(133250);
    ab.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_list.size %d", new Object[] { Integer.valueOf(AppBrandIDCardVerifyPwdFrag.b(this.iQG.iQF).wsl.size()) });
    Iterator localIterator = AppBrandIDCardVerifyPwdFrag.b(this.iQG.iQF).wsl.iterator();
    while (localIterator.hasNext())
    {
      gb localgb = (gb)localIterator.next();
      if ((bo.isNullOrNil(localgb.wsj)) || (bo.isNullOrNil(localgb.wsk))) {
        ab.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_id or show_phone is empty, continue");
      } else {
        paraml.e(AppBrandIDCardVerifyPwdFrag.b(this.iQG.iQF).wsl.indexOf(localgb), localgb.wsk);
      }
    }
    AppMethodBeat.o(133250);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardVerifyPwdFrag.2.1
 * JD-Core Version:    0.7.0.1
 */