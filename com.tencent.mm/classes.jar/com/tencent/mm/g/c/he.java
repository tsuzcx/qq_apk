package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class he
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFs;
  private static final int ekU = "createTime".hashCode();
  private static final int emY;
  private static final int fhg = "RecordId".hashCode();
  private static final int fhh = "AppId".hashCode();
  private static final int fhi = "AppName".hashCode();
  private static final int fhj;
  private static final int fhk;
  private static final int fhl;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFk;
  private boolean ekx;
  private boolean emT;
  private boolean fha;
  private boolean fhb;
  private boolean fhc;
  private boolean fhd;
  private boolean fhe;
  private boolean fhf;
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
    eFs = "UserName".hashCode();
    fhj = "IconUrl".hashCode();
    fhk = "BriefIntro".hashCode();
    fhl = "isSync".hashCode();
    emY = "debugType".hashCode();
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
      if (fhg != k) {
        break label65;
      }
      this.field_RecordId = paramCursor.getString(i);
      this.fha = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fhh == k)
      {
        this.field_AppId = paramCursor.getString(i);
      }
      else if (fhi == k)
      {
        this.field_AppName = paramCursor.getString(i);
      }
      else if (eFs == k)
      {
        this.field_UserName = paramCursor.getString(i);
      }
      else if (fhj == k)
      {
        this.field_IconUrl = paramCursor.getString(i);
      }
      else if (fhk == k)
      {
        this.field_BriefIntro = paramCursor.getString(i);
      }
      else
      {
        if (fhl == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSync = bool;
            break;
          }
        }
        if (emY == k) {
          this.field_debugType = paramCursor.getInt(i);
        } else if (ekU == k) {
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
    if (this.fha) {
      localContentValues.put("RecordId", this.field_RecordId);
    }
    if (this.fhb) {
      localContentValues.put("AppId", this.field_AppId);
    }
    if (this.fhc) {
      localContentValues.put("AppName", this.field_AppName);
    }
    if (this.eFk) {
      localContentValues.put("UserName", this.field_UserName);
    }
    if (this.fhd) {
      localContentValues.put("IconUrl", this.field_IconUrl);
    }
    if (this.fhe) {
      localContentValues.put("BriefIntro", this.field_BriefIntro);
    }
    if (this.fhf) {
      localContentValues.put("isSync", Boolean.valueOf(this.field_isSync));
    }
    if (this.emT) {
      localContentValues.put("debugType", Integer.valueOf(this.field_debugType));
    }
    if (this.ekx) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.he
 * JD-Core Version:    0.7.0.1
 */