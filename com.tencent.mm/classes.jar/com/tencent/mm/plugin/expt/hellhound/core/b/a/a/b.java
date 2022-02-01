package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bss;
import com.tencent.mm.protocal.protobuf.chh;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.LinkedList;

public final class b
{
  public static String aea(String paramString)
  {
    AppMethodBeat.i(121960);
    Object localObject = coc();
    if ((localObject == null) || (((chh)localObject).HaJ.isEmpty()))
    {
      AppMethodBeat.o(121960);
      return null;
    }
    Iterator localIterator = ((chh)localObject).HaJ.iterator();
    localObject = null;
    if (localIterator.hasNext())
    {
      bss localbss = (bss)localIterator.next();
      if ((localbss == null) || (!paramString.equals(localbss.key))) {
        break label102;
      }
      localObject = localbss;
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
      paramString = ((bss)localObject).value;
      AppMethodBeat.o(121960);
      return paramString;
    }
  }
  
  private static chh coc()
  {
    AppMethodBeat.i(121962);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("hell_ac_ble_mmkv_key");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121962);
      return null;
    }
    chh localchh = new chh();
    try
    {
      localchh.parseFrom(arrayOfByte);
      AppMethodBeat.o(121962);
      return localchh;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("HABBYGE-MALI.ActivityBundleDao", localException, "ActivityBundleDao _doRead parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  public static void fQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121961);
    chh localchh = coc();
    if (localchh == null) {
      localchh = new chh();
    }
    for (;;)
    {
      Object localObject = localchh.HaJ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bss localbss = (bss)((Iterator)localObject).next();
        if ((localbss != null) && (paramString1.equals(localbss.key))) {
          localchh.HaJ.remove(localbss);
        }
      }
      localObject = new bss();
      ((bss)localObject).key = paramString1;
      ((bss)localObject).value = paramString2;
      localchh.HaJ.add(localObject);
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_ac_ble_mmkv_key", localchh.toByteArray());
        AppMethodBeat.o(121961);
        return;
      }
      catch (Exception paramString1)
      {
        ad.printErrStackTrace("HABBYGE-MALI.ActivityBundleDao", paramString1, "ActivityBundleDao writeBack", new Object[0]);
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