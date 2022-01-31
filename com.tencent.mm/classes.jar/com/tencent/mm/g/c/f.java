package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class f
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dgJ = "snsId".hashCode();
  private static final int dgK = "userName".hashCode();
  private static final int dgL = "localFlag".hashCode();
  private static final int dgM = "createTime".hashCode();
  private static final int dgN = "head".hashCode();
  private static final int dgO = "localPrivate".hashCode();
  private static final int dgP = "sourceType".hashCode();
  private static final int dgQ = "likeFlag".hashCode();
  private static final int dgR = "pravited".hashCode();
  private static final int dgS = "stringSeq".hashCode();
  private static final int dgT = "content".hashCode();
  private static final int dgU = "attrBuf".hashCode();
  private static final int dgV = "postBuf".hashCode();
  private static final int dgW = "adinfo".hashCode();
  private static final int dgX = "adxml".hashCode();
  private static final int dgY = "createAdTime".hashCode();
  private static final int dgZ = "exposureTime".hashCode();
  private static final int dha = "firstControlTime".hashCode();
  private static final int dhb = "recxml".hashCode();
  private static final int dhc = "subType".hashCode();
  private static final int dhd = "exposureCount".hashCode();
  private static final int dhe = "atAdinfo".hashCode();
  private static final int dhf = "remindInfoGroup".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean dgA = true;
  private boolean dgB = true;
  private boolean dgC = true;
  private boolean dgD = true;
  private boolean dgE = true;
  private boolean dgF = true;
  private boolean dgG = true;
  private boolean dgH = true;
  private boolean dgI = true;
  private boolean dgm = true;
  private boolean dgn = true;
  private boolean dgo = true;
  private boolean dgp = true;
  private boolean dgq = true;
  private boolean dgr = true;
  private boolean dgs = true;
  private boolean dgt = true;
  private boolean dgu = true;
  private boolean dgv = true;
  private boolean dgw = true;
  private boolean dgx = true;
  private boolean dgy = true;
  private boolean dgz = true;
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
      if (dgJ != k) {
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
      if (dgK == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (dgL == k) {
        this.field_localFlag = paramCursor.getInt(i);
      } else if (dgM == k) {
        this.field_createTime = paramCursor.getInt(i);
      } else if (dgN == k) {
        this.field_head = paramCursor.getInt(i);
      } else if (dgO == k) {
        this.field_localPrivate = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (dgP == k) {
        this.field_sourceType = paramCursor.getInt(i);
      } else if (dgQ == k) {
        this.field_likeFlag = paramCursor.getInt(i);
      } else if (dgR == k) {
        this.field_pravited = paramCursor.getInt(i);
      } else if (dgS == k) {
        this.field_stringSeq = paramCursor.getString(i);
      } else if (dgT == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (dgU == k) {
        this.field_attrBuf = paramCursor.getBlob(i);
      } else if (dgV == k) {
        this.field_postBuf = paramCursor.getBlob(i);
      } else if (dgW == k) {
        this.field_adinfo = paramCursor.getString(i);
      } else if (dgX == k) {
        this.field_adxml = paramCursor.getString(i);
      } else if (dgY == k) {
        this.field_createAdTime = paramCursor.getInt(i);
      } else if (dgZ == k) {
        this.field_exposureTime = paramCursor.getInt(i);
      } else if (dha == k) {
        this.field_firstControlTime = paramCursor.getInt(i);
      } else if (dhb == k) {
        this.field_recxml = paramCursor.getString(i);
      } else if (dhc == k) {
        this.field_subType = paramCursor.getInt(i);
      } else if (dhd == k) {
        this.field_exposureCount = paramCursor.getInt(i);
      } else if (dhe == k) {
        this.field_atAdinfo = paramCursor.getString(i);
      } else if (dhf == k) {
        this.field_remindInfoGroup = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dgm) {
      localContentValues.put("snsId", Long.valueOf(this.field_snsId));
    }
    if (this.dgn) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.dgo) {
      localContentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
    }
    if (this.dgp) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.dgq) {
      localContentValues.put("head", Integer.valueOf(this.field_head));
    }
    if (this.dgr) {
      localContentValues.put("localPrivate", Integer.valueOf(this.field_localPrivate));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.dgs) {
      localContentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
    }
    if (this.dgt) {
      localContentValues.put("likeFlag", Integer.valueOf(this.field_likeFlag));
    }
    if (this.dgu) {
      localContentValues.put("pravited", Integer.valueOf(this.field_pravited));
    }
    if (this.dgv) {
      localContentValues.put("stringSeq", this.field_stringSeq);
    }
    if (this.dgw) {
      localContentValues.put("content", this.field_content);
    }
    if (this.dgx) {
      localContentValues.put("attrBuf", this.field_attrBuf);
    }
    if (this.dgy) {
      localContentValues.put("postBuf", this.field_postBuf);
    }
    if (this.dgz) {
      localContentValues.put("adinfo", this.field_adinfo);
    }
    if (this.dgA) {
      localContentValues.put("adxml", this.field_adxml);
    }
    if (this.dgB) {
      localContentValues.put("createAdTime", Integer.valueOf(this.field_createAdTime));
    }
    if (this.dgC) {
      localContentValues.put("exposureTime", Integer.valueOf(this.field_exposureTime));
    }
    if (this.dgD) {
      localContentValues.put("firstControlTime", Integer.valueOf(this.field_firstControlTime));
    }
    if (this.dgE) {
      localContentValues.put("recxml", this.field_recxml);
    }
    if (this.dgF) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.dgG) {
      localContentValues.put("exposureCount", Integer.valueOf(this.field_exposureCount));
    }
    if (this.dgH) {
      localContentValues.put("atAdinfo", this.field_atAdinfo);
    }
    if (this.dgI) {
      localContentValues.put("remindInfoGroup", this.field_remindInfoGroup);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.f
 * JD-Core Version:    0.7.0.1
 */