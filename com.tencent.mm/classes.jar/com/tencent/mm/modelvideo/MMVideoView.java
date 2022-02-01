package com.tencent.mm.modelvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.plugin.a.k;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;

public class MMVideoView
  extends CommonVideoView
  implements b.a
{
  private i.a jpL;
  private String jpM;
  protected b jpS;
  protected String jpT;
  public String jpU;
  protected int jpV;
  protected int jpW;
  protected f jpX;
  protected int jpY;
  protected int jpZ;
  private boolean jqa;
  protected boolean jqb;
  protected int jqc;
  protected int jqd;
  protected boolean jqe;
  protected boolean jqf;
  private boolean jqg;
  protected MMVideoView.a jqh;
  protected boolean jqi;
  public boolean jqj;
  private MTimerHandler jqk;
  
  public MMVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(126787);
    this.jpV = 0;
    this.jpW = 0;
    this.jqc = 0;
    this.jqe = false;
    this.jqf = false;
    this.jqg = false;
    this.jqi = false;
    this.jqk = new MTimerHandler(new MTimerHandler.CallBack()
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
          bool1 = MMVideoView.this.ub(i);
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
    this.jpV = 0;
    this.jpW = 0;
    this.jqc = 0;
    this.jqe = false;
    this.jqf = false;
    this.jqg = false;
    this.jqi = false;
    this.jqk = new MTimerHandler(new MTimerHandler.CallBack()
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
          bool1 = MMVideoView.this.ub(i);
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
    this.jpV = 0;
    this.jpW = 0;
    this.jqc = 0;
    this.jqe = false;
    this.jqf = false;
    this.jqg = false;
    this.jqi = false;
    this.jqk = new MTimerHandler(new MTimerHandler.CallBack()
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
          bool1 = MMVideoView.this.ub(i);
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
  
  private void bgW()
  {
    AppMethodBeat.i(126808);
    Log.i(this.TAG, "%s pauseByDataBlock ", new Object[] { bgQ() });
    showLoading();
    pause();
    AppMethodBeat.o(126808);
  }
  
  private String getRootPath()
  {
    AppMethodBeat.i(126793);
    if (!Util.isNullOrNil(this.jpM))
    {
      str = this.jpM;
      AppMethodBeat.o(126793);
      return str;
    }
    String str = com.tencent.mm.loader.j.b.aKJ() + "video/";
    AppMethodBeat.o(126793);
    return str;
  }
  
  private boolean o(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(126811);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if ((this.jpX.a(paramInt1, paramInt2, localPInt1, localPInt2)) && (this.jpS != null))
      {
        bool = this.jpS.isVideoDataAvailable(this.jpT, localPInt1.value, localPInt2.value);
        if (bool) {
          break label258;
        }
        String str = this.jpT + "_" + localPInt1.value + "_" + localPInt2.value;
        if ((this.jqf) && (!paramBoolean)) {
          break label213;
        }
        this.jqf = true;
        if (this.jpS != null) {
          this.jpS.requestVideoData(this.jpT, localPInt1.value, localPInt2.value);
        }
        AppMethodBeat.o(126811);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e(this.TAG, "%s check video data error[%s] ", new Object[] { bgQ(), localException.toString() });
        boolean bool = false;
        continue;
        label213:
        Log.d(this.TAG, "%s already request video [%s] isRequestNow[%b] isSeek[%b] ", new Object[] { bgQ(), localException, Boolean.valueOf(this.jqf), Boolean.valueOf(paramBoolean) });
        continue;
        label258:
        Log.d(this.TAG, "%s already had video data.", new Object[] { bgQ() });
      }
    }
  }
  
  public final void AI(long paramLong)
  {
    AppMethodBeat.i(240850);
    Log.i(this.TAG, "%s deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s", new Object[] { bgQ(), Long.valueOf(paramLong), Integer.valueOf(this.jpY), this.jpT });
    if (this.jpY != 0)
    {
      Log.w(this.TAG, "moov had callback, do nothing.");
      AppMethodBeat.o(240850);
      return;
    }
    goq();
    try
    {
      if (this.jpX == null)
      {
        Log.w(this.TAG, "%s parser is null, thread is error.", new Object[] { bgQ() });
        AppMethodBeat.o(240850);
        return;
      }
      if (!this.jpX.L(this.jpU, paramLong)) {
        break label254;
      }
      this.jpY = this.jpX.blS();
      Log.i(this.TAG, "%s mp4 parse moov success. duration %d cdnMediaId %s ", new Object[] { bgQ(), Integer.valueOf(this.jpY), this.jpT });
      if (ub(0)) {
        bgV();
      }
      if (this.jpZ == -1)
      {
        this.jpW = 1;
        AppMethodBeat.o(240850);
        return;
      }
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace(this.TAG, localException, "%s deal moov ready error [%s]", new Object[] { bgQ(), this.jpT });
      AppMethodBeat.o(240850);
      return;
    }
    this.jpW = 2;
    AppMethodBeat.o(240850);
    return;
    label254:
    Log.w(this.TAG, "%s mp4 parse moov error. cdnMediaId %s", new Object[] { bgQ(), this.jpT });
    if (this.jpS != null) {
      this.jpS.requestVideoData(this.jpT, 0, -1);
    }
    AppMethodBeat.o(240850);
  }
  
  public boolean G(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(126804);
    switch (this.jpV)
    {
    }
    do
    {
      paramBoolean = true;
      for (;;)
      {
        Log.printInfoStack(this.TAG, "%s seek video time %d, download status %d playStatus %d", new Object[] { bgQ(), Integer.valueOf(paramInt), Integer.valueOf(this.jpV), Integer.valueOf(this.jpW) });
        AppMethodBeat.o(126804);
        return paramBoolean;
        this.jpW = 2;
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        a(paramInt, localPInt1, localPInt2);
        if (o(localPInt1.value, localPInt2.value, true))
        {
          this.jpZ = -1;
          this.jqb = false;
          this.jqc = localPInt2.value;
          this.jpW = 3;
          super.c(paramInt, paramBoolean);
          paramBoolean = true;
        }
        else
        {
          this.jpZ = paramInt;
          this.jqa = paramBoolean;
          this.jqb = true;
          bgW();
          paramBoolean = false;
          continue;
          super.c(paramInt, paramBoolean);
          paramBoolean = true;
          continue;
          paramBoolean = true;
        }
      }
    } while (asa());
    if (this.mEM)
    {
      this.mEK = paramBoolean;
      this.jqa = paramBoolean;
      this.mEL = paramInt;
      this.jpZ = paramInt;
    }
    for (;;)
    {
      start();
      break;
      this.mEK = paramBoolean;
      if (paramInt > 0) {
        this.mEL = paramInt;
      } else {
        this.mEL = this.mEH;
      }
    }
  }
  
  protected boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(126807);
    paramPInt1.value = Math.max(paramInt, this.jqc);
    if (this.jpW == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.jqd;
    }
    if (this.jpW == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.jqd + 8);
    }
    if ((this.jpW == 3) || (this.jpW == 4))
    {
      paramPInt1.value = this.jqc;
      paramPInt2.value = (this.jqd + paramInt + 1 + this.jqh.jqn);
    }
    if (paramPInt2.value >= this.jpY + 1) {
      paramPInt2.value = (this.jpY + 1);
    }
    if (paramPInt2.value < paramPInt1.value)
    {
      paramPInt1.value += this.jqh.jqn;
      AppMethodBeat.o(126807);
      return false;
    }
    Log.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { bgQ(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.jpW), Integer.valueOf(this.jqc), Integer.valueOf(this.jqd), this.jpT });
    AppMethodBeat.o(126807);
    return true;
  }
  
  public void ax(String paramString, int paramInt)
  {
    AppMethodBeat.i(126815);
    if ((!Util.isEqual(this.jpT, paramString)) || (this.jpV == 3))
    {
      AppMethodBeat.o(126815);
      return;
    }
    Log.i(this.TAG, "%s download finish [%d]", new Object[] { bgQ(), Integer.valueOf(paramInt) });
    if (paramInt == 0) {
      this.jpV = 3;
    }
    String str;
    if (this.jpL != null)
    {
      paramString = this.jpL;
      str = this.jpU;
      if (this.jpW <= 0) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.aO(str, bool);
      fO(true);
      this.jqf = false;
      AppMethodBeat.o(126815);
      return;
    }
  }
  
  protected void bgR()
  {
    AppMethodBeat.i(169101);
    if (!Util.isNullOrNil(this.url))
    {
      this.jpT = ("MMVideo_" + this.url.hashCode());
      this.jpU = (getRootPath() + "MMVideo_" + this.url.hashCode() + ".mp4");
      s.boN(s.boZ(this.jpU));
      Log.i(this.TAG, "%s set video path [%s %s]", new Object[] { bgQ(), this.jpT, this.jpU });
    }
    AppMethodBeat.o(169101);
  }
  
  protected f bgT()
  {
    AppMethodBeat.i(240849);
    k localk = new k();
    AppMethodBeat.o(240849);
    return localk;
  }
  
  protected void bgU()
  {
    this.jqh.jqm = 5;
    this.jqh.jqn = 2;
  }
  
  protected void bgV()
  {
    AppMethodBeat.i(126794);
    Log.printInfoStack(this.TAG, "%s prepareVideo", new Object[] { bgQ() });
    if (this.qbJ != null)
    {
      this.jqe = true;
      this.qbJ.setVideoPath(this.jpU);
    }
    AppMethodBeat.o(126794);
  }
  
  public void bgX() {}
  
  public void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(126792);
    super.c(paramBoolean, paramString, paramInt);
    bgR();
    AppMethodBeat.o(126792);
  }
  
  public boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(126803);
    paramBoolean = G((int)paramDouble, paramBoolean);
    AppMethodBeat.o(126803);
    return paramBoolean;
  }
  
  public j di(Context paramContext)
  {
    AppMethodBeat.i(126800);
    this.mEJ = 1;
    paramContext = new VideoPlayerTextureView(paramContext);
    paramContext.setNeedResetExtractor(true);
    AppMethodBeat.o(126800);
    return paramContext;
  }
  
  public void fN(boolean paramBoolean)
  {
    AppMethodBeat.i(126805);
    super.fN(paramBoolean);
    hideLoading();
    AppMethodBeat.o(126805);
  }
  
  public void fO(boolean paramBoolean)
  {
    AppMethodBeat.i(126816);
    Log.d(this.TAG, "%s start timer rightNow[%b]", new Object[] { bgQ(), Boolean.valueOf(paramBoolean) });
    this.jqk.stopTimer();
    this.jqk.startTimer(10L, 500L);
    AppMethodBeat.o(126816);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(126818);
    if (this.jpV == 3)
    {
      i = getVideoDurationSec();
      AppMethodBeat.o(126818);
      return i;
    }
    int i = this.jqc;
    AppMethodBeat.o(126818);
    return i;
  }
  
  public View getInnerVideoView()
  {
    if ((this.qbJ instanceof VideoPlayerTextureView)) {
      return (View)this.qbJ;
    }
    return null;
  }
  
  public String getMediaId()
  {
    return this.jpT;
  }
  
  public int getReportIdkey()
  {
    return 100;
  }
  
  public void i(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(126814);
    if (!Util.isEqual(this.jpT, paramString))
    {
      AppMethodBeat.o(126814);
      return;
    }
    Log.d(this.TAG, "%s download  onProgress [%d, %d]", new Object[] { bgQ(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(126814);
  }
  
  public void initView()
  {
    AppMethodBeat.i(126790);
    super.initView();
    this.TAG = "MicroMsg.MMVideoView";
    this.jpX = bgT();
    this.jqh = new MMVideoView.a();
    bgU();
    reset();
    AppMethodBeat.o(126790);
  }
  
  public void onCompletion()
  {
    AppMethodBeat.i(126798);
    if (this.jqj)
    {
      G(0, true);
      super.fdO();
    }
    for (;;)
    {
      this.jpX.release();
      AppMethodBeat.o(126798);
      return;
      super.onCompletion();
      if ((this.jpT != null) && (this.jpS != null)) {
        this.jpS.he(this.jpT);
      }
      reset();
      if (this.qbJ != null) {
        this.qbJ.stop();
      }
    }
  }
  
  public void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(126813);
    this.jqf = false;
    if ((paramLong1 <= -1L) || (paramLong2 <= -1L))
    {
      Log.w(this.TAG, "%s deal data available error offset[%d], length[%d]", new Object[] { bgQ(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      AppMethodBeat.o(126813);
      return;
    }
    if (!Util.isEqual(this.jpT, paramString))
    {
      AppMethodBeat.o(126813);
      return;
    }
    try
    {
      this.jqc = this.jpX.dG((int)paramLong1, (int)paramLong2);
      Log.i(this.TAG, "%s deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { bgQ(), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(this.jqc) });
      fO(true);
      AppMethodBeat.o(126813);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        Log.e(this.TAG, "%s deal data available file pos to video time error[%s] ", new Object[] { bgQ(), paramString.toString() });
      }
    }
  }
  
  public void onUIPause()
  {
    AppMethodBeat.i(126795);
    super.onUIPause();
    if (this.jqi)
    {
      this.jqg = true;
      stop();
    }
    AppMethodBeat.o(126795);
  }
  
  public void onUIResume()
  {
    AppMethodBeat.i(126796);
    super.onUIResume();
    Log.i(this.TAG, "%s onUIResume stopDownloadByUiPause[%b] currTimeOnUiPause[%d] isPlayOnUiPause[%b]", new Object[] { bgQ(), Boolean.valueOf(this.jqg), Integer.valueOf(this.mEH), Boolean.valueOf(this.mEI) });
    if (this.jqg)
    {
      G(this.mEH, this.mEI);
      AppMethodBeat.o(126796);
      return;
    }
    if ((this.qbJ != null) && (d.oD(24)) && ((this.qbJ instanceof VideoPlayerTextureView)))
    {
      ((VideoPlayerTextureView)this.qbJ).bLe();
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
      this.jqf = false;
      this.jpW = 4;
    }
    AppMethodBeat.o(126809);
    return bool;
  }
  
  public boolean play()
  {
    AppMethodBeat.i(126810);
    boolean bool = super.play();
    if (bool) {
      this.jpW = 3;
    }
    AppMethodBeat.o(126810);
    return bool;
  }
  
  public void reset()
  {
    this.jpZ = -1;
    this.jqc = 0;
    this.jpY = 0;
    this.jpW = 0;
    this.jpV = 0;
    this.jqb = false;
    this.jqe = false;
    this.jqf = false;
    if (this.jqh != null) {
      this.jqd = this.jqh.jqm;
    }
  }
  
  protected void setDownloadStatus(int paramInt)
  {
    this.jpV = paramInt;
  }
  
  protected void setFilepath(String paramString)
  {
    this.jpU = paramString;
  }
  
  public void setIMMDownloadFinish(i.a parama)
  {
    this.jpL = parama;
  }
  
  public void setIOnlineVideoProxy(b paramb)
  {
    AppMethodBeat.i(126791);
    this.jpS = paramb;
    this.jpS.a(this);
    AppMethodBeat.o(126791);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.jqj = paramBoolean;
  }
  
  public void setRootPath(String paramString)
  {
    this.jpM = paramString;
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(126801);
    if ((this.qbJ instanceof VideoPlayerTextureView))
    {
      ((VideoPlayerTextureView)this.qbJ).setScaleType(parame);
      yU(getReportIdkey() + 14);
    }
    AppMethodBeat.o(126801);
  }
  
  public void start()
  {
    AppMethodBeat.i(126797);
    Log.i(this.TAG, "%s start cdnMediaId[%s] timeDuration[%d]", new Object[] { bgQ(), this.jpT, Integer.valueOf(this.jpY) });
    if (this.qbJ != null)
    {
      if (!Util.isNullOrNil(this.qbJ.getVideoPath())) {
        break label145;
      }
      showLoading();
      this.jqi = true;
      this.jpY = 0;
      this.jpV = 1;
      if (this.jpS != null)
      {
        this.jpS.p(this.jpT, this.jpU, this.url);
        this.jpS.a(this);
      }
      fgB();
    }
    for (;;)
    {
      yU(getReportIdkey() + 1);
      AppMethodBeat.o(126797);
      return;
      label145:
      play();
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(126799);
    if (this.jpS != null) {
      this.jpS.he(this.jpT);
    }
    reset();
    super.stop();
    this.jpX.release();
    AppMethodBeat.o(126799);
  }
  
  public void stopTimer()
  {
    AppMethodBeat.i(126817);
    this.jqk.stopTimer();
    AppMethodBeat.o(126817);
  }
  
  protected final boolean ub(int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    AppMethodBeat.i(126802);
    if (this.jpZ != -1) {}
    for (int i = this.jpZ;; i = paramInt)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(bgQ()).append(" check timer playCurrPos ").append(paramInt).append(" playTime ").append(i).append(" cachePlayTime ").append(this.jqc).append(" timeDuration ").append(this.jpY).append(" playStatus ").append(this.jpW).append(" downloadStatus ").append(this.jpV).append(" cdnMediaId ").append(this.jpT).append(" isPrepareVideo[").append(this.jqe).append("], isPrepared[").append(this.ZA).append("]");
      Log.i(this.TAG, ((StringBuilder)localObject).toString());
      switch (this.jpV)
      {
      default: 
        Log.w(this.TAG, "%s check time default.", new Object[] { bgQ() });
        bool1 = false;
      }
      for (;;)
      {
        AppMethodBeat.o(126802);
        return bool1;
        if (!uc(i))
        {
          this.jqb = true;
          if (this.jqc <= 0) {
            if (this.jpZ == -1)
            {
              this.jpW = 1;
              label268:
              bool1 = false;
            }
          }
        }
        for (;;)
        {
          xI(i);
          localObject = new PInt();
          PInt localPInt = new PInt();
          if (!a(i, (PInt)localObject, localPInt)) {
            break label743;
          }
          if (!o(((PInt)localObject).value, localPInt.value, false)) {
            break label764;
          }
          this.jqc = Math.max(this.jqc, localPInt.value);
          bool1 = bool2;
          break;
          this.jpW = 2;
          break label268;
          Log.i(this.TAG, "%s pause by load data cdnMediaId %s, playStatus %d", new Object[] { bgQ(), this.jpT, Integer.valueOf(this.jpW) });
          gor();
          if ((this.jpW != 2) && (this.jpW != 4))
          {
            this.jqd += this.jqh.jqm;
            this.jqd = Math.min(this.jqd, 60);
            got();
            this.jpW = 4;
          }
          bgW();
          break label268;
          if (this.jqe)
          {
            xI(i);
            Log.i(this.TAG, "resumeByDataGain, playStatus:%s, isPlaying:%s, pauseByLoadData:%s", new Object[] { Integer.valueOf(this.jpW), Boolean.valueOf(this.qbJ.isPlaying()), Boolean.valueOf(this.jqb) });
            if (this.jqb)
            {
              gos();
              gou();
              Log.i(this.TAG, "%s resume by data gain cdnMediaId %s", new Object[] { bgQ(), this.jpT });
              if (this.jpZ != -1)
              {
                G(this.jpZ, this.jqa);
                this.jpZ = -1;
                bool1 = false;
                label588:
                this.jqb = bool1;
                paramInt = 3;
              }
            }
            for (;;)
            {
              this.jpW = paramInt;
              do
              {
                bool1 = true;
                break;
                if (play())
                {
                  bool1 = false;
                  break label588;
                }
                bool1 = true;
                break label588;
              } while ((this.jpW == 3) && (this.qbJ.isPlaying()));
              Log.i(this.TAG, "%s start to play video playStatus[%d]", new Object[] { bgQ(), Integer.valueOf(this.jpW) });
              if (play()) {
                paramInt = 3;
              } else {
                paramInt = this.jpW;
              }
            }
          }
          Log.i(this.TAG, "%s prepare cdnMediaId [%s]", new Object[] { bgQ(), this.jpT });
          if (this.jpW == 5) {
            this.jpW = 1;
          }
          bgV();
          bool1 = true;
        }
        label743:
        Log.d(this.TAG, "%s can not calc download.", new Object[] { bgQ() });
        label764:
        continue;
        if (this.ZA)
        {
          if (this.jqb)
          {
            if (this.jpZ == -1) {
              break label825;
            }
            G(this.jpZ, true);
            this.jpZ = -1;
          }
          for (;;)
          {
            this.jqb = bool1;
            this.jpW = 3;
            xI(i);
            bool1 = bool2;
            break;
            label825:
            if (!play()) {
              bool1 = true;
            }
          }
        }
        if (this.jpW == 5) {
          this.jpW = 1;
        }
        bgV();
        bool1 = bool2;
        continue;
        Log.w(this.TAG, "%s download error.", new Object[] { bgQ() });
        bool1 = false;
      }
    }
  }
  
  public boolean uc(int paramInt)
  {
    AppMethodBeat.i(126806);
    if (this.jpV == 3)
    {
      AppMethodBeat.o(126806);
      return true;
    }
    if ((this.jqc - paramInt <= 1) && (this.jqc < this.jpY))
    {
      AppMethodBeat.o(126806);
      return false;
    }
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.jpX.a(paramInt, paramInt + 1, localPInt1, localPInt2)) {
        if (this.jpS != null)
        {
          bool1 = this.jpS.isVideoDataAvailable(this.jpT, localPInt1.value, localPInt2.value);
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
          this.jqc = paramInt;
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
        Log.e(this.TAG, "%s check video data error %s ", new Object[] { bgQ(), localException1.toString() });
        boolean bool2 = bool1;
        continue;
        bool1 = false;
        continue;
        bool2 = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelvideo.MMVideoView
 * JD-Core Version:    0.7.0.1
 */