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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.aa.g;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.1;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.2;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.m;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.3;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.4;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.5;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
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
  private int aag;
  private int ark;
  private boolean ckB;
  private boolean ckC;
  private boolean ckP;
  private boolean cnd;
  private int jSJ;
  private RelativeLayout kmJ;
  public e kmK;
  private TextView kmL;
  private DanmuView kmM;
  public e.a kmN;
  private View kmO;
  private View kmP;
  private TextView kmQ;
  private LinearLayout kmR;
  private AppBrandDotPercentIndicator kmS;
  private TextView kmT;
  private ImageView kmU;
  private ImageView kmV;
  private ImageView kmW;
  private ImageView kmX;
  private FrameLayout kmY;
  private String kmZ;
  private int kna;
  private c knb;
  private boolean knc;
  public com.tencent.mm.plugin.appbrand.jsapi.video.c.b knd;
  private boolean kne;
  private boolean knf;
  private com.tencent.mm.plugin.appbrand.jsapi.video.ui.a kng;
  private a knh;
  private boolean kni;
  private boolean knj;
  private double knk;
  private String knl;
  private boolean knm;
  private boolean knn;
  private boolean kno;
  private boolean knp;
  private boolean knq;
  private int knr;
  private String kns;
  private boolean knt;
  private boolean knu;
  private boolean knv;
  private boolean knw;
  private boolean knx;
  private String mAppId;
  private boolean mIsMute;
  
  public AppBrandVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(137735);
    this.aag = -1;
    this.knv = false;
    this.knw = true;
    this.knx = false;
    this.cnd = false;
    init(paramContext);
    AppMethodBeat.o(137735);
  }
  
  public AppBrandVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(137736);
    this.aag = -1;
    this.knv = false;
    this.knw = true;
    this.knx = false;
    this.cnd = false;
    init(paramContext);
    AppMethodBeat.o(137736);
  }
  
  public <T extends View,  extends e> AppBrandVideoView(Context paramContext, T paramT)
  {
    super(paramContext);
    AppMethodBeat.i(137734);
    this.aag = -1;
    this.knv = false;
    this.knw = true;
    this.knx = false;
    this.cnd = false;
    this.kmK = ((e)paramT);
    init(paramContext);
    this.kmJ.addView(paramT);
    AppMethodBeat.o(137734);
  }
  
  private boolean aXf()
  {
    AppMethodBeat.i(137791);
    if ((this.kni) || (this.kmK.aXf()))
    {
      AppMethodBeat.o(137791);
      return true;
    }
    AppMethodBeat.o(137791);
    return false;
  }
  
  private void bcc()
  {
    AppMethodBeat.i(193753);
    if (this.kmK != null) {
      this.kmK.bcc();
    }
    AppMethodBeat.o(193753);
  }
  
  private void bcd()
  {
    AppMethodBeat.i(137780);
    this.kng = new com.tencent.mm.plugin.appbrand.jsapi.video.ui.a(getContext(), this, new a.b()
    {
      public final void av(float paramAnonymousFloat)
      {
        AppMethodBeat.i(193733);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(193733);
          return;
        }
        ad.d("MicroMsg.Video.AppBrandVideoView", "onAdjustVolume:".concat(String.valueOf(paramAnonymousFloat)));
        AppBrandVideoView.o(AppBrandVideoView.this).setPercent(paramAnonymousFloat);
        AppBrandVideoView.p(AppBrandVideoView.this).setText(2131760999);
        AppBrandVideoView.q(AppBrandVideoView.this).setImageResource(2131231041);
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(0);
        AppBrandVideoView.j(AppBrandVideoView.this);
        AppMethodBeat.o(193733);
      }
      
      public final void aw(float paramAnonymousFloat)
      {
        AppMethodBeat.i(193734);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(193734);
          return;
        }
        ad.d("MicroMsg.Video.AppBrandVideoView", "onAdjustBrightness:".concat(String.valueOf(paramAnonymousFloat)));
        AppBrandVideoView.o(AppBrandVideoView.this).setPercent(paramAnonymousFloat);
        AppBrandVideoView.p(AppBrandVideoView.this).setText(2131760998);
        AppBrandVideoView.q(AppBrandVideoView.this).setImageResource(2131231033);
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(0);
        AppBrandVideoView.j(AppBrandVideoView.this);
        AppMethodBeat.o(193734);
      }
      
      public final void bcn()
      {
        AppMethodBeat.i(193727);
        ad.d("MicroMsg.Video.AppBrandVideoView", "onSingleTap");
        if ((AppBrandVideoView.f(AppBrandVideoView.this)) && (AppBrandVideoView.g(AppBrandVideoView.this).getVisibility() != 0))
        {
          AppBrandVideoView.h(AppBrandVideoView.this).bcz();
          if (AppBrandVideoView.i(AppBrandVideoView.this)) {
            AppBrandVideoView.j(AppBrandVideoView.this);
          }
        }
        AppMethodBeat.o(193727);
      }
      
      public final void bco()
      {
        AppMethodBeat.i(193728);
        ad.d("MicroMsg.Video.AppBrandVideoView", "onDoubleTap");
        if (AppBrandVideoView.k(AppBrandVideoView.this))
        {
          if (AppBrandVideoView.b(AppBrandVideoView.this).isPlaying())
          {
            AppBrandVideoView.this.pause();
            AppMethodBeat.o(193728);
            return;
          }
          AppBrandVideoView.this.start();
        }
        AppMethodBeat.o(193728);
      }
      
      public final void bcp()
      {
        AppMethodBeat.i(193729);
        if (!AppBrandVideoView.l(AppBrandVideoView.this))
        {
          AppMethodBeat.o(193729);
          return;
        }
        AppBrandVideoView.m(AppBrandVideoView.this).setVisibility(0);
        AppBrandVideoView.j(AppBrandVideoView.this);
        AppMethodBeat.o(193729);
      }
      
      public final void bcq()
      {
        AppMethodBeat.i(193735);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(193735);
          return;
        }
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.n(AppBrandVideoView.this);
        AppMethodBeat.o(193735);
      }
      
      public final void bcr()
      {
        AppMethodBeat.i(193736);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(193736);
          return;
        }
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.n(AppBrandVideoView.this);
        AppMethodBeat.o(193736);
      }
      
      public final boolean bcs()
      {
        AppMethodBeat.i(205908);
        boolean bool = AppBrandVideoView.s(AppBrandVideoView.this);
        AppMethodBeat.o(205908);
        return bool;
      }
      
      public final boolean bct()
      {
        AppMethodBeat.i(205909);
        boolean bool = AppBrandVideoView.s(AppBrandVideoView.this);
        AppMethodBeat.o(205909);
        return bool;
      }
      
      public final boolean bcu()
      {
        AppMethodBeat.i(193739);
        boolean bool = AppBrandVideoView.l(AppBrandVideoView.this);
        AppMethodBeat.o(193739);
        return bool;
      }
      
      public final int getCurrentPosition()
      {
        AppMethodBeat.i(193732);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getCurrPosSec();
        AppMethodBeat.o(193732);
        return i;
      }
      
      public final int j(int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(193730);
        if (!AppBrandVideoView.l(AppBrandVideoView.this))
        {
          AppMethodBeat.o(193730);
          return 0;
        }
        ad.i("MicroMsg.Video.AppBrandVideoView", "onDragProgress:" + paramAnonymousInt + "/" + paramAnonymousFloat);
        paramAnonymousInt = AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec();
        int i = com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.a.c(paramAnonymousFloat, AppBrandVideoView.this.getMeasuredWidth(), getCurrentPosition(), paramAnonymousInt);
        String str = l.mz(paramAnonymousInt * 1000L);
        AppBrandVideoView.m(AppBrandVideoView.this).setText(l.mz(i * 1000L) + "/" + str);
        AppBrandVideoView.h(AppBrandVideoView.this).seek(i);
        if (AppBrandVideoView.h(AppBrandVideoView.this).bcB()) {
          AppBrandVideoView.h(AppBrandVideoView.this).bcH();
        }
        AppMethodBeat.o(193730);
        return i;
      }
      
      public final void k(int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(193731);
        if (!AppBrandVideoView.l(AppBrandVideoView.this))
        {
          AppMethodBeat.o(193731);
          return;
        }
        AppBrandVideoView.m(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.n(AppBrandVideoView.this);
        ad.i("MicroMsg.Video.AppBrandVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(AppBrandVideoView.b(AppBrandVideoView.this).getCurrPosSec()), Float.valueOf(paramAnonymousFloat) });
        AppBrandVideoView.this.d(paramAnonymousInt, false);
        AppMethodBeat.o(193731);
      }
    });
    AppMethodBeat.o(137780);
  }
  
  private void bce()
  {
    AppMethodBeat.i(137781);
    this.kmN.bce();
    AppMethodBeat.o(137781);
  }
  
  private void bcf()
  {
    AppMethodBeat.i(137782);
    this.kmK.setIMMVideoViewCallback(new e.c()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(193740);
        ad.i("MicroMsg.Video.AppBrandVideoView", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null)
        {
          paramAnonymousString1 = AppBrandVideoView.d(AppBrandVideoView.this);
          paramAnonymousString1.clean();
          try
          {
            paramAnonymousString2 = paramAnonymousString1.bdC();
            paramAnonymousString2.put("errMsg", paramAnonymousString3);
            paramAnonymousString1.a(new b.d((byte)0), paramAnonymousString2);
            AppMethodBeat.o(193740);
            return;
          }
          catch (JSONException paramAnonymousString1)
          {
            ad.e("MicroMsg.Video.JsApiVideoCallback", "onError e=%s", new Object[] { paramAnonymousString1 });
          }
        }
        AppMethodBeat.o(193740);
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(193743);
        ad.i("MicroMsg.Video.AppBrandVideoView", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (AppBrandVideoView.D(AppBrandVideoView.this) == -1)
        {
          paramAnonymousString1 = AppBrandVideoView.this;
          if (paramAnonymousInt1 >= paramAnonymousInt2) {
            break label205;
          }
        }
        for (int i = 0;; i = 90)
        {
          AppBrandVideoView.a(paramAnonymousString1, i);
          ad.i("MicroMsg.Video.AppBrandVideoView", "onGetVideoSize adjust direction from AUTO to %s", new Object[] { Integer.valueOf(AppBrandVideoView.D(AppBrandVideoView.this)) });
          if (AppBrandVideoView.d(AppBrandVideoView.this) == null) {
            break label228;
          }
          paramAnonymousString1 = AppBrandVideoView.d(AppBrandVideoView.this);
          i = AppBrandVideoView.this.getDuration();
          try
          {
            ad.i("MicroMsg.Video.JsApiVideoCallback", "onVideoLoadedMetaData, width:%d, height:%d, duration:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i) });
            paramAnonymousString2 = paramAnonymousString1.bdC();
            paramAnonymousString2.put("width", paramAnonymousInt1);
            paramAnonymousString2.put("height", paramAnonymousInt2);
            paramAnonymousString2.put("duration", i * 1.0D / 1000.0D);
            paramAnonymousString1.a(new b.f((byte)0), paramAnonymousString2);
            AppMethodBeat.o(193743);
            return;
          }
          catch (JSONException paramAnonymousString1)
          {
            label205:
            ad.e("MicroMsg.Video.JsApiVideoCallback", "onVideoLoadedMetaData e=%s", new Object[] { paramAnonymousString1 });
          }
        }
        label228:
        AppMethodBeat.o(193743);
      }
      
      public final void db(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(193741);
        ad.i("MicroMsg.Video.AppBrandVideoView", "onPrepared");
        AppBrandVideoView.t(AppBrandVideoView.this);
        if (AppBrandVideoView.u(AppBrandVideoView.this)) {
          AppBrandVideoView.this.start();
        }
        AppBrandVideoView.v(AppBrandVideoView.this).bee();
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
          AppBrandVideoView.d(AppBrandVideoView.this).krV = 0;
        }
        AppMethodBeat.o(193741);
      }
      
      public final void dc(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(193742);
        ad.i("MicroMsg.Video.AppBrandVideoView", "onVideoEnded");
        AppBrandVideoView.m(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.h(AppBrandVideoView.this).setIsPlay(false);
        if ((AppBrandVideoView.h(AppBrandVideoView.this).bcB()) && (AppBrandVideoView.h(AppBrandVideoView.this).bcE())) {
          AppBrandVideoView.h(AppBrandVideoView.this).hide();
        }
        if (AppBrandVideoView.w(AppBrandVideoView.this).getVisibility() == 0) {
          AppBrandVideoView.w(AppBrandVideoView.this).setVisibility(8);
        }
        if ((AppBrandVideoView.x(AppBrandVideoView.this)) || (!AppBrandVideoView.y(AppBrandVideoView.this)))
        {
          AppBrandVideoView.z(AppBrandVideoView.this).setVisibility(8);
          AppBrandVideoView.g(AppBrandVideoView.this).setVisibility(8);
        }
        for (;;)
        {
          if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
            paramAnonymousString1 = AppBrandVideoView.d(AppBrandVideoView.this);
          }
          try
          {
            paramAnonymousString1.a(new b.c((byte)0), paramAnonymousString1.bdC());
            paramAnonymousString1.bdD();
            paramAnonymousString1.bdE();
            if (AppBrandVideoView.C(AppBrandVideoView.this)) {
              AppBrandVideoView.this.d(0.0D, true);
            }
            AppMethodBeat.o(193742);
            return;
            if (AppBrandVideoView.A(AppBrandVideoView.this) <= 0) {
              AppBrandVideoView.B(AppBrandVideoView.this).setText(AppBrandVideoView.rY(AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec()));
            }
            AppBrandVideoView.z(AppBrandVideoView.this).setVisibility(0);
            AppBrandVideoView.g(AppBrandVideoView.this).setVisibility(0);
          }
          catch (JSONException paramAnonymousString2)
          {
            for (;;)
            {
              ad.e("MicroMsg.Video.JsApiVideoCallback", "OnVideoEnded e=%s", new Object[] { paramAnonymousString2 });
            }
          }
        }
      }
      
      public final void dd(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(193744);
        ad.i("MicroMsg.Video.AppBrandVideoView", "onVideoPause");
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
          paramAnonymousString1 = AppBrandVideoView.d(AppBrandVideoView.this);
        }
        try
        {
          paramAnonymousString1.a(new b.g((byte)0), paramAnonymousString1.bdC());
          paramAnonymousString1.bdD();
          AppMethodBeat.o(193744);
          return;
        }
        catch (JSONException paramAnonymousString2)
        {
          for (;;)
          {
            ad.e("MicroMsg.Video.JsApiVideoCallback", "OnVideoPause e=%s", new Object[] { paramAnonymousString2 });
          }
        }
      }
      
      public final void de(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(193745);
        ad.i("MicroMsg.Video.AppBrandVideoView", "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(AppBrandVideoView.x(AppBrandVideoView.this)) });
        if ((AppBrandVideoView.A(AppBrandVideoView.this) <= 0) && (!AppBrandVideoView.x(AppBrandVideoView.this))) {
          AppBrandVideoView.B(AppBrandVideoView.this).setText(AppBrandVideoView.rY(AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec()));
        }
        AppBrandVideoView.a(AppBrandVideoView.this, AppBrandVideoView.x(AppBrandVideoView.this));
        if (AppBrandVideoView.f(AppBrandVideoView.this)) {
          AppBrandVideoView.E(AppBrandVideoView.this);
        }
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
          paramAnonymousString1 = AppBrandVideoView.d(AppBrandVideoView.this);
        }
        try
        {
          paramAnonymousString1.krT = 0;
          paramAnonymousString2 = paramAnonymousString1.bdC();
          paramAnonymousString2.put("timeStamp", System.currentTimeMillis());
          paramAnonymousString1.a(new b.h((byte)0), paramAnonymousString2);
          if (paramAnonymousString1.krS == null) {
            paramAnonymousString1.krS = new av(new b.1(paramAnonymousString1), true);
          }
          paramAnonymousString1.krS.av(250L, 250L);
          if (paramAnonymousString1.krU == null) {
            paramAnonymousString1.krU = new av(new b.2(paramAnonymousString1), true);
          }
          paramAnonymousString1.krU.av(500L, 500L);
        }
        catch (JSONException paramAnonymousString1)
        {
          for (;;)
          {
            ad.e("MicroMsg.Video.JsApiVideoCallback", "OnVideoPlay e=%s", new Object[] { paramAnonymousString1 });
          }
        }
        if ((AppBrandVideoView.F(AppBrandVideoView.this) != null) && ("wxfe02ecfe70800f46".equalsIgnoreCase(AppBrandVideoView.F(AppBrandVideoView.this).getAppId())))
        {
          ad.i("MicroMsg.Video.AppBrandVideoView", "onVideoPlay, send play event");
          com.tencent.mm.sdk.b.a.ESL.l(new com.tencent.mm.plugin.appbrand.jsapi.video.c.a());
        }
        AppMethodBeat.o(193745);
      }
      
      public final void dg(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(193746);
        ad.i("MicroMsg.Video.AppBrandVideoView", "onVideoWaiting");
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
          paramAnonymousString1 = AppBrandVideoView.d(AppBrandVideoView.this);
        }
        try
        {
          paramAnonymousString2 = paramAnonymousString1.bdC();
          paramAnonymousString2.put("timeStamp", System.currentTimeMillis());
          paramAnonymousString1.a(new b.m((byte)0), paramAnonymousString2);
          AppBrandVideoView.b(AppBrandVideoView.this, true);
          AppBrandVideoView.j(AppBrandVideoView.this);
          AppMethodBeat.o(193746);
          return;
        }
        catch (JSONException paramAnonymousString1)
        {
          for (;;)
          {
            ad.e("MicroMsg.Video.JsApiVideoCallback", "onVideoWaiting e=%s", new Object[] { paramAnonymousString1 });
          }
        }
      }
      
      public final void dh(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(193747);
        AppBrandVideoView.b(AppBrandVideoView.this, false);
        AppBrandVideoView.n(AppBrandVideoView.this);
        AppMethodBeat.o(193747);
      }
    });
    AppMethodBeat.o(137782);
  }
  
  private void bch()
  {
    AppMethodBeat.i(137786);
    this.kmM = ((DanmuView)findViewById(2131298920));
    this.kmM.setDanmuViewCallBack(new AppBrandVideoView.11(this));
    this.kmM.bdA();
    this.kmM.setMaxRunningPerRow(5);
    this.kmM.setPickItemInterval(200);
    this.kmM.hide();
    if ((this.kmK != null) && (((View)this.kmK).getHeight() > 0))
    {
      float f = this.kmM.getYOffset();
      int i = (int)(((View)this.kmK).getHeight() * f);
      f = com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b.dq(getContext());
      this.kmM.setMaxRow((int)(i / f));
    }
    AppMethodBeat.o(137786);
  }
  
  private boolean bci()
  {
    AppMethodBeat.i(137792);
    if ((this.knn) && (!this.kmK.aXf()) && (!bck()))
    {
      AppMethodBeat.o(137792);
      return true;
    }
    AppMethodBeat.o(137792);
    return false;
  }
  
  private boolean bcj()
  {
    AppMethodBeat.i(137793);
    if ((!bck()) && (((!bcg()) && (this.kne)) || ((bcg()) && (this.knf))))
    {
      AppMethodBeat.o(137793);
      return true;
    }
    AppMethodBeat.o(137793);
    return false;
  }
  
  private boolean bck()
  {
    AppMethodBeat.i(137794);
    if (this.kmO.getVisibility() == 0)
    {
      AppMethodBeat.o(137794);
      return true;
    }
    AppMethodBeat.o(137794);
    return false;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(137737);
    LayoutInflater.from(paramContext).inflate(2131493072, this);
    setBackgroundColor(-16777216);
    this.kmJ = ((RelativeLayout)findViewById(2131306410));
    this.kmL = ((TextView)findViewById(2131303515));
    this.kmO = findViewById(2131298814);
    this.kmP = findViewById(2131298828);
    this.kmQ = ((TextView)findViewById(2131298832));
    this.kmR = ((LinearLayout)findViewById(2131296505));
    this.kmS = ((AppBrandDotPercentIndicator)findViewById(2131296506));
    this.kmT = ((TextView)findViewById(2131296502));
    this.kmU = ((ImageView)findViewById(2131296504));
    this.kmV = ((ImageView)findViewById(2131298813));
    this.kmW = ((ImageView)findViewById(2131303297));
    this.kmX = ((ImageView)findViewById(2131303296));
    this.kmY = ((FrameLayout)findViewById(2131303298));
    this.kmS.setDotsNum(8);
    ((ImageView)findViewById(2131298827)).setOnClickListener(new AppBrandVideoView.1(this));
    bcd();
    bcf();
    AppMethodBeat.o(137737);
  }
  
  private static String rW(int paramInt)
  {
    AppMethodBeat.i(137788);
    String str = rX(paramInt / 60) + ":" + rX(paramInt % 60);
    AppMethodBeat.o(137788);
    return str;
  }
  
  private static String rX(int paramInt)
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
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(137761);
      return;
    }
    if (!bt.isNullOrNil(this.knl))
    {
      ad.i("MicroMsg.Video.AppBrandVideoView", "setCover mCoverUrl not null");
      AppMethodBeat.o(137761);
      return;
    }
    com.tencent.mm.plugin.appbrand.aa.l.bqm().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193725);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(193724);
            if ((this.val$bitmap != null) && (!this.val$bitmap.isRecycled())) {
              AppBrandVideoView.a(AppBrandVideoView.this).setImageBitmap(this.val$bitmap);
            }
            AppMethodBeat.o(193724);
          }
        });
        AppMethodBeat.o(193725);
      }
    });
    AppMethodBeat.o(137761);
  }
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(137787);
    this.kmN = parama;
    if (((this.kmN instanceof View)) && (this.kmN != null))
    {
      parama = (View)this.kmN;
      if (parama.getId() != -1) {
        parama.setId(2131296841);
      }
    }
    this.kmN.hide();
    this.kmN.setFullScreenBtnOnClickListener(new AppBrandVideoView.12(this));
    this.kmN.setIplaySeekCallback(new AppBrandVideoView.13(this));
    this.kmN.setOnPlayButtonClickListener(new AppBrandVideoView.14(this));
    this.kmN.setStatePorter(new AppBrandVideoView.2(this));
    this.kmN.setMuteBtnOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(193721);
        paramAnonymousView = AppBrandVideoView.this;
        if (!AppBrandVideoView.G(AppBrandVideoView.this)) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setMute(bool);
          AppMethodBeat.o(193721);
          return;
        }
      }
    });
    this.kmN.setExitFullScreenBtnOnClickListener(new AppBrandVideoView.4(this));
    this.kmN.a(new e.f()
    {
      public final void onVisibilityChanged(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(193722);
        AppBrandVideoView.E(AppBrandVideoView.this);
        AppMethodBeat.o(193722);
      }
    });
    this.kmN.setOnUpdateProgressLenListener(new e.e()
    {
      public final void onProgressChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(193723);
        if (paramAnonymousInt2 <= 0)
        {
          AppMethodBeat.o(193723);
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
          paramAnonymousInt1 = i * AppBrandVideoView.H(AppBrandVideoView.this).getWidth() / paramAnonymousInt2;
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)AppBrandVideoView.I(AppBrandVideoView.this).getLayoutParams();
          localLayoutParams.width = paramAnonymousInt1;
          AppBrandVideoView.I(AppBrandVideoView.this).setLayoutParams(localLayoutParams);
          AppBrandVideoView.I(AppBrandVideoView.this).requestLayout();
          AppMethodBeat.o(193723);
          return;
        }
      }
    });
    AppMethodBeat.o(137787);
  }
  
  public final boolean bcg()
  {
    AppMethodBeat.i(137785);
    if (this.knh == null)
    {
      ad.w("MicroMsg.Video.AppBrandVideoView", "isInFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(137785);
      return false;
    }
    boolean bool = this.knh.isFullScreen();
    AppMethodBeat.o(137785);
    return bool;
  }
  
  public final void clean()
  {
    AppMethodBeat.i(137756);
    ad.i("MicroMsg.Video.AppBrandVideoView", "clean");
    stop();
    this.kmK.onUIDestroy();
    if (this.kmM != null) {
      this.kmM.clear();
    }
    this.kmN.onDestroy();
    AppMethodBeat.o(137756);
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(137758);
    int i = this.kmK.getCurrPosSec();
    ad.i("MicroMsg.Video.AppBrandVideoView", "seek to position=%s current=%d isLive=%b", new Object[] { Double.valueOf(paramDouble), Integer.valueOf(i), Boolean.valueOf(this.kni) });
    if (aXf())
    {
      AppMethodBeat.o(137758);
      return;
    }
    this.kmO.setVisibility(8);
    if (paramBoolean) {
      this.kmK.c(paramDouble, paramBoolean);
    }
    for (;;)
    {
      if ((this.kmM != null) && (i > paramDouble))
      {
        DanmuView localDanmuView = this.kmM;
        i = (int)paramDouble;
        ad.i("MicroMsg.DanmuView", "seekToPlayTime playTime=%d", new Object[] { Integer.valueOf(i) });
        localDanmuView.bdw();
        localDanmuView.clearItems();
        localDanmuView.prepare();
        com.tencent.e.h.Iye.aP(new DanmuView.5(localDanmuView, i));
      }
      AppMethodBeat.o(137758);
      return;
      this.kmK.p(paramDouble);
    }
  }
  
  public final boolean da(String arg1, String paramString2)
  {
    AppMethodBeat.i(137779);
    if (this.kmM == null)
    {
      ad.w("MicroMsg.Video.AppBrandVideoView", " addDanmaku mDanmakuView null");
      bch();
    }
    int j = g.Nh(paramString2);
    int i = j;
    if (j == 0) {
      i = -1;
    }
    paramString2 = new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a(getContext(), new SpannableString(???), i, this.kmK.getCurrPosSec());
    DanmuView localDanmuView = this.kmM;
    synchronized (localDanmuView.krE)
    {
      localDanmuView.krE.offerFirst(paramString2);
      com.tencent.e.h.Iye.f(new DanmuView.3(localDanmuView, paramString2), "DanmuView-addItemToWaitingHead");
      AppMethodBeat.o(137779);
      return true;
    }
  }
  
  public final void e(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(137757);
    String str = paramString;
    if (this.knb != null)
    {
      str = paramString;
      if (this.knb.Ee() != null)
      {
        str = paramString;
        if (this.knb.Ee().Eb(paramString))
        {
          paramString = this.knb.Ee().EP(paramString);
          if (paramString != null) {
            break label124;
          }
        }
      }
    }
    label124:
    for (paramString = null;; paramString = "file://" + q.B(paramString.fhU()))
    {
      str = paramString;
      ad.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath path=%s isLive=%s", new Object[] { str, Boolean.valueOf(paramBoolean) });
      if (!bt.isNullOrNil(str)) {
        break;
      }
      ad.v("MicroMsg.Video.AppBrandVideoView", "setVideoPath videoPath empty");
      AppMethodBeat.o(137757);
      return;
    }
    stop();
    this.kni = paramBoolean;
    this.kns = str;
    this.kmK.setVideoSource(this.knr);
    this.kmK.c(paramBoolean, str, paramInt);
    if (this.knk > 0.0D) {
      this.kmK.c(this.knk, this.ckP);
    }
    Object localObject;
    if ((this.knr == 1) && (com.tencent.luggage.a.e.K(h.class) != null))
    {
      localObject = ((h)com.tencent.luggage.a.e.K(h.class)).Je(this.kns);
      if (localObject != null)
      {
        ad.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath localVideoPath:%s", new Object[] { localObject });
        paramString = this.kns;
        ad.i("MicroMsg.Video.AppBrandVideoView", "leonlad setPreLoadVideoPath %s", new Object[] { localObject });
        if ((!this.kmK.isPlaying()) && (this.kns.equalsIgnoreCase(paramString)))
        {
          this.kns = paramString;
          this.kmK.c(this.kni, (String)localObject, 0);
          if (!this.ckP) {
            break label452;
          }
          ad.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay true");
          start();
        }
      }
    }
    for (;;)
    {
      if (this.knd != null) {
        localObject = this.knd;
      }
      try
      {
        JSONObject localJSONObject = ((com.tencent.mm.plugin.appbrand.jsapi.video.c.b)localObject).bdC();
        localJSONObject.put("timeStamp", System.currentTimeMillis());
        localJSONObject.put("url", paramString);
        ((com.tencent.mm.plugin.appbrand.jsapi.video.c.b)localObject).a(new b.a((byte)0), localJSONObject);
        if (this.ckP)
        {
          ad.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay true");
          start();
          setCover(str);
          AppMethodBeat.o(137757);
          return;
          label452:
          ad.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay false");
          bcc();
        }
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          ad.e("MicroMsg.Video.JsApiVideoCallback", "onVideoCanPlay e=%s", new Object[] { paramString });
          continue;
          ad.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay false");
          bcc();
        }
      }
    }
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(137773);
    if (this.kmK != null)
    {
      int i = this.kmK.getCacheTimeSec();
      AppMethodBeat.o(137773);
      return i;
    }
    AppMethodBeat.o(137773);
    return 0;
  }
  
  public com.tencent.mm.plugin.appbrand.jsapi.video.c.b getCallback()
  {
    return this.knd;
  }
  
  public String getCookieData()
  {
    return this.kmZ;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(137772);
    int i = this.kmK.getCurrPosMs();
    AppMethodBeat.o(137772);
    return i;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(137771);
    int i = this.kmK.getCurrPosSec();
    AppMethodBeat.o(137771);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(137748);
    if (this.ark > 0)
    {
      i = this.ark;
      AppMethodBeat.o(137748);
      return i;
    }
    int i = this.kmK.getVideoDurationSec();
    AppMethodBeat.o(137748);
    return i;
  }
  
  public final void gm(boolean paramBoolean)
  {
    AppMethodBeat.i(137765);
    ad.i("MicroMsg.Video.AppBrandVideoView", "enableProgressGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.knn = paramBoolean;
    AppMethodBeat.o(137765);
  }
  
  public final void gn(boolean paramBoolean)
  {
    AppMethodBeat.i(137790);
    if (this.knd == null)
    {
      AppMethodBeat.o(137790);
      return;
    }
    this.knd.c(this.kna, paramBoolean, this.jSJ);
    AppMethodBeat.o(137790);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(137783);
    if (this.knu) {
      bool = true;
    }
    while (bool)
    {
      if (this.kng != null) {
        this.kng.A(paramMotionEvent);
      }
      AppMethodBeat.o(137783);
      return true;
      bool = bci();
      if (!bcj()) {
        bool = false;
      }
    }
    if ((paramMotionEvent.getAction() == 0) && (this.knc) && (this.kmO.getVisibility() != 0))
    {
      this.kmN.bcz();
      if (this.knt) {
        bce();
      }
    }
    if (this.knm)
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
    ad.i("MicroMsg.Video.AppBrandVideoView", "onUIDestroy");
    clean();
    AppMethodBeat.o(137755);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(137753);
    ad.i("MicroMsg.Video.AppBrandVideoView", "onUIResume");
    if (this.knv)
    {
      ad.i("MicroMsg.Video.AppBrandVideoView", "onUIResume, should skip ui resume");
      this.knv = false;
      AppMethodBeat.o(137753);
      return;
    }
    this.kmK.onUIResume();
    AppMethodBeat.o(137753);
  }
  
  public final void p(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(137784);
    ad.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen toFullScreen:%b direction:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.knh == null)
    {
      ad.w("MicroMsg.Video.AppBrandVideoView", "operateFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(137784);
      return;
    }
    if (paramBoolean == bcg())
    {
      ad.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen current same");
      AppMethodBeat.o(137784);
      return;
    }
    if (paramInt == -1) {
      if (this.aag == -1)
      {
        paramInt = 90;
        ad.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen target direction:%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        this.jSJ = paramInt;
        this.knh.rM(paramInt);
        this.kmN.bcC();
        gn(true);
        AppMethodBeat.o(137784);
        return;
        paramInt = this.aag;
        break;
      }
      this.knh.bah();
      this.kmN.bah();
      AppMethodBeat.o(137784);
      return;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137751);
    ad.i("MicroMsg.Video.AppBrandVideoView", "pause");
    if (!this.kmK.isPlaying())
    {
      ad.i("MicroMsg.Video.AppBrandVideoView", "pause, video not playing");
      AppMethodBeat.o(137751);
      return;
    }
    if (!this.knx)
    {
      ad.i("MicroMsg.Video.AppBrandVideoView", "pause, video not prepared");
      this.cnd = false;
      AppMethodBeat.o(137751);
      return;
    }
    this.kmK.pause();
    if ((this.kmM != null) && (this.kmN.bcy())) {
      this.kmM.pause();
    }
    AppMethodBeat.o(137751);
  }
  
  public final void rV(int paramInt)
  {
    AppMethodBeat.i(137754);
    ad.i("MicroMsg.Video.AppBrandVideoView", "onUIPause, type:%d", new Object[] { Integer.valueOf(paramInt) });
    if (((paramInt == 2) && (!this.ckC)) || ((paramInt == 1) && (!this.ckB)))
    {
      ad.i("MicroMsg.Video.AppBrandVideoView", "onUIPause, should skip ui pause");
      this.knv = true;
      AppMethodBeat.o(137754);
      return;
    }
    this.kmK.onUIPause();
    AppMethodBeat.o(137754);
  }
  
  public void setAutoPauseIfNavigate(boolean paramBoolean)
  {
    this.ckB = paramBoolean;
  }
  
  public void setAutoPauseIfOpenNative(boolean paramBoolean)
  {
    this.ckC = paramBoolean;
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(137745);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setAutoPlay %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.ckP = paramBoolean;
    AppMethodBeat.o(137745);
  }
  
  public void setCallback(com.tencent.mm.plugin.appbrand.jsapi.video.c.b paramb)
  {
    this.knd = paramb;
  }
  
  public void setComponent(c paramc)
  {
    AppMethodBeat.i(137738);
    this.knb = paramc;
    this.mAppId = paramc.getAppId();
    AppMethodBeat.o(137738);
  }
  
  public void setConsumeTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(137739);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setConsumeTouchEvent game=%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.knm = paramBoolean;
    AppMethodBeat.o(137739);
  }
  
  public void setCookieData(String paramString)
  {
    this.kmZ = paramString;
  }
  
  public final void setCover$16da05f7(String paramString)
  {
    AppMethodBeat.i(137760);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setCover:%s", new Object[] { paramString });
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(137760);
      return;
    }
    this.knl = paramString;
    com.tencent.mm.modelappbrand.a.b.aub().a(this.kmV, paramString, null, null);
    AppMethodBeat.o(137760);
  }
  
  public void setDanmakuEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(137767);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setDanmakuEnable %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kmN.setDanmakuBtnOpen(paramBoolean);
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
      ad.i("MicroMsg.Video.AppBrandVideoView", "setDanmakuItemList length=%d", new Object[] { Integer.valueOf(i) });
      if (this.kmM == null)
      {
        ad.w("MicroMsg.Video.AppBrandVideoView", "setDanmakuItemList mDanmakuView null");
        bch();
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
      int k = g.Nh(((JSONObject)localObject).optString("color", ""));
      j = k;
      if (k == 0) {
        j = -1;
      }
    }
    label203:
    paramJSONArray = this.kmM;
    paramJSONArray.bdw();
    paramJSONArray.clearItems();
    paramJSONArray.krF.clear();
    paramJSONArray.prepare();
    if (localArrayList.isEmpty())
    {
      paramJSONArray.bdx();
      AppMethodBeat.o(137778);
      return;
    }
    com.tencent.e.h.Iye.aS(new DanmuView.4(paramJSONArray, localArrayList));
    paramJSONArray.bdx();
    AppMethodBeat.o(137778);
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(137747);
    if (paramInt <= 0)
    {
      ad.i("MicroMsg.Video.AppBrandVideoView", "setDuration error duration=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137747);
      return;
    }
    this.kmQ.setText(rW(paramInt));
    this.ark = paramInt;
    AppMethodBeat.o(137747);
  }
  
  public void setEnablePlayGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(137744);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setEnablePlayGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.knu = paramBoolean;
    AppMethodBeat.o(137744);
  }
  
  public void setFullScreenDelegate(a parama)
  {
    this.knh = parama;
  }
  
  public void setFullScreenDirection(int paramInt)
  {
    AppMethodBeat.i(137774);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setFullScreenDirection %d", new Object[] { Integer.valueOf(paramInt) });
    this.aag = paramInt;
    AppMethodBeat.o(137774);
  }
  
  public void setInitialTime(double paramDouble)
  {
    AppMethodBeat.i(137777);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setInitialTime %s", new Object[] { Double.valueOf(paramDouble) });
    this.knk = paramDouble;
    AppMethodBeat.o(137777);
  }
  
  public void setIsEnableBottomProgressBar(boolean paramBoolean)
  {
    this.knw = paramBoolean;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(137759);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setIsShowBasicControls %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.knc = paramBoolean;
    if (this.kmN != null)
    {
      if (this.knc)
      {
        this.kmN.bcA();
        AppMethodBeat.o(137759);
        return;
      }
      this.kmN.hide();
    }
    AppMethodBeat.o(137759);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(137749);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setLoop %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.knj = paramBoolean;
    AppMethodBeat.o(137749);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(137770);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setMute %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mIsMute = paramBoolean;
    this.kmK.setMute(paramBoolean);
    this.kmN.setMuteBtnState(paramBoolean);
    AppMethodBeat.o(137770);
  }
  
  public void setObjectFit(String paramString)
  {
    AppMethodBeat.i(137769);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setObjectFit %s", new Object[] { paramString });
    if ("fill".equalsIgnoreCase(paramString))
    {
      this.kmK.setScaleType(e.h.knQ);
      this.kmV.setScaleType(ImageView.ScaleType.FIT_XY);
      AppMethodBeat.o(137769);
      return;
    }
    if ("cover".equalsIgnoreCase(paramString))
    {
      this.kmK.setScaleType(e.h.knS);
      this.kmV.setScaleType(ImageView.ScaleType.CENTER_CROP);
      AppMethodBeat.o(137769);
      return;
    }
    this.kmK.setScaleType(e.h.knR);
    this.kmV.setScaleType(ImageView.ScaleType.FIT_CENTER);
    AppMethodBeat.o(137769);
  }
  
  public void setPageGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(137775);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setPageGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kne = paramBoolean;
    AppMethodBeat.o(137775);
  }
  
  public void setPageGestureInFullscreen(boolean paramBoolean)
  {
    AppMethodBeat.i(137776);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setPageGestureInFullscreen %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.knf = paramBoolean;
    AppMethodBeat.o(137776);
  }
  
  public void setPlayBtnPosition(String paramString)
  {
    AppMethodBeat.i(137743);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setPlayBtnPosition %s", new Object[] { paramString });
    if ((!bt.isNullOrNil(paramString)) && (paramString.equalsIgnoreCase("center")))
    {
      this.kmN.setPlayBtnInCenterPosition(true);
      AppMethodBeat.o(137743);
      return;
    }
    this.kmN.setPlayBtnInCenterPosition(false);
    AppMethodBeat.o(137743);
  }
  
  public void setShowCenterPlayBtn(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(137766);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setShowCenterPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.knq = paramBoolean;
    View localView = this.kmO;
    if (paramBoolean)
    {
      i = 0;
      localView.setVisibility(i);
      localView = this.kmP;
      if (!paramBoolean) {
        break label104;
      }
    }
    label104:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      if ((this.knq) && (this.kmN != null)) {
        this.kmN.hide();
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
    ad.i("MicroMsg.Video.AppBrandVideoView", "setShowControlProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    e.a locala = this.kmN;
    if ((paramBoolean) && (!aXf())) {}
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
    ad.i("MicroMsg.Video.AppBrandVideoView", "setShowDanmakuBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (this.kmM == null) {
        bch();
      }
      this.kmN.setDanmakuBtnOnClickListener(new e.g()
      {
        public final void go(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(193726);
          if (paramAnonymousBoolean) {
            if (AppBrandVideoView.b(AppBrandVideoView.this).isPlaying()) {
              AppBrandVideoView.c(AppBrandVideoView.this).show();
            }
          }
          for (;;)
          {
            if (AppBrandVideoView.d(AppBrandVideoView.this) == null) {
              break label164;
            }
            com.tencent.mm.plugin.appbrand.jsapi.video.c.b localb = AppBrandVideoView.d(AppBrandVideoView.this);
            int i = AppBrandVideoView.e(AppBrandVideoView.this);
            try
            {
              ad.i("MicroMsg.Video.JsApiVideoCallback", "onVideoClickDanmuBtn showDanmu=%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              JSONObject localJSONObject = localb.bdC();
              localJSONObject.put("showDanmu", paramAnonymousBoolean);
              localJSONObject.put("videoPlayerId", i);
              localb.a(new b.b((byte)0), localJSONObject);
              AppMethodBeat.o(193726);
              return;
            }
            catch (JSONException localJSONException)
            {
              ad.e("MicroMsg.Video.JsApiVideoCallback", "onVideoClickDanmuBtn e=%s", new Object[] { localJSONException });
            }
            AppBrandVideoView.c(AppBrandVideoView.this).pause();
            continue;
            AppBrandVideoView.c(AppBrandVideoView.this).hide();
          }
          label164:
          AppMethodBeat.o(193726);
        }
      });
    }
    this.kmN.setShowDanmakuBtn(paramBoolean);
    AppMethodBeat.o(137768);
  }
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(137763);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setShowFullScreenBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kmN.setShowFullScreenBtn(paramBoolean);
    AppMethodBeat.o(137763);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(137740);
    ad.i("MicroMsg.Video.AppBrandVideoView", "showMuteBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kmN.setShowMuteBtn(paramBoolean);
    AppMethodBeat.o(137740);
  }
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(137764);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setShowPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kmN.setShowPlayBtn(paramBoolean);
    AppMethodBeat.o(137764);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(137762);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setShowProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.kno = paramBoolean;
    e.a locala = this.kmN;
    if (((paramBoolean) || (this.knp)) && (!aXf())) {}
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
    AppMethodBeat.i(193754);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setShowProgressInControlMode %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.knp = paramBoolean;
    e.a locala = this.kmN;
    if (((this.kno) || (paramBoolean)) && (!aXf())) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      locala.setShowProgress(paramBoolean);
      AppMethodBeat.o(193754);
      return;
    }
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(137741);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setTitle %s", new Object[] { paramString });
    this.kmN.setTitle(paramString);
    AppMethodBeat.o(137741);
  }
  
  public void setVideoPlayerId(int paramInt)
  {
    this.kna = paramInt;
  }
  
  public void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(137746);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setVideoSource %d", new Object[] { Integer.valueOf(paramInt) });
    this.knr = paramInt;
    AppMethodBeat.o(137746);
  }
  
  public final void start()
  {
    AppMethodBeat.i(137750);
    ad.i("MicroMsg.Video.AppBrandVideoView", "start");
    if (this.kmK.isPlaying())
    {
      ad.i("MicroMsg.Video.AppBrandVideoView", "start, video is playing");
      AppMethodBeat.o(137750);
      return;
    }
    if (!this.knx)
    {
      ad.i("MicroMsg.Video.AppBrandVideoView", "start, video not prepared");
      this.cnd = true;
    }
    if (this.knc) {
      this.kmN.bcF();
    }
    this.kmO.setVisibility(8);
    this.kmK.start();
    if ((this.kmM != null) && (this.kmN.bcy())) {
      this.kmM.show();
    }
    if (com.tencent.luggage.a.e.K(h.class) != null) {
      ((h)com.tencent.luggage.a.e.K(h.class)).report(this.kns);
    }
    AppMethodBeat.o(137750);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(137752);
    ad.i("MicroMsg.Video.AppBrandVideoView", "stop");
    if (!this.kmK.isPlaying())
    {
      ad.i("MicroMsg.Video.AppBrandVideoView", "stop, video not playing");
      AppMethodBeat.o(137752);
      return;
    }
    if (!this.knx)
    {
      ad.i("MicroMsg.Video.AppBrandVideoView", "stop, video not prepared");
      this.cnd = false;
      AppMethodBeat.o(137752);
      return;
    }
    this.kmK.stop();
    this.kmN.bcG();
    if (this.kmM != null) {
      this.kmM.hide();
    }
    AppMethodBeat.o(137752);
  }
  
  public static abstract interface a
  {
    public abstract void bah();
    
    public abstract boolean isFullScreen();
    
    public abstract void rM(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView
 * JD-Core Version:    0.7.0.1
 */