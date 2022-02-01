package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eu
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS record_localid_index ON RecordCDNInfo(recordLocalId)" };
  private static final int eBN;
  private static final int eBi;
  private static final int eBk;
  private static final int eBr = "localId".hashCode();
  private static final int eDk;
  private static final int eDt;
  private static final int eTU = "recordLocalId".hashCode();
  private static final int eTV;
  private static final int eTW;
  private static final int eTX = "tpdataurl".hashCode();
  private static final int ejR;
  private static final int elM;
  private static final int elO;
  private static final int elP;
  private static final int eml;
  private static final int ezo;
  private static final int ezx;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eBd = true;
  private boolean eBf = true;
  private boolean eBp = true;
  private boolean eBz = true;
  private boolean eCH = true;
  private boolean eCQ = true;
  private boolean eTQ = true;
  private boolean eTR = true;
  private boolean eTS = true;
  private boolean eTT = true;
  private boolean ejO = true;
  private boolean elv = true;
  private boolean elx = true;
  private boolean ely = true;
  private boolean emh = true;
  private boolean eyC = true;
  private boolean eyL = true;
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
    eBN = "toUser".hashCode();
    eBi = "dataId".hashCode();
    elM = "mediaId".hashCode();
    eml = "path".hashCode();
    ezo = "cdnUrl".hashCode();
    eBk = "cdnKey".hashCode();
    elO = "totalLen".hashCode();
    eTV = "isThumb".hashCode();
    elP = "offset".hashCode();
    type_HASHCODE = "type".hashCode();
    eDk = "fileType".hashCode();
    ejR = "status".hashCode();
    eDt = "errCode".hashCode();
    eTW = "tpaeskey".hashCode();
    ezx = "tpauthkey".hashCode();
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
      this.field_localId = paramCursor.getInt(i);
      this.eBp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eTU == k)
      {
        this.field_recordLocalId = paramCursor.getInt(i);
      }
      else if (eBN == k)
      {
        this.field_toUser = paramCursor.getString(i);
      }
      else if (eBi == k)
      {
        this.field_dataId = paramCursor.getString(i);
      }
      else if (elM == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (eml == k)
      {
        this.field_path = paramCursor.getString(i);
      }
      else if (ezo == k)
      {
        this.field_cdnUrl = paramCursor.getString(i);
      }
      else if (eBk == k)
      {
        this.field_cdnKey = paramCursor.getString(i);
      }
      else if (elO == k)
      {
        this.field_totalLen = paramCursor.getInt(i);
      }
      else
      {
        if (eTV == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isThumb = bool;
            break;
          }
        }
        if (elP == k) {
          this.field_offset = paramCursor.getInt(i);
        } else if (type_HASHCODE == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (eDk == k) {
          this.field_fileType = paramCursor.getInt(i);
        } else if (ejR == k) {
          this.field_status = paramCursor.getInt(i);
        } else if (eDt == k) {
          this.field_errCode = paramCursor.getInt(i);
        } else if (eTW == k) {
          this.field_tpaeskey = paramCursor.getString(i);
        } else if (ezx == k) {
          this.field_tpauthkey = paramCursor.getString(i);
        } else if (eTX == k) {
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
    if (this.eBp) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.eTQ) {
      localContentValues.put("recordLocalId", Integer.valueOf(this.field_recordLocalId));
    }
    if (this.field_toUser == null) {
      this.field_toUser = "";
    }
    if (this.eBz) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.eBd) {
      localContentValues.put("dataId", this.field_dataId);
    }
    if (this.elv) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.emh) {
      localContentValues.put("path", this.field_path);
    }
    if (this.eyC) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.eBf) {
      localContentValues.put("cdnKey", this.field_cdnKey);
    }
    if (this.elx) {
      localContentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
    }
    if (this.eTR) {
      localContentValues.put("isThumb", Boolean.valueOf(this.field_isThumb));
    }
    if (this.ely) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eCH) {
      localContentValues.put("fileType", Integer.valueOf(this.field_fileType));
    }
    if (this.ejO) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eCQ) {
      localContentValues.put("errCode", Integer.valueOf(this.field_errCode));
    }
    if (this.eTS) {
      localContentValues.put("tpaeskey", this.field_tpaeskey);
    }
    if (this.eyL) {
      localContentValues.put("tpauthkey", this.field_tpauthkey);
    }
    if (this.eTT) {
      localContentValues.put("tpdataurl", this.field_tpdataurl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.eu
 * JD-Core Version:    0.7.0.1
 */