package com.tencent.mm.plugin.expt.hellhound.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
{
  public static void Dv(int paramInt)
  {
    AppMethodBeat.i(122027);
    auh localauh2 = cqO();
    auh localauh1 = localauh2;
    if (localauh2 == null) {
      localauh1 = new auh();
    }
    localauh1.GLd = paramInt;
    a(localauh1);
    AppMethodBeat.o(122027);
  }
  
  static void a(auh paramauh)
  {
    AppMethodBeat.i(122028);
    try
    {
      b.p("hell_fntbck_pter_mmkv_key", paramauh.toByteArray());
      AppMethodBeat.o(122028);
      return;
    }
    catch (Exception paramauh)
    {
      ae.printErrStackTrace("HABBYGE-MALI.FrontBackDao", paramauh, "writeBackFrontBack", new Object[0]);
      AppMethodBeat.o(122028);
    }
  }
  
  public static auh cqO()
  {
    AppMethodBeat.i(122029);
    byte[] arrayOfByte = b.getBytes("hell_fntbck_pter_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(122029);
      return null;
    }
    auh localauh = new auh();
    try
    {
      localauh.parseFrom(arrayOfByte);
      AppMethodBeat.o(122029);
      return localauh;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("HABBYGE-MALI.FrontBackDao", localException, "_doReadFrontBack parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  public static void la(boolean paramBoolean)
  {
    AppMethodBeat.i(122026);
    auh localauh2 = cqO();
    auh localauh1 = localauh2;
    if (localauh2 == null) {
      localauh1 = new auh();
    }
    localauh1.GLh = paramBoolean;
    ae.d("HABBYGE-MALI.FrontBackDao", "logout8EventFromAdd: %b", new Object[] { Boolean.valueOf(localauh1.GLh) });
    a(localauh1);
    AppMethodBeat.o(122026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.c.a
 * JD-Core Version:    0.7.0.1
 */