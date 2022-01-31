package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class f
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int csA;
  private static final int csB;
  private static final int csC;
  private static final int csD;
  private static final int csE;
  private static final int csF;
  private static final int csG;
  private static final int csH;
  private static final int csI;
  private static final int csJ;
  private static final int csK;
  private static final int csL;
  private static final int csM;
  private static final int csN;
  private static final int csO;
  private static final int csP;
  private static final int css = "snsId".hashCode();
  private static final int cst = "userName".hashCode();
  private static final int csu = "localFlag".hashCode();
  private static final int csv = "createTime".hashCode();
  private static final int csw = "head".hashCode();
  private static final int csx = "localPrivate".hashCode();
  private static final int csy = "type".hashCode();
  private static final int csz = "sourceType".hashCode();
  private boolean crU = true;
  private boolean crV = true;
  private boolean crW = true;
  private boolean crX = true;
  private boolean crY = true;
  private boolean crZ = true;
  private boolean csa = true;
  private boolean csb = true;
  private boolean csc = true;
  private boolean csd = true;
  private boolean cse = true;
  private boolean csf = true;
  private boolean csg = true;
  private boolean csh = true;
  private boolean csi = true;
  private boolean csj = true;
  private boolean csk = true;
  private boolean csl = true;
  private boolean csm = true;
  private boolean csn = true;
  private boolean cso = true;
  private boolean csp = true;
  private boolean csq = true;
  private boolean csr = true;
  public String field_adinfo;
  public String field_adxml;
  public String field_atAdinfo;
  public byte[] field_attrBuf;
  public byte[] field_content;
  public int field_createAdTime;
  public int field_createTime;
  public int field_exposureCount;
  public int field_exposureTime;
  public int field_firstControlTime;
  public int field_head;
  public int field_likeFlag;
  public int field_localFlag;
  public int field_localPrivate;
  public byte[] field_postBuf;
  public int field_pravited;
  public String field_recxml;
  public byte[] field_remindInfoGroup;
  public long field_snsId;
  public int field_sourceType;
  public String field_stringSeq;
  public int field_subType;
  public int field_type;
  public String field_userName;
  
  static
  {
    csA = "likeFlag".hashCode();
    csB = "pravited".hashCode();
    csC = "stringSeq".hashCode();
    csD = "content".hashCode();
    csE = "attrBuf".hashCode();
    csF = "postBuf".hashCode();
    csG = "adinfo".hashCode();
    csH = "adxml".hashCode();
    csI = "createAdTime".hashCode();
    csJ = "exposureTime".hashCode();
    csK = "firstControlTime".hashCode();
    csL = "recxml".hashCode();
    csM = "subType".hashCode();
    csN = "exposureCount".hashCode();
    csO = "atAdinfo".hashCode();
    csP = "remindInfoGroup".hashCode();
  }
  
  public void d(Cursor paramCursor)
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
      if (css != k) {
        break label60;
      }
      this.field_snsId = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (cst == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (csu == k) {
        this.field_localFlag = paramCursor.getInt(i);
      } else if (csv == k) {
        this.field_createTime = paramCursor.getInt(i);
      } else if (csw == k) {
        this.field_head = paramCursor.getInt(i);
      } else if (csx == k) {
        this.field_localPrivate = paramCursor.getInt(i);
      } else if (csy == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (csz == k) {
        this.field_sourceType = paramCursor.getInt(i);
      } else if (csA == k) {
        this.field_likeFlag = paramCursor.getInt(i);
      } else if (csB == k) {
        this.field_pravited = paramCursor.getInt(i);
      } else if (csC == k) {
        this.field_stringSeq = paramCursor.getString(i);
      } else if (csD == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (csE == k) {
        this.field_attrBuf = paramCursor.getBlob(i);
      } else if (csF == k) {
        this.field_postBuf = paramCursor.getBlob(i);
      } else if (csG == k) {
        this.field_adinfo = paramCursor.getString(i);
      } else if (csH == k) {
        this.field_adxml = paramCursor.getString(i);
      } else if (csI == k) {
        this.field_createAdTime = paramCursor.getInt(i);
      } else if (csJ == k) {
        this.field_exposureTime = paramCursor.getInt(i);
      } else if (csK == k) {
        this.field_firstControlTime = paramCursor.getInt(i);
      } else if (csL == k) {
        this.field_recxml = paramCursor.getString(i);
      } else if (csM == k) {
        this.field_subType = paramCursor.getInt(i);
      } else if (csN == k) {
        this.field_exposureCount = paramCursor.getInt(i);
      } else if (csO == k) {
        this.field_atAdinfo = paramCursor.getString(i);
      } else if (csP == k) {
        this.field_remindInfoGroup = paramCursor.getBlob(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.crU) {
      localContentValues.put("snsId", Long.valueOf(this.field_snsId));
    }
    if (this.crV) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.crW) {
      localContentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
    }
    if (this.crX) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.crY) {
      localContentValues.put("head", Integer.valueOf(this.field_head));
    }
    if (this.crZ) {
      localContentValues.put("localPrivate", Integer.valueOf(this.field_localPrivate));
    }
    if (this.csa) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.csb) {
      localContentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
    }
    if (this.csc) {
      localContentValues.put("likeFlag", Integer.valueOf(this.field_likeFlag));
    }
    if (this.csd) {
      localContentValues.put("pravited", Integer.valueOf(this.field_pravited));
    }
    if (this.cse) {
      localContentValues.put("stringSeq", this.field_stringSeq);
    }
    if (this.csf) {
      localContentValues.put("content", this.field_content);
    }
    if (this.csg) {
      localContentValues.put("attrBuf", this.field_attrBuf);
    }
    if (this.csh) {
      localContentValues.put("postBuf", this.field_postBuf);
    }
    if (this.csi) {
      localContentValues.put("adinfo", this.field_adinfo);
    }
    if (this.csj) {
      localContentValues.put("adxml", this.field_adxml);
    }
    if (this.csk) {
      localContentValues.put("createAdTime", Integer.valueOf(this.field_createAdTime));
    }
    if (this.csl) {
      localContentValues.put("exposureTime", Integer.valueOf(this.field_exposureTime));
    }
    if (this.csm) {
      localContentValues.put("firstControlTime", Integer.valueOf(this.field_firstControlTime));
    }
    if (this.csn) {
      localContentValues.put("recxml", this.field_recxml);
    }
    if (this.cso) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.csp) {
      localContentValues.put("exposureCount", Integer.valueOf(this.field_exposureCount));
    }
    if (this.csq) {
      localContentValues.put("atAdinfo", this.field_atAdinfo);
    }
    if (this.csr) {
      localContentValues.put("remindInfoGroup", this.field_remindInfoGroup);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.h.c.f
 * JD-Core Version:    0.7.0.1
 */