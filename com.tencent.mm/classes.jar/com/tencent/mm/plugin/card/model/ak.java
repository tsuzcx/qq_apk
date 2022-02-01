package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ex;
import com.tencent.mm.protocal.protobuf.tw;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class ak
  extends ex
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(112869);
    c.a locala = new c.a();
    locala.IBL = new Field[2];
    locala.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "cardUserId";
    locala.IBN.put("cardUserId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" cardUserId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "cardUserId";
    locala.columns[1] = "retryCount";
    locala.IBN.put("retryCount", "INTEGER");
    localStringBuilder.append(" retryCount INTEGER");
    locala.columns[2] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(112869);
  }
  
  public static ak b(tw paramtw)
  {
    AppMethodBeat.i(112868);
    ak localak = new ak();
    localak.field_cardUserId = paramtw.Gaq;
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
  
  public final c.a getDBInfo()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.ak
 * JD-Core Version:    0.7.0.1
 */