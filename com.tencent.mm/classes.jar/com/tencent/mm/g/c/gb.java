package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gb
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dXA;
  private static final int dXv = "RecordId".hashCode();
  private static final int dXw = "AppId".hashCode();
  private static final int dXx = "AppName".hashCode();
  private static final int dXy;
  private static final int dXz;
  private static final int dgM = "createTime".hashCode();
  private static final int diF;
  private static final int dyI = "UserName".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dXp = true;
  private boolean dXq = true;
  private boolean dXr = true;
  private boolean dXs = true;
  private boolean dXt = true;
  private boolean dXu = true;
  private boolean dgp = true;
  private boolean diz = true;
  private boolean dyA = true;
  public String field_AppId;
  public String field_AppName;
  public String field_BriefIntro;
  public String field_IconUrl;
  public String field_RecordId;
  public String field_UserName;
  public long field_createTime;
  public int field_debugType;
  public boolean field_isSync;
  
  static
  {
    dXy = "IconUrl".hashCode();
    dXz = "BriefIntro".hashCode();
    dXA = "isSync".hashCode();
    diF = "debugType".hashCode();
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
      if (dXv != k) {
        break label65;
      }
      this.field_RecordId = paramCursor.getString(i);
      this.dXp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dXw == k)
      {
        this.field_AppId = paramCursor.getString(i);
      }
      else if (dXx == k)
      {
        this.field_AppName = paramCursor.getString(i);
      }
      else if (dyI == k)
      {
        this.field_UserName = paramCursor.getString(i);
      }
      else if (dXy == k)
      {
        this.field_IconUrl = paramCursor.getString(i);
      }
      else if (dXz == k)
      {
        this.field_BriefIntro = paramCursor.getString(i);
      }
      else
      {
        if (dXA == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSync = bool;
            break;
          }
        }
        if (diF == k) {
          this.field_debugType = paramCursor.getInt(i);
        } else if (dgM == k) {
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
    if (this.dXp) {
      localContentValues.put("RecordId", this.field_RecordId);
    }
    if (this.dXq) {
      localContentValues.put("AppId", this.field_AppId);
    }
    if (this.dXr) {
      localContentValues.put("AppName", this.field_AppName);
    }
    if (this.dyA) {
      localContentValues.put("UserName", this.field_UserName);
    }
    if (this.dXs) {
      localContentValues.put("IconUrl", this.field_IconUrl);
    }
    if (this.dXt) {
      localContentValues.put("BriefIntro", this.field_BriefIntro);
    }
    if (this.dXu) {
      localContentValues.put("isSync", Boolean.valueOf(this.field_isSync));
    }
    if (this.diz) {
      localContentValues.put("debugType", Integer.valueOf(this.field_debugType));
    }
    if (this.dgp) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.gb
 * JD-Core Version:    0.7.0.1
 */