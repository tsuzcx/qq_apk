package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ay
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ejR;
  private static final int elb;
  private static final int eme;
  private static final int eoK;
  private static final int epA = "editingMsg".hashCode();
  private static final int epC;
  private static final int epD;
  private static final int epE = "msgCount".hashCode();
  private static final int ept;
  private static final int epx;
  private static final int epy;
  private static final int epz = "atCount".hashCode();
  private static final int ewB;
  private static final int ewC;
  private static final int ewD;
  private static final int ewE;
  private static final int ewF;
  private static final int ewG;
  private static final int ewH;
  private static final int ewI = "sightTime".hashCode();
  private static final int ewJ = "unReadMuteCount".hashCode();
  private static final int ewK = "lastSeq".hashCode();
  private static final int ewL = "UnDeliverCount".hashCode();
  private static final int ewM = "UnReadInvite".hashCode();
  private static final int ewN = "firstUnDeliverSeq".hashCode();
  private static final int ewO = "editingQuoteMsgId".hashCode();
  private static final int ewP = "hasTodo".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ejO = false;
  private boolean ekE = false;
  private boolean emb = false;
  private boolean eoI = false;
  private boolean epe = false;
  private boolean epi = false;
  private boolean epj = false;
  private boolean epk = false;
  private boolean epl = false;
  private boolean epn = false;
  private boolean epo = false;
  private boolean epp = false;
  private boolean ewA = false;
  private boolean ewm = false;
  private boolean ewn = false;
  private boolean ewo = false;
  public boolean ewp = false;
  private boolean ewq = false;
  private boolean ewr = false;
  private boolean ews = false;
  public boolean ewt = false;
  private boolean ewu = false;
  private boolean ewv = false;
  private boolean eww = false;
  private boolean ewx = false;
  private boolean ewy = false;
  public boolean ewz = false;
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
    eme = "username".hashCode();
    ept = "unReadCount".hashCode();
    ewB = "chatmode".hashCode();
    ejR = "status".hashCode();
    epC = "isSend".hashCode();
    ewC = "conversationTime".hashCode();
    elb = "content".hashCode();
    epD = "msgType".hashCode();
    ewD = "customNotify".hashCode();
    ewE = "showTips".hashCode();
    eoK = "flag".hashCode();
    epx = "digest".hashCode();
    epy = "digestUser".hashCode();
    ewF = "hasTrunc".hashCode();
    ewG = "parentRef".hashCode();
    ewH = "attrflag".hashCode();
  }
  
  public final int SB()
  {
    return this.field_unReadCount;
  }
  
  public final long SC()
  {
    return this.field_lastSeq;
  }
  
  public final int SD()
  {
    return this.field_UnDeliverCount;
  }
  
  public final long SE()
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
      if (epE != k) {
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
      if (eme == k)
      {
        this.field_username = paramCursor.getString(i);
        this.emb = true;
      }
      else if (ept == k)
      {
        this.field_unReadCount = paramCursor.getInt(i);
      }
      else if (ewB == k)
      {
        this.field_chatmode = paramCursor.getInt(i);
      }
      else if (ejR == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (epC == k)
      {
        this.field_isSend = paramCursor.getInt(i);
      }
      else if (ewC == k)
      {
        this.field_conversationTime = paramCursor.getLong(i);
      }
      else if (elb == k)
      {
        this.field_content = paramCursor.getString(i);
      }
      else if (epD == k)
      {
        this.field_msgType = paramCursor.getString(i);
      }
      else if (ewD == k)
      {
        this.field_customNotify = paramCursor.getString(i);
      }
      else if (ewE == k)
      {
        this.field_showTips = paramCursor.getInt(i);
      }
      else if (eoK == k)
      {
        this.field_flag = paramCursor.getLong(i);
      }
      else if (epx == k)
      {
        this.field_digest = paramCursor.getString(i);
      }
      else if (epy == k)
      {
        this.field_digestUser = paramCursor.getString(i);
      }
      else if (ewF == k)
      {
        this.field_hasTrunc = paramCursor.getInt(i);
      }
      else if (ewG == k)
      {
        this.field_parentRef = paramCursor.getString(i);
      }
      else if (ewH == k)
      {
        this.field_attrflag = paramCursor.getInt(i);
      }
      else if (epA == k)
      {
        this.field_editingMsg = paramCursor.getString(i);
      }
      else if (epz == k)
      {
        this.field_atCount = paramCursor.getInt(i);
      }
      else if (ewI == k)
      {
        this.field_sightTime = paramCursor.getLong(i);
      }
      else if (ewJ == k)
      {
        this.field_unReadMuteCount = paramCursor.getInt(i);
      }
      else if (ewK == k)
      {
        this.field_lastSeq = paramCursor.getLong(i);
      }
      else if (ewL == k)
      {
        this.field_UnDeliverCount = paramCursor.getInt(i);
      }
      else if (ewM == k)
      {
        this.field_UnReadInvite = paramCursor.getInt(i);
      }
      else if (ewN == k)
      {
        this.field_firstUnDeliverSeq = paramCursor.getLong(i);
      }
      else if (ewO == k)
      {
        this.field_editingQuoteMsgId = paramCursor.getLong(i);
      }
      else if (ewP == k)
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
    if (this.epp) {
      localContentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
    }
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.emb) {
      localContentValues.put("username", this.field_username);
    }
    if (this.epe) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.ewm) {
      localContentValues.put("chatmode", Integer.valueOf(this.field_chatmode));
    }
    if (this.ejO) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.epn) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.ewn) {
      localContentValues.put("conversationTime", Long.valueOf(this.field_conversationTime));
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.ekE) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_msgType == null) {
      this.field_msgType = "";
    }
    if (this.epo) {
      localContentValues.put("msgType", this.field_msgType);
    }
    if (this.field_customNotify == null) {
      this.field_customNotify = "";
    }
    if (this.ewo) {
      localContentValues.put("customNotify", this.field_customNotify);
    }
    if (this.ewp) {
      localContentValues.put("showTips", Integer.valueOf(this.field_showTips));
    }
    if (this.eoI) {
      localContentValues.put("flag", Long.valueOf(this.field_flag));
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.epi) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.field_digestUser == null) {
      this.field_digestUser = "";
    }
    if (this.epj) {
      localContentValues.put("digestUser", this.field_digestUser);
    }
    if (this.ewq) {
      localContentValues.put("hasTrunc", Integer.valueOf(this.field_hasTrunc));
    }
    if (this.ewr) {
      localContentValues.put("parentRef", this.field_parentRef);
    }
    if (this.ews) {
      localContentValues.put("attrflag", Integer.valueOf(this.field_attrflag));
    }
    if (this.field_editingMsg == null) {
      this.field_editingMsg = "";
    }
    if (this.epl) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.epk) {
      localContentValues.put("atCount", Integer.valueOf(this.field_atCount));
    }
    if (this.ewt) {
      localContentValues.put("sightTime", Long.valueOf(this.field_sightTime));
    }
    if (this.ewu) {
      localContentValues.put("unReadMuteCount", Integer.valueOf(this.field_unReadMuteCount));
    }
    if (this.ewv) {
      localContentValues.put("lastSeq", Long.valueOf(this.field_lastSeq));
    }
    if (this.eww) {
      localContentValues.put("UnDeliverCount", Integer.valueOf(this.field_UnDeliverCount));
    }
    if (this.ewx) {
      localContentValues.put("UnReadInvite", Integer.valueOf(this.field_UnReadInvite));
    }
    if (this.ewy) {
      localContentValues.put("firstUnDeliverSeq", Long.valueOf(this.field_firstUnDeliverSeq));
    }
    if (this.ewz) {
      localContentValues.put("editingQuoteMsgId", Long.valueOf(this.field_editingQuoteMsgId));
    }
    if (this.ewA) {
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
  
  public final void jS(int paramInt)
  {
    this.field_msgCount = paramInt;
    this.epp = true;
  }
  
  public final void jT(int paramInt)
  {
    this.field_unReadCount = paramInt;
    this.epe = true;
  }
  
  public final void jU(int paramInt)
  {
    this.field_chatmode = paramInt;
    this.ewm = true;
  }
  
  public final void jV(int paramInt)
  {
    this.field_isSend = paramInt;
    this.epn = true;
  }
  
  public final void jW(int paramInt)
  {
    this.field_hasTrunc = paramInt;
    this.ewq = true;
  }
  
  public final void jX(int paramInt)
  {
    this.field_attrflag = paramInt;
    this.ews = true;
  }
  
  public final void jY(int paramInt)
  {
    this.field_atCount = paramInt;
    this.epk = true;
  }
  
  public final void jZ(int paramInt)
  {
    this.field_unReadMuteCount = paramInt;
    this.ewu = true;
  }
  
  public final void kS(long paramLong)
  {
    this.field_conversationTime = paramLong;
    this.ewn = true;
  }
  
  public void kT(long paramLong)
  {
    this.field_flag = paramLong;
    this.eoI = true;
  }
  
  public final void kU(long paramLong)
  {
    this.field_lastSeq = paramLong;
    this.ewv = true;
  }
  
  public final void kV(long paramLong)
  {
    this.field_firstUnDeliverSeq = paramLong;
    this.ewy = true;
  }
  
  public final void ka(int paramInt)
  {
    this.field_UnDeliverCount = paramInt;
    this.eww = true;
  }
  
  public final void kb(int paramInt)
  {
    this.field_UnReadInvite = paramInt;
    this.ewx = true;
  }
  
  public final void kc(int paramInt)
  {
    this.field_hasTodo = paramInt;
    this.ewA = true;
  }
  
  public final void nK(String paramString)
  {
    this.field_msgType = paramString;
    this.epo = true;
  }
  
  public final void nL(String paramString)
  {
    this.field_digest = paramString;
    this.epi = true;
  }
  
  public final void nM(String paramString)
  {
    this.field_digestUser = paramString;
    this.epj = true;
  }
  
  public final void nN(String paramString)
  {
    this.field_parentRef = paramString;
    this.ewr = true;
  }
  
  public final void nO(String paramString)
  {
    this.field_editingMsg = paramString;
    this.epl = true;
  }
  
  public final void setContent(String paramString)
  {
    this.field_content = paramString;
    this.ekE = true;
  }
  
  public final void setStatus(int paramInt)
  {
    this.field_status = paramInt;
    this.ejO = true;
  }
  
  public final void setUsername(String paramString)
  {
    this.field_username = paramString;
    this.emb = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ay
 * JD-Core Version:    0.7.0.1
 */