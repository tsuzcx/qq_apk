package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fd
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eJw;
  private static final int eLv = "sayhiuser".hashCode();
  private static final int eLw = "sayhicontent".hashCode();
  private static final int eLx = "imgpath".hashCode();
  private static final int ejR;
  private static final int elb;
  private static final int elq;
  private static final int epC = "isSend".hashCode();
  private static final int erT;
  private static final int eyY = "svrid".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eJn = true;
  private boolean eLr = true;
  private boolean eLs = true;
  private boolean eLt = true;
  private boolean ejO = true;
  private boolean ekE = true;
  private boolean elo = true;
  private boolean epn = true;
  private boolean erF = true;
  private boolean eym = true;
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
    ejR = "status".hashCode();
    type_HASHCODE = "type".hashCode();
    elq = "scene".hashCode();
    eJw = "createtime".hashCode();
    erT = "talker".hashCode();
    elb = "content".hashCode();
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
      if (eyY != k) {
        break label65;
      }
      this.field_svrid = paramCursor.getLong(i);
      this.eym = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ejR == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (elq == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (eJw == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (erT == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (elb == k) {
        this.field_content = paramCursor.getString(i);
      } else if (eLv == k) {
        this.field_sayhiuser = paramCursor.getString(i);
      } else if (eLw == k) {
        this.field_sayhicontent = paramCursor.getString(i);
      } else if (eLx == k) {
        this.field_imgpath = paramCursor.getString(i);
      } else if (epC == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eym) {
      localContentValues.put("svrid", Long.valueOf(this.field_svrid));
    }
    if (this.ejO) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.elo) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.eJn) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.erF) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.ekE) {
      localContentValues.put("content", this.field_content);
    }
    if (this.eLr) {
      localContentValues.put("sayhiuser", this.field_sayhiuser);
    }
    if (this.eLs) {
      localContentValues.put("sayhicontent", this.field_sayhicontent);
    }
    if (this.eLt) {
      localContentValues.put("imgpath", this.field_imgpath);
    }
    if (this.epn) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fd
 * JD-Core Version:    0.7.0.1
 */