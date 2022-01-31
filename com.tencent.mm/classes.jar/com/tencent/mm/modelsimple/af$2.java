package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bk.a;
import com.tencent.mm.network.c;
import com.tencent.mm.network.e;
import com.tencent.mm.protocal.protobuf.gj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class af$2
  implements bk.a
{
  af$2(af paramaf, gj paramgj, byte[] paramArrayOfByte) {}
  
  public final void a(e parame)
  {
    AppMethodBeat.i(154516);
    if (parame == null)
    {
      ab.d("MicroMsg.NetsceneAxAuth", "dispatcher null");
      AppMethodBeat.o(154516);
      return;
    }
    if (parame.adI() == null)
    {
      ab.d("MicroMsg.NetsceneAxAuth", "getAccInfo null");
      AppMethodBeat.o(154516);
      return;
    }
    try
    {
      parame.adI().b(this.fQg.fQe, this.fQh.toByteArray(), this.fud);
      AppMethodBeat.o(154516);
      return;
    }
    catch (Exception parame)
    {
      ab.e("MicroMsg.NetsceneAxAuth", "exception:%s", new Object[] { bo.l(parame) });
      AppMethodBeat.o(154516);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelsimple.af.2
 * JD-Core Version:    0.7.0.1
 */