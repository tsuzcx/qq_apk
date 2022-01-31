package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.g.a;
import com.tencent.mm.sdk.platformtools.ae;

public class TMAssistantProfile
  extends e
{
  public static final String bwr = ae.getPackageName() + ":TMAssistantDownloadSDKService";
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    a.aQ(ae.getContext());
    k.cl(bwr);
    com.tencent.mm.compatible.util.k.setupBrokenLibraryHandler();
    p.tb();
  }
  
  public String toString()
  {
    return bwr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.TMAssistantProfile
 * JD-Core Version:    0.7.0.1
 */