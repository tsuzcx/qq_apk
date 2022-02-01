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
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.LayoutParams;
import android.support.design.widget.AppBarLayout.b;
import android.support.design.widget.CoordinatorLayout.d;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
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
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.luckymoney.a.a.a;
import com.tencent.mm.plugin.luckymoney.ui.HorizontalLayoutManager;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI;
import com.tencent.mm.protocal.protobuf.dlr;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.edn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.view.MediaBannerIndicator;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.RecyclerHorizontalViewPager.b;
import com.tencent.mm.view.RecyclerHorizontalViewPager.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class EnvelopeAppBarLayout
  extends AppBarLayout
  implements LifecycleObserver
{
  private int apZ;
  private boolean isPreview;
  private int xiP;
  private View yYW;
  private ImageView yYX;
  private RecyclerHorizontalViewPager yYY;
  private RecyclerView yYZ;
  private int yZA;
  private EnvelopeStoryBehavior yZB;
  private ArrayList<b> yZC;
  private EnvelopeStoryVideoManager yZD;
  private dlt yZE;
  private String yZF;
  private String yZG;
  private String yZH;
  public int yZI;
  private boolean yZJ;
  public boolean yZK;
  private boolean yZL;
  private ValueAnimator yZM;
  private ObjectAnimator yZN;
  private ValueAnimator yZO;
  private AnimatorSet yZP;
  private AppBarLayout.b yZQ;
  private final float yZR;
  private final float yZS;
  private final float yZT;
  private boolean yZU;
  private boolean yZV;
  private int yZW;
  private boolean yZX;
  private boolean yZY;
  private boolean yZZ;
  private TouchCoordinatorLayout yZa;
  private ViewGroup yZb;
  private ViewGroup yZc;
  private MediaBannerIndicator yZd;
  private TextView yZe;
  private RoundCornerImageView yZf;
  private TextView yZg;
  private TextView yZh;
  private TextView yZi;
  private TextView yZj;
  private TextView yZk;
  private ViewGroup yZl;
  private View yZm;
  private ImageView yZn;
  private ImageView yZo;
  private ImageView yZp;
  private ViewGroup yZq;
  private ViewGroup yZr;
  private ProgressBar yZs;
  public LuckyMoneyDetailUI yZt;
  private int yZu;
  private int yZv;
  private int yZw;
  private int yZx;
  private int yZy;
  private int yZz;
  private boolean zaa;
  private boolean zab;
  private View.OnClickListener zac;
  private int zad;
  
  public EnvelopeAppBarLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(163595);
    this.yZx = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 130);
    this.yZy = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 120);
    this.yZz = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 420);
    this.yZA = (this.yZz - this.yZy);
    this.apZ = 0;
    this.yZC = new ArrayList();
    this.yZJ = true;
    this.yZK = false;
    this.yZL = false;
    this.yZR = 1.335F;
    this.yZS = 1.0F;
    this.yZT = 0.6F;
    this.yZU = false;
    this.yZV = false;
    this.yZX = false;
    this.yZY = false;
    this.yZZ = false;
    this.zaa = false;
    this.zab = false;
    this.isPreview = false;
    this.zac = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163578);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((!EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this)) && (EnvelopeAppBarLayout.this.yZI == 2))
        {
          EnvelopeAppBarLayout.this.b(true, true, true);
          EnvelopeAppBarLayout.b(EnvelopeAppBarLayout.this);
          com.tencent.mm.plugin.luckymoney.a.d.xV(5);
          com.tencent.mm.plugin.luckymoney.a.c.bC(6, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(163578);
      }
    };
    this.zad = MMApplicationContext.getResources().getDimensionPixelSize(2131166614);
    init();
    AppMethodBeat.o(163595);
  }
  
  public EnvelopeAppBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163596);
    this.yZx = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 130);
    this.yZy = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 120);
    this.yZz = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 420);
    this.yZA = (this.yZz - this.yZy);
    this.apZ = 0;
    this.yZC = new ArrayList();
    this.yZJ = true;
    this.yZK = false;
    this.yZL = false;
    this.yZR = 1.335F;
    this.yZS = 1.0F;
    this.yZT = 0.6F;
    this.yZU = false;
    this.yZV = false;
    this.yZX = false;
    this.yZY = false;
    this.yZZ = false;
    this.zaa = false;
    this.zab = false;
    this.isPreview = false;
    this.zac = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163578);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((!EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this)) && (EnvelopeAppBarLayout.this.yZI == 2))
        {
          EnvelopeAppBarLayout.this.b(true, true, true);
          EnvelopeAppBarLayout.b(EnvelopeAppBarLayout.this);
          com.tencent.mm.plugin.luckymoney.a.d.xV(5);
          com.tencent.mm.plugin.luckymoney.a.c.bC(6, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(163578);
      }
    };
    this.zad = MMApplicationContext.getResources().getDimensionPixelSize(2131166614);
    init();
    AppMethodBeat.o(163596);
  }
  
  private void efG()
  {
    AppMethodBeat.i(163599);
    this.yZb.setOnClickListener(this.zac);
    this.yYX.setOnClickListener(this.zac);
    AppMethodBeat.o(163599);
  }
  
  private void efH()
  {
    AppMethodBeat.i(163600);
    Object localObject = new Rect();
    getWindowVisibleDisplayFrame((Rect)localObject);
    this.yZu = (((Rect)localObject).right - ((Rect)localObject).left);
    this.yZv = ((int)(this.yZu * 1.335F));
    this.yYX.setMinimumHeight(this.yZv);
    localObject = new AppBarLayout.LayoutParams(this.yZv);
    ((AppBarLayout.LayoutParams)localObject).nu = 3;
    this.yYW.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.yYW.setMinimumHeight(this.yZy);
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174331);
        EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this).G(-(EnvelopeAppBarLayout.this.getTotalScrollRange() - EnvelopeAppBarLayout.j(EnvelopeAppBarLayout.this)));
        EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this).setAlpha(1.0F);
        AppMethodBeat.o(174331);
      }
    }, 50L);
    AppMethodBeat.o(163600);
  }
  
  private boolean efI()
  {
    AppMethodBeat.i(163601);
    com.tencent.mm.view.recyclerview.h localh = (com.tencent.mm.view.recyclerview.h)this.yYY.ch(this.apZ);
    if (localh == null)
    {
      AppMethodBeat.o(163601);
      return false;
    }
    if (((b)localh.Rra).zaq.Gat == 2)
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
    inflate(getContext(), 2131495360, this);
    setExpanded(false);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163584);
        Object localObject = (CoordinatorLayout.d)EnvelopeAppBarLayout.this.getLayoutParams();
        EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, (EnvelopeStoryBehavior)((CoordinatorLayout.d)localObject).qC);
        EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this).yZK = EnvelopeAppBarLayout.this.yZK;
        localObject = EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this);
        if ((EnvelopeAppBarLayout.this.yZI == 1) || (EnvelopeAppBarLayout.this.yZI == 2)) {}
        for (boolean bool = true;; bool = false)
        {
          ((EnvelopeStoryBehavior)localObject).zaz = bool;
          EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this).zaA = EnvelopeAppBarLayout.e(EnvelopeAppBarLayout.this);
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, (TouchCoordinatorLayout)EnvelopeAppBarLayout.this.getParent());
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).findViewById(2131304058));
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, (RecyclerView)EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).findViewById(2131304073));
          EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).b(new View.OnTouchListener()
          {
            float aTD;
            float aTE;
            long zaf;
            boolean zag = false;
            
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
                this.aTD = paramAnonymous2MotionEvent.getRawX();
                this.aTE = paramAnonymous2MotionEvent.getRawY();
                this.zaf = Util.currentTicks();
                this.zag = true;
              }
              for (;;)
              {
                AppMethodBeat.o(163583);
                return false;
                label100:
                this.zag = false;
                continue;
                label108:
                if ((paramAnonymous2MotionEvent.getActionMasked() == 1) && (this.zag) && (Util.ticksToNow(this.zaf) < 500L))
                {
                  paramAnonymous2View = new Rect();
                  EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this).getGlobalVisibleRect(paramAnonymous2View);
                  int i = (int)paramAnonymous2MotionEvent.getRawX();
                  int j = (int)paramAnonymous2MotionEvent.getRawY();
                  if ((Math.abs(i - this.aTD) <= 20.0F) && (Math.abs(j - this.aTE) <= 20.0F) && (paramAnonymous2View.contains(i, j)))
                  {
                    Log.i("MicroMsg.EnvelopeAppBarLayout", "click collapse view");
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
    this.yZD = new EnvelopeStoryVideoManager();
    initView();
    this.yZQ = new AppBarLayout.b()
    {
      private int zaj = 0;
      
      public final void c(AppBarLayout paramAnonymousAppBarLayout, int paramAnonymousInt)
      {
        AppMethodBeat.i(163585);
        Log.d("MicroMsg.EnvelopeAppBarLayout", "offset: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
        paramAnonymousInt = Math.abs(paramAnonymousInt);
        float f1 = (paramAnonymousAppBarLayout.getTotalScrollRange() - EnvelopeAppBarLayout.j(EnvelopeAppBarLayout.this) - paramAnonymousInt) / ((paramAnonymousAppBarLayout.getTotalScrollRange() - EnvelopeAppBarLayout.j(EnvelopeAppBarLayout.this)) * 1.0F);
        float f2 = 1.0F - f1;
        if (!EnvelopeAppBarLayout.k(EnvelopeAppBarLayout.this))
        {
          EnvelopeAppBarLayout.l(EnvelopeAppBarLayout.this).setAlpha(1.0F - f2);
          if (paramAnonymousInt <= EnvelopeAppBarLayout.m(EnvelopeAppBarLayout.this))
          {
            EnvelopeAppBarLayout.n(EnvelopeAppBarLayout.this).setAlpha(0.0F);
            EnvelopeAppBarLayout.o(EnvelopeAppBarLayout.this).setAlpha(1.0F - f2);
          }
        }
        else
        {
          if (EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this) != null)
          {
            if (EnvelopeAppBarLayout.this.yZI != 2) {
              break label283;
            }
            EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this).setAlpha(f2);
          }
          label158:
          if ((paramAnonymousAppBarLayout.getTotalScrollRange() - paramAnonymousInt != 0) || (this.zaj == paramAnonymousInt)) {
            break label378;
          }
          EnvelopeAppBarLayout.q(EnvelopeAppBarLayout.this);
        }
        for (;;)
        {
          if (EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this) != null) {
            EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this).setAlpha((float)(0.7D * f1));
          }
          this.zaj = paramAnonymousInt;
          AppMethodBeat.o(163585);
          return;
          int i = paramAnonymousAppBarLayout.getTotalScrollRange();
          int j = EnvelopeAppBarLayout.j(EnvelopeAppBarLayout.this);
          int k = EnvelopeAppBarLayout.m(EnvelopeAppBarLayout.this);
          float f3 = (paramAnonymousInt - EnvelopeAppBarLayout.m(EnvelopeAppBarLayout.this)) / ((i - j - k) * 1.0F);
          EnvelopeAppBarLayout.n(EnvelopeAppBarLayout.this).setAlpha(f3);
          break;
          label283:
          if (EnvelopeAppBarLayout.this.yZI != 1) {
            break label158;
          }
          i = paramAnonymousAppBarLayout.getTotalScrollRange() - paramAnonymousInt;
          Log.d("MicroMsg.EnvelopeAppBarLayout", "distance: %s", new Object[] { Integer.valueOf(i) });
          if (i <= EnvelopeAppBarLayout.j(EnvelopeAppBarLayout.this))
          {
            f2 = i / (EnvelopeAppBarLayout.j(EnvelopeAppBarLayout.this) * 1.0F);
            EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this).setAlpha(f2);
            break label158;
          }
          EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this).setAlpha(1.0F);
          break label158;
          label378:
          if ((paramAnonymousInt == 0) && (this.zaj != paramAnonymousInt)) {
            EnvelopeAppBarLayout.r(EnvelopeAppBarLayout.this);
          }
        }
      }
    };
    a(this.yZQ);
    AppMethodBeat.o(163597);
  }
  
  private void initView()
  {
    AppMethodBeat.i(163598);
    this.yYW = findViewById(2131308537);
    this.yZb = ((ViewGroup)findViewById(2131304079));
    this.yZc = ((ViewGroup)findViewById(2131304084));
    this.yYX = ((ImageView)findViewById(2131308619));
    this.yZs = ((ProgressBar)findViewById(2131308620));
    this.yYY = ((RecyclerHorizontalViewPager)findViewById(2131308688));
    this.yZd = ((MediaBannerIndicator)findViewById(2131308538));
    this.yZe = ((TextView)findViewById(2131308550));
    this.yZf = ((RoundCornerImageView)findViewById(2131308668));
    this.yZg = ((TextView)findViewById(2131308710));
    this.yZh = ((TextView)findViewById(2131308709));
    this.yZq = ((ViewGroup)findViewById(2131308696));
    this.yZi = ((TextView)findViewById(2131304082));
    this.yZj = ((TextView)findViewById(2131304080));
    this.yZl = ((ViewGroup)findViewById(2131304081));
    this.yZk = ((TextView)findViewById(2131308695));
    this.yZn = ((ImageView)findViewById(2131304078));
    this.yZo = ((ImageView)findViewById(2131308617));
    this.yZp = ((ImageView)findViewById(2131308618));
    this.yZf.shadowRadius = 4;
    this.yZf.shadowColor = getResources().getColor(2131099676);
    this.yZd.setSelectDrawable(getResources().getDrawable(2131233793));
    this.yZd.setUnSelectDrawable(getResources().getDrawable(2131233794));
    this.yZd.setIndicatorWidth(getResources().getDimensionPixelSize(2131165314));
    getContext();
    Object localObject = new HorizontalLayoutManager();
    this.yYY.setHasFixedSize(true);
    this.yYY.setItemViewCacheSize(4);
    final com.tencent.mm.plugin.luckymoney.scaledLayout.a locala = new com.tencent.mm.plugin.luckymoney.scaledLayout.a();
    locala.context = getContext();
    locala.yYe = true;
    this.yYY.setSnapHelper(locala);
    this.yYY.setOnInterceptTouchEvent(new RecyclerHorizontalViewPager.c()
    {
      public final boolean b(MotionEvent paramAnonymousMotionEvent, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(163589);
        if (paramAnonymousMotionEvent.getAction() == 0) {
          locala.yYd = com.tencent.mm.plugin.luckymoney.scaledLayout.a.h(this.zam);
        }
        AppMethodBeat.o(163589);
        return paramAnonymousBoolean;
      }
      
      public final void n(MotionEvent paramAnonymousMotionEvent) {}
    });
    ((HorizontalLayoutManager)localObject).qOi = 1;
    ((HorizontalLayoutManager)localObject).setItemPrefetchEnabled(true);
    ((LinearLayoutManager)localObject).aqE = 3;
    ((HorizontalLayoutManager)localObject).setOrientation(0);
    this.yYY.setLayoutManager((RecyclerView.LayoutManager)localObject);
    localObject = new WxRecyclerAdapter(new com.tencent.mm.view.recyclerview.f()
    {
      public final com.tencent.mm.view.recyclerview.e<?> EC(int paramAnonymousInt)
      {
        AppMethodBeat.i(163590);
        EnvelopeAppBarLayout.a locala = new EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this);
        AppMethodBeat.o(163590);
        return locala;
      }
    }, this.yZC, false);
    this.yYY.setAdapter((RecyclerView.a)localObject);
    this.yYY.setPageChangeListener(new RecyclerHorizontalViewPager.b()
    {
      public final void aC(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(213344);
        Log.i("MicroMsg.EnvelopeAppBarLayout", "on page change: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        com.tencent.mm.view.recyclerview.h localh;
        EnvelopeAppBarLayout.b localb;
        if (paramAnonymousBoolean)
        {
          if (EnvelopeAppBarLayout.u(EnvelopeAppBarLayout.this) == paramAnonymousInt)
          {
            AppMethodBeat.o(213344);
            return;
          }
          EnvelopeAppBarLayout.this.efF();
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, paramAnonymousInt);
          localh = (com.tencent.mm.view.recyclerview.h)EnvelopeAppBarLayout.v(EnvelopeAppBarLayout.this).ch(paramAnonymousInt);
          if (localh != null)
          {
            paramAnonymousBoolean = EnvelopeAppBarLayout.w(EnvelopeAppBarLayout.this);
            localb = (EnvelopeAppBarLayout.b)localh.Rra;
            if (!paramAnonymousBoolean) {
              break label206;
            }
            localb.efJ();
          }
        }
        for (;;)
        {
          EnvelopeAppBarLayout.x(EnvelopeAppBarLayout.this).a(EnvelopeAppBarLayout.this.getContext(), (FrameLayout)localh.Mn(2131304088), (ImageView)localh.Mn(2131304085), (ProgressBar)localh.Mn(2131304086), localb.zaq.Gav, localb.videoWidth, localb.videoHeight, paramAnonymousInt, paramAnonymousBoolean);
          com.tencent.mm.plugin.luckymoney.a.d.xV(6);
          b.zbe += 1;
          EnvelopeAppBarLayout.y(EnvelopeAppBarLayout.this).setCurrentIndex(paramAnonymousInt);
          AppMethodBeat.o(213344);
          return;
          label206:
          b.zbh += 1;
        }
      }
    });
    AppMethodBeat.o(163598);
  }
  
  private void xN(int paramInt)
  {
    AppMethodBeat.i(163607);
    this.yZI = paramInt;
    switch (this.yZI)
    {
    default: 
      AppMethodBeat.o(163607);
      return;
    case 0: 
      this.yZJ = true;
      this.yZK = true;
      this.yZb.setVisibility(8);
      this.yZp.setVisibility(8);
      if (com.tencent.mm.ui.ao.isDarkMode())
      {
        this.yZo.setImageResource(2131690532);
        AppMethodBeat.o(163607);
        return;
      }
      this.yZo.setImageResource(2131690531);
      AppMethodBeat.o(163607);
      return;
    case 1: 
      this.yZJ = true;
      this.yZK = true;
      this.yZb.setVisibility(0);
      this.yZn.setVisibility(8);
      this.yYX.setVisibility(0);
      this.yZp.setVisibility(8);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 32);
      this.yZl.setLayoutParams(localLayoutParams);
      if (com.tencent.mm.ui.ao.isDarkMode())
      {
        this.yZo.setImageResource(2131690532);
        AppMethodBeat.o(163607);
        return;
      }
      this.yZo.setImageResource(2131690531);
      AppMethodBeat.o(163607);
      return;
    }
    this.yZJ = false;
    this.yZK = false;
    this.yZb.setVisibility(0);
    this.yZn.setVisibility(0);
    this.yZp.setVisibility(0);
    this.yZp.setAlpha(0.0F);
    if (com.tencent.mm.ui.ao.isDarkMode()) {
      this.yZo.setImageResource(2131690532);
    }
    for (;;)
    {
      com.tencent.mm.plugin.luckymoney.a.c.bC(4, this.yZG);
      break;
      this.yZo.setImageResource(2131690531);
    }
  }
  
  public final void a(dlt paramdlt, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(213346);
    if (Util.isNullOrNil(this.yZG))
    {
      xN(0);
      this.yZv = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 502);
      paramdlt = new AppBarLayout.LayoutParams(this.yZv);
      paramdlt.nu = 3;
      this.yYW.setMinimumHeight(this.yZy);
      this.yYW.setLayoutParams(paramdlt);
    }
    for (;;)
    {
      Log.i("MicroMsg.EnvelopeAppBarLayout", "set envelope story: %s", new Object[] { Integer.valueOf(this.yZI) });
      AppMethodBeat.o(213346);
      return;
      if (paramdlt != null) {
        break;
      }
      xN(1);
      efH();
      this.yZi.setText(paramString2);
      a.zbc = paramString2;
    }
    this.yZE = paramdlt;
    this.yZF = paramString1;
    this.isPreview = paramBoolean;
    this.yZe.setText(this.yZE.description);
    this.yZg.setText(this.yZE.MPn);
    this.yZi.setText(this.yZE.title);
    a.zbc = this.yZE.MPn;
    if (paramdlt.MPq != null) {
      paramInt = paramdlt.MPq.iwy;
    }
    if (paramInt == 2)
    {
      this.yZj.setVisibility(0);
      this.yZh.setVisibility(0);
      if (this.yZE.pTI != 1) {
        break label480;
      }
      if (!this.yZY)
      {
        com.tencent.mm.plugin.luckymoney.a.c.bC(8, this.yZG);
        this.yZY = true;
      }
      this.yZq.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(213336);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          Log.d("MicroMsg.EnvelopeAppBarLayout", "go to h5");
          if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
          {
            com.tencent.mm.wallet_core.ui.f.bn(EnvelopeAppBarLayout.this.getContext(), EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).yUK);
            com.tencent.mm.plugin.luckymoney.a.d.xV(7);
            com.tencent.mm.plugin.luckymoney.a.c.bC(9, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
            b.zbm += 1;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(213336);
        }
      });
      this.yZk.setText(2131755882);
      label291:
      if (!Util.isNullOrNil(this.yZE.MPr)) {
        this.yZk.setText(this.yZE.MPr);
      }
      if (Util.isNullOrNil(paramdlt.iwv)) {
        break label772;
      }
      ((com.tencent.mm.plugin.luckymoney.a.a)g.af(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.yZf, paramdlt.iwv, paramdlt.iww, paramString1);
      this.yZf.setVisibility(0);
      label363:
      this.yZC.clear();
      if (paramdlt.MPo.isEmpty()) {
        break label1507;
      }
      b.zbk = 1;
      a.zbd = 2;
      paramdlt = paramdlt.MPo.iterator();
    }
    for (;;)
    {
      if (!paramdlt.hasNext()) {
        break label797;
      }
      paramString1 = (edn)paramdlt.next();
      paramString2 = new b();
      paramString2.zaq = paramString1;
      this.yZC.add(paramString2);
      if (paramString1.Gat == 2)
      {
        this.xiP += 1;
        continue;
        this.yZj.setVisibility(8);
        this.yZh.setVisibility(8);
        break;
        label480:
        if (this.yZE.pTI == 2)
        {
          if (Util.isNullOrNil(this.yZE.yUL)) {
            break label291;
          }
          if (!this.yZZ)
          {
            com.tencent.mm.plugin.luckymoney.a.c.bC(11, this.yZG);
            this.yZZ = true;
          }
          com.tencent.mm.wallet_core.ui.f.aZ(this.yZq, 100);
          b.zbl = 1;
          this.yZq.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(213337);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              Log.d("MicroMsg.EnvelopeAppBarLayout", "go to profile");
              if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
              {
                com.tencent.mm.wallet_core.ui.f.cL(EnvelopeAppBarLayout.this.getContext(), EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).yUL);
                com.tencent.mm.plugin.luckymoney.a.d.xV(7);
                com.tencent.mm.plugin.luckymoney.a.c.bC(13, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
                b.zbm += 1;
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(213337);
            }
          });
          this.yZk.setText(2131762615);
          break label291;
        }
        if (this.yZE.pTI == 3)
        {
          if (!this.zaa)
          {
            com.tencent.mm.plugin.luckymoney.a.c.bC(12, this.yZG);
            this.zaa = true;
          }
          this.yZq.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(213338);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              Log.d("MicroMsg.EnvelopeAppBarLayout", "go to mini app");
              if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
              {
                com.tencent.mm.wallet_core.ui.f.u(EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).yUL, EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).yUK, 0, 1100);
                com.tencent.mm.plugin.luckymoney.a.d.xV(7);
                com.tencent.mm.plugin.luckymoney.a.c.bC(14, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
                b.zbm += 1;
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(213338);
            }
          });
          this.yZk.setText(2131762619);
          break label291;
        }
        if (this.yZE.pTI == 4)
        {
          if (!this.zaa) {
            this.zaa = true;
          }
          this.yZq.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(213339);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              Log.d("MicroMsg.EnvelopeAppBarLayout", "go to mini app");
              if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.putExtra("finder_username", EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).yUL);
                ((aj)g.ah(aj.class)).enterFinderProfileUI(EnvelopeAppBarLayout.this.yZt, paramAnonymousView);
                b.zbm += 1;
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(213339);
            }
          });
          this.yZk.setText(2131762618);
          break label291;
        }
        if (this.yZE.pTI == 5)
        {
          this.yZq.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(213340);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("uin", EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).MPs);
              paramAnonymousView.putExtra("name", EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).yUL);
              paramAnonymousView.putExtra("headurl", EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).yUK);
              paramAnonymousView.putExtra("extra_scence", 30);
              com.tencent.mm.br.c.b(EnvelopeAppBarLayout.this.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(213340);
            }
          });
          this.yZk.setText(2131762617);
          break label291;
        }
        if (this.yZE.pTI == 6)
        {
          this.yZq.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(213341);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("extra_id", EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).yUL);
              paramAnonymousView.putExtra("preceding_scence", 21);
              com.tencent.mm.br.c.b(EnvelopeAppBarLayout.this.getContext(), "emoji", ".ui.EmojiStoreDetailUI", paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(213341);
            }
          });
          this.yZk.setText(2131762616);
          break label291;
        }
        this.yZq.setVisibility(8);
        b.zbl = 0;
        break label291;
        label772:
        this.yZf.setVisibility(8);
        break label363;
      }
      this.yZW += 1;
    }
    label797:
    this.yZd.setCount(this.yZC.size());
    xN(2);
    paramdlt = new Rect();
    getWindowVisibleDisplayFrame(paramdlt);
    this.yZu = (paramdlt.right - paramdlt.left);
    this.yZv = ((int)(this.yZu * 1.667F));
    paramInt = (int)(this.yZu * 1.335F);
    this.yZw = (this.yZv - paramInt);
    this.yYX.setMinimumHeight(paramInt);
    paramdlt = new AppBarLayout.LayoutParams(this.yZv);
    paramdlt.nu = 3;
    this.yYW.setLayoutParams(paramdlt);
    this.yZz = ((int)(this.yZu * 1.0F));
    this.yYW.setMinimumHeight(this.yZy);
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163580);
        EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this).G(-(EnvelopeAppBarLayout.this.getTotalScrollRange() - EnvelopeAppBarLayout.j(EnvelopeAppBarLayout.this)));
        EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this).setAlpha(1.0F);
        AppMethodBeat.o(163580);
      }
    }, 50L);
    if (this.isPreview)
    {
      paramInt = ((Integer)g.aAh().azQ().get(ar.a.OfD, Integer.valueOf(0))).intValue();
      label982:
      Log.i("MicroMsg.EnvelopeAppBarLayout", "show first guide: %s", new Object[] { Integer.valueOf(paramInt) });
      if ((paramInt >= 3) || (this.yZI != 2)) {
        break label1455;
      }
      paramInt = 1;
      label1020:
      if (paramInt != 0)
      {
        this.zab = true;
        this.yZr = ((ViewGroup)findViewById(2131304083));
        this.yZr.setVisibility(0);
        this.yZb.setVisibility(4);
        this.yZM = new ValueAnimator();
        this.yZM.setDuration(700L);
        this.yZM.setInterpolator(new AccelerateDecelerateInterpolator());
        this.yZM.setIntValues(new int[] { 0, this.yZx });
        this.yZN = new ObjectAnimator();
        this.yZN.setPropertyName("alpha");
        this.yZN.setFloatValues(new float[] { 1.0F, 0.0F });
        this.yZN.setTarget(this.yZr);
        this.yZN.setDuration(300L);
        this.yZN.setStartDelay(200L);
        this.yZN.addListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationStart(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(163586);
            EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this).setVisibility(0);
            EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this).setAlpha(0.0F);
            AppMethodBeat.o(163586);
          }
        });
        this.yZO = new ValueAnimator();
        this.yZO.setInterpolator(android.support.design.a.a.gO);
        this.yZO.setStartDelay(200L);
        this.yZO.setDuration(300L);
        this.yZO.setIntValues(new int[] { this.yZx, 0 });
        paramdlt = new ValueAnimator.AnimatorUpdateListener()
        {
          int zak = 0;
          
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(163587);
            Log.d("MicroMsg.EnvelopeAppBarLayout", "animate value: " + paramAnonymousValueAnimator.getAnimatedValue());
            int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
            int j = i - this.zak;
            this.zak = i;
            float f = (EnvelopeAppBarLayout.s(EnvelopeAppBarLayout.this) - i) / (EnvelopeAppBarLayout.s(EnvelopeAppBarLayout.this) * 1.0F);
            if (EnvelopeAppBarLayout.this.yZI == 2) {
              EnvelopeAppBarLayout.n(EnvelopeAppBarLayout.this).setAlpha(f);
            }
            EnvelopeAppBarLayout.this.offsetTopAndBottom(j);
            if (j > 0)
            {
              EnvelopeAppBarLayout.t(EnvelopeAppBarLayout.this).offsetTopAndBottom((int)(j * 0.123F));
              AppMethodBeat.o(163587);
              return;
            }
            EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this).setAlpha(f);
            AppMethodBeat.o(163587);
          }
        };
        this.yZM.addUpdateListener(paramdlt);
        this.yZO.addUpdateListener(paramdlt);
        this.yZP = new AnimatorSet();
        this.yZP.playSequentially(new Animator[] { this.yZM, this.yZN, this.yZO });
        this.yZP.addListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(163588);
            EnvelopeAppBarLayout.t(EnvelopeAppBarLayout.this).setVisibility(8);
            if (EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this) != null) {
              EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).zbo = false;
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
            AppMethodBeat.i(213342);
            if (EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this) != null) {
              EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).zbo = true;
            }
            EnvelopeAppBarLayout.A(EnvelopeAppBarLayout.this).setStartDelay(700L);
            EnvelopeAppBarLayout.A(EnvelopeAppBarLayout.this).start();
            AppMethodBeat.o(213342);
          }
        });
        if (!this.isPreview) {
          break label1461;
        }
        paramInt = ((Integer)g.aAh().azQ().get(ar.a.OfD, Integer.valueOf(0))).intValue();
        g.aAh().azQ().set(ar.a.OfD, Integer.valueOf(paramInt + 1));
      }
    }
    for (;;)
    {
      this.yYY.getAdapter().atj.notifyChanged();
      break;
      paramInt = ((Integer)g.aAh().azQ().get(ar.a.OfC, Integer.valueOf(0))).intValue();
      break label982;
      label1455:
      paramInt = 0;
      break label1020;
      label1461:
      paramInt = ((Integer)g.aAh().azQ().get(ar.a.OfC, Integer.valueOf(0))).intValue();
      g.aAh().azQ().set(ar.a.OfC, Integer.valueOf(paramInt + 1));
      continue;
      label1507:
      xN(1);
      efH();
    }
  }
  
  public final void efF()
  {
    AppMethodBeat.i(182455);
    Object localObject1;
    Object localObject2;
    int i;
    if (this.apZ >= 0)
    {
      if (Util.isNullOrNil(b.sessionId))
      {
        AppMethodBeat.o(182455);
        return;
      }
      localObject1 = (com.tencent.mm.view.recyclerview.h)this.yYY.ch(this.apZ);
      if (localObject1 != null)
      {
        boolean bool = efI();
        localObject1 = (b)((com.tencent.mm.view.recyclerview.h)localObject1).Rra;
        if (bool)
        {
          localObject2 = this.yZD;
          i = this.apZ;
          localObject2 = (EnvelopeStoryVideoManager.c)((EnvelopeStoryVideoManager)localObject2).zaE.get(Integer.valueOf(i));
          if (localObject2 == null)
          {
            AppMethodBeat.o(182455);
            return;
          }
          ((EnvelopeStoryVideoManager.c)localObject2).zaT = ((EnvelopeStoryVideoManager.c)localObject2).zaV.getCurrPosSec();
          if (((EnvelopeStoryVideoManager.c)localObject2).zaU.get() == 1) {
            i = (int)(((EnvelopeStoryVideoManager.c)localObject2).zaT - ((EnvelopeStoryVideoManager.c)localObject2).zaS);
          }
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h.CyF.a(19270, new Object[] { Integer.valueOf(2), this.yZF, ((EnvelopeStoryVideoManager.c)localObject2).zaU, "", ((b)localObject1).zaq.Gav, Integer.valueOf(i), b.sessionId });
      AppMethodBeat.o(182455);
      return;
      if (((EnvelopeStoryVideoManager.c)localObject2).zaU.get() > 1)
      {
        i = ((EnvelopeStoryVideoManager.c)localObject2).zaU.get();
        i = (int)(((EnvelopeStoryVideoManager.c)localObject2).zaP - ((EnvelopeStoryVideoManager.c)localObject2).zaS + ((EnvelopeStoryVideoManager.c)localObject2).zaT + (i - 1) * ((EnvelopeStoryVideoManager.c)localObject2).zaP);
        continue;
        com.tencent.mm.plugin.report.service.h.CyF.a(19270, new Object[] { Integer.valueOf(1), this.yZF, Integer.valueOf(0), ((b)localObject1).zaq.Gav, "", Integer.valueOf(0), b.sessionId });
        AppMethodBeat.o(182455);
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public final void iC(String paramString1, String paramString2)
  {
    AppMethodBeat.i(163608);
    if ((Util.isNullOrNil(this.yZG)) && (!Util.isNullOrNil(paramString1)))
    {
      this.yZG = paramString1;
      this.yZH = paramString2;
      this.yZs.setVisibility(0);
      ((com.tencent.mm.plugin.luckymoney.a.a)g.af(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.yYX, this.yZG, this.yZH, this.yZF, this.yZv, this.yZu, 0, new a.a()
      {
        public final void ei(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(213343);
          if (paramAnonymousBoolean) {
            EnvelopeAppBarLayout.B(EnvelopeAppBarLayout.this).setVisibility(8);
          }
          AppMethodBeat.o(213343);
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
    efF();
    this.yZD.efP();
    if ((this.yZI == 1) || (this.yZI == 2)) {
      b.xV(3);
    }
    com.tencent.mm.plugin.luckymoney.a.d.xV(11);
    AppMethodBeat.o(163604);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void onUIPause() {}
  
  public void setActivityLifeCycle(LuckyMoneyDetailUI paramLuckyMoneyDetailUI)
  {
    AppMethodBeat.i(213345);
    paramLuckyMoneyDetailUI.getLifecycle().addObserver(this.yZD);
    paramLuckyMoneyDetailUI.getLifecycle().addObserver(this);
    this.yZt = paramLuckyMoneyDetailUI;
    EnvelopeStoryVideoManager localEnvelopeStoryVideoManager = this.yZD;
    localEnvelopeStoryVideoManager.pRg = paramLuckyMoneyDetailUI;
    MMHandlerThread.postToMainThread(new EnvelopeStoryVideoManager.1(localEnvelopeStoryVideoManager));
    AppMethodBeat.o(213345);
  }
  
  final class a
    extends com.tencent.mm.view.recyclerview.e<EnvelopeAppBarLayout.b>
  {
    a() {}
    
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.h paramh, int paramInt) {}
    
    public final int getLayoutId()
    {
      return 2131495359;
    }
  }
  
  final class b
    implements com.tencent.mm.view.recyclerview.a
  {
    public int videoHeight = -1;
    public int videoWidth = -1;
    public edn zaq;
    
    b() {}
    
    public final int cxn()
    {
      return 0;
    }
    
    public final void efJ()
    {
      AppMethodBeat.i(163594);
      if ((this.videoHeight > 0) && (this.videoWidth > 0))
      {
        AppMethodBeat.o(163594);
        return;
      }
      float f = this.zaq.height / (this.zaq.width * 1.0F);
      if (f > 1.667F)
      {
        this.videoHeight = EnvelopeAppBarLayout.D(EnvelopeAppBarLayout.this);
        this.videoWidth = ((int)(EnvelopeAppBarLayout.D(EnvelopeAppBarLayout.this) / f));
      }
      for (;;)
      {
        Log.d("MicroMsg.EnvelopeAppBarLayout", "video size: %s, %s", new Object[] { Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight) });
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
    
    public final long lT()
    {
      return 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout
 * JD-Core Version:    0.7.0.1
 */