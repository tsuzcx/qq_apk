package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bby;
import com.tencent.mm.protocal.protobuf.cii;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class s
{
  public int bsY;
  public String cDt;
  public long cFn;
  public String cGU;
  public String cHH;
  String clientId;
  public long createTime;
  public int czu;
  public int edL;
  public long fVM;
  public String fVa;
  public int fWa;
  public int fXA;
  public int fXB;
  public int fXC;
  public String fXD;
  public int fXE;
  public String fXF;
  public cii fXG;
  public bby fXH;
  public String fXq;
  public int fXs;
  public int fXt;
  public int fXu;
  public long fXv;
  public long fXw;
  public int fXx;
  public int fXy;
  public int fXz;
  public String fileName;
  public int fsd;
  public int status;
  public int videoFormat;
  
  public s()
  {
    AppMethodBeat.i(50782);
    this.bsY = -1;
    this.fileName = "";
    this.clientId = "";
    this.cFn = 0L;
    this.fWa = 0;
    this.fXs = 0;
    this.fsd = 0;
    this.fXt = 0;
    this.fXu = 0;
    this.status = 0;
    this.createTime = 0L;
    this.fXv = 0L;
    this.fXw = 0L;
    this.fXx = 0;
    this.fXy = 0;
    this.fXz = 0;
    this.fXA = 0;
    this.cDt = "";
    this.fXq = "";
    this.fXB = 0;
    this.fXC = 0;
    this.fVa = "";
    this.fXD = "";
    this.fXE = 0;
    this.fVM = 0L;
    this.fXF = "";
    this.cHH = "";
    this.fXG = new cii();
    this.cGU = "";
    this.edL = 0;
    this.fXH = new bby();
    this.czu = 0;
    this.videoFormat = 0;
    AppMethodBeat.o(50782);
  }
  
  private void W(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(50787);
    this.fXG = new cii();
    try
    {
      this.fXG.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(50787);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ab.printErrStackTrace("MicroMsg.VideoInfo", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(50787);
    }
  }
  
  private void X(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(50788);
    this.fXH = new bby();
    try
    {
      this.fXH.parseFrom(paramArrayOfByte);
      AppMethodBeat.o(50788);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      AppMethodBeat.o(50788);
    }
  }
  
  private byte[] alN()
  {
    AppMethodBeat.i(50786);
    Object localObject = new byte[0];
    try
    {
      byte[] arrayOfByte = this.fXG.toByteArray();
      localObject = arrayOfByte;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.VideoInfo", localException, "", new Object[0]);
      }
    }
    AppMethodBeat.o(50786);
    return localObject;
  }
  
  private byte[] alT()
  {
    AppMethodBeat.i(50789);
    Object localObject = new byte[0];
    try
    {
      byte[] arrayOfByte = this.fXH.toByteArray();
      localObject = arrayOfByte;
    }
    catch (Exception localException)
    {
      label19:
      break label19;
    }
    AppMethodBeat.o(50789);
    return localObject;
  }
  
  public static String vc(String paramString)
  {
    AppMethodBeat.i(50783);
    try
    {
      paramString = br.F(paramString, "msg");
      if (paramString != null)
      {
        paramString = (String)paramString.get(".msg.videomsg.$cdnvideourl");
        AppMethodBeat.o(50783);
        return paramString;
      }
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(50783);
    }
    return "";
  }
  
  public final String alM()
  {
    if (this.fXq == null) {
      return "";
    }
    return this.fXq;
  }
  
  public final String alO()
  {
    if (this.fVa == null) {
      return "";
    }
    return this.fVa;
  }
  
  public final String alP()
  {
    if (this.fXD == null) {
      return "";
    }
    return this.fXD;
  }
  
  public final boolean alQ()
  {
    return (this.status == 140) || (this.status == 141) || (this.status == 142);
  }
  
  public final boolean alR()
  {
    return (this.status == 121) || (this.status == 122) || (this.status == 120) || (this.status == 123);
  }
  
  public final boolean alS()
  {
    return (this.status == 199) || (this.status == 199);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(50784);
    this.fileName = paramCursor.getString(0);
    this.clientId = paramCursor.getString(1);
    this.cFn = paramCursor.getLong(2);
    this.fWa = paramCursor.getInt(3);
    this.fXs = paramCursor.getInt(4);
    this.fsd = paramCursor.getInt(5);
    this.fXt = paramCursor.getInt(6);
    this.fXu = paramCursor.getInt(7);
    this.status = paramCursor.getInt(8);
    this.createTime = paramCursor.getLong(9);
    this.fXv = paramCursor.getLong(10);
    this.fXw = paramCursor.getLong(11);
    this.fXx = paramCursor.getInt(12);
    this.fXy = paramCursor.getInt(13);
    this.fXz = paramCursor.getInt(14);
    this.fXA = paramCursor.getInt(15);
    this.cDt = paramCursor.getString(16);
    this.fXq = paramCursor.getString(17);
    this.fXB = paramCursor.getInt(18);
    this.fXC = paramCursor.getInt(19);
    this.fVa = paramCursor.getString(20);
    this.fXD = paramCursor.getString(21);
    this.fXE = paramCursor.getInt(22);
    this.fVM = paramCursor.getLong(23);
    this.fXF = paramCursor.getString(24);
    this.cHH = paramCursor.getString(25);
    W(paramCursor.getBlob(26));
    this.cGU = paramCursor.getString(27);
    this.edL = paramCursor.getInt(28);
    X(paramCursor.getBlob(29));
    this.czu = paramCursor.getInt(30);
    this.videoFormat = paramCursor.getInt(31);
    AppMethodBeat.o(50784);
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(50785);
    ContentValues localContentValues = new ContentValues();
    if ((this.bsY & 0x1) != 0) {
      localContentValues.put("filename", getFileName());
    }
    if ((this.bsY & 0x2) != 0) {
      if (this.clientId != null) {
        break label775;
      }
    }
    label775:
    for (String str = "";; str = this.clientId)
    {
      localContentValues.put("clientid", str);
      if ((this.bsY & 0x4) != 0) {
        localContentValues.put("msgsvrid", Long.valueOf(this.cFn));
      }
      if ((this.bsY & 0x8) != 0) {
        localContentValues.put("netoffset", Integer.valueOf(this.fWa));
      }
      if ((this.bsY & 0x10) != 0) {
        localContentValues.put("filenowsize", Integer.valueOf(this.fXs));
      }
      if ((this.bsY & 0x20) != 0) {
        localContentValues.put("totallen", Integer.valueOf(this.fsd));
      }
      if ((this.bsY & 0x40) != 0) {
        localContentValues.put("thumbnetoffset", Integer.valueOf(this.fXt));
      }
      if ((this.bsY & 0x80) != 0) {
        localContentValues.put("thumblen", Integer.valueOf(this.fXu));
      }
      if ((this.bsY & 0x100) != 0) {
        localContentValues.put("status", Integer.valueOf(this.status));
      }
      if ((this.bsY & 0x200) != 0) {
        localContentValues.put("createtime", Long.valueOf(this.createTime));
      }
      if ((this.bsY & 0x400) != 0) {
        localContentValues.put("lastmodifytime", Long.valueOf(this.fXv));
      }
      if ((this.bsY & 0x800) != 0) {
        localContentValues.put("downloadtime", Long.valueOf(this.fXw));
      }
      if ((this.bsY & 0x1000) != 0) {
        localContentValues.put("videolength", Integer.valueOf(this.fXx));
      }
      if ((this.bsY & 0x2000) != 0) {
        localContentValues.put("msglocalid", Integer.valueOf(this.fXy));
      }
      if ((this.bsY & 0x4000) != 0) {
        localContentValues.put("nettimes", Integer.valueOf(this.fXz));
      }
      if ((this.bsY & 0x8000) != 0) {
        localContentValues.put("cameratype", Integer.valueOf(this.fXA));
      }
      if ((this.bsY & 0x10000) != 0) {
        localContentValues.put("user", getUser());
      }
      if ((this.bsY & 0x20000) != 0) {
        localContentValues.put("human", alM());
      }
      if ((this.bsY & 0x40000) != 0) {
        localContentValues.put("reserved1", Integer.valueOf(this.fXB));
      }
      if ((this.bsY & 0x80000) != 0) {
        localContentValues.put("reserved2", Integer.valueOf(this.fXC));
      }
      if ((this.bsY & 0x100000) != 0) {
        localContentValues.put("reserved3", alO());
      }
      if ((this.bsY & 0x200000) != 0) {
        localContentValues.put("reserved4", alP());
      }
      if ((this.bsY & 0x400000) != 0) {
        localContentValues.put("videofuncflag", Integer.valueOf(this.fXE));
      }
      if ((this.bsY & 0x800000) != 0) {
        localContentValues.put("masssendid", Long.valueOf(this.fVM));
      }
      if ((this.bsY & 0x1000000) != 0) {
        localContentValues.put("masssendlist", this.fXF);
      }
      if ((this.bsY & 0x2000000) != 0) {
        localContentValues.put("videomd5", this.cHH);
      }
      if ((this.bsY & 0x4000000) != 0) {
        localContentValues.put("streamvideo", alN());
      }
      if ((this.bsY & 0x8000000) != 0) {
        localContentValues.put("statextstr", this.cGU);
      }
      if ((this.bsY & 0x10000000) != 0) {
        localContentValues.put("downloadscene", Integer.valueOf(this.edL));
      }
      if ((this.bsY & 0x20000000) != 0) {
        localContentValues.put("mmsightextinfo", alT());
      }
      if ((this.bsY & 0x1) != 0) {
        localContentValues.put("preloadsize", Integer.valueOf(this.czu));
      }
      if ((this.bsY & 0x2) != 0) {
        localContentValues.put("videoformat", Integer.valueOf(this.videoFormat));
      }
      AppMethodBeat.o(50785);
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
    if (this.cDt == null) {
      return "";
    }
    return this.cDt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.s
 * JD-Core Version:    0.7.0.1
 */