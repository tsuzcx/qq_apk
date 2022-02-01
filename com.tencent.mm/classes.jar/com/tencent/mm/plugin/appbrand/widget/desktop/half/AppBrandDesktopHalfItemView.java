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
import com.tencent.mm.plugin.appbrand.service.r;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.List;

public class AppBrandDesktopHalfItemView
  extends LinearLayout
{
  private RecyclerView.m asH;
  private int gQT;
  private Context mContext;
  private int nbB;
  ConversationAppBrandRecentView nbO;
  private int ndW;
  private AppBrandRecentView.b neA;
  private com.tencent.mm.plugin.appbrand.widget.recentview.b neB;
  private LinearLayout neC;
  private FrameLayout neD;
  private View neE;
  private AppBrandRecentView.f neF;
  private float neG;
  a neH;
  boolean neI;
  private a.b neJ;
  private boolean neK;
  private Animator.AnimatorListener neL;
  private TextView jdField_new;
  private ImageView nex;
  private AppBrandRecentView.e ney;
  RecyclerView.c nez;
  
  public AppBrandDesktopHalfItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49748);
    this.ney = null;
    this.nez = null;
    this.neA = null;
    this.asH = null;
    this.neB = null;
    this.neC = null;
    this.neD = null;
    this.neE = null;
    this.nbB = 0;
    this.ndW = 0;
    this.neG = 0.0F;
    this.neH = null;
    this.neI = false;
    this.neJ = null;
    this.neK = true;
    this.gQT = 1;
    this.neL = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(49735);
        if ((AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this) != null) && (AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).neO != null) && (AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).neO.auu != null) && ((AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).neO instanceof BaseAppBrandRecentView.b))) {
          ((BaseAppBrandRecentView.b)AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).neO).titleTv.setVisibility(0);
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
    this.ney = null;
    this.nez = null;
    this.neA = null;
    this.asH = null;
    this.neB = null;
    this.neC = null;
    this.neD = null;
    this.neE = null;
    this.nbB = 0;
    this.ndW = 0;
    this.neG = 0.0F;
    this.neH = null;
    this.neI = false;
    this.neJ = null;
    this.neK = true;
    this.gQT = 1;
    this.neL = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(49735);
        if ((AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this) != null) && (AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).neO != null) && (AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).neO.auu != null) && ((AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).neO instanceof BaseAppBrandRecentView.b))) {
          ((BaseAppBrandRecentView.b)AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).neO).titleTv.setVisibility(0);
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
  
  private void bEk()
  {
    AppMethodBeat.i(49753);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(getContext().getResources().getDisplayMetrics().widthPixels * 2, -2);
    this.neC.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(49753);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49750);
    this.mContext = paramContext;
    paramContext = z.jV(this.mContext).inflate(2131492985, this);
    this.jdField_new = ((TextView)paramContext.findViewById(2131296703));
    this.jdField_new.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(49738);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/half/AppBrandDesktopHalfItemView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.nse)
        {
          ((r)g.ab(r.class)).dk(AppBrandDesktopHalfItemView.this.getContext());
          if (AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this) != null) {
            AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this).bEx();
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/half/AppBrandDesktopHalfItemView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(49738);
          return;
          if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.nsd)
          {
            ((r)g.ab(r.class)).d(AppBrandDesktopHalfItemView.this.getContext(), 3, 0);
            if (AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this) != null) {
              AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this).bEy();
            }
          }
        }
      }
    });
    this.nex = ((ImageView)paramContext.findViewById(2131296702));
    this.nex.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(49739);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/widget/desktop/half/AppBrandDesktopHalfItemView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.nse)
        {
          ((r)g.ab(r.class)).dk(AppBrandDesktopHalfItemView.this.getContext());
          if (AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this) != null) {
            AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this).bEx();
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/widget/desktop/half/AppBrandDesktopHalfItemView$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(49739);
          return;
          if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.nsd)
          {
            ((r)g.ab(r.class)).d(AppBrandDesktopHalfItemView.this.getContext(), 3, 0);
            if (AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this) != null) {
              AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this).bEy();
            }
          }
        }
      }
    });
    this.neD = ((FrameLayout)paramContext.findViewById(2131296704));
    this.neC = ((LinearLayout)paramContext.findViewById(2131300139));
    bEk();
    this.nbO = ((ConversationAppBrandRecentView)paramContext.findViewById(2131296701));
    this.nbO.setRefreshListener(new AppBrandRecentView.e()
    {
      public final void uT(int paramAnonymousInt)
      {
        AppMethodBeat.i(49740);
        if (AppBrandDesktopHalfItemView.c(AppBrandDesktopHalfItemView.this) != null) {
          AppBrandDesktopHalfItemView.c(AppBrandDesktopHalfItemView.this).uT(paramAnonymousInt);
        }
        AppMethodBeat.o(49740);
      }
    });
    this.nbO.getAdapter().a(new RecyclerView.c()
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
    this.nbO.setOnItemClickListener(new AppBrandRecentView.b()
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
    this.nbO.setOnScrollPageListener(new com.tencent.mm.plugin.appbrand.widget.recentview.c()
    {
      public final void N(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(49744);
        ae.i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo onScrollPageChanged currentPage: %d, isAuto: %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        if ((AppBrandDesktopHalfItemView.f(AppBrandDesktopHalfItemView.this) != null) && (!paramAnonymousBoolean))
        {
          com.tencent.mm.plugin.appbrand.widget.recentview.b localb;
          if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.nsd)
          {
            localb = AppBrandDesktopHalfItemView.f(AppBrandDesktopHalfItemView.this);
            ae.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo scrollRecentList");
            localb.nsm += 1;
            AppMethodBeat.o(49744);
            return;
          }
          if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.nse)
          {
            localb = AppBrandDesktopHalfItemView.f(AppBrandDesktopHalfItemView.this);
            ae.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo scrollStarList");
            localb.nsy += 1;
          }
        }
        AppMethodBeat.o(49744);
      }
    });
    this.nbO.setOnBindCustomViewHolderListener(new ConversationAppBrandRecentView.a()
    {
      public final void a(BaseAppBrandRecentView.b paramAnonymousb, int paramAnonymousInt)
      {
        AppMethodBeat.i(49745);
        if ((AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this) != null) && (AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).atQ == paramAnonymousInt) && (AppBrandDesktopHalfItemView.h(AppBrandDesktopHalfItemView.this)) && (paramAnonymousb != null) && (paramAnonymousb.auu != null))
        {
          ae.i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo ScaleAndAlphaAnimation set to default position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).neO = paramAnonymousb;
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
    this.neF = paramf;
    if (this.neF == AppBrandRecentView.f.nsd)
    {
      this.jdField_new.setText(getResources().getString(2131762214));
      this.nbO.setType(this.neF);
      this.nbO.setItemAnimator(new com.tencent.mm.plugin.appbrand.widget.desktop.c(this.nbO, true));
      this.nbO.setDataQuery(new AppBrandRecentView.c()
      {
        public final List wm(int paramAnonymousInt)
        {
          AppMethodBeat.i(49734);
          List localList = ((ai)g.ab(ai.class)).sb(paramAnonymousInt);
          AppMethodBeat.o(49734);
          return localList;
        }
      });
      AppMethodBeat.o(49747);
      return;
    }
    if (this.neF == AppBrandRecentView.f.nse)
    {
      setTitle(getResources().getString(2131761482));
      this.nbO.setType(this.neF);
      this.nbO.setItemAnimator(new com.tencent.mm.plugin.appbrand.widget.desktop.c(this.nbO, false));
      this.nbO.setDataQuery(new AppBrandRecentView.c()
      {
        public final List wm(int paramAnonymousInt)
        {
          AppMethodBeat.i(49737);
          List localList = ((ah)g.ab(ah.class)).a(paramAnonymousInt, ah.a.jTn);
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
    Object localObject = this.nbO;
    if (((BaseAppBrandRecentView)localObject).ntc != null)
    {
      localObject = ((BaseAppBrandRecentView)localObject).ntc;
      ((e)localObject).ntS = true;
      ((e)localObject).a(0, paramb, true);
    }
    AppMethodBeat.o(49767);
  }
  
  public final void bEl()
  {
    AppMethodBeat.i(49768);
    Object localObject = this.nbO;
    if (((BaseAppBrandRecentView)localObject).ntc != null)
    {
      localObject = ((BaseAppBrandRecentView)localObject).ntc;
      RecyclerView.i locali = ((e)localObject).ntK.getLayoutManager();
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(locali, locala.ahE(), "com/tencent/mm/plugin/appbrand/widget/recentview/ViewPagerHelper", "resetToFirstPage", "()V", "Undefined", "scrollToPosition", "(I)V");
      locali.ca(((Integer)locala.mt(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(locali, "com/tencent/mm/plugin/appbrand/widget/recentview/ViewPagerHelper", "resetToFirstPage", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((e)localObject).mOffsetX = 0;
      ((e)localObject).ntL = 0;
      ((e)localObject).ntM = 0;
      ((e)localObject).nnp = 0;
    }
    AppMethodBeat.o(49768);
  }
  
  public final void e(Configuration paramConfiguration)
  {
    AppMethodBeat.i(49752);
    ae.i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo HalfItemView onConfigurationChanged orientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    if (this.gQT != paramConfiguration.orientation)
    {
      Object localObject = this.nbO;
      int i = ((RecyclerView)localObject).getItemDecorationCount();
      if (i <= 0)
      {
        paramConfiguration = new IndexOutOfBoundsException("0 is an invalid index for size ".concat(String.valueOf(i)));
        AppMethodBeat.o(49752);
        throw paramConfiguration;
      }
      localObject = (RecyclerView.h)((RecyclerView)localObject).arT.get(0);
      if ((localObject != null) && ((localObject instanceof a))) {
        ((a)localObject).padding = d.ec(this.mContext);
      }
      this.nbO.getAdapter().asY.notifyChanged();
    }
    this.gQT = paramConfiguration.orientation;
    AppMethodBeat.o(49752);
  }
  
  public int getCustomCount()
  {
    AppMethodBeat.i(49763);
    int i = this.nbO.getCustomItemCount();
    AppMethodBeat.o(49763);
    return i;
  }
  
  public int getDataCount()
  {
    AppMethodBeat.i(49762);
    int i = this.nbO.getDataCount();
    AppMethodBeat.o(49762);
    return i;
  }
  
  public List<com.tencent.mm.plugin.appbrand.widget.recentview.a> getPreviewList()
  {
    AppMethodBeat.i(49761);
    List localList = this.nbO.getPreviewItemList();
    AppMethodBeat.o(49761);
    return localList;
  }
  
  public ConversationAppBrandRecentView getRecentView()
  {
    return this.nbO;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49751);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.neK) && (this.nex.getMeasuredWidth() != 0) && (this.nex.getMeasuredHeight() != 0))
    {
      this.nex.getLayoutParams().width = ((int)(this.nex.getMeasuredWidth() * d.ef(getContext())));
      this.nex.getLayoutParams().height = ((int)(this.nex.getMeasuredHeight() * d.ef(getContext())));
      this.neK = false;
    }
    AppMethodBeat.o(49751);
  }
  
  public void setCreateContextMenuListener(View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    AppMethodBeat.i(49764);
    this.nbO.setCreateContextMenuListener(paramOnCreateContextMenuListener);
    AppMethodBeat.o(49764);
  }
  
  public void setDataQuery(AppBrandRecentView.c paramc)
  {
    AppMethodBeat.i(49760);
    this.nbO.setDataQuery(paramc);
    AppMethodBeat.o(49760);
  }
  
  public void setEnableDataCache(boolean paramBoolean)
  {
    AppMethodBeat.i(49756);
    this.nbO.setEnableDataCache(paramBoolean);
    AppMethodBeat.o(49756);
  }
  
  public void setItemPadding(int paramInt)
  {
    this.nbB = paramInt;
  }
  
  public void setMenuItemSelectedListener(AppBrandRecentView.a parama)
  {
    AppMethodBeat.i(49765);
    this.nbO.setMenuItemSelectedListener(parama);
    AppMethodBeat.o(49765);
  }
  
  public void setOnDataChangedListener(AppBrandRecentView.d paramd)
  {
    AppMethodBeat.i(49766);
    this.nbO.setOnDataChangedListener(paramd);
    AppMethodBeat.o(49766);
  }
  
  public void setOnItemClickListener(AppBrandRecentView.b paramb)
  {
    this.neA = paramb;
  }
  
  public void setOnLaunchUIListener(a.b paramb)
  {
    this.neJ = paramb;
  }
  
  public void setRefreshListener(AppBrandRecentView.e parame)
  {
    AppMethodBeat.i(49755);
    this.nbO.setRefreshListener(parame);
    AppMethodBeat.o(49755);
  }
  
  public void setReporter(com.tencent.mm.plugin.appbrand.widget.recentview.b paramb)
  {
    this.neB = paramb;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(49757);
    this.jdField_new.setText(paramString);
    AppMethodBeat.o(49757);
  }
  
  public void setTitlePadding(Rect paramRect)
  {
    AppMethodBeat.i(49759);
    if (paramRect != null) {
      this.jdField_new.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    }
    AppMethodBeat.o(49759);
  }
  
  public void setTitlePaddingLeft(int paramInt)
  {
    AppMethodBeat.i(49758);
    if (this.jdField_new != null)
    {
      TextView localTextView = this.jdField_new;
      localTextView.setPadding(paramInt, localTextView.getPaddingTop(), this.jdField_new.getPaddingRight(), this.jdField_new.getPaddingBottom());
    }
    AppMethodBeat.o(49758);
  }
  
  final class a
  {
    int atQ = -1;
    int neN = -1;
    RecyclerView.w neO = null;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView
 * JD-Core Version:    0.7.0.1
 */