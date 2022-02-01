package com.tencent.mm.plugin.expt.hellhound.a.f.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ama;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  public static void Xm(String paramString)
  {
    AppMethodBeat.i(122273);
    if (paramString == null)
    {
      AppMethodBeat.o(122273);
      return;
    }
    ama localama2 = cdC();
    ama localama1 = localama2;
    if (localama2 == null) {
      localama1 = new ama();
    }
    localama1.Dnf = paramString;
    localama1.Dne = null;
    localama1.Dng = null;
    a(localama1);
    ad.d("FloatLastActionDao", "HABBYGE-MALI, updateFloatAction: %s", new Object[] { paramString });
    AppMethodBeat.o(122273);
  }
  
  private static void a(ama paramama)
  {
    AppMethodBeat.i(122276);
    if (paramama == null)
    {
      AppMethodBeat.o(122276);
      return;
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_key_hell_float_lst_ac", paramama.toByteArray());
      AppMethodBeat.o(122276);
      return;
    }
    catch (Exception paramama)
    {
      ad.printErrStackTrace("FloatLastActionDao", paramama, "HABBYGE-MALI, FloatLastActionDao._writeBack: %s", new Object[] { paramama.getMessage() });
      AppMethodBeat.o(122276);
    }
  }
  
  static ama cdC()
  {
    AppMethodBeat.i(122277);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_key_hell_float_lst_ac");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      ad.e("FloatLastActionDao", "HABBYGE-MALI, HellSession read(): NULL");
      AppMethodBeat.o(122277);
      return null;
    }
    ama localama = new ama();
    try
    {
      localama.parseFrom(arrayOfByte);
      AppMethodBeat.o(122277);
      return localama;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("FloatLastActionDao", localException, "HABBYGE-MALI, FloatLastActionDao._read: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(122277);
    }
    return null;
  }
  
  public static void l(bxx parambxx)
  {
    AppMethodBeat.i(122274);
    if (parambxx == null)
    {
      AppMethodBeat.o(122274);
      return;
    }
    ama localama2 = cdC();
    ama localama1 = localama2;
    if (localama2 == null) {
      localama1 = new ama();
    }
    localama1.Dnf = null;
    localama1.Dne = parambxx;
    a(localama1);
    AppMethodBeat.o(122274);
  }
  
  public static void m(bxx parambxx)
  {
    AppMethodBeat.i(122275);
    ama localama2 = cdC();
    ama localama1 = localama2;
    if (localama2 == null) {
      localama1 = new ama();
    }
    localama1.Dng = parambxx;
    a(localama1);
    AppMethodBeat.o(122275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b
 * JD-Core Version:    0.7.0.1
 */