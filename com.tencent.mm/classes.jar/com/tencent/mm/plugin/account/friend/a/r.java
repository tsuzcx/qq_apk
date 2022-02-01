package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ey;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public final class r
  extends ey
{
  protected static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(184421);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[9];
    localMAutoDBInfo.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "encryptUsername";
    localMAutoDBInfo.colsMap.put("encryptUsername", "TEXT");
    localStringBuilder.append(" encryptUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "oldUsername";
    localMAutoDBInfo.colsMap.put("oldUsername", "TEXT");
    localStringBuilder.append(" oldUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "ticket";
    localMAutoDBInfo.colsMap.put("ticket", "TEXT");
    localStringBuilder.append(" ticket TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "nickname";
    localMAutoDBInfo.colsMap.put("nickname", "TEXT");
    localStringBuilder.append(" nickname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "addState";
    localMAutoDBInfo.colsMap.put("addState", "INTEGER");
    localStringBuilder.append(" addState INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "showHead";
    localMAutoDBInfo.colsMap.put("showHead", "INTEGER");
    localStringBuilder.append(" showHead INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "pinyinName";
    localMAutoDBInfo.colsMap.put("pinyinName", "TEXT");
    localStringBuilder.append(" pinyinName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "seq";
    localMAutoDBInfo.colsMap.put("seq", "INTEGER");
    localStringBuilder.append(" seq INTEGER");
    localMAutoDBInfo.columns[9] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    AppMethodBeat.o(184421);
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.r
 * JD-Core Version:    0.7.0.1
 */