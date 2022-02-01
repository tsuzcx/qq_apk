package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fi
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS record_localid_index ON RecordCDNInfo(recordLocalId)" };
  private static final int eEL;
  private static final int eGG;
  private static final int eGI;
  private static final int eGJ;
  private static final int eHf;
  private static final int eUR;
  private static final int eVa = "tpauthkey".hashCode();
  private static final int eWL;
  private static final int eWN;
  private static final int eWU = "localId".hashCode();
  private static final int eXq;
  private static final int eYN;
  private static final int eYW;
  private static final int fru = "recordLocalId".hashCode();
  private static final int frv;
  private static final int frw;
  private static final int frx = "tpdataurl".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eEI = true;
  private boolean eGp = true;
  private boolean eGr = true;
  private boolean eGs = true;
  private boolean eHb = true;
  private boolean eUf = true;
  private boolean eUo = true;
  private boolean eWG = true;
  private boolean eWI = true;
  private boolean eWS = true;
  private boolean eXc = true;
  private boolean eYk = true;
  private boolean eYt = true;
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
  private boolean frq = true;
  private boolean frr = true;
  private boolean frs = true;
  private boolean frt = true;
  
  static
  {
    eXq = "toUser".hashCode();
    eWL = "dataId".hashCode();
    eGG = "mediaId".hashCode();
    eHf = "path".hashCode();
    eUR = "cdnUrl".hashCode();
    eWN = "cdnKey".hashCode();
    eGI = "totalLen".hashCode();
    frv = "isThumb".hashCode();
    eGJ = "offset".hashCode();
    type_HASHCODE = "type".hashCode();
    eYN = "fileType".hashCode();
    eEL = "status".hashCode();
    eYW = "errCode".hashCode();
    frw = "tpaeskey".hashCode();
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
      this.field_localId = paramCursor.getInt(i);
      this.eWS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fru == k)
      {
        this.field_recordLocalId = paramCursor.getInt(i);
      }
      else if (eXq == k)
      {
        this.field_toUser = paramCursor.getString(i);
      }
      else if (eWL == k)
      {
        this.field_dataId = paramCursor.getString(i);
      }
      else if (eGG == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (eHf == k)
      {
        this.field_path = paramCursor.getString(i);
      }
      else if (eUR == k)
      {
        this.field_cdnUrl = paramCursor.getString(i);
      }
      else if (eWN == k)
      {
        this.field_cdnKey = paramCursor.getString(i);
      }
      else if (eGI == k)
      {
        this.field_totalLen = paramCursor.getInt(i);
      }
      else
      {
        if (frv == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isThumb = bool;
            break;
          }
        }
        if (eGJ == k) {
          this.field_offset = paramCursor.getInt(i);
        } else if (type_HASHCODE == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (eYN == k) {
          this.field_fileType = paramCursor.getInt(i);
        } else if (eEL == k) {
          this.field_status = paramCursor.getInt(i);
        } else if (eYW == k) {
          this.field_errCode = paramCursor.getInt(i);
        } else if (frw == k) {
          this.field_tpaeskey = paramCursor.getString(i);
        } else if (eVa == k) {
          this.field_tpauthkey = paramCursor.getString(i);
        } else if (frx == k) {
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
    if (this.eWS) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.frq) {
      localContentValues.put("recordLocalId", Integer.valueOf(this.field_recordLocalId));
    }
    if (this.field_toUser == null) {
      this.field_toUser = "";
    }
    if (this.eXc) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.eWG) {
      localContentValues.put("dataId", this.field_dataId);
    }
    if (this.eGp) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.eHb) {
      localContentValues.put("path", this.field_path);
    }
    if (this.eUf) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.eWI) {
      localContentValues.put("cdnKey", this.field_cdnKey);
    }
    if (this.eGr) {
      localContentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
    }
    if (this.frr) {
      localContentValues.put("isThumb", Boolean.valueOf(this.field_isThumb));
    }
    if (this.eGs) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eYk) {
      localContentValues.put("fileType", Integer.valueOf(this.field_fileType));
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eYt) {
      localContentValues.put("errCode", Integer.valueOf(this.field_errCode));
    }
    if (this.frs) {
      localContentValues.put("tpaeskey", this.field_tpaeskey);
    }
    if (this.eUo) {
      localContentValues.put("tpauthkey", this.field_tpauthkey);
    }
    if (this.frt) {
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