package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class bj
  extends IAutoDBItem
{
  public static final Column C_CONTENT;
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS emojiGroupIndex ON EmojiInfo(catalog)" };
  public static final SingleTable TABLE = new SingleTable("EmojiInfo");
  private static final int content_HASHCODE;
  public static final Column hFK;
  public static final Column hFO;
  private static final int hGK;
  private static final int hGO;
  public static final Column hGW;
  public static final Column hGX;
  public static final Column hGY;
  public static final Column hGZ;
  public static final Column hHA;
  public static final Column hHB;
  public static final Column hHC;
  public static final Column hHD;
  public static final Column hHE;
  public static final Column hHF;
  public static final Column hHG;
  public static final Column hHH;
  public static final Column hHI;
  public static final Column hHJ;
  public static final Column hHa;
  public static final Column hHb;
  public static final Column hHc;
  public static final Column hHd;
  public static final Column hHe;
  public static final Column hHf;
  public static final Column hHg;
  public static final Column hHh;
  public static final Column hHi;
  public static final Column hHj;
  public static final Column hHk;
  public static final Column hHl;
  public static final Column hHm;
  public static final Column hHn;
  public static final Column hHo;
  public static final Column hHp;
  public static final Column hHq;
  public static final Column hHr;
  public static final Column hHs;
  public static final Column hHt;
  public static final Column hHu;
  public static final Column hHv;
  public static final Column hHw;
  public static final Column hHx;
  public static final Column hHy;
  public static final Column hHz;
  private static final int hIA;
  private static final int hIB;
  private static final int hIC;
  private static final int hID;
  private static final int hIE;
  private static final int hIF;
  private static final int hIG;
  private static final int hIH;
  private static final int hII;
  private static final int hIJ;
  private static final int hIK;
  private static final int hIL;
  private static final int hIM = "needupload".hashCode();
  private static final int hIN = "designerID".hashCode();
  private static final int hIO = "thumbUrl".hashCode();
  private static final int hIP = "cdnUrl".hashCode();
  private static final int hIQ = "encrypturl".hashCode();
  private static final int hIR = "aeskey".hashCode();
  private static final int hIS = "width".hashCode();
  private static final int hIT = "height".hashCode();
  private static final int hIU = "externUrl".hashCode();
  private static final int hIV = "externMd5".hashCode();
  private static final int hIW = "activityid".hashCode();
  private static final int hIX = "tpurl".hashCode();
  private static final int hIY = "tpauthkey".hashCode();
  private static final int hIZ = "wxamMd5".hashCode();
  private static final int hIy;
  private static final int hIz;
  private static final int hJa = "attachedText".hashCode();
  private static final int hJb = "captureStatus".hashCode();
  private static final int hJc = "attachedEmojiMD5".hashCode();
  private static final int hJd = "imitateMd5".hashCode();
  private static final int hJe = "captureUploadErrCode".hashCode();
  private static final int hJf = "captureUploadCounter".hashCode();
  private static final int hJg = "captureEnterTime".hashCode();
  private static final int hJh = "lensId".hashCode();
  private static final int hJi = "attachTextColor".hashCode();
  private static final int hJj = "captureScene".hashCode();
  private static final int hJk = "attr".hashCode();
  private static final int hJl = "linkId".hashCode();
  public static final Column hpd;
  private static final int hph;
  public static final Column hqa;
  private static final int hqk;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSetcontent = true;
  private boolean __hadSettype = true;
  public String field_activityid;
  public String field_aeskey;
  public String field_app_id;
  public String field_attachTextColor;
  public byte[] field_attachedEmojiMD5;
  public String field_attachedText;
  public String field_attr;
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
  public String field_linkId;
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
  private boolean hGk = true;
  private boolean hGo = true;
  private boolean hHK = true;
  private boolean hHL = true;
  private boolean hHM = true;
  private boolean hHN = true;
  private boolean hHO = true;
  private boolean hHP = true;
  private boolean hHQ = true;
  private boolean hHR = true;
  private boolean hHS = true;
  private boolean hHT = true;
  private boolean hHU = true;
  private boolean hHV = true;
  private boolean hHW = true;
  private boolean hHX = true;
  private boolean hHY = true;
  private boolean hHZ = true;
  private boolean hIa = true;
  private boolean hIb = true;
  private boolean hIc = true;
  private boolean hId = true;
  private boolean hIe = true;
  private boolean hIf = true;
  private boolean hIg = true;
  private boolean hIh = true;
  private boolean hIi = true;
  private boolean hIj = true;
  private boolean hIk = true;
  private boolean hIl = true;
  private boolean hIm = true;
  private boolean hIn = true;
  private boolean hIo = true;
  private boolean hIp = true;
  private boolean hIq = true;
  private boolean hIr = true;
  private boolean hIs = true;
  private boolean hIt = true;
  private boolean hIu = true;
  private boolean hIv = true;
  private boolean hIw = true;
  private boolean hIx = true;
  private boolean hpf = true;
  private boolean hqf = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "EmojiInfo", "");
    hGW = new Column("md5", "string", "EmojiInfo", "");
    hGX = new Column("svrid", "string", "EmojiInfo", "");
    hGY = new Column("catalog", "int", "EmojiInfo", "");
    C_TYPE = new Column("type", "int", "EmojiInfo", "");
    hpd = new Column("size", "int", "EmojiInfo", "");
    hGZ = new Column("start", "int", "EmojiInfo", "");
    hHa = new Column("state", "int", "EmojiInfo", "");
    hHb = new Column("name", "string", "EmojiInfo", "");
    C_CONTENT = new Column("content", "string", "EmojiInfo", "");
    hHc = new Column("reserved1", "string", "EmojiInfo", "");
    hHd = new Column("reserved2", "string", "EmojiInfo", "");
    hHe = new Column("reserved3", "int", "EmojiInfo", "");
    hHf = new Column("reserved4", "int", "EmojiInfo", "");
    hHg = new Column("app_id", "string", "EmojiInfo", "");
    hHh = new Column("groupid", "string", "EmojiInfo", "");
    hFK = new Column("lastusetime", "long", "EmojiInfo", "");
    hHi = new Column("framesinfo", "string", "EmojiInfo", "");
    hFO = new Column("idx", "int", "EmojiInfo", "");
    hHj = new Column("temp", "int", "EmojiInfo", "");
    hqa = new Column("source", "int", "EmojiInfo", "");
    hHk = new Column("needupload", "int", "EmojiInfo", "");
    hHl = new Column("designerid", "string", "EmojiInfo", "");
    hHm = new Column("thumburl", "string", "EmojiInfo", "");
    hHn = new Column("cdnurl", "string", "EmojiInfo", "");
    hHo = new Column("encrypturl", "string", "EmojiInfo", "");
    hHp = new Column("aeskey", "string", "EmojiInfo", "");
    hHq = new Column("width", "int", "EmojiInfo", "");
    hHr = new Column("height", "int", "EmojiInfo", "");
    hHs = new Column("externurl", "string", "EmojiInfo", "");
    hHt = new Column("externmd5", "string", "EmojiInfo", "");
    hHu = new Column("activityid", "string", "EmojiInfo", "");
    hHv = new Column("tpurl", "string", "EmojiInfo", "");
    hHw = new Column("tpauthkey", "string", "EmojiInfo", "");
    hHx = new Column("wxammd5", "string", "EmojiInfo", "");
    hHy = new Column("attachedtext", "string", "EmojiInfo", "");
    hHz = new Column("capturestatus", "int", "EmojiInfo", "");
    hHA = new Column("attachedemojimd5", "byte[]", "EmojiInfo", "");
    hHB = new Column("imitatemd5", "string", "EmojiInfo", "");
    hHC = new Column("captureuploaderrcode", "int", "EmojiInfo", "");
    hHD = new Column("captureuploadcounter", "int", "EmojiInfo", "");
    hHE = new Column("captureentertime", "long", "EmojiInfo", "");
    hHF = new Column("lensid", "string", "EmojiInfo", "");
    hHG = new Column("attachtextcolor", "string", "EmojiInfo", "");
    hHH = new Column("capturescene", "int", "EmojiInfo", "");
    hHI = new Column("attr", "string", "EmojiInfo", "");
    hHJ = new Column("linkid", "string", "EmojiInfo", "");
    hIy = "md5".hashCode();
    hIz = "svrid".hashCode();
    hIA = "catalog".hashCode();
    type_HASHCODE = "type".hashCode();
    hph = "size".hashCode();
    hIB = "start".hashCode();
    hIC = "state".hashCode();
    hID = "name".hashCode();
    content_HASHCODE = "content".hashCode();
    hIE = "reserved1".hashCode();
    hIF = "reserved2".hashCode();
    hIG = "reserved3".hashCode();
    hIH = "reserved4".hashCode();
    hII = "app_id".hashCode();
    hIJ = "groupId".hashCode();
    hGK = "lastUseTime".hashCode();
    hIK = "framesInfo".hashCode();
    hGO = "idx".hashCode();
    hIL = "temp".hashCode();
    hqk = "source".hashCode();
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
      if (hIy != k) {
        break label65;
      }
      this.field_md5 = paramCursor.getString(i);
      this.hHK = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hIz == k) {
        this.field_svrid = paramCursor.getString(i);
      } else if (hIA == k) {
        this.field_catalog = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (hph == k) {
        this.field_size = paramCursor.getInt(i);
      } else if (hIB == k) {
        this.field_start = paramCursor.getInt(i);
      } else if (hIC == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (hID == k) {
        this.field_name = paramCursor.getString(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (hIE == k) {
        this.field_reserved1 = paramCursor.getString(i);
      } else if (hIF == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (hIG == k) {
        this.field_reserved3 = paramCursor.getInt(i);
      } else if (hIH == k) {
        this.field_reserved4 = paramCursor.getInt(i);
      } else if (hII == k) {
        this.field_app_id = paramCursor.getString(i);
      } else if (hIJ == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (hGK == k) {
        this.field_lastUseTime = paramCursor.getLong(i);
      } else if (hIK == k) {
        this.field_framesInfo = paramCursor.getString(i);
      } else if (hGO == k) {
        this.field_idx = paramCursor.getInt(i);
      } else if (hIL == k) {
        this.field_temp = paramCursor.getInt(i);
      } else if (hqk == k) {
        this.field_source = paramCursor.getInt(i);
      } else if (hIM == k) {
        this.field_needupload = paramCursor.getInt(i);
      } else if (hIN == k) {
        this.field_designerID = paramCursor.getString(i);
      } else if (hIO == k) {
        this.field_thumbUrl = paramCursor.getString(i);
      } else if (hIP == k) {
        this.field_cdnUrl = paramCursor.getString(i);
      } else if (hIQ == k) {
        this.field_encrypturl = paramCursor.getString(i);
      } else if (hIR == k) {
        this.field_aeskey = paramCursor.getString(i);
      } else if (hIS == k) {
        this.field_width = paramCursor.getInt(i);
      } else if (hIT == k) {
        this.field_height = paramCursor.getInt(i);
      } else if (hIU == k) {
        this.field_externUrl = paramCursor.getString(i);
      } else if (hIV == k) {
        this.field_externMd5 = paramCursor.getString(i);
      } else if (hIW == k) {
        this.field_activityid = paramCursor.getString(i);
      } else if (hIX == k) {
        this.field_tpurl = paramCursor.getString(i);
      } else if (hIY == k) {
        this.field_tpauthkey = paramCursor.getString(i);
      } else if (hIZ == k) {
        this.field_wxamMd5 = paramCursor.getString(i);
      } else if (hJa == k) {
        this.field_attachedText = paramCursor.getString(i);
      } else if (hJb == k) {
        this.field_captureStatus = paramCursor.getInt(i);
      } else if (hJc == k) {
        this.field_attachedEmojiMD5 = paramCursor.getBlob(i);
      } else if (hJd == k) {
        this.field_imitateMd5 = paramCursor.getString(i);
      } else if (hJe == k) {
        this.field_captureUploadErrCode = paramCursor.getInt(i);
      } else if (hJf == k) {
        this.field_captureUploadCounter = paramCursor.getInt(i);
      } else if (hJg == k) {
        this.field_captureEnterTime = paramCursor.getLong(i);
      } else if (hJh == k) {
        this.field_lensId = paramCursor.getString(i);
      } else if (hJi == k) {
        this.field_attachTextColor = paramCursor.getString(i);
      } else if (hJj == k) {
        this.field_captureScene = paramCursor.getInt(i);
      } else if (hJk == k) {
        this.field_attr = paramCursor.getString(i);
      } else if (hJl == k) {
        this.field_linkId = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hHK) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.hHL) {
      localContentValues.put("svrid", this.field_svrid);
    }
    if (this.hHM) {
      localContentValues.put("catalog", Integer.valueOf(this.field_catalog));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.hpf) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.hHN) {
      localContentValues.put("start", Integer.valueOf(this.field_start));
    }
    if (this.hHO) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.hHP) {
      localContentValues.put("name", this.field_name);
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.hHQ) {
      localContentValues.put("reserved1", this.field_reserved1);
    }
    if (this.hHR) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.hHS) {
      localContentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
    }
    if (this.hHT) {
      localContentValues.put("reserved4", Integer.valueOf(this.field_reserved4));
    }
    if (this.hHU) {
      localContentValues.put("app_id", this.field_app_id);
    }
    if (this.field_groupId == null) {
      this.field_groupId = "";
    }
    if (this.hHV) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.hGk) {
      localContentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
    }
    if (this.field_framesInfo == null) {
      this.field_framesInfo = "";
    }
    if (this.hHW) {
      localContentValues.put("framesInfo", this.field_framesInfo);
    }
    if (this.hGo) {
      localContentValues.put("idx", Integer.valueOf(this.field_idx));
    }
    if (this.hHX) {
      localContentValues.put("temp", Integer.valueOf(this.field_temp));
    }
    if (this.hqf) {
      localContentValues.put("source", Integer.valueOf(this.field_source));
    }
    if (this.hHY) {
      localContentValues.put("needupload", Integer.valueOf(this.field_needupload));
    }
    if (this.hHZ) {
      localContentValues.put("designerID", this.field_designerID);
    }
    if (this.hIa) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.hIb) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.hIc) {
      localContentValues.put("encrypturl", this.field_encrypturl);
    }
    if (this.hId) {
      localContentValues.put("aeskey", this.field_aeskey);
    }
    if (this.hIe) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.hIf) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.hIg) {
      localContentValues.put("externUrl", this.field_externUrl);
    }
    if (this.hIh) {
      localContentValues.put("externMd5", this.field_externMd5);
    }
    if (this.hIi) {
      localContentValues.put("activityid", this.field_activityid);
    }
    if (this.hIj) {
      localContentValues.put("tpurl", this.field_tpurl);
    }
    if (this.hIk) {
      localContentValues.put("tpauthkey", this.field_tpauthkey);
    }
    if (this.hIl) {
      localContentValues.put("wxamMd5", this.field_wxamMd5);
    }
    if (this.hIm) {
      localContentValues.put("attachedText", this.field_attachedText);
    }
    if (this.hIn) {
      localContentValues.put("captureStatus", Integer.valueOf(this.field_captureStatus));
    }
    if (this.hIo) {
      localContentValues.put("attachedEmojiMD5", this.field_attachedEmojiMD5);
    }
    if (this.hIp) {
      localContentValues.put("imitateMd5", this.field_imitateMd5);
    }
    if (this.hIq) {
      localContentValues.put("captureUploadErrCode", Integer.valueOf(this.field_captureUploadErrCode));
    }
    if (this.hIr) {
      localContentValues.put("captureUploadCounter", Integer.valueOf(this.field_captureUploadCounter));
    }
    if (this.hIs) {
      localContentValues.put("captureEnterTime", Long.valueOf(this.field_captureEnterTime));
    }
    if (this.hIt) {
      localContentValues.put("lensId", this.field_lensId);
    }
    if (this.hIu) {
      localContentValues.put("attachTextColor", this.field_attachTextColor);
    }
    if (this.hIv) {
      localContentValues.put("captureScene", Integer.valueOf(this.field_captureScene));
    }
    if (this.hIw) {
      localContentValues.put("attr", this.field_attr);
    }
    if (this.hIx) {
      localContentValues.put("linkId", this.field_linkId);
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
    return "EmojiInfo";
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.bj
 * JD-Core Version:    0.7.0.1
 */