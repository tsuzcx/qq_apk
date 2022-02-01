package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class da
  extends IAutoDBItem
{
  public static final Column C_LOCALID;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("GameHaowanMedia");
  public static final Column hHq;
  public static final Column hHr;
  private static final int hIS;
  private static final int hIT;
  public static final Column hTM;
  private static final int hUK;
  private static final int hUk;
  public static final Column hXP;
  public static final Column hXQ;
  public static final Column hXR;
  public static final Column hXS;
  public static final Column hXT;
  public static final Column hXU;
  public static final Column hXV;
  public static final Column hXW;
  public static final Column hXX;
  private static final int hYg;
  private static final int hYh;
  private static final int hYi = "isGif".hashCode();
  private static final int hYj = "mediaUrl".hashCode();
  private static final int hYk = "thumbPicUrl".hashCode();
  private static final int hYl = "uploadState".hashCode();
  private static final int hYm = "hostTaskId".hashCode();
  private static final int hYn = "editFlag".hashCode();
  public static final Column hnC;
  private static final int hok;
  public static final Column hpd;
  private static final int hph;
  public static final Column hzC;
  private static final int hzS;
  private static final int localId_HASHCODE;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetlocalId = true;
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
  private boolean hIe = true;
  private boolean hIf = true;
  private boolean hTY = true;
  private boolean hUt = true;
  private boolean hXY = true;
  private boolean hXZ = true;
  private boolean hYa = true;
  private boolean hYb = true;
  private boolean hYc = true;
  private boolean hYd = true;
  private boolean hYe = true;
  private boolean hYf = true;
  private boolean hnT = true;
  private boolean hpf = true;
  private boolean hzK = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "GameHaowanMedia", "");
    C_LOCALID = new Column("localid", "string", "GameHaowanMedia", "");
    hnC = new Column("mediaid", "string", "GameHaowanMedia", "");
    hXP = new Column("mediatype", "int", "GameHaowanMedia", "");
    hzC = new Column("filepath", "string", "GameHaowanMedia", "");
    hXQ = new Column("compresspath", "string", "GameHaowanMedia", "");
    hXR = new Column("thumbpath", "string", "GameHaowanMedia", "");
    hHq = new Column("width", "int", "GameHaowanMedia", "");
    hHr = new Column("height", "int", "GameHaowanMedia", "");
    hTM = new Column("duration", "int", "GameHaowanMedia", "");
    hpd = new Column("size", "long", "GameHaowanMedia", "");
    hXS = new Column("isgif", "boolean", "GameHaowanMedia", "");
    hXT = new Column("mediaurl", "string", "GameHaowanMedia", "");
    hXU = new Column("thumbpicurl", "string", "GameHaowanMedia", "");
    hXV = new Column("uploadstate", "int", "GameHaowanMedia", "");
    hXW = new Column("hosttaskid", "string", "GameHaowanMedia", "");
    hXX = new Column("editflag", "int", "GameHaowanMedia", "");
    localId_HASHCODE = "localId".hashCode();
    hok = "mediaId".hashCode();
    hUK = "mediaType".hashCode();
    hzS = "filePath".hashCode();
    hYg = "compressPath".hashCode();
    hYh = "thumbPath".hashCode();
    hIS = "width".hashCode();
    hIT = "height".hashCode();
    hUk = "duration".hashCode();
    hph = "size".hashCode();
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
      if (hok == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (hUK == k)
      {
        this.field_mediaType = paramCursor.getInt(i);
      }
      else if (hzS == k)
      {
        this.field_filePath = paramCursor.getString(i);
      }
      else if (hYg == k)
      {
        this.field_compressPath = paramCursor.getString(i);
      }
      else if (hYh == k)
      {
        this.field_thumbPath = paramCursor.getString(i);
      }
      else if (hIS == k)
      {
        this.field_width = paramCursor.getInt(i);
      }
      else if (hIT == k)
      {
        this.field_height = paramCursor.getInt(i);
      }
      else if (hUk == k)
      {
        this.field_duration = paramCursor.getInt(i);
      }
      else if (hph == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else
      {
        if (hYi == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isGif = bool;
            break;
          }
        }
        if (hYj == k) {
          this.field_mediaUrl = paramCursor.getString(i);
        } else if (hYk == k) {
          this.field_thumbPicUrl = paramCursor.getString(i);
        } else if (hYl == k) {
          this.field_uploadState = paramCursor.getInt(i);
        } else if (hYm == k) {
          this.field_hostTaskId = paramCursor.getString(i);
        } else if (hYn == k) {
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
    if (this.hnT) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.hUt) {
      localContentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
    }
    if (this.hzK) {
      localContentValues.put("filePath", this.field_filePath);
    }
    if (this.hXY) {
      localContentValues.put("compressPath", this.field_compressPath);
    }
    if (this.hXZ) {
      localContentValues.put("thumbPath", this.field_thumbPath);
    }
    if (this.hIe) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.hIf) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.hTY) {
      localContentValues.put("duration", Integer.valueOf(this.field_duration));
    }
    if (this.hpf) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.hYa) {
      localContentValues.put("isGif", Boolean.valueOf(this.field_isGif));
    }
    if (this.hYb) {
      localContentValues.put("mediaUrl", this.field_mediaUrl);
    }
    if (this.hYc) {
      localContentValues.put("thumbPicUrl", this.field_thumbPicUrl);
    }
    if (this.hYd) {
      localContentValues.put("uploadState", Integer.valueOf(this.field_uploadState));
    }
    if (this.hYe) {
      localContentValues.put("hostTaskId", this.field_hostTaskId);
    }
    if (this.hYf) {
      localContentValues.put("editFlag", Integer.valueOf(this.field_editFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "GameHaowanMedia";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.da
 * JD-Core Version:    0.7.0.1
 */