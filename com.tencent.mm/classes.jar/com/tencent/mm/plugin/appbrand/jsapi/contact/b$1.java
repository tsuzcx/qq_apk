package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.ui.widget.a.e;

final class b$1
  implements Runnable
{
  b$1(b paramb, Context paramContext, a parama, c paramc, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(186004);
    b localb = this.kNb;
    Activity localActivity = (Activity)this.kMZ;
    a locala = this.kNa;
    c localc = this.cnL;
    int i = this.cjS;
    String str1 = localActivity.getString(2131761019);
    String str2 = localActivity.getString(2131761018);
    e locale = new e(localActivity, 1, false);
    locale.LfS = new b.2(localb, new String[] { str1, str2 });
    locale.LfT = new b.3(localb, locala, localActivity, localc, i);
    locale.cPF();
    AppMethodBeat.o(186004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.b.1
 * JD-Core Version:    0.7.0.1
 */