package com.tencent.matrix.report;

import android.os.SystemClock;
import com.tencent.matrix.e.b;
import com.tencent.matrix.trace.b.a.a;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class g
  implements h.b
{
  private final ConcurrentHashMap<String, a> cFg = new ConcurrentHashMap();
  
  public final boolean c(c paramc)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (paramc.cFa.getTag().equals("Trace"))
    {
      localObject = paramc.cEZ;
      paramc = paramc.tag;
      if (!paramc.equalsIgnoreCase("Trace_EvilMethod")) {
        break label116;
      }
      paramc = ((JSONObject)localObject).getString("detail");
      if (!paramc.equalsIgnoreCase(a.a.cJN.toString())) {
        break label85;
      }
      if (ax.flf().decodeBool("clicfg_anr_report_all", true)) {
        break label244;
      }
      bool1 = bt.isNullOrNil(((JSONObject)localObject).getString("stackKey"));
    }
    for (;;)
    {
      return bool1;
      label85:
      bool1 = bool2;
      if (paramc.equalsIgnoreCase(a.a.cJM.toString()))
      {
        bool1 = bool2;
        if (!ax.flf().decodeBool("clicfg_normal_report", false))
        {
          return true;
          label116:
          bool1 = bool2;
          if (paramc.equalsIgnoreCase("Trace_FPS"))
          {
            String str = ((JSONObject)localObject).getString("scene");
            localObject = (a)this.cFg.get(str);
            paramc = (c)localObject;
            if (localObject == null)
            {
              paramc = new a((byte)0);
              this.cFg.put(str, paramc);
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
                this.cFg.put(str, new a((byte)0));
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
  
  static final class a
  {
    int count = 0;
    long time = SystemClock.uptimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.g
 * JD-Core Version:    0.7.0.1
 */