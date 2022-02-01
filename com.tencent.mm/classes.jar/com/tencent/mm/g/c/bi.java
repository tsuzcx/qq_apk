package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bi
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS emojiGroupIndex ON EmojiInfo(catalog)" };
  private static final int eFV;
  private static final int eHv;
  private static final int eIf = "source".hashCode();
  private static final int eTC;
  private static final int eTG;
  private static final int eUA = "md5".hashCode();
  private static final int eUB = "svrid".hashCode();
  private static final int eUC = "catalog".hashCode();
  private static final int eUD;
  private static final int eUE;
  private static final int eUF;
  private static final int eUG;
  private static final int eUH;
  private static final int eUI;
  private static final int eUJ;
  private static final int eUK;
  private static final int eUL;
  private static final int eUM;
  private static final int eUN;
  private static final int eUO = "needupload".hashCode();
  private static final int eUP = "designerID".hashCode();
  private static final int eUQ = "thumbUrl".hashCode();
  private static final int eUR = "cdnUrl".hashCode();
  private static final int eUS = "encrypturl".hashCode();
  private static final int eUT = "aeskey".hashCode();
  private static final int eUU = "width".hashCode();
  private static final int eUV = "height".hashCode();
  private static final int eUW = "externUrl".hashCode();
  private static final int eUX = "externMd5".hashCode();
  private static final int eUY = "activityid".hashCode();
  private static final int eUZ = "tpurl".hashCode();
  private static final int eVa = "tpauthkey".hashCode();
  private static final int eVb = "wxamMd5".hashCode();
  private static final int eVc = "attachedText".hashCode();
  private static final int eVd = "captureStatus".hashCode();
  private static final int eVe = "attachedEmojiMD5".hashCode();
  private static final int eVf = "imitateMd5".hashCode();
  private static final int eVg = "captureUploadErrCode".hashCode();
  private static final int eVh = "captureUploadCounter".hashCode();
  private static final int eVi = "captureEnterTime".hashCode();
  private static final int eVj = "lensId".hashCode();
  private static final int eVk = "attachTextColor".hashCode();
  private static final int eVl = "captureScene".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eFy = true;
  private boolean eHt = true;
  private boolean eIa = true;
  private boolean eTO = true;
  private boolean eTP = true;
  private boolean eTQ = true;
  private boolean eTR = true;
  private boolean eTS = true;
  private boolean eTT = true;
  private boolean eTU = true;
  private boolean eTV = true;
  private boolean eTW = true;
  private boolean eTX = true;
  private boolean eTY = true;
  private boolean eTZ = true;
  private boolean eTc = true;
  private boolean eTg = true;
  private boolean eUa = true;
  private boolean eUb = true;
  private boolean eUc = true;
  private boolean eUd = true;
  private boolean eUe = true;
  private boolean eUf = true;
  private boolean eUg = true;
  private boolean eUh = true;
  private boolean eUi = true;
  private boolean eUj = true;
  private boolean eUk = true;
  private boolean eUl = true;
  private boolean eUm = true;
  private boolean eUn = true;
  private boolean eUo = true;
  private boolean eUp = true;
  private boolean eUq = true;
  private boolean eUr = true;
  private boolean eUs = true;
  private boolean eUt = true;
  private boolean eUu = true;
  private boolean eUv = true;
  private boolean eUw = true;
  private boolean eUx = true;
  private boolean eUy = true;
  private boolean eUz = true;
  public String field_activityid;
  public String field_aeskey;
  public String field_app_id;
  public String field_attachTextColor;
  public byte[] field_attachedEmojiMD5;
  public String field_attachedText;
  public long field_captureEnterTime;
  public int field_captureScene;
  public int field_captureStatus;
  public int field_captureUploadCounter;
  public int field_captureUploadErrCode;
  public int field_catalog;
  public String field_cdnUrl;
  public String field_content;
  public String field_designerID;
  public String field_encrypturl;
  public String field_externMd5;
  public String field_externUrl;
  public String field_framesInfo;
  public String field_groupId;
  public int field_height;
  public int field_idx;
  public String field_imitateMd5;
  public long field_lastUseTime;
  public String field_lensId;
  public String field_md5;
  public String field_name;
  public int field_needupload;
  public String field_reserved1;
  public String field_reserved2;
  public int field_reserved3;
  public int field_reserved4;
  public int field_size;
  public int field_source;
  public int field_start;
  public int field_state;
  public String field_svrid;
  public int field_temp;
  public String field_thumbUrl;
  public String field_tpauthkey;
  public String field_tpurl;
  public int field_type;
  public int field_width;
  public String field_wxamMd5;
  
  static
  {
    eHv = "size".hashCode();
    eUD = "start".hashCode();
    eUE = "state".hashCode();
    eUF = "name".hashCode();
    eFV = "content".hashCode();
    eUG = "reserved1".hashCode();
    eUH = "reserved2".hashCode();
    eUI = "reserved3".hashCode();
    eUJ = "reserved4".hashCode();
    eUK = "app_id".hashCode();
    eUL = "groupId".hashCode();
    eTC = "lastUseTime".hashCode();
    eUM = "framesInfo".hashCode();
    eTG = "idx".hashCode();
    eUN = "temp".hashCode();
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (eUA != k) {
        break label65;
      }
      this.field_md5 = paramCursor.getString(i);
      this.eTO = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eUB == k) {
        this.field_svrid = paramCursor.getString(i);
      } else if (eUC == k) {
        this.field_catalog = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eHv == k) {
        this.field_size = paramCursor.getInt(i);
      } else if (eUD == k) {
        this.field_start = paramCursor.getInt(i);
      } else if (eUE == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (eUF == k) {
        this.field_name = paramCursor.getString(i);
      } else if (eFV == k) {
        this.field_content = paramCursor.getString(i);
      } else if (eUG == k) {
        this.field_reserved1 = paramCursor.getString(i);
      } else if (eUH == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (eUI == k) {
        this.field_reserved3 = paramCursor.getInt(i);
      } else if (eUJ == k) {
        this.field_reserved4 = paramCursor.getInt(i);
      } else if (eUK == k) {
        this.field_app_id = paramCursor.getString(i);
      } else if (eUL == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (eTC == k) {
        this.field_lastUseTime = paramCursor.getLong(i);
      } else if (eUM == k) {
        this.field_framesInfo = paramCursor.getString(i);
      } else if (eTG == k) {
        this.field_idx = paramCursor.getInt(i);
      } else if (eUN == k) {
        this.field_temp = paramCursor.getInt(i);
      } else if (eIf == k) {
        this.field_source = paramCursor.getInt(i);
      } else if (eUO == k) {
        this.field_needupload = paramCursor.getInt(i);
      } else if (eUP == k) {
        this.field_designerID = paramCursor.getString(i);
      } else if (eUQ == k) {
        this.field_thumbUrl = paramCursor.getString(i);
      } else if (eUR == k) {
        this.field_cdnUrl = paramCursor.getString(i);
      } else if (eUS == k) {
        this.field_encrypturl = paramCursor.getString(i);
      } else if (eUT == k) {
        this.field_aeskey = paramCursor.getString(i);
      } else if (eUU == k) {
        this.field_width = paramCursor.getInt(i);
      } else if (eUV == k) {
        this.field_height = paramCursor.getInt(i);
      } else if (eUW == k) {
        this.field_externUrl = paramCursor.getString(i);
      } else if (eUX == k) {
        this.field_externMd5 = paramCursor.getString(i);
      } else if (eUY == k) {
        this.field_activityid = paramCursor.getString(i);
      } else if (eUZ == k) {
        this.field_tpurl = paramCursor.getString(i);
      } else if (eVa == k) {
        this.field_tpauthkey = paramCursor.getString(i);
      } else if (eVb == k) {
        this.field_wxamMd5 = paramCursor.getString(i);
      } else if (eVc == k) {
        this.field_attachedText = paramCursor.getString(i);
      } else if (eVd == k) {
        this.field_captureStatus = paramCursor.getInt(i);
      } else if (eVe == k) {
        this.field_attachedEmojiMD5 = paramCursor.getBlob(i);
      } else if (eVf == k) {
        this.field_imitateMd5 = paramCursor.getString(i);
      } else if (eVg == k) {
        this.field_captureUploadErrCode = paramCursor.getInt(i);
      } else if (eVh == k) {
        this.field_captureUploadCounter = paramCursor.getInt(i);
      } else if (eVi == k) {
        this.field_captureEnterTime = paramCursor.getLong(i);
      } else if (eVj == k) {
        this.field_lensId = paramCursor.getString(i);
      } else if (eVk == k) {
        this.field_attachTextColor = paramCursor.getString(i);
      } else if (eVl == k) {
        this.field_captureScene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eTO) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.eTP) {
      localContentValues.put("svrid", this.field_svrid);
    }
    if (this.eTQ) {
      localContentValues.put("catalog", Integer.valueOf(this.field_catalog));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eHt) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.eTR) {
      localContentValues.put("start", Integer.valueOf(this.field_start));
    }
    if (this.eTS) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.eTT) {
      localContentValues.put("name", this.field_name);
    }
    if (this.eFy) {
      localContentValues.put("content", this.field_content);
    }
    if (this.eTU) {
      localContentValues.put("reserved1", this.field_reserved1);
    }
    if (this.eTV) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.eTW) {
      localContentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
    }
    if (this.eTX) {
      localContentValues.put("reserved4", Integer.valueOf(this.field_reserved4));
    }
    if (this.eTY) {
      localContentValues.put("app_id", this.field_app_id);
    }
    if (this.field_groupId == null) {
      this.field_groupId = "";
    }
    if (this.eTZ) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.eTc) {
      localContentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
    }
    if (this.field_framesInfo == null) {
      this.field_framesInfo = "";
    }
    if (this.eUa) {
      localContentValues.put("framesInfo", this.field_framesInfo);
    }
    if (this.eTg) {
      localContentValues.put("idx", Integer.valueOf(this.field_idx));
    }
    if (this.eUb) {
      localContentValues.put("temp", Integer.valueOf(this.field_temp));
    }
    if (this.eIa) {
      localContentValues.put("source", Integer.valueOf(this.field_source));
    }
    if (this.eUc) {
      localContentValues.put("needupload", Integer.valueOf(this.field_needupload));
    }
    if (this.eUd) {
      localContentValues.put("designerID", this.field_designerID);
    }
    if (this.eUe) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.eUf) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.eUg) {
      localContentValues.put("encrypturl", this.field_encrypturl);
    }
    if (this.eUh) {
      localContentValues.put("aeskey", this.field_aeskey);
    }
    if (this.eUi) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.eUj) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.eUk) {
      localContentValues.put("externUrl", this.field_externUrl);
    }
    if (this.eUl) {
      localContentValues.put("externMd5", this.field_externMd5);
    }
    if (this.eUm) {
      localContentValues.put("activityid", this.field_activityid);
    }
    if (this.eUn) {
      localContentValues.put("tpurl", this.field_tpurl);
    }
    if (this.eUo) {
      localContentValues.put("tpauthkey", this.field_tpauthkey);
    }
    if (this.eUp) {
      localContentValues.put("wxamMd5", this.field_wxamMd5);
    }
    if (this.eUq) {
      localContentValues.put("attachedText", this.field_attachedText);
    }
    if (this.eUr) {
      localContentValues.put("captureStatus", Integer.valueOf(this.field_captureStatus));
    }
    if (this.eUs) {
      localContentValues.put("attachedEmojiMD5", this.field_attachedEmojiMD5);
    }
    if (this.eUt) {
      localContentValues.put("imitateMd5", this.field_imitateMd5);
    }
    if (this.eUu) {
      localContentValues.put("captureUploadErrCode", Integer.valueOf(this.field_captureUploadErrCode));
    }
    if (this.eUv) {
      localContentValues.put("captureUploadCounter", Integer.valueOf(this.field_captureUploadCounter));
    }
    if (this.eUw) {
      localContentValues.put("captureEnterTime", Long.valueOf(this.field_captureEnterTime));
    }
    if (this.eUx) {
      localContentValues.put("lensId", this.field_lensId);
    }
    if (this.eUy) {
      localContentValues.put("attachTextColor", this.field_attachTextColor);
    }
    if (this.eUz) {
      localContentValues.put("captureScene", Integer.valueOf(this.field_captureScene));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bi
 * JD-Core Version:    0.7.0.1
 */