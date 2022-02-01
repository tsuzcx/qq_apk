package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.z;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import junit.framework.Assert;

public final class k
  extends z
{
  public static c.a info;
  
  static
  {
    AppMethodBeat.i(150130);
    c.a locala = new c.a();
    locala.GvF = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.GvH.put("msgId", "LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "msgId";
    locala.columns[1] = "xml";
    locala.GvH.put("xml", "TEXT");
    localStringBuilder.append(" xml TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "appId";
    locala.GvH.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "title";
    locala.GvH.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "description";
    locala.GvH.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "source";
    locala.GvH.put("source", "TEXT");
    localStringBuilder.append(" source TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "type";
    locala.GvH.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    if (b.eUk()) {
      Assert.assertTrue(awl());
    }
    AppMethodBeat.o(150130);
  }
  
  private static final boolean awl()
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
    if (j > 197)
    {
      ac.e("MicroMsg.AppMessage", "AppMessage.Content should not add new field!!! (%d) is over the limit(%d)!!!", new Object[] { Integer.valueOf(j), Integer.valueOf(197) });
      AppMethodBeat.o(150129);
      return false;
    }
    ac.i("MicroMsg.AppMessage", "AppMessage.Content nonStaticFieldCount: %d", new Object[] { Integer.valueOf(j) });
    AppMethodBeat.o(150129);
    return true;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ah.k
 * JD-Core Version:    0.7.0.1
 */