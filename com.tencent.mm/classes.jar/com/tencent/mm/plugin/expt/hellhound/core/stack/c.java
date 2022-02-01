package com.tencent.mm.plugin.expt.hellhound.core.stack;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.bk;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
{
  public static void a(bk parambk)
  {
    AppMethodBeat.i(121880);
    if (parambk == null)
    {
      AppMethodBeat.o(121880);
      return;
    }
    Object localObject = null;
    try
    {
      parambk = parambk.toByteArray();
      b.p("hell_astackd_mmkv_key", parambk);
      AppMethodBeat.o(121880);
      return;
    }
    catch (Exception parambk)
    {
      for (;;)
      {
        ad.printErrStackTrace("HABBYGE-MALI.ActivityStackDao", parambk, "ActivityStackDao write", new Object[0]);
        parambk = localObject;
      }
    }
  }
  
  public static bk cnP()
  {
    AppMethodBeat.i(121879);
    bk localbk2 = cnQ();
    bk localbk1 = localbk2;
    if (localbk2 == null)
    {
      localbk1 = new bk();
      a(localbk1);
    }
    AppMethodBeat.o(121879);
    return localbk1;
  }
  
  private static bk cnQ()
  {
    AppMethodBeat.i(121881);
    byte[] arrayOfByte = b.getBytes("hell_astackd_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121881);
      return null;
    }
    bk localbk = new bk();
    try
    {
      localbk.parseFrom(arrayOfByte);
      AppMethodBeat.o(121881);
      return localbk;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("HABBYGE-MALI.ActivityStackDao", localException, "ActivityStackDao read", new Object[0]);
      AppMethodBeat.o(121881);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.c
 * JD-Core Version:    0.7.0.1
 */