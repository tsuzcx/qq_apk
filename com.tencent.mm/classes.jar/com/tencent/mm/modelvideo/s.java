package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cly;
import com.tencent.mm.protocal.protobuf.eeq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class s
{
  public int cSx;
  String clientId;
  public long createTime;
  public int dRQ;
  public long dTS;
  public String dWq;
  public String ean;
  public String ebj;
  public String fileName;
  public int gqW;
  public int iFw;
  public int iKP;
  public String jpP;
  public int jqP;
  public long jqz;
  private boolean jsA;
  private boolean jsB;
  public String jsh;
  public int jsj;
  public int jsk;
  public int jsl;
  public long jsm;
  public long jsn;
  public int jso;
  public int jsp;
  public int jsq;
  public int jsr;
  public int jss;
  public String jst;
  public int jsu;
  public String jsv;
  public eeq jsw;
  public cly jsx;
  int jsy;
  String jsz;
  public int status;
  public int videoFormat;
  
  public s()
  {
    AppMethodBeat.i(126948);
    this.cSx = -1;
    this.fileName = "";
    this.clientId = "";
    this.dTS = 0L;
    this.jqP = 0;
    this.jsj = 0;
    this.iKP = 0;
    this.jsk = 0;
    this.jsl = 0;
    this.status = 0;
    this.createTime = 0L;
    this.jsm = 0L;
    this.jsn = 0L;
    this.iFw = 0;
    this.jso = 0;
    this.jsp = 0;
    this.jsq = 0;
    this.dWq = "";
    this.jsh = "";
    this.jsr = 0;
    this.jss = 0;
    this.jpP = "";
    this.jst = "";
    this.jsu = 0;
    this.jqz = 0L;
    this.jsv = "";
    this.ebj = "";
    this.jsw = new eeq();
    this.ean = "";
    this.gqW = 0;
    this.jsx = new cly();
    this.dRQ = 0;
    this.videoFormat = 0;
    AppMethodBeat.o(126948);
  }
  
  public static String Qn(String paramString)
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
  
  private void as(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126953);
    this.jsw = new eeq();
    try
    {
      this.jsw.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(126953);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.printErrStackTrace("MicroMsg.VideoInfo", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(126953);
    }
  }
  
  private void at(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(126955);
    this.jsx = new cly();
    try
    {
      this.jsx.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(126955);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(126955);
    }
  }
  
  private byte[] bht()
  {
    AppMethodBeat.i(126952);
    Object localObject = new byte[0];
    try
    {
      byte[] arrayOfByte = this.jsw.toByteArray();
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
  
  private byte[] bhz()
  {
    AppMethodBeat.i(126956);
    Object localObject = new byte[0];
    try
    {
      byte[] arrayOfByte = this.jsx.toByteArray();
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
  
  public final void Qo(String paramString)
  {
    this.jsz = paramString;
    this.jsB = true;
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(126954);
    if (this.jsw == null) {
      this.jsw = new eeq();
    }
    this.jsw.izb = paramString2;
    this.jsw.LxJ = paramInt;
    this.jsw.iyZ = paramString1;
    this.jsw.izc = paramString3;
    this.jsw.izd = paramString4;
    this.jsw.izf = paramString5;
    this.jsw.izg = paramString6;
    AppMethodBeat.o(126954);
  }
  
  public final int bcq()
  {
    return this.iKP;
  }
  
  public final String bhs()
  {
    if (this.jsh == null) {
      return "";
    }
    return this.jsh;
  }
  
  public final String bhu()
  {
    if (this.jpP == null) {
      return "";
    }
    return this.jpP;
  }
  
  public final String bhv()
  {
    if (this.jst == null) {
      return "";
    }
    return this.jst;
  }
  
  public final boolean bhw()
  {
    return (this.status == 140) || (this.status == 141) || (this.status == 142);
  }
  
  public final boolean bhx()
  {
    return (this.status == 121) || (this.status == 122) || (this.status == 120) || (this.status == 123);
  }
  
  public final boolean bhy()
  {
    return (this.status == 199) || (this.status == 199);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(126950);
    this.fileName = paramCursor.getString(0);
    this.clientId = paramCursor.getString(1);
    this.dTS = paramCursor.getLong(2);
    this.jqP = paramCursor.getInt(3);
    this.jsj = paramCursor.getInt(4);
    this.iKP = paramCursor.getInt(5);
    this.jsk = paramCursor.getInt(6);
    this.jsl = paramCursor.getInt(7);
    this.status = paramCursor.getInt(8);
    this.createTime = paramCursor.getLong(9);
    this.jsm = paramCursor.getLong(10);
    this.jsn = paramCursor.getLong(11);
    this.iFw = paramCursor.getInt(12);
    this.jso = paramCursor.getInt(13);
    this.jsp = paramCursor.getInt(14);
    this.jsq = paramCursor.getInt(15);
    this.dWq = paramCursor.getString(16);
    this.jsh = paramCursor.getString(17);
    this.jsr = paramCursor.getInt(18);
    this.jss = paramCursor.getInt(19);
    this.jpP = paramCursor.getString(20);
    this.jst = paramCursor.getString(21);
    this.jsu = paramCursor.getInt(22);
    this.jqz = paramCursor.getLong(23);
    this.jsv = paramCursor.getString(24);
    this.ebj = paramCursor.getString(25);
    as(paramCursor.getBlob(26));
    this.ean = paramCursor.getString(27);
    this.gqW = paramCursor.getInt(28);
    at(paramCursor.getBlob(29));
    this.dRQ = paramCursor.getInt(30);
    this.videoFormat = paramCursor.getInt(31);
    this.jsy = paramCursor.getInt(32);
    this.jsz = paramCursor.getString(33);
    AppMethodBeat.o(126950);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(126951);
    ContentValues localContentValues = new ContentValues();
    if ((this.cSx & 0x1) != 0) {
      localContentValues.put("filename", getFileName());
    }
    if ((this.cSx & 0x2) != 0) {
      if (this.clientId != null) {
        break label821;
      }
    }
    label821:
    for (String str = "";; str = this.clientId)
    {
      localContentValues.put("clientid", str);
      if ((this.cSx & 0x4) != 0) {
        localContentValues.put("msgsvrid", Long.valueOf(this.dTS));
      }
      if ((this.cSx & 0x8) != 0) {
        localContentValues.put("netoffset", Integer.valueOf(this.jqP));
      }
      if ((this.cSx & 0x10) != 0) {
        localContentValues.put("filenowsize", Integer.valueOf(this.jsj));
      }
      if ((this.cSx & 0x20) != 0) {
        localContentValues.put("totallen", Integer.valueOf(this.iKP));
      }
      if ((this.cSx & 0x40) != 0) {
        localContentValues.put("thumbnetoffset", Integer.valueOf(this.jsk));
      }
      if ((this.cSx & 0x80) != 0) {
        localContentValues.put("thumblen", Integer.valueOf(this.jsl));
      }
      if ((this.cSx & 0x100) != 0) {
        localContentValues.put("status", Integer.valueOf(this.status));
      }
      if ((this.cSx & 0x200) != 0) {
        localContentValues.put("createtime", Long.valueOf(this.createTime));
      }
      if ((this.cSx & 0x400) != 0) {
        localContentValues.put("lastmodifytime", Long.valueOf(this.jsm));
      }
      if ((this.cSx & 0x800) != 0) {
        localContentValues.put("downloadtime", Long.valueOf(this.jsn));
      }
      if ((this.cSx & 0x1000) != 0) {
        localContentValues.put("videolength", Integer.valueOf(this.iFw));
      }
      if ((this.cSx & 0x2000) != 0) {
        localContentValues.put("msglocalid", Integer.valueOf(this.jso));
      }
      if ((this.cSx & 0x4000) != 0) {
        localContentValues.put("nettimes", Integer.valueOf(this.jsp));
      }
      if ((this.cSx & 0x8000) != 0) {
        localContentValues.put("cameratype", Integer.valueOf(this.jsq));
      }
      if ((this.cSx & 0x10000) != 0) {
        localContentValues.put("user", getUser());
      }
      if ((this.cSx & 0x20000) != 0) {
        localContentValues.put("human", bhs());
      }
      if ((this.cSx & 0x40000) != 0) {
        localContentValues.put("reserved1", Integer.valueOf(this.jsr));
      }
      if ((this.cSx & 0x80000) != 0) {
        localContentValues.put("reserved2", Integer.valueOf(this.jss));
      }
      if ((this.cSx & 0x100000) != 0) {
        localContentValues.put("reserved3", bhu());
      }
      if ((this.cSx & 0x200000) != 0) {
        localContentValues.put("reserved4", bhv());
      }
      if ((this.cSx & 0x400000) != 0) {
        localContentValues.put("videofuncflag", Integer.valueOf(this.jsu));
      }
      if ((this.cSx & 0x800000) != 0) {
        localContentValues.put("masssendid", Long.valueOf(this.jqz));
      }
      if ((this.cSx & 0x1000000) != 0) {
        localContentValues.put("masssendlist", this.jsv);
      }
      if ((this.cSx & 0x2000000) != 0) {
        localContentValues.put("videomd5", this.ebj);
      }
      if ((this.cSx & 0x4000000) != 0) {
        localContentValues.put("streamvideo", bht());
      }
      if ((this.cSx & 0x8000000) != 0) {
        localContentValues.put("statextstr", this.ean);
      }
      if ((this.cSx & 0x10000000) != 0) {
        localContentValues.put("downloadscene", Integer.valueOf(this.gqW));
      }
      if ((this.cSx & 0x20000000) != 0) {
        localContentValues.put("mmsightextinfo", bhz());
      }
      if ((this.cSx & 0x1) != 0) {
        localContentValues.put("preloadsize", Integer.valueOf(this.dRQ));
      }
      if ((this.cSx & 0x2) != 0) {
        localContentValues.put("videoformat", Integer.valueOf(this.videoFormat));
      }
      if (this.jsA) {
        localContentValues.put("forward_msg_local_id", Integer.valueOf(this.jsy));
      }
      if (this.jsB) {
        localContentValues.put("msg_uuid", this.jsz);
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
    if (this.dWq == null) {
      return "";
    }
    return this.dWq;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(126947);
    String str = "VideoInfo{fileName='" + this.fileName + '\'' + ", clientId='" + this.clientId + '\'' + ", msgSvrId=" + this.dTS + ", netOffset=" + this.jqP + ", fileNowSize=" + this.jsj + ", totalLen=" + this.iKP + ", thumbNetOffset=" + this.jsk + ", thumbLen=" + this.jsl + ", status=" + this.status + ", createTime=" + this.createTime + ", lastModifyTime=" + this.jsm + ", priorityTime=" + this.jsn + ", videoLength=" + this.iFw + ", msgLocalId=" + this.jso + ", netTimes=" + this.jsp + ", cameraType=" + this.jsq + ", user='" + this.dWq + '\'' + ", human='" + this.jsh + '\'' + ", isExport=" + this.jsr + ", isUseCdn=" + this.jss + ", importPath='" + this.jpP + '\'' + ", recvXml='" + this.jst + '\'' + ", videoFuncFlag=" + this.jsu + ", massSendId=" + this.jqz + ", massSendList='" + this.jsv + '\'' + ", videoMD5='" + this.ebj + '\'' + ", streamVideoProto=" + this.jsw + ", statextstr='" + this.ean + '\'' + ", downloadScene=" + this.gqW + ", mmSightExtInfo=" + this.jsx + ", preloadSize=" + this.dRQ + ", videoFormat=" + this.videoFormat + ", flag=" + this.cSx + '}';
    AppMethodBeat.o(126947);
    return str;
  }
  
  public final void ue(int paramInt)
  {
    this.jsy = paramInt;
    this.jsA = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.s
 * JD-Core Version:    0.7.0.1
 */