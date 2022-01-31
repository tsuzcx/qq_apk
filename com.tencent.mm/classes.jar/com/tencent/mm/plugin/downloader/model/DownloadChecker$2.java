package com.tencent.mm.plugin.downloader.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.plugin.downloader.c.a.a.d;
import com.tencent.mm.plugin.downloader.c.a.a.k;
import com.tencent.mm.plugin.downloader.c.b.f;
import com.tencent.mm.plugin.downloader.c.b.j;
import com.tencent.mm.sdk.platformtools.ab;

final class DownloadChecker$2
  implements w.a
{
  DownloadChecker$2(String paramString1, String paramString2, String paramString3, com.tencent.mm.ipcinvoker.c paramc) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb, m paramm)
  {
    AppMethodBeat.i(2344);
    ab.i("MicroMsg.DownloadChecker", "errType = %d, errCode = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    paramm = new DownloadChecker.DownloadInterceptBean();
    d locald;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramb = (k)paramb.fsW.fta;
      if (paramb != null)
      {
        paramInt1 = paramb.kWb;
        paramString = paramb.kWc;
        locald = paramb.kVX;
        if (DownloadChecker.DownloadInterceptBean.a(locald))
        {
          paramm.cmX = true;
          paramm.kXO = paramInt1;
          paramm.kXP = paramString;
          if (locald.kVQ.kWV == null)
          {
            paramString = null;
            paramm.appId = paramString;
            if (locald.kVQ.kWV != null) {
              break label435;
            }
            paramString = null;
            label143:
            paramm.appName = paramString;
            if (locald.kVQ.kWV != null) {
              break label450;
            }
            paramString = null;
            label162:
            paramm.iconUrl = paramString;
            paramm.downloadUrl = locald.kVQ.kWX.kWM.eds;
            paramm.kXQ = locald.kVQ.kWX.kWM.kWu;
            paramm.size = locald.kVQ.kWX.kWM.kWo;
            paramm.packageName = locald.kVQ.kWX.kWM.kWn;
            paramm.cqq = locald.kVQ.kWX.kWM.kWp;
            paramm.cvQ = locald.kVQ.kWX.kWM.kWq;
            paramm.kXR = locald.kVQ.kWX.kWQ;
            label298:
            ab.i("MicroMsg.DownloadChecker", "check download from net, ret: %d, confirmType: %d, appid: %s", new Object[] { Integer.valueOf(paramb.koj), Integer.valueOf(paramb.kWb), paramm.appId });
            if (paramb.koj == 0) {
              break label474;
            }
            paramm.cmX = false;
            label353:
            DownloadChecker.c.a(paramm.appId, this.val$downloadUrl, paramm.downloadUrl, String.valueOf(paramb.koj), this.kXN, this.cad, String.valueOf(paramb.kWb));
          }
        }
      }
    }
    for (;;)
    {
      if (this.eEg != null) {
        this.eEg.ad(paramm);
      }
      AppMethodBeat.o(2344);
      return 0;
      paramString = locald.kVQ.kWV.cwc;
      break;
      label435:
      paramString = locald.kVQ.kWV.kWx;
      break label143;
      label450:
      paramString = locald.kVQ.kWV.kWy;
      break label162;
      paramm.cmX = false;
      break label298;
      label474:
      if (paramm.cmX) {
        break label353;
      }
      paramb.koj = DownloadChecker.c.kXW;
      break label353;
      paramm.cmX = false;
      continue;
      paramm.cmX = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader.model.DownloadChecker.2
 * JD-Core Version:    0.7.0.1
 */