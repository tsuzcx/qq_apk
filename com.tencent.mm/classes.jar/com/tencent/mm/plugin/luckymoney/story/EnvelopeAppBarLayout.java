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
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.net.Uri.Builder;
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
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout.LayoutParams;
import com.google.android.material.appbar.AppBarLayout.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.h.a;
import com.tencent.mm.plugin.luckymoney.a.a.a;
import com.tencent.mm.plugin.luckymoney.model.LuckyMoneyEnvelopeResUpdateListener;
import com.tencent.mm.plugin.luckymoney.ui.HorizontalLayoutManager;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.protocal.protobuf.eof;
import com.tencent.mm.protocal.protobuf.eoh;
import com.tencent.mm.protocal.protobuf.fim;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.RoundCornerImageView;
import com.tencent.mm.util.b.a;
import com.tencent.mm.vfs.y;
import com.tencent.mm.view.MediaBannerIndicator;
import com.tencent.mm.view.RecyclerHorizontalViewPager;
import com.tencent.mm.view.RecyclerHorizontalViewPager.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class EnvelopeAppBarLayout
  extends AppBarLayout
  implements p
{
  private int AXs;
  private boolean EFw;
  private ImageView KwA;
  private ImageView KwB;
  private ViewGroup KwC;
  private ViewGroup KwD;
  private ViewGroup KwE;
  private ProgressBar KwF;
  public LuckyMoneyDetailUI KwG;
  private ObjectAnimator KwH;
  private boolean KwI;
  private int KwJ;
  private int KwK;
  private int KwL;
  private int KwM;
  private int KwN;
  private int KwO;
  private int KwP;
  private EnvelopeStoryBehavior KwQ;
  private ArrayList<b> KwR;
  private EnvelopeStoryVideoManager KwS;
  private eoh KwT;
  private String KwU;
  private String KwV;
  private String KwW;
  public int KwX;
  private boolean KwY;
  public boolean KwZ;
  private View Kwi;
  private ImageView Kwj;
  private RecyclerHorizontalViewPager Kwk;
  private RecyclerView Kwl;
  private TouchCoordinatorLayout Kwm;
  private ViewGroup Kwn;
  private ViewGroup Kwo;
  private MediaBannerIndicator Kwp;
  private TextView Kwq;
  private RoundCornerImageView Kwr;
  private TextView Kws;
  private TextView Kwt;
  private TextView Kwu;
  private TextView Kwv;
  private TextView Kww;
  private ViewGroup Kwx;
  private View Kwy;
  private ImageView Kwz;
  private boolean Kxa;
  private ValueAnimator Kxb;
  private ObjectAnimator Kxc;
  private ValueAnimator Kxd;
  private AnimatorSet Kxe;
  private AppBarLayout.b Kxf;
  private final float Kxg;
  private final float Kxh;
  private final float Kxi;
  private boolean Kxj;
  private boolean Kxk;
  private int Kxl;
  private boolean Kxm;
  private boolean Kxn;
  private boolean Kxo;
  private boolean Kxp;
  private boolean Kxq;
  private boolean Kxr;
  private boolean Kxs;
  private boolean Kxt;
  private boolean Kxu;
  private boolean Kxv;
  private boolean Kxw;
  private boolean Kxx;
  private View.OnClickListener Kxy;
  private int Kxz;
  private int bXr;
  private boolean isPreview;
  
  public EnvelopeAppBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(163596);
    this.KwI = false;
    this.KwM = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 130);
    this.KwN = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 120);
    this.KwO = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 420);
    this.KwP = (this.KwO - this.KwN);
    this.bXr = 0;
    this.KwR = new ArrayList();
    this.KwY = true;
    this.KwZ = false;
    this.Kxa = false;
    this.Kxg = 1.335F;
    this.Kxh = 1.0F;
    this.Kxi = 0.6F;
    this.Kxj = false;
    this.Kxk = false;
    this.Kxm = false;
    this.Kxn = false;
    this.Kxo = false;
    this.Kxp = false;
    this.Kxq = false;
    this.Kxr = false;
    this.Kxs = false;
    this.Kxt = false;
    this.Kxu = false;
    this.isPreview = false;
    this.EFw = false;
    this.Kxv = false;
    this.Kxy = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(163578);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((!EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this)) && (EnvelopeAppBarLayout.this.KwX == 2))
        {
          EnvelopeAppBarLayout.this.c(true, true, true);
          EnvelopeAppBarLayout.b(EnvelopeAppBarLayout.this);
          com.tencent.mm.plugin.luckymoney.a.d.BI(5);
          com.tencent.mm.plugin.luckymoney.a.c.cg(6, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(163578);
      }
    };
    this.Kxz = MMApplicationContext.getResources().getDimensionPixelSize(a.d.lucky_money_detail_story_logo_size);
    inflate(getContext(), a.g.lucky_money_detail_story_layout, this);
    setExpanded(false);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163584);
        Object localObject = (CoordinatorLayout.d)EnvelopeAppBarLayout.this.getLayoutParams();
        EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, (EnvelopeStoryBehavior)((CoordinatorLayout.d)localObject).bnr);
        EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this).KwZ = EnvelopeAppBarLayout.this.KwZ;
        localObject = EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this);
        if ((EnvelopeAppBarLayout.this.KwX == 1) || (EnvelopeAppBarLayout.this.KwX == 2)) {}
        for (boolean bool = true;; bool = false)
        {
          ((EnvelopeStoryBehavior)localObject).Kya = bool;
          EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this).Kyb = EnvelopeAppBarLayout.e(EnvelopeAppBarLayout.this);
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, (TouchCoordinatorLayout)EnvelopeAppBarLayout.this.getParent());
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).findViewById(a.f.lucky_money_detail_expand_white_cover));
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, (RecyclerView)EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).findViewById(a.f.lucky_money_detail_record_list));
          EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).a(new View.OnTouchListener()
          {
            long KxC;
            boolean KxD = false;
            float cxM;
            float cxN;
            
            public final boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
            {
              AppMethodBeat.i(163583);
              if (paramAnonymous2MotionEvent.getActionMasked() == 0) {
                EnvelopeAppBarLayout.g(EnvelopeAppBarLayout.this);
              }
              if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
              {
                if (paramAnonymous2MotionEvent.getActionMasked() != 0) {
                  break label125;
                }
                paramAnonymous2View = new Rect();
                EnvelopeAppBarLayout.h(EnvelopeAppBarLayout.this).getGlobalVisibleRect(paramAnonymous2View);
                if (!paramAnonymous2View.contains((int)paramAnonymous2MotionEvent.getRawX(), (int)paramAnonymous2MotionEvent.getRawY())) {
                  break label117;
                }
                this.cxM = paramAnonymous2MotionEvent.getRawX();
                this.cxN = paramAnonymous2MotionEvent.getRawY();
                this.KxC = Util.currentTicks();
                this.KxD = true;
              }
              for (;;)
              {
                AppMethodBeat.o(163583);
                return false;
                label117:
                this.KxD = false;
                continue;
                label125:
                if ((paramAnonymous2MotionEvent.getActionMasked() == 1) && (this.KxD) && (Util.ticksToNow(this.KxC) < 500L))
                {
                  paramAnonymous2View = new Rect();
                  EnvelopeAppBarLayout.h(EnvelopeAppBarLayout.this).getGlobalVisibleRect(paramAnonymous2View);
                  int i = (int)paramAnonymous2MotionEvent.getRawX();
                  int j = (int)paramAnonymous2MotionEvent.getRawY();
                  if ((Math.abs(i - this.cxM) <= 20.0F) && (Math.abs(j - this.cxN) <= 20.0F) && (paramAnonymous2View.contains(i, j)))
                  {
                    Log.i("MicroMsg.EnvelopeAppBarLayout", "click collapse view");
                    EnvelopeAppBarLayout.i(EnvelopeAppBarLayout.this);
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
          EnvelopeAppBarLayout.h(EnvelopeAppBarLayout.this).setOnTouchListener(new View.OnTouchListener()
          {
            public final boolean onTouch(View paramAnonymous2View, MotionEvent paramAnonymous2MotionEvent)
            {
              return false;
            }
          });
          EnvelopeAppBarLayout.j(EnvelopeAppBarLayout.this);
          AppMethodBeat.o(163584);
          return;
        }
      }
    });
    this.KwS = new EnvelopeStoryVideoManager();
    this.Kwi = findViewById(a.f.story_content_layout);
    this.Kwn = ((ViewGroup)findViewById(a.f.lucky_money_detail_story_collapse_layout));
    this.Kwo = ((ViewGroup)findViewById(a.f.lucky_money_detail_story_info_layout));
    this.Kwj = ((ImageView)findViewById(a.f.story_envelope_iv));
    this.KwF = ((ProgressBar)findViewById(a.f.story_envelope_loading_iv));
    this.Kwk = ((RecyclerHorizontalViewPager)findViewById(a.f.story_pager_view));
    this.Kwp = ((MediaBannerIndicator)findViewById(a.f.story_control_indicator));
    this.Kwq = ((TextView)findViewById(a.f.story_desc_tv));
    this.Kwr = ((RoundCornerImageView)findViewById(a.f.story_logo_iv));
    this.Kws = ((TextView)findViewById(a.f.story_username_tv));
    this.Kwt = ((TextView)findViewById(a.f.story_username_label_tv));
    this.KwC = ((ViewGroup)findViewById(a.f.story_profile_enter_layout));
    this.KwD = ((ViewGroup)findViewById(a.f.story_profile_layout));
    this.Kwu = ((TextView)findViewById(a.f.lucky_money_detail_story_collapse_title_tv));
    this.Kwv = ((TextView)findViewById(a.f.lucky_money_detail_story_collapse_title_label_tv));
    this.Kwx = ((ViewGroup)findViewById(a.f.lucky_money_detail_story_collapse_title_layout));
    this.Kww = ((TextView)findViewById(a.f.story_profile_enter_btn));
    this.Kwz = ((ImageView)findViewById(a.f.lucky_money_detail_story_collapse_down_btn));
    this.KwA = ((ImageView)findViewById(a.f.story_envelope_bottom_cover_iv));
    this.KwB = ((ImageView)findViewById(a.f.story_envelope_bottom_cover_shadow_iv));
    this.Kwr.shadowRadius = 4;
    this.Kwr.shadowColor = getResources().getColor(a.c.BW_100_Alpha_0_3);
    this.Kwp.setSelectDrawable(getResources().getDrawable(a.e.lucky_money_story_selected_radius));
    this.Kwp.setUnSelectDrawable(getResources().getDrawable(a.e.lucky_money_story_unselected_radius));
    this.Kwp.setIndicatorWidth(getResources().getDimensionPixelSize(a.d.Edge_A));
    getContext();
    paramContext = new HorizontalLayoutManager();
    this.Kwk.setHasFixedSize(true);
    this.Kwk.setItemViewCacheSize(4);
    paramAttributeSet = new com.tencent.mm.plugin.luckymoney.scaledLayout.a();
    paramAttributeSet.context = getContext();
    paramAttributeSet.Kvr = true;
    this.Kwk.setSnapHelper(paramAttributeSet);
    this.Kwk.setOnInterceptTouchEvent(new EnvelopeAppBarLayout.18(this, paramAttributeSet, paramContext));
    paramContext.xwJ = 1;
    paramContext.setItemPrefetchEnabled(true);
    paramContext.bXK = 3;
    paramContext.setOrientation(0);
    this.Kwk.setLayoutManager(paramContext);
    paramContext = new WxRecyclerAdapter(new g()
    {
      public final com.tencent.mm.view.recyclerview.f<?> yF(int paramAnonymousInt)
      {
        AppMethodBeat.i(163590);
        EnvelopeAppBarLayout.a locala = new EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this);
        AppMethodBeat.o(163590);
        return locala;
      }
    }, this.KwR, false);
    this.Kwk.setAdapter(paramContext);
    this.Kwk.setPageChangeListener(new RecyclerHorizontalViewPager.b()
    {
      public final void aE(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        boolean bool1 = true;
        AppMethodBeat.i(284019);
        Log.i("MicroMsg.EnvelopeAppBarLayout", "on page change: %s, %s", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        com.tencent.mm.view.recyclerview.j localj;
        boolean bool2;
        EnvelopeAppBarLayout.b localb;
        String str;
        if (paramAnonymousBoolean)
        {
          if (EnvelopeAppBarLayout.B(EnvelopeAppBarLayout.this) == paramAnonymousInt)
          {
            AppMethodBeat.o(284019);
            return;
          }
          EnvelopeAppBarLayout.this.fXH();
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, paramAnonymousInt);
          localj = (com.tencent.mm.view.recyclerview.j)EnvelopeAppBarLayout.r(EnvelopeAppBarLayout.this).fU(paramAnonymousInt);
          if (localj != null)
          {
            bool2 = EnvelopeAppBarLayout.C(EnvelopeAppBarLayout.this);
            localb = (EnvelopeAppBarLayout.b)localj.CSA;
            if (!bool2) {
              break label241;
            }
            localb.fXO();
            if (!EnvelopeStoryVideoManager.ci(localb.KxP, localb.KxR)) {
              break label252;
            }
            str = localb.KxR;
          }
        }
        for (paramAnonymousBoolean = bool1;; paramAnonymousBoolean = false)
        {
          EnvelopeAppBarLayout.D(EnvelopeAppBarLayout.this).a(EnvelopeAppBarLayout.this.getContext(), (FrameLayout)localj.UH(a.f.lucky_money_detail_story_item_video_container), (ImageView)localj.UH(a.f.lucky_money_detail_story_item_image_iv), (ProgressBar)localj.UH(a.f.lucky_money_detail_story_item_loading_pb), str, localb.videoWidth, localb.videoHeight, paramAnonymousInt, bool2, paramAnonymousBoolean, false);
          com.tencent.mm.plugin.luckymoney.a.d.BI(6);
          b.KyH += 1;
          EnvelopeAppBarLayout.E(EnvelopeAppBarLayout.this).setCurrentIndex(paramAnonymousInt);
          AppMethodBeat.o(284019);
          return;
          label241:
          b.KyK += 1;
          break;
          label252:
          str = localb.KxO.abJl;
        }
      }
    });
    this.Kxf = new AppBarLayout.b()
    {
      private int ESj = 0;
      private int KxG = 0;
      private float KxH = 0.0F;
      
      public final void onOffsetChanged(AppBarLayout paramAnonymousAppBarLayout, int paramAnonymousInt)
      {
        AppMethodBeat.i(284021);
        int i = Math.abs(paramAnonymousInt);
        int j = paramAnonymousAppBarLayout.getTotalScrollRange() - EnvelopeAppBarLayout.k(EnvelopeAppBarLayout.this) - i;
        float f1 = j / ((paramAnonymousAppBarLayout.getTotalScrollRange() - EnvelopeAppBarLayout.k(EnvelopeAppBarLayout.this)) * 1.0F);
        float f2 = 1.0F - f1;
        Log.d("MicroMsg.EnvelopeAppBarLayout", "offset: %s, distance: %s", new Object[] { Integer.valueOf(paramAnonymousInt), Integer.valueOf(j) });
        int k;
        if (!EnvelopeAppBarLayout.l(EnvelopeAppBarLayout.this))
        {
          EnvelopeAppBarLayout.m(EnvelopeAppBarLayout.this).setAlpha(1.0F - f2);
          if ((i <= EnvelopeAppBarLayout.n(EnvelopeAppBarLayout.this)) || (EnvelopeAppBarLayout.o(EnvelopeAppBarLayout.this)))
          {
            EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this).setAlpha(0.0F);
            EnvelopeAppBarLayout.q(EnvelopeAppBarLayout.this).setAlpha(1.0F - f2);
          }
        }
        else
        {
          Log.d("MicroMsg.EnvelopeAppBarLayout", "mHasTranslationPagerView: %s", new Object[] { Boolean.valueOf(EnvelopeAppBarLayout.o(EnvelopeAppBarLayout.this)) });
          if ((EnvelopeAppBarLayout.o(EnvelopeAppBarLayout.this)) && (j >= 0) && (j != this.KxG))
          {
            k = Math.max(0, this.KxG);
            EnvelopeAppBarLayout.r(EnvelopeAppBarLayout.this).setTranslationY(-paramAnonymousInt / 2.0F);
            Log.d("MicroMsg.EnvelopeAppBarLayout", "offset: %s, top: %s", new Object[] { Integer.valueOf(j - k), Float.valueOf(EnvelopeAppBarLayout.r(EnvelopeAppBarLayout.this).getTranslationY()) });
            if (EnvelopeAppBarLayout.r(EnvelopeAppBarLayout.this).getTranslationY() <= 0.0F)
            {
              EnvelopeAppBarLayout.r(EnvelopeAppBarLayout.this).setTranslationY(0.0F);
              EnvelopeAppBarLayout.s(EnvelopeAppBarLayout.this);
            }
          }
          if (EnvelopeAppBarLayout.t(EnvelopeAppBarLayout.this) != null)
          {
            if (EnvelopeAppBarLayout.this.KwX != 2) {
              break label610;
            }
            if ((paramAnonymousAppBarLayout.getTotalScrollRange() - i != 0) || (this.ESj == i)) {
              break label516;
            }
            EnvelopeAppBarLayout.t(EnvelopeAppBarLayout.this).setAlpha(0.0F);
            EnvelopeAppBarLayout.this.KwG.KBD.setAlpha(0.0F);
            EnvelopeAppBarLayout.this.KwG.KBE.setVisibility(8);
            label375:
            this.KxH = f2;
          }
          label381:
          if ((paramAnonymousAppBarLayout.getTotalScrollRange() - i != 0) || (this.ESj == i)) {
            break label702;
          }
          EnvelopeAppBarLayout.u(EnvelopeAppBarLayout.this);
        }
        for (;;)
        {
          if (EnvelopeAppBarLayout.h(EnvelopeAppBarLayout.this) != null) {
            EnvelopeAppBarLayout.h(EnvelopeAppBarLayout.this).setAlpha((float)(0.7D * f1));
          }
          this.ESj = i;
          this.KxG = j;
          AppMethodBeat.o(284021);
          return;
          k = paramAnonymousAppBarLayout.getTotalScrollRange();
          int m = EnvelopeAppBarLayout.k(EnvelopeAppBarLayout.this);
          int n = EnvelopeAppBarLayout.n(EnvelopeAppBarLayout.this);
          float f3 = (i - EnvelopeAppBarLayout.n(EnvelopeAppBarLayout.this)) / ((k - m - n) * 1.0F);
          EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this).setAlpha(f3);
          break;
          label516:
          if (this.KxH == f2) {
            break label375;
          }
          EnvelopeAppBarLayout.t(EnvelopeAppBarLayout.this).setAlpha(f2);
          EnvelopeAppBarLayout.this.KwG.KAV.setAlpha(f2);
          EnvelopeAppBarLayout.this.KwG.KBD.setAlpha(f2);
          if (f2 == 0.0F)
          {
            EnvelopeAppBarLayout.this.KwG.KBE.setVisibility(8);
            break label375;
          }
          EnvelopeAppBarLayout.this.KwG.KBE.setVisibility(0);
          break label375;
          label610:
          if (EnvelopeAppBarLayout.this.KwX != 1) {
            break label381;
          }
          paramAnonymousInt = paramAnonymousAppBarLayout.getTotalScrollRange() - i;
          Log.d("MicroMsg.EnvelopeAppBarLayout", "distance: %s", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt <= EnvelopeAppBarLayout.k(EnvelopeAppBarLayout.this))
          {
            f2 = paramAnonymousInt / (EnvelopeAppBarLayout.k(EnvelopeAppBarLayout.this) * 1.0F);
            EnvelopeAppBarLayout.t(EnvelopeAppBarLayout.this).setAlpha(f2);
            break label381;
          }
          EnvelopeAppBarLayout.t(EnvelopeAppBarLayout.this).setAlpha(1.0F);
          break label381;
          label702:
          if ((i == 0) && (this.ESj != i)) {
            EnvelopeAppBarLayout.v(EnvelopeAppBarLayout.this);
          } else if ((paramAnonymousAppBarLayout.getTotalScrollRange() - i == com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 300)) && (this.ESj != i)) {
            EnvelopeAppBarLayout.w(EnvelopeAppBarLayout.this);
          }
        }
      }
    };
    a(this.Kxf);
    AppMethodBeat.o(163596);
  }
  
  private void By(int paramInt)
  {
    AppMethodBeat.i(163607);
    this.KwX = paramInt;
    switch (this.KwX)
    {
    default: 
      AppMethodBeat.o(163607);
      return;
    case 0: 
      this.KwY = true;
      this.KwZ = true;
      this.Kwn.setVisibility(8);
      this.KwB.setVisibility(8);
      if (aw.isDarkMode()) {
        this.KwA.setImageResource(a.h.icons_filled_detail_skin_hb_mask_dark);
      }
      for (;;)
      {
        this.Kwj.setTag(a.f.lucky_money_detail_envelope_state_key, Boolean.FALSE);
        AppMethodBeat.o(163607);
        return;
        this.KwA.setImageResource(a.h.icons_filled_detail_skin_hb_mask);
      }
    case 1: 
      this.KwY = true;
      this.KwZ = true;
      this.Kwn.setVisibility(8);
      this.Kwz.setVisibility(8);
      this.Kwn.setPadding(com.tencent.mm.cd.a.fromDPToPix(getContext(), 12), com.tencent.mm.cd.a.fromDPToPix(getContext(), 8), com.tencent.mm.cd.a.fromDPToPix(getContext(), 12), com.tencent.mm.cd.a.fromDPToPix(getContext(), 4));
      this.Kwj.setVisibility(0);
      this.KwB.setVisibility(8);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      localLayoutParams.bottomMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 15);
      this.Kwx.setLayoutParams(localLayoutParams);
      if (aw.isDarkMode()) {
        this.KwA.setImageResource(a.h.icons_filled_detail_skin_hb_mask_dark);
      }
      for (;;)
      {
        this.Kwj.setTag(a.f.lucky_money_detail_envelope_state_key, Boolean.TRUE);
        AppMethodBeat.o(163607);
        return;
        this.KwA.setImageResource(a.h.icons_filled_detail_skin_hb_mask);
      }
    }
    this.KwY = false;
    this.KwZ = false;
    this.Kwn.setVisibility(0);
    this.Kwz.setVisibility(0);
    this.Kwn.setPadding(com.tencent.mm.cd.a.fromDPToPix(getContext(), 12), com.tencent.mm.cd.a.fromDPToPix(getContext(), 4), com.tencent.mm.cd.a.fromDPToPix(getContext(), 12), com.tencent.mm.cd.a.fromDPToPix(getContext(), 4));
    this.KwB.setVisibility(0);
    this.KwB.setAlpha(0.0F);
    if (aw.isDarkMode()) {
      this.KwA.setImageResource(a.h.icons_filled_detail_skin_hb_mask_dark);
    }
    for (;;)
    {
      com.tencent.mm.plugin.luckymoney.a.c.cg(4, this.KwV);
      this.Kwj.setTag(a.f.lucky_money_detail_envelope_state_key, Boolean.TRUE);
      break;
      this.KwA.setImageResource(a.h.icons_filled_detail_skin_hb_mask);
    }
  }
  
  private void b(com.tencent.mm.view.recyclerview.j paramj, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(284027);
    b localb = (b)paramj.CSA;
    localb.fXO();
    String str;
    if (EnvelopeStoryVideoManager.ci(localb.KxP, localb.KxR)) {
      str = localb.KxR;
    }
    for (boolean bool = true;; bool = false)
    {
      this.KwS.a(getContext(), (FrameLayout)paramj.UH(a.f.lucky_money_detail_story_item_video_container), (ImageView)paramj.UH(a.f.lucky_money_detail_story_item_image_iv), (ProgressBar)paramj.UH(a.f.lucky_money_detail_story_item_loading_pb), str, localb.videoWidth, localb.videoHeight, paramInt, true, bool, paramBoolean);
      AppMethodBeat.o(284027);
      return;
      str = localb.KxO.abJl;
    }
  }
  
  private void fXI()
  {
    AppMethodBeat.i(163599);
    this.Kwn.setOnClickListener(this.Kxy);
    if ((!this.Kxa) && (this.KwX == 2)) {
      this.Kwn.setBackgroundResource(a.e.lucky_money_detail_story_normal_click_bg);
    }
    for (;;)
    {
      this.Kwj.setOnClickListener(this.Kxy);
      AppMethodBeat.o(163599);
      return;
      this.Kwn.setBackgroundResource(a.e.lucky_money_detail_story_click_bg_normal);
    }
  }
  
  private void fXJ()
  {
    AppMethodBeat.i(163600);
    Object localObject = aw.bf(getContext());
    if ((localObject != null) && (((Point)localObject).x > 0)) {}
    for (this.KwJ = ((Point)localObject).x;; this.KwJ = (((Rect)localObject).right - ((Rect)localObject).left))
    {
      this.KwK = ((int)(this.KwJ * 1.335F));
      this.Kwj.setMinimumHeight(this.KwK);
      localObject = new AppBarLayout.LayoutParams(this.KwK);
      ((AppBarLayout.LayoutParams)localObject).dog = 3;
      this.Kwi.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.Kwi.setMinimumHeight(this.KwN);
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(174331);
          EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this).ji(-(EnvelopeAppBarLayout.this.getTotalScrollRange() - EnvelopeAppBarLayout.k(EnvelopeAppBarLayout.this)));
          EnvelopeAppBarLayout.t(EnvelopeAppBarLayout.this).setAlpha(1.0F);
          AppMethodBeat.o(174331);
        }
      }, 50L);
      AppMethodBeat.o(163600);
      return;
      localObject = new Rect();
      getWindowVisibleDisplayFrame((Rect)localObject);
    }
  }
  
  private boolean fXK()
  {
    AppMethodBeat.i(163601);
    com.tencent.mm.view.recyclerview.j localj = (com.tencent.mm.view.recyclerview.j)this.Kwk.fU(this.bXr);
    if (localj == null)
    {
      AppMethodBeat.o(163601);
      return false;
    }
    if (((b)localj.CSA).KxO.abJk == 2)
    {
      AppMethodBeat.o(163601);
      return true;
    }
    AppMethodBeat.o(163601);
    return false;
  }
  
  private static boolean fXL()
  {
    AppMethodBeat.i(284031);
    com.tencent.mm.util.i locali = com.tencent.mm.util.i.agtt;
    int i = com.tencent.mm.util.i.a(b.a.agsz, 0);
    if (i == 1)
    {
      AppMethodBeat.o(284031);
      return true;
    }
    if (i == 2)
    {
      AppMethodBeat.o(284031);
      return false;
    }
    if (((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVv, Integer.valueOf(0))).intValue() == 0)
    {
      AppMethodBeat.o(284031);
      return true;
    }
    AppMethodBeat.o(284031);
    return false;
  }
  
  private void fXM()
  {
    AppMethodBeat.i(284035);
    if ((!this.Kxw) || (!this.Kxx))
    {
      Log.i("MicroMsg.EnvelopeAppBarLayout", "not run this time");
      AppMethodBeat.o(284035);
      return;
    }
    if (!fXL())
    {
      Log.i("MicroMsg.EnvelopeAppBarLayout", "disable auto play");
      AppMethodBeat.o(284035);
      return;
    }
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(284014);
        if ((EnvelopeAppBarLayout.this.KwX == 2) && (EnvelopeAppBarLayout.C(EnvelopeAppBarLayout.this)))
        {
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, ObjectAnimator.ofFloat(EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this), "alpha", new float[] { EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this).getAlpha(), 0.0F }));
          EnvelopeAppBarLayout.G(EnvelopeAppBarLayout.this).setDuration(500L);
          int i = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVw, Integer.valueOf(1500))).intValue();
          EnvelopeAppBarLayout.G(EnvelopeAppBarLayout.this).setStartDelay(i);
          EnvelopeAppBarLayout.G(EnvelopeAppBarLayout.this).start();
          EnvelopeAppBarLayout.G(EnvelopeAppBarLayout.this).addListener(new Animator.AnimatorListener()
          {
            public final void onAnimationCancel(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationEnd(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(284022);
              Log.d("MicroMsg.EnvelopeAppBarLayout", "has animator end");
              AppMethodBeat.o(284022);
            }
            
            public final void onAnimationRepeat(Animator paramAnonymous2Animator) {}
            
            public final void onAnimationStart(Animator paramAnonymous2Animator)
            {
              AppMethodBeat.i(284018);
              Log.d("MicroMsg.EnvelopeAppBarLayout", "start fade animator");
              if (!EnvelopeAppBarLayout.G(EnvelopeAppBarLayout.this).isRunning())
              {
                AppMethodBeat.o(284018);
                return;
              }
              EnvelopeAppBarLayout.H(EnvelopeAppBarLayout.this);
              AppMethodBeat.o(284018);
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
              AppMethodBeat.i(284023);
              if (EnvelopeAppBarLayout.C(EnvelopeAppBarLayout.this))
              {
                Object localObject = (com.tencent.mm.view.recyclerview.j)EnvelopeAppBarLayout.r(EnvelopeAppBarLayout.this).fU(EnvelopeAppBarLayout.B(EnvelopeAppBarLayout.this));
                if (localObject != null)
                {
                  EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, (com.tencent.mm.view.recyclerview.j)localObject, EnvelopeAppBarLayout.B(EnvelopeAppBarLayout.this));
                  LuckyMoneyDetailUI.a locala = (LuckyMoneyDetailUI.a)EnvelopeAppBarLayout.this.KwG.component(LuckyMoneyDetailUI.a.class);
                  localObject = ((com.tencent.mm.view.recyclerview.j)localObject).caK.findViewById(a.f.lucky_money_detail_story_item_video_container);
                  ((View)localObject).sendAccessibilityEvent(32768);
                  ((View)localObject).announceForAccessibility(locala.getString(a.i.lucky_money_detail_envelope_preview_video_desc_accessibility_text));
                }
              }
              AppMethodBeat.o(284023);
            }
          }, i);
        }
        AppMethodBeat.o(284014);
      }
    });
    AppMethodBeat.o(284035);
  }
  
  private void fXN()
  {
    AppMethodBeat.i(284037);
    if ((this.KwH != null) && (this.KwH.isStarted())) {
      this.KwH.cancel();
    }
    AppMethodBeat.o(284037);
  }
  
  public final void a(eoh parameoh, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(284145);
    if (Util.isNullOrNil(this.KwV))
    {
      By(0);
      this.KwK = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 502);
      parameoh = new AppBarLayout.LayoutParams(this.KwK);
      parameoh.dog = 3;
      this.Kwi.setMinimumHeight(this.KwN);
      this.Kwi.setLayoutParams(parameoh);
    }
    for (;;)
    {
      Log.i("MicroMsg.EnvelopeAppBarLayout", "set envelope story: %s", new Object[] { Integer.valueOf(this.KwX) });
      AppMethodBeat.o(284145);
      return;
      if (parameoh != null) {
        break;
      }
      By(1);
      fXJ();
      this.Kwu.setText(paramString2);
      a.KyE = paramString2;
    }
    this.KwT = parameoh;
    this.KwU = paramString1;
    this.isPreview = paramBoolean;
    this.Kwq.setText(this.KwT.description);
    this.Kws.setText(this.KwT.absv);
    this.Kwu.setText(this.KwT.title);
    a.KyE = this.KwT.absv;
    if (parameoh.absy != null) {
      paramInt = parameoh.absy.nQJ;
    }
    if (paramInt == 2)
    {
      this.Kwv.setVisibility(0);
      this.Kwt.setVisibility(0);
      com.tencent.mm.plugin.luckymoney.a.c.KlD = this.KwT.wuj;
      if (this.KwT.wuj != 1) {
        break label554;
      }
      if (!this.Kxn)
      {
        com.tencent.mm.plugin.luckymoney.a.c.cg(8, this.KwV);
        this.Kxn = true;
      }
      this.KwC.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(284038);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          Log.d("MicroMsg.EnvelopeAppBarLayout", "go to h5");
          if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
          {
            com.tencent.mm.wallet_core.ui.i.bC(EnvelopeAppBarLayout.this.getContext(), EnvelopeAppBarLayout.F(EnvelopeAppBarLayout.this).Kru);
            com.tencent.mm.plugin.luckymoney.a.d.BI(7);
            com.tencent.mm.plugin.luckymoney.a.c.cg(9, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
            b.KyP += 1;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$12", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(284038);
        }
      });
      this.Kww.setText(a.i.app_learn_more);
      label301:
      if (!Util.isNullOrNil(this.KwT.absz)) {
        this.Kww.setText(this.KwT.absz);
      }
      if (Util.isNullOrNil(parameoh.nQG)) {
        break label897;
      }
      ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.Kwr, parameoh.nQG, parameoh.nQH, paramString1);
      this.Kwr.setVisibility(0);
      label373:
      this.KwR.clear();
      if (parameoh.absw.isEmpty()) {
        break label1705;
      }
      b.KyN = 1;
      a.KyF = 2;
      paramInt = 0;
      label401:
      if (paramInt >= parameoh.absw.size()) {
        break label922;
      }
      paramString1 = (fim)parameoh.absw.get(paramInt);
      paramString2 = new b();
      paramString2.KxO = paramString1;
      paramString2.KxQ = paramInt;
      paramString2.KxP = parameoh.aaxT;
      String str = LuckyMoneyEnvelopeResUpdateListener.jD(paramString2.KxP, paramString2.KxQ);
      if ((paramString2.KxP > 0) && (y.ZC(str)))
      {
        Log.i("MicroMsg.EnvelopeAppBarLayout", "[static luckymoney resource] has local video,add path");
        paramString2.KxR = str;
      }
      this.KwR.add(paramString2);
      if (paramString1.abJk != 2) {
        break label909;
      }
      this.AXs += 1;
    }
    for (;;)
    {
      paramInt += 1;
      break label401;
      this.Kwv.setVisibility(8);
      this.Kwt.setVisibility(8);
      break;
      label554:
      if (this.KwT.wuj == 2)
      {
        if (Util.isNullOrNil(this.KwT.Krv)) {
          break label301;
        }
        if (!this.Kxo)
        {
          com.tencent.mm.plugin.luckymoney.a.c.cg(11, this.KwV);
          this.Kxo = true;
        }
        com.tencent.mm.wallet_core.ui.i.bG(this.KwC, 100);
        b.KyO = 1;
        this.KwC.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(284034);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            Log.d("MicroMsg.EnvelopeAppBarLayout", "go to profile");
            if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
            {
              paramAnonymousView = new Intent();
              paramAnonymousView.putExtra("Contact_User", EnvelopeAppBarLayout.F(EnvelopeAppBarLayout.this).Krv);
              paramAnonymousView.putExtra("Contact_Scene", 240);
              if (!Util.isNullOrNil(EnvelopeAppBarLayout.F(EnvelopeAppBarLayout.this).absE)) {
                paramAnonymousView.putExtra("biz_profile_enter_from_luck_money_spring_event_url", Uri.parse(EnvelopeAppBarLayout.F(EnvelopeAppBarLayout.this).absE).buildUpon().appendQueryParameter("fromscene", "2").appendQueryParameter("type", "1").build().toString());
              }
              paramAnonymousView.putExtra("force_get_contact", true);
              com.tencent.mm.br.c.b(EnvelopeAppBarLayout.this.getContext(), "profile", ".ui.ContactInfoUI", paramAnonymousView, 2);
              com.tencent.mm.plugin.luckymoney.a.d.BI(7);
              com.tencent.mm.plugin.luckymoney.a.c.cg(13, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
              b.KyP += 1;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$13", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(284034);
          }
        });
        this.Kww.setText(a.i.lucky_money_envelope_story_enter_biz_profile_text);
        break label301;
      }
      if (this.KwT.wuj == 3)
      {
        if (!this.Kxp)
        {
          com.tencent.mm.plugin.luckymoney.a.c.cg(12, this.KwV);
          this.Kxp = true;
        }
        this.KwC.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(284036);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            Log.d("MicroMsg.EnvelopeAppBarLayout", "go to mini app");
            if (EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this))
            {
              com.tencent.mm.wallet_core.ui.i.y(EnvelopeAppBarLayout.F(EnvelopeAppBarLayout.this).Krv, EnvelopeAppBarLayout.F(EnvelopeAppBarLayout.this).Kru, 0, 1100);
              com.tencent.mm.plugin.luckymoney.a.d.BI(7);
              com.tencent.mm.plugin.luckymoney.a.c.cg(14, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
              b.KyP += 1;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$14", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(284036);
          }
        });
        this.Kww.setText(a.i.lucky_money_envelope_story_enter_miniapp_text);
        break label301;
      }
      if (this.KwT.wuj == 4)
      {
        if (!this.Kxs)
        {
          com.tencent.mm.plugin.luckymoney.a.c.cg(19, this.KwV);
          this.Kxs = true;
        }
        this.KwC.setOnClickListener(new View.OnClickListener()
        {
          /* Error */
          public final void onClick(View paramAnonymousView)
          {
            // Byte code:
            //   0: ldc 24
            //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
            //   5: new 32	com/tencent/mm/hellhoundlib/b/b
            //   8: dup
            //   9: invokespecial 33	com/tencent/mm/hellhoundlib/b/b:<init>	()V
            //   12: astore_2
            //   13: aload_2
            //   14: aload_1
            //   15: invokevirtual 37	com/tencent/mm/hellhoundlib/b/b:cH	(Ljava/lang/Object;)V
            //   18: ldc 39
            //   20: ldc 40
            //   22: ldc 41
            //   24: ldc 42
            //   26: aload_0
            //   27: aload_2
            //   28: invokevirtual 46	com/tencent/mm/hellhoundlib/b/b:aYj	()[Ljava/lang/Object;
            //   31: invokestatic 52	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)V
            //   34: ldc 54
            //   36: ldc 56
            //   38: invokestatic 62	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
            //   41: aload_0
            //   42: getfield 17	com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$7:KxA	Lcom/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout;
            //   45: invokestatic 65	com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout:a	(Lcom/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout;)Z
            //   48: ifeq +293 -> 341
            //   51: new 67	android/content/Intent
            //   54: dup
            //   55: invokespecial 68	android/content/Intent:<init>	()V
            //   58: astore_1
            //   59: ldc 70
            //   61: invokestatic 76	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
            //   64: checkcast 70	com/tencent/mm/plugin/findersdk/a/cn
            //   67: bipush 10
            //   69: iconst_2
            //   70: bipush 32
            //   72: aload_1
            //   73: invokeinterface 80 5 0
            //   78: pop
            //   79: aload_1
            //   80: ldc 82
            //   82: aload_0
            //   83: getfield 17	com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$7:KxA	Lcom/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout;
            //   86: invokestatic 86	com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout:F	(Lcom/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout;)Lcom/tencent/mm/protocal/protobuf/eoh;
            //   89: getfield 92	com/tencent/mm/protocal/protobuf/eoh:Krv	Ljava/lang/String;
            //   92: invokevirtual 96	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
            //   95: pop
            //   96: aload_0
            //   97: getfield 17	com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$7:KxA	Lcom/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout;
            //   100: invokestatic 86	com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout:F	(Lcom/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout;)Lcom/tencent/mm/protocal/protobuf/eoh;
            //   103: getfield 99	com/tencent/mm/protocal/protobuf/eoh:absE	Ljava/lang/String;
            //   106: invokestatic 105	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
            //   109: ifne +46 -> 155
            //   112: aload_1
            //   113: ldc 107
            //   115: aload_0
            //   116: getfield 17	com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$7:KxA	Lcom/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout;
            //   119: invokestatic 86	com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout:F	(Lcom/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout;)Lcom/tencent/mm/protocal/protobuf/eoh;
            //   122: getfield 99	com/tencent/mm/protocal/protobuf/eoh:absE	Ljava/lang/String;
            //   125: invokestatic 113	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
            //   128: invokevirtual 117	android/net/Uri:buildUpon	()Landroid/net/Uri$Builder;
            //   131: ldc 119
            //   133: ldc 121
            //   135: invokevirtual 127	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
            //   138: ldc 129
            //   140: ldc 121
            //   142: invokevirtual 127	android/net/Uri$Builder:appendQueryParameter	(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;
            //   145: invokevirtual 133	android/net/Uri$Builder:build	()Landroid/net/Uri;
            //   148: invokevirtual 137	android/net/Uri:toString	()Ljava/lang/String;
            //   151: invokevirtual 96	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
            //   154: pop
            //   155: aload_1
            //   156: ldc 139
            //   158: aload_0
            //   159: getfield 17	com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$7:KxA	Lcom/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout;
            //   162: invokestatic 86	com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout:F	(Lcom/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout;)Lcom/tencent/mm/protocal/protobuf/eoh;
            //   165: getfield 142	com/tencent/mm/protocal/protobuf/eoh:nQE	Ljava/lang/String;
            //   168: invokevirtual 96	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
            //   171: pop
            //   172: aload_1
            //   173: ldc 144
            //   175: iconst_1
            //   176: invokevirtual 147	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
            //   179: pop
            //   180: new 149	org/json/JSONObject
            //   183: dup
            //   184: invokespecial 150	org/json/JSONObject:<init>	()V
            //   187: astore_2
            //   188: aload_2
            //   189: ldc 152
            //   191: iconst_1
            //   192: invokevirtual 156	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
            //   195: pop
            //   196: aload_1
            //   197: ldc 158
            //   199: aload_2
            //   200: invokevirtual 159	org/json/JSONObject:toString	()Ljava/lang/String;
            //   203: invokevirtual 96	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
            //   206: pop
            //   207: ldc 70
            //   209: invokestatic 76	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
            //   212: checkcast 70	com/tencent/mm/plugin/findersdk/a/cn
            //   215: aload_0
            //   216: getfield 17	com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$7:KxA	Lcom/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout;
            //   219: getfield 163	com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout:KwG	Lcom/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI;
            //   222: aload_1
            //   223: invokeinterface 167 3 0
            //   228: aload_0
            //   229: getfield 17	com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$7:KxA	Lcom/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout;
            //   232: getfield 163	com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout:KwG	Lcom/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI;
            //   235: getstatic 173	com/tencent/mm/plugin/wxpay/a$a:slide_right_in	I
            //   238: getstatic 176	com/tencent/mm/plugin/wxpay/a$a:slide_left_out	I
            //   241: invokevirtual 182	com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyDetailUI:overridePendingTransition	(II)V
            //   244: bipush 7
            //   246: invokestatic 187	com/tencent/mm/plugin/luckymoney/a/d:BI	(I)V
            //   249: bipush 20
            //   251: aload_0
            //   252: getfield 17	com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$7:KxA	Lcom/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout;
            //   255: invokestatic 190	com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout:c	(Lcom/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout;)Ljava/lang/String;
            //   258: invokestatic 196	com/tencent/mm/plugin/luckymoney/a/c:cg	(ILjava/lang/String;)V
            //   261: getstatic 201	com/tencent/mm/plugin/luckymoney/story/b:KyP	I
            //   264: iconst_1
            //   265: iadd
            //   266: putstatic 201	com/tencent/mm/plugin/luckymoney/story/b:KyP	I
            //   269: new 149	org/json/JSONObject
            //   272: dup
            //   273: invokespecial 150	org/json/JSONObject:<init>	()V
            //   276: astore_1
            //   277: aload_1
            //   278: ldc 203
            //   280: aload_0
            //   281: getfield 17	com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$7:KxA	Lcom/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout;
            //   284: invokestatic 86	com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout:F	(Lcom/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout;)Lcom/tencent/mm/protocal/protobuf/eoh;
            //   287: getfield 142	com/tencent/mm/protocal/protobuf/eoh:nQE	Ljava/lang/String;
            //   290: invokevirtual 206	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            //   293: pop
            //   294: aload_1
            //   295: ldc 208
            //   297: aload_0
            //   298: getfield 17	com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$7:KxA	Lcom/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout;
            //   301: invokestatic 86	com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout:F	(Lcom/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout;)Lcom/tencent/mm/protocal/protobuf/eoh;
            //   304: getfield 92	com/tencent/mm/protocal/protobuf/eoh:Krv	Ljava/lang/String;
            //   307: invokevirtual 206	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
            //   310: pop
            //   311: aload_1
            //   312: ldc 210
            //   314: iconst_1
            //   315: invokevirtual 156	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
            //   318: pop
            //   319: ldc 70
            //   321: invokestatic 76	com/tencent/mm/kernel/h:az	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/b/a;
            //   324: checkcast 70	com/tencent/mm/plugin/findersdk/a/cn
            //   327: invokeinterface 214 1 0
            //   332: ldc 216
            //   334: iconst_1
            //   335: aload_1
            //   336: invokeinterface 222 4 0
            //   341: aload_0
            //   342: ldc 39
            //   344: ldc 40
            //   346: ldc 41
            //   348: ldc 42
            //   350: invokestatic 225	com/tencent/mm/hellhoundlib/a/a:a	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
            //   353: ldc 24
            //   355: invokestatic 228	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
            //   358: return
            //   359: astore_3
            //   360: ldc 54
            //   362: ldc 230
            //   364: iconst_1
            //   365: anewarray 4	java/lang/Object
            //   368: dup
            //   369: iconst_0
            //   370: aload_3
            //   371: aastore
            //   372: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
            //   375: goto -179 -> 196
            //   378: astore_2
            //   379: ldc 54
            //   381: ldc 230
            //   383: iconst_1
            //   384: anewarray 4	java/lang/Object
            //   387: dup
            //   388: iconst_0
            //   389: aload_2
            //   390: aastore
            //   391: invokestatic 234	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
            //   394: goto -75 -> 319
            // Local variable table:
            //   start	length	slot	name	signature
            //   0	397	0	this	7
            //   0	397	1	paramAnonymousView	View
            //   12	188	2	localObject1	Object
            //   378	12	2	localObject2	Object
            //   359	12	3	localObject3	Object
            // Exception table:
            //   from	to	target	type
            //   188	196	359	finally
            //   277	319	378	finally
          }
        });
        this.Kww.setText(a.i.lucky_money_envelope_story_enter_finder_text);
        break label301;
      }
      if (this.KwT.wuj == 5)
      {
        if (!this.Kxr)
        {
          com.tencent.mm.plugin.luckymoney.a.c.cg(17, this.KwV);
          this.Kxr = true;
        }
        this.KwC.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(284032);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("uin", EnvelopeAppBarLayout.F(EnvelopeAppBarLayout.this).absA);
            paramAnonymousView.putExtra("name", EnvelopeAppBarLayout.F(EnvelopeAppBarLayout.this).Krv);
            paramAnonymousView.putExtra("headurl", EnvelopeAppBarLayout.F(EnvelopeAppBarLayout.this).Kru);
            paramAnonymousView.putExtra("extra_scence", 30);
            com.tencent.mm.br.c.b(EnvelopeAppBarLayout.this.getContext(), "emoji", ".ui.v2.EmojiStoreV2DesignerUI", paramAnonymousView);
            com.tencent.mm.plugin.luckymoney.a.d.BI(7);
            com.tencent.mm.plugin.luckymoney.a.c.cg(18, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
            b.KyP += 1;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$16", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(284032);
          }
        });
        this.Kww.setText(a.i.lucky_money_envelope_story_enter_emoji_designer_text);
        break label301;
      }
      if (this.KwT.wuj == 6)
      {
        if (!this.Kxq)
        {
          com.tencent.mm.plugin.luckymoney.a.c.cg(15, this.KwV);
          this.Kxq = true;
        }
        this.KwC.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(284030);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            paramAnonymousView = new Intent();
            paramAnonymousView.putExtra("extra_id", EnvelopeAppBarLayout.F(EnvelopeAppBarLayout.this).Krv);
            paramAnonymousView.putExtra("preceding_scence", 21);
            com.tencent.mm.br.c.b(EnvelopeAppBarLayout.this.getContext(), "emoji", ".ui.EmojiStoreDetailUI", paramAnonymousView);
            com.tencent.mm.plugin.luckymoney.a.d.BI(7);
            com.tencent.mm.plugin.luckymoney.a.c.cg(16, EnvelopeAppBarLayout.c(EnvelopeAppBarLayout.this));
            b.KyP += 1;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/story/EnvelopeAppBarLayout$17", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(284030);
          }
        });
        this.Kww.setText(a.i.lucky_money_envelope_story_enter_emoji_album_text);
        break label301;
      }
      this.KwC.setVisibility(8);
      b.KyO = 0;
      break label301;
      label897:
      this.Kwr.setVisibility(8);
      break label373;
      label909:
      this.Kxl += 1;
    }
    label922:
    this.Kwp.setCount(this.KwR.size());
    By(2);
    parameoh = aw.bf(getContext());
    label968:
    label1108:
    int i;
    if ((parameoh != null) && (parameoh.x > 0))
    {
      this.KwJ = parameoh.x;
      this.KwK = ((int)(this.KwJ * 1.667F));
      paramInt = (int)(this.KwJ * 1.335F);
      this.KwL = (this.KwK - paramInt);
      this.Kwj.setMinimumHeight(paramInt);
      parameoh = new AppBarLayout.LayoutParams(this.KwK);
      parameoh.dog = 3;
      this.Kwi.setLayoutParams(parameoh);
      this.KwO = ((int)(this.KwJ * 1.0F));
      this.Kwi.setMinimumHeight(this.KwN);
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(163580);
          EnvelopeAppBarLayout.d(EnvelopeAppBarLayout.this).ji(-(EnvelopeAppBarLayout.this.getTotalScrollRange() - EnvelopeAppBarLayout.k(EnvelopeAppBarLayout.this)));
          EnvelopeAppBarLayout.t(EnvelopeAppBarLayout.this).setAlpha(1.0F);
          EnvelopeAppBarLayout.this.KwG.KBD.setAlpha(1.0F);
          EnvelopeAppBarLayout.this.KwG.KBE.setVisibility(0);
          EnvelopeAppBarLayout.w(EnvelopeAppBarLayout.this);
          AppMethodBeat.o(163580);
        }
      }, 50L);
      if (!this.isPreview) {
        break label1588;
      }
      paramInt = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVu, Integer.valueOf(0))).intValue();
      Log.i("MicroMsg.EnvelopeAppBarLayout", "show first guide: %s", new Object[] { Integer.valueOf(paramInt) });
      parameoh = com.tencent.mm.util.i.agtt;
      i = com.tencent.mm.util.i.a(b.a.agsy, 0);
      if (i != 1) {
        break label1615;
      }
      paramInt = 1;
      label1151:
      if (paramInt == 0) {
        break label1693;
      }
      this.Kxu = true;
      this.KwE = ((ViewGroup)findViewById(a.f.lucky_money_detail_story_guide_layout));
      this.KwE.setVisibility(0);
      this.Kwn.setVisibility(4);
      this.Kxb = new ValueAnimator();
      this.Kxb.setDuration(700L);
      this.Kxb.setInterpolator(new AccelerateDecelerateInterpolator());
      this.Kxb.setIntValues(new int[] { 0, this.KwM });
      this.Kxc = new ObjectAnimator();
      this.Kxc.setPropertyName("alpha");
      this.Kxc.setFloatValues(new float[] { 1.0F, 0.0F });
      this.Kxc.setTarget(this.KwE);
      this.Kxc.setDuration(300L);
      this.Kxc.setStartDelay(200L);
      this.Kxc.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(284016);
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, true);
          AppMethodBeat.o(284016);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(163586);
          EnvelopeAppBarLayout.a(EnvelopeAppBarLayout.this, false);
          EnvelopeAppBarLayout.t(EnvelopeAppBarLayout.this).setVisibility(0);
          EnvelopeAppBarLayout.t(EnvelopeAppBarLayout.this).setAlpha(0.0F);
          AppMethodBeat.o(163586);
        }
      });
      this.Kxd = new ValueAnimator();
      this.Kxd.setInterpolator(com.google.android.material.a.a.dnu);
      this.Kxd.setStartDelay(200L);
      this.Kxd.setDuration(300L);
      this.Kxd.setIntValues(new int[] { this.KwM, 0 });
      parameoh = new ValueAnimator.AnimatorUpdateListener()
      {
        int KxI = 0;
        
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(163587);
          Log.d("MicroMsg.EnvelopeAppBarLayout", "animate value: " + paramAnonymousValueAnimator.getAnimatedValue());
          int i = ((Integer)paramAnonymousValueAnimator.getAnimatedValue()).intValue();
          int j = i - this.KxI;
          this.KxI = i;
          float f = (EnvelopeAppBarLayout.x(EnvelopeAppBarLayout.this) - i) / (EnvelopeAppBarLayout.x(EnvelopeAppBarLayout.this) * 1.0F);
          if (EnvelopeAppBarLayout.this.KwX == 2) {
            EnvelopeAppBarLayout.p(EnvelopeAppBarLayout.this).setAlpha(f);
          }
          EnvelopeAppBarLayout.this.offsetTopAndBottom(j);
          if (j > 0)
          {
            EnvelopeAppBarLayout.y(EnvelopeAppBarLayout.this).offsetTopAndBottom((int)(j * 0.123F));
            AppMethodBeat.o(163587);
            return;
          }
          EnvelopeAppBarLayout.t(EnvelopeAppBarLayout.this).setAlpha(f);
          AppMethodBeat.o(163587);
        }
      };
      this.Kxb.addUpdateListener(parameoh);
      this.Kxd.addUpdateListener(parameoh);
      this.Kxe = new AnimatorSet();
      this.Kxe.playSequentially(new Animator[] { this.Kxb, this.Kxc, this.Kxd });
      this.Kxe.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(163588);
          EnvelopeAppBarLayout.y(EnvelopeAppBarLayout.this).setVisibility(8);
          if (EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this) != null) {
            EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).KyR = false;
          }
          EnvelopeAppBarLayout.z(EnvelopeAppBarLayout.this);
          EnvelopeAppBarLayout.A(EnvelopeAppBarLayout.this);
          AppMethodBeat.o(163588);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      });
      post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(284013);
          if (EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this) != null) {
            EnvelopeAppBarLayout.f(EnvelopeAppBarLayout.this).KyR = true;
          }
          EnvelopeAppBarLayout.I(EnvelopeAppBarLayout.this).setStartDelay(700L);
          EnvelopeAppBarLayout.I(EnvelopeAppBarLayout.this).start();
          AppMethodBeat.o(284013);
        }
      });
      if (!this.isPreview) {
        break label1647;
      }
      paramInt = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVu, Integer.valueOf(0))).intValue();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acVu, Integer.valueOf(paramInt + 1));
    }
    for (;;)
    {
      this.Kwk.getAdapter().bZE.notifyChanged();
      break;
      parameoh = new Rect();
      getWindowVisibleDisplayFrame(parameoh);
      this.KwJ = (parameoh.right - parameoh.left);
      break label968;
      label1588:
      paramInt = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVt, Integer.valueOf(0))).intValue();
      break label1108;
      label1615:
      if ((i != 2) && (paramInt < 3) && (this.KwX == 2))
      {
        paramInt = 1;
        break label1151;
      }
      paramInt = 0;
      break label1151;
      label1647:
      paramInt = ((Integer)com.tencent.mm.kernel.h.baE().ban().get(at.a.acVt, Integer.valueOf(0))).intValue();
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acVt, Integer.valueOf(paramInt + 1));
      continue;
      label1693:
      this.Kxx = true;
      fXM();
      continue;
      label1705:
      By(1);
      fXJ();
    }
  }
  
  public final void ao(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(284147);
    if ((Util.isNullOrNil(this.KwV)) && (!Util.isNullOrNil(paramString1)))
    {
      this.KwV = paramString1;
      this.KwW = paramString2;
      this.KwF.setVisibility(0);
      ((com.tencent.mm.plugin.luckymoney.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.luckymoney.a.a.class)).a(this.Kwj, this.KwV, this.KwW, this.KwU, this.KwK, this.KwJ, 0, new a.a()
      {
        public final void onComplete(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(284020);
          if (paramAnonymousBoolean)
          {
            EnvelopeAppBarLayout.J(EnvelopeAppBarLayout.this).setVisibility(8);
            EnvelopeAppBarLayout.K(EnvelopeAppBarLayout.this);
            EnvelopeAppBarLayout.A(EnvelopeAppBarLayout.this);
          }
          AppMethodBeat.o(284020);
        }
      }, paramInt, 2, 0);
    }
    AppMethodBeat.o(284147);
  }
  
  public final void fXH()
  {
    int j = 0;
    AppMethodBeat.i(182455);
    Object localObject1;
    Object localObject2;
    int i;
    if (this.bXr >= 0)
    {
      if (Util.isNullOrNil(b.sessionId))
      {
        AppMethodBeat.o(182455);
        return;
      }
      localObject1 = (com.tencent.mm.view.recyclerview.j)this.Kwk.fU(this.bXr);
      if (localObject1 != null)
      {
        boolean bool = fXK();
        localObject2 = (b)((com.tencent.mm.view.recyclerview.j)localObject1).CSA;
        if (bool)
        {
          localObject1 = this.KwS;
          i = this.bXr;
          localObject1 = (EnvelopeStoryVideoManager.c)((EnvelopeStoryVideoManager)localObject1).Kye.get(Integer.valueOf(i));
          if (localObject1 == null)
          {
            AppMethodBeat.o(182455);
            return;
          }
          ((EnvelopeStoryVideoManager.c)localObject1).Kyu = ((EnvelopeStoryVideoManager.c)localObject1).Kyw.getCurrPosSec();
          if (((EnvelopeStoryVideoManager.c)localObject1).Kyv.get() == 1) {
            i = (int)(((EnvelopeStoryVideoManager.c)localObject1).Kyu - ((EnvelopeStoryVideoManager.c)localObject1).Kyt);
          }
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.report.service.h localh = com.tencent.mm.plugin.report.service.h.OAn;
      String str1 = this.KwU;
      AtomicInteger localAtomicInteger = ((EnvelopeStoryVideoManager.c)localObject1).Kyv;
      localObject2 = ((b)localObject2).KxO.abJl;
      String str2 = b.sessionId;
      if (((EnvelopeStoryVideoManager.c)localObject1).isPreview) {
        j = 1;
      }
      localh.b(19270, new Object[] { Integer.valueOf(2), str1, localAtomicInteger, "", localObject2, Integer.valueOf(i), str2, Integer.valueOf(j), com.tencent.mm.plugin.luckymoney.a.c.openId });
      AppMethodBeat.o(182455);
      return;
      if (((EnvelopeStoryVideoManager.c)localObject1).Kyv.get() > 1)
      {
        i = ((EnvelopeStoryVideoManager.c)localObject1).Kyv.get();
        i = (int)(((EnvelopeStoryVideoManager.c)localObject1).Kyp - ((EnvelopeStoryVideoManager.c)localObject1).Kyt + ((EnvelopeStoryVideoManager.c)localObject1).Kyu + (i - 1) * ((EnvelopeStoryVideoManager.c)localObject1).Kyp);
        continue;
        com.tencent.mm.plugin.report.service.h.OAn.b(19270, new Object[] { Integer.valueOf(1), this.KwU, Integer.valueOf(0), ((b)localObject2).KxO.abJl, "", Integer.valueOf(0), b.sessionId, Integer.valueOf(0), com.tencent.mm.plugin.luckymoney.a.c.openId });
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
  
  @z(Ho=j.a.ON_DESTROY)
  public void onUIDestroy()
  {
    AppMethodBeat.i(163604);
    fXH();
    this.KwS.fXV();
    if ((this.KwX == 1) || (this.KwX == 2)) {
      b.BI(3);
    }
    com.tencent.mm.plugin.luckymoney.a.d.BI(11);
    fXN();
    AppMethodBeat.o(163604);
  }
  
  @z(Ho=j.a.ON_PAUSE)
  public void onUIPause() {}
  
  public void setActivityLifeCycle(LuckyMoneyDetailUI paramLuckyMoneyDetailUI)
  {
    AppMethodBeat.i(284129);
    paramLuckyMoneyDetailUI.getLifecycle().addObserver(this.KwS);
    paramLuckyMoneyDetailUI.getLifecycle().addObserver(this);
    this.KwG = paramLuckyMoneyDetailUI;
    EnvelopeStoryVideoManager localEnvelopeStoryVideoManager = this.KwS;
    localEnvelopeStoryVideoManager.wrG = paramLuckyMoneyDetailUI;
    MMHandlerThread.postToMainThread(new EnvelopeStoryVideoManager.1(localEnvelopeStoryVideoManager));
    AppMethodBeat.o(284129);
  }
  
  final class a
    extends com.tencent.mm.view.recyclerview.f<EnvelopeAppBarLayout.b>
  {
    a() {}
    
    public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt) {}
    
    public final int getLayoutId()
    {
      return a.g.lucky_money_detail_story_item;
    }
  }
  
  final class b
    implements com.tencent.mm.view.recyclerview.a
  {
    public fim KxO;
    public int KxP = -1;
    public int KxQ = -1;
    public String KxR = "";
    public int videoHeight = -1;
    public int videoWidth = -1;
    
    b() {}
    
    public final long bZA()
    {
      return 0L;
    }
    
    public final int bZB()
    {
      return 0;
    }
    
    public final void fXO()
    {
      AppMethodBeat.i(163594);
      if ((this.videoHeight > 0) && (this.videoWidth > 0))
      {
        AppMethodBeat.o(163594);
        return;
      }
      float f = this.KxO.height / (this.KxO.width * 1.0F);
      if (f > 1.667F)
      {
        this.videoHeight = EnvelopeAppBarLayout.M(EnvelopeAppBarLayout.this);
        this.videoWidth = ((int)(EnvelopeAppBarLayout.M(EnvelopeAppBarLayout.this) / f));
      }
      for (;;)
      {
        Log.d("MicroMsg.EnvelopeAppBarLayout", "video size: %s, %s", new Object[] { Integer.valueOf(this.videoWidth), Integer.valueOf(this.videoHeight) });
        AppMethodBeat.o(163594);
        return;
        if (f < 1.667F)
        {
          this.videoWidth = EnvelopeAppBarLayout.N(EnvelopeAppBarLayout.this);
          this.videoHeight = ((int)(f * EnvelopeAppBarLayout.N(EnvelopeAppBarLayout.this)));
        }
        else
        {
          this.videoHeight = EnvelopeAppBarLayout.M(EnvelopeAppBarLayout.this);
          this.videoWidth = EnvelopeAppBarLayout.N(EnvelopeAppBarLayout.this);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.story.EnvelopeAppBarLayout
 * JD-Core Version:    0.7.0.1
 */