package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.protocal.protobuf.beh;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.io.IOException;

public final class g
  extends com.tencent.mm.wallet_core.c.a<beh, c>
{
  private static g uli;
  
  public static g cYU()
  {
    AppMethodBeat.i(65165);
    if (uli == null) {
      uli = new g();
    }
    g localg = uli;
    AppMethodBeat.o(65165);
    return localg;
  }
  
  private static beh cYV()
  {
    AppMethodBeat.i(65167);
    Object localObject = (String)com.tencent.mm.kernel.g.agR().agA().get(ah.a.GPV, "");
    if (bs.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(65167);
      return null;
    }
    localObject = ((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1);
    try
    {
      localObject = (beh)new beh().parseFrom((byte[])localObject);
      AppMethodBeat.o(65167);
      return localObject;
    }
    catch (IOException localIOException)
    {
      ac.printErrStackTrace("MicroMsg.GetShowSourceAsyncLoader", localIOException, "", new Object[0]);
      AppMethodBeat.o(65167);
    }
    return null;
  }
  
  public final void c(c.a<beh> parama)
  {
    AppMethodBeat.i(182454);
    ac.i("MicroMsg.GetShowSourceAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if ((parama.errType == 0) && (parama.errCode == 0) && (((beh)parama.hvj).dae == 0)) {
      try
      {
        parama = new String(((beh)parama.hvj).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
        com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPV, parama);
        AppMethodBeat.o(182454);
        return;
      }
      catch (IOException parama)
      {
        ac.printErrStackTrace("MicroMsg.GetShowSourceAsyncLoader", parama, "", new Object[0]);
      }
    }
    AppMethodBeat.o(182454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.g
 * JD-Core Version:    0.7.0.1
 */