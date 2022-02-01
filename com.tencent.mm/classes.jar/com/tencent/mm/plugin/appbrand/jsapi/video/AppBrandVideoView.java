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
import com.tencent.luggage.b.d.a.c;
import com.tencent.luggage.b.d.a.d;
import com.tencent.luggage.b.d.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.appstorage.r;
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
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
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
  private int alM;
  private boolean cFF;
  private boolean cFq;
  private boolean cFr;
  private boolean cJK;
  private String mAppId;
  private boolean mIsMute;
  private boolean mLoop;
  private int oVs;
  private com.tencent.mm.plugin.appbrand.jsapi.e puA;
  private boolean puB;
  public com.tencent.mm.plugin.appbrand.jsapi.video.c.b puC;
  private boolean puD;
  private boolean puE;
  private com.tencent.mm.plugin.appbrand.jsapi.video.ui.a puF;
  private a puG;
  private boolean puH;
  private double puI;
  private String puJ;
  private boolean puK;
  private boolean puL;
  private boolean puM;
  private boolean puN;
  private boolean puO;
  private int puP;
  private String puQ;
  private boolean puR;
  private boolean puS;
  private boolean puT;
  private boolean puU;
  private boolean puV;
  private MTimerHandler puW;
  private int puX;
  private int puY;
  private d.c puZ;
  private int puh;
  private RelativeLayout pui;
  public d puj;
  private TextView puk;
  private DanmuView pul;
  public d.a pum;
  private View pun;
  private View puo;
  private TextView pup;
  private LinearLayout puq;
  private AppBrandDotPercentIndicator pur;
  private TextView pus;
  private ImageView put;
  private ImageView puu;
  private ImageView puv;
  private ImageView puw;
  private FrameLayout pux;
  private String puy;
  private int puz;
  
  public AppBrandVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(137735);
    this.puh = -1;
    this.puT = false;
    this.puU = true;
    this.puV = false;
    this.cJK = false;
    this.puX = 0;
    this.puY = -16777216;
    init(paramContext);
    AppMethodBeat.o(137735);
  }
  
  public AppBrandVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(137736);
    this.puh = -1;
    this.puT = false;
    this.puU = true;
    this.puV = false;
    this.cJK = false;
    this.puX = 0;
    this.puY = -16777216;
    init(paramContext);
    AppMethodBeat.o(137736);
  }
  
  public <T extends View,  extends d> AppBrandVideoView(Context paramContext, T paramT)
  {
    super(paramContext);
    AppMethodBeat.i(137734);
    this.puh = -1;
    this.puT = false;
    this.puU = true;
    this.puV = false;
    this.cJK = false;
    this.puX = 0;
    this.puY = -16777216;
    this.puj = ((d)paramT);
    init(paramContext);
    this.pui.addView(paramT);
    AppMethodBeat.o(137734);
  }
  
  public <T extends View,  extends d> AppBrandVideoView(Context paramContext, T paramT, byte paramByte)
  {
    super(paramContext);
    AppMethodBeat.i(229626);
    this.puh = -1;
    this.puT = false;
    this.puU = true;
    this.puV = false;
    this.cJK = false;
    this.puX = 0;
    this.puY = -16777216;
    this.puj = ((d)paramT);
    this.puY = -16777216;
    init(paramContext);
    this.pui.addView(paramT);
    AppMethodBeat.o(229626);
  }
  
  private static String AP(int paramInt)
  {
    AppMethodBeat.i(137788);
    String str = AQ(paramInt / 60) + ":" + AQ(paramInt % 60);
    AppMethodBeat.o(137788);
    return str;
  }
  
  private static String AQ(int paramInt)
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
  
  private void bUF()
  {
    AppMethodBeat.i(229662);
    if (this.puj != null) {
      this.puj.bUF();
    }
    AppMethodBeat.o(229662);
  }
  
  private void bUH()
  {
    AppMethodBeat.i(137780);
    this.puF = new com.tencent.mm.plugin.appbrand.jsapi.video.ui.a(getContext(), this, new com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b()
    {
      public final void aM(float paramAnonymousFloat)
      {
        AppMethodBeat.i(226843);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(226843);
          return;
        }
        Log.d("MicroMsg.Video.AppBrandVideoView", "onAdjustVolume:".concat(String.valueOf(paramAnonymousFloat)));
        AppBrandVideoView.o(AppBrandVideoView.this).setPercent(paramAnonymousFloat);
        AppBrandVideoView.p(AppBrandVideoView.this).setText(a.f.luggage_app_brand_video_volume);
        AppBrandVideoView.q(AppBrandVideoView.this).setImageResource(com.tencent.luggage.b.d.a.b.app_brand_video_volume_icon);
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(0);
        AppBrandVideoView.j(AppBrandVideoView.this);
        AppMethodBeat.o(226843);
      }
      
      public final void aN(float paramAnonymousFloat)
      {
        AppMethodBeat.i(226846);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(226846);
          return;
        }
        Log.d("MicroMsg.Video.AppBrandVideoView", "onAdjustBrightness:".concat(String.valueOf(paramAnonymousFloat)));
        AppBrandVideoView.o(AppBrandVideoView.this).setPercent(paramAnonymousFloat);
        AppBrandVideoView.p(AppBrandVideoView.this).setText(a.f.luggage_app_brand_video_brightness);
        AppBrandVideoView.q(AppBrandVideoView.this).setImageResource(com.tencent.luggage.b.d.a.b.app_brand_video_brightness_icon);
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(0);
        AppBrandVideoView.j(AppBrandVideoView.this);
        AppMethodBeat.o(226846);
      }
      
      public final void bUS()
      {
        AppMethodBeat.i(226823);
        Log.d("MicroMsg.Video.AppBrandVideoView", "onSingleTap");
        if ((AppBrandVideoView.f(AppBrandVideoView.this)) && (AppBrandVideoView.g(AppBrandVideoView.this).getVisibility() != 0))
        {
          AppBrandVideoView.h(AppBrandVideoView.this).bVb();
          if (AppBrandVideoView.i(AppBrandVideoView.this)) {
            AppBrandVideoView.j(AppBrandVideoView.this);
          }
        }
        AppMethodBeat.o(226823);
      }
      
      public final void bUT()
      {
        AppMethodBeat.i(226826);
        Log.d("MicroMsg.Video.AppBrandVideoView", "onDoubleTap");
        if (AppBrandVideoView.k(AppBrandVideoView.this))
        {
          if (AppBrandVideoView.b(AppBrandVideoView.this).isPlaying())
          {
            AppBrandVideoView.this.pause();
            AppMethodBeat.o(226826);
            return;
          }
          AppBrandVideoView.this.start();
        }
        AppMethodBeat.o(226826);
      }
      
      public final void bUU()
      {
        AppMethodBeat.i(226828);
        if (!AppBrandVideoView.l(AppBrandVideoView.this))
        {
          AppMethodBeat.o(226828);
          return;
        }
        AppBrandVideoView.m(AppBrandVideoView.this).setVisibility(0);
        AppBrandVideoView.j(AppBrandVideoView.this);
        AppMethodBeat.o(226828);
      }
      
      public final void bUV()
      {
        AppMethodBeat.i(226848);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(226848);
          return;
        }
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.n(AppBrandVideoView.this);
        AppMethodBeat.o(226848);
      }
      
      public final void bUW()
      {
        AppMethodBeat.i(226849);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(226849);
          return;
        }
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.n(AppBrandVideoView.this);
        AppMethodBeat.o(226849);
      }
      
      public final boolean bUX()
      {
        AppMethodBeat.i(292955);
        boolean bool = AppBrandVideoView.s(AppBrandVideoView.this);
        AppMethodBeat.o(292955);
        return bool;
      }
      
      public final boolean bUY()
      {
        AppMethodBeat.i(292956);
        boolean bool = AppBrandVideoView.s(AppBrandVideoView.this);
        AppMethodBeat.o(292956);
        return bool;
      }
      
      public final boolean bUZ()
      {
        AppMethodBeat.i(226854);
        boolean bool = AppBrandVideoView.l(AppBrandVideoView.this);
        AppMethodBeat.o(226854);
        return bool;
      }
      
      public final int getCurrentPosition()
      {
        AppMethodBeat.i(226839);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getCurrPosSec();
        AppMethodBeat.o(226839);
        return i;
      }
      
      public final int l(int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(226833);
        if (!AppBrandVideoView.l(AppBrandVideoView.this))
        {
          AppMethodBeat.o(226833);
          return 0;
        }
        Log.i("MicroMsg.Video.AppBrandVideoView", "onDragProgress:" + paramAnonymousInt + "/" + paramAnonymousFloat);
        paramAnonymousInt = AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec();
        int i = com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.a.c(paramAnonymousFloat, AppBrandVideoView.this.getMeasuredWidth(), getCurrentPosition(), paramAnonymousInt);
        String str = k.GN(paramAnonymousInt * 1000L);
        AppBrandVideoView.m(AppBrandVideoView.this).setText(k.GN(i * 1000L) + "/" + str);
        AppBrandVideoView.h(AppBrandVideoView.this).seek(i);
        if (AppBrandVideoView.h(AppBrandVideoView.this).bVd()) {
          AppBrandVideoView.h(AppBrandVideoView.this).bVi();
        }
        AppMethodBeat.o(226833);
        return i;
      }
      
      public final void m(int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(226838);
        if (!AppBrandVideoView.l(AppBrandVideoView.this))
        {
          AppMethodBeat.o(226838);
          return;
        }
        AppBrandVideoView.m(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.n(AppBrandVideoView.this);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(AppBrandVideoView.b(AppBrandVideoView.this).getCurrPosSec()), Float.valueOf(paramAnonymousFloat) });
        AppBrandVideoView.this.b(paramAnonymousInt, false);
        AppMethodBeat.o(226838);
      }
    });
    AppMethodBeat.o(137780);
  }
  
  private void bUI()
  {
    AppMethodBeat.i(137781);
    this.pum.bUI();
    AppMethodBeat.o(137781);
  }
  
  private void bUJ()
  {
    AppMethodBeat.i(137782);
    this.puj.setIMMVideoViewCallback(new d.c()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(227616);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        com.tencent.mm.plugin.appbrand.jsapi.video.c.b localb;
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null)
        {
          localb = AppBrandVideoView.d(AppBrandVideoView.this);
          localb.clean();
        }
        try
        {
          JSONObject localJSONObject = localb.bWg();
          localJSONObject.put("errMsg", paramAnonymousString3);
          localb.a(new b.d((byte)0), localJSONObject);
          if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
            AppBrandVideoView.t(AppBrandVideoView.this).c(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(227616);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            Log.e("MicroMsg.Video.JsApiVideoCallback", "onError e=%s", new Object[] { localJSONException });
          }
        }
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(227632);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
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
          Log.i("MicroMsg.Video.AppBrandVideoView", "onGetVideoSize adjust direction from AUTO to %s", new Object[] { Integer.valueOf(AppBrandVideoView.G(AppBrandVideoView.this)) });
          if (AppBrandVideoView.d(AppBrandVideoView.this) != null)
          {
            localObject = AppBrandVideoView.d(AppBrandVideoView.this);
            i = AppBrandVideoView.this.getDuration();
          }
          try
          {
            Log.i("MicroMsg.Video.JsApiVideoCallback", "onVideoLoadedMetaData, width:%d, height:%d, duration:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i) });
            JSONObject localJSONObject = ((com.tencent.mm.plugin.appbrand.jsapi.video.c.b)localObject).bWg();
            localJSONObject.put("width", paramAnonymousInt1);
            localJSONObject.put("height", paramAnonymousInt2);
            localJSONObject.put("duration", i * 1.0D / 1000.0D);
            ((com.tencent.mm.plugin.appbrand.jsapi.video.c.b)localObject).a(new b.f((byte)0), localJSONObject);
            if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
              AppBrandVideoView.t(AppBrandVideoView.this).d(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt1, paramAnonymousInt2);
            }
            AppMethodBeat.o(227632);
            return;
            label242:
            i = 90;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              Log.e("MicroMsg.Video.JsApiVideoCallback", "onVideoLoadedMetaData e=%s", new Object[] { localJSONException });
            }
          }
        }
      }
      
      public final void dS(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(227619);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onPrepared");
        AppBrandVideoView.a(AppBrandVideoView.this, 0);
        AppBrandVideoView.u(AppBrandVideoView.this);
        AppBrandVideoView.v(AppBrandVideoView.this);
        if (AppBrandVideoView.w(AppBrandVideoView.this)) {
          AppBrandVideoView.this.start();
        }
        AppBrandVideoView.x(AppBrandVideoView.this).bWZ();
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
          AppBrandVideoView.d(AppBrandVideoView.this);
        }
        if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
          AppBrandVideoView.t(AppBrandVideoView.this).dS(paramAnonymousString1, paramAnonymousString2);
        }
        AppMethodBeat.o(227619);
      }
      
      public final void dT(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(227627);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onVideoEnded");
        AppBrandVideoView.y(AppBrandVideoView.this);
        AppBrandVideoView.m(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.h(AppBrandVideoView.this).setIsPlay(false);
        if ((AppBrandVideoView.h(AppBrandVideoView.this).bVd()) && (AppBrandVideoView.h(AppBrandVideoView.this).bVf())) {
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
            localb.a(new b.c((byte)0), localb.bWg());
            localb.bWh();
            if (AppBrandVideoView.F(AppBrandVideoView.this)) {
              AppBrandVideoView.this.b(0.0D, true);
            }
            if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
              AppBrandVideoView.t(AppBrandVideoView.this).dT(paramAnonymousString1, paramAnonymousString2);
            }
            AppMethodBeat.o(227627);
            return;
            if (AppBrandVideoView.D(AppBrandVideoView.this) <= 0) {
              AppBrandVideoView.E(AppBrandVideoView.this).setText(AppBrandVideoView.AR(AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec()));
            }
            AppBrandVideoView.C(AppBrandVideoView.this).setVisibility(0);
            AppBrandVideoView.g(AppBrandVideoView.this).setVisibility(0);
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              Log.e("MicroMsg.Video.JsApiVideoCallback", "OnVideoEnded e=%s", new Object[] { localJSONException });
            }
          }
        }
      }
      
      public final void dU(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(227634);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onVideoPause");
        com.tencent.mm.plugin.appbrand.jsapi.video.c.b localb;
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
          localb = AppBrandVideoView.d(AppBrandVideoView.this);
        }
        try
        {
          localb.a(new b.g((byte)0), localb.bWg());
          localb.bWh();
          if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
            AppBrandVideoView.t(AppBrandVideoView.this).dU(paramAnonymousString1, paramAnonymousString2);
          }
          AppMethodBeat.o(227634);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            Log.e("MicroMsg.Video.JsApiVideoCallback", "OnVideoPause e=%s", new Object[] { localJSONException });
          }
        }
      }
      
      public final void dV(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(227650);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(AppBrandVideoView.A(AppBrandVideoView.this)) });
        if ((AppBrandVideoView.D(AppBrandVideoView.this) <= 0) && (!AppBrandVideoView.A(AppBrandVideoView.this))) {
          AppBrandVideoView.E(AppBrandVideoView.this).setText(AppBrandVideoView.AR(AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec()));
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
          localb.pzj = 0;
          JSONObject localJSONObject = localb.bWg();
          localJSONObject.put("timeStamp", System.currentTimeMillis());
          localb.a(new b.h((byte)0), localJSONObject);
          if (localb.pzi == null) {
            localb.pzi = new MTimerHandler(new b.1(localb), true);
          }
          localb.pzi.startTimer(250L);
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            Log.e("MicroMsg.Video.JsApiVideoCallback", "OnVideoPlay e=%s", new Object[] { localJSONException });
          }
        }
        if ((AppBrandVideoView.I(AppBrandVideoView.this) != null) && ("wxfe02ecfe70800f46".equalsIgnoreCase(AppBrandVideoView.I(AppBrandVideoView.this).getAppId())))
        {
          Log.i("MicroMsg.Video.AppBrandVideoView", "onVideoPlay, send play event");
          EventCenter.instance.publish(new com.tencent.mm.plugin.appbrand.jsapi.video.c.a());
        }
        if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
          AppBrandVideoView.t(AppBrandVideoView.this).dV(paramAnonymousString1, paramAnonymousString2);
        }
        AppMethodBeat.o(227650);
      }
      
      public final void dW(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(227654);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onVideoWaiting");
        com.tencent.mm.plugin.appbrand.jsapi.video.c.b localb;
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
          localb = AppBrandVideoView.d(AppBrandVideoView.this);
        }
        try
        {
          JSONObject localJSONObject = localb.bWg();
          localJSONObject.put("timeStamp", System.currentTimeMillis());
          localb.a(new b.m((byte)0), localJSONObject);
          AppBrandVideoView.b(AppBrandVideoView.this, true);
          AppBrandVideoView.j(AppBrandVideoView.this);
          if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
            AppBrandVideoView.t(AppBrandVideoView.this).dW(paramAnonymousString1, paramAnonymousString2);
          }
          AppMethodBeat.o(227654);
          return;
        }
        catch (JSONException localJSONException)
        {
          for (;;)
          {
            Log.e("MicroMsg.Video.JsApiVideoCallback", "onVideoWaiting e=%s", new Object[] { localJSONException });
          }
        }
      }
      
      public final void dX(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(227656);
        AppBrandVideoView.b(AppBrandVideoView.this, false);
        AppBrandVideoView.n(AppBrandVideoView.this);
        if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
          AppBrandVideoView.t(AppBrandVideoView.this).dX(paramAnonymousString1, paramAnonymousString2);
        }
        AppMethodBeat.o(227656);
      }
    });
    AppMethodBeat.o(137782);
  }
  
  private void bUL()
  {
    AppMethodBeat.i(137786);
    this.pul = ((DanmuView)findViewById(a.c.danmaku_view));
    this.pul.setDanmuViewCallBack(new c()
    {
      public final int bkj()
      {
        AppMethodBeat.i(230477);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getCurrPosSec();
        AppMethodBeat.o(230477);
        return i;
      }
    });
    this.pul.bWe();
    this.pul.setMaxRunningPerRow(5);
    this.pul.setPickItemInterval(200);
    this.pul.hide();
    if ((this.puj != null) && (((View)this.puj).getHeight() > 0))
    {
      float f = this.pul.getYOffset();
      int i = (int)(((View)this.puj).getHeight() * f);
      f = com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b.dU(getContext());
      this.pul.setMaxRow((int)(i / f));
    }
    AppMethodBeat.o(137786);
  }
  
  private boolean bUM()
  {
    AppMethodBeat.i(137792);
    if ((this.puL) && (!this.puj.isLive()) && (!bUO()))
    {
      AppMethodBeat.o(137792);
      return true;
    }
    AppMethodBeat.o(137792);
    return false;
  }
  
  private boolean bUN()
  {
    AppMethodBeat.i(137793);
    if ((!bUO()) && (((!bUK()) && (this.puD)) || ((bUK()) && (this.puE))))
    {
      AppMethodBeat.o(137793);
      return true;
    }
    AppMethodBeat.o(137793);
    return false;
  }
  
  private boolean bUO()
  {
    AppMethodBeat.i(137794);
    if (this.pun.getVisibility() == 0)
    {
      AppMethodBeat.o(137794);
      return true;
    }
    AppMethodBeat.o(137794);
    return false;
  }
  
  private void bUP()
  {
    AppMethodBeat.i(229728);
    if (this.puW != null) {
      this.puW.stopTimer();
    }
    AppMethodBeat.o(229728);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(137737);
    LayoutInflater.from(paramContext).inflate(a.d.app_brand_video_container, this);
    setBackgroundColor(this.puY);
    this.pui = ((RelativeLayout)findViewById(a.c.video_view));
    this.puk = ((TextView)findViewById(a.c.progress));
    this.pun = findViewById(a.c.cover_area);
    this.puo = findViewById(a.c.cover_play_btn_area);
    this.pup = ((TextView)findViewById(a.c.cover_total_time));
    this.puq = ((LinearLayout)findViewById(a.c.adjust_info_layout));
    this.pur = ((AppBrandDotPercentIndicator)findViewById(a.c.adjust_percent_indicator));
    this.pus = ((TextView)findViewById(a.c.adjust_content));
    this.put = ((ImageView)findViewById(a.c.adjust_icon));
    this.puu = ((ImageView)findViewById(a.c.cover));
    this.puv = ((ImageView)findViewById(a.c.player_bottom_progress_bar_front));
    this.puw = ((ImageView)findViewById(a.c.player_bottom_progress_bar_background));
    this.pux = ((FrameLayout)findViewById(a.c.player_bottom_progress_root));
    this.pur.setDotsNum(8);
    ((ImageView)findViewById(a.c.cover_play_btn)).setOnClickListener(new AppBrandVideoView.1(this));
    bUH();
    bUJ();
    AppMethodBeat.o(137737);
  }
  
  private boolean isLive()
  {
    AppMethodBeat.i(137791);
    if ((this.puH) || (this.puj.isLive()))
    {
      AppMethodBeat.o(137791);
      return true;
    }
    AppMethodBeat.o(137791);
    return false;
  }
  
  private void setCover(final String paramString)
  {
    AppMethodBeat.i(137761);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(137761);
      return;
    }
    if (!Util.isNullOrNil(this.puJ))
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "setCover mCoverUrl not null");
      AppMethodBeat.o(137761);
      return;
    }
    m.clV().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(228387);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(230511);
            if ((this.val$bitmap != null) && (!this.val$bitmap.isRecycled())) {
              AppBrandVideoView.a(AppBrandVideoView.this).setImageBitmap(this.val$bitmap);
            }
            AppMethodBeat.o(230511);
          }
        });
        AppMethodBeat.o(228387);
      }
    });
    AppMethodBeat.o(137761);
  }
  
  public final void AO(int paramInt)
  {
    AppMethodBeat.i(137754);
    Log.i("MicroMsg.Video.AppBrandVideoView", "onUIPause, type:%d", new Object[] { Integer.valueOf(paramInt) });
    if (((paramInt == 2) && (!this.cFr)) || ((paramInt == 1) && (!this.cFq)))
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "onUIPause, should skip ui pause");
      this.puT = true;
      AppMethodBeat.o(137754);
      return;
    }
    this.puj.onUIPause();
    AppMethodBeat.o(137754);
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(137787);
    this.pum = parama;
    if (((this.pum instanceof View)) && (this.pum != null))
    {
      parama = (View)this.pum;
      if (parama.getId() != -1) {
        parama.setId(a.c.app_brand_video_preview_ui_controller_bar_id);
      }
    }
    this.pum.hide();
    this.pum.setFullScreenBtnOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(230590);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (!AppBrandVideoView.this.bUK()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView = AppBrandVideoView.this;
          paramAnonymousView.s(bool, AppBrandVideoView.G(paramAnonymousView));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(230590);
          return;
        }
      }
    });
    this.pum.setIplaySeekCallback(new d.d()
    {
      public final void aRo()
      {
        AppMethodBeat.i(230058);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onSeekPre");
        AppMethodBeat.o(230058);
      }
      
      public final void tY(int paramAnonymousInt)
      {
        AppMethodBeat.i(230059);
        AppBrandVideoView.this.b(paramAnonymousInt, false);
        AppMethodBeat.o(230059);
      }
    });
    this.pum.setOnPlayButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(227202);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (AppBrandVideoView.b(AppBrandVideoView.this).isPlaying()) {
          AppBrandVideoView.this.pause();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(227202);
          return;
          AppBrandVideoView.this.start();
        }
      }
    });
    this.pum.setStatePorter(new d.i()
    {
      public final int bUQ()
      {
        AppMethodBeat.i(229115);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getCacheTimeSec();
        AppMethodBeat.o(229115);
        return i;
      }
      
      public final int bUR()
      {
        AppMethodBeat.i(229117);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec();
        AppMethodBeat.o(229117);
        return i;
      }
    });
    this.pum.setMuteBtnOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(230121);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = AppBrandVideoView.this;
        if (!AppBrandVideoView.J(AppBrandVideoView.this)) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setMute(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(230121);
          return;
        }
      }
    });
    this.pum.setExitFullScreenBtnOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(137702);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        AppBrandVideoView.this.s(false, AppBrandVideoView.G(AppBrandVideoView.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(137702);
      }
    });
    this.pum.a(new d.f()
    {
      public final void onVisibilityChanged(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(227061);
        AppBrandVideoView.H(AppBrandVideoView.this);
        AppMethodBeat.o(227061);
      }
    });
    this.pum.setOnUpdateProgressLenListener(new d.e()
    {
      public final void onProgressChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(229855);
        if (paramAnonymousInt2 <= 0)
        {
          AppMethodBeat.o(229855);
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
          AppMethodBeat.o(229855);
          return;
        }
      }
    });
    AppMethodBeat.o(137787);
  }
  
  public final void aiL(String paramString)
  {
    AppMethodBeat.i(137760);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setCover:%s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(137760);
      return;
    }
    this.puJ = paramString;
    com.tencent.mm.modelappbrand.a.b.bhh().a(this.puu, paramString, null, null);
    AppMethodBeat.o(137760);
  }
  
  public final void b(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(137758);
    int i = this.puj.getCurrPosSec();
    Log.i("MicroMsg.Video.AppBrandVideoView", "seek to position=%s current=%d isLive=%b", new Object[] { Double.valueOf(paramDouble), Integer.valueOf(i), Boolean.valueOf(this.puH) });
    if (isLive())
    {
      AppMethodBeat.o(137758);
      return;
    }
    this.pun.setVisibility(8);
    if (paramBoolean) {
      this.puj.a(paramDouble, paramBoolean);
    }
    for (;;)
    {
      if ((this.pul != null) && (i > paramDouble)) {
        this.pul.Bb((int)paramDouble);
      }
      AppMethodBeat.o(137758);
      return;
      this.puj.p(paramDouble);
    }
  }
  
  public final void bUG()
  {
    AppMethodBeat.i(229664);
    b(0.0D, false);
    AppMethodBeat.o(229664);
  }
  
  public final boolean bUK()
  {
    AppMethodBeat.i(137785);
    if (this.puG == null)
    {
      Log.w("MicroMsg.Video.AppBrandVideoView", "isInFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(137785);
      return false;
    }
    boolean bool = this.puG.QT();
    AppMethodBeat.o(137785);
    return bool;
  }
  
  public final void clean()
  {
    AppMethodBeat.i(137756);
    Log.i("MicroMsg.Video.AppBrandVideoView", "clean");
    stop();
    this.puj.onUIDestroy();
    if (this.pul != null) {
      this.pul.clear();
    }
    this.pum.onDestroy();
    bUP();
    AppMethodBeat.o(137756);
  }
  
  public final boolean dR(String arg1, String paramString2)
  {
    AppMethodBeat.i(137779);
    if (this.pul == null)
    {
      Log.w("MicroMsg.Video.AppBrandVideoView", " addDanmaku mDanmakuView null");
      bUL();
    }
    int j = com.tencent.mm.plugin.appbrand.ac.g.anf(paramString2);
    int i = j;
    if (j == 0) {
      i = -1;
    }
    paramString2 = new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a(getContext(), new SpannableString(???), i, this.puj.getCurrPosSec());
    DanmuView localDanmuView = this.pul;
    synchronized (localDanmuView.pyU)
    {
      localDanmuView.pyU.offerFirst(paramString2);
      h.ZvG.d(new DanmuView.3(localDanmuView, paramString2), "DanmuView-addItemToWaitingHead");
      AppMethodBeat.o(137779);
      return true;
    }
  }
  
  public final void f(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(137757);
    String str = paramString;
    if (this.puA != null)
    {
      str = paramString;
      if (this.puA.getFileSystem() != null)
      {
        str = paramString;
        if (this.puA.getFileSystem().acS(paramString))
        {
          paramString = this.puA.getFileSystem().adL(paramString);
          if (paramString != null) {
            break label126;
          }
        }
      }
    }
    label126:
    for (paramString = null;; paramString = "file://" + paramString.bOF())
    {
      str = paramString;
      Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath path=%s isLive=%s", new Object[] { str, Boolean.valueOf(paramBoolean) });
      if (!Util.isNullOrNil(str)) {
        break;
      }
      Log.v("MicroMsg.Video.AppBrandVideoView", "setVideoPath videoPath empty");
      AppMethodBeat.o(137757);
      return;
    }
    stop();
    this.puH = paramBoolean;
    this.puQ = str;
    this.puj.setVideoSource(this.puP);
    this.puj.c(paramBoolean, str, paramInt);
    if (this.puI > 0.0D) {
      this.puj.a(this.puI, this.cFF);
    }
    Object localObject;
    if ((this.puP == 1) && (com.tencent.luggage.a.e.K(g.class) != null))
    {
      localObject = ((g)com.tencent.luggage.a.e.K(g.class)).aiM(this.puQ);
      if (localObject != null)
      {
        Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath localVideoPath:%s", new Object[] { localObject });
        paramString = this.puQ;
        Log.i("MicroMsg.Video.AppBrandVideoView", "leonlad setPreLoadVideoPath %s", new Object[] { localObject });
        if ((!this.puj.isPlaying()) && (this.puQ.equalsIgnoreCase(paramString)))
        {
          this.puQ = paramString;
          this.puj.c(this.puH, (String)localObject, 0);
          if (!this.cFF) {
            break label455;
          }
          Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay true");
          start();
        }
      }
    }
    for (;;)
    {
      if (this.puC != null) {
        localObject = this.puC;
      }
      try
      {
        JSONObject localJSONObject = ((com.tencent.mm.plugin.appbrand.jsapi.video.c.b)localObject).bWg();
        localJSONObject.put("timeStamp", System.currentTimeMillis());
        localJSONObject.put("url", paramString);
        ((com.tencent.mm.plugin.appbrand.jsapi.video.c.b)localObject).a(new b.a((byte)0), localJSONObject);
        if (this.cFF)
        {
          Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay true");
          start();
          setCover(str);
          AppMethodBeat.o(137757);
          return;
          label455:
          Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay false");
          bUF();
        }
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          Log.e("MicroMsg.Video.JsApiVideoCallback", "onVideoCanPlay e=%s", new Object[] { paramString });
          continue;
          Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay false");
          bUF();
        }
      }
    }
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(137773);
    if (this.puj != null)
    {
      int i = this.puj.getCacheTimeSec();
      AppMethodBeat.o(137773);
      return i;
    }
    AppMethodBeat.o(137773);
    return 0;
  }
  
  public com.tencent.mm.plugin.appbrand.jsapi.video.c.b getCallback()
  {
    return this.puC;
  }
  
  public String getCookieData()
  {
    return this.puy;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(137772);
    int i = this.puj.getCurrPosMs();
    AppMethodBeat.o(137772);
    return i;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(137771);
    int i = this.puj.getCurrPosSec();
    AppMethodBeat.o(137771);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(137748);
    if (this.alM > 0)
    {
      i = this.alM;
      AppMethodBeat.o(137748);
      return i;
    }
    int i = this.puj.getVideoDurationSec();
    AppMethodBeat.o(137748);
    return i;
  }
  
  public final void iC(boolean paramBoolean)
  {
    AppMethodBeat.i(137765);
    Log.i("MicroMsg.Video.AppBrandVideoView", "enableProgressGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.puL = paramBoolean;
    AppMethodBeat.o(137765);
  }
  
  public final void iD(boolean paramBoolean)
  {
    AppMethodBeat.i(137790);
    if (this.puC == null)
    {
      AppMethodBeat.o(137790);
      return;
    }
    this.puC.c(this.puz, paramBoolean, this.oVs);
    AppMethodBeat.o(137790);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(137783);
    if (this.puS) {
      bool = true;
    }
    while (bool)
    {
      if (this.puF != null) {
        this.puF.C(paramMotionEvent);
      }
      AppMethodBeat.o(137783);
      return true;
      bool = bUM();
      if (!bUN()) {
        bool = false;
      }
    }
    if ((paramMotionEvent.getAction() == 0) && (this.puB) && (this.pun.getVisibility() != 0))
    {
      this.pum.bVb();
      if (this.puR) {
        bUI();
      }
    }
    if (this.puK)
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
    Log.i("MicroMsg.Video.AppBrandVideoView", "onUIDestroy");
    clean();
    AppMethodBeat.o(137755);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(137753);
    Log.i("MicroMsg.Video.AppBrandVideoView", "onUIResume");
    if (this.puT)
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "onUIResume, should skip ui resume");
      this.puT = false;
      AppMethodBeat.o(137753);
      return;
    }
    this.puj.onUIResume();
    AppMethodBeat.o(137753);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137751);
    Log.i("MicroMsg.Video.AppBrandVideoView", "pause");
    if (!this.puV)
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "pause, video not prepared");
      this.cJK = false;
      AppMethodBeat.o(137751);
      return;
    }
    if (!this.puj.isPlaying())
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "pause, video not playing");
      AppMethodBeat.o(137751);
      return;
    }
    this.puj.pause();
    if ((this.pul != null) && (this.pum.bVa())) {
      this.pul.pause();
    }
    AppMethodBeat.o(137751);
  }
  
  public final void s(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(137784);
    Log.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen toFullScreen:%b direction:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.puG == null)
    {
      Log.w("MicroMsg.Video.AppBrandVideoView", "operateFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(137784);
      return;
    }
    if (paramBoolean == bUK())
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen current same");
      AppMethodBeat.o(137784);
      return;
    }
    if (paramInt == -1) {
      if (this.puh == -1)
      {
        paramInt = 90;
        Log.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen target direction:%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        this.oVs = paramInt;
        this.puG.Az(paramInt);
        this.pum.Nq();
        iD(true);
        AppMethodBeat.o(137784);
        return;
        paramInt = this.puh;
        break;
      }
      this.puG.bSs();
      this.pum.bSs();
      AppMethodBeat.o(137784);
      return;
    }
  }
  
  public void setAutoPauseIfNavigate(boolean paramBoolean)
  {
    this.cFq = paramBoolean;
  }
  
  public void setAutoPauseIfOpenNative(boolean paramBoolean)
  {
    this.cFr = paramBoolean;
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(137745);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setAutoPlay %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.cFF = paramBoolean;
    AppMethodBeat.o(137745);
  }
  
  public void setCallback(com.tencent.mm.plugin.appbrand.jsapi.video.c.b paramb)
  {
    this.puC = paramb;
  }
  
  public void setComponent(com.tencent.mm.plugin.appbrand.jsapi.e parame)
  {
    AppMethodBeat.i(137738);
    this.puA = parame;
    this.mAppId = parame.getAppId();
    AppMethodBeat.o(137738);
  }
  
  public void setConsumeTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(137739);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setConsumeTouchEvent game=%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.puK = paramBoolean;
    AppMethodBeat.o(137739);
  }
  
  public void setCookieData(String paramString)
  {
    this.puy = paramString;
  }
  
  public void setDanmakuEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(137767);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setDanmakuEnable %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.pum.setDanmakuBtnOpen(paramBoolean);
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
      Log.i("MicroMsg.Video.AppBrandVideoView", "setDanmakuItemList length=%d", new Object[] { Integer.valueOf(i) });
      if (this.pul == null)
      {
        Log.w("MicroMsg.Video.AppBrandVideoView", "setDanmakuItemList mDanmakuView null");
        bUL();
      }
      localArrayList = new ArrayList();
      i = 0;
      label77:
      if (i >= paramJSONArray.length()) {
        break label205;
      }
      localObject = paramJSONArray.optJSONObject(i);
      if (localObject != null) {
        break label127;
      }
    }
    label127:
    int m;
    String str;
    int j;
    for (Object localObject = null;; localObject = new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a(getContext(), new SpannableString(str), j, m))
    {
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      i += 1;
      break label77;
      i = 0;
      break;
      m = ((JSONObject)localObject).optInt("time", 0);
      str = ((JSONObject)localObject).optString("text", "");
      int k = com.tencent.mm.plugin.appbrand.ac.g.anf(((JSONObject)localObject).optString("color", ""));
      j = k;
      if (k == 0) {
        j = -1;
      }
    }
    label205:
    paramJSONArray = this.pul;
    paramJSONArray.bWa();
    paramJSONArray.clearItems();
    paramJSONArray.pyV.clear();
    paramJSONArray.prepare();
    if (localArrayList.isEmpty())
    {
      paramJSONArray.bWb();
      AppMethodBeat.o(137778);
      return;
    }
    h.ZvG.bh(new DanmuView.4(paramJSONArray, localArrayList));
    paramJSONArray.bWb();
    AppMethodBeat.o(137778);
  }
  
  public void setDuration(int paramInt)
  {
    AppMethodBeat.i(137747);
    if (paramInt <= 0)
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "setDuration error duration=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137747);
      return;
    }
    this.pup.setText(AP(paramInt));
    this.alM = paramInt;
    AppMethodBeat.o(137747);
  }
  
  public void setEnablePlayGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(137744);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setEnablePlayGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.puS = paramBoolean;
    AppMethodBeat.o(137744);
  }
  
  public void setFullScreenDelegate(a parama)
  {
    this.puG = parama;
  }
  
  public void setFullScreenDirection(int paramInt)
  {
    AppMethodBeat.i(137774);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setFullScreenDirection %d", new Object[] { Integer.valueOf(paramInt) });
    this.puh = paramInt;
    AppMethodBeat.o(137774);
  }
  
  public void setFullScreenState(boolean paramBoolean)
  {
    AppMethodBeat.i(229694);
    if (paramBoolean)
    {
      this.pum.Nq();
      AppMethodBeat.o(229694);
      return;
    }
    this.pum.bSs();
    AppMethodBeat.o(229694);
  }
  
  public void setIMMVideoViewCallback(d.c paramc)
  {
    this.puZ = paramc;
  }
  
  public void setInitialTime(double paramDouble)
  {
    AppMethodBeat.i(137777);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setInitialTime %s", new Object[] { Double.valueOf(paramDouble) });
    this.puI = paramDouble;
    AppMethodBeat.o(137777);
  }
  
  public void setIsEnableBottomProgressBar(boolean paramBoolean)
  {
    this.puU = paramBoolean;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(137759);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setIsShowBasicControls %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.puB = paramBoolean;
    if (this.pum != null)
    {
      if (this.puB)
      {
        this.pum.bVc();
        AppMethodBeat.o(137759);
        return;
      }
      this.pum.hide();
    }
    AppMethodBeat.o(137759);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(137749);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setLoop %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mLoop = paramBoolean;
    AppMethodBeat.o(137749);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(137770);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setMute %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mIsMute = paramBoolean;
    this.puj.setMute(paramBoolean);
    this.pum.setMuteBtnState(paramBoolean);
    AppMethodBeat.o(137770);
  }
  
  public void setObjectFit(String paramString)
  {
    AppMethodBeat.i(137769);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setObjectFit %s", new Object[] { paramString });
    if ("fill".equalsIgnoreCase(paramString))
    {
      this.puj.setScaleType(d.h.pvm);
      this.puu.setScaleType(ImageView.ScaleType.FIT_XY);
      AppMethodBeat.o(137769);
      return;
    }
    if ("cover".equalsIgnoreCase(paramString))
    {
      this.puj.setScaleType(d.h.pvo);
      this.puu.setScaleType(ImageView.ScaleType.CENTER_CROP);
      AppMethodBeat.o(137769);
      return;
    }
    this.puj.setScaleType(d.h.pvn);
    this.puu.setScaleType(ImageView.ScaleType.FIT_CENTER);
    AppMethodBeat.o(137769);
  }
  
  public void setPageGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(137775);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setPageGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.puD = paramBoolean;
    AppMethodBeat.o(137775);
  }
  
  public void setPageGestureInFullscreen(boolean paramBoolean)
  {
    AppMethodBeat.i(137776);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setPageGestureInFullscreen %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.puE = paramBoolean;
    AppMethodBeat.o(137776);
  }
  
  public void setPlayBtnPosition(String paramString)
  {
    AppMethodBeat.i(137743);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setPlayBtnPosition %s", new Object[] { paramString });
    if ((!Util.isNullOrNil(paramString)) && (paramString.equalsIgnoreCase("center")))
    {
      this.pum.setPlayBtnInCenterPosition(true);
      AppMethodBeat.o(137743);
      return;
    }
    this.pum.setPlayBtnInCenterPosition(false);
    AppMethodBeat.o(137743);
  }
  
  public void setShowCenterPlayBtn(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(137766);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setShowCenterPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.puO = paramBoolean;
    View localView = this.pun;
    if (paramBoolean)
    {
      i = 0;
      localView.setVisibility(i);
      localView = this.puo;
      if (!paramBoolean) {
        break label105;
      }
    }
    label105:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      if ((this.puO) && (this.pum != null)) {
        this.pum.hide();
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
    Log.i("MicroMsg.Video.AppBrandVideoView", "setShowControlProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    d.a locala = this.pum;
    if ((paramBoolean) && (!isLive())) {}
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
    Log.i("MicroMsg.Video.AppBrandVideoView", "setShowDanmakuBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      if (this.pul == null) {
        bUL();
      }
      this.pum.setDanmakuBtnOnClickListener(new d.g()
      {
        public final void iE(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(228146);
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
              Log.i("MicroMsg.Video.JsApiVideoCallback", "onVideoClickDanmuBtn showDanmu=%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
              JSONObject localJSONObject = localb.bWg();
              localJSONObject.put("showDanmu", paramAnonymousBoolean);
              localJSONObject.put("videoPlayerId", i);
              localb.a(new b.b((byte)0), localJSONObject);
              AppMethodBeat.o(228146);
              return;
            }
            catch (JSONException localJSONException)
            {
              Log.e("MicroMsg.Video.JsApiVideoCallback", "onVideoClickDanmuBtn e=%s", new Object[] { localJSONException });
            }
            AppBrandVideoView.c(AppBrandVideoView.this).pause();
            continue;
            AppBrandVideoView.c(AppBrandVideoView.this).hide();
          }
          label164:
          AppMethodBeat.o(228146);
        }
      });
    }
    this.pum.setShowDanmakuBtn(paramBoolean);
    AppMethodBeat.o(137768);
  }
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(137763);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setShowFullScreenBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.pum.setShowFullScreenBtn(paramBoolean);
    AppMethodBeat.o(137763);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(137740);
    Log.i("MicroMsg.Video.AppBrandVideoView", "showMuteBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.pum.setShowMuteBtn(paramBoolean);
    AppMethodBeat.o(137740);
  }
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(137764);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setShowPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.pum.setShowPlayBtn(paramBoolean);
    AppMethodBeat.o(137764);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(137762);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setShowProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.puM = paramBoolean;
    d.a locala = this.pum;
    if (((paramBoolean) || (this.puN)) && (!isLive())) {}
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
    AppMethodBeat.i(229678);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setShowProgressInControlMode %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.puN = paramBoolean;
    d.a locala = this.pum;
    if (((this.puM) || (paramBoolean)) && (!isLive())) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      locala.setShowProgress(paramBoolean);
      AppMethodBeat.o(229678);
      return;
    }
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(137741);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setTitle %s", new Object[] { paramString });
    this.pum.setTitle(paramString);
    AppMethodBeat.o(137741);
  }
  
  public void setVideoPlayerId(int paramInt)
  {
    this.puz = paramInt;
  }
  
  public void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(137746);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoSource %d", new Object[] { Integer.valueOf(paramInt) });
    this.puP = paramInt;
    AppMethodBeat.o(137746);
  }
  
  public final void start()
  {
    AppMethodBeat.i(137750);
    Log.i("MicroMsg.Video.AppBrandVideoView", "start");
    if (!this.puV) {
      Log.i("MicroMsg.Video.AppBrandVideoView", "start, video not prepared");
    }
    for (this.cJK = true; this.puj.isPlaying(); this.cJK = false)
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "start, video is playing");
      AppMethodBeat.o(137750);
      return;
      Log.i("MicroMsg.Video.AppBrandVideoView", "start, video prepared, reset control flag");
    }
    if (this.puB) {
      this.pum.bVg();
    }
    this.pun.setVisibility(8);
    this.puj.start();
    if ((this.pul != null) && (this.pum.bVa())) {
      this.pul.show();
    }
    if (com.tencent.luggage.a.e.K(g.class) != null) {
      ((g)com.tencent.luggage.a.e.K(g.class)).report(this.puQ);
    }
    AppMethodBeat.o(137750);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(137752);
    Log.i("MicroMsg.Video.AppBrandVideoView", "stop");
    if (!this.puV)
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "stop, video not prepared");
      this.cJK = false;
      AppMethodBeat.o(137752);
      return;
    }
    if (!this.puj.isPlaying())
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "stop, video not playing");
      AppMethodBeat.o(137752);
      return;
    }
    this.puj.stop();
    this.pum.bVh();
    if (this.pul != null) {
      this.pul.hide();
    }
    AppMethodBeat.o(137752);
  }
  
  public static abstract interface a
  {
    public abstract void Az(int paramInt);
    
    public abstract boolean QT();
    
    public abstract void bSs();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView
 * JD-Core Version:    0.7.0.1
 */