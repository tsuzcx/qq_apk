package com.tencent.matrix.report;

import com.tencent.matrix.resource.b.a.b;
import com.tencent.matrix.resource.c;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import org.json.JSONException;
import org.json.JSONObject;

public final class m
  implements k.d
{
  private final double dav = Math.random();
  
  private static void a(JSONObject paramJSONObject, int paramInt)
  {
    com.tencent.mm.plugin.report.service.h.IzE.a(18573, new Object[] { paramJSONObject.getString("activity"), paramJSONObject.getString("leak_detail"), paramJSONObject.getString("cost_millis"), Integer.valueOf(paramInt), Integer.valueOf(0), BuildInfo.BUILD_TAG, BuildInfo.REV });
  }
  
  public final void a(k.b paramb)
  {
    if (!(paramb.daa instanceof c))
    {
      com.tencent.mm.sdk.platformtools.Log.e("Matrix.ResourcePluginReporter", "reporter not match plugin");
      return;
    }
    int j;
    String str;
    try
    {
      j = paramb.type;
      paramb = paramb.cZZ;
      str = paramb.getString("dump_mode");
      com.tencent.mm.sdk.platformtools.Log.i("Matrix.ResourcePluginReporter", "issueType = %s", new Object[] { Integer.valueOf(j) });
      com.tencent.mm.sdk.platformtools.Log.i("Matrix.ResourcePluginReporter", "content = %s", new Object[] { paramb.toString() });
      if (!a.b.dcL.name().equals(str)) {
        break label192;
      }
      switch (j)
      {
      case 0: 
        com.tencent.mm.sdk.platformtools.Log.i("Matrix.ResourcePluginReporter", "LEAK_FOUND");
        a(paramb, 7);
        return;
      }
    }
    catch (JSONException paramb)
    {
      com.tencent.mm.sdk.platformtools.Log.printErrStackTrace("Matrix.ResourcePluginReporter", paramb, "", new Object[0]);
      if (BuildInfo.DEBUG) {
        break label155;
      }
    }
    if (WeChatEnvironment.hasDebugger())
    {
      label155:
      throw new RuntimeException("Matrix report error -- yves", paramb);
      com.tencent.mm.sdk.platformtools.Log.i("Matrix.ResourcePluginReporter", "ERR_FILE_NOT_FOUND");
      a(paramb, 1);
      return;
      com.tencent.mm.sdk.platformtools.Log.i("Matrix.ResourcePluginReporter", "ERR_ANALYSE_OOM");
      a(paramb, 3);
      return;
      label192:
      if (a.b.dcI.name().equals(str))
      {
        if ((((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vxs, true)) && (this.dav < 1.0D / ((b)com.tencent.mm.kernel.h.ae(b.class)).a(b.a.vxt, 10))) {
          break label367;
        }
        if (!WeChatEnvironment.hasDebugger()) {
          break label372;
        }
        break label367;
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        if (j != 0) {
          break;
        }
        a(paramb, 8);
        return;
      }
      if ((!a.b.dcK.name().equals(str)) || (j != 0)) {
        break;
      }
      a(paramb, 10);
      return;
      com.tencent.mm.plugin.report.service.h.IzE.a(18573, new Object[] { "", android.util.Log.getStackTraceString(paramb), Integer.valueOf(0), Integer.valueOf(9), Integer.valueOf(0), BuildInfo.BUILD_TAG, BuildInfo.REV });
      return;
      return;
      label367:
      int i = 1;
      continue;
      label372:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.matrix.report.m
 * JD-Core Version:    0.7.0.1
 */