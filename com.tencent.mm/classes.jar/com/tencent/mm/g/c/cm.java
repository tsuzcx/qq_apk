package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cm
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eBL;
  private static final int eBM;
  private static final int eDL = "localId".hashCode();
  private static final int eHH;
  private static final int eJI;
  private static final int eJJ;
  private static final int eJK;
  private static final int eJL = "isGif".hashCode();
  private static final int eJM = "mediaUrl".hashCode();
  private static final int eJN = "thumbPicUrl".hashCode();
  private static final int eJO = "uploadState".hashCode();
  private static final int eJP = "hostTaskId".hashCode();
  private static final int eJQ = "editFlag".hashCode();
  private static final int enR = "mediaId".hashCode();
  private static final int eoH;
  private static final int evF;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAZ = true;
  private boolean eBa = true;
  private boolean eDJ = true;
  private boolean eHv = true;
  private boolean eJA = true;
  private boolean eJB = true;
  private boolean eJC = true;
  private boolean eJD = true;
  private boolean eJE = true;
  private boolean eJF = true;
  private boolean eJG = true;
  private boolean eJH = true;
  private boolean eJz = true;
  private boolean enA = true;
  private boolean eoF = true;
  private boolean evx = true;
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
    eHH = "mediaType".hashCode();
    evF = "filePath".hashCode();
    eJI = "compressPath".hashCode();
    eJJ = "thumbPath".hashCode();
    eBL = "width".hashCode();
    eBM = "height".hashCode();
    eJK = "duration".hashCode();
    eoH = "size".hashCode();
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
      if (eDL != k) {
        break label65;
      }
      this.field_localId = paramCursor.getString(i);
      this.eDJ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (enR == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (eHH == k)
      {
        this.field_mediaType = paramCursor.getInt(i);
      }
      else if (evF == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (eJI == k)
      {
        this.field_compressPath = paramCursor.getString(i);
      }
      else if (eJJ == k)
      {
        this.field_thumbPath = paramCursor.getString(i);
      }
      else if (eBL == k)
      {
        this.field_width = paramCursor.getInt(i);
      }
      else if (eBM == k)
      {
        this.field_height = paramCursor.getInt(i);
      }
      else if (eJK == k)
      {
        this.field_duration = paramCursor.getInt(i);
      }
      else if (eoH == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else
      {
        if (eJL == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isGif = bool;
            break;
          }
        }
        if (eJM == k) {
          this.field_mediaUrl = paramCursor.getString(i);
        } else if (eJN == k) {
          this.field_thumbPicUrl = paramCursor.getString(i);
        } else if (eJO == k) {
          this.field_uploadState = paramCursor.getInt(i);
        } else if (eJP == k) {
          this.field_hostTaskId = paramCursor.getString(i);
        } else if (eJQ == k) {
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
    if (this.eDJ) {
      localContentValues.put("localId", this.field_localId);
    }
    if (this.enA) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.eHv) {
      localContentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
    }
    if (this.evx) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.eJz) {
      localContentValues.put("compressPath", this.field_compressPath);
    }
    if (this.eJA) {
      localContentValues.put("thumbPath", this.field_thumbPath);
    }
    if (this.eAZ) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.eBa) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.eJB) {
      localContentValues.put("duration", Integer.valueOf(this.field_duration));
    }
    if (this.eoF) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.eJC) {
      localContentValues.put("isGif", Boolean.valueOf(this.field_isGif));
    }
    if (this.eJD) {
      localContentValues.put("mediaUrl", this.field_mediaUrl);
    }
    if (this.eJE) {
      localContentValues.put("thumbPicUrl", this.field_thumbPicUrl);
    }
    if (this.eJF) {
      localContentValues.put("uploadState", Integer.valueOf(this.field_uploadState));
    }
    if (this.eJG) {
      localContentValues.put("hostTaskId", this.field_hostTaskId);
    }
    if (this.eJH) {
      localContentValues.put("editFlag", Integer.valueOf(this.field_editFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.cm
 * JD-Core Version:    0.7.0.1
 */