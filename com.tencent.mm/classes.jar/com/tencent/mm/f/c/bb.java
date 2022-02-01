package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class bb
  extends IAutoDBItem
{
  public static final Column C_CONTENT;
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("Conversation");
  private static final int content_HASHCODE;
  public static final Column hDZ;
  private static final int hEH;
  private static final int hEI;
  private static final int hEJ;
  private static final int hEK;
  private static final int hEL;
  private static final int hEM;
  private static final int hEN;
  private static final int hEO = "sightTime".hashCode();
  private static final int hEP = "unReadMuteCount".hashCode();
  private static final int hEQ = "lastSeq".hashCode();
  private static final int hER = "UnDeliverCount".hashCode();
  private static final int hES = "UnReadInvite".hashCode();
  private static final int hET = "firstUnDeliverSeq".hashCode();
  private static final int hEU = "editingQuoteMsgId".hashCode();
  private static final int hEV = "hasTodo".hashCode();
  private static final int hEW = "hbMarkRed".hashCode();
  private static final int hEX = "remitMarkRed".hashCode();
  public static final Column hEa;
  public static final Column hEb;
  public static final Column hEc;
  public static final Column hEd;
  public static final Column hEe;
  public static final Column hEf;
  public static final Column hEg;
  public static final Column hEh;
  public static final Column hEi;
  public static final Column hEj;
  public static final Column hEk;
  public static final Column hEl;
  public static final Column hEm;
  public static final Column hEn;
  public static final Column hEo;
  public static final Column hEp;
  private static final int hmC;
  public static final Column hmw;
  public static final Column hsU;
  public static final Column hsY;
  public static final Column hsZ;
  public static final Column hsi;
  private static final int hsm;
  private static final int htC;
  private static final int htD;
  private static final int htE;
  private static final int htF;
  private static final int htH;
  private static final int htI;
  private static final int htJ;
  public static final Column hta;
  public static final Column htb;
  public static final Column htd;
  public static final Column hte;
  public static final Column htf;
  private static final int hty;
  private static final int rowid_HASHCODE = "rowid".hashCode();
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
  private boolean hEA = false;
  private boolean hEB = false;
  private boolean hEC = false;
  public boolean hED = false;
  private boolean hEE = false;
  private boolean hEF = false;
  private boolean hEG = false;
  private boolean hEq = false;
  private boolean hEr = false;
  private boolean hEs = false;
  private boolean hEt = false;
  private boolean hEu = false;
  private boolean hEv = false;
  private boolean hEw = false;
  public boolean hEx = false;
  private boolean hEy = false;
  private boolean hEz = false;
  private boolean hmz = false;
  private boolean hsk = false;
  private boolean htj = false;
  private boolean htn = false;
  private boolean hto = false;
  private boolean htp = false;
  private boolean htq = false;
  private boolean hts = false;
  private boolean htt = false;
  private boolean htu = false;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "Conversation", "");
    htf = new Column("msgcount", "int", "Conversation", "");
    C_USERNAME = new Column("username", "string", "Conversation", "");
    hsU = new Column("unreadcount", "int", "Conversation", "");
    hDZ = new Column("chatmode", "int", "Conversation", "");
    hmw = new Column("status", "int", "Conversation", "");
    htd = new Column("issend", "int", "Conversation", "");
    hEa = new Column("conversationtime", "long", "Conversation", "");
    C_CONTENT = new Column("content", "string", "Conversation", "");
    hte = new Column("msgtype", "string", "Conversation", "");
    hEb = new Column("customnotify", "string", "Conversation", "");
    hEc = new Column("showtips", "int", "Conversation", "");
    hsi = new Column("flag", "long", "Conversation", "");
    hsY = new Column("digest", "string", "Conversation", "");
    hsZ = new Column("digestuser", "string", "Conversation", "");
    hEd = new Column("hastrunc", "int", "Conversation", "");
    hEe = new Column("parentref", "string", "Conversation", "");
    hEf = new Column("attrflag", "int", "Conversation", "");
    htb = new Column("editingmsg", "string", "Conversation", "");
    hta = new Column("atcount", "int", "Conversation", "");
    hEg = new Column("sighttime", "long", "Conversation", "");
    hEh = new Column("unreadmutecount", "int", "Conversation", "");
    hEi = new Column("lastseq", "long", "Conversation", "");
    hEj = new Column("undelivercount", "int", "Conversation", "");
    hEk = new Column("unreadinvite", "int", "Conversation", "");
    hEl = new Column("firstundeliverseq", "long", "Conversation", "");
    hEm = new Column("editingquotemsgid", "long", "Conversation", "");
    hEn = new Column("hastodo", "int", "Conversation", "");
    hEo = new Column("hbmarkred", "int", "Conversation", "");
    hEp = new Column("remitmarkred", "int", "Conversation", "");
    htJ = "msgCount".hashCode();
    username_HASHCODE = "username".hashCode();
    hty = "unReadCount".hashCode();
    hEH = "chatmode".hashCode();
    hmC = "status".hashCode();
    htH = "isSend".hashCode();
    hEI = "conversationTime".hashCode();
    content_HASHCODE = "content".hashCode();
    htI = "msgType".hashCode();
    hEJ = "customNotify".hashCode();
    hEK = "showTips".hashCode();
    hsm = "flag".hashCode();
    htC = "digest".hashCode();
    htD = "digestUser".hashCode();
    hEL = "hasTrunc".hashCode();
    hEM = "parentRef".hashCode();
    hEN = "attrflag".hashCode();
    htF = "editingMsg".hashCode();
    htE = "atCount".hashCode();
  }
  
  public final void EB(long paramLong)
  {
    this.field_conversationTime = paramLong;
    this.hEr = true;
  }
  
  public void EC(long paramLong)
  {
    this.field_flag = paramLong;
    this.hsk = true;
  }
  
  public final void ED(long paramLong)
  {
    this.field_lastSeq = paramLong;
    this.hEz = true;
  }
  
  public final void EE(long paramLong)
  {
    this.field_firstUnDeliverSeq = paramLong;
    this.hEC = true;
  }
  
  public final void IZ(String paramString)
  {
    this.field_msgType = paramString;
    this.htt = true;
  }
  
  public final void Ja(String paramString)
  {
    this.field_digest = paramString;
    this.htn = true;
  }
  
  public final void Jb(String paramString)
  {
    this.field_digestUser = paramString;
    this.hto = true;
  }
  
  public final void Jc(String paramString)
  {
    this.field_parentRef = paramString;
    this.hEv = true;
  }
  
  public final void Jd(String paramString)
  {
    this.field_editingMsg = paramString;
    this.htq = true;
  }
  
  public final int apA()
  {
    return this.field_isSend;
  }
  
  public final String apB()
  {
    return this.field_digestUser;
  }
  
  public final int apC()
  {
    return this.field_unReadMuteCount;
  }
  
  public final long apD()
  {
    return this.field_lastSeq;
  }
  
  public final int apE()
  {
    return this.field_UnDeliverCount;
  }
  
  public final long apF()
  {
    return this.field_firstUnDeliverSeq;
  }
  
  public final int apz()
  {
    return this.field_unReadCount;
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
      if (htJ != k) {
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
      else if (hty == k)
      {
        this.field_unReadCount = paramCursor.getInt(i);
      }
      else if (hEH == k)
      {
        this.field_chatmode = paramCursor.getInt(i);
      }
      else if (hmC == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (htH == k)
      {
        this.field_isSend = paramCursor.getInt(i);
      }
      else if (hEI == k)
      {
        this.field_conversationTime = paramCursor.getLong(i);
      }
      else if (content_HASHCODE == k)
      {
        this.field_content = paramCursor.getString(i);
      }
      else if (htI == k)
      {
        this.field_msgType = paramCursor.getString(i);
      }
      else if (hEJ == k)
      {
        this.field_customNotify = paramCursor.getString(i);
      }
      else if (hEK == k)
      {
        this.field_showTips = paramCursor.getInt(i);
      }
      else if (hsm == k)
      {
        this.field_flag = paramCursor.getLong(i);
      }
      else if (htC == k)
      {
        this.field_digest = paramCursor.getString(i);
      }
      else if (htD == k)
      {
        this.field_digestUser = paramCursor.getString(i);
      }
      else if (hEL == k)
      {
        this.field_hasTrunc = paramCursor.getInt(i);
      }
      else if (hEM == k)
      {
        this.field_parentRef = paramCursor.getString(i);
      }
      else if (hEN == k)
      {
        this.field_attrflag = paramCursor.getInt(i);
      }
      else if (htF == k)
      {
        this.field_editingMsg = paramCursor.getString(i);
      }
      else if (htE == k)
      {
        this.field_atCount = paramCursor.getInt(i);
      }
      else if (hEO == k)
      {
        this.field_sightTime = paramCursor.getLong(i);
      }
      else if (hEP == k)
      {
        this.field_unReadMuteCount = paramCursor.getInt(i);
      }
      else if (hEQ == k)
      {
        this.field_lastSeq = paramCursor.getLong(i);
      }
      else if (hER == k)
      {
        this.field_UnDeliverCount = paramCursor.getInt(i);
      }
      else if (hES == k)
      {
        this.field_UnReadInvite = paramCursor.getInt(i);
      }
      else if (hET == k)
      {
        this.field_firstUnDeliverSeq = paramCursor.getLong(i);
      }
      else if (hEU == k)
      {
        this.field_editingQuoteMsgId = paramCursor.getLong(i);
      }
      else if (hEV == k)
      {
        this.field_hasTodo = paramCursor.getInt(i);
      }
      else if (hEW == k)
      {
        this.field_hbMarkRed = paramCursor.getInt(i);
      }
      else if (hEX == k)
      {
        this.field_remitMarkRed = paramCursor.getInt(i);
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
    if (this.htu) {
      localContentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
    }
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.htj) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.hEq) {
      localContentValues.put("chatmode", Integer.valueOf(this.field_chatmode));
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.hts) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.hEr) {
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
    if (this.htt) {
      localContentValues.put("msgType", this.field_msgType);
    }
    if (this.field_customNotify == null) {
      this.field_customNotify = "";
    }
    if (this.hEs) {
      localContentValues.put("customNotify", this.field_customNotify);
    }
    if (this.hEt) {
      localContentValues.put("showTips", Integer.valueOf(this.field_showTips));
    }
    if (this.hsk) {
      localContentValues.put("flag", Long.valueOf(this.field_flag));
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.htn) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.field_digestUser == null) {
      this.field_digestUser = "";
    }
    if (this.hto) {
      localContentValues.put("digestUser", this.field_digestUser);
    }
    if (this.hEu) {
      localContentValues.put("hasTrunc", Integer.valueOf(this.field_hasTrunc));
    }
    if (this.hEv) {
      localContentValues.put("parentRef", this.field_parentRef);
    }
    if (this.hEw) {
      localContentValues.put("attrflag", Integer.valueOf(this.field_attrflag));
    }
    if (this.field_editingMsg == null) {
      this.field_editingMsg = "";
    }
    if (this.htq) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.htp) {
      localContentValues.put("atCount", Integer.valueOf(this.field_atCount));
    }
    if (this.hEx) {
      localContentValues.put("sightTime", Long.valueOf(this.field_sightTime));
    }
    if (this.hEy) {
      localContentValues.put("unReadMuteCount", Integer.valueOf(this.field_unReadMuteCount));
    }
    if (this.hEz) {
      localContentValues.put("lastSeq", Long.valueOf(this.field_lastSeq));
    }
    if (this.hEA) {
      localContentValues.put("UnDeliverCount", Integer.valueOf(this.field_UnDeliverCount));
    }
    if (this.hEB) {
      localContentValues.put("UnReadInvite", Integer.valueOf(this.field_UnReadInvite));
    }
    if (this.hEC) {
      localContentValues.put("firstUnDeliverSeq", Long.valueOf(this.field_firstUnDeliverSeq));
    }
    if (this.hED) {
      localContentValues.put("editingQuoteMsgId", Long.valueOf(this.field_editingQuoteMsgId));
    }
    if (this.hEE) {
      localContentValues.put("hasTodo", Integer.valueOf(this.field_hasTodo));
    }
    if (this.hEF) {
      localContentValues.put("hbMarkRed", Integer.valueOf(this.field_hbMarkRed));
    }
    if (this.hEG) {
      localContentValues.put("remitMarkRed", Integer.valueOf(this.field_remitMarkRed));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public final String getContent()
  {
    return this.field_content;
  }
  
  public final String getDigest()
  {
    return this.field_digest;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "Conversation";
  }
  
  public final String getUsername()
  {
    return this.field_username;
  }
  
  public final void pG(int paramInt)
  {
    this.field_msgCount = paramInt;
    this.htu = true;
  }
  
  public final void pH(int paramInt)
  {
    this.field_unReadCount = paramInt;
    this.htj = true;
  }
  
  public final void pI(int paramInt)
  {
    this.field_chatmode = paramInt;
    this.hEq = true;
  }
  
  public final void pJ(int paramInt)
  {
    this.field_isSend = paramInt;
    this.hts = true;
  }
  
  public final void pK(int paramInt)
  {
    this.field_hasTrunc = paramInt;
    this.hEu = true;
  }
  
  public final void pL(int paramInt)
  {
    this.field_attrflag = paramInt;
    this.hEw = true;
  }
  
  public final void pM(int paramInt)
  {
    this.field_atCount = paramInt;
    this.htp = true;
  }
  
  public final void pN(int paramInt)
  {
    this.field_unReadMuteCount = paramInt;
    this.hEy = true;
  }
  
  public final void pO(int paramInt)
  {
    this.field_UnDeliverCount = paramInt;
    this.hEA = true;
  }
  
  public final void pP(int paramInt)
  {
    this.field_UnReadInvite = paramInt;
    this.hEB = true;
  }
  
  public final void pQ(int paramInt)
  {
    this.field_hasTodo = paramInt;
    this.hEE = true;
  }
  
  public final void pR(int paramInt)
  {
    this.field_hbMarkRed = paramInt;
    this.hEF = true;
  }
  
  public final void pS(int paramInt)
  {
    this.field_remitMarkRed = paramInt;
    this.hEG = true;
  }
  
  public final void setContent(String paramString)
  {
    this.field_content = paramString;
    this.__hadSetcontent = true;
  }
  
  public final void setStatus(int paramInt)
  {
    this.field_status = paramInt;
    this.hmz = true;
  }
  
  public final void setUsername(String paramString)
  {
    this.field_username = paramString;
    this.__hadSetusername = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.bb
 * JD-Core Version:    0.7.0.1
 */