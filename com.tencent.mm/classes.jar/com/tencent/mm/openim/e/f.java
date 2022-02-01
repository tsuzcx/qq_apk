package com.tencent.mm.openim.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;

public class f
  extends MAutoStorage<e>
{
  public static final String[] SQL_CREATE;
  public h lvy;
  
  static
  {
    AppMethodBeat.i(209460);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(e.info, "OpenIMFinderInfo") };
    AppMethodBeat.o(209460);
  }
  
  public f(h paramh)
  {
    super(paramh, e.info, "OpenIMFinderInfo", null);
    this.lvy = paramh;
  }
  
  public final boolean a(e parame)
  {
    AppMethodBeat.i(209458);
    Log.i("MicroMsg.Openim.OpenIMFinderInfoStg", "replace " + parame.field_openIMUsername + "," + parame.field_finder_username);
    boolean bool = super.replace(parame);
    AppMethodBeat.o(209458);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.e.f
 * JD-Core Version:    0.7.0.1
 */