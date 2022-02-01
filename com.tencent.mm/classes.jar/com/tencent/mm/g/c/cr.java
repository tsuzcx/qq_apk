package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cr
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGG;
  private static final int eHv = "size".hashCode();
  private static final int eON;
  private static final int eUU;
  private static final int eUV;
  private static final int eWU = "localId".hashCode();
  private static final int faZ;
  private static final int fby;
  private static final int fdG;
  private static final int fdH;
  private static final int fdI = "isGif".hashCode();
  private static final int fdJ = "mediaUrl".hashCode();
  private static final int fdK = "thumbPicUrl".hashCode();
  private static final int fdL = "uploadState".hashCode();
  private static final int fdM = "hostTaskId".hashCode();
  private static final int fdN = "editFlag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGp = true;
  private boolean eHt = true;
  private boolean eOF = true;
  private boolean eUi = true;
  private boolean eUj = true;
  private boolean eWS = true;
  private boolean faN = true;
  private boolean fbi = true;
  private boolean fdA = true;
  private boolean fdB = true;
  private boolean fdC = true;
  private boolean fdD = true;
  private boolean fdE = true;
  private boolean fdF = true;
  private boolean fdy = true;
  private boolean fdz = true;
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
  
  static
  {
    eGG = "mediaId".hashCode();
    fby = "mediaType".hashCode();
    eON = "filePath".hashCode();
    fdG = "compressPath".hashCode();
    fdH = "thumbPath".hashCode();
    eUU = "width".hashCode();
    eUV = "height".hashCode();
    faZ = "duration".hashCode();
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
      if (eWU != k) {
        break label65;
      }
      this.field_localId = paramCursor.getString(i);
      this.eWS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eGG == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (fby == k)
      {
        this.field_mediaType = paramCursor.getInt(i);
      }
      else if (eON == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (fdG == k)
      {
        this.field_compressPath = paramCursor.getString(i);
      }
      else if (fdH == k)
      {
        this.field_thumbPath = paramCursor.getString(i);
      }
      else if (eUU == k)
      {
        this.field_width = paramCursor.getInt(i);
      }
      else if (eUV == k)
      {
        this.field_height = paramCursor.getInt(i);
      }
      else if (faZ == k)
      {
        this.field_duration = paramCursor.getInt(i);
      }
      else if (eHv == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else
      {
        if (fdI == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isGif = bool;
            break;
          }
        }
        if (fdJ == k) {
          this.field_mediaUrl = paramCursor.getString(i);
        } else if (fdK == k) {
          this.field_thumbPicUrl = paramCursor.getString(i);
        } else if (fdL == k) {
          this.field_uploadState = paramCursor.getInt(i);
        } else if (fdM == k) {
          this.field_hostTaskId = paramCursor.getString(i);
        } else if (fdN == k) {
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
    if (this.eWS) {
      localContentValues.put("localId", this.field_localId);
    }
    if (this.eGp) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.fbi) {
      localContentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
    }
    if (this.eOF) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.fdy) {
      localContentValues.put("compressPath", this.field_compressPath);
    }
    if (this.fdz) {
      localContentValues.put("thumbPath", this.field_thumbPath);
    }
    if (this.eUi) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.eUj) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.faN) {
      localContentValues.put("duration", Integer.valueOf(this.field_duration));
    }
    if (this.eHt) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.fdA) {
      localContentValues.put("isGif", Boolean.valueOf(this.field_isGif));
    }
    if (this.fdB) {
      localContentValues.put("mediaUrl", this.field_mediaUrl);
    }
    if (this.fdC) {
      localContentValues.put("thumbPicUrl", this.field_thumbPicUrl);
    }
    if (this.fdD) {
      localContentValues.put("uploadState", Integer.valueOf(this.field_uploadState));
    }
    if (this.fdE) {
      localContentValues.put("hostTaskId", this.field_hostTaskId);
    }
    if (this.fdF) {
      localContentValues.put("editFlag", Integer.valueOf(this.field_editFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cr
 * JD-Core Version:    0.7.0.1
 */