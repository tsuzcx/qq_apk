package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.fs;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public abstract class am
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eCW = "msgId".hashCode();
  private static final int eDc;
  private static final int eEf;
  private static final int eEm;
  private static final int eJn = "bitFlag".hashCode();
  private static final int eLe = "msgSvrId".hashCode();
  private static final int eLf;
  private static final int eLg;
  private static final int eLh;
  private static final int eLi;
  private static final int eLj;
  private static final int eLk;
  private static final int eLl;
  private static final int eLm;
  private static final int eLn;
  private static final int eLo;
  private static final int eLp = "bizClientMsgId".hashCode();
  private static final int eLq = "rankSessionId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eCS = true;
  private boolean eCZ = true;
  private boolean eDI = true;
  private boolean eDP = true;
  private boolean eJa = true;
  private boolean eKR = true;
  private boolean eKS = true;
  private boolean eKT = true;
  public boolean eKU = true;
  private boolean eKV = true;
  private boolean eKW = true;
  private boolean eKX = true;
  private boolean eKY = true;
  private boolean eKZ = true;
  private boolean eLa = true;
  private boolean eLb = true;
  private boolean eLc = true;
  private boolean eLd = true;
  private int eLr;
  public String eLs;
  protected byte[] eLt;
  public long eLu;
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
  public int field_status;
  public String field_talker;
  public int field_talkerId;
  public int field_type;
  
  static
  {
    eDc = "status".hashCode();
    eEf = "createTime".hashCode();
    eLf = "talker".hashCode();
    eEm = "content".hashCode();
    eLg = "imgPath".hashCode();
    eLh = "lvbuffer".hashCode();
    eLi = "talkerId".hashCode();
    eLj = "isExpand".hashCode();
    eLk = "orderFlag".hashCode();
    eLl = "hasShow".hashCode();
    eLm = "placeTop".hashCode();
    eLn = "appMsgStatInfoProto".hashCode();
    eLo = "isRead".hashCode();
  }
  
  public final void Vz()
  {
    this.eLt = null;
    this.eKU = true;
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
            if (eLe == k)
            {
              this.field_msgSvrId = paramCursor.getLong(i);
            }
            else if (type_HASHCODE == k)
            {
              this.field_type = paramCursor.getInt(i);
            }
            else if (eDc == k)
            {
              this.field_status = paramCursor.getInt(i);
            }
            else if (eEf == k)
            {
              this.field_createTime = paramCursor.getLong(i);
            }
            else if (eLf == k)
            {
              this.field_talker = paramCursor.getString(i);
            }
            else if (eEm == k)
            {
              this.field_content = paramCursor.getString(i);
            }
            else if (eLg == k)
            {
              this.field_imgPath = paramCursor.getString(i);
            }
            else if (eLh == k)
            {
              this.field_lvbuffer = paramCursor.getBlob(i);
            }
            else if (eLi == k)
            {
              this.field_talkerId = paramCursor.getInt(i);
            }
            else
            {
              if (eLj == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (boolean bool = true;; bool = false)
                {
                  this.field_isExpand = bool;
                  break;
                }
              }
              if (eLk == k) {
                this.field_orderFlag = paramCursor.getLong(i);
              } else if (eLl == k) {
                this.field_hasShow = paramCursor.getInt(i);
              } else if (eLm == k) {
                this.field_placeTop = paramCursor.getInt(i);
              } else if (eLn == k) {
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
                  ad.e("MicroMsg.SDK.BaseBizTimeLineInfo", localIOException.getMessage());
                }
              } else if (eLo == k) {
                this.field_isRead = paramCursor.getInt(i);
              } else if (eJn == k) {
                this.field_bitFlag = paramCursor.getInt(i);
              } else if (eLp == k) {
                this.field_bizClientMsgId = paramCursor.getString(i);
              } else if (eLq == k) {
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
            i = paramCursor.cy(this.field_lvbuffer);
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
      if (!paramCursor.fki()) {
        this.eLr = paramCursor.getInt();
      }
      if (!paramCursor.fki()) {
        this.eLs = paramCursor.getString();
      }
      if (!paramCursor.fki()) {
        this.eLt = paramCursor.getBuffer();
      }
    } while (paramCursor.fki());
    this.eLu = paramCursor.getLong();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.eKU)
      {
        localObject = new aa();
        ((aa)localObject).fkj();
        ((aa)localObject).aaw(this.eLr);
        ((aa)localObject).aQp(this.eLs);
        ((aa)localObject).cz(this.eLt);
        ((aa)localObject).CV(this.eLu);
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
      if (this.eKU) {
        ((ContentValues)localObject).put("lvbuffer", this.field_lvbuffer);
      }
      if (this.eKV) {
        ((ContentValues)localObject).put("talkerId", Integer.valueOf(this.field_talkerId));
      }
      if (this.eKW) {
        ((ContentValues)localObject).put("isExpand", Boolean.valueOf(this.field_isExpand));
      }
      if (this.eKX) {
        ((ContentValues)localObject).put("orderFlag", Long.valueOf(this.field_orderFlag));
      }
      if (this.eKY) {
        ((ContentValues)localObject).put("hasShow", Integer.valueOf(this.field_hasShow));
      }
      if (this.eKZ) {
        ((ContentValues)localObject).put("placeTop", Integer.valueOf(this.field_placeTop));
      }
      if ((!this.eLa) || (this.field_appMsgStatInfoProto == null)) {}
    }
    catch (Exception localException)
    {
      try
      {
        Object localObject;
        ((ContentValues)localObject).put("appMsgStatInfoProto", this.field_appMsgStatInfoProto.toByteArray());
        if (this.eLb) {
          ((ContentValues)localObject).put("isRead", Integer.valueOf(this.field_isRead));
        }
        if (this.eJa) {
          ((ContentValues)localObject).put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.field_bizClientMsgId == null) {
          this.field_bizClientMsgId = "";
        }
        if (this.eLc) {
          ((ContentValues)localObject).put("bizClientMsgId", this.field_bizClientMsgId);
        }
        if (this.field_rankSessionId == null) {
          this.field_rankSessionId = "";
        }
        if (this.eLd) {
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
  
  public final void jY(int paramInt)
  {
    this.eLr = paramInt;
    this.eKU = true;
  }
  
  public final void sP(String paramString)
  {
    this.eLs = paramString;
    this.eKU = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.am
 * JD-Core Version:    0.7.0.1
 */