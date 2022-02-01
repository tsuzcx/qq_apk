package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.bmk;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public abstract class du
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eIA;
  private static final int eON;
  private static final int eOO;
  private static final int eOP;
  private static final int eOQ;
  private static final int eOR;
  private static final int eOS = "solitaireFoldInfo".hashCode();
  private static final int ejL = "msgId".hashCode();
  private static final int ejR;
  private static final int ekU;
  private static final int elb;
  private static final int eoK;
  private static final int epC;
  private static final int epr;
  private static final int erS = "msgSvrId".hashCode();
  private static final int erT;
  private static final int erU;
  private static final int erV;
  private static final int erW;
  private static final int ese;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = false;
  public String dxG;
  private boolean eIu = false;
  public boolean eOH = false;
  private boolean eOI = false;
  private boolean eOJ = false;
  public boolean eOK = false;
  public boolean eOL = false;
  public boolean eOM = false;
  public String eOT;
  public int eOU;
  public int eOV;
  protected int eOW;
  public int eOX;
  public int eOY;
  public int eOZ;
  public String ePa;
  public String ePb;
  public String ePc;
  public int ePd;
  public byte[] ePe;
  public String ePf;
  public String ePg;
  public int ePh;
  private boolean ejH = false;
  private boolean ejO = false;
  private boolean ekE = false;
  private boolean ekx = false;
  private boolean eoI = false;
  private boolean epc = false;
  private boolean epn = false;
  private boolean erE = false;
  private boolean erF = false;
  private boolean erG = false;
  public boolean erH = false;
  private boolean erI = false;
  private boolean erQ = false;
  public int esg;
  public String esh;
  public long field_bizChatId;
  public String field_bizChatUserId;
  public String field_bizClientMsgId;
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
  public bmk field_solitaireFoldInfo;
  public int field_status;
  public String field_talker;
  public int field_talkerId;
  public String field_transBrandWording;
  public String field_transContent;
  private int field_type;
  
  static
  {
    ejR = "status".hashCode();
    epC = "isSend".hashCode();
    eON = "isShowTimer".hashCode();
    ekU = "createTime".hashCode();
    erT = "talker".hashCode();
    elb = "content".hashCode();
    erU = "imgPath".hashCode();
    eOO = "reserved".hashCode();
    erV = "lvbuffer".hashCode();
    erW = "talkerId".hashCode();
    eOP = "transContent".hashCode();
    eOQ = "transBrandWording".hashCode();
    ese = "bizClientMsgId".hashCode();
    epr = "bizChatId".hashCode();
    eOR = "bizChatUserId".hashCode();
    eIA = "msgSeq".hashCode();
    eoK = "flag".hashCode();
  }
  
  public final void P(byte[] paramArrayOfByte)
  {
    this.field_lvbuffer = paramArrayOfByte;
    this.erH = true;
  }
  
  public final long SF()
  {
    return this.field_msgId;
  }
  
  public final long SG()
  {
    return this.field_msgSvrId;
  }
  
  public final int SH()
  {
    return this.field_isSend;
  }
  
  public final String SI()
  {
    return this.field_talker;
  }
  
  public final String SJ()
  {
    return this.field_imgPath;
  }
  
  public final String SK()
  {
    return this.field_reserved;
  }
  
  public final String SL()
  {
    return this.field_bizClientMsgId;
  }
  
  public final String SM()
  {
    return this.esh;
  }
  
  public final void SN()
  {
    this.eOX = 1;
    this.erH = true;
  }
  
  public final String SO()
  {
    return this.ePg;
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
          if (ejL == k)
          {
            this.field_msgId = paramCursor.getLong(i);
            this.ejH = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (erS == k) {
              this.field_msgSvrId = paramCursor.getLong(i);
            } else if (type_HASHCODE == k) {
              this.field_type = paramCursor.getInt(i);
            } else if (ejR == k) {
              this.field_status = paramCursor.getInt(i);
            } else if (epC == k) {
              this.field_isSend = paramCursor.getInt(i);
            } else if (eON == k) {
              this.field_isShowTimer = paramCursor.getInt(i);
            } else if (ekU == k) {
              this.field_createTime = paramCursor.getLong(i);
            } else if (erT == k) {
              this.field_talker = paramCursor.getString(i);
            } else if (elb == k) {
              this.field_content = paramCursor.getString(i);
            } else if (erU == k) {
              this.field_imgPath = paramCursor.getString(i);
            } else if (eOO == k) {
              this.field_reserved = paramCursor.getString(i);
            } else if (erV == k) {
              this.field_lvbuffer = paramCursor.getBlob(i);
            } else if (erW == k) {
              this.field_talkerId = paramCursor.getInt(i);
            } else if (eOP == k) {
              this.field_transContent = paramCursor.getString(i);
            } else if (eOQ == k) {
              this.field_transBrandWording = paramCursor.getString(i);
            } else if (ese == k) {
              this.field_bizClientMsgId = paramCursor.getString(i);
            } else if (epr == k) {
              this.field_bizChatId = paramCursor.getLong(i);
            } else if (eOR == k) {
              this.field_bizChatUserId = paramCursor.getString(i);
            } else if (eIA == k) {
              this.field_msgSeq = paramCursor.getLong(i);
            } else if (eoK == k) {
              this.field_flag = paramCursor.getInt(i);
            } else if (eOS == k) {
              try
              {
                byte[] arrayOfByte = paramCursor.getBlob(i);
                if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
                  continue;
                }
                this.field_solitaireFoldInfo = ((bmk)new bmk().parseFrom(arrayOfByte));
              }
              catch (IOException localIOException)
              {
                ad.e("MicroMsg.SDK.BaseMsgInfo", localIOException.getMessage());
              }
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
            i = paramCursor.cs(this.field_lvbuffer);
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
      if (!paramCursor.eFk()) {
        this.eOT = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.esg = paramCursor.getInt();
      }
      if (!paramCursor.eFk()) {
        this.esh = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.eOU = paramCursor.getInt();
      }
      if (!paramCursor.eFk()) {
        this.eOV = paramCursor.getInt();
      }
      if (!paramCursor.eFk()) {
        this.eOW = paramCursor.getInt();
      }
      if (!paramCursor.eFk()) {
        this.eOX = paramCursor.getInt();
      }
      if (!paramCursor.eFk()) {
        this.eOY = paramCursor.getInt();
      }
      if (!paramCursor.eFk()) {
        this.eOZ = paramCursor.getInt();
      }
      if (!paramCursor.eFk()) {
        this.ePa = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.ePb = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.ePc = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.ePd = paramCursor.getInt();
      }
      if (!paramCursor.eFk()) {
        this.dxG = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.ePe = paramCursor.getBuffer();
      }
      if (!paramCursor.eFk()) {
        this.ePf = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.ePg = paramCursor.getString();
      }
    } while (paramCursor.eFk());
    this.ePh = paramCursor.getInt();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.erH)
      {
        localObject = new aa();
        ((aa)localObject).eFl();
        ((aa)localObject).aFs(this.eOT);
        ((aa)localObject).Wi(this.esg);
        ((aa)localObject).aFs(this.esh);
        ((aa)localObject).Wi(this.eOU);
        ((aa)localObject).Wi(this.eOV);
        ((aa)localObject).Wi(this.eOW);
        ((aa)localObject).Wi(this.eOX);
        ((aa)localObject).Wi(this.eOY);
        ((aa)localObject).Wi(this.eOZ);
        ((aa)localObject).aFs(this.ePa);
        ((aa)localObject).aFs(this.ePb);
        ((aa)localObject).aFs(this.ePc);
        ((aa)localObject).Wi(this.ePd);
        ((aa)localObject).aFs(this.dxG);
        ((aa)localObject).ct(this.ePe);
        ((aa)localObject).aFs(this.ePf);
        ((aa)localObject).aFs(this.ePg);
        ((aa)localObject).Wi(this.ePh);
        this.field_lvbuffer = ((aa)localObject).eFm();
      }
      localObject = new ContentValues();
      if (this.ejH) {
        ((ContentValues)localObject).put("msgId", Long.valueOf(this.field_msgId));
      }
      if (this.erE) {
        ((ContentValues)localObject).put("msgSvrId", Long.valueOf(this.field_msgSvrId));
      }
      if (this.__hadSettype) {
        ((ContentValues)localObject).put("type", Integer.valueOf(this.field_type));
      }
      if (this.ejO) {
        ((ContentValues)localObject).put("status", Integer.valueOf(this.field_status));
      }
      if (this.epn) {
        ((ContentValues)localObject).put("isSend", Integer.valueOf(this.field_isSend));
      }
      if (this.eOH) {
        ((ContentValues)localObject).put("isShowTimer", Integer.valueOf(this.field_isShowTimer));
      }
      if (this.ekx) {
        ((ContentValues)localObject).put("createTime", Long.valueOf(this.field_createTime));
      }
      if (this.erF) {
        ((ContentValues)localObject).put("talker", this.field_talker);
      }
      if (this.field_content == null) {
        this.field_content = "";
      }
      if (this.ekE) {
        ((ContentValues)localObject).put("content", this.field_content);
      }
      if (this.erG) {
        ((ContentValues)localObject).put("imgPath", this.field_imgPath);
      }
      if (this.eOI) {
        ((ContentValues)localObject).put("reserved", this.field_reserved);
      }
      if (this.erH) {
        ((ContentValues)localObject).put("lvbuffer", this.field_lvbuffer);
      }
      if (this.erI) {
        ((ContentValues)localObject).put("talkerId", Integer.valueOf(this.field_talkerId));
      }
      if (this.field_transContent == null) {
        this.field_transContent = "";
      }
      if (this.eOJ) {
        ((ContentValues)localObject).put("transContent", this.field_transContent);
      }
      if (this.field_transBrandWording == null) {
        this.field_transBrandWording = "";
      }
      if (this.eOK) {
        ((ContentValues)localObject).put("transBrandWording", this.field_transBrandWording);
      }
      if (this.field_bizClientMsgId == null) {
        this.field_bizClientMsgId = "";
      }
      if (this.erQ) {
        ((ContentValues)localObject).put("bizClientMsgId", this.field_bizClientMsgId);
      }
      if (this.epc) {
        ((ContentValues)localObject).put("bizChatId", Long.valueOf(this.field_bizChatId));
      }
      if (this.field_bizChatUserId == null) {
        this.field_bizChatUserId = "";
      }
      if (this.eOL) {
        ((ContentValues)localObject).put("bizChatUserId", this.field_bizChatUserId);
      }
      if (this.eIu) {
        ((ContentValues)localObject).put("msgSeq", Long.valueOf(this.field_msgSeq));
      }
      if (this.eoI) {
        ((ContentValues)localObject).put("flag", Integer.valueOf(this.field_flag));
      }
      if ((!this.eOM) || (this.field_solitaireFoldInfo == null)) {}
    }
    catch (Exception localException)
    {
      try
      {
        Object localObject;
        ((ContentValues)localObject).put("solitaireFoldInfo", this.field_solitaireFoldInfo.toByteArray());
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
  
  public final void jC(int paramInt)
  {
    this.esg = paramInt;
    this.erH = true;
  }
  
  public final void jV(int paramInt)
  {
    this.field_isSend = paramInt;
    this.epn = true;
  }
  
  public final void kX(long paramLong)
  {
    this.field_msgSvrId = paramLong;
    this.erE = true;
  }
  
  public final void kY(long paramLong)
  {
    this.field_createTime = paramLong;
    this.ekx = true;
  }
  
  public final void kZ(long paramLong)
  {
    this.field_bizChatId = paramLong;
    this.epc = true;
  }
  
  public final void kf(int paramInt)
  {
    this.field_talkerId = paramInt;
    this.erI = true;
  }
  
  public final void kh(int paramInt)
  {
    this.eOU = paramInt;
    this.erH = true;
  }
  
  public final void ki(int paramInt)
  {
    this.eOV = paramInt;
    this.erH = true;
  }
  
  public final void kj(int paramInt)
  {
    this.eOW = paramInt;
    this.erH = true;
  }
  
  public final void kk(int paramInt)
  {
    this.eOY = paramInt;
    this.erH = true;
  }
  
  public final void kl(int paramInt)
  {
    this.eOZ = paramInt;
    this.erH = true;
  }
  
  public final void km(int paramInt)
  {
    this.ePd = paramInt;
    this.erH = true;
  }
  
  public final void kn(int paramInt)
  {
    this.ePh = paramInt;
    this.erH = true;
  }
  
  public final void la(long paramLong)
  {
    this.field_msgSeq = paramLong;
    this.eIu = true;
  }
  
  public final void mZ(String paramString)
  {
    this.esh = paramString;
    this.erH = true;
  }
  
  public final void nY(String paramString)
  {
    this.field_talker = paramString;
    this.erF = true;
  }
  
  public final void nZ(String paramString)
  {
    this.field_imgPath = paramString;
    this.erG = true;
  }
  
  public final void oa(String paramString)
  {
    this.field_reserved = paramString;
    this.eOI = true;
  }
  
  public final void ob(String paramString)
  {
    this.field_transContent = paramString;
    this.eOJ = true;
  }
  
  public final void oc(String paramString)
  {
    this.field_bizClientMsgId = paramString;
    this.erQ = true;
  }
  
  public final void od(String paramString)
  {
    this.eOT = paramString;
    this.erH = true;
  }
  
  public final void oe(String paramString)
  {
    this.ePb = paramString;
    this.erH = true;
  }
  
  public final void of(String paramString)
  {
    this.ePc = paramString;
    this.erH = true;
  }
  
  public final void og(String paramString)
  {
    this.ePf = paramString;
    this.erH = true;
  }
  
  public final void oh(String paramString)
  {
    this.ePg = paramString;
    this.erH = true;
  }
  
  public final void setContent(String paramString)
  {
    this.field_content = paramString;
    this.ekE = true;
  }
  
  public final void setFlag(int paramInt)
  {
    this.field_flag = paramInt;
    this.eoI = true;
  }
  
  public final void setMsgId(long paramLong)
  {
    this.field_msgId = paramLong;
    this.ejH = true;
  }
  
  public void setStatus(int paramInt)
  {
    this.field_status = paramInt;
    this.ejO = true;
  }
  
  public final void setType(int paramInt)
  {
    this.field_type = paramInt;
    this.__hadSettype = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.du
 * JD-Core Version:    0.7.0.1
 */