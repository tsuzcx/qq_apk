package com.tencent.mm.plugin.luckymoney.story;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.LayoutParams;
import android.support.design.widget.AppBarLayout.b;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.i;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.h.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.luckymoney.a.a.a;
import com.tencent.mm.plugin.luckymoney.ui.HorizontalLayoutManager;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.protocal.protobuf.cic;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ai;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.view.MediaBannerIndicator;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.RecyclerHorizontalViewPager.b;
import com.tencent.mm.view.RecyclerHorizontalViewPager.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class EnvelopeAppBarLayout
  extends AppBarLayout
  implements LifecycleObserver
{
  private int ana;
  public MMActivity nqA;
  private int rBj;
  private View tgX;
  private ImageView tgY;
  private RecyclerHorizontalViewPager tgZ;
  private int thA;
  private EnvelopeStoryBehavior thB;
  private ArrayList<b> thC;
  private EnvelopeStoryVideoManager thD;
  private cic thE;
  private String thF;
  private String thG;
  private String thH;
  public int thI;
  private boolean thJ;
  public boolean thK;
  private boolean thL;
  private ValueAnimator thM;
  private ObjectAnimator thN;
  private ValueAnimator thO;
  private AnimatorSet thP;
  private AppBarLayout.b thQ;
  private final float thR;
  private final float thS;
  private boolean thT;
  private boolean thU;
  private int thV;
  private boolean thW;
  private boolean thX;
  private boolean thY;
  private boolean thZ;
  private RecyclerView tha;
  private TouchCoordinatorLayout thb;
  private ViewGroup thc;
  private ViewGroup thd;
  private MediaBannerIndicator the;
  private TextView thf;
  private RoundCornerImageView thg;
  private TextView thh;
  private TextView thi;
  private TextView thj;
  private TextView thk;
  private TextView thl;
  private ViewGroup thm;
  private View thn;
  private ImageView tho;
  private ImageView thp;
  private ImageView thq;
  private ViewGroup thr;
  private ViewGroup ths;
  private ProgressBar tht;
  private int thu;
  private int thv;
  private int thw;
  private int thx;
  private int thy;
  private int thz;
  private boolean tia;
  private boolean tib;
  private View.OnClickListener tic;
  private int tie;
  
  public EnvelopeAppBarLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(163595);
    this.thx = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 130);
    this.thy = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 120);
    this.thz = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 250);
    this.thA = (this.thz - this.thy);
    this.ana = 0;
    this.thC = new ArrayList();
    this.thJ = true;
    this.thK = false;
    this.thL = false;
    this.thR = 1.335F;
    this.thS = 0.6F;
    this.thT = false;
    this.thU = false;
    this.thW = false;
    this.thX = false;
    this.thY = false;
    this.thZ = false;
    this.tia = false;
    this.tib = false;
    this.tic = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163578);
        if ((!EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this)) && (EnvelopeAppBarLayout.this.thI == 2))
        {
          EnvelopeAppBarLayout.this.b(true, true, true);
          EnvelopeAppBarLayout.b(EnvelopeAppBarLayout.this);
          com.tencent.mm.plugin.luckymoney.a.d.sw(5);
          com.tencent.mm.plugin.luckymoney.a.c.bi(6, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
        }
        AppMethodBeat.o(163578);
      }
    };
    this.tie = aj.getResources().getDimensionPixelSize(2131166499);
    init();
    AppMethodBeat.o(163595);
  }
  
  public EnvelopeAppBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163596);
    this.thx = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 130);
    this.thy = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 120);
    this.thz = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 250);
    this.thA = (this.thz - this.thy);
    this.ana = 0;
    this.thC = new ArrayList();
    this.thJ = true;
    this.thK = false;
    this.thL = false;
    this.thR = 1.335F;
    this.thS = 0.6F;
    this.thT = false;
    this.thU = false;
    this.thW = false;
    this.thX = false;
    this.thY = false;
    this.thZ = false;
    this.tia = false;
    this.tib = false;
    this.tic = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163578);
        if ((!EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this)) && (EnvelopeAppBarLayout.this.thI == 2))
        {
          EnvelopeAppBarLayout.this.b(true, true, true);
          EnvelopeAppBarLayout.b(EnvelopeAppBarLayout.this);
          com.tencent.mm.plugin.luckymoney.a.d.sw(5);
          com.tencent.mm.plugin.luckymoney.a.c.bi(6, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
        }
        AppMethodBeat.o(163578);
      }
    };
    this.tie = aj.getResources().getDimensionPixelSize(2131166499);
    init();
    AppMethodBeat.o(163596);
  }
  
  private void cLU()
  {
    AppMethodBeat.i(163599);
    this.thc.setOnClickListener(this.tic);
    this.tgY.setOnClickListener(this.tic);
    AppMethodBeat.o(163599);
  }
  
  private void cLV()
  {
    AppMethodBeat.i(163600);
    Object localObject = new Rect();
    getWindowVisibleDisplayFrame((Rect)localObject);
    this.thu = (((Rect)localObject).right - ((Rect)localObject).left);
    this.thv = ((int)(this.thu * 1.335F));
    this.tgY.setMinimumHeight(this.thv);
    localObject = new AppBarLayout.LayoutParams(this.thv);
    ((AppBarLayout.LayoutParams)localObject).kA = 3;
    this.tgX.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.tgX.setMinimumHeight(this.thy);
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174331);
        EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this).G(-(EnvelopeAppBarLayout.this.getTotalScrollRange() - EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this)));
        EnvelopeAppBarLayout.o(EnvelopeAppBarLayout.this).setAlpha(1.0F);
        AppMethodBeat.o(174331);
      }
    }, 50L);
    AppMethodBeat.o(163600);
  }
  
  private boolean cLW()
  {
    AppMethodBeat.i(163601);
    com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)this.tgZ.cj(this.ana);
    if (locale == null)
    {
      AppMethodBeat.o(163601);
      return false;
    }
    if (((b)locale.IbA).tir.Eqm == 2)
    {
      AppMethodBeat.o(163601);
      return true;
    }
    AppMethodBeat.o(163601);
    return false;
  }
  
  private void init()
  {
    AppMethodBeat.i(163597);
    inflate(getContext(), 2131494638, this);
    setExpanded(false);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163584);
        Object localObject = (CoordinatorLayout.d)EnvelopeAppBarLayout.this.getLayoutParams();
        EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, (EnvelopeStoryBehavior)((CoordinatorLayout.d)localObject).nG);
        EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this).thK = EnvelopeAppBarLayout.this.thK;
        localObject = EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this);
        if (EnvelopeAppBarLayout.this.thI == 1) {}
        for (boolean bool = true;; bool = false)
        {
          ((EnvelopeStoryBehavior)localObject).tiA = bool;
          EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this).tiB = EnvelopeAppBarLayout.e(EnvelopeAppBarLayout.this);
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, (TouchCoordinatorLayout)EnvelopeAppBarLayout.this.getParent());
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).findViewById(2131301755));
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, (RecyclerView)EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).findViewById(2131301770));
          EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).a(new View.OnTouchListener()
          {
            float qXK;
            float seQ;
            long tig;
            boolean tih = false;
            
            public final boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
            {
              AppMethodBeat.i(163583);
              if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
              {
                if (paramAnonymous2MotionEvent.getActionMasked() != 0) {
                  break label108;
                }
                paramAnonymous2View = new Rect();
                EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this).getGlobalVisibleRect(paramAnonymous2View);
                if (!paramAnonymous2View.contains((int)paramAnonymous2MotionEvent.getRawX(), (int)paramAnonymous2MotionEvent.getRawY())) {
                  break label100;
                }
                this.qXK = paramAnonymous2MotionEvent.getRawX();
                this.seQ = paramAnonymous2MotionEvent.getRawY();
                this.tig = bt.GC();
                this.tih = true;
              }
              for (;;)
              {
                AppMethodBeat.o(163583);
                return false;
                label100:
                this.tih = false;
                continue;
                label108:
                if ((paramAnonymous2MotionEvent.getActionMasked() == 1) && (this.tih) && (bt.aS(this.tig) < 500L))
                {
                  paramAnonymous2View = new Rect();
                  EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this).getGlobalVisibleRect(paramAnonymous2View);
                  int i = (int)paramAnonymous2MotionEvent.getRawX();
                  int j = (int)paramAnonymous2MotionEvent.getRawY();
                  if ((Math.abs(i - this.qXK) <= 20.0F) && (Math.abs(j - this.seQ) <= 20.0F) && (paramAnonymous2View.contains(i, j)))
                  {
                    ad.i("MicroMsg.EnvelopeAppBarLayout", "click collapse view");
                    EnvelopeAppBarLayout.h(EnvelopeAppBarLayout.this);
                    EnvelopeAppBarLayout.this.postDelayed(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(163582);
                        EnvelopeAppBarLayout.this.b(false, true, true);
                        AppMethodBeat.o(163582);
                      }
                    }, 30L);
                  }
                }
              }
            }
          });
          EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this).setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
            {
              return false;
            }
          });
          EnvelopeAppBarLayout.i(EnvelopeAppBarLayout.this);
          AppMethodBeat.o(163584);
          return;
        }
      }
    });
    this.thD = new EnvelopeStoryVideoManager();
    initView();
    this.thQ = new AppBarLayout.b()
    {
      private int tik = 0;
      
      public final void c(AppBarLayout paramAnonymousAppBarLayout, int paramAnonymousInt)
      {
        AppMethodBeat.i(163585);
        ad.d("MicroMsg.EnvelopeAppBarLayout", "offset: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        paramAnonymousInt = Math.abs(paramAnonymousInt);
        int i = paramAnonymousAppBarLayout.getTotalScrollRange() - paramAnonymousInt;
        float f1 = i / (paramAnonymousAppBarLayout.getTotalScrollRange() * 1.0F);
        float f2 = 1.0F - f1;
        if (!EnvelopeAppBarLayout.j(EnvelopeAppBarLayout.this))
        {
          EnvelopeAppBarLayout.k(EnvelopeAppBarLayout.this).setAlpha(1.0F - f2);
          if (paramAnonymousInt <= EnvelopeAppBarLayout.l(EnvelopeAppBarLayout.this))
          {
            EnvelopeAppBarLayout.m(EnvelopeAppBarLayout.this).setAlpha(0.0F);
            EnvelopeAppBarLayout.n(EnvelopeAppBarLayout.this).setAlpha(1.0F - f2);
          }
        }
        else
        {
          if (EnvelopeAppBarLayout.o(EnvelopeAppBarLayout.this) != null)
          {
            if (EnvelopeAppBarLayout.this.thI != 2) {
              break label259;
            }
            EnvelopeAppBarLayout.o(EnvelopeAppBarLayout.this).setAlpha(f2);
          }
          label146:
          if ((paramAnonymousAppBarLayout.getTotalScrollRange() - paramAnonymousInt != 0) || (this.tik == paramAnonymousInt)) {
            break label346;
          }
          EnvelopeAppBarLayout.q(EnvelopeAppBarLayout.this);
        }
        for (;;)
        {
          if (EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this) != null) {
            EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this).setAlpha((float)(f1 * 0.7D));
          }
          this.tik = paramAnonymousInt;
          AppMethodBeat.o(163585);
          return;
          int j = paramAnonymousAppBarLayout.getTotalScrollRange();
          int k = EnvelopeAppBarLayout.l(EnvelopeAppBarLayout.this);
          float f3 = (paramAnonymousInt - EnvelopeAppBarLayout.l(EnvelopeAppBarLayout.this)) / ((j - k) * 1.0F);
          EnvelopeAppBarLayout.m(EnvelopeAppBarLayout.this).setAlpha(f3);
          break;
          label259:
          if (EnvelopeAppBarLayout.this.thI != 1) {
            break label146;
          }
          ad.d("MicroMsg.EnvelopeAppBarLayout", "distance: %s", new Object[] { Integer.valueOf(i) });
          if (i <= EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this))
          {
            f2 = i / (EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this) * 1.0F);
            EnvelopeAppBarLayout.o(EnvelopeAppBarLayout.this).setAlpha(f2);
            break label146;
          }
          EnvelopeAppBarLayout.o(EnvelopeAppBarLayout.this).setAlpha(1.0F);
          break label146;
          label346:
          if ((paramAnonymousInt == 0) && (this.tik != paramAnonymousInt)) {
            EnvelopeAppBarLayout.r(EnvelopeAppBarLayout.this);
          }
        }
      }
    };
    a(this.thQ);
    AppMethodBeat.o(163597);
  }
  
  private void initView()
  {
    AppMethodBeat.i(163598);
    this.tgX = findViewById(2131305332);
    this.thc = ((ViewGroup)findViewById(2131301776));
    this.thd = ((ViewGroup)findViewById(2131301779));
    this.tgY = ((ImageView)findViewById(2131305413));
    this.tht = ((ProgressBar)findViewById(2131305414));
    this.tgZ = ((RecyclerHorizontalViewPager)findViewById(2131305482));
    this.the = ((MediaBannerIndicator)findViewById(2131305333));
    this.thf = ((TextView)findViewById(2131305345));
    this.thg = ((RoundCornerImageView)findViewById(2131305462));
    this.thh = ((TextView)findViewById(2131305502));
    this.thi = ((TextView)findViewById(2131307252));
    this.thr = ((ViewGroup)findViewById(2131305490));
    this.thj = ((TextView)findViewById(2131301777));
    this.thk = ((TextView)findViewById(2131307211));
    this.thm = ((ViewGroup)findViewById(2131307212));
    this.thl = ((TextView)findViewById(2131305489));
    this.tho = ((ImageView)findViewById(2131301775));
    this.thp = ((ImageView)findViewById(2131305411));
    this.thq = ((ImageView)findViewById(2131305412));
    this.thg.shadowRadius = 4;
    this.thg.shadowColor = getResources().getColor(2131099670);
    this.the.setSelectDrawable(getResources().getDrawable(2131233139));
    this.the.setUnSelectDrawable(getResources().getDrawable(2131233140));
    this.the.setIndicatorWidth(getResources().getDimensionPixelSize(2131165303));
    getContext();
    Object localObject = new HorizontalLayoutManager();
    this.tgZ.setHasFixedSize(true);
    this.tgZ.setItemViewCacheSize(4);
    final com.tencent.mm.plugin.luckymoney.scaledLayout.a locala = new com.tencent.mm.plugin.luckymoney.scaledLayout.a();
    locala.context = getContext();
    locala.tge = true;
    this.tgZ.setSnapHelper(locala);
    this.tgZ.setOnInterceptTouchEvent(new RecyclerHorizontalViewPager.c()
    {
      public final boolean c(MotionEvent paramAnonymousMotionEvent, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(163589);
        if (paramAnonymousMotionEvent.getAction() == 0) {
          locala.tgd = com.tencent.mm.plugin.luckymoney.scaledLayout.a.h(this.tin);
        }
        AppMethodBeat.o(163589);
        return paramAnonymousBoolean;
      }
      
      public final void m(MotionEvent paramAnonymousMotionEvent) {}
    });
    ((HorizontalLayoutManager)localObject).old = 1;
    ((HorizontalLayoutManager)localObject).aw(true);
    ((LinearLayoutManager)localObject).anF = 3;
    ((HorizontalLayoutManager)localObject).setOrientation(0);
    this.tgZ.setLayoutManager((RecyclerView.i)localObject);
    localObject = new WxRecyclerAdapter(new com.tencent.mm.view.recyclerview.c()
    {
      public final b<?> zm(int paramAnonymousInt)
      {
        AppMethodBeat.i(163590);
        EnvelopeAppBarLayout.a locala = new EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this);
        AppMethodBeat.o(163590);
        return locala;
      }
    }, this.thC, false);
    this.tgZ.setAdapter((RecyclerView.a)localObject);
    this.tgZ.setPageChangeListener(new RecyclerHorizontalViewPager.b()
    {
      public final void ad(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(163591);
        ad.i("MicroMsg.EnvelopeAppBarLayout", "on page change: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        com.tencent.mm.view.recyclerview.e locale;
        EnvelopeAppBarLayout.b localb;
        if (paramAnonymousBoolean)
        {
          if (EnvelopeAppBarLayout.u(EnvelopeAppBarLayout.this) == paramAnonymousInt)
          {
            AppMethodBeat.o(163591);
            return;
          }
          EnvelopeAppBarLayout.this.cLT();
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, paramAnonymousInt);
          locale = (com.tencent.mm.view.recyclerview.e)EnvelopeAppBarLayout.v(EnvelopeAppBarLayout.this).cj(paramAnonymousInt);
          if (locale != null)
          {
            paramAnonymousBoolean = EnvelopeAppBarLayout.w(EnvelopeAppBarLayout.this);
            localb = (EnvelopeAppBarLayout.b)locale.IbA;
            if (!paramAnonymousBoolean) {
              break label206;
            }
            localb.cLX();
          }
        }
        for (;;)
        {
          EnvelopeAppBarLayout.x(EnvelopeAppBarLayout.this).a(EnvelopeAppBarLayout.this.getContext(), (FrameLayout)locale.abq(2131301783), (ImageView)locale.abq(2131301780), (ProgressBar)locale.abq(2131301781), localb.tir.Eqn, localb.videoWidth, localb.videoHeight, paramAnonymousInt, paramAnonymousBoolean);
          com.tencent.mm.plugin.luckymoney.a.d.sw(6);
          a.tje += 1;
          EnvelopeAppBarLayout.y(EnvelopeAppBarLayout.this).setCurrentIndex(paramAnonymousInt);
          AppMethodBeat.o(163591);
          return;
          label206:
          a.tjh += 1;
        }
      }
    });
    AppMethodBeat.o(163598);
  }
  
  private void sq(int paramInt)
  {
    AppMethodBeat.i(163607);
    this.thI = paramInt;
    switch (this.thI)
    {
    default: 
      AppMethodBeat.o(163607);
      return;
    case 0: 
      this.thJ = true;
      this.thK = true;
      this.thc.setVisibility(8);
      this.thq.setVisibility(8);
      if (ai.Eq())
      {
        this.thp.setImageResource(2131690387);
        AppMethodBeat.o(163607);
        return;
      }
      this.thp.setImageResource(2131690386);
      AppMethodBeat.o(163607);
      return;
    case 1: 
      this.thJ = true;
      this.thK = true;
      this.thc.setVisibility(0);
      this.tho.setVisibility(8);
      this.tgY.setVisibility(0);
      this.thq.setVisibility(8);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.bottomMargin = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 32);
      this.thm.setLayoutParams(localLayoutParams);
      if (ai.Eq())
      {
        this.thp.setImageResource(2131690387);
        AppMethodBeat.o(163607);
        return;
      }
      this.thp.setImageResource(2131690386);
      AppMethodBeat.o(163607);
      return;
    }
    this.thJ = false;
    this.thK = false;
    this.thc.setVisibility(0);
    this.tho.setVisibility(0);
    this.thq.setVisibility(0);
    this.thq.setAlpha(0.0F);
    if (ai.Eq()) {
      this.thp.setImageResource(2131690387);
    }
    for (;;)
    {
      com.tencent.mm.plugin.luckymoney.a.c.bi(4, this.thG);
      break;
      this.thp.setImageResource(2131690386);
    }
  }
  
  public final void a(cic paramcic, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(187040);
    if (bt.isNullOrNil(this.thG))
    {
      sq(0);
      this.thv = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 502);
      paramcic = new AppBarLayout.LayoutParams(this.thv);
      paramcic.kA = 3;
      this.tgX.setMinimumHeight(this.thy);
      this.tgX.setLayoutParams(paramcic);
    }
    for (;;)
    {
      ad.i("MicroMsg.EnvelopeAppBarLayout", "set envelope story: %s", new Object[] { Integer.valueOf(this.thI) });
      AppMethodBeat.o(187040);
      return;
      if (paramcic != null) {
        break;
      }
      sq(1);
      cLV();
      this.thj.setText(paramString2);
    }
    this.thE = paramcic;
    this.thF = paramString1;
    this.tib = paramBoolean;
    this.thf.setText(this.thE.description);
    this.thh.setText(this.thE.Edu);
    this.thj.setText(this.thE.title);
    if (paramcic.Edz != null) {
      paramInt = paramcic.Edz.gGU;
    }
    if (paramInt == 2)
    {
      this.thk.setVisibility(0);
      this.thi.setVisibility(0);
      if (this.thE.ntg != 2) {
        break label461;
      }
      if (!bt.isNullOrNil(this.thE.Edx))
      {
        if (!this.thY)
        {
          com.tencent.mm.plugin.luckymoney.a.c.bi(11, this.thG);
          this.thY = true;
        }
        com.tencent.mm.wallet_core.ui.e.aS(this.thr, 100);
        a.tjm = 1;
        this.thr.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(174332);
            ad.d("MicroMsg.EnvelopeAppBarLayout", "go to profile");
            if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
            {
              com.tencent.mm.wallet_core.ui.e.cm(EnvelopeAppBarLayout.this.getContext(), EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).Edx);
              com.tencent.mm.plugin.luckymoney.a.d.sw(7);
              com.tencent.mm.plugin.luckymoney.a.c.bi(13, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
              a.tjn += 1;
            }
            AppMethodBeat.o(174332);
          }
        });
        this.thl.setText(2131760853);
      }
      label303:
      if (bt.isNullOrNil(paramcic.gGR)) {
        break label537;
      }
      ((com.tencent.mm.plugin.luckymoney.a.a)g.ab(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.thg, paramcic.gGR, paramcic.gGS, paramString1);
      this.thg.setVisibility(0);
      label348:
      this.thC.clear();
      if (paramcic.Edv.isEmpty()) {
        break label1249;
      }
      a.tjl = 1;
      paramcic = paramcic.Edv.iterator();
    }
    for (;;)
    {
      if (!paramcic.hasNext()) {
        break label562;
      }
      paramString1 = (cyg)paramcic.next();
      paramString2 = new b();
      paramString2.tir = paramString1;
      this.thC.add(paramString2);
      if (paramString1.Eqm == 2)
      {
        this.rBj += 1;
        continue;
        this.thk.setVisibility(8);
        this.thi.setVisibility(8);
        break;
        label461:
        if (this.thE.ntg == 3)
        {
          if (!this.thZ)
          {
            com.tencent.mm.plugin.luckymoney.a.c.bi(12, this.thG);
            this.thZ = true;
          }
          this.thr.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(187037);
              ad.d("MicroMsg.EnvelopeAppBarLayout", "go to mini app");
              if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
              {
                com.tencent.mm.wallet_core.ui.e.v(EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).Edx, EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).Edw, 0, 1100);
                com.tencent.mm.plugin.luckymoney.a.d.sw(7);
                com.tencent.mm.plugin.luckymoney.a.c.bi(14, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
                a.tjn += 1;
              }
              AppMethodBeat.o(187037);
            }
          });
          this.thl.setText(2131760854);
          break label303;
        }
        this.thr.setVisibility(8);
        a.tjm = 0;
        break label303;
        label537:
        this.thg.setVisibility(8);
        break label348;
      }
      this.thV += 1;
    }
    label562:
    this.the.setCount(this.thC.size());
    sq(2);
    paramcic = new Rect();
    getWindowVisibleDisplayFrame(paramcic);
    this.thu = (paramcic.right - paramcic.left);
    this.thv = ((int)(this.thu * 1.667F));
    paramInt = (int)(this.thu * 1.335F);
    this.thw = (this.thv - paramInt);
    this.tgY.setMinimumHeight(paramInt);
    paramcic = new AppBarLayout.LayoutParams(this.thv);
    paramcic.kA = 3;
    this.tgX.setLayoutParams(paramcic);
    this.tgX.setMinimumHeight(this.thz);
    setExpanded(false);
    if (this.tib)
    {
      paramInt = ((Integer)g.afB().afk().get(ae.a.Fsz, Integer.valueOf(0))).intValue();
      label724:
      ad.i("MicroMsg.EnvelopeAppBarLayout", "show first guide: %s", new Object[] { Integer.valueOf(paramInt) });
      if ((paramInt >= 3) || (this.thI != 2)) {
        break label1197;
      }
      paramInt = 1;
      label762:
      if (paramInt != 0)
      {
        this.tia = true;
        this.ths = ((ViewGroup)findViewById(2131301778));
        this.ths.setVisibility(0);
        this.thc.setVisibility(4);
        this.thM = new ValueAnimator();
        this.thM.setDuration(700L);
        this.thM.setInterpolator(new AccelerateDecelerateInterpolator());
        this.thM.setIntValues(new int[] { 0, this.thx });
        this.thN = new ObjectAnimator();
        this.thN.setPropertyName("alpha");
        this.thN.setFloatValues(new float[] { 1.0F, 0.0F });
        this.thN.setTarget(this.ths);
        this.thN.setDuration(300L);
        this.thN.setStartDelay(200L);
        this.thN.addListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(163586);
            EnvelopeAppBarLayout.o(EnvelopeAppBarLayout.this).setVisibility(0);
            EnvelopeAppBarLayout.o(EnvelopeAppBarLayout.this).setAlpha(0.0F);
            AppMethodBeat.o(163586);
          }
        });
        this.thO = new ValueAnimator();
        this.thO.setInterpolator(android.support.design.a.a.dT);
        this.thO.setStartDelay(200L);
        this.thO.setDuration(300L);
        this.thO.setIntValues(new int[] { this.thx, 0 });
        paramcic = new ValueAnimator.AnimatorUpdateListener()
        {
          int til = 0;
          
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(163587);
            ad.d("MicroMsg.EnvelopeAppBarLayout", "animate value: " + paramAnonymousValueAnimator.getAnimatedValue());
            int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
            int j = i - this.til;
            this.til = i;
            float f = (EnvelopeAppBarLayout.s(EnvelopeAppBarLayout.this) - i) / (EnvelopeAppBarLayout.s(EnvelopeAppBarLayout.this) * 1.0F);
            if (EnvelopeAppBarLayout.this.thI == 2) {
              EnvelopeAppBarLayout.m(EnvelopeAppBarLayout.this).setAlpha(f);
            }
            EnvelopeAppBarLayout.this.offsetTopAndBottom(j);
            if (j > 0)
            {
              EnvelopeAppBarLayout.t(EnvelopeAppBarLayout.this).offsetTopAndBottom((int)(j * 0.123F));
              AppMethodBeat.o(163587);
              return;
            }
            EnvelopeAppBarLayout.o(EnvelopeAppBarLayout.this).setAlpha(f);
            AppMethodBeat.o(163587);
          }
        };
        this.thM.addUpdateListener(paramcic);
        this.thO.addUpdateListener(paramcic);
        this.thP = new AnimatorSet();
        this.thP.playSequentially(new Animator[] { this.thM, this.thN, this.thO });
        this.thP.addListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(163588);
            EnvelopeAppBarLayout.t(EnvelopeAppBarLayout.this).setVisibility(8);
            if (EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this) != null) {
              EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).tjp = false;
            }
            AppMethodBeat.o(163588);
          }
          
          public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator) {}
        });
        post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187038);
            if (EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this) != null) {
              EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).tjp = true;
            }
            EnvelopeAppBarLayout.A(EnvelopeAppBarLayout.this).setStartDelay(700L);
            EnvelopeAppBarLayout.A(EnvelopeAppBarLayout.this).start();
            AppMethodBeat.o(187038);
          }
        });
        if (!this.tib) {
          break label1203;
        }
        paramInt = ((Integer)g.afB().afk().get(ae.a.Fsz, Integer.valueOf(0))).intValue();
        g.afB().afk().set(ae.a.Fsz, Integer.valueOf(paramInt + 1));
      }
    }
    for (;;)
    {
      this.tgZ.getAdapter().aql.notifyChanged();
      break;
      paramInt = ((Integer)g.afB().afk().get(ae.a.Fsy, Integer.valueOf(0))).intValue();
      break label724;
      label1197:
      paramInt = 0;
      break label762;
      label1203:
      paramInt = ((Integer)g.afB().afk().get(ae.a.Fsy, Integer.valueOf(0))).intValue();
      g.afB().afk().set(ae.a.Fsy, Integer.valueOf(paramInt + 1));
      continue;
      label1249:
      sq(1);
      cLV();
    }
  }
  
  public final void cLT()
  {
    AppMethodBeat.i(182455);
    Object localObject1;
    Object localObject2;
    int i;
    if (this.ana >= 0)
    {
      if (bt.isNullOrNil(a.sessionId))
      {
        AppMethodBeat.o(182455);
        return;
      }
      localObject1 = (com.tencent.mm.view.recyclerview.e)this.tgZ.cj(this.ana);
      if (localObject1 != null)
      {
        boolean bool = cLW();
        localObject1 = (b)((com.tencent.mm.view.recyclerview.e)localObject1).IbA;
        if (bool)
        {
          localObject2 = this.thD;
          i = this.ana;
          localObject2 = (EnvelopeStoryVideoManager.c)((EnvelopeStoryVideoManager)localObject2).tiF.get(Integer.valueOf(i));
          if (localObject2 == null)
          {
            AppMethodBeat.o(182455);
            return;
          }
          ((EnvelopeStoryVideoManager.c)localObject2).tiU = ((EnvelopeStoryVideoManager.c)localObject2).tiX.getCurrPosSec();
          if (((EnvelopeStoryVideoManager.c)localObject2).tiW.get() == 1) {
            i = (int)(((EnvelopeStoryVideoManager.c)localObject2).tiU - ((EnvelopeStoryVideoManager.c)localObject2).tiT);
          }
        }
      }
    }
    for (;;)
    {
      h.vKh.f(19270, new Object[] { Integer.valueOf(2), this.thF, ((EnvelopeStoryVideoManager.c)localObject2).tiW, "", ((b)localObject1).tir.Eqn, Integer.valueOf(i), a.sessionId });
      AppMethodBeat.o(182455);
      return;
      if (((EnvelopeStoryVideoManager.c)localObject2).tiW.get() > 1)
      {
        i = ((EnvelopeStoryVideoManager.c)localObject2).tiW.get();
        i = (int)(((EnvelopeStoryVideoManager.c)localObject2).tiQ - ((EnvelopeStoryVideoManager.c)localObject2).tiT + ((EnvelopeStoryVideoManager.c)localObject2).tiU + (i - 1) * ((EnvelopeStoryVideoManager.c)localObject2).tiQ);
        continue;
        h.vKh.f(19270, new Object[] { Integer.valueOf(1), this.thF, Integer.valueOf(0), ((b)localObject1).tir.Eqn, "", Integer.valueOf(0), a.sessionId });
        AppMethodBeat.o(182455);
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public final void hg(String paramString1, String paramString2)
  {
    AppMethodBeat.i(163608);
    if ((bt.isNullOrNil(this.thG)) && (!bt.isNullOrNil(paramString1)))
    {
      this.thG = paramString1;
      this.thH = paramString2;
      this.tht.setVisibility(0);
      ((com.tencent.mm.plugin.luckymoney.a.a)g.ab(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.tgY, this.thG, this.thH, this.thF, this.thv, this.thu, 0, new a.a()
      {
        public final void ib(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(187039);
          EnvelopeAppBarLayout.B(EnvelopeAppBarLayout.this).setVisibility(8);
          AppMethodBeat.o(187039);
        }
      });
    }
    AppMethodBeat.o(163608);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(163606);
    super.onFinishInflate();
    AppMethodBeat.o(163606);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onUIDestroy()
  {
    AppMethodBeat.i(163604);
    cLT();
    this.thD.cMd();
    if ((this.thI == 1) || (this.thI == 2)) {
      a.sw(3);
    }
    com.tencent.mm.plugin.luckymoney.a.d.sw(11);
    AppMethodBeat.o(163604);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void onUIPause() {}
  
  public void setActivityLifeCycle(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(163603);
    paramMMActivity.getLifecycle().addObserver(this.thD);
    paramMMActivity.getLifecycle().addObserver(this);
    this.nqA = paramMMActivity;
    EnvelopeStoryVideoManager localEnvelopeStoryVideoManager = this.thD;
    localEnvelopeStoryVideoManager.nqA = paramMMActivity;
    aq.f(new EnvelopeStoryVideoManager.1(localEnvelopeStoryVideoManager));
    AppMethodBeat.o(163603);
  }
  
  final class a
    extends b<EnvelopeAppBarLayout.b>
  {
    a() {}
    
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.e parame, int paramInt) {}
    
    public final int getLayoutId()
    {
      return 2131494637;
    }
  }
  
  final class b
    implements com.tencent.mm.view.recyclerview.a
  {
    public cyg tir;
    public int videoHeight = -1;
    public int videoWidth = -1;
    
    b() {}
    
    public final long bMs()
    {
      return 0L;
    }
    
    public final int bMt()
    {
      return 0;
    }
    
    public final void cLX()
    {
      AppMethodBeat.i(163594);
      if ((this.videoHeight > 0) && (this.videoWidth > 0))
      {
        AppMethodBeat.o(163594);
        return;
      }
      float f = this.tir.height / (this.tir.width * 1.0F);
      if (f > 1.667F)
      {
        this.videoHeight = EnvelopeAppBarLayout.D(EnvelopeAppBarLayout.this);
        this.videoWidth = ((int)(EnvelopeAppBarLayout.D(EnvelopeAppBarLayout.this) / f));
      }
      for (;;)
      {
        ad.d("MicroMsg.EnvelopeAppBarLayout", "video size: %s, %s", new Object[] { Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight) });
        AppMethodBeat.o(163594);
        return;
        if (f < 1.667F)
        {
          this.videoWidth = EnvelopeAppBarLayout.E(EnvelopeAppBarLayout.this);
          this.videoHeight = ((int)(f * EnvelopeAppBarLayout.E(EnvelopeAppBarLayout.this)));
        }
        else
        {
          this.videoHeight = EnvelopeAppBarLayout.D(EnvelopeAppBarLayout.this);
          this.videoWidth = EnvelopeAppBarLayout.E(EnvelopeAppBarLayout.this);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout
 * JD-Core Version:    0.7.0.1
 */