package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.n.e;
import com.tencent.mm.plugin.appbrand.jsapi.n.f;
import com.tencent.mm.plugin.appbrand.jsapi.n.g;
import com.tencent.mm.plugin.appbrand.jsapi.n.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.n.i;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView.a;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
{
  public final aa caw;
  public final String cgL;
  final AppBrandPipContainerView jdU;
  final View lMC;
  public final g lMD;
  final i lME;
  final x lMF;
  public volatile boolean lMG;
  volatile boolean lMH;
  a lMI;
  int lMJ;
  int lMK;
  int lML;
  int lMM;
  int lMN;
  int lMO;
  int lMP;
  int lMQ;
  int lMR;
  int lMS;
  int lMT;
  int lMU;
  int lMV;
  int lMW;
  int lMX;
  int lMY;
  int lMZ;
  int lNa;
  private int lNb;
  private int lNc;
  private int lNd;
  int lNe;
  int lNf;
  int lNg;
  private int lNh;
  private int lNi;
  private int lNj;
  private int lNk;
  private int lNl;
  private int lNm;
  private int lNn;
  private int lNo;
  private int lNp;
  private int lNq;
  private int lNr;
  private int lNs;
  int mScreenHeight;
  int mScreenWidth;
  
  b(aa paramaa, AppBrandPipContainerView paramAppBrandPipContainerView, View paramView, g paramg, i parami, x paramx)
  {
    AppMethodBeat.i(193441);
    this.cgL = ("MicroMsg.AppBrand.AppBrandPipContainerOnPageSwitchHandler#" + hashCode());
    this.lMG = false;
    this.lMH = false;
    this.lMI = null;
    this.lNb = AppBrandPipContainerView.mrx;
    this.lNc = AppBrandPipContainerView.mrw;
    this.lNd = AppBrandPipContainerView.mry;
    this.lNe = AppBrandPipContainerView.mrz;
    this.lNf = AppBrandPipContainerView.mrA;
    this.lNg = AppBrandPipContainerView.mrB;
    this.caw = paramaa;
    this.jdU = paramAppBrandPipContainerView;
    this.lMC = paramView;
    this.lMD = paramg;
    this.lME = parami;
    this.lMF = paramx;
    AppMethodBeat.o(193441);
  }
  
  final void a(float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    AppMethodBeat.i(193446);
    paramInt7 = (int)(paramFloat / 100.0F * paramInt7);
    paramInt8 = (int)(paramFloat / 100.0F * paramInt8);
    paramInt9 = (int)(paramFloat / 100.0F * paramInt9);
    int i = paramInt7 * 2 + paramInt5;
    int j = paramInt6 + paramInt8 + paramInt9;
    paramInt1 = (paramInt1 - i) / 2;
    paramInt2 = (paramInt2 - j) / 2;
    paramInt10 = (int)(paramFloat / 100.0F * paramInt10);
    paramInt11 = (int)(paramFloat / 100.0F * paramInt11);
    paramInt12 = (int)(paramFloat / 100.0F * paramInt12);
    ViewGroup.LayoutParams localLayoutParams = this.jdU.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = j;
    this.jdU.setLayoutParams(localLayoutParams);
    this.jdU.setX(paramInt3 + paramInt1);
    this.jdU.setY(paramInt4 + paramInt2);
    localLayoutParams = this.lMC.getLayoutParams();
    localLayoutParams.width = paramInt5;
    localLayoutParams.height = paramInt6;
    this.lMC.setLayoutParams(localLayoutParams);
    this.jdU.b(paramInt5, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12);
    AppMethodBeat.o(193446);
  }
  
  final void aE(float paramFloat)
  {
    AppMethodBeat.i(193442);
    if (!this.lMG)
    {
      ac.w(this.cgL, "handleVideoTransferProgress, false == mHandleStarted");
      AppMethodBeat.o(193442);
      return;
    }
    this.lNh = (this.lMJ + (int)(paramFloat / 100.0F * (this.lMV - this.lMJ)));
    this.lNi = (this.lMK + (int)(paramFloat / 100.0F * (this.lMW - this.lMK)));
    this.lNj = (this.lML + (int)(paramFloat / 100.0F * (this.lMX - this.lML)));
    this.lNk = (this.lMM + (int)(paramFloat / 100.0F * (this.lMY - this.lMM)));
    this.lNl = (this.lMN + (int)(paramFloat / 100.0F * (this.lMZ - this.lMN)));
    this.lNm = (this.lMO + (int)(paramFloat / 100.0F * (this.lNa - this.lMO)));
    this.lNn = ((int)Math.ceil(0.5F * (this.lNh - this.lNl)));
    this.lNo = ((int)Math.ceil(0.4F * (this.lNi - this.lNm)));
    this.lNp = ((int)Math.ceil(0.6F * (this.lNi - this.lNm)));
    this.lNq = (this.lMS + (int)(paramFloat / 100.0F * (this.lNe - this.lMS)));
    this.lNr = (this.lMT + (int)(paramFloat / 100.0F * (this.lNf - this.lMT)));
    this.lNs = (this.lMU + (int)(paramFloat / 100.0F * (this.lNg - this.lMU)));
    a(paramFloat, this.lNh, this.lNi, this.lNj, this.lNk, this.lNl, this.lNm, this.lNn, this.lNo, this.lNp, this.lNq, this.lNr, this.lNs);
    AppMethodBeat.o(193442);
  }
  
  final void bsy()
  {
    AppMethodBeat.i(193443);
    ac.i(this.cgL, "handleVideoPage2PipEnd");
    if (!this.lMG) {
      hn(false);
    }
    a(100.0F, this.lMV, this.lMW, this.lMX, this.lMY, this.lMZ, this.lNa, this.lNb, this.lNc, this.lNd, this.lNe, this.lNf, this.lNg);
    AppMethodBeat.o(193443);
  }
  
  final Point bsz()
  {
    AppMethodBeat.i(193445);
    Object localObject = this.caw.lyE;
    if (localObject == null)
    {
      ac.w(this.cgL, "calculateWebView2PipContainerParentOffset, null == appBrandWebView");
      AppMethodBeat.o(193445);
      return null;
    }
    localObject = ((ay)localObject).getContentView();
    if (localObject == null)
    {
      ac.w(this.cgL, "calculateWebView2PipContainerParentOffset, null == webView");
      AppMethodBeat.o(193445);
      return null;
    }
    ViewParent localViewParent = this.jdU.getParent();
    if (!(localViewParent instanceof ViewGroup))
    {
      ac.w(this.cgL, "calculateWebView2PipContainerParentOffset, viewParent is not ViewGroup");
      AppMethodBeat.o(193445);
      return null;
    }
    ViewGroup localViewGroup = (ViewGroup)localViewParent;
    this.mScreenWidth = localViewGroup.getWidth();
    this.mScreenHeight = localViewGroup.getHeight();
    ac.d(this.cgL, "calculateWebView2PipContainerParentOffset, mScreenWidth: %d, mScreenHeight: %d", new Object[] { Integer.valueOf(this.mScreenWidth), Integer.valueOf(this.mScreenHeight) });
    localViewParent = ((View)localObject).getParent();
    int i = 0;
    int j = 0;
    while (localViewParent != null)
    {
      if (!(localViewParent instanceof ViewGroup))
      {
        ac.w(this.cgL, "calculateWebView2PipContainerParentOffset, parent is not ViewGroup");
        AppMethodBeat.o(193445);
        return null;
      }
      j = (int)(j + ((View)localObject).getX());
      float f = i;
      i = (int)(((View)localObject).getY() + f);
      if (localViewParent == localViewGroup)
      {
        ac.d(this.cgL, "calculateWebView2PipContainerParentOffset, offsetX: %d, offsetY: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        localObject = new Point(j, i);
        AppMethodBeat.o(193445);
        return localObject;
      }
      localObject = (View)localViewParent;
      localViewParent = ((View)localObject).getParent();
    }
    AppMethodBeat.o(193445);
    return null;
  }
  
  final boolean hn(boolean paramBoolean)
  {
    AppMethodBeat.i(193444);
    final int i = this.lME.getVideoWidth();
    final int j = this.lME.getVideoHeight();
    if ((i == 0) || (j == 0))
    {
      ac.w(this.cgL, "handleVideoPage2PipStart, 0 == realVideoWidth || 0 == reaVideoHeight");
      AppMethodBeat.o(193444);
      return false;
    }
    Object localObject = bsz();
    if (localObject == null)
    {
      ac.w(this.cgL, "handleVideoPage2PipStart, null == webView2PipContainerParentOffset");
      AppMethodBeat.o(193444);
      return false;
    }
    final Point localPoint1 = new Point();
    localObject = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193438);
        if (b.this.lMG)
        {
          ac.i(b.this.cgL, "handleVideoPage2PipStart, true == mHandleStarted");
          AppMethodBeat.o(193438);
          return;
        }
        int j = b.this.lMD.biv();
        int k = b.this.lMD.biw();
        int i = localPoint1.x;
        int m = this.lNv.x;
        int n = localPoint1.y;
        int i1 = this.lNv.y;
        ac.i(b.this.cgL, "handleVideoPage2PipStart, originVideoPosX: %d, originVideoPosY: %d", new Object[] { Integer.valueOf(i + m), Integer.valueOf(n + i1) });
        b.this.jdU.a(b.a(b.this, localPoint1.x, localPoint1.y, this.lNv));
        Object localObject = b.this;
        m = i;
        n = j;
        if ((-1 != m) && (-1 != n))
        {
          i = 1;
          if (i == 0) {
            break label513;
          }
          if (m < n) {
            break label550;
          }
          i = 1;
        }
        for (;;)
        {
          label211:
          label231:
          f localf;
          if (i != 0)
          {
            ((b)localObject).lMV = AppBrandPipContainerView.mri;
            ((b)localObject).lMW = AppBrandPipContainerView.mrj;
            if ((((b)localObject).lMC instanceof f))
            {
              localf = (f)((b)localObject).lMC;
              if (i == 0) {
                break label542;
              }
            }
          }
          label513:
          label542:
          for (localObject = e.kHS;; localObject = e.kHT)
          {
            localf.a((e)localObject);
            localObject = b.this.jdU;
            i = b.this.lMV;
            j = b.this.lMW;
            ((AppBrandPipContainerView)localObject).ek(((AppBrandPipContainerView)localObject).mrM, i);
            ((AppBrandPipContainerView)localObject).el(((AppBrandPipContainerView)localObject).mrN, j);
            ac.i("MicroMsg.AppBrand.AppBrandPipContainerView", "adjustStablePos, mStablePosX: " + ((AppBrandPipContainerView)localObject).mrM + ", mStablePosY: " + ((AppBrandPipContainerView)localObject).mrN);
            ((AppBrandPipContainerView)localObject).em(((AppBrandPipContainerView)localObject).mrM, ((AppBrandPipContainerView)localObject).mrN);
            b.this.a(0.0F, b.this.lMJ, b.this.lMK, b.this.lML, b.this.lMM, b.this.lMN, b.this.lMO, b.this.lMP, b.this.lMQ, b.this.lMR, b.this.lMS, b.this.lMT, b.this.lMU);
            b.this.lMG = true;
            if (b.this.lMF != null)
            {
              ac.i(b.this.cgL, "handleVideoPage2PipStart, run afterStartTask");
              b.this.lMF.bxt();
            }
            AppMethodBeat.o(193438);
            return;
            i = 0;
            break;
            if (j < k) {
              break label550;
            }
            i = 1;
            break label211;
            ((b)localObject).lMV = AppBrandPipContainerView.mrm;
            ((b)localObject).lMW = AppBrandPipContainerView.mrn;
            break label231;
          }
          label550:
          i = 0;
        }
      }
    };
    if (paramBoolean) {
      this.lMD.a(this.caw, new g.a()
      {
        public final void dR(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(193439);
          if (b.this.lMH)
          {
            ac.i(b.this.cgL, "handleVideoPage2PipStart, onVideoPositionGot, released");
            AppMethodBeat.o(193439);
            return;
          }
          localPoint1.x = paramAnonymousInt1;
          localPoint1.y = paramAnonymousInt2;
          this.lNy.run();
          AppMethodBeat.o(193439);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(193444);
      return true;
      Point localPoint2 = this.lMD.bix();
      localPoint1.x = localPoint2.x;
      localPoint1.y = localPoint2.y;
      ((Runnable)localObject).run();
    }
  }
  
  final class a
    implements AppBrandPipContainerView.a
  {
    int chx;
    int chy;
    Point lNz = null;
    
    private a() {}
    
    public final void ef(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(193440);
      ac.d(b.this.cgL, "MyOnStablePositionChangeListener, onStablePositionChange");
      if (b.this.lMH)
      {
        ac.i(b.this.cgL, "onStablePositionChange, onVideoPositionGot, released");
        AppMethodBeat.o(193440);
        return;
      }
      int k = b.this.lME.getVideoWidth();
      int j = b.this.lME.getVideoHeight();
      if ((k == 0) || (j == 0))
      {
        ac.w(b.this.cgL, "MyOnStablePositionChangeListener, 0 == realVideoWidth || 0 == reaVideoHeight");
        AppMethodBeat.o(193440);
        return;
      }
      int m = b.this.lMD.biv();
      int n = b.this.lMD.biw();
      if (this.lNz == null) {
        this.lNz = b.this.bsz();
      }
      if (this.lNz == null)
      {
        ac.w(b.this.cgL, "MyOnStablePositionChangeListener, null == mWebView2PipContainerParentOffset");
        AppMethodBeat.o(193440);
        return;
      }
      int i2 = this.chx;
      int i1 = this.chy + this.lNz.y;
      ac.i(b.this.cgL, "MyOnStablePositionChangeListener, originVideoPosX: %d, originVideoPosY: %d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1) });
      b localb = b.this;
      label259:
      int i;
      label288:
      float f2;
      if ((-1 != k) && (-1 != j))
      {
        paramInt2 = 1;
        paramInt1 = 0;
        if (paramInt2 == 0) {
          break label953;
        }
        if (k >= j) {
          paramInt1 = 1;
        }
        if (paramInt1 == 0) {
          break label965;
        }
        localb.lMV = AppBrandPipContainerView.mri;
        localb.lMW = AppBrandPipContainerView.mrj;
        i = AppBrandPipContainerView.mrk;
        paramInt1 = AppBrandPipContainerView.mrl;
        int i3 = localb.jdU.getStablePosX();
        int i4 = localb.jdU.getStablePosY();
        ac.i(localb.cgL, "calculateStablePipContainerSizeAndPosition, stablePosX: %d, stablePosY: %d", new Object[] { Integer.valueOf(i3), Integer.valueOf(i4) });
        localb.lMX = Math.min(Math.max(0, i3), localb.mScreenWidth - localb.lMV);
        localb.lMY = Math.min(Math.max(0, i4), localb.mScreenHeight - localb.lMW);
        ac.i(localb.cgL, "calculateStablePipContainerSizeAndPosition, mEndPipContainerPosX: %d, mEndPipContainerPosY: %d", new Object[] { Integer.valueOf(localb.lMX), Integer.valueOf(localb.lMY) });
        if (paramInt2 == 0)
        {
          j = n;
          k = m;
        }
        float f1 = (i + 0.0F) / k;
        f2 = (paramInt1 + 0.0F) / j;
        if (f1 < f2) {
          break label993;
        }
        localb.lMZ = i;
        localb.lNa = ((int)Math.ceil(j * f1));
        label485:
        localb.lMN = m;
        localb.lMO = n;
        ac.d(localb.cgL, "calculateStablePipContainerSize, mStartVideoContainerWidth: %d, mStartVideoContainerHeight: %d", new Object[] { Integer.valueOf(localb.lMN), Integer.valueOf(localb.lMO) });
        localb.lMK = ((int)((localb.lMW + 0.0F) / localb.lNa * localb.lMO));
        localb.lMJ = ((int)((localb.lMV + 0.0F) / localb.lMZ * localb.lMN));
        ac.d(localb.cgL, "calculateStablePipContainerSize, mStartPipContainerWidth: %d, mStartPipContainerHeight: %d", new Object[] { Integer.valueOf(localb.lMJ), Integer.valueOf(localb.lMK) });
        localb.lMZ = i;
        localb.lNa = paramInt1;
        f1 = (localb.lMJ + 0.0F) / localb.lMV;
        f2 = (localb.lMK + 0.0F) / localb.lMW;
        ac.d(localb.cgL, "calculateStablePipContainerSize, start2EndWidthRatio: %f, start2EndHeightRatio: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
        j = Math.min(Math.max(i2, -localb.lMJ), localb.mScreenWidth);
        k = Math.min(Math.max(i1, -localb.lMK), localb.mScreenHeight);
        ac.d(localb.cgL, "calculateStablePipContainerSize, originVideoPosX: %d, originVideoPosY: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
        if (paramInt2 == 0) {
          break label1018;
        }
        localb.lML = (j - (int)((localb.lMV - i) * f1 / 2.0F));
      }
      for (localb.lMM = (k - (int)((localb.lMW - paramInt1) * f2 / 2.0F));; localb.lMM = ((n - localb.lMO) / 2 + k - (localb.lMK - localb.lMO) / 2))
      {
        localb.lMP = ((int)Math.ceil(0.5F * (localb.lMJ - localb.lMN)));
        localb.lMQ = ((int)Math.ceil(0.4F * (localb.lMK - localb.lMO)));
        localb.lMR = ((int)Math.ceil(0.6F * (localb.lMK - localb.lMO)));
        localb.lMS = ((int)(localb.lNe * f2));
        localb.lMT = ((int)(localb.lNf * f2));
        localb.lMU = ((int)(localb.lNg * f2));
        AppMethodBeat.o(193440);
        return;
        paramInt2 = 0;
        break;
        label953:
        if (m < n) {
          break label259;
        }
        paramInt1 = 1;
        break label259;
        label965:
        localb.lMV = AppBrandPipContainerView.mrm;
        localb.lMW = AppBrandPipContainerView.mrn;
        i = AppBrandPipContainerView.mro;
        paramInt1 = AppBrandPipContainerView.mrp;
        break label288;
        label993:
        localb.lMZ = ((int)Math.ceil(k * f2));
        localb.lNa = paramInt1;
        break label485;
        label1018:
        localb.lML = ((m - localb.lMN) / 2 + j - (localb.lMJ - localb.lMN) / 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.b
 * JD-Core Version:    0.7.0.1
 */