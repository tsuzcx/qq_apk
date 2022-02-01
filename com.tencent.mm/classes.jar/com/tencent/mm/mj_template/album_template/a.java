package com.tencent.mm.mj_template.album_template;

import com.tencent.maas.instamovie.MJExportSettings;
import com.tencent.maas.instamovie.mediafoundation.FrameRate;
import com.tencent.maas.instamovie.mediafoundation.b;
import com.tencent.maas.instamovie.mediafoundation.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.mj_template.maas.c.a.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.e;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/album_template/FinderMaasMovieSessionConfigProviderImpl;", "Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC$IMaasMovieSessionConfigProvider;", "()V", "TAG", "", "provideExportSettings", "Lcom/tencent/maas/instamovie/MJExportSettings;", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements a.a
{
  public static final a nVZ;
  
  static
  {
    AppMethodBeat.i(240422);
    nVZ = new a();
    AppMethodBeat.o(240422);
  }
  
  public final MJExportSettings bwB()
  {
    AppMethodBeat.i(240431);
    VideoTransPara localVideoTransPara = e.bIg().bIn();
    int m = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zeJ, 30);
    int j = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zeI, 0);
    int i;
    int n;
    Object localObject;
    if (j == 0)
    {
      i = localVideoTransPara.videoBitrate;
      n = i / m;
      int k = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zeH, 0);
      i = k;
      if (k == 0) {
        i = localVideoTransPara.width;
      }
      if (i <= 1080) {
        break label263;
      }
      localObject = b.eGb;
      label109:
      Log.i("FinderMaasMovieSessionConfigProviderImpl", "provideExportSettings: fps: " + m + ", iframeInterval: " + localVideoTransPara.nCd * m + ", videoBitrate: " + n + ", xVideoBitrate:" + j + ", configBitrate:" + localVideoTransPara.videoBitrate + ", audioBitrate: " + localVideoTransPara.audioBitrate + ", dimension: " + i);
      if (m != 60) {
        break label301;
      }
    }
    label263:
    label301:
    for (FrameRate localFrameRate = FrameRate.FrameRate60;; localFrameRate = FrameRate.FrameRate30)
    {
      localObject = new MJExportSettings(localFrameRate, n, localVideoTransPara.audioBitrate, d.eGm, com.tencent.maas.instamovie.mediafoundation.a.eFy, com.tencent.maas.instamovie.mediafoundation.c.eGg, (b)localObject, localVideoTransPara.nCd * m);
      AppMethodBeat.o(240431);
      return localObject;
      i = j;
      break;
      if (i > 720)
      {
        localObject = b.eGa;
        break label109;
      }
      if (i > 540)
      {
        localObject = b.eFZ;
        break label109;
      }
      localObject = b.eFY;
      break label109;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.album_template.a
 * JD-Core Version:    0.7.0.1
 */