package com.tencent.mm.plugin.expt.hellhound.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  public static void BB(int paramInt)
  {
    AppMethodBeat.i(122027);
    amt localamt2 = ccp();
    amt localamt1 = localamt2;
    if (localamt2 == null) {
      localamt1 = new amt();
    }
    localamt1.DnN = paramInt;
    a(localamt1);
    AppMethodBeat.o(122027);
  }
  
  static void a(amt paramamt)
  {
    AppMethodBeat.i(122028);
    try
    {
      b.o("hell_fntbck_pter_mmkv_key", paramamt.toByteArray());
      AppMethodBeat.o(122028);
      return;
    }
    catch (Exception paramamt)
    {
      ad.printErrStackTrace("FrontBackDao", paramamt, "habbyge-mali, writeBackFrontBack", new Object[0]);
      AppMethodBeat.o(122028);
    }
  }
  
  public static amt ccp()
  {
    AppMethodBeat.i(122029);
    byte[] arrayOfByte = b.getBytes("hell_fntbck_pter_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(122029);
      return null;
    }
    amt localamt = new amt();
    try
    {
      localamt.parseFrom(arrayOfByte);
      AppMethodBeat.o(122029);
      return localamt;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("FrontBackDao", localException, "habbyge-mali, _doReadFrontBack parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  public static void ke(boolean paramBoolean)
  {
    AppMethodBeat.i(122026);
    amt localamt2 = ccp();
    amt localamt1 = localamt2;
    if (localamt2 == null) {
      localamt1 = new amt();
    }
    localamt1.DnS = paramBoolean;
    ad.d("FrontBackDao", "habbyge-mali, logout8EventFromAdd: %b", new Object[] { Boolean.valueOf(localamt1.DnS) });
    a(localamt1);
    AppMethodBeat.o(122026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.c.a
 * JD-Core Version:    0.7.0.1
 */