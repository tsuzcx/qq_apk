package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class eb
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("GroupTodo");
  public static final Column UPDATETIME;
  public static final Column USERNAME;
  public static final Column jJJ;
  private static final int jKh;
  public static final Column jON;
  private static final int jOT;
  public static final Column kBA;
  public static final Column kBB;
  public static final Column kBC;
  public static final Column kBD;
  private static final int kBP;
  private static final int kBQ;
  private static final int kBR;
  private static final int kBS;
  private static final int kBT;
  private static final int kBU;
  private static final int kBV;
  private static final int kBW;
  private static final int kBX;
  private static final int kBY;
  private static final int kBZ;
  public static final Column kBh;
  private static final int kBr;
  public static final Column kBw;
  public static final Column kBx;
  public static final Column kBy;
  public static final Column kBz;
  public static final Column kee;
  private static final int kfH;
  public static final Column kwh;
  private static final StorageObserverOwner<eb> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
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
  private boolean jJV = true;
  private boolean jOQ = true;
  private boolean kBE = true;
  private boolean kBF = true;
  private boolean kBG = true;
  private boolean kBH = true;
  private boolean kBI = true;
  private boolean kBJ = true;
  private boolean kBK = true;
  private boolean kBL = true;
  private boolean kBM = true;
  private boolean kBN = true;
  private boolean kBO = true;
  private boolean kBm = true;
  private boolean keT = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kBw = new Column("todoid", "string", TABLE.getName(), "");
    kwh = new Column("roomname", "string", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    jJJ = new Column("path", "string", TABLE.getName(), "");
    CREATETIME = new Column("createtime", "long", TABLE.getName(), "");
    UPDATETIME = new Column("updatetime", "long", TABLE.getName(), "");
    kBx = new Column("custominfo", "string", TABLE.getName(), "");
    jON = new Column("title", "string", TABLE.getName(), "");
    kBh = new Column("creator", "string", TABLE.getName(), "");
    kBy = new Column("related_msgids", "string", TABLE.getName(), "");
    kBz = new Column("manager", "string", TABLE.getName(), "");
    kBA = new Column("nreply", "int", TABLE.getName(), "");
    kee = new Column("state", "int", TABLE.getName(), "");
    kBB = new Column("netSceneState", "int", TABLE.getName(), "");
    kBC = new Column("shareKey", "string", TABLE.getName(), "");
    kBD = new Column("shareName", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kBP = "todoid".hashCode();
    kBQ = "roomname".hashCode();
    username_HASHCODE = "username".hashCode();
    jKh = "path".hashCode();
    kBR = "createtime".hashCode();
    kBS = "updatetime".hashCode();
    kBT = "custominfo".hashCode();
    jOT = "title".hashCode();
    kBr = "creator".hashCode();
    kBU = "related_msgids".hashCode();
    kBV = "manager".hashCode();
    kBW = "nreply".hashCode();
    kfH = "state".hashCode();
    kBX = "netSceneState".hashCode();
    kBY = "shareKey".hashCode();
    kBZ = "shareName".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[16];
    localMAutoDBInfo.columns = new String[17];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "todoid";
    localMAutoDBInfo.colsMap.put("todoid", "TEXT");
    localStringBuilder.append(" todoid TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "roomname";
    localMAutoDBInfo.colsMap.put("roomname", "TEXT");
    localStringBuilder.append(" roomname TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "path";
    localMAutoDBInfo.colsMap.put("path", "TEXT");
    localStringBuilder.append(" path TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "createtime";
    localMAutoDBInfo.colsMap.put("createtime", "LONG");
    localStringBuilder.append(" createtime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "updatetime";
    localMAutoDBInfo.colsMap.put("updatetime", "LONG");
    localStringBuilder.append(" updatetime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "custominfo";
    localMAutoDBInfo.colsMap.put("custominfo", "TEXT default '' ");
    localStringBuilder.append(" custominfo TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "title";
    localMAutoDBInfo.colsMap.put("title", "TEXT default '' ");
    localStringBuilder.append(" title TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "creator";
    localMAutoDBInfo.colsMap.put("creator", "TEXT");
    localStringBuilder.append(" creator TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "related_msgids";
    localMAutoDBInfo.colsMap.put("related_msgids", "TEXT");
    localStringBuilder.append(" related_msgids TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "manager";
    localMAutoDBInfo.colsMap.put("manager", "TEXT");
    localStringBuilder.append(" manager TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "nreply";
    localMAutoDBInfo.colsMap.put("nreply", "INTEGER");
    localStringBuilder.append(" nreply INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "state";
    localMAutoDBInfo.colsMap.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "netSceneState";
    localMAutoDBInfo.colsMap.put("netSceneState", "INTEGER");
    localStringBuilder.append(" netSceneState INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "shareKey";
    localMAutoDBInfo.colsMap.put("shareKey", "TEXT");
    localStringBuilder.append(" shareKey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "shareName";
    localMAutoDBInfo.colsMap.put("shareName", "TEXT");
    localStringBuilder.append(" shareName TEXT");
    localMAutoDBInfo.columns[16] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("todoid"))
    {
      this.field_todoid = paramContentValues.getAsString("todoid");
      if (paramBoolean) {
        this.kBE = true;
      }
    }
    if (paramContentValues.containsKey("roomname"))
    {
      this.field_roomname = paramContentValues.getAsString("roomname");
      if (paramBoolean) {
        this.kBF = true;
      }
    }
    if (paramContentValues.containsKey("username"))
    {
      this.field_username = paramContentValues.getAsString("username");
      if (paramBoolean) {
        this.__hadSetusername = true;
      }
    }
    if (paramContentValues.containsKey("path"))
    {
      this.field_path = paramContentValues.getAsString("path");
      if (paramBoolean) {
        this.jJV = true;
      }
    }
    if (paramContentValues.containsKey("createtime"))
    {
      this.field_createtime = paramContentValues.getAsLong("createtime").longValue();
      if (paramBoolean) {
        this.kBG = true;
      }
    }
    if (paramContentValues.containsKey("updatetime"))
    {
      this.field_updatetime = paramContentValues.getAsLong("updatetime").longValue();
      if (paramBoolean) {
        this.kBH = true;
      }
    }
    if (paramContentValues.containsKey("custominfo"))
    {
      this.field_custominfo = paramContentValues.getAsString("custominfo");
      if (paramBoolean) {
        this.kBI = true;
      }
    }
    if (paramContentValues.containsKey("title"))
    {
      this.field_title = paramContentValues.getAsString("title");
      if (paramBoolean) {
        this.jOQ = true;
      }
    }
    if (paramContentValues.containsKey("creator"))
    {
      this.field_creator = paramContentValues.getAsString("creator");
      if (paramBoolean) {
        this.kBm = true;
      }
    }
    if (paramContentValues.containsKey("related_msgids"))
    {
      this.field_related_msgids = paramContentValues.getAsString("related_msgids");
      if (paramBoolean) {
        this.kBJ = true;
      }
    }
    if (paramContentValues.containsKey("manager"))
    {
      this.field_manager = paramContentValues.getAsString("manager");
      if (paramBoolean) {
        this.kBK = true;
      }
    }
    if (paramContentValues.containsKey("nreply"))
    {
      this.field_nreply = paramContentValues.getAsInteger("nreply").intValue();
      if (paramBoolean) {
        this.kBL = true;
      }
    }
    if (paramContentValues.containsKey("state"))
    {
      this.field_state = paramContentValues.getAsInteger("state").intValue();
      if (paramBoolean) {
        this.keT = true;
      }
    }
    if (paramContentValues.containsKey("netSceneState"))
    {
      this.field_netSceneState = paramContentValues.getAsInteger("netSceneState").intValue();
      if (paramBoolean) {
        this.kBM = true;
      }
    }
    if (paramContentValues.containsKey("shareKey"))
    {
      this.field_shareKey = paramContentValues.getAsString("shareKey");
      if (paramBoolean) {
        this.kBN = true;
      }
    }
    if (paramContentValues.containsKey("shareName"))
    {
      this.field_shareName = paramContentValues.getAsString("shareName");
      if (paramBoolean) {
        this.kBO = true;
      }
    }
    if (paramContentValues.containsKey("rowid")) {
      this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
    }
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
      if (kBP != k) {
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
      if (kBQ == k) {
        this.field_roomname = paramCursor.getString(i);
      } else if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (jKh == k) {
        this.field_path = paramCursor.getString(i);
      } else if (kBR == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (kBS == k) {
        this.field_updatetime = paramCursor.getLong(i);
      } else if (kBT == k) {
        this.field_custominfo = paramCursor.getString(i);
      } else if (jOT == k) {
        this.field_title = paramCursor.getString(i);
      } else if (kBr == k) {
        this.field_creator = paramCursor.getString(i);
      } else if (kBU == k) {
        this.field_related_msgids = paramCursor.getString(i);
      } else if (kBV == k) {
        this.field_manager = paramCursor.getString(i);
      } else if (kBW == k) {
        this.field_nreply = paramCursor.getInt(i);
      } else if (kfH == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (kBX == k) {
        this.field_netSceneState = paramCursor.getInt(i);
      } else if (kBY == k) {
        this.field_shareKey = paramCursor.getString(i);
      } else if (kBZ == k) {
        this.field_shareName = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kBE) {
      localContentValues.put("todoid", this.field_todoid);
    }
    if (this.kBF) {
      localContentValues.put("roomname", this.field_roomname);
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.jJV) {
      localContentValues.put("path", this.field_path);
    }
    if (this.kBG) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.kBH) {
      localContentValues.put("updatetime", Long.valueOf(this.field_updatetime));
    }
    if (this.field_custominfo == null) {
      this.field_custominfo = "";
    }
    if (this.kBI) {
      localContentValues.put("custominfo", this.field_custominfo);
    }
    if (this.field_title == null) {
      this.field_title = "";
    }
    if (this.jOQ) {
      localContentValues.put("title", this.field_title);
    }
    if (this.kBm) {
      localContentValues.put("creator", this.field_creator);
    }
    if (this.kBJ) {
      localContentValues.put("related_msgids", this.field_related_msgids);
    }
    if (this.kBK) {
      localContentValues.put("manager", this.field_manager);
    }
    if (this.kBL) {
      localContentValues.put("nreply", Integer.valueOf(this.field_nreply));
    }
    if (this.keT) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if (this.kBM) {
      localContentValues.put("netSceneState", Integer.valueOf(this.field_netSceneState));
    }
    if (this.kBN) {
      localContentValues.put("shareKey", this.field_shareKey);
    }
    if (this.kBO) {
      localContentValues.put("shareName", this.field_shareName);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends eb> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.systemRowid);
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.b.eb
 * JD-Core Version:    0.7.0.1
 */