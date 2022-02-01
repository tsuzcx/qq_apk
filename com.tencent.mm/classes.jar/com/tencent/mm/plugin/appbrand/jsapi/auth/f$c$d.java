package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.permission.a.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.o.a;
import d.l;
import java.util.ArrayList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
final class f$c$d
  implements Runnable
{
  f$c$d(String paramString1, Context paramContext, String paramString2, Bitmap paramBitmap, b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(169567);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new o.a(this.kxU, this.cqB.getResources().getString(2131755946), this.kxV, this.cvX));
    this.kxW.setSelectListItem((List)localArrayList);
    AppMethodBeat.o(169567);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.f.c.d
 * JD-Core Version:    0.7.0.1
 */