package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.a.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.protocal.protobuf.bjf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.io.IOException;

public final class g
  extends com.tencent.mm.wallet_core.c.a<bjf, c>
{
  private static g vzT;
  
  public static g dlf()
  {
    AppMethodBeat.i(65165);
    if (vzT == null) {
      vzT = new g();
    }
    g localg = vzT;
    AppMethodBeat.o(65165);
    return localg;
  }
  
  private static bjf dlg()
  {
    AppMethodBeat.i(65167);
    Object localObject = (String)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IWO, "");
    if (bu.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(65167);
      return null;
    }
    localObject = ((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1);
    try
    {
      localObject = (bjf)new bjf().parseFrom((byte[])localObject);
      AppMethodBeat.o(65167);
      return localObject;
    }
    catch (IOException localIOException)
    {
      ae.printErrStackTrace("MicroMsg.GetShowSourceAsyncLoader", localIOException, "", new Object[0]);
      AppMethodBeat.o(65167);
    }
    return null;
  }
  
  public final void c(a.a<bjf> parama)
  {
    AppMethodBeat.i(182454);
    ae.i("MicroMsg.GetShowSourceAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if ((parama.errType == 0) && (parama.errCode == 0) && (((bjf)parama.hQv).dmy == 0)) {
      try
      {
        parama = new String(((bjf)parama.hQv).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWO, parama);
        AppMethodBeat.o(182454);
        return;
      }
      catch (IOException parama)
      {
        ae.printErrStackTrace("MicroMsg.GetShowSourceAsyncLoader", parama, "", new Object[0]);
      }
    }
    AppMethodBeat.o(182454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.g
 * JD-Core Version:    0.7.0.1
 */