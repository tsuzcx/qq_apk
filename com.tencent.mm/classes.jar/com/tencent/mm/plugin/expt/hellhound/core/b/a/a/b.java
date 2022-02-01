package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dfx;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public static String aro(String paramString)
  {
    AppMethodBeat.i(121960);
    Object localObject = dJr();
    if ((localObject == null) || (((eae)localObject).abfm.isEmpty()))
    {
      AppMethodBeat.o(121960);
      return null;
    }
    Iterator localIterator = ((eae)localObject).abfm.iterator();
    localObject = null;
    if (localIterator.hasNext())
    {
      dfx localdfx = (dfx)localIterator.next();
      if ((localdfx == null) || (!paramString.equals(localdfx.key))) {
        break label102;
      }
      localObject = localdfx;
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
      paramString = ((dfx)localObject).value;
      AppMethodBeat.o(121960);
      return paramString;
    }
  }
  
  private static eae dJr()
  {
    AppMethodBeat.i(121962);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.ard("hell_ac_ble_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121962);
      return null;
    }
    eae localeae = new eae();
    try
    {
      localeae.parseFrom(arrayOfByte);
      AppMethodBeat.o(121962);
      return localeae;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("HABBYGE-MALI.ActivityBundleDao", localException, "ActivityBundleDao _doRead parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  public static void hj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121961);
    eae localeae = dJr();
    if (localeae == null) {
      localeae = new eae();
    }
    for (;;)
    {
      Object localObject = localeae.abfm.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dfx localdfx = (dfx)((Iterator)localObject).next();
        if ((localdfx != null) && (paramString1.equals(localdfx.key))) {
          localeae.abfm.remove(localdfx);
        }
      }
      localObject = new dfx();
      ((dfx)localObject).key = paramString1;
      ((dfx)localObject).value = paramString2;
      localeae.abfm.add(localObject);
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.u("hell_ac_ble_mmkv_key", localeae.toByteArray());
        AppMethodBeat.o(121961);
        return;
      }
      catch (Exception paramString1)
      {
        Log.printErrStackTrace("HABBYGE-MALI.ActivityBundleDao", paramString1, "ActivityBundleDao writeBack", new Object[0]);
        AppMethodBeat.o(121961);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */