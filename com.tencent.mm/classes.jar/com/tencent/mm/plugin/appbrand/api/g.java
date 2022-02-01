package com.tencent.mm.plugin.appbrand.api;

import android.app.ActivityOptions;
import android.os.PersistableBundle;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import java.util.List;

public final class g
{
  public String appId;
  public String cyq;
  public String cyr;
  public String dCw;
  public int iOo;
  public String kHA;
  public ValueCallback<String> kHB;
  public int kHC;
  public ActivityOptions kHD;
  public String kHE;
  public AppBrandLaunchReferrer kHF;
  public String kHG;
  public String kHH;
  public AppBrandLaunchFromNotifyReferrer kHI;
  public WeAppOpenDeclarePromptBundle kHJ;
  public List<String> kHK;
  public HalfScreenConfig kHL;
  public boolean kHM;
  public i kHN;
  public boolean kHO;
  public ParcelableMultiTaskData kHP;
  public String kHQ;
  public String kHw;
  public d kHx;
  public PersistableBundle kHy;
  public int kHz;
  public int launchMode;
  public int scene;
  public String username;
  public int version;
  
  public g()
  {
    AppMethodBeat.i(153192);
    this.launchMode = 0;
    this.kHL = HalfScreenConfig.lfr;
    this.kHM = false;
    this.kHN = null;
    this.kHO = false;
    this.kHP = null;
    this.kHQ = "";
    this.iOo = 0;
    this.version = 0;
    this.kHw = "";
    this.kHx = null;
    if (this.kHy != null)
    {
      this.kHy.clear();
      this.kHy = null;
    }
    this.kHy = null;
    this.scene = 1000;
    this.kHC = -100;
    this.kHD = null;
    this.kHF = null;
    this.kHJ = null;
    this.kHK = null;
    this.kHL = HalfScreenConfig.lfr;
    this.kHM = false;
    this.kHN = null;
    this.kHO = false;
    this.kHP = null;
    this.kHQ = "";
    AppMethodBeat.o(153192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.api.g
 * JD-Core Version:    0.7.0.1
 */