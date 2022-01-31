package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bp
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FavItemInfo_id_Index ON FavItemInfo(id)", "CREATE INDEX IF NOT EXISTS FavItemInfo_type_Index ON FavItemInfo(type)", "CREATE INDEX IF NOT EXISTS FavItemInfo_updateSeq_Index ON FavItemInfo(updateSeq)", "CREATE INDEX IF NOT EXISTS FavItemInfo_flag_Index ON FavItemInfo(flag)", "CREATE INDEX IF NOT EXISTS FavItemInfo_sourceId_Index ON FavItemInfo(sourceId)", "CREATE INDEX IF NOT EXISTS FavItemInfo_datatotalsize_Index ON FavItemInfo(datatotalsize)" };
  private static final int dgP;
  private static final int dhV;
  private static final int dki = "xml".hashCode();
  private static final int dkn;
  private static final int dsg;
  private static final int dwH;
  private static final int dwI;
  private static final int dwJ;
  private static final int dwK;
  private static final int dwL;
  private static final int dwM;
  private static final int dwN;
  private static final int dwO;
  private static final int dwP;
  private static final int dwQ = "ext".hashCode();
  private static final int dwR = "edittime".hashCode();
  private static final int dwS = "tagProto".hashCode();
  private static final int dwT = "sessionId".hashCode();
  private static final int dwU = "datatotalsize".hashCode();
  private static final int dwr = "localId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean dgs = true;
  private boolean dhT = true;
  private boolean dkf = true;
  private boolean dkl = true;
  private boolean dsd = true;
  private boolean dwA = true;
  private boolean dwB = true;
  private boolean dwC = true;
  private boolean dwD = true;
  private boolean dwE = true;
  private boolean dwF = true;
  private boolean dwG = true;
  private boolean dwp = true;
  private boolean dwt = true;
  private boolean dwu = true;
  private boolean dwv = true;
  private boolean dww = true;
  private boolean dwx = true;
  private boolean dwy = true;
  private boolean dwz = true;
  public long field_datatotalsize;
  public long field_edittime;
  public String field_ext;
  public acq field_favProto;
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
  public add field_tagProto;
  public String field_toUser;
  public int field_type;
  public int field_updateSeq;
  public long field_updateTime;
  public String field_xml;
  
  static
  {
    dsg = "id".hashCode();
    type_HASHCODE = "type".hashCode();
    dwH = "localSeq".hashCode();
    dwI = "updateSeq".hashCode();
    dkn = "flag".hashCode();
    dwJ = "sourceId".hashCode();
    dwK = "itemStatus".hashCode();
    dgP = "sourceType".hashCode();
    dwL = "sourceCreateTime".hashCode();
    dhV = "updateTime".hashCode();
    dwM = "fromUser".hashCode();
    dwN = "toUser".hashCode();
    dwO = "realChatName".hashCode();
    dwP = "favProto".hashCode();
  }
  
  public static c.a Hm()
  {
    c.a locala = new c.a();
    locala.yrK = new Field[21];
    locala.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.yrM.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "localId";
    locala.columns[1] = "id";
    locala.yrM.put("id", "INTEGER");
    localStringBuilder.append(" id INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.yrM.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "localSeq";
    locala.yrM.put("localSeq", "INTEGER");
    localStringBuilder.append(" localSeq INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "updateSeq";
    locala.yrM.put("updateSeq", "INTEGER");
    localStringBuilder.append(" updateSeq INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "flag";
    locala.yrM.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "sourceId";
    locala.yrM.put("sourceId", "TEXT");
    localStringBuilder.append(" sourceId TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "itemStatus";
    locala.yrM.put("itemStatus", "INTEGER");
    localStringBuilder.append(" itemStatus INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "sourceType";
    locala.yrM.put("sourceType", "INTEGER");
    localStringBuilder.append(" sourceType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "sourceCreateTime";
    locala.yrM.put("sourceCreateTime", "LONG");
    localStringBuilder.append(" sourceCreateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "updateTime";
    locala.yrM.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "fromUser";
    locala.yrM.put("fromUser", "TEXT");
    localStringBuilder.append(" fromUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "toUser";
    locala.yrM.put("toUser", "TEXT");
    localStringBuilder.append(" toUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "realChatName";
    locala.yrM.put("realChatName", "TEXT");
    localStringBuilder.append(" realChatName TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "favProto";
    locala.yrM.put("favProto", "BLOB");
    localStringBuilder.append(" favProto BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "xml";
    locala.yrM.put("xml", "TEXT");
    localStringBuilder.append(" xml TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "ext";
    locala.yrM.put("ext", "TEXT");
    localStringBuilder.append(" ext TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "edittime";
    locala.yrM.put("edittime", "LONG");
    localStringBuilder.append(" edittime LONG");
    localStringBuilder.append(", ");
    locala.columns[18] = "tagProto";
    locala.yrM.put("tagProto", "BLOB");
    localStringBuilder.append(" tagProto BLOB");
    localStringBuilder.append(", ");
    locala.columns[19] = "sessionId";
    locala.yrM.put("sessionId", "TEXT");
    localStringBuilder.append(" sessionId TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "datatotalsize";
    locala.yrM.put("datatotalsize", "LONG");
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
      if (dwr != k) {
        break label65;
      }
      this.field_localId = paramCursor.getLong(i);
      this.dwp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dsg == k) {
        this.field_id = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (dwH == k) {
        this.field_localSeq = paramCursor.getInt(i);
      } else if (dwI == k) {
        this.field_updateSeq = paramCursor.getInt(i);
      } else if (dkn == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (dwJ == k) {
        this.field_sourceId = paramCursor.getString(i);
      } else if (dwK == k) {
        this.field_itemStatus = paramCursor.getInt(i);
      } else if (dgP == k) {
        this.field_sourceType = paramCursor.getInt(i);
      } else if (dwL == k) {
        this.field_sourceCreateTime = paramCursor.getLong(i);
      } else if (dhV == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (dwM == k) {
        this.field_fromUser = paramCursor.getString(i);
      } else if (dwN == k) {
        this.field_toUser = paramCursor.getString(i);
      } else if (dwO == k) {
        this.field_realChatName = paramCursor.getString(i);
      } else if (dwP == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_favProto = ((acq)new acq().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ab.e("MicroMsg.SDK.BaseFavItemInfo", localIOException1.getMessage());
        }
      } else if (dki == k) {
        this.field_xml = paramCursor.getString(i);
      } else if (dwQ == k) {
        this.field_ext = paramCursor.getString(i);
      } else if (dwR == k) {
        this.field_edittime = paramCursor.getLong(i);
      } else if (dwS == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_tagProto = ((add)new add().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ab.e("MicroMsg.SDK.BaseFavItemInfo", localIOException2.getMessage());
        }
      } else if (dwT == k) {
        this.field_sessionId = paramCursor.getString(i);
      } else if (dwU == k) {
        this.field_datatotalsize = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dwp) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if (this.dsd) {
      localContentValues.put("id", Integer.valueOf(this.field_id));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.dwt) {
      localContentValues.put("localSeq", Integer.valueOf(this.field_localSeq));
    }
    if (this.dwu) {
      localContentValues.put("updateSeq", Integer.valueOf(this.field_updateSeq));
    }
    if (this.dkl) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.dwv) {
      localContentValues.put("sourceId", this.field_sourceId);
    }
    if (this.dww) {
      localContentValues.put("itemStatus", Integer.valueOf(this.field_itemStatus));
    }
    if (this.dgs) {
      localContentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
    }
    if (this.dwx) {
      localContentValues.put("sourceCreateTime", Long.valueOf(this.field_sourceCreateTime));
    }
    if (this.dhT) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.dwy) {
      localContentValues.put("fromUser", this.field_fromUser);
    }
    if (this.dwz) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.dwA) {
      localContentValues.put("realChatName", this.field_realChatName);
    }
    if ((this.dwB) && (this.field_favProto != null)) {}
    try
    {
      localContentValues.put("favProto", this.field_favProto.toByteArray());
      if (this.dkf) {
        localContentValues.put("xml", this.field_xml);
      }
      if (this.dwC) {
        localContentValues.put("ext", this.field_ext);
      }
      if (this.dwD) {
        localContentValues.put("edittime", Long.valueOf(this.field_edittime));
      }
      if ((!this.dwE) || (this.field_tagProto == null)) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        localContentValues.put("tagProto", this.field_tagProto.toByteArray());
        if (this.dwF) {
          localContentValues.put("sessionId", this.field_sessionId);
        }
        if (this.dwG) {
          localContentValues.put("datatotalsize", Long.valueOf(this.field_datatotalsize));
        }
        if (this.systemRowid > 0L) {
          localContentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return localContentValues;
        localIOException1 = localIOException1;
        ab.e("MicroMsg.SDK.BaseFavItemInfo", localIOException1.getMessage());
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          ab.e("MicroMsg.SDK.BaseFavItemInfo", localIOException2.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.bp
 * JD-Core Version:    0.7.0.1
 */