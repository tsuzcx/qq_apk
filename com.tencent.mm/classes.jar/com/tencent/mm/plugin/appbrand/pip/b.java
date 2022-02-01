package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.w.e;
import com.tencent.mm.plugin.appbrand.jsapi.w.f;
import com.tencent.mm.plugin.appbrand.jsapi.w.g;
import com.tencent.mm.plugin.appbrand.jsapi.w.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.w.i;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.utils.ag;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public final ad enm;
  public final String exO;
  int mScreenHeight;
  int mScreenWidth;
  final AppBrandPipContainerView qsN;
  volatile boolean sPK;
  final View tIY;
  public final g tIZ;
  int tJA;
  int tJB;
  private int tJC;
  private int tJD;
  private int tJE;
  private int tJF;
  private int tJG;
  private int tJH;
  private int tJI;
  private int tJJ;
  private int tJK;
  private int tJL;
  private int tJM;
  private int tJN;
  final i tJa;
  final ag tJb;
  public volatile boolean tJc;
  a tJd;
  int tJe;
  int tJf;
  int tJg;
  int tJh;
  int tJi;
  int tJj;
  int tJk;
  int tJl;
  int tJm;
  int tJn;
  int tJo;
  int tJp;
  int tJq;
  int tJr;
  int tJs;
  int tJt;
  int tJu;
  int tJv;
  private int tJw;
  private int tJx;
  private int tJy;
  int tJz;
  
  b(ad paramad, AppBrandPipContainerView paramAppBrandPipContainerView, View paramView, g paramg, i parami, ag paramag)
  {
    AppMethodBeat.i(319604);
    this.exO = ("MicroMsg.AppBrand.AppBrandPipContainerOnPageSwitchHandler#" + hashCode());
    this.tJc = false;
    this.sPK = false;
    this.tJd = null;
    this.tJw = AppBrandPipContainerView.uwA;
    this.tJx = AppBrandPipContainerView.uwz;
    this.tJy = AppBrandPipContainerView.uwB;
    this.tJz = AppBrandPipContainerView.uwC;
    this.tJA = AppBrandPipContainerView.uwD;
    this.tJB = AppBrandPipContainerView.uwE;
    this.enm = paramad;
    this.qsN = paramAppBrandPipContainerView;
    this.tIY = paramView;
    this.tIZ = paramg;
    this.tJa = parami;
    this.tJb = paramag;
    AppMethodBeat.o(319604);
  }
  
  final void a(float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    AppMethodBeat.i(319652);
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
    ViewGroup.LayoutParams localLayoutParams = this.qsN.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = j;
    this.qsN.setLayoutParams(localLayoutParams);
    this.qsN.setX(paramInt3 + paramInt1);
    this.qsN.setY(paramInt4 + paramInt2);
    localLayoutParams = this.tIY.getLayoutParams();
    localLayoutParams.width = paramInt5;
    localLayoutParams.height = paramInt6;
    this.tIY.setLayoutParams(localLayoutParams);
    this.qsN.a(paramInt5, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12);
    AppMethodBeat.o(319652);
  }
  
  final void bU(float paramFloat)
  {
    AppMethodBeat.i(319620);
    if (!this.tJc)
    {
      Log.w(this.exO, "handleVideoTransferProgress, false == mHandleStarted");
      AppMethodBeat.o(319620);
      return;
    }
    this.tJC = (this.tJe + (int)(paramFloat / 100.0F * (this.tJq - this.tJe)));
    this.tJD = (this.tJf + (int)(paramFloat / 100.0F * (this.tJr - this.tJf)));
    this.tJE = (this.tJg + (int)(paramFloat / 100.0F * (this.tJs - this.tJg)));
    this.tJF = (this.tJh + (int)(paramFloat / 100.0F * (this.tJt - this.tJh)));
    this.tJG = (this.tJi + (int)(paramFloat / 100.0F * (this.tJu - this.tJi)));
    this.tJH = (this.tJj + (int)(paramFloat / 100.0F * (this.tJv - this.tJj)));
    this.tJI = ((int)Math.ceil(0.5F * (this.tJC - this.tJG)));
    this.tJJ = ((int)Math.ceil(0.4F * (this.tJD - this.tJH)));
    this.tJK = ((int)Math.ceil(0.6F * (this.tJD - this.tJH)));
    this.tJL = (this.tJn + (int)(paramFloat / 100.0F * (this.tJz - this.tJn)));
    this.tJM = (this.tJo + (int)(paramFloat / 100.0F * (this.tJA - this.tJo)));
    this.tJN = (this.tJp + (int)(paramFloat / 100.0F * (this.tJB - this.tJp)));
    a(paramFloat, this.tJC, this.tJD, this.tJE, this.tJF, this.tJG, this.tJH, this.tJI, this.tJJ, this.tJK, this.tJL, this.tJM, this.tJN);
    AppMethodBeat.o(319620);
  }
  
  final void cHH()
  {
    AppMethodBeat.i(319623);
    Log.i(this.exO, "handleVideoPage2PipEnd");
    if (!this.tJc) {
      kH(false);
    }
    a(100.0F, this.tJq, this.tJr, this.tJs, this.tJt, this.tJu, this.tJv, this.tJw, this.tJx, this.tJy, this.tJz, this.tJA, this.tJB);
    AppMethodBeat.o(319623);
  }
  
  final Point cHI()
  {
    AppMethodBeat.i(319646);
    Object localObject = this.enm.tti;
    if (localObject == null)
    {
      Log.w(this.exO, "calculateWebView2PipContainerParentOffset, null == appBrandWebView");
      AppMethodBeat.o(319646);
      return null;
    }
    localObject = ((bd)localObject).getContentView();
    if (localObject == null)
    {
      Log.w(this.exO, "calculateWebView2PipContainerParentOffset, null == webView");
      AppMethodBeat.o(319646);
      return null;
    }
    ViewParent localViewParent = this.qsN.getParent();
    if (!(localViewParent instanceof ViewGroup))
    {
      Log.w(this.exO, "calculateWebView2PipContainerParentOffset, viewParent is not ViewGroup");
      AppMethodBeat.o(319646);
      return null;
    }
    ViewGroup localViewGroup = (ViewGroup)localViewParent;
    this.mScreenWidth = localViewGroup.getWidth();
    this.mScreenHeight = localViewGroup.getHeight();
    Log.d(this.exO, "calculateWebView2PipContainerParentOffset, mScreenWidth: %d, mScreenHeight: %d", new Object[] { Integer.valueOf(this.mScreenWidth), Integer.valueOf(this.mScreenHeight) });
    localViewParent = ((View)localObject).getParent();
    int i = 0;
    int j = 0;
    while (localViewParent != null)
    {
      if (!(localViewParent instanceof ViewGroup))
      {
        Log.w(this.exO, "calculateWebView2PipContainerParentOffset, parent is not ViewGroup");
        AppMethodBeat.o(319646);
        return null;
      }
      j = (int)(j + ((View)localObject).getX());
      float f = i;
      i = (int)(((View)localObject).getY() + f);
      if (localViewParent == localViewGroup)
      {
        Log.d(this.exO, "calculateWebView2PipContainerParentOffset, offsetX: %d, offsetY: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        localObject = new Point(j, i);
        AppMethodBeat.o(319646);
        return localObject;
      }
      localObject = (View)localViewParent;
      localViewParent = ((View)localObject).getParent();
    }
    AppMethodBeat.o(319646);
    return null;
  }
  
  final boolean kH(boolean paramBoolean)
  {
    AppMethodBeat.i(319633);
    final int i = this.tJa.getVideoWidth();
    final int j = this.tJa.getVideoHeight();
    if ((i == 0) || (j == 0))
    {
      Log.w(this.exO, "handleVideoPage2PipStart, 0 == realVideoWidth || 0 == reaVideoHeight");
      AppMethodBeat.o(319633);
      return false;
    }
    Object localObject = cHI();
    if (localObject == null)
    {
      Log.w(this.exO, "handleVideoPage2PipStart, null == webView2PipContainerParentOffset");
      AppMethodBeat.o(319633);
      return false;
    }
    final Point localPoint1 = new Point();
    localObject = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(319557);
        if (b.this.tJc)
        {
          Log.i(b.this.exO, "handleVideoPage2PipStart, true == mHandleStarted");
          AppMethodBeat.o(319557);
          return;
        }
        int j = b.this.tIZ.auH();
        int k = b.this.tIZ.auI();
        int i = localPoint1.x;
        int m = this.tJQ.x;
        int n = localPoint1.y;
        int i1 = this.tJQ.y;
        Log.i(b.this.exO, "handleVideoPage2PipStart, originVideoPosX: %d, originVideoPosY: %d", new Object[] { Integer.valueOf(i + m), Integer.valueOf(n + i1) });
        b.this.qsN.a(b.a(b.this, localPoint1.x, localPoint1.y, this.tJQ));
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
            ((b)localObject).tJq = AppBrandPipContainerView.uwl;
            ((b)localObject).tJr = AppBrandPipContainerView.uwm;
            if ((((b)localObject).tIY instanceof f))
            {
              localf = (f)((b)localObject).tIY;
              if (i == 0) {
                break label542;
              }
            }
          }
          label513:
          label542:
          for (localObject = e.sqD;; localObject = e.sqE)
          {
            localf.a((e)localObject);
            localObject = b.this.qsN;
            i = b.this.tJq;
            j = b.this.tJr;
            ((AppBrandPipContainerView)localObject).fR(((AppBrandPipContainerView)localObject).uwQ, i);
            ((AppBrandPipContainerView)localObject).fS(((AppBrandPipContainerView)localObject).uwR, j);
            Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "adjustStablePos, mStablePosX: " + ((AppBrandPipContainerView)localObject).uwQ + ", mStablePosY: " + ((AppBrandPipContainerView)localObject).uwR);
            ((AppBrandPipContainerView)localObject).fT(((AppBrandPipContainerView)localObject).uwQ, ((AppBrandPipContainerView)localObject).uwR);
            b.this.a(0.0F, b.this.tJe, b.this.tJf, b.this.tJg, b.this.tJh, b.this.tJi, b.this.tJj, b.this.tJk, b.this.tJl, b.this.tJm, b.this.tJn, b.this.tJo, b.this.tJp);
            b.this.tJc = true;
            if (b.this.tJb != null)
            {
              Log.i(b.this.exO, "handleVideoPage2PipStart, run afterStartTask");
              b.this.tJb.cNF();
            }
            AppMethodBeat.o(319557);
            return;
            i = 0;
            break;
            if (j < k) {
              break label550;
            }
            i = 1;
            break label211;
            ((b)localObject).tJq = AppBrandPipContainerView.uwp;
            ((b)localObject).tJr = AppBrandPipContainerView.uwq;
            break label231;
          }
          label550:
          i = 0;
        }
      }
    };
    if (paramBoolean) {
      this.tIZ.a(this.enm, new g.a()
      {
        public final void fx(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(319551);
          if (b.this.sPK)
          {
            Log.i(b.this.exO, "handleVideoPage2PipStart, onVideoPositionGot, released");
            AppMethodBeat.o(319551);
            return;
          }
          localPoint1.x = paramAnonymousInt1;
          localPoint1.y = paramAnonymousInt2;
          this.tJT.run();
          AppMethodBeat.o(319551);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(319633);
      return true;
      Point localPoint2 = this.tIZ.cum();
      localPoint1.x = localPoint2.x;
      localPoint1.y = localPoint2.y;
      ((Runnable)localObject).run();
    }
  }
  
  final class a
    implements AppBrandPipContainerView.a
  {
    private int eyB;
    private int eyC;
    private Point tJU = null;
    
    private a() {}
    
    public final void onStablePositionChange(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(319568);
      Log.d(b.this.exO, "MyOnStablePositionChangeListener, onStablePositionChange");
      if (b.this.sPK)
      {
        Log.i(b.this.exO, "onStablePositionChange, onVideoPositionGot, released");
        AppMethodBeat.o(319568);
        return;
      }
      int k = b.this.tJa.getVideoWidth();
      int j = b.this.tJa.getVideoHeight();
      if ((k == 0) || (j == 0))
      {
        Log.w(b.this.exO, "MyOnStablePositionChangeListener, 0 == realVideoWidth || 0 == reaVideoHeight");
        AppMethodBeat.o(319568);
        return;
      }
      int m = b.this.tIZ.auH();
      int n = b.this.tIZ.auI();
      if (this.tJU == null) {
        this.tJU = b.this.cHI();
      }
      if (this.tJU == null)
      {
        Log.w(b.this.exO, "MyOnStablePositionChangeListener, null == mWebView2PipContainerParentOffset");
        AppMethodBeat.o(319568);
        return;
      }
      int i2 = this.eyB;
      int i1 = this.eyC + this.tJU.y;
      Log.i(b.this.exO, "MyOnStablePositionChangeListener, originVideoPosX: %d, originVideoPosY: %d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1) });
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
        localb.tJq = AppBrandPipContainerView.uwl;
        localb.tJr = AppBrandPipContainerView.uwm;
        i = AppBrandPipContainerView.uwn;
        paramInt1 = AppBrandPipContainerView.uwo;
        int i3 = localb.qsN.getStablePosX();
        int i4 = localb.qsN.getStablePosY();
        Log.i(localb.exO, "calculateStablePipContainerSizeAndPosition, stablePosX: %d, stablePosY: %d", new Object[] { Integer.valueOf(i3), Integer.valueOf(i4) });
        localb.tJs = Math.min(Math.max(0, i3), localb.mScreenWidth - localb.tJq);
        localb.tJt = Math.min(Math.max(0, i4), localb.mScreenHeight - localb.tJr);
        Log.i(localb.exO, "calculateStablePipContainerSizeAndPosition, mEndPipContainerPosX: %d, mEndPipContainerPosY: %d", new Object[] { Integer.valueOf(localb.tJs), Integer.valueOf(localb.tJt) });
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
        localb.tJu = i;
        localb.tJv = ((int)Math.ceil(j * f1));
        label485:
        localb.tJi = m;
        localb.tJj = n;
        Log.d(localb.exO, "calculateStablePipContainerSize, mStartVideoContainerWidth: %d, mStartVideoContainerHeight: %d", new Object[] { Integer.valueOf(localb.tJi), Integer.valueOf(localb.tJj) });
        localb.tJf = ((int)((localb.tJr + 0.0F) / localb.tJv * localb.tJj));
        localb.tJe = ((int)((localb.tJq + 0.0F) / localb.tJu * localb.tJi));
        Log.d(localb.exO, "calculateStablePipContainerSize, mStartPipContainerWidth: %d, mStartPipContainerHeight: %d", new Object[] { Integer.valueOf(localb.tJe), Integer.valueOf(localb.tJf) });
        localb.tJu = i;
        localb.tJv = paramInt1;
        f1 = (localb.tJe + 0.0F) / localb.tJq;
        f2 = (localb.tJf + 0.0F) / localb.tJr;
        Log.d(localb.exO, "calculateStablePipContainerSize, start2EndWidthRatio: %f, start2EndHeightRatio: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
        j = Math.min(Math.max(i2, -localb.tJe), localb.mScreenWidth);
        k = Math.min(Math.max(i1, -localb.tJf), localb.mScreenHeight);
        Log.d(localb.exO, "calculateStablePipContainerSize, originVideoPosX: %d, originVideoPosY: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
        if (paramInt2 == 0) {
          break label1018;
        }
        localb.tJg = (j - (int)((localb.tJq - i) * f1 / 2.0F));
      }
      for (localb.tJh = (k - (int)((localb.tJr - paramInt1) * f2 / 2.0F));; localb.tJh = ((n - localb.tJj) / 2 + k - (localb.tJf - localb.tJj) / 2))
      {
        localb.tJk = ((int)Math.ceil(0.5F * (localb.tJe - localb.tJi)));
        localb.tJl = ((int)Math.ceil(0.4F * (localb.tJf - localb.tJj)));
        localb.tJm = ((int)Math.ceil(0.6F * (localb.tJf - localb.tJj)));
        localb.tJn = ((int)(localb.tJz * f2));
        localb.tJo = ((int)(localb.tJA * f2));
        localb.tJp = ((int)(localb.tJB * f2));
        AppMethodBeat.o(319568);
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
        localb.tJq = AppBrandPipContainerView.uwp;
        localb.tJr = AppBrandPipContainerView.uwq;
        i = AppBrandPipContainerView.uwr;
        paramInt1 = AppBrandPipContainerView.uws;
        break label288;
        label993:
        localb.tJu = ((int)Math.ceil(k * f2));
        localb.tJv = paramInt1;
        break label485;
        label1018:
        localb.tJg = ((m - localb.tJi) / 2 + j - (localb.tJe - localb.tJi) / 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.b
 * JD-Core Version:    0.7.0.1
 */