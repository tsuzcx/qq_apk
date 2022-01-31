package com.tencent.mm.model.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.o;
import com.tencent.mm.ai.p;
import com.tencent.mm.ba.j;
import com.tencent.mm.ba.n;
import com.tencent.mm.ba.r;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.io.File;
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
  private static c fpO;
  private ArrayList<c.a> eDb;
  private final int fpK;
  private final String fpL;
  private final long fpM;
  private volatile boolean fpN;
  private SharedPreferences sp;
  
  private c()
  {
    AppMethodBeat.i(16418);
    this.fpK = 21;
    this.fpL = "trace_config_last_update_time";
    this.fpM = 86400000L;
    this.fpN = false;
    this.sp = ah.dsQ();
    this.eDb = new ArrayList();
    AppMethodBeat.o(16418);
  }
  
  public static c acf()
  {
    AppMethodBeat.i(16419);
    if (fpO == null) {}
    try
    {
      if (fpO == null) {
        fpO = new c();
      }
      c localc = fpO;
      AppMethodBeat.o(16419);
      return localc;
    }
    finally
    {
      AppMethodBeat.o(16419);
    }
  }
  
  private void kO(int paramInt)
  {
    AppMethodBeat.i(16421);
    r.aiP();
    Object localObject1 = n.aiM();
    Object localObject2 = r.aiP().cB(paramInt, 21);
    label470:
    for (;;)
    {
      try
      {
        Object localObject3 = br.F(e.cS(new File(new File((String)localObject1), (String)localObject2).getPath()), "TraceConfig");
        if (localObject3 == null)
        {
          ab.d("MicroMsg.TraceConfigUpdater", "summer kvMap is null and ret");
          AppMethodBeat.o(16421);
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
            long l = bo.getLong((String)((Map)localObject3).get(localObject1), -1L);
            if (l < 0L) {
              break label470;
            }
            ab.i("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig i: " + i + " key: " + (String)localObject4 + "|value: " + l);
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
        com.tencent.mm.ba.m localm;
        localm.putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
      }
      catch (IOException localIOException)
      {
        ab.printErrStackTrace("MicroMsg.TraceConfigUpdater", localIOException, "", new Object[0]);
        localm = r.aiP().cz(paramInt, 21);
        localm.status = 2;
        r.aiP().b(localm);
        AppMethodBeat.o(16421);
        return;
      }
      ab.d("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig configMap size: " + ((Map)localObject2).size());
      int j = this.eDb.size();
      int i = 0;
      while (i < j)
      {
        ((c.a)this.eDb.get(i)).abZ();
        i += 1;
      }
    }
  }
  
  private void release()
  {
    AppMethodBeat.i(16422);
    ab.i("MicroMsg.TraceConfigUpdater", "summer release");
    this.fpN = false;
    aw.Rc().b(159, this);
    aw.Rc().b(160, this);
    AppMethodBeat.o(16422);
  }
  
  public final boolean a(c.a parama)
  {
    AppMethodBeat.i(16423);
    if ((parama != null) && (!this.eDb.contains(parama)))
    {
      boolean bool = this.eDb.add(parama);
      AppMethodBeat.o(16423);
      return bool;
    }
    AppMethodBeat.o(16423);
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(16420);
    int i = paramm.getType();
    ab.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
    if ((!(paramm instanceof o)) || (((o)paramm).ads() != 21))
    {
      ab.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd another scene and ret");
      AppMethodBeat.o(16420);
      return;
    }
    if (i == 159)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = r.aiP().lS(21);
        if ((paramString == null) || (paramString.length == 0))
        {
          ab.i("MicroMsg.TraceConfigUpdater", "summer doDownload error no pkg found.");
          release();
          AppMethodBeat.o(16420);
          return;
        }
        paramString = paramString[0];
        ab.i("MicroMsg.TraceConfigUpdater", "summer doDownload pkg id:" + paramString.id + " version:" + paramString.version + " status:" + paramString.status + " type:" + paramString.cvs);
        if (5 == paramString.status)
        {
          paramString = new j(paramString.id, 21);
          aw.Rc().a(paramString, 0);
          AppMethodBeat.o(16420);
          return;
        }
        ab.i("MicroMsg.TraceConfigUpdater", "summer pkgInfo has downloaded and release");
        this.sp.edit().putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
        release();
        AppMethodBeat.o(16420);
        return;
      }
      release();
      AppMethodBeat.o(16420);
      return;
    }
    if (i == 160)
    {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        kO(((j)paramm).fMD);
      }
      release();
    }
    AppMethodBeat.o(16420);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.d.c
 * JD-Core Version:    0.7.0.1
 */