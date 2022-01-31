package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class af
  implements f
{
  c dZC;
  
  public af()
  {
    AppMethodBeat.i(19410);
    this.dZC = new af.1(this);
    a.ymk.c(this.dZC);
    AppMethodBeat.o(19410);
  }
  
  private static void aD(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(19412);
    ab.i("MicroMsg.WearHardDeviceLogic", "publish auth response deviceId=%s | isSuccess=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    vx localvx = new vx();
    localvx.cNm.coO = 8;
    localvx.cNm.csk = paramBoolean;
    localvx.cNm.bYu = paramString;
    a.ymk.l(localvx);
    AppMethodBeat.o(19412);
  }
  
  private static void aE(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(19413);
    ab.i("MicroMsg.WearHardDeviceLogic", "publish send response deviceId=%s | isSuccess=%b", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
    vx localvx = new vx();
    localvx.cNm.coO = 5;
    localvx.cNm.csk = paramBoolean;
    localvx.cNm.bYu = paramString;
    a.ymk.l(localvx);
    AppMethodBeat.o(19413);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(19411);
    if ((paramm instanceof r))
    {
      aw.Rc().b(541, this);
      paramString = (r)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        aD(paramString.lFw, true);
        AppMethodBeat.o(19411);
        return;
      }
      aD(paramString.lFw, false);
      AppMethodBeat.o(19411);
      return;
    }
    if ((paramm instanceof w))
    {
      aw.Rc().b(538, this);
      paramString = (w)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        aE(paramString.lFy, true);
        AppMethodBeat.o(19411);
        return;
      }
      aE(paramString.lFy, false);
    }
    AppMethodBeat.o(19411);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.af
 * JD-Core Version:    0.7.0.1
 */