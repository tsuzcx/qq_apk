package com.tencent.mm.plugin.expt.hellhound.a.f.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
{
  static void a(bjt parambjt)
  {
    AppMethodBeat.i(122169);
    if (parambjt == null)
    {
      AppMethodBeat.o(122169);
      return;
    }
    b(parambjt);
    AppMethodBeat.o(122169);
  }
  
  private static void b(bjt parambjt)
  {
    AppMethodBeat.i(122171);
    try
    {
      b.o("mmkv_key_hell_PFLOW", parambjt.toByteArray());
      AppMethodBeat.o(122171);
      return;
    }
    catch (Exception parambjt)
    {
      ac.printErrStackTrace("HellPageFlowDao", parambjt, "HABBYGE-MALI, HellPageFlowDao.writeBack crash", new Object[0]);
      AppMethodBeat.o(122171);
    }
  }
  
  public static bjt clh()
  {
    AppMethodBeat.i(122170);
    bjt localbjt2 = cli();
    bjt localbjt1 = localbjt2;
    if (localbjt2 == null)
    {
      localbjt1 = new bjt();
      b(localbjt1);
    }
    AppMethodBeat.o(122170);
    return localbjt1;
  }
  
  private static bjt cli()
  {
    AppMethodBeat.i(122172);
    byte[] arrayOfByte = b.getBytes("mmkv_key_hell_PFLOW");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(122172);
      return null;
    }
    bjt localbjt = new bjt();
    try
    {
      localbjt.parseFrom(arrayOfByte);
      AppMethodBeat.o(122172);
      return localbjt;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("HellPageFlowDao", localException, "HABBYGE-MALI, HellPageFlowDao.read crash", new Object[0]);
      AppMethodBeat.o(122172);
    }
    return null;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(122173);
    long l = System.currentTimeMillis();
    b.o("mmkv_key_hell_PFLOW", new byte[0]);
    ac.i("HellPageFlowDao", "HABBYGE-MALI, HellPageFlowDao-reset-time: %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(122173);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.d.a
 * JD-Core Version:    0.7.0.1
 */