package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.c.ang;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.d;
import com.tencent.mm.storage.z;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public enum q
{
  private static volatile long fIK;
  private static volatile ang fIL;
  private static final Set<q.b> fIM = Collections.newSetFromMap(new ConcurrentHashMap());
  
  public static void a(q.b paramb)
  {
    if (paramb == null) {
      return;
    }
    fIM.add(paramb);
  }
  
  public static boolean acY()
  {
    return true;
  }
  
  public static boolean acZ()
  {
    switch (q.3.fIS[ada().ordinal()])
    {
    }
    do
    {
      return false;
      return true;
      if (adb()) {
        return true;
      }
    } while ((fIL == null) || (fIL.hHm < fIL.tjg));
    return true;
  }
  
  static q.a ada()
  {
    int i = 0;
    if (!g.DK())
    {
      localObject = q.a.fIT;
      return localObject;
    }
    Object localObject = com.tencent.mm.model.c.c.IX().fJ("100215");
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      int j = bk.getInt((String)((com.tencent.mm.storage.c)localObject).ctr().get("isOpenNewNearEntry"), 0);
      q.a[] arrayOfa = q.a.values();
      int k = arrayOfa.length;
      for (;;)
      {
        if (i >= k) {
          break label88;
        }
        q.a locala = arrayOfa[i];
        localObject = locala;
        if (locala.value == j) {
          break;
        }
        i += 1;
      }
    }
    label88:
    return q.a.fIT;
  }
  
  static boolean adb()
  {
    return g.DP().Dz().getBoolean(ac.a.ute, false);
  }
  
  static void adc()
  {
    g.DP().Dz().c(ac.a.ute, Boolean.valueOf(true));
  }
  
  public static ang ade()
  {
    return fIL;
  }
  
  public static boolean adf()
  {
    long l2 = bk.UX();
    if ((!g.DK()) || (fIL == null)) {}
    for (long l1 = 0L; l2 >= l1; l1 = fIK) {
      return true;
    }
    return false;
  }
  
  public static void adg()
  {
    fIL = null;
  }
  
  public static void b(q.b paramb)
  {
    if (paramb == null) {
      return;
    }
    fIM.remove(paramb);
  }
  
  public static boolean refresh()
  {
    fIL = null;
    fIK = 0L;
    Object localObject = ada();
    if (q.a.fIT == localObject) {
      return false;
    }
    localObject = new PBool();
    PBool localPBool = new PBool();
    ((PBool)localObject).value = false;
    localPBool.value = false;
    am localam = new am(Looper.getMainLooper(), new q.1(localPBool, (PBool)localObject), false);
    long l = TimeUnit.SECONDS.toMillis(20L);
    localam.S(l, l);
    localObject = (a.a)com.tencent.mm.plugin.appbrand.v.c.aU(new q.2((PBool)localObject, localPBool));
    com.tencent.mm.modelgeo.c.Ob().b((a.a)localObject, false);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.q
 * JD-Core Version:    0.7.0.1
 */