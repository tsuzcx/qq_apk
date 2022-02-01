package com.tencent.mm.plugin.expt.hellhound.a.f.g.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.apc;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.sdk.platformtools.ac;

public final class c
{
  static void CD(int paramInt)
  {
    AppMethodBeat.i(195296);
    apc localapc2 = clp();
    apc localapc1 = localapc2;
    if (localapc2 == null) {
      localapc1 = new apc();
    }
    localapc1.type = paramInt;
    a(localapc1);
    AppMethodBeat.o(195296);
  }
  
  public static void a(apc paramapc)
  {
    AppMethodBeat.i(122285);
    if (paramapc == null)
    {
      AppMethodBeat.o(122285);
      return;
    }
    try
    {
      b.o("mmkv_key_hell_floatS", paramapc.toByteArray());
      AppMethodBeat.o(122285);
      return;
    }
    catch (Exception paramapc)
    {
      ac.printErrStackTrace("FloatSessionDao", paramapc, "HABBYGE-MALI, FloatSessionDao._writeBack: %s", new Object[] { paramapc.getMessage() });
      AppMethodBeat.o(122285);
    }
  }
  
  public static void b(bju parambju)
  {
    AppMethodBeat.i(122279);
    if (parambju == null)
    {
      AppMethodBeat.o(122279);
      return;
    }
    apc localapc2 = clp();
    apc localapc1 = localapc2;
    if (localapc2 == null) {
      localapc1 = new apc();
    }
    localapc1.EHZ = new bju();
    localapc1.EHZ.qoi = parambju.qoi;
    localapc1.EHZ.dnh = parambju.dnh;
    a(localapc1);
    AppMethodBeat.o(122279);
  }
  
  public static bju cll()
  {
    AppMethodBeat.i(122280);
    Object localObject = clp();
    if (localObject == null)
    {
      AppMethodBeat.o(122280);
      return null;
    }
    localObject = ((apc)localObject).EHZ;
    AppMethodBeat.o(122280);
    return localObject;
  }
  
  static boolean clm()
  {
    AppMethodBeat.i(122282);
    apc localapc = clp();
    if ((localapc != null) && (localapc.EIc))
    {
      AppMethodBeat.o(122282);
      return true;
    }
    AppMethodBeat.o(122282);
    return false;
  }
  
  public static int cln()
  {
    AppMethodBeat.i(184390);
    apc localapc = clp();
    if (localapc == null)
    {
      AppMethodBeat.o(184390);
      return 8;
    }
    int i = localapc.EId;
    AppMethodBeat.o(184390);
    return i;
  }
  
  public static Pair<Integer, Integer> clo()
  {
    AppMethodBeat.i(122284);
    Object localObject = clp();
    if (localObject == null)
    {
      AppMethodBeat.o(122284);
      return null;
    }
    localObject = Pair.create(Integer.valueOf(((apc)localObject).EIa), Integer.valueOf(((apc)localObject).EIb));
    AppMethodBeat.o(122284);
    return localObject;
  }
  
  public static apc clp()
  {
    AppMethodBeat.i(122286);
    byte[] arrayOfByte = b.getBytes("mmkv_key_hell_floatS");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      ac.e("FloatSessionDao", "HABBYGE-MALI, HellSession read(): NULL");
      AppMethodBeat.o(122286);
      return null;
    }
    apc localapc = new apc();
    try
    {
      localapc.parseFrom(arrayOfByte);
      AppMethodBeat.o(122286);
      return localapc;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("FloatSessionDao", localException, "HABBYGE-MALI, FloatSessionDao._read: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(122286);
    }
    return null;
  }
  
  public static void fs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(122283);
    apc localapc2 = clp();
    apc localapc1 = localapc2;
    if (localapc2 == null) {
      localapc1 = new apc();
    }
    if (paramInt1 != -1) {
      localapc1.EIa = paramInt1;
    }
    if (paramInt2 != -1) {
      localapc1.EIb = paramInt2;
    }
    a(localapc1);
    AppMethodBeat.o(122283);
  }
  
  public static void kK(boolean paramBoolean)
  {
    AppMethodBeat.i(122281);
    apc localapc2 = clp();
    apc localapc1 = localapc2;
    if (localapc2 == null) {
      localapc1 = new apc();
    }
    localapc1.EIc = paramBoolean;
    a(localapc1);
    ac.d("FloatSessionDao", "HABBYGE-MALI, setClickMenuItem: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(122281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c
 * JD-Core Version:    0.7.0.1
 */