package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ig
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int createTime_HASHCODE = "createTime".hashCode();
  private static final int fGE;
  private static final int fly;
  private static final int gjW = "RecordId".hashCode();
  private static final int gjX = "AppId".hashCode();
  private static final int gjY = "AppName".hashCode();
  private static final int gjZ;
  private static final int gka;
  private static final int gkb;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime;
  private boolean fGw;
  public String field_AppId;
  public String field_AppName;
  public String field_BriefIntro;
  public String field_IconUrl;
  public String field_RecordId;
  public String field_UserName;
  public long field_createTime;
  public int field_debugType;
  public boolean field_isSync;
  private boolean flt;
  private boolean gjQ;
  private boolean gjR;
  private boolean gjS;
  private boolean gjT;
  private boolean gjU;
  private boolean gjV;
  
  static
  {
    fGE = "UserName".hashCode();
    gjZ = "IconUrl".hashCode();
    gka = "BriefIntro".hashCode();
    gkb = "isSync".hashCode();
    fly = "debugType".hashCode();
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
      if (gjW != k) {
        break label65;
      }
      this.field_RecordId = paramCursor.getString(i);
      this.gjQ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (gjX == k)
      {
        this.field_AppId = paramCursor.getString(i);
      }
      else if (gjY == k)
      {
        this.field_AppName = paramCursor.getString(i);
      }
      else if (fGE == k)
      {
        this.field_UserName = paramCursor.getString(i);
      }
      else if (gjZ == k)
      {
        this.field_IconUrl = paramCursor.getString(i);
      }
      else if (gka == k)
      {
        this.field_BriefIntro = paramCursor.getString(i);
      }
      else
      {
        if (gkb == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSync = bool;
            break;
          }
        }
        if (fly == k) {
          this.field_debugType = paramCursor.getInt(i);
        } else if (createTime_HASHCODE == k) {
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
    if (this.gjQ) {
      localContentValues.put("RecordId", this.field_RecordId);
    }
    if (this.gjR) {
      localContentValues.put("AppId", this.field_AppId);
    }
    if (this.gjS) {
      localContentValues.put("AppName", this.field_AppName);
    }
    if (this.fGw) {
      localContentValues.put("UserName", this.field_UserName);
    }
    if (this.gjT) {
      localContentValues.put("IconUrl", this.field_IconUrl);
    }
    if (this.gjU) {
      localContentValues.put("BriefIntro", this.field_BriefIntro);
    }
    if (this.gjV) {
      localContentValues.put("isSync", Boolean.valueOf(this.field_isSync));
    }
    if (this.flt) {
      localContentValues.put("debugType", Integer.valueOf(this.field_debugType));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ig
 * JD-Core Version:    0.7.0.1
 */