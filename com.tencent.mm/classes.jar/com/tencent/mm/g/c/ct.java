package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ct
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eJA;
  private static final int eJB;
  private static final int eJC = "netSceneState".hashCode();
  private static final int eJg;
  private static final int eJu = "todoid".hashCode();
  private static final int eJv = "roomname".hashCode();
  private static final int eJw;
  private static final int eJx;
  private static final int eJy;
  private static final int eJz;
  private static final int eme = "username".hashCode();
  private static final int eml = "path".hashCode();
  private static final int eoG;
  private static final int ezb;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eJb = true;
  private boolean eJl = true;
  private boolean eJm = true;
  private boolean eJn = true;
  private boolean eJo = true;
  private boolean eJp = true;
  private boolean eJq = true;
  private boolean eJr = true;
  private boolean eJs = true;
  private boolean eJt = true;
  private boolean emb = true;
  private boolean emh = true;
  private boolean eoD = true;
  private boolean eyp = true;
  public long field_createtime;
  public String field_creator;
  public String field_custominfo;
  public String field_manager;
  public int field_netSceneState;
  public int field_nreply;
  public String field_path;
  public String field_related_msgids;
  public String field_roomname;
  public int field_state;
  public String field_title;
  public String field_todoid;
  public long field_updatetime;
  public String field_username;
  
  static
  {
    eJw = "createtime".hashCode();
    eJx = "updatetime".hashCode();
    eJy = "custominfo".hashCode();
    eoG = "title".hashCode();
    eJg = "creator".hashCode();
    eJz = "related_msgids".hashCode();
    eJA = "manager".hashCode();
    eJB = "nreply".hashCode();
    ezb = "state".hashCode();
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
      if (eJu != k) {
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
      if (eJv == k) {
        this.field_roomname = paramCursor.getString(i);
      } else if (eme == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eml == k) {
        this.field_path = paramCursor.getString(i);
      } else if (eJw == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (eJx == k) {
        this.field_updatetime = paramCursor.getLong(i);
      } else if (eJy == k) {
        this.field_custominfo = paramCursor.getString(i);
      } else if (eoG == k) {
        this.field_title = paramCursor.getString(i);
      } else if (eJg == k) {
        this.field_creator = paramCursor.getString(i);
      } else if (eJz == k) {
        this.field_related_msgids = paramCursor.getString(i);
      } else if (eJA == k) {
        this.field_manager = paramCursor.getString(i);
      } else if (eJB == k) {
        this.field_nreply = paramCursor.getInt(i);
      } else if (ezb == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (eJC == k) {
        this.field_netSceneState = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eJl) {
      localContentValues.put("todoid", this.field_todoid);
    }
    if (this.eJm) {
      localContentValues.put("roomname", this.field_roomname);
    }
    if (this.emb) {
      localContentValues.put("username", this.field_username);
    }
    if (this.field_path == null) {
      this.field_path = "小程序字段";
    }
    if (this.emh) {
      localContentValues.put("path", this.field_path);
    }
    if (this.eJn) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.eJo) {
      localContentValues.put("updatetime", Long.valueOf(this.field_updatetime));
    }
    if (this.field_custominfo == null) {
      this.field_custominfo = "";
    }
    if (this.eJp) {
      localContentValues.put("custominfo", this.field_custominfo);
    }
    if (this.field_title == null) {
      this.field_title = "";
    }
    if (this.eoD) {
      localContentValues.put("title", this.field_title);
    }
    if (this.field_creator == null) {
      this.field_creator = "创建者username";
    }
    if (this.eJb) {
      localContentValues.put("creator", this.field_creator);
    }
    if (this.eJq) {
      localContentValues.put("related_msgids", this.field_related_msgids);
    }
    if (this.field_manager == null) {
      this.field_manager = "管理员username";
    }
    if (this.eJr) {
      localContentValues.put("manager", this.field_manager);
    }
    if (this.eJs) {
      localContentValues.put("nreply", Integer.valueOf(this.field_nreply));
    }
    if (this.eyp) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.eJt) {
      localContentValues.put("netSceneState", Integer.valueOf(this.field_netSceneState));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ct
 * JD-Core Version:    0.7.0.1
 */