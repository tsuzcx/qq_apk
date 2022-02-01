package com.tencent.kinda.framework.module.impl;

import android.content.Context;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KCrtService;
import com.tencent.kinda.gen.KGenDigitalCrtReq;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.o;

public class KindaCrtServiceImpl
  implements KCrtService, f
{
  private final String TAG = "KindaCrtServiceImpl";
  private VoidStringCallback m_failCallback;
  private KGenDigitalCrtReq m_req;
  private VoidCallback m_successCallback;
  
  public void delCert()
  {
    AppMethodBeat.i(193159);
    ad.fVY();
    Object localObject = ad.getCrtNo();
    ae.i("KindaCrtServiceImpl", "do delete cert: %s", new Object[] { localObject });
    ad.fVY().bag((String)localObject);
    localObject = new o((String)localObject);
    com.tencent.mm.kernel.g.ajj().a((n)localObject, 0);
    AppMethodBeat.o(193159);
  }
  
  public String getCrtNo()
  {
    AppMethodBeat.i(18631);
    ad.fVY();
    String str = ad.getCrtNo();
    if (str.isEmpty())
    {
      ae.e("KindaCrtServiceImpl", "crt_no is empty.");
      AppMethodBeat.o(18631);
      return null;
    }
    Context localContext = KindaContext.get();
    if (localContext != null) {
      com.tencent.mm.wallet_core.c.b.fVM().init(localContext);
    }
    com.tencent.mm.wallet_core.c.b.fVM();
    if (!com.tencent.mm.wallet_core.c.b.isCertExist(str))
    {
      ae.e("KindaCrtServiceImpl", "crt_no is not exist.");
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
    ae.e("KindaCrtServiceImpl", "onSceneEnd. errCode: " + paramInt2 + " errMsg: " + paramString);
    if ((paramn instanceof NetSceneKindaGenDigitalCert))
    {
      ae.e("KindaCrtServiceImpl", "NetSceneKindaGenDigitalCert");
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
      com.tencent.mm.kernel.g.ajQ().gDv.b(1580, this);
      AppMethodBeat.o(18634);
      return;
      label89:
      ae.e("KindaCrtServiceImpl", "m_successCallback is null!!");
      continue;
      label99:
      if (this.m_failCallback != null) {
        this.m_failCallback.call(paramString);
      } else {
        ae.e("KindaCrtServiceImpl", "m_failCallback is null!!");
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
      com.tencent.mm.wallet_core.c.b.fVM().init(localContext);
    }
    com.tencent.mm.wallet_core.c.b.fVM();
    paramString = com.tencent.mm.wallet_core.c.b.genUserSig(paramString, paramArrayOfByte);
    if (bu.isNullOrNil(paramString))
    {
      paramArrayOfByte = com.tencent.mm.plugin.report.service.g.yxI;
      com.tencent.mm.wallet_core.c.b.fVM();
      paramArrayOfByte.f(20743, new Object[] { "user_identification", "pay_cert_sign", "", "", "", "", Integer.valueOf(com.tencent.mm.wallet_core.c.b.getLastError()) });
    }
    AppMethodBeat.o(18632);
    return paramString;
  }
  
  public void startGenDigitalCrtImpl(KGenDigitalCrtReq paramKGenDigitalCrtReq, VoidCallback paramVoidCallback, VoidStringCallback paramVoidStringCallback)
  {
    AppMethodBeat.i(18633);
    this.m_req = paramKGenDigitalCrtReq;
    this.m_successCallback = paramVoidCallback;
    this.m_failCallback = paramVoidStringCallback;
    com.tencent.mm.kernel.g.ajQ().gDv.a(1580, this);
    paramVoidCallback = new NetSceneKindaGenDigitalCert(paramKGenDigitalCrtReq);
    ae.i("KindaCrtServiceImpl", "The Param of startGenDigitalCrtImpl is: " + paramKGenDigitalCrtReq.toString());
    com.tencent.mm.kernel.g.ajj().a(paramVoidCallback, 0);
    AppMethodBeat.o(18633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaCrtServiceImpl
 * JD-Core Version:    0.7.0.1
 */