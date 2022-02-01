package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cpd;
import com.tencent.mm.protocal.protobuf.dhu;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public static String axk(String paramString)
  {
    AppMethodBeat.i(121960);
    Object localObject = dcP();
    if ((localObject == null) || (((dhu)localObject).TOQ.isEmpty()))
    {
      AppMethodBeat.o(121960);
      return null;
    }
    Iterator localIterator = ((dhu)localObject).TOQ.iterator();
    localObject = null;
    if (localIterator.hasNext())
    {
      cpd localcpd = (cpd)localIterator.next();
      if ((localcpd == null) || (!paramString.equals(localcpd.key))) {
        break label102;
      }
      localObject = localcpd;
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
      paramString = ((cpd)localObject).value;
      AppMethodBeat.o(121960);
      return paramString;
    }
  }
  
  private static dhu dcP()
  {
    AppMethodBeat.i(121962);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.awZ("hell_ac_ble_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121962);
      return null;
    }
    dhu localdhu = new dhu();
    try
    {
      localdhu.parseFrom(arrayOfByte);
      AppMethodBeat.o(121962);
      return localdhu;
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
  
  public static void gC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121961);
    dhu localdhu = dcP();
    if (localdhu == null) {
      localdhu = new dhu();
    }
    for (;;)
    {
      Object localObject = localdhu.TOQ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        cpd localcpd = (cpd)((Iterator)localObject).next();
        if ((localcpd != null) && (paramString1.equals(localcpd.key))) {
          localdhu.TOQ.remove(localcpd);
        }
      }
      localObject = new cpd();
      ((cpd)localObject).key = paramString1;
      ((cpd)localObject).value = paramString2;
      localdhu.TOQ.add(localObject);
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.r("hell_ac_ble_mmkv_key", localdhu.toByteArray());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b
 * JD-Core Version:    0.7.0.1
 */