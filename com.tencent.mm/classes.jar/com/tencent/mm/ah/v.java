package com.tencent.mm.ah;

import android.os.Looper;
import com.tencent.mm.bv.b;
import com.tencent.mm.h.a.hj;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.adt;
import com.tencent.mm.protocal.c.azd;
import com.tencent.mm.protocal.c.bik;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bom;
import com.tencent.mm.protocal.c.bzo;
import com.tencent.mm.protocal.c.eq;
import com.tencent.mm.protocal.h.a;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.q.b;
import com.tencent.mm.protocal.u.b;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;

public final class v
  extends h.a
{
  private static a eel;
  private byte[] cbM;
  private k.e eek;
  private int type;
  
  public v(k.e parame, int paramInt)
  {
    this.eek = parame;
    this.type = paramInt;
  }
  
  public static void a(a parama)
  {
    eel = parama;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, PInt paramPInt, bly parambly)
  {
    PByteArray localPByteArray2 = new PByteArray();
    paramPInt.value = -1;
    PByteArray localPByteArray1 = new PByteArray();
    PInt localPInt1 = new PInt(0);
    PInt localPInt2 = new PInt(0);
    PInt localPInt3 = new PInt(255);
    try
    {
      boolean bool1 = MMProtocalJni.unpack(localPByteArray1, paramArrayOfByte1, paramArrayOfByte2, localPByteArray2, paramPInt, localPInt1, localPInt2, localPInt3);
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.RemoteResp", "bufToRespNoRSA unpack ret[%b], noticeid[%d], headExtFlags[%d]", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(localPInt2.value), Integer.valueOf(localPInt3.value) });
      if (localPInt2.value != 0)
      {
        paramArrayOfByte1 = new hj();
        paramArrayOfByte1.bPm.bPn = localPInt2.value;
        boolean bool2 = a.udP.m(paramArrayOfByte1);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.RemoteResp", "summerdiz bufToRespNoRSA publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(localPInt2.value), Boolean.valueOf(bool2) });
      }
      if (bool1)
      {
        if ((paramPInt.value == -13) || (paramPInt.value == -102) || (paramPInt.value == -3001))
        {
          com.tencent.mm.sdk.platformtools.y.e("MicroMsg.RemoteResp", "unpack failed. error:%d", new Object[] { Integer.valueOf(paramPInt.value) });
          return null;
        }
        int i = paramPInt.value;
        if (i == -3002)
        {
          try
          {
            paramArrayOfByte1 = new String(localPByteArray1.value);
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.RemoteResp", "bufToRespNoRSA -3002 ERR_IDCDISASTER, errStr:%s", new Object[] { paramArrayOfByte1 });
            new ah(Looper.getMainLooper()).post(new Runnable()
            {
              public final void run()
              {
                if ((!bk.bl(this.eem)) && (v.Ln() != null)) {
                  v.Ln().cv(this.eem);
                }
              }
            });
            return null;
          }
          catch (Exception paramArrayOfByte1)
          {
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.RemoteResp", "parse string err while MM_ERR_IDCDISASTER");
          }
        }
        else
        {
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.RemoteResp", "fuckwifi bufToRespNoRSA using protobuf ok jtype:%d enType:%d ", new Object[] { Integer.valueOf(110), Integer.valueOf(localPInt1.value) });
          parambly.aH(localPByteArray1.value);
          return localPByteArray1.value;
        }
      }
      else
      {
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.RemoteResp", "unpack failed.");
      }
    }
    catch (Exception paramArrayOfByte1)
    {
      com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.RemoteResp", paramArrayOfByte1, "parseFrom unbuild exception, check now!", new Object[0]);
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.RemoteResp", "exception:%s", new Object[] { bk.j(paramArrayOfByte1) });
    }
    return null;
  }
  
  public final int CK()
  {
    switch (this.type)
    {
    default: 
      return 0;
    case 701: 
    case 702: 
      return ((i.g)this.eek).spz.tPv.jwX;
    }
    return ((u.b)this.eek).sqm.jwX;
  }
  
  public final byte[] Dj()
  {
    switch (this.type)
    {
    default: 
      return new byte[0];
    case 701: 
    case 702: 
      return ((i.g)this.eek).eNt;
    }
    return ((u.b)this.eek).eNt;
  }
  
  public final byte[] KM()
  {
    return this.cbM;
  }
  
  public final byte[] KO()
  {
    switch (this.type)
    {
    default: 
      return new byte[0];
    case 701: 
    case 702: 
      return ((i.g)this.eek).spA;
    }
    return ((u.b)this.eek).spA;
  }
  
  public final int Lf()
  {
    return this.eek.spO;
  }
  
  public final String Lg()
  {
    return this.eek.spP;
  }
  
  public final int Lh()
  {
    return this.eek.spN;
  }
  
  public final byte[] Li()
  {
    switch (this.type)
    {
    }
    for (;;)
    {
      return new byte[0];
      if (((i.g)this.eek).spz.tPv.syi != null)
      {
        return ((i.g)this.eek).spz.tPv.syi.tFM.toByteArray();
        bom localbom = ((u.b)this.eek).sqm.tvn;
        if ((localbom != null) && (localbom.syi != null)) {
          return localbom.syi.tFM.toByteArray();
        }
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.RemoteResp", "summerauth MMFunc_NewReg SecAuthRegKeySect is null");
      }
    }
  }
  
  public final String Lj()
  {
    if (this.type == 381)
    {
      bik localbik = ((q.b)this.eek).sqf.tbP;
      if (localbik != null) {
        return bk.pm(localbik.tCA);
      }
    }
    return "";
  }
  
  public final String Lk()
  {
    if (this.type == 381)
    {
      bik localbik = ((q.b)this.eek).sqf.tbP;
      if (localbik != null) {
        return bk.pm(localbik.tCz);
      }
    }
    return "";
  }
  
  public final int Ll()
  {
    if (this.type == 381) {
      return ((q.b)this.eek).sqf.taV;
    }
    return 0;
  }
  
  public final String Lm()
  {
    switch (this.type)
    {
    default: 
      return "";
    case 701: 
    case 702: 
      return ((i.g)this.eek).eNw;
    }
    return ((u.b)this.eek).sqm.hPY;
  }
  
  public final boolean a(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    PByteArray localPByteArray1 = new PByteArray();
    if (!(this.eek instanceof k.c))
    {
      com.tencent.mm.sdk.platformtools.y.f("MicroMsg.RemoteResp", "all protocal should implemented with protobuf");
      return false;
    }
    PByteArray localPByteArray2 = new PByteArray();
    PInt localPInt2 = new PInt(0);
    k.c localc = (k.c)this.eek;
    PInt localPInt3 = new PInt(0);
    PInt localPInt1 = new PInt(0);
    PInt localPInt4 = new PInt(255);
    for (;;)
    {
      int i;
      try
      {
        if (localc.cpe())
        {
          paramInt = localc.A(paramArrayOfByte1);
          com.tencent.mm.sdk.platformtools.y.d("MicroMsg.RemoteResp", "rawData using protobuf ok");
          this.eek.spN = paramInt;
          if (bk.bl(ae.eSS)) {
            break;
          }
          this.eek.spP = ae.eSS;
          break;
        }
        boolean bool = MMProtocalJni.unpack(localPByteArray2, paramArrayOfByte1, paramArrayOfByte2, localPByteArray1, localPInt2, localPInt3, localPInt1, localPInt4);
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.RemoteResp", "bufToResp unpack ret[%b], jType[%d], noticeid[%d], headExtFlags[%d]", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt), Integer.valueOf(localPInt1.value), Integer.valueOf(localPInt4.value) });
        if (!bool) {
          break label811;
        }
        this.eek.spO = localPInt4.value;
        if ((paramInt != 701) && (paramInt != 702) && (10001 == ae.eSP) && (ae.eSQ > 0))
        {
          if (ae.eSQ == 2) {
            com.tencent.mm.protocal.y.K("", "", 0);
          }
          ae.eSQ = 0;
          localPInt2.value = -13;
          com.tencent.mm.sdk.platformtools.y.w("MicroMsg.RemoteResp", "dkcert dktest set session timeout once !");
        }
        if ((localPInt2.value == -13) || (localPInt2.value == -102) || (localPInt2.value == -3001) || (localPInt2.value == -3002) || (localPInt2.value == -3003))
        {
          this.eek.spN = localPInt2.value;
          i = localPInt2.value;
          if (i == -3002) {}
          try
          {
            this.eek.spP = new String(localPByteArray2.value);
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.RemoteResp", "jType [%d], ret value[%d], noticeId[%s], msg[%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localPInt2.value), localPInt1, this.eek.spP });
            this.eek.bufferSize = paramArrayOfByte1.length;
            this.cbM = localPByteArray1.value;
            if (!bk.bl(ae.eSS)) {
              this.eek.spP = ae.eSS;
            }
            if (localPInt1.value == 0) {
              break label835;
            }
            paramArrayOfByte1 = new hj();
            paramArrayOfByte1.bPm.bPn = localPInt1.value;
            if ((paramInt == 701) && (this.eek.spN == 0))
            {
              com.tencent.mm.sdk.platformtools.y.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent MMFunc_ManualAuth ok [%d]", new Object[] { Integer.valueOf(localPInt1.value) });
              paramArrayOfByte1.bPm.bPo = true;
            }
            bool = a.udP.m(paramArrayOfByte1);
            com.tencent.mm.sdk.platformtools.y.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(localPInt1.value), Boolean.valueOf(bool) });
            localPInt1.value = 0;
          }
          catch (Exception paramArrayOfByte2)
          {
            com.tencent.mm.sdk.platformtools.y.e("MicroMsg.RemoteResp", "parse string err while MM_ERR_IDCDISASTER");
            continue;
          }
        }
        i = localc.A(localPByteArray2.value);
      }
      catch (Exception paramArrayOfByte1)
      {
        com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.RemoteResp", paramArrayOfByte1, "from Protobuf unbuild exception, check now!", new Object[0]);
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.RemoteResp", "exception:%s", new Object[] { bk.j(paramArrayOfByte1) });
        if (localPInt1.value != 0)
        {
          paramArrayOfByte1 = new hj();
          paramArrayOfByte1.bPm.bPn = localPInt1.value;
          bool = a.udP.m(paramArrayOfByte1);
          com.tencent.mm.sdk.platformtools.y.i("MicroMsg.RemoteResp", "summerdiz publish GetDisasterInfoEvent noticeid[%d] publish[%b]", new Object[] { Integer.valueOf(localPInt1.value), Boolean.valueOf(bool) });
          localPInt1.value = 0;
        }
        return false;
      }
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.RemoteResp", "bufToResp using protobuf ok jType:%d, enType:%d errCode:%d, len:%d, headExtFlags:%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localPInt3.value), Integer.valueOf(i), Integer.valueOf(localPByteArray2.value.length), Integer.valueOf(this.eek.spO) });
      this.eek.spN = i;
      continue;
      label811:
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.RemoteResp", "unpack return false jType[%d]", new Object[] { Integer.valueOf(paramInt) });
    }
    return true;
    label835:
    return true;
  }
  
  public final int getCmdId()
  {
    return this.eek.getCmdId();
  }
  
  public final void ij(int paramInt)
  {
    this.eek.spN = paramInt;
  }
  
  public final void ky(String paramString)
  {
    this.eek.spP = paramString;
  }
  
  public static abstract interface a
  {
    public abstract void cv(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ah.v
 * JD-Core Version:    0.7.0.1
 */