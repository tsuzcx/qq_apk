package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class az
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int elV;
  private static final int eng;
  private static final int eok;
  private static final int eqO;
  private static final int erB;
  private static final int erC;
  private static final int erD = "atCount".hashCode();
  private static final int erE;
  private static final int erG;
  private static final int erH;
  private static final int erI = "msgCount".hashCode();
  private static final int erx;
  private static final int eyY;
  private static final int eyZ;
  private static final int eza;
  private static final int ezb;
  private static final int ezc;
  private static final int ezd;
  private static final int eze;
  private static final int ezf = "sightTime".hashCode();
  private static final int ezg = "unReadMuteCount".hashCode();
  private static final int ezh = "lastSeq".hashCode();
  private static final int ezi = "UnDeliverCount".hashCode();
  private static final int ezj = "UnReadInvite".hashCode();
  private static final int ezk = "firstUnDeliverSeq".hashCode();
  private static final int ezl = "editingQuoteMsgId".hashCode();
  private static final int ezm = "hasTodo".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean elS = false;
  private boolean emI = false;
  private boolean eoh = false;
  private boolean eqM = false;
  private boolean eri = false;
  private boolean erm = false;
  private boolean ern = false;
  private boolean ero = false;
  private boolean erp = false;
  private boolean err = false;
  private boolean ers = false;
  private boolean ert = false;
  private boolean eyJ = false;
  private boolean eyK = false;
  private boolean eyL = false;
  public boolean eyM = false;
  private boolean eyN = false;
  private boolean eyO = false;
  private boolean eyP = false;
  public boolean eyQ = false;
  private boolean eyR = false;
  private boolean eyS = false;
  private boolean eyT = false;
  private boolean eyU = false;
  private boolean eyV = false;
  public boolean eyW = false;
  private boolean eyX = false;
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
    eok = "username".hashCode();
    erx = "unReadCount".hashCode();
    eyY = "chatmode".hashCode();
    elV = "status".hashCode();
    erG = "isSend".hashCode();
    eyZ = "conversationTime".hashCode();
    eng = "content".hashCode();
    erH = "msgType".hashCode();
    eza = "customNotify".hashCode();
    ezb = "showTips".hashCode();
    eqO = "flag".hashCode();
    erB = "digest".hashCode();
    erC = "digestUser".hashCode();
    ezc = "hasTrunc".hashCode();
    ezd = "parentRef".hashCode();
    eze = "attrflag".hashCode();
    erE = "editingMsg".hashCode();
  }
  
  public final int Tv()
  {
    return this.field_unReadCount;
  }
  
  public final long Tw()
  {
    return this.field_lastSeq;
  }
  
  public final int Tx()
  {
    return this.field_UnDeliverCount;
  }
  
  public final long Ty()
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
      if (erI != k) {
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
      if (eok == k)
      {
        this.field_username = paramCursor.getString(i);
        this.eoh = true;
      }
      else if (erx == k)
      {
        this.field_unReadCount = paramCursor.getInt(i);
      }
      else if (eyY == k)
      {
        this.field_chatmode = paramCursor.getInt(i);
      }
      else if (elV == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (erG == k)
      {
        this.field_isSend = paramCursor.getInt(i);
      }
      else if (eyZ == k)
      {
        this.field_conversationTime = paramCursor.getLong(i);
      }
      else if (eng == k)
      {
        this.field_content = paramCursor.getString(i);
      }
      else if (erH == k)
      {
        this.field_msgType = paramCursor.getString(i);
      }
      else if (eza == k)
      {
        this.field_customNotify = paramCursor.getString(i);
      }
      else if (ezb == k)
      {
        this.field_showTips = paramCursor.getInt(i);
      }
      else if (eqO == k)
      {
        this.field_flag = paramCursor.getLong(i);
      }
      else if (erB == k)
      {
        this.field_digest = paramCursor.getString(i);
      }
      else if (erC == k)
      {
        this.field_digestUser = paramCursor.getString(i);
      }
      else if (ezc == k)
      {
        this.field_hasTrunc = paramCursor.getInt(i);
      }
      else if (ezd == k)
      {
        this.field_parentRef = paramCursor.getString(i);
      }
      else if (eze == k)
      {
        this.field_attrflag = paramCursor.getInt(i);
      }
      else if (erE == k)
      {
        this.field_editingMsg = paramCursor.getString(i);
      }
      else if (erD == k)
      {
        this.field_atCount = paramCursor.getInt(i);
      }
      else if (ezf == k)
      {
        this.field_sightTime = paramCursor.getLong(i);
      }
      else if (ezg == k)
      {
        this.field_unReadMuteCount = paramCursor.getInt(i);
      }
      else if (ezh == k)
      {
        this.field_lastSeq = paramCursor.getLong(i);
      }
      else if (ezi == k)
      {
        this.field_UnDeliverCount = paramCursor.getInt(i);
      }
      else if (ezj == k)
      {
        this.field_UnReadInvite = paramCursor.getInt(i);
      }
      else if (ezk == k)
      {
        this.field_firstUnDeliverSeq = paramCursor.getLong(i);
      }
      else if (ezl == k)
      {
        this.field_editingQuoteMsgId = paramCursor.getLong(i);
      }
      else if (ezm == k)
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
    if (this.ert) {
      localContentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
    }
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.eoh) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eri) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.eyJ) {
      localContentValues.put("chatmode", Integer.valueOf(this.field_chatmode));
    }
    if (this.elS) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.err) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.eyK) {
      localContentValues.put("conversationTime", Long.valueOf(this.field_conversationTime));
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.emI) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_msgType == null) {
      this.field_msgType = "";
    }
    if (this.ers) {
      localContentValues.put("msgType", this.field_msgType);
    }
    if (this.field_customNotify == null) {
      this.field_customNotify = "";
    }
    if (this.eyL) {
      localContentValues.put("customNotify", this.field_customNotify);
    }
    if (this.eyM) {
      localContentValues.put("showTips", Integer.valueOf(this.field_showTips));
    }
    if (this.eqM) {
      localContentValues.put("flag", Long.valueOf(this.field_flag));
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.erm) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.field_digestUser == null) {
      this.field_digestUser = "";
    }
    if (this.ern) {
      localContentValues.put("digestUser", this.field_digestUser);
    }
    if (this.eyN) {
      localContentValues.put("hasTrunc", Integer.valueOf(this.field_hasTrunc));
    }
    if (this.eyO) {
      localContentValues.put("parentRef", this.field_parentRef);
    }
    if (this.eyP) {
      localContentValues.put("attrflag", Integer.valueOf(this.field_attrflag));
    }
    if (this.field_editingMsg == null) {
      this.field_editingMsg = "";
    }
    if (this.erp) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.ero) {
      localContentValues.put("atCount", Integer.valueOf(this.field_atCount));
    }
    if (this.eyQ) {
      localContentValues.put("sightTime", Long.valueOf(this.field_sightTime));
    }
    if (this.eyR) {
      localContentValues.put("unReadMuteCount", Integer.valueOf(this.field_unReadMuteCount));
    }
    if (this.eyS) {
      localContentValues.put("lastSeq", Long.valueOf(this.field_lastSeq));
    }
    if (this.eyT) {
      localContentValues.put("UnDeliverCount", Integer.valueOf(this.field_UnDeliverCount));
    }
    if (this.eyU) {
      localContentValues.put("UnReadInvite", Integer.valueOf(this.field_UnReadInvite));
    }
    if (this.eyV) {
      localContentValues.put("firstUnDeliverSeq", Long.valueOf(this.field_firstUnDeliverSeq));
    }
    if (this.eyW) {
      localContentValues.put("editingQuoteMsgId", Long.valueOf(this.field_editingQuoteMsgId));
    }
    if (this.eyX) {
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
  
  public final void jQ(int paramInt)
  {
    this.field_msgCount = paramInt;
    this.ert = true;
  }
  
  public final void jR(int paramInt)
  {
    this.field_unReadCount = paramInt;
    this.eri = true;
  }
  
  public final void jS(int paramInt)
  {
    this.field_chatmode = paramInt;
    this.eyJ = true;
  }
  
  public final void jT(int paramInt)
  {
    this.field_isSend = paramInt;
    this.err = true;
  }
  
  public final void jU(int paramInt)
  {
    this.field_hasTrunc = paramInt;
    this.eyN = true;
  }
  
  public final void jV(int paramInt)
  {
    this.field_attrflag = paramInt;
    this.eyP = true;
  }
  
  public final void jW(int paramInt)
  {
    this.field_atCount = paramInt;
    this.ero = true;
  }
  
  public final void jX(int paramInt)
  {
    this.field_unReadMuteCount = paramInt;
    this.eyR = true;
  }
  
  public final void jY(int paramInt)
  {
    this.field_UnDeliverCount = paramInt;
    this.eyT = true;
  }
  
  public final void jZ(int paramInt)
  {
    this.field_UnReadInvite = paramInt;
    this.eyU = true;
  }
  
  public final void ka(int paramInt)
  {
    this.field_hasTodo = paramInt;
    this.eyX = true;
  }
  
  public final void ou(long paramLong)
  {
    this.field_conversationTime = paramLong;
    this.eyK = true;
  }
  
  public void ov(long paramLong)
  {
    this.field_flag = paramLong;
    this.eqM = true;
  }
  
  public final void ow(long paramLong)
  {
    this.field_lastSeq = paramLong;
    this.eyS = true;
  }
  
  public final void ox(long paramLong)
  {
    this.field_firstUnDeliverSeq = paramLong;
    this.eyV = true;
  }
  
  public final void qQ(String paramString)
  {
    this.field_msgType = paramString;
    this.ers = true;
  }
  
  public final void qR(String paramString)
  {
    this.field_digest = paramString;
    this.erm = true;
  }
  
  public final void qS(String paramString)
  {
    this.field_digestUser = paramString;
    this.ern = true;
  }
  
  public final void qT(String paramString)
  {
    this.field_parentRef = paramString;
    this.eyO = true;
  }
  
  public final void qU(String paramString)
  {
    this.field_editingMsg = paramString;
    this.erp = true;
  }
  
  public final void setContent(String paramString)
  {
    this.field_content = paramString;
    this.emI = true;
  }
  
  public final void setStatus(int paramInt)
  {
    this.field_status = paramInt;
    this.elS = true;
  }
  
  public final void setUsername(String paramString)
  {
    this.field_username = paramString;
    this.eoh = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.az
 * JD-Core Version:    0.7.0.1
 */