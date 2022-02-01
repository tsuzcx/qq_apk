package com.tencent.mm.model.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.bb.k;
import com.tencent.mm.bb.l;
import com.tencent.mm.bb.o;
import com.tencent.mm.bb.t;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class c
  implements g
{
  private static c hrT;
  private volatile boolean fRX;
  private final int hrQ;
  private final String hrR;
  private final long hrS;
  private ArrayList<a> listeners;
  private SharedPreferences sp;
  
  private c()
  {
    AppMethodBeat.i(20464);
    this.hrQ = 21;
    this.hrR = "trace_config_last_update_time";
    this.hrS = 86400000L;
    this.fRX = false;
    this.sp = ai.eUY();
    this.listeners = new ArrayList();
    AppMethodBeat.o(20464);
  }
  
  public static c aAx()
  {
    AppMethodBeat.i(20465);
    if (hrT == null) {}
    try
    {
      if (hrT == null) {
        hrT = new c();
      }
      c localc = hrT;
      AppMethodBeat.o(20465);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(20465);
    }
  }
  
  private void ol(int paramInt)
  {
    AppMethodBeat.i(20467);
    t.aGO();
    Object localObject1 = com.tencent.mm.bb.p.aGL();
    Object localObject2 = t.aGO().di(paramInt, 21);
    label466:
    for (;;)
    {
      try
      {
        Object localObject3 = bv.L(i.aSr(com.tencent.mm.vfs.q.B(new e((String)localObject1, (String)localObject2).mUri)), "TraceConfig");
        if (localObject3 == null)
        {
          ac.d("MicroMsg.TraceConfigUpdater", "summer kvMap is null and ret");
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
            long l = bs.getLong((String)((Map)localObject3).get(localObject1), -1L);
            if (l < 0L) {
              break label466;
            }
            ac.i("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig i: " + i + " key: " + (String)localObject4 + "|value: " + l);
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
        o localo;
        localo.putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
      }
      catch (IOException localIOException)
      {
        ac.printErrStackTrace("MicroMsg.TraceConfigUpdater", localIOException, "", new Object[0]);
        localo = t.aGO().dg(paramInt, 21);
        localo.status = 2;
        t.aGO().b(localo);
        AppMethodBeat.o(20467);
        return;
      }
      ac.d("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig configMap size: " + ((Map)localObject2).size());
      int j = this.listeners.size();
      int i = 0;
      while (i < j)
      {
        ((a)this.listeners.get(i)).aAu();
        i += 1;
      }
    }
  }
  
  private void release()
  {
    AppMethodBeat.i(20468);
    ac.i("MicroMsg.TraceConfigUpdater", "summer release");
    this.fRX = false;
    az.agi().b(159, this);
    az.agi().b(160, this);
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
    ac.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
    if ((!(paramn instanceof com.tencent.mm.ak.p)) || (((com.tencent.mm.ak.p)paramn).aBJ() != 21))
    {
      ac.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd another scene and ret");
      AppMethodBeat.o(20466);
      return;
    }
    if (i == 159)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = t.aGO().po(21);
        if ((paramString == null) || (paramString.length == 0))
        {
          ac.i("MicroMsg.TraceConfigUpdater", "summer doDownload error no pkg found.");
          release();
          AppMethodBeat.o(20466);
          return;
        }
        paramString = paramString[0];
        ac.i("MicroMsg.TraceConfigUpdater", "summer doDownload pkg id:" + paramString.id + " version:" + paramString.version + " status:" + paramString.status + " type:" + paramString.dib);
        if (5 == paramString.status)
        {
          paramString = new k(paramString.id, 21);
          az.agi().a(paramString, 0);
          AppMethodBeat.o(20466);
          return;
        }
        ac.i("MicroMsg.TraceConfigUpdater", "summer pkgInfo has downloaded and release");
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
        ol(((k)paramn).hPY);
      }
      release();
    }
    AppMethodBeat.o(20466);
  }
  
  public static abstract interface a
  {
    public abstract void aAu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.d.c
 * JD-Core Version:    0.7.0.1
 */