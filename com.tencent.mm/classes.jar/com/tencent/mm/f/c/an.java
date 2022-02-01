package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.ft;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;

public abstract class an
  extends IAutoDBItem
{
  public static final Column C_CONTENT;
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("BizTimeLineInfo");
  private static final int content_HASHCODE;
  private static final int createTime_HASHCODE;
  private static final int hmC;
  public static final Column hml;
  private static final int hmt;
  public static final Column hmw;
  public static final Column htS;
  private static final int hus = "bitFlag".hashCode();
  public static final Column hwH;
  public static final Column hwI;
  public static final Column hwJ;
  public static final Column hwK;
  public static final Column hwL;
  public static final Column hwM;
  public static final Column hwN;
  public static final Column hwO;
  public static final Column hwP;
  public static final Column hwQ;
  public static final Column hwR;
  public static final Column hwS;
  public static final Column hwT;
  public static final Column hwU;
  private static final int hxj;
  private static final int hxk;
  private static final int hxl;
  private static final int hxm;
  private static final int hxn;
  private static final int hxo;
  private static final int hxp;
  private static final int hxq;
  private static final int hxr;
  private static final int hxs;
  private static final int hxt;
  private static final int hxu = "bizClientMsgId".hashCode();
  private static final int hxv = "rankSessionId".hashCode();
  private static final int hxw = "recommendCardId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSetcontent = true;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSettype = true;
  public ft field_appMsgStatInfoProto;
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
  private boolean hmp = true;
  private boolean hmz = true;
  private boolean huf = true;
  private boolean hwV = true;
  private boolean hwW = true;
  private boolean hwX = true;
  public boolean hwY = true;
  private boolean hwZ = true;
  public long hxA;
  private boolean hxa = true;
  private boolean hxb = true;
  private boolean hxc = true;
  private boolean hxd = true;
  private boolean hxe = true;
  private boolean hxf = true;
  private boolean hxg = true;
  private boolean hxh = true;
  private boolean hxi = true;
  private int hxx;
  public String hxy;
  private byte[] hxz;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "BizTimeLineInfo", "");
    hml = new Column("msgid", "long", "BizTimeLineInfo", "");
    hwH = new Column("msgsvrid", "long", "BizTimeLineInfo", "");
    C_TYPE = new Column("type", "int", "BizTimeLineInfo", "");
    hmw = new Column("status", "int", "BizTimeLineInfo", "");
    C_CREATETIME = new Column("createtime", "long", "BizTimeLineInfo", "");
    hwI = new Column("talker", "string", "BizTimeLineInfo", "");
    C_CONTENT = new Column("content", "string", "BizTimeLineInfo", "");
    hwJ = new Column("imgpath", "string", "BizTimeLineInfo", "");
    hwK = new Column("lvbuffer", "byte[]", "BizTimeLineInfo", "");
    hwL = new Column("talkerid", "int", "BizTimeLineInfo", "");
    hwM = new Column("isexpand", "boolean", "BizTimeLineInfo", "");
    hwN = new Column("orderflag", "long", "BizTimeLineInfo", "");
    hwO = new Column("hasshow", "int", "BizTimeLineInfo", "");
    hwP = new Column("placetop", "int", "BizTimeLineInfo", "");
    hwQ = new Column("appmsgstatinfoproto", "proto", "BizTimeLineInfo", "com.tencent.mm.protocal.protobuf.AppMsgStatInfo");
    hwR = new Column("isread", "int", "BizTimeLineInfo", "");
    htS = new Column("bitflag", "int", "BizTimeLineInfo", "");
    hwS = new Column("bizclientmsgid", "string", "BizTimeLineInfo", "");
    hwT = new Column("ranksessionid", "string", "BizTimeLineInfo", "");
    hwU = new Column("recommendcardid", "string", "BizTimeLineInfo", "");
    hmt = "msgId".hashCode();
    hxj = "msgSvrId".hashCode();
    type_HASHCODE = "type".hashCode();
    hmC = "status".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    hxk = "talker".hashCode();
    content_HASHCODE = "content".hashCode();
    hxl = "imgPath".hashCode();
    hxm = "lvbuffer".hashCode();
    hxn = "talkerId".hashCode();
    hxo = "isExpand".hashCode();
    hxp = "orderFlag".hashCode();
    hxq = "hasShow".hashCode();
    hxr = "placeTop".hashCode();
    hxs = "appMsgStatInfoProto".hashCode();
    hxt = "isRead".hashCode();
  }
  
  public final void Ip(String paramString)
  {
    this.hxy = paramString;
    this.hwY = true;
  }
  
  public final String apc()
  {
    return this.hxy;
  }
  
  public final byte[] apd()
  {
    return this.hxz;
  }
  
  public final void ape()
  {
    this.hxz = null;
    this.hwY = true;
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
          if (hmt == k)
          {
            this.field_msgId = paramCursor.getLong(i);
            this.hmp = true;
          }
          for (;;)
          {
            i += 1;
            break;
            if (hxj == k)
            {
              this.field_msgSvrId = paramCursor.getLong(i);
            }
            else if (type_HASHCODE == k)
            {
              this.field_type = paramCursor.getInt(i);
            }
            else if (hmC == k)
            {
              this.field_status = paramCursor.getInt(i);
            }
            else if (createTime_HASHCODE == k)
            {
              this.field_createTime = paramCursor.getLong(i);
            }
            else if (hxk == k)
            {
              this.field_talker = paramCursor.getString(i);
            }
            else if (content_HASHCODE == k)
            {
              this.field_content = paramCursor.getString(i);
            }
            else if (hxl == k)
            {
              this.field_imgPath = paramCursor.getString(i);
            }
            else if (hxm == k)
            {
              this.field_lvbuffer = paramCursor.getBlob(i);
            }
            else if (hxn == k)
            {
              this.field_talkerId = paramCursor.getInt(i);
            }
            else
            {
              if (hxo == k)
              {
                if (paramCursor.getInt(i) != 0) {}
                for (boolean bool = true;; bool = false)
                {
                  this.field_isExpand = bool;
                  break;
                }
              }
              if (hxp == k) {
                this.field_orderFlag = paramCursor.getLong(i);
              } else if (hxq == k) {
                this.field_hasShow = paramCursor.getInt(i);
              } else if (hxr == k) {
                this.field_placeTop = paramCursor.getInt(i);
              } else if (hxs == k) {
                try
                {
                  byte[] arrayOfByte = paramCursor.getBlob(i);
                  if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
                    continue;
                  }
                  this.field_appMsgStatInfoProto = ((ft)new ft().parseFrom(arrayOfByte));
                }
                catch (IOException localIOException)
                {
                  Log.e("MicroMsg.SDK.BaseBizTimeLineInfo", localIOException.getMessage());
                }
              } else if (hxt == k) {
                this.field_isRead = paramCursor.getInt(i);
              } else if (hus == k) {
                this.field_bitFlag = paramCursor.getInt(i);
              } else if (hxu == k) {
                this.field_bizClientMsgId = paramCursor.getString(i);
              } else if (hxv == k) {
                this.field_rankSessionId = paramCursor.getString(i);
              } else if (hxw == k) {
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
        this.hxx = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.hxy = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.hxz = paramCursor.getBuffer();
      }
    } while (paramCursor.checkGetFinish());
    this.hxA = paramCursor.getLong();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.hwY)
      {
        localObject = new LVBuffer();
        ((LVBuffer)localObject).initBuild();
        ((LVBuffer)localObject).putInt(this.hxx);
        ((LVBuffer)localObject).putString(this.hxy);
        ((LVBuffer)localObject).putBuffer(this.hxz);
        ((LVBuffer)localObject).putLong(this.hxA);
        this.field_lvbuffer = ((LVBuffer)localObject).buildFinish();
      }
      localObject = new ContentValues();
      if (this.hmp) {
        ((ContentValues)localObject).put("msgId", Long.valueOf(this.field_msgId));
      }
      if (this.hwV) {
        ((ContentValues)localObject).put("msgSvrId", Long.valueOf(this.field_msgSvrId));
      }
      if (this.__hadSettype) {
        ((ContentValues)localObject).put("type", Integer.valueOf(this.field_type));
      }
      if (this.hmz) {
        ((ContentValues)localObject).put("status", Integer.valueOf(this.field_status));
      }
      if (this.__hadSetcreateTime) {
        ((ContentValues)localObject).put("createTime", Long.valueOf(this.field_createTime));
      }
      if (this.hwW) {
        ((ContentValues)localObject).put("talker", this.field_talker);
      }
      if (this.field_content == null) {
        this.field_content = "";
      }
      if (this.__hadSetcontent) {
        ((ContentValues)localObject).put("content", this.field_content);
      }
      if (this.hwX) {
        ((ContentValues)localObject).put("imgPath", this.field_imgPath);
      }
      if (this.hwY) {
        ((ContentValues)localObject).put("lvbuffer", this.field_lvbuffer);
      }
      if (this.hwZ) {
        ((ContentValues)localObject).put("talkerId", Integer.valueOf(this.field_talkerId));
      }
      if (this.hxa) {
        ((ContentValues)localObject).put("isExpand", Boolean.valueOf(this.field_isExpand));
      }
      if (this.hxb) {
        ((ContentValues)localObject).put("orderFlag", Long.valueOf(this.field_orderFlag));
      }
      if (this.hxc) {
        ((ContentValues)localObject).put("hasShow", Integer.valueOf(this.field_hasShow));
      }
      if (this.hxd) {
        ((ContentValues)localObject).put("placeTop", Integer.valueOf(this.field_placeTop));
      }
      if ((!this.hxe) || (this.field_appMsgStatInfoProto == null)) {}
    }
    catch (Exception localException)
    {
      try
      {
        Object localObject;
        ((ContentValues)localObject).put("appMsgStatInfoProto", this.field_appMsgStatInfoProto.toByteArray());
        if (this.hxf) {
          ((ContentValues)localObject).put("isRead", Integer.valueOf(this.field_isRead));
        }
        if (this.huf) {
          ((ContentValues)localObject).put("bitFlag", Integer.valueOf(this.field_bitFlag));
        }
        if (this.field_bizClientMsgId == null) {
          this.field_bizClientMsgId = "";
        }
        if (this.hxg) {
          ((ContentValues)localObject).put("bizClientMsgId", this.field_bizClientMsgId);
        }
        if (this.field_rankSessionId == null) {
          this.field_rankSessionId = "";
        }
        if (this.hxh) {
          ((ContentValues)localObject).put("rankSessionId", this.field_rankSessionId);
        }
        if (this.field_recommendCardId == null) {
          this.field_recommendCardId = "";
        }
        if (this.hxi) {
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
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "BizTimeLineInfo";
  }
  
  public final void pp(int paramInt)
  {
    this.hxx = paramInt;
    this.hwY = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.an
 * JD-Core Version:    0.7.0.1
 */