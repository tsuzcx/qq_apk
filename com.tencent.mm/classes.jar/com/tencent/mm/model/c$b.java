package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;
import com.tencent.mm.vfs.p;

final class c$b
  implements Runnable
{
  String dsT;
  String hmj;
  
  public c$b(String paramString1, String paramString2)
  {
    this.dsT = paramString1;
    this.hmj = paramString2;
  }
  
  public final void run()
  {
    AppMethodBeat.i(20247);
    if ((bs.isNullOrNil(this.dsT)) || (bs.isNullOrNil(this.hmj)))
    {
      AppMethodBeat.o(20247);
      return;
    }
    ac.d("MicroMsg.AccountStorage", "MoveDataFiles :" + this.dsT + " to :" + this.hmj);
    if (!e.YD())
    {
      AppMethodBeat.o(20247);
      return;
    }
    if (!this.hmj.substring(0, b.aph().length()).equals(b.aph()))
    {
      AppMethodBeat.o(20247);
      return;
    }
    i.ct(this.dsT + "image/", this.hmj + "image/");
    if (!p.fyy()) {
      i.ct(this.dsT + "image2/", this.hmj + "image2/");
    }
    i.ct(this.dsT + "video/", this.hmj + "video/");
    i.ct(this.dsT + "voice/", this.hmj + "voice/");
    i.ct(this.dsT + "voice2/", this.hmj + "voice2/");
    i.ct(this.dsT + "package/", this.hmj + "package/");
    i.ct(this.dsT + "emoji/", this.hmj + "emoji/");
    i.ct(this.dsT + "mailapp/", this.hmj + "mailapp/");
    i.ct(this.dsT + "brandicon/", this.hmj + "brandicon/");
    AppMethodBeat.o(20247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.c.b
 * JD-Core Version:    0.7.0.1
 */