package com.tencent.mm.model.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.bc.k;
import com.tencent.mm.bc.l;
import com.tencent.mm.bc.o;
import com.tencent.mm.bc.t;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
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
  private static c gRt;
  private volatile boolean fOm;
  private ArrayList<a> fYf;
  private final int gRq;
  private final String gRr;
  private final long gRs;
  private SharedPreferences sp;
  
  private c()
  {
    AppMethodBeat.i(20464);
    this.gRq = 21;
    this.gRr = "trace_config_last_update_time";
    this.gRs = 86400000L;
    this.fOm = false;
    this.sp = aj.eFE();
    this.fYf = new ArrayList();
    AppMethodBeat.o(20464);
  }
  
  public static c atG()
  {
    AppMethodBeat.i(20465);
    if (gRt == null) {}
    try
    {
      if (gRt == null) {
        gRt = new c();
      }
      c localc = gRt;
      AppMethodBeat.o(20465);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(20465);
    }
  }
  
  private void nx(int paramInt)
  {
    AppMethodBeat.i(20467);
    t.azY();
    Object localObject1 = com.tencent.mm.bc.p.azV();
    Object localObject2 = t.azY().di(paramInt, 21);
    label466:
    for (;;)
    {
      try
      {
        Object localObject3 = bw.K(i.aMP(com.tencent.mm.vfs.q.B(new e((String)localObject1, (String)localObject2).mUri)), "TraceConfig");
        if (localObject3 == null)
        {
          ad.d("MicroMsg.TraceConfigUpdater", "summer kvMap is null and ret");
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
            long l = bt.getLong((String)((Map)localObject3).get(localObject1), -1L);
            if (l < 0L) {
              break label466;
            }
            ad.i("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig i: " + i + " key: " + (String)localObject4 + "|value: " + l);
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
        ad.printErrStackTrace("MicroMsg.TraceConfigUpdater", localIOException, "", new Object[0]);
        localo = t.azY().dg(paramInt, 21);
        localo.status = 2;
        t.azY().b(localo);
        AppMethodBeat.o(20467);
        return;
      }
      ad.d("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig configMap size: " + ((Map)localObject2).size());
      int j = this.fYf.size();
      int i = 0;
      while (i < j)
      {
        ((a)this.fYf.get(i)).atD();
        i += 1;
      }
    }
  }
  
  private void release()
  {
    AppMethodBeat.i(20468);
    ad.i("MicroMsg.TraceConfigUpdater", "summer release");
    this.fOm = false;
    az.aeS().b(159, this);
    az.aeS().b(160, this);
    AppMethodBeat.o(20468);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(20469);
    if ((parama != null) && (!this.fYf.contains(parama)))
    {
      boolean bool = this.fYf.add(parama);
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
    ad.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
    if ((!(paramn instanceof com.tencent.mm.al.p)) || (((com.tencent.mm.al.p)paramn).auQ() != 21))
    {
      ad.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd another scene and ret");
      AppMethodBeat.o(20466);
      return;
    }
    if (i == 159)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = t.azY().oA(21);
        if ((paramString == null) || (paramString.length == 0))
        {
          ad.i("MicroMsg.TraceConfigUpdater", "summer doDownload error no pkg found.");
          release();
          AppMethodBeat.o(20466);
          return;
        }
        paramString = paramString[0];
        ad.i("MicroMsg.TraceConfigUpdater", "summer doDownload pkg id:" + paramString.id + " version:" + paramString.version + " status:" + paramString.status + " type:" + paramString.dkC);
        if (5 == paramString.status)
        {
          paramString = new k(paramString.id, 21);
          az.aeS().a(paramString, 0);
          AppMethodBeat.o(20466);
          return;
        }
        ad.i("MicroMsg.TraceConfigUpdater", "summer pkgInfo has downloaded and release");
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
        nx(((k)paramn).hpw);
      }
      release();
    }
    AppMethodBeat.o(20466);
  }
  
  public static abstract interface a
  {
    public abstract void atD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.d.c
 * JD-Core Version:    0.7.0.1
 */