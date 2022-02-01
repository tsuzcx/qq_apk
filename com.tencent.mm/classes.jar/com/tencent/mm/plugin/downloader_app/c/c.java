package com.tencent.mm.plugin.downloader_app.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class c
  extends j<a>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(8965);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "DownloadTaskItem") };
    AppMethodBeat.o(8965);
  }
  
  public c(e parame)
  {
    super(parame, a.info, "DownloadTaskItem", null);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(8964);
    boolean bool = update(parama, new String[0]);
    AppMethodBeat.o(8964);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.c.c
 * JD-Core Version:    0.7.0.1
 */