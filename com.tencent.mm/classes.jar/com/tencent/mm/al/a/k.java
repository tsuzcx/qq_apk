package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.reflect.Field;
import java.util.Map;

public final class k
  extends ai
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(116443);
    c.a locala = new c.a();
    locala.GvF = new Field[10];
    locala.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "userId";
    locala.GvH.put("userId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" userId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "userId";
    locala.columns[1] = "userName";
    locala.GvH.put("userName", "TEXT default '' ");
    localStringBuilder.append(" userName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "userNamePY";
    locala.GvH.put("userNamePY", "TEXT default '' ");
    localStringBuilder.append(" userNamePY TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "brandUserName";
    locala.GvH.put("brandUserName", "TEXT default '' ");
    localStringBuilder.append(" brandUserName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "UserVersion";
    locala.GvH.put("UserVersion", "INTEGER default '-1' ");
    localStringBuilder.append(" UserVersion INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "needToUpdate";
    locala.GvH.put("needToUpdate", "INTEGER default 'true' ");
    localStringBuilder.append(" needToUpdate INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "headImageUrl";
    locala.GvH.put("headImageUrl", "TEXT");
    localStringBuilder.append(" headImageUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "profileUrl";
    locala.GvH.put("profileUrl", "TEXT");
    localStringBuilder.append(" profileUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "bitFlag";
    locala.GvH.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "addMemberUrl";
    locala.GvH.put("addMemberUrl", "TEXT");
    localStringBuilder.append(" addMemberUrl TEXT");
    locala.columns[10] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(116443);
  }
  
  public final boolean aDm()
  {
    AppMethodBeat.i(116442);
    if (this.field_needToUpdate)
    {
      AppMethodBeat.o(116442);
      return true;
    }
    if ((bs.isNullOrNil(this.field_profileUrl)) && (bs.isNullOrNil(this.field_headImageUrl)))
    {
      AppMethodBeat.o(116442);
      return true;
    }
    if ((bs.isNullOrNil(this.field_userNamePY)) && (!bs.isNullOrNil(this.field_userName)))
    {
      AppMethodBeat.o(116442);
      return true;
    }
    AppMethodBeat.o(116442);
    return false;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
  
  public final boolean hc(int paramInt)
  {
    return (this.field_bitFlag & paramInt) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.a.k
 * JD-Core Version:    0.7.0.1
 */