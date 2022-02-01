package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.KOfflinePayService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

public class KOfflinePayServiceImpl
  implements KOfflinePayService
{
  private static final String TAG = "KOfflinePayServiceImpl";
  
  public void cleanCftToken(String paramString)
  {
    AppMethodBeat.i(18361);
    com.tencent.mm.wallet_core.c.b.iiL();
    com.tencent.mm.wallet_core.c.b.clearToken(paramString);
    AppMethodBeat.o(18361);
  }
  
  public String decryptByCftCert(String paramString1, String paramString2)
  {
    return null;
  }
  
  public byte[] decryptBySM4(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    return new byte[0];
  }
  
  public boolean deleteCftCert(String paramString)
  {
    AppMethodBeat.i(18362);
    com.tencent.mm.wallet_core.c.b.iiL();
    com.tencent.mm.wallet_core.c.b.clearCert(paramString);
    AppMethodBeat.o(18362);
    return true;
  }
  
  public String getCertid()
  {
    AppMethodBeat.i(18351);
    k.fkT();
    String str = k.aaK(196617);
    AppMethodBeat.o(18351);
    return str;
  }
  
  public String getCftCSR(String paramString)
  {
    AppMethodBeat.i(18372);
    com.tencent.mm.wallet_core.c.b.iiL().iiM();
    com.tencent.mm.wallet_core.c.b localb = com.tencent.mm.wallet_core.c.b.iiL();
    com.tencent.mm.wallet_core.b.iie();
    if (com.tencent.mm.wallet_core.b.iig()) {}
    for (int i = 1;; i = 0)
    {
      paramString = localb.ia(paramString, i);
      AppMethodBeat.o(18372);
      return paramString;
    }
  }
  
  public String getCftCertSign(String paramString1, String paramString2)
  {
    AppMethodBeat.i(18360);
    com.tencent.mm.wallet_core.c.b.iiL();
    paramString1 = com.tencent.mm.wallet_core.c.b.genUserSig(paramString1, paramString2);
    AppMethodBeat.o(18360);
    return paramString1;
  }
  
  public String getCodever()
  {
    AppMethodBeat.i(18349);
    String str = h.aHG().aHp().get(ar.a.Vgm, "");
    AppMethodBeat.o(18349);
    return str;
  }
  
  public String getDeviceid()
  {
    AppMethodBeat.i(18347);
    k.fkT();
    String str = k.aaK(196628);
    AppMethodBeat.o(18347);
    return str;
  }
  
  public String getLastSelectedCardBindSerial()
  {
    AppMethodBeat.i(18354);
    String str = a.flZ();
    AppMethodBeat.o(18354);
    return str;
  }
  
  public long getLastTokenUpdateTs()
  {
    AppMethodBeat.i(18365);
    long l1 = 0L;
    try
    {
      long l2 = Long.valueOf(a.flX()).longValue();
      l1 = l2;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label20:
      break label20;
    }
    AppMethodBeat.o(18365);
    return l1;
  }
  
  public String getOfflinePayAckKey()
  {
    return null;
  }
  
  public boolean getOfflinePayHasSuccess()
  {
    AppMethodBeat.i(18371);
    boolean bool = ((Boolean)h.aHG().aHp().get(ar.a.VmK, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(18371);
    return bool;
  }
  
  public int getRegetTokenNum()
  {
    AppMethodBeat.i(18369);
    int i = a.fmq();
    AppMethodBeat.o(18369);
    return i;
  }
  
  public String getTokenPin()
  {
    AppMethodBeat.i(18358);
    String str = a.getTokenPin();
    AppMethodBeat.o(18358);
    return str;
  }
  
  public int getTokenUpdateInterval()
  {
    AppMethodBeat.i(18367);
    int i = a.fmj();
    AppMethodBeat.o(18367);
    return i;
  }
  
  public boolean importCftCert(String paramString1, String paramString2)
  {
    AppMethodBeat.i(18373);
    boolean bool = com.tencent.mm.wallet_core.c.b.iiL().importCert(paramString1, paramString2);
    AppMethodBeat.o(18373);
    return bool;
  }
  
  public void removeCertid()
  {
    AppMethodBeat.i(18353);
    k.fkT();
    k.bL(196617, "");
    AppMethodBeat.o(18353);
  }
  
  public boolean setCertid(String paramString)
  {
    AppMethodBeat.i(18352);
    if (!com.tencent.matrix.trace.g.b.fK(paramString))
    {
      k.fkT();
      k.bL(196617, paramString);
      AppMethodBeat.o(18352);
      return true;
    }
    AppMethodBeat.o(18352);
    return false;
  }
  
  public boolean setCftTokenCode(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(18363);
    com.tencent.mm.wallet_core.c.b.iiL();
    paramBoolean = com.tencent.mm.wallet_core.c.b.I(paramString2, paramString1, paramBoolean);
    AppMethodBeat.o(18363);
    return paramBoolean;
  }
  
  public boolean setCodever(String paramString)
  {
    AppMethodBeat.i(18350);
    if (!com.tencent.matrix.trace.g.b.fK(paramString))
    {
      h.aHG().aHp().set(ar.a.Vgm, paramString);
      AppMethodBeat.o(18350);
      return true;
    }
    AppMethodBeat.o(18350);
    return false;
  }
  
  public boolean setDeviceid(String paramString)
  {
    AppMethodBeat.i(18348);
    if (!com.tencent.matrix.trace.g.b.fK(paramString))
    {
      k.fkT();
      k.bL(196628, paramString);
      AppMethodBeat.o(18348);
      return true;
    }
    AppMethodBeat.o(18348);
    return false;
  }
  
  public void setLastSelectedCardBindSerial(String paramString)
  {
    AppMethodBeat.i(18355);
    a.aTG(paramString);
    AppMethodBeat.o(18355);
  }
  
  public void setLastTokenUpdateTs(long paramLong)
  {
    AppMethodBeat.i(18364);
    k.fkT();
    k.bL(196632, String.valueOf(paramLong));
    AppMethodBeat.o(18364);
  }
  
  public void setOfflinePayAckKey(String paramString) {}
  
  public void setOfflinePayHasSuccess()
  {
    AppMethodBeat.i(18370);
    h.aHG().aHp().set(ar.a.VmK, Boolean.TRUE);
    AppMethodBeat.o(18370);
  }
  
  public void setOfflineStateClose() {}
  
  public void setOfflineStateOpen() {}
  
  public void setRegetTokenNum(int paramInt)
  {
    AppMethodBeat.i(18368);
    a.aaS(paramInt);
    AppMethodBeat.o(18368);
  }
  
  public boolean setTokenPin(String paramString)
  {
    AppMethodBeat.i(18359);
    if (!com.tencent.matrix.trace.g.b.fK(paramString))
    {
      k.fkT();
      k.bL(196647, paramString);
      AppMethodBeat.o(18359);
      return true;
    }
    AppMethodBeat.o(18359);
    return false;
  }
  
  public void setTokenUpdateInterval(int paramInt)
  {
    AppMethodBeat.i(18366);
    k.fkT();
    k.bL(196649, String.valueOf(paramInt));
    AppMethodBeat.o(18366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KOfflinePayServiceImpl
 * JD-Core Version:    0.7.0.1
 */