package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.p;

final class c$b
  implements Runnable
{
  String dET;
  String hEw;
  
  public c$b(String paramString1, String paramString2)
  {
    this.dET = paramString1;
    this.hEw = paramString2;
  }
  
  public final void run()
  {
    AppMethodBeat.i(20247);
    if ((bt.isNullOrNil(this.dET)) || (bt.isNullOrNil(this.hEw)))
    {
      AppMethodBeat.o(20247);
      return;
    }
    ad.i("MicroMsg.AccountStorage", "MoveDataFiles :" + this.dET + " to :" + this.hEw);
    if (!e.abf())
    {
      AppMethodBeat.o(20247);
      return;
    }
    if (!this.hEw.substring(0, b.arU().length()).equals(b.arU()))
    {
      AppMethodBeat.o(20247);
      return;
    }
    i.cv(this.dET + "image/", this.hEw + "image/");
    p.fPs();
    i.cv(this.dET + "video/", this.hEw + "video/");
    i.cv(this.dET + "voice/", this.hEw + "voice/");
    i.cv(this.dET + "voice2/", this.hEw + "voice2/");
    i.cv(this.dET + "package/", this.hEw + "package/");
    i.cv(this.dET + "emoji/", this.hEw + "emoji/");
    i.cv(this.dET + "mailapp/", this.hEw + "mailapp/");
    i.cv(this.dET + "brandicon/", this.hEw + "brandicon/");
    AppMethodBeat.o(20247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.c.b
 * JD-Core Version:    0.7.0.1
 */