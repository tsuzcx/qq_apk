package com.tencent.mm.modelvideo;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.avn;
import com.tencent.mm.protocal.c.bwa;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;

public final class s
{
  public int bRT = 0;
  public String bVI = "";
  public long bXr = 0L;
  public String bYN = "";
  public String bZs = "";
  public int bcw = -1;
  String clientId = "";
  public long createTime = 0L;
  public int dmi = 0;
  public long eFV = 0L;
  public String eFj = "";
  public int eGk = 0;
  public String eHA = "";
  public int eHC = 0;
  public int eHD = 0;
  public int eHE = 0;
  public long eHF = 0L;
  public long eHG = 0L;
  public int eHH = 0;
  public int eHI = 0;
  public int eHJ = 0;
  public int eHK = 0;
  public int eHL = 0;
  public int eHM = 0;
  public String eHN = "";
  public int eHO = 0;
  public String eHP = "";
  public bwa eHQ = new bwa();
  public avn eHR = new avn();
  public int ebK = 0;
  public String fileName = "";
  public int status = 0;
  public int videoFormat = 0;
  
  private byte[] SH()
  {
    try
    {
      byte[] arrayOfByte = this.eHR.toByteArray();
      return arrayOfByte;
    }
    catch (Exception localException) {}
    return new byte[0];
  }
  
  private byte[] Sz()
  {
    try
    {
      byte[] arrayOfByte = this.eHQ.toByteArray();
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.VideoInfo", localException, "", new Object[0]);
    }
    return new byte[0];
  }
  
  public static String nP(String paramString)
  {
    try
    {
      paramString = bn.s(paramString, "msg");
      if (paramString != null)
      {
        paramString = (String)paramString.get(".msg.videomsg.$cdnvideourl");
        return paramString;
      }
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public final String SA()
  {
    if (this.bVI == null) {
      return "";
    }
    return this.bVI;
  }
  
  public final String SB()
  {
    if (this.eHA == null) {
      return "";
    }
    return this.eHA;
  }
  
  public final String SC()
  {
    if (this.eFj == null) {
      return "";
    }
    return this.eFj;
  }
  
  public final String SD()
  {
    if (this.eHN == null) {
      return "";
    }
    return this.eHN;
  }
  
  public final boolean SE()
  {
    return (this.status == 140) || (this.status == 141) || (this.status == 142);
  }
  
  public final boolean SF()
  {
    return (this.status == 121) || (this.status == 122) || (this.status == 120) || (this.status == 123);
  }
  
  public final boolean SG()
  {
    return (this.status == 199) || (this.status == 199);
  }
  
  public final void d(Cursor paramCursor)
  {
    this.fileName = paramCursor.getString(0);
    this.clientId = paramCursor.getString(1);
    this.bXr = paramCursor.getLong(2);
    this.eGk = paramCursor.getInt(3);
    this.eHC = paramCursor.getInt(4);
    this.ebK = paramCursor.getInt(5);
    this.eHD = paramCursor.getInt(6);
    this.eHE = paramCursor.getInt(7);
    this.status = paramCursor.getInt(8);
    this.createTime = paramCursor.getLong(9);
    this.eHF = paramCursor.getLong(10);
    this.eHG = paramCursor.getLong(11);
    this.eHH = paramCursor.getInt(12);
    this.eHI = paramCursor.getInt(13);
    this.eHJ = paramCursor.getInt(14);
    this.eHK = paramCursor.getInt(15);
    this.bVI = paramCursor.getString(16);
    this.eHA = paramCursor.getString(17);
    this.eHL = paramCursor.getInt(18);
    this.eHM = paramCursor.getInt(19);
    this.eFj = paramCursor.getString(20);
    this.eHN = paramCursor.getString(21);
    this.eHO = paramCursor.getInt(22);
    this.eFV = paramCursor.getLong(23);
    this.eHP = paramCursor.getString(24);
    this.bZs = paramCursor.getString(25);
    byte[] arrayOfByte = paramCursor.getBlob(26);
    this.eHQ = new bwa();
    try
    {
      this.eHQ.aH(arrayOfByte);
      this.bYN = paramCursor.getString(27);
      this.dmi = paramCursor.getInt(28);
      arrayOfByte = paramCursor.getBlob(29);
      this.eHR = new avn();
    }
    catch (Exception localException1)
    {
      try
      {
        this.eHR.aH(arrayOfByte);
        label388:
        this.bRT = paramCursor.getInt(30);
        this.videoFormat = paramCursor.getInt(31);
        return;
        localException1 = localException1;
        y.printErrStackTrace("MicroMsg.VideoInfo", localException1, "", new Object[0]);
      }
      catch (Exception localException2)
      {
        break label388;
      }
    }
  }
  
  public final String getFileName()
  {
    if (this.fileName == null) {
      return "";
    }
    return this.fileName;
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if ((this.bcw & 0x1) != 0) {
      localContentValues.put("filename", getFileName());
    }
    if ((this.bcw & 0x2) != 0) {
      if (this.clientId != null) {
        break label752;
      }
    }
    label752:
    for (String str = "";; str = this.clientId)
    {
      localContentValues.put("clientid", str);
      if ((this.bcw & 0x4) != 0) {
        localContentValues.put("msgsvrid", Long.valueOf(this.bXr));
      }
      if ((this.bcw & 0x8) != 0) {
        localContentValues.put("netoffset", Integer.valueOf(this.eGk));
      }
      if ((this.bcw & 0x10) != 0) {
        localContentValues.put("filenowsize", Integer.valueOf(this.eHC));
      }
      if ((this.bcw & 0x20) != 0) {
        localContentValues.put("totallen", Integer.valueOf(this.ebK));
      }
      if ((this.bcw & 0x40) != 0) {
        localContentValues.put("thumbnetoffset", Integer.valueOf(this.eHD));
      }
      if ((this.bcw & 0x80) != 0) {
        localContentValues.put("thumblen", Integer.valueOf(this.eHE));
      }
      if ((this.bcw & 0x100) != 0) {
        localContentValues.put("status", Integer.valueOf(this.status));
      }
      if ((this.bcw & 0x200) != 0) {
        localContentValues.put("createtime", Long.valueOf(this.createTime));
      }
      if ((this.bcw & 0x400) != 0) {
        localContentValues.put("lastmodifytime", Long.valueOf(this.eHF));
      }
      if ((this.bcw & 0x800) != 0) {
        localContentValues.put("downloadtime", Long.valueOf(this.eHG));
      }
      if ((this.bcw & 0x1000) != 0) {
        localContentValues.put("videolength", Integer.valueOf(this.eHH));
      }
      if ((this.bcw & 0x2000) != 0) {
        localContentValues.put("msglocalid", Integer.valueOf(this.eHI));
      }
      if ((this.bcw & 0x4000) != 0) {
        localContentValues.put("nettimes", Integer.valueOf(this.eHJ));
      }
      if ((this.bcw & 0x8000) != 0) {
        localContentValues.put("cameratype", Integer.valueOf(this.eHK));
      }
      if ((this.bcw & 0x10000) != 0) {
        localContentValues.put("user", SA());
      }
      if ((this.bcw & 0x20000) != 0) {
        localContentValues.put("human", SB());
      }
      if ((this.bcw & 0x40000) != 0) {
        localContentValues.put("reserved1", Integer.valueOf(this.eHL));
      }
      if ((this.bcw & 0x80000) != 0) {
        localContentValues.put("reserved2", Integer.valueOf(this.eHM));
      }
      if ((this.bcw & 0x100000) != 0) {
        localContentValues.put("reserved3", SC());
      }
      if ((this.bcw & 0x200000) != 0) {
        localContentValues.put("reserved4", SD());
      }
      if ((this.bcw & 0x400000) != 0) {
        localContentValues.put("videofuncflag", Integer.valueOf(this.eHO));
      }
      if ((this.bcw & 0x800000) != 0) {
        localContentValues.put("masssendid", Long.valueOf(this.eFV));
      }
      if ((this.bcw & 0x1000000) != 0) {
        localContentValues.put("masssendlist", this.eHP);
      }
      if ((this.bcw & 0x2000000) != 0) {
        localContentValues.put("videomd5", this.bZs);
      }
      if ((this.bcw & 0x4000000) != 0) {
        localContentValues.put("streamvideo", Sz());
      }
      if ((this.bcw & 0x8000000) != 0) {
        localContentValues.put("statextstr", this.bYN);
      }
      if ((this.bcw & 0x10000000) != 0) {
        localContentValues.put("downloadscene", Integer.valueOf(this.dmi));
      }
      if ((this.bcw & 0x20000000) != 0) {
        localContentValues.put("mmsightextinfo", SH());
      }
      if ((this.bcw & 0x1) != 0) {
        localContentValues.put("preloadsize", Integer.valueOf(this.bRT));
      }
      if ((this.bcw & 0x2) != 0) {
        localContentValues.put("videoformat", Integer.valueOf(this.videoFormat));
      }
      return localContentValues;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.s
 * JD-Core Version:    0.7.0.1
 */