package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class by
  extends IAutoDBItem
{
  public static final Column C_ID;
  public static final Column C_LOCALID;
  public static final Column C_ROWID;
  public static final Column C_SOURCETYPE;
  public static final Column C_TYPE;
  public static final Column C_UPDATETIME;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FavItemInfo_id_Index ON FavItemInfo(id)", "CREATE INDEX IF NOT EXISTS FavItemInfo_type_Index ON FavItemInfo(type)", "CREATE INDEX IF NOT EXISTS FavItemInfo_updateSeq_Index ON FavItemInfo(updateSeq)", "CREATE INDEX IF NOT EXISTS FavItemInfo_flag_Index ON FavItemInfo(flag)", "CREATE INDEX IF NOT EXISTS FavItemInfo_sourceId_Index ON FavItemInfo(sourceId)", "CREATE INDEX IF NOT EXISTS FavItemInfo_datatotalsize_Index ON FavItemInfo(datatotalsize)" };
  public static final SingleTable TABLE = new SingleTable("FavItemInfo");
  public static final Column hLG;
  public static final Column hLH;
  public static final Column hLI;
  public static final Column hLJ;
  public static final Column hLK;
  public static final Column hLL;
  public static final Column hLM;
  public static final Column hLN;
  public static final Column hLO;
  public static final Column hLP;
  public static final Column hLQ;
  public static final Column hLR;
  public static final Column hLS;
  public static final Column hLT;
  private static final int hMi;
  private static final int hMj;
  private static final int hMk;
  private static final int hMl;
  private static final int hMm;
  private static final int hMn;
  private static final int hMo;
  private static final int hMp;
  private static final int hMq;
  private static final int hMr = "ext".hashCode();
  private static final int hMs = "edittime".hashCode();
  private static final int hMt = "tagProto".hashCode();
  private static final int hMu = "sessionId".hashCode();
  private static final int hMv = "datatotalsize".hashCode();
  public static final Column hrZ;
  private static final int hsf;
  public static final Column hsi;
  private static final int hsm;
  private static final int id_HASHCODE;
  private static final int localId_HASHCODE;
  private static final int rowid_HASHCODE = "rowid".hashCode();
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
  public aoc field_favProto;
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
  public aop field_tagProto;
  public String field_toUser;
  public int field_type;
  public int field_updateSeq;
  public long field_updateTime;
  public String field_xml;
  private boolean hLU = true;
  private boolean hLV = true;
  private boolean hLW = true;
  private boolean hLX = true;
  private boolean hLY = true;
  private boolean hLZ = true;
  private boolean hMa = true;
  private boolean hMb = true;
  private boolean hMc = true;
  private boolean hMd = true;
  private boolean hMe = true;
  private boolean hMf = true;
  private boolean hMg = true;
  private boolean hMh = true;
  private boolean hsc = true;
  private boolean hsk = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "FavItemInfo", "");
    C_LOCALID = new Column("localid", "long", "FavItemInfo", "");
    C_ID = new Column("id", "int", "FavItemInfo", "");
    C_TYPE = new Column("type", "int", "FavItemInfo", "");
    hLG = new Column("localseq", "int", "FavItemInfo", "");
    hLH = new Column("updateseq", "int", "FavItemInfo", "");
    hsi = new Column("flag", "int", "FavItemInfo", "");
    hLI = new Column("sourceid", "string", "FavItemInfo", "");
    hLJ = new Column("itemstatus", "int", "FavItemInfo", "");
    C_SOURCETYPE = new Column("sourcetype", "int", "FavItemInfo", "");
    hLK = new Column("sourcecreatetime", "long", "FavItemInfo", "");
    C_UPDATETIME = new Column("updatetime", "long", "FavItemInfo", "");
    hLL = new Column("fromuser", "string", "FavItemInfo", "");
    hLM = new Column("touser", "string", "FavItemInfo", "");
    hLN = new Column("realchatname", "string", "FavItemInfo", "");
    hLO = new Column("favproto", "proto", "FavItemInfo", "com.tencent.mm.protocal.protobuf.FavProtoItem");
    hrZ = new Column("xml", "string", "FavItemInfo", "");
    hLP = new Column("ext", "string", "FavItemInfo", "");
    hLQ = new Column("edittime", "long", "FavItemInfo", "");
    hLR = new Column("tagproto", "proto", "FavItemInfo", "com.tencent.mm.protocal.protobuf.FavTagList");
    hLS = new Column("sessionid", "string", "FavItemInfo", "");
    hLT = new Column("datatotalsize", "long", "FavItemInfo", "");
    localId_HASHCODE = "localId".hashCode();
    id_HASHCODE = "id".hashCode();
    type_HASHCODE = "type".hashCode();
    hMi = "localSeq".hashCode();
    hMj = "updateSeq".hashCode();
    hsm = "flag".hashCode();
    hMk = "sourceId".hashCode();
    hMl = "itemStatus".hashCode();
    sourceType_HASHCODE = "sourceType".hashCode();
    hMm = "sourceCreateTime".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    hMn = "fromUser".hashCode();
    hMo = "toUser".hashCode();
    hMp = "realChatName".hashCode();
    hMq = "favProto".hashCode();
    hsf = "xml".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
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
    return localMAutoDBInfo;
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
      } else if (hMi == k) {
        this.field_localSeq = paramCursor.getInt(i);
      } else if (hMj == k) {
        this.field_updateSeq = paramCursor.getInt(i);
      } else if (hsm == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (hMk == k) {
        this.field_sourceId = paramCursor.getString(i);
      } else if (hMl == k) {
        this.field_itemStatus = paramCursor.getInt(i);
      } else if (sourceType_HASHCODE == k) {
        this.field_sourceType = paramCursor.getInt(i);
      } else if (hMm == k) {
        this.field_sourceCreateTime = paramCursor.getLong(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (hMn == k) {
        this.field_fromUser = paramCursor.getString(i);
      } else if (hMo == k) {
        this.field_toUser = paramCursor.getString(i);
      } else if (hMp == k) {
        this.field_realChatName = paramCursor.getString(i);
      } else if (hMq == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_favProto = ((aoc)new aoc().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.SDK.BaseFavItemInfo", localIOException1.getMessage());
        }
      } else if (hsf == k) {
        this.field_xml = paramCursor.getString(i);
      } else if (hMr == k) {
        this.field_ext = paramCursor.getString(i);
      } else if (hMs == k) {
        this.field_edittime = paramCursor.getLong(i);
      } else if (hMt == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_tagProto = ((aop)new aop().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          Log.e("MicroMsg.SDK.BaseFavItemInfo", localIOException2.getMessage());
        }
      } else if (hMu == k) {
        this.field_sessionId = paramCursor.getString(i);
      } else if (hMv == k) {
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
    if (this.hLU) {
      localContentValues.put("localSeq", Integer.valueOf(this.field_localSeq));
    }
    if (this.hLV) {
      localContentValues.put("updateSeq", Integer.valueOf(this.field_updateSeq));
    }
    if (this.hsk) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.hLW) {
      localContentValues.put("sourceId", this.field_sourceId);
    }
    if (this.hLX) {
      localContentValues.put("itemStatus", Integer.valueOf(this.field_itemStatus));
    }
    if (this.__hadSetsourceType) {
      localContentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
    }
    if (this.hLY) {
      localContentValues.put("sourceCreateTime", Long.valueOf(this.field_sourceCreateTime));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.hLZ) {
      localContentValues.put("fromUser", this.field_fromUser);
    }
    if (this.hMa) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.hMb) {
      localContentValues.put("realChatName", this.field_realChatName);
    }
    if ((this.hMc) && (this.field_favProto != null)) {}
    try
    {
      localContentValues.put("favProto", this.field_favProto.toByteArray());
      if (this.hsc) {
        localContentValues.put("xml", this.field_xml);
      }
      if (this.hMd) {
        localContentValues.put("ext", this.field_ext);
      }
      if (this.hMe) {
        localContentValues.put("edittime", Long.valueOf(this.field_edittime));
      }
      if ((!this.hMf) || (this.field_tagProto == null)) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        localContentValues.put("tagProto", this.field_tagProto.toByteArray());
        if (this.hMg) {
          localContentValues.put("sessionId", this.field_sessionId);
        }
        if (this.hMh) {
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
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "FavItemInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.by
 * JD-Core Version:    0.7.0.1
 */