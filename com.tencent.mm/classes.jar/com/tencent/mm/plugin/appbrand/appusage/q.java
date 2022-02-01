package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.c;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public enum q
{
  private static volatile bhj juY;
  private static final Set<Object> juZ;
  
  static
  {
    AppMethodBeat.i(44546);
    jva = new q[0];
    juZ = Collections.newSetFromMap(new ConcurrentHashMap());
    AppMethodBeat.o(44546);
  }
  
  public static boolean aYD()
  {
    return true;
  }
  
  public static boolean aYE()
  {
    AppMethodBeat.i(44539);
    switch (1.jvb[aYF().ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(44539);
      return false;
      AppMethodBeat.o(44539);
      return false;
      AppMethodBeat.o(44539);
      return true;
      if (aYG())
      {
        AppMethodBeat.o(44539);
        return true;
      }
    } while (juY == null);
    if (juY.mUg >= juY.EWA)
    {
      AppMethodBeat.o(44539);
      return true;
    }
    AppMethodBeat.o(44539);
    return false;
  }
  
  static a aYF()
  {
    int i = 0;
    AppMethodBeat.i(44541);
    if (!g.agM())
    {
      localObject = a.jvc;
      AppMethodBeat.o(44541);
      return localObject;
    }
    Object localObject = com.tencent.mm.model.c.d.aAp().tJ("100215");
    if (((c)localObject).isValid())
    {
      int j = bs.getInt((String)((c)localObject).eYV().get("isOpenNewNearEntry"), 0);
      localObject = a.values();
      int k = localObject.length;
      while (i < k)
      {
        a locala = localObject[i];
        if (locala.value == j)
        {
          AppMethodBeat.o(44541);
          return locala;
        }
        i += 1;
      }
    }
    localObject = a.jvc;
    AppMethodBeat.o(44541);
    return localObject;
  }
  
  static boolean aYG()
  {
    AppMethodBeat.i(44542);
    boolean bool = g.agR().agA().getBoolean(ah.a.GJp, false);
    AppMethodBeat.o(44542);
    return bool;
  }
  
  static void aYH()
  {
    AppMethodBeat.i(44543);
    g.agR().agA().set(ah.a.GJp, Boolean.TRUE);
    AppMethodBeat.o(44543);
  }
  
  public static bhj aYI()
  {
    return juY;
  }
  
  public static void clearData()
  {
    juY = null;
  }
  
  static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(44534);
      jvc = new a("FORCE_OFF", 0, 0);
      jvd = new a("FORCE_ON", 1, 1);
      jve = new a("DYNAMIC_THRESHOLD", 2, 2);
      jvf = new a[] { jvc, jvd, jve };
      AppMethodBeat.o(44534);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.q
 * JD-Core Version:    0.7.0.1
 */