package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class do
  extends c
{
  private static final int cFT;
  private static final int cGc = "tpauthkey".hashCode();
  private static final int cHA;
  private static final int cHC;
  private static final int cHJ;
  private static final int cIe;
  private static final int cJi;
  private static final int cJr;
  private static final int cUP;
  private static final int cUQ;
  private static final int cUR;
  private static final int cUS = "tpdataurl".hashCode();
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS record_localid_index ON RecordCDNInfo(recordLocalId)" };
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int csy;
  private static final int ctM;
  private static final int cto;
  private static final int ctq;
  private static final int ctr;
  private boolean cFq = true;
  private boolean cFz = true;
  private boolean cHH = true;
  private boolean cHR = true;
  private boolean cHv = true;
  private boolean cHx = true;
  private boolean cIN = true;
  private boolean cIW = true;
  private boolean cUL = true;
  private boolean cUM = true;
  private boolean cUN = true;
  private boolean cUO = true;
  private boolean crk = true;
  private boolean csX = true;
  private boolean csZ = true;
  private boolean csa = true;
  private boolean ctI = true;
  private boolean cta = true;
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
    cHJ = "localId".hashCode();
    cUP = "recordLocalId".hashCode();
    cIe = "toUser".hashCode();
    cHA = "dataId".hashCode();
    cto = "mediaId".hashCode();
    ctM = "path".hashCode();
    cFT = "cdnUrl".hashCode();
    cHC = "cdnKey".hashCode();
    ctq = "totalLen".hashCode();
    cUQ = "isThumb".hashCode();
    ctr = "offset".hashCode();
    csy = "type".hashCode();
    cJi = "fileType".hashCode();
    crn = "status".hashCode();
    cJr = "errCode".hashCode();
    cUR = "tpaeskey".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cHJ != k) {
        break label65;
      }
      this.field_localId = paramCursor.getInt(i);
      this.cHH = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cUP == k)
      {
        this.field_recordLocalId = paramCursor.getInt(i);
      }
      else if (cIe == k)
      {
        this.field_toUser = paramCursor.getString(i);
      }
      else if (cHA == k)
      {
        this.field_dataId = paramCursor.getString(i);
      }
      else if (cto == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (ctM == k)
      {
        this.field_path = paramCursor.getString(i);
      }
      else if (cFT == k)
      {
        this.field_cdnUrl = paramCursor.getString(i);
      }
      else if (cHC == k)
      {
        this.field_cdnKey = paramCursor.getString(i);
      }
      else if (ctq == k)
      {
        this.field_totalLen = paramCursor.getInt(i);
      }
      else
      {
        if (cUQ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isThumb = bool;
            break;
          }
        }
        if (ctr == k) {
          this.field_offset = paramCursor.getInt(i);
        } else if (csy == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (cJi == k) {
          this.field_fileType = paramCursor.getInt(i);
        } else if (crn == k) {
          this.field_status = paramCursor.getInt(i);
        } else if (cJr == k) {
          this.field_errCode = paramCursor.getInt(i);
        } else if (cUR == k) {
          this.field_tpaeskey = paramCursor.getString(i);
        } else if (cGc == k) {
          this.field_tpauthkey = paramCursor.getString(i);
        } else if (cUS == k) {
          this.field_tpdataurl = paramCursor.getString(i);
        } else if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cHH) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.cUL) {
      localContentValues.put("recordLocalId", Integer.valueOf(this.field_recordLocalId));
    }
    if (this.field_toUser == null) {
      this.field_toUser = "";
    }
    if (this.cHR) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.cHv) {
      localContentValues.put("dataId", this.field_dataId);
    }
    if (this.csX) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.ctI) {
      localContentValues.put("path", this.field_path);
    }
    if (this.cFq) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.cHx) {
      localContentValues.put("cdnKey", this.field_cdnKey);
    }
    if (this.csZ) {
      localContentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
    }
    if (this.cUM) {
      localContentValues.put("isThumb", Boolean.valueOf(this.field_isThumb));
    }
    if (this.cta) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.csa) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.cIN) {
      localContentValues.put("fileType", Integer.valueOf(this.field_fileType));
    }
    if (this.crk) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.cIW) {
      localContentValues.put("errCode", Integer.valueOf(this.field_errCode));
    }
    if (this.cUN) {
      localContentValues.put("tpaeskey", this.field_tpaeskey);
    }
    if (this.cFz) {
      localContentValues.put("tpauthkey", this.field_tpauthkey);
    }
    if (this.cUO) {
      localContentValues.put("tpdataurl", this.field_tpdataurl);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.h.c.do
 * JD-Core Version:    0.7.0.1
 */