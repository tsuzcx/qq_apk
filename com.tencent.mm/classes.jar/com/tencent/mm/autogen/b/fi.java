package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.djs;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class fi
  extends IAutoDBItem
{
  public static final Column CONTENT;
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("message");
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
  public static final Column kKT;
  public static final Column kKU;
  private static final int kLe;
  private static final int kLf;
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private boolean __hadSetcontent = false;
  private boolean __hadSetcreateTime = false;
  private boolean __hadSettype = false;
  public long field_bizChatId;
  public String field_bizChatUserId;
  public String field_bizClientMsgId;
  public String field_content;
  private long field_createTime;
  public int field_flag;
  private String field_fromUsername;
  public String field_historyId;
  public String field_imgPath;
  public int field_isSend;
  private int field_isShowTimer;
  private byte[] field_lvbuffer;
  public long field_msgId;
  public long field_msgSeq;
  public long field_msgSvrId;
  public String field_reserved;
  public djs field_solitaireFoldInfo;
  public int field_status;
  public String field_talker;
  public int field_talkerId;
  private String field_toUsername;
  public String field_transBrandWording;
  public String field_transContent;
  private int field_type;
  public int fileStatus;
  public String iah;
  private boolean jIC = false;
  private boolean jIs = false;
  private boolean jOX = false;
  private boolean jPU = false;
  private boolean jQf = false;
  private boolean jTO = false;
  private boolean jTP = false;
  private boolean jTQ = false;
  public boolean jTR = false;
  public boolean jTS = false;
  private boolean jTZ = false;
  public int jUq;
  public String jUr;
  private boolean kAk = false;
  private boolean kKV = false;
  private boolean kKW = false;
  private boolean kKX = false;
  public boolean kKY = false;
  public boolean kKZ = false;
  public boolean kLa = false;
  private boolean kLb = false;
  private boolean kLc = false;
  private boolean kLd = false;
  public String kLg;
  public int kLh;
  public int kLi;
  public int kLj;
  public int kLk;
  public int kLl;
  public int kLm;
  public String kLn;
  public String kLo;
  public String kLp;
  public int kLq;
  public byte[] kLr;
  public String kLs;
  public String kLt;
  public int kLu;
  public int kLv;
  public int kLw;
  public int kLx;
  public String kLy;
  
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
    kKT = new Column("solitaireFoldInfo", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.LocalSolitaireFoldInfo");
    jUA = new Column("fromUsername", "string", TABLE.getName(), "");
    jUB = new Column("toUsername", "string", TABLE.getName(), "");
    kKU = new Column("historyId", "string", TABLE.getName(), "");
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
    kLe = "solitaireFoldInfo".hashCode();
    jUI = "fromUsername".hashCode();
    jUJ = "toUsername".hashCode();
    kLf = "historyId".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[24];
    localMAutoDBInfo.columns = new String[25];
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
    localMAutoDBInfo.columns[20] = "solitaireFoldInfo";
    localMAutoDBInfo.colsMap.put("solitaireFoldInfo", "BLOB");
    localStringBuilder.append(" solitaireFoldInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "fromUsername";
    localMAutoDBInfo.colsMap.put("fromUsername", "TEXT");
    localStringBuilder.append(" fromUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "toUsername";
    localMAutoDBInfo.colsMap.put("toUsername", "TEXT");
    localStringBuilder.append(" toUsername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "historyId";
    localMAutoDBInfo.colsMap.put("historyId", "TEXT");
    localStringBuilder.append(" historyId TEXT");
    localMAutoDBInfo.columns[24] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void AU(String paramString)
  {
    this.jUr = paramString;
    this.jTR = true;
  }
  
  public final void BS(String paramString)
  {
    this.field_talker = paramString;
    this.jTP = true;
  }
  
  public final void BT(String paramString)
  {
    this.field_imgPath = paramString;
    this.jTQ = true;
  }
  
  public final void BU(String paramString)
  {
    this.field_reserved = paramString;
    this.kKW = true;
  }
  
  public final void BV(String paramString)
  {
    this.field_transContent = paramString;
    this.kKX = true;
  }
  
  public final void BW(String paramString)
  {
    this.field_bizClientMsgId = paramString;
    this.jTZ = true;
  }
  
  public final void BX(String paramString)
  {
    this.field_fromUsername = paramString;
    this.kLb = true;
  }
  
  public final void BY(String paramString)
  {
    this.field_toUsername = paramString;
    this.kLc = true;
  }
  
  public final void BZ(String paramString)
  {
    this.field_historyId = paramString;
    this.kLd = true;
  }
  
  public final void Ca(String paramString)
  {
    this.kLg = paramString;
    this.jTR = true;
  }
  
  public final void Cb(String paramString)
  {
    this.kLo = paramString;
    this.jTR = true;
  }
  
  public final void Cc(String paramString)
  {
    this.kLp = paramString;
    this.jTR = true;
  }
  
  public final void Cd(String paramString)
  {
    this.kLs = paramString;
    this.jTR = true;
  }
  
  public final void Ce(String paramString)
  {
    this.kLt = paramString;
    this.jTR = true;
  }
  
  public final void Cf(String paramString)
  {
    this.kLy = paramString;
    this.jTR = true;
  }
  
  public final long aJG()
  {
    return this.field_msgId;
  }
  
  public final long aJH()
  {
    return this.field_msgSvrId;
  }
  
  public final int aJI()
  {
    return this.field_isSend;
  }
  
  public final int aJJ()
  {
    return this.field_isShowTimer;
  }
  
  public final String aJK()
  {
    return this.field_talker;
  }
  
  public final String aJL()
  {
    return this.field_imgPath;
  }
  
  public final String aJM()
  {
    return this.field_reserved;
  }
  
  public final byte[] aJN()
  {
    return this.field_lvbuffer;
  }
  
  public String aJO()
  {
    return this.field_fromUsername;
  }
  
  public String aJP()
  {
    return this.field_toUsername;
  }
  
  public final String aJQ()
  {
    return this.kLt;
  }
  
  public final void aJR()
  {
    this.kLw = 1;
    this.jTR = true;
  }
  
  public final void ah(byte[] paramArrayOfByte)
  {
    this.field_lvbuffer = paramArrayOfByte;
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
    if (paramContentValues.containsKey("isSend"))
    {
      this.field_isSend = paramContentValues.getAsInteger("isSend").intValue();
      if (paramBoolean) {
        this.jQf = true;
      }
    }
    if (paramContentValues.containsKey("isShowTimer"))
    {
      this.field_isShowTimer = paramContentValues.getAsInteger("isShowTimer").intValue();
      if (paramBoolean) {
        this.kKV = true;
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
    if (paramContentValues.containsKey("reserved"))
    {
      this.field_reserved = paramContentValues.getAsString("reserved");
      if (paramBoolean) {
        this.kKW = true;
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
    if (paramContentValues.containsKey("transContent"))
    {
      this.field_transContent = paramContentValues.getAsString("transContent");
      if (paramBoolean) {
        this.kKX = true;
      }
    }
    if (paramContentValues.containsKey("transBrandWording"))
    {
      this.field_transBrandWording = paramContentValues.getAsString("transBrandWording");
      if (paramBoolean) {
        this.kKY = true;
      }
    }
    if (paramContentValues.containsKey("bizClientMsgId"))
    {
      this.field_bizClientMsgId = paramContentValues.getAsString("bizClientMsgId");
      if (paramBoolean) {
        this.jTZ = true;
      }
    }
    if (paramContentValues.containsKey("bizChatId"))
    {
      this.field_bizChatId = paramContentValues.getAsLong("bizChatId").longValue();
      if (paramBoolean) {
        this.jPU = true;
      }
    }
    if (paramContentValues.containsKey("bizChatUserId"))
    {
      this.field_bizChatUserId = paramContentValues.getAsString("bizChatUserId");
      if (paramBoolean) {
        this.kKZ = true;
      }
    }
    if (paramContentValues.containsKey("msgSeq"))
    {
      this.field_msgSeq = paramContentValues.getAsLong("msgSeq").longValue();
      if (paramBoolean) {
        this.kAk = true;
      }
    }
    if (paramContentValues.containsKey("flag"))
    {
      this.field_flag = paramContentValues.getAsInteger("flag").intValue();
      if (paramBoolean) {
        this.jOX = true;
      }
    }
    if (paramContentValues.containsKey("solitaireFoldInfo")) {}
    try
    {
      byte[] arrayOfByte = paramContentValues.getAsByteArray("solitaireFoldInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_solitaireFoldInfo = ((djs)new djs().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kLa = true;
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseMsgInfo", localIOException.getMessage());
      }
    }
    if (paramContentValues.containsKey("fromUsername"))
    {
      this.field_fromUsername = paramContentValues.getAsString("fromUsername");
      if (paramBoolean) {
        this.kLb = true;
      }
    }
    if (paramContentValues.containsKey("toUsername"))
    {
      this.field_toUsername = paramContentValues.getAsString("toUsername");
      if (paramBoolean) {
        this.kLc = true;
      }
    }
    if (paramContentValues.containsKey("historyId"))
    {
      this.field_historyId = paramContentValues.getAsString("historyId");
      if (paramBoolean) {
        this.kLd = true;
      }
    }
    if (paramContentValues.containsKey("rowid")) {
      this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
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
            if (jUc == k) {
              this.field_msgSvrId = paramCursor.getLong(i);
            } else if (type_HASHCODE == k) {
              this.field_type = paramCursor.getInt(i);
            } else if (jIF == k) {
              this.field_status = paramCursor.getInt(i);
            } else if (jQu == k) {
              this.field_isSend = paramCursor.getInt(i);
            } else if (jUC == k) {
              this.field_isShowTimer = paramCursor.getInt(i);
            } else if (createTime_HASHCODE == k) {
              this.field_createTime = paramCursor.getLong(i);
            } else if (jUd == k) {
              this.field_talker = paramCursor.getString(i);
            } else if (content_HASHCODE == k) {
              this.field_content = paramCursor.getString(i);
            } else if (jUe == k) {
              this.field_imgPath = paramCursor.getString(i);
            } else if (jUD == k) {
              this.field_reserved = paramCursor.getString(i);
            } else if (jUf == k) {
              this.field_lvbuffer = paramCursor.getBlob(i);
            } else if (jUg == k) {
              this.field_talkerId = paramCursor.getInt(i);
            } else if (jUE == k) {
              this.field_transContent = paramCursor.getString(i);
            } else if (jUF == k) {
              this.field_transBrandWording = paramCursor.getString(i);
            } else if (jUn == k) {
              this.field_bizClientMsgId = paramCursor.getString(i);
            } else if (jQj == k) {
              this.field_bizChatId = paramCursor.getLong(i);
            } else if (jUG == k) {
              this.field_bizChatUserId = paramCursor.getString(i);
            } else if (jUH == k) {
              this.field_msgSeq = paramCursor.getLong(i);
            } else if (jOZ == k) {
              this.field_flag = paramCursor.getInt(i);
            } else if (kLe == k) {
              try
              {
                byte[] arrayOfByte = paramCursor.getBlob(i);
                if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
                  continue;
                }
                this.field_solitaireFoldInfo = ((djs)new djs().parseFrom(arrayOfByte));
              }
              catch (IOException localIOException)
              {
                Log.e("MicroMsg.SDK.BaseMsgInfo", localIOException.getMessage());
              }
            } else if (jUI == k) {
              this.field_fromUsername = paramCursor.getString(i);
            } else if (jUJ == k) {
              this.field_toUsername = paramCursor.getString(i);
            } else if (kLf == k) {
              this.field_historyId = paramCursor.getString(i);
            } else if (rowid_HASHCODE == k) {
              this.systemRowid = paramCursor.getLong(i);
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
              Log.e("MicroMsg.SDK.BaseMsgInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          Log.e("MicroMsg.SDK.BaseMsgInfo", "get value failed");
          return;
        }
      }
      if (!paramCursor.checkGetFinish()) {
        this.kLg = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.jUq = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.jUr = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kLh = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kLi = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kLj = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kLk = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kLl = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kLm = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kLn = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kLo = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kLp = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kLq = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.iah = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kLr = paramCursor.getBuffer();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kLs = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kLt = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kLu = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kLv = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kLw = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fileStatus = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.kLx = paramCursor.getInt();
      }
    } while (paramCursor.checkGetFinish());
    this.kLy = paramCursor.getString();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.jTR)
      {
        localObject = new LVBuffer();
        ((LVBuffer)localObject).initBuild();
        ((LVBuffer)localObject).putString(this.kLg);
        ((LVBuffer)localObject).putInt(this.jUq);
        ((LVBuffer)localObject).putString(this.jUr);
        ((LVBuffer)localObject).putInt(this.kLh);
        ((LVBuffer)localObject).putInt(this.kLi);
        ((LVBuffer)localObject).putInt(this.kLj);
        ((LVBuffer)localObject).putInt(this.kLk);
        ((LVBuffer)localObject).putInt(this.kLl);
        ((LVBuffer)localObject).putInt(this.kLm);
        ((LVBuffer)localObject).putString(this.kLn);
        ((LVBuffer)localObject).putString(this.kLo);
        ((LVBuffer)localObject).putString(this.kLp);
        ((LVBuffer)localObject).putInt(this.kLq);
        ((LVBuffer)localObject).putString(this.iah);
        ((LVBuffer)localObject).putBuffer(this.kLr);
        ((LVBuffer)localObject).putString(this.kLs);
        ((LVBuffer)localObject).putString(this.kLt);
        ((LVBuffer)localObject).putInt(this.kLu);
        ((LVBuffer)localObject).putInt(this.kLv);
        ((LVBuffer)localObject).putInt(this.kLw);
        ((LVBuffer)localObject).putInt(this.fileStatus);
        ((LVBuffer)localObject).putInt(this.kLx);
        ((LVBuffer)localObject).putString(this.kLy);
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
      if (this.jQf) {
        ((ContentValues)localObject).put("isSend", Integer.valueOf(this.field_isSend));
      }
      if (this.kKV) {
        ((ContentValues)localObject).put("isShowTimer", Integer.valueOf(this.field_isShowTimer));
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
      if (this.kKW) {
        ((ContentValues)localObject).put("reserved", this.field_reserved);
      }
      if (this.jTR) {
        ((ContentValues)localObject).put("lvbuffer", this.field_lvbuffer);
      }
      if (this.jTS) {
        ((ContentValues)localObject).put("talkerId", Integer.valueOf(this.field_talkerId));
      }
      if (this.field_transContent == null) {
        this.field_transContent = "";
      }
      if (this.kKX) {
        ((ContentValues)localObject).put("transContent", this.field_transContent);
      }
      if (this.field_transBrandWording == null) {
        this.field_transBrandWording = "";
      }
      if (this.kKY) {
        ((ContentValues)localObject).put("transBrandWording", this.field_transBrandWording);
      }
      if (this.field_bizClientMsgId == null) {
        this.field_bizClientMsgId = "";
      }
      if (this.jTZ) {
        ((ContentValues)localObject).put("bizClientMsgId", this.field_bizClientMsgId);
      }
      if (this.jPU) {
        ((ContentValues)localObject).put("bizChatId", Long.valueOf(this.field_bizChatId));
      }
      if (this.field_bizChatUserId == null) {
        this.field_bizChatUserId = "";
      }
      if (this.kKZ) {
        ((ContentValues)localObject).put("bizChatUserId", this.field_bizChatUserId);
      }
      if (this.kAk) {
        ((ContentValues)localObject).put("msgSeq", Long.valueOf(this.field_msgSeq));
      }
      if (this.jOX) {
        ((ContentValues)localObject).put("flag", Integer.valueOf(this.field_flag));
      }
      if ((!this.kLa) || (this.field_solitaireFoldInfo == null)) {}
    }
    catch (Exception localException)
    {
      try
      {
        Object localObject;
        ((ContentValues)localObject).put("solitaireFoldInfo", this.field_solitaireFoldInfo.toByteArray());
        if (this.kLb) {
          ((ContentValues)localObject).put("fromUsername", this.field_fromUsername);
        }
        if (this.kLc) {
          ((ContentValues)localObject).put("toUsername", this.field_toUsername);
        }
        if (this.kLd) {
          ((ContentValues)localObject).put("historyId", this.field_historyId);
        }
        if (this.systemRowid > 0L) {
          ((ContentValues)localObject).put("rowid", Long.valueOf(this.systemRowid));
        }
        return localObject;
        localException = localException;
        Log.e("MicroMsg.SDK.BaseMsgInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("MicroMsg.SDK.BaseMsgInfo", localIOException.getMessage());
        }
      }
    }
  }
  
  public final void gX(long paramLong)
  {
    this.field_msgSvrId = paramLong;
    this.jTO = true;
  }
  
  public final void gY(long paramLong)
  {
    this.field_bizChatId = paramLong;
    this.jPU = true;
  }
  
  public final void gZ(long paramLong)
  {
    this.field_msgSeq = paramLong;
    this.kAk = true;
  }
  
  public final String getContent()
  {
    return this.field_content;
  }
  
  public long getCreateTime()
  {
    return this.field_createTime;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_msgId);
  }
  
  public final int getStatus()
  {
    return this.field_status;
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
  
  public int getType()
  {
    return this.field_type;
  }
  
  public final void pI(int paramInt)
  {
    this.field_isSend = paramInt;
    this.jQf = true;
  }
  
  public final void pV(int paramInt)
  {
    this.field_isShowTimer = paramInt;
    this.kKV = true;
  }
  
  public final void pW(int paramInt)
  {
    this.kLh = paramInt;
    this.jTR = true;
  }
  
  public final void pX(int paramInt)
  {
    this.kLi = paramInt;
    this.jTR = true;
  }
  
  public final void pY(int paramInt)
  {
    this.kLl = paramInt;
    this.jTR = true;
  }
  
  public final void pZ(int paramInt)
  {
    this.kLm = paramInt;
    this.jTR = true;
  }
  
  public final void po(int paramInt)
  {
    this.jUq = paramInt;
    this.jTR = true;
  }
  
  public final void qa(int paramInt)
  {
    this.kLq = paramInt;
    this.jTR = true;
  }
  
  public final void qb(int paramInt)
  {
    this.kLu = paramInt;
    this.jTR = true;
  }
  
  public final void setContent(String paramString)
  {
    this.field_content = paramString;
    this.__hadSetcontent = true;
  }
  
  public final void setCreateTime(long paramLong)
  {
    this.field_createTime = paramLong;
    this.__hadSetcreateTime = true;
  }
  
  public final void setFileStatus(int paramInt)
  {
    this.fileStatus = paramInt;
    this.jTR = true;
  }
  
  public final void setFlag(int paramInt)
  {
    this.field_flag = paramInt;
    this.jOX = true;
  }
  
  public final void setMsgId(long paramLong)
  {
    this.field_msgId = paramLong;
    this.jIs = true;
  }
  
  public void setStatus(int paramInt)
  {
    this.field_status = paramInt;
    this.jIC = true;
  }
  
  public final void setType(int paramInt)
  {
    this.field_type = paramInt;
    this.__hadSettype = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.b.fi
 * JD-Core Version:    0.7.0.1
 */