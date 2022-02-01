package com.tencent.mm.plugin.appbrand.pip;

import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.t.e;
import com.tencent.mm.plugin.appbrand.jsapi.t.f;
import com.tencent.mm.plugin.appbrand.jsapi.t.g;
import com.tencent.mm.plugin.appbrand.jsapi.t.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.t.i;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.page.bd;
import com.tencent.mm.plugin.appbrand.utils.ab;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView;
import com.tencent.mm.plugin.appbrand.widget.AppBrandPipContainerView.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public final String cED;
  public final ad cvo;
  int mScreenHeight;
  int mScreenWidth;
  final AppBrandPipContainerView nud;
  volatile boolean pKR;
  int qEA;
  int qEB;
  int qEC;
  int qED;
  int qEE;
  int qEF;
  int qEG;
  private int qEH;
  private int qEI;
  private int qEJ;
  int qEK;
  int qEL;
  int qEM;
  private int qEN;
  private int qEO;
  private int qEP;
  private int qEQ;
  private int qER;
  private int qES;
  private int qET;
  private int qEU;
  private int qEV;
  private int qEW;
  private int qEX;
  private int qEY;
  final View qEj;
  public final g qEk;
  final i qEl;
  final ab qEm;
  public volatile boolean qEn;
  a qEo;
  int qEp;
  int qEq;
  int qEr;
  int qEs;
  int qEt;
  int qEu;
  int qEv;
  int qEw;
  int qEx;
  int qEy;
  int qEz;
  
  b(ad paramad, AppBrandPipContainerView paramAppBrandPipContainerView, View paramView, g paramg, i parami, ab paramab)
  {
    AppMethodBeat.i(246525);
    this.cED = ("MicroMsg.AppBrand.AppBrandPipContainerOnPageSwitchHandler#" + hashCode());
    this.qEn = false;
    this.pKR = false;
    this.qEo = null;
    this.qEH = AppBrandPipContainerView.rmH;
    this.qEI = AppBrandPipContainerView.rmG;
    this.qEJ = AppBrandPipContainerView.rmI;
    this.qEK = AppBrandPipContainerView.rmJ;
    this.qEL = AppBrandPipContainerView.rmK;
    this.qEM = AppBrandPipContainerView.rmL;
    this.cvo = paramad;
    this.nud = paramAppBrandPipContainerView;
    this.qEj = paramView;
    this.qEk = paramg;
    this.qEl = parami;
    this.qEm = paramab;
    AppMethodBeat.o(246525);
  }
  
  final void a(float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12)
  {
    AppMethodBeat.i(246531);
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
    ViewGroup.LayoutParams localLayoutParams = this.nud.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = j;
    this.nud.setLayoutParams(localLayoutParams);
    this.nud.setX(paramInt3 + paramInt1);
    this.nud.setY(paramInt4 + paramInt2);
    localLayoutParams = this.qEj.getLayoutParams();
    localLayoutParams.width = paramInt5;
    localLayoutParams.height = paramInt6;
    this.qEj.setLayoutParams(localLayoutParams);
    this.nud.a(paramInt5, paramInt7, paramInt8, paramInt9, paramInt10, paramInt11, paramInt12);
    AppMethodBeat.o(246531);
  }
  
  final void aS(float paramFloat)
  {
    AppMethodBeat.i(246527);
    if (!this.qEn)
    {
      Log.w(this.cED, "handleVideoTransferProgress, false == mHandleStarted");
      AppMethodBeat.o(246527);
      return;
    }
    this.qEN = (this.qEp + (int)(paramFloat / 100.0F * (this.qEB - this.qEp)));
    this.qEO = (this.qEq + (int)(paramFloat / 100.0F * (this.qEC - this.qEq)));
    this.qEP = (this.qEr + (int)(paramFloat / 100.0F * (this.qED - this.qEr)));
    this.qEQ = (this.qEs + (int)(paramFloat / 100.0F * (this.qEE - this.qEs)));
    this.qER = (this.qEt + (int)(paramFloat / 100.0F * (this.qEF - this.qEt)));
    this.qES = (this.qEu + (int)(paramFloat / 100.0F * (this.qEG - this.qEu)));
    this.qET = ((int)Math.ceil(0.5F * (this.qEN - this.qER)));
    this.qEU = ((int)Math.ceil(0.4F * (this.qEO - this.qES)));
    this.qEV = ((int)Math.ceil(0.6F * (this.qEO - this.qES)));
    this.qEW = (this.qEy + (int)(paramFloat / 100.0F * (this.qEK - this.qEy)));
    this.qEX = (this.qEz + (int)(paramFloat / 100.0F * (this.qEL - this.qEz)));
    this.qEY = (this.qEA + (int)(paramFloat / 100.0F * (this.qEM - this.qEA)));
    a(paramFloat, this.qEN, this.qEO, this.qEP, this.qEQ, this.qER, this.qES, this.qET, this.qEU, this.qEV, this.qEW, this.qEX, this.qEY);
    AppMethodBeat.o(246527);
  }
  
  final void cgJ()
  {
    AppMethodBeat.i(246528);
    Log.i(this.cED, "handleVideoPage2PipEnd");
    if (!this.qEn) {
      ju(false);
    }
    a(100.0F, this.qEB, this.qEC, this.qED, this.qEE, this.qEF, this.qEG, this.qEH, this.qEI, this.qEJ, this.qEK, this.qEL, this.qEM);
    AppMethodBeat.o(246528);
  }
  
  final Point cgK()
  {
    AppMethodBeat.i(246530);
    Object localObject = this.cvo.qoF;
    if (localObject == null)
    {
      Log.w(this.cED, "calculateWebView2PipContainerParentOffset, null == appBrandWebView");
      AppMethodBeat.o(246530);
      return null;
    }
    localObject = ((bd)localObject).getContentView();
    if (localObject == null)
    {
      Log.w(this.cED, "calculateWebView2PipContainerParentOffset, null == webView");
      AppMethodBeat.o(246530);
      return null;
    }
    ViewParent localViewParent = this.nud.getParent();
    if (!(localViewParent instanceof ViewGroup))
    {
      Log.w(this.cED, "calculateWebView2PipContainerParentOffset, viewParent is not ViewGroup");
      AppMethodBeat.o(246530);
      return null;
    }
    ViewGroup localViewGroup = (ViewGroup)localViewParent;
    this.mScreenWidth = localViewGroup.getWidth();
    this.mScreenHeight = localViewGroup.getHeight();
    Log.d(this.cED, "calculateWebView2PipContainerParentOffset, mScreenWidth: %d, mScreenHeight: %d", new Object[] { Integer.valueOf(this.mScreenWidth), Integer.valueOf(this.mScreenHeight) });
    localViewParent = ((View)localObject).getParent();
    int i = 0;
    int j = 0;
    while (localViewParent != null)
    {
      if (!(localViewParent instanceof ViewGroup))
      {
        Log.w(this.cED, "calculateWebView2PipContainerParentOffset, parent is not ViewGroup");
        AppMethodBeat.o(246530);
        return null;
      }
      j = (int)(j + ((View)localObject).getX());
      float f = i;
      i = (int)(((View)localObject).getY() + f);
      if (localViewParent == localViewGroup)
      {
        Log.d(this.cED, "calculateWebView2PipContainerParentOffset, offsetX: %d, offsetY: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(i) });
        localObject = new Point(j, i);
        AppMethodBeat.o(246530);
        return localObject;
      }
      localObject = (View)localViewParent;
      localViewParent = ((View)localObject).getParent();
    }
    AppMethodBeat.o(246530);
    return null;
  }
  
  final boolean ju(boolean paramBoolean)
  {
    AppMethodBeat.i(246529);
    final int i = this.qEl.getVideoWidth();
    final int j = this.qEl.getVideoHeight();
    if ((i == 0) || (j == 0))
    {
      Log.w(this.cED, "handleVideoPage2PipStart, 0 == realVideoWidth || 0 == reaVideoHeight");
      AppMethodBeat.o(246529);
      return false;
    }
    Object localObject = cgK();
    if (localObject == null)
    {
      Log.w(this.cED, "handleVideoPage2PipStart, null == webView2PipContainerParentOffset");
      AppMethodBeat.o(246529);
      return false;
    }
    final Point localPoint1 = new Point();
    localObject = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(243760);
        if (b.this.qEn)
        {
          Log.i(b.this.cED, "handleVideoPage2PipStart, true == mHandleStarted");
          AppMethodBeat.o(243760);
          return;
        }
        int j = b.this.qEk.Ub();
        int k = b.this.qEk.Uc();
        int i = localPoint1.x;
        int m = this.qFb.x;
        int n = localPoint1.y;
        int i1 = this.qFb.y;
        Log.i(b.this.cED, "handleVideoPage2PipStart, originVideoPosX: %d, originVideoPosY: %d", new Object[] { Integer.valueOf(i + m), Integer.valueOf(n + i1) });
        b.this.nud.a(b.a(b.this, localPoint1.x, localPoint1.y, this.qFb));
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
            ((b)localObject).qEB = AppBrandPipContainerView.rms;
            ((b)localObject).qEC = AppBrandPipContainerView.rmt;
            if ((((b)localObject).qEj instanceof f))
            {
              localf = (f)((b)localObject).qEj;
              if (i == 0) {
                break label542;
              }
            }
          }
          label513:
          label542:
          for (localObject = e.plB;; localObject = e.plC)
          {
            localf.a((e)localObject);
            localObject = b.this.nud;
            i = b.this.qEB;
            j = b.this.qEC;
            ((AppBrandPipContainerView)localObject).eZ(((AppBrandPipContainerView)localObject).rmX, i);
            ((AppBrandPipContainerView)localObject).fa(((AppBrandPipContainerView)localObject).rmY, j);
            Log.i("MicroMsg.AppBrand.AppBrandPipContainerView", "adjustStablePos, mStablePosX: " + ((AppBrandPipContainerView)localObject).rmX + ", mStablePosY: " + ((AppBrandPipContainerView)localObject).rmY);
            ((AppBrandPipContainerView)localObject).fb(((AppBrandPipContainerView)localObject).rmX, ((AppBrandPipContainerView)localObject).rmY);
            b.this.a(0.0F, b.this.qEp, b.this.qEq, b.this.qEr, b.this.qEs, b.this.qEt, b.this.qEu, b.this.qEv, b.this.qEw, b.this.qEx, b.this.qEy, b.this.qEz, b.this.qEA);
            b.this.qEn = true;
            if (b.this.qEm != null)
            {
              Log.i(b.this.cED, "handleVideoPage2PipStart, run afterStartTask");
              b.this.qEm.cml();
            }
            AppMethodBeat.o(243760);
            return;
            i = 0;
            break;
            if (j < k) {
              break label550;
            }
            i = 1;
            break label211;
            ((b)localObject).qEB = AppBrandPipContainerView.rmw;
            ((b)localObject).qEC = AppBrandPipContainerView.rmx;
            break label231;
          }
          label550:
          i = 0;
        }
      }
    };
    if (paramBoolean) {
      this.qEk.a(this.cvo, new g.a()
      {
        public final void eD(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(243374);
          if (b.this.pKR)
          {
            Log.i(b.this.cED, "handleVideoPage2PipStart, onVideoPositionGot, released");
            AppMethodBeat.o(243374);
            return;
          }
          localPoint1.x = paramAnonymousInt1;
          localPoint1.y = paramAnonymousInt2;
          this.qFe.run();
          AppMethodBeat.o(243374);
        }
      });
    }
    for (;;)
    {
      AppMethodBeat.o(246529);
      return true;
      Point localPoint2 = this.qEk.bTZ();
      localPoint1.x = localPoint2.x;
      localPoint1.y = localPoint2.y;
      ((Runnable)localObject).run();
    }
  }
  
  final class a
    implements AppBrandPipContainerView.a
  {
    int cFn;
    int cFo;
    Point qFf = null;
    
    private a() {}
    
    public final void eU(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(243593);
      Log.d(b.this.cED, "MyOnStablePositionChangeListener, onStablePositionChange");
      if (b.this.pKR)
      {
        Log.i(b.this.cED, "onStablePositionChange, onVideoPositionGot, released");
        AppMethodBeat.o(243593);
        return;
      }
      int k = b.this.qEl.getVideoWidth();
      int j = b.this.qEl.getVideoHeight();
      if ((k == 0) || (j == 0))
      {
        Log.w(b.this.cED, "MyOnStablePositionChangeListener, 0 == realVideoWidth || 0 == reaVideoHeight");
        AppMethodBeat.o(243593);
        return;
      }
      int m = b.this.qEk.Ub();
      int n = b.this.qEk.Uc();
      if (this.qFf == null) {
        this.qFf = b.this.cgK();
      }
      if (this.qFf == null)
      {
        Log.w(b.this.cED, "MyOnStablePositionChangeListener, null == mWebView2PipContainerParentOffset");
        AppMethodBeat.o(243593);
        return;
      }
      int i2 = this.cFn;
      int i1 = this.cFo + this.qFf.y;
      Log.i(b.this.cED, "MyOnStablePositionChangeListener, originVideoPosX: %d, originVideoPosY: %d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i1) });
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
        localb.qEB = AppBrandPipContainerView.rms;
        localb.qEC = AppBrandPipContainerView.rmt;
        i = AppBrandPipContainerView.rmu;
        paramInt1 = AppBrandPipContainerView.rmv;
        int i3 = localb.nud.getStablePosX();
        int i4 = localb.nud.getStablePosY();
        Log.i(localb.cED, "calculateStablePipContainerSizeAndPosition, stablePosX: %d, stablePosY: %d", new Object[] { Integer.valueOf(i3), Integer.valueOf(i4) });
        localb.qED = Math.min(Math.max(0, i3), localb.mScreenWidth - localb.qEB);
        localb.qEE = Math.min(Math.max(0, i4), localb.mScreenHeight - localb.qEC);
        Log.i(localb.cED, "calculateStablePipContainerSizeAndPosition, mEndPipContainerPosX: %d, mEndPipContainerPosY: %d", new Object[] { Integer.valueOf(localb.qED), Integer.valueOf(localb.qEE) });
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
        localb.qEF = i;
        localb.qEG = ((int)Math.ceil(j * f1));
        label485:
        localb.qEt = m;
        localb.qEu = n;
        Log.d(localb.cED, "calculateStablePipContainerSize, mStartVideoContainerWidth: %d, mStartVideoContainerHeight: %d", new Object[] { Integer.valueOf(localb.qEt), Integer.valueOf(localb.qEu) });
        localb.qEq = ((int)((localb.qEC + 0.0F) / localb.qEG * localb.qEu));
        localb.qEp = ((int)((localb.qEB + 0.0F) / localb.qEF * localb.qEt));
        Log.d(localb.cED, "calculateStablePipContainerSize, mStartPipContainerWidth: %d, mStartPipContainerHeight: %d", new Object[] { Integer.valueOf(localb.qEp), Integer.valueOf(localb.qEq) });
        localb.qEF = i;
        localb.qEG = paramInt1;
        f1 = (localb.qEp + 0.0F) / localb.qEB;
        f2 = (localb.qEq + 0.0F) / localb.qEC;
        Log.d(localb.cED, "calculateStablePipContainerSize, start2EndWidthRatio: %f, start2EndHeightRatio: %f", new Object[] { Float.valueOf(f1), Float.valueOf(f2) });
        j = Math.min(Math.max(i2, -localb.qEp), localb.mScreenWidth);
        k = Math.min(Math.max(i1, -localb.qEq), localb.mScreenHeight);
        Log.d(localb.cED, "calculateStablePipContainerSize, originVideoPosX: %d, originVideoPosY: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k) });
        if (paramInt2 == 0) {
          break label1018;
        }
        localb.qEr = (j - (int)((localb.qEB - i) * f1 / 2.0F));
      }
      for (localb.qEs = (k - (int)((localb.qEC - paramInt1) * f2 / 2.0F));; localb.qEs = ((n - localb.qEu) / 2 + k - (localb.qEq - localb.qEu) / 2))
      {
        localb.qEv = ((int)Math.ceil(0.5F * (localb.qEp - localb.qEt)));
        localb.qEw = ((int)Math.ceil(0.4F * (localb.qEq - localb.qEu)));
        localb.qEx = ((int)Math.ceil(0.6F * (localb.qEq - localb.qEu)));
        localb.qEy = ((int)(localb.qEK * f2));
        localb.qEz = ((int)(localb.qEL * f2));
        localb.qEA = ((int)(localb.qEM * f2));
        AppMethodBeat.o(243593);
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
        localb.qEB = AppBrandPipContainerView.rmw;
        localb.qEC = AppBrandPipContainerView.rmx;
        i = AppBrandPipContainerView.rmy;
        paramInt1 = AppBrandPipContainerView.rmz;
        break label288;
        label993:
        localb.qEF = ((int)Math.ceil(k * f2));
        localb.qEG = paramInt1;
        break label485;
        label1018:
        localb.qEr = ((m - localb.qEt) / 2 + j - (localb.qEp - localb.qEt) / 2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.pip.b
 * JD-Core Version:    0.7.0.1
 */