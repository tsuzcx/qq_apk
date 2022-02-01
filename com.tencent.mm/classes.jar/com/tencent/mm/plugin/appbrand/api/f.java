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
  public String dkh;
  public int hQh;
  public String jCN;
  public d jCO;
  public PersistableBundle jCP;
  public int jCQ;
  public String jCR;
  public ValueCallback<String> jCS;
  public int jCT;
  public ActivityOptions jCU;
  public String jCV;
  public AppBrandLaunchReferrer jCW;
  public String jCX;
  public String jCY;
  public AppBrandLaunchFromNotifyReferrer jCZ;
  public WeAppOpenDeclarePromptBundle jDa;
  public int launchMode;
  public int scene;
  public String username;
  public int version;
  
  public f()
  {
    AppMethodBeat.i(153192);
    this.launchMode = 0;
    this.hQh = 0;
    this.version = 0;
    this.jCN = "";
    this.jCO = null;
    if (this.jCP != null) {
      this.jCP.clear();
    }
    this.jCP = null;
    this.scene = 1000;
    this.jCT = -100;
    this.jCU = null;
    this.jCW = null;
    this.jDa = null;
    AppMethodBeat.o(153192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.api.f
 * JD-Core Version:    0.7.0.1
 */