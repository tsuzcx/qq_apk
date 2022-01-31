package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eq
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
  private static final int dhc = "subType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean dgF = true;
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
  public byte[] field_attrBuf;
  public byte[] field_content;
  public int field_createTime;
  public int field_head;
  public int field_likeFlag;
  public int field_localFlag;
  public int field_localPrivate;
  public byte[] field_postBuf;
  public int field_pravited;
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
      } else if (dhc == k) {
        this.field_subType = paramCursor.getInt(i);
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
    if (this.dgF) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.eq
 * JD-Core Version:    0.7.0.1
 */