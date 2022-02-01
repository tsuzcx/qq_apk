package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.ui.widget.a.e;

final class b$1
  implements Runnable
{
  b$1(b paramb, Context paramContext, a parama, f paramf, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(186004);
    b localb = this.lRT;
    Activity localActivity = (Activity)this.lRR;
    a locala = this.lRS;
    f localf = this.czN;
    int i = this.cvP;
    String str1 = localActivity.getString(2131762795);
    String str2 = localActivity.getString(2131762794);
    e locale = new e(localActivity, 1, false);
    locale.HLX = new b.2(localb, new String[] { str1, str2 });
    locale.HLY = new b.3(localb, locala, localActivity, localf, i);
    locale.dGm();
    AppMethodBeat.o(186004);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.b.1
 * JD-Core Version:    0.7.0.1
 */