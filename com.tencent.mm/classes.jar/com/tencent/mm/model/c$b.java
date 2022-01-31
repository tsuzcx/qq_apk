package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class c$b
  implements Runnable
{
  String cEG;
  String fkA;
  
  public c$b(String paramString1, String paramString2)
  {
    this.cEG = paramString1;
    this.fkA = paramString2;
  }
  
  public final void run()
  {
    AppMethodBeat.i(16204);
    if ((bo.isNullOrNil(this.cEG)) || (bo.isNullOrNil(this.fkA)))
    {
      AppMethodBeat.o(16204);
      return;
    }
    ab.d("MicroMsg.AccountStorage", "MoveDataFiles :" + this.cEG + " to :" + this.fkA);
    if (!f.Mi())
    {
      AppMethodBeat.o(16204);
      return;
    }
    if (!this.fkA.substring(0, com.tencent.mm.compatible.util.e.eQz.length()).equals(com.tencent.mm.compatible.util.e.eQz))
    {
      AppMethodBeat.o(16204);
      return;
    }
    com.tencent.mm.vfs.e.iG(this.cEG + "image/", this.fkA + "image/");
    com.tencent.mm.vfs.e.iG(this.cEG + "image2/", this.fkA + "image2/");
    com.tencent.mm.vfs.e.iG(this.cEG + "video/", this.fkA + "video/");
    com.tencent.mm.vfs.e.iG(this.cEG + "voice/", this.fkA + "voice/");
    com.tencent.mm.vfs.e.iG(this.cEG + "voice2/", this.fkA + "voice2/");
    com.tencent.mm.vfs.e.iG(this.cEG + "package/", this.fkA + "package/");
    com.tencent.mm.vfs.e.iG(this.cEG + "emoji/", this.fkA + "emoji/");
    com.tencent.mm.vfs.e.iG(this.cEG + "mailapp/", this.fkA + "mailapp/");
    com.tencent.mm.vfs.e.iG(this.cEG + "brandicon/", this.fkA + "brandicon/");
    AppMethodBeat.o(16204);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.c.b
 * JD-Core Version:    0.7.0.1
 */