package com.tencent.matrix.report;

import android.os.SystemClock;
import com.tencent.matrix.trace.b.a.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class g
  implements h.b
{
  private final ConcurrentHashMap<String, a> cWn = new ConcurrentHashMap();
  
  public final boolean c(c paramc)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (paramc.cWf.getTag().equals("Trace"))
    {
      localObject = paramc.cWe;
      paramc = paramc.tag;
      if (!paramc.equalsIgnoreCase("Trace_EvilMethod")) {
        break label116;
      }
      paramc = ((JSONObject)localObject).getString("detail");
      if (!paramc.equalsIgnoreCase(a.a.daU.toString())) {
        break label85;
      }
      if (MultiProcessMMKV.getDefault().decodeBool("clicfg_anr_report_all", true)) {
        break label277;
      }
      bool1 = Util.isNullOrNil(((JSONObject)localObject).getString("stackKey"));
    }
    for (;;)
    {
      return bool1;
      label85:
      bool1 = bool2;
      if (paramc.equalsIgnoreCase(a.a.daT.toString()))
      {
        bool1 = bool2;
        label277:
        if (!MultiProcessMMKV.getDefault().decodeBool("clicfg_normal_report", false))
        {
          return true;
          label116:
          if (paramc.equalsIgnoreCase("Trace_FPS"))
          {
            String str = ((JSONObject)localObject).getString("scene");
            localObject = (a)this.cWn.get(str);
            paramc = (c)localObject;
            if (localObject == null)
            {
              paramc = new a((byte)0);
              this.cWn.put(str, paramc);
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
                this.cWn.put(str, new a((byte)0));
                return true;
              }
            }
          }
          else
          {
            bool1 = bool2;
            if (paramc.equalsIgnoreCase("Trace_StartUp"))
            {
              bool1 = bool2;
              if (!((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.som, false))
              {
                return true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.report.g
 * JD-Core Version:    0.7.0.1
 */