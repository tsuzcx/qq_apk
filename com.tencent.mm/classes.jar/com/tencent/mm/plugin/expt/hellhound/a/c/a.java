package com.tencent.mm.plugin.expt.hellhound.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.bfq;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public static void Hi(int paramInt)
  {
    AppMethodBeat.i(122027);
    bfq localbfq2 = cPw();
    bfq localbfq1 = localbfq2;
    if (localbfq2 == null) {
      localbfq1 = new bfq();
    }
    localbfq1.LPh = paramInt;
    a(localbfq1);
    AppMethodBeat.o(122027);
  }
  
  static void a(bfq parambfq)
  {
    AppMethodBeat.i(122028);
    try
    {
      b.o("hell_fntbck_pter_mmkv_key", parambfq.toByteArray());
      AppMethodBeat.o(122028);
      return;
    }
    catch (Exception parambfq)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FrontBackDao", parambfq, "writeBackFrontBack", new Object[0]);
      AppMethodBeat.o(122028);
    }
  }
  
  public static bfq cPw()
  {
    AppMethodBeat.i(122029);
    byte[] arrayOfByte = b.getBytes("hell_fntbck_pter_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(122029);
      return null;
    }
    bfq localbfq = new bfq();
    try
    {
      localbfq.parseFrom(arrayOfByte);
      AppMethodBeat.o(122029);
      return localbfq;
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
  
  public static void mi(boolean paramBoolean)
  {
    AppMethodBeat.i(122026);
    bfq localbfq2 = cPw();
    bfq localbfq1 = localbfq2;
    if (localbfq2 == null) {
      localbfq1 = new bfq();
    }
    localbfq1.LPl = paramBoolean;
    Log.d("HABBYGE-MALI.FrontBackDao", "logout8EventFromAdd: %b", new Object[] { Boolean.valueOf(localbfq1.LPl) });
    a(localbfq1);
    AppMethodBeat.o(122026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.c.a
 * JD-Core Version:    0.7.0.1
 */