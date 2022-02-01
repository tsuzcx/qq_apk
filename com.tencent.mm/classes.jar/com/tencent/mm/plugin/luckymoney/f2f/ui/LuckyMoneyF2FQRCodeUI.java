package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
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
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.f.a;
import com.tencent.mm.ak.f.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.luckymoney.f2f.a.1;
import com.tencent.mm.plugin.luckymoney.f2f.a.2;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.plugin.luckymoney.model.y;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.cu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bg.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import com.tencent.mm.ui.base.HorizontalListViewV2;
import com.tencent.mm.ui.base.HorizontalListViewV2.d;
import com.tencent.mm.ui.base.HorizontalListViewV2.d.a;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
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
  implements bg.a
{
  private View aew;
  private au iRv;
  private int[] iSg;
  private DisplayMetrics iuy;
  private String jXd;
  private Bitmap mBitmap;
  private SensorManager mSensorManager;
  private com.tencent.mm.ui.widget.a.e mdB;
  private n.d oAR;
  private String pBl;
  private int retCode;
  private String uhB;
  private Button uhK;
  private String uiY;
  private String uiZ;
  private ShuffleView.c ujA;
  private List<View> ujB;
  private ViewGroup ujC;
  private ViewGroup ujD;
  private View ujE;
  private com.tencent.mm.plugin.luckymoney.f2f.a ujF;
  private long ujG;
  private String ujH;
  private ValueAnimator ujI;
  private float ujJ;
  private float ujK;
  private float ujL;
  private cc.a ujM;
  private n.c ujN;
  private Bitmap ujO;
  private Bitmap ujP;
  private Bitmap ujQ;
  private Bitmap ujR;
  private Bitmap ujS;
  private Bitmap ujT;
  private Bitmap ujU;
  private Bitmap ujV;
  private Bitmap ujW;
  private Bitmap ujX;
  private Bitmap ujY;
  private Bitmap ujZ;
  private int uja;
  private View ujl;
  private View ujm;
  private ImageView ujn;
  private TextView ujo;
  private TextView ujp;
  private ImageView ujq;
  private TextView ujr;
  private TextView ujs;
  private HorizontalListViewV2 ujt;
  private List<String> uju;
  private Map<String, String> ujv;
  private Queue<Pair<String, Integer>> ujw;
  private a ujx;
  private TextView ujy;
  private ShuffleView ujz;
  private com.tencent.mm.particles.b uka;
  private com.tencent.mm.particles.b ukb;
  final SensorEventListener ukc;
  
  public LuckyMoneyF2FQRCodeUI()
  {
    AppMethodBeat.i(65085);
    this.ujM = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(65061);
        paramAnonymousa = bv.L(com.tencent.mm.platformtools.z.a(paramAnonymousa.fXi.DPV), "sysmsg");
        if (paramAnonymousa != null)
        {
          String str1 = (String)paramAnonymousa.get(".sysmsg.sendId");
          final String str2 = (String)paramAnonymousa.get(".sysmsg.username");
          final String str3 = (String)paramAnonymousa.get(".sysmsg.amount");
          final String str4 = (String)paramAnonymousa.get(".sysmsg.receiveId");
          if (bs.getInt((String)paramAnonymousa.get(".sysmsg.islucky"), 0) > 0) {
            LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, str2);
          }
          if (!bs.T(new String[] { str1, str2, str3 })) {
            LuckyMoneyF2FQRCodeUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(65060);
                Object localObject;
                if (!LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).contains(str4))
                {
                  LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).add(0, str4);
                  if (!w.wG(str2))
                  {
                    localObject = new i();
                    ((i)localObject).username = str2;
                    p.aBw().b((i)localObject);
                  }
                  LuckyMoneyF2FQRCodeUI.b(LuckyMoneyF2FQRCodeUI.this).put(str4, str2);
                  localObject = LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this);
                  if (((ShuffleView)localObject).ukx.size() > 0)
                  {
                    if (((ShuffleView)localObject).ukB.isStarted()) {
                      ((ShuffleView)localObject).ukB.end();
                    }
                    if (((ShuffleView)localObject).pmy.isStarted()) {
                      ((ShuffleView)localObject).pmy.end();
                    }
                    if (((ShuffleView)localObject).iSA == null) {
                      break label351;
                    }
                    ((ShuffleView)localObject).ukF = ((ShuffleView)localObject).iSA;
                    ((ShuffleView)localObject).ukx.remove(((ShuffleView)localObject).ukF);
                    if (((ShuffleView)localObject).ukz != null) {
                      ((ShuffleView)localObject).ukz.start();
                    }
                    ((ShuffleView)localObject).HM(((ShuffleView)localObject).ukH);
                    if (((ShuffleView)localObject).ukK <= 0) {
                      break label338;
                    }
                    ((ShuffleView)localObject).ukH = ((ShuffleView)localObject).cYR();
                    ((ShuffleView)localObject).iSA = ((View)((ShuffleView)localObject).ukx.get(((ShuffleView)localObject).ukH));
                  }
                }
                for (;;)
                {
                  LuckyMoneyF2FQRCodeUI.d(LuckyMoneyF2FQRCodeUI.this).remove(LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this).getExitView());
                  LuckyMoneyF2FQRCodeUI.e(LuckyMoneyF2FQRCodeUI.this).au(0L, 60000L);
                  LuckyMoneyF2FQRCodeUI.f(LuckyMoneyF2FQRCodeUI.this).add(new Pair(str2, Integer.valueOf(bs.getInt(str3, 0))));
                  AppMethodBeat.o(65060);
                  return;
                  label338:
                  ((ShuffleView)localObject).iSA = null;
                  ((ShuffleView)localObject).ukH = 0;
                  continue;
                  label351:
                  ((ShuffleView)localObject).HK(((ShuffleView)localObject).cYR());
                  ((ShuffleView)localObject).ukF = ((ShuffleView)localObject).iSA;
                  ((ShuffleView)localObject).ukB.addListener(new ShuffleView.5((ShuffleView)localObject));
                }
              }
            });
          }
        }
        AppMethodBeat.o(65061);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.ujN = new LuckyMoneyF2FQRCodeUI.8(this);
    this.oAR = new LuckyMoneyF2FQRCodeUI.9(this);
    this.uka = new com.tencent.mm.particles.b()
    {
      public final com.tencent.mm.particles.a.b a(Random paramAnonymousRandom)
      {
        AppMethodBeat.i(65075);
        int i = paramAnonymousRandom.nextInt(100);
        if (i < 16)
        {
          if (LuckyMoneyF2FQRCodeUI.j(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233007, 36));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.j(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65075);
          return paramAnonymousRandom;
        }
        if (i < 33)
        {
          if (LuckyMoneyF2FQRCodeUI.k(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.b(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233008, 36));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.k(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65075);
          return paramAnonymousRandom;
        }
        if (i < 50)
        {
          if (LuckyMoneyF2FQRCodeUI.l(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233009, 36));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.l(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65075);
          return paramAnonymousRandom;
        }
        if (i < 70)
        {
          if (LuckyMoneyF2FQRCodeUI.m(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.d(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233002, 36));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.m(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65075);
          return paramAnonymousRandom;
        }
        if (i < 90)
        {
          if (LuckyMoneyF2FQRCodeUI.n(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.e(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233003, 36));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.n(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65075);
          return paramAnonymousRandom;
        }
        if (LuckyMoneyF2FQRCodeUI.o(LuckyMoneyF2FQRCodeUI.this) == null) {
          LuckyMoneyF2FQRCodeUI.f(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233004, 36));
        }
        paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.o(LuckyMoneyF2FQRCodeUI.this));
        AppMethodBeat.o(65075);
        return paramAnonymousRandom;
      }
    };
    this.ukb = new com.tencent.mm.particles.b()
    {
      public final com.tencent.mm.particles.a.b a(Random paramAnonymousRandom)
      {
        AppMethodBeat.i(65076);
        int i = paramAnonymousRandom.nextInt(100);
        if (i < 10)
        {
          if (LuckyMoneyF2FQRCodeUI.p(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.g(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233007, 32));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.p(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65076);
          return paramAnonymousRandom;
        }
        if (i < 20)
        {
          if (LuckyMoneyF2FQRCodeUI.q(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.h(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233008, 32));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.q(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65076);
          return paramAnonymousRandom;
        }
        if (i < 30)
        {
          if (LuckyMoneyF2FQRCodeUI.r(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.i(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233009, 32));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.r(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65076);
          return paramAnonymousRandom;
        }
        if (i < 50)
        {
          if (LuckyMoneyF2FQRCodeUI.s(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.j(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233002, 32));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.s(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65076);
          return paramAnonymousRandom;
        }
        if (i < 75)
        {
          if (LuckyMoneyF2FQRCodeUI.t(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.k(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233003, 32));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.t(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65076);
          return paramAnonymousRandom;
        }
        if (LuckyMoneyF2FQRCodeUI.u(LuckyMoneyF2FQRCodeUI.this) == null) {
          LuckyMoneyF2FQRCodeUI.l(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233004, 32));
        }
        paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.u(LuckyMoneyF2FQRCodeUI.this));
        AppMethodBeat.o(65076);
        return paramAnonymousRandom;
      }
    };
    this.ukc = new SensorEventListener()
    {
      float tmJ;
      final int ukh;
      float uki;
      int ukj;
      ValueAnimator ukk;
      
      public final void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt)
      {
        AppMethodBeat.i(65072);
        ac.i("LuckyMoneyF2FQRCodeUI", "onAccuracyChanged");
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
          if (this.ukj == 0) {
            this.ukj = (com.tencent.mm.pluginsdk.g.dT(LuckyMoneyF2FQRCodeUI.this) + (int)this.uki);
          }
          f2 = paramAnonymousSensorEvent.values[1];
          if (Math.abs(f2 - this.tmJ) < 0.05D)
          {
            AppMethodBeat.o(65071);
            return;
          }
          this.tmJ = f2;
          ac.d("LuckyMoneyF2FQRCodeUI", "[onSensorChanged] y:%s ", new Object[] { Float.valueOf(f2) });
          if (f2 >= -3.0F) {
            break label246;
          }
        }
        for (;;)
        {
          f1 = f1 / 3.0F * this.ukj + this.ukj;
          ac.d("LuckyMoneyF2FQRCodeUI", "paddingTop:%s nowPaddingTop:%s", new Object[] { Float.valueOf(f1), Integer.valueOf(LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingTop()) });
          if (this.ukk != null) {
            this.ukk.cancel();
          }
          this.ukk = ValueAnimator.ofFloat(new float[] { LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingTop(), f1 }).setDuration(200L);
          this.ukk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
          {
            public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
            {
              AppMethodBeat.i(65069);
              float f = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue();
              LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).setPadding(LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingLeft(), (int)f, LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingRight(), LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingBottom());
              f /= LuckyMoneyF2FQRCodeUI.7.this.ukj;
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
          this.ukk.start();
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
  
  private void cYM()
  {
    AppMethodBeat.i(65087);
    if (!bs.isNullOrNil(this.pBl))
    {
      this.mBitmap = com.tencent.mm.by.a.a.bU(this, this.pBl);
      this.ujq.setImageBitmap(this.mBitmap);
    }
    if (this.uja <= 0)
    {
      this.ujq.setPadding(com.tencent.mm.cc.a.fromDPToPix(this, 5), com.tencent.mm.cc.a.fromDPToPix(this, 5), com.tencent.mm.cc.a.fromDPToPix(this, 5), com.tencent.mm.cc.a.fromDPToPix(this, 5));
      this.ujq.setImageResource(2131233001);
      this.ujy.setVisibility(8);
      this.uhK.setVisibility(0);
      this.ujr.setVisibility(4);
      this.ujl.setPadding(this.ujl.getPaddingLeft(), com.tencent.mm.pluginsdk.g.dT(this), this.ujl.getPaddingRight(), this.ujl.getPaddingBottom());
      if (this.uju.size() > 0)
      {
        this.ujs.setText(getString(2131760864));
        AppMethodBeat.o(65087);
        return;
      }
      this.ujs.setText(getString(2131760865));
      AppMethodBeat.o(65087);
      return;
    }
    this.ujq.setPadding(0, 0, 0, 0);
    this.ujr.setText(getString(2131760870));
    this.ujr.setVisibility(0);
    this.ujs.setText(getString(2131760870));
    this.ujy.setText(getString(2131760869, new Object[] { Integer.valueOf(this.uja) }));
    this.ujy.setVisibility(0);
    this.uhK.setVisibility(8);
    AppMethodBeat.o(65087);
  }
  
  private void cYN()
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
    com.tencent.mm.plugin.luckymoney.f2f.a locala = this.ujF;
    WeakReference localWeakReference = new WeakReference(this);
    com.tencent.mm.kernel.g.agU().az(new a.1(locala, localHashSet, localWeakReference));
    locala.uiw.setOnLoadCompleteListener(new a.2(locala));
    AppMethodBeat.o(65088);
  }
  
  private void cYO()
  {
    AppMethodBeat.i(65089);
    int i = this.ujt.getWidth() - this.uju.size() * getResources().getDimensionPixelSize(2131165188);
    if (i > 0)
    {
      this.ujt.setPadding(i / 2, 0, i / 2, 0);
      AppMethodBeat.o(65089);
      return;
    }
    this.ujt.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(65089);
  }
  
  private void cYP()
  {
    AppMethodBeat.i(65090);
    if (this.ujB.size() != this.uja)
    {
      ac.i("LuckyMoneyF2FQRCodeUI", "shuffle cards: %d", new Object[] { Integer.valueOf(this.ujB.size()), Integer.valueOf(this.uja) });
      this.ujB.clear();
      int i = 0;
      while (i < this.uja)
      {
        View localView = LayoutInflater.from(this).inflate(2131494641, this.ujz, false);
        ((FrameLayout.LayoutParams)localView.getLayoutParams()).gravity = 81;
        this.ujB.add(localView);
        i += 1;
      }
      this.ujz.setAllShuffleCards(this.ujB);
    }
    AppMethodBeat.o(65090);
  }
  
  public final void Q(String paramString, long paramLong)
  {
    AppMethodBeat.i(207098);
    ac.i("LuckyMoneyF2FQRCodeUI", "screenShot");
    if (this.uja > 0)
    {
      paramString = this.pBl;
      ac.i("LuckyMoneyF2FQRCodeUI", "invalidQRCode");
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.b(paramString), false);
      ac.i("LuckyMoneyF2FQRCodeUI", "getQRCode");
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.e(), false);
      cYM();
      paramString = this.iSg;
      paramString[1] += 1;
      com.tencent.mm.ui.base.h.c(this, getString(2131760871), null, true);
    }
    AppMethodBeat.o(207098);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131494642;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65086);
    super.onCreate(paramBundle);
    this.iuy = getResources().getDisplayMetrics();
    this.uju = new ArrayList();
    this.ujv = new HashMap();
    this.ujw = new LinkedList();
    this.ujB = new ArrayList();
    this.iSg = new int[6];
    paramBundle = this.iSg;
    paramBundle[0] += 1;
    this.iRv = new au(new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(65077);
        com.tencent.mm.plugin.luckymoney.f2f.a.e locale = new com.tencent.mm.plugin.luckymoney.f2f.a.e();
        LuckyMoneyF2FQRCodeUI.this.doSceneProgress(locale, false);
        AppMethodBeat.o(65077);
        return true;
      }
    }, true);
    this.aew = findViewById(2131301823);
    this.ujl = findViewById(2131306989);
    this.ujs = ((TextView)findViewById(2131301819));
    this.ujr = ((TextView)findViewById(2131301820));
    this.ujL = this.ujs.getAlpha();
    this.ujq = ((ImageView)this.aew.findViewById(2131301818));
    this.ujt = ((HorizontalListViewV2)findViewById(2131301821));
    this.ujx = new a((byte)0);
    this.ujt.setAdapter(this.ujx);
    this.ujt.setOnItemClickListener(new LuckyMoneyF2FQRCodeUI.13(this));
    this.ujt.setOnScrollStateChangedListener(new HorizontalListViewV2.d()
    {
      public final void a(HorizontalListViewV2.d.a paramAnonymousa)
      {
        AppMethodBeat.i(65079);
        if ((paramAnonymousa == HorizontalListViewV2.d.a.HvG) && (LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size() >= 5) && (LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size() < LuckyMoneyF2FQRCodeUI.w(LuckyMoneyF2FQRCodeUI.this)) && (LuckyMoneyF2FQRCodeUI.x(LuckyMoneyF2FQRCodeUI.this).getLastVisiblePosition() == LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size() - 1) && (!bs.isNullOrNil(LuckyMoneyF2FQRCodeUI.v(LuckyMoneyF2FQRCodeUI.this))))
        {
          paramAnonymousa = new ah(LuckyMoneyF2FQRCodeUI.v(LuckyMoneyF2FQRCodeUI.this), 5, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size(), null, "v1.0");
          LuckyMoneyF2FQRCodeUI.this.doSceneProgress(paramAnonymousa);
        }
        AppMethodBeat.o(65079);
      }
    });
    this.uhK = ((Button)findViewById(2131301817));
    this.uhK.setOnClickListener(new LuckyMoneyF2FQRCodeUI.15(this));
    this.ujy = ((TextView)findViewById(2131301825));
    this.ujm = findViewById(2131301824);
    setBackBtn(new LuckyMoneyF2FQRCodeUI.2(this));
    setMMTitle(getString(2131760872));
    addIconOptionMenu(0, 2131689493, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65063);
        LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, new com.tencent.mm.ui.widget.a.e(LuckyMoneyF2FQRCodeUI.this, 1, false));
        LuckyMoneyF2FQRCodeUI.z(LuckyMoneyF2FQRCodeUI.this).ISu = LuckyMoneyF2FQRCodeUI.y(LuckyMoneyF2FQRCodeUI.this);
        LuckyMoneyF2FQRCodeUI.z(LuckyMoneyF2FQRCodeUI.this).ISv = LuckyMoneyF2FQRCodeUI.A(LuckyMoneyF2FQRCodeUI.this);
        LuckyMoneyF2FQRCodeUI.z(LuckyMoneyF2FQRCodeUI.this).cED();
        AppMethodBeat.o(65063);
        return true;
      }
    });
    setActionbarColor(getResources().getColor(2131100568));
    hideActionbarLine();
    this.ujC = ((ViewGroup)findViewById(2131301812));
    this.ujD = ((ViewGroup)findViewById(2131301811));
    this.ujE = findViewById(2131301814);
    this.ujE.setAlpha(0.0F);
    this.mSensorManager = ((SensorManager)ai.getContext().getSystemService("sensor"));
    this.mSensorManager.registerListener(this.ukc, this.mSensorManager.getDefaultSensor(1), 3);
    this.ujF = new com.tencent.mm.plugin.luckymoney.f2f.a();
    this.ujz = ((ShuffleView)findViewById(2131301826));
    this.ujA = new ShuffleView.c();
    this.ujA.ukZ = 4;
    this.ujA.ukX = 2;
    this.ujA.ukY = 4;
    this.ujA.ula = 300;
    this.ujA.scaleY = 0.0F;
    this.ujz.setShuffleSetting(this.ujA);
    ShuffleView.iuy = this.iuy;
    paramBundle = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(300L);
    this.ujz.setExitAnimator(paramBundle);
    this.ujz.setExitAnimatorListener(new ShuffleView.a()
    {
      public final void a(ValueAnimator paramAnonymousValueAnimator, View paramAnonymousView)
      {
        AppMethodBeat.i(65064);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f == 0.0F)
        {
          LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, paramAnonymousView.getTranslationX());
          LuckyMoneyF2FQRCodeUI.b(LuckyMoneyF2FQRCodeUI.this, paramAnonymousView.getTranslationY());
          paramAnonymousView.findViewById(2131301827).setVisibility(0);
        }
        paramAnonymousView.setTranslationX((1.0F - f) * LuckyMoneyF2FQRCodeUI.B(LuckyMoneyF2FQRCodeUI.this));
        paramAnonymousView.setTranslationY((1.0F - f) * LuckyMoneyF2FQRCodeUI.C(LuckyMoneyF2FQRCodeUI.this) - (LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this).getHeight() + LuckyMoneyF2FQRCodeUI.C(LuckyMoneyF2FQRCodeUI.this) * 8.0F) * f);
        paramAnonymousView.setScaleX(0.5F * f + 1.0F);
        paramAnonymousView.setScaleY(0.5F * f + 1.0F);
        paramAnonymousValueAnimator = (Pair)LuckyMoneyF2FQRCodeUI.f(LuckyMoneyF2FQRCodeUI.this).peek();
        if ((paramAnonymousValueAnimator != null) && (!bs.isNullOrNil(LuckyMoneyF2FQRCodeUI.D(LuckyMoneyF2FQRCodeUI.this))) && (LuckyMoneyF2FQRCodeUI.D(LuckyMoneyF2FQRCodeUI.this).equals(paramAnonymousValueAnimator.first))) {
          LuckyMoneyF2FQRCodeUI.E(LuckyMoneyF2FQRCodeUI.this).setAlpha(f);
        }
        ac.i("LuckyMoneyF2FQRCodeUI", "fireworkBottomLayer %f", new Object[] { Float.valueOf(f) });
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
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).rH("packet_received.m4a");
          LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this).removeView(LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this).getExitView());
          LuckyMoneyF2FQRCodeUI.H(LuckyMoneyF2FQRCodeUI.this);
          LuckyMoneyF2FQRCodeUI.I(LuckyMoneyF2FQRCodeUI.this).start();
        }
        AppMethodBeat.o(65064);
      }
    });
    this.ujz.setCardListener(new ShuffleView.b()
    {
      public final void HH(int paramAnonymousInt)
      {
        AppMethodBeat.i(65066);
        LuckyMoneyF2FQRCodeUI.K(LuckyMoneyF2FQRCodeUI.this);
        if (paramAnonymousInt != 8)
        {
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).rH("select_card.m4a");
          arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
          arrayOfInt[3] += 1;
          AppMethodBeat.o(65066);
          return;
        }
        int[] arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
        arrayOfInt[5] += 1;
        AppMethodBeat.o(65066);
      }
      
      public final void gd(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(65065);
        if (paramAnonymousInt2 == 8)
        {
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).rH("music" + (paramAnonymousInt1 + 1) + ".m4a");
          arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
          arrayOfInt[4] += 1;
          AppMethodBeat.o(65065);
          return;
        }
        LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).rH("touch_card.m4a");
        int[] arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
        arrayOfInt[2] += 1;
        AppMethodBeat.o(65065);
      }
      
      public final void ge(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(65067);
        if (paramAnonymousInt2 == 8)
        {
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).rH("music" + (paramAnonymousInt1 + 1) + ".m4a");
          AppMethodBeat.o(65067);
          return;
        }
        LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).rH("select_card.m4a");
        AppMethodBeat.o(65067);
      }
    });
    cYN();
    this.ujI = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.ujI.setDuration(300L);
    this.ujI.setStartDelay(3000L);
    this.ujI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
          LuckyMoneyF2FQRCodeUI.x(LuckyMoneyF2FQRCodeUI.this).fie();
        }
        AppMethodBeat.o(65068);
      }
    });
    cYM();
    getWindow().addFlags(128);
    AppMethodBeat.o(65086);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65094);
    com.tencent.mm.plugin.report.service.h.wUl.f(14007, new Object[] { Integer.valueOf(this.iSg[0]), Integer.valueOf(this.iSg[1]), Integer.valueOf(this.iSg[2]), Integer.valueOf(this.iSg[3]), Integer.valueOf(this.iSg[4]), Integer.valueOf(this.iSg[5]) });
    com.tencent.mm.plugin.luckymoney.f2f.a locala = this.ujF;
    locala.stopped = true;
    locala.uiw.release();
    getWindow().clearFlags(128);
    super.onDestroy();
    AppMethodBeat.o(65094);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(65093);
    super.onPause();
    if (this.mSensorManager != null) {
      this.mSensorManager.unregisterListener(this.ukc);
    }
    AppMethodBeat.o(65093);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65091);
    super.onResume();
    doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.e(), true);
    this.iRv.au(60000L, 60000L);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("ffopenwxhb", this.ujM, true);
    addSceneEndListener(1990);
    addSceneEndListener(1987);
    addSceneEndListener(1971);
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    if (localLayoutParams.screenBrightness < 0.85F)
    {
      localLayoutParams.screenBrightness = 0.85F;
      getWindow().setAttributes(localLayoutParams);
    }
    bg.a(this, this);
    if (this.mSensorManager != null) {
      this.mSensorManager.registerListener(this.ukc, this.mSensorManager.getDefaultSensor(1), 3);
    }
    AppMethodBeat.o(65091);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 0;
    AppMethodBeat.i(65095);
    ac.i("LuckyMoneyF2FQRCodeUI", "errType: %d,errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramn instanceof com.tencent.mm.plugin.luckymoney.f2f.a.e))
      {
        ac.d("LuckyMoneyF2FQRCodeUI", "sendId:" + this.uhB);
        if ((!bs.T(new String[] { this.uhB, ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).uhB })) && (!this.uhB.equals(((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).uhB)))
        {
          this.uju.clear();
          this.ujv.clear();
          this.ujw.clear();
          this.ujx.notifyDataSetChanged();
          this.ujH = "";
        }
        if (!bs.isNullOrNil(((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).uhB)) {
          this.uhB = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).uhB;
        }
        this.pBl = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).pBl;
        this.uja = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).uja;
        this.uiZ = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).uiZ;
        this.uiY = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).uiY;
        cYM();
        cYP();
        if (this.uja == 0) {
          this.iRv.stopTimer();
        }
        if ((this.uju.size() == 0) && (!bs.isNullOrNil(this.uhB))) {
          doSceneProgress(new ah(this.uhB, 5, 0, null, "v1.0"), false);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(65095);
      return true;
      if ((paramn instanceof com.tencent.mm.plugin.luckymoney.f2f.a.a))
      {
        this.uhB = "";
        this.pBl = "";
        this.uja = 0;
        this.uju.clear();
        this.ujH = "";
        this.ujx.notifyDataSetChanged();
        cYM();
        cYP();
        this.iRv.stopTimer();
        if (!bs.isNullOrNil(this.uiZ)) {
          com.tencent.mm.ui.base.h.cg(this, this.uiZ);
        }
        this.uiY = "";
      }
      else if ((paramn instanceof ah))
      {
        this.ujG = ((ah)paramn).uni.ulC;
        paramString = ((ah)paramn).uni.ulR;
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramInt1 = i;
          while (paramInt1 < paramString.size())
          {
            paramn = (y)paramString.get(paramInt1);
            if ((!bs.isNullOrNil(paramn.ulF)) && (!this.uju.contains(paramn.ulF)))
            {
              this.uju.add(paramn.ulF);
              String str = paramn.userName;
              if (!bs.isNullOrNil(paramn.umX)) {
                this.ujH = str;
              }
              this.ujv.put(paramn.ulF, str);
            }
            paramInt1 += 1;
          }
          cYO();
          this.ujx.notifyDataSetChanged();
        }
      }
      else if ((paramn instanceof com.tencent.mm.plugin.luckymoney.f2f.a.b))
      {
        ac.i("LuckyMoneyF2FQRCodeUI", "onSceneEnd NetSceneF2FLuckyMoneyInvalid");
        this.retCode = ((com.tencent.mm.plugin.luckymoney.f2f.a.b)paramn).dae;
        this.jXd = ((com.tencent.mm.plugin.luckymoney.f2f.a.b)paramn).oxf;
        ac.i("LuckyMoneyF2FQRCodeUI", "retcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        continue;
        if (!bs.isNullOrNil(paramString)) {
          com.tencent.mm.ui.base.h.c(this, paramString, getString(2131755906), true);
        }
      }
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(65092);
    super.onStop();
    this.iRv.stopTimer();
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("ffopenwxhb", this.ujM, true);
    removeSceneEndListener(1990);
    removeSceneEndListener(1987);
    removeSceneEndListener(1971);
    bg.a(this, null);
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
        paramView = LayoutInflater.from(LuckyMoneyF2FQRCodeUI.this).inflate(2131494644, null);
        Object localObject = (ImageView)paramView.findViewById(2131301822);
        ImageView localImageView = (ImageView)paramView.findViewById(2131301815);
        paramViewGroup = new a();
        paramViewGroup.iDk = ((ImageView)localObject);
        paramViewGroup.ukm = localImageView;
        paramView.setTag(paramViewGroup);
        localObject = (String)LuckyMoneyF2FQRCodeUI.b(LuckyMoneyF2FQRCodeUI.this).get(getItem(paramInt));
        com.tencent.mm.plugin.luckymoney.model.z.b(paramViewGroup.iDk, null, (String)localObject);
        if ((bs.isNullOrNil(LuckyMoneyF2FQRCodeUI.D(LuckyMoneyF2FQRCodeUI.this))) || (!LuckyMoneyF2FQRCodeUI.D(LuckyMoneyF2FQRCodeUI.this).equals(localObject))) {
          break label157;
        }
        paramViewGroup.ukm.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(65083);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label157:
        paramViewGroup.ukm.setVisibility(4);
      }
    }
    
    final class a
    {
      ImageView iDk;
      ImageView ukm;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI
 * JD-Core Version:    0.7.0.1
 */