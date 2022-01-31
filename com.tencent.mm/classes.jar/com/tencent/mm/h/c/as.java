package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class as
  extends c
{
  private static final int cDA;
  private static final int cDB;
  private static final int cDC;
  private static final int cDD;
  private static final int cDE;
  private static final int cDF = "sightTime".hashCode();
  private static final int cDG = "unReadMuteCount".hashCode();
  private static final int cDH = "lastSeq".hashCode();
  private static final int cDI = "UnDeliverCount".hashCode();
  private static final int cDJ = "UnReadInvite".hashCode();
  private static final int cDK = "firstUnDeliverSeq".hashCode();
  private static final int cDy;
  private static final int cDz;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int csD;
  private static final int ctF;
  private static final int cwU;
  private static final int cwY;
  private static final int cwZ;
  private static final int cwe;
  private static final int cxa;
  private static final int cxb;
  private static final int cxd;
  private static final int cxe;
  private static final int cxf = "msgCount".hashCode();
  private boolean cDl = false;
  private boolean cDm = false;
  private boolean cDn = false;
  public boolean cDo = false;
  private boolean cDp = false;
  private boolean cDq = false;
  private boolean cDr = false;
  public boolean cDs = false;
  private boolean cDt = false;
  private boolean cDu = false;
  private boolean cDv = false;
  private boolean cDw = false;
  private boolean cDx = false;
  private boolean crk = false;
  private boolean csf = false;
  private boolean ctD = false;
  private boolean cwG = false;
  private boolean cwK = false;
  private boolean cwL = false;
  private boolean cwM = false;
  private boolean cwN = false;
  private boolean cwP = false;
  private boolean cwQ = false;
  private boolean cwR = false;
  private boolean cwc = false;
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
  public long field_firstUnDeliverSeq;
  public long field_flag;
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
    ctF = "username".hashCode();
    cwU = "unReadCount".hashCode();
    cDy = "chatmode".hashCode();
    crn = "status".hashCode();
    cxd = "isSend".hashCode();
    cDz = "conversationTime".hashCode();
    csD = "content".hashCode();
    cxe = "msgType".hashCode();
    cDA = "customNotify".hashCode();
    cDB = "showTips".hashCode();
    cwe = "flag".hashCode();
    cwY = "digest".hashCode();
    cwZ = "digestUser".hashCode();
    cDC = "hasTrunc".hashCode();
    cDD = "parentRef".hashCode();
    cDE = "attrflag".hashCode();
    cxb = "editingMsg".hashCode();
    cxa = "atCount".hashCode();
  }
  
  public final void ba(long paramLong)
  {
    this.field_conversationTime = paramLong;
    this.cDm = true;
  }
  
  public final void bb(long paramLong)
  {
    this.field_flag = paramLong;
    this.cwc = true;
  }
  
  public final void bc(long paramLong)
  {
    this.field_lastSeq = paramLong;
    this.cDu = true;
  }
  
  public final void bd(long paramLong)
  {
    this.field_firstUnDeliverSeq = paramLong;
    this.cDx = true;
  }
  
  public final void d(Cursor paramCursor)
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
      if (cxf != k) {
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
      if (ctF == k)
      {
        this.field_username = paramCursor.getString(i);
        this.ctD = true;
      }
      else if (cwU == k)
      {
        this.field_unReadCount = paramCursor.getInt(i);
      }
      else if (cDy == k)
      {
        this.field_chatmode = paramCursor.getInt(i);
      }
      else if (crn == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (cxd == k)
      {
        this.field_isSend = paramCursor.getInt(i);
      }
      else if (cDz == k)
      {
        this.field_conversationTime = paramCursor.getLong(i);
      }
      else if (csD == k)
      {
        this.field_content = paramCursor.getString(i);
      }
      else if (cxe == k)
      {
        this.field_msgType = paramCursor.getString(i);
      }
      else if (cDA == k)
      {
        this.field_customNotify = paramCursor.getString(i);
      }
      else if (cDB == k)
      {
        this.field_showTips = paramCursor.getInt(i);
      }
      else if (cwe == k)
      {
        this.field_flag = paramCursor.getLong(i);
      }
      else if (cwY == k)
      {
        this.field_digest = paramCursor.getString(i);
      }
      else if (cwZ == k)
      {
        this.field_digestUser = paramCursor.getString(i);
      }
      else if (cDC == k)
      {
        this.field_hasTrunc = paramCursor.getInt(i);
      }
      else if (cDD == k)
      {
        this.field_parentRef = paramCursor.getString(i);
      }
      else if (cDE == k)
      {
        this.field_attrflag = paramCursor.getInt(i);
      }
      else if (cxb == k)
      {
        this.field_editingMsg = paramCursor.getString(i);
      }
      else if (cxa == k)
      {
        this.field_atCount = paramCursor.getInt(i);
      }
      else if (cDF == k)
      {
        this.field_sightTime = paramCursor.getLong(i);
      }
      else if (cDG == k)
      {
        this.field_unReadMuteCount = paramCursor.getInt(i);
      }
      else if (cDH == k)
      {
        this.field_lastSeq = paramCursor.getLong(i);
      }
      else if (cDI == k)
      {
        this.field_UnDeliverCount = paramCursor.getInt(i);
      }
      else if (cDJ == k)
      {
        this.field_UnReadInvite = paramCursor.getInt(i);
      }
      else if (cDK == k)
      {
        this.field_firstUnDeliverSeq = paramCursor.getLong(i);
      }
      else if (crh == k)
      {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final void dP(String paramString)
  {
    this.field_msgType = paramString;
    this.cwQ = true;
  }
  
  public final void dQ(String paramString)
  {
    this.field_digest = paramString;
    this.cwK = true;
  }
  
  public final void dR(String paramString)
  {
    this.field_digestUser = paramString;
    this.cwL = true;
  }
  
  public final void dS(String paramString)
  {
    this.field_parentRef = paramString;
    this.cDq = true;
  }
  
  public final void dT(String paramString)
  {
    this.field_editingMsg = paramString;
    this.cwN = true;
  }
  
  public final void fA(int paramInt)
  {
    this.field_isSend = paramInt;
    this.cwP = true;
  }
  
  public final void fB(int paramInt)
  {
    this.field_hasTrunc = paramInt;
    this.cDp = true;
  }
  
  public final void fC(int paramInt)
  {
    this.field_attrflag = paramInt;
    this.cDr = true;
  }
  
  public final void fD(int paramInt)
  {
    this.field_atCount = paramInt;
    this.cwM = true;
  }
  
  public final void fE(int paramInt)
  {
    this.field_unReadMuteCount = paramInt;
    this.cDt = true;
  }
  
  public final void fF(int paramInt)
  {
    this.field_UnDeliverCount = paramInt;
    this.cDv = true;
  }
  
  public final void fG(int paramInt)
  {
    this.field_UnReadInvite = paramInt;
    this.cDw = true;
  }
  
  public final void fx(int paramInt)
  {
    this.field_msgCount = paramInt;
    this.cwR = true;
  }
  
  public final void fy(int paramInt)
  {
    this.field_unReadCount = paramInt;
    this.cwG = true;
  }
  
  public final void fz(int paramInt)
  {
    this.field_chatmode = paramInt;
    this.cDl = true;
  }
  
  public final String getUsername()
  {
    return this.field_username;
  }
  
  public final void setContent(String paramString)
  {
    this.field_content = paramString;
    this.csf = true;
  }
  
  public final void setStatus(int paramInt)
  {
    this.field_status = paramInt;
    this.crk = true;
  }
  
  public final void setUsername(String paramString)
  {
    this.field_username = paramString;
    this.ctD = true;
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cwR) {
      localContentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
    }
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.ctD) {
      localContentValues.put("username", this.field_username);
    }
    if (this.cwG) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.cDl) {
      localContentValues.put("chatmode", Integer.valueOf(this.field_chatmode));
    }
    if (this.crk) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.cwP) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.cDm) {
      localContentValues.put("conversationTime", Long.valueOf(this.field_conversationTime));
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.csf) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_msgType == null) {
      this.field_msgType = "";
    }
    if (this.cwQ) {
      localContentValues.put("msgType", this.field_msgType);
    }
    if (this.field_customNotify == null) {
      this.field_customNotify = "";
    }
    if (this.cDn) {
      localContentValues.put("customNotify", this.field_customNotify);
    }
    if (this.cDo) {
      localContentValues.put("showTips", Integer.valueOf(this.field_showTips));
    }
    if (this.cwc) {
      localContentValues.put("flag", Long.valueOf(this.field_flag));
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.cwK) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.field_digestUser == null) {
      this.field_digestUser = "";
    }
    if (this.cwL) {
      localContentValues.put("digestUser", this.field_digestUser);
    }
    if (this.cDp) {
      localContentValues.put("hasTrunc", Integer.valueOf(this.field_hasTrunc));
    }
    if (this.cDq) {
      localContentValues.put("parentRef", this.field_parentRef);
    }
    if (this.cDr) {
      localContentValues.put("attrflag", Integer.valueOf(this.field_attrflag));
    }
    if (this.field_editingMsg == null) {
      this.field_editingMsg = "";
    }
    if (this.cwN) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.cwM) {
      localContentValues.put("atCount", Integer.valueOf(this.field_atCount));
    }
    if (this.cDs) {
      localContentValues.put("sightTime", Long.valueOf(this.field_sightTime));
    }
    if (this.cDt) {
      localContentValues.put("unReadMuteCount", Integer.valueOf(this.field_unReadMuteCount));
    }
    if (this.cDu) {
      localContentValues.put("lastSeq", Long.valueOf(this.field_lastSeq));
    }
    if (this.cDv) {
      localContentValues.put("UnDeliverCount", Integer.valueOf(this.field_UnDeliverCount));
    }
    if (this.cDw) {
      localContentValues.put("UnReadInvite", Integer.valueOf(this.field_UnReadInvite));
    }
    if (this.cDx) {
      localContentValues.put("firstUnDeliverSeq", Long.valueOf(this.field_firstUnDeliverSeq));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
  
  public final long vr()
  {
    return this.field_lastSeq;
  }
  
  public final int vs()
  {
    return this.field_UnDeliverCount;
  }
  
  public final long vt()
  {
    return this.field_firstUnDeliverSeq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.h.c.as
 * JD-Core Version:    0.7.0.1
 */