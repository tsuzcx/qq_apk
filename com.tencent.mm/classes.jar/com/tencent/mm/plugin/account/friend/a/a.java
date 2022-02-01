package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public final class a
{
  String bNK;
  public int dtM;
  public String evs;
  public String gUa;
  public int gUd;
  private int id;
  public String ijB;
  long ijC;
  public String ijD;
  public String ijE;
  String ijF;
  String ijG;
  public String ijH;
  public int ijI;
  public byte[] ijJ;
  public int ijK;
  public String ijL;
  public int ijM;
  public String ijN;
  public String ijO;
  public String ijP;
  int ijQ;
  public String ijR;
  int ijS;
  int ijT;
  String ijU;
  public String ijV;
  String ijW;
  int ijX;
  String ijY;
  long ijZ;
  int ika;
  String ikb;
  String ikc;
  String ikd;
  public long ike;
  private String md5;
  public String realName;
  public int status;
  public int type;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(130966);
    this.dtM = -1;
    this.id = 0;
    this.md5 = "";
    this.ijB = "";
    this.ijC = 0L;
    this.realName = "";
    this.ijD = "";
    this.ijE = "";
    this.username = "";
    this.bNK = "";
    this.ijF = "";
    this.ijG = "";
    this.type = 0;
    this.ijH = "";
    this.evs = "";
    this.status = 0;
    this.gUa = "";
    this.gUd = 0;
    this.ijI = 0;
    this.ijL = "";
    this.ijM = 0;
    this.ijN = "";
    this.ijO = "";
    this.ijP = "";
    this.ijQ = 0;
    this.ijR = "";
    this.ijS = 0;
    this.ijT = 0;
    this.ijU = "";
    this.ijV = "";
    this.ijW = "";
    this.ijX = -1;
    this.ijY = "";
    this.ijZ = -1L;
    this.ika = -1;
    this.ikb = "";
    this.ikc = "";
    this.ikd = "";
    this.ike = 0L;
    AppMethodBeat.o(130966);
  }
  
  public static int Ca(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(130971);
    try
    {
      int j = bt.fH("0x" + paramString.substring(0, 8), 0);
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
  
  private byte[] aIt()
  {
    AppMethodBeat.i(130970);
    try
    {
      Object localObject = new aa();
      ((aa)localObject).eFl();
      ((aa)localObject).aFs(this.ijL);
      ((aa)localObject).Wi(this.ijM);
      ((aa)localObject).aFs(this.ijN);
      ((aa)localObject).aFs(this.ijO);
      ((aa)localObject).aFs(this.ijP);
      ((aa)localObject).Wi(this.ijQ);
      ((aa)localObject).aFs(this.ijR);
      ((aa)localObject).Wi(this.ijS);
      ((aa)localObject).Wi(this.ijT);
      ((aa)localObject).aFs(this.ijU);
      ((aa)localObject).aFs(this.ijV);
      ((aa)localObject).aFs(this.ijW);
      ((aa)localObject).Wi(this.ijX);
      ((aa)localObject).aFs(this.ijY);
      ((aa)localObject).vC(this.ijZ);
      ((aa)localObject).Wi(this.ika);
      ((aa)localObject).aFs(this.ikb);
      ((aa)localObject).aFs(this.ikc);
      ((aa)localObject).aFs(this.ikd);
      ((aa)localObject).vC(this.ike);
      localObject = ((aa)localObject).eFm();
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
  
  private void aq(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(130968);
    try
    {
      aa localaa = new aa();
      int i = localaa.cs(paramArrayOfByte);
      if (i != 0)
      {
        ad.e("MicroMsg.AddrUpload", "parse LVBuffer error:".concat(String.valueOf(i)));
        AppMethodBeat.o(130968);
        return;
      }
      this.ijL = localaa.getString();
      this.ijM = localaa.getInt();
      this.ijN = localaa.getString();
      this.ijO = localaa.getString();
      this.ijP = localaa.getString();
      this.ijQ = localaa.getInt();
      this.ijR = localaa.getString();
      this.ijS = localaa.getInt();
      this.ijT = localaa.getInt();
      this.ijU = localaa.getString();
      this.ijV = localaa.getString();
      this.ijW = localaa.getString();
      this.ijX = localaa.getInt();
      this.ijY = localaa.getString();
      this.ijZ = localaa.getLong();
      this.ika = localaa.getInt();
      this.ikb = localaa.getString();
      this.ikc = localaa.getString();
      this.ikd = localaa.getString();
      this.ike = localaa.getLong();
      AppMethodBeat.o(130968);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ad.printErrStackTrace("MicroMsg.AddrUpload", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(130968);
    }
  }
  
  public final void Cb(String paramString)
  {
    AppMethodBeat.i(130972);
    this.md5 = paramString;
    this.id = Ca(paramString);
    AppMethodBeat.o(130972);
  }
  
  public final String JS()
  {
    if (this.md5 == null) {
      return "";
    }
    return this.md5;
  }
  
  public final int Zh()
  {
    AppMethodBeat.i(130973);
    int i = 32;
    int j;
    if (!bt.isNullOrNil(aIw()))
    {
      i = aIw().charAt(0);
      if ((i < 97) || (i > 122)) {
        break label74;
      }
      j = (char)(i - 32);
    }
    for (;;)
    {
      AppMethodBeat.o(130973);
      return j;
      if (bt.isNullOrNil(aIx())) {
        break;
      }
      i = aIx().charAt(0);
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
  
  public final String aIA()
  {
    if (this.ijH == null) {
      return "";
    }
    return this.ijH;
  }
  
  public final void aIB()
  {
    this.ijI |= 0x1;
  }
  
  public final boolean aIC()
  {
    return (this.ijI & 0x1) == 0;
  }
  
  public final String aIu()
  {
    if (this.ijB == null) {
      return "";
    }
    return this.ijB;
  }
  
  public final String aIv()
  {
    if (this.realName == null) {
      return "";
    }
    return this.realName;
  }
  
  public final String aIw()
  {
    if (this.ijD == null) {
      return "";
    }
    return this.ijD;
  }
  
  public final String aIx()
  {
    if (this.ijE == null) {
      return "";
    }
    return this.ijE;
  }
  
  public final String aIy()
  {
    if (this.ijF == null) {
      return "";
    }
    return this.ijF;
  }
  
  public final String aIz()
  {
    if (this.ijG == null) {
      return "";
    }
    return this.ijG;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(130967);
    Cb(paramCursor.getString(1));
    this.ijB = paramCursor.getString(2);
    this.ijC = paramCursor.getLong(3);
    this.realName = paramCursor.getString(4);
    this.ijD = paramCursor.getString(5);
    this.ijE = paramCursor.getString(6);
    this.username = paramCursor.getString(7);
    this.bNK = paramCursor.getString(8);
    this.ijF = paramCursor.getString(9);
    this.ijG = paramCursor.getString(10);
    this.type = paramCursor.getInt(11);
    this.ijH = paramCursor.getString(12);
    this.evs = paramCursor.getString(13);
    int i = paramCursor.getInt(14);
    if (i == 65536) {}
    for (this.status = 0;; this.status = i)
    {
      this.ijI = paramCursor.getInt(17);
      this.gUa = paramCursor.getString(15);
      this.gUd = paramCursor.getInt(18);
      this.ijJ = paramCursor.getBlob(19);
      if (!bt.cw(this.ijJ)) {
        aq(this.ijJ);
      }
      this.ijK = paramCursor.getInt(20);
      AppMethodBeat.o(130967);
      return;
    }
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(130969);
    ContentValues localContentValues = new ContentValues();
    if ((this.dtM & 0x1) != 0) {
      localContentValues.put("id", Integer.valueOf(this.id));
    }
    if ((this.dtM & 0x2) != 0) {
      localContentValues.put("md5", JS());
    }
    if ((this.dtM & 0x4) != 0) {
      localContentValues.put("peopleid", aIu());
    }
    if ((this.dtM & 0x8) != 0) {
      localContentValues.put("uploadtime", Long.valueOf(this.ijC));
    }
    if ((this.dtM & 0x10) != 0) {
      localContentValues.put("realname", aIv());
    }
    if ((this.dtM & 0x20) != 0) {
      localContentValues.put("realnamepyinitial", aIw());
    }
    if ((this.dtM & 0x40) != 0) {
      localContentValues.put("realnamequanpin", aIx());
    }
    if ((this.dtM & 0x80) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.dtM & 0x100) != 0) {
      localContentValues.put("nickname", getNickName());
    }
    if ((this.dtM & 0x200) != 0) {
      localContentValues.put("nicknamepyinitial", aIy());
    }
    if ((this.dtM & 0x400) != 0) {
      localContentValues.put("nicknamequanpin", aIz());
    }
    if ((this.dtM & 0x800) != 0) {
      localContentValues.put("type", Integer.valueOf(this.type));
    }
    if ((this.dtM & 0x1000) != 0) {
      localContentValues.put("moblie", aIA());
    }
    if ((this.dtM & 0x2000) != 0) {
      localContentValues.put("email", getEmail());
    }
    int i;
    if ((this.dtM & 0x4000) != 0)
    {
      i = this.status;
      if (i != 0) {
        break label489;
      }
      localContentValues.put("status", Integer.valueOf(65536));
    }
    for (;;)
    {
      if ((this.dtM & 0x8000) != 0) {
        localContentValues.put("reserved1", this.gUa);
      }
      if ((this.dtM & 0x20000) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.ijI));
      }
      if ((this.dtM & 0x40000) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.gUd));
      }
      if ((this.dtM & 0x80000) != 0)
      {
        this.ijJ = aIt();
        localContentValues.put("lvbuf", this.ijJ);
      }
      if ((this.dtM & 0x100000) != 0) {
        localContentValues.put("showhead", Integer.valueOf(this.ijK));
      }
      AppMethodBeat.o(130969);
      return localContentValues;
      label489:
      localContentValues.put("status", Integer.valueOf(i));
    }
  }
  
  public final String getEmail()
  {
    if (this.evs == null) {
      return "";
    }
    return this.evs;
  }
  
  public final String getNickName()
  {
    if (this.bNK == null) {
      return "";
    }
    return this.bNK;
  }
  
  public final String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.a
 * JD-Core Version:    0.7.0.1
 */