package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.w;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.g;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.j;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.k;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.k.a;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.l;
import com.tencent.mm.plugin.appbrand.widget.desktop.b.m;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.z;
import java.util.List;

public class AppBrandDesktopDragView
  extends DragFeatureView
{
  private int aYS;
  private ValueAnimator cPJ;
  private List mHf;
  private HeaderContainer mUr;
  private List mWq;
  private int mWr;
  private boolean mWs;
  private boolean mWt;
  private b mWu;
  private int mWv;
  private boolean mWw;
  private boolean mWx;
  private a mWy;
  private f mWz;
  private int paddingLeft;
  private int paddingTop;
  
  public AppBrandDesktopDragView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49501);
    this.mWr = 0;
    this.mWs = false;
    this.mWt = false;
    this.mWu = null;
    this.mWv = 0;
    this.paddingLeft = 0;
    this.paddingTop = 0;
    this.mWw = false;
    this.mWx = false;
    this.aYS = 0;
    init();
    AppMethodBeat.o(49501);
  }
  
  public AppBrandDesktopDragView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49502);
    this.mWr = 0;
    this.mWs = false;
    this.mWt = false;
    this.mWu = null;
    this.mWv = 0;
    this.paddingLeft = 0;
    this.paddingTop = 0;
    this.mWw = false;
    this.mWx = false;
    this.aYS = 0;
    init();
    AppMethodBeat.o(49502);
  }
  
  private int cJ(Object paramObject)
  {
    AppMethodBeat.i(49508);
    int i;
    if (this.mWs) {
      if ((this.mWy != null) && (this.mWy.bCS() - 1 >= b.bcu())) {
        i = 1;
      }
    }
    while (i != 0)
    {
      ad.i("MicroMsg.AppBrandDesktopDragView", "alvinluo checkCanInsert current: %d, over limit: %d", new Object[] { Integer.valueOf(this.mWy.bCS()), Integer.valueOf(b.bcu()) });
      AppMethodBeat.o(49508);
      return 2;
      i = 0;
      continue;
      if ((this.mWy != null) && (this.mWy.bCS() >= b.bcu())) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((paramObject instanceof AppBrandDesktopView.c))
    {
      paramObject = (AppBrandDesktopView.c)paramObject;
      if (paramObject.mXW != null)
      {
        if (j.a.rQ(paramObject.mXW.hQh))
        {
          if (paramObject.mXW.jQb <= System.currentTimeMillis() / 1000L)
          {
            AppMethodBeat.o(49508);
            return 0;
          }
          AppMethodBeat.o(49508);
          return 1;
        }
        AppMethodBeat.o(49508);
        return 0;
      }
    }
    AppMethodBeat.o(49508);
    return 99;
  }
  
  private float getOffsetX()
  {
    AppMethodBeat.i(49511);
    float f2 = d.dX(getContext());
    float f1 = this.aYS / 2;
    f2 /= 2.0F;
    float f3 = this.paddingLeft;
    AppMethodBeat.o(49511);
    return f3 - (f1 - f2);
  }
  
  private float getOffsetY()
  {
    AppMethodBeat.i(49512);
    float f = -(a.fromDPToPix(getContext(), 32) + (d.ea(getContext()) * 1.5F - d.ea(getContext())) / 2.0F);
    AppMethodBeat.o(49512);
    return f;
  }
  
  private void init()
  {
    AppMethodBeat.i(49503);
    this.paddingTop = getResources().getDimensionPixelOffset(2131165480);
    AppMethodBeat.o(49503);
  }
  
  private void m(final View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(49505);
    if ((paramView.getVisibility() == 0) && (paramBoolean))
    {
      AppMethodBeat.o(49505);
      return;
    }
    if ((paramBoolean) && (this.mWx))
    {
      AppMethodBeat.o(49505);
      return;
    }
    if ((paramView.getVisibility() != 0) && (!paramBoolean))
    {
      AppMethodBeat.o(49505);
      return;
    }
    if ((!paramBoolean) && (this.mWw))
    {
      AppMethodBeat.o(49505);
      return;
    }
    if (paramBoolean)
    {
      this.mWx = true;
      paramView.setScaleX(0.1F);
      paramView.setScaleY(0.1F);
      paramView.setVisibility(0);
      paramView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(200L).setListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49496);
          AppBrandDesktopDragView.d(AppBrandDesktopDragView.this);
          AppMethodBeat.o(49496);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49495);
          AppBrandDesktopDragView.d(AppBrandDesktopDragView.this);
          AppMethodBeat.o(49495);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      }).start();
      AppMethodBeat.o(49505);
      return;
    }
    this.mWw = true;
    paramView.setScaleX(1.0F);
    paramView.setScaleY(1.0F);
    paramView.setVisibility(0);
    paramView.animate().scaleX(0.0F).scaleY(0.0F).setDuration(200L).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(49498);
        AppBrandDesktopDragView.e(AppBrandDesktopDragView.this);
        paramView.setVisibility(4);
        AppMethodBeat.o(49498);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(49497);
        AppBrandDesktopDragView.e(AppBrandDesktopDragView.this);
        paramView.setVisibility(4);
        AppMethodBeat.o(49497);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    }).start();
    AppMethodBeat.o(49505);
  }
  
  protected final j N(RecyclerView.w paramw)
  {
    AppMethodBeat.i(49504);
    if ((paramw != null) && (paramw.auy == 2))
    {
      this.mWs = false;
      paramw = new k(this, this.mWq, this.mHf, new k.a()
      {
        public final boolean E(Object paramAnonymousObject1, Object paramAnonymousObject2)
        {
          AppMethodBeat.i(49481);
          if ((paramAnonymousObject2 == null) || (paramAnonymousObject1 == null))
          {
            AppMethodBeat.o(49481);
            return false;
          }
          if (((paramAnonymousObject2 instanceof AppBrandDesktopView.c)) && ((paramAnonymousObject1 instanceof AppBrandDesktopView.c)))
          {
            paramAnonymousObject2 = (AppBrandDesktopView.c)paramAnonymousObject2;
            paramAnonymousObject1 = (AppBrandDesktopView.c)paramAnonymousObject1;
            if ((paramAnonymousObject2.mXW != null) && (paramAnonymousObject1.mXW != null) && (!bt.isNullOrNil(paramAnonymousObject2.mXW.username)) && (!bt.isNullOrNil(paramAnonymousObject1.mXW.username)) && (paramAnonymousObject1.mXW.f(paramAnonymousObject2.mXW))) {}
            for (int i = 1; i != 0; i = 0)
            {
              AppMethodBeat.o(49481);
              return true;
            }
          }
          AppMethodBeat.o(49481);
          return false;
        }
        
        public final float bAn()
        {
          AppMethodBeat.i(49477);
          float f = AppBrandDesktopDragView.a(AppBrandDesktopDragView.this);
          AppMethodBeat.o(49477);
          return f;
        }
        
        public final float bAo()
        {
          AppMethodBeat.i(49478);
          float f = AppBrandDesktopDragView.b(AppBrandDesktopDragView.this);
          AppMethodBeat.o(49478);
          return f;
        }
        
        public final void bCQ()
        {
          AppMethodBeat.i(49479);
          ad.d("MicroMsg.AppBrandDesktopDragView", "alvinluo onInsert");
          AppBrandDesktopDragView.a(AppBrandDesktopDragView.this, true);
          AppMethodBeat.o(49479);
        }
        
        public final void bCR()
        {
          AppMethodBeat.i(49480);
          ad.d("MicroMsg.AppBrandDesktopDragView", "alvinluo onCancelInsert");
          AppBrandDesktopDragView.a(AppBrandDesktopDragView.this, false);
          AppMethodBeat.o(49480);
        }
        
        public final Object cC(Object paramAnonymousObject)
        {
          AppMethodBeat.i(49475);
          if ((paramAnonymousObject instanceof AppBrandDesktopView.c))
          {
            paramAnonymousObject = (AppBrandDesktopView.c)paramAnonymousObject;
            AppBrandDesktopView.c localc = new AppBrandDesktopView.c(1);
            localc.mXW = paramAnonymousObject.mXW;
            localc.position = paramAnonymousObject.position;
            AppMethodBeat.o(49475);
            return localc;
          }
          AppMethodBeat.o(49475);
          return paramAnonymousObject;
        }
        
        public final View cQ(View paramAnonymousView)
        {
          AppMethodBeat.i(49476);
          paramAnonymousView = paramAnonymousView.findViewById(2131300892);
          AppMethodBeat.o(49476);
          return paramAnonymousView;
        }
        
        public final void h(Object paramAnonymousObject, int paramAnonymousInt)
        {
          if ((paramAnonymousObject instanceof AppBrandDesktopView.c)) {
            ((AppBrandDesktopView.c)paramAnonymousObject).position = paramAnonymousInt;
          }
        }
      });
      i = getResources().getDimensionPixelSize(2131165568);
      j = this.paddingLeft;
      paramw.paddingTop = i;
      paramw.paddingLeft = j;
      paramw.mYA = getRecyclerScrollComputer();
      paramw.nay = new g()
      {
        public final boolean O(RecyclerView.w paramAnonymousw)
        {
          return paramAnonymousw.auy == 2;
        }
        
        public final boolean P(RecyclerView.w paramAnonymousw)
        {
          return (paramAnonymousw == null) || (paramAnonymousw.auy == 2) || (paramAnonymousw.auy == 10) || (paramAnonymousw.auy == 11);
        }
        
        public final void a(RecyclerView.w paramAnonymousw, View paramAnonymousView, Object paramAnonymousObject, int paramAnonymousInt)
        {
          AppMethodBeat.i(49483);
          if (paramAnonymousInt == 6) {
            AppBrandDesktopDragView.b(AppBrandDesktopDragView.this, true);
          }
          for (;;)
          {
            AppBrandDesktopDragView.a(AppBrandDesktopDragView.this, paramAnonymousw, paramAnonymousView, paramAnonymousObject, paramAnonymousInt);
            AppMethodBeat.o(49483);
            return;
            AppBrandDesktopDragView.b(AppBrandDesktopDragView.this, false);
          }
        }
        
        public final boolean a(RecyclerView.w paramAnonymousw, Object paramAnonymousObject)
        {
          AppMethodBeat.i(49486);
          if (AppBrandDesktopDragView.a(AppBrandDesktopDragView.this, paramAnonymousObject) != 0)
          {
            ad.e("MicroMsg.AppBrandDesktopDragView", "alvinluo checkCanInsert can't insert");
            AppMethodBeat.o(49486);
            return false;
          }
          if ((paramAnonymousw.auy == 1) || (paramAnonymousw.auy == 2) || (paramAnonymousw.auy == 7))
          {
            AppMethodBeat.o(49486);
            return true;
          }
          AppMethodBeat.o(49486);
          return false;
        }
        
        public final void b(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(49485);
          if ((paramAnonymousBoolean) && (AppBrandDesktopDragView.c(AppBrandDesktopDragView.this) != null)) {
            AppBrandDesktopDragView.c(AppBrandDesktopDragView.this).cK(paramAnonymousObject);
          }
          AppMethodBeat.o(49485);
        }
        
        public final void cB(Object paramAnonymousObject)
        {
          AppMethodBeat.i(49487);
          if ((paramAnonymousObject instanceof AppBrandDesktopView.c))
          {
            ((AppBrandDesktopView.c)paramAnonymousObject).type = 2;
            if (AppBrandDesktopDragView.c(AppBrandDesktopDragView.this) != null) {
              AppBrandDesktopDragView.c(AppBrandDesktopDragView.this).cM(paramAnonymousObject);
            }
          }
          AppMethodBeat.o(49487);
        }
        
        public final void cP(View paramAnonymousView)
        {
          AppMethodBeat.i(49484);
          if (paramAnonymousView != null)
          {
            View localView = paramAnonymousView.findViewById(2131305201);
            if (localView != null) {
              localView.setVisibility(4);
            }
            paramAnonymousView = paramAnonymousView.findViewById(2131296835);
            if (paramAnonymousView != null) {
              paramAnonymousView.setVisibility(4);
            }
          }
          AppMethodBeat.o(49484);
        }
        
        public final View e(RecyclerView paramAnonymousRecyclerView, RecyclerView.w paramAnonymousw)
        {
          AppMethodBeat.i(49482);
          if ((paramAnonymousw instanceof f))
          {
            paramAnonymousRecyclerView = AppBrandDesktopDragView.this.a((f)paramAnonymousw);
            AppMethodBeat.o(49482);
            return paramAnonymousRecyclerView;
          }
          AppMethodBeat.o(49482);
          return null;
        }
      };
      AppMethodBeat.o(49504);
      return paramw;
    }
    this.mWs = true;
    paramw = new l(this, this.mHf, new m()
    {
      public final float bAn()
      {
        AppMethodBeat.i(49490);
        float f = AppBrandDesktopDragView.a(AppBrandDesktopDragView.this);
        AppMethodBeat.o(49490);
        return f;
      }
      
      public final float bAo()
      {
        AppMethodBeat.i(49491);
        float f = AppBrandDesktopDragView.b(AppBrandDesktopDragView.this);
        AppMethodBeat.o(49491);
        return f;
      }
      
      public final Object cC(Object paramAnonymousObject)
      {
        AppMethodBeat.i(49488);
        if ((paramAnonymousObject instanceof AppBrandDesktopView.c))
        {
          paramAnonymousObject = (AppBrandDesktopView.c)paramAnonymousObject;
          AppBrandDesktopView.c localc = new AppBrandDesktopView.c(1);
          localc.mXW = paramAnonymousObject.mXW;
          AppMethodBeat.o(49488);
          return localc;
        }
        AppMethodBeat.o(49488);
        return paramAnonymousObject;
      }
      
      public final View cQ(View paramAnonymousView)
      {
        AppMethodBeat.i(49489);
        paramAnonymousView = paramAnonymousView.findViewById(2131300892);
        AppMethodBeat.o(49489);
        return paramAnonymousView;
      }
      
      public final void h(Object paramAnonymousObject, int paramAnonymousInt)
      {
        if ((paramAnonymousObject instanceof AppBrandDesktopView.c)) {
          ((AppBrandDesktopView.c)paramAnonymousObject).position = paramAnonymousInt;
        }
      }
    });
    paramw.mYA = getRecyclerScrollComputer();
    paramw.nay = new g()
    {
      public final boolean O(RecyclerView.w paramAnonymousw)
      {
        return paramAnonymousw.auy == 1;
      }
      
      public final boolean P(RecyclerView.w paramAnonymousw)
      {
        return false;
      }
      
      public final void a(RecyclerView.w paramAnonymousw, View paramAnonymousView, Object paramAnonymousObject, int paramAnonymousInt) {}
      
      public final boolean a(RecyclerView.w paramAnonymousw, Object paramAnonymousObject)
      {
        return (paramAnonymousw.auy == 1) || (paramAnonymousw.auy == 7);
      }
      
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(49493);
        if (AppBrandDesktopDragView.c(AppBrandDesktopDragView.this) != null) {
          AppBrandDesktopDragView.c(AppBrandDesktopDragView.this).g(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
        }
        AppMethodBeat.o(49493);
      }
      
      public final void cB(Object paramAnonymousObject)
      {
        AppMethodBeat.i(49494);
        if (((paramAnonymousObject instanceof AppBrandDesktopView.c)) && (AppBrandDesktopDragView.c(AppBrandDesktopDragView.this) != null)) {
          AppBrandDesktopDragView.c(AppBrandDesktopDragView.this).cL(paramAnonymousObject);
        }
        AppMethodBeat.o(49494);
      }
      
      public final void cP(View paramAnonymousView) {}
      
      public final View e(RecyclerView paramAnonymousRecyclerView, RecyclerView.w paramAnonymousw)
      {
        AppMethodBeat.i(49492);
        paramAnonymousRecyclerView = AppBrandDesktopDragView.this.a((f)paramAnonymousw);
        AppMethodBeat.o(49492);
        return paramAnonymousRecyclerView;
      }
    };
    int i = getResources().getDimensionPixelSize(2131165568);
    int j = this.paddingLeft;
    paramw.paddingTop = i;
    paramw.paddingLeft = j;
    AppMethodBeat.o(49504);
    return paramw;
  }
  
  protected final View a(f paramf)
  {
    AppMethodBeat.i(49510);
    View localView1 = z.jO(getContext()).inflate(2131494553, null, false);
    localView1.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
    this.mWz = new f(localView1);
    f localf = this.mWz;
    View localView2 = paramf.auu;
    localView1 = localf.auu;
    localView1.setScaleX(1.0F);
    localView1.setScaleY(1.0F);
    localView1.setAlpha(1.0F);
    localView1.setVisibility(0);
    int[] arrayOfInt = new int[2];
    localView2.getLocationOnScreen(arrayOfInt);
    localf.lZa.setImageDrawable(paramf.lZa.getDrawable());
    localf.lZa.setBackground(paramf.lZa.getBackground());
    localf.mYj.setText(paramf.mYj.getText());
    localf.mYj.setVisibility(paramf.mYj.getVisibility());
    localf.mYk.setVisibility(4);
    float f1 = d.ea(getContext());
    float f2 = f1 * 1.5F + a.fromDPToPix(getContext(), 8) * 2;
    ad.i("MicroMsg.AppBrandDesktopDragView", "alvinluo fillFloatView iconLayout: %f", new Object[] { Float.valueOf(f2) });
    localView1.findViewById(2131300899).getLayoutParams().height = ((int)f2);
    localf.mYi.getLayoutParams().height = ((int)f2);
    localf.mYi.getLayoutParams().width = ((int)f1 + (int)(a.ay(getContext(), 2131165568) * 2 * d.eb(getContext())));
    localf.lZa.getLayoutParams().width = ((int)f1);
    localf.lZa.getLayoutParams().height = ((int)f1);
    localf.mYh.getLayoutParams().width = ((int)f1);
    localf.mYh.getLayoutParams().height = ((int)f1);
    paramf = localf.mYk.getLayoutParams();
    if ((paramf instanceof RelativeLayout.LayoutParams))
    {
      ((RelativeLayout.LayoutParams)paramf).topMargin = (a.fromDPToPix(getContext(), 6) + (int)(f1 * 0.5F / 2.0F));
      paramf.width = ((int)(getContext().getResources().getDimensionPixelSize(2131165480) * d.eb(getContext())));
      paramf.height = ((int)(getContext().getResources().getDimensionPixelSize(2131165480) * d.eb(getContext())));
    }
    float f3 = (f1 * 1.5F - f1) / 2.0F;
    f2 = arrayOfInt[0] + getOffsetX();
    f3 = arrayOfInt[1] + this.paddingTop - f3 - a.fromDPToPix(getContext(), 48);
    localView1.findViewById(2131296835).setVisibility(4);
    localView1.findViewById(2131300892).animate().alpha(0.5F).setDuration(300L).setListener(null).start();
    gB(false);
    localView1.findViewById(2131300892).animate().scaleX(1.5F).scaleY(1.5F).setDuration(300L).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(49499);
        AppBrandDesktopDragView.this.gB(true);
        AppMethodBeat.o(49499);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    }).start();
    paramf = (ImageView)localView1.findViewById(2131305201);
    paramf.getLayoutParams().height = ((int)(a.fromDPToPix(getContext(), 24) * d.eb(getContext())));
    paramf.getLayoutParams().width = ((int)(a.fromDPToPix(getContext(), 24) * d.eb(getContext())));
    paramf.setTranslationY(-f1 * 0.5F / 2.0F);
    paramf.setTranslationX(f1 * 0.5F / 2.0F);
    localView1.setTranslationX(f2);
    localView1.setTranslationY(f3);
    ad.i("MicroMsg.AppBrandDesktopDragView", "alvinluo fillFloatView offsetX: %f, transX: %f, transY: %f", new Object[] { Float.valueOf(getOffsetX()), Float.valueOf(f2), Float.valueOf(f3) });
    AppMethodBeat.o(49510);
    return localView1;
  }
  
  protected final RecyclerView.w d(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(49509);
    getRecyclerView().getGlobalVisibleRect(this.mRect);
    if (!this.mRect.contains((int)paramFloat1, (int)paramFloat2))
    {
      AppMethodBeat.o(49509);
      return null;
    }
    int i = 0;
    Object localObject1 = null;
    int k = 0;
    RecyclerView.w localw;
    Object localObject2;
    int j;
    if (k < getRecyclerView().getChildCount())
    {
      localw = getRecyclerView().bh(getRecyclerView().getChildAt(k));
      localObject2 = localObject1;
      j = i;
      if (localw.auy != 7)
      {
        localObject2 = localObject1;
        j = i;
        if (localw.auy != 3)
        {
          localObject2 = localObject1;
          j = i;
          if (localw.auy != 8)
          {
            localw.auu.getGlobalVisibleRect(this.mRect);
            localObject2 = localObject1;
            j = i;
            if (this.mRect.contains((int)paramFloat1, (int)paramFloat2)) {
              if (2 == localw.auy)
              {
                RecyclerView localRecyclerView = (RecyclerView)localw.auu.findViewById(2131303807);
                j = 0;
                label195:
                if (j < localRecyclerView.getAdapter().getItemCount())
                {
                  localObject2 = localRecyclerView.ci(j);
                  if ((localObject2 == null) || (((RecyclerView.w)localObject2).auu == null)) {
                    break label435;
                  }
                  ((RecyclerView.w)localObject2).auu.getGlobalVisibleRect(this.mRect);
                  if (!this.mRect.contains((int)paramFloat1, (int)paramFloat2)) {
                    break label435;
                  }
                  i = 1;
                  localObject1 = localObject2;
                }
              }
            }
          }
        }
      }
    }
    label435:
    for (;;)
    {
      j += 1;
      break label195;
      localObject2 = localObject1;
      j = i;
      if (i == 0)
      {
        if (paramBoolean)
        {
          AppMethodBeat.o(49509);
          return null;
        }
        j = 1;
        localObject2 = localw;
      }
      k += 1;
      localObject1 = localObject2;
      i = j;
      break;
      if (i != 0)
      {
        AppMethodBeat.o(49509);
        return localObject1;
      }
      if (!paramBoolean)
      {
        i = getRecyclerView().getChildCount() - 1;
        while (i >= 0)
        {
          localObject1 = getRecyclerView().bh(getRecyclerView().getChildAt(i));
          if (this.mWs)
          {
            if (((RecyclerView.w)localObject1).auy == 1)
            {
              AppMethodBeat.o(49509);
              return localObject1;
            }
          }
          else if (((RecyclerView.w)localObject1).auy == 7)
          {
            AppMethodBeat.o(49509);
            return localObject1;
          }
          i -= 1;
        }
      }
      AppMethodBeat.o(49509);
      return null;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49507);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    getGlobalVisibleRect(this.mYt);
    this.mYt.set(this.mYt.left, this.mYt.bottom - this.mYn - (int)(getContext().getResources().getDimensionPixelSize(2131166416) * 1.0F) - 40, this.mYt.right, this.mYt.bottom - this.mYn);
    ad.i("MicroMsg.AppBrandDesktopDragView", "alvinluo bottomRect: %s", new Object[] { this.mYt });
    getRecyclerView().getGlobalVisibleRect(this.mYu);
    this.mYu.set(this.mYu.left, 0, this.mYu.right, this.mYu.top + this.mYn);
    AppMethodBeat.o(49507);
  }
  
  public void setAppBrandCounter(a parama)
  {
    this.mWy = parama;
  }
  
  public void setCollectionCallback(b paramb)
  {
    this.mWu = paramb;
  }
  
  public void setCollectionStartPosition(int paramInt)
  {
    this.mWr = paramInt;
  }
  
  public void setCopyList(List paramList)
  {
    this.mWq = paramList;
  }
  
  public void setHeaderContainer(HeaderContainer paramHeaderContainer)
  {
    this.mUr = paramHeaderContainer;
  }
  
  public void setItemPadding(int paramInt)
  {
    this.paddingLeft = paramInt;
  }
  
  public void setList(List paramList)
  {
    this.mHf = paramList;
  }
  
  protected void setRubbishViewVisible(final int paramInt)
  {
    AppMethodBeat.i(49506);
    super.setRubbishViewVisible(paramInt);
    boolean bool;
    float f;
    if (paramInt == 0)
    {
      bool = true;
      f = getResources().getDimension(2131166753) * 1.0F;
      if (!bool) {
        break label176;
      }
      f = -f;
    }
    label176:
    for (;;)
    {
      if (bool) {}
      for (paramInt = 0;; paramInt = (int)f)
      {
        ad.v("MicroMsg.AppBrandDesktopDragView", "alvinluo transBackFooterAnim isShow: %b, offset: %f, extraBottomHeight: %d", new Object[] { Boolean.valueOf(bool), Float.valueOf(f), Integer.valueOf(paramInt) });
        this.cPJ = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("transY", new float[] { 0.0F, f }) });
        final int i = this.mUr.getBackUpFooterRect().top;
        this.cPJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          float mWC = 0.0F;
          float mWD = 0.0F;
          
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(49500);
            try
            {
              float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue("transY")).floatValue();
              this.mWD += f - this.mWC;
              AppBrandDesktopDragView.f(AppBrandDesktopDragView.this).getBackUpFooterRect().top = ((int)(i + f));
              ad.v("MicroMsg.AppBrandDesktopDragView", "alvinluo transBackFooterAnim totalValue: %f, top: %d", new Object[] { Float.valueOf(this.mWD), Integer.valueOf(AppBrandDesktopDragView.f(AppBrandDesktopDragView.this).getBackUpFooterRect().top) });
              AppBrandDesktopDragView.f(AppBrandDesktopDragView.this).setExtraBottomHeight(paramInt - (int)this.mWD);
              AppBrandDesktopDragView.f(AppBrandDesktopDragView.this).requestLayout();
              this.mWC = f;
              if (AppBrandDesktopDragView.f(AppBrandDesktopDragView.this).getParent() != null) {
                ((ViewGroup)AppBrandDesktopDragView.f(AppBrandDesktopDragView.this).getParent()).invalidate();
              }
              AppMethodBeat.o(49500);
              return;
            }
            catch (Exception paramAnonymousValueAnimator)
            {
              AppMethodBeat.o(49500);
            }
          }
        });
        this.cPJ.setDuration(300L);
        this.cPJ.start();
        AppMethodBeat.o(49506);
        return;
        bool = false;
        break;
      }
    }
  }
  
  public void setViewWidth(int paramInt)
  {
    this.aYS = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract int bCS();
  }
  
  public static abstract interface b
  {
    public abstract void cK(Object paramObject);
    
    public abstract void cL(Object paramObject);
    
    public abstract void cM(Object paramObject);
    
    public abstract void g(int paramInt1, int paramInt2, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView
 * JD-Core Version:    0.7.0.1
 */