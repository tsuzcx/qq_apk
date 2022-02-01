package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.KOfflinePayService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.f.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.offline.c.d;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tenpay.android.wechat.TenpayUtil;

public class KOfflinePayServiceImpl
  implements KOfflinePayService
{
  private static final String TAG = "KOfflinePayServiceImpl";
  
  public void cleanCftToken(String paramString)
  {
    AppMethodBeat.i(18361);
    com.tencent.mm.wallet_core.model.b.jOG();
    com.tencent.mm.wallet_core.model.b.clearToken(paramString);
    AppMethodBeat.o(18361);
  }
  
  public String decryptByCftCert(String paramString1, String paramString2)
  {
    AppMethodBeat.i(226488);
    com.tencent.mm.wallet_core.model.b.jOG();
    paramString1 = com.tencent.mm.wallet_core.model.b.decrypt(paramString1, paramString2);
    AppMethodBeat.o(226488);
    return paramString1;
  }
  
  public byte[] decryptBySM4(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    AppMethodBeat.i(226501);
    paramArrayOfByte1 = TenpayUtil.sm4DecryptCBC(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3);
    AppMethodBeat.o(226501);
    return paramArrayOfByte1;
  }
  
  public boolean deleteCftCert(String paramString)
  {
    AppMethodBeat.i(18362);
    com.tencent.mm.wallet_core.model.b.jOG();
    com.tencent.mm.wallet_core.model.b.clearCert(paramString);
    AppMethodBeat.o(18362);
    return true;
  }
  
  public String getCertid()
  {
    AppMethodBeat.i(18351);
    k.gvj();
    String str = k.afd(196617);
    AppMethodBeat.o(18351);
    return str;
  }
  
  public String getCftCSR(String paramString)
  {
    AppMethodBeat.i(18372);
    com.tencent.mm.wallet_core.model.b.jOG().jOH();
    com.tencent.mm.wallet_core.model.b localb = com.tencent.mm.wallet_core.model.b.jOG();
    com.tencent.mm.wallet_core.b.jNX();
    if (com.tencent.mm.wallet_core.b.jNZ()) {}
    for (int i = 1;; i = 0)
    {
      paramString = localb.jm(paramString, i);
      AppMethodBeat.o(18372);
      return paramString;
    }
  }
  
  public String getCftCertSign(String paramString1, String paramString2)
  {
    AppMethodBeat.i(18360);
    com.tencent.mm.wallet_core.model.b.jOG();
    paramString1 = com.tencent.mm.wallet_core.model.b.genUserSig(paramString1, paramString2);
    AppMethodBeat.o(18360);
    return paramString1;
  }
  
  public String getCodever()
  {
    AppMethodBeat.i(18349);
    String str = h.baE().ban().get(at.a.acHB, "");
    AppMethodBeat.o(18349);
    return str;
  }
  
  public String getDeviceid()
  {
    AppMethodBeat.i(18347);
    k.gvj();
    String str = k.afd(196628);
    AppMethodBeat.o(18347);
    return str;
  }
  
  public String getLastSelectedCardBindSerial()
  {
    AppMethodBeat.i(18354);
    String str = d.gwL();
    AppMethodBeat.o(18354);
    return str;
  }
  
  public long getLastTokenUpdateTs()
  {
    AppMethodBeat.i(18365);
    long l1 = 0L;
    try
    {
      long l2 = Long.valueOf(d.gwJ()).longValue();
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
    AppMethodBeat.i(226498);
    String str = d.gwY();
    AppMethodBeat.o(226498);
    return str;
  }
  
  public boolean getOfflinePayHasSuccess()
  {
    AppMethodBeat.i(18371);
    boolean bool = ((Boolean)h.baE().ban().get(at.a.acOf, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(18371);
    return bool;
  }
  
  public int getRegetTokenNum()
  {
    AppMethodBeat.i(18369);
    int i = d.gxd();
    AppMethodBeat.o(18369);
    return i;
  }
  
  public String getTokenPin()
  {
    AppMethodBeat.i(18358);
    String str = d.getTokenPin();
    AppMethodBeat.o(18358);
    return str;
  }
  
  public int getTokenUpdateInterval()
  {
    AppMethodBeat.i(18367);
    int i = d.gwV();
    AppMethodBeat.o(18367);
    return i;
  }
  
  public boolean importCftCert(String paramString1, String paramString2)
  {
    AppMethodBeat.i(18373);
    boolean bool = com.tencent.mm.wallet_core.model.b.jOG().importCert(paramString1, paramString2);
    AppMethodBeat.o(18373);
    return bool;
  }
  
  public void removeCertid()
  {
    AppMethodBeat.i(18353);
    k.gvj();
    k.ct(196617, "");
    AppMethodBeat.o(18353);
  }
  
  public boolean setCertid(String paramString)
  {
    AppMethodBeat.i(18352);
    if (!c.hm(paramString))
    {
      k.gvj();
      k.ct(196617, paramString);
      AppMethodBeat.o(18352);
      return true;
    }
    AppMethodBeat.o(18352);
    return false;
  }
  
  public boolean setCftTokenCode(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(18363);
    com.tencent.mm.wallet_core.model.b.jOG();
    paramBoolean = com.tencent.mm.wallet_core.model.b.P(paramString2, paramString1, paramBoolean);
    AppMethodBeat.o(18363);
    return paramBoolean;
  }
  
  public boolean setCodever(String paramString)
  {
    AppMethodBeat.i(18350);
    if (!c.hm(paramString))
    {
      h.baE().ban().set(at.a.acHB, paramString);
      AppMethodBeat.o(18350);
      return true;
    }
    AppMethodBeat.o(18350);
    return false;
  }
  
  public boolean setDeviceid(String paramString)
  {
    AppMethodBeat.i(18348);
    if (!c.hm(paramString))
    {
      k.gvj();
      k.ct(196628, paramString);
      AppMethodBeat.o(18348);
      return true;
    }
    AppMethodBeat.o(18348);
    return false;
  }
  
  public void setLastSelectedCardBindSerial(String paramString)
  {
    AppMethodBeat.i(18355);
    d.aQL(paramString);
    AppMethodBeat.o(18355);
  }
  
  public void setLastTokenUpdateTs(long paramLong)
  {
    AppMethodBeat.i(18364);
    k.gvj();
    k.ct(196632, String.valueOf(paramLong));
    AppMethodBeat.o(18364);
  }
  
  public void setOfflinePayAckKey(String paramString)
  {
    AppMethodBeat.i(226496);
    if (paramString != null) {}
    for (;;)
    {
      d.aQT(paramString);
      AppMethodBeat.o(226496);
      return;
      paramString = "";
    }
  }
  
  public void setOfflinePayHasSuccess()
  {
    AppMethodBeat.i(18370);
    h.baE().ban().set(at.a.acOf, Boolean.TRUE);
    AppMethodBeat.o(18370);
  }
  
  public void setOfflineStateClose()
  {
    AppMethodBeat.i(226492);
    k.gvj();
    k.ct(196630, "0");
    AppMethodBeat.o(226492);
  }
  
  public void setOfflineStateOpen()
  {
    AppMethodBeat.i(226489);
    k.gvj();
    k.ct(196630, "1");
    AppMethodBeat.o(226489);
  }
  
  public void setRegetTokenNum(int paramInt)
  {
    AppMethodBeat.i(18368);
    d.afk(paramInt);
    AppMethodBeat.o(18368);
  }
  
  public boolean setTokenPin(String paramString)
  {
    AppMethodBeat.i(18359);
    if (!c.hm(paramString))
    {
      k.gvj();
      k.ct(196647, paramString);
      AppMethodBeat.o(18359);
      return true;
    }
    AppMethodBeat.o(18359);
    return false;
  }
  
  public void setTokenUpdateInterval(int paramInt)
  {
    AppMethodBeat.i(18366);
    k.gvj();
    k.ct(196649, String.valueOf(paramInt));
    AppMethodBeat.o(18366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KOfflinePayServiceImpl
 * JD-Core Version:    0.7.0.1
 */