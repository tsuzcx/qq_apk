package com.tencent.mm.plugin.game.model.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class e
{
  static void C(String paramString, int paramInt1, int paramInt2)
  {
    if (bk.bl(paramString)) {
      return;
    }
    FileDownloadTaskInfo localFileDownloadTaskInfo = com.tencent.mm.plugin.downloader.model.d.aFP().zL(paramString);
    if ((localFileDownloadTaskInfo != null) && (localFileDownloadTaskInfo.id > 0L))
    {
      long l = localFileDownloadTaskInfo.id;
      String str = localFileDownloadTaskInfo.url;
      if (localFileDownloadTaskInfo.hFz == 0L) {}
      for (int i = 0;; i = (int)(localFileDownloadTaskInfo.iPM * 100L / localFileDownloadTaskInfo.hFz))
      {
        a(paramString, l, str, i, paramInt1, paramInt2, false, false, false, false, false, "");
        return;
      }
    }
    a(paramString, 0L, "", 0, paramInt1, paramInt2, false, false, false, false, false, "");
  }
  
  public static void EP(String paramString)
  {
    if (bk.bl(paramString)) {
      return;
    }
    FileDownloadTaskInfo localFileDownloadTaskInfo = com.tencent.mm.plugin.downloader.model.d.aFP().zL(paramString);
    Object localObject = ((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYh().EQ(paramString);
    if ((localFileDownloadTaskInfo != null) && (localFileDownloadTaskInfo.id > 0L))
    {
      if (localObject != null)
      {
        l = localFileDownloadTaskInfo.id;
        String str = localFileDownloadTaskInfo.url;
        if (localFileDownloadTaskInfo.hFz == 0L) {}
        for (i = 0;; i = (int)(localFileDownloadTaskInfo.iPM * 100L / localFileDownloadTaskInfo.hFz))
        {
          a(paramString, l, str, i, 3, 0, ((c)localObject).field_noWifi, ((c)localObject).field_noSdcard, ((c)localObject).field_noEnoughSpace, ((c)localObject).field_lowBattery, ((c)localObject).field_continueDelay, "");
          return;
        }
      }
      long l = localFileDownloadTaskInfo.id;
      localObject = localFileDownloadTaskInfo.url;
      if (localFileDownloadTaskInfo.hFz == 0L) {}
      for (int i = 0;; i = (int)(localFileDownloadTaskInfo.iPM * 100L / localFileDownloadTaskInfo.hFz))
      {
        a(paramString, l, (String)localObject, i, 3, 0, false, false, false, false, false, "");
        return;
      }
    }
    if (localObject != null)
    {
      a(paramString, 0L, "", 0, 3, 0, ((c)localObject).field_noWifi, ((c)localObject).field_noSdcard, ((c)localObject).field_noEnoughSpace, ((c)localObject).field_lowBattery, ((c)localObject).field_continueDelay, "");
      return;
    }
    a(paramString, 0L, "", 0, 3, 0, false, false, false, false, false, "");
  }
  
  static void T(String paramString, int paramInt1, int paramInt2)
  {
    if (bk.bl(paramString)) {}
    while (((com.tencent.mm.plugin.game.a.c)g.r(com.tencent.mm.plugin.game.a.c.class)).aYh().EQ(paramString) == null) {
      return;
    }
    C(paramString, paramInt1, paramInt2);
  }
  
  private static void a(String paramString1, long paramLong, String paramString2, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString3)
  {
    y.i("MicroMsg.GameSilentDownloadReporter", "reportInfo, appId:%s, downloadId:%d, downloadUrl:%s, downloadedPct:%d, finishType:%d, errCode:%d, noWifi:%b, noSdcard:%b, noEnoughSpace:%b, lowBattery:%b, continueDelay:%b", new Object[] { paramString1, Long.valueOf(paramLong), paramString2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3), Boolean.valueOf(paramBoolean4), Boolean.valueOf(paramBoolean5) });
    try
    {
      if (bk.bl(paramString2)) {
        break label411;
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
      if (!bk.bl(paramString3))
      {
        str4 = URLEncoder.encode(paramString3, "UTF-8");
        str1 = paramString2;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      for (;;)
      {
        String str2;
        String str3 = paramString2;
        str4 = paramString3;
      }
    }
    paramString2 = new Object[12];
    paramString2[0] = paramString1;
    paramString2[1] = Long.valueOf(paramLong);
    paramString2[2] = str1;
    paramString2[3] = Integer.valueOf(paramInt1);
    paramString2[4] = Integer.valueOf(paramInt2);
    paramString2[5] = Integer.valueOf(paramInt3);
    if (paramBoolean1)
    {
      paramInt1 = 1;
      paramString2[6] = Integer.valueOf(paramInt1);
      if (!paramBoolean2) {
        break label328;
      }
      paramInt1 = 1;
      label212:
      paramString2[7] = Integer.valueOf(paramInt1);
      if (!paramBoolean3) {
        break label334;
      }
      paramInt1 = 1;
      label229:
      paramString2[8] = Integer.valueOf(paramInt1);
      if (!paramBoolean4) {
        break label340;
      }
      paramInt1 = 1;
      label246:
      paramString2[9] = Integer.valueOf(paramInt1);
      if (!paramBoolean5) {
        break label346;
      }
    }
    label328:
    label334:
    label340:
    label346:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramString2[10] = Integer.valueOf(paramInt1);
      paramString2[11] = str4;
      paramString1 = new StringBuilder();
      paramInt1 = 0;
      while (paramInt1 < 11)
      {
        paramString1.append(String.valueOf(paramString2[paramInt1])).append(',');
        paramInt1 += 1;
      }
      paramInt1 = 0;
      break;
      paramInt1 = 0;
      break label212;
      paramInt1 = 0;
      break label229;
      paramInt1 = 0;
      break label246;
    }
    paramString1.append(String.valueOf(paramString2[11]));
    paramString1 = paramString1.toString();
    com.tencent.mm.game.report.api.c.dCx.a(new com.tencent.mm.game.report.api.d(15547, paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.a.e
 * JD-Core Version:    0.7.0.1
 */