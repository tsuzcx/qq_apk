package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.fl;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public abstract class am
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ejL = "msgId".hashCode();
  private static final int ejR;
  private static final int ekU;
  private static final int elb;
  private static final int eqa = "bitFlag".hashCode();
  private static final int erS = "msgSvrId".hashCode();
  private static final int erT;
  private static final int erU;
  private static final int erV;
  private static final int erW;
  private static final int erX;
  private static final int erY;
  private static final int erZ;
  private static final int esa;
  private static final int esb;
  private static final int esc;
  private static final int esd = "bizRejectMsgId".hashCode();
  private static final int ese = "bizClientMsgId".hashCode();
  private static final int esf = "rankSessionId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean ejH = true;
  private boolean ejO = true;
  private boolean ekE = true;
  private boolean ekx = true;
  private boolean epN = true;
  private boolean erE = true;
  private boolean erF = true;
  private boolean erG = true;
  private boolean erH = true;
  private boolean erI = true;
  private boolean erJ = true;
  private boolean erK = true;
  private boolean erL = true;
  private boolean erM = true;
  private boolean erN = true;
  private boolean erO = true;
  private boolean erP = true;
  private boolean erQ = true;
  private boolean erR = true;
  private int esg;
  public String esh;
  protected byte[] esi;
  private long esj;
  public fl field_appMsgStatInfoProto;
  public int field_bitFlag;
  public String field_bizClientMsgId;
  public long field_bizRejectMsgId;
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
  public int field_status;
  public String field_talker;
  public int field_talkerId;
  public int field_type;
  
  static
  {
    ejR = "status".hashCode();
    ekU = "createTime".hashCode();
    erT = "talker".hashCode();
    elb = "content".hashCode();
    erU = "imgPath".hashCode();
    erV = "lvbuffer".hashCode();
    erW = "talkerId".hashCode();
    erX = "isExpand".hashCode();
    erY = "orderFlag".hashCode();
    erZ = "hasShow".hashCode();
    esa = "placeTop".hashCode();
    esb = "appMsgStatInfoProto".hashCode();
    esc = "isRead".hashCode();
  }
  
  public final void N(byte[] paramArrayOfByte)
  {
    this.esi = paramArrayOfByte;
    this.erH = true;
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
            if (erS == k)
            {
              this.field_msgSvrId = paramCursor.getLong(i);
            }
            else if (type_HASHCODE == k)
            {
              this.field_type = paramCursor.getInt(i);
            }
            else if (ejR == k)
            {
              this.field_status = paramCursor.getInt(i);
            }
            else if (ekU == k)
            {
              this.field_createTime = paramCursor.getLong(i);
            }
            else if (erT == k)
            {
              this.field_talker = paramCursor.getString(i);
            }
            else if (elb == k)
            {
              this.field_content = paramCursor.getString(i);
            }
            else if (erU == k)
            {
              this.field_imgPath = paramCursor.getString(i);
            }
            else if (erV == k)
            {
              this.field_lvbuffer = paramCursor.getBlob(i);
            }
            else if (erW == k)
            {
              this.field_talkerId = paramCursor.getInt(i);
            }
            else
            {
              if (erX == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (boolean bool = true;; bool = false)
                {
                  this.field_isExpand = bool;
                  break;
                }
              }
              if (erY == k) {
                this.field_orderFlag = paramCursor.getLong(i);
              } else if (erZ == k) {
                this.field_hasShow = paramCursor.getInt(i);
              } else if (esa == k) {
                this.field_placeTop = paramCursor.getInt(i);
              } else if (esb == k) {
                try
                {
                  byte[] arrayOfByte = paramCursor.getBlob(i);
                  if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
                    continue;
                  }
                  this.field_appMsgStatInfoProto = ((fl)new fl().parseFrom(arrayOfByte));
                }
                catch (IOException localIOException)
                {
                  ad.e("MicroMsg.SDK.BaseBizTimeLineInfo", localIOException.getMessage());
                }
              } else if (esc == k) {
                this.field_isRead = paramCursor.getInt(i);
              } else if (eqa == k) {
                this.field_bitFlag = paramCursor.getInt(i);
              } else if (esd == k) {
                this.field_bizRejectMsgId = paramCursor.getLong(i);
              } else if (ese == k) {
                this.field_bizClientMsgId = paramCursor.getString(i);
              } else if (esf == k) {
                this.field_rankSessionId = paramCursor.getString(i);
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
            paramCursor = new aa();
            i = paramCursor.cs(this.field_lvbuffer);
            if (i != 0)
            {
              ad.e("MicroMsg.SDK.BaseBizTimeLineInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          ad.e("MicroMsg.SDK.BaseBizTimeLineInfo", "get value failed");
          return;
        }
      }
      if (!paramCursor.eFk()) {
        this.esg = paramCursor.getInt();
      }
      if (!paramCursor.eFk()) {
        this.esh = paramCursor.getString();
      }
      if (!paramCursor.eFk()) {
        this.esi = paramCursor.getBuffer();
      }
    } while (paramCursor.eFk());
    this.esj = paramCursor.getLong();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.erH)
      {
        localObject = new aa();
        ((aa)localObject).eFl();
        ((aa)localObject).Wi(this.esg);
        ((aa)localObject).aFs(this.esh);
        ((aa)localObject).ct(this.esi);
        ((aa)localObject).vC(this.esj);
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
      if (this.erH) {
        ((ContentValues)localObject).put("lvbuffer", this.field_lvbuffer);
      }
      if (this.erI) {
        ((ContentValues)localObject).put("talkerId", Integer.valueOf(this.field_talkerId));
      }
      if (this.erJ) {
        ((ContentValues)localObject).put("isExpand", Boolean.valueOf(this.field_isExpand));
      }
      if (this.erK) {
        ((ContentValues)localObject).put("orderFlag", Long.valueOf(this.field_orderFlag));
      }
      if (this.erL) {
        ((ContentValues)localObject).put("hasShow", Integer.valueOf(this.field_hasShow));
      }
      if (this.erM) {
        ((ContentValues)localObject).put("placeTop", Integer.valueOf(this.field_placeTop));
      }
      if ((!this.erN) || (this.field_appMsgStatInfoProto == null)) {}
    }
    catch (Exception localException)
    {
      try
      {
        Object localObject;
        ((ContentValues)localObject).put("appMsgStatInfoProto", this.field_appMsgStatInfoProto.toByteArray());
        if (this.erO) {
          ((ContentValues)localObject).put("isRead", Integer.valueOf(this.field_isRead));
        }
        if (this.epN) {
          ((ContentValues)localObject).put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.erP) {
          ((ContentValues)localObject).put("bizRejectMsgId", Long.valueOf(this.field_bizRejectMsgId));
        }
        if (this.field_bizClientMsgId == null) {
          this.field_bizClientMsgId = "";
        }
        if (this.erQ) {
          ((ContentValues)localObject).put("bizClientMsgId", this.field_bizClientMsgId);
        }
        if (this.field_rankSessionId == null) {
          this.field_rankSessionId = "";
        }
        if (this.erR) {
          ((ContentValues)localObject).put("rankSessionId", this.field_rankSessionId);
        }
        if (this.systemRowid > 0L) {
          ((ContentValues)localObject).put("rowid", Long.valueOf(this.systemRowid));
        }
        return localObject;
        localException = localException;
        ad.e("MicroMsg.SDK.BaseBizTimeLineInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ad.e("MicroMsg.SDK.BaseBizTimeLineInfo", localIOException.getMessage());
        }
      }
    }
  }
  
  public final void jC(int paramInt)
  {
    this.esg = paramInt;
    this.erH = true;
  }
  
  public final void mZ(String paramString)
  {
    this.esh = paramString;
    this.erH = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.am
 * JD-Core Version:    0.7.0.1
 */