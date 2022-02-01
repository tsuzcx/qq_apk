package com.tencent.mm.modelvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.plugin.a.k;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.h.a;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.i;

public class MMVideoView
  extends CommonVideoView
  implements b.a
{
  protected int hYA;
  protected int hYB;
  protected boolean hYC;
  private boolean hYD;
  private boolean hYE;
  protected a hYF;
  protected boolean hYG;
  public boolean hYH;
  private au hYI;
  private String hYj;
  protected b hYp;
  protected String hYq;
  public String hYr;
  private h.a hYs;
  protected int hYt;
  protected int hYu;
  protected f hYv;
  protected int hYw;
  protected int hYx;
  private boolean hYy;
  protected boolean hYz;
  
  public MMVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(126787);
    this.hYt = 0;
    this.hYu = 0;
    this.hYA = 0;
    this.hYC = false;
    this.hYD = false;
    this.hYE = false;
    this.hYG = false;
    this.hYI = new au(new au.a()
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
          bool1 = MMVideoView.this.pG(i);
          ac.d(MMVideoView.e(MMVideoView.this), "%s check timer[%b] isplay[%b]", new Object[] { MMVideoView.f(MMVideoView.this), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
            ac.e(MMVideoView.c(MMVideoView.this), "%s online video timer check error [%s] ", new Object[] { MMVideoView.d(MMVideoView.this), localException.toString() });
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
    this.hYt = 0;
    this.hYu = 0;
    this.hYA = 0;
    this.hYC = false;
    this.hYD = false;
    this.hYE = false;
    this.hYG = false;
    this.hYI = new au(new au.a()
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
          bool1 = MMVideoView.this.pG(i);
          ac.d(MMVideoView.e(MMVideoView.this), "%s check timer[%b] isplay[%b]", new Object[] { MMVideoView.f(MMVideoView.this), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
            ac.e(MMVideoView.c(MMVideoView.this), "%s online video timer check error [%s] ", new Object[] { MMVideoView.d(MMVideoView.this), localException.toString() });
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
    this.hYt = 0;
    this.hYu = 0;
    this.hYA = 0;
    this.hYC = false;
    this.hYD = false;
    this.hYE = false;
    this.hYG = false;
    this.hYI = new au(new au.a()
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
          bool1 = MMVideoView.this.pG(i);
          ac.d(MMVideoView.e(MMVideoView.this), "%s check timer[%b] isplay[%b]", new Object[] { MMVideoView.f(MMVideoView.this), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
            ac.e(MMVideoView.c(MMVideoView.this), "%s online video timer check error [%s] ", new Object[] { MMVideoView.d(MMVideoView.this), localException.toString() });
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
  
  private void aJm()
  {
    AppMethodBeat.i(126808);
    ac.i(this.TAG, "%s pauseByDataBlock ", new Object[] { blf() });
    showLoading();
    pause();
    AppMethodBeat.o(126808);
  }
  
  private String getRootPath()
  {
    AppMethodBeat.i(126793);
    if (!bs.isNullOrNil(this.hYj))
    {
      str = this.hYj;
      AppMethodBeat.o(126793);
      return str;
    }
    String str = com.tencent.mm.loader.j.b.aph() + "video/";
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
      if ((this.hYv.a(paramInt1, paramInt2, localPInt1, localPInt2)) && (this.hYp != null))
      {
        bool = this.hYp.isVideoDataAvailable(this.hYq, localPInt1.value, localPInt2.value);
        if (bool) {
          break label258;
        }
        String str = this.hYq + "_" + localPInt1.value + "_" + localPInt2.value;
        if ((this.hYD) && (!paramBoolean)) {
          break label213;
        }
        this.hYD = true;
        if (this.hYp != null) {
          this.hYp.requestVideoData(this.hYq, localPInt1.value, localPInt2.value);
        }
        AppMethodBeat.o(126811);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ac.e(this.TAG, "%s check video data error[%s] ", new Object[] { blf(), localException.toString() });
        boolean bool = false;
        continue;
        label213:
        ac.d(this.TAG, "%s already request video [%s] isRequestNow[%b] isSeek[%b] ", new Object[] { blf(), localException, Boolean.valueOf(this.hYD), Boolean.valueOf(paramBoolean) });
        continue;
        label258:
        ac.d(this.TAG, "%s already had video data.", new Object[] { blf() });
      }
    }
  }
  
  public boolean C(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(126804);
    switch (this.hYt)
    {
    }
    do
    {
      paramBoolean = true;
      for (;;)
      {
        ac.m(this.TAG, "%s seek video time %d, download status %d playStatus %d", new Object[] { blf(), Integer.valueOf(paramInt), Integer.valueOf(this.hYt), Integer.valueOf(this.hYu) });
        AppMethodBeat.o(126804);
        return paramBoolean;
        this.hYu = 2;
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        a(paramInt, localPInt1, localPInt2);
        if (n(localPInt1.value, localPInt2.value, true))
        {
          this.hYx = -1;
          this.hYz = false;
          this.hYA = localPInt2.value;
          this.hYu = 3;
          super.c(paramInt, paramBoolean);
          paramBoolean = true;
        }
        else
        {
          this.hYx = paramInt;
          this.hYy = paramBoolean;
          this.hYz = true;
          aJm();
          paramBoolean = false;
          continue;
          super.c(paramInt, paramBoolean);
          paramBoolean = true;
          continue;
          paramBoolean = true;
        }
      }
    } while (blh());
    if (this.kWq)
    {
      this.kWo = paramBoolean;
      this.hYy = paramBoolean;
      this.kWp = paramInt;
      this.hYx = paramInt;
    }
    for (;;)
    {
      start();
      break;
      this.kWo = paramBoolean;
      if (paramInt > 0) {
        this.kWp = paramInt;
      } else {
        this.kWp = this.kWl;
      }
    }
  }
  
  protected boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(126807);
    paramPInt1.value = Math.max(paramInt, this.hYA);
    if (this.hYu == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.hYB;
    }
    if (this.hYu == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.hYB + 8);
    }
    if ((this.hYu == 3) || (this.hYu == 4))
    {
      paramPInt1.value = this.hYA;
      paramPInt2.value = (this.hYB + paramInt + 1 + this.hYF.hYL);
    }
    if (paramPInt2.value >= this.hYw + 1) {
      paramPInt2.value = (this.hYw + 1);
    }
    if (paramPInt2.value < paramPInt1.value)
    {
      paramPInt1.value += this.hYF.hYL;
      AppMethodBeat.o(126807);
      return false;
    }
    ac.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { blf(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.hYu), Integer.valueOf(this.hYA), Integer.valueOf(this.hYB), this.hYq });
    AppMethodBeat.o(126807);
    return true;
  }
  
  protected void aJh()
  {
    AppMethodBeat.i(169101);
    if (!bs.isNullOrNil(this.url))
    {
      this.hYq = ("MMVideo_" + this.url.hashCode());
      this.hYr = (getRootPath() + "MMVideo_" + this.url.hashCode() + ".mp4");
      i.aSh(i.aSs(this.hYr));
      ac.i(this.TAG, "%s set video path [%s %s]", new Object[] { blf(), this.hYq, this.hYr });
    }
    AppMethodBeat.o(169101);
  }
  
  protected f aJj()
  {
    AppMethodBeat.i(209966);
    k localk = new k();
    AppMethodBeat.o(209966);
    return localk;
  }
  
  protected void aJk()
  {
    this.hYF.hYK = 5;
    this.hYF.hYL = 2;
  }
  
  protected void aJl()
  {
    AppMethodBeat.i(126794);
    ac.m(this.TAG, "%s prepareVideo", new Object[] { blf() });
    if (this.odZ != null)
    {
      this.hYC = true;
      this.odZ.setVideoPath(this.hYr);
    }
    AppMethodBeat.o(126794);
  }
  
  public void aJn() {}
  
  public void aq(String paramString, int paramInt)
  {
    AppMethodBeat.i(126815);
    if ((!bs.lr(this.hYq, paramString)) || (this.hYt == 3))
    {
      AppMethodBeat.o(126815);
      return;
    }
    ac.i(this.TAG, "%s download finish [%d]", new Object[] { blf(), Integer.valueOf(paramInt) });
    if (paramInt == 0) {
      this.hYt = 3;
    }
    String str;
    if (this.hYs != null)
    {
      paramString = this.hYs;
      str = this.hYr;
      if (this.hYu <= 0) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.aI(str, bool);
      eT(true);
      this.hYD = false;
      AppMethodBeat.o(126815);
      return;
    }
  }
  
  public void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(126792);
    super.c(paramBoolean, paramString, paramInt);
    aJh();
    AppMethodBeat.o(126792);
  }
  
  public boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(126803);
    paramBoolean = C((int)paramDouble, paramBoolean);
    AppMethodBeat.o(126803);
    return paramBoolean;
  }
  
  public h cO(Context paramContext)
  {
    AppMethodBeat.i(126800);
    this.kWn = 1;
    paramContext = new VideoPlayerTextureView(paramContext);
    paramContext.setNeedResetExtractor(true);
    AppMethodBeat.o(126800);
    return paramContext;
  }
  
  public void eS(boolean paramBoolean)
  {
    AppMethodBeat.i(126805);
    super.eS(paramBoolean);
    hideLoading();
    AppMethodBeat.o(126805);
  }
  
  public void eT(boolean paramBoolean)
  {
    AppMethodBeat.i(126816);
    ac.d(this.TAG, "%s start timer rightNow[%b]", new Object[] { blf(), Boolean.valueOf(paramBoolean) });
    this.hYI.stopTimer();
    this.hYI.au(10L, 500L);
    AppMethodBeat.o(126816);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(126818);
    if (this.hYt == 3)
    {
      i = getVideoDurationSec();
      AppMethodBeat.o(126818);
      return i;
    }
    int i = this.hYA;
    AppMethodBeat.o(126818);
    return i;
  }
  
  public View getInnerVideoView()
  {
    if ((this.odZ instanceof VideoPlayerTextureView)) {
      return (View)this.odZ;
    }
    return null;
  }
  
  public String getMediaId()
  {
    return this.hYq;
  }
  
  public int getReportIdkey()
  {
    return 100;
  }
  
  public void i(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(126814);
    if (!bs.lr(this.hYq, paramString))
    {
      AppMethodBeat.o(126814);
      return;
    }
    ac.d(this.TAG, "%s download  onProgress [%d, %d]", new Object[] { blf(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(126814);
  }
  
  public void initView()
  {
    AppMethodBeat.i(126790);
    super.initView();
    this.TAG = "MicroMsg.MMVideoView";
    this.hYv = aJj();
    this.hYF = new a();
    aJk();
    reset();
    AppMethodBeat.o(126790);
  }
  
  public void onCompletion()
  {
    AppMethodBeat.i(126798);
    if (this.hYH)
    {
      C(0, true);
      super.dLd();
    }
    for (;;)
    {
      this.hYv.release();
      AppMethodBeat.o(126798);
      return;
      super.onCompletion();
      if ((this.hYq != null) && (this.hYp != null)) {
        this.hYp.fo(this.hYq);
      }
      reset();
      if (this.odZ != null) {
        this.odZ.stop();
      }
    }
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(126813);
    this.hYD = false;
    if ((paramLong1 <= -1L) || (paramLong2 <= -1L))
    {
      ac.w(this.TAG, "%s deal data available error offset[%d], length[%d]", new Object[] { blf(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      AppMethodBeat.o(126813);
      return;
    }
    if (!bs.lr(this.hYq, paramString))
    {
      AppMethodBeat.o(126813);
      return;
    }
    try
    {
      this.hYA = this.hYv.dw((int)paramLong1, (int)paramLong2);
      ac.i(this.TAG, "%s deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { blf(), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(this.hYA) });
      eT(true);
      AppMethodBeat.o(126813);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ac.e(this.TAG, "%s deal data available file pos to video time error[%s] ", new Object[] { blf(), paramString.toString() });
      }
    }
  }
  
  public void onUIPause()
  {
    AppMethodBeat.i(126795);
    super.onUIPause();
    if (this.hYG)
    {
      this.hYE = true;
      stop();
    }
    AppMethodBeat.o(126795);
  }
  
  public void onUIResume()
  {
    AppMethodBeat.i(126796);
    super.onUIResume();
    ac.i(this.TAG, "%s onUIResume stopDownloadByUiPause[%b] currTimeOnUiPause[%d] isPlayOnUiPause[%b]", new Object[] { blf(), Boolean.valueOf(this.hYE), Integer.valueOf(this.kWl), Boolean.valueOf(this.kWm) });
    if (this.hYE)
    {
      C(this.kWl, this.kWm);
      AppMethodBeat.o(126796);
      return;
    }
    if ((this.odZ != null) && (d.kZ(24)) && ((this.odZ instanceof VideoPlayerTextureView)))
    {
      ((VideoPlayerTextureView)this.odZ).bld();
      AppMethodBeat.o(126796);
      return;
    }
    AppMethodBeat.o(126796);
  }
  
  protected final boolean pG(int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    AppMethodBeat.i(126802);
    if (this.hYx != -1) {}
    for (int i = this.hYx;; i = paramInt)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(blf()).append(" check timer playCurrPos ").append(paramInt).append(" playTime ").append(i).append(" cachePlayTime ").append(this.hYA).append(" timeDuration ").append(this.hYw).append(" playStatus ").append(this.hYu).append(" downloadStatus ").append(this.hYt).append(" cdnMediaId ").append(this.hYq).append(" isPrepareVideo[").append(this.hYC).append("], isPrepared[").append(this.Xy).append("]");
      ac.i(this.TAG, ((StringBuilder)localObject).toString());
      switch (this.hYt)
      {
      default: 
        ac.w(this.TAG, "%s check time default.", new Object[] { blf() });
        bool1 = false;
      }
      for (;;)
      {
        AppMethodBeat.o(126802);
        return bool1;
        if (!pH(i))
        {
          this.hYz = true;
          if (this.hYA <= 0) {
            if (this.hYx == -1)
            {
              this.hYu = 1;
              label268:
              bool1 = false;
            }
          }
        }
        for (;;)
        {
          tc(i);
          localObject = new PInt();
          PInt localPInt = new PInt();
          if (!a(i, (PInt)localObject, localPInt)) {
            break label743;
          }
          if (!n(((PInt)localObject).value, localPInt.value, false)) {
            break label764;
          }
          this.hYA = Math.max(this.hYA, localPInt.value);
          bool1 = bool2;
          break;
          this.hYu = 2;
          break label268;
          ac.i(this.TAG, "%s pause by load data cdnMediaId %s, playStatus %d", new Object[] { blf(), this.hYq, Integer.valueOf(this.hYu) });
          eMw();
          if ((this.hYu != 2) && (this.hYu != 4))
          {
            this.hYB += this.hYF.hYK;
            this.hYB = Math.min(this.hYB, 60);
            eMy();
            this.hYu = 4;
          }
          aJm();
          break label268;
          if (this.hYC)
          {
            tc(i);
            ac.i(this.TAG, "resumeByDataGain, playStatus:%s, isPlaying:%s, pauseByLoadData:%s", new Object[] { Integer.valueOf(this.hYu), Boolean.valueOf(this.odZ.isPlaying()), Boolean.valueOf(this.hYz) });
            if (this.hYz)
            {
              eMx();
              eMz();
              ac.i(this.TAG, "%s resume by data gain cdnMediaId %s", new Object[] { blf(), this.hYq });
              if (this.hYx != -1)
              {
                C(this.hYx, this.hYy);
                this.hYx = -1;
                bool1 = false;
                label588:
                this.hYz = bool1;
                paramInt = 3;
              }
            }
            for (;;)
            {
              this.hYu = paramInt;
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
              } while ((this.hYu == 3) && (this.odZ.isPlaying()));
              ac.i(this.TAG, "%s start to play video playStatus[%d]", new Object[] { blf(), Integer.valueOf(this.hYu) });
              if (play()) {
                paramInt = 3;
              } else {
                paramInt = this.hYu;
              }
            }
          }
          ac.i(this.TAG, "%s prepare cdnMediaId [%s]", new Object[] { blf(), this.hYq });
          if (this.hYu == 5) {
            this.hYu = 1;
          }
          aJl();
          bool1 = true;
        }
        label743:
        ac.d(this.TAG, "%s can not calc download.", new Object[] { blf() });
        label764:
        continue;
        if (this.Xy)
        {
          if (this.hYz)
          {
            if (this.hYx == -1) {
              break label825;
            }
            C(this.hYx, true);
            this.hYx = -1;
          }
          for (;;)
          {
            this.hYz = bool1;
            this.hYu = 3;
            tc(i);
            bool1 = bool2;
            break;
            label825:
            if (!play()) {
              bool1 = true;
            }
          }
        }
        if (this.hYu == 5) {
          this.hYu = 1;
        }
        aJl();
        bool1 = bool2;
        continue;
        ac.w(this.TAG, "%s download error.", new Object[] { blf() });
        bool1 = false;
      }
    }
  }
  
  public boolean pH(int paramInt)
  {
    AppMethodBeat.i(126806);
    if (this.hYt == 3)
    {
      AppMethodBeat.o(126806);
      return true;
    }
    if ((this.hYA - paramInt <= 1) && (this.hYA < this.hYw))
    {
      AppMethodBeat.o(126806);
      return false;
    }
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.hYv.a(paramInt, paramInt + 1, localPInt1, localPInt2)) {
        if (this.hYp != null)
        {
          bool1 = this.hYp.isVideoDataAvailable(this.hYq, localPInt1.value, localPInt2.value);
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
          this.hYA = paramInt;
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
        ac.e(this.TAG, "%s check video data error %s ", new Object[] { blf(), localException1.toString() });
        boolean bool2 = bool1;
        continue;
        bool1 = false;
        continue;
        bool2 = false;
      }
    }
  }
  
  public boolean pause()
  {
    AppMethodBeat.i(126809);
    boolean bool = super.pause();
    if (bool)
    {
      this.hYD = false;
      this.hYu = 4;
    }
    AppMethodBeat.o(126809);
    return bool;
  }
  
  public boolean play()
  {
    AppMethodBeat.i(126810);
    boolean bool = super.play();
    if (bool) {
      this.hYu = 3;
    }
    AppMethodBeat.o(126810);
    return bool;
  }
  
  public final void qq(long paramLong)
  {
    AppMethodBeat.i(209967);
    ac.i(this.TAG, "%s deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s", new Object[] { blf(), Long.valueOf(paramLong), Integer.valueOf(this.hYw), this.hYq });
    if (this.hYw != 0)
    {
      ac.w(this.TAG, "moov had callback, do nothing.");
      AppMethodBeat.o(209967);
      return;
    }
    eMv();
    try
    {
      if (this.hYv == null)
      {
        ac.w(this.TAG, "%s parser is null, thread is error.", new Object[] { blf() });
        AppMethodBeat.o(209967);
        return;
      }
      if (!this.hYv.F(this.hYr, paramLong)) {
        break label263;
      }
      this.hYw = this.hYv.aND();
      ac.i(this.TAG, "%s mp4 parse moov success. duration %d cdnMediaId %s ", new Object[] { blf(), Integer.valueOf(this.hYw), this.hYq });
      if (pG(0)) {
        aJl();
      }
      if (this.hYx == -1)
      {
        this.hYu = 1;
        AppMethodBeat.o(209967);
        return;
      }
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace(this.TAG, localException, "%s deal moov ready error [%s]", new Object[] { blf(), this.hYq });
      AppMethodBeat.o(209967);
      return;
    }
    this.hYu = 2;
    AppMethodBeat.o(209967);
    return;
    label263:
    ac.w(this.TAG, "%s mp4 parse moov error. cdnMediaId %s", new Object[] { blf(), this.hYq });
    if (this.hYp != null) {
      this.hYp.requestVideoData(this.hYq, 0, -1);
    }
    AppMethodBeat.o(209967);
  }
  
  public void reset()
  {
    this.hYx = -1;
    this.hYA = 0;
    this.hYw = 0;
    this.hYu = 0;
    this.hYt = 0;
    this.hYz = false;
    this.hYC = false;
    this.hYD = false;
    if (this.hYF != null) {
      this.hYB = this.hYF.hYK;
    }
  }
  
  protected void setDownloadStatus(int paramInt)
  {
    this.hYt = paramInt;
  }
  
  protected void setFilepath(String paramString)
  {
    this.hYr = paramString;
  }
  
  public void setIMMDownloadFinish(h.a parama)
  {
    this.hYs = parama;
  }
  
  public void setIOnlineVideoProxy(b paramb)
  {
    AppMethodBeat.i(126791);
    this.hYp = paramb;
    this.hYp.a(this);
    AppMethodBeat.o(126791);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.hYH = paramBoolean;
  }
  
  public void setRootPath(String paramString)
  {
    this.hYj = paramString;
  }
  
  public void setScaleType(h.e parame)
  {
    AppMethodBeat.i(126801);
    if ((this.odZ instanceof VideoPlayerTextureView))
    {
      ((VideoPlayerTextureView)this.odZ).setScaleType(parame);
      oQ(getReportIdkey() + 14);
    }
    AppMethodBeat.o(126801);
  }
  
  public void start()
  {
    AppMethodBeat.i(126797);
    ac.i(this.TAG, "%s start cdnMediaId[%s] timeDuration[%d]", new Object[] { blf(), this.hYq, Integer.valueOf(this.hYw) });
    if (this.odZ != null)
    {
      if (!bs.isNullOrNil(this.odZ.getVideoPath())) {
        break label145;
      }
      showLoading();
      this.hYG = true;
      this.hYw = 0;
      this.hYt = 1;
      if (this.hYp != null)
      {
        this.hYp.q(this.hYq, this.hYr, this.url);
        this.hYp.a(this);
      }
      dOq();
    }
    for (;;)
    {
      oQ(getReportIdkey() + 1);
      AppMethodBeat.o(126797);
      return;
      label145:
      play();
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(126799);
    if (this.hYp != null) {
      this.hYp.fo(this.hYq);
    }
    reset();
    super.stop();
    this.hYv.release();
    AppMethodBeat.o(126799);
  }
  
  public void stopTimer()
  {
    AppMethodBeat.i(126817);
    this.hYI.stopTimer();
    AppMethodBeat.o(126817);
  }
  
  public static final class a
  {
    public int hYK;
    public int hYL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.MMVideoView
 * JD-Core Version:    0.7.0.1
 */