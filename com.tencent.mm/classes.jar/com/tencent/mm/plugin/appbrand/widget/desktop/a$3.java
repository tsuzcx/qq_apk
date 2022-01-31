package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.widget.ListView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;

final class a$3
  implements Runnable
{
  a$3(a parama) {}
  
  public final void run()
  {
    int i = a.c(this.hpC).getBottom();
    int j = a.b(this.hpC);
    a.d(this.hpC).smoothScrollBy(i - j, 520);
    a.f(this.hpC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.a.3
 * JD-Core Version:    0.7.0.1
 */