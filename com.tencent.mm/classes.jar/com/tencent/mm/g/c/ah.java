package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.eu;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public abstract class ah
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dfD = "msgId".hashCode();
  private static final int dfJ;
  private static final int dgM;
  private static final int dgT;
  private static final int dlA = "bitFlag".hashCode();
  private static final int dng = "msgSvrId".hashCode();
  private static final int dnh;
  private static final int dni;
  private static final int dnj;
  private static final int dnk;
  private static final int dnl;
  private static final int dnm;
  private static final int dnn;
  private static final int dno;
  private static final int dnp;
  private static final int dnq;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean dfG = true;
  private boolean dfz = true;
  private boolean dgp = true;
  private boolean dgw = true;
  private boolean dlo = true;
  private boolean dmV = true;
  private boolean dmW = true;
  private boolean dmX = true;
  private boolean dmY = true;
  private boolean dmZ = true;
  private boolean dna = true;
  private boolean dnb = true;
  private boolean dnc = true;
  private boolean dnd = true;
  private boolean dne = true;
  private boolean dnf = true;
  private int dnr;
  private String dns;
  public eu field_appMsgStatInfoProto;
  public int field_bitFlag;
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
  public int field_status;
  public String field_talker;
  public int field_talkerId;
  public int field_type;
  
  static
  {
    dfJ = "status".hashCode();
    dgM = "createTime".hashCode();
    dnh = "talker".hashCode();
    dgT = "content".hashCode();
    dni = "imgPath".hashCode();
    dnj = "lvbuffer".hashCode();
    dnk = "talkerId".hashCode();
    dnl = "isExpand".hashCode();
    dnm = "orderFlag".hashCode();
    dnn = "hasShow".hashCode();
    dno = "placeTop".hashCode();
    dnp = "appMsgStatInfoProto".hashCode();
    dnq = "isRead".hashCode();
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
          if (dfD == k)
          {
            this.field_msgId = paramCursor.getLong(i);
            this.dfz = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (dng == k)
            {
              this.field_msgSvrId = paramCursor.getLong(i);
            }
            else if (type_HASHCODE == k)
            {
              this.field_type = paramCursor.getInt(i);
            }
            else if (dfJ == k)
            {
              this.field_status = paramCursor.getInt(i);
            }
            else if (dgM == k)
            {
              this.field_createTime = paramCursor.getLong(i);
            }
            else if (dnh == k)
            {
              this.field_talker = paramCursor.getString(i);
            }
            else if (dgT == k)
            {
              this.field_content = paramCursor.getString(i);
            }
            else if (dni == k)
            {
              this.field_imgPath = paramCursor.getString(i);
            }
            else if (dnj == k)
            {
              this.field_lvbuffer = paramCursor.getBlob(i);
            }
            else if (dnk == k)
            {
              this.field_talkerId = paramCursor.getInt(i);
            }
            else
            {
              if (dnl == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (boolean bool = true;; bool = false)
                {
                  this.field_isExpand = bool;
                  break;
                }
              }
              if (dnm == k) {
                this.field_orderFlag = paramCursor.getLong(i);
              } else if (dnn == k) {
                this.field_hasShow = paramCursor.getInt(i);
              } else if (dno == k) {
                this.field_placeTop = paramCursor.getInt(i);
              } else if (dnp == k) {
                try
                {
                  byte[] arrayOfByte = paramCursor.getBlob(i);
                  if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
                    continue;
                  }
                  this.field_appMsgStatInfoProto = ((eu)new eu().parseFrom(arrayOfByte));
                }
                catch (IOException localIOException)
                {
                  ab.e("MicroMsg.SDK.BaseBizTimeLineInfo", localIOException.getMessage());
                }
              } else if (dnq == k) {
                this.field_isRead = paramCursor.getInt(i);
              } else if (dlA == k) {
                this.field_bitFlag = paramCursor.getInt(i);
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
            paramCursor = new y();
            i = paramCursor.ca(this.field_lvbuffer);
            if (i != 0)
            {
              ab.e("MicroMsg.SDK.BaseBizTimeLineInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          ab.e("MicroMsg.SDK.BaseBizTimeLineInfo", "get value failed");
          return;
        }
      }
      if (!paramCursor.dsu()) {
        this.dnr = paramCursor.getInt();
      }
    } while (paramCursor.dsu());
    this.dns = paramCursor.getString();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.dmY)
      {
        localObject = new y();
        ((y)localObject).dsv();
        ((y)localObject).Nd(this.dnr);
        ((y)localObject).ape(this.dns);
        this.field_lvbuffer = ((y)localObject).dsw();
      }
      localObject = new ContentValues();
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
      if (this.dmY) {
        ((ContentValues)localObject).put("lvbuffer", this.field_lvbuffer);
      }
      if (this.dmZ) {
        ((ContentValues)localObject).put("talkerId", Integer.valueOf(this.field_talkerId));
      }
      if (this.dna) {
        ((ContentValues)localObject).put("isExpand", Boolean.valueOf(this.field_isExpand));
      }
      if (this.dnb) {
        ((ContentValues)localObject).put("orderFlag", Long.valueOf(this.field_orderFlag));
      }
      if (this.dnc) {
        ((ContentValues)localObject).put("hasShow", Integer.valueOf(this.field_hasShow));
      }
      if (this.dnd) {
        ((ContentValues)localObject).put("placeTop", Integer.valueOf(this.field_placeTop));
      }
      if ((!this.dne) || (this.field_appMsgStatInfoProto == null)) {}
    }
    catch (Exception localException)
    {
      try
      {
        Object localObject;
        ((ContentValues)localObject).put("appMsgStatInfoProto", this.field_appMsgStatInfoProto.toByteArray());
        if (this.dnf) {
          ((ContentValues)localObject).put("isRead", Integer.valueOf(this.field_isRead));
        }
        if (this.dlo) {
          ((ContentValues)localObject).put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.systemRowid > 0L) {
          ((ContentValues)localObject).put("rowid", Long.valueOf(this.systemRowid));
        }
        return localObject;
        localException = localException;
        ab.e("MicroMsg.SDK.BaseBizTimeLineInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          ab.e("MicroMsg.SDK.BaseBizTimeLineInfo", localIOException.getMessage());
        }
      }
    }
  }
  
  public final void hr(int paramInt)
  {
    this.dnr = paramInt;
    this.dmY = true;
  }
  
  public final void jl(String paramString)
  {
    this.dns = paramString;
    this.dmY = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.ah
 * JD-Core Version:    0.7.0.1
 */