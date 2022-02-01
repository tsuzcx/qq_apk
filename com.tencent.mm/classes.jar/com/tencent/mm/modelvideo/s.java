package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bsz;
import com.tencent.mm.protocal.protobuf.dev;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.Map;

public final class s
{
  String clientId;
  public long createTime;
  public int dnl;
  public long dpl;
  public String drG;
  public int drx;
  public String dvs;
  public String dwi;
  public String fileName;
  public int fry;
  public long hYX;
  public String hYm;
  public int hZn;
  public int hpy;
  public int hux;
  public String iaC;
  public int iaE;
  public int iaF;
  public int iaG;
  public long iaH;
  public long iaI;
  public int iaJ;
  public int iaK;
  public int iaL;
  public int iaM;
  public int iaN;
  public String iaO;
  public int iaP;
  public String iaQ;
  public dev iaR;
  public bsz iaS;
  int iaT;
  String iaU;
  private boolean iaV;
  private boolean iaW;
  public int status;
  public int videoFormat;
  
  public s()
  {
    AppMethodBeat.i(126948);
    this.drx = -1;
    this.fileName = "";
    this.clientId = "";
    this.dpl = 0L;
    this.hZn = 0;
    this.iaE = 0;
    this.hux = 0;
    this.iaF = 0;
    this.iaG = 0;
    this.status = 0;
    this.createTime = 0L;
    this.iaH = 0L;
    this.iaI = 0L;
    this.hpy = 0;
    this.iaJ = 0;
    this.iaK = 0;
    this.iaL = 0;
    this.drG = "";
    this.iaC = "";
    this.iaM = 0;
    this.iaN = 0;
    this.hYm = "";
    this.iaO = "";
    this.iaP = 0;
    this.hYX = 0L;
    this.iaQ = "";
    this.dwi = "";
    this.iaR = new dev();
    this.dvs = "";
    this.fry = 0;
    this.iaS = new bsz();
    this.dnl = 0;
    this.videoFormat = 0;
    AppMethodBeat.o(126948);
  }
  
  public static String DR(String paramString)
  {
    AppMethodBeat.i(126949);
    try
    {
      paramString = bv.L(paramString, "msg");
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
  
  private byte[] aJI()
  {
    AppMethodBeat.i(126952);
    Object localObject = new byte[0];
    try
    {
      byte[] arrayOfByte = this.iaR.toByteArray();
      localObject = arrayOfByte;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.VideoInfo", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(126952);
    return localObject;
  }
  
  private byte[] aJO()
  {
    AppMethodBeat.i(126956);
    Object localObject = new byte[0];
    try
    {
      byte[] arrayOfByte = this.iaS.toByteArray();
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
    this.iaR = new dev();
    try
    {
      this.iaR.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(126953);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ac.printErrStackTrace("MicroMsg.VideoInfo", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(126953);
    }
  }
  
  private void ae(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126955);
    this.iaS = new bsz();
    try
    {
      this.iaS.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(126955);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(126955);
    }
  }
  
  public final void DS(String paramString)
  {
    this.iaU = paramString;
    this.iaW = true;
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(126954);
    if (this.iaR == null) {
      this.iaR = new dev();
    }
    this.iaR.hjX = paramString2;
    this.iaR.EBs = paramInt;
    this.iaR.hjV = paramString1;
    this.iaR.hjY = paramString3;
    this.iaR.hjZ = paramString4;
    this.iaR.hkb = paramString5;
    this.iaR.hkc = paramString6;
    AppMethodBeat.o(126954);
  }
  
  public final String aJH()
  {
    if (this.iaC == null) {
      return "";
    }
    return this.iaC;
  }
  
  public final String aJJ()
  {
    if (this.hYm == null) {
      return "";
    }
    return this.hYm;
  }
  
  public final String aJK()
  {
    if (this.iaO == null) {
      return "";
    }
    return this.iaO;
  }
  
  public final boolean aJL()
  {
    return (this.status == 140) || (this.status == 141) || (this.status == 142);
  }
  
  public final boolean aJM()
  {
    return (this.status == 121) || (this.status == 122) || (this.status == 120) || (this.status == 123);
  }
  
  public final boolean aJN()
  {
    return (this.status == 199) || (this.status == 199);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(126950);
    this.fileName = paramCursor.getString(0);
    this.clientId = paramCursor.getString(1);
    this.dpl = paramCursor.getLong(2);
    this.hZn = paramCursor.getInt(3);
    this.iaE = paramCursor.getInt(4);
    this.hux = paramCursor.getInt(5);
    this.iaF = paramCursor.getInt(6);
    this.iaG = paramCursor.getInt(7);
    this.status = paramCursor.getInt(8);
    this.createTime = paramCursor.getLong(9);
    this.iaH = paramCursor.getLong(10);
    this.iaI = paramCursor.getLong(11);
    this.hpy = paramCursor.getInt(12);
    this.iaJ = paramCursor.getInt(13);
    this.iaK = paramCursor.getInt(14);
    this.iaL = paramCursor.getInt(15);
    this.drG = paramCursor.getString(16);
    this.iaC = paramCursor.getString(17);
    this.iaM = paramCursor.getInt(18);
    this.iaN = paramCursor.getInt(19);
    this.hYm = paramCursor.getString(20);
    this.iaO = paramCursor.getString(21);
    this.iaP = paramCursor.getInt(22);
    this.hYX = paramCursor.getLong(23);
    this.iaQ = paramCursor.getString(24);
    this.dwi = paramCursor.getString(25);
    ad(paramCursor.getBlob(26));
    this.dvs = paramCursor.getString(27);
    this.fry = paramCursor.getInt(28);
    ae(paramCursor.getBlob(29));
    this.dnl = paramCursor.getInt(30);
    this.videoFormat = paramCursor.getInt(31);
    this.iaT = paramCursor.getInt(32);
    this.iaU = paramCursor.getString(33);
    AppMethodBeat.o(126950);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(126951);
    ContentValues localContentValues = new ContentValues();
    if ((this.drx & 0x1) != 0) {
      localContentValues.put("filename", getFileName());
    }
    if ((this.drx & 0x2) != 0) {
      if (this.clientId != null) {
        break label819;
      }
    }
    label819:
    for (String str = "";; str = this.clientId)
    {
      localContentValues.put("clientid", str);
      if ((this.drx & 0x4) != 0) {
        localContentValues.put("msgsvrid", Long.valueOf(this.dpl));
      }
      if ((this.drx & 0x8) != 0) {
        localContentValues.put("netoffset", Integer.valueOf(this.hZn));
      }
      if ((this.drx & 0x10) != 0) {
        localContentValues.put("filenowsize", Integer.valueOf(this.iaE));
      }
      if ((this.drx & 0x20) != 0) {
        localContentValues.put("totallen", Integer.valueOf(this.hux));
      }
      if ((this.drx & 0x40) != 0) {
        localContentValues.put("thumbnetoffset", Integer.valueOf(this.iaF));
      }
      if ((this.drx & 0x80) != 0) {
        localContentValues.put("thumblen", Integer.valueOf(this.iaG));
      }
      if ((this.drx & 0x100) != 0) {
        localContentValues.put("status", Integer.valueOf(this.status));
      }
      if ((this.drx & 0x200) != 0) {
        localContentValues.put("createtime", Long.valueOf(this.createTime));
      }
      if ((this.drx & 0x400) != 0) {
        localContentValues.put("lastmodifytime", Long.valueOf(this.iaH));
      }
      if ((this.drx & 0x800) != 0) {
        localContentValues.put("downloadtime", Long.valueOf(this.iaI));
      }
      if ((this.drx & 0x1000) != 0) {
        localContentValues.put("videolength", Integer.valueOf(this.hpy));
      }
      if ((this.drx & 0x2000) != 0) {
        localContentValues.put("msglocalid", Integer.valueOf(this.iaJ));
      }
      if ((this.drx & 0x4000) != 0) {
        localContentValues.put("nettimes", Integer.valueOf(this.iaK));
      }
      if ((this.drx & 0x8000) != 0) {
        localContentValues.put("cameratype", Integer.valueOf(this.iaL));
      }
      if ((this.drx & 0x10000) != 0) {
        localContentValues.put("user", getUser());
      }
      if ((this.drx & 0x20000) != 0) {
        localContentValues.put("human", aJH());
      }
      if ((this.drx & 0x40000) != 0) {
        localContentValues.put("reserved1", Integer.valueOf(this.iaM));
      }
      if ((this.drx & 0x80000) != 0) {
        localContentValues.put("reserved2", Integer.valueOf(this.iaN));
      }
      if ((this.drx & 0x100000) != 0) {
        localContentValues.put("reserved3", aJJ());
      }
      if ((this.drx & 0x200000) != 0) {
        localContentValues.put("reserved4", aJK());
      }
      if ((this.drx & 0x400000) != 0) {
        localContentValues.put("videofuncflag", Integer.valueOf(this.iaP));
      }
      if ((this.drx & 0x800000) != 0) {
        localContentValues.put("masssendid", Long.valueOf(this.hYX));
      }
      if ((this.drx & 0x1000000) != 0) {
        localContentValues.put("masssendlist", this.iaQ);
      }
      if ((this.drx & 0x2000000) != 0) {
        localContentValues.put("videomd5", this.dwi);
      }
      if ((this.drx & 0x4000000) != 0) {
        localContentValues.put("streamvideo", aJI());
      }
      if ((this.drx & 0x8000000) != 0) {
        localContentValues.put("statextstr", this.dvs);
      }
      if ((this.drx & 0x10000000) != 0) {
        localContentValues.put("downloadscene", Integer.valueOf(this.fry));
      }
      if ((this.drx & 0x20000000) != 0) {
        localContentValues.put("mmsightextinfo", aJO());
      }
      if ((this.drx & 0x1) != 0) {
        localContentValues.put("preloadsize", Integer.valueOf(this.dnl));
      }
      if ((this.drx & 0x2) != 0) {
        localContentValues.put("videoformat", Integer.valueOf(this.videoFormat));
      }
      if (this.iaV) {
        localContentValues.put("forward_msg_local_id", Integer.valueOf(this.iaT));
      }
      if (this.iaW) {
        localContentValues.put("msg_uuid", this.iaU);
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
    if (this.drG == null) {
      return "";
    }
    return this.drG;
  }
  
  public final void pJ(int paramInt)
  {
    this.iaT = paramInt;
    this.iaV = true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(126947);
    String str = "VideoInfo{fileName='" + this.fileName + '\'' + ", clientId='" + this.clientId + '\'' + ", msgSvrId=" + this.dpl + ", netOffset=" + this.hZn + ", fileNowSize=" + this.iaE + ", totalLen=" + this.hux + ", thumbNetOffset=" + this.iaF + ", thumbLen=" + this.iaG + ", status=" + this.status + ", createTime=" + this.createTime + ", lastModifyTime=" + this.iaH + ", priorityTime=" + this.iaI + ", videoLength=" + this.hpy + ", msgLocalId=" + this.iaJ + ", netTimes=" + this.iaK + ", cameraType=" + this.iaL + ", user='" + this.drG + '\'' + ", human='" + this.iaC + '\'' + ", isExport=" + this.iaM + ", isUseCdn=" + this.iaN + ", importPath='" + this.hYm + '\'' + ", recvXml='" + this.iaO + '\'' + ", videoFuncFlag=" + this.iaP + ", massSendId=" + this.hYX + ", massSendList='" + this.iaQ + '\'' + ", videoMD5='" + this.dwi + '\'' + ", streamVideoProto=" + this.iaR + ", statextstr='" + this.dvs + '\'' + ", downloadScene=" + this.fry + ", mmSightExtInfo=" + this.iaS + ", preloadSize=" + this.dnl + ", videoFormat=" + this.videoFormat + ", flag=" + this.drx + '}';
    AppMethodBeat.o(126947);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.s
 * JD-Core Version:    0.7.0.1
 */