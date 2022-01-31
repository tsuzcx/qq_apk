package com.tencent.mm.app;

import android.content.res.Configuration;
import com.tencent.mm.compatible.loader.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.x;

public class NoSpaceProfile
  extends e
{
  public static final String bwr = ae.getPackageName() + ":nospace";
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onCreate()
  {
    k.cl(bwr);
    com.tencent.mm.compatible.util.k.setupBrokenLibraryHandler();
    x.initLanguage(ae.getContext());
    p.tb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.NoSpaceProfile
 * JD-Core Version:    0.7.0.1
 */