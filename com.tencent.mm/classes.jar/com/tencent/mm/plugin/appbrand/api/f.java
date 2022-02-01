package com.tencent.mm.plugin.appbrand.api;

import android.app.ActivityOptions;
import android.os.PersistableBundle;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;

public final class f
{
  public String appId;
  public String cmv;
  public String cmw;
  public String dlj;
  public int hSZ;
  public String jFL;
  public d jFM;
  public PersistableBundle jFN;
  public int jFO;
  public String jFP;
  public ValueCallback<String> jFQ;
  public int jFR;
  public ActivityOptions jFS;
  public String jFT;
  public AppBrandLaunchReferrer jFU;
  public String jFV;
  public String jFW;
  public AppBrandLaunchFromNotifyReferrer jFX;
  public WeAppOpenDeclarePromptBundle jFY;
  public int launchMode;
  public int scene;
  public String username;
  public int version;
  
  public f()
  {
    AppMethodBeat.i(153192);
    this.launchMode = 0;
    this.hSZ = 0;
    this.version = 0;
    this.jFL = "";
    this.jFM = null;
    if (this.jFN != null) {
      this.jFN.clear();
    }
    this.jFN = null;
    this.scene = 1000;
    this.jFR = -100;
    this.jFS = null;
    this.jFU = null;
    this.jFY = null;
    AppMethodBeat.o(153192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.api.f
 * JD-Core Version:    0.7.0.1
 */