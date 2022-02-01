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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.f.a;
import com.tencent.mm.al.f.c;
import com.tencent.mm.al.n;
import com.tencent.mm.model.cc;
import com.tencent.mm.model.cc.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.luckymoney.f2f.a.1;
import com.tencent.mm.plugin.luckymoney.f2f.a.2;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.y;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.protocal.protobuf.cs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.bh.a;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
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
  implements bh.a
{
  private View adC;
  private DisplayMetrics hUu;
  private av irp;
  private int[] isb;
  private String jwH;
  private com.tencent.mm.ui.widget.a.e lBF;
  private Bitmap mBitmap;
  private SensorManager mSensorManager;
  private n.d nXw;
  private String oYa;
  private int retCode;
  private String sZn;
  private Button sZw;
  private String taJ;
  private String taK;
  private int taL;
  private View taW;
  private View taX;
  private ImageView taY;
  private TextView taZ;
  private Bitmap tbA;
  private Bitmap tbB;
  private Bitmap tbC;
  private Bitmap tbD;
  private Bitmap tbE;
  private Bitmap tbF;
  private Bitmap tbG;
  private Bitmap tbH;
  private Bitmap tbI;
  private Bitmap tbJ;
  private Bitmap tbK;
  private com.tencent.mm.particles.b tbL;
  private com.tencent.mm.particles.b tbM;
  final SensorEventListener tbN;
  private TextView tba;
  private ImageView tbb;
  private TextView tbc;
  private TextView tbd;
  private HorizontalListViewV2 tbe;
  private List<String> tbf;
  private Map<String, String> tbg;
  private Queue<Pair<String, Integer>> tbh;
  private a tbi;
  private TextView tbj;
  private ShuffleView tbk;
  private ShuffleView.c tbl;
  private List<View> tbm;
  private ViewGroup tbn;
  private ViewGroup tbo;
  private View tbp;
  private com.tencent.mm.plugin.luckymoney.f2f.a tbq;
  private long tbr;
  private String tbs;
  private ValueAnimator tbt;
  private float tbu;
  private float tbv;
  private float tbw;
  private cc.a tbx;
  private n.c tby;
  private Bitmap tbz;
  
  public LuckyMoneyF2FQRCodeUI()
  {
    AppMethodBeat.i(65085);
    this.tbx = new cc.a()
    {
      public final void a(f.a paramAnonymousa)
      {
        AppMethodBeat.i(65061);
        paramAnonymousa = bw.K(com.tencent.mm.platformtools.z.a(paramAnonymousa.fTo.Cxz), "sysmsg");
        if (paramAnonymousa != null)
        {
          String str1 = (String)paramAnonymousa.get(".sysmsg.sendId");
          final String str2 = (String)paramAnonymousa.get(".sysmsg.username");
          final String str3 = (String)paramAnonymousa.get(".sysmsg.amount");
          final String str4 = (String)paramAnonymousa.get(".sysmsg.receiveId");
          if (bt.getInt((String)paramAnonymousa.get(".sysmsg.islucky"), 0) > 0) {
            LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, str2);
          }
          if (!bt.T(new String[] { str1, str2, str3 })) {
            LuckyMoneyF2FQRCodeUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(65060);
                Object localObject;
                if (!LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).contains(str4))
                {
                  LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).add(0, str4);
                  if (!w.sD(str2))
                  {
                    localObject = new i();
                    ((i)localObject).username = str2;
                    p.auF().b((i)localObject);
                  }
                  LuckyMoneyF2FQRCodeUI.b(LuckyMoneyF2FQRCodeUI.this).put(str4, str2);
                  localObject = LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this);
                  if (((ShuffleView)localObject).tci.size() > 0)
                  {
                    if (((ShuffleView)localObject).tcm.isStarted()) {
                      ((ShuffleView)localObject).tcm.end();
                    }
                    if (((ShuffleView)localObject).oIY.isStarted()) {
                      ((ShuffleView)localObject).oIY.end();
                    }
                    if (((ShuffleView)localObject).isv == null) {
                      break label351;
                    }
                    ((ShuffleView)localObject).tcq = ((ShuffleView)localObject).isv;
                    ((ShuffleView)localObject).tci.remove(((ShuffleView)localObject).tcq);
                    if (((ShuffleView)localObject).tck != null) {
                      ((ShuffleView)localObject).tck.start();
                    }
                    ((ShuffleView)localObject).FR(((ShuffleView)localObject).tcs);
                    if (((ShuffleView)localObject).tcv <= 0) {
                      break label338;
                    }
                    ((ShuffleView)localObject).tcs = ((ShuffleView)localObject).cLl();
                    ((ShuffleView)localObject).isv = ((View)((ShuffleView)localObject).tci.get(((ShuffleView)localObject).tcs));
                  }
                }
                for (;;)
                {
                  LuckyMoneyF2FQRCodeUI.d(LuckyMoneyF2FQRCodeUI.this).remove(LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this).getExitView());
                  LuckyMoneyF2FQRCodeUI.e(LuckyMoneyF2FQRCodeUI.this).av(0L, 60000L);
                  LuckyMoneyF2FQRCodeUI.f(LuckyMoneyF2FQRCodeUI.this).add(new Pair(str2, Integer.valueOf(bt.getInt(str3, 0))));
                  AppMethodBeat.o(65060);
                  return;
                  label338:
                  ((ShuffleView)localObject).isv = null;
                  ((ShuffleView)localObject).tcs = 0;
                  continue;
                  label351:
                  ((ShuffleView)localObject).FP(((ShuffleView)localObject).cLl());
                  ((ShuffleView)localObject).tcq = ((ShuffleView)localObject).isv;
                  ((ShuffleView)localObject).tcm.addListener(new ShuffleView.5((ShuffleView)localObject));
                }
              }
            });
          }
        }
        AppMethodBeat.o(65061);
      }
      
      public final void a(f.c paramAnonymousc) {}
    };
    this.tby = new n.c()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(65073);
        if (bt.isNullOrNil(LuckyMoneyF2FQRCodeUI.g(LuckyMoneyF2FQRCodeUI.this)))
        {
          paramAnonymousl.jj(1, 2131760859);
          AppMethodBeat.o(65073);
          return;
        }
        paramAnonymousl.a(1, LuckyMoneyF2FQRCodeUI.this.getString(2131760859), LuckyMoneyF2FQRCodeUI.g(LuckyMoneyF2FQRCodeUI.this), 0);
        AppMethodBeat.o(65073);
      }
    };
    this.nXw = new n.d()
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
          com.tencent.mm.ui.base.h.cf(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.this.getString(2131760860));
        }
      }
    };
    this.tbL = new com.tencent.mm.particles.b()
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
    this.tbM = new com.tencent.mm.particles.b()
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
    this.tbN = new SensorEventListener()
    {
      float seQ;
      final int tbS;
      float tbT;
      int tbU;
      ValueAnimator tbV;
      
      public final void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt)
      {
        AppMethodBeat.i(65072);
        ad.i("LuckyMoneyF2FQRCodeUI", "onAccuracyChanged");
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
          if (this.tbU == 0) {
            this.tbU = (com.tencent.mm.pluginsdk.g.dL(LuckyMoneyF2FQRCodeUI.this) + (int)this.tbT);
          }
          f2 = paramAnonymousSensorEvent.values[1];
          if (Math.abs(f2 - this.seQ) < 0.05D)
          {
            AppMethodBeat.o(65071);
            return;
          }
          this.seQ = f2;
          ad.d("LuckyMoneyF2FQRCodeUI", "[onSensorChanged] y:%s ", new Object[] { Float.valueOf(f2) });
          if (f2 >= -3.0F) {
            break label246;
          }
        }
        for (;;)
        {
          f1 = f1 / 3.0F * this.tbU + this.tbU;
          ad.d("LuckyMoneyF2FQRCodeUI", "paddingTop:%s nowPaddingTop:%s", new Object[] { Float.valueOf(f1), Integer.valueOf(LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingTop()) });
          if (this.tbV != null) {
            this.tbV.cancel();
          }
          this.tbV = ValueAnimator.ofFloat(new float[] { LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingTop(), f1 }).setDuration(200L);
          this.tbV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
          {
            public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
            {
              AppMethodBeat.i(65069);
              float f = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue();
              LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).setPadding(LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingLeft(), (int)f, LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingRight(), LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingBottom());
              f /= LuckyMoneyF2FQRCodeUI.7.this.tbU;
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
          this.tbV.start();
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
  
  private void cLg()
  {
    AppMethodBeat.i(65087);
    if (!bt.isNullOrNil(this.oYa))
    {
      this.mBitmap = com.tencent.mm.bz.a.a.bT(this, this.oYa);
      this.tbb.setImageBitmap(this.mBitmap);
    }
    if (this.taL <= 0)
    {
      this.tbb.setPadding(com.tencent.mm.cd.a.fromDPToPix(this, 5), com.tencent.mm.cd.a.fromDPToPix(this, 5), com.tencent.mm.cd.a.fromDPToPix(this, 5), com.tencent.mm.cd.a.fromDPToPix(this, 5));
      this.tbb.setImageResource(2131233001);
      this.tbj.setVisibility(8);
      this.sZw.setVisibility(0);
      this.tbc.setVisibility(4);
      this.taW.setPadding(this.taW.getPaddingLeft(), com.tencent.mm.pluginsdk.g.dL(this), this.taW.getPaddingRight(), this.taW.getPaddingBottom());
      if (this.tbf.size() > 0)
      {
        this.tbd.setText(getString(2131760864));
        AppMethodBeat.o(65087);
        return;
      }
      this.tbd.setText(getString(2131760865));
      AppMethodBeat.o(65087);
      return;
    }
    this.tbb.setPadding(0, 0, 0, 0);
    this.tbc.setText(getString(2131760870));
    this.tbc.setVisibility(0);
    this.tbd.setText(getString(2131760870));
    this.tbj.setText(getString(2131760869, new Object[] { Integer.valueOf(this.taL) }));
    this.tbj.setVisibility(0);
    this.sZw.setVisibility(8);
    AppMethodBeat.o(65087);
  }
  
  private void cLh()
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
    com.tencent.mm.plugin.luckymoney.f2f.a locala = this.tbq;
    WeakReference localWeakReference = new WeakReference(this);
    com.tencent.mm.kernel.g.afE().ax(new a.1(locala, localHashSet, localWeakReference));
    locala.tah.setOnLoadCompleteListener(new a.2(locala));
    AppMethodBeat.o(65088);
  }
  
  private void cLi()
  {
    AppMethodBeat.i(65089);
    int i = this.tbe.getWidth() - this.tbf.size() * getResources().getDimensionPixelSize(2131165188);
    if (i > 0)
    {
      this.tbe.setPadding(i / 2, 0, i / 2, 0);
      AppMethodBeat.o(65089);
      return;
    }
    this.tbe.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(65089);
  }
  
  private void cLj()
  {
    AppMethodBeat.i(65090);
    if (this.tbm.size() != this.taL)
    {
      ad.i("LuckyMoneyF2FQRCodeUI", "shuffle cards: %d", new Object[] { Integer.valueOf(this.tbm.size()), Integer.valueOf(this.taL) });
      this.tbm.clear();
      int i = 0;
      while (i < this.taL)
      {
        View localView = LayoutInflater.from(this).inflate(2131494641, this.tbk, false);
        ((FrameLayout.LayoutParams)localView.getLayoutParams()).gravity = 81;
        this.tbm.add(localView);
        i += 1;
      }
      this.tbk.setAllShuffleCards(this.tbm);
    }
    AppMethodBeat.o(65090);
  }
  
  public final void P(String paramString, long paramLong)
  {
    AppMethodBeat.i(187036);
    ad.i("LuckyMoneyF2FQRCodeUI", "screenShot");
    if (this.taL > 0)
    {
      paramString = this.oYa;
      ad.i("LuckyMoneyF2FQRCodeUI", "invalidQRCode");
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.b(paramString), false);
      ad.i("LuckyMoneyF2FQRCodeUI", "getQRCode");
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.e(), false);
      cLg();
      paramString = this.isb;
      paramString[1] += 1;
      com.tencent.mm.ui.base.h.c(this, getString(2131760871), null, true);
    }
    AppMethodBeat.o(187036);
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
    this.hUu = getResources().getDisplayMetrics();
    this.tbf = new ArrayList();
    this.tbg = new HashMap();
    this.tbh = new LinkedList();
    this.tbm = new ArrayList();
    this.isb = new int[6];
    paramBundle = this.isb;
    paramBundle[0] += 1;
    this.irp = new av(new av.a()
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
    this.adC = findViewById(2131301823);
    this.taW = findViewById(2131306989);
    this.tbd = ((TextView)findViewById(2131301819));
    this.tbc = ((TextView)findViewById(2131301820));
    this.tbw = this.tbd.getAlpha();
    this.tbb = ((ImageView)this.adC.findViewById(2131301818));
    this.tbe = ((HorizontalListViewV2)findViewById(2131301821));
    this.tbi = new a((byte)0);
    this.tbe.setAdapter(this.tbi);
    this.tbe.setOnItemClickListener(new LuckyMoneyF2FQRCodeUI.13(this));
    this.tbe.setOnScrollStateChangedListener(new HorizontalListViewV2.d()
    {
      public final void a(HorizontalListViewV2.d.a paramAnonymousa)
      {
        AppMethodBeat.i(65079);
        if ((paramAnonymousa == HorizontalListViewV2.d.a.FVS) && (LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size() >= 5) && (LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size() < LuckyMoneyF2FQRCodeUI.w(LuckyMoneyF2FQRCodeUI.this)) && (LuckyMoneyF2FQRCodeUI.x(LuckyMoneyF2FQRCodeUI.this).getLastVisiblePosition() == LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size() - 1) && (!bt.isNullOrNil(LuckyMoneyF2FQRCodeUI.v(LuckyMoneyF2FQRCodeUI.this))))
        {
          paramAnonymousa = new ah(LuckyMoneyF2FQRCodeUI.v(LuckyMoneyF2FQRCodeUI.this), 5, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size(), null, "v1.0");
          LuckyMoneyF2FQRCodeUI.this.doSceneProgress(paramAnonymousa);
        }
        AppMethodBeat.o(65079);
      }
    });
    this.sZw = ((Button)findViewById(2131301817));
    this.sZw.setOnClickListener(new LuckyMoneyF2FQRCodeUI.15(this));
    this.tbj = ((TextView)findViewById(2131301825));
    this.taX = findViewById(2131301824);
    setBackBtn(new LuckyMoneyF2FQRCodeUI.2(this));
    setMMTitle(getString(2131760872));
    addIconOptionMenu(0, 2131689493, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65063);
        LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, new com.tencent.mm.ui.widget.a.e(LuckyMoneyF2FQRCodeUI.this, 1, false));
        LuckyMoneyF2FQRCodeUI.z(LuckyMoneyF2FQRCodeUI.this).HrX = LuckyMoneyF2FQRCodeUI.y(LuckyMoneyF2FQRCodeUI.this);
        LuckyMoneyF2FQRCodeUI.z(LuckyMoneyF2FQRCodeUI.this).HrY = LuckyMoneyF2FQRCodeUI.A(LuckyMoneyF2FQRCodeUI.this);
        LuckyMoneyF2FQRCodeUI.z(LuckyMoneyF2FQRCodeUI.this).csG();
        AppMethodBeat.o(65063);
        return true;
      }
    });
    setActionbarColor(getResources().getColor(2131100568));
    hideActionbarLine();
    this.tbn = ((ViewGroup)findViewById(2131301812));
    this.tbo = ((ViewGroup)findViewById(2131301811));
    this.tbp = findViewById(2131301814);
    this.tbp.setAlpha(0.0F);
    this.mSensorManager = ((SensorManager)aj.getContext().getSystemService("sensor"));
    this.mSensorManager.registerListener(this.tbN, this.mSensorManager.getDefaultSensor(1), 3);
    this.tbq = new com.tencent.mm.plugin.luckymoney.f2f.a();
    this.tbk = ((ShuffleView)findViewById(2131301826));
    this.tbl = new ShuffleView.c();
    this.tbl.tcK = 4;
    this.tbl.tcI = 2;
    this.tbl.tcJ = 4;
    this.tbl.tcL = 300;
    this.tbl.scaleY = 0.0F;
    this.tbk.setShuffleSetting(this.tbl);
    ShuffleView.hUu = this.hUu;
    paramBundle = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(300L);
    this.tbk.setExitAnimator(paramBundle);
    this.tbk.setExitAnimatorListener(new ShuffleView.a()
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
        if ((paramAnonymousValueAnimator != null) && (!bt.isNullOrNil(LuckyMoneyF2FQRCodeUI.D(LuckyMoneyF2FQRCodeUI.this))) && (LuckyMoneyF2FQRCodeUI.D(LuckyMoneyF2FQRCodeUI.this).equals(paramAnonymousValueAnimator.first))) {
          LuckyMoneyF2FQRCodeUI.E(LuckyMoneyF2FQRCodeUI.this).setAlpha(f);
        }
        ad.i("LuckyMoneyF2FQRCodeUI", "fireworkBottomLayer %f", new Object[] { Float.valueOf(f) });
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
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).oB("packet_received.m4a");
          LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this).removeView(LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this).getExitView());
          LuckyMoneyF2FQRCodeUI.H(LuckyMoneyF2FQRCodeUI.this);
          LuckyMoneyF2FQRCodeUI.I(LuckyMoneyF2FQRCodeUI.this).start();
        }
        AppMethodBeat.o(65064);
      }
    });
    this.tbk.setCardListener(new ShuffleView.b()
    {
      public final void FM(int paramAnonymousInt)
      {
        AppMethodBeat.i(65066);
        LuckyMoneyF2FQRCodeUI.K(LuckyMoneyF2FQRCodeUI.this);
        if (paramAnonymousInt != 8)
        {
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).oB("select_card.m4a");
          arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
          arrayOfInt[3] += 1;
          AppMethodBeat.o(65066);
          return;
        }
        int[] arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
        arrayOfInt[5] += 1;
        AppMethodBeat.o(65066);
      }
      
      public final void fW(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(65065);
        if (paramAnonymousInt2 == 8)
        {
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).oB("music" + (paramAnonymousInt1 + 1) + ".m4a");
          arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
          arrayOfInt[4] += 1;
          AppMethodBeat.o(65065);
          return;
        }
        LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).oB("touch_card.m4a");
        int[] arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
        arrayOfInt[2] += 1;
        AppMethodBeat.o(65065);
      }
      
      public final void fX(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(65067);
        if (paramAnonymousInt2 == 8)
        {
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).oB("music" + (paramAnonymousInt1 + 1) + ".m4a");
          AppMethodBeat.o(65067);
          return;
        }
        LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).oB("select_card.m4a");
        AppMethodBeat.o(65067);
      }
    });
    cLh();
    this.tbt = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.tbt.setDuration(300L);
    this.tbt.setStartDelay(3000L);
    this.tbt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
          LuckyMoneyF2FQRCodeUI.x(LuckyMoneyF2FQRCodeUI.this).eSu();
        }
        AppMethodBeat.o(65068);
      }
    });
    cLg();
    getWindow().addFlags(128);
    AppMethodBeat.o(65086);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65094);
    com.tencent.mm.plugin.report.service.h.vKh.f(14007, new Object[] { Integer.valueOf(this.isb[0]), Integer.valueOf(this.isb[1]), Integer.valueOf(this.isb[2]), Integer.valueOf(this.isb[3]), Integer.valueOf(this.isb[4]), Integer.valueOf(this.isb[5]) });
    com.tencent.mm.plugin.luckymoney.f2f.a locala = this.tbq;
    locala.stopped = true;
    locala.tah.release();
    getWindow().clearFlags(128);
    super.onDestroy();
    AppMethodBeat.o(65094);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(65093);
    super.onPause();
    if (this.mSensorManager != null) {
      this.mSensorManager.unregisterListener(this.tbN);
    }
    AppMethodBeat.o(65093);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65091);
    super.onResume();
    doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.e(), true);
    this.irp.av(60000L, 60000L);
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().a("ffopenwxhb", this.tbx, true);
    addSceneEndListener(1990);
    addSceneEndListener(1987);
    addSceneEndListener(1971);
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    if (localLayoutParams.screenBrightness < 0.85F)
    {
      localLayoutParams.screenBrightness = 0.85F;
      getWindow().setAttributes(localLayoutParams);
    }
    bh.a(this, this);
    if (this.mSensorManager != null) {
      this.mSensorManager.registerListener(this.tbN, this.mSensorManager.getDefaultSensor(1), 3);
    }
    AppMethodBeat.o(65091);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    int i = 0;
    AppMethodBeat.i(65095);
    ad.i("LuckyMoneyF2FQRCodeUI", "errType: %d,errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramn instanceof com.tencent.mm.plugin.luckymoney.f2f.a.e))
      {
        ad.d("LuckyMoneyF2FQRCodeUI", "sendId:" + this.sZn);
        if ((!bt.T(new String[] { this.sZn, ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).sZn })) && (!this.sZn.equals(((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).sZn)))
        {
          this.tbf.clear();
          this.tbg.clear();
          this.tbh.clear();
          this.tbi.notifyDataSetChanged();
          this.tbs = "";
        }
        if (!bt.isNullOrNil(((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).sZn)) {
          this.sZn = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).sZn;
        }
        this.oYa = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).oYa;
        this.taL = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).taL;
        this.taK = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).taK;
        this.taJ = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).taJ;
        cLg();
        cLj();
        if (this.taL == 0) {
          this.irp.stopTimer();
        }
        if ((this.tbf.size() == 0) && (!bt.isNullOrNil(this.sZn))) {
          doSceneProgress(new ah(this.sZn, 5, 0, null, "v1.0"), false);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(65095);
      return true;
      if ((paramn instanceof com.tencent.mm.plugin.luckymoney.f2f.a.a))
      {
        this.sZn = "";
        this.oYa = "";
        this.taL = 0;
        this.tbf.clear();
        this.tbs = "";
        this.tbi.notifyDataSetChanged();
        cLg();
        cLj();
        this.irp.stopTimer();
        if (!bt.isNullOrNil(this.taK)) {
          com.tencent.mm.ui.base.h.cf(this, this.taK);
        }
        this.taJ = "";
      }
      else if ((paramn instanceof ah))
      {
        this.tbr = ((ah)paramn).teT.tdn;
        paramString = ((ah)paramn).teT.tdC;
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramInt1 = i;
          while (paramInt1 < paramString.size())
          {
            paramn = (y)paramString.get(paramInt1);
            if ((!bt.isNullOrNil(paramn.tdq)) && (!this.tbf.contains(paramn.tdq)))
            {
              this.tbf.add(paramn.tdq);
              String str = paramn.userName;
              if (!bt.isNullOrNil(paramn.teI)) {
                this.tbs = str;
              }
              this.tbg.put(paramn.tdq, str);
            }
            paramInt1 += 1;
          }
          cLi();
          this.tbi.notifyDataSetChanged();
        }
      }
      else if ((paramn instanceof com.tencent.mm.plugin.luckymoney.f2f.a.b))
      {
        ad.i("LuckyMoneyF2FQRCodeUI", "onSceneEnd NetSceneF2FLuckyMoneyInvalid");
        this.retCode = ((com.tencent.mm.plugin.luckymoney.f2f.a.b)paramn).dcG;
        this.jwH = ((com.tencent.mm.plugin.luckymoney.f2f.a.b)paramn).nTK;
        ad.i("LuckyMoneyF2FQRCodeUI", "retcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        continue;
        if (!bt.isNullOrNil(paramString)) {
          com.tencent.mm.ui.base.h.c(this, paramString, getString(2131755906), true);
        }
      }
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(65092);
    super.onStop();
    this.irp.stopTimer();
    ((q)com.tencent.mm.kernel.g.ad(q.class)).getSysCmdMsgExtension().b("ffopenwxhb", this.tbx, true);
    removeSceneEndListener(1990);
    removeSceneEndListener(1987);
    removeSceneEndListener(1971);
    bh.a(this, null);
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
        paramViewGroup.ida = ((ImageView)localObject);
        paramViewGroup.tbX = localImageView;
        paramView.setTag(paramViewGroup);
        localObject = (String)LuckyMoneyF2FQRCodeUI.b(LuckyMoneyF2FQRCodeUI.this).get(getItem(paramInt));
        com.tencent.mm.plugin.luckymoney.model.z.b(paramViewGroup.ida, null, (String)localObject);
        if ((bt.isNullOrNil(LuckyMoneyF2FQRCodeUI.D(LuckyMoneyF2FQRCodeUI.this))) || (!LuckyMoneyF2FQRCodeUI.D(LuckyMoneyF2FQRCodeUI.this).equals(localObject))) {
          break label157;
        }
        paramViewGroup.tbX.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(65083);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label157:
        paramViewGroup.tbX.setVisibility(4);
      }
    }
    
    final class a
    {
      ImageView ida;
      ImageView tbX;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI
 * JD-Core Version:    0.7.0.1
 */