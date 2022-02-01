package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class df
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGY;
  private static final int eHf;
  private static final int eJC;
  private static final int eUE = "state".hashCode();
  private static final int fgD = "todoid".hashCode();
  private static final int fgE = "roomname".hashCode();
  private static final int fgF;
  private static final int fgG;
  private static final int fgH;
  private static final int fgI;
  private static final int fgJ;
  private static final int fgK;
  private static final int fgL = "netSceneState".hashCode();
  private static final int fgM = "shareKey".hashCode();
  private static final int fgN = "shareName".hashCode();
  private static final int fgn;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGV = true;
  private boolean eHb = true;
  private boolean eJz = true;
  private boolean eTS = true;
  private boolean fgA = true;
  private boolean fgB = true;
  private boolean fgC = true;
  private boolean fgi = true;
  private boolean fgs = true;
  private boolean fgt = true;
  private boolean fgu = true;
  private boolean fgv = true;
  private boolean fgw = true;
  private boolean fgx = true;
  private boolean fgy = true;
  private boolean fgz = true;
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
  
  static
  {
    eGY = "username".hashCode();
    eHf = "path".hashCode();
    fgF = "createtime".hashCode();
    fgG = "updatetime".hashCode();
    fgH = "custominfo".hashCode();
    eJC = "title".hashCode();
    fgn = "creator".hashCode();
    fgI = "related_msgids".hashCode();
    fgJ = "manager".hashCode();
    fgK = "nreply".hashCode();
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
      if (fgD != k) {
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
      if (fgE == k) {
        this.field_roomname = paramCursor.getString(i);
      } else if (eGY == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eHf == k) {
        this.field_path = paramCursor.getString(i);
      } else if (fgF == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (fgG == k) {
        this.field_updatetime = paramCursor.getLong(i);
      } else if (fgH == k) {
        this.field_custominfo = paramCursor.getString(i);
      } else if (eJC == k) {
        this.field_title = paramCursor.getString(i);
      } else if (fgn == k) {
        this.field_creator = paramCursor.getString(i);
      } else if (fgI == k) {
        this.field_related_msgids = paramCursor.getString(i);
      } else if (fgJ == k) {
        this.field_manager = paramCursor.getString(i);
      } else if (fgK == k) {
        this.field_nreply = paramCursor.getInt(i);
      } else if (eUE == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (fgL == k) {
        this.field_netSceneState = paramCursor.getInt(i);
      } else if (fgM == k) {
        this.field_shareKey = paramCursor.getString(i);
      } else if (fgN == k) {
        this.field_shareName = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fgs) {
      localContentValues.put("todoid", this.field_todoid);
    }
    if (this.fgt) {
      localContentValues.put("roomname", this.field_roomname);
    }
    if (this.eGV) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eHb) {
      localContentValues.put("path", this.field_path);
    }
    if (this.fgu) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.fgv) {
      localContentValues.put("updatetime", Long.valueOf(this.field_updatetime));
    }
    if (this.field_custominfo == null) {
      this.field_custominfo = "";
    }
    if (this.fgw) {
      localContentValues.put("custominfo", this.field_custominfo);
    }
    if (this.field_title == null) {
      this.field_title = "";
    }
    if (this.eJz) {
      localContentValues.put("title", this.field_title);
    }
    if (this.fgi) {
      localContentValues.put("creator", this.field_creator);
    }
    if (this.fgx) {
      localContentValues.put("related_msgids", this.field_related_msgids);
    }
    if (this.fgy) {
      localContentValues.put("manager", this.field_manager);
    }
    if (this.fgz) {
      localContentValues.put("nreply", Integer.valueOf(this.field_nreply));
    }
    if (this.eTS) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.fgA) {
      localContentValues.put("netSceneState", Integer.valueOf(this.field_netSceneState));
    }
    if (this.fgB) {
      localContentValues.put("shareKey", this.field_shareKey);
    }
    if (this.fgC) {
      localContentValues.put("shareName", this.field_shareName);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.df
 * JD-Core Version:    0.7.0.1
 */