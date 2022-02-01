package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.bk.a;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;
import org.json.JSONObject;

public abstract class fx
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("OpenIMKefuContact");
  public static final Column TYPE;
  public static final Column USERNAME;
  public static final Column jJA;
  private static final int jJE;
  public static final Column jMN;
  private static final int jMX;
  public static final Column jTk;
  private static final int jTs;
  public static final Column jZj;
  private static final int kQG;
  private static final int kQH;
  private static final int kQI;
  private static final int kQJ;
  private static final int kQK;
  private static final int kQL;
  private static final int kQM;
  private static final int kQN;
  private static final int kQO;
  private static final int kQP;
  private static final int kQQ;
  public static final Column kQl;
  public static final Column kQm;
  public static final Column kQn;
  public static final Column kQo;
  public static final Column kQp;
  public static final Column kQq;
  public static final Column kQr;
  public static final Column kQs;
  public static final Column kQt;
  public static final Column kQu;
  private static final StorageObserverOwner<fx> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSettype = true;
  private boolean __hadSetusername = true;
  public String field_bigHeadImg;
  public int field_checkTime;
  public String field_customInfoDetail;
  public int field_customInfoDetailVisible;
  public String field_finderUsername;
  public String field_kfUrl;
  public String field_nickname;
  public String field_nicknamePyInit;
  public String field_nicknamePyQuanPin;
  public String field_openImAppId;
  public String field_openImDescWordingId;
  public String field_smallHeadImg;
  public int field_source;
  public String field_ticket;
  public long field_type;
  public String field_username;
  private boolean jJC = true;
  private boolean jMS = true;
  private boolean jTo = true;
  private boolean kQA = true;
  private boolean kQB = true;
  private boolean kQC = true;
  private boolean kQD = true;
  private boolean kQE = true;
  private boolean kQF = true;
  private boolean kQv = true;
  private boolean kQw = true;
  private boolean kQx = true;
  private boolean kQy = true;
  private boolean kQz = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    jTk = new Column("nickname", "string", TABLE.getName(), "");
    kQl = new Column("bigHeadImg", "string", TABLE.getName(), "");
    kQm = new Column("smallHeadImg", "string", TABLE.getName(), "");
    kQn = new Column("nicknamePyInit", "string", TABLE.getName(), "");
    kQo = new Column("nicknamePyQuanPin", "string", TABLE.getName(), "");
    jZj = new Column("openImAppId", "string", TABLE.getName(), "");
    kQp = new Column("openImDescWordingId", "string", TABLE.getName(), "");
    jMN = new Column("source", "int", TABLE.getName(), "");
    kQq = new Column("checkTime", "int", TABLE.getName(), "");
    kQr = new Column("customInfoDetailVisible", "int", TABLE.getName(), "");
    kQs = new Column("customInfoDetail", "string", TABLE.getName(), "");
    jJA = new Column("ticket", "string", TABLE.getName(), "");
    TYPE = new Column("type", "long", TABLE.getName(), "");
    kQt = new Column("finderUsername", "string", TABLE.getName(), "");
    kQu = new Column("kfUrl", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS OpenIMKefuContact_username_index ON OpenIMKefuContact(username)" };
    username_HASHCODE = "username".hashCode();
    jTs = "nickname".hashCode();
    kQG = "bigHeadImg".hashCode();
    kQH = "smallHeadImg".hashCode();
    kQI = "nicknamePyInit".hashCode();
    kQJ = "nicknamePyQuanPin".hashCode();
    kQK = "openImAppId".hashCode();
    kQL = "openImDescWordingId".hashCode();
    jMX = "source".hashCode();
    kQM = "checkTime".hashCode();
    kQN = "customInfoDetailVisible".hashCode();
    kQO = "customInfoDetail".hashCode();
    jJE = "ticket".hashCode();
    type_HASHCODE = "type".hashCode();
    kQP = "finderUsername".hashCode();
    kQQ = "kfUrl".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[16];
    localMAutoDBInfo.columns = new String[17];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "username";
    localMAutoDBInfo.columns[1] = "nickname";
    localMAutoDBInfo.colsMap.put("nickname", "TEXT default '' ");
    localStringBuilder.append(" nickname TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "bigHeadImg";
    localMAutoDBInfo.colsMap.put("bigHeadImg", "TEXT default '' ");
    localStringBuilder.append(" bigHeadImg TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "smallHeadImg";
    localMAutoDBInfo.colsMap.put("smallHeadImg", "TEXT default '' ");
    localStringBuilder.append(" smallHeadImg TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "nicknamePyInit";
    localMAutoDBInfo.colsMap.put("nicknamePyInit", "TEXT default '' ");
    localStringBuilder.append(" nicknamePyInit TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "nicknamePyQuanPin";
    localMAutoDBInfo.colsMap.put("nicknamePyQuanPin", "TEXT default '' ");
    localStringBuilder.append(" nicknamePyQuanPin TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "openImAppId";
    localMAutoDBInfo.colsMap.put("openImAppId", "TEXT default '' ");
    localStringBuilder.append(" openImAppId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "openImDescWordingId";
    localMAutoDBInfo.colsMap.put("openImDescWordingId", "TEXT default '' ");
    localStringBuilder.append(" openImDescWordingId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "source";
    localMAutoDBInfo.colsMap.put("source", "INTEGER default '' ");
    localStringBuilder.append(" source INTEGER default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "checkTime";
    localMAutoDBInfo.colsMap.put("checkTime", "INTEGER default '0' ");
    localStringBuilder.append(" checkTime INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "customInfoDetailVisible";
    localMAutoDBInfo.colsMap.put("customInfoDetailVisible", "INTEGER");
    localStringBuilder.append(" customInfoDetailVisible INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "customInfoDetail";
    localMAutoDBInfo.colsMap.put("customInfoDetail", "TEXT");
    localStringBuilder.append(" customInfoDetail TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "ticket";
    localMAutoDBInfo.colsMap.put("ticket", "TEXT");
    localStringBuilder.append(" ticket TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "type";
    localMAutoDBInfo.colsMap.put("type", "LONG default '0' ");
    localStringBuilder.append(" type LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "finderUsername";
    localMAutoDBInfo.colsMap.put("finderUsername", "TEXT default '' ");
    localStringBuilder.append(" finderUsername TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "kfUrl";
    localMAutoDBInfo.colsMap.put("kfUrl", "TEXT default '' ");
    localStringBuilder.append(" kfUrl TEXT default '' ");
    localMAutoDBInfo.columns[16] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  private JSONObject toJSON()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      a.b(localJSONObject, "username", this.field_username);
      a.b(localJSONObject, "nickname", this.field_nickname);
      a.b(localJSONObject, "bigHeadImg", this.field_bigHeadImg);
      a.b(localJSONObject, "smallHeadImg", this.field_smallHeadImg);
      a.b(localJSONObject, "nicknamePyInit", this.field_nicknamePyInit);
      a.b(localJSONObject, "nicknamePyQuanPin", this.field_nicknamePyQuanPin);
      a.b(localJSONObject, "openImAppId", this.field_openImAppId);
      a.b(localJSONObject, "openImDescWordingId", this.field_openImDescWordingId);
      a.b(localJSONObject, "source", Integer.valueOf(this.field_source));
      a.b(localJSONObject, "checkTime", Integer.valueOf(this.field_checkTime));
      a.b(localJSONObject, "customInfoDetailVisible", Integer.valueOf(this.field_customInfoDetailVisible));
      a.b(localJSONObject, "customInfoDetail", this.field_customInfoDetail);
      a.b(localJSONObject, "ticket", this.field_ticket);
      a.b(localJSONObject, "type", Long.valueOf(this.field_type));
      a.b(localJSONObject, "finderUsername", this.field_finderUsername);
      a.b(localJSONObject, "kfUrl", this.field_kfUrl);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return localJSONObject;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("username"))
    {
      this.field_username = paramContentValues.getAsString("username");
      if (paramBoolean) {
        this.__hadSetusername = true;
      }
    }
    if (paramContentValues.containsKey("nickname"))
    {
      this.field_nickname = paramContentValues.getAsString("nickname");
      if (paramBoolean) {
        this.jTo = true;
      }
    }
    if (paramContentValues.containsKey("bigHeadImg"))
    {
      this.field_bigHeadImg = paramContentValues.getAsString("bigHeadImg");
      if (paramBoolean) {
        this.kQv = true;
      }
    }
    if (paramContentValues.containsKey("smallHeadImg"))
    {
      this.field_smallHeadImg = paramContentValues.getAsString("smallHeadImg");
      if (paramBoolean) {
        this.kQw = true;
      }
    }
    if (paramContentValues.containsKey("nicknamePyInit"))
    {
      this.field_nicknamePyInit = paramContentValues.getAsString("nicknamePyInit");
      if (paramBoolean) {
        this.kQx = true;
      }
    }
    if (paramContentValues.containsKey("nicknamePyQuanPin"))
    {
      this.field_nicknamePyQuanPin = paramContentValues.getAsString("nicknamePyQuanPin");
      if (paramBoolean) {
        this.kQy = true;
      }
    }
    if (paramContentValues.containsKey("openImAppId"))
    {
      this.field_openImAppId = paramContentValues.getAsString("openImAppId");
      if (paramBoolean) {
        this.kQz = true;
      }
    }
    if (paramContentValues.containsKey("openImDescWordingId"))
    {
      this.field_openImDescWordingId = paramContentValues.getAsString("openImDescWordingId");
      if (paramBoolean) {
        this.kQA = true;
      }
    }
    if (paramContentValues.containsKey("source"))
    {
      this.field_source = paramContentValues.getAsInteger("source").intValue();
      if (paramBoolean) {
        this.jMS = true;
      }
    }
    if (paramContentValues.containsKey("checkTime"))
    {
      this.field_checkTime = paramContentValues.getAsInteger("checkTime").intValue();
      if (paramBoolean) {
        this.kQB = true;
      }
    }
    if (paramContentValues.containsKey("customInfoDetailVisible"))
    {
      this.field_customInfoDetailVisible = paramContentValues.getAsInteger("customInfoDetailVisible").intValue();
      if (paramBoolean) {
        this.kQC = true;
      }
    }
    if (paramContentValues.containsKey("customInfoDetail"))
    {
      this.field_customInfoDetail = paramContentValues.getAsString("customInfoDetail");
      if (paramBoolean) {
        this.kQD = true;
      }
    }
    if (paramContentValues.containsKey("ticket"))
    {
      this.field_ticket = paramContentValues.getAsString("ticket");
      if (paramBoolean) {
        this.jJC = true;
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsLong("type").longValue();
      if (paramBoolean) {
        this.__hadSettype = true;
      }
    }
    if (paramContentValues.containsKey("finderUsername"))
    {
      this.field_finderUsername = paramContentValues.getAsString("finderUsername");
      if (paramBoolean) {
        this.kQE = true;
      }
    }
    if (paramContentValues.containsKey("kfUrl"))
    {
      this.field_kfUrl = paramContentValues.getAsString("kfUrl");
      if (paramBoolean) {
        this.kQF = true;
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
      if (username_HASHCODE != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.__hadSetusername = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jTs == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (kQG == k) {
        this.field_bigHeadImg = paramCursor.getString(i);
      } else if (kQH == k) {
        this.field_smallHeadImg = paramCursor.getString(i);
      } else if (kQI == k) {
        this.field_nicknamePyInit = paramCursor.getString(i);
      } else if (kQJ == k) {
        this.field_nicknamePyQuanPin = paramCursor.getString(i);
      } else if (kQK == k) {
        this.field_openImAppId = paramCursor.getString(i);
      } else if (kQL == k) {
        this.field_openImDescWordingId = paramCursor.getString(i);
      } else if (jMX == k) {
        this.field_source = paramCursor.getInt(i);
      } else if (kQM == k) {
        this.field_checkTime = paramCursor.getInt(i);
      } else if (kQN == k) {
        this.field_customInfoDetailVisible = paramCursor.getInt(i);
      } else if (kQO == k) {
        this.field_customInfoDetail = paramCursor.getString(i);
      } else if (jJE == k) {
        this.field_ticket = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getLong(i);
      } else if (kQP == k) {
        this.field_finderUsername = paramCursor.getString(i);
      } else if (kQQ == k) {
        this.field_kfUrl = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.field_nickname == null) {
      this.field_nickname = "";
    }
    if (this.jTo) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.field_bigHeadImg == null) {
      this.field_bigHeadImg = "";
    }
    if (this.kQv) {
      localContentValues.put("bigHeadImg", this.field_bigHeadImg);
    }
    if (this.field_smallHeadImg == null) {
      this.field_smallHeadImg = "";
    }
    if (this.kQw) {
      localContentValues.put("smallHeadImg", this.field_smallHeadImg);
    }
    if (this.field_nicknamePyInit == null) {
      this.field_nicknamePyInit = "";
    }
    if (this.kQx) {
      localContentValues.put("nicknamePyInit", this.field_nicknamePyInit);
    }
    if (this.field_nicknamePyQuanPin == null) {
      this.field_nicknamePyQuanPin = "";
    }
    if (this.kQy) {
      localContentValues.put("nicknamePyQuanPin", this.field_nicknamePyQuanPin);
    }
    if (this.field_openImAppId == null) {
      this.field_openImAppId = "";
    }
    if (this.kQz) {
      localContentValues.put("openImAppId", this.field_openImAppId);
    }
    if (this.field_openImDescWordingId == null) {
      this.field_openImDescWordingId = "";
    }
    if (this.kQA) {
      localContentValues.put("openImDescWordingId", this.field_openImDescWordingId);
    }
    if (this.jMS) {
      localContentValues.put("source", Integer.valueOf(this.field_source));
    }
    if (this.kQB) {
      localContentValues.put("checkTime", Integer.valueOf(this.field_checkTime));
    }
    if (this.kQC) {
      localContentValues.put("customInfoDetailVisible", Integer.valueOf(this.field_customInfoDetailVisible));
    }
    if (this.kQD) {
      localContentValues.put("customInfoDetail", this.field_customInfoDetail);
    }
    if (this.jJC) {
      localContentValues.put("ticket", this.field_ticket);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Long.valueOf(this.field_type));
    }
    if (this.field_finderUsername == null) {
      this.field_finderUsername = "";
    }
    if (this.kQE) {
      localContentValues.put("finderUsername", this.field_finderUsername);
    }
    if (this.field_kfUrl == null) {
      this.field_kfUrl = "";
    }
    if (this.kQF) {
      localContentValues.put("kfUrl", this.field_kfUrl);
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
  
  public StorageObserverOwner<? extends fx> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_username;
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
 * Qualified Name:     com.tencent.mm.autogen.b.fx
 * JD-Core Version:    0.7.0.1
 */