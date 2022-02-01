package com.tencent.mm.model.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.bb.l;
import com.tencent.mm.bb.t;
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.vfs.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class c
  implements f
{
  private static c hNe;
  private volatile boolean gnW;
  private final int hNb;
  private final String hNc;
  private final long hNd;
  private ArrayList<a> listeners;
  private SharedPreferences sp;
  
  private c()
  {
    AppMethodBeat.i(20464);
    this.hNb = 21;
    this.hNc = "trace_config_last_update_time";
    this.hNd = 86400000L;
    this.gnW = false;
    this.sp = ak.fox();
    this.listeners = new ArrayList();
    AppMethodBeat.o(20464);
  }
  
  public static c aDQ()
  {
    AppMethodBeat.i(20465);
    if (hNe == null) {}
    try
    {
      if (hNe == null) {
        hNe = new c();
      }
      c localc = hNe;
      AppMethodBeat.o(20465);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(20465);
    }
  }
  
  private void oO(int paramInt)
  {
    AppMethodBeat.i(20467);
    t.aKs();
    Object localObject1 = com.tencent.mm.bb.p.aKp();
    Object localObject2 = t.aKs().dl(paramInt, 21);
    label466:
    for (;;)
    {
      try
      {
        Object localObject3 = bx.M(com.tencent.mm.vfs.o.aZT(w.B(new com.tencent.mm.vfs.k((String)localObject1, (String)localObject2).mUri)), "TraceConfig");
        if (localObject3 == null)
        {
          ae.d("MicroMsg.TraceConfigUpdater", "summer kvMap is null and ret");
          AppMethodBeat.o(20467);
          return;
        }
        localObject2 = new HashMap();
        i = 0;
        Object localObject4 = new StringBuilder().append(".TraceConfig.Item");
        if (i == 0)
        {
          localObject1 = "";
          localObject1 = localObject1;
          localObject4 = (String)((Map)localObject3).get((String)localObject1 + ".$key");
          if (localObject4 != null)
          {
            i += 1;
            long l = bu.getLong((String)((Map)localObject3).get(localObject1), -1L);
            if (l < 0L) {
              break label466;
            }
            ae.i("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig i: " + i + " key: " + (String)localObject4 + "|value: " + l);
            ((Map)localObject2).put(localObject4, Long.valueOf(l));
          }
        }
        else
        {
          localObject1 = Integer.valueOf(i);
          continue;
        }
        localObject1 = this.sp.edit();
        localObject3 = ((Map)localObject2).entrySet().iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Map.Entry)((Iterator)localObject3).next();
          ((SharedPreferences.Editor)localObject1).putLong((String)((Map.Entry)localObject4).getKey(), ((Long)((Map.Entry)localObject4).getValue()).longValue());
          continue;
        }
        com.tencent.mm.bb.o localo;
        localo.putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
      }
      catch (IOException localIOException)
      {
        ae.printErrStackTrace("MicroMsg.TraceConfigUpdater", localIOException, "", new Object[0]);
        localo = t.aKs().dj(paramInt, 21);
        localo.status = 2;
        t.aKs().b(localo);
        AppMethodBeat.o(20467);
        return;
      }
      ae.d("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig configMap size: " + ((Map)localObject2).size());
      int j = this.listeners.size();
      int i = 0;
      while (i < j)
      {
        ((a)this.listeners.get(i)).aDN();
        i += 1;
      }
    }
  }
  
  private void release()
  {
    AppMethodBeat.i(20468);
    ae.i("MicroMsg.TraceConfigUpdater", "summer release");
    this.gnW = false;
    bc.ajj().b(159, this);
    bc.ajj().b(160, this);
    AppMethodBeat.o(20468);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(20469);
    if ((parama != null) && (!this.listeners.contains(parama)))
    {
      boolean bool = this.listeners.add(parama);
      AppMethodBeat.o(20469);
      return bool;
    }
    AppMethodBeat.o(20469);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(20466);
    int i = paramn.getType();
    ae.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
    if ((!(paramn instanceof com.tencent.mm.ak.p)) || (((com.tencent.mm.ak.p)paramn).aFc() != 21))
    {
      ae.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd another scene and ret");
      AppMethodBeat.o(20466);
      return;
    }
    if (i == 159)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = t.aKs().pU(21);
        if ((paramString == null) || (paramString.length == 0))
        {
          ae.i("MicroMsg.TraceConfigUpdater", "summer doDownload error no pkg found.");
          release();
          AppMethodBeat.o(20466);
          return;
        }
        paramString = paramString[0];
        ae.i("MicroMsg.TraceConfigUpdater", "summer doDownload pkg id:" + paramString.id + " version:" + paramString.version + " status:" + paramString.status + " type:" + paramString.duK);
        if (5 == paramString.status)
        {
          paramString = new com.tencent.mm.bb.k(paramString.id, 21);
          bc.ajj().a(paramString, 0);
          AppMethodBeat.o(20466);
          return;
        }
        ae.i("MicroMsg.TraceConfigUpdater", "summer pkgInfo has downloaded and release");
        this.sp.edit().putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
        release();
        AppMethodBeat.o(20466);
        return;
      }
      release();
      AppMethodBeat.o(20466);
      return;
    }
    if (i == 160)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        oO(((com.tencent.mm.bb.k)paramn).imf);
      }
      release();
    }
    AppMethodBeat.o(20466);
  }
  
  public static abstract interface a
  {
    public abstract void aDN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.d.c
 * JD-Core Version:    0.7.0.1
 */