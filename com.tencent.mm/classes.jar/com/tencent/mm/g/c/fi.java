package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fi
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS record_localid_index ON RecordCDNInfo(recordLocalId)" };
  private static final int eDc;
  private static final int eEX;
  private static final int eEZ;
  private static final int eFa;
  private static final int eFw;
  private static final int eTg;
  private static final int eTp = "tpauthkey".hashCode();
  private static final int eVF;
  private static final int eVa;
  private static final int eVc;
  private static final int eVj = "localId".hashCode();
  private static final int eXc;
  private static final int eXl;
  private static final int fpu = "recordLocalId".hashCode();
  private static final int fpv;
  private static final int fpw;
  private static final int fpx = "tpdataurl".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eCZ = true;
  private boolean eEG = true;
  private boolean eEI = true;
  private boolean eEJ = true;
  private boolean eFs = true;
  private boolean eSD = true;
  private boolean eSu = true;
  private boolean eUV = true;
  private boolean eUX = true;
  private boolean eVh = true;
  private boolean eVr = true;
  private boolean eWI = true;
  private boolean eWz = true;
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
  private boolean fpp = true;
  private boolean fpq = true;
  private boolean fpr = true;
  private boolean fpt = true;
  
  static
  {
    eVF = "toUser".hashCode();
    eVa = "dataId".hashCode();
    eEX = "mediaId".hashCode();
    eFw = "path".hashCode();
    eTg = "cdnUrl".hashCode();
    eVc = "cdnKey".hashCode();
    eEZ = "totalLen".hashCode();
    fpv = "isThumb".hashCode();
    eFa = "offset".hashCode();
    type_HASHCODE = "type".hashCode();
    eXc = "fileType".hashCode();
    eDc = "status".hashCode();
    eXl = "errCode".hashCode();
    fpw = "tpaeskey".hashCode();
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
      this.field_localId = paramCursor.getInt(i);
      this.eVh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fpu == k)
      {
        this.field_recordLocalId = paramCursor.getInt(i);
      }
      else if (eVF == k)
      {
        this.field_toUser = paramCursor.getString(i);
      }
      else if (eVa == k)
      {
        this.field_dataId = paramCursor.getString(i);
      }
      else if (eEX == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (eFw == k)
      {
        this.field_path = paramCursor.getString(i);
      }
      else if (eTg == k)
      {
        this.field_cdnUrl = paramCursor.getString(i);
      }
      else if (eVc == k)
      {
        this.field_cdnKey = paramCursor.getString(i);
      }
      else if (eEZ == k)
      {
        this.field_totalLen = paramCursor.getInt(i);
      }
      else
      {
        if (fpv == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isThumb = bool;
            break;
          }
        }
        if (eFa == k) {
          this.field_offset = paramCursor.getInt(i);
        } else if (type_HASHCODE == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (eXc == k) {
          this.field_fileType = paramCursor.getInt(i);
        } else if (eDc == k) {
          this.field_status = paramCursor.getInt(i);
        } else if (eXl == k) {
          this.field_errCode = paramCursor.getInt(i);
        } else if (fpw == k) {
          this.field_tpaeskey = paramCursor.getString(i);
        } else if (eTp == k) {
          this.field_tpauthkey = paramCursor.getString(i);
        } else if (fpx == k) {
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
    if (this.eVh) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.fpp) {
      localContentValues.put("recordLocalId", Integer.valueOf(this.field_recordLocalId));
    }
    if (this.field_toUser == null) {
      this.field_toUser = "";
    }
    if (this.eVr) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.eUV) {
      localContentValues.put("dataId", this.field_dataId);
    }
    if (this.eEG) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.eFs) {
      localContentValues.put("path", this.field_path);
    }
    if (this.eSu) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.eUX) {
      localContentValues.put("cdnKey", this.field_cdnKey);
    }
    if (this.eEI) {
      localContentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
    }
    if (this.fpq) {
      localContentValues.put("isThumb", Boolean.valueOf(this.field_isThumb));
    }
    if (this.eEJ) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eWz) {
      localContentValues.put("fileType", Integer.valueOf(this.field_fileType));
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eWI) {
      localContentValues.put("errCode", Integer.valueOf(this.field_errCode));
    }
    if (this.fpr) {
      localContentValues.put("tpaeskey", this.field_tpaeskey);
    }
    if (this.eSD) {
      localContentValues.put("tpauthkey", this.field_tpauthkey);
    }
    if (this.fpt) {
      localContentValues.put("tpdataurl", this.field_tpdataurl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fi
 * JD-Core Version:    0.7.0.1
 */