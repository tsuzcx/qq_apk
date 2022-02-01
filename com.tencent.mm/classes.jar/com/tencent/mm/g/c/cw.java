package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class cw
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fFE;
  private static final int fFe;
  private static final int fHX;
  private static final int fHY;
  private static final int fHZ = "isGif".hashCode();
  private static final int fIa = "mediaUrl".hashCode();
  private static final int fIb = "thumbPicUrl".hashCode();
  private static final int fIc = "uploadState".hashCode();
  private static final int fId = "hostTaskId".hashCode();
  private static final int fIe = "editFlag".hashCode();
  private static final int fkX;
  private static final int fkm;
  private static final int fsu;
  private static final int fyA;
  private static final int fyz;
  private static final int localId_HASHCODE = "localId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetlocalId = true;
  private boolean fES = true;
  private boolean fFn = true;
  private boolean fHP = true;
  private boolean fHQ = true;
  private boolean fHR = true;
  private boolean fHS = true;
  private boolean fHT = true;
  private boolean fHU = true;
  private boolean fHV = true;
  private boolean fHW = true;
  public String field_compressPath;
  public int field_duration;
  public int field_editFlag;
  public String field_filePath;
  public int field_height;
  public String field_hostTaskId;
  public boolean field_isGif;
  public String field_localId;
  public String field_mediaId;
  public int field_mediaType;
  public String field_mediaUrl;
  public long field_size;
  public String field_thumbPath;
  public String field_thumbPicUrl;
  public int field_uploadState;
  public int field_width;
  private boolean fjV = true;
  private boolean fkV = true;
  private boolean fsm = true;
  private boolean fxN = true;
  private boolean fxO = true;
  
  static
  {
    fkm = "mediaId".hashCode();
    fFE = "mediaType".hashCode();
    fsu = "filePath".hashCode();
    fHX = "compressPath".hashCode();
    fHY = "thumbPath".hashCode();
    fyz = "width".hashCode();
    fyA = "height".hashCode();
    fFe = "duration".hashCode();
    fkX = "size".hashCode();
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
      if (localId_HASHCODE != k) {
        break label65;
      }
      this.field_localId = paramCursor.getString(i);
      this.__hadSetlocalId = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fkm == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (fFE == k)
      {
        this.field_mediaType = paramCursor.getInt(i);
      }
      else if (fsu == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (fHX == k)
      {
        this.field_compressPath = paramCursor.getString(i);
      }
      else if (fHY == k)
      {
        this.field_thumbPath = paramCursor.getString(i);
      }
      else if (fyz == k)
      {
        this.field_width = paramCursor.getInt(i);
      }
      else if (fyA == k)
      {
        this.field_height = paramCursor.getInt(i);
      }
      else if (fFe == k)
      {
        this.field_duration = paramCursor.getInt(i);
      }
      else if (fkX == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else
      {
        if (fHZ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isGif = bool;
            break;
          }
        }
        if (fIa == k) {
          this.field_mediaUrl = paramCursor.getString(i);
        } else if (fIb == k) {
          this.field_thumbPicUrl = paramCursor.getString(i);
        } else if (fIc == k) {
          this.field_uploadState = paramCursor.getInt(i);
        } else if (fId == k) {
          this.field_hostTaskId = paramCursor.getString(i);
        } else if (fIe == k) {
          this.field_editFlag = paramCursor.getInt(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetlocalId) {
      localContentValues.put("localId", this.field_localId);
    }
    if (this.fjV) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.fFn) {
      localContentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
    }
    if (this.fsm) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.fHP) {
      localContentValues.put("compressPath", this.field_compressPath);
    }
    if (this.fHQ) {
      localContentValues.put("thumbPath", this.field_thumbPath);
    }
    if (this.fxN) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.fxO) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.fES) {
      localContentValues.put("duration", Integer.valueOf(this.field_duration));
    }
    if (this.fkV) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.fHR) {
      localContentValues.put("isGif", Boolean.valueOf(this.field_isGif));
    }
    if (this.fHS) {
      localContentValues.put("mediaUrl", this.field_mediaUrl);
    }
    if (this.fHT) {
      localContentValues.put("thumbPicUrl", this.field_thumbPicUrl);
    }
    if (this.fHU) {
      localContentValues.put("uploadState", Integer.valueOf(this.field_uploadState));
    }
    if (this.fHV) {
      localContentValues.put("hostTaskId", this.field_hostTaskId);
    }
    if (this.fHW) {
      localContentValues.put("editFlag", Integer.valueOf(this.field_editFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.cw
 * JD-Core Version:    0.7.0.1
 */