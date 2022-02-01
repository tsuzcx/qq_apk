package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.csm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.io.IOException;

public final class l
  extends com.tencent.mm.wallet_core.model.a<csm, e>
{
  private static l Krt;
  
  public static l fWR()
  {
    AppMethodBeat.i(65165);
    if (Krt == null) {
      Krt = new l();
    }
    l locall = Krt;
    AppMethodBeat.o(65165);
    return locall;
  }
  
  public static csm fWS()
  {
    AppMethodBeat.i(65167);
    Object localObject = (String)h.baE().ban().get(at.a.acUX, "");
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(65167);
      return null;
    }
    localObject = ((String)localObject).getBytes(org.apache.commons.b.a.ISO_8859_1);
    try
    {
      localObject = (csm)new csm().parseFrom((byte[])localObject);
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
  
  public final void b(b.a<csm> parama)
  {
    AppMethodBeat.i(182454);
    Log.i("MicroMsg.GetShowSourceAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if ((parama.errType == 0) && (parama.errCode == 0) && (((csm)parama.ott).hAV == 0)) {
      try
      {
        parama = new String(((csm)parama.ott).toByteArray(), org.apache.commons.b.a.ISO_8859_1);
        h.baE().ban().set(at.a.acUX, parama);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.l
 * JD-Core Version:    0.7.0.1
 */