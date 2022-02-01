package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cb
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final Column ID;
  public static final String[] INDEX_CREATE;
  public static final Column LOCALID;
  public static final Column ROWID;
  public static final Column SOURCETYPE;
  public static final SingleTable TABLE = new SingleTable("FavItemInfo");
  public static final Column TYPE;
  public static final Column UPDATETIME;
  private static final int id_HASHCODE;
  public static final Column jOM;
  private static final int jOS;
  public static final Column jOV;
  private static final int jOZ;
  public static final Column kiK;
  public static final Column kiL;
  public static final Column kiM;
  public static final Column kiN;
  public static final Column kiO;
  public static final Column kiP;
  public static final Column kiQ;
  public static final Column kiR;
  public static final Column kiS;
  public static final Column kiT;
  public static final Column kiU;
  public static final Column kiV;
  public static final Column kiW;
  public static final Column kiX;
  private static final int kjm;
  private static final int kjn;
  private static final int kjo;
  private static final int kjp;
  private static final int kjq;
  private static final int kjr;
  private static final int kjs;
  private static final int kjt;
  private static final int kju;
  private static final int kjv;
  private static final int kjw;
  private static final int kjx;
  private static final int kjy;
  private static final int kjz;
  private static final int localId_HASHCODE;
  private static final StorageObserverOwner<cb> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int sourceType_HASHCODE;
  private static final int type_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSetid = true;
  private boolean __hadSetlocalId = true;
  private boolean __hadSetsourceType = true;
  private boolean __hadSettype = true;
  private boolean __hadSetupdateTime = true;
  public long field_datatotalsize;
  public long field_edittime;
  public String field_ext;
  public arv field_favProto;
  public int field_flag;
  public String field_fromUser;
  public int field_id;
  public int field_itemStatus;
  public long field_localId;
  public int field_localSeq;
  public String field_realChatName;
  public String field_sessionId;
  public long field_sourceCreateTime;
  public String field_sourceId;
  public int field_sourceType;
  public asi field_tagProto;
  public String field_toUser;
  public int field_type;
  public int field_updateSeq;
  public long field_updateTime;
  public String field_xml;
  private boolean jOP = true;
  private boolean jOX = true;
  private boolean kiY = true;
  private boolean kiZ = true;
  private boolean kja = true;
  private boolean kjb = true;
  private boolean kjc = true;
  private boolean kjd = true;
  private boolean kje = true;
  private boolean kjf = true;
  private boolean kjg = true;
  private boolean kjh = true;
  private boolean kji = true;
  private boolean kjj = true;
  private boolean kjk = true;
  private boolean kjl = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    LOCALID = new Column("localId", "long", TABLE.getName(), "");
    ID = new Column("id", "int", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    kiK = new Column("localSeq", "int", TABLE.getName(), "");
    kiL = new Column("updateSeq", "int", TABLE.getName(), "");
    jOV = new Column("flag", "int", TABLE.getName(), "");
    kiM = new Column("sourceId", "string", TABLE.getName(), "");
    kiN = new Column("itemStatus", "int", TABLE.getName(), "");
    SOURCETYPE = new Column("sourceType", "int", TABLE.getName(), "");
    kiO = new Column("sourceCreateTime", "long", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    kiP = new Column("fromUser", "string", TABLE.getName(), "");
    kiQ = new Column("toUser", "string", TABLE.getName(), "");
    kiR = new Column("realChatName", "string", TABLE.getName(), "");
    kiS = new Column("favProto", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FavProtoItem");
    jOM = new Column("xml", "string", TABLE.getName(), "");
    kiT = new Column("ext", "string", TABLE.getName(), "");
    kiU = new Column("edittime", "long", TABLE.getName(), "");
    kiV = new Column("tagProto", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FavTagList");
    kiW = new Column("sessionId", "string", TABLE.getName(), "");
    kiX = new Column("datatotalsize", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS FavItemInfo_id_Index ON FavItemInfo(id)", "CREATE INDEX IF NOT EXISTS FavItemInfo_type_Index ON FavItemInfo(type)", "CREATE INDEX IF NOT EXISTS FavItemInfo_updateSeq_Index ON FavItemInfo(updateSeq)", "CREATE INDEX IF NOT EXISTS FavItemInfo_flag_Index ON FavItemInfo(flag)", "CREATE INDEX IF NOT EXISTS FavItemInfo_sourceId_Index ON FavItemInfo(sourceId)", "CREATE INDEX IF NOT EXISTS FavItemInfo_datatotalsize_Index ON FavItemInfo(datatotalsize)" };
    localId_HASHCODE = "localId".hashCode();
    id_HASHCODE = "id".hashCode();
    type_HASHCODE = "type".hashCode();
    kjm = "localSeq".hashCode();
    kjn = "updateSeq".hashCode();
    jOZ = "flag".hashCode();
    kjo = "sourceId".hashCode();
    kjp = "itemStatus".hashCode();
    sourceType_HASHCODE = "sourceType".hashCode();
    kjq = "sourceCreateTime".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    kjr = "fromUser".hashCode();
    kjs = "toUser".hashCode();
    kjt = "realChatName".hashCode();
    kju = "favProto".hashCode();
    jOS = "xml".hashCode();
    kjv = "ext".hashCode();
    kjw = "edittime".hashCode();
    kjx = "tagProto".hashCode();
    kjy = "sessionId".hashCode();
    kjz = "datatotalsize".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[21];
    localMAutoDBInfo.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "localId";
    localMAutoDBInfo.colsMap.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "localId";
    localMAutoDBInfo.columns[1] = "id";
    localMAutoDBInfo.colsMap.put("id", "INTEGER");
    localStringBuilder.append(" id INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "localSeq";
    localMAutoDBInfo.colsMap.put("localSeq", "INTEGER");
    localStringBuilder.append(" localSeq INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "updateSeq";
    localMAutoDBInfo.colsMap.put("updateSeq", "INTEGER");
    localStringBuilder.append(" updateSeq INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "flag";
    localMAutoDBInfo.colsMap.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "sourceId";
    localMAutoDBInfo.colsMap.put("sourceId", "TEXT");
    localStringBuilder.append(" sourceId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "itemStatus";
    localMAutoDBInfo.colsMap.put("itemStatus", "INTEGER");
    localStringBuilder.append(" itemStatus INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "sourceType";
    localMAutoDBInfo.colsMap.put("sourceType", "INTEGER");
    localStringBuilder.append(" sourceType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "sourceCreateTime";
    localMAutoDBInfo.colsMap.put("sourceCreateTime", "LONG");
    localStringBuilder.append(" sourceCreateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "updateTime";
    localMAutoDBInfo.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "fromUser";
    localMAutoDBInfo.colsMap.put("fromUser", "TEXT");
    localStringBuilder.append(" fromUser TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "toUser";
    localMAutoDBInfo.colsMap.put("toUser", "TEXT");
    localStringBuilder.append(" toUser TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "realChatName";
    localMAutoDBInfo.colsMap.put("realChatName", "TEXT");
    localStringBuilder.append(" realChatName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "favProto";
    localMAutoDBInfo.colsMap.put("favProto", "BLOB");
    localStringBuilder.append(" favProto BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "xml";
    localMAutoDBInfo.colsMap.put("xml", "TEXT");
    localStringBuilder.append(" xml TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "ext";
    localMAutoDBInfo.colsMap.put("ext", "TEXT");
    localStringBuilder.append(" ext TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "edittime";
    localMAutoDBInfo.colsMap.put("edittime", "LONG");
    localStringBuilder.append(" edittime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "tagProto";
    localMAutoDBInfo.colsMap.put("tagProto", "BLOB");
    localStringBuilder.append(" tagProto BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "sessionId";
    localMAutoDBInfo.colsMap.put("sessionId", "TEXT");
    localStringBuilder.append(" sessionId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "datatotalsize";
    localMAutoDBInfo.colsMap.put("datatotalsize", "LONG");
    localStringBuilder.append(" datatotalsize LONG");
    localMAutoDBInfo.columns[21] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("localId"))
    {
      this.field_localId = paramContentValues.getAsLong("localId").longValue();
      if (paramBoolean) {
        this.__hadSetlocalId = true;
      }
    }
    if (paramContentValues.containsKey("id"))
    {
      this.field_id = paramContentValues.getAsInteger("id").intValue();
      if (paramBoolean) {
        this.__hadSetid = true;
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsInteger("type").intValue();
      if (paramBoolean) {
        this.__hadSettype = true;
      }
    }
    if (paramContentValues.containsKey("localSeq"))
    {
      this.field_localSeq = paramContentValues.getAsInteger("localSeq").intValue();
      if (paramBoolean) {
        this.kiY = true;
      }
    }
    if (paramContentValues.containsKey("updateSeq"))
    {
      this.field_updateSeq = paramContentValues.getAsInteger("updateSeq").intValue();
      if (paramBoolean) {
        this.kiZ = true;
      }
    }
    if (paramContentValues.containsKey("flag"))
    {
      this.field_flag = paramContentValues.getAsInteger("flag").intValue();
      if (paramBoolean) {
        this.jOX = true;
      }
    }
    if (paramContentValues.containsKey("sourceId"))
    {
      this.field_sourceId = paramContentValues.getAsString("sourceId");
      if (paramBoolean) {
        this.kja = true;
      }
    }
    if (paramContentValues.containsKey("itemStatus"))
    {
      this.field_itemStatus = paramContentValues.getAsInteger("itemStatus").intValue();
      if (paramBoolean) {
        this.kjb = true;
      }
    }
    if (paramContentValues.containsKey("sourceType"))
    {
      this.field_sourceType = paramContentValues.getAsInteger("sourceType").intValue();
      if (paramBoolean) {
        this.__hadSetsourceType = true;
      }
    }
    if (paramContentValues.containsKey("sourceCreateTime"))
    {
      this.field_sourceCreateTime = paramContentValues.getAsLong("sourceCreateTime").longValue();
      if (paramBoolean) {
        this.kjc = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
      }
    }
    if (paramContentValues.containsKey("fromUser"))
    {
      this.field_fromUser = paramContentValues.getAsString("fromUser");
      if (paramBoolean) {
        this.kjd = true;
      }
    }
    if (paramContentValues.containsKey("toUser"))
    {
      this.field_toUser = paramContentValues.getAsString("toUser");
      if (paramBoolean) {
        this.kje = true;
      }
    }
    if (paramContentValues.containsKey("realChatName"))
    {
      this.field_realChatName = paramContentValues.getAsString("realChatName");
      if (paramBoolean) {
        this.kjf = true;
      }
    }
    if (paramContentValues.containsKey("favProto")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("favProto");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_favProto = ((arv)new arv().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kjg = true;
        }
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        Log.e("MicroMsg.SDK.BaseFavItemInfo", localIOException1.getMessage());
      }
    }
    if (paramContentValues.containsKey("xml"))
    {
      this.field_xml = paramContentValues.getAsString("xml");
      if (paramBoolean) {
        this.jOP = true;
      }
    }
    if (paramContentValues.containsKey("ext"))
    {
      this.field_ext = paramContentValues.getAsString("ext");
      if (paramBoolean) {
        this.kjh = true;
      }
    }
    if (paramContentValues.containsKey("edittime"))
    {
      this.field_edittime = paramContentValues.getAsLong("edittime").longValue();
      if (paramBoolean) {
        this.kji = true;
      }
    }
    if (paramContentValues.containsKey("tagProto")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("tagProto");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_tagProto = ((asi)new asi().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kjj = true;
        }
      }
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFavItemInfo", localIOException2.getMessage());
      }
    }
    if (paramContentValues.containsKey("sessionId"))
    {
      this.field_sessionId = paramContentValues.getAsString("sessionId");
      if (paramBoolean) {
        this.kjk = true;
      }
    }
    if (paramContentValues.containsKey("datatotalsize"))
    {
      this.field_datatotalsize = paramContentValues.getAsLong("datatotalsize").longValue();
      if (paramBoolean) {
        this.kjl = true;
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
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (localId_HASHCODE != k) {
        break label65;
      }
      this.field_localId = paramCursor.getLong(i);
      this.__hadSetlocalId = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (id_HASHCODE == k) {
        this.field_id = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (kjm == k) {
        this.field_localSeq = paramCursor.getInt(i);
      } else if (kjn == k) {
        this.field_updateSeq = paramCursor.getInt(i);
      } else if (jOZ == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (kjo == k) {
        this.field_sourceId = paramCursor.getString(i);
      } else if (kjp == k) {
        this.field_itemStatus = paramCursor.getInt(i);
      } else if (sourceType_HASHCODE == k) {
        this.field_sourceType = paramCursor.getInt(i);
      } else if (kjq == k) {
        this.field_sourceCreateTime = paramCursor.getLong(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (kjr == k) {
        this.field_fromUser = paramCursor.getString(i);
      } else if (kjs == k) {
        this.field_toUser = paramCursor.getString(i);
      } else if (kjt == k) {
        this.field_realChatName = paramCursor.getString(i);
      } else if (kju == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_favProto = ((arv)new arv().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.SDK.BaseFavItemInfo", localIOException1.getMessage());
        }
      } else if (jOS == k) {
        this.field_xml = paramCursor.getString(i);
      } else if (kjv == k) {
        this.field_ext = paramCursor.getString(i);
      } else if (kjw == k) {
        this.field_edittime = paramCursor.getLong(i);
      } else if (kjx == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_tagProto = ((asi)new asi().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          Log.e("MicroMsg.SDK.BaseFavItemInfo", localIOException2.getMessage());
        }
      } else if (kjy == k) {
        this.field_sessionId = paramCursor.getString(i);
      } else if (kjz == k) {
        this.field_datatotalsize = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetlocalId) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if (this.__hadSetid) {
      localContentValues.put("id", Integer.valueOf(this.field_id));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.kiY) {
      localContentValues.put("localSeq", Integer.valueOf(this.field_localSeq));
    }
    if (this.kiZ) {
      localContentValues.put("updateSeq", Integer.valueOf(this.field_updateSeq));
    }
    if (this.jOX) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.kja) {
      localContentValues.put("sourceId", this.field_sourceId);
    }
    if (this.kjb) {
      localContentValues.put("itemStatus", Integer.valueOf(this.field_itemStatus));
    }
    if (this.__hadSetsourceType) {
      localContentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
    }
    if (this.kjc) {
      localContentValues.put("sourceCreateTime", Long.valueOf(this.field_sourceCreateTime));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.kjd) {
      localContentValues.put("fromUser", this.field_fromUser);
    }
    if (this.kje) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.kjf) {
      localContentValues.put("realChatName", this.field_realChatName);
    }
    if ((this.kjg) && (this.field_favProto != null)) {}
    try
    {
      localContentValues.put("favProto", this.field_favProto.toByteArray());
      if (this.jOP) {
        localContentValues.put("xml", this.field_xml);
      }
      if (this.kjh) {
        localContentValues.put("ext", this.field_ext);
      }
      if (this.kji) {
        localContentValues.put("edittime", Long.valueOf(this.field_edittime));
      }
      if ((!this.kjj) || (this.field_tagProto == null)) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        localContentValues.put("tagProto", this.field_tagProto.toByteArray());
        if (this.kjk) {
          localContentValues.put("sessionId", this.field_sessionId);
        }
        if (this.kjl) {
          localContentValues.put("datatotalsize", Long.valueOf(this.field_datatotalsize));
        }
        if (this.systemRowid > 0L) {
          localContentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return localContentValues;
        localIOException1 = localIOException1;
        Log.e("MicroMsg.SDK.BaseFavItemInfo", localIOException1.getMessage());
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          Log.e("MicroMsg.SDK.BaseFavItemInfo", localIOException2.getMessage());
        }
      }
    }
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends cb> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_localId);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.b.cb
 * JD-Core Version:    0.7.0.1
 */