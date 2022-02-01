package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KOfflinePayService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.i;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;

public class KOfflinePayServiceImpl
  implements KOfflinePayService
{
  private static final String TAG = "KOfflinePayServiceImpl";
  
  public void cleanCftToken(String paramString)
  {
    AppMethodBeat.i(18361);
    com.tencent.mm.wallet_core.c.b.hhj();
    com.tencent.mm.wallet_core.c.b.clearToken(paramString);
    AppMethodBeat.o(18361);
  }
  
  public boolean deleteCftCert(String paramString)
  {
    AppMethodBeat.i(18362);
    com.tencent.mm.wallet_core.c.b.hhj();
    com.tencent.mm.wallet_core.c.b.clearCert(paramString);
    AppMethodBeat.o(18362);
    return true;
  }
  
  public String getCertid()
  {
    AppMethodBeat.i(18351);
    k.ezn();
    String str = k.TX(196617);
    AppMethodBeat.o(18351);
    return str;
  }
  
  public String getCftCSR(String paramString)
  {
    AppMethodBeat.i(18372);
    com.tencent.mm.wallet_core.c.b.hhj().hhk();
    com.tencent.mm.wallet_core.c.b localb = com.tencent.mm.wallet_core.c.b.hhj();
    com.tencent.mm.wallet_core.b.hgC();
    if (com.tencent.mm.wallet_core.b.hgE()) {}
    for (int i = 1;; i = 0)
    {
      paramString = localb.hr(paramString, i);
      AppMethodBeat.o(18372);
      return paramString;
    }
  }
  
  public String getCftCertSign(String paramString1, String paramString2)
  {
    AppMethodBeat.i(18360);
    com.tencent.mm.wallet_core.c.b.hhj();
    paramString1 = com.tencent.mm.wallet_core.c.b.genUserSig(paramString1, paramString2);
    AppMethodBeat.o(18360);
    return paramString1;
  }
  
  public String getCftToken(String paramString)
  {
    AppMethodBeat.i(18356);
    com.tencent.mm.wallet_core.c.b.hhj();
    paramString = com.tencent.mm.wallet_core.c.b.getToken(paramString);
    AppMethodBeat.o(18356);
    return paramString;
  }
  
  public String getCodever()
  {
    AppMethodBeat.i(18349);
    String str = g.aAh().azQ().get(ar.a.NSo, "");
    AppMethodBeat.o(18349);
    return str;
  }
  
  public String getDeviceid()
  {
    AppMethodBeat.i(18347);
    k.ezn();
    String str = k.TX(196628);
    AppMethodBeat.o(18347);
    return str;
  }
  
  public String getLastSelectedCardBindSerial()
  {
    AppMethodBeat.i(18354);
    String str = a.eAv();
    AppMethodBeat.o(18354);
    return str;
  }
  
  public long getLastTokenUpdateTs()
  {
    AppMethodBeat.i(18365);
    long l1 = 0L;
    try
    {
      long l2 = Long.valueOf(a.eAt()).longValue();
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
  
  public boolean getOfflinePayHasSuccess()
  {
    AppMethodBeat.i(18371);
    boolean bool = ((Boolean)g.aAh().azQ().get(ar.a.NYK, Boolean.FALSE)).booleanValue();
    AppMethodBeat.o(18371);
    return bool;
  }
  
  public ArrayList<ITransmitKvData> getPaymentCardList()
  {
    return null;
  }
  
  public int getRegetTokenNum()
  {
    AppMethodBeat.i(18369);
    int i = a.eAM();
    AppMethodBeat.o(18369);
    return i;
  }
  
  public int getRemainCftTokenNum(String paramString)
  {
    AppMethodBeat.i(18357);
    k.ezn();
    k.ezq();
    int i = i.ezm();
    AppMethodBeat.o(18357);
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
    int i = a.eAF();
    AppMethodBeat.o(18367);
    return i;
  }
  
  public boolean importCftCert(String paramString1, String paramString2)
  {
    AppMethodBeat.i(18373);
    boolean bool = com.tencent.mm.wallet_core.c.b.hhj().importCert(paramString1, paramString2);
    AppMethodBeat.o(18373);
    return bool;
  }
  
  public void removeCertid()
  {
    AppMethodBeat.i(18353);
    k.ezn();
    k.bN(196617, "");
    AppMethodBeat.o(18353);
  }
  
  public boolean setCertid(String paramString)
  {
    AppMethodBeat.i(18352);
    if (!com.tencent.matrix.trace.g.b.eP(paramString))
    {
      k.ezn();
      k.bN(196617, paramString);
      AppMethodBeat.o(18352);
      return true;
    }
    AppMethodBeat.o(18352);
    return false;
  }
  
  public boolean setCftTokenCode(String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(18363);
    com.tencent.mm.wallet_core.c.b.hhj();
    paramBoolean = com.tencent.mm.wallet_core.c.b.F(paramString2, paramString1, paramBoolean);
    AppMethodBeat.o(18363);
    return paramBoolean;
  }
  
  public boolean setCodever(String paramString)
  {
    AppMethodBeat.i(18350);
    if (!com.tencent.matrix.trace.g.b.eP(paramString))
    {
      g.aAh().azQ().set(ar.a.NSo, paramString);
      AppMethodBeat.o(18350);
      return true;
    }
    AppMethodBeat.o(18350);
    return false;
  }
  
  public boolean setDeviceid(String paramString)
  {
    AppMethodBeat.i(18348);
    if (!com.tencent.matrix.trace.g.b.eP(paramString))
    {
      k.ezn();
      k.bN(196628, paramString);
      AppMethodBeat.o(18348);
      return true;
    }
    AppMethodBeat.o(18348);
    return false;
  }
  
  public void setLastSelectedCardBindSerial(String paramString)
  {
    AppMethodBeat.i(18355);
    a.aJk(paramString);
    AppMethodBeat.o(18355);
  }
  
  public void setLastTokenUpdateTs(long paramLong)
  {
    AppMethodBeat.i(18364);
    k.ezn();
    k.bN(196632, String.valueOf(paramLong));
    AppMethodBeat.o(18364);
  }
  
  public void setOfflinePayHasSuccess()
  {
    AppMethodBeat.i(18370);
    g.aAh().azQ().set(ar.a.NYK, Boolean.TRUE);
    AppMethodBeat.o(18370);
  }
  
  public void setRegetTokenNum(int paramInt)
  {
    AppMethodBeat.i(18368);
    a.Uh(paramInt);
    AppMethodBeat.o(18368);
  }
  
  public boolean setTokenPin(String paramString)
  {
    AppMethodBeat.i(18359);
    if (!com.tencent.matrix.trace.g.b.eP(paramString))
    {
      k.ezn();
      k.bN(196647, paramString);
      AppMethodBeat.o(18359);
      return true;
    }
    AppMethodBeat.o(18359);
    return false;
  }
  
  public void setTokenUpdateInterval(int paramInt)
  {
    AppMethodBeat.i(18366);
    k.ezn();
    k.bN(196649, String.valueOf(paramInt));
    AppMethodBeat.o(18366);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KOfflinePayServiceImpl
 * JD-Core Version:    0.7.0.1
 */