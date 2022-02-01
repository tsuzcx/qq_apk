package com.tencent.mm.plugin.expt.hellhound.core.stack;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.bi;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
{
  public static void a(bi parambi)
  {
    AppMethodBeat.i(121880);
    if (parambi == null)
    {
      AppMethodBeat.o(121880);
      return;
    }
    Object localObject = null;
    try
    {
      parambi = parambi.toByteArray();
      b.o("hell_astackd_mmkv_key", parambi);
      AppMethodBeat.o(121880);
      return;
    }
    catch (Exception parambi)
    {
      for (;;)
      {
        ad.printErrStackTrace("ActivityStackDao", parambi, "ActivityStackDao write", new Object[0]);
        parambi = localObject;
      }
    }
  }
  
  public static bi cbE()
  {
    AppMethodBeat.i(121879);
    bi localbi2 = cbF();
    bi localbi1 = localbi2;
    if (localbi2 == null)
    {
      localbi1 = new bi();
      a(localbi1);
    }
    AppMethodBeat.o(121879);
    return localbi1;
  }
  
  private static bi cbF()
  {
    AppMethodBeat.i(121881);
    byte[] arrayOfByte = b.getBytes("hell_astackd_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121881);
      return null;
    }
    bi localbi = new bi();
    try
    {
      localbi.parseFrom(arrayOfByte);
      AppMethodBeat.o(121881);
      return localbi;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("ActivityStackDao", localException, "ActivityStackDao read", new Object[0]);
      AppMethodBeat.o(121881);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.c
 * JD-Core Version:    0.7.0.1
 */