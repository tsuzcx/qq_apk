package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.gn;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ap
  extends IAutoDBItem
{
  public static final Column CONTENT;
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("BizTimeLineInfo");
  public static final Column TYPE;
  private static final int content_HASHCODE;
  private static final int createTime_HASHCODE;
  private static final int jIF;
  public static final Column jIo;
  private static final int jIw;
  public static final Column jIz;
  public static final Column jQF;
  private static final int jRf;
  public static final Column jTA;
  public static final Column jTB;
  public static final Column jTC;
  public static final Column jTD;
  public static final Column jTE;
  public static final Column jTF;
  public static final Column jTG;
  public static final Column jTH;
  public static final Column jTI;
  public static final Column jTJ;
  public static final Column jTK;
  public static final Column jTL;
  public static final Column jTM;
  public static final Column jTN;
  private static final int jUc;
  private static final int jUd;
  private static final int jUe;
  private static final int jUf;
  private static final int jUg;
  private static final int jUh;
  private static final int jUi;
  private static final int jUj;
  private static final int jUk;
  private static final int jUl;
  private static final int jUm;
  private static final int jUn;
  private static final int jUo;
  private static final int jUp;
  private static final StorageObserverOwner<ap> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private boolean __hadSetcontent = true;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSettype = true;
  public gn field_appMsgStatInfoProto;
  public int field_bitFlag;
  public String field_bizClientMsgId;
  public String field_content;
  public long field_createTime;
  public int field_hasShow;
  public String field_imgPath;
  public boolean field_isExpand;
  public int field_isRead;
  public byte[] field_lvbuffer;
  public long field_msgId;
  public long field_msgSvrId;
  public long field_orderFlag;
  public int field_placeTop;
  public String field_rankSessionId;
  public String field_recommendCardId;
  public int field_status;
  public String field_talker;
  public int field_talkerId;
  public int field_type;
  private boolean jIC = true;
  private boolean jIs = true;
  private boolean jQS = true;
  private boolean jTO = true;
  private boolean jTP = true;
  private boolean jTQ = true;
  private boolean jTR = true;
  private boolean jTS = true;
  private boolean jTT = true;
  private boolean jTU = true;
  private boolean jTV = true;
  private boolean jTW = true;
  private boolean jTX = true;
  private boolean jTY = true;
  private boolean jTZ = true;
  private boolean jUa = true;
  private boolean jUb = true;
  private int jUq;
  public String jUr;
  private byte[] jUs;
  public long jUt;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jIo = new Column("msgId", "long", TABLE.getName(), "");
    jTA = new Column("msgSvrId", "long", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "long", TABLE.getName(), "");
    jTB = new Column("talker", "string", TABLE.getName(), "");
    CONTENT = new Column("content", "string", TABLE.getName(), "");
    jTC = new Column("imgPath", "string", TABLE.getName(), "");
    jTD = new Column("lvbuffer", "byte[]", TABLE.getName(), "");
    jTE = new Column("talkerId", "int", TABLE.getName(), "");
    jTF = new Column("isExpand", "boolean", TABLE.getName(), "");
    jTG = new Column("orderFlag", "long", TABLE.getName(), "");
    jTH = new Column("hasShow", "int", TABLE.getName(), "");
    jTI = new Column("placeTop", "int", TABLE.getName(), "");
    jTJ = new Column("appMsgStatInfoProto", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.AppMsgStatInfo");
    jTK = new Column("isRead", "int", TABLE.getName(), "");
    jQF = new Column("bitFlag", "int", TABLE.getName(), "");
    jTL = new Column("bizClientMsgId", "string", TABLE.getName(), "");
    jTM = new Column("rankSessionId", "string", TABLE.getName(), "");
    jTN = new Column("recommendCardId", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jIw = "msgId".hashCode();
    jUc = "msgSvrId".hashCode();
    type_HASHCODE = "type".hashCode();
    jIF = "status".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    jUd = "talker".hashCode();
    content_HASHCODE = "content".hashCode();
    jUe = "imgPath".hashCode();
    jUf = "lvbuffer".hashCode();
    jUg = "talkerId".hashCode();
    jUh = "isExpand".hashCode();
    jUi = "orderFlag".hashCode();
    jUj = "hasShow".hashCode();
    jUk = "placeTop".hashCode();
    jUl = "appMsgStatInfoProto".hashCode();
    jUm = "isRead".hashCode();
    jRf = "bitFlag".hashCode();
    jUn = "bizClientMsgId".hashCode();
    jUo = "rankSessionId".hashCode();
    jUp = "recommendCardId".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[20];
    localMAutoDBInfo.columns = new String[21];
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
    localMAutoDBInfo.columns[4] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "talker";
    localMAutoDBInfo.colsMap.put("talker", "TEXT");
    localStringBuilder.append(" talker TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "imgPath";
    localMAutoDBInfo.colsMap.put("imgPath", "TEXT");
    localStringBuilder.append(" imgPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "lvbuffer";
    localMAutoDBInfo.colsMap.put("lvbuffer", "BLOB");
    localStringBuilder.append(" lvbuffer BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "talkerId";
    localMAutoDBInfo.colsMap.put("talkerId", "INTEGER");
    localStringBuilder.append(" talkerId INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "isExpand";
    localMAutoDBInfo.colsMap.put("isExpand", "INTEGER");
    localStringBuilder.append(" isExpand INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "orderFlag";
    localMAutoDBInfo.colsMap.put("orderFlag", "LONG default '0' ");
    localStringBuilder.append(" orderFlag LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "hasShow";
    localMAutoDBInfo.colsMap.put("hasShow", "INTEGER default '1' ");
    localStringBuilder.append(" hasShow INTEGER default '1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "placeTop";
    localMAutoDBInfo.colsMap.put("placeTop", "INTEGER default '1' ");
    localStringBuilder.append(" placeTop INTEGER default '1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "appMsgStatInfoProto";
    localMAutoDBInfo.colsMap.put("appMsgStatInfoProto", "BLOB");
    localStringBuilder.append(" appMsgStatInfoProto BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "isRead";
    localMAutoDBInfo.colsMap.put("isRead", "INTEGER default '0' ");
    localStringBuilder.append(" isRead INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "bitFlag";
    localMAutoDBInfo.colsMap.put("bitFlag", "INTEGER default '0' ");
    localStringBuilder.append(" bitFlag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "bizClientMsgId";
    localMAutoDBInfo.colsMap.put("bizClientMsgId", "TEXT default '' ");
    localStringBuilder.append(" bizClientMsgId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "rankSessionId";
    localMAutoDBInfo.colsMap.put("rankSessionId", "TEXT default '' ");
    localStringBuilder.append(" rankSessionId TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "recommendCardId";
    localMAutoDBInfo.colsMap.put("recommendCardId", "TEXT default '' ");
    localStringBuilder.append(" recommendCardId TEXT default '' ");
    localMAutoDBInfo.columns[20] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public final void AU(String paramString)
  {
    this.jUr = paramString;
    this.jTR = true;
  }
  
  public final byte[] aJq()
  {
    return this.jUs;
  }
  
  public final void aJr()
  {
    this.jUs = null;
    this.jTR = true;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("msgId"))
    {
      this.field_msgId = paramContentValues.getAsLong("msgId").longValue();
      if (paramBoolean) {
        this.jIs = true;
      }
    }
    if (paramContentValues.containsKey("msgSvrId"))
    {
      this.field_msgSvrId = paramContentValues.getAsLong("msgSvrId").longValue();
      if (paramBoolean) {
        this.jTO = true;
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsInteger("type").intValue();
      if (paramBoolean) {
        this.__hadSettype = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("createTime"))
    {
      this.field_createTime = paramContentValues.getAsLong("createTime").longValue();
      if (paramBoolean) {
        this.__hadSetcreateTime = true;
      }
    }
    if (paramContentValues.containsKey("talker"))
    {
      this.field_talker = paramContentValues.getAsString("talker");
      if (paramBoolean) {
        this.jTP = true;
      }
    }
    if (paramContentValues.containsKey("content"))
    {
      this.field_content = paramContentValues.getAsString("content");
      if (paramBoolean) {
        this.__hadSetcontent = true;
      }
    }
    if (paramContentValues.containsKey("imgPath"))
    {
      this.field_imgPath = paramContentValues.getAsString("imgPath");
      if (paramBoolean) {
        this.jTQ = true;
      }
    }
    if (paramContentValues.containsKey("lvbuffer"))
    {
      this.field_lvbuffer = paramContentValues.getAsByteArray("lvbuffer");
      if (paramBoolean) {
        this.jTR = true;
      }
    }
    if (paramContentValues.containsKey("talkerId"))
    {
      this.field_talkerId = paramContentValues.getAsInteger("talkerId").intValue();
      if (paramBoolean) {
        this.jTS = true;
      }
    }
    if (paramContentValues.containsKey("isExpand")) {
      if (paramContentValues.getAsInteger("isExpand").intValue() == 0) {
        break label653;
      }
    }
    label653:
    for (boolean bool = true;; bool = false)
    {
      this.field_isExpand = bool;
      if (paramBoolean) {
        this.jTT = true;
      }
      if (paramContentValues.containsKey("orderFlag"))
      {
        this.field_orderFlag = paramContentValues.getAsLong("orderFlag").longValue();
        if (paramBoolean) {
          this.jTU = true;
        }
      }
      if (paramContentValues.containsKey("hasShow"))
      {
        this.field_hasShow = paramContentValues.getAsInteger("hasShow").intValue();
        if (paramBoolean) {
          this.jTV = true;
        }
      }
      if (paramContentValues.containsKey("placeTop"))
      {
        this.field_placeTop = paramContentValues.getAsInteger("placeTop").intValue();
        if (paramBoolean) {
          this.jTW = true;
        }
      }
      if (paramContentValues.containsKey("appMsgStatInfoProto")) {}
      try
      {
        byte[] arrayOfByte = paramContentValues.getAsByteArray("appMsgStatInfoProto");
        if ((arrayOfByte != null) && (arrayOfByte.length > 0))
        {
          this.field_appMsgStatInfoProto = ((gn)new gn().parseFrom(arrayOfByte));
          if (paramBoolean) {
            this.jTX = true;
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("MicroMsg.SDK.BaseBizTimeLineInfo", localIOException.getMessage());
        }
      }
      if (paramContentValues.containsKey("isRead"))
      {
        this.field_isRead = paramContentValues.getAsInteger("isRead").intValue();
        if (paramBoolean) {
          this.jTY = true;
        }
      }
      if (paramContentValues.containsKey("bitFlag"))
      {
        this.field_bitFlag = paramContentValues.getAsInteger("bitFlag").intValue();
        if (paramBoolean) {
          this.jQS = true;
        }
      }
      if (paramContentValues.containsKey("bizClientMsgId"))
      {
        this.field_bizClientMsgId = paramContentValues.getAsString("bizClientMsgId");
        if (paramBoolean) {
          this.jTZ = true;
        }
      }
      if (paramContentValues.containsKey("rankSessionId"))
      {
        this.field_rankSessionId = paramContentValues.getAsString("rankSessionId");
        if (paramBoolean) {
          this.jUa = true;
        }
      }
      if (paramContentValues.containsKey("recommendCardId"))
      {
        this.field_recommendCardId = paramContentValues.getAsString("recommendCardId");
        if (paramBoolean) {
          this.jUb = true;
        }
      }
      if (paramContentValues.containsKey("rowid")) {
        this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
      }
      return;
    }
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {}
    do
    {
      for (;;)
      {
        return;
        int j = arrayOfString.length;
        int i = 0;
        if (i < j)
        {
          int k = arrayOfString[i].hashCode();
          if (jIw == k)
          {
            this.field_msgId = paramCursor.getLong(i);
            this.jIs = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (jUc == k)
            {
              this.field_msgSvrId = paramCursor.getLong(i);
            }
            else if (type_HASHCODE == k)
            {
              this.field_type = paramCursor.getInt(i);
            }
            else if (jIF == k)
            {
              this.field_status = paramCursor.getInt(i);
            }
            else if (createTime_HASHCODE == k)
            {
              this.field_createTime = paramCursor.getLong(i);
            }
            else if (jUd == k)
            {
              this.field_talker = paramCursor.getString(i);
            }
            else if (content_HASHCODE == k)
            {
              this.field_content = paramCursor.getString(i);
            }
            else if (jUe == k)
            {
              this.field_imgPath = paramCursor.getString(i);
            }
            else if (jUf == k)
            {
              this.field_lvbuffer = paramCursor.getBlob(i);
            }
            else if (jUg == k)
            {
              this.field_talkerId = paramCursor.getInt(i);
            }
            else
            {
              if (jUh == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (boolean bool = true;; bool = false)
                {
                  this.field_isExpand = bool;
                  break;
                }
              }
              if (jUi == k) {
                this.field_orderFlag = paramCursor.getLong(i);
              } else if (jUj == k) {
                this.field_hasShow = paramCursor.getInt(i);
              } else if (jUk == k) {
                this.field_placeTop = paramCursor.getInt(i);
              } else if (jUl == k) {
                try
                {
                  byte[] arrayOfByte = paramCursor.getBlob(i);
                  if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
                    continue;
                  }
                  this.field_appMsgStatInfoProto = ((gn)new gn().parseFrom(arrayOfByte));
                }
                catch (IOException localIOException)
                {
                  Log.e("MicroMsg.SDK.BaseBizTimeLineInfo", localIOException.getMessage());
                }
              } else if (jUm == k) {
                this.field_isRead = paramCursor.getInt(i);
              } else if (jRf == k) {
                this.field_bitFlag = paramCursor.getInt(i);
              } else if (jUn == k) {
                this.field_bizClientMsgId = paramCursor.getString(i);
              } else if (jUo == k) {
                this.field_rankSessionId = paramCursor.getString(i);
              } else if (jUp == k) {
                this.field_recommendCardId = paramCursor.getString(i);
              } else if (rowid_HASHCODE == k) {
                this.systemRowid = paramCursor.getLong(i);
              }
            }
          }
        }
        try
        {
          if ((this.field_lvbuffer != null) && (this.field_lvbuffer.length != 0))
          {
            paramCursor = new LVBuffer();
            i = paramCursor.initParse(this.field_lvbuffer);
            if (i != 0)
            {
              Log.e("MicroMsg.SDK.BaseBizTimeLineInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          Log.e("MicroMsg.SDK.BaseBizTimeLineInfo", "get value failed");
          return;
        }
      }
      if (!paramCursor.checkGetFinish()) {
        this.jUq = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.jUr = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.jUs = paramCursor.getBuffer();
      }
    } while (paramCursor.checkGetFinish());
    this.jUt = paramCursor.getLong();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.jTR)
      {
        localObject = new LVBuffer();
        ((LVBuffer)localObject).initBuild();
        ((LVBuffer)localObject).putInt(this.jUq);
        ((LVBuffer)localObject).putString(this.jUr);
        ((LVBuffer)localObject).putBuffer(this.jUs);
        ((LVBuffer)localObject).putLong(this.jUt);
        this.field_lvbuffer = ((LVBuffer)localObject).buildFinish();
      }
      localObject = new ContentValues();
      if (this.jIs) {
        ((ContentValues)localObject).put("msgId", Long.valueOf(this.field_msgId));
      }
      if (this.jTO) {
        ((ContentValues)localObject).put("msgSvrId", Long.valueOf(this.field_msgSvrId));
      }
      if (this.__hadSettype) {
        ((ContentValues)localObject).put("type", Integer.valueOf(this.field_type));
      }
      if (this.jIC) {
        ((ContentValues)localObject).put("status", Integer.valueOf(this.field_status));
      }
      if (this.__hadSetcreateTime) {
        ((ContentValues)localObject).put("createTime", Long.valueOf(this.field_createTime));
      }
      if (this.jTP) {
        ((ContentValues)localObject).put("talker", this.field_talker);
      }
      if (this.field_content == null) {
        this.field_content = "";
      }
      if (this.__hadSetcontent) {
        ((ContentValues)localObject).put("content", this.field_content);
      }
      if (this.jTQ) {
        ((ContentValues)localObject).put("imgPath", this.field_imgPath);
      }
      if (this.jTR) {
        ((ContentValues)localObject).put("lvbuffer", this.field_lvbuffer);
      }
      if (this.jTS) {
        ((ContentValues)localObject).put("talkerId", Integer.valueOf(this.field_talkerId));
      }
      if (this.jTT) {
        ((ContentValues)localObject).put("isExpand", Boolean.valueOf(this.field_isExpand));
      }
      if (this.jTU) {
        ((ContentValues)localObject).put("orderFlag", Long.valueOf(this.field_orderFlag));
      }
      if (this.jTV) {
        ((ContentValues)localObject).put("hasShow", Integer.valueOf(this.field_hasShow));
      }
      if (this.jTW) {
        ((ContentValues)localObject).put("placeTop", Integer.valueOf(this.field_placeTop));
      }
      if ((!this.jTX) || (this.field_appMsgStatInfoProto == null)) {}
    }
    catch (Exception localException)
    {
      try
      {
        Object localObject;
        ((ContentValues)localObject).put("appMsgStatInfoProto", this.field_appMsgStatInfoProto.toByteArray());
        if (this.jTY) {
          ((ContentValues)localObject).put("isRead", Integer.valueOf(this.field_isRead));
        }
        if (this.jQS) {
          ((ContentValues)localObject).put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.field_bizClientMsgId == null) {
          this.field_bizClientMsgId = "";
        }
        if (this.jTZ) {
          ((ContentValues)localObject).put("bizClientMsgId", this.field_bizClientMsgId);
        }
        if (this.field_rankSessionId == null) {
          this.field_rankSessionId = "";
        }
        if (this.jUa) {
          ((ContentValues)localObject).put("rankSessionId", this.field_rankSessionId);
        }
        if (this.field_recommendCardId == null) {
          this.field_recommendCardId = "";
        }
        if (this.jUb) {
          ((ContentValues)localObject).put("recommendCardId", this.field_recommendCardId);
        }
        if (this.systemRowid > 0L) {
          ((ContentValues)localObject).put("rowid", Long.valueOf(this.systemRowid));
        }
        return localObject;
        localException = localException;
        Log.e("MicroMsg.SDK.BaseBizTimeLineInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("MicroMsg.SDK.BaseBizTimeLineInfo", localIOException.getMessage());
        }
      }
    }
  }
  
  public final void gM(long paramLong)
  {
    this.jUt = paramLong;
    this.jTR = true;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends ap> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_msgId);
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
  
  public final void po(int paramInt)
  {
    this.jUq = paramInt;
    this.jTR = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.b.ap
 * JD-Core Version:    0.7.0.1
 */