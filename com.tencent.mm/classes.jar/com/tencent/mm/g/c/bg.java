package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bg
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS emojiGroupIndex ON EmojiInfo(catalog)" };
  private static final int elb;
  private static final int emB;
  private static final int eni;
  private static final int exY;
  private static final int eyX = "md5".hashCode();
  private static final int eyY = "svrid".hashCode();
  private static final int eyZ = "catalog".hashCode();
  private static final int eyc;
  private static final int ezA = "captureStatus".hashCode();
  private static final int ezB = "attachedEmojiMD5".hashCode();
  private static final int ezC = "imitateMd5".hashCode();
  private static final int ezD = "captureUploadErrCode".hashCode();
  private static final int ezE = "captureUploadCounter".hashCode();
  private static final int ezF = "captureEnterTime".hashCode();
  private static final int ezG = "lensId".hashCode();
  private static final int ezH = "attachTextColor".hashCode();
  private static final int ezI = "captureScene".hashCode();
  private static final int eza;
  private static final int ezb;
  private static final int ezc;
  private static final int ezd;
  private static final int eze;
  private static final int ezf;
  private static final int ezg;
  private static final int ezh;
  private static final int ezi;
  private static final int ezj;
  private static final int ezk;
  private static final int ezl;
  private static final int ezm;
  private static final int ezn;
  private static final int ezo;
  private static final int ezp;
  private static final int ezq;
  private static final int ezr;
  private static final int ezs;
  private static final int ezt;
  private static final int ezu;
  private static final int ezv;
  private static final int ezw;
  private static final int ezx;
  private static final int ezy;
  private static final int ezz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean ekE = true;
  private boolean emz = true;
  private boolean enc = true;
  private boolean exC = true;
  private boolean exy = true;
  private boolean eyA = true;
  private boolean eyB = true;
  private boolean eyC = true;
  private boolean eyD = true;
  private boolean eyE = true;
  private boolean eyF = true;
  private boolean eyG = true;
  private boolean eyH = true;
  private boolean eyI = true;
  private boolean eyJ = true;
  private boolean eyK = true;
  private boolean eyL = true;
  private boolean eyM = true;
  private boolean eyN = true;
  private boolean eyO = true;
  private boolean eyP = true;
  private boolean eyQ = true;
  private boolean eyR = true;
  private boolean eyS = true;
  private boolean eyT = true;
  private boolean eyU = true;
  private boolean eyV = true;
  private boolean eyW = true;
  private boolean eyl = true;
  private boolean eym = true;
  private boolean eyn = true;
  private boolean eyo = true;
  private boolean eyp = true;
  private boolean eyq = true;
  private boolean eyr = true;
  private boolean eys = true;
  private boolean eyt = true;
  private boolean eyu = true;
  private boolean eyv = true;
  private boolean eyw = true;
  private boolean eyx = true;
  private boolean eyy = true;
  private boolean eyz = true;
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
    emB = "size".hashCode();
    eza = "start".hashCode();
    ezb = "state".hashCode();
    ezc = "name".hashCode();
    elb = "content".hashCode();
    ezd = "reserved1".hashCode();
    eze = "reserved2".hashCode();
    ezf = "reserved3".hashCode();
    ezg = "reserved4".hashCode();
    ezh = "app_id".hashCode();
    ezi = "groupId".hashCode();
    exY = "lastUseTime".hashCode();
    ezj = "framesInfo".hashCode();
    eyc = "idx".hashCode();
    ezk = "temp".hashCode();
    eni = "source".hashCode();
    ezl = "needupload".hashCode();
    ezm = "designerID".hashCode();
    ezn = "thumbUrl".hashCode();
    ezo = "cdnUrl".hashCode();
    ezp = "encrypturl".hashCode();
    ezq = "aeskey".hashCode();
    ezr = "width".hashCode();
    ezs = "height".hashCode();
    ezt = "externUrl".hashCode();
    ezu = "externMd5".hashCode();
    ezv = "activityid".hashCode();
    ezw = "tpurl".hashCode();
    ezx = "tpauthkey".hashCode();
    ezy = "wxamMd5".hashCode();
    ezz = "attachedText".hashCode();
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
      if (eyX != k) {
        break label65;
      }
      this.field_md5 = paramCursor.getString(i);
      this.eyl = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eyY == k) {
        this.field_svrid = paramCursor.getString(i);
      } else if (eyZ == k) {
        this.field_catalog = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (emB == k) {
        this.field_size = paramCursor.getInt(i);
      } else if (eza == k) {
        this.field_start = paramCursor.getInt(i);
      } else if (ezb == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (ezc == k) {
        this.field_name = paramCursor.getString(i);
      } else if (elb == k) {
        this.field_content = paramCursor.getString(i);
      } else if (ezd == k) {
        this.field_reserved1 = paramCursor.getString(i);
      } else if (eze == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (ezf == k) {
        this.field_reserved3 = paramCursor.getInt(i);
      } else if (ezg == k) {
        this.field_reserved4 = paramCursor.getInt(i);
      } else if (ezh == k) {
        this.field_app_id = paramCursor.getString(i);
      } else if (ezi == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (exY == k) {
        this.field_lastUseTime = paramCursor.getLong(i);
      } else if (ezj == k) {
        this.field_framesInfo = paramCursor.getString(i);
      } else if (eyc == k) {
        this.field_idx = paramCursor.getInt(i);
      } else if (ezk == k) {
        this.field_temp = paramCursor.getInt(i);
      } else if (eni == k) {
        this.field_source = paramCursor.getInt(i);
      } else if (ezl == k) {
        this.field_needupload = paramCursor.getInt(i);
      } else if (ezm == k) {
        this.field_designerID = paramCursor.getString(i);
      } else if (ezn == k) {
        this.field_thumbUrl = paramCursor.getString(i);
      } else if (ezo == k) {
        this.field_cdnUrl = paramCursor.getString(i);
      } else if (ezp == k) {
        this.field_encrypturl = paramCursor.getString(i);
      } else if (ezq == k) {
        this.field_aeskey = paramCursor.getString(i);
      } else if (ezr == k) {
        this.field_width = paramCursor.getInt(i);
      } else if (ezs == k) {
        this.field_height = paramCursor.getInt(i);
      } else if (ezt == k) {
        this.field_externUrl = paramCursor.getString(i);
      } else if (ezu == k) {
        this.field_externMd5 = paramCursor.getString(i);
      } else if (ezv == k) {
        this.field_activityid = paramCursor.getString(i);
      } else if (ezw == k) {
        this.field_tpurl = paramCursor.getString(i);
      } else if (ezx == k) {
        this.field_tpauthkey = paramCursor.getString(i);
      } else if (ezy == k) {
        this.field_wxamMd5 = paramCursor.getString(i);
      } else if (ezz == k) {
        this.field_attachedText = paramCursor.getString(i);
      } else if (ezA == k) {
        this.field_captureStatus = paramCursor.getInt(i);
      } else if (ezB == k) {
        this.field_attachedEmojiMD5 = paramCursor.getBlob(i);
      } else if (ezC == k) {
        this.field_imitateMd5 = paramCursor.getString(i);
      } else if (ezD == k) {
        this.field_captureUploadErrCode = paramCursor.getInt(i);
      } else if (ezE == k) {
        this.field_captureUploadCounter = paramCursor.getInt(i);
      } else if (ezF == k) {
        this.field_captureEnterTime = paramCursor.getLong(i);
      } else if (ezG == k) {
        this.field_lensId = paramCursor.getString(i);
      } else if (ezH == k) {
        this.field_attachTextColor = paramCursor.getString(i);
      } else if (ezI == k) {
        this.field_captureScene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eyl) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.eym) {
      localContentValues.put("svrid", this.field_svrid);
    }
    if (this.eyn) {
      localContentValues.put("catalog", Integer.valueOf(this.field_catalog));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.emz) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.eyo) {
      localContentValues.put("start", Integer.valueOf(this.field_start));
    }
    if (this.eyp) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.eyq) {
      localContentValues.put("name", this.field_name);
    }
    if (this.ekE) {
      localContentValues.put("content", this.field_content);
    }
    if (this.eyr) {
      localContentValues.put("reserved1", this.field_reserved1);
    }
    if (this.eys) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.eyt) {
      localContentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
    }
    if (this.eyu) {
      localContentValues.put("reserved4", Integer.valueOf(this.field_reserved4));
    }
    if (this.eyv) {
      localContentValues.put("app_id", this.field_app_id);
    }
    if (this.field_groupId == null) {
      this.field_groupId = "";
    }
    if (this.eyw) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.exy) {
      localContentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
    }
    if (this.field_framesInfo == null) {
      this.field_framesInfo = "";
    }
    if (this.eyx) {
      localContentValues.put("framesInfo", this.field_framesInfo);
    }
    if (this.exC) {
      localContentValues.put("idx", Integer.valueOf(this.field_idx));
    }
    if (this.eyy) {
      localContentValues.put("temp", Integer.valueOf(this.field_temp));
    }
    if (this.enc) {
      localContentValues.put("source", Integer.valueOf(this.field_source));
    }
    if (this.eyz) {
      localContentValues.put("needupload", Integer.valueOf(this.field_needupload));
    }
    if (this.eyA) {
      localContentValues.put("designerID", this.field_designerID);
    }
    if (this.eyB) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.eyC) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.eyD) {
      localContentValues.put("encrypturl", this.field_encrypturl);
    }
    if (this.eyE) {
      localContentValues.put("aeskey", this.field_aeskey);
    }
    if (this.eyF) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.eyG) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.eyH) {
      localContentValues.put("externUrl", this.field_externUrl);
    }
    if (this.eyI) {
      localContentValues.put("externMd5", this.field_externMd5);
    }
    if (this.eyJ) {
      localContentValues.put("activityid", this.field_activityid);
    }
    if (this.eyK) {
      localContentValues.put("tpurl", this.field_tpurl);
    }
    if (this.eyL) {
      localContentValues.put("tpauthkey", this.field_tpauthkey);
    }
    if (this.eyM) {
      localContentValues.put("wxamMd5", this.field_wxamMd5);
    }
    if (this.eyN) {
      localContentValues.put("attachedText", this.field_attachedText);
    }
    if (this.eyO) {
      localContentValues.put("captureStatus", Integer.valueOf(this.field_captureStatus));
    }
    if (this.eyP) {
      localContentValues.put("attachedEmojiMD5", this.field_attachedEmojiMD5);
    }
    if (this.eyQ) {
      localContentValues.put("imitateMd5", this.field_imitateMd5);
    }
    if (this.eyR) {
      localContentValues.put("captureUploadErrCode", Integer.valueOf(this.field_captureUploadErrCode));
    }
    if (this.eyS) {
      localContentValues.put("captureUploadCounter", Integer.valueOf(this.field_captureUploadCounter));
    }
    if (this.eyT) {
      localContentValues.put("captureEnterTime", Long.valueOf(this.field_captureEnterTime));
    }
    if (this.eyU) {
      localContentValues.put("lensId", this.field_lensId);
    }
    if (this.eyV) {
      localContentValues.put("attachTextColor", this.field_attachTextColor);
    }
    if (this.eyW) {
      localContentValues.put("captureScene", Integer.valueOf(this.field_captureScene));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.bg
 * JD-Core Version:    0.7.0.1
 */