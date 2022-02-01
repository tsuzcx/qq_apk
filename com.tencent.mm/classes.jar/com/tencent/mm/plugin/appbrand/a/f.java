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
  public String dbt;
  public int gXn;
  public String iJb;
  public d iJc;
  public PersistableBundle iJd;
  public int iJe;
  public String iJf;
  public ValueCallback<String> iJg;
  public int iJh;
  public ActivityOptions iJi;
  public String iJj;
  public AppBrandLaunchReferrer iJk;
  public String iJl;
  public String iJm;
  public AppBrandLaunchFromNotifyReferrer iJn;
  public int launchMode;
  public int scene;
  public String username;
  public int version;
  
  public f()
  {
    AppMethodBeat.i(153192);
    this.launchMode = 0;
    this.gXn = 0;
    this.version = 0;
    this.iJb = "";
    this.iJc = null;
    if (this.iJd != null) {
      this.iJd.clear();
    }
    this.iJd = null;
    this.scene = 1000;
    this.iJh = -100;
    this.iJi = null;
    this.iJk = null;
    AppMethodBeat.o(153192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.a.f
 * JD-Core Version:    0.7.0.1
 */