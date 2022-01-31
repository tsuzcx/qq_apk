package com.tencent.mm.plugin.brandservice.ui.widget;

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
import com.tencent.mm.plugin.appbrand.jsapi.video.d.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.d.g;
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

public class MPVideoWrapper
  extends RelativeLayout
  implements com.tencent.mm.model.d.a, com.tencent.mm.plugin.appbrand.jsapi.video.d, h.a, h.b, h.c
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
  
  public MPVideoWrapper(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MPVideoWrapper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(14632);
    this.idB = d.g.idJ;
    this.fcD = false;
    this.idC = -1.0F;
    this.icR = 0;
    this.mContext = paramContext;
    this.idF = new com.tencent.mm.model.d();
    AppMethodBeat.o(14632);
  }
  
  private boolean a(boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(14636);
    if ((paramBoolean) || (this.idE))
    {
      AppMethodBeat.o(14636);
      return true;
    }
    if (com.tencent.mm.compatible.util.d.fw(18))
    {
      AppMethodBeat.o(14636);
      return true;
    }
    int i = ah.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.h.Mp()).getInt("appbrand_video_player", -1);
    ab.d("MicroMsg.AppBrandVideoWrapper", "checkUseSystemPlayer abtestFlag[%d]", new Object[] { Integer.valueOf(i) });
    if (i <= 0)
    {
      ab.i("MicroMsg.AppBrandVideoWrapper", "abtest is zero, use system player");
      AppMethodBeat.o(14636);
      return true;
    }
    if ((!bo.isNullOrNil(paramString1)) && (paramString1.contains(".m3u8")))
    {
      ab.i("MicroMsg.AppBrandVideoWrapper", "%d it is m3u8 file use system player.", new Object[] { Integer.valueOf(hashCode()) });
      hB(204L);
      AppMethodBeat.o(14636);
      return true;
    }
    if (r.vb(paramString2))
    {
      ab.i("MicroMsg.AppBrandVideoWrapper", "%d it is m3u8 file use system player.", new Object[] { Integer.valueOf(hashCode()) });
      hB(204L);
      AppMethodBeat.o(14636);
      return true;
    }
    AppMethodBeat.o(14636);
    return false;
  }
  
  private com.tencent.mm.pluginsdk.ui.h aFB()
  {
    AppMethodBeat.i(14634);
    MPCommonVideoView localMPCommonVideoView = new MPCommonVideoView(this.mContext);
    localMPCommonVideoView.setReporter(this);
    localMPCommonVideoView.LS(this.icR);
    localMPCommonVideoView.setIMMVideoViewCallback(this);
    hB(200L);
    AppMethodBeat.o(14634);
    return localMPCommonVideoView;
  }
  
  private com.tencent.mm.pluginsdk.ui.h aFC()
  {
    AppMethodBeat.i(14635);
    MMVideoView localMMVideoView = new MMVideoView(this.mContext);
    localMMVideoView.setReporter(this);
    localMMVideoView.setIMMVideoViewCallback(this);
    localMMVideoView.setIMMDownloadFinish(this);
    String str = e.eQz + "appbrandvideo/";
    j.akQ(str);
    localMMVideoView.setRootPath(str);
    hB(201L);
    AppMethodBeat.o(14635);
    return localMMVideoView;
  }
  
  public final void aEM()
  {
    AppMethodBeat.i(14656);
    if (this.idy != null) {
      this.idy.aEM();
    }
    this.idF.cJ(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(14656);
  }
  
  public final void alo()
  {
    AppMethodBeat.i(14655);
    if (this.idy != null) {
      this.idy.alo();
    }
    this.idF.cJ(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(14655);
  }
  
  public final void alp()
  {
    AppMethodBeat.i(14654);
    if (this.idy != null) {
      this.idy.alp();
    }
    AppMethodBeat.o(14654);
  }
  
  public final void an(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(14659);
    ab.i("MicroMsg.AppBrandVideoWrapper", "%d onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { Integer.valueOf(hashCode()), paramString, Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      AppMethodBeat.o(14659);
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
      AppMethodBeat.o(14659);
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
    AppMethodBeat.i(14658);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(14658);
      return false;
    }
    this.idC = paramFloat;
    if (this.idy != null)
    {
      boolean bool = this.idy.ay(this.idC);
      AppMethodBeat.o(14658);
      return bool;
    }
    AppMethodBeat.o(14658);
    return false;
  }
  
  public final void c(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14660);
    ab.w("MicroMsg.AppBrandVideoWrapper", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramString3, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.idz != null) {
      this.idz.c(paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
    AppMethodBeat.o(14660);
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(14633);
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
          AppMethodBeat.i(14631);
          MPVideoWrapper.a(MPVideoWrapper.this);
          AppMethodBeat.o(14631);
        }
      }, "AppBrandVideo_checkVideoUrl");
      AppMethodBeat.o(14633);
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
    AppMethodBeat.i(14661);
    ab.i("MicroMsg.AppBrandVideoWrapper", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
    if (this.idz != null) {
      this.idz.cq(paramString1, paramString2);
    }
    if (isLive())
    {
      hB(203L);
      AppMethodBeat.o(14661);
      return;
    }
    hB(202L);
    AppMethodBeat.o(14661);
  }
  
  public final void cr(String paramString1, String paramString2)
  {
    AppMethodBeat.i(14662);
    ab.i("MicroMsg.AppBrandVideoWrapper", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
    if (this.idz != null) {
      this.idz.cr(paramString1, paramString2);
    }
    AppMethodBeat.o(14662);
  }
  
  public final void cs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(14664);
    ab.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(false);
    this.idF.cJ(false);
    if (this.idz != null) {
      this.idz.cs(paramString1, paramString2);
    }
    AppMethodBeat.o(14664);
  }
  
  public final void ct(String paramString1, String paramString2)
  {
    AppMethodBeat.i(14665);
    ab.d("MicroMsg.AppBrandVideoWrapper", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
    setKeepScreenOn(true);
    this.idF.a(this);
    if (this.idz != null) {
      this.idz.ct(paramString1, paramString2);
    }
    AppMethodBeat.o(14665);
  }
  
  public final void cu(String paramString1, String paramString2)
  {
    AppMethodBeat.i(14666);
    if (this.idz != null) {
      this.idz.cu(paramString1, paramString2);
    }
    AppMethodBeat.o(14666);
  }
  
  public final void cv(String paramString1, String paramString2)
  {
    AppMethodBeat.i(14667);
    if (this.idz != null) {
      this.idz.cv(paramString1, paramString2);
    }
    AppMethodBeat.o(14667);
  }
  
  public final void d(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14663);
    ab.i("MicroMsg.AppBrandVideoWrapper", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (this.idz != null) {
      this.idz.d(paramString1, paramString2, paramInt1, paramInt2);
    }
    AppMethodBeat.o(14663);
  }
  
  public final boolean d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(14640);
    if (this.idy != null)
    {
      paramBoolean = this.idy.d(paramDouble, paramBoolean);
      AppMethodBeat.o(14640);
      return paramBoolean;
    }
    AppMethodBeat.o(14640);
    return false;
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(14646);
    if (this.idy != null)
    {
      int i = this.idy.getCacheTimeSec();
      AppMethodBeat.o(14646);
      return i;
    }
    AppMethodBeat.o(14646);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(14644);
    if (this.idy != null)
    {
      int i = this.idy.getCurrPosMs();
      AppMethodBeat.o(14644);
      return i;
    }
    AppMethodBeat.o(14644);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(14645);
    if (this.idy != null)
    {
      int i = this.idy.getCurrPosSec();
      AppMethodBeat.o(14645);
      return i;
    }
    AppMethodBeat.o(14645);
    return 0;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(14638);
    if (this.idy != null)
    {
      int i = this.idy.getPlayerType();
      AppMethodBeat.o(14638);
      return i;
    }
    AppMethodBeat.o(14638);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(14643);
    if (this.idy != null)
    {
      i = this.idy.getVideoDurationSec();
      AppMethodBeat.o(14643);
      return i;
    }
    int i = this.idD;
    AppMethodBeat.o(14643);
    return i;
  }
  
  public final void hB(long paramLong)
  {
    AppMethodBeat.i(14669);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(600L, paramLong, 1L, false);
    AppMethodBeat.o(14669);
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(14648);
    if (this.idy != null)
    {
      boolean bool = this.idy.isLive();
      AppMethodBeat.o(14648);
      return bool;
    }
    AppMethodBeat.o(14648);
    return false;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(14647);
    if (this.idy != null)
    {
      boolean bool = this.idy.isPlaying();
      AppMethodBeat.o(14647);
      return bool;
    }
    AppMethodBeat.o(14647);
    return false;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(14652);
    if (this.idy != null)
    {
      setKeepScreenOn(false);
      this.idF.cJ(false);
      boolean bool = this.idy.pause();
      AppMethodBeat.o(14652);
      return bool;
    }
    AppMethodBeat.o(14652);
    return false;
  }
  
  public final boolean r(double paramDouble)
  {
    AppMethodBeat.i(14639);
    if (this.idy != null)
    {
      boolean bool = this.idy.r(paramDouble);
      AppMethodBeat.o(14639);
      return bool;
    }
    AppMethodBeat.o(14639);
    return false;
  }
  
  public void setControlBar(com.tencent.mm.plugin.appbrand.jsapi.video.d.a parama) {}
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(14649);
    if (this.idy != null) {
      this.idy.setCover(paramBitmap);
    }
    AppMethodBeat.o(14649);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(14642);
    if (this.idy != null) {
      this.idy.setFullDirection(paramInt);
    }
    AppMethodBeat.o(14642);
  }
  
  public void setIMMVideoViewCallback(d.b paramb)
  {
    this.idz = paramb;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(14641);
    if (this.idy != null) {
      this.idy.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(14641);
  }
  
  public void setKeepScreenOn(boolean paramBoolean)
  {
    AppMethodBeat.i(14668);
    ab.d("MicroMsg.AppBrandVideoWrapper", "set keep screen on[%b] stack[%s]", new Object[] { Boolean.valueOf(paramBoolean), bo.dtY() });
    super.setKeepScreenOn(paramBoolean);
    AppMethodBeat.o(14668);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(14653);
    this.fcD = paramBoolean;
    if (this.idy != null) {
      this.idy.setMute(this.fcD);
    }
    AppMethodBeat.o(14653);
  }
  
  public void setScaleType(d.g paramg)
  {
    AppMethodBeat.i(14657);
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
      AppMethodBeat.o(14657);
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
    AppMethodBeat.i(14637);
    this.idA = paramg;
    if (this.idy != null) {
      this.idy.setVideoFooterView(this.idA);
    }
    AppMethodBeat.o(14637);
  }
  
  public void setVideoSource(int paramInt)
  {
    this.icR = paramInt;
  }
  
  public final void start()
  {
    AppMethodBeat.i(14650);
    if (this.idy != null)
    {
      this.idy.start();
      setKeepScreenOn(true);
      this.idF.a(this);
    }
    AppMethodBeat.o(14650);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(14651);
    if (this.idy != null)
    {
      this.idy.stop();
      this.idF.cJ(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(14651);
  }
  
  public final void xE(String paramString)
  {
    AppMethodBeat.i(14670);
    com.tencent.mm.plugin.report.service.h.qsU.kvStat(14349, paramString);
    AppMethodBeat.o(14670);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.widget.MPVideoWrapper
 * JD-Core Version:    0.7.0.1
 */