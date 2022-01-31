package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fn
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int csv;
  private static final int cuz;
  private static final int dgh = "RecordId".hashCode();
  private static final int dgi = "AppId".hashCode();
  private static final int dgj = "AppName".hashCode();
  private static final int dgk = "UserName".hashCode();
  private static final int dgl = "IconUrl".hashCode();
  private static final int dgm = "BriefIntro".hashCode();
  private static final int dgn = "isSync".hashCode();
  private boolean crX = true;
  private boolean cut = true;
  private boolean dga = true;
  private boolean dgb = true;
  private boolean dgc = true;
  private boolean dgd = true;
  private boolean dge = true;
  private boolean dgf = true;
  private boolean dgg = true;
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
    cuz = "debugType".hashCode();
    csv = "createTime".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (dgh != k) {
        break label65;
      }
      this.field_RecordId = paramCursor.getString(i);
      this.dga = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dgi == k)
      {
        this.field_AppId = paramCursor.getString(i);
      }
      else if (dgj == k)
      {
        this.field_AppName = paramCursor.getString(i);
      }
      else if (dgk == k)
      {
        this.field_UserName = paramCursor.getString(i);
      }
      else if (dgl == k)
      {
        this.field_IconUrl = paramCursor.getString(i);
      }
      else if (dgm == k)
      {
        this.field_BriefIntro = paramCursor.getString(i);
      }
      else
      {
        if (dgn == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSync = bool;
            break;
          }
        }
        if (cuz == k) {
          this.field_debugType = paramCursor.getInt(i);
        } else if (csv == k) {
          this.field_createTime = paramCursor.getLong(i);
        } else if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dga) {
      localContentValues.put("RecordId", this.field_RecordId);
    }
    if (this.dgb) {
      localContentValues.put("AppId", this.field_AppId);
    }
    if (this.dgc) {
      localContentValues.put("AppName", this.field_AppName);
    }
    if (this.dgd) {
      localContentValues.put("UserName", this.field_UserName);
    }
    if (this.dge) {
      localContentValues.put("IconUrl", this.field_IconUrl);
    }
    if (this.dgf) {
      localContentValues.put("BriefIntro", this.field_BriefIntro);
    }
    if (this.dgg) {
      localContentValues.put("isSync", Boolean.valueOf(this.field_isSync));
    }
    if (this.cut) {
      localContentValues.put("debugType", Integer.valueOf(this.field_debugType));
    }
    if (this.crX) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.c.fn
 * JD-Core Version:    0.7.0.1
 */