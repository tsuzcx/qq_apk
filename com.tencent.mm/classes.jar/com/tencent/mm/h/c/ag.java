package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.dt;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public abstract class ag
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crg = "msgId".hashCode();
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int csD;
  private static final int csv;
  private static final int csy;
  private static final int czf = "msgSvrId".hashCode();
  private static final int czg;
  private static final int czh;
  private static final int czi;
  private static final int czj;
  private static final int czk;
  private static final int czl;
  private static final int czm;
  private static final int czn;
  private static final int czo;
  private static final int czp;
  private boolean crX = true;
  private boolean crc = true;
  private boolean crk = true;
  private boolean csa = true;
  private boolean csf = true;
  private boolean cyU = true;
  private boolean cyV = true;
  private boolean cyW = true;
  private boolean cyX = true;
  private boolean cyY = true;
  private boolean cyZ = true;
  private boolean cza = true;
  private boolean czb = true;
  private boolean czc = true;
  private boolean czd = true;
  private boolean cze = true;
  private int czq;
  private String czr;
  public dt field_appMsgStatInfoProto;
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
    csy = "type".hashCode();
    crn = "status".hashCode();
    csv = "createTime".hashCode();
    czg = "talker".hashCode();
    csD = "content".hashCode();
    czh = "imgPath".hashCode();
    czi = "lvbuffer".hashCode();
    czj = "talkerId".hashCode();
    czk = "isExpand".hashCode();
    czl = "orderFlag".hashCode();
    czm = "hasShow".hashCode();
    czn = "placeTop".hashCode();
    czo = "appMsgStatInfoProto".hashCode();
    czp = "isRead".hashCode();
  }
  
  public final void cY(String paramString)
  {
    this.czr = paramString;
    this.cyX = true;
  }
  
  public final void d(Cursor paramCursor)
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
          if (crg == k)
          {
            this.field_msgId = paramCursor.getLong(i);
            this.crc = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (czf == k)
            {
              this.field_msgSvrId = paramCursor.getLong(i);
            }
            else if (csy == k)
            {
              this.field_type = paramCursor.getInt(i);
            }
            else if (crn == k)
            {
              this.field_status = paramCursor.getInt(i);
            }
            else if (csv == k)
            {
              this.field_createTime = paramCursor.getLong(i);
            }
            else if (czg == k)
            {
              this.field_talker = paramCursor.getString(i);
            }
            else if (csD == k)
            {
              this.field_content = paramCursor.getString(i);
            }
            else if (czh == k)
            {
              this.field_imgPath = paramCursor.getString(i);
            }
            else if (czi == k)
            {
              this.field_lvbuffer = paramCursor.getBlob(i);
            }
            else if (czj == k)
            {
              this.field_talkerId = paramCursor.getInt(i);
            }
            else
            {
              if (czk == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (boolean bool = true;; bool = false)
                {
                  this.field_isExpand = bool;
                  break;
                }
              }
              if (czl == k) {
                this.field_orderFlag = paramCursor.getLong(i);
              } else if (czm == k) {
                this.field_hasShow = paramCursor.getInt(i);
              } else if (czn == k) {
                this.field_placeTop = paramCursor.getInt(i);
              } else if (czo == k) {
                try
                {
                  byte[] arrayOfByte = paramCursor.getBlob(i);
                  if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
                    continue;
                  }
                  this.field_appMsgStatInfoProto = ((dt)new dt().aH(arrayOfByte));
                }
                catch (IOException localIOException)
                {
                  y.e("MicroMsg.SDK.BaseBizTimeLineInfo", localIOException.getMessage());
                }
              } else if (czp == k) {
                this.field_isRead = paramCursor.getInt(i);
              } else if (crh == k) {
                this.ujK = paramCursor.getLong(i);
              }
            }
          }
        }
        try
        {
          if ((this.field_lvbuffer != null) && (this.field_lvbuffer.length != 0))
          {
            paramCursor = new v();
            i = paramCursor.bA(this.field_lvbuffer);
            if (i != 0)
            {
              y.e("MicroMsg.SDK.BaseBizTimeLineInfo", "parse LVBuffer error:" + i);
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          y.e("MicroMsg.SDK.BaseBizTimeLineInfo", "get value failed");
          return;
        }
      }
      if (!paramCursor.cqx()) {
        this.czq = paramCursor.getInt();
      }
    } while (paramCursor.cqx());
    this.czr = paramCursor.getString();
  }
  
  public final void ff(int paramInt)
  {
    this.czq = paramInt;
    this.cyX = true;
  }
  
  public final ContentValues vf()
  {
    try
    {
      if (this.cyX)
      {
        localObject = new v();
        ((v)localObject).cqy();
        ((v)localObject).Fb(this.czq);
        ((v)localObject).Zg(this.czr);
        this.field_lvbuffer = ((v)localObject).cqz();
      }
      localObject = new ContentValues();
      if (this.crc) {
        ((ContentValues)localObject).put("msgId", Long.valueOf(this.field_msgId));
      }
      if (this.cyU) {
        ((ContentValues)localObject).put("msgSvrId", Long.valueOf(this.field_msgSvrId));
      }
      if (this.csa) {
        ((ContentValues)localObject).put("type", Integer.valueOf(this.field_type));
      }
      if (this.crk) {
        ((ContentValues)localObject).put("status", Integer.valueOf(this.field_status));
      }
      if (this.crX) {
        ((ContentValues)localObject).put("createTime", Long.valueOf(this.field_createTime));
      }
      if (this.cyV) {
        ((ContentValues)localObject).put("talker", this.field_talker);
      }
      if (this.field_content == null) {
        this.field_content = "";
      }
      if (this.csf) {
        ((ContentValues)localObject).put("content", this.field_content);
      }
      if (this.cyW) {
        ((ContentValues)localObject).put("imgPath", this.field_imgPath);
      }
      if (this.cyX) {
        ((ContentValues)localObject).put("lvbuffer", this.field_lvbuffer);
      }
      if (this.cyY) {
        ((ContentValues)localObject).put("talkerId", Integer.valueOf(this.field_talkerId));
      }
      if (this.cyZ) {
        ((ContentValues)localObject).put("isExpand", Boolean.valueOf(this.field_isExpand));
      }
      if (this.cza) {
        ((ContentValues)localObject).put("orderFlag", Long.valueOf(this.field_orderFlag));
      }
      if (this.czb) {
        ((ContentValues)localObject).put("hasShow", Integer.valueOf(this.field_hasShow));
      }
      if (this.czc) {
        ((ContentValues)localObject).put("placeTop", Integer.valueOf(this.field_placeTop));
      }
      if ((!this.czd) || (this.field_appMsgStatInfoProto == null)) {}
    }
    catch (Exception localException)
    {
      try
      {
        Object localObject;
        ((ContentValues)localObject).put("appMsgStatInfoProto", this.field_appMsgStatInfoProto.toByteArray());
        if (this.cze) {
          ((ContentValues)localObject).put("isRead", Integer.valueOf(this.field_isRead));
        }
        if (this.ujK > 0L) {
          ((ContentValues)localObject).put("rowid", Long.valueOf(this.ujK));
        }
        return localObject;
        localException = localException;
        y.e("MicroMsg.SDK.BaseBizTimeLineInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          y.e("MicroMsg.SDK.BaseBizTimeLineInfo", localIOException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.c.ag
 * JD-Core Version:    0.7.0.1
 */