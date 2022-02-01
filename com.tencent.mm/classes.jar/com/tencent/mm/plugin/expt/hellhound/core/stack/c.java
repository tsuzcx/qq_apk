package com.tencent.mm.plugin.expt.hellhound.core.stack;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.bo;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static void a(bo parambo)
  {
    AppMethodBeat.i(121880);
    if (parambo == null)
    {
      AppMethodBeat.o(121880);
      return;
    }
    Object localObject = null;
    try
    {
      parambo = parambo.toByteArray();
      b.o("hell_astackd_mmkv_key", parambo);
      AppMethodBeat.o(121880);
      return;
    }
    catch (Exception parambo)
    {
      for (;;)
      {
        Log.printErrStackTrace("HABBYGE-MALI.ActivityStackDao", parambo, "ActivityStackDao write", new Object[0]);
        parambo = localObject;
      }
    }
  }
  
  public static bo cNK()
  {
    AppMethodBeat.i(121879);
    bo localbo2 = cNL();
    bo localbo1 = localbo2;
    if (localbo2 == null)
    {
      localbo1 = new bo();
      a(localbo1);
    }
    AppMethodBeat.o(121879);
    return localbo1;
  }
  
  private static bo cNL()
  {
    AppMethodBeat.i(121881);
    byte[] arrayOfByte = b.getBytes("hell_astackd_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121881);
      return null;
    }
    bo localbo = new bo();
    try
    {
      localbo.parseFrom(arrayOfByte);
      AppMethodBeat.o(121881);
      return localbo;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.ActivityStackDao", localException, "ActivityStackDao read", new Object[0]);
      AppMethodBeat.o(121881);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.c
 * JD-Core Version:    0.7.0.1
 */