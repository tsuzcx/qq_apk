package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bdr;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.c;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public enum q
{
  private static volatile bdr iUI;
  private static final Set<Object> iUJ;
  
  static
  {
    AppMethodBeat.i(44546);
    iUK = new q[0];
    iUJ = Collections.newSetFromMap(new ConcurrentHashMap());
    AppMethodBeat.o(44546);
  }
  
  public static boolean aRI()
  {
    return true;
  }
  
  public static boolean aRJ()
  {
    AppMethodBeat.i(44539);
    switch (1.iUL[aRK().ordinal()])
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
      if (aRL())
      {
        AppMethodBeat.o(44539);
        return true;
      }
    } while (iUI == null);
    if (iUI.msf >= iUI.DBe)
    {
      AppMethodBeat.o(44539);
      return true;
    }
    AppMethodBeat.o(44539);
    return false;
  }
  
  static a aRK()
  {
    int i = 0;
    AppMethodBeat.i(44541);
    if (!g.afw())
    {
      localObject = a.iUM;
      AppMethodBeat.o(44541);
      return localObject;
    }
    Object localObject = com.tencent.mm.model.c.d.aty().qu("100215");
    if (((c)localObject).isValid())
    {
      int j = bt.getInt((String)((c)localObject).eJy().get("isOpenNewNearEntry"), 0);
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
    localObject = a.iUM;
    AppMethodBeat.o(44541);
    return localObject;
  }
  
  static boolean aRL()
  {
    AppMethodBeat.i(44542);
    boolean bool = g.afB().afk().getBoolean(ae.a.FlA, false);
    AppMethodBeat.o(44542);
    return bool;
  }
  
  static void aRM()
  {
    AppMethodBeat.i(44543);
    g.afB().afk().set(ae.a.FlA, Boolean.TRUE);
    AppMethodBeat.o(44543);
  }
  
  public static bdr aRN()
  {
    return iUI;
  }
  
  public static void clearData()
  {
    iUI = null;
  }
  
  static enum a
  {
    final int value;
    
    static
    {
      AppMethodBeat.i(44534);
      iUM = new a("FORCE_OFF", 0, 0);
      iUN = new a("FORCE_ON", 1, 1);
      iUO = new a("DYNAMIC_THRESHOLD", 2, 2);
      iUP = new a[] { iUM, iUN, iUO };
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