package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h.a;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class AppBrandVideoWrapper
  extends RelativeLayout
  implements d.a, c, h.a, h.b, h.c
{
  private boolean aLW;
  protected int gDO = 0;
  private boolean gEA;
  private com.tencent.mm.model.d gEB;
  private com.tencent.mm.pluginsdk.ui.h gEt;
  private c.b gEu;
  private g gEv;
  private c.g gEw = c.g.gEF;
  private boolean gEx = false;
  private float gEy = -1.0F;
  private int gEz;
  private Context mContext;
  private String url;
  
  public AppBrandVideoWrapper(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AppBrandVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AppBrandVideoWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    this.gEB = new com.tencent.mm.model.d();
  }
  
  private boolean a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((paramBoolean) || (this.gEA)) {}
    while (com.tencent.mm.compatible.util.d.gG(18)) {
      return true;
    }
    int i = ae.getContext().getSharedPreferences("system_config_prefs", 4).getInt("appbrand_video_player", -1);
    y.d("MicroMsg.AppBrandVideoWrapper", "checkUseSystemPlayer abtestFlag[%d]", new Object[] { Integer.valueOf(i) });
    if (i <= 0)
    {
      y.i("MicroMsg.AppBrandVideoWrapper", "abtest is zero, use system player");
      return true;
    }
    if ((!bk.bl(paramString1)) && (paramString1.contains(".m3u8")))
    {
      y.i("MicroMsg.AppBrandVideoWrapper", "%d it is m3u8 file use system player.", new Object[] { Integer.valueOf(hashCode()) });
      cB(204L);
      return true;
    }
    if (r.nO(paramString2))
    {
      y.i("MicroMsg.AppBrandVideoWrapper", "%d it is m3u8 file use system player.", new Object[] { Integer.valueOf(hashCode()) });
      cB(204L);
      return true;
    }
    return false;
  }
  
  public static void aiE()
  {
    AppBrandVideoView.setProxy(new AppBrandVideoWrapper.1());
  }
  
  private com.tencent.mm.pluginsdk.ui.h akR()
  {
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.setReporter(this);
    localCommonVideoView.DU(this.gDO);
    localCommonVideoView.setIMMVideoViewCallback(this);
    cB(200L);
    return localCommonVideoView;
  }
  
  private com.tencent.mm.pluginsdk.ui.h akS()
  {
    MMVideoView localMMVideoView = new MMVideoView(this.mContext);
    localMMVideoView.setReporter(this);
    localMMVideoView.setIMMVideoViewCallback(this);
    localMMVideoView.setIOnlineVideoProxy(new AppBrandOnlineVideoProxy());
    localMMVideoView.setIMMDownloadFinish(this);
    String str = com.tencent.mm.compatible.util.e.bkH + "appbrandvideo/";
    com.tencent.mm.sdk.platformtools.h.Vu(str);
    localMMVideoView.setRootPath(str);
    cB(201L);
    return localMMVideoView;
  }
  
  public final void Se()
  {
    if (this.gEt != null) {
      this.gEt.Se();
    }
    this.gEB.bH(false);
    setKeepScreenOn(false);
  }
  
  public final void Sf()
  {
    if (this.gEt != null) {
      this.gEt.Sf();
    }
  }
  
  public final void ai(String paramString, boolean paramBoolean)
  {
    y.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { Integer.valueOf(hashCode()), paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean) {
      return;
    }
    int i;
    if (a(false, "", paramString))
    {
      if (!(this.gEt instanceof MMVideoView)) {
        break label285;
      }
      this.gEt.stop();
      this.gEt.bFF();
      removeView((View)this.gEt);
      y.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use common video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.gEt = akR();
      i = 1;
    }
    for (;;)
    {
      setScaleType(this.gEw);
      aj(this.gEy);
      setMute(this.gEx);
      if (i == 0) {
        break;
      }
      setVideoFooterView(this.gEv);
      paramString = new RelativeLayout.LayoutParams(-1, -1);
      addView((View)this.gEt, paramString);
      this.gEt.c(this.aLW, this.url, this.gEz);
      this.gEt.start();
      return;
      if ((this.gEt instanceof CommonVideoView))
      {
        this.gEt.stop();
        this.gEt.bFF();
        removeView((View)this.gEt);
        y.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.gEt = akS();
        i = 1;
      }
      else
      {
        label285:
        i = 0;
      }
    }
  }
  
  public final boolean aj(float paramFloat)
  {
    if (paramFloat <= 0.0F) {}
    do
    {
      return false;
      this.gEy = paramFloat;
    } while (this.gEt == null);
    return this.gEt.aj(this.gEy);
  }
  
  public final void akT()
  {
    if (this.gEt != null) {
      this.gEt.akT();
    }
    this.gEB.bH(false);
    setKeepScreenOn(false);
  }
  
  public final void bH(String paramString1, String paramString2)
  {
    y.i("MicroMsg.AppBrandVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.gEu != null) {
      this.gEu.akt();
    }
    if (isLive())
    {
      cB(203L);
      return;
    }
    cB(202L);
  }
  
  public final void bI(String paramString1, String paramString2)
  {
    y.i("MicroMsg.AppBrandVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.gEu != null) {
      this.gEu.aku();
    }
  }
  
  public final void bJ(String paramString1, String paramString2)
  {
    y.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.gEB.bH(false);
    if (this.gEu != null) {
      this.gEu.akv();
    }
  }
  
  public final void bK(String paramString1, String paramString2)
  {
    y.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.gEB.a(this);
    if (this.gEu != null) {
      this.gEu.akw();
    }
  }
  
  public final void bL(String paramString1, String paramString2)
  {
    if (this.gEu != null) {
      this.gEu.akx();
    }
  }
  
  public final void bM(String paramString1, String paramString2)
  {
    if (this.gEu != null) {
      this.gEu.aky();
    }
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    y.w("MicroMsg.AppBrandVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.gEu != null) {
      this.gEu.F(paramString3, paramInt1, paramInt2);
    }
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    int i = 1;
    this.gEz = paramInt;
    this.aLW = paramBoolean;
    PString localPString = new PString();
    localPString.value = paramString;
    if ((!bk.bl(localPString.value)) && (localPString.value.indexOf("file://") == 0))
    {
      localPString.value = localPString.value.substring(7);
      paramBoolean = true;
      this.gEA = paramBoolean;
      this.url = localPString.value;
      if (this.gEt != null) {
        break label278;
      }
      if (!a(this.aLW, this.url, "")) {
        break label242;
      }
      y.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.gEt = akR();
      paramInt = i;
    }
    for (;;)
    {
      setScaleType(this.gEw);
      aj(this.gEy);
      setMute(this.gEx);
      if (paramInt != 0)
      {
        setVideoFooterView(this.gEv);
        paramString = new RelativeLayout.LayoutParams(-1, -1);
        addView((View)this.gEt, paramString);
      }
      this.gEt.c(this.aLW, this.url, this.gEz);
      com.tencent.mm.sdk.f.e.post(new AppBrandVideoWrapper.2(this), "AppBrandVideo_checkVideoUrl");
      return;
      paramBoolean = false;
      break;
      label242:
      y.i("MicroMsg.AppBrandVideoWrapper", "%d use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.gEt = akS();
      paramInt = i;
      continue;
      label278:
      if (a(this.aLW, this.url, ""))
      {
        if ((this.gEt instanceof MMVideoView))
        {
          this.gEt.stop();
          this.gEt.bFF();
          removeView((View)this.gEt);
          y.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
          this.gEt = akR();
          paramInt = i;
        }
        else
        {
          y.i("MicroMsg.AppBrandVideoWrapper", "%d use last common video view !", new Object[] { Integer.valueOf(hashCode()) });
          this.gEt.stop();
          paramInt = 0;
        }
      }
      else if ((this.gEt instanceof CommonVideoView))
      {
        this.gEt.stop();
        this.gEt.bFF();
        removeView((View)this.gEt);
        y.i("MicroMsg.AppBrandVideoWrapper", "%d use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.gEt = akS();
        paramInt = i;
      }
      else
      {
        y.i("MicroMsg.AppBrandVideoWrapper", "%d use last mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.gEt.stop();
        paramInt = 0;
      }
    }
  }
  
  public final void cB(long paramLong)
  {
    com.tencent.mm.plugin.report.service.h.nFQ.a(600L, paramLong, 1L, false);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.gEu != null) {
      this.gEu.bY(paramInt1, paramInt2);
    }
  }
  
  public int getCacheTimeSec()
  {
    if (this.gEt != null) {
      return this.gEt.getCacheTimeSec();
    }
    return 0;
  }
  
  public int getCurrPosMs()
  {
    if (this.gEt != null) {
      return this.gEt.getCurrPosMs();
    }
    return 0;
  }
  
  public int getCurrPosSec()
  {
    if (this.gEt != null) {
      return this.gEt.getCurrPosSec();
    }
    return 0;
  }
  
  public int getPlayerType()
  {
    if (this.gEt != null) {
      return this.gEt.getPlayerType();
    }
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    if (this.gEt != null) {
      return this.gEt.getVideoDurationSec();
    }
    return this.gEz;
  }
  
  public final boolean isLive()
  {
    if (this.gEt != null) {
      return this.gEt.isLive();
    }
    return false;
  }
  
  public final boolean isPlaying()
  {
    if (this.gEt != null) {
      return this.gEt.isPlaying();
    }
    return false;
  }
  
  public final boolean lF(int paramInt)
  {
    if (this.gEt != null) {
      return this.gEt.lF(paramInt);
    }
    return false;
  }
  
  public final boolean pause()
  {
    boolean bool = false;
    if (this.gEt != null)
    {
      setKeepScreenOn(false);
      this.gEB.bH(false);
      bool = this.gEt.pause();
    }
    return bool;
  }
  
  public final void qk(String paramString)
  {
    com.tencent.mm.plugin.report.service.h.nFQ.aC(14349, paramString);
  }
  
  public void setControlBar(c.a parama) {}
  
  public void setCover(Bitmap paramBitmap)
  {
    if (this.gEt != null) {
      this.gEt.setCover(paramBitmap);
    }
  }
  
  public void setFullDirection(int paramInt)
  {
    if (this.gEt != null) {
      this.gEt.setFullDirection(paramInt);
    }
  }
  
  public void setIMMVideoViewCallback(c.b paramb)
  {
    this.gEu = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    if (this.gEt != null) {
      this.gEt.setIsShowBasicControls(paramBoolean);
    }
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    y.d("MicroMsg.AppBrandVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bk.csb() });
    super.setKeepScreenOn(paramBoolean);
  }
  
  public void setMute(boolean paramBoolean)
  {
    this.gEx = paramBoolean;
    if (this.gEt != null) {
      this.gEt.setMute(this.gEx);
    }
  }
  
  public void setScaleType(c.g paramg)
  {
    this.gEw = paramg;
    com.tencent.mm.pluginsdk.ui.h localh;
    int i;
    if (this.gEt != null)
    {
      localh = this.gEt;
      paramg = this.gEw;
      if (paramg != null)
      {
        paramg = paramg.name();
        i = -1;
      }
      switch (paramg.hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          paramg = h.d.rZQ;
        }
        break;
      }
    }
    for (;;)
    {
      localh.setScaleType(paramg);
      return;
      if (!paramg.equals("CONTAIN")) {
        break;
      }
      i = 0;
      break;
      if (!paramg.equals("COVER")) {
        break;
      }
      i = 1;
      break;
      if (!paramg.equals("FILL")) {
        break;
      }
      i = 2;
      break;
      paramg = h.d.rZS;
      continue;
      paramg = h.d.rZT;
      continue;
      paramg = h.d.rZR;
    }
  }
  
  public void setVideoFooterView(g paramg)
  {
    this.gEv = paramg;
    if (this.gEt != null) {
      this.gEt.setVideoFooterView(this.gEv);
    }
  }
  
  public void setVideoSource(int paramInt)
  {
    this.gDO = paramInt;
  }
  
  public final void start()
  {
    if (this.gEt != null)
    {
      this.gEt.start();
      setKeepScreenOn(true);
      this.gEB.a(this);
    }
  }
  
  public final void stop()
  {
    if (this.gEt != null)
    {
      this.gEt.stop();
      this.gEB.bH(false);
      setKeepScreenOn(false);
    }
  }
  
  public final boolean y(int paramInt, boolean paramBoolean)
  {
    if (this.gEt != null) {
      return this.gEt.y(paramInt, paramBoolean);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper
 * JD-Core Version:    0.7.0.1
 */