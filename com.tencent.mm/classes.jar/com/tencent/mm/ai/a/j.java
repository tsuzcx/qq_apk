package com.tencent.mm.ai.a;

import com.tencent.mm.h.c.ac;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.lang.reflect.Field;
import java.util.Map;

public final class j
  extends ac
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[10];
    locala.columns = new String[11];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "userId";
    locala.ujN.put("userId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" userId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "userId";
    locala.columns[1] = "userName";
    locala.ujN.put("userName", "TEXT default '' ");
    localStringBuilder.append(" userName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "userNamePY";
    locala.ujN.put("userNamePY", "TEXT default '' ");
    localStringBuilder.append(" userNamePY TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "brandUserName";
    locala.ujN.put("brandUserName", "TEXT default '' ");
    localStringBuilder.append(" brandUserName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "UserVersion";
    locala.ujN.put("UserVersion", "INTEGER default '-1' ");
    localStringBuilder.append(" UserVersion INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[5] = "needToUpdate";
    locala.ujN.put("needToUpdate", "INTEGER default 'true' ");
    localStringBuilder.append(" needToUpdate INTEGER default 'true' ");
    localStringBuilder.append(", ");
    locala.columns[6] = "headImageUrl";
    locala.ujN.put("headImageUrl", "TEXT");
    localStringBuilder.append(" headImageUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "profileUrl";
    locala.ujN.put("profileUrl", "TEXT");
    localStringBuilder.append(" profileUrl TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "bitFlag";
    locala.ujN.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[9] = "addMemberUrl";
    locala.ujN.put("addMemberUrl", "TEXT");
    localStringBuilder.append(" addMemberUrl TEXT");
    locala.columns[10] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public final boolean MO()
  {
    if (this.field_needToUpdate) {}
    while (((bk.bl(this.field_profileUrl)) && (bk.bl(this.field_headImageUrl))) || ((bk.bl(this.field_userNamePY)) && (!bk.bl(this.field_userName)))) {
      return true;
    }
    return false;
  }
  
  public final boolean il(int paramInt)
  {
    return (this.field_bitFlag & paramInt) != 0;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ai.a.j
 * JD-Core Version:    0.7.0.1
 */