package com.tencent.mm.plugin.expt.hellhound.a.f.g.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.atn;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
{
  static void DD(int paramInt)
  {
    AppMethodBeat.i(196166);
    atn localatn2 = csg();
    atn localatn1 = localatn2;
    if (localatn2 == null) {
      localatn1 = new atn();
    }
    localatn1.type = paramInt;
    a(localatn1);
    AppMethodBeat.o(196166);
  }
  
  public static void a(atn paramatn)
  {
    AppMethodBeat.i(122285);
    if (paramatn == null)
    {
      AppMethodBeat.o(122285);
      return;
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.p("mmkv_key_hell_floatS", paramatn.toByteArray());
      AppMethodBeat.o(122285);
      return;
    }
    catch (Exception paramatn)
    {
      ae.printErrStackTrace("HABBYGE-MALI.FloatSessionDao", paramatn, "FloatSessionDao._writeBack: %s", new Object[] { paramatn.getMessage() });
      AppMethodBeat.o(122285);
    }
  }
  
  public static void b(bou parambou)
  {
    AppMethodBeat.i(122279);
    if (parambou == null)
    {
      AppMethodBeat.o(122279);
      return;
    }
    atn localatn2 = csg();
    atn localatn1 = localatn2;
    if (localatn2 == null) {
      localatn1 = new atn();
    }
    localatn1.GKr = new bou();
    localatn1.GKr.duQ = parambou.duQ;
    localatn1.GKr.dAa = parambou.dAa;
    localatn1.GKr.aHQ = parambou.aHQ;
    a(localatn1);
    AppMethodBeat.o(122279);
  }
  
  public static bou csd()
  {
    AppMethodBeat.i(122280);
    Object localObject = csg();
    if (localObject == null)
    {
      AppMethodBeat.o(122280);
      return null;
    }
    localObject = ((atn)localObject).GKr;
    AppMethodBeat.o(122280);
    return localObject;
  }
  
  public static int cse()
  {
    AppMethodBeat.i(184390);
    atn localatn = csg();
    if (localatn == null)
    {
      AppMethodBeat.o(184390);
      return 8;
    }
    int i = localatn.GKv;
    AppMethodBeat.o(184390);
    return i;
  }
  
  public static Pair<Integer, Integer> csf()
  {
    AppMethodBeat.i(122284);
    Object localObject = csg();
    if (localObject == null)
    {
      AppMethodBeat.o(122284);
      return null;
    }
    localObject = Pair.create(Integer.valueOf(((atn)localObject).GKs), Integer.valueOf(((atn)localObject).GKt));
    AppMethodBeat.o(122284);
    return localObject;
  }
  
  public static atn csg()
  {
    AppMethodBeat.i(122286);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_key_hell_floatS");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      ae.e("HABBYGE-MALI.FloatSessionDao", "HellSession read(): NULL");
      AppMethodBeat.o(122286);
      return null;
    }
    atn localatn = new atn();
    try
    {
      localatn.parseFrom(arrayOfByte);
      AppMethodBeat.o(122286);
      return localatn;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("HABBYGE-MALI.FloatSessionDao", localException, "FloatSessionDao._read: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(122286);
    }
    return null;
  }
  
  public static void fx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(122283);
    atn localatn2 = csg();
    atn localatn1 = localatn2;
    if (localatn2 == null) {
      localatn1 = new atn();
    }
    if (paramInt1 != -1) {
      localatn1.GKs = paramInt1;
    }
    if (paramInt2 != -1) {
      localatn1.GKt = paramInt2;
    }
    a(localatn1);
    AppMethodBeat.o(122283);
  }
  
  public static void lc(boolean paramBoolean)
  {
    AppMethodBeat.i(122281);
    atn localatn2 = csg();
    atn localatn1 = localatn2;
    if (localatn2 == null) {
      localatn1 = new atn();
    }
    localatn1.GKu = paramBoolean;
    a(localatn1);
    ae.d("HABBYGE-MALI.FloatSessionDao", "setClickMenuItem: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(122281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b
 * JD-Core Version:    0.7.0.1
 */