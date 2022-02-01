package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.g;
import com.tencent.mm.protocal.protobuf.bkl;
import com.tencent.mm.protocal.protobuf.bxu;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.d;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  public static String Bq(int paramInt)
  {
    AppMethodBeat.i(121984);
    Object localObject = cbR();
    if (localObject == null)
    {
      AppMethodBeat.o(121984);
      return null;
    }
    localObject = ((bxu)localObject).DUn.iterator();
    bkl localbkl;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localbkl = (bkl)((Iterator)localObject).next();
    } while ((localbkl == null) || (!String.valueOf(paramInt).equals(localbkl.key)));
    for (localObject = localbkl.value;; localObject = null)
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
  
  public static d<String, Boolean, String> Br(int paramInt)
  {
    AppMethodBeat.i(121985);
    Object localObject = cbR();
    if (localObject == null)
    {
      AppMethodBeat.o(121985);
      return null;
    }
    localObject = ((bxu)localObject).DUn.iterator();
    bkl localbkl;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localbkl = (bkl)((Iterator)localObject).next();
    } while ((localbkl == null) || (!String.valueOf(paramInt).equals(localbkl.key)));
    for (localObject = localbkl.value;; localObject = null)
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
  
  public static void K(String paramString1, String paramString2, int paramInt)
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
      if (com.tencent.mm.plugin.expt.hellhound.core.b.Vt(paramString1))
      {
        paramString2 = g.VZ(paramString1);
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
      fu(String.valueOf(paramInt), paramString1 + "|" + bool + "|" + paramString2);
      AppMethodBeat.o(121983);
      return;
    }
  }
  
  private static bxu cbR()
  {
    AppMethodBeat.i(121987);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_key_page_se_dao");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121987);
      return null;
    }
    bxu localbxu = new bxu();
    try
    {
      localbxu.parseFrom(arrayOfByte);
      AppMethodBeat.o(121987);
      return localbxu;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("PageStateDao", localException, "habbyge-mali, PageStateDao _doRead parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  private static void fu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121986);
    bxu localbxu = cbR();
    if (localbxu == null) {
      localbxu = new bxu();
    }
    for (;;)
    {
      Object localObject = localbxu.DUn.iterator();
      while (((Iterator)localObject).hasNext())
      {
        bkl localbkl = (bkl)((Iterator)localObject).next();
        if ((localbkl != null) && (paramString1.equals(localbkl.key))) {
          localbxu.DUn.remove(localbkl);
        }
      }
      localObject = new bkl();
      ((bkl)localObject).key = paramString1;
      ((bkl)localObject).value = paramString2;
      localbxu.DUn.add(localObject);
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.o("mmkv_key_page_se_dao", localbxu.toByteArray());
        AppMethodBeat.o(121986);
        return;
      }
      catch (Exception paramString1)
      {
        ad.printErrStackTrace("PageStateDao", paramString1, "habbyge-mali, PageStateDao writeBack", new Object[0]);
        AppMethodBeat.o(121986);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e
 * JD-Core Version:    0.7.0.1
 */