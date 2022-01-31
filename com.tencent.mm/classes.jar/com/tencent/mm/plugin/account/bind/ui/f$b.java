package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ab;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.b;

final class f$b
  extends SecurityImage.b
{
  f$b(f paramf) {}
  
  public final void Ws()
  {
    this.feE.Fj();
    ab localab = new ab(5, this.feE.fey, this.feE.fex.getSecImgSid(), this.feE.fex.getSecImgCode(), this.feE.fex.getSecImgEncryptKey(), true, 1);
    g.Dk().a(localab, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.f.b
 * JD-Core Version:    0.7.0.1
 */