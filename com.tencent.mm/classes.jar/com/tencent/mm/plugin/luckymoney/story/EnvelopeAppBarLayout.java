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
import com.tencent.mm.plugin.luckymoney.a.a.a;
import com.tencent.mm.plugin.luckymoney.ui.HorizontalLayoutManager;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI;
import com.tencent.mm.protocal.protobuf.ctb;
import com.tencent.mm.protocal.protobuf.ctd;
import com.tencent.mm.protocal.protobuf.dka;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.view.MediaBannerIndicator;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.RecyclerHorizontalViewPager.b;
import com.tencent.mm.view.RecyclerHorizontalViewPager.c;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.wallet_core.ui.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class EnvelopeAppBarLayout
  extends AppBarLayout
  implements LifecycleObserver
{
  private int apN;
  private int tRD;
  private View vDV;
  private ImageView vDW;
  private RecyclerHorizontalViewPager vDX;
  private RecyclerView vDY;
  private TouchCoordinatorLayout vDZ;
  private EnvelopeStoryBehavior vEA;
  private ArrayList<b> vEB;
  private EnvelopeStoryVideoManager vEC;
  private ctd vED;
  private String vEE;
  private String vEF;
  private String vEG;
  public int vEH;
  private boolean vEI;
  public boolean vEJ;
  private boolean vEK;
  private ValueAnimator vEL;
  private ObjectAnimator vEM;
  private ValueAnimator vEN;
  private AnimatorSet vEO;
  private AppBarLayout.b vEP;
  private final float vEQ;
  private final float vER;
  private final float vES;
  private boolean vET;
  private boolean vEU;
  private int vEV;
  private boolean vEW;
  private boolean vEX;
  private boolean vEY;
  private boolean vEZ;
  private ViewGroup vEa;
  private ViewGroup vEb;
  private MediaBannerIndicator vEc;
  private TextView vEd;
  private RoundCornerImageView vEe;
  private TextView vEf;
  private TextView vEg;
  private TextView vEh;
  private TextView vEi;
  private TextView vEj;
  private ViewGroup vEk;
  private View vEl;
  private ImageView vEm;
  private ImageView vEn;
  private ImageView vEo;
  private ViewGroup vEp;
  private ViewGroup vEq;
  private ProgressBar vEr;
  public LuckyMoneyDetailUI vEs;
  private int vEt;
  private int vEu;
  private int vEv;
  private int vEw;
  private int vEx;
  private int vEy;
  private int vEz;
  private boolean vFa;
  private boolean vFb;
  private View.OnClickListener vFc;
  private int vFd;
  
  public EnvelopeAppBarLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(163595);
    this.vEw = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 130);
    this.vEx = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 120);
    this.vEy = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 420);
    this.vEz = (this.vEy - this.vEx);
    this.apN = 0;
    this.vEB = new ArrayList();
    this.vEI = true;
    this.vEJ = false;
    this.vEK = false;
    this.vEQ = 1.335F;
    this.vER = 1.0F;
    this.vES = 0.6F;
    this.vET = false;
    this.vEU = false;
    this.vEW = false;
    this.vEX = false;
    this.vEY = false;
    this.vEZ = false;
    this.vFa = false;
    this.vFb = false;
    this.vFc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163578);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((!EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this)) && (EnvelopeAppBarLayout.this.vEH == 2))
        {
          EnvelopeAppBarLayout.this.b(true, true, true);
          EnvelopeAppBarLayout.b(EnvelopeAppBarLayout.this);
          com.tencent.mm.plugin.luckymoney.a.d.tW(5);
          com.tencent.mm.plugin.luckymoney.a.c.bq(6, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(163578);
      }
    };
    this.vFd = ak.getResources().getDimensionPixelSize(2131166499);
    init();
    AppMethodBeat.o(163595);
  }
  
  public EnvelopeAppBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163596);
    this.vEw = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 130);
    this.vEx = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 120);
    this.vEy = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 420);
    this.vEz = (this.vEy - this.vEx);
    this.apN = 0;
    this.vEB = new ArrayList();
    this.vEI = true;
    this.vEJ = false;
    this.vEK = false;
    this.vEQ = 1.335F;
    this.vER = 1.0F;
    this.vES = 0.6F;
    this.vET = false;
    this.vEU = false;
    this.vEW = false;
    this.vEX = false;
    this.vEY = false;
    this.vEZ = false;
    this.vFa = false;
    this.vFb = false;
    this.vFc = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163578);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((!EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this)) && (EnvelopeAppBarLayout.this.vEH == 2))
        {
          EnvelopeAppBarLayout.this.b(true, true, true);
          EnvelopeAppBarLayout.b(EnvelopeAppBarLayout.this);
          com.tencent.mm.plugin.luckymoney.a.d.tW(5);
          com.tencent.mm.plugin.luckymoney.a.c.bq(6, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(163578);
      }
    };
    this.vFd = ak.getResources().getDimensionPixelSize(2131166499);
    init();
    AppMethodBeat.o(163596);
  }
  
  private void dlL()
  {
    AppMethodBeat.i(163599);
    this.vEa.setOnClickListener(this.vFc);
    this.vDW.setOnClickListener(this.vFc);
    AppMethodBeat.o(163599);
  }
  
  private void dlM()
  {
    AppMethodBeat.i(163600);
    Object localObject = new Rect();
    getWindowVisibleDisplayFrame((Rect)localObject);
    this.vEt = (((Rect)localObject).right - ((Rect)localObject).left);
    this.vEu = ((int)(this.vEt * 1.335F));
    this.vDW.setMinimumHeight(this.vEu);
    localObject = new AppBarLayout.LayoutParams(this.vEu);
    ((AppBarLayout.LayoutParams)localObject).ns = 3;
    this.vDV.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.vDV.setMinimumHeight(this.vEx);
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
  
  private boolean dlN()
  {
    AppMethodBeat.i(163601);
    com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)this.vDX.ci(this.apN);
    if (locale == null)
    {
      AppMethodBeat.o(163601);
      return false;
    }
    if (((b)locale.LSj).vFq.HRK == 2)
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
        EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, (EnvelopeStoryBehavior)((CoordinatorLayout.d)localObject).qA);
        EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this).vEJ = EnvelopeAppBarLayout.this.vEJ;
        localObject = EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this);
        if (EnvelopeAppBarLayout.this.vEH == 1) {}
        for (boolean bool = true;; bool = false)
        {
          ((EnvelopeStoryBehavior)localObject).vFz = bool;
          EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this).vFA = EnvelopeAppBarLayout.e(EnvelopeAppBarLayout.this);
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, (TouchCoordinatorLayout)EnvelopeAppBarLayout.this.getParent());
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).findViewById(2131301755));
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, (RecyclerView)EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).findViewById(2131301770));
          EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).a(new View.OnTouchListener()
          {
            float aTL;
            float aTM;
            long vFf;
            boolean vFg = false;
            
            public final boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
            {
              AppMethodBeat.i(163583);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              localb.bd(paramAnonymous2MotionEvent);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$2$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
              if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
              {
                if (paramAnonymous2MotionEvent.getActionMasked() != 0) {
                  break label159;
                }
                paramAnonymous2View = new Rect();
                EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this).getGlobalVisibleRect(paramAnonymous2View);
                if (!paramAnonymous2View.contains((int)paramAnonymous2MotionEvent.getRawX(), (int)paramAnonymous2MotionEvent.getRawY())) {
                  break label151;
                }
                this.aTL = paramAnonymous2MotionEvent.getRawX();
                this.aTM = paramAnonymous2MotionEvent.getRawY();
                this.vFf = bu.HQ();
                this.vFg = true;
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$2$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(163583);
                return false;
                label151:
                this.vFg = false;
                continue;
                label159:
                if ((paramAnonymous2MotionEvent.getActionMasked() == 1) && (this.vFg) && (bu.aO(this.vFf) < 500L))
                {
                  paramAnonymous2View = new Rect();
                  EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this).getGlobalVisibleRect(paramAnonymous2View);
                  int i = (int)paramAnonymous2MotionEvent.getRawX();
                  int j = (int)paramAnonymous2MotionEvent.getRawY();
                  if ((Math.abs(i - this.aTL) <= 20.0F) && (Math.abs(j - this.aTM) <= 20.0F) && (paramAnonymous2View.contains(i, j)))
                  {
                    ae.i("MicroMsg.EnvelopeAppBarLayout", "click collapse view");
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
          EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this).setOnTouchListener(new EnvelopeAppBarLayout.8.2(this));
          EnvelopeAppBarLayout.i(EnvelopeAppBarLayout.this);
          AppMethodBeat.o(163584);
          return;
        }
      }
    });
    this.vEC = new EnvelopeStoryVideoManager();
    initView();
    this.vEP = new AppBarLayout.b()
    {
      private int vFj = 0;
      
      public final void c(AppBarLayout paramAnonymousAppBarLayout, int paramAnonymousInt)
      {
        AppMethodBeat.i(163585);
        ae.d("MicroMsg.EnvelopeAppBarLayout", "offset: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
            if (EnvelopeAppBarLayout.this.vEH != 2) {
              break label259;
            }
            EnvelopeAppBarLayout.o(EnvelopeAppBarLayout.this).setAlpha(f2);
          }
          label146:
          if ((paramAnonymousAppBarLayout.getTotalScrollRange() - paramAnonymousInt != 0) || (this.vFj == paramAnonymousInt)) {
            break label346;
          }
          EnvelopeAppBarLayout.q(EnvelopeAppBarLayout.this);
        }
        for (;;)
        {
          if (EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this) != null) {
            EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this).setAlpha((float)(f1 * 0.7D));
          }
          this.vFj = paramAnonymousInt;
          AppMethodBeat.o(163585);
          return;
          int j = paramAnonymousAppBarLayout.getTotalScrollRange();
          int k = EnvelopeAppBarLayout.l(EnvelopeAppBarLayout.this);
          float f3 = (paramAnonymousInt - EnvelopeAppBarLayout.l(EnvelopeAppBarLayout.this)) / ((j - k) * 1.0F);
          EnvelopeAppBarLayout.m(EnvelopeAppBarLayout.this).setAlpha(f3);
          break;
          label259:
          if (EnvelopeAppBarLayout.this.vEH != 1) {
            break label146;
          }
          ae.d("MicroMsg.EnvelopeAppBarLayout", "distance: %s", new Object[] { Integer.valueOf(i) });
          if (i <= EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this))
          {
            f2 = i / (EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this) * 1.0F);
            EnvelopeAppBarLayout.o(EnvelopeAppBarLayout.this).setAlpha(f2);
            break label146;
          }
          EnvelopeAppBarLayout.o(EnvelopeAppBarLayout.this).setAlpha(1.0F);
          break label146;
          label346:
          if ((paramAnonymousInt == 0) && (this.vFj != paramAnonymousInt)) {
            EnvelopeAppBarLayout.r(EnvelopeAppBarLayout.this);
          }
        }
      }
    };
    a(this.vEP);
    AppMethodBeat.o(163597);
  }
  
  private void initView()
  {
    AppMethodBeat.i(163598);
    this.vDV = findViewById(2131305332);
    this.vEa = ((ViewGroup)findViewById(2131301776));
    this.vEb = ((ViewGroup)findViewById(2131301779));
    this.vDW = ((ImageView)findViewById(2131305413));
    this.vEr = ((ProgressBar)findViewById(2131305414));
    this.vDX = ((RecyclerHorizontalViewPager)findViewById(2131305482));
    this.vEc = ((MediaBannerIndicator)findViewById(2131305333));
    this.vEd = ((TextView)findViewById(2131305345));
    this.vEe = ((RoundCornerImageView)findViewById(2131305462));
    this.vEf = ((TextView)findViewById(2131305502));
    this.vEg = ((TextView)findViewById(2131307252));
    this.vEp = ((ViewGroup)findViewById(2131305490));
    this.vEh = ((TextView)findViewById(2131301777));
    this.vEi = ((TextView)findViewById(2131307211));
    this.vEk = ((ViewGroup)findViewById(2131307212));
    this.vEj = ((TextView)findViewById(2131305489));
    this.vEm = ((ImageView)findViewById(2131301775));
    this.vEn = ((ImageView)findViewById(2131305411));
    this.vEo = ((ImageView)findViewById(2131305412));
    this.vEe.shadowRadius = 4;
    this.vEe.shadowColor = getResources().getColor(2131099670);
    this.vEc.setSelectDrawable(getResources().getDrawable(2131233139));
    this.vEc.setUnSelectDrawable(getResources().getDrawable(2131233140));
    this.vEc.setIndicatorWidth(getResources().getDimensionPixelSize(2131165303));
    getContext();
    Object localObject = new HorizontalLayoutManager();
    this.vDX.setHasFixedSize(true);
    this.vDX.setItemViewCacheSize(4);
    final com.tencent.mm.plugin.luckymoney.scaledLayout.a locala = new com.tencent.mm.plugin.luckymoney.scaledLayout.a();
    locala.context = getContext();
    locala.vDc = true;
    this.vDX.setSnapHelper(locala);
    this.vDX.setOnInterceptTouchEvent(new RecyclerHorizontalViewPager.c()
    {
      public final boolean b(MotionEvent paramAnonymousMotionEvent, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(163589);
        if (paramAnonymousMotionEvent.getAction() == 0) {
          locala.vDb = com.tencent.mm.plugin.luckymoney.scaledLayout.a.h(this.vFm);
        }
        AppMethodBeat.o(163589);
        return paramAnonymousBoolean;
      }
      
      public final void k(MotionEvent paramAnonymousMotionEvent) {}
    });
    ((HorizontalLayoutManager)localObject).pyR = 1;
    ((HorizontalLayoutManager)localObject).aw(true);
    ((LinearLayoutManager)localObject).aqs = 3;
    ((HorizontalLayoutManager)localObject).setOrientation(0);
    this.vDX.setLayoutManager((RecyclerView.i)localObject);
    localObject = new WxRecyclerAdapter(new com.tencent.mm.view.recyclerview.c()
    {
      public final com.tencent.mm.view.recyclerview.b<?> AX(int paramAnonymousInt)
      {
        AppMethodBeat.i(163590);
        EnvelopeAppBarLayout.a locala = new EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this);
        AppMethodBeat.o(163590);
        return locala;
      }
    }, this.vEB, false);
    this.vDX.setAdapter((RecyclerView.a)localObject);
    this.vDX.setPageChangeListener(new RecyclerHorizontalViewPager.b()
    {
      public final void af(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(163591);
        ae.i("MicroMsg.EnvelopeAppBarLayout", "on page change: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        com.tencent.mm.view.recyclerview.e locale;
        EnvelopeAppBarLayout.b localb;
        if (paramAnonymousBoolean)
        {
          if (EnvelopeAppBarLayout.u(EnvelopeAppBarLayout.this) == paramAnonymousInt)
          {
            AppMethodBeat.o(163591);
            return;
          }
          EnvelopeAppBarLayout.this.dlK();
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, paramAnonymousInt);
          locale = (com.tencent.mm.view.recyclerview.e)EnvelopeAppBarLayout.v(EnvelopeAppBarLayout.this).ci(paramAnonymousInt);
          if (locale != null)
          {
            paramAnonymousBoolean = EnvelopeAppBarLayout.w(EnvelopeAppBarLayout.this);
            localb = (EnvelopeAppBarLayout.b)locale.LSj;
            if (!paramAnonymousBoolean) {
              break label206;
            }
            localb.dlO();
          }
        }
        for (;;)
        {
          EnvelopeAppBarLayout.x(EnvelopeAppBarLayout.this).a(EnvelopeAppBarLayout.this.getContext(), (FrameLayout)locale.GD(2131301783), (ImageView)locale.GD(2131301780), (ProgressBar)locale.GD(2131301781), localb.vFq.HRL, localb.videoWidth, localb.videoHeight, paramAnonymousInt, paramAnonymousBoolean);
          com.tencent.mm.plugin.luckymoney.a.d.tW(6);
          b.vGe += 1;
          EnvelopeAppBarLayout.y(EnvelopeAppBarLayout.this).setCurrentIndex(paramAnonymousInt);
          AppMethodBeat.o(163591);
          return;
          label206:
          b.vGh += 1;
        }
      }
    });
    AppMethodBeat.o(163598);
  }
  
  private void tP(int paramInt)
  {
    AppMethodBeat.i(163607);
    this.vEH = paramInt;
    switch (this.vEH)
    {
    default: 
      AppMethodBeat.o(163607);
      return;
    case 0: 
      this.vEI = true;
      this.vEJ = true;
      this.vEa.setVisibility(8);
      this.vEo.setVisibility(8);
      if (al.isDarkMode())
      {
        this.vEn.setImageResource(2131690387);
        AppMethodBeat.o(163607);
        return;
      }
      this.vEn.setImageResource(2131690386);
      AppMethodBeat.o(163607);
      return;
    case 1: 
      this.vEI = true;
      this.vEJ = true;
      this.vEa.setVisibility(0);
      this.vEm.setVisibility(8);
      this.vDW.setVisibility(0);
      this.vEo.setVisibility(8);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.bottomMargin = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 32);
      this.vEk.setLayoutParams(localLayoutParams);
      if (al.isDarkMode())
      {
        this.vEn.setImageResource(2131690387);
        AppMethodBeat.o(163607);
        return;
      }
      this.vEn.setImageResource(2131690386);
      AppMethodBeat.o(163607);
      return;
    }
    this.vEI = false;
    this.vEJ = false;
    this.vEa.setVisibility(0);
    this.vEm.setVisibility(0);
    this.vEo.setVisibility(0);
    this.vEo.setAlpha(0.0F);
    if (al.isDarkMode()) {
      this.vEn.setImageResource(2131690387);
    }
    for (;;)
    {
      com.tencent.mm.plugin.luckymoney.a.c.bq(4, this.vEF);
      break;
      this.vEn.setImageResource(2131690386);
    }
  }
  
  public final void a(ctd paramctd, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(189844);
    if (bu.isNullOrNil(this.vEF))
    {
      tP(0);
      this.vEu = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 502);
      paramctd = new AppBarLayout.LayoutParams(this.vEu);
      paramctd.ns = 3;
      this.vDV.setMinimumHeight(this.vEx);
      this.vDV.setLayoutParams(paramctd);
    }
    for (;;)
    {
      ae.i("MicroMsg.EnvelopeAppBarLayout", "set envelope story: %s", new Object[] { Integer.valueOf(this.vEH) });
      AppMethodBeat.o(189844);
      return;
      if (paramctd != null) {
        break;
      }
      tP(1);
      dlM();
      this.vEh.setText(paramString2);
      a.vGc = paramString2;
    }
    this.vED = paramctd;
    this.vEE = paramString1;
    this.vFb = paramBoolean;
    this.vEd.setText(this.vED.description);
    this.vEf.setText(this.vED.HEf);
    this.vEh.setText(this.vED.title);
    a.vGc = this.vED.HEf;
    if (paramctd.HEk != null) {
      paramInt = paramctd.HEk.hCs;
    }
    if (paramInt == 2)
    {
      this.vEi.setVisibility(0);
      this.vEg.setVisibility(0);
      if (this.vED.oGc != 1) {
        break label453;
      }
      if (!this.vEX)
      {
        com.tencent.mm.plugin.luckymoney.a.c.bq(8, this.vEF);
        this.vEX = true;
      }
      this.vEp.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(174332);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          ae.d("MicroMsg.EnvelopeAppBarLayout", "go to h5");
          if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
          {
            f.aY(EnvelopeAppBarLayout.this.getContext(), EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).HEh);
            com.tencent.mm.plugin.luckymoney.a.d.tW(7);
            com.tencent.mm.plugin.luckymoney.a.c.bq(9, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
            b.vGn += 1;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(174332);
        }
      });
      this.vEj.setText(2131755801);
      label291:
      if (bu.isNullOrNil(paramctd.hCp)) {
        break label615;
      }
      ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.vEe, paramctd.hCp, paramctd.hCq, paramString1);
      this.vEe.setVisibility(0);
      label336:
      this.vEB.clear();
      if (paramctd.HEg.isEmpty()) {
        break label1339;
      }
      b.vGl = 1;
      a.vGd = 2;
      paramctd = paramctd.HEg.iterator();
    }
    for (;;)
    {
      if (!paramctd.hasNext()) {
        break label640;
      }
      paramString1 = (dka)paramctd.next();
      paramString2 = new b();
      paramString2.vFq = paramString1;
      this.vEB.add(paramString2);
      if (paramString1.HRK == 2)
      {
        this.tRD += 1;
        continue;
        this.vEi.setVisibility(8);
        this.vEg.setVisibility(8);
        break;
        label453:
        if (this.vED.oGc == 2)
        {
          if (bu.isNullOrNil(this.vED.HEi)) {
            break label291;
          }
          if (!this.vEY)
          {
            com.tencent.mm.plugin.luckymoney.a.c.bq(11, this.vEF);
            this.vEY = true;
          }
          f.aW(this.vEp, 100);
          b.vGm = 1;
          this.vEp.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(189838);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              ae.d("MicroMsg.EnvelopeAppBarLayout", "go to profile");
              if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
              {
                f.cs(EnvelopeAppBarLayout.this.getContext(), EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).HEi);
                com.tencent.mm.plugin.luckymoney.a.d.tW(7);
                com.tencent.mm.plugin.luckymoney.a.c.bq(13, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
                b.vGn += 1;
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(189838);
            }
          });
          this.vEj.setText(2131760853);
          break label291;
        }
        if (this.vED.oGc == 3)
        {
          if (!this.vEZ)
          {
            com.tencent.mm.plugin.luckymoney.a.c.bq(12, this.vEF);
            this.vEZ = true;
          }
          this.vEp.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(189839);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              ae.d("MicroMsg.EnvelopeAppBarLayout", "go to mini app");
              if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
              {
                f.u(EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).HEi, EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).HEh, 0, 1100);
                com.tencent.mm.plugin.luckymoney.a.d.tW(7);
                com.tencent.mm.plugin.luckymoney.a.c.bq(14, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
                b.vGn += 1;
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(189839);
            }
          });
          this.vEj.setText(2131760854);
          break label291;
        }
        this.vEp.setVisibility(8);
        b.vGm = 0;
        break label291;
        label615:
        this.vEe.setVisibility(8);
        break label336;
      }
      this.vEV += 1;
    }
    label640:
    this.vEc.setCount(this.vEB.size());
    tP(2);
    paramctd = new Rect();
    getWindowVisibleDisplayFrame(paramctd);
    this.vEt = (paramctd.right - paramctd.left);
    this.vEu = ((int)(this.vEt * 1.667F));
    paramInt = (int)(this.vEt * 1.335F);
    this.vEv = (this.vEu - paramInt);
    this.vDW.setMinimumHeight(paramInt);
    paramctd = new AppBarLayout.LayoutParams(this.vEu);
    paramctd.ns = 3;
    this.vDV.setLayoutParams(paramctd);
    this.vEy = ((int)(this.vEt * 1.0F));
    this.vDV.setMinimumHeight(this.vEy);
    setExpanded(false);
    if (this.vFb)
    {
      paramInt = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IXk, Integer.valueOf(0))).intValue();
      label814:
      ae.i("MicroMsg.EnvelopeAppBarLayout", "show first guide: %s", new Object[] { Integer.valueOf(paramInt) });
      if ((paramInt >= 3) || (this.vEH != 2)) {
        break label1287;
      }
      paramInt = 1;
      label852:
      if (paramInt != 0)
      {
        this.vFa = true;
        this.vEq = ((ViewGroup)findViewById(2131301778));
        this.vEq.setVisibility(0);
        this.vEa.setVisibility(4);
        this.vEL = new ValueAnimator();
        this.vEL.setDuration(700L);
        this.vEL.setInterpolator(new AccelerateDecelerateInterpolator());
        this.vEL.setIntValues(new int[] { 0, this.vEw });
        this.vEM = new ObjectAnimator();
        this.vEM.setPropertyName("alpha");
        this.vEM.setFloatValues(new float[] { 1.0F, 0.0F });
        this.vEM.setTarget(this.vEq);
        this.vEM.setDuration(300L);
        this.vEM.setStartDelay(200L);
        this.vEM.addListener(new Animator.AnimatorListener()
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
        this.vEN = new ValueAnimator();
        this.vEN.setInterpolator(android.support.design.a.a.gM);
        this.vEN.setStartDelay(200L);
        this.vEN.setDuration(300L);
        this.vEN.setIntValues(new int[] { this.vEw, 0 });
        paramctd = new ValueAnimator.AnimatorUpdateListener()
        {
          int vFk = 0;
          
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(163587);
            ae.d("MicroMsg.EnvelopeAppBarLayout", "animate value: " + paramAnonymousValueAnimator.getAnimatedValue());
            int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
            int j = i - this.vFk;
            this.vFk = i;
            float f = (EnvelopeAppBarLayout.s(EnvelopeAppBarLayout.this) - i) / (EnvelopeAppBarLayout.s(EnvelopeAppBarLayout.this) * 1.0F);
            if (EnvelopeAppBarLayout.this.vEH == 2) {
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
        this.vEL.addUpdateListener(paramctd);
        this.vEN.addUpdateListener(paramctd);
        this.vEO = new AnimatorSet();
        this.vEO.playSequentially(new Animator[] { this.vEL, this.vEM, this.vEN });
        this.vEO.addListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(163588);
            EnvelopeAppBarLayout.t(EnvelopeAppBarLayout.this).setVisibility(8);
            if (EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this) != null) {
              EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).vGp = false;
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
            AppMethodBeat.i(189840);
            if (EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this) != null) {
              EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).vGp = true;
            }
            EnvelopeAppBarLayout.A(EnvelopeAppBarLayout.this).setStartDelay(700L);
            EnvelopeAppBarLayout.A(EnvelopeAppBarLayout.this).start();
            AppMethodBeat.o(189840);
          }
        });
        if (!this.vFb) {
          break label1293;
        }
        paramInt = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IXk, Integer.valueOf(0))).intValue();
        com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXk, Integer.valueOf(paramInt + 1));
      }
    }
    for (;;)
    {
      this.vDX.getAdapter().asY.notifyChanged();
      break;
      paramInt = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IXj, Integer.valueOf(0))).intValue();
      break label814;
      label1287:
      paramInt = 0;
      break label852;
      label1293:
      paramInt = ((Integer)com.tencent.mm.kernel.g.ajR().ajA().get(am.a.IXj, Integer.valueOf(0))).intValue();
      com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IXj, Integer.valueOf(paramInt + 1));
      continue;
      label1339:
      tP(1);
      dlM();
    }
  }
  
  public final void dlK()
  {
    AppMethodBeat.i(182455);
    Object localObject1;
    Object localObject2;
    int i;
    if (this.apN >= 0)
    {
      if (bu.isNullOrNil(b.sessionId))
      {
        AppMethodBeat.o(182455);
        return;
      }
      localObject1 = (com.tencent.mm.view.recyclerview.e)this.vDX.ci(this.apN);
      if (localObject1 != null)
      {
        boolean bool = dlN();
        localObject1 = (b)((com.tencent.mm.view.recyclerview.e)localObject1).LSj;
        if (bool)
        {
          localObject2 = this.vEC;
          i = this.apN;
          localObject2 = (EnvelopeStoryVideoManager.c)((EnvelopeStoryVideoManager)localObject2).vFE.get(Integer.valueOf(i));
          if (localObject2 == null)
          {
            AppMethodBeat.o(182455);
            return;
          }
          ((EnvelopeStoryVideoManager.c)localObject2).vFT = ((EnvelopeStoryVideoManager.c)localObject2).vFV.getCurrPosSec();
          if (((EnvelopeStoryVideoManager.c)localObject2).vFU.get() == 1) {
            i = (int)(((EnvelopeStoryVideoManager.c)localObject2).vFT - ((EnvelopeStoryVideoManager.c)localObject2).vFS);
          }
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yxI.f(19270, new Object[] { Integer.valueOf(2), this.vEE, ((EnvelopeStoryVideoManager.c)localObject2).vFU, "", ((b)localObject1).vFq.HRL, Integer.valueOf(i), b.sessionId });
      AppMethodBeat.o(182455);
      return;
      if (((EnvelopeStoryVideoManager.c)localObject2).vFU.get() > 1)
      {
        i = ((EnvelopeStoryVideoManager.c)localObject2).vFU.get();
        i = (int)(((EnvelopeStoryVideoManager.c)localObject2).vFP - ((EnvelopeStoryVideoManager.c)localObject2).vFS + ((EnvelopeStoryVideoManager.c)localObject2).vFT + (i - 1) * ((EnvelopeStoryVideoManager.c)localObject2).vFP);
        continue;
        com.tencent.mm.plugin.report.service.g.yxI.f(19270, new Object[] { Integer.valueOf(1), this.vEE, Integer.valueOf(0), ((b)localObject1).vFq.HRL, "", Integer.valueOf(0), b.sessionId });
        AppMethodBeat.o(182455);
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public final void hS(String paramString1, String paramString2)
  {
    AppMethodBeat.i(163608);
    if ((bu.isNullOrNil(this.vEF)) && (!bu.isNullOrNil(paramString1)))
    {
      this.vEF = paramString1;
      this.vEG = paramString2;
      this.vEr.setVisibility(0);
      ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.vDW, this.vEF, this.vEG, this.vEE, this.vEu, this.vEt, 0, new a.a()
      {
        public final void iI(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(189841);
          EnvelopeAppBarLayout.B(EnvelopeAppBarLayout.this).setVisibility(8);
          AppMethodBeat.o(189841);
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
    dlK();
    this.vEC.dlU();
    if ((this.vEH == 1) || (this.vEH == 2)) {
      b.tW(3);
    }
    com.tencent.mm.plugin.luckymoney.a.d.tW(11);
    AppMethodBeat.o(163604);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void onUIPause() {}
  
  public void setActivityLifeCycle(LuckyMoneyDetailUI paramLuckyMoneyDetailUI)
  {
    AppMethodBeat.i(189843);
    paramLuckyMoneyDetailUI.getLifecycle().addObserver(this.vEC);
    paramLuckyMoneyDetailUI.getLifecycle().addObserver(this);
    this.vEs = paramLuckyMoneyDetailUI;
    EnvelopeStoryVideoManager localEnvelopeStoryVideoManager = this.vEC;
    localEnvelopeStoryVideoManager.oDx = paramLuckyMoneyDetailUI;
    ar.f(new EnvelopeStoryVideoManager.1(localEnvelopeStoryVideoManager));
    AppMethodBeat.o(189843);
  }
  
  final class a
    extends com.tencent.mm.view.recyclerview.b<EnvelopeAppBarLayout.b>
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
    public dka vFq;
    public int videoHeight = -1;
    public int videoWidth = -1;
    
    b() {}
    
    public final int bZz()
    {
      return 0;
    }
    
    public final void dlO()
    {
      AppMethodBeat.i(163594);
      if ((this.videoHeight > 0) && (this.videoWidth > 0))
      {
        AppMethodBeat.o(163594);
        return;
      }
      float f = this.vFq.height / (this.vFq.width * 1.0F);
      if (f > 1.667F)
      {
        this.videoHeight = EnvelopeAppBarLayout.D(EnvelopeAppBarLayout.this);
        this.videoWidth = ((int)(EnvelopeAppBarLayout.D(EnvelopeAppBarLayout.this) / f));
      }
      for (;;)
      {
        ae.d("MicroMsg.EnvelopeAppBarLayout", "video size: %s, %s", new Object[] { Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight) });
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
    
    public final long lP()
    {
      return 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout
 * JD-Core Version:    0.7.0.1
 */