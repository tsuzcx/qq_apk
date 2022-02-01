package com.tencent.mm.plugin.expt.hellhound.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  public static void Di(int paramInt)
  {
    AppMethodBeat.i(122027);
    atr localatr2 = cpm();
    atr localatr1 = localatr2;
    if (localatr2 == null) {
      localatr1 = new atr();
    }
    localatr1.GrF = paramInt;
    a(localatr1);
    AppMethodBeat.o(122027);
  }
  
  static void a(atr paramatr)
  {
    AppMethodBeat.i(122028);
    try
    {
      b.p("hell_fntbck_pter_mmkv_key", paramatr.toByteArray());
      AppMethodBeat.o(122028);
      return;
    }
    catch (Exception paramatr)
    {
      ad.printErrStackTrace("HABBYGE-MALI.FrontBackDao", paramatr, "writeBackFrontBack", new Object[0]);
      AppMethodBeat.o(122028);
    }
  }
  
  public static atr cpm()
  {
    AppMethodBeat.i(122029);
    byte[] arrayOfByte = b.getBytes("hell_fntbck_pter_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(122029);
      return null;
    }
    atr localatr = new atr();
    try
    {
      localatr.parseFrom(arrayOfByte);
      AppMethodBeat.o(122029);
      return localatr;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("HABBYGE-MALI.FrontBackDao", localException, "_doReadFrontBack parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  public static void la(boolean paramBoolean)
  {
    AppMethodBeat.i(122026);
    atr localatr2 = cpm();
    atr localatr1 = localatr2;
    if (localatr2 == null) {
      localatr1 = new atr();
    }
    localatr1.GrJ = paramBoolean;
    ad.d("HABBYGE-MALI.FrontBackDao", "logout8EventFromAdd: %b", new Object[] { Boolean.valueOf(localatr1.GrJ) });
    a(localatr1);
    AppMethodBeat.o(122026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.c.a
 * JD-Core Version:    0.7.0.1
 */