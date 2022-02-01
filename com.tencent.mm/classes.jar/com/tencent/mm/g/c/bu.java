package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.ahb;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bu
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FavItemInfo_id_Index ON FavItemInfo(id)", "CREATE INDEX IF NOT EXISTS FavItemInfo_type_Index ON FavItemInfo(type)", "CREATE INDEX IF NOT EXISTS FavItemInfo_updateSeq_Index ON FavItemInfo(updateSeq)", "CREATE INDEX IF NOT EXISTS FavItemInfo_flag_Index ON FavItemInfo(flag)", "CREATE INDEX IF NOT EXISTS FavItemInfo_sourceId_Index ON FavItemInfo(sourceId)", "CREATE INDEX IF NOT EXISTS FavItemInfo_datatotalsize_Index ON FavItemInfo(datatotalsize)" };
  private static final int eBH;
  private static final int eBI;
  private static final int eBJ;
  private static final int eBK;
  private static final int eBL;
  private static final int eBM;
  private static final int eBN;
  private static final int eBO;
  private static final int eBP;
  private static final int eBQ = "ext".hashCode();
  private static final int eBR = "edittime".hashCode();
  private static final int eBS = "tagProto".hashCode();
  private static final int eBT = "sessionId".hashCode();
  private static final int eBU = "datatotalsize".hashCode();
  private static final int eBr = "localId".hashCode();
  private static final int ekX;
  private static final int emf;
  private static final int eoF;
  private static final int eoK;
  private static final int exb = "id".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eBA = true;
  private boolean eBB = true;
  private boolean eBC = true;
  private boolean eBD = true;
  private boolean eBE = true;
  private boolean eBF = true;
  private boolean eBG = true;
  private boolean eBp = true;
  private boolean eBt = true;
  private boolean eBu = true;
  private boolean eBv = true;
  private boolean eBw = true;
  private boolean eBx = true;
  private boolean eBy = true;
  private boolean eBz = true;
  private boolean ekA = true;
  private boolean emc = true;
  private boolean eoC = true;
  private boolean eoI = true;
  private boolean ewY = true;
  public long field_datatotalsize;
  public long field_edittime;
  public String field_ext;
  public ago field_favProto;
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
  public ahb field_tagProto;
  public String field_toUser;
  public int field_type;
  public int field_updateSeq;
  public long field_updateTime;
  public String field_xml;
  
  static
  {
    eBH = "localSeq".hashCode();
    eBI = "updateSeq".hashCode();
    eoK = "flag".hashCode();
    eBJ = "sourceId".hashCode();
    eBK = "itemStatus".hashCode();
    ekX = "sourceType".hashCode();
    eBL = "sourceCreateTime".hashCode();
    emf = "updateTime".hashCode();
    eBM = "fromUser".hashCode();
    eBN = "toUser".hashCode();
    eBO = "realChatName".hashCode();
    eBP = "favProto".hashCode();
    eoF = "xml".hashCode();
  }
  
  public static c.a So()
  {
    c.a locala = new c.a();
    locala.EYt = new Field[21];
    locala.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.EYv.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "localId";
    locala.columns[1] = "id";
    locala.EYv.put("id", "INTEGER");
    localStringBuilder.append(" id INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.EYv.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "localSeq";
    locala.EYv.put("localSeq", "INTEGER");
    localStringBuilder.append(" localSeq INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "updateSeq";
    locala.EYv.put("updateSeq", "INTEGER");
    localStringBuilder.append(" updateSeq INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "flag";
    locala.EYv.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "sourceId";
    locala.EYv.put("sourceId", "TEXT");
    localStringBuilder.append(" sourceId TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "itemStatus";
    locala.EYv.put("itemStatus", "INTEGER");
    localStringBuilder.append(" itemStatus INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "sourceType";
    locala.EYv.put("sourceType", "INTEGER");
    localStringBuilder.append(" sourceType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "sourceCreateTime";
    locala.EYv.put("sourceCreateTime", "LONG");
    localStringBuilder.append(" sourceCreateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "updateTime";
    locala.EYv.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "fromUser";
    locala.EYv.put("fromUser", "TEXT");
    localStringBuilder.append(" fromUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "toUser";
    locala.EYv.put("toUser", "TEXT");
    localStringBuilder.append(" toUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "realChatName";
    locala.EYv.put("realChatName", "TEXT");
    localStringBuilder.append(" realChatName TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "favProto";
    locala.EYv.put("favProto", "BLOB");
    localStringBuilder.append(" favProto BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "xml";
    locala.EYv.put("xml", "TEXT");
    localStringBuilder.append(" xml TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "ext";
    locala.EYv.put("ext", "TEXT");
    localStringBuilder.append(" ext TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "edittime";
    locala.EYv.put("edittime", "LONG");
    localStringBuilder.append(" edittime LONG");
    localStringBuilder.append(", ");
    locala.columns[18] = "tagProto";
    locala.EYv.put("tagProto", "BLOB");
    localStringBuilder.append(" tagProto BLOB");
    localStringBuilder.append(", ");
    locala.columns[19] = "sessionId";
    locala.EYv.put("sessionId", "TEXT");
    localStringBuilder.append(" sessionId TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "datatotalsize";
    locala.EYv.put("datatotalsize", "LONG");
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
      if (eBr != k) {
        break label65;
      }
      this.field_localId = paramCursor.getLong(i);
      this.eBp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (exb == k) {
        this.field_id = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eBH == k) {
        this.field_localSeq = paramCursor.getInt(i);
      } else if (eBI == k) {
        this.field_updateSeq = paramCursor.getInt(i);
      } else if (eoK == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (eBJ == k) {
        this.field_sourceId = paramCursor.getString(i);
      } else if (eBK == k) {
        this.field_itemStatus = paramCursor.getInt(i);
      } else if (ekX == k) {
        this.field_sourceType = paramCursor.getInt(i);
      } else if (eBL == k) {
        this.field_sourceCreateTime = paramCursor.getLong(i);
      } else if (emf == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eBM == k) {
        this.field_fromUser = paramCursor.getString(i);
      } else if (eBN == k) {
        this.field_toUser = paramCursor.getString(i);
      } else if (eBO == k) {
        this.field_realChatName = paramCursor.getString(i);
      } else if (eBP == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_favProto = ((ago)new ago().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ad.e("MicroMsg.SDK.BaseFavItemInfo", localIOException1.getMessage());
        }
      } else if (eoF == k) {
        this.field_xml = paramCursor.getString(i);
      } else if (eBQ == k) {
        this.field_ext = paramCursor.getString(i);
      } else if (eBR == k) {
        this.field_edittime = paramCursor.getLong(i);
      } else if (eBS == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_tagProto = ((ahb)new ahb().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ad.e("MicroMsg.SDK.BaseFavItemInfo", localIOException2.getMessage());
        }
      } else if (eBT == k) {
        this.field_sessionId = paramCursor.getString(i);
      } else if (eBU == k) {
        this.field_datatotalsize = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eBp) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if (this.ewY) {
      localContentValues.put("id", Integer.valueOf(this.field_id));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eBt) {
      localContentValues.put("localSeq", Integer.valueOf(this.field_localSeq));
    }
    if (this.eBu) {
      localContentValues.put("updateSeq", Integer.valueOf(this.field_updateSeq));
    }
    if (this.eoI) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.eBv) {
      localContentValues.put("sourceId", this.field_sourceId);
    }
    if (this.eBw) {
      localContentValues.put("itemStatus", Integer.valueOf(this.field_itemStatus));
    }
    if (this.ekA) {
      localContentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
    }
    if (this.eBx) {
      localContentValues.put("sourceCreateTime", Long.valueOf(this.field_sourceCreateTime));
    }
    if (this.emc) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eBy) {
      localContentValues.put("fromUser", this.field_fromUser);
    }
    if (this.eBz) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.eBA) {
      localContentValues.put("realChatName", this.field_realChatName);
    }
    if ((this.eBB) && (this.field_favProto != null)) {}
    try
    {
      localContentValues.put("favProto", this.field_favProto.toByteArray());
      if (this.eoC) {
        localContentValues.put("xml", this.field_xml);
      }
      if (this.eBC) {
        localContentValues.put("ext", this.field_ext);
      }
      if (this.eBD) {
        localContentValues.put("edittime", Long.valueOf(this.field_edittime));
      }
      if ((!this.eBE) || (this.field_tagProto == null)) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        localContentValues.put("tagProto", this.field_tagProto.toByteArray());
        if (this.eBF) {
          localContentValues.put("sessionId", this.field_sessionId);
        }
        if (this.eBG) {
          localContentValues.put("datatotalsize", Long.valueOf(this.field_datatotalsize));
        }
        if (this.systemRowid > 0L) {
          localContentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return localContentValues;
        localIOException1 = localIOException1;
        ad.e("MicroMsg.SDK.BaseFavItemInfo", localIOException1.getMessage());
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          ad.e("MicroMsg.SDK.BaseFavItemInfo", localIOException2.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bu
 * JD-Core Version:    0.7.0.1
 */