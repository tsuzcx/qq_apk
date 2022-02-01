package com.tencent.mm.plugin.expt.hellhound.a.f.g.a;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ben;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  static void Hq(int paramInt)
  {
    AppMethodBeat.i(220598);
    ben localben2 = cQO();
    ben localben1 = localben2;
    if (localben2 == null) {
      localben1 = new ben();
    }
    localben1.type = paramInt;
    a(localben1);
    AppMethodBeat.o(220598);
  }
  
  public static void a(ben paramben)
  {
    AppMethodBeat.i(122285);
    if (paramben == null)
    {
      AppMethodBeat.o(122285);
      return;
    }
    try
    {
      com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_key_hell_floatS", paramben.toByteArray());
      AppMethodBeat.o(122285);
      return;
    }
    catch (Exception paramben)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FloatSessionDao", paramben, "FloatSessionDao._writeBack: %s", new Object[] { paramben.getMessage() });
      AppMethodBeat.o(122285);
    }
  }
  
  public static void b(cbm paramcbm)
  {
    AppMethodBeat.i(122279);
    if (paramcbm == null)
    {
      AppMethodBeat.o(122279);
      return;
    }
    ben localben2 = cQO();
    ben localben1 = localben2;
    if (localben2 == null) {
      localben1 = new ben();
    }
    localben1.LOl = new cbm();
    localben1.LOl.dMl = paramcbm.dMl;
    localben1.LOl.dRM = paramcbm.dRM;
    localben1.LOl.aHK = paramcbm.aHK;
    a(localben1);
    AppMethodBeat.o(122279);
  }
  
  public static cbm cQL()
  {
    AppMethodBeat.i(122280);
    Object localObject = cQO();
    if (localObject == null)
    {
      AppMethodBeat.o(122280);
      return null;
    }
    localObject = ((ben)localObject).LOl;
    AppMethodBeat.o(122280);
    return localObject;
  }
  
  public static int cQM()
  {
    AppMethodBeat.i(184390);
    ben localben = cQO();
    if (localben == null)
    {
      AppMethodBeat.o(184390);
      return 8;
    }
    int i = localben.LOp;
    AppMethodBeat.o(184390);
    return i;
  }
  
  public static Pair<Integer, Integer> cQN()
  {
    AppMethodBeat.i(122284);
    Object localObject = cQO();
    if (localObject == null)
    {
      AppMethodBeat.o(122284);
      return null;
    }
    localObject = Pair.create(Integer.valueOf(((ben)localObject).LOm), Integer.valueOf(((ben)localObject).LOn));
    AppMethodBeat.o(122284);
    return localObject;
  }
  
  public static ben cQO()
  {
    AppMethodBeat.i(122286);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_key_hell_floatS");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(122286);
      return null;
    }
    ben localben = new ben();
    try
    {
      localben.parseFrom(arrayOfByte);
      AppMethodBeat.o(122286);
      return localben;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("HABBYGE-MALI.FloatSessionDao", localException, "FloatSessionDao._read: %s", new Object[] { localException.getMessage() });
      AppMethodBeat.o(122286);
    }
    return null;
  }
  
  public static void fN(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(122283);
    ben localben2 = cQO();
    ben localben1 = localben2;
    if (localben2 == null) {
      localben1 = new ben();
    }
    if (paramInt1 != -1) {
      localben1.LOm = paramInt1;
    }
    if (paramInt2 != -1) {
      localben1.LOn = paramInt2;
    }
    a(localben1);
    AppMethodBeat.o(122283);
  }
  
  static int getMethod()
  {
    AppMethodBeat.i(220599);
    ben localben = cQO();
    if (localben == null)
    {
      AppMethodBeat.o(220599);
      return -1;
    }
    int i = localben.type;
    AppMethodBeat.o(220599);
    return i;
  }
  
  public static void mk(boolean paramBoolean)
  {
    AppMethodBeat.i(122281);
    ben localben2 = cQO();
    ben localben1 = localben2;
    if (localben2 == null) {
      localben1 = new ben();
    }
    localben1.LOo = paramBoolean;
    a(localben1);
    Log.d("HABBYGE-MALI.FloatSessionDao", "setClickMenuItem: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    AppMethodBeat.o(122281);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b
 * JD-Core Version:    0.7.0.1
 */