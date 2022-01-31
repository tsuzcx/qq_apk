package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cn
  extends c
{
  private static final int cFD;
  private static final int cOc;
  private static final int cOd;
  private static final int cOe;
  private static final int cOf;
  private static final int cOg;
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS lbsverifymessage_unread_index ON LBSVerifyMessage(status)", "CREATE INDEX IF NOT EXISTS lbsverifymessage_createtimeIndex ON LBSVerifyMessage(createtime)" };
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int csD;
  private static final int csS;
  private static final int csT;
  private static final int csy;
  private static final int cwe;
  private static final int cxd;
  private static final int czg;
  private boolean cFa = true;
  private boolean cNX = true;
  private boolean cNY = true;
  private boolean cNZ = true;
  private boolean cOa = true;
  private boolean cOb = true;
  private boolean crk = true;
  private boolean csQ = true;
  private boolean csR = true;
  private boolean csa = true;
  private boolean csf = true;
  private boolean cwP = true;
  private boolean cwc = true;
  private boolean cyV = true;
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
    cFD = "svrid".hashCode();
    crn = "status".hashCode();
    csy = "type".hashCode();
    csS = "scene".hashCode();
    cOc = "createtime".hashCode();
    czg = "talker".hashCode();
    csD = "content".hashCode();
    cOd = "sayhiuser".hashCode();
    cOe = "sayhicontent".hashCode();
    cOf = "imgpath".hashCode();
    cxd = "isSend".hashCode();
    cOg = "sayhiencryptuser".hashCode();
    csT = "ticket".hashCode();
    cwe = "flag".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cFD != k) {
        break label65;
      }
      this.field_svrid = paramCursor.getLong(i);
      this.cFa = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (crn == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (csy == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (csS == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (cOc == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (czg == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (csD == k) {
        this.field_content = paramCursor.getString(i);
      } else if (cOd == k) {
        this.field_sayhiuser = paramCursor.getString(i);
      } else if (cOe == k) {
        this.field_sayhicontent = paramCursor.getString(i);
      } else if (cOf == k) {
        this.field_imgpath = paramCursor.getString(i);
      } else if (cxd == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (cOg == k) {
        this.field_sayhiencryptuser = paramCursor.getString(i);
      } else if (csT == k) {
        this.field_ticket = paramCursor.getString(i);
      } else if (cwe == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cFa) {
      localContentValues.put("svrid", Long.valueOf(this.field_svrid));
    }
    if (this.crk) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.csa) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.csQ) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.cNX) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.cyV) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.csf) {
      localContentValues.put("content", this.field_content);
    }
    if (this.cNY) {
      localContentValues.put("sayhiuser", this.field_sayhiuser);
    }
    if (this.cNZ) {
      localContentValues.put("sayhicontent", this.field_sayhicontent);
    }
    if (this.cOa) {
      localContentValues.put("imgpath", this.field_imgpath);
    }
    if (this.cwP) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.cOb) {
      localContentValues.put("sayhiencryptuser", this.field_sayhiencryptuser);
    }
    if (this.csR) {
      localContentValues.put("ticket", this.field_ticket);
    }
    if (this.cwc) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.h.c.cn
 * JD-Core Version:    0.7.0.1
 */