package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class hb
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eSc = "appid".hashCode();
  private static final int eme;
  private static final int emp = "token".hashCode();
  private static final int feb;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eSa = true;
  private boolean emb = true;
  private boolean emo = true;
  private boolean fdw = true;
  public String field_appid;
  public String field_token;
  public int field_uin;
  public String field_username;
  
  static
  {
    eme = "username".hashCode();
    feb = "uin".hashCode();
  }
  
  public static c.a So()
  {
    c.a locala = new c.a();
    locala.EYt = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "token";
    locala.EYv.put("token", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" token TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "token";
    locala.columns[1] = "username";
    locala.EYv.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "uin";
    locala.EYv.put("uin", "INTEGER");
    localStringBuilder.append(" uin INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "appid";
    locala.EYv.put("appid", "TEXT");
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
      if (emp != k) {
        break label65;
      }
      this.field_token = paramCursor.getString(i);
      this.emo = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eme == k) {
        this.field_username = paramCursor.getString(i);
      } else if (feb == k) {
        this.field_uin = paramCursor.getInt(i);
      } else if (eSc == k) {
        this.field_appid = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.emo) {
      localContentValues.put("token", this.field_token);
    }
    if (this.emb) {
      localContentValues.put("username", this.field_username);
    }
    if (this.fdw) {
      localContentValues.put("uin", Integer.valueOf(this.field_uin));
    }
    if (this.eSa) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.hb
 * JD-Core Version:    0.7.0.1
 */