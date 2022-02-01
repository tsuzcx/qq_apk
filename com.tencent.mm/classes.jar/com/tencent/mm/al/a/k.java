package com.tencent.mm.al.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bu;
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
    locala.IBL = new Field[10];
    locala.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "userId";
    locala.IBN.put("userId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" userId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "userId";
    locala.columns[1] = "userName";
    locala.IBN.put("userName", "TEXT default '' ");
    localStringBuilder.append(" userName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "userNamePY";
    locala.IBN.put("userNamePY", "TEXT default '' ");
    localStringBuilder.append(" userNamePY TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "brandUserName";
    locala.IBN.put("brandUserName", "TEXT default '' ");
    localStringBuilder.append(" brandUserName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "UserVersion";
    locala.IBN.put("UserVersion", "INTEGER default '-1' ");
    localStringBuilder.append(" UserVersion INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "needToUpdate";
    locala.IBN.put("needToUpdate", "INTEGER default 'true' ");
    localStringBuilder.append(" needToUpdate INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "headImageUrl";
    locala.IBN.put("headImageUrl", "TEXT");
    localStringBuilder.append(" headImageUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "profileUrl";
    locala.IBN.put("profileUrl", "TEXT");
    localStringBuilder.append(" profileUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "bitFlag";
    locala.IBN.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "addMemberUrl";
    locala.IBN.put("addMemberUrl", "TEXT");
    localStringBuilder.append(" addMemberUrl TEXT");
    locala.columns[10] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(116443);
  }
  
  public final boolean aGF()
  {
    AppMethodBeat.i(116442);
    if (this.field_needToUpdate)
    {
      AppMethodBeat.o(116442);
      return true;
    }
    if ((bu.isNullOrNil(this.field_profileUrl)) && (bu.isNullOrNil(this.field_headImageUrl)))
    {
      AppMethodBeat.o(116442);
      return true;
    }
    if ((bu.isNullOrNil(this.field_userNamePY)) && (!bu.isNullOrNil(this.field_userName)))
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
  
  public final boolean hk(int paramInt)
  {
    return (this.field_bitFlag & paramInt) != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.a.k
 * JD-Core Version:    0.7.0.1
 */