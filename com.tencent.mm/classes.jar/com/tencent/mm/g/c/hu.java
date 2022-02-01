package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hu
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFO = "createTime".hashCode();
  private static final int eHW;
  private static final int fEM = "RecordId".hashCode();
  private static final int fEN = "AppId".hashCode();
  private static final int fEO = "AppName".hashCode();
  private static final int fEP;
  private static final int fEQ;
  private static final int fER;
  private static final int fcl = "UserName".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFr;
  private boolean eHR;
  private boolean fEG;
  private boolean fEH;
  private boolean fEI;
  private boolean fEJ;
  private boolean fEK;
  private boolean fEL;
  private boolean fcd;
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
    fEP = "IconUrl".hashCode();
    fEQ = "BriefIntro".hashCode();
    fER = "isSync".hashCode();
    eHW = "debugType".hashCode();
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
      if (fEM != k) {
        break label65;
      }
      this.field_RecordId = paramCursor.getString(i);
      this.fEG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fEN == k)
      {
        this.field_AppId = paramCursor.getString(i);
      }
      else if (fEO == k)
      {
        this.field_AppName = paramCursor.getString(i);
      }
      else if (fcl == k)
      {
        this.field_UserName = paramCursor.getString(i);
      }
      else if (fEP == k)
      {
        this.field_IconUrl = paramCursor.getString(i);
      }
      else if (fEQ == k)
      {
        this.field_BriefIntro = paramCursor.getString(i);
      }
      else
      {
        if (fER == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSync = bool;
            break;
          }
        }
        if (eHW == k) {
          this.field_debugType = paramCursor.getInt(i);
        } else if (eFO == k) {
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
    if (this.fEG) {
      localContentValues.put("RecordId", this.field_RecordId);
    }
    if (this.fEH) {
      localContentValues.put("AppId", this.field_AppId);
    }
    if (this.fEI) {
      localContentValues.put("AppName", this.field_AppName);
    }
    if (this.fcd) {
      localContentValues.put("UserName", this.field_UserName);
    }
    if (this.fEJ) {
      localContentValues.put("IconUrl", this.field_IconUrl);
    }
    if (this.fEK) {
      localContentValues.put("BriefIntro", this.field_BriefIntro);
    }
    if (this.fEL) {
      localContentValues.put("isSync", Boolean.valueOf(this.field_isSync));
    }
    if (this.eHR) {
      localContentValues.put("debugType", Integer.valueOf(this.field_debugType));
    }
    if (this.eFr) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.hu
 * JD-Core Version:    0.7.0.1
 */