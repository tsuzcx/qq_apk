package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class r
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS AppBrandPrefetchWxaAttrsMarkTableAppIdIndex ON AppBrandPrefetchWxaAttrsMarkTable(appId)" };
  private static final int eEU = "appId".hashCode();
  private static final int eFW = "prefetchUpdateTime".hashCode();
  private static final int eFp = "username".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eED = true;
  private boolean eFV = true;
  private boolean eFm = true;
  public String field_appId;
  public long field_prefetchUpdateTime;
  public String field_username;
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.IhC.put("username", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" username TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "username";
    locala.columns[1] = "appId";
    locala.IhC.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "prefetchUpdateTime";
    locala.IhC.put("prefetchUpdateTime", "LONG");
    localStringBuilder.append(" prefetchUpdateTime LONG");
    locala.columns[3] = "rowid";
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
      if (eFp != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.eFm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eEU == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (eFW == k) {
        this.field_prefetchUpdateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eFm) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eED) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eFV) {
      localContentValues.put("prefetchUpdateTime", Long.valueOf(this.field_prefetchUpdateTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.r
 * JD-Core Version:    0.7.0.1
 */