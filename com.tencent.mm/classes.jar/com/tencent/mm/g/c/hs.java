package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hs
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEf = "createTime".hashCode();
  private static final int eGn;
  private static final int fCI = "RecordId".hashCode();
  private static final int fCJ = "AppId".hashCode();
  private static final int fCK = "AppName".hashCode();
  private static final int fCL;
  private static final int fCM;
  private static final int fCN;
  private static final int faw = "UserName".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDI;
  private boolean eGi;
  private boolean fCC;
  private boolean fCD;
  private boolean fCE;
  private boolean fCF;
  private boolean fCG;
  private boolean fCH;
  private boolean fao;
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
    fCL = "IconUrl".hashCode();
    fCM = "BriefIntro".hashCode();
    fCN = "isSync".hashCode();
    eGn = "debugType".hashCode();
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
      if (fCI != k) {
        break label65;
      }
      this.field_RecordId = paramCursor.getString(i);
      this.fCC = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fCJ == k)
      {
        this.field_AppId = paramCursor.getString(i);
      }
      else if (fCK == k)
      {
        this.field_AppName = paramCursor.getString(i);
      }
      else if (faw == k)
      {
        this.field_UserName = paramCursor.getString(i);
      }
      else if (fCL == k)
      {
        this.field_IconUrl = paramCursor.getString(i);
      }
      else if (fCM == k)
      {
        this.field_BriefIntro = paramCursor.getString(i);
      }
      else
      {
        if (fCN == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSync = bool;
            break;
          }
        }
        if (eGn == k) {
          this.field_debugType = paramCursor.getInt(i);
        } else if (eEf == k) {
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
    if (this.fCC) {
      localContentValues.put("RecordId", this.field_RecordId);
    }
    if (this.fCD) {
      localContentValues.put("AppId", this.field_AppId);
    }
    if (this.fCE) {
      localContentValues.put("AppName", this.field_AppName);
    }
    if (this.fao) {
      localContentValues.put("UserName", this.field_UserName);
    }
    if (this.fCF) {
      localContentValues.put("IconUrl", this.field_IconUrl);
    }
    if (this.fCG) {
      localContentValues.put("BriefIntro", this.field_BriefIntro);
    }
    if (this.fCH) {
      localContentValues.put("isSync", Boolean.valueOf(this.field_isSync));
    }
    if (this.eGi) {
      localContentValues.put("debugType", Integer.valueOf(this.field_debugType));
    }
    if (this.eDI) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.hs
 * JD-Core Version:    0.7.0.1
 */