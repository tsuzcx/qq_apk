package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.bra;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.z;
import java.io.IOException;

public abstract class dy
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eLs;
  private static final int eRV;
  private static final int eRW;
  private static final int eRX;
  private static final int eRY;
  private static final int eRZ;
  private static final int eSa = "solitaireFoldInfo".hashCode();
  private static final int elP = "msgId".hashCode();
  private static final int elV;
  private static final int emY;
  private static final int eng;
  private static final int eqO;
  private static final int erG;
  private static final int erv;
  private static final int etW = "msgSvrId".hashCode();
  private static final int etX;
  private static final int etY;
  private static final int etZ;
  private static final int eua;
  private static final int eui;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = false;
  public String dvs;
  private boolean eLm = false;
  public boolean eRP = false;
  private boolean eRQ = false;
  private boolean eRR = false;
  public boolean eRS = false;
  public boolean eRT = false;
  public boolean eRU = false;
  public String eSb;
  public int eSc;
  public int eSd;
  protected int eSe;
  public int eSf;
  public int eSg;
  public int eSh;
  public String eSi;
  public String eSj;
  public String eSk;
  public int eSl;
  public byte[] eSm;
  public String eSn;
  public String eSo;
  public int eSp;
  private boolean elL = false;
  private boolean elS = false;
  private boolean emB = false;
  private boolean emI = false;
  private boolean eqM = false;
  private boolean erg = false;
  private boolean err = false;
  private boolean etI = false;
  private boolean etJ = false;
  private boolean etK = false;
  public boolean etL = false;
  private boolean etM = false;
  private boolean etU = false;
  public int euk;
  public String eul;
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
  public bra field_solitaireFoldInfo;
  public int field_status;
  public String field_talker;
  public int field_talkerId;
  public String field_transBrandWording;
  public String field_transContent;
  private int field_type;
  
  static
  {
    elV = "status".hashCode();
    erG = "isSend".hashCode();
    eRV = "isShowTimer".hashCode();
    emY = "createTime".hashCode();
    etX = "talker".hashCode();
    eng = "content".hashCode();
    etY = "imgPath".hashCode();
    eRW = "reserved".hashCode();
    etZ = "lvbuffer".hashCode();
    eua = "talkerId".hashCode();
    eRX = "transContent".hashCode();
    eRY = "transBrandWording".hashCode();
    eui = "bizClientMsgId".hashCode();
    erv = "bizChatId".hashCode();
    eRZ = "bizChatUserId".hashCode();
    eLs = "msgSeq".hashCode();
    eqO = "flag".hashCode();
  }
  
  public final void N(byte[] paramArrayOfByte)
  {
    this.field_lvbuffer = paramArrayOfByte;
    this.etL = true;
  }
  
  public final long TA()
  {
    return this.field_msgSvrId;
  }
  
  public final int TB()
  {
    return this.field_isSend;
  }
  
  public final String TC()
  {
    return this.field_talker;
  }
  
  public final String TD()
  {
    return this.field_imgPath;
  }
  
  public final String TE()
  {
    return this.field_reserved;
  }
  
  public final String TF()
  {
    return this.field_bizClientMsgId;
  }
  
  public final String TG()
  {
    return this.eul;
  }
  
  public final void TH()
  {
    this.eSf = 1;
    this.etL = true;
  }
  
  public final String TI()
  {
    return this.eSo;
  }
  
  public final long Tz()
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
        int j = arrayOfString.length;
        int i = 0;
        if (i < j)
        {
          int k = arrayOfString[i].hashCode();
          if (elP == k)
          {
            this.field_msgId = paramCursor.getLong(i);
            this.elL = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (etW == k) {
              this.field_msgSvrId = paramCursor.getLong(i);
            } else if (type_HASHCODE == k) {
              this.field_type = paramCursor.getInt(i);
            } else if (elV == k) {
              this.field_status = paramCursor.getInt(i);
            } else if (erG == k) {
              this.field_isSend = paramCursor.getInt(i);
            } else if (eRV == k) {
              this.field_isShowTimer = paramCursor.getInt(i);
            } else if (emY == k) {
              this.field_createTime = paramCursor.getLong(i);
            } else if (etX == k) {
              this.field_talker = paramCursor.getString(i);
            } else if (eng == k) {
              this.field_content = paramCursor.getString(i);
            } else if (etY == k) {
              this.field_imgPath = paramCursor.getString(i);
            } else if (eRW == k) {
              this.field_reserved = paramCursor.getString(i);
            } else if (etZ == k) {
              this.field_lvbuffer = paramCursor.getBlob(i);
            } else if (eua == k) {
              this.field_talkerId = paramCursor.getInt(i);
            } else if (eRX == k) {
              this.field_transContent = paramCursor.getString(i);
            } else if (eRY == k) {
              this.field_transBrandWording = paramCursor.getString(i);
            } else if (eui == k) {
              this.field_bizClientMsgId = paramCursor.getString(i);
            } else if (erv == k) {
              this.field_bizChatId = paramCursor.getLong(i);
            } else if (eRZ == k) {
              this.field_bizChatUserId = paramCursor.getString(i);
            } else if (eLs == k) {
              this.field_msgSeq = paramCursor.getLong(i);
            } else if (eqO == k) {
              this.field_flag = paramCursor.getInt(i);
            } else if (eSa == k) {
              try
              {
                byte[] arrayOfByte = paramCursor.getBlob(i);
                if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
                  continue;
                }
                this.field_solitaireFoldInfo = ((bra)new bra().parseFrom(arrayOfByte));
              }
              catch (IOException localIOException)
              {
                ac.e("MicroMsg.SDK.BaseMsgInfo", localIOException.getMessage());
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
            paramCursor = new z();
            i = paramCursor.cr(this.field_lvbuffer);
            if (i != 0)
            {
              ac.e("MicroMsg.SDK.BaseMsgInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          ac.e("MicroMsg.SDK.BaseMsgInfo", "get value failed");
          return;
        }
      }
      if (!paramCursor.eUE()) {
        this.eSb = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.euk = paramCursor.getInt();
      }
      if (!paramCursor.eUE()) {
        this.eul = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.eSc = paramCursor.getInt();
      }
      if (!paramCursor.eUE()) {
        this.eSd = paramCursor.getInt();
      }
      if (!paramCursor.eUE()) {
        this.eSe = paramCursor.getInt();
      }
      if (!paramCursor.eUE()) {
        this.eSf = paramCursor.getInt();
      }
      if (!paramCursor.eUE()) {
        this.eSg = paramCursor.getInt();
      }
      if (!paramCursor.eUE()) {
        this.eSh = paramCursor.getInt();
      }
      if (!paramCursor.eUE()) {
        this.eSi = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.eSj = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.eSk = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.eSl = paramCursor.getInt();
      }
      if (!paramCursor.eUE()) {
        this.dvs = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.eSm = paramCursor.getBuffer();
      }
      if (!paramCursor.eUE()) {
        this.eSn = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.eSo = paramCursor.getString();
      }
    } while (paramCursor.eUE());
    this.eSp = paramCursor.getInt();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.etL)
      {
        localObject = new z();
        ((z)localObject).eUF();
        ((z)localObject).aKJ(this.eSb);
        ((z)localObject).Yr(this.euk);
        ((z)localObject).aKJ(this.eul);
        ((z)localObject).Yr(this.eSc);
        ((z)localObject).Yr(this.eSd);
        ((z)localObject).Yr(this.eSe);
        ((z)localObject).Yr(this.eSf);
        ((z)localObject).Yr(this.eSg);
        ((z)localObject).Yr(this.eSh);
        ((z)localObject).aKJ(this.eSi);
        ((z)localObject).aKJ(this.eSj);
        ((z)localObject).aKJ(this.eSk);
        ((z)localObject).Yr(this.eSl);
        ((z)localObject).aKJ(this.dvs);
        ((z)localObject).cs(this.eSm);
        ((z)localObject).aKJ(this.eSn);
        ((z)localObject).aKJ(this.eSo);
        ((z)localObject).Yr(this.eSp);
        this.field_lvbuffer = ((z)localObject).eUG();
      }
      localObject = new ContentValues();
      if (this.elL) {
        ((ContentValues)localObject).put("msgId", Long.valueOf(this.field_msgId));
      }
      if (this.etI) {
        ((ContentValues)localObject).put("msgSvrId", Long.valueOf(this.field_msgSvrId));
      }
      if (this.__hadSettype) {
        ((ContentValues)localObject).put("type", Integer.valueOf(this.field_type));
      }
      if (this.elS) {
        ((ContentValues)localObject).put("status", Integer.valueOf(this.field_status));
      }
      if (this.err) {
        ((ContentValues)localObject).put("isSend", Integer.valueOf(this.field_isSend));
      }
      if (this.eRP) {
        ((ContentValues)localObject).put("isShowTimer", Integer.valueOf(this.field_isShowTimer));
      }
      if (this.emB) {
        ((ContentValues)localObject).put("createTime", Long.valueOf(this.field_createTime));
      }
      if (this.etJ) {
        ((ContentValues)localObject).put("talker", this.field_talker);
      }
      if (this.field_content == null) {
        this.field_content = "";
      }
      if (this.emI) {
        ((ContentValues)localObject).put("content", this.field_content);
      }
      if (this.etK) {
        ((ContentValues)localObject).put("imgPath", this.field_imgPath);
      }
      if (this.eRQ) {
        ((ContentValues)localObject).put("reserved", this.field_reserved);
      }
      if (this.etL) {
        ((ContentValues)localObject).put("lvbuffer", this.field_lvbuffer);
      }
      if (this.etM) {
        ((ContentValues)localObject).put("talkerId", Integer.valueOf(this.field_talkerId));
      }
      if (this.field_transContent == null) {
        this.field_transContent = "";
      }
      if (this.eRR) {
        ((ContentValues)localObject).put("transContent", this.field_transContent);
      }
      if (this.field_transBrandWording == null) {
        this.field_transBrandWording = "";
      }
      if (this.eRS) {
        ((ContentValues)localObject).put("transBrandWording", this.field_transBrandWording);
      }
      if (this.field_bizClientMsgId == null) {
        this.field_bizClientMsgId = "";
      }
      if (this.etU) {
        ((ContentValues)localObject).put("bizClientMsgId", this.field_bizClientMsgId);
      }
      if (this.erg) {
        ((ContentValues)localObject).put("bizChatId", Long.valueOf(this.field_bizChatId));
      }
      if (this.field_bizChatUserId == null) {
        this.field_bizChatUserId = "";
      }
      if (this.eRT) {
        ((ContentValues)localObject).put("bizChatUserId", this.field_bizChatUserId);
      }
      if (this.eLm) {
        ((ContentValues)localObject).put("msgSeq", Long.valueOf(this.field_msgSeq));
      }
      if (this.eqM) {
        ((ContentValues)localObject).put("flag", Integer.valueOf(this.field_flag));
      }
      if ((!this.eRU) || (this.field_solitaireFoldInfo == null)) {}
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
        ac.e("MicroMsg.SDK.BaseMsgInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ac.e("MicroMsg.SDK.BaseMsgInfo", localIOException.getMessage());
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
  
  public final void jA(int paramInt)
  {
    this.euk = paramInt;
    this.etL = true;
  }
  
  public final void jT(int paramInt)
  {
    this.field_isSend = paramInt;
    this.err = true;
  }
  
  public final void kd(int paramInt)
  {
    this.field_talkerId = paramInt;
    this.etM = true;
  }
  
  public final void ke(int paramInt)
  {
    this.eSc = paramInt;
    this.etL = true;
  }
  
  public final void kf(int paramInt)
  {
    this.eSd = paramInt;
    this.etL = true;
  }
  
  public final void kg(int paramInt)
  {
    this.eSe = paramInt;
    this.etL = true;
  }
  
  public final void kh(int paramInt)
  {
    this.eSg = paramInt;
    this.etL = true;
  }
  
  public final void ki(int paramInt)
  {
    this.eSh = paramInt;
    this.etL = true;
  }
  
  public final void kj(int paramInt)
  {
    this.eSl = paramInt;
    this.etL = true;
  }
  
  public final void kk(int paramInt)
  {
    this.eSp = paramInt;
    this.etL = true;
  }
  
  public final void oA(long paramLong)
  {
    this.field_createTime = paramLong;
    this.emB = true;
  }
  
  public final void oB(long paramLong)
  {
    this.field_bizChatId = paramLong;
    this.erg = true;
  }
  
  public final void oC(long paramLong)
  {
    this.field_msgSeq = paramLong;
    this.eLm = true;
  }
  
  public final void oz(long paramLong)
  {
    this.field_msgSvrId = paramLong;
    this.etI = true;
  }
  
  public final void qf(String paramString)
  {
    this.eul = paramString;
    this.etL = true;
  }
  
  public final void re(String paramString)
  {
    this.field_talker = paramString;
    this.etJ = true;
  }
  
  public final void rf(String paramString)
  {
    this.field_imgPath = paramString;
    this.etK = true;
  }
  
  public final void rg(String paramString)
  {
    this.field_reserved = paramString;
    this.eRQ = true;
  }
  
  public final void rh(String paramString)
  {
    this.field_transContent = paramString;
    this.eRR = true;
  }
  
  public final void ri(String paramString)
  {
    this.field_bizClientMsgId = paramString;
    this.etU = true;
  }
  
  public final void rj(String paramString)
  {
    this.eSb = paramString;
    this.etL = true;
  }
  
  public final void rk(String paramString)
  {
    this.eSj = paramString;
    this.etL = true;
  }
  
  public final void rl(String paramString)
  {
    this.eSk = paramString;
    this.etL = true;
  }
  
  public final void rm(String paramString)
  {
    this.eSn = paramString;
    this.etL = true;
  }
  
  public final void rn(String paramString)
  {
    this.eSo = paramString;
    this.etL = true;
  }
  
  public final void setContent(String paramString)
  {
    this.field_content = paramString;
    this.emI = true;
  }
  
  public final void setFlag(int paramInt)
  {
    this.field_flag = paramInt;
    this.eqM = true;
  }
  
  public final void setMsgId(long paramLong)
  {
    this.field_msgId = paramLong;
    this.elL = true;
  }
  
  public void setStatus(int paramInt)
  {
    this.field_status = paramInt;
    this.elS = true;
  }
  
  public final void setType(int paramInt)
  {
    this.field_type = paramInt;
    this.__hadSettype = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.dy
 * JD-Core Version:    0.7.0.1
 */