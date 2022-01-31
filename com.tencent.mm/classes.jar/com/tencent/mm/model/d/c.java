package com.tencent.mm.model.d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.a.e;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.o;
import com.tencent.mm.ah.p;
import com.tencent.mm.az.j;
import com.tencent.mm.az.n;
import com.tencent.mm.az.r;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
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
  private static c dZJ;
  private ArrayList<c.a> dFz = new ArrayList();
  private final int dZF = 21;
  private final String dZG = "trace_config_last_update_time";
  private final long dZH = 86400000L;
  private volatile boolean dZI = false;
  private SharedPreferences dnD = ae.cqS();
  
  public static c Ji()
  {
    if (dZJ == null) {}
    try
    {
      if (dZJ == null) {
        dZJ = new c();
      }
      return dZJ;
    }
    finally {}
  }
  
  private void ib(int paramInt)
  {
    r.PK();
    Object localObject1 = n.PH();
    Object localObject2 = r.PK().br(paramInt, 21);
    label452:
    for (;;)
    {
      try
      {
        Object localObject3 = bn.s(e.bP(new File(new File((String)localObject1), (String)localObject2).getPath()), "TraceConfig");
        if (localObject3 == null)
        {
          y.d("MicroMsg.TraceConfigUpdater", "summer kvMap is null and ret");
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
            long l = bk.getLong((String)((Map)localObject3).get(localObject1), -1L);
            if (l < 0L) {
              break label452;
            }
            y.i("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig i: " + i + " key: " + (String)localObject4 + "|value: " + l);
            ((Map)localObject2).put(localObject4, Long.valueOf(l));
          }
        }
        else
        {
          localObject1 = Integer.valueOf(i);
          continue;
        }
        localObject1 = this.dnD.edit();
        localObject3 = ((Map)localObject2).entrySet().iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (Map.Entry)((Iterator)localObject3).next();
          ((SharedPreferences.Editor)localObject1).putLong((String)((Map.Entry)localObject4).getKey(), ((Long)((Map.Entry)localObject4).getValue()).longValue());
          continue;
        }
        com.tencent.mm.az.m localm;
        localm.putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
      }
      catch (IOException localIOException)
      {
        y.printErrStackTrace("MicroMsg.TraceConfigUpdater", localIOException, "", new Object[0]);
        localm = r.PK().bp(paramInt, 21);
        localm.status = 2;
        r.PK().b(localm);
        return;
      }
      y.d("MicroMsg.TraceConfigUpdater", "summer updateTraceConfig configMap size: " + ((Map)localObject2).size());
      int j = this.dFz.size();
      int i = 0;
      while (i < j)
      {
        ((c.a)this.dFz.get(i)).Jc();
        i += 1;
      }
    }
  }
  
  private void release()
  {
    y.i("MicroMsg.TraceConfigUpdater", "summer release");
    this.dZI = false;
    au.Dk().b(159, this);
    au.Dk().b(160, this);
  }
  
  public final boolean a(c.a parama)
  {
    if ((parama != null) && (!this.dFz.contains(parama))) {
      return this.dFz.add(parama);
    }
    return false;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    int i = paramm.getType();
    y.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd: errType:[%d], errCode:[%d], type:[%d]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
    if ((!(paramm instanceof o)) || (((o)paramm).KF() != 21)) {
      y.i("MicroMsg.TraceConfigUpdater", "summer onSceneEnd another scene and ret");
    }
    do
    {
      return;
      if (i == 159)
      {
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          paramString = r.PK().ja(21);
          if ((paramString == null) || (paramString.length == 0))
          {
            y.i("MicroMsg.TraceConfigUpdater", "summer doDownload error no pkg found.");
            release();
            return;
          }
          paramString = paramString[0];
          y.i("MicroMsg.TraceConfigUpdater", "summer doDownload pkg id:" + paramString.id + " version:" + paramString.version + " status:" + paramString.status + " type:" + paramString.bOa);
          if (5 == paramString.status)
          {
            paramString = new j(paramString.id, 21);
            au.Dk().a(paramString, 0);
            return;
          }
          y.i("MicroMsg.TraceConfigUpdater", "summer pkgInfo has downloaded and release");
          this.dnD.edit().putLong("trace_config_last_update_time", System.currentTimeMillis()).commit();
          release();
          return;
        }
        release();
        return;
      }
    } while (i != 160);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      ib(((j)paramm).ewN);
    }
    release();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.d.c
 * JD-Core Version:    0.7.0.1
 */