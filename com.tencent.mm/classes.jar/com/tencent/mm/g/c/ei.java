package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public abstract class ei
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eCW = "msgId".hashCode();
  private static final int eDc;
  private static final int eEf;
  private static final int eEm;
  private static final int eHX;
  private static final int eIE;
  private static final int eIP;
  private static final int eLD;
  private static final int eLE;
  private static final int eLF;
  private static final int eLG;
  private static final int eLH;
  private static final int eLI;
  private static final int eLJ = "fromUsername".hashCode();
  private static final int eLK = "toUsername".hashCode();
  private static final int eLe = "msgSvrId".hashCode();
  private static final int eLf;
  private static final int eLg;
  private static final int eLh;
  private static final int eLi;
  private static final int eLp;
  private static final int fko;
  private static final int fkp = "historyId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = false;
  public String dHv;
  private boolean eCS = false;
  private boolean eCZ = false;
  private boolean eDI = false;
  private boolean eDP = false;
  private boolean eHV = false;
  private boolean eIA = false;
  private boolean eIp = false;
  private boolean eKR = false;
  private boolean eKS = false;
  private boolean eKT = false;
  public boolean eKU = false;
  public boolean eKV = false;
  private boolean eLA = false;
  private boolean eLB = false;
  private boolean eLC = false;
  private boolean eLc = false;
  public int eLr;
  public String eLs;
  public boolean eLv = false;
  private boolean eLw = false;
  private boolean eLx = false;
  public boolean eLy = false;
  public boolean eLz = false;
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
  public bvn field_solitaireFoldInfo;
  public int field_status;
  public String field_talker;
  public int field_talkerId;
  private String field_toUsername;
  public String field_transBrandWording;
  public String field_transContent;
  private int field_type;
  public int fkA;
  public byte[] fkB;
  public String fkC;
  public String fkD;
  public int fkE;
  public boolean fkm = false;
  private boolean fkn = false;
  public String fkq;
  public int fkr;
  public int fks;
  protected int fkt;
  public int fku;
  public int fkv;
  public int fkw;
  public String fkx;
  public String fky;
  public String fkz;
  
  static
  {
    eDc = "status".hashCode();
    eIP = "isSend".hashCode();
    eLD = "isShowTimer".hashCode();
    eEf = "createTime".hashCode();
    eLf = "talker".hashCode();
    eEm = "content".hashCode();
    eLg = "imgPath".hashCode();
    eLE = "reserved".hashCode();
    eLh = "lvbuffer".hashCode();
    eLi = "talkerId".hashCode();
    eLF = "transContent".hashCode();
    eLG = "transBrandWording".hashCode();
    eLp = "bizClientMsgId".hashCode();
    eIE = "bizChatId".hashCode();
    eLH = "bizChatUserId".hashCode();
    eLI = "msgSeq".hashCode();
    eHX = "flag".hashCode();
    fko = "solitaireFoldInfo".hashCode();
  }
  
  public final void M(byte[] paramArrayOfByte)
  {
    this.field_lvbuffer = paramArrayOfByte;
    this.eKU = true;
  }
  
  public final long VP()
  {
    return this.field_msgId;
  }
  
  public final long VQ()
  {
    return this.field_msgSvrId;
  }
  
  public final int VR()
  {
    return this.field_isSend;
  }
  
  public final String VS()
  {
    return this.field_talker;
  }
  
  public final String VT()
  {
    return this.field_imgPath;
  }
  
  public final String VU()
  {
    return this.field_reserved;
  }
  
  public final String VV()
  {
    return this.field_bizClientMsgId;
  }
  
  public final String VW()
  {
    return this.eLs;
  }
  
  public final String VX()
  {
    return this.fky;
  }
  
  public final String VY()
  {
    return this.fkD;
  }
  
  public final int VZ()
  {
    return this.fkE;
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
          if (eCW == k)
          {
            this.field_msgId = paramCursor.getLong(i);
            this.eCS = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (eLe == k) {
              this.field_msgSvrId = paramCursor.getLong(i);
            } else if (type_HASHCODE == k) {
              this.field_type = paramCursor.getInt(i);
            } else if (eDc == k) {
              this.field_status = paramCursor.getInt(i);
            } else if (eIP == k) {
              this.field_isSend = paramCursor.getInt(i);
            } else if (eLD == k) {
              this.field_isShowTimer = paramCursor.getInt(i);
            } else if (eEf == k) {
              this.field_createTime = paramCursor.getLong(i);
            } else if (eLf == k) {
              this.field_talker = paramCursor.getString(i);
            } else if (eEm == k) {
              this.field_content = paramCursor.getString(i);
            } else if (eLg == k) {
              this.field_imgPath = paramCursor.getString(i);
            } else if (eLE == k) {
              this.field_reserved = paramCursor.getString(i);
            } else if (eLh == k) {
              this.field_lvbuffer = paramCursor.getBlob(i);
            } else if (eLi == k) {
              this.field_talkerId = paramCursor.getInt(i);
            } else if (eLF == k) {
              this.field_transContent = paramCursor.getString(i);
            } else if (eLG == k) {
              this.field_transBrandWording = paramCursor.getString(i);
            } else if (eLp == k) {
              this.field_bizClientMsgId = paramCursor.getString(i);
            } else if (eIE == k) {
              this.field_bizChatId = paramCursor.getLong(i);
            } else if (eLH == k) {
              this.field_bizChatUserId = paramCursor.getString(i);
            } else if (eLI == k) {
              this.field_msgSeq = paramCursor.getLong(i);
            } else if (eHX == k) {
              this.field_flag = paramCursor.getInt(i);
            } else if (fko == k) {
              try
              {
                byte[] arrayOfByte = paramCursor.getBlob(i);
                if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
                  continue;
                }
                this.field_solitaireFoldInfo = ((bvn)new bvn().parseFrom(arrayOfByte));
              }
              catch (IOException localIOException)
              {
                ad.e("MicroMsg.SDK.BaseMsgInfo", localIOException.getMessage());
              }
            } else if (eLJ == k) {
              this.field_fromUsername = paramCursor.getString(i);
            } else if (eLK == k) {
              this.field_toUsername = paramCursor.getString(i);
            } else if (fkp == k) {
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
            paramCursor = new aa();
            i = paramCursor.cy(this.field_lvbuffer);
            if (i != 0)
            {
              ad.e("MicroMsg.SDK.BaseMsgInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          ad.e("MicroMsg.SDK.BaseMsgInfo", "get value failed");
          return;
        }
      }
      if (!paramCursor.fki()) {
        this.fkq = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.eLr = paramCursor.getInt();
      }
      if (!paramCursor.fki()) {
        this.eLs = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.fkr = paramCursor.getInt();
      }
      if (!paramCursor.fki()) {
        this.fks = paramCursor.getInt();
      }
      if (!paramCursor.fki()) {
        this.fkt = paramCursor.getInt();
      }
      if (!paramCursor.fki()) {
        this.fku = paramCursor.getInt();
      }
      if (!paramCursor.fki()) {
        this.fkv = paramCursor.getInt();
      }
      if (!paramCursor.fki()) {
        this.fkw = paramCursor.getInt();
      }
      if (!paramCursor.fki()) {
        this.fkx = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.fky = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.fkz = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.fkA = paramCursor.getInt();
      }
      if (!paramCursor.fki()) {
        this.dHv = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.fkB = paramCursor.getBuffer();
      }
      if (!paramCursor.fki()) {
        this.fkC = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.fkD = paramCursor.getString();
      }
    } while (paramCursor.fki());
    this.fkE = paramCursor.getInt();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.eKU)
      {
        localObject = new aa();
        ((aa)localObject).fkj();
        ((aa)localObject).aQp(this.fkq);
        ((aa)localObject).aaw(this.eLr);
        ((aa)localObject).aQp(this.eLs);
        ((aa)localObject).aaw(this.fkr);
        ((aa)localObject).aaw(this.fks);
        ((aa)localObject).aaw(this.fkt);
        ((aa)localObject).aaw(this.fku);
        ((aa)localObject).aaw(this.fkv);
        ((aa)localObject).aaw(this.fkw);
        ((aa)localObject).aQp(this.fkx);
        ((aa)localObject).aQp(this.fky);
        ((aa)localObject).aQp(this.fkz);
        ((aa)localObject).aaw(this.fkA);
        ((aa)localObject).aQp(this.dHv);
        ((aa)localObject).cz(this.fkB);
        ((aa)localObject).aQp(this.fkC);
        ((aa)localObject).aQp(this.fkD);
        ((aa)localObject).aaw(this.fkE);
        this.field_lvbuffer = ((aa)localObject).fkk();
      }
      localObject = new ContentValues();
      if (this.eCS) {
        ((ContentValues)localObject).put("msgId", Long.valueOf(this.field_msgId));
      }
      if (this.eKR) {
        ((ContentValues)localObject).put("msgSvrId", Long.valueOf(this.field_msgSvrId));
      }
      if (this.__hadSettype) {
        ((ContentValues)localObject).put("type", Integer.valueOf(this.field_type));
      }
      if (this.eCZ) {
        ((ContentValues)localObject).put("status", Integer.valueOf(this.field_status));
      }
      if (this.eIA) {
        ((ContentValues)localObject).put("isSend", Integer.valueOf(this.field_isSend));
      }
      if (this.eLv) {
        ((ContentValues)localObject).put("isShowTimer", Integer.valueOf(this.field_isShowTimer));
      }
      if (this.eDI) {
        ((ContentValues)localObject).put("createTime", Long.valueOf(this.field_createTime));
      }
      if (this.eKS) {
        ((ContentValues)localObject).put("talker", this.field_talker);
      }
      if (this.field_content == null) {
        this.field_content = "";
      }
      if (this.eDP) {
        ((ContentValues)localObject).put("content", this.field_content);
      }
      if (this.eKT) {
        ((ContentValues)localObject).put("imgPath", this.field_imgPath);
      }
      if (this.eLw) {
        ((ContentValues)localObject).put("reserved", this.field_reserved);
      }
      if (this.eKU) {
        ((ContentValues)localObject).put("lvbuffer", this.field_lvbuffer);
      }
      if (this.eKV) {
        ((ContentValues)localObject).put("talkerId", Integer.valueOf(this.field_talkerId));
      }
      if (this.field_transContent == null) {
        this.field_transContent = "";
      }
      if (this.eLx) {
        ((ContentValues)localObject).put("transContent", this.field_transContent);
      }
      if (this.field_transBrandWording == null) {
        this.field_transBrandWording = "";
      }
      if (this.eLy) {
        ((ContentValues)localObject).put("transBrandWording", this.field_transBrandWording);
      }
      if (this.field_bizClientMsgId == null) {
        this.field_bizClientMsgId = "";
      }
      if (this.eLc) {
        ((ContentValues)localObject).put("bizClientMsgId", this.field_bizClientMsgId);
      }
      if (this.eIp) {
        ((ContentValues)localObject).put("bizChatId", Long.valueOf(this.field_bizChatId));
      }
      if (this.field_bizChatUserId == null) {
        this.field_bizChatUserId = "";
      }
      if (this.eLz) {
        ((ContentValues)localObject).put("bizChatUserId", this.field_bizChatUserId);
      }
      if (this.eLA) {
        ((ContentValues)localObject).put("msgSeq", Long.valueOf(this.field_msgSeq));
      }
      if (this.eHV) {
        ((ContentValues)localObject).put("flag", Integer.valueOf(this.field_flag));
      }
      if ((!this.fkm) || (this.field_solitaireFoldInfo == null)) {}
    }
    catch (Exception localException)
    {
      try
      {
        Object localObject;
        ((ContentValues)localObject).put("solitaireFoldInfo", this.field_solitaireFoldInfo.toByteArray());
        if (this.eLB) {
          ((ContentValues)localObject).put("fromUsername", this.field_fromUsername);
        }
        if (this.eLC) {
          ((ContentValues)localObject).put("toUsername", this.field_toUsername);
        }
        if (this.fkn) {
          ((ContentValues)localObject).put("historyId", this.field_historyId);
        }
        if (this.systemRowid > 0L) {
          ((ContentValues)localObject).put("rowid", Long.valueOf(this.systemRowid));
        }
        return localObject;
        localException = localException;
        ad.e("MicroMsg.SDK.BaseMsgInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ad.e("MicroMsg.SDK.BaseMsgInfo", localIOException.getMessage());
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
  
  public final void jY(int paramInt)
  {
    this.eLr = paramInt;
    this.eKU = true;
  }
  
  public final void kB(int paramInt)
  {
    this.fkr = paramInt;
    this.eKU = true;
  }
  
  public final void kC(int paramInt)
  {
    this.fks = paramInt;
    this.eKU = true;
  }
  
  public final void kD(int paramInt)
  {
    this.fkt = paramInt;
    this.eKU = true;
  }
  
  public final void kE(int paramInt)
  {
    this.fkv = paramInt;
    this.eKU = true;
  }
  
  public final void kF(int paramInt)
  {
    this.fkw = paramInt;
    this.eKU = true;
  }
  
  public final void kG(int paramInt)
  {
    this.fkA = paramInt;
    this.eKU = true;
  }
  
  public final void kH(int paramInt)
  {
    this.fkE = paramInt;
    this.eKU = true;
  }
  
  public final void kr(int paramInt)
  {
    this.field_isSend = paramInt;
    this.eIA = true;
  }
  
  public final void qA(long paramLong)
  {
    this.field_createTime = paramLong;
    this.eDI = true;
  }
  
  public final void qB(long paramLong)
  {
    this.field_bizChatId = paramLong;
    this.eIp = true;
  }
  
  public final void qC(long paramLong)
  {
    this.field_msgSeq = paramLong;
    this.eLA = true;
  }
  
  public final void qz(long paramLong)
  {
    this.field_msgSvrId = paramLong;
    this.eKR = true;
  }
  
  public final void sP(String paramString)
  {
    this.eLs = paramString;
    this.eKU = true;
  }
  
  public final void setContent(String paramString)
  {
    this.field_content = paramString;
    this.eDP = true;
  }
  
  public final void setFlag(int paramInt)
  {
    this.field_flag = paramInt;
    this.eHV = true;
  }
  
  public final void setMsgId(long paramLong)
  {
    this.field_msgId = paramLong;
    this.eCS = true;
  }
  
  public void setStatus(int paramInt)
  {
    this.field_status = paramInt;
    this.eCZ = true;
  }
  
  public final void setType(int paramInt)
  {
    this.field_type = paramInt;
    this.__hadSettype = true;
  }
  
  public final void tN(String paramString)
  {
    this.field_talker = paramString;
    this.eKS = true;
  }
  
  public final void tO(String paramString)
  {
    this.field_imgPath = paramString;
    this.eKT = true;
  }
  
  public final void tP(String paramString)
  {
    this.field_reserved = paramString;
    this.eLw = true;
  }
  
  public final void tQ(String paramString)
  {
    this.field_transContent = paramString;
    this.eLx = true;
  }
  
  public final void tR(String paramString)
  {
    this.field_bizClientMsgId = paramString;
    this.eLc = true;
  }
  
  public final void tS(String paramString)
  {
    this.field_fromUsername = paramString;
    this.eLB = true;
  }
  
  public final void tT(String paramString)
  {
    this.field_toUsername = paramString;
    this.eLC = true;
  }
  
  public final void tU(String paramString)
  {
    this.field_historyId = paramString;
    this.fkn = true;
  }
  
  public final void tV(String paramString)
  {
    this.fkq = paramString;
    this.eKU = true;
  }
  
  public final void tW(String paramString)
  {
    this.fky = paramString;
    this.eKU = true;
  }
  
  public final void tX(String paramString)
  {
    this.fkz = paramString;
    this.eKU = true;
  }
  
  public final void tY(String paramString)
  {
    this.fkC = paramString;
    this.eKU = true;
  }
  
  public final void tZ(String paramString)
  {
    this.fkD = paramString;
    this.eKU = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ei
 * JD-Core Version:    0.7.0.1
 */