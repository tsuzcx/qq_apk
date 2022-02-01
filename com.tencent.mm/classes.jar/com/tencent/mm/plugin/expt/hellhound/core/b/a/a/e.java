package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.protocal.protobuf.cpd;
import com.tencent.mm.protocal.protobuf.dhu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.d;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  public static String KB(int paramInt)
  {
    AppMethodBeat.i(121984);
    Object localObject = dcP();
    if (localObject == null)
    {
      AppMethodBeat.o(121984);
      return null;
    }
    localObject = ((dhu)localObject).TOQ.iterator();
    cpd localcpd;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localcpd = (cpd)((Iterator)localObject).next();
    } while ((localcpd == null) || (!String.valueOf(paramInt).equals(localcpd.key)));
    for (localObject = localcpd.value;; localObject = null)
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
  
  public static d<String, Boolean, String> KC(int paramInt)
  {
    AppMethodBeat.i(121985);
    Object localObject = dcP();
    if (localObject == null)
    {
      AppMethodBeat.o(121985);
      return null;
    }
    localObject = ((dhu)localObject).TOQ.iterator();
    cpd localcpd;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localcpd = (cpd)((Iterator)localObject).next();
    } while ((localcpd == null) || (!String.valueOf(paramInt).equals(localcpd.key)));
    for (localObject = localcpd.value;; localObject = null)
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
      localObject = a.h(localObject[0], Boolean.valueOf(localObject[1]), localObject[2]);
      AppMethodBeat.o(121985);
      return localObject;
    }
  }
  
  public static void R(String paramString1, String paramString2, int paramInt)
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
      if (com.tencent.mm.plugin.expt.hellhound.core.b.awy(paramString1))
      {
        paramString2 = h.axm(paramString1);
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
      gC(String.valueOf(paramInt), paramString1 + "|" + bool + "|" + paramString2);
      AppMethodBeat.o(121983);
      return;
    }
  }
  
  private static dhu dcP()
  {
    AppMethodBeat.i(121987);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.awZ("mmkv_key_page_se_dao");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121987);
      return null;
    }
    dhu localdhu = new dhu();
    try
    {
      localdhu.parseFrom(arrayOfByte);
      AppMethodBeat.o(121987);
      return localdhu;
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
  
  private static void gC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121986);
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
        com.tencent.mm.plugin.expt.hellhound.core.a.b.r("mmkv_key_page_se_dao", localdhu.toByteArray());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */