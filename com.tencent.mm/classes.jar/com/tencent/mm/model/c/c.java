package com.tencent.mm.model.c;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.r;
import com.tencent.mm.model.bh;
import com.tencent.mm.modelpackage.o;
import com.tencent.mm.modelpackage.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class c
  implements h
{
  private static c opK;
  private ArrayList<a> listeners;
  private volatile boolean mjj;
  private final int opH;
  private final String opI;
  private final long opJ;
  private SharedPreferences sp;
  
  private c()
  {
    AppMethodBeat.i(20464);
    this.opH = 21;
    this.opI = "trace_config_last_update_time";
    this.opJ = 86400000L;
    this.mjj = false;
    this.sp = MMApplicationContext.getDefaultPreference();
    this.listeners = new ArrayList();
    AppMethodBeat.o(20464);
  }
  
  public static c bEC()
  {
    AppMethodBeat.i(20465);
    if (opK == null) {}
    try
    {
      if (opK == null) {
        opK = new c();
      }
      c localc = opK;
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
    this.mjj = false;
    bh.aZW().b(159, this);
    bh.aZW().b(160, this);
    AppMethodBeat.o(20468);
  }
  
  private void vH(int paramInt)
  {
    AppMethodBeat.i(20467);
    com.tencent.mm.modelpackage.u.bLH();
    Object localObject1 = t.bLE();
    Object localObject2 = com.tencent.mm.modelpackage.u.bLH().eK(paramInt, 21);
    label467:
    for (;;)
    {
      try
      {
        Object localObject3 = XmlParser.parseXml(y.bEn(ah.v(new com.tencent.mm.vfs.u((String)localObject1, (String)localObject2).mUri)), "TraceConfig", null);
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
        com.tencent.mm.modelpackage.s locals;
        locals.putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
      }
      catch (IOException localIOException)
      {
        Log.printErrStackTrace("MicroMsg.TraceConfigUpdater", localIOException, "", new Object[0]);
        locals = com.tencent.mm.modelpackage.u.bLH().eI(paramInt, 21);
        locals.status = 2;
        com.tencent.mm.modelpackage.u.bLH().b(locals);
        AppMethodBeat.o(20467);
        return;
      }
      Log.d("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig configMap size: " + ((Map)localObject2).size());
      int j = this.listeners.size();
      int i = 0;
      while (i < j)
      {
        ((a)this.listeners.get(i)).bEy();
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(20466);
    int i = paramp.getType();
    Log.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
    if ((!(paramp instanceof r)) || (((r)paramp).bFO() != 21))
    {
      Log.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd another scene and ret");
      AppMethodBeat.o(20466);
      return;
    }
    if (i == 159)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = com.tencent.mm.modelpackage.u.bLH().wK(21);
        if ((paramString == null) || (paramString.length == 0))
        {
          Log.i("MicroMsg.TraceConfigUpdater", "summer doDownload error no pkg found.");
          release();
          AppMethodBeat.o(20466);
          return;
        }
        paramString = paramString[0];
        Log.i("MicroMsg.TraceConfigUpdater", "summer doDownload pkg id:" + paramString.id + " version:" + paramString.version + " status:" + paramString.status + " type:" + paramString.hJK);
        if (5 == paramString.status)
        {
          paramString = new o(paramString.id, 21);
          bh.aZW().a(paramString, 0);
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
        vH(((o)paramp).oQV);
      }
      release();
    }
    AppMethodBeat.o(20466);
  }
  
  public static abstract interface a
  {
    public abstract void bEy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.c.c
 * JD-Core Version:    0.7.0.1
 */