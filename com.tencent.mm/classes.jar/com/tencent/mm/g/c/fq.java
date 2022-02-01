package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fq
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int emV = "snsId".hashCode();
  private static final int emW = "userName".hashCode();
  private static final int emX = "localFlag".hashCode();
  private static final int emY = "createTime".hashCode();
  private static final int emZ = "head".hashCode();
  private static final int ena = "localPrivate".hashCode();
  private static final int enb = "sourceType".hashCode();
  private static final int enc = "likeFlag".hashCode();
  private static final int ene = "pravited".hashCode();
  private static final int enf = "stringSeq".hashCode();
  private static final int eng = "content".hashCode();
  private static final int enh = "attrBuf".hashCode();
  private static final int eni = "postBuf".hashCode();
  private static final int enp = "subType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean emA = true;
  private boolean emB = true;
  private boolean emC = true;
  private boolean emD = true;
  private boolean emE = true;
  private boolean emF = true;
  private boolean emG = true;
  private boolean emH = true;
  private boolean emI = true;
  private boolean emJ = true;
  private boolean emK = true;
  private boolean emR = true;
  private boolean emy = true;
  private boolean emz = true;
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
      if (emV != k) {
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
      if (emW == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (emX == k) {
        this.field_localFlag = paramCursor.getInt(i);
      } else if (emY == k) {
        this.field_createTime = paramCursor.getInt(i);
      } else if (emZ == k) {
        this.field_head = paramCursor.getInt(i);
      } else if (ena == k) {
        this.field_localPrivate = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (enb == k) {
        this.field_sourceType = paramCursor.getInt(i);
      } else if (enc == k) {
        this.field_likeFlag = paramCursor.getInt(i);
      } else if (ene == k) {
        this.field_pravited = paramCursor.getInt(i);
      } else if (enf == k) {
        this.field_stringSeq = paramCursor.getString(i);
      } else if (eng == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (enh == k) {
        this.field_attrBuf = paramCursor.getBlob(i);
      } else if (eni == k) {
        this.field_postBuf = paramCursor.getBlob(i);
      } else if (enp == k) {
        this.field_subType = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.emy) {
      localContentValues.put("snsId", Long.valueOf(this.field_snsId));
    }
    if (this.emz) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.emA) {
      localContentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
    }
    if (this.emB) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.emC) {
      localContentValues.put("head", Integer.valueOf(this.field_head));
    }
    if (this.emD) {
      localContentValues.put("localPrivate", Integer.valueOf(this.field_localPrivate));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.emE) {
      localContentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
    }
    if (this.emF) {
      localContentValues.put("likeFlag", Integer.valueOf(this.field_likeFlag));
    }
    if (this.emG) {
      localContentValues.put("pravited", Integer.valueOf(this.field_pravited));
    }
    if (this.emH) {
      localContentValues.put("stringSeq", this.field_stringSeq);
    }
    if (this.emI) {
      localContentValues.put("content", this.field_content);
    }
    if (this.emJ) {
      localContentValues.put("attrBuf", this.field_attrBuf);
    }
    if (this.emK) {
      localContentValues.put("postBuf", this.field_postBuf);
    }
    if (this.emR) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.fq
 * JD-Core Version:    0.7.0.1
 */