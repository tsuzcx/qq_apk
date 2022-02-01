package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;

public abstract class et
  extends IAutoDBItem
{
  public static final Column C_CONTENT;
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("MsgInfo");
  private static final int content_HASHCODE;
  private static final int createTime_HASHCODE;
  private static final int hmC;
  public static final Column hml;
  private static final int hmt;
  public static final Column hmw;
  public static final Column hsS;
  public static final Column hsi;
  private static final int hsm;
  private static final int htH;
  public static final Column htd;
  private static final int htw;
  public static final Column hwH;
  public static final Column hwI;
  public static final Column hwJ;
  public static final Column hwK;
  public static final Column hwL;
  public static final Column hwS;
  public static final Column hxB;
  public static final Column hxC;
  public static final Column hxD;
  public static final Column hxE;
  public static final Column hxF;
  public static final Column hxG;
  public static final Column hxH;
  public static final Column hxI;
  private static final int hxJ;
  private static final int hxK;
  private static final int hxL;
  private static final int hxM;
  private static final int hxN;
  private static final int hxO;
  private static final int hxP = "fromUsername".hashCode();
  private static final int hxQ = "toUsername".hashCode();
  private static final int hxj;
  private static final int hxk;
  private static final int hxl;
  private static final int hxm;
  private static final int hxn;
  private static final int hxu;
  public static final Column ikU;
  public static final Column ikV;
  private static final int ilf;
  private static final int ilg = "historyId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSetcontent = false;
  private boolean __hadSetcreateTime = false;
  private boolean __hadSettype = false;
  public String fUk;
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
  private int field_isShowTimer;
  private byte[] field_lvbuffer;
  public long field_msgId;
  public long field_msgSeq;
  public long field_msgSvrId;
  public String field_reserved;
  public csq field_solitaireFoldInfo;
  public int field_status;
  public String field_talker;
  public int field_talkerId;
  private String field_toUsername;
  public String field_transBrandWording;
  public String field_transContent;
  private int field_type;
  public int fileStatus;
  private boolean hmp = false;
  private boolean hmz = false;
  private boolean hsk = false;
  private boolean hth = false;
  private boolean hts = false;
  private boolean hwV = false;
  private boolean hwW = false;
  private boolean hwX = false;
  public boolean hwY = false;
  public boolean hwZ = false;
  private boolean hxg = false;
  public int hxx;
  public String hxy;
  private boolean iaZ = false;
  private boolean ikW = false;
  private boolean ikX = false;
  private boolean ikY = false;
  public boolean ikZ = false;
  public boolean ila = false;
  public boolean ilb = false;
  private boolean ilc = false;
  private boolean ild = false;
  private boolean ile = false;
  public String ilh;
  public int ili;
  public int ilj;
  public int ilk;
  public int ill;
  public int ilm;
  public int iln;
  public String ilo;
  public String ilp;
  public String ilq;
  public int ilr;
  public byte[] ils;
  public String ilt;
  public String ilu;
  public int ilv;
  public int ilw;
  public int ilx;
  public int ily;
  public String ilz;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "MsgInfo", "");
    hml = new Column("msgid", "long", "MsgInfo", "");
    hwH = new Column("msgsvrid", "long", "MsgInfo", "");
    C_TYPE = new Column("type", "int", "MsgInfo", "");
    hmw = new Column("status", "int", "MsgInfo", "");
    htd = new Column("issend", "int", "MsgInfo", "");
    hxB = new Column("isshowtimer", "int", "MsgInfo", "");
    C_CREATETIME = new Column("createtime", "long", "MsgInfo", "");
    hwI = new Column("talker", "string", "MsgInfo", "");
    C_CONTENT = new Column("content", "string", "MsgInfo", "");
    hwJ = new Column("imgpath", "string", "MsgInfo", "");
    hxC = new Column("reserved", "string", "MsgInfo", "");
    hwK = new Column("lvbuffer", "byte[]", "MsgInfo", "");
    hwL = new Column("talkerid", "int", "MsgInfo", "");
    hxD = new Column("transcontent", "string", "MsgInfo", "");
    hxE = new Column("transbrandwording", "string", "MsgInfo", "");
    hwS = new Column("bizclientmsgid", "string", "MsgInfo", "");
    hsS = new Column("bizchatid", "long", "MsgInfo", "");
    hxF = new Column("bizchatuserid", "string", "MsgInfo", "");
    hxG = new Column("msgseq", "long", "MsgInfo", "");
    hsi = new Column("flag", "int", "MsgInfo", "");
    ikU = new Column("solitairefoldinfo", "proto", "MsgInfo", "com.tencent.mm.protocal.protobuf.LocalSolitaireFoldInfo");
    hxH = new Column("fromusername", "string", "MsgInfo", "");
    hxI = new Column("tousername", "string", "MsgInfo", "");
    ikV = new Column("historyid", "string", "MsgInfo", "");
    hmt = "msgId".hashCode();
    hxj = "msgSvrId".hashCode();
    type_HASHCODE = "type".hashCode();
    hmC = "status".hashCode();
    htH = "isSend".hashCode();
    hxJ = "isShowTimer".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    hxk = "talker".hashCode();
    content_HASHCODE = "content".hashCode();
    hxl = "imgPath".hashCode();
    hxK = "reserved".hashCode();
    hxm = "lvbuffer".hashCode();
    hxn = "talkerId".hashCode();
    hxL = "transContent".hashCode();
    hxM = "transBrandWording".hashCode();
    hxu = "bizClientMsgId".hashCode();
    htw = "bizChatId".hashCode();
    hxN = "bizChatUserId".hashCode();
    hxO = "msgSeq".hashCode();
    hsm = "flag".hashCode();
    ilf = "solitaireFoldInfo".hashCode();
  }
  
  public final void EG(long paramLong)
  {
    this.field_msgSvrId = paramLong;
    this.hwV = true;
  }
  
  public final void EH(long paramLong)
  {
    this.field_bizChatId = paramLong;
    this.hth = true;
  }
  
  public final void EI(long paramLong)
  {
    this.field_msgSeq = paramLong;
    this.iaZ = true;
  }
  
  public final void Ip(String paramString)
  {
    this.hxy = paramString;
    this.hwY = true;
  }
  
  public final void Jm(String paramString)
  {
    this.field_talker = paramString;
    this.hwW = true;
  }
  
  public final void Jn(String paramString)
  {
    this.field_imgPath = paramString;
    this.hwX = true;
  }
  
  public final void Jo(String paramString)
  {
    this.field_reserved = paramString;
    this.ikX = true;
  }
  
  public final void Jp(String paramString)
  {
    this.field_transContent = paramString;
    this.ikY = true;
  }
  
  public final void Jq(String paramString)
  {
    this.field_bizClientMsgId = paramString;
    this.hxg = true;
  }
  
  public final void Jr(String paramString)
  {
    this.field_fromUsername = paramString;
    this.ilc = true;
  }
  
  public final void Js(String paramString)
  {
    this.field_toUsername = paramString;
    this.ild = true;
  }
  
  public final void Jt(String paramString)
  {
    this.field_historyId = paramString;
    this.ile = true;
  }
  
  public final void Ju(String paramString)
  {
    this.ilh = paramString;
    this.hwY = true;
  }
  
  public final void Jv(String paramString)
  {
    this.ilp = paramString;
    this.hwY = true;
  }
  
  public final void Jw(String paramString)
  {
    this.ilq = paramString;
    this.hwY = true;
  }
  
  public final void Jx(String paramString)
  {
    this.ilt = paramString;
    this.hwY = true;
  }
  
  public final void Jy(String paramString)
  {
    this.ilu = paramString;
    this.hwY = true;
  }
  
  public final void Jz(String paramString)
  {
    this.ilz = paramString;
    this.hwY = true;
  }
  
  public final void ah(byte[] paramArrayOfByte)
  {
    this.field_lvbuffer = paramArrayOfByte;
    this.hwY = true;
  }
  
  public final int apA()
  {
    return this.field_isSend;
  }
  
  public final long apG()
  {
    return this.field_msgId;
  }
  
  public final long apH()
  {
    return this.field_msgSvrId;
  }
  
  public final int apI()
  {
    return this.field_isShowTimer;
  }
  
  public final String apJ()
  {
    return this.field_talker;
  }
  
  public final String apK()
  {
    return this.field_imgPath;
  }
  
  public final String apL()
  {
    return this.field_reserved;
  }
  
  public final byte[] apM()
  {
    return this.field_lvbuffer;
  }
  
  public final String apN()
  {
    return this.field_bizClientMsgId;
  }
  
  public final int apO()
  {
    return this.ill;
  }
  
  public final String apP()
  {
    return this.ilp;
  }
  
  public final String apQ()
  {
    return this.ilu;
  }
  
  public final int apR()
  {
    return this.ilv;
  }
  
  public final int apS()
  {
    return this.ilx;
  }
  
  public final void apT()
  {
    this.ilx = 1;
    this.hwY = true;
  }
  
  public final String apc()
  {
    return this.hxy;
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
            if (hxj == k) {
              this.field_msgSvrId = paramCursor.getLong(i);
            } else if (type_HASHCODE == k) {
              this.field_type = paramCursor.getInt(i);
            } else if (hmC == k) {
              this.field_status = paramCursor.getInt(i);
            } else if (htH == k) {
              this.field_isSend = paramCursor.getInt(i);
            } else if (hxJ == k) {
              this.field_isShowTimer = paramCursor.getInt(i);
            } else if (createTime_HASHCODE == k) {
              this.field_createTime = paramCursor.getLong(i);
            } else if (hxk == k) {
              this.field_talker = paramCursor.getString(i);
            } else if (content_HASHCODE == k) {
              this.field_content = paramCursor.getString(i);
            } else if (hxl == k) {
              this.field_imgPath = paramCursor.getString(i);
            } else if (hxK == k) {
              this.field_reserved = paramCursor.getString(i);
            } else if (hxm == k) {
              this.field_lvbuffer = paramCursor.getBlob(i);
            } else if (hxn == k) {
              this.field_talkerId = paramCursor.getInt(i);
            } else if (hxL == k) {
              this.field_transContent = paramCursor.getString(i);
            } else if (hxM == k) {
              this.field_transBrandWording = paramCursor.getString(i);
            } else if (hxu == k) {
              this.field_bizClientMsgId = paramCursor.getString(i);
            } else if (htw == k) {
              this.field_bizChatId = paramCursor.getLong(i);
            } else if (hxN == k) {
              this.field_bizChatUserId = paramCursor.getString(i);
            } else if (hxO == k) {
              this.field_msgSeq = paramCursor.getLong(i);
            } else if (hsm == k) {
              this.field_flag = paramCursor.getInt(i);
            } else if (ilf == k) {
              try
              {
                byte[] arrayOfByte = paramCursor.getBlob(i);
                if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
                  continue;
                }
                this.field_solitaireFoldInfo = ((csq)new csq().parseFrom(arrayOfByte));
              }
              catch (IOException localIOException)
              {
                Log.e("MicroMsg.SDK.BaseMsgInfo", localIOException.getMessage());
              }
            } else if (hxP == k) {
              this.field_fromUsername = paramCursor.getString(i);
            } else if (hxQ == k) {
              this.field_toUsername = paramCursor.getString(i);
            } else if (ilg == k) {
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
        this.ilh = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.hxx = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.hxy = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.ili = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.ilj = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.ilk = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.ill = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.ilm = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.iln = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.ilo = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.ilp = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.ilq = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.ilr = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fUk = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.ils = paramCursor.getBuffer();
      }
      if (!paramCursor.checkGetFinish()) {
        this.ilt = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.ilu = paramCursor.getString();
      }
      if (!paramCursor.checkGetFinish()) {
        this.ilv = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.ilw = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.ilx = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.fileStatus = paramCursor.getInt();
      }
      if (!paramCursor.checkGetFinish()) {
        this.ily = paramCursor.getInt();
      }
    } while (paramCursor.checkGetFinish());
    this.ilz = paramCursor.getString();
  }
  
  public ContentValues convertTo()
  {
    try
    {
      if (this.hwY)
      {
        localObject = new LVBuffer();
        ((LVBuffer)localObject).initBuild();
        ((LVBuffer)localObject).putString(this.ilh);
        ((LVBuffer)localObject).putInt(this.hxx);
        ((LVBuffer)localObject).putString(this.hxy);
        ((LVBuffer)localObject).putInt(this.ili);
        ((LVBuffer)localObject).putInt(this.ilj);
        ((LVBuffer)localObject).putInt(this.ilk);
        ((LVBuffer)localObject).putInt(this.ill);
        ((LVBuffer)localObject).putInt(this.ilm);
        ((LVBuffer)localObject).putInt(this.iln);
        ((LVBuffer)localObject).putString(this.ilo);
        ((LVBuffer)localObject).putString(this.ilp);
        ((LVBuffer)localObject).putString(this.ilq);
        ((LVBuffer)localObject).putInt(this.ilr);
        ((LVBuffer)localObject).putString(this.fUk);
        ((LVBuffer)localObject).putBuffer(this.ils);
        ((LVBuffer)localObject).putString(this.ilt);
        ((LVBuffer)localObject).putString(this.ilu);
        ((LVBuffer)localObject).putInt(this.ilv);
        ((LVBuffer)localObject).putInt(this.ilw);
        ((LVBuffer)localObject).putInt(this.ilx);
        ((LVBuffer)localObject).putInt(this.fileStatus);
        ((LVBuffer)localObject).putInt(this.ily);
        ((LVBuffer)localObject).putString(this.ilz);
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
      if (this.hts) {
        ((ContentValues)localObject).put("isSend", Integer.valueOf(this.field_isSend));
      }
      if (this.ikW) {
        ((ContentValues)localObject).put("isShowTimer", Integer.valueOf(this.field_isShowTimer));
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
      if (this.ikX) {
        ((ContentValues)localObject).put("reserved", this.field_reserved);
      }
      if (this.hwY) {
        ((ContentValues)localObject).put("lvbuffer", this.field_lvbuffer);
      }
      if (this.hwZ) {
        ((ContentValues)localObject).put("talkerId", Integer.valueOf(this.field_talkerId));
      }
      if (this.field_transContent == null) {
        this.field_transContent = "";
      }
      if (this.ikY) {
        ((ContentValues)localObject).put("transContent", this.field_transContent);
      }
      if (this.field_transBrandWording == null) {
        this.field_transBrandWording = "";
      }
      if (this.ikZ) {
        ((ContentValues)localObject).put("transBrandWording", this.field_transBrandWording);
      }
      if (this.field_bizClientMsgId == null) {
        this.field_bizClientMsgId = "";
      }
      if (this.hxg) {
        ((ContentValues)localObject).put("bizClientMsgId", this.field_bizClientMsgId);
      }
      if (this.hth) {
        ((ContentValues)localObject).put("bizChatId", Long.valueOf(this.field_bizChatId));
      }
      if (this.field_bizChatUserId == null) {
        this.field_bizChatUserId = "";
      }
      if (this.ila) {
        ((ContentValues)localObject).put("bizChatUserId", this.field_bizChatUserId);
      }
      if (this.iaZ) {
        ((ContentValues)localObject).put("msgSeq", Long.valueOf(this.field_msgSeq));
      }
      if (this.hsk) {
        ((ContentValues)localObject).put("flag", Integer.valueOf(this.field_flag));
      }
      if ((!this.ilb) || (this.field_solitaireFoldInfo == null)) {}
    }
    catch (Exception localException)
    {
      try
      {
        Object localObject;
        ((ContentValues)localObject).put("solitaireFoldInfo", this.field_solitaireFoldInfo.toByteArray());
        if (this.ilc) {
          ((ContentValues)localObject).put("fromUsername", this.field_fromUsername);
        }
        if (this.ild) {
          ((ContentValues)localObject).put("toUsername", this.field_toUsername);
        }
        if (this.ile) {
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
  
  public final int getFileStatus()
  {
    return this.fileStatus;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public final int getStatus()
  {
    return this.field_status;
  }
  
  public String getTableName()
  {
    return "MsgInfo";
  }
  
  public int getType()
  {
    return this.field_type;
  }
  
  public final void pJ(int paramInt)
  {
    this.field_isSend = paramInt;
    this.hts = true;
  }
  
  public final void pV(int paramInt)
  {
    this.field_isShowTimer = paramInt;
    this.ikW = true;
  }
  
  public final void pW(int paramInt)
  {
    this.ili = paramInt;
    this.hwY = true;
  }
  
  public final void pX(int paramInt)
  {
    this.ilj = paramInt;
    this.hwY = true;
  }
  
  public final void pY(int paramInt)
  {
    this.ilm = paramInt;
    this.hwY = true;
  }
  
  public final void pZ(int paramInt)
  {
    this.iln = paramInt;
    this.hwY = true;
  }
  
  public final void pp(int paramInt)
  {
    this.hxx = paramInt;
    this.hwY = true;
  }
  
  public final void qa(int paramInt)
  {
    this.ilr = paramInt;
    this.hwY = true;
  }
  
  public final void qb(int paramInt)
  {
    this.ilv = paramInt;
    this.hwY = true;
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
  
  public final void setFileStatus(int paramInt)
  {
    this.fileStatus = paramInt;
    this.hwY = true;
  }
  
  public final void setFlag(int paramInt)
  {
    this.field_flag = paramInt;
    this.hsk = true;
  }
  
  public final void setMsgId(long paramLong)
  {
    this.field_msgId = paramLong;
    this.hmp = true;
  }
  
  public void setStatus(int paramInt)
  {
    this.field_status = paramInt;
    this.hmz = true;
  }
  
  public final void setType(int paramInt)
  {
    this.field_type = paramInt;
    this.__hadSettype = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.et
 * JD-Core Version:    0.7.0.1
 */