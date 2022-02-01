package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.s.e;
import com.tencent.mm.plugin.appbrand.jsapi.s.f;
import com.tencent.mm.plugin.appbrand.jsapi.s.g;
import com.tencent.mm.plugin.appbrand.jsapi.s.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.s.i;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.page.bb;
import com.tencent.mm.plugin.appbrand.utils.z;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public final String cDW;
  public final ac cwK;
  final AppBrandPipContainerView kAR;
  volatile boolean mJZ;
  int mScreenHeight;
  int mScreenWidth;
  final View nBY;
  public final g nBZ;
  int nCA;
  int nCB;
  private int nCC;
  private int nCD;
  private int nCE;
  private int nCF;
  private int nCG;
  private int nCH;
  private int nCI;
  private int nCJ;
  private int nCK;
  private int nCL;
  private int nCM;
  private int nCN;
  final i nCa;
  final z nCb;
  public volatile boolean nCc;
  a nCd;
  int nCe;
  int nCf;
  int nCg;
  int nCh;
  int nCi;
  int nCj;
  int nCk;
  int nCl;
  int nCm;
  int nCn;
  int nCo;
  int nCp;
  int nCq;
  int nCr;
  int nCs;
  int nCt;
  int nCu;
  int nCv;
  private int nCw;
  private int nCx;
  private int nCy;
  int nCz;
  
  b(ac paramac, AppBrandPipContainerView paramAppBrandPipContainerView, View paramView, g paramg, i parami, z paramz)
  {
    AppMethodBeat.i(219501);
    this.cDW = ("MicroMsg.AppBrand.AppBrandPipContainerOnPageSwitchHandler#" + hashCode());
    this.nCc = false;
    this.mJZ = false;
    this.nCd = null;
    this.nCw = AppBrandPipContainerView.okp;
    this.nCx = AppBrandPipContainerView.oko;
    this.nCy = AppBrandPipContainerView.okq;
    this.nCz = AppBrandPipContainerView.okr;
    this.nCA = AppBrandPipContainerView.oks;
    this.nCB = AppBrandPipContainerView.okt;
    this.cwK = paramac;
    this.kAR = paramAppBrandPipContainerView;
    this.nBY = paramView;
    this.nBZ = paramg;
    this.nCa = parami;
    this.nCb = paramz;
    AppMethodBeat.o(219501);
  }
  
  final void a(float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    AppMethodBeat.i(219506);
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
    ViewGroup.LayoutParams localLayoutParams = this.kAR.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = j;
    this.kAR.setLayoutParams(localLayoutParams);
    this.kAR.setX(paramInt3 + paramInt1);
    this.kAR.setY(paramInt4 + paramInt2);
    localLayoutParams = this.nBY.getLayoutParams();
    localLayoutParams.width = paramInt5;
    localLayoutParams.height = paramInt6;
    this.nBY.setLayoutParams(localLayoutParams);
    this.kAR.b(paramInt5, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12);
    AppMethodBeat.o(219506);
  }
  
  final void aR(float paramFloat)
  {
    AppMethodBeat.i(219502);
    if (!this.nCc)
    {
      Log.w(this.cDW, "handleVideoTransferProgress, false == mHandleStarted");
      AppMethodBeat.o(219502);
      return;
    }
    this.nCC = (this.nCe + (int)(paramFloat / 100.0F * (this.nCq - this.nCe)));
    this.nCD = (this.nCf + (int)(paramFloat / 100.0F * (this.nCr - this.nCf)));
    this.nCE = (this.nCg + (int)(paramFloat / 100.0F * (this.nCs - this.nCg)));
    this.nCF = (this.nCh + (int)(paramFloat / 100.0F * (this.nCt - this.nCh)));
    this.nCG = (this.nCi + (int)(paramFloat / 100.0F * (this.nCu - this.nCi)));
    this.nCH = (this.nCj + (int)(paramFloat / 100.0F * (this.nCv - this.nCj)));
    this.nCI = ((int)Math.ceil(0.5F * (this.nCC - this.nCG)));
    this.nCJ = ((int)Math.ceil(0.4F * (this.nCD - this.nCH)));
    this.nCK = ((int)Math.ceil(0.6F * (this.nCD - this.nCH)));
    this.nCL = (this.nCn + (int)(paramFloat / 100.0F * (this.nCz - this.nCn)));
    this.nCM = (this.nCo + (int)(paramFloat / 100.0F * (this.nCA - this.nCo)));
    this.nCN = (this.nCp + (int)(paramFloat / 100.0F * (this.nCB - this.nCp)));
    a(paramFloat, this.nCC, this.nCD, this.nCE, this.nCF, this.nCG, this.nCH, this.nCI, this.nCJ, this.nCK, this.nCL, this.nCM, this.nCN);
    AppMethodBeat.o(219502);
  }
  
  final void bTE()
  {
    AppMethodBeat.i(219503);
    Log.i(this.cDW, "handleVideoPage2PipEnd");
    if (!this.nCc) {
      iw(false);
    }
    a(100.0F, this.nCq, this.nCr, this.nCs, this.nCt, this.nCu, this.nCv, this.nCw, this.nCx, this.nCy, this.nCz, this.nCA, this.nCB);
    AppMethodBeat.o(219503);
  }
  
  final Point bTF()
  {
    AppMethodBeat.i(219505);
    Object localObject = this.cwK.nmX;
    if (localObject == null)
    {
      Log.w(this.cDW, "calculateWebView2PipContainerParentOffset, null == appBrandWebView");
      AppMethodBeat.o(219505);
      return null;
    }
    localObject = ((bb)localObject).getContentView();
    if (localObject == null)
    {
      Log.w(this.cDW, "calculateWebView2PipContainerParentOffset, null == webView");
      AppMethodBeat.o(219505);
      return null;
    }
    ViewParent localViewParent = this.kAR.getParent();
    if (!(localViewParent instanceof ViewGroup))
    {
      Log.w(this.cDW, "calculateWebView2PipContainerParentOffset, viewParent is not ViewGroup");
      AppMethodBeat.o(219505);
      return null;
    }
    ViewGroup localViewGroup = (ViewGroup)localViewParent;
    this.mScreenWidth = localViewGroup.getWidth();
    this.mScreenHeight = localViewGroup.getHeight();
    Log.d(this.cDW, "calculateWebView2PipContainerParentOffset, mScreenWidth: %d, mScreenHeight: %d", new Object[] { Integer.valueOf(this.mScreenWidth), Integer.valueOf(this.mScreenHeight) });
    localViewParent = ((View)localObject).getParent();
    int i = 0;
    int j = 0;
    while (localViewParent != null)
    {
      if (!(localViewParent instanceof ViewGroup))
      {
        Log.w(this.cDW, "calculateWebView2PipContainerParentOffset, parent is not ViewGroup");
        AppMethodBeat.o(219505);
        return null;
      }
      j = (int)(j + ((View)localObject).getX());
      float f = i;
      i = (int)(((View)localObject).getY() + f);
      if (localViewParent == localViewGroup)
      {
        Log.d(this.cDW, "calculateWebView2PipContainerParentOffset, offsetX: %d, offsetY: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        localObject = new Point(j, i);
        AppMethodBeat.o(219505);
        return localObject;
      }
      localObject = (View)localViewParent;
      localViewParent = ((View)localObject).getParent();
    }
    AppMethodBeat.o(219505);
    return null;
  }
  
  final boolean iw(boolean paramBoolean)
  {
    AppMethodBeat.i(219504);
    final int i = this.nCa.getVideoWidth();
    final int j = this.nCa.getVideoHeight();
    if ((i == 0) || (j == 0))
    {
      Log.w(this.cDW, "handleVideoPage2PipStart, 0 == realVideoWidth || 0 == reaVideoHeight");
      AppMethodBeat.o(219504);
      return false;
    }
    Object localObject = bTF();
    if (localObject == null)
    {
      Log.w(this.cDW, "handleVideoPage2PipStart, null == webView2PipContainerParentOffset");
      AppMethodBeat.o(219504);
      return false;
    }
    final Point localPoint1 = new Point();
    localObject = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(219498);
        if (b.this.nCc)
        {
          Log.i(b.this.cDW, "handleVideoPage2PipStart, true == mHandleStarted");
          AppMethodBeat.o(219498);
          return;
        }
        int j = b.this.nBZ.bIp();
        int k = b.this.nBZ.bIq();
        int i = localPoint1.x;
        int m = this.nCQ.x;
        int n = localPoint1.y;
        int i1 = this.nCQ.y;
        Log.i(b.this.cDW, "handleVideoPage2PipStart, originVideoPosX: %d, originVideoPosY: %d", new Object[] { Integer.valueOf(i + m), Integer.valueOf(n + i1) });
        b.this.kAR.a(b.a(b.this, localPoint1.x, localPoint1.y, this.nCQ));
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
            ((b)localObject).nCq = AppBrandPipContainerView.oka;
            ((b)localObject).nCr = AppBrandPipContainerView.okb;
            if ((((b)localObject).nBY instanceof f))
            {
              localf = (f)((b)localObject).nBY;
              if (i == 0) {
                break label542;
              }
            }
          }
          label513:
          label542:
          for (localObject = e.mnv;; localObject = e.mnw)
          {
            localf.a((e)localObject);
            localObject = b.this.kAR;
            i = b.this.nCq;
            j = b.this.nCr;
            ((AppBrandPipContainerView)localObject).eA(((AppBrandPipContainerView)localObject).okF, i);
            ((AppBrandPipContainerView)localObject).eB(((AppBrandPipContainerView)localObject).okG, j);
            Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "adjustStablePos, mStablePosX: " + ((AppBrandPipContainerView)localObject).okF + ", mStablePosY: " + ((AppBrandPipContainerView)localObject).okG);
            ((AppBrandPipContainerView)localObject).eC(((AppBrandPipContainerView)localObject).okF, ((AppBrandPipContainerView)localObject).okG);
            b.this.a(0.0F, b.this.nCe, b.this.nCf, b.this.nCg, b.this.nCh, b.this.nCi, b.this.nCj, b.this.nCk, b.this.nCl, b.this.nCm, b.this.nCn, b.this.nCo, b.this.nCp);
            b.this.nCc = true;
            if (b.this.nCb != null)
            {
              Log.i(b.this.cDW, "handleVideoPage2PipStart, run afterStartTask");
              b.this.nCb.bZv();
            }
            AppMethodBeat.o(219498);
            return;
            i = 0;
            break;
            if (j < k) {
              break label550;
            }
            i = 1;
            break label211;
            ((b)localObject).nCq = AppBrandPipContainerView.oke;
            ((b)localObject).nCr = AppBrandPipContainerView.okf;
            break label231;
          }
          label550:
          i = 0;
        }
      }
    };
    if (paramBoolean) {
      this.nBZ.a(this.cwK, new g.a()
      {
        public final void ef(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(219499);
          if (b.this.mJZ)
          {
            Log.i(b.this.cDW, "handleVideoPage2PipStart, onVideoPositionGot, released");
            AppMethodBeat.o(219499);
            return;
          }
          localPoint1.x = paramAnonymousInt1;
          localPoint1.y = paramAnonymousInt2;
          this.nCT.run();
          AppMethodBeat.o(219499);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(219504);
      return true;
      Point localPoint2 = this.nBZ.bIr();
      localPoint1.x = localPoint2.x;
      localPoint1.y = localPoint2.y;
      ((Runnable)localObject).run();
    }
  }
  
  final class a
    implements AppBrandPipContainerView.a
  {
    int cEH;
    int cEI;
    Point nCU = null;
    
    private a() {}
    
    public final void ev(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(219500);
      Log.d(b.this.cDW, "MyOnStablePositionChangeListener, onStablePositionChange");
      if (b.this.mJZ)
      {
        Log.i(b.this.cDW, "onStablePositionChange, onVideoPositionGot, released");
        AppMethodBeat.o(219500);
        return;
      }
      int k = b.this.nCa.getVideoWidth();
      int j = b.this.nCa.getVideoHeight();
      if ((k == 0) || (j == 0))
      {
        Log.w(b.this.cDW, "MyOnStablePositionChangeListener, 0 == realVideoWidth || 0 == reaVideoHeight");
        AppMethodBeat.o(219500);
        return;
      }
      int m = b.this.nBZ.bIp();
      int n = b.this.nBZ.bIq();
      if (this.nCU == null) {
        this.nCU = b.this.bTF();
      }
      if (this.nCU == null)
      {
        Log.w(b.this.cDW, "MyOnStablePositionChangeListener, null == mWebView2PipContainerParentOffset");
        AppMethodBeat.o(219500);
        return;
      }
      int i2 = this.cEH;
      int i1 = this.cEI + this.nCU.y;
      Log.i(b.this.cDW, "MyOnStablePositionChangeListener, originVideoPosX: %d, originVideoPosY: %d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1) });
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
        localb.nCq = AppBrandPipContainerView.oka;
        localb.nCr = AppBrandPipContainerView.okb;
        i = AppBrandPipContainerView.okc;
        paramInt1 = AppBrandPipContainerView.okd;
        int i3 = localb.kAR.getStablePosX();
        int i4 = localb.kAR.getStablePosY();
        Log.i(localb.cDW, "calculateStablePipContainerSizeAndPosition, stablePosX: %d, stablePosY: %d", new Object[] { Integer.valueOf(i3), Integer.valueOf(i4) });
        localb.nCs = Math.min(Math.max(0, i3), localb.mScreenWidth - localb.nCq);
        localb.nCt = Math.min(Math.max(0, i4), localb.mScreenHeight - localb.nCr);
        Log.i(localb.cDW, "calculateStablePipContainerSizeAndPosition, mEndPipContainerPosX: %d, mEndPipContainerPosY: %d", new Object[] { Integer.valueOf(localb.nCs), Integer.valueOf(localb.nCt) });
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
        localb.nCu = i;
        localb.nCv = ((int)Math.ceil(j * f1));
        label485:
        localb.nCi = m;
        localb.nCj = n;
        Log.d(localb.cDW, "calculateStablePipContainerSize, mStartVideoContainerWidth: %d, mStartVideoContainerHeight: %d", new Object[] { Integer.valueOf(localb.nCi), Integer.valueOf(localb.nCj) });
        localb.nCf = ((int)((localb.nCr + 0.0F) / localb.nCv * localb.nCj));
        localb.nCe = ((int)((localb.nCq + 0.0F) / localb.nCu * localb.nCi));
        Log.d(localb.cDW, "calculateStablePipContainerSize, mStartPipContainerWidth: %d, mStartPipContainerHeight: %d", new Object[] { Integer.valueOf(localb.nCe), Integer.valueOf(localb.nCf) });
        localb.nCu = i;
        localb.nCv = paramInt1;
        f1 = (localb.nCe + 0.0F) / localb.nCq;
        f2 = (localb.nCf + 0.0F) / localb.nCr;
        Log.d(localb.cDW, "calculateStablePipContainerSize, start2EndWidthRatio: %f, start2EndHeightRatio: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
        j = Math.min(Math.max(i2, -localb.nCe), localb.mScreenWidth);
        k = Math.min(Math.max(i1, -localb.nCf), localb.mScreenHeight);
        Log.d(localb.cDW, "calculateStablePipContainerSize, originVideoPosX: %d, originVideoPosY: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
        if (paramInt2 == 0) {
          break label1018;
        }
        localb.nCg = (j - (int)((localb.nCq - i) * f1 / 2.0F));
      }
      for (localb.nCh = (k - (int)((localb.nCr - paramInt1) * f2 / 2.0F));; localb.nCh = ((n - localb.nCj) / 2 + k - (localb.nCf - localb.nCj) / 2))
      {
        localb.nCk = ((int)Math.ceil(0.5F * (localb.nCe - localb.nCi)));
        localb.nCl = ((int)Math.ceil(0.4F * (localb.nCf - localb.nCj)));
        localb.nCm = ((int)Math.ceil(0.6F * (localb.nCf - localb.nCj)));
        localb.nCn = ((int)(localb.nCz * f2));
        localb.nCo = ((int)(localb.nCA * f2));
        localb.nCp = ((int)(localb.nCB * f2));
        AppMethodBeat.o(219500);
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
        localb.nCq = AppBrandPipContainerView.oke;
        localb.nCr = AppBrandPipContainerView.okf;
        i = AppBrandPipContainerView.okg;
        paramInt1 = AppBrandPipContainerView.okh;
        break label288;
        label993:
        localb.nCu = ((int)Math.ceil(k * f2));
        localb.nCv = paramInt1;
        break label485;
        label1018:
        localb.nCg = ((m - localb.nCi) / 2 + j - (localb.nCe - localb.nCi) / 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.b
 * JD-Core Version:    0.7.0.1
 */