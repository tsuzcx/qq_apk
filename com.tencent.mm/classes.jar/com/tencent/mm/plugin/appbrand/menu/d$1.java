package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.task.b;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class d$1
  implements n.c
{
  d$1(d paramd, z paramz, String paramString, Context paramContext) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(132202);
    paraml.hx(1, 2131306121);
    paraml.hx(2, 2131306118);
    paraml.hx(7, 2131306120);
    paraml.hx(9, 2131306115);
    paraml.e(3, "appID: " + this.hKE.getAppId());
    paraml.e(8, "username: " + this.hKE.getRuntime().atS().username);
    paraml.e(4, "TRIM PAGE");
    if (bo.isNullOrNil(this.eDZ)) {}
    for (String str = "UNKNOWN PROCESS NAME";; str = this.eDZ)
    {
      paraml.e(5, str);
      paraml.e(6, this.val$context.getString(2131306116) + String.format("(cur:%b)", new Object[] { Boolean.valueOf(b.aLC()) }));
      paraml.e(10, "JAVA ASSERT");
      paraml.e(11, "JNI ASSERT");
      AppMethodBeat.o(132202);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.d.1
 * JD-Core Version:    0.7.0.1
 */