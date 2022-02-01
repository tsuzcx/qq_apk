package com.tencent.mm.plugin.appbrand.page;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.o.f;
import com.tencent.mm.plugin.appbrand.jsapi.o.g;
import com.tencent.mm.plugin.appbrand.jsapi.o.h;
import com.tencent.mm.plugin.appbrand.jsapi.o.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.j;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class af
{
  public final aa cdz;
  public final String cjP;
  final AppBrandPipContainerView iDU;
  final View lbN;
  public final h lbO;
  final j lbP;
  public volatile boolean lbQ;
  private a lbR;
  int lbS;
  int lbT;
  int lbU;
  int lbV;
  int lbW;
  int lbX;
  int lbY;
  int lbZ;
  private int lcA;
  private int lcB;
  int lca;
  int lcb;
  int lcc;
  int lcd;
  int lce;
  int lcf;
  private int lcg;
  private int lch;
  private int lci;
  private int lcj;
  private int lck;
  private int lcl;
  private int lcm;
  private int lcn;
  private int lco;
  private int lcp;
  private int lcq;
  private int lcr;
  private int lcs;
  private int lct;
  private int lcu;
  private int lcv;
  private int lcw;
  private int lcx;
  private int lcy;
  private int lcz;
  private int mScreenHeight;
  private int mScreenWidth;
  
  af(aa paramaa, AppBrandPipContainerView paramAppBrandPipContainerView, View paramView, h paramh, j paramj)
  {
    AppMethodBeat.i(194504);
    this.cjP = ("MicroMsg.AppBrand.AppBrandPipContainerOnPageSwitchHandler#" + hashCode());
    this.lbQ = false;
    this.lbR = null;
    this.lck = AppBrandPipContainerView.lPv;
    this.lcl = AppBrandPipContainerView.lPu;
    this.lcm = AppBrandPipContainerView.lPw;
    this.lcn = AppBrandPipContainerView.lPx;
    this.lco = AppBrandPipContainerView.lPy;
    this.lcp = AppBrandPipContainerView.lPz;
    this.cdz = paramaa;
    this.iDU = paramAppBrandPipContainerView;
    this.lbN = paramView;
    this.lbO = paramh;
    this.lbP = paramj;
    AppMethodBeat.o(194504);
  }
  
  final void a(float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    AppMethodBeat.i(176639);
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
    ViewGroup.LayoutParams localLayoutParams = this.iDU.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = j;
    this.iDU.setLayoutParams(localLayoutParams);
    this.iDU.setX(paramInt3 + paramInt1);
    this.iDU.setY(paramInt4 + paramInt2);
    localLayoutParams = this.lbN.getLayoutParams();
    localLayoutParams.width = paramInt5;
    localLayoutParams.height = paramInt6;
    this.lbN.setLayoutParams(localLayoutParams);
    this.iDU.b(paramInt5, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12);
    AppMethodBeat.o(176639);
  }
  
  final void aA(float paramFloat)
  {
    AppMethodBeat.i(176637);
    if (!this.lbQ)
    {
      ad.w(this.cjP, "handleVideoTransferProgress, false == mHandleStarted");
      AppMethodBeat.o(176637);
      return;
    }
    this.lcq = (this.lbS + (int)(paramFloat / 100.0F * (this.lce - this.lbS)));
    this.lcr = (this.lbT + (int)(paramFloat / 100.0F * (this.lcf - this.lbT)));
    this.lcs = (this.lbU + (int)(paramFloat / 100.0F * (this.lcg - this.lbU)));
    this.lct = (this.lbV + (int)(paramFloat / 100.0F * (this.lch - this.lbV)));
    this.lcu = (this.lbW + (int)(paramFloat / 100.0F * (this.lci - this.lbW)));
    this.lcv = (this.lbX + (int)(paramFloat / 100.0F * (this.lcj - this.lbX)));
    this.lcw = ((int)Math.ceil(0.5F * (this.lcq - this.lcu)));
    this.lcx = ((int)Math.ceil(0.4F * (this.lcr - this.lcv)));
    this.lcy = ((int)Math.ceil(0.6F * (this.lcr - this.lcv)));
    this.lcz = (this.lcb + (int)(paramFloat / 100.0F * (this.lcn - this.lcb)));
    this.lcA = (this.lcc + (int)(paramFloat / 100.0F * (this.lco - this.lcc)));
    this.lcB = (this.lcd + (int)(paramFloat / 100.0F * (this.lcp - this.lcd)));
    a(paramFloat, this.lcq, this.lcr, this.lcs, this.lct, this.lcu, this.lcv, this.lcw, this.lcx, this.lcy, this.lcz, this.lcA, this.lcB);
    AppMethodBeat.o(176637);
  }
  
  final Point bkh()
  {
    AppMethodBeat.i(176638);
    Object localObject = this.cdz.kWU;
    if (localObject == null)
    {
      ad.w(this.cjP, "calculateWebView2PipContainerParentOffset, null == appBrandWebView");
      AppMethodBeat.o(176638);
      return null;
    }
    localObject = ((bd)localObject).getContentView();
    if (localObject == null)
    {
      ad.w(this.cjP, "calculateWebView2PipContainerParentOffset, null == webView");
      AppMethodBeat.o(176638);
      return null;
    }
    ViewParent localViewParent = this.iDU.getParent();
    if (!(localViewParent instanceof ViewGroup))
    {
      ad.w(this.cjP, "calculateWebView2PipContainerParentOffset, viewParent is not ViewGroup");
      AppMethodBeat.o(176638);
      return null;
    }
    ViewGroup localViewGroup = (ViewGroup)localViewParent;
    this.mScreenWidth = localViewGroup.getWidth();
    this.mScreenHeight = localViewGroup.getHeight();
    ad.d(this.cjP, "calculateWebView2PipContainerParentOffset, mScreenWidth: %d, mScreenHeight: %d", new Object[] { Integer.valueOf(this.mScreenWidth), Integer.valueOf(this.mScreenHeight) });
    localViewParent = ((View)localObject).getParent();
    int i = 0;
    int j = 0;
    while (localViewParent != null)
    {
      if (!(localViewParent instanceof ViewGroup))
      {
        ad.w(this.cjP, "calculateWebView2PipContainerParentOffset, parent is not ViewGroup");
        AppMethodBeat.o(176638);
        return null;
      }
      j = (int)(j + ((View)localObject).getX());
      float f = i;
      i = (int)(((View)localObject).getY() + f);
      if (localViewParent == localViewGroup)
      {
        ad.d(this.cjP, "calculateWebView2PipContainerParentOffset, offsetX: %d, offsetY: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        localObject = new Point(j, i);
        AppMethodBeat.o(176638);
        return localObject;
      }
      localObject = (View)localViewParent;
      localViewParent = ((View)localObject).getParent();
    }
    AppMethodBeat.o(176638);
    return null;
  }
  
  final boolean gC(boolean paramBoolean)
  {
    AppMethodBeat.i(194505);
    final int i = this.lbP.getVideoWidth();
    final int j = this.lbP.getVideoHeight();
    if ((i == 0) || (j == 0))
    {
      ad.w(this.cjP, "handleVideoPage2PipStart, 0 == realVideoWidth || 0 == reaVideoHeight");
      AppMethodBeat.o(194505);
      return false;
    }
    Object localObject = bkh();
    if (localObject == null)
    {
      ad.w(this.cjP, "handleVideoPage2PipStart, null == webView2PipContainerParentOffset");
      AppMethodBeat.o(194505);
      return false;
    }
    final Point localPoint1 = new Point();
    localObject = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194502);
        if (af.this.lbQ)
        {
          ad.i(af.this.cjP, "handleVideoPage2PipStart, true == mHandleStarted");
          AppMethodBeat.o(194502);
          return;
        }
        int j = af.this.lbO.bbC();
        int k = af.this.lbO.bbD();
        int m = localPoint1.x + this.lcE.x;
        int n = localPoint1.y + this.lcE.y;
        ad.i(af.this.cjP, "handleVideoPage2PipStart, originVideoPosX: %d, originVideoPosY: %d", new Object[] { Integer.valueOf(m), Integer.valueOf(n) });
        af.this.iDU.setOnStablePositionChangeListener(af.a(af.this, localPoint1.x, localPoint1.y, this.lcE));
        Object localObject = af.this;
        int i1 = i;
        int i2 = j;
        int i;
        if ((-1 != i1) && (-1 != i2))
        {
          i = 1;
          if (i == 0) {
            break label434;
          }
          if (i1 < i2) {
            break label471;
          }
          i = 1;
        }
        for (;;)
        {
          label205:
          label225:
          g localg;
          if (i != 0)
          {
            ((af)localObject).lce = AppBrandPipContainerView.lPg;
            ((af)localObject).lcf = AppBrandPipContainerView.lPh;
            if ((((af)localObject).lbN instanceof g))
            {
              localg = (g)((af)localObject).lbN;
              if (i == 0) {
                break label463;
              }
            }
          }
          label434:
          label463:
          for (localObject = f.khc;; localObject = f.khd)
          {
            localg.a((f)localObject);
            if (!af.this.iDU.ei(af.this.lce, af.this.lcf)) {
              af.a(af.this, i, j, j, k, m, n);
            }
            af.this.a(0.0F, af.this.lbS, af.this.lbT, af.this.lbU, af.this.lbV, af.this.lbW, af.this.lbX, af.this.lbY, af.this.lbZ, af.this.lca, af.this.lcb, af.this.lcc, af.this.lcd);
            af.this.iDU.setVisibility(0);
            af.this.lbQ = true;
            AppMethodBeat.o(194502);
            return;
            i = 0;
            break;
            if (j < k) {
              break label471;
            }
            i = 1;
            break label205;
            ((af)localObject).lce = AppBrandPipContainerView.lPk;
            ((af)localObject).lcf = AppBrandPipContainerView.lPl;
            break label225;
          }
          label471:
          i = 0;
        }
      }
    };
    if (paramBoolean) {
      this.lbO.a(this.cdz, new h.a()
      {
        public final void dQ(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(194503);
          localPoint1.x = paramAnonymousInt1;
          localPoint1.y = paramAnonymousInt2;
          this.lcH.run();
          AppMethodBeat.o(194503);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(194505);
      return true;
      Point localPoint2 = this.lbO.bbE();
      localPoint1.x = localPoint2.x;
      localPoint1.y = localPoint2.y;
      ((Runnable)localObject).run();
    }
  }
  
  final class a
    implements AppBrandPipContainerView.a
  {
    int cky;
    int ckz;
    Point lcI = null;
    
    private a() {}
    
    public final void bki()
    {
      AppMethodBeat.i(176636);
      ad.d(af.this.cjP, "MyOnStablePositionChangeListener, onStablePositionChange");
      int i = af.this.lbP.getVideoWidth();
      int j = af.this.lbP.getVideoHeight();
      if ((i == 0) || (j == 0))
      {
        ad.w(af.this.cjP, "MyOnStablePositionChangeListener, 0 == realVideoWidth || 0 == reaVideoHeight");
        AppMethodBeat.o(176636);
        return;
      }
      int k = af.this.lbO.bbC();
      int m = af.this.lbO.bbD();
      if (this.lcI == null) {
        this.lcI = af.this.bkh();
      }
      if (this.lcI == null)
      {
        ad.w(af.this.cjP, "MyOnStablePositionChangeListener, null == mWebView2PipContainerParentOffset");
        AppMethodBeat.o(176636);
        return;
      }
      int n = this.cky;
      int i1 = this.ckz;
      i1 = this.lcI.y + i1;
      ad.i(af.this.cjP, "MyOnStablePositionChangeListener, originVideoPosX: %d, originVideoPosY: %d", new Object[] { Integer.valueOf(n), Integer.valueOf(i1) });
      af.a(af.this, i, j, k, m, n, i1);
      AppMethodBeat.o(176636);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.af
 * JD-Core Version:    0.7.0.1
 */