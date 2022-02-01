package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ff;
import com.tencent.mm.protocal.protobuf.vb;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class ak
  extends ff
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(112869);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "cardUserId";
    localMAutoDBInfo.colsMap.put("cardUserId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" cardUserId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "cardUserId";
    localMAutoDBInfo.columns[1] = "retryCount";
    localMAutoDBInfo.colsMap.put("retryCount", "INTEGER");
    localStringBuilder.append(" retryCount INTEGER");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(112869);
  }
  
  public static ak b(vb paramvb)
  {
    AppMethodBeat.i(112868);
    ak localak = new ak();
    localak.field_cardUserId = paramvb.KUk;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ak
 * JD-Core Version:    0.7.0.1
 */