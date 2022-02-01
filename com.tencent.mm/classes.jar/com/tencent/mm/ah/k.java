package com.tencent.mm.ah;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.z;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
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
    locala.IBL = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.IBN.put("msgId", "LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "msgId";
    locala.columns[1] = "xml";
    locala.IBN.put("xml", "TEXT");
    localStringBuilder.append(" xml TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "appId";
    locala.IBN.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "title";
    locala.IBN.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "description";
    locala.IBN.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "source";
    locala.IBN.put("source", "TEXT");
    localStringBuilder.append(" source TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "type";
    locala.IBN.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    if (b.fnF()) {
      Assert.assertTrue(azn());
    }
    AppMethodBeat.o(150130);
  }
  
  private static final boolean azn()
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
    if (j > 201)
    {
      ae.e("MicroMsg.AppMessage", "AppMessage.Content should not add new field!!! (%d) is over the limit(%d)!!!", new Object[] { Integer.valueOf(j), Integer.valueOf(201) });
      AppMethodBeat.o(150129);
      return false;
    }
    ae.i("MicroMsg.AppMessage", "AppMessage.Content nonStaticFieldCount: %d", new Object[] { Integer.valueOf(j) });
    AppMethodBeat.o(150129);
    return true;
  }
  
  public final c.a getDBInfo()
  {
    return info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ah.k
 * JD-Core Version:    0.7.0.1
 */