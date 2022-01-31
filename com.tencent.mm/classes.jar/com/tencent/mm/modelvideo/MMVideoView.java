package com.tencent.mm.modelvideo;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.h.a;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class MMVideoView
  extends CommonVideoView
  implements b.a
{
  private boolean eFA = false;
  private boolean eFB = false;
  private boolean eFC = false;
  public MMVideoView.a eFD;
  private boolean eFE = false;
  public boolean eFF;
  private am eFG = new am(new MMVideoView.1(this), true);
  private String eFm;
  public b eFn;
  public String eFo;
  public String eFp;
  private h.a eFq;
  public int eFr = 0;
  public int eFs = 0;
  public com.tencent.mm.plugin.a.f eFt;
  public int eFu;
  public int eFv;
  private boolean eFw;
  public boolean eFx;
  public int eFy = 0;
  public int eFz;
  
  public MMVideoView(Context paramContext)
  {
    super(paramContext);
  }
  
  public MMVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MMVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void Sd()
  {
    if (this.iuC != null)
    {
      this.eFA = true;
      this.iuC.setVideoPath(this.eFp);
    }
  }
  
  private void Sg()
  {
    y.i(this.TAG, "%s pauseByDataBlock ", new Object[] { ayL() });
    apT();
    pause();
  }
  
  private boolean f(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    boolean bool;
    try
    {
      if (this.eFt.a(paramInt1, paramInt2, localPInt1, localPInt2))
      {
        bool = this.eFn.isVideoDataAvailable(this.eFo, localPInt1.value, localPInt2.value);
        if (bool) {
          break label232;
        }
        String str = this.eFo + "_" + localPInt1.value + "_" + localPInt2.value;
        if ((this.eFB) && (!paramBoolean)) {
          break label187;
        }
        this.eFB = true;
        this.eFn.j(this.eFo, localPInt1.value, localPInt2.value);
        return bool;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e(this.TAG, "%s check video data error[%s] ", new Object[] { ayL(), localException.toString() });
        bool = false;
      }
      label187:
      y.d(this.TAG, "%s already request video [%s] isRequestNow[%b] isSeek[%b] ", new Object[] { ayL(), localException, Boolean.valueOf(this.eFB), Boolean.valueOf(paramBoolean) });
      return bool;
    }
    label232:
    y.d(this.TAG, "%s already had video data.", new Object[] { ayL() });
    return bool;
  }
  
  private String getRootPath()
  {
    if (!bk.bl(this.eFm)) {
      return this.eFm;
    }
    return com.tencent.mm.compatible.util.e.bkH + "appbrandvideo/";
  }
  
  private void reset()
  {
    this.eFv = -1;
    this.eFy = 0;
    this.eFu = 0;
    this.eFs = 0;
    this.eFr = 0;
    this.eFx = false;
    this.eFA = false;
    this.eFB = false;
    if (this.eFD != null) {
      this.eFz = this.eFD.eFI;
    }
  }
  
  public void Sc()
  {
    this.eFD.eFI = 5;
    this.eFD.eFJ = 2;
  }
  
  public void Se()
  {
    super.Se();
    if (this.eFE)
    {
      this.eFC = true;
      stop();
    }
  }
  
  public void Sf()
  {
    super.Sf();
    y.i(this.TAG, "%s onUIResume stopDownloadByUiPause[%b] currTimeOnUiPause[%d] isPlayOnUiPause[%b]", new Object[] { ayL(), Boolean.valueOf(this.eFC), Integer.valueOf(this.rYG), Boolean.valueOf(this.rYH) });
    if (this.eFC) {
      y(this.rYG, this.rYH);
    }
    while ((this.iuC == null) || (!d.gF(24)) || (!(this.iuC instanceof VideoPlayerTextureView))) {
      return;
    }
    ((VideoPlayerTextureView)this.iuC).biz();
  }
  
  public final void Sh() {}
  
  public void V(String paramString, int paramInt)
  {
    if ((!bk.isEqual(this.eFo, paramString)) || (this.eFr == 3)) {
      return;
    }
    y.i(this.TAG, "%s download finish [%d]", new Object[] { ayL(), Integer.valueOf(paramInt) });
    if (paramInt == 0) {
      this.eFr = 3;
    }
    String str;
    if (this.eFq != null)
    {
      paramString = this.eFq;
      str = this.eFp;
      if (this.eFs <= 0) {
        break label104;
      }
    }
    label104:
    for (boolean bool = true;; bool = false)
    {
      paramString.ai(str, bool);
      ce(true);
      this.eFB = false;
      return;
    }
  }
  
  public boolean a(int paramInt, PInt paramPInt1, PInt paramPInt2)
  {
    paramPInt1.value = Math.max(paramInt, this.eFy);
    if (this.eFs == 1)
    {
      paramPInt1.value = paramInt;
      paramPInt1.value += this.eFz;
    }
    if (this.eFs == 2)
    {
      paramPInt1.value = (paramInt - 8);
      if (paramPInt1.value < 0) {
        paramPInt1.value = 0;
      }
      paramPInt2.value = (paramPInt1.value + this.eFz + 8);
    }
    if ((this.eFs == 3) || (this.eFs == 4))
    {
      paramPInt1.value = this.eFy;
      paramPInt2.value = (this.eFz + paramInt + 1 + this.eFD.eFJ);
    }
    if (paramPInt2.value >= this.eFu + 1) {
      paramPInt2.value = (this.eFu + 1);
    }
    if (paramPInt2.value < paramPInt1.value)
    {
      paramPInt1.value += this.eFD.eFJ;
      return false;
    }
    y.i(this.TAG, "%s calcDownloadRange range[%d, %d] playTime[%d] playStatus[%d] cache[%d, %d] [%s]", new Object[] { ayL(), Integer.valueOf(paramPInt1.value), Integer.valueOf(paramPInt2.value), Integer.valueOf(paramInt), Integer.valueOf(this.eFs), Integer.valueOf(this.eFy), Integer.valueOf(this.eFz), this.eFo });
    return true;
  }
  
  public com.tencent.mm.pluginsdk.ui.tools.f bF(Context paramContext)
  {
    this.rYI = 1;
    paramContext = new VideoPlayerTextureView(paramContext);
    paramContext.setNeedResetExtractor(true);
    return paramContext;
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    super.c(paramBoolean, paramString, paramInt);
    if (!bk.bl(paramString))
    {
      this.eFo = ("MMVideo_" + paramString.hashCode());
      this.eFp = (getRootPath() + "MMVideo_" + paramString.hashCode() + ".mp4");
      com.tencent.mm.vfs.e.nb(com.tencent.mm.vfs.e.aeS(this.eFp));
      y.i(this.TAG, "%s set video path [%s %s]", new Object[] { ayL(), this.eFo, this.eFp });
    }
  }
  
  public final void cd(boolean paramBoolean)
  {
    super.cd(paramBoolean);
    bdC();
  }
  
  protected final void ce(boolean paramBoolean)
  {
    y.d(this.TAG, "%s start timer rightNow[%b]", new Object[] { ayL(), Boolean.valueOf(paramBoolean) });
    this.eFG.stopTimer();
    this.eFG.S(500L, 500L);
  }
  
  public void e(String paramString, int paramInt1, int paramInt2)
  {
    if (!bk.isEqual(this.eFo, paramString)) {
      return;
    }
    y.d(this.TAG, "%s download  onProgress [%d, %d]", new Object[] { ayL(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
  }
  
  public int getCacheTimeSec()
  {
    if (this.eFr == 3) {
      return getVideoDurationSec();
    }
    return this.eFy;
  }
  
  public String getMediaId()
  {
    return this.eFo;
  }
  
  public int getReportIdkey()
  {
    return 100;
  }
  
  public void initView()
  {
    super.initView();
    this.TAG = "MicroMsg.MMVideoView";
    this.eFt = new com.tencent.mm.plugin.a.f();
    this.eFD = new MMVideoView.a();
    Sc();
    reset();
  }
  
  public final void jq(int paramInt)
  {
    y.i(this.TAG, "%s deal moov ready moovPos %d, timeDuration %d, cdnMediaId %s", new Object[] { ayL(), Integer.valueOf(paramInt), Integer.valueOf(this.eFu), this.eFo });
    if (this.eFu != 0)
    {
      y.w(this.TAG, "moov had callback, do nothing.");
      return;
    }
    clY();
    try
    {
      if (this.eFt == null)
      {
        y.w(this.TAG, "%s parser is null, thread is error.", new Object[] { ayL() });
        return;
      }
    }
    catch (Exception localException)
    {
      y.printErrStackTrace(this.TAG, localException, "%s deal moov ready error [%s]", new Object[] { ayL(), this.eFo });
      return;
    }
    if (this.eFt.t(this.eFp, paramInt))
    {
      this.eFu = this.eFt.eUz;
      y.i(this.TAG, "%s mp4 parse moov success. duration %d cdnMediaId %s ", new Object[] { ayL(), Integer.valueOf(this.eFu), this.eFo });
      if (jr(0)) {
        Sd();
      }
      if (this.eFv == -1)
      {
        this.eFs = 1;
        return;
      }
      this.eFs = 2;
      return;
    }
    y.w(this.TAG, "%s mp4 parse moov error. cdnMediaId %s", new Object[] { ayL(), this.eFo });
    this.eFn.j(this.eFo, 0, -1);
  }
  
  public final boolean jr(int paramInt)
  {
    boolean bool = false;
    if (this.eFv != -1) {}
    for (int i = this.eFv;; i = paramInt)
    {
      y.i(this.TAG, "%s check timer playCurrPos %d playTime %d cachePlayTime %d timeDuration %d playStatus %d downloadStatus %d cdnMediaId %s isPrepareVideo[%b]", new Object[] { ayL(), Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.eFy), Integer.valueOf(this.eFu), Integer.valueOf(this.eFs), Integer.valueOf(this.eFr), this.eFo, Boolean.valueOf(this.eFA) });
      switch (this.eFr)
      {
      default: 
        y.w(this.TAG, "%s check time default.", new Object[] { ayL() });
        return false;
      case 1: 
        if (!js(i))
        {
          this.eFx = true;
          if (this.eFy <= 0) {
            if (this.eFv == -1)
            {
              this.eFs = 1;
              bool = false;
            }
          }
        }
        for (;;)
        {
          nD(i);
          PInt localPInt1 = new PInt();
          PInt localPInt2 = new PInt();
          if (!a(i, localPInt1, localPInt2)) {
            break label606;
          }
          if (!f(localPInt1.value, localPInt2.value, false)) {
            break label627;
          }
          this.eFy = Math.max(this.eFy, localPInt2.value);
          return true;
          this.eFs = 2;
          break;
          y.i(this.TAG, "%s pause by load data cdnMediaId %s, playStatus %d", new Object[] { ayL(), this.eFo, Integer.valueOf(this.eFs) });
          clZ();
          if ((this.eFs != 2) && (this.eFs != 4))
          {
            this.eFz += this.eFD.eFI;
            this.eFz = Math.min(this.eFz, 60);
            cmb();
            this.eFs = 4;
          }
          Sg();
          break;
          if (this.eFA)
          {
            nD(i);
            if (this.eFx)
            {
              cma();
              cmc();
              y.i(this.TAG, "%s resume by data gain cdnMediaId %s", new Object[] { ayL(), this.eFo });
              if (this.eFv != -1)
              {
                y(this.eFv, this.eFw);
                this.eFv = -1;
                bool = false;
                this.eFx = bool;
                paramInt = 3;
              }
            }
            for (;;)
            {
              this.eFs = paramInt;
              do
              {
                bool = true;
                break;
                if (play())
                {
                  bool = false;
                  break label463;
                }
                bool = true;
                break label463;
              } while (this.eFs == 3);
              y.i(this.TAG, "%s start to play video playStatus[%d]", new Object[] { ayL(), Integer.valueOf(this.eFs) });
              if (play()) {
                paramInt = 3;
              } else {
                paramInt = this.eFs;
              }
            }
          }
          y.i(this.TAG, "%s prepare cdnMediaId [%s]", new Object[] { ayL(), this.eFo });
          if (this.eFs == 5) {
            this.eFs = 1;
          }
          Sd();
          bool = true;
        }
        y.d(this.TAG, "%s can not calc download.", new Object[] { ayL() });
        return bool;
      case 3: 
        label463:
        label606:
        label627:
        if (this.eFA)
        {
          if (this.eFx)
          {
            if (this.eFv == -1) {
              break label683;
            }
            y(this.eFv, true);
            this.eFv = -1;
          }
          for (;;)
          {
            this.eFx = bool;
            this.eFs = 3;
            nD(i);
            return true;
            if (!play()) {
              bool = true;
            }
          }
        }
        label683:
        if (this.eFs == 5) {
          this.eFs = 1;
        }
        Sd();
        return true;
      }
      y.w(this.TAG, "%s download error.", new Object[] { ayL() });
      return false;
    }
  }
  
  /* Error */
  public boolean js(int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: getfield 43	com/tencent/mm/modelvideo/MMVideoView:eFr	I
    //   6: iconst_3
    //   7: if_icmpne +7 -> 14
    //   10: iconst_1
    //   11: istore_2
    //   12: iload_2
    //   13: ireturn
    //   14: aload_0
    //   15: getfield 47	com/tencent/mm/modelvideo/MMVideoView:eFy	I
    //   18: iload_1
    //   19: isub
    //   20: iconst_1
    //   21: if_icmpgt +14 -> 35
    //   24: aload_0
    //   25: getfield 47	com/tencent/mm/modelvideo/MMVideoView:eFy	I
    //   28: aload_0
    //   29: getfield 214	com/tencent/mm/modelvideo/MMVideoView:eFu	I
    //   32: if_icmplt -20 -> 12
    //   35: new 134	com/tencent/mm/pointers/PInt
    //   38: dup
    //   39: invokespecial 136	com/tencent/mm/pointers/PInt:<init>	()V
    //   42: astore 4
    //   44: new 134	com/tencent/mm/pointers/PInt
    //   47: dup
    //   48: invokespecial 136	com/tencent/mm/pointers/PInt:<init>	()V
    //   51: astore 5
    //   53: aload_0
    //   54: getfield 138	com/tencent/mm/modelvideo/MMVideoView:eFt	Lcom/tencent/mm/plugin/a/f;
    //   57: iload_1
    //   58: iload_1
    //   59: iconst_1
    //   60: iadd
    //   61: aload 4
    //   63: aload 5
    //   65: invokevirtual 143	com/tencent/mm/plugin/a/f:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   68: ifeq +85 -> 153
    //   71: aload_0
    //   72: getfield 145	com/tencent/mm/modelvideo/MMVideoView:eFn	Lcom/tencent/mm/modelvideo/b;
    //   75: aload_0
    //   76: getfield 147	com/tencent/mm/modelvideo/MMVideoView:eFo	Ljava/lang/String;
    //   79: aload 4
    //   81: getfield 150	com/tencent/mm/pointers/PInt:value	I
    //   84: aload 5
    //   86: getfield 150	com/tencent/mm/pointers/PInt:value	I
    //   89: invokeinterface 156 4 0
    //   94: istore_2
    //   95: iload_2
    //   96: istore_3
    //   97: iload_2
    //   98: ifne +10 -> 108
    //   101: aload_0
    //   102: iload_1
    //   103: putfield 47	com/tencent/mm/modelvideo/MMVideoView:eFy	I
    //   106: iload_2
    //   107: istore_3
    //   108: iload_3
    //   109: ireturn
    //   110: astore 4
    //   112: iconst_0
    //   113: istore_2
    //   114: aload_0
    //   115: getfield 92	com/tencent/mm/modelvideo/MMVideoView:TAG	Ljava/lang/String;
    //   118: ldc_w 449
    //   121: iconst_2
    //   122: anewarray 96	java/lang/Object
    //   125: dup
    //   126: iconst_0
    //   127: aload_0
    //   128: invokevirtual 100	com/tencent/mm/modelvideo/MMVideoView:ayL	()Ljava/lang/String;
    //   131: aastore
    //   132: dup
    //   133: iconst_1
    //   134: aload 4
    //   136: invokevirtual 178	java/lang/Exception:toString	()Ljava/lang/String;
    //   139: aastore
    //   140: invokestatic 180	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   143: iload_2
    //   144: istore_3
    //   145: goto -37 -> 108
    //   148: astore 4
    //   150: goto -36 -> 114
    //   153: iconst_0
    //   154: istore_3
    //   155: goto -47 -> 108
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	this	MMVideoView
    //   0	158	1	paramInt	int
    //   1	143	2	bool1	boolean
    //   96	59	3	bool2	boolean
    //   42	38	4	localPInt1	PInt
    //   110	25	4	localException1	Exception
    //   148	1	4	localException2	Exception
    //   51	34	5	localPInt2	PInt
    // Exception table:
    //   from	to	target	type
    //   53	95	110	java/lang/Exception
    //   101	106	148	java/lang/Exception
  }
  
  public final void onDataAvailable(String paramString, int paramInt1, int paramInt2)
  {
    this.eFB = false;
    if ((paramInt1 < 0) || (paramInt2 < 0)) {
      y.w(this.TAG, "%s deal data available error offset[%d], length[%d]", new Object[] { ayL(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    }
    while (!bk.isEqual(this.eFo, paramString)) {
      return;
    }
    try
    {
      this.eFy = this.eFt.bE(paramInt1, paramInt2);
      y.i(this.TAG, "%s deal data available. offset[%d] length[%d] cachePlayTime[%d]", new Object[] { ayL(), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(this.eFy) });
      ce(true);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        y.e(this.TAG, "%s deal data available file pos to video time error[%s] ", new Object[] { ayL(), paramString.toString() });
      }
    }
  }
  
  public final boolean pause()
  {
    boolean bool = super.pause();
    if (bool) {
      this.eFs = 4;
    }
    return bool;
  }
  
  public final boolean play()
  {
    boolean bool = super.play();
    if (bool) {
      this.eFs = 3;
    }
    return bool;
  }
  
  protected void setDownloadStatus(int paramInt)
  {
    this.eFr = paramInt;
  }
  
  protected void setFilepath(String paramString)
  {
    this.eFp = paramString;
  }
  
  public void setIMMDownloadFinish(h.a parama)
  {
    this.eFq = parama;
  }
  
  public void setIOnlineVideoProxy(b paramb)
  {
    this.eFn = paramb;
    this.eFn.a(this);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    this.eFF = paramBoolean;
  }
  
  public void setRootPath(String paramString)
  {
    this.eFm = paramString;
  }
  
  public void setScaleType(h.d paramd)
  {
    if ((this.iuC instanceof VideoPlayerTextureView))
    {
      ((VideoPlayerTextureView)this.iuC).setScaleType(paramd);
      cB(getReportIdkey() + 14);
    }
  }
  
  public void start()
  {
    y.i(this.TAG, "%s start cdnMediaId[%s] timeDuration[%d]", new Object[] { ayL(), this.eFo, Integer.valueOf(this.eFu) });
    if (this.iuC != null)
    {
      if (!bk.bl(this.iuC.getVideoPath())) {
        break label126;
      }
      apT();
      this.eFE = true;
      this.eFu = 0;
      this.eFr = 1;
      this.eFn.p(this.eFo, this.eFp, this.url);
      this.eFn.a(this);
      bHW();
    }
    for (;;)
    {
      cB(getReportIdkey() + 1);
      return;
      label126:
      play();
    }
  }
  
  public void stop()
  {
    this.eFn.nF(this.eFo);
    reset();
    super.stop();
  }
  
  public final void stopTimer()
  {
    this.eFG.stopTimer();
  }
  
  public final void ug()
  {
    if (this.eFF)
    {
      y(0, true);
      return;
    }
    this.eFn.nF(this.eFo);
    reset();
    if (this.iuC != null) {
      this.iuC.stop();
    }
    super.ug();
  }
  
  public boolean y(int paramInt, boolean paramBoolean)
  {
    switch (this.eFr)
    {
    }
    do
    {
      paramBoolean = true;
      for (;;)
      {
        y.l(this.TAG, "%s seek video time %d, download status %d playStatus %d", new Object[] { ayL(), Integer.valueOf(paramInt), Integer.valueOf(this.eFr), Integer.valueOf(this.eFs) });
        return paramBoolean;
        this.eFs = 2;
        PInt localPInt1 = new PInt();
        PInt localPInt2 = new PInt();
        a(paramInt, localPInt1, localPInt2);
        if (f(localPInt1.value, localPInt2.value, true))
        {
          this.eFv = -1;
          this.eFx = false;
          this.eFy = localPInt2.value;
          this.eFs = 3;
          super.y(paramInt, paramBoolean);
          paramBoolean = true;
        }
        else
        {
          this.eFv = paramInt;
          this.eFw = paramBoolean;
          this.eFx = true;
          Sg();
          paramBoolean = false;
          continue;
          super.y(paramInt, paramBoolean);
          paramBoolean = true;
          continue;
          paramBoolean = true;
        }
      }
    } while (isPrepared());
    if (this.rYL)
    {
      this.rYJ = paramBoolean;
      this.eFw = paramBoolean;
      this.rYK = paramInt;
      this.eFv = paramInt;
    }
    for (;;)
    {
      start();
      break;
      this.rYJ = paramBoolean;
      if (paramInt > 0) {
        this.rYK = paramInt;
      } else {
        this.rYK = this.rYG;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelvideo.MMVideoView
 * JD-Core Version:    0.7.0.1
 */