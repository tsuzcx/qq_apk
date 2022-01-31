package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yw;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bn
  extends c
{
  private static final int cDW;
  private static final int cHJ;
  private static final int cHY;
  private static final int cHZ;
  private static final int cIa;
  private static final int cIb;
  private static final int cIc;
  private static final int cId;
  private static final int cIe;
  private static final int cIf;
  private static final int cIg;
  private static final int cIh;
  private static final int cIi;
  private static final int cIj;
  private static final int cIk = "datatotalsize".hashCode();
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS FavItemInfo_id_Index ON FavItemInfo(id)", "CREATE INDEX IF NOT EXISTS FavItemInfo_type_Index ON FavItemInfo(type)", "CREATE INDEX IF NOT EXISTS FavItemInfo_updateSeq_Index ON FavItemInfo(updateSeq)", "CREATE INDEX IF NOT EXISTS FavItemInfo_flag_Index ON FavItemInfo(flag)", "CREATE INDEX IF NOT EXISTS FavItemInfo_sourceId_Index ON FavItemInfo(sourceId)", "CREATE INDEX IF NOT EXISTS FavItemInfo_datatotalsize_Index ON FavItemInfo(datatotalsize)" };
  private static final int crh = "rowid".hashCode();
  private static final int csy;
  private static final int csz;
  private static final int ctG;
  private static final int cui;
  private static final int cvY;
  private static final int cwe;
  private boolean cDT = true;
  private boolean cHH = true;
  private boolean cHL = true;
  private boolean cHM = true;
  private boolean cHN = true;
  private boolean cHO = true;
  private boolean cHP = true;
  private boolean cHQ = true;
  private boolean cHR = true;
  private boolean cHS = true;
  private boolean cHT = true;
  private boolean cHU = true;
  private boolean cHV = true;
  private boolean cHW = true;
  private boolean cHX = true;
  private boolean csa = true;
  private boolean csb = true;
  private boolean ctE = true;
  private boolean cub = true;
  private boolean cvU = true;
  private boolean cwc = true;
  public long field_datatotalsize;
  public long field_edittime;
  public String field_ext;
  public yj field_favProto;
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
  public yw field_tagProto;
  public String field_toUser;
  public int field_type;
  public int field_updateSeq;
  public long field_updateTime;
  public String field_xml;
  
  static
  {
    cHJ = "localId".hashCode();
    cDW = "id".hashCode();
    csy = "type".hashCode();
    cHY = "localSeq".hashCode();
    cHZ = "updateSeq".hashCode();
    cwe = "flag".hashCode();
    cIa = "sourceId".hashCode();
    cIb = "itemStatus".hashCode();
    csz = "sourceType".hashCode();
    cIc = "sourceCreateTime".hashCode();
    ctG = "updateTime".hashCode();
    cId = "fromUser".hashCode();
    cIe = "toUser".hashCode();
    cIf = "realChatName".hashCode();
    cIg = "favProto".hashCode();
    cvY = "xml".hashCode();
    cIh = "ext".hashCode();
    cIi = "edittime".hashCode();
    cIj = "tagProto".hashCode();
    cui = "sessionId".hashCode();
  }
  
  public static c.a vg()
  {
    c.a locala = new c.a();
    locala.ujL = new Field[21];
    locala.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.ujN.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "localId";
    locala.columns[1] = "id";
    locala.ujN.put("id", "INTEGER");
    localStringBuilder.append(" id INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.ujN.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "localSeq";
    locala.ujN.put("localSeq", "INTEGER");
    localStringBuilder.append(" localSeq INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "updateSeq";
    locala.ujN.put("updateSeq", "INTEGER");
    localStringBuilder.append(" updateSeq INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "flag";
    locala.ujN.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "sourceId";
    locala.ujN.put("sourceId", "TEXT");
    localStringBuilder.append(" sourceId TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "itemStatus";
    locala.ujN.put("itemStatus", "INTEGER");
    localStringBuilder.append(" itemStatus INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "sourceType";
    locala.ujN.put("sourceType", "INTEGER");
    localStringBuilder.append(" sourceType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "sourceCreateTime";
    locala.ujN.put("sourceCreateTime", "LONG");
    localStringBuilder.append(" sourceCreateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "updateTime";
    locala.ujN.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "fromUser";
    locala.ujN.put("fromUser", "TEXT");
    localStringBuilder.append(" fromUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "toUser";
    locala.ujN.put("toUser", "TEXT");
    localStringBuilder.append(" toUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "realChatName";
    locala.ujN.put("realChatName", "TEXT");
    localStringBuilder.append(" realChatName TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "favProto";
    locala.ujN.put("favProto", "BLOB");
    localStringBuilder.append(" favProto BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "xml";
    locala.ujN.put("xml", "TEXT");
    localStringBuilder.append(" xml TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "ext";
    locala.ujN.put("ext", "TEXT");
    localStringBuilder.append(" ext TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "edittime";
    locala.ujN.put("edittime", "LONG");
    localStringBuilder.append(" edittime LONG");
    localStringBuilder.append(", ");
    locala.columns[18] = "tagProto";
    locala.ujN.put("tagProto", "BLOB");
    localStringBuilder.append(" tagProto BLOB");
    localStringBuilder.append(", ");
    locala.columns[19] = "sessionId";
    locala.ujN.put("sessionId", "TEXT");
    localStringBuilder.append(" sessionId TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "datatotalsize";
    locala.ujN.put("datatotalsize", "LONG");
    localStringBuilder.append(" datatotalsize LONG");
    locala.columns[21] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
  }
  
  public final void d(Cursor paramCursor)
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
      if (cHJ != k) {
        break label65;
      }
      this.field_localId = paramCursor.getLong(i);
      this.cHH = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cDW == k) {
        this.field_id = paramCursor.getInt(i);
      } else if (csy == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (cHY == k) {
        this.field_localSeq = paramCursor.getInt(i);
      } else if (cHZ == k) {
        this.field_updateSeq = paramCursor.getInt(i);
      } else if (cwe == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (cIa == k) {
        this.field_sourceId = paramCursor.getString(i);
      } else if (cIb == k) {
        this.field_itemStatus = paramCursor.getInt(i);
      } else if (csz == k) {
        this.field_sourceType = paramCursor.getInt(i);
      } else if (cIc == k) {
        this.field_sourceCreateTime = paramCursor.getLong(i);
      } else if (ctG == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (cId == k) {
        this.field_fromUser = paramCursor.getString(i);
      } else if (cIe == k) {
        this.field_toUser = paramCursor.getString(i);
      } else if (cIf == k) {
        this.field_realChatName = paramCursor.getString(i);
      } else if (cIg == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_favProto = ((yj)new yj().aH(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          y.e("MicroMsg.SDK.BaseFavItemInfo", localIOException1.getMessage());
        }
      } else if (cvY == k) {
        this.field_xml = paramCursor.getString(i);
      } else if (cIh == k) {
        this.field_ext = paramCursor.getString(i);
      } else if (cIi == k) {
        this.field_edittime = paramCursor.getLong(i);
      } else if (cIj == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_tagProto = ((yw)new yw().aH(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          y.e("MicroMsg.SDK.BaseFavItemInfo", localIOException2.getMessage());
        }
      } else if (cui == k) {
        this.field_sessionId = paramCursor.getString(i);
      } else if (cIk == k) {
        this.field_datatotalsize = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cHH) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if (this.cDT) {
      localContentValues.put("id", Integer.valueOf(this.field_id));
    }
    if (this.csa) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.cHL) {
      localContentValues.put("localSeq", Integer.valueOf(this.field_localSeq));
    }
    if (this.cHM) {
      localContentValues.put("updateSeq", Integer.valueOf(this.field_updateSeq));
    }
    if (this.cwc) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.cHN) {
      localContentValues.put("sourceId", this.field_sourceId);
    }
    if (this.cHO) {
      localContentValues.put("itemStatus", Integer.valueOf(this.field_itemStatus));
    }
    if (this.csb) {
      localContentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
    }
    if (this.cHP) {
      localContentValues.put("sourceCreateTime", Long.valueOf(this.field_sourceCreateTime));
    }
    if (this.ctE) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.cHQ) {
      localContentValues.put("fromUser", this.field_fromUser);
    }
    if (this.cHR) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.cHS) {
      localContentValues.put("realChatName", this.field_realChatName);
    }
    if ((this.cHT) && (this.field_favProto != null)) {}
    try
    {
      localContentValues.put("favProto", this.field_favProto.toByteArray());
      if (this.cvU) {
        localContentValues.put("xml", this.field_xml);
      }
      if (this.cHU) {
        localContentValues.put("ext", this.field_ext);
      }
      if (this.cHV) {
        localContentValues.put("edittime", Long.valueOf(this.field_edittime));
      }
      if ((!this.cHW) || (this.field_tagProto == null)) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        localContentValues.put("tagProto", this.field_tagProto.toByteArray());
        if (this.cub) {
          localContentValues.put("sessionId", this.field_sessionId);
        }
        if (this.cHX) {
          localContentValues.put("datatotalsize", Long.valueOf(this.field_datatotalsize));
        }
        if (this.ujK > 0L) {
          localContentValues.put("rowid", Long.valueOf(this.ujK));
        }
        return localContentValues;
        localIOException1 = localIOException1;
        y.e("MicroMsg.SDK.BaseFavItemInfo", localIOException1.getMessage());
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          y.e("MicroMsg.SDK.BaseFavItemInfo", localIOException2.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.c.bn
 * JD-Core Version:    0.7.0.1
 */