package com.tencent.mm.plugin.account.ui;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.b;

public abstract class b
  extends SecurityImage.b
{
  SecurityImage fex = null;
  m fkS = null;
  
  public final void Ws()
  {
    g.Dk().a(a(this.fkS, ""), 0);
  }
  
  public abstract m a(m paramm, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.b
 * JD-Core Version:    0.7.0.1
 */