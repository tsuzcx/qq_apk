package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.sdk.platformtools.ab;

final class a$4
  implements Runnable
{
  a$4(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(133667);
    ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo doOpenHeader");
    int i = a.c(this.jcW).getTop();
    a.d(this.jcW).smoothScrollBy(i, 600);
    a.e(this.jcW);
    AppMethodBeat.o(133667);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.4
 * JD-Core Version:    0.7.0.1
 */