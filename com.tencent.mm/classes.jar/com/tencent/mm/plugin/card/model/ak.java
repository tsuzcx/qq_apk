package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.gd;
import com.tencent.mm.protocal.protobuf.wu;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class ak
  extends gd
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(112869);
    info = gd.aJm();
    AppMethodBeat.o(112869);
  }
  
  public static ak b(wu paramwu)
  {
    AppMethodBeat.i(112868);
    ak localak = new ak();
    localak.field_cardUserId = paramwu.YSF;
    AppMethodBeat.o(112868);
    return localak;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ak)) {}
    do
    {
      return false;
      paramObject = (ak)paramObject;
    } while (this.field_cardUserId != paramObject.field_cardUserId);
    return true;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(112867);
    if (this.field_cardUserId == null)
    {
      AppMethodBeat.o(112867);
      return 0;
    }
    int i = this.field_cardUserId.hashCode();
    AppMethodBeat.o(112867);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ak
 * JD-Core Version:    0.7.0.1
 */