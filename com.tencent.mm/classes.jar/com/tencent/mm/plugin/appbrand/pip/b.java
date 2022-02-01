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
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.page.ay;
import com.tencent.mm.plugin.appbrand.utils.x;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  public final aa ckN;
  public final String crd;
  final AppBrandPipContainerView jxc;
  volatile boolean lxW;
  int mScreenHeight;
  int mScreenWidth;
  int mmA;
  int mmB;
  int mmC;
  int mmD;
  int mmE;
  int mmF;
  int mmG;
  int mmH;
  int mmI;
  int mmJ;
  int mmK;
  int mmL;
  int mmM;
  int mmN;
  private int mmO;
  private int mmP;
  private int mmQ;
  int mmR;
  int mmS;
  int mmT;
  private int mmU;
  private int mmV;
  private int mmW;
  private int mmX;
  private int mmY;
  private int mmZ;
  final View mmq;
  public final g mmr;
  final i mms;
  final x mmt;
  public volatile boolean mmu;
  a mmv;
  int mmw;
  int mmx;
  int mmy;
  int mmz;
  private int mna;
  private int mnb;
  private int mnc;
  private int mnd;
  private int mne;
  private int mnf;
  
  b(aa paramaa, AppBrandPipContainerView paramAppBrandPipContainerView, View paramView, g paramg, i parami, x paramx)
  {
    AppMethodBeat.i(197358);
    this.crd = ("MicroMsg.AppBrand.AppBrandPipContainerOnPageSwitchHandler#" + hashCode());
    this.mmu = false;
    this.lxW = false;
    this.mmv = null;
    this.mmO = AppBrandPipContainerView.mSc;
    this.mmP = AppBrandPipContainerView.mSb;
    this.mmQ = AppBrandPipContainerView.mSd;
    this.mmR = AppBrandPipContainerView.mSe;
    this.mmS = AppBrandPipContainerView.mSf;
    this.mmT = AppBrandPipContainerView.mSg;
    this.ckN = paramaa;
    this.jxc = paramAppBrandPipContainerView;
    this.mmq = paramView;
    this.mmr = paramg;
    this.mms = parami;
    this.mmt = paramx;
    AppMethodBeat.o(197358);
  }
  
  final void a(float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    AppMethodBeat.i(197363);
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
    ViewGroup.LayoutParams localLayoutParams = this.jxc.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = j;
    this.jxc.setLayoutParams(localLayoutParams);
    this.jxc.setX(paramInt3 + paramInt1);
    this.jxc.setY(paramInt4 + paramInt2);
    localLayoutParams = this.mmq.getLayoutParams();
    localLayoutParams.width = paramInt5;
    localLayoutParams.height = paramInt6;
    this.mmq.setLayoutParams(localLayoutParams);
    this.jxc.b(paramInt5, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12);
    AppMethodBeat.o(197363);
  }
  
  final void aH(float paramFloat)
  {
    AppMethodBeat.i(197359);
    if (!this.mmu)
    {
      ad.w(this.crd, "handleVideoTransferProgress, false == mHandleStarted");
      AppMethodBeat.o(197359);
      return;
    }
    this.mmU = (this.mmw + (int)(paramFloat / 100.0F * (this.mmI - this.mmw)));
    this.mmV = (this.mmx + (int)(paramFloat / 100.0F * (this.mmJ - this.mmx)));
    this.mmW = (this.mmy + (int)(paramFloat / 100.0F * (this.mmK - this.mmy)));
    this.mmX = (this.mmz + (int)(paramFloat / 100.0F * (this.mmL - this.mmz)));
    this.mmY = (this.mmA + (int)(paramFloat / 100.0F * (this.mmM - this.mmA)));
    this.mmZ = (this.mmB + (int)(paramFloat / 100.0F * (this.mmN - this.mmB)));
    this.mna = ((int)Math.ceil(0.5F * (this.mmU - this.mmY)));
    this.mnb = ((int)Math.ceil(0.4F * (this.mmV - this.mmZ)));
    this.mnc = ((int)Math.ceil(0.6F * (this.mmV - this.mmZ)));
    this.mnd = (this.mmF + (int)(paramFloat / 100.0F * (this.mmR - this.mmF)));
    this.mne = (this.mmG + (int)(paramFloat / 100.0F * (this.mmS - this.mmG)));
    this.mnf = (this.mmH + (int)(paramFloat / 100.0F * (this.mmT - this.mmH)));
    a(paramFloat, this.mmU, this.mmV, this.mmW, this.mmX, this.mmY, this.mmZ, this.mna, this.mnb, this.mnc, this.mnd, this.mne, this.mnf);
    AppMethodBeat.o(197359);
  }
  
  final void bwD()
  {
    AppMethodBeat.i(197360);
    ad.i(this.crd, "handleVideoPage2PipEnd");
    if (!this.mmu) {
      hu(false);
    }
    a(100.0F, this.mmI, this.mmJ, this.mmK, this.mmL, this.mmM, this.mmN, this.mmO, this.mmP, this.mmQ, this.mmR, this.mmS, this.mmT);
    AppMethodBeat.o(197360);
  }
  
  final Point bwE()
  {
    AppMethodBeat.i(197362);
    Object localObject = this.ckN.lYc;
    if (localObject == null)
    {
      ad.w(this.crd, "calculateWebView2PipContainerParentOffset, null == appBrandWebView");
      AppMethodBeat.o(197362);
      return null;
    }
    localObject = ((ay)localObject).getContentView();
    if (localObject == null)
    {
      ad.w(this.crd, "calculateWebView2PipContainerParentOffset, null == webView");
      AppMethodBeat.o(197362);
      return null;
    }
    ViewParent localViewParent = this.jxc.getParent();
    if (!(localViewParent instanceof ViewGroup))
    {
      ad.w(this.crd, "calculateWebView2PipContainerParentOffset, viewParent is not ViewGroup");
      AppMethodBeat.o(197362);
      return null;
    }
    ViewGroup localViewGroup = (ViewGroup)localViewParent;
    this.mScreenWidth = localViewGroup.getWidth();
    this.mScreenHeight = localViewGroup.getHeight();
    ad.d(this.crd, "calculateWebView2PipContainerParentOffset, mScreenWidth: %d, mScreenHeight: %d", new Object[] { Integer.valueOf(this.mScreenWidth), Integer.valueOf(this.mScreenHeight) });
    localViewParent = ((View)localObject).getParent();
    int i = 0;
    int j = 0;
    while (localViewParent != null)
    {
      if (!(localViewParent instanceof ViewGroup))
      {
        ad.w(this.crd, "calculateWebView2PipContainerParentOffset, parent is not ViewGroup");
        AppMethodBeat.o(197362);
        return null;
      }
      j = (int)(j + ((View)localObject).getX());
      float f = i;
      i = (int)(((View)localObject).getY() + f);
      if (localViewParent == localViewGroup)
      {
        ad.d(this.crd, "calculateWebView2PipContainerParentOffset, offsetX: %d, offsetY: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        localObject = new Point(j, i);
        AppMethodBeat.o(197362);
        return localObject;
      }
      localObject = (View)localViewParent;
      localViewParent = ((View)localObject).getParent();
    }
    AppMethodBeat.o(197362);
    return null;
  }
  
  final boolean hu(boolean paramBoolean)
  {
    AppMethodBeat.i(197361);
    final int i = this.mms.getVideoWidth();
    final int j = this.mms.getVideoHeight();
    if ((i == 0) || (j == 0))
    {
      ad.w(this.crd, "handleVideoPage2PipStart, 0 == realVideoWidth || 0 == reaVideoHeight");
      AppMethodBeat.o(197361);
      return false;
    }
    Object localObject = bwE();
    if (localObject == null)
    {
      ad.w(this.crd, "handleVideoPage2PipStart, null == webView2PipContainerParentOffset");
      AppMethodBeat.o(197361);
      return false;
    }
    final Point localPoint1 = new Point();
    localObject = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(197355);
        if (b.this.mmu)
        {
          ad.i(b.this.crd, "handleVideoPage2PipStart, true == mHandleStarted");
          AppMethodBeat.o(197355);
          return;
        }
        int j = b.this.mmr.bmh();
        int k = b.this.mmr.bmi();
        int i = localPoint1.x;
        int m = this.mni.x;
        int n = localPoint1.y;
        int i1 = this.mni.y;
        ad.i(b.this.crd, "handleVideoPage2PipStart, originVideoPosX: %d, originVideoPosY: %d", new Object[] { Integer.valueOf(i + m), Integer.valueOf(n + i1) });
        b.this.jxc.a(b.a(b.this, localPoint1.x, localPoint1.y, this.mni));
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
            ((b)localObject).mmI = AppBrandPipContainerView.mRN;
            ((b)localObject).mmJ = AppBrandPipContainerView.mRO;
            if ((((b)localObject).mmq instanceof f))
            {
              localf = (f)((b)localObject).mmq;
              if (i == 0) {
                break label542;
              }
            }
          }
          label513:
          label542:
          for (localObject = e.lel;; localObject = e.lem)
          {
            localf.a((e)localObject);
            localObject = b.this.jxc;
            i = b.this.mmI;
            j = b.this.mmJ;
            ((AppBrandPipContainerView)localObject).em(((AppBrandPipContainerView)localObject).mSs, i);
            ((AppBrandPipContainerView)localObject).en(((AppBrandPipContainerView)localObject).mSt, j);
            ad.i("MicroMsg.AppBrand.AppBrandPipContainerView", "adjustStablePos, mStablePosX: " + ((AppBrandPipContainerView)localObject).mSs + ", mStablePosY: " + ((AppBrandPipContainerView)localObject).mSt);
            ((AppBrandPipContainerView)localObject).eo(((AppBrandPipContainerView)localObject).mSs, ((AppBrandPipContainerView)localObject).mSt);
            b.this.a(0.0F, b.this.mmw, b.this.mmx, b.this.mmy, b.this.mmz, b.this.mmA, b.this.mmB, b.this.mmC, b.this.mmD, b.this.mmE, b.this.mmF, b.this.mmG, b.this.mmH);
            b.this.mmu = true;
            if (b.this.mmt != null)
            {
              ad.i(b.this.crd, "handleVideoPage2PipStart, run afterStartTask");
              b.this.mmt.bBx();
            }
            AppMethodBeat.o(197355);
            return;
            i = 0;
            break;
            if (j < k) {
              break label550;
            }
            i = 1;
            break label211;
            ((b)localObject).mmI = AppBrandPipContainerView.mRR;
            ((b)localObject).mmJ = AppBrandPipContainerView.mRS;
            break label231;
          }
          label550:
          i = 0;
        }
      }
    };
    if (paramBoolean) {
      this.mmr.a(this.ckN, new g.a()
      {
        public final void dT(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(197356);
          if (b.this.lxW)
          {
            ad.i(b.this.crd, "handleVideoPage2PipStart, onVideoPositionGot, released");
            AppMethodBeat.o(197356);
            return;
          }
          localPoint1.x = paramAnonymousInt1;
          localPoint1.y = paramAnonymousInt2;
          this.mnl.run();
          AppMethodBeat.o(197356);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(197361);
      return true;
      Point localPoint2 = this.mmr.bmj();
      localPoint1.x = localPoint2.x;
      localPoint1.y = localPoint2.y;
      ((Runnable)localObject).run();
    }
  }
  
  final class a
    implements AppBrandPipContainerView.a
  {
    int crP;
    int crQ;
    Point mnm = null;
    
    private a() {}
    
    public final void eh(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(197357);
      ad.d(b.this.crd, "MyOnStablePositionChangeListener, onStablePositionChange");
      if (b.this.lxW)
      {
        ad.i(b.this.crd, "onStablePositionChange, onVideoPositionGot, released");
        AppMethodBeat.o(197357);
        return;
      }
      int k = b.this.mms.getVideoWidth();
      int j = b.this.mms.getVideoHeight();
      if ((k == 0) || (j == 0))
      {
        ad.w(b.this.crd, "MyOnStablePositionChangeListener, 0 == realVideoWidth || 0 == reaVideoHeight");
        AppMethodBeat.o(197357);
        return;
      }
      int m = b.this.mmr.bmh();
      int n = b.this.mmr.bmi();
      if (this.mnm == null) {
        this.mnm = b.this.bwE();
      }
      if (this.mnm == null)
      {
        ad.w(b.this.crd, "MyOnStablePositionChangeListener, null == mWebView2PipContainerParentOffset");
        AppMethodBeat.o(197357);
        return;
      }
      int i2 = this.crP;
      int i1 = this.crQ + this.mnm.y;
      ad.i(b.this.crd, "MyOnStablePositionChangeListener, originVideoPosX: %d, originVideoPosY: %d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1) });
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
        localb.mmI = AppBrandPipContainerView.mRN;
        localb.mmJ = AppBrandPipContainerView.mRO;
        i = AppBrandPipContainerView.mRP;
        paramInt1 = AppBrandPipContainerView.mRQ;
        int i3 = localb.jxc.getStablePosX();
        int i4 = localb.jxc.getStablePosY();
        ad.i(localb.crd, "calculateStablePipContainerSizeAndPosition, stablePosX: %d, stablePosY: %d", new Object[] { Integer.valueOf(i3), Integer.valueOf(i4) });
        localb.mmK = Math.min(Math.max(0, i3), localb.mScreenWidth - localb.mmI);
        localb.mmL = Math.min(Math.max(0, i4), localb.mScreenHeight - localb.mmJ);
        ad.i(localb.crd, "calculateStablePipContainerSizeAndPosition, mEndPipContainerPosX: %d, mEndPipContainerPosY: %d", new Object[] { Integer.valueOf(localb.mmK), Integer.valueOf(localb.mmL) });
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
        localb.mmM = i;
        localb.mmN = ((int)Math.ceil(j * f1));
        label485:
        localb.mmA = m;
        localb.mmB = n;
        ad.d(localb.crd, "calculateStablePipContainerSize, mStartVideoContainerWidth: %d, mStartVideoContainerHeight: %d", new Object[] { Integer.valueOf(localb.mmA), Integer.valueOf(localb.mmB) });
        localb.mmx = ((int)((localb.mmJ + 0.0F) / localb.mmN * localb.mmB));
        localb.mmw = ((int)((localb.mmI + 0.0F) / localb.mmM * localb.mmA));
        ad.d(localb.crd, "calculateStablePipContainerSize, mStartPipContainerWidth: %d, mStartPipContainerHeight: %d", new Object[] { Integer.valueOf(localb.mmw), Integer.valueOf(localb.mmx) });
        localb.mmM = i;
        localb.mmN = paramInt1;
        f1 = (localb.mmw + 0.0F) / localb.mmI;
        f2 = (localb.mmx + 0.0F) / localb.mmJ;
        ad.d(localb.crd, "calculateStablePipContainerSize, start2EndWidthRatio: %f, start2EndHeightRatio: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
        j = Math.min(Math.max(i2, -localb.mmw), localb.mScreenWidth);
        k = Math.min(Math.max(i1, -localb.mmx), localb.mScreenHeight);
        ad.d(localb.crd, "calculateStablePipContainerSize, originVideoPosX: %d, originVideoPosY: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
        if (paramInt2 == 0) {
          break label1018;
        }
        localb.mmy = (j - (int)((localb.mmI - i) * f1 / 2.0F));
      }
      for (localb.mmz = (k - (int)((localb.mmJ - paramInt1) * f2 / 2.0F));; localb.mmz = ((n - localb.mmB) / 2 + k - (localb.mmx - localb.mmB) / 2))
      {
        localb.mmC = ((int)Math.ceil(0.5F * (localb.mmw - localb.mmA)));
        localb.mmD = ((int)Math.ceil(0.4F * (localb.mmx - localb.mmB)));
        localb.mmE = ((int)Math.ceil(0.6F * (localb.mmx - localb.mmB)));
        localb.mmF = ((int)(localb.mmR * f2));
        localb.mmG = ((int)(localb.mmS * f2));
        localb.mmH = ((int)(localb.mmT * f2));
        AppMethodBeat.o(197357);
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
        localb.mmI = AppBrandPipContainerView.mRR;
        localb.mmJ = AppBrandPipContainerView.mRS;
        i = AppBrandPipContainerView.mRT;
        paramInt1 = AppBrandPipContainerView.mRU;
        break label288;
        label993:
        localb.mmM = ((int)Math.ceil(k * f2));
        localb.mmN = paramInt1;
        break label485;
        label1018:
        localb.mmy = ((m - localb.mmA) / 2 + j - (localb.mmw - localb.mmA) / 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.b
 * JD-Core Version:    0.7.0.1
 */