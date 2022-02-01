package com.tencent.mm.ag;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.z;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import junit.framework.Assert;

public final class k
  extends z
{
  public static IAutoDBItem.MAutoDBInfo info;
  
  static
  {
    AppMethodBeat.i(150130);
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "msgId";
    localMAutoDBInfo.colsMap.put("msgId", "LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "msgId";
    localMAutoDBInfo.columns[1] = "xml";
    localMAutoDBInfo.colsMap.put("xml", "TEXT");
    localStringBuilder.append(" xml TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "title";
    localMAutoDBInfo.colsMap.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "description";
    localMAutoDBInfo.colsMap.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "source";
    localMAutoDBInfo.colsMap.put("source", "TEXT");
    localStringBuilder.append(" source TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    info = localMAutoDBInfo;
    if (CrashReportFactory.hasDebuger()) {
      Assert.assertTrue(aSt());
    }
    AppMethodBeat.o(150130);
  }
  
  private static final boolean aSt()
  {
    AppMethodBeat.i(150129);
    Field[] arrayOfField = k.b.class.getDeclaredFields();
    int i = 0;
    int k;
    for (int j = 0; i < arrayOfField.length; j = k)
    {
      k = j;
      if (!Modifier.isStatic(arrayOfField[i].getModifiers())) {
        k = j + 1;
      }
      i += 1;
    }
    if (j > 204)
    {
      Log.e("MicroMsg.AppMessage", "AppMessage.Content should not add new field!!! (%d) is over the limit(%d)!!!", new Object[] { Integer.valueOf(j), Integer.valueOf(204) });
      AppMethodBeat.o(150129);
      return false;
    }
    Log.i("MicroMsg.AppMessage", "AppMessage.Content nonStaticFieldCount: %d", new Object[] { Integer.valueOf(j) });
    AppMethodBeat.o(150129);
    return true;
  }
  
  public final IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ag.k
 * JD-Core Version:    0.7.0.1
 */