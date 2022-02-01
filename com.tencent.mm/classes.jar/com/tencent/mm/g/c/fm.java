package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fm
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ekR = "snsId".hashCode();
  private static final int ekS = "userName".hashCode();
  private static final int ekT = "localFlag".hashCode();
  private static final int ekU = "createTime".hashCode();
  private static final int ekV = "head".hashCode();
  private static final int ekW = "localPrivate".hashCode();
  private static final int ekX = "sourceType".hashCode();
  private static final int ekY = "likeFlag".hashCode();
  private static final int ekZ = "pravited".hashCode();
  private static final int ela = "stringSeq".hashCode();
  private static final int elb = "content".hashCode();
  private static final int elc = "attrBuf".hashCode();
  private static final int eld = "postBuf".hashCode();
  private static final int elk = "subType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean ekA = true;
  private boolean ekB = true;
  private boolean ekC = true;
  private boolean ekD = true;
  private boolean ekE = true;
  private boolean ekF = true;
  private boolean ekG = true;
  private boolean ekN = true;
  private boolean eku = true;
  private boolean ekv = true;
  private boolean ekw = true;
  private boolean ekx = true;
  private boolean eky = true;
  private boolean ekz = true;
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
      if (ekR != k) {
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
      if (ekS == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (ekT == k) {
        this.field_localFlag = paramCursor.getInt(i);
      } else if (ekU == k) {
        this.field_createTime = paramCursor.getInt(i);
      } else if (ekV == k) {
        this.field_head = paramCursor.getInt(i);
      } else if (ekW == k) {
        this.field_localPrivate = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (ekX == k) {
        this.field_sourceType = paramCursor.getInt(i);
      } else if (ekY == k) {
        this.field_likeFlag = paramCursor.getInt(i);
      } else if (ekZ == k) {
        this.field_pravited = paramCursor.getInt(i);
      } else if (ela == k) {
        this.field_stringSeq = paramCursor.getString(i);
      } else if (elb == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (elc == k) {
        this.field_attrBuf = paramCursor.getBlob(i);
      } else if (eld == k) {
        this.field_postBuf = paramCursor.getBlob(i);
      } else if (elk == k) {
        this.field_subType = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eku) {
      localContentValues.put("snsId", Long.valueOf(this.field_snsId));
    }
    if (this.ekv) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.ekw) {
      localContentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
    }
    if (this.ekx) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.eky) {
      localContentValues.put("head", Integer.valueOf(this.field_head));
    }
    if (this.ekz) {
      localContentValues.put("localPrivate", Integer.valueOf(this.field_localPrivate));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.ekA) {
      localContentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
    }
    if (this.ekB) {
      localContentValues.put("likeFlag", Integer.valueOf(this.field_likeFlag));
    }
    if (this.ekC) {
      localContentValues.put("pravited", Integer.valueOf(this.field_pravited));
    }
    if (this.ekD) {
      localContentValues.put("stringSeq", this.field_stringSeq);
    }
    if (this.ekE) {
      localContentValues.put("content", this.field_content);
    }
    if (this.ekF) {
      localContentValues.put("attrBuf", this.field_attrBuf);
    }
    if (this.ekG) {
      localContentValues.put("postBuf", this.field_postBuf);
    }
    if (this.ekN) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fm
 * JD-Core Version:    0.7.0.1
 */