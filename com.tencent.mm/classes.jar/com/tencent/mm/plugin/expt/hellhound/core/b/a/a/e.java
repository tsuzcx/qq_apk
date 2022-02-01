package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.g;
import com.tencent.mm.protocal.protobuf.bof;
import com.tencent.mm.protocal.protobuf.ccp;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.d;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  public static String Ci(int paramInt)
  {
    AppMethodBeat.i(121984);
    Object localObject = cjc();
    if (localObject == null)
    {
      AppMethodBeat.o(121984);
      return null;
    }
    localObject = ((ccp)localObject).Fra.iterator();
    bof localbof;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localbof = (bof)((Iterator)localObject).next();
    } while ((localbof == null) || (!String.valueOf(paramInt).equals(localbof.key)));
    for (localObject = localbof.value;; localObject = null)
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
  
  public static d<String, Boolean, String> Cj(int paramInt)
  {
    AppMethodBeat.i(121985);
    Object localObject = cjc();
    if (localObject == null)
    {
      AppMethodBeat.o(121985);
      return null;
    }
    localObject = ((ccp)localObject).Fra.iterator();
    bof localbof;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localbof = (bof)((Iterator)localObject).next();
    } while ((localbof == null) || (!String.valueOf(paramInt).equals(localbof.key)));
    for (localObject = localbof.value;; localObject = null)
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
  
  public static void L(String paramString1, String paramString2, int paramInt)
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
      if (com.tencent.mm.plugin.expt.hellhound.core.b.ZF(paramString1))
      {
        paramString2 = g.aao(paramString1);
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
      fH(String.valueOf(paramInt), paramString1 + "|" + bool + "|" + paramString2);
      AppMethodBeat.o(121983);
      return;
    }
  }
  
  private static ccp cjc()
  {
    AppMethodBeat.i(121987);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_key_page_se_dao");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121987);
      return null;
    }
    ccp localccp = new ccp();
    try
    {
      localccp.parseFrom(arrayOfByte);
      AppMethodBeat.o(121987);
      return localccp;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.printErrStackTrace("PageStateDao", localException, "habbyge-mali, PageStateDao _doRead parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  private static void fH(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121986);
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
        com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_key_page_se_dao", localccp.toByteArray());
        AppMethodBeat.o(121986);
        return;
      }
      catch (Exception paramString1)
      {
        ac.printErrStackTrace("PageStateDao", paramString1, "habbyge-mali, PageStateDao writeBack", new Object[0]);
        AppMethodBeat.o(121986);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */