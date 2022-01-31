package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ek;
import com.tencent.mm.protocal.protobuf.cbv;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class n
  extends ek
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(88086);
    c.a locala = new c.a();
    locala.yrK = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "card_id";
    locala.yrM.put("card_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" card_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "card_id";
    locala.columns[1] = "state_flag";
    locala.yrM.put("state_flag", "INTEGER");
    localStringBuilder.append(" state_flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "update_time";
    locala.yrM.put("update_time", "LONG");
    localStringBuilder.append(" update_time LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "seq";
    locala.yrM.put("seq", "LONG");
    localStringBuilder.append(" seq LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "retryCount";
    locala.yrM.put("retryCount", "INTEGER");
    localStringBuilder.append(" retryCount INTEGER");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(88086);
  }
  
  public static n c(cbv paramcbv)
  {
    AppMethodBeat.i(88085);
    n localn = new n();
    localn.field_card_id = paramcbv.cHn;
    localn.field_update_time = paramcbv.wAo;
    localn.field_state_flag = paramcbv.kpN;
    localn.field_seq = paramcbv.xyE;
    localn.field_retryCount = 10;
    AppMethodBeat.o(88085);
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
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(88084);
    if (this.field_card_id == null)
    {
      AppMethodBeat.o(88084);
      return 0;
    }
    int i = this.field_card_id.hashCode();
    AppMethodBeat.o(88084);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.n
 * JD-Core Version:    0.7.0.1
 */