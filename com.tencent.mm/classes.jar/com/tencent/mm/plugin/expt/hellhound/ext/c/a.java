package com.tencent.mm.plugin.expt.hellhound.ext.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.cal;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public static void LR(int paramInt)
  {
    AppMethodBeat.i(122027);
    cal localcal2 = dLf();
    cal localcal1 = localcal2;
    if (localcal2 == null) {
      localcal1 = new cal();
    }
    localcal1.aajs = paramInt;
    a(localcal1);
    AppMethodBeat.o(122027);
  }
  
  static void a(cal paramcal)
  {
    AppMethodBeat.i(122028);
    try
    {
      b.u("hell_fntbck_pter_mmkv_key", paramcal.toByteArray());
      AppMethodBeat.o(122028);
      return;
    }
    catch (Exception paramcal)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FrontBackDao", paramcal, "writeBackFrontBack", new Object[0]);
      AppMethodBeat.o(122028);
    }
  }
  
  public static cal dLf()
  {
    AppMethodBeat.i(122029);
    byte[] arrayOfByte = b.ard("hell_fntbck_pter_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(122029);
      return null;
    }
    cal localcal = new cal();
    try
    {
      localcal.parseFrom(arrayOfByte);
      AppMethodBeat.o(122029);
      return localcal;
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
  
  public static void oV(boolean paramBoolean)
  {
    AppMethodBeat.i(122026);
    cal localcal2 = dLf();
    cal localcal1 = localcal2;
    if (localcal2 == null) {
      localcal1 = new cal();
    }
    localcal1.aajw = paramBoolean;
    Log.d("HABBYGE-MALI.FrontBackDao", "logout8EventFromAdd: %b", new Object[] { Boolean.valueOf(localcal1.aajw) });
    a(localcal1);
    AppMethodBeat.o(122026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.c.a
 * JD-Core Version:    0.7.0.1
 */