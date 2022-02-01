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
import com.tencent.mm.al.e.a;
import com.tencent.mm.al.e.c;
import com.tencent.mm.al.n;
import com.tencent.mm.model.cd;
import com.tencent.mm.model.cd.a;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.luckymoney.f2f.a.1;
import com.tencent.mm.plugin.luckymoney.f2f.a.2;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.y;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.protocal.protobuf.cv;
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
  implements bh.a
{
  private View agn;
  private DisplayMetrics iNB;
  private av jkD;
  private int[] jlo;
  private String krz;
  private Bitmap mBitmap;
  private com.tencent.mm.ui.widget.a.e mDL;
  private SensorManager mSensorManager;
  private n.e pem;
  private String qeQ;
  private int retCode;
  private String vkl;
  private Button vku;
  private String vlG;
  private String vlH;
  private int vlI;
  private View vlT;
  private View vlU;
  private ImageView vlV;
  private TextView vlW;
  private TextView vlX;
  private ImageView vlY;
  private TextView vlZ;
  private Bitmap vmA;
  private Bitmap vmB;
  private Bitmap vmC;
  private Bitmap vmD;
  private Bitmap vmE;
  private Bitmap vmF;
  private Bitmap vmG;
  private Bitmap vmH;
  private com.tencent.mm.particles.b vmI;
  private com.tencent.mm.particles.b vmJ;
  final SensorEventListener vmK;
  private TextView vma;
  private HorizontalListViewV2 vmb;
  private List<String> vmc;
  private Map<String, String> vmd;
  private Queue<Pair<String, Integer>> vme;
  private a vmf;
  private TextView vmg;
  private ShuffleView vmh;
  private ShuffleView.c vmi;
  private List<View> vmj;
  private ViewGroup vmk;
  private ViewGroup vml;
  private View vmm;
  private com.tencent.mm.plugin.luckymoney.f2f.a vmn;
  private long vmo;
  private String vmp;
  private ValueAnimator vmq;
  private float vmr;
  private float vms;
  private float vmt;
  private cd.a vmu;
  private n.d vmv;
  private Bitmap vmw;
  private Bitmap vmx;
  private Bitmap vmy;
  private Bitmap vmz;
  
  public LuckyMoneyF2FQRCodeUI()
  {
    AppMethodBeat.i(65085);
    this.vmu = new cd.a()
    {
      public final void a(e.a paramAnonymousa)
      {
        AppMethodBeat.i(65061);
        paramAnonymousa = bw.M(com.tencent.mm.platformtools.z.a(paramAnonymousa.gqE.Fvk), "sysmsg");
        if (paramAnonymousa != null)
        {
          String str1 = (String)paramAnonymousa.get(".sysmsg.sendId");
          final String str2 = (String)paramAnonymousa.get(".sysmsg.username");
          final String str3 = (String)paramAnonymousa.get(".sysmsg.amount");
          final String str4 = (String)paramAnonymousa.get(".sysmsg.receiveId");
          if (bt.getInt((String)paramAnonymousa.get(".sysmsg.islucky"), 0) > 0) {
            LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, str2);
          }
          if (!bt.V(new String[] { str1, str2, str3 })) {
            LuckyMoneyF2FQRCodeUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(65060);
                Object localObject;
                if (!LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).contains(str4))
                {
                  LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).add(0, str4);
                  if (!w.zD(str2))
                  {
                    localObject = new i();
                    ((i)localObject).username = str2;
                    p.aEx().b((i)localObject);
                  }
                  LuckyMoneyF2FQRCodeUI.b(LuckyMoneyF2FQRCodeUI.this).put(str4, str2);
                  localObject = LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this);
                  if (((ShuffleView)localObject).vnf.size() > 0)
                  {
                    if (((ShuffleView)localObject).vnh.isStarted()) {
                      ((ShuffleView)localObject).vnh.end();
                    }
                    if (((ShuffleView)localObject).pPY.isStarted()) {
                      ((ShuffleView)localObject).pPY.end();
                    }
                    if (((ShuffleView)localObject).jlI == null) {
                      break label351;
                    }
                    ((ShuffleView)localObject).vnl = ((ShuffleView)localObject).jlI;
                    ((ShuffleView)localObject).vnf.remove(((ShuffleView)localObject).vnl);
                    if (((ShuffleView)localObject).rUu != null) {
                      ((ShuffleView)localObject).rUu.start();
                    }
                    ((ShuffleView)localObject).Ji(((ShuffleView)localObject).vnn);
                    if (((ShuffleView)localObject).vnq <= 0) {
                      break label338;
                    }
                    ((ShuffleView)localObject).vnn = ((ShuffleView)localObject).did();
                    ((ShuffleView)localObject).jlI = ((View)((ShuffleView)localObject).vnf.get(((ShuffleView)localObject).vnn));
                  }
                }
                for (;;)
                {
                  LuckyMoneyF2FQRCodeUI.d(LuckyMoneyF2FQRCodeUI.this).remove(LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this).getExitView());
                  LuckyMoneyF2FQRCodeUI.e(LuckyMoneyF2FQRCodeUI.this).az(0L, 60000L);
                  LuckyMoneyF2FQRCodeUI.f(LuckyMoneyF2FQRCodeUI.this).add(new Pair(str2, Integer.valueOf(bt.getInt(str3, 0))));
                  AppMethodBeat.o(65060);
                  return;
                  label338:
                  ((ShuffleView)localObject).jlI = null;
                  ((ShuffleView)localObject).vnn = 0;
                  continue;
                  label351:
                  ((ShuffleView)localObject).Jg(((ShuffleView)localObject).did());
                  ((ShuffleView)localObject).vnl = ((ShuffleView)localObject).jlI;
                  ((ShuffleView)localObject).vnh.addListener(new ShuffleView.5((ShuffleView)localObject));
                }
              }
            });
          }
        }
        AppMethodBeat.o(65061);
      }
      
      public final void a(e.c paramAnonymousc) {}
    };
    this.vmv = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(65073);
        if (bt.isNullOrNil(LuckyMoneyF2FQRCodeUI.g(LuckyMoneyF2FQRCodeUI.this)))
        {
          paramAnonymousl.jI(1, 2131760859);
          AppMethodBeat.o(65073);
          return;
        }
        paramAnonymousl.a(1, LuckyMoneyF2FQRCodeUI.this.getString(2131760859), LuckyMoneyF2FQRCodeUI.g(LuckyMoneyF2FQRCodeUI.this), 0);
        AppMethodBeat.o(65073);
      }
    };
    this.pem = new n.e()
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
          com.tencent.mm.ui.base.h.cl(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.this.getString(2131760860));
        }
      }
    };
    this.vmI = new com.tencent.mm.particles.b()
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
    this.vmJ = new com.tencent.mm.particles.b()
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
    this.vmK = new SensorEventListener()
    {
      float aTM;
      final int vmP;
      float vmQ;
      int vmR;
      ValueAnimator vmS;
      
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
          if (this.vmR == 0) {
            this.vmR = (com.tencent.mm.pluginsdk.h.dT(LuckyMoneyF2FQRCodeUI.this) + (int)this.vmQ);
          }
          f2 = paramAnonymousSensorEvent.values[1];
          if (Math.abs(f2 - this.aTM) < 0.05D)
          {
            AppMethodBeat.o(65071);
            return;
          }
          this.aTM = f2;
          ad.d("LuckyMoneyF2FQRCodeUI", "[onSensorChanged] y:%s ", new Object[] { Float.valueOf(f2) });
          if (f2 >= -3.0F) {
            break label246;
          }
        }
        for (;;)
        {
          f1 = f1 / 3.0F * this.vmR + this.vmR;
          ad.d("LuckyMoneyF2FQRCodeUI", "paddingTop:%s nowPaddingTop:%s", new Object[] { Float.valueOf(f1), Integer.valueOf(LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingTop()) });
          if (this.vmS != null) {
            this.vmS.cancel();
          }
          this.vmS = ValueAnimator.ofFloat(new float[] { LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingTop(), f1 }).setDuration(200L);
          this.vmS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
          {
            public final void onAnimationUpdate(ValueAnimator paramAnonymous2ValueAnimator)
            {
              AppMethodBeat.i(65069);
              float f = ((Float)paramAnonymous2ValueAnimator.getAnimatedValue()).floatValue();
              LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).setPadding(LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingLeft(), (int)f, LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingRight(), LuckyMoneyF2FQRCodeUI.O(LuckyMoneyF2FQRCodeUI.this).getPaddingBottom());
              f /= LuckyMoneyF2FQRCodeUI.7.this.vmR;
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
          this.vmS.start();
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
  
  private void dhY()
  {
    AppMethodBeat.i(65087);
    if (!bt.isNullOrNil(this.qeQ))
    {
      this.mBitmap = com.tencent.mm.bz.a.a.bY(this, this.qeQ);
      this.vlY.setImageBitmap(this.mBitmap);
    }
    if (this.vlI <= 0)
    {
      this.vlY.setPadding(com.tencent.mm.cc.a.fromDPToPix(this, 5), com.tencent.mm.cc.a.fromDPToPix(this, 5), com.tencent.mm.cc.a.fromDPToPix(this, 5), com.tencent.mm.cc.a.fromDPToPix(this, 5));
      this.vlY.setImageResource(2131233001);
      this.vmg.setVisibility(8);
      this.vku.setVisibility(0);
      this.vlZ.setVisibility(4);
      this.vlT.setPadding(this.vlT.getPaddingLeft(), com.tencent.mm.pluginsdk.h.dT(this), this.vlT.getPaddingRight(), this.vlT.getPaddingBottom());
      if (this.vmc.size() > 0)
      {
        this.vma.setText(getString(2131760864));
        AppMethodBeat.o(65087);
        return;
      }
      this.vma.setText(getString(2131760865));
      AppMethodBeat.o(65087);
      return;
    }
    this.vlY.setPadding(0, 0, 0, 0);
    this.vlZ.setText(getString(2131760870));
    this.vlZ.setVisibility(0);
    this.vma.setText(getString(2131760870));
    this.vmg.setText(getString(2131760869, new Object[] { Integer.valueOf(this.vlI) }));
    this.vmg.setVisibility(0);
    this.vku.setVisibility(8);
    AppMethodBeat.o(65087);
  }
  
  private void dhZ()
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
    com.tencent.mm.plugin.luckymoney.f2f.a locala = this.vmn;
    WeakReference localWeakReference = new WeakReference(this);
    com.tencent.mm.kernel.g.ajF().ay(new a.1(locala, localHashSet, localWeakReference));
    locala.vle.setOnLoadCompleteListener(new a.2(locala));
    AppMethodBeat.o(65088);
  }
  
  private void dia()
  {
    AppMethodBeat.i(65089);
    int i = this.vmb.getWidth() - this.vmc.size() * getResources().getDimensionPixelSize(2131165188);
    if (i > 0)
    {
      this.vmb.setPadding(i / 2, 0, i / 2, 0);
      AppMethodBeat.o(65089);
      return;
    }
    this.vmb.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(65089);
  }
  
  private void dib()
  {
    AppMethodBeat.i(65090);
    if (this.vmj.size() != this.vlI)
    {
      ad.i("LuckyMoneyF2FQRCodeUI", "shuffle cards: %d", new Object[] { Integer.valueOf(this.vmj.size()), Integer.valueOf(this.vlI) });
      this.vmj.clear();
      int i = 0;
      while (i < this.vlI)
      {
        View localView = LayoutInflater.from(this).inflate(2131494641, this.vmh, false);
        ((FrameLayout.LayoutParams)localView.getLayoutParams()).gravity = 81;
        this.vmj.add(localView);
        i += 1;
      }
      this.vmh.setAllShuffleCards(this.vmj);
    }
    AppMethodBeat.o(65090);
  }
  
  public final void X(String paramString, long paramLong)
  {
    AppMethodBeat.i(199002);
    ad.i("LuckyMoneyF2FQRCodeUI", "screenShot");
    if (this.vlI > 0)
    {
      paramString = this.qeQ;
      ad.i("LuckyMoneyF2FQRCodeUI", "invalidQRCode");
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.b(paramString), false);
      ad.i("LuckyMoneyF2FQRCodeUI", "getQRCode");
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.e(), false);
      dhY();
      paramString = this.jlo;
      paramString[1] += 1;
      com.tencent.mm.ui.base.h.c(this, getString(2131760871), null, true);
    }
    AppMethodBeat.o(199002);
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
    this.iNB = getResources().getDisplayMetrics();
    this.vmc = new ArrayList();
    this.vmd = new HashMap();
    this.vme = new LinkedList();
    this.vmj = new ArrayList();
    this.jlo = new int[6];
    paramBundle = this.jlo;
    paramBundle[0] += 1;
    this.jkD = new av(new av.a()
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
    this.vlT = findViewById(2131306989);
    this.vma = ((TextView)findViewById(2131301819));
    this.vlZ = ((TextView)findViewById(2131301820));
    this.vmt = this.vma.getAlpha();
    this.vlY = ((ImageView)this.agn.findViewById(2131301818));
    this.vmb = ((HorizontalListViewV2)findViewById(2131301821));
    this.vmf = new a((byte)0);
    this.vmb.setAdapter(this.vmf);
    this.vmb.setOnItemClickListener(new LuckyMoneyF2FQRCodeUI.13(this));
    this.vmb.setOnScrollStateChangedListener(new HorizontalListViewV2.d()
    {
      public final void a(HorizontalListViewV2.d.a paramAnonymousa)
      {
        AppMethodBeat.i(65079);
        if ((paramAnonymousa == HorizontalListViewV2.d.a.Jjw) && (LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size() >= 5) && (LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size() < LuckyMoneyF2FQRCodeUI.w(LuckyMoneyF2FQRCodeUI.this)) && (LuckyMoneyF2FQRCodeUI.x(LuckyMoneyF2FQRCodeUI.this).getLastVisiblePosition() == LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size() - 1) && (!bt.isNullOrNil(LuckyMoneyF2FQRCodeUI.v(LuckyMoneyF2FQRCodeUI.this))))
        {
          paramAnonymousa = new ah(LuckyMoneyF2FQRCodeUI.v(LuckyMoneyF2FQRCodeUI.this), 5, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size(), null, "v1.0");
          LuckyMoneyF2FQRCodeUI.this.doSceneProgress(paramAnonymousa);
        }
        AppMethodBeat.o(65079);
      }
    });
    this.vku = ((Button)findViewById(2131301817));
    this.vku.setOnClickListener(new LuckyMoneyF2FQRCodeUI.15(this));
    this.vmg = ((TextView)findViewById(2131301825));
    this.vlU = findViewById(2131301824);
    setBackBtn(new LuckyMoneyF2FQRCodeUI.2(this));
    setMMTitle(getString(2131760872));
    addIconOptionMenu(0, 2131689493, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65063);
        LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, new com.tencent.mm.ui.widget.a.e(LuckyMoneyF2FQRCodeUI.this, 1, false));
        LuckyMoneyF2FQRCodeUI.z(LuckyMoneyF2FQRCodeUI.this).KJy = LuckyMoneyF2FQRCodeUI.y(LuckyMoneyF2FQRCodeUI.this);
        LuckyMoneyF2FQRCodeUI.z(LuckyMoneyF2FQRCodeUI.this).KJz = LuckyMoneyF2FQRCodeUI.A(LuckyMoneyF2FQRCodeUI.this);
        LuckyMoneyF2FQRCodeUI.z(LuckyMoneyF2FQRCodeUI.this).cMW();
        AppMethodBeat.o(65063);
        return true;
      }
    });
    setActionbarColor(getResources().getColor(2131100568));
    hideActionbarLine();
    this.vmk = ((ViewGroup)findViewById(2131301812));
    this.vml = ((ViewGroup)findViewById(2131301811));
    this.vmm = findViewById(2131301814);
    this.vmm.setAlpha(0.0F);
    this.mSensorManager = ((SensorManager)aj.getContext().getSystemService("sensor"));
    this.mSensorManager.registerListener(this.vmK, this.mSensorManager.getDefaultSensor(1), 3);
    this.vmn = new com.tencent.mm.plugin.luckymoney.f2f.a();
    this.vmh = ((ShuffleView)findViewById(2131301826));
    this.vmi = new ShuffleView.c();
    this.vmi.vnF = 4;
    this.vmi.vnD = 2;
    this.vmi.vnE = 4;
    this.vmi.vnG = 300;
    this.vmi.scaleY = 0.0F;
    this.vmh.setShuffleSetting(this.vmi);
    ShuffleView.iNB = this.iNB;
    paramBundle = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(300L);
    this.vmh.setExitAnimator(paramBundle);
    this.vmh.setExitAnimatorListener(new ShuffleView.a()
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
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).uu("packet_received.m4a");
          LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this).removeView(LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this).getExitView());
          LuckyMoneyF2FQRCodeUI.H(LuckyMoneyF2FQRCodeUI.this);
          LuckyMoneyF2FQRCodeUI.I(LuckyMoneyF2FQRCodeUI.this).start();
        }
        AppMethodBeat.o(65064);
      }
    });
    this.vmh.setCardListener(new ShuffleView.b()
    {
      public final void Jd(int paramAnonymousInt)
      {
        AppMethodBeat.i(65066);
        LuckyMoneyF2FQRCodeUI.K(LuckyMoneyF2FQRCodeUI.this);
        if (paramAnonymousInt != 8)
        {
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).uu("select_card.m4a");
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
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).uu("music" + (paramAnonymousInt1 + 1) + ".m4a");
          arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
          arrayOfInt[4] += 1;
          AppMethodBeat.o(65065);
          return;
        }
        LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).uu("touch_card.m4a");
        int[] arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
        arrayOfInt[2] += 1;
        AppMethodBeat.o(65065);
      }
      
      public final void gv(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(65067);
        if (paramAnonymousInt2 == 8)
        {
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).uu("music" + (paramAnonymousInt1 + 1) + ".m4a");
          AppMethodBeat.o(65067);
          return;
        }
        LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).uu("select_card.m4a");
        AppMethodBeat.o(65067);
      }
    });
    dhZ();
    this.vmq = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.vmq.setDuration(300L);
    this.vmq.setStartDelay(3000L);
    this.vmq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
          LuckyMoneyF2FQRCodeUI.x(LuckyMoneyF2FQRCodeUI.this).fyt();
        }
        AppMethodBeat.o(65068);
      }
    });
    dhY();
    getWindow().addFlags(128);
    AppMethodBeat.o(65086);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65094);
    com.tencent.mm.plugin.report.service.g.yhR.f(14007, new Object[] { Integer.valueOf(this.jlo[0]), Integer.valueOf(this.jlo[1]), Integer.valueOf(this.jlo[2]), Integer.valueOf(this.jlo[3]), Integer.valueOf(this.jlo[4]), Integer.valueOf(this.jlo[5]) });
    com.tencent.mm.plugin.luckymoney.f2f.a locala = this.vmn;
    locala.stopped = true;
    locala.vle.release();
    getWindow().clearFlags(128);
    super.onDestroy();
    AppMethodBeat.o(65094);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(65093);
    super.onPause();
    if (this.mSensorManager != null) {
      this.mSensorManager.unregisterListener(this.vmK);
    }
    AppMethodBeat.o(65093);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65091);
    super.onResume();
    doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.e(), true);
    this.jkD.az(60000L, 60000L);
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().a("ffopenwxhb", this.vmu, true);
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
      this.mSensorManager.registerListener(this.vmK, this.mSensorManager.getDefaultSensor(1), 3);
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
        ad.d("LuckyMoneyF2FQRCodeUI", "sendId:" + this.vkl);
        if ((!bt.V(new String[] { this.vkl, ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).vkl })) && (!this.vkl.equals(((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).vkl)))
        {
          this.vmc.clear();
          this.vmd.clear();
          this.vme.clear();
          this.vmf.notifyDataSetChanged();
          this.vmp = "";
        }
        if (!bt.isNullOrNil(((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).vkl)) {
          this.vkl = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).vkl;
        }
        this.qeQ = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).qeQ;
        this.vlI = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).vlI;
        this.vlH = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).vlH;
        this.vlG = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramn).vlG;
        dhY();
        dib();
        if (this.vlI == 0) {
          this.jkD.stopTimer();
        }
        if ((this.vmc.size() == 0) && (!bt.isNullOrNil(this.vkl))) {
          doSceneProgress(new ah(this.vkl, 5, 0, null, "v1.0"), false);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(65095);
      return true;
      if ((paramn instanceof com.tencent.mm.plugin.luckymoney.f2f.a.a))
      {
        this.vkl = "";
        this.qeQ = "";
        this.vlI = 0;
        this.vmc.clear();
        this.vmp = "";
        this.vmf.notifyDataSetChanged();
        dhY();
        dib();
        this.jkD.stopTimer();
        if (!bt.isNullOrNil(this.vlH)) {
          com.tencent.mm.ui.base.h.cl(this, this.vlH);
        }
        this.vlG = "";
      }
      else if ((paramn instanceof ah))
      {
        this.vmo = ((ah)paramn).vpO.voi;
        paramString = ((ah)paramn).vpO.vox;
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramInt1 = i;
          while (paramInt1 < paramString.size())
          {
            paramn = (y)paramString.get(paramInt1);
            if ((!bt.isNullOrNil(paramn.vol)) && (!this.vmc.contains(paramn.vol)))
            {
              this.vmc.add(paramn.vol);
              String str = paramn.userName;
              if (!bt.isNullOrNil(paramn.vpD)) {
                this.vmp = str;
              }
              this.vmd.put(paramn.vol, str);
            }
            paramInt1 += 1;
          }
          dia();
          this.vmf.notifyDataSetChanged();
        }
      }
      else if ((paramn instanceof com.tencent.mm.plugin.luckymoney.f2f.a.b))
      {
        ad.i("LuckyMoneyF2FQRCodeUI", "onSceneEnd NetSceneF2FLuckyMoneyInvalid");
        this.retCode = ((com.tencent.mm.plugin.luckymoney.f2f.a.b)paramn).dlw;
        this.krz = ((com.tencent.mm.plugin.luckymoney.f2f.a.b)paramn).paA;
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
    this.jkD.stopTimer();
    ((r)com.tencent.mm.kernel.g.ad(r.class)).getSysCmdMsgExtension().b("ffopenwxhb", this.vmu, true);
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
        paramViewGroup.iWu = ((ImageView)localObject);
        paramViewGroup.vmU = localImageView;
        paramView.setTag(paramViewGroup);
        localObject = (String)LuckyMoneyF2FQRCodeUI.b(LuckyMoneyF2FQRCodeUI.this).get(getItem(paramInt));
        com.tencent.mm.plugin.luckymoney.model.z.b(paramViewGroup.iWu, null, (String)localObject);
        if ((bt.isNullOrNil(LuckyMoneyF2FQRCodeUI.D(LuckyMoneyF2FQRCodeUI.this))) || (!LuckyMoneyF2FQRCodeUI.D(LuckyMoneyF2FQRCodeUI.this).equals(localObject))) {
          break label157;
        }
        paramViewGroup.vmU.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(65083);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label157:
        paramViewGroup.vmU.setVisibility(4);
      }
    }
    
    final class a
    {
      ImageView iWu;
      ImageView vmU;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI
 * JD-Core Version:    0.7.0.1
 */