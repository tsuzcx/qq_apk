package com.tencent.mm.model.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.bb.m;
import com.tencent.mm.bb.n;
import com.tencent.mm.bb.r;
import com.tencent.mm.bb.v;
import com.tencent.mm.model.bg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
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
  private static c iIk;
  private volatile boolean gYQ;
  private final int iIh;
  private final String iIi;
  private final long iIj;
  private ArrayList<a> listeners;
  private SharedPreferences sp;
  
  private c()
  {
    AppMethodBeat.i(20464);
    this.iIh = 21;
    this.iIi = "trace_config_last_update_time";
    this.iIj = 86400000L;
    this.gYQ = false;
    this.sp = MMApplicationContext.getDefaultPreference();
    this.listeners = new ArrayList();
    AppMethodBeat.o(20464);
  }
  
  public static c aXD()
  {
    AppMethodBeat.i(20465);
    if (iIk == null) {}
    try
    {
      if (iIk == null) {
        iIk = new c();
      }
      c localc = iIk;
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
    this.gYQ = false;
    bg.azz().b(159, this);
    bg.azz().b(160, this);
    AppMethodBeat.o(20468);
  }
  
  private void sC(int paramInt)
  {
    AppMethodBeat.i(20467);
    v.bev();
    Object localObject1 = r.bes();
    Object localObject2 = v.bev().dv(paramInt, 21);
    label467:
    for (;;)
    {
      try
      {
        Object localObject3 = XmlParser.parseXml(com.tencent.mm.vfs.s.boY(aa.z(new o((String)localObject1, (String)localObject2).mUri)), "TraceConfig", null);
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
              break label467;
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
        com.tencent.mm.bb.q localq;
        localq.putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.TraceConfigUpdater", localIOException, "", new Object[0]);
        localq = v.bev().dt(paramInt, 21);
        localq.status = 2;
        v.bev().b(localq);
        AppMethodBeat.o(20467);
        return;
      }
      Log.d("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig configMap size: " + ((Map)localObject2).size());
      int j = this.listeners.size();
      int i = 0;
      while (i < j)
      {
        ((a)this.listeners.get(i)).aXz();
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(20466);
    int i = paramq.getType();
    Log.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
    if ((!(paramq instanceof com.tencent.mm.ak.s)) || (((com.tencent.mm.ak.s)paramq).aYR() != 21))
    {
      Log.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd another scene and ret");
      AppMethodBeat.o(20466);
      return;
    }
    if (i == 159)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = v.bev().tJ(21);
        if ((paramString == null) || (paramString.length == 0))
        {
          Log.i("MicroMsg.TraceConfigUpdater", "summer doDownload error no pkg found.");
          release();
          AppMethodBeat.o(20466);
          return;
        }
        paramString = paramString[0];
        Log.i("MicroMsg.TraceConfigUpdater", "summer doDownload pkg id:" + paramString.id + " version:" + paramString.version + " status:" + paramString.status + " type:" + paramString.dMe);
        if (5 == paramString.status)
        {
          paramString = new m(paramString.id, 21);
          bg.azz().a(paramString, 0);
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
        sC(((m)paramq).jho);
      }
      release();
    }
    AppMethodBeat.o(20466);
  }
  
  public static abstract interface a
  {
    public abstract void aXz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.d.c
 * JD-Core Version:    0.7.0.1
 */