package com.tencent.mm.plugin.expt.hellhound.a.b.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  static void a(aux paramaux)
  {
    AppMethodBeat.i(152388);
    if (paramaux == null)
    {
      AppMethodBeat.o(152388);
      return;
    }
    b(paramaux);
    AppMethodBeat.o(152388);
  }
  
  private static void b(aux paramaux)
  {
    AppMethodBeat.i(152390);
    try
    {
      b.v("mmkv_key_hell_PFLOW", paramaux.toByteArray());
      AppMethodBeat.o(152390);
      return;
    }
    catch (Exception paramaux)
    {
      ab.printErrStackTrace("HellPageFlowDao", paramaux, "habbyge-mali, HellPageFlowDao.writeBack crash", new Object[0]);
      AppMethodBeat.o(152390);
    }
  }
  
  public static aux bsu()
  {
    AppMethodBeat.i(152389);
    aux localaux2 = bsv();
    aux localaux1 = localaux2;
    if (localaux2 == null)
    {
      localaux1 = new aux();
      b(localaux1);
    }
    AppMethodBeat.o(152389);
    return localaux1;
  }
  
  private static aux bsv()
  {
    AppMethodBeat.i(152391);
    byte[] arrayOfByte = b.getBytes("mmkv_key_hell_PFLOW");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      ab.e("HellPageFlowDao", "habbyge-mali, HellPageFlowDao read(): NULL");
      AppMethodBeat.o(152391);
      return null;
    }
    aux localaux = new aux();
    try
    {
      localaux.parseFrom(arrayOfByte);
      AppMethodBeat.o(152391);
      return localaux;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("HellPageFlowDao", localException, "habbyge-mali, HellPageFlowDao.read crash", new Object[0]);
      AppMethodBeat.o(152391);
    }
    return null;
  }
  
  public static void reset()
  {
    AppMethodBeat.i(152392);
    b.v("mmkv_key_hell_PFLOW", new byte[0]);
    AppMethodBeat.o(152392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.c.a
 * JD-Core Version:    0.7.0.1
 */