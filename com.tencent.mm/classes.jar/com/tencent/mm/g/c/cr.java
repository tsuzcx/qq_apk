package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cr
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEX;
  private static final int eFM = "size".hashCode();
  private static final int eNc;
  private static final int eTj;
  private static final int eTk;
  private static final int eVj = "localId".hashCode();
  private static final int eZK;
  private static final int eZm;
  private static final int fbR;
  private static final int fbS;
  private static final int fbT = "isGif".hashCode();
  private static final int fbU = "mediaUrl".hashCode();
  private static final int fbV = "thumbPicUrl".hashCode();
  private static final int fbW = "uploadState".hashCode();
  private static final int fbX = "hostTaskId".hashCode();
  private static final int fbY = "editFlag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEG = true;
  private boolean eFK = true;
  private boolean eMU = true;
  private boolean eSx = true;
  private boolean eSy = true;
  private boolean eVh = true;
  private boolean eZa = true;
  private boolean eZv = true;
  private boolean fbJ = true;
  private boolean fbK = true;
  private boolean fbL = true;
  private boolean fbM = true;
  private boolean fbN = true;
  private boolean fbO = true;
  private boolean fbP = true;
  private boolean fbQ = true;
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
    eEX = "mediaId".hashCode();
    eZK = "mediaType".hashCode();
    eNc = "filePath".hashCode();
    fbR = "compressPath".hashCode();
    fbS = "thumbPath".hashCode();
    eTj = "width".hashCode();
    eTk = "height".hashCode();
    eZm = "duration".hashCode();
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
      if (eVj != k) {
        break label65;
      }
      this.field_localId = paramCursor.getString(i);
      this.eVh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eEX == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (eZK == k)
      {
        this.field_mediaType = paramCursor.getInt(i);
      }
      else if (eNc == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (fbR == k)
      {
        this.field_compressPath = paramCursor.getString(i);
      }
      else if (fbS == k)
      {
        this.field_thumbPath = paramCursor.getString(i);
      }
      else if (eTj == k)
      {
        this.field_width = paramCursor.getInt(i);
      }
      else if (eTk == k)
      {
        this.field_height = paramCursor.getInt(i);
      }
      else if (eZm == k)
      {
        this.field_duration = paramCursor.getInt(i);
      }
      else if (eFM == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else
      {
        if (fbT == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isGif = bool;
            break;
          }
        }
        if (fbU == k) {
          this.field_mediaUrl = paramCursor.getString(i);
        } else if (fbV == k) {
          this.field_thumbPicUrl = paramCursor.getString(i);
        } else if (fbW == k) {
          this.field_uploadState = paramCursor.getInt(i);
        } else if (fbX == k) {
          this.field_hostTaskId = paramCursor.getString(i);
        } else if (fbY == k) {
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
    if (this.eVh) {
      localContentValues.put("localId", this.field_localId);
    }
    if (this.eEG) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.eZv) {
      localContentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
    }
    if (this.eMU) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.fbJ) {
      localContentValues.put("compressPath", this.field_compressPath);
    }
    if (this.fbK) {
      localContentValues.put("thumbPath", this.field_thumbPath);
    }
    if (this.eSx) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.eSy) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.eZa) {
      localContentValues.put("duration", Integer.valueOf(this.field_duration));
    }
    if (this.eFK) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.fbL) {
      localContentValues.put("isGif", Boolean.valueOf(this.field_isGif));
    }
    if (this.fbM) {
      localContentValues.put("mediaUrl", this.field_mediaUrl);
    }
    if (this.fbN) {
      localContentValues.put("thumbPicUrl", this.field_thumbPicUrl);
    }
    if (this.fbO) {
      localContentValues.put("uploadState", Integer.valueOf(this.field_uploadState));
    }
    if (this.fbP) {
      localContentValues.put("hostTaskId", this.field_hostTaskId);
    }
    if (this.fbQ) {
      localContentValues.put("editFlag", Integer.valueOf(this.field_editFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.cr
 * JD-Core Version:    0.7.0.1
 */