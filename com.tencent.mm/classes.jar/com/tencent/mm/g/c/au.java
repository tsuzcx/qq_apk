package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class au
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dfJ;
  private static final int dgT;
  private static final int dhU;
  private static final int dkV;
  private static final int dkZ;
  private static final int dkn;
  private static final int dla;
  private static final int dlb = "atCount".hashCode();
  private static final int dlc;
  private static final int dle;
  private static final int dlf;
  private static final int dlg = "msgCount".hashCode();
  private static final int drI;
  private static final int drJ;
  private static final int drK;
  private static final int drL;
  private static final int drM;
  private static final int drN;
  private static final int drO;
  private static final int drP = "sightTime".hashCode();
  private static final int drQ = "unReadMuteCount".hashCode();
  private static final int drR = "lastSeq".hashCode();
  private static final int drS = "UnDeliverCount".hashCode();
  private static final int drT = "UnReadInvite".hashCode();
  private static final int drU = "firstUnDeliverSeq".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dfG = false;
  private boolean dgw = false;
  private boolean dhS = false;
  private boolean dkH = false;
  private boolean dkL = false;
  private boolean dkM = false;
  private boolean dkN = false;
  private boolean dkO = false;
  private boolean dkQ = false;
  private boolean dkR = false;
  private boolean dkS = false;
  private boolean dkl = false;
  private boolean drA = false;
  private boolean drB = false;
  public boolean drC = false;
  private boolean drD = false;
  private boolean drE = false;
  private boolean drF = false;
  private boolean drG = false;
  private boolean drH = false;
  private boolean drv = false;
  private boolean drw = false;
  private boolean drx = false;
  public boolean dry = false;
  private boolean drz = false;
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
    dhU = "username".hashCode();
    dkV = "unReadCount".hashCode();
    drI = "chatmode".hashCode();
    dfJ = "status".hashCode();
    dle = "isSend".hashCode();
    drJ = "conversationTime".hashCode();
    dgT = "content".hashCode();
    dlf = "msgType".hashCode();
    drK = "customNotify".hashCode();
    drL = "showTips".hashCode();
    dkn = "flag".hashCode();
    dkZ = "digest".hashCode();
    dla = "digestUser".hashCode();
    drM = "hasTrunc".hashCode();
    drN = "parentRef".hashCode();
    drO = "attrflag".hashCode();
    dlc = "editingMsg".hashCode();
  }
  
  public final long Hw()
  {
    return this.field_lastSeq;
  }
  
  public final int Hx()
  {
    return this.field_UnDeliverCount;
  }
  
  public final long Hy()
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
      if (dlg != k) {
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
      if (dhU == k)
      {
        this.field_username = paramCursor.getString(i);
        this.dhS = true;
      }
      else if (dkV == k)
      {
        this.field_unReadCount = paramCursor.getInt(i);
      }
      else if (drI == k)
      {
        this.field_chatmode = paramCursor.getInt(i);
      }
      else if (dfJ == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (dle == k)
      {
        this.field_isSend = paramCursor.getInt(i);
      }
      else if (drJ == k)
      {
        this.field_conversationTime = paramCursor.getLong(i);
      }
      else if (dgT == k)
      {
        this.field_content = paramCursor.getString(i);
      }
      else if (dlf == k)
      {
        this.field_msgType = paramCursor.getString(i);
      }
      else if (drK == k)
      {
        this.field_customNotify = paramCursor.getString(i);
      }
      else if (drL == k)
      {
        this.field_showTips = paramCursor.getInt(i);
      }
      else if (dkn == k)
      {
        this.field_flag = paramCursor.getLong(i);
      }
      else if (dkZ == k)
      {
        this.field_digest = paramCursor.getString(i);
      }
      else if (dla == k)
      {
        this.field_digestUser = paramCursor.getString(i);
      }
      else if (drM == k)
      {
        this.field_hasTrunc = paramCursor.getInt(i);
      }
      else if (drN == k)
      {
        this.field_parentRef = paramCursor.getString(i);
      }
      else if (drO == k)
      {
        this.field_attrflag = paramCursor.getInt(i);
      }
      else if (dlc == k)
      {
        this.field_editingMsg = paramCursor.getString(i);
      }
      else if (dlb == k)
      {
        this.field_atCount = paramCursor.getInt(i);
      }
      else if (drP == k)
      {
        this.field_sightTime = paramCursor.getLong(i);
      }
      else if (drQ == k)
      {
        this.field_unReadMuteCount = paramCursor.getInt(i);
      }
      else if (drR == k)
      {
        this.field_lastSeq = paramCursor.getLong(i);
      }
      else if (drS == k)
      {
        this.field_UnDeliverCount = paramCursor.getInt(i);
      }
      else if (drT == k)
      {
        this.field_UnReadInvite = paramCursor.getInt(i);
      }
      else if (drU == k)
      {
        this.field_firstUnDeliverSeq = paramCursor.getLong(i);
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
    if (this.dkS) {
      localContentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
    }
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.dhS) {
      localContentValues.put("username", this.field_username);
    }
    if (this.dkH) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.drv) {
      localContentValues.put("chatmode", Integer.valueOf(this.field_chatmode));
    }
    if (this.dfG) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.dkQ) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.drw) {
      localContentValues.put("conversationTime", Long.valueOf(this.field_conversationTime));
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.dgw) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_msgType == null) {
      this.field_msgType = "";
    }
    if (this.dkR) {
      localContentValues.put("msgType", this.field_msgType);
    }
    if (this.field_customNotify == null) {
      this.field_customNotify = "";
    }
    if (this.drx) {
      localContentValues.put("customNotify", this.field_customNotify);
    }
    if (this.dry) {
      localContentValues.put("showTips", Integer.valueOf(this.field_showTips));
    }
    if (this.dkl) {
      localContentValues.put("flag", Long.valueOf(this.field_flag));
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.dkL) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.field_digestUser == null) {
      this.field_digestUser = "";
    }
    if (this.dkM) {
      localContentValues.put("digestUser", this.field_digestUser);
    }
    if (this.drz) {
      localContentValues.put("hasTrunc", Integer.valueOf(this.field_hasTrunc));
    }
    if (this.drA) {
      localContentValues.put("parentRef", this.field_parentRef);
    }
    if (this.drB) {
      localContentValues.put("attrflag", Integer.valueOf(this.field_attrflag));
    }
    if (this.field_editingMsg == null) {
      this.field_editingMsg = "";
    }
    if (this.dkO) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.dkN) {
      localContentValues.put("atCount", Integer.valueOf(this.field_atCount));
    }
    if (this.drC) {
      localContentValues.put("sightTime", Long.valueOf(this.field_sightTime));
    }
    if (this.drD) {
      localContentValues.put("unReadMuteCount", Integer.valueOf(this.field_unReadMuteCount));
    }
    if (this.drE) {
      localContentValues.put("lastSeq", Long.valueOf(this.field_lastSeq));
    }
    if (this.drF) {
      localContentValues.put("UnDeliverCount", Integer.valueOf(this.field_UnDeliverCount));
    }
    if (this.drG) {
      localContentValues.put("UnReadInvite", Integer.valueOf(this.field_UnReadInvite));
    }
    if (this.drH) {
      localContentValues.put("firstUnDeliverSeq", Long.valueOf(this.field_firstUnDeliverSeq));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public final void fK(long paramLong)
  {
    this.field_conversationTime = paramLong;
    this.drw = true;
  }
  
  public final void fL(long paramLong)
  {
    this.field_flag = paramLong;
    this.dkl = true;
  }
  
  public final void fM(long paramLong)
  {
    this.field_lastSeq = paramLong;
    this.drE = true;
  }
  
  public final void fN(long paramLong)
  {
    this.field_firstUnDeliverSeq = paramLong;
    this.drH = true;
  }
  
  public final String getUsername()
  {
    return this.field_username;
  }
  
  public final void hI(int paramInt)
  {
    this.field_msgCount = paramInt;
    this.dkS = true;
  }
  
  public final void hJ(int paramInt)
  {
    this.field_unReadCount = paramInt;
    this.dkH = true;
  }
  
  public final void hK(int paramInt)
  {
    this.field_chatmode = paramInt;
    this.drv = true;
  }
  
  public final void hL(int paramInt)
  {
    this.field_isSend = paramInt;
    this.dkQ = true;
  }
  
  public final void hM(int paramInt)
  {
    this.field_hasTrunc = paramInt;
    this.drz = true;
  }
  
  public final void hN(int paramInt)
  {
    this.field_attrflag = paramInt;
    this.drB = true;
  }
  
  public final void hO(int paramInt)
  {
    this.field_atCount = paramInt;
    this.dkN = true;
  }
  
  public final void hP(int paramInt)
  {
    this.field_unReadMuteCount = paramInt;
    this.drD = true;
  }
  
  public final void hQ(int paramInt)
  {
    this.field_UnDeliverCount = paramInt;
    this.drF = true;
  }
  
  public final void hR(int paramInt)
  {
    this.field_UnReadInvite = paramInt;
    this.drG = true;
  }
  
  public final void jV(String paramString)
  {
    this.field_msgType = paramString;
    this.dkR = true;
  }
  
  public final void jW(String paramString)
  {
    this.field_digest = paramString;
    this.dkL = true;
  }
  
  public final void jX(String paramString)
  {
    this.field_digestUser = paramString;
    this.dkM = true;
  }
  
  public final void jY(String paramString)
  {
    this.field_parentRef = paramString;
    this.drA = true;
  }
  
  public final void jZ(String paramString)
  {
    this.field_editingMsg = paramString;
    this.dkO = true;
  }
  
  public final void setContent(String paramString)
  {
    this.field_content = paramString;
    this.dgw = true;
  }
  
  public final void setStatus(int paramInt)
  {
    this.field_status = paramInt;
    this.dfG = true;
  }
  
  public final void setUsername(String paramString)
  {
    this.field_username = paramString;
    this.dhS = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.au
 * JD-Core Version:    0.7.0.1
 */