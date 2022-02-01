package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class aq
  extends IAutoDBItem
{
  public static final Column CONTENT;
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("BypMsgInfo");
  public static final Column TYPE;
  private static final int content_HASHCODE;
  private static final int createTime_HASHCODE;
  private static final int jIF;
  public static final Column jIo;
  private static final int jIw;
  public static final Column jIz;
  public static final Column jOV;
  private static final int jOZ;
  public static final Column jPF;
  public static final Column jPQ;
  private static final int jQj;
  private static final int jQu;
  private static final int jSZ;
  public static final Column jSx;
  public static final Column jTA;
  public static final Column jTB;
  public static final Column jTC;
  public static final Column jTD;
  public static final Column jTE;
  public static final Column jTL;
  public static final Column jUA;
  public static final Column jUB;
  private static final int jUC;
  private static final int jUD;
  private static final int jUE;
  private static final int jUF;
  private static final int jUG;
  private static final int jUH;
  private static final int jUI;
  private static final int jUJ;
  private static final int jUc;
  private static final int jUd;
  private static final int jUe;
  private static final int jUf;
  private static final int jUg;
  private static final int jUn;
  public static final Column jUu;
  public static final Column jUv;
  public static final Column jUw;
  public static final Column jUx;
  public static final Column jUy;
  public static final Column jUz;
  private static final StorageObserverOwner<aq> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  public long field_bizChatId;
  public String field_bizChatUserId;
  public String field_bizClientMsgId;
  public String field_content;
  public long field_createTime;
  public byte[] field_extInfo;
  public int field_flag;
  public String field_fromUsername;
  public String field_imgPath;
  public int field_isSend;
  public int field_isShowTimer;
  public byte[] field_lvbuffer;
  public long field_msgId;
  public long field_msgSeq;
  public long field_msgSvrId;
  public String field_reserved;
  public int field_status;
  public String field_talker;
  public int field_talkerId;
  public String field_toUsername;
  public String field_transBrandWording;
  public String field_transContent;
  public int field_type;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jIo = new Column("msgId", "long", TABLE.getName(), "");
    jTA = new Column("msgSvrId", "long", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    jPQ = new Column("isSend", "int", TABLE.getName(), "");
    jUu = new Column("isShowTimer", "int", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "long", TABLE.getName(), "");
    jTB = new Column("talker", "string", TABLE.getName(), "");
    CONTENT = new Column("content", "string", TABLE.getName(), "");
    jTC = new Column("imgPath", "string", TABLE.getName(), "");
    jUv = new Column("reserved", "string", TABLE.getName(), "");
    jTD = new Column("lvbuffer", "byte[]", TABLE.getName(), "");
    jTE = new Column("talkerId", "int", TABLE.getName(), "");
    jUw = new Column("transContent", "string", TABLE.getName(), "");
    jUx = new Column("transBrandWording", "string", TABLE.getName(), "");
    jTL = new Column("bizClientMsgId", "string", TABLE.getName(), "");
    jPF = new Column("bizChatId", "long", TABLE.getName(), "");
    jUy = new Column("bizChatUserId", "string", TABLE.getName(), "");
    jUz = new Column("msgSeq", "long", TABLE.getName(), "");
    jOV = new Column("flag", "int", TABLE.getName(), "");
    jUA = new Column("fromUsername", "string", TABLE.getName(), "");
    jUB = new Column("toUsername", "string", TABLE.getName(), "");
    jSx = new Column("extInfo", "byte[]", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jIw = "msgId".hashCode();
    jUc = "msgSvrId".hashCode();
    type_HASHCODE = "type".hashCode();
    jIF = "status".hashCode();
    jQu = "isSend".hashCode();
    jUC = "isShowTimer".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    jUd = "talker".hashCode();
    content_HASHCODE = "content".hashCode();
    jUe = "imgPath".hashCode();
    jUD = "reserved".hashCode();
    jUf = "lvbuffer".hashCode();
    jUg = "talkerId".hashCode();
    jUE = "transContent".hashCode();
    jUF = "transBrandWording".hashCode();
    jUn = "bizClientMsgId".hashCode();
    jQj = "bizChatId".hashCode();
    jUG = "bizChatUserId".hashCode();
    jUH = "msgSeq".hashCode();
    jOZ = "flag".hashCode();
    jUI = "fromUsername".hashCode();
    jUJ = "toUsername".hashCode();
    jSZ = "extInfo".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[23];
    localMAutoDBInfo.columns = new String[24];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "msgId";
    localMAutoDBInfo.colsMap.put("msgId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "msgId";
    localMAutoDBInfo.columns[1] = "msgSvrId";
    localMAutoDBInfo.colsMap.put("msgSvrId", "LONG");
    localStringBuilder.append(" msgSvrId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "isSend";
    localMAutoDBInfo.colsMap.put("isSend", "INTEGER");
    localStringBuilder.append(" isSend INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "isShowTimer";
    localMAutoDBInfo.colsMap.put("isShowTimer", "INTEGER");
    localStringBuilder.append(" isShowTimer INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "talker";
    localMAutoDBInfo.colsMap.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "imgPath";
    localMAutoDBInfo.colsMap.put("imgPath", "TEXT");
    localStringBuilder.append(" imgPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "reserved";
    localMAutoDBInfo.colsMap.put("reserved", "TEXT");
    localStringBuilder.append(" reserved TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "lvbuffer";
    localMAutoDBInfo.colsMap.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "talkerId";
    localMAutoDBInfo.colsMap.put("talkerId", "INTEGER");
    localStringBuilder.append(" talkerId INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "transContent";
    localMAutoDBInfo.colsMap.put("transContent", "TEXT default '' ");
    localStringBuilder.append(" transContent TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "transBrandWording";
    localMAutoDBInfo.colsMap.put("transBrandWording", "TEXT default '' ");
    localStringBuilder.append(" transBrandWording TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "bizClientMsgId";
    localMAutoDBInfo.colsMap.put("bizClientMsgId", "TEXT default '' ");
    localStringBuilder.append(" bizClientMsgId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "bizChatId";
    localMAutoDBInfo.colsMap.put("bizChatId", "LONG default '-1' ");
    localStringBuilder.append(" bizChatId LONG default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "bizChatUserId";
    localMAutoDBInfo.colsMap.put("bizChatUserId", "TEXT default '' ");
    localStringBuilder.append(" bizChatUserId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "msgSeq";
    localMAutoDBInfo.colsMap.put("msgSeq", "LONG");
    localStringBuilder.append(" msgSeq LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "flag";
    localMAutoDBInfo.colsMap.put("flag", "INTEGER default '0' ");
    localStringBuilder.append(" flag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "fromUsername";
    localMAutoDBInfo.colsMap.put("fromUsername", "TEXT");
    localStringBuilder.append(" fromUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "toUsername";
    localMAutoDBInfo.colsMap.put("toUsername", "TEXT");
    localStringBuilder.append(" toUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "extInfo";
    localMAutoDBInfo.colsMap.put("extInfo", "BLOB");
    localStringBuilder.append(" extInfo BLOB");
    localMAutoDBInfo.columns[23] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("msgId"))
    {
      paramContentValues.getAsLong("msgId").longValue();
      throw null;
    }
    if (paramContentValues.containsKey("msgSvrId"))
    {
      paramContentValues.getAsLong("msgSvrId").longValue();
      throw null;
    }
    if (paramContentValues.containsKey("type"))
    {
      paramContentValues.getAsInteger("type").intValue();
      throw null;
    }
    if (paramContentValues.containsKey("status"))
    {
      paramContentValues.getAsInteger("status").intValue();
      throw null;
    }
    if (paramContentValues.containsKey("isSend"))
    {
      paramContentValues.getAsInteger("isSend").intValue();
      throw null;
    }
    if (paramContentValues.containsKey("isShowTimer"))
    {
      paramContentValues.getAsInteger("isShowTimer").intValue();
      throw null;
    }
    if (paramContentValues.containsKey("createTime"))
    {
      paramContentValues.getAsLong("createTime").longValue();
      throw null;
    }
    if (paramContentValues.containsKey("talker"))
    {
      paramContentValues.getAsString("talker");
      throw null;
    }
    if (paramContentValues.containsKey("content"))
    {
      paramContentValues.getAsString("content");
      throw null;
    }
    if (paramContentValues.containsKey("imgPath"))
    {
      paramContentValues.getAsString("imgPath");
      throw null;
    }
    if (paramContentValues.containsKey("reserved"))
    {
      paramContentValues.getAsString("reserved");
      throw null;
    }
    if (paramContentValues.containsKey("lvbuffer"))
    {
      paramContentValues.getAsByteArray("lvbuffer");
      throw null;
    }
    if (paramContentValues.containsKey("talkerId"))
    {
      paramContentValues.getAsInteger("talkerId").intValue();
      throw null;
    }
    if (paramContentValues.containsKey("transContent"))
    {
      paramContentValues.getAsString("transContent");
      throw null;
    }
    if (paramContentValues.containsKey("transBrandWording"))
    {
      paramContentValues.getAsString("transBrandWording");
      throw null;
    }
    if (paramContentValues.containsKey("bizClientMsgId"))
    {
      paramContentValues.getAsString("bizClientMsgId");
      throw null;
    }
    if (paramContentValues.containsKey("bizChatId"))
    {
      paramContentValues.getAsLong("bizChatId").longValue();
      throw null;
    }
    if (paramContentValues.containsKey("bizChatUserId"))
    {
      paramContentValues.getAsString("bizChatUserId");
      throw null;
    }
    if (paramContentValues.containsKey("msgSeq"))
    {
      paramContentValues.getAsLong("msgSeq").longValue();
      throw null;
    }
    if (paramContentValues.containsKey("flag"))
    {
      paramContentValues.getAsInteger("flag").intValue();
      throw null;
    }
    if (paramContentValues.containsKey("fromUsername"))
    {
      paramContentValues.getAsString("fromUsername");
      throw null;
    }
    if (paramContentValues.containsKey("toUsername"))
    {
      paramContentValues.getAsString("toUsername");
      throw null;
    }
    if (paramContentValues.containsKey("extInfo"))
    {
      paramContentValues.getAsByteArray("extInfo");
      throw null;
    }
    if (paramContentValues.containsKey("rowid")) {
      this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
    }
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {}
    for (;;)
    {
      return;
      int i = 0;
      int j = arrayOfString.length;
      while (i < j)
      {
        int k = arrayOfString[i].hashCode();
        if (jIw == k)
        {
          paramCursor.getLong(i);
          throw null;
        }
        if (jUc == k)
        {
          paramCursor.getLong(i);
          throw null;
        }
        if (type_HASHCODE == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (jIF == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (jQu == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (jUC == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (createTime_HASHCODE == k)
        {
          paramCursor.getLong(i);
          throw null;
        }
        if (jUd == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (content_HASHCODE == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (jUe == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (jUD == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (jUf == k)
        {
          paramCursor.getBlob(i);
          throw null;
        }
        if (jUg == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (jUE == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (jUF == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (jUn == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (jQj == k)
        {
          paramCursor.getLong(i);
          throw null;
        }
        if (jUG == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (jUH == k)
        {
          paramCursor.getLong(i);
          throw null;
        }
        if (jOZ == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (jUI == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (jUJ == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (jSZ == k)
        {
          paramCursor.getBlob(i);
          throw null;
        }
        if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
        i += 1;
      }
    }
  }
  
  public ContentValues convertTo()
  {
    new ContentValues();
    throw null;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends aq> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    throw null;
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
 * Qualified Name:     com.tencent.mm.autogen.b.aq
 * JD-Core Version:    0.7.0.1
 */