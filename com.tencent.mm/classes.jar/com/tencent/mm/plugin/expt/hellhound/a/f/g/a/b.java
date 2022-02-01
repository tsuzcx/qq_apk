package com.tencent.mm.plugin.expt.hellhound.a.f.g.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.asx;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  static void Dq(int paramInt)
  {
    AppMethodBeat.i(210499);
    asx localasx2 = cqE();
    asx localasx1 = localasx2;
    if (localasx2 == null) {
      localasx1 = new asx();
    }
    localasx1.type = paramInt;
    a(localasx1);
    AppMethodBeat.o(210499);
  }
  
  public static void a(asx paramasx)
  {
    AppMethodBeat.i(122285);
    if (paramasx == null)
    {
      AppMethodBeat.o(122285);
      return;
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.p("mmkv_key_hell_floatS", paramasx.toByteArray());
      AppMethodBeat.o(122285);
      return;
    }
    catch (Exception paramasx)
    {
      ad.printErrStackTrace("HABBYGE-MALI.FloatSessionDao", paramasx, "FloatSessionDao._writeBack: %s", new Object[] { paramasx.getMessage() });
      AppMethodBeat.o(122285);
    }
  }
  
  public static void b(boc paramboc)
  {
    AppMethodBeat.i(122279);
    if (paramboc == null)
    {
      AppMethodBeat.o(122279);
      return;
    }
    asx localasx2 = cqE();
    asx localasx1 = localasx2;
    if (localasx2 == null) {
      localasx1 = new asx();
    }
    localasx1.GqT = new boc();
    localasx1.GqT.dtL = paramboc.dtL;
    localasx1.GqT.dyV = paramboc.dyV;
    localasx1.GqT.aHQ = paramboc.aHQ;
    a(localasx1);
    AppMethodBeat.o(122279);
  }
  
  public static boc cqB()
  {
    AppMethodBeat.i(122280);
    Object localObject = cqE();
    if (localObject == null)
    {
      AppMethodBeat.o(122280);
      return null;
    }
    localObject = ((asx)localObject).GqT;
    AppMethodBeat.o(122280);
    return localObject;
  }
  
  public static int cqC()
  {
    AppMethodBeat.i(184390);
    asx localasx = cqE();
    if (localasx == null)
    {
      AppMethodBeat.o(184390);
      return 8;
    }
    int i = localasx.GqX;
    AppMethodBeat.o(184390);
    return i;
  }
  
  public static Pair<Integer, Integer> cqD()
  {
    AppMethodBeat.i(122284);
    Object localObject = cqE();
    if (localObject == null)
    {
      AppMethodBeat.o(122284);
      return null;
    }
    localObject = Pair.create(Integer.valueOf(((asx)localObject).GqU), Integer.valueOf(((asx)localObject).GqV));
    AppMethodBeat.o(122284);
    return localObject;
  }
  
  public static asx cqE()
  {
    AppMethodBeat.i(122286);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_key_hell_floatS");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      ad.e("HABBYGE-MALI.FloatSessionDao", "HellSession read(): NULL");
      AppMethodBeat.o(122286);
      return null;
    }
    asx localasx = new asx();
    try
    {
      localasx.parseFrom(arrayOfByte);
      AppMethodBeat.o(122286);
      return localasx;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("HABBYGE-MALI.FloatSessionDao", localException, "FloatSessionDao._read: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(122286);
    }
    return null;
  }
  
  public static void fz(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(122283);
    asx localasx2 = cqE();
    asx localasx1 = localasx2;
    if (localasx2 == null) {
      localasx1 = new asx();
    }
    if (paramInt1 != -1) {
      localasx1.GqU = paramInt1;
    }
    if (paramInt2 != -1) {
      localasx1.GqV = paramInt2;
    }
    a(localasx1);
    AppMethodBeat.o(122283);
  }
  
  public static void lc(boolean paramBoolean)
  {
    AppMethodBeat.i(122281);
    asx localasx2 = cqE();
    asx localasx1 = localasx2;
    if (localasx2 == null) {
      localasx1 = new asx();
    }
    localasx1.GqW = paramBoolean;
    a(localasx1);
    ad.d("HABBYGE-MALI.FloatSessionDao", "setClickMenuItem: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(122281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b
 * JD-Core Version:    0.7.0.1
 */