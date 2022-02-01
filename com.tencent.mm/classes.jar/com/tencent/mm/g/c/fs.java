package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fs
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEL;
  private static final int eFV;
  private static final int eGk;
  private static final int eKy = "isSend".hashCode();
  private static final int eMP;
  private static final int eUB = "svrid".hashCode();
  private static final int fgF;
  private static final int fiH;
  private static final int fiI;
  private static final int fiJ;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eEI = true;
  private boolean eFy = true;
  private boolean eGi = true;
  private boolean eKj = true;
  private boolean eMB = true;
  private boolean eTP = true;
  private boolean fgu = true;
  private boolean fiD = true;
  private boolean fiE = true;
  private boolean fiF = true;
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
    eEL = "status".hashCode();
    type_HASHCODE = "type".hashCode();
    eGk = "scene".hashCode();
    fgF = "createtime".hashCode();
    eMP = "talker".hashCode();
    eFV = "content".hashCode();
    fiH = "sayhiuser".hashCode();
    fiI = "sayhicontent".hashCode();
    fiJ = "imgpath".hashCode();
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
      if (eUB != k) {
        break label65;
      }
      this.field_svrid = paramCursor.getLong(i);
      this.eTP = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eEL == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eGk == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (fgF == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (eMP == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (eFV == k) {
        this.field_content = paramCursor.getString(i);
      } else if (fiH == k) {
        this.field_sayhiuser = paramCursor.getString(i);
      } else if (fiI == k) {
        this.field_sayhicontent = paramCursor.getString(i);
      } else if (fiJ == k) {
        this.field_imgpath = paramCursor.getString(i);
      } else if (eKy == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eTP) {
      localContentValues.put("svrid", Long.valueOf(this.field_svrid));
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eGi) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.fgu) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.eMB) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.eFy) {
      localContentValues.put("content", this.field_content);
    }
    if (this.fiD) {
      localContentValues.put("sayhiuser", this.field_sayhiuser);
    }
    if (this.fiE) {
      localContentValues.put("sayhicontent", this.field_sayhicontent);
    }
    if (this.fiF) {
      localContentValues.put("imgpath", this.field_imgpath);
    }
    if (this.eKj) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fs
 * JD-Core Version:    0.7.0.1
 */