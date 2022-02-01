package com.tencent.mm.ao.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.aj;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class k
  extends aj
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(116443);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[10];
    localMAutoDBInfo.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "userId";
    localMAutoDBInfo.colsMap.put("userId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" userId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "userId";
    localMAutoDBInfo.columns[1] = "userName";
    localMAutoDBInfo.colsMap.put("userName", "TEXT default '' ");
    localStringBuilder.append(" userName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "userNamePY";
    localMAutoDBInfo.colsMap.put("userNamePY", "TEXT default '' ");
    localStringBuilder.append(" userNamePY TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "brandUserName";
    localMAutoDBInfo.colsMap.put("brandUserName", "TEXT default '' ");
    localStringBuilder.append(" brandUserName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "UserVersion";
    localMAutoDBInfo.colsMap.put("UserVersion", "INTEGER default '-1' ");
    localStringBuilder.append(" UserVersion INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "needToUpdate";
    localMAutoDBInfo.colsMap.put("needToUpdate", "INTEGER default 'true' ");
    localStringBuilder.append(" needToUpdate INTEGER default 'true' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "headImageUrl";
    localMAutoDBInfo.colsMap.put("headImageUrl", "TEXT");
    localStringBuilder.append(" headImageUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "profileUrl";
    localMAutoDBInfo.colsMap.put("profileUrl", "TEXT");
    localStringBuilder.append(" profileUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "bitFlag";
    localMAutoDBInfo.colsMap.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "addMemberUrl";
    localMAutoDBInfo.colsMap.put("addMemberUrl", "TEXT");
    localStringBuilder.append(" addMemberUrl TEXT");
    localMAutoDBInfo.columns[10] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(116443);
  }
  
  public final boolean bjN()
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
  
  public final boolean jQ(int paramInt)
  {
    return (this.field_bitFlag & paramInt) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ao.a.k
 * JD-Core Version:    0.7.0.1
 */