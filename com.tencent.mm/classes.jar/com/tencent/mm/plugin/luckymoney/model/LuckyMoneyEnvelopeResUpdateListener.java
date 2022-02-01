package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadRequest;
import com.tencent.mars.cdn.CdnLogic.C2CDownloadResult;
import com.tencent.mars.cdn.CdnLogic.CronetTaskResult;
import com.tencent.mars.cdn.CdnLogic.DownloadCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.cd;
import com.tencent.mm.autogen.a.cd.a;
import com.tencent.mm.pluginsdk.res.downloader.checkresupdate.m;
import com.tencent.mm.protocal.protobuf.abj;
import com.tencent.mm.protocal.protobuf.esa;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LuckyMoneyEnvelopeResUpdateListener
  extends IListener<cd>
  implements com.tencent.mm.am.h
{
  public static final String KsW;
  
  static
  {
    AppMethodBeat.i(65222);
    KsW = com.tencent.mm.loader.i.b.bmr() + "luckymoney/";
    AppMethodBeat.o(65222);
  }
  
  public LuckyMoneyEnvelopeResUpdateListener()
  {
    super(f.hfK);
    AppMethodBeat.i(160802);
    this.__eventId = cd.class.getName().hashCode();
    AppMethodBeat.o(160802);
  }
  
  public static String ZP(int paramInt)
  {
    AppMethodBeat.i(65218);
    String str = KsW + paramInt + "/";
    AppMethodBeat.o(65218);
    return str;
  }
  
  public static String ZQ(int paramInt)
  {
    AppMethodBeat.i(283908);
    String str = ZP(paramInt) + "story/";
    AppMethodBeat.o(283908);
    return str;
  }
  
  public static void fXd()
  {
    AppMethodBeat.i(65217);
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
    com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.avS(58);
    AppMethodBeat.o(65217);
  }
  
  public static String jD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(283912);
    String str = ZQ(paramInt1) + "detail_video_" + paramInt2 + ".mp4";
    AppMethodBeat.o(283912);
    return str;
  }
  
  public static int jX(String paramString1, final String paramString2)
  {
    AppMethodBeat.i(283915);
    Log.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "downnloadPAGAnimResource fileId：%s aesKey:%s", new Object[] { paramString1, paramString2 });
    if (Util.isNullOrNil(paramString1))
    {
      AppMethodBeat.o(283915);
      return -1;
    }
    com.tencent.mm.plugin.report.service.h.OAn.kJ(991, 26);
    CdnLogic.C2CDownloadRequest localC2CDownloadRequest = new CdnLogic.C2CDownloadRequest();
    final String str = ac.fXf();
    localC2CDownloadRequest.url = paramString1;
    localC2CDownloadRequest.fileKey = paramString1;
    localC2CDownloadRequest.marscdnBizType = 2;
    localC2CDownloadRequest.marscdnAppType = 266;
    localC2CDownloadRequest.fileType = 20303;
    localC2CDownloadRequest.setSavePath(str);
    localC2CDownloadRequest.taskStartTime = Util.nowMilliSecond();
    long l = localC2CDownloadRequest.taskStartTime;
    Log.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "pag resource download beginTime: %s", new Object[] { Long.valueOf(localC2CDownloadRequest.taskStartTime) });
    int i = CdnLogic.startSNSDownload(localC2CDownloadRequest, null, new CdnLogic.DownloadCallback()
    {
      public final void onC2CDownloadCompleted(String paramAnonymousString, CdnLogic.C2CDownloadResult paramAnonymousC2CDownloadResult)
      {
        AppMethodBeat.i(283913);
        Log.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "pag resource download end , cost：%s", new Object[] { Long.valueOf(Util.nowMilliSecond() - this.pcy) });
        if ((paramAnonymousC2CDownloadResult != null) && (paramAnonymousC2CDownloadResult.cronetTaskResult != null) && (paramAnonymousC2CDownloadResult.cronetTaskResult.performance != null)) {
          Log.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "pag resource download end, fileId:%s, statusCode:%d, profile:%s", new Object[] { str, Integer.valueOf(paramAnonymousC2CDownloadResult.cronetTaskResult.statusCode), paramAnonymousC2CDownloadResult.cronetTaskResult.performance });
        }
        Log.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "pag resource download result.errorCode ：%s， tempFilePath ：%s , md5：%s , file downaload md5:%s ", new Object[] { Integer.valueOf(paramAnonymousC2CDownloadResult.errorCode), paramString2, this.KsZ, y.bub(paramString2) });
        if (paramAnonymousC2CDownloadResult.errorCode != 0)
        {
          Log.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "pag resource download failed:%s", new Object[] { Integer.valueOf(paramAnonymousC2CDownloadResult.errorCode) });
          com.tencent.mm.plugin.report.service.h.OAn.kJ(991, 28);
          AppMethodBeat.o(283913);
          return;
        }
        if (!y.ZC(paramString2))
        {
          Log.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "pag resource download File fail:%s", new Object[] { paramString2 });
          com.tencent.mm.plugin.report.service.h.OAn.kJ(991, 28);
          AppMethodBeat.o(283913);
          return;
        }
        if (ac.jY(paramString2, ac.fXg()))
        {
          com.tencent.mm.plugin.report.service.h.OAn.kJ(991, 29);
          AppMethodBeat.o(283913);
          return;
        }
        com.tencent.mm.plugin.report.service.h.OAn.kJ(991, 30);
        AppMethodBeat.o(283913);
      }
      
      public final void onDownloadProgressChanged(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2, boolean paramAnonymousBoolean) {}
    }, 0);
    AppMethodBeat.o(283915);
    return i;
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(283928);
    Log.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "resourceType.errType:%s，errCode：%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (((paramp instanceof m)) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = (abj)c.c.b(((c)paramp.getReqResp()).otC);
      if (!Util.isNullOrNil(paramString.ZjV))
      {
        paramp = paramString.ZjV.iterator();
        if (paramp.hasNext())
        {
          esa localesa = (esa)paramp.next();
          paramInt1 = localesa.vhJ;
          if (Util.isNullOrNil(localesa.abvT)) {}
          for (paramString = "null";; paramString = String.valueOf(localesa.abvT.size()))
          {
            Log.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "resType：%d，responses.size()：%s", new Object[] { Integer.valueOf(paramInt1), paramString });
            if ((localesa.vhJ == 58) && (!Util.isNullOrNil(localesa.abvT)))
            {
              Log.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "real donwload envelope resource");
              com.tencent.mm.plugin.report.service.h.OAn.kJ(991, 16);
            }
            if ((localesa.vhJ != 104) || (Util.isNullOrNil(localesa.abvT))) {
              break;
            }
            Log.i("MicroMsg.LuckyMoneyEnvelopeResUpdateListener", "real donwload pag resource");
            com.tencent.mm.plugin.report.service.h.OAn.kJ(991, 20);
            break;
          }
        }
      }
    }
    AppMethodBeat.o(283928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEnvelopeResUpdateListener
 * JD-Core Version:    0.7.0.1
 */