package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  String blZ;
  public int bsY;
  private String cqq;
  public String dqF;
  public String ezj;
  public String fsf;
  public int fsi;
  public String gwE;
  long gwF;
  public String gwG;
  public String gwH;
  String gwI;
  String gwJ;
  public String gwK;
  public int gwL;
  public byte[] gwM;
  public int gwN;
  public String gwO;
  public int gwP;
  public String gwQ;
  public String gwR;
  public String gwS;
  int gwT;
  public String gwU;
  int gwV;
  int gwW;
  String gwX;
  public String gwY;
  String gwZ;
  int gxa;
  String gxb;
  long gxc;
  int gxd;
  String gxe;
  String gxf;
  String gxg;
  public long gxh;
  private int id;
  public int status;
  public int type;
  public String username;
  
  public a()
  {
    AppMethodBeat.i(108301);
    this.bsY = -1;
    this.id = 0;
    this.cqq = "";
    this.gwE = "";
    this.gwF = 0L;
    this.ezj = "";
    this.gwG = "";
    this.gwH = "";
    this.username = "";
    this.blZ = "";
    this.gwI = "";
    this.gwJ = "";
    this.type = 0;
    this.gwK = "";
    this.dqF = "";
    this.status = 0;
    this.fsf = "";
    this.fsi = 0;
    this.gwL = 0;
    this.gwO = "";
    this.gwP = 0;
    this.gwQ = "";
    this.gwR = "";
    this.gwS = "";
    this.gwT = 0;
    this.gwU = "";
    this.gwV = 0;
    this.gwW = 0;
    this.gwX = "";
    this.gwY = "";
    this.gwZ = "";
    this.gxa = -1;
    this.gxb = "";
    this.gxc = -1L;
    this.gxd = -1;
    this.gxe = "";
    this.gxf = "";
    this.gxg = "";
    this.gxh = 0L;
    AppMethodBeat.o(108301);
  }
  
  private void ag(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108303);
    try
    {
      y localy = new y();
      int i = localy.ca(paramArrayOfByte);
      if (i != 0)
      {
        ab.e("MicroMsg.AddrUpload", "parse LVBuffer error:".concat(String.valueOf(i)));
        AppMethodBeat.o(108303);
        return;
      }
      this.gwO = localy.getString();
      this.gwP = localy.getInt();
      this.gwQ = localy.getString();
      this.gwR = localy.getString();
      this.gwS = localy.getString();
      this.gwT = localy.getInt();
      this.gwU = localy.getString();
      this.gwV = localy.getInt();
      this.gwW = localy.getInt();
      this.gwX = localy.getString();
      this.gwY = localy.getString();
      this.gwZ = localy.getString();
      this.gxa = localy.getInt();
      this.gxb = localy.getString();
      this.gxc = localy.getLong();
      this.gxd = localy.getInt();
      this.gxe = localy.getString();
      this.gxf = localy.getString();
      this.gxg = localy.getString();
      this.gxh = localy.getLong();
      AppMethodBeat.o(108303);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      ab.printErrStackTrace("MicroMsg.AddrUpload", paramArrayOfByte, "", new Object[0]);
      AppMethodBeat.o(108303);
    }
  }
  
  private byte[] apX()
  {
    AppMethodBeat.i(108305);
    try
    {
      Object localObject = new y();
      ((y)localObject).dsv();
      ((y)localObject).ape(this.gwO);
      ((y)localObject).Nd(this.gwP);
      ((y)localObject).ape(this.gwQ);
      ((y)localObject).ape(this.gwR);
      ((y)localObject).ape(this.gwS);
      ((y)localObject).Nd(this.gwT);
      ((y)localObject).ape(this.gwU);
      ((y)localObject).Nd(this.gwV);
      ((y)localObject).Nd(this.gwW);
      ((y)localObject).ape(this.gwX);
      ((y)localObject).ape(this.gwY);
      ((y)localObject).ape(this.gwZ);
      ((y)localObject).Nd(this.gxa);
      ((y)localObject).ape(this.gxb);
      ((y)localObject).nN(this.gxc);
      ((y)localObject).Nd(this.gxd);
      ((y)localObject).ape(this.gxe);
      ((y)localObject).ape(this.gxf);
      ((y)localObject).ape(this.gxg);
      ((y)localObject).nN(this.gxh);
      localObject = ((y)localObject).dsw();
      AppMethodBeat.o(108305);
      return localObject;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.AddrUpload", localException, "", new Object[0]);
      AppMethodBeat.o(108305);
    }
    return null;
  }
  
  public static int wV(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(108306);
    try
    {
      int j = bo.apN("0x" + paramString.substring(0, 8));
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.AddrUpload", localException, "md5: %s", new Object[] { paramString });
      }
    }
    AppMethodBeat.o(108306);
    return i;
  }
  
  public final String Al()
  {
    if (this.cqq == null) {
      return "";
    }
    return this.cqq;
  }
  
  public final int Nu()
  {
    AppMethodBeat.i(108308);
    int i = 32;
    int j;
    if (!bo.isNullOrNil(aqa()))
    {
      i = aqa().charAt(0);
      if ((i < 97) || (i > 122)) {
        break label74;
      }
      j = (char)(i - 32);
    }
    for (;;)
    {
      AppMethodBeat.o(108308);
      return j;
      if (bo.isNullOrNil(aqb())) {
        break;
      }
      i = aqb().charAt(0);
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
  
  public final String apY()
  {
    if (this.gwE == null) {
      return "";
    }
    return this.gwE;
  }
  
  public final String apZ()
  {
    if (this.ezj == null) {
      return "";
    }
    return this.ezj;
  }
  
  public final String aqa()
  {
    if (this.gwG == null) {
      return "";
    }
    return this.gwG;
  }
  
  public final String aqb()
  {
    if (this.gwH == null) {
      return "";
    }
    return this.gwH;
  }
  
  public final String aqc()
  {
    if (this.blZ == null) {
      return "";
    }
    return this.blZ;
  }
  
  public final String aqd()
  {
    if (this.gwI == null) {
      return "";
    }
    return this.gwI;
  }
  
  public final String aqe()
  {
    if (this.gwJ == null) {
      return "";
    }
    return this.gwJ;
  }
  
  public final String aqf()
  {
    if (this.gwK == null) {
      return "";
    }
    return this.gwK;
  }
  
  public final void aqg()
  {
    this.gwL |= 0x1;
  }
  
  public final boolean aqh()
  {
    return (this.gwL & 0x1) == 0;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(108302);
    wW(paramCursor.getString(1));
    this.gwE = paramCursor.getString(2);
    this.gwF = paramCursor.getLong(3);
    this.ezj = paramCursor.getString(4);
    this.gwG = paramCursor.getString(5);
    this.gwH = paramCursor.getString(6);
    this.username = paramCursor.getString(7);
    this.blZ = paramCursor.getString(8);
    this.gwI = paramCursor.getString(9);
    this.gwJ = paramCursor.getString(10);
    this.type = paramCursor.getInt(11);
    this.gwK = paramCursor.getString(12);
    this.dqF = paramCursor.getString(13);
    int i = paramCursor.getInt(14);
    if (i == 65536) {}
    for (this.status = 0;; this.status = i)
    {
      this.gwL = paramCursor.getInt(17);
      this.fsf = paramCursor.getString(15);
      this.fsi = paramCursor.getInt(18);
      this.gwM = paramCursor.getBlob(19);
      if (!bo.ce(this.gwM)) {
        ag(this.gwM);
      }
      this.gwN = paramCursor.getInt(20);
      AppMethodBeat.o(108302);
      return;
    }
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(108304);
    ContentValues localContentValues = new ContentValues();
    if ((this.bsY & 0x1) != 0) {
      localContentValues.put("id", Integer.valueOf(this.id));
    }
    if ((this.bsY & 0x2) != 0) {
      localContentValues.put("md5", Al());
    }
    if ((this.bsY & 0x4) != 0) {
      localContentValues.put("peopleid", apY());
    }
    if ((this.bsY & 0x8) != 0) {
      localContentValues.put("uploadtime", Long.valueOf(this.gwF));
    }
    if ((this.bsY & 0x10) != 0) {
      localContentValues.put("realname", apZ());
    }
    if ((this.bsY & 0x20) != 0) {
      localContentValues.put("realnamepyinitial", aqa());
    }
    if ((this.bsY & 0x40) != 0) {
      localContentValues.put("realnamequanpin", aqb());
    }
    if ((this.bsY & 0x80) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.bsY & 0x100) != 0) {
      localContentValues.put("nickname", aqc());
    }
    if ((this.bsY & 0x200) != 0) {
      localContentValues.put("nicknamepyinitial", aqd());
    }
    if ((this.bsY & 0x400) != 0) {
      localContentValues.put("nicknamequanpin", aqe());
    }
    if ((this.bsY & 0x800) != 0) {
      localContentValues.put("type", Integer.valueOf(this.type));
    }
    if ((this.bsY & 0x1000) != 0) {
      localContentValues.put("moblie", aqf());
    }
    if ((this.bsY & 0x2000) != 0) {
      localContentValues.put("email", getEmail());
    }
    int i;
    if ((this.bsY & 0x4000) != 0)
    {
      i = this.status;
      if (i != 0) {
        break label489;
      }
      localContentValues.put("status", Integer.valueOf(65536));
    }
    for (;;)
    {
      if ((this.bsY & 0x8000) != 0) {
        localContentValues.put("reserved1", this.fsf);
      }
      if ((this.bsY & 0x20000) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.gwL));
      }
      if ((this.bsY & 0x40000) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.fsi));
      }
      if ((this.bsY & 0x80000) != 0)
      {
        this.gwM = apX();
        localContentValues.put("lvbuf", this.gwM);
      }
      if ((this.bsY & 0x100000) != 0) {
        localContentValues.put("showhead", Integer.valueOf(this.gwN));
      }
      AppMethodBeat.o(108304);
      return localContentValues;
      label489:
      localContentValues.put("status", Integer.valueOf(i));
    }
  }
  
  public final String getEmail()
  {
    if (this.dqF == null) {
      return "";
    }
    return this.dqF;
  }
  
  public final String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
  
  public final void wW(String paramString)
  {
    AppMethodBeat.i(108307);
    this.cqq = paramString;
    this.id = wV(paramString);
    AppMethodBeat.o(108307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.a
 * JD-Core Version:    0.7.0.1
 */