package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.protocal.protobuf.dfx;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.d;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  public static String LB(int paramInt)
  {
    AppMethodBeat.i(121984);
    Object localObject = dJr();
    if (localObject == null)
    {
      AppMethodBeat.o(121984);
      return null;
    }
    localObject = ((eae)localObject).abfm.iterator();
    dfx localdfx;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localdfx = (dfx)((Iterator)localObject).next();
    } while ((localdfx == null) || (!String.valueOf(paramInt).equals(localdfx.key)));
    for (localObject = localdfx.value;; localObject = null)
    {
      if ((localObject == null) || (((String)localObject).equals("")))
      {
        AppMethodBeat.o(121984);
        return null;
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length != 3)
      {
        AppMethodBeat.o(121984);
        return null;
      }
      localObject = localObject[0];
      AppMethodBeat.o(121984);
      return localObject;
    }
  }
  
  public static d<String, Boolean, String> LC(int paramInt)
  {
    AppMethodBeat.i(121985);
    Object localObject = dJr();
    if (localObject == null)
    {
      AppMethodBeat.o(121985);
      return null;
    }
    localObject = ((eae)localObject).abfm.iterator();
    dfx localdfx;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localdfx = (dfx)((Iterator)localObject).next();
    } while ((localdfx == null) || (!String.valueOf(paramInt).equals(localdfx.key)));
    for (localObject = localdfx.value;; localObject = null)
    {
      if ((localObject == null) || (((String)localObject).equals("")))
      {
        AppMethodBeat.o(121985);
        return null;
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length != 3)
      {
        AppMethodBeat.o(121985);
        return null;
      }
      localObject = a.g(localObject[0], Boolean.valueOf(localObject[1]), localObject[2]);
      AppMethodBeat.o(121985);
      return localObject;
    }
  }
  
  public static void Y(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(121983);
    if ((paramString1 == null) || (paramString1.isEmpty()))
    {
      AppMethodBeat.o(121983);
      return;
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty(paramString2))
    {
      localObject1 = localObject2;
      if (com.tencent.mm.plugin.expt.hellhound.core.b.aqC(paramString1))
      {
        paramString2 = h.arq(paramString1);
        localObject1 = localObject2;
        if (paramString2 != null) {
          localObject1 = paramString2.getClass().getCanonicalName();
        }
      }
    }
    paramString2 = (String)localObject1;
    if (localObject1 == null) {
      paramString2 = "NULL";
    }
    if (!paramString2.equals("NULL")) {}
    for (boolean bool = true;; bool = false)
    {
      hj(String.valueOf(paramInt), paramString1 + "|" + bool + "|" + paramString2);
      AppMethodBeat.o(121983);
      return;
    }
  }
  
  private static eae dJr()
  {
    AppMethodBeat.i(121987);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.ard("mmkv_key_page_se_dao");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121987);
      return null;
    }
    eae localeae = new eae();
    try
    {
      localeae.parseFrom(arrayOfByte);
      AppMethodBeat.o(121987);
      return localeae;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.printErrStackTrace("HABBYGE-MALI.PageStateDao", localException, "PageStateDao _doRead parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  private static void hj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121986);
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
        com.tencent.mm.plugin.expt.hellhound.core.a.b.u("mmkv_key_page_se_dao", localeae.toByteArray());
        AppMethodBeat.o(121986);
        return;
      }
      catch (Exception paramString1)
      {
        Log.printErrStackTrace("HABBYGE-MALI.PageStateDao", paramString1, "PageStateDao writeBack", new Object[0]);
        AppMethodBeat.o(121986);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */