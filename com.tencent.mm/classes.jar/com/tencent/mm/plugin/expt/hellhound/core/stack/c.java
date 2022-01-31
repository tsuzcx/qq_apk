package com.tencent.mm.plugin.expt.hellhound.core.stack;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.bf;
import com.tencent.mm.sdk.platformtools.ab;

public final class c
{
  public static void a(bf parambf)
  {
    AppMethodBeat.i(73360);
    if (parambf == null)
    {
      AppMethodBeat.o(73360);
      return;
    }
    Object localObject = null;
    try
    {
      parambf = parambf.toByteArray();
      b.v("hell_astackd_mmkv_key", parambf);
      AppMethodBeat.o(73360);
      return;
    }
    catch (Exception parambf)
    {
      for (;;)
      {
        ab.printErrStackTrace("ActivityStackDao", parambf, "ActivityStackDao write", new Object[0]);
        parambf = localObject;
      }
    }
  }
  
  public static bf brA()
  {
    AppMethodBeat.i(73359);
    bf localbf2 = brB();
    bf localbf1 = localbf2;
    if (localbf2 == null)
    {
      localbf1 = new bf();
      a(localbf1);
    }
    AppMethodBeat.o(73359);
    return localbf1;
  }
  
  private static bf brB()
  {
    AppMethodBeat.i(73361);
    byte[] arrayOfByte = b.getBytes("hell_astackd_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(73361);
      return null;
    }
    bf localbf = new bf();
    try
    {
      localbf.parseFrom(arrayOfByte);
      AppMethodBeat.o(73361);
      return localbf;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("ActivityStackDao", localException, "ActivityStackDao read", new Object[0]);
      AppMethodBeat.o(73361);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.stack.c
 * JD-Core Version:    0.7.0.1
 */