package com.tencent.mm.an.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ak;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class k
  extends ak
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(116443);
    info = ak.aJm();
    AppMethodBeat.o(116443);
  }
  
  public final boolean bHy()
  {
    AppMethodBeat.i(116442);
    if (this.field_needToUpdate)
    {
      AppMethodBeat.o(116442);
      return true;
    }
    if ((Util.isNullOrNil(this.field_profileUrl)) && (Util.isNullOrNil(this.field_headImageUrl)))
    {
      AppMethodBeat.o(116442);
      return true;
    }
    if ((Util.isNullOrNil(this.field_userNamePY)) && (!Util.isNullOrNil(this.field_userName)))
    {
      AppMethodBeat.o(116442);
      return true;
    }
    AppMethodBeat.o(116442);
    return false;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final boolean nG(int paramInt)
  {
    return (this.field_bitFlag & paramInt) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.an.a.k
 * JD-Core Version:    0.7.0.1
 */