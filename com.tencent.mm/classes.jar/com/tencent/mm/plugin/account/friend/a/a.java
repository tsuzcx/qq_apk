package com.tencent.mm.plugin.account.friend.a;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  String aVr = "";
  private String bIW = "";
  public int bcw = -1;
  public String cCt = "";
  public String dBS = "";
  public String ebN = "";
  public int ebQ = 0;
  public String feW = "";
  long feX = 0L;
  public String feY = "";
  public String feZ = "";
  String ffa = "";
  String ffb = "";
  public String ffc = "";
  public int ffd = 0;
  public byte[] ffe;
  public int fff;
  public String ffg = "";
  public int ffh = 0;
  public String ffi = "";
  public String ffj = "";
  public String ffk = "";
  int ffl = 0;
  public String ffm = "";
  int ffn = 0;
  int ffo = 0;
  String ffp = "";
  public String ffq = "";
  String ffr = "";
  int ffs = -1;
  String fft = "";
  long ffu = -1L;
  int ffv = -1;
  String ffw = "";
  String ffx = "";
  String ffy = "";
  public long ffz = 0L;
  private int id = 0;
  public int status = 0;
  public int type = 0;
  public String username = "";
  
  private byte[] Wu()
  {
    try
    {
      Object localObject = new v();
      ((v)localObject).cqy();
      ((v)localObject).Zg(this.ffg);
      ((v)localObject).Fb(this.ffh);
      ((v)localObject).Zg(this.ffi);
      ((v)localObject).Zg(this.ffj);
      ((v)localObject).Zg(this.ffk);
      ((v)localObject).Fb(this.ffl);
      ((v)localObject).Zg(this.ffm);
      ((v)localObject).Fb(this.ffn);
      ((v)localObject).Fb(this.ffo);
      ((v)localObject).Zg(this.ffp);
      ((v)localObject).Zg(this.ffq);
      ((v)localObject).Zg(this.ffr);
      ((v)localObject).Fb(this.ffs);
      ((v)localObject).Zg(this.fft);
      ((v)localObject).ho(this.ffu);
      ((v)localObject).Fb(this.ffv);
      ((v)localObject).Zg(this.ffw);
      ((v)localObject).Zg(this.ffx);
      ((v)localObject).Zg(this.ffy);
      ((v)localObject).ho(this.ffz);
      localObject = ((v)localObject).cqz();
      return localObject;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.AddrUpload", localException, "", new Object[0]);
    }
    return null;
  }
  
  public static int pF(String paramString)
  {
    try
    {
      int i = bk.ZJ("0x" + paramString.substring(0, 8));
      return i;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.AddrUpload", localException, "md5: %s", new Object[] { paramString });
    }
    return 0;
  }
  
  public final int AE()
  {
    int i = 32;
    int j;
    if (!bk.bl(Wy()))
    {
      i = Wy().charAt(0);
      if ((i < 97) || (i > 122)) {
        break label64;
      }
      j = (char)(i - 32);
    }
    label64:
    do
    {
      return j;
      if (bk.bl(Wz())) {
        break;
      }
      i = Wz().charAt(0);
      break;
      if (i < 65) {
        break label78;
      }
      j = i;
    } while (i <= 90);
    label78:
    return 123;
  }
  
  public final String WA()
  {
    if (this.aVr == null) {
      return "";
    }
    return this.aVr;
  }
  
  public final String WB()
  {
    if (this.ffa == null) {
      return "";
    }
    return this.ffa;
  }
  
  public final String WC()
  {
    if (this.ffb == null) {
      return "";
    }
    return this.ffb;
  }
  
  public final String WD()
  {
    if (this.ffc == null) {
      return "";
    }
    return this.ffc;
  }
  
  public final void WE()
  {
    this.ffd |= 0x1;
  }
  
  public final boolean WF()
  {
    return (this.ffd & 0x1) == 0;
  }
  
  public final String Wv()
  {
    if (this.bIW == null) {
      return "";
    }
    return this.bIW;
  }
  
  public final String Ww()
  {
    if (this.feW == null) {
      return "";
    }
    return this.feW;
  }
  
  public final String Wx()
  {
    if (this.dBS == null) {
      return "";
    }
    return this.dBS;
  }
  
  public final String Wy()
  {
    if (this.feY == null) {
      return "";
    }
    return this.feY;
  }
  
  public final String Wz()
  {
    if (this.feZ == null) {
      return "";
    }
    return this.feZ;
  }
  
  public final void d(Cursor paramCursor)
  {
    pG(paramCursor.getString(1));
    this.feW = paramCursor.getString(2);
    this.feX = paramCursor.getLong(3);
    this.dBS = paramCursor.getString(4);
    this.feY = paramCursor.getString(5);
    this.feZ = paramCursor.getString(6);
    this.username = paramCursor.getString(7);
    this.aVr = paramCursor.getString(8);
    this.ffa = paramCursor.getString(9);
    this.ffb = paramCursor.getString(10);
    this.type = paramCursor.getInt(11);
    this.ffc = paramCursor.getString(12);
    this.cCt = paramCursor.getString(13);
    int i = paramCursor.getInt(14);
    byte[] arrayOfByte;
    if (i == 65536)
    {
      this.status = 0;
      this.ffd = paramCursor.getInt(17);
      this.ebN = paramCursor.getString(15);
      this.ebQ = paramCursor.getInt(18);
      this.ffe = paramCursor.getBlob(19);
      if (!bk.bE(this.ffe)) {
        arrayOfByte = this.ffe;
      }
    }
    for (;;)
    {
      try
      {
        localv = new v();
        i = localv.bA(arrayOfByte);
        if (i == 0) {
          continue;
        }
        y.e("MicroMsg.AddrUpload", "parse LVBuffer error:" + i);
      }
      catch (Exception localException)
      {
        v localv;
        y.printErrStackTrace("MicroMsg.AddrUpload", localException, "", new Object[0]);
        continue;
      }
      this.fff = paramCursor.getInt(20);
      return;
      this.status = i;
      break;
      this.ffg = localv.getString();
      this.ffh = localv.getInt();
      this.ffi = localv.getString();
      this.ffj = localv.getString();
      this.ffk = localv.getString();
      this.ffl = localv.getInt();
      this.ffm = localv.getString();
      this.ffn = localv.getInt();
      this.ffo = localv.getInt();
      this.ffp = localv.getString();
      this.ffq = localv.getString();
      this.ffr = localv.getString();
      this.ffs = localv.getInt();
      this.fft = localv.getString();
      this.ffu = localv.getLong();
      this.ffv = localv.getInt();
      this.ffw = localv.getString();
      this.ffx = localv.getString();
      this.ffy = localv.getString();
      this.ffz = localv.getLong();
    }
  }
  
  public final String getEmail()
  {
    if (this.cCt == null) {
      return "";
    }
    return this.cCt;
  }
  
  public final String getUsername()
  {
    if (this.username == null) {
      return "";
    }
    return this.username;
  }
  
  public final void pG(String paramString)
  {
    this.bIW = paramString;
    this.id = pF(paramString);
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if ((this.bcw & 0x1) != 0) {
      localContentValues.put("id", Integer.valueOf(this.id));
    }
    if ((this.bcw & 0x2) != 0) {
      localContentValues.put("md5", Wv());
    }
    if ((this.bcw & 0x4) != 0) {
      localContentValues.put("peopleid", Ww());
    }
    if ((this.bcw & 0x8) != 0) {
      localContentValues.put("uploadtime", Long.valueOf(this.feX));
    }
    if ((this.bcw & 0x10) != 0) {
      localContentValues.put("realname", Wx());
    }
    if ((this.bcw & 0x20) != 0) {
      localContentValues.put("realnamepyinitial", Wy());
    }
    if ((this.bcw & 0x40) != 0) {
      localContentValues.put("realnamequanpin", Wz());
    }
    if ((this.bcw & 0x80) != 0) {
      localContentValues.put("username", getUsername());
    }
    if ((this.bcw & 0x100) != 0) {
      localContentValues.put("nickname", WA());
    }
    if ((this.bcw & 0x200) != 0) {
      localContentValues.put("nicknamepyinitial", WB());
    }
    if ((this.bcw & 0x400) != 0) {
      localContentValues.put("nicknamequanpin", WC());
    }
    if ((this.bcw & 0x800) != 0) {
      localContentValues.put("type", Integer.valueOf(this.type));
    }
    if ((this.bcw & 0x1000) != 0) {
      localContentValues.put("moblie", WD());
    }
    if ((this.bcw & 0x2000) != 0) {
      localContentValues.put("email", getEmail());
    }
    int i;
    if ((this.bcw & 0x4000) != 0)
    {
      i = this.status;
      if (i != 0) {
        break label476;
      }
      localContentValues.put("status", Integer.valueOf(65536));
    }
    for (;;)
    {
      if ((this.bcw & 0x8000) != 0) {
        localContentValues.put("reserved1", this.ebN);
      }
      if ((this.bcw & 0x20000) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.ffd));
      }
      if ((this.bcw & 0x40000) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.ebQ));
      }
      if ((this.bcw & 0x80000) != 0)
      {
        this.ffe = Wu();
        localContentValues.put("lvbuf", this.ffe);
      }
      if ((this.bcw & 0x100000) != 0) {
        localContentValues.put("showhead", Integer.valueOf(this.fff));
      }
      return localContentValues;
      label476:
      localContentValues.put("status", Integer.valueOf(i));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.a
 * JD-Core Version:    0.7.0.1
 */