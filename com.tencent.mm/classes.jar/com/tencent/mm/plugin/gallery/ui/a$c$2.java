package com.tencent.mm.plugin.gallery.ui;

import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.HashMap;

final class a$c$2
  implements a.c.a
{
  public final void a(a.c paramc, int paramInt)
  {
    AppMethodBeat.i(21362);
    if ((paramc == null) || (a.c.c(paramc) == null))
    {
      AppMethodBeat.o(21362);
      return;
    }
    paramc = (TextView)a.c.c(paramc).get();
    if (paramc == null)
    {
      AppMethodBeat.o(21362);
      return;
    }
    a.c.h(paramc, paramInt);
    a.c.bEp().remove(paramc);
    AppMethodBeat.o(21362);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a.c.2
 * JD-Core Version:    0.7.0.1
 */