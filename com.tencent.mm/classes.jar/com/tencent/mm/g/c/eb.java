package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class eb
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS lbsverifymessage_unread_index ON LBSVerifyMessage(status)", "CREATE INDEX IF NOT EXISTS lbsverifymessage_createtimeIndex ON LBSVerifyMessage(createtime)" };
  private static final int content_HASHCODE;
  private static final int fLi;
  private static final int fNl;
  private static final int fNm;
  private static final int fNn;
  private static final int fNo = "sayhiencryptuser".hashCode();
  private static final int fjQ;
  private static final int fjR = "ticket".hashCode();
  private static final int fjl;
  private static final int fni = "flag".hashCode();
  private static final int foe;
  private static final int fqw;
  private static final int fyg = "svrid".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSetcontent = true;
  private boolean __hadSettype = true;
  private boolean fKX = true;
  private boolean fNh = true;
  private boolean fNi = true;
  private boolean fNj = true;
  private boolean fNk = true;
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
  private boolean fjO = true;
  private boolean fjP = true;
  private boolean fji = true;
  private boolean fnP = true;
  private boolean fng = true;
  private boolean fqi = true;
  private boolean fxu = true;
  
  static
  {
    fjl = "status".hashCode();
    type_HASHCODE = "type".hashCode();
    fjQ = "scene".hashCode();
    fLi = "createtime".hashCode();
    fqw = "talker".hashCode();
    content_HASHCODE = "content".hashCode();
    fNl = "sayhiuser".hashCode();
    fNm = "sayhicontent".hashCode();
    fNn = "imgpath".hashCode();
    foe = "isSend".hashCode();
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
      if (fyg != k) {
        break label65;
      }
      this.field_svrid = paramCursor.getLong(i);
      this.fxu = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fjl == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (fjQ == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (fLi == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (fqw == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (fNl == k) {
        this.field_sayhiuser = paramCursor.getString(i);
      } else if (fNm == k) {
        this.field_sayhicontent = paramCursor.getString(i);
      } else if (fNn == k) {
        this.field_imgpath = paramCursor.getString(i);
      } else if (foe == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (fNo == k) {
        this.field_sayhiencryptuser = paramCursor.getString(i);
      } else if (fjR == k) {
        this.field_ticket = paramCursor.getString(i);
      } else if (fni == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fxu) {
      localContentValues.put("svrid", Long.valueOf(this.field_svrid));
    }
    if (this.fji) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.fjO) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.fKX) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.fqi) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.fNh) {
      localContentValues.put("sayhiuser", this.field_sayhiuser);
    }
    if (this.fNi) {
      localContentValues.put("sayhicontent", this.field_sayhicontent);
    }
    if (this.fNj) {
      localContentValues.put("imgpath", this.field_imgpath);
    }
    if (this.fnP) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.fNk) {
      localContentValues.put("sayhiencryptuser", this.field_sayhiencryptuser);
    }
    if (this.fjP) {
      localContentValues.put("ticket", this.field_ticket);
    }
    if (this.fng) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.eb
 * JD-Core Version:    0.7.0.1
 */