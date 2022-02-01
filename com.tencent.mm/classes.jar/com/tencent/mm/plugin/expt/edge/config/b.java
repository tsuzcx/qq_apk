package com.tencent.mm.plugin.expt.edge.config;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.plugin.expt.e.d;
import com.tencent.mm.protocal.protobuf.ame;
import com.tencent.mm.protocal.protobuf.amg;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.c.i;

public class b
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.b.c
{
  private static volatile b zyz;
  private Map<String, com.tencent.mm.plugin.expt.edge.e.a.b> zyA;
  public Map<String, com.tencent.mm.plugin.expt.edge.e.a.c> zyB;
  public Map<String, List<com.tencent.mm.plugin.expt.edge.e.a.b>> zyC;
  private MMHandler zyD;
  private a zyE;
  public c zyF;
  private final IListener zyG;
  private final IListener zyH;
  private final IListener zyI;
  private final IListener zyJ;
  private final IListener zyK;
  private final IListener zyL;
  
  private b()
  {
    AppMethodBeat.i(299810);
    this.zyG = new EdgeComputingConfigService.3(this, f.hfK);
    this.zyH = new EdgeComputingConfigService.4(this, f.hfK);
    this.zyI = new EdgeComputingConfigService.5(this, f.hfK);
    this.zyJ = new EdgeComputingConfigService.6(this, f.hfK);
    this.zyK = new EdgeComputingConfigService.7(this, f.hfK);
    this.zyL = new EdgeComputingConfigService.8(this, f.hfK);
    this.zyA = new HashMap();
    this.zyB = new HashMap();
    this.zyC = new HashMap();
    this.zyD = new MMHandler("EdgeComputingConfigService#mParseConfigHandler");
    this.zyE = new a();
    initConfig();
    dIj();
    this.zyK.alive();
    this.zyL.alive();
    this.zyG.alive();
    this.zyH.alive();
    this.zyI.alive();
    this.zyJ.alive();
    AppMethodBeat.o(299810);
  }
  
  public static b dIg()
  {
    AppMethodBeat.i(299802);
    if (zyz == null) {}
    try
    {
      if (zyz == null) {
        zyz = new b();
      }
      b localb = zyz;
      AppMethodBeat.o(299802);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(299802);
    }
  }
  
  private void dIj()
  {
    AppMethodBeat.i(299831);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.zyA.values().iterator();
    while (localIterator.hasNext())
    {
      com.tencent.mm.plugin.expt.edge.e.a.b localb = (com.tencent.mm.plugin.expt.edge.e.a.b)localIterator.next();
      if ((localb.zzV == 1) && (localb.zzW > 0))
      {
        List localList = (List)localHashMap.get(String.valueOf(localb.zzW));
        Object localObject = localList;
        if (localList == null)
        {
          localObject = new ArrayList();
          localHashMap.put(String.valueOf(localb.zzW), localObject);
        }
        ((List)localObject).add(localb);
      }
    }
    this.zyC = localHashMap;
    AppMethodBeat.o(299831);
  }
  
  private void initConfig()
  {
    AppMethodBeat.i(299822);
    Object localObject1 = new StringBuilder("[EdgeComputingConfigService] initConfig, uin : ");
    d.dNI();
    Log.i("EdgeComputingConfigService", d.getUin());
    localObject1 = com.tencent.mm.plugin.expt.edge.b.dHZ();
    if (localObject1 == null)
    {
      AppMethodBeat.o(299822);
      return;
    }
    Object localObject2 = ((MultiProcessMMKV)localObject1).decodeBytes("mmkv_key_script_config_container");
    Object localObject4;
    if ((localObject2 != null) && (localObject2.length > 0))
    {
      localObject4 = new ame();
      try
      {
        ((ame)localObject4).parseFrom((byte[])localObject2);
        localObject2 = com.tencent.mm.plugin.expt.edge.e.c.a((ame)localObject4);
        if (localObject2 != null)
        {
          localObject4 = ((Map)localObject2).values().iterator();
          while (((Iterator)localObject4).hasNext())
          {
            com.tencent.mm.plugin.expt.edge.e.a.b localb = (com.tencent.mm.plugin.expt.edge.e.a.b)((Iterator)localObject4).next();
            Log.i("EdgeComputingConfigService", "[EdgeComputingConfigService] initConfig, scriptConfigModel configID : " + localb.zzS);
          }
        }
        localObject1 = ((MultiProcessMMKV)localObject1).decodeBytes("mmkv_key_sql_config_container");
      }
      catch (Exception localException2)
      {
        Log.e("EdgeComputingConfigService", "[EdgeComputingConfigService] initConfig parse script config throw Exception : " + localException2.getMessage());
      }
    }
    for (;;)
    {
      Object localObject3;
      if ((localObject1 != null) && (localObject1.length > 0))
      {
        localObject3 = new amg();
        try
        {
          ((amg)localObject3).parseFrom((byte[])localObject1);
          localObject1 = com.tencent.mm.plugin.expt.edge.e.c.a((amg)localObject3);
          if (localObject1 == null) {
            break label322;
          }
          localObject3 = ((Map)localObject1).values().iterator();
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (com.tencent.mm.plugin.expt.edge.e.a.c)((Iterator)localObject3).next();
            Log.i("EdgeComputingConfigService", "[EdgeComputingConfigService] initConfig, sqlConfigModel configID : " + ((com.tencent.mm.plugin.expt.edge.e.a.c)localObject4).zzS);
          }
          AppMethodBeat.o(299822);
        }
        catch (Exception localException1)
        {
          Log.e("EdgeComputingConfigService", "[EdgeComputingConfigService] initConfig parse sql config throw Exception : " + localException1.getMessage());
        }
      }
      return;
      this.zyA = ((Map)localObject3);
    }
    this.zyB = localException1;
    label322:
    AppMethodBeat.o(299822);
  }
  
  public final List<com.tencent.mm.plugin.expt.edge.e.a.b> dIh()
  {
    AppMethodBeat.i(299874);
    ArrayList localArrayList = new ArrayList();
    synchronized (this.zyA)
    {
      Iterator localIterator = this.zyA.values().iterator();
      if (localIterator.hasNext()) {
        localArrayList.add((com.tencent.mm.plugin.expt.edge.e.a.b)localIterator.next());
      }
    }
    Collections.sort(localList, new Comparator() {});
    AppMethodBeat.o(299874);
    return localList;
  }
  
  public final List<com.tencent.mm.plugin.expt.edge.e.a.c> dIi()
  {
    AppMethodBeat.i(299878);
    ArrayList localArrayList = new ArrayList();
    synchronized (this.zyB)
    {
      Iterator localIterator = this.zyB.values().iterator();
      if (localIterator.hasNext()) {
        localArrayList.add((com.tencent.mm.plugin.expt.edge.e.a.c)localIterator.next());
      }
    }
    Collections.sort(localList, new Comparator() {});
    AppMethodBeat.o(299878);
    return localList;
  }
  
  public final void dIk()
  {
    AppMethodBeat.i(299885);
    amg localamg = com.tencent.mm.plugin.expt.edge.e.c.ag(this.zyB);
    if (localamg != null)
    {
      MultiProcessMMKV localMultiProcessMMKV = com.tencent.mm.plugin.expt.edge.b.dHZ();
      if (localMultiProcessMMKV != null) {
        try
        {
          Log.i("EdgeComputingConfigService", "[EdgeComputingConfigService] mSessionEdgeSqlChangeEvent encode mmkvEncode : ".concat(String.valueOf(localMultiProcessMMKV.encode("mmkv_key_sql_config_container", localamg.toByteArray()))));
          AppMethodBeat.o(299885);
          return;
        }
        catch (IOException localIOException)
        {
          Log.e("EdgeComputingConfigService", "[EdgeComputingConfigService] mSessionEdgeSqlChangeEvent encode throw IOException : " + localIOException.getMessage());
        }
      }
    }
    AppMethodBeat.o(299885);
  }
  
  public final void dIl()
  {
    AppMethodBeat.i(299902);
    this.zyD.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(299807);
        Iterator localIterator = b.a(b.this).values().iterator();
        String str;
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.expt.edge.e.a.b localb = (com.tencent.mm.plugin.expt.edge.e.a.b)localIterator.next();
          if ((i.hm(localb.script)) && (!i.hm(localb.zAe)))
          {
            str = com.tencent.mm.plugin.expt.edge.b.aqi(localb.zAe);
            if (!i.hm(str)) {
              try
              {
                localb.script = new String(Base64.decode(str, 0), "UTF-8");
                b.e(b.this);
                com.tencent.mm.plugin.expt.edge.f.a.oH(true);
              }
              catch (Exception localException1)
              {
                Log.e("EdgeComputingConfigService", "EdgeComputingConfigService [tryToDownloadScript] throw Exception : " + localException1.getMessage());
              }
            } else {
              com.tencent.mm.plugin.expt.edge.f.a.oH(false);
            }
          }
        }
        localIterator = b.g(b.this).values().iterator();
        while (localIterator.hasNext())
        {
          com.tencent.mm.plugin.expt.edge.e.a.c localc = (com.tencent.mm.plugin.expt.edge.e.a.c)localIterator.next();
          if ((i.hm(localc.sql)) && (!i.hm(localc.zAh)))
          {
            str = com.tencent.mm.plugin.expt.edge.b.aqi(localc.zAh);
            if (!i.hm(str)) {
              try
              {
                localc.sql = new String(Base64.decode(str, 0), "UTF-8");
                b.h(b.this);
                com.tencent.mm.plugin.expt.edge.f.a.oH(true);
              }
              catch (Exception localException2)
              {
                Log.e("EdgeComputingConfigService", "EdgeComputingConfigService [tryToDownloadScript] throw Exception : " + localException2.getMessage());
              }
            } else {
              com.tencent.mm.plugin.expt.edge.f.a.oH(false);
            }
          }
        }
        AppMethodBeat.o(299807);
      }
    });
    AppMethodBeat.o(299902);
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(299890);
    paramc = new StringBuilder("[EdgeComputingConfigService] onAccountInitialized, uin : ");
    d.dNI();
    Log.i("EdgeComputingConfigService", d.getUin());
    this.zyA = new HashMap();
    this.zyB = new HashMap();
    this.zyC = new HashMap();
    initConfig();
    dIj();
    AppMethodBeat.o(299890);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(299895);
    StringBuilder localStringBuilder = new StringBuilder("[EdgeComputingConfigService] onAccountRåelease, uin : ");
    d.dNI();
    Log.i("EdgeComputingConfigService", d.getUin());
    this.zyA = new HashMap();
    this.zyB = new HashMap();
    this.zyC = new HashMap();
    AppMethodBeat.o(299895);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.config.b
 * JD-Core Version:    0.7.0.1
 */