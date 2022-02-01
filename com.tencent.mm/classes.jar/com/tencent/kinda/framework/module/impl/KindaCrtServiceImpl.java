package com.tencent.kinda.framework.module.impl;

import android.content.Context;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KCrtService;
import com.tencent.kinda.gen.KGenDigitalCrtReq;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.c.ad;
import com.tencent.mm.wallet_core.c.o;

public class KindaCrtServiceImpl
  implements KCrtService, i
{
  private final String TAG = "KindaCrtServiceImpl";
  private VoidStringCallback m_failCallback;
  private KGenDigitalCrtReq m_req;
  private VoidCallback m_successCallback;
  
  public void delCert()
  {
    AppMethodBeat.i(214450);
    ad.hhv();
    Object localObject = ad.getCrtNo();
    Log.i("KindaCrtServiceImpl", "do delete cert: %s", new Object[] { localObject });
    ad.hhv().bpo((String)localObject);
    localObject = new o((String)localObject);
    g.azz().a((q)localObject, 0);
    AppMethodBeat.o(214450);
  }
  
  public String getCrtNo()
  {
    AppMethodBeat.i(18631);
    ad.hhv();
    String str = ad.getCrtNo();
    if (str.isEmpty())
    {
      Log.e("KindaCrtServiceImpl", "crt_no is empty.");
      AppMethodBeat.o(18631);
      return null;
    }
    Context localContext = KindaContext.get();
    if (localContext != null) {
      com.tencent.mm.wallet_core.c.b.hhj().init(localContext);
    }
    com.tencent.mm.wallet_core.c.b.hhj();
    if (!com.tencent.mm.wallet_core.c.b.isCertExist(str))
    {
      Log.e("KindaCrtServiceImpl", "crt_no is not exist.");
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(18634);
    Log.e("KindaCrtServiceImpl", "onSceneEnd. errCode: " + paramInt2 + " errMsg: " + paramString);
    if ((paramq instanceof NetSceneKindaGenDigitalCert))
    {
      Log.e("KindaCrtServiceImpl", "NetSceneKindaGenDigitalCert");
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
      g.aAg().hqi.b(1580, this);
      AppMethodBeat.o(18634);
      return;
      label89:
      Log.e("KindaCrtServiceImpl", "m_successCallback is null!!");
      continue;
      label99:
      if (this.m_failCallback != null) {
        this.m_failCallback.call(paramString);
      } else {
        Log.e("KindaCrtServiceImpl", "m_failCallback is null!!");
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
      com.tencent.mm.wallet_core.c.b.hhj().init(localContext);
    }
    com.tencent.mm.wallet_core.c.b.hhj();
    paramString = com.tencent.mm.wallet_core.c.b.genUserSig(paramString, paramArrayOfByte);
    if (Util.isNullOrNil(paramString))
    {
      paramArrayOfByte = h.CyF;
      com.tencent.mm.wallet_core.c.b.hhj();
      paramArrayOfByte.a(20743, new Object[] { "user_identification", "pay_cert_sign", "", "", "", "", Integer.valueOf(com.tencent.mm.wallet_core.c.b.getLastError()) });
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
    g.aAg().hqi.a(1580, this);
    paramVoidCallback = new NetSceneKindaGenDigitalCert(paramKGenDigitalCrtReq);
    Log.i("KindaCrtServiceImpl", "The Param of startGenDigitalCrtImpl is: " + paramKGenDigitalCrtReq.toString());
    g.azz().a(paramVoidCallback, 0);
    AppMethodBeat.o(18633);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaCrtServiceImpl
 * JD-Core Version:    0.7.0.1
 */