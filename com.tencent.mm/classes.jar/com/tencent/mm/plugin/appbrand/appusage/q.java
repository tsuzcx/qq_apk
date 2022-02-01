package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.blr;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.c;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public enum q
{
  private static volatile blr jOR;
  private static final Set<Object> jOS;
  
  static
  {
    AppMethodBeat.i(44546);
    jOT = new q[0];
    jOS = Collections.newSetFromMap(new ConcurrentHashMap());
    AppMethodBeat.o(44546);
  }
  
  public static boolean bcb()
  {
    return true;
  }
  
  public static boolean bcc()
  {
    AppMethodBeat.i(44539);
    switch (1.jOU[bcd().ordinal()])
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
      if (bce())
      {
        AppMethodBeat.o(44539);
        return true;
      }
    } while (jOR == null);
    if (jOR.nuE >= jOR.GFX)
    {
      AppMethodBeat.o(44539);
      return true;
    }
    AppMethodBeat.o(44539);
    return false;
  }
  
  static a bcd()
  {
    int i = 0;
    AppMethodBeat.i(44541);
    if (!g.ajx())
    {
      localObject = a.jOV;
      AppMethodBeat.o(44541);
      return localObject;
    }
    Object localObject = com.tencent.mm.model.c.d.aDs().wz("100215");
    if (((c)localObject).isValid())
    {
      int j = bt.getInt((String)((c)localObject).foF().get("isOpenNewNearEntry"), 0);
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
    localObject = a.jOV;
    AppMethodBeat.o(44541);
    return localObject;
  }
  
  static boolean bce()
  {
    AppMethodBeat.i(44542);
    boolean bool = g.ajC().ajl().getBoolean(al.a.IvH, false);
    AppMethodBeat.o(44542);
    return bool;
  }
  
  static void bcf()
  {
    AppMethodBeat.i(44543);
    g.ajC().ajl().set(al.a.IvH, Boolean.TRUE);
    AppMethodBeat.o(44543);
  }
  
  public static blr bcg()
  {
    return jOR;
  }
  
  public static void clearData()
  {
    jOR = null;
  }
  
  static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(44534);
      jOV = new a("FORCE_OFF", 0, 0);
      jOW = new a("FORCE_ON", 1, 1);
      jOX = new a("DYNAMIC_THRESHOLD", 2, 2);
      jOY = new a[] { jOV, jOW, jOX };
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