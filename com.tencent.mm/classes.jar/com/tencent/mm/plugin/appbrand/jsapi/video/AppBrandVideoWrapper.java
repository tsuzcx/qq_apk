package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h.a;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.j;

public class AppBrandVideoWrapper
  extends RelativeLayout
  implements com.tencent.mm.model.d.a, d, h.a, h.b, h.c
{
  private boolean aTq;
  private boolean fcD;
  protected int icR;
  private g idA;
  private d.g idB;
  private float idC;
  private int idD;
  private boolean idE;
  private com.tencent.mm.model.d idF;
  private com.tencent.mm.pluginsdk.ui.h idy;
  private d.b idz;
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
    AppMethodBeat.i(131588);
    this.idB = d.g.idJ;
    this.fcD = false;
    this.idC = -1.0F;
    this.icR = 0;
    this.mContext = paramContext;
    this.idF = new com.tencent.mm.model.d();
    AppMethodBeat.o(131588);
  }
  
  private boolean a(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(131592);
    if ((paramBoolean) || (this.idE))
    {
      AppMethodBeat.o(131592);
      return true;
    }
    if (com.tencent.mm.compatible.util.d.fw(18))
    {
      AppMethodBeat.o(131592);
      return true;
    }
    int i = ah.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.h.Mp()).getInt("appbrand_video_player", -1);
    ab.d("MicroMsg.AppBrandVideoWrapper", "checkUseSystemPlayer abtestFlag[%d]", new Object[] { Integer.valueOf(i) });
    if (i <= 0)
    {
      ab.i("MicroMsg.AppBrandVideoWrapper", "abtest is zero, use system player");
      AppMethodBeat.o(131592);
      return true;
    }
    if ((!bo.isNullOrNil(paramString1)) && (paramString1.contains(".m3u8")))
    {
      ab.i("MicroMsg.AppBrandVideoWrapper", "%d it is m3u8 file use system player.", new Object[] { Integer.valueOf(hashCode()) });
      hB(204L);
      AppMethodBeat.o(131592);
      return true;
    }
    if (r.vb(paramString2))
    {
      ab.i("MicroMsg.AppBrandVideoWrapper", "%d it is m3u8 file use system player.", new Object[] { Integer.valueOf(hashCode()) });
      hB(204L);
      AppMethodBeat.o(131592);
      return true;
    }
    AppMethodBeat.o(131592);
    return false;
  }
  
  public static void aCz()
  {
    AppMethodBeat.i(131587);
    AppBrandVideoView.setProxy(new AppBrandVideoWrapper.1());
    AppMethodBeat.o(131587);
  }
  
  private com.tencent.mm.pluginsdk.ui.h aFB()
  {
    AppMethodBeat.i(131590);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.setReporter(this);
    localCommonVideoView.LS(this.icR);
    localCommonVideoView.setIMMVideoViewCallback(this);
    hB(200L);
    AppMethodBeat.o(131590);
    return localCommonVideoView;
  }
  
  private com.tencent.mm.pluginsdk.ui.h aFC()
  {
    AppMethodBeat.i(131591);
    MMVideoView localMMVideoView = new MMVideoView(this.mContext);
    localMMVideoView.setReporter(this);
    localMMVideoView.setIMMVideoViewCallback(this);
    localMMVideoView.setIOnlineVideoProxy(new AppBrandOnlineVideoProxy());
    localMMVideoView.setIMMDownloadFinish(this);
    String str = e.eQz + "appbrandvideo/";
    j.akQ(str);
    localMMVideoView.setRootPath(str);
    hB(201L);
    AppMethodBeat.o(131591);
    return localMMVideoView;
  }
  
  public final void aEM()
  {
    AppMethodBeat.i(131612);
    if (this.idy != null) {
      this.idy.aEM();
    }
    this.idF.cJ(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(131612);
  }
  
  public final void alo()
  {
    AppMethodBeat.i(131611);
    if (this.idy != null) {
      this.idy.alo();
    }
    this.idF.cJ(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(131611);
  }
  
  public final void alp()
  {
    AppMethodBeat.i(131610);
    if (this.idy != null) {
      this.idy.alp();
    }
    AppMethodBeat.o(131610);
  }
  
  public final void an(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(131615);
    ab.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { Integer.valueOf(hashCode()), paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      AppMethodBeat.o(131615);
      return;
    }
    int i;
    if (a(false, "", paramString))
    {
      if (!(this.idy instanceof MMVideoView)) {
        break label302;
      }
      this.idy.stop();
      this.idy.crA();
      removeView((View)this.idy);
      ab.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use common video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.idy = aFB();
      i = 1;
    }
    for (;;)
    {
      setScaleType(this.idB);
      ay(this.idC);
      setMute(this.fcD);
      if (i != 0)
      {
        setVideoFooterView(this.idA);
        paramString = new RelativeLayout.LayoutParams(-1, -1);
        addView((View)this.idy, paramString);
        this.idy.c(this.aTq, this.url, this.idD);
        this.idy.start();
      }
      AppMethodBeat.o(131615);
      return;
      if ((this.idy instanceof CommonVideoView))
      {
        this.idy.stop();
        this.idy.crA();
        removeView((View)this.idy);
        ab.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.idy = aFC();
        i = 1;
      }
      else
      {
        label302:
        i = 0;
      }
    }
  }
  
  public final boolean ay(float paramFloat)
  {
    AppMethodBeat.i(131614);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(131614);
      return false;
    }
    this.idC = paramFloat;
    if (this.idy != null)
    {
      boolean bool = this.idy.ay(this.idC);
      AppMethodBeat.o(131614);
      return bool;
    }
    AppMethodBeat.o(131614);
    return false;
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131616);
    ab.w("MicroMsg.AppBrandVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.idz != null) {
      this.idz.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    AppMethodBeat.o(131616);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(131589);
    this.idD = paramInt;
    this.aTq = paramBoolean;
    PString localPString = new PString();
    localPString.value = paramString;
    if ((!bo.isNullOrNil(localPString.value)) && (localPString.value.indexOf("file://") == 0))
    {
      localPString.value = localPString.value.substring(7);
      paramBoolean = true;
      this.idE = paramBoolean;
      this.url = localPString.value;
      if (this.idy != null) {
        break label289;
      }
      if (!a(this.aTq, this.url, "")) {
        break label253;
      }
      ab.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.idy = aFB();
      paramInt = i;
    }
    for (;;)
    {
      setScaleType(this.idB);
      ay(this.idC);
      setMute(this.fcD);
      if (paramInt != 0)
      {
        setVideoFooterView(this.idA);
        paramString = new RelativeLayout.LayoutParams(-1, -1);
        addView((View)this.idy, paramString);
      }
      this.idy.c(this.aTq, this.url, this.idD);
      com.tencent.mm.sdk.g.d.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(131586);
          AppBrandVideoWrapper.a(AppBrandVideoWrapper.this);
          AppMethodBeat.o(131586);
        }
      }, "AppBrandVideo_checkVideoUrl");
      AppMethodBeat.o(131589);
      return;
      paramBoolean = false;
      break;
      label253:
      ab.i("MicroMsg.AppBrandVideoWrapper", "%d use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
      this.idy = aFC();
      paramInt = i;
      continue;
      label289:
      if (a(this.aTq, this.url, ""))
      {
        if ((this.idy instanceof MMVideoView))
        {
          this.idy.stop();
          this.idy.crA();
          removeView((View)this.idy);
          ab.i("MicroMsg.AppBrandVideoWrapper", "%d use common video view !", new Object[] { Integer.valueOf(hashCode()) });
          this.idy = aFB();
          paramInt = i;
        }
        else
        {
          ab.i("MicroMsg.AppBrandVideoWrapper", "%d use last common video view !", new Object[] { Integer.valueOf(hashCode()) });
          this.idy.stop();
          paramInt = 0;
        }
      }
      else if ((this.idy instanceof CommonVideoView))
      {
        this.idy.stop();
        this.idy.crA();
        removeView((View)this.idy);
        ab.i("MicroMsg.AppBrandVideoWrapper", "%d use mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.idy = aFC();
        paramInt = i;
      }
      else
      {
        ab.i("MicroMsg.AppBrandVideoWrapper", "%d use last mm video view !", new Object[] { Integer.valueOf(hashCode()) });
        this.idy.stop();
        paramInt = 0;
      }
    }
  }
  
  public final void cq(String paramString1, String paramString2)
  {
    AppMethodBeat.i(131617);
    ab.i("MicroMsg.AppBrandVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.idz != null) {
      this.idz.cq(paramString1, paramString2);
    }
    if (isLive())
    {
      hB(203L);
      AppMethodBeat.o(131617);
      return;
    }
    hB(202L);
    AppMethodBeat.o(131617);
  }
  
  public final void cr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(131618);
    ab.i("MicroMsg.AppBrandVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.idz != null) {
      this.idz.cr(paramString1, paramString2);
    }
    AppMethodBeat.o(131618);
  }
  
  public final void cs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(131620);
    ab.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.idF.cJ(false);
    if (this.idz != null) {
      this.idz.cs(paramString1, paramString2);
    }
    AppMethodBeat.o(131620);
  }
  
  public final void ct(String paramString1, String paramString2)
  {
    AppMethodBeat.i(131621);
    ab.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.idF.a(this);
    if (this.idz != null) {
      this.idz.ct(paramString1, paramString2);
    }
    AppMethodBeat.o(131621);
  }
  
  public final void cu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(131622);
    if (this.idz != null) {
      this.idz.cu(paramString1, paramString2);
    }
    AppMethodBeat.o(131622);
  }
  
  public final void cv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(131623);
    if (this.idz != null) {
      this.idz.cv(paramString1, paramString2);
    }
    AppMethodBeat.o(131623);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(131619);
    ab.i("MicroMsg.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.idz != null) {
      this.idz.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(131619);
  }
  
  public final boolean d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(131596);
    if (this.idy != null)
    {
      paramBoolean = this.idy.d(paramDouble, paramBoolean);
      AppMethodBeat.o(131596);
      return paramBoolean;
    }
    AppMethodBeat.o(131596);
    return false;
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(131602);
    if (this.idy != null)
    {
      int i = this.idy.getCacheTimeSec();
      AppMethodBeat.o(131602);
      return i;
    }
    AppMethodBeat.o(131602);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(131600);
    if (this.idy != null)
    {
      int i = this.idy.getCurrPosMs();
      AppMethodBeat.o(131600);
      return i;
    }
    AppMethodBeat.o(131600);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(131601);
    if (this.idy != null)
    {
      int i = this.idy.getCurrPosSec();
      AppMethodBeat.o(131601);
      return i;
    }
    AppMethodBeat.o(131601);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(131594);
    if (this.idy != null)
    {
      int i = this.idy.getPlayerType();
      AppMethodBeat.o(131594);
      return i;
    }
    AppMethodBeat.o(131594);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(131599);
    if (this.idy != null)
    {
      i = this.idy.getVideoDurationSec();
      AppMethodBeat.o(131599);
      return i;
    }
    int i = this.idD;
    AppMethodBeat.o(131599);
    return i;
  }
  
  public final void hB(long paramLong)
  {
    AppMethodBeat.i(131625);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(131625);
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(131604);
    if (this.idy != null)
    {
      boolean bool = this.idy.isLive();
      AppMethodBeat.o(131604);
      return bool;
    }
    AppMethodBeat.o(131604);
    return false;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(131603);
    if (this.idy != null)
    {
      boolean bool = this.idy.isPlaying();
      AppMethodBeat.o(131603);
      return bool;
    }
    AppMethodBeat.o(131603);
    return false;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(131608);
    if (this.idy != null)
    {
      setKeepScreenOn(false);
      this.idF.cJ(false);
      boolean bool = this.idy.pause();
      AppMethodBeat.o(131608);
      return bool;
    }
    AppMethodBeat.o(131608);
    return false;
  }
  
  public final boolean r(double paramDouble)
  {
    AppMethodBeat.i(131595);
    if (this.idy != null)
    {
      boolean bool = this.idy.r(paramDouble);
      AppMethodBeat.o(131595);
      return bool;
    }
    AppMethodBeat.o(131595);
    return false;
  }
  
  public void setControlBar(d.a parama) {}
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(131605);
    if (this.idy != null) {
      this.idy.setCover(paramBitmap);
    }
    AppMethodBeat.o(131605);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(131598);
    if (this.idy != null) {
      this.idy.setFullDirection(paramInt);
    }
    AppMethodBeat.o(131598);
  }
  
  public void setIMMVideoViewCallback(d.b paramb)
  {
    this.idz = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(131597);
    if (this.idy != null) {
      this.idy.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(131597);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(131624);
    ab.d("MicroMsg.AppBrandVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bo.dtY() });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(131624);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(131609);
    this.fcD = paramBoolean;
    if (this.idy != null) {
      this.idy.setMute(this.fcD);
    }
    AppMethodBeat.o(131609);
  }
  
  public void setScaleType(d.g paramg)
  {
    AppMethodBeat.i(131613);
    this.idB = paramg;
    com.tencent.mm.pluginsdk.ui.h localh;
    int i;
    if (this.idy != null)
    {
      localh = this.idy;
      paramg = this.idB;
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
          paramg = h.d.vQI;
        }
        break;
      }
    }
    for (;;)
    {
      localh.setScaleType(paramg);
      AppMethodBeat.o(131613);
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
      paramg = h.d.vQK;
      continue;
      paramg = h.d.vQL;
      continue;
      paramg = h.d.vQJ;
    }
  }
  
  public void setVideoFooterView(g paramg)
  {
    AppMethodBeat.i(131593);
    this.idA = paramg;
    if (this.idy != null) {
      this.idy.setVideoFooterView(this.idA);
    }
    AppMethodBeat.o(131593);
  }
  
  public void setVideoSource(int paramInt)
  {
    this.icR = paramInt;
  }
  
  public final void start()
  {
    AppMethodBeat.i(131606);
    if (this.idy != null)
    {
      this.idy.start();
      setKeepScreenOn(true);
      this.idF.a(this);
    }
    AppMethodBeat.o(131606);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(131607);
    if (this.idy != null)
    {
      this.idy.stop();
      this.idF.cJ(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(131607);
  }
  
  public final void xE(String paramString)
  {
    AppMethodBeat.i(131626);
    com.tencent.mm.plugin.report.service.h.qsU.kvStat(14349, paramString);
    AppMethodBeat.o(131626);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper
 * JD-Core Version:    0.7.0.1
 */