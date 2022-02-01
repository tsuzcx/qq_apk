package com.tencent.mm.modelvideo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.a.j;
import com.tencent.mm.plugin.a.p;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.h.a;
import com.tencent.mm.pluginsdk.ui.h.e;
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
  protected p KCd;
  private String hxI;
  protected b hxO;
  protected String hxP;
  public String hxQ;
  private h.a hxR;
  protected int hxS;
  protected int hxT;
  protected int hxV;
  protected int hxW;
  private boolean hxX;
  protected boolean hxY;
  protected int hxZ;
  protected int hya;
  protected boolean hyb;
  private boolean hyc;
  private boolean hyd;
  protected a hye;
  protected boolean hyf;
  public boolean hyg;
  private av hyh;
  
  public MMVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(126787);
    this.hxS = 0;
    this.hxT = 0;
    this.hxZ = 0;
    this.hyb = false;
    this.hyc = false;
    this.hyd = false;
    this.hyf = false;
    this.hyh = new av(new av.a()
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
          bool1 = MMVideoView.this.oR(i);
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
    this.hxS = 0;
    this.hxT = 0;
    this.hxZ = 0;
    this.hyb = false;
    this.hyc = false;
    this.hyd = false;
    this.hyf = false;
    this.hyh = new av(new av.a()
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
          bool1 = MMVideoView.this.oR(i);
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
    this.hxS = 0;
    this.hxT = 0;
    this.hxZ = 0;
    this.hyb = false;
    this.hyc = false;
    this.hyd = false;
    this.hyf = false;
    this.hyh = new av(new av.a()
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
          bool1 = MMVideoView.this.oR(i);
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
  
  private void aCv()
  {
    AppMethodBeat.i(126808);
    ad.i(this.TAG, "%s pauseByDataBlock ", new Object[] { bel() });
    showLoading();
    pause();
    AppMethodBeat.o(126808);
  }
  
  private String getRootPath()
  {
    AppMethodBeat.i(126793);
    if (!bt.isNullOrNil(this.hxI))
    {
      str = this.hxI;
      AppMethodBeat.o(126793);
      return str;
    }
    String str = com.tencent.mm.loader.j.b.aih() + "video/";
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
      if ((this.KCd.a(paramInt1, paramInt2, localPInt1, localPInt2)) && (this.hxO != null))
      {
        bool = this.hxO.isVideoDataAvailable(this.hxP, localPInt1.value, localPInt2.value);
        if (bool) {
          break label258;
        }
        String str = this.hxP + "_" + localPInt1.value + "_" + localPInt2.value;
        if ((this.hyc) && (!paramBoolean)) {
          break label213;
        }
        this.hyc = true;
        if (this.hxO != null) {
          this.hxO.requestVideoData(this.hxP, localPInt1.value, localPInt2.value);
        }
        AppMethodBeat.o(126811);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e(this.TAG, "%s check video data error[%s] ", new Object[] { bel(), localException.toString() });
        boolean bool = false;
        continue;
        label213:
        ad.d(this.TAG, "%s already request video [%s] isRequestNow[%b] isSeek[%b] ", new Object[] { bel(), localException, Boolean.valueOf(this.hyc), Boolean.valueOf(paramBoolean) });
        continue;
        label258:
        ad.d(this.TAG, "%s already had video data.", new Object[] { bel() });
      }
    }
  }
  
  public final void Bl(long paramLong)
  {
    AppMethodBeat.i(202420);
    ad.i(this.TAG, "%s deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s", new Object[] { bel(), Long.valueOf(paramLong), Integer.valueOf(this.hxV), this.hxP });
    if (this.hxV != 0)
    {
      ad.w(this.TAG, "moov had callback, do nothing.");
      AppMethodBeat.o(202420);
      return;
    }
    exb();
    try
    {
      if (this.KCd == null)
      {
        ad.w(this.TAG, "%s parser is null, thread is error.", new Object[] { bel() });
        AppMethodBeat.o(202420);
        return;
      }
      if (!this.KCd.E(this.hxQ, paramLong)) {
        break label254;
      }
      this.hxV = this.KCd.aGR();
      ad.i(this.TAG, "%s mp4 parse moov success. duration %d cdnMediaId %s ", new Object[] { bel(), Integer.valueOf(this.hxV), this.hxP });
      if (oR(0)) {
        aCu();
      }
      if (this.hxW == -1)
      {
        this.hxT = 1;
        AppMethodBeat.o(202420);
        return;
      }
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace(this.TAG, localException, "%s deal moov ready error [%s]", new Object[] { bel(), this.hxP });
      AppMethodBeat.o(202420);
      return;
    }
    this.hxT = 2;
    AppMethodBeat.o(202420);
    return;
    label254:
    ad.w(this.TAG, "%s mp4 parse moov error. cdnMediaId %s", new Object[] { bel(), this.hxP });
    if (this.hxO != null) {
      this.hxO.requestVideoData(this.hxP, 0, -1);
    }
    AppMethodBeat.o(202420);
  }
  
  public boolean C(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(126804);
    switch (this.hxS)
    {
    }
    do
    {
      paramBoolean = true;
      for (;;)
      {
        ad.m(this.TAG, "%s seek video time %d, download status %d playStatus %d", new Object[] { bel(), Integer.valueOf(paramInt), Integer.valueOf(this.hxS), Integer.valueOf(this.hxT) });
        AppMethodBeat.o(126804);
        return paramBoolean;
        this.hxT = 2;
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        a(paramInt, localPInt1, localPInt2);
        if (n(localPInt1.value, localPInt2.value, true))
        {
          this.hxW = -1;
          this.hxY = false;
          this.hxZ = localPInt2.value;
          this.hxT = 3;
          super.c(paramInt, paramBoolean);
          paramBoolean = true;
        }
        else
        {
          this.hxW = paramInt;
          this.hxX = paramBoolean;
          this.hxY = true;
          aCv();
          paramBoolean = false;
          continue;
          super.c(paramInt, paramBoolean);
          paramBoolean = true;
          continue;
          paramBoolean = true;
        }
      }
    } while (ben());
    if (this.kvc)
    {
      this.kva = paramBoolean;
      this.hxX = paramBoolean;
      this.kvb = paramInt;
      this.hxW = paramInt;
    }
    for (;;)
    {
      start();
      break;
      this.kva = paramBoolean;
      if (paramInt > 0) {
        this.kvb = paramInt;
      } else {
        this.kvb = this.kuX;
      }
    }
  }
  
  protected boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(126807);
    paramPInt1.value = Math.max(paramInt, this.hxZ);
    if (this.hxT == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.hya;
    }
    if (this.hxT == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.hya + 8);
    }
    if ((this.hxT == 3) || (this.hxT == 4))
    {
      paramPInt1.value = this.hxZ;
      paramPInt2.value = (this.hya + paramInt + 1 + this.hye.hyk);
    }
    if (paramPInt2.value >= this.hxV + 1) {
      paramPInt2.value = (this.hxV + 1);
    }
    if (paramPInt2.value < paramPInt1.value)
    {
      paramPInt1.value += this.hye.hyk;
      AppMethodBeat.o(126807);
      return false;
    }
    ad.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { bel(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.hxT), Integer.valueOf(this.hxZ), Integer.valueOf(this.hya), this.hxP });
    AppMethodBeat.o(126807);
    return true;
  }
  
  protected void aCr()
  {
    AppMethodBeat.i(169101);
    if (!bt.isNullOrNil(this.url))
    {
      this.hxP = ("MMVideo_" + this.url.hashCode());
      this.hxQ = (getRootPath() + "MMVideo_" + this.url.hashCode() + ".mp4");
      i.aMF(i.aMQ(this.hxQ));
      ad.i(this.TAG, "%s set video path [%s %s]", new Object[] { bel(), this.hxP, this.hxQ });
    }
    AppMethodBeat.o(169101);
  }
  
  protected void aCt()
  {
    this.hye.hyj = 5;
    this.hye.hyk = 2;
  }
  
  protected void aCu()
  {
    AppMethodBeat.i(126794);
    ad.m(this.TAG, "%s prepareVideo", new Object[] { bel() });
    if (this.nAZ != null)
    {
      this.hyb = true;
      this.nAZ.setVideoPath(this.hxQ);
    }
    AppMethodBeat.o(126794);
  }
  
  public void aCw() {}
  
  public void am(String paramString, int paramInt)
  {
    AppMethodBeat.i(126815);
    if ((!bt.kU(this.hxP, paramString)) || (this.hxS == 3))
    {
      AppMethodBeat.o(126815);
      return;
    }
    ad.i(this.TAG, "%s download finish [%d]", new Object[] { bel(), Integer.valueOf(paramInt) });
    if (paramInt == 0) {
      this.hxS = 3;
    }
    String str;
    if (this.hxR != null)
    {
      paramString = this.hxR;
      str = this.hxQ;
      if (this.hxT <= 0) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.aH(str, bool);
      ez(true);
      this.hyc = false;
      AppMethodBeat.o(126815);
      return;
    }
  }
  
  public void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(126792);
    super.c(paramBoolean, paramString, paramInt);
    aCr();
    AppMethodBeat.o(126792);
  }
  
  public boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(126803);
    paramBoolean = C((int)paramDouble, paramBoolean);
    AppMethodBeat.o(126803);
    return paramBoolean;
  }
  
  public h cF(Context paramContext)
  {
    AppMethodBeat.i(126800);
    this.kuZ = 1;
    paramContext = new VideoPlayerTextureView(paramContext);
    paramContext.setNeedResetExtractor(true);
    AppMethodBeat.o(126800);
    return paramContext;
  }
  
  public void ey(boolean paramBoolean)
  {
    AppMethodBeat.i(126805);
    super.ey(paramBoolean);
    hideLoading();
    AppMethodBeat.o(126805);
  }
  
  public void ez(boolean paramBoolean)
  {
    AppMethodBeat.i(126816);
    ad.d(this.TAG, "%s start timer rightNow[%b]", new Object[] { bel(), Boolean.valueOf(paramBoolean) });
    this.hyh.stopTimer();
    this.hyh.av(10L, 500L);
    AppMethodBeat.o(126816);
  }
  
  protected p fQM()
  {
    AppMethodBeat.i(202419);
    j localj = new j();
    AppMethodBeat.o(202419);
    return localj;
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(126818);
    if (this.hxS == 3)
    {
      i = getVideoDurationSec();
      AppMethodBeat.o(126818);
      return i;
    }
    int i = this.hxZ;
    AppMethodBeat.o(126818);
    return i;
  }
  
  public View getInnerVideoView()
  {
    if ((this.nAZ instanceof VideoPlayerTextureView)) {
      return (View)this.nAZ;
    }
    return null;
  }
  
  public String getMediaId()
  {
    return this.hxP;
  }
  
  public int getReportIdkey()
  {
    return 100;
  }
  
  public void initView()
  {
    AppMethodBeat.i(126790);
    super.initView();
    this.TAG = "MicroMsg.MMVideoView";
    this.KCd = fQM();
    this.hye = new a();
    aCt();
    reset();
    AppMethodBeat.o(126790);
  }
  
  public void k(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(126814);
    if (!bt.kU(this.hxP, paramString))
    {
      AppMethodBeat.o(126814);
      return;
    }
    ad.d(this.TAG, "%s download  onProgress [%d, %d]", new Object[] { bel(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
    AppMethodBeat.o(126814);
  }
  
  protected final boolean oR(int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    AppMethodBeat.i(126802);
    if (this.hxW != -1) {}
    for (int i = this.hxW;; i = paramInt)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(bel()).append(" check timer playCurrPos ").append(paramInt).append(" playTime ").append(i).append(" cachePlayTime ").append(this.hxZ).append(" timeDuration ").append(this.hxV).append(" playStatus ").append(this.hxT).append(" downloadStatus ").append(this.hxS).append(" cdnMediaId ").append(this.hxP).append(" isPrepareVideo[").append(this.hyb).append("], isPrepared[").append(this.WD).append("]");
      ad.i(this.TAG, ((StringBuilder)localObject).toString());
      switch (this.hxS)
      {
      default: 
        ad.w(this.TAG, "%s check time default.", new Object[] { bel() });
        bool1 = false;
      }
      for (;;)
      {
        AppMethodBeat.o(126802);
        return bool1;
        if (!oS(i))
        {
          this.hxY = true;
          if (this.hxZ <= 0) {
            if (this.hxW == -1)
            {
              this.hxT = 1;
              label268:
              bool1 = false;
            }
          }
        }
        for (;;)
        {
          sm(i);
          localObject = new PInt();
          PInt localPInt = new PInt();
          if (!a(i, (PInt)localObject, localPInt)) {
            break label743;
          }
          if (!n(((PInt)localObject).value, localPInt.value, false)) {
            break label764;
          }
          this.hxZ = Math.max(this.hxZ, localPInt.value);
          bool1 = bool2;
          break;
          this.hxT = 2;
          break label268;
          ad.i(this.TAG, "%s pause by load data cdnMediaId %s, playStatus %d", new Object[] { bel(), this.hxP, Integer.valueOf(this.hxT) });
          exc();
          if ((this.hxT != 2) && (this.hxT != 4))
          {
            this.hya += this.hye.hyj;
            this.hya = Math.min(this.hya, 60);
            exe();
            this.hxT = 4;
          }
          aCv();
          break label268;
          if (this.hyb)
          {
            sm(i);
            ad.i(this.TAG, "resumeByDataGain, playStatus:%s, isPlaying:%s, pauseByLoadData:%s", new Object[] { Integer.valueOf(this.hxT), Boolean.valueOf(this.nAZ.isPlaying()), Boolean.valueOf(this.hxY) });
            if (this.hxY)
            {
              exd();
              exf();
              ad.i(this.TAG, "%s resume by data gain cdnMediaId %s", new Object[] { bel(), this.hxP });
              if (this.hxW != -1)
              {
                C(this.hxW, this.hxX);
                this.hxW = -1;
                bool1 = false;
                label588:
                this.hxY = bool1;
                paramInt = 3;
              }
            }
            for (;;)
            {
              this.hxT = paramInt;
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
              } while ((this.hxT == 3) && (this.nAZ.isPlaying()));
              ad.i(this.TAG, "%s start to play video playStatus[%d]", new Object[] { bel(), Integer.valueOf(this.hxT) });
              if (play()) {
                paramInt = 3;
              } else {
                paramInt = this.hxT;
              }
            }
          }
          ad.i(this.TAG, "%s prepare cdnMediaId [%s]", new Object[] { bel(), this.hxP });
          if (this.hxT == 5) {
            this.hxT = 1;
          }
          aCu();
          bool1 = true;
        }
        label743:
        ad.d(this.TAG, "%s can not calc download.", new Object[] { bel() });
        label764:
        continue;
        if (this.WD)
        {
          if (this.hxY)
          {
            if (this.hxW == -1) {
              break label825;
            }
            C(this.hxW, true);
            this.hxW = -1;
          }
          for (;;)
          {
            this.hxY = bool1;
            this.hxT = 3;
            sm(i);
            bool1 = bool2;
            break;
            label825:
            if (!play()) {
              bool1 = true;
            }
          }
        }
        if (this.hxT == 5) {
          this.hxT = 1;
        }
        aCu();
        bool1 = bool2;
        continue;
        ad.w(this.TAG, "%s download error.", new Object[] { bel() });
        bool1 = false;
      }
    }
  }
  
  public boolean oS(int paramInt)
  {
    AppMethodBeat.i(126806);
    if (this.hxS == 3)
    {
      AppMethodBeat.o(126806);
      return true;
    }
    if ((this.hxZ - paramInt <= 1) && (this.hxZ < this.hxV))
    {
      AppMethodBeat.o(126806);
      return false;
    }
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.KCd.a(paramInt, paramInt + 1, localPInt1, localPInt2)) {
        if (this.hxO != null)
        {
          bool1 = this.hxO.isVideoDataAvailable(this.hxP, localPInt1.value, localPInt2.value);
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
          this.hxZ = paramInt;
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
        ad.e(this.TAG, "%s check video data error %s ", new Object[] { bel(), localException1.toString() });
        boolean bool2 = bool1;
        continue;
        bool1 = false;
        continue;
        bool2 = false;
      }
    }
  }
  
  public void onCompletion()
  {
    AppMethodBeat.i(126798);
    if (this.hyg)
    {
      C(0, true);
      super.dwE();
    }
    for (;;)
    {
      this.KCd.release();
      AppMethodBeat.o(126798);
      return;
      super.onCompletion();
      if ((this.hxP != null) && (this.hxO != null)) {
        this.hxO.fy(this.hxP);
      }
      reset();
      if (this.nAZ != null) {
        this.nAZ.stop();
      }
    }
  }
  
  public final void onDataAvailable(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(126813);
    this.hyc = false;
    if ((paramLong1 <= -1L) || (paramLong2 <= -1L))
    {
      ad.w(this.TAG, "%s deal data available error offset[%d], length[%d]", new Object[] { bel(), Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
      AppMethodBeat.o(126813);
      return;
    }
    if (!bt.kU(this.hxP, paramString))
    {
      AppMethodBeat.o(126813);
      return;
    }
    try
    {
      this.hxZ = this.KCd.dw((int)paramLong1, (int)paramLong2);
      ad.i(this.TAG, "%s deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { bel(), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Integer.valueOf(this.hxZ) });
      ez(true);
      AppMethodBeat.o(126813);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ad.e(this.TAG, "%s deal data available file pos to video time error[%s] ", new Object[] { bel(), paramString.toString() });
      }
    }
  }
  
  public void onUIPause()
  {
    AppMethodBeat.i(126795);
    super.onUIPause();
    if (this.hyf)
    {
      this.hyd = true;
      stop();
    }
    AppMethodBeat.o(126795);
  }
  
  public void onUIResume()
  {
    AppMethodBeat.i(126796);
    super.onUIResume();
    ad.i(this.TAG, "%s onUIResume stopDownloadByUiPause[%b] currTimeOnUiPause[%d] isPlayOnUiPause[%b]", new Object[] { bel(), Boolean.valueOf(this.hyd), Integer.valueOf(this.kuX), Boolean.valueOf(this.kuY) });
    if (this.hyd)
    {
      C(this.kuX, this.kuY);
      AppMethodBeat.o(126796);
      return;
    }
    if ((this.nAZ != null) && (d.lf(24)) && ((this.nAZ instanceof VideoPlayerTextureView)))
    {
      ((VideoPlayerTextureView)this.nAZ).bej();
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
      this.hyc = false;
      this.hxT = 4;
    }
    AppMethodBeat.o(126809);
    return bool;
  }
  
  public boolean play()
  {
    AppMethodBeat.i(126810);
    boolean bool = super.play();
    if (bool) {
      this.hxT = 3;
    }
    AppMethodBeat.o(126810);
    return bool;
  }
  
  public void reset()
  {
    this.hxW = -1;
    this.hxZ = 0;
    this.hxV = 0;
    this.hxT = 0;
    this.hxS = 0;
    this.hxY = false;
    this.hyb = false;
    this.hyc = false;
    if (this.hye != null) {
      this.hya = this.hye.hyj;
    }
  }
  
  protected void setDownloadStatus(int paramInt)
  {
    this.hxS = paramInt;
  }
  
  protected void setFilepath(String paramString)
  {
    this.hxQ = paramString;
  }
  
  public void setIMMDownloadFinish(h.a parama)
  {
    this.hxR = parama;
  }
  
  public void setIOnlineVideoProxy(b paramb)
  {
    AppMethodBeat.i(126791);
    this.hxO = paramb;
    this.hxO.a(this);
    AppMethodBeat.o(126791);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.hyg = paramBoolean;
  }
  
  public void setRootPath(String paramString)
  {
    this.hxI = paramString;
  }
  
  public void setScaleType(h.e parame)
  {
    AppMethodBeat.i(126801);
    if ((this.nAZ instanceof VideoPlayerTextureView))
    {
      ((VideoPlayerTextureView)this.nAZ).setScaleType(parame);
      ln(getReportIdkey() + 14);
    }
    AppMethodBeat.o(126801);
  }
  
  public void start()
  {
    AppMethodBeat.i(126797);
    ad.i(this.TAG, "%s start cdnMediaId[%s] timeDuration[%d]", new Object[] { bel(), this.hxP, Integer.valueOf(this.hxV) });
    if (this.nAZ != null)
    {
      if (!bt.isNullOrNil(this.nAZ.getVideoPath())) {
        break label145;
      }
      showLoading();
      this.hyf = true;
      this.hxV = 0;
      this.hxS = 1;
      if (this.hxO != null)
      {
        this.hxO.q(this.hxP, this.hxQ, this.url);
        this.hxO.a(this);
      }
      dzT();
    }
    for (;;)
    {
      ln(getReportIdkey() + 1);
      AppMethodBeat.o(126797);
      return;
      label145:
      play();
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(126799);
    if (this.hxO != null) {
      this.hxO.fy(this.hxP);
    }
    reset();
    super.stop();
    this.KCd.release();
    AppMethodBeat.o(126799);
  }
  
  public void stopTimer()
  {
    AppMethodBeat.i(126817);
    this.hyh.stopTimer();
    AppMethodBeat.o(126817);
  }
  
  public static final class a
  {
    public int hyj;
    public int hyk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelvideo.MMVideoView
 * JD-Core Version:    0.7.0.1
 */