package com.tencent.mm.plugin.expt.hellhound.ext.session.f.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bzj;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  static void LZ(int paramInt)
  {
    AppMethodBeat.i(300241);
    bzj localbzj2 = dMx();
    bzj localbzj1 = localbzj2;
    if (localbzj2 == null) {
      localbzj1 = new bzj();
    }
    localbzj1.type = paramInt;
    a(localbzj1);
    AppMethodBeat.o(300241);
  }
  
  public static void a(bzj parambzj)
  {
    AppMethodBeat.i(122285);
    if (parambzj == null)
    {
      AppMethodBeat.o(122285);
      return;
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.u("mmkv_key_hell_floatS", parambzj.toByteArray());
      AppMethodBeat.o(122285);
      return;
    }
    catch (Exception parambzj)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FloatSessionDao", parambzj, "FloatSessionDao._writeBack: %s", new Object[] { parambzj.getMessage() });
      AppMethodBeat.o(122285);
    }
  }
  
  public static void b(czu paramczu)
  {
    AppMethodBeat.i(122279);
    if (paramczu == null)
    {
      AppMethodBeat.o(122279);
      return;
    }
    bzj localbzj2 = dMx();
    bzj localbzj1 = localbzj2;
    if (localbzj2 == null) {
      localbzj1 = new bzj();
    }
    localbzj1.aaiA = new czu();
    localbzj1.aaiA.hJW = paramczu.hJW;
    localbzj1.aaiA.hQR = paramczu.hQR;
    localbzj1.aaiA.cHb = paramczu.cHb;
    a(localbzj1);
    AppMethodBeat.o(122279);
  }
  
  static int dMt()
  {
    AppMethodBeat.i(300244);
    bzj localbzj = dMx();
    if (localbzj == null)
    {
      AppMethodBeat.o(300244);
      return -1;
    }
    int i = localbzj.type;
    AppMethodBeat.o(300244);
    return i;
  }
  
  public static czu dMu()
  {
    AppMethodBeat.i(122280);
    Object localObject = dMx();
    if (localObject == null)
    {
      AppMethodBeat.o(122280);
      return null;
    }
    localObject = ((bzj)localObject).aaiA;
    AppMethodBeat.o(122280);
    return localObject;
  }
  
  public static int dMv()
  {
    AppMethodBeat.i(184390);
    bzj localbzj = dMx();
    if (localbzj == null)
    {
      AppMethodBeat.o(184390);
      return 8;
    }
    int i = localbzj.aaiE;
    AppMethodBeat.o(184390);
    return i;
  }
  
  public static Pair<Integer, Integer> dMw()
  {
    AppMethodBeat.i(122284);
    Object localObject = dMx();
    if (localObject == null)
    {
      AppMethodBeat.o(122284);
      return null;
    }
    localObject = Pair.create(Integer.valueOf(((bzj)localObject).aaiB), Integer.valueOf(((bzj)localObject).aaiC));
    AppMethodBeat.o(122284);
    return localObject;
  }
  
  public static bzj dMx()
  {
    AppMethodBeat.i(122286);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.ard("mmkv_key_hell_floatS");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(122286);
      return null;
    }
    bzj localbzj = new bzj();
    try
    {
      localbzj.parseFrom(arrayOfByte);
      AppMethodBeat.o(122286);
      return localbzj;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FloatSessionDao", localException, "FloatSessionDao._read: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(122286);
    }
    return null;
  }
  
  public static void hd(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(122283);
    bzj localbzj2 = dMx();
    bzj localbzj1 = localbzj2;
    if (localbzj2 == null) {
      localbzj1 = new bzj();
    }
    if (paramInt1 != -1) {
      localbzj1.aaiB = paramInt1;
    }
    if (paramInt2 != -1) {
      localbzj1.aaiC = paramInt2;
    }
    a(localbzj1);
    AppMethodBeat.o(122283);
  }
  
  public static void oX(boolean paramBoolean)
  {
    AppMethodBeat.i(122281);
    bzj localbzj2 = dMx();
    bzj localbzj1 = localbzj2;
    if (localbzj2 == null) {
      localbzj1 = new bzj();
    }
    localbzj1.aaiD = paramBoolean;
    a(localbzj1);
    Log.d("HABBYGE-MALI.FloatSessionDao", "setClickMenuItem: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(122281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.b
 * JD-Core Version:    0.7.0.1
 */