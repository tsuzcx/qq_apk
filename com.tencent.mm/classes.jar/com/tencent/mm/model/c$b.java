package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.v;

final class c$b
  implements Runnable
{
  String dFY;
  String hHo;
  
  public c$b(String paramString1, String paramString2)
  {
    this.dFY = paramString1;
    this.hHo = paramString2;
  }
  
  public final void run()
  {
    AppMethodBeat.i(20247);
    if ((bu.isNullOrNil(this.dFY)) || (bu.isNullOrNil(this.hHo)))
    {
      AppMethodBeat.o(20247);
      return;
    }
    ae.i("MicroMsg.AccountStorage", "MoveDataFiles :" + this.dFY + " to :" + this.hHo);
    if (!e.abo())
    {
      AppMethodBeat.o(20247);
      return;
    }
    if (!this.hHo.substring(0, b.asj().length()).equals(b.asj()))
    {
      AppMethodBeat.o(20247);
      return;
    }
    o.cx(this.dFY + "image/", this.hHo + "image/");
    v.fTP();
    o.cx(this.dFY + "video/", this.hHo + "video/");
    o.cx(this.dFY + "voice/", this.hHo + "voice/");
    o.cx(this.dFY + "voice2/", this.hHo + "voice2/");
    o.cx(this.dFY + "package/", this.hHo + "package/");
    o.cx(this.dFY + "emoji/", this.hHo + "emoji/");
    o.cx(this.dFY + "mailapp/", this.hHo + "mailapp/");
    o.cx(this.dFY + "brandicon/", this.hHo + "brandicon/");
    AppMethodBeat.o(20247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.c.b
 * JD-Core Version:    0.7.0.1
 */