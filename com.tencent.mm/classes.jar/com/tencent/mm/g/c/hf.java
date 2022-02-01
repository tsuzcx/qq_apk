package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class hf
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eVm = "appid".hashCode();
  private static final int eok;
  private static final int eov = "token".hashCode();
  private static final int fht;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eVk = true;
  private boolean eoh = true;
  private boolean eou = true;
  private boolean fgO = true;
  public String field_appid;
  public String field_token;
  public int field_uin;
  public String field_username;
  
  static
  {
    eok = "username".hashCode();
    fht = "uin".hashCode();
  }
  
  public static c.a Th()
  {
    c.a locala = new c.a();
    locala.GvF = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "token";
    locala.GvH.put("token", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" token TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "token";
    locala.columns[1] = "username";
    locala.GvH.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "uin";
    locala.GvH.put("uin", "INTEGER");
    localStringBuilder.append(" uin INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "appid";
    locala.GvH.put("appid", "TEXT");
    localStringBuilder.append(" appid TEXT");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
  }
  
  public void convertFrom(Cursor paramCursor)
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
      if (eov != k) {
        break label65;
      }
      this.field_token = paramCursor.getString(i);
      this.eou = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eok == k) {
        this.field_username = paramCursor.getString(i);
      } else if (fht == k) {
        this.field_uin = paramCursor.getInt(i);
      } else if (eVm == k) {
        this.field_appid = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eou) {
      localContentValues.put("token", this.field_token);
    }
    if (this.eoh) {
      localContentValues.put("username", this.field_username);
    }
    if (this.fgO) {
      localContentValues.put("uin", Integer.valueOf(this.field_uin));
    }
    if (this.eVk) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.hf
 * JD-Core Version:    0.7.0.1
 */