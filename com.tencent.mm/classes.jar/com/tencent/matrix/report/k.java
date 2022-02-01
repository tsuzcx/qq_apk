package com.tencent.matrix.report;

import android.os.SystemClock;
import com.tencent.matrix.d.b;
import com.tencent.matrix.trace.b.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class k
  implements l.c
{
  private final ConcurrentHashMap<String, a> eYI = new ConcurrentHashMap();
  
  public final boolean c(g paramg)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (paramg.eYA.getTag().equals("Trace"))
    {
      localObject = paramg.eYz;
      paramg = paramg.tag;
      if (!paramg.equalsIgnoreCase("Trace_EvilMethod")) {
        break label74;
      }
      if ((!((JSONObject)localObject).getString("detail").equalsIgnoreCase(a.a.fdV.toString())) || (MultiProcessMMKV.getDefault().decodeBool("clicfg_normal_report", false))) {
        break label235;
      }
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      label74:
      if (paramg.equalsIgnoreCase("Trace_FPS"))
      {
        String str = ((JSONObject)localObject).getString("scene");
        localObject = (a)this.eYI.get(str);
        paramg = (g)localObject;
        if (localObject == null)
        {
          paramg = new a((byte)0);
          this.eYI.put(str, paramg);
        }
        long l1 = SystemClock.uptimeMillis();
        long l2 = paramg.time;
        paramg.count += 1;
        bool1 = bool2;
        if (paramg.count > 12)
        {
          bool1 = bool2;
          if (l1 - l2 <= 2400000L)
          {
            this.eYI.put(str, new a((byte)0));
            return true;
          }
        }
      }
      else
      {
        bool1 = bool2;
        if (paramg.equalsIgnoreCase("Trace_StartUp"))
        {
          bool1 = bool2;
          if (!((c)h.ax(c.class)).a(c.a.zto, false))
          {
            return true;
            label235:
            bool1 = false;
          }
        }
      }
    }
  }
  
  static final class a
  {
    int count = 0;
    long time = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.report.k
 * JD-Core Version:    0.7.0.1
 */