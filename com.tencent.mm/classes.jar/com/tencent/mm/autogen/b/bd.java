package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bd
  extends IAutoDBItem
{
  public static final Column CONTENT;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("rconversation");
  public static final Column USERNAME;
  private static final int content_HASHCODE;
  private static final int jIF;
  public static final Column jIz;
  public static final Column jOV;
  private static final int jOZ;
  public static final Column jPH;
  public static final Column jPL;
  public static final Column jPM;
  public static final Column jPN;
  public static final Column jPO;
  public static final Column jPQ;
  public static final Column jPR;
  public static final Column jPS;
  private static final int jQl;
  private static final int jQp;
  private static final int jQq;
  private static final int jQr;
  private static final int jQs;
  private static final int jQu;
  private static final int jQv;
  private static final int jQw;
  public static final Column kaU;
  public static final Column kaV;
  public static final Column kaW;
  public static final Column kaX;
  public static final Column kaY;
  public static final Column kaZ;
  private static final int kbE;
  private static final int kbF;
  private static final int kbG;
  private static final int kbH;
  private static final int kbI;
  private static final int kbJ;
  private static final int kbK;
  private static final int kbL;
  private static final int kbM;
  private static final int kbN;
  private static final int kbO;
  private static final int kbP;
  private static final int kbQ;
  private static final int kbR;
  private static final int kbS;
  private static final int kbT;
  private static final int kbU;
  private static final int kbV;
  public static final Column kba;
  public static final Column kbb;
  public static final Column kbc;
  public static final Column kbd;
  public static final Column kbe;
  public static final Column kbf;
  public static final Column kbg;
  public static final Column kbh;
  public static final Column kbi;
  public static final Column kbj;
  public static final Column kbk;
  public static final Column kbl;
  private static final int rowid_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetcontent = false;
  private boolean __hadSetusername = false;
  public int field_UnDeliverCount;
  public int field_UnReadInvite;
  public int field_atCount;
  public int field_attrflag;
  public int field_chatmode;
  public String field_content;
  public long field_conversationTime;
  private String field_customNotify;
  public String field_digest;
  public String field_digestUser;
  public String field_editingMsg;
  public long field_editingQuoteMsgId;
  public long field_firstUnDeliverSeq;
  public long field_flag;
  public int field_hasSpecialFollow;
  public int field_hasTodo;
  private int field_hasTrunc;
  public int field_hbMarkRed;
  public int field_isSend;
  public long field_lastSeq;
  public int field_msgCount;
  public String field_msgType;
  public String field_parentRef;
  public int field_remitMarkRed;
  public int field_showTips;
  public long field_sightTime;
  public int field_status;
  public int field_unReadCount;
  public int field_unReadMuteCount;
  public String field_username;
  private boolean jIC = false;
  private boolean jOX = false;
  private boolean jPW = false;
  private boolean jQa = false;
  private boolean jQb = false;
  private boolean jQc = false;
  private boolean jQd = false;
  private boolean jQf = false;
  private boolean jQg = false;
  private boolean jQh = false;
  private boolean kbA = false;
  private boolean kbB = false;
  private boolean kbC = false;
  private boolean kbD = false;
  private boolean kbm = false;
  private boolean kbn = false;
  private boolean kbo = false;
  private boolean kbp = false;
  private boolean kbq = false;
  private boolean kbr = false;
  private boolean kbs = false;
  public boolean kbt = false;
  private boolean kbu = false;
  private boolean kbv = false;
  private boolean kbw = false;
  private boolean kbx = false;
  private boolean kby = false;
  public boolean kbz = false;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jPS = new Column("msgCount", "int", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    jPH = new Column("unReadCount", "int", TABLE.getName(), "");
    kaU = new Column("chatmode", "int", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    jPQ = new Column("isSend", "int", TABLE.getName(), "");
    kaV = new Column("conversationTime", "long", TABLE.getName(), "");
    CONTENT = new Column("content", "string", TABLE.getName(), "");
    jPR = new Column("msgType", "string", TABLE.getName(), "");
    kaW = new Column("customNotify", "string", TABLE.getName(), "");
    kaX = new Column("showTips", "int", TABLE.getName(), "");
    jOV = new Column("flag", "long", TABLE.getName(), "");
    jPL = new Column("digest", "string", TABLE.getName(), "");
    jPM = new Column("digestUser", "string", TABLE.getName(), "");
    kaY = new Column("hasTrunc", "int", TABLE.getName(), "");
    kaZ = new Column("parentRef", "string", TABLE.getName(), "");
    kba = new Column("attrflag", "int", TABLE.getName(), "");
    jPO = new Column("editingMsg", "string", TABLE.getName(), "");
    jPN = new Column("atCount", "int", TABLE.getName(), "");
    kbb = new Column("sightTime", "long", TABLE.getName(), "");
    kbc = new Column("unReadMuteCount", "int", TABLE.getName(), "");
    kbd = new Column("lastSeq", "long", TABLE.getName(), "");
    kbe = new Column("UnDeliverCount", "int", TABLE.getName(), "");
    kbf = new Column("UnReadInvite", "int", TABLE.getName(), "");
    kbg = new Column("firstUnDeliverSeq", "long", TABLE.getName(), "");
    kbh = new Column("editingQuoteMsgId", "long", TABLE.getName(), "");
    kbi = new Column("hasTodo", "int", TABLE.getName(), "");
    kbj = new Column("hbMarkRed", "int", TABLE.getName(), "");
    kbk = new Column("remitMarkRed", "int", TABLE.getName(), "");
    kbl = new Column("hasSpecialFollow", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    jQw = "msgCount".hashCode();
    username_HASHCODE = "username".hashCode();
    jQl = "unReadCount".hashCode();
    kbE = "chatmode".hashCode();
    jIF = "status".hashCode();
    jQu = "isSend".hashCode();
    kbF = "conversationTime".hashCode();
    content_HASHCODE = "content".hashCode();
    jQv = "msgType".hashCode();
    kbG = "customNotify".hashCode();
    kbH = "showTips".hashCode();
    jOZ = "flag".hashCode();
    jQp = "digest".hashCode();
    jQq = "digestUser".hashCode();
    kbI = "hasTrunc".hashCode();
    kbJ = "parentRef".hashCode();
    kbK = "attrflag".hashCode();
    jQs = "editingMsg".hashCode();
    jQr = "atCount".hashCode();
    kbL = "sightTime".hashCode();
    kbM = "unReadMuteCount".hashCode();
    kbN = "lastSeq".hashCode();
    kbO = "UnDeliverCount".hashCode();
    kbP = "UnReadInvite".hashCode();
    kbQ = "firstUnDeliverSeq".hashCode();
    kbR = "editingQuoteMsgId".hashCode();
    kbS = "hasTodo".hashCode();
    kbT = "hbMarkRed".hashCode();
    kbU = "remitMarkRed".hashCode();
    kbV = "hasSpecialFollow".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[30];
    localMAutoDBInfo.columns = new String[31];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "msgCount";
    localMAutoDBInfo.colsMap.put("msgCount", "INTEGER default '0' ");
    localStringBuilder.append(" msgCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" username TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "username";
    localMAutoDBInfo.columns[2] = "unReadCount";
    localMAutoDBInfo.colsMap.put("unReadCount", "INTEGER default '0' ");
    localStringBuilder.append(" unReadCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "chatmode";
    localMAutoDBInfo.colsMap.put("chatmode", "INTEGER default '0' ");
    localStringBuilder.append(" chatmode INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER default '0' ");
    localStringBuilder.append(" status INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "isSend";
    localMAutoDBInfo.colsMap.put("isSend", "INTEGER default '0' ");
    localStringBuilder.append(" isSend INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "conversationTime";
    localMAutoDBInfo.colsMap.put("conversationTime", "LONG default '0' ");
    localStringBuilder.append(" conversationTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "content";
    localMAutoDBInfo.colsMap.put("content", "TEXT default '' ");
    localStringBuilder.append(" content TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "msgType";
    localMAutoDBInfo.colsMap.put("msgType", "TEXT default '' ");
    localStringBuilder.append(" msgType TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "customNotify";
    localMAutoDBInfo.colsMap.put("customNotify", "TEXT default '' ");
    localStringBuilder.append(" customNotify TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "showTips";
    localMAutoDBInfo.colsMap.put("showTips", "INTEGER default '0' ");
    localStringBuilder.append(" showTips INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "flag";
    localMAutoDBInfo.colsMap.put("flag", "LONG default '0' ");
    localStringBuilder.append(" flag LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "digest";
    localMAutoDBInfo.colsMap.put("digest", "TEXT default '' ");
    localStringBuilder.append(" digest TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "digestUser";
    localMAutoDBInfo.colsMap.put("digestUser", "TEXT default '' ");
    localStringBuilder.append(" digestUser TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "hasTrunc";
    localMAutoDBInfo.colsMap.put("hasTrunc", "INTEGER default '0' ");
    localStringBuilder.append(" hasTrunc INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "parentRef";
    localMAutoDBInfo.colsMap.put("parentRef", "TEXT");
    localStringBuilder.append(" parentRef TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "attrflag";
    localMAutoDBInfo.colsMap.put("attrflag", "INTEGER default '0' ");
    localStringBuilder.append(" attrflag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "editingMsg";
    localMAutoDBInfo.colsMap.put("editingMsg", "TEXT default '' ");
    localStringBuilder.append(" editingMsg TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "atCount";
    localMAutoDBInfo.colsMap.put("atCount", "INTEGER default '0' ");
    localStringBuilder.append(" atCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "sightTime";
    localMAutoDBInfo.colsMap.put("sightTime", "LONG default '0' ");
    localStringBuilder.append(" sightTime LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "unReadMuteCount";
    localMAutoDBInfo.colsMap.put("unReadMuteCount", "INTEGER default '0' ");
    localStringBuilder.append(" unReadMuteCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "lastSeq";
    localMAutoDBInfo.colsMap.put("lastSeq", "LONG");
    localStringBuilder.append(" lastSeq LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "UnDeliverCount";
    localMAutoDBInfo.colsMap.put("UnDeliverCount", "INTEGER");
    localStringBuilder.append(" UnDeliverCount INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "UnReadInvite";
    localMAutoDBInfo.colsMap.put("UnReadInvite", "INTEGER");
    localStringBuilder.append(" UnReadInvite INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "firstUnDeliverSeq";
    localMAutoDBInfo.colsMap.put("firstUnDeliverSeq", "LONG");
    localStringBuilder.append(" firstUnDeliverSeq LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "editingQuoteMsgId";
    localMAutoDBInfo.colsMap.put("editingQuoteMsgId", "LONG default '0' ");
    localStringBuilder.append(" editingQuoteMsgId LONG default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "hasTodo";
    localMAutoDBInfo.colsMap.put("hasTodo", "INTEGER default '0' ");
    localStringBuilder.append(" hasTodo INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "hbMarkRed";
    localMAutoDBInfo.colsMap.put("hbMarkRed", "INTEGER default '0' ");
    localStringBuilder.append(" hbMarkRed INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "remitMarkRed";
    localMAutoDBInfo.colsMap.put("remitMarkRed", "INTEGER default '0' ");
    localStringBuilder.append(" remitMarkRed INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[29] = "hasSpecialFollow";
    localMAutoDBInfo.colsMap.put("hasSpecialFollow", "INTEGER default '0' ");
    localStringBuilder.append(" hasSpecialFollow INTEGER default '0' ");
    localMAutoDBInfo.columns[30] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public final void BE(String paramString)
  {
    this.field_msgType = paramString;
    this.jQg = true;
  }
  
  public final void BF(String paramString)
  {
    this.field_digest = paramString;
    this.jQa = true;
  }
  
  public final void BG(String paramString)
  {
    this.field_digestUser = paramString;
    this.jQb = true;
  }
  
  public final void BH(String paramString)
  {
    this.field_parentRef = paramString;
    this.kbr = true;
  }
  
  public final void BI(String paramString)
  {
    this.field_editingMsg = paramString;
    this.jQd = true;
  }
  
  public final long aJD()
  {
    return this.field_lastSeq;
  }
  
  public final int aJE()
  {
    return this.field_UnDeliverCount;
  }
  
  public final long aJF()
  {
    return this.field_firstUnDeliverSeq;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("msgCount"))
    {
      this.field_msgCount = paramContentValues.getAsInteger("msgCount").intValue();
      if (paramBoolean) {
        this.jQh = true;
      }
    }
    if (paramContentValues.containsKey("username"))
    {
      this.field_username = paramContentValues.getAsString("username");
      if (paramBoolean) {
        this.__hadSetusername = true;
      }
    }
    if (paramContentValues.containsKey("unReadCount"))
    {
      this.field_unReadCount = paramContentValues.getAsInteger("unReadCount").intValue();
      if (paramBoolean) {
        this.jPW = true;
      }
    }
    if (paramContentValues.containsKey("chatmode"))
    {
      this.field_chatmode = paramContentValues.getAsInteger("chatmode").intValue();
      if (paramBoolean) {
        this.kbm = true;
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
    if (paramContentValues.containsKey("conversationTime"))
    {
      this.field_conversationTime = paramContentValues.getAsLong("conversationTime").longValue();
      if (paramBoolean) {
        this.kbn = true;
      }
    }
    if (paramContentValues.containsKey("content"))
    {
      this.field_content = paramContentValues.getAsString("content");
      if (paramBoolean) {
        this.__hadSetcontent = true;
      }
    }
    if (paramContentValues.containsKey("msgType"))
    {
      this.field_msgType = paramContentValues.getAsString("msgType");
      if (paramBoolean) {
        this.jQg = true;
      }
    }
    if (paramContentValues.containsKey("customNotify"))
    {
      this.field_customNotify = paramContentValues.getAsString("customNotify");
      if (paramBoolean) {
        this.kbo = true;
      }
    }
    if (paramContentValues.containsKey("showTips"))
    {
      this.field_showTips = paramContentValues.getAsInteger("showTips").intValue();
      if (paramBoolean) {
        this.kbp = true;
      }
    }
    if (paramContentValues.containsKey("flag"))
    {
      this.field_flag = paramContentValues.getAsLong("flag").longValue();
      if (paramBoolean) {
        this.jOX = true;
      }
    }
    if (paramContentValues.containsKey("digest"))
    {
      this.field_digest = paramContentValues.getAsString("digest");
      if (paramBoolean) {
        this.jQa = true;
      }
    }
    if (paramContentValues.containsKey("digestUser"))
    {
      this.field_digestUser = paramContentValues.getAsString("digestUser");
      if (paramBoolean) {
        this.jQb = true;
      }
    }
    if (paramContentValues.containsKey("hasTrunc"))
    {
      this.field_hasTrunc = paramContentValues.getAsInteger("hasTrunc").intValue();
      if (paramBoolean) {
        this.kbq = true;
      }
    }
    if (paramContentValues.containsKey("parentRef"))
    {
      this.field_parentRef = paramContentValues.getAsString("parentRef");
      if (paramBoolean) {
        this.kbr = true;
      }
    }
    if (paramContentValues.containsKey("attrflag"))
    {
      this.field_attrflag = paramContentValues.getAsInteger("attrflag").intValue();
      if (paramBoolean) {
        this.kbs = true;
      }
    }
    if (paramContentValues.containsKey("editingMsg"))
    {
      this.field_editingMsg = paramContentValues.getAsString("editingMsg");
      if (paramBoolean) {
        this.jQd = true;
      }
    }
    if (paramContentValues.containsKey("atCount"))
    {
      this.field_atCount = paramContentValues.getAsInteger("atCount").intValue();
      if (paramBoolean) {
        this.jQc = true;
      }
    }
    if (paramContentValues.containsKey("sightTime"))
    {
      this.field_sightTime = paramContentValues.getAsLong("sightTime").longValue();
      if (paramBoolean) {
        this.kbt = true;
      }
    }
    if (paramContentValues.containsKey("unReadMuteCount"))
    {
      this.field_unReadMuteCount = paramContentValues.getAsInteger("unReadMuteCount").intValue();
      if (paramBoolean) {
        this.kbu = true;
      }
    }
    if (paramContentValues.containsKey("lastSeq"))
    {
      this.field_lastSeq = paramContentValues.getAsLong("lastSeq").longValue();
      if (paramBoolean) {
        this.kbv = true;
      }
    }
    if (paramContentValues.containsKey("UnDeliverCount"))
    {
      this.field_UnDeliverCount = paramContentValues.getAsInteger("UnDeliverCount").intValue();
      if (paramBoolean) {
        this.kbw = true;
      }
    }
    if (paramContentValues.containsKey("UnReadInvite"))
    {
      this.field_UnReadInvite = paramContentValues.getAsInteger("UnReadInvite").intValue();
      if (paramBoolean) {
        this.kbx = true;
      }
    }
    if (paramContentValues.containsKey("firstUnDeliverSeq"))
    {
      this.field_firstUnDeliverSeq = paramContentValues.getAsLong("firstUnDeliverSeq").longValue();
      if (paramBoolean) {
        this.kby = true;
      }
    }
    if (paramContentValues.containsKey("editingQuoteMsgId"))
    {
      this.field_editingQuoteMsgId = paramContentValues.getAsLong("editingQuoteMsgId").longValue();
      if (paramBoolean) {
        this.kbz = true;
      }
    }
    if (paramContentValues.containsKey("hasTodo"))
    {
      this.field_hasTodo = paramContentValues.getAsInteger("hasTodo").intValue();
      if (paramBoolean) {
        this.kbA = true;
      }
    }
    if (paramContentValues.containsKey("hbMarkRed"))
    {
      this.field_hbMarkRed = paramContentValues.getAsInteger("hbMarkRed").intValue();
      if (paramBoolean) {
        this.kbB = true;
      }
    }
    if (paramContentValues.containsKey("remitMarkRed"))
    {
      this.field_remitMarkRed = paramContentValues.getAsInteger("remitMarkRed").intValue();
      if (paramBoolean) {
        this.kbC = true;
      }
    }
    if (paramContentValues.containsKey("hasSpecialFollow"))
    {
      this.field_hasSpecialFollow = paramContentValues.getAsInteger("hasSpecialFollow").intValue();
      if (paramBoolean) {
        this.kbD = true;
      }
    }
    if (paramContentValues.containsKey("rowid")) {
      this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
    }
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (jQw != k) {
        break label60;
      }
      this.field_msgCount = paramCursor.getInt(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (username_HASHCODE == k)
      {
        this.field_username = paramCursor.getString(i);
        this.__hadSetusername = true;
      }
      else if (jQl == k)
      {
        this.field_unReadCount = paramCursor.getInt(i);
      }
      else if (kbE == k)
      {
        this.field_chatmode = paramCursor.getInt(i);
      }
      else if (jIF == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (jQu == k)
      {
        this.field_isSend = paramCursor.getInt(i);
      }
      else if (kbF == k)
      {
        this.field_conversationTime = paramCursor.getLong(i);
      }
      else if (content_HASHCODE == k)
      {
        this.field_content = paramCursor.getString(i);
      }
      else if (jQv == k)
      {
        this.field_msgType = paramCursor.getString(i);
      }
      else if (kbG == k)
      {
        this.field_customNotify = paramCursor.getString(i);
      }
      else if (kbH == k)
      {
        this.field_showTips = paramCursor.getInt(i);
      }
      else if (jOZ == k)
      {
        this.field_flag = paramCursor.getLong(i);
      }
      else if (jQp == k)
      {
        this.field_digest = paramCursor.getString(i);
      }
      else if (jQq == k)
      {
        this.field_digestUser = paramCursor.getString(i);
      }
      else if (kbI == k)
      {
        this.field_hasTrunc = paramCursor.getInt(i);
      }
      else if (kbJ == k)
      {
        this.field_parentRef = paramCursor.getString(i);
      }
      else if (kbK == k)
      {
        this.field_attrflag = paramCursor.getInt(i);
      }
      else if (jQs == k)
      {
        this.field_editingMsg = paramCursor.getString(i);
      }
      else if (jQr == k)
      {
        this.field_atCount = paramCursor.getInt(i);
      }
      else if (kbL == k)
      {
        this.field_sightTime = paramCursor.getLong(i);
      }
      else if (kbM == k)
      {
        this.field_unReadMuteCount = paramCursor.getInt(i);
      }
      else if (kbN == k)
      {
        this.field_lastSeq = paramCursor.getLong(i);
      }
      else if (kbO == k)
      {
        this.field_UnDeliverCount = paramCursor.getInt(i);
      }
      else if (kbP == k)
      {
        this.field_UnReadInvite = paramCursor.getInt(i);
      }
      else if (kbQ == k)
      {
        this.field_firstUnDeliverSeq = paramCursor.getLong(i);
      }
      else if (kbR == k)
      {
        this.field_editingQuoteMsgId = paramCursor.getLong(i);
      }
      else if (kbS == k)
      {
        this.field_hasTodo = paramCursor.getInt(i);
      }
      else if (kbT == k)
      {
        this.field_hbMarkRed = paramCursor.getInt(i);
      }
      else if (kbU == k)
      {
        this.field_remitMarkRed = paramCursor.getInt(i);
      }
      else if (kbV == k)
      {
        this.field_hasSpecialFollow = paramCursor.getInt(i);
      }
      else if (rowid_HASHCODE == k)
      {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jQh) {
      localContentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
    }
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.jPW) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.kbm) {
      localContentValues.put("chatmode", Integer.valueOf(this.field_chatmode));
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.jQf) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.kbn) {
      localContentValues.put("conversationTime", Long.valueOf(this.field_conversationTime));
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_msgType == null) {
      this.field_msgType = "";
    }
    if (this.jQg) {
      localContentValues.put("msgType", this.field_msgType);
    }
    if (this.field_customNotify == null) {
      this.field_customNotify = "";
    }
    if (this.kbo) {
      localContentValues.put("customNotify", this.field_customNotify);
    }
    if (this.kbp) {
      localContentValues.put("showTips", Integer.valueOf(this.field_showTips));
    }
    if (this.jOX) {
      localContentValues.put("flag", Long.valueOf(this.field_flag));
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.jQa) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.field_digestUser == null) {
      this.field_digestUser = "";
    }
    if (this.jQb) {
      localContentValues.put("digestUser", this.field_digestUser);
    }
    if (this.kbq) {
      localContentValues.put("hasTrunc", Integer.valueOf(this.field_hasTrunc));
    }
    if (this.kbr) {
      localContentValues.put("parentRef", this.field_parentRef);
    }
    if (this.kbs) {
      localContentValues.put("attrflag", Integer.valueOf(this.field_attrflag));
    }
    if (this.field_editingMsg == null) {
      this.field_editingMsg = "";
    }
    if (this.jQd) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.jQc) {
      localContentValues.put("atCount", Integer.valueOf(this.field_atCount));
    }
    if (this.kbt) {
      localContentValues.put("sightTime", Long.valueOf(this.field_sightTime));
    }
    if (this.kbu) {
      localContentValues.put("unReadMuteCount", Integer.valueOf(this.field_unReadMuteCount));
    }
    if (this.kbv) {
      localContentValues.put("lastSeq", Long.valueOf(this.field_lastSeq));
    }
    if (this.kbw) {
      localContentValues.put("UnDeliverCount", Integer.valueOf(this.field_UnDeliverCount));
    }
    if (this.kbx) {
      localContentValues.put("UnReadInvite", Integer.valueOf(this.field_UnReadInvite));
    }
    if (this.kby) {
      localContentValues.put("firstUnDeliverSeq", Long.valueOf(this.field_firstUnDeliverSeq));
    }
    if (this.kbz) {
      localContentValues.put("editingQuoteMsgId", Long.valueOf(this.field_editingQuoteMsgId));
    }
    if (this.kbA) {
      localContentValues.put("hasTodo", Integer.valueOf(this.field_hasTodo));
    }
    if (this.kbB) {
      localContentValues.put("hbMarkRed", Integer.valueOf(this.field_hbMarkRed));
    }
    if (this.kbC) {
      localContentValues.put("remitMarkRed", Integer.valueOf(this.field_remitMarkRed));
    }
    if (this.kbD) {
      localContentValues.put("hasSpecialFollow", Integer.valueOf(this.field_hasSpecialFollow));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public final void gR(long paramLong)
  {
    this.field_conversationTime = paramLong;
    this.kbn = true;
  }
  
  public void gS(long paramLong)
  {
    this.field_flag = paramLong;
    this.jOX = true;
  }
  
  public final void gT(long paramLong)
  {
    this.field_lastSeq = paramLong;
    this.kbv = true;
  }
  
  public final void gU(long paramLong)
  {
    this.field_firstUnDeliverSeq = paramLong;
    this.kby = true;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public final String getDigest()
  {
    return this.field_digest;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_username;
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
  
  public final String getUsername()
  {
    return this.field_username;
  }
  
  public final void pF(int paramInt)
  {
    this.field_msgCount = paramInt;
    this.jQh = true;
  }
  
  public final void pG(int paramInt)
  {
    this.field_unReadCount = paramInt;
    this.jPW = true;
  }
  
  public final void pH(int paramInt)
  {
    this.field_chatmode = paramInt;
    this.kbm = true;
  }
  
  public final void pI(int paramInt)
  {
    this.field_isSend = paramInt;
    this.jQf = true;
  }
  
  public final void pJ(int paramInt)
  {
    this.field_hasTrunc = paramInt;
    this.kbq = true;
  }
  
  public final void pK(int paramInt)
  {
    this.field_attrflag = paramInt;
    this.kbs = true;
  }
  
  public final void pL(int paramInt)
  {
    this.field_atCount = paramInt;
    this.jQc = true;
  }
  
  public final void pM(int paramInt)
  {
    this.field_unReadMuteCount = paramInt;
    this.kbu = true;
  }
  
  public final void pN(int paramInt)
  {
    this.field_UnDeliverCount = paramInt;
    this.kbw = true;
  }
  
  public final void pO(int paramInt)
  {
    this.field_UnReadInvite = paramInt;
    this.kbx = true;
  }
  
  public final void pP(int paramInt)
  {
    this.field_hasTodo = paramInt;
    this.kbA = true;
  }
  
  public final void pQ(int paramInt)
  {
    this.field_hbMarkRed = paramInt;
    this.kbB = true;
  }
  
  public final void pR(int paramInt)
  {
    this.field_remitMarkRed = paramInt;
    this.kbC = true;
  }
  
  public final void pS(int paramInt)
  {
    this.field_hasSpecialFollow = paramInt;
    this.kbD = true;
  }
  
  public final void setContent(String paramString)
  {
    this.field_content = paramString;
    this.__hadSetcontent = true;
  }
  
  public final void setStatus(int paramInt)
  {
    this.field_status = paramInt;
    this.jIC = true;
  }
  
  public final void setUsername(String paramString)
  {
    this.field_username = paramString;
    this.__hadSetusername = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.b.bd
 * JD-Core Version:    0.7.0.1
 */