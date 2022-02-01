package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ck
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FinderSessionInfo_sessionId_index ON FinderSessionInfo(sessionId)", "CREATE INDEX IF NOT EXISTS FinderSessionInfo_talker_index ON FinderSessionInfo(talker)", "CREATE INDEX IF NOT EXISTS FinderSessionInfo_type_index ON FinderSessionInfo(type)" };
  private static final int eFq;
  private static final int eLf;
  private static final int eVL = "sessionId".hashCode();
  private static final int eYv = "actionPermission".hashCode();
  private static final int fag;
  private static final int fah = "rejectMsg".hashCode();
  private static final int fai = "disableSendMsg".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eFn = true;
  private boolean eKS = true;
  private boolean eVx = true;
  private boolean eYr = true;
  private boolean fad = true;
  private boolean fae = true;
  private boolean faf = true;
  public int field_actionPermission;
  public int field_disableSendMsg;
  public int field_rejectMsg;
  public String field_selfUsername;
  public String field_sessionId;
  public String field_talker;
  public int field_type;
  public long field_updateTime;
  
  static
  {
    eLf = "talker".hashCode();
    eFq = "updateTime".hashCode();
    fag = "selfUsername".hashCode();
    type_HASHCODE = "type".hashCode();
  }
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[8];
    locala.columns = new String[9];
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
    locala.columns[2] = "updateTime";
    locala.IhC.put("updateTime", "LONG default '0' ");
    localStringBuilder.append(" updateTime LONG default '0' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "selfUsername";
    locala.IhC.put("selfUsername", "TEXT default '' ");
    localStringBuilder.append(" selfUsername TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[4] = "type";
    locala.IhC.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "actionPermission";
    locala.IhC.put("actionPermission", "INTEGER");
    localStringBuilder.append(" actionPermission INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "rejectMsg";
    locala.IhC.put("rejectMsg", "INTEGER");
    localStringBuilder.append(" rejectMsg INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "disableSendMsg";
    locala.IhC.put("disableSendMsg", "INTEGER");
    localStringBuilder.append(" disableSendMsg INTEGER");
    locala.columns[8] = "rowid";
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
      } else if (eFq == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (fag == k) {
        this.field_selfUsername = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eYv == k) {
        this.field_actionPermission = paramCursor.getInt(i);
      } else if (fah == k) {
        this.field_rejectMsg = paramCursor.getInt(i);
      } else if (fai == k) {
        this.field_disableSendMsg = paramCursor.getInt(i);
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
    if (this.eFn) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.field_selfUsername == null) {
      this.field_selfUsername = "";
    }
    if (this.fad) {
      localContentValues.put("selfUsername", this.field_selfUsername);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eYr) {
      localContentValues.put("actionPermission", Integer.valueOf(this.field_actionPermission));
    }
    if (this.fae) {
      localContentValues.put("rejectMsg", Integer.valueOf(this.field_rejectMsg));
    }
    if (this.faf) {
      localContentValues.put("disableSendMsg", Integer.valueOf(this.field_disableSendMsg));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ck
 * JD-Core Version:    0.7.0.1
 */