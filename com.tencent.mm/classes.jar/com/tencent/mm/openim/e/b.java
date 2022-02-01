package com.tencent.mm.openim.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;

public final class b
  extends MAutoStorage<a>
{
  public static final String[] SQL_CREATE;
  public h iFy;
  
  static
  {
    AppMethodBeat.i(151328);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(a.info, "OpenIMAccTypeInfo") };
    AppMethodBeat.o(151328);
  }
  
  public b(h paramh)
  {
    super(paramh, a.info, "OpenIMAccTypeInfo", null);
    this.iFy = paramh;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(151326);
    parama.field_updateTime = Util.nowSecond();
    boolean bool = super.replace(parama);
    AppMethodBeat.o(151326);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.e.b
 * JD-Core Version:    0.7.0.1
 */