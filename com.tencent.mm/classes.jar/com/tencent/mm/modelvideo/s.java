package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.byg;
import com.tencent.mm.protocal.protobuf.dld;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.Map;

public final class s
{
  String clientId;
  public long createTime;
  public int dAe;
  public long dCd;
  public String dED;
  public int dEu;
  public String dIA;
  public String dJw;
  public int fLK;
  public String fileName;
  public int hKI;
  public int hPI;
  public String iuC;
  public int ivD;
  public long ivn;
  public String iwS;
  public int iwU;
  public int iwV;
  public int iwW;
  public long iwX;
  public long iwY;
  public int iwZ;
  public int ixa;
  public int ixb;
  public int ixc;
  public int ixd;
  public String ixe;
  public int ixf;
  public String ixg;
  public dld ixh;
  public byg ixi;
  int ixj;
  String ixk;
  private boolean ixl;
  private boolean ixm;
  public int status;
  public int videoFormat;
  
  public s()
  {
    AppMethodBeat.i(126948);
    this.dEu = -1;
    this.fileName = "";
    this.clientId = "";
    this.dCd = 0L;
    this.ivD = 0;
    this.iwU = 0;
    this.hPI = 0;
    this.iwV = 0;
    this.iwW = 0;
    this.status = 0;
    this.createTime = 0L;
    this.iwX = 0L;
    this.iwY = 0L;
    this.hKI = 0;
    this.iwZ = 0;
    this.ixa = 0;
    this.ixb = 0;
    this.dED = "";
    this.iwS = "";
    this.ixc = 0;
    this.ixd = 0;
    this.iuC = "";
    this.ixe = "";
    this.ixf = 0;
    this.ivn = 0L;
    this.ixg = "";
    this.dJw = "";
    this.ixh = new dld();
    this.dIA = "";
    this.fLK = 0;
    this.ixi = new byg();
    this.dAe = 0;
    this.videoFormat = 0;
    AppMethodBeat.o(126948);
  }
  
  public static String HA(String paramString)
  {
    AppMethodBeat.i(126949);
    try
    {
      paramString = bx.M(paramString, "msg");
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
  
  private byte[] aNr()
  {
    AppMethodBeat.i(126952);
    Object localObject = new byte[0];
    try
    {
      byte[] arrayOfByte = this.ixh.toByteArray();
      localObject = arrayOfByte;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.VideoInfo", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(126952);
    return localObject;
  }
  
  private byte[] aNx()
  {
    AppMethodBeat.i(126956);
    Object localObject = new byte[0];
    try
    {
      byte[] arrayOfByte = this.ixi.toByteArray();
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
    this.ixh = new dld();
    try
    {
      this.ixh.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(126953);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ae.printErrStackTrace("MicroMsg.VideoInfo", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(126953);
    }
  }
  
  private void ae(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126955);
    this.ixi = new byg();
    try
    {
      this.ixi.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(126955);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(126955);
    }
  }
  
  public final void HB(String paramString)
  {
    this.ixk = paramString;
    this.ixm = true;
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(126954);
    if (this.ixh == null) {
      this.ixh = new dld();
    }
    this.ixh.hEV = paramString2;
    this.ixh.GBN = paramInt;
    this.ixh.hET = paramString1;
    this.ixh.hEW = paramString3;
    this.ixh.hEX = paramString4;
    this.ixh.hEZ = paramString5;
    this.ixh.hFa = paramString6;
    AppMethodBeat.o(126954);
  }
  
  public final int aIw()
  {
    return this.hPI;
  }
  
  public final String aNq()
  {
    if (this.iwS == null) {
      return "";
    }
    return this.iwS;
  }
  
  public final String aNs()
  {
    if (this.iuC == null) {
      return "";
    }
    return this.iuC;
  }
  
  public final String aNt()
  {
    if (this.ixe == null) {
      return "";
    }
    return this.ixe;
  }
  
  public final boolean aNu()
  {
    return (this.status == 140) || (this.status == 141) || (this.status == 142);
  }
  
  public final boolean aNv()
  {
    return (this.status == 121) || (this.status == 122) || (this.status == 120) || (this.status == 123);
  }
  
  public final boolean aNw()
  {
    return (this.status == 199) || (this.status == 199);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(126950);
    this.fileName = paramCursor.getString(0);
    this.clientId = paramCursor.getString(1);
    this.dCd = paramCursor.getLong(2);
    this.ivD = paramCursor.getInt(3);
    this.iwU = paramCursor.getInt(4);
    this.hPI = paramCursor.getInt(5);
    this.iwV = paramCursor.getInt(6);
    this.iwW = paramCursor.getInt(7);
    this.status = paramCursor.getInt(8);
    this.createTime = paramCursor.getLong(9);
    this.iwX = paramCursor.getLong(10);
    this.iwY = paramCursor.getLong(11);
    this.hKI = paramCursor.getInt(12);
    this.iwZ = paramCursor.getInt(13);
    this.ixa = paramCursor.getInt(14);
    this.ixb = paramCursor.getInt(15);
    this.dED = paramCursor.getString(16);
    this.iwS = paramCursor.getString(17);
    this.ixc = paramCursor.getInt(18);
    this.ixd = paramCursor.getInt(19);
    this.iuC = paramCursor.getString(20);
    this.ixe = paramCursor.getString(21);
    this.ixf = paramCursor.getInt(22);
    this.ivn = paramCursor.getLong(23);
    this.ixg = paramCursor.getString(24);
    this.dJw = paramCursor.getString(25);
    ad(paramCursor.getBlob(26));
    this.dIA = paramCursor.getString(27);
    this.fLK = paramCursor.getInt(28);
    ae(paramCursor.getBlob(29));
    this.dAe = paramCursor.getInt(30);
    this.videoFormat = paramCursor.getInt(31);
    this.ixj = paramCursor.getInt(32);
    this.ixk = paramCursor.getString(33);
    AppMethodBeat.o(126950);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(126951);
    ContentValues localContentValues = new ContentValues();
    if ((this.dEu & 0x1) != 0) {
      localContentValues.put("filename", getFileName());
    }
    if ((this.dEu & 0x2) != 0) {
      if (this.clientId != null) {
        break label821;
      }
    }
    label821:
    for (String str = "";; str = this.clientId)
    {
      localContentValues.put("clientid", str);
      if ((this.dEu & 0x4) != 0) {
        localContentValues.put("msgsvrid", Long.valueOf(this.dCd));
      }
      if ((this.dEu & 0x8) != 0) {
        localContentValues.put("netoffset", Integer.valueOf(this.ivD));
      }
      if ((this.dEu & 0x10) != 0) {
        localContentValues.put("filenowsize", Integer.valueOf(this.iwU));
      }
      if ((this.dEu & 0x20) != 0) {
        localContentValues.put("totallen", Integer.valueOf(this.hPI));
      }
      if ((this.dEu & 0x40) != 0) {
        localContentValues.put("thumbnetoffset", Integer.valueOf(this.iwV));
      }
      if ((this.dEu & 0x80) != 0) {
        localContentValues.put("thumblen", Integer.valueOf(this.iwW));
      }
      if ((this.dEu & 0x100) != 0) {
        localContentValues.put("status", Integer.valueOf(this.status));
      }
      if ((this.dEu & 0x200) != 0) {
        localContentValues.put("createtime", Long.valueOf(this.createTime));
      }
      if ((this.dEu & 0x400) != 0) {
        localContentValues.put("lastmodifytime", Long.valueOf(this.iwX));
      }
      if ((this.dEu & 0x800) != 0) {
        localContentValues.put("downloadtime", Long.valueOf(this.iwY));
      }
      if ((this.dEu & 0x1000) != 0) {
        localContentValues.put("videolength", Integer.valueOf(this.hKI));
      }
      if ((this.dEu & 0x2000) != 0) {
        localContentValues.put("msglocalid", Integer.valueOf(this.iwZ));
      }
      if ((this.dEu & 0x4000) != 0) {
        localContentValues.put("nettimes", Integer.valueOf(this.ixa));
      }
      if ((this.dEu & 0x8000) != 0) {
        localContentValues.put("cameratype", Integer.valueOf(this.ixb));
      }
      if ((this.dEu & 0x10000) != 0) {
        localContentValues.put("user", getUser());
      }
      if ((this.dEu & 0x20000) != 0) {
        localContentValues.put("human", aNq());
      }
      if ((this.dEu & 0x40000) != 0) {
        localContentValues.put("reserved1", Integer.valueOf(this.ixc));
      }
      if ((this.dEu & 0x80000) != 0) {
        localContentValues.put("reserved2", Integer.valueOf(this.ixd));
      }
      if ((this.dEu & 0x100000) != 0) {
        localContentValues.put("reserved3", aNs());
      }
      if ((this.dEu & 0x200000) != 0) {
        localContentValues.put("reserved4", aNt());
      }
      if ((this.dEu & 0x400000) != 0) {
        localContentValues.put("videofuncflag", Integer.valueOf(this.ixf));
      }
      if ((this.dEu & 0x800000) != 0) {
        localContentValues.put("masssendid", Long.valueOf(this.ivn));
      }
      if ((this.dEu & 0x1000000) != 0) {
        localContentValues.put("masssendlist", this.ixg);
      }
      if ((this.dEu & 0x2000000) != 0) {
        localContentValues.put("videomd5", this.dJw);
      }
      if ((this.dEu & 0x4000000) != 0) {
        localContentValues.put("streamvideo", aNr());
      }
      if ((this.dEu & 0x8000000) != 0) {
        localContentValues.put("statextstr", this.dIA);
      }
      if ((this.dEu & 0x10000000) != 0) {
        localContentValues.put("downloadscene", Integer.valueOf(this.fLK));
      }
      if ((this.dEu & 0x20000000) != 0) {
        localContentValues.put("mmsightextinfo", aNx());
      }
      if ((this.dEu & 0x1) != 0) {
        localContentValues.put("preloadsize", Integer.valueOf(this.dAe));
      }
      if ((this.dEu & 0x2) != 0) {
        localContentValues.put("videoformat", Integer.valueOf(this.videoFormat));
      }
      if (this.ixl) {
        localContentValues.put("forward_msg_local_id", Integer.valueOf(this.ixj));
      }
      if (this.ixm) {
        localContentValues.put("msg_uuid", this.ixk);
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
    if (this.dED == null) {
      return "";
    }
    return this.dED;
  }
  
  public final void qo(int paramInt)
  {
    this.ixj = paramInt;
    this.ixl = true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(126947);
    String str = "VideoInfo{fileName='" + this.fileName + '\'' + ", clientId='" + this.clientId + '\'' + ", msgSvrId=" + this.dCd + ", netOffset=" + this.ivD + ", fileNowSize=" + this.iwU + ", totalLen=" + this.hPI + ", thumbNetOffset=" + this.iwV + ", thumbLen=" + this.iwW + ", status=" + this.status + ", createTime=" + this.createTime + ", lastModifyTime=" + this.iwX + ", priorityTime=" + this.iwY + ", videoLength=" + this.hKI + ", msgLocalId=" + this.iwZ + ", netTimes=" + this.ixa + ", cameraType=" + this.ixb + ", user='" + this.dED + '\'' + ", human='" + this.iwS + '\'' + ", isExport=" + this.ixc + ", isUseCdn=" + this.ixd + ", importPath='" + this.iuC + '\'' + ", recvXml='" + this.ixe + '\'' + ", videoFuncFlag=" + this.ixf + ", massSendId=" + this.ivn + ", massSendList='" + this.ixg + '\'' + ", videoMD5='" + this.dJw + '\'' + ", streamVideoProto=" + this.ixh + ", statextstr='" + this.dIA + '\'' + ", downloadScene=" + this.fLK + ", mmSightExtInfo=" + this.ixi + ", preloadSize=" + this.dAe + ", videoFormat=" + this.videoFormat + ", flag=" + this.dEu + '}';
    AppMethodBeat.o(126947);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.s
 * JD-Core Version:    0.7.0.1
 */