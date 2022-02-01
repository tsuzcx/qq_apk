package com.tencent.mm.modelvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;

public class MMVideoView
  extends CommonVideoView
  implements f.a
{
  protected int mfA;
  private boolean mfB;
  protected boolean mfC;
  protected int mfD;
  protected int mfE;
  protected boolean mfF;
  protected boolean mfG;
  private boolean mfH;
  protected a mfI;
  protected boolean mfJ;
  public boolean mfK;
  private MTimerHandler mfL;
  private i.a mfg;
  private String mfn;
  protected f mft;
  protected String mfu;
  public String mfv;
  protected int mfw;
  protected int mfx;
  protected com.tencent.mm.plugin.a.f mfy;
  protected int mfz;
  
  public MMVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(126787);
    this.mfw = 0;
    this.mfx = 0;
    this.mfD = 0;
    this.mfF = false;
    this.mfG = false;
    this.mfH = false;
    this.mfJ = false;
    this.mfL = new MTimerHandler(new MTimerHandler.CallBack()
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
    this.mfw = 0;
    this.mfx = 0;
    this.mfD = 0;
    this.mfF = false;
    this.mfG = false;
    this.mfH = false;
    this.mfJ = false;
    this.mfL = new MTimerHandler(new MTimerHandler.CallBack()
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
    this.mfw = 0;
    this.mfx = 0;
    this.mfD = 0;
    this.mfF = false;
    this.mfG = false;
    this.mfH = false;
    this.mfJ = false;
    this.mfL = new MTimerHandler(new MTimerHandler.CallBack()
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
  
  private void bqn()
  {
    AppMethodBeat.i(126808);
    Log.i(this.TAG, "%s pauseByDataBlock ", new Object[] { bqf() });
    showLoading();
    pause();
    AppMethodBeat.o(126808);
  }
  
  private String getRootPath()
  {
    AppMethodBeat.i(126793);
    if (!Util.isNullOrNil(this.mfn))
    {
      str = this.mfn;
      AppMethodBeat.o(126793);
      return str;
    }
    String str = b.aSL() + "video/";
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
      if ((this.mfy.a(paramInt1, paramInt2, localPInt1, localPInt2)) && (this.mft != null))
      {
        bool = this.mft.isVideoDataAvailable(this.mfu, localPInt1.value, localPInt2.value);
        if (bool) {
          break label258;
        }
        String str = this.mfu + "_" + localPInt1.value + "_" + localPInt2.value;
        if ((this.mfG) && (!paramBoolean)) {
          break label213;
        }
        this.mfG = true;
        if (this.mft != null) {
          this.mft.requestVideoData(this.mfu, localPInt1.value, localPInt2.value);
        }
        AppMethodBeat.o(126811);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e(this.TAG, "%s check video data error[%s] ", new Object[] { bqf(), localException.toString() });
        boolean bool = false;
        continue;
        label213:
        Log.d(this.TAG, "%s already request video [%s] isRequestNow[%b] isSeek[%b] ", new Object[] { bqf(), localException, Boolean.valueOf(this.mfG), Boolean.valueOf(paramBoolean) });
        continue;
        label258:
        Log.d(this.TAG, "%s already had video data.", new Object[] { bqf() });
      }
    }
  }
  
  public final void GQ(long paramLong)
  {
    AppMethodBeat.i(216966);
    Log.i(this.TAG, "%s deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s", new Object[] { bqf(), Long.valueOf(paramLong), Integer.valueOf(this.mfz), this.mfu });
    if (this.mfz != 0)
    {
      Log.w(this.TAG, "moov had callback, do nothing.");
      AppMethodBeat.o(216966);
      return;
    }
    hja();
    try
    {
      if (this.mfy == null)
      {
        Log.w(this.TAG, "%s parser is null, thread is error.", new Object[] { bqf() });
        AppMethodBeat.o(216966);
        return;
      }
      if (!this.mfy.K(this.mfv, paramLong)) {
        break label254;
      }
      this.mfz = this.mfy.bvI();
      Log.i(this.TAG, "%s mp4 parse moov success. duration %d cdnMediaId %s ", new Object[] { bqf(), Integer.valueOf(this.mfz), this.mfu });
      if (xa(0)) {
        bqm();
      }
      if (this.mfA == -1)
      {
        this.mfx = 1;
        AppMethodBeat.o(216966);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, localException, "%s deal moov ready error [%s]", new Object[] { bqf(), this.mfu });
      AppMethodBeat.o(216966);
      return;
    }
    this.mfx = 2;
    AppMethodBeat.o(216966);
    return;
    label254:
    Log.w(this.TAG, "%s mp4 parse moov error. cdnMediaId %s", new Object[] { bqf(), this.mfu });
    if (this.mft != null) {
      this.mft.requestVideoData(this.mfu, 0, -1);
    }
    AppMethodBeat.o(216966);
  }
  
  public boolean I(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(126804);
    switch (this.mfw)
    {
    }
    do
    {
      paramBoolean = true;
      for (;;)
      {
        Log.printInfoStack(this.TAG, "%s seek video time %d, download status %d playStatus %d", new Object[] { bqf(), Integer.valueOf(paramInt), Integer.valueOf(this.mfw), Integer.valueOf(this.mfx) });
        AppMethodBeat.o(126804);
        return paramBoolean;
        this.mfx = 2;
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        a(paramInt, localPInt1, localPInt2);
        if (p(localPInt1.value, localPInt2.value, true))
        {
          this.mfA = -1;
          this.mfC = false;
          this.mfD = localPInt2.value;
          this.mfx = 3;
          super.a(paramInt, paramBoolean);
          paramBoolean = true;
        }
        else
        {
          this.mfA = paramInt;
          this.mfB = paramBoolean;
          this.mfC = true;
          bqn();
          paramBoolean = false;
          continue;
          super.a(paramInt, paramBoolean);
          paramBoolean = true;
          continue;
          paramBoolean = true;
        }
      }
    } while (ayN());
    if (this.pDY)
    {
      this.pDW = paramBoolean;
      this.mfB = paramBoolean;
      this.pDX = paramInt;
      this.mfA = paramInt;
    }
    for (;;)
    {
      start();
      break;
      this.pDW = paramBoolean;
      if (paramInt > 0) {
        this.pDX = paramInt;
      } else {
        this.pDX = this.pDT;
      }
    }
  }
  
  public boolean a(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(126803);
    paramBoolean = I((int)paramDouble, paramBoolean);
    AppMethodBeat.o(126803);
    return paramBoolean;
  }
  
  protected boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(126807);
    paramPInt1.value = Math.max(paramInt, this.mfD);
    if (this.mfx == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.mfE;
    }
    if (this.mfx == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.mfE + 8);
    }
    if ((this.mfx == 3) || (this.mfx == 4))
    {
      paramPInt1.value = this.mfD;
      paramPInt2.value = (this.mfE + paramInt + 1 + this.mfI.mfO);
    }
    if (paramPInt2.value >= this.mfz + 1) {
      paramPInt2.value = (this.mfz + 1);
    }
    if (paramPInt2.value < paramPInt1.value)
    {
      paramPInt1.value += this.mfI.mfO;
      AppMethodBeat.o(126807);
      return false;
    }
    Log.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { bqf(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.mfx), Integer.valueOf(this.mfD), Integer.valueOf(this.mfE), this.mfu });
    AppMethodBeat.o(126807);
    return true;
  }
  
  public void aP(String paramString, int paramInt)
  {
    AppMethodBeat.i(126815);
    if ((!Util.isEqual(this.mfu, paramString)) || (this.mfw == 3))
    {
      AppMethodBeat.o(126815);
      return;
    }
    Log.i(this.TAG, "%s download finish [%d]", new Object[] { bqf(), Integer.valueOf(paramInt) });
    if (paramInt == 0) {
      this.mfw = 3;
    }
    String str;
    if (this.mfg != null)
    {
      paramString = this.mfg;
      str = this.mfv;
      if (this.mfx <= 0) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.aR(str, bool);
      gA(true);
      this.mfG = false;
      AppMethodBeat.o(126815);
      return;
    }
  }
  
  protected void bqi()
  {
    AppMethodBeat.i(169101);
    if (!Util.isNullOrNil(this.url))
    {
      this.mfu = ("MMVideo_" + this.url.hashCode());
      this.mfv = (getRootPath() + "MMVideo_" + this.url.hashCode() + ".mp4");
      u.bBD(u.bBT(this.mfv));
      Log.i(this.TAG, "%s set video path [%s %s]", new Object[] { bqf(), this.mfu, this.mfv });
    }
    AppMethodBeat.o(169101);
  }
  
  protected com.tencent.mm.plugin.a.f bqk()
  {
    AppMethodBeat.i(216939);
    com.tencent.mm.plugin.a.k localk = new com.tencent.mm.plugin.a.k();
    AppMethodBeat.o(216939);
    return localk;
  }
  
  protected void bql()
  {
    this.mfI.mfN = 5;
    this.mfI.mfO = 2;
  }
  
  protected void bqm()
  {
    AppMethodBeat.i(126794);
    Log.printInfoStack(this.TAG, "%s prepareVideo", new Object[] { bqf() });
    if (this.txH != null)
    {
      this.mfF = true;
      this.txH.setVideoPath(this.mfv);
    }
    AppMethodBeat.o(126794);
  }
  
  public boolean bqo()
  {
    AppMethodBeat.i(126810);
    boolean bool = super.bqo();
    if (bool) {
      this.mfx = 3;
    }
    AppMethodBeat.o(126810);
    return bool;
  }
  
  public void bqp() {}
  
  public void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(126792);
    super.c(paramBoolean, paramString, paramInt);
    bqi();
    AppMethodBeat.o(126792);
  }
  
  public com.tencent.mm.pluginsdk.ui.tools.k df(Context paramContext)
  {
    AppMethodBeat.i(126800);
    this.pDV = 1;
    paramContext = new VideoPlayerTextureView(paramContext);
    paramContext.setNeedResetExtractor(true);
    AppMethodBeat.o(126800);
    return paramContext;
  }
  
  public void gA(boolean paramBoolean)
  {
    AppMethodBeat.i(126816);
    Log.d(this.TAG, "%s start timer rightNow[%b]", new Object[] { bqf(), Boolean.valueOf(paramBoolean) });
    this.mfL.stopTimer();
    this.mfL.startTimer(10L, 500L);
    AppMethodBeat.o(126816);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(126818);
    if (this.mfw == 3)
    {
      i = getVideoDurationSec();
      AppMethodBeat.o(126818);
      return i;
    }
    int i = this.mfD;
    AppMethodBeat.o(126818);
    return i;
  }
  
  public View getInnerVideoView()
  {
    if ((this.txH instanceof VideoPlayerTextureView)) {
      return (View)this.txH;
    }
    return null;
  }
  
  public String getMediaId()
  {
    return this.mfu;
  }
  
  public int getReportIdkey()
  {
    return 100;
  }
  
  public void gz(boolean paramBoolean)
  {
    AppMethodBeat.i(126805);
    super.gz(paramBoolean);
    hideLoading();
    AppMethodBeat.o(126805);
  }
  
  public void h(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(126814);
    if (!Util.isEqual(this.mfu, paramString))
    {
      AppMethodBeat.o(126814);
      return;
    }
    Log.d(this.TAG, "%s download  onProgress [%d, %d]", new Object[] { bqf(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(126814);
  }
  
  public void initView()
  {
    AppMethodBeat.i(126790);
    super.initView();
    this.TAG = "MicroMsg.MMVideoView";
    this.mfy = bqk();
    this.mfI = new a();
    bql();
    reset();
    AppMethodBeat.o(126790);
  }
  
  public void onCompletion()
  {
    AppMethodBeat.i(126798);
    if (this.mfK)
    {
      I(0, true);
      super.fKt();
    }
    for (;;)
    {
      this.mfy.release();
      AppMethodBeat.o(126798);
      return;
      super.onCompletion();
      if ((this.mfu != null) && (this.mft != null)) {
        this.mft.hR(this.mfu);
      }
      reset();
      if (this.txH != null) {
        this.txH.stop();
      }
    }
  }
  
  public void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(126813);
    this.mfG = false;
    if ((paramLong1 <= -1L) || (paramLong2 <= -1L))
    {
      Log.w(this.TAG, "%s deal data available error offset[%d], length[%d]", new Object[] { bqf(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      AppMethodBeat.o(126813);
      return;
    }
    if (!Util.isEqual(this.mfu, paramString))
    {
      AppMethodBeat.o(126813);
      return;
    }
    try
    {
      this.mfD = this.mfy.ee((int)paramLong1, (int)paramLong2);
      Log.i(this.TAG, "%s deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { bqf(), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(this.mfD) });
      gA(true);
      AppMethodBeat.o(126813);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e(this.TAG, "%s deal data available file pos to video time error[%s] ", new Object[] { bqf(), paramString.toString() });
      }
    }
  }
  
  public void onUIPause()
  {
    AppMethodBeat.i(126795);
    super.onUIPause();
    if (this.mfJ)
    {
      this.mfH = true;
      stop();
    }
    AppMethodBeat.o(126795);
  }
  
  public void onUIResume()
  {
    AppMethodBeat.i(126796);
    super.onUIResume();
    Log.i(this.TAG, "%s onUIResume stopDownloadByUiPause[%b] currTimeOnUiPause[%d] isPlayOnUiPause[%b]", new Object[] { bqf(), Boolean.valueOf(this.mfH), Integer.valueOf(this.pDT), Boolean.valueOf(this.pDU) });
    if (this.mfH)
    {
      I(this.pDT, this.pDU);
      AppMethodBeat.o(126796);
      return;
    }
    if ((this.txH != null) && (d.qV(24)) && ((this.txH instanceof VideoPlayerTextureView)))
    {
      ((VideoPlayerTextureView)this.txH).bXe();
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
      this.mfG = false;
      this.mfx = 4;
    }
    AppMethodBeat.o(126809);
    return bool;
  }
  
  public void reset()
  {
    this.mfA = -1;
    this.mfD = 0;
    this.mfz = 0;
    this.mfx = 0;
    this.mfw = 0;
    this.mfC = false;
    this.mfF = false;
    this.mfG = false;
    if (this.mfI != null) {
      this.mfE = this.mfI.mfN;
    }
  }
  
  protected void setDownloadStatus(int paramInt)
  {
    this.mfw = paramInt;
  }
  
  protected void setFilepath(String paramString)
  {
    this.mfv = paramString;
  }
  
  public void setIMMDownloadFinish(i.a parama)
  {
    this.mfg = parama;
  }
  
  public void setIOnlineVideoProxy(f paramf)
  {
    AppMethodBeat.i(126791);
    this.mft = paramf;
    this.mft.a(this);
    AppMethodBeat.o(126791);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.mfK = paramBoolean;
  }
  
  public void setRootPath(String paramString)
  {
    this.mfn = paramString;
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(126801);
    if ((this.txH instanceof VideoPlayerTextureView))
    {
      ((VideoPlayerTextureView)this.txH).setScaleType(parame);
      EW(getReportIdkey() + 14);
    }
    AppMethodBeat.o(126801);
  }
  
  public void start()
  {
    AppMethodBeat.i(126797);
    Log.i(this.TAG, "%s start cdnMediaId[%s] timeDuration[%d]", new Object[] { bqf(), this.mfu, Integer.valueOf(this.mfz) });
    if (this.txH != null)
    {
      if (!Util.isNullOrNil(this.txH.getVideoPath())) {
        break label145;
      }
      showLoading();
      this.mfJ = true;
      this.mfz = 0;
      this.mfw = 1;
      if (this.mft != null)
      {
        this.mft.s(this.mfu, this.mfv, this.url);
        this.mft.a(this);
      }
      fUH();
    }
    for (;;)
    {
      EW(getReportIdkey() + 1);
      AppMethodBeat.o(126797);
      return;
      label145:
      bqo();
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(126799);
    if (this.mft != null) {
      this.mft.hR(this.mfu);
    }
    reset();
    super.stop();
    this.mfy.release();
    AppMethodBeat.o(126799);
  }
  
  public void stopTimer()
  {
    AppMethodBeat.i(126817);
    this.mfL.stopTimer();
    AppMethodBeat.o(126817);
  }
  
  protected final boolean xa(int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    AppMethodBeat.i(126802);
    if (this.mfA != -1) {}
    for (int i = this.mfA;; i = paramInt)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(bqf()).append(" check timer playCurrPos ").append(paramInt).append(" playTime ").append(i).append(" cachePlayTime ").append(this.mfD).append(" timeDuration ").append(this.mfz).append(" playStatus ").append(this.mfx).append(" downloadStatus ").append(this.mfw).append(" cdnMediaId ").append(this.mfu).append(" isPrepareVideo[").append(this.mfF).append("], isPrepared[").append(this.gX).append("]");
      Log.i(this.TAG, ((StringBuilder)localObject).toString());
      switch (this.mfw)
      {
      default: 
        Log.w(this.TAG, "%s check time default.", new Object[] { bqf() });
        bool1 = false;
      }
      for (;;)
      {
        AppMethodBeat.o(126802);
        return bool1;
        if (!xb(i))
        {
          this.mfC = true;
          if (this.mfD <= 0) {
            if (this.mfA == -1)
            {
              this.mfx = 1;
              label268:
              bool1 = false;
            }
          }
        }
        for (;;)
        {
          Bg(i);
          localObject = new PInt();
          PInt localPInt = new PInt();
          if (!a(i, (PInt)localObject, localPInt)) {
            break label743;
          }
          if (!p(((PInt)localObject).value, localPInt.value, false)) {
            break label764;
          }
          this.mfD = Math.max(this.mfD, localPInt.value);
          bool1 = bool2;
          break;
          this.mfx = 2;
          break label268;
          Log.i(this.TAG, "%s pause by load data cdnMediaId %s, playStatus %d", new Object[] { bqf(), this.mfu, Integer.valueOf(this.mfx) });
          hjb();
          if ((this.mfx != 2) && (this.mfx != 4))
          {
            this.mfE += this.mfI.mfN;
            this.mfE = Math.min(this.mfE, 60);
            hjd();
            this.mfx = 4;
          }
          bqn();
          break label268;
          if (this.mfF)
          {
            Bg(i);
            Log.i(this.TAG, "resumeByDataGain, playStatus:%s, isPlaying:%s, pauseByLoadData:%s", new Object[] { Integer.valueOf(this.mfx), Boolean.valueOf(this.txH.isPlaying()), Boolean.valueOf(this.mfC) });
            if (this.mfC)
            {
              hjc();
              hje();
              Log.i(this.TAG, "%s resume by data gain cdnMediaId %s", new Object[] { bqf(), this.mfu });
              if (this.mfA != -1)
              {
                I(this.mfA, this.mfB);
                this.mfA = -1;
                bool1 = false;
                label588:
                this.mfC = bool1;
                paramInt = 3;
              }
            }
            for (;;)
            {
              this.mfx = paramInt;
              do
              {
                bool1 = true;
                break;
                if (bqo())
                {
                  bool1 = false;
                  break label588;
                }
                bool1 = true;
                break label588;
              } while ((this.mfx == 3) && (this.txH.isPlaying()));
              Log.i(this.TAG, "%s start to play video playStatus[%d]", new Object[] { bqf(), Integer.valueOf(this.mfx) });
              if (bqo()) {
                paramInt = 3;
              } else {
                paramInt = this.mfx;
              }
            }
          }
          Log.i(this.TAG, "%s prepare cdnMediaId [%s]", new Object[] { bqf(), this.mfu });
          if (this.mfx == 5) {
            this.mfx = 1;
          }
          bqm();
          bool1 = true;
        }
        label743:
        Log.d(this.TAG, "%s can not calc download.", new Object[] { bqf() });
        label764:
        continue;
        if (this.gX)
        {
          if (this.mfC)
          {
            if (this.mfA == -1) {
              break label825;
            }
            I(this.mfA, true);
            this.mfA = -1;
          }
          for (;;)
          {
            this.mfC = bool1;
            this.mfx = 3;
            Bg(i);
            bool1 = bool2;
            break;
            label825:
            if (!bqo()) {
              bool1 = true;
            }
          }
        }
        if (this.mfx == 5) {
          this.mfx = 1;
        }
        bqm();
        bool1 = bool2;
        continue;
        Log.w(this.TAG, "%s download error.", new Object[] { bqf() });
        bool1 = false;
      }
    }
  }
  
  public boolean xb(int paramInt)
  {
    AppMethodBeat.i(126806);
    if (this.mfw == 3)
    {
      AppMethodBeat.o(126806);
      return true;
    }
    if ((this.mfD - paramInt <= 1) && (this.mfD < this.mfz))
    {
      AppMethodBeat.o(126806);
      return false;
    }
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.mfy.a(paramInt, paramInt + 1, localPInt1, localPInt2)) {
        if (this.mft != null)
        {
          bool1 = this.mft.isVideoDataAvailable(this.mfu, localPInt1.value, localPInt2.value);
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
          this.mfD = paramInt;
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
        Log.e(this.TAG, "%s check video data error %s ", new Object[] { bqf(), localException1.toString() });
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
    public int mfN;
    public int mfO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.MMVideoView
 * JD-Core Version:    0.7.0.1
 */