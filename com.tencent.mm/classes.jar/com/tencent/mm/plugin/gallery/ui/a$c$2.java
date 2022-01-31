package com.tencent.mm.plugin.gallery.ui;

import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.HashMap;

final class a$c$2
  implements a.c.a
{
  public final void a(a.c paramc, int paramInt)
  {
    if ((paramc == null) || (a.c.c(paramc) == null)) {}
    do
    {
      return;
      paramc = (TextView)a.c.c(paramc).get();
    } while (paramc == null);
    a.c.e(paramc, paramInt);
    a.c.aXL().remove(paramc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.ui.a.c.2
 * JD-Core Version:    0.7.0.1
 */