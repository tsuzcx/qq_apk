package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class f
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEc = "snsId".hashCode();
  private static final int eEd = "userName".hashCode();
  private static final int eEe = "localFlag".hashCode();
  private static final int eEf = "createTime".hashCode();
  private static final int eEg = "head".hashCode();
  private static final int eEh = "localPrivate".hashCode();
  private static final int eEi = "sourceType".hashCode();
  private static final int eEj = "likeFlag".hashCode();
  private static final int eEk = "pravited".hashCode();
  private static final int eEl = "stringSeq".hashCode();
  private static final int eEm = "content".hashCode();
  private static final int eEn = "attrBuf".hashCode();
  private static final int eEo = "postBuf".hashCode();
  private static final int eEp = "adinfo".hashCode();
  private static final int eEq = "adxml".hashCode();
  private static final int eEr = "createAdTime".hashCode();
  private static final int eEs = "exposureTime".hashCode();
  private static final int eEt = "firstControlTime".hashCode();
  private static final int eEu = "recxml".hashCode();
  private static final int eEv = "subType".hashCode();
  private static final int eEw = "exposureCount".hashCode();
  private static final int eEx = "atAdinfo".hashCode();
  private static final int eEy = "remindInfoGroup".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eDF = true;
  private boolean eDG = true;
  private boolean eDH = true;
  private boolean eDI = true;
  private boolean eDJ = true;
  private boolean eDK = true;
  private boolean eDL = true;
  private boolean eDM = true;
  private boolean eDN = true;
  private boolean eDO = true;
  private boolean eDP = true;
  private boolean eDQ = true;
  private boolean eDR = true;
  private boolean eDS = true;
  private boolean eDT = true;
  private boolean eDU = true;
  private boolean eDV = true;
  private boolean eDW = true;
  private boolean eDX = true;
  private boolean eDY = true;
  private boolean eDZ = true;
  private boolean eEa = true;
  private boolean eEb = true;
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
      if (eEc != k) {
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
      if (eEd == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (eEe == k) {
        this.field_localFlag = paramCursor.getInt(i);
      } else if (eEf == k) {
        this.field_createTime = paramCursor.getInt(i);
      } else if (eEg == k) {
        this.field_head = paramCursor.getInt(i);
      } else if (eEh == k) {
        this.field_localPrivate = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eEi == k) {
        this.field_sourceType = paramCursor.getInt(i);
      } else if (eEj == k) {
        this.field_likeFlag = paramCursor.getInt(i);
      } else if (eEk == k) {
        this.field_pravited = paramCursor.getInt(i);
      } else if (eEl == k) {
        this.field_stringSeq = paramCursor.getString(i);
      } else if (eEm == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (eEn == k) {
        this.field_attrBuf = paramCursor.getBlob(i);
      } else if (eEo == k) {
        this.field_postBuf = paramCursor.getBlob(i);
      } else if (eEp == k) {
        this.field_adinfo = paramCursor.getString(i);
      } else if (eEq == k) {
        this.field_adxml = paramCursor.getString(i);
      } else if (eEr == k) {
        this.field_createAdTime = paramCursor.getInt(i);
      } else if (eEs == k) {
        this.field_exposureTime = paramCursor.getInt(i);
      } else if (eEt == k) {
        this.field_firstControlTime = paramCursor.getInt(i);
      } else if (eEu == k) {
        this.field_recxml = paramCursor.getString(i);
      } else if (eEv == k) {
        this.field_subType = paramCursor.getInt(i);
      } else if (eEw == k) {
        this.field_exposureCount = paramCursor.getInt(i);
      } else if (eEx == k) {
        this.field_atAdinfo = paramCursor.getString(i);
      } else if (eEy == k) {
        this.field_remindInfoGroup = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eDF) {
      localContentValues.put("snsId", Long.valueOf(this.field_snsId));
    }
    if (this.eDG) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.eDH) {
      localContentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
    }
    if (this.eDI) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.eDJ) {
      localContentValues.put("head", Integer.valueOf(this.field_head));
    }
    if (this.eDK) {
      localContentValues.put("localPrivate", Integer.valueOf(this.field_localPrivate));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eDL) {
      localContentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
    }
    if (this.eDM) {
      localContentValues.put("likeFlag", Integer.valueOf(this.field_likeFlag));
    }
    if (this.eDN) {
      localContentValues.put("pravited", Integer.valueOf(this.field_pravited));
    }
    if (this.eDO) {
      localContentValues.put("stringSeq", this.field_stringSeq);
    }
    if (this.eDP) {
      localContentValues.put("content", this.field_content);
    }
    if (this.eDQ) {
      localContentValues.put("attrBuf", this.field_attrBuf);
    }
    if (this.eDR) {
      localContentValues.put("postBuf", this.field_postBuf);
    }
    if (this.eDS) {
      localContentValues.put("adinfo", this.field_adinfo);
    }
    if (this.eDT) {
      localContentValues.put("adxml", this.field_adxml);
    }
    if (this.eDU) {
      localContentValues.put("createAdTime", Integer.valueOf(this.field_createAdTime));
    }
    if (this.eDV) {
      localContentValues.put("exposureTime", Integer.valueOf(this.field_exposureTime));
    }
    if (this.eDW) {
      localContentValues.put("firstControlTime", Integer.valueOf(this.field_firstControlTime));
    }
    if (this.eDX) {
      localContentValues.put("recxml", this.field_recxml);
    }
    if (this.eDY) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.eDZ) {
      localContentValues.put("exposureCount", Integer.valueOf(this.field_exposureCount));
    }
    if (this.eEa) {
      localContentValues.put("atAdinfo", this.field_atAdinfo);
    }
    if (this.eEb) {
      localContentValues.put("remindInfoGroup", this.field_remindInfoGroup);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.f
 * JD-Core Version:    0.7.0.1
 */