package com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.azc;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public static String Mq(String paramString)
  {
    AppMethodBeat.i(152278);
    Object localObject = brN();
    if ((localObject == null) || (((bkf)localObject).xyH.isEmpty()))
    {
      AppMethodBeat.o(152278);
      return null;
    }
    Iterator localIterator = ((bkf)localObject).xyH.iterator();
    localObject = null;
    if (localIterator.hasNext())
    {
      azc localazc = (azc)localIterator.next();
      if ((localazc == null) || (!paramString.equals(localazc.key))) {
        break label102;
      }
      localObject = localazc;
    }
    label102:
    for (;;)
    {
      break;
      if (localObject == null)
      {
        AppMethodBeat.o(152278);
        return null;
      }
      paramString = ((azc)localObject).value;
      AppMethodBeat.o(152278);
      return paramString;
    }
  }
  
  private static bkf brN()
  {
    AppMethodBeat.i(152280);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("hell_ac_ble_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(152280);
      return null;
    }
    bkf localbkf = new bkf();
    try
    {
      localbkf.parseFrom(arrayOfByte);
      AppMethodBeat.o(152280);
      return localbkf;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("ActivityBundleDao", localException, "habbyge-mali, ActivityBundleDao _doRead parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  public static void eh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152279);
    bkf localbkf = brN();
    if (localbkf == null) {
      localbkf = new bkf();
    }
    for (;;)
    {
      Object localObject = localbkf.xyH.iterator();
      while (((Iterator)localObject).hasNext())
      {
        azc localazc = (azc)((Iterator)localObject).next();
        if ((localazc != null) && (paramString1.equals(localazc.key))) {
          localbkf.xyH.remove(localazc);
        }
      }
      localObject = new azc();
      ((azc)localObject).key = paramString1;
      ((azc)localObject).value = paramString2;
      localbkf.xyH.add(localObject);
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.v("hell_ac_ble_mmkv_key", localbkf.toByteArray());
        AppMethodBeat.o(152279);
        return;
      }
      catch (Exception paramString1)
      {
        ab.printErrStackTrace("ActivityBundleDao", paramString1, "habbyge-mali, ActivityBundleDao writeBack", new Object[0]);
        AppMethodBeat.o(152279);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.b
 * JD-Core Version:    0.7.0.1
 */