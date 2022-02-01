package com.tencent.kinda.framework.module.impl;

import android.content.Context;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KCrtService;
import com.tencent.kinda.gen.KGenDigitalCrtReq;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;

public class KindaCrtServiceImpl
  implements KCrtService, com.tencent.mm.al.g
{
  private final String TAG = "KindaCrtServiceImpl";
  private VoidStringCallback m_failCallback;
  private KGenDigitalCrtReq m_req;
  private VoidCallback m_successCallback;
  
  public String getCrtNo()
  {
    AppMethodBeat.i(18631);
    com.tencent.mm.wallet_core.c.ad.fkc();
    String str = com.tencent.mm.wallet_core.c.ad.getCrtNo();
    if (str.isEmpty())
    {
      com.tencent.mm.sdk.platformtools.ad.e("KindaCrtServiceImpl", "crt_no is empty.");
      AppMethodBeat.o(18631);
      return null;
    }
    Context localContext = KindaContext.get();
    if (localContext != null) {
      com.tencent.mm.wallet_core.c.b.fjR().init(localContext);
    }
    com.tencent.mm.wallet_core.c.b.fjR();
    if (!com.tencent.mm.wallet_core.c.b.isCertExist(str))
    {
      com.tencent.mm.sdk.platformtools.ad.e("KindaCrtServiceImpl", "crt_no is not exist.");
      AppMethodBeat.o(18631);
      return null;
    }
    AppMethodBeat.o(18631);
    return str;
  }
  
  public boolean hasCrt()
  {
    AppMethodBeat.i(18630);
    String str = getCrtNo();
    if ((str != null) && (!str.isEmpty()))
    {
      AppMethodBeat.o(18630);
      return true;
    }
    AppMethodBeat.o(18630);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(18634);
    com.tencent.mm.sdk.platformtools.ad.e("KindaCrtServiceImpl", "onSceneEnd. errCode: " + paramInt2 + " errMsg: " + paramString);
    if ((paramn instanceof NetSceneKindaGenDigitalCert))
    {
      com.tencent.mm.sdk.platformtools.ad.e("KindaCrtServiceImpl", "NetSceneKindaGenDigitalCert");
      if (paramInt2 != 0) {
        break label99;
      }
      if (this.m_successCallback == null) {
        break label89;
      }
      this.m_successCallback.call();
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.afA().gcy.b(1580, this);
      AppMethodBeat.o(18634);
      return;
      label89:
      com.tencent.mm.sdk.platformtools.ad.e("KindaCrtServiceImpl", "m_successCallback is null!!");
      continue;
      label99:
      if (this.m_failCallback != null) {
        this.m_failCallback.call(paramString);
      } else {
        com.tencent.mm.sdk.platformtools.ad.e("KindaCrtServiceImpl", "m_failCallback is null!!");
      }
    }
  }
  
  public String sign(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(18632);
    if ((paramString == null) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(18632);
      return null;
    }
    Context localContext = KindaContext.get();
    if (localContext != null) {
      com.tencent.mm.wallet_core.c.b.fjR().init(localContext);
    }
    com.tencent.mm.wallet_core.c.b.fjR();
    paramString = com.tencent.mm.wallet_core.c.b.genUserSig(paramString, paramArrayOfByte);
    AppMethodBeat.o(18632);
    return paramString;
  }
  
  public void startGenDigitalCrtImpl(KGenDigitalCrtReq paramKGenDigitalCrtReq, VoidCallback paramVoidCallback, VoidStringCallback paramVoidStringCallback)
  {
    AppMethodBeat.i(18633);
    this.m_req = paramKGenDigitalCrtReq;
    this.m_successCallback = paramVoidCallback;
    this.m_failCallback = paramVoidStringCallback;
    com.tencent.mm.kernel.g.afA().gcy.a(1580, this);
    paramVoidCallback = new NetSceneKindaGenDigitalCert(paramKGenDigitalCrtReq);
    com.tencent.mm.sdk.platformtools.ad.i("KindaCrtServiceImpl", "The Param of startGenDigitalCrtImpl is: " + paramKGenDigitalCrtReq.toString());
    com.tencent.mm.kernel.g.aeS().a(paramVoidCallback, 0);
    AppMethodBeat.o(18633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaCrtServiceImpl
 * JD-Core Version:    0.7.0.1
 */