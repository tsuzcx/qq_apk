package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bb
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS emojiGroupIndex ON EmojiInfo(catalog)" };
  private static final int dgT;
  private static final int diK;
  private static final int dij;
  private static final int dsY;
  private static final int dtX = "md5".hashCode();
  private static final int dtY = "svrid".hashCode();
  private static final int dtZ = "catalog".hashCode();
  private static final int dtc;
  private static final int duA = "captureStatus".hashCode();
  private static final int duB = "attachedEmojiMD5".hashCode();
  private static final int duC = "imitateMd5".hashCode();
  private static final int duD = "captureUploadErrCode".hashCode();
  private static final int duE = "captureUploadCounter".hashCode();
  private static final int duF = "captureEnterTime".hashCode();
  private static final int duG = "lensId".hashCode();
  private static final int duH = "attachTextColor".hashCode();
  private static final int duI = "captureScene".hashCode();
  private static final int dua;
  private static final int dub;
  private static final int duc;
  private static final int dud;
  private static final int due;
  private static final int duf;
  private static final int dug;
  private static final int duh;
  private static final int dui;
  private static final int duj;
  private static final int duk;
  private static final int dul;
  private static final int dum;
  private static final int dun;
  private static final int duo;
  private static final int dup;
  private static final int duq;
  private static final int dur;
  private static final int dus;
  private static final int dut;
  private static final int duu;
  private static final int duv;
  private static final int duw;
  private static final int dux;
  private static final int duy;
  private static final int duz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean dgw = true;
  private boolean diH = true;
  private boolean dih = true;
  private boolean dsC = true;
  private boolean dsy = true;
  private boolean dtA = true;
  private boolean dtB = true;
  private boolean dtC = true;
  private boolean dtD = true;
  private boolean dtE = true;
  private boolean dtF = true;
  private boolean dtG = true;
  private boolean dtH = true;
  private boolean dtI = true;
  private boolean dtJ = true;
  private boolean dtK = true;
  private boolean dtL = true;
  private boolean dtM = true;
  private boolean dtN = true;
  private boolean dtO = true;
  private boolean dtP = true;
  private boolean dtQ = true;
  private boolean dtR = true;
  private boolean dtS = true;
  private boolean dtT = true;
  private boolean dtU = true;
  private boolean dtV = true;
  private boolean dtW = true;
  private boolean dtk = true;
  private boolean dtl = true;
  private boolean dtm = true;
  private boolean dtn = true;
  private boolean dto = true;
  private boolean dtp = true;
  private boolean dtq = true;
  private boolean dtr = true;
  private boolean dtt = true;
  private boolean dtu = true;
  private boolean dtv = true;
  private boolean dtw = true;
  private boolean dtx = true;
  private boolean dty = true;
  private boolean dtz = true;
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
    dij = "size".hashCode();
    dua = "start".hashCode();
    dub = "state".hashCode();
    duc = "name".hashCode();
    dgT = "content".hashCode();
    dud = "reserved1".hashCode();
    due = "reserved2".hashCode();
    duf = "reserved3".hashCode();
    dug = "reserved4".hashCode();
    duh = "app_id".hashCode();
    dui = "groupId".hashCode();
    dsY = "lastUseTime".hashCode();
    duj = "framesInfo".hashCode();
    dtc = "idx".hashCode();
    duk = "temp".hashCode();
    diK = "source".hashCode();
    dul = "needupload".hashCode();
    dum = "designerID".hashCode();
    dun = "thumbUrl".hashCode();
    duo = "cdnUrl".hashCode();
    dup = "encrypturl".hashCode();
    duq = "aeskey".hashCode();
    dur = "width".hashCode();
    dus = "height".hashCode();
    dut = "externUrl".hashCode();
    duu = "externMd5".hashCode();
    duv = "activityid".hashCode();
    duw = "tpurl".hashCode();
    dux = "tpauthkey".hashCode();
    duy = "wxamMd5".hashCode();
    duz = "attachedText".hashCode();
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
      if (dtX != k) {
        break label65;
      }
      this.field_md5 = paramCursor.getString(i);
      this.dtk = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dtY == k) {
        this.field_svrid = paramCursor.getString(i);
      } else if (dtZ == k) {
        this.field_catalog = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (dij == k) {
        this.field_size = paramCursor.getInt(i);
      } else if (dua == k) {
        this.field_start = paramCursor.getInt(i);
      } else if (dub == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (duc == k) {
        this.field_name = paramCursor.getString(i);
      } else if (dgT == k) {
        this.field_content = paramCursor.getString(i);
      } else if (dud == k) {
        this.field_reserved1 = paramCursor.getString(i);
      } else if (due == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (duf == k) {
        this.field_reserved3 = paramCursor.getInt(i);
      } else if (dug == k) {
        this.field_reserved4 = paramCursor.getInt(i);
      } else if (duh == k) {
        this.field_app_id = paramCursor.getString(i);
      } else if (dui == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (dsY == k) {
        this.field_lastUseTime = paramCursor.getLong(i);
      } else if (duj == k) {
        this.field_framesInfo = paramCursor.getString(i);
      } else if (dtc == k) {
        this.field_idx = paramCursor.getInt(i);
      } else if (duk == k) {
        this.field_temp = paramCursor.getInt(i);
      } else if (diK == k) {
        this.field_source = paramCursor.getInt(i);
      } else if (dul == k) {
        this.field_needupload = paramCursor.getInt(i);
      } else if (dum == k) {
        this.field_designerID = paramCursor.getString(i);
      } else if (dun == k) {
        this.field_thumbUrl = paramCursor.getString(i);
      } else if (duo == k) {
        this.field_cdnUrl = paramCursor.getString(i);
      } else if (dup == k) {
        this.field_encrypturl = paramCursor.getString(i);
      } else if (duq == k) {
        this.field_aeskey = paramCursor.getString(i);
      } else if (dur == k) {
        this.field_width = paramCursor.getInt(i);
      } else if (dus == k) {
        this.field_height = paramCursor.getInt(i);
      } else if (dut == k) {
        this.field_externUrl = paramCursor.getString(i);
      } else if (duu == k) {
        this.field_externMd5 = paramCursor.getString(i);
      } else if (duv == k) {
        this.field_activityid = paramCursor.getString(i);
      } else if (duw == k) {
        this.field_tpurl = paramCursor.getString(i);
      } else if (dux == k) {
        this.field_tpauthkey = paramCursor.getString(i);
      } else if (duy == k) {
        this.field_wxamMd5 = paramCursor.getString(i);
      } else if (duz == k) {
        this.field_attachedText = paramCursor.getString(i);
      } else if (duA == k) {
        this.field_captureStatus = paramCursor.getInt(i);
      } else if (duB == k) {
        this.field_attachedEmojiMD5 = paramCursor.getBlob(i);
      } else if (duC == k) {
        this.field_imitateMd5 = paramCursor.getString(i);
      } else if (duD == k) {
        this.field_captureUploadErrCode = paramCursor.getInt(i);
      } else if (duE == k) {
        this.field_captureUploadCounter = paramCursor.getInt(i);
      } else if (duF == k) {
        this.field_captureEnterTime = paramCursor.getLong(i);
      } else if (duG == k) {
        this.field_lensId = paramCursor.getString(i);
      } else if (duH == k) {
        this.field_attachTextColor = paramCursor.getString(i);
      } else if (duI == k) {
        this.field_captureScene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dtk) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.dtl) {
      localContentValues.put("svrid", this.field_svrid);
    }
    if (this.dtm) {
      localContentValues.put("catalog", Integer.valueOf(this.field_catalog));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.dih) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.dtn) {
      localContentValues.put("start", Integer.valueOf(this.field_start));
    }
    if (this.dto) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.dtp) {
      localContentValues.put("name", this.field_name);
    }
    if (this.dgw) {
      localContentValues.put("content", this.field_content);
    }
    if (this.dtq) {
      localContentValues.put("reserved1", this.field_reserved1);
    }
    if (this.dtr) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.dtt) {
      localContentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
    }
    if (this.dtu) {
      localContentValues.put("reserved4", Integer.valueOf(this.field_reserved4));
    }
    if (this.dtv) {
      localContentValues.put("app_id", this.field_app_id);
    }
    if (this.field_groupId == null) {
      this.field_groupId = "";
    }
    if (this.dtw) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.dsy) {
      localContentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
    }
    if (this.field_framesInfo == null) {
      this.field_framesInfo = "";
    }
    if (this.dtx) {
      localContentValues.put("framesInfo", this.field_framesInfo);
    }
    if (this.dsC) {
      localContentValues.put("idx", Integer.valueOf(this.field_idx));
    }
    if (this.dty) {
      localContentValues.put("temp", Integer.valueOf(this.field_temp));
    }
    if (this.diH) {
      localContentValues.put("source", Integer.valueOf(this.field_source));
    }
    if (this.dtz) {
      localContentValues.put("needupload", Integer.valueOf(this.field_needupload));
    }
    if (this.dtA) {
      localContentValues.put("designerID", this.field_designerID);
    }
    if (this.dtB) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.dtC) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.dtD) {
      localContentValues.put("encrypturl", this.field_encrypturl);
    }
    if (this.dtE) {
      localContentValues.put("aeskey", this.field_aeskey);
    }
    if (this.dtF) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.dtG) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.dtH) {
      localContentValues.put("externUrl", this.field_externUrl);
    }
    if (this.dtI) {
      localContentValues.put("externMd5", this.field_externMd5);
    }
    if (this.dtJ) {
      localContentValues.put("activityid", this.field_activityid);
    }
    if (this.dtK) {
      localContentValues.put("tpurl", this.field_tpurl);
    }
    if (this.dtL) {
      localContentValues.put("tpauthkey", this.field_tpauthkey);
    }
    if (this.dtM) {
      localContentValues.put("wxamMd5", this.field_wxamMd5);
    }
    if (this.dtN) {
      localContentValues.put("attachedText", this.field_attachedText);
    }
    if (this.dtO) {
      localContentValues.put("captureStatus", Integer.valueOf(this.field_captureStatus));
    }
    if (this.dtP) {
      localContentValues.put("attachedEmojiMD5", this.field_attachedEmojiMD5);
    }
    if (this.dtQ) {
      localContentValues.put("imitateMd5", this.field_imitateMd5);
    }
    if (this.dtR) {
      localContentValues.put("captureUploadErrCode", Integer.valueOf(this.field_captureUploadErrCode));
    }
    if (this.dtS) {
      localContentValues.put("captureUploadCounter", Integer.valueOf(this.field_captureUploadCounter));
    }
    if (this.dtT) {
      localContentValues.put("captureEnterTime", Long.valueOf(this.field_captureEnterTime));
    }
    if (this.dtU) {
      localContentValues.put("lensId", this.field_lensId);
    }
    if (this.dtV) {
      localContentValues.put("attachTextColor", this.field_attachTextColor);
    }
    if (this.dtW) {
      localContentValues.put("captureScene", Integer.valueOf(this.field_captureScene));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.bb
 * JD-Core Version:    0.7.0.1
 */