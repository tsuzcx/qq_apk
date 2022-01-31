package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.y;

public abstract class dd
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dBE = "msgSeq".hashCode();
  private static final int dGL;
  private static final int dGM;
  private static final int dGN;
  private static final int dGO;
  private static final int dGP;
  private static final int dGQ;
  private static final int dfD = "msgId".hashCode();
  private static final int dfJ;
  private static final int dgM;
  private static final int dgT;
  private static final int dkT;
  private static final int dkn = "flag".hashCode();
  private static final int dle;
  private static final int dng = "msgSvrId".hashCode();
  private static final int dnh;
  private static final int dni;
  private static final int dnj;
  private static final int dnk;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = false;
  private String cGU;
  private boolean dBy = false;
  public boolean dGF = false;
  private boolean dGG = false;
  private boolean dGH = false;
  public boolean dGI = false;
  private boolean dGJ = false;
  public boolean dGK = false;
  public String dGR;
  public int dGS;
  public int dGT;
  protected int dGU;
  public int dGV;
  public int dGW;
  public int dGX;
  public String dGY;
  public String dGZ;
  public String dHa;
  public int dHb;
  public byte[] dHc;
  private boolean dfG = false;
  private boolean dfz = false;
  private boolean dgp = false;
  private boolean dgw = false;
  private boolean dkF = false;
  private boolean dkQ = false;
  private boolean dkl = false;
  private boolean dmV = false;
  private boolean dmW = false;
  private boolean dmX = false;
  public boolean dmY = false;
  private boolean dmZ = false;
  public int dnr;
  public String dns;
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
    dfJ = "status".hashCode();
    dle = "isSend".hashCode();
    dGL = "isShowTimer".hashCode();
    dgM = "createTime".hashCode();
    dnh = "talker".hashCode();
    dgT = "content".hashCode();
    dni = "imgPath".hashCode();
    dGM = "reserved".hashCode();
    dnj = "lvbuffer".hashCode();
    dnk = "talkerId".hashCode();
    dGN = "transContent".hashCode();
    dGO = "transBrandWording".hashCode();
    dGP = "bizClientMsgId".hashCode();
    dkT = "bizChatId".hashCode();
    dGQ = "bizChatUserId".hashCode();
  }
  
  public final void H(byte[] paramArrayOfByte)
  {
    this.field_lvbuffer = paramArrayOfByte;
    this.dmY = true;
  }
  
  public final long HA()
  {
    return this.field_msgSvrId;
  }
  
  public final int HB()
  {
    return this.field_isSend;
  }
  
  public final long HC()
  {
    return this.field_createTime;
  }
  
  public final String HD()
  {
    return this.field_talker;
  }
  
  public final String HE()
  {
    return this.field_imgPath;
  }
  
  public final String HF()
  {
    return this.field_reserved;
  }
  
  public final void HG()
  {
    this.dGV = 1;
    this.dmY = true;
  }
  
  public final long Hz()
  {
    return this.field_msgId;
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
        int i = 0;
        int j = arrayOfString.length;
        if (i < j)
        {
          int k = arrayOfString[i].hashCode();
          if (dfD == k)
          {
            this.field_msgId = paramCursor.getLong(i);
            this.dfz = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (dng == k) {
              this.field_msgSvrId = paramCursor.getLong(i);
            } else if (type_HASHCODE == k) {
              this.field_type = paramCursor.getInt(i);
            } else if (dfJ == k) {
              this.field_status = paramCursor.getInt(i);
            } else if (dle == k) {
              this.field_isSend = paramCursor.getInt(i);
            } else if (dGL == k) {
              this.field_isShowTimer = paramCursor.getInt(i);
            } else if (dgM == k) {
              this.field_createTime = paramCursor.getLong(i);
            } else if (dnh == k) {
              this.field_talker = paramCursor.getString(i);
            } else if (dgT == k) {
              this.field_content = paramCursor.getString(i);
            } else if (dni == k) {
              this.field_imgPath = paramCursor.getString(i);
            } else if (dGM == k) {
              this.field_reserved = paramCursor.getString(i);
            } else if (dnj == k) {
              this.field_lvbuffer = paramCursor.getBlob(i);
            } else if (dnk == k) {
              this.field_talkerId = paramCursor.getInt(i);
            } else if (dGN == k) {
              this.field_transContent = paramCursor.getString(i);
            } else if (dGO == k) {
              this.field_transBrandWording = paramCursor.getString(i);
            } else if (dGP == k) {
              this.field_bizClientMsgId = paramCursor.getString(i);
            } else if (dkT == k) {
              this.field_bizChatId = paramCursor.getLong(i);
            } else if (dGQ == k) {
              this.field_bizChatUserId = paramCursor.getString(i);
            } else if (dBE == k) {
              this.field_msgSeq = paramCursor.getLong(i);
            } else if (dkn == k) {
              this.field_flag = paramCursor.getInt(i);
            } else if (rowid_HASHCODE == k) {
              this.systemRowid = paramCursor.getLong(i);
            }
          }
        }
        try
        {
          if ((this.field_lvbuffer != null) && (this.field_lvbuffer.length != 0))
          {
            paramCursor = new y();
            i = paramCursor.ca(this.field_lvbuffer);
            if (i != 0)
            {
              ab.e("MicroMsg.SDK.BaseMsgInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          ab.e("MicroMsg.SDK.BaseMsgInfo", "get value failed");
          return;
        }
      }
      if (!paramCursor.dsu()) {
        this.dGR = paramCursor.getString();
      }
      if (!paramCursor.dsu()) {
        this.dnr = paramCursor.getInt();
      }
      if (!paramCursor.dsu()) {
        this.dns = paramCursor.getString();
      }
      if (!paramCursor.dsu()) {
        this.dGS = paramCursor.getInt();
      }
      if (!paramCursor.dsu()) {
        this.dGT = paramCursor.getInt();
      }
      if (!paramCursor.dsu()) {
        this.dGU = paramCursor.getInt();
      }
      if (!paramCursor.dsu()) {
        this.dGV = paramCursor.getInt();
      }
      if (!paramCursor.dsu()) {
        this.dGW = paramCursor.getInt();
      }
      if (!paramCursor.dsu()) {
        this.dGX = paramCursor.getInt();
      }
      if (!paramCursor.dsu()) {
        this.dGY = paramCursor.getString();
      }
      if (!paramCursor.dsu()) {
        this.dGZ = paramCursor.getString();
      }
      if (!paramCursor.dsu()) {
        this.dHa = paramCursor.getString();
      }
      if (!paramCursor.dsu()) {
        this.dHb = paramCursor.getInt();
      }
      if (!paramCursor.dsu()) {
        this.cGU = paramCursor.getString();
      }
    } while (paramCursor.dsu());
    this.dHc = paramCursor.getBuffer();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.dmY)
      {
        localObject = new y();
        ((y)localObject).dsv();
        ((y)localObject).ape(this.dGR);
        ((y)localObject).Nd(this.dnr);
        ((y)localObject).ape(this.dns);
        ((y)localObject).Nd(this.dGS);
        ((y)localObject).Nd(this.dGT);
        ((y)localObject).Nd(this.dGU);
        ((y)localObject).Nd(this.dGV);
        ((y)localObject).Nd(this.dGW);
        ((y)localObject).Nd(this.dGX);
        ((y)localObject).ape(this.dGY);
        ((y)localObject).ape(this.dGZ);
        ((y)localObject).ape(this.dHa);
        ((y)localObject).Nd(this.dHb);
        ((y)localObject).ape(this.cGU);
        ((y)localObject).cb(this.dHc);
        this.field_lvbuffer = ((y)localObject).dsw();
      }
      Object localObject = new ContentValues();
      if (this.dfz) {
        ((ContentValues)localObject).put("msgId", Long.valueOf(this.field_msgId));
      }
      if (this.dmV) {
        ((ContentValues)localObject).put("msgSvrId", Long.valueOf(this.field_msgSvrId));
      }
      if (this.__hadSettype) {
        ((ContentValues)localObject).put("type", Integer.valueOf(this.field_type));
      }
      if (this.dfG) {
        ((ContentValues)localObject).put("status", Integer.valueOf(this.field_status));
      }
      if (this.dkQ) {
        ((ContentValues)localObject).put("isSend", Integer.valueOf(this.field_isSend));
      }
      if (this.dGF) {
        ((ContentValues)localObject).put("isShowTimer", Integer.valueOf(this.field_isShowTimer));
      }
      if (this.dgp) {
        ((ContentValues)localObject).put("createTime", Long.valueOf(this.field_createTime));
      }
      if (this.dmW) {
        ((ContentValues)localObject).put("talker", this.field_talker);
      }
      if (this.field_content == null) {
        this.field_content = "";
      }
      if (this.dgw) {
        ((ContentValues)localObject).put("content", this.field_content);
      }
      if (this.dmX) {
        ((ContentValues)localObject).put("imgPath", this.field_imgPath);
      }
      if (this.dGG) {
        ((ContentValues)localObject).put("reserved", this.field_reserved);
      }
      if (this.dmY) {
        ((ContentValues)localObject).put("lvbuffer", this.field_lvbuffer);
      }
      if (this.dmZ) {
        ((ContentValues)localObject).put("talkerId", Integer.valueOf(this.field_talkerId));
      }
      if (this.field_transContent == null) {
        this.field_transContent = "";
      }
      if (this.dGH) {
        ((ContentValues)localObject).put("transContent", this.field_transContent);
      }
      if (this.field_transBrandWording == null) {
        this.field_transBrandWording = "";
      }
      if (this.dGI) {
        ((ContentValues)localObject).put("transBrandWording", this.field_transBrandWording);
      }
      if (this.field_bizClientMsgId == null) {
        this.field_bizClientMsgId = "";
      }
      if (this.dGJ) {
        ((ContentValues)localObject).put("bizClientMsgId", this.field_bizClientMsgId);
      }
      if (this.dkF) {
        ((ContentValues)localObject).put("bizChatId", Long.valueOf(this.field_bizChatId));
      }
      if (this.field_bizChatUserId == null) {
        this.field_bizChatUserId = "";
      }
      if (this.dGK) {
        ((ContentValues)localObject).put("bizChatUserId", this.field_bizChatUserId);
      }
      if (this.dBy) {
        ((ContentValues)localObject).put("msgSeq", Long.valueOf(this.field_msgSeq));
      }
      if (this.dkl) {
        ((ContentValues)localObject).put("flag", Integer.valueOf(this.field_flag));
      }
      if (this.systemRowid > 0L) {
        ((ContentValues)localObject).put("rowid", Long.valueOf(this.systemRowid));
      }
      return localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.SDK.BaseMsgInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
    }
  }
  
  public final void fP(long paramLong)
  {
    this.field_msgSvrId = paramLong;
    this.dmV = true;
  }
  
  public final void fQ(long paramLong)
  {
    this.field_createTime = paramLong;
    this.dgp = true;
  }
  
  public final void fR(long paramLong)
  {
    this.field_bizChatId = paramLong;
    this.dkF = true;
  }
  
  public final void fS(long paramLong)
  {
    this.field_msgSeq = paramLong;
    this.dBy = true;
  }
  
  public final String getContent()
  {
    return this.field_content;
  }
  
  public final int getStatus()
  {
    return this.field_status;
  }
  
  public int getType()
  {
    return this.field_type;
  }
  
  public final void hL(int paramInt)
  {
    this.field_isSend = paramInt;
    this.dkQ = true;
  }
  
  public final void hU(int paramInt)
  {
    this.field_talkerId = paramInt;
    this.dmZ = true;
  }
  
  public final void hV(int paramInt)
  {
    this.field_flag = paramInt;
    this.dkl = true;
  }
  
  public final void hW(int paramInt)
  {
    this.dGS = paramInt;
    this.dmY = true;
  }
  
  public final void hX(int paramInt)
  {
    this.dGT = paramInt;
    this.dmY = true;
  }
  
  public final void hY(int paramInt)
  {
    this.dGU = paramInt;
    this.dmY = true;
  }
  
  public final void hZ(int paramInt)
  {
    this.dGW = paramInt;
    this.dmY = true;
  }
  
  public final void hr(int paramInt)
  {
    this.dnr = paramInt;
    this.dmY = true;
  }
  
  public final void ia(int paramInt)
  {
    this.dGX = paramInt;
    this.dmY = true;
  }
  
  public final void ib(int paramInt)
  {
    this.dHb = paramInt;
    this.dmY = true;
  }
  
  public final void jl(String paramString)
  {
    this.dns = paramString;
    this.dmY = true;
  }
  
  public final void kj(String paramString)
  {
    this.field_talker = paramString;
    this.dmW = true;
  }
  
  public final void kk(String paramString)
  {
    this.field_imgPath = paramString;
    this.dmX = true;
  }
  
  public final void kl(String paramString)
  {
    this.field_reserved = paramString;
    this.dGG = true;
  }
  
  public final void km(String paramString)
  {
    this.field_transContent = paramString;
    this.dGH = true;
  }
  
  public final void kn(String paramString)
  {
    this.field_bizClientMsgId = paramString;
    this.dGJ = true;
  }
  
  public final void ko(String paramString)
  {
    this.dGR = paramString;
    this.dmY = true;
  }
  
  public final void kp(String paramString)
  {
    this.dGZ = paramString;
    this.dmY = true;
  }
  
  public final void kq(String paramString)
  {
    this.dHa = paramString;
    this.dmY = true;
  }
  
  public final void setContent(String paramString)
  {
    this.field_content = paramString;
    this.dgw = true;
  }
  
  public final void setMsgId(long paramLong)
  {
    this.field_msgId = paramLong;
    this.dfz = true;
  }
  
  public void setStatus(int paramInt)
  {
    this.field_status = paramInt;
    this.dfG = true;
  }
  
  public final void setType(int paramInt)
  {
    this.field_type = paramInt;
    this.__hadSettype = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.dd
 * JD-Core Version:    0.7.0.1
 */