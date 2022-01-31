package com.tencent.mm.plugin.gai;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.tencent.mm.sdk.platformtools.y;

final class Plugin$2
  implements Runnable
{
  Plugin$2(Plugin paramPlugin, Context paramContext, Plugin.a parama) {}
  
  public final void run()
  {
    String str = "";
    Object localObject1 = null;
    Object localObject2 = null;
    try
    {
      AdvertisingIdClient.Info localInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.val$context);
      localObject2 = localInfo;
      localObject1 = localInfo;
      y.d("MicroMsg.Plugin.gai", "adInfo: %s", new Object[] { localInfo });
      return;
    }
    catch (Exception localException)
    {
      do
      {
        localObject1 = localObject2;
        y.printErrStackTrace("MicroMsg.Plugin.gai", localException, "AdMatReport:: get Ad Id info error %s", new Object[] { localException.getMessage() });
        localObject1 = localObject2;
        y.e("MicroMsg.Plugin.gai", "AdMatReport:: get Ad Id info error %s", new Object[] { localException.getMessage() });
      } while (this.kGf == null);
      this.kGf.Em("");
      return;
    }
    finally
    {
      if (localObject1 != null)
      {
        str = localObject1.getId();
        y.i("MicroMsg.Plugin.gai", "get GoogleAid : [%s]", new Object[] { str });
      }
      if (this.kGf != null) {
        this.kGf.Em(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.gai.Plugin.2
 * JD-Core Version:    0.7.0.1
 */