package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.3;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.4;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.5;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b;
import com.tencent.mm.plugin.appbrand.z.g;
import com.tencent.mm.plugin.appbrand.z.l.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.vfs.q;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandVideoView
  extends RelativeLayout
{
  private int abb;
  private int asf;
  private boolean chA;
  private boolean chB;
  private boolean chR;
  private boolean ckf;
  private boolean kOA;
  private boolean kOB;
  private double kOC;
  private String kOD;
  private boolean kOE;
  private boolean kOF;
  private boolean kOG;
  private boolean kOH;
  private boolean kOI;
  private int kOJ;
  private String kOK;
  private boolean kOL;
  private boolean kOM;
  private boolean kON;
  private boolean kOO;
  private boolean kOP;
  private au kOQ;
  private int kOR;
  private RelativeLayout kOb;
  public e kOc;
  private TextView kOd;
  private DanmuView kOe;
  public e.a kOf;
  private View kOg;
  private View kOh;
  private TextView kOi;
  private LinearLayout kOj;
  private AppBrandDotPercentIndicator kOk;
  private TextView kOl;
  private ImageView kOm;
  private ImageView kOn;
  private ImageView kOo;
  private ImageView kOp;
  private FrameLayout kOq;
  private String kOr;
  private int kOs;
  private com.tencent.mm.plugin.appbrand.jsapi.c kOt;
  private boolean kOu;
  public com.tencent.mm.plugin.appbrand.jsapi.video.c.b kOv;
  private boolean kOw;
  private boolean kOx;
  private com.tencent.mm.plugin.appbrand.jsapi.video.ui.a kOy;
  private a kOz;
  private int ktv;
  private String mAppId;
  private boolean mIsMute;
  
  public AppBrandVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(137735);
    this.abb = -1;
    this.kON = false;
    this.kOO = true;
    this.kOP = false;
    this.ckf = false;
    this.kOR = 0;
    init(paramContext);
    AppMethodBeat.o(137735);
  }
  
  public AppBrandVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(137736);
    this.abb = -1;
    this.kON = false;
    this.kOO = true;
    this.kOP = false;
    this.ckf = false;
    this.kOR = 0;
    init(paramContext);
    AppMethodBeat.o(137736);
  }
  
  public <T extends View,  extends e> AppBrandVideoView(Context paramContext, T paramT)
  {
    super(paramContext);
    AppMethodBeat.i(137734);
    this.abb = -1;
    this.kON = false;
    this.kOO = true;
    this.kOP = false;
    this.ckf = false;
    this.kOR = 0;
    this.kOc = ((e)paramT);
    init(paramContext);
    this.kOb.addView(paramT);
    AppMethodBeat.o(137734);
  }
  
  private boolean bed()
  {
    AppMethodBeat.i(137791);
    if ((this.kOA) || (this.kOc.bed()))
    {
      AppMethodBeat.o(137791);
      return true;
    }
    AppMethodBeat.o(137791);
    return false;
  }
  
  private void biX()
  {
    AppMethodBeat.i(194096);
    if (this.kOc != null) {
      this.kOc.biX();
    }
    AppMethodBeat.o(194096);
  }
  
  private void biY()
  {
    AppMethodBeat.i(137780);
    this.kOy = new com.tencent.mm.plugin.appbrand.jsapi.video.ui.a(getContext(), this, new a.b()
    {
      public final void aA(float paramAnonymousFloat)
      {
        AppMethodBeat.i(194077);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(194077);
          return;
        }
        ac.d("MicroMsg.Video.AppBrandVideoView", "onAdjustBrightness:".concat(String.valueOf(paramAnonymousFloat)));
        AppBrandVideoView.o(AppBrandVideoView.this).setPercent(paramAnonymousFloat);
        AppBrandVideoView.p(AppBrandVideoView.this).setText(2131760998);
        AppBrandVideoView.q(AppBrandVideoView.this).setImageResource(2131231033);
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(0);
        AppBrandVideoView.j(AppBrandVideoView.this);
        AppMethodBeat.o(194077);
      }
      
      public final void az(float paramAnonymousFloat)
      {
        AppMethodBeat.i(194076);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(194076);
          return;
        }
        ac.d("MicroMsg.Video.AppBrandVideoView", "onAdjustVolume:".concat(String.valueOf(paramAnonymousFloat)));
        AppBrandVideoView.o(AppBrandVideoView.this).setPercent(paramAnonymousFloat);
        AppBrandVideoView.p(AppBrandVideoView.this).setText(2131760999);
        AppBrandVideoView.q(AppBrandVideoView.this).setImageResource(2131231041);
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(0);
        AppBrandVideoView.j(AppBrandVideoView.this);
        AppMethodBeat.o(194076);
      }
      
      public final void bjj()
      {
        AppMethodBeat.i(194070);
        ac.d("MicroMsg.Video.AppBrandVideoView", "onSingleTap");
        if ((AppBrandVideoView.f(AppBrandVideoView.this)) && (AppBrandVideoView.g(AppBrandVideoView.this).getVisibility() != 0))
        {
          AppBrandVideoView.h(AppBrandVideoView.this).bju();
          if (AppBrandVideoView.i(AppBrandVideoView.this)) {
            AppBrandVideoView.j(AppBrandVideoView.this);
          }
        }
        AppMethodBeat.o(194070);
      }
      
      public final void bjk()
      {
        AppMethodBeat.i(194071);
        ac.d("MicroMsg.Video.AppBrandVideoView", "onDoubleTap");
        if (AppBrandVideoView.k(AppBrandVideoView.this))
        {
          if (AppBrandVideoView.b(AppBrandVideoView.this).isPlaying())
          {
            AppBrandVideoView.this.pause();
            AppMethodBeat.o(194071);
            return;
          }
          AppBrandVideoView.this.start();
        }
        AppMethodBeat.o(194071);
      }
      
      public final void bjl()
      {
        AppMethodBeat.i(194072);
        if (!AppBrandVideoView.l(AppBrandVideoView.this))
        {
          AppMethodBeat.o(194072);
          return;
        }
        AppBrandVideoView.m(AppBrandVideoView.this).setVisibility(0);
        AppBrandVideoView.j(AppBrandVideoView.this);
        AppMethodBeat.o(194072);
      }
      
      public final void bjm()
      {
        AppMethodBeat.i(194078);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(194078);
          return;
        }
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.n(AppBrandVideoView.this);
        AppMethodBeat.o(194078);
      }
      
      public final void bjn()
      {
        AppMethodBeat.i(194079);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(194079);
          return;
        }
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.n(AppBrandVideoView.this);
        AppMethodBeat.o(194079);
      }
      
      public final boolean bjo()
      {
        AppMethodBeat.i(210399);
        boolean bool = AppBrandVideoView.s(AppBrandVideoView.this);
        AppMethodBeat.o(210399);
        return bool;
      }
      
      public final boolean bjp()
      {
        AppMethodBeat.i(210400);
        boolean bool = AppBrandVideoView.s(AppBrandVideoView.this);
        AppMethodBeat.o(210400);
        return bool;
      }
      
      public final boolean bjq()
      {
        AppMethodBeat.i(194082);
        boolean bool = AppBrandVideoView.l(AppBrandVideoView.this);
        AppMethodBeat.o(194082);
        return bool;
      }
      
      public final int getCurrentPosition()
      {
        AppMethodBeat.i(194075);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getCurrPosSec();
        AppMethodBeat.o(194075);
        return i;
      }
      
      public final int j(int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(194073);
        if (!AppBrandVideoView.l(AppBrandVideoView.this))
        {
          AppMethodBeat.o(194073);
          return 0;
        }
        ac.i("MicroMsg.Video.AppBrandVideoView", "onDragProgress:" + paramAnonymousInt + "/" + paramAnonymousFloat);
        paramAnonymousInt = AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec();
        int i = com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.a.c(paramAnonymousFloat, AppBrandVideoView.this.getMeasuredWidth(), getCurrentPosition(), paramAnonymousInt);
        String str = r.qn(paramAnonymousInt * 1000L);
        AppBrandVideoView.m(AppBrandVideoView.this).setText(r.qn(i * 1000L) + "/" + str);
        AppBrandVideoView.h(AppBrandVideoView.this).seek(i);
        if (AppBrandVideoView.h(AppBrandVideoView.this).bjw()) {
          AppBrandVideoView.h(AppBrandVideoView.this).bjC();
        }
        AppMethodBeat.o(194073);
        return i;
      }
      
      public final void k(int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(194074);
        if (!AppBrandVideoView.l(AppBrandVideoView.this))
        {
          AppMethodBeat.o(194074);
          return;
        }
        AppBrandVideoView.m(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.n(AppBrandVideoView.this);
        ac.i("MicroMsg.Video.AppBrandVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(AppBrandVideoView.b(AppBrandVideoView.this).getCurrPosSec()), Float.valueOf(paramAnonymousFloat) });
        AppBrandVideoView.this.d(paramAnonymousInt, false);
        AppMethodBeat.o(194074);
      }
    });
    AppMethodBeat.o(137780);
  }
  
  private void biZ()
  {
    AppMethodBeat.i(137781);
    this.kOf.biZ();
    AppMethodBeat.o(137781);
  }
  
  private void bja()
  {
    AppMethodBeat.i(137782);
    this.kOc.setIMMVideoViewCallback(new AppBrandVideoView.11(this));
    AppMethodBeat.o(137782);
  }
  
  private void bjc()
  {
    AppMethodBeat.i(137786);
    this.kOe = ((DanmuView)findViewById(2131298920));
    this.kOe.setDanmuViewCallBack(new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.c()
    {
      public final int aDG()
      {
        AppMethodBeat.i(194091);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getCurrPosSec();
        AppMethodBeat.o(194091);
        return i;
      }
    });
    this.kOe.bkv();
    this.kOe.setMaxRunningPerRow(5);
    this.kOe.setPickItemInterval(200);
    this.kOe.hide();
    if ((this.kOc != null) && (((View)this.kOc).getHeight() > 0))
    {
      float f = this.kOe.getYOffset();
      int i = (int)(((View)this.kOc).getHeight() * f);
      f = com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b.dz(getContext());
      this.kOe.setMaxRow((int)(i / f));
    }
    AppMethodBeat.o(137786);
  }
  
  private boolean bjd()
  {
    AppMethodBeat.i(137792);
    if ((this.kOF) && (!this.kOc.bed()) && (!bjf()))
    {
      AppMethodBeat.o(137792);
      return true;
    }
    AppMethodBeat.o(137792);
    return false;
  }
  
  private boolean bje()
  {
    AppMethodBeat.i(137793);
    if ((!bjf()) && (((!bjb()) && (this.kOw)) || ((bjb()) && (this.kOx))))
    {
      AppMethodBeat.o(137793);
      return true;
    }
    AppMethodBeat.o(137793);
    return false;
  }
  
  private boolean bjf()
  {
    AppMethodBeat.i(137794);
    if (this.kOg.getVisibility() == 0)
    {
      AppMethodBeat.o(137794);
      return true;
    }
    AppMethodBeat.o(137794);
    return false;
  }
  
  private void bjg()
  {
    AppMethodBeat.i(194099);
    if (this.kOQ != null) {
      this.kOQ.stopTimer();
    }
    AppMethodBeat.o(194099);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(137737);
    LayoutInflater.from(paramContext).inflate(2131493072, this);
    setBackgroundColor(-16777216);
    this.kOb = ((RelativeLayout)findViewById(2131306410));
    this.kOd = ((TextView)findViewById(2131303515));
    this.kOg = findViewById(2131298814);
    this.kOh = findViewById(2131298828);
    this.kOi = ((TextView)findViewById(2131298832));
    this.kOj = ((LinearLayout)findViewById(2131296505));
    this.kOk = ((AppBrandDotPercentIndicator)findViewById(2131296506));
    this.kOl = ((TextView)findViewById(2131296502));
    this.kOm = ((ImageView)findViewById(2131296504));
    this.kOn = ((ImageView)findViewById(2131298813));
    this.kOo = ((ImageView)findViewById(2131303297));
    this.kOp = ((ImageView)findViewById(2131303296));
    this.kOq = ((FrameLayout)findViewById(2131303298));
    this.kOk.setDotsNum(8);
    ((ImageView)findViewById(2131298827)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(137698);
        AppBrandVideoView.this.start();
        AppMethodBeat.o(137698);
      }
    });
    biY();
    bja();
    AppMethodBeat.o(137737);
  }
  
  private static String sN(int paramInt)
  {
    AppMethodBeat.i(137788);
    String str = sO(paramInt / 60) + ":" + sO(paramInt % 60);
    AppMethodBeat.o(137788);
    return str;
  }
  
  private static String sO(int paramInt)
  {
    AppMethodBeat.i(137789);
    if (paramInt < 10)
    {
      String str = "0".concat(String.valueOf(paramInt));
      AppMethodBeat.o(137789);
      return str;
    }
    AppMethodBeat.o(137789);
    return String.valueOf(paramInt);
  }
  
  private void setCover(final String paramString)
  {
    AppMethodBeat.i(137761);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(137761);
      return;
    }
    if (!bs.isNullOrNil(this.kOD))
    {
      ac.i("MicroMsg.Video.AppBrandVideoView", "setCover mCoverUrl not null");
      AppMethodBeat.o(137761);
      return;
    }
    com.tencent.mm.plugin.appbrand.z.l.bxj().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(194068);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(194067);
            if ((this.val$bitmap != null) && (!this.val$bitmap.isRecycled())) {
              AppBrandVideoView.a(AppBrandVideoView.this).setImageBitmap(this.val$bitmap);
            }
            AppMethodBeat.o(194067);
          }
        });
        AppMethodBeat.o(194068);
      }
    });
    AppMethodBeat.o(137761);
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(137787);
    this.kOf = parama;
    if (((this.kOf instanceof View)) && (this.kOf != null))
    {
      parama = (View)this.kOf;
      if (parama.getId() != -1) {
        parama.setId(2131296841);
      }
    }
    this.kOf.hide();
    this.kOf.setFullScreenBtnOnClickListener(new AppBrandVideoView.13(this));
    this.kOf.setIplaySeekCallback(new e.d()
    {
      public final void anR()
      {
        AppMethodBeat.i(194093);
        ac.i("MicroMsg.Video.AppBrandVideoView", "onSeekPre");
        AppMethodBeat.o(194093);
      }
      
      public final void nn(int paramAnonymousInt)
      {
        AppMethodBeat.i(194094);
        AppBrandVideoView.this.d(paramAnonymousInt, false);
        AppMethodBeat.o(194094);
      }
    });
    this.kOf.setOnPlayButtonClickListener(new AppBrandVideoView.15(this));
    this.kOf.setStatePorter(new e.i()
    {
      public final int bjh()
      {
        AppMethodBeat.i(194061);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getCacheTimeSec();
        AppMethodBeat.o(194061);
        return i;
      }
      
      public final int bji()
      {
        AppMethodBeat.i(194062);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec();
        AppMethodBeat.o(194062);
        return i;
      }
    });
    this.kOf.setMuteBtnOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(194063);
        paramAnonymousView = AppBrandVideoView.this;
        if (!AppBrandVideoView.I(AppBrandVideoView.this)) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setMute(bool);
          AppMethodBeat.o(194063);
          return;
        }
      }
    });
    this.kOf.setExitFullScreenBtnOnClickListener(new AppBrandVideoView.4(this));
    this.kOf.a(new e.f()
    {
      public final void onVisibilityChanged(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(194064);
        AppBrandVideoView.G(AppBrandVideoView.this);
        AppMethodBeat.o(194064);
      }
    });
    this.kOf.setOnUpdateProgressLenListener(new e.e()
    {
      public final void onProgressChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(194065);
        if (paramAnonymousInt2 <= 0)
        {
          AppMethodBeat.o(194065);
          return;
        }
        if (paramAnonymousInt1 < 0) {
          paramAnonymousInt1 = 0;
        }
        for (;;)
        {
          int i = paramAnonymousInt1;
          if (paramAnonymousInt1 > paramAnonymousInt2) {
            i = paramAnonymousInt2;
          }
          paramAnonymousInt1 = i * AppBrandVideoView.J(AppBrandVideoView.this).getWidth() / paramAnonymousInt2;
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)AppBrandVideoView.K(AppBrandVideoView.this).getLayoutParams();
          localLayoutParams.width = paramAnonymousInt1;
          AppBrandVideoView.K(AppBrandVideoView.this).setLayoutParams(localLayoutParams);
          AppBrandVideoView.K(AppBrandVideoView.this).requestLayout();
          AppMethodBeat.o(194065);
          return;
        }
      }
    });
    AppMethodBeat.o(137787);
  }
  
  public final boolean bjb()
  {
    AppMethodBeat.i(137785);
    if (this.kOz == null)
    {
      ac.w("MicroMsg.Video.AppBrandVideoView", "isInFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(137785);
      return false;
    }
    boolean bool = this.kOz.isFullScreen();
    AppMethodBeat.o(137785);
    return bool;
  }
  
  public final void clean()
  {
    AppMethodBeat.i(137756);
    ac.i("MicroMsg.Video.AppBrandVideoView", "clean");
    stop();
    this.kOc.onUIDestroy();
    if (this.kOe != null) {
      this.kOe.clear();
    }
    this.kOf.onDestroy();
    bjg();
    AppMethodBeat.o(137756);
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(137758);
    int i = this.kOc.getCurrPosSec();
    ac.i("MicroMsg.Video.AppBrandVideoView", "seek to position=%s current=%d isLive=%b", new Object[] { Double.valueOf(paramDouble), Integer.valueOf(i), Boolean.valueOf(this.kOA) });
    if (bed())
    {
      AppMethodBeat.o(137758);
      return;
    }
    this.kOg.setVisibility(8);
    if (paramBoolean) {
      this.kOc.c(paramDouble, paramBoolean);
    }
    for (;;)
    {
      if ((this.kOe != null) && (i > paramDouble))
      {
        DanmuView localDanmuView = this.kOe;
        i = (int)paramDouble;
        ac.i("MicroMsg.DanmuView", "seekToPlayTime playTime=%d", new Object[] { Integer.valueOf(i) });
        localDanmuView.bkr();
        localDanmuView.clearItems();
        localDanmuView.prepare();
        h.JZN.aS(new DanmuView.5(localDanmuView, i));
      }
      AppMethodBeat.o(137758);
      return;
      this.kOc.o(paramDouble);
    }
  }
  
  public final boolean dn(String arg1, String paramString2)
  {
    AppMethodBeat.i(137779);
    if (this.kOe == null)
    {
      ac.w("MicroMsg.Video.AppBrandVideoView", " addDanmaku mDanmakuView null");
      bjc();
    }
    int j = g.Rq(paramString2);
    int i = j;
    if (j == 0) {
      i = -1;
    }
    paramString2 = new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a(getContext(), new SpannableString(???), i, this.kOc.getCurrPosSec());
    DanmuView localDanmuView = this.kOe;
    synchronized (localDanmuView.kSX)
    {
      localDanmuView.kSX.offerFirst(paramString2);
      h.JZN.f(new DanmuView.3(localDanmuView, paramString2), "DanmuView-addItemToWaitingHead");
      AppMethodBeat.o(137779);
      return true;
    }
  }
  
  public final void e(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(137757);
    String str = paramString;
    if (this.kOt != null)
    {
      str = paramString;
      if (this.kOt.DH() != null)
      {
        str = paramString;
        if (this.kOt.DH().Ie(paramString))
        {
          paramString = this.kOt.DH().IS(paramString);
          if (paramString != null) {
            break label124;
          }
        }
      }
    }
    label124:
    for (paramString = null;; paramString = "file://" + q.B(paramString.fxV()))
    {
      str = paramString;
      ac.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath path=%s isLive=%s", new Object[] { str, Boolean.valueOf(paramBoolean) });
      if (!bs.isNullOrNil(str)) {
        break;
      }
      ac.v("MicroMsg.Video.AppBrandVideoView", "setVideoPath videoPath empty");
      AppMethodBeat.o(137757);
      return;
    }
    stop();
    this.kOA = paramBoolean;
    this.kOK = str;
    this.kOc.setVideoSource(this.kOJ);
    this.kOc.c(paramBoolean, str, paramInt);
    if (this.kOC > 0.0D) {
      this.kOc.c(this.kOC, this.chR);
    }
    Object localObject;
    if ((this.kOJ == 1) && (com.tencent.luggage.a.e.K(l.class) != null))
    {
      localObject = ((l)com.tencent.luggage.a.e.K(l.class)).Ni(this.kOK);
      if (localObject != null)
      {
        ac.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath localVideoPath:%s", new Object[] { localObject });
        paramString = this.kOK;
        ac.i("MicroMsg.Video.AppBrandVideoView", "leonlad setPreLoadVideoPath %s", new Object[] { localObject });
        if ((!this.kOc.isPlaying()) && (this.kOK.equalsIgnoreCase(paramString)))
        {
          this.kOK = paramString;
          this.kOc.c(this.kOA, (String)localObject, 0);
          if (!this.chR) {
            break label452;
          }
          ac.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay true");
          start();
        }
      }
    }
    for (;;)
    {
      if (this.kOv != null) {
        localObject = this.kOv;
      }
      try
      {
        JSONObject localJSONObject = ((com.tencent.mm.plugin.appbrand.jsapi.video.c.b)localObject).bkx();
        localJSONObject.put("timeStamp", System.currentTimeMillis());
        localJSONObject.put("url", paramString);
        ((com.tencent.mm.plugin.appbrand.jsapi.video.c.b)localObject).a(new b.a((byte)0), localJSONObject);
        if (this.chR)
        {
          ac.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay true");
          start();
          setCover(str);
          AppMethodBeat.o(137757);
          return;
          label452:
          ac.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay false");
          biX();
        }
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          ac.e("MicroMsg.Video.JsApiVideoCallback", "onVideoCanPlay e=%s", new Object[] { paramString });
          continue;
          ac.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay false");
          biX();
        }
      }
    }
  }
  
  public final void gI(boolean paramBoolean)
  {
    AppMethodBeat.i(137765);
    ac.i("MicroMsg.Video.AppBrandVideoView", "enableProgressGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOF = paramBoolean;
    AppMethodBeat.o(137765);
  }
  
  public final void gJ(boolean paramBoolean)
  {
    AppMethodBeat.i(137790);
    if (this.kOv == null)
    {
      AppMethodBeat.o(137790);
      return;
    }
    this.kOv.c(this.kOs, paramBoolean, this.ktv);
    AppMethodBeat.o(137790);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(137773);
    if (this.kOc != null)
    {
      int i = this.kOc.getCacheTimeSec();
      AppMethodBeat.o(137773);
      return i;
    }
    AppMethodBeat.o(137773);
    return 0;
  }
  
  public com.tencent.mm.plugin.appbrand.jsapi.video.c.b getCallback()
  {
    return this.kOv;
  }
  
  public String getCookieData()
  {
    return this.kOr;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(137772);
    int i = this.kOc.getCurrPosMs();
    AppMethodBeat.o(137772);
    return i;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(137771);
    int i = this.kOc.getCurrPosSec();
    AppMethodBeat.o(137771);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(137748);
    if (this.asf > 0)
    {
      i = this.asf;
      AppMethodBeat.o(137748);
      return i;
    }
    int i = this.kOc.getVideoDurationSec();
    AppMethodBeat.o(137748);
    return i;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(137783);
    if (this.kOM) {
      bool = true;
    }
    while (bool)
    {
      if (this.kOy != null) {
        this.kOy.y(paramMotionEvent);
      }
      AppMethodBeat.o(137783);
      return true;
      bool = bjd();
      if (!bje()) {
        bool = false;
      }
    }
    if ((paramMotionEvent.getAction() == 0) && (this.kOu) && (this.kOg.getVisibility() != 0))
    {
      this.kOf.bju();
      if (this.kOL) {
        biZ();
      }
    }
    if (this.kOE)
    {
      AppMethodBeat.o(137783);
      return true;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(137783);
    return bool;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(137755);
    ac.i("MicroMsg.Video.AppBrandVideoView", "onUIDestroy");
    clean();
    AppMethodBeat.o(137755);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(137753);
    ac.i("MicroMsg.Video.AppBrandVideoView", "onUIResume");
    if (this.kON)
    {
      ac.i("MicroMsg.Video.AppBrandVideoView", "onUIResume, should skip ui resume");
      this.kON = false;
      AppMethodBeat.o(137753);
      return;
    }
    this.kOc.onUIResume();
    AppMethodBeat.o(137753);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137751);
    ac.i("MicroMsg.Video.AppBrandVideoView", "pause");
    if (!this.kOc.isPlaying())
    {
      ac.i("MicroMsg.Video.AppBrandVideoView", "pause, video not playing");
      AppMethodBeat.o(137751);
      return;
    }
    if (!this.kOP)
    {
      ac.i("MicroMsg.Video.AppBrandVideoView", "pause, video not prepared");
      this.ckf = false;
      AppMethodBeat.o(137751);
      return;
    }
    this.kOc.pause();
    if ((this.kOe != null) && (this.kOf.bjt())) {
      this.kOe.pause();
    }
    AppMethodBeat.o(137751);
  }
  
  public final void q(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(137784);
    ac.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen toFullScreen:%b direction:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.kOz == null)
    {
      ac.w("MicroMsg.Video.AppBrandVideoView", "operateFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(137784);
      return;
    }
    if (paramBoolean == bjb())
    {
      ac.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen current same");
      AppMethodBeat.o(137784);
      return;
    }
    if (paramInt == -1) {
      if (this.abb == -1)
      {
        paramInt = 90;
        ac.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen target direction:%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        this.ktv = paramInt;
        this.kOz.sC(paramInt);
        this.kOf.bjx();
        gJ(true);
        AppMethodBeat.o(137784);
        return;
        paramInt = this.abb;
        break;
      }
      this.kOz.bha();
      this.kOf.bha();
      AppMethodBeat.o(137784);
      return;
    }
  }
  
  public final void sM(int paramInt)
  {
    AppMethodBeat.i(137754);
    ac.i("MicroMsg.Video.AppBrandVideoView", "onUIPause, type:%d", new Object[] { Integer.valueOf(paramInt) });
    if (((paramInt == 2) && (!this.chB)) || ((paramInt == 1) && (!this.chA)))
    {
      ac.i("MicroMsg.Video.AppBrandVideoView", "onUIPause, should skip ui pause");
      this.kON = true;
      AppMethodBeat.o(137754);
      return;
    }
    this.kOc.onUIPause();
    AppMethodBeat.o(137754);
  }
  
  public void setAutoPauseIfNavigate(boolean paramBoolean)
  {
    this.chA = paramBoolean;
  }
  
  public void setAutoPauseIfOpenNative(boolean paramBoolean)
  {
    this.chB = paramBoolean;
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(137745);
    ac.i("MicroMsg.Video.AppBrandVideoView", "setAutoPlay %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.chR = paramBoolean;
    AppMethodBeat.o(137745);
  }
  
  public void setCallback(com.tencent.mm.plugin.appbrand.jsapi.video.c.b paramb)
  {
    this.kOv = paramb;
  }
  
  public void setComponent(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(137738);
    this.kOt = paramc;
    this.mAppId = paramc.getAppId();
    AppMethodBeat.o(137738);
  }
  
  public void setConsumeTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(137739);
    ac.i("MicroMsg.Video.AppBrandVideoView", "setConsumeTouchEvent game=%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOE = paramBoolean;
    AppMethodBeat.o(137739);
  }
  
  public void setCookieData(String paramString)
  {
    this.kOr = paramString;
  }
  
  public final void setCover$16da05f7(String paramString)
  {
    AppMethodBeat.i(137760);
    ac.i("MicroMsg.Video.AppBrandVideoView", "setCover:%s", new Object[] { paramString });
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(137760);
      return;
    }
    this.kOD = paramString;
    com.tencent.mm.modelappbrand.a.b.aAS().a(this.kOn, paramString, null, null);
    AppMethodBeat.o(137760);
  }
  
  public void setDanmakuEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(137767);
    ac.i("MicroMsg.Video.AppBrandVideoView", "setDanmakuEnable %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOf.setDanmakuBtnOpen(paramBoolean);
    AppMethodBeat.o(137767);
  }
  
  public void setDanmakuItemList(JSONArray paramJSONArray)
  {
    AppMethodBeat.i(137778);
    if (paramJSONArray == null)
    {
      AppMethodBeat.o(137778);
      return;
    }
    int i;
    ArrayList localArrayList;
    if (paramJSONArray != null)
    {
      i = paramJSONArray.length();
      ac.i("MicroMsg.Video.AppBrandVideoView", "setDanmakuItemList length=%d", new Object[] { Integer.valueOf(i) });
      if (this.kOe == null)
      {
        ac.w("MicroMsg.Video.AppBrandVideoView", "setDanmakuItemList mDanmakuView null");
        bjc();
      }
      localArrayList = new ArrayList();
      i = 0;
      label75:
      if (i >= paramJSONArray.length()) {
        break label203;
      }
      localObject = paramJSONArray.optJSONObject(i);
      if (localObject != null) {
        break label125;
      }
    }
    label125:
    int m;
    String str;
    int j;
    for (Object localObject = null;; localObject = new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a(getContext(), new SpannableString(str), j, m))
    {
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      i += 1;
      break label75;
      i = 0;
      break;
      m = ((JSONObject)localObject).optInt("time", 0);
      str = ((JSONObject)localObject).optString("text", "");
      int k = g.Rq(((JSONObject)localObject).optString("color", ""));
      j = k;
      if (k == 0) {
        j = -1;
      }
    }
    label203:
    paramJSONArray = this.kOe;
    paramJSONArray.bkr();
    paramJSONArray.clearItems();
    paramJSONArray.kSY.clear();
    paramJSONArray.prepare();
    if (localArrayList.isEmpty())
    {
      paramJSONArray.bks();
      AppMethodBeat.o(137778);
      return;
    }
    h.JZN.aV(new DanmuView.4(paramJSONArray, localArrayList));
    paramJSONArray.bks();
    AppMethodBeat.o(137778);
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(137747);
    if (paramInt <= 0)
    {
      ac.i("MicroMsg.Video.AppBrandVideoView", "setDuration error duration=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137747);
      return;
    }
    this.kOi.setText(sN(paramInt));
    this.asf = paramInt;
    AppMethodBeat.o(137747);
  }
  
  public void setEnablePlayGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(137744);
    ac.i("MicroMsg.Video.AppBrandVideoView", "setEnablePlayGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOM = paramBoolean;
    AppMethodBeat.o(137744);
  }
  
  public void setFullScreenDelegate(a parama)
  {
    this.kOz = parama;
  }
  
  public void setFullScreenDirection(int paramInt)
  {
    AppMethodBeat.i(137774);
    ac.i("MicroMsg.Video.AppBrandVideoView", "setFullScreenDirection %d", new Object[] { Integer.valueOf(paramInt) });
    this.abb = paramInt;
    AppMethodBeat.o(137774);
  }
  
  public void setFullScreenState(boolean paramBoolean)
  {
    AppMethodBeat.i(194098);
    if (paramBoolean)
    {
      this.kOf.bjx();
      AppMethodBeat.o(194098);
      return;
    }
    this.kOf.bha();
    AppMethodBeat.o(194098);
  }
  
  public void setInitialTime(double paramDouble)
  {
    AppMethodBeat.i(137777);
    ac.i("MicroMsg.Video.AppBrandVideoView", "setInitialTime %s", new Object[] { Double.valueOf(paramDouble) });
    this.kOC = paramDouble;
    AppMethodBeat.o(137777);
  }
  
  public void setIsEnableBottomProgressBar(boolean paramBoolean)
  {
    this.kOO = paramBoolean;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(137759);
    ac.i("MicroMsg.Video.AppBrandVideoView", "setIsShowBasicControls %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOu = paramBoolean;
    if (this.kOf != null)
    {
      if (this.kOu)
      {
        this.kOf.bjv();
        AppMethodBeat.o(137759);
        return;
      }
      this.kOf.hide();
    }
    AppMethodBeat.o(137759);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(137749);
    ac.i("MicroMsg.Video.AppBrandVideoView", "setLoop %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOB = paramBoolean;
    AppMethodBeat.o(137749);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(137770);
    ac.i("MicroMsg.Video.AppBrandVideoView", "setMute %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mIsMute = paramBoolean;
    this.kOc.setMute(paramBoolean);
    this.kOf.setMuteBtnState(paramBoolean);
    AppMethodBeat.o(137770);
  }
  
  public void setObjectFit(String paramString)
  {
    AppMethodBeat.i(137769);
    ac.i("MicroMsg.Video.AppBrandVideoView", "setObjectFit %s", new Object[] { paramString });
    if ("fill".equalsIgnoreCase(paramString))
    {
      this.kOc.setScaleType(e.h.kPk);
      this.kOn.setScaleType(ImageView.ScaleType.FIT_XY);
      AppMethodBeat.o(137769);
      return;
    }
    if ("cover".equalsIgnoreCase(paramString))
    {
      this.kOc.setScaleType(e.h.kPm);
      this.kOn.setScaleType(ImageView.ScaleType.CENTER_CROP);
      AppMethodBeat.o(137769);
      return;
    }
    this.kOc.setScaleType(e.h.kPl);
    this.kOn.setScaleType(ImageView.ScaleType.FIT_CENTER);
    AppMethodBeat.o(137769);
  }
  
  public void setPageGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(137775);
    ac.i("MicroMsg.Video.AppBrandVideoView", "setPageGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOw = paramBoolean;
    AppMethodBeat.o(137775);
  }
  
  public void setPageGestureInFullscreen(boolean paramBoolean)
  {
    AppMethodBeat.i(137776);
    ac.i("MicroMsg.Video.AppBrandVideoView", "setPageGestureInFullscreen %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOx = paramBoolean;
    AppMethodBeat.o(137776);
  }
  
  public void setPlayBtnPosition(String paramString)
  {
    AppMethodBeat.i(137743);
    ac.i("MicroMsg.Video.AppBrandVideoView", "setPlayBtnPosition %s", new Object[] { paramString });
    if ((!bs.isNullOrNil(paramString)) && (paramString.equalsIgnoreCase("center")))
    {
      this.kOf.setPlayBtnInCenterPosition(true);
      AppMethodBeat.o(137743);
      return;
    }
    this.kOf.setPlayBtnInCenterPosition(false);
    AppMethodBeat.o(137743);
  }
  
  public void setShowCenterPlayBtn(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(137766);
    ac.i("MicroMsg.Video.AppBrandVideoView", "setShowCenterPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOI = paramBoolean;
    View localView = this.kOg;
    if (paramBoolean)
    {
      i = 0;
      localView.setVisibility(i);
      localView = this.kOh;
      if (!paramBoolean) {
        break label104;
      }
    }
    label104:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      if ((this.kOI) && (this.kOf != null)) {
        this.kOf.hide();
      }
      AppMethodBeat.o(137766);
      return;
      i = 8;
      break;
    }
  }
  
  public void setShowControlProgress(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(137742);
    ac.i("MicroMsg.Video.AppBrandVideoView", "setShowControlProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    e.a locala = this.kOf;
    if ((paramBoolean) && (!bed())) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      locala.setShowControlProgress(paramBoolean);
      AppMethodBeat.o(137742);
      return;
    }
  }
  
  public void setShowDanmakuBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(137768);
    ac.i("MicroMsg.Video.AppBrandVideoView", "setShowDanmakuBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (this.kOe == null) {
        bjc();
      }
      this.kOf.setDanmakuBtnOnClickListener(new AppBrandVideoView.9(this));
    }
    this.kOf.setShowDanmakuBtn(paramBoolean);
    AppMethodBeat.o(137768);
  }
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(137763);
    ac.i("MicroMsg.Video.AppBrandVideoView", "setShowFullScreenBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOf.setShowFullScreenBtn(paramBoolean);
    AppMethodBeat.o(137763);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(137740);
    ac.i("MicroMsg.Video.AppBrandVideoView", "showMuteBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOf.setShowMuteBtn(paramBoolean);
    AppMethodBeat.o(137740);
  }
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(137764);
    ac.i("MicroMsg.Video.AppBrandVideoView", "setShowPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOf.setShowPlayBtn(paramBoolean);
    AppMethodBeat.o(137764);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(137762);
    ac.i("MicroMsg.Video.AppBrandVideoView", "setShowProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOG = paramBoolean;
    e.a locala = this.kOf;
    if (((paramBoolean) || (this.kOH)) && (!bed())) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      locala.setShowProgress(paramBoolean);
      AppMethodBeat.o(137762);
      return;
    }
  }
  
  public void setShowProgressBarInControlMode(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(194097);
    ac.i("MicroMsg.Video.AppBrandVideoView", "setShowProgressInControlMode %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kOH = paramBoolean;
    e.a locala = this.kOf;
    if (((this.kOG) || (paramBoolean)) && (!bed())) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      locala.setShowProgress(paramBoolean);
      AppMethodBeat.o(194097);
      return;
    }
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(137741);
    ac.i("MicroMsg.Video.AppBrandVideoView", "setTitle %s", new Object[] { paramString });
    this.kOf.setTitle(paramString);
    AppMethodBeat.o(137741);
  }
  
  public void setVideoPlayerId(int paramInt)
  {
    this.kOs = paramInt;
  }
  
  public void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(137746);
    ac.i("MicroMsg.Video.AppBrandVideoView", "setVideoSource %d", new Object[] { Integer.valueOf(paramInt) });
    this.kOJ = paramInt;
    AppMethodBeat.o(137746);
  }
  
  public final void start()
  {
    AppMethodBeat.i(137750);
    ac.i("MicroMsg.Video.AppBrandVideoView", "start");
    if (this.kOc.isPlaying())
    {
      ac.i("MicroMsg.Video.AppBrandVideoView", "start, video is playing");
      AppMethodBeat.o(137750);
      return;
    }
    if (!this.kOP)
    {
      ac.i("MicroMsg.Video.AppBrandVideoView", "start, video not prepared");
      this.ckf = true;
    }
    if (this.kOu) {
      this.kOf.bjA();
    }
    this.kOg.setVisibility(8);
    this.kOc.start();
    if ((this.kOe != null) && (this.kOf.bjt())) {
      this.kOe.show();
    }
    if (com.tencent.luggage.a.e.K(l.class) != null) {
      ((l)com.tencent.luggage.a.e.K(l.class)).report(this.kOK);
    }
    AppMethodBeat.o(137750);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(137752);
    ac.i("MicroMsg.Video.AppBrandVideoView", "stop");
    if (!this.kOc.isPlaying())
    {
      ac.i("MicroMsg.Video.AppBrandVideoView", "stop, video not playing");
      AppMethodBeat.o(137752);
      return;
    }
    if (!this.kOP)
    {
      ac.i("MicroMsg.Video.AppBrandVideoView", "stop, video not prepared");
      this.ckf = false;
      AppMethodBeat.o(137752);
      return;
    }
    this.kOc.stop();
    this.kOf.bjB();
    if (this.kOe != null) {
      this.kOe.hide();
    }
    AppMethodBeat.o(137752);
  }
  
  public static abstract interface a
  {
    public abstract void bha();
    
    public abstract boolean isFullScreen();
    
    public abstract void sC(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView
 * JD-Core Version:    0.7.0.1
 */