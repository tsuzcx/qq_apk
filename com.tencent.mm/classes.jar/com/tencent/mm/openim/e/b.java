package com.tencent.mm.openim.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;

public final class b
  extends j<a>
{
  public static final String[] SQL_CREATE;
  public h fnw;
  
  static
  {
    AppMethodBeat.i(78984);
    SQL_CREATE = new String[] { j.getCreateSQLs(a.info, "OpenIMAccTypeInfo") };
    AppMethodBeat.o(78984);
  }
  
  public b(h paramh)
  {
    super(paramh, a.info, "OpenIMAccTypeInfo", null);
    this.fnw = paramh;
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(78982);
    parama.field_updateTime = bo.aox();
    boolean bool = super.replace(parama);
    AppMethodBeat.o(78982);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.openim.e.b
 * JD-Core Version:    0.7.0.1
 */