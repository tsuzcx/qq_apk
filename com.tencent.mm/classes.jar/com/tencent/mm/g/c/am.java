package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.fs;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;

public abstract class am
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEF = "msgId".hashCode();
  private static final int eEL;
  private static final int eFO;
  private static final int eFV;
  private static final int eKW = "bitFlag".hashCode();
  private static final int eMO = "msgSvrId".hashCode();
  private static final int eMP;
  private static final int eMQ;
  private static final int eMR;
  private static final int eMS;
  private static final int eMT;
  private static final int eMU;
  private static final int eMV;
  private static final int eMW;
  private static final int eMX;
  private static final int eMY;
  private static final int eMZ = "bizClientMsgId".hashCode();
  private static final int eNa = "rankSessionId".hashCode();
  private static final int eNb = "recommendCardId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eEB = true;
  private boolean eEI = true;
  private boolean eFr = true;
  private boolean eFy = true;
  private boolean eKJ = true;
  private boolean eMA = true;
  private boolean eMB = true;
  private boolean eMC = true;
  public boolean eMD = true;
  private boolean eME = true;
  private boolean eMF = true;
  private boolean eMG = true;
  private boolean eMH = true;
  private boolean eMI = true;
  private boolean eMJ = true;
  private boolean eMK = true;
  private boolean eML = true;
  private boolean eMM = true;
  private boolean eMN = true;
  private int eNc;
  public String eNd;
  protected byte[] eNe;
  public long eNf;
  public fs field_appMsgStatInfoProto;
  public int field_bitFlag;
  public String field_bizClientMsgId;
  public String field_content;
  public long field_createTime;
  public int field_hasShow;
  public String field_imgPath;
  public boolean field_isExpand;
  public int field_isRead;
  public byte[] field_lvbuffer;
  public long field_msgId;
  public long field_msgSvrId;
  public long field_orderFlag;
  public int field_placeTop;
  public String field_rankSessionId;
  public String field_recommendCardId;
  public int field_status;
  public String field_talker;
  public int field_talkerId;
  public int field_type;
  
  static
  {
    eEL = "status".hashCode();
    eFO = "createTime".hashCode();
    eMP = "talker".hashCode();
    eFV = "content".hashCode();
    eMQ = "imgPath".hashCode();
    eMR = "lvbuffer".hashCode();
    eMS = "talkerId".hashCode();
    eMT = "isExpand".hashCode();
    eMU = "orderFlag".hashCode();
    eMV = "hasShow".hashCode();
    eMW = "placeTop".hashCode();
    eMX = "appMsgStatInfoProto".hashCode();
    eMY = "isRead".hashCode();
  }
  
  public final void VH()
  {
    this.eNe = null;
    this.eMD = true;
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
            if (eMO == k)
            {
              this.field_msgSvrId = paramCursor.getLong(i);
            }
            else if (type_HASHCODE == k)
            {
              this.field_type = paramCursor.getInt(i);
            }
            else if (eEL == k)
            {
              this.field_status = paramCursor.getInt(i);
            }
            else if (eFO == k)
            {
              this.field_createTime = paramCursor.getLong(i);
            }
            else if (eMP == k)
            {
              this.field_talker = paramCursor.getString(i);
            }
            else if (eFV == k)
            {
              this.field_content = paramCursor.getString(i);
            }
            else if (eMQ == k)
            {
              this.field_imgPath = paramCursor.getString(i);
            }
            else if (eMR == k)
            {
              this.field_lvbuffer = paramCursor.getBlob(i);
            }
            else if (eMS == k)
            {
              this.field_talkerId = paramCursor.getInt(i);
            }
            else
            {
              if (eMT == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (boolean bool = true;; bool = false)
                {
                  this.field_isExpand = bool;
                  break;
                }
              }
              if (eMU == k) {
                this.field_orderFlag = paramCursor.getLong(i);
              } else if (eMV == k) {
                this.field_hasShow = paramCursor.getInt(i);
              } else if (eMW == k) {
                this.field_placeTop = paramCursor.getInt(i);
              } else if (eMX == k) {
                try
                {
                  byte[] arrayOfByte = paramCursor.getBlob(i);
                  if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
                    continue;
                  }
                  this.field_appMsgStatInfoProto = ((fs)new fs().parseFrom(arrayOfByte));
                }
                catch (IOException localIOException)
                {
                  ae.e("MicroMsg.SDK.BaseBizTimeLineInfo", localIOException.getMessage());
                }
              } else if (eMY == k) {
                this.field_isRead = paramCursor.getInt(i);
              } else if (eKW == k) {
                this.field_bitFlag = paramCursor.getInt(i);
              } else if (eMZ == k) {
                this.field_bizClientMsgId = paramCursor.getString(i);
              } else if (eNa == k) {
                this.field_rankSessionId = paramCursor.getString(i);
              } else if (eNb == k) {
                this.field_recommendCardId = paramCursor.getString(i);
              } else if (rowid_HASHCODE == k) {
                this.systemRowid = paramCursor.getLong(i);
              }
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
              ae.e("MicroMsg.SDK.BaseBizTimeLineInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          ae.e("MicroMsg.SDK.BaseBizTimeLineInfo", "get value failed");
          return;
        }
      }
      if (!paramCursor.foc()) {
        this.eNc = paramCursor.getInt();
      }
      if (!paramCursor.foc()) {
        this.eNd = paramCursor.getString();
      }
      if (!paramCursor.foc()) {
        this.eNe = paramCursor.getBuffer();
      }
    } while (paramCursor.foc());
    this.eNf = paramCursor.getLong();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.eMD)
      {
        localObject = new ab();
        ((ab)localObject).fod();
        ((ab)localObject).abc(this.eNc);
        ((ab)localObject).aRM(this.eNd);
        ((ab)localObject).cC(this.eNe);
        ((ab)localObject).Dt(this.eNf);
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
      if (this.eMD) {
        ((ContentValues)localObject).put("lvbuffer", this.field_lvbuffer);
      }
      if (this.eME) {
        ((ContentValues)localObject).put("talkerId", Integer.valueOf(this.field_talkerId));
      }
      if (this.eMF) {
        ((ContentValues)localObject).put("isExpand", Boolean.valueOf(this.field_isExpand));
      }
      if (this.eMG) {
        ((ContentValues)localObject).put("orderFlag", Long.valueOf(this.field_orderFlag));
      }
      if (this.eMH) {
        ((ContentValues)localObject).put("hasShow", Integer.valueOf(this.field_hasShow));
      }
      if (this.eMI) {
        ((ContentValues)localObject).put("placeTop", Integer.valueOf(this.field_placeTop));
      }
      if ((!this.eMJ) || (this.field_appMsgStatInfoProto == null)) {}
    }
    catch (Exception localException)
    {
      try
      {
        Object localObject;
        ((ContentValues)localObject).put("appMsgStatInfoProto", this.field_appMsgStatInfoProto.toByteArray());
        if (this.eMK) {
          ((ContentValues)localObject).put("isRead", Integer.valueOf(this.field_isRead));
        }
        if (this.eKJ) {
          ((ContentValues)localObject).put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.field_bizClientMsgId == null) {
          this.field_bizClientMsgId = "";
        }
        if (this.eML) {
          ((ContentValues)localObject).put("bizClientMsgId", this.field_bizClientMsgId);
        }
        if (this.field_rankSessionId == null) {
          this.field_rankSessionId = "";
        }
        if (this.eMM) {
          ((ContentValues)localObject).put("rankSessionId", this.field_rankSessionId);
        }
        if (this.field_recommendCardId == null) {
          this.field_recommendCardId = "";
        }
        if (this.eMN) {
          ((ContentValues)localObject).put("recommendCardId", this.field_recommendCardId);
        }
        if (this.systemRowid > 0L) {
          ((ContentValues)localObject).put("rowid", Long.valueOf(this.systemRowid));
        }
        return localObject;
        localException = localException;
        ae.e("MicroMsg.SDK.BaseBizTimeLineInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ae.e("MicroMsg.SDK.BaseBizTimeLineInfo", localIOException.getMessage());
        }
      }
    }
  }
  
  public final void ka(int paramInt)
  {
    this.eNc = paramInt;
    this.eMD = true;
  }
  
  public final void tk(String paramString)
  {
    this.eNd = paramString;
    this.eMD = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.am
 * JD-Core Version:    0.7.0.1
 */