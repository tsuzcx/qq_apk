package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bb
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int content_HASHCODE;
  private static final int fjl;
  private static final int fnV;
  private static final int fnZ;
  private static final int fni;
  private static final int foa;
  private static final int fob = "atCount".hashCode();
  private static final int foc;
  private static final int foe;
  private static final int fof;
  private static final int fog = "msgCount".hashCode();
  private static final int fvL;
  private static final int fvM;
  private static final int fvN;
  private static final int fvO;
  private static final int fvP;
  private static final int fvQ;
  private static final int fvR;
  private static final int fvS = "sightTime".hashCode();
  private static final int fvT = "unReadMuteCount".hashCode();
  private static final int fvU = "lastSeq".hashCode();
  private static final int fvV = "UnDeliverCount".hashCode();
  private static final int fvW = "UnReadInvite".hashCode();
  private static final int fvX = "firstUnDeliverSeq".hashCode();
  private static final int fvY = "editingQuoteMsgId".hashCode();
  private static final int fvZ = "hasTodo".hashCode();
  private static final int fwa = "hbMarkRed".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE = "username".hashCode();
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
  public int field_showTips;
  public long field_sightTime;
  public int field_status;
  public int field_unReadCount;
  public int field_unReadMuteCount;
  public String field_username;
  private boolean fji = false;
  private boolean fnG = false;
  private boolean fnK = false;
  private boolean fnL = false;
  private boolean fnM = false;
  private boolean fnN = false;
  private boolean fnP = false;
  private boolean fnQ = false;
  private boolean fnR = false;
  private boolean fng = false;
  private boolean fvA = false;
  private boolean fvB = false;
  public boolean fvC = false;
  private boolean fvD = false;
  private boolean fvE = false;
  private boolean fvF = false;
  private boolean fvG = false;
  private boolean fvH = false;
  public boolean fvI = false;
  private boolean fvJ = false;
  private boolean fvK = false;
  private boolean fvv = false;
  private boolean fvw = false;
  private boolean fvx = false;
  public boolean fvy = false;
  private boolean fvz = false;
  
  static
  {
    fnV = "unReadCount".hashCode();
    fvL = "chatmode".hashCode();
    fjl = "status".hashCode();
    foe = "isSend".hashCode();
    fvM = "conversationTime".hashCode();
    content_HASHCODE = "content".hashCode();
    fof = "msgType".hashCode();
    fvN = "customNotify".hashCode();
    fvO = "showTips".hashCode();
    fni = "flag".hashCode();
    fnZ = "digest".hashCode();
    foa = "digestUser".hashCode();
    fvP = "hasTrunc".hashCode();
    fvQ = "parentRef".hashCode();
    fvR = "attrflag".hashCode();
    foc = "editingMsg".hashCode();
  }
  
  public final void Cl(String paramString)
  {
    this.field_msgType = paramString;
    this.fnQ = true;
  }
  
  public final void Cm(String paramString)
  {
    this.field_digest = paramString;
    this.fnK = true;
  }
  
  public final void Cn(String paramString)
  {
    this.field_digestUser = paramString;
    this.fnL = true;
  }
  
  public final void Co(String paramString)
  {
    this.field_parentRef = paramString;
    this.fvA = true;
  }
  
  public final void Cp(String paramString)
  {
    this.field_editingMsg = paramString;
    this.fnN = true;
  }
  
  public final int ajG()
  {
    return this.field_unReadCount;
  }
  
  public final int ajH()
  {
    return this.field_unReadMuteCount;
  }
  
  public final long ajI()
  {
    return this.field_lastSeq;
  }
  
  public final int ajJ()
  {
    return this.field_UnDeliverCount;
  }
  
  public final long ajK()
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
      if (fog != k) {
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
      else if (fnV == k)
      {
        this.field_unReadCount = paramCursor.getInt(i);
      }
      else if (fvL == k)
      {
        this.field_chatmode = paramCursor.getInt(i);
      }
      else if (fjl == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else if (foe == k)
      {
        this.field_isSend = paramCursor.getInt(i);
      }
      else if (fvM == k)
      {
        this.field_conversationTime = paramCursor.getLong(i);
      }
      else if (content_HASHCODE == k)
      {
        this.field_content = paramCursor.getString(i);
      }
      else if (fof == k)
      {
        this.field_msgType = paramCursor.getString(i);
      }
      else if (fvN == k)
      {
        this.field_customNotify = paramCursor.getString(i);
      }
      else if (fvO == k)
      {
        this.field_showTips = paramCursor.getInt(i);
      }
      else if (fni == k)
      {
        this.field_flag = paramCursor.getLong(i);
      }
      else if (fnZ == k)
      {
        this.field_digest = paramCursor.getString(i);
      }
      else if (foa == k)
      {
        this.field_digestUser = paramCursor.getString(i);
      }
      else if (fvP == k)
      {
        this.field_hasTrunc = paramCursor.getInt(i);
      }
      else if (fvQ == k)
      {
        this.field_parentRef = paramCursor.getString(i);
      }
      else if (fvR == k)
      {
        this.field_attrflag = paramCursor.getInt(i);
      }
      else if (foc == k)
      {
        this.field_editingMsg = paramCursor.getString(i);
      }
      else if (fob == k)
      {
        this.field_atCount = paramCursor.getInt(i);
      }
      else if (fvS == k)
      {
        this.field_sightTime = paramCursor.getLong(i);
      }
      else if (fvT == k)
      {
        this.field_unReadMuteCount = paramCursor.getInt(i);
      }
      else if (fvU == k)
      {
        this.field_lastSeq = paramCursor.getLong(i);
      }
      else if (fvV == k)
      {
        this.field_UnDeliverCount = paramCursor.getInt(i);
      }
      else if (fvW == k)
      {
        this.field_UnReadInvite = paramCursor.getInt(i);
      }
      else if (fvX == k)
      {
        this.field_firstUnDeliverSeq = paramCursor.getLong(i);
      }
      else if (fvY == k)
      {
        this.field_editingQuoteMsgId = paramCursor.getLong(i);
      }
      else if (fvZ == k)
      {
        this.field_hasTodo = paramCursor.getInt(i);
      }
      else if (fwa == k)
      {
        this.field_hbMarkRed = paramCursor.getInt(i);
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
    if (this.fnR) {
      localContentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
    }
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.fnG) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.fvv) {
      localContentValues.put("chatmode", Integer.valueOf(this.field_chatmode));
    }
    if (this.fji) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fnP) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.fvw) {
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
    if (this.fnQ) {
      localContentValues.put("msgType", this.field_msgType);
    }
    if (this.field_customNotify == null) {
      this.field_customNotify = "";
    }
    if (this.fvx) {
      localContentValues.put("customNotify", this.field_customNotify);
    }
    if (this.fvy) {
      localContentValues.put("showTips", Integer.valueOf(this.field_showTips));
    }
    if (this.fng) {
      localContentValues.put("flag", Long.valueOf(this.field_flag));
    }
    if (this.field_digest == null) {
      this.field_digest = "";
    }
    if (this.fnK) {
      localContentValues.put("digest", this.field_digest);
    }
    if (this.field_digestUser == null) {
      this.field_digestUser = "";
    }
    if (this.fnL) {
      localContentValues.put("digestUser", this.field_digestUser);
    }
    if (this.fvz) {
      localContentValues.put("hasTrunc", Integer.valueOf(this.field_hasTrunc));
    }
    if (this.fvA) {
      localContentValues.put("parentRef", this.field_parentRef);
    }
    if (this.fvB) {
      localContentValues.put("attrflag", Integer.valueOf(this.field_attrflag));
    }
    if (this.field_editingMsg == null) {
      this.field_editingMsg = "";
    }
    if (this.fnN) {
      localContentValues.put("editingMsg", this.field_editingMsg);
    }
    if (this.fnM) {
      localContentValues.put("atCount", Integer.valueOf(this.field_atCount));
    }
    if (this.fvC) {
      localContentValues.put("sightTime", Long.valueOf(this.field_sightTime));
    }
    if (this.fvD) {
      localContentValues.put("unReadMuteCount", Integer.valueOf(this.field_unReadMuteCount));
    }
    if (this.fvE) {
      localContentValues.put("lastSeq", Long.valueOf(this.field_lastSeq));
    }
    if (this.fvF) {
      localContentValues.put("UnDeliverCount", Integer.valueOf(this.field_UnDeliverCount));
    }
    if (this.fvG) {
      localContentValues.put("UnReadInvite", Integer.valueOf(this.field_UnReadInvite));
    }
    if (this.fvH) {
      localContentValues.put("firstUnDeliverSeq", Long.valueOf(this.field_firstUnDeliverSeq));
    }
    if (this.fvI) {
      localContentValues.put("editingQuoteMsgId", Long.valueOf(this.field_editingQuoteMsgId));
    }
    if (this.fvJ) {
      localContentValues.put("hasTodo", Integer.valueOf(this.field_hasTodo));
    }
    if (this.fvK) {
      localContentValues.put("hbMarkRed", Integer.valueOf(this.field_hbMarkRed));
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
  
  public final void nA(int paramInt)
  {
    this.field_UnDeliverCount = paramInt;
    this.fvF = true;
  }
  
  public final void nB(int paramInt)
  {
    this.field_UnReadInvite = paramInt;
    this.fvG = true;
  }
  
  public final void nC(int paramInt)
  {
    this.field_hasTodo = paramInt;
    this.fvJ = true;
  }
  
  public final void nD(int paramInt)
  {
    this.field_hbMarkRed = paramInt;
    this.fvK = true;
  }
  
  public final void ns(int paramInt)
  {
    this.field_msgCount = paramInt;
    this.fnR = true;
  }
  
  public final void nt(int paramInt)
  {
    this.field_unReadCount = paramInt;
    this.fnG = true;
  }
  
  public final void nu(int paramInt)
  {
    this.field_chatmode = paramInt;
    this.fvv = true;
  }
  
  public final void nv(int paramInt)
  {
    this.field_isSend = paramInt;
    this.fnP = true;
  }
  
  public final void nw(int paramInt)
  {
    this.field_hasTrunc = paramInt;
    this.fvz = true;
  }
  
  public final void nx(int paramInt)
  {
    this.field_attrflag = paramInt;
    this.fvB = true;
  }
  
  public final void ny(int paramInt)
  {
    this.field_atCount = paramInt;
    this.fnM = true;
  }
  
  public final void nz(int paramInt)
  {
    this.field_unReadMuteCount = paramInt;
    this.fvD = true;
  }
  
  public final void setContent(String paramString)
  {
    this.field_content = paramString;
    this.__hadSetcontent = true;
  }
  
  public final void setStatus(int paramInt)
  {
    this.field_status = paramInt;
    this.fji = true;
  }
  
  public final void setUsername(String paramString)
  {
    this.field_username = paramString;
    this.__hadSetusername = true;
  }
  
  public final void yA(long paramLong)
  {
    this.field_conversationTime = paramLong;
    this.fvw = true;
  }
  
  public void yB(long paramLong)
  {
    this.field_flag = paramLong;
    this.fng = true;
  }
  
  public final void yC(long paramLong)
  {
    this.field_lastSeq = paramLong;
    this.fvE = true;
  }
  
  public final void yD(long paramLong)
  {
    this.field_firstUnDeliverSeq = paramLong;
    this.fvH = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bb
 * JD-Core Version:    0.7.0.1
 */