package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gd;
import com.tencent.mm.protocal.protobuf.dxh;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class n
  extends gd
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(113025);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[5];
    localMAutoDBInfo.columns = new String[6];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "card_id";
    localMAutoDBInfo.colsMap.put("card_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" card_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "card_id";
    localMAutoDBInfo.columns[1] = "state_flag";
    localMAutoDBInfo.colsMap.put("state_flag", "INTEGER");
    localStringBuilder.append(" state_flag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "update_time";
    localMAutoDBInfo.colsMap.put("update_time", "LONG");
    localStringBuilder.append(" update_time LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "seq";
    localMAutoDBInfo.colsMap.put("seq", "LONG");
    localStringBuilder.append(" seq LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "retryCount";
    localMAutoDBInfo.colsMap.put("retryCount", "INTEGER");
    localStringBuilder.append(" retryCount INTEGER");
    localMAutoDBInfo.columns[5] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(113025);
  }
  
  public static n c(dxh paramdxh)
  {
    AppMethodBeat.i(113024);
    n localn = new n();
    localn.field_card_id = paramdxh.eaO;
    localn.field_update_time = paramdxh.KWR;
    localn.field_state_flag = paramdxh.pVR;
    localn.field_seq = paramdxh.seq;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.n
 * JD-Core Version:    0.7.0.1
 */