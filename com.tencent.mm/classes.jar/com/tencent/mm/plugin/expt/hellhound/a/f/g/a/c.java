package com.tencent.mm.plugin.expt.hellhound.a.f.g.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.alz;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
{
  public static void a(alz paramalz)
  {
    AppMethodBeat.i(122285);
    if (paramalz == null)
    {
      AppMethodBeat.o(122285);
      return;
    }
    try
    {
      b.o("mmkv_key_hell_floatS", paramalz.toByteArray());
      AppMethodBeat.o(122285);
      return;
    }
    catch (Exception paramalz)
    {
      ad.printErrStackTrace("FloatSessionDao", paramalz, "HABBYGE-MALI, FloatSessionDao._writeBack: %s", new Object[] { paramalz.getMessage() });
      AppMethodBeat.o(122285);
    }
  }
  
  static void ahb(int paramInt)
  {
    AppMethodBeat.i(205458);
    alz localalz2 = cdH();
    alz localalz1 = localalz2;
    if (localalz2 == null) {
      localalz1 = new alz();
    }
    localalz1.type = paramInt;
    a(localalz1);
    AppMethodBeat.o(205458);
  }
  
  public static void b(bgc parambgc)
  {
    AppMethodBeat.i(122279);
    if (parambgc == null)
    {
      AppMethodBeat.o(122279);
      return;
    }
    alz localalz2 = cdH();
    alz localalz1 = localalz2;
    if (localalz2 == null) {
      localalz1 = new alz();
    }
    localalz1.DmZ = new bgc();
    localalz1.DmZ.DDP = parambgc.DDP;
    localalz1.DmZ.dpw = parambgc.dpw;
    a(localalz1);
    AppMethodBeat.o(122279);
  }
  
  public static bgc cdD()
  {
    AppMethodBeat.i(122280);
    Object localObject = cdH();
    if (localObject == null)
    {
      AppMethodBeat.o(122280);
      return null;
    }
    localObject = ((alz)localObject).DmZ;
    AppMethodBeat.o(122280);
    return localObject;
  }
  
  static boolean cdE()
  {
    AppMethodBeat.i(122282);
    alz localalz = cdH();
    if ((localalz != null) && (localalz.Dnc))
    {
      AppMethodBeat.o(122282);
      return true;
    }
    AppMethodBeat.o(122282);
    return false;
  }
  
  public static int cdF()
  {
    AppMethodBeat.i(184390);
    alz localalz = cdH();
    if (localalz == null)
    {
      AppMethodBeat.o(184390);
      return 8;
    }
    int i = localalz.Dnd;
    AppMethodBeat.o(184390);
    return i;
  }
  
  public static Pair<Integer, Integer> cdG()
  {
    AppMethodBeat.i(122284);
    Object localObject = cdH();
    if (localObject == null)
    {
      AppMethodBeat.o(122284);
      return null;
    }
    localObject = Pair.create(Integer.valueOf(((alz)localObject).Dna), Integer.valueOf(((alz)localObject).Dnb));
    AppMethodBeat.o(122284);
    return localObject;
  }
  
  public static alz cdH()
  {
    AppMethodBeat.i(122286);
    byte[] arrayOfByte = b.getBytes("mmkv_key_hell_floatS");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      ad.e("FloatSessionDao", "HABBYGE-MALI, HellSession read(): NULL");
      AppMethodBeat.o(122286);
      return null;
    }
    alz localalz = new alz();
    try
    {
      localalz.parseFrom(arrayOfByte);
      AppMethodBeat.o(122286);
      return localalz;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("FloatSessionDao", localException, "HABBYGE-MALI, FloatSessionDao._read: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(122286);
    }
    return null;
  }
  
  public static void fp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(122283);
    alz localalz2 = cdH();
    alz localalz1 = localalz2;
    if (localalz2 == null) {
      localalz1 = new alz();
    }
    if (paramInt1 != -1) {
      localalz1.Dna = paramInt1;
    }
    if (paramInt2 != -1) {
      localalz1.Dnb = paramInt2;
    }
    a(localalz1);
    AppMethodBeat.o(122283);
  }
  
  public static void kg(boolean paramBoolean)
  {
    AppMethodBeat.i(122281);
    alz localalz2 = cdH();
    alz localalz1 = localalz2;
    if (localalz2 == null) {
      localalz1 = new alz();
    }
    localalz1.Dnc = paramBoolean;
    a(localalz1);
    ad.d("FloatSessionDao", "HABBYGE-MALI, setClickMenuItem: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(122281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c
 * JD-Core Version:    0.7.0.1
 */