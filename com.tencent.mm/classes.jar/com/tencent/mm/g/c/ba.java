package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ba
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEL;
  private static final int eFV;
  private static final int eGY;
  private static final int eJG;
  private static final int eKA = "msgCount".hashCode();
  private static final int eKp;
  private static final int eKt;
  private static final int eKu;
  private static final int eKv = "atCount".hashCode();
  private static final int eKw;
  private static final int eKy;
  private static final int eKz;
  private static final int eSh;
  private static final int eSi;
  private static final int eSj;
  private static final int eSk;
  private static final int eSl;
  private static final int eSm;
  private static final int eSn;
  private static final int eSo = "sightTime".hashCode();
  private static final int eSp = "unReadMuteCount".hashCode();
  private static final int eSq = "lastSeq".hashCode();
  private static final int eSr = "UnDeliverCount".hashCode();
  private static final int eSs = "UnReadInvite".hashCode();
  private static final int eSt = "firstUnDeliverSeq".hashCode();
  private static final int eSu = "editingQuoteMsgId".hashCode();
  private static final int eSv = "hasTodo".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEI = false;
  private boolean eFy = false;
  private boolean eGV = false;
  private boolean eJE = false;
  private boolean eKa = false;
  private boolean eKe = false;
  private boolean eKf = false;
  private boolean eKg = false;
  private boolean eKh = false;
  private boolean eKj = false;
  private boolean eKk = false;
  private boolean eKl = false;
  private boolean eRS = false;
  private boolean eRT = false;
  private boolean eRU = false;
  public boolean eRV = false;
  private boolean eRW = false;
  private boolean eRX = false;
  private boolean eRY = false;
  public boolean eRZ = false;
  private boolean eSa = false;
  private boolean eSb = false;
  private boolean eSc = false;
  private boolean eSd = false;
  private boolean eSe = false;
  public boolean eSf = false;
  private boolean eSg = false;
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
  public int field_isSend;
  public long field_lastSeq;
  public int field_msgCount;
  public String field_msgType;
  public String field_parentRef;
  public int field_showTips;
  public long field_sightTime;
  public int field_status;
  public int field_unReadCount;
  public int field_unReadMuteCount;
  public String field_username;
  
  static
  {
    eGY = "username".hashCode();
    eKp = "unReadCount".hashCode();
    eSh = "chatmode".hashCode();
    eEL = "status".hashCode();
    eKy = "isSend".hashCode();
    eSi = "conversationTime".hashCode();
    eFV = "content".hashCode();
    eKz = "msgType".hashCode();
    eSj = "customNotify".hashCode();
    eSk = "showTips".hashCode();
    eJG = "flag".hashCode();
    eKt = "digest".hashCode();
    eKu = "digestUser".hashCode();
    eSl = "hasTrunc".hashCode();
    eSm = "parentRef".hashCode();
    eSn = "attrflag".hashCode();
    eKw = "editingMsg".hashCode();
  }
  
  public final int VS()
  {
    return this.field_unReadCount;
  }
  
  public final int VT()
  {
    return this.field_unReadMuteCount;
  }
  
  public final long VU()
  {
    return this.field_lastSeq;
  }
  
  public final int VV()
  {
    return this.field_UnDeliverCount;
  }
  
  public final long VW()
  {
    return this.field_firstUnDeliverSeq;
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
      if (eKA != k) {
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
      if (eGY == k)
      {
        this.field_username = paramCursor.getString(i);
        this.eGV = true;
      }
      else if (eKp == k)
      {
        this.field_unReadCount = paramCursor.getInt(i);
      }
      else if (eSh == k)
      {
        this.field_chatmode = paramCursor.getInt(i);
      }
      else if (eEL == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (eKy == k)
      {
        this.field_isSend = paramCursor.getInt(i);
      }
      else if (eSi == k)
      {
        this.field_conversationTime = paramCursor.getLong(i);
      }
      else if (eFV == k)
      {
        this.field_content = paramCursor.getString(i);
      }
      else if (eKz == k)
      {
        this.field_msgType = paramCursor.getString(i);
      }
      else if (eSj == k)
      {
        this.field_customNotify = paramCursor.getString(i);
      }
      else if (eSk == k)
      {
        this.field_showTips = paramCursor.getInt(i);
      }
      else if (eJG == k)
      {
        this.field_flag = paramCursor.getLong(i);
      }
      else if (eKt == k)
      {
        this.field_digest = paramCursor.getString(i);
      }
      else if (eKu == k)
      {
        this.field_digestUser = paramCursor.getString(i);
      }
      else if (eSl == k)
      {
        this.field_hasTrunc = paramCursor.getInt(i);
      }
      else if (eSm == k)
      {
        this.field_parentRef = paramCursor.getString(i);
      }
      else if (eSn == k)
      {
        this.field_attrflag = paramCursor.getInt(i);
      }
      else if (eKw == k)
      {
        this.field_editingMsg = paramCursor.getString(i);
      }
      else if (eKv == k)
      {
        this.field_atCount = paramCursor.getInt(i);
      }
      else if (eSo == k)
      {
        this.field_sightTime = paramCursor.getLong(i);
      }
      else if (eSp == k)
      {
        this.field_unReadMuteCount = paramCursor.getInt(i);
      }
      else if (eSq == k)
      {
        this.field_lastSeq = paramCursor.getLong(i);
      }
      else if (eSr == k)
      {
        this.field_UnDeliverCount = paramCursor.getInt(i);
      }
      else if (eSs == k)
      {
        this.field_UnReadInvite = paramCursor.getInt(i);
      }
      else if (eSt == k)
      {
        this.field_firstUnDeliverSeq = paramCursor.getLong(i);
      }
      else if (eSu == k)
      {
        this.field_editingQuoteMsgId = paramCursor.getLong(i);
      }
      else if (eSv == k)
      {
        this.field_hasTodo = paramCursor.getInt(i);
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
    if (this.eKl) {
      localContentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
    }
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.eGV) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eKa) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.eRS) {
      localContentValues.put("chatmode", Integer.valueOf(this.field_chatmode));
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eKj) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.eRT) {
      localContentValues.put("conversationTime", Long.valueOf(this.field_conversationTime));
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.eFy) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_msgType == null) {
      this.field_msgType = "";
    }
    if (this.eKk) {
      localContentValues.put("msgType", this.field_msgType);
    }
    if (this.field_customNotify == null) {
      this.field_customNotify = "";
    }
    if (this.eRU) {
      localContentValues.put("customNotify", this.field_customNotify);
    }
    if (this.eRV) {
      localContentValues.put("showTips", Integer.valueOf(this.field_showTips));
    }
    if (this.eJE) {
      localContentValues.put("flag", Long.valueOf(this.field_flag));
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.eKe) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.field_digestUser == null) {
      this.field_digestUser = "";
    }
    if (this.eKf) {
      localContentValues.put("digestUser", this.field_digestUser);
    }
    if (this.eRW) {
      localContentValues.put("hasTrunc", Integer.valueOf(this.field_hasTrunc));
    }
    if (this.eRX) {
      localContentValues.put("parentRef", this.field_parentRef);
    }
    if (this.eRY) {
      localContentValues.put("attrflag", Integer.valueOf(this.field_attrflag));
    }
    if (this.field_editingMsg == null) {
      this.field_editingMsg = "";
    }
    if (this.eKh) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.eKg) {
      localContentValues.put("atCount", Integer.valueOf(this.field_atCount));
    }
    if (this.eRZ) {
      localContentValues.put("sightTime", Long.valueOf(this.field_sightTime));
    }
    if (this.eSa) {
      localContentValues.put("unReadMuteCount", Integer.valueOf(this.field_unReadMuteCount));
    }
    if (this.eSb) {
      localContentValues.put("lastSeq", Long.valueOf(this.field_lastSeq));
    }
    if (this.eSc) {
      localContentValues.put("UnDeliverCount", Integer.valueOf(this.field_UnDeliverCount));
    }
    if (this.eSd) {
      localContentValues.put("UnReadInvite", Integer.valueOf(this.field_UnReadInvite));
    }
    if (this.eSe) {
      localContentValues.put("firstUnDeliverSeq", Long.valueOf(this.field_firstUnDeliverSeq));
    }
    if (this.eSf) {
      localContentValues.put("editingQuoteMsgId", Long.valueOf(this.field_editingQuoteMsgId));
    }
    if (this.eSg) {
      localContentValues.put("hasTodo", Integer.valueOf(this.field_hasTodo));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public final String getDigest()
  {
    return this.field_digest;
  }
  
  public final String getUsername()
  {
    return this.field_username;
  }
  
  public final void kA(int paramInt)
  {
    this.field_hasTodo = paramInt;
    this.eSg = true;
  }
  
  public final void kq(int paramInt)
  {
    this.field_msgCount = paramInt;
    this.eKl = true;
  }
  
  public final void kr(int paramInt)
  {
    this.field_unReadCount = paramInt;
    this.eKa = true;
  }
  
  public final void ks(int paramInt)
  {
    this.field_chatmode = paramInt;
    this.eRS = true;
  }
  
  public final void kt(int paramInt)
  {
    this.field_isSend = paramInt;
    this.eKj = true;
  }
  
  public final void ku(int paramInt)
  {
    this.field_hasTrunc = paramInt;
    this.eRW = true;
  }
  
  public final void kv(int paramInt)
  {
    this.field_attrflag = paramInt;
    this.eRY = true;
  }
  
  public final void kw(int paramInt)
  {
    this.field_atCount = paramInt;
    this.eKg = true;
  }
  
  public final void kx(int paramInt)
  {
    this.field_unReadMuteCount = paramInt;
    this.eSa = true;
  }
  
  public final void ky(int paramInt)
  {
    this.field_UnDeliverCount = paramInt;
    this.eSc = true;
  }
  
  public final void kz(int paramInt)
  {
    this.field_UnReadInvite = paramInt;
    this.eSd = true;
  }
  
  public final void qH(long paramLong)
  {
    this.field_conversationTime = paramLong;
    this.eRT = true;
  }
  
  public void qI(long paramLong)
  {
    this.field_flag = paramLong;
    this.eJE = true;
  }
  
  public final void qJ(long paramLong)
  {
    this.field_lastSeq = paramLong;
    this.eSb = true;
  }
  
  public final void qK(long paramLong)
  {
    this.field_firstUnDeliverSeq = paramLong;
    this.eSe = true;
  }
  
  public final void setContent(String paramString)
  {
    this.field_content = paramString;
    this.eFy = true;
  }
  
  public final void setStatus(int paramInt)
  {
    this.field_status = paramInt;
    this.eEI = true;
  }
  
  public final void setUsername(String paramString)
  {
    this.field_username = paramString;
    this.eGV = true;
  }
  
  public final void tV(String paramString)
  {
    this.field_msgType = paramString;
    this.eKk = true;
  }
  
  public final void tW(String paramString)
  {
    this.field_digest = paramString;
    this.eKe = true;
  }
  
  public final void tX(String paramString)
  {
    this.field_digestUser = paramString;
    this.eKf = true;
  }
  
  public final void tY(String paramString)
  {
    this.field_parentRef = paramString;
    this.eRX = true;
  }
  
  public final void tZ(String paramString)
  {
    this.field_editingMsg = paramString;
    this.eKh = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ba
 * JD-Core Version:    0.7.0.1
 */