package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.gf;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class an
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int content_HASHCODE;
  private static final int createTime_HASHCODE;
  private static final int fjf = "msgId".hashCode();
  private static final int fjl;
  private static final int foC = "bitFlag".hashCode();
  private static final int fqA;
  private static final int fqB;
  private static final int fqC;
  private static final int fqD;
  private static final int fqE;
  private static final int fqF;
  private static final int fqG = "bizClientMsgId".hashCode();
  private static final int fqH = "rankSessionId".hashCode();
  private static final int fqI = "recommendCardId".hashCode();
  private static final int fqv = "msgSvrId".hashCode();
  private static final int fqw;
  private static final int fqx;
  private static final int fqy;
  private static final int fqz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSetcontent = true;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSettype = true;
  public gf field_appMsgStatInfoProto;
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
  private boolean fjb = true;
  private boolean fji = true;
  private boolean fop = true;
  private int fqJ;
  public String fqK;
  protected byte[] fqL;
  public long fqM;
  private boolean fqh = true;
  private boolean fqi = true;
  private boolean fqj = true;
  protected boolean fqk = true;
  private boolean fql = true;
  private boolean fqm = true;
  private boolean fqn = true;
  private boolean fqo = true;
  private boolean fqp = true;
  private boolean fqq = true;
  private boolean fqr = true;
  private boolean fqs = true;
  private boolean fqt = true;
  private boolean fqu = true;
  
  static
  {
    fjl = "status".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    fqw = "talker".hashCode();
    content_HASHCODE = "content".hashCode();
    fqx = "imgPath".hashCode();
    fqy = "lvbuffer".hashCode();
    fqz = "talkerId".hashCode();
    fqA = "isExpand".hashCode();
    fqB = "orderFlag".hashCode();
    fqC = "hasShow".hashCode();
    fqD = "placeTop".hashCode();
    fqE = "appMsgStatInfoProto".hashCode();
    fqF = "isRead".hashCode();
  }
  
  public final void BB(String paramString)
  {
    this.fqK = paramString;
    this.fqk = true;
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
            if (fqv == k)
            {
              this.field_msgSvrId = paramCursor.getLong(i);
            }
            else if (type_HASHCODE == k)
            {
              this.field_type = paramCursor.getInt(i);
            }
            else if (fjl == k)
            {
              this.field_status = paramCursor.getInt(i);
            }
            else if (createTime_HASHCODE == k)
            {
              this.field_createTime = paramCursor.getLong(i);
            }
            else if (fqw == k)
            {
              this.field_talker = paramCursor.getString(i);
            }
            else if (content_HASHCODE == k)
            {
              this.field_content = paramCursor.getString(i);
            }
            else if (fqx == k)
            {
              this.field_imgPath = paramCursor.getString(i);
            }
            else if (fqy == k)
            {
              this.field_lvbuffer = paramCursor.getBlob(i);
            }
            else if (fqz == k)
            {
              this.field_talkerId = paramCursor.getInt(i);
            }
            else
            {
              if (fqA == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (boolean bool = true;; bool = false)
                {
                  this.field_isExpand = bool;
                  break;
                }
              }
              if (fqB == k) {
                this.field_orderFlag = paramCursor.getLong(i);
              } else if (fqC == k) {
                this.field_hasShow = paramCursor.getInt(i);
              } else if (fqD == k) {
                this.field_placeTop = paramCursor.getInt(i);
              } else if (fqE == k) {
                try
                {
                  byte[] arrayOfByte = paramCursor.getBlob(i);
                  if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
                    continue;
                  }
                  this.field_appMsgStatInfoProto = ((gf)new gf().parseFrom(arrayOfByte));
                }
                catch (IOException localIOException)
                {
                  Log.e("MicroMsg.SDK.BaseBizTimeLineInfo", localIOException.getMessage());
                }
              } else if (fqF == k) {
                this.field_isRead = paramCursor.getInt(i);
              } else if (foC == k) {
                this.field_bitFlag = paramCursor.getInt(i);
              } else if (fqG == k) {
                this.field_bizClientMsgId = paramCursor.getString(i);
              } else if (fqH == k) {
                this.field_rankSessionId = paramCursor.getString(i);
              } else if (fqI == k) {
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
            paramCursor = new LVBuffer();
            i = paramCursor.initParse(this.field_lvbuffer);
            if (i != 0)
            {
              Log.e("MicroMsg.SDK.BaseBizTimeLineInfo", "parse LVBuffer error:".concat(String.valueOf(i)));
              return;
            }
          }
        }
        catch (Exception paramCursor)
        {
          Log.e("MicroMsg.SDK.BaseBizTimeLineInfo", "get value failed");
          return;
        }
      }
      if (!paramCursor.checkGetFinish()) {
        this.fqJ = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fqK = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fqL = paramCursor.getBuffer();
      }
    } while (paramCursor.checkGetFinish());
    this.fqM = paramCursor.getLong();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.fqk)
      {
        localObject = new LVBuffer();
        ((LVBuffer)localObject).initBuild();
        ((LVBuffer)localObject).putInt(this.fqJ);
        ((LVBuffer)localObject).putString(this.fqK);
        ((LVBuffer)localObject).putBuffer(this.fqL);
        ((LVBuffer)localObject).putLong(this.fqM);
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
      if (this.fqk) {
        ((ContentValues)localObject).put("lvbuffer", this.field_lvbuffer);
      }
      if (this.fql) {
        ((ContentValues)localObject).put("talkerId", Integer.valueOf(this.field_talkerId));
      }
      if (this.fqm) {
        ((ContentValues)localObject).put("isExpand", Boolean.valueOf(this.field_isExpand));
      }
      if (this.fqn) {
        ((ContentValues)localObject).put("orderFlag", Long.valueOf(this.field_orderFlag));
      }
      if (this.fqo) {
        ((ContentValues)localObject).put("hasShow", Integer.valueOf(this.field_hasShow));
      }
      if (this.fqp) {
        ((ContentValues)localObject).put("placeTop", Integer.valueOf(this.field_placeTop));
      }
      if ((!this.fqq) || (this.field_appMsgStatInfoProto == null)) {}
    }
    catch (Exception localException)
    {
      try
      {
        Object localObject;
        ((ContentValues)localObject).put("appMsgStatInfoProto", this.field_appMsgStatInfoProto.toByteArray());
        if (this.fqr) {
          ((ContentValues)localObject).put("isRead", Integer.valueOf(this.field_isRead));
        }
        if (this.fop) {
          ((ContentValues)localObject).put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.field_bizClientMsgId == null) {
          this.field_bizClientMsgId = "";
        }
        if (this.fqs) {
          ((ContentValues)localObject).put("bizClientMsgId", this.field_bizClientMsgId);
        }
        if (this.field_rankSessionId == null) {
          this.field_rankSessionId = "";
        }
        if (this.fqt) {
          ((ContentValues)localObject).put("rankSessionId", this.field_rankSessionId);
        }
        if (this.field_recommendCardId == null) {
          this.field_recommendCardId = "";
        }
        if (this.fqu) {
          ((ContentValues)localObject).put("recommendCardId", this.field_recommendCardId);
        }
        if (this.systemRowid > 0L) {
          ((ContentValues)localObject).put("rowid", Long.valueOf(this.systemRowid));
        }
        return localObject;
        localException = localException;
        Log.e("MicroMsg.SDK.BaseBizTimeLineInfo", "get value failed, %s", new Object[] { localException.getMessage() });
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("MicroMsg.SDK.BaseBizTimeLineInfo", localIOException.getMessage());
        }
      }
    }
  }
  
  public final void nc(int paramInt)
  {
    this.fqJ = paramInt;
    this.fqk = true;
  }
  
  public final void yw(long paramLong)
  {
    this.fqM = paramLong;
    this.fqk = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.an
 * JD-Core Version:    0.7.0.1
 */