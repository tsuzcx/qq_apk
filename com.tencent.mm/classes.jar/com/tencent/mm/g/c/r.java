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
  private static final int elJ = "appId".hashCode();
  private static final int emH = "prefetchUpdateTime".hashCode();
  private static final int eme = "username".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean els = true;
  private boolean emG = true;
  private boolean emb = true;
  public String field_appId;
  public long field_prefetchUpdateTime;
  public String field_username;
  
  public static c.a So()
  {
    c.a locala = new c.a();
    locala.EYt = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "username";
    locala.EYv.put("username", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" username TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "username";
    locala.columns[1] = "appId";
    locala.EYv.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "prefetchUpdateTime";
    locala.EYv.put("prefetchUpdateTime", "LONG");
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
      if (eme != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.emb = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (elJ == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (emH == k) {
        this.field_prefetchUpdateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.emb) {
      localContentValues.put("username", this.field_username);
    }
    if (this.els) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.emG) {
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