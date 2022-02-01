package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

final class c$b
  implements Runnable
{
  String from;
  String to;
  
  public c$b(String paramString1, String paramString2)
  {
    this.from = paramString1;
    this.to = paramString2;
  }
  
  public final void run()
  {
    AppMethodBeat.i(20247);
    if ((Util.isNullOrNil(this.from)) || (Util.isNullOrNil(this.to)))
    {
      AppMethodBeat.o(20247);
      return;
    }
    Log.i("MicroMsg.AccountStorage", "MoveDataFiles :" + this.from + " to :" + this.to);
    if (!e.aPU())
    {
      AppMethodBeat.o(20247);
      return;
    }
    if (!this.to.substring(0, b.bmz().length()).equals(b.bmz()))
    {
      AppMethodBeat.o(20247);
      return;
    }
    y.qp(this.from + "image/", this.to + "image/");
    y.qp(this.from + "video/", this.to + "video/");
    y.qp(this.from + "voice/", this.to + "voice/");
    y.qp(this.from + "voice2/", this.to + "voice2/");
    y.qp(this.from + "package/", this.to + "package/");
    y.qp(this.from + "emoji/", this.to + "emoji/");
    y.qp(this.from + "mailapp/", this.to + "mailapp/");
    y.qp(this.from + "brandicon/", this.to + "brandicon/");
    AppMethodBeat.o(20247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.c.b
 * JD-Core Version:    0.7.0.1
 */