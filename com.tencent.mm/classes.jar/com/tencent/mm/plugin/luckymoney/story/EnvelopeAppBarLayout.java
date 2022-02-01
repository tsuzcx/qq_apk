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
import com.tencent.mm.plugin.luckymoney.a.a.a;
import com.tencent.mm.plugin.luckymoney.a.c;
import com.tencent.mm.plugin.luckymoney.a.d;
import com.tencent.mm.plugin.luckymoney.ui.HorizontalLayoutManager;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.protocal.protobuf.csj;
import com.tencent.mm.protocal.protobuf.djf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.view.MediaBannerIndicator;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.RecyclerHorizontalViewPager.b;
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
  private int apN;
  private int tGM;
  private View vrQ;
  private ImageView vrR;
  private RecyclerHorizontalViewPager vrS;
  private RecyclerView vrT;
  private TouchCoordinatorLayout vrU;
  private ViewGroup vrV;
  private ViewGroup vrW;
  private MediaBannerIndicator vrX;
  private TextView vrY;
  private RoundCornerImageView vrZ;
  private String vsA;
  private String vsB;
  public int vsC;
  private boolean vsD;
  public boolean vsE;
  private boolean vsF;
  private ValueAnimator vsG;
  private ObjectAnimator vsH;
  private ValueAnimator vsI;
  private AnimatorSet vsJ;
  private AppBarLayout.b vsK;
  private final float vsL;
  private final float vsM;
  private final float vsN;
  private boolean vsO;
  private boolean vsP;
  private int vsQ;
  private boolean vsR;
  private boolean vsS;
  private boolean vsT;
  private boolean vsU;
  private boolean vsV;
  private boolean vsW;
  private View.OnClickListener vsX;
  private int vsY;
  private TextView vsa;
  private TextView vsb;
  private TextView vsc;
  private TextView vsd;
  private TextView vse;
  private ViewGroup vsf;
  private View vsg;
  private ImageView vsh;
  private ImageView vsi;
  private ImageView vsj;
  private ViewGroup vsk;
  private ViewGroup vsl;
  private ProgressBar vsm;
  public LuckyMoneyDetailUI vsn;
  private int vso;
  private int vsp;
  private int vsq;
  private int vsr;
  private int vss;
  private int vst;
  private int vsu;
  private EnvelopeStoryBehavior vsv;
  private ArrayList<EnvelopeAppBarLayout.b> vsw;
  private EnvelopeStoryVideoManager vsx;
  private csj vsy;
  private String vsz;
  
  public EnvelopeAppBarLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(163595);
    this.vsr = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 130);
    this.vss = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 120);
    this.vst = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 420);
    this.vsu = (this.vst - this.vss);
    this.apN = 0;
    this.vsw = new ArrayList();
    this.vsD = true;
    this.vsE = false;
    this.vsF = false;
    this.vsL = 1.335F;
    this.vsM = 1.0F;
    this.vsN = 0.6F;
    this.vsO = false;
    this.vsP = false;
    this.vsR = false;
    this.vsS = false;
    this.vsT = false;
    this.vsU = false;
    this.vsV = false;
    this.vsW = false;
    this.vsX = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163578);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((!EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this)) && (EnvelopeAppBarLayout.this.vsC == 2))
        {
          EnvelopeAppBarLayout.this.b(true, true, true);
          EnvelopeAppBarLayout.b(EnvelopeAppBarLayout.this);
          d.tQ(5);
          c.br(6, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(163578);
      }
    };
    this.vsY = aj.getResources().getDimensionPixelSize(2131166499);
    init();
    AppMethodBeat.o(163595);
  }
  
  public EnvelopeAppBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163596);
    this.vsr = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 130);
    this.vss = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 120);
    this.vst = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 420);
    this.vsu = (this.vst - this.vss);
    this.apN = 0;
    this.vsw = new ArrayList();
    this.vsD = true;
    this.vsE = false;
    this.vsF = false;
    this.vsL = 1.335F;
    this.vsM = 1.0F;
    this.vsN = 0.6F;
    this.vsO = false;
    this.vsP = false;
    this.vsR = false;
    this.vsS = false;
    this.vsT = false;
    this.vsU = false;
    this.vsV = false;
    this.vsW = false;
    this.vsX = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163578);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((!EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this)) && (EnvelopeAppBarLayout.this.vsC == 2))
        {
          EnvelopeAppBarLayout.this.b(true, true, true);
          EnvelopeAppBarLayout.b(EnvelopeAppBarLayout.this);
          d.tQ(5);
          c.br(6, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(163578);
      }
    };
    this.vsY = aj.getResources().getDimensionPixelSize(2131166499);
    init();
    AppMethodBeat.o(163596);
  }
  
  private void diM()
  {
    AppMethodBeat.i(163599);
    this.vrV.setOnClickListener(this.vsX);
    this.vrR.setOnClickListener(this.vsX);
    AppMethodBeat.o(163599);
  }
  
  private void diN()
  {
    AppMethodBeat.i(163600);
    Object localObject = new Rect();
    getWindowVisibleDisplayFrame((Rect)localObject);
    this.vso = (((Rect)localObject).right - ((Rect)localObject).left);
    this.vsp = ((int)(this.vso * 1.335F));
    this.vrR.setMinimumHeight(this.vsp);
    localObject = new AppBarLayout.LayoutParams(this.vsp);
    ((AppBarLayout.LayoutParams)localObject).ns = 3;
    this.vrQ.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.vrQ.setMinimumHeight(this.vss);
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
  
  private boolean diO()
  {
    AppMethodBeat.i(163601);
    com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)this.vrS.ci(this.apN);
    if (locale == null)
    {
      AppMethodBeat.o(163601);
      return false;
    }
    if (((EnvelopeAppBarLayout.b)locale.Lvw).vtl.HxZ == 2)
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
        EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this).vsE = EnvelopeAppBarLayout.this.vsE;
        localObject = EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this);
        if (EnvelopeAppBarLayout.this.vsC == 1) {}
        for (boolean bool = true;; bool = false)
        {
          ((EnvelopeStoryBehavior)localObject).vtu = bool;
          EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this).vtv = EnvelopeAppBarLayout.e(EnvelopeAppBarLayout.this);
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, (TouchCoordinatorLayout)EnvelopeAppBarLayout.this.getParent());
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).findViewById(2131301755));
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, (RecyclerView)EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).findViewById(2131301770));
          EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).a(new View.OnTouchListener()
          {
            float aTL;
            float aTM;
            long vta;
            boolean vtb = false;
            
            public final boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
            {
              AppMethodBeat.i(163583);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymous2View);
              localb.bd(paramAnonymous2MotionEvent);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$2$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
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
                this.vta = bt.HI();
                this.vtb = true;
              }
              for (;;)
              {
                com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$2$1", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
                AppMethodBeat.o(163583);
                return false;
                label151:
                this.vtb = false;
                continue;
                label159:
                if ((paramAnonymous2MotionEvent.getActionMasked() == 1) && (this.vtb) && (bt.aO(this.vta) < 500L))
                {
                  paramAnonymous2View = new Rect();
                  EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this).getGlobalVisibleRect(paramAnonymous2View);
                  int i = (int)paramAnonymous2MotionEvent.getRawX();
                  int j = (int)paramAnonymous2MotionEvent.getRawY();
                  if ((Math.abs(i - this.aTL) <= 20.0F) && (Math.abs(j - this.aTM) <= 20.0F) && (paramAnonymous2View.contains(i, j)))
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
          EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this).setOnTouchListener(new EnvelopeAppBarLayout.7.2(this));
          EnvelopeAppBarLayout.i(EnvelopeAppBarLayout.this);
          AppMethodBeat.o(163584);
          return;
        }
      }
    });
    this.vsx = new EnvelopeStoryVideoManager();
    initView();
    this.vsK = new AppBarLayout.b()
    {
      private int vte = 0;
      
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
            if (EnvelopeAppBarLayout.this.vsC != 2) {
              break label259;
            }
            EnvelopeAppBarLayout.o(EnvelopeAppBarLayout.this).setAlpha(f2);
          }
          label146:
          if ((paramAnonymousAppBarLayout.getTotalScrollRange() - paramAnonymousInt != 0) || (this.vte == paramAnonymousInt)) {
            break label346;
          }
          EnvelopeAppBarLayout.q(EnvelopeAppBarLayout.this);
        }
        for (;;)
        {
          if (EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this) != null) {
            EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this).setAlpha((float)(f1 * 0.7D));
          }
          this.vte = paramAnonymousInt;
          AppMethodBeat.o(163585);
          return;
          int j = paramAnonymousAppBarLayout.getTotalScrollRange();
          int k = EnvelopeAppBarLayout.l(EnvelopeAppBarLayout.this);
          float f3 = (paramAnonymousInt - EnvelopeAppBarLayout.l(EnvelopeAppBarLayout.this)) / ((j - k) * 1.0F);
          EnvelopeAppBarLayout.m(EnvelopeAppBarLayout.this).setAlpha(f3);
          break;
          label259:
          if (EnvelopeAppBarLayout.this.vsC != 1) {
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
          if ((paramAnonymousInt == 0) && (this.vte != paramAnonymousInt)) {
            EnvelopeAppBarLayout.r(EnvelopeAppBarLayout.this);
          }
        }
      }
    };
    a(this.vsK);
    AppMethodBeat.o(163597);
  }
  
  private void initView()
  {
    AppMethodBeat.i(163598);
    this.vrQ = findViewById(2131305332);
    this.vrV = ((ViewGroup)findViewById(2131301776));
    this.vrW = ((ViewGroup)findViewById(2131301779));
    this.vrR = ((ImageView)findViewById(2131305413));
    this.vsm = ((ProgressBar)findViewById(2131305414));
    this.vrS = ((RecyclerHorizontalViewPager)findViewById(2131305482));
    this.vrX = ((MediaBannerIndicator)findViewById(2131305333));
    this.vrY = ((TextView)findViewById(2131305345));
    this.vrZ = ((RoundCornerImageView)findViewById(2131305462));
    this.vsa = ((TextView)findViewById(2131305502));
    this.vsb = ((TextView)findViewById(2131307252));
    this.vsk = ((ViewGroup)findViewById(2131305490));
    this.vsc = ((TextView)findViewById(2131301777));
    this.vsd = ((TextView)findViewById(2131307211));
    this.vsf = ((ViewGroup)findViewById(2131307212));
    this.vse = ((TextView)findViewById(2131305489));
    this.vsh = ((ImageView)findViewById(2131301775));
    this.vsi = ((ImageView)findViewById(2131305411));
    this.vsj = ((ImageView)findViewById(2131305412));
    this.vrZ.shadowRadius = 4;
    this.vrZ.shadowColor = getResources().getColor(2131099670);
    this.vrX.setSelectDrawable(getResources().getDrawable(2131233139));
    this.vrX.setUnSelectDrawable(getResources().getDrawable(2131233140));
    this.vrX.setIndicatorWidth(getResources().getDimensionPixelSize(2131165303));
    getContext();
    Object localObject = new HorizontalLayoutManager();
    this.vrS.setHasFixedSize(true);
    this.vrS.setItemViewCacheSize(4);
    com.tencent.mm.plugin.luckymoney.scaledLayout.a locala = new com.tencent.mm.plugin.luckymoney.scaledLayout.a();
    locala.context = getContext();
    locala.vqX = true;
    this.vrS.setSnapHelper(locala);
    this.vrS.setOnInterceptTouchEvent(new EnvelopeAppBarLayout.12(this, locala, (HorizontalLayoutManager)localObject));
    ((HorizontalLayoutManager)localObject).psl = 1;
    ((HorizontalLayoutManager)localObject).aw(true);
    ((LinearLayoutManager)localObject).aqs = 3;
    ((HorizontalLayoutManager)localObject).setOrientation(0);
    this.vrS.setLayoutManager((RecyclerView.i)localObject);
    localObject = new WxRecyclerAdapter(new EnvelopeAppBarLayout.13(this), this.vsw, false);
    this.vrS.setAdapter((RecyclerView.a)localObject);
    this.vrS.setPageChangeListener(new RecyclerHorizontalViewPager.b()
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
          EnvelopeAppBarLayout.this.diL();
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, paramAnonymousInt);
          locale = (com.tencent.mm.view.recyclerview.e)EnvelopeAppBarLayout.v(EnvelopeAppBarLayout.this).ci(paramAnonymousInt);
          if (locale != null)
          {
            paramAnonymousBoolean = EnvelopeAppBarLayout.w(EnvelopeAppBarLayout.this);
            localb = (EnvelopeAppBarLayout.b)locale.Lvw;
            if (!paramAnonymousBoolean) {
              break label206;
            }
            localb.diP();
          }
        }
        for (;;)
        {
          EnvelopeAppBarLayout.x(EnvelopeAppBarLayout.this).a(EnvelopeAppBarLayout.this.getContext(), (FrameLayout)locale.Gd(2131301783), (ImageView)locale.Gd(2131301780), (ProgressBar)locale.Gd(2131301781), localb.vtl.Hya, localb.videoWidth, localb.videoHeight, paramAnonymousInt, paramAnonymousBoolean);
          d.tQ(6);
          b.vua += 1;
          EnvelopeAppBarLayout.y(EnvelopeAppBarLayout.this).setCurrentIndex(paramAnonymousInt);
          AppMethodBeat.o(163591);
          return;
          label206:
          b.vud += 1;
        }
      }
    });
    AppMethodBeat.o(163598);
  }
  
  private void tK(int paramInt)
  {
    AppMethodBeat.i(163607);
    this.vsC = paramInt;
    switch (this.vsC)
    {
    default: 
      AppMethodBeat.o(163607);
      return;
    case 0: 
      this.vsD = true;
      this.vsE = true;
      this.vrV.setVisibility(8);
      this.vsj.setVisibility(8);
      if (al.isDarkMode())
      {
        this.vsi.setImageResource(2131690387);
        AppMethodBeat.o(163607);
        return;
      }
      this.vsi.setImageResource(2131690386);
      AppMethodBeat.o(163607);
      return;
    case 1: 
      this.vsD = true;
      this.vsE = true;
      this.vrV.setVisibility(0);
      this.vsh.setVisibility(8);
      this.vrR.setVisibility(0);
      this.vsj.setVisibility(8);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.bottomMargin = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 32);
      this.vsf.setLayoutParams(localLayoutParams);
      if (al.isDarkMode())
      {
        this.vsi.setImageResource(2131690387);
        AppMethodBeat.o(163607);
        return;
      }
      this.vsi.setImageResource(2131690386);
      AppMethodBeat.o(163607);
      return;
    }
    this.vsD = false;
    this.vsE = false;
    this.vrV.setVisibility(0);
    this.vsh.setVisibility(0);
    this.vsj.setVisibility(0);
    this.vsj.setAlpha(0.0F);
    if (al.isDarkMode()) {
      this.vsi.setImageResource(2131690387);
    }
    for (;;)
    {
      c.br(4, this.vsA);
      break;
      this.vsi.setImageResource(2131690386);
    }
  }
  
  public final void a(csj paramcsj, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(199009);
    if (bt.isNullOrNil(this.vsA))
    {
      tK(0);
      this.vsp = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 502);
      paramcsj = new AppBarLayout.LayoutParams(this.vsp);
      paramcsj.ns = 3;
      this.vrQ.setMinimumHeight(this.vss);
      this.vrQ.setLayoutParams(paramcsj);
    }
    for (;;)
    {
      ad.i("MicroMsg.EnvelopeAppBarLayout", "set envelope story: %s", new Object[] { Integer.valueOf(this.vsC) });
      AppMethodBeat.o(199009);
      return;
      if (paramcsj != null) {
        break;
      }
      tK(1);
      diN();
      this.vsc.setText(paramString2);
      a.vtY = paramString2;
    }
    this.vsy = paramcsj;
    this.vsz = paramString1;
    this.vsW = paramBoolean;
    this.vrY.setText(this.vsy.description);
    this.vsa.setText(this.vsy.HkF);
    this.vsc.setText(this.vsy.title);
    a.vtY = this.vsy.HkF;
    if (paramcsj.HkK != null) {
      paramInt = paramcsj.HkK.hzE;
    }
    if (paramInt == 2)
    {
      this.vsd.setVisibility(0);
      this.vsb.setVisibility(0);
      if (this.vsy.ozA != 2) {
        break label479;
      }
      if (!bt.isNullOrNil(this.vsy.HkI))
      {
        if (!this.vsT)
        {
          c.br(11, this.vsA);
          this.vsT = true;
        }
        com.tencent.mm.wallet_core.ui.e.aW(this.vsk, 100);
        b.vui = 1;
        this.vsk.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(174332);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
            ad.d("MicroMsg.EnvelopeAppBarLayout", "go to profile");
            if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
            {
              com.tencent.mm.wallet_core.ui.e.cr(EnvelopeAppBarLayout.this.getContext(), EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).HkI);
              d.tQ(7);
              c.br(13, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
              b.vuj += 1;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$11", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(174332);
          }
        });
        this.vse.setText(2131760853);
      }
      label317:
      if (bt.isNullOrNil(paramcsj.hzB)) {
        break label555;
      }
      ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.vrZ, paramcsj.hzB, paramcsj.hzC, paramString1);
      this.vrZ.setVisibility(0);
      label362:
      this.vsw.clear();
      if (paramcsj.HkG.isEmpty()) {
        break label1279;
      }
      b.vuh = 1;
      a.vtZ = 2;
      paramcsj = paramcsj.HkG.iterator();
    }
    for (;;)
    {
      if (!paramcsj.hasNext()) {
        break label580;
      }
      paramString1 = (djf)paramcsj.next();
      paramString2 = new EnvelopeAppBarLayout.b(this);
      paramString2.vtl = paramString1;
      this.vsw.add(paramString2);
      if (paramString1.HxZ == 2)
      {
        this.tGM += 1;
        continue;
        this.vsd.setVisibility(8);
        this.vsb.setVisibility(8);
        break;
        label479:
        if (this.vsy.ozA == 3)
        {
          if (!this.vsU)
          {
            c.br(12, this.vsA);
            this.vsU = true;
          }
          this.vsk.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(199004);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
              ad.d("MicroMsg.EnvelopeAppBarLayout", "go to mini app");
              if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
              {
                com.tencent.mm.wallet_core.ui.e.v(EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).HkI, EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).HkH, 0, 1100);
                d.tQ(7);
                c.br(14, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
                b.vuj += 1;
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(199004);
            }
          });
          this.vse.setText(2131760854);
          break label317;
        }
        this.vsk.setVisibility(8);
        b.vui = 0;
        break label317;
        label555:
        this.vrZ.setVisibility(8);
        break label362;
      }
      this.vsQ += 1;
    }
    label580:
    this.vrX.setCount(this.vsw.size());
    tK(2);
    paramcsj = new Rect();
    getWindowVisibleDisplayFrame(paramcsj);
    this.vso = (paramcsj.right - paramcsj.left);
    this.vsp = ((int)(this.vso * 1.667F));
    paramInt = (int)(this.vso * 1.335F);
    this.vsq = (this.vsp - paramInt);
    this.vrR.setMinimumHeight(paramInt);
    paramcsj = new AppBarLayout.LayoutParams(this.vsp);
    paramcsj.ns = 3;
    this.vrQ.setLayoutParams(paramcsj);
    this.vst = ((int)(this.vso * 1.0F));
    this.vrQ.setMinimumHeight(this.vst);
    setExpanded(false);
    if (this.vsW)
    {
      paramInt = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICK, Integer.valueOf(0))).intValue();
      label754:
      ad.i("MicroMsg.EnvelopeAppBarLayout", "show first guide: %s", new Object[] { Integer.valueOf(paramInt) });
      if ((paramInt >= 3) || (this.vsC != 2)) {
        break label1227;
      }
      paramInt = 1;
      label792:
      if (paramInt != 0)
      {
        this.vsV = true;
        this.vsl = ((ViewGroup)findViewById(2131301778));
        this.vsl.setVisibility(0);
        this.vrV.setVisibility(4);
        this.vsG = new ValueAnimator();
        this.vsG.setDuration(700L);
        this.vsG.setInterpolator(new AccelerateDecelerateInterpolator());
        this.vsG.setIntValues(new int[] { 0, this.vsr });
        this.vsH = new ObjectAnimator();
        this.vsH.setPropertyName("alpha");
        this.vsH.setFloatValues(new float[] { 1.0F, 0.0F });
        this.vsH.setTarget(this.vsl);
        this.vsH.setDuration(300L);
        this.vsH.setStartDelay(200L);
        this.vsH.addListener(new Animator.AnimatorListener()
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
        this.vsI = new ValueAnimator();
        this.vsI.setInterpolator(android.support.design.a.a.gM);
        this.vsI.setStartDelay(200L);
        this.vsI.setDuration(300L);
        this.vsI.setIntValues(new int[] { this.vsr, 0 });
        paramcsj = new ValueAnimator.AnimatorUpdateListener()
        {
          int vtf = 0;
          
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(163587);
            ad.d("MicroMsg.EnvelopeAppBarLayout", "animate value: " + paramAnonymousValueAnimator.getAnimatedValue());
            int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
            int j = i - this.vtf;
            this.vtf = i;
            float f = (EnvelopeAppBarLayout.s(EnvelopeAppBarLayout.this) - i) / (EnvelopeAppBarLayout.s(EnvelopeAppBarLayout.this) * 1.0F);
            if (EnvelopeAppBarLayout.this.vsC == 2) {
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
        this.vsG.addUpdateListener(paramcsj);
        this.vsI.addUpdateListener(paramcsj);
        this.vsJ = new AnimatorSet();
        this.vsJ.playSequentially(new Animator[] { this.vsG, this.vsH, this.vsI });
        this.vsJ.addListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(163588);
            EnvelopeAppBarLayout.t(EnvelopeAppBarLayout.this).setVisibility(8);
            if (EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this) != null) {
              EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).vul = false;
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
            AppMethodBeat.i(199005);
            if (EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this) != null) {
              EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).vul = true;
            }
            EnvelopeAppBarLayout.A(EnvelopeAppBarLayout.this).setStartDelay(700L);
            EnvelopeAppBarLayout.A(EnvelopeAppBarLayout.this).start();
            AppMethodBeat.o(199005);
          }
        });
        if (!this.vsW) {
          break label1233;
        }
        paramInt = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICK, Integer.valueOf(0))).intValue();
        com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICK, Integer.valueOf(paramInt + 1));
      }
    }
    for (;;)
    {
      this.vrS.getAdapter().asY.notifyChanged();
      break;
      paramInt = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICJ, Integer.valueOf(0))).intValue();
      break label754;
      label1227:
      paramInt = 0;
      break label792;
      label1233:
      paramInt = ((Integer)com.tencent.mm.kernel.g.ajC().ajl().get(al.a.ICJ, Integer.valueOf(0))).intValue();
      com.tencent.mm.kernel.g.ajC().ajl().set(al.a.ICJ, Integer.valueOf(paramInt + 1));
      continue;
      label1279:
      tK(1);
      diN();
    }
  }
  
  public final void diL()
  {
    AppMethodBeat.i(182455);
    Object localObject1;
    Object localObject2;
    int i;
    if (this.apN >= 0)
    {
      if (bt.isNullOrNil(b.sessionId))
      {
        AppMethodBeat.o(182455);
        return;
      }
      localObject1 = (com.tencent.mm.view.recyclerview.e)this.vrS.ci(this.apN);
      if (localObject1 != null)
      {
        boolean bool = diO();
        localObject1 = (EnvelopeAppBarLayout.b)((com.tencent.mm.view.recyclerview.e)localObject1).Lvw;
        if (bool)
        {
          localObject2 = this.vsx;
          i = this.apN;
          localObject2 = (EnvelopeStoryVideoManager.c)((EnvelopeStoryVideoManager)localObject2).vtz.get(Integer.valueOf(i));
          if (localObject2 == null)
          {
            AppMethodBeat.o(182455);
            return;
          }
          ((EnvelopeStoryVideoManager.c)localObject2).vtO = ((EnvelopeStoryVideoManager.c)localObject2).vtR.getCurrPosSec();
          if (((EnvelopeStoryVideoManager.c)localObject2).vtQ.get() == 1) {
            i = (int)(((EnvelopeStoryVideoManager.c)localObject2).vtO - ((EnvelopeStoryVideoManager.c)localObject2).vtN);
          }
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.g.yhR.f(19270, new Object[] { Integer.valueOf(2), this.vsz, ((EnvelopeStoryVideoManager.c)localObject2).vtQ, "", ((EnvelopeAppBarLayout.b)localObject1).vtl.Hya, Integer.valueOf(i), b.sessionId });
      AppMethodBeat.o(182455);
      return;
      if (((EnvelopeStoryVideoManager.c)localObject2).vtQ.get() > 1)
      {
        i = ((EnvelopeStoryVideoManager.c)localObject2).vtQ.get();
        i = (int)(((EnvelopeStoryVideoManager.c)localObject2).vtK - ((EnvelopeStoryVideoManager.c)localObject2).vtN + ((EnvelopeStoryVideoManager.c)localObject2).vtO + (i - 1) * ((EnvelopeStoryVideoManager.c)localObject2).vtK);
        continue;
        com.tencent.mm.plugin.report.service.g.yhR.f(19270, new Object[] { Integer.valueOf(1), this.vsz, Integer.valueOf(0), ((EnvelopeAppBarLayout.b)localObject1).vtl.Hya, "", Integer.valueOf(0), b.sessionId });
        AppMethodBeat.o(182455);
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public final void hL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(163608);
    if ((bt.isNullOrNil(this.vsA)) && (!bt.isNullOrNil(paramString1)))
    {
      this.vsA = paramString1;
      this.vsB = paramString2;
      this.vsm.setVisibility(0);
      ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.vrR, this.vsA, this.vsB, this.vsz, this.vsp, this.vso, 0, new a.a()
      {
        public final void iK(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(199006);
          EnvelopeAppBarLayout.B(EnvelopeAppBarLayout.this).setVisibility(8);
          AppMethodBeat.o(199006);
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
    diL();
    this.vsx.diV();
    if ((this.vsC == 1) || (this.vsC == 2)) {
      b.tQ(3);
    }
    d.tQ(11);
    AppMethodBeat.o(163604);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void onUIPause() {}
  
  public void setActivityLifeCycle(LuckyMoneyDetailUI paramLuckyMoneyDetailUI)
  {
    AppMethodBeat.i(199008);
    paramLuckyMoneyDetailUI.getLifecycle().addObserver(this.vsx);
    paramLuckyMoneyDetailUI.getLifecycle().addObserver(this);
    this.vsn = paramLuckyMoneyDetailUI;
    EnvelopeStoryVideoManager localEnvelopeStoryVideoManager = this.vsx;
    localEnvelopeStoryVideoManager.owV = paramLuckyMoneyDetailUI;
    aq.f(new EnvelopeStoryVideoManager.1(localEnvelopeStoryVideoManager));
    AppMethodBeat.o(199008);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout
 * JD-Core Version:    0.7.0.1
 */