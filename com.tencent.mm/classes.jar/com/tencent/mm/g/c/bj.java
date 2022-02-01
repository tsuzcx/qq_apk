package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bj
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS emojiGroupIndex ON EmojiInfo(catalog)" };
  private static final int content_HASHCODE;
  private static final int fkX;
  private static final int flH;
  private static final int fxh;
  private static final int fxl;
  private static final int fyA = "height".hashCode();
  private static final int fyB = "externUrl".hashCode();
  private static final int fyC = "externMd5".hashCode();
  private static final int fyD = "activityid".hashCode();
  private static final int fyE = "tpurl".hashCode();
  private static final int fyF = "tpauthkey".hashCode();
  private static final int fyG = "wxamMd5".hashCode();
  private static final int fyH = "attachedText".hashCode();
  private static final int fyI = "captureStatus".hashCode();
  private static final int fyJ = "attachedEmojiMD5".hashCode();
  private static final int fyK = "imitateMd5".hashCode();
  private static final int fyL = "captureUploadErrCode".hashCode();
  private static final int fyM = "captureUploadCounter".hashCode();
  private static final int fyN = "captureEnterTime".hashCode();
  private static final int fyO = "lensId".hashCode();
  private static final int fyP = "attachTextColor".hashCode();
  private static final int fyQ = "captureScene".hashCode();
  private static final int fyf = "md5".hashCode();
  private static final int fyg = "svrid".hashCode();
  private static final int fyh = "catalog".hashCode();
  private static final int fyi;
  private static final int fyj;
  private static final int fyk;
  private static final int fyl;
  private static final int fym;
  private static final int fyn;
  private static final int fyo;
  private static final int fyp;
  private static final int fyq;
  private static final int fyr;
  private static final int fys;
  private static final int fyt;
  private static final int fyu;
  private static final int fyv;
  private static final int fyw;
  private static final int fyx;
  private static final int fyy;
  private static final int fyz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSetcontent = true;
  private boolean __hadSettype = true;
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
  private boolean fkV = true;
  private boolean flC = true;
  private boolean fwH = true;
  private boolean fwL = true;
  private boolean fxA = true;
  private boolean fxB = true;
  private boolean fxC = true;
  private boolean fxD = true;
  private boolean fxE = true;
  private boolean fxF = true;
  private boolean fxG = true;
  private boolean fxH = true;
  private boolean fxI = true;
  private boolean fxJ = true;
  private boolean fxK = true;
  private boolean fxL = true;
  private boolean fxM = true;
  private boolean fxN = true;
  private boolean fxO = true;
  private boolean fxP = true;
  private boolean fxQ = true;
  private boolean fxR = true;
  private boolean fxS = true;
  private boolean fxT = true;
  private boolean fxU = true;
  private boolean fxV = true;
  private boolean fxW = true;
  private boolean fxX = true;
  private boolean fxY = true;
  private boolean fxZ = true;
  private boolean fxt = true;
  private boolean fxu = true;
  private boolean fxv = true;
  private boolean fxw = true;
  private boolean fxx = true;
  private boolean fxy = true;
  private boolean fxz = true;
  private boolean fya = true;
  private boolean fyb = true;
  private boolean fyc = true;
  private boolean fyd = true;
  private boolean fye = true;
  
  static
  {
    fkX = "size".hashCode();
    fyi = "start".hashCode();
    fyj = "state".hashCode();
    fyk = "name".hashCode();
    content_HASHCODE = "content".hashCode();
    fyl = "reserved1".hashCode();
    fym = "reserved2".hashCode();
    fyn = "reserved3".hashCode();
    fyo = "reserved4".hashCode();
    fyp = "app_id".hashCode();
    fyq = "groupId".hashCode();
    fxh = "lastUseTime".hashCode();
    fyr = "framesInfo".hashCode();
    fxl = "idx".hashCode();
    fys = "temp".hashCode();
    flH = "source".hashCode();
    fyt = "needupload".hashCode();
    fyu = "designerID".hashCode();
    fyv = "thumbUrl".hashCode();
    fyw = "cdnUrl".hashCode();
    fyx = "encrypturl".hashCode();
    fyy = "aeskey".hashCode();
    fyz = "width".hashCode();
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
      if (fyf != k) {
        break label65;
      }
      this.field_md5 = paramCursor.getString(i);
      this.fxt = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fyg == k) {
        this.field_svrid = paramCursor.getString(i);
      } else if (fyh == k) {
        this.field_catalog = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (fkX == k) {
        this.field_size = paramCursor.getInt(i);
      } else if (fyi == k) {
        this.field_start = paramCursor.getInt(i);
      } else if (fyj == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (fyk == k) {
        this.field_name = paramCursor.getString(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (fyl == k) {
        this.field_reserved1 = paramCursor.getString(i);
      } else if (fym == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (fyn == k) {
        this.field_reserved3 = paramCursor.getInt(i);
      } else if (fyo == k) {
        this.field_reserved4 = paramCursor.getInt(i);
      } else if (fyp == k) {
        this.field_app_id = paramCursor.getString(i);
      } else if (fyq == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (fxh == k) {
        this.field_lastUseTime = paramCursor.getLong(i);
      } else if (fyr == k) {
        this.field_framesInfo = paramCursor.getString(i);
      } else if (fxl == k) {
        this.field_idx = paramCursor.getInt(i);
      } else if (fys == k) {
        this.field_temp = paramCursor.getInt(i);
      } else if (flH == k) {
        this.field_source = paramCursor.getInt(i);
      } else if (fyt == k) {
        this.field_needupload = paramCursor.getInt(i);
      } else if (fyu == k) {
        this.field_designerID = paramCursor.getString(i);
      } else if (fyv == k) {
        this.field_thumbUrl = paramCursor.getString(i);
      } else if (fyw == k) {
        this.field_cdnUrl = paramCursor.getString(i);
      } else if (fyx == k) {
        this.field_encrypturl = paramCursor.getString(i);
      } else if (fyy == k) {
        this.field_aeskey = paramCursor.getString(i);
      } else if (fyz == k) {
        this.field_width = paramCursor.getInt(i);
      } else if (fyA == k) {
        this.field_height = paramCursor.getInt(i);
      } else if (fyB == k) {
        this.field_externUrl = paramCursor.getString(i);
      } else if (fyC == k) {
        this.field_externMd5 = paramCursor.getString(i);
      } else if (fyD == k) {
        this.field_activityid = paramCursor.getString(i);
      } else if (fyE == k) {
        this.field_tpurl = paramCursor.getString(i);
      } else if (fyF == k) {
        this.field_tpauthkey = paramCursor.getString(i);
      } else if (fyG == k) {
        this.field_wxamMd5 = paramCursor.getString(i);
      } else if (fyH == k) {
        this.field_attachedText = paramCursor.getString(i);
      } else if (fyI == k) {
        this.field_captureStatus = paramCursor.getInt(i);
      } else if (fyJ == k) {
        this.field_attachedEmojiMD5 = paramCursor.getBlob(i);
      } else if (fyK == k) {
        this.field_imitateMd5 = paramCursor.getString(i);
      } else if (fyL == k) {
        this.field_captureUploadErrCode = paramCursor.getInt(i);
      } else if (fyM == k) {
        this.field_captureUploadCounter = paramCursor.getInt(i);
      } else if (fyN == k) {
        this.field_captureEnterTime = paramCursor.getLong(i);
      } else if (fyO == k) {
        this.field_lensId = paramCursor.getString(i);
      } else if (fyP == k) {
        this.field_attachTextColor = paramCursor.getString(i);
      } else if (fyQ == k) {
        this.field_captureScene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fxt) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.fxu) {
      localContentValues.put("svrid", this.field_svrid);
    }
    if (this.fxv) {
      localContentValues.put("catalog", Integer.valueOf(this.field_catalog));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.fkV) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.fxw) {
      localContentValues.put("start", Integer.valueOf(this.field_start));
    }
    if (this.fxx) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.fxy) {
      localContentValues.put("name", this.field_name);
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.fxz) {
      localContentValues.put("reserved1", this.field_reserved1);
    }
    if (this.fxA) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.fxB) {
      localContentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
    }
    if (this.fxC) {
      localContentValues.put("reserved4", Integer.valueOf(this.field_reserved4));
    }
    if (this.fxD) {
      localContentValues.put("app_id", this.field_app_id);
    }
    if (this.field_groupId == null) {
      this.field_groupId = "";
    }
    if (this.fxE) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.fwH) {
      localContentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
    }
    if (this.field_framesInfo == null) {
      this.field_framesInfo = "";
    }
    if (this.fxF) {
      localContentValues.put("framesInfo", this.field_framesInfo);
    }
    if (this.fwL) {
      localContentValues.put("idx", Integer.valueOf(this.field_idx));
    }
    if (this.fxG) {
      localContentValues.put("temp", Integer.valueOf(this.field_temp));
    }
    if (this.flC) {
      localContentValues.put("source", Integer.valueOf(this.field_source));
    }
    if (this.fxH) {
      localContentValues.put("needupload", Integer.valueOf(this.field_needupload));
    }
    if (this.fxI) {
      localContentValues.put("designerID", this.field_designerID);
    }
    if (this.fxJ) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.fxK) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.fxL) {
      localContentValues.put("encrypturl", this.field_encrypturl);
    }
    if (this.fxM) {
      localContentValues.put("aeskey", this.field_aeskey);
    }
    if (this.fxN) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.fxO) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.fxP) {
      localContentValues.put("externUrl", this.field_externUrl);
    }
    if (this.fxQ) {
      localContentValues.put("externMd5", this.field_externMd5);
    }
    if (this.fxR) {
      localContentValues.put("activityid", this.field_activityid);
    }
    if (this.fxS) {
      localContentValues.put("tpurl", this.field_tpurl);
    }
    if (this.fxT) {
      localContentValues.put("tpauthkey", this.field_tpauthkey);
    }
    if (this.fxU) {
      localContentValues.put("wxamMd5", this.field_wxamMd5);
    }
    if (this.fxV) {
      localContentValues.put("attachedText", this.field_attachedText);
    }
    if (this.fxW) {
      localContentValues.put("captureStatus", Integer.valueOf(this.field_captureStatus));
    }
    if (this.fxX) {
      localContentValues.put("attachedEmojiMD5", this.field_attachedEmojiMD5);
    }
    if (this.fxY) {
      localContentValues.put("imitateMd5", this.field_imitateMd5);
    }
    if (this.fxZ) {
      localContentValues.put("captureUploadErrCode", Integer.valueOf(this.field_captureUploadErrCode));
    }
    if (this.fya) {
      localContentValues.put("captureUploadCounter", Integer.valueOf(this.field_captureUploadCounter));
    }
    if (this.fyb) {
      localContentValues.put("captureEnterTime", Long.valueOf(this.field_captureEnterTime));
    }
    if (this.fyc) {
      localContentValues.put("lensId", this.field_lensId);
    }
    if (this.fyd) {
      localContentValues.put("attachTextColor", this.field_attachTextColor);
    }
    if (this.fye) {
      localContentValues.put("captureScene", Integer.valueOf(this.field_captureScene));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.bj
 * JD-Core Version:    0.7.0.1
 */