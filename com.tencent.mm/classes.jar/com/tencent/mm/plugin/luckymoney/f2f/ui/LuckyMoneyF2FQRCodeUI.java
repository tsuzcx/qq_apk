package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
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
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.an.h.a;
import com.tencent.mm.an.h.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ck;
import com.tencent.mm.model.ck.a;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.luckymoney.f2f.a.1;
import com.tencent.mm.plugin.luckymoney.f2f.a.2;
import com.tencent.mm.plugin.luckymoney.model.ae;
import com.tencent.mm.plugin.luckymoney.model.ag;
import com.tencent.mm.plugin.luckymoney.model.ap;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.db;
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
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.wallet_core.ui.g;
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
  private Button EuM;
  private String EvW;
  private String EvX;
  private int EvY;
  private ViewGroup EwA;
  private ViewGroup EwB;
  private View EwC;
  private com.tencent.mm.plugin.luckymoney.f2f.a EwD;
  private long EwE;
  private String EwF;
  private ValueAnimator EwG;
  private float EwH;
  private float EwI;
  private float EwJ;
  private ck.a EwK;
  private q.f EwL;
  private Bitmap EwM;
  private Bitmap EwN;
  private Bitmap EwO;
  private Bitmap EwP;
  private Bitmap EwQ;
  private Bitmap EwR;
  private Bitmap EwS;
  private Bitmap EwT;
  private Bitmap EwU;
  private Bitmap EwV;
  private Bitmap EwW;
  private Bitmap EwX;
  private com.tencent.mm.particles.b EwY;
  private com.tencent.mm.particles.b EwZ;
  private View Ewj;
  private View Ewk;
  private ImageView Ewl;
  private TextView Ewm;
  private TextView Ewn;
  private ImageView Ewo;
  private TextView Ewp;
  private TextView Ewq;
  private HorizontalListViewV2 Ewr;
  private List<String> Ews;
  private Map<String, String> Ewt;
  private Queue<Pair<String, Integer>> Ewu;
  private a Ewv;
  private TextView Eww;
  private ShuffleView Ewx;
  private ShuffleView.c Ewy;
  private List<View> Ewz;
  final SensorEventListener Exa;
  private Bitmap mBitmap;
  private View mL;
  private SensorManager mSensorManager;
  private DisplayMetrics metrics;
  private MTimerHandler ndv;
  private int[] nei;
  private com.tencent.mm.ui.widget.a.e qXn;
  private int retCode;
  private String tVH;
  private q.g tZd;
  private String vhY;
  private String ybP;
  
  public LuckyMoneyF2FQRCodeUI()
  {
    AppMethodBeat.i(65085);
    this.EwK = new ck.a()
    {
      public final void a(h.a paramAnonymousa)
      {
        AppMethodBeat.i(65061);
        paramAnonymousa = XmlParser.parseXml(z.a(paramAnonymousa.jQG.RIF), "sysmsg", null);
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
                  if (!ab.Ql(str2))
                  {
                    localObject = new j();
                    ((j)localObject).username = str2;
                    com.tencent.mm.am.q.bhP().b((j)localObject);
                  }
                  LuckyMoneyF2FQRCodeUI.b(LuckyMoneyF2FQRCodeUI.this).put(str4, str2);
                  localObject = LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this);
                  if (((ShuffleView)localObject).Exv.size() > 0)
                  {
                    if (((ShuffleView)localObject).Exx.isStarted()) {
                      ((ShuffleView)localObject).Exx.end();
                    }
                    if (((ShuffleView)localObject).uQS.isStarted()) {
                      ((ShuffleView)localObject).uQS.end();
                    }
                    if (((ShuffleView)localObject).neE == null) {
                      break label351;
                    }
                    ((ShuffleView)localObject).ExB = ((ShuffleView)localObject).neE;
                    ((ShuffleView)localObject).Exv.remove(((ShuffleView)localObject).ExB);
                    if (((ShuffleView)localObject).xwu != null) {
                      ((ShuffleView)localObject).xwu.start();
                    }
                    ((ShuffleView)localObject).VS(((ShuffleView)localObject).ExD);
                    if (((ShuffleView)localObject).ExG <= 0) {
                      break label338;
                    }
                    ((ShuffleView)localObject).ExD = ((ShuffleView)localObject).eOp();
                    ((ShuffleView)localObject).neE = ((View)((ShuffleView)localObject).Exv.get(((ShuffleView)localObject).ExD));
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
                  ((ShuffleView)localObject).neE = null;
                  ((ShuffleView)localObject).ExD = 0;
                  continue;
                  label351:
                  ((ShuffleView)localObject).VQ(((ShuffleView)localObject).eOp());
                  ((ShuffleView)localObject).ExB = ((ShuffleView)localObject).neE;
                  ((ShuffleView)localObject).Exx.addListener(new ShuffleView.5((ShuffleView)localObject));
                }
              }
            });
          }
        }
        AppMethodBeat.o(65061);
      }
      
      public final void a(h.c paramAnonymousc) {}
    };
    this.EwL = new LuckyMoneyF2FQRCodeUI.8(this);
    this.tZd = new LuckyMoneyF2FQRCodeUI.9(this);
    this.EwY = new com.tencent.mm.particles.b()
    {
      public final com.tencent.mm.particles.a.b a(Random paramAnonymousRandom)
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
    this.EwZ = new com.tencent.mm.particles.b()
    {
      public final com.tencent.mm.particles.a.b a(Random paramAnonymousRandom)
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
    this.Exa = new LuckyMoneyF2FQRCodeUI.7(this);
    AppMethodBeat.o(65085);
  }
  
  private void eOk()
  {
    AppMethodBeat.i(65087);
    if (!Util.isNullOrNil(this.vhY))
    {
      this.mBitmap = com.tencent.mm.cf.a.a.cD(this, this.vhY);
      this.Ewo.setImageBitmap(this.mBitmap);
    }
    if (this.EvY <= 0)
    {
      this.Ewo.setPadding(com.tencent.mm.ci.a.fromDPToPix(this, 5), com.tencent.mm.ci.a.fromDPToPix(this, 5), com.tencent.mm.ci.a.fromDPToPix(this, 5), com.tencent.mm.ci.a.fromDPToPix(this, 5));
      this.Ewo.setImageResource(a.e.lucky_money_f2f_empty_qrcode);
      this.Eww.setVisibility(8);
      this.EuM.setVisibility(0);
      this.Ewp.setVisibility(4);
      this.Ewj.setPadding(this.Ewj.getPaddingLeft(), com.tencent.mm.pluginsdk.h.ew(this), this.Ewj.getPaddingRight(), this.Ewj.getPaddingBottom());
      if (this.Ews.size() > 0)
      {
        this.Ewq.setText(getString(a.i.lucky_money_f2f_no_remain_tips));
        AppMethodBeat.o(65087);
        return;
      }
      this.Ewq.setText(getString(a.i.lucky_money_f2f_not_prepare_tips));
      AppMethodBeat.o(65087);
      return;
    }
    this.Ewo.setPadding(0, 0, 0, 0);
    this.Ewp.setText(getString(a.i.lucky_money_f2f_scan_qrcode_tips));
    this.Ewp.setVisibility(0);
    this.Ewq.setText(getString(a.i.lucky_money_f2f_scan_qrcode_tips));
    this.Eww.setText(getString(a.i.lucky_money_f2f_remain_tip, new Object[] { Integer.valueOf(this.EvY) }));
    this.Eww.setVisibility(0);
    this.EuM.setVisibility(8);
    AppMethodBeat.o(65087);
  }
  
  private void eOl()
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
    com.tencent.mm.plugin.luckymoney.f2f.a locala = this.EwD;
    WeakReference localWeakReference = new WeakReference(this);
    com.tencent.mm.kernel.h.aHJ().postToWorker(new a.1(locala, localHashSet, localWeakReference));
    locala.Evw.setOnLoadCompleteListener(new a.2(locala));
    AppMethodBeat.o(65088);
  }
  
  private void eOm()
  {
    AppMethodBeat.i(65089);
    int i = this.Ewr.getWidth() - this.Ews.size() * getResources().getDimensionPixelSize(a.d.BigAvatarSize);
    if (i > 0)
    {
      this.Ewr.setPadding(i / 2, 0, i / 2, 0);
      AppMethodBeat.o(65089);
      return;
    }
    this.Ewr.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(65089);
  }
  
  private void eOn()
  {
    AppMethodBeat.i(65090);
    if (this.Ewz.size() != this.EvY)
    {
      Log.i("LuckyMoneyF2FQRCodeUI", "shuffle cards: %d", new Object[] { Integer.valueOf(this.Ewz.size()), Integer.valueOf(this.EvY) });
      this.Ewz.clear();
      int i = 0;
      while (i < this.EvY)
      {
        View localView = LayoutInflater.from(this).inflate(a.g.lucky_money_f2f_packet_card_view, this.Ewx, false);
        ((FrameLayout.LayoutParams)localView.getLayoutParams()).gravity = 81;
        this.Ewz.add(localView);
        i += 1;
      }
      this.Ewx.setAllShuffleCards(this.Ewz);
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
    this.Ews = new ArrayList();
    this.Ewt = new HashMap();
    this.Ewu = new LinkedList();
    this.Ewz = new ArrayList();
    this.nei = new int[6];
    paramBundle = this.nei;
    paramBundle[0] += 1;
    this.ndv = new MTimerHandler(new MTimerHandler.CallBack()
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
    this.mL = findViewById(a.f.lucky_money_f2f_recv_header);
    this.Ewj = findViewById(a.f.white_block);
    this.Ewq = ((TextView)findViewById(a.f.lucky_money_f2f_qrcode_bottom_tip));
    this.Ewp = ((TextView)findViewById(a.f.lucky_money_f2f_qrcode_top_tip));
    this.EwJ = this.Ewq.getAlpha();
    this.Ewo = ((ImageView)this.mL.findViewById(a.f.lucky_money_f2f_qrcode));
    this.Ewr = ((HorizontalListViewV2)findViewById(a.f.lucky_money_f2f_recv_avatar_list));
    this.Ewv = new a((byte)0);
    this.Ewr.setAdapter(this.Ewv);
    this.Ewr.setOnItemClickListener(new LuckyMoneyF2FQRCodeUI.13(this));
    this.Ewr.setOnScrollStateChangedListener(new HorizontalListViewV2.d()
    {
      public final void a(HorizontalListViewV2.d.a paramAnonymousa)
      {
        AppMethodBeat.i(65079);
        if ((paramAnonymousa == HorizontalListViewV2.d.a.Wij) && (LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size() >= 5) && (LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size() < LuckyMoneyF2FQRCodeUI.w(LuckyMoneyF2FQRCodeUI.this)) && (LuckyMoneyF2FQRCodeUI.x(LuckyMoneyF2FQRCodeUI.this).getLastVisiblePosition() == LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size() - 1) && (!Util.isNullOrNil(LuckyMoneyF2FQRCodeUI.v(LuckyMoneyF2FQRCodeUI.this))))
        {
          paramAnonymousa = new ap(LuckyMoneyF2FQRCodeUI.v(LuckyMoneyF2FQRCodeUI.this), 5, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size(), null, "v1.0");
          LuckyMoneyF2FQRCodeUI.this.doSceneProgress(paramAnonymousa);
        }
        AppMethodBeat.o(65079);
      }
    });
    this.EuM = ((Button)findViewById(a.f.lucky_money_f2f_prepare_btn));
    this.EuM.setOnClickListener(new LuckyMoneyF2FQRCodeUI.15(this));
    this.Eww = ((TextView)findViewById(a.f.lucky_money_f2f_remain_text));
    this.Ewk = findViewById(a.f.lucky_money_f2f_recv_packet);
    setBackBtn(new LuckyMoneyF2FQRCodeUI.2(this));
    setMMTitle(getString(a.i.lucky_money_f2f_title));
    addIconOptionMenu(0, a.h.actionbar_icon_dark_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(65063);
        LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, new com.tencent.mm.ui.widget.a.e(LuckyMoneyF2FQRCodeUI.this, 1, false));
        LuckyMoneyF2FQRCodeUI.z(LuckyMoneyF2FQRCodeUI.this).ODT = LuckyMoneyF2FQRCodeUI.y(LuckyMoneyF2FQRCodeUI.this);
        LuckyMoneyF2FQRCodeUI.z(LuckyMoneyF2FQRCodeUI.this).ODU = LuckyMoneyF2FQRCodeUI.A(LuckyMoneyF2FQRCodeUI.this);
        LuckyMoneyF2FQRCodeUI.z(LuckyMoneyF2FQRCodeUI.this).eik();
        AppMethodBeat.o(65063);
        return true;
      }
    });
    setActionbarColor(getResources().getColor(a.c.lucky_money_goldstyle_actionbar_bg_color));
    hideActionbarLine();
    this.EwA = ((ViewGroup)findViewById(a.f.lucky_money_f2f_firework_layer_top));
    this.EwB = ((ViewGroup)findViewById(a.f.lucky_money_f2f_firework_layer_bottom));
    this.EwC = findViewById(a.f.lucky_money_f2f_layer_mask);
    this.EwC.setAlpha(0.0F);
    this.mSensorManager = ((SensorManager)MMApplicationContext.getContext().getSystemService("sensor"));
    this.mSensorManager.registerListener(this.Exa, this.mSensorManager.getDefaultSensor(1), 3);
    this.EwD = new com.tencent.mm.plugin.luckymoney.f2f.a();
    this.Ewx = ((ShuffleView)findViewById(a.f.lucky_money_f2f_shuffle_view));
    this.Ewy = new ShuffleView.c();
    this.Ewy.ExV = 4;
    this.Ewy.ExT = 2;
    this.Ewy.ExU = 4;
    this.Ewy.ExW = 300;
    this.Ewy.scaleY = 0.0F;
    this.Ewx.setShuffleSetting(this.Ewy);
    ShuffleView.metrics = this.metrics;
    paramBundle = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(300L);
    this.Ewx.setExitAnimator(paramBundle);
    this.Ewx.setExitAnimatorListener(new ShuffleView.a()
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
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).JW("packet_received.m4a");
          LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this).removeView(LuckyMoneyF2FQRCodeUI.c(LuckyMoneyF2FQRCodeUI.this).getExitView());
          LuckyMoneyF2FQRCodeUI.H(LuckyMoneyF2FQRCodeUI.this);
          LuckyMoneyF2FQRCodeUI.I(LuckyMoneyF2FQRCodeUI.this).start();
        }
        AppMethodBeat.o(65064);
      }
    });
    this.Ewx.setCardListener(new ShuffleView.b()
    {
      public final void VN(int paramAnonymousInt)
      {
        AppMethodBeat.i(65066);
        LuckyMoneyF2FQRCodeUI.K(LuckyMoneyF2FQRCodeUI.this);
        if (paramAnonymousInt != 8)
        {
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).JW("select_card.m4a");
          arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
          arrayOfInt[3] += 1;
          AppMethodBeat.o(65066);
          return;
        }
        int[] arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
        arrayOfInt[5] += 1;
        AppMethodBeat.o(65066);
      }
      
      public final void hW(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(65065);
        if (paramAnonymousInt2 == 8)
        {
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).JW("music" + (paramAnonymousInt1 + 1) + ".m4a");
          arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
          arrayOfInt[4] += 1;
          AppMethodBeat.o(65065);
          return;
        }
        LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).JW("touch_card.m4a");
        int[] arrayOfInt = LuckyMoneyF2FQRCodeUI.J(LuckyMoneyF2FQRCodeUI.this);
        arrayOfInt[2] += 1;
        AppMethodBeat.o(65065);
      }
      
      public final void hX(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(65067);
        if (paramAnonymousInt2 == 8)
        {
          LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).JW("music" + (paramAnonymousInt1 + 1) + ".m4a");
          AppMethodBeat.o(65067);
          return;
        }
        LuckyMoneyF2FQRCodeUI.G(LuckyMoneyF2FQRCodeUI.this).JW("select_card.m4a");
        AppMethodBeat.o(65067);
      }
    });
    eOl();
    this.EwG = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.EwG.setDuration(300L);
    this.EwG.setStartDelay(3000L);
    this.EwG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
          LuckyMoneyF2FQRCodeUI.x(LuckyMoneyF2FQRCodeUI.this).hJs();
        }
        AppMethodBeat.o(65068);
      }
    });
    eOk();
    getWindow().addFlags(128);
    if (g.ijx()) {
      getWindow().addFlags(8192);
    }
    AppMethodBeat.o(65086);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(65094);
    com.tencent.mm.plugin.report.service.h.IzE.a(14007, new Object[] { Integer.valueOf(this.nei[0]), Integer.valueOf(this.nei[1]), Integer.valueOf(this.nei[2]), Integer.valueOf(this.nei[3]), Integer.valueOf(this.nei[4]), Integer.valueOf(this.nei[5]) });
    com.tencent.mm.plugin.luckymoney.f2f.a locala = this.EwD;
    locala.aFI = true;
    locala.Evw.release();
    getWindow().clearFlags(128);
    super.onDestroy();
    AppMethodBeat.o(65094);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(65093);
    super.onPause();
    if (this.mSensorManager != null) {
      this.mSensorManager.unregisterListener(this.Exa);
    }
    AppMethodBeat.o(65093);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(65091);
    super.onResume();
    doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.e(), true);
    this.ndv.startTimer(60000L);
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().a("ffopenwxhb", this.EwK, true);
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
      this.mSensorManager.registerListener(this.Exa, this.mSensorManager.getDefaultSensor(1), 3);
    }
    AppMethodBeat.o(65091);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    int i = 0;
    AppMethodBeat.i(65095);
    Log.i("LuckyMoneyF2FQRCodeUI", "errType: %d,errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramq instanceof com.tencent.mm.plugin.luckymoney.f2f.a.e))
      {
        Log.d("LuckyMoneyF2FQRCodeUI", "sendId:" + this.ybP);
        if ((!Util.isNullOrNil(new String[] { this.ybP, ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramq).ybP })) && (!this.ybP.equals(((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramq).ybP)))
        {
          this.Ews.clear();
          this.Ewt.clear();
          this.Ewu.clear();
          this.Ewv.notifyDataSetChanged();
          this.EwF = "";
        }
        if (!Util.isNullOrNil(((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramq).ybP)) {
          this.ybP = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramq).ybP;
        }
        this.vhY = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramq).vhY;
        this.EvY = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramq).EvY;
        this.EvX = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramq).EvX;
        this.EvW = ((com.tencent.mm.plugin.luckymoney.f2f.a.e)paramq).EvW;
        eOk();
        eOn();
        if (this.EvY == 0) {
          this.ndv.stopTimer();
        }
        if ((this.Ews.size() == 0) && (!Util.isNullOrNil(this.ybP))) {
          doSceneProgress(new ap(this.ybP, 5, 0, null, "v1.0"), false);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(65095);
      return true;
      if ((paramq instanceof com.tencent.mm.plugin.luckymoney.f2f.a.a))
      {
        this.ybP = "";
        this.vhY = "";
        this.EvY = 0;
        this.Ews.clear();
        this.EwF = "";
        this.Ewv.notifyDataSetChanged();
        eOk();
        eOn();
        this.ndv.stopTimer();
        if (!Util.isNullOrNil(this.EvX)) {
          com.tencent.mm.ui.base.h.cO(this, this.EvX);
        }
        this.EvW = "";
      }
      else if ((paramq instanceof ap))
      {
        this.EwE = ((ap)paramq).EAX.Eze;
        paramString = ((ap)paramq).EAX.Ezu;
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramInt1 = i;
          while (paramInt1 < paramString.size())
          {
            paramq = (ae)paramString.get(paramInt1);
            if ((!Util.isNullOrNil(paramq.Ezh)) && (!this.Ews.contains(paramq.Ezh)))
            {
              this.Ews.add(paramq.Ezh);
              String str = paramq.userName;
              if (!Util.isNullOrNil(paramq.EAJ)) {
                this.EwF = str;
              }
              this.Ewt.put(paramq.Ezh, str);
            }
            paramInt1 += 1;
          }
          eOm();
          this.Ewv.notifyDataSetChanged();
        }
      }
      else if ((paramq instanceof com.tencent.mm.plugin.luckymoney.f2f.a.b))
      {
        Log.i("LuckyMoneyF2FQRCodeUI", "onSceneEnd NetSceneF2FLuckyMoneyInvalid");
        this.retCode = ((com.tencent.mm.plugin.luckymoney.f2f.a.b)paramq).fwx;
        this.tVH = ((com.tencent.mm.plugin.luckymoney.f2f.a.b)paramq).tVo;
        Log.i("LuckyMoneyF2FQRCodeUI", "retcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        continue;
        if (!Util.isNullOrNil(paramString)) {
          com.tencent.mm.ui.base.h.c(this, paramString, getString(a.i.app_tip), true);
        }
      }
    }
  }
  
  public void onScreenShot(String paramString, long paramLong)
  {
    AppMethodBeat.i(270771);
    Log.i("LuckyMoneyF2FQRCodeUI", "screenShot");
    if (this.EvY > 0)
    {
      paramString = this.vhY;
      Log.i("LuckyMoneyF2FQRCodeUI", "invalidQRCode");
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.b(paramString), false);
      Log.i("LuckyMoneyF2FQRCodeUI", "getQRCode");
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.e(), false);
      eOk();
      paramString = this.nei;
      paramString[1] += 1;
      com.tencent.mm.ui.base.h.c(this, getString(a.i.lucky_money_f2f_screen_shot_tips), null, true);
    }
    AppMethodBeat.o(270771);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(65092);
    super.onStop();
    this.ndv.stopTimer();
    ((v)com.tencent.mm.kernel.h.ag(v.class)).getSysCmdMsgExtension().b("ffopenwxhb", this.EwK, true);
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
        paramViewGroup.mOe = ((ImageView)localObject);
        paramViewGroup.Exk = localImageView;
        paramView.setTag(paramViewGroup);
        localObject = (String)LuckyMoneyF2FQRCodeUI.b(LuckyMoneyF2FQRCodeUI.this).get(getItem(paramInt));
        ag.a(paramViewGroup.mOe, null, (String)localObject);
        if ((Util.isNullOrNil(LuckyMoneyF2FQRCodeUI.D(LuckyMoneyF2FQRCodeUI.this))) || (!LuckyMoneyF2FQRCodeUI.D(LuckyMoneyF2FQRCodeUI.this).equals(localObject))) {
          break label160;
        }
        paramViewGroup.Exk.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(65083);
        return paramView;
        paramViewGroup = (a)paramView.getTag();
        break;
        label160:
        paramViewGroup.Exk.setVisibility(4);
      }
    }
    
    final class a
    {
      ImageView Exk;
      ImageView mOe;
      
      a() {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI
 * JD-Core Version:    0.7.0.1
 */