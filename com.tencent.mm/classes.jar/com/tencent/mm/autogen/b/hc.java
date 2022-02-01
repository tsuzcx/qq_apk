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

public abstract class hc
  extends IAutoDBItem
{
  public static final Column CONTENT;
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("ShakeVerifyMessage");
  public static final Column TYPE;
  private static final int content_HASHCODE;
  private static final int jIF;
  public static final Column jIz;
  private static final int jJD;
  public static final Column jJz;
  public static final Column jPQ;
  private static final int jQu;
  public static final Column jTB;
  public static final Column jTC;
  private static final int jUd;
  private static final int kBR;
  public static final Column kES;
  public static final Column kET;
  private static final int kEZ;
  private static final int kFa;
  private static final int kFb;
  public static final Column keb;
  private static final int kfE;
  private static final StorageObserverOwner<hc> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private boolean __hadSetcontent = true;
  private boolean __hadSettype = true;
  public String field_content;
  public long field_createtime;
  public String field_imgpath;
  public int field_isSend;
  public String field_sayhicontent;
  public String field_sayhiuser;
  public int field_scene;
  public int field_status;
  public long field_svrid;
  public String field_talker;
  public int field_type;
  private boolean jIC = true;
  private boolean jJB = true;
  private boolean jQf = true;
  private boolean jTP = true;
  private boolean kBG = true;
  private boolean kEV = true;
  private boolean kEW = true;
  private boolean kEX = true;
  private boolean keQ = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    keb = new Column("svrid", "long", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    jJz = new Column("scene", "int", TABLE.getName(), "");
    CREATETIME = new Column("createtime", "long", TABLE.getName(), "");
    jTB = new Column("talker", "string", TABLE.getName(), "");
    CONTENT = new Column("content", "string", TABLE.getName(), "");
    kES = new Column("sayhiuser", "string", TABLE.getName(), "");
    kET = new Column("sayhicontent", "string", TABLE.getName(), "");
    jTC = new Column("imgpath", "string", TABLE.getName(), "");
    jPQ = new Column("isSend", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kfE = "svrid".hashCode();
    jIF = "status".hashCode();
    type_HASHCODE = "type".hashCode();
    jJD = "scene".hashCode();
    kBR = "createtime".hashCode();
    jUd = "talker".hashCode();
    content_HASHCODE = "content".hashCode();
    kEZ = "sayhiuser".hashCode();
    kFa = "sayhicontent".hashCode();
    kFb = "imgpath".hashCode();
    jQu = "isSend".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[11];
    localMAutoDBInfo.columns = new String[12];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "svrid";
    localMAutoDBInfo.colsMap.put("svrid", "LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(" svrid LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "svrid";
    localMAutoDBInfo.columns[1] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "scene";
    localMAutoDBInfo.colsMap.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "createtime";
    localMAutoDBInfo.colsMap.put("createtime", "LONG");
    localStringBuilder.append(" createtime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "talker";
    localMAutoDBInfo.colsMap.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "sayhiuser";
    localMAutoDBInfo.colsMap.put("sayhiuser", "TEXT");
    localStringBuilder.append(" sayhiuser TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "sayhicontent";
    localMAutoDBInfo.colsMap.put("sayhicontent", "TEXT");
    localStringBuilder.append(" sayhicontent TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "imgpath";
    localMAutoDBInfo.colsMap.put("imgpath", "TEXT");
    localStringBuilder.append(" imgpath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "isSend";
    localMAutoDBInfo.colsMap.put("isSend", "INTEGER");
    localStringBuilder.append(" isSend INTEGER");
    localMAutoDBInfo.columns[11] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("svrid"))
    {
      this.field_svrid = paramContentValues.getAsLong("svrid").longValue();
      if (paramBoolean) {
        this.keQ = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsInteger("type").intValue();
      if (paramBoolean) {
        this.__hadSettype = true;
      }
    }
    if (paramContentValues.containsKey("scene"))
    {
      this.field_scene = paramContentValues.getAsInteger("scene").intValue();
      if (paramBoolean) {
        this.jJB = true;
      }
    }
    if (paramContentValues.containsKey("createtime"))
    {
      this.field_createtime = paramContentValues.getAsLong("createtime").longValue();
      if (paramBoolean) {
        this.kBG = true;
      }
    }
    if (paramContentValues.containsKey("talker"))
    {
      this.field_talker = paramContentValues.getAsString("talker");
      if (paramBoolean) {
        this.jTP = true;
      }
    }
    if (paramContentValues.containsKey("content"))
    {
      this.field_content = paramContentValues.getAsString("content");
      if (paramBoolean) {
        this.__hadSetcontent = true;
      }
    }
    if (paramContentValues.containsKey("sayhiuser"))
    {
      this.field_sayhiuser = paramContentValues.getAsString("sayhiuser");
      if (paramBoolean) {
        this.kEV = true;
      }
    }
    if (paramContentValues.containsKey("sayhicontent"))
    {
      this.field_sayhicontent = paramContentValues.getAsString("sayhicontent");
      if (paramBoolean) {
        this.kEW = true;
      }
    }
    if (paramContentValues.containsKey("imgpath"))
    {
      this.field_imgpath = paramContentValues.getAsString("imgpath");
      if (paramBoolean) {
        this.kEX = true;
      }
    }
    if (paramContentValues.containsKey("isSend"))
    {
      this.field_isSend = paramContentValues.getAsInteger("isSend").intValue();
      if (paramBoolean) {
        this.jQf = true;
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
      if (kfE != k) {
        break label65;
      }
      this.field_svrid = paramCursor.getLong(i);
      this.keQ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jIF == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (jJD == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (kBR == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (jUd == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (kEZ == k) {
        this.field_sayhiuser = paramCursor.getString(i);
      } else if (kFa == k) {
        this.field_sayhicontent = paramCursor.getString(i);
      } else if (kFb == k) {
        this.field_imgpath = paramCursor.getString(i);
      } else if (jQu == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.keQ) {
      localContentValues.put("svrid", Long.valueOf(this.field_svrid));
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.jJB) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.kBG) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.jTP) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.kEV) {
      localContentValues.put("sayhiuser", this.field_sayhiuser);
    }
    if (this.kEW) {
      localContentValues.put("sayhicontent", this.field_sayhicontent);
    }
    if (this.kEX) {
      localContentValues.put("imgpath", this.field_imgpath);
    }
    if (this.jQf) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
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
  
  public StorageObserverOwner<? extends hc> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_svrid);
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
 * Qualified Name:     com.tencent.mm.autogen.b.hc
 * JD-Core Version:    0.7.0.1
 */