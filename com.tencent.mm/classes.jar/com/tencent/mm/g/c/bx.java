package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.ala;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bx
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FavItemInfo_id_Index ON FavItemInfo(id)", "CREATE INDEX IF NOT EXISTS FavItemInfo_type_Index ON FavItemInfo(type)", "CREATE INDEX IF NOT EXISTS FavItemInfo_updateSeq_Index ON FavItemInfo(updateSeq)", "CREATE INDEX IF NOT EXISTS FavItemInfo_flag_Index ON FavItemInfo(flag)", "CREATE INDEX IF NOT EXISTS FavItemInfo_sourceId_Index ON FavItemInfo(sourceId)", "CREATE INDEX IF NOT EXISTS FavItemInfo_datatotalsize_Index ON FavItemInfo(datatotalsize)" };
  private static final int eFR;
  private static final int eGZ;
  private static final int eJB = "xml".hashCode();
  private static final int eJG;
  private static final int eQh;
  private static final int eWU = "localId".hashCode();
  private static final int eXk;
  private static final int eXl;
  private static final int eXm;
  private static final int eXn;
  private static final int eXo;
  private static final int eXp;
  private static final int eXq;
  private static final int eXr;
  private static final int eXs;
  private static final int eXt = "ext".hashCode();
  private static final int eXu = "edittime".hashCode();
  private static final int eXv = "tagProto".hashCode();
  private static final int eXw = "sessionId".hashCode();
  private static final int eXx = "datatotalsize".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eFu = true;
  private boolean eGW = true;
  private boolean eJE = true;
  private boolean eJy = true;
  private boolean eQd = true;
  private boolean eWS = true;
  private boolean eWW = true;
  private boolean eWX = true;
  private boolean eWY = true;
  private boolean eWZ = true;
  private boolean eXa = true;
  private boolean eXb = true;
  private boolean eXc = true;
  private boolean eXd = true;
  private boolean eXe = true;
  private boolean eXf = true;
  private boolean eXg = true;
  private boolean eXh = true;
  private boolean eXi = true;
  private boolean eXj = true;
  public long field_datatotalsize;
  public long field_edittime;
  public String field_ext;
  public akn field_favProto;
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
  public ala field_tagProto;
  public String field_toUser;
  public int field_type;
  public int field_updateSeq;
  public long field_updateTime;
  public String field_xml;
  
  static
  {
    eQh = "id".hashCode();
    type_HASHCODE = "type".hashCode();
    eXk = "localSeq".hashCode();
    eXl = "updateSeq".hashCode();
    eJG = "flag".hashCode();
    eXm = "sourceId".hashCode();
    eXn = "itemStatus".hashCode();
    eFR = "sourceType".hashCode();
    eXo = "sourceCreateTime".hashCode();
    eGZ = "updateTime".hashCode();
    eXp = "fromUser".hashCode();
    eXq = "toUser".hashCode();
    eXr = "realChatName".hashCode();
    eXs = "favProto".hashCode();
  }
  
  public static c.a VD()
  {
    c.a locala = new c.a();
    locala.IBL = new Field[21];
    locala.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.IBN.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "localId";
    locala.columns[1] = "id";
    locala.IBN.put("id", "INTEGER");
    localStringBuilder.append(" id INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.IBN.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "localSeq";
    locala.IBN.put("localSeq", "INTEGER");
    localStringBuilder.append(" localSeq INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "updateSeq";
    locala.IBN.put("updateSeq", "INTEGER");
    localStringBuilder.append(" updateSeq INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "flag";
    locala.IBN.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "sourceId";
    locala.IBN.put("sourceId", "TEXT");
    localStringBuilder.append(" sourceId TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "itemStatus";
    locala.IBN.put("itemStatus", "INTEGER");
    localStringBuilder.append(" itemStatus INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "sourceType";
    locala.IBN.put("sourceType", "INTEGER");
    localStringBuilder.append(" sourceType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "sourceCreateTime";
    locala.IBN.put("sourceCreateTime", "LONG");
    localStringBuilder.append(" sourceCreateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "updateTime";
    locala.IBN.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "fromUser";
    locala.IBN.put("fromUser", "TEXT");
    localStringBuilder.append(" fromUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "toUser";
    locala.IBN.put("toUser", "TEXT");
    localStringBuilder.append(" toUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "realChatName";
    locala.IBN.put("realChatName", "TEXT");
    localStringBuilder.append(" realChatName TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "favProto";
    locala.IBN.put("favProto", "BLOB");
    localStringBuilder.append(" favProto BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "xml";
    locala.IBN.put("xml", "TEXT");
    localStringBuilder.append(" xml TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "ext";
    locala.IBN.put("ext", "TEXT");
    localStringBuilder.append(" ext TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "edittime";
    locala.IBN.put("edittime", "LONG");
    localStringBuilder.append(" edittime LONG");
    localStringBuilder.append(", ");
    locala.columns[18] = "tagProto";
    locala.IBN.put("tagProto", "BLOB");
    localStringBuilder.append(" tagProto BLOB");
    localStringBuilder.append(", ");
    locala.columns[19] = "sessionId";
    locala.IBN.put("sessionId", "TEXT");
    localStringBuilder.append(" sessionId TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "datatotalsize";
    locala.IBN.put("datatotalsize", "LONG");
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
      if (eWU != k) {
        break label65;
      }
      this.field_localId = paramCursor.getLong(i);
      this.eWS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eQh == k) {
        this.field_id = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eXk == k) {
        this.field_localSeq = paramCursor.getInt(i);
      } else if (eXl == k) {
        this.field_updateSeq = paramCursor.getInt(i);
      } else if (eJG == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (eXm == k) {
        this.field_sourceId = paramCursor.getString(i);
      } else if (eXn == k) {
        this.field_itemStatus = paramCursor.getInt(i);
      } else if (eFR == k) {
        this.field_sourceType = paramCursor.getInt(i);
      } else if (eXo == k) {
        this.field_sourceCreateTime = paramCursor.getLong(i);
      } else if (eGZ == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eXp == k) {
        this.field_fromUser = paramCursor.getString(i);
      } else if (eXq == k) {
        this.field_toUser = paramCursor.getString(i);
      } else if (eXr == k) {
        this.field_realChatName = paramCursor.getString(i);
      } else if (eXs == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_favProto = ((akn)new akn().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ae.e("MicroMsg.SDK.BaseFavItemInfo", localIOException1.getMessage());
        }
      } else if (eJB == k) {
        this.field_xml = paramCursor.getString(i);
      } else if (eXt == k) {
        this.field_ext = paramCursor.getString(i);
      } else if (eXu == k) {
        this.field_edittime = paramCursor.getLong(i);
      } else if (eXv == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_tagProto = ((ala)new ala().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ae.e("MicroMsg.SDK.BaseFavItemInfo", localIOException2.getMessage());
        }
      } else if (eXw == k) {
        this.field_sessionId = paramCursor.getString(i);
      } else if (eXx == k) {
        this.field_datatotalsize = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eWS) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if (this.eQd) {
      localContentValues.put("id", Integer.valueOf(this.field_id));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eWW) {
      localContentValues.put("localSeq", Integer.valueOf(this.field_localSeq));
    }
    if (this.eWX) {
      localContentValues.put("updateSeq", Integer.valueOf(this.field_updateSeq));
    }
    if (this.eJE) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.eWY) {
      localContentValues.put("sourceId", this.field_sourceId);
    }
    if (this.eWZ) {
      localContentValues.put("itemStatus", Integer.valueOf(this.field_itemStatus));
    }
    if (this.eFu) {
      localContentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
    }
    if (this.eXa) {
      localContentValues.put("sourceCreateTime", Long.valueOf(this.field_sourceCreateTime));
    }
    if (this.eGW) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eXb) {
      localContentValues.put("fromUser", this.field_fromUser);
    }
    if (this.eXc) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.eXd) {
      localContentValues.put("realChatName", this.field_realChatName);
    }
    if ((this.eXe) && (this.field_favProto != null)) {}
    try
    {
      localContentValues.put("favProto", this.field_favProto.toByteArray());
      if (this.eJy) {
        localContentValues.put("xml", this.field_xml);
      }
      if (this.eXf) {
        localContentValues.put("ext", this.field_ext);
      }
      if (this.eXg) {
        localContentValues.put("edittime", Long.valueOf(this.field_edittime));
      }
      if ((!this.eXh) || (this.field_tagProto == null)) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        localContentValues.put("tagProto", this.field_tagProto.toByteArray());
        if (this.eXi) {
          localContentValues.put("sessionId", this.field_sessionId);
        }
        if (this.eXj) {
          localContentValues.put("datatotalsize", Long.valueOf(this.field_datatotalsize));
        }
        if (this.systemRowid > 0L) {
          localContentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return localContentValues;
        localIOException1 = localIOException1;
        ae.e("MicroMsg.SDK.BaseFavItemInfo", localIOException1.getMessage());
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          ae.e("MicroMsg.SDK.BaseFavItemInfo", localIOException2.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bx
 * JD-Core Version:    0.7.0.1
 */