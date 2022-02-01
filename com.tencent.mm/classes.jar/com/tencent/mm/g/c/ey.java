package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ey
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS record_localid_index ON RecordCDNInfo(recordLocalId)" };
  private static final int eBI;
  private static final int eBR = "tpauthkey".hashCode();
  private static final int eDC;
  private static final int eDE;
  private static final int eDL = "localId".hashCode();
  private static final int eEh;
  private static final int eFE;
  private static final int eFN;
  private static final int eXe = "recordLocalId".hashCode();
  private static final int eXf;
  private static final int eXg;
  private static final int eXh = "tpdataurl".hashCode();
  private static final int elV;
  private static final int enR;
  private static final int enT;
  private static final int enU;
  private static final int eor;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eAW = true;
  private boolean eBf = true;
  private boolean eDJ = true;
  private boolean eDT = true;
  private boolean eDx = true;
  private boolean eDz = true;
  private boolean eFb = true;
  private boolean eFk = true;
  private boolean eXa = true;
  private boolean eXb = true;
  private boolean eXc = true;
  private boolean eXd = true;
  private boolean elS = true;
  private boolean enA = true;
  private boolean enC = true;
  private boolean enD = true;
  private boolean eon = true;
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
    eEh = "toUser".hashCode();
    eDC = "dataId".hashCode();
    enR = "mediaId".hashCode();
    eor = "path".hashCode();
    eBI = "cdnUrl".hashCode();
    eDE = "cdnKey".hashCode();
    enT = "totalLen".hashCode();
    eXf = "isThumb".hashCode();
    enU = "offset".hashCode();
    type_HASHCODE = "type".hashCode();
    eFE = "fileType".hashCode();
    elV = "status".hashCode();
    eFN = "errCode".hashCode();
    eXg = "tpaeskey".hashCode();
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
      this.field_localId = paramCursor.getInt(i);
      this.eDJ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eXe == k)
      {
        this.field_recordLocalId = paramCursor.getInt(i);
      }
      else if (eEh == k)
      {
        this.field_toUser = paramCursor.getString(i);
      }
      else if (eDC == k)
      {
        this.field_dataId = paramCursor.getString(i);
      }
      else if (enR == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (eor == k)
      {
        this.field_path = paramCursor.getString(i);
      }
      else if (eBI == k)
      {
        this.field_cdnUrl = paramCursor.getString(i);
      }
      else if (eDE == k)
      {
        this.field_cdnKey = paramCursor.getString(i);
      }
      else if (enT == k)
      {
        this.field_totalLen = paramCursor.getInt(i);
      }
      else
      {
        if (eXf == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isThumb = bool;
            break;
          }
        }
        if (enU == k) {
          this.field_offset = paramCursor.getInt(i);
        } else if (type_HASHCODE == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (eFE == k) {
          this.field_fileType = paramCursor.getInt(i);
        } else if (elV == k) {
          this.field_status = paramCursor.getInt(i);
        } else if (eFN == k) {
          this.field_errCode = paramCursor.getInt(i);
        } else if (eXg == k) {
          this.field_tpaeskey = paramCursor.getString(i);
        } else if (eBR == k) {
          this.field_tpauthkey = paramCursor.getString(i);
        } else if (eXh == k) {
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
    if (this.eDJ) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.eXa) {
      localContentValues.put("recordLocalId", Integer.valueOf(this.field_recordLocalId));
    }
    if (this.field_toUser == null) {
      this.field_toUser = "";
    }
    if (this.eDT) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.eDx) {
      localContentValues.put("dataId", this.field_dataId);
    }
    if (this.enA) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.eon) {
      localContentValues.put("path", this.field_path);
    }
    if (this.eAW) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.eDz) {
      localContentValues.put("cdnKey", this.field_cdnKey);
    }
    if (this.enC) {
      localContentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
    }
    if (this.eXb) {
      localContentValues.put("isThumb", Boolean.valueOf(this.field_isThumb));
    }
    if (this.enD) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eFb) {
      localContentValues.put("fileType", Integer.valueOf(this.field_fileType));
    }
    if (this.elS) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eFk) {
      localContentValues.put("errCode", Integer.valueOf(this.field_errCode));
    }
    if (this.eXc) {
      localContentValues.put("tpaeskey", this.field_tpaeskey);
    }
    if (this.eBf) {
      localContentValues.put("tpauthkey", this.field_tpauthkey);
    }
    if (this.eXd) {
      localContentValues.put("tpdataurl", this.field_tpdataurl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ey
 * JD-Core Version:    0.7.0.1
 */