package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dl
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fKQ;
  private static final int fLg = "todoid".hashCode();
  private static final int fLh = "roomname".hashCode();
  private static final int fLi;
  private static final int fLj;
  private static final int fLk;
  private static final int fLl;
  private static final int fLm;
  private static final int fLn;
  private static final int fLo = "netSceneState".hashCode();
  private static final int fLp = "shareKey".hashCode();
  private static final int fLq = "shareName".hashCode();
  private static final int fkH;
  private static final int fne;
  private static final int fyj;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE = "username".hashCode();
  private boolean __hadSetusername = true;
  private boolean fKL = true;
  private boolean fKV = true;
  private boolean fKW = true;
  private boolean fKX = true;
  private boolean fKY = true;
  private boolean fKZ = true;
  private boolean fLa = true;
  private boolean fLb = true;
  private boolean fLc = true;
  private boolean fLd = true;
  private boolean fLe = true;
  private boolean fLf = true;
  public long field_createtime;
  public String field_creator;
  public String field_custominfo;
  public String field_manager;
  public int field_netSceneState;
  public int field_nreply;
  public String field_path;
  public String field_related_msgids;
  public String field_roomname;
  public String field_shareKey;
  public String field_shareName;
  public int field_state;
  public String field_title;
  public String field_todoid;
  public long field_updatetime;
  public String field_username;
  private boolean fkD = true;
  private boolean fnb = true;
  private boolean fxx = true;
  
  static
  {
    fkH = "path".hashCode();
    fLi = "createtime".hashCode();
    fLj = "updatetime".hashCode();
    fLk = "custominfo".hashCode();
    fne = "title".hashCode();
    fKQ = "creator".hashCode();
    fLl = "related_msgids".hashCode();
    fLm = "manager".hashCode();
    fLn = "nreply".hashCode();
    fyj = "state".hashCode();
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
      if (fLg != k) {
        break label60;
      }
      this.field_todoid = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (fLh == k) {
        this.field_roomname = paramCursor.getString(i);
      } else if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (fkH == k) {
        this.field_path = paramCursor.getString(i);
      } else if (fLi == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (fLj == k) {
        this.field_updatetime = paramCursor.getLong(i);
      } else if (fLk == k) {
        this.field_custominfo = paramCursor.getString(i);
      } else if (fne == k) {
        this.field_title = paramCursor.getString(i);
      } else if (fKQ == k) {
        this.field_creator = paramCursor.getString(i);
      } else if (fLl == k) {
        this.field_related_msgids = paramCursor.getString(i);
      } else if (fLm == k) {
        this.field_manager = paramCursor.getString(i);
      } else if (fLn == k) {
        this.field_nreply = paramCursor.getInt(i);
      } else if (fyj == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (fLo == k) {
        this.field_netSceneState = paramCursor.getInt(i);
      } else if (fLp == k) {
        this.field_shareKey = paramCursor.getString(i);
      } else if (fLq == k) {
        this.field_shareName = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fKV) {
      localContentValues.put("todoid", this.field_todoid);
    }
    if (this.fKW) {
      localContentValues.put("roomname", this.field_roomname);
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.fkD) {
      localContentValues.put("path", this.field_path);
    }
    if (this.fKX) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.fKY) {
      localContentValues.put("updatetime", Long.valueOf(this.field_updatetime));
    }
    if (this.field_custominfo == null) {
      this.field_custominfo = "";
    }
    if (this.fKZ) {
      localContentValues.put("custominfo", this.field_custominfo);
    }
    if (this.field_title == null) {
      this.field_title = "";
    }
    if (this.fnb) {
      localContentValues.put("title", this.field_title);
    }
    if (this.fKL) {
      localContentValues.put("creator", this.field_creator);
    }
    if (this.fLa) {
      localContentValues.put("related_msgids", this.field_related_msgids);
    }
    if (this.fLb) {
      localContentValues.put("manager", this.field_manager);
    }
    if (this.fLc) {
      localContentValues.put("nreply", Integer.valueOf(this.field_nreply));
    }
    if (this.fxx) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.fLd) {
      localContentValues.put("netSceneState", Integer.valueOf(this.field_netSceneState));
    }
    if (this.fLe) {
      localContentValues.put("shareKey", this.field_shareKey);
    }
    if (this.fLf) {
      localContentValues.put("shareName", this.field_shareName);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.dl
 * JD-Core Version:    0.7.0.1
 */