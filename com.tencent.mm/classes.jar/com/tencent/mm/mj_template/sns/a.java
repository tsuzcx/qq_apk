package com.tencent.mm.mj_template.sns;

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
import com.tencent.mm.util.b.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/sns/SnsMaasMovieSessionConfigProviderImpl;", "Lcom/tencent/mm/mj_template/maas/uic/IMaasSdkUIC$IMaasMovieSessionConfigProvider;", "()V", "TAG", "", "provideExportMaxDuration", "", "provideExportSettings", "Lcom/tencent/maas/instamovie/MJExportSettings;", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements a.a
{
  public static final a odN;
  
  static
  {
    AppMethodBeat.i(240139);
    odN = new a();
    AppMethodBeat.o(240139);
  }
  
  public static int byw()
  {
    AppMethodBeat.i(240132);
    int i = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zeU, 60);
    AppMethodBeat.o(240132);
    return i;
  }
  
  public final MJExportSettings bwB()
  {
    AppMethodBeat.i(240151);
    VideoTransPara localVideoTransPara = e.bIg().bIj();
    int m = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zeR, 30);
    int j = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zeS, b.a.agsj, 0);
    int i;
    int n;
    Object localObject;
    if (j == 0)
    {
      i = localVideoTransPara.videoBitrate;
      n = i / m;
      int k = ((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zeT, b.a.agsk, 0);
      i = k;
      if (k == 0) {
        i = localVideoTransPara.width;
      }
      if (i <= 1080) {
        break label269;
      }
      localObject = b.eGb;
      label115:
      Log.i("MicroMsg.SnsTemplate.SnsMaasMovieSessionConfigProviderImpl", "provideExportSettings: fps: " + m + ", iframeInterval: " + localVideoTransPara.nCd * m + ", videoBitrate: " + n + ", xVideoBitrate:" + j + ", configBitrate:" + localVideoTransPara.videoBitrate + ", audioBitrate: " + localVideoTransPara.audioBitrate + ", dimension: " + i);
      if (m != 60) {
        break label307;
      }
    }
    label269:
    label307:
    for (FrameRate localFrameRate = FrameRate.FrameRate60;; localFrameRate = FrameRate.FrameRate30)
    {
      localObject = new MJExportSettings(localFrameRate, n, localVideoTransPara.audioBitrate, d.eGm, com.tencent.maas.instamovie.mediafoundation.a.eFy, com.tencent.maas.instamovie.mediafoundation.c.eGg, (b)localObject, localVideoTransPara.nCd * m);
      AppMethodBeat.o(240151);
      return localObject;
      i = j;
      break;
      if (i > 720)
      {
        localObject = b.eGa;
        break label115;
      }
      if (i > 540)
      {
        localObject = b.eFZ;
        break label115;
      }
      localObject = b.eFY;
      break label115;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.sns.a
 * JD-Core Version:    0.7.0.1
 */