package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class df
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFp;
  private static final int eFw;
  private static final int eHT;
  private static final int eST = "state".hashCode();
  private static final int feI = "todoid".hashCode();
  private static final int feJ = "roomname".hashCode();
  private static final int feK;
  private static final int feL;
  private static final int feM;
  private static final int feN;
  private static final int feO;
  private static final int feP;
  private static final int feQ = "netSceneState".hashCode();
  private static final int feu;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFm = true;
  private boolean eFs = true;
  private boolean eHQ = true;
  private boolean eSh = true;
  private boolean feA = true;
  private boolean feB = true;
  private boolean feC = true;
  private boolean feD = true;
  private boolean feE = true;
  private boolean feF = true;
  private boolean feG = true;
  private boolean feH = true;
  private boolean fep = true;
  private boolean fez = true;
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
    eFp = "username".hashCode();
    eFw = "path".hashCode();
    feK = "createtime".hashCode();
    feL = "updatetime".hashCode();
    feM = "custominfo".hashCode();
    eHT = "title".hashCode();
    feu = "creator".hashCode();
    feN = "related_msgids".hashCode();
    feO = "manager".hashCode();
    feP = "nreply".hashCode();
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
      if (feI != k) {
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
      if (feJ == k) {
        this.field_roomname = paramCursor.getString(i);
      } else if (eFp == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eFw == k) {
        this.field_path = paramCursor.getString(i);
      } else if (feK == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (feL == k) {
        this.field_updatetime = paramCursor.getLong(i);
      } else if (feM == k) {
        this.field_custominfo = paramCursor.getString(i);
      } else if (eHT == k) {
        this.field_title = paramCursor.getString(i);
      } else if (feu == k) {
        this.field_creator = paramCursor.getString(i);
      } else if (feN == k) {
        this.field_related_msgids = paramCursor.getString(i);
      } else if (feO == k) {
        this.field_manager = paramCursor.getString(i);
      } else if (feP == k) {
        this.field_nreply = paramCursor.getInt(i);
      } else if (eST == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (feQ == k) {
        this.field_netSceneState = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fez) {
      localContentValues.put("todoid", this.field_todoid);
    }
    if (this.feA) {
      localContentValues.put("roomname", this.field_roomname);
    }
    if (this.eFm) {
      localContentValues.put("username", this.field_username);
    }
    if (this.field_path == null) {
      this.field_path = "小程序字段";
    }
    if (this.eFs) {
      localContentValues.put("path", this.field_path);
    }
    if (this.feB) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.feC) {
      localContentValues.put("updatetime", Long.valueOf(this.field_updatetime));
    }
    if (this.field_custominfo == null) {
      this.field_custominfo = "";
    }
    if (this.feD) {
      localContentValues.put("custominfo", this.field_custominfo);
    }
    if (this.field_title == null) {
      this.field_title = "";
    }
    if (this.eHQ) {
      localContentValues.put("title", this.field_title);
    }
    if (this.field_creator == null) {
      this.field_creator = "创建者username";
    }
    if (this.fep) {
      localContentValues.put("creator", this.field_creator);
    }
    if (this.feE) {
      localContentValues.put("related_msgids", this.field_related_msgids);
    }
    if (this.field_manager == null) {
      this.field_manager = "管理员username";
    }
    if (this.feF) {
      localContentValues.put("manager", this.field_manager);
    }
    if (this.feG) {
      localContentValues.put("nreply", Integer.valueOf(this.field_nreply));
    }
    if (this.eSh) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.feH) {
      localContentValues.put("netSceneState", Integer.valueOf(this.field_netSceneState));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.df
 * JD-Core Version:    0.7.0.1
 */