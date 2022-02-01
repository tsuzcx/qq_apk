package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cgh;
import com.tencent.mm.protocal.protobuf.cyi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public static String apk(String paramString)
  {
    AppMethodBeat.i(121960);
    Object localObject = cNX();
    if ((localObject == null) || (((cyi)localObject).MDh.isEmpty()))
    {
      AppMethodBeat.o(121960);
      return null;
    }
    Iterator localIterator = ((cyi)localObject).MDh.iterator();
    localObject = null;
    if (localIterator.hasNext())
    {
      cgh localcgh = (cgh)localIterator.next();
      if ((localcgh == null) || (!paramString.equals(localcgh.key))) {
        break label102;
      }
      localObject = localcgh;
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
      paramString = ((cgh)localObject).value;
      AppMethodBeat.o(121960);
      return paramString;
    }
  }
  
  private static cyi cNX()
  {
    AppMethodBeat.i(121962);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("hell_ac_ble_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121962);
      return null;
    }
    cyi localcyi = new cyi();
    try
    {
      localcyi.parseFrom(arrayOfByte);
      AppMethodBeat.o(121962);
      return localcyi;
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
  
  public static void go(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121961);
    cyi localcyi = cNX();
    if (localcyi == null) {
      localcyi = new cyi();
    }
    for (;;)
    {
      Object localObject = localcyi.MDh.iterator();
      while (((Iterator)localObject).hasNext())
      {
        cgh localcgh = (cgh)((Iterator)localObject).next();
        if ((localcgh != null) && (paramString1.equals(localcgh.key))) {
          localcyi.MDh.remove(localcgh);
        }
      }
      localObject = new cgh();
      ((cgh)localObject).key = paramString1;
      ((cgh)localObject).value = paramString2;
      localcyi.MDh.add(localObject);
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_ac_ble_mmkv_key", localcyi.toByteArray());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */