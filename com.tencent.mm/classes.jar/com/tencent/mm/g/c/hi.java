package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hi
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eIk;
  private static final int emY = "createTime".hashCode();
  private static final int epe;
  private static final int fkB = "RecordId".hashCode();
  private static final int fkC = "AppId".hashCode();
  private static final int fkD = "AppName".hashCode();
  private static final int fkE;
  private static final int fkF;
  private static final int fkG;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eIc;
  private boolean emB;
  private boolean eoZ;
  public String field_AppId;
  public String field_AppName;
  public String field_BriefIntro;
  public String field_IconUrl;
  public String field_RecordId;
  public String field_UserName;
  public long field_createTime;
  public int field_debugType;
  public boolean field_isSync;
  private boolean fkA;
  private boolean fkv;
  private boolean fkw;
  private boolean fkx;
  private boolean fky;
  private boolean fkz;
  
  static
  {
    eIk = "UserName".hashCode();
    fkE = "IconUrl".hashCode();
    fkF = "BriefIntro".hashCode();
    fkG = "isSync".hashCode();
    epe = "debugType".hashCode();
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (fkB != k) {
        break label65;
      }
      this.field_RecordId = paramCursor.getString(i);
      this.fkv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fkC == k)
      {
        this.field_AppId = paramCursor.getString(i);
      }
      else if (fkD == k)
      {
        this.field_AppName = paramCursor.getString(i);
      }
      else if (eIk == k)
      {
        this.field_UserName = paramCursor.getString(i);
      }
      else if (fkE == k)
      {
        this.field_IconUrl = paramCursor.getString(i);
      }
      else if (fkF == k)
      {
        this.field_BriefIntro = paramCursor.getString(i);
      }
      else
      {
        if (fkG == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSync = bool;
            break;
          }
        }
        if (epe == k) {
          this.field_debugType = paramCursor.getInt(i);
        } else if (emY == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fkv) {
      localContentValues.put("RecordId", this.field_RecordId);
    }
    if (this.fkw) {
      localContentValues.put("AppId", this.field_AppId);
    }
    if (this.fkx) {
      localContentValues.put("AppName", this.field_AppName);
    }
    if (this.eIc) {
      localContentValues.put("UserName", this.field_UserName);
    }
    if (this.fky) {
      localContentValues.put("IconUrl", this.field_IconUrl);
    }
    if (this.fkz) {
      localContentValues.put("BriefIntro", this.field_BriefIntro);
    }
    if (this.fkA) {
      localContentValues.put("isSync", Boolean.valueOf(this.field_isSync));
    }
    if (this.eoZ) {
      localContentValues.put("debugType", Integer.valueOf(this.field_debugType));
    }
    if (this.emB) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.hi
 * JD-Core Version:    0.7.0.1
 */