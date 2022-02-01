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
import android.support.v7.widget.RecyclerView.v;
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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.appusage.ah;
import com.tencent.mm.plugin.appbrand.appusage.ah.a;
import com.tencent.mm.plugin.appbrand.appusage.ai;
import com.tencent.mm.plugin.appbrand.service.p;
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
import com.tencent.mm.plugin.appbrand.widget.recentview.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.e.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.List;

public class AppBrandDesktopHalfItemView
  extends LinearLayout
{
  private RecyclerView.m apU;
  private int lTO;
  ConversationAppBrandRecentView lUb;
  private TextView lWE;
  private ImageView lWF;
  private AppBrandRecentView.e lWG;
  RecyclerView.c lWH;
  private AppBrandRecentView.b lWI;
  private b lWJ;
  private LinearLayout lWK;
  private FrameLayout lWL;
  private View lWM;
  private AppBrandRecentView.f lWN;
  private float lWO;
  a lWP;
  boolean lWQ;
  private a.b lWR;
  private boolean lWS;
  private Animator.AnimatorListener lWT;
  private int lWf;
  private int lgU;
  private Context mContext;
  
  public AppBrandDesktopHalfItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49748);
    this.lWG = null;
    this.lWH = null;
    this.lWI = null;
    this.apU = null;
    this.lWJ = null;
    this.lWK = null;
    this.lWL = null;
    this.lWM = null;
    this.lTO = 0;
    this.lWf = 0;
    this.lWO = 0.0F;
    this.lWP = null;
    this.lWQ = false;
    this.lWR = null;
    this.lWS = true;
    this.lgU = 1;
    this.lWT = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(49735);
        if ((AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this) != null) && (AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).lWW != null) && (AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).lWW.arI != null) && ((AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).lWW instanceof BaseAppBrandRecentView.b))) {
          ((BaseAppBrandRecentView.b)AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).lWW).titleTv.setVisibility(0);
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
    this.lWG = null;
    this.lWH = null;
    this.lWI = null;
    this.apU = null;
    this.lWJ = null;
    this.lWK = null;
    this.lWL = null;
    this.lWM = null;
    this.lTO = 0;
    this.lWf = 0;
    this.lWO = 0.0F;
    this.lWP = null;
    this.lWQ = false;
    this.lWR = null;
    this.lWS = true;
    this.lgU = 1;
    this.lWT = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(49735);
        if ((AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this) != null) && (AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).lWW != null) && (AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).lWW.arI != null) && ((AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).lWW instanceof BaseAppBrandRecentView.b))) {
          ((BaseAppBrandRecentView.b)AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).lWW).titleTv.setVisibility(0);
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
  
  private void bso()
  {
    AppMethodBeat.i(49753);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(getContext().getResources().getDisplayMetrics().widthPixels * 2, -2);
    this.lWK.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(49753);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49750);
    this.mContext = paramContext;
    paramContext = y.js(this.mContext).inflate(2131492985, this);
    this.lWE = ((TextView)paramContext.findViewById(2131296703));
    this.lWE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(49738);
        if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.mkx)
        {
          ((p)g.ab(p.class)).db(AppBrandDesktopHalfItemView.this.getContext());
          if (AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this) != null)
          {
            AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this).bsC();
            AppMethodBeat.o(49738);
          }
        }
        else if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.mkw)
        {
          ((p)g.ab(p.class)).b(AppBrandDesktopHalfItemView.this.getContext(), 3, 0);
          if (AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this) != null) {
            AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this).bsD();
          }
        }
        AppMethodBeat.o(49738);
      }
    });
    this.lWF = ((ImageView)paramContext.findViewById(2131296702));
    this.lWF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(49739);
        if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.mkx)
        {
          ((p)g.ab(p.class)).db(AppBrandDesktopHalfItemView.this.getContext());
          if (AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this) != null)
          {
            AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this).bsC();
            AppMethodBeat.o(49739);
          }
        }
        else if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.mkw)
        {
          ((p)g.ab(p.class)).b(AppBrandDesktopHalfItemView.this.getContext(), 3, 0);
          if (AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this) != null) {
            AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this).bsD();
          }
        }
        AppMethodBeat.o(49739);
      }
    });
    this.lWL = ((FrameLayout)paramContext.findViewById(2131296704));
    this.lWK = ((LinearLayout)paramContext.findViewById(2131300139));
    bso();
    this.lUb = ((ConversationAppBrandRecentView)paramContext.findViewById(2131296701));
    this.lUb.setRefreshListener(new AppBrandRecentView.e()
    {
      public final void tu(int paramAnonymousInt)
      {
        AppMethodBeat.i(49740);
        if (AppBrandDesktopHalfItemView.c(AppBrandDesktopHalfItemView.this) != null) {
          AppBrandDesktopHalfItemView.c(AppBrandDesktopHalfItemView.this).tu(paramAnonymousInt);
        }
        AppMethodBeat.o(49740);
      }
    });
    this.lUb.getAdapter().a(new RecyclerView.c()
    {
      public final void au(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(49741);
        super.au(paramAnonymousInt1, paramAnonymousInt2);
        if (AppBrandDesktopHalfItemView.d(AppBrandDesktopHalfItemView.this) != null) {
          AppBrandDesktopHalfItemView.d(AppBrandDesktopHalfItemView.this).au(paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(49741);
      }
    });
    this.lUb.setOnItemClickListener(new AppBrandRecentView.b()
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
    this.lUb.setOnScrollPageListener(new com.tencent.mm.plugin.appbrand.widget.recentview.c()
    {
      public final void M(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(49744);
        ad.i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo onScrollPageChanged currentPage: %d, isAuto: %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        if ((AppBrandDesktopHalfItemView.f(AppBrandDesktopHalfItemView.this) != null) && (!paramAnonymousBoolean))
        {
          b localb;
          if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.mkw)
          {
            localb = AppBrandDesktopHalfItemView.f(AppBrandDesktopHalfItemView.this);
            ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo scrollRecentList");
            localb.mkF += 1;
            AppMethodBeat.o(49744);
            return;
          }
          if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.mkx)
          {
            localb = AppBrandDesktopHalfItemView.f(AppBrandDesktopHalfItemView.this);
            ad.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo scrollStarList");
            localb.mkR += 1;
          }
        }
        AppMethodBeat.o(49744);
      }
    });
    this.lUb.setOnBindCustomViewHolderListener(new ConversationAppBrandRecentView.a()
    {
      public final void a(BaseAppBrandRecentView.b paramAnonymousb, int paramAnonymousInt)
      {
        AppMethodBeat.i(49745);
        if ((AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this) != null) && (AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).ard == paramAnonymousInt) && (AppBrandDesktopHalfItemView.h(AppBrandDesktopHalfItemView.this)) && (paramAnonymousb != null) && (paramAnonymousb.arI != null))
        {
          ad.i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo ScaleAndAlphaAnimation set to default position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).lWW = paramAnonymousb;
          AppBrandDesktopHalfItemView.i(AppBrandDesktopHalfItemView.this);
        }
        AppMethodBeat.o(49745);
      }
    });
    AppMethodBeat.o(49750);
  }
  
  private void setToDefaultStatus(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49754);
    if ((paramv instanceof BaseAppBrandRecentView.b))
    {
      paramv.arI.setAlpha(0.0F);
      paramv.arI.setScaleX(0.95F);
      paramv.arI.setScaleY(0.95F);
    }
    AppMethodBeat.o(49754);
  }
  
  public final void a(AppBrandRecentView.f paramf)
  {
    AppMethodBeat.i(49747);
    this.lWN = paramf;
    if (this.lWN == AppBrandRecentView.f.mkw)
    {
      this.lWE.setText(getResources().getString(2131762214));
      this.lUb.setType(this.lWN);
      this.lUb.setItemAnimator(new com.tencent.mm.plugin.appbrand.widget.desktop.c(this.lUb, true));
      this.lUb.setDataQuery(new AppBrandRecentView.c()
      {
        public final List uK(int paramAnonymousInt)
        {
          AppMethodBeat.i(49734);
          List localList = ((ai)g.ab(ai.class)).qL(paramAnonymousInt);
          AppMethodBeat.o(49734);
          return localList;
        }
      });
      AppMethodBeat.o(49747);
      return;
    }
    if (this.lWN == AppBrandRecentView.f.mkx)
    {
      setTitle(getResources().getString(2131761482));
      this.lUb.setType(this.lWN);
      this.lUb.setItemAnimator(new com.tencent.mm.plugin.appbrand.widget.desktop.c(this.lUb, false));
      this.lUb.setDataQuery(new AppBrandRecentView.c()
      {
        public final List uK(int paramAnonymousInt)
        {
          AppMethodBeat.i(49737);
          List localList = ((ah)g.ab(ah.class)).a(paramAnonymousInt, ah.a.iVL);
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
    Object localObject = this.lUb;
    if (((BaseAppBrandRecentView)localObject).mlv != null)
    {
      localObject = ((BaseAppBrandRecentView)localObject).mlv;
      ((e)localObject).mmk = true;
      ((e)localObject).a(0, paramb, true);
    }
    AppMethodBeat.o(49767);
  }
  
  public final void bsp()
  {
    AppMethodBeat.i(49768);
    Object localObject = this.lUb;
    if (((BaseAppBrandRecentView)localObject).mlv != null)
    {
      localObject = ((BaseAppBrandRecentView)localObject).mlv;
      RecyclerView.i locali = ((e)localObject).mmc.getLayoutManager();
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(locali, locala.adn(), "com/tencent/mm/plugin/appbrand/widget/recentview/ViewPagerHelper", "resetToFirstPage", "()V", "Undefined", "scrollToPosition", "(I)V");
      locali.ca(((Integer)locala.lS(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(locali, "com/tencent/mm/plugin/appbrand/widget/recentview/ViewPagerHelper", "resetToFirstPage", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((e)localObject).mOffsetX = 0;
      ((e)localObject).mmd = 0;
      ((e)localObject).mme = 0;
      ((e)localObject).mfK = 0;
    }
    AppMethodBeat.o(49768);
  }
  
  public final void e(Configuration paramConfiguration)
  {
    AppMethodBeat.i(49752);
    ad.i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo HalfItemView onConfigurationChanged orientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    if (this.lgU != paramConfiguration.orientation)
    {
      Object localObject = this.lUb;
      int i = ((RecyclerView)localObject).getItemDecorationCount();
      if (i <= 0)
      {
        paramConfiguration = new IndexOutOfBoundsException("0 is an invalid index for size ".concat(String.valueOf(i)));
        AppMethodBeat.o(49752);
        throw paramConfiguration;
      }
      localObject = (RecyclerView.h)((RecyclerView)localObject).apf.get(0);
      if ((localObject != null) && ((localObject instanceof a))) {
        ((a)localObject).padding = d.dQ(this.mContext);
      }
      this.lUb.getAdapter().aql.notifyChanged();
    }
    this.lgU = paramConfiguration.orientation;
    AppMethodBeat.o(49752);
  }
  
  public int getCustomCount()
  {
    AppMethodBeat.i(49763);
    int i = this.lUb.getCustomItemCount();
    AppMethodBeat.o(49763);
    return i;
  }
  
  public int getDataCount()
  {
    AppMethodBeat.i(49762);
    int i = this.lUb.getDataCount();
    AppMethodBeat.o(49762);
    return i;
  }
  
  public List<com.tencent.mm.plugin.appbrand.widget.recentview.a> getPreviewList()
  {
    AppMethodBeat.i(49761);
    List localList = this.lUb.getPreviewItemList();
    AppMethodBeat.o(49761);
    return localList;
  }
  
  public ConversationAppBrandRecentView getRecentView()
  {
    return this.lUb;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49751);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.lWS) && (this.lWF.getMeasuredWidth() != 0) && (this.lWF.getMeasuredHeight() != 0))
    {
      this.lWF.getLayoutParams().width = ((int)(this.lWF.getMeasuredWidth() * d.dT(getContext())));
      this.lWF.getLayoutParams().height = ((int)(this.lWF.getMeasuredHeight() * d.dT(getContext())));
      this.lWS = false;
    }
    AppMethodBeat.o(49751);
  }
  
  public void setCreateContextMenuListener(View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    AppMethodBeat.i(49764);
    this.lUb.setCreateContextMenuListener(paramOnCreateContextMenuListener);
    AppMethodBeat.o(49764);
  }
  
  public void setDataQuery(AppBrandRecentView.c paramc)
  {
    AppMethodBeat.i(49760);
    this.lUb.setDataQuery(paramc);
    AppMethodBeat.o(49760);
  }
  
  public void setEnableDataCache(boolean paramBoolean)
  {
    AppMethodBeat.i(49756);
    this.lUb.setEnableDataCache(paramBoolean);
    AppMethodBeat.o(49756);
  }
  
  public void setItemPadding(int paramInt)
  {
    this.lTO = paramInt;
  }
  
  public void setMenuItemSelectedListener(AppBrandRecentView.a parama)
  {
    AppMethodBeat.i(49765);
    this.lUb.setMenuItemSelectedListener(parama);
    AppMethodBeat.o(49765);
  }
  
  public void setOnDataChangedListener(AppBrandRecentView.d paramd)
  {
    AppMethodBeat.i(49766);
    this.lUb.setOnDataChangedListener(paramd);
    AppMethodBeat.o(49766);
  }
  
  public void setOnItemClickListener(AppBrandRecentView.b paramb)
  {
    this.lWI = paramb;
  }
  
  public void setOnLaunchUIListener(a.b paramb)
  {
    this.lWR = paramb;
  }
  
  public void setRefreshListener(AppBrandRecentView.e parame)
  {
    AppMethodBeat.i(49755);
    this.lUb.setRefreshListener(parame);
    AppMethodBeat.o(49755);
  }
  
  public void setReporter(b paramb)
  {
    this.lWJ = paramb;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(49757);
    this.lWE.setText(paramString);
    AppMethodBeat.o(49757);
  }
  
  public void setTitlePadding(Rect paramRect)
  {
    AppMethodBeat.i(49759);
    if (paramRect != null) {
      this.lWE.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    }
    AppMethodBeat.o(49759);
  }
  
  public void setTitlePaddingLeft(int paramInt)
  {
    AppMethodBeat.i(49758);
    if (this.lWE != null)
    {
      TextView localTextView = this.lWE;
      localTextView.setPadding(paramInt, localTextView.getPaddingTop(), this.lWE.getPaddingRight(), this.lWE.getPaddingBottom());
    }
    AppMethodBeat.o(49758);
  }
  
  final class a
  {
    int ard = -1;
    int lWV = -1;
    RecyclerView.v lWW = null;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView
 * JD-Core Version:    0.7.0.1
 */