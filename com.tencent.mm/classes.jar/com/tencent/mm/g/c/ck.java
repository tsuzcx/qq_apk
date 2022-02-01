package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ck
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eBr = "localId".hashCode();
  private static final int eEW;
  private static final int eGQ;
  private static final int eGR;
  private static final int eGS;
  private static final int eGT = "isGif".hashCode();
  private static final int eGU = "mediaUrl".hashCode();
  private static final int eGV = "thumbPicUrl".hashCode();
  private static final int eGW = "uploadState".hashCode();
  private static final int eGX = "hostTaskId".hashCode();
  private static final int eGY = "editFlag".hashCode();
  private static final int elM = "mediaId".hashCode();
  private static final int emB;
  private static final int etB;
  private static final int ezr;
  private static final int ezs;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eBp = true;
  private boolean eEN = true;
  private boolean eGH = true;
  private boolean eGI = true;
  private boolean eGJ = true;
  private boolean eGK = true;
  private boolean eGL = true;
  private boolean eGM = true;
  private boolean eGN = true;
  private boolean eGO = true;
  private boolean eGP = true;
  private boolean elv = true;
  private boolean emz = true;
  private boolean ett = true;
  private boolean eyF = true;
  private boolean eyG = true;
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
    eEW = "mediaType".hashCode();
    etB = "filePath".hashCode();
    eGQ = "compressPath".hashCode();
    eGR = "thumbPath".hashCode();
    ezr = "width".hashCode();
    ezs = "height".hashCode();
    eGS = "duration".hashCode();
    emB = "size".hashCode();
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
      if (eBr != k) {
        break label65;
      }
      this.field_localId = paramCursor.getString(i);
      this.eBp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (elM == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (eEW == k)
      {
        this.field_mediaType = paramCursor.getInt(i);
      }
      else if (etB == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (eGQ == k)
      {
        this.field_compressPath = paramCursor.getString(i);
      }
      else if (eGR == k)
      {
        this.field_thumbPath = paramCursor.getString(i);
      }
      else if (ezr == k)
      {
        this.field_width = paramCursor.getInt(i);
      }
      else if (ezs == k)
      {
        this.field_height = paramCursor.getInt(i);
      }
      else if (eGS == k)
      {
        this.field_duration = paramCursor.getInt(i);
      }
      else if (emB == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else
      {
        if (eGT == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isGif = bool;
            break;
          }
        }
        if (eGU == k) {
          this.field_mediaUrl = paramCursor.getString(i);
        } else if (eGV == k) {
          this.field_thumbPicUrl = paramCursor.getString(i);
        } else if (eGW == k) {
          this.field_uploadState = paramCursor.getInt(i);
        } else if (eGX == k) {
          this.field_hostTaskId = paramCursor.getString(i);
        } else if (eGY == k) {
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
    if (this.eBp) {
      localContentValues.put("localId", this.field_localId);
    }
    if (this.elv) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.eEN) {
      localContentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
    }
    if (this.ett) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.eGH) {
      localContentValues.put("compressPath", this.field_compressPath);
    }
    if (this.eGI) {
      localContentValues.put("thumbPath", this.field_thumbPath);
    }
    if (this.eyF) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.eyG) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.eGJ) {
      localContentValues.put("duration", Integer.valueOf(this.field_duration));
    }
    if (this.emz) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.eGK) {
      localContentValues.put("isGif", Boolean.valueOf(this.field_isGif));
    }
    if (this.eGL) {
      localContentValues.put("mediaUrl", this.field_mediaUrl);
    }
    if (this.eGM) {
      localContentValues.put("thumbPicUrl", this.field_thumbPicUrl);
    }
    if (this.eGN) {
      localContentValues.put("uploadState", Integer.valueOf(this.field_uploadState));
    }
    if (this.eGO) {
      localContentValues.put("hostTaskId", this.field_hostTaskId);
    }
    if (this.eGP) {
      localContentValues.put("editFlag", Integer.valueOf(this.field_editFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ck
 * JD-Core Version:    0.7.0.1
 */