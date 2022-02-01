package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.cjv;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class eo
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int content_HASHCODE;
  private static final int createTime_HASHCODE;
  private static final int fQP;
  private static final int fQQ = "historyId".hashCode();
  private static final int fjf = "msgId".hashCode();
  private static final int fjl;
  private static final int fnT;
  private static final int fni;
  private static final int foe;
  private static final int fqG;
  private static final int fqV;
  private static final int fqW;
  private static final int fqX;
  private static final int fqY;
  private static final int fqZ;
  private static final int fqv = "msgSvrId".hashCode();
  private static final int fqw;
  private static final int fqx;
  private static final int fqy;
  private static final int fqz;
  private static final int fra;
  private static final int frb;
  private static final int frc;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSetcontent = false;
  private boolean __hadSetcreateTime = false;
  private boolean __hadSettype = false;
  public String ean;
  public boolean fQN = false;
  private boolean fQO = false;
  public String fQR;
  public int fQS;
  public int fQT;
  protected int fQU;
  public int fQV;
  public int fQW;
  public int fQX;
  public String fQY;
  public String fQZ;
  public String fRa;
  public int fRb;
  public byte[] fRc;
  public String fRd;
  public String fRe;
  public int fRf;
  public int fRg;
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
  public cjv field_solitaireFoldInfo;
  public int field_status;
  public String field_talker;
  public int field_talkerId;
  private String field_toUsername;
  public String field_transBrandWording;
  public String field_transContent;
  private int field_type;
  private boolean fjb = false;
  private boolean fji = false;
  private boolean fnE = false;
  private boolean fnP = false;
  private boolean fng = false;
  public int fqJ;
  public String fqK;
  public boolean fqN = false;
  private boolean fqO = false;
  private boolean fqP = false;
  public boolean fqQ = false;
  public boolean fqR = false;
  private boolean fqS = false;
  private boolean fqT = false;
  private boolean fqU = false;
  private boolean fqh = false;
  private boolean fqi = false;
  private boolean fqj = false;
  public boolean fqk = false;
  public boolean fql = false;
  private boolean fqs = false;
  
  static
  {
    fjl = "status".hashCode();
    foe = "isSend".hashCode();
    fqV = "isShowTimer".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    fqw = "talker".hashCode();
    content_HASHCODE = "content".hashCode();
    fqx = "imgPath".hashCode();
    fqW = "reserved".hashCode();
    fqy = "lvbuffer".hashCode();
    fqz = "talkerId".hashCode();
    fqX = "transContent".hashCode();
    fqY = "transBrandWording".hashCode();
    fqG = "bizClientMsgId".hashCode();
    fnT = "bizChatId".hashCode();
    fqZ = "bizChatUserId".hashCode();
    fra = "msgSeq".hashCode();
    fni = "flag".hashCode();
    fQP = "solitaireFoldInfo".hashCode();
    frb = "fromUsername".hashCode();
    frc = "toUsername".hashCode();
  }
  
  public final void BB(String paramString)
  {
    this.fqK = paramString;
    this.fqk = true;
  }
  
  public final void CA(String paramString)
  {
    this.field_reserved = paramString;
    this.fqO = true;
  }
  
  public final void CB(String paramString)
  {
    this.field_transContent = paramString;
    this.fqP = true;
  }
  
  public final void CC(String paramString)
  {
    this.field_bizClientMsgId = paramString;
    this.fqs = true;
  }
  
  public final void CD(String paramString)
  {
    this.field_fromUsername = paramString;
    this.fqT = true;
  }
  
  public final void CE(String paramString)
  {
    this.field_toUsername = paramString;
    this.fqU = true;
  }
  
  public final void CF(String paramString)
  {
    this.field_historyId = paramString;
    this.fQO = true;
  }
  
  public final void CG(String paramString)
  {
    this.fQR = paramString;
    this.fqk = true;
  }
  
  public final void CH(String paramString)
  {
    this.fQZ = paramString;
    this.fqk = true;
  }
  
  public final void CI(String paramString)
  {
    this.fRa = paramString;
    this.fqk = true;
  }
  
  public final void CJ(String paramString)
  {
    this.fRd = paramString;
    this.fqk = true;
  }
  
  public final void CK(String paramString)
  {
    this.fRe = paramString;
    this.fqk = true;
  }
  
  public final void Cy(String paramString)
  {
    this.field_talker = paramString;
    this.fqi = true;
  }
  
  public final void Cz(String paramString)
  {
    this.field_imgPath = paramString;
    this.fqj = true;
  }
  
  public final void aa(byte[] paramArrayOfByte)
  {
    this.field_lvbuffer = paramArrayOfByte;
    this.fqk = true;
  }
  
  public final long ajL()
  {
    return this.field_msgId;
  }
  
  public final long ajM()
  {
    return this.field_msgSvrId;
  }
  
  public final int ajN()
  {
    return this.field_isSend;
  }
  
  public final String ajO()
  {
    return this.field_talker;
  }
  
  public final String ajP()
  {
    return this.field_imgPath;
  }
  
  public final String ajQ()
  {
    return this.field_reserved;
  }
  
  public final String ajR()
  {
    return this.field_bizClientMsgId;
  }
  
  public final int ajS()
  {
    return this.fQV;
  }
  
  public final String ajT()
  {
    return this.fQZ;
  }
  
  public final String ajU()
  {
    return this.fRe;
  }
  
  public final int ajV()
  {
    return this.fRf;
  }
  
  public final String ajw()
  {
    return this.fqK;
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
          if (fjf == k)
          {
            this.field_msgId = paramCursor.getLong(i);
            this.fjb = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (fqv == k) {
              this.field_msgSvrId = paramCursor.getLong(i);
            } else if (type_HASHCODE == k) {
              this.field_type = paramCursor.getInt(i);
            } else if (fjl == k) {
              this.field_status = paramCursor.getInt(i);
            } else if (foe == k) {
              this.field_isSend = paramCursor.getInt(i);
            } else if (fqV == k) {
              this.field_isShowTimer = paramCursor.getInt(i);
            } else if (createTime_HASHCODE == k) {
              this.field_createTime = paramCursor.getLong(i);
            } else if (fqw == k) {
              this.field_talker = paramCursor.getString(i);
            } else if (content_HASHCODE == k) {
              this.field_content = paramCursor.getString(i);
            } else if (fqx == k) {
              this.field_imgPath = paramCursor.getString(i);
            } else if (fqW == k) {
              this.field_reserved = paramCursor.getString(i);
            } else if (fqy == k) {
              this.field_lvbuffer = paramCursor.getBlob(i);
            } else if (fqz == k) {
              this.field_talkerId = paramCursor.getInt(i);
            } else if (fqX == k) {
              this.field_transContent = paramCursor.getString(i);
            } else if (fqY == k) {
              this.field_transBrandWording = paramCursor.getString(i);
            } else if (fqG == k) {
              this.field_bizClientMsgId = paramCursor.getString(i);
            } else if (fnT == k) {
              this.field_bizChatId = paramCursor.getLong(i);
            } else if (fqZ == k) {
              this.field_bizChatUserId = paramCursor.getString(i);
            } else if (fra == k) {
              this.field_msgSeq = paramCursor.getLong(i);
            } else if (fni == k) {
              this.field_flag = paramCursor.getInt(i);
            } else if (fQP == k) {
              try
              {
                byte[] arrayOfByte = paramCursor.getBlob(i);
                if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
                  continue;
                }
                this.field_solitaireFoldInfo = ((cjv)new cjv().parseFrom(arrayOfByte));
              }
              catch (IOException localIOException)
              {
                Log.e("MicroMsg.SDK.BaseMsgInfo", localIOException.getMessage());
              }
            } else if (frb == k) {
              this.field_fromUsername = paramCursor.getString(i);
            } else if (frc == k) {
              this.field_toUsername = paramCursor.getString(i);
            } else if (fQQ == k) {
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
            paramCursor = new LVBuffer();
            i = paramCursor.initParse(this.field_lvbuffer);
            if (i != 0)
            {
              Log.e("MicroMsg.SDK.BaseMsgInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          Log.e("MicroMsg.SDK.BaseMsgInfo", "get value failed");
          return;
        }
      }
      if (!paramCursor.checkGetFinish()) {
        this.fQR = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fqJ = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fqK = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fQS = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fQT = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fQU = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fQV = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fQW = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fQX = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fQY = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fQZ = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fRa = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fRb = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.ean = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fRc = paramCursor.getBuffer();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fRd = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fRe = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fRf = paramCursor.getInt();
      }
    } while (paramCursor.checkGetFinish());
    this.fRg = paramCursor.getInt();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.fqk)
      {
        localObject = new LVBuffer();
        ((LVBuffer)localObject).initBuild();
        ((LVBuffer)localObject).putString(this.fQR);
        ((LVBuffer)localObject).putInt(this.fqJ);
        ((LVBuffer)localObject).putString(this.fqK);
        ((LVBuffer)localObject).putInt(this.fQS);
        ((LVBuffer)localObject).putInt(this.fQT);
        ((LVBuffer)localObject).putInt(this.fQU);
        ((LVBuffer)localObject).putInt(this.fQV);
        ((LVBuffer)localObject).putInt(this.fQW);
        ((LVBuffer)localObject).putInt(this.fQX);
        ((LVBuffer)localObject).putString(this.fQY);
        ((LVBuffer)localObject).putString(this.fQZ);
        ((LVBuffer)localObject).putString(this.fRa);
        ((LVBuffer)localObject).putInt(this.fRb);
        ((LVBuffer)localObject).putString(this.ean);
        ((LVBuffer)localObject).putBuffer(this.fRc);
        ((LVBuffer)localObject).putString(this.fRd);
        ((LVBuffer)localObject).putString(this.fRe);
        ((LVBuffer)localObject).putInt(this.fRf);
        ((LVBuffer)localObject).putInt(this.fRg);
        this.field_lvbuffer = ((LVBuffer)localObject).buildFinish();
      }
      localObject = new ContentValues();
      if (this.fjb) {
        ((ContentValues)localObject).put("msgId", Long.valueOf(this.field_msgId));
      }
      if (this.fqh) {
        ((ContentValues)localObject).put("msgSvrId", Long.valueOf(this.field_msgSvrId));
      }
      if (this.__hadSettype) {
        ((ContentValues)localObject).put("type", Integer.valueOf(this.field_type));
      }
      if (this.fji) {
        ((ContentValues)localObject).put("status", Integer.valueOf(this.field_status));
      }
      if (this.fnP) {
        ((ContentValues)localObject).put("isSend", Integer.valueOf(this.field_isSend));
      }
      if (this.fqN) {
        ((ContentValues)localObject).put("isShowTimer", Integer.valueOf(this.field_isShowTimer));
      }
      if (this.__hadSetcreateTime) {
        ((ContentValues)localObject).put("createTime", Long.valueOf(this.field_createTime));
      }
      if (this.fqi) {
        ((ContentValues)localObject).put("talker", this.field_talker);
      }
      if (this.field_content == null) {
        this.field_content = "";
      }
      if (this.__hadSetcontent) {
        ((ContentValues)localObject).put("content", this.field_content);
      }
      if (this.fqj) {
        ((ContentValues)localObject).put("imgPath", this.field_imgPath);
      }
      if (this.fqO) {
        ((ContentValues)localObject).put("reserved", this.field_reserved);
      }
      if (this.fqk) {
        ((ContentValues)localObject).put("lvbuffer", this.field_lvbuffer);
      }
      if (this.fql) {
        ((ContentValues)localObject).put("talkerId", Integer.valueOf(this.field_talkerId));
      }
      if (this.field_transContent == null) {
        this.field_transContent = "";
      }
      if (this.fqP) {
        ((ContentValues)localObject).put("transContent", this.field_transContent);
      }
      if (this.field_transBrandWording == null) {
        this.field_transBrandWording = "";
      }
      if (this.fqQ) {
        ((ContentValues)localObject).put("transBrandWording", this.field_transBrandWording);
      }
      if (this.field_bizClientMsgId == null) {
        this.field_bizClientMsgId = "";
      }
      if (this.fqs) {
        ((ContentValues)localObject).put("bizClientMsgId", this.field_bizClientMsgId);
      }
      if (this.fnE) {
        ((ContentValues)localObject).put("bizChatId", Long.valueOf(this.field_bizChatId));
      }
      if (this.field_bizChatUserId == null) {
        this.field_bizChatUserId = "";
      }
      if (this.fqR) {
        ((ContentValues)localObject).put("bizChatUserId", this.field_bizChatUserId);
      }
      if (this.fqS) {
        ((ContentValues)localObject).put("msgSeq", Long.valueOf(this.field_msgSeq));
      }
      if (this.fng) {
        ((ContentValues)localObject).put("flag", Integer.valueOf(this.field_flag));
      }
      if ((!this.fQN) || (this.field_solitaireFoldInfo == null)) {}
    }
    catch (Exception localException)
    {
      try
      {
        Object localObject;
        ((ContentValues)localObject).put("solitaireFoldInfo", this.field_solitaireFoldInfo.toByteArray());
        if (this.fqT) {
          ((ContentValues)localObject).put("fromUsername", this.field_fromUsername);
        }
        if (this.fqU) {
          ((ContentValues)localObject).put("toUsername", this.field_toUsername);
        }
        if (this.fQO) {
          ((ContentValues)localObject).put("historyId", this.field_historyId);
        }
        if (this.systemRowid > 0L) {
          ((ContentValues)localObject).put("rowid", Long.valueOf(this.systemRowid));
        }
        return localObject;
        localException = localException;
        Log.e("MicroMsg.SDK.BaseMsgInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("MicroMsg.SDK.BaseMsgInfo", localIOException.getMessage());
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
  
  public final void nG(int paramInt)
  {
    this.fQS = paramInt;
    this.fqk = true;
  }
  
  public final void nH(int paramInt)
  {
    this.fQT = paramInt;
    this.fqk = true;
  }
  
  public final void nI(int paramInt)
  {
    this.fQU = paramInt;
    this.fqk = true;
  }
  
  public final void nJ(int paramInt)
  {
    this.fQW = paramInt;
    this.fqk = true;
  }
  
  public final void nK(int paramInt)
  {
    this.fQX = paramInt;
    this.fqk = true;
  }
  
  public final void nL(int paramInt)
  {
    this.fRb = paramInt;
    this.fqk = true;
  }
  
  public final void nM(int paramInt)
  {
    this.fRf = paramInt;
    this.fqk = true;
  }
  
  public final void nc(int paramInt)
  {
    this.fqJ = paramInt;
    this.fqk = true;
  }
  
  public final void nv(int paramInt)
  {
    this.field_isSend = paramInt;
    this.fnP = true;
  }
  
  public final void setContent(String paramString)
  {
    this.field_content = paramString;
    this.__hadSetcontent = true;
  }
  
  public final void setCreateTime(long paramLong)
  {
    this.field_createTime = paramLong;
    this.__hadSetcreateTime = true;
  }
  
  public final void setFlag(int paramInt)
  {
    this.field_flag = paramInt;
    this.fng = true;
  }
  
  public final void setMsgId(long paramLong)
  {
    this.field_msgId = paramLong;
    this.fjb = true;
  }
  
  public void setStatus(int paramInt)
  {
    this.field_status = paramInt;
    this.fji = true;
  }
  
  public final void setType(int paramInt)
  {
    this.field_type = paramInt;
    this.__hadSettype = true;
  }
  
  public final void yF(long paramLong)
  {
    this.field_msgSvrId = paramLong;
    this.fqh = true;
  }
  
  public final void yG(long paramLong)
  {
    this.field_bizChatId = paramLong;
    this.fnE = true;
  }
  
  public final void yH(long paramLong)
  {
    this.field_msgSeq = paramLong;
    this.fqS = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.eo
 * JD-Core Version:    0.7.0.1
 */