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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.appstorage.q;
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
import com.tencent.mm.plugin.appbrand.jsapi.video.danmu.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppBrandVideoView
  extends RelativeLayout
{
  private int add;
  private int atU;
  private boolean cEK;
  private boolean cEL;
  private boolean cEZ;
  private boolean cJg;
  private int lXF;
  private String mAppId;
  private boolean mIsMute;
  private boolean mLoop;
  private RelativeLayout mvI;
  public e mvJ;
  private TextView mvK;
  private DanmuView mvL;
  public e.a mvM;
  private View mvN;
  private View mvO;
  private TextView mvP;
  private LinearLayout mvQ;
  private AppBrandDotPercentIndicator mvR;
  private TextView mvS;
  private ImageView mvT;
  private ImageView mvU;
  private ImageView mvV;
  private ImageView mvW;
  private FrameLayout mvX;
  private String mvY;
  private int mvZ;
  private f mwa;
  private boolean mwb;
  public com.tencent.mm.plugin.appbrand.jsapi.video.c.b mwc;
  private boolean mwd;
  private boolean mwe;
  private com.tencent.mm.plugin.appbrand.jsapi.video.ui.a mwf;
  private a mwg;
  private boolean mwh;
  private double mwi;
  private String mwj;
  private boolean mwk;
  private boolean mwl;
  private boolean mwm;
  private boolean mwn;
  private boolean mwo;
  private int mwp;
  private String mwq;
  private boolean mwr;
  private boolean mws;
  private boolean mwt;
  private boolean mwu;
  private boolean mwv;
  private MTimerHandler mww;
  private int mwx;
  private int mwy;
  private e.c mwz;
  
  public AppBrandVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(137735);
    this.add = -1;
    this.mwt = false;
    this.mwu = true;
    this.mwv = false;
    this.cJg = false;
    this.mwx = 0;
    this.mwy = -16777216;
    init(paramContext);
    AppMethodBeat.o(137735);
  }
  
  public AppBrandVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(137736);
    this.add = -1;
    this.mwt = false;
    this.mwu = true;
    this.mwv = false;
    this.cJg = false;
    this.mwx = 0;
    this.mwy = -16777216;
    init(paramContext);
    AppMethodBeat.o(137736);
  }
  
  public <T extends View,  extends e> AppBrandVideoView(Context paramContext, T paramT)
  {
    super(paramContext);
    AppMethodBeat.i(137734);
    this.add = -1;
    this.mwt = false;
    this.mwu = true;
    this.mwv = false;
    this.cJg = false;
    this.mwx = 0;
    this.mwy = -16777216;
    this.mvJ = ((e)paramT);
    init(paramContext);
    this.mvI.addView(paramT);
    AppMethodBeat.o(137734);
  }
  
  public <T extends View,  extends e> AppBrandVideoView(Context paramContext, T paramT, byte paramByte)
  {
    super(paramContext);
    AppMethodBeat.i(234597);
    this.add = -1;
    this.mwt = false;
    this.mwu = true;
    this.mwv = false;
    this.cJg = false;
    this.mwx = 0;
    this.mwy = -16777216;
    this.mvJ = ((e)paramT);
    this.mwy = -16777216;
    init(paramContext);
    this.mvI.addView(paramT);
    AppMethodBeat.o(234597);
  }
  
  private void bIW()
  {
    AppMethodBeat.i(234598);
    if (this.mvJ != null) {
      this.mvJ.bIW();
    }
    AppMethodBeat.o(234598);
  }
  
  private void bIY()
  {
    AppMethodBeat.i(137780);
    this.mwf = new com.tencent.mm.plugin.appbrand.jsapi.video.ui.a(getContext(), this, new a.b()
    {
      public final void aM(float paramAnonymousFloat)
      {
        AppMethodBeat.i(234577);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(234577);
          return;
        }
        Log.d("MicroMsg.Video.AppBrandVideoView", "onAdjustVolume:".concat(String.valueOf(paramAnonymousFloat)));
        AppBrandVideoView.o(AppBrandVideoView.this).setPercent(paramAnonymousFloat);
        AppBrandVideoView.p(AppBrandVideoView.this).setText(2131762775);
        AppBrandVideoView.q(AppBrandVideoView.this).setImageResource(2131231074);
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(0);
        AppBrandVideoView.j(AppBrandVideoView.this);
        AppMethodBeat.o(234577);
      }
      
      public final void aN(float paramAnonymousFloat)
      {
        AppMethodBeat.i(234578);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(234578);
          return;
        }
        Log.d("MicroMsg.Video.AppBrandVideoView", "onAdjustBrightness:".concat(String.valueOf(paramAnonymousFloat)));
        AppBrandVideoView.o(AppBrandVideoView.this).setPercent(paramAnonymousFloat);
        AppBrandVideoView.p(AppBrandVideoView.this).setText(2131762774);
        AppBrandVideoView.q(AppBrandVideoView.this).setImageResource(2131231066);
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(0);
        AppBrandVideoView.j(AppBrandVideoView.this);
        AppMethodBeat.o(234578);
      }
      
      public final void bJj()
      {
        AppMethodBeat.i(234571);
        Log.d("MicroMsg.Video.AppBrandVideoView", "onSingleTap");
        if ((AppBrandVideoView.f(AppBrandVideoView.this)) && (AppBrandVideoView.g(AppBrandVideoView.this).getVisibility() != 0))
        {
          AppBrandVideoView.h(AppBrandVideoView.this).bJu();
          if (AppBrandVideoView.i(AppBrandVideoView.this)) {
            AppBrandVideoView.j(AppBrandVideoView.this);
          }
        }
        AppMethodBeat.o(234571);
      }
      
      public final void bJk()
      {
        AppMethodBeat.i(234572);
        Log.d("MicroMsg.Video.AppBrandVideoView", "onDoubleTap");
        if (AppBrandVideoView.k(AppBrandVideoView.this))
        {
          if (AppBrandVideoView.b(AppBrandVideoView.this).isPlaying())
          {
            AppBrandVideoView.this.pause();
            AppMethodBeat.o(234572);
            return;
          }
          AppBrandVideoView.this.start();
        }
        AppMethodBeat.o(234572);
      }
      
      public final void bJl()
      {
        AppMethodBeat.i(234573);
        if (!AppBrandVideoView.l(AppBrandVideoView.this))
        {
          AppMethodBeat.o(234573);
          return;
        }
        AppBrandVideoView.m(AppBrandVideoView.this).setVisibility(0);
        AppBrandVideoView.j(AppBrandVideoView.this);
        AppMethodBeat.o(234573);
      }
      
      public final void bJm()
      {
        AppMethodBeat.i(234579);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(234579);
          return;
        }
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.n(AppBrandVideoView.this);
        AppMethodBeat.o(234579);
      }
      
      public final void bJn()
      {
        AppMethodBeat.i(234580);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(234580);
          return;
        }
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.n(AppBrandVideoView.this);
        AppMethodBeat.o(234580);
      }
      
      public final boolean bJo()
      {
        AppMethodBeat.i(258646);
        boolean bool = AppBrandVideoView.s(AppBrandVideoView.this);
        AppMethodBeat.o(258646);
        return bool;
      }
      
      public final boolean bJp()
      {
        AppMethodBeat.i(258647);
        boolean bool = AppBrandVideoView.s(AppBrandVideoView.this);
        AppMethodBeat.o(258647);
        return bool;
      }
      
      public final boolean bJq()
      {
        AppMethodBeat.i(234583);
        boolean bool = AppBrandVideoView.l(AppBrandVideoView.this);
        AppMethodBeat.o(234583);
        return bool;
      }
      
      public final int getCurrentPosition()
      {
        AppMethodBeat.i(234576);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getCurrPosSec();
        AppMethodBeat.o(234576);
        return i;
      }
      
      public final int k(int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(234574);
        if (!AppBrandVideoView.l(AppBrandVideoView.this))
        {
          AppMethodBeat.o(234574);
          return 0;
        }
        Log.i("MicroMsg.Video.AppBrandVideoView", "onDragProgress:" + paramAnonymousInt + "/" + paramAnonymousFloat);
        paramAnonymousInt = AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec();
        int i = com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.a.c(paramAnonymousFloat, AppBrandVideoView.this.getMeasuredWidth(), getCurrentPosition(), paramAnonymousInt);
        String str = l.AF(paramAnonymousInt * 1000L);
        AppBrandVideoView.m(AppBrandVideoView.this).setText(l.AF(i * 1000L) + "/" + str);
        AppBrandVideoView.h(AppBrandVideoView.this).seek(i);
        if (AppBrandVideoView.h(AppBrandVideoView.this).bJw()) {
          AppBrandVideoView.h(AppBrandVideoView.this).bJB();
        }
        AppMethodBeat.o(234574);
        return i;
      }
      
      public final void l(int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(234575);
        if (!AppBrandVideoView.l(AppBrandVideoView.this))
        {
          AppMethodBeat.o(234575);
          return;
        }
        AppBrandVideoView.m(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.n(AppBrandVideoView.this);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(AppBrandVideoView.b(AppBrandVideoView.this).getCurrPosSec()), Float.valueOf(paramAnonymousFloat) });
        AppBrandVideoView.this.d(paramAnonymousInt, false);
        AppMethodBeat.o(234575);
      }
    });
    AppMethodBeat.o(137780);
  }
  
  private void bIZ()
  {
    AppMethodBeat.i(137781);
    this.mvM.bIZ();
    AppMethodBeat.o(137781);
  }
  
  private void bJa()
  {
    AppMethodBeat.i(137782);
    this.mvJ.setIMMVideoViewCallback(new e.c()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(234584);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        com.tencent.mm.plugin.appbrand.jsapi.video.c.b localb;
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null)
        {
          localb = AppBrandVideoView.d(AppBrandVideoView.this);
          localb.clean();
        }
        try
        {
          JSONObject localJSONObject = localb.bKv();
          localJSONObject.put("errMsg", paramAnonymousString3);
          localb.a(new b.d((byte)0), localJSONObject);
          if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
            AppBrandVideoView.t(AppBrandVideoView.this).c(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousInt1, paramAnonymousInt2);
          }
          AppMethodBeat.o(234584);
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
        AppMethodBeat.i(234587);
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
            JSONObject localJSONObject = ((com.tencent.mm.plugin.appbrand.jsapi.video.c.b)localObject).bKv();
            localJSONObject.put("width", paramAnonymousInt1);
            localJSONObject.put("height", paramAnonymousInt2);
            localJSONObject.put("duration", i * 1.0D / 1000.0D);
            ((com.tencent.mm.plugin.appbrand.jsapi.video.c.b)localObject).a(new b.f((byte)0), localJSONObject);
            if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
              AppBrandVideoView.t(AppBrandVideoView.this).d(paramAnonymousString1, paramAnonymousString2, paramAnonymousInt1, paramAnonymousInt2);
            }
            AppMethodBeat.o(234587);
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
      
      public final void dH(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(234585);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onPrepared");
        AppBrandVideoView.a(AppBrandVideoView.this, 0);
        AppBrandVideoView.u(AppBrandVideoView.this);
        AppBrandVideoView.v(AppBrandVideoView.this);
        if (AppBrandVideoView.w(AppBrandVideoView.this)) {
          AppBrandVideoView.this.start();
        }
        AppBrandVideoView.x(AppBrandVideoView.this).bKZ();
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
          AppBrandVideoView.d(AppBrandVideoView.this);
        }
        if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
          AppBrandVideoView.t(AppBrandVideoView.this).dH(paramAnonymousString1, paramAnonymousString2);
        }
        AppMethodBeat.o(234585);
      }
      
      public final void dI(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(234586);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onVideoEnded");
        AppBrandVideoView.y(AppBrandVideoView.this);
        AppBrandVideoView.m(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.h(AppBrandVideoView.this).setIsPlay(false);
        if ((AppBrandVideoView.h(AppBrandVideoView.this).bJw()) && (AppBrandVideoView.h(AppBrandVideoView.this).bJy())) {
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
            localb.a(new b.c((byte)0), localb.bKv());
            localb.bKw();
            if (AppBrandVideoView.F(AppBrandVideoView.this)) {
              AppBrandVideoView.this.d(0.0D, true);
            }
            if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
              AppBrandVideoView.t(AppBrandVideoView.this).dI(paramAnonymousString1, paramAnonymousString2);
            }
            AppMethodBeat.o(234586);
            return;
            if (AppBrandVideoView.D(AppBrandVideoView.this) <= 0) {
              AppBrandVideoView.E(AppBrandVideoView.this).setText(AppBrandVideoView.xu(AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec()));
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
      
      public final void dJ(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(234588);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onVideoPause");
        com.tencent.mm.plugin.appbrand.jsapi.video.c.b localb;
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
          localb = AppBrandVideoView.d(AppBrandVideoView.this);
        }
        try
        {
          localb.a(new b.g((byte)0), localb.bKv());
          localb.bKw();
          if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
            AppBrandVideoView.t(AppBrandVideoView.this).dJ(paramAnonymousString1, paramAnonymousString2);
          }
          AppMethodBeat.o(234588);
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
      
      public final void dK(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(234589);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(AppBrandVideoView.A(AppBrandVideoView.this)) });
        if ((AppBrandVideoView.D(AppBrandVideoView.this) <= 0) && (!AppBrandVideoView.A(AppBrandVideoView.this))) {
          AppBrandVideoView.E(AppBrandVideoView.this).setText(AppBrandVideoView.xu(AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec()));
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
          localb.mAN = 0;
          JSONObject localJSONObject = localb.bKv();
          localJSONObject.put("timeStamp", System.currentTimeMillis());
          localb.a(new b.h((byte)0), localJSONObject);
          if (localb.mAM == null) {
            localb.mAM = new MTimerHandler(new b.1(localb), true);
          }
          localb.mAM.startTimer(250L);
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
          AppBrandVideoView.t(AppBrandVideoView.this).dK(paramAnonymousString1, paramAnonymousString2);
        }
        AppMethodBeat.o(234589);
      }
      
      public final void dL(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(234590);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onVideoWaiting");
        com.tencent.mm.plugin.appbrand.jsapi.video.c.b localb;
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
          localb = AppBrandVideoView.d(AppBrandVideoView.this);
        }
        try
        {
          JSONObject localJSONObject = localb.bKv();
          localJSONObject.put("timeStamp", System.currentTimeMillis());
          localb.a(new b.m((byte)0), localJSONObject);
          AppBrandVideoView.b(AppBrandVideoView.this, true);
          AppBrandVideoView.j(AppBrandVideoView.this);
          if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
            AppBrandVideoView.t(AppBrandVideoView.this).dL(paramAnonymousString1, paramAnonymousString2);
          }
          AppMethodBeat.o(234590);
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
      
      public final void dM(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(234591);
        AppBrandVideoView.b(AppBrandVideoView.this, false);
        AppBrandVideoView.n(AppBrandVideoView.this);
        if (AppBrandVideoView.t(AppBrandVideoView.this) != null) {
          AppBrandVideoView.t(AppBrandVideoView.this).dM(paramAnonymousString1, paramAnonymousString2);
        }
        AppMethodBeat.o(234591);
      }
    });
    AppMethodBeat.o(137782);
  }
  
  private void bJc()
  {
    AppMethodBeat.i(137786);
    this.mvL = ((DanmuView)findViewById(2131299404));
    this.mvL.setDanmuViewCallBack(new c()
    {
      public final int baT()
      {
        AppMethodBeat.i(234592);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getCurrPosSec();
        AppMethodBeat.o(234592);
        return i;
      }
    });
    this.mvL.bKt();
    this.mvL.setMaxRunningPerRow(5);
    this.mvL.setPickItemInterval(200);
    this.mvL.hide();
    if ((this.mvJ != null) && (((View)this.mvJ).getHeight() > 0))
    {
      float f = this.mvL.getYOffset();
      int i = (int)(((View)this.mvJ).getHeight() * f);
      f = com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b.dW(getContext());
      this.mvL.setMaxRow((int)(i / f));
    }
    AppMethodBeat.o(137786);
  }
  
  private boolean bJd()
  {
    AppMethodBeat.i(137792);
    if ((this.mwl) && (!this.mvJ.isLive()) && (!bJf()))
    {
      AppMethodBeat.o(137792);
      return true;
    }
    AppMethodBeat.o(137792);
    return false;
  }
  
  private boolean bJe()
  {
    AppMethodBeat.i(137793);
    if ((!bJf()) && (((!bJb()) && (this.mwd)) || ((bJb()) && (this.mwe))))
    {
      AppMethodBeat.o(137793);
      return true;
    }
    AppMethodBeat.o(137793);
    return false;
  }
  
  private boolean bJf()
  {
    AppMethodBeat.i(137794);
    if (this.mvN.getVisibility() == 0)
    {
      AppMethodBeat.o(137794);
      return true;
    }
    AppMethodBeat.o(137794);
    return false;
  }
  
  private void bJg()
  {
    AppMethodBeat.i(234602);
    if (this.mww != null) {
      this.mww.stopTimer();
    }
    AppMethodBeat.o(234602);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(137737);
    LayoutInflater.from(paramContext).inflate(2131493112, this);
    setBackgroundColor(this.mwy);
    this.mvI = ((RelativeLayout)findViewById(2131309841));
    this.mvK = ((TextView)findViewById(2131306281));
    this.mvN = findViewById(2131299279);
    this.mvO = findViewById(2131299293);
    this.mvP = ((TextView)findViewById(2131299297));
    this.mvQ = ((LinearLayout)findViewById(2131296579));
    this.mvR = ((AppBrandDotPercentIndicator)findViewById(2131296580));
    this.mvS = ((TextView)findViewById(2131296576));
    this.mvT = ((ImageView)findViewById(2131296578));
    this.mvU = ((ImageView)findViewById(2131299277));
    this.mvV = ((ImageView)findViewById(2131305970));
    this.mvW = ((ImageView)findViewById(2131305969));
    this.mvX = ((FrameLayout)findViewById(2131305971));
    this.mvR.setDotsNum(8);
    ((ImageView)findViewById(2131299292)).setOnClickListener(new AppBrandVideoView.1(this));
    bIY();
    bJa();
    AppMethodBeat.o(137737);
  }
  
  private boolean isLive()
  {
    AppMethodBeat.i(137791);
    if ((this.mwh) || (this.mvJ.isLive()))
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
    if (!Util.isNullOrNil(this.mwj))
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "setCover mCoverUrl not null");
      AppMethodBeat.o(137761);
      return;
    }
    m.bZn().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(234569);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(234568);
            if ((this.val$bitmap != null) && (!this.val$bitmap.isRecycled())) {
              AppBrandVideoView.a(AppBrandVideoView.this).setImageBitmap(this.val$bitmap);
            }
            AppMethodBeat.o(234568);
          }
        });
        AppMethodBeat.o(234569);
      }
    });
    AppMethodBeat.o(137761);
  }
  
  private static String xs(int paramInt)
  {
    AppMethodBeat.i(137788);
    String str = xt(paramInt / 60) + ":" + xt(paramInt % 60);
    AppMethodBeat.o(137788);
    return str;
  }
  
  private static String xt(int paramInt)
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
    this.mvM = parama;
    if (((this.mvM instanceof View)) && (this.mvM != null))
    {
      parama = (View)this.mvM;
      if (parama.getId() != -1) {
        parama.setId(2131296933);
      }
    }
    this.mvM.hide();
    this.mvM.setFullScreenBtnOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(234593);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (!AppBrandVideoView.this.bJb()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView = AppBrandVideoView.this;
          paramAnonymousView.p(bool, AppBrandVideoView.G(paramAnonymousView));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(234593);
          return;
        }
      }
    });
    this.mvM.setIplaySeekCallback(new e.d()
    {
      public final void aJq()
      {
        AppMethodBeat.i(234594);
        Log.i("MicroMsg.Video.AppBrandVideoView", "onSeekPre");
        AppMethodBeat.o(234594);
      }
      
      public final void rk(int paramAnonymousInt)
      {
        AppMethodBeat.i(234595);
        AppBrandVideoView.this.d(paramAnonymousInt, false);
        AppMethodBeat.o(234595);
      }
    });
    this.mvM.setOnPlayButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(234596);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (AppBrandVideoView.b(AppBrandVideoView.this).isPlaying()) {
          AppBrandVideoView.this.pause();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(234596);
          return;
          AppBrandVideoView.this.start();
        }
      }
    });
    this.mvM.setStatePorter(new e.i()
    {
      public final int bJh()
      {
        AppMethodBeat.i(234562);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getCacheTimeSec();
        AppMethodBeat.o(234562);
        return i;
      }
      
      public final int bJi()
      {
        AppMethodBeat.i(234563);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec();
        AppMethodBeat.o(234563);
        return i;
      }
    });
    this.mvM.setMuteBtnOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(234564);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = AppBrandVideoView.this;
        if (!AppBrandVideoView.J(AppBrandVideoView.this)) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setMute(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(234564);
          return;
        }
      }
    });
    this.mvM.setExitFullScreenBtnOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(137702);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        AppBrandVideoView.this.p(false, AppBrandVideoView.G(AppBrandVideoView.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(137702);
      }
    });
    this.mvM.a(new e.f()
    {
      public final void onVisibilityChanged(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(234565);
        AppBrandVideoView.H(AppBrandVideoView.this);
        AppMethodBeat.o(234565);
      }
    });
    this.mvM.setOnUpdateProgressLenListener(new e.e()
    {
      public final void onProgressChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(234566);
        if (paramAnonymousInt2 <= 0)
        {
          AppMethodBeat.o(234566);
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
          AppMethodBeat.o(234566);
          return;
        }
      }
    });
    AppMethodBeat.o(137787);
  }
  
  public final void bIX()
  {
    AppMethodBeat.i(234599);
    d(0.0D, false);
    AppMethodBeat.o(234599);
  }
  
  public final boolean bJb()
  {
    AppMethodBeat.i(137785);
    if (this.mwg == null)
    {
      Log.w("MicroMsg.Video.AppBrandVideoView", "isInFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(137785);
      return false;
    }
    boolean bool = this.mwg.isFullScreen();
    AppMethodBeat.o(137785);
    return bool;
  }
  
  public final void clean()
  {
    AppMethodBeat.i(137756);
    Log.i("MicroMsg.Video.AppBrandVideoView", "clean");
    stop();
    this.mvJ.onUIDestroy();
    if (this.mvL != null) {
      this.mvL.clear();
    }
    this.mvM.onDestroy();
    bJg();
    AppMethodBeat.o(137756);
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(137758);
    int i = this.mvJ.getCurrPosSec();
    Log.i("MicroMsg.Video.AppBrandVideoView", "seek to position=%s current=%d isLive=%b", new Object[] { Double.valueOf(paramDouble), Integer.valueOf(i), Boolean.valueOf(this.mwh) });
    if (isLive())
    {
      AppMethodBeat.o(137758);
      return;
    }
    this.mvN.setVisibility(8);
    if (paramBoolean) {
      this.mvJ.c(paramDouble, paramBoolean);
    }
    for (;;)
    {
      if ((this.mvL != null) && (i > paramDouble)) {
        this.mvL.xE((int)paramDouble);
      }
      AppMethodBeat.o(137758);
      return;
      this.mvJ.p(paramDouble);
    }
  }
  
  public final boolean dG(String arg1, String paramString2)
  {
    AppMethodBeat.i(137779);
    if (this.mvL == null)
    {
      Log.w("MicroMsg.Video.AppBrandVideoView", " addDanmaku mDanmakuView null");
      bJc();
    }
    int j = g.afD(paramString2);
    int i = j;
    if (j == 0) {
      i = -1;
    }
    paramString2 = new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a(getContext(), new SpannableString(???), i, this.mvJ.getCurrPosSec());
    DanmuView localDanmuView = this.mvL;
    synchronized (localDanmuView.mAz)
    {
      localDanmuView.mAz.offerFirst(paramString2);
      com.tencent.f.h.RTc.b(new DanmuView.3(localDanmuView, paramString2), "DanmuView-addItemToWaitingHead");
      AppMethodBeat.o(137779);
      return true;
    }
  }
  
  public final void e(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(137757);
    String str = paramString;
    if (this.mwa != null)
    {
      str = paramString;
      if (this.mwa.getFileSystem() != null)
      {
        str = paramString;
        if (this.mwa.getFileSystem().Vi(paramString))
        {
          paramString = this.mwa.getFileSystem().VY(paramString);
          if (paramString != null) {
            break label124;
          }
        }
      }
    }
    label124:
    for (paramString = null;; paramString = "file://" + aa.z(paramString.her()))
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
    this.mwh = paramBoolean;
    this.mwq = str;
    this.mvJ.setVideoSource(this.mwp);
    this.mvJ.c(paramBoolean, str, paramInt);
    if (this.mwi > 0.0D) {
      this.mvJ.c(this.mwi, this.cEZ);
    }
    Object localObject;
    if ((this.mwp == 1) && (com.tencent.luggage.a.e.M(h.class) != null))
    {
      localObject = ((h)com.tencent.luggage.a.e.M(h.class)).aaT(this.mwq);
      if (localObject != null)
      {
        Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath localVideoPath:%s", new Object[] { localObject });
        paramString = this.mwq;
        Log.i("MicroMsg.Video.AppBrandVideoView", "leonlad setPreLoadVideoPath %s", new Object[] { localObject });
        if ((!this.mvJ.isPlaying()) && (this.mwq.equalsIgnoreCase(paramString)))
        {
          this.mwq = paramString;
          this.mvJ.c(this.mwh, (String)localObject, 0);
          if (!this.cEZ) {
            break label452;
          }
          Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay true");
          start();
        }
      }
    }
    for (;;)
    {
      if (this.mwc != null) {
        localObject = this.mwc;
      }
      try
      {
        JSONObject localJSONObject = ((com.tencent.mm.plugin.appbrand.jsapi.video.c.b)localObject).bKv();
        localJSONObject.put("timeStamp", System.currentTimeMillis());
        localJSONObject.put("url", paramString);
        ((com.tencent.mm.plugin.appbrand.jsapi.video.c.b)localObject).a(new b.a((byte)0), localJSONObject);
        if (this.cEZ)
        {
          Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay true");
          start();
          setCover(str);
          AppMethodBeat.o(137757);
          return;
          label452:
          Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay false");
          bIW();
        }
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          Log.e("MicroMsg.Video.JsApiVideoCallback", "onVideoCanPlay e=%s", new Object[] { paramString });
          continue;
          Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay false");
          bIW();
        }
      }
    }
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(137773);
    if (this.mvJ != null)
    {
      int i = this.mvJ.getCacheTimeSec();
      AppMethodBeat.o(137773);
      return i;
    }
    AppMethodBeat.o(137773);
    return 0;
  }
  
  public com.tencent.mm.plugin.appbrand.jsapi.video.c.b getCallback()
  {
    return this.mwc;
  }
  
  public String getCookieData()
  {
    return this.mvY;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(137772);
    int i = this.mvJ.getCurrPosMs();
    AppMethodBeat.o(137772);
    return i;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(137771);
    int i = this.mvJ.getCurrPosSec();
    AppMethodBeat.o(137771);
    return i;
  }
  
  public int getDuration()
  {
    AppMethodBeat.i(137748);
    if (this.atU > 0)
    {
      i = this.atU;
      AppMethodBeat.o(137748);
      return i;
    }
    int i = this.mvJ.getVideoDurationSec();
    AppMethodBeat.o(137748);
    return i;
  }
  
  public final void hM(boolean paramBoolean)
  {
    AppMethodBeat.i(137765);
    Log.i("MicroMsg.Video.AppBrandVideoView", "enableProgressGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mwl = paramBoolean;
    AppMethodBeat.o(137765);
  }
  
  public final void hN(boolean paramBoolean)
  {
    AppMethodBeat.i(137790);
    if (this.mwc == null)
    {
      AppMethodBeat.o(137790);
      return;
    }
    this.mwc.c(this.mvZ, paramBoolean, this.lXF);
    AppMethodBeat.o(137790);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(137783);
    if (this.mws) {
      bool = true;
    }
    while (bool)
    {
      if (this.mwf != null) {
        this.mwf.A(paramMotionEvent);
      }
      AppMethodBeat.o(137783);
      return true;
      bool = bJd();
      if (!bJe()) {
        bool = false;
      }
    }
    if ((paramMotionEvent.getAction() == 0) && (this.mwb) && (this.mvN.getVisibility() != 0))
    {
      this.mvM.bJu();
      if (this.mwr) {
        bIZ();
      }
    }
    if (this.mwk)
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
    if (this.mwt)
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "onUIResume, should skip ui resume");
      this.mwt = false;
      AppMethodBeat.o(137753);
      return;
    }
    this.mvJ.onUIResume();
    AppMethodBeat.o(137753);
  }
  
  public final void p(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(137784);
    Log.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen toFullScreen:%b direction:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.mwg == null)
    {
      Log.w("MicroMsg.Video.AppBrandVideoView", "operateFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(137784);
      return;
    }
    if (paramBoolean == bJb())
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen current same");
      AppMethodBeat.o(137784);
      return;
    }
    if (paramInt == -1) {
      if (this.add == -1)
      {
        paramInt = 90;
        Log.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen target direction:%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        this.lXF = paramInt;
        this.mwg.xd(paramInt);
        this.mvM.KD();
        hN(true);
        AppMethodBeat.o(137784);
        return;
        paramInt = this.add;
        break;
      }
      this.mwg.bGL();
      this.mvM.bGL();
      AppMethodBeat.o(137784);
      return;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137751);
    Log.i("MicroMsg.Video.AppBrandVideoView", "pause");
    if (!this.mwv)
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "pause, video not prepared");
      this.cJg = false;
      AppMethodBeat.o(137751);
      return;
    }
    if (!this.mvJ.isPlaying())
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "pause, video not playing");
      AppMethodBeat.o(137751);
      return;
    }
    this.mvJ.pause();
    if ((this.mvL != null) && (this.mvM.bJt())) {
      this.mvL.pause();
    }
    AppMethodBeat.o(137751);
  }
  
  public void setAutoPauseIfNavigate(boolean paramBoolean)
  {
    this.cEK = paramBoolean;
  }
  
  public void setAutoPauseIfOpenNative(boolean paramBoolean)
  {
    this.cEL = paramBoolean;
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(137745);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setAutoPlay %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.cEZ = paramBoolean;
    AppMethodBeat.o(137745);
  }
  
  public void setCallback(com.tencent.mm.plugin.appbrand.jsapi.video.c.b paramb)
  {
    this.mwc = paramb;
  }
  
  public void setComponent(f paramf)
  {
    AppMethodBeat.i(137738);
    this.mwa = paramf;
    this.mAppId = paramf.getAppId();
    AppMethodBeat.o(137738);
  }
  
  public void setConsumeTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(137739);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setConsumeTouchEvent game=%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mwk = paramBoolean;
    AppMethodBeat.o(137739);
  }
  
  public void setCookieData(String paramString)
  {
    this.mvY = paramString;
  }
  
  public final void setCover$16da05f7(String paramString)
  {
    AppMethodBeat.i(137760);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setCover:%s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(137760);
      return;
    }
    this.mwj = paramString;
    com.tencent.mm.modelappbrand.a.b.aXY().a(this.mvU, paramString, null, null);
    AppMethodBeat.o(137760);
  }
  
  public void setDanmakuEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(137767);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setDanmakuEnable %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mvM.setDanmakuBtnOpen(paramBoolean);
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
      if (this.mvL == null)
      {
        Log.w("MicroMsg.Video.AppBrandVideoView", "setDanmakuItemList mDanmakuView null");
        bJc();
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
      int k = g.afD(((JSONObject)localObject).optString("color", ""));
      j = k;
      if (k == 0) {
        j = -1;
      }
    }
    label203:
    paramJSONArray = this.mvL;
    paramJSONArray.bKp();
    paramJSONArray.clearItems();
    paramJSONArray.mAA.clear();
    paramJSONArray.prepare();
    if (localArrayList.isEmpty())
    {
      paramJSONArray.bKq();
      AppMethodBeat.o(137778);
      return;
    }
    com.tencent.f.h.RTc.ba(new DanmuView.4(paramJSONArray, localArrayList));
    paramJSONArray.bKq();
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
    this.mvP.setText(xs(paramInt));
    this.atU = paramInt;
    AppMethodBeat.o(137747);
  }
  
  public void setEnablePlayGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(137744);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setEnablePlayGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mws = paramBoolean;
    AppMethodBeat.o(137744);
  }
  
  public void setFullScreenDelegate(a parama)
  {
    this.mwg = parama;
  }
  
  public void setFullScreenDirection(int paramInt)
  {
    AppMethodBeat.i(137774);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setFullScreenDirection %d", new Object[] { Integer.valueOf(paramInt) });
    this.add = paramInt;
    AppMethodBeat.o(137774);
  }
  
  public void setFullScreenState(boolean paramBoolean)
  {
    AppMethodBeat.i(234601);
    if (paramBoolean)
    {
      this.mvM.KD();
      AppMethodBeat.o(234601);
      return;
    }
    this.mvM.bGL();
    AppMethodBeat.o(234601);
  }
  
  public void setIMMVideoViewCallback(e.c paramc)
  {
    this.mwz = paramc;
  }
  
  public void setInitialTime(double paramDouble)
  {
    AppMethodBeat.i(137777);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setInitialTime %s", new Object[] { Double.valueOf(paramDouble) });
    this.mwi = paramDouble;
    AppMethodBeat.o(137777);
  }
  
  public void setIsEnableBottomProgressBar(boolean paramBoolean)
  {
    this.mwu = paramBoolean;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(137759);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setIsShowBasicControls %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mwb = paramBoolean;
    if (this.mvM != null)
    {
      if (this.mwb)
      {
        this.mvM.bJv();
        AppMethodBeat.o(137759);
        return;
      }
      this.mvM.hide();
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
    this.mvJ.setMute(paramBoolean);
    this.mvM.setMuteBtnState(paramBoolean);
    AppMethodBeat.o(137770);
  }
  
  public void setObjectFit(String paramString)
  {
    AppMethodBeat.i(137769);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setObjectFit %s", new Object[] { paramString });
    if ("fill".equalsIgnoreCase(paramString))
    {
      this.mvJ.setScaleType(e.h.mwS);
      this.mvU.setScaleType(ImageView.ScaleType.FIT_XY);
      AppMethodBeat.o(137769);
      return;
    }
    if ("cover".equalsIgnoreCase(paramString))
    {
      this.mvJ.setScaleType(e.h.mwU);
      this.mvU.setScaleType(ImageView.ScaleType.CENTER_CROP);
      AppMethodBeat.o(137769);
      return;
    }
    this.mvJ.setScaleType(e.h.mwT);
    this.mvU.setScaleType(ImageView.ScaleType.FIT_CENTER);
    AppMethodBeat.o(137769);
  }
  
  public void setPageGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(137775);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setPageGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mwd = paramBoolean;
    AppMethodBeat.o(137775);
  }
  
  public void setPageGestureInFullscreen(boolean paramBoolean)
  {
    AppMethodBeat.i(137776);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setPageGestureInFullscreen %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mwe = paramBoolean;
    AppMethodBeat.o(137776);
  }
  
  public void setPlayBtnPosition(String paramString)
  {
    AppMethodBeat.i(137743);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setPlayBtnPosition %s", new Object[] { paramString });
    if ((!Util.isNullOrNil(paramString)) && (paramString.equalsIgnoreCase("center")))
    {
      this.mvM.setPlayBtnInCenterPosition(true);
      AppMethodBeat.o(137743);
      return;
    }
    this.mvM.setPlayBtnInCenterPosition(false);
    AppMethodBeat.o(137743);
  }
  
  public void setShowCenterPlayBtn(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(137766);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setShowCenterPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mwo = paramBoolean;
    View localView = this.mvN;
    if (paramBoolean)
    {
      i = 0;
      localView.setVisibility(i);
      localView = this.mvO;
      if (!paramBoolean) {
        break label104;
      }
    }
    label104:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      if ((this.mwo) && (this.mvM != null)) {
        this.mvM.hide();
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
    e.a locala = this.mvM;
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
      if (this.mvL == null) {
        bJc();
      }
      this.mvM.setDanmakuBtnOnClickListener(new e.g()
      {
        public final void hO(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(234570);
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
              JSONObject localJSONObject = localb.bKv();
              localJSONObject.put("showDanmu", paramAnonymousBoolean);
              localJSONObject.put("videoPlayerId", i);
              localb.a(new b.b((byte)0), localJSONObject);
              AppMethodBeat.o(234570);
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
          AppMethodBeat.o(234570);
        }
      });
    }
    this.mvM.setShowDanmakuBtn(paramBoolean);
    AppMethodBeat.o(137768);
  }
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(137763);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setShowFullScreenBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mvM.setShowFullScreenBtn(paramBoolean);
    AppMethodBeat.o(137763);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(137740);
    Log.i("MicroMsg.Video.AppBrandVideoView", "showMuteBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mvM.setShowMuteBtn(paramBoolean);
    AppMethodBeat.o(137740);
  }
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(137764);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setShowPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mvM.setShowPlayBtn(paramBoolean);
    AppMethodBeat.o(137764);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(137762);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setShowProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mwm = paramBoolean;
    e.a locala = this.mvM;
    if (((paramBoolean) || (this.mwn)) && (!isLive())) {}
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
    AppMethodBeat.i(234600);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setShowProgressInControlMode %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mwn = paramBoolean;
    e.a locala = this.mvM;
    if (((this.mwm) || (paramBoolean)) && (!isLive())) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      locala.setShowProgress(paramBoolean);
      AppMethodBeat.o(234600);
      return;
    }
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(137741);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setTitle %s", new Object[] { paramString });
    this.mvM.setTitle(paramString);
    AppMethodBeat.o(137741);
  }
  
  public void setVideoPlayerId(int paramInt)
  {
    this.mvZ = paramInt;
  }
  
  public void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(137746);
    Log.i("MicroMsg.Video.AppBrandVideoView", "setVideoSource %d", new Object[] { Integer.valueOf(paramInt) });
    this.mwp = paramInt;
    AppMethodBeat.o(137746);
  }
  
  public final void start()
  {
    AppMethodBeat.i(137750);
    Log.i("MicroMsg.Video.AppBrandVideoView", "start");
    if (!this.mwv) {
      Log.i("MicroMsg.Video.AppBrandVideoView", "start, video not prepared");
    }
    for (this.cJg = true; this.mvJ.isPlaying(); this.cJg = false)
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "start, video is playing");
      AppMethodBeat.o(137750);
      return;
      Log.i("MicroMsg.Video.AppBrandVideoView", "start, video prepared, reset control flag");
    }
    if (this.mwb) {
      this.mvM.bJz();
    }
    this.mvN.setVisibility(8);
    this.mvJ.start();
    if ((this.mvL != null) && (this.mvM.bJt())) {
      this.mvL.show();
    }
    if (com.tencent.luggage.a.e.M(h.class) != null) {
      ((h)com.tencent.luggage.a.e.M(h.class)).report(this.mwq);
    }
    AppMethodBeat.o(137750);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(137752);
    Log.i("MicroMsg.Video.AppBrandVideoView", "stop");
    if (!this.mwv)
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "stop, video not prepared");
      this.cJg = false;
      AppMethodBeat.o(137752);
      return;
    }
    if (!this.mvJ.isPlaying())
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "stop, video not playing");
      AppMethodBeat.o(137752);
      return;
    }
    this.mvJ.stop();
    this.mvM.bJA();
    if (this.mvL != null) {
      this.mvL.hide();
    }
    AppMethodBeat.o(137752);
  }
  
  public final void xr(int paramInt)
  {
    AppMethodBeat.i(137754);
    Log.i("MicroMsg.Video.AppBrandVideoView", "onUIPause, type:%d", new Object[] { Integer.valueOf(paramInt) });
    if (((paramInt == 2) && (!this.cEL)) || ((paramInt == 1) && (!this.cEK)))
    {
      Log.i("MicroMsg.Video.AppBrandVideoView", "onUIPause, should skip ui pause");
      this.mwt = true;
      AppMethodBeat.o(137754);
      return;
    }
    this.mvJ.onUIPause();
    AppMethodBeat.o(137754);
  }
  
  public static abstract interface a
  {
    public abstract void bGL();
    
    public abstract boolean isFullScreen();
    
    public abstract void xd(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView
 * JD-Core Version:    0.7.0.1
 */