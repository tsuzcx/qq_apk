package com.tencent.mm.plugin.appbrand.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionCoverImageInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.game.preload.a.a;
import com.tencent.mm.plugin.appbrand.game.preload.ui.BootstrapProgressBar;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.page.capsulebar.d;
import com.tencent.mm.plugin.appbrand.platform.window.c;
import com.tencent.mm.plugin.appbrand.platform.window.e.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.x;

@SuppressLint({"ViewConstructor"})
final class h
  extends com.tencent.mm.ui.statusbar.b
  implements com.tencent.mm.plugin.appbrand.launching.q, ab
{
  private com.tencent.mm.plugin.appbrand.q kBw;
  private ImageView nSS;
  private ImageView nST;
  private ImageView nSU;
  private TextView nSV;
  private LinearLayout nSW;
  private AppBrandCircleProgressView nSX;
  private d nSY;
  private e.b nSZ;
  private TextView nTa;
  private boolean nTb;
  private Runnable nTc;
  private RelativeLayout nTd;
  private boolean nTe;
  private boolean nTf;
  private boolean nTg;
  private int nTh;
  private boolean nTi;
  private int nTj;
  private RelativeLayout nTk;
  private ImageView nTl;
  private BootstrapProgressBar nTm;
  private boolean nTn;
  private boolean nTo;
  private Boolean nTp;
  private boolean nTq;
  
  public h(final Context paramContext, com.tencent.mm.plugin.appbrand.q paramq)
  {
    super(paramContext);
    AppMethodBeat.i(48602);
    this.nSZ = e.b.nEl;
    this.nTc = null;
    this.nTe = false;
    this.nTf = false;
    this.nTg = false;
    this.nTi = false;
    this.nTj = 30;
    this.nTq = false;
    this.kBw = paramq;
    Log.i("MicroMsg.AppBrandGameUILoadingSplash", "init");
    setClickable(true);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(2131493103, this);
    this.nTk = ((RelativeLayout)findViewById(2131296799));
    this.nTl = ((ImageView)findViewById(2131296800));
    this.nTm = ((BootstrapProgressBar)findViewById(2131296801));
    com.tencent.mm.plugin.appbrand.game.preload.e.bDw().dX(999, 1);
    if ((((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.rZF, false)) && (this.kBw != null))
    {
      final long l = Util.currentTicks();
      paramq = this.kBw.bsC();
      if (paramq.cyv.lgU == null)
      {
        paramContext = null;
        if (Util.isNullOrNil(paramContext)) {
          break label1037;
        }
        this.nTe = true;
        Log.i("MicroMsg.AppBrandGameUILoadingSplash", "loadingImgUrl:%s", new Object[] { paramContext });
        com.tencent.mm.plugin.appbrand.game.preload.e.bDw().dX(1000, 1);
        com.tencent.mm.ch.a.post(new Runnable()
        {
          public final void a(final Bitmap paramAnonymousBitmap, final long paramAnonymousLong)
          {
            AppMethodBeat.i(227600);
            Log.i("MicroMsg.AppBrandGameUILoadingSplash", "onLoadingImageLoaded");
            h.a(h.this);
            if (h.b(h.this) != null) {
              m.runOnUiThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(48585);
                  if (paramAnonymousBitmap != null)
                  {
                    h.b(h.this).setImageBitmap(paramAnonymousBitmap);
                    if (h.c(h.this)) {
                      h.d(h.this);
                    }
                    com.tencent.mm.plugin.appbrand.game.preload.e.bDw().dX(1002, (int)Util.ticksToNow(h.1.this.nTr));
                    com.tencent.mm.plugin.appbrand.game.preload.e.bDw().dX(1001, (int)paramAnonymousLong);
                  }
                  AppMethodBeat.o(48585);
                }
              });
            }
            AppMethodBeat.o(227600);
          }
        }
        {
          public final void run()
          {
            AppMethodBeat.i(227601);
            com.tencent.mm.plugin.appbrand.game.preload.a.bDs();
            Object localObject1 = h.e(h.this).mAppId;
            String str1 = paramContext;
            a.a locala = this.nTw;
            String str2;
            Object localObject3;
            if ((!Util.isNullOrNil((String)localObject1)) && (!Util.isNullOrNil(str1)))
            {
              localObject1 = com.tencent.mm.plugin.appbrand.game.preload.a.iIN + "/" + (String)localObject1 + "/";
              FilePathGenerator.checkMkdir((String)localObject1);
              str2 = (String)localObject1 + MD5Util.getMD5String(str1);
              Log.i("MicroMsg.WAGameLoadingImgManager", "loadingImgPath:%s", new Object[] { str2 });
              localObject3 = null;
              localObject1 = null;
              if (!new o(str2).exists()) {}
            }
            else
            {
              try
              {
                localObject3 = s.openRead(str2);
                localObject1 = localObject3;
              }
              catch (FileNotFoundException localFileNotFoundException2)
              {
                for (;;)
                {
                  Log.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localFileNotFoundException2, "", new Object[0]);
                }
              }
              localObject3 = localObject1;
              if (localObject1 == null) {}
            }
            for (;;)
            {
              long l;
              try
              {
                l = ((InputStream)localObject1).available();
                locala.a(BitmapUtil.decodeStream((InputStream)localObject1), l);
                localObject3 = localObject1;
              }
              catch (IOException localIOException1)
              {
                Log.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localIOException1, "read contentLength", new Object[0]);
                localObject4 = localObject1;
                continue;
              }
              Util.qualityClose((Closeable)localObject3);
              AppMethodBeat.o(227601);
              return;
              Object localObject4;
              com.tencent.mm.plugin.appbrand.game.preload.a.dj(str2, str1);
              try
              {
                localObject1 = s.openRead(str2);
                localObject4 = localObject1;
                if (localObject1 == null) {
                  continue;
                }
                try
                {
                  l = ((InputStream)localObject1).available();
                  locala.a(BitmapUtil.decodeStream((InputStream)localObject1), l);
                  localObject4 = localObject1;
                }
                catch (IOException localIOException2)
                {
                  Log.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localIOException2, "read contentLength", new Object[0]);
                  localObject5 = localObject1;
                }
              }
              catch (FileNotFoundException localFileNotFoundException1)
              {
                for (;;)
                {
                  Object localObject5;
                  Log.printErrStackTrace("MicroMsg.WAGameLoadingImgManager", localFileNotFoundException1, "", new Object[0]);
                  Object localObject2 = localObject5;
                }
              }
            }
          }
        });
        if (paramq.cyv.lgU != null) {
          break label1050;
        }
        paramContext = (Context)localObject;
        label274:
        if (Util.isNullOrNil(paramContext)) {
          break label1064;
        }
        this.nTh = Color.parseColor(paramContext);
        this.nTm.setProgressColor(this.nTh);
        Log.i("MicroMsg.AppBrandGameUILoadingSplash", "loadingProgressBarColor:%s", new Object[] { Integer.valueOf(this.nTh) });
        label322:
        this.nTm.setAnimated(true);
        this.nTm.setStriped(true);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48590);
            h.f(h.this);
            Log.i("MicroMsg.AppBrandGameUILoadingSplash", "mCustomSplashScreenDelayTimeEnd");
            if (h.g(h.this)) {
              h.d(h.this);
            }
            AppMethodBeat.o(48590);
          }
        }, 1000L);
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(48591);
            if (h.g(h.this))
            {
              AppMethodBeat.o(48591);
              return;
            }
            h.h(h.this);
            h.i(h.this).setVisibility(0);
            h.j(h.this);
            AppMethodBeat.o(48591);
          }
        }, 2000L);
      }
    }
    else
    {
      label366:
      this.nTd = ((RelativeLayout)findViewById(2131296810));
      this.nSS = ((ImageView)findViewById(2131296805));
      this.nSS.setImageDrawable(com.tencent.mm.modelappbrand.a.a.aXX());
      this.nSV = ((TextView)findViewById(2131296808));
      this.nST = ((ImageView)findViewById(2131296812));
      this.nSU = ((ImageView)findViewById(2131296809));
      this.nSW = ((LinearLayout)findViewById(2131296803));
      this.nTa = ((TextView)findViewById(2131303696));
      this.nSX = ((AppBrandCircleProgressView)findViewById(2131296807));
      this.nSX.setCircleColor(getResources().getColor(2131099657));
      this.nSX.setDotWidth(getResources().getDimensionPixelSize(2131165839));
      this.nSX.setDotColor(getResources().getColor(2131099710));
      this.nSX.setCircleStrokeWidth(getResources().getDimensionPixelSize(2131165838));
      this.nSX.setProgressColor(getResources().getColor(2131099710));
      this.nSX.setProgressWidth(getResources().getDimensionPixelSize(2131165840));
      if (MMApplicationContext.isMainProcess()) {
        this.nSX.setTransitionTimingMs(2147483647);
      }
      paramContext = (RelativeLayout.LayoutParams)this.nSU.getLayoutParams();
      paramq = (RelativeLayout.LayoutParams)this.nST.getLayoutParams();
      this.nSY = new d(getContext());
      localObject = new LinearLayout.LayoutParams(-2, -2);
      ((LinearLayout.LayoutParams)localObject).gravity = 21;
      ((LinearLayout.LayoutParams)localObject).rightMargin = com.tencent.mm.cb.a.aH(getContext(), 2131165795);
      ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cb.a.aH(getContext(), 2131165796);
      this.nSW.addView(this.nSY, (ViewGroup.LayoutParams)localObject);
      if (this.kBw.bsC().originalFlag != 1) {
        break label1095;
      }
      this.nSU.setVisibility(0);
      label731:
      localObject = (RelativeLayout.LayoutParams)this.nTm.getLayoutParams();
      this.nSZ = this.kBw.getWindowAndroid().getOrientationHandler().btm();
      Log.i("MicroMsg.AppBrandGameUILoadingSplash", "mLastDeviceOrientation :%s", new Object[] { this.nSZ });
      if ((this.nSZ != e.b.nEn) && (this.nSZ != e.b.nEo) && (this.nSZ != e.b.nEp) && (this.nSZ != e.b.nEq)) {
        break label1124;
      }
      if (this.nSU.getVisibility() != 0) {
        break label1107;
      }
      paramq.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), 2131165797);
      paramContext.topMargin = com.tencent.mm.cb.a.aH(getContext(), 2131165804);
      this.nSU.setLayoutParams(paramContext);
      label869:
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = com.tencent.mm.cb.a.aH(getContext(), 2131165791);
      ((RelativeLayout.LayoutParams)localObject).width = com.tencent.mm.cb.a.aH(getContext(), 2131165792);
      this.nTm.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.nST.setLayoutParams(paramq);
      S(getResources().getColor(2131099650), true);
      this.nSY.setBackgroundColor(0);
      paramContext = this.nSY;
      if (this.nTp == null) {
        this.nTp = Boolean.valueOf(ao.isDarkMode());
      }
      if (!this.nTp.booleanValue()) {
        break label1220;
      }
    }
    label1037:
    label1050:
    label1064:
    label1220:
    for (int i = -1;; i = -16777216)
    {
      paramContext.setStyleColor(i);
      paramContext = new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(227604);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/ui/AppBrandGameUILoadingSplash$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (h.r(h.this))
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandGameUILoadingSplash$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(227604);
            return;
          }
          com.tencent.mm.plugin.appbrand.h.a(h.e(h.this).mAppId, h.d.kzP);
          h.e(h.this).finish();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/ui/AppBrandGameUILoadingSplash$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(227604);
        }
      };
      this.nSY.setHomeButtonOnClickListener(paramContext);
      y.x(getContext(), true);
      if (!this.nTe) {
        this.nSX.bWT();
      }
      AppMethodBeat.o(48602);
      return;
      paramContext = paramq.cyv.lgU.lgQ;
      break;
      com.tencent.mm.plugin.appbrand.game.preload.e.bDw().dX(1000, 0);
      break label366;
      paramContext = paramq.cyv.lgU.lgR;
      break label274;
      this.nTh = getContext().getResources().getColor(2131099946);
      this.nTm.setProgressColor(this.nTh);
      break label322;
      label1095:
      this.nSU.setVisibility(8);
      break label731;
      label1107:
      paramq.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), 2131165798);
      break label869;
      label1124:
      if (this.nSU.getVisibility() == 0)
      {
        paramq.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), 2131165798);
        paramContext.topMargin = com.tencent.mm.cb.a.aH(getContext(), 2131165806);
        this.nSU.setLayoutParams(paramContext);
      }
      for (;;)
      {
        ((RelativeLayout.LayoutParams)localObject).width = com.tencent.mm.cb.a.aH(getContext(), 2131165794);
        ((RelativeLayout.LayoutParams)localObject).bottomMargin = com.tencent.mm.cb.a.aH(getContext(), 2131165793);
        break;
        paramq.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), 2131165798);
      }
    }
  }
  
  public final void eo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(48603);
    com.tencent.mm.modelappbrand.a.b.aXY().a(this.nSS, paramString1, null, com.tencent.mm.modelappbrand.a.g.iJB);
    this.nSV.setText(paramString2);
    AppMethodBeat.o(48603);
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(48605);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    e.b localb = this.kBw.getWindowAndroid().getOrientationHandler().btm();
    RelativeLayout.LayoutParams localLayoutParams1;
    RelativeLayout.LayoutParams localLayoutParams2;
    RelativeLayout.LayoutParams localLayoutParams3;
    if (localb != this.nSZ)
    {
      this.nSZ = localb;
      localLayoutParams1 = (RelativeLayout.LayoutParams)this.nSU.getLayoutParams();
      localLayoutParams2 = (RelativeLayout.LayoutParams)this.nTm.getLayoutParams();
      localLayoutParams3 = (RelativeLayout.LayoutParams)this.nST.getLayoutParams();
      if ((localb != e.b.nEn) && (localb != e.b.nEo) && (localb != e.b.nEp) && (localb != e.b.nEq)) {
        break label245;
      }
      if (this.nSU.getVisibility() != 0) {
        break label227;
      }
      localLayoutParams3.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), 2131165797);
      localLayoutParams1.topMargin = com.tencent.mm.cb.a.aH(getContext(), 2131165804);
      this.nSU.setLayoutParams(localLayoutParams1);
    }
    for (;;)
    {
      localLayoutParams2.width = com.tencent.mm.cb.a.aH(getContext(), 2131165792);
      localLayoutParams2.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), 2131165791);
      this.nTm.setLayoutParams(localLayoutParams2);
      this.nST.setLayoutParams(localLayoutParams3);
      requestLayout();
      AppMethodBeat.o(48605);
      return;
      label227:
      localLayoutParams3.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), 2131165798);
    }
    label245:
    if (this.nSU.getVisibility() == 0)
    {
      localLayoutParams3.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), 2131165798);
      localLayoutParams1.topMargin = com.tencent.mm.cb.a.aH(getContext(), 2131165806);
      this.nSU.setLayoutParams(localLayoutParams1);
    }
    for (;;)
    {
      localLayoutParams2.width = com.tencent.mm.cb.a.aH(getContext(), 2131165794);
      localLayoutParams2.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), 2131165793);
      break;
      localLayoutParams3.bottomMargin = com.tencent.mm.cb.a.aH(getContext(), 2131165798);
    }
  }
  
  public final void setProgress(int paramInt)
  {
    AppMethodBeat.i(48606);
    if (!this.nTe)
    {
      if (paramInt < 100)
      {
        this.nSX.setProgress(paramInt / 2);
        AppMethodBeat.o(48606);
        return;
      }
      if (!this.nTn)
      {
        this.nTn = true;
        new Timer(true).scheduleAtFixedRate(new b(), 0L, 50L);
        AppMethodBeat.o(48606);
      }
    }
    else if ((!this.nTf) && (this.nTi))
    {
      if (paramInt < 100)
      {
        this.nSX.setProgress(paramInt / 2);
        AppMethodBeat.o(48606);
        return;
      }
      if (!this.nTn)
      {
        this.nTn = true;
        new Timer(true).scheduleAtFixedRate(new b(), 0L, 100L);
        AppMethodBeat.o(48606);
      }
    }
    else if (paramInt < 100)
    {
      if (this.nTk.getVisibility() == 0)
      {
        this.nTm.setProgress(paramInt / 2);
        AppMethodBeat.o(48606);
      }
    }
    else if (!this.nTo)
    {
      this.nTo = true;
      new Timer(true).scheduleAtFixedRate(new a(), 0L, 1000 / this.nTj);
    }
    AppMethodBeat.o(48606);
  }
  
  public final void vy(final int paramInt)
  {
    AppMethodBeat.i(48607);
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48595);
        Log.i("MicroMsg.AppBrandGameUILoadingSplash", "onDataTransferState  state=" + paramInt);
        if (paramInt == 3)
        {
          if (h.l(h.this))
          {
            h.m(h.this).setVisibility(0);
            h.m(h.this).setText(2131756048);
            AppMethodBeat.o(48595);
            return;
          }
          h.a(h.this, this);
        }
        AppMethodBeat.o(48595);
      }
    });
    AppMethodBeat.o(48607);
  }
  
  public final void yu(int paramInt) {}
  
  public final void z(final kotlin.g.a.a<x> parama)
  {
    AppMethodBeat.i(227605);
    this.nTq = true;
    Log.w("MicroMsg.AppBrandGameUILoadingSplash", "animateHide");
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(48592);
        final ViewParent localViewParent = h.this.getParent();
        if (!(localViewParent instanceof ViewGroup))
        {
          Log.i("MicroMsg.AppBrandGameUILoadingSplash", "animateHide, wrong ViewGroup");
          AppMethodBeat.o(48592);
          return;
        }
        h.k(h.this).bWU();
        ViewPropertyAnimator localViewPropertyAnimator = h.this.animate();
        localViewPropertyAnimator.setStartDelay(((float)localViewPropertyAnimator.getDuration() * 0.8F));
        localViewPropertyAnimator.setDuration(((float)localViewPropertyAnimator.getDuration() * 1.0F));
        localViewPropertyAnimator.setListener(new AnimatorListenerAdapter()
        {
          public final void onAnimationEnd(Animator paramAnonymous2Animator)
          {
            AppMethodBeat.i(227603);
            h.this.post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(227602);
                Log.i("MicroMsg.AppBrandGameUILoadingSplash", "animateHide, remove splash");
                h.this.setVisibility(8);
                ((ViewGroup)h.5.1.this.nTy).removeView(h.this);
                if (h.5.this.nTx != null) {
                  h.5.this.nTx.invoke();
                }
                AppMethodBeat.o(227602);
              }
            });
            AppMethodBeat.o(227603);
          }
        });
        localViewPropertyAnimator.alpha(0.0F).start();
        AppMethodBeat.o(48592);
      }
    });
    AppMethodBeat.o(227605);
  }
  
  public final class a
    extends TimerTask
  {
    private float progress = 50.0F;
    
    public a() {}
    
    public final void run()
    {
      AppMethodBeat.i(48599);
      if (this.progress >= 100.0F)
      {
        cancel();
        AppMethodBeat.o(48599);
        return;
      }
      this.progress += 0.33F;
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48598);
          if (h.p(h.this).getVisibility() == 0) {
            h.q(h.this).setProgress(h.a.a(h.a.this));
          }
          AppMethodBeat.o(48598);
        }
      });
      AppMethodBeat.o(48599);
    }
  }
  
  public final class b
    extends TimerTask
  {
    private int progress = 50;
    
    public b() {}
    
    public final void run()
    {
      AppMethodBeat.i(48601);
      if (this.progress >= 100)
      {
        cancel();
        AppMethodBeat.o(48601);
        return;
      }
      this.progress += 1;
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(48600);
          h.k(h.this).setProgress(h.b.a(h.b.this));
          if (h.b.a(h.b.this) == 100)
          {
            h.n(h.this);
            if (h.o(h.this) != null)
            {
              h.o(h.this).run();
              h.a(h.this, null);
            }
          }
          AppMethodBeat.o(48600);
        }
      });
      AppMethodBeat.o(48601);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.h
 * JD-Core Version:    0.7.0.1
 */