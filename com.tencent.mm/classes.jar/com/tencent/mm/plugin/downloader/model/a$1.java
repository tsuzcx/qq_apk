package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;

final class a$1
  implements Runnable
{
  a$1(long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(141054);
    com.tencent.mm.plugin.downloader.g.a locala = d.iJ(this.kXZ);
    if ((locala != null) && (a.mF(locala.field_status))) {
      f.bjl().f(locala);
    }
    int i = bo.a((Integer)a.Nt().get(Long.valueOf(this.kXZ)), 0);
    a.Nt().put(Long.valueOf(this.kXZ), Integer.valueOf(i + 1));
    AppMethodBeat.o(141054);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.a.1
 * JD-Core Version:    0.7.0.1
 */