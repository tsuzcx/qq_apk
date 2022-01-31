package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.y;

public abstract class cs
  extends c
{
  private static final int cLO;
  private static final int cQA;
  private static final int cQB;
  private static final int cQC;
  private static final int cQD;
  private static final int cQE;
  private static final int cQz;
  public static final String[] cqY = new String[0];
  private static final int crg = "msgId".hashCode();
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int csD;
  private static final int csv;
  private static final int csy;
  private static final int cwS;
  private static final int cwe;
  private static final int cxd;
  private static final int czf = "msgSvrId".hashCode();
  private static final int czg;
  private static final int czh;
  private static final int czi;
  private static final int czj;
  private String bYN;
  private boolean cLI = false;
  public String cQF;
  public int cQG;
  public int cQH;
  public int cQI;
  public int cQJ;
  public int cQK;
  public int cQL;
  public String cQM;
  public String cQN;
  public String cQO;
  public int cQP;
  public byte[] cQQ;
  public boolean cQt = false;
  private boolean cQu = false;
  private boolean cQv = false;
  public boolean cQw = false;
  private boolean cQx = false;
  public boolean cQy = false;
  private boolean crX = false;
  private boolean crc = false;
  private boolean crk = false;
  private boolean csa = false;
  private boolean csf = false;
  private boolean cwE = false;
  private boolean cwP = false;
  private boolean cwc = false;
  private boolean cyU = false;
  private boolean cyV = false;
  private boolean cyW = false;
  public boolean cyX = false;
  public boolean cyY = false;
  public int czq;
  public String czr;
  public long field_bizChatId;
  public String field_bizChatUserId;
  private String field_bizClientMsgId;
  public String field_content;
  public long field_createTime;
  public int field_flag;
  public String field_imgPath;
  public int field_isSend;
  public int field_isShowTimer;
  public byte[] field_lvbuffer;
  public long field_msgId;
  public long field_msgSeq;
  public long field_msgSvrId;
  public String field_reserved;
  public int field_status;
  public String field_talker;
  public int field_talkerId;
  public String field_transBrandWording;
  public String field_transContent;
  private int field_type;
  
  static
  {
    csy = "type".hashCode();
    crn = "status".hashCode();
    cxd = "isSend".hashCode();
    cQz = "isShowTimer".hashCode();
    csv = "createTime".hashCode();
    czg = "talker".hashCode();
    csD = "content".hashCode();
    czh = "imgPath".hashCode();
    cQA = "reserved".hashCode();
    czi = "lvbuffer".hashCode();
    czj = "talkerId".hashCode();
    cQB = "transContent".hashCode();
    cQC = "transBrandWording".hashCode();
    cQD = "bizClientMsgId".hashCode();
    cwS = "bizChatId".hashCode();
    cQE = "bizChatUserId".hashCode();
    cLO = "msgSeq".hashCode();
    cwe = "flag".hashCode();
  }
  
  public final void bf(long paramLong)
  {
    this.field_msgSvrId = paramLong;
    this.cyU = true;
  }
  
  public final void bg(long paramLong)
  {
    this.field_createTime = paramLong;
    this.crX = true;
  }
  
  public final void bh(long paramLong)
  {
    this.field_bizChatId = paramLong;
    this.cwE = true;
  }
  
  public final void bi(long paramLong)
  {
    this.field_msgSeq = paramLong;
    this.cLI = true;
  }
  
  public final void cY(String paramString)
  {
    this.czr = paramString;
    this.cyX = true;
  }
  
  public void d(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {}
    do
    {
      for (;;)
      {
        return;
        int i = 0;
        int j = arrayOfString.length;
        if (i < j)
        {
          int k = arrayOfString[i].hashCode();
          if (crg == k)
          {
            this.field_msgId = paramCursor.getLong(i);
            this.crc = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (czf == k) {
              this.field_msgSvrId = paramCursor.getLong(i);
            } else if (csy == k) {
              this.field_type = paramCursor.getInt(i);
            } else if (crn == k) {
              this.field_status = paramCursor.getInt(i);
            } else if (cxd == k) {
              this.field_isSend = paramCursor.getInt(i);
            } else if (cQz == k) {
              this.field_isShowTimer = paramCursor.getInt(i);
            } else if (csv == k) {
              this.field_createTime = paramCursor.getLong(i);
            } else if (czg == k) {
              this.field_talker = paramCursor.getString(i);
            } else if (csD == k) {
              this.field_content = paramCursor.getString(i);
            } else if (czh == k) {
              this.field_imgPath = paramCursor.getString(i);
            } else if (cQA == k) {
              this.field_reserved = paramCursor.getString(i);
            } else if (czi == k) {
              this.field_lvbuffer = paramCursor.getBlob(i);
            } else if (czj == k) {
              this.field_talkerId = paramCursor.getInt(i);
            } else if (cQB == k) {
              this.field_transContent = paramCursor.getString(i);
            } else if (cQC == k) {
              this.field_transBrandWording = paramCursor.getString(i);
            } else if (cQD == k) {
              this.field_bizClientMsgId = paramCursor.getString(i);
            } else if (cwS == k) {
              this.field_bizChatId = paramCursor.getLong(i);
            } else if (cQE == k) {
              this.field_bizChatUserId = paramCursor.getString(i);
            } else if (cLO == k) {
              this.field_msgSeq = paramCursor.getLong(i);
            } else if (cwe == k) {
              this.field_flag = paramCursor.getInt(i);
            } else if (crh == k) {
              this.ujK = paramCursor.getLong(i);
            }
          }
        }
        try
        {
          if ((this.field_lvbuffer != null) && (this.field_lvbuffer.length != 0))
          {
            paramCursor = new v();
            i = paramCursor.bA(this.field_lvbuffer);
            if (i != 0)
            {
              y.e("MicroMsg.SDK.BaseMsgInfo", "parse LVBuffer error:" + i);
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          y.e("MicroMsg.SDK.BaseMsgInfo", "get value failed");
          return;
        }
      }
      if (!paramCursor.cqx()) {
        this.cQF = paramCursor.getString();
      }
      if (!paramCursor.cqx()) {
        this.czq = paramCursor.getInt();
      }
      if (!paramCursor.cqx()) {
        this.czr = paramCursor.getString();
      }
      if (!paramCursor.cqx()) {
        this.cQG = paramCursor.getInt();
      }
      if (!paramCursor.cqx()) {
        this.cQH = paramCursor.getInt();
      }
      if (!paramCursor.cqx()) {
        this.cQI = paramCursor.getInt();
      }
      if (!paramCursor.cqx()) {
        this.cQJ = paramCursor.getInt();
      }
      if (!paramCursor.cqx()) {
        this.cQK = paramCursor.getInt();
      }
      if (!paramCursor.cqx()) {
        this.cQL = paramCursor.getInt();
      }
      if (!paramCursor.cqx()) {
        this.cQM = paramCursor.getString();
      }
      if (!paramCursor.cqx()) {
        this.cQN = paramCursor.getString();
      }
      if (!paramCursor.cqx()) {
        this.cQO = paramCursor.getString();
      }
      if (!paramCursor.cqx()) {
        this.cQP = paramCursor.getInt();
      }
      if (!paramCursor.cqx()) {
        this.bYN = paramCursor.getString();
      }
    } while (paramCursor.cqx());
    this.cQQ = paramCursor.getBuffer();
  }
  
  public final void ec(String paramString)
  {
    this.field_talker = paramString;
    this.cyV = true;
  }
  
  public final void ed(String paramString)
  {
    this.field_imgPath = paramString;
    this.cyW = true;
  }
  
  public final void ee(String paramString)
  {
    this.field_reserved = paramString;
    this.cQu = true;
  }
  
  public final void ef(String paramString)
  {
    this.field_transContent = paramString;
    this.cQv = true;
  }
  
  public final void eg(String paramString)
  {
    this.field_bizClientMsgId = paramString;
    this.cQx = true;
  }
  
  public final void eh(String paramString)
  {
    this.cQF = paramString;
    this.cyX = true;
  }
  
  public final void ei(String paramString)
  {
    this.cQN = paramString;
    this.cyX = true;
  }
  
  public final void ej(String paramString)
  {
    this.cQO = paramString;
    this.cyX = true;
  }
  
  public final void fA(int paramInt)
  {
    this.field_isSend = paramInt;
    this.cwP = true;
  }
  
  public final void fJ(int paramInt)
  {
    this.field_flag = paramInt;
    this.cwc = true;
  }
  
  public final void fK(int paramInt)
  {
    this.cQG = paramInt;
    this.cyX = true;
  }
  
  public final void fL(int paramInt)
  {
    this.cQH = paramInt;
    this.cyX = true;
  }
  
  public final void fM(int paramInt)
  {
    this.cQL = paramInt;
    this.cyX = true;
  }
  
  public final void fN(int paramInt)
  {
    this.cQP = paramInt;
    this.cyX = true;
  }
  
  public final void ff(int paramInt)
  {
    this.czq = paramInt;
    this.cyX = true;
  }
  
  public final String getContent()
  {
    return this.field_content;
  }
  
  public int getType()
  {
    return this.field_type;
  }
  
  public final void setContent(String paramString)
  {
    this.field_content = paramString;
    this.csf = true;
  }
  
  public final void setMsgId(long paramLong)
  {
    this.field_msgId = paramLong;
    this.crc = true;
  }
  
  public void setStatus(int paramInt)
  {
    this.field_status = paramInt;
    this.crk = true;
  }
  
  public final void setType(int paramInt)
  {
    this.field_type = paramInt;
    this.csa = true;
  }
  
  public ContentValues vf()
  {
    try
    {
      if (this.cyX)
      {
        localObject = new v();
        ((v)localObject).cqy();
        ((v)localObject).Zg(this.cQF);
        ((v)localObject).Fb(this.czq);
        ((v)localObject).Zg(this.czr);
        ((v)localObject).Fb(this.cQG);
        ((v)localObject).Fb(this.cQH);
        ((v)localObject).Fb(this.cQI);
        ((v)localObject).Fb(this.cQJ);
        ((v)localObject).Fb(this.cQK);
        ((v)localObject).Fb(this.cQL);
        ((v)localObject).Zg(this.cQM);
        ((v)localObject).Zg(this.cQN);
        ((v)localObject).Zg(this.cQO);
        ((v)localObject).Fb(this.cQP);
        ((v)localObject).Zg(this.bYN);
        ((v)localObject).bB(this.cQQ);
        this.field_lvbuffer = ((v)localObject).cqz();
      }
      Object localObject = new ContentValues();
      if (this.crc) {
        ((ContentValues)localObject).put("msgId", Long.valueOf(this.field_msgId));
      }
      if (this.cyU) {
        ((ContentValues)localObject).put("msgSvrId", Long.valueOf(this.field_msgSvrId));
      }
      if (this.csa) {
        ((ContentValues)localObject).put("type", Integer.valueOf(this.field_type));
      }
      if (this.crk) {
        ((ContentValues)localObject).put("status", Integer.valueOf(this.field_status));
      }
      if (this.cwP) {
        ((ContentValues)localObject).put("isSend", Integer.valueOf(this.field_isSend));
      }
      if (this.cQt) {
        ((ContentValues)localObject).put("isShowTimer", Integer.valueOf(this.field_isShowTimer));
      }
      if (this.crX) {
        ((ContentValues)localObject).put("createTime", Long.valueOf(this.field_createTime));
      }
      if (this.cyV) {
        ((ContentValues)localObject).put("talker", this.field_talker);
      }
      if (this.field_content == null) {
        this.field_content = "";
      }
      if (this.csf) {
        ((ContentValues)localObject).put("content", this.field_content);
      }
      if (this.cyW) {
        ((ContentValues)localObject).put("imgPath", this.field_imgPath);
      }
      if (this.cQu) {
        ((ContentValues)localObject).put("reserved", this.field_reserved);
      }
      if (this.cyX) {
        ((ContentValues)localObject).put("lvbuffer", this.field_lvbuffer);
      }
      if (this.cyY) {
        ((ContentValues)localObject).put("talkerId", Integer.valueOf(this.field_talkerId));
      }
      if (this.field_transContent == null) {
        this.field_transContent = "";
      }
      if (this.cQv) {
        ((ContentValues)localObject).put("transContent", this.field_transContent);
      }
      if (this.field_transBrandWording == null) {
        this.field_transBrandWording = "";
      }
      if (this.cQw) {
        ((ContentValues)localObject).put("transBrandWording", this.field_transBrandWording);
      }
      if (this.field_bizClientMsgId == null) {
        this.field_bizClientMsgId = "";
      }
      if (this.cQx) {
        ((ContentValues)localObject).put("bizClientMsgId", this.field_bizClientMsgId);
      }
      if (this.cwE) {
        ((ContentValues)localObject).put("bizChatId", Long.valueOf(this.field_bizChatId));
      }
      if (this.field_bizChatUserId == null) {
        this.field_bizChatUserId = "";
      }
      if (this.cQy) {
        ((ContentValues)localObject).put("bizChatUserId", this.field_bizChatUserId);
      }
      if (this.cLI) {
        ((ContentValues)localObject).put("msgSeq", Long.valueOf(this.field_msgSeq));
      }
      if (this.cwc) {
        ((ContentValues)localObject).put("flag", Integer.valueOf(this.field_flag));
      }
      if (this.ujK > 0L) {
        ((ContentValues)localObject).put("rowid", Long.valueOf(this.ujK));
      }
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.SDK.BaseMsgInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final long vu()
  {
    return this.field_msgSvrId;
  }
  
  public final int vv()
  {
    return this.field_isSend;
  }
  
  public final long vw()
  {
    return this.field_createTime;
  }
  
  public final String vx()
  {
    return this.field_talker;
  }
  
  public final void w(byte[] paramArrayOfByte)
  {
    this.field_lvbuffer = paramArrayOfByte;
    this.cyX = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.h.c.cs
 * JD-Core Version:    0.7.0.1
 */