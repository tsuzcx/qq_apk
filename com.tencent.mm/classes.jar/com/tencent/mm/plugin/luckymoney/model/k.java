package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.cda;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.io.IOException;

public final class k
  extends com.tencent.mm.wallet_core.c.a<cda, d>
{
  private static k EyG;
  
  public static k eOu()
  {
    AppMethodBeat.i(65165);
    if (EyG == null) {
      EyG = new k();
    }
    k localk = EyG;
    AppMethodBeat.o(65165);
    return localk;
  }
  
  public static cda eOv()
  {
    AppMethodBeat.i(65167);
    Object localObject = (String)h.aHG().aHp().get(ar.a.Vts, "");
    if (Util.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(65167);
      return null;
    }
    localObject = ((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1);
    try
    {
      localObject = (cda)new cda().parseFrom((byte[])localObject);
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
  
  public final void b(c.a<cda> parama)
  {
    AppMethodBeat.i(182454);
    Log.i("MicroMsg.GetShowSourceAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if ((parama.errType == 0) && (parama.errCode == 0) && (((cda)parama.lBJ).fwx == 0)) {
      try
      {
        parama = new String(((cda)parama.lBJ).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
        h.aHG().aHp().set(ar.a.Vts, parama);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.k
 * JD-Core Version:    0.7.0.1
 */