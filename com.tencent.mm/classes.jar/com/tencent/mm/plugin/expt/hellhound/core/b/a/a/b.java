package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bof;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public static String aan(String paramString)
  {
    AppMethodBeat.i(121960);
    Object localObject = cjc();
    if ((localObject == null) || (((ccp)localObject).Fra.isEmpty()))
    {
      AppMethodBeat.o(121960);
      return null;
    }
    Iterator localIterator = ((ccp)localObject).Fra.iterator();
    localObject = null;
    if (localIterator.hasNext())
    {
      bof localbof = (bof)localIterator.next();
      if ((localbof == null) || (!paramString.equals(localbof.key))) {
        break label102;
      }
      localObject = localbof;
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
      paramString = ((bof)localObject).value;
      AppMethodBeat.o(121960);
      return paramString;
    }
  }
  
  private static ccp cjc()
  {
    AppMethodBeat.i(121962);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("hell_ac_ble_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121962);
      return null;
    }
    ccp localccp = new ccp();
    try
    {
      localccp.parseFrom(arrayOfByte);
      AppMethodBeat.o(121962);
      return localccp;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("ActivityBundleDao", localException, "habbyge-mali, ActivityBundleDao _doRead parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  public static void fH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121961);
    ccp localccp = cjc();
    if (localccp == null) {
      localccp = new ccp();
    }
    for (;;)
    {
      Object localObject = localccp.Fra.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bof localbof = (bof)((Iterator)localObject).next();
        if ((localbof != null) && (paramString1.equals(localbof.key))) {
          localccp.Fra.remove(localbof);
        }
      }
      localObject = new bof();
      ((bof)localObject).key = paramString1;
      ((bof)localObject).value = paramString2;
      localccp.Fra.add(localObject);
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_ac_ble_mmkv_key", localccp.toByteArray());
        AppMethodBeat.o(121961);
        return;
      }
      catch (Exception paramString1)
      {
        ac.printErrStackTrace("ActivityBundleDao", paramString1, "habbyge-mali, ActivityBundleDao writeBack", new Object[0]);
        AppMethodBeat.o(121961);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */