package com.tencent.mm.model.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.be.n;
import com.tencent.mm.be.o;
import com.tencent.mm.be.r;
import com.tencent.mm.be.w;
import com.tencent.mm.model.bh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.u;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class c
  implements i
{
  private static c lym;
  private volatile boolean jJQ;
  private ArrayList<a> listeners;
  private final int lyj;
  private final String lyk;
  private final long lyl;
  private SharedPreferences sp;
  
  private c()
  {
    AppMethodBeat.i(20464);
    this.lyj = 21;
    this.lyk = "trace_config_last_update_time";
    this.lyl = 86400000L;
    this.jJQ = false;
    this.sp = MMApplicationContext.getDefaultPreference();
    this.listeners = new ArrayList();
    AppMethodBeat.o(20464);
  }
  
  public static c bgK()
  {
    AppMethodBeat.i(20465);
    if (lym == null) {}
    try
    {
      if (lym == null) {
        lym = new c();
      }
      c localc = lym;
      AppMethodBeat.o(20465);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(20465);
    }
  }
  
  private void release()
  {
    AppMethodBeat.i(20468);
    Log.i("MicroMsg.TraceConfigUpdater", "summer release");
    this.jJQ = false;
    bh.aGY().b(159, this);
    bh.aGY().b(160, this);
    AppMethodBeat.o(20468);
  }
  
  private void vz(int paramInt)
  {
    AppMethodBeat.i(20467);
    w.bnU();
    Object localObject1 = com.tencent.mm.be.s.bnR();
    Object localObject2 = w.bnU().dS(paramInt, 21);
    label464:
    for (;;)
    {
      try
      {
        Object localObject3 = XmlParser.parseXml(u.bBS(new com.tencent.mm.vfs.q((String)localObject1, (String)localObject2).getPath()), "TraceConfig", null);
        if (localObject3 == null)
        {
          Log.d("MicroMsg.TraceConfigUpdater", "summer kvMap is null and ret");
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
            long l = Util.getLong((String)((Map)localObject3).get(localObject1), -1L);
            if (l < 0L) {
              break label464;
            }
            Log.i("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig i: " + i + " key: " + (String)localObject4 + "|value: " + l);
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
        r localr;
        localr.putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.TraceConfigUpdater", localIOException, "", new Object[0]);
        localr = w.bnU().dQ(paramInt, 21);
        localr.status = 2;
        w.bnU().b(localr);
        AppMethodBeat.o(20467);
        return;
      }
      Log.d("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig configMap size: " + ((Map)localObject2).size());
      int j = this.listeners.size();
      int i = 0;
      while (i < j)
      {
        ((a)this.listeners.get(i)).bgG();
        i += 1;
      }
    }
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(20466);
    int i = paramq.getType();
    Log.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
    if ((!(paramq instanceof com.tencent.mm.an.s)) || (((com.tencent.mm.an.s)paramq).big() != 21))
    {
      Log.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd another scene and ret");
      AppMethodBeat.o(20466);
      return;
    }
    if (i == 159)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = w.bnU().wJ(21);
        if ((paramString == null) || (paramString.length == 0))
        {
          Log.i("MicroMsg.TraceConfigUpdater", "summer doDownload error no pkg found.");
          release();
          AppMethodBeat.o(20466);
          return;
        }
        paramString = paramString[0];
        Log.i("MicroMsg.TraceConfigUpdater", "summer doDownload pkg id:" + paramString.id + " version:" + paramString.version + " status:" + paramString.status + " type:" + paramString.fES);
        if (5 == paramString.status)
        {
          paramString = new n(paramString.id, 21);
          bh.aGY().a(paramString, 0);
          AppMethodBeat.o(20466);
          return;
        }
        Log.i("MicroMsg.TraceConfigUpdater", "summer pkgInfo has downloaded and release");
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
        vz(((n)paramq).lXR);
      }
      release();
    }
    AppMethodBeat.o(20466);
  }
  
  public static abstract interface a
  {
    public abstract void bgG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.d.c
 * JD-Core Version:    0.7.0.1
 */