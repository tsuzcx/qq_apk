package com.tencent.mm.plugin.expt.hellhound.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.bmr;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public static void KS(int paramInt)
  {
    AppMethodBeat.i(122027);
    bmr localbmr2 = deq();
    bmr localbmr1 = localbmr2;
    if (localbmr2 == null) {
      localbmr1 = new bmr();
    }
    localbmr1.SXy = paramInt;
    a(localbmr1);
    AppMethodBeat.o(122027);
  }
  
  static void a(bmr parambmr)
  {
    AppMethodBeat.i(122028);
    try
    {
      b.r("hell_fntbck_pter_mmkv_key", parambmr.toByteArray());
      AppMethodBeat.o(122028);
      return;
    }
    catch (Exception parambmr)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FrontBackDao", parambmr, "writeBackFrontBack", new Object[0]);
      AppMethodBeat.o(122028);
    }
  }
  
  public static bmr deq()
  {
    AppMethodBeat.i(122029);
    byte[] arrayOfByte = b.awZ("hell_fntbck_pter_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(122029);
      return null;
    }
    bmr localbmr = new bmr();
    try
    {
      localbmr.parseFrom(arrayOfByte);
      AppMethodBeat.o(122029);
      return localbmr;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("HABBYGE-MALI.FrontBackDao", localException, "_doReadFrontBack parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  public static void nv(boolean paramBoolean)
  {
    AppMethodBeat.i(122026);
    bmr localbmr2 = deq();
    bmr localbmr1 = localbmr2;
    if (localbmr2 == null) {
      localbmr1 = new bmr();
    }
    localbmr1.SXC = paramBoolean;
    Log.d("HABBYGE-MALI.FrontBackDao", "logout8EventFromAdd: %b", new Object[] { Boolean.valueOf(localbmr1.SXC) });
    a(localbmr1);
    AppMethodBeat.o(122026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.c.a
 * JD-Core Version:    0.7.0.1
 */