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
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cne;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.dds;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.aj;
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
  private int anV;
  private int sKb;
  private TextView upA;
  private ViewGroup upB;
  private View upC;
  private ImageView upD;
  private ImageView upE;
  private ImageView upF;
  private ViewGroup upG;
  private ViewGroup upH;
  private ProgressBar upI;
  public LuckyMoneyDetailUI upJ;
  private int upK;
  private int upL;
  private int upM;
  private int upN;
  private int upO;
  private int upP;
  private int upQ;
  private EnvelopeStoryBehavior upR;
  private ArrayList<b> upS;
  private EnvelopeStoryVideoManager upT;
  private cng upU;
  private String upV;
  private String upW;
  private String upX;
  public int upY;
  private boolean upZ;
  private View upm;
  private ImageView upn;
  private RecyclerHorizontalViewPager upo;
  private RecyclerView upp;
  private TouchCoordinatorLayout upq;
  private ViewGroup upr;
  private ViewGroup ups;
  private MediaBannerIndicator upt;
  private TextView upu;
  private RoundCornerImageView upv;
  private TextView upw;
  private TextView upx;
  private TextView upy;
  private TextView upz;
  public boolean uqa;
  private boolean uqb;
  private ValueAnimator uqc;
  private ObjectAnimator uqd;
  private ValueAnimator uqe;
  private AnimatorSet uqf;
  private AppBarLayout.b uqg;
  private final float uqh;
  private final float uqi;
  private boolean uqj;
  private boolean uqk;
  private int uql;
  private boolean uqm;
  private boolean uqn;
  private boolean uqo;
  private boolean uqp;
  private boolean uqq;
  private boolean uqr;
  private View.OnClickListener uqs;
  private int uqt;
  
  public EnvelopeAppBarLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(163595);
    this.upN = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 130);
    this.upO = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 120);
    this.upP = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 250);
    this.upQ = (this.upP - this.upO);
    this.anV = 0;
    this.upS = new ArrayList();
    this.upZ = true;
    this.uqa = false;
    this.uqb = false;
    this.uqh = 1.335F;
    this.uqi = 0.6F;
    this.uqj = false;
    this.uqk = false;
    this.uqm = false;
    this.uqn = false;
    this.uqo = false;
    this.uqp = false;
    this.uqq = false;
    this.uqr = false;
    this.uqs = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163578);
        if ((!EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this)) && (EnvelopeAppBarLayout.this.upY == 2))
        {
          EnvelopeAppBarLayout.this.b(true, true, true);
          EnvelopeAppBarLayout.b(EnvelopeAppBarLayout.this);
          com.tencent.mm.plugin.luckymoney.a.d.tn(5);
          com.tencent.mm.plugin.luckymoney.a.c.bn(6, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
        }
        AppMethodBeat.o(163578);
      }
    };
    this.uqt = ai.getResources().getDimensionPixelSize(2131166499);
    init();
    AppMethodBeat.o(163595);
  }
  
  public EnvelopeAppBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163596);
    this.upN = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 130);
    this.upO = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 120);
    this.upP = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 250);
    this.upQ = (this.upP - this.upO);
    this.anV = 0;
    this.upS = new ArrayList();
    this.upZ = true;
    this.uqa = false;
    this.uqb = false;
    this.uqh = 1.335F;
    this.uqi = 0.6F;
    this.uqj = false;
    this.uqk = false;
    this.uqm = false;
    this.uqn = false;
    this.uqo = false;
    this.uqp = false;
    this.uqq = false;
    this.uqr = false;
    this.uqs = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163578);
        if ((!EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this)) && (EnvelopeAppBarLayout.this.upY == 2))
        {
          EnvelopeAppBarLayout.this.b(true, true, true);
          EnvelopeAppBarLayout.b(EnvelopeAppBarLayout.this);
          com.tencent.mm.plugin.luckymoney.a.d.tn(5);
          com.tencent.mm.plugin.luckymoney.a.c.bn(6, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
        }
        AppMethodBeat.o(163578);
      }
    };
    this.uqt = ai.getResources().getDimensionPixelSize(2131166499);
    init();
    AppMethodBeat.o(163596);
  }
  
  private void cZA()
  {
    AppMethodBeat.i(163599);
    this.upr.setOnClickListener(this.uqs);
    this.upn.setOnClickListener(this.uqs);
    AppMethodBeat.o(163599);
  }
  
  private void cZB()
  {
    AppMethodBeat.i(163600);
    Object localObject = new Rect();
    getWindowVisibleDisplayFrame((Rect)localObject);
    this.upK = (((Rect)localObject).right - ((Rect)localObject).left);
    this.upL = ((int)(this.upK * 1.335F));
    this.upn.setMinimumHeight(this.upL);
    localObject = new AppBarLayout.LayoutParams(this.upL);
    ((AppBarLayout.LayoutParams)localObject).lz = 3;
    this.upm.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.upm.setMinimumHeight(this.upO);
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
  
  private boolean cZC()
  {
    AppMethodBeat.i(163601);
    com.tencent.mm.view.recyclerview.e locale = (com.tencent.mm.view.recyclerview.e)this.upo.ci(this.anV);
    if (locale == null)
    {
      AppMethodBeat.o(163601);
      return false;
    }
    if (((b)locale.JCq).uqG.FNo == 2)
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
        EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, (EnvelopeStoryBehavior)((CoordinatorLayout.d)localObject).oH);
        EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this).uqa = EnvelopeAppBarLayout.this.uqa;
        localObject = EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this);
        if (EnvelopeAppBarLayout.this.upY == 1) {}
        for (boolean bool = true;; bool = false)
        {
          ((EnvelopeStoryBehavior)localObject).uqP = bool;
          EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this).uqQ = EnvelopeAppBarLayout.e(EnvelopeAppBarLayout.this);
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, (TouchCoordinatorLayout)EnvelopeAppBarLayout.this.getParent());
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).findViewById(2131301755));
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, (RecyclerView)EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).findViewById(2131301770));
          EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).a(new View.OnTouchListener()
          {
            float rYu;
            float tmJ;
            long uqv;
            boolean uqw = false;
            
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
                this.rYu = paramAnonymous2MotionEvent.getRawX();
                this.tmJ = paramAnonymous2MotionEvent.getRawY();
                this.uqv = bs.Gn();
                this.uqw = true;
              }
              for (;;)
              {
                AppMethodBeat.o(163583);
                return false;
                label100:
                this.uqw = false;
                continue;
                label108:
                if ((paramAnonymous2MotionEvent.getActionMasked() == 1) && (this.uqw) && (bs.aO(this.uqv) < 500L))
                {
                  paramAnonymous2View = new Rect();
                  EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this).getGlobalVisibleRect(paramAnonymous2View);
                  int i = (int)paramAnonymous2MotionEvent.getRawX();
                  int j = (int)paramAnonymous2MotionEvent.getRawY();
                  if ((Math.abs(i - this.rYu) <= 20.0F) && (Math.abs(j - this.tmJ) <= 20.0F) && (paramAnonymous2View.contains(i, j)))
                  {
                    ac.i("MicroMsg.EnvelopeAppBarLayout", "click collapse view");
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
    this.upT = new EnvelopeStoryVideoManager();
    initView();
    this.uqg = new AppBarLayout.b()
    {
      private int uqz = 0;
      
      public final void c(AppBarLayout paramAnonymousAppBarLayout, int paramAnonymousInt)
      {
        AppMethodBeat.i(163585);
        ac.d("MicroMsg.EnvelopeAppBarLayout", "offset: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
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
            if (EnvelopeAppBarLayout.this.upY != 2) {
              break label259;
            }
            EnvelopeAppBarLayout.o(EnvelopeAppBarLayout.this).setAlpha(f2);
          }
          label146:
          if ((paramAnonymousAppBarLayout.getTotalScrollRange() - paramAnonymousInt != 0) || (this.uqz == paramAnonymousInt)) {
            break label346;
          }
          EnvelopeAppBarLayout.q(EnvelopeAppBarLayout.this);
        }
        for (;;)
        {
          if (EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this) != null) {
            EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this).setAlpha((float)(f1 * 0.7D));
          }
          this.uqz = paramAnonymousInt;
          AppMethodBeat.o(163585);
          return;
          int j = paramAnonymousAppBarLayout.getTotalScrollRange();
          int k = EnvelopeAppBarLayout.l(EnvelopeAppBarLayout.this);
          float f3 = (paramAnonymousInt - EnvelopeAppBarLayout.l(EnvelopeAppBarLayout.this)) / ((j - k) * 1.0F);
          EnvelopeAppBarLayout.m(EnvelopeAppBarLayout.this).setAlpha(f3);
          break;
          label259:
          if (EnvelopeAppBarLayout.this.upY != 1) {
            break label146;
          }
          ac.d("MicroMsg.EnvelopeAppBarLayout", "distance: %s", new Object[] { Integer.valueOf(i) });
          if (i <= EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this))
          {
            f2 = i / (EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this) * 1.0F);
            EnvelopeAppBarLayout.o(EnvelopeAppBarLayout.this).setAlpha(f2);
            break label146;
          }
          EnvelopeAppBarLayout.o(EnvelopeAppBarLayout.this).setAlpha(1.0F);
          break label146;
          label346:
          if ((paramAnonymousInt == 0) && (this.uqz != paramAnonymousInt)) {
            EnvelopeAppBarLayout.r(EnvelopeAppBarLayout.this);
          }
        }
      }
    };
    a(this.uqg);
    AppMethodBeat.o(163597);
  }
  
  private void initView()
  {
    AppMethodBeat.i(163598);
    this.upm = findViewById(2131305332);
    this.upr = ((ViewGroup)findViewById(2131301776));
    this.ups = ((ViewGroup)findViewById(2131301779));
    this.upn = ((ImageView)findViewById(2131305413));
    this.upI = ((ProgressBar)findViewById(2131305414));
    this.upo = ((RecyclerHorizontalViewPager)findViewById(2131305482));
    this.upt = ((MediaBannerIndicator)findViewById(2131305333));
    this.upu = ((TextView)findViewById(2131305345));
    this.upv = ((RoundCornerImageView)findViewById(2131305462));
    this.upw = ((TextView)findViewById(2131305502));
    this.upx = ((TextView)findViewById(2131307252));
    this.upG = ((ViewGroup)findViewById(2131305490));
    this.upy = ((TextView)findViewById(2131301777));
    this.upz = ((TextView)findViewById(2131307211));
    this.upB = ((ViewGroup)findViewById(2131307212));
    this.upA = ((TextView)findViewById(2131305489));
    this.upD = ((ImageView)findViewById(2131301775));
    this.upE = ((ImageView)findViewById(2131305411));
    this.upF = ((ImageView)findViewById(2131305412));
    this.upv.shadowRadius = 4;
    this.upv.shadowColor = getResources().getColor(2131099670);
    this.upt.setSelectDrawable(getResources().getDrawable(2131233139));
    this.upt.setUnSelectDrawable(getResources().getDrawable(2131233140));
    this.upt.setIndicatorWidth(getResources().getDimensionPixelSize(2131165303));
    getContext();
    Object localObject = new HorizontalLayoutManager();
    this.upo.setHasFixedSize(true);
    this.upo.setItemViewCacheSize(4);
    final com.tencent.mm.plugin.luckymoney.scaledLayout.a locala = new com.tencent.mm.plugin.luckymoney.scaledLayout.a();
    locala.context = getContext();
    locala.uot = true;
    this.upo.setSnapHelper(locala);
    this.upo.setOnInterceptTouchEvent(new RecyclerHorizontalViewPager.c()
    {
      public final boolean b(MotionEvent paramAnonymousMotionEvent, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(163589);
        if (paramAnonymousMotionEvent.getAction() == 0) {
          locala.uos = com.tencent.mm.plugin.luckymoney.scaledLayout.a.h(this.uqC);
        }
        AppMethodBeat.o(163589);
        return paramAnonymousBoolean;
      }
      
      public final void k(MotionEvent paramAnonymousMotionEvent) {}
    });
    ((HorizontalLayoutManager)localObject).oOD = 1;
    ((HorizontalLayoutManager)localObject).aw(true);
    ((LinearLayoutManager)localObject).aoA = 3;
    ((HorizontalLayoutManager)localObject).setOrientation(0);
    this.upo.setLayoutManager((RecyclerView.i)localObject);
    localObject = new WxRecyclerAdapter(new com.tencent.mm.view.recyclerview.c()
    {
      public final com.tencent.mm.view.recyclerview.b<?> Ac(int paramAnonymousInt)
      {
        AppMethodBeat.i(163590);
        EnvelopeAppBarLayout.a locala = new EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this);
        AppMethodBeat.o(163590);
        return locala;
      }
    }, this.upS, false);
    this.upo.setAdapter((RecyclerView.a)localObject);
    this.upo.setPageChangeListener(new RecyclerHorizontalViewPager.b()
    {
      public final void ad(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(163591);
        ac.i("MicroMsg.EnvelopeAppBarLayout", "on page change: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        com.tencent.mm.view.recyclerview.e locale;
        EnvelopeAppBarLayout.b localb;
        if (paramAnonymousBoolean)
        {
          if (EnvelopeAppBarLayout.u(EnvelopeAppBarLayout.this) == paramAnonymousInt)
          {
            AppMethodBeat.o(163591);
            return;
          }
          EnvelopeAppBarLayout.this.cZz();
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, paramAnonymousInt);
          locale = (com.tencent.mm.view.recyclerview.e)EnvelopeAppBarLayout.v(EnvelopeAppBarLayout.this).ci(paramAnonymousInt);
          if (locale != null)
          {
            paramAnonymousBoolean = EnvelopeAppBarLayout.w(EnvelopeAppBarLayout.this);
            localb = (EnvelopeAppBarLayout.b)locale.JCq;
            if (!paramAnonymousBoolean) {
              break label206;
            }
            localb.cZD();
          }
        }
        for (;;)
        {
          EnvelopeAppBarLayout.x(EnvelopeAppBarLayout.this).a(EnvelopeAppBarLayout.this.getContext(), (FrameLayout)locale.adJ(2131301783), (ImageView)locale.adJ(2131301780), (ProgressBar)locale.adJ(2131301781), localb.uqG.FNp, localb.videoWidth, localb.videoHeight, paramAnonymousInt, paramAnonymousBoolean);
          com.tencent.mm.plugin.luckymoney.a.d.tn(6);
          b.urx += 1;
          EnvelopeAppBarLayout.y(EnvelopeAppBarLayout.this).setCurrentIndex(paramAnonymousInt);
          AppMethodBeat.o(163591);
          return;
          label206:
          b.urA += 1;
        }
      }
    });
    AppMethodBeat.o(163598);
  }
  
  private void tg(int paramInt)
  {
    AppMethodBeat.i(163607);
    this.upY = paramInt;
    switch (this.upY)
    {
    default: 
      AppMethodBeat.o(163607);
      return;
    case 0: 
      this.upZ = true;
      this.uqa = true;
      this.upr.setVisibility(8);
      this.upF.setVisibility(8);
      if (aj.DT())
      {
        this.upE.setImageResource(2131690387);
        AppMethodBeat.o(163607);
        return;
      }
      this.upE.setImageResource(2131690386);
      AppMethodBeat.o(163607);
      return;
    case 1: 
      this.upZ = true;
      this.uqa = true;
      this.upr.setVisibility(0);
      this.upD.setVisibility(8);
      this.upn.setVisibility(0);
      this.upF.setVisibility(8);
      FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
      localLayoutParams.bottomMargin = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 32);
      this.upB.setLayoutParams(localLayoutParams);
      if (aj.DT())
      {
        this.upE.setImageResource(2131690387);
        AppMethodBeat.o(163607);
        return;
      }
      this.upE.setImageResource(2131690386);
      AppMethodBeat.o(163607);
      return;
    }
    this.upZ = false;
    this.uqa = false;
    this.upr.setVisibility(0);
    this.upD.setVisibility(0);
    this.upF.setVisibility(0);
    this.upF.setAlpha(0.0F);
    if (aj.DT()) {
      this.upE.setImageResource(2131690387);
    }
    for (;;)
    {
      com.tencent.mm.plugin.luckymoney.a.c.bn(4, this.upW);
      break;
      this.upE.setImageResource(2131690386);
    }
  }
  
  public final void a(cng paramcng, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(207103);
    if (bs.isNullOrNil(this.upW))
    {
      tg(0);
      this.upL = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 502);
      paramcng = new AppBarLayout.LayoutParams(this.upL);
      paramcng.lz = 3;
      this.upm.setMinimumHeight(this.upO);
      this.upm.setLayoutParams(paramcng);
    }
    for (;;)
    {
      ac.i("MicroMsg.EnvelopeAppBarLayout", "set envelope story: %s", new Object[] { Integer.valueOf(this.upY) });
      AppMethodBeat.o(207103);
      return;
      if (paramcng != null) {
        break;
      }
      tg(1);
      cZB();
      this.upy.setText(paramString2);
      a.urv = paramString2;
    }
    this.upU = paramcng;
    this.upV = paramString1;
    this.uqr = paramBoolean;
    this.upu.setText(this.upU.description);
    this.upw.setText(this.upU.FAr);
    this.upy.setText(this.upU.title);
    a.urv = this.upU.FAr;
    if (paramcng.FAw != null) {
      paramInt = paramcng.FAw.hhv;
    }
    if (paramInt == 2)
    {
      this.upz.setVisibility(0);
      this.upx.setVisibility(0);
      if (this.upU.nWg != 2) {
        break label479;
      }
      if (!bs.isNullOrNil(this.upU.FAu))
      {
        if (!this.uqo)
        {
          com.tencent.mm.plugin.luckymoney.a.c.bn(11, this.upW);
          this.uqo = true;
        }
        com.tencent.mm.wallet_core.ui.e.aT(this.upG, 100);
        b.urF = 1;
        this.upG.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(174332);
            ac.d("MicroMsg.EnvelopeAppBarLayout", "go to profile");
            if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
            {
              com.tencent.mm.wallet_core.ui.e.cm(EnvelopeAppBarLayout.this.getContext(), EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).FAu);
              com.tencent.mm.plugin.luckymoney.a.d.tn(7);
              com.tencent.mm.plugin.luckymoney.a.c.bn(13, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
              b.urG += 1;
            }
            AppMethodBeat.o(174332);
          }
        });
        this.upA.setText(2131760853);
      }
      label317:
      if (bs.isNullOrNil(paramcng.hhs)) {
        break label555;
      }
      ((com.tencent.mm.plugin.luckymoney.a.a)g.ab(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.upv, paramcng.hhs, paramcng.hht, paramString1);
      this.upv.setVisibility(0);
      label362:
      this.upS.clear();
      if (paramcng.FAs.isEmpty()) {
        break label1267;
      }
      b.urE = 1;
      a.urw = 2;
      paramcng = paramcng.FAs.iterator();
    }
    for (;;)
    {
      if (!paramcng.hasNext()) {
        break label580;
      }
      paramString1 = (dds)paramcng.next();
      paramString2 = new b();
      paramString2.uqG = paramString1;
      this.upS.add(paramString2);
      if (paramString1.FNo == 2)
      {
        this.sKb += 1;
        continue;
        this.upz.setVisibility(8);
        this.upx.setVisibility(8);
        break;
        label479:
        if (this.upU.nWg == 3)
        {
          if (!this.uqp)
          {
            com.tencent.mm.plugin.luckymoney.a.c.bn(12, this.upW);
            this.uqp = true;
          }
          this.upG.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(207099);
              ac.d("MicroMsg.EnvelopeAppBarLayout", "go to mini app");
              if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
              {
                com.tencent.mm.wallet_core.ui.e.v(EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).FAu, EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).FAt, 0, 1100);
                com.tencent.mm.plugin.luckymoney.a.d.tn(7);
                com.tencent.mm.plugin.luckymoney.a.c.bn(14, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
                b.urG += 1;
              }
              AppMethodBeat.o(207099);
            }
          });
          this.upA.setText(2131760854);
          break label317;
        }
        this.upG.setVisibility(8);
        b.urF = 0;
        break label317;
        label555:
        this.upv.setVisibility(8);
        break label362;
      }
      this.uql += 1;
    }
    label580:
    this.upt.setCount(this.upS.size());
    tg(2);
    paramcng = new Rect();
    getWindowVisibleDisplayFrame(paramcng);
    this.upK = (paramcng.right - paramcng.left);
    this.upL = ((int)(this.upK * 1.667F));
    paramInt = (int)(this.upK * 1.335F);
    this.upM = (this.upL - paramInt);
    this.upn.setMinimumHeight(paramInt);
    paramcng = new AppBarLayout.LayoutParams(this.upL);
    paramcng.lz = 3;
    this.upm.setLayoutParams(paramcng);
    this.upm.setMinimumHeight(this.upP);
    setExpanded(false);
    if (this.uqr)
    {
      paramInt = ((Integer)g.agR().agA().get(ah.a.GQq, Integer.valueOf(0))).intValue();
      label742:
      ac.i("MicroMsg.EnvelopeAppBarLayout", "show first guide: %s", new Object[] { Integer.valueOf(paramInt) });
      if ((paramInt >= 3) || (this.upY != 2)) {
        break label1215;
      }
      paramInt = 1;
      label780:
      if (paramInt != 0)
      {
        this.uqq = true;
        this.upH = ((ViewGroup)findViewById(2131301778));
        this.upH.setVisibility(0);
        this.upr.setVisibility(4);
        this.uqc = new ValueAnimator();
        this.uqc.setDuration(700L);
        this.uqc.setInterpolator(new AccelerateDecelerateInterpolator());
        this.uqc.setIntValues(new int[] { 0, this.upN });
        this.uqd = new ObjectAnimator();
        this.uqd.setPropertyName("alpha");
        this.uqd.setFloatValues(new float[] { 1.0F, 0.0F });
        this.uqd.setTarget(this.upH);
        this.uqd.setDuration(300L);
        this.uqd.setStartDelay(200L);
        this.uqd.addListener(new Animator.AnimatorListener()
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
        this.uqe = new ValueAnimator();
        this.uqe.setInterpolator(android.support.design.a.a.eT);
        this.uqe.setStartDelay(200L);
        this.uqe.setDuration(300L);
        this.uqe.setIntValues(new int[] { this.upN, 0 });
        paramcng = new ValueAnimator.AnimatorUpdateListener()
        {
          int uqA = 0;
          
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(163587);
            ac.d("MicroMsg.EnvelopeAppBarLayout", "animate value: " + paramAnonymousValueAnimator.getAnimatedValue());
            int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
            int j = i - this.uqA;
            this.uqA = i;
            float f = (EnvelopeAppBarLayout.s(EnvelopeAppBarLayout.this) - i) / (EnvelopeAppBarLayout.s(EnvelopeAppBarLayout.this) * 1.0F);
            if (EnvelopeAppBarLayout.this.upY == 2) {
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
        this.uqc.addUpdateListener(paramcng);
        this.uqe.addUpdateListener(paramcng);
        this.uqf = new AnimatorSet();
        this.uqf.playSequentially(new Animator[] { this.uqc, this.uqd, this.uqe });
        this.uqf.addListener(new Animator.AnimatorListener()
        {
          public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            AppMethodBeat.i(163588);
            EnvelopeAppBarLayout.t(EnvelopeAppBarLayout.this).setVisibility(8);
            if (EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this) != null) {
              EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).urI = false;
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
            AppMethodBeat.i(207100);
            if (EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this) != null) {
              EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).urI = true;
            }
            EnvelopeAppBarLayout.A(EnvelopeAppBarLayout.this).setStartDelay(700L);
            EnvelopeAppBarLayout.A(EnvelopeAppBarLayout.this).start();
            AppMethodBeat.o(207100);
          }
        });
        if (!this.uqr) {
          break label1221;
        }
        paramInt = ((Integer)g.agR().agA().get(ah.a.GQq, Integer.valueOf(0))).intValue();
        g.agR().agA().set(ah.a.GQq, Integer.valueOf(paramInt + 1));
      }
    }
    for (;;)
    {
      this.upo.getAdapter().arg.notifyChanged();
      break;
      paramInt = ((Integer)g.agR().agA().get(ah.a.GQp, Integer.valueOf(0))).intValue();
      break label742;
      label1215:
      paramInt = 0;
      break label780;
      label1221:
      paramInt = ((Integer)g.agR().agA().get(ah.a.GQp, Integer.valueOf(0))).intValue();
      g.agR().agA().set(ah.a.GQp, Integer.valueOf(paramInt + 1));
      continue;
      label1267:
      tg(1);
      cZB();
    }
  }
  
  public final void cZz()
  {
    AppMethodBeat.i(182455);
    Object localObject1;
    Object localObject2;
    int i;
    if (this.anV >= 0)
    {
      if (bs.isNullOrNil(b.sessionId))
      {
        AppMethodBeat.o(182455);
        return;
      }
      localObject1 = (com.tencent.mm.view.recyclerview.e)this.upo.ci(this.anV);
      if (localObject1 != null)
      {
        boolean bool = cZC();
        localObject1 = (b)((com.tencent.mm.view.recyclerview.e)localObject1).JCq;
        if (bool)
        {
          localObject2 = this.upT;
          i = this.anV;
          localObject2 = (EnvelopeStoryVideoManager.c)((EnvelopeStoryVideoManager)localObject2).uqU.get(Integer.valueOf(i));
          if (localObject2 == null)
          {
            AppMethodBeat.o(182455);
            return;
          }
          ((EnvelopeStoryVideoManager.c)localObject2).urk = ((EnvelopeStoryVideoManager.c)localObject2).uro.getCurrPosSec();
          if (((EnvelopeStoryVideoManager.c)localObject2).urn.get() == 1) {
            i = (int)(((EnvelopeStoryVideoManager.c)localObject2).urk - ((EnvelopeStoryVideoManager.c)localObject2).urj);
          }
        }
      }
    }
    for (;;)
    {
      h.wUl.f(19270, new Object[] { Integer.valueOf(2), this.upV, ((EnvelopeStoryVideoManager.c)localObject2).urn, "", ((b)localObject1).uqG.FNp, Integer.valueOf(i), b.sessionId });
      AppMethodBeat.o(182455);
      return;
      if (((EnvelopeStoryVideoManager.c)localObject2).urn.get() > 1)
      {
        i = ((EnvelopeStoryVideoManager.c)localObject2).urn.get();
        i = (int)(((EnvelopeStoryVideoManager.c)localObject2).urf - ((EnvelopeStoryVideoManager.c)localObject2).urj + ((EnvelopeStoryVideoManager.c)localObject2).urk + (i - 1) * ((EnvelopeStoryVideoManager.c)localObject2).urf);
        continue;
        h.wUl.f(19270, new Object[] { Integer.valueOf(1), this.upV, Integer.valueOf(0), ((b)localObject1).uqG.FNp, "", Integer.valueOf(0), b.sessionId });
        AppMethodBeat.o(182455);
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public final void hz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(163608);
    if ((bs.isNullOrNil(this.upW)) && (!bs.isNullOrNil(paramString1)))
    {
      this.upW = paramString1;
      this.upX = paramString2;
      this.upI.setVisibility(0);
      ((com.tencent.mm.plugin.luckymoney.a.a)g.ab(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.upn, this.upW, this.upX, this.upV, this.upL, this.upK, 0, new a.a()
      {
        public final void iB(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(207101);
          EnvelopeAppBarLayout.B(EnvelopeAppBarLayout.this).setVisibility(8);
          AppMethodBeat.o(207101);
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
    cZz();
    this.upT.cZJ();
    if ((this.upY == 1) || (this.upY == 2)) {
      b.tn(3);
    }
    com.tencent.mm.plugin.luckymoney.a.d.tn(11);
    AppMethodBeat.o(163604);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  public void onUIPause() {}
  
  public void setActivityLifeCycle(LuckyMoneyDetailUI paramLuckyMoneyDetailUI)
  {
    AppMethodBeat.i(207102);
    paramLuckyMoneyDetailUI.getLifecycle().addObserver(this.upT);
    paramLuckyMoneyDetailUI.getLifecycle().addObserver(this);
    this.upJ = paramLuckyMoneyDetailUI;
    EnvelopeStoryVideoManager localEnvelopeStoryVideoManager = this.upT;
    localEnvelopeStoryVideoManager.nTA = paramLuckyMoneyDetailUI;
    ap.f(new EnvelopeStoryVideoManager.1(localEnvelopeStoryVideoManager));
    AppMethodBeat.o(207102);
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
    public dds uqG;
    public int videoHeight = -1;
    public int videoWidth = -1;
    
    b() {}
    
    public final int bTF()
    {
      return 0;
    }
    
    public final void cZD()
    {
      AppMethodBeat.i(163594);
      if ((this.videoHeight > 0) && (this.videoWidth > 0))
      {
        AppMethodBeat.o(163594);
        return;
      }
      float f = this.uqG.height / (this.uqG.width * 1.0F);
      if (f > 1.667F)
      {
        this.videoHeight = EnvelopeAppBarLayout.D(EnvelopeAppBarLayout.this);
        this.videoWidth = ((int)(EnvelopeAppBarLayout.D(EnvelopeAppBarLayout.this) / f));
      }
      for (;;)
      {
        ac.d("MicroMsg.EnvelopeAppBarLayout", "video size: %s, %s", new Object[] { Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight) });
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
    
    public final long lx()
    {
      return 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout
 * JD-Core Version:    0.7.0.1
 */