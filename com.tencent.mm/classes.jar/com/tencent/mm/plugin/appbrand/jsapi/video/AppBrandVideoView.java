package com.tencent.mm.plugin.appbrand.jsapi.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.luggage.a.e;
import com.tencent.luggage.b.d.a.c;
import com.tencent.luggage.b.d.a.d;
import com.tencent.luggage.b.d.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.jsapi.f;
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
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.DanmuView.5;
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.threadpool.h;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandVideoView
  extends RelativeLayout
{
  private int cam;
  private boolean eDt;
  private boolean eyE;
  private boolean eyF;
  private boolean eyT;
  private String mAppId;
  private boolean mIsMute;
  private boolean mLoop;
  private boolean sAa;
  private boolean sAb;
  private MTimerHandler sAc;
  private int sAd;
  private int sAe;
  private d.c sAf;
  private int saP;
  private ImageView szA;
  private ImageView szB;
  private ImageView szC;
  private FrameLayout szD;
  private String szE;
  private int szF;
  private f szG;
  private boolean szH;
  public com.tencent.mm.plugin.appbrand.jsapi.video.c.b szI;
  private boolean szJ;
  private boolean szK;
  private com.tencent.mm.plugin.appbrand.jsapi.video.ui.a szL;
  private a szM;
  private boolean szN;
  private double szO;
  private String szP;
  private boolean szQ;
  private boolean szR;
  private boolean szS;
  private boolean szT;
  private boolean szU;
  private int szV;
  private String szW;
  private boolean szX;
  private boolean szY;
  private boolean szZ;
  private int szn;
  private RelativeLayout szo;
  public d szp;
  private TextView szq;
  private DanmuView szr;
  public d.a szs;
  private View szt;
  private View szu;
  private TextView szv;
  private LinearLayout szw;
  private AppBrandDotPercentIndicator szx;
  private TextView szy;
  private ImageView szz;
  
  public AppBrandVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(137735);
    this.szn = -1;
    this.szZ = false;
    this.sAa = true;
    this.sAb = false;
    this.eDt = false;
    this.sAd = 0;
    this.sAe = -16777216;
    init(paramContext);
    AppMethodBeat.o(137735);
  }
  
  public AppBrandVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(137736);
    this.szn = -1;
    this.szZ = false;
    this.sAa = true;
    this.sAb = false;
    this.eDt = false;
    this.sAd = 0;
    this.sAe = -16777216;
    init(paramContext);
    AppMethodBeat.o(137736);
  }
  
  public <T extends View,  extends d> AppBrandVideoView(Context paramContext, T paramT)
  {
    super(paramContext);
    AppMethodBeat.i(137734);
    this.szn = -1;
    this.szZ = false;
    this.sAa = true;
    this.sAb = false;
    this.eDt = false;
    this.sAd = 0;
    this.sAe = -16777216;
    this.szp = ((d)paramT);
    init(paramContext);
    this.szo.addView(paramT);
    AppMethodBeat.o(137734);
  }
  
  public <T extends View,  extends d> AppBrandVideoView(Context paramContext, T paramT, byte paramByte)
  {
    super(paramContext);
    AppMethodBeat.i(328170);
    this.szn = -1;
    this.szZ = false;
    this.sAa = true;
    this.sAb = false;
    this.eDt = false;
    this.sAd = 0;
    this.sAe = -16777216;
    this.szp = ((d)paramT);
    this.sAe = -16777216;
    init(paramContext);
    this.szo.addView(paramT);
    AppMethodBeat.o(328170);
  }
  
  private static String Be(int paramInt)
  {
    AppMethodBeat.i(137788);
    String str = Bf(paramInt / 60) + ":" + Bf(paramInt % 60);
    AppMethodBeat.o(137788);
    return str;
  }
  
  private static String Bf(int paramInt)
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
  
  private void cuV()
  {
    AppMethodBeat.i(328186);
    if (this.szp != null) {
      this.szp.cuV();
    }
    AppMethodBeat.o(328186);
  }
  
  private void cuW()
  {
    AppMethodBeat.i(137780);
    this.szL = new com.tencent.mm.plugin.appbrand.jsapi.video.ui.a(getContext(), this, new com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b()
    {
      public final void bK(float paramAnonymousFloat)
      {
        AppMethodBeat.i(328202);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(328202);
          return;
        }
        Log.d("MicroMsg.Video.AppBrandVideoView", "onAdjustVolume:".concat(String.valueOf(paramAnonymousFloat)));
        AppBrandVideoView.o(AppBrandVideoView.this).setPercent(paramAnonymousFloat);
        AppBrandVideoView.p(AppBrandVideoView.this).setText(a.f.luggage_app_brand_video_volume);
        AppBrandVideoView.q(AppBrandVideoView.this).setImageResource(com.tencent.luggage.b.d.a.b.app_brand_video_volume_icon);
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(0);
        AppBrandVideoView.j(AppBrandVideoView.this);
        AppMethodBeat.o(328202);
      }
      
      public final void bL(float paramAnonymousFloat)
      {
        AppMethodBeat.i(328207);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(328207);
          return;
        }
        Log.d("MicroMsg.Video.AppBrandVideoView", "onAdjustBrightness:".concat(String.valueOf(paramAnonymousFloat)));
        AppBrandVideoView.o(AppBrandVideoView.this).setPercent(paramAnonymousFloat);
        AppBrandVideoView.p(AppBrandVideoView.this).setText(a.f.luggage_app_brand_video_brightness);
        AppBrandVideoView.q(AppBrandVideoView.this).setImageResource(com.tencent.luggage.b.d.a.b.app_brand_video_brightness_icon);
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(0);
        AppBrandVideoView.j(AppBrandVideoView.this);
        AppMethodBeat.o(328207);
      }
      
      public final void cvh()
      {
        AppMethodBeat.i(328171);
        Log.d("MicroMsg.Video.AppBrandVideoView", "onSingleTap");
        if ((AppBrandVideoView.f(AppBrandVideoView.this)) && (AppBrandVideoView.g(AppBrandVideoView.this).getVisibility() != 0))
        {
          AppBrandVideoView.h(AppBrandVideoView.this).cvr();
          if (AppBrandVideoView.i(AppBrandVideoView.this)) {
            AppBrandVideoView.j(AppBrandVideoView.this);
          }
        }
        AppMethodBeat.o(328171);
      }
      
      public final void cvi()
      {
        AppMethodBeat.i(328176);
        Log.d("MicroMsg.Video.AppBrandVideoView", "onDoubleTap");
        if (AppBrandVideoView.k(AppBrandVideoView.this))
        {
          if (AppBrandVideoView.b(AppBrandVideoView.this).isPlaying())
          {
            AppBrandVideoView.this.pause();
            AppMethodBeat.o(328176);
            return;
          }
          AppBrandVideoView.this.start();
        }
        AppMethodBeat.o(328176);
      }
      
      public final void cvj()
      {
        AppMethodBeat.i(328179);
        if (!AppBrandVideoView.l(AppBrandVideoView.this))
        {
          AppMethodBeat.o(328179);
          return;
        }
        AppBrandVideoView.m(AppBrandVideoView.this).setVisibility(0);
        AppBrandVideoView.j(AppBrandVideoView.this);
        AppMethodBeat.o(328179);
      }
      
      public final boolean cvk()
      {
        return true;
      }
      
      public final void cvl()
      {
        AppMethodBeat.i(328215);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(328215);
          return;
        }
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.n(AppBrandVideoView.this);
        AppMethodBeat.o(328215);
      }
      
      public final void cvm()
      {
        AppMethodBeat.i(328221);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(328221);
          return;
        }
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.n(AppBrandVideoView.this);
        AppMethodBeat.o(328221);
      }
      
      public final boolean cvn()
      {
        AppMethodBeat.i(370028);
        boolean bool = AppBrandVideoView.s(AppBrandVideoView.this);
        AppMethodBeat.o(370028);
        return bool;
      }
      
      public final boolean cvo()
      {
        AppMethodBeat.i(370029);
        boolean bool = AppBrandVideoView.s(AppBrandVideoView.this);
        AppMethodBeat.o(370029);
        return bool;
      }
      
      public final boolean cvp()
      {
        AppMethodBeat.i(328230);
        boolean bool = AppBrandVideoView.l(AppBrandVideoView.this);
        AppMethodBeat.o(328230);
        return bool;
      }
      
      public final int getCurrentPosition()
      {
        AppMethodBeat.i(328197);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getCurrPosSec();
        AppMethodBeat.o(328197);
        return i;
      }
      
      public final int p(int paramAnonymousInt, float paramAnonymousFloat)
      {
        int k = 180;
        int j = 0;
        AppMethodBeat.i(328183);
        if (!AppBrandVideoView.l(AppBrandVideoView.this))
        {
          AppMethodBeat.o(328183);
          return 0;
        }
        Log.i("MicroMsg.Video.AppBrandVideoView", "onDragProgress:" + paramAnonymousInt + "/" + paramAnonymousFloat);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec();
        float f = AppBrandVideoView.this.getMeasuredWidth();
        int m = getCurrentPosition();
        paramAnonymousFloat /= f;
        if (i <= 180)
        {
          paramAnonymousInt = i;
          paramAnonymousInt = (int)(paramAnonymousInt * paramAnonymousFloat) + m;
          if (paramAnonymousInt >= 0) {
            break label254;
          }
          paramAnonymousInt = j;
        }
        for (;;)
        {
          String str = k.iY(i * 1000L);
          AppBrandVideoView.m(AppBrandVideoView.this).setText(k.iY(paramAnonymousInt * 1000L) + "/" + str);
          AppBrandVideoView.h(AppBrandVideoView.this).seek(paramAnonymousInt);
          if (AppBrandVideoView.h(AppBrandVideoView.this).cvt()) {
            AppBrandVideoView.h(AppBrandVideoView.this).cvy();
          }
          AppMethodBeat.o(328183);
          return paramAnonymousInt;
          paramAnonymousInt = k;
          if (i <= 600) {
            break;
          }
          if (i <= 1800)
          {
            paramAnonymousInt = 300;
            break;
          }
          paramAnonymousInt = 600;
          break;
          label254:
          if (paramAnonymousInt > i) {
            paramAnonymousInt = i;
          }
        }
      }
      
      public final void q(int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(328188);
        if (!AppBrandVideoView.l(AppBrandVideoView.this))
        {
          AppMethodBeat.o(328188);
          return;
        }
        AppBrandVideoView.m(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.n(AppBrandVideoView.this);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(AppBrandVideoView.b(AppBrandVideoView.this).getCurrPosSec()), Float.valueOf(paramAnonymousFloat) });
        AppBrandVideoView.this.c(paramAnonymousInt, false);
        AppMethodBeat.o(328188);
      }
    });
    AppMethodBeat.o(137780);
  }
  
  private void cuX()
  {
    AppMethodBeat.i(137781);
    this.szs.cuX();
    AppMethodBeat.o(137781);
  }
  
  private void cuY()
  {
    AppMethodBeat.i(137782);
    this.szp.setIMMVideoViewCallback(new d.c()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(328172);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        com.tencent.mm.plugin.appbrand.jsapi.video.c.b localb;
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null)
        {
          localb = AppBrandVideoView.d(AppBrandVideoView.this);
          localb.clean();
        }
        try
        {
          JSONObject localJSONObject = localb.cws();
          localJSONObject.put("errMsg", paramAnonymousString3);
          localb.a(new b.d((byte)0), localJSONObject);
          if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
            AppBrandVideoView.t(AppBrandVideoView.this).d(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(328172);
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
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(328187);
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
            JSONObject localJSONObject = ((com.tencent.mm.plugin.appbrand.jsapi.video.c.b)localObject).cws();
            localJSONObject.put("width", paramAnonymousInt1);
            localJSONObject.put("height", paramAnonymousInt2);
            localJSONObject.put("duration", i * 1.0D / 1000.0D);
            ((com.tencent.mm.plugin.appbrand.jsapi.video.c.b)localObject).a(new b.f((byte)0), localJSONObject);
            if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
              AppBrandVideoView.t(AppBrandVideoView.this).e(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt1, paramAnonymousInt2);
            }
            AppMethodBeat.o(328187);
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
      
      public final void el(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(328177);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onPrepared");
        AppBrandVideoView.a(AppBrandVideoView.this, 0);
        AppBrandVideoView.u(AppBrandVideoView.this);
        AppBrandVideoView.v(AppBrandVideoView.this);
        if (AppBrandVideoView.w(AppBrandVideoView.this)) {
          AppBrandVideoView.this.start();
        }
        com.tencent.mm.plugin.appbrand.jsapi.video.ui.a locala = AppBrandVideoView.x(AppBrandVideoView.this);
        locala.sIj = -1;
        locala.sIk = 0;
        locala.sIi = 0.0F;
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
          AppBrandVideoView.d(AppBrandVideoView.this);
        }
        if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
          AppBrandVideoView.t(AppBrandVideoView.this).el(paramAnonymousString1, paramAnonymousString2);
        }
        AppMethodBeat.o(328177);
      }
      
      public final void em(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(328182);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onVideoEnded");
        AppBrandVideoView.y(AppBrandVideoView.this);
        AppBrandVideoView.m(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.h(AppBrandVideoView.this).setIsPlay(false);
        if ((AppBrandVideoView.h(AppBrandVideoView.this).cvt()) && (AppBrandVideoView.h(AppBrandVideoView.this).cvv())) {
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
            localb.a(new b.c((byte)0), localb.cws());
            localb.cwt();
            if (AppBrandVideoView.F(AppBrandVideoView.this)) {
              AppBrandVideoView.this.c(0.0D, true);
            }
            if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
              AppBrandVideoView.t(AppBrandVideoView.this).em(paramAnonymousString1, paramAnonymousString2);
            }
            AppMethodBeat.o(328182);
            return;
            if (AppBrandVideoView.D(AppBrandVideoView.this) <= 0) {
              AppBrandVideoView.E(AppBrandVideoView.this).setText(AppBrandVideoView.Bg(AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec()));
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
      
      public final void en(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(328193);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onVideoPause");
        com.tencent.mm.plugin.appbrand.jsapi.video.c.b localb;
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
          localb = AppBrandVideoView.d(AppBrandVideoView.this);
        }
        try
        {
          localb.a(new b.g((byte)0), localb.cws());
          localb.cwt();
          if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
            AppBrandVideoView.t(AppBrandVideoView.this).en(paramAnonymousString1, paramAnonymousString2);
          }
          AppMethodBeat.o(328193);
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
      
      public final void eo(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(328201);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(AppBrandVideoView.A(AppBrandVideoView.this)) });
        if ((AppBrandVideoView.D(AppBrandVideoView.this) <= 0) && (!AppBrandVideoView.A(AppBrandVideoView.this))) {
          AppBrandVideoView.E(AppBrandVideoView.this).setText(AppBrandVideoView.Bg(AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec()));
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
          localb.sEo = 0;
          JSONObject localJSONObject = localb.cws();
          localJSONObject.put("timeStamp", System.currentTimeMillis());
          localb.a(new b.h((byte)0), localJSONObject);
          if (localb.sEn == null) {
            localb.sEn = new MTimerHandler(new b.1(localb), true);
          }
          localb.sEn.startTimer(250L);
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
          new com.tencent.mm.plugin.appbrand.jsapi.video.c.a().publish();
        }
        if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
          AppBrandVideoView.t(AppBrandVideoView.this).eo(paramAnonymousString1, paramAnonymousString2);
        }
        AppMethodBeat.o(328201);
      }
      
      public final void ep(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(328205);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onVideoWaiting");
        com.tencent.mm.plugin.appbrand.jsapi.video.c.b localb;
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
          localb = AppBrandVideoView.d(AppBrandVideoView.this);
        }
        try
        {
          JSONObject localJSONObject = localb.cws();
          localJSONObject.put("timeStamp", System.currentTimeMillis());
          localb.a(new b.m((byte)0), localJSONObject);
          AppBrandVideoView.b(AppBrandVideoView.this, true);
          AppBrandVideoView.j(AppBrandVideoView.this);
          if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
            AppBrandVideoView.t(AppBrandVideoView.this).ep(paramAnonymousString1, paramAnonymousString2);
          }
          AppMethodBeat.o(328205);
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
      
      public final void eq(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(328213);
        AppBrandVideoView.b(AppBrandVideoView.this, false);
        AppBrandVideoView.n(AppBrandVideoView.this);
        if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
          AppBrandVideoView.t(AppBrandVideoView.this).eq(paramAnonymousString1, paramAnonymousString2);
        }
        AppMethodBeat.o(328213);
      }
    });
    AppMethodBeat.o(137782);
  }
  
  private void cva()
  {
    AppMethodBeat.i(137786);
    this.szr = ((DanmuView)findViewById(a.c.danmaku_view));
    this.szr.setDanmuViewCallBack(new c()
    {
      public final int bIa()
      {
        AppMethodBeat.i(328164);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getCurrPosSec();
        AppMethodBeat.o(328164);
        return i;
      }
    });
    this.szr.cwq();
    this.szr.setMaxRunningPerRow(5);
    this.szr.setPickItemInterval(200);
    this.szr.hide();
    if ((this.szp != null) && (((View)this.szp).getHeight() > 0))
    {
      float f = this.szr.getYOffset();
      int i = (int)(((View)this.szp).getHeight() * f);
      f = com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b.eO(getContext());
      this.szr.setMaxRow((int)(i / f));
    }
    AppMethodBeat.o(137786);
  }
  
  private boolean cvb()
  {
    AppMethodBeat.i(137792);
    if ((this.szR) && (!this.szp.isLive()) && (!cvd()))
    {
      AppMethodBeat.o(137792);
      return true;
    }
    AppMethodBeat.o(137792);
    return false;
  }
  
  private boolean cvc()
  {
    AppMethodBeat.i(137793);
    if ((!cvd()) && (((!cuZ()) && (this.szJ)) || ((cuZ()) && (this.szK))))
    {
      AppMethodBeat.o(137793);
      return true;
    }
    AppMethodBeat.o(137793);
    return false;
  }
  
  private boolean cvd()
  {
    AppMethodBeat.i(137794);
    if (this.szt.getVisibility() == 0)
    {
      AppMethodBeat.o(137794);
      return true;
    }
    AppMethodBeat.o(137794);
    return false;
  }
  
  private void cve()
  {
    AppMethodBeat.i(328243);
    if (this.sAc != null) {
      this.sAc.stopTimer();
    }
    AppMethodBeat.o(328243);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(137737);
    LayoutInflater.from(paramContext).inflate(a.d.app_brand_video_container, this);
    setBackgroundColor(this.sAe);
    this.szo = ((RelativeLayout)findViewById(a.c.video_view));
    this.szq = ((TextView)findViewById(a.c.progress));
    this.szt = findViewById(a.c.cover_area);
    this.szu = findViewById(a.c.cover_play_btn_area);
    this.szv = ((TextView)findViewById(a.c.cover_total_time));
    this.szw = ((LinearLayout)findViewById(a.c.adjust_info_layout));
    this.szx = ((AppBrandDotPercentIndicator)findViewById(a.c.adjust_percent_indicator));
    this.szy = ((TextView)findViewById(a.c.adjust_content));
    this.szz = ((ImageView)findViewById(a.c.adjust_icon));
    this.szA = ((ImageView)findViewById(a.c.cover));
    this.szB = ((ImageView)findViewById(a.c.player_bottom_progress_bar_front));
    this.szC = ((ImageView)findViewById(a.c.player_bottom_progress_bar_background));
    this.szD = ((FrameLayout)findViewById(a.c.player_bottom_progress_root));
    this.szx.setDotsNum(8);
    ((ImageView)findViewById(a.c.cover_play_btn)).setOnClickListener(new AppBrandVideoView.1(this));
    cuW();
    cuY();
    AppMethodBeat.o(137737);
  }
  
  private boolean isLive()
  {
    AppMethodBeat.i(137791);
    if ((this.szN) || (this.szp.isLive()))
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
    if (!Util.isNullOrNil(this.szP))
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "setCover mCoverUrl not null");
      AppMethodBeat.o(137761);
      return;
    }
    o.cNm().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(328133);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(328150);
            if ((this.val$bitmap != null) && (!this.val$bitmap.isRecycled())) {
              AppBrandVideoView.a(AppBrandVideoView.this).setImageBitmap(this.val$bitmap);
            }
            AppMethodBeat.o(328150);
          }
        });
        AppMethodBeat.o(328133);
      }
    });
    AppMethodBeat.o(137761);
  }
  
  public final void Bd(int paramInt)
  {
    AppMethodBeat.i(137754);
    Log.i("MicroMsg.Video.AppBrandVideoView", "onUIPause, type:%d", new Object[] { Integer.valueOf(paramInt) });
    if (((paramInt == 2) && (!this.eyF)) || ((paramInt == 1) && (!this.eyE)))
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "onUIPause, should skip ui pause");
      this.szZ = true;
      AppMethodBeat.o(137754);
      return;
    }
    this.szp.onUIPause();
    AppMethodBeat.o(137754);
  }
  
  public final void a(d.a parama)
  {
    AppMethodBeat.i(137787);
    this.szs = parama;
    if (((this.szs instanceof View)) && (this.szs != null))
    {
      parama = (View)this.szs;
      if (parama.getId() != -1) {
        parama.setId(a.c.app_brand_video_preview_ui_controller_bar_id);
      }
    }
    this.szs.hide();
    this.szs.setFullScreenBtnOnClickListener(new AppBrandVideoView.13(this));
    this.szs.setIplaySeekCallback(new d.d()
    {
      public final void blc()
      {
        AppMethodBeat.i(328180);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onSeekPre");
        AppMethodBeat.o(328180);
      }
      
      public final void tS(int paramAnonymousInt)
      {
        AppMethodBeat.i(328185);
        AppBrandVideoView.this.c(paramAnonymousInt, false);
        AppMethodBeat.o(328185);
      }
    });
    this.szs.setOnPlayButtonClickListener(new AppBrandVideoView.15(this));
    this.szs.setStatePorter(new d.i()
    {
      public final int cvf()
      {
        AppMethodBeat.i(328127);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getCacheTimeSec();
        AppMethodBeat.o(328127);
        return i;
      }
      
      public final int cvg()
      {
        AppMethodBeat.i(328132);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec();
        AppMethodBeat.o(328132);
        return i;
      }
    });
    this.szs.setMuteBtnOnClickListener(new AppBrandVideoView.3(this));
    this.szs.setExitFullScreenBtnOnClickListener(new AppBrandVideoView.4(this));
    this.szs.a(new d.f()
    {
      public final void onVisibilityChanged(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(328140);
        AppBrandVideoView.H(AppBrandVideoView.this);
        AppMethodBeat.o(328140);
      }
    });
    this.szs.setOnUpdateProgressLenListener(new d.e()
    {
      public final void onProgressChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(328134);
        if (paramAnonymousInt2 <= 0)
        {
          AppMethodBeat.o(328134);
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
          AppMethodBeat.o(328134);
          return;
        }
      }
    });
    AppMethodBeat.o(137787);
  }
  
  public final void abL(String paramString)
  {
    AppMethodBeat.i(137760);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setCover:%s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(137760);
      return;
    }
    this.szP = paramString;
    com.tencent.mm.modelappbrand.a.b.bEY().a(this.szA, paramString, null, null);
    AppMethodBeat.o(137760);
  }
  
  public final void c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(137758);
    int i = this.szp.getCurrPosSec();
    Log.i("MicroMsg.Video.AppBrandVideoView", "seek to position=%s current=%d isLive=%b", new Object[] { Double.valueOf(paramDouble), Integer.valueOf(i), Boolean.valueOf(this.szN) });
    if (isLive())
    {
      AppMethodBeat.o(137758);
      return;
    }
    this.szt.setVisibility(8);
    if (paramBoolean) {
      this.szp.b(paramDouble, paramBoolean);
    }
    for (;;)
    {
      if ((this.szr != null) && (i > paramDouble))
      {
        DanmuView localDanmuView = this.szr;
        i = (int)paramDouble;
        Log.i("MicroMsg.DanmuView", "seekToPlayTime playTime=%d", new Object[] { Integer.valueOf(i) });
        localDanmuView.cwm();
        localDanmuView.clearItems();
        localDanmuView.prepare();
        h.ahAA.bm(new DanmuView.5(localDanmuView, i));
      }
      AppMethodBeat.o(137758);
      return;
      this.szp.G(paramDouble);
    }
  }
  
  public final void clean()
  {
    AppMethodBeat.i(137756);
    Log.i("MicroMsg.Video.AppBrandVideoView", "clean");
    stop();
    this.szp.onUIDestroy();
    if (this.szr != null) {
      this.szr.clear();
    }
    this.szs.onDestroy();
    cve();
    AppMethodBeat.o(137756);
  }
  
  public final boolean cuZ()
  {
    AppMethodBeat.i(137785);
    if (this.szM == null)
    {
      Log.w("MicroMsg.Video.AppBrandVideoView", "isInFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(137785);
      return false;
    }
    boolean bool = this.szM.isFullScreen();
    AppMethodBeat.o(137785);
    return bool;
  }
  
  public final void e(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(137757);
    String str = paramString;
    if (this.szG != null)
    {
      str = paramString;
      if (this.szG.getFileSystem() != null)
      {
        str = paramString;
        if (this.szG.getFileSystem().Vq(paramString))
        {
          paramString = this.szG.getFileSystem().Wm(paramString);
          if (paramString != null) {
            break label126;
          }
        }
      }
    }
    label126:
    for (paramString = null;; paramString = "file://" + ah.v(paramString.jKT()))
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
    this.szN = paramBoolean;
    this.szW = str;
    this.szp.setVideoSource(this.szV);
    this.szp.b(paramBoolean, str, paramInt);
    if (this.szO > 0.0D) {
      this.szp.b(this.szO, this.eyT);
    }
    Object localObject;
    if ((this.szV == 1) && (e.T(g.class) != null))
    {
      localObject = ((g)e.T(g.class)).abM(this.szW);
      if (localObject != null)
      {
        Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath localVideoPath:%s", new Object[] { localObject });
        paramString = this.szW;
        Log.i("MicroMsg.Video.AppBrandVideoView", "leonlad setPreLoadVideoPath %s", new Object[] { localObject });
        if ((!this.szp.isPlaying()) && (this.szW.equalsIgnoreCase(paramString)))
        {
          this.szW = paramString;
          this.szp.b(this.szN, (String)localObject, 0);
          if (!this.eyT) {
            break label458;
          }
          Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay true");
          start();
        }
      }
    }
    for (;;)
    {
      if (this.szI != null) {
        localObject = this.szI;
      }
      try
      {
        JSONObject localJSONObject = ((com.tencent.mm.plugin.appbrand.jsapi.video.c.b)localObject).cws();
        localJSONObject.put("timeStamp", System.currentTimeMillis());
        localJSONObject.put("url", paramString);
        ((com.tencent.mm.plugin.appbrand.jsapi.video.c.b)localObject).a(new b.a((byte)0), localJSONObject);
        if (this.eyT)
        {
          Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay true");
          start();
          setCover(str);
          AppMethodBeat.o(137757);
          return;
          label458:
          Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay false");
          cuV();
        }
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          Log.e("MicroMsg.Video.JsApiVideoCallback", "onVideoCanPlay e=%s", new Object[] { paramString });
          continue;
          Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay false");
          cuV();
        }
      }
    }
  }
  
  public final boolean ek(String arg1, String paramString2)
  {
    AppMethodBeat.i(137779);
    if (this.szr == null)
    {
      Log.w("MicroMsg.Video.AppBrandVideoView", " addDanmaku mDanmakuView null");
      cva();
    }
    int j = com.tencent.mm.plugin.appbrand.af.i.agv(paramString2);
    int i = j;
    if (j == 0) {
      i = -1;
    }
    paramString2 = new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a(getContext(), new SpannableString(???), i, this.szp.getCurrPosSec());
    DanmuView localDanmuView = this.szr;
    synchronized (localDanmuView.sDZ)
    {
      localDanmuView.sDZ.offerFirst(paramString2);
      h.ahAA.g(new DanmuView.3(localDanmuView, paramString2), "DanmuView-addItemToWaitingHead");
      AppMethodBeat.o(137779);
      return true;
    }
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(137773);
    if (this.szp != null)
    {
      int i = this.szp.getCacheTimeSec();
      AppMethodBeat.o(137773);
      return i;
    }
    AppMethodBeat.o(137773);
    return 0;
  }
  
  public com.tencent.mm.plugin.appbrand.jsapi.video.c.b getCallback()
  {
    return this.szI;
  }
  
  public String getCookieData()
  {
    return this.szE;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(137772);
    int i = this.szp.getCurrPosMs();
    AppMethodBeat.o(137772);
    return i;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(137771);
    int i = this.szp.getCurrPosSec();
    AppMethodBeat.o(137771);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(137748);
    if (this.cam > 0)
    {
      i = this.cam;
      AppMethodBeat.o(137748);
      return i;
    }
    int i = this.szp.getVideoDurationSec();
    AppMethodBeat.o(137748);
    return i;
  }
  
  public final void jG(boolean paramBoolean)
  {
    AppMethodBeat.i(137765);
    Log.i("MicroMsg.Video.AppBrandVideoView", "enableProgressGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.szR = paramBoolean;
    AppMethodBeat.o(137765);
  }
  
  public final void jH(boolean paramBoolean)
  {
    AppMethodBeat.i(137790);
    if (this.szI == null)
    {
      AppMethodBeat.o(137790);
      return;
    }
    this.szI.c(this.szF, paramBoolean, this.saP);
    AppMethodBeat.o(137790);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(137783);
    com.tencent.mm.plugin.appbrand.jsapi.video.ui.a locala;
    if (this.szY)
    {
      bool = true;
      if (!bool) {
        break label349;
      }
      if (this.szL != null)
      {
        locala = this.szL;
        if (locala.sIh.cvk())
        {
          int i = paramMotionEvent.getActionMasked();
          if (i == 0)
          {
            locala.sIi = paramMotionEvent.getRawX();
            locala.dG = ((AudioManager)locala.mContext.getSystemService("audio")).getStreamVolume(3);
            locala.sxi = k.eN(locala.mContext);
          }
          GestureDetector localGestureDetector = locala.mQj;
          com.tencent.mm.hellhoundlib.b.a locala1 = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b(localGestureDetector, locala1.aYi(), "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          com.tencent.mm.hellhoundlib.a.a.a(localGestureDetector, localGestureDetector.onTouchEvent((MotionEvent)locala1.sb(0)), "com/tencent/mm/plugin/appbrand/jsapi/video/ui/VideoPlayerGestureController", "handleTouchEvent", "(Landroid/view/MotionEvent;)V", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
          if ((i != 1) && (i != 3)) {
            break label257;
          }
          if (locala.sIg != a.a.sIq) {
            break label282;
          }
          locala.sIh.q(locala.sIk, paramMotionEvent.getRawX() - locala.sIi);
          locala.sIj = -1;
          locala.sIk = 0;
          locala.sIi = 0.0F;
        }
      }
    }
    for (;;)
    {
      locala.sIg = a.a.sIn;
      label257:
      AppMethodBeat.o(137783);
      return true;
      bool = cvb();
      if (cvc()) {
        break;
      }
      bool = false;
      break;
      label282:
      if (locala.sIg == a.a.sIo)
      {
        ((AudioManager)locala.mContext.getSystemService("audio")).getStreamMaxVolume(3);
        locala.sIh.cvl();
      }
      else if (locala.sIg == a.a.sIp)
      {
        locala.sIh.cvm();
      }
    }
    label349:
    if ((paramMotionEvent.getAction() == 0) && (this.szH) && (this.szt.getVisibility() != 0))
    {
      this.szs.cvr();
      if (this.szX) {
        cuX();
      }
    }
    if (this.szQ)
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
    if (this.szZ)
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "onUIResume, should skip ui resume");
      this.szZ = false;
      AppMethodBeat.o(137753);
      return;
    }
    this.szp.onUIResume();
    AppMethodBeat.o(137753);
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137751);
    Log.i("MicroMsg.Video.AppBrandVideoView", "pause");
    if (!this.sAb)
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "pause, video not prepared");
      this.eDt = false;
      AppMethodBeat.o(137751);
      return;
    }
    if (!this.szp.isPlaying())
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "pause, video not playing");
      AppMethodBeat.o(137751);
      return;
    }
    this.szp.pause();
    if ((this.szr != null) && (this.szs.cvq())) {
      this.szr.pause();
    }
    AppMethodBeat.o(137751);
  }
  
  public final void q(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(137784);
    Log.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen toFullScreen:%b direction:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.szM == null)
    {
      Log.w("MicroMsg.Video.AppBrandVideoView", "operateFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(137784);
      return;
    }
    if (paramBoolean == cuZ())
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen current same");
      AppMethodBeat.o(137784);
      return;
    }
    if (paramInt == -1) {
      if (this.szn == -1)
      {
        paramInt = 90;
        Log.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen target direction:%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        this.saP = paramInt;
        this.szM.AM(paramInt);
        this.szs.anJ();
        jH(true);
        AppMethodBeat.o(137784);
        return;
        paramInt = this.szn;
        break;
      }
      this.szM.csz();
      this.szs.csz();
      AppMethodBeat.o(137784);
      return;
    }
  }
  
  public void setAutoPauseIfNavigate(boolean paramBoolean)
  {
    this.eyE = paramBoolean;
  }
  
  public void setAutoPauseIfOpenNative(boolean paramBoolean)
  {
    this.eyF = paramBoolean;
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(137745);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setAutoPlay %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.eyT = paramBoolean;
    AppMethodBeat.o(137745);
  }
  
  public void setCallback(com.tencent.mm.plugin.appbrand.jsapi.video.c.b paramb)
  {
    this.szI = paramb;
  }
  
  public void setComponent(f paramf)
  {
    AppMethodBeat.i(137738);
    this.szG = paramf;
    this.mAppId = paramf.getAppId();
    AppMethodBeat.o(137738);
  }
  
  public void setConsumeTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(137739);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setConsumeTouchEvent game=%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.szQ = paramBoolean;
    AppMethodBeat.o(137739);
  }
  
  public void setCookieData(String paramString)
  {
    this.szE = paramString;
  }
  
  public void setDanmakuEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(137767);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setDanmakuEnable %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.szs.setDanmakuBtnOpen(paramBoolean);
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
      if (this.szr == null)
      {
        Log.w("MicroMsg.Video.AppBrandVideoView", "setDanmakuItemList mDanmakuView null");
        cva();
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
      int k = com.tencent.mm.plugin.appbrand.af.i.agv(((JSONObject)localObject).optString("color", ""));
      j = k;
      if (k == 0) {
        j = -1;
      }
    }
    label205:
    paramJSONArray = this.szr;
    paramJSONArray.cwm();
    paramJSONArray.clearItems();
    paramJSONArray.sEa.clear();
    paramJSONArray.prepare();
    if (localArrayList.isEmpty())
    {
      paramJSONArray.cwn();
      AppMethodBeat.o(137778);
      return;
    }
    h.ahAA.bp(new DanmuView.4(paramJSONArray, localArrayList));
    paramJSONArray.cwn();
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
    this.szv.setText(Be(paramInt));
    this.cam = paramInt;
    AppMethodBeat.o(137747);
  }
  
  public void setEnablePlayGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(137744);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setEnablePlayGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.szY = paramBoolean;
    AppMethodBeat.o(137744);
  }
  
  public void setFullScreenDelegate(a parama)
  {
    this.szM = parama;
  }
  
  public void setFullScreenDirection(int paramInt)
  {
    AppMethodBeat.i(137774);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setFullScreenDirection %d", new Object[] { Integer.valueOf(paramInt) });
    this.szn = paramInt;
    AppMethodBeat.o(137774);
  }
  
  public void setFullScreenState(boolean paramBoolean)
  {
    AppMethodBeat.i(328752);
    if (paramBoolean)
    {
      this.szs.anJ();
      AppMethodBeat.o(328752);
      return;
    }
    this.szs.csz();
    AppMethodBeat.o(328752);
  }
  
  public void setIMMVideoViewCallback(d.c paramc)
  {
    this.sAf = paramc;
  }
  
  public void setInitialTime(double paramDouble)
  {
    AppMethodBeat.i(137777);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setInitialTime %s", new Object[] { Double.valueOf(paramDouble) });
    this.szO = paramDouble;
    AppMethodBeat.o(137777);
  }
  
  public void setIsEnableBottomProgressBar(boolean paramBoolean)
  {
    this.sAa = paramBoolean;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(137759);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setIsShowBasicControls %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.szH = paramBoolean;
    if (this.szs != null)
    {
      if (this.szH)
      {
        this.szs.cvs();
        AppMethodBeat.o(137759);
        return;
      }
      this.szs.hide();
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
    this.szp.setMute(paramBoolean);
    this.szs.setMuteBtnState(paramBoolean);
    AppMethodBeat.o(137770);
  }
  
  public void setObjectFit(String paramString)
  {
    AppMethodBeat.i(137769);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setObjectFit %s", new Object[] { paramString });
    if ("fill".equalsIgnoreCase(paramString))
    {
      this.szp.setScaleType(d.h.sAs);
      this.szA.setScaleType(ImageView.ScaleType.FIT_XY);
      AppMethodBeat.o(137769);
      return;
    }
    if ("cover".equalsIgnoreCase(paramString))
    {
      this.szp.setScaleType(d.h.sAu);
      this.szA.setScaleType(ImageView.ScaleType.CENTER_CROP);
      AppMethodBeat.o(137769);
      return;
    }
    this.szp.setScaleType(d.h.sAt);
    this.szA.setScaleType(ImageView.ScaleType.FIT_CENTER);
    AppMethodBeat.o(137769);
  }
  
  public void setPageGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(137775);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setPageGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.szJ = paramBoolean;
    AppMethodBeat.o(137775);
  }
  
  public void setPageGestureInFullscreen(boolean paramBoolean)
  {
    AppMethodBeat.i(137776);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setPageGestureInFullscreen %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.szK = paramBoolean;
    AppMethodBeat.o(137776);
  }
  
  public void setPlayBtnPosition(String paramString)
  {
    AppMethodBeat.i(137743);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setPlayBtnPosition %s", new Object[] { paramString });
    if ((!Util.isNullOrNil(paramString)) && (paramString.equalsIgnoreCase("center")))
    {
      this.szs.setPlayBtnInCenterPosition(true);
      AppMethodBeat.o(137743);
      return;
    }
    this.szs.setPlayBtnInCenterPosition(false);
    AppMethodBeat.o(137743);
  }
  
  public void setShowCenterPlayBtn(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(137766);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setShowCenterPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.szU = paramBoolean;
    View localView = this.szt;
    if (paramBoolean)
    {
      i = 0;
      localView.setVisibility(i);
      localView = this.szu;
      if (!paramBoolean) {
        break label105;
      }
    }
    label105:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      if ((this.szU) && (this.szs != null)) {
        this.szs.hide();
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
    d.a locala = this.szs;
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
      if (this.szr == null) {
        cva();
      }
      this.szs.setDanmakuBtnOnClickListener(new d.g()
      {
        public final void jI(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(328139);
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
              JSONObject localJSONObject = localb.cws();
              localJSONObject.put("showDanmu", paramAnonymousBoolean);
              localJSONObject.put("videoPlayerId", i);
              localb.a(new b.b((byte)0), localJSONObject);
              AppMethodBeat.o(328139);
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
          AppMethodBeat.o(328139);
        }
      });
    }
    this.szs.setShowDanmakuBtn(paramBoolean);
    AppMethodBeat.o(137768);
  }
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(137763);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setShowFullScreenBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.szs.setShowFullScreenBtn(paramBoolean);
    AppMethodBeat.o(137763);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(137740);
    Log.i("MicroMsg.Video.AppBrandVideoView", "showMuteBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.szs.setShowMuteBtn(paramBoolean);
    AppMethodBeat.o(137740);
  }
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(137764);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setShowPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.szs.setShowPlayBtn(paramBoolean);
    AppMethodBeat.o(137764);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(137762);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setShowProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.szS = paramBoolean;
    d.a locala = this.szs;
    if (((paramBoolean) || (this.szT)) && (!isLive())) {}
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
    AppMethodBeat.i(328673);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setShowProgressInControlMode %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.szT = paramBoolean;
    d.a locala = this.szs;
    if (((this.szS) || (paramBoolean)) && (!isLive())) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      locala.setShowProgress(paramBoolean);
      AppMethodBeat.o(328673);
      return;
    }
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(137741);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setTitle %s", new Object[] { paramString });
    this.szs.setTitle(paramString);
    AppMethodBeat.o(137741);
  }
  
  public void setVideoPlayerId(int paramInt)
  {
    this.szF = paramInt;
  }
  
  public void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(137746);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoSource %d", new Object[] { Integer.valueOf(paramInt) });
    this.szV = paramInt;
    AppMethodBeat.o(137746);
  }
  
  public final void start()
  {
    AppMethodBeat.i(137750);
    Log.i("MicroMsg.Video.AppBrandVideoView", "start");
    if (!this.sAb) {
      Log.i("MicroMsg.Video.AppBrandVideoView", "start, video not prepared");
    }
    for (this.eDt = true; this.szp.isPlaying(); this.eDt = false)
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "start, video is playing");
      AppMethodBeat.o(137750);
      return;
      Log.i("MicroMsg.Video.AppBrandVideoView", "start, video prepared, reset control flag");
    }
    if (this.szH) {
      this.szs.cvw();
    }
    this.szt.setVisibility(8);
    this.szp.start();
    if ((this.szr != null) && (this.szs.cvq())) {
      this.szr.show();
    }
    if (e.T(g.class) != null) {
      ((g)e.T(g.class)).report(this.szW);
    }
    AppMethodBeat.o(137750);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(137752);
    Log.i("MicroMsg.Video.AppBrandVideoView", "stop");
    if (!this.sAb)
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "stop, video not prepared");
      this.eDt = false;
      AppMethodBeat.o(137752);
      return;
    }
    if (!this.szp.isPlaying())
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "stop, video not playing");
      AppMethodBeat.o(137752);
      return;
    }
    this.szp.stop();
    this.szs.cvx();
    if (this.szr != null) {
      this.szr.hide();
    }
    AppMethodBeat.o(137752);
  }
  
  public static abstract interface a
  {
    public abstract void AM(int paramInt);
    
    public abstract void csz();
    
    public abstract boolean isFullScreen();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView
 * JD-Core Version:    0.7.0.1
 */