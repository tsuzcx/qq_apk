package com.tencent.mm.openim.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fv;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class e
  extends fv
{
  public static IAutoDBItem.MAutoDBInfo dbInfo;
  
  static
  {
    AppMethodBeat.i(235749);
    dbInfo = aJm();
    AppMethodBeat.o(235749);
  }
  
  public e(String paramString1, String paramString2)
  {
    this.field_username = paramString1;
    this.field_content = paramString2;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return dbInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.e.e
 * JD-Core Version:    0.7.0.1
 */