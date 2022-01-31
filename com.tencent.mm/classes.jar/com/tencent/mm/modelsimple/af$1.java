package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class af$1
  implements bk.a
{
  af$1(af paramaf) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(154515);
    if (parame == null)
    {
      ab.d("MicroMsg.NetsceneAxAuth", "dispatcher null");
      AppMethodBeat.o(154515);
      return;
    }
    if (parame.adI() == null)
    {
      ab.d("MicroMsg.NetsceneAxAuth", "getAccInfo null");
      AppMethodBeat.o(154515);
      return;
    }
    try
    {
      parame = parame.adI();
      int i = parame.getUin();
      parame.a(new byte[0], new byte[0], new byte[0], i);
      parame.adG();
      AppMethodBeat.o(154515);
      return;
    }
    catch (Exception parame)
    {
      ab.e("MicroMsg.NetsceneAxAuth", "exception:%s", new Object[] { bo.l(parame) });
      AppMethodBeat.o(154515);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelsimple.af.1
 * JD-Core Version:    0.7.0.1
 */