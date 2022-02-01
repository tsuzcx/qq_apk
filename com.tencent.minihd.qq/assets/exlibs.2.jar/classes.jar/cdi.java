import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.tmdownloader.ITMAssistantDownloadClientListener;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import java.util.HashMap;

public final class cdi
  implements ITMAssistantDownloadClientListener
{
  public void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString, long paramLong1, long paramLong2)
  {
    if (paramTMAssistantDownloadClient == null) {}
    do
    {
      return;
      paramTMAssistantDownloadClient = (cdh)OfflineDownloader.a().get(paramString);
    } while ((paramTMAssistantDownloadClient == null) || (paramTMAssistantDownloadClient.a == null));
    int i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
    paramTMAssistantDownloadClient.a.a(i);
  }
  
  public void OnDownloadSDKTaskStateChanged(TMAssistantDownloadClient paramTMAssistantDownloadClient, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    if (paramTMAssistantDownloadClient == null)
    {
      OfflineDownloader.a(null, paramString1, null, -1, "client is null, " + paramString2);
      return;
    }
    paramString2 = (cdh)OfflineDownloader.a().get(paramString1);
    if ((paramString2 == null) || (paramString2.a == null))
    {
      OfflineDownloader.a(null, paramString1, null, -1, "download info is null or callback is null");
      return;
    }
    switch (paramInt1)
    {
    case 2: 
    case 3: 
    default: 
      return;
    case 4: 
      OfflineDownloader.a(paramTMAssistantDownloadClient, paramString2, paramString1);
      return;
    }
    OfflineDownloader.a(paramString2.a, paramString1, paramString2.c, paramInt2, "offline zip download fail");
    OfflineDownloader.a().cancelDownloadTask(paramString1);
  }
  
  public void OnDwonloadSDKServiceInvalid(TMAssistantDownloadClient paramTMAssistantDownloadClient) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     cdi
 * JD-Core Version:    0.7.0.1
 */