package com.tencent.kinda.framework.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.b;
import com.tencent.mm.model.q;
import java.util.HashMap;

public class SubCoreKinda
  implements at
{
  public static final String TAG = "MicroMsg.SubCoreKinda";
  private static HashMap<Integer, h.d> baseDBFactories;
  private KindaCacheStg cacheStg;
  private KindaConfigCacheStg configCacheStg;
  
  static
  {
    AppMethodBeat.i(144458);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("KindaCacheTable".hashCode()), new SubCoreKinda.1());
    AppMethodBeat.o(144458);
  }
  
  public static SubCoreKinda getCore()
  {
    AppMethodBeat.i(144455);
    SubCoreKinda localSubCoreKinda = (SubCoreKinda)q.S(SubCoreKinda.class);
    AppMethodBeat.o(144455);
    return localSubCoreKinda;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public KindaCacheStg getCacheStg()
  {
    AppMethodBeat.i(144457);
    if (!g.RG())
    {
      localObject = new b();
      AppMethodBeat.o(144457);
      throw ((Throwable)localObject);
    }
    if (getCore().cacheStg == null) {
      getCore().cacheStg = new KindaCacheStg(g.RL().eHS);
    }
    Object localObject = getCore().cacheStg;
    AppMethodBeat.o(144457);
    return localObject;
  }
  
  public KindaConfigCacheStg getConfigCacheStg()
  {
    AppMethodBeat.i(144456);
    if (!g.RG())
    {
      localObject = new b();
      AppMethodBeat.o(144456);
      throw ((Throwable)localObject);
    }
    if (getCore().configCacheStg == null) {
      getCore().configCacheStg = new KindaConfigCacheStg(g.RL().eHS);
    }
    Object localObject = getCore().configCacheStg;
    AppMethodBeat.o(144456);
    return localObject;
  }
  
  public void onAccountPostReset(boolean paramBoolean) {}
  
  public void onAccountRelease() {}
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.app.SubCoreKinda
 * JD-Core Version:    0.7.0.1
 */