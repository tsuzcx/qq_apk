package com.tencent.mm.plugin.appbrand.widget.desktop;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.am;

final class a$1
  implements Runnable
{
  a$1(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(133664);
    a.a(this.jcW, am.di(a.a(this.jcW)));
    ab.i("MicroMsg.AppBrandDesktopAnimController", "[run] mScrollOffset:" + a.b(this.jcW));
    AppMethodBeat.o(133664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.1
 * JD-Core Version:    0.7.0.1
 */