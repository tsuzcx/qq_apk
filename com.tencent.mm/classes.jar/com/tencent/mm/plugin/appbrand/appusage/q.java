package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bza;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.c;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public enum q
{
  private static volatile bza kUT;
  private static final Set<Object> kUU;
  
  static
  {
    AppMethodBeat.i(44546);
    kUV = new q[0];
    kUU = Collections.newSetFromMap(new ConcurrentHashMap());
    AppMethodBeat.o(44546);
  }
  
  public static boolean bxV()
  {
    return true;
  }
  
  public static boolean bxW()
  {
    AppMethodBeat.i(44539);
    switch (1.kUW[bxX().ordinal()])
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
      if (bxY())
      {
        AppMethodBeat.o(44539);
        return true;
      }
    } while (kUT == null);
    if (kUT.oKX >= kUT.Mez)
    {
      AppMethodBeat.o(44539);
      return true;
    }
    AppMethodBeat.o(44539);
    return false;
  }
  
  static a bxX()
  {
    int i = 0;
    AppMethodBeat.i(44541);
    if (!g.aAc())
    {
      localObject = a.kUX;
      AppMethodBeat.o(44541);
      return localObject;
    }
    Object localObject = com.tencent.mm.model.c.d.aXu().Fu("100215");
    if (((c)localObject).isValid())
    {
      int j = Util.getInt((String)((c)localObject).gzz().get("isOpenNewNearEntry"), 0);
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
    localObject = a.kUY;
    AppMethodBeat.o(44541);
    return localObject;
  }
  
  static boolean bxY()
  {
    AppMethodBeat.i(44542);
    boolean bool = g.aAh().azQ().getBoolean(ar.a.NYg, false);
    AppMethodBeat.o(44542);
    return bool;
  }
  
  static void bxZ()
  {
    AppMethodBeat.i(44543);
    g.aAh().azQ().set(ar.a.NYg, Boolean.TRUE);
    AppMethodBeat.o(44543);
  }
  
  public static bza bya()
  {
    return kUT;
  }
  
  public static void clearData()
  {
    kUT = null;
  }
  
  static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(44534);
      kUX = new a("FORCE_OFF", 0, 0);
      kUY = new a("FORCE_ON", 1, 1);
      kUZ = new a("DYNAMIC_THRESHOLD", 2, 2);
      kVa = new a[] { kUX, kUY, kUZ };
      AppMethodBeat.o(44534);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.q
 * JD-Core Version:    0.7.0.1
 */