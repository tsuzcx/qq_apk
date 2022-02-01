package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cs
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEf;
  private static final int eZK;
  private static final int fbW = "uploadState".hashCode();
  private static final int fci = "taskId".hashCode();
  private static final int fcj;
  private static final int fck;
  private static final int fcl;
  private static final int fcm;
  private static final int fcn = "publishState".hashCode();
  private static final int fco = "compressImg".hashCode();
  private static final int fcp = "mixState".hashCode();
  private static final int fcq = "bgMixTaskId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDI = true;
  private boolean eZv = true;
  private boolean fbO = true;
  private boolean fbZ = true;
  private boolean fca = true;
  private boolean fcb = true;
  private boolean fcc = true;
  private boolean fcd = true;
  private boolean fce = true;
  private boolean fcf = true;
  private boolean fcg = true;
  private boolean fch = true;
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
    eEf = "createTime".hashCode();
    fcj = "publishSource".hashCode();
    eZK = "mediaType".hashCode();
    fck = "localIdList".hashCode();
    fcl = "mediaList".hashCode();
    fcm = "BusinessData".hashCode();
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
      if (fci != k) {
        break label65;
      }
      this.field_taskId = paramCursor.getString(i);
      this.fbZ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eEf == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else if (fcj == k)
      {
        this.field_publishSource = paramCursor.getInt(i);
      }
      else if (eZK == k)
      {
        this.field_mediaType = paramCursor.getInt(i);
      }
      else if (fck == k)
      {
        this.field_localIdList = paramCursor.getString(i);
      }
      else if (fcl == k)
      {
        this.field_mediaList = paramCursor.getString(i);
      }
      else if (fcm == k)
      {
        this.field_BusinessData = paramCursor.getString(i);
      }
      else if (fbW == k)
      {
        this.field_uploadState = paramCursor.getInt(i);
      }
      else if (fcn == k)
      {
        this.field_publishState = paramCursor.getInt(i);
      }
      else
      {
        if (fco == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_compressImg = bool;
            break;
          }
        }
        if (fcp == k) {
          this.field_mixState = paramCursor.getInt(i);
        } else if (fcq == k) {
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
    if (this.fbZ) {
      localContentValues.put("taskId", this.field_taskId);
    }
    if (this.eDI) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.fca) {
      localContentValues.put("publishSource", Integer.valueOf(this.field_publishSource));
    }
    if (this.eZv) {
      localContentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
    }
    if (this.fcb) {
      localContentValues.put("localIdList", this.field_localIdList);
    }
    if (this.fcc) {
      localContentValues.put("mediaList", this.field_mediaList);
    }
    if (this.fcd) {
      localContentValues.put("BusinessData", this.field_BusinessData);
    }
    if (this.fbO) {
      localContentValues.put("uploadState", Integer.valueOf(this.field_uploadState));
    }
    if (this.fce) {
      localContentValues.put("publishState", Integer.valueOf(this.field_publishState));
    }
    if (this.fcf) {
      localContentValues.put("compressImg", Boolean.valueOf(this.field_compressImg));
    }
    if (this.fcg) {
      localContentValues.put("mixState", Integer.valueOf(this.field_mixState));
    }
    if (this.fch) {
      localContentValues.put("bgMixTaskId", this.field_bgMixTaskId);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.cs
 * JD-Core Version:    0.7.0.1
 */