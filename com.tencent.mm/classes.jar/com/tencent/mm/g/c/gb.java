package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gb
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
  private static final int eGe = "subType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eFA = true;
  private boolean eFH = true;
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
      } else if (eGe == k) {
        this.field_subType = paramCursor.getInt(i);
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
    if (this.eFH) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.gb
 * JD-Core Version:    0.7.0.1
 */