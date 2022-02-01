package com.tencent.mm.plugin.expt.hellhound.a.f.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.apd;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
{
  private static void a(apd paramapd)
  {
    AppMethodBeat.i(122276);
    if (paramapd == null)
    {
      AppMethodBeat.o(122276);
      return;
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_key_hell_float_lst_ac", paramapd.toByteArray());
      AppMethodBeat.o(122276);
      return;
    }
    catch (Exception paramapd)
    {
      ac.printErrStackTrace("FloatLastActionDao", paramapd, "HABBYGE-MALI, FloatLastActionDao._writeBack: %s", new Object[] { paramapd.getMessage() });
      AppMethodBeat.o(122276);
    }
  }
  
  public static void abJ(String paramString)
  {
    AppMethodBeat.i(122273);
    if (paramString == null)
    {
      AppMethodBeat.o(122273);
      return;
    }
    apd localapd2 = clk();
    apd localapd1 = localapd2;
    if (localapd2 == null) {
      localapd1 = new apd();
    }
    localapd1.EIf = paramString;
    localapd1.EIe = null;
    localapd1.EIg = null;
    a(localapd1);
    ac.d("FloatLastActionDao", "HABBYGE-MALI, updateFloatAction: %s", new Object[] { paramString });
    AppMethodBeat.o(122273);
  }
  
  static apd clk()
  {
    AppMethodBeat.i(122277);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_key_hell_float_lst_ac");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      ac.e("FloatLastActionDao", "HABBYGE-MALI, HellSession read(): NULL");
      AppMethodBeat.o(122277);
      return null;
    }
    apd localapd = new apd();
    try
    {
      localapd.parseFrom(arrayOfByte);
      AppMethodBeat.o(122277);
      return localapd;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("FloatLastActionDao", localException, "HABBYGE-MALI, FloatLastActionDao._read: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(122277);
    }
    return null;
  }
  
  public static void m(ccs paramccs)
  {
    AppMethodBeat.i(122274);
    if (paramccs == null)
    {
      AppMethodBeat.o(122274);
      return;
    }
    apd localapd2 = clk();
    apd localapd1 = localapd2;
    if (localapd2 == null) {
      localapd1 = new apd();
    }
    localapd1.EIf = null;
    localapd1.EIe = paramccs;
    a(localapd1);
    AppMethodBeat.o(122274);
  }
  
  public static void n(ccs paramccs)
  {
    AppMethodBeat.i(122275);
    apd localapd2 = clk();
    apd localapd1 = localapd2;
    if (localapd2 == null) {
      localapd1 = new apd();
    }
    localapd1.EIg = paramccs;
    a(localapd1);
    AppMethodBeat.o(122275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b
 * JD-Core Version:    0.7.0.1
 */