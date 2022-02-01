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
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.1;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.f;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.h;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.i;
import com.tencent.mm.plugin.appbrand.jsapi.video.c.b.m;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.3;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.4;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b;
import com.tencent.mm.plugin.appbrand.y.g;
import com.tencent.mm.plugin.appbrand.y.m;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandVideoView
  extends RelativeLayout
{
  private int acQ;
  private int atW;
  private boolean csJ;
  private boolean csv;
  private boolean csw;
  private boolean cvi;
  private int kSz;
  private a lpA;
  private boolean lpB;
  private boolean lpC;
  private double lpD;
  private String lpE;
  private boolean lpF;
  private boolean lpG;
  private boolean lpH;
  private boolean lpI;
  private boolean lpJ;
  private int lpK;
  private String lpL;
  private boolean lpM;
  private boolean lpN;
  private boolean lpO;
  private boolean lpP;
  private boolean lpQ;
  private aw lpR;
  private int lpS;
  private int lpT;
  private e.c lpU;
  private RelativeLayout lpc;
  public e lpd;
  private TextView lpe;
  private DanmuView lpf;
  public e.a lpg;
  private View lph;
  private View lpi;
  private TextView lpj;
  private LinearLayout lpk;
  private AppBrandDotPercentIndicator lpl;
  private TextView lpm;
  private ImageView lpn;
  private ImageView lpo;
  private ImageView lpp;
  private ImageView lpq;
  private FrameLayout lpr;
  private String lps;
  private int lpt;
  private com.tencent.mm.plugin.appbrand.jsapi.c lpu;
  private boolean lpv;
  public com.tencent.mm.plugin.appbrand.jsapi.video.c.b lpw;
  private boolean lpx;
  private boolean lpy;
  private com.tencent.mm.plugin.appbrand.jsapi.video.ui.a lpz;
  private String mAppId;
  private boolean mIsMute;
  
  public AppBrandVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(137735);
    this.acQ = -1;
    this.lpO = false;
    this.lpP = true;
    this.lpQ = false;
    this.cvi = false;
    this.lpS = 0;
    this.lpT = -16777216;
    init(paramContext);
    AppMethodBeat.o(137735);
  }
  
  public AppBrandVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(137736);
    this.acQ = -1;
    this.lpO = false;
    this.lpP = true;
    this.lpQ = false;
    this.cvi = false;
    this.lpS = 0;
    this.lpT = -16777216;
    init(paramContext);
    AppMethodBeat.o(137736);
  }
  
  public <T extends View,  extends e> AppBrandVideoView(Context paramContext, T paramT)
  {
    super(paramContext);
    AppMethodBeat.i(137734);
    this.acQ = -1;
    this.lpO = false;
    this.lpP = true;
    this.lpQ = false;
    this.cvi = false;
    this.lpS = 0;
    this.lpT = -16777216;
    this.lpd = ((e)paramT);
    init(paramContext);
    this.lpc.addView(paramT);
    AppMethodBeat.o(137734);
  }
  
  public <T extends View,  extends e> AppBrandVideoView(Context paramContext, T paramT, byte paramByte)
  {
    super(paramContext);
    AppMethodBeat.i(210932);
    this.acQ = -1;
    this.lpO = false;
    this.lpP = true;
    this.lpQ = false;
    this.cvi = false;
    this.lpS = 0;
    this.lpT = -16777216;
    this.lpd = ((e)paramT);
    this.lpT = -16777216;
    init(paramContext);
    this.lpc.addView(paramT);
    AppMethodBeat.o(210932);
  }
  
  private boolean bip()
  {
    AppMethodBeat.i(137791);
    if ((this.lpB) || (this.lpd.bip()))
    {
      AppMethodBeat.o(137791);
      return true;
    }
    AppMethodBeat.o(137791);
    return false;
  }
  
  private boolean bnA()
  {
    AppMethodBeat.i(137793);
    if ((!bnB()) && (((!bnx()) && (this.lpx)) || ((bnx()) && (this.lpy))))
    {
      AppMethodBeat.o(137793);
      return true;
    }
    AppMethodBeat.o(137793);
    return false;
  }
  
  private boolean bnB()
  {
    AppMethodBeat.i(137794);
    if (this.lph.getVisibility() == 0)
    {
      AppMethodBeat.o(137794);
      return true;
    }
    AppMethodBeat.o(137794);
    return false;
  }
  
  private void bnC()
  {
    AppMethodBeat.i(210937);
    if (this.lpR != null) {
      this.lpR.stopTimer();
    }
    AppMethodBeat.o(210937);
  }
  
  private void bns()
  {
    AppMethodBeat.i(210933);
    if (this.lpd != null) {
      this.lpd.bns();
    }
    AppMethodBeat.o(210933);
  }
  
  private void bnu()
  {
    AppMethodBeat.i(137780);
    this.lpz = new com.tencent.mm.plugin.appbrand.jsapi.video.ui.a(getContext(), this, new a.b()
    {
      public final void aC(float paramAnonymousFloat)
      {
        AppMethodBeat.i(210912);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(210912);
          return;
        }
        ae.d("MicroMsg.Video.AppBrandVideoView", "onAdjustVolume:".concat(String.valueOf(paramAnonymousFloat)));
        AppBrandVideoView.o(AppBrandVideoView.this).setPercent(paramAnonymousFloat);
        AppBrandVideoView.p(AppBrandVideoView.this).setText(2131760999);
        AppBrandVideoView.q(AppBrandVideoView.this).setImageResource(2131231041);
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(0);
        AppBrandVideoView.j(AppBrandVideoView.this);
        AppMethodBeat.o(210912);
      }
      
      public final void aD(float paramAnonymousFloat)
      {
        AppMethodBeat.i(210913);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(210913);
          return;
        }
        ae.d("MicroMsg.Video.AppBrandVideoView", "onAdjustBrightness:".concat(String.valueOf(paramAnonymousFloat)));
        AppBrandVideoView.o(AppBrandVideoView.this).setPercent(paramAnonymousFloat);
        AppBrandVideoView.p(AppBrandVideoView.this).setText(2131760998);
        AppBrandVideoView.q(AppBrandVideoView.this).setImageResource(2131231033);
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(0);
        AppBrandVideoView.j(AppBrandVideoView.this);
        AppMethodBeat.o(210913);
      }
      
      public final void bnF()
      {
        AppMethodBeat.i(210906);
        ae.d("MicroMsg.Video.AppBrandVideoView", "onSingleTap");
        if ((AppBrandVideoView.f(AppBrandVideoView.this)) && (AppBrandVideoView.g(AppBrandVideoView.this).getVisibility() != 0))
        {
          AppBrandVideoView.h(AppBrandVideoView.this).bnQ();
          if (AppBrandVideoView.i(AppBrandVideoView.this)) {
            AppBrandVideoView.j(AppBrandVideoView.this);
          }
        }
        AppMethodBeat.o(210906);
      }
      
      public final void bnG()
      {
        AppMethodBeat.i(210907);
        ae.d("MicroMsg.Video.AppBrandVideoView", "onDoubleTap");
        if (AppBrandVideoView.k(AppBrandVideoView.this))
        {
          if (AppBrandVideoView.b(AppBrandVideoView.this).isPlaying())
          {
            AppBrandVideoView.this.pause();
            AppMethodBeat.o(210907);
            return;
          }
          AppBrandVideoView.this.start();
        }
        AppMethodBeat.o(210907);
      }
      
      public final void bnH()
      {
        AppMethodBeat.i(210908);
        if (!AppBrandVideoView.l(AppBrandVideoView.this))
        {
          AppMethodBeat.o(210908);
          return;
        }
        AppBrandVideoView.m(AppBrandVideoView.this).setVisibility(0);
        AppBrandVideoView.j(AppBrandVideoView.this);
        AppMethodBeat.o(210908);
      }
      
      public final void bnI()
      {
        AppMethodBeat.i(210914);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(210914);
          return;
        }
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.n(AppBrandVideoView.this);
        AppMethodBeat.o(210914);
      }
      
      public final void bnJ()
      {
        AppMethodBeat.i(210915);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(210915);
          return;
        }
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.n(AppBrandVideoView.this);
        AppMethodBeat.o(210915);
      }
      
      public final boolean bnK()
      {
        AppMethodBeat.i(224436);
        boolean bool = AppBrandVideoView.s(AppBrandVideoView.this);
        AppMethodBeat.o(224436);
        return bool;
      }
      
      public final boolean bnL()
      {
        AppMethodBeat.i(224437);
        boolean bool = AppBrandVideoView.s(AppBrandVideoView.this);
        AppMethodBeat.o(224437);
        return bool;
      }
      
      public final boolean bnM()
      {
        AppMethodBeat.i(210918);
        boolean bool = AppBrandVideoView.l(AppBrandVideoView.this);
        AppMethodBeat.o(210918);
        return bool;
      }
      
      public final int getCurrentPosition()
      {
        AppMethodBeat.i(210911);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getCurrPosSec();
        AppMethodBeat.o(210911);
        return i;
      }
      
      public final int k(int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(210909);
        if (!AppBrandVideoView.l(AppBrandVideoView.this))
        {
          AppMethodBeat.o(210909);
          return 0;
        }
        ae.i("MicroMsg.Video.AppBrandVideoView", "onDragProgress:" + paramAnonymousInt + "/" + paramAnonymousFloat);
        paramAnonymousInt = AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec();
        int i = com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.a.c(paramAnonymousFloat, AppBrandVideoView.this.getMeasuredWidth(), getCurrentPosition(), paramAnonymousInt);
        String str = l.sz(paramAnonymousInt * 1000L);
        AppBrandVideoView.m(AppBrandVideoView.this).setText(l.sz(i * 1000L) + "/" + str);
        AppBrandVideoView.h(AppBrandVideoView.this).seek(i);
        if (AppBrandVideoView.h(AppBrandVideoView.this).bnS()) {
          AppBrandVideoView.h(AppBrandVideoView.this).bnY();
        }
        AppMethodBeat.o(210909);
        return i;
      }
      
      public final void l(int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(210910);
        if (!AppBrandVideoView.l(AppBrandVideoView.this))
        {
          AppMethodBeat.o(210910);
          return;
        }
        AppBrandVideoView.m(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.n(AppBrandVideoView.this);
        ae.i("MicroMsg.Video.AppBrandVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(AppBrandVideoView.b(AppBrandVideoView.this).getCurrPosSec()), Float.valueOf(paramAnonymousFloat) });
        AppBrandVideoView.this.d(paramAnonymousInt, false);
        AppMethodBeat.o(210910);
      }
    });
    AppMethodBeat.o(137780);
  }
  
  private void bnv()
  {
    AppMethodBeat.i(137781);
    this.lpg.bnv();
    AppMethodBeat.o(137781);
  }
  
  private void bnw()
  {
    AppMethodBeat.i(137782);
    this.lpd.setIMMVideoViewCallback(new e.c()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(210919);
        ae.i("MicroMsg.Video.AppBrandVideoView", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        com.tencent.mm.plugin.appbrand.jsapi.video.c.b localb;
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null)
        {
          localb = AppBrandVideoView.d(AppBrandVideoView.this);
          localb.clean();
        }
        try
        {
          JSONObject localJSONObject = localb.boS();
          localJSONObject.put("errMsg", paramAnonymousString3);
          localb.a(new b.d((byte)0), localJSONObject);
          if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
            AppBrandVideoView.t(AppBrandVideoView.this).c(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(210919);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ae.e("MicroMsg.Video.JsApiVideoCallback", "onError e=%s", new Object[] { localJSONException });
          }
        }
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(210922);
        ae.i("MicroMsg.Video.AppBrandVideoView", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        Object localObject;
        int i;
        if (AppBrandVideoView.G(AppBrandVideoView.this) == -1)
        {
          localObject = AppBrandVideoView.this;
          if (paramAnonymousInt1 >= paramAnonymousInt2) {
            break label242;
          }
          i = 0;
        }
        for (;;)
        {
          AppBrandVideoView.b((AppBrandVideoView)localObject, i);
          ae.i("MicroMsg.Video.AppBrandVideoView", "onGetVideoSize adjust direction from AUTO to %s", new Object[] { Integer.valueOf(AppBrandVideoView.G(AppBrandVideoView.this)) });
          if (AppBrandVideoView.d(AppBrandVideoView.this) != null)
          {
            localObject = AppBrandVideoView.d(AppBrandVideoView.this);
            i = AppBrandVideoView.this.getDuration();
          }
          try
          {
            ae.i("MicroMsg.Video.JsApiVideoCallback", "onVideoLoadedMetaData, width:%d, height:%d, duration:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i) });
            JSONObject localJSONObject = ((com.tencent.mm.plugin.appbrand.jsapi.video.c.b)localObject).boS();
            localJSONObject.put("width", paramAnonymousInt1);
            localJSONObject.put("height", paramAnonymousInt2);
            localJSONObject.put("duration", i * 1.0D / 1000.0D);
            ((com.tencent.mm.plugin.appbrand.jsapi.video.c.b)localObject).a(new b.f((byte)0), localJSONObject);
            if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
              AppBrandVideoView.t(AppBrandVideoView.this).d(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt1, paramAnonymousInt2);
            }
            AppMethodBeat.o(210922);
            return;
            label242:
            i = 90;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              ae.e("MicroMsg.Video.JsApiVideoCallback", "onVideoLoadedMetaData e=%s", new Object[] { localJSONException });
            }
          }
        }
      }
      
      public final void ds(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(210920);
        ae.i("MicroMsg.Video.AppBrandVideoView", "onPrepared");
        AppBrandVideoView.a(AppBrandVideoView.this, 0);
        AppBrandVideoView.u(AppBrandVideoView.this);
        AppBrandVideoView.v(AppBrandVideoView.this);
        if (AppBrandVideoView.w(AppBrandVideoView.this)) {
          AppBrandVideoView.this.start();
        }
        AppBrandVideoView.x(AppBrandVideoView.this).bpt();
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
          AppBrandVideoView.d(AppBrandVideoView.this);
        }
        if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
          AppBrandVideoView.t(AppBrandVideoView.this).ds(paramAnonymousString1, paramAnonymousString2);
        }
        AppMethodBeat.o(210920);
      }
      
      public final void dt(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(210921);
        ae.i("MicroMsg.Video.AppBrandVideoView", "onVideoEnded");
        AppBrandVideoView.y(AppBrandVideoView.this);
        AppBrandVideoView.m(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.h(AppBrandVideoView.this).setIsPlay(false);
        if ((AppBrandVideoView.h(AppBrandVideoView.this).bnS()) && (AppBrandVideoView.h(AppBrandVideoView.this).bnV())) {
          AppBrandVideoView.h(AppBrandVideoView.this).hide();
        }
        if (AppBrandVideoView.z(AppBrandVideoView.this).getVisibility() == 0) {
          AppBrandVideoView.z(AppBrandVideoView.this).setVisibility(8);
        }
        if ((AppBrandVideoView.A(AppBrandVideoView.this)) || (!AppBrandVideoView.B(AppBrandVideoView.this)))
        {
          AppBrandVideoView.C(AppBrandVideoView.this).setVisibility(8);
          AppBrandVideoView.g(AppBrandVideoView.this).setVisibility(8);
        }
        for (;;)
        {
          com.tencent.mm.plugin.appbrand.jsapi.video.c.b localb;
          if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
            localb = AppBrandVideoView.d(AppBrandVideoView.this);
          }
          try
          {
            localb.a(new b.c((byte)0), localb.boS());
            localb.boT();
            if (AppBrandVideoView.F(AppBrandVideoView.this)) {
              AppBrandVideoView.this.d(0.0D, true);
            }
            if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
              AppBrandVideoView.t(AppBrandVideoView.this).dt(paramAnonymousString1, paramAnonymousString2);
            }
            AppMethodBeat.o(210921);
            return;
            if (AppBrandVideoView.D(AppBrandVideoView.this) <= 0) {
              AppBrandVideoView.E(AppBrandVideoView.this).setText(AppBrandVideoView.tw(AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec()));
            }
            AppBrandVideoView.C(AppBrandVideoView.this).setVisibility(0);
            AppBrandVideoView.g(AppBrandVideoView.this).setVisibility(0);
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              ae.e("MicroMsg.Video.JsApiVideoCallback", "OnVideoEnded e=%s", new Object[] { localJSONException });
            }
          }
        }
      }
      
      public final void du(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(210923);
        ae.i("MicroMsg.Video.AppBrandVideoView", "onVideoPause");
        com.tencent.mm.plugin.appbrand.jsapi.video.c.b localb;
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
          localb = AppBrandVideoView.d(AppBrandVideoView.this);
        }
        try
        {
          localb.a(new b.g((byte)0), localb.boS());
          localb.boT();
          if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
            AppBrandVideoView.t(AppBrandVideoView.this).du(paramAnonymousString1, paramAnonymousString2);
          }
          AppMethodBeat.o(210923);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ae.e("MicroMsg.Video.JsApiVideoCallback", "OnVideoPause e=%s", new Object[] { localJSONException });
          }
        }
      }
      
      public final void dv(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(210924);
        ae.i("MicroMsg.Video.AppBrandVideoView", "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(AppBrandVideoView.A(AppBrandVideoView.this)) });
        if ((AppBrandVideoView.D(AppBrandVideoView.this) <= 0) && (!AppBrandVideoView.A(AppBrandVideoView.this))) {
          AppBrandVideoView.E(AppBrandVideoView.this).setText(AppBrandVideoView.tw(AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec()));
        }
        AppBrandVideoView.a(AppBrandVideoView.this, AppBrandVideoView.A(AppBrandVideoView.this));
        if (AppBrandVideoView.f(AppBrandVideoView.this)) {
          AppBrandVideoView.H(AppBrandVideoView.this);
        }
        com.tencent.mm.plugin.appbrand.jsapi.video.c.b localb;
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
          localb = AppBrandVideoView.d(AppBrandVideoView.this);
        }
        try
        {
          localb.lul = 0;
          JSONObject localJSONObject = localb.boS();
          localJSONObject.put("timeStamp", System.currentTimeMillis());
          localb.a(new b.h((byte)0), localJSONObject);
          if (localb.luk == null) {
            localb.luk = new aw(new b.1(localb), true);
          }
          localb.luk.ay(250L, 250L);
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ae.e("MicroMsg.Video.JsApiVideoCallback", "OnVideoPlay e=%s", new Object[] { localJSONException });
          }
        }
        if ((AppBrandVideoView.I(AppBrandVideoView.this) != null) && ("wxfe02ecfe70800f46".equalsIgnoreCase(AppBrandVideoView.I(AppBrandVideoView.this).getAppId())))
        {
          ae.i("MicroMsg.Video.AppBrandVideoView", "onVideoPlay, send play event");
          com.tencent.mm.sdk.b.a.IvT.l(new com.tencent.mm.plugin.appbrand.jsapi.video.c.a());
        }
        if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
          AppBrandVideoView.t(AppBrandVideoView.this).dv(paramAnonymousString1, paramAnonymousString2);
        }
        AppMethodBeat.o(210924);
      }
      
      public final void dw(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(210925);
        ae.i("MicroMsg.Video.AppBrandVideoView", "onVideoWaiting");
        com.tencent.mm.plugin.appbrand.jsapi.video.c.b localb;
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
          localb = AppBrandVideoView.d(AppBrandVideoView.this);
        }
        try
        {
          JSONObject localJSONObject = localb.boS();
          localJSONObject.put("timeStamp", System.currentTimeMillis());
          localb.a(new b.m((byte)0), localJSONObject);
          AppBrandVideoView.b(AppBrandVideoView.this, true);
          AppBrandVideoView.j(AppBrandVideoView.this);
          if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
            AppBrandVideoView.t(AppBrandVideoView.this).dw(paramAnonymousString1, paramAnonymousString2);
          }
          AppMethodBeat.o(210925);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            ae.e("MicroMsg.Video.JsApiVideoCallback", "onVideoWaiting e=%s", new Object[] { localJSONException });
          }
        }
      }
      
      public final void dx(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(210926);
        AppBrandVideoView.b(AppBrandVideoView.this, false);
        AppBrandVideoView.n(AppBrandVideoView.this);
        if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
          AppBrandVideoView.t(AppBrandVideoView.this).dx(paramAnonymousString1, paramAnonymousString2);
        }
        AppMethodBeat.o(210926);
      }
    });
    AppMethodBeat.o(137782);
  }
  
  private void bny()
  {
    AppMethodBeat.i(137786);
    this.lpf = ((DanmuView)findViewById(2131298920));
    this.lpf.setDanmuViewCallBack(new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.c()
    {
      public final int aHc()
      {
        AppMethodBeat.i(210927);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getCurrPosSec();
        AppMethodBeat.o(210927);
        return i;
      }
    });
    this.lpf.boQ();
    this.lpf.setMaxRunningPerRow(5);
    this.lpf.setPickItemInterval(200);
    this.lpf.hide();
    if ((this.lpd != null) && (((View)this.lpd).getHeight() > 0))
    {
      float f = this.lpf.getYOffset();
      int i = (int)(((View)this.lpd).getHeight() * f);
      f = com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b.dB(getContext());
      this.lpf.setMaxRow((int)(i / f));
    }
    AppMethodBeat.o(137786);
  }
  
  private boolean bnz()
  {
    AppMethodBeat.i(137792);
    if ((this.lpG) && (!this.lpd.bip()) && (!bnB()))
    {
      AppMethodBeat.o(137792);
      return true;
    }
    AppMethodBeat.o(137792);
    return false;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(137737);
    LayoutInflater.from(paramContext).inflate(2131493072, this);
    setBackgroundColor(this.lpT);
    this.lpc = ((RelativeLayout)findViewById(2131306410));
    this.lpe = ((TextView)findViewById(2131303515));
    this.lph = findViewById(2131298814);
    this.lpi = findViewById(2131298828);
    this.lpj = ((TextView)findViewById(2131298832));
    this.lpk = ((LinearLayout)findViewById(2131296505));
    this.lpl = ((AppBrandDotPercentIndicator)findViewById(2131296506));
    this.lpm = ((TextView)findViewById(2131296502));
    this.lpn = ((ImageView)findViewById(2131296504));
    this.lpo = ((ImageView)findViewById(2131298813));
    this.lpp = ((ImageView)findViewById(2131303297));
    this.lpq = ((ImageView)findViewById(2131303296));
    this.lpr = ((FrameLayout)findViewById(2131303298));
    this.lpl.setDotsNum(8);
    ((ImageView)findViewById(2131298827)).setOnClickListener(new AppBrandVideoView.1(this));
    bnu();
    bnw();
    AppMethodBeat.o(137737);
  }
  
  private void setCover(final String paramString)
  {
    AppMethodBeat.i(137761);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(137761);
      return;
    }
    if (!bu.isNullOrNil(this.lpE))
    {
      ae.i("MicroMsg.Video.AppBrandVideoView", "setCover mCoverUrl not null");
      AppMethodBeat.o(137761);
      return;
    }
    m.bCj().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(210904);
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(210903);
            if ((this.val$bitmap != null) && (!this.val$bitmap.isRecycled())) {
              AppBrandVideoView.a(AppBrandVideoView.this).setImageBitmap(this.val$bitmap);
            }
            AppMethodBeat.o(210903);
          }
        });
        AppMethodBeat.o(210904);
      }
    });
    AppMethodBeat.o(137761);
  }
  
  private static String tu(int paramInt)
  {
    AppMethodBeat.i(137788);
    String str = tv(paramInt / 60) + ":" + tv(paramInt % 60);
    AppMethodBeat.o(137788);
    return str;
  }
  
  private static String tv(int paramInt)
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
  
  public final void a(e.a parama)
  {
    AppMethodBeat.i(137787);
    this.lpg = parama;
    if (((this.lpg instanceof View)) && (this.lpg != null))
    {
      parama = (View)this.lpg;
      if (parama.getId() != -1) {
        parama.setId(2131296841);
      }
    }
    this.lpg.hide();
    this.lpg.setFullScreenBtnOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210928);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (!AppBrandVideoView.this.bnx()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView = AppBrandVideoView.this;
          paramAnonymousView.q(bool, AppBrandVideoView.G(paramAnonymousView));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(210928);
          return;
        }
      }
    });
    this.lpg.setIplaySeekCallback(new e.d()
    {
      public final void aqS()
      {
        AppMethodBeat.i(210929);
        ae.i("MicroMsg.Video.AppBrandVideoView", "onSeekPre");
        AppMethodBeat.o(210929);
      }
      
      public final void nP(int paramAnonymousInt)
      {
        AppMethodBeat.i(210930);
        AppBrandVideoView.this.d(paramAnonymousInt, false);
        AppMethodBeat.o(210930);
      }
    });
    this.lpg.setOnPlayButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210931);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (AppBrandVideoView.b(AppBrandVideoView.this).isPlaying()) {
          AppBrandVideoView.this.pause();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(210931);
          return;
          AppBrandVideoView.this.start();
        }
      }
    });
    this.lpg.setStatePorter(new e.i()
    {
      public final int bnD()
      {
        AppMethodBeat.i(210897);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getCacheTimeSec();
        AppMethodBeat.o(210897);
        return i;
      }
      
      public final int bnE()
      {
        AppMethodBeat.i(210898);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec();
        AppMethodBeat.o(210898);
        return i;
      }
    });
    this.lpg.setMuteBtnOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(210899);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramAnonymousView = AppBrandVideoView.this;
        if (!AppBrandVideoView.J(AppBrandVideoView.this)) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setMute(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(210899);
          return;
        }
      }
    });
    this.lpg.setExitFullScreenBtnOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(137702);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        AppBrandVideoView.this.q(false, AppBrandVideoView.G(AppBrandVideoView.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(137702);
      }
    });
    this.lpg.a(new e.f()
    {
      public final void onVisibilityChanged(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(210900);
        AppBrandVideoView.H(AppBrandVideoView.this);
        AppMethodBeat.o(210900);
      }
    });
    this.lpg.setOnUpdateProgressLenListener(new e.e()
    {
      public final void onProgressChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(210901);
        if (paramAnonymousInt2 <= 0)
        {
          AppMethodBeat.o(210901);
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
          paramAnonymousInt1 = i * AppBrandVideoView.K(AppBrandVideoView.this).getWidth() / paramAnonymousInt2;
          FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)AppBrandVideoView.L(AppBrandVideoView.this).getLayoutParams();
          localLayoutParams.width = paramAnonymousInt1;
          AppBrandVideoView.L(AppBrandVideoView.this).setLayoutParams(localLayoutParams);
          AppBrandVideoView.L(AppBrandVideoView.this).requestLayout();
          AppMethodBeat.o(210901);
          return;
        }
      }
    });
    AppMethodBeat.o(137787);
  }
  
  public final void bnt()
  {
    AppMethodBeat.i(210934);
    d(0.0D, false);
    AppMethodBeat.o(210934);
  }
  
  public final boolean bnx()
  {
    AppMethodBeat.i(137785);
    if (this.lpA == null)
    {
      ae.w("MicroMsg.Video.AppBrandVideoView", "isInFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(137785);
      return false;
    }
    boolean bool = this.lpA.isFullScreen();
    AppMethodBeat.o(137785);
    return bool;
  }
  
  public final void clean()
  {
    AppMethodBeat.i(137756);
    ae.i("MicroMsg.Video.AppBrandVideoView", "clean");
    stop();
    this.lpd.onUIDestroy();
    if (this.lpf != null) {
      this.lpf.clear();
    }
    this.lpg.onDestroy();
    bnC();
    AppMethodBeat.o(137756);
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(137758);
    int i = this.lpd.getCurrPosSec();
    ae.i("MicroMsg.Video.AppBrandVideoView", "seek to position=%s current=%d isLive=%b", new Object[] { Double.valueOf(paramDouble), Integer.valueOf(i), Boolean.valueOf(this.lpB) });
    if (bip())
    {
      AppMethodBeat.o(137758);
      return;
    }
    this.lph.setVisibility(8);
    if (paramBoolean) {
      this.lpd.c(paramDouble, paramBoolean);
    }
    for (;;)
    {
      if ((this.lpf != null) && (i > paramDouble)) {
        this.lpf.tG((int)paramDouble);
      }
      AppMethodBeat.o(137758);
      return;
      this.lpd.o(paramDouble);
    }
  }
  
  public final boolean dr(String arg1, String paramString2)
  {
    AppMethodBeat.i(137779);
    if (this.lpf == null)
    {
      ae.w("MicroMsg.Video.AppBrandVideoView", " addDanmaku mDanmakuView null");
      bny();
    }
    int j = g.VH(paramString2);
    int i = j;
    if (j == 0) {
      i = -1;
    }
    paramString2 = new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a(getContext(), new SpannableString(???), i, this.lpd.getCurrPosSec());
    DanmuView localDanmuView = this.lpf;
    synchronized (localDanmuView.ltX)
    {
      localDanmuView.ltX.offerFirst(paramString2);
      com.tencent.e.h.MqF.f(new DanmuView.3(localDanmuView, paramString2), "DanmuView-addItemToWaitingHead");
      AppMethodBeat.o(137779);
      return true;
    }
  }
  
  public final void e(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(137757);
    String str = paramString;
    if (this.lpu != null)
    {
      str = paramString;
      if (this.lpu.Fl() != null)
      {
        str = paramString;
        if (this.lpu.Fl().LZ(paramString))
        {
          paramString = this.lpu.Fl().MP(paramString);
          if (paramString != null) {
            break label124;
          }
        }
      }
    }
    label124:
    for (paramString = null;; paramString = "file://" + w.B(paramString.fTh()))
    {
      str = paramString;
      ae.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath path=%s isLive=%s", new Object[] { str, Boolean.valueOf(paramBoolean) });
      if (!bu.isNullOrNil(str)) {
        break;
      }
      ae.v("MicroMsg.Video.AppBrandVideoView", "setVideoPath videoPath empty");
      AppMethodBeat.o(137757);
      return;
    }
    stop();
    this.lpB = paramBoolean;
    this.lpL = str;
    this.lpd.setVideoSource(this.lpK);
    this.lpd.c(paramBoolean, str, paramInt);
    if (this.lpD > 0.0D) {
      this.lpd.c(this.lpD, this.csJ);
    }
    Object localObject;
    if ((this.lpK == 1) && (com.tencent.luggage.a.e.K(h.class) != null))
    {
      localObject = ((h)com.tencent.luggage.a.e.K(h.class)).Ro(this.lpL);
      if (localObject != null)
      {
        ae.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath localVideoPath:%s", new Object[] { localObject });
        paramString = this.lpL;
        ae.i("MicroMsg.Video.AppBrandVideoView", "leonlad setPreLoadVideoPath %s", new Object[] { localObject });
        if ((!this.lpd.isPlaying()) && (this.lpL.equalsIgnoreCase(paramString)))
        {
          this.lpL = paramString;
          this.lpd.c(this.lpB, (String)localObject, 0);
          if (!this.csJ) {
            break label452;
          }
          ae.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay true");
          start();
        }
      }
    }
    for (;;)
    {
      if (this.lpw != null) {
        localObject = this.lpw;
      }
      try
      {
        JSONObject localJSONObject = ((com.tencent.mm.plugin.appbrand.jsapi.video.c.b)localObject).boS();
        localJSONObject.put("timeStamp", System.currentTimeMillis());
        localJSONObject.put("url", paramString);
        ((com.tencent.mm.plugin.appbrand.jsapi.video.c.b)localObject).a(new b.a((byte)0), localJSONObject);
        if (this.csJ)
        {
          ae.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay true");
          start();
          setCover(str);
          AppMethodBeat.o(137757);
          return;
          label452:
          ae.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay false");
          bns();
        }
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          ae.e("MicroMsg.Video.JsApiVideoCallback", "onVideoCanPlay e=%s", new Object[] { paramString });
          continue;
          ae.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay false");
          bns();
        }
      }
    }
  }
  
  public final void gP(boolean paramBoolean)
  {
    AppMethodBeat.i(137765);
    ae.i("MicroMsg.Video.AppBrandVideoView", "enableProgressGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpG = paramBoolean;
    AppMethodBeat.o(137765);
  }
  
  public final void gQ(boolean paramBoolean)
  {
    AppMethodBeat.i(137790);
    if (this.lpw == null)
    {
      AppMethodBeat.o(137790);
      return;
    }
    this.lpw.c(this.lpt, paramBoolean, this.kSz);
    AppMethodBeat.o(137790);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(137773);
    if (this.lpd != null)
    {
      int i = this.lpd.getCacheTimeSec();
      AppMethodBeat.o(137773);
      return i;
    }
    AppMethodBeat.o(137773);
    return 0;
  }
  
  public com.tencent.mm.plugin.appbrand.jsapi.video.c.b getCallback()
  {
    return this.lpw;
  }
  
  public String getCookieData()
  {
    return this.lps;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(137772);
    int i = this.lpd.getCurrPosMs();
    AppMethodBeat.o(137772);
    return i;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(137771);
    int i = this.lpd.getCurrPosSec();
    AppMethodBeat.o(137771);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(137748);
    if (this.atW > 0)
    {
      i = this.atW;
      AppMethodBeat.o(137748);
      return i;
    }
    int i = this.lpd.getVideoDurationSec();
    AppMethodBeat.o(137748);
    return i;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(137783);
    if (this.lpN) {
      bool = true;
    }
    while (bool)
    {
      if (this.lpz != null) {
        this.lpz.w(paramMotionEvent);
      }
      AppMethodBeat.o(137783);
      return true;
      bool = bnz();
      if (!bnA()) {
        bool = false;
      }
    }
    if ((paramMotionEvent.getAction() == 0) && (this.lpv) && (this.lph.getVisibility() != 0))
    {
      this.lpg.bnQ();
      if (this.lpM) {
        bnv();
      }
    }
    if (this.lpF)
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
    ae.i("MicroMsg.Video.AppBrandVideoView", "onUIDestroy");
    clean();
    AppMethodBeat.o(137755);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(137753);
    ae.i("MicroMsg.Video.AppBrandVideoView", "onUIResume");
    if (this.lpO)
    {
      ae.i("MicroMsg.Video.AppBrandVideoView", "onUIResume, should skip ui resume");
      this.lpO = false;
      AppMethodBeat.o(137753);
      return;
    }
    this.lpd.onUIResume();
    AppMethodBeat.o(137753);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137751);
    ae.i("MicroMsg.Video.AppBrandVideoView", "pause");
    if (!this.lpQ)
    {
      ae.i("MicroMsg.Video.AppBrandVideoView", "pause, video not prepared");
      this.cvi = false;
      AppMethodBeat.o(137751);
      return;
    }
    if (!this.lpd.isPlaying())
    {
      ae.i("MicroMsg.Video.AppBrandVideoView", "pause, video not playing");
      AppMethodBeat.o(137751);
      return;
    }
    this.lpd.pause();
    if ((this.lpf != null) && (this.lpg.bnP())) {
      this.lpf.pause();
    }
    AppMethodBeat.o(137751);
  }
  
  public final void q(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(137784);
    ae.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen toFullScreen:%b direction:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.lpA == null)
    {
      ae.w("MicroMsg.Video.AppBrandVideoView", "operateFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(137784);
      return;
    }
    if (paramBoolean == bnx())
    {
      ae.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen current same");
      AppMethodBeat.o(137784);
      return;
    }
    if (paramInt == -1) {
      if (this.acQ == -1)
      {
        paramInt = 90;
        ae.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen target direction:%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        this.kSz = paramInt;
        this.lpA.th(paramInt);
        this.lpg.bnT();
        gQ(true);
        AppMethodBeat.o(137784);
        return;
        paramInt = this.acQ;
        break;
      }
      this.lpA.blp();
      this.lpg.blp();
      AppMethodBeat.o(137784);
      return;
    }
  }
  
  public void setAutoPauseIfNavigate(boolean paramBoolean)
  {
    this.csv = paramBoolean;
  }
  
  public void setAutoPauseIfOpenNative(boolean paramBoolean)
  {
    this.csw = paramBoolean;
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(137745);
    ae.i("MicroMsg.Video.AppBrandVideoView", "setAutoPlay %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.csJ = paramBoolean;
    AppMethodBeat.o(137745);
  }
  
  public void setCallback(com.tencent.mm.plugin.appbrand.jsapi.video.c.b paramb)
  {
    this.lpw = paramb;
  }
  
  public void setComponent(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(137738);
    this.lpu = paramc;
    this.mAppId = paramc.getAppId();
    AppMethodBeat.o(137738);
  }
  
  public void setConsumeTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(137739);
    ae.i("MicroMsg.Video.AppBrandVideoView", "setConsumeTouchEvent game=%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpF = paramBoolean;
    AppMethodBeat.o(137739);
  }
  
  public void setCookieData(String paramString)
  {
    this.lps = paramString;
  }
  
  public final void setCover$16da05f7(String paramString)
  {
    AppMethodBeat.i(137760);
    ae.i("MicroMsg.Video.AppBrandVideoView", "setCover:%s", new Object[] { paramString });
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(137760);
      return;
    }
    this.lpE = paramString;
    com.tencent.mm.modelappbrand.a.b.aEl().a(this.lpo, paramString, null, null);
    AppMethodBeat.o(137760);
  }
  
  public void setDanmakuEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(137767);
    ae.i("MicroMsg.Video.AppBrandVideoView", "setDanmakuEnable %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpg.setDanmakuBtnOpen(paramBoolean);
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
      ae.i("MicroMsg.Video.AppBrandVideoView", "setDanmakuItemList length=%d", new Object[] { Integer.valueOf(i) });
      if (this.lpf == null)
      {
        ae.w("MicroMsg.Video.AppBrandVideoView", "setDanmakuItemList mDanmakuView null");
        bny();
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
      int k = g.VH(((JSONObject)localObject).optString("color", ""));
      j = k;
      if (k == 0) {
        j = -1;
      }
    }
    label203:
    paramJSONArray = this.lpf;
    paramJSONArray.boM();
    paramJSONArray.clearItems();
    paramJSONArray.ltY.clear();
    paramJSONArray.prepare();
    if (localArrayList.isEmpty())
    {
      paramJSONArray.boN();
      AppMethodBeat.o(137778);
      return;
    }
    com.tencent.e.h.MqF.aR(new DanmuView.4(paramJSONArray, localArrayList));
    paramJSONArray.boN();
    AppMethodBeat.o(137778);
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(137747);
    if (paramInt <= 0)
    {
      ae.i("MicroMsg.Video.AppBrandVideoView", "setDuration error duration=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137747);
      return;
    }
    this.lpj.setText(tu(paramInt));
    this.atW = paramInt;
    AppMethodBeat.o(137747);
  }
  
  public void setEnablePlayGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(137744);
    ae.i("MicroMsg.Video.AppBrandVideoView", "setEnablePlayGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpN = paramBoolean;
    AppMethodBeat.o(137744);
  }
  
  public void setFullScreenDelegate(a parama)
  {
    this.lpA = parama;
  }
  
  public void setFullScreenDirection(int paramInt)
  {
    AppMethodBeat.i(137774);
    ae.i("MicroMsg.Video.AppBrandVideoView", "setFullScreenDirection %d", new Object[] { Integer.valueOf(paramInt) });
    this.acQ = paramInt;
    AppMethodBeat.o(137774);
  }
  
  public void setFullScreenState(boolean paramBoolean)
  {
    AppMethodBeat.i(210936);
    if (paramBoolean)
    {
      this.lpg.bnT();
      AppMethodBeat.o(210936);
      return;
    }
    this.lpg.blp();
    AppMethodBeat.o(210936);
  }
  
  public void setIMMVideoViewCallback(e.c paramc)
  {
    this.lpU = paramc;
  }
  
  public void setInitialTime(double paramDouble)
  {
    AppMethodBeat.i(137777);
    ae.i("MicroMsg.Video.AppBrandVideoView", "setInitialTime %s", new Object[] { Double.valueOf(paramDouble) });
    this.lpD = paramDouble;
    AppMethodBeat.o(137777);
  }
  
  public void setIsEnableBottomProgressBar(boolean paramBoolean)
  {
    this.lpP = paramBoolean;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(137759);
    ae.i("MicroMsg.Video.AppBrandVideoView", "setIsShowBasicControls %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpv = paramBoolean;
    if (this.lpg != null)
    {
      if (this.lpv)
      {
        this.lpg.bnR();
        AppMethodBeat.o(137759);
        return;
      }
      this.lpg.hide();
    }
    AppMethodBeat.o(137759);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(137749);
    ae.i("MicroMsg.Video.AppBrandVideoView", "setLoop %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpC = paramBoolean;
    AppMethodBeat.o(137749);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(137770);
    ae.i("MicroMsg.Video.AppBrandVideoView", "setMute %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mIsMute = paramBoolean;
    this.lpd.setMute(paramBoolean);
    this.lpg.setMuteBtnState(paramBoolean);
    AppMethodBeat.o(137770);
  }
  
  public void setObjectFit(String paramString)
  {
    AppMethodBeat.i(137769);
    ae.i("MicroMsg.Video.AppBrandVideoView", "setObjectFit %s", new Object[] { paramString });
    if ("fill".equalsIgnoreCase(paramString))
    {
      this.lpd.setScaleType(e.h.lqn);
      this.lpo.setScaleType(ImageView.ScaleType.FIT_XY);
      AppMethodBeat.o(137769);
      return;
    }
    if ("cover".equalsIgnoreCase(paramString))
    {
      this.lpd.setScaleType(e.h.lqp);
      this.lpo.setScaleType(ImageView.ScaleType.CENTER_CROP);
      AppMethodBeat.o(137769);
      return;
    }
    this.lpd.setScaleType(e.h.lqo);
    this.lpo.setScaleType(ImageView.ScaleType.FIT_CENTER);
    AppMethodBeat.o(137769);
  }
  
  public void setPageGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(137775);
    ae.i("MicroMsg.Video.AppBrandVideoView", "setPageGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpx = paramBoolean;
    AppMethodBeat.o(137775);
  }
  
  public void setPageGestureInFullscreen(boolean paramBoolean)
  {
    AppMethodBeat.i(137776);
    ae.i("MicroMsg.Video.AppBrandVideoView", "setPageGestureInFullscreen %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpy = paramBoolean;
    AppMethodBeat.o(137776);
  }
  
  public void setPlayBtnPosition(String paramString)
  {
    AppMethodBeat.i(137743);
    ae.i("MicroMsg.Video.AppBrandVideoView", "setPlayBtnPosition %s", new Object[] { paramString });
    if ((!bu.isNullOrNil(paramString)) && (paramString.equalsIgnoreCase("center")))
    {
      this.lpg.setPlayBtnInCenterPosition(true);
      AppMethodBeat.o(137743);
      return;
    }
    this.lpg.setPlayBtnInCenterPosition(false);
    AppMethodBeat.o(137743);
  }
  
  public void setShowCenterPlayBtn(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(137766);
    ae.i("MicroMsg.Video.AppBrandVideoView", "setShowCenterPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpJ = paramBoolean;
    View localView = this.lph;
    if (paramBoolean)
    {
      i = 0;
      localView.setVisibility(i);
      localView = this.lpi;
      if (!paramBoolean) {
        break label104;
      }
    }
    label104:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      if ((this.lpJ) && (this.lpg != null)) {
        this.lpg.hide();
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
    ae.i("MicroMsg.Video.AppBrandVideoView", "setShowControlProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    e.a locala = this.lpg;
    if ((paramBoolean) && (!bip())) {}
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
    ae.i("MicroMsg.Video.AppBrandVideoView", "setShowDanmakuBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (this.lpf == null) {
        bny();
      }
      this.lpg.setDanmakuBtnOnClickListener(new e.g()
      {
        public final void gR(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(210905);
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
              ae.i("MicroMsg.Video.JsApiVideoCallback", "onVideoClickDanmuBtn showDanmu=%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              JSONObject localJSONObject = localb.boS();
              localJSONObject.put("showDanmu", paramAnonymousBoolean);
              localJSONObject.put("videoPlayerId", i);
              localb.a(new b.b((byte)0), localJSONObject);
              AppMethodBeat.o(210905);
              return;
            }
            catch (JSONException localJSONException)
            {
              ae.e("MicroMsg.Video.JsApiVideoCallback", "onVideoClickDanmuBtn e=%s", new Object[] { localJSONException });
            }
            AppBrandVideoView.c(AppBrandVideoView.this).pause();
            continue;
            AppBrandVideoView.c(AppBrandVideoView.this).hide();
          }
          label164:
          AppMethodBeat.o(210905);
        }
      });
    }
    this.lpg.setShowDanmakuBtn(paramBoolean);
    AppMethodBeat.o(137768);
  }
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(137763);
    ae.i("MicroMsg.Video.AppBrandVideoView", "setShowFullScreenBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpg.setShowFullScreenBtn(paramBoolean);
    AppMethodBeat.o(137763);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(137740);
    ae.i("MicroMsg.Video.AppBrandVideoView", "showMuteBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpg.setShowMuteBtn(paramBoolean);
    AppMethodBeat.o(137740);
  }
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(137764);
    ae.i("MicroMsg.Video.AppBrandVideoView", "setShowPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpg.setShowPlayBtn(paramBoolean);
    AppMethodBeat.o(137764);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(137762);
    ae.i("MicroMsg.Video.AppBrandVideoView", "setShowProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpH = paramBoolean;
    e.a locala = this.lpg;
    if (((paramBoolean) || (this.lpI)) && (!bip())) {}
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
    AppMethodBeat.i(210935);
    ae.i("MicroMsg.Video.AppBrandVideoView", "setShowProgressInControlMode %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lpI = paramBoolean;
    e.a locala = this.lpg;
    if (((this.lpH) || (paramBoolean)) && (!bip())) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      locala.setShowProgress(paramBoolean);
      AppMethodBeat.o(210935);
      return;
    }
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(137741);
    ae.i("MicroMsg.Video.AppBrandVideoView", "setTitle %s", new Object[] { paramString });
    this.lpg.setTitle(paramString);
    AppMethodBeat.o(137741);
  }
  
  public void setVideoPlayerId(int paramInt)
  {
    this.lpt = paramInt;
  }
  
  public void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(137746);
    ae.i("MicroMsg.Video.AppBrandVideoView", "setVideoSource %d", new Object[] { Integer.valueOf(paramInt) });
    this.lpK = paramInt;
    AppMethodBeat.o(137746);
  }
  
  public final void start()
  {
    AppMethodBeat.i(137750);
    ae.i("MicroMsg.Video.AppBrandVideoView", "start");
    if (this.lpd.isPlaying())
    {
      ae.i("MicroMsg.Video.AppBrandVideoView", "start, video is playing");
      AppMethodBeat.o(137750);
      return;
    }
    if (!this.lpQ) {
      ae.i("MicroMsg.Video.AppBrandVideoView", "start, video not prepared");
    }
    for (this.cvi = true;; this.cvi = false)
    {
      if (this.lpv) {
        this.lpg.bnW();
      }
      this.lph.setVisibility(8);
      this.lpd.start();
      if ((this.lpf != null) && (this.lpg.bnP())) {
        this.lpf.show();
      }
      if (com.tencent.luggage.a.e.K(h.class) != null) {
        ((h)com.tencent.luggage.a.e.K(h.class)).report(this.lpL);
      }
      AppMethodBeat.o(137750);
      return;
      ae.i("MicroMsg.Video.AppBrandVideoView", "start, video prepared, reset control flag");
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(137752);
    ae.i("MicroMsg.Video.AppBrandVideoView", "stop");
    if (!this.lpQ)
    {
      ae.i("MicroMsg.Video.AppBrandVideoView", "stop, video not prepared");
      this.cvi = false;
      AppMethodBeat.o(137752);
      return;
    }
    if (!this.lpd.isPlaying())
    {
      ae.i("MicroMsg.Video.AppBrandVideoView", "stop, video not playing");
      AppMethodBeat.o(137752);
      return;
    }
    this.lpd.stop();
    this.lpg.bnX();
    if (this.lpf != null) {
      this.lpf.hide();
    }
    AppMethodBeat.o(137752);
  }
  
  public final void tt(int paramInt)
  {
    AppMethodBeat.i(137754);
    ae.i("MicroMsg.Video.AppBrandVideoView", "onUIPause, type:%d", new Object[] { Integer.valueOf(paramInt) });
    if (((paramInt == 2) && (!this.csw)) || ((paramInt == 1) && (!this.csv)))
    {
      ae.i("MicroMsg.Video.AppBrandVideoView", "onUIPause, should skip ui pause");
      this.lpO = true;
      AppMethodBeat.o(137754);
      return;
    }
    this.lpd.onUIPause();
    AppMethodBeat.o(137754);
  }
  
  public static abstract interface a
  {
    public abstract void blp();
    
    public abstract boolean isFullScreen();
    
    public abstract void th(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView
 * JD-Core Version:    0.7.0.1
 */