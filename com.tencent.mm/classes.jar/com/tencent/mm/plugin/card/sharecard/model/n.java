package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.he;
import com.tencent.mm.protocal.protobuf.fbi;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public final class n
  extends he
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(113025);
    info = he.aJm();
    AppMethodBeat.o(113025);
  }
  
  public static n c(fbi paramfbi)
  {
    AppMethodBeat.i(113024);
    n localn = new n();
    localn.field_card_id = paramfbi.iaI;
    localn.field_update_time = paramfbi.update_time;
    localn.field_state_flag = paramfbi.wwq;
    localn.field_seq = paramfbi.seq;
    localn.field_retryCount = 10;
    AppMethodBeat.o(113024);
    return localn;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof n)) {}
    do
    {
      return false;
      paramObject = (n)paramObject;
    } while (this.field_card_id != paramObject.field_card_id);
    return true;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(113023);
    if (this.field_card_id == null)
    {
      AppMethodBeat.o(113023);
      return 0;
    }
    int i = this.field_card_id.hashCode();
    AppMethodBeat.o(113023);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.n
 * JD-Core Version:    0.7.0.1
 */