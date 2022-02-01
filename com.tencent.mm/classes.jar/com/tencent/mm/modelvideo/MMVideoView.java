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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.i;

public class MMVideoView
  extends CommonVideoView
  implements b.a
{
  private String irF;
  protected b irL;
  protected String irM;
  public String irN;
  private i.a irO;
  protected int irP;
  protected int irQ;
  protected f irR;
  protected int irS;
  protected int irT;
  private boolean irU;
  protected boolean irV;
  protected int irW;
  protected int irX;
  protected boolean irY;
  private boolean irZ;
  private boolean isa;
  protected MMVideoView.a isb;
  protected boolean isc;
  public boolean isd;
  private av ise;
  
  public MMVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(126787);
    this.irP = 0;
    this.irQ = 0;
    this.irW = 0;
    this.irY = false;
    this.irZ = false;
    this.isa = false;
    this.isc = false;
    this.ise = new av(new av.a()
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
          bool1 = MMVideoView.this.qi(i);
          ad.d(MMVideoView.e(MMVideoView.this), "%s check timer[%b] isplay[%b]", new Object[] { MMVideoView.f(MMVideoView.this), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
            ad.e(MMVideoView.c(MMVideoView.this), "%s online video timer check error [%s] ", new Object[] { MMVideoView.d(MMVideoView.this), localException.toString() });
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
    this.irP = 0;
    this.irQ = 0;
    this.irW = 0;
    this.irY = false;
    this.irZ = false;
    this.isa = false;
    this.isc = false;
    this.ise = new av(new av.a()
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
          bool1 = MMVideoView.this.qi(i);
          ad.d(MMVideoView.e(MMVideoView.this), "%s check timer[%b] isplay[%b]", new Object[] { MMVideoView.f(MMVideoView.this), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
            ad.e(MMVideoView.c(MMVideoView.this), "%s online video timer check error [%s] ", new Object[] { MMVideoView.d(MMVideoView.this), localException.toString() });
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
    this.irP = 0;
    this.irQ = 0;
    this.irW = 0;
    this.irY = false;
    this.irZ = false;
    this.isa = false;
    this.isc = false;
    this.ise = new av(new av.a()
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
          bool1 = MMVideoView.this.qi(i);
          ad.d(MMVideoView.e(MMVideoView.this), "%s check timer[%b] isplay[%b]", new Object[] { MMVideoView.f(MMVideoView.this), Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
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
            ad.e(MMVideoView.c(MMVideoView.this), "%s online video timer check error [%s] ", new Object[] { MMVideoView.d(MMVideoView.this), localException.toString() });
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
  
  private void aMw()
  {
    AppMethodBeat.i(126808);
    ad.i(this.TAG, "%s pauseByDataBlock ", new Object[] { boQ() });
    showLoading();
    pause();
    AppMethodBeat.o(126808);
  }
  
  private String getRootPath()
  {
    AppMethodBeat.i(126793);
    if (!bt.isNullOrNil(this.irF))
    {
      str = this.irF;
      AppMethodBeat.o(126793);
      return str;
    }
    String str = com.tencent.mm.loader.j.b.arU() + "video/";
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
      if ((this.irR.a(paramInt1, paramInt2, localPInt1, localPInt2)) && (this.irL != null))
      {
        bool = this.irL.isVideoDataAvailable(this.irM, localPInt1.value, localPInt2.value);
        if (bool) {
          break label258;
        }
        String str = this.irM + "_" + localPInt1.value + "_" + localPInt2.value;
        if ((this.irZ) && (!paramBoolean)) {
          break label213;
        }
        this.irZ = true;
        if (this.irL != null) {
          this.irL.requestVideoData(this.irM, localPInt1.value, localPInt2.value);
        }
        AppMethodBeat.o(126811);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e(this.TAG, "%s check video data error[%s] ", new Object[] { boQ(), localException.toString() });
        boolean bool = false;
        continue;
        label213:
        ad.d(this.TAG, "%s already request video [%s] isRequestNow[%b] isSeek[%b] ", new Object[] { boQ(), localException, Boolean.valueOf(this.irZ), Boolean.valueOf(paramBoolean) });
        continue;
        label258:
        ad.d(this.TAG, "%s already had video data.", new Object[] { boQ() });
      }
    }
  }
  
  public boolean C(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(126804);
    switch (this.irP)
    {
    }
    do
    {
      paramBoolean = true;
      for (;;)
      {
        ad.m(this.TAG, "%s seek video time %d, download status %d playStatus %d", new Object[] { boQ(), Integer.valueOf(paramInt), Integer.valueOf(this.irP), Integer.valueOf(this.irQ) });
        AppMethodBeat.o(126804);
        return paramBoolean;
        this.irQ = 2;
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        a(paramInt, localPInt1, localPInt2);
        if (n(localPInt1.value, localPInt2.value, true))
        {
          this.irT = -1;
          this.irV = false;
          this.irW = localPInt2.value;
          this.irQ = 3;
          super.c(paramInt, paramBoolean);
          paramBoolean = true;
        }
        else
        {
          this.irT = paramInt;
          this.irU = paramBoolean;
          this.irV = true;
          aMw();
          paramBoolean = false;
          continue;
          super.c(paramInt, paramBoolean);
          paramBoolean = true;
          continue;
          paramBoolean = true;
        }
      }
    } while (boS());
    if (this.ltp)
    {
      this.ltn = paramBoolean;
      this.irU = paramBoolean;
      this.lto = paramInt;
      this.irT = paramInt;
    }
    for (;;)
    {
      start();
      break;
      this.ltn = paramBoolean;
      if (paramInt > 0) {
        this.lto = paramInt;
      } else {
        this.lto = this.ltk;
      }
    }
  }
  
  protected boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(126807);
    paramPInt1.value = Math.max(paramInt, this.irW);
    if (this.irQ == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.irX;
    }
    if (this.irQ == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.irX + 8);
    }
    if ((this.irQ == 3) || (this.irQ == 4))
    {
      paramPInt1.value = this.irW;
      paramPInt2.value = (this.irX + paramInt + 1 + this.isb.ish);
    }
    if (paramPInt2.value >= this.irS + 1) {
      paramPInt2.value = (this.irS + 1);
    }
    if (paramPInt2.value < paramPInt1.value)
    {
      paramPInt1.value += this.isb.ish;
      AppMethodBeat.o(126807);
      return false;
    }
    ad.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { boQ(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.irQ), Integer.valueOf(this.irW), Integer.valueOf(this.irX), this.irM });
    AppMethodBeat.o(126807);
    return true;
  }
  
  protected void aMr()
  {
    AppMethodBeat.i(169101);
    if (!bt.isNullOrNil(this.url))
    {
      this.irM = ("MMVideo_" + this.url.hashCode());
      this.irN = (getRootPath() + "MMVideo_" + this.url.hashCode() + ".mp4");
      i.aYg(i.aYr(this.irN));
      ad.i(this.TAG, "%s set video path [%s %s]", new Object[] { boQ(), this.irM, this.irN });
    }
    AppMethodBeat.o(169101);
  }
  
  protected f aMt()
  {
    AppMethodBeat.i(218843);
    k localk = new k();
    AppMethodBeat.o(218843);
    return localk;
  }
  
  protected void aMu()
  {
    this.isb.isg = 5;
    this.isb.ish = 2;
  }
  
  protected void aMv()
  {
    AppMethodBeat.i(126794);
    ad.m(this.TAG, "%s prepareVideo", new Object[] { boQ() });
    if (this.oHt != null)
    {
      this.irY = true;
      this.oHt.setVideoPath(this.irN);
    }
    AppMethodBeat.o(126794);
  }
  
  public void aMx() {}
  
  public void as(String paramString, int paramInt)
  {
    AppMethodBeat.i(126815);
    if ((!bt.lQ(this.irM, paramString)) || (this.irP == 3))
    {
      AppMethodBeat.o(126815);
      return;
    }
    ad.i(this.TAG, "%s download finish [%d]", new Object[] { boQ(), Integer.valueOf(paramInt) });
    if (paramInt == 0) {
      this.irP = 3;
    }
    String str;
    if (this.irO != null)
    {
      paramString = this.irO;
      str = this.irN;
      if (this.irQ <= 0) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.aK(str, bool);
      eV(true);
      this.irZ = false;
      AppMethodBeat.o(126815);
      return;
    }
  }
  
  public void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(126792);
    super.c(paramBoolean, paramString, paramInt);
    aMr();
    AppMethodBeat.o(126792);
  }
  
  public boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(126803);
    paramBoolean = C((int)paramDouble, paramBoolean);
    AppMethodBeat.o(126803);
    return paramBoolean;
  }
  
  public h cL(Context paramContext)
  {
    AppMethodBeat.i(126800);
    this.ltm = 1;
    paramContext = new VideoPlayerTextureView(paramContext);
    paramContext.setNeedResetExtractor(true);
    AppMethodBeat.o(126800);
    return paramContext;
  }
  
  public void eU(boolean paramBoolean)
  {
    AppMethodBeat.i(126805);
    super.eU(paramBoolean);
    hideLoading();
    AppMethodBeat.o(126805);
  }
  
  public void eV(boolean paramBoolean)
  {
    AppMethodBeat.i(126816);
    ad.d(this.TAG, "%s start timer rightNow[%b]", new Object[] { boQ(), Boolean.valueOf(paramBoolean) });
    this.ise.stopTimer();
    this.ise.az(10L, 500L);
    AppMethodBeat.o(126816);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(126818);
    if (this.irP == 3)
    {
      i = getVideoDurationSec();
      AppMethodBeat.o(126818);
      return i;
    }
    int i = this.irW;
    AppMethodBeat.o(126818);
    return i;
  }
  
  public View getInnerVideoView()
  {
    if ((this.oHt instanceof VideoPlayerTextureView)) {
      return (View)this.oHt;
    }
    return null;
  }
  
  public String getMediaId()
  {
    return this.irM;
  }
  
  public int getReportIdkey()
  {
    return 100;
  }
  
  public void i(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(126814);
    if (!bt.lQ(this.irM, paramString))
    {
      AppMethodBeat.o(126814);
      return;
    }
    ad.d(this.TAG, "%s download  onProgress [%d, %d]", new Object[] { boQ(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(126814);
  }
  
  public void initView()
  {
    AppMethodBeat.i(126790);
    super.initView();
    this.TAG = "MicroMsg.MMVideoView";
    this.irR = aMt();
    this.isb = new MMVideoView.a();
    aMu();
    reset();
    AppMethodBeat.o(126790);
  }
  
  public void onCompletion()
  {
    AppMethodBeat.i(126798);
    if (this.isd)
    {
      C(0, true);
      super.dXu();
    }
    for (;;)
    {
      this.irR.release();
      AppMethodBeat.o(126798);
      return;
      super.onCompletion();
      if ((this.irM != null) && (this.irL != null)) {
        this.irL.gj(this.irM);
      }
      reset();
      if (this.oHt != null) {
        this.oHt.stop();
      }
    }
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(126813);
    this.irZ = false;
    if ((paramLong1 <= -1L) || (paramLong2 <= -1L))
    {
      ad.w(this.TAG, "%s deal data available error offset[%d], length[%d]", new Object[] { boQ(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      AppMethodBeat.o(126813);
      return;
    }
    if (!bt.lQ(this.irM, paramString))
    {
      AppMethodBeat.o(126813);
      return;
    }
    try
    {
      this.irW = this.irR.dy((int)paramLong1, (int)paramLong2);
      ad.i(this.TAG, "%s deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { boQ(), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(this.irW) });
      eV(true);
      AppMethodBeat.o(126813);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.e(this.TAG, "%s deal data available file pos to video time error[%s] ", new Object[] { boQ(), paramString.toString() });
      }
    }
  }
  
  public void onUIPause()
  {
    AppMethodBeat.i(126795);
    super.onUIPause();
    if (this.isc)
    {
      this.isa = true;
      stop();
    }
    AppMethodBeat.o(126795);
  }
  
  public void onUIResume()
  {
    AppMethodBeat.i(126796);
    super.onUIResume();
    ad.i(this.TAG, "%s onUIResume stopDownloadByUiPause[%b] currTimeOnUiPause[%d] isPlayOnUiPause[%b]", new Object[] { boQ(), Boolean.valueOf(this.isa), Integer.valueOf(this.ltk), Boolean.valueOf(this.ltl) });
    if (this.isa)
    {
      C(this.ltk, this.ltl);
      AppMethodBeat.o(126796);
      return;
    }
    if ((this.oHt != null) && (d.ly(24)) && ((this.oHt instanceof VideoPlayerTextureView)))
    {
      ((VideoPlayerTextureView)this.oHt).boO();
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
      this.irZ = false;
      this.irQ = 4;
    }
    AppMethodBeat.o(126809);
    return bool;
  }
  
  public boolean play()
  {
    AppMethodBeat.i(126810);
    boolean bool = super.play();
    if (bool) {
      this.irQ = 3;
    }
    AppMethodBeat.o(126810);
    return bool;
  }
  
  protected final boolean qi(int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    AppMethodBeat.i(126802);
    if (this.irT != -1) {}
    for (int i = this.irT;; i = paramInt)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(boQ()).append(" check timer playCurrPos ").append(paramInt).append(" playTime ").append(i).append(" cachePlayTime ").append(this.irW).append(" timeDuration ").append(this.irS).append(" playStatus ").append(this.irQ).append(" downloadStatus ").append(this.irP).append(" cdnMediaId ").append(this.irM).append(" isPrepareVideo[").append(this.irY).append("], isPrepared[").append(this.Zn).append("]");
      ad.i(this.TAG, ((StringBuilder)localObject).toString());
      switch (this.irP)
      {
      default: 
        ad.w(this.TAG, "%s check time default.", new Object[] { boQ() });
        bool1 = false;
      }
      for (;;)
      {
        AppMethodBeat.o(126802);
        return bool1;
        if (!qj(i))
        {
          this.irV = true;
          if (this.irW <= 0) {
            if (this.irT == -1)
            {
              this.irQ = 1;
              label268:
              bool1 = false;
            }
          }
        }
        for (;;)
        {
          tF(i);
          localObject = new PInt();
          PInt localPInt = new PInt();
          if (!a(i, (PInt)localObject, localPInt)) {
            break label743;
          }
          if (!n(((PInt)localObject).value, localPInt.value, false)) {
            break label764;
          }
          this.irW = Math.max(this.irW, localPInt.value);
          bool1 = bool2;
          break;
          this.irQ = 2;
          break label268;
          ad.i(this.TAG, "%s pause by load data cdnMediaId %s, playStatus %d", new Object[] { boQ(), this.irM, Integer.valueOf(this.irQ) });
          fbt();
          if ((this.irQ != 2) && (this.irQ != 4))
          {
            this.irX += this.isb.isg;
            this.irX = Math.min(this.irX, 60);
            fbv();
            this.irQ = 4;
          }
          aMw();
          break label268;
          if (this.irY)
          {
            tF(i);
            ad.i(this.TAG, "resumeByDataGain, playStatus:%s, isPlaying:%s, pauseByLoadData:%s", new Object[] { Integer.valueOf(this.irQ), Boolean.valueOf(this.oHt.isPlaying()), Boolean.valueOf(this.irV) });
            if (this.irV)
            {
              fbu();
              fbw();
              ad.i(this.TAG, "%s resume by data gain cdnMediaId %s", new Object[] { boQ(), this.irM });
              if (this.irT != -1)
              {
                C(this.irT, this.irU);
                this.irT = -1;
                bool1 = false;
                label588:
                this.irV = bool1;
                paramInt = 3;
              }
            }
            for (;;)
            {
              this.irQ = paramInt;
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
              } while ((this.irQ == 3) && (this.oHt.isPlaying()));
              ad.i(this.TAG, "%s start to play video playStatus[%d]", new Object[] { boQ(), Integer.valueOf(this.irQ) });
              if (play()) {
                paramInt = 3;
              } else {
                paramInt = this.irQ;
              }
            }
          }
          ad.i(this.TAG, "%s prepare cdnMediaId [%s]", new Object[] { boQ(), this.irM });
          if (this.irQ == 5) {
            this.irQ = 1;
          }
          aMv();
          bool1 = true;
        }
        label743:
        ad.d(this.TAG, "%s can not calc download.", new Object[] { boQ() });
        label764:
        continue;
        if (this.Zn)
        {
          if (this.irV)
          {
            if (this.irT == -1) {
              break label825;
            }
            C(this.irT, true);
            this.irT = -1;
          }
          for (;;)
          {
            this.irV = bool1;
            this.irQ = 3;
            tF(i);
            bool1 = bool2;
            break;
            label825:
            if (!play()) {
              bool1 = true;
            }
          }
        }
        if (this.irQ == 5) {
          this.irQ = 1;
        }
        aMv();
        bool1 = bool2;
        continue;
        ad.w(this.TAG, "%s download error.", new Object[] { boQ() });
        bool1 = false;
      }
    }
  }
  
  public boolean qj(int paramInt)
  {
    AppMethodBeat.i(126806);
    if (this.irP == 3)
    {
      AppMethodBeat.o(126806);
      return true;
    }
    if ((this.irW - paramInt <= 1) && (this.irW < this.irS))
    {
      AppMethodBeat.o(126806);
      return false;
    }
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.irR.a(paramInt, paramInt + 1, localPInt1, localPInt2)) {
        if (this.irL != null)
        {
          bool1 = this.irL.isVideoDataAvailable(this.irM, localPInt1.value, localPInt2.value);
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
          this.irW = paramInt;
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
        ad.e(this.TAG, "%s check video data error %s ", new Object[] { boQ(), localException1.toString() });
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
    this.irT = -1;
    this.irW = 0;
    this.irS = 0;
    this.irQ = 0;
    this.irP = 0;
    this.irV = false;
    this.irY = false;
    this.irZ = false;
    if (this.isb != null) {
      this.irX = this.isb.isg;
    }
  }
  
  protected void setDownloadStatus(int paramInt)
  {
    this.irP = paramInt;
  }
  
  protected void setFilepath(String paramString)
  {
    this.irN = paramString;
  }
  
  public void setIMMDownloadFinish(i.a parama)
  {
    this.irO = parama;
  }
  
  public void setIOnlineVideoProxy(b paramb)
  {
    AppMethodBeat.i(126791);
    this.irL = paramb;
    this.irL.a(this);
    AppMethodBeat.o(126791);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.isd = paramBoolean;
  }
  
  public void setRootPath(String paramString)
  {
    this.irF = paramString;
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(126801);
    if ((this.oHt instanceof VideoPlayerTextureView))
    {
      ((VideoPlayerTextureView)this.oHt).setScaleType(parame);
      qQ(getReportIdkey() + 14);
    }
    AppMethodBeat.o(126801);
  }
  
  public final void sp(long paramLong)
  {
    AppMethodBeat.i(218844);
    ad.i(this.TAG, "%s deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s", new Object[] { boQ(), Long.valueOf(paramLong), Integer.valueOf(this.irS), this.irM });
    if (this.irS != 0)
    {
      ad.w(this.TAG, "moov had callback, do nothing.");
      AppMethodBeat.o(218844);
      return;
    }
    fbs();
    try
    {
      if (this.irR == null)
      {
        ad.w(this.TAG, "%s parser is null, thread is error.", new Object[] { boQ() });
        AppMethodBeat.o(218844);
        return;
      }
      if (!this.irR.L(this.irN, paramLong)) {
        break label263;
      }
      this.irS = this.irR.aQP();
      ad.i(this.TAG, "%s mp4 parse moov success. duration %d cdnMediaId %s ", new Object[] { boQ(), Integer.valueOf(this.irS), this.irM });
      if (qi(0)) {
        aMv();
      }
      if (this.irT == -1)
      {
        this.irQ = 1;
        AppMethodBeat.o(218844);
        return;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(this.TAG, localException, "%s deal moov ready error [%s]", new Object[] { boQ(), this.irM });
      AppMethodBeat.o(218844);
      return;
    }
    this.irQ = 2;
    AppMethodBeat.o(218844);
    return;
    label263:
    ad.w(this.TAG, "%s mp4 parse moov error. cdnMediaId %s", new Object[] { boQ(), this.irM });
    if (this.irL != null) {
      this.irL.requestVideoData(this.irM, 0, -1);
    }
    AppMethodBeat.o(218844);
  }
  
  public void start()
  {
    AppMethodBeat.i(126797);
    ad.i(this.TAG, "%s start cdnMediaId[%s] timeDuration[%d]", new Object[] { boQ(), this.irM, Integer.valueOf(this.irS) });
    if (this.oHt != null)
    {
      if (!bt.isNullOrNil(this.oHt.getVideoPath())) {
        break label145;
      }
      showLoading();
      this.isc = true;
      this.irS = 0;
      this.irP = 1;
      if (this.irL != null)
      {
        this.irL.p(this.irM, this.irN, this.url);
        this.irL.a(this);
      }
      eaE();
    }
    for (;;)
    {
      qQ(getReportIdkey() + 1);
      AppMethodBeat.o(126797);
      return;
      label145:
      play();
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(126799);
    if (this.irL != null) {
      this.irL.gj(this.irM);
    }
    reset();
    super.stop();
    this.irR.release();
    AppMethodBeat.o(126799);
  }
  
  public void stopTimer()
  {
    AppMethodBeat.i(126817);
    this.ise.stopTimer();
    AppMethodBeat.o(126817);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.MMVideoView
 * JD-Core Version:    0.7.0.1
 */