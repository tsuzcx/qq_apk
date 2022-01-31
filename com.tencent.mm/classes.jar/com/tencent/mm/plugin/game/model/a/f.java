package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.a;
import com.tencent.mm.game.report.api.b;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.game.api.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class f
{
  static void O(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111520);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(111520);
      return;
    }
    FileDownloadTaskInfo localFileDownloadTaskInfo = com.tencent.mm.plugin.downloader.model.f.bjl().JH(paramString);
    if ((localFileDownloadTaskInfo != null) && (localFileDownloadTaskInfo.id > 0L))
    {
      long l = localFileDownloadTaskInfo.id;
      String str = localFileDownloadTaskInfo.url;
      if (localFileDownloadTaskInfo.jyU == 0L) {}
      for (int i = 0;; i = (int)(localFileDownloadTaskInfo.kYX * 100L / localFileDownloadTaskInfo.jyU))
      {
        a(paramString, l, str, i, paramInt1, paramInt2, false, false, false, false, false, "");
        AppMethodBeat.o(111520);
        return;
      }
    }
    a(paramString, 0L, "", 0, paramInt1, paramInt2, false, false, false, false, false, "");
    AppMethodBeat.o(111520);
  }
  
  public static void Qh(String paramString)
  {
    AppMethodBeat.i(111518);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(111518);
      return;
    }
    FileDownloadTaskInfo localFileDownloadTaskInfo = com.tencent.mm.plugin.downloader.model.f.bjl().JH(paramString);
    Object localObject = ((e)com.tencent.mm.kernel.g.E(e.class)).bEU().Qi(paramString);
    if ((localFileDownloadTaskInfo != null) && (localFileDownloadTaskInfo.id > 0L))
    {
      if (localObject != null)
      {
        l = localFileDownloadTaskInfo.id;
        String str = localFileDownloadTaskInfo.url;
        if (localFileDownloadTaskInfo.jyU == 0L) {}
        for (i = 0;; i = (int)(localFileDownloadTaskInfo.kYX * 100L / localFileDownloadTaskInfo.jyU))
        {
          a(paramString, l, str, i, 3, 0, ((d)localObject).field_noWifi, ((d)localObject).field_noSdcard, ((d)localObject).field_noEnoughSpace, ((d)localObject).field_lowBattery, ((d)localObject).field_continueDelay, "");
          AppMethodBeat.o(111518);
          return;
        }
      }
      long l = localFileDownloadTaskInfo.id;
      localObject = localFileDownloadTaskInfo.url;
      if (localFileDownloadTaskInfo.jyU == 0L) {}
      for (int i = 0;; i = (int)(localFileDownloadTaskInfo.kYX * 100L / localFileDownloadTaskInfo.jyU))
      {
        a(paramString, l, (String)localObject, i, 3, 0, false, false, false, false, false, "");
        AppMethodBeat.o(111518);
        return;
      }
    }
    if (localObject != null)
    {
      a(paramString, 0L, "", 0, 3, 0, ((d)localObject).field_noWifi, ((d)localObject).field_noSdcard, ((d)localObject).field_noEnoughSpace, ((d)localObject).field_lowBattery, ((d)localObject).field_continueDelay, "");
      AppMethodBeat.o(111518);
      return;
    }
    a(paramString, 0L, "", 0, 3, 0, false, false, false, false, false, "");
    AppMethodBeat.o(111518);
  }
  
  private static void a(String paramString1, long paramLong, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString3)
  {
    AppMethodBeat.i(111521);
    ab.i("MicroMsg.GameSilentDownloadReporter", "reportInfo, appId:%s, downloadId:%d, downloadUrl:%s, downloadedPct:%d, finishType:%d, errCode:%d, noWifi:%b, noSdcard:%b, noEnoughSpace:%b, lowBattery:%b, continueDelay:%b", new Object[] { paramString1, Long.valueOf(paramLong), paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean4), Boolean.valueOf(paramBoolean5) });
    try
    {
      if (bo.isNullOrNil(paramString2)) {
        break label363;
      }
      str1 = URLEncoder.encode(paramString2, "UTF-8");
      paramString2 = str1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      String str4;
      for (;;)
      {
        String str1;
        str2 = paramString2;
        str4 = paramString3;
      }
    }
    str1 = paramString2;
    str4 = paramString3;
    try
    {
      if (!bo.isNullOrNil(paramString3))
      {
        str4 = URLEncoder.encode(paramString3, "UTF-8");
        str1 = paramString2;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      for (;;)
      {
        int i;
        int j;
        label162:
        int k;
        label170:
        int m;
        label178:
        int n;
        label315:
        label321:
        label327:
        label333:
        String str2;
        String str3 = paramString2;
        str4 = paramString3;
      }
    }
    if (paramBoolean1)
    {
      i = 1;
      if (!paramBoolean2) {
        break label315;
      }
      j = 1;
      if (!paramBoolean3) {
        break label321;
      }
      k = 1;
      if (!paramBoolean4) {
        break label327;
      }
      m = 1;
      if (!paramBoolean5) {
        break label333;
      }
    }
    for (n = 1;; n = 0)
    {
      paramString1 = q(new Object[] { paramString1, Long.valueOf(paramLong), str1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), str4 });
      a.ezM.a(new b(15547, paramString1));
      AppMethodBeat.o(111521);
      return;
      i = 0;
      break;
      j = 0;
      break label162;
      k = 0;
      break label170;
      m = 0;
      break label178;
    }
  }
  
  static void aj(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111519);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(111519);
      return;
    }
    if (((e)com.tencent.mm.kernel.g.E(e.class)).bEU().Qi(paramString) != null) {
      O(paramString, paramInt1, paramInt2);
    }
    AppMethodBeat.o(111519);
  }
  
  private static String q(Object... paramVarArgs)
  {
    AppMethodBeat.i(111522);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < 11)
    {
      localStringBuilder.append(String.valueOf(paramVarArgs[i])).append(',');
      i += 1;
    }
    localStringBuilder.append(String.valueOf(paramVarArgs[11]));
    paramVarArgs = localStringBuilder.toString();
    AppMethodBeat.o(111522);
    return paramVarArgs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.f
 * JD-Core Version:    0.7.0.1
 */