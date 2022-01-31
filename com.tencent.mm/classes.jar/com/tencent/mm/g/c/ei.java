package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ei
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dDS;
  private static final int dDT = "sayhiuser".hashCode();
  private static final int dDU = "sayhicontent".hashCode();
  private static final int dDV = "imgpath".hashCode();
  private static final int dfJ;
  private static final int dgT;
  private static final int dhi;
  private static final int dle = "isSend".hashCode();
  private static final int dnh;
  private static final int dtY = "svrid".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean dDN = true;
  private boolean dDO = true;
  private boolean dDP = true;
  private boolean dDQ = true;
  private boolean dfG = true;
  private boolean dgw = true;
  private boolean dhg = true;
  private boolean dkQ = true;
  private boolean dmW = true;
  private boolean dtl = true;
  public String field_content;
  public long field_createtime;
  public String field_imgpath;
  public int field_isSend;
  public String field_sayhicontent;
  public String field_sayhiuser;
  public int field_scene;
  public int field_status;
  public long field_svrid;
  public String field_talker;
  public int field_type;
  
  static
  {
    dfJ = "status".hashCode();
    type_HASHCODE = "type".hashCode();
    dhi = "scene".hashCode();
    dDS = "createtime".hashCode();
    dnh = "talker".hashCode();
    dgT = "content".hashCode();
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
      if (dtY != k) {
        break label65;
      }
      this.field_svrid = paramCursor.getLong(i);
      this.dtl = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dfJ == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (dhi == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (dDS == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (dnh == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (dgT == k) {
        this.field_content = paramCursor.getString(i);
      } else if (dDT == k) {
        this.field_sayhiuser = paramCursor.getString(i);
      } else if (dDU == k) {
        this.field_sayhicontent = paramCursor.getString(i);
      } else if (dDV == k) {
        this.field_imgpath = paramCursor.getString(i);
      } else if (dle == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dtl) {
      localContentValues.put("svrid", Long.valueOf(this.field_svrid));
    }
    if (this.dfG) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.dhg) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.dDN) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.dmW) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.dgw) {
      localContentValues.put("content", this.field_content);
    }
    if (this.dDO) {
      localContentValues.put("sayhiuser", this.field_sayhiuser);
    }
    if (this.dDP) {
      localContentValues.put("sayhicontent", this.field_sayhicontent);
    }
    if (this.dDQ) {
      localContentValues.put("imgpath", this.field_imgpath);
    }
    if (this.dkQ) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ei
 * JD-Core Version:    0.7.0.1
 */