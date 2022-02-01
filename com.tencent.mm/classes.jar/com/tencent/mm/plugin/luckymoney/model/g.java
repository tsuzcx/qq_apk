package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.a.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import java.io.IOException;

public final class g
  extends com.tencent.mm.wallet_core.c.a<bip, c>
{
  private static g vnO;
  
  public static g dig()
  {
    AppMethodBeat.i(65165);
    if (vnO == null) {
      vnO = new g();
    }
    g localg = vnO;
    AppMethodBeat.o(65165);
    return localg;
  }
  
  private static bip dih()
  {
    AppMethodBeat.i(65167);
    Object localObject = (String)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICp, "");
    if (bt.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(65167);
      return null;
    }
    localObject = ((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1);
    try
    {
      localObject = (bip)new bip().parseFrom((byte[])localObject);
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
  
  public final void c(a.a<bip> parama)
  {
    AppMethodBeat.i(182454);
    ad.i("MicroMsg.GetShowSourceAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if ((parama.errType == 0) && (parama.errCode == 0) && (((bip)parama.hNC).dlw == 0)) {
      try
      {
        parama = new String(((bip)parama.hNC).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICp, parama);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.g
 * JD-Core Version:    0.7.0.1
 */