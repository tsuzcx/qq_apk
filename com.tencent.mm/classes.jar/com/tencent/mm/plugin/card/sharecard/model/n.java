package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fu;
import com.tencent.mm.protocal.protobuf.ded;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class n
  extends fu
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(113025);
    c.a locala = new c.a();
    locala.IBL = new Field[5];
    locala.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "card_id";
    locala.IBN.put("card_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" card_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "card_id";
    locala.columns[1] = "state_flag";
    locala.IBN.put("state_flag", "INTEGER");
    localStringBuilder.append(" state_flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "update_time";
    locala.IBN.put("update_time", "LONG");
    localStringBuilder.append(" update_time LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "seq";
    locala.IBN.put("seq", "LONG");
    localStringBuilder.append(" seq LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "retryCount";
    locala.IBN.put("retryCount", "INTEGER");
    localStringBuilder.append(" retryCount INTEGER");
    locala.columns[5] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(113025);
  }
  
  public static n c(ded paramded)
  {
    AppMethodBeat.i(113024);
    n localn = new n();
    localn.field_card_id = paramded.dJb;
    localn.field_update_time = paramded.GcL;
    localn.field_state_flag = paramded.oId;
    localn.field_seq = paramded.seq;
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
  
  public final c.a getDBInfo()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.n
 * JD-Core Version:    0.7.0.1
 */