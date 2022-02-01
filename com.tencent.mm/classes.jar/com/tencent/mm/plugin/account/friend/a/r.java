package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.eq;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public final class r
  extends eq
{
  protected static c.a info;
  
  static
  {
    AppMethodBeat.i(184421);
    c.a locala = new c.a();
    locala.IBL = new Field[9];
    locala.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "encryptUsername";
    locala.IBN.put("encryptUsername", "TEXT");
    localStringBuilder.append(" encryptUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "oldUsername";
    locala.IBN.put("oldUsername", "TEXT");
    localStringBuilder.append(" oldUsername TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "ticket";
    locala.IBN.put("ticket", "TEXT");
    localStringBuilder.append(" ticket TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "nickname";
    locala.IBN.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "addState";
    locala.IBN.put("addState", "INTEGER");
    localStringBuilder.append(" addState INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "showHead";
    locala.IBN.put("showHead", "INTEGER");
    localStringBuilder.append(" showHead INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "pinyinName";
    locala.IBN.put("pinyinName", "TEXT");
    localStringBuilder.append(" pinyinName TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "username";
    locala.IBN.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[8] = "seq";
    locala.IBN.put("seq", "INTEGER");
    localStringBuilder.append(" seq INTEGER");
    locala.columns[9] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    AppMethodBeat.o(184421);
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.r
 * JD-Core Version:    0.7.0.1
 */