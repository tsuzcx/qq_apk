package com.tencent.mm.modelvideo;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.a.f;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.h.a;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;

public class MMVideoView
  extends CommonVideoView
  implements b.a
{
  private String fVd;
  protected b fVe;
  protected String fVf;
  public String fVg;
  private h.a fVh;
  protected int fVi;
  protected int fVj;
  protected f fVk;
  protected int fVl;
  protected int fVm;
  private boolean fVn;
  protected boolean fVo;
  protected int fVp;
  protected int fVq;
  protected boolean fVr;
  private boolean fVs;
  private boolean fVt;
  protected MMVideoView.a fVu;
  private boolean fVv;
  public boolean fVw;
  private ap fVx;
  
  public MMVideoView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(50630);
    this.fVi = 0;
    this.fVj = 0;
    this.fVp = 0;
    this.fVr = false;
    this.fVs = false;
    this.fVt = false;
    this.fVv = false;
    this.fVx = new ap(new MMVideoView.1(this), true);
    AppMethodBeat.o(50630);
  }
  
  public MMVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(50631);
    this.fVi = 0;
    this.fVj = 0;
    this.fVp = 0;
    this.fVr = false;
    this.fVs = false;
    this.fVt = false;
    this.fVv = false;
    this.fVx = new ap(new MMVideoView.1(this), true);
    AppMethodBeat.o(50631);
  }
  
  public MMVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(50632);
    this.fVi = 0;
    this.fVj = 0;
    this.fVp = 0;
    this.fVr = false;
    this.fVs = false;
    this.fVt = false;
    this.fVv = false;
    this.fVx = new ap(new MMVideoView.1(this), true);
    AppMethodBeat.o(50632);
  }
  
  private boolean C(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(50646);
    switch (this.fVi)
    {
    }
    do
    {
      paramBoolean = true;
      for (;;)
      {
        ab.b(this.TAG, "%s seek video time %d, download status %d playStatus %d", new Object[] { bas(), Integer.valueOf(paramInt), Integer.valueOf(this.fVi), Integer.valueOf(this.fVj) });
        AppMethodBeat.o(50646);
        return paramBoolean;
        this.fVj = 2;
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        a(paramInt, localPInt1, localPInt2);
        if (i(localPInt1.value, localPInt2.value, true))
        {
          this.fVm = -1;
          this.fVo = false;
          this.fVp = localPInt2.value;
          this.fVj = 3;
          super.d(paramInt, paramBoolean);
          paramBoolean = true;
        }
        else
        {
          this.fVm = paramInt;
          this.fVn = paramBoolean;
          this.fVo = true;
          alq();
          paramBoolean = false;
          continue;
          super.d(paramInt, paramBoolean);
          paramBoolean = true;
          continue;
          paramBoolean = true;
        }
      }
    } while (bUC());
    if (this.vPA)
    {
      this.vPy = paramBoolean;
      this.fVn = paramBoolean;
      this.vPz = paramInt;
      this.fVm = paramInt;
    }
    for (;;)
    {
      start();
      break;
      this.vPy = paramBoolean;
      if (paramInt > 0) {
        this.vPz = paramInt;
      } else {
        this.vPz = this.vPv;
      }
    }
  }
  
  private void alq()
  {
    AppMethodBeat.i(50650);
    ab.i(this.TAG, "%s pauseByDataBlock ", new Object[] { bas() });
    showLoading();
    pause();
    AppMethodBeat.o(50650);
  }
  
  private String getRootPath()
  {
    AppMethodBeat.i(50636);
    if (!bo.isNullOrNil(this.fVd))
    {
      str = this.fVd;
      AppMethodBeat.o(50636);
      return str;
    }
    String str = com.tencent.mm.compatible.util.e.eQz + "video/";
    AppMethodBeat.o(50636);
    return str;
  }
  
  private boolean i(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(50653);
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    try
    {
      if (this.fVk.a(paramInt1, paramInt2, localPInt1, localPInt2))
      {
        bool = this.fVe.isVideoDataAvailable(this.fVf, localPInt1.value, localPInt2.value);
        if (bool) {
          break label242;
        }
        String str = this.fVf + "_" + localPInt1.value + "_" + localPInt2.value;
        if ((this.fVs) && (!paramBoolean)) {
          break label197;
        }
        this.fVs = true;
        this.fVe.requestVideoData(this.fVf, localPInt1.value, localPInt2.value);
        AppMethodBeat.o(50653);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e(this.TAG, "%s check video data error[%s] ", new Object[] { bas(), localException.toString() });
        boolean bool = false;
        continue;
        label197:
        ab.d(this.TAG, "%s already request video [%s] isRequestNow[%b] isSeek[%b] ", new Object[] { bas(), localException, Boolean.valueOf(this.fVs), Boolean.valueOf(paramBoolean) });
        continue;
        label242:
        ab.d(this.TAG, "%s already had video data.", new Object[] { bas() });
      }
    }
  }
  
  public void Es()
  {
    AppMethodBeat.i(50641);
    if (this.fVw)
    {
      C(0, true);
      AppMethodBeat.o(50641);
      return;
    }
    if (this.fVf != null) {
      this.fVe.er(this.fVf);
    }
    reset();
    if (this.kvG != null) {
      this.kvG.stop();
    }
    super.Es();
    AppMethodBeat.o(50641);
  }
  
  protected boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    AppMethodBeat.i(50649);
    paramPInt1.value = Math.max(paramInt, this.fVp);
    if (this.fVj == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.fVq;
    }
    if (this.fVj == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.fVq + 8);
    }
    if ((this.fVj == 3) || (this.fVj == 4))
    {
      paramPInt1.value = this.fVp;
      paramPInt2.value = (this.fVq + paramInt + 1 + this.fVu.fVA);
    }
    if (paramPInt2.value >= this.fVl + 1) {
      paramPInt2.value = (this.fVl + 1);
    }
    if (paramPInt2.value < paramPInt1.value)
    {
      paramPInt1.value += this.fVu.fVA;
      AppMethodBeat.o(50649);
      return false;
    }
    ab.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { bas(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.fVj), Integer.valueOf(this.fVp), Integer.valueOf(this.fVq), this.fVf });
    AppMethodBeat.o(50649);
    return true;
  }
  
  public void ad(String paramString, int paramInt)
  {
    AppMethodBeat.i(50657);
    if ((!bo.isEqual(this.fVf, paramString)) || (this.fVi == 3))
    {
      AppMethodBeat.o(50657);
      return;
    }
    ab.i(this.TAG, "%s download finish [%d]", new Object[] { bas(), Integer.valueOf(paramInt) });
    if (paramInt == 0) {
      this.fVi = 3;
    }
    String str;
    if (this.fVh != null)
    {
      paramString = this.fVh;
      str = this.fVg;
      if (this.fVj <= 0) {
        break label122;
      }
    }
    label122:
    for (boolean bool = true;; bool = false)
    {
      paramString.an(str, bool);
      dh(true);
      this.fVs = false;
      AppMethodBeat.o(50657);
      return;
    }
  }
  
  protected void alm()
  {
    this.fVu.fVz = 5;
    this.fVu.fVA = 2;
  }
  
  protected void aln()
  {
    AppMethodBeat.i(50637);
    ab.b(this.TAG, "%s prepareVideo", new Object[] { bas() });
    if (this.kvG != null)
    {
      this.fVr = true;
      this.kvG.setVideoPath(this.fVg);
    }
    AppMethodBeat.o(50637);
  }
  
  public void alo()
  {
    AppMethodBeat.i(50638);
    super.alo();
    if (this.fVv)
    {
      this.fVt = true;
      stop();
    }
    AppMethodBeat.o(50638);
  }
  
  public void alp()
  {
    AppMethodBeat.i(50639);
    super.alp();
    ab.i(this.TAG, "%s onUIResume stopDownloadByUiPause[%b] currTimeOnUiPause[%d] isPlayOnUiPause[%b]", new Object[] { bas(), Boolean.valueOf(this.fVt), Integer.valueOf(this.vPv), Boolean.valueOf(this.vPw) });
    if (this.fVt)
    {
      C(this.vPv, this.vPw);
      AppMethodBeat.o(50639);
      return;
    }
    if ((this.kvG != null) && (d.fv(24)) && ((this.kvG instanceof VideoPlayerTextureView)))
    {
      ((VideoPlayerTextureView)this.kvG).bQB();
      AppMethodBeat.o(50639);
      return;
    }
    AppMethodBeat.o(50639);
  }
  
  public void alr() {}
  
  public void c(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(50635);
    super.c(paramBoolean, paramString, paramInt);
    if (!bo.isNullOrNil(paramString))
    {
      this.fVf = ("MMVideo_" + paramString.hashCode());
      this.fVg = (getRootPath() + "MMVideo_" + paramString.hashCode() + ".mp4");
      com.tencent.mm.vfs.e.um(com.tencent.mm.vfs.e.avK(this.fVg));
      ab.i(this.TAG, "%s set video path [%s %s]", new Object[] { bas(), this.fVf, this.fVg });
    }
    AppMethodBeat.o(50635);
  }
  
  public com.tencent.mm.pluginsdk.ui.tools.e ck(Context paramContext)
  {
    AppMethodBeat.i(50643);
    this.vPx = 1;
    paramContext = new VideoPlayerTextureView(paramContext);
    paramContext.setNeedResetExtractor(true);
    AppMethodBeat.o(50643);
    return paramContext;
  }
  
  public final boolean d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(139639);
    paramBoolean = C((int)paramDouble, paramBoolean);
    AppMethodBeat.o(139639);
    return paramBoolean;
  }
  
  public void dg(boolean paramBoolean)
  {
    AppMethodBeat.i(50647);
    super.dg(paramBoolean);
    hideLoading();
    AppMethodBeat.o(50647);
  }
  
  public void dh(boolean paramBoolean)
  {
    AppMethodBeat.i(50658);
    ab.d(this.TAG, "%s start timer rightNow[%b]", new Object[] { bas(), Boolean.valueOf(paramBoolean) });
    this.fVx.stopTimer();
    this.fVx.ag(10L, 500L);
    AppMethodBeat.o(50658);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(50660);
    if (this.fVi == 3)
    {
      i = getVideoDurationSec();
      AppMethodBeat.o(50660);
      return i;
    }
    int i = this.fVp;
    AppMethodBeat.o(50660);
    return i;
  }
  
  public String getMediaId()
  {
    return this.fVf;
  }
  
  public int getReportIdkey()
  {
    return 100;
  }
  
  public void initView()
  {
    AppMethodBeat.i(50633);
    super.initView();
    this.TAG = "MicroMsg.MMVideoView";
    this.fVk = new f();
    this.fVu = new MMVideoView.a();
    alm();
    reset();
    AppMethodBeat.o(50633);
  }
  
  public final void m(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50655);
    this.fVs = false;
    if ((paramInt1 < 0) || (paramInt2 < 0))
    {
      ab.w(this.TAG, "%s deal data available error offset[%d], length[%d]", new Object[] { bas(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(50655);
      return;
    }
    if (!bo.isEqual(this.fVf, paramString))
    {
      AppMethodBeat.o(50655);
      return;
    }
    try
    {
      this.fVp = this.fVk.cP(paramInt1, paramInt2);
      ab.i(this.TAG, "%s deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { bas(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.fVp) });
      dh(true);
      AppMethodBeat.o(50655);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.e(this.TAG, "%s deal data available file pos to video time error[%s] ", new Object[] { bas(), paramString.toString() });
      }
    }
  }
  
  public final void mi(int paramInt)
  {
    AppMethodBeat.i(50654);
    ab.i(this.TAG, "%s deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s", new Object[] { bas(), Integer.valueOf(paramInt), Integer.valueOf(this.fVl), this.fVf });
    if (this.fVl != 0)
    {
      ab.w(this.TAG, "moov had callback, do nothing.");
      AppMethodBeat.o(50654);
      return;
    }
    dmO();
    try
    {
      if (this.fVk == null)
      {
        ab.w(this.TAG, "%s parser is null, thread is error.", new Object[] { bas() });
        AppMethodBeat.o(50654);
        return;
      }
      if (!this.fVk.C(this.fVg, paramInt)) {
        break label260;
      }
      this.fVl = this.fVk.gmx;
      ab.i(this.TAG, "%s mp4 parse moov success. duration %d cdnMediaId %s ", new Object[] { bas(), Integer.valueOf(this.fVl), this.fVf });
      if (mj(0)) {
        aln();
      }
      if (this.fVm == -1)
      {
        this.fVj = 1;
        AppMethodBeat.o(50654);
        return;
      }
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace(this.TAG, localException, "%s deal moov ready error [%s]", new Object[] { bas(), this.fVf });
      AppMethodBeat.o(50654);
      return;
    }
    this.fVj = 2;
    AppMethodBeat.o(50654);
    return;
    label260:
    ab.w(this.TAG, "%s mp4 parse moov error. cdnMediaId %s", new Object[] { bas(), this.fVf });
    this.fVe.requestVideoData(this.fVf, 0, -1);
    AppMethodBeat.o(50654);
  }
  
  protected final boolean mj(int paramInt)
  {
    boolean bool1 = false;
    boolean bool2 = true;
    AppMethodBeat.i(50645);
    if (this.fVm != -1) {}
    for (int i = this.fVm;; i = paramInt)
    {
      ab.i(this.TAG, "%s check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d playStatus %d downloadStatus %d cdnMediaId %s isPrepareVideo[%b], isPrepared[%b]", new Object[] { bas(), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.fVp), Integer.valueOf(this.fVl), Integer.valueOf(this.fVj), Integer.valueOf(this.fVi), this.fVf, Boolean.valueOf(this.fVr), Boolean.valueOf(this.Pz) });
      switch (this.fVi)
      {
      default: 
        ab.w(this.TAG, "%s check time default.", new Object[] { bas() });
        bool1 = false;
      }
      for (;;)
      {
        AppMethodBeat.o(50645);
        return bool1;
        if (!mk(i))
        {
          this.fVo = true;
          if (this.fVp <= 0) {
            if (this.fVm == -1)
            {
              this.fVj = 1;
              label224:
              bool1 = false;
            }
          }
        }
        for (;;)
        {
          rl(i);
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          if (!a(i, localPInt1, localPInt2)) {
            break label699;
          }
          if (!i(localPInt1.value, localPInt2.value, false)) {
            break label720;
          }
          this.fVp = Math.max(this.fVp, localPInt2.value);
          bool1 = bool2;
          break;
          this.fVj = 2;
          break label224;
          ab.i(this.TAG, "%s pause by load data cdnMediaId %s, playStatus %d", new Object[] { bas(), this.fVf, Integer.valueOf(this.fVj) });
          dmP();
          if ((this.fVj != 2) && (this.fVj != 4))
          {
            this.fVq += this.fVu.fVz;
            this.fVq = Math.min(this.fVq, 60);
            dmR();
            this.fVj = 4;
          }
          alq();
          break label224;
          if (this.fVr)
          {
            rl(i);
            ab.i(this.TAG, "resumeByDataGain, playStatus:%s, isPlaying:%s, pauseByLoadData:%s", new Object[] { Integer.valueOf(this.fVj), Boolean.valueOf(this.kvG.isPlaying()), Boolean.valueOf(this.fVo) });
            if (this.fVo)
            {
              dmQ();
              dmS();
              ab.i(this.TAG, "%s resume by data gain cdnMediaId %s", new Object[] { bas(), this.fVf });
              if (this.fVm != -1)
              {
                C(this.fVm, this.fVn);
                this.fVm = -1;
                bool1 = false;
                label544:
                this.fVo = bool1;
                paramInt = 3;
              }
            }
            for (;;)
            {
              this.fVj = paramInt;
              do
              {
                bool1 = true;
                break;
                if (play())
                {
                  bool1 = false;
                  break label544;
                }
                bool1 = true;
                break label544;
              } while ((this.fVj == 3) && (this.kvG.isPlaying()));
              ab.i(this.TAG, "%s start to play video playStatus[%d]", new Object[] { bas(), Integer.valueOf(this.fVj) });
              if (play()) {
                paramInt = 3;
              } else {
                paramInt = this.fVj;
              }
            }
          }
          ab.i(this.TAG, "%s prepare cdnMediaId [%s]", new Object[] { bas(), this.fVf });
          if (this.fVj == 5) {
            this.fVj = 1;
          }
          aln();
          bool1 = true;
        }
        label699:
        ab.d(this.TAG, "%s can not calc download.", new Object[] { bas() });
        label720:
        continue;
        if (this.Pz)
        {
          if (this.fVo)
          {
            if (this.fVm == -1) {
              break label781;
            }
            C(this.fVm, true);
            this.fVm = -1;
          }
          for (;;)
          {
            this.fVo = bool1;
            this.fVj = 3;
            rl(i);
            bool1 = bool2;
            break;
            label781:
            if (!play()) {
              bool1 = true;
            }
          }
        }
        if (this.fVj == 5) {
          this.fVj = 1;
        }
        aln();
        bool1 = bool2;
        continue;
        ab.w(this.TAG, "%s download error.", new Object[] { bas() });
        bool1 = false;
      }
    }
  }
  
  /* Error */
  public boolean mk(int paramInt)
  {
    // Byte code:
    //   0: ldc_w 533
    //   3: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 50	com/tencent/mm/modelvideo/MMVideoView:fVi	I
    //   10: iconst_3
    //   11: if_icmpne +11 -> 22
    //   14: ldc_w 533
    //   17: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   20: iconst_1
    //   21: ireturn
    //   22: aload_0
    //   23: getfield 54	com/tencent/mm/modelvideo/MMVideoView:fVp	I
    //   26: iload_1
    //   27: isub
    //   28: iconst_1
    //   29: if_icmpgt +22 -> 51
    //   32: aload_0
    //   33: getfield 54	com/tencent/mm/modelvideo/MMVideoView:fVp	I
    //   36: aload_0
    //   37: getfield 300	com/tencent/mm/modelvideo/MMVideoView:fVl	I
    //   40: if_icmpge +11 -> 51
    //   43: ldc_w 533
    //   46: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   49: iconst_0
    //   50: ireturn
    //   51: new 114	com/tencent/mm/pointers/PInt
    //   54: dup
    //   55: invokespecial 117	com/tencent/mm/pointers/PInt:<init>	()V
    //   58: astore 4
    //   60: new 114	com/tencent/mm/pointers/PInt
    //   63: dup
    //   64: invokespecial 117	com/tencent/mm/pointers/PInt:<init>	()V
    //   67: astore 5
    //   69: aload_0
    //   70: getfield 224	com/tencent/mm/modelvideo/MMVideoView:fVk	Lcom/tencent/mm/plugin/a/f;
    //   73: iload_1
    //   74: iload_1
    //   75: iconst_1
    //   76: iadd
    //   77: aload 4
    //   79: aload 5
    //   81: invokevirtual 229	com/tencent/mm/plugin/a/f:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   84: ifeq +91 -> 175
    //   87: aload_0
    //   88: getfield 231	com/tencent/mm/modelvideo/MMVideoView:fVe	Lcom/tencent/mm/modelvideo/b;
    //   91: aload_0
    //   92: getfield 233	com/tencent/mm/modelvideo/MMVideoView:fVf	Ljava/lang/String;
    //   95: aload 4
    //   97: getfield 124	com/tencent/mm/pointers/PInt:value	I
    //   100: aload 5
    //   102: getfield 124	com/tencent/mm/pointers/PInt:value	I
    //   105: invokeinterface 239 4 0
    //   110: istore_2
    //   111: iload_2
    //   112: istore_3
    //   113: iload_2
    //   114: ifne +10 -> 124
    //   117: aload_0
    //   118: iload_1
    //   119: putfield 54	com/tencent/mm/modelvideo/MMVideoView:fVp	I
    //   122: iload_2
    //   123: istore_3
    //   124: ldc_w 533
    //   127: invokestatic 77	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   130: iload_3
    //   131: ireturn
    //   132: astore 4
    //   134: iconst_0
    //   135: istore_2
    //   136: aload_0
    //   137: getfield 92	com/tencent/mm/modelvideo/MMVideoView:TAG	Ljava/lang/String;
    //   140: ldc_w 535
    //   143: iconst_2
    //   144: anewarray 96	java/lang/Object
    //   147: dup
    //   148: iconst_0
    //   149: aload_0
    //   150: invokevirtual 100	com/tencent/mm/modelvideo/MMVideoView:bas	()Ljava/lang/String;
    //   153: aastore
    //   154: dup
    //   155: iconst_1
    //   156: aload 4
    //   158: invokevirtual 251	java/lang/Exception:toString	()Ljava/lang/String;
    //   161: aastore
    //   162: invokestatic 253	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   165: iload_2
    //   166: istore_3
    //   167: goto -43 -> 124
    //   170: astore 4
    //   172: goto -36 -> 136
    //   175: iconst_0
    //   176: istore_3
    //   177: goto -53 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	MMVideoView
    //   0	180	1	paramInt	int
    //   110	56	2	bool1	boolean
    //   112	65	3	bool2	boolean
    //   58	38	4	localPInt1	PInt
    //   132	25	4	localException1	Exception
    //   170	1	4	localException2	Exception
    //   67	34	5	localPInt2	PInt
    // Exception table:
    //   from	to	target	type
    //   69	111	132	java/lang/Exception
    //   117	122	170	java/lang/Exception
  }
  
  public void n(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(50656);
    if (!bo.isEqual(this.fVf, paramString))
    {
      AppMethodBeat.o(50656);
      return;
    }
    ab.d(this.TAG, "%s download  onProgress [%d, %d]", new Object[] { bas(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(50656);
  }
  
  public boolean pause()
  {
    AppMethodBeat.i(50651);
    boolean bool = super.pause();
    if (bool) {
      this.fVj = 4;
    }
    AppMethodBeat.o(50651);
    return bool;
  }
  
  public final boolean play()
  {
    AppMethodBeat.i(50652);
    boolean bool = super.play();
    if (bool) {
      this.fVj = 3;
    }
    AppMethodBeat.o(50652);
    return bool;
  }
  
  public void reset()
  {
    this.fVm = -1;
    this.fVp = 0;
    this.fVl = 0;
    this.fVj = 0;
    this.fVi = 0;
    this.fVo = false;
    this.fVr = false;
    this.fVs = false;
    if (this.fVu != null) {
      this.fVq = this.fVu.fVz;
    }
  }
  
  protected void setDownloadStatus(int paramInt)
  {
    this.fVi = paramInt;
  }
  
  protected void setFilepath(String paramString)
  {
    this.fVg = paramString;
  }
  
  public void setIMMDownloadFinish(h.a parama)
  {
    this.fVh = parama;
  }
  
  public void setIOnlineVideoProxy(b paramb)
  {
    AppMethodBeat.i(50634);
    this.fVe = paramb;
    this.fVe.a(this);
    AppMethodBeat.o(50634);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.fVw = paramBoolean;
  }
  
  public void setRootPath(String paramString)
  {
    this.fVd = paramString;
  }
  
  public void setScaleType(h.d paramd)
  {
    AppMethodBeat.i(50644);
    if ((this.kvG instanceof VideoPlayerTextureView))
    {
      ((VideoPlayerTextureView)this.kvG).setScaleType(paramd);
      hB(getReportIdkey() + 14);
    }
    AppMethodBeat.o(50644);
  }
  
  public void start()
  {
    AppMethodBeat.i(50640);
    ab.i(this.TAG, "%s start cdnMediaId[%s] timeDuration[%d]", new Object[] { bas(), this.fVf, Integer.valueOf(this.fVl) });
    if (this.kvG != null)
    {
      if (!bo.isNullOrNil(this.kvG.getVideoPath())) {
        break label145;
      }
      showLoading();
      this.fVv = true;
      this.fVl = 0;
      this.fVi = 1;
      if (this.fVe != null)
      {
        this.fVe.r(this.fVf, this.fVg, this.url);
        this.fVe.a(this);
      }
      cuk();
    }
    for (;;)
    {
      hB(getReportIdkey() + 1);
      AppMethodBeat.o(50640);
      return;
      label145:
      play();
    }
  }
  
  public void stop()
  {
    AppMethodBeat.i(50642);
    if (this.fVe != null) {
      this.fVe.er(this.fVf);
    }
    reset();
    super.stop();
    AppMethodBeat.o(50642);
  }
  
  public void stopTimer()
  {
    AppMethodBeat.i(50659);
    this.fVx.stopTimer();
    AppMethodBeat.o(50659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.MMVideoView
 * JD-Core Version:    0.7.0.1
 */