package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bw
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FavItemInfo_id_Index ON FavItemInfo(id)", "CREATE INDEX IF NOT EXISTS FavItemInfo_type_Index ON FavItemInfo(type)", "CREATE INDEX IF NOT EXISTS FavItemInfo_updateSeq_Index ON FavItemInfo(updateSeq)", "CREATE INDEX IF NOT EXISTS FavItemInfo_flag_Index ON FavItemInfo(flag)", "CREATE INDEX IF NOT EXISTS FavItemInfo_sourceId_Index ON FavItemInfo(sourceId)", "CREATE INDEX IF NOT EXISTS FavItemInfo_datatotalsize_Index ON FavItemInfo(datatotalsize)" };
  private static final int eDL = "localId".hashCode();
  private static final int eEb;
  private static final int eEc;
  private static final int eEd;
  private static final int eEe;
  private static final int eEf;
  private static final int eEg;
  private static final int eEh;
  private static final int eEi;
  private static final int eEj;
  private static final int eEk = "ext".hashCode();
  private static final int eEl = "edittime".hashCode();
  private static final int eEm = "tagProto".hashCode();
  private static final int eEn = "sessionId".hashCode();
  private static final int eEo = "datatotalsize".hashCode();
  private static final int enb;
  private static final int eol;
  private static final int eqJ;
  private static final int eqO;
  private static final int ewX = "id".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eDJ = true;
  private boolean eDN = true;
  private boolean eDO = true;
  private boolean eDP = true;
  private boolean eDQ = true;
  private boolean eDR = true;
  private boolean eDS = true;
  private boolean eDT = true;
  private boolean eDU = true;
  private boolean eDV = true;
  private boolean eDW = true;
  private boolean eDX = true;
  private boolean eDY = true;
  private boolean eDZ = true;
  private boolean eEa = true;
  private boolean emE = true;
  private boolean eoi = true;
  private boolean eqG = true;
  private boolean eqM = true;
  private boolean ewT = true;
  public long field_datatotalsize;
  public long field_edittime;
  public String field_ext;
  public ahn field_favProto;
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
  public aia field_tagProto;
  public String field_toUser;
  public int field_type;
  public int field_updateSeq;
  public long field_updateTime;
  public String field_xml;
  
  static
  {
    eEb = "localSeq".hashCode();
    eEc = "updateSeq".hashCode();
    eqO = "flag".hashCode();
    eEd = "sourceId".hashCode();
    eEe = "itemStatus".hashCode();
    enb = "sourceType".hashCode();
    eEf = "sourceCreateTime".hashCode();
    eol = "updateTime".hashCode();
    eEg = "fromUser".hashCode();
    eEh = "toUser".hashCode();
    eEi = "realChatName".hashCode();
    eEj = "favProto".hashCode();
    eqJ = "xml".hashCode();
  }
  
  public static c.a Th()
  {
    c.a locala = new c.a();
    locala.GvF = new Field[21];
    locala.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.GvH.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "localId";
    locala.columns[1] = "id";
    locala.GvH.put("id", "INTEGER");
    localStringBuilder.append(" id INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.GvH.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "localSeq";
    locala.GvH.put("localSeq", "INTEGER");
    localStringBuilder.append(" localSeq INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "updateSeq";
    locala.GvH.put("updateSeq", "INTEGER");
    localStringBuilder.append(" updateSeq INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "flag";
    locala.GvH.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "sourceId";
    locala.GvH.put("sourceId", "TEXT");
    localStringBuilder.append(" sourceId TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "itemStatus";
    locala.GvH.put("itemStatus", "INTEGER");
    localStringBuilder.append(" itemStatus INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "sourceType";
    locala.GvH.put("sourceType", "INTEGER");
    localStringBuilder.append(" sourceType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "sourceCreateTime";
    locala.GvH.put("sourceCreateTime", "LONG");
    localStringBuilder.append(" sourceCreateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "updateTime";
    locala.GvH.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "fromUser";
    locala.GvH.put("fromUser", "TEXT");
    localStringBuilder.append(" fromUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "toUser";
    locala.GvH.put("toUser", "TEXT");
    localStringBuilder.append(" toUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "realChatName";
    locala.GvH.put("realChatName", "TEXT");
    localStringBuilder.append(" realChatName TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "favProto";
    locala.GvH.put("favProto", "BLOB");
    localStringBuilder.append(" favProto BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "xml";
    locala.GvH.put("xml", "TEXT");
    localStringBuilder.append(" xml TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "ext";
    locala.GvH.put("ext", "TEXT");
    localStringBuilder.append(" ext TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "edittime";
    locala.GvH.put("edittime", "LONG");
    localStringBuilder.append(" edittime LONG");
    localStringBuilder.append(", ");
    locala.columns[18] = "tagProto";
    locala.GvH.put("tagProto", "BLOB");
    localStringBuilder.append(" tagProto BLOB");
    localStringBuilder.append(", ");
    locala.columns[19] = "sessionId";
    locala.GvH.put("sessionId", "TEXT");
    localStringBuilder.append(" sessionId TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "datatotalsize";
    locala.GvH.put("datatotalsize", "LONG");
    localStringBuilder.append(" datatotalsize LONG");
    locala.columns[21] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
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
      if (eDL != k) {
        break label65;
      }
      this.field_localId = paramCursor.getLong(i);
      this.eDJ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ewX == k) {
        this.field_id = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eEb == k) {
        this.field_localSeq = paramCursor.getInt(i);
      } else if (eEc == k) {
        this.field_updateSeq = paramCursor.getInt(i);
      } else if (eqO == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (eEd == k) {
        this.field_sourceId = paramCursor.getString(i);
      } else if (eEe == k) {
        this.field_itemStatus = paramCursor.getInt(i);
      } else if (enb == k) {
        this.field_sourceType = paramCursor.getInt(i);
      } else if (eEf == k) {
        this.field_sourceCreateTime = paramCursor.getLong(i);
      } else if (eol == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eEg == k) {
        this.field_fromUser = paramCursor.getString(i);
      } else if (eEh == k) {
        this.field_toUser = paramCursor.getString(i);
      } else if (eEi == k) {
        this.field_realChatName = paramCursor.getString(i);
      } else if (eEj == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_favProto = ((ahn)new ahn().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ac.e("MicroMsg.SDK.BaseFavItemInfo", localIOException1.getMessage());
        }
      } else if (eqJ == k) {
        this.field_xml = paramCursor.getString(i);
      } else if (eEk == k) {
        this.field_ext = paramCursor.getString(i);
      } else if (eEl == k) {
        this.field_edittime = paramCursor.getLong(i);
      } else if (eEm == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_tagProto = ((aia)new aia().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ac.e("MicroMsg.SDK.BaseFavItemInfo", localIOException2.getMessage());
        }
      } else if (eEn == k) {
        this.field_sessionId = paramCursor.getString(i);
      } else if (eEo == k) {
        this.field_datatotalsize = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eDJ) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if (this.ewT) {
      localContentValues.put("id", Integer.valueOf(this.field_id));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eDN) {
      localContentValues.put("localSeq", Integer.valueOf(this.field_localSeq));
    }
    if (this.eDO) {
      localContentValues.put("updateSeq", Integer.valueOf(this.field_updateSeq));
    }
    if (this.eqM) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.eDP) {
      localContentValues.put("sourceId", this.field_sourceId);
    }
    if (this.eDQ) {
      localContentValues.put("itemStatus", Integer.valueOf(this.field_itemStatus));
    }
    if (this.emE) {
      localContentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
    }
    if (this.eDR) {
      localContentValues.put("sourceCreateTime", Long.valueOf(this.field_sourceCreateTime));
    }
    if (this.eoi) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eDS) {
      localContentValues.put("fromUser", this.field_fromUser);
    }
    if (this.eDT) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.eDU) {
      localContentValues.put("realChatName", this.field_realChatName);
    }
    if ((this.eDV) && (this.field_favProto != null)) {}
    try
    {
      localContentValues.put("favProto", this.field_favProto.toByteArray());
      if (this.eqG) {
        localContentValues.put("xml", this.field_xml);
      }
      if (this.eDW) {
        localContentValues.put("ext", this.field_ext);
      }
      if (this.eDX) {
        localContentValues.put("edittime", Long.valueOf(this.field_edittime));
      }
      if ((!this.eDY) || (this.field_tagProto == null)) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        localContentValues.put("tagProto", this.field_tagProto.toByteArray());
        if (this.eDZ) {
          localContentValues.put("sessionId", this.field_sessionId);
        }
        if (this.eEa) {
          localContentValues.put("datatotalsize", Long.valueOf(this.field_datatotalsize));
        }
        if (this.systemRowid > 0L) {
          localContentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return localContentValues;
        localIOException1 = localIOException1;
        ac.e("MicroMsg.SDK.BaseFavItemInfo", localIOException1.getMessage());
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          ac.e("MicroMsg.SDK.BaseFavItemInfo", localIOException2.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bw
 * JD-Core Version:    0.7.0.1
 */