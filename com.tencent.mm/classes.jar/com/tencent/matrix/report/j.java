package com.tencent.matrix.report;

import android.os.SystemClock;
import com.tencent.matrix.trace.b.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public final class j
  implements k.c
{
  private final ConcurrentHashMap<String, a> dai = new ConcurrentHashMap();
  
  public final boolean c(f paramf)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    Object localObject;
    if (paramf.daa.getTag().equals("Trace"))
    {
      localObject = paramf.cZZ;
      paramf = paramf.tag;
      if (!paramf.equalsIgnoreCase("Trace_EvilMethod")) {
        break label116;
      }
      paramf = ((JSONObject)localObject).getString("detail");
      if (!paramf.equalsIgnoreCase(a.a.deX.toString())) {
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
      if (paramf.equalsIgnoreCase(a.a.deW.toString()))
      {
        bool1 = bool2;
        label277:
        if (!MultiProcessMMKV.getDefault().decodeBool("clicfg_normal_report", false))
        {
          return true;
          label116:
          if (paramf.equalsIgnoreCase("Trace_FPS"))
          {
            String str = ((JSONObject)localObject).getString("scene");
            localObject = (a)this.dai.get(str);
            paramf = (f)localObject;
            if (localObject == null)
            {
              paramf = new a((byte)0);
              this.dai.put(str, paramf);
            }
            long l1 = SystemClock.uptimeMillis();
            long l2 = paramf.time;
            paramf.count += 1;
            bool1 = bool2;
            if (paramf.count > 12)
            {
              bool1 = bool2;
              if (l1 - l2 <= 2400000L)
              {
                this.dai.put(str, new a((byte)0));
                return true;
              }
            }
          }
          else
          {
            bool1 = bool2;
            if (paramf.equalsIgnoreCase("Trace_StartUp"))
            {
              bool1 = bool2;
              if (!((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vZL, false))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.j
 * JD-Core Version:    0.7.0.1
 */