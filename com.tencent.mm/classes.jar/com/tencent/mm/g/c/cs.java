package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cs
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFO;
  private static final int fby;
  private static final int fdL = "uploadState".hashCode();
  private static final int fdX = "taskId".hashCode();
  private static final int fdY;
  private static final int fdZ;
  private static final int fea;
  private static final int feb;
  private static final int fec = "publishState".hashCode();
  private static final int fed = "compressImg".hashCode();
  private static final int fee = "mixState".hashCode();
  private static final int fef = "bgMixTaskId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFr = true;
  private boolean fbi = true;
  private boolean fdD = true;
  private boolean fdO = true;
  private boolean fdP = true;
  private boolean fdQ = true;
  private boolean fdR = true;
  private boolean fdS = true;
  private boolean fdT = true;
  private boolean fdU = true;
  private boolean fdV = true;
  private boolean fdW = true;
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
    eFO = "createTime".hashCode();
    fdY = "publishSource".hashCode();
    fby = "mediaType".hashCode();
    fdZ = "localIdList".hashCode();
    fea = "mediaList".hashCode();
    feb = "BusinessData".hashCode();
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
      if (fdX != k) {
        break label65;
      }
      this.field_taskId = paramCursor.getString(i);
      this.fdO = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eFO == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else if (fdY == k)
      {
        this.field_publishSource = paramCursor.getInt(i);
      }
      else if (fby == k)
      {
        this.field_mediaType = paramCursor.getInt(i);
      }
      else if (fdZ == k)
      {
        this.field_localIdList = paramCursor.getString(i);
      }
      else if (fea == k)
      {
        this.field_mediaList = paramCursor.getString(i);
      }
      else if (feb == k)
      {
        this.field_BusinessData = paramCursor.getString(i);
      }
      else if (fdL == k)
      {
        this.field_uploadState = paramCursor.getInt(i);
      }
      else if (fec == k)
      {
        this.field_publishState = paramCursor.getInt(i);
      }
      else
      {
        if (fed == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_compressImg = bool;
            break;
          }
        }
        if (fee == k) {
          this.field_mixState = paramCursor.getInt(i);
        } else if (fef == k) {
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
    if (this.fdO) {
      localContentValues.put("taskId", this.field_taskId);
    }
    if (this.eFr) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.fdP) {
      localContentValues.put("publishSource", Integer.valueOf(this.field_publishSource));
    }
    if (this.fbi) {
      localContentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
    }
    if (this.fdQ) {
      localContentValues.put("localIdList", this.field_localIdList);
    }
    if (this.fdR) {
      localContentValues.put("mediaList", this.field_mediaList);
    }
    if (this.fdS) {
      localContentValues.put("BusinessData", this.field_BusinessData);
    }
    if (this.fdD) {
      localContentValues.put("uploadState", Integer.valueOf(this.field_uploadState));
    }
    if (this.fdT) {
      localContentValues.put("publishState", Integer.valueOf(this.field_publishState));
    }
    if (this.fdU) {
      localContentValues.put("compressImg", Boolean.valueOf(this.field_compressImg));
    }
    if (this.fdV) {
      localContentValues.put("mixState", Integer.valueOf(this.field_mixState));
    }
    if (this.fdW) {
      localContentValues.put("bgMixTaskId", this.field_bgMixTaskId);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.cs
 * JD-Core Version:    0.7.0.1
 */