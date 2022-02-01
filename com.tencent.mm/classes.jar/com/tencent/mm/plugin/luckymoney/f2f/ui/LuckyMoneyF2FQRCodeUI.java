package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.g.a;
import com.tencent.mm.am.g.c;
import com.tencent.mm.am.p;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cl;
import com.tencent.mm.model.cl.a;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.luckymoney.f2f.a.1;
import com.tencent.mm.plugin.luckymoney.f2f.a.2;
import com.tencent.mm.plugin.luckymoney.f2f.a.e;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil;
import com.tencent.mm.sdk.platformtools.ScreenShotUtil.ScreenShotCallback;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.base.HorizontalListViewV2;
import com.tencent.mm.ui.base.HorizontalListViewV2.d;
import com.tencent.mm.ui.base.HorizontalListViewV2.d.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.wallet_core.ui.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

public class LuckyMoneyF2FQRCodeUI
  extends LuckyMoneyBaseUI
  implements ScreenShotUtil.ScreenShotCallback
{
  private String CAf;
  private Button Knt;
  private String KoF;
  private String KoG;
  private int KoH;
  private View KoS;
  private View KoT;
  private ImageView KoU;
  private TextView KoV;
  private TextView KoW;
  private ImageView KoX;
  private TextView KoY;
  private TextView KoZ;
  private Bitmap KpA;
  private Bitmap KpB;
  private Bitmap KpC;
  private Bitmap KpD;
  private Bitmap KpE;
  private Bitmap KpF;
  private Bitmap KpG;
  private com.tencent.mm.particles.b KpH;
  private com.tencent.mm.particles.b KpI;
  final SensorEventListener KpJ;
  private HorizontalListViewV2 Kpa;
  private List<String> Kpb;
  private Map<String, String> Kpc;
  private Queue<Pair<String, Integer>> Kpd;
  private a Kpe;
  private TextView Kpf;
  private ShuffleView Kpg;
  private ShuffleView.c Kph;
  private List<View> Kpi;
  private ViewGroup Kpj;
  private ViewGroup Kpk;
  private View Kpl;
  private com.tencent.mm.plugin.luckymoney.f2f.a Kpm;
  private long Kpn;
  private String Kpo;
  private ValueAnimator Kpp;
  private float Kpq;
  private float Kpr;
  private float Kps;
  private cl.a Kpt;
  private u.g Kpu;
  private Bitmap Kpv;
  private Bitmap Kpw;
  private Bitmap Kpx;
  private Bitmap Kpy;
  private Bitmap Kpz;
  private Bitmap mBitmap;
  private SensorManager mSensorManager;
  private DisplayMetrics metrics;
  private View nJ;
  private int[] pZy;
  private MTimerHandler qaM;
  private int retCode;
  private f ucS;
  private String wZb;
  private u.i xcv;
  private String ytZ;
  
  public LuckyMoneyF2FQRCodeUI()
  {
    AppMethodBeat.i(65085);
    this.Kpt = new cl.a()
    {
      public final void a(g.a paramAnonymousa)
      {
        AppMethodBeat.i(65061);
        paramAnonymousa = XmlParser.parseXml(w.a(paramAnonymousa.mpN.YFG), "sysmsg", null);
        if (paramAnonymousa != null)
        {
          String str1 = (String)paramAnonymousa.get(".sysmsg.sendId");
          final String str2 = (String)paramAnonymousa.get(".sysmsg.username");
          final String str3 = (String)paramAnonymousa.get(".sysmsg.amount");
          final String str4 = (String)paramAnonymousa.get(".sysmsg.receiveId");
          if (Util.getInt((String)paramAnonymousa.get(".sysmsg.islucky"), 0) > 0) {
            LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, str2);
          }
          if (!Util.isNullOrNil(new String[] { str1, str2, str3 })) {
            LuckyMoneyF2FQRCodeUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(65060);
                Object localObject;
                if (!LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).contains(str4))
                {
                  LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).add(0, str4);
                  if (!ab.IR(str2))
                  {
                    localObject = new j();
                    ((j)localObject).username = str2;
                    com.tencent.mm.modelavatar.q.bFE().b((j)localObject);
                  }
                  LuckyMoneyF2FQRCodeUI.b(LuckyMoneyF2FQRCodeUI.this).put(str4, str2);
                  localObject = LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this);
                  if (((ShuffleView)localObject).Kqf.size() > 0)
                  {
                    if (((ShuffleView)localObject).Kqh.isStarted()) {
                      ((ShuffleView)localObject).Kqh.end();
                    }
                    if (((ShuffleView)localObject).ydD.isStarted()) {
                      ((ShuffleView)localObject).ydD.end();
                    }
                    if (((ShuffleView)localObject).qbs == null) {
                      break label351;
                    }
                    ((ShuffleView)localObject).Kql = ((ShuffleView)localObject).qbs;
                    ((ShuffleView)localObject).Kqf.remove(((ShuffleView)localObject).Kql);
                    if (((ShuffleView)localObject).ATZ != null) {
                      ((ShuffleView)localObject).ATZ.start();
                    }
                    ((ShuffleView)localObject).ZO(((ShuffleView)localObject).Kqn);
                    if (((ShuffleView)localObject).Kqq <= 0) {
                      break label338;
                    }
                    ((ShuffleView)localObject).Kqn = ((ShuffleView)localObject).fWK();
                    ((ShuffleView)localObject).qbs = ((View)((ShuffleView)localObject).Kqf.get(((ShuffleView)localObject).Kqn));
                  }
                }
                for (;;)
                {
                  LuckyMoneyF2FQRCodeUI.d(LuckyMoneyF2FQRCodeUI.this).remove(LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this).getExitView());
                  LuckyMoneyF2FQRCodeUI.e(LuckyMoneyF2FQRCodeUI.this).startTimer(0L, 60000L);
                  LuckyMoneyF2FQRCodeUI.f(LuckyMoneyF2FQRCodeUI.this).add(new Pair(str2, Integer.valueOf(Util.getInt(str3, 0))));
                  AppMethodBeat.o(65060);
                  return;
                  label338:
                  ((ShuffleView)localObject).qbs = null;
                  ((ShuffleView)localObject).Kqn = 0;
                  continue;
                  label351:
                  ((ShuffleView)localObject).ZM(((ShuffleView)localObject).fWK());
                  ((ShuffleView)localObject).Kql = ((ShuffleView)localObject).qbs;
                  ((ShuffleView)localObject).Kqh.addListener(new ShuffleView.5((ShuffleView)localObject));
                }
              }
            });
          }
        }
        AppMethodBeat.o(65061);
      }
      
      public final void a(g.c paramAnonymousc) {}
    };
    this.Kpu = new u.g()
    {
      public final void onCreateMMMenu(s paramAnonymouss)
      {
        AppMethodBeat.i(65073);
        if (Util.isNullOrNil(LuckyMoneyF2FQRCodeUI.g(LuckyMoneyF2FQRCodeUI.this)))
        {
          paramAnonymouss.oh(1, a.i.lucky_money_f2f_clear);
          AppMethodBeat.o(65073);
          return;
        }
        paramAnonymouss.a(1, LuckyMoneyF2FQRCodeUI.this.getString(a.i.lucky_money_f2f_clear), LuckyMoneyF2FQRCodeUI.g(LuckyMoneyF2FQRCodeUI.this), 0);
        AppMethodBeat.o(65073);
      }
    };
    this.xcv = new u.i()
    {
      public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
      {
        AppMethodBeat.i(65074);
        switch (paramAnonymousMenuItem.getItemId())
        {
        }
        for (;;)
        {
          AppMethodBeat.o(65074);
          return;
          if (LuckyMoneyF2FQRCodeUI.h(LuckyMoneyF2FQRCodeUI.this) > 0)
          {
            LuckyMoneyF2FQRCodeUI.i(LuckyMoneyF2FQRCodeUI.this);
            AppMethodBeat.o(65074);
            return;
          }
          com.tencent.mm.ui.base.k.cZ(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.this.getString(a.i.lucky_money_f2f_clear_zero_packet_tips));
        }
      }
    };
    this.KpH = new com.tencent.mm.particles.b()
    {
      public final com.tencent.mm.particles.a.b generateConfetti(Random paramAnonymousRandom)
      {
        AppMethodBeat.i(65075);
        int i = paramAnonymousRandom.nextInt(100);
        if (i < 16)
        {
          if (LuckyMoneyF2FQRCodeUI.j(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, a.e.lucky_money_f2f_firework_ribbon_1, 36));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.j(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65075);
          return paramAnonymousRandom;
        }
        if (i < 33)
        {
          if (LuckyMoneyF2FQRCodeUI.k(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.b(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, a.e.lucky_money_f2f_firework_ribbon_2, 36));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.k(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65075);
          return paramAnonymousRandom;
        }
        if (i < 50)
        {
          if (LuckyMoneyF2FQRCodeUI.l(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, a.e.lucky_money_f2f_firework_ribbon_3, 36));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.l(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65075);
          return paramAnonymousRandom;
        }
        if (i < 70)
        {
          if (LuckyMoneyF2FQRCodeUI.m(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.d(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, a.e.lucky_money_f2f_firework_leaf_top_1, 36));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.m(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65075);
          return paramAnonymousRandom;
        }
        if (i < 90)
        {
          if (LuckyMoneyF2FQRCodeUI.n(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.e(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, a.e.lucky_money_f2f_firework_leaf_top_2, 36));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.n(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65075);
          return paramAnonymousRandom;
        }
        if (LuckyMoneyF2FQRCodeUI.o(LuckyMoneyF2FQRCodeUI.this) == null) {
          LuckyMoneyF2FQRCodeUI.f(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, a.e.lucky_money_f2f_firework_leaf_top_3, 36));
        }
        paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.o(LuckyMoneyF2FQRCodeUI.this));
        AppMethodBeat.o(65075);
        return paramAnonymousRandom;
      }
    };
    this.KpI = new com.tencent.mm.particles.b()
    {
      public final com.tencent.mm.particles.a.b generateConfetti(Random paramAnonymousRandom)
      {
        AppMethodBeat.i(65076);
        int i = paramAnonymousRandom.nextInt(100);
        if (i < 10)
        {
          if (LuckyMoneyF2FQRCodeUI.p(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.g(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, a.e.lucky_money_f2f_firework_ribbon_1, 32));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.p(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65076);
          return paramAnonymousRandom;
        }
        if (i < 20)
        {
          if (LuckyMoneyF2FQRCodeUI.q(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.h(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, a.e.lucky_money_f2f_firework_ribbon_2, 32));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.q(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65076);
          return paramAnonymousRandom;
        }
        if (i < 30)
        {
          if (LuckyMoneyF2FQRCodeUI.r(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.i(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, a.e.lucky_money_f2f_firework_ribbon_3, 32));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.r(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65076);
          return paramAnonymousRandom;
        }
        if (i < 50)
        {
          if (LuckyMoneyF2FQRCodeUI.s(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.j(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, a.e.lucky_money_f2f_firework_leaf_top_1, 32));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.s(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65076);
          return paramAnonymousRandom;
        }
        if (i < 75)
        {
          if (LuckyMoneyF2FQRCodeUI.t(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.k(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, a.e.lucky_money_f2f_firework_leaf_top_2, 32));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.t(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65076);
          return paramAnonymousRandom;
        }
        if (LuckyMoneyF2FQRCodeUI.u(LuckyMoneyF2FQRCodeUI.this) == null) {
          LuckyMoneyF2FQRCodeUI.l(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, a.e.lucky_money_f2f_firework_leaf_top_3, 32));
        }
        paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.u(LuckyMoneyF2FQRCodeUI.this));
        AppMethodBeat.o(65076);
        return paramAnonymousRandom;
      }
    };
    this.KpJ = new SensorEventListener()
    {
      final int KpO;
      float KpP;
      int KpQ;
      ValueAnimator KpR;
      float cxN;
      
      public final void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt)
      {
        AppMethodBeat.i(65072);
        Log.i("LuckyMoneyF2FQRCodeUI", "onAccuracyChanged");
        AppMethodBeat.o(65072);
      }
      
      public final void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
      {
        float f1 = -3.0F;
        AppMethodBeat.i(65071);
        float f2;
        if (paramAnonymousSensorEvent.sensor.getType() == 1)
        {
          if (LuckyMoneyF2FQRCodeUI.h(LuckyMoneyF2FQRCodeUI.this) <= 0)
          {
            AppMethodBeat.o(65071);
            return;
          }
          if (this.KpQ == 0) {
            this.KpQ = (com.tencent.mm.pluginsdk.h.fs(LuckyMoneyF2FQRCodeUI.this) + (int)this.KpP);
          }
          f2 = paramAnonymousSensorEvent.values[1];
          if (Math.abs(f2 - this.cxN) < 0.05D)
          {
            AppMethodBeat.o(65071);
            return;
          }
          this.cxN = f2;
          Log.d("LuckyMoneyF2FQRCodeUI", "[onSensorChanged] y:%s ", new Object[] { Float.valueOf(f2) });
          if (f2 >= -3.0F) {
            break label246;
          }
        }
        for (;;)
        {
          f1 = f1 / 3.0F * this.KpQ + this.KpQ;
          Log.d("LuckyMoneyF2FQRCodeUI", "paddingTop:%s nowPaddingTop:%s", new Object[] { Float.valueOf(f1), Integer.valueOf(LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingTop()) });
          if (this.KpR != null) {
            this.KpR.cancel();
          }
          this.KpR = ValueAnimator.ofFloat(new float[] { LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingTop(), f1 }).setDuration(200L);
          this.KpR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
          {
            public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
            {
              AppMethodBeat.i(65069);
              float f = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue();
              LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).setPadding(LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingLeft(), (int)f, LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingRight(), LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingBottom());
              f /= LuckyMoneyF2FQRCodeUI.7.this.KpQ;
              if (f <= 1.0F)
              {
                LuckyMoneyF2FQRCodeUI.Q(LuckyMoneyF2FQRCodeUI.this).setAlpha(1.0F - f + LuckyMoneyF2FQRCodeUI.P(LuckyMoneyF2FQRCodeUI.this));
                LuckyMoneyF2FQRCodeUI.R(LuckyMoneyF2FQRCodeUI.this).setAlpha(f * LuckyMoneyF2FQRCodeUI.P(LuckyMoneyF2FQRCodeUI.this));
                AppMethodBeat.o(65069);
                return;
              }
              LuckyMoneyF2FQRCodeUI.Q(LuckyMoneyF2FQRCodeUI.this).setAlpha(LuckyMoneyF2FQRCodeUI.P(LuckyMoneyF2FQRCodeUI.this));
              LuckyMoneyF2FQRCodeUI.R(LuckyMoneyF2FQRCodeUI.this).setAlpha(LuckyMoneyF2FQRCodeUI.P(LuckyMoneyF2FQRCodeUI.this));
              AppMethodBeat.o(65069);
            }
          });
          this.KpR.start();
          AppMethodBeat.o(65071);
          return;
          label246:
          if (f2 > 0.0F) {
            f1 = 0.0F;
          } else {
            f1 = f2;
          }
        }
      }
    };
    AppMethodBeat.o(65085);
  }
  
  private void fWF()
  {
    AppMethodBeat.i(65087);
    if (!Util.isNullOrNil(this.ytZ))
    {
      this.mBitmap = com.tencent.mm.bz.a.a.cO(this, this.ytZ);
      this.KoX.setImageBitmap(this.mBitmap);
    }
    if (this.KoH <= 0)
    {
      this.KoX.setPadding(com.tencent.mm.cd.a.fromDPToPix(this, 5), com.tencent.mm.cd.a.fromDPToPix(this, 5), com.tencent.mm.cd.a.fromDPToPix(this, 5), com.tencent.mm.cd.a.fromDPToPix(this, 5));
      this.KoX.setImageResource(a.e.lucky_money_f2f_empty_qrcode);
      this.Kpf.setVisibility(8);
      this.Knt.setVisibility(0);
      this.KoY.setVisibility(4);
      this.KoS.setPadding(this.KoS.getPaddingLeft(), com.tencent.mm.pluginsdk.h.fs(this), this.KoS.getPaddingRight(), this.KoS.getPaddingBottom());
      if (this.Kpb.size() > 0)
      {
        this.KoZ.setText(getString(a.i.lucky_money_f2f_no_remain_tips));
        AppMethodBeat.o(65087);
        return;
      }
      this.KoZ.setText(getString(a.i.lucky_money_f2f_not_prepare_tips));
      AppMethodBeat.o(65087);
      return;
    }
    this.KoX.setPadding(0, 0, 0, 0);
    this.KoY.setText(getString(a.i.lucky_money_f2f_scan_qrcode_tips));
    this.KoY.setVisibility(0);
    this.KoZ.setText(getString(a.i.lucky_money_f2f_scan_qrcode_tips));
    this.Kpf.setText(getString(a.i.lucky_money_f2f_remain_tip, new Object[] { Integer.valueOf(this.KoH) }));
    this.Kpf.setVisibility(0);
    this.Knt.setVisibility(8);
    AppMethodBeat.o(65087);
  }
  
  private void fWG()
  {
    AppMethodBeat.i(65088);
    HashSet localHashSet = new HashSet();
    localHashSet.add("touch_card.m4a");
    localHashSet.add("select_card.m4a");
    int i = 1;
    while (i <= 8)
    {
      localHashSet.add("music" + i + ".m4a");
      i += 1;
    }
    localHashSet.add("packet_received.m4a");
    localHashSet.add("most_lucky.m4a");
    localHashSet.add("whistle.m4a");
    com.tencent.mm.plugin.luckymoney.f2f.a locala = this.Kpm;
    WeakReference localWeakReference = new WeakReference(this);
    com.tencent.mm.kernel.h.baH().postToWorker(new a.1(locala, localHashSet, localWeakReference));
    locala.Koe.setOnLoadCompleteListener(new a.2(locala));
    AppMethodBeat.o(65088);
  }
  
  private void fWH()
  {
    AppMethodBeat.i(65089);
    int i = this.Kpa.getWidth() - this.Kpb.size() * getResources().getDimensionPixelSize(a.d.BigAvatarSize);
    if (i > 0)
    {
      this.Kpa.setPadding(i / 2, 0, i / 2, 0);
      AppMethodBeat.o(65089);
      return;
    }
    this.Kpa.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(65089);
  }
  
  private void fWI()
  {
    AppMethodBeat.i(65090);
    if (this.Kpi.size() != this.KoH)
    {
      Log.i("LuckyMoneyF2FQRCodeUI", "shuffle cards: %d", new Object[] { Integer.valueOf(this.Kpi.size()), Integer.valueOf(this.KoH) });
      this.Kpi.clear();
      int i = 0;
      while (i < this.KoH)
      {
        View localView = LayoutInflater.from(this).inflate(a.g.lucky_money_f2f_packet_card_view, this.Kpg, false);
        ((FrameLayout.LayoutParams)localView.getLayoutParams()).gravity = 81;
        this.Kpi.add(localView);
        i += 1;
      }
      this.Kpg.setAllShuffleCards(this.Kpi);
    }
    AppMethodBeat.o(65090);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.g.lucky_money_f2f_qrcode_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65086);
    super.onCreate(paramBundle);
    this.metrics = getResources().getDisplayMetrics();
    this.Kpb = new ArrayList();
    this.Kpc = new HashMap();
    this.Kpd = new LinkedList();
    this.Kpi = new ArrayList();
    this.pZy = new int[6];
    paramBundle = this.pZy;
    paramBundle[0] += 1;
    this.qaM = new MTimerHandler(new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(65077);
        e locale = new e();
        LuckyMoneyF2FQRCodeUI.this.doSceneProgress(locale, false);
        AppMethodBeat.o(65077);
        return true;
      }
    }, true);
    this.nJ = findViewById(a.f.lucky_money_f2f_recv_header);
    this.KoS = findViewById(a.f.white_block);
    this.KoZ = ((TextView)findViewById(a.f.lucky_money_f2f_qrcode_bottom_tip));
    this.KoY = ((TextView)findViewById(a.f.lucky_money_f2f_qrcode_top_tip));
    this.Kps = this.KoZ.getAlpha();
    this.KoX = ((ImageView)this.nJ.findViewById(a.f.lucky_money_f2f_qrcode));
    this.Kpa = ((HorizontalListViewV2)findViewById(a.f.lucky_money_f2f_recv_avatar_list));
    this.Kpe = new a((byte)0);
    this.Kpa.setAdapter(this.Kpe);
    this.Kpa.setOnItemClickListener(new LuckyMoneyF2FQRCodeUI.13(this));
    this.Kpa.setOnScrollStateChangedListener(new HorizontalListViewV2.d()
    {
      public final void a(HorizontalListViewV2.d.a paramAnonymousa)
      {
        AppMethodBeat.i(65079);
        if ((paramAnonymousa == HorizontalListViewV2.d.a.adPg) && (LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size() >= 5) && (LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size() < LuckyMoneyF2FQRCodeUI.w(LuckyMoneyF2FQRCodeUI.this)) && (LuckyMoneyF2FQRCodeUI.x(LuckyMoneyF2FQRCodeUI.this).getLastVisiblePosition() == LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size() - 1) && (!Util.isNullOrNil(LuckyMoneyF2FQRCodeUI.v(LuckyMoneyF2FQRCodeUI.this))))
        {
          paramAnonymousa = new aq(LuckyMoneyF2FQRCodeUI.v(LuckyMoneyF2FQRCodeUI.this), 5, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size(), null, "v1.0");
          LuckyMoneyF2FQRCodeUI.this.doSceneProgress(paramAnonymousa);
        }
        AppMethodBeat.o(65079);
      }
    });
    this.Knt = ((Button)findViewById(a.f.lucky_money_f2f_prepare_btn));
    this.Knt.setOnClickListener(new LuckyMoneyF2FQRCodeUI.15(this));
    this.Kpf = ((TextView)findViewById(a.f.lucky_money_f2f_remain_text));
    this.KoT = findViewById(a.f.lucky_money_f2f_recv_packet);
    setBackBtn(new LuckyMoneyF2FQRCodeUI.2(this));
    setMMTitle(getString(a.i.lucky_money_f2f_title));
    addIconOptionMenu(0, a.h.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65063);
        LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, new f(LuckyMoneyF2FQRCodeUI.this, 1, false));
        LuckyMoneyF2FQRCodeUI.z(LuckyMoneyF2FQRCodeUI.this).Vtg = LuckyMoneyF2FQRCodeUI.y(LuckyMoneyF2FQRCodeUI.this);
        LuckyMoneyF2FQRCodeUI.z(LuckyMoneyF2FQRCodeUI.this).GAC = LuckyMoneyF2FQRCodeUI.A(LuckyMoneyF2FQRCodeUI.this);
        LuckyMoneyF2FQRCodeUI.z(LuckyMoneyF2FQRCodeUI.this).dDn();
        AppMethodBeat.o(65063);
        return true;
      }
    });
    setActionbarColor(getResources().getColor(a.c.lucky_money_goldstyle_actionbar_bg_color));
    hideActionbarLine();
    this.Kpj = ((ViewGroup)findViewById(a.f.lucky_money_f2f_firework_layer_top));
    this.Kpk = ((ViewGroup)findViewById(a.f.lucky_money_f2f_firework_layer_bottom));
    this.Kpl = findViewById(a.f.lucky_money_f2f_layer_mask);
    this.Kpl.setAlpha(0.0F);
    this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
    this.mSensorManager.registerListener(this.KpJ, this.mSensorManager.getDefaultSensor(1), 3);
    this.Kpm = new com.tencent.mm.plugin.luckymoney.f2f.a();
    this.Kpg = ((ShuffleView)findViewById(a.f.lucky_money_f2f_shuffle_view));
    this.Kph = new ShuffleView.c();
    this.Kph.KqF = 4;
    this.Kph.KqD = 2;
    this.Kph.KqE = 4;
    this.Kph.KqG = 300;
    this.Kph.scaleY = 0.0F;
    this.Kpg.setShuffleSetting(this.Kph);
    ShuffleView.metrics = this.metrics;
    paramBundle = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(300L);
    this.Kpg.setExitAnimator(paramBundle);
    this.Kpg.setExitAnimatorListener(new ShuffleView.a()
    {
      public final void a(ValueAnimator paramAnonymousValueAnimator, View paramAnonymousView)
      {
        AppMethodBeat.i(65064);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f == 0.0F)
        {
          LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, paramAnonymousView.getTranslationX());
          LuckyMoneyF2FQRCodeUI.b(LuckyMoneyF2FQRCodeUI.this, paramAnonymousView.getTranslationY());
          paramAnonymousView.findViewById(a.f.lucky_money_f2f_single_card).setVisibility(0);
        }
        paramAnonymousView.setTranslationX((1.0F - f) * LuckyMoneyF2FQRCodeUI.B(LuckyMoneyF2FQRCodeUI.this));
        paramAnonymousView.setTranslationY((1.0F - f) * LuckyMoneyF2FQRCodeUI.C(LuckyMoneyF2FQRCodeUI.this) - (LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this).getHeight() + LuckyMoneyF2FQRCodeUI.C(LuckyMoneyF2FQRCodeUI.this) * 8.0F) * f);
        paramAnonymousView.setScaleX(0.5F * f + 1.0F);
        paramAnonymousView.setScaleY(0.5F * f + 1.0F);
        paramAnonymousValueAnimator = (Pair)LuckyMoneyF2FQRCodeUI.f(LuckyMoneyF2FQRCodeUI.this).peek();
        if ((paramAnonymousValueAnimator != null) && (!Util.isNullOrNil(LuckyMoneyF2FQRCodeUI.D(LuckyMoneyF2FQRCodeUI.this))) && (LuckyMoneyF2FQRCodeUI.D(LuckyMoneyF2FQRCodeUI.this).equals(paramAnonymousValueAnimator.first))) {
          LuckyMoneyF2FQRCodeUI.E(LuckyMoneyF2FQRCodeUI.this).setAlpha(f);
        }
        Log.i("LuckyMoneyF2FQRCodeUI", "fireworkBottomLayer %f", new Object[] { Float.valueOf(f) });
        if (f >= 0.9F)
        {
          paramAnonymousView.setAlpha((1.0F - f) * 10.0F);
          LuckyMoneyF2FQRCodeUI.F(LuckyMoneyF2FQRCodeUI.this).setAlpha(1.0F - (1.0F - f) * 10.0F);
          LuckyMoneyF2FQRCodeUI.F(LuckyMoneyF2FQRCodeUI.this).setScaleX(f);
          LuckyMoneyF2FQRCodeUI.F(LuckyMoneyF2FQRCodeUI.this).setScaleY(f);
          LuckyMoneyF2FQRCodeUI.F(LuckyMoneyF2FQRCodeUI.this).setVisibility(0);
        }
        if (f == 1.0F)
        {
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).aKx("packet_received.m4a");
          LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this).removeView(LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this).getExitView());
          LuckyMoneyF2FQRCodeUI.H(LuckyMoneyF2FQRCodeUI.this);
          LuckyMoneyF2FQRCodeUI.I(LuckyMoneyF2FQRCodeUI.this).start();
        }
        AppMethodBeat.o(65064);
      }
    });
    this.Kpg.setCardListener(new ShuffleView.b()
    {
      public final void ZJ(int paramAnonymousInt)
      {
        AppMethodBeat.i(65066);
        LuckyMoneyF2FQRCodeUI.K(LuckyMoneyF2FQRCodeUI.this);
        if (paramAnonymousInt != 8)
        {
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).aKx("select_card.m4a");
          arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
          arrayOfInt[3] += 1;
          AppMethodBeat.o(65066);
          return;
        }
        int[] arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
        arrayOfInt[5] += 1;
        AppMethodBeat.o(65066);
      }
      
      public final void jB(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(65065);
        if (paramAnonymousInt2 == 8)
        {
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).aKx("music" + (paramAnonymousInt1 + 1) + ".m4a");
          arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
          arrayOfInt[4] += 1;
          AppMethodBeat.o(65065);
          return;
        }
        LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).aKx("touch_card.m4a");
        int[] arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
        arrayOfInt[2] += 1;
        AppMethodBeat.o(65065);
      }
      
      public final void jC(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(65067);
        if (paramAnonymousInt2 == 8)
        {
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).aKx("music" + (paramAnonymousInt1 + 1) + ".m4a");
          AppMethodBeat.o(65067);
          return;
        }
        LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).aKx("select_card.m4a");
        AppMethodBeat.o(65067);
      }
    });
    fWG();
    this.Kpp = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.Kpp.setDuration(300L);
    this.Kpp.setStartDelay(3000L);
    this.Kpp.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(65068);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        LuckyMoneyF2FQRCodeUI.F(LuckyMoneyF2FQRCodeUI.this).setTranslationY(-0.5F * f * LuckyMoneyF2FQRCodeUI.L(LuckyMoneyF2FQRCodeUI.this).heightPixels);
        LuckyMoneyF2FQRCodeUI.E(LuckyMoneyF2FQRCodeUI.this).setAlpha(1.0F - f);
        if (f == 1.0F)
        {
          LuckyMoneyF2FQRCodeUI.F(LuckyMoneyF2FQRCodeUI.this).setVisibility(8);
          LuckyMoneyF2FQRCodeUI.F(LuckyMoneyF2FQRCodeUI.this).setTranslationY(0.0F);
          LuckyMoneyF2FQRCodeUI.M(LuckyMoneyF2FQRCodeUI.this);
          LuckyMoneyF2FQRCodeUI.N(LuckyMoneyF2FQRCodeUI.this).notifyDataSetChanged();
          LuckyMoneyF2FQRCodeUI.x(LuckyMoneyF2FQRCodeUI.this).jlV();
        }
        AppMethodBeat.o(65068);
      }
    });
    fWF();
    getWindow().addFlags(128);
    if (i.jPv()) {
      getWindow().addFlags(8192);
    }
    AppMethodBeat.o(65086);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65094);
    com.tencent.mm.plugin.report.service.h.OAn.b(14007, new Object[] { Integer.valueOf(this.pZy[0]), Integer.valueOf(this.pZy[1]), Integer.valueOf(this.pZy[2]), Integer.valueOf(this.pZy[3]), Integer.valueOf(this.pZy[4]), Integer.valueOf(this.pZy[5]) });
    com.tencent.mm.plugin.luckymoney.f2f.a locala = this.Kpm;
    locala.cBt = true;
    locala.Koe.release();
    getWindow().clearFlags(128);
    super.onDestroy();
    AppMethodBeat.o(65094);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(65093);
    super.onPause();
    if (this.mSensorManager != null) {
      this.mSensorManager.unregisterListener(this.KpJ);
    }
    AppMethodBeat.o(65093);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65091);
    super.onResume();
    doSceneProgress(new e(), true);
    this.qaM.startTimer(60000L);
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().a("ffopenwxhb", this.Kpt, true);
    addSceneEndListener(1990);
    addSceneEndListener(1987);
    addSceneEndListener(1971);
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    if (localLayoutParams.screenBrightness < 0.85F)
    {
      localLayoutParams.screenBrightness = 0.85F;
      getWindow().setAttributes(localLayoutParams);
    }
    ScreenShotUtil.setScreenShotCallback(this, this);
    if (this.mSensorManager != null) {
      this.mSensorManager.registerListener(this.KpJ, this.mSensorManager.getDefaultSensor(1), 3);
    }
    AppMethodBeat.o(65091);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    int i = 0;
    AppMethodBeat.i(65095);
    Log.i("LuckyMoneyF2FQRCodeUI", "errType: %d,errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramp instanceof e))
      {
        Log.d("LuckyMoneyF2FQRCodeUI", "sendId:" + this.CAf);
        if ((!Util.isNullOrNil(new String[] { this.CAf, ((e)paramp).CAf })) && (!this.CAf.equals(((e)paramp).CAf)))
        {
          this.Kpb.clear();
          this.Kpc.clear();
          this.Kpd.clear();
          this.Kpe.notifyDataSetChanged();
          this.Kpo = "";
        }
        if (!Util.isNullOrNil(((e)paramp).CAf)) {
          this.CAf = ((e)paramp).CAf;
        }
        this.ytZ = ((e)paramp).ytZ;
        this.KoH = ((e)paramp).KoH;
        this.KoG = ((e)paramp).KoG;
        this.KoF = ((e)paramp).KoF;
        fWF();
        fWI();
        if (this.KoH == 0) {
          this.qaM.stopTimer();
        }
        if ((this.Kpb.size() == 0) && (!Util.isNullOrNil(this.CAf))) {
          doSceneProgress(new aq(this.CAf, 5, 0, null, "v1.0"), false);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(65095);
      return true;
      if ((paramp instanceof com.tencent.mm.plugin.luckymoney.f2f.a.a))
      {
        this.CAf = "";
        this.ytZ = "";
        this.KoH = 0;
        this.Kpb.clear();
        this.Kpo = "";
        this.Kpe.notifyDataSetChanged();
        fWF();
        fWI();
        this.qaM.stopTimer();
        if (!Util.isNullOrNil(this.KoG)) {
          com.tencent.mm.ui.base.k.cZ(this, this.KoG);
        }
        this.KoF = "";
      }
      else if ((paramp instanceof aq))
      {
        this.Kpn = ((aq)paramp).KtU.KrR;
        paramString = ((aq)paramp).KtU.Ksg;
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramInt1 = i;
          while (paramInt1 < paramString.size())
          {
            paramp = (af)paramString.get(paramInt1);
            if ((!Util.isNullOrNil(paramp.KrU)) && (!this.Kpb.contains(paramp.KrU)))
            {
              this.Kpb.add(paramp.KrU);
              String str = paramp.userName;
              if (!Util.isNullOrNil(paramp.KtF)) {
                this.Kpo = str;
              }
              this.Kpc.put(paramp.KrU, str);
            }
            paramInt1 += 1;
          }
          fWH();
          this.Kpe.notifyDataSetChanged();
        }
      }
      else if ((paramp instanceof com.tencent.mm.plugin.luckymoney.f2f.a.b))
      {
        Log.i("LuckyMoneyF2FQRCodeUI", "onSceneEnd NetSceneF2FLuckyMoneyInvalid");
        this.retCode = ((com.tencent.mm.plugin.luckymoney.f2f.a.b)paramp).hAV;
        this.wZb = ((com.tencent.mm.plugin.luckymoney.f2f.a.b)paramp).wYI;
        Log.i("LuckyMoneyF2FQRCodeUI", "retcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        continue;
        if (!Util.isNullOrNil(paramString)) {
          com.tencent.mm.ui.base.k.c(this, paramString, getString(a.i.app_tip), true);
        }
      }
    }
  }
  
  public void onScreenShot(String paramString, long paramLong)
  {
    AppMethodBeat.i(283991);
    Log.i("LuckyMoneyF2FQRCodeUI", "screenShot");
    if (this.KoH > 0)
    {
      paramString = this.ytZ;
      Log.i("LuckyMoneyF2FQRCodeUI", "invalidQRCode");
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.b(paramString), false);
      Log.i("LuckyMoneyF2FQRCodeUI", "getQRCode");
      doSceneProgress(new e(), false);
      fWF();
      paramString = this.pZy;
      paramString[1] += 1;
      com.tencent.mm.ui.base.k.c(this, getString(a.i.lucky_money_f2f_screen_shot_tips), null, true);
    }
    AppMethodBeat.o(283991);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(65092);
    super.onStop();
    this.qaM.stopTimer();
    ((v)com.tencent.mm.kernel.h.az(v.class)).getSysCmdMsgExtension().b("ffopenwxhb", this.Kpt, true);
    removeSceneEndListener(1990);
    removeSceneEndListener(1987);
    removeSceneEndListener(1971);
    ScreenShotUtil.setScreenShotCallback(this, null);
    AppMethodBeat.o(65092);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    private String getItem(int paramInt)
    {
      AppMethodBeat.i(65082);
      String str = (String)LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).get(paramInt);
      AppMethodBeat.o(65082);
      return str;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(65081);
      int i = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size();
      AppMethodBeat.o(65081);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(65083);
      if (paramView == null)
      {
        paramView = LayoutInflater.from(LuckyMoneyF2FQRCodeUI.this).inflate(a.g.lucky_money_f2f_recv_list_item, null);
        Object localObject = (ImageView)paramView.findViewById(a.f.lucky_money_f2f_recv_grid_avatar);
        ImageView localImageView = (ImageView)paramView.findViewById(a.f.lucky_money_f2f_most_lucky_icon);
        paramViewGroup = new a();
        paramViewGroup.pKM = ((ImageView)localObject);
        paramViewGroup.KpT = localImageView;
        paramView.setTag(paramViewGroup);
        localObject = (String)LuckyMoneyF2FQRCodeUI.b(LuckyMoneyF2FQRCodeUI.this).get(getItem(paramInt));
        ah.a(paramViewGroup.pKM, null, (String)localObject);
        if ((Util.isNullOrNil(LuckyMoneyF2FQRCodeUI.D(LuckyMoneyF2FQRCodeUI.this))) || (!LuckyMoneyF2FQRCodeUI.D(LuckyMoneyF2FQRCodeUI.this).equals(localObject))) {
          break label160;
        }
        paramViewGroup.KpT.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(65083);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label160:
        paramViewGroup.KpT.setVisibility(4);
      }
    }
    
    final class a
    {
      ImageView KpT;
      ImageView pKM;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI
 * JD-Core Version:    0.7.0.1
 */