package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dl
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS lbsverifymessage_unread_index ON LBSVerifyMessage(status)", "CREATE INDEX IF NOT EXISTS lbsverifymessage_createtimeIndex ON LBSVerifyMessage(createtime)" };
  private static final int eBs = "svrid".hashCode();
  private static final int eMo;
  private static final int eOn;
  private static final int eOo;
  private static final int eOp;
  private static final int eOq = "sayhiencryptuser".hashCode();
  private static final int elV = "status".hashCode();
  private static final int eng;
  private static final int env;
  private static final int enw = "ticket".hashCode();
  private static final int eqO = "flag".hashCode();
  private static final int erG;
  private static final int etX;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eAG = true;
  private boolean eMf = true;
  private boolean eOj = true;
  private boolean eOk = true;
  private boolean eOl = true;
  private boolean eOm = true;
  private boolean elS = true;
  private boolean emI = true;
  private boolean ent = true;
  private boolean enu = true;
  private boolean eqM = true;
  private boolean err = true;
  private boolean etJ = true;
  public String field_content;
  public long field_createtime;
  public int field_flag;
  public String field_imgpath;
  public int field_isSend;
  public String field_sayhicontent;
  public String field_sayhiencryptuser;
  public String field_sayhiuser;
  public int field_scene;
  public int field_status;
  public long field_svrid;
  public String field_talker;
  public String field_ticket;
  public int field_type;
  
  static
  {
    env = "scene".hashCode();
    eMo = "createtime".hashCode();
    etX = "talker".hashCode();
    eng = "content".hashCode();
    eOn = "sayhiuser".hashCode();
    eOo = "sayhicontent".hashCode();
    eOp = "imgpath".hashCode();
    erG = "isSend".hashCode();
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
      if (eBs != k) {
        break label65;
      }
      this.field_svrid = paramCursor.getLong(i);
      this.eAG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (elV == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (env == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (eMo == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (etX == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (eng == k) {
        this.field_content = paramCursor.getString(i);
      } else if (eOn == k) {
        this.field_sayhiuser = paramCursor.getString(i);
      } else if (eOo == k) {
        this.field_sayhicontent = paramCursor.getString(i);
      } else if (eOp == k) {
        this.field_imgpath = paramCursor.getString(i);
      } else if (erG == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (eOq == k) {
        this.field_sayhiencryptuser = paramCursor.getString(i);
      } else if (enw == k) {
        this.field_ticket = paramCursor.getString(i);
      } else if (eqO == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eAG) {
      localContentValues.put("svrid", Long.valueOf(this.field_svrid));
    }
    if (this.elS) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.ent) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.eMf) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.etJ) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.emI) {
      localContentValues.put("content", this.field_content);
    }
    if (this.eOj) {
      localContentValues.put("sayhiuser", this.field_sayhiuser);
    }
    if (this.eOk) {
      localContentValues.put("sayhicontent", this.field_sayhicontent);
    }
    if (this.eOl) {
      localContentValues.put("imgpath", this.field_imgpath);
    }
    if (this.err) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.eOm) {
      localContentValues.put("sayhiencryptuser", this.field_sayhiencryptuser);
    }
    if (this.enu) {
      localContentValues.put("ticket", this.field_ticket);
    }
    if (this.eqM) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.dl
 * JD-Core Version:    0.7.0.1
 */