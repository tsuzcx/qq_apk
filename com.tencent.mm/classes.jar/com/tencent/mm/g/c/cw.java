package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cw
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS GameLifeSessionInfo_sessionId_index ON GameLifeSessionInfo(sessionId)", "CREATE INDEX IF NOT EXISTS GameLifeSessionInfo_talker_index ON GameLifeSessionInfo(talker)", "CREATE INDEX IF NOT EXISTS GameLifeSessionInfo_selfUsername_index ON GameLifeSessionInfo(selfUserName)" };
  private static final int eLf = "talker".hashCode();
  private static final int eVL = "sessionId".hashCode();
  private static final int fcB = "selfUserName".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eKS = true;
  private boolean eVx = true;
  private boolean fcz = true;
  public String field_selfUserName;
  public String field_sessionId;
  public String field_talker;
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[3];
    locala.columns = new String[4];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "sessionId";
    locala.IhC.put("sessionId", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" sessionId TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "sessionId";
    locala.columns[1] = "talker";
    locala.IhC.put("talker", "TEXT default '' ");
    localStringBuilder.append(" talker TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "selfUserName";
    locala.IhC.put("selfUserName", "TEXT default '' ");
    localStringBuilder.append(" selfUserName TEXT default '' ");
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
      if (eVL != k) {
        break label65;
      }
      this.field_sessionId = paramCursor.getString(i);
      this.eVx = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eLf == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (fcB == k) {
        this.field_selfUserName = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_sessionId == null) {
      this.field_sessionId = "";
    }
    if (this.eVx) {
      localContentValues.put("sessionId", this.field_sessionId);
    }
    if (this.field_talker == null) {
      this.field_talker = "";
    }
    if (this.eKS) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_selfUserName == null) {
      this.field_selfUserName = "";
    }
    if (this.fcz) {
      localContentValues.put("selfUserName", this.field_selfUserName);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.cw
 * JD-Core Version:    0.7.0.1
 */