package com.tencent.mm.ae;

import com.tencent.mm.h.c.s;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Map;
import junit.framework.Assert;

public final class g
  extends s
{
  public static c.a buS;
  
  static
  {
    c.a locala = new c.a();
    locala.ujL = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.ujN.put("msgId", "LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "msgId";
    locala.columns[1] = "xml";
    locala.ujN.put("xml", "TEXT");
    localStringBuilder.append(" xml TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "appId";
    locala.ujN.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "title";
    locala.ujN.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "description";
    locala.ujN.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "source";
    locala.ujN.put("source", "TEXT");
    localStringBuilder.append(" source TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "type";
    locala.ujN.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    buS = locala;
    if (b.cqk()) {
      Assert.assertTrue(Fl());
    }
  }
  
  private static final boolean Fl()
  {
    Field[] arrayOfField = g.a.class.getDeclaredFields();
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
    if (j > 193)
    {
      y.e("MicroMsg.AppMessage", "AppMessage.Content should not add new field!!! (%d) is over the limit(%d)!!!", new Object[] { Integer.valueOf(j), Integer.valueOf(193) });
      return false;
    }
    y.i("MicroMsg.AppMessage", "AppMessage.Content nonStaticFieldCount: %d", new Object[] { Integer.valueOf(j) });
    return true;
  }
  
  protected final c.a rM()
  {
    return buS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ae.g
 * JD-Core Version:    0.7.0.1
 */