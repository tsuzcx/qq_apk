package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

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
    if (!e.avA())
    {
      AppMethodBeat.o(20247);
      return;
    }
    if (!this.to.substring(0, b.aSL().length()).equals(b.aSL()))
    {
      AppMethodBeat.o(20247);
      return;
    }
    u.or(this.from + "image/", this.to + "image/");
    u.or(this.from + "video/", this.to + "video/");
    u.or(this.from + "voice/", this.to + "voice/");
    u.or(this.from + "voice2/", this.to + "voice2/");
    u.or(this.from + "package/", this.to + "package/");
    u.or(this.from + "emoji/", this.to + "emoji/");
    u.or(this.from + "mailapp/", this.to + "mailapp/");
    u.or(this.from + "brandicon/", this.to + "brandicon/");
    AppMethodBeat.o(20247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.c.b
 * JD-Core Version:    0.7.0.1
 */