package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.protocal.protobuf.dki;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

public final class s
{
  String clientId;
  public long createTime;
  public long dAY;
  public int dDp;
  public String dDy;
  public String dHv;
  public String dIs;
  public int dyZ;
  public int fJH;
  public String fileName;
  public int hHQ;
  public int hMP;
  public String irI;
  public int isJ;
  public long ist;
  public String itY;
  public int iua;
  public int iub;
  public int iuc;
  public long iud;
  public long iue;
  public int iuf;
  public int iug;
  public int iuh;
  public int iui;
  public int iuj;
  public String iuk;
  public int iul;
  public String ium;
  public dki iun;
  public bxm iuo;
  int iup;
  String iuq;
  private boolean iur;
  private boolean ius;
  public int status;
  public int videoFormat;
  
  public s()
  {
    AppMethodBeat.i(126948);
    this.dDp = -1;
    this.fileName = "";
    this.clientId = "";
    this.dAY = 0L;
    this.isJ = 0;
    this.iua = 0;
    this.hMP = 0;
    this.iub = 0;
    this.iuc = 0;
    this.status = 0;
    this.createTime = 0L;
    this.iud = 0L;
    this.iue = 0L;
    this.hHQ = 0;
    this.iuf = 0;
    this.iug = 0;
    this.iuh = 0;
    this.dDy = "";
    this.itY = "";
    this.iui = 0;
    this.iuj = 0;
    this.irI = "";
    this.iuk = "";
    this.iul = 0;
    this.ist = 0L;
    this.ium = "";
    this.dIs = "";
    this.iun = new dki();
    this.dHv = "";
    this.fJH = 0;
    this.iuo = new bxm();
    this.dyZ = 0;
    this.videoFormat = 0;
    AppMethodBeat.o(126948);
  }
  
  public static String GY(String paramString)
  {
    AppMethodBeat.i(126949);
    try
    {
      paramString = bw.M(paramString, "msg");
      if (paramString != null)
      {
        paramString = (String)paramString.get(".msg.videomsg.$cdnvideourl");
        AppMethodBeat.o(126949);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(126949);
    }
    return "";
  }
  
  private byte[] aMT()
  {
    AppMethodBeat.i(126952);
    Object localObject = new byte[0];
    try
    {
      byte[] arrayOfByte = this.iun.toByteArray();
      localObject = arrayOfByte;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.VideoInfo", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(126952);
    return localObject;
  }
  
  private byte[] aMZ()
  {
    AppMethodBeat.i(126956);
    Object localObject = new byte[0];
    try
    {
      byte[] arrayOfByte = this.iuo.toByteArray();
      localObject = arrayOfByte;
    }
    catch (Exception localException)
    {
      label19:
      break label19;
    }
    AppMethodBeat.o(126956);
    return localObject;
  }
  
  private void ad(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126953);
    this.iun = new dki();
    try
    {
      this.iun.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(126953);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.printErrStackTrace("MicroMsg.VideoInfo", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(126953);
    }
  }
  
  private void ae(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126955);
    this.iuo = new bxm();
    try
    {
      this.iuo.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(126955);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(126955);
    }
  }
  
  public final void GZ(String paramString)
  {
    this.iuq = paramString;
    this.ius = true;
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(126954);
    if (this.iun == null) {
      this.iun = new dki();
    }
    this.iun.hCg = paramString2;
    this.iun.Gje = paramInt;
    this.iun.hCe = paramString1;
    this.iun.hCh = paramString3;
    this.iun.hCi = paramString4;
    this.iun.hCk = paramString5;
    this.iun.hCl = paramString6;
    AppMethodBeat.o(126954);
  }
  
  public final String aMS()
  {
    if (this.itY == null) {
      return "";
    }
    return this.itY;
  }
  
  public final String aMU()
  {
    if (this.irI == null) {
      return "";
    }
    return this.irI;
  }
  
  public final String aMV()
  {
    if (this.iuk == null) {
      return "";
    }
    return this.iuk;
  }
  
  public final boolean aMW()
  {
    return (this.status == 140) || (this.status == 141) || (this.status == 142);
  }
  
  public final boolean aMX()
  {
    return (this.status == 121) || (this.status == 122) || (this.status == 120) || (this.status == 123);
  }
  
  public final boolean aMY()
  {
    return (this.status == 199) || (this.status == 199);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(126950);
    this.fileName = paramCursor.getString(0);
    this.clientId = paramCursor.getString(1);
    this.dAY = paramCursor.getLong(2);
    this.isJ = paramCursor.getInt(3);
    this.iua = paramCursor.getInt(4);
    this.hMP = paramCursor.getInt(5);
    this.iub = paramCursor.getInt(6);
    this.iuc = paramCursor.getInt(7);
    this.status = paramCursor.getInt(8);
    this.createTime = paramCursor.getLong(9);
    this.iud = paramCursor.getLong(10);
    this.iue = paramCursor.getLong(11);
    this.hHQ = paramCursor.getInt(12);
    this.iuf = paramCursor.getInt(13);
    this.iug = paramCursor.getInt(14);
    this.iuh = paramCursor.getInt(15);
    this.dDy = paramCursor.getString(16);
    this.itY = paramCursor.getString(17);
    this.iui = paramCursor.getInt(18);
    this.iuj = paramCursor.getInt(19);
    this.irI = paramCursor.getString(20);
    this.iuk = paramCursor.getString(21);
    this.iul = paramCursor.getInt(22);
    this.ist = paramCursor.getLong(23);
    this.ium = paramCursor.getString(24);
    this.dIs = paramCursor.getString(25);
    ad(paramCursor.getBlob(26));
    this.dHv = paramCursor.getString(27);
    this.fJH = paramCursor.getInt(28);
    ae(paramCursor.getBlob(29));
    this.dyZ = paramCursor.getInt(30);
    this.videoFormat = paramCursor.getInt(31);
    this.iup = paramCursor.getInt(32);
    this.iuq = paramCursor.getString(33);
    AppMethodBeat.o(126950);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(126951);
    ContentValues localContentValues = new ContentValues();
    if ((this.dDp & 0x1) != 0) {
      localContentValues.put("filename", getFileName());
    }
    if ((this.dDp & 0x2) != 0) {
      if (this.clientId != null) {
        break label819;
      }
    }
    label819:
    for (String str = "";; str = this.clientId)
    {
      localContentValues.put("clientid", str);
      if ((this.dDp & 0x4) != 0) {
        localContentValues.put("msgsvrid", Long.valueOf(this.dAY));
      }
      if ((this.dDp & 0x8) != 0) {
        localContentValues.put("netoffset", Integer.valueOf(this.isJ));
      }
      if ((this.dDp & 0x10) != 0) {
        localContentValues.put("filenowsize", Integer.valueOf(this.iua));
      }
      if ((this.dDp & 0x20) != 0) {
        localContentValues.put("totallen", Integer.valueOf(this.hMP));
      }
      if ((this.dDp & 0x40) != 0) {
        localContentValues.put("thumbnetoffset", Integer.valueOf(this.iub));
      }
      if ((this.dDp & 0x80) != 0) {
        localContentValues.put("thumblen", Integer.valueOf(this.iuc));
      }
      if ((this.dDp & 0x100) != 0) {
        localContentValues.put("status", Integer.valueOf(this.status));
      }
      if ((this.dDp & 0x200) != 0) {
        localContentValues.put("createtime", Long.valueOf(this.createTime));
      }
      if ((this.dDp & 0x400) != 0) {
        localContentValues.put("lastmodifytime", Long.valueOf(this.iud));
      }
      if ((this.dDp & 0x800) != 0) {
        localContentValues.put("downloadtime", Long.valueOf(this.iue));
      }
      if ((this.dDp & 0x1000) != 0) {
        localContentValues.put("videolength", Integer.valueOf(this.hHQ));
      }
      if ((this.dDp & 0x2000) != 0) {
        localContentValues.put("msglocalid", Integer.valueOf(this.iuf));
      }
      if ((this.dDp & 0x4000) != 0) {
        localContentValues.put("nettimes", Integer.valueOf(this.iug));
      }
      if ((this.dDp & 0x8000) != 0) {
        localContentValues.put("cameratype", Integer.valueOf(this.iuh));
      }
      if ((this.dDp & 0x10000) != 0) {
        localContentValues.put("user", getUser());
      }
      if ((this.dDp & 0x20000) != 0) {
        localContentValues.put("human", aMS());
      }
      if ((this.dDp & 0x40000) != 0) {
        localContentValues.put("reserved1", Integer.valueOf(this.iui));
      }
      if ((this.dDp & 0x80000) != 0) {
        localContentValues.put("reserved2", Integer.valueOf(this.iuj));
      }
      if ((this.dDp & 0x100000) != 0) {
        localContentValues.put("reserved3", aMU());
      }
      if ((this.dDp & 0x200000) != 0) {
        localContentValues.put("reserved4", aMV());
      }
      if ((this.dDp & 0x400000) != 0) {
        localContentValues.put("videofuncflag", Integer.valueOf(this.iul));
      }
      if ((this.dDp & 0x800000) != 0) {
        localContentValues.put("masssendid", Long.valueOf(this.ist));
      }
      if ((this.dDp & 0x1000000) != 0) {
        localContentValues.put("masssendlist", this.ium);
      }
      if ((this.dDp & 0x2000000) != 0) {
        localContentValues.put("videomd5", this.dIs);
      }
      if ((this.dDp & 0x4000000) != 0) {
        localContentValues.put("streamvideo", aMT());
      }
      if ((this.dDp & 0x8000000) != 0) {
        localContentValues.put("statextstr", this.dHv);
      }
      if ((this.dDp & 0x10000000) != 0) {
        localContentValues.put("downloadscene", Integer.valueOf(this.fJH));
      }
      if ((this.dDp & 0x20000000) != 0) {
        localContentValues.put("mmsightextinfo", aMZ());
      }
      if ((this.dDp & 0x1) != 0) {
        localContentValues.put("preloadsize", Integer.valueOf(this.dyZ));
      }
      if ((this.dDp & 0x2) != 0) {
        localContentValues.put("videoformat", Integer.valueOf(this.videoFormat));
      }
      if (this.iur) {
        localContentValues.put("forward_msg_local_id", Integer.valueOf(this.iup));
      }
      if (this.ius) {
        localContentValues.put("msg_uuid", this.iuq);
      }
      AppMethodBeat.o(126951);
      return localContentValues;
    }
  }
  
  public final String getFileName()
  {
    if (this.fileName == null) {
      return "";
    }
    return this.fileName;
  }
  
  public final String getUser()
  {
    if (this.dDy == null) {
      return "";
    }
    return this.dDy;
  }
  
  public final void ql(int paramInt)
  {
    this.iup = paramInt;
    this.iur = true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(126947);
    String str = "VideoInfo{fileName='" + this.fileName + '\'' + ", clientId='" + this.clientId + '\'' + ", msgSvrId=" + this.dAY + ", netOffset=" + this.isJ + ", fileNowSize=" + this.iua + ", totalLen=" + this.hMP + ", thumbNetOffset=" + this.iub + ", thumbLen=" + this.iuc + ", status=" + this.status + ", createTime=" + this.createTime + ", lastModifyTime=" + this.iud + ", priorityTime=" + this.iue + ", videoLength=" + this.hHQ + ", msgLocalId=" + this.iuf + ", netTimes=" + this.iug + ", cameraType=" + this.iuh + ", user='" + this.dDy + '\'' + ", human='" + this.itY + '\'' + ", isExport=" + this.iui + ", isUseCdn=" + this.iuj + ", importPath='" + this.irI + '\'' + ", recvXml='" + this.iuk + '\'' + ", videoFuncFlag=" + this.iul + ", massSendId=" + this.ist + ", massSendList='" + this.ium + '\'' + ", videoMD5='" + this.dIs + '\'' + ", streamVideoProto=" + this.iun + ", statextstr='" + this.dHv + '\'' + ", downloadScene=" + this.fJH + ", mmSightExtInfo=" + this.iuo + ", preloadSize=" + this.dyZ + ", videoFormat=" + this.videoFormat + ", flag=" + this.dDp + '}';
    AppMethodBeat.o(126947);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.s
 * JD-Core Version:    0.7.0.1
 */