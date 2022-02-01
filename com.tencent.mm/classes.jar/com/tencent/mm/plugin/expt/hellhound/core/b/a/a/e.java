package com.tencent.mm.plugin.expt.hellhound.core.b.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.h;
import com.tencent.mm.protocal.protobuf.bss;
import com.tencent.mm.protocal.protobuf.chh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.vending.j.a;
import com.tencent.mm.vending.j.d;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  public static String CT(int paramInt)
  {
    AppMethodBeat.i(121984);
    Object localObject = coc();
    if (localObject == null)
    {
      AppMethodBeat.o(121984);
      return null;
    }
    localObject = ((chh)localObject).HaJ.iterator();
    bss localbss;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localbss = (bss)((Iterator)localObject).next();
    } while ((localbss == null) || (!String.valueOf(paramInt).equals(localbss.key)));
    for (localObject = localbss.value;; localObject = null)
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
  
  public static d<String, Boolean, String> CU(int paramInt)
  {
    AppMethodBeat.i(121985);
    Object localObject = coc();
    if (localObject == null)
    {
      AppMethodBeat.o(121985);
      return null;
    }
    localObject = ((chh)localObject).HaJ.iterator();
    bss localbss;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localbss = (bss)((Iterator)localObject).next();
    } while ((localbss == null) || (!String.valueOf(paramInt).equals(localbss.key)));
    for (localObject = localbss.value;; localObject = null)
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
      if (com.tencent.mm.plugin.expt.hellhound.core.b.ads(paramString1))
      {
        paramString2 = h.aec(paramString1);
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
      fQ(String.valueOf(paramInt), paramString1 + "|" + bool + "|" + paramString2);
      AppMethodBeat.o(121983);
      return;
    }
  }
  
  private static chh coc()
  {
    AppMethodBeat.i(121987);
    byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("mmkv_key_page_se_dao");
    if ((arrayOfByte == null) || (arrayOfByte.length <= 0))
    {
      AppMethodBeat.o(121987);
      return null;
    }
    chh localchh = new chh();
    try
    {
      localchh.parseFrom(arrayOfByte);
      AppMethodBeat.o(121987);
      return localchh;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.printErrStackTrace("HABBYGE-MALI.PageStateDao", localException, "PageStateDao _doRead parse", new Object[0]);
        Object localObject = null;
      }
    }
  }
  
  private static void fQ(String paramString1, String paramString2)
  {
    AppMethodBeat.i(121986);
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
        com.tencent.mm.plugin.expt.hellhound.core.a.b.p("mmkv_key_page_se_dao", localchh.toByteArray());
        AppMethodBeat.o(121986);
        return;
      }
      catch (Exception paramString1)
      {
        ad.printErrStackTrace("HABBYGE-MALI.PageStateDao", paramString1, "PageStateDao writeBack", new Object[0]);
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