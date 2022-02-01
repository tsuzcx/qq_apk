package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public int cUP;
  public String hDf;
  private int id;
  public String lAY;
  public int lBb;
  public String mVA;
  public String mVB;
  int mVC;
  public String mVD;
  int mVE;
  int mVF;
  String mVG;
  public String mVH;
  String mVI;
  int mVJ;
  String mVK;
  long mVL;
  int mVM;
  String mVN;
  String mVO;
  String mVP;
  public long mVQ;
  public String mVn;
  long mVo;
  public String mVp;
  public String mVq;
  String mVr;
  String mVs;
  public String mVt;
  public int mVu;
  public byte[] mVv;
  public int mVw;
  public String mVx;
  public int mVy;
  public String mVz;
  private String md5;
  String nickName;
  public String realName;
  public int status;
  public int type;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(130966);
    this.cUP = -1;
    this.id = 0;
    this.md5 = "";
    this.mVn = "";
    this.mVo = 0L;
    this.realName = "";
    this.mVp = "";
    this.mVq = "";
    this.username = "";
    this.nickName = "";
    this.mVr = "";
    this.mVs = "";
    this.type = 0;
    this.mVt = "";
    this.hDf = "";
    this.status = 0;
    this.lAY = "";
    this.lBb = 0;
    this.mVu = 0;
    this.mVx = "";
    this.mVy = 0;
    this.mVz = "";
    this.mVA = "";
    this.mVB = "";
    this.mVC = 0;
    this.mVD = "";
    this.mVE = 0;
    this.mVF = 0;
    this.mVG = "";
    this.mVH = "";
    this.mVI = "";
    this.mVJ = -1;
    this.mVK = "";
    this.mVL = -1L;
    this.mVM = -1;
    this.mVN = "";
    this.mVO = "";
    this.mVP = "";
    this.mVQ = 0L;
    AppMethodBeat.o(130966);
  }
  
  private void aR(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130968);
    try
    {
      LVBuffer localLVBuffer = new LVBuffer();
      int i = localLVBuffer.initParse(paramArrayOfByte);
      if (i != 0)
      {
        Log.e("MicroMsg.AddrUpload", "parse LVBuffer error:".concat(String.valueOf(i)));
        AppMethodBeat.o(130968);
        return;
      }
      this.mVx = localLVBuffer.getString();
      this.mVy = localLVBuffer.getInt();
      this.mVz = localLVBuffer.getString();
      this.mVA = localLVBuffer.getString();
      this.mVB = localLVBuffer.getString();
      this.mVC = localLVBuffer.getInt();
      this.mVD = localLVBuffer.getString();
      this.mVE = localLVBuffer.getInt();
      this.mVF = localLVBuffer.getInt();
      this.mVG = localLVBuffer.getString();
      this.mVH = localLVBuffer.getString();
      this.mVI = localLVBuffer.getString();
      this.mVJ = localLVBuffer.getInt();
      this.mVK = localLVBuffer.getString();
      this.mVL = localLVBuffer.getLong();
      this.mVM = localLVBuffer.getInt();
      this.mVN = localLVBuffer.getString();
      this.mVO = localLVBuffer.getString();
      this.mVP = localLVBuffer.getString();
      this.mVQ = localLVBuffer.getLong();
      AppMethodBeat.o(130968);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.printErrStackTrace("MicroMsg.AddrUpload", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(130968);
    }
  }
  
  public static int aaw(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(130971);
    try
    {
      int j = Util.getHex("0x" + paramString.substring(0, 8), 0);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.AddrUpload", localException, "md5: %s", new Object[] { paramString });
      }
    }
    AppMethodBeat.o(130971);
    return i;
  }
  
  private byte[] bxR()
  {
    AppMethodBeat.i(130970);
    try
    {
      Object localObject = new LVBuffer();
      ((LVBuffer)localObject).initBuild();
      ((LVBuffer)localObject).putString(this.mVx);
      ((LVBuffer)localObject).putInt(this.mVy);
      ((LVBuffer)localObject).putString(this.mVz);
      ((LVBuffer)localObject).putString(this.mVA);
      ((LVBuffer)localObject).putString(this.mVB);
      ((LVBuffer)localObject).putInt(this.mVC);
      ((LVBuffer)localObject).putString(this.mVD);
      ((LVBuffer)localObject).putInt(this.mVE);
      ((LVBuffer)localObject).putInt(this.mVF);
      ((LVBuffer)localObject).putString(this.mVG);
      ((LVBuffer)localObject).putString(this.mVH);
      ((LVBuffer)localObject).putString(this.mVI);
      ((LVBuffer)localObject).putInt(this.mVJ);
      ((LVBuffer)localObject).putString(this.mVK);
      ((LVBuffer)localObject).putLong(this.mVL);
      ((LVBuffer)localObject).putInt(this.mVM);
      ((LVBuffer)localObject).putString(this.mVN);
      ((LVBuffer)localObject).putString(this.mVO);
      ((LVBuffer)localObject).putString(this.mVP);
      ((LVBuffer)localObject).putLong(this.mVQ);
      localObject = ((LVBuffer)localObject).buildFinish();
      AppMethodBeat.o(130970);
      return localObject;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.AddrUpload", localException, "", new Object[0]);
      AppMethodBeat.o(130970);
    }
    return null;
  }
  
  public final int axh()
  {
    AppMethodBeat.i(130973);
    int i = 32;
    int j;
    if (!Util.isNullOrNil(bxU()))
    {
      i = bxU().charAt(0);
      if ((i < 97) || (i > 122)) {
        break label74;
      }
      j = (char)(i - 32);
    }
    for (;;)
    {
      AppMethodBeat.o(130973);
      return j;
      if (Util.isNullOrNil(bxV())) {
        break;
      }
      i = bxV().charAt(0);
      break;
      label74:
      if (i >= 65)
      {
        j = i;
        if (i <= 90) {}
      }
      else
      {
        j = 123;
      }
    }
  }
  
  public final String bxS()
  {
    if (this.mVn == null) {
      return "";
    }
    return this.mVn;
  }
  
  public final String bxT()
  {
    if (this.realName == null) {
      return "";
    }
    return this.realName;
  }
  
  public final String bxU()
  {
    if (this.mVp == null) {
      return "";
    }
    return this.mVp;
  }
  
  public final String bxV()
  {
    if (this.mVq == null) {
      return "";
    }
    return this.mVq;
  }
  
  public final String bxW()
  {
    if (this.mVr == null) {
      return "";
    }
    return this.mVr;
  }
  
  public final String bxX()
  {
    if (this.mVs == null) {
      return "";
    }
    return this.mVs;
  }
  
  public final String bxY()
  {
    if (this.mVt == null) {
      return "";
    }
    return this.mVt;
  }
  
  public final void bxZ()
  {
    this.mVu |= 0x1;
  }
  
  public final boolean bya()
  {
    return (this.mVu & 0x1) == 0;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(130967);
    setMd5(paramCursor.getString(1));
    this.mVn = paramCursor.getString(2);
    this.mVo = paramCursor.getLong(3);
    this.realName = paramCursor.getString(4);
    this.mVp = paramCursor.getString(5);
    this.mVq = paramCursor.getString(6);
    this.username = paramCursor.getString(7);
    this.nickName = paramCursor.getString(8);
    this.mVr = paramCursor.getString(9);
    this.mVs = paramCursor.getString(10);
    this.type = paramCursor.getInt(11);
    this.mVt = paramCursor.getString(12);
    this.hDf = paramCursor.getString(13);
    int i = paramCursor.getInt(14);
    if (i == 65536) {}
    for (this.status = 0;; this.status = i)
    {
      this.mVu = paramCursor.getInt(17);
      this.lAY = paramCursor.getString(15);
      this.lBb = paramCursor.getInt(18);
      this.mVv = paramCursor.getBlob(19);
      if (!Util.isNullOrNil(this.mVv)) {
        aR(this.mVv);
      }
      this.mVw = paramCursor.getInt(20);
      AppMethodBeat.o(130967);
      return;
    }
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(130969);
    ContentValues localContentValues = new ContentValues();
    if ((this.cUP & 0x1) != 0) {
      localContentValues.put("id", Integer.valueOf(this.id));
    }
    if ((this.cUP & 0x2) != 0) {
      localContentValues.put("md5", getMd5());
    }
    if ((this.cUP & 0x4) != 0) {
      localContentValues.put("peopleid", bxS());
    }
    if ((this.cUP & 0x8) != 0) {
      localContentValues.put("uploadtime", Long.valueOf(this.mVo));
    }
    if ((this.cUP & 0x10) != 0) {
      localContentValues.put("realname", bxT());
    }
    if ((this.cUP & 0x20) != 0) {
      localContentValues.put("realnamepyinitial", bxU());
    }
    if ((this.cUP & 0x40) != 0) {
      localContentValues.put("realnamequanpin", bxV());
    }
    if ((this.cUP & 0x80) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.cUP & 0x100) != 0) {
      localContentValues.put("nickname", getNickName());
    }
    if ((this.cUP & 0x200) != 0) {
      localContentValues.put("nicknamepyinitial", bxW());
    }
    if ((this.cUP & 0x400) != 0) {
      localContentValues.put("nicknamequanpin", bxX());
    }
    if ((this.cUP & 0x800) != 0) {
      localContentValues.put("type", Integer.valueOf(this.type));
    }
    if ((this.cUP & 0x1000) != 0) {
      localContentValues.put("moblie", bxY());
    }
    if ((this.cUP & 0x2000) != 0) {
      localContentValues.put("email", getEmail());
    }
    int i;
    if ((this.cUP & 0x4000) != 0)
    {
      i = this.status;
      if (i != 0) {
        break label489;
      }
      localContentValues.put("status", Integer.valueOf(65536));
    }
    for (;;)
    {
      if ((this.cUP & 0x8000) != 0) {
        localContentValues.put("reserved1", this.lAY);
      }
      if ((this.cUP & 0x20000) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.mVu));
      }
      if ((this.cUP & 0x40000) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.lBb));
      }
      if ((this.cUP & 0x80000) != 0)
      {
        this.mVv = bxR();
        localContentValues.put("lvbuf", this.mVv);
      }
      if ((this.cUP & 0x100000) != 0) {
        localContentValues.put("showhead", Integer.valueOf(this.mVw));
      }
      AppMethodBeat.o(130969);
      return localContentValues;
      label489:
      localContentValues.put("status", Integer.valueOf(i));
    }
  }
  
  public final String getEmail()
  {
    if (this.hDf == null) {
      return "";
    }
    return this.hDf;
  }
  
  public final String getMd5()
  {
    if (this.md5 == null) {
      return "";
    }
    return this.md5;
  }
  
  public final String getNickName()
  {
    if (this.nickName == null) {
      return "";
    }
    return this.nickName;
  }
  
  public final String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
  
  public final void setMd5(String paramString)
  {
    AppMethodBeat.i(130972);
    this.md5 = paramString;
    this.id = aaw(paramString);
    AppMethodBeat.o(130972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.a
 * JD-Core Version:    0.7.0.1
 */