package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.c.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.io.IOException;

public final class g
  extends com.tencent.mm.wallet_core.c.a<bap, c>
{
  private static g tcT;
  
  public static g cLo()
  {
    AppMethodBeat.i(65165);
    if (tcT == null) {
      tcT = new g();
    }
    g localg = tcT;
    AppMethodBeat.o(65165);
    return localg;
  }
  
  private static bap cLp()
  {
    AppMethodBeat.i(65167);
    Object localObject = (String)com.tencent.mm.kernel.g.afB().afk().get(ae.a.Fse, "");
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(65167);
      return null;
    }
    localObject = ((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1);
    try
    {
      localObject = (bap)new bap().parseFrom((byte[])localObject);
      AppMethodBeat.o(65167);
      return localObject;
    }
    catch (IOException localIOException)
    {
      ad.printErrStackTrace("MicroMsg.GetShowSourceAsyncLoader", localIOException, "", new Object[0]);
      AppMethodBeat.o(65167);
    }
    return null;
  }
  
  public final void c(c.a<bap> parama)
  {
    AppMethodBeat.i(182454);
    ad.i("MicroMsg.GetShowSourceAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if ((parama.errType == 0) && (parama.errCode == 0) && (((bap)parama.gUK).dcG == 0)) {
      try
      {
        parama = new String(((bap)parama.gUK).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
        com.tencent.mm.kernel.g.afB().afk().set(ae.a.Fse, parama);
        AppMethodBeat.o(182454);
        return;
      }
      catch (IOException parama)
      {
        ad.printErrStackTrace("MicroMsg.GetShowSourceAsyncLoader", parama, "", new Object[0]);
      }
    }
    AppMethodBeat.o(182454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.g
 * JD-Core Version:    0.7.0.1
 */