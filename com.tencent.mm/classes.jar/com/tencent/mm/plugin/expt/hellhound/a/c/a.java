package com.tencent.mm.plugin.expt.hellhound.a.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
{
  public static void Cv(int paramInt)
  {
    AppMethodBeat.i(122027);
    apx localapx2 = cjY();
    apx localapx1 = localapx2;
    if (localapx2 == null) {
      localapx1 = new apx();
    }
    localapx1.EIN = paramInt;
    a(localapx1);
    AppMethodBeat.o(122027);
  }
  
  static void a(apx paramapx)
  {
    AppMethodBeat.i(122028);
    try
    {
      b.o("hell_fntbck_pter_mmkv_key", paramapx.toByteArray());
      AppMethodBeat.o(122028);
      return;
    }
    catch (Exception paramapx)
    {
      ac.printErrStackTrace("FrontBackDao", paramapx, "habbyge-mali, writeBackFrontBack", new Object[0]);
      AppMethodBeat.o(122028);
    }
  }
  
  public static apx cjY()
  {
    AppMethodBeat.i(122029);
    byte[] arrayOfByte = b.getBytes("hell_fntbck_pter_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(122029);
      return null;
    }
    apx localapx = new apx();
    try
    {
      localapx.parseFrom(arrayOfByte);
      AppMethodBeat.o(122029);
      return localapx;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("FrontBackDao", localException, "habbyge-mali, _doReadFrontBack parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  public static void kI(boolean paramBoolean)
  {
    AppMethodBeat.i(122026);
    apx localapx2 = cjY();
    apx localapx1 = localapx2;
    if (localapx2 == null) {
      localapx1 = new apx();
    }
    localapx1.EIS = paramBoolean;
    ac.d("FrontBackDao", "habbyge-mali, logout8EventFromAdd: %b", new Object[] { Boolean.valueOf(localapx1.EIS) });
    a(localapx1);
    AppMethodBeat.o(122026);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.c.a
 * JD-Core Version:    0.7.0.1
 */