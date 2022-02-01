package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.q.e;
import com.tencent.mm.plugin.appbrand.jsapi.q.f;
import com.tencent.mm.plugin.appbrand.jsapi.q.g;
import com.tencent.mm.plugin.appbrand.jsapi.q.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.q.i;
import com.tencent.mm.plugin.appbrand.page.ax;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView.a;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
{
  public final com.tencent.mm.plugin.appbrand.page.z ckP;
  public final String crG;
  final AppBrandPipContainerView jAa;
  volatile boolean lCu;
  int mScreenHeight;
  int mScreenWidth;
  int mrA;
  int mrB;
  int mrC;
  int mrD;
  int mrE;
  int mrF;
  int mrG;
  int mrH;
  int mrI;
  int mrJ;
  int mrK;
  private int mrL;
  private int mrM;
  private int mrN;
  int mrO;
  int mrP;
  int mrQ;
  private int mrR;
  private int mrS;
  private int mrT;
  private int mrU;
  private int mrV;
  private int mrW;
  private int mrX;
  private int mrY;
  private int mrZ;
  final View mrn;
  public final g mro;
  final i mrp;
  final com.tencent.mm.plugin.appbrand.utils.z mrq;
  public volatile boolean mrr;
  a mrs;
  int mrt;
  int mru;
  int mrv;
  int mrw;
  int mrx;
  int mry;
  int mrz;
  private int msa;
  private int msb;
  private int msc;
  
  b(com.tencent.mm.plugin.appbrand.page.z paramz, AppBrandPipContainerView paramAppBrandPipContainerView, View paramView, g paramg, i parami, com.tencent.mm.plugin.appbrand.utils.z paramz1)
  {
    AppMethodBeat.i(207899);
    this.crG = ("MicroMsg.AppBrand.AppBrandPipContainerOnPageSwitchHandler#" + hashCode());
    this.mrr = false;
    this.lCu = false;
    this.mrs = null;
    this.mrL = AppBrandPipContainerView.mXm;
    this.mrM = AppBrandPipContainerView.mXl;
    this.mrN = AppBrandPipContainerView.mXn;
    this.mrO = AppBrandPipContainerView.mXo;
    this.mrP = AppBrandPipContainerView.mXp;
    this.mrQ = AppBrandPipContainerView.mXq;
    this.ckP = paramz;
    this.jAa = paramAppBrandPipContainerView;
    this.mrn = paramView;
    this.mro = paramg;
    this.mrp = parami;
    this.mrq = paramz1;
    AppMethodBeat.o(207899);
  }
  
  final void a(float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    AppMethodBeat.i(207904);
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
    ViewGroup.LayoutParams localLayoutParams = this.jAa.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = j;
    this.jAa.setLayoutParams(localLayoutParams);
    this.jAa.setX(paramInt3 + paramInt1);
    this.jAa.setY(paramInt4 + paramInt2);
    localLayoutParams = this.mrn.getLayoutParams();
    localLayoutParams.width = paramInt5;
    localLayoutParams.height = paramInt6;
    this.mrn.setLayoutParams(localLayoutParams);
    this.jAa.b(paramInt5, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12);
    AppMethodBeat.o(207904);
  }
  
  final void aH(float paramFloat)
  {
    AppMethodBeat.i(207900);
    if (!this.mrr)
    {
      ae.w(this.crG, "handleVideoTransferProgress, false == mHandleStarted");
      AppMethodBeat.o(207900);
      return;
    }
    this.mrR = (this.mrt + (int)(paramFloat / 100.0F * (this.mrF - this.mrt)));
    this.mrS = (this.mru + (int)(paramFloat / 100.0F * (this.mrG - this.mru)));
    this.mrT = (this.mrv + (int)(paramFloat / 100.0F * (this.mrH - this.mrv)));
    this.mrU = (this.mrw + (int)(paramFloat / 100.0F * (this.mrI - this.mrw)));
    this.mrV = (this.mrx + (int)(paramFloat / 100.0F * (this.mrJ - this.mrx)));
    this.mrW = (this.mry + (int)(paramFloat / 100.0F * (this.mrK - this.mry)));
    this.mrX = ((int)Math.ceil(0.5F * (this.mrR - this.mrV)));
    this.mrY = ((int)Math.ceil(0.4F * (this.mrS - this.mrW)));
    this.mrZ = ((int)Math.ceil(0.6F * (this.mrS - this.mrW)));
    this.msa = (this.mrC + (int)(paramFloat / 100.0F * (this.mrO - this.mrC)));
    this.msb = (this.mrD + (int)(paramFloat / 100.0F * (this.mrP - this.mrD)));
    this.msc = (this.mrE + (int)(paramFloat / 100.0F * (this.mrQ - this.mrE)));
    a(paramFloat, this.mrR, this.mrS, this.mrT, this.mrU, this.mrV, this.mrW, this.mrX, this.mrY, this.mrZ, this.msa, this.msb, this.msc);
    AppMethodBeat.o(207900);
  }
  
  final void bxu()
  {
    AppMethodBeat.i(207901);
    ae.i(this.crG, "handleVideoPage2PipEnd");
    if (!this.mrr) {
      hv(false);
    }
    a(100.0F, this.mrF, this.mrG, this.mrH, this.mrI, this.mrJ, this.mrK, this.mrL, this.mrM, this.mrN, this.mrO, this.mrP, this.mrQ);
    AppMethodBeat.o(207901);
  }
  
  final Point bxv()
  {
    AppMethodBeat.i(207903);
    Object localObject = this.ckP.mcJ;
    if (localObject == null)
    {
      ae.w(this.crG, "calculateWebView2PipContainerParentOffset, null == appBrandWebView");
      AppMethodBeat.o(207903);
      return null;
    }
    localObject = ((ax)localObject).getContentView();
    if (localObject == null)
    {
      ae.w(this.crG, "calculateWebView2PipContainerParentOffset, null == webView");
      AppMethodBeat.o(207903);
      return null;
    }
    ViewParent localViewParent = this.jAa.getParent();
    if (!(localViewParent instanceof ViewGroup))
    {
      ae.w(this.crG, "calculateWebView2PipContainerParentOffset, viewParent is not ViewGroup");
      AppMethodBeat.o(207903);
      return null;
    }
    ViewGroup localViewGroup = (ViewGroup)localViewParent;
    this.mScreenWidth = localViewGroup.getWidth();
    this.mScreenHeight = localViewGroup.getHeight();
    ae.d(this.crG, "calculateWebView2PipContainerParentOffset, mScreenWidth: %d, mScreenHeight: %d", new Object[] { Integer.valueOf(this.mScreenWidth), Integer.valueOf(this.mScreenHeight) });
    localViewParent = ((View)localObject).getParent();
    int i = 0;
    int j = 0;
    while (localViewParent != null)
    {
      if (!(localViewParent instanceof ViewGroup))
      {
        ae.w(this.crG, "calculateWebView2PipContainerParentOffset, parent is not ViewGroup");
        AppMethodBeat.o(207903);
        return null;
      }
      j = (int)(j + ((View)localObject).getX());
      float f = i;
      i = (int)(((View)localObject).getY() + f);
      if (localViewParent == localViewGroup)
      {
        ae.d(this.crG, "calculateWebView2PipContainerParentOffset, offsetX: %d, offsetY: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        localObject = new Point(j, i);
        AppMethodBeat.o(207903);
        return localObject;
      }
      localObject = (View)localViewParent;
      localViewParent = ((View)localObject).getParent();
    }
    AppMethodBeat.o(207903);
    return null;
  }
  
  final boolean hv(boolean paramBoolean)
  {
    AppMethodBeat.i(207902);
    final int i = this.mrp.getVideoWidth();
    final int j = this.mrp.getVideoHeight();
    if ((i == 0) || (j == 0))
    {
      ae.w(this.crG, "handleVideoPage2PipStart, 0 == realVideoWidth || 0 == reaVideoHeight");
      AppMethodBeat.o(207902);
      return false;
    }
    Object localObject = bxv();
    if (localObject == null)
    {
      ae.w(this.crG, "handleVideoPage2PipStart, null == webView2PipContainerParentOffset");
      AppMethodBeat.o(207902);
      return false;
    }
    final Point localPoint1 = new Point();
    localObject = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(207896);
        if (b.this.mrr)
        {
          ae.i(b.this.crG, "handleVideoPage2PipStart, true == mHandleStarted");
          AppMethodBeat.o(207896);
          return;
        }
        int j = b.this.mro.bmQ();
        int k = b.this.mro.bmR();
        int i = localPoint1.x;
        int m = this.msf.x;
        int n = localPoint1.y;
        int i1 = this.msf.y;
        ae.i(b.this.crG, "handleVideoPage2PipStart, originVideoPosX: %d, originVideoPosY: %d", new Object[] { Integer.valueOf(i + m), Integer.valueOf(n + i1) });
        b.this.jAa.a(b.a(b.this, localPoint1.x, localPoint1.y, this.msf));
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
            ((b)localObject).mrF = AppBrandPipContainerView.mWX;
            ((b)localObject).mrG = AppBrandPipContainerView.mWY;
            if ((((b)localObject).mrn instanceof f))
            {
              localf = (f)((b)localObject).mrn;
              if (i == 0) {
                break label542;
              }
            }
          }
          label513:
          label542:
          for (localObject = e.lhX;; localObject = e.lhY)
          {
            localf.a((e)localObject);
            localObject = b.this.jAa;
            i = b.this.mrF;
            j = b.this.mrG;
            ((AppBrandPipContainerView)localObject).em(((AppBrandPipContainerView)localObject).mXB, i);
            ((AppBrandPipContainerView)localObject).en(((AppBrandPipContainerView)localObject).mXC, j);
            ae.i("MicroMsg.AppBrand.AppBrandPipContainerView", "adjustStablePos, mStablePosX: " + ((AppBrandPipContainerView)localObject).mXB + ", mStablePosY: " + ((AppBrandPipContainerView)localObject).mXC);
            ((AppBrandPipContainerView)localObject).eo(((AppBrandPipContainerView)localObject).mXB, ((AppBrandPipContainerView)localObject).mXC);
            b.this.a(0.0F, b.this.mrt, b.this.mru, b.this.mrv, b.this.mrw, b.this.mrx, b.this.mry, b.this.mrz, b.this.mrA, b.this.mrB, b.this.mrC, b.this.mrD, b.this.mrE);
            b.this.mrr = true;
            if (b.this.mrq != null)
            {
              ae.i(b.this.crG, "handleVideoPage2PipStart, run afterStartTask");
              b.this.mrq.bCr();
            }
            AppMethodBeat.o(207896);
            return;
            i = 0;
            break;
            if (j < k) {
              break label550;
            }
            i = 1;
            break label211;
            ((b)localObject).mrF = AppBrandPipContainerView.mXb;
            ((b)localObject).mrG = AppBrandPipContainerView.mXc;
            break label231;
          }
          label550:
          i = 0;
        }
      }
    };
    if (paramBoolean) {
      this.mro.a(this.ckP, new g.a()
      {
        public final void dT(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(207897);
          if (b.this.lCu)
          {
            ae.i(b.this.crG, "handleVideoPage2PipStart, onVideoPositionGot, released");
            AppMethodBeat.o(207897);
            return;
          }
          localPoint1.x = paramAnonymousInt1;
          localPoint1.y = paramAnonymousInt2;
          this.msj.run();
          AppMethodBeat.o(207897);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(207902);
      return true;
      Point localPoint2 = this.mro.bmS();
      localPoint1.x = localPoint2.x;
      localPoint1.y = localPoint2.y;
      ((Runnable)localObject).run();
    }
  }
  
  final class a
    implements AppBrandPipContainerView.a
  {
    int css;
    int cst;
    Point msk = null;
    
    private a() {}
    
    public final void eh(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(207898);
      ae.d(b.this.crG, "MyOnStablePositionChangeListener, onStablePositionChange");
      if (b.this.lCu)
      {
        ae.i(b.this.crG, "onStablePositionChange, onVideoPositionGot, released");
        AppMethodBeat.o(207898);
        return;
      }
      int k = b.this.mrp.getVideoWidth();
      int j = b.this.mrp.getVideoHeight();
      if ((k == 0) || (j == 0))
      {
        ae.w(b.this.crG, "MyOnStablePositionChangeListener, 0 == realVideoWidth || 0 == reaVideoHeight");
        AppMethodBeat.o(207898);
        return;
      }
      int m = b.this.mro.bmQ();
      int n = b.this.mro.bmR();
      if (this.msk == null) {
        this.msk = b.this.bxv();
      }
      if (this.msk == null)
      {
        ae.w(b.this.crG, "MyOnStablePositionChangeListener, null == mWebView2PipContainerParentOffset");
        AppMethodBeat.o(207898);
        return;
      }
      int i2 = this.css;
      int i1 = this.cst + this.msk.y;
      ae.i(b.this.crG, "MyOnStablePositionChangeListener, originVideoPosX: %d, originVideoPosY: %d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1) });
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
        localb.mrF = AppBrandPipContainerView.mWX;
        localb.mrG = AppBrandPipContainerView.mWY;
        i = AppBrandPipContainerView.mWZ;
        paramInt1 = AppBrandPipContainerView.mXa;
        int i3 = localb.jAa.getStablePosX();
        int i4 = localb.jAa.getStablePosY();
        ae.i(localb.crG, "calculateStablePipContainerSizeAndPosition, stablePosX: %d, stablePosY: %d", new Object[] { Integer.valueOf(i3), Integer.valueOf(i4) });
        localb.mrH = Math.min(Math.max(0, i3), localb.mScreenWidth - localb.mrF);
        localb.mrI = Math.min(Math.max(0, i4), localb.mScreenHeight - localb.mrG);
        ae.i(localb.crG, "calculateStablePipContainerSizeAndPosition, mEndPipContainerPosX: %d, mEndPipContainerPosY: %d", new Object[] { Integer.valueOf(localb.mrH), Integer.valueOf(localb.mrI) });
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
        localb.mrJ = i;
        localb.mrK = ((int)Math.ceil(j * f1));
        label485:
        localb.mrx = m;
        localb.mry = n;
        ae.d(localb.crG, "calculateStablePipContainerSize, mStartVideoContainerWidth: %d, mStartVideoContainerHeight: %d", new Object[] { Integer.valueOf(localb.mrx), Integer.valueOf(localb.mry) });
        localb.mru = ((int)((localb.mrG + 0.0F) / localb.mrK * localb.mry));
        localb.mrt = ((int)((localb.mrF + 0.0F) / localb.mrJ * localb.mrx));
        ae.d(localb.crG, "calculateStablePipContainerSize, mStartPipContainerWidth: %d, mStartPipContainerHeight: %d", new Object[] { Integer.valueOf(localb.mrt), Integer.valueOf(localb.mru) });
        localb.mrJ = i;
        localb.mrK = paramInt1;
        f1 = (localb.mrt + 0.0F) / localb.mrF;
        f2 = (localb.mru + 0.0F) / localb.mrG;
        ae.d(localb.crG, "calculateStablePipContainerSize, start2EndWidthRatio: %f, start2EndHeightRatio: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
        j = Math.min(Math.max(i2, -localb.mrt), localb.mScreenWidth);
        k = Math.min(Math.max(i1, -localb.mru), localb.mScreenHeight);
        ae.d(localb.crG, "calculateStablePipContainerSize, originVideoPosX: %d, originVideoPosY: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
        if (paramInt2 == 0) {
          break label1018;
        }
        localb.mrv = (j - (int)((localb.mrF - i) * f1 / 2.0F));
      }
      for (localb.mrw = (k - (int)((localb.mrG - paramInt1) * f2 / 2.0F));; localb.mrw = ((n - localb.mry) / 2 + k - (localb.mru - localb.mry) / 2))
      {
        localb.mrz = ((int)Math.ceil(0.5F * (localb.mrt - localb.mrx)));
        localb.mrA = ((int)Math.ceil(0.4F * (localb.mru - localb.mry)));
        localb.mrB = ((int)Math.ceil(0.6F * (localb.mru - localb.mry)));
        localb.mrC = ((int)(localb.mrO * f2));
        localb.mrD = ((int)(localb.mrP * f2));
        localb.mrE = ((int)(localb.mrQ * f2));
        AppMethodBeat.o(207898);
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
        localb.mrF = AppBrandPipContainerView.mXb;
        localb.mrG = AppBrandPipContainerView.mXc;
        i = AppBrandPipContainerView.mXd;
        paramInt1 = AppBrandPipContainerView.mXe;
        break label288;
        label993:
        localb.mrJ = ((int)Math.ceil(k * f2));
        localb.mrK = paramInt1;
        break label485;
        label1018:
        localb.mrv = ((m - localb.mrx) / 2 + j - (localb.mrt - localb.mrx) / 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.b
 * JD-Core Version:    0.7.0.1
 */