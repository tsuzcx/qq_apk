package com.tencent.mm.plugin.appbrand.widget.desktop.half;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.c;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.m;
import android.support.v7.widget.RecyclerView.w;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.appusage.ah.a;
import com.tencent.mm.plugin.appbrand.appusage.ai;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.widget.desktop.d;
import com.tencent.mm.plugin.appbrand.widget.header.a.a.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.c;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.d;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.f;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.BaseAppBrandRecentView.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.e.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.List;

public class AppBrandDesktopHalfItemView
  extends LinearLayout
{
  private RecyclerView.m asH;
  private int gOl;
  private Context mContext;
  ConversationAppBrandRecentView mWI;
  private int mWv;
  private int mYP;
  boolean mZA;
  private a.b mZB;
  private boolean mZC;
  private Animator.AnimatorListener mZD;
  private TextView mZo;
  private ImageView mZp;
  private AppBrandRecentView.e mZq;
  RecyclerView.c mZr;
  private AppBrandRecentView.b mZs;
  private com.tencent.mm.plugin.appbrand.widget.recentview.b mZt;
  private LinearLayout mZu;
  private FrameLayout mZv;
  private View mZw;
  private AppBrandRecentView.f mZx;
  private float mZy;
  a mZz;
  
  public AppBrandDesktopHalfItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49748);
    this.mZq = null;
    this.mZr = null;
    this.mZs = null;
    this.asH = null;
    this.mZt = null;
    this.mZu = null;
    this.mZv = null;
    this.mZw = null;
    this.mWv = 0;
    this.mYP = 0;
    this.mZy = 0.0F;
    this.mZz = null;
    this.mZA = false;
    this.mZB = null;
    this.mZC = true;
    this.gOl = 1;
    this.mZD = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(49735);
        if ((AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this) != null) && (AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).mZG != null) && (AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).mZG.auu != null) && ((AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).mZG instanceof BaseAppBrandRecentView.b))) {
          ((BaseAppBrandRecentView.b)AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).mZG).titleTv.setVisibility(0);
        }
        AppBrandDesktopHalfItemView.j(AppBrandDesktopHalfItemView.this);
        AppMethodBeat.o(49735);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    };
    init(paramContext);
    AppMethodBeat.o(49748);
  }
  
  public AppBrandDesktopHalfItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49749);
    this.mZq = null;
    this.mZr = null;
    this.mZs = null;
    this.asH = null;
    this.mZt = null;
    this.mZu = null;
    this.mZv = null;
    this.mZw = null;
    this.mWv = 0;
    this.mYP = 0;
    this.mZy = 0.0F;
    this.mZz = null;
    this.mZA = false;
    this.mZB = null;
    this.mZC = true;
    this.gOl = 1;
    this.mZD = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(49735);
        if ((AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this) != null) && (AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).mZG != null) && (AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).mZG.auu != null) && ((AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).mZG instanceof BaseAppBrandRecentView.b))) {
          ((BaseAppBrandRecentView.b)AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).mZG).titleTv.setVisibility(0);
        }
        AppBrandDesktopHalfItemView.j(AppBrandDesktopHalfItemView.this);
        AppMethodBeat.o(49735);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    };
    init(paramContext);
    AppMethodBeat.o(49749);
  }
  
  private void bDs()
  {
    AppMethodBeat.i(49753);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(getContext().getResources().getDisplayMetrics().widthPixels * 2, -2);
    this.mZu.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(49753);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49750);
    this.mContext = paramContext;
    paramContext = z.jO(this.mContext).inflate(2131492985, this);
    this.mZo = ((TextView)paramContext.findViewById(2131296703));
    this.mZo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(49738);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/half/AppBrandDesktopHalfItemView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.nmU)
        {
          ((q)g.ab(q.class)).di(AppBrandDesktopHalfItemView.this.getContext());
          if (AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this) != null) {
            AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this).bDF();
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/half/AppBrandDesktopHalfItemView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(49738);
          return;
          if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.nmT)
          {
            ((q)g.ab(q.class)).d(AppBrandDesktopHalfItemView.this.getContext(), 3, 0);
            if (AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this) != null) {
              AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this).bDG();
            }
          }
        }
      }
    });
    this.mZp = ((ImageView)paramContext.findViewById(2131296702));
    this.mZp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(49739);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/half/AppBrandDesktopHalfItemView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.nmU)
        {
          ((q)g.ab(q.class)).di(AppBrandDesktopHalfItemView.this.getContext());
          if (AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this) != null) {
            AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this).bDF();
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/half/AppBrandDesktopHalfItemView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(49739);
          return;
          if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.nmT)
          {
            ((q)g.ab(q.class)).d(AppBrandDesktopHalfItemView.this.getContext(), 3, 0);
            if (AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this) != null) {
              AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this).bDG();
            }
          }
        }
      }
    });
    this.mZv = ((FrameLayout)paramContext.findViewById(2131296704));
    this.mZu = ((LinearLayout)paramContext.findViewById(2131300139));
    bDs();
    this.mWI = ((ConversationAppBrandRecentView)paramContext.findViewById(2131296701));
    this.mWI.setRefreshListener(new AppBrandRecentView.e()
    {
      public final void uP(int paramAnonymousInt)
      {
        AppMethodBeat.i(49740);
        if (AppBrandDesktopHalfItemView.c(AppBrandDesktopHalfItemView.this) != null) {
          AppBrandDesktopHalfItemView.c(AppBrandDesktopHalfItemView.this).uP(paramAnonymousInt);
        }
        AppMethodBeat.o(49740);
      }
    });
    this.mWI.getAdapter().a(new RecyclerView.c()
    {
      public final void av(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(49741);
        super.av(paramAnonymousInt1, paramAnonymousInt2);
        if (AppBrandDesktopHalfItemView.d(AppBrandDesktopHalfItemView.this) != null) {
          AppBrandDesktopHalfItemView.d(AppBrandDesktopHalfItemView.this).av(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(49741);
      }
    });
    this.mWI.setOnItemClickListener(new AppBrandRecentView.b()
    {
      public final boolean a(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recentview.a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(49742);
        if (AppBrandDesktopHalfItemView.e(AppBrandDesktopHalfItemView.this) != null)
        {
          boolean bool = AppBrandDesktopHalfItemView.e(AppBrandDesktopHalfItemView.this).a(paramAnonymousView, paramAnonymousa, paramAnonymousFloat1, paramAnonymousFloat2);
          AppMethodBeat.o(49742);
          return bool;
        }
        AppMethodBeat.o(49742);
        return false;
      }
      
      public final boolean b(View paramAnonymousView, com.tencent.mm.plugin.appbrand.widget.recentview.a paramAnonymousa, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(49743);
        if (AppBrandDesktopHalfItemView.e(AppBrandDesktopHalfItemView.this) != null)
        {
          boolean bool = AppBrandDesktopHalfItemView.e(AppBrandDesktopHalfItemView.this).b(paramAnonymousView, paramAnonymousa, paramAnonymousFloat1, paramAnonymousFloat2);
          AppMethodBeat.o(49743);
          return bool;
        }
        AppMethodBeat.o(49743);
        return false;
      }
    });
    this.mWI.setOnScrollPageListener(new com.tencent.mm.plugin.appbrand.widget.recentview.c()
    {
      public final void M(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(49744);
        ad.i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo onScrollPageChanged currentPage: %d, isAuto: %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        if ((AppBrandDesktopHalfItemView.f(AppBrandDesktopHalfItemView.this) != null) && (!paramAnonymousBoolean))
        {
          com.tencent.mm.plugin.appbrand.widget.recentview.b localb;
          if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.nmT)
          {
            localb = AppBrandDesktopHalfItemView.f(AppBrandDesktopHalfItemView.this);
            ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo scrollRecentList");
            localb.nnc += 1;
            AppMethodBeat.o(49744);
            return;
          }
          if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.nmU)
          {
            localb = AppBrandDesktopHalfItemView.f(AppBrandDesktopHalfItemView.this);
            ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo scrollStarList");
            localb.nno += 1;
          }
        }
        AppMethodBeat.o(49744);
      }
    });
    this.mWI.setOnBindCustomViewHolderListener(new ConversationAppBrandRecentView.a()
    {
      public final void a(BaseAppBrandRecentView.b paramAnonymousb, int paramAnonymousInt)
      {
        AppMethodBeat.i(49745);
        if ((AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this) != null) && (AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).atQ == paramAnonymousInt) && (AppBrandDesktopHalfItemView.h(AppBrandDesktopHalfItemView.this)) && (paramAnonymousb != null) && (paramAnonymousb.auu != null))
        {
          ad.i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo ScaleAndAlphaAnimation set to default position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).mZG = paramAnonymousb;
          AppBrandDesktopHalfItemView.i(AppBrandDesktopHalfItemView.this);
        }
        AppMethodBeat.o(49745);
      }
    });
    AppMethodBeat.o(49750);
  }
  
  private void setToDefaultStatus(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49754);
    if ((paramw instanceof BaseAppBrandRecentView.b))
    {
      paramw.auu.setAlpha(0.0F);
      paramw.auu.setScaleX(0.95F);
      paramw.auu.setScaleY(0.95F);
    }
    AppMethodBeat.o(49754);
  }
  
  public final void a(AppBrandRecentView.f paramf)
  {
    AppMethodBeat.i(49747);
    this.mZx = paramf;
    if (this.mZx == AppBrandRecentView.f.nmT)
    {
      this.mZo.setText(getResources().getString(2131762214));
      this.mWI.setType(this.mZx);
      this.mWI.setItemAnimator(new com.tencent.mm.plugin.appbrand.widget.desktop.c(this.mWI, true));
      this.mWI.setDataQuery(new AppBrandRecentView.c()
      {
        public final List wh(int paramAnonymousInt)
        {
          AppMethodBeat.i(49734);
          List localList = ((ai)g.ab(ai.class)).rY(paramAnonymousInt);
          AppMethodBeat.o(49734);
          return localList;
        }
      });
      AppMethodBeat.o(49747);
      return;
    }
    if (this.mZx == AppBrandRecentView.f.nmU)
    {
      setTitle(getResources().getString(2131761482));
      this.mWI.setType(this.mZx);
      this.mWI.setItemAnimator(new com.tencent.mm.plugin.appbrand.widget.desktop.c(this.mWI, false));
      this.mWI.setDataQuery(new AppBrandRecentView.c()
      {
        public final List wh(int paramAnonymousInt)
        {
          AppMethodBeat.i(49737);
          List localList = ((ah)g.ab(ah.class)).a(paramAnonymousInt, ah.a.jPV);
          AppMethodBeat.o(49737);
          return localList;
        }
      });
    }
    AppMethodBeat.o(49747);
  }
  
  public final void a(e.b paramb)
  {
    AppMethodBeat.i(49767);
    Object localObject = this.mWI;
    if (((BaseAppBrandRecentView)localObject).nnS != null)
    {
      localObject = ((BaseAppBrandRecentView)localObject).nnS;
      ((e)localObject).noI = true;
      ((e)localObject).a(0, paramb, true);
    }
    AppMethodBeat.o(49767);
  }
  
  public final void bDt()
  {
    AppMethodBeat.i(49768);
    Object localObject = this.mWI;
    if (((BaseAppBrandRecentView)localObject).nnS != null)
    {
      localObject = ((BaseAppBrandRecentView)localObject).nnS;
      RecyclerView.i locali = ((e)localObject).noA.getLayoutManager();
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(locali, locala.ahp(), "com/tencent/mm/plugin/appbrand/widget/recentview/ViewPagerHelper", "resetToFirstPage", "()V", "Undefined", "scrollToPosition", "(I)V");
      locali.ca(((Integer)locala.mq(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(locali, "com/tencent/mm/plugin/appbrand/widget/recentview/ViewPagerHelper", "resetToFirstPage", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((e)localObject).mOffsetX = 0;
      ((e)localObject).noB = 0;
      ((e)localObject).noC = 0;
      ((e)localObject).nih = 0;
    }
    AppMethodBeat.o(49768);
  }
  
  public final void e(Configuration paramConfiguration)
  {
    AppMethodBeat.i(49752);
    ad.i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo HalfItemView onConfigurationChanged orientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    if (this.gOl != paramConfiguration.orientation)
    {
      Object localObject = this.mWI;
      int i = ((RecyclerView)localObject).getItemDecorationCount();
      if (i <= 0)
      {
        paramConfiguration = new IndexOutOfBoundsException("0 is an invalid index for size ".concat(String.valueOf(i)));
        AppMethodBeat.o(49752);
        throw paramConfiguration;
      }
      localObject = (RecyclerView.h)((RecyclerView)localObject).arT.get(0);
      if ((localObject != null) && ((localObject instanceof a))) {
        ((a)localObject).padding = d.dY(this.mContext);
      }
      this.mWI.getAdapter().asY.notifyChanged();
    }
    this.gOl = paramConfiguration.orientation;
    AppMethodBeat.o(49752);
  }
  
  public int getCustomCount()
  {
    AppMethodBeat.i(49763);
    int i = this.mWI.getCustomItemCount();
    AppMethodBeat.o(49763);
    return i;
  }
  
  public int getDataCount()
  {
    AppMethodBeat.i(49762);
    int i = this.mWI.getDataCount();
    AppMethodBeat.o(49762);
    return i;
  }
  
  public List<com.tencent.mm.plugin.appbrand.widget.recentview.a> getPreviewList()
  {
    AppMethodBeat.i(49761);
    List localList = this.mWI.getPreviewItemList();
    AppMethodBeat.o(49761);
    return localList;
  }
  
  public ConversationAppBrandRecentView getRecentView()
  {
    return this.mWI;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49751);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.mZC) && (this.mZp.getMeasuredWidth() != 0) && (this.mZp.getMeasuredHeight() != 0))
    {
      this.mZp.getLayoutParams().width = ((int)(this.mZp.getMeasuredWidth() * d.eb(getContext())));
      this.mZp.getLayoutParams().height = ((int)(this.mZp.getMeasuredHeight() * d.eb(getContext())));
      this.mZC = false;
    }
    AppMethodBeat.o(49751);
  }
  
  public void setCreateContextMenuListener(View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    AppMethodBeat.i(49764);
    this.mWI.setCreateContextMenuListener(paramOnCreateContextMenuListener);
    AppMethodBeat.o(49764);
  }
  
  public void setDataQuery(AppBrandRecentView.c paramc)
  {
    AppMethodBeat.i(49760);
    this.mWI.setDataQuery(paramc);
    AppMethodBeat.o(49760);
  }
  
  public void setEnableDataCache(boolean paramBoolean)
  {
    AppMethodBeat.i(49756);
    this.mWI.setEnableDataCache(paramBoolean);
    AppMethodBeat.o(49756);
  }
  
  public void setItemPadding(int paramInt)
  {
    this.mWv = paramInt;
  }
  
  public void setMenuItemSelectedListener(AppBrandRecentView.a parama)
  {
    AppMethodBeat.i(49765);
    this.mWI.setMenuItemSelectedListener(parama);
    AppMethodBeat.o(49765);
  }
  
  public void setOnDataChangedListener(AppBrandRecentView.d paramd)
  {
    AppMethodBeat.i(49766);
    this.mWI.setOnDataChangedListener(paramd);
    AppMethodBeat.o(49766);
  }
  
  public void setOnItemClickListener(AppBrandRecentView.b paramb)
  {
    this.mZs = paramb;
  }
  
  public void setOnLaunchUIListener(a.b paramb)
  {
    this.mZB = paramb;
  }
  
  public void setRefreshListener(AppBrandRecentView.e parame)
  {
    AppMethodBeat.i(49755);
    this.mWI.setRefreshListener(parame);
    AppMethodBeat.o(49755);
  }
  
  public void setReporter(com.tencent.mm.plugin.appbrand.widget.recentview.b paramb)
  {
    this.mZt = paramb;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(49757);
    this.mZo.setText(paramString);
    AppMethodBeat.o(49757);
  }
  
  public void setTitlePadding(Rect paramRect)
  {
    AppMethodBeat.i(49759);
    if (paramRect != null) {
      this.mZo.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    }
    AppMethodBeat.o(49759);
  }
  
  public void setTitlePaddingLeft(int paramInt)
  {
    AppMethodBeat.i(49758);
    if (this.mZo != null)
    {
      TextView localTextView = this.mZo;
      localTextView.setPadding(paramInt, localTextView.getPaddingTop(), this.mZo.getPaddingRight(), this.mZo.getPaddingBottom());
    }
    AppMethodBeat.o(49758);
  }
  
  final class a
  {
    int atQ = -1;
    int mZF = -1;
    RecyclerView.w mZG = null;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView
 * JD-Core Version:    0.7.0.1
 */