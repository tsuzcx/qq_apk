package com.tencent.mm.mj_template.album_template;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.media.util.d.a;
import com.tencent.mm.mj_template.maas.sdk.f;
import com.tencent.mm.mj_template.maas.sdk.g;
import com.tencent.mm.mj_template.plugin.a;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.util.b.a;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/album_template/MaasAlbumTemplateGlobalConfig;", "", "()V", "TAG", "", "deviceSupport", "", "disableAiAnalysis", "enableExportRetry", "isEnableVideoTranscodeOptimize", "preprocTimeoutLimit", "", "videoTranscodeDimensionLimit", "Lcom/tencent/maas/instamovie/mediafoundation/DimensionLevel;", "toDimensionLevel", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b nWa;
  
  static
  {
    AppMethodBeat.i(240474);
    nWa = new b();
    AppMethodBeat.o(240474);
  }
  
  public static boolean bwC()
  {
    AppMethodBeat.i(240434);
    int i;
    int j;
    label66:
    Object localObject;
    if ((BuildInfo.IS_ARM64) || (((c)h.ax(c.class)).a(c.a.zeE, b.a.agse, 0) == 1))
    {
      i = 1;
      if (Build.VERSION.SDK_INT < ((c)h.ax(c.class)).a(c.a.zeF, b.a.agsf, 26)) {
        break label108;
      }
      j = 1;
      if ((j & i) == 0) {
        break label229;
      }
      localObject = f.obN;
      if (BuildInfo.IS_ARM64) {
        break label113;
      }
      Log.w(f.TAG, "isValid: work on arm64");
      i = 0;
    }
    for (;;)
    {
      if (i == 0) {
        break label229;
      }
      AppMethodBeat.o(240434);
      return true;
      i = 0;
      break;
      label108:
      j = 0;
      break label66;
      label113:
      Boolean localBoolean = a.ocw;
      s.s(localBoolean, "MAAS_IN_PKG");
      if (!localBoolean.booleanValue())
      {
        Log.i(f.TAG, s.X("isValid: isLoaded:", Boolean.valueOf(f.obO)));
        if (!f.obO)
        {
          ((f)localObject).bxR();
          localObject = g.obV;
          i = g.bxZ() - g.bya();
          localObject = g.obV;
          j = g.bxM();
          Log.i(f.TAG, "isValid: loadFilCount:" + i + ", compatVersion:" + j);
          if ((i > 1) || (j != 10100003))
          {
            i = 0;
            continue;
          }
        }
      }
      i = 1;
    }
    label229:
    AppMethodBeat.o(240434);
    return false;
  }
  
  public static boolean bwD()
  {
    AppMethodBeat.i(240439);
    if (((c)h.ax(c.class)).a(c.a.zeK, b.a.agsg, 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.MaasAlbumTemplateGlobalConfig", s.X("disableAiAnalysis: ", Boolean.valueOf(bool)));
      AppMethodBeat.o(240439);
      return bool;
    }
  }
  
  public static boolean bwE()
  {
    AppMethodBeat.i(240448);
    if (((c)h.ax(c.class)).a(c.a.zeN, b.a.agsh, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.MaasAlbumTemplateGlobalConfig", s.X("isEnableVideoTranscodeOptimize: ", Boolean.valueOf(bool)));
      AppMethodBeat.o(240448);
      return bool;
    }
  }
  
  public static com.tencent.maas.instamovie.mediafoundation.b bwF()
  {
    AppMethodBeat.i(240461);
    int k = com.tencent.mm.media.util.d.nFC.bqn();
    Object localObject1 = ((c)h.ax(c.class)).a(c.a.zeO, "");
    Object localObject2 = (CharSequence)localObject1;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(240461);
      return null;
    }
    for (;;)
    {
      int m;
      int j;
      try
      {
        localObject1 = new JSONArray((String)localObject1);
        m = ((JSONArray)localObject1).length();
        if (m <= 0) {
          break label236;
        }
        i = 0;
        j = i + 1;
        localObject2 = ((JSONArray)localObject1).optJSONObject(i);
        if (localObject2 != null)
        {
          int n = ((JSONObject)localObject2).optInt("rating", -1);
          i = ((JSONObject)localObject2).optInt("limit", -1);
          if (n == k)
          {
            Log.i("MicroMsg.MaasAlbumTemplateGlobalConfig", "videoTranscodeDimensionLimit: " + i + ", gpuRating:" + k);
            if (i <= 0) {
              break label248;
            }
            localObject1 = d.nWs;
            if (!d.bwQ().containsKey(Integer.valueOf(i))) {
              break label241;
            }
            localObject1 = com.tencent.maas.instamovie.mediafoundation.b.mM(i);
            AppMethodBeat.o(240461);
            return localObject1;
          }
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.MaasAlbumTemplateGlobalConfig", (Throwable)localException, "parse videoTranscodeDimensionLimit error", new Object[0]);
        AppMethodBeat.o(240461);
        return null;
      }
      if (j >= m)
      {
        label236:
        i = -1;
        continue;
        label241:
        AppMethodBeat.o(240461);
        return null;
        label248:
        AppMethodBeat.o(240461);
        return null;
      }
      else
      {
        i = j;
      }
    }
  }
  
  public static int bwG()
  {
    AppMethodBeat.i(240466);
    int i = ((c)h.ax(c.class)).a(c.a.zeV, b.a.agsp, 20);
    AppMethodBeat.o(240466);
    return i;
  }
  
  public static boolean bwH()
  {
    AppMethodBeat.i(240469);
    boolean bool = ((c)h.ax(c.class)).a(c.a.zeG, false);
    Log.i("MicroMsg.MaasAlbumTemplateGlobalConfig", s.X("disableExportRetry ", Boolean.valueOf(bool)));
    if (!bool)
    {
      AppMethodBeat.o(240469);
      return true;
    }
    AppMethodBeat.o(240469);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.b
 * JD-Core Version:    0.7.0.1
 */