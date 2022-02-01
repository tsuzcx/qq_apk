package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LVBuffer;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class a
{
  public int cSx;
  public String fuD;
  public String iKR;
  public int iKU;
  private int id;
  public String kdN;
  long kdO;
  public String kdP;
  public String kdQ;
  String kdR;
  String kdS;
  public String kdT;
  public int kdU;
  public byte[] kdV;
  public int kdW;
  public String kdX;
  public int kdY;
  public String kdZ;
  public String kea;
  public String keb;
  int kec;
  public String ked;
  int kee;
  int kef;
  String keg;
  public String keh;
  String kei;
  int kej;
  String kek;
  long kel;
  int kem;
  String ken;
  String keo;
  String kep;
  public long keq;
  private String md5;
  String nickName;
  public String realName;
  public int status;
  public int type;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(130966);
    this.cSx = -1;
    this.id = 0;
    this.md5 = "";
    this.kdN = "";
    this.kdO = 0L;
    this.realName = "";
    this.kdP = "";
    this.kdQ = "";
    this.username = "";
    this.nickName = "";
    this.kdR = "";
    this.kdS = "";
    this.type = 0;
    this.kdT = "";
    this.fuD = "";
    this.status = 0;
    this.iKR = "";
    this.iKU = 0;
    this.kdU = 0;
    this.kdX = "";
    this.kdY = 0;
    this.kdZ = "";
    this.kea = "";
    this.keb = "";
    this.kec = 0;
    this.ked = "";
    this.kee = 0;
    this.kef = 0;
    this.keg = "";
    this.keh = "";
    this.kei = "";
    this.kej = -1;
    this.kek = "";
    this.kel = -1L;
    this.kem = -1;
    this.ken = "";
    this.keo = "";
    this.kep = "";
    this.keq = 0L;
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
  
  private void aG(byte[] paramArrayOfByte)
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
      this.kdX = localLVBuffer.getString();
      this.kdY = localLVBuffer.getInt();
      this.kdZ = localLVBuffer.getString();
      this.kea = localLVBuffer.getString();
      this.keb = localLVBuffer.getString();
      this.kec = localLVBuffer.getInt();
      this.ked = localLVBuffer.getString();
      this.kee = localLVBuffer.getInt();
      this.kef = localLVBuffer.getInt();
      this.keg = localLVBuffer.getString();
      this.keh = localLVBuffer.getString();
      this.kei = localLVBuffer.getString();
      this.kej = localLVBuffer.getInt();
      this.kek = localLVBuffer.getString();
      this.kel = localLVBuffer.getLong();
      this.kem = localLVBuffer.getInt();
      this.ken = localLVBuffer.getString();
      this.keo = localLVBuffer.getString();
      this.kep = localLVBuffer.getString();
      this.keq = localLVBuffer.getLong();
      AppMethodBeat.o(130968);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      Log.printErrStackTrace("MicroMsg.AddrUpload", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(130968);
    }
  }
  
  private byte[] bnI()
  {
    AppMethodBeat.i(130970);
    try
    {
      Object localObject = new LVBuffer();
      ((LVBuffer)localObject).initBuild();
      ((LVBuffer)localObject).putString(this.kdX);
      ((LVBuffer)localObject).putInt(this.kdY);
      ((LVBuffer)localObject).putString(this.kdZ);
      ((LVBuffer)localObject).putString(this.kea);
      ((LVBuffer)localObject).putString(this.keb);
      ((LVBuffer)localObject).putInt(this.kec);
      ((LVBuffer)localObject).putString(this.ked);
      ((LVBuffer)localObject).putInt(this.kee);
      ((LVBuffer)localObject).putInt(this.kef);
      ((LVBuffer)localObject).putString(this.keg);
      ((LVBuffer)localObject).putString(this.keh);
      ((LVBuffer)localObject).putString(this.kei);
      ((LVBuffer)localObject).putInt(this.kej);
      ((LVBuffer)localObject).putString(this.kek);
      ((LVBuffer)localObject).putLong(this.kel);
      ((LVBuffer)localObject).putInt(this.kem);
      ((LVBuffer)localObject).putString(this.ken);
      ((LVBuffer)localObject).putString(this.keo);
      ((LVBuffer)localObject).putString(this.kep);
      ((LVBuffer)localObject).putLong(this.keq);
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
  
  public final int aqN()
  {
    AppMethodBeat.i(130973);
    int i = 32;
    int j;
    if (!Util.isNullOrNil(bnL()))
    {
      i = bnL().charAt(0);
      if ((i < 97) || (i > 122)) {
        break label74;
      }
      j = (char)(i - 32);
    }
    for (;;)
    {
      AppMethodBeat.o(130973);
      return j;
      if (Util.isNullOrNil(bnM())) {
        break;
      }
      i = bnM().charAt(0);
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
  
  public final String bnJ()
  {
    if (this.kdN == null) {
      return "";
    }
    return this.kdN;
  }
  
  public final String bnK()
  {
    if (this.realName == null) {
      return "";
    }
    return this.realName;
  }
  
  public final String bnL()
  {
    if (this.kdP == null) {
      return "";
    }
    return this.kdP;
  }
  
  public final String bnM()
  {
    if (this.kdQ == null) {
      return "";
    }
    return this.kdQ;
  }
  
  public final String bnN()
  {
    if (this.kdR == null) {
      return "";
    }
    return this.kdR;
  }
  
  public final String bnO()
  {
    if (this.kdS == null) {
      return "";
    }
    return this.kdS;
  }
  
  public final String bnP()
  {
    if (this.kdT == null) {
      return "";
    }
    return this.kdT;
  }
  
  public final void bnQ()
  {
    this.kdU |= 0x1;
  }
  
  public final boolean bnR()
  {
    return (this.kdU & 0x1) == 0;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(130967);
    setMd5(paramCursor.getString(1));
    this.kdN = paramCursor.getString(2);
    this.kdO = paramCursor.getLong(3);
    this.realName = paramCursor.getString(4);
    this.kdP = paramCursor.getString(5);
    this.kdQ = paramCursor.getString(6);
    this.username = paramCursor.getString(7);
    this.nickName = paramCursor.getString(8);
    this.kdR = paramCursor.getString(9);
    this.kdS = paramCursor.getString(10);
    this.type = paramCursor.getInt(11);
    this.kdT = paramCursor.getString(12);
    this.fuD = paramCursor.getString(13);
    int i = paramCursor.getInt(14);
    if (i == 65536) {}
    for (this.status = 0;; this.status = i)
    {
      this.kdU = paramCursor.getInt(17);
      this.iKR = paramCursor.getString(15);
      this.iKU = paramCursor.getInt(18);
      this.kdV = paramCursor.getBlob(19);
      if (!Util.isNullOrNil(this.kdV)) {
        aG(this.kdV);
      }
      this.kdW = paramCursor.getInt(20);
      AppMethodBeat.o(130967);
      return;
    }
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(130969);
    ContentValues localContentValues = new ContentValues();
    if ((this.cSx & 0x1) != 0) {
      localContentValues.put("id", Integer.valueOf(this.id));
    }
    if ((this.cSx & 0x2) != 0) {
      localContentValues.put("md5", getMd5());
    }
    if ((this.cSx & 0x4) != 0) {
      localContentValues.put("peopleid", bnJ());
    }
    if ((this.cSx & 0x8) != 0) {
      localContentValues.put("uploadtime", Long.valueOf(this.kdO));
    }
    if ((this.cSx & 0x10) != 0) {
      localContentValues.put("realname", bnK());
    }
    if ((this.cSx & 0x20) != 0) {
      localContentValues.put("realnamepyinitial", bnL());
    }
    if ((this.cSx & 0x40) != 0) {
      localContentValues.put("realnamequanpin", bnM());
    }
    if ((this.cSx & 0x80) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.cSx & 0x100) != 0) {
      localContentValues.put("nickname", getNickName());
    }
    if ((this.cSx & 0x200) != 0) {
      localContentValues.put("nicknamepyinitial", bnN());
    }
    if ((this.cSx & 0x400) != 0) {
      localContentValues.put("nicknamequanpin", bnO());
    }
    if ((this.cSx & 0x800) != 0) {
      localContentValues.put("type", Integer.valueOf(this.type));
    }
    if ((this.cSx & 0x1000) != 0) {
      localContentValues.put("moblie", bnP());
    }
    if ((this.cSx & 0x2000) != 0) {
      localContentValues.put("email", getEmail());
    }
    int i;
    if ((this.cSx & 0x4000) != 0)
    {
      i = this.status;
      if (i != 0) {
        break label489;
      }
      localContentValues.put("status", Integer.valueOf(65536));
    }
    for (;;)
    {
      if ((this.cSx & 0x8000) != 0) {
        localContentValues.put("reserved1", this.iKR);
      }
      if ((this.cSx & 0x20000) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.kdU));
      }
      if ((this.cSx & 0x40000) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.iKU));
      }
      if ((this.cSx & 0x80000) != 0)
      {
        this.kdV = bnI();
        localContentValues.put("lvbuf", this.kdV);
      }
      if ((this.cSx & 0x100000) != 0) {
        localContentValues.put("showhead", Integer.valueOf(this.kdW));
      }
      AppMethodBeat.o(130969);
      return localContentValues;
      label489:
      localContentValues.put("status", Integer.valueOf(i));
    }
  }
  
  public final String getEmail()
  {
    if (this.fuD == null) {
      return "";
    }
    return this.fuD;
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
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.a
 * JD-Core Version:    0.7.0.1
 */