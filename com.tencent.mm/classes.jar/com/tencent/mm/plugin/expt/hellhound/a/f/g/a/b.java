package com.tencent.mm.plugin.expt.hellhound.a.f.g.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.blr;
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  static void La(int paramInt)
  {
    AppMethodBeat.i(254184);
    blr localblr2 = dfJ();
    blr localblr1 = localblr2;
    if (localblr2 == null) {
      localblr1 = new blr();
    }
    localblr1.type = paramInt;
    a(localblr1);
    AppMethodBeat.o(254184);
  }
  
  public static void a(blr paramblr)
  {
    AppMethodBeat.i(122285);
    if (paramblr == null)
    {
      AppMethodBeat.o(122285);
      return;
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.r("mmkv_key_hell_floatS", paramblr.toByteArray());
      AppMethodBeat.o(122285);
      return;
    }
    catch (Exception paramblr)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FloatSessionDao", paramblr, "FloatSessionDao._writeBack: %s", new Object[] { paramblr.getMessage() });
      AppMethodBeat.o(122285);
    }
  }
  
  public static void b(cjp paramcjp)
  {
    AppMethodBeat.i(122279);
    if (paramcjp == null)
    {
      AppMethodBeat.o(122279);
      return;
    }
    blr localblr2 = dfJ();
    blr localblr1 = localblr2;
    if (localblr2 == null) {
      localblr1 = new blr();
    }
    localblr1.SWJ = new cjp();
    localblr1.SWJ.fFe = paramcjp.fFe;
    localblr1.SWJ.fLj = paramcjp.fLj;
    localblr1.SWJ.aNf = paramcjp.aNf;
    a(localblr1);
    AppMethodBeat.o(122279);
  }
  
  static int dfF()
  {
    AppMethodBeat.i(254186);
    blr localblr = dfJ();
    if (localblr == null)
    {
      AppMethodBeat.o(254186);
      return -1;
    }
    int i = localblr.type;
    AppMethodBeat.o(254186);
    return i;
  }
  
  public static cjp dfG()
  {
    AppMethodBeat.i(122280);
    Object localObject = dfJ();
    if (localObject == null)
    {
      AppMethodBeat.o(122280);
      return null;
    }
    localObject = ((blr)localObject).SWJ;
    AppMethodBeat.o(122280);
    return localObject;
  }
  
  public static int dfH()
  {
    AppMethodBeat.i(184390);
    blr localblr = dfJ();
    if (localblr == null)
    {
      AppMethodBeat.o(184390);
      return 8;
    }
    int i = localblr.SWN;
    AppMethodBeat.o(184390);
    return i;
  }
  
  public static Pair<Integer, Integer> dfI()
  {
    AppMethodBeat.i(122284);
    Object localObject = dfJ();
    if (localObject == null)
    {
      AppMethodBeat.o(122284);
      return null;
    }
    localObject = Pair.create(Integer.valueOf(((blr)localObject).SWK), Integer.valueOf(((blr)localObject).SWL));
    AppMethodBeat.o(122284);
    return localObject;
  }
  
  public static blr dfJ()
  {
    AppMethodBeat.i(122286);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.awZ("mmkv_key_hell_floatS");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(122286);
      return null;
    }
    blr localblr = new blr();
    try
    {
      localblr.parseFrom(arrayOfByte);
      AppMethodBeat.o(122286);
      return localblr;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FloatSessionDao", localException, "FloatSessionDao._read: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(122286);
    }
    return null;
  }
  
  public static void gk(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(122283);
    blr localblr2 = dfJ();
    blr localblr1 = localblr2;
    if (localblr2 == null) {
      localblr1 = new blr();
    }
    if (paramInt1 != -1) {
      localblr1.SWK = paramInt1;
    }
    if (paramInt2 != -1) {
      localblr1.SWL = paramInt2;
    }
    a(localblr1);
    AppMethodBeat.o(122283);
  }
  
  public static void nx(boolean paramBoolean)
  {
    AppMethodBeat.i(122281);
    blr localblr2 = dfJ();
    blr localblr1 = localblr2;
    if (localblr2 == null) {
      localblr1 = new blr();
    }
    localblr1.SWM = paramBoolean;
    a(localblr1);
    Log.d("HABBYGE-MALI.FloatSessionDao", "setClickMenuItem: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(122281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b
 * JD-Core Version:    0.7.0.1
 */