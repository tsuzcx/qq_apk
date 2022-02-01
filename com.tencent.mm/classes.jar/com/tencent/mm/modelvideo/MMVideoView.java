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
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;

public class MMVideoView
  extends CommonVideoView
  implements b.a
{
  protected b iuF;
  protected String iuG;
  public String iuH;
  private i.a iuI;
  protected int iuJ;
  protected int iuK;
  protected f iuL;
  protected int iuM;
  protected int iuN;
  private boolean iuO;
  protected boolean iuP;
  protected int iuQ;
  protected int iuR;
  protected boolean iuS;
  private boolean iuT;
  private boolean iuU;
  protected a iuV;
  protected boolean iuW;
  public boolean iuX;
  private aw iuY;
  private String iuz;
  
  public MMVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(126787);
    this.iuJ = 0;
    this.iuK = 0;
    this.iuQ = 0;
    this.iuS = false;
    this.iuT = false;
    this.iuU = false;
    this.iuW = false;
    this.iuY = new aw(new aw.a()
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
          bool1 = MMVideoView.this.ql(i);
          ae.d(MMVideoView.e(MMVideoView.this), "%s check timer[%b] isplay[%b]", new Object[] { MMVideoView.f(MMVideoView.this), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
            ae.e(MMVideoView.c(MMVideoView.this), "%s online video timer check error [%s] ", new Object[] { MMVideoView.d(MMVideoView.this), localException.toString() });
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
    this.iuJ = 0;
    this.iuK = 0;
    this.iuQ = 0;
    this.iuS = false;
    this.iuT = false;
    this.iuU = false;
    this.iuW = false;
    this.iuY = new aw(new aw.a()
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
          bool1 = MMVideoView.this.ql(i);
          ae.d(MMVideoView.e(MMVideoView.this), "%s check timer[%b] isplay[%b]", new Object[] { MMVideoView.f(MMVideoView.this), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
            ae.e(MMVideoView.c(MMVideoView.this), "%s online video timer check error [%s] ", new Object[] { MMVideoView.d(MMVideoView.this), localException.toString() });
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
    this.iuJ = 0;
    this.iuK = 0;
    this.iuQ = 0;
    this.iuS = false;
    this.iuT = false;
    this.iuU = false;
    this.iuW = false;
    this.iuY = new aw(new aw.a()
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
          bool1 = MMVideoView.this.ql(i);
          ae.d(MMVideoView.e(MMVideoView.this), "%s check timer[%b] isplay[%b]", new Object[] { MMVideoView.f(MMVideoView.this), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
            ae.e(MMVideoView.c(MMVideoView.this), "%s online video timer check error [%s] ", new Object[] { MMVideoView.d(MMVideoView.this), localException.toString() });
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
  
  private void aMU()
  {
    AppMethodBeat.i(126808);
    ae.i(this.TAG, "%s pauseByDataBlock ", new Object[] { bpA() });
    showLoading();
    pause();
    AppMethodBeat.o(126808);
  }
  
  private String getRootPath()
  {
    AppMethodBeat.i(126793);
    if (!bu.isNullOrNil(this.iuz))
    {
      str = this.iuz;
      AppMethodBeat.o(126793);
      return str;
    }
    String str = com.tencent.mm.loader.j.b.asj() + "video/";
    AppMethodBeat.o(126793);
    return str;
  }
  
  private boolean n(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(126811);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if ((this.iuL.a(paramInt1, paramInt2, localPInt1, localPInt2)) && (this.iuF != null))
      {
        bool = this.iuF.isVideoDataAvailable(this.iuG, localPInt1.value, localPInt2.value);
        if (bool) {
          break label258;
        }
        String str = this.iuG + "_" + localPInt1.value + "_" + localPInt2.value;
        if ((this.iuT) && (!paramBoolean)) {
          break label213;
        }
        this.iuT = true;
        if (this.iuF != null) {
          this.iuF.requestVideoData(this.iuG, localPInt1.value, localPInt2.value);
        }
        AppMethodBeat.o(126811);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ae.e(this.TAG, "%s check video data error[%s] ", new Object[] { bpA(), localException.toString() });
        boolean bool = false;
        continue;
        label213:
        ae.d(this.TAG, "%s already request video [%s] isRequestNow[%b] isSeek[%b] ", new Object[] { bpA(), localException, Boolean.valueOf(this.iuT), Boolean.valueOf(paramBoolean) });
        continue;
        label258:
        ae.d(this.TAG, "%s already had video data.", new Object[] { bpA() });
      }
    }
  }
  
  public boolean C(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(126804);
    switch (this.iuJ)
    {
    }
    do
    {
      paramBoolean = true;
      for (;;)
      {
        ae.m(this.TAG, "%s seek video time %d, download status %d playStatus %d", new Object[] { bpA(), Integer.valueOf(paramInt), Integer.valueOf(this.iuJ), Integer.valueOf(this.iuK) });
        AppMethodBeat.o(126804);
        return paramBoolean;
        this.iuK = 2;
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        a(paramInt, localPInt1, localPInt2);
        if (n(localPInt1.value, localPInt2.value, true))
        {
          this.iuN = -1;
          this.iuP = false;
          this.iuQ = localPInt2.value;
          this.iuK = 3;
          super.c(paramInt, paramBoolean);
          paramBoolean = true;
        }
        else
        {
          this.iuN = paramInt;
          this.iuO = paramBoolean;
          this.iuP = true;
          aMU();
          paramBoolean = false;
          continue;
          super.c(paramInt, paramBoolean);
          paramBoolean = true;
          continue;
          paramBoolean = true;
        }
      }
    } while (bpC());
    if (this.lxO)
    {
      this.lxM = paramBoolean;
      this.iuO = paramBoolean;
      this.lxN = paramInt;
      this.iuN = paramInt;
    }
    for (;;)
    {
      start();
      break;
      this.lxM = paramBoolean;
      if (paramInt > 0) {
        this.lxN = paramInt;
      } else {
        this.lxN = this.lxJ;
      }
    }
  }
  
  protected boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(126807);
    paramPInt1.value = Math.max(paramInt, this.iuQ);
    if (this.iuK == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.iuR;
    }
    if (this.iuK == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.iuR + 8);
    }
    if ((this.iuK == 3) || (this.iuK == 4))
    {
      paramPInt1.value = this.iuQ;
      paramPInt2.value = (this.iuR + paramInt + 1 + this.iuV.ivb);
    }
    if (paramPInt2.value >= this.iuM + 1) {
      paramPInt2.value = (this.iuM + 1);
    }
    if (paramPInt2.value < paramPInt1.value)
    {
      paramPInt1.value += this.iuV.ivb;
      AppMethodBeat.o(126807);
      return false;
    }
    ae.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { bpA(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.iuK), Integer.valueOf(this.iuQ), Integer.valueOf(this.iuR), this.iuG });
    AppMethodBeat.o(126807);
    return true;
  }
  
  protected void aMP()
  {
    AppMethodBeat.i(169101);
    if (!bu.isNullOrNil(this.url))
    {
      this.iuG = ("MMVideo_" + this.url.hashCode());
      this.iuH = (getRootPath() + "MMVideo_" + this.url.hashCode() + ".mp4");
      o.aZI(o.aZU(this.iuH));
      ae.i(this.TAG, "%s set video path [%s %s]", new Object[] { bpA(), this.iuG, this.iuH });
    }
    AppMethodBeat.o(169101);
  }
  
  protected f aMR()
  {
    AppMethodBeat.i(217460);
    k localk = new k();
    AppMethodBeat.o(217460);
    return localk;
  }
  
  protected void aMS()
  {
    this.iuV.iva = 5;
    this.iuV.ivb = 2;
  }
  
  protected void aMT()
  {
    AppMethodBeat.i(126794);
    ae.m(this.TAG, "%s prepareVideo", new Object[] { bpA() });
    if (this.oNV != null)
    {
      this.iuS = true;
      this.oNV.setVideoPath(this.iuH);
    }
    AppMethodBeat.o(126794);
  }
  
  public void aMV() {}
  
  public void at(String paramString, int paramInt)
  {
    AppMethodBeat.i(126815);
    if ((!bu.lX(this.iuG, paramString)) || (this.iuJ == 3))
    {
      AppMethodBeat.o(126815);
      return;
    }
    ae.i(this.TAG, "%s download finish [%d]", new Object[] { bpA(), Integer.valueOf(paramInt) });
    if (paramInt == 0) {
      this.iuJ = 3;
    }
    String str;
    if (this.iuI != null)
    {
      paramString = this.iuI;
      str = this.iuH;
      if (this.iuK <= 0) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.aM(str, bool);
      eY(true);
      this.iuT = false;
      AppMethodBeat.o(126815);
      return;
    }
  }
  
  public void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(126792);
    super.c(paramBoolean, paramString, paramInt);
    aMP();
    AppMethodBeat.o(126792);
  }
  
  public boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(126803);
    paramBoolean = C((int)paramDouble, paramBoolean);
    AppMethodBeat.o(126803);
    return paramBoolean;
  }
  
  public h cN(Context paramContext)
  {
    AppMethodBeat.i(126800);
    this.lxL = 1;
    paramContext = new VideoPlayerTextureView(paramContext);
    paramContext.setNeedResetExtractor(true);
    AppMethodBeat.o(126800);
    return paramContext;
  }
  
  public void eX(boolean paramBoolean)
  {
    AppMethodBeat.i(126805);
    super.eX(paramBoolean);
    hideLoading();
    AppMethodBeat.o(126805);
  }
  
  public void eY(boolean paramBoolean)
  {
    AppMethodBeat.i(126816);
    ae.d(this.TAG, "%s start timer rightNow[%b]", new Object[] { bpA(), Boolean.valueOf(paramBoolean) });
    this.iuY.stopTimer();
    this.iuY.ay(10L, 500L);
    AppMethodBeat.o(126816);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(126818);
    if (this.iuJ == 3)
    {
      i = getVideoDurationSec();
      AppMethodBeat.o(126818);
      return i;
    }
    int i = this.iuQ;
    AppMethodBeat.o(126818);
    return i;
  }
  
  public View getInnerVideoView()
  {
    if ((this.oNV instanceof VideoPlayerTextureView)) {
      return (View)this.oNV;
    }
    return null;
  }
  
  public String getMediaId()
  {
    return this.iuG;
  }
  
  public int getReportIdkey()
  {
    return 100;
  }
  
  public void i(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(126814);
    if (!bu.lX(this.iuG, paramString))
    {
      AppMethodBeat.o(126814);
      return;
    }
    ae.d(this.TAG, "%s download  onProgress [%d, %d]", new Object[] { bpA(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(126814);
  }
  
  public void initView()
  {
    AppMethodBeat.i(126790);
    super.initView();
    this.TAG = "MicroMsg.MMVideoView";
    this.iuL = aMR();
    this.iuV = new a();
    aMS();
    reset();
    AppMethodBeat.o(126790);
  }
  
  public void onCompletion()
  {
    AppMethodBeat.i(126798);
    if (this.iuX)
    {
      C(0, true);
      super.eaX();
    }
    for (;;)
    {
      this.iuL.release();
      AppMethodBeat.o(126798);
      return;
      super.onCompletion();
      if ((this.iuG != null) && (this.iuF != null)) {
        this.iuF.gp(this.iuG);
      }
      reset();
      if (this.oNV != null) {
        this.oNV.stop();
      }
    }
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(126813);
    this.iuT = false;
    if ((paramLong1 <= -1L) || (paramLong2 <= -1L))
    {
      ae.w(this.TAG, "%s deal data available error offset[%d], length[%d]", new Object[] { bpA(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      AppMethodBeat.o(126813);
      return;
    }
    if (!bu.lX(this.iuG, paramString))
    {
      AppMethodBeat.o(126813);
      return;
    }
    try
    {
      this.iuQ = this.iuL.dy((int)paramLong1, (int)paramLong2);
      ae.i(this.TAG, "%s deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { bpA(), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(this.iuQ) });
      eY(true);
      AppMethodBeat.o(126813);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ae.e(this.TAG, "%s deal data available file pos to video time error[%s] ", new Object[] { bpA(), paramString.toString() });
      }
    }
  }
  
  public void onUIPause()
  {
    AppMethodBeat.i(126795);
    super.onUIPause();
    if (this.iuW)
    {
      this.iuU = true;
      stop();
    }
    AppMethodBeat.o(126795);
  }
  
  public void onUIResume()
  {
    AppMethodBeat.i(126796);
    super.onUIResume();
    ae.i(this.TAG, "%s onUIResume stopDownloadByUiPause[%b] currTimeOnUiPause[%d] isPlayOnUiPause[%b]", new Object[] { bpA(), Boolean.valueOf(this.iuU), Integer.valueOf(this.lxJ), Boolean.valueOf(this.lxK) });
    if (this.iuU)
    {
      C(this.lxJ, this.lxK);
      AppMethodBeat.o(126796);
      return;
    }
    if ((this.oNV != null) && (d.lA(24)) && ((this.oNV instanceof VideoPlayerTextureView)))
    {
      ((VideoPlayerTextureView)this.oNV).bpy();
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
      this.iuT = false;
      this.iuK = 4;
    }
    AppMethodBeat.o(126809);
    return bool;
  }
  
  public boolean play()
  {
    AppMethodBeat.i(126810);
    boolean bool = super.play();
    if (bool) {
      this.iuK = 3;
    }
    AppMethodBeat.o(126810);
    return bool;
  }
  
  protected final boolean ql(int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    AppMethodBeat.i(126802);
    if (this.iuN != -1) {}
    for (int i = this.iuN;; i = paramInt)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(bpA()).append(" check timer playCurrPos ").append(paramInt).append(" playTime ").append(i).append(" cachePlayTime ").append(this.iuQ).append(" timeDuration ").append(this.iuM).append(" playStatus ").append(this.iuK).append(" downloadStatus ").append(this.iuJ).append(" cdnMediaId ").append(this.iuG).append(" isPrepareVideo[").append(this.iuS).append("], isPrepared[").append(this.Zn).append("]");
      ae.i(this.TAG, ((StringBuilder)localObject).toString());
      switch (this.iuJ)
      {
      default: 
        ae.w(this.TAG, "%s check time default.", new Object[] { bpA() });
        bool1 = false;
      }
      for (;;)
      {
        AppMethodBeat.o(126802);
        return bool1;
        if (!qm(i))
        {
          this.iuP = true;
          if (this.iuQ <= 0) {
            if (this.iuN == -1)
            {
              this.iuK = 1;
              label268:
              bool1 = false;
            }
          }
        }
        for (;;)
        {
          tK(i);
          localObject = new PInt();
          PInt localPInt = new PInt();
          if (!a(i, (PInt)localObject, localPInt)) {
            break label743;
          }
          if (!n(((PInt)localObject).value, localPInt.value, false)) {
            break label764;
          }
          this.iuQ = Math.max(this.iuQ, localPInt.value);
          bool1 = bool2;
          break;
          this.iuK = 2;
          break label268;
          ae.i(this.TAG, "%s pause by load data cdnMediaId %s, playStatus %d", new Object[] { bpA(), this.iuG, Integer.valueOf(this.iuK) });
          ffh();
          if ((this.iuK != 2) && (this.iuK != 4))
          {
            this.iuR += this.iuV.iva;
            this.iuR = Math.min(this.iuR, 60);
            ffj();
            this.iuK = 4;
          }
          aMU();
          break label268;
          if (this.iuS)
          {
            tK(i);
            ae.i(this.TAG, "resumeByDataGain, playStatus:%s, isPlaying:%s, pauseByLoadData:%s", new Object[] { Integer.valueOf(this.iuK), Boolean.valueOf(this.oNV.isPlaying()), Boolean.valueOf(this.iuP) });
            if (this.iuP)
            {
              ffi();
              ffk();
              ae.i(this.TAG, "%s resume by data gain cdnMediaId %s", new Object[] { bpA(), this.iuG });
              if (this.iuN != -1)
              {
                C(this.iuN, this.iuO);
                this.iuN = -1;
                bool1 = false;
                label588:
                this.iuP = bool1;
                paramInt = 3;
              }
            }
            for (;;)
            {
              this.iuK = paramInt;
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
              } while ((this.iuK == 3) && (this.oNV.isPlaying()));
              ae.i(this.TAG, "%s start to play video playStatus[%d]", new Object[] { bpA(), Integer.valueOf(this.iuK) });
              if (play()) {
                paramInt = 3;
              } else {
                paramInt = this.iuK;
              }
            }
          }
          ae.i(this.TAG, "%s prepare cdnMediaId [%s]", new Object[] { bpA(), this.iuG });
          if (this.iuK == 5) {
            this.iuK = 1;
          }
          aMT();
          bool1 = true;
        }
        label743:
        ae.d(this.TAG, "%s can not calc download.", new Object[] { bpA() });
        label764:
        continue;
        if (this.Zn)
        {
          if (this.iuP)
          {
            if (this.iuN == -1) {
              break label825;
            }
            C(this.iuN, true);
            this.iuN = -1;
          }
          for (;;)
          {
            this.iuP = bool1;
            this.iuK = 3;
            tK(i);
            bool1 = bool2;
            break;
            label825:
            if (!play()) {
              bool1 = true;
            }
          }
        }
        if (this.iuK == 5) {
          this.iuK = 1;
        }
        aMT();
        bool1 = bool2;
        continue;
        ae.w(this.TAG, "%s download error.", new Object[] { bpA() });
        bool1 = false;
      }
    }
  }
  
  public boolean qm(int paramInt)
  {
    AppMethodBeat.i(126806);
    if (this.iuJ == 3)
    {
      AppMethodBeat.o(126806);
      return true;
    }
    if ((this.iuQ - paramInt <= 1) && (this.iuQ < this.iuM))
    {
      AppMethodBeat.o(126806);
      return false;
    }
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.iuL.a(paramInt, paramInt + 1, localPInt1, localPInt2)) {
        if (this.iuF != null)
        {
          bool1 = this.iuF.isVideoDataAvailable(this.iuG, localPInt1.value, localPInt2.value);
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
          this.iuQ = paramInt;
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
        ae.e(this.TAG, "%s check video data error %s ", new Object[] { bpA(), localException1.toString() });
        boolean bool2 = bool1;
        continue;
        bool1 = false;
        continue;
        bool2 = false;
      }
    }
  }
  
  public void reset()
  {
    this.iuN = -1;
    this.iuQ = 0;
    this.iuM = 0;
    this.iuK = 0;
    this.iuJ = 0;
    this.iuP = false;
    this.iuS = false;
    this.iuT = false;
    if (this.iuV != null) {
      this.iuR = this.iuV.iva;
    }
  }
  
  public final void sC(long paramLong)
  {
    AppMethodBeat.i(217461);
    ae.i(this.TAG, "%s deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s", new Object[] { bpA(), Long.valueOf(paramLong), Integer.valueOf(this.iuM), this.iuG });
    if (this.iuM != 0)
    {
      ae.w(this.TAG, "moov had callback, do nothing.");
      AppMethodBeat.o(217461);
      return;
    }
    ffg();
    try
    {
      if (this.iuL == null)
      {
        ae.w(this.TAG, "%s parser is null, thread is error.", new Object[] { bpA() });
        AppMethodBeat.o(217461);
        return;
      }
      if (!this.iuL.L(this.iuH, paramLong)) {
        break label263;
      }
      this.iuM = this.iuL.aRo();
      ae.i(this.TAG, "%s mp4 parse moov success. duration %d cdnMediaId %s ", new Object[] { bpA(), Integer.valueOf(this.iuM), this.iuG });
      if (ql(0)) {
        aMT();
      }
      if (this.iuN == -1)
      {
        this.iuK = 1;
        AppMethodBeat.o(217461);
        return;
      }
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace(this.TAG, localException, "%s deal moov ready error [%s]", new Object[] { bpA(), this.iuG });
      AppMethodBeat.o(217461);
      return;
    }
    this.iuK = 2;
    AppMethodBeat.o(217461);
    return;
    label263:
    ae.w(this.TAG, "%s mp4 parse moov error. cdnMediaId %s", new Object[] { bpA(), this.iuG });
    if (this.iuF != null) {
      this.iuF.requestVideoData(this.iuG, 0, -1);
    }
    AppMethodBeat.o(217461);
  }
  
  protected void setDownloadStatus(int paramInt)
  {
    this.iuJ = paramInt;
  }
  
  protected void setFilepath(String paramString)
  {
    this.iuH = paramString;
  }
  
  public void setIMMDownloadFinish(i.a parama)
  {
    this.iuI = parama;
  }
  
  public void setIOnlineVideoProxy(b paramb)
  {
    AppMethodBeat.i(126791);
    this.iuF = paramb;
    this.iuF.a(this);
    AppMethodBeat.o(126791);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.iuX = paramBoolean;
  }
  
  public void setRootPath(String paramString)
  {
    this.iuz = paramString;
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(126801);
    if ((this.oNV instanceof VideoPlayerTextureView))
    {
      ((VideoPlayerTextureView)this.oNV).setScaleType(parame);
      rd(getReportIdkey() + 14);
    }
    AppMethodBeat.o(126801);
  }
  
  public void start()
  {
    AppMethodBeat.i(126797);
    ae.i(this.TAG, "%s start cdnMediaId[%s] timeDuration[%d]", new Object[] { bpA(), this.iuG, Integer.valueOf(this.iuM) });
    if (this.oNV != null)
    {
      if (!bu.isNullOrNil(this.oNV.getVideoPath())) {
        break label145;
      }
      showLoading();
      this.iuW = true;
      this.iuM = 0;
      this.iuJ = 1;
      if (this.iuF != null)
      {
        this.iuF.p(this.iuG, this.iuH, this.url);
        this.iuF.a(this);
      }
      eek();
    }
    for (;;)
    {
      rd(getReportIdkey() + 1);
      AppMethodBeat.o(126797);
      return;
      label145:
      play();
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(126799);
    if (this.iuF != null) {
      this.iuF.gp(this.iuG);
    }
    reset();
    super.stop();
    this.iuL.release();
    AppMethodBeat.o(126799);
  }
  
  public void stopTimer()
  {
    AppMethodBeat.i(126817);
    this.iuY.stopTimer();
    AppMethodBeat.o(126817);
  }
  
  public static final class a
  {
    public int iva;
    public int ivb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.modelvideo.MMVideoView
 * JD-Core Version:    0.7.0.1
 */