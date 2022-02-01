package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.cgu;
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
  private static volatile cgu nPg;
  private static final Set<Object> nPh;
  
  static
  {
    AppMethodBeat.i(44546);
    nPi = new q[0];
    nPh = Collections.newSetFromMap(new ConcurrentHashMap());
    AppMethodBeat.o(44546);
  }
  
  public static boolean bJk()
  {
    return true;
  }
  
  public static boolean bJl()
  {
    AppMethodBeat.i(44539);
    switch (1.nPj[bJm().ordinal()])
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
      if (bJn())
      {
        AppMethodBeat.o(44539);
        return true;
      }
    } while (nPg == null);
    if (nPg.rMN >= nPg.Tob)
    {
      AppMethodBeat.o(44539);
      return true;
    }
    AppMethodBeat.o(44539);
    return false;
  }
  
  static a bJm()
  {
    int i = 0;
    AppMethodBeat.i(44541);
    if (!h.aHB())
    {
      localObject = a.nPk;
      AppMethodBeat.o(44541);
      return localObject;
    }
    Object localObject = com.tencent.mm.model.c.d.bgB().Mu("100215");
    if (((c)localObject).isValid())
    {
      int j = Util.getInt((String)((c)localObject).hvz().get("isOpenNewNearEntry"), 0);
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
    localObject = a.nPl;
    AppMethodBeat.o(44541);
    return localObject;
  }
  
  static boolean bJn()
  {
    AppMethodBeat.i(44542);
    boolean bool = h.aHG().aHp().getBoolean(ar.a.Vmg, false);
    AppMethodBeat.o(44542);
    return bool;
  }
  
  static void bJo()
  {
    AppMethodBeat.i(44543);
    h.aHG().aHp().set(ar.a.Vmg, Boolean.TRUE);
    AppMethodBeat.o(44543);
  }
  
  public static cgu bJp()
  {
    return nPg;
  }
  
  public static void clearData()
  {
    nPg = null;
  }
  
  static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(44534);
      nPk = new a("FORCE_OFF", 0, 0);
      nPl = new a("FORCE_ON", 1, 1);
      nPm = new a("DYNAMIC_THRESHOLD", 2, 2);
      nPn = new a[] { nPk, nPl, nPm };
      AppMethodBeat.o(44534);
    }
    
    private a(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.q
 * JD-Core Version:    0.7.0.1
 */