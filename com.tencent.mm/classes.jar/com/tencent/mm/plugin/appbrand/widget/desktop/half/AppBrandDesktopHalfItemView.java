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
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.z;
import java.util.ArrayList;
import java.util.List;

public class AppBrandDesktopHalfItemView
  extends LinearLayout
{
  private RecyclerView.m aqP;
  private int guA;
  private Context mContext;
  private int mvQ;
  ConversationAppBrandRecentView mwd;
  private TextView myG;
  private ImageView myH;
  private AppBrandRecentView.e myI;
  RecyclerView.c myJ;
  private AppBrandRecentView.b myK;
  private b myL;
  private LinearLayout myM;
  private FrameLayout myN;
  private View myO;
  private AppBrandRecentView.f myP;
  private float myQ;
  a myR;
  boolean myS;
  private a.b myT;
  private boolean myU;
  private Animator.AnimatorListener myV;
  private int myh;
  
  public AppBrandDesktopHalfItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49748);
    this.myI = null;
    this.myJ = null;
    this.myK = null;
    this.aqP = null;
    this.myL = null;
    this.myM = null;
    this.myN = null;
    this.myO = null;
    this.mvQ = 0;
    this.myh = 0;
    this.myQ = 0.0F;
    this.myR = null;
    this.myS = false;
    this.myT = null;
    this.myU = true;
    this.guA = 1;
    this.myV = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(49735);
        if ((AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this) != null) && (AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).myY != null) && (AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).myY.asD != null) && ((AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).myY instanceof BaseAppBrandRecentView.b))) {
          ((BaseAppBrandRecentView.b)AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).myY).titleTv.setVisibility(0);
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
    this.myI = null;
    this.myJ = null;
    this.myK = null;
    this.aqP = null;
    this.myL = null;
    this.myM = null;
    this.myN = null;
    this.myO = null;
    this.mvQ = 0;
    this.myh = 0;
    this.myQ = 0.0F;
    this.myR = null;
    this.myS = false;
    this.myT = null;
    this.myU = true;
    this.guA = 1;
    this.myV = new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(49735);
        if ((AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this) != null) && (AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).myY != null) && (AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).myY.asD != null) && ((AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).myY instanceof BaseAppBrandRecentView.b))) {
          ((BaseAppBrandRecentView.b)AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).myY).titleTv.setVisibility(0);
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
  
  private void bzo()
  {
    AppMethodBeat.i(49753);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(getContext().getResources().getDisplayMetrics().widthPixels * 2, -2);
    this.myM.setLayoutParams(localLayoutParams);
    AppMethodBeat.o(49753);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(49750);
    this.mContext = paramContext;
    paramContext = z.jD(this.mContext).inflate(2131492985, this);
    this.myG = ((TextView)paramContext.findViewById(2131296703));
    this.myG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(49738);
        if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.mMy)
        {
          ((p)g.ab(p.class)).dk(AppBrandDesktopHalfItemView.this.getContext());
          if (AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this) != null)
          {
            AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this).bzC();
            AppMethodBeat.o(49738);
          }
        }
        else if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.mMx)
        {
          ((p)g.ab(p.class)).d(AppBrandDesktopHalfItemView.this.getContext(), 3, 0);
          if (AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this) != null) {
            AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this).bzD();
          }
        }
        AppMethodBeat.o(49738);
      }
    });
    this.myH = ((ImageView)paramContext.findViewById(2131296702));
    this.myH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(49739);
        if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.mMy)
        {
          ((p)g.ab(p.class)).dk(AppBrandDesktopHalfItemView.this.getContext());
          if (AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this) != null)
          {
            AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this).bzC();
            AppMethodBeat.o(49739);
          }
        }
        else if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.mMx)
        {
          ((p)g.ab(p.class)).d(AppBrandDesktopHalfItemView.this.getContext(), 3, 0);
          if (AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this) != null) {
            AppBrandDesktopHalfItemView.b(AppBrandDesktopHalfItemView.this).bzD();
          }
        }
        AppMethodBeat.o(49739);
      }
    });
    this.myN = ((FrameLayout)paramContext.findViewById(2131296704));
    this.myM = ((LinearLayout)paramContext.findViewById(2131300139));
    bzo();
    this.mwd = ((ConversationAppBrandRecentView)paramContext.findViewById(2131296701));
    this.mwd.setRefreshListener(new AppBrandRecentView.e()
    {
      public final void ul(int paramAnonymousInt)
      {
        AppMethodBeat.i(49740);
        if (AppBrandDesktopHalfItemView.c(AppBrandDesktopHalfItemView.this) != null) {
          AppBrandDesktopHalfItemView.c(AppBrandDesktopHalfItemView.this).ul(paramAnonymousInt);
        }
        AppMethodBeat.o(49740);
      }
    });
    this.mwd.getAdapter().a(new RecyclerView.c()
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
    this.mwd.setOnItemClickListener(new AppBrandRecentView.b()
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
    this.mwd.setOnScrollPageListener(new com.tencent.mm.plugin.appbrand.widget.recentview.c()
    {
      public final void M(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(49744);
        ac.i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo onScrollPageChanged currentPage: %d, isAuto: %b", new Object[] { Integer.valueOf(paramAnonymousInt), Boolean.valueOf(paramAnonymousBoolean) });
        if ((AppBrandDesktopHalfItemView.f(AppBrandDesktopHalfItemView.this) != null) && (!paramAnonymousBoolean))
        {
          b localb;
          if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.mMx)
          {
            localb = AppBrandDesktopHalfItemView.f(AppBrandDesktopHalfItemView.this);
            ac.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo scrollRecentList");
            localb.mMG += 1;
            AppMethodBeat.o(49744);
            return;
          }
          if (AppBrandDesktopHalfItemView.a(AppBrandDesktopHalfItemView.this) == AppBrandRecentView.f.mMy)
          {
            localb = AppBrandDesktopHalfItemView.f(AppBrandDesktopHalfItemView.this);
            ac.v("MicroMsg.AppBrandRecentViewReporter", "alvinluo scrollStarList");
            localb.mMS += 1;
          }
        }
        AppMethodBeat.o(49744);
      }
    });
    this.mwd.setOnBindCustomViewHolderListener(new ConversationAppBrandRecentView.a()
    {
      public final void a(BaseAppBrandRecentView.b paramAnonymousb, int paramAnonymousInt)
      {
        AppMethodBeat.i(49745);
        if ((AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this) != null) && (AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).arZ == paramAnonymousInt) && (AppBrandDesktopHalfItemView.h(AppBrandDesktopHalfItemView.this)) && (paramAnonymousb != null) && (paramAnonymousb.asD != null))
        {
          ac.i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo ScaleAndAlphaAnimation set to default position: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          AppBrandDesktopHalfItemView.g(AppBrandDesktopHalfItemView.this).myY = paramAnonymousb;
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
      paramw.asD.setAlpha(0.0F);
      paramw.asD.setScaleX(0.95F);
      paramw.asD.setScaleY(0.95F);
    }
    AppMethodBeat.o(49754);
  }
  
  public final void a(AppBrandRecentView.f paramf)
  {
    AppMethodBeat.i(49747);
    this.myP = paramf;
    if (this.myP == AppBrandRecentView.f.mMx)
    {
      this.myG.setText(getResources().getString(2131762214));
      this.mwd.setType(this.myP);
      this.mwd.setItemAnimator(new com.tencent.mm.plugin.appbrand.widget.desktop.c(this.mwd, true));
      this.mwd.setDataQuery(new AppBrandDesktopHalfItemView.1(this));
      AppMethodBeat.o(49747);
      return;
    }
    if (this.myP == AppBrandRecentView.f.mMy)
    {
      setTitle(getResources().getString(2131761482));
      this.mwd.setType(this.myP);
      this.mwd.setItemAnimator(new com.tencent.mm.plugin.appbrand.widget.desktop.c(this.mwd, false));
      this.mwd.setDataQuery(new AppBrandDesktopHalfItemView.4(this));
    }
    AppMethodBeat.o(49747);
  }
  
  public final void a(e.b paramb)
  {
    AppMethodBeat.i(49767);
    Object localObject = this.mwd;
    if (((BaseAppBrandRecentView)localObject).mNw != null)
    {
      localObject = ((BaseAppBrandRecentView)localObject).mNw;
      ((e)localObject).mOl = true;
      ((e)localObject).a(0, paramb, true);
    }
    AppMethodBeat.o(49767);
  }
  
  public final void bzp()
  {
    AppMethodBeat.i(49768);
    Object localObject = this.mwd;
    if (((BaseAppBrandRecentView)localObject).mNw != null)
    {
      localObject = ((BaseAppBrandRecentView)localObject).mNw;
      RecyclerView.i locali = ((e)localObject).mOd.getLayoutManager();
      com.tencent.mm.hellhoundlib.b.a locala = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
      com.tencent.mm.hellhoundlib.a.a.a(locali, locala.aeD(), "com/tencent/mm/plugin/appbrand/widget/recentview/ViewPagerHelper", "resetToFirstPage", "()V", "Undefined", "scrollToPosition", "(I)V");
      locali.ca(((Integer)locala.lR(0)).intValue());
      com.tencent.mm.hellhoundlib.a.a.a(locali, "com/tencent/mm/plugin/appbrand/widget/recentview/ViewPagerHelper", "resetToFirstPage", "()V", "Undefined", "scrollToPosition", "(I)V");
      ((e)localObject).mOffsetX = 0;
      ((e)localObject).mOe = 0;
      ((e)localObject).mOf = 0;
      ((e)localObject).mHJ = 0;
    }
    AppMethodBeat.o(49768);
  }
  
  public final void e(Configuration paramConfiguration)
  {
    AppMethodBeat.i(49752);
    ac.i("MicroMsg.AppBrandDesktopHalfItemView", "alvinluo HalfItemView onConfigurationChanged orientation: %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    if (this.guA != paramConfiguration.orientation)
    {
      Object localObject = this.mwd;
      int i = ((RecyclerView)localObject).getItemDecorationCount();
      if (i <= 0)
      {
        paramConfiguration = new IndexOutOfBoundsException("0 is an invalid index for size ".concat(String.valueOf(i)));
        AppMethodBeat.o(49752);
        throw paramConfiguration;
      }
      localObject = (RecyclerView.h)((RecyclerView)localObject).aqb.get(0);
      if ((localObject != null) && ((localObject instanceof a))) {
        ((a)localObject).padding = d.dY(this.mContext);
      }
      this.mwd.getAdapter().arg.notifyChanged();
    }
    this.guA = paramConfiguration.orientation;
    AppMethodBeat.o(49752);
  }
  
  public int getCustomCount()
  {
    AppMethodBeat.i(49763);
    int i = this.mwd.getCustomItemCount();
    AppMethodBeat.o(49763);
    return i;
  }
  
  public int getDataCount()
  {
    AppMethodBeat.i(49762);
    int i = this.mwd.getDataCount();
    AppMethodBeat.o(49762);
    return i;
  }
  
  public List<com.tencent.mm.plugin.appbrand.widget.recentview.a> getPreviewList()
  {
    AppMethodBeat.i(49761);
    List localList = this.mwd.getPreviewItemList();
    AppMethodBeat.o(49761);
    return localList;
  }
  
  public ConversationAppBrandRecentView getRecentView()
  {
    return this.mwd;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(49751);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.myU) && (this.myH.getMeasuredWidth() != 0) && (this.myH.getMeasuredHeight() != 0))
    {
      this.myH.getLayoutParams().width = ((int)(this.myH.getMeasuredWidth() * d.eb(getContext())));
      this.myH.getLayoutParams().height = ((int)(this.myH.getMeasuredHeight() * d.eb(getContext())));
      this.myU = false;
    }
    AppMethodBeat.o(49751);
  }
  
  public void setCreateContextMenuListener(View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    AppMethodBeat.i(49764);
    this.mwd.setCreateContextMenuListener(paramOnCreateContextMenuListener);
    AppMethodBeat.o(49764);
  }
  
  public void setDataQuery(AppBrandRecentView.c paramc)
  {
    AppMethodBeat.i(49760);
    this.mwd.setDataQuery(paramc);
    AppMethodBeat.o(49760);
  }
  
  public void setEnableDataCache(boolean paramBoolean)
  {
    AppMethodBeat.i(49756);
    this.mwd.setEnableDataCache(paramBoolean);
    AppMethodBeat.o(49756);
  }
  
  public void setItemPadding(int paramInt)
  {
    this.mvQ = paramInt;
  }
  
  public void setMenuItemSelectedListener(AppBrandRecentView.a parama)
  {
    AppMethodBeat.i(49765);
    this.mwd.setMenuItemSelectedListener(parama);
    AppMethodBeat.o(49765);
  }
  
  public void setOnDataChangedListener(AppBrandRecentView.d paramd)
  {
    AppMethodBeat.i(49766);
    this.mwd.setOnDataChangedListener(paramd);
    AppMethodBeat.o(49766);
  }
  
  public void setOnItemClickListener(AppBrandRecentView.b paramb)
  {
    this.myK = paramb;
  }
  
  public void setOnLaunchUIListener(a.b paramb)
  {
    this.myT = paramb;
  }
  
  public void setRefreshListener(AppBrandRecentView.e parame)
  {
    AppMethodBeat.i(49755);
    this.mwd.setRefreshListener(parame);
    AppMethodBeat.o(49755);
  }
  
  public void setReporter(b paramb)
  {
    this.myL = paramb;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(49757);
    this.myG.setText(paramString);
    AppMethodBeat.o(49757);
  }
  
  public void setTitlePadding(Rect paramRect)
  {
    AppMethodBeat.i(49759);
    if (paramRect != null) {
      this.myG.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    }
    AppMethodBeat.o(49759);
  }
  
  public void setTitlePaddingLeft(int paramInt)
  {
    AppMethodBeat.i(49758);
    if (this.myG != null)
    {
      TextView localTextView = this.myG;
      localTextView.setPadding(paramInt, localTextView.getPaddingTop(), this.myG.getPaddingRight(), this.myG.getPaddingBottom());
    }
    AppMethodBeat.o(49758);
  }
  
  final class a
  {
    int arZ = -1;
    int myX = -1;
    RecyclerView.w myY = null;
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.half.AppBrandDesktopHalfItemView
 * JD-Core Version:    0.7.0.1
 */