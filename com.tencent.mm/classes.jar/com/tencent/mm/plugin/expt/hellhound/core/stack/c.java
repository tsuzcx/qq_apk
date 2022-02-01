package com.tencent.mm.plugin.expt.hellhound.core.stack;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.bm;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static void a(bm parambm)
  {
    AppMethodBeat.i(121880);
    if (parambm == null)
    {
      AppMethodBeat.o(121880);
      return;
    }
    Object localObject = null;
    try
    {
      parambm = parambm.toByteArray();
      b.r("hell_astackd_mmkv_key", parambm);
      AppMethodBeat.o(121880);
      return;
    }
    catch (Exception parambm)
    {
      for (;;)
      {
        Log.printErrStackTrace("HABBYGE-MALI.ActivityStackDao", parambm, "ActivityStackDao write", new Object[0]);
        parambm = localObject;
      }
    }
  }
  
  public static bm dcC()
  {
    AppMethodBeat.i(121879);
    bm localbm2 = dcD();
    bm localbm1 = localbm2;
    if (localbm2 == null)
    {
      localbm1 = new bm();
      a(localbm1);
    }
    AppMethodBeat.o(121879);
    return localbm1;
  }
  
  private static bm dcD()
  {
    AppMethodBeat.i(121881);
    byte[] arrayOfByte = b.awZ("hell_astackd_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121881);
      return null;
    }
    bm localbm = new bm();
    try
    {
      localbm.parseFrom(arrayOfByte);
      AppMethodBeat.o(121881);
      return localbm;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.ActivityStackDao", localException, "ActivityStackDao read", new Object[0]);
      AppMethodBeat.o(121881);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.c
 * JD-Core Version:    0.7.0.1
 */