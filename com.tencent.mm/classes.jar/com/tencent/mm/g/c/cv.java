package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cv
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eBv = "state".hashCode();
  private static final int eLY;
  private static final int eMm = "todoid".hashCode();
  private static final int eMn = "roomname".hashCode();
  private static final int eMo;
  private static final int eMp;
  private static final int eMq;
  private static final int eMr;
  private static final int eMs;
  private static final int eMt;
  private static final int eMu = "netSceneState".hashCode();
  private static final int eok = "username".hashCode();
  private static final int eor = "path".hashCode();
  private static final int eqK;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAJ = true;
  private boolean eLT = true;
  private boolean eMd = true;
  private boolean eMe = true;
  private boolean eMf = true;
  private boolean eMg = true;
  private boolean eMh = true;
  private boolean eMi = true;
  private boolean eMj = true;
  private boolean eMk = true;
  private boolean eMl = true;
  private boolean eoh = true;
  private boolean eon = true;
  private boolean eqH = true;
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
    eMo = "createtime".hashCode();
    eMp = "updatetime".hashCode();
    eMq = "custominfo".hashCode();
    eqK = "title".hashCode();
    eLY = "creator".hashCode();
    eMr = "related_msgids".hashCode();
    eMs = "manager".hashCode();
    eMt = "nreply".hashCode();
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
      if (eMm != k) {
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
      if (eMn == k) {
        this.field_roomname = paramCursor.getString(i);
      } else if (eok == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eor == k) {
        this.field_path = paramCursor.getString(i);
      } else if (eMo == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (eMp == k) {
        this.field_updatetime = paramCursor.getLong(i);
      } else if (eMq == k) {
        this.field_custominfo = paramCursor.getString(i);
      } else if (eqK == k) {
        this.field_title = paramCursor.getString(i);
      } else if (eLY == k) {
        this.field_creator = paramCursor.getString(i);
      } else if (eMr == k) {
        this.field_related_msgids = paramCursor.getString(i);
      } else if (eMs == k) {
        this.field_manager = paramCursor.getString(i);
      } else if (eMt == k) {
        this.field_nreply = paramCursor.getInt(i);
      } else if (eBv == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (eMu == k) {
        this.field_netSceneState = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eMd) {
      localContentValues.put("todoid", this.field_todoid);
    }
    if (this.eMe) {
      localContentValues.put("roomname", this.field_roomname);
    }
    if (this.eoh) {
      localContentValues.put("username", this.field_username);
    }
    if (this.field_path == null) {
      this.field_path = "小程序字段";
    }
    if (this.eon) {
      localContentValues.put("path", this.field_path);
    }
    if (this.eMf) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.eMg) {
      localContentValues.put("updatetime", Long.valueOf(this.field_updatetime));
    }
    if (this.field_custominfo == null) {
      this.field_custominfo = "";
    }
    if (this.eMh) {
      localContentValues.put("custominfo", this.field_custominfo);
    }
    if (this.field_title == null) {
      this.field_title = "";
    }
    if (this.eqH) {
      localContentValues.put("title", this.field_title);
    }
    if (this.field_creator == null) {
      this.field_creator = "创建者username";
    }
    if (this.eLT) {
      localContentValues.put("creator", this.field_creator);
    }
    if (this.eMi) {
      localContentValues.put("related_msgids", this.field_related_msgids);
    }
    if (this.field_manager == null) {
      this.field_manager = "管理员username";
    }
    if (this.eMj) {
      localContentValues.put("manager", this.field_manager);
    }
    if (this.eMk) {
      localContentValues.put("nreply", Integer.valueOf(this.field_nreply));
    }
    if (this.eAJ) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.eMl) {
      localContentValues.put("netSceneState", Integer.valueOf(this.field_netSceneState));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.cv
 * JD-Core Version:    0.7.0.1
 */