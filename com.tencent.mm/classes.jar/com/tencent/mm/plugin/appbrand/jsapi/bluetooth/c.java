package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.luggage.b.e;
import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.appbrand.p.a;
import java.util.ArrayList;

public final class c
{
  public static void bU(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey = new IDKey();
    localIDKey.SetID(762);
    localIDKey.SetKey(paramInt1);
    localIDKey.SetValue(1L);
    localArrayList.add(localIDKey);
    localIDKey = new IDKey();
    localIDKey.SetID(762);
    localIDKey.SetKey(paramInt2);
    localIDKey.SetValue(1L);
    localArrayList.add(localIDKey);
    ((a)e.j(a.class)).m(localArrayList);
  }
  
  public static void jdMethod_if(int paramInt)
  {
    ((a)e.j(a.class)).d(762L, paramInt, 1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.bluetooth.c
 * JD-Core Version:    0.7.0.1
 */