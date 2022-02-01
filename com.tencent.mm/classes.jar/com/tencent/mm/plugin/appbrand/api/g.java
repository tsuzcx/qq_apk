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
  public int cBU;
  public int chatType;
  public String cwT;
  public String cwU;
  public String fWY;
  public String fvd;
  public int launchMode;
  public int lyw;
  public String nBA;
  public AppBrandLaunchFromNotifyReferrer nBB;
  public WeAppOpenDeclarePromptBundle nBC;
  public List<String> nBD;
  public HalfScreenConfig nBE;
  public boolean nBF;
  public i nBG;
  public boolean nBH;
  public ParcelableMultiTaskData nBI;
  public String nBJ;
  public String nBq;
  public d nBr;
  public PersistableBundle nBs;
  public int nBt;
  public String nBu;
  public ValueCallback<String> nBv;
  public int nBw;
  public ActivityOptions nBx;
  public String nBy;
  public AppBrandLaunchReferrer nBz;
  public int scene;
  public String username;
  public int version;
  
  public g()
  {
    AppMethodBeat.i(153192);
    this.launchMode = 0;
    this.nBE = HalfScreenConfig.nZJ;
    this.nBF = false;
    this.nBG = null;
    this.nBH = false;
    this.nBI = null;
    this.nBJ = "";
    this.chatType = -1;
    this.lyw = 0;
    this.cBU = 0;
    this.version = 0;
    this.nBq = "";
    this.nBr = null;
    if (this.nBs != null)
    {
      this.nBs.clear();
      this.nBs = null;
    }
    this.nBs = null;
    this.scene = 1000;
    this.nBw = -100;
    this.nBx = null;
    this.nBz = null;
    this.nBC = null;
    this.nBD = null;
    this.nBE = HalfScreenConfig.nZJ;
    this.nBF = false;
    this.nBG = null;
    this.nBH = false;
    this.nBI = null;
    this.nBJ = "";
    this.chatType = -1;
    this.lyw = 0;
    AppMethodBeat.o(153192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.api.g
 * JD-Core Version:    0.7.0.1
 */