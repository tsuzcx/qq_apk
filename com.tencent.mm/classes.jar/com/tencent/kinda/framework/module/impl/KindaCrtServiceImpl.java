package com.tencent.kinda.framework.module.impl;

import android.content.Context;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.KCrtService;
import com.tencent.kinda.gen.KGenDigitalCrtReq;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.wallet_core.c.ab;
import org.xwalk.core.Log;

public class KindaCrtServiceImpl
  implements KCrtService, f
{
  private final String TAG = "KindaCrtServiceImpl";
  private VoidStringCallback m_failCallback;
  private KGenDigitalCrtReq m_req;
  private VoidCallback m_successCallback;
  
  public String getCrtNo()
  {
    AppMethodBeat.i(144517);
    ab.dSv();
    String str = ab.getCrtNo();
    if (str.isEmpty())
    {
      Log.e("KindaCrtServiceImpl", "crt_no is empty.");
      AppMethodBeat.o(144517);
      return null;
    }
    Context localContext = KindaContext.get();
    if (localContext != null) {
      com.tencent.mm.wallet_core.c.b.dSi().init(localContext);
    }
    com.tencent.mm.wallet_core.c.b.dSi();
    if (!com.tencent.mm.wallet_core.c.b.isCertExist(str))
    {
      Log.e("KindaCrtServiceImpl", "crt_no is not exist.");
      AppMethodBeat.o(144517);
      return null;
    }
    AppMethodBeat.o(144517);
    return str;
  }
  
  public boolean hasCrt()
  {
    AppMethodBeat.i(144516);
    String str = getCrtNo();
    if ((str != null) && (!str.isEmpty()))
    {
      AppMethodBeat.o(144516);
      return true;
    }
    AppMethodBeat.o(144516);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(144520);
    Log.e("KindaCrtServiceImpl", "onSceneEnd. errCode: " + paramInt2 + " errMsg: " + paramString);
    if ((paramm instanceof NetSceneKindaGenDigitalCert))
    {
      Log.e("KindaCrtServiceImpl", "NetSceneKindaGenDigitalCert");
      g.RK().eHt.b(1580, this);
    }
    AppMethodBeat.o(144520);
  }
  
  public String sign(String paramString, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(144518);
    if ((paramString == null) || (paramArrayOfByte == null))
    {
      AppMethodBeat.o(144518);
      return null;
    }
    Context localContext = KindaContext.get();
    if (localContext != null) {
      com.tencent.mm.wallet_core.c.b.dSi().init(localContext);
    }
    com.tencent.mm.wallet_core.c.b.dSi();
    paramString = com.tencent.mm.wallet_core.c.b.genUserSig(paramString, paramArrayOfByte);
    AppMethodBeat.o(144518);
    return paramString;
  }
  
  public void startGenDigitalCrtImpl(KGenDigitalCrtReq paramKGenDigitalCrtReq, VoidCallback paramVoidCallback, VoidStringCallback paramVoidStringCallback)
  {
    AppMethodBeat.i(144519);
    this.m_req = paramKGenDigitalCrtReq;
    this.m_successCallback = paramVoidCallback;
    this.m_failCallback = paramVoidStringCallback;
    g.RK().eHt.a(1580, this);
    paramKGenDigitalCrtReq = new NetSceneKindaGenDigitalCert(paramKGenDigitalCrtReq, paramVoidCallback, paramVoidStringCallback);
    g.Rc().a(paramKGenDigitalCrtReq, 0);
    AppMethodBeat.o(144519);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaCrtServiceImpl
 * JD-Core Version:    0.7.0.1
 */