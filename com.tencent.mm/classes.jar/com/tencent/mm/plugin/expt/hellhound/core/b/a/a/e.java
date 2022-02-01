package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.protocal.protobuf.btm;
import com.tencent.mm.protocal.protobuf.cib;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.d;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  public static String Dg(int paramInt)
  {
    AppMethodBeat.i(121984);
    Object localObject = cpE();
    if (localObject == null)
    {
      AppMethodBeat.o(121984);
      return null;
    }
    localObject = ((cib)localObject).Huj.iterator();
    btm localbtm;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localbtm = (btm)((Iterator)localObject).next();
    } while ((localbtm == null) || (!String.valueOf(paramInt).equals(localbtm.key)));
    for (localObject = localbtm.value;; localObject = null)
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
  
  public static d<String, Boolean, String> Dh(int paramInt)
  {
    AppMethodBeat.i(121985);
    Object localObject = cpE();
    if (localObject == null)
    {
      AppMethodBeat.o(121985);
      return null;
    }
    localObject = ((cib)localObject).Huj.iterator();
    btm localbtm;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localbtm = (btm)((Iterator)localObject).next();
    } while ((localbtm == null) || (!String.valueOf(paramInt).equals(localbtm.key)));
    for (localObject = localbtm.value;; localObject = null)
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
      localObject = a.i(localObject[0], Boolean.valueOf(localObject[1]), localObject[2]);
      AppMethodBeat.o(121985);
      return localObject;
    }
  }
  
  public static void O(String paramString1, String paramString2, int paramInt)
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
      if (com.tencent.mm.plugin.expt.hellhound.core.b.aem(paramString1))
      {
        paramString2 = h.aeW(paramString1);
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
      fV(String.valueOf(paramInt), paramString1 + "|" + bool + "|" + paramString2);
      AppMethodBeat.o(121983);
      return;
    }
  }
  
  private static cib cpE()
  {
    AppMethodBeat.i(121987);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_key_page_se_dao");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121987);
      return null;
    }
    cib localcib = new cib();
    try
    {
      localcib.parseFrom(arrayOfByte);
      AppMethodBeat.o(121987);
      return localcib;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.printErrStackTrace("HABBYGE-MALI.PageStateDao", localException, "PageStateDao _doRead parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  private static void fV(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121986);
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
        com.tencent.mm.plugin.expt.hellhound.core.a.b.p("mmkv_key_page_se_dao", localcib.toByteArray());
        AppMethodBeat.o(121986);
        return;
      }
      catch (Exception paramString1)
      {
        ae.printErrStackTrace("HABBYGE-MALI.PageStateDao", paramString1, "PageStateDao writeBack", new Object[0]);
        AppMethodBeat.o(121986);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */