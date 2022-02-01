package com.tencent.kinda.framework.app;

import com.tencent.kinda.framework.jsapi.KindaJSInvokeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.b;
import com.tencent.mm.model.be;
import com.tencent.mm.model.y;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class SubCoreKinda
  implements be
{
  public static final String TAG = "MicroMsg.SubCoreKinda";
  private static HashMap<Integer, h.b> baseDBFactories;
  private KindaCacheStg cacheStg;
  private KindaConfigCacheStg configCacheStg;
  private KindaJSInvokeListener jsInvokeListener;
  
  static
  {
    AppMethodBeat.i(18566);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("KindaCacheTable".hashCode()), new h.b()
    {
      public String[] getSQLs()
      {
        return KindaCacheStg.SQL_CREATE;
      }
    });
    AppMethodBeat.o(18566);
  }
  
  public SubCoreKinda()
  {
    AppMethodBeat.i(226417);
    this.jsInvokeListener = new KindaJSInvokeListener();
    AppMethodBeat.o(226417);
  }
  
  public static SubCoreKinda getCore()
  {
    AppMethodBeat.i(18563);
    SubCoreKinda localSubCoreKinda = (SubCoreKinda)y.aL(SubCoreKinda.class);
    AppMethodBeat.o(18563);
    return localSubCoreKinda;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public KindaCacheStg getCacheStg()
  {
    AppMethodBeat.i(18565);
    if (!h.baz())
    {
      localObject = new b();
      AppMethodBeat.o(18565);
      throw ((Throwable)localObject);
    }
    if (getCore().cacheStg == null) {
      getCore().cacheStg = new KindaCacheStg(h.baE().mCN);
    }
    Object localObject = getCore().cacheStg;
    AppMethodBeat.o(18565);
    return localObject;
  }
  
  public KindaConfigCacheStg getConfigCacheStg()
  {
    AppMethodBeat.i(18564);
    if (!h.baz())
    {
      localObject = new b();
      AppMethodBeat.o(18564);
      throw ((Throwable)localObject);
    }
    if (getCore().configCacheStg == null) {
      getCore().configCacheStg = new KindaConfigCacheStg(h.baE().mCN);
    }
    Object localObject = getCore().configCacheStg;
    AppMethodBeat.o(18564);
    return localObject;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(226430);
    this.jsInvokeListener.alive();
    AppMethodBeat.o(226430);
  }
  
  public void onAccountRelease() {}
  
  public void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(226434);
    this.jsInvokeListener.dead();
    AppMethodBeat.o(226434);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.app.SubCoreKinda
 * JD-Core Version:    0.7.0.1
 */