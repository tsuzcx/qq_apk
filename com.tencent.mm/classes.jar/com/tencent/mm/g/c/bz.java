package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bz
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dAA;
  private static final int dAB = "publishState".hashCode();
  private static final int dAC = "compressImg".hashCode();
  private static final int dAh;
  private static final int dAo;
  private static final int dAw = "taskId".hashCode();
  private static final int dAx;
  private static final int dAy;
  private static final int dAz;
  private static final int dgM = "createTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dAg = true;
  private boolean dAp = true;
  private boolean dAq = true;
  private boolean dAr = true;
  private boolean dAs = true;
  private boolean dAt = true;
  private boolean dAu = true;
  private boolean dAv = true;
  private boolean dgp = true;
  private boolean dzZ = true;
  public String field_BusinessData;
  public boolean field_compressImg;
  public long field_createTime;
  public String field_localIdList;
  public String field_mediaList;
  public int field_mediaType;
  public int field_publishSource;
  public int field_publishState;
  public String field_taskId;
  public int field_uploadState;
  
  static
  {
    dAx = "publishSource".hashCode();
    dAh = "mediaType".hashCode();
    dAy = "localIdList".hashCode();
    dAz = "mediaList".hashCode();
    dAA = "BusinessData".hashCode();
    dAo = "uploadState".hashCode();
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
      if (dAw != k) {
        break label65;
      }
      this.field_taskId = paramCursor.getString(i);
      this.dAp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dgM == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else if (dAx == k)
      {
        this.field_publishSource = paramCursor.getInt(i);
      }
      else if (dAh == k)
      {
        this.field_mediaType = paramCursor.getInt(i);
      }
      else if (dAy == k)
      {
        this.field_localIdList = paramCursor.getString(i);
      }
      else if (dAz == k)
      {
        this.field_mediaList = paramCursor.getString(i);
      }
      else if (dAA == k)
      {
        this.field_BusinessData = paramCursor.getString(i);
      }
      else if (dAo == k)
      {
        this.field_uploadState = paramCursor.getInt(i);
      }
      else if (dAB == k)
      {
        this.field_publishState = paramCursor.getInt(i);
      }
      else
      {
        if (dAC == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_compressImg = bool;
            break;
          }
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dAp) {
      localContentValues.put("taskId", this.field_taskId);
    }
    if (this.dgp) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.dAq) {
      localContentValues.put("publishSource", Integer.valueOf(this.field_publishSource));
    }
    if (this.dzZ) {
      localContentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
    }
    if (this.dAr) {
      localContentValues.put("localIdList", this.field_localIdList);
    }
    if (this.dAs) {
      localContentValues.put("mediaList", this.field_mediaList);
    }
    if (this.dAt) {
      localContentValues.put("BusinessData", this.field_BusinessData);
    }
    if (this.dAg) {
      localContentValues.put("uploadState", Integer.valueOf(this.field_uploadState));
    }
    if (this.dAu) {
      localContentValues.put("publishState", Integer.valueOf(this.field_publishState));
    }
    if (this.dAv) {
      localContentValues.put("compressImg", Boolean.valueOf(this.field_compressImg));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.bz
 * JD-Core Version:    0.7.0.1
 */