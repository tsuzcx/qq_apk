package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class by
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dAh;
  private static final int dAi;
  private static final int dAj;
  private static final int dAk;
  private static final int dAl = "isGif".hashCode();
  private static final int dAm = "mediaUrl".hashCode();
  private static final int dAn = "thumbPicUrl".hashCode();
  private static final int dAo = "uploadState".hashCode();
  private static final int dhE;
  private static final int dij;
  private static final int doK;
  private static final int dur;
  private static final int dus;
  private static final int dwr = "localId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dAa = true;
  private boolean dAb = true;
  private boolean dAc = true;
  private boolean dAd = true;
  private boolean dAe = true;
  private boolean dAf = true;
  private boolean dAg = true;
  private boolean dhn = true;
  private boolean dih = true;
  private boolean doC = true;
  private boolean dtF = true;
  private boolean dtG = true;
  private boolean dwp = true;
  private boolean dzZ = true;
  public String field_compressPath;
  public int field_duration;
  public String field_filePath;
  public int field_height;
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
    dhE = "mediaId".hashCode();
    dAh = "mediaType".hashCode();
    doK = "filePath".hashCode();
    dAi = "compressPath".hashCode();
    dAj = "thumbPath".hashCode();
    dur = "width".hashCode();
    dus = "height".hashCode();
    dAk = "duration".hashCode();
    dij = "size".hashCode();
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
      if (dwr != k) {
        break label65;
      }
      this.field_localId = paramCursor.getString(i);
      this.dwp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dhE == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (dAh == k)
      {
        this.field_mediaType = paramCursor.getInt(i);
      }
      else if (doK == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (dAi == k)
      {
        this.field_compressPath = paramCursor.getString(i);
      }
      else if (dAj == k)
      {
        this.field_thumbPath = paramCursor.getString(i);
      }
      else if (dur == k)
      {
        this.field_width = paramCursor.getInt(i);
      }
      else if (dus == k)
      {
        this.field_height = paramCursor.getInt(i);
      }
      else if (dAk == k)
      {
        this.field_duration = paramCursor.getInt(i);
      }
      else if (dij == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else
      {
        if (dAl == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isGif = bool;
            break;
          }
        }
        if (dAm == k) {
          this.field_mediaUrl = paramCursor.getString(i);
        } else if (dAn == k) {
          this.field_thumbPicUrl = paramCursor.getString(i);
        } else if (dAo == k) {
          this.field_uploadState = paramCursor.getInt(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dwp) {
      localContentValues.put("localId", this.field_localId);
    }
    if (this.dhn) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.dzZ) {
      localContentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
    }
    if (this.doC) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.dAa) {
      localContentValues.put("compressPath", this.field_compressPath);
    }
    if (this.dAb) {
      localContentValues.put("thumbPath", this.field_thumbPath);
    }
    if (this.dtF) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.dtG) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.dAc) {
      localContentValues.put("duration", Integer.valueOf(this.field_duration));
    }
    if (this.dih) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.dAd) {
      localContentValues.put("isGif", Boolean.valueOf(this.field_isGif));
    }
    if (this.dAe) {
      localContentValues.put("mediaUrl", this.field_mediaUrl);
    }
    if (this.dAf) {
      localContentValues.put("thumbPicUrl", this.field_thumbPicUrl);
    }
    if (this.dAg) {
      localContentValues.put("uploadState", Integer.valueOf(this.field_uploadState));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.by
 * JD-Core Version:    0.7.0.1
 */