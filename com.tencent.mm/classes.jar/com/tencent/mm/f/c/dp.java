package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class dp
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final Column C_UPDATETIME;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("GroupTodo");
  public static final Column hHa;
  private static final int hIC = "state".hashCode();
  public static final Column hWV;
  public static final Column hoC;
  private static final int hoK;
  public static final Column hsa;
  private static final int hsg;
  public static final Column ibW;
  private static final int icE;
  private static final int icF;
  private static final int icG;
  private static final int icH;
  private static final int icI;
  private static final int icJ;
  private static final int icK;
  private static final int icL;
  private static final int icM = "netSceneState".hashCode();
  private static final int icN = "shareKey".hashCode();
  private static final int icO = "shareName".hashCode();
  private static final int icg;
  public static final Column icl;
  public static final Column icm;
  public static final Column icn;
  public static final Column ico;
  public static final Column icp;
  public static final Column icq;
  public static final Column icr;
  public static final Column ics;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
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
  private boolean hHO = true;
  private boolean hoG = true;
  private boolean hsd = true;
  private boolean icA = true;
  private boolean icB = true;
  private boolean icC = true;
  private boolean icD = true;
  private boolean icb = true;
  private boolean ict = true;
  private boolean icu = true;
  private boolean icv = true;
  private boolean icw = true;
  private boolean icx = true;
  private boolean icy = true;
  private boolean icz = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "GroupTodo", "");
    icl = new Column("todoid", "string", "GroupTodo", "");
    hWV = new Column("roomname", "string", "GroupTodo", "");
    C_USERNAME = new Column("username", "string", "GroupTodo", "");
    hoC = new Column("path", "string", "GroupTodo", "");
    C_CREATETIME = new Column("createtime", "long", "GroupTodo", "");
    C_UPDATETIME = new Column("updatetime", "long", "GroupTodo", "");
    icm = new Column("custominfo", "string", "GroupTodo", "");
    hsa = new Column("title", "string", "GroupTodo", "");
    ibW = new Column("creator", "string", "GroupTodo", "");
    icn = new Column("related_msgids", "string", "GroupTodo", "");
    ico = new Column("manager", "string", "GroupTodo", "");
    icp = new Column("nreply", "int", "GroupTodo", "");
    hHa = new Column("state", "int", "GroupTodo", "");
    icq = new Column("netscenestate", "int", "GroupTodo", "");
    icr = new Column("sharekey", "string", "GroupTodo", "");
    ics = new Column("sharename", "string", "GroupTodo", "");
    icE = "todoid".hashCode();
    icF = "roomname".hashCode();
    username_HASHCODE = "username".hashCode();
    hoK = "path".hashCode();
    icG = "createtime".hashCode();
    icH = "updatetime".hashCode();
    icI = "custominfo".hashCode();
    hsg = "title".hashCode();
    icg = "creator".hashCode();
    icJ = "related_msgids".hashCode();
    icK = "manager".hashCode();
    icL = "nreply".hashCode();
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
      if (icE != k) {
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
      if (icF == k) {
        this.field_roomname = paramCursor.getString(i);
      } else if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (hoK == k) {
        this.field_path = paramCursor.getString(i);
      } else if (icG == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (icH == k) {
        this.field_updatetime = paramCursor.getLong(i);
      } else if (icI == k) {
        this.field_custominfo = paramCursor.getString(i);
      } else if (hsg == k) {
        this.field_title = paramCursor.getString(i);
      } else if (icg == k) {
        this.field_creator = paramCursor.getString(i);
      } else if (icJ == k) {
        this.field_related_msgids = paramCursor.getString(i);
      } else if (icK == k) {
        this.field_manager = paramCursor.getString(i);
      } else if (icL == k) {
        this.field_nreply = paramCursor.getInt(i);
      } else if (hIC == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (icM == k) {
        this.field_netSceneState = paramCursor.getInt(i);
      } else if (icN == k) {
        this.field_shareKey = paramCursor.getString(i);
      } else if (icO == k) {
        this.field_shareName = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ict) {
      localContentValues.put("todoid", this.field_todoid);
    }
    if (this.icu) {
      localContentValues.put("roomname", this.field_roomname);
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.hoG) {
      localContentValues.put("path", this.field_path);
    }
    if (this.icv) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.icw) {
      localContentValues.put("updatetime", Long.valueOf(this.field_updatetime));
    }
    if (this.field_custominfo == null) {
      this.field_custominfo = "";
    }
    if (this.icx) {
      localContentValues.put("custominfo", this.field_custominfo);
    }
    if (this.field_title == null) {
      this.field_title = "";
    }
    if (this.hsd) {
      localContentValues.put("title", this.field_title);
    }
    if (this.icb) {
      localContentValues.put("creator", this.field_creator);
    }
    if (this.icy) {
      localContentValues.put("related_msgids", this.field_related_msgids);
    }
    if (this.icz) {
      localContentValues.put("manager", this.field_manager);
    }
    if (this.icA) {
      localContentValues.put("nreply", Integer.valueOf(this.field_nreply));
    }
    if (this.hHO) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.icB) {
      localContentValues.put("netSceneState", Integer.valueOf(this.field_netSceneState));
    }
    if (this.icC) {
      localContentValues.put("shareKey", this.field_shareKey);
    }
    if (this.icD) {
      localContentValues.put("shareName", this.field_shareName);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "GroupTodo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.dp
 * JD-Core Version:    0.7.0.1
 */