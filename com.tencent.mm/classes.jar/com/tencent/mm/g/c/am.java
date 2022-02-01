package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.fn;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.z;
import java.io.IOException;

public abstract class am
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int elP = "msgId".hashCode();
  private static final int elV;
  private static final int emY;
  private static final int eng;
  private static final int ese = "bitFlag".hashCode();
  private static final int etW = "msgSvrId".hashCode();
  private static final int etX;
  private static final int etY;
  private static final int etZ;
  private static final int eua;
  private static final int eub;
  private static final int euc;
  private static final int eud;
  private static final int eue;
  private static final int euf;
  private static final int eug;
  private static final int euh = "bizRejectMsgId".hashCode();
  private static final int eui = "bizClientMsgId".hashCode();
  private static final int euj = "rankSessionId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean elL = true;
  private boolean elS = true;
  private boolean emB = true;
  private boolean emI = true;
  private boolean erR = true;
  private boolean etI = true;
  private boolean etJ = true;
  private boolean etK = true;
  private boolean etL = true;
  private boolean etM = true;
  private boolean etN = true;
  private boolean etO = true;
  private boolean etP = true;
  private boolean etQ = true;
  private boolean etR = true;
  private boolean etS = true;
  private boolean etT = true;
  private boolean etU = true;
  private boolean etV = true;
  private int euk;
  public String eul;
  protected byte[] eum;
  private long eun;
  public fn field_appMsgStatInfoProto;
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
    elV = "status".hashCode();
    emY = "createTime".hashCode();
    etX = "talker".hashCode();
    eng = "content".hashCode();
    etY = "imgPath".hashCode();
    etZ = "lvbuffer".hashCode();
    eua = "talkerId".hashCode();
    eub = "isExpand".hashCode();
    euc = "orderFlag".hashCode();
    eud = "hasShow".hashCode();
    eue = "placeTop".hashCode();
    euf = "appMsgStatInfoProto".hashCode();
    eug = "isRead".hashCode();
  }
  
  public final void L(byte[] paramArrayOfByte)
  {
    this.eum = paramArrayOfByte;
    this.etL = true;
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
            if (etW == k)
            {
              this.field_msgSvrId = paramCursor.getLong(i);
            }
            else if (type_HASHCODE == k)
            {
              this.field_type = paramCursor.getInt(i);
            }
            else if (elV == k)
            {
              this.field_status = paramCursor.getInt(i);
            }
            else if (emY == k)
            {
              this.field_createTime = paramCursor.getLong(i);
            }
            else if (etX == k)
            {
              this.field_talker = paramCursor.getString(i);
            }
            else if (eng == k)
            {
              this.field_content = paramCursor.getString(i);
            }
            else if (etY == k)
            {
              this.field_imgPath = paramCursor.getString(i);
            }
            else if (etZ == k)
            {
              this.field_lvbuffer = paramCursor.getBlob(i);
            }
            else if (eua == k)
            {
              this.field_talkerId = paramCursor.getInt(i);
            }
            else
            {
              if (eub == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (boolean bool = true;; bool = false)
                {
                  this.field_isExpand = bool;
                  break;
                }
              }
              if (euc == k) {
                this.field_orderFlag = paramCursor.getLong(i);
              } else if (eud == k) {
                this.field_hasShow = paramCursor.getInt(i);
              } else if (eue == k) {
                this.field_placeTop = paramCursor.getInt(i);
              } else if (euf == k) {
                try
                {
                  byte[] arrayOfByte = paramCursor.getBlob(i);
                  if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
                    continue;
                  }
                  this.field_appMsgStatInfoProto = ((fn)new fn().parseFrom(arrayOfByte));
                }
                catch (IOException localIOException)
                {
                  ac.e("MicroMsg.SDK.BaseBizTimeLineInfo", localIOException.getMessage());
                }
              } else if (eug == k) {
                this.field_isRead = paramCursor.getInt(i);
              } else if (ese == k) {
                this.field_bitFlag = paramCursor.getInt(i);
              } else if (euh == k) {
                this.field_bizRejectMsgId = paramCursor.getLong(i);
              } else if (eui == k) {
                this.field_bizClientMsgId = paramCursor.getString(i);
              } else if (euj == k) {
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
            paramCursor = new z();
            i = paramCursor.cr(this.field_lvbuffer);
            if (i != 0)
            {
              ac.e("MicroMsg.SDK.BaseBizTimeLineInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          ac.e("MicroMsg.SDK.BaseBizTimeLineInfo", "get value failed");
          return;
        }
      }
      if (!paramCursor.eUE()) {
        this.euk = paramCursor.getInt();
      }
      if (!paramCursor.eUE()) {
        this.eul = paramCursor.getString();
      }
      if (!paramCursor.eUE()) {
        this.eum = paramCursor.getBuffer();
      }
    } while (paramCursor.eUE());
    this.eun = paramCursor.getLong();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.etL)
      {
        localObject = new z();
        ((z)localObject).eUF();
        ((z)localObject).Yr(this.euk);
        ((z)localObject).aKJ(this.eul);
        ((z)localObject).cs(this.eum);
        ((z)localObject).Af(this.eun);
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
      if (this.etL) {
        ((ContentValues)localObject).put("lvbuffer", this.field_lvbuffer);
      }
      if (this.etM) {
        ((ContentValues)localObject).put("talkerId", Integer.valueOf(this.field_talkerId));
      }
      if (this.etN) {
        ((ContentValues)localObject).put("isExpand", Boolean.valueOf(this.field_isExpand));
      }
      if (this.etO) {
        ((ContentValues)localObject).put("orderFlag", Long.valueOf(this.field_orderFlag));
      }
      if (this.etP) {
        ((ContentValues)localObject).put("hasShow", Integer.valueOf(this.field_hasShow));
      }
      if (this.etQ) {
        ((ContentValues)localObject).put("placeTop", Integer.valueOf(this.field_placeTop));
      }
      if ((!this.etR) || (this.field_appMsgStatInfoProto == null)) {}
    }
    catch (Exception localException)
    {
      try
      {
        Object localObject;
        ((ContentValues)localObject).put("appMsgStatInfoProto", this.field_appMsgStatInfoProto.toByteArray());
        if (this.etS) {
          ((ContentValues)localObject).put("isRead", Integer.valueOf(this.field_isRead));
        }
        if (this.erR) {
          ((ContentValues)localObject).put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.etT) {
          ((ContentValues)localObject).put("bizRejectMsgId", Long.valueOf(this.field_bizRejectMsgId));
        }
        if (this.field_bizClientMsgId == null) {
          this.field_bizClientMsgId = "";
        }
        if (this.etU) {
          ((ContentValues)localObject).put("bizClientMsgId", this.field_bizClientMsgId);
        }
        if (this.field_rankSessionId == null) {
          this.field_rankSessionId = "";
        }
        if (this.etV) {
          ((ContentValues)localObject).put("rankSessionId", this.field_rankSessionId);
        }
        if (this.systemRowid > 0L) {
          ((ContentValues)localObject).put("rowid", Long.valueOf(this.systemRowid));
        }
        return localObject;
        localException = localException;
        ac.e("MicroMsg.SDK.BaseBizTimeLineInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ac.e("MicroMsg.SDK.BaseBizTimeLineInfo", localIOException.getMessage());
        }
      }
    }
  }
  
  public final void jA(int paramInt)
  {
    this.euk = paramInt;
    this.etL = true;
  }
  
  public final void qf(String paramString)
  {
    this.eul = paramString;
    this.etL = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.am
 * JD-Core Version:    0.7.0.1
 */