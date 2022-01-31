package com.tencent.mm.plugin.appbrand.ui.autofill;

import com.tencent.mm.protocal.c.ex;
import com.tencent.mm.protocal.c.ey;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.Iterator;
import java.util.LinkedList;

final class b$2$1
  implements n.c
{
  b$2$1(b.2 param2) {}
  
  public final void a(l paraml)
  {
    y.i("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_list.size %d", new Object[] { Integer.valueOf(b.b(this.hfs.hfr).syD.size()) });
    Iterator localIterator = b.b(this.hfs.hfr).syD.iterator();
    while (localIterator.hasNext())
    {
      ex localex = (ex)localIterator.next();
      if ((bk.bl(localex.syB)) || (bk.bl(localex.syC))) {
        y.e("MicroMsg.AppBrandIDCardVerifyPwdFrag", "phone_id or show_phone is empty, continue");
      } else {
        paraml.e(b.b(this.hfs.hfr).syD.indexOf(localex), localex.syC);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.b.2.1
 * JD-Core Version:    0.7.0.1
 */