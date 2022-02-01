package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cn
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eHH;
  private static final int eJO = "uploadState".hashCode();
  private static final int eKa = "taskId".hashCode();
  private static final int eKb;
  private static final int eKc;
  private static final int eKd;
  private static final int eKe;
  private static final int eKf = "publishState".hashCode();
  private static final int eKg = "compressImg".hashCode();
  private static final int eKh = "mixState".hashCode();
  private static final int eKi = "bgMixTaskId".hashCode();
  private static final int emY = "createTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eHv = true;
  private boolean eJF = true;
  private boolean eJR = true;
  private boolean eJS = true;
  private boolean eJT = true;
  private boolean eJU = true;
  private boolean eJV = true;
  private boolean eJW = true;
  private boolean eJX = true;
  private boolean eJY = true;
  private boolean eJZ = true;
  private boolean emB = true;
  public String field_BusinessData;
  public String field_bgMixTaskId;
  public boolean field_compressImg;
  public long field_createTime;
  public String field_localIdList;
  public String field_mediaList;
  public int field_mediaType;
  public int field_mixState;
  public int field_publishSource;
  public int field_publishState;
  public String field_taskId;
  public int field_uploadState;
  
  static
  {
    eKb = "publishSource".hashCode();
    eHH = "mediaType".hashCode();
    eKc = "localIdList".hashCode();
    eKd = "mediaList".hashCode();
    eKe = "BusinessData".hashCode();
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
      if (eKa != k) {
        break label65;
      }
      this.field_taskId = paramCursor.getString(i);
      this.eJR = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (emY == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else if (eKb == k)
      {
        this.field_publishSource = paramCursor.getInt(i);
      }
      else if (eHH == k)
      {
        this.field_mediaType = paramCursor.getInt(i);
      }
      else if (eKc == k)
      {
        this.field_localIdList = paramCursor.getString(i);
      }
      else if (eKd == k)
      {
        this.field_mediaList = paramCursor.getString(i);
      }
      else if (eKe == k)
      {
        this.field_BusinessData = paramCursor.getString(i);
      }
      else if (eJO == k)
      {
        this.field_uploadState = paramCursor.getInt(i);
      }
      else if (eKf == k)
      {
        this.field_publishState = paramCursor.getInt(i);
      }
      else
      {
        if (eKg == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_compressImg = bool;
            break;
          }
        }
        if (eKh == k) {
          this.field_mixState = paramCursor.getInt(i);
        } else if (eKi == k) {
          this.field_bgMixTaskId = paramCursor.getString(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eJR) {
      localContentValues.put("taskId", this.field_taskId);
    }
    if (this.emB) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.eJS) {
      localContentValues.put("publishSource", Integer.valueOf(this.field_publishSource));
    }
    if (this.eHv) {
      localContentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
    }
    if (this.eJT) {
      localContentValues.put("localIdList", this.field_localIdList);
    }
    if (this.eJU) {
      localContentValues.put("mediaList", this.field_mediaList);
    }
    if (this.eJV) {
      localContentValues.put("BusinessData", this.field_BusinessData);
    }
    if (this.eJF) {
      localContentValues.put("uploadState", Integer.valueOf(this.field_uploadState));
    }
    if (this.eJW) {
      localContentValues.put("publishState", Integer.valueOf(this.field_publishState));
    }
    if (this.eJX) {
      localContentValues.put("compressImg", Boolean.valueOf(this.field_compressImg));
    }
    if (this.eJY) {
      localContentValues.put("mixState", Integer.valueOf(this.field_mixState));
    }
    if (this.eJZ) {
      localContentValues.put("bgMixTaskId", this.field_bgMixTaskId);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.cn
 * JD-Core Version:    0.7.0.1
 */