package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.sdk.platformtools.ab;

final class a$5
  implements Runnable
{
  a$5(a parama, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(133668);
    int j = a.c(this.jcW).getBottom() - a.b(this.jcW);
    ab.i("MicroMsg.AppBrandDesktopAnimController", "alvinluo closeHeader distance: %d, bottom: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(a.c(this.jcW).getBottom()) });
    ListView localListView = a.d(this.jcW);
    int i;
    if (a.f(this.jcW))
    {
      i = 10;
      localListView.smoothScrollBy(j, i);
      a.g(this.jcW);
      a.a(this.jcW, false);
      if (a.h(this.jcW) == 0) {
        break label148;
      }
      i = a.h(this.jcW);
      a.i(this.jcW);
    }
    for (;;)
    {
      a.b(this.jcW, i);
      AppMethodBeat.o(133668);
      return;
      i = 600;
      break;
      label148:
      i = this.Au;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.5
 * JD-Core Version:    0.7.0.1
 */