package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w.a;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.g.a;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.protocal.protobuf.rf;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;

final class h$2
  implements w.a
{
  h$2(h paramh, String paramString) {}
  
  public final int a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.b paramb, m paramm)
  {
    AppMethodBeat.i(111537);
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      ab.e("MicroMsg.GameSilentDownloader", "Check Error, errType:%d, errCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      a.I(this.val$appId, 18L);
      AppMethodBeat.o(111537);
      return 0;
    }
    paramb = (rf)paramb.fsW.fta;
    if (paramb == null)
    {
      AppMethodBeat.o(111537);
      return 0;
    }
    ab.i("MicroMsg.GameSilentDownloader", "op:%d", new Object[] { Integer.valueOf(paramb.op) });
    switch (paramb.op)
    {
    default: 
      a.I(this.val$appId, 19L);
    }
    for (;;)
    {
      AppMethodBeat.o(111537);
      return 0;
      ((e)com.tencent.mm.kernel.g.E(e.class)).bEU().Qn(this.val$appId);
      if ((paramb.wJw == null) || (paramb.wJw.kWM == null) || (bo.isNullOrNil(paramb.wJw.kWM.eds)))
      {
        ab.e("MicroMsg.GameSilentDownloader", "downloadInfo is null");
        a.I(this.val$appId, 20L);
        AppMethodBeat.o(111537);
        return 0;
      }
      paramString = ((e)com.tencent.mm.kernel.g.E(e.class)).bEU().Qi(this.val$appId);
      if (paramString == null)
      {
        ab.i("MicroMsg.GameSilentDownloader", "local SilentDownloadTask is deleted");
        AppMethodBeat.o(111537);
        return 0;
      }
      if (!paramb.wJw.kWM.eds.equals(bo.nullAsNil(paramString.field_downloadUrl)))
      {
        ab.i("MicroMsg.GameSilentDownloader", "update downloadInfo. [oldDownloadUrl]:%s, [newDownloadUrl]:%s, [size]:%d, [md5]:%s, [SecondaryUrl]:%s", new Object[] { paramString.field_downloadUrl, paramb.wJw.kWM.eds, Long.valueOf(paramb.wJw.kWM.kWo), paramb.wJw.kWM.kWp, paramb.wJw.kWM.kWu });
        if (bo.isNullOrNil(paramString.field_downloadUrl))
        {
          paramm = paramb.wJw.kWM.eds;
          paramm = com.tencent.mm.plugin.downloader.model.f.bjl().JI(paramm);
          if ((paramm != null) && (paramm.id > 0L) && (paramm.status != 4))
          {
            ab.i("MicroMsg.GameSilentDownloader", "download task already exists");
            f.O(this.val$appId, 6, 0);
            ((e)com.tencent.mm.kernel.g.E(e.class)).bEU().delete(paramString, new String[0]);
            this.npN.ig(false);
            AppMethodBeat.o(111537);
            return 0;
          }
        }
        paramString.field_downloadUrl = paramb.wJw.kWM.eds;
        paramString.field_size = paramb.wJw.kWM.kWo;
        paramString.field_md5 = paramb.wJw.kWM.kWp;
        paramString.field_SecondaryUrl = paramb.wJw.kWM.kWu;
        if (!bo.isNullOrNil(paramb.wJw.kWM.kWn)) {
          paramString.field_packageName = paramb.wJw.kWM.kWn;
        }
        paramString.field_downloadInWidget = paramb.wJw.kWQ;
        ((e)com.tencent.mm.kernel.g.E(e.class)).bEU().update(paramString, new String[0]);
      }
      if (!at.isWifi(ah.getContext()))
      {
        ab.i("MicroMsg.GameSilentDownloader", "cgi response back, but not in wifi");
      }
      else
      {
        paramInt1 = paramb.wJw.kWM.kWq;
        if ((paramString == null) || (bo.isNullOrNil(paramString.field_downloadUrl)))
        {
          ab.e("MicroMsg.GameSilentDownloader", "downloadInfo is null");
        }
        else
        {
          ab.i("MicroMsg.GameSilentDownloader", "startDownload, appId:%s, url:%s, size:%d, md5:%s, packageName:%s, expireTime:%d, isFirst:%b, nextCheckTime:%d, isRunning:%b", new Object[] { paramString.field_appId, paramString.field_downloadUrl, Long.valueOf(paramString.field_size), paramString.field_md5, paramString.field_packageName, Long.valueOf(paramString.field_expireTime), Boolean.valueOf(paramString.field_isFirst), Long.valueOf(paramString.field_nextCheckTime), Boolean.valueOf(paramString.field_isRunning) });
          paramb = paramString.field_downloadUrl;
          paramb = com.tencent.mm.plugin.downloader.model.f.bjl().JI(paramb);
          long l;
          if ((paramb != null) && (paramb.id > 0L) && (paramb.status == 2))
          {
            ab.i("MicroMsg.GameSilentDownloader", "resume downloadTask");
            l = paramb.id;
            com.tencent.mm.plugin.downloader.model.f.bjl().kYy = true;
            com.tencent.mm.plugin.downloader.model.f.bjl().iC(l);
          }
          else
          {
            com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(858L, 9L, 1L, false);
            if (paramString.field_downloadInWidget) {
              ((com.tencent.mm.plugin.downloader_app.a.d)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.downloader_app.a.d.class)).JP(paramString.field_appId);
            }
            paramb = new g.a();
            paramb.JJ(paramString.field_downloadUrl);
            paramb.JK(paramString.field_SecondaryUrl);
            paramb.setAppId(paramString.field_appId);
            paramb.iR(paramString.field_size);
            paramb.dC(paramString.field_packageName);
            paramb.JL(com.tencent.mm.pluginsdk.model.app.g.b(ah.getContext(), com.tencent.mm.pluginsdk.model.app.g.ca(paramString.field_appId, true), null));
            paramb.JM(paramString.field_md5);
            paramb.gr(false);
            paramb.gs(false);
            paramb.tV(1);
            paramb.bjt();
            paramb.setScene(7001);
            com.tencent.mm.plugin.downloader.model.f.bjl().kYy = true;
            if (paramInt1 == 1) {}
            for (l = com.tencent.mm.plugin.downloader.model.f.bjl().b(paramb.kYR);; l = com.tencent.mm.plugin.downloader.model.f.bjl().a(paramb.kYR))
            {
              ab.i("MicroMsg.GameSilentDownload.GameDownloadHelper", "add downloadTask id:%d, downloaderType:%d", new Object[] { Long.valueOf(l), Integer.valueOf(paramInt1) });
              break;
            }
            ab.i("MicroMsg.GameSilentDownloader", "delay, nextInterval:%d", new Object[] { Long.valueOf(paramb.wJv) });
            ((e)com.tencent.mm.kernel.g.E(e.class)).bEU().X(this.val$appId, bo.aox() + paramb.wJv);
            this.npN.ig(false);
            continue;
            f.O(this.val$appId, 5, 0);
            h.cancelDownload(this.val$appId);
            this.npN.ig(false);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.h.2
 * JD-Core Version:    0.7.0.1
 */