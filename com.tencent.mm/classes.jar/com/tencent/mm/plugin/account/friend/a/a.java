package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.z;

public final class a
{
  String bLs;
  public int drx;
  public String exO;
  public int huC;
  public String huz;
  public String iJI;
  long iJJ;
  public String iJK;
  public String iJL;
  String iJM;
  String iJN;
  public String iJO;
  public int iJP;
  public byte[] iJQ;
  public int iJR;
  public String iJS;
  public int iJT;
  public String iJU;
  public String iJV;
  public String iJW;
  int iJX;
  public String iJY;
  int iJZ;
  int iKa;
  String iKb;
  public String iKc;
  String iKd;
  int iKe;
  String iKf;
  long iKg;
  int iKh;
  String iKi;
  String iKj;
  String iKk;
  public long iKl;
  private int id;
  private String md5;
  public String realName;
  public int status;
  public int type;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(130966);
    this.drx = -1;
    this.id = 0;
    this.md5 = "";
    this.iJI = "";
    this.iJJ = 0L;
    this.realName = "";
    this.iJK = "";
    this.iJL = "";
    this.username = "";
    this.bLs = "";
    this.iJM = "";
    this.iJN = "";
    this.type = 0;
    this.iJO = "";
    this.exO = "";
    this.status = 0;
    this.huz = "";
    this.huC = 0;
    this.iJP = 0;
    this.iJS = "";
    this.iJT = 0;
    this.iJU = "";
    this.iJV = "";
    this.iJW = "";
    this.iJX = 0;
    this.iJY = "";
    this.iJZ = 0;
    this.iKa = 0;
    this.iKb = "";
    this.iKc = "";
    this.iKd = "";
    this.iKe = -1;
    this.iKf = "";
    this.iKg = -1L;
    this.iKh = -1;
    this.iKi = "";
    this.iKj = "";
    this.iKk = "";
    this.iKl = 0L;
    AppMethodBeat.o(130966);
  }
  
  public static int Gd(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(130971);
    try
    {
      int j = bs.fM("0x" + paramString.substring(0, 8), 0);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("MicroMsg.AddrUpload", localException, "md5: %s", new Object[] { paramString });
      }
    }
    AppMethodBeat.o(130971);
    return i;
  }
  
  private byte[] aPk()
  {
    AppMethodBeat.i(130970);
    try
    {
      Object localObject = new z();
      ((z)localObject).eUF();
      ((z)localObject).aKJ(this.iJS);
      ((z)localObject).Yr(this.iJT);
      ((z)localObject).aKJ(this.iJU);
      ((z)localObject).aKJ(this.iJV);
      ((z)localObject).aKJ(this.iJW);
      ((z)localObject).Yr(this.iJX);
      ((z)localObject).aKJ(this.iJY);
      ((z)localObject).Yr(this.iJZ);
      ((z)localObject).Yr(this.iKa);
      ((z)localObject).aKJ(this.iKb);
      ((z)localObject).aKJ(this.iKc);
      ((z)localObject).aKJ(this.iKd);
      ((z)localObject).Yr(this.iKe);
      ((z)localObject).aKJ(this.iKf);
      ((z)localObject).Af(this.iKg);
      ((z)localObject).Yr(this.iKh);
      ((z)localObject).aKJ(this.iKi);
      ((z)localObject).aKJ(this.iKj);
      ((z)localObject).aKJ(this.iKk);
      ((z)localObject).Af(this.iKl);
      localObject = ((z)localObject).eUG();
      AppMethodBeat.o(130970);
      return localObject;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.AddrUpload", localException, "", new Object[0]);
      AppMethodBeat.o(130970);
    }
    return null;
  }
  
  private void ap(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130968);
    try
    {
      z localz = new z();
      int i = localz.cr(paramArrayOfByte);
      if (i != 0)
      {
        ac.e("MicroMsg.AddrUpload", "parse LVBuffer error:".concat(String.valueOf(i)));
        AppMethodBeat.o(130968);
        return;
      }
      this.iJS = localz.getString();
      this.iJT = localz.getInt();
      this.iJU = localz.getString();
      this.iJV = localz.getString();
      this.iJW = localz.getString();
      this.iJX = localz.getInt();
      this.iJY = localz.getString();
      this.iJZ = localz.getInt();
      this.iKa = localz.getInt();
      this.iKb = localz.getString();
      this.iKc = localz.getString();
      this.iKd = localz.getString();
      this.iKe = localz.getInt();
      this.iKf = localz.getString();
      this.iKg = localz.getLong();
      this.iKh = localz.getInt();
      this.iKi = localz.getString();
      this.iKj = localz.getString();
      this.iKk = localz.getString();
      this.iKl = localz.getLong();
      AppMethodBeat.o(130968);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ac.printErrStackTrace("MicroMsg.AddrUpload", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(130968);
    }
  }
  
  public final void Ge(String paramString)
  {
    AppMethodBeat.i(130972);
    this.md5 = paramString;
    this.id = Gd(paramString);
    AppMethodBeat.o(130972);
  }
  
  public final String JC()
  {
    if (this.md5 == null) {
      return "";
    }
    return this.md5;
  }
  
  public final String aPl()
  {
    if (this.iJI == null) {
      return "";
    }
    return this.iJI;
  }
  
  public final String aPm()
  {
    if (this.realName == null) {
      return "";
    }
    return this.realName;
  }
  
  public final String aPn()
  {
    if (this.iJK == null) {
      return "";
    }
    return this.iJK;
  }
  
  public final String aPo()
  {
    if (this.iJL == null) {
      return "";
    }
    return this.iJL;
  }
  
  public final String aPp()
  {
    if (this.iJM == null) {
      return "";
    }
    return this.iJM;
  }
  
  public final String aPq()
  {
    if (this.iJN == null) {
      return "";
    }
    return this.iJN;
  }
  
  public final String aPr()
  {
    if (this.iJO == null) {
      return "";
    }
    return this.iJO;
  }
  
  public final void aPs()
  {
    this.iJP |= 0x1;
  }
  
  public final boolean aPt()
  {
    return (this.iJP & 0x1) == 0;
  }
  
  public final int aac()
  {
    AppMethodBeat.i(130973);
    int i = 32;
    int j;
    if (!bs.isNullOrNil(aPn()))
    {
      i = aPn().charAt(0);
      if ((i < 97) || (i > 122)) {
        break label76;
      }
      j = (char)(i - 32);
    }
    for (;;)
    {
      AppMethodBeat.o(130973);
      return j;
      if (bs.isNullOrNil(aPo())) {
        break;
      }
      i = aPo().charAt(0);
      break;
      label76:
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
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(130967);
    Ge(paramCursor.getString(1));
    this.iJI = paramCursor.getString(2);
    this.iJJ = paramCursor.getLong(3);
    this.realName = paramCursor.getString(4);
    this.iJK = paramCursor.getString(5);
    this.iJL = paramCursor.getString(6);
    this.username = paramCursor.getString(7);
    this.bLs = paramCursor.getString(8);
    this.iJM = paramCursor.getString(9);
    this.iJN = paramCursor.getString(10);
    this.type = paramCursor.getInt(11);
    this.iJO = paramCursor.getString(12);
    this.exO = paramCursor.getString(13);
    int i = paramCursor.getInt(14);
    if (i == 65536) {}
    for (this.status = 0;; this.status = i)
    {
      this.iJP = paramCursor.getInt(17);
      this.huz = paramCursor.getString(15);
      this.huC = paramCursor.getInt(18);
      this.iJQ = paramCursor.getBlob(19);
      if (!bs.cv(this.iJQ)) {
        ap(this.iJQ);
      }
      this.iJR = paramCursor.getInt(20);
      AppMethodBeat.o(130967);
      return;
    }
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(130969);
    ContentValues localContentValues = new ContentValues();
    if ((this.drx & 0x1) != 0) {
      localContentValues.put("id", Integer.valueOf(this.id));
    }
    if ((this.drx & 0x2) != 0) {
      localContentValues.put("md5", JC());
    }
    if ((this.drx & 0x4) != 0) {
      localContentValues.put("peopleid", aPl());
    }
    if ((this.drx & 0x8) != 0) {
      localContentValues.put("uploadtime", Long.valueOf(this.iJJ));
    }
    if ((this.drx & 0x10) != 0) {
      localContentValues.put("realname", aPm());
    }
    if ((this.drx & 0x20) != 0) {
      localContentValues.put("realnamepyinitial", aPn());
    }
    if ((this.drx & 0x40) != 0) {
      localContentValues.put("realnamequanpin", aPo());
    }
    if ((this.drx & 0x80) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.drx & 0x100) != 0) {
      localContentValues.put("nickname", getNickName());
    }
    if ((this.drx & 0x200) != 0) {
      localContentValues.put("nicknamepyinitial", aPp());
    }
    if ((this.drx & 0x400) != 0) {
      localContentValues.put("nicknamequanpin", aPq());
    }
    if ((this.drx & 0x800) != 0) {
      localContentValues.put("type", Integer.valueOf(this.type));
    }
    if ((this.drx & 0x1000) != 0) {
      localContentValues.put("moblie", aPr());
    }
    if ((this.drx & 0x2000) != 0) {
      localContentValues.put("email", getEmail());
    }
    int i;
    if ((this.drx & 0x4000) != 0)
    {
      i = this.status;
      if (i != 0) {
        break label489;
      }
      localContentValues.put("status", Integer.valueOf(65536));
    }
    for (;;)
    {
      if ((this.drx & 0x8000) != 0) {
        localContentValues.put("reserved1", this.huz);
      }
      if ((this.drx & 0x20000) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.iJP));
      }
      if ((this.drx & 0x40000) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.huC));
      }
      if ((this.drx & 0x80000) != 0)
      {
        this.iJQ = aPk();
        localContentValues.put("lvbuf", this.iJQ);
      }
      if ((this.drx & 0x100000) != 0) {
        localContentValues.put("showhead", Integer.valueOf(this.iJR));
      }
      AppMethodBeat.o(130969);
      return localContentValues;
      label489:
      localContentValues.put("status", Integer.valueOf(i));
    }
  }
  
  public final String getEmail()
  {
    if (this.exO == null) {
      return "";
    }
    return this.exO;
  }
  
  public final String getNickName()
  {
    if (this.bLs == null) {
      return "";
    }
    return this.bLs;
  }
  
  public final String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.a
 * JD-Core Version:    0.7.0.1
 */