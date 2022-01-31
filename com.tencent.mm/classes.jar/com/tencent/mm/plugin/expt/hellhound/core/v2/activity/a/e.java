package com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.azc;
import com.tencent.mm.protocal.protobuf.bkf;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  private static bkf brN()
  {
    AppMethodBeat.i(152287);
    byte[] arrayOfByte = b.getBytes("mmkv_key_ac_se");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(152287);
      return null;
    }
    bkf localbkf = new bkf();
    try
    {
      localbkf.parseFrom(arrayOfByte);
      AppMethodBeat.o(152287);
      return localbkf;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace("ActivityStateDao", localException, "habbyge-mali, ActivityStateDao _doRead parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  public static void cf(String paramString, int paramInt)
  {
    AppMethodBeat.i(152284);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(152284);
      return;
    }
    eh(String.valueOf(paramInt), paramString);
    AppMethodBeat.o(152284);
  }
  
  private static void eh(String paramString1, String paramString2)
  {
    AppMethodBeat.i(152286);
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
        b.v("mmkv_key_ac_se", localbkf.toByteArray());
        AppMethodBeat.o(152286);
        return;
      }
      catch (Exception paramString1)
      {
        ab.printErrStackTrace("ActivityStateDao", paramString1, "habbyge-mali, ActivityStateDao writeBack", new Object[0]);
        AppMethodBeat.o(152286);
        return;
      }
    }
  }
  
  public static String vn(int paramInt)
  {
    AppMethodBeat.i(152285);
    Object localObject = brN();
    if (localObject == null)
    {
      AppMethodBeat.o(152285);
      return null;
    }
    localObject = ((bkf)localObject).xyH.iterator();
    azc localazc;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localazc = (azc)((Iterator)localObject).next();
    } while ((localazc == null) || (!String.valueOf(paramInt).equals(localazc.key)));
    for (localObject = localazc.value;; localObject = null)
    {
      AppMethodBeat.o(152285);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.v2.activity.a.e
 * JD-Core Version:    0.7.0.1
 */