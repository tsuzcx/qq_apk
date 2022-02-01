package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cl
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEW;
  private static final int eGW = "uploadState".hashCode();
  private static final int eHi = "taskId".hashCode();
  private static final int eHj;
  private static final int eHk;
  private static final int eHl;
  private static final int eHm;
  private static final int eHn = "publishState".hashCode();
  private static final int eHo = "compressImg".hashCode();
  private static final int eHp = "mixState".hashCode();
  private static final int eHq = "bgMixTaskId".hashCode();
  private static final int ekU = "createTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEN = true;
  private boolean eGN = true;
  private boolean eGZ = true;
  private boolean eHa = true;
  private boolean eHb = true;
  private boolean eHc = true;
  private boolean eHd = true;
  private boolean eHe = true;
  private boolean eHf = true;
  private boolean eHg = true;
  private boolean eHh = true;
  private boolean ekx = true;
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
    eHj = "publishSource".hashCode();
    eEW = "mediaType".hashCode();
    eHk = "localIdList".hashCode();
    eHl = "mediaList".hashCode();
    eHm = "BusinessData".hashCode();
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
      if (eHi != k) {
        break label65;
      }
      this.field_taskId = paramCursor.getString(i);
      this.eGZ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ekU == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else if (eHj == k)
      {
        this.field_publishSource = paramCursor.getInt(i);
      }
      else if (eEW == k)
      {
        this.field_mediaType = paramCursor.getInt(i);
      }
      else if (eHk == k)
      {
        this.field_localIdList = paramCursor.getString(i);
      }
      else if (eHl == k)
      {
        this.field_mediaList = paramCursor.getString(i);
      }
      else if (eHm == k)
      {
        this.field_BusinessData = paramCursor.getString(i);
      }
      else if (eGW == k)
      {
        this.field_uploadState = paramCursor.getInt(i);
      }
      else if (eHn == k)
      {
        this.field_publishState = paramCursor.getInt(i);
      }
      else
      {
        if (eHo == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_compressImg = bool;
            break;
          }
        }
        if (eHp == k) {
          this.field_mixState = paramCursor.getInt(i);
        } else if (eHq == k) {
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
    if (this.eGZ) {
      localContentValues.put("taskId", this.field_taskId);
    }
    if (this.ekx) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.eHa) {
      localContentValues.put("publishSource", Integer.valueOf(this.field_publishSource));
    }
    if (this.eEN) {
      localContentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
    }
    if (this.eHb) {
      localContentValues.put("localIdList", this.field_localIdList);
    }
    if (this.eHc) {
      localContentValues.put("mediaList", this.field_mediaList);
    }
    if (this.eHd) {
      localContentValues.put("BusinessData", this.field_BusinessData);
    }
    if (this.eGN) {
      localContentValues.put("uploadState", Integer.valueOf(this.field_uploadState));
    }
    if (this.eHe) {
      localContentValues.put("publishState", Integer.valueOf(this.field_publishState));
    }
    if (this.eHf) {
      localContentValues.put("compressImg", Boolean.valueOf(this.field_compressImg));
    }
    if (this.eHg) {
      localContentValues.put("mixState", Integer.valueOf(this.field_mixState));
    }
    if (this.eHh) {
      localContentValues.put("bgMixTaskId", this.field_bgMixTaskId);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cl
 * JD-Core Version:    0.7.0.1
 */