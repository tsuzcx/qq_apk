package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.btm;
import com.tencent.mm.protocal.protobuf.cib;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public static String aeU(String paramString)
  {
    AppMethodBeat.i(121960);
    Object localObject = cpE();
    if ((localObject == null) || (((cib)localObject).Huj.isEmpty()))
    {
      AppMethodBeat.o(121960);
      return null;
    }
    Iterator localIterator = ((cib)localObject).Huj.iterator();
    localObject = null;
    if (localIterator.hasNext())
    {
      btm localbtm = (btm)localIterator.next();
      if ((localbtm == null) || (!paramString.equals(localbtm.key))) {
        break label102;
      }
      localObject = localbtm;
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
      paramString = ((btm)localObject).value;
      AppMethodBeat.o(121960);
      return paramString;
    }
  }
  
  private static cib cpE()
  {
    AppMethodBeat.i(121962);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("hell_ac_ble_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121962);
      return null;
    }
    cib localcib = new cib();
    try
    {
      localcib.parseFrom(arrayOfByte);
      AppMethodBeat.o(121962);
      return localcib;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("HABBYGE-MALI.ActivityBundleDao", localException, "ActivityBundleDao _doRead parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  public static void fV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121961);
    cib localcib = cpE();
    if (localcib == null) {
      localcib = new cib();
    }
    for (;;)
    {
      Object localObject = localcib.Huj.iterator();
      while (((Iterator)localObject).hasNext())
      {
        btm localbtm = (btm)((Iterator)localObject).next();
        if ((localbtm != null) && (paramString1.equals(localbtm.key))) {
          localcib.Huj.remove(localbtm);
        }
      }
      localObject = new btm();
      ((btm)localObject).key = paramString1;
      ((btm)localObject).value = paramString2;
      localcib.Huj.add(localObject);
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_ac_ble_mmkv_key", localcib.toByteArray());
        AppMethodBeat.o(121961);
        return;
      }
      catch (Exception paramString1)
      {
        ae.printErrStackTrace("HABBYGE-MALI.ActivityBundleDao", paramString1, "ActivityBundleDao writeBack", new Object[0]);
        AppMethodBeat.o(121961);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */