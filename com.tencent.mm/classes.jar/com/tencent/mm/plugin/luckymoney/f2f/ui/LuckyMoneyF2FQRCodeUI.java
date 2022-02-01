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
import com.tencent.mm.ak.e.a;
import com.tencent.mm.ak.e.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.cf;
import com.tencent.mm.model.cf.a;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.luckymoney.f2f.a.1;
import com.tencent.mm.plugin.luckymoney.f2f.a.2;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.y;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.cv;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.aw.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bi.a;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import com.tencent.mm.ui.base.HorizontalListViewV2;
import com.tencent.mm.ui.base.HorizontalListViewV2.d;
import com.tencent.mm.ui.base.HorizontalListViewV2.d.a;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
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
  implements bi.a
{
  private View agn;
  private DisplayMetrics iQv;
  private aw jnx;
  private int[] joi;
  private String kuP;
  private Bitmap mBitmap;
  private com.tencent.mm.ui.widget.a.e mIQ;
  private SensorManager mSensorManager;
  private n.e pkS;
  private String qlv;
  private int retCode;
  private String vwq;
  private Button vwz;
  private String vxL;
  private String vxM;
  private int vxN;
  private View vxY;
  private View vxZ;
  private n.d vyA;
  private Bitmap vyB;
  private Bitmap vyC;
  private Bitmap vyD;
  private Bitmap vyE;
  private Bitmap vyF;
  private Bitmap vyG;
  private Bitmap vyH;
  private Bitmap vyI;
  private Bitmap vyJ;
  private Bitmap vyK;
  private Bitmap vyL;
  private Bitmap vyM;
  private com.tencent.mm.particles.b vyN;
  private com.tencent.mm.particles.b vyO;
  final SensorEventListener vyP;
  private ImageView vya;
  private TextView vyb;
  private TextView vyc;
  private ImageView vyd;
  private TextView vye;
  private TextView vyf;
  private HorizontalListViewV2 vyg;
  private List<String> vyh;
  private Map<String, String> vyi;
  private Queue<Pair<String, Integer>> vyj;
  private a vyk;
  private TextView vyl;
  private ShuffleView vym;
  private ShuffleView.c vyn;
  private List<View> vyo;
  private ViewGroup vyp;
  private ViewGroup vyq;
  private View vyr;
  private com.tencent.mm.plugin.luckymoney.f2f.a vys;
  private long vyt;
  private String vyu;
  private ValueAnimator vyv;
  private float vyw;
  private float vyx;
  private float vyy;
  private cf.a vyz;
  
  public LuckyMoneyF2FQRCodeUI()
  {
    AppMethodBeat.i(65085);
    this.vyz = new cf.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(65061);
        paramAnonymousa = bx.M(com.tencent.mm.platformtools.z.a(paramAnonymousa.gte.FNI), "sysmsg");
        if (paramAnonymousa != null)
        {
          String str1 = (String)paramAnonymousa.get(".sysmsg.sendId");
          final String str2 = (String)paramAnonymousa.get(".sysmsg.username");
          final String str3 = (String)paramAnonymousa.get(".sysmsg.amount");
          final String str4 = (String)paramAnonymousa.get(".sysmsg.receiveId");
          if (bu.getInt((String)paramAnonymousa.get(".sysmsg.islucky"), 0) > 0) {
            LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, str2);
          }
          if (!bu.V(new String[] { str1, str2, str3 })) {
            LuckyMoneyF2FQRCodeUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(65060);
                Object localObject;
                if (!LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).contains(str4))
                {
                  LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).add(0, str4);
                  if (!x.An(str2))
                  {
                    localObject = new i();
                    ((i)localObject).username = str2;
                    p.aEN().b((i)localObject);
                  }
                  LuckyMoneyF2FQRCodeUI.b(LuckyMoneyF2FQRCodeUI.this).put(str4, str2);
                  localObject = LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this);
                  if (((ShuffleView)localObject).vzk.size() > 0)
                  {
                    if (((ShuffleView)localObject).vzm.isStarted()) {
                      ((ShuffleView)localObject).vzm.end();
                    }
                    if (((ShuffleView)localObject).pWD.isStarted()) {
                      ((ShuffleView)localObject).pWD.end();
                    }
                    if (((ShuffleView)localObject).joC == null) {
                      break label351;
                    }
                    ((ShuffleView)localObject).vzq = ((ShuffleView)localObject).joC;
                    ((ShuffleView)localObject).vzk.remove(((ShuffleView)localObject).vzq);
                    if (((ShuffleView)localObject).scY != null) {
                      ((ShuffleView)localObject).scY.start();
                    }
                    ((ShuffleView)localObject).JH(((ShuffleView)localObject).vzs);
                    if (((ShuffleView)localObject).vzv <= 0) {
                      break label338;
                    }
                    ((ShuffleView)localObject).vzs = ((ShuffleView)localObject).dlc();
                    ((ShuffleView)localObject).joC = ((View)((ShuffleView)localObject).vzk.get(((ShuffleView)localObject).vzs));
                  }
                }
                for (;;)
                {
                  LuckyMoneyF2FQRCodeUI.d(LuckyMoneyF2FQRCodeUI.this).remove(LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this).getExitView());
                  LuckyMoneyF2FQRCodeUI.e(LuckyMoneyF2FQRCodeUI.this).ay(0L, 60000L);
                  LuckyMoneyF2FQRCodeUI.f(LuckyMoneyF2FQRCodeUI.this).add(new Pair(str2, Integer.valueOf(bu.getInt(str3, 0))));
                  AppMethodBeat.o(65060);
                  return;
                  label338:
                  ((ShuffleView)localObject).joC = null;
                  ((ShuffleView)localObject).vzs = 0;
                  continue;
                  label351:
                  ((ShuffleView)localObject).JF(((ShuffleView)localObject).dlc());
                  ((ShuffleView)localObject).vzq = ((ShuffleView)localObject).joC;
                  ((ShuffleView)localObject).vzm.addListener(new ShuffleView.5((ShuffleView)localObject));
                }
              }
            });
          }
        }
        AppMethodBeat.o(65061);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.vyA = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(65073);
        if (bu.isNullOrNil(LuckyMoneyF2FQRCodeUI.g(LuckyMoneyF2FQRCodeUI.this)))
        {
          paramAnonymousl.jM(1, 2131760859);
          AppMethodBeat.o(65073);
          return;
        }
        paramAnonymousl.a(1, LuckyMoneyF2FQRCodeUI.this.getString(2131760859), LuckyMoneyF2FQRCodeUI.g(LuckyMoneyF2FQRCodeUI.this), 0);
        AppMethodBeat.o(65073);
      }
    };
    this.pkS = new n.e()
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
          com.tencent.mm.ui.base.h.cm(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.this.getString(2131760860));
        }
      }
    };
    this.vyN = new com.tencent.mm.particles.b()
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
    this.vyO = new com.tencent.mm.particles.b()
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
    this.vyP = new SensorEventListener()
    {
      float aTM;
      final int vyU;
      float vyV;
      int vyW;
      ValueAnimator vyX;
      
      public final void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt)
      {
        AppMethodBeat.i(65072);
        ae.i("LuckyMoneyF2FQRCodeUI", "onAccuracyChanged");
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
          if (this.vyW == 0) {
            this.vyW = (com.tencent.mm.pluginsdk.h.dX(LuckyMoneyF2FQRCodeUI.this) + (int)this.vyV);
          }
          f2 = paramAnonymousSensorEvent.values[1];
          if (Math.abs(f2 - this.aTM) < 0.05D)
          {
            AppMethodBeat.o(65071);
            return;
          }
          this.aTM = f2;
          ae.d("LuckyMoneyF2FQRCodeUI", "[onSensorChanged] y:%s ", new Object[] { Float.valueOf(f2) });
          if (f2 >= -3.0F) {
            break label246;
          }
        }
        for (;;)
        {
          f1 = f1 / 3.0F * this.vyW + this.vyW;
          ae.d("LuckyMoneyF2FQRCodeUI", "paddingTop:%s nowPaddingTop:%s", new Object[] { Float.valueOf(f1), Integer.valueOf(LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingTop()) });
          if (this.vyX != null) {
            this.vyX.cancel();
          }
          this.vyX = ValueAnimator.ofFloat(new float[] { LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingTop(), f1 }).setDuration(200L);
          this.vyX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
          {
            public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
            {
              AppMethodBeat.i(65069);
              float f = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue();
              LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).setPadding(LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingLeft(), (int)f, LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingRight(), LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingBottom());
              f /= LuckyMoneyF2FQRCodeUI.7.this.vyW;
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
          this.vyX.start();
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
  
  private void dkX()
  {
    AppMethodBeat.i(65087);
    if (!bu.isNullOrNil(this.qlv))
    {
      this.mBitmap = com.tencent.mm.by.a.a.bZ(this, this.qlv);
      this.vyd.setImageBitmap(this.mBitmap);
    }
    if (this.vxN <= 0)
    {
      this.vyd.setPadding(com.tencent.mm.cb.a.fromDPToPix(this, 5), com.tencent.mm.cb.a.fromDPToPix(this, 5), com.tencent.mm.cb.a.fromDPToPix(this, 5), com.tencent.mm.cb.a.fromDPToPix(this, 5));
      this.vyd.setImageResource(2131233001);
      this.vyl.setVisibility(8);
      this.vwz.setVisibility(0);
      this.vye.setVisibility(4);
      this.vxY.setPadding(this.vxY.getPaddingLeft(), com.tencent.mm.pluginsdk.h.dX(this), this.vxY.getPaddingRight(), this.vxY.getPaddingBottom());
      if (this.vyh.size() > 0)
      {
        this.vyf.setText(getString(2131760864));
        AppMethodBeat.o(65087);
        return;
      }
      this.vyf.setText(getString(2131760865));
      AppMethodBeat.o(65087);
      return;
    }
    this.vyd.setPadding(0, 0, 0, 0);
    this.vye.setText(getString(2131760870));
    this.vye.setVisibility(0);
    this.vyf.setText(getString(2131760870));
    this.vyl.setText(getString(2131760869, new Object[] { Integer.valueOf(this.vxN) }));
    this.vyl.setVisibility(0);
    this.vwz.setVisibility(8);
    AppMethodBeat.o(65087);
  }
  
  private void dkY()
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
    com.tencent.mm.plugin.luckymoney.f2f.a locala = this.vys;
    WeakReference localWeakReference = new WeakReference(this);
    com.tencent.mm.kernel.g.ajU().aw(new a.1(locala, localHashSet, localWeakReference));
    locala.vxj.setOnLoadCompleteListener(new a.2(locala));
    AppMethodBeat.o(65088);
  }
  
  private void dkZ()
  {
    AppMethodBeat.i(65089);
    int i = this.vyg.getWidth() - this.vyh.size() * getResources().getDimensionPixelSize(2131165188);
    if (i > 0)
    {
      this.vyg.setPadding(i / 2, 0, i / 2, 0);
      AppMethodBeat.o(65089);
      return;
    }
    this.vyg.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(65089);
  }
  
  private void dla()
  {
    AppMethodBeat.i(65090);
    if (this.vyo.size() != this.vxN)
    {
      ae.i("LuckyMoneyF2FQRCodeUI", "shuffle cards: %d", new Object[] { Integer.valueOf(this.vyo.size()), Integer.valueOf(this.vxN) });
      this.vyo.clear();
      int i = 0;
      while (i < this.vxN)
      {
        View localView = LayoutInflater.from(this).inflate(2131494641, this.vym, false);
        ((FrameLayout.LayoutParams)localView.getLayoutParams()).gravity = 81;
        this.vyo.add(localView);
        i += 1;
      }
      this.vym.setAllShuffleCards(this.vyo);
    }
    AppMethodBeat.o(65090);
  }
  
  public final void X(String paramString, long paramLong)
  {
    AppMethodBeat.i(189836);
    ae.i("LuckyMoneyF2FQRCodeUI", "screenShot");
    if (this.vxN > 0)
    {
      paramString = this.qlv;
      ae.i("LuckyMoneyF2FQRCodeUI", "invalidQRCode");
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.b(paramString), false);
      ae.i("LuckyMoneyF2FQRCodeUI", "getQRCode");
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.e(), false);
      dkX();
      paramString = this.joi;
      paramString[1] += 1;
      com.tencent.mm.ui.base.h.c(this, getString(2131760871), null, true);
    }
    AppMethodBeat.o(189836);
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
    this.iQv = getResources().getDisplayMetrics();
    this.vyh = new ArrayList();
    this.vyi = new HashMap();
    this.vyj = new LinkedList();
    this.vyo = new ArrayList();
    this.joi = new int[6];
    paramBundle = this.joi;
    paramBundle[0] += 1;
    this.jnx = new aw(new aw.a()
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
    this.agn = findViewById(2131301823);
    this.vxY = findViewById(2131306989);
    this.vyf = ((TextView)findViewById(2131301819));
    this.vye = ((TextView)findViewById(2131301820));
    this.vyy = this.vyf.getAlpha();
    this.vyd = ((ImageView)this.agn.findViewById(2131301818));
    this.vyg = ((HorizontalListViewV2)findViewById(2131301821));
    this.vyk = new a((byte)0);
    this.vyg.setAdapter(this.vyk);
    this.vyg.setOnItemClickListener(new LuckyMoneyF2FQRCodeUI.13(this));
    this.vyg.setOnScrollStateChangedListener(new HorizontalListViewV2.d()
    {
      public final void a(HorizontalListViewV2.d.a paramAnonymousa)
      {
        AppMethodBeat.i(65079);
        if ((paramAnonymousa == HorizontalListViewV2.d.a.JEk) && (LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size() >= 5) && (LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size() < LuckyMoneyF2FQRCodeUI.w(LuckyMoneyF2FQRCodeUI.this)) && (LuckyMoneyF2FQRCodeUI.x(LuckyMoneyF2FQRCodeUI.this).getLastVisiblePosition() == LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size() - 1) && (!bu.isNullOrNil(LuckyMoneyF2FQRCodeUI.v(LuckyMoneyF2FQRCodeUI.this))))
        {
          paramAnonymousa = new ah(LuckyMoneyF2FQRCodeUI.v(LuckyMoneyF2FQRCodeUI.this), 5, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size(), null, "v1.0");
          LuckyMoneyF2FQRCodeUI.this.doSceneProgress(paramAnonymousa);
        }
        AppMethodBeat.o(65079);
      }
    });
    this.vwz = ((Button)findViewById(2131301817));
    this.vwz.setOnClickListener(new LuckyMoneyF2FQRCodeUI.15(this));
    this.vyl = ((TextView)findViewById(2131301825));
    this.vxZ = findViewById(2131301824);
    setBackBtn(new LuckyMoneyF2FQRCodeUI.2(this));
    setMMTitle(getString(2131760872));
    addIconOptionMenu(0, 2131689493, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65063);
        LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, new com.tencent.mm.ui.widget.a.e(LuckyMoneyF2FQRCodeUI.this, 1, false));
        LuckyMoneyF2FQRCodeUI.z(LuckyMoneyF2FQRCodeUI.this).LfS = LuckyMoneyF2FQRCodeUI.y(LuckyMoneyF2FQRCodeUI.this);
        LuckyMoneyF2FQRCodeUI.z(LuckyMoneyF2FQRCodeUI.this).LfT = LuckyMoneyF2FQRCodeUI.A(LuckyMoneyF2FQRCodeUI.this);
        LuckyMoneyF2FQRCodeUI.z(LuckyMoneyF2FQRCodeUI.this).cPF();
        AppMethodBeat.o(65063);
        return true;
      }
    });
    setActionbarColor(getResources().getColor(2131100568));
    hideActionbarLine();
    this.vyp = ((ViewGroup)findViewById(2131301812));
    this.vyq = ((ViewGroup)findViewById(2131301811));
    this.vyr = findViewById(2131301814);
    this.vyr.setAlpha(0.0F);
    this.mSensorManager = ((SensorManager)ak.getContext().getSystemService("sensor"));
    this.mSensorManager.registerListener(this.vyP, this.mSensorManager.getDefaultSensor(1), 3);
    this.vys = new com.tencent.mm.plugin.luckymoney.f2f.a();
    this.vym = ((ShuffleView)findViewById(2131301826));
    this.vyn = new ShuffleView.c();
    this.vyn.vzK = 4;
    this.vyn.vzI = 2;
    this.vyn.vzJ = 4;
    this.vyn.vzL = 300;
    this.vyn.scaleY = 0.0F;
    this.vym.setShuffleSetting(this.vyn);
    ShuffleView.iQv = this.iQv;
    paramBundle = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(300L);
    this.vym.setExitAnimator(paramBundle);
    this.vym.setExitAnimatorListener(new ShuffleView.a()
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
        if ((paramAnonymousValueAnimator != null) && (!bu.isNullOrNil(LuckyMoneyF2FQRCodeUI.D(LuckyMoneyF2FQRCodeUI.this))) && (LuckyMoneyF2FQRCodeUI.D(LuckyMoneyF2FQRCodeUI.this).equals(paramAnonymousValueAnimator.first))) {
          LuckyMoneyF2FQRCodeUI.E(LuckyMoneyF2FQRCodeUI.this).setAlpha(f);
        }
        ae.i("LuckyMoneyF2FQRCodeUI", "fireworkBottomLayer %f", new Object[] { Float.valueOf(f) });
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
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).uP("packet_received.m4a");
          LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this).removeView(LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this).getExitView());
          LuckyMoneyF2FQRCodeUI.H(LuckyMoneyF2FQRCodeUI.this);
          LuckyMoneyF2FQRCodeUI.I(LuckyMoneyF2FQRCodeUI.this).start();
        }
        AppMethodBeat.o(65064);
      }
    });
    this.vym.setCardListener(new ShuffleView.b()
    {
      public final void JC(int paramAnonymousInt)
      {
        AppMethodBeat.i(65066);
        LuckyMoneyF2FQRCodeUI.K(LuckyMoneyF2FQRCodeUI.this);
        if (paramAnonymousInt != 8)
        {
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).uP("select_card.m4a");
          arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
          arrayOfInt[3] += 1;
          AppMethodBeat.o(65066);
          return;
        }
        int[] arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
        arrayOfInt[5] += 1;
        AppMethodBeat.o(65066);
      }
      
      public final void gu(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(65065);
        if (paramAnonymousInt2 == 8)
        {
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).uP("music" + (paramAnonymousInt1 + 1) + ".m4a");
          arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
          arrayOfInt[4] += 1;
          AppMethodBeat.o(65065);
          return;
        }
        LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).uP("touch_card.m4a");
        int[] arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
        arrayOfInt[2] += 1;
        AppMethodBeat.o(65065);
      }
      
      public final void gv(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(65067);
        if (paramAnonymousInt2 == 8)
        {
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).uP("music" + (paramAnonymousInt1 + 1) + ".m4a");
          AppMethodBeat.o(65067);
          return;
        }
        LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).uP("select_card.m4a");
        AppMethodBeat.o(65067);
      }
    });
    dkY();
    this.vyv = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.vyv.setDuration(300L);
    this.vyv.setStartDelay(3000L);
    this.vyv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
          LuckyMoneyF2FQRCodeUI.x(LuckyMoneyF2FQRCodeUI.this).fCv();
        }
        AppMethodBeat.o(65068);
      }
    });
    dkX();
    getWindow().addFlags(128);
    AppMethodBeat.o(65086);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65094);
    com.tencent.mm.plugin.report.service.g.yxI.f(14007, new Object[] { Integer.valueOf(this.joi[0]), Integer.valueOf(this.joi[1]), Integer.valueOf(this.joi[2]), Integer.valueOf(this.joi[3]), Integer.valueOf(this.joi[4]), Integer.valueOf(this.joi[5]) });
    com.tencent.mm.plugin.luckymoney.f2f.a locala = this.vys;
    locala.stopped = true;
    locala.vxj.release();
    getWindow().clearFlags(128);
    super.onDestroy();
    AppMethodBeat.o(65094);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(65093);
    super.onPause();
    if (this.mSensorManager != null) {
      this.mSensorManager.unregisterListener(this.vyP);
    }
    AppMethodBeat.o(65093);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65091);
    super.onResume();
    doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.e(), true);
    this.jnx.ay(60000L, 60000L);
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().a("ffopenwxhb", this.vyz, true);
    addSceneEndListener(1990);
    addSceneEndListener(1987);
    addSceneEndListener(1971);
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    if (localLayoutParams.screenBrightness < 0.85F)
    {
      localLayoutParams.screenBrightness = 0.85F;
      getWindow().setAttributes(localLayoutParams);
    }
    bi.a(this, this);
    if (this.mSensorManager != null) {
      this.mSensorManager.registerListener(this.vyP, this.mSensorManager.getDefaultSensor(1), 3);
    }
    AppMethodBeat.o(65091);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 0;
    AppMethodBeat.i(65095);
    ae.i("LuckyMoneyF2FQRCodeUI", "errType: %d,errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramn instanceof com.tencent.mm.plugin.luckymoney.f2f.a.e))
      {
        ae.d("LuckyMoneyF2FQRCodeUI", "sendId:" + this.vwq);
        if ((!bu.V(new String[] { this.vwq, ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).vwq })) && (!this.vwq.equals(((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).vwq)))
        {
          this.vyh.clear();
          this.vyi.clear();
          this.vyj.clear();
          this.vyk.notifyDataSetChanged();
          this.vyu = "";
        }
        if (!bu.isNullOrNil(((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).vwq)) {
          this.vwq = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).vwq;
        }
        this.qlv = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).qlv;
        this.vxN = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).vxN;
        this.vxM = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).vxM;
        this.vxL = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).vxL;
        dkX();
        dla();
        if (this.vxN == 0) {
          this.jnx.stopTimer();
        }
        if ((this.vyh.size() == 0) && (!bu.isNullOrNil(this.vwq))) {
          doSceneProgress(new ah(this.vwq, 5, 0, null, "v1.0"), false);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(65095);
      return true;
      if ((paramn instanceof com.tencent.mm.plugin.luckymoney.f2f.a.a))
      {
        this.vwq = "";
        this.qlv = "";
        this.vxN = 0;
        this.vyh.clear();
        this.vyu = "";
        this.vyk.notifyDataSetChanged();
        dkX();
        dla();
        this.jnx.stopTimer();
        if (!bu.isNullOrNil(this.vxM)) {
          com.tencent.mm.ui.base.h.cm(this, this.vxM);
        }
        this.vxL = "";
      }
      else if ((paramn instanceof ah))
      {
        this.vyt = ((ah)paramn).vBT.vAn;
        paramString = ((ah)paramn).vBT.vAC;
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramInt1 = i;
          while (paramInt1 < paramString.size())
          {
            paramn = (y)paramString.get(paramInt1);
            if ((!bu.isNullOrNil(paramn.vAq)) && (!this.vyh.contains(paramn.vAq)))
            {
              this.vyh.add(paramn.vAq);
              String str = paramn.userName;
              if (!bu.isNullOrNil(paramn.vBI)) {
                this.vyu = str;
              }
              this.vyi.put(paramn.vAq, str);
            }
            paramInt1 += 1;
          }
          dkZ();
          this.vyk.notifyDataSetChanged();
        }
      }
      else if ((paramn instanceof com.tencent.mm.plugin.luckymoney.f2f.a.b))
      {
        ae.i("LuckyMoneyF2FQRCodeUI", "onSceneEnd NetSceneF2FLuckyMoneyInvalid");
        this.retCode = ((com.tencent.mm.plugin.luckymoney.f2f.a.b)paramn).dmy;
        this.kuP = ((com.tencent.mm.plugin.luckymoney.f2f.a.b)paramn).phe;
        ae.i("LuckyMoneyF2FQRCodeUI", "retcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        continue;
        if (!bu.isNullOrNil(paramString)) {
          com.tencent.mm.ui.base.h.c(this, paramString, getString(2131755906), true);
        }
      }
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(65092);
    super.onStop();
    this.jnx.stopTimer();
    ((s)com.tencent.mm.kernel.g.ad(s.class)).getSysCmdMsgExtension().b("ffopenwxhb", this.vyz, true);
    removeSceneEndListener(1990);
    removeSceneEndListener(1987);
    removeSceneEndListener(1971);
    bi.a(this, null);
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
        paramViewGroup.iZn = ((ImageView)localObject);
        paramViewGroup.vyZ = localImageView;
        paramView.setTag(paramViewGroup);
        localObject = (String)LuckyMoneyF2FQRCodeUI.b(LuckyMoneyF2FQRCodeUI.this).get(getItem(paramInt));
        com.tencent.mm.plugin.luckymoney.model.z.b(paramViewGroup.iZn, null, (String)localObject);
        if ((bu.isNullOrNil(LuckyMoneyF2FQRCodeUI.D(LuckyMoneyF2FQRCodeUI.this))) || (!LuckyMoneyF2FQRCodeUI.D(LuckyMoneyF2FQRCodeUI.this).equals(localObject))) {
          break label157;
        }
        paramViewGroup.vyZ.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(65083);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label157:
        paramViewGroup.vyZ.setVisibility(4);
      }
    }
    
    final class a
    {
      ImageView iZn;
      ImageView vyZ;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI
 * JD-Core Version:    0.7.0.1
 */