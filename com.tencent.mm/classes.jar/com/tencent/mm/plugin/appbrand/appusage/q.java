package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.protocal.protobuf.asv;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public enum q
{
  private static volatile long hbC;
  private static volatile asv hbD;
  private static final Set<q.b> hbE;
  
  static
  {
    AppMethodBeat.i(129616);
    hbF = new q[0];
    hbE = Collections.newSetFromMap(new ConcurrentHashMap());
    AppMethodBeat.o(129616);
  }
  
  public static void a(q.b paramb)
  {
    AppMethodBeat.i(129607);
    hbE.add(paramb);
    AppMethodBeat.o(129607);
  }
  
  public static boolean axe()
  {
    return true;
  }
  
  public static boolean axf()
  {
    AppMethodBeat.i(129609);
    switch (3.hbK[axg().ordinal()])
    {
    }
    do
    {
      AppMethodBeat.o(129609);
      return false;
      AppMethodBeat.o(129609);
      return false;
      AppMethodBeat.o(129609);
      return true;
      if (axh())
      {
        AppMethodBeat.o(129609);
        return true;
      }
    } while (hbD == null);
    if (hbD.jAI >= hbD.xhT)
    {
      AppMethodBeat.o(129609);
      return true;
    }
    AppMethodBeat.o(129609);
    return false;
  }
  
  static q.a axg()
  {
    int i = 0;
    AppMethodBeat.i(129611);
    if (!g.RG())
    {
      localObject = q.a.hbL;
      AppMethodBeat.o(129611);
      return localObject;
    }
    Object localObject = com.tencent.mm.model.c.c.abU().me("100215");
    if (((com.tencent.mm.storage.c)localObject).isValid())
    {
      int j = bo.getInt((String)((com.tencent.mm.storage.c)localObject).dvN().get("isOpenNewNearEntry"), 0);
      localObject = q.a.values();
      int k = localObject.length;
      while (i < k)
      {
        q.a locala = localObject[i];
        if (locala.value == j)
        {
          AppMethodBeat.o(129611);
          return locala;
        }
        i += 1;
      }
    }
    localObject = q.a.hbL;
    AppMethodBeat.o(129611);
    return localObject;
  }
  
  static boolean axh()
  {
    AppMethodBeat.i(129612);
    boolean bool = g.RL().Ru().getBoolean(ac.a.yDe, false);
    AppMethodBeat.o(129612);
    return bool;
  }
  
  static void axi()
  {
    AppMethodBeat.i(129613);
    g.RL().Ru().set(ac.a.yDe, Boolean.TRUE);
    AppMethodBeat.o(129613);
  }
  
  public static asv axj()
  {
    return hbD;
  }
  
  public static boolean axk()
  {
    AppMethodBeat.i(129614);
    long l2 = bo.aox();
    if ((!g.RG()) || (hbD == null)) {}
    for (long l1 = 0L; l2 >= l1; l1 = hbC)
    {
      AppMethodBeat.o(129614);
      return true;
    }
    AppMethodBeat.o(129614);
    return false;
  }
  
  public static void b(q.b paramb)
  {
    AppMethodBeat.i(129608);
    hbE.remove(paramb);
    AppMethodBeat.o(129608);
  }
  
  public static void clearData()
  {
    hbD = null;
  }
  
  public static boolean refresh()
  {
    AppMethodBeat.i(129610);
    hbD = null;
    hbC = 0L;
    Object localObject = axg();
    if (q.a.hbL == localObject)
    {
      AppMethodBeat.o(129610);
      return false;
    }
    localObject = new PBool();
    PBool localPBool = new PBool();
    ((PBool)localObject).value = false;
    localPBool.value = false;
    ap localap = new ap(Looper.getMainLooper(), new q.1(localPBool, (PBool)localObject), false);
    long l = TimeUnit.SECONDS.toMillis(20L);
    localap.ag(l, l);
    localObject = (b.a)com.tencent.mm.plugin.appbrand.t.e.bq(new q.2((PBool)localObject, localPBool));
    com.tencent.mm.modelgeo.d.agQ().b((b.a)localObject, false);
    AppMethodBeat.o(129610);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.q
 * JD-Core Version:    0.7.0.1
 */