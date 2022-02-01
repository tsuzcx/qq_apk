package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bkl;
import com.tencent.mm.protocal.protobuf.bxu;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public static String VY(String paramString)
  {
    AppMethodBeat.i(121960);
    Object localObject = cbR();
    if ((localObject == null) || (((bxu)localObject).DUn.isEmpty()))
    {
      AppMethodBeat.o(121960);
      return null;
    }
    Iterator localIterator = ((bxu)localObject).DUn.iterator();
    localObject = null;
    if (localIterator.hasNext())
    {
      bkl localbkl = (bkl)localIterator.next();
      if ((localbkl == null) || (!paramString.equals(localbkl.key))) {
        break label102;
      }
      localObject = localbkl;
    }
    label102:
    for (;;)
    {
      break;
      if (localObject == null)
      {
        AppMethodBeat.o(121960);
        return null;
      }
      paramString = ((bkl)localObject).value;
      AppMethodBeat.o(121960);
      return paramString;
    }
  }
  
  private static bxu cbR()
  {
    AppMethodBeat.i(121962);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("hell_ac_ble_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121962);
      return null;
    }
    bxu localbxu = new bxu();
    try
    {
      localbxu.parseFrom(arrayOfByte);
      AppMethodBeat.o(121962);
      return localbxu;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("ActivityBundleDao", localException, "habbyge-mali, ActivityBundleDao _doRead parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  public static void fu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121961);
    bxu localbxu = cbR();
    if (localbxu == null) {
      localbxu = new bxu();
    }
    for (;;)
    {
      Object localObject = localbxu.DUn.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bkl localbkl = (bkl)((Iterator)localObject).next();
        if ((localbkl != null) && (paramString1.equals(localbkl.key))) {
          localbxu.DUn.remove(localbkl);
        }
      }
      localObject = new bkl();
      ((bkl)localObject).key = paramString1;
      ((bkl)localObject).value = paramString2;
      localbxu.DUn.add(localObject);
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_ac_ble_mmkv_key", localbxu.toByteArray());
        AppMethodBeat.o(121961);
        return;
      }
      catch (Exception paramString1)
      {
        ad.printErrStackTrace("ActivityBundleDao", paramString1, "habbyge-mali, ActivityBundleDao writeBack", new Object[0]);
        AppMethodBeat.o(121961);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */