package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dv
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS lbsverifymessage_unread_index ON LBSVerifyMessage(status)", "CREATE INDEX IF NOT EXISTS lbsverifymessage_createtimeIndex ON LBSVerifyMessage(createtime)" };
  private static final int eDc;
  private static final int eEB;
  private static final int eEC = "ticket".hashCode();
  private static final int eEm;
  private static final int eHX = "flag".hashCode();
  private static final int eIP;
  private static final int eLf;
  private static final int eSQ = "svrid".hashCode();
  private static final int feK;
  private static final int fgJ;
  private static final int fgK;
  private static final int fgL;
  private static final int fgM;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eCZ = true;
  private boolean eDP = true;
  private boolean eEA = true;
  private boolean eEz = true;
  private boolean eHV = true;
  private boolean eIA = true;
  private boolean eKS = true;
  private boolean eSe = true;
  private boolean feB = true;
  private boolean fgF = true;
  private boolean fgG = true;
  private boolean fgH = true;
  private boolean fgI = true;
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
    eDc = "status".hashCode();
    type_HASHCODE = "type".hashCode();
    eEB = "scene".hashCode();
    feK = "createtime".hashCode();
    eLf = "talker".hashCode();
    eEm = "content".hashCode();
    fgJ = "sayhiuser".hashCode();
    fgK = "sayhicontent".hashCode();
    fgL = "imgpath".hashCode();
    eIP = "isSend".hashCode();
    fgM = "sayhiencryptuser".hashCode();
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
      if (eSQ != k) {
        break label65;
      }
      this.field_svrid = paramCursor.getLong(i);
      this.eSe = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eDc == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eEB == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (feK == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (eLf == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (eEm == k) {
        this.field_content = paramCursor.getString(i);
      } else if (fgJ == k) {
        this.field_sayhiuser = paramCursor.getString(i);
      } else if (fgK == k) {
        this.field_sayhicontent = paramCursor.getString(i);
      } else if (fgL == k) {
        this.field_imgpath = paramCursor.getString(i);
      } else if (eIP == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (fgM == k) {
        this.field_sayhiencryptuser = paramCursor.getString(i);
      } else if (eEC == k) {
        this.field_ticket = paramCursor.getString(i);
      } else if (eHX == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eSe) {
      localContentValues.put("svrid", Long.valueOf(this.field_svrid));
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eEz) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.feB) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.eKS) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.eDP) {
      localContentValues.put("content", this.field_content);
    }
    if (this.fgF) {
      localContentValues.put("sayhiuser", this.field_sayhiuser);
    }
    if (this.fgG) {
      localContentValues.put("sayhicontent", this.field_sayhicontent);
    }
    if (this.fgH) {
      localContentValues.put("imgpath", this.field_imgpath);
    }
    if (this.eIA) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.fgI) {
      localContentValues.put("sayhiencryptuser", this.field_sayhiencryptuser);
    }
    if (this.eEA) {
      localContentValues.put("ticket", this.field_ticket);
    }
    if (this.eHV) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.dv
 * JD-Core Version:    0.7.0.1
 */