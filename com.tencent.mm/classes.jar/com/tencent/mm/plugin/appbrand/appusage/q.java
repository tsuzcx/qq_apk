package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bmj;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.c;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public enum q
{
  private static volatile bmj jSj;
  private static final Set<Object> jSk;
  
  static
  {
    AppMethodBeat.i(44546);
    jSl = new q[0];
    jSk = Collections.newSetFromMap(new ConcurrentHashMap());
    AppMethodBeat.o(44546);
  }
  
  public static boolean bcG()
  {
    return true;
  }
  
  public static boolean bcH()
  {
    AppMethodBeat.i(44539);
    switch (1.jSm[bcI().ordinal()])
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
      if (bcJ())
      {
        AppMethodBeat.o(44539);
        return true;
      }
    } while (jSj == null);
    if (jSj.nzZ >= jSj.GZz)
    {
      AppMethodBeat.o(44539);
      return true;
    }
    AppMethodBeat.o(44539);
    return false;
  }
  
  static a bcI()
  {
    int i = 0;
    AppMethodBeat.i(44541);
    if (!g.ajM())
    {
      localObject = a.jSn;
      AppMethodBeat.o(44541);
      return localObject;
    }
    Object localObject = com.tencent.mm.model.c.d.aDI().xi("100215");
    if (((c)localObject).isValid())
    {
      int j = bu.getInt((String)((c)localObject).fsy().get("isOpenNewNearEntry"), 0);
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
    localObject = a.jSn;
    AppMethodBeat.o(44541);
    return localObject;
  }
  
  static boolean bcJ()
  {
    AppMethodBeat.i(44542);
    boolean bool = g.ajR().ajA().getBoolean(am.a.IQf, false);
    AppMethodBeat.o(44542);
    return bool;
  }
  
  static void bcK()
  {
    AppMethodBeat.i(44543);
    g.ajR().ajA().set(am.a.IQf, Boolean.TRUE);
    AppMethodBeat.o(44543);
  }
  
  public static bmj bcL()
  {
    return jSj;
  }
  
  public static void clearData()
  {
    jSj = null;
  }
  
  static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(44534);
      jSn = new a("FORCE_OFF", 0, 0);
      jSo = new a("FORCE_ON", 1, 1);
      jSp = new a("DYNAMIC_THRESHOLD", 2, 2);
      jSq = new a[] { jSn, jSo, jSp };
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