package com.tencent.mm.plugin.account.friend.model;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public int eQp;
  private int id;
  public String kab;
  private String md5;
  String nickName;
  public String osA;
  public int osD;
  public String pRU;
  long pRV;
  public String pRW;
  public String pRX;
  String pRY;
  String pRZ;
  public String pSa;
  public int pSb;
  public byte[] pSc;
  public int pSd;
  public String pSe;
  public int pSf;
  public String pSg;
  public String pSh;
  public String pSi;
  int pSj;
  public String pSk;
  int pSl;
  int pSm;
  String pSn;
  public String pSo;
  String pSp;
  int pSq;
  String pSr;
  long pSs;
  int pSt;
  String pSu;
  String pSv;
  String pSw;
  public long pSx;
  public String realName;
  public int status;
  public int type;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(130966);
    this.eQp = -1;
    this.id = 0;
    this.md5 = "";
    this.pRU = "";
    this.pRV = 0L;
    this.realName = "";
    this.pRW = "";
    this.pRX = "";
    this.username = "";
    this.nickName = "";
    this.pRY = "";
    this.pRZ = "";
    this.type = 0;
    this.pSa = "";
    this.kab = "";
    this.status = 0;
    this.osA = "";
    this.osD = 0;
    this.pSb = 0;
    this.pSe = "";
    this.pSf = 0;
    this.pSg = "";
    this.pSh = "";
    this.pSi = "";
    this.pSj = 0;
    this.pSk = "";
    this.pSl = 0;
    this.pSm = 0;
    this.pSn = "";
    this.pSo = "";
    this.pSp = "";
    this.pSq = -1;
    this.pSr = "";
    this.pSs = -1L;
    this.pSt = -1;
    this.pSu = "";
    this.pSv = "";
    this.pSw = "";
    this.pSx = 0L;
    AppMethodBeat.o(130966);
  }
  
  public static int SQ(String paramString)
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
      this.pSe = localLVBuffer.getString();
      this.pSf = localLVBuffer.getInt();
      this.pSg = localLVBuffer.getString();
      this.pSh = localLVBuffer.getString();
      this.pSi = localLVBuffer.getString();
      this.pSj = localLVBuffer.getInt();
      this.pSk = localLVBuffer.getString();
      this.pSl = localLVBuffer.getInt();
      this.pSm = localLVBuffer.getInt();
      this.pSn = localLVBuffer.getString();
      this.pSo = localLVBuffer.getString();
      this.pSp = localLVBuffer.getString();
      this.pSq = localLVBuffer.getInt();
      this.pSr = localLVBuffer.getString();
      this.pSs = localLVBuffer.getLong();
      this.pSt = localLVBuffer.getInt();
      this.pSu = localLVBuffer.getString();
      this.pSv = localLVBuffer.getString();
      this.pSw = localLVBuffer.getString();
      this.pSx = localLVBuffer.getLong();
      AppMethodBeat.o(130968);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.printErrStackTrace("MicroMsg.AddrUpload", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(130968);
    }
  }
  
  private byte[] bWG()
  {
    AppMethodBeat.i(130970);
    try
    {
      Object localObject = new LVBuffer();
      ((LVBuffer)localObject).initBuild();
      ((LVBuffer)localObject).putString(this.pSe);
      ((LVBuffer)localObject).putInt(this.pSf);
      ((LVBuffer)localObject).putString(this.pSg);
      ((LVBuffer)localObject).putString(this.pSh);
      ((LVBuffer)localObject).putString(this.pSi);
      ((LVBuffer)localObject).putInt(this.pSj);
      ((LVBuffer)localObject).putString(this.pSk);
      ((LVBuffer)localObject).putInt(this.pSl);
      ((LVBuffer)localObject).putInt(this.pSm);
      ((LVBuffer)localObject).putString(this.pSn);
      ((LVBuffer)localObject).putString(this.pSo);
      ((LVBuffer)localObject).putString(this.pSp);
      ((LVBuffer)localObject).putInt(this.pSq);
      ((LVBuffer)localObject).putString(this.pSr);
      ((LVBuffer)localObject).putLong(this.pSs);
      ((LVBuffer)localObject).putInt(this.pSt);
      ((LVBuffer)localObject).putString(this.pSu);
      ((LVBuffer)localObject).putString(this.pSv);
      ((LVBuffer)localObject).putString(this.pSw);
      ((LVBuffer)localObject).putLong(this.pSx);
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
  
  public final int aRH()
  {
    AppMethodBeat.i(130973);
    int i = 32;
    int j;
    if (!Util.isNullOrNil(bWJ()))
    {
      i = bWJ().charAt(0);
      if ((i < 97) || (i > 122)) {
        break label74;
      }
      j = (char)(i - 32);
    }
    for (;;)
    {
      AppMethodBeat.o(130973);
      return j;
      if (Util.isNullOrNil(bWK())) {
        break;
      }
      i = bWK().charAt(0);
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
  
  public final String bWH()
  {
    if (this.pRU == null) {
      return "";
    }
    return this.pRU;
  }
  
  public final String bWI()
  {
    if (this.realName == null) {
      return "";
    }
    return this.realName;
  }
  
  public final String bWJ()
  {
    if (this.pRW == null) {
      return "";
    }
    return this.pRW;
  }
  
  public final String bWK()
  {
    if (this.pRX == null) {
      return "";
    }
    return this.pRX;
  }
  
  public final String bWL()
  {
    if (this.pRY == null) {
      return "";
    }
    return this.pRY;
  }
  
  public final String bWM()
  {
    if (this.pRZ == null) {
      return "";
    }
    return this.pRZ;
  }
  
  public final String bWN()
  {
    if (this.pSa == null) {
      return "";
    }
    return this.pSa;
  }
  
  public final void bWO()
  {
    this.pSb |= 0x1;
  }
  
  public final boolean bWP()
  {
    return (this.pSb & 0x1) == 0;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(130967);
    setMd5(paramCursor.getString(1));
    this.pRU = paramCursor.getString(2);
    this.pRV = paramCursor.getLong(3);
    this.realName = paramCursor.getString(4);
    this.pRW = paramCursor.getString(5);
    this.pRX = paramCursor.getString(6);
    this.username = paramCursor.getString(7);
    this.nickName = paramCursor.getString(8);
    this.pRY = paramCursor.getString(9);
    this.pRZ = paramCursor.getString(10);
    this.type = paramCursor.getInt(11);
    this.pSa = paramCursor.getString(12);
    this.kab = paramCursor.getString(13);
    int i = paramCursor.getInt(14);
    if (i == 65536) {}
    for (this.status = 0;; this.status = i)
    {
      this.pSb = paramCursor.getInt(17);
      this.osA = paramCursor.getString(15);
      this.osD = paramCursor.getInt(18);
      this.pSc = paramCursor.getBlob(19);
      if (!Util.isNullOrNil(this.pSc)) {
        aR(this.pSc);
      }
      this.pSd = paramCursor.getInt(20);
      AppMethodBeat.o(130967);
      return;
    }
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(130969);
    ContentValues localContentValues = new ContentValues();
    if ((this.eQp & 0x1) != 0) {
      localContentValues.put("id", Integer.valueOf(this.id));
    }
    if ((this.eQp & 0x2) != 0) {
      localContentValues.put("md5", getMd5());
    }
    if ((this.eQp & 0x4) != 0) {
      localContentValues.put("peopleid", bWH());
    }
    if ((this.eQp & 0x8) != 0) {
      localContentValues.put("uploadtime", Long.valueOf(this.pRV));
    }
    if ((this.eQp & 0x10) != 0) {
      localContentValues.put("realname", bWI());
    }
    if ((this.eQp & 0x20) != 0) {
      localContentValues.put("realnamepyinitial", bWJ());
    }
    if ((this.eQp & 0x40) != 0) {
      localContentValues.put("realnamequanpin", bWK());
    }
    if ((this.eQp & 0x80) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.eQp & 0x100) != 0) {
      localContentValues.put("nickname", getNickName());
    }
    if ((this.eQp & 0x200) != 0) {
      localContentValues.put("nicknamepyinitial", bWL());
    }
    if ((this.eQp & 0x400) != 0) {
      localContentValues.put("nicknamequanpin", bWM());
    }
    if ((this.eQp & 0x800) != 0) {
      localContentValues.put("type", Integer.valueOf(this.type));
    }
    if ((this.eQp & 0x1000) != 0) {
      localContentValues.put("moblie", bWN());
    }
    if ((this.eQp & 0x2000) != 0) {
      localContentValues.put("email", getEmail());
    }
    int i;
    if ((this.eQp & 0x4000) != 0)
    {
      i = this.status;
      if (i != 0) {
        break label489;
      }
      localContentValues.put("status", Integer.valueOf(65536));
    }
    for (;;)
    {
      if ((this.eQp & 0x8000) != 0) {
        localContentValues.put("reserved1", this.osA);
      }
      if ((this.eQp & 0x20000) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.pSb));
      }
      if ((this.eQp & 0x40000) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.osD));
      }
      if ((this.eQp & 0x80000) != 0)
      {
        this.pSc = bWG();
        localContentValues.put("lvbuf", this.pSc);
      }
      if ((this.eQp & 0x100000) != 0) {
        localContentValues.put("showhead", Integer.valueOf(this.pSd));
      }
      AppMethodBeat.o(130969);
      return localContentValues;
      label489:
      localContentValues.put("status", Integer.valueOf(i));
    }
  }
  
  public final String getEmail()
  {
    if (this.kab == null) {
      return "";
    }
    return this.kab;
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
    this.id = SQ(paramString);
    AppMethodBeat.o(130972);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.a
 * JD-Core Version:    0.7.0.1
 */