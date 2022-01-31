package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.aqa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.io.IOException;

public final class f
  extends com.tencent.mm.wallet_core.c.a<aqa, c>
{
  private static f onc;
  
  public static f bNf()
  {
    AppMethodBeat.i(42274);
    if (onc == null) {
      onc = new f();
    }
    f localf = onc;
    AppMethodBeat.o(42274);
    return localf;
  }
  
  private static aqa bNg()
  {
    AppMethodBeat.i(42276);
    Object localObject = (String)g.RL().Ru().get(ac.a.yJg, "");
    if (bo.isNullOrNil((String)localObject))
    {
      AppMethodBeat.o(42276);
      return null;
    }
    localObject = ((String)localObject).getBytes(org.apache.commons.a.a.ISO_8859_1);
    try
    {
      localObject = (aqa)new aqa().parseFrom((byte[])localObject);
      AppMethodBeat.o(42276);
      return localObject;
    }
    catch (IOException localIOException)
    {
      ab.printErrStackTrace("MicroMsg.GetShowSourceAsyncLoader", localIOException, "", new Object[0]);
      AppMethodBeat.o(42276);
    }
    return null;
  }
  
  public final void e(a.a<aqa> parama)
  {
    AppMethodBeat.i(42275);
    ab.i("MicroMsg.GetShowSourceAsyncLoader", "errType: %s, errCode: %s", new Object[] { Integer.valueOf(parama.errCode), Integer.valueOf(parama.errType) });
    if ((parama.errType == 0) && (parama.errCode == 0) && (((aqa)parama.fsN).cnK == 0)) {
      try
      {
        parama = new String(((aqa)parama.fsN).toByteArray(), org.apache.commons.a.a.ISO_8859_1);
        g.RL().Ru().set(ac.a.yJg, parama);
        AppMethodBeat.o(42275);
        return;
      }
      catch (IOException parama)
      {
        ab.printErrStackTrace("MicroMsg.GetShowSourceAsyncLoader", parama, "", new Object[0]);
      }
    }
    AppMethodBeat.o(42275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.f
 * JD-Core Version:    0.7.0.1
 */