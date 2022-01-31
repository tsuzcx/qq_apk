package com.tencent.mm.plugin.card.model;

import com.tencent.mm.h.c.de;
import com.tencent.mm.protocal.c.mi;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class ak
  extends de
{
  protected static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "cardUserId";
    locala.ujN.put("cardUserId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" cardUserId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "cardUserId";
    locala.columns[1] = "retryCount";
    locala.ujN.put("retryCount", "INTEGER");
    localStringBuilder.append(" retryCount INTEGER");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
  }
  
  public static ak a(mi parammi)
  {
    ak localak = new ak();
    localak.field_cardUserId = parammi.sJe;
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
  
  public final int hashCode()
  {
    if (this.field_cardUserId == null) {
      return 0;
    }
    return this.field_cardUserId.hashCode();
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ak
 * JD-Core Version:    0.7.0.1
 */