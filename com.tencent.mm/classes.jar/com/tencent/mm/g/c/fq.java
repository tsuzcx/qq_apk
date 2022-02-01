package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fq
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS record_localid_index ON RecordCDNInfo(recordLocalId)" };
  private static final int fAT;
  private static final int fAq;
  private static final int fAs;
  private static final int fCA;
  private static final int fCr;
  private static final int fVZ;
  private static final int fWa;
  private static final int fWb;
  private static final int fWc = "tpdataurl".hashCode();
  private static final int fjl;
  private static final int fkH;
  private static final int fkm;
  private static final int fko;
  private static final int fkp;
  private static final int fyF;
  private static final int fyw;
  private static final int localId_HASHCODE = "localId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSetlocalId = true;
  private boolean __hadSettype = true;
  private boolean fAF = true;
  private boolean fAl = true;
  private boolean fAn = true;
  private boolean fBN = true;
  private boolean fBW = true;
  private boolean fVV = true;
  private boolean fVW = true;
  private boolean fVX = true;
  private boolean fVY = true;
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
  private boolean fjV = true;
  private boolean fjX = true;
  private boolean fjY = true;
  private boolean fji = true;
  private boolean fkD = true;
  private boolean fxK = true;
  private boolean fxT = true;
  
  static
  {
    fVZ = "recordLocalId".hashCode();
    fAT = "toUser".hashCode();
    fAq = "dataId".hashCode();
    fkm = "mediaId".hashCode();
    fkH = "path".hashCode();
    fyw = "cdnUrl".hashCode();
    fAs = "cdnKey".hashCode();
    fko = "totalLen".hashCode();
    fWa = "isThumb".hashCode();
    fkp = "offset".hashCode();
    type_HASHCODE = "type".hashCode();
    fCr = "fileType".hashCode();
    fjl = "status".hashCode();
    fCA = "errCode".hashCode();
    fWb = "tpaeskey".hashCode();
    fyF = "tpauthkey".hashCode();
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
      if (fVZ == k)
      {
        this.field_recordLocalId = paramCursor.getInt(i);
      }
      else if (fAT == k)
      {
        this.field_toUser = paramCursor.getString(i);
      }
      else if (fAq == k)
      {
        this.field_dataId = paramCursor.getString(i);
      }
      else if (fkm == k)
      {
        this.field_mediaId = paramCursor.getString(i);
      }
      else if (fkH == k)
      {
        this.field_path = paramCursor.getString(i);
      }
      else if (fyw == k)
      {
        this.field_cdnUrl = paramCursor.getString(i);
      }
      else if (fAs == k)
      {
        this.field_cdnKey = paramCursor.getString(i);
      }
      else if (fko == k)
      {
        this.field_totalLen = paramCursor.getInt(i);
      }
      else
      {
        if (fWa == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isThumb = bool;
            break;
          }
        }
        if (fkp == k) {
          this.field_offset = paramCursor.getInt(i);
        } else if (type_HASHCODE == k) {
          this.field_type = paramCursor.getInt(i);
        } else if (fCr == k) {
          this.field_fileType = paramCursor.getInt(i);
        } else if (fjl == k) {
          this.field_status = paramCursor.getInt(i);
        } else if (fCA == k) {
          this.field_errCode = paramCursor.getInt(i);
        } else if (fWb == k) {
          this.field_tpaeskey = paramCursor.getString(i);
        } else if (fyF == k) {
          this.field_tpauthkey = paramCursor.getString(i);
        } else if (fWc == k) {
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
    if (this.fVV) {
      localContentValues.put("recordLocalId", Integer.valueOf(this.field_recordLocalId));
    }
    if (this.field_toUser == null) {
      this.field_toUser = "";
    }
    if (this.fAF) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.fAl) {
      localContentValues.put("dataId", this.field_dataId);
    }
    if (this.fjV) {
      localContentValues.put("mediaId", this.field_mediaId);
    }
    if (this.fkD) {
      localContentValues.put("path", this.field_path);
    }
    if (this.fxK) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.fAn) {
      localContentValues.put("cdnKey", this.field_cdnKey);
    }
    if (this.fjX) {
      localContentValues.put("totalLen", Integer.valueOf(this.field_totalLen));
    }
    if (this.fVW) {
      localContentValues.put("isThumb", Boolean.valueOf(this.field_isThumb));
    }
    if (this.fjY) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.fBN) {
      localContentValues.put("fileType", Integer.valueOf(this.field_fileType));
    }
    if (this.fji) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fBW) {
      localContentValues.put("errCode", Integer.valueOf(this.field_errCode));
    }
    if (this.fVX) {
      localContentValues.put("tpaeskey", this.field_tpaeskey);
    }
    if (this.fxT) {
      localContentValues.put("tpauthkey", this.field_tpauthkey);
    }
    if (this.fVY) {
      localContentValues.put("tpdataurl", this.field_tpdataurl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fq
 * JD-Core Version:    0.7.0.1
 */