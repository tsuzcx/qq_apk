package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class by
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FavItemInfo_id_Index ON FavItemInfo(id)", "CREATE INDEX IF NOT EXISTS FavItemInfo_type_Index ON FavItemInfo(type)", "CREATE INDEX IF NOT EXISTS FavItemInfo_updateSeq_Index ON FavItemInfo(updateSeq)", "CREATE INDEX IF NOT EXISTS FavItemInfo_flag_Index ON FavItemInfo(flag)", "CREATE INDEX IF NOT EXISTS FavItemInfo_sourceId_Index ON FavItemInfo(sourceId)", "CREATE INDEX IF NOT EXISTS FavItemInfo_datatotalsize_Index ON FavItemInfo(datatotalsize)" };
  private static final int fAN;
  private static final int fAO;
  private static final int fAP;
  private static final int fAQ;
  private static final int fAR;
  private static final int fAS;
  private static final int fAT;
  private static final int fAU;
  private static final int fAV;
  private static final int fAW = "ext".hashCode();
  private static final int fAX = "edittime".hashCode();
  private static final int fAY = "tagProto".hashCode();
  private static final int fAZ = "sessionId".hashCode();
  private static final int fBa = "datatotalsize".hashCode();
  private static final int fnd;
  private static final int fni;
  private static final int id_HASHCODE;
  private static final int localId_HASHCODE = "localId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int sourceType_HASHCODE;
  private static final int type_HASHCODE;
  private static final int updateTime_HASHCODE;
  private boolean __hadSetid = true;
  private boolean __hadSetlocalId = true;
  private boolean __hadSetsourceType = true;
  private boolean __hadSettype = true;
  private boolean __hadSetupdateTime = true;
  private boolean fAA = true;
  private boolean fAB = true;
  private boolean fAC = true;
  private boolean fAD = true;
  private boolean fAE = true;
  private boolean fAF = true;
  private boolean fAG = true;
  private boolean fAH = true;
  private boolean fAI = true;
  private boolean fAJ = true;
  private boolean fAK = true;
  private boolean fAL = true;
  private boolean fAM = true;
  private boolean fAz = true;
  public long field_datatotalsize;
  public long field_edittime;
  public String field_ext;
  public anb field_favProto;
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
  public ano field_tagProto;
  public String field_toUser;
  public int field_type;
  public int field_updateSeq;
  public long field_updateTime;
  public String field_xml;
  private boolean fna = true;
  private boolean fng = true;
  
  static
  {
    id_HASHCODE = "id".hashCode();
    type_HASHCODE = "type".hashCode();
    fAN = "localSeq".hashCode();
    fAO = "updateSeq".hashCode();
    fni = "flag".hashCode();
    fAP = "sourceId".hashCode();
    fAQ = "itemStatus".hashCode();
    sourceType_HASHCODE = "sourceType".hashCode();
    fAR = "sourceCreateTime".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    fAS = "fromUser".hashCode();
    fAT = "toUser".hashCode();
    fAU = "realChatName".hashCode();
    fAV = "favProto".hashCode();
    fnd = "xml".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
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
      } else if (fAN == k) {
        this.field_localSeq = paramCursor.getInt(i);
      } else if (fAO == k) {
        this.field_updateSeq = paramCursor.getInt(i);
      } else if (fni == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (fAP == k) {
        this.field_sourceId = paramCursor.getString(i);
      } else if (fAQ == k) {
        this.field_itemStatus = paramCursor.getInt(i);
      } else if (sourceType_HASHCODE == k) {
        this.field_sourceType = paramCursor.getInt(i);
      } else if (fAR == k) {
        this.field_sourceCreateTime = paramCursor.getLong(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (fAS == k) {
        this.field_fromUser = paramCursor.getString(i);
      } else if (fAT == k) {
        this.field_toUser = paramCursor.getString(i);
      } else if (fAU == k) {
        this.field_realChatName = paramCursor.getString(i);
      } else if (fAV == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_favProto = ((anb)new anb().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.SDK.BaseFavItemInfo", localIOException1.getMessage());
        }
      } else if (fnd == k) {
        this.field_xml = paramCursor.getString(i);
      } else if (fAW == k) {
        this.field_ext = paramCursor.getString(i);
      } else if (fAX == k) {
        this.field_edittime = paramCursor.getLong(i);
      } else if (fAY == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_tagProto = ((ano)new ano().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          Log.e("MicroMsg.SDK.BaseFavItemInfo", localIOException2.getMessage());
        }
      } else if (fAZ == k) {
        this.field_sessionId = paramCursor.getString(i);
      } else if (fBa == k) {
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
    if (this.fAz) {
      localContentValues.put("localSeq", Integer.valueOf(this.field_localSeq));
    }
    if (this.fAA) {
      localContentValues.put("updateSeq", Integer.valueOf(this.field_updateSeq));
    }
    if (this.fng) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.fAB) {
      localContentValues.put("sourceId", this.field_sourceId);
    }
    if (this.fAC) {
      localContentValues.put("itemStatus", Integer.valueOf(this.field_itemStatus));
    }
    if (this.__hadSetsourceType) {
      localContentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
    }
    if (this.fAD) {
      localContentValues.put("sourceCreateTime", Long.valueOf(this.field_sourceCreateTime));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.fAE) {
      localContentValues.put("fromUser", this.field_fromUser);
    }
    if (this.fAF) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.fAG) {
      localContentValues.put("realChatName", this.field_realChatName);
    }
    if ((this.fAH) && (this.field_favProto != null)) {}
    try
    {
      localContentValues.put("favProto", this.field_favProto.toByteArray());
      if (this.fna) {
        localContentValues.put("xml", this.field_xml);
      }
      if (this.fAI) {
        localContentValues.put("ext", this.field_ext);
      }
      if (this.fAJ) {
        localContentValues.put("edittime", Long.valueOf(this.field_edittime));
      }
      if ((!this.fAK) || (this.field_tagProto == null)) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        localContentValues.put("tagProto", this.field_tagProto.toByteArray());
        if (this.fAL) {
          localContentValues.put("sessionId", this.field_sessionId);
        }
        if (this.fAM) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.by
 * JD-Core Version:    0.7.0.1
 */