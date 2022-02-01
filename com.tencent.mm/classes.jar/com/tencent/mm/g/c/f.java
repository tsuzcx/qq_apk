package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class f
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFL = "snsId".hashCode();
  private static final int eFM = "userName".hashCode();
  private static final int eFN = "localFlag".hashCode();
  private static final int eFO = "createTime".hashCode();
  private static final int eFP = "head".hashCode();
  private static final int eFQ = "localPrivate".hashCode();
  private static final int eFR = "sourceType".hashCode();
  private static final int eFS = "likeFlag".hashCode();
  private static final int eFT = "pravited".hashCode();
  private static final int eFU = "stringSeq".hashCode();
  private static final int eFV = "content".hashCode();
  private static final int eFW = "attrBuf".hashCode();
  private static final int eFX = "postBuf".hashCode();
  private static final int eFY = "adinfo".hashCode();
  private static final int eFZ = "adxml".hashCode();
  private static final int eGa = "createAdTime".hashCode();
  private static final int eGb = "exposureTime".hashCode();
  private static final int eGc = "firstControlTime".hashCode();
  private static final int eGd = "recxml".hashCode();
  private static final int eGe = "subType".hashCode();
  private static final int eGf = "exposureCount".hashCode();
  private static final int eGg = "atAdinfo".hashCode();
  private static final int eGh = "remindInfoGroup".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eFA = true;
  private boolean eFB = true;
  private boolean eFC = true;
  private boolean eFD = true;
  private boolean eFE = true;
  private boolean eFF = true;
  private boolean eFG = true;
  private boolean eFH = true;
  private boolean eFI = true;
  private boolean eFJ = true;
  private boolean eFK = true;
  private boolean eFo = true;
  private boolean eFp = true;
  private boolean eFq = true;
  private boolean eFr = true;
  private boolean eFs = true;
  private boolean eFt = true;
  private boolean eFu = true;
  private boolean eFv = true;
  private boolean eFw = true;
  private boolean eFx = true;
  private boolean eFy = true;
  private boolean eFz = true;
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
      if (eFL != k) {
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
      if (eFM == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (eFN == k) {
        this.field_localFlag = paramCursor.getInt(i);
      } else if (eFO == k) {
        this.field_createTime = paramCursor.getInt(i);
      } else if (eFP == k) {
        this.field_head = paramCursor.getInt(i);
      } else if (eFQ == k) {
        this.field_localPrivate = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eFR == k) {
        this.field_sourceType = paramCursor.getInt(i);
      } else if (eFS == k) {
        this.field_likeFlag = paramCursor.getInt(i);
      } else if (eFT == k) {
        this.field_pravited = paramCursor.getInt(i);
      } else if (eFU == k) {
        this.field_stringSeq = paramCursor.getString(i);
      } else if (eFV == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (eFW == k) {
        this.field_attrBuf = paramCursor.getBlob(i);
      } else if (eFX == k) {
        this.field_postBuf = paramCursor.getBlob(i);
      } else if (eFY == k) {
        this.field_adinfo = paramCursor.getString(i);
      } else if (eFZ == k) {
        this.field_adxml = paramCursor.getString(i);
      } else if (eGa == k) {
        this.field_createAdTime = paramCursor.getInt(i);
      } else if (eGb == k) {
        this.field_exposureTime = paramCursor.getInt(i);
      } else if (eGc == k) {
        this.field_firstControlTime = paramCursor.getInt(i);
      } else if (eGd == k) {
        this.field_recxml = paramCursor.getString(i);
      } else if (eGe == k) {
        this.field_subType = paramCursor.getInt(i);
      } else if (eGf == k) {
        this.field_exposureCount = paramCursor.getInt(i);
      } else if (eGg == k) {
        this.field_atAdinfo = paramCursor.getString(i);
      } else if (eGh == k) {
        this.field_remindInfoGroup = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eFo) {
      localContentValues.put("snsId", Long.valueOf(this.field_snsId));
    }
    if (this.eFp) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.eFq) {
      localContentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
    }
    if (this.eFr) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.eFs) {
      localContentValues.put("head", Integer.valueOf(this.field_head));
    }
    if (this.eFt) {
      localContentValues.put("localPrivate", Integer.valueOf(this.field_localPrivate));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eFu) {
      localContentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
    }
    if (this.eFv) {
      localContentValues.put("likeFlag", Integer.valueOf(this.field_likeFlag));
    }
    if (this.eFw) {
      localContentValues.put("pravited", Integer.valueOf(this.field_pravited));
    }
    if (this.eFx) {
      localContentValues.put("stringSeq", this.field_stringSeq);
    }
    if (this.eFy) {
      localContentValues.put("content", this.field_content);
    }
    if (this.eFz) {
      localContentValues.put("attrBuf", this.field_attrBuf);
    }
    if (this.eFA) {
      localContentValues.put("postBuf", this.field_postBuf);
    }
    if (this.eFB) {
      localContentValues.put("adinfo", this.field_adinfo);
    }
    if (this.eFC) {
      localContentValues.put("adxml", this.field_adxml);
    }
    if (this.eFD) {
      localContentValues.put("createAdTime", Integer.valueOf(this.field_createAdTime));
    }
    if (this.eFE) {
      localContentValues.put("exposureTime", Integer.valueOf(this.field_exposureTime));
    }
    if (this.eFF) {
      localContentValues.put("firstControlTime", Integer.valueOf(this.field_firstControlTime));
    }
    if (this.eFG) {
      localContentValues.put("recxml", this.field_recxml);
    }
    if (this.eFH) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.eFI) {
      localContentValues.put("exposureCount", Integer.valueOf(this.field_exposureCount));
    }
    if (this.eFJ) {
      localContentValues.put("atAdinfo", this.field_atAdinfo);
    }
    if (this.eFK) {
      localContentValues.put("remindInfoGroup", this.field_remindInfoGroup);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.f
 * JD-Core Version:    0.7.0.1
 */