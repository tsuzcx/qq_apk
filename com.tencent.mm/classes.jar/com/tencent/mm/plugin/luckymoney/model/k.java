package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bvi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.IOException;

public final class k
  extends com.tencent.mm.wallet_core.c.a<bvi, d>
{
  private static k yUJ;
  
  public static k eeZ()
  {
    AppMethodBeat.i(65165);
    if (yUJ == null) {
      yUJ = new k();
    }
    k localk = yUJ;
    AppMethodBeat.o(65165);
    return localk;
  }
  
  private static bvi efa()
  {
    AppMethodBeat.i(65167);
    Object localObject = (String)g.aAh().azQ().get(ar.a.Ofg, "");
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(65167);
      return null;
    }
    localObject = ((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1);
    try
    {
      localObject = (bvi)new bvi().parseFrom((byte[])localObject);
      AppMethodBeat.o(65167);
      return localObject;
    }
    catch (IOException localIOException)
    {
      Log.printErrStackTrace("MicroMsg.GetShowSourceAsyncLoader", localIOException, "", new Object[0]);
      AppMethodBeat.o(65167);
    }
    return null;
  }
  
  public final void b(c.a<bvi> parama)
  {
    AppMethodBeat.i(182454);
    Log.i("MicroMsg.GetShowSourceAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if ((parama.errType == 0) && (parama.errCode == 0) && (((bvi)parama.iLC).dDN == 0)) {
      try
      {
        parama = new String(((bvi)parama.iLC).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
        g.aAh().azQ().set(ar.a.Ofg, parama);
        AppMethodBeat.o(182454);
        return;
      }
      catch (IOException parama)
      {
        Log.printErrStackTrace("MicroMsg.GetShowSourceAsyncLoader", parama, "", new Object[0]);
      }
    }
    AppMethodBeat.o(182454);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.k
 * JD-Core Version:    0.7.0.1
 */