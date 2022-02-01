package com.tencent.mm.plugin.luckymoney.story;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout.d;
import androidx.lifecycle.h.a;
import androidx.lifecycle.k;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.LayoutParams;
import com.google.android.material.appbar.AppBarLayout.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.luckymoney.a.a.a;
import com.tencent.mm.plugin.luckymoney.a.d;
import com.tencent.mm.plugin.luckymoney.ui.HorizontalLayoutManager;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.dvj;
import com.tencent.mm.protocal.protobuf.dvl;
import com.tencent.mm.protocal.protobuf.eno;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.util.b.a;
import com.tencent.mm.vfs.u;
import com.tencent.mm.view.MediaBannerIndicator;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.RecyclerHorizontalViewPager.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.wallet_core.ui.g;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class EnvelopeAppBarLayout
  extends AppBarLayout
  implements k
{
  private ViewGroup EDA;
  private ProgressBar EDB;
  public LuckyMoneyDetailUI EDC;
  private ObjectAnimator EDD;
  private boolean EDE;
  private int EDF;
  private int EDG;
  private int EDH;
  private int EDI;
  private int EDJ;
  private int EDK;
  private int EDL;
  private EnvelopeStoryBehavior EDM;
  private ArrayList<b> EDN;
  private EnvelopeStoryVideoManager EDO;
  private dvl EDP;
  private String EDQ;
  private String EDR;
  private String EDS;
  public int EDT;
  private boolean EDU;
  public boolean EDV;
  private boolean EDW;
  private ValueAnimator EDX;
  private ObjectAnimator EDY;
  private ValueAnimator EDZ;
  private View EDe;
  private ImageView EDf;
  private RecyclerHorizontalViewPager EDg;
  private RecyclerView EDh;
  private TouchCoordinatorLayout EDi;
  private ViewGroup EDj;
  private ViewGroup EDk;
  private MediaBannerIndicator EDl;
  private TextView EDm;
  private RoundCornerImageView EDn;
  private TextView EDo;
  private TextView EDp;
  private TextView EDq;
  private TextView EDr;
  private TextView EDs;
  private ViewGroup EDt;
  private View EDu;
  private ImageView EDv;
  private ImageView EDw;
  private ImageView EDx;
  private ViewGroup EDy;
  private ViewGroup EDz;
  private AnimatorSet EEa;
  private AppBarLayout.b EEb;
  private final float EEc;
  private final float EEd;
  private final float EEe;
  private boolean EEf;
  private boolean EEg;
  private int EEh;
  private boolean EEi;
  private boolean EEj;
  private boolean EEk;
  private boolean EEl;
  private boolean EEm;
  private boolean EEn;
  private boolean EEo;
  private boolean EEp;
  private boolean EEq;
  private boolean EEr;
  private boolean EEs;
  private boolean EEt;
  private View.OnClickListener EEu;
  private int EEv;
  private int aiM;
  private boolean isPreview;
  private int xzT;
  
  public EnvelopeAppBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163596);
    this.EDE = false;
    this.EDI = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 130);
    this.EDJ = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 120);
    this.EDK = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 420);
    this.EDL = (this.EDK - this.EDJ);
    this.aiM = 0;
    this.EDN = new ArrayList();
    this.EDU = true;
    this.EDV = false;
    this.EDW = false;
    this.EEc = 1.335F;
    this.EEd = 1.0F;
    this.EEe = 0.6F;
    this.EEf = false;
    this.EEg = false;
    this.EEi = false;
    this.EEj = false;
    this.EEk = false;
    this.EEl = false;
    this.EEm = false;
    this.EEn = false;
    this.EEo = false;
    this.EEp = false;
    this.isPreview = false;
    this.EEq = false;
    this.EEr = false;
    this.EEu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163578);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((!EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this)) && (EnvelopeAppBarLayout.this.EDT == 2))
        {
          EnvelopeAppBarLayout.this.c(true, true, true);
          EnvelopeAppBarLayout.b(EnvelopeAppBarLayout.this);
          d.Bv(5);
          com.tencent.mm.plugin.luckymoney.a.c.bz(6, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(163578);
      }
    };
    this.EEv = MMApplicationContext.getResources().getDimensionPixelSize(a.d.lucky_money_detail_story_logo_size);
    inflate(getContext(), a.g.lucky_money_detail_story_layout, this);
    setExpanded(false);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163584);
        EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this);
        Object localObject = (CoordinatorLayout.d)EnvelopeAppBarLayout.this.getLayoutParams();
        EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, (EnvelopeStoryBehavior)((CoordinatorLayout.d)localObject).Hq);
        EnvelopeAppBarLayout.e(EnvelopeAppBarLayout.this).EDV = EnvelopeAppBarLayout.this.EDV;
        localObject = EnvelopeAppBarLayout.e(EnvelopeAppBarLayout.this);
        if ((EnvelopeAppBarLayout.this.EDT == 1) || (EnvelopeAppBarLayout.this.EDT == 2)) {}
        for (boolean bool = true;; bool = false)
        {
          ((EnvelopeStoryBehavior)localObject).EEV = bool;
          EnvelopeAppBarLayout.e(EnvelopeAppBarLayout.this).EEW = EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this);
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, (TouchCoordinatorLayout)EnvelopeAppBarLayout.this.getParent());
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this).findViewById(a.f.lucky_money_detail_expand_white_cover));
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, (RecyclerView)EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this).findViewById(a.f.lucky_money_detail_record_list));
          EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this).b(new View.OnTouchListener()
          {
            long EEy;
            boolean EEz = false;
            float aCa;
            float aCb;
            
            public final boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
            {
              AppMethodBeat.i(163583);
              if (paramAnonymous2MotionEvent.getActionMasked() == 0) {
                EnvelopeAppBarLayout.h(EnvelopeAppBarLayout.this);
              }
              if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
              {
                if (paramAnonymous2MotionEvent.getActionMasked() != 0) {
                  break label125;
                }
                paramAnonymous2View = new Rect();
                EnvelopeAppBarLayout.i(EnvelopeAppBarLayout.this).getGlobalVisibleRect(paramAnonymous2View);
                if (!paramAnonymous2View.contains((int)paramAnonymous2MotionEvent.getRawX(), (int)paramAnonymous2MotionEvent.getRawY())) {
                  break label117;
                }
                this.aCa = paramAnonymous2MotionEvent.getRawX();
                this.aCb = paramAnonymous2MotionEvent.getRawY();
                this.EEy = Util.currentTicks();
                this.EEz = true;
              }
              for (;;)
              {
                AppMethodBeat.o(163583);
                return false;
                label117:
                this.EEz = false;
                continue;
                label125:
                if ((paramAnonymous2MotionEvent.getActionMasked() == 1) && (this.EEz) && (Util.ticksToNow(this.EEy) < 500L))
                {
                  paramAnonymous2View = new Rect();
                  EnvelopeAppBarLayout.i(EnvelopeAppBarLayout.this).getGlobalVisibleRect(paramAnonymous2View);
                  int i = (int)paramAnonymous2MotionEvent.getRawX();
                  int j = (int)paramAnonymous2MotionEvent.getRawY();
                  if ((Math.abs(i - this.aCa) <= 20.0F) && (Math.abs(j - this.aCb) <= 20.0F) && (paramAnonymous2View.contains(i, j)))
                  {
                    Log.i("MicroMsg.EnvelopeAppBarLayout", "click collapse view");
                    EnvelopeAppBarLayout.j(EnvelopeAppBarLayout.this);
                    EnvelopeAppBarLayout.this.postDelayed(new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(163582);
                        EnvelopeAppBarLayout.this.c(false, true, true);
                        AppMethodBeat.o(163582);
                      }
                    }, 30L);
                  }
                }
              }
            }
          });
          EnvelopeAppBarLayout.i(EnvelopeAppBarLayout.this).setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
            {
              return false;
            }
          });
          EnvelopeAppBarLayout.k(EnvelopeAppBarLayout.this);
          AppMethodBeat.o(163584);
          return;
        }
      }
    });
    this.EDO = new EnvelopeStoryVideoManager();
    this.EDe = findViewById(a.f.story_content_layout);
    this.EDj = ((ViewGroup)findViewById(a.f.lucky_money_detail_story_collapse_layout));
    this.EDk = ((ViewGroup)findViewById(a.f.lucky_money_detail_story_info_layout));
    this.EDf = ((ImageView)findViewById(a.f.story_envelope_iv));
    this.EDB = ((ProgressBar)findViewById(a.f.story_envelope_loading_iv));
    this.EDg = ((RecyclerHorizontalViewPager)findViewById(a.f.story_pager_view));
    this.EDl = ((MediaBannerIndicator)findViewById(a.f.story_control_indicator));
    this.EDm = ((TextView)findViewById(a.f.story_desc_tv));
    this.EDn = ((RoundCornerImageView)findViewById(a.f.story_logo_iv));
    this.EDo = ((TextView)findViewById(a.f.story_username_tv));
    this.EDp = ((TextView)findViewById(a.f.story_username_label_tv));
    this.EDy = ((ViewGroup)findViewById(a.f.story_profile_enter_layout));
    this.EDz = ((ViewGroup)findViewById(a.f.story_profile_layout));
    this.EDq = ((TextView)findViewById(a.f.lucky_money_detail_story_collapse_title_tv));
    this.EDr = ((TextView)findViewById(a.f.lucky_money_detail_story_collapse_title_label_tv));
    this.EDt = ((ViewGroup)findViewById(a.f.lucky_money_detail_story_collapse_title_layout));
    this.EDs = ((TextView)findViewById(a.f.story_profile_enter_btn));
    this.EDv = ((ImageView)findViewById(a.f.lucky_money_detail_story_collapse_down_btn));
    this.EDw = ((ImageView)findViewById(a.f.story_envelope_bottom_cover_iv));
    this.EDx = ((ImageView)findViewById(a.f.story_envelope_bottom_cover_shadow_iv));
    this.EDn.shadowRadius = 4;
    this.EDn.shadowColor = getResources().getColor(a.c.BW_100_Alpha_0_3);
    this.EDl.setSelectDrawable(getResources().getDrawable(a.e.lucky_money_story_selected_radius));
    this.EDl.setUnSelectDrawable(getResources().getDrawable(a.e.lucky_money_story_unselected_radius));
    this.EDl.setIndicatorWidth(getResources().getDimensionPixelSize(a.d.Edge_A));
    getContext();
    paramContext = new HorizontalLayoutManager();
    this.EDg.setHasFixedSize(true);
    this.EDg.setItemViewCacheSize(4);
    paramAttributeSet = new com.tencent.mm.plugin.luckymoney.scaledLayout.a();
    paramAttributeSet.context = getContext();
    paramAttributeSet.ECn = true;
    this.EDg.setSnapHelper(paramAttributeSet);
    this.EDg.setOnInterceptTouchEvent(new EnvelopeAppBarLayout.19(this, paramAttributeSet, paramContext));
    paramContext.uqm = 1;
    paramContext.setItemPrefetchEnabled(true);
    paramContext.ajf = 3;
    paramContext.setOrientation(0);
    this.EDg.setLayoutManager(paramContext);
    paramContext = new WxRecyclerAdapter(new com.tencent.mm.view.recyclerview.f()
    {
      public final e<?> yx(int paramAnonymousInt)
      {
        AppMethodBeat.i(163590);
        EnvelopeAppBarLayout.a locala = new EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this);
        AppMethodBeat.o(163590);
        return locala;
      }
    }, this.EDN, false);
    this.EDg.setAdapter(paramContext);
    this.EDg.setPageChangeListener(new RecyclerHorizontalViewPager.b()
    {
      public final void al(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        boolean bool1 = true;
        AppMethodBeat.i(187391);
        Log.i("MicroMsg.EnvelopeAppBarLayout", "on page change: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        com.tencent.mm.view.recyclerview.i locali;
        boolean bool2;
        EnvelopeAppBarLayout.b localb;
        String str;
        if (paramAnonymousBoolean)
        {
          if (EnvelopeAppBarLayout.C(EnvelopeAppBarLayout.this) == paramAnonymousInt)
          {
            AppMethodBeat.o(187391);
            return;
          }
          EnvelopeAppBarLayout.this.ePd();
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, paramAnonymousInt);
          locali = (com.tencent.mm.view.recyclerview.i)EnvelopeAppBarLayout.s(EnvelopeAppBarLayout.this).cK(paramAnonymousInt);
          if (locali != null)
          {
            bool2 = EnvelopeAppBarLayout.D(EnvelopeAppBarLayout.this);
            localb = (EnvelopeAppBarLayout.b)locali.YSz;
            if (!bool2) {
              break label241;
            }
            localb.ePk();
            if (!EnvelopeStoryVideoManager.bB(localb.EEK, localb.EEM)) {
              break label252;
            }
            str = localb.EEM;
          }
        }
        for (paramAnonymousBoolean = bool1;; paramAnonymousBoolean = false)
        {
          EnvelopeAppBarLayout.E(EnvelopeAppBarLayout.this).a(EnvelopeAppBarLayout.this.getContext(), (FrameLayout)locali.RD(a.f.lucky_money_detail_story_item_video_container), (ImageView)locali.RD(a.f.lucky_money_detail_story_item_image_iv), (ProgressBar)locali.RD(a.f.lucky_money_detail_story_item_loading_pb), str, localb.videoWidth, localb.videoHeight, paramAnonymousInt, bool2, paramAnonymousBoolean, false);
          d.Bv(6);
          b.EFB += 1;
          EnvelopeAppBarLayout.F(EnvelopeAppBarLayout.this).setCurrentIndex(paramAnonymousInt);
          AppMethodBeat.o(187391);
          return;
          label241:
          b.EFE += 1;
          break;
          label252:
          str = localb.EEJ.Uqm;
        }
      }
    });
    this.EEb = new AppBarLayout.b()
    {
      private int Aze = 0;
      private int EEC = 0;
      
      public final void c(AppBarLayout paramAnonymousAppBarLayout, int paramAnonymousInt)
      {
        AppMethodBeat.i(242089);
        int i = Math.abs(paramAnonymousInt);
        int j = paramAnonymousAppBarLayout.getTotalScrollRange() - EnvelopeAppBarLayout.l(EnvelopeAppBarLayout.this) - i;
        float f1 = j / ((paramAnonymousAppBarLayout.getTotalScrollRange() - EnvelopeAppBarLayout.l(EnvelopeAppBarLayout.this)) * 1.0F);
        float f2 = 1.0F - f1;
        Log.d("MicroMsg.EnvelopeAppBarLayout", "offset: %s, distance: %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(j) });
        int k;
        if (!EnvelopeAppBarLayout.m(EnvelopeAppBarLayout.this))
        {
          EnvelopeAppBarLayout.n(EnvelopeAppBarLayout.this).setAlpha(1.0F - f2);
          if ((i <= EnvelopeAppBarLayout.o(EnvelopeAppBarLayout.this)) || (EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this)))
          {
            EnvelopeAppBarLayout.q(EnvelopeAppBarLayout.this).setAlpha(0.0F);
            EnvelopeAppBarLayout.r(EnvelopeAppBarLayout.this).setAlpha(1.0F - f2);
          }
        }
        else
        {
          Log.d("MicroMsg.EnvelopeAppBarLayout", "mHasTranslationPagerView: %s", new Object[] { Boolean.valueOf(EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this)) });
          if ((EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this)) && (j >= 0) && (j != this.EEC))
          {
            k = Math.max(0, this.EEC);
            EnvelopeAppBarLayout.s(EnvelopeAppBarLayout.this).setTranslationY(-paramAnonymousInt / 2.0F);
            Log.d("MicroMsg.EnvelopeAppBarLayout", "offset: %s, top: %s", new Object[] { Integer.valueOf(j - k), Float.valueOf(EnvelopeAppBarLayout.s(EnvelopeAppBarLayout.this).getTranslationY()) });
            if (EnvelopeAppBarLayout.s(EnvelopeAppBarLayout.this).getTranslationY() <= 0.0F)
            {
              EnvelopeAppBarLayout.s(EnvelopeAppBarLayout.this).setTranslationY(0.0F);
              EnvelopeAppBarLayout.t(EnvelopeAppBarLayout.this);
            }
          }
          if (EnvelopeAppBarLayout.u(EnvelopeAppBarLayout.this) != null)
          {
            if (EnvelopeAppBarLayout.this.EDT != 2) {
              break label463;
            }
            EnvelopeAppBarLayout.u(EnvelopeAppBarLayout.this).setAlpha(f2);
          }
          label328:
          if ((paramAnonymousAppBarLayout.getTotalScrollRange() - i != 0) || (this.Aze == i)) {
            break label555;
          }
          EnvelopeAppBarLayout.v(EnvelopeAppBarLayout.this);
        }
        for (;;)
        {
          if (EnvelopeAppBarLayout.i(EnvelopeAppBarLayout.this) != null) {
            EnvelopeAppBarLayout.i(EnvelopeAppBarLayout.this).setAlpha((float)(0.7D * f1));
          }
          this.Aze = i;
          this.EEC = j;
          AppMethodBeat.o(242089);
          return;
          k = paramAnonymousAppBarLayout.getTotalScrollRange();
          int m = EnvelopeAppBarLayout.l(EnvelopeAppBarLayout.this);
          int n = EnvelopeAppBarLayout.o(EnvelopeAppBarLayout.this);
          float f3 = (i - EnvelopeAppBarLayout.o(EnvelopeAppBarLayout.this)) / ((k - m - n) * 1.0F);
          EnvelopeAppBarLayout.q(EnvelopeAppBarLayout.this).setAlpha(f3);
          break;
          label463:
          if (EnvelopeAppBarLayout.this.EDT != 1) {
            break label328;
          }
          paramAnonymousInt = paramAnonymousAppBarLayout.getTotalScrollRange() - i;
          Log.d("MicroMsg.EnvelopeAppBarLayout", "distance: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt <= EnvelopeAppBarLayout.l(EnvelopeAppBarLayout.this))
          {
            f2 = paramAnonymousInt / (EnvelopeAppBarLayout.l(EnvelopeAppBarLayout.this) * 1.0F);
            EnvelopeAppBarLayout.u(EnvelopeAppBarLayout.this).setAlpha(f2);
            break label328;
          }
          EnvelopeAppBarLayout.u(EnvelopeAppBarLayout.this).setAlpha(1.0F);
          break label328;
          label555:
          if ((i == 0) && (this.Aze != i)) {
            EnvelopeAppBarLayout.w(EnvelopeAppBarLayout.this);
          } else if ((paramAnonymousAppBarLayout.getTotalScrollRange() - i == com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 300)) && (this.Aze != i)) {
            EnvelopeAppBarLayout.x(EnvelopeAppBarLayout.this);
          }
        }
      }
    };
    a(this.EEb);
    AppMethodBeat.o(163596);
  }
  
  private void Bl(int paramInt)
  {
    AppMethodBeat.i(163607);
    this.EDT = paramInt;
    switch (this.EDT)
    {
    default: 
      AppMethodBeat.o(163607);
      return;
    case 0: 
      this.EDU = true;
      this.EDV = true;
      this.EDj.setVisibility(8);
      this.EDx.setVisibility(8);
      if (ar.isDarkMode())
      {
        this.EDw.setImageResource(a.h.icons_filled_detail_skin_hb_mask_dark);
        AppMethodBeat.o(163607);
        return;
      }
      this.EDw.setImageResource(a.h.icons_filled_detail_skin_hb_mask);
      AppMethodBeat.o(163607);
      return;
    case 1: 
      this.EDU = true;
      this.EDV = true;
      this.EDj.setVisibility(0);
      this.EDv.setVisibility(8);
      this.EDj.setPadding(com.tencent.mm.ci.a.fromDPToPix(getContext(), 12), com.tencent.mm.ci.a.fromDPToPix(getContext(), 8), com.tencent.mm.ci.a.fromDPToPix(getContext(), 12), com.tencent.mm.ci.a.fromDPToPix(getContext(), 4));
      this.EDf.setVisibility(0);
      this.EDx.setVisibility(8);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.bottomMargin = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 15);
      this.EDt.setLayoutParams(localLayoutParams);
      if (ar.isDarkMode())
      {
        this.EDw.setImageResource(a.h.icons_filled_detail_skin_hb_mask_dark);
        AppMethodBeat.o(163607);
        return;
      }
      this.EDw.setImageResource(a.h.icons_filled_detail_skin_hb_mask);
      AppMethodBeat.o(163607);
      return;
    }
    this.EDU = false;
    this.EDV = false;
    this.EDj.setVisibility(0);
    this.EDv.setVisibility(0);
    this.EDj.setPadding(com.tencent.mm.ci.a.fromDPToPix(getContext(), 12), com.tencent.mm.ci.a.fromDPToPix(getContext(), 4), com.tencent.mm.ci.a.fromDPToPix(getContext(), 12), com.tencent.mm.ci.a.fromDPToPix(getContext(), 4));
    this.EDx.setVisibility(0);
    this.EDx.setAlpha(0.0F);
    if (ar.isDarkMode()) {
      this.EDw.setImageResource(a.h.icons_filled_detail_skin_hb_mask_dark);
    }
    for (;;)
    {
      com.tencent.mm.plugin.luckymoney.a.c.bz(4, this.EDR);
      break;
      this.EDw.setImageResource(a.h.icons_filled_detail_skin_hb_mask);
    }
  }
  
  private void b(com.tencent.mm.view.recyclerview.i parami, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(276738);
    b localb = (b)parami.YSz;
    localb.ePk();
    String str;
    if (EnvelopeStoryVideoManager.bB(localb.EEK, localb.EEM)) {
      str = localb.EEM;
    }
    for (boolean bool = true;; bool = false)
    {
      this.EDO.a(getContext(), (FrameLayout)parami.RD(a.f.lucky_money_detail_story_item_video_container), (ImageView)parami.RD(a.f.lucky_money_detail_story_item_image_iv), (ProgressBar)parami.RD(a.f.lucky_money_detail_story_item_loading_pb), str, localb.videoWidth, localb.videoHeight, paramInt, true, bool, paramBoolean);
      AppMethodBeat.o(276738);
      return;
      str = localb.EEJ.Uqm;
    }
  }
  
  private void ePe()
  {
    AppMethodBeat.i(163599);
    this.EDj.setOnClickListener(this.EEu);
    this.EDf.setOnClickListener(this.EEu);
    AppMethodBeat.o(163599);
  }
  
  private void ePf()
  {
    AppMethodBeat.i(163600);
    Object localObject = new Rect();
    getWindowVisibleDisplayFrame((Rect)localObject);
    this.EDF = (((Rect)localObject).right - ((Rect)localObject).left);
    this.EDG = ((int)(this.EDF * 1.335F));
    this.EDf.setMinimumHeight(this.EDG);
    localObject = new AppBarLayout.LayoutParams(this.EDG);
    ((AppBarLayout.LayoutParams)localObject).bvd = 3;
    this.EDe.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.EDe.setMinimumHeight(this.EDJ);
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(174331);
        EnvelopeAppBarLayout.e(EnvelopeAppBarLayout.this).fT(-(EnvelopeAppBarLayout.this.getTotalScrollRange() - EnvelopeAppBarLayout.l(EnvelopeAppBarLayout.this)));
        EnvelopeAppBarLayout.u(EnvelopeAppBarLayout.this).setAlpha(1.0F);
        AppMethodBeat.o(174331);
      }
    }, 50L);
    AppMethodBeat.o(163600);
  }
  
  private boolean ePg()
  {
    AppMethodBeat.i(163601);
    com.tencent.mm.view.recyclerview.i locali = (com.tencent.mm.view.recyclerview.i)this.EDg.cK(this.aiM);
    if (locali == null)
    {
      AppMethodBeat.o(163601);
      return false;
    }
    if (((b)locali.YSz).EEJ.Uql == 2)
    {
      AppMethodBeat.o(163601);
      return true;
    }
    AppMethodBeat.o(163601);
    return false;
  }
  
  private static boolean ePh()
  {
    AppMethodBeat.i(276748);
    com.tencent.mm.util.i locali = com.tencent.mm.util.i.YyX;
    int i = com.tencent.mm.util.i.a(b.a.Yyx, 0);
    if (i == 1)
    {
      AppMethodBeat.o(276748);
      return true;
    }
    if (i == 2)
    {
      AppMethodBeat.o(276748);
      return false;
    }
    if (((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VtQ, Integer.valueOf(0))).intValue() == 0)
    {
      AppMethodBeat.o(276748);
      return true;
    }
    AppMethodBeat.o(276748);
    return false;
  }
  
  private void ePi()
  {
    AppMethodBeat.i(276750);
    if ((!this.EEs) || (!this.EEt))
    {
      Log.i("MicroMsg.EnvelopeAppBarLayout", "not run this time");
      AppMethodBeat.o(276750);
      return;
    }
    if (!ePh())
    {
      Log.i("MicroMsg.EnvelopeAppBarLayout", "disable auto play");
      AppMethodBeat.o(276750);
      return;
    }
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(278198);
        if ((EnvelopeAppBarLayout.this.EDT == 2) && (EnvelopeAppBarLayout.D(EnvelopeAppBarLayout.this)))
        {
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, ObjectAnimator.ofFloat(EnvelopeAppBarLayout.q(EnvelopeAppBarLayout.this), "alpha", new float[] { EnvelopeAppBarLayout.q(EnvelopeAppBarLayout.this).getAlpha(), 0.0F }));
          EnvelopeAppBarLayout.H(EnvelopeAppBarLayout.this).setDuration(500L);
          int i = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VtR, Integer.valueOf(1500))).intValue();
          EnvelopeAppBarLayout.H(EnvelopeAppBarLayout.this).setStartDelay(i);
          EnvelopeAppBarLayout.H(EnvelopeAppBarLayout.this).start();
          EnvelopeAppBarLayout.H(EnvelopeAppBarLayout.this).addListener(new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(267021);
              Log.d("MicroMsg.EnvelopeAppBarLayout", "has animator end");
              AppMethodBeat.o(267021);
            }
            
            public final void onAnimationRepeat(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationStart(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(267020);
              Log.d("MicroMsg.EnvelopeAppBarLayout", "start fade animator");
              if (!EnvelopeAppBarLayout.H(EnvelopeAppBarLayout.this).isRunning())
              {
                AppMethodBeat.o(267020);
                return;
              }
              EnvelopeAppBarLayout.I(EnvelopeAppBarLayout.this);
              AppMethodBeat.o(267020);
            }
          });
          int j = i - 300;
          i = j;
          if (j < 0) {
            i = 0;
          }
          EnvelopeAppBarLayout.this.postDelayed(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(273953);
              if (EnvelopeAppBarLayout.D(EnvelopeAppBarLayout.this))
              {
                com.tencent.mm.view.recyclerview.i locali = (com.tencent.mm.view.recyclerview.i)EnvelopeAppBarLayout.s(EnvelopeAppBarLayout.this).cK(EnvelopeAppBarLayout.C(EnvelopeAppBarLayout.this));
                if (locali != null) {
                  EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, locali, EnvelopeAppBarLayout.C(EnvelopeAppBarLayout.this));
                }
              }
              AppMethodBeat.o(273953);
            }
          }, i);
        }
        AppMethodBeat.o(278198);
      }
    });
    AppMethodBeat.o(276750);
  }
  
  private void ePj()
  {
    AppMethodBeat.i(276751);
    if ((this.EDD != null) && (this.EDD.isStarted())) {
      this.EDD.cancel();
    }
    AppMethodBeat.o(276751);
  }
  
  public final void a(dvl paramdvl, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(276745);
    if (Util.isNullOrNil(this.EDR))
    {
      Bl(0);
      this.EDG = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 502);
      paramdvl = new AppBarLayout.LayoutParams(this.EDG);
      paramdvl.bvd = 3;
      this.EDe.setMinimumHeight(this.EDJ);
      this.EDe.setLayoutParams(paramdvl);
    }
    for (;;)
    {
      Log.i("MicroMsg.EnvelopeAppBarLayout", "set envelope story: %s", new Object[] { Integer.valueOf(this.EDT) });
      AppMethodBeat.o(276745);
      return;
      if (paramdvl != null) {
        break;
      }
      Bl(1);
      ePf();
      this.EDq.setText(paramString2);
      a.EFz = paramString2;
    }
    this.EDP = paramdvl;
    this.EDQ = paramString1;
    this.isPreview = paramBoolean;
    this.EDm.setText(this.EDP.description);
    this.EDo.setText(this.EDP.Ubp);
    this.EDq.setText(this.EDP.title);
    a.EFz = this.EDP.Ubp;
    if (paramdvl.Ubs != null) {
      paramInt = paramdvl.Ubs.llL;
    }
    if (paramInt == 2)
    {
      this.EDr.setVisibility(0);
      this.EDp.setVisibility(0);
      if (this.EDP.tpK != 1) {
        break label544;
      }
      if (!this.EEj)
      {
        com.tencent.mm.plugin.luckymoney.a.c.bz(8, this.EDR);
        this.EEj = true;
      }
      this.EDy.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(273429);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          Log.d("MicroMsg.EnvelopeAppBarLayout", "go to h5");
          if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
          {
            g.bA(EnvelopeAppBarLayout.this.getContext(), EnvelopeAppBarLayout.G(EnvelopeAppBarLayout.this).EyH);
            d.Bv(7);
            com.tencent.mm.plugin.luckymoney.a.c.bz(9, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
            b.EFJ += 1;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(273429);
        }
      });
      this.EDs.setText(a.i.app_learn_more);
      label291:
      if (!Util.isNullOrNil(this.EDP.Ubt)) {
        this.EDs.setText(this.EDP.Ubt);
      }
      if (Util.isNullOrNil(paramdvl.llI)) {
        break label887;
      }
      ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.EDn, paramdvl.llI, paramdvl.llJ, paramString1);
      this.EDn.setVisibility(0);
      label363:
      this.EDN.clear();
      if (paramdvl.Ubq.isEmpty()) {
        break label1665;
      }
      b.EFH = 1;
      a.EFA = 2;
      paramInt = 0;
      label391:
      if (paramInt >= paramdvl.Ubq.size()) {
        break label912;
      }
      paramString1 = (eno)paramdvl.Ubq.get(paramInt);
      paramString2 = new b();
      paramString2.EEJ = paramString1;
      paramString2.EEL = paramInt;
      paramString2.EEK = paramdvl.Tkq;
      String str = com.tencent.mm.plugin.luckymoney.model.t.hY(paramString2.EEK, paramString2.EEL);
      if ((paramString2.EEK > 0) && (u.agG(str)))
      {
        Log.i("MicroMsg.EnvelopeAppBarLayout", "[static luckymoney resource] has local video,add path");
        paramString2.EEM = str;
      }
      this.EDN.add(paramString2);
      if (paramString1.Uql != 2) {
        break label899;
      }
      this.xzT += 1;
    }
    for (;;)
    {
      paramInt += 1;
      break label391;
      this.EDr.setVisibility(8);
      this.EDp.setVisibility(8);
      break;
      label544:
      if (this.EDP.tpK == 2)
      {
        if (Util.isNullOrNil(this.EDP.EyI)) {
          break label291;
        }
        if (!this.EEk)
        {
          com.tencent.mm.plugin.luckymoney.a.c.bz(11, this.EDR);
          this.EEk = true;
        }
        g.bi(this.EDy, 100);
        b.EFI = 1;
        this.EDy.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(265057);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            Log.d("MicroMsg.EnvelopeAppBarLayout", "go to profile");
            if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
            {
              g.cW(EnvelopeAppBarLayout.this.getContext(), EnvelopeAppBarLayout.G(EnvelopeAppBarLayout.this).EyI);
              d.Bv(7);
              com.tencent.mm.plugin.luckymoney.a.c.bz(13, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
              b.EFJ += 1;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(265057);
          }
        });
        this.EDs.setText(a.i.lucky_money_envelope_story_enter_biz_profile_text);
        break label291;
      }
      if (this.EDP.tpK == 3)
      {
        if (!this.EEl)
        {
          com.tencent.mm.plugin.luckymoney.a.c.bz(12, this.EDR);
          this.EEl = true;
        }
        this.EDy.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(275502);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            Log.d("MicroMsg.EnvelopeAppBarLayout", "go to mini app");
            if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
            {
              g.v(EnvelopeAppBarLayout.G(EnvelopeAppBarLayout.this).EyI, EnvelopeAppBarLayout.G(EnvelopeAppBarLayout.this).EyH, 0, 1100);
              d.Bv(7);
              com.tencent.mm.plugin.luckymoney.a.c.bz(14, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
              b.EFJ += 1;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(275502);
          }
        });
        this.EDs.setText(a.i.lucky_money_envelope_story_enter_miniapp_text);
        break label291;
      }
      if (this.EDP.tpK == 4)
      {
        if (!this.EEo)
        {
          com.tencent.mm.plugin.luckymoney.a.c.bz(19, this.EDR);
          this.EEo = true;
        }
        this.EDy.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(264550);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            Log.d("MicroMsg.EnvelopeAppBarLayout", "go to mini app");
            if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
            {
              paramAnonymousView = new Intent();
              ((ak)com.tencent.mm.kernel.h.ag(ak.class)).fillContextIdToIntent(10, 2, 32, paramAnonymousView);
              paramAnonymousView.putExtra("finder_username", EnvelopeAppBarLayout.G(EnvelopeAppBarLayout.this).EyI);
              ((ak)com.tencent.mm.kernel.h.ag(ak.class)).enterFinderProfileUI(EnvelopeAppBarLayout.this.EDC, paramAnonymousView);
              d.Bv(7);
              com.tencent.mm.plugin.luckymoney.a.c.bz(19, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
              b.EFJ += 1;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$15", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(264550);
          }
        });
        this.EDs.setText(a.i.lucky_money_envelope_story_enter_finder_text);
        break label291;
      }
      if (this.EDP.tpK == 5)
      {
        if (!this.EEn)
        {
          com.tencent.mm.plugin.luckymoney.a.c.bz(17, this.EDR);
          this.EEn = true;
        }
        this.EDy.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(277681);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("uin", EnvelopeAppBarLayout.G(EnvelopeAppBarLayout.this).Ubu);
            paramAnonymousView.putExtra("name", EnvelopeAppBarLayout.G(EnvelopeAppBarLayout.this).EyI);
            paramAnonymousView.putExtra("headurl", EnvelopeAppBarLayout.G(EnvelopeAppBarLayout.this).EyH);
            paramAnonymousView.putExtra("extra_scence", 30);
            com.tencent.mm.by.c.b(EnvelopeAppBarLayout.this.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", paramAnonymousView);
            d.Bv(7);
            com.tencent.mm.plugin.luckymoney.a.c.bz(18, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
            b.EFJ += 1;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(277681);
          }
        });
        this.EDs.setText(a.i.lucky_money_envelope_story_enter_emoji_designer_text);
        break label291;
      }
      if (this.EDP.tpK == 6)
      {
        if (!this.EEm)
        {
          com.tencent.mm.plugin.luckymoney.a.c.bz(15, this.EDR);
          this.EEm = true;
        }
        this.EDy.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(265581);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("extra_id", EnvelopeAppBarLayout.G(EnvelopeAppBarLayout.this).EyI);
            paramAnonymousView.putExtra("preceding_scence", 21);
            com.tencent.mm.by.c.b(EnvelopeAppBarLayout.this.getContext(), "emoji", ".ui.EmojiStoreDetailUI", paramAnonymousView);
            d.Bv(7);
            com.tencent.mm.plugin.luckymoney.a.c.bz(16, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
            b.EFJ += 1;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(265581);
          }
        });
        this.EDs.setText(a.i.lucky_money_envelope_story_enter_emoji_album_text);
        break label291;
      }
      this.EDy.setVisibility(8);
      b.EFI = 0;
      break label291;
      label887:
      this.EDn.setVisibility(8);
      break label363;
      label899:
      this.EEh += 1;
    }
    label912:
    this.EDl.setCount(this.EDN.size());
    Bl(2);
    paramdvl = new Rect();
    getWindowVisibleDisplayFrame(paramdvl);
    this.EDF = (paramdvl.right - paramdvl.left);
    this.EDG = ((int)(this.EDF * 1.667F));
    paramInt = (int)(this.EDF * 1.335F);
    this.EDH = (this.EDG - paramInt);
    this.EDf.setMinimumHeight(paramInt);
    paramdvl = new AppBarLayout.LayoutParams(this.EDG);
    paramdvl.bvd = 3;
    this.EDe.setLayoutParams(paramdvl);
    this.EDK = ((int)(this.EDF * 1.0F));
    this.EDe.setMinimumHeight(this.EDJ);
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163580);
        EnvelopeAppBarLayout.e(EnvelopeAppBarLayout.this).fT(-(EnvelopeAppBarLayout.this.getTotalScrollRange() - EnvelopeAppBarLayout.l(EnvelopeAppBarLayout.this)));
        EnvelopeAppBarLayout.u(EnvelopeAppBarLayout.this).setAlpha(1.0F);
        EnvelopeAppBarLayout.x(EnvelopeAppBarLayout.this);
        AppMethodBeat.o(163580);
      }
    }, 50L);
    label1097:
    int i;
    if (this.isPreview)
    {
      paramInt = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VtP, Integer.valueOf(0))).intValue();
      Log.i("MicroMsg.EnvelopeAppBarLayout", "show first guide: %s", new Object[] { Integer.valueOf(paramInt) });
      paramdvl = com.tencent.mm.util.i.YyX;
      i = com.tencent.mm.util.i.a(b.a.Yyw, 0);
      if (i != 1) {
        break label1575;
      }
      paramInt = 1;
      label1140:
      if (paramInt == 0) {
        break label1653;
      }
      this.EEp = true;
      this.EDA = ((ViewGroup)findViewById(a.f.lucky_money_detail_story_guide_layout));
      this.EDA.setVisibility(0);
      this.EDj.setVisibility(4);
      this.EDX = new ValueAnimator();
      this.EDX.setDuration(700L);
      this.EDX.setInterpolator(new AccelerateDecelerateInterpolator());
      this.EDX.setIntValues(new int[] { 0, this.EDI });
      this.EDY = new ObjectAnimator();
      this.EDY.setPropertyName("alpha");
      this.EDY.setFloatValues(new float[] { 1.0F, 0.0F });
      this.EDY.setTarget(this.EDA);
      this.EDY.setDuration(300L);
      this.EDY.setStartDelay(200L);
      this.EDY.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(197349);
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, true);
          AppMethodBeat.o(197349);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(163586);
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, false);
          EnvelopeAppBarLayout.u(EnvelopeAppBarLayout.this).setVisibility(0);
          EnvelopeAppBarLayout.u(EnvelopeAppBarLayout.this).setAlpha(0.0F);
          AppMethodBeat.o(163586);
        }
      });
      this.EDZ = new ValueAnimator();
      this.EDZ.setInterpolator(com.google.android.material.a.a.buq);
      this.EDZ.setStartDelay(200L);
      this.EDZ.setDuration(300L);
      this.EDZ.setIntValues(new int[] { this.EDI, 0 });
      paramdvl = new ValueAnimator.AnimatorUpdateListener()
      {
        int EED = 0;
        
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(163587);
          Log.d("MicroMsg.EnvelopeAppBarLayout", "animate value: " + paramAnonymousValueAnimator.getAnimatedValue());
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          int j = i - this.EED;
          this.EED = i;
          float f = (EnvelopeAppBarLayout.y(EnvelopeAppBarLayout.this) - i) / (EnvelopeAppBarLayout.y(EnvelopeAppBarLayout.this) * 1.0F);
          if (EnvelopeAppBarLayout.this.EDT == 2) {
            EnvelopeAppBarLayout.q(EnvelopeAppBarLayout.this).setAlpha(f);
          }
          EnvelopeAppBarLayout.this.offsetTopAndBottom(j);
          if (j > 0)
          {
            EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).offsetTopAndBottom((int)(j * 0.123F));
            AppMethodBeat.o(163587);
            return;
          }
          EnvelopeAppBarLayout.u(EnvelopeAppBarLayout.this).setAlpha(f);
          AppMethodBeat.o(163587);
        }
      };
      this.EDX.addUpdateListener(paramdvl);
      this.EDZ.addUpdateListener(paramdvl);
      this.EEa = new AnimatorSet();
      this.EEa.playSequentially(new Animator[] { this.EDX, this.EDY, this.EDZ });
      this.EEa.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(163588);
          EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this).setVisibility(8);
          if (EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this) != null) {
            EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this).EFL = false;
          }
          EnvelopeAppBarLayout.A(EnvelopeAppBarLayout.this);
          EnvelopeAppBarLayout.B(EnvelopeAppBarLayout.this);
          AppMethodBeat.o(163588);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(266747);
          if (EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this) != null) {
            EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this).EFL = true;
          }
          EnvelopeAppBarLayout.J(EnvelopeAppBarLayout.this).setStartDelay(700L);
          EnvelopeAppBarLayout.J(EnvelopeAppBarLayout.this).start();
          AppMethodBeat.o(266747);
        }
      });
      if (!this.isPreview) {
        break label1607;
      }
      paramInt = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VtP, Integer.valueOf(0))).intValue();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VtP, Integer.valueOf(paramInt + 1));
    }
    for (;;)
    {
      this.EDg.getAdapter().alc.notifyChanged();
      break;
      paramInt = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VtO, Integer.valueOf(0))).intValue();
      break label1097;
      label1575:
      if ((i != 2) && (paramInt < 3) && (this.EDT == 2))
      {
        paramInt = 1;
        break label1140;
      }
      paramInt = 0;
      break label1140;
      label1607:
      paramInt = ((Integer)com.tencent.mm.kernel.h.aHG().aHp().get(ar.a.VtO, Integer.valueOf(0))).intValue();
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VtO, Integer.valueOf(paramInt + 1));
      continue;
      label1653:
      this.EEt = true;
      ePi();
      continue;
      label1665:
      Bl(1);
      ePf();
    }
  }
  
  public final void ah(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(276752);
    if ((Util.isNullOrNil(this.EDR)) && (!Util.isNullOrNil(paramString1)))
    {
      this.EDR = paramString1;
      this.EDS = paramString2;
      this.EDB.setVisibility(0);
      ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.EDf, this.EDR, this.EDS, this.EDQ, this.EDG, this.EDF, 0, new a.a()
      {
        public final void eG(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(186763);
          if (paramAnonymousBoolean)
          {
            EnvelopeAppBarLayout.K(EnvelopeAppBarLayout.this).setVisibility(8);
            EnvelopeAppBarLayout.L(EnvelopeAppBarLayout.this);
            EnvelopeAppBarLayout.B(EnvelopeAppBarLayout.this);
          }
          AppMethodBeat.o(186763);
        }
      }, paramInt, 2, 0);
    }
    AppMethodBeat.o(276752);
  }
  
  public final void ePd()
  {
    int j = 0;
    AppMethodBeat.i(182455);
    Object localObject1;
    Object localObject2;
    int i;
    if (this.aiM >= 0)
    {
      if (Util.isNullOrNil(b.sessionId))
      {
        AppMethodBeat.o(182455);
        return;
      }
      localObject1 = (com.tencent.mm.view.recyclerview.i)this.EDg.cK(this.aiM);
      if (localObject1 != null)
      {
        boolean bool = ePg();
        localObject2 = (b)((com.tencent.mm.view.recyclerview.i)localObject1).YSz;
        if (bool)
        {
          localObject1 = this.EDO;
          i = this.aiM;
          localObject1 = (EnvelopeStoryVideoManager.c)((EnvelopeStoryVideoManager)localObject1).EEZ.get(Integer.valueOf(i));
          if (localObject1 == null)
          {
            AppMethodBeat.o(182455);
            return;
          }
          ((EnvelopeStoryVideoManager.c)localObject1).EFp = ((EnvelopeStoryVideoManager.c)localObject1).EFr.getCurrPosSec();
          if (((EnvelopeStoryVideoManager.c)localObject1).EFq.get() == 1) {
            i = (int)(((EnvelopeStoryVideoManager.c)localObject1).EFp - ((EnvelopeStoryVideoManager.c)localObject1).EFo);
          }
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.IzE;
      String str1 = this.EDQ;
      AtomicInteger localAtomicInteger = ((EnvelopeStoryVideoManager.c)localObject1).EFq;
      localObject2 = ((b)localObject2).EEJ.Uqm;
      String str2 = b.sessionId;
      if (((EnvelopeStoryVideoManager.c)localObject1).isPreview) {
        j = 1;
      }
      localh.a(19270, new Object[] { Integer.valueOf(2), str1, localAtomicInteger, "", localObject2, Integer.valueOf(i), str2, Integer.valueOf(j), com.tencent.mm.plugin.luckymoney.a.c.openId });
      AppMethodBeat.o(182455);
      return;
      if (((EnvelopeStoryVideoManager.c)localObject1).EFq.get() > 1)
      {
        i = ((EnvelopeStoryVideoManager.c)localObject1).EFq.get();
        i = (int)(((EnvelopeStoryVideoManager.c)localObject1).EFk - ((EnvelopeStoryVideoManager.c)localObject1).EFo + ((EnvelopeStoryVideoManager.c)localObject1).EFp + (i - 1) * ((EnvelopeStoryVideoManager.c)localObject1).EFk);
        continue;
        com.tencent.mm.plugin.report.service.h.IzE.a(19270, new Object[] { Integer.valueOf(1), this.EDQ, Integer.valueOf(0), ((b)localObject2).EEJ.Uqm, "", Integer.valueOf(0), b.sessionId, Integer.valueOf(0), com.tencent.mm.plugin.luckymoney.a.c.openId });
        AppMethodBeat.o(182455);
      }
      else
      {
        i = 0;
      }
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(163606);
    super.onFinishInflate();
    AppMethodBeat.o(163606);
  }
  
  @androidx.lifecycle.t(jl=h.a.ON_DESTROY)
  public void onUIDestroy()
  {
    AppMethodBeat.i(163604);
    ePd();
    this.EDO.ePr();
    if ((this.EDT == 1) || (this.EDT == 2)) {
      b.Bv(3);
    }
    d.Bv(11);
    ePj();
    AppMethodBeat.o(163604);
  }
  
  @androidx.lifecycle.t(jl=h.a.ON_PAUSE)
  public void onUIPause() {}
  
  public void setActivityLifeCycle(LuckyMoneyDetailUI paramLuckyMoneyDetailUI)
  {
    AppMethodBeat.i(276739);
    paramLuckyMoneyDetailUI.getLifecycle().a(this.EDO);
    paramLuckyMoneyDetailUI.getLifecycle().a(this);
    this.EDC = paramLuckyMoneyDetailUI;
    EnvelopeStoryVideoManager localEnvelopeStoryVideoManager = this.EDO;
    localEnvelopeStoryVideoManager.tnf = paramLuckyMoneyDetailUI;
    MMHandlerThread.postToMainThread(new EnvelopeStoryVideoManager.1(localEnvelopeStoryVideoManager));
    AppMethodBeat.o(276739);
  }
  
  final class a
    extends e<EnvelopeAppBarLayout.b>
  {
    a() {}
    
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt) {}
    
    public final int getLayoutId()
    {
      return a.g.lucky_money_detail_story_item;
    }
  }
  
  final class b
    implements com.tencent.mm.view.recyclerview.a
  {
    public eno EEJ;
    public int EEK = -1;
    public int EEL = -1;
    public String EEM = "";
    public int videoHeight = -1;
    public int videoWidth = -1;
    
    b() {}
    
    public final int bAQ()
    {
      return 0;
    }
    
    public final void ePk()
    {
      AppMethodBeat.i(163594);
      if ((this.videoHeight > 0) && (this.videoWidth > 0))
      {
        AppMethodBeat.o(163594);
        return;
      }
      float f = this.EEJ.height / (this.EEJ.width * 1.0F);
      if (f > 1.667F)
      {
        this.videoHeight = EnvelopeAppBarLayout.N(EnvelopeAppBarLayout.this);
        this.videoWidth = ((int)(EnvelopeAppBarLayout.N(EnvelopeAppBarLayout.this) / f));
      }
      for (;;)
      {
        Log.d("MicroMsg.EnvelopeAppBarLayout", "video size: %s, %s", new Object[] { Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight) });
        AppMethodBeat.o(163594);
        return;
        if (f < 1.667F)
        {
          this.videoWidth = EnvelopeAppBarLayout.O(EnvelopeAppBarLayout.this);
          this.videoHeight = ((int)(f * EnvelopeAppBarLayout.O(EnvelopeAppBarLayout.this)));
        }
        else
        {
          this.videoHeight = EnvelopeAppBarLayout.N(EnvelopeAppBarLayout.this);
          this.videoWidth = EnvelopeAppBarLayout.O(EnvelopeAppBarLayout.this);
        }
      }
    }
    
    public final long mf()
    {
      return 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout
 * JD-Core Version:    0.7.0.1
 */