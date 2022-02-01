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
import com.tencent.mm.ak.h.a;
import com.tencent.mm.ak.h.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.cj.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.luckymoney.f2f.a.1;
import com.tencent.mm.plugin.luckymoney.f2f.a.2;
import com.tencent.mm.plugin.luckymoney.model.ad;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ao;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.messenger.foundation.a.s;
import com.tencent.mm.protocal.protobuf.de;
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
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
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
  private View agA;
  private MTimerHandler klF;
  private int[] kmr;
  private Bitmap mBitmap;
  private SensorManager mSensorManager;
  private DisplayMetrics metrics;
  private com.tencent.mm.ui.widget.a.e nVN;
  private o.g qAd;
  private String qwG;
  private String rCq;
  private int retCode;
  private String yQE;
  private Button yQO;
  private String yRZ;
  private ShuffleView ySA;
  private ShuffleView.c ySB;
  private List<View> ySC;
  private ViewGroup ySD;
  private ViewGroup ySE;
  private View ySF;
  private com.tencent.mm.plugin.luckymoney.f2f.a ySG;
  private long ySH;
  private String ySI;
  private ValueAnimator ySJ;
  private float ySK;
  private float ySL;
  private float ySM;
  private cj.a ySN;
  private o.f ySO;
  private Bitmap ySP;
  private Bitmap ySQ;
  private Bitmap ySR;
  private Bitmap ySS;
  private Bitmap yST;
  private Bitmap ySU;
  private Bitmap ySV;
  private Bitmap ySW;
  private Bitmap ySX;
  private Bitmap ySY;
  private Bitmap ySZ;
  private String ySa;
  private int ySb;
  private View ySm;
  private View ySn;
  private ImageView ySo;
  private TextView ySp;
  private TextView ySq;
  private ImageView ySr;
  private TextView ySs;
  private TextView ySt;
  private HorizontalListViewV2 ySu;
  private List<String> ySv;
  private Map<String, String> ySw;
  private Queue<Pair<String, Integer>> ySx;
  private a ySy;
  private TextView ySz;
  private Bitmap yTa;
  private com.tencent.mm.particles.b yTb;
  private com.tencent.mm.particles.b yTc;
  final SensorEventListener yTd;
  
  public LuckyMoneyF2FQRCodeUI()
  {
    AppMethodBeat.i(65085);
    this.ySN = new cj.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(65061);
        paramAnonymousa = XmlParser.parseXml(z.a(paramAnonymousa.heO.KHn), "sysmsg", null);
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
                  if (!ab.IS(str2))
                  {
                    localObject = new i();
                    ((i)localObject).username = str2;
                    p.aYB().b((i)localObject);
                  }
                  LuckyMoneyF2FQRCodeUI.b(LuckyMoneyF2FQRCodeUI.this).put(str4, str2);
                  localObject = LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this);
                  if (((ShuffleView)localObject).yTy.size() > 0)
                  {
                    if (((ShuffleView)localObject).yTA.isStarted()) {
                      ((ShuffleView)localObject).yTA.end();
                    }
                    if (((ShuffleView)localObject).rnC.isStarted()) {
                      ((ShuffleView)localObject).rnC.end();
                    }
                    if (((ShuffleView)localObject).kmM == null) {
                      break label351;
                    }
                    ((ShuffleView)localObject).yTE = ((ShuffleView)localObject).kmM;
                    ((ShuffleView)localObject).yTy.remove(((ShuffleView)localObject).yTE);
                    if (((ShuffleView)localObject).tMD != null) {
                      ((ShuffleView)localObject).tMD.start();
                    }
                    ((ShuffleView)localObject).PJ(((ShuffleView)localObject).yTG);
                    if (((ShuffleView)localObject).yTJ <= 0) {
                      break label338;
                    }
                    ((ShuffleView)localObject).yTG = ((ShuffleView)localObject).eeU();
                    ((ShuffleView)localObject).kmM = ((View)((ShuffleView)localObject).yTy.get(((ShuffleView)localObject).yTG));
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
                  ((ShuffleView)localObject).kmM = null;
                  ((ShuffleView)localObject).yTG = 0;
                  continue;
                  label351:
                  ((ShuffleView)localObject).PH(((ShuffleView)localObject).eeU());
                  ((ShuffleView)localObject).yTE = ((ShuffleView)localObject).kmM;
                  ((ShuffleView)localObject).yTA.addListener(new ShuffleView.5((ShuffleView)localObject));
                }
              }
            });
          }
        }
        AppMethodBeat.o(65061);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.ySO = new o.f()
    {
      public final void onCreateMMMenu(m paramAnonymousm)
      {
        AppMethodBeat.i(65073);
        if (Util.isNullOrNil(LuckyMoneyF2FQRCodeUI.g(LuckyMoneyF2FQRCodeUI.this)))
        {
          paramAnonymousm.kV(1, 2131762628);
          AppMethodBeat.o(65073);
          return;
        }
        paramAnonymousm.a(1, LuckyMoneyF2FQRCodeUI.this.getString(2131762628), LuckyMoneyF2FQRCodeUI.g(LuckyMoneyF2FQRCodeUI.this), 0);
        AppMethodBeat.o(65073);
      }
    };
    this.qAd = new o.g()
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
          com.tencent.mm.ui.base.h.cD(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.this.getString(2131762629));
        }
      }
    };
    this.yTb = new com.tencent.mm.particles.b()
    {
      public final com.tencent.mm.particles.a.b a(Random paramAnonymousRandom)
      {
        AppMethodBeat.i(65075);
        int i = paramAnonymousRandom.nextInt(100);
        if (i < 16)
        {
          if (LuckyMoneyF2FQRCodeUI.j(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233660, 36));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.j(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65075);
          return paramAnonymousRandom;
        }
        if (i < 33)
        {
          if (LuckyMoneyF2FQRCodeUI.k(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.b(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233661, 36));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.k(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65075);
          return paramAnonymousRandom;
        }
        if (i < 50)
        {
          if (LuckyMoneyF2FQRCodeUI.l(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233662, 36));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.l(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65075);
          return paramAnonymousRandom;
        }
        if (i < 70)
        {
          if (LuckyMoneyF2FQRCodeUI.m(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.d(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233655, 36));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.m(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65075);
          return paramAnonymousRandom;
        }
        if (i < 90)
        {
          if (LuckyMoneyF2FQRCodeUI.n(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.e(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233656, 36));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.n(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65075);
          return paramAnonymousRandom;
        }
        if (LuckyMoneyF2FQRCodeUI.o(LuckyMoneyF2FQRCodeUI.this) == null) {
          LuckyMoneyF2FQRCodeUI.f(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233657, 36));
        }
        paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.o(LuckyMoneyF2FQRCodeUI.this));
        AppMethodBeat.o(65075);
        return paramAnonymousRandom;
      }
    };
    this.yTc = new com.tencent.mm.particles.b()
    {
      public final com.tencent.mm.particles.a.b a(Random paramAnonymousRandom)
      {
        AppMethodBeat.i(65076);
        int i = paramAnonymousRandom.nextInt(100);
        if (i < 10)
        {
          if (LuckyMoneyF2FQRCodeUI.p(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.g(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233660, 32));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.p(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65076);
          return paramAnonymousRandom;
        }
        if (i < 20)
        {
          if (LuckyMoneyF2FQRCodeUI.q(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.h(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233661, 32));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.q(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65076);
          return paramAnonymousRandom;
        }
        if (i < 30)
        {
          if (LuckyMoneyF2FQRCodeUI.r(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.i(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233662, 32));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.r(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65076);
          return paramAnonymousRandom;
        }
        if (i < 50)
        {
          if (LuckyMoneyF2FQRCodeUI.s(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.j(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233655, 32));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.s(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65076);
          return paramAnonymousRandom;
        }
        if (i < 75)
        {
          if (LuckyMoneyF2FQRCodeUI.t(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.k(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233656, 32));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.t(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(65076);
          return paramAnonymousRandom;
        }
        if (LuckyMoneyF2FQRCodeUI.u(LuckyMoneyF2FQRCodeUI.this) == null) {
          LuckyMoneyF2FQRCodeUI.l(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2131233657, 32));
        }
        paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.u(LuckyMoneyF2FQRCodeUI.this));
        AppMethodBeat.o(65076);
        return paramAnonymousRandom;
      }
    };
    this.yTd = new SensorEventListener()
    {
      float aTE;
      final int yTi;
      float yTj;
      int yTk;
      ValueAnimator yTl;
      
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
          if (this.yTk == 0) {
            this.yTk = (com.tencent.mm.pluginsdk.h.eu(LuckyMoneyF2FQRCodeUI.this) + (int)this.yTj);
          }
          f2 = paramAnonymousSensorEvent.values[1];
          if (Math.abs(f2 - this.aTE) < 0.05D)
          {
            AppMethodBeat.o(65071);
            return;
          }
          this.aTE = f2;
          Log.d("LuckyMoneyF2FQRCodeUI", "[onSensorChanged] y:%s ", new Object[] { Float.valueOf(f2) });
          if (f2 >= -3.0F) {
            break label246;
          }
        }
        for (;;)
        {
          f1 = f1 / 3.0F * this.yTk + this.yTk;
          Log.d("LuckyMoneyF2FQRCodeUI", "paddingTop:%s nowPaddingTop:%s", new Object[] { Float.valueOf(f1), Integer.valueOf(LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingTop()) });
          if (this.yTl != null) {
            this.yTl.cancel();
          }
          this.yTl = ValueAnimator.ofFloat(new float[] { LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingTop(), f1 }).setDuration(200L);
          this.yTl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
          {
            public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
            {
              AppMethodBeat.i(65069);
              float f = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue();
              LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).setPadding(LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingLeft(), (int)f, LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingRight(), LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingBottom());
              f /= LuckyMoneyF2FQRCodeUI.7.this.yTk;
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
          this.yTl.start();
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
  
  private void eeP()
  {
    AppMethodBeat.i(65087);
    if (!Util.isNullOrNil(this.rCq))
    {
      this.mBitmap = com.tencent.mm.by.a.a.ct(this, this.rCq);
      this.ySr.setImageBitmap(this.mBitmap);
    }
    if (this.ySb <= 0)
    {
      this.ySr.setPadding(com.tencent.mm.cb.a.fromDPToPix(this, 5), com.tencent.mm.cb.a.fromDPToPix(this, 5), com.tencent.mm.cb.a.fromDPToPix(this, 5), com.tencent.mm.cb.a.fromDPToPix(this, 5));
      this.ySr.setImageResource(2131233654);
      this.ySz.setVisibility(8);
      this.yQO.setVisibility(0);
      this.ySs.setVisibility(4);
      this.ySm.setPadding(this.ySm.getPaddingLeft(), com.tencent.mm.pluginsdk.h.eu(this), this.ySm.getPaddingRight(), this.ySm.getPaddingBottom());
      if (this.ySv.size() > 0)
      {
        this.ySt.setText(getString(2131762633));
        AppMethodBeat.o(65087);
        return;
      }
      this.ySt.setText(getString(2131762634));
      AppMethodBeat.o(65087);
      return;
    }
    this.ySr.setPadding(0, 0, 0, 0);
    this.ySs.setText(getString(2131762639));
    this.ySs.setVisibility(0);
    this.ySt.setText(getString(2131762639));
    this.ySz.setText(getString(2131762638, new Object[] { Integer.valueOf(this.ySb) }));
    this.ySz.setVisibility(0);
    this.yQO.setVisibility(8);
    AppMethodBeat.o(65087);
  }
  
  private void eeQ()
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
    com.tencent.mm.plugin.luckymoney.f2f.a locala = this.ySG;
    WeakReference localWeakReference = new WeakReference(this);
    g.aAk().postToWorker(new a.1(locala, localHashSet, localWeakReference));
    locala.yRy.setOnLoadCompleteListener(new a.2(locala));
    AppMethodBeat.o(65088);
  }
  
  private void eeR()
  {
    AppMethodBeat.i(65089);
    int i = this.ySu.getWidth() - this.ySv.size() * getResources().getDimensionPixelSize(2131165191);
    if (i > 0)
    {
      this.ySu.setPadding(i / 2, 0, i / 2, 0);
      AppMethodBeat.o(65089);
      return;
    }
    this.ySu.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(65089);
  }
  
  private void eeS()
  {
    AppMethodBeat.i(65090);
    if (this.ySC.size() != this.ySb)
    {
      Log.i("LuckyMoneyF2FQRCodeUI", "shuffle cards: %d", new Object[] { Integer.valueOf(this.ySC.size()), Integer.valueOf(this.ySb) });
      this.ySC.clear();
      int i = 0;
      while (i < this.ySb)
      {
        View localView = LayoutInflater.from(this).inflate(2131495363, this.ySA, false);
        ((FrameLayout.LayoutParams)localView.getLayoutParams()).gravity = 81;
        this.ySC.add(localView);
        i += 1;
      }
      this.ySA.setAllShuffleCards(this.ySC);
    }
    AppMethodBeat.o(65090);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131495364;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65086);
    super.onCreate(paramBundle);
    this.metrics = getResources().getDisplayMetrics();
    this.ySv = new ArrayList();
    this.ySw = new HashMap();
    this.ySx = new LinkedList();
    this.ySC = new ArrayList();
    this.kmr = new int[6];
    paramBundle = this.kmr;
    paramBundle[0] += 1;
    this.klF = new MTimerHandler(new MTimerHandler.CallBack()
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
    this.agA = findViewById(2131304134);
    this.ySm = findViewById(2131310490);
    this.ySt = ((TextView)findViewById(2131304130));
    this.ySs = ((TextView)findViewById(2131304131));
    this.ySM = this.ySt.getAlpha();
    this.ySr = ((ImageView)this.agA.findViewById(2131304129));
    this.ySu = ((HorizontalListViewV2)findViewById(2131304132));
    this.ySy = new a((byte)0);
    this.ySu.setAdapter(this.ySy);
    this.ySu.setOnItemClickListener(new LuckyMoneyF2FQRCodeUI.13(this));
    this.ySu.setOnScrollStateChangedListener(new HorizontalListViewV2.d()
    {
      public final void a(HorizontalListViewV2.d.a paramAnonymousa)
      {
        AppMethodBeat.i(65079);
        if ((paramAnonymousa == HorizontalListViewV2.d.a.OPc) && (LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size() >= 5) && (LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size() < LuckyMoneyF2FQRCodeUI.w(LuckyMoneyF2FQRCodeUI.this)) && (LuckyMoneyF2FQRCodeUI.x(LuckyMoneyF2FQRCodeUI.this).getLastVisiblePosition() == LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size() - 1) && (!Util.isNullOrNil(LuckyMoneyF2FQRCodeUI.v(LuckyMoneyF2FQRCodeUI.this))))
        {
          paramAnonymousa = new ao(LuckyMoneyF2FQRCodeUI.v(LuckyMoneyF2FQRCodeUI.this), 5, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size(), null, "v1.0");
          LuckyMoneyF2FQRCodeUI.this.doSceneProgress(paramAnonymousa);
        }
        AppMethodBeat.o(65079);
      }
    });
    this.yQO = ((Button)findViewById(2131304128));
    this.yQO.setOnClickListener(new LuckyMoneyF2FQRCodeUI.15(this));
    this.ySz = ((TextView)findViewById(2131304136));
    this.ySn = findViewById(2131304135);
    setBackBtn(new LuckyMoneyF2FQRCodeUI.2(this));
    setMMTitle(getString(2131762641));
    addIconOptionMenu(0, 2131689495, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65063);
        LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, new com.tencent.mm.ui.widget.a.e(LuckyMoneyF2FQRCodeUI.this, 1, false));
        LuckyMoneyF2FQRCodeUI.z(LuckyMoneyF2FQRCodeUI.this).HLX = LuckyMoneyF2FQRCodeUI.y(LuckyMoneyF2FQRCodeUI.this);
        LuckyMoneyF2FQRCodeUI.z(LuckyMoneyF2FQRCodeUI.this).HLY = LuckyMoneyF2FQRCodeUI.A(LuckyMoneyF2FQRCodeUI.this);
        LuckyMoneyF2FQRCodeUI.z(LuckyMoneyF2FQRCodeUI.this).dGm();
        AppMethodBeat.o(65063);
        return true;
      }
    });
    setActionbarColor(getResources().getColor(2131100736));
    hideActionbarLine();
    this.ySD = ((ViewGroup)findViewById(2131304123));
    this.ySE = ((ViewGroup)findViewById(2131304122));
    this.ySF = findViewById(2131304125);
    this.ySF.setAlpha(0.0F);
    this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
    this.mSensorManager.registerListener(this.yTd, this.mSensorManager.getDefaultSensor(1), 3);
    this.ySG = new com.tencent.mm.plugin.luckymoney.f2f.a();
    this.ySA = ((ShuffleView)findViewById(2131304137));
    this.ySB = new ShuffleView.c();
    this.ySB.yTY = 4;
    this.ySB.yTW = 2;
    this.ySB.yTX = 4;
    this.ySB.yTZ = 300;
    this.ySB.scaleY = 0.0F;
    this.ySA.setShuffleSetting(this.ySB);
    ShuffleView.metrics = this.metrics;
    paramBundle = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(300L);
    this.ySA.setExitAnimator(paramBundle);
    this.ySA.setExitAnimatorListener(new ShuffleView.a()
    {
      public final void a(ValueAnimator paramAnonymousValueAnimator, View paramAnonymousView)
      {
        AppMethodBeat.i(65064);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        if (f == 0.0F)
        {
          LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, paramAnonymousView.getTranslationX());
          LuckyMoneyF2FQRCodeUI.b(LuckyMoneyF2FQRCodeUI.this, paramAnonymousView.getTranslationY());
          paramAnonymousView.findViewById(2131304138).setVisibility(0);
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
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).Df("packet_received.m4a");
          LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this).removeView(LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this).getExitView());
          LuckyMoneyF2FQRCodeUI.H(LuckyMoneyF2FQRCodeUI.this);
          LuckyMoneyF2FQRCodeUI.I(LuckyMoneyF2FQRCodeUI.this).start();
        }
        AppMethodBeat.o(65064);
      }
    });
    this.ySA.setCardListener(new ShuffleView.b()
    {
      public final void PE(int paramAnonymousInt)
      {
        AppMethodBeat.i(65066);
        LuckyMoneyF2FQRCodeUI.K(LuckyMoneyF2FQRCodeUI.this);
        if (paramAnonymousInt != 8)
        {
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).Df("select_card.m4a");
          arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
          arrayOfInt[3] += 1;
          AppMethodBeat.o(65066);
          return;
        }
        int[] arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
        arrayOfInt[5] += 1;
        AppMethodBeat.o(65066);
      }
      
      public final void gS(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(65065);
        if (paramAnonymousInt2 == 8)
        {
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).Df("music" + (paramAnonymousInt1 + 1) + ".m4a");
          arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
          arrayOfInt[4] += 1;
          AppMethodBeat.o(65065);
          return;
        }
        LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).Df("touch_card.m4a");
        int[] arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
        arrayOfInt[2] += 1;
        AppMethodBeat.o(65065);
      }
      
      public final void gT(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(65067);
        if (paramAnonymousInt2 == 8)
        {
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).Df("music" + (paramAnonymousInt1 + 1) + ".m4a");
          AppMethodBeat.o(65067);
          return;
        }
        LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).Df("select_card.m4a");
        AppMethodBeat.o(65067);
      }
    });
    eeQ();
    this.ySJ = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.ySJ.setDuration(300L);
    this.ySJ.setStartDelay(3000L);
    this.ySJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
          LuckyMoneyF2FQRCodeUI.x(LuckyMoneyF2FQRCodeUI.this).gKt();
        }
        AppMethodBeat.o(65068);
      }
    });
    eeP();
    getWindow().addFlags(128);
    AppMethodBeat.o(65086);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65094);
    com.tencent.mm.plugin.report.service.h.CyF.a(14007, new Object[] { Integer.valueOf(this.kmr[0]), Integer.valueOf(this.kmr[1]), Integer.valueOf(this.kmr[2]), Integer.valueOf(this.kmr[3]), Integer.valueOf(this.kmr[4]), Integer.valueOf(this.kmr[5]) });
    com.tencent.mm.plugin.luckymoney.f2f.a locala = this.ySG;
    locala.stopped = true;
    locala.yRy.release();
    getWindow().clearFlags(128);
    super.onDestroy();
    AppMethodBeat.o(65094);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(65093);
    super.onPause();
    if (this.mSensorManager != null) {
      this.mSensorManager.unregisterListener(this.yTd);
    }
    AppMethodBeat.o(65093);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65091);
    super.onResume();
    doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.e(), true);
    this.klF.startTimer(60000L);
    ((s)g.ah(s.class)).getSysCmdMsgExtension().a("ffopenwxhb", this.ySN, true);
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
      this.mSensorManager.registerListener(this.yTd, this.mSensorManager.getDefaultSensor(1), 3);
    }
    AppMethodBeat.o(65091);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    int i = 0;
    AppMethodBeat.i(65095);
    Log.i("LuckyMoneyF2FQRCodeUI", "errType: %d,errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramq instanceof com.tencent.mm.plugin.luckymoney.f2f.a.e))
      {
        Log.d("LuckyMoneyF2FQRCodeUI", "sendId:" + this.yQE);
        if ((!Util.isNullOrNil(new String[] { this.yQE, ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramq).yQE })) && (!this.yQE.equals(((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramq).yQE)))
        {
          this.ySv.clear();
          this.ySw.clear();
          this.ySx.clear();
          this.ySy.notifyDataSetChanged();
          this.ySI = "";
        }
        if (!Util.isNullOrNil(((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramq).yQE)) {
          this.yQE = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramq).yQE;
        }
        this.rCq = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramq).rCq;
        this.ySb = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramq).ySb;
        this.ySa = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramq).ySa;
        this.yRZ = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramq).yRZ;
        eeP();
        eeS();
        if (this.ySb == 0) {
          this.klF.stopTimer();
        }
        if ((this.ySv.size() == 0) && (!Util.isNullOrNil(this.yQE))) {
          doSceneProgress(new ao(this.yQE, 5, 0, null, "v1.0"), false);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(65095);
      return true;
      if ((paramq instanceof com.tencent.mm.plugin.luckymoney.f2f.a.a))
      {
        this.yQE = "";
        this.rCq = "";
        this.ySb = 0;
        this.ySv.clear();
        this.ySI = "";
        this.ySy.notifyDataSetChanged();
        eeP();
        eeS();
        this.klF.stopTimer();
        if (!Util.isNullOrNil(this.ySa)) {
          com.tencent.mm.ui.base.h.cD(this, this.ySa);
        }
        this.yRZ = "";
      }
      else if ((paramq instanceof ao))
      {
        this.ySH = ((ao)paramq).yWT.yVh;
        paramString = ((ao)paramq).yWT.yVw;
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramInt1 = i;
          while (paramInt1 < paramString.size())
          {
            paramq = (ad)paramString.get(paramInt1);
            if ((!Util.isNullOrNil(paramq.yVk)) && (!this.ySv.contains(paramq.yVk)))
            {
              this.ySv.add(paramq.yVk);
              String str = paramq.userName;
              if (!Util.isNullOrNil(paramq.yWG)) {
                this.ySI = str;
              }
              this.ySw.put(paramq.yVk, str);
            }
            paramInt1 += 1;
          }
          eeR();
          this.ySy.notifyDataSetChanged();
        }
      }
      else if ((paramq instanceof com.tencent.mm.plugin.luckymoney.f2f.a.b))
      {
        Log.i("LuckyMoneyF2FQRCodeUI", "onSceneEnd NetSceneF2FLuckyMoneyInvalid");
        this.retCode = ((com.tencent.mm.plugin.luckymoney.f2f.a.b)paramq).dDN;
        this.qwG = ((com.tencent.mm.plugin.luckymoney.f2f.a.b)paramq).qwn;
        Log.i("LuckyMoneyF2FQRCodeUI", "retcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        continue;
        if (!Util.isNullOrNil(paramString)) {
          com.tencent.mm.ui.base.h.c(this, paramString, getString(2131755998), true);
        }
      }
    }
  }
  
  public void onScreenShot(String paramString, long paramLong)
  {
    AppMethodBeat.i(213265);
    Log.i("LuckyMoneyF2FQRCodeUI", "screenShot");
    if (this.ySb > 0)
    {
      paramString = this.rCq;
      Log.i("LuckyMoneyF2FQRCodeUI", "invalidQRCode");
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.b(paramString), false);
      Log.i("LuckyMoneyF2FQRCodeUI", "getQRCode");
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.e(), false);
      eeP();
      paramString = this.kmr;
      paramString[1] += 1;
      com.tencent.mm.ui.base.h.c(this, getString(2131762640), null, true);
    }
    AppMethodBeat.o(213265);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(65092);
    super.onStop();
    this.klF.stopTimer();
    ((s)g.ah(s.class)).getSysCmdMsgExtension().b("ffopenwxhb", this.ySN, true);
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
        paramView = LayoutInflater.from(LuckyMoneyF2FQRCodeUI.this).inflate(2131495366, null);
        Object localObject = (ImageView)paramView.findViewById(2131304133);
        ImageView localImageView = (ImageView)paramView.findViewById(2131304126);
        paramViewGroup = new a();
        paramViewGroup.jWS = ((ImageView)localObject);
        paramViewGroup.yTn = localImageView;
        paramView.setTag(paramViewGroup);
        localObject = (String)LuckyMoneyF2FQRCodeUI.b(LuckyMoneyF2FQRCodeUI.this).get(getItem(paramInt));
        af.a(paramViewGroup.jWS, null, (String)localObject);
        if ((Util.isNullOrNil(LuckyMoneyF2FQRCodeUI.D(LuckyMoneyF2FQRCodeUI.this))) || (!LuckyMoneyF2FQRCodeUI.D(LuckyMoneyF2FQRCodeUI.this).equals(localObject))) {
          break label157;
        }
        paramViewGroup.yTn.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(65083);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label157:
        paramViewGroup.yTn.setVisibility(4);
      }
    }
    
    final class a
    {
      ImageView jWS;
      ImageView yTn;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI
 * JD-Core Version:    0.7.0.1
 */