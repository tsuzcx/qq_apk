package com.tencent.mm.modelvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.plugin.a.k;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;

public class MMVideoView
  extends CommonVideoView
  implements f.a
{
  private i.a oXY;
  protected int oYA;
  protected boolean oYB;
  protected boolean oYC;
  private boolean oYD;
  protected a oYE;
  protected boolean oYF;
  public boolean oYG;
  private MTimerHandler oYH;
  private String oYg;
  protected f oYp;
  protected String oYq;
  public String oYr;
  protected int oYs;
  protected int oYt;
  protected com.tencent.mm.plugin.a.f oYu;
  protected int oYv;
  protected int oYw;
  private boolean oYx;
  protected boolean oYy;
  protected int oYz;
  
  public MMVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(126787);
    this.oYs = 0;
    this.oYt = 0;
    this.oYz = 0;
    this.oYB = false;
    this.oYC = false;
    this.oYD = false;
    this.oYF = false;
    this.oYH = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(126786);
        if (MMVideoView.a(MMVideoView.this) == null)
        {
          AppMethodBeat.o(126786);
          return false;
        }
        boolean bool2 = MMVideoView.this.isPlaying();
        if (bool2) {
          MMVideoView.this.hideLoading();
        }
        boolean bool1;
        try
        {
          int i = MMVideoView.b(MMVideoView.this).getCurrentPosition() / 1000;
          MMVideoView.a(MMVideoView.this, i);
          bool1 = MMVideoView.this.xa(i);
          Log.d(MMVideoView.e(MMVideoView.this), "%s check timer[%b] isplay[%b]", new Object[] { MMVideoView.f(MMVideoView.this), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if (MMVideoView.g(MMVideoView.this)) {
            if ((bool1) && (bool2) && (MMVideoView.h(MMVideoView.this)))
            {
              AppMethodBeat.o(126786);
              return true;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e(MMVideoView.c(MMVideoView.this), "%s online video timer check error [%s] ", new Object[] { MMVideoView.d(MMVideoView.this), localException.toString() });
            bool1 = false;
          }
          AppMethodBeat.o(126786);
          return false;
        }
        if ((bool1) && (bool2))
        {
          AppMethodBeat.o(126786);
          return true;
        }
        AppMethodBeat.o(126786);
        return false;
      }
    }, true);
    AppMethodBeat.o(126787);
  }
  
  public MMVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(126788);
    this.oYs = 0;
    this.oYt = 0;
    this.oYz = 0;
    this.oYB = false;
    this.oYC = false;
    this.oYD = false;
    this.oYF = false;
    this.oYH = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(126786);
        if (MMVideoView.a(MMVideoView.this) == null)
        {
          AppMethodBeat.o(126786);
          return false;
        }
        boolean bool2 = MMVideoView.this.isPlaying();
        if (bool2) {
          MMVideoView.this.hideLoading();
        }
        boolean bool1;
        try
        {
          int i = MMVideoView.b(MMVideoView.this).getCurrentPosition() / 1000;
          MMVideoView.a(MMVideoView.this, i);
          bool1 = MMVideoView.this.xa(i);
          Log.d(MMVideoView.e(MMVideoView.this), "%s check timer[%b] isplay[%b]", new Object[] { MMVideoView.f(MMVideoView.this), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if (MMVideoView.g(MMVideoView.this)) {
            if ((bool1) && (bool2) && (MMVideoView.h(MMVideoView.this)))
            {
              AppMethodBeat.o(126786);
              return true;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e(MMVideoView.c(MMVideoView.this), "%s online video timer check error [%s] ", new Object[] { MMVideoView.d(MMVideoView.this), localException.toString() });
            bool1 = false;
          }
          AppMethodBeat.o(126786);
          return false;
        }
        if ((bool1) && (bool2))
        {
          AppMethodBeat.o(126786);
          return true;
        }
        AppMethodBeat.o(126786);
        return false;
      }
    }, true);
    AppMethodBeat.o(126788);
  }
  
  public MMVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(126789);
    this.oYs = 0;
    this.oYt = 0;
    this.oYz = 0;
    this.oYB = false;
    this.oYC = false;
    this.oYD = false;
    this.oYF = false;
    this.oYH = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(126786);
        if (MMVideoView.a(MMVideoView.this) == null)
        {
          AppMethodBeat.o(126786);
          return false;
        }
        boolean bool2 = MMVideoView.this.isPlaying();
        if (bool2) {
          MMVideoView.this.hideLoading();
        }
        boolean bool1;
        try
        {
          int i = MMVideoView.b(MMVideoView.this).getCurrentPosition() / 1000;
          MMVideoView.a(MMVideoView.this, i);
          bool1 = MMVideoView.this.xa(i);
          Log.d(MMVideoView.e(MMVideoView.this), "%s check timer[%b] isplay[%b]", new Object[] { MMVideoView.f(MMVideoView.this), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
          if (MMVideoView.g(MMVideoView.this)) {
            if ((bool1) && (bool2) && (MMVideoView.h(MMVideoView.this)))
            {
              AppMethodBeat.o(126786);
              return true;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            Log.e(MMVideoView.c(MMVideoView.this), "%s online video timer check error [%s] ", new Object[] { MMVideoView.d(MMVideoView.this), localException.toString() });
            bool1 = false;
          }
          AppMethodBeat.o(126786);
          return false;
        }
        if ((bool1) && (bool2))
        {
          AppMethodBeat.o(126786);
          return true;
        }
        AppMethodBeat.o(126786);
        return false;
      }
    }, true);
    AppMethodBeat.o(126789);
  }
  
  private void bNT()
  {
    AppMethodBeat.i(126808);
    Log.i(this.TAG, "%s pauseByDataBlock ", new Object[] { bNL() });
    showLoading();
    pause();
    AppMethodBeat.o(126808);
  }
  
  private String getRootPath()
  {
    AppMethodBeat.i(126793);
    if (!Util.isNullOrNil(this.oYg))
    {
      str = this.oYg;
      AppMethodBeat.o(126793);
      return str;
    }
    String str = b.bmz() + "video/";
    AppMethodBeat.o(126793);
    return str;
  }
  
  private boolean p(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(126811);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if ((this.oYu.a(paramInt1, paramInt2, localPInt1, localPInt2)) && (this.oYp != null))
      {
        bool = this.oYp.isVideoDataAvailable(this.oYq, localPInt1.value, localPInt2.value);
        if (bool) {
          break label258;
        }
        String str = this.oYq + "_" + localPInt1.value + "_" + localPInt2.value;
        if ((this.oYC) && (!paramBoolean)) {
          break label213;
        }
        this.oYC = true;
        if (this.oYp != null) {
          this.oYp.requestVideoData(this.oYq, localPInt1.value, localPInt2.value);
        }
        AppMethodBeat.o(126811);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e(this.TAG, "%s check video data error[%s] ", new Object[] { bNL(), localException.toString() });
        boolean bool = false;
        continue;
        label213:
        Log.d(this.TAG, "%s already request video [%s] isRequestNow[%b] isSeek[%b] ", new Object[] { bNL(), localException, Boolean.valueOf(this.oYC), Boolean.valueOf(paramBoolean) });
        continue;
        label258:
        Log.d(this.TAG, "%s already had video data.", new Object[] { bNL() });
      }
    }
  }
  
  public boolean X(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(126804);
    switch (this.oYs)
    {
    }
    do
    {
      paramBoolean = true;
      for (;;)
      {
        Log.printInfoStack(this.TAG, "%s seek video time %d, download status %d playStatus %d", new Object[] { bNL(), Integer.valueOf(paramInt), Integer.valueOf(this.oYs), Integer.valueOf(this.oYt) });
        AppMethodBeat.o(126804);
        return paramBoolean;
        Log.i(this.XXD, "seekTo, downloadStatus is downloading");
        this.oYt = 2;
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        a(paramInt, localPInt1, localPInt2);
        if (p(localPInt1.value, localPInt2.value, true))
        {
          this.oYw = -1;
          this.oYy = false;
          this.oYz = localPInt2.value;
          this.oYt = 3;
          super.b(paramInt, paramBoolean);
          paramBoolean = true;
        }
        else
        {
          this.oYw = paramInt;
          this.oYx = paramBoolean;
          this.oYy = true;
          bNT();
          paramBoolean = false;
          continue;
          Log.i(this.XXD, "seekTo, downloadStatus is download finish");
          super.b(paramInt, paramBoolean);
          paramBoolean = true;
          continue;
          Log.i(this.XXD, "seekTo, downloadStatus is download error");
          paramBoolean = true;
        }
      }
      Log.i(this.XXD, "seekTo, downloadStatus is download default, isPrepared is " + cxs());
    } while (cxs());
    if (this.sJk)
    {
      this.sJi = paramBoolean;
      this.oYx = paramBoolean;
      this.sJj = paramInt;
      this.oYw = paramInt;
    }
    for (;;)
    {
      start();
      break;
      this.sJi = paramBoolean;
      if (paramInt > 0) {
        this.sJj = paramInt;
      } else {
        this.sJj = this.sJf;
      }
    }
  }
  
  protected boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(126807);
    paramPInt1.value = Math.max(paramInt, this.oYz);
    if (this.oYt == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.oYA;
    }
    if (this.oYt == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.oYA + 8);
    }
    if ((this.oYt == 3) || (this.oYt == 4))
    {
      paramPInt1.value = this.oYz;
      paramPInt2.value = (this.oYA + paramInt + 1 + this.oYE.oYK);
    }
    if (paramPInt2.value >= this.oYv + 1) {
      paramPInt2.value = (this.oYv + 1);
    }
    if (paramPInt2.value < paramPInt1.value)
    {
      paramPInt1.value += this.oYE.oYK;
      AppMethodBeat.o(126807);
      return false;
    }
    Log.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { bNL(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.oYt), Integer.valueOf(this.oYz), Integer.valueOf(this.oYA), this.oYq });
    AppMethodBeat.o(126807);
    return true;
  }
  
  public void b(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(126792);
    super.b(paramBoolean, paramString, paramInt);
    bNO();
    AppMethodBeat.o(126792);
  }
  
  public boolean b(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(126803);
    paramBoolean = X((int)paramDouble, paramBoolean);
    AppMethodBeat.o(126803);
    return paramBoolean;
  }
  
  protected void bNO()
  {
    AppMethodBeat.i(169101);
    if (!Util.isNullOrNil(this.url))
    {
      this.oYq = ("MMVideo_" + this.url.hashCode());
      this.oYr = (getRootPath() + "MMVideo_" + this.url.hashCode() + ".mp4");
      y.bDX(y.bEo(this.oYr));
      Log.i(this.TAG, "%s set video path [%s %s]", new Object[] { bNL(), this.oYq, this.oYr });
    }
    AppMethodBeat.o(169101);
  }
  
  protected com.tencent.mm.plugin.a.f bNQ()
  {
    AppMethodBeat.i(241259);
    k localk = new k();
    AppMethodBeat.o(241259);
    return localk;
  }
  
  protected void bNR()
  {
    this.oYE.oYJ = 5;
    this.oYE.oYK = 2;
  }
  
  protected void bNS()
  {
    AppMethodBeat.i(126794);
    Log.i(this.XXD, "prepareVideo and set video path to VideoPlayerTextureView");
    Log.printInfoStack(this.TAG, "%s prepareVideo", new Object[] { bNL() });
    if (this.wCd != null)
    {
      this.oYB = true;
      this.wCd.setVideoPath(this.oYr);
    }
    AppMethodBeat.o(126794);
  }
  
  public boolean bNU()
  {
    AppMethodBeat.i(126810);
    boolean bool = super.bNU();
    if (bool) {
      this.oYt = 3;
    }
    AppMethodBeat.o(126810);
    return bool;
  }
  
  public void bNV() {}
  
  public void bb(String paramString, int paramInt)
  {
    AppMethodBeat.i(126815);
    if ((!Util.isEqual(this.oYq, paramString)) || (this.oYs == 3))
    {
      AppMethodBeat.o(126815);
      return;
    }
    Log.i(this.TAG, "%s download finish [%d]", new Object[] { bNL(), Integer.valueOf(paramInt) });
    if (paramInt == 0) {
      this.oYs = 3;
    }
    String str;
    if (this.oXY != null)
    {
      paramString = this.oXY;
      str = this.oYr;
      if (this.oYt <= 0) {
        break label132;
      }
    }
    label132:
    for (boolean bool = true;; bool = false)
    {
      paramString.bd(str, bool);
      Log.i(this.XXD, "onFinish, startTimer");
      ho(true);
      this.oYC = false;
      AppMethodBeat.o(126815);
      return;
    }
  }
  
  public i dY(Context paramContext)
  {
    AppMethodBeat.i(126800);
    this.sJh = 1;
    paramContext = new VideoPlayerTextureView(paramContext);
    paramContext.setNeedResetExtractor(true);
    AppMethodBeat.o(126800);
    return paramContext;
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(126818);
    if (this.oYs == 3)
    {
      i = getVideoDurationSec();
      AppMethodBeat.o(126818);
      return i;
    }
    int i = this.oYz;
    AppMethodBeat.o(126818);
    return i;
  }
  
  public View getInnerVideoView()
  {
    if ((this.wCd instanceof VideoPlayerTextureView)) {
      return (View)this.wCd;
    }
    return null;
  }
  
  public String getMediaId()
  {
    return this.oYq;
  }
  
  public int getReportIdkey()
  {
    return 100;
  }
  
  public void h(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(126814);
    if (!Util.isEqual(this.oYq, paramString))
    {
      AppMethodBeat.o(126814);
      return;
    }
    Log.d(this.TAG, "%s download  onProgress [%d, %d]", new Object[] { bNL(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(126814);
  }
  
  public void ho(boolean paramBoolean)
  {
    AppMethodBeat.i(126816);
    Log.d(this.TAG, "%s start timer rightNow[%b]", new Object[] { bNL(), Boolean.valueOf(paramBoolean) });
    this.oYH.stopTimer();
    this.oYH.startTimer(10L, 500L);
    AppMethodBeat.o(126816);
  }
  
  public void initView()
  {
    AppMethodBeat.i(126790);
    super.initView();
    this.TAG = "MicroMsg.MMVideoView";
    this.XXD = "VideoView.MMVideoView";
    this.oYu = bNQ();
    this.oYE = new a();
    bNR();
    reset();
    AppMethodBeat.o(126790);
  }
  
  public final void jb(long paramLong)
  {
    AppMethodBeat.i(241316);
    Log.i(this.XXD, "onMoovReady");
    Log.i(this.TAG, "%s deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s", new Object[] { bNL(), Long.valueOf(paramLong), Integer.valueOf(this.oYv), this.oYq });
    if (this.oYv != 0)
    {
      Log.w(this.TAG, "moov had callback, do nothing.");
      AppMethodBeat.o(241316);
      return;
    }
    iJV();
    try
    {
      if (this.oYu == null)
      {
        Log.w(this.TAG, "%s parser is null, thread is error.", new Object[] { bNL() });
        AppMethodBeat.o(241316);
        return;
      }
      if (!this.oYu.O(this.oYr, paramLong)) {
        break label273;
      }
      this.oYv = this.oYu.bTU();
      Log.i(this.TAG, "%s mp4 parse moov success. duration %d cdnMediaId %s ", new Object[] { bNL(), Integer.valueOf(this.oYv), this.oYq });
      if (xa(0)) {
        bNS();
      }
      if (this.oYw == -1)
      {
        this.oYt = 1;
        AppMethodBeat.o(241316);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, localException, "%s deal moov ready error [%s]", new Object[] { bNL(), this.oYq });
      AppMethodBeat.o(241316);
      return;
    }
    this.oYt = 2;
    AppMethodBeat.o(241316);
    return;
    label273:
    Log.w(this.TAG, "%s mp4 parse moov error. cdnMediaId %s", new Object[] { bNL(), this.oYq });
    if (this.oYp != null) {
      this.oYp.requestVideoData(this.oYq, 0, -1);
    }
    AppMethodBeat.o(241316);
  }
  
  public void onCompletion()
  {
    AppMethodBeat.i(126798);
    if (this.oYG)
    {
      X(0, true);
      super.hay();
    }
    for (;;)
    {
      this.oYu.release();
      AppMethodBeat.o(126798);
      return;
      super.onCompletion();
      if ((this.oYq != null) && (this.oYp != null)) {
        this.oYp.js(this.oYq);
      }
      reset();
      if (this.wCd != null) {
        this.wCd.stop();
      }
    }
  }
  
  public void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(126813);
    this.oYC = false;
    if ((paramLong1 <= -1L) || (paramLong2 <= -1L))
    {
      Log.w(this.TAG, "%s deal data available error offset[%d], length[%d]", new Object[] { bNL(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      AppMethodBeat.o(126813);
      return;
    }
    if (!Util.isEqual(this.oYq, paramString))
    {
      AppMethodBeat.o(126813);
      return;
    }
    try
    {
      this.oYz = this.oYu.eX((int)paramLong1, (int)paramLong2);
      Log.i(this.TAG, "%s deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { bNL(), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(this.oYz) });
      Log.i(this.XXD, "onDataAvailable, startTimer");
      ho(true);
      AppMethodBeat.o(126813);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e(this.TAG, "%s deal data available file pos to video time error[%s] ", new Object[] { bNL(), paramString.toString() });
      }
    }
  }
  
  public void onSeekComplete(boolean paramBoolean)
  {
    AppMethodBeat.i(126805);
    super.onSeekComplete(paramBoolean);
    hideLoading();
    AppMethodBeat.o(126805);
  }
  
  public void onUIPause()
  {
    AppMethodBeat.i(126795);
    super.onUIPause();
    if (this.oYF)
    {
      this.oYD = true;
      stop();
    }
    AppMethodBeat.o(126795);
  }
  
  public void onUIResume()
  {
    AppMethodBeat.i(126796);
    super.onUIResume();
    Log.i(this.TAG, "%s onUIResume stopDownloadByUiPause[%b] currTimeOnUiPause[%d] isPlayOnUiPause[%b]", new Object[] { bNL(), Boolean.valueOf(this.oYD), Integer.valueOf(this.sJf), Boolean.valueOf(this.sJg) });
    if (this.oYD)
    {
      X(this.sJf, this.sJg);
      AppMethodBeat.o(126796);
      return;
    }
    if ((this.wCd != null) && (d.rb(24)) && ((this.wCd instanceof VideoPlayerTextureView)))
    {
      ((VideoPlayerTextureView)this.wCd).cxp();
      AppMethodBeat.o(126796);
      return;
    }
    AppMethodBeat.o(126796);
  }
  
  public boolean pause()
  {
    AppMethodBeat.i(126809);
    boolean bool = super.pause();
    if (bool)
    {
      this.oYC = false;
      this.oYt = 4;
    }
    AppMethodBeat.o(126809);
    return bool;
  }
  
  public void reset()
  {
    this.oYw = -1;
    this.oYz = 0;
    this.oYv = 0;
    this.oYt = 0;
    this.oYs = 0;
    this.oYy = false;
    this.oYB = false;
    this.oYC = false;
    if (this.oYE != null) {
      this.oYA = this.oYE.oYJ;
    }
  }
  
  protected void setDownloadStatus(int paramInt)
  {
    this.oYs = paramInt;
  }
  
  protected void setFilepath(String paramString)
  {
    this.oYr = paramString;
  }
  
  public void setIMMDownloadFinish(i.a parama)
  {
    this.oXY = parama;
  }
  
  public void setIOnlineVideoProxy(f paramf)
  {
    AppMethodBeat.i(126791);
    this.oYp = paramf;
    this.oYp.a(this);
    AppMethodBeat.o(126791);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.oYG = paramBoolean;
  }
  
  public void setRootPath(String paramString)
  {
    this.oYg = paramString;
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(126801);
    if ((this.wCd instanceof VideoPlayerTextureView))
    {
      ((VideoPlayerTextureView)this.wCd).setScaleType(parame);
      hp(getReportIdkey() + 14);
    }
    AppMethodBeat.o(126801);
  }
  
  public void start()
  {
    AppMethodBeat.i(126797);
    Log.i(this.TAG, "%s start cdnMediaId[%s] timeDuration[%d]", new Object[] { bNL(), this.oYq, Integer.valueOf(this.oYv) });
    if (this.wCd != null)
    {
      if (!Util.isNullOrNil(this.wCd.getVideoPath())) {
        break label145;
      }
      showLoading();
      this.oYF = true;
      this.oYv = 0;
      this.oYs = 1;
      if (this.oYp != null)
      {
        this.oYp.w(this.oYq, this.oYr, this.url);
        this.oYp.a(this);
      }
      hmY();
    }
    for (;;)
    {
      hp(getReportIdkey() + 1);
      AppMethodBeat.o(126797);
      return;
      label145:
      bNU();
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(126799);
    if (this.oYp != null) {
      this.oYp.js(this.oYq);
    }
    reset();
    super.stop();
    this.oYu.release();
    AppMethodBeat.o(126799);
  }
  
  public void stopTimer()
  {
    AppMethodBeat.i(126817);
    this.oYH.stopTimer();
    AppMethodBeat.o(126817);
  }
  
  protected final boolean xa(int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    AppMethodBeat.i(126802);
    if (this.oYw != -1) {}
    for (int i = this.oYw;; i = paramInt)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(bNL()).append(" check timer playCurrPos ").append(paramInt).append(" playTime ").append(i).append(" cachePlayTime ").append(this.oYz).append(" timeDuration ").append(this.oYv).append(" playStatus ").append(this.oYt).append(" downloadStatus ").append(this.oYs).append(" cdnMediaId ").append(this.oYq).append(" isPrepareVideo[").append(this.oYB).append("], isPrepared[").append(this.hS).append("]");
      Log.i(this.TAG, ((StringBuilder)localObject).toString());
      switch (this.oYs)
      {
      default: 
        Log.i(this.XXD, "checkTimer, downloadStatus is default, playCurrPos is ".concat(String.valueOf(paramInt)));
        Log.w(this.TAG, "%s check time default.", new Object[] { bNL() });
        bool1 = false;
      }
      for (;;)
      {
        AppMethodBeat.o(126802);
        return bool1;
        Log.i(this.XXD, "checkTimer, downloadStatus is downloading, playCurrPos is ".concat(String.valueOf(paramInt)));
        if (!xb(i))
        {
          this.oYy = true;
          if (this.oYz <= 0) {
            if (this.oYw == -1)
            {
              this.oYt = 1;
              label302:
              bool1 = false;
            }
          }
        }
        for (;;)
        {
          Bt(i);
          localObject = new PInt();
          PInt localPInt = new PInt();
          if (!a(i, (PInt)localObject, localPInt)) {
            break label777;
          }
          if (!p(((PInt)localObject).value, localPInt.value, false)) {
            break label798;
          }
          this.oYz = Math.max(this.oYz, localPInt.value);
          bool1 = bool2;
          break;
          this.oYt = 2;
          break label302;
          Log.i(this.TAG, "%s pause by load data cdnMediaId %s, playStatus %d", new Object[] { bNL(), this.oYq, Integer.valueOf(this.oYt) });
          iJW();
          if ((this.oYt != 2) && (this.oYt != 4))
          {
            this.oYA += this.oYE.oYJ;
            this.oYA = Math.min(this.oYA, 60);
            iJY();
            this.oYt = 4;
          }
          bNT();
          break label302;
          if (this.oYB)
          {
            Bt(i);
            Log.i(this.TAG, "resumeByDataGain, playStatus:%s, isPlaying:%s, pauseByLoadData:%s", new Object[] { Integer.valueOf(this.oYt), Boolean.valueOf(this.wCd.isPlaying()), Boolean.valueOf(this.oYy) });
            if (this.oYy)
            {
              iJX();
              iJZ();
              Log.i(this.TAG, "%s resume by data gain cdnMediaId %s", new Object[] { bNL(), this.oYq });
              if (this.oYw != -1)
              {
                X(this.oYw, this.oYx);
                this.oYw = -1;
                bool1 = false;
                label622:
                this.oYy = bool1;
                paramInt = 3;
              }
            }
            for (;;)
            {
              this.oYt = paramInt;
              do
              {
                bool1 = true;
                break;
                if (bNU())
                {
                  bool1 = false;
                  break label622;
                }
                bool1 = true;
                break label622;
              } while ((this.oYt == 3) && (this.wCd.isPlaying()));
              Log.i(this.TAG, "%s start to play video playStatus[%d]", new Object[] { bNL(), Integer.valueOf(this.oYt) });
              if (bNU()) {
                paramInt = 3;
              } else {
                paramInt = this.oYt;
              }
            }
          }
          Log.i(this.TAG, "%s prepare cdnMediaId [%s]", new Object[] { bNL(), this.oYq });
          if (this.oYt == 5) {
            this.oYt = 1;
          }
          bNS();
          bool1 = true;
        }
        label777:
        Log.d(this.TAG, "%s can not calc download.", new Object[] { bNL() });
        label798:
        continue;
        Log.i(this.XXD, "checkTimer, downloadStatus is download finish, playCurrPos is ".concat(String.valueOf(paramInt)));
        if (this.hS)
        {
          if (this.oYy)
          {
            if (this.oYw == -1) {
              break label876;
            }
            X(this.oYw, true);
            this.oYw = -1;
          }
          for (;;)
          {
            this.oYy = bool1;
            this.oYt = 3;
            Bt(i);
            bool1 = bool2;
            break;
            label876:
            if (!bNU()) {
              bool1 = true;
            }
          }
        }
        if (this.oYt == 5) {
          this.oYt = 1;
        }
        bNS();
        bool1 = bool2;
        continue;
        Log.i(this.XXD, "checkTimer, downloadStatus is download error, playCurrPos is ".concat(String.valueOf(paramInt)));
        Log.w(this.TAG, "%s download error.", new Object[] { bNL() });
        bool1 = false;
      }
    }
  }
  
  public boolean xb(int paramInt)
  {
    AppMethodBeat.i(126806);
    if (this.oYs == 3)
    {
      AppMethodBeat.o(126806);
      return true;
    }
    if ((this.oYz - paramInt <= 1) && (this.oYz < this.oYv))
    {
      AppMethodBeat.o(126806);
      return false;
    }
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.oYu.a(paramInt, paramInt + 1, localPInt1, localPInt2)) {
        if (this.oYp != null)
        {
          bool1 = this.oYp.isVideoDataAvailable(this.oYq, localPInt1.value, localPInt2.value);
          bool2 = bool1;
          if (bool1) {}
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          this.oYz = paramInt;
          bool2 = bool1;
          AppMethodBeat.o(126806);
          return bool2;
        }
        catch (Exception localException2)
        {
          continue;
        }
        localException1 = localException1;
        boolean bool1 = false;
        Log.e(this.TAG, "%s check video data error %s ", new Object[] { bNL(), localException1.toString() });
        boolean bool2 = bool1;
        continue;
        bool1 = false;
        continue;
        bool2 = false;
      }
    }
  }
  
  public static final class a
  {
    public int oYJ;
    public int oYK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.modelvideo.MMVideoView
 * JD-Core Version:    0.7.0.1
 */