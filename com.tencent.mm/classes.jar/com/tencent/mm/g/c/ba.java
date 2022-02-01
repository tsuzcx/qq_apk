package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ba
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDc;
  private static final int eEm;
  private static final int eFp;
  private static final int eHX;
  private static final int eIG;
  private static final int eIK;
  private static final int eIL;
  private static final int eIM = "atCount".hashCode();
  private static final int eIN;
  private static final int eIP;
  private static final int eIQ;
  private static final int eIR = "msgCount".hashCode();
  private static final int eQA;
  private static final int eQB;
  private static final int eQC;
  private static final int eQD = "sightTime".hashCode();
  private static final int eQE = "unReadMuteCount".hashCode();
  private static final int eQF = "lastSeq".hashCode();
  private static final int eQG = "UnDeliverCount".hashCode();
  private static final int eQH = "UnReadInvite".hashCode();
  private static final int eQI = "firstUnDeliverSeq".hashCode();
  private static final int eQJ = "editingQuoteMsgId".hashCode();
  private static final int eQK = "hasTodo".hashCode();
  private static final int eQw;
  private static final int eQx;
  private static final int eQy;
  private static final int eQz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCZ = false;
  private boolean eDP = false;
  private boolean eFm = false;
  private boolean eHV = false;
  private boolean eIA = false;
  private boolean eIB = false;
  private boolean eIC = false;
  private boolean eIr = false;
  private boolean eIv = false;
  private boolean eIw = false;
  private boolean eIx = false;
  private boolean eIy = false;
  private boolean eQh = false;
  private boolean eQi = false;
  private boolean eQj = false;
  public boolean eQk = false;
  private boolean eQl = false;
  private boolean eQm = false;
  private boolean eQn = false;
  public boolean eQo = false;
  private boolean eQp = false;
  private boolean eQq = false;
  private boolean eQr = false;
  private boolean eQs = false;
  private boolean eQt = false;
  public boolean eQu = false;
  private boolean eQv = false;
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
    eFp = "username".hashCode();
    eIG = "unReadCount".hashCode();
    eQw = "chatmode".hashCode();
    eDc = "status".hashCode();
    eIP = "isSend".hashCode();
    eQx = "conversationTime".hashCode();
    eEm = "content".hashCode();
    eIQ = "msgType".hashCode();
    eQy = "customNotify".hashCode();
    eQz = "showTips".hashCode();
    eHX = "flag".hashCode();
    eIK = "digest".hashCode();
    eIL = "digestUser".hashCode();
    eQA = "hasTrunc".hashCode();
    eQB = "parentRef".hashCode();
    eQC = "attrflag".hashCode();
    eIN = "editingMsg".hashCode();
  }
  
  public final int VK()
  {
    return this.field_unReadCount;
  }
  
  public final int VL()
  {
    return this.field_unReadMuteCount;
  }
  
  public final long VM()
  {
    return this.field_lastSeq;
  }
  
  public final int VN()
  {
    return this.field_UnDeliverCount;
  }
  
  public final long VO()
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
      if (eIR != k) {
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
      if (eFp == k)
      {
        this.field_username = paramCursor.getString(i);
        this.eFm = true;
      }
      else if (eIG == k)
      {
        this.field_unReadCount = paramCursor.getInt(i);
      }
      else if (eQw == k)
      {
        this.field_chatmode = paramCursor.getInt(i);
      }
      else if (eDc == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (eIP == k)
      {
        this.field_isSend = paramCursor.getInt(i);
      }
      else if (eQx == k)
      {
        this.field_conversationTime = paramCursor.getLong(i);
      }
      else if (eEm == k)
      {
        this.field_content = paramCursor.getString(i);
      }
      else if (eIQ == k)
      {
        this.field_msgType = paramCursor.getString(i);
      }
      else if (eQy == k)
      {
        this.field_customNotify = paramCursor.getString(i);
      }
      else if (eQz == k)
      {
        this.field_showTips = paramCursor.getInt(i);
      }
      else if (eHX == k)
      {
        this.field_flag = paramCursor.getLong(i);
      }
      else if (eIK == k)
      {
        this.field_digest = paramCursor.getString(i);
      }
      else if (eIL == k)
      {
        this.field_digestUser = paramCursor.getString(i);
      }
      else if (eQA == k)
      {
        this.field_hasTrunc = paramCursor.getInt(i);
      }
      else if (eQB == k)
      {
        this.field_parentRef = paramCursor.getString(i);
      }
      else if (eQC == k)
      {
        this.field_attrflag = paramCursor.getInt(i);
      }
      else if (eIN == k)
      {
        this.field_editingMsg = paramCursor.getString(i);
      }
      else if (eIM == k)
      {
        this.field_atCount = paramCursor.getInt(i);
      }
      else if (eQD == k)
      {
        this.field_sightTime = paramCursor.getLong(i);
      }
      else if (eQE == k)
      {
        this.field_unReadMuteCount = paramCursor.getInt(i);
      }
      else if (eQF == k)
      {
        this.field_lastSeq = paramCursor.getLong(i);
      }
      else if (eQG == k)
      {
        this.field_UnDeliverCount = paramCursor.getInt(i);
      }
      else if (eQH == k)
      {
        this.field_UnReadInvite = paramCursor.getInt(i);
      }
      else if (eQI == k)
      {
        this.field_firstUnDeliverSeq = paramCursor.getLong(i);
      }
      else if (eQJ == k)
      {
        this.field_editingQuoteMsgId = paramCursor.getLong(i);
      }
      else if (eQK == k)
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
    if (this.eIC) {
      localContentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
    }
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.eFm) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eIr) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.eQh) {
      localContentValues.put("chatmode", Integer.valueOf(this.field_chatmode));
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eIA) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.eQi) {
      localContentValues.put("conversationTime", Long.valueOf(this.field_conversationTime));
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.eDP) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_msgType == null) {
      this.field_msgType = "";
    }
    if (this.eIB) {
      localContentValues.put("msgType", this.field_msgType);
    }
    if (this.field_customNotify == null) {
      this.field_customNotify = "";
    }
    if (this.eQj) {
      localContentValues.put("customNotify", this.field_customNotify);
    }
    if (this.eQk) {
      localContentValues.put("showTips", Integer.valueOf(this.field_showTips));
    }
    if (this.eHV) {
      localContentValues.put("flag", Long.valueOf(this.field_flag));
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.eIv) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.field_digestUser == null) {
      this.field_digestUser = "";
    }
    if (this.eIw) {
      localContentValues.put("digestUser", this.field_digestUser);
    }
    if (this.eQl) {
      localContentValues.put("hasTrunc", Integer.valueOf(this.field_hasTrunc));
    }
    if (this.eQm) {
      localContentValues.put("parentRef", this.field_parentRef);
    }
    if (this.eQn) {
      localContentValues.put("attrflag", Integer.valueOf(this.field_attrflag));
    }
    if (this.field_editingMsg == null) {
      this.field_editingMsg = "";
    }
    if (this.eIy) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.eIx) {
      localContentValues.put("atCount", Integer.valueOf(this.field_atCount));
    }
    if (this.eQo) {
      localContentValues.put("sightTime", Long.valueOf(this.field_sightTime));
    }
    if (this.eQp) {
      localContentValues.put("unReadMuteCount", Integer.valueOf(this.field_unReadMuteCount));
    }
    if (this.eQq) {
      localContentValues.put("lastSeq", Long.valueOf(this.field_lastSeq));
    }
    if (this.eQr) {
      localContentValues.put("UnDeliverCount", Integer.valueOf(this.field_UnDeliverCount));
    }
    if (this.eQs) {
      localContentValues.put("UnReadInvite", Integer.valueOf(this.field_UnReadInvite));
    }
    if (this.eQt) {
      localContentValues.put("firstUnDeliverSeq", Long.valueOf(this.field_firstUnDeliverSeq));
    }
    if (this.eQu) {
      localContentValues.put("editingQuoteMsgId", Long.valueOf(this.field_editingQuoteMsgId));
    }
    if (this.eQv) {
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
  
  public final void ko(int paramInt)
  {
    this.field_msgCount = paramInt;
    this.eIC = true;
  }
  
  public final void kp(int paramInt)
  {
    this.field_unReadCount = paramInt;
    this.eIr = true;
  }
  
  public final void kq(int paramInt)
  {
    this.field_chatmode = paramInt;
    this.eQh = true;
  }
  
  public final void kr(int paramInt)
  {
    this.field_isSend = paramInt;
    this.eIA = true;
  }
  
  public final void ks(int paramInt)
  {
    this.field_hasTrunc = paramInt;
    this.eQl = true;
  }
  
  public final void kt(int paramInt)
  {
    this.field_attrflag = paramInt;
    this.eQn = true;
  }
  
  public final void ku(int paramInt)
  {
    this.field_atCount = paramInt;
    this.eIx = true;
  }
  
  public final void kv(int paramInt)
  {
    this.field_unReadMuteCount = paramInt;
    this.eQp = true;
  }
  
  public final void kw(int paramInt)
  {
    this.field_UnDeliverCount = paramInt;
    this.eQr = true;
  }
  
  public final void kx(int paramInt)
  {
    this.field_UnReadInvite = paramInt;
    this.eQs = true;
  }
  
  public final void ky(int paramInt)
  {
    this.field_hasTodo = paramInt;
    this.eQv = true;
  }
  
  public final void qu(long paramLong)
  {
    this.field_conversationTime = paramLong;
    this.eQi = true;
  }
  
  public void qv(long paramLong)
  {
    this.field_flag = paramLong;
    this.eHV = true;
  }
  
  public final void qw(long paramLong)
  {
    this.field_lastSeq = paramLong;
    this.eQq = true;
  }
  
  public final void qx(long paramLong)
  {
    this.field_firstUnDeliverSeq = paramLong;
    this.eQt = true;
  }
  
  public final void setContent(String paramString)
  {
    this.field_content = paramString;
    this.eDP = true;
  }
  
  public final void setStatus(int paramInt)
  {
    this.field_status = paramInt;
    this.eCZ = true;
  }
  
  public final void setUsername(String paramString)
  {
    this.field_username = paramString;
    this.eFm = true;
  }
  
  public final void tA(String paramString)
  {
    this.field_msgType = paramString;
    this.eIB = true;
  }
  
  public final void tB(String paramString)
  {
    this.field_digest = paramString;
    this.eIv = true;
  }
  
  public final void tC(String paramString)
  {
    this.field_digestUser = paramString;
    this.eIw = true;
  }
  
  public final void tD(String paramString)
  {
    this.field_parentRef = paramString;
    this.eQm = true;
  }
  
  public final void tE(String paramString)
  {
    this.field_editingMsg = paramString;
    this.eIy = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ba
 * JD-Core Version:    0.7.0.1
 */