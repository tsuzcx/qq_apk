package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.ui.widget.a.d;
import java.util.List;

public final class m
  extends l
{
  m(s params, List<com.tencent.mm.plugin.appbrand.menu.n> paramList)
  {
    super(params, paramList);
  }
  
  protected final void a(d paramd)
  {
    boolean bool2 = false;
    super.a(paramd);
    s locals = (s)this.gSP;
    boolean bool1;
    if (locals.getRuntime().ZH()) {
      if ((locals.isFullScreen()) || (locals.anp()))
      {
        bool1 = true;
        paramd.rxb = bool1;
        if (!locals.isFullScreen())
        {
          bool1 = bool2;
          if (!locals.anp()) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    for (paramd.rxc = bool1;; paramd.rxc = locals.isFullScreen())
    {
      locals.a(new m.1(this, locals));
      locals.a(new m.2(this, locals));
      return;
      bool1 = false;
      break;
      paramd.rxb = locals.isFullScreen();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.m
 * JD-Core Version:    0.7.0.1
 */