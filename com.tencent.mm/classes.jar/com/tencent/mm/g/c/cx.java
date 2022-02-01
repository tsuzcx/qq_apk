package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class cx
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int createTime_HASHCODE;
  private static final int fFE;
  private static final int fIc = "uploadState".hashCode();
  private static final int fIp = "taskId".hashCode();
  private static final int fIq;
  private static final int fIr;
  private static final int fIs;
  private static final int fIt;
  private static final int fIu = "publishState".hashCode();
  private static final int fIv = "compressImg".hashCode();
  private static final int fIw = "mixState".hashCode();
  private static final int fIx = "bgMixTaskId".hashCode();
  private static final int fIy = "sourceSceneId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
  private boolean fFn = true;
  private boolean fHU = true;
  private boolean fIf = true;
  private boolean fIg = true;
  private boolean fIh = true;
  private boolean fIi = true;
  private boolean fIj = true;
  private boolean fIk = true;
  private boolean fIl = true;
  private boolean fIm = true;
  private boolean fIn = true;
  private boolean fIo = true;
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
  public int field_sourceSceneId;
  public String field_taskId;
  public int field_uploadState;
  
  static
  {
    createTime_HASHCODE = "createTime".hashCode();
    fIq = "publishSource".hashCode();
    fFE = "mediaType".hashCode();
    fIr = "localIdList".hashCode();
    fIs = "mediaList".hashCode();
    fIt = "BusinessData".hashCode();
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
      if (fIp != k) {
        break label65;
      }
      this.field_taskId = paramCursor.getString(i);
      this.fIf = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (createTime_HASHCODE == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else if (fIq == k)
      {
        this.field_publishSource = paramCursor.getInt(i);
      }
      else if (fFE == k)
      {
        this.field_mediaType = paramCursor.getInt(i);
      }
      else if (fIr == k)
      {
        this.field_localIdList = paramCursor.getString(i);
      }
      else if (fIs == k)
      {
        this.field_mediaList = paramCursor.getString(i);
      }
      else if (fIt == k)
      {
        this.field_BusinessData = paramCursor.getString(i);
      }
      else if (fIc == k)
      {
        this.field_uploadState = paramCursor.getInt(i);
      }
      else if (fIu == k)
      {
        this.field_publishState = paramCursor.getInt(i);
      }
      else
      {
        if (fIv == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_compressImg = bool;
            break;
          }
        }
        if (fIw == k) {
          this.field_mixState = paramCursor.getInt(i);
        } else if (fIx == k) {
          this.field_bgMixTaskId = paramCursor.getString(i);
        } else if (fIy == k) {
          this.field_sourceSceneId = paramCursor.getInt(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fIf) {
      localContentValues.put("taskId", this.field_taskId);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.fIg) {
      localContentValues.put("publishSource", Integer.valueOf(this.field_publishSource));
    }
    if (this.fFn) {
      localContentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
    }
    if (this.fIh) {
      localContentValues.put("localIdList", this.field_localIdList);
    }
    if (this.fIi) {
      localContentValues.put("mediaList", this.field_mediaList);
    }
    if (this.fIj) {
      localContentValues.put("BusinessData", this.field_BusinessData);
    }
    if (this.fHU) {
      localContentValues.put("uploadState", Integer.valueOf(this.field_uploadState));
    }
    if (this.fIk) {
      localContentValues.put("publishState", Integer.valueOf(this.field_publishState));
    }
    if (this.fIl) {
      localContentValues.put("compressImg", Boolean.valueOf(this.field_compressImg));
    }
    if (this.fIm) {
      localContentValues.put("mixState", Integer.valueOf(this.field_mixState));
    }
    if (this.fIn) {
      localContentValues.put("bgMixTaskId", this.field_bgMixTaskId);
    }
    if (this.fIo) {
      localContentValues.put("sourceSceneId", Integer.valueOf(this.field_sourceSceneId));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.cx
 * JD-Core Version:    0.7.0.1
 */