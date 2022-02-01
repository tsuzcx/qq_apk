package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.bwh;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;

public abstract class ei
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEF = "msgId".hashCode();
  private static final int eEL;
  private static final int eFO;
  private static final int eFV;
  private static final int eJG;
  private static final int eKn;
  private static final int eKy;
  private static final int eMO = "msgSvrId".hashCode();
  private static final int eMP;
  private static final int eMQ;
  private static final int eMR;
  private static final int eMS;
  private static final int eMZ;
  private static final int eNo;
  private static final int eNp;
  private static final int eNq;
  private static final int eNr;
  private static final int eNs;
  private static final int eNt;
  private static final int eNu = "fromUsername".hashCode();
  private static final int eNv = "toUsername".hashCode();
  private static final int fml;
  private static final int fmm = "historyId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = false;
  public String dIA;
  private boolean eEB = false;
  private boolean eEI = false;
  private boolean eFr = false;
  private boolean eFy = false;
  private boolean eJE = false;
  private boolean eJY = false;
  private boolean eKj = false;
  private boolean eMA = false;
  private boolean eMB = false;
  private boolean eMC = false;
  public boolean eMD = false;
  public boolean eME = false;
  private boolean eML = false;
  public int eNc;
  public String eNd;
  public boolean eNg = false;
  private boolean eNh = false;
  private boolean eNi = false;
  public boolean eNj = false;
  public boolean eNk = false;
  private boolean eNl = false;
  private boolean eNm = false;
  private boolean eNn = false;
  public long field_bizChatId;
  public String field_bizChatUserId;
  public String field_bizClientMsgId;
  public String field_content;
  public long field_createTime;
  public int field_flag;
  private String field_fromUsername;
  public String field_historyId;
  public String field_imgPath;
  public int field_isSend;
  public int field_isShowTimer;
  public byte[] field_lvbuffer;
  public long field_msgId;
  public long field_msgSeq;
  public long field_msgSvrId;
  public String field_reserved;
  public bwh field_solitaireFoldInfo;
  public int field_status;
  public String field_talker;
  public int field_talkerId;
  private String field_toUsername;
  public String field_transBrandWording;
  public String field_transContent;
  private int field_type;
  public String fmA;
  public int fmB;
  public int fmC;
  public boolean fmj = false;
  private boolean fmk = false;
  public String fmn;
  public int fmo;
  public int fmp;
  protected int fmq;
  public int fmr;
  public int fms;
  public int fmt;
  public String fmu;
  public String fmv;
  public String fmw;
  public int fmx;
  public byte[] fmy;
  public String fmz;
  
  static
  {
    eEL = "status".hashCode();
    eKy = "isSend".hashCode();
    eNo = "isShowTimer".hashCode();
    eFO = "createTime".hashCode();
    eMP = "talker".hashCode();
    eFV = "content".hashCode();
    eMQ = "imgPath".hashCode();
    eNp = "reserved".hashCode();
    eMR = "lvbuffer".hashCode();
    eMS = "talkerId".hashCode();
    eNq = "transContent".hashCode();
    eNr = "transBrandWording".hashCode();
    eMZ = "bizClientMsgId".hashCode();
    eKn = "bizChatId".hashCode();
    eNs = "bizChatUserId".hashCode();
    eNt = "msgSeq".hashCode();
    eJG = "flag".hashCode();
    fml = "solitaireFoldInfo".hashCode();
  }
  
  public final void M(byte[] paramArrayOfByte)
  {
    this.field_lvbuffer = paramArrayOfByte;
    this.eMD = true;
  }
  
  public final long VX()
  {
    return this.field_msgId;
  }
  
  public final long VY()
  {
    return this.field_msgSvrId;
  }
  
  public final int VZ()
  {
    return this.field_isSend;
  }
  
  public final String Wa()
  {
    return this.field_talker;
  }
  
  public final String Wb()
  {
    return this.field_imgPath;
  }
  
  public final String Wc()
  {
    return this.field_reserved;
  }
  
  public final String Wd()
  {
    return this.field_bizClientMsgId;
  }
  
  public final String We()
  {
    return this.eNd;
  }
  
  public final String Wf()
  {
    return this.fmv;
  }
  
  public final String Wg()
  {
    return this.fmA;
  }
  
  public final int Wh()
  {
    return this.fmB;
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {}
    do
    {
      for (;;)
      {
        return;
        int j = arrayOfString.length;
        int i = 0;
        if (i < j)
        {
          int k = arrayOfString[i].hashCode();
          if (eEF == k)
          {
            this.field_msgId = paramCursor.getLong(i);
            this.eEB = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (eMO == k) {
              this.field_msgSvrId = paramCursor.getLong(i);
            } else if (type_HASHCODE == k) {
              this.field_type = paramCursor.getInt(i);
            } else if (eEL == k) {
              this.field_status = paramCursor.getInt(i);
            } else if (eKy == k) {
              this.field_isSend = paramCursor.getInt(i);
            } else if (eNo == k) {
              this.field_isShowTimer = paramCursor.getInt(i);
            } else if (eFO == k) {
              this.field_createTime = paramCursor.getLong(i);
            } else if (eMP == k) {
              this.field_talker = paramCursor.getString(i);
            } else if (eFV == k) {
              this.field_content = paramCursor.getString(i);
            } else if (eMQ == k) {
              this.field_imgPath = paramCursor.getString(i);
            } else if (eNp == k) {
              this.field_reserved = paramCursor.getString(i);
            } else if (eMR == k) {
              this.field_lvbuffer = paramCursor.getBlob(i);
            } else if (eMS == k) {
              this.field_talkerId = paramCursor.getInt(i);
            } else if (eNq == k) {
              this.field_transContent = paramCursor.getString(i);
            } else if (eNr == k) {
              this.field_transBrandWording = paramCursor.getString(i);
            } else if (eMZ == k) {
              this.field_bizClientMsgId = paramCursor.getString(i);
            } else if (eKn == k) {
              this.field_bizChatId = paramCursor.getLong(i);
            } else if (eNs == k) {
              this.field_bizChatUserId = paramCursor.getString(i);
            } else if (eNt == k) {
              this.field_msgSeq = paramCursor.getLong(i);
            } else if (eJG == k) {
              this.field_flag = paramCursor.getInt(i);
            } else if (fml == k) {
              try
              {
                byte[] arrayOfByte = paramCursor.getBlob(i);
                if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
                  continue;
                }
                this.field_solitaireFoldInfo = ((bwh)new bwh().parseFrom(arrayOfByte));
              }
              catch (IOException localIOException)
              {
                ae.e("MicroMsg.SDK.BaseMsgInfo", localIOException.getMessage());
              }
            } else if (eNu == k) {
              this.field_fromUsername = paramCursor.getString(i);
            } else if (eNv == k) {
              this.field_toUsername = paramCursor.getString(i);
            } else if (fmm == k) {
              this.field_historyId = paramCursor.getString(i);
            } else if (rowid_HASHCODE == k) {
              this.systemRowid = paramCursor.getLong(i);
            }
          }
        }
        try
        {
          if ((this.field_lvbuffer != null) && (this.field_lvbuffer.length != 0))
          {
            paramCursor = new ab();
            i = paramCursor.cB(this.field_lvbuffer);
            if (i != 0)
            {
              ae.e("MicroMsg.SDK.BaseMsgInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          ae.e("MicroMsg.SDK.BaseMsgInfo", "get value failed");
          return;
        }
      }
      if (!paramCursor.foc()) {
        this.fmn = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.eNc = paramCursor.getInt();
      }
      if (!paramCursor.foc()) {
        this.eNd = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.fmo = paramCursor.getInt();
      }
      if (!paramCursor.foc()) {
        this.fmp = paramCursor.getInt();
      }
      if (!paramCursor.foc()) {
        this.fmq = paramCursor.getInt();
      }
      if (!paramCursor.foc()) {
        this.fmr = paramCursor.getInt();
      }
      if (!paramCursor.foc()) {
        this.fms = paramCursor.getInt();
      }
      if (!paramCursor.foc()) {
        this.fmt = paramCursor.getInt();
      }
      if (!paramCursor.foc()) {
        this.fmu = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.fmv = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.fmw = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.fmx = paramCursor.getInt();
      }
      if (!paramCursor.foc()) {
        this.dIA = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.fmy = paramCursor.getBuffer();
      }
      if (!paramCursor.foc()) {
        this.fmz = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.fmA = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.fmB = paramCursor.getInt();
      }
    } while (paramCursor.foc());
    this.fmC = paramCursor.getInt();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.eMD)
      {
        localObject = new ab();
        ((ab)localObject).fod();
        ((ab)localObject).aRM(this.fmn);
        ((ab)localObject).abc(this.eNc);
        ((ab)localObject).aRM(this.eNd);
        ((ab)localObject).abc(this.fmo);
        ((ab)localObject).abc(this.fmp);
        ((ab)localObject).abc(this.fmq);
        ((ab)localObject).abc(this.fmr);
        ((ab)localObject).abc(this.fms);
        ((ab)localObject).abc(this.fmt);
        ((ab)localObject).aRM(this.fmu);
        ((ab)localObject).aRM(this.fmv);
        ((ab)localObject).aRM(this.fmw);
        ((ab)localObject).abc(this.fmx);
        ((ab)localObject).aRM(this.dIA);
        ((ab)localObject).cC(this.fmy);
        ((ab)localObject).aRM(this.fmz);
        ((ab)localObject).aRM(this.fmA);
        ((ab)localObject).abc(this.fmB);
        ((ab)localObject).abc(this.fmC);
        this.field_lvbuffer = ((ab)localObject).foe();
      }
      localObject = new ContentValues();
      if (this.eEB) {
        ((ContentValues)localObject).put("msgId", Long.valueOf(this.field_msgId));
      }
      if (this.eMA) {
        ((ContentValues)localObject).put("msgSvrId", Long.valueOf(this.field_msgSvrId));
      }
      if (this.__hadSettype) {
        ((ContentValues)localObject).put("type", Integer.valueOf(this.field_type));
      }
      if (this.eEI) {
        ((ContentValues)localObject).put("status", Integer.valueOf(this.field_status));
      }
      if (this.eKj) {
        ((ContentValues)localObject).put("isSend", Integer.valueOf(this.field_isSend));
      }
      if (this.eNg) {
        ((ContentValues)localObject).put("isShowTimer", Integer.valueOf(this.field_isShowTimer));
      }
      if (this.eFr) {
        ((ContentValues)localObject).put("createTime", Long.valueOf(this.field_createTime));
      }
      if (this.eMB) {
        ((ContentValues)localObject).put("talker", this.field_talker);
      }
      if (this.field_content == null) {
        this.field_content = "";
      }
      if (this.eFy) {
        ((ContentValues)localObject).put("content", this.field_content);
      }
      if (this.eMC) {
        ((ContentValues)localObject).put("imgPath", this.field_imgPath);
      }
      if (this.eNh) {
        ((ContentValues)localObject).put("reserved", this.field_reserved);
      }
      if (this.eMD) {
        ((ContentValues)localObject).put("lvbuffer", this.field_lvbuffer);
      }
      if (this.eME) {
        ((ContentValues)localObject).put("talkerId", Integer.valueOf(this.field_talkerId));
      }
      if (this.field_transContent == null) {
        this.field_transContent = "";
      }
      if (this.eNi) {
        ((ContentValues)localObject).put("transContent", this.field_transContent);
      }
      if (this.field_transBrandWording == null) {
        this.field_transBrandWording = "";
      }
      if (this.eNj) {
        ((ContentValues)localObject).put("transBrandWording", this.field_transBrandWording);
      }
      if (this.field_bizClientMsgId == null) {
        this.field_bizClientMsgId = "";
      }
      if (this.eML) {
        ((ContentValues)localObject).put("bizClientMsgId", this.field_bizClientMsgId);
      }
      if (this.eJY) {
        ((ContentValues)localObject).put("bizChatId", Long.valueOf(this.field_bizChatId));
      }
      if (this.field_bizChatUserId == null) {
        this.field_bizChatUserId = "";
      }
      if (this.eNk) {
        ((ContentValues)localObject).put("bizChatUserId", this.field_bizChatUserId);
      }
      if (this.eNl) {
        ((ContentValues)localObject).put("msgSeq", Long.valueOf(this.field_msgSeq));
      }
      if (this.eJE) {
        ((ContentValues)localObject).put("flag", Integer.valueOf(this.field_flag));
      }
      if ((!this.fmj) || (this.field_solitaireFoldInfo == null)) {}
    }
    catch (Exception localException)
    {
      try
      {
        Object localObject;
        ((ContentValues)localObject).put("solitaireFoldInfo", this.field_solitaireFoldInfo.toByteArray());
        if (this.eNm) {
          ((ContentValues)localObject).put("fromUsername", this.field_fromUsername);
        }
        if (this.eNn) {
          ((ContentValues)localObject).put("toUsername", this.field_toUsername);
        }
        if (this.fmk) {
          ((ContentValues)localObject).put("historyId", this.field_historyId);
        }
        if (this.systemRowid > 0L) {
          ((ContentValues)localObject).put("rowid", Long.valueOf(this.systemRowid));
        }
        return localObject;
        localException = localException;
        ae.e("MicroMsg.SDK.BaseMsgInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ae.e("MicroMsg.SDK.BaseMsgInfo", localIOException.getMessage());
        }
      }
    }
  }
  
  public final String getContent()
  {
    return this.field_content;
  }
  
  public final long getCreateTime()
  {
    return this.field_createTime;
  }
  
  public final int getStatus()
  {
    return this.field_status;
  }
  
  public int getType()
  {
    return this.field_type;
  }
  
  public final void kD(int paramInt)
  {
    this.fmo = paramInt;
    this.eMD = true;
  }
  
  public final void kE(int paramInt)
  {
    this.fmp = paramInt;
    this.eMD = true;
  }
  
  public final void kF(int paramInt)
  {
    this.fmq = paramInt;
    this.eMD = true;
  }
  
  public final void kG(int paramInt)
  {
    this.fms = paramInt;
    this.eMD = true;
  }
  
  public final void kH(int paramInt)
  {
    this.fmt = paramInt;
    this.eMD = true;
  }
  
  public final void kI(int paramInt)
  {
    this.fmx = paramInt;
    this.eMD = true;
  }
  
  public final void kJ(int paramInt)
  {
    this.fmB = paramInt;
    this.eMD = true;
  }
  
  public final void ka(int paramInt)
  {
    this.eNc = paramInt;
    this.eMD = true;
  }
  
  public final void kt(int paramInt)
  {
    this.field_isSend = paramInt;
    this.eKj = true;
  }
  
  public final void qM(long paramLong)
  {
    this.field_msgSvrId = paramLong;
    this.eMA = true;
  }
  
  public final void qN(long paramLong)
  {
    this.field_createTime = paramLong;
    this.eFr = true;
  }
  
  public final void qO(long paramLong)
  {
    this.field_bizChatId = paramLong;
    this.eJY = true;
  }
  
  public final void qP(long paramLong)
  {
    this.field_msgSeq = paramLong;
    this.eNl = true;
  }
  
  public final void setContent(String paramString)
  {
    this.field_content = paramString;
    this.eFy = true;
  }
  
  public final void setFlag(int paramInt)
  {
    this.field_flag = paramInt;
    this.eJE = true;
  }
  
  public final void setMsgId(long paramLong)
  {
    this.field_msgId = paramLong;
    this.eEB = true;
  }
  
  public void setStatus(int paramInt)
  {
    this.field_status = paramInt;
    this.eEI = true;
  }
  
  public final void setType(int paramInt)
  {
    this.field_type = paramInt;
    this.__hadSettype = true;
  }
  
  public final void tk(String paramString)
  {
    this.eNd = paramString;
    this.eMD = true;
  }
  
  public final void ui(String paramString)
  {
    this.field_talker = paramString;
    this.eMB = true;
  }
  
  public final void uj(String paramString)
  {
    this.field_imgPath = paramString;
    this.eMC = true;
  }
  
  public final void uk(String paramString)
  {
    this.field_reserved = paramString;
    this.eNh = true;
  }
  
  public final void ul(String paramString)
  {
    this.field_transContent = paramString;
    this.eNi = true;
  }
  
  public final void um(String paramString)
  {
    this.field_bizClientMsgId = paramString;
    this.eML = true;
  }
  
  public final void un(String paramString)
  {
    this.field_fromUsername = paramString;
    this.eNm = true;
  }
  
  public final void uo(String paramString)
  {
    this.field_toUsername = paramString;
    this.eNn = true;
  }
  
  public final void up(String paramString)
  {
    this.field_historyId = paramString;
    this.fmk = true;
  }
  
  public final void uq(String paramString)
  {
    this.fmn = paramString;
    this.eMD = true;
  }
  
  public final void ur(String paramString)
  {
    this.fmv = paramString;
    this.eMD = true;
  }
  
  public final void us(String paramString)
  {
    this.fmw = paramString;
    this.eMD = true;
  }
  
  public final void ut(String paramString)
  {
    this.fmz = paramString;
    this.eMD = true;
  }
  
  public final void uu(String paramString)
  {
    this.fmA = paramString;
    this.eMD = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ei
 * JD-Core Version:    0.7.0.1
 */