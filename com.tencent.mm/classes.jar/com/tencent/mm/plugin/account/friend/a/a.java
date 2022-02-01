package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public final class a
{
  String bVF;
  public int dEu;
  public String eQY;
  public String hPK;
  public int hPN;
  private int id;
  public String jfK;
  long jfL;
  public String jfM;
  public String jfN;
  String jfO;
  String jfP;
  public String jfQ;
  public int jfR;
  public byte[] jfS;
  public int jfT;
  public String jfU;
  public int jfV;
  public String jfW;
  public String jfX;
  public String jfY;
  int jfZ;
  public String jga;
  int jgb;
  int jgc;
  String jgd;
  public String jge;
  String jgf;
  int jgg;
  String jgh;
  long jgi;
  int jgj;
  String jgk;
  String jgl;
  String jgm;
  public long jgn;
  private String md5;
  public String realName;
  public int status;
  public int type;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(130966);
    this.dEu = -1;
    this.id = 0;
    this.md5 = "";
    this.jfK = "";
    this.jfL = 0L;
    this.realName = "";
    this.jfM = "";
    this.jfN = "";
    this.username = "";
    this.bVF = "";
    this.jfO = "";
    this.jfP = "";
    this.type = 0;
    this.jfQ = "";
    this.eQY = "";
    this.status = 0;
    this.hPK = "";
    this.hPN = 0;
    this.jfR = 0;
    this.jfU = "";
    this.jfV = 0;
    this.jfW = "";
    this.jfX = "";
    this.jfY = "";
    this.jfZ = 0;
    this.jga = "";
    this.jgb = 0;
    this.jgc = 0;
    this.jgd = "";
    this.jge = "";
    this.jgf = "";
    this.jgg = -1;
    this.jgh = "";
    this.jgi = -1L;
    this.jgj = -1;
    this.jgk = "";
    this.jgl = "";
    this.jgm = "";
    this.jgn = 0L;
    AppMethodBeat.o(130966);
  }
  
  public static int JR(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(130971);
    try
    {
      int j = bu.gs("0x" + paramString.substring(0, 8), 0);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("MicroMsg.AddrUpload", localException, "md5: %s", new Object[] { paramString });
      }
    }
    AppMethodBeat.o(130971);
    return i;
  }
  
  private byte[] aSV()
  {
    AppMethodBeat.i(130970);
    try
    {
      Object localObject = new ab();
      ((ab)localObject).fod();
      ((ab)localObject).aRM(this.jfU);
      ((ab)localObject).abc(this.jfV);
      ((ab)localObject).aRM(this.jfW);
      ((ab)localObject).aRM(this.jfX);
      ((ab)localObject).aRM(this.jfY);
      ((ab)localObject).abc(this.jfZ);
      ((ab)localObject).aRM(this.jga);
      ((ab)localObject).abc(this.jgb);
      ((ab)localObject).abc(this.jgc);
      ((ab)localObject).aRM(this.jgd);
      ((ab)localObject).aRM(this.jge);
      ((ab)localObject).aRM(this.jgf);
      ((ab)localObject).abc(this.jgg);
      ((ab)localObject).aRM(this.jgh);
      ((ab)localObject).Dt(this.jgi);
      ((ab)localObject).abc(this.jgj);
      ((ab)localObject).aRM(this.jgk);
      ((ab)localObject).aRM(this.jgl);
      ((ab)localObject).aRM(this.jgm);
      ((ab)localObject).Dt(this.jgn);
      localObject = ((ab)localObject).foe();
      AppMethodBeat.o(130970);
      return localObject;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.AddrUpload", localException, "", new Object[0]);
      AppMethodBeat.o(130970);
    }
    return null;
  }
  
  private void ap(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130968);
    try
    {
      ab localab = new ab();
      int i = localab.cB(paramArrayOfByte);
      if (i != 0)
      {
        ae.e("MicroMsg.AddrUpload", "parse LVBuffer error:".concat(String.valueOf(i)));
        AppMethodBeat.o(130968);
        return;
      }
      this.jfU = localab.getString();
      this.jfV = localab.getInt();
      this.jfW = localab.getString();
      this.jfX = localab.getString();
      this.jfY = localab.getString();
      this.jfZ = localab.getInt();
      this.jga = localab.getString();
      this.jgb = localab.getInt();
      this.jgc = localab.getInt();
      this.jgd = localab.getString();
      this.jge = localab.getString();
      this.jgf = localab.getString();
      this.jgg = localab.getInt();
      this.jgh = localab.getString();
      this.jgi = localab.getLong();
      this.jgj = localab.getInt();
      this.jgk = localab.getString();
      this.jgl = localab.getString();
      this.jgm = localab.getString();
      this.jgn = localab.getLong();
      AppMethodBeat.o(130968);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ae.printErrStackTrace("MicroMsg.AddrUpload", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(130968);
    }
  }
  
  public final void JS(String paramString)
  {
    AppMethodBeat.i(130972);
    this.md5 = paramString;
    this.id = JR(paramString);
    AppMethodBeat.o(130972);
  }
  
  public final String Lj()
  {
    if (this.md5 == null) {
      return "";
    }
    return this.md5;
  }
  
  public final String aSW()
  {
    if (this.jfK == null) {
      return "";
    }
    return this.jfK;
  }
  
  public final String aSX()
  {
    if (this.realName == null) {
      return "";
    }
    return this.realName;
  }
  
  public final String aSY()
  {
    if (this.jfM == null) {
      return "";
    }
    return this.jfM;
  }
  
  public final String aSZ()
  {
    if (this.jfN == null) {
      return "";
    }
    return this.jfN;
  }
  
  public final String aTa()
  {
    if (this.jfO == null) {
      return "";
    }
    return this.jfO;
  }
  
  public final String aTb()
  {
    if (this.jfP == null) {
      return "";
    }
    return this.jfP;
  }
  
  public final String aTc()
  {
    if (this.jfQ == null) {
      return "";
    }
    return this.jfQ;
  }
  
  public final void aTd()
  {
    this.jfR |= 0x1;
  }
  
  public final boolean aTe()
  {
    return (this.jfR & 0x1) == 0;
  }
  
  public final int acP()
  {
    AppMethodBeat.i(130973);
    int i = 32;
    int j;
    if (!bu.isNullOrNil(aSY()))
    {
      i = aSY().charAt(0);
      if ((i < 97) || (i > 122)) {
        break label76;
      }
      j = (char)(i - 32);
    }
    for (;;)
    {
      AppMethodBeat.o(130973);
      return j;
      if (bu.isNullOrNil(aSZ())) {
        break;
      }
      i = aSZ().charAt(0);
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
    JS(paramCursor.getString(1));
    this.jfK = paramCursor.getString(2);
    this.jfL = paramCursor.getLong(3);
    this.realName = paramCursor.getString(4);
    this.jfM = paramCursor.getString(5);
    this.jfN = paramCursor.getString(6);
    this.username = paramCursor.getString(7);
    this.bVF = paramCursor.getString(8);
    this.jfO = paramCursor.getString(9);
    this.jfP = paramCursor.getString(10);
    this.type = paramCursor.getInt(11);
    this.jfQ = paramCursor.getString(12);
    this.eQY = paramCursor.getString(13);
    int i = paramCursor.getInt(14);
    if (i == 65536) {}
    for (this.status = 0;; this.status = i)
    {
      this.jfR = paramCursor.getInt(17);
      this.hPK = paramCursor.getString(15);
      this.hPN = paramCursor.getInt(18);
      this.jfS = paramCursor.getBlob(19);
      if (!bu.cF(this.jfS)) {
        ap(this.jfS);
      }
      this.jfT = paramCursor.getInt(20);
      AppMethodBeat.o(130967);
      return;
    }
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(130969);
    ContentValues localContentValues = new ContentValues();
    if ((this.dEu & 0x1) != 0) {
      localContentValues.put("id", Integer.valueOf(this.id));
    }
    if ((this.dEu & 0x2) != 0) {
      localContentValues.put("md5", Lj());
    }
    if ((this.dEu & 0x4) != 0) {
      localContentValues.put("peopleid", aSW());
    }
    if ((this.dEu & 0x8) != 0) {
      localContentValues.put("uploadtime", Long.valueOf(this.jfL));
    }
    if ((this.dEu & 0x10) != 0) {
      localContentValues.put("realname", aSX());
    }
    if ((this.dEu & 0x20) != 0) {
      localContentValues.put("realnamepyinitial", aSY());
    }
    if ((this.dEu & 0x40) != 0) {
      localContentValues.put("realnamequanpin", aSZ());
    }
    if ((this.dEu & 0x80) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.dEu & 0x100) != 0) {
      localContentValues.put("nickname", getNickName());
    }
    if ((this.dEu & 0x200) != 0) {
      localContentValues.put("nicknamepyinitial", aTa());
    }
    if ((this.dEu & 0x400) != 0) {
      localContentValues.put("nicknamequanpin", aTb());
    }
    if ((this.dEu & 0x800) != 0) {
      localContentValues.put("type", Integer.valueOf(this.type));
    }
    if ((this.dEu & 0x1000) != 0) {
      localContentValues.put("moblie", aTc());
    }
    if ((this.dEu & 0x2000) != 0) {
      localContentValues.put("email", getEmail());
    }
    int i;
    if ((this.dEu & 0x4000) != 0)
    {
      i = this.status;
      if (i != 0) {
        break label489;
      }
      localContentValues.put("status", Integer.valueOf(65536));
    }
    for (;;)
    {
      if ((this.dEu & 0x8000) != 0) {
        localContentValues.put("reserved1", this.hPK);
      }
      if ((this.dEu & 0x20000) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.jfR));
      }
      if ((this.dEu & 0x40000) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.hPN));
      }
      if ((this.dEu & 0x80000) != 0)
      {
        this.jfS = aSV();
        localContentValues.put("lvbuf", this.jfS);
      }
      if ((this.dEu & 0x100000) != 0) {
        localContentValues.put("showhead", Integer.valueOf(this.jfT));
      }
      AppMethodBeat.o(130969);
      return localContentValues;
      label489:
      localContentValues.put("status", Integer.valueOf(i));
    }
  }
  
  public final String getEmail()
  {
    if (this.eQY == null) {
      return "";
    }
    return this.eQY;
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