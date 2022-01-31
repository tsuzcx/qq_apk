package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.b;

public abstract class b
  extends SecurityImage.b
{
  m gCj = null;
  SecurityImage gwg = null;
  
  public abstract m a(m paramm, String paramString);
  
  public final void apW()
  {
    g.Rc().a(a(this.gCj, ""), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.b
 * JD-Core Version:    0.7.0.1
 */