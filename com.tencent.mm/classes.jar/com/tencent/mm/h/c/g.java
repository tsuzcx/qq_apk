package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class g
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int csS;
  private static final int csT;
  private static final int cst = "userName".hashCode();
  private boolean crV = true;
  private boolean csQ = true;
  private boolean csR = true;
  public int field_scene;
  public String field_ticket;
  public String field_userName;
  
  static
  {
    csS = "scene".hashCode();
    csT = "ticket".hashCode();
  }
  
  public static c.a vg()
  {
    c.a locala = new c.a();
    locala.ujL = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "userName";
    locala.ujN.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    locala.columns[1] = "scene";
    locala.ujN.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "ticket";
    locala.ujN.put("ticket", "TEXT");
    localStringBuilder.append(" ticket TEXT");
    locala.columns[3] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
  }
  
  public final void d(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (cst != k) {
        break label60;
      }
      this.field_userName = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (csS == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (csT == k) {
        this.field_ticket = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.crV) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.csQ) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.csR) {
      localContentValues.put("ticket", this.field_ticket);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.h.c.g
 * JD-Core Version:    0.7.0.1
 */