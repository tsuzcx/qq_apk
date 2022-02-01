package com.tencent.mm.plugin.appbrand.api;

import android.app.ActivityOptions;
import android.os.PersistableBundle;
import android.webkit.ValueCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchFromNotifyReferrer;
import com.tencent.mm.plugin.appbrand.config.AppBrandLaunchReferrer;
import com.tencent.mm.plugin.appbrand.config.HalfScreenConfig;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.widget.j;
import java.util.List;

public final class g
{
  public String appId;
  public int chatType;
  public String eoR;
  public String eoT;
  public String eoU;
  public boolean epf;
  public z epq;
  public String epr;
  public boolean eps;
  public y ept;
  public y epu;
  public int euz;
  public String hzx;
  public String icX;
  public ValueCallback<String> idh;
  public int launchMode;
  public int opX;
  public String qAF;
  public d qAG;
  public PersistableBundle qAH;
  public int qAI;
  public String qAJ;
  public ValueCallback<Integer> qAK;
  public int qAL;
  public ActivityOptions qAM;
  public String qAN;
  public AppBrandLaunchReferrer qAO;
  public String qAP;
  public AppBrandLaunchFromNotifyReferrer qAQ;
  public WeAppOpenDeclarePromptBundle qAR;
  public List<String> qAS;
  public HalfScreenConfig qAT;
  public i qAU;
  public boolean qAV;
  public ParcelableMultiTaskData qAW;
  public String qAX;
  public boolean qAY;
  public Class<? extends j> qAZ;
  public String qBa;
  public int scene;
  public String username;
  public int version;
  
  public g()
  {
    AppMethodBeat.i(153192);
    this.epf = false;
    this.launchMode = 0;
    this.qAT = HalfScreenConfig.rad;
    this.epq = z.raV;
    this.qAU = null;
    this.qAV = false;
    this.qAW = null;
    this.qAX = "";
    this.chatType = -1;
    this.opX = 0;
    this.ept = y.raQ;
    this.epu = y.raQ;
    this.qAY = false;
    this.qAZ = null;
    this.qBa = "";
    this.euz = 0;
    this.version = 0;
    this.qAF = "";
    this.epf = false;
    this.qAG = null;
    if (this.qAH != null)
    {
      this.qAH.clear();
      this.qAH = null;
    }
    this.qAH = null;
    this.scene = 1000;
    this.qAL = -100;
    this.qAM = null;
    this.qAO = null;
    this.qAR = null;
    this.qAS = null;
    this.qAT = HalfScreenConfig.rad;
    this.epq = z.raV;
    this.epr = null;
    this.eps = false;
    this.qAU = null;
    this.qAV = false;
    this.qAW = null;
    this.qAX = "";
    this.chatType = -1;
    this.opX = 0;
    this.ept = y.raQ;
    this.epu = y.raQ;
    this.qAY = false;
    this.qAZ = null;
    this.qBa = "";
    this.idh = null;
    this.qAK = null;
    AppMethodBeat.o(153192);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.api.g
 * JD-Core Version:    0.7.0.1
 */