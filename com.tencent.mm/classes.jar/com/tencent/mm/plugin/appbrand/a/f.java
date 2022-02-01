package com.tencent.mm.plugin.appbrand.a;

import android.app.ActivityOptions;
import android.os.PersistableBundle;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;

public final class f
{
  public String appId;
  public String cYP;
  public int hxM;
  public String jjf;
  public d jjg;
  public PersistableBundle jjh;
  public int jji;
  public String jjj;
  public ValueCallback<String> jjk;
  public int jjl;
  public ActivityOptions jjm;
  public String jjn;
  public AppBrandLaunchReferrer jjo;
  public String jjp;
  public String jjq;
  public AppBrandLaunchFromNotifyReferrer jjr;
  public int launchMode;
  public int scene;
  public String username;
  public int version;
  
  public f()
  {
    AppMethodBeat.i(153192);
    this.launchMode = 0;
    this.hxM = 0;
    this.version = 0;
    this.jjf = "";
    this.jjg = null;
    if (this.jjh != null) {
      this.jjh.clear();
    }
    this.jjh = null;
    this.scene = 1000;
    this.jjl = -100;
    this.jjm = null;
    this.jjo = null;
    AppMethodBeat.o(153192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.f
 * JD-Core Version:    0.7.0.1
 */