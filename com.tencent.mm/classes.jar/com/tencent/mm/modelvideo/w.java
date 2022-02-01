package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cuv;
import com.tencent.mm.protocal.protobuf.eor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class w
{
  public int cUP;
  String clientId;
  public long createTime;
  public int fLn;
  public long fNu;
  public String fPV;
  public String fUk;
  public String fVg;
  public String fileName;
  public int iVf;
  public int lAW;
  public int lvw;
  public String mfq;
  public long mga;
  public int mgq;
  public String mhK;
  public int mhM;
  public int mhN;
  public int mhO;
  public long mhP;
  public long mhQ;
  public int mhR;
  public int mhS;
  public int mhT;
  public int mhU;
  public int mhV;
  public String mhW;
  public int mhX;
  public String mhY;
  public eor mhZ;
  public cuv mia;
  int mib;
  String mic;
  private boolean mid;
  private boolean mie;
  public int status;
  public int videoFormat;
  
  public w()
  {
    AppMethodBeat.i(126948);
    this.cUP = -1;
    this.fileName = "";
    this.clientId = "";
    this.fNu = 0L;
    this.mgq = 0;
    this.mhM = 0;
    this.lAW = 0;
    this.mhN = 0;
    this.mhO = 0;
    this.status = 0;
    this.createTime = 0L;
    this.mhP = 0L;
    this.mhQ = 0L;
    this.lvw = 0;
    this.mhR = 0;
    this.mhS = 0;
    this.mhT = 0;
    this.fPV = "";
    this.mhK = "";
    this.mhU = 0;
    this.mhV = 0;
    this.mfq = "";
    this.mhW = "";
    this.mhX = 0;
    this.mga = 0L;
    this.mhY = "";
    this.fVg = "";
    this.mhZ = new eor();
    this.fUk = "";
    this.iVf = 0;
    this.mia = new cuv();
    this.fLn = 0;
    this.videoFormat = 0;
    AppMethodBeat.o(126948);
  }
  
  public static String XK(String paramString)
  {
    AppMethodBeat.i(126949);
    try
    {
      paramString = XmlParser.parseXml(paramString, "msg", null);
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
  
  private void aD(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126953);
    this.mhZ = new eor();
    try
    {
      this.mhZ.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(126953);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.printErrStackTrace("MicroMsg.VideoInfo", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(126953);
    }
  }
  
  private void aE(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126955);
    this.mia = new cuv();
    try
    {
      this.mia.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(126955);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(126955);
    }
  }
  
  private byte[] bqL()
  {
    AppMethodBeat.i(126952);
    Object localObject = new byte[0];
    try
    {
      byte[] arrayOfByte = this.mhZ.toByteArray();
      localObject = arrayOfByte;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.VideoInfo", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(126952);
    return localObject;
  }
  
  private byte[] bqT()
  {
    AppMethodBeat.i(126956);
    Object localObject = new byte[0];
    try
    {
      byte[] arrayOfByte = this.mia.toByteArray();
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
  
  public final void XL(String paramString)
  {
    this.mic = paramString;
    this.mie = true;
  }
  
  public final void ZK()
  {
    this.status = 111;
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(126954);
    if (this.mhZ == null) {
      this.mhZ = new eor();
    }
    this.mhZ.lot = paramString2;
    this.mhZ.SAk = paramInt;
    this.mhZ.lor = paramString1;
    this.mhZ.lou = paramString3;
    this.mhZ.lov = paramString4;
    this.mhZ.lox = paramString5;
    this.mhZ.loy = paramString6;
    AppMethodBeat.o(126954);
  }
  
  public final int bfj()
  {
    return this.lvw;
  }
  
  public final int blF()
  {
    return this.lAW;
  }
  
  public final String bqK()
  {
    if (this.mhK == null) {
      return "";
    }
    return this.mhK;
  }
  
  public final String bqM()
  {
    if (this.fPV == null) {
      return "";
    }
    return this.fPV;
  }
  
  public final String bqN()
  {
    if (this.mfq == null) {
      return "";
    }
    return this.mfq;
  }
  
  public final String bqO()
  {
    if (this.mhW == null) {
      return "";
    }
    return this.mhW;
  }
  
  public final int bqP()
  {
    return this.mhX;
  }
  
  public final boolean bqQ()
  {
    return (this.status == 140) || (this.status == 141) || (this.status == 142);
  }
  
  public final boolean bqR()
  {
    return (this.status == 121) || (this.status == 122) || (this.status == 120) || (this.status == 123);
  }
  
  public final boolean bqS()
  {
    return (this.status == 199) || (this.status == 199);
  }
  
  public final cuv bqU()
  {
    return this.mia;
  }
  
  public final int bqV()
  {
    return this.fLn;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(126950);
    this.fileName = paramCursor.getString(0);
    this.clientId = paramCursor.getString(1);
    this.fNu = paramCursor.getLong(2);
    this.mgq = paramCursor.getInt(3);
    this.mhM = paramCursor.getInt(4);
    this.lAW = paramCursor.getInt(5);
    this.mhN = paramCursor.getInt(6);
    this.mhO = paramCursor.getInt(7);
    this.status = paramCursor.getInt(8);
    this.createTime = paramCursor.getLong(9);
    this.mhP = paramCursor.getLong(10);
    this.mhQ = paramCursor.getLong(11);
    this.lvw = paramCursor.getInt(12);
    this.mhR = paramCursor.getInt(13);
    this.mhS = paramCursor.getInt(14);
    this.mhT = paramCursor.getInt(15);
    this.fPV = paramCursor.getString(16);
    this.mhK = paramCursor.getString(17);
    this.mhU = paramCursor.getInt(18);
    this.mhV = paramCursor.getInt(19);
    this.mfq = paramCursor.getString(20);
    this.mhW = paramCursor.getString(21);
    this.mhX = paramCursor.getInt(22);
    this.mga = paramCursor.getLong(23);
    this.mhY = paramCursor.getString(24);
    this.fVg = paramCursor.getString(25);
    aD(paramCursor.getBlob(26));
    this.fUk = paramCursor.getString(27);
    this.iVf = paramCursor.getInt(28);
    aE(paramCursor.getBlob(29));
    this.fLn = paramCursor.getInt(30);
    this.videoFormat = paramCursor.getInt(31);
    this.mib = paramCursor.getInt(32);
    this.mic = paramCursor.getString(33);
    AppMethodBeat.o(126950);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(126951);
    ContentValues localContentValues = new ContentValues();
    if ((this.cUP & 0x1) != 0) {
      localContentValues.put("filename", getFileName());
    }
    if ((this.cUP & 0x2) != 0) {
      if (this.clientId != null) {
        break label821;
      }
    }
    label821:
    for (String str = "";; str = this.clientId)
    {
      localContentValues.put("clientid", str);
      if ((this.cUP & 0x4) != 0) {
        localContentValues.put("msgsvrid", Long.valueOf(this.fNu));
      }
      if ((this.cUP & 0x8) != 0) {
        localContentValues.put("netoffset", Integer.valueOf(this.mgq));
      }
      if ((this.cUP & 0x10) != 0) {
        localContentValues.put("filenowsize", Integer.valueOf(this.mhM));
      }
      if ((this.cUP & 0x20) != 0) {
        localContentValues.put("totallen", Integer.valueOf(this.lAW));
      }
      if ((this.cUP & 0x40) != 0) {
        localContentValues.put("thumbnetoffset", Integer.valueOf(this.mhN));
      }
      if ((this.cUP & 0x80) != 0) {
        localContentValues.put("thumblen", Integer.valueOf(this.mhO));
      }
      if ((this.cUP & 0x100) != 0) {
        localContentValues.put("status", Integer.valueOf(this.status));
      }
      if ((this.cUP & 0x200) != 0) {
        localContentValues.put("createtime", Long.valueOf(this.createTime));
      }
      if ((this.cUP & 0x400) != 0) {
        localContentValues.put("lastmodifytime", Long.valueOf(this.mhP));
      }
      if ((this.cUP & 0x800) != 0) {
        localContentValues.put("downloadtime", Long.valueOf(this.mhQ));
      }
      if ((this.cUP & 0x1000) != 0) {
        localContentValues.put("videolength", Integer.valueOf(this.lvw));
      }
      if ((this.cUP & 0x2000) != 0) {
        localContentValues.put("msglocalid", Integer.valueOf(this.mhR));
      }
      if ((this.cUP & 0x4000) != 0) {
        localContentValues.put("nettimes", Integer.valueOf(this.mhS));
      }
      if ((this.cUP & 0x8000) != 0) {
        localContentValues.put("cameratype", Integer.valueOf(this.mhT));
      }
      if ((this.cUP & 0x10000) != 0) {
        localContentValues.put("user", bqM());
      }
      if ((this.cUP & 0x20000) != 0) {
        localContentValues.put("human", bqK());
      }
      if ((this.cUP & 0x40000) != 0) {
        localContentValues.put("reserved1", Integer.valueOf(this.mhU));
      }
      if ((this.cUP & 0x80000) != 0) {
        localContentValues.put("reserved2", Integer.valueOf(this.mhV));
      }
      if ((this.cUP & 0x100000) != 0) {
        localContentValues.put("reserved3", bqN());
      }
      if ((this.cUP & 0x200000) != 0) {
        localContentValues.put("reserved4", bqO());
      }
      if ((this.cUP & 0x400000) != 0) {
        localContentValues.put("videofuncflag", Integer.valueOf(this.mhX));
      }
      if ((this.cUP & 0x800000) != 0) {
        localContentValues.put("masssendid", Long.valueOf(this.mga));
      }
      if ((this.cUP & 0x1000000) != 0) {
        localContentValues.put("masssendlist", this.mhY);
      }
      if ((this.cUP & 0x2000000) != 0) {
        localContentValues.put("videomd5", this.fVg);
      }
      if ((this.cUP & 0x4000000) != 0) {
        localContentValues.put("streamvideo", bqL());
      }
      if ((this.cUP & 0x8000000) != 0) {
        localContentValues.put("statextstr", this.fUk);
      }
      if ((this.cUP & 0x10000000) != 0) {
        localContentValues.put("downloadscene", Integer.valueOf(this.iVf));
      }
      if ((this.cUP & 0x20000000) != 0) {
        localContentValues.put("mmsightextinfo", bqT());
      }
      if ((this.cUP & 0x1) != 0) {
        localContentValues.put("preloadsize", Integer.valueOf(this.fLn));
      }
      if ((this.cUP & 0x2) != 0) {
        localContentValues.put("videoformat", Integer.valueOf(this.videoFormat));
      }
      if (this.mid) {
        localContentValues.put("forward_msg_local_id", Integer.valueOf(this.mib));
      }
      if (this.mie) {
        localContentValues.put("msg_uuid", this.mic);
      }
      AppMethodBeat.o(126951);
      return localContentValues;
    }
  }
  
  public final long getCreateTime()
  {
    return this.createTime;
  }
  
  public final String getFileName()
  {
    if (this.fileName == null) {
      return "";
    }
    return this.fileName;
  }
  
  public final int getStatus()
  {
    return this.status;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(126947);
    String str = "VideoInfo{fileName='" + this.fileName + '\'' + ", clientId='" + this.clientId + '\'' + ", msgSvrId=" + this.fNu + ", netOffset=" + this.mgq + ", fileNowSize=" + this.mhM + ", totalLen=" + this.lAW + ", thumbNetOffset=" + this.mhN + ", thumbLen=" + this.mhO + ", status=" + this.status + ", createTime=" + this.createTime + ", lastModifyTime=" + this.mhP + ", priorityTime=" + this.mhQ + ", videoLength=" + this.lvw + ", msgLocalId=" + this.mhR + ", netTimes=" + this.mhS + ", cameraType=" + this.mhT + ", user='" + this.fPV + '\'' + ", human='" + this.mhK + '\'' + ", isExport=" + this.mhU + ", isUseCdn=" + this.mhV + ", importPath='" + this.mfq + '\'' + ", recvXml='" + this.mhW + '\'' + ", videoFuncFlag=" + this.mhX + ", massSendId=" + this.mga + ", massSendList='" + this.mhY + '\'' + ", videoMD5='" + this.fVg + '\'' + ", streamVideoProto=" + this.mhZ + ", statextstr='" + this.fUk + '\'' + ", downloadScene=" + this.iVf + ", mmSightExtInfo=" + this.mia + ", preloadSize=" + this.fLn + ", videoFormat=" + this.videoFormat + ", flag=" + this.cUP + '}';
    AppMethodBeat.o(126947);
    return str;
  }
  
  public final void wf(int paramInt)
  {
    this.lAW = paramInt;
  }
  
  public final void xd(int paramInt)
  {
    this.mib = paramInt;
    this.mid = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.w
 * JD-Core Version:    0.7.0.1
 */