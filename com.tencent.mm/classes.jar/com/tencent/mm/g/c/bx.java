package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akq;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bx
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FavItemInfo_id_Index ON FavItemInfo(id)", "CREATE INDEX IF NOT EXISTS FavItemInfo_type_Index ON FavItemInfo(type)", "CREATE INDEX IF NOT EXISTS FavItemInfo_updateSeq_Index ON FavItemInfo(updateSeq)", "CREATE INDEX IF NOT EXISTS FavItemInfo_flag_Index ON FavItemInfo(flag)", "CREATE INDEX IF NOT EXISTS FavItemInfo_sourceId_Index ON FavItemInfo(sourceId)", "CREATE INDEX IF NOT EXISTS FavItemInfo_datatotalsize_Index ON FavItemInfo(datatotalsize)" };
  private static final int eEi;
  private static final int eFq;
  private static final int eHS = "xml".hashCode();
  private static final int eHX;
  private static final int eOw;
  private static final int eVA;
  private static final int eVB;
  private static final int eVC;
  private static final int eVD;
  private static final int eVE;
  private static final int eVF;
  private static final int eVG;
  private static final int eVH;
  private static final int eVI = "ext".hashCode();
  private static final int eVJ = "edittime".hashCode();
  private static final int eVK = "tagProto".hashCode();
  private static final int eVL = "sessionId".hashCode();
  private static final int eVM = "datatotalsize".hashCode();
  private static final int eVj = "localId".hashCode();
  private static final int eVz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eDL = true;
  private boolean eFn = true;
  private boolean eHP = true;
  private boolean eHV = true;
  private boolean eOs = true;
  private boolean eVh = true;
  private boolean eVl = true;
  private boolean eVm = true;
  private boolean eVn = true;
  private boolean eVo = true;
  private boolean eVp = true;
  private boolean eVq = true;
  private boolean eVr = true;
  private boolean eVs = true;
  private boolean eVt = true;
  private boolean eVu = true;
  private boolean eVv = true;
  private boolean eVw = true;
  private boolean eVx = true;
  private boolean eVy = true;
  public long field_datatotalsize;
  public long field_edittime;
  public String field_ext;
  public akd field_favProto;
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
  public akq field_tagProto;
  public String field_toUser;
  public int field_type;
  public int field_updateSeq;
  public long field_updateTime;
  public String field_xml;
  
  static
  {
    eOw = "id".hashCode();
    type_HASHCODE = "type".hashCode();
    eVz = "localSeq".hashCode();
    eVA = "updateSeq".hashCode();
    eHX = "flag".hashCode();
    eVB = "sourceId".hashCode();
    eVC = "itemStatus".hashCode();
    eEi = "sourceType".hashCode();
    eVD = "sourceCreateTime".hashCode();
    eFq = "updateTime".hashCode();
    eVE = "fromUser".hashCode();
    eVF = "toUser".hashCode();
    eVG = "realChatName".hashCode();
    eVH = "favProto".hashCode();
  }
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[21];
    locala.columns = new String[22];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.IhC.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "localId";
    locala.columns[1] = "id";
    locala.IhC.put("id", "INTEGER");
    localStringBuilder.append(" id INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "type";
    locala.IhC.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "localSeq";
    locala.IhC.put("localSeq", "INTEGER");
    localStringBuilder.append(" localSeq INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "updateSeq";
    locala.IhC.put("updateSeq", "INTEGER");
    localStringBuilder.append(" updateSeq INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "flag";
    locala.IhC.put("flag", "INTEGER");
    localStringBuilder.append(" flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "sourceId";
    locala.IhC.put("sourceId", "TEXT");
    localStringBuilder.append(" sourceId TEXT");
    localStringBuilder.append(", ");
    locala.columns[7] = "itemStatus";
    locala.IhC.put("itemStatus", "INTEGER");
    localStringBuilder.append(" itemStatus INTEGER");
    localStringBuilder.append(", ");
    locala.columns[8] = "sourceType";
    locala.IhC.put("sourceType", "INTEGER");
    localStringBuilder.append(" sourceType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "sourceCreateTime";
    locala.IhC.put("sourceCreateTime", "LONG");
    localStringBuilder.append(" sourceCreateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "updateTime";
    locala.IhC.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "fromUser";
    locala.IhC.put("fromUser", "TEXT");
    localStringBuilder.append(" fromUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "toUser";
    locala.IhC.put("toUser", "TEXT");
    localStringBuilder.append(" toUser TEXT");
    localStringBuilder.append(", ");
    locala.columns[13] = "realChatName";
    locala.IhC.put("realChatName", "TEXT");
    localStringBuilder.append(" realChatName TEXT");
    localStringBuilder.append(", ");
    locala.columns[14] = "favProto";
    locala.IhC.put("favProto", "BLOB");
    localStringBuilder.append(" favProto BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "xml";
    locala.IhC.put("xml", "TEXT");
    localStringBuilder.append(" xml TEXT");
    localStringBuilder.append(", ");
    locala.columns[16] = "ext";
    locala.IhC.put("ext", "TEXT");
    localStringBuilder.append(" ext TEXT");
    localStringBuilder.append(", ");
    locala.columns[17] = "edittime";
    locala.IhC.put("edittime", "LONG");
    localStringBuilder.append(" edittime LONG");
    localStringBuilder.append(", ");
    locala.columns[18] = "tagProto";
    locala.IhC.put("tagProto", "BLOB");
    localStringBuilder.append(" tagProto BLOB");
    localStringBuilder.append(", ");
    locala.columns[19] = "sessionId";
    locala.IhC.put("sessionId", "TEXT");
    localStringBuilder.append(" sessionId TEXT");
    localStringBuilder.append(", ");
    locala.columns[20] = "datatotalsize";
    locala.IhC.put("datatotalsize", "LONG");
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
      if (eVj != k) {
        break label65;
      }
      this.field_localId = paramCursor.getLong(i);
      this.eVh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eOw == k) {
        this.field_id = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eVz == k) {
        this.field_localSeq = paramCursor.getInt(i);
      } else if (eVA == k) {
        this.field_updateSeq = paramCursor.getInt(i);
      } else if (eHX == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (eVB == k) {
        this.field_sourceId = paramCursor.getString(i);
      } else if (eVC == k) {
        this.field_itemStatus = paramCursor.getInt(i);
      } else if (eEi == k) {
        this.field_sourceType = paramCursor.getInt(i);
      } else if (eVD == k) {
        this.field_sourceCreateTime = paramCursor.getLong(i);
      } else if (eFq == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eVE == k) {
        this.field_fromUser = paramCursor.getString(i);
      } else if (eVF == k) {
        this.field_toUser = paramCursor.getString(i);
      } else if (eVG == k) {
        this.field_realChatName = paramCursor.getString(i);
      } else if (eVH == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_favProto = ((akd)new akd().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ad.e("MicroMsg.SDK.BaseFavItemInfo", localIOException1.getMessage());
        }
      } else if (eHS == k) {
        this.field_xml = paramCursor.getString(i);
      } else if (eVI == k) {
        this.field_ext = paramCursor.getString(i);
      } else if (eVJ == k) {
        this.field_edittime = paramCursor.getLong(i);
      } else if (eVK == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_tagProto = ((akq)new akq().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ad.e("MicroMsg.SDK.BaseFavItemInfo", localIOException2.getMessage());
        }
      } else if (eVL == k) {
        this.field_sessionId = paramCursor.getString(i);
      } else if (eVM == k) {
        this.field_datatotalsize = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eVh) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if (this.eOs) {
      localContentValues.put("id", Integer.valueOf(this.field_id));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eVl) {
      localContentValues.put("localSeq", Integer.valueOf(this.field_localSeq));
    }
    if (this.eVm) {
      localContentValues.put("updateSeq", Integer.valueOf(this.field_updateSeq));
    }
    if (this.eHV) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.eVn) {
      localContentValues.put("sourceId", this.field_sourceId);
    }
    if (this.eVo) {
      localContentValues.put("itemStatus", Integer.valueOf(this.field_itemStatus));
    }
    if (this.eDL) {
      localContentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
    }
    if (this.eVp) {
      localContentValues.put("sourceCreateTime", Long.valueOf(this.field_sourceCreateTime));
    }
    if (this.eFn) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.eVq) {
      localContentValues.put("fromUser", this.field_fromUser);
    }
    if (this.eVr) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.eVs) {
      localContentValues.put("realChatName", this.field_realChatName);
    }
    if ((this.eVt) && (this.field_favProto != null)) {}
    try
    {
      localContentValues.put("favProto", this.field_favProto.toByteArray());
      if (this.eHP) {
        localContentValues.put("xml", this.field_xml);
      }
      if (this.eVu) {
        localContentValues.put("ext", this.field_ext);
      }
      if (this.eVv) {
        localContentValues.put("edittime", Long.valueOf(this.field_edittime));
      }
      if ((!this.eVw) || (this.field_tagProto == null)) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        localContentValues.put("tagProto", this.field_tagProto.toByteArray());
        if (this.eVx) {
          localContentValues.put("sessionId", this.field_sessionId);
        }
        if (this.eVy) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.bx
 * JD-Core Version:    0.7.0.1
 */