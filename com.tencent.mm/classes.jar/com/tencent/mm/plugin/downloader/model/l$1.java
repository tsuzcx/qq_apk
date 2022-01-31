package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.f;
import com.tencent.mm.plugin.downloader.g.a;

final class l$1
  implements Runnable
{
  l$1(l paraml, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(2465);
    a locala = d.iJ(this.kYi);
    if (locala == null)
    {
      AppMethodBeat.o(2465);
      return;
    }
    f.afO().sJ(locala.field_downloadUrl);
    if (locala.field_status != 5)
    {
      locala.field_status = 5;
      d.e(locala);
      this.kZg.kYw.iF(this.kYi);
    }
    AppMethodBeat.o(2465);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.l.1
 * JD-Core Version:    0.7.0.1
 */