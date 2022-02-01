package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.Map;

public final class s
{
  String clientId;
  public long createTime;
  public int dpA;
  public long drA;
  public int dtM;
  public String dtV;
  public String dxG;
  public String dyw;
  public String fileName;
  public int foe;
  public int gOY;
  public int gTY;
  public String hAb;
  public int hAd;
  public int hAe;
  public int hAf;
  public long hAg;
  public long hAh;
  public int hAi;
  public int hAj;
  public int hAk;
  public int hAl;
  public int hAm;
  public String hAn;
  public int hAo;
  public String hAp;
  public czj hAq;
  public boj hAr;
  int hAs;
  String hAt;
  private boolean hAu;
  private boolean hAv;
  public String hxL;
  public int hyM;
  public long hyw;
  public int status;
  public int videoFormat;
  
  public s()
  {
    AppMethodBeat.i(126948);
    this.dtM = -1;
    this.fileName = "";
    this.clientId = "";
    this.drA = 0L;
    this.hyM = 0;
    this.hAd = 0;
    this.gTY = 0;
    this.hAe = 0;
    this.hAf = 0;
    this.status = 0;
    this.createTime = 0L;
    this.hAg = 0L;
    this.hAh = 0L;
    this.gOY = 0;
    this.hAi = 0;
    this.hAj = 0;
    this.hAk = 0;
    this.dtV = "";
    this.hAb = "";
    this.hAl = 0;
    this.hAm = 0;
    this.hxL = "";
    this.hAn = "";
    this.hAo = 0;
    this.hyw = 0L;
    this.hAp = "";
    this.dyw = "";
    this.hAq = new czj();
    this.dxG = "";
    this.foe = 0;
    this.hAr = new boj();
    this.dpA = 0;
    this.videoFormat = 0;
    AppMethodBeat.o(126948);
  }
  
  private byte[] aCR()
  {
    AppMethodBeat.i(126952);
    Object localObject = new byte[0];
    try
    {
      byte[] arrayOfByte = this.hAq.toByteArray();
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
  
  private byte[] aCX()
  {
    AppMethodBeat.i(126956);
    Object localObject = new byte[0];
    try
    {
      byte[] arrayOfByte = this.hAr.toByteArray();
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
  
  private void ae(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126953);
    this.hAq = new czj();
    try
    {
      this.hAq.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(126953);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.printErrStackTrace("MicroMsg.VideoInfo", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(126953);
    }
  }
  
  private void af(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126955);
    this.hAr = new boj();
    try
    {
      this.hAr.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(126955);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(126955);
    }
  }
  
  public static String zM(String paramString)
  {
    AppMethodBeat.i(126949);
    try
    {
      paramString = bw.K(paramString, "msg");
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
  
  public final void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(126954);
    if (this.hAq == null) {
      this.hAq = new czj();
    }
    this.hAq.gJx = paramString2;
    this.hAq.Dim = paramInt;
    this.hAq.gJv = paramString1;
    this.hAq.gJy = paramString3;
    this.hAq.gJz = paramString4;
    this.hAq.gJB = paramString5;
    this.hAq.gJC = paramString6;
    AppMethodBeat.o(126954);
  }
  
  public final String aCQ()
  {
    if (this.hAb == null) {
      return "";
    }
    return this.hAb;
  }
  
  public final String aCS()
  {
    if (this.hxL == null) {
      return "";
    }
    return this.hxL;
  }
  
  public final String aCT()
  {
    if (this.hAn == null) {
      return "";
    }
    return this.hAn;
  }
  
  public final boolean aCU()
  {
    return (this.status == 140) || (this.status == 141) || (this.status == 142);
  }
  
  public final boolean aCV()
  {
    return (this.status == 121) || (this.status == 122) || (this.status == 120) || (this.status == 123);
  }
  
  public final boolean aCW()
  {
    return (this.status == 199) || (this.status == 199);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(126950);
    this.fileName = paramCursor.getString(0);
    this.clientId = paramCursor.getString(1);
    this.drA = paramCursor.getLong(2);
    this.hyM = paramCursor.getInt(3);
    this.hAd = paramCursor.getInt(4);
    this.gTY = paramCursor.getInt(5);
    this.hAe = paramCursor.getInt(6);
    this.hAf = paramCursor.getInt(7);
    this.status = paramCursor.getInt(8);
    this.createTime = paramCursor.getLong(9);
    this.hAg = paramCursor.getLong(10);
    this.hAh = paramCursor.getLong(11);
    this.gOY = paramCursor.getInt(12);
    this.hAi = paramCursor.getInt(13);
    this.hAj = paramCursor.getInt(14);
    this.hAk = paramCursor.getInt(15);
    this.dtV = paramCursor.getString(16);
    this.hAb = paramCursor.getString(17);
    this.hAl = paramCursor.getInt(18);
    this.hAm = paramCursor.getInt(19);
    this.hxL = paramCursor.getString(20);
    this.hAn = paramCursor.getString(21);
    this.hAo = paramCursor.getInt(22);
    this.hyw = paramCursor.getLong(23);
    this.hAp = paramCursor.getString(24);
    this.dyw = paramCursor.getString(25);
    ae(paramCursor.getBlob(26));
    this.dxG = paramCursor.getString(27);
    this.foe = paramCursor.getInt(28);
    af(paramCursor.getBlob(29));
    this.dpA = paramCursor.getInt(30);
    this.videoFormat = paramCursor.getInt(31);
    this.hAs = paramCursor.getInt(32);
    this.hAt = paramCursor.getString(33);
    AppMethodBeat.o(126950);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(126951);
    ContentValues localContentValues = new ContentValues();
    if ((this.dtM & 0x1) != 0) {
      localContentValues.put("filename", getFileName());
    }
    if ((this.dtM & 0x2) != 0) {
      if (this.clientId != null) {
        break label818;
      }
    }
    label818:
    for (String str = "";; str = this.clientId)
    {
      localContentValues.put("clientid", str);
      if ((this.dtM & 0x4) != 0) {
        localContentValues.put("msgsvrid", Long.valueOf(this.drA));
      }
      if ((this.dtM & 0x8) != 0) {
        localContentValues.put("netoffset", Integer.valueOf(this.hyM));
      }
      if ((this.dtM & 0x10) != 0) {
        localContentValues.put("filenowsize", Integer.valueOf(this.hAd));
      }
      if ((this.dtM & 0x20) != 0) {
        localContentValues.put("totallen", Integer.valueOf(this.gTY));
      }
      if ((this.dtM & 0x40) != 0) {
        localContentValues.put("thumbnetoffset", Integer.valueOf(this.hAe));
      }
      if ((this.dtM & 0x80) != 0) {
        localContentValues.put("thumblen", Integer.valueOf(this.hAf));
      }
      if ((this.dtM & 0x100) != 0) {
        localContentValues.put("status", Integer.valueOf(this.status));
      }
      if ((this.dtM & 0x200) != 0) {
        localContentValues.put("createtime", Long.valueOf(this.createTime));
      }
      if ((this.dtM & 0x400) != 0) {
        localContentValues.put("lastmodifytime", Long.valueOf(this.hAg));
      }
      if ((this.dtM & 0x800) != 0) {
        localContentValues.put("downloadtime", Long.valueOf(this.hAh));
      }
      if ((this.dtM & 0x1000) != 0) {
        localContentValues.put("videolength", Integer.valueOf(this.gOY));
      }
      if ((this.dtM & 0x2000) != 0) {
        localContentValues.put("msglocalid", Integer.valueOf(this.hAi));
      }
      if ((this.dtM & 0x4000) != 0) {
        localContentValues.put("nettimes", Integer.valueOf(this.hAj));
      }
      if ((this.dtM & 0x8000) != 0) {
        localContentValues.put("cameratype", Integer.valueOf(this.hAk));
      }
      if ((this.dtM & 0x10000) != 0) {
        localContentValues.put("user", getUser());
      }
      if ((this.dtM & 0x20000) != 0) {
        localContentValues.put("human", aCQ());
      }
      if ((this.dtM & 0x40000) != 0) {
        localContentValues.put("reserved1", Integer.valueOf(this.hAl));
      }
      if ((this.dtM & 0x80000) != 0) {
        localContentValues.put("reserved2", Integer.valueOf(this.hAm));
      }
      if ((this.dtM & 0x100000) != 0) {
        localContentValues.put("reserved3", aCS());
      }
      if ((this.dtM & 0x200000) != 0) {
        localContentValues.put("reserved4", aCT());
      }
      if ((this.dtM & 0x400000) != 0) {
        localContentValues.put("videofuncflag", Integer.valueOf(this.hAo));
      }
      if ((this.dtM & 0x800000) != 0) {
        localContentValues.put("masssendid", Long.valueOf(this.hyw));
      }
      if ((this.dtM & 0x1000000) != 0) {
        localContentValues.put("masssendlist", this.hAp);
      }
      if ((this.dtM & 0x2000000) != 0) {
        localContentValues.put("videomd5", this.dyw);
      }
      if ((this.dtM & 0x4000000) != 0) {
        localContentValues.put("streamvideo", aCR());
      }
      if ((this.dtM & 0x8000000) != 0) {
        localContentValues.put("statextstr", this.dxG);
      }
      if ((this.dtM & 0x10000000) != 0) {
        localContentValues.put("downloadscene", Integer.valueOf(this.foe));
      }
      if ((this.dtM & 0x20000000) != 0) {
        localContentValues.put("mmsightextinfo", aCX());
      }
      if ((this.dtM & 0x1) != 0) {
        localContentValues.put("preloadsize", Integer.valueOf(this.dpA));
      }
      if ((this.dtM & 0x2) != 0) {
        localContentValues.put("videoformat", Integer.valueOf(this.videoFormat));
      }
      if (this.hAu) {
        localContentValues.put("forward_msg_local_id", Integer.valueOf(this.hAs));
      }
      if (this.hAv) {
        localContentValues.put("msg_uuid", this.hAt);
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
    if (this.dtV == null) {
      return "";
    }
    return this.dtV;
  }
  
  public final void oU(int paramInt)
  {
    this.hAs = paramInt;
    this.hAu = true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(126947);
    String str = "VideoInfo{fileName='" + this.fileName + '\'' + ", clientId='" + this.clientId + '\'' + ", msgSvrId=" + this.drA + ", netOffset=" + this.hyM + ", fileNowSize=" + this.hAd + ", totalLen=" + this.gTY + ", thumbNetOffset=" + this.hAe + ", thumbLen=" + this.hAf + ", status=" + this.status + ", createTime=" + this.createTime + ", lastModifyTime=" + this.hAg + ", priorityTime=" + this.hAh + ", videoLength=" + this.gOY + ", msgLocalId=" + this.hAi + ", netTimes=" + this.hAj + ", cameraType=" + this.hAk + ", user='" + this.dtV + '\'' + ", human='" + this.hAb + '\'' + ", isExport=" + this.hAl + ", isUseCdn=" + this.hAm + ", importPath='" + this.hxL + '\'' + ", recvXml='" + this.hAn + '\'' + ", videoFuncFlag=" + this.hAo + ", massSendId=" + this.hyw + ", massSendList='" + this.hAp + '\'' + ", videoMD5='" + this.dyw + '\'' + ", streamVideoProto=" + this.hAq + ", statextstr='" + this.dxG + '\'' + ", downloadScene=" + this.foe + ", mmSightExtInfo=" + this.hAr + ", preloadSize=" + this.dpA + ", videoFormat=" + this.videoFormat + ", flag=" + this.dtM + '}';
    AppMethodBeat.o(126947);
    return str;
  }
  
  public final void zN(String paramString)
  {
    this.hAt = paramString;
    this.hAv = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelvideo.s
 * JD-Core Version:    0.7.0.1
 */