package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  String bVF;
  public int dDp;
  public String ePn;
  public String hMR;
  public int hMU;
  private int id;
  public String jcR;
  long jcS;
  public String jcT;
  public String jcU;
  String jcV;
  String jcW;
  public String jcX;
  public int jcY;
  public byte[] jcZ;
  public int jda;
  public String jdb;
  public int jdc;
  public String jdd;
  public String jde;
  public String jdf;
  int jdg;
  public String jdh;
  int jdi;
  int jdj;
  String jdk;
  public String jdl;
  String jdm;
  int jdn;
  String jdo;
  long jdp;
  int jdq;
  String jdr;
  String jds;
  String jdt;
  public long jdu;
  private String md5;
  public String realName;
  public int status;
  public int type;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(130966);
    this.dDp = -1;
    this.id = 0;
    this.md5 = "";
    this.jcR = "";
    this.jcS = 0L;
    this.realName = "";
    this.jcT = "";
    this.jcU = "";
    this.username = "";
    this.bVF = "";
    this.jcV = "";
    this.jcW = "";
    this.type = 0;
    this.jcX = "";
    this.ePn = "";
    this.status = 0;
    this.hMR = "";
    this.hMU = 0;
    this.jcY = 0;
    this.jdb = "";
    this.jdc = 0;
    this.jdd = "";
    this.jde = "";
    this.jdf = "";
    this.jdg = 0;
    this.jdh = "";
    this.jdi = 0;
    this.jdj = 0;
    this.jdk = "";
    this.jdl = "";
    this.jdm = "";
    this.jdn = -1;
    this.jdo = "";
    this.jdp = -1L;
    this.jdq = -1;
    this.jdr = "";
    this.jds = "";
    this.jdt = "";
    this.jdu = 0L;
    AppMethodBeat.o(130966);
  }
  
  public static int Js(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(130971);
    try
    {
      int j = bt.gj("0x" + paramString.substring(0, 8), 0);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("MicroMsg.AddrUpload", localException, "md5: %s", new Object[] { paramString });
      }
    }
    AppMethodBeat.o(130971);
    return i;
  }
  
  private byte[] aSw()
  {
    AppMethodBeat.i(130970);
    try
    {
      Object localObject = new aa();
      ((aa)localObject).fkj();
      ((aa)localObject).aQp(this.jdb);
      ((aa)localObject).aaw(this.jdc);
      ((aa)localObject).aQp(this.jdd);
      ((aa)localObject).aQp(this.jde);
      ((aa)localObject).aQp(this.jdf);
      ((aa)localObject).aaw(this.jdg);
      ((aa)localObject).aQp(this.jdh);
      ((aa)localObject).aaw(this.jdi);
      ((aa)localObject).aaw(this.jdj);
      ((aa)localObject).aQp(this.jdk);
      ((aa)localObject).aQp(this.jdl);
      ((aa)localObject).aQp(this.jdm);
      ((aa)localObject).aaw(this.jdn);
      ((aa)localObject).aQp(this.jdo);
      ((aa)localObject).CV(this.jdp);
      ((aa)localObject).aaw(this.jdq);
      ((aa)localObject).aQp(this.jdr);
      ((aa)localObject).aQp(this.jds);
      ((aa)localObject).aQp(this.jdt);
      ((aa)localObject).CV(this.jdu);
      localObject = ((aa)localObject).fkk();
      AppMethodBeat.o(130970);
      return localObject;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.AddrUpload", localException, "", new Object[0]);
      AppMethodBeat.o(130970);
    }
    return null;
  }
  
  private void ap(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130968);
    try
    {
      aa localaa = new aa();
      int i = localaa.cy(paramArrayOfByte);
      if (i != 0)
      {
        ad.e("MicroMsg.AddrUpload", "parse LVBuffer error:".concat(String.valueOf(i)));
        AppMethodBeat.o(130968);
        return;
      }
      this.jdb = localaa.getString();
      this.jdc = localaa.getInt();
      this.jdd = localaa.getString();
      this.jde = localaa.getString();
      this.jdf = localaa.getString();
      this.jdg = localaa.getInt();
      this.jdh = localaa.getString();
      this.jdi = localaa.getInt();
      this.jdj = localaa.getInt();
      this.jdk = localaa.getString();
      this.jdl = localaa.getString();
      this.jdm = localaa.getString();
      this.jdn = localaa.getInt();
      this.jdo = localaa.getString();
      this.jdp = localaa.getLong();
      this.jdq = localaa.getInt();
      this.jdr = localaa.getString();
      this.jds = localaa.getString();
      this.jdt = localaa.getString();
      this.jdu = localaa.getLong();
      AppMethodBeat.o(130968);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.printErrStackTrace("MicroMsg.AddrUpload", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(130968);
    }
  }
  
  public final void Jt(String paramString)
  {
    AppMethodBeat.i(130972);
    this.md5 = paramString;
    this.id = Js(paramString);
    AppMethodBeat.o(130972);
  }
  
  public final String Lb()
  {
    if (this.md5 == null) {
      return "";
    }
    return this.md5;
  }
  
  public final String aSA()
  {
    if (this.jcU == null) {
      return "";
    }
    return this.jcU;
  }
  
  public final String aSB()
  {
    if (this.jcV == null) {
      return "";
    }
    return this.jcV;
  }
  
  public final String aSC()
  {
    if (this.jcW == null) {
      return "";
    }
    return this.jcW;
  }
  
  public final String aSD()
  {
    if (this.jcX == null) {
      return "";
    }
    return this.jcX;
  }
  
  public final void aSE()
  {
    this.jcY |= 0x1;
  }
  
  public final boolean aSF()
  {
    return (this.jcY & 0x1) == 0;
  }
  
  public final String aSx()
  {
    if (this.jcR == null) {
      return "";
    }
    return this.jcR;
  }
  
  public final String aSy()
  {
    if (this.realName == null) {
      return "";
    }
    return this.realName;
  }
  
  public final String aSz()
  {
    if (this.jcT == null) {
      return "";
    }
    return this.jcT;
  }
  
  public final int acE()
  {
    AppMethodBeat.i(130973);
    int i = 32;
    int j;
    if (!bt.isNullOrNil(aSz()))
    {
      i = aSz().charAt(0);
      if ((i < 97) || (i > 122)) {
        break label76;
      }
      j = (char)(i - 32);
    }
    for (;;)
    {
      AppMethodBeat.o(130973);
      return j;
      if (bt.isNullOrNil(aSA())) {
        break;
      }
      i = aSA().charAt(0);
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
    Jt(paramCursor.getString(1));
    this.jcR = paramCursor.getString(2);
    this.jcS = paramCursor.getLong(3);
    this.realName = paramCursor.getString(4);
    this.jcT = paramCursor.getString(5);
    this.jcU = paramCursor.getString(6);
    this.username = paramCursor.getString(7);
    this.bVF = paramCursor.getString(8);
    this.jcV = paramCursor.getString(9);
    this.jcW = paramCursor.getString(10);
    this.type = paramCursor.getInt(11);
    this.jcX = paramCursor.getString(12);
    this.ePn = paramCursor.getString(13);
    int i = paramCursor.getInt(14);
    if (i == 65536) {}
    for (this.status = 0;; this.status = i)
    {
      this.jcY = paramCursor.getInt(17);
      this.hMR = paramCursor.getString(15);
      this.hMU = paramCursor.getInt(18);
      this.jcZ = paramCursor.getBlob(19);
      if (!bt.cC(this.jcZ)) {
        ap(this.jcZ);
      }
      this.jda = paramCursor.getInt(20);
      AppMethodBeat.o(130967);
      return;
    }
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(130969);
    ContentValues localContentValues = new ContentValues();
    if ((this.dDp & 0x1) != 0) {
      localContentValues.put("id", Integer.valueOf(this.id));
    }
    if ((this.dDp & 0x2) != 0) {
      localContentValues.put("md5", Lb());
    }
    if ((this.dDp & 0x4) != 0) {
      localContentValues.put("peopleid", aSx());
    }
    if ((this.dDp & 0x8) != 0) {
      localContentValues.put("uploadtime", Long.valueOf(this.jcS));
    }
    if ((this.dDp & 0x10) != 0) {
      localContentValues.put("realname", aSy());
    }
    if ((this.dDp & 0x20) != 0) {
      localContentValues.put("realnamepyinitial", aSz());
    }
    if ((this.dDp & 0x40) != 0) {
      localContentValues.put("realnamequanpin", aSA());
    }
    if ((this.dDp & 0x80) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.dDp & 0x100) != 0) {
      localContentValues.put("nickname", getNickName());
    }
    if ((this.dDp & 0x200) != 0) {
      localContentValues.put("nicknamepyinitial", aSB());
    }
    if ((this.dDp & 0x400) != 0) {
      localContentValues.put("nicknamequanpin", aSC());
    }
    if ((this.dDp & 0x800) != 0) {
      localContentValues.put("type", Integer.valueOf(this.type));
    }
    if ((this.dDp & 0x1000) != 0) {
      localContentValues.put("moblie", aSD());
    }
    if ((this.dDp & 0x2000) != 0) {
      localContentValues.put("email", getEmail());
    }
    int i;
    if ((this.dDp & 0x4000) != 0)
    {
      i = this.status;
      if (i != 0) {
        break label489;
      }
      localContentValues.put("status", Integer.valueOf(65536));
    }
    for (;;)
    {
      if ((this.dDp & 0x8000) != 0) {
        localContentValues.put("reserved1", this.hMR);
      }
      if ((this.dDp & 0x20000) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.jcY));
      }
      if ((this.dDp & 0x40000) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.hMU));
      }
      if ((this.dDp & 0x80000) != 0)
      {
        this.jcZ = aSw();
        localContentValues.put("lvbuf", this.jcZ);
      }
      if ((this.dDp & 0x100000) != 0) {
        localContentValues.put("showhead", Integer.valueOf(this.jda));
      }
      AppMethodBeat.o(130969);
      return localContentValues;
      label489:
      localContentValues.put("status", Integer.valueOf(i));
    }
  }
  
  public final String getEmail()
  {
    if (this.ePn == null) {
      return "";
    }
    return this.ePn;
  }
  
  public final String getNickName()
  {
    if (this.bVF == null) {
      return "";
    }
    return this.bVF;
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