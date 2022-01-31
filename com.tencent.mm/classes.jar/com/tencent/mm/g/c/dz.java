package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dz
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS record_localid_index ON RecordCDNInfo(recordLocalId)" };
  private static final int dLb;
  private static final int dLc;
  private static final int dLd;
  private static final int dLe = "tpdataurl".hashCode();
  private static final int dfJ;
  private static final int dhE;
  private static final int dhG;
  private static final int dhH;
  private static final int dib;
  private static final int duo;
  private static final int dux;
  private static final int dwN;
  private static final int dwi;
  private static final int dwk;
  private static final int dwr = "localId".hashCode();
  private static final int dxY;
  private static final int dyh;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean dKX = true;
  private boolean dKY = true;
  private boolean dKZ = true;
  private boolean dLa = true;
  private boolean dfG = true;
  private boolean dhX = true;
  private boolean dhn = true;
  private boolean dhp = true;
  private boolean dhq = true;
  private boolean dtC = true;
  private boolean dtL = true;
  private boolean dwd = true;
  private boolean dwf = true;
  private boolean dwp = true;
  private boolean dwz = true;
  private boolean dxG = true;
  private boolean dxx = true;
  public String field_cdnKey;
  public String field_cdnUrl;
  public String field_dataId;
  public int field_errCode;
  public int field_fileType;
  public boolean field_isThumb;
  public int field_localId;
  public String field_mediaId;
  public int field_offset;
  public String field_path;
  public int field_recordLocalId;
  public int field_status;
  public String field_toUser;
  public int field_totalLen;
  public String field_tpaeskey;
  public String field_tpauthkey;
  public String field_tpdataurl;
  public int field_type;
  
  static
  {
    dLb = "recordLocalId".hashCode();
    dwN = "toUser".hashCode();
    dwi = "dataId".hashCode();
    dhE = "mediaId".hashCode();
    dib = "path".hashCode();
    duo = "cdnUrl".hashCode();
    dwk = "cdnKey".hashCode();
    dhG = "totalLen".hashCode();
    dLc = "isThumb".hashCode();
    dhH = "offset".hashCode();
    type_HASHCODE = "type".hashCode();
    dxY = "fileType".hashCode();
    dfJ = "status".hashCode();
    dyh = "errCode".hashCode();
    dLd = "tpaeskey".hashCode();
    dux = "tpauthkey".hashCode();
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
      this.field_localId = paramCursor.getInt(i);
      this.dwp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dLb == k)
      {
        this.field_recordLocalId = paramCursor.getInt(i);
      }
      else if (dwN == k)
      {
        this.field_toUser = paramCursor.getString(i);
      }
      else if (dwi == k)
      {
        this.field_dataId = paramCursor.getString(i);
      }
      else if (dhE == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (dib == k)
      {
        this.field_path = paramCursor.getString(i);
      }
      else if (duo == k)
      {
        this.field_cdnUrl = paramCursor.getString(i);
      }
      else if (dwk == k)
      {
        this.field_cdnKey = paramCursor.getString(i);
      }
      else if (dhG == k)
      {
        this.field_totalLen = paramCursor.getInt(i);
      }
      else
      {
        if (dLc == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isThumb = bool;
            break;
          }
        }
        if (dhH == k) {
          this.field_offset = paramCursor.getInt(i);
        } else if (type_HASHCODE == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (dxY == k) {
          this.field_fileType = paramCursor.getInt(i);
        } else if (dfJ == k) {
          this.field_status = paramCursor.getInt(i);
        } else if (dyh == k) {
          this.field_errCode = paramCursor.getInt(i);
        } else if (dLd == k) {
          this.field_tpaeskey = paramCursor.getString(i);
        } else if (dux == k) {
          this.field_tpauthkey = paramCursor.getString(i);
        } else if (dLe == k) {
          this.field_tpdataurl = paramCursor.getString(i);
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
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.dKX) {
      localContentValues.put("recordLocalId", Integer.valueOf(this.field_recordLocalId));
    }
    if (this.field_toUser == null) {
      this.field_toUser = "";
    }
    if (this.dwz) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.dwd) {
      localContentValues.put("dataId", this.field_dataId);
    }
    if (this.dhn) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.dhX) {
      localContentValues.put("path", this.field_path);
    }
    if (this.dtC) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.dwf) {
      localContentValues.put("cdnKey", this.field_cdnKey);
    }
    if (this.dhp) {
      localContentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
    }
    if (this.dKY) {
      localContentValues.put("isThumb", Boolean.valueOf(this.field_isThumb));
    }
    if (this.dhq) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.dxx) {
      localContentValues.put("fileType", Integer.valueOf(this.field_fileType));
    }
    if (this.dfG) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.dxG) {
      localContentValues.put("errCode", Integer.valueOf(this.field_errCode));
    }
    if (this.dKZ) {
      localContentValues.put("tpaeskey", this.field_tpaeskey);
    }
    if (this.dtL) {
      localContentValues.put("tpauthkey", this.field_tpauthkey);
    }
    if (this.dLa) {
      localContentValues.put("tpdataurl", this.field_tpdataurl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.dz
 * JD-Core Version:    0.7.0.1
 */