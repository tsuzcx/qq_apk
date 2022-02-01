package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ao
  extends IAutoDBItem
{
  public static final Column C_CONTENT;
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("BypMsgInfo");
  private static final int content_HASHCODE;
  private static final int createTime_HASHCODE;
  private static final int hmC;
  public static final Column hml;
  private static final int hmt;
  public static final Column hmw;
  public static final Column hsS;
  public static final Column hsi;
  private static final int hsm;
  private static final int htH;
  public static final Column htd;
  private static final int htw;
  public static final Column hvK;
  public static final Column hwH;
  public static final Column hwI;
  public static final Column hwJ;
  public static final Column hwK;
  public static final Column hwL;
  public static final Column hwS;
  private static final int hwm = "extInfo".hashCode();
  public static final Column hxB;
  public static final Column hxC;
  public static final Column hxD;
  public static final Column hxE;
  public static final Column hxF;
  public static final Column hxG;
  public static final Column hxH;
  public static final Column hxI;
  private static final int hxJ;
  private static final int hxK;
  private static final int hxL;
  private static final int hxM;
  private static final int hxN;
  private static final int hxO;
  private static final int hxP;
  private static final int hxQ;
  private static final int hxj;
  private static final int hxk;
  private static final int hxl;
  private static final int hxm;
  private static final int hxn;
  private static final int hxu;
  private static final int rowid_HASHCODE = "rowid".hashCode();
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
    C_ROWID = new Column("rowid", "long", "BypMsgInfo", "");
    hml = new Column("msgid", "long", "BypMsgInfo", "");
    hwH = new Column("msgsvrid", "long", "BypMsgInfo", "");
    C_TYPE = new Column("type", "int", "BypMsgInfo", "");
    hmw = new Column("status", "int", "BypMsgInfo", "");
    htd = new Column("issend", "int", "BypMsgInfo", "");
    hxB = new Column("isshowtimer", "int", "BypMsgInfo", "");
    C_CREATETIME = new Column("createtime", "long", "BypMsgInfo", "");
    hwI = new Column("talker", "string", "BypMsgInfo", "");
    C_CONTENT = new Column("content", "string", "BypMsgInfo", "");
    hwJ = new Column("imgpath", "string", "BypMsgInfo", "");
    hxC = new Column("reserved", "string", "BypMsgInfo", "");
    hwK = new Column("lvbuffer", "byte[]", "BypMsgInfo", "");
    hwL = new Column("talkerid", "int", "BypMsgInfo", "");
    hxD = new Column("transcontent", "string", "BypMsgInfo", "");
    hxE = new Column("transbrandwording", "string", "BypMsgInfo", "");
    hwS = new Column("bizclientmsgid", "string", "BypMsgInfo", "");
    hsS = new Column("bizchatid", "long", "BypMsgInfo", "");
    hxF = new Column("bizchatuserid", "string", "BypMsgInfo", "");
    hxG = new Column("msgseq", "long", "BypMsgInfo", "");
    hsi = new Column("flag", "int", "BypMsgInfo", "");
    hxH = new Column("fromusername", "string", "BypMsgInfo", "");
    hxI = new Column("tousername", "string", "BypMsgInfo", "");
    hvK = new Column("extinfo", "byte[]", "BypMsgInfo", "");
    hmt = "msgId".hashCode();
    hxj = "msgSvrId".hashCode();
    type_HASHCODE = "type".hashCode();
    hmC = "status".hashCode();
    htH = "isSend".hashCode();
    hxJ = "isShowTimer".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    hxk = "talker".hashCode();
    content_HASHCODE = "content".hashCode();
    hxl = "imgPath".hashCode();
    hxK = "reserved".hashCode();
    hxm = "lvbuffer".hashCode();
    hxn = "talkerId".hashCode();
    hxL = "transContent".hashCode();
    hxM = "transBrandWording".hashCode();
    hxu = "bizClientMsgId".hashCode();
    htw = "bizChatId".hashCode();
    hxN = "bizChatUserId".hashCode();
    hxO = "msgSeq".hashCode();
    hsm = "flag".hashCode();
    hxP = "fromUsername".hashCode();
    hxQ = "toUsername".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
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
    return localMAutoDBInfo;
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
        if (hmt == k)
        {
          paramCursor.getLong(i);
          throw null;
        }
        if (hxj == k)
        {
          paramCursor.getLong(i);
          throw null;
        }
        if (type_HASHCODE == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (hmC == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (htH == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (hxJ == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (createTime_HASHCODE == k)
        {
          paramCursor.getLong(i);
          throw null;
        }
        if (hxk == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (content_HASHCODE == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (hxl == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (hxK == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (hxm == k)
        {
          paramCursor.getBlob(i);
          throw null;
        }
        if (hxn == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (hxL == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (hxM == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (hxu == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (htw == k)
        {
          paramCursor.getLong(i);
          throw null;
        }
        if (hxN == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (hxO == k)
        {
          paramCursor.getLong(i);
          throw null;
        }
        if (hsm == k)
        {
          paramCursor.getInt(i);
          throw null;
        }
        if (hxP == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (hxQ == k)
        {
          paramCursor.getString(i);
          throw null;
        }
        if (hwm == k)
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
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "BypMsgInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.ao
 * JD-Core Version:    0.7.0.1
 */