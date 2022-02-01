package com.tencent.mm.plugin.expt.hellhound.a.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  static void a(bgb parambgb)
  {
    AppMethodBeat.i(122169);
    if (parambgb == null)
    {
      AppMethodBeat.o(122169);
      return;
    }
    b(parambgb);
    AppMethodBeat.o(122169);
  }
  
  private static void b(bgb parambgb)
  {
    AppMethodBeat.i(122171);
    try
    {
      b.o("mmkv_key_hell_PFLOW", parambgb.toByteArray());
      AppMethodBeat.o(122171);
      return;
    }
    catch (Exception parambgb)
    {
      ad.printErrStackTrace("HellPageFlowDao", parambgb, "HABBYGE-MALI, HellPageFlowDao.writeBack crash", new Object[0]);
      AppMethodBeat.o(122171);
    }
  }
  
  private static bgb cdA()
  {
    AppMethodBeat.i(122172);
    byte[] arrayOfByte = b.getBytes("mmkv_key_hell_PFLOW");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(122172);
      return null;
    }
    bgb localbgb = new bgb();
    try
    {
      localbgb.parseFrom(arrayOfByte);
      AppMethodBeat.o(122172);
      return localbgb;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("HellPageFlowDao", localException, "HABBYGE-MALI, HellPageFlowDao.read crash", new Object[0]);
      AppMethodBeat.o(122172);
    }
    return null;
  }
  
  public static bgb cdz()
  {
    AppMethodBeat.i(122170);
    bgb localbgb2 = cdA();
    bgb localbgb1 = localbgb2;
    if (localbgb2 == null)
    {
      localbgb1 = new bgb();
      b(localbgb1);
    }
    AppMethodBeat.o(122170);
    return localbgb1;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(122173);
    long l = System.currentTimeMillis();
    b.o("mmkv_key_hell_PFLOW", new byte[0]);
    ad.i("HellPageFlowDao", "HABBYGE-MALI, HellPageFlowDao-reset-time: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(122173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.d.a
 * JD-Core Version:    0.7.0.1
 */