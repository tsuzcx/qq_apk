package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dmb;
import com.tencent.mm.protocal.protobuf.fjp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.Map;

public final class z
{
  public String clientId;
  public long createTime;
  public int eQp;
  public String fileName;
  public int hQV;
  public long hTh;
  public String hVQ;
  public String iah;
  public String ibd;
  public int lxk;
  public long oYW;
  public String oYj;
  public String oYk;
  public int oZm;
  public int omT;
  public int osy;
  public String paV;
  public int paX;
  public int paY;
  public int paZ;
  public long pba;
  public long pbb;
  public int pbc;
  public int pbd;
  public int pbe;
  public int pbf;
  public int pbg;
  public String pbh;
  public int pbi;
  public String pbj;
  public fjp pbk;
  public dmb pbl;
  int pbm;
  String pbn;
  public String pbo;
  private int pbp;
  private boolean pbq;
  private boolean pbr;
  private boolean pbs;
  private boolean pbt;
  private boolean pbu;
  public int status;
  public int videoFormat;
  
  public z()
  {
    AppMethodBeat.i(126948);
    this.eQp = -1;
    this.fileName = "";
    this.clientId = "";
    this.hTh = 0L;
    this.oZm = 0;
    this.paX = 0;
    this.osy = 0;
    this.paY = 0;
    this.paZ = 0;
    this.status = 0;
    this.createTime = 0L;
    this.pba = 0L;
    this.pbb = 0L;
    this.omT = 0;
    this.pbc = 0;
    this.pbd = 0;
    this.pbe = 0;
    this.hVQ = "";
    this.paV = "";
    this.pbf = 0;
    this.pbg = 0;
    this.oYj = "";
    this.pbh = "";
    this.pbi = 0;
    this.oYW = 0L;
    this.pbj = "";
    this.ibd = "";
    this.pbk = new fjp();
    this.iah = "";
    this.lxk = 0;
    this.pbl = new dmb();
    this.hQV = 0;
    this.videoFormat = 0;
    AppMethodBeat.o(126948);
  }
  
  public static String PM(String paramString)
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
    this.pbk = new fjp();
    try
    {
      this.pbk.parseFrom(paramArrayOfByte);
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
    this.pbl = new dmb();
    try
    {
      this.pbl.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(126955);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(126955);
    }
  }
  
  private byte[] bOr()
  {
    AppMethodBeat.i(126952);
    Object localObject = new byte[0];
    try
    {
      byte[] arrayOfByte = this.pbk.toByteArray();
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
  
  private byte[] bOy()
  {
    AppMethodBeat.i(126956);
    Object localObject = new byte[0];
    try
    {
      byte[] arrayOfByte = this.pbl.toByteArray();
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
  
  public final void PN(String paramString)
  {
    this.pbn = paramString;
    this.pbr = true;
  }
  
  public final void PO(String paramString)
  {
    this.pbo = paramString;
    this.pbs = true;
  }
  
  public final void PP(String paramString)
  {
    this.oYk = paramString;
    this.pbt = true;
  }
  
  public final void a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    AppMethodBeat.i(126954);
    if (this.pbk == null) {
      this.pbk = new fjp();
    }
    this.pbk.nTw = paramString2;
    this.pbk.ZBc = paramInt;
    this.pbk.nTu = paramString1;
    this.pbk.nTx = paramString3;
    this.pbk.nTy = paramString4;
    this.pbk.nTA = paramString5;
    this.pbk.nTB = paramString6;
    AppMethodBeat.o(126954);
  }
  
  public final void bOA()
  {
    this.pbp = 1;
    this.pbu = true;
  }
  
  public final String bOq()
  {
    if (this.paV == null) {
      return "";
    }
    return this.paV;
  }
  
  public final String bOs()
  {
    if (this.hVQ == null) {
      return "";
    }
    return this.hVQ;
  }
  
  public final String bOt()
  {
    if (this.oYj == null) {
      return "";
    }
    return this.oYj;
  }
  
  public final String bOu()
  {
    if (this.pbh == null) {
      return "";
    }
    return this.pbh;
  }
  
  public final boolean bOv()
  {
    return (this.status == 140) || (this.status == 141) || (this.status == 142);
  }
  
  public final boolean bOw()
  {
    return (this.status == 121) || (this.status == 122) || (this.status == 120) || (this.status == 123);
  }
  
  public final boolean bOx()
  {
    return (this.status == 199) || (this.status == 199);
  }
  
  public final boolean bOz()
  {
    return this.pbp == 1;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(126950);
    this.fileName = paramCursor.getString(0);
    this.clientId = paramCursor.getString(1);
    this.hTh = paramCursor.getLong(2);
    this.oZm = paramCursor.getInt(3);
    this.paX = paramCursor.getInt(4);
    this.osy = paramCursor.getInt(5);
    this.paY = paramCursor.getInt(6);
    this.paZ = paramCursor.getInt(7);
    this.status = paramCursor.getInt(8);
    this.createTime = paramCursor.getLong(9);
    this.pba = paramCursor.getLong(10);
    this.pbb = paramCursor.getLong(11);
    this.omT = paramCursor.getInt(12);
    this.pbc = paramCursor.getInt(13);
    this.pbd = paramCursor.getInt(14);
    this.pbe = paramCursor.getInt(15);
    this.hVQ = paramCursor.getString(16);
    this.paV = paramCursor.getString(17);
    this.pbf = paramCursor.getInt(18);
    this.pbg = paramCursor.getInt(19);
    this.oYj = paramCursor.getString(20);
    this.pbh = paramCursor.getString(21);
    this.pbi = paramCursor.getInt(22);
    this.oYW = paramCursor.getLong(23);
    this.pbj = paramCursor.getString(24);
    this.ibd = paramCursor.getString(25);
    aD(paramCursor.getBlob(26));
    this.iah = paramCursor.getString(27);
    this.lxk = paramCursor.getInt(28);
    aE(paramCursor.getBlob(29));
    this.hQV = paramCursor.getInt(30);
    this.videoFormat = paramCursor.getInt(31);
    this.pbm = paramCursor.getInt(32);
    this.pbn = paramCursor.getString(33);
    this.pbo = paramCursor.getString(34);
    this.oYk = paramCursor.getString(35);
    this.pbp = paramCursor.getInt(36);
    AppMethodBeat.o(126950);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(126951);
    ContentValues localContentValues = new ContentValues();
    if ((this.eQp & 0x1) != 0) {
      localContentValues.put("filename", getFileName());
    }
    if ((this.eQp & 0x2) != 0) {
      if (this.clientId != null) {
        break label878;
      }
    }
    label878:
    for (String str = "";; str = this.clientId)
    {
      localContentValues.put("clientid", str);
      if ((this.eQp & 0x4) != 0) {
        localContentValues.put("msgsvrid", Long.valueOf(this.hTh));
      }
      if ((this.eQp & 0x8) != 0) {
        localContentValues.put("netoffset", Integer.valueOf(this.oZm));
      }
      if ((this.eQp & 0x10) != 0) {
        localContentValues.put("filenowsize", Integer.valueOf(this.paX));
      }
      if ((this.eQp & 0x20) != 0) {
        localContentValues.put("totallen", Integer.valueOf(this.osy));
      }
      if ((this.eQp & 0x40) != 0) {
        localContentValues.put("thumbnetoffset", Integer.valueOf(this.paY));
      }
      if ((this.eQp & 0x80) != 0) {
        localContentValues.put("thumblen", Integer.valueOf(this.paZ));
      }
      if ((this.eQp & 0x100) != 0) {
        localContentValues.put("status", Integer.valueOf(this.status));
      }
      if ((this.eQp & 0x200) != 0) {
        localContentValues.put("createtime", Long.valueOf(this.createTime));
      }
      if ((this.eQp & 0x400) != 0) {
        localContentValues.put("lastmodifytime", Long.valueOf(this.pba));
      }
      if ((this.eQp & 0x800) != 0) {
        localContentValues.put("downloadtime", Long.valueOf(this.pbb));
      }
      if ((this.eQp & 0x1000) != 0) {
        localContentValues.put("videolength", Integer.valueOf(this.omT));
      }
      if ((this.eQp & 0x2000) != 0) {
        localContentValues.put("msglocalid", Integer.valueOf(this.pbc));
      }
      if ((this.eQp & 0x4000) != 0) {
        localContentValues.put("nettimes", Integer.valueOf(this.pbd));
      }
      if ((this.eQp & 0x8000) != 0) {
        localContentValues.put("cameratype", Integer.valueOf(this.pbe));
      }
      if ((this.eQp & 0x10000) != 0) {
        localContentValues.put("user", bOs());
      }
      if ((this.eQp & 0x20000) != 0) {
        localContentValues.put("human", bOq());
      }
      if ((this.eQp & 0x40000) != 0) {
        localContentValues.put("reserved1", Integer.valueOf(this.pbf));
      }
      if ((this.eQp & 0x80000) != 0) {
        localContentValues.put("reserved2", Integer.valueOf(this.pbg));
      }
      if ((this.eQp & 0x100000) != 0) {
        localContentValues.put("reserved3", bOt());
      }
      if ((this.eQp & 0x200000) != 0) {
        localContentValues.put("reserved4", bOu());
      }
      if ((this.eQp & 0x400000) != 0) {
        localContentValues.put("videofuncflag", Integer.valueOf(this.pbi));
      }
      if ((this.eQp & 0x800000) != 0) {
        localContentValues.put("masssendid", Long.valueOf(this.oYW));
      }
      if ((this.eQp & 0x1000000) != 0) {
        localContentValues.put("masssendlist", this.pbj);
      }
      if ((this.eQp & 0x2000000) != 0) {
        localContentValues.put("videomd5", this.ibd);
      }
      if ((this.eQp & 0x4000000) != 0) {
        localContentValues.put("streamvideo", bOr());
      }
      if ((this.eQp & 0x8000000) != 0) {
        localContentValues.put("statextstr", this.iah);
      }
      if ((this.eQp & 0x10000000) != 0) {
        localContentValues.put("downloadscene", Integer.valueOf(this.lxk));
      }
      if ((this.eQp & 0x20000000) != 0) {
        localContentValues.put("mmsightextinfo", bOy());
      }
      if ((this.eQp & 0x1) != 0) {
        localContentValues.put("preloadsize", Integer.valueOf(this.hQV));
      }
      if ((this.eQp & 0x2) != 0) {
        localContentValues.put("videoformat", Integer.valueOf(this.videoFormat));
      }
      if (this.pbq) {
        localContentValues.put("forward_msg_local_id", Integer.valueOf(this.pbm));
      }
      if (this.pbr) {
        localContentValues.put("msg_uuid", this.pbn);
      }
      if (this.pbs) {
        localContentValues.put("share_app_info", this.pbo);
      }
      if (this.pbt) {
        localContentValues.put("origin_file_name", this.oYk);
      }
      if (this.pbu) {
        localContentValues.put("had_clicked_video", Boolean.valueOf(bOz()));
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
  
  public final String toString()
  {
    AppMethodBeat.i(126947);
    String str = "VideoInfo{fileName='" + this.fileName + '\'' + ", clientId='" + this.clientId + '\'' + ", msgSvrId=" + this.hTh + ", netOffset=" + this.oZm + ", fileNowSize=" + this.paX + ", totalLen=" + this.osy + ", thumbNetOffset=" + this.paY + ", thumbLen=" + this.paZ + ", status=" + this.status + ", createTime=" + this.createTime + ", lastModifyTime=" + this.pba + ", priorityTime=" + this.pbb + ", videoLength=" + this.omT + ", msgLocalId=" + this.pbc + ", netTimes=" + this.pbd + ", cameraType=" + this.pbe + ", user='" + this.hVQ + '\'' + ", human='" + this.paV + '\'' + ", isExport=" + this.pbf + ", isUseCdn=" + this.pbg + ", importPath='" + this.oYj + '\'' + ", recvXml='" + this.pbh + '\'' + ", videoFuncFlag=" + this.pbi + ", massSendId=" + this.oYW + ", massSendList='" + this.pbj + '\'' + ", videoMD5='" + this.ibd + '\'' + ", streamVideoProto=" + this.pbk + ", statextstr='" + this.iah + '\'' + ", downloadScene=" + this.lxk + ", mmSightExtInfo=" + this.pbl + ", preloadSize=" + this.hQV + ", videoFormat=" + this.videoFormat + ", flag=" + this.eQp + '}';
    AppMethodBeat.o(126947);
    return str;
  }
  
  public final void xd(int paramInt)
  {
    this.pbm = paramInt;
    this.pbq = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.z
 * JD-Core Version:    0.7.0.1
 */