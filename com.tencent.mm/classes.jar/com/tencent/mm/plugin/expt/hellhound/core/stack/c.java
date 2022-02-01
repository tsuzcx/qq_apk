package com.tencent.mm.plugin.expt.hellhound.core.stack;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.bu;
import com.tencent.mm.sdk.platformtools.Log;

public final class c
{
  public static void a(bu parambu)
  {
    AppMethodBeat.i(121880);
    if (parambu == null)
    {
      AppMethodBeat.o(121880);
      return;
    }
    Object localObject = null;
    try
    {
      parambu = parambu.toByteArray();
      b.u("hell_astackd_mmkv_key", parambu);
      AppMethodBeat.o(121880);
      return;
    }
    catch (Exception parambu)
    {
      for (;;)
      {
        Log.printErrStackTrace("HABBYGE-MALI.ActivityStackDao", parambu, "ActivityStackDao write", new Object[0]);
        parambu = localObject;
      }
    }
  }
  
  public static bu dJe()
  {
    AppMethodBeat.i(121879);
    bu localbu2 = dJf();
    bu localbu1 = localbu2;
    if (localbu2 == null)
    {
      localbu1 = new bu();
      a(localbu1);
    }
    AppMethodBeat.o(121879);
    return localbu1;
  }
  
  private static bu dJf()
  {
    AppMethodBeat.i(121881);
    byte[] arrayOfByte = b.ard("hell_astackd_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121881);
      return null;
    }
    bu localbu = new bu();
    try
    {
      localbu.parseFrom(arrayOfByte);
      AppMethodBeat.o(121881);
      return localbu;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.ActivityStackDao", localException, "ActivityStackDao read", new Object[0]);
      AppMethodBeat.o(121881);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.c
 * JD-Core Version:    0.7.0.1
 */