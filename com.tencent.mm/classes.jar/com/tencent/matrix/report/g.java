package com.tencent.matrix.report;

import android.os.SystemClock;
import com.tencent.matrix.e.b;
import com.tencent.matrix.trace.b.a.a;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class g
  implements h.b
{
  private final ConcurrentHashMap<String, g.a> cFP = new ConcurrentHashMap();
  
  public final boolean c(c paramc)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (paramc.cFH.getTag().equals("Trace"))
    {
      localObject = paramc.cFG;
      paramc = paramc.tag;
      if (!paramc.equalsIgnoreCase("Trace_EvilMethod")) {
        break label116;
      }
      paramc = ((JSONObject)localObject).getString("detail");
      if (!paramc.equalsIgnoreCase(a.a.cKw.toString())) {
        break label85;
      }
      if (ay.fpa().decodeBool("clicfg_anr_report_all", true)) {
        break label244;
      }
      bool1 = bu.isNullOrNil(((JSONObject)localObject).getString("stackKey"));
    }
    for (;;)
    {
      return bool1;
      label85:
      bool1 = bool2;
      if (paramc.equalsIgnoreCase(a.a.cKv.toString()))
      {
        bool1 = bool2;
        if (!ay.fpa().decodeBool("clicfg_normal_report", false))
        {
          return true;
          label116:
          bool1 = bool2;
          if (paramc.equalsIgnoreCase("Trace_FPS"))
          {
            String str = ((JSONObject)localObject).getString("scene");
            localObject = (g.a)this.cFP.get(str);
            paramc = (c)localObject;
            if (localObject == null)
            {
              paramc = new g.a((byte)0);
              this.cFP.put(str, paramc);
            }
            long l1 = SystemClock.uptimeMillis();
            long l2 = paramc.time;
            paramc.count += 1;
            bool1 = bool2;
            if (paramc.count > 12)
            {
              bool1 = bool2;
              if (l1 - l2 <= 2400000L)
              {
                this.cFP.put(str, new g.a((byte)0));
                return true;
                label244:
                bool1 = false;
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.g
 * JD-Core Version:    0.7.0.1
 */