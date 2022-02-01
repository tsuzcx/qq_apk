package com.tencent.mm.openim.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;

public class h
  extends MAutoStorage<g>
{
  public static final String[] SQL_CREATE;
  public com.tencent.mm.storagebase.h omV;
  
  static
  {
    AppMethodBeat.i(235745);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(g.info, "OpenIMFinderInfoNew") };
    AppMethodBeat.o(235745);
  }
  
  public h(com.tencent.mm.storagebase.h paramh)
  {
    super(paramh, g.info, "OpenIMFinderInfoNew", null);
    this.omV = paramh;
  }
  
  public final boolean a(g paramg)
  {
    AppMethodBeat.i(235747);
    Log.i("MicroMsg.Openim.OpenIMFinderInfoStg", "replace " + paramg.field_openIMUsername + "," + paramg.field_finder_username);
    boolean bool = super.replace(paramg);
    AppMethodBeat.o(235747);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.e.h
 * JD-Core Version:    0.7.0.1
 */