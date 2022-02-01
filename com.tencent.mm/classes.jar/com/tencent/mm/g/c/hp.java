package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class hp
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFA = "token".hashCode();
  private static final int eFp = "username".hashCode();
  private static final int fnB = "appid".hashCode();
  private static final int fzB = "uin".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFm = true;
  private boolean eFz = true;
  public String field_appid;
  public String field_token;
  public int field_uin;
  public String field_username;
  private boolean fnz = true;
  private boolean fyW = true;
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "token";
    locala.IhC.put("token", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" token TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "token";
    locala.columns[1] = "username";
    locala.IhC.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "uin";
    locala.IhC.put("uin", "INTEGER");
    localStringBuilder.append(" uin INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "appid";
    locala.IhC.put("appid", "TEXT");
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
      if (eFA != k) {
        break label65;
      }
      this.field_token = paramCursor.getString(i);
      this.eFz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eFp == k) {
        this.field_username = paramCursor.getString(i);
      } else if (fzB == k) {
        this.field_uin = paramCursor.getInt(i);
      } else if (fnB == k) {
        this.field_appid = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eFz) {
      localContentValues.put("token", this.field_token);
    }
    if (this.eFm) {
      localContentValues.put("username", this.field_username);
    }
    if (this.fyW) {
      localContentValues.put("uin", Integer.valueOf(this.field_uin));
    }
    if (this.fnz) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.hp
 * JD-Core Version:    0.7.0.1
 */