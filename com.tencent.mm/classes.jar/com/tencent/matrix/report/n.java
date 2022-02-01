package com.tencent.matrix.report;

import com.tencent.matrix.resource.b.a.b;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class n
  implements l.d
{
  public static a eYW;
  private final double eYV = Math.random();
  
  private static void a(JSONObject paramJSONObject, int paramInt)
  {
    String str3 = "";
    String str1 = str3;
    if (eYW != null) {}
    try
    {
      str1 = new JSONObject(eYW.ayZ()).toString().replace(",", ";");
      com.tencent.mm.plugin.report.service.h.OAn.b(18573, new Object[] { paramJSONObject.getString("activity"), paramJSONObject.getString("leak_detail"), paramJSONObject.getString("cost_millis"), Integer.valueOf(paramInt), Integer.valueOf(0), BuildInfo.BUILD_TAG, BuildInfo.REV, str1 });
      return;
    }
    finally
    {
      for (;;)
      {
        String str2 = str3;
      }
    }
  }
  
  public final void a(l.b paramb)
  {
    if (!(paramb.eYA instanceof com.tencent.matrix.resource.c))
    {
      com.tencent.mm.sdk.platformtools.Log.e("Matrix.ResourcePluginReporter", "reporter not match plugin");
      label17:
      return;
    }
    for (;;)
    {
      try
      {
        j = paramb.type;
        paramb = paramb.eYz;
        str = paramb.getString("dump_mode");
        com.tencent.mm.sdk.platformtools.Log.i("Matrix.ResourcePluginReporter", "issueType = %s", new Object[] { Integer.valueOf(j) });
        com.tencent.mm.sdk.platformtools.Log.i("Matrix.ResourcePluginReporter", "content = %s", new Object[] { paramb.toString() });
        if (a.b.fbm.name().equals(str)) {
          switch (j)
          {
          case 0: 
            com.tencent.mm.sdk.platformtools.Log.i("Matrix.ResourcePluginReporter", "LEAK_FOUND");
            a(paramb, 7);
            return;
          }
        }
      }
      catch (JSONException paramb)
      {
        int j;
        String str;
        com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("Matrix.ResourcePluginReporter", paramb, "", new Object[0]);
        if ((BuildInfo.DEBUG) || (WeChatEnvironment.hasDebugger()))
        {
          throw new RuntimeException("Matrix report error -- yves", paramb);
          com.tencent.mm.sdk.platformtools.Log.i("Matrix.ResourcePluginReporter", "ERR_FILE_NOT_FOUND");
          a(paramb, 1);
          return;
          com.tencent.mm.sdk.platformtools.Log.i("Matrix.ResourcePluginReporter", "ERR_ANALYSE_OOM");
          a(paramb, 3);
          return;
          if (a.b.fbj.name().equals(str))
          {
            if ((((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yKO, true)) && (this.eYV < 1.0D / ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yKP, 10))) {
              break label605;
            }
            if (!WeChatEnvironment.hasDebugger()) {
              break label610;
            }
            break label605;
            if (i != 0)
            {
              if (j != 0) {
                break;
              }
              a(paramb, 8);
              return;
            }
          }
          if (!a.b.fbl.name().equals(str)) {}
        }
        switch (j)
        {
        case 0: 
          com.tencent.mm.sdk.platformtools.Log.i("Matrix.ResourcePluginReporter", "LEAK_FOUND");
          a(paramb, 15);
          return;
        case 2: 
          com.tencent.mm.sdk.platformtools.Log.i("Matrix.ResourcePluginReporter", "ERR_FILE_NOT_FOUND");
          a(paramb, 17);
          return;
        case 3: 
          com.tencent.mm.sdk.platformtools.Log.i("Matrix.ResourcePluginReporter", "ERR_ANALYSE_OOM");
          a(paramb, 16);
          return;
          if (a.b.fbo.name().equals(str)) {}
          switch (j)
          {
          case 0: 
            com.tencent.mm.sdk.platformtools.Log.i("Matrix.ResourcePluginReporter", "LEAK_FOUND");
            a(paramb, 21);
            return;
          case 2: 
            com.tencent.mm.sdk.platformtools.Log.i("Matrix.ResourcePluginReporter", "ERR_FILE_NOT_FOUND");
            a(paramb, 23);
            return;
          case 3: 
            com.tencent.mm.sdk.platformtools.Log.i("Matrix.ResourcePluginReporter", "ERR_ANALYSE_OOM");
            a(paramb, 22);
            return;
            if (!a.b.fbp.name().equals(str)) {
              break label17;
            }
            switch (j)
            {
            case 0: 
              com.tencent.mm.sdk.platformtools.Log.i("Matrix.ResourcePluginReporter", "LEAK_FOUND");
              a(paramb, 24);
              return;
            case 2: 
              com.tencent.mm.sdk.platformtools.Log.i("Matrix.ResourcePluginReporter", "ERR_FILE_NOT_FOUND");
              a(paramb, 26);
              return;
            case 3: 
              com.tencent.mm.sdk.platformtools.Log.i("Matrix.ResourcePluginReporter", "ERR_ANALYSE_OOM");
              a(paramb, 25);
              return;
              com.tencent.mm.plugin.report.service.h.OAn.b(18573, new Object[] { "", android.util.Log.getStackTraceString(paramb), Integer.valueOf(0), Integer.valueOf(9), Integer.valueOf(0), BuildInfo.BUILD_TAG, BuildInfo.REV });
              return;
            }
            break;
          }
          break;
        }
      }
      return;
      label605:
      int i = 1;
      continue;
      label610:
      i = 0;
    }
    return;
    return;
  }
  
  public static abstract interface a
  {
    public abstract Map<String, String> ayZ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.report.n
 * JD-Core Version:    0.7.0.1
 */