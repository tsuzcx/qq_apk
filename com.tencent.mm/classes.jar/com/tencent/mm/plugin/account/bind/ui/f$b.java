package com.tencent.mm.plugin.account.bind.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ac;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.b;

final class f$b
  extends SecurityImage.b
{
  f$b(f paramf) {}
  
  public final void apW()
  {
    AppMethodBeat.i(13756);
    this.gwn.Yj();
    ac localac = new ac(5, this.gwn.gwh, this.gwn.gwg.getSecImgSid(), this.gwn.gwg.getSecImgCode(), this.gwn.gwg.getSecImgEncryptKey(), true, 1);
    g.Rc().a(localac, 0);
    AppMethodBeat.o(13756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.f.b
 * JD-Core Version:    0.7.0.1
 */