package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class az
  extends c
{
  private static final int cEN;
  private static final int cER;
  private static final int cFC;
  private static final int cFD;
  private static final int cFE;
  private static final int cFF;
  private static final int cFG;
  private static final int cFH;
  private static final int cFI;
  private static final int cFJ;
  private static final int cFK;
  private static final int cFL;
  private static final int cFM;
  private static final int cFN;
  private static final int cFO;
  private static final int cFP;
  private static final int cFQ = "needupload".hashCode();
  private static final int cFR = "designerID".hashCode();
  private static final int cFS = "thumbUrl".hashCode();
  private static final int cFT = "cdnUrl".hashCode();
  private static final int cFU = "encrypturl".hashCode();
  private static final int cFV = "aeskey".hashCode();
  private static final int cFW = "width".hashCode();
  private static final int cFX = "height".hashCode();
  private static final int cFY = "externUrl".hashCode();
  private static final int cFZ = "externMd5".hashCode();
  private static final int cGa = "activityid".hashCode();
  private static final int cGb = "tpurl".hashCode();
  private static final int cGc = "tpauthkey".hashCode();
  private static final int cGd = "wxamMd5".hashCode();
  private static final int cGe = "attachedText".hashCode();
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS emojiGroupIndex ON EmojiInfo(catalog)" };
  private static final int crh = "rowid".hashCode();
  private static final int csD;
  private static final int csy;
  private static final int ctS;
  private static final int cwb;
  private boolean cEZ = true;
  private boolean cEn = true;
  private boolean cEr = true;
  private boolean cFA = true;
  private boolean cFB = true;
  private boolean cFa = true;
  private boolean cFb = true;
  private boolean cFc = true;
  private boolean cFd = true;
  private boolean cFe = true;
  private boolean cFf = true;
  private boolean cFg = true;
  private boolean cFh = true;
  private boolean cFi = true;
  private boolean cFj = true;
  private boolean cFk = true;
  private boolean cFl = true;
  private boolean cFm = true;
  private boolean cFn = true;
  private boolean cFo = true;
  private boolean cFp = true;
  private boolean cFq = true;
  private boolean cFr = true;
  private boolean cFs = true;
  private boolean cFt = true;
  private boolean cFu = true;
  private boolean cFv = true;
  private boolean cFw = true;
  private boolean cFx = true;
  private boolean cFy = true;
  private boolean cFz = true;
  private boolean csa = true;
  private boolean csf = true;
  private boolean ctQ = true;
  private boolean cvX = true;
  public String field_activityid;
  public String field_aeskey;
  public String field_app_id;
  public String field_attachedText;
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
  public long field_lastUseTime;
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
    cFC = "md5".hashCode();
    cFD = "svrid".hashCode();
    cFE = "catalog".hashCode();
    csy = "type".hashCode();
    ctS = "size".hashCode();
    cFF = "start".hashCode();
    cFG = "state".hashCode();
    cFH = "name".hashCode();
    csD = "content".hashCode();
    cFI = "reserved1".hashCode();
    cFJ = "reserved2".hashCode();
    cFK = "reserved3".hashCode();
    cFL = "reserved4".hashCode();
    cFM = "app_id".hashCode();
    cFN = "groupId".hashCode();
    cEN = "lastUseTime".hashCode();
    cFO = "framesInfo".hashCode();
    cER = "idx".hashCode();
    cFP = "temp".hashCode();
    cwb = "source".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cFC != k) {
        break label65;
      }
      this.field_md5 = paramCursor.getString(i);
      this.cEZ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cFD == k) {
        this.field_svrid = paramCursor.getString(i);
      } else if (cFE == k) {
        this.field_catalog = paramCursor.getInt(i);
      } else if (csy == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (ctS == k) {
        this.field_size = paramCursor.getInt(i);
      } else if (cFF == k) {
        this.field_start = paramCursor.getInt(i);
      } else if (cFG == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (cFH == k) {
        this.field_name = paramCursor.getString(i);
      } else if (csD == k) {
        this.field_content = paramCursor.getString(i);
      } else if (cFI == k) {
        this.field_reserved1 = paramCursor.getString(i);
      } else if (cFJ == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (cFK == k) {
        this.field_reserved3 = paramCursor.getInt(i);
      } else if (cFL == k) {
        this.field_reserved4 = paramCursor.getInt(i);
      } else if (cFM == k) {
        this.field_app_id = paramCursor.getString(i);
      } else if (cFN == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (cEN == k) {
        this.field_lastUseTime = paramCursor.getLong(i);
      } else if (cFO == k) {
        this.field_framesInfo = paramCursor.getString(i);
      } else if (cER == k) {
        this.field_idx = paramCursor.getInt(i);
      } else if (cFP == k) {
        this.field_temp = paramCursor.getInt(i);
      } else if (cwb == k) {
        this.field_source = paramCursor.getInt(i);
      } else if (cFQ == k) {
        this.field_needupload = paramCursor.getInt(i);
      } else if (cFR == k) {
        this.field_designerID = paramCursor.getString(i);
      } else if (cFS == k) {
        this.field_thumbUrl = paramCursor.getString(i);
      } else if (cFT == k) {
        this.field_cdnUrl = paramCursor.getString(i);
      } else if (cFU == k) {
        this.field_encrypturl = paramCursor.getString(i);
      } else if (cFV == k) {
        this.field_aeskey = paramCursor.getString(i);
      } else if (cFW == k) {
        this.field_width = paramCursor.getInt(i);
      } else if (cFX == k) {
        this.field_height = paramCursor.getInt(i);
      } else if (cFY == k) {
        this.field_externUrl = paramCursor.getString(i);
      } else if (cFZ == k) {
        this.field_externMd5 = paramCursor.getString(i);
      } else if (cGa == k) {
        this.field_activityid = paramCursor.getString(i);
      } else if (cGb == k) {
        this.field_tpurl = paramCursor.getString(i);
      } else if (cGc == k) {
        this.field_tpauthkey = paramCursor.getString(i);
      } else if (cGd == k) {
        this.field_wxamMd5 = paramCursor.getString(i);
      } else if (cGe == k) {
        this.field_attachedText = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public void reset() {}
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cEZ) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.cFa) {
      localContentValues.put("svrid", this.field_svrid);
    }
    if (this.cFb) {
      localContentValues.put("catalog", Integer.valueOf(this.field_catalog));
    }
    if (this.csa) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.ctQ) {
      localContentValues.put("size", Integer.valueOf(this.field_size));
    }
    if (this.cFc) {
      localContentValues.put("start", Integer.valueOf(this.field_start));
    }
    if (this.cFd) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.cFe) {
      localContentValues.put("name", this.field_name);
    }
    if (this.csf) {
      localContentValues.put("content", this.field_content);
    }
    if (this.cFf) {
      localContentValues.put("reserved1", this.field_reserved1);
    }
    if (this.cFg) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.cFh) {
      localContentValues.put("reserved3", Integer.valueOf(this.field_reserved3));
    }
    if (this.cFi) {
      localContentValues.put("reserved4", Integer.valueOf(this.field_reserved4));
    }
    if (this.cFj) {
      localContentValues.put("app_id", this.field_app_id);
    }
    if (this.field_groupId == null) {
      this.field_groupId = "";
    }
    if (this.cFk) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.cEn) {
      localContentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
    }
    if (this.field_framesInfo == null) {
      this.field_framesInfo = "";
    }
    if (this.cFl) {
      localContentValues.put("framesInfo", this.field_framesInfo);
    }
    if (this.cEr) {
      localContentValues.put("idx", Integer.valueOf(this.field_idx));
    }
    if (this.cFm) {
      localContentValues.put("temp", Integer.valueOf(this.field_temp));
    }
    if (this.cvX) {
      localContentValues.put("source", Integer.valueOf(this.field_source));
    }
    if (this.cFn) {
      localContentValues.put("needupload", Integer.valueOf(this.field_needupload));
    }
    if (this.cFo) {
      localContentValues.put("designerID", this.field_designerID);
    }
    if (this.cFp) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.cFq) {
      localContentValues.put("cdnUrl", this.field_cdnUrl);
    }
    if (this.cFr) {
      localContentValues.put("encrypturl", this.field_encrypturl);
    }
    if (this.cFs) {
      localContentValues.put("aeskey", this.field_aeskey);
    }
    if (this.cFt) {
      localContentValues.put("width", Integer.valueOf(this.field_width));
    }
    if (this.cFu) {
      localContentValues.put("height", Integer.valueOf(this.field_height));
    }
    if (this.cFv) {
      localContentValues.put("externUrl", this.field_externUrl);
    }
    if (this.cFw) {
      localContentValues.put("externMd5", this.field_externMd5);
    }
    if (this.cFx) {
      localContentValues.put("activityid", this.field_activityid);
    }
    if (this.cFy) {
      localContentValues.put("tpurl", this.field_tpurl);
    }
    if (this.cFz) {
      localContentValues.put("tpauthkey", this.field_tpauthkey);
    }
    if (this.cFA) {
      localContentValues.put("wxamMd5", this.field_wxamMd5);
    }
    if (this.cFB) {
      localContentValues.put("attachedText", this.field_attachedText);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.c.az
 * JD-Core Version:    0.7.0.1
 */