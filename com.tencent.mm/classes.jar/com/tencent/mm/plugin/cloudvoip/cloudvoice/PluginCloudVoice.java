package com.tencent.mm.plugin.cloudvoip.cloudvoice;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.d;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.a.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.voip.mars.comm.PlatformComm;

public class PluginCloudVoice
  extends f
  implements c, a
{
  private static final String[] iEn = { "confService", "marsbridgenetwork", "marsbridgexlog" };
  
  private void init(Context paramContext)
  {
    PlatformComm.init(paramContext, new Handler(Looper.getMainLooper()));
  }
  
  private boolean isAppBrandProcess()
  {
    try
    {
      String str = ae.getPackageName();
      boolean bool = ((h)com.tencent.mm.kernel.g.DM().Dr()).dIA.startsWith(str + ":appbrand");
      return bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  private void prepareOpenVoiceEnv(Context paramContext)
  {
    y.i("MicroMsg.OpenVoice.PluginCloudVoice", "hy: load so");
    String[] arrayOfString = iEn;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      k.b(arrayOfString[i], paramContext.getClassLoader());
      i += 1;
    }
    init(paramContext);
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    super.configure(paramg);
    y.i("MicroMsg.OpenVoice.PluginCloudVoice", "hy: PluginCloudVoice configure");
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    y.i("MicroMsg.OpenVoice.PluginCloudVoice", "hy: PluginCloudVoice execute");
    if ((isAppBrandProcess()) || (ae.cqX())) {
      prepareOpenVoiceEnv(ae.getContext());
    }
  }
  
  public void onAccountInitialized(e.c paramc) {}
  
  public void onAccountRelease()
  {
    y.i("MicroMsg.OpenVoice.PluginCloudVoice", "hy: account release. uninit openvoice so");
    j localj = j.iFl;
    localj.H(localj.iFJ);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.PluginCloudVoice
 * JD-Core Version:    0.7.0.1
 */