package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class fx
  extends IAutoDBItem
{
  public static final Column C_LOCALID;
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS record_localid_index ON RecordCDNInfo(recordLocalId)" };
  public static final SingleTable TABLE = new SingleTable("RecordCDNInfo");
  public static final Column hHn;
  public static final Column hHw;
  private static final int hIP;
  private static final int hIY = "tpauthkey".hashCode();
  public static final Column hLM;
  public static final Column hLm;
  public static final Column hLo;
  private static final int hLv;
  private static final int hLx;
  private static final int hMo;
  public static final Column hNH;
  public static final Column hNy;
  private static final int hOG;
  private static final int hOP;
  private static final int hmC;
  public static final Column hmw;
  public static final Column hnC;
  public static final Column hnE;
  public static final Column hnF;
  public static final Column hoC;
  private static final int hoK;
  private static final int hok;
  private static final int hom;
  private static final int hon;
  public static final Column isQ;
  public static final Column isR;
  public static final Column isS;
  public static final Column isT;
  private static final int isY;
  private static final int isZ;
  private static final int ita;
  private static final int itb = "tpdataurl".hashCode();
  private static final int localId_HASHCODE;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSetlocalId = true;
  private boolean __hadSettype = true;
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
  private boolean hIb = true;
  private boolean hIk = true;
  private boolean hLq = true;
  private boolean hLs = true;
  private boolean hMa = true;
  private boolean hOc = true;
  private boolean hOl = true;
  private boolean hmz = true;
  private boolean hnT = true;
  private boolean hnV = true;
  private boolean hnW = true;
  private boolean hoG = true;
  private boolean isU = true;
  private boolean isV = true;
  private boolean isW = true;
  private boolean isX = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "RecordCDNInfo", "");
    C_LOCALID = new Column("localid", "int", "RecordCDNInfo", "");
    isQ = new Column("recordlocalid", "int", "RecordCDNInfo", "");
    hLM = new Column("touser", "string", "RecordCDNInfo", "");
    hLm = new Column("dataid", "string", "RecordCDNInfo", "");
    hnC = new Column("mediaid", "string", "RecordCDNInfo", "");
    hoC = new Column("path", "string", "RecordCDNInfo", "");
    hHn = new Column("cdnurl", "string", "RecordCDNInfo", "");
    hLo = new Column("cdnkey", "string", "RecordCDNInfo", "");
    hnE = new Column("totallen", "int", "RecordCDNInfo", "");
    isR = new Column("isthumb", "boolean", "RecordCDNInfo", "");
    hnF = new Column("offset", "int", "RecordCDNInfo", "");
    C_TYPE = new Column("type", "int", "RecordCDNInfo", "");
    hNy = new Column("filetype", "int", "RecordCDNInfo", "");
    hmw = new Column("status", "int", "RecordCDNInfo", "");
    hNH = new Column("errcode", "int", "RecordCDNInfo", "");
    isS = new Column("tpaeskey", "string", "RecordCDNInfo", "");
    hHw = new Column("tpauthkey", "string", "RecordCDNInfo", "");
    isT = new Column("tpdataurl", "string", "RecordCDNInfo", "");
    localId_HASHCODE = "localId".hashCode();
    isY = "recordLocalId".hashCode();
    hMo = "toUser".hashCode();
    hLv = "dataId".hashCode();
    hok = "mediaId".hashCode();
    hoK = "path".hashCode();
    hIP = "cdnUrl".hashCode();
    hLx = "cdnKey".hashCode();
    hom = "totalLen".hashCode();
    isZ = "isThumb".hashCode();
    hon = "offset".hashCode();
    type_HASHCODE = "type".hashCode();
    hOG = "fileType".hashCode();
    hmC = "status".hashCode();
    hOP = "errCode".hashCode();
    ita = "tpaeskey".hashCode();
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
      this.field_localId = paramCursor.getInt(i);
      this.__hadSetlocalId = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (isY == k)
      {
        this.field_recordLocalId = paramCursor.getInt(i);
      }
      else if (hMo == k)
      {
        this.field_toUser = paramCursor.getString(i);
      }
      else if (hLv == k)
      {
        this.field_dataId = paramCursor.getString(i);
      }
      else if (hok == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (hoK == k)
      {
        this.field_path = paramCursor.getString(i);
      }
      else if (hIP == k)
      {
        this.field_cdnUrl = paramCursor.getString(i);
      }
      else if (hLx == k)
      {
        this.field_cdnKey = paramCursor.getString(i);
      }
      else if (hom == k)
      {
        this.field_totalLen = paramCursor.getInt(i);
      }
      else
      {
        if (isZ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isThumb = bool;
            break;
          }
        }
        if (hon == k) {
          this.field_offset = paramCursor.getInt(i);
        } else if (type_HASHCODE == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (hOG == k) {
          this.field_fileType = paramCursor.getInt(i);
        } else if (hmC == k) {
          this.field_status = paramCursor.getInt(i);
        } else if (hOP == k) {
          this.field_errCode = paramCursor.getInt(i);
        } else if (ita == k) {
          this.field_tpaeskey = paramCursor.getString(i);
        } else if (hIY == k) {
          this.field_tpauthkey = paramCursor.getString(i);
        } else if (itb == k) {
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
    if (this.__hadSetlocalId) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.isU) {
      localContentValues.put("recordLocalId", Integer.valueOf(this.field_recordLocalId));
    }
    if (this.field_toUser == null) {
      this.field_toUser = "";
    }
    if (this.hMa) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.hLq) {
      localContentValues.put("dataId", this.field_dataId);
    }
    if (this.hnT) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.hoG) {
      localContentValues.put("path", this.field_path);
    }
    if (this.hIb) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.hLs) {
      localContentValues.put("cdnKey", this.field_cdnKey);
    }
    if (this.hnV) {
      localContentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
    }
    if (this.isV) {
      localContentValues.put("isThumb", Boolean.valueOf(this.field_isThumb));
    }
    if (this.hnW) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.hOc) {
      localContentValues.put("fileType", Integer.valueOf(this.field_fileType));
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.hOl) {
      localContentValues.put("errCode", Integer.valueOf(this.field_errCode));
    }
    if (this.isW) {
      localContentValues.put("tpaeskey", this.field_tpaeskey);
    }
    if (this.hIk) {
      localContentValues.put("tpauthkey", this.field_tpauthkey);
    }
    if (this.isX) {
      localContentValues.put("tpdataurl", this.field_tpdataurl);
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
    return "RecordCDNInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.fx
 * JD-Core Version:    0.7.0.1
 */