package com.tencent.mm.plugin.cdndownloader.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;

public final class c
  extends j<a>
{
  public static final String[] SQL_CREATE;
  
  static
  {
    AppMethodBeat.i(120815);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "CdnDownloadInfo") };
    AppMethodBeat.o(120815);
  }
  
  public c(e parame)
  {
    super(parame, a.info, "CdnDownloadInfo", null);
  }
  
  public final boolean VQ(String paramString)
  {
    AppMethodBeat.i(120814);
    boolean bool = execSQL("CdnDownloadInfo", String.format("delete from %s where %s=%s", new Object[] { "CdnDownloadInfo", "downloadUrlHashCode", Integer.valueOf(paramString.hashCode()) }));
    AppMethodBeat.o(120814);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.cdndownloader.f.c
 * JD-Core Version:    0.7.0.1
 */