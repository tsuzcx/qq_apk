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
import com.tencent.mm.plugin.appbrand.appstorage.p;
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
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.AppBrandDotPercentIndicator;
import com.tencent.mm.plugin.appbrand.jsapi.video.ui.a.b;
import com.tencent.mm.plugin.appbrand.z.m;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
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
  private int acQ;
  private int atW;
  private boolean crS;
  private boolean crT;
  private boolean csg;
  private boolean cuF;
  private int kOR;
  private RelativeLayout lkE;
  public e lkF;
  private TextView lkG;
  private DanmuView lkH;
  public e.a lkI;
  private View lkJ;
  private View lkK;
  private TextView lkL;
  private LinearLayout lkM;
  private AppBrandDotPercentIndicator lkN;
  private TextView lkO;
  private ImageView lkP;
  private ImageView lkQ;
  private ImageView lkR;
  private ImageView lkS;
  private FrameLayout lkT;
  private String lkU;
  private int lkV;
  private com.tencent.mm.plugin.appbrand.jsapi.c lkW;
  private boolean lkX;
  public com.tencent.mm.plugin.appbrand.jsapi.video.c.b lkY;
  private boolean lkZ;
  private boolean lla;
  private com.tencent.mm.plugin.appbrand.jsapi.video.ui.a llb;
  private a llc;
  private boolean lld;
  private boolean lle;
  private double llf;
  private String llg;
  private boolean llh;
  private boolean lli;
  private boolean llj;
  private boolean llk;
  private boolean lll;
  private int llm;
  private String lln;
  private boolean llo;
  private boolean llp;
  private boolean llq;
  private boolean llr;
  private boolean lls;
  private av llt;
  private int llu;
  private String mAppId;
  private boolean mIsMute;
  
  public AppBrandVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(137735);
    this.acQ = -1;
    this.llq = false;
    this.llr = true;
    this.lls = false;
    this.cuF = false;
    this.llu = 0;
    init(paramContext);
    AppMethodBeat.o(137735);
  }
  
  public AppBrandVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(137736);
    this.acQ = -1;
    this.llq = false;
    this.llr = true;
    this.lls = false;
    this.cuF = false;
    this.llu = 0;
    init(paramContext);
    AppMethodBeat.o(137736);
  }
  
  public <T extends View,  extends e> AppBrandVideoView(Context paramContext, T paramT)
  {
    super(paramContext);
    AppMethodBeat.i(137734);
    this.acQ = -1;
    this.llq = false;
    this.llr = true;
    this.lls = false;
    this.cuF = false;
    this.llu = 0;
    this.lkF = ((e)paramT);
    init(paramContext);
    this.lkE.addView(paramT);
    AppMethodBeat.o(137734);
  }
  
  private boolean bhH()
  {
    AppMethodBeat.i(137791);
    if ((this.lld) || (this.lkF.bhH()))
    {
      AppMethodBeat.o(137791);
      return true;
    }
    AppMethodBeat.o(137791);
    return false;
  }
  
  private void bmJ()
  {
    AppMethodBeat.i(205908);
    if (this.lkF != null) {
      this.lkF.bmJ();
    }
    AppMethodBeat.o(205908);
  }
  
  private void bmK()
  {
    AppMethodBeat.i(137780);
    this.llb = new com.tencent.mm.plugin.appbrand.jsapi.video.ui.a(getContext(), this, new a.b()
    {
      public final void aC(float paramAnonymousFloat)
      {
        AppMethodBeat.i(205888);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(205888);
          return;
        }
        ad.d("MicroMsg.Video.AppBrandVideoView", "onAdjustVolume:".concat(String.valueOf(paramAnonymousFloat)));
        AppBrandVideoView.o(AppBrandVideoView.this).setPercent(paramAnonymousFloat);
        AppBrandVideoView.p(AppBrandVideoView.this).setText(2131760999);
        AppBrandVideoView.q(AppBrandVideoView.this).setImageResource(2131231041);
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(0);
        AppBrandVideoView.j(AppBrandVideoView.this);
        AppMethodBeat.o(205888);
      }
      
      public final void aD(float paramAnonymousFloat)
      {
        AppMethodBeat.i(205889);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(205889);
          return;
        }
        ad.d("MicroMsg.Video.AppBrandVideoView", "onAdjustBrightness:".concat(String.valueOf(paramAnonymousFloat)));
        AppBrandVideoView.o(AppBrandVideoView.this).setPercent(paramAnonymousFloat);
        AppBrandVideoView.p(AppBrandVideoView.this).setText(2131760998);
        AppBrandVideoView.q(AppBrandVideoView.this).setImageResource(2131231033);
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(0);
        AppBrandVideoView.j(AppBrandVideoView.this);
        AppMethodBeat.o(205889);
      }
      
      public final void bmV()
      {
        AppMethodBeat.i(205882);
        ad.d("MicroMsg.Video.AppBrandVideoView", "onSingleTap");
        if ((AppBrandVideoView.f(AppBrandVideoView.this)) && (AppBrandVideoView.g(AppBrandVideoView.this).getVisibility() != 0))
        {
          AppBrandVideoView.h(AppBrandVideoView.this).bng();
          if (AppBrandVideoView.i(AppBrandVideoView.this)) {
            AppBrandVideoView.j(AppBrandVideoView.this);
          }
        }
        AppMethodBeat.o(205882);
      }
      
      public final void bmW()
      {
        AppMethodBeat.i(205883);
        ad.d("MicroMsg.Video.AppBrandVideoView", "onDoubleTap");
        if (AppBrandVideoView.k(AppBrandVideoView.this))
        {
          if (AppBrandVideoView.b(AppBrandVideoView.this).isPlaying())
          {
            AppBrandVideoView.this.pause();
            AppMethodBeat.o(205883);
            return;
          }
          AppBrandVideoView.this.start();
        }
        AppMethodBeat.o(205883);
      }
      
      public final void bmX()
      {
        AppMethodBeat.i(205884);
        if (!AppBrandVideoView.l(AppBrandVideoView.this))
        {
          AppMethodBeat.o(205884);
          return;
        }
        AppBrandVideoView.m(AppBrandVideoView.this).setVisibility(0);
        AppBrandVideoView.j(AppBrandVideoView.this);
        AppMethodBeat.o(205884);
      }
      
      public final void bmY()
      {
        AppMethodBeat.i(205890);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(205890);
          return;
        }
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.n(AppBrandVideoView.this);
        AppMethodBeat.o(205890);
      }
      
      public final void bmZ()
      {
        AppMethodBeat.i(205891);
        if (!AppBrandVideoView.s(AppBrandVideoView.this))
        {
          AppMethodBeat.o(205891);
          return;
        }
        AppBrandVideoView.r(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.n(AppBrandVideoView.this);
        AppMethodBeat.o(205891);
      }
      
      public final boolean bna()
      {
        AppMethodBeat.i(221581);
        boolean bool = AppBrandVideoView.s(AppBrandVideoView.this);
        AppMethodBeat.o(221581);
        return bool;
      }
      
      public final boolean bnb()
      {
        AppMethodBeat.i(221582);
        boolean bool = AppBrandVideoView.s(AppBrandVideoView.this);
        AppMethodBeat.o(221582);
        return bool;
      }
      
      public final boolean bnc()
      {
        AppMethodBeat.i(205894);
        boolean bool = AppBrandVideoView.l(AppBrandVideoView.this);
        AppMethodBeat.o(205894);
        return bool;
      }
      
      public final int getCurrentPosition()
      {
        AppMethodBeat.i(205887);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getCurrPosSec();
        AppMethodBeat.o(205887);
        return i;
      }
      
      public final int k(int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(205885);
        if (!AppBrandVideoView.l(AppBrandVideoView.this))
        {
          AppMethodBeat.o(205885);
          return 0;
        }
        ad.i("MicroMsg.Video.AppBrandVideoView", "onDragProgress:" + paramAnonymousInt + "/" + paramAnonymousFloat);
        paramAnonymousInt = AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec();
        int i = com.tencent.mm.plugin.appbrand.jsapi.video.progressbar.a.c(paramAnonymousFloat, AppBrandVideoView.this.getMeasuredWidth(), getCurrentPosition(), paramAnonymousInt);
        String str = l.sm(paramAnonymousInt * 1000L);
        AppBrandVideoView.m(AppBrandVideoView.this).setText(l.sm(i * 1000L) + "/" + str);
        AppBrandVideoView.h(AppBrandVideoView.this).seek(i);
        if (AppBrandVideoView.h(AppBrandVideoView.this).bni()) {
          AppBrandVideoView.h(AppBrandVideoView.this).bno();
        }
        AppMethodBeat.o(205885);
        return i;
      }
      
      public final void l(int paramAnonymousInt, float paramAnonymousFloat)
      {
        AppMethodBeat.i(205886);
        if (!AppBrandVideoView.l(AppBrandVideoView.this))
        {
          AppMethodBeat.o(205886);
          return;
        }
        AppBrandVideoView.m(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.n(AppBrandVideoView.this);
        ad.i("MicroMsg.Video.AppBrandVideoView", "onEndDragProgress: dragPosition=%d currentPositon=%d totalDistanceX=%s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(AppBrandVideoView.b(AppBrandVideoView.this).getCurrPosSec()), Float.valueOf(paramAnonymousFloat) });
        AppBrandVideoView.this.d(paramAnonymousInt, false);
        AppMethodBeat.o(205886);
      }
    });
    AppMethodBeat.o(137780);
  }
  
  private void bmL()
  {
    AppMethodBeat.i(137781);
    this.lkI.bmL();
    AppMethodBeat.o(137781);
  }
  
  private void bmM()
  {
    AppMethodBeat.i(137782);
    this.lkF.setIMMVideoViewCallback(new e.c()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(205895);
        ad.i("MicroMsg.Video.AppBrandVideoView", "onError errorMsg=%s what=%d extra=%d", new Object[] { paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null)
        {
          paramAnonymousString1 = AppBrandVideoView.d(AppBrandVideoView.this);
          paramAnonymousString1.clean();
          try
          {
            paramAnonymousString2 = paramAnonymousString1.boi();
            paramAnonymousString2.put("errMsg", paramAnonymousString3);
            paramAnonymousString1.a(new b.d((byte)0), paramAnonymousString2);
            AppMethodBeat.o(205895);
            return;
          }
          catch (JSONException paramAnonymousString1)
          {
            ad.e("MicroMsg.Video.JsApiVideoCallback", "onError e=%s", new Object[] { paramAnonymousString1 });
          }
        }
        AppMethodBeat.o(205895);
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(205898);
        ad.i("MicroMsg.Video.AppBrandVideoView", "onGetVideoSize width=%d height=%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (AppBrandVideoView.F(AppBrandVideoView.this) == -1)
        {
          paramAnonymousString1 = AppBrandVideoView.this;
          if (paramAnonymousInt1 >= paramAnonymousInt2) {
            break label205;
          }
        }
        for (int i = 0;; i = 90)
        {
          AppBrandVideoView.b(paramAnonymousString1, i);
          ad.i("MicroMsg.Video.AppBrandVideoView", "onGetVideoSize adjust direction from AUTO to %s", new Object[] { Integer.valueOf(AppBrandVideoView.F(AppBrandVideoView.this)) });
          if (AppBrandVideoView.d(AppBrandVideoView.this) == null) {
            break label228;
          }
          paramAnonymousString1 = AppBrandVideoView.d(AppBrandVideoView.this);
          i = AppBrandVideoView.this.getDuration();
          try
          {
            ad.i("MicroMsg.Video.JsApiVideoCallback", "onVideoLoadedMetaData, width:%d, height:%d, duration:%d", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), Integer.valueOf(i) });
            paramAnonymousString2 = paramAnonymousString1.boi();
            paramAnonymousString2.put("width", paramAnonymousInt1);
            paramAnonymousString2.put("height", paramAnonymousInt2);
            paramAnonymousString2.put("duration", i * 1.0D / 1000.0D);
            paramAnonymousString1.a(new b.f((byte)0), paramAnonymousString2);
            AppMethodBeat.o(205898);
            return;
          }
          catch (JSONException paramAnonymousString1)
          {
            label205:
            ad.e("MicroMsg.Video.JsApiVideoCallback", "onVideoLoadedMetaData e=%s", new Object[] { paramAnonymousString1 });
          }
        }
        label228:
        AppMethodBeat.o(205898);
      }
      
      public final void dq(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(205896);
        ad.i("MicroMsg.Video.AppBrandVideoView", "onPrepared");
        AppBrandVideoView.a(AppBrandVideoView.this, 0);
        AppBrandVideoView.t(AppBrandVideoView.this);
        AppBrandVideoView.u(AppBrandVideoView.this);
        if (AppBrandVideoView.v(AppBrandVideoView.this)) {
          AppBrandVideoView.this.start();
        }
        AppBrandVideoView.w(AppBrandVideoView.this).boJ();
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
          AppBrandVideoView.d(AppBrandVideoView.this);
        }
        AppMethodBeat.o(205896);
      }
      
      public final void dr(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(205897);
        ad.i("MicroMsg.Video.AppBrandVideoView", "onVideoEnded");
        AppBrandVideoView.x(AppBrandVideoView.this);
        AppBrandVideoView.m(AppBrandVideoView.this).setVisibility(8);
        AppBrandVideoView.h(AppBrandVideoView.this).setIsPlay(false);
        if ((AppBrandVideoView.h(AppBrandVideoView.this).bni()) && (AppBrandVideoView.h(AppBrandVideoView.this).bnl())) {
          AppBrandVideoView.h(AppBrandVideoView.this).hide();
        }
        if (AppBrandVideoView.y(AppBrandVideoView.this).getVisibility() == 0) {
          AppBrandVideoView.y(AppBrandVideoView.this).setVisibility(8);
        }
        if ((AppBrandVideoView.z(AppBrandVideoView.this)) || (!AppBrandVideoView.A(AppBrandVideoView.this)))
        {
          AppBrandVideoView.B(AppBrandVideoView.this).setVisibility(8);
          AppBrandVideoView.g(AppBrandVideoView.this).setVisibility(8);
        }
        for (;;)
        {
          if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
            paramAnonymousString1 = AppBrandVideoView.d(AppBrandVideoView.this);
          }
          try
          {
            paramAnonymousString1.a(new b.c((byte)0), paramAnonymousString1.boi());
            paramAnonymousString1.boj();
            if (AppBrandVideoView.E(AppBrandVideoView.this)) {
              AppBrandVideoView.this.d(0.0D, true);
            }
            AppMethodBeat.o(205897);
            return;
            if (AppBrandVideoView.C(AppBrandVideoView.this) <= 0) {
              AppBrandVideoView.D(AppBrandVideoView.this).setText(AppBrandVideoView.ts(AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec()));
            }
            AppBrandVideoView.B(AppBrandVideoView.this).setVisibility(0);
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
      
      public final void ds(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(205899);
        ad.i("MicroMsg.Video.AppBrandVideoView", "onVideoPause");
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
          paramAnonymousString1 = AppBrandVideoView.d(AppBrandVideoView.this);
        }
        try
        {
          paramAnonymousString1.a(new b.g((byte)0), paramAnonymousString1.boi());
          paramAnonymousString1.boj();
          AppMethodBeat.o(205899);
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
      
      public final void dt(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(205900);
        ad.i("MicroMsg.Video.AppBrandVideoView", "onVideoPlay, isLive:%b", new Object[] { Boolean.valueOf(AppBrandVideoView.z(AppBrandVideoView.this)) });
        if ((AppBrandVideoView.C(AppBrandVideoView.this) <= 0) && (!AppBrandVideoView.z(AppBrandVideoView.this))) {
          AppBrandVideoView.D(AppBrandVideoView.this).setText(AppBrandVideoView.ts(AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec()));
        }
        AppBrandVideoView.a(AppBrandVideoView.this, AppBrandVideoView.z(AppBrandVideoView.this));
        if (AppBrandVideoView.f(AppBrandVideoView.this)) {
          AppBrandVideoView.G(AppBrandVideoView.this);
        }
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
          paramAnonymousString1 = AppBrandVideoView.d(AppBrandVideoView.this);
        }
        try
        {
          paramAnonymousString1.lpO = 0;
          paramAnonymousString2 = paramAnonymousString1.boi();
          paramAnonymousString2.put("timeStamp", System.currentTimeMillis());
          paramAnonymousString1.a(new b.h((byte)0), paramAnonymousString2);
          if (paramAnonymousString1.lpN == null) {
            paramAnonymousString1.lpN = new av(new b.1(paramAnonymousString1), true);
          }
          paramAnonymousString1.lpN.az(250L, 250L);
        }
        catch (JSONException paramAnonymousString1)
        {
          for (;;)
          {
            ad.e("MicroMsg.Video.JsApiVideoCallback", "OnVideoPlay e=%s", new Object[] { paramAnonymousString1 });
          }
        }
        if ((AppBrandVideoView.H(AppBrandVideoView.this) != null) && ("wxfe02ecfe70800f46".equalsIgnoreCase(AppBrandVideoView.H(AppBrandVideoView.this).getAppId())))
        {
          ad.i("MicroMsg.Video.AppBrandVideoView", "onVideoPlay, send play event");
          com.tencent.mm.sdk.b.a.IbL.l(new com.tencent.mm.plugin.appbrand.jsapi.video.c.a());
        }
        AppMethodBeat.o(205900);
      }
      
      public final void du(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(205901);
        ad.i("MicroMsg.Video.AppBrandVideoView", "onVideoWaiting");
        if (AppBrandVideoView.d(AppBrandVideoView.this) != null) {
          paramAnonymousString1 = AppBrandVideoView.d(AppBrandVideoView.this);
        }
        try
        {
          paramAnonymousString2 = paramAnonymousString1.boi();
          paramAnonymousString2.put("timeStamp", System.currentTimeMillis());
          paramAnonymousString1.a(new b.m((byte)0), paramAnonymousString2);
          AppBrandVideoView.b(AppBrandVideoView.this, true);
          AppBrandVideoView.j(AppBrandVideoView.this);
          AppMethodBeat.o(205901);
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
      
      public final void dv(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(205902);
        AppBrandVideoView.b(AppBrandVideoView.this, false);
        AppBrandVideoView.n(AppBrandVideoView.this);
        AppMethodBeat.o(205902);
      }
    });
    AppMethodBeat.o(137782);
  }
  
  private void bmO()
  {
    AppMethodBeat.i(137786);
    this.lkH = ((DanmuView)findViewById(2131298920));
    this.lkH.setDanmuViewCallBack(new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.c()
    {
      public final int aGL()
      {
        AppMethodBeat.i(205903);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getCurrPosSec();
        AppMethodBeat.o(205903);
        return i;
      }
    });
    this.lkH.bog();
    this.lkH.setMaxRunningPerRow(5);
    this.lkH.setPickItemInterval(200);
    this.lkH.hide();
    if ((this.lkF != null) && (((View)this.lkF).getHeight() > 0))
    {
      float f = this.lkH.getYOffset();
      int i = (int)(((View)this.lkF).getHeight() * f);
      f = com.tencent.mm.plugin.appbrand.jsapi.video.danmu.b.dx(getContext());
      this.lkH.setMaxRow((int)(i / f));
    }
    AppMethodBeat.o(137786);
  }
  
  private boolean bmP()
  {
    AppMethodBeat.i(137792);
    if ((this.lli) && (!this.lkF.bhH()) && (!bmR()))
    {
      AppMethodBeat.o(137792);
      return true;
    }
    AppMethodBeat.o(137792);
    return false;
  }
  
  private boolean bmQ()
  {
    AppMethodBeat.i(137793);
    if ((!bmR()) && (((!bmN()) && (this.lkZ)) || ((bmN()) && (this.lla))))
    {
      AppMethodBeat.o(137793);
      return true;
    }
    AppMethodBeat.o(137793);
    return false;
  }
  
  private boolean bmR()
  {
    AppMethodBeat.i(137794);
    if (this.lkJ.getVisibility() == 0)
    {
      AppMethodBeat.o(137794);
      return true;
    }
    AppMethodBeat.o(137794);
    return false;
  }
  
  private void bmS()
  {
    AppMethodBeat.i(205911);
    if (this.llt != null) {
      this.llt.stopTimer();
    }
    AppMethodBeat.o(205911);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(137737);
    LayoutInflater.from(paramContext).inflate(2131493072, this);
    setBackgroundColor(-16777216);
    this.lkE = ((RelativeLayout)findViewById(2131306410));
    this.lkG = ((TextView)findViewById(2131303515));
    this.lkJ = findViewById(2131298814);
    this.lkK = findViewById(2131298828);
    this.lkL = ((TextView)findViewById(2131298832));
    this.lkM = ((LinearLayout)findViewById(2131296505));
    this.lkN = ((AppBrandDotPercentIndicator)findViewById(2131296506));
    this.lkO = ((TextView)findViewById(2131296502));
    this.lkP = ((ImageView)findViewById(2131296504));
    this.lkQ = ((ImageView)findViewById(2131298813));
    this.lkR = ((ImageView)findViewById(2131303297));
    this.lkS = ((ImageView)findViewById(2131303296));
    this.lkT = ((FrameLayout)findViewById(2131303298));
    this.lkN.setDotsNum(8);
    ((ImageView)findViewById(2131298827)).setOnClickListener(new AppBrandVideoView.1(this));
    bmK();
    bmM();
    AppMethodBeat.o(137737);
  }
  
  private void setCover(final String paramString)
  {
    AppMethodBeat.i(137761);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(137761);
      return;
    }
    if (!bt.isNullOrNil(this.llg))
    {
      ad.i("MicroMsg.Video.AppBrandVideoView", "setCover mCoverUrl not null");
      AppMethodBeat.o(137761);
      return;
    }
    m.bBp().postToWorker(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(205880);
        aq.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(205879);
            if ((this.val$bitmap != null) && (!this.val$bitmap.isRecycled())) {
              AppBrandVideoView.a(AppBrandVideoView.this).setImageBitmap(this.val$bitmap);
            }
            AppMethodBeat.o(205879);
          }
        });
        AppMethodBeat.o(205880);
      }
    });
    AppMethodBeat.o(137761);
  }
  
  private static String tq(int paramInt)
  {
    AppMethodBeat.i(137788);
    String str = tr(paramInt / 60) + ":" + tr(paramInt % 60);
    AppMethodBeat.o(137788);
    return str;
  }
  
  private static String tr(int paramInt)
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
    this.lkI = parama;
    if (((this.lkI instanceof View)) && (this.lkI != null))
    {
      parama = (View)this.lkI;
      if (parama.getId() != -1) {
        parama.setId(2131296841);
      }
    }
    this.lkI.hide();
    this.lkI.setFullScreenBtnOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(205904);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (!AppBrandVideoView.this.bmN()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView = AppBrandVideoView.this;
          paramAnonymousView.p(bool, AppBrandVideoView.F(paramAnonymousView));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(205904);
          return;
        }
      }
    });
    this.lkI.setIplaySeekCallback(new e.d()
    {
      public final void aqD()
      {
        AppMethodBeat.i(205905);
        ad.i("MicroMsg.Video.AppBrandVideoView", "onSeekPre");
        AppMethodBeat.o(205905);
      }
      
      public final void nM(int paramAnonymousInt)
      {
        AppMethodBeat.i(205906);
        AppBrandVideoView.this.d(paramAnonymousInt, false);
        AppMethodBeat.o(205906);
      }
    });
    this.lkI.setOnPlayButtonClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(205907);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (AppBrandVideoView.b(AppBrandVideoView.this).isPlaying()) {
          AppBrandVideoView.this.pause();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(205907);
          return;
          AppBrandVideoView.this.start();
        }
      }
    });
    this.lkI.setStatePorter(new e.i()
    {
      public final int bmT()
      {
        AppMethodBeat.i(205873);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getCacheTimeSec();
        AppMethodBeat.o(205873);
        return i;
      }
      
      public final int bmU()
      {
        AppMethodBeat.i(205874);
        int i = AppBrandVideoView.b(AppBrandVideoView.this).getVideoDurationSec();
        AppMethodBeat.o(205874);
        return i;
      }
    });
    this.lkI.setMuteBtnOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(205875);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = AppBrandVideoView.this;
        if (!AppBrandVideoView.I(AppBrandVideoView.this)) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setMute(bool);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(205875);
          return;
        }
      }
    });
    this.lkI.setExitFullScreenBtnOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(137702);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        AppBrandVideoView.this.p(false, AppBrandVideoView.F(AppBrandVideoView.this));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/video/AppBrandVideoView$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(137702);
      }
    });
    this.lkI.a(new e.f()
    {
      public final void onVisibilityChanged(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(205876);
        AppBrandVideoView.G(AppBrandVideoView.this);
        AppMethodBeat.o(205876);
      }
    });
    this.lkI.setOnUpdateProgressLenListener(new e.e()
    {
      public final void onProgressChanged(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(205877);
        if (paramAnonymousInt2 <= 0)
        {
          AppMethodBeat.o(205877);
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
          AppMethodBeat.o(205877);
          return;
        }
      }
    });
    AppMethodBeat.o(137787);
  }
  
  public final boolean bmN()
  {
    AppMethodBeat.i(137785);
    if (this.llc == null)
    {
      ad.w("MicroMsg.Video.AppBrandVideoView", "isInFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(137785);
      return false;
    }
    boolean bool = this.llc.isFullScreen();
    AppMethodBeat.o(137785);
    return bool;
  }
  
  public final void clean()
  {
    AppMethodBeat.i(137756);
    ad.i("MicroMsg.Video.AppBrandVideoView", "clean");
    stop();
    this.lkF.onUIDestroy();
    if (this.lkH != null) {
      this.lkH.clear();
    }
    this.lkI.onDestroy();
    bmS();
    AppMethodBeat.o(137756);
  }
  
  public final void d(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(137758);
    int i = this.lkF.getCurrPosSec();
    ad.i("MicroMsg.Video.AppBrandVideoView", "seek to position=%s current=%d isLive=%b", new Object[] { Double.valueOf(paramDouble), Integer.valueOf(i), Boolean.valueOf(this.lld) });
    if (bhH())
    {
      AppMethodBeat.o(137758);
      return;
    }
    this.lkJ.setVisibility(8);
    if (paramBoolean) {
      this.lkF.c(paramDouble, paramBoolean);
    }
    for (;;)
    {
      if ((this.lkH != null) && (i > paramDouble))
      {
        DanmuView localDanmuView = this.lkH;
        i = (int)paramDouble;
        ad.i("MicroMsg.DanmuView", "seekToPlayTime playTime=%d", new Object[] { Integer.valueOf(i) });
        localDanmuView.boc();
        localDanmuView.clearItems();
        localDanmuView.prepare();
        com.tencent.e.h.LTJ.aR(new DanmuView.5(localDanmuView, i));
      }
      AppMethodBeat.o(137758);
      return;
      this.lkF.o(paramDouble);
    }
  }
  
  public final boolean dp(String arg1, String paramString2)
  {
    AppMethodBeat.i(137779);
    if (this.lkH == null)
    {
      ad.w("MicroMsg.Video.AppBrandVideoView", " addDanmaku mDanmakuView null");
      bmO();
    }
    int j = com.tencent.mm.plugin.appbrand.z.g.UW(paramString2);
    int i = j;
    if (j == 0) {
      i = -1;
    }
    paramString2 = new com.tencent.mm.plugin.appbrand.jsapi.video.danmu.a(getContext(), new SpannableString(???), i, this.lkF.getCurrPosSec());
    DanmuView localDanmuView = this.lkH;
    synchronized (localDanmuView.lpA)
    {
      localDanmuView.lpA.offerFirst(paramString2);
      com.tencent.e.h.LTJ.f(new DanmuView.3(localDanmuView, paramString2), "DanmuView-addItemToWaitingHead");
      AppMethodBeat.o(137779);
      return true;
    }
  }
  
  public final void e(String paramString, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(137757);
    String str = paramString;
    if (this.lkW != null)
    {
      str = paramString;
      if (this.lkW.Fg() != null)
      {
        str = paramString;
        if (this.lkW.Fg().Lw(paramString))
        {
          paramString = this.lkW.Fg().Mj(paramString);
          if (paramString != null) {
            break label124;
          }
        }
      }
    }
    label124:
    for (paramString = null;; paramString = "file://" + q.B(paramString.fOK()))
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
    this.lld = paramBoolean;
    this.lln = str;
    this.lkF.setVideoSource(this.llm);
    this.lkF.c(paramBoolean, str, paramInt);
    if (this.llf > 0.0D) {
      this.lkF.c(this.llf, this.csg);
    }
    Object localObject;
    if ((this.llm == 1) && (com.tencent.luggage.a.e.K(h.class) != null))
    {
      localObject = ((h)com.tencent.luggage.a.e.K(h.class)).QF(this.lln);
      if (localObject != null)
      {
        ad.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath localVideoPath:%s", new Object[] { localObject });
        paramString = this.lln;
        ad.i("MicroMsg.Video.AppBrandVideoView", "leonlad setPreLoadVideoPath %s", new Object[] { localObject });
        if ((!this.lkF.isPlaying()) && (this.lln.equalsIgnoreCase(paramString)))
        {
          this.lln = paramString;
          this.lkF.c(this.lld, (String)localObject, 0);
          if (!this.csg) {
            break label452;
          }
          ad.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay true");
          start();
        }
      }
    }
    for (;;)
    {
      if (this.lkY != null) {
        localObject = this.lkY;
      }
      try
      {
        JSONObject localJSONObject = ((com.tencent.mm.plugin.appbrand.jsapi.video.c.b)localObject).boi();
        localJSONObject.put("timeStamp", System.currentTimeMillis());
        localJSONObject.put("url", paramString);
        ((com.tencent.mm.plugin.appbrand.jsapi.video.c.b)localObject).a(new b.a((byte)0), localJSONObject);
        if (this.csg)
        {
          ad.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay true");
          start();
          setCover(str);
          AppMethodBeat.o(137757);
          return;
          label452:
          ad.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay false");
          bmJ();
        }
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          ad.e("MicroMsg.Video.JsApiVideoCallback", "onVideoCanPlay e=%s", new Object[] { paramString });
          continue;
          ad.i("MicroMsg.Video.AppBrandVideoView", "setVideoPath autoPlay false");
          bmJ();
        }
      }
    }
  }
  
  public final void gP(boolean paramBoolean)
  {
    AppMethodBeat.i(137765);
    ad.i("MicroMsg.Video.AppBrandVideoView", "enableProgressGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lli = paramBoolean;
    AppMethodBeat.o(137765);
  }
  
  public final void gQ(boolean paramBoolean)
  {
    AppMethodBeat.i(137790);
    if (this.lkY == null)
    {
      AppMethodBeat.o(137790);
      return;
    }
    this.lkY.c(this.lkV, paramBoolean, this.kOR);
    AppMethodBeat.o(137790);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(137773);
    if (this.lkF != null)
    {
      int i = this.lkF.getCacheTimeSec();
      AppMethodBeat.o(137773);
      return i;
    }
    AppMethodBeat.o(137773);
    return 0;
  }
  
  public com.tencent.mm.plugin.appbrand.jsapi.video.c.b getCallback()
  {
    return this.lkY;
  }
  
  public String getCookieData()
  {
    return this.lkU;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(137772);
    int i = this.lkF.getCurrPosMs();
    AppMethodBeat.o(137772);
    return i;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(137771);
    int i = this.lkF.getCurrPosSec();
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
    int i = this.lkF.getVideoDurationSec();
    AppMethodBeat.o(137748);
    return i;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(137783);
    if (this.llp) {
      bool = true;
    }
    while (bool)
    {
      if (this.llb != null) {
        this.llb.w(paramMotionEvent);
      }
      AppMethodBeat.o(137783);
      return true;
      bool = bmP();
      if (!bmQ()) {
        bool = false;
      }
    }
    if ((paramMotionEvent.getAction() == 0) && (this.lkX) && (this.lkJ.getVisibility() != 0))
    {
      this.lkI.bng();
      if (this.llo) {
        bmL();
      }
    }
    if (this.llh)
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
    if (this.llq)
    {
      ad.i("MicroMsg.Video.AppBrandVideoView", "onUIResume, should skip ui resume");
      this.llq = false;
      AppMethodBeat.o(137753);
      return;
    }
    this.lkF.onUIResume();
    AppMethodBeat.o(137753);
  }
  
  public final void p(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(137784);
    ad.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen toFullScreen:%b direction:%d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    if (this.llc == null)
    {
      ad.w("MicroMsg.Video.AppBrandVideoView", "operateFullScreen mFullScreenDelegate null");
      AppMethodBeat.o(137784);
      return;
    }
    if (paramBoolean == bmN())
    {
      ad.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen current same");
      AppMethodBeat.o(137784);
      return;
    }
    if (paramInt == -1) {
      if (this.acQ == -1)
      {
        paramInt = 90;
        ad.i("MicroMsg.Video.AppBrandVideoView", "operateFullScreen target direction:%d", new Object[] { Integer.valueOf(paramInt) });
      }
    }
    for (;;)
    {
      if (paramBoolean)
      {
        this.kOR = paramInt;
        this.llc.te(paramInt);
        this.lkI.bnj();
        gQ(true);
        AppMethodBeat.o(137784);
        return;
        paramInt = this.acQ;
        break;
      }
      this.llc.bkF();
      this.lkI.bkF();
      AppMethodBeat.o(137784);
      return;
    }
  }
  
  public final void pause()
  {
    AppMethodBeat.i(137751);
    ad.i("MicroMsg.Video.AppBrandVideoView", "pause");
    if (!this.lls)
    {
      ad.i("MicroMsg.Video.AppBrandVideoView", "pause, video not prepared");
      this.cuF = false;
      AppMethodBeat.o(137751);
      return;
    }
    if (!this.lkF.isPlaying())
    {
      ad.i("MicroMsg.Video.AppBrandVideoView", "pause, video not playing");
      AppMethodBeat.o(137751);
      return;
    }
    this.lkF.pause();
    if ((this.lkH != null) && (this.lkI.bnf())) {
      this.lkH.pause();
    }
    AppMethodBeat.o(137751);
  }
  
  public void setAutoPauseIfNavigate(boolean paramBoolean)
  {
    this.crS = paramBoolean;
  }
  
  public void setAutoPauseIfOpenNative(boolean paramBoolean)
  {
    this.crT = paramBoolean;
  }
  
  public void setAutoPlay(boolean paramBoolean)
  {
    AppMethodBeat.i(137745);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setAutoPlay %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.csg = paramBoolean;
    AppMethodBeat.o(137745);
  }
  
  public void setCallback(com.tencent.mm.plugin.appbrand.jsapi.video.c.b paramb)
  {
    this.lkY = paramb;
  }
  
  public void setComponent(com.tencent.mm.plugin.appbrand.jsapi.c paramc)
  {
    AppMethodBeat.i(137738);
    this.lkW = paramc;
    this.mAppId = paramc.getAppId();
    AppMethodBeat.o(137738);
  }
  
  public void setConsumeTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(137739);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setConsumeTouchEvent game=%s", new Object[] { Boolean.valueOf(paramBoolean) });
    this.llh = paramBoolean;
    AppMethodBeat.o(137739);
  }
  
  public void setCookieData(String paramString)
  {
    this.lkU = paramString;
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
    this.llg = paramString;
    com.tencent.mm.modelappbrand.a.b.aDV().a(this.lkQ, paramString, null, null);
    AppMethodBeat.o(137760);
  }
  
  public void setDanmakuEnable(boolean paramBoolean)
  {
    AppMethodBeat.i(137767);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setDanmakuEnable %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lkI.setDanmakuBtnOpen(paramBoolean);
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
      if (this.lkH == null)
      {
        ad.w("MicroMsg.Video.AppBrandVideoView", "setDanmakuItemList mDanmakuView null");
        bmO();
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
      int k = com.tencent.mm.plugin.appbrand.z.g.UW(((JSONObject)localObject).optString("color", ""));
      j = k;
      if (k == 0) {
        j = -1;
      }
    }
    label203:
    paramJSONArray = this.lkH;
    paramJSONArray.boc();
    paramJSONArray.clearItems();
    paramJSONArray.lpB.clear();
    paramJSONArray.prepare();
    if (localArrayList.isEmpty())
    {
      paramJSONArray.bod();
      AppMethodBeat.o(137778);
      return;
    }
    com.tencent.e.h.LTJ.aU(new DanmuView.4(paramJSONArray, localArrayList));
    paramJSONArray.bod();
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
    this.lkL.setText(tq(paramInt));
    this.atW = paramInt;
    AppMethodBeat.o(137747);
  }
  
  public void setEnablePlayGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(137744);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setEnablePlayGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.llp = paramBoolean;
    AppMethodBeat.o(137744);
  }
  
  public void setFullScreenDelegate(a parama)
  {
    this.llc = parama;
  }
  
  public void setFullScreenDirection(int paramInt)
  {
    AppMethodBeat.i(137774);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setFullScreenDirection %d", new Object[] { Integer.valueOf(paramInt) });
    this.acQ = paramInt;
    AppMethodBeat.o(137774);
  }
  
  public void setFullScreenState(boolean paramBoolean)
  {
    AppMethodBeat.i(205910);
    if (paramBoolean)
    {
      this.lkI.bnj();
      AppMethodBeat.o(205910);
      return;
    }
    this.lkI.bkF();
    AppMethodBeat.o(205910);
  }
  
  public void setInitialTime(double paramDouble)
  {
    AppMethodBeat.i(137777);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setInitialTime %s", new Object[] { Double.valueOf(paramDouble) });
    this.llf = paramDouble;
    AppMethodBeat.o(137777);
  }
  
  public void setIsEnableBottomProgressBar(boolean paramBoolean)
  {
    this.llr = paramBoolean;
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(137759);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setIsShowBasicControls %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lkX = paramBoolean;
    if (this.lkI != null)
    {
      if (this.lkX)
      {
        this.lkI.bnh();
        AppMethodBeat.o(137759);
        return;
      }
      this.lkI.hide();
    }
    AppMethodBeat.o(137759);
  }
  
  public void setLoop(boolean paramBoolean)
  {
    AppMethodBeat.i(137749);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setLoop %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lle = paramBoolean;
    AppMethodBeat.o(137749);
  }
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(137770);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setMute %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.mIsMute = paramBoolean;
    this.lkF.setMute(paramBoolean);
    this.lkI.setMuteBtnState(paramBoolean);
    AppMethodBeat.o(137770);
  }
  
  public void setObjectFit(String paramString)
  {
    AppMethodBeat.i(137769);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setObjectFit %s", new Object[] { paramString });
    if ("fill".equalsIgnoreCase(paramString))
    {
      this.lkF.setScaleType(e.h.llN);
      this.lkQ.setScaleType(ImageView.ScaleType.FIT_XY);
      AppMethodBeat.o(137769);
      return;
    }
    if ("cover".equalsIgnoreCase(paramString))
    {
      this.lkF.setScaleType(e.h.llP);
      this.lkQ.setScaleType(ImageView.ScaleType.CENTER_CROP);
      AppMethodBeat.o(137769);
      return;
    }
    this.lkF.setScaleType(e.h.llO);
    this.lkQ.setScaleType(ImageView.ScaleType.FIT_CENTER);
    AppMethodBeat.o(137769);
  }
  
  public void setPageGesture(boolean paramBoolean)
  {
    AppMethodBeat.i(137775);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setPageGesture %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lkZ = paramBoolean;
    AppMethodBeat.o(137775);
  }
  
  public void setPageGestureInFullscreen(boolean paramBoolean)
  {
    AppMethodBeat.i(137776);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setPageGestureInFullscreen %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lla = paramBoolean;
    AppMethodBeat.o(137776);
  }
  
  public void setPlayBtnPosition(String paramString)
  {
    AppMethodBeat.i(137743);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setPlayBtnPosition %s", new Object[] { paramString });
    if ((!bt.isNullOrNil(paramString)) && (paramString.equalsIgnoreCase("center")))
    {
      this.lkI.setPlayBtnInCenterPosition(true);
      AppMethodBeat.o(137743);
      return;
    }
    this.lkI.setPlayBtnInCenterPosition(false);
    AppMethodBeat.o(137743);
  }
  
  public void setShowCenterPlayBtn(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(137766);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setShowCenterPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lll = paramBoolean;
    View localView = this.lkJ;
    if (paramBoolean)
    {
      i = 0;
      localView.setVisibility(i);
      localView = this.lkK;
      if (!paramBoolean) {
        break label104;
      }
    }
    label104:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      if ((this.lll) && (this.lkI != null)) {
        this.lkI.hide();
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
    e.a locala = this.lkI;
    if ((paramBoolean) && (!bhH())) {}
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
      if (this.lkH == null) {
        bmO();
      }
      this.lkI.setDanmakuBtnOnClickListener(new e.g()
      {
        public final void gR(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(205881);
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
              JSONObject localJSONObject = localb.boi();
              localJSONObject.put("showDanmu", paramAnonymousBoolean);
              localJSONObject.put("videoPlayerId", i);
              localb.a(new b.b((byte)0), localJSONObject);
              AppMethodBeat.o(205881);
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
          AppMethodBeat.o(205881);
        }
      });
    }
    this.lkI.setShowDanmakuBtn(paramBoolean);
    AppMethodBeat.o(137768);
  }
  
  public void setShowFullScreenBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(137763);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setShowFullScreenBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lkI.setShowFullScreenBtn(paramBoolean);
    AppMethodBeat.o(137763);
  }
  
  public void setShowMuteBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(137740);
    ad.i("MicroMsg.Video.AppBrandVideoView", "showMuteBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lkI.setShowMuteBtn(paramBoolean);
    AppMethodBeat.o(137740);
  }
  
  public void setShowPlayBtn(boolean paramBoolean)
  {
    AppMethodBeat.i(137764);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setShowPlayBtn %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.lkI.setShowPlayBtn(paramBoolean);
    AppMethodBeat.o(137764);
  }
  
  public void setShowProgress(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(137762);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setShowProgress %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.llj = paramBoolean;
    e.a locala = this.lkI;
    if (((paramBoolean) || (this.llk)) && (!bhH())) {}
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
    AppMethodBeat.i(205909);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setShowProgressInControlMode %b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.llk = paramBoolean;
    e.a locala = this.lkI;
    if (((this.llj) || (paramBoolean)) && (!bhH())) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      locala.setShowProgress(paramBoolean);
      AppMethodBeat.o(205909);
      return;
    }
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(137741);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setTitle %s", new Object[] { paramString });
    this.lkI.setTitle(paramString);
    AppMethodBeat.o(137741);
  }
  
  public void setVideoPlayerId(int paramInt)
  {
    this.lkV = paramInt;
  }
  
  public void setVideoSource(int paramInt)
  {
    AppMethodBeat.i(137746);
    ad.i("MicroMsg.Video.AppBrandVideoView", "setVideoSource %d", new Object[] { Integer.valueOf(paramInt) });
    this.llm = paramInt;
    AppMethodBeat.o(137746);
  }
  
  public final void start()
  {
    AppMethodBeat.i(137750);
    ad.i("MicroMsg.Video.AppBrandVideoView", "start");
    if (this.lkF.isPlaying())
    {
      ad.i("MicroMsg.Video.AppBrandVideoView", "start, video is playing");
      AppMethodBeat.o(137750);
      return;
    }
    if (!this.lls)
    {
      ad.i("MicroMsg.Video.AppBrandVideoView", "start, video not prepared");
      this.cuF = true;
    }
    if (this.lkX) {
      this.lkI.bnm();
    }
    this.lkJ.setVisibility(8);
    this.lkF.start();
    if ((this.lkH != null) && (this.lkI.bnf())) {
      this.lkH.show();
    }
    if (com.tencent.luggage.a.e.K(h.class) != null) {
      ((h)com.tencent.luggage.a.e.K(h.class)).report(this.lln);
    }
    AppMethodBeat.o(137750);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(137752);
    ad.i("MicroMsg.Video.AppBrandVideoView", "stop");
    if (!this.lls)
    {
      ad.i("MicroMsg.Video.AppBrandVideoView", "stop, video not prepared");
      this.cuF = false;
      AppMethodBeat.o(137752);
      return;
    }
    if (!this.lkF.isPlaying())
    {
      ad.i("MicroMsg.Video.AppBrandVideoView", "stop, video not playing");
      AppMethodBeat.o(137752);
      return;
    }
    this.lkF.stop();
    this.lkI.bnn();
    if (this.lkH != null) {
      this.lkH.hide();
    }
    AppMethodBeat.o(137752);
  }
  
  public final void tp(int paramInt)
  {
    AppMethodBeat.i(137754);
    ad.i("MicroMsg.Video.AppBrandVideoView", "onUIPause, type:%d", new Object[] { Integer.valueOf(paramInt) });
    if (((paramInt == 2) && (!this.crT)) || ((paramInt == 1) && (!this.crS)))
    {
      ad.i("MicroMsg.Video.AppBrandVideoView", "onUIPause, should skip ui pause");
      this.llq = true;
      AppMethodBeat.o(137754);
      return;
    }
    this.lkF.onUIPause();
    AppMethodBeat.o(137754);
  }
  
  public static abstract interface a
  {
    public abstract void bkF();
    
    public abstract boolean isFullScreen();
    
    public abstract void te(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView
 * JD-Core Version:    0.7.0.1
 */