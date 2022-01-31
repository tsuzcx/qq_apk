package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.plugin.luckymoney.f2f.a.1;
import com.tencent.mm.plugin.luckymoney.f2f.a.2;
import com.tencent.mm.plugin.luckymoney.f2f.a.e;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.plugin.luckymoney.model.w;
import com.tencent.mm.plugin.luckymoney.model.x;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.pluginsdk.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bc;
import com.tencent.mm.sdk.platformtools.bc.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.HorizontalListViewV2;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.widget.b.d;
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
  implements bc.a
{
  private View Ww;
  private SensorManager bmB;
  private int[] gEs;
  private ap gIs;
  private DisplayMetrics gjH;
  private String hxt;
  private d iOd;
  private n.d kRh;
  private String lHq;
  private Bitmap mBitmap;
  private String ojA;
  private Button ojJ;
  private String okU;
  private int okV;
  private com.tencent.mm.plugin.luckymoney.f2f.a olA;
  private long olB;
  private String olC;
  private ValueAnimator olD;
  private float olE;
  private float olF;
  private float olG;
  private bz.a olH;
  private n.c olI;
  private Bitmap olJ;
  private Bitmap olK;
  private Bitmap olL;
  private Bitmap olM;
  private Bitmap olN;
  private Bitmap olO;
  private Bitmap olP;
  private Bitmap olQ;
  private Bitmap olR;
  private Bitmap olS;
  private Bitmap olT;
  private Bitmap olU;
  private com.tencent.mm.particles.b olV;
  private com.tencent.mm.particles.b olW;
  final SensorEventListener olX;
  private View olg;
  private View olh;
  private ImageView oli;
  private TextView olj;
  private TextView olk;
  private ImageView oll;
  private TextView olm;
  private TextView oln;
  private HorizontalListViewV2 olo;
  private List<String> olp;
  private Map<String, String> olq;
  private Queue<Pair<String, Integer>> olr;
  private a ols;
  private TextView olt;
  private ShuffleView olu;
  private ShuffleView.c olv;
  private List<View> olw;
  private ViewGroup olx;
  private ViewGroup oly;
  private View olz;
  private int retCode;
  
  public LuckyMoneyF2FQRCodeUI()
  {
    AppMethodBeat.i(42194);
    this.olH = new LuckyMoneyF2FQRCodeUI.1(this);
    this.olI = new LuckyMoneyF2FQRCodeUI.8(this);
    this.kRh = new LuckyMoneyF2FQRCodeUI.9(this);
    this.olV = new LuckyMoneyF2FQRCodeUI.10(this);
    this.olW = new com.tencent.mm.particles.b()
    {
      public final com.tencent.mm.particles.a.b a(Random paramAnonymousRandom)
      {
        AppMethodBeat.i(142025);
        int i = paramAnonymousRandom.nextInt(100);
        if (i < 10)
        {
          if (LuckyMoneyF2FQRCodeUI.o(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.g(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2130839394, 32));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.o(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(142025);
          return paramAnonymousRandom;
        }
        if (i < 20)
        {
          if (LuckyMoneyF2FQRCodeUI.p(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.h(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2130839395, 32));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.p(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(142025);
          return paramAnonymousRandom;
        }
        if (i < 30)
        {
          if (LuckyMoneyF2FQRCodeUI.q(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.i(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2130839396, 32));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.q(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(142025);
          return paramAnonymousRandom;
        }
        if (i < 50)
        {
          if (LuckyMoneyF2FQRCodeUI.r(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.j(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2130839389, 32));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.r(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(142025);
          return paramAnonymousRandom;
        }
        if (i < 75)
        {
          if (LuckyMoneyF2FQRCodeUI.s(LuckyMoneyF2FQRCodeUI.this) == null) {
            LuckyMoneyF2FQRCodeUI.k(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2130839390, 32));
          }
          paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.s(LuckyMoneyF2FQRCodeUI.this));
          AppMethodBeat.o(142025);
          return paramAnonymousRandom;
        }
        if (LuckyMoneyF2FQRCodeUI.t(LuckyMoneyF2FQRCodeUI.this) == null) {
          LuckyMoneyF2FQRCodeUI.l(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this, 2130839391, 32));
        }
        paramAnonymousRandom = new com.tencent.mm.particles.a.a(LuckyMoneyF2FQRCodeUI.t(LuckyMoneyF2FQRCodeUI.this));
        AppMethodBeat.o(142025);
        return paramAnonymousRandom;
      }
    };
    this.olX = new LuckyMoneyF2FQRCodeUI.7(this);
    AppMethodBeat.o(42194);
  }
  
  private void bMX()
  {
    AppMethodBeat.i(42196);
    if (!bo.isNullOrNil(this.lHq))
    {
      this.mBitmap = com.tencent.mm.by.a.a.bE(this, this.lHq);
      this.oll.setImageBitmap(this.mBitmap);
    }
    if (this.okV <= 0)
    {
      this.oll.setPadding(com.tencent.mm.cb.a.fromDPToPix(this, 5), com.tencent.mm.cb.a.fromDPToPix(this, 5), com.tencent.mm.cb.a.fromDPToPix(this, 5), com.tencent.mm.cb.a.fromDPToPix(this, 5));
      this.oll.setImageResource(2130839388);
      this.olt.setVisibility(8);
      this.ojJ.setVisibility(0);
      this.olm.setVisibility(4);
      this.olg.setPadding(this.olg.getPaddingLeft(), f.di(this), this.olg.getPaddingRight(), this.olg.getPaddingBottom());
      if (this.olp.size() > 0)
      {
        this.oln.setText(getString(2131301222));
        AppMethodBeat.o(42196);
        return;
      }
      this.oln.setText(getString(2131301223));
      AppMethodBeat.o(42196);
      return;
    }
    this.oll.setPadding(0, 0, 0, 0);
    this.olm.setText(getString(2131301228));
    this.olm.setVisibility(0);
    this.oln.setText(getString(2131301228));
    this.olt.setText(getString(2131301227, new Object[] { Integer.valueOf(this.okV) }));
    this.olt.setVisibility(0);
    this.ojJ.setVisibility(8);
    AppMethodBeat.o(42196);
  }
  
  private void bMY()
  {
    AppMethodBeat.i(42197);
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
    com.tencent.mm.plugin.luckymoney.f2f.a locala = this.olA;
    WeakReference localWeakReference = new WeakReference(this);
    g.RO().ac(new a.1(locala, localHashSet, localWeakReference));
    locala.okt.setOnLoadCompleteListener(new a.2(locala));
    AppMethodBeat.o(42197);
  }
  
  private void bMZ()
  {
    AppMethodBeat.i(42198);
    int i = this.olo.getWidth() - this.olp.size() * getResources().getDimensionPixelSize(2131427497);
    if (i > 0)
    {
      this.olo.setPadding(i / 2, 0, i / 2, 0);
      AppMethodBeat.o(42198);
      return;
    }
    this.olo.setPadding(0, 0, 0, 0);
    AppMethodBeat.o(42198);
  }
  
  private void bNa()
  {
    AppMethodBeat.i(42199);
    if (this.olw.size() != this.okV)
    {
      ab.i("LuckyMoneyF2FQRCodeUI", "shuffle cards: %d", new Object[] { Integer.valueOf(this.olw.size()), Integer.valueOf(this.okV) });
      this.olw.clear();
      int i = 0;
      while (i < this.okV)
      {
        View localView = LayoutInflater.from(this).inflate(2130970027, this.olu, false);
        ((FrameLayout.LayoutParams)localView.getLayoutParams()).gravity = 81;
        this.olw.add(localView);
        i += 1;
      }
      this.olu.setAllShuffleCards(this.olw);
    }
    AppMethodBeat.o(42199);
  }
  
  public final void aNW()
  {
    AppMethodBeat.i(42205);
    ab.i("LuckyMoneyF2FQRCodeUI", "screenShot");
    if (this.okV > 0)
    {
      Object localObject = this.lHq;
      ab.i("LuckyMoneyF2FQRCodeUI", "invalidQRCode");
      doSceneProgress(new com.tencent.mm.plugin.luckymoney.f2f.a.b((String)localObject), false);
      ab.i("LuckyMoneyF2FQRCodeUI", "getQRCode");
      doSceneProgress(new e(), false);
      bMX();
      localObject = this.gEs;
      localObject[1] += 1;
      com.tencent.mm.ui.base.h.b(this, getString(2131301229), null, true);
    }
    AppMethodBeat.o(42205);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2130970028;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42195);
    super.onCreate(paramBundle);
    this.gjH = getResources().getDisplayMetrics();
    this.olp = new ArrayList();
    this.olq = new HashMap();
    this.olr = new LinkedList();
    this.olw = new ArrayList();
    this.gEs = new int[6];
    paramBundle = this.gEs;
    paramBundle[0] += 1;
    this.gIs = new ap(new ap.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(42186);
        e locale = new e();
        LuckyMoneyF2FQRCodeUI.this.doSceneProgress(locale, false);
        AppMethodBeat.o(42186);
        return true;
      }
    }, true);
    this.Ww = findViewById(2131825668);
    this.olg = findViewById(2131825666);
    this.oln = ((TextView)findViewById(2131825671));
    this.olm = ((TextView)findViewById(2131825669));
    this.olG = this.oln.getAlpha();
    this.oll = ((ImageView)this.Ww.findViewById(2131825670));
    this.olo = ((HorizontalListViewV2)findViewById(2131825672));
    this.ols = new a((byte)0);
    this.olo.setAdapter(this.ols);
    this.olo.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(42187);
        paramAnonymousAdapterView = new Intent(LuckyMoneyF2FQRCodeUI.this, LuckyMoneyBeforeDetailUI.class);
        paramAnonymousAdapterView.putExtra("key_sendid", LuckyMoneyF2FQRCodeUI.u(LuckyMoneyF2FQRCodeUI.this));
        LuckyMoneyF2FQRCodeUI.this.startActivity(paramAnonymousAdapterView);
        AppMethodBeat.o(42187);
      }
    });
    this.olo.setOnScrollStateChangedListener(new LuckyMoneyF2FQRCodeUI.14(this));
    this.ojJ = ((Button)findViewById(2131825675));
    this.ojJ.setOnClickListener(new LuckyMoneyF2FQRCodeUI.15(this));
    this.olt = ((TextView)findViewById(2131825674));
    this.olh = findViewById(2131825677);
    setBackBtn(new LuckyMoneyF2FQRCodeUI.2(this));
    setMMTitle(getString(2131301230));
    addIconOptionMenu(0, 2131230740, new LuckyMoneyF2FQRCodeUI.3(this));
    setActionbarColor(getResources().getColor(2131690229));
    hideActionbarLine();
    this.olx = ((ViewGroup)findViewById(2131825683));
    this.oly = ((ViewGroup)findViewById(2131825667));
    this.olz = findViewById(2131825676);
    this.olz.setAlpha(0.0F);
    this.bmB = ((SensorManager)ah.getContext().getSystemService("sensor"));
    this.bmB.registerListener(this.olX, this.bmB.getDefaultSensor(1), 3);
    this.olA = new com.tencent.mm.plugin.luckymoney.f2f.a();
    this.olu = ((ShuffleView)findViewById(2131825673));
    this.olv = new ShuffleView.c();
    this.olv.omT = 4;
    this.olv.omR = 2;
    this.olv.omS = 4;
    this.olv.omU = 300;
    this.olv.scaleY = 0.0F;
    this.olu.setShuffleSetting(this.olv);
    ShuffleView.gjH = this.gjH;
    paramBundle = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(300L);
    this.olu.setExitAnimator(paramBundle);
    this.olu.setExitAnimatorListener(new LuckyMoneyF2FQRCodeUI.4(this));
    this.olu.setCardListener(new LuckyMoneyF2FQRCodeUI.5(this));
    bMY();
    this.olD = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    this.olD.setDuration(300L);
    this.olD.setStartDelay(3000L);
    this.olD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        AppMethodBeat.i(42177);
        float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
        LuckyMoneyF2FQRCodeUI.E(LuckyMoneyF2FQRCodeUI.this).setTranslationY(-0.5F * f * LuckyMoneyF2FQRCodeUI.K(LuckyMoneyF2FQRCodeUI.this).heightPixels);
        LuckyMoneyF2FQRCodeUI.D(LuckyMoneyF2FQRCodeUI.this).setAlpha(1.0F - f);
        if (f == 1.0F)
        {
          LuckyMoneyF2FQRCodeUI.E(LuckyMoneyF2FQRCodeUI.this).setVisibility(8);
          LuckyMoneyF2FQRCodeUI.E(LuckyMoneyF2FQRCodeUI.this).setTranslationY(0.0F);
          LuckyMoneyF2FQRCodeUI.L(LuckyMoneyF2FQRCodeUI.this);
          LuckyMoneyF2FQRCodeUI.M(LuckyMoneyF2FQRCodeUI.this).notifyDataSetChanged();
          LuckyMoneyF2FQRCodeUI.w(LuckyMoneyF2FQRCodeUI.this).dDE();
        }
        AppMethodBeat.o(42177);
      }
    });
    bMX();
    getWindow().addFlags(128);
    AppMethodBeat.o(42195);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(42203);
    com.tencent.mm.plugin.report.service.h.qsU.e(14007, new Object[] { Integer.valueOf(this.gEs[0]), Integer.valueOf(this.gEs[1]), Integer.valueOf(this.gEs[2]), Integer.valueOf(this.gEs[3]), Integer.valueOf(this.gEs[4]), Integer.valueOf(this.gEs[5]) });
    com.tencent.mm.plugin.luckymoney.f2f.a locala = this.olA;
    locala.jFQ = true;
    locala.okt.release();
    getWindow().clearFlags(128);
    super.onDestroy();
    AppMethodBeat.o(42203);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(42202);
    super.onPause();
    if (this.bmB != null) {
      this.bmB.unregisterListener(this.olX);
    }
    AppMethodBeat.o(42202);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(42200);
    super.onResume();
    doSceneProgress(new e(), true);
    this.gIs.ag(60000L, 60000L);
    ((p)g.G(p.class)).getSysCmdMsgExtension().a("ffopenwxhb", this.olH, true);
    addSceneEndListener(1990);
    addSceneEndListener(1987);
    addSceneEndListener(1971);
    WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
    if (localLayoutParams.screenBrightness < 0.85F)
    {
      localLayoutParams.screenBrightness = 0.85F;
      getWindow().setAttributes(localLayoutParams);
    }
    bc.a(this, this);
    if (this.bmB != null) {
      this.bmB.registerListener(this.olX, this.bmB.getDefaultSensor(1), 3);
    }
    AppMethodBeat.o(42200);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    int i = 0;
    AppMethodBeat.i(42204);
    ab.i("LuckyMoneyF2FQRCodeUI", "errType: %d,errCode: %d,errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      if ((paramm instanceof e))
      {
        ab.d("LuckyMoneyF2FQRCodeUI", "sendId:" + this.ojA);
        if ((!bo.Q(new String[] { this.ojA, ((e)paramm).ojA })) && (!this.ojA.equals(((e)paramm).ojA)))
        {
          this.olp.clear();
          this.olq.clear();
          this.olr.clear();
          this.ols.notifyDataSetChanged();
          this.olC = "";
        }
        if (!bo.isNullOrNil(((e)paramm).ojA)) {
          this.ojA = ((e)paramm).ojA;
        }
        this.lHq = ((e)paramm).lHq;
        this.okV = ((e)paramm).okV;
        this.okU = ((e)paramm).okU;
        bMX();
        bNa();
        if (this.okV == 0) {
          this.gIs.stopTimer();
        }
        if ((this.olp.size() == 0) && (!bo.isNullOrNil(this.ojA))) {
          doSceneProgress(new af(this.ojA, 5, 0, null, "v1.0"), false);
        }
      }
    }
    for (;;)
    {
      AppMethodBeat.o(42204);
      return true;
      if ((paramm instanceof com.tencent.mm.plugin.luckymoney.f2f.a.a))
      {
        this.ojA = "";
        this.lHq = "";
        this.okV = 0;
        this.olp.clear();
        this.olC = "";
        this.ols.notifyDataSetChanged();
        bMX();
        bNa();
        this.gIs.stopTimer();
        if (!bo.isNullOrNil(this.okU)) {
          com.tencent.mm.ui.base.h.bO(this, this.okU);
        }
      }
      else if ((paramm instanceof af))
      {
        this.olB = ((af)paramm).ooO.onw;
        paramString = ((af)paramm).ooO.onL;
        if ((paramString != null) && (paramString.size() > 0))
        {
          paramInt1 = i;
          while (paramInt1 < paramString.size())
          {
            paramm = (w)paramString.get(paramInt1);
            if ((!bo.isNullOrNil(paramm.onz)) && (!this.olp.contains(paramm.onz)))
            {
              this.olp.add(paramm.onz);
              String str = paramm.userName;
              if (!bo.isNullOrNil(paramm.ooE)) {
                this.olC = str;
              }
              this.olq.put(paramm.onz, str);
            }
            paramInt1 += 1;
          }
          bMZ();
          this.ols.notifyDataSetChanged();
        }
      }
      else if ((paramm instanceof com.tencent.mm.plugin.luckymoney.f2f.a.b))
      {
        ab.i("LuckyMoneyF2FQRCodeUI", "onSceneEnd NetSceneF2FLuckyMoneyInvalid");
        this.retCode = ((com.tencent.mm.plugin.luckymoney.f2f.a.b)paramm).cnK;
        this.hxt = ((com.tencent.mm.plugin.luckymoney.f2f.a.b)paramm).kNv;
        ab.i("LuckyMoneyF2FQRCodeUI", "retcode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        continue;
        if (!bo.isNullOrNil(paramString)) {
          com.tencent.mm.ui.base.h.b(this, paramString, getString(2131297087), true);
        }
      }
    }
  }
  
  public void onStop()
  {
    AppMethodBeat.i(42201);
    super.onStop();
    this.gIs.stopTimer();
    ((p)g.G(p.class)).getSysCmdMsgExtension().b("ffopenwxhb", this.olH, true);
    removeSceneEndListener(1990);
    removeSceneEndListener(1987);
    removeSceneEndListener(1971);
    bc.a(this, null);
    AppMethodBeat.o(42201);
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
      AppMethodBeat.i(42191);
      String str = (String)LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).get(paramInt);
      AppMethodBeat.o(42191);
      return str;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(42190);
      int i = LuckyMoneyF2FQRCodeUI.a(LuckyMoneyF2FQRCodeUI.this).size();
      AppMethodBeat.o(42190);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(42192);
      if (paramView == null)
      {
        paramView = LayoutInflater.from(LuckyMoneyF2FQRCodeUI.this).inflate(2130970030, null);
        Object localObject = (ImageView)paramView.findViewById(2131825689);
        ImageView localImageView = (ImageView)paramView.findViewById(2131825690);
        paramViewGroup = new LuckyMoneyF2FQRCodeUI.a.a(this);
        paramViewGroup.gqF = ((ImageView)localObject);
        paramViewGroup.omh = localImageView;
        paramView.setTag(paramViewGroup);
        localObject = (String)LuckyMoneyF2FQRCodeUI.b(LuckyMoneyF2FQRCodeUI.this).get(getItem(paramInt));
        x.b(paramViewGroup.gqF, null, (String)localObject);
        if ((bo.isNullOrNil(LuckyMoneyF2FQRCodeUI.C(LuckyMoneyF2FQRCodeUI.this))) || (!LuckyMoneyF2FQRCodeUI.C(LuckyMoneyF2FQRCodeUI.this).equals(localObject))) {
          break label157;
        }
        paramViewGroup.omh.setVisibility(0);
      }
      for (;;)
      {
        AppMethodBeat.o(42192);
        return paramView;
        paramViewGroup = (LuckyMoneyF2FQRCodeUI.a.a)paramView.getTag();
        break;
        label157:
        paramViewGroup.omh.setVisibility(4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.LuckyMoneyF2FQRCodeUI
 * JD-Core Version:    0.7.0.1
 */