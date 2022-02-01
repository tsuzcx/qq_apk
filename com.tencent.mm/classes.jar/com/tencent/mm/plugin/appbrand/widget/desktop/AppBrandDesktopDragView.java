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
import android.support.v7.widget.RecyclerView.v;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
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
import com.tencent.mm.ui.y;
import java.util.List;

public class AppBrandDesktopDragView
  extends DragFeatureView
{
  private int aNI;
  private ValueAnimator cHw;
  private List lEL;
  private HeaderContainer lRJ;
  private List lTJ;
  private int lTK;
  private boolean lTL;
  private boolean lTM;
  private b lTN;
  private int lTO;
  private boolean lTP;
  private boolean lTQ;
  private a lTR;
  private e lTS;
  private int paddingLeft;
  private int paddingTop;
  
  public AppBrandDesktopDragView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49501);
    this.lTK = 0;
    this.lTL = false;
    this.lTM = false;
    this.lTN = null;
    this.lTO = 0;
    this.paddingLeft = 0;
    this.paddingTop = 0;
    this.lTP = false;
    this.lTQ = false;
    this.aNI = 0;
    init();
    AppMethodBeat.o(49501);
  }
  
  public AppBrandDesktopDragView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49502);
    this.lTK = 0;
    this.lTL = false;
    this.lTM = false;
    this.lTN = null;
    this.lTO = 0;
    this.paddingLeft = 0;
    this.paddingTop = 0;
    this.lTP = false;
    this.lTQ = false;
    this.aNI = 0;
    init();
    AppMethodBeat.o(49502);
  }
  
  private int cI(Object paramObject)
  {
    AppMethodBeat.i(49508);
    int i;
    if (this.lTL) {
      if ((this.lTR != null) && (this.lTR.brP() - 1 >= b.aSb())) {
        i = 1;
      }
    }
    while (i != 0)
    {
      ad.i("MicroMsg.AppBrandDesktopDragView", "alvinluo checkCanInsert current: %d, over limit: %d", new Object[] { Integer.valueOf(this.lTR.brP()), Integer.valueOf(b.aSb()) });
      AppMethodBeat.o(49508);
      return 2;
      i = 0;
      continue;
      if ((this.lTR != null) && (this.lTR.brP() >= b.aSb())) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((paramObject instanceof AppBrandDesktopView.c))
    {
      paramObject = (AppBrandDesktopView.c)paramObject;
      if (paramObject.lVq != null)
      {
        if (j.a.qD(paramObject.lVq.gXn))
        {
          if (paramObject.lVq.iVR <= System.currentTimeMillis() / 1000L)
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
    float f2 = d.dP(getContext());
    float f1 = this.aNI / 2;
    f2 /= 2.0F;
    float f3 = this.paddingLeft;
    AppMethodBeat.o(49511);
    return f3 - (f1 - f2);
  }
  
  private float getOffsetY()
  {
    AppMethodBeat.i(49512);
    float f = -(a.fromDPToPix(getContext(), 32) + (d.dS(getContext()) * 1.5F - d.dS(getContext())) / 2.0F);
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
    if ((paramBoolean) && (this.lTQ))
    {
      AppMethodBeat.o(49505);
      return;
    }
    if ((paramView.getVisibility() != 0) && (!paramBoolean))
    {
      AppMethodBeat.o(49505);
      return;
    }
    if ((!paramBoolean) && (this.lTP))
    {
      AppMethodBeat.o(49505);
      return;
    }
    if (paramBoolean)
    {
      this.lTQ = true;
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
    this.lTP = true;
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
  
  protected final j N(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49504);
    if ((paramv != null) && (paramv.arM == 2))
    {
      this.lTL = false;
      paramv = new k(this, this.lTJ, this.lEL, new k.a()
      {
        public final boolean C(Object paramAnonymousObject1, Object paramAnonymousObject2)
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
            if ((paramAnonymousObject2.lVq != null) && (paramAnonymousObject1.lVq != null) && (!bt.isNullOrNil(paramAnonymousObject2.lVq.username)) && (!bt.isNullOrNil(paramAnonymousObject1.lVq.username)) && (paramAnonymousObject1.lVq.f(paramAnonymousObject2.lVq))) {}
            for (int i = 1; i != 0; i = 0)
            {
              AppMethodBeat.o(49481);
              return true;
            }
          }
          AppMethodBeat.o(49481);
          return false;
        }
        
        public final float bpm()
        {
          AppMethodBeat.i(49477);
          float f = AppBrandDesktopDragView.a(AppBrandDesktopDragView.this);
          AppMethodBeat.o(49477);
          return f;
        }
        
        public final float bpn()
        {
          AppMethodBeat.i(49478);
          float f = AppBrandDesktopDragView.b(AppBrandDesktopDragView.this);
          AppMethodBeat.o(49478);
          return f;
        }
        
        public final void brN()
        {
          AppMethodBeat.i(49479);
          ad.d("MicroMsg.AppBrandDesktopDragView", "alvinluo onInsert");
          AppBrandDesktopDragView.a(AppBrandDesktopDragView.this, true);
          AppMethodBeat.o(49479);
        }
        
        public final void brO()
        {
          AppMethodBeat.i(49480);
          ad.d("MicroMsg.AppBrandDesktopDragView", "alvinluo onCancelInsert");
          AppBrandDesktopDragView.a(AppBrandDesktopDragView.this, false);
          AppMethodBeat.o(49480);
        }
        
        public final Object cB(Object paramAnonymousObject)
        {
          AppMethodBeat.i(49475);
          if ((paramAnonymousObject instanceof AppBrandDesktopView.c))
          {
            paramAnonymousObject = (AppBrandDesktopView.c)paramAnonymousObject;
            AppBrandDesktopView.c localc = new AppBrandDesktopView.c(1);
            localc.lVq = paramAnonymousObject.lVq;
            localc.position = paramAnonymousObject.position;
            AppMethodBeat.o(49475);
            return localc;
          }
          AppMethodBeat.o(49475);
          return paramAnonymousObject;
        }
        
        public final View cM(View paramAnonymousView)
        {
          AppMethodBeat.i(49476);
          paramAnonymousView = paramAnonymousView.findViewById(2131300892);
          AppMethodBeat.o(49476);
          return paramAnonymousView;
        }
        
        public final void g(Object paramAnonymousObject, int paramAnonymousInt)
        {
          if ((paramAnonymousObject instanceof AppBrandDesktopView.c)) {
            ((AppBrandDesktopView.c)paramAnonymousObject).position = paramAnonymousInt;
          }
        }
      });
      i = getResources().getDimensionPixelSize(2131165568);
      j = this.paddingLeft;
      paramv.paddingTop = i;
      paramv.paddingLeft = j;
      paramv.lVQ = getRecyclerScrollComputer();
      paramv.lXO = new g()
      {
        public final boolean O(RecyclerView.v paramAnonymousv)
        {
          return paramAnonymousv.arM == 2;
        }
        
        public final boolean P(RecyclerView.v paramAnonymousv)
        {
          return (paramAnonymousv == null) || (paramAnonymousv.arM == 2) || (paramAnonymousv.arM == 10) || (paramAnonymousv.arM == 11);
        }
        
        public final void a(RecyclerView.v paramAnonymousv, View paramAnonymousView, Object paramAnonymousObject, int paramAnonymousInt)
        {
          AppMethodBeat.i(49483);
          if (paramAnonymousInt == 6) {
            AppBrandDesktopDragView.b(AppBrandDesktopDragView.this, true);
          }
          for (;;)
          {
            AppBrandDesktopDragView.a(AppBrandDesktopDragView.this, paramAnonymousv, paramAnonymousView, paramAnonymousObject, paramAnonymousInt);
            AppMethodBeat.o(49483);
            return;
            AppBrandDesktopDragView.b(AppBrandDesktopDragView.this, false);
          }
        }
        
        public final boolean a(RecyclerView.v paramAnonymousv, Object paramAnonymousObject)
        {
          AppMethodBeat.i(49486);
          if (AppBrandDesktopDragView.a(AppBrandDesktopDragView.this, paramAnonymousObject) != 0)
          {
            ad.e("MicroMsg.AppBrandDesktopDragView", "alvinluo checkCanInsert can't insert");
            AppMethodBeat.o(49486);
            return false;
          }
          if ((paramAnonymousv.arM == 1) || (paramAnonymousv.arM == 2) || (paramAnonymousv.arM == 7))
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
            AppBrandDesktopDragView.c(AppBrandDesktopDragView.this).cJ(paramAnonymousObject);
          }
          AppMethodBeat.o(49485);
        }
        
        public final void cA(Object paramAnonymousObject)
        {
          AppMethodBeat.i(49487);
          if ((paramAnonymousObject instanceof AppBrandDesktopView.c))
          {
            ((AppBrandDesktopView.c)paramAnonymousObject).type = 2;
            if (AppBrandDesktopDragView.c(AppBrandDesktopDragView.this) != null) {
              AppBrandDesktopDragView.c(AppBrandDesktopDragView.this).cL(paramAnonymousObject);
            }
          }
          AppMethodBeat.o(49487);
        }
        
        public final void cL(View paramAnonymousView)
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
        
        public final View e(RecyclerView paramAnonymousRecyclerView, RecyclerView.v paramAnonymousv)
        {
          AppMethodBeat.i(49482);
          if ((paramAnonymousv instanceof e))
          {
            paramAnonymousRecyclerView = AppBrandDesktopDragView.this.a((e)paramAnonymousv);
            AppMethodBeat.o(49482);
            return paramAnonymousRecyclerView;
          }
          AppMethodBeat.o(49482);
          return null;
        }
      };
      AppMethodBeat.o(49504);
      return paramv;
    }
    this.lTL = true;
    paramv = new l(this, this.lEL, new m()
    {
      public final float bpm()
      {
        AppMethodBeat.i(49490);
        float f = AppBrandDesktopDragView.a(AppBrandDesktopDragView.this);
        AppMethodBeat.o(49490);
        return f;
      }
      
      public final float bpn()
      {
        AppMethodBeat.i(49491);
        float f = AppBrandDesktopDragView.b(AppBrandDesktopDragView.this);
        AppMethodBeat.o(49491);
        return f;
      }
      
      public final Object cB(Object paramAnonymousObject)
      {
        AppMethodBeat.i(49488);
        if ((paramAnonymousObject instanceof AppBrandDesktopView.c))
        {
          paramAnonymousObject = (AppBrandDesktopView.c)paramAnonymousObject;
          AppBrandDesktopView.c localc = new AppBrandDesktopView.c(1);
          localc.lVq = paramAnonymousObject.lVq;
          AppMethodBeat.o(49488);
          return localc;
        }
        AppMethodBeat.o(49488);
        return paramAnonymousObject;
      }
      
      public final View cM(View paramAnonymousView)
      {
        AppMethodBeat.i(49489);
        paramAnonymousView = paramAnonymousView.findViewById(2131300892);
        AppMethodBeat.o(49489);
        return paramAnonymousView;
      }
      
      public final void g(Object paramAnonymousObject, int paramAnonymousInt)
      {
        if ((paramAnonymousObject instanceof AppBrandDesktopView.c)) {
          ((AppBrandDesktopView.c)paramAnonymousObject).position = paramAnonymousInt;
        }
      }
    });
    paramv.lVQ = getRecyclerScrollComputer();
    paramv.lXO = new g()
    {
      public final boolean O(RecyclerView.v paramAnonymousv)
      {
        return paramAnonymousv.arM == 1;
      }
      
      public final boolean P(RecyclerView.v paramAnonymousv)
      {
        return false;
      }
      
      public final void a(RecyclerView.v paramAnonymousv, View paramAnonymousView, Object paramAnonymousObject, int paramAnonymousInt) {}
      
      public final boolean a(RecyclerView.v paramAnonymousv, Object paramAnonymousObject)
      {
        return (paramAnonymousv.arM == 1) || (paramAnonymousv.arM == 7);
      }
      
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(49493);
        if (AppBrandDesktopDragView.c(AppBrandDesktopDragView.this) != null) {
          AppBrandDesktopDragView.c(AppBrandDesktopDragView.this).g(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
        }
        AppMethodBeat.o(49493);
      }
      
      public final void cA(Object paramAnonymousObject)
      {
        AppMethodBeat.i(49494);
        if (((paramAnonymousObject instanceof AppBrandDesktopView.c)) && (AppBrandDesktopDragView.c(AppBrandDesktopDragView.this) != null)) {
          AppBrandDesktopDragView.c(AppBrandDesktopDragView.this).cK(paramAnonymousObject);
        }
        AppMethodBeat.o(49494);
      }
      
      public final void cL(View paramAnonymousView) {}
      
      public final View e(RecyclerView paramAnonymousRecyclerView, RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(49492);
        paramAnonymousRecyclerView = AppBrandDesktopDragView.this.a((e)paramAnonymousv);
        AppMethodBeat.o(49492);
        return paramAnonymousRecyclerView;
      }
    };
    int i = getResources().getDimensionPixelSize(2131165568);
    int j = this.paddingLeft;
    paramv.paddingTop = i;
    paramv.paddingLeft = j;
    AppMethodBeat.o(49504);
    return paramv;
  }
  
  protected final View a(e parame)
  {
    AppMethodBeat.i(49510);
    View localView1 = y.js(getContext()).inflate(2131494553, null, false);
    localView1.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
    this.lTS = new e(localView1);
    e locale = this.lTS;
    View localView2 = parame.arI;
    localView1 = locale.arI;
    localView1.setScaleX(1.0F);
    localView1.setScaleY(1.0F);
    localView1.setAlpha(1.0F);
    localView1.setVisibility(0);
    int[] arrayOfInt = new int[2];
    localView2.getLocationOnScreen(arrayOfInt);
    locale.kXS.setImageDrawable(parame.kXS.getDrawable());
    locale.kXS.setBackground(parame.kXS.getBackground());
    locale.lVA.setText(parame.lVA.getText());
    locale.lVA.setVisibility(parame.lVA.getVisibility());
    locale.lVB.setVisibility(4);
    float f1 = d.dS(getContext());
    float f2 = f1 * 1.5F + a.fromDPToPix(getContext(), 8) * 2;
    ad.i("MicroMsg.AppBrandDesktopDragView", "alvinluo fillFloatView iconLayout: %f", new Object[] { Float.valueOf(f2) });
    localView1.findViewById(2131300899).getLayoutParams().height = ((int)f2);
    locale.lVz.getLayoutParams().height = ((int)f2);
    locale.lVz.getLayoutParams().width = ((int)f1 + (int)(a.ap(getContext(), 2131165568) * 2 * d.dT(getContext())));
    locale.kXS.getLayoutParams().width = ((int)f1);
    locale.kXS.getLayoutParams().height = ((int)f1);
    locale.lVy.getLayoutParams().width = ((int)f1);
    locale.lVy.getLayoutParams().height = ((int)f1);
    parame = locale.lVB.getLayoutParams();
    if ((parame instanceof RelativeLayout.LayoutParams))
    {
      ((RelativeLayout.LayoutParams)parame).topMargin = (a.fromDPToPix(getContext(), 6) + (int)(f1 * 0.5F / 2.0F));
      parame.width = ((int)(getContext().getResources().getDimensionPixelSize(2131165480) * d.dT(getContext())));
      parame.height = ((int)(getContext().getResources().getDimensionPixelSize(2131165480) * d.dT(getContext())));
    }
    float f3 = (f1 * 1.5F - f1) / 2.0F;
    f2 = arrayOfInt[0] + getOffsetX();
    f3 = arrayOfInt[1] + this.paddingTop - f3 - a.fromDPToPix(getContext(), 48);
    localView1.findViewById(2131296835).setVisibility(4);
    localView1.findViewById(2131300892).animate().alpha(0.5F).setDuration(300L).setListener(null).start();
    fZ(false);
    localView1.findViewById(2131300892).animate().scaleX(1.5F).scaleY(1.5F).setDuration(300L).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(49499);
        AppBrandDesktopDragView.this.fZ(true);
        AppMethodBeat.o(49499);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    }).start();
    parame = (ImageView)localView1.findViewById(2131305201);
    parame.getLayoutParams().height = ((int)(a.fromDPToPix(getContext(), 24) * d.dT(getContext())));
    parame.getLayoutParams().width = ((int)(a.fromDPToPix(getContext(), 24) * d.dT(getContext())));
    parame.setTranslationY(-f1 * 0.5F / 2.0F);
    parame.setTranslationX(f1 * 0.5F / 2.0F);
    localView1.setTranslationX(f2);
    localView1.setTranslationY(f3);
    ad.i("MicroMsg.AppBrandDesktopDragView", "alvinluo fillFloatView offsetX: %f, transX: %f, transY: %f", new Object[] { Float.valueOf(getOffsetX()), Float.valueOf(f2), Float.valueOf(f3) });
    AppMethodBeat.o(49510);
    return localView1;
  }
  
  protected final RecyclerView.v e(float paramFloat1, float paramFloat2, boolean paramBoolean)
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
    RecyclerView.v localv;
    Object localObject2;
    int j;
    if (k < getRecyclerView().getChildCount())
    {
      localv = getRecyclerView().bh(getRecyclerView().getChildAt(k));
      localObject2 = localObject1;
      j = i;
      if (localv.arM != 7)
      {
        localObject2 = localObject1;
        j = i;
        if (localv.arM != 3)
        {
          localObject2 = localObject1;
          j = i;
          if (localv.arM != 8)
          {
            localv.arI.getGlobalVisibleRect(this.mRect);
            localObject2 = localObject1;
            j = i;
            if (this.mRect.contains((int)paramFloat1, (int)paramFloat2)) {
              if (2 == localv.arM)
              {
                RecyclerView localRecyclerView = (RecyclerView)localv.arI.findViewById(2131303807);
                j = 0;
                label195:
                if (j < localRecyclerView.getAdapter().getItemCount())
                {
                  localObject2 = localRecyclerView.cj(j);
                  if ((localObject2 == null) || (((RecyclerView.v)localObject2).arI == null)) {
                    break label435;
                  }
                  ((RecyclerView.v)localObject2).arI.getGlobalVisibleRect(this.mRect);
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
        localObject2 = localv;
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
          if (this.lTL)
          {
            if (((RecyclerView.v)localObject1).arM == 1)
            {
              AppMethodBeat.o(49509);
              return localObject1;
            }
          }
          else if (((RecyclerView.v)localObject1).arM == 7)
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
    getGlobalVisibleRect(this.lVJ);
    this.lVJ.set(this.lVJ.left, this.lVJ.bottom - this.lVD - (int)(getContext().getResources().getDimensionPixelSize(2131166416) * 1.0F) - 40, this.lVJ.right, this.lVJ.bottom - this.lVD);
    ad.i("MicroMsg.AppBrandDesktopDragView", "alvinluo bottomRect: %s", new Object[] { this.lVJ });
    getRecyclerView().getGlobalVisibleRect(this.lVK);
    this.lVK.set(this.lVK.left, 0, this.lVK.right, this.lVK.top + this.lVD);
    AppMethodBeat.o(49507);
  }
  
  public void setAppBrandCounter(a parama)
  {
    this.lTR = parama;
  }
  
  public void setCollectionCallback(b paramb)
  {
    this.lTN = paramb;
  }
  
  public void setCollectionStartPosition(int paramInt)
  {
    this.lTK = paramInt;
  }
  
  public void setCopyList(List paramList)
  {
    this.lTJ = paramList;
  }
  
  public void setHeaderContainer(HeaderContainer paramHeaderContainer)
  {
    this.lRJ = paramHeaderContainer;
  }
  
  public void setItemPadding(int paramInt)
  {
    this.paddingLeft = paramInt;
  }
  
  public void setList(List paramList)
  {
    this.lEL = paramList;
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
        this.cHw = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("transY", new float[] { 0.0F, f }) });
        final int i = this.lRJ.getBackUpFooterRect().top;
        this.cHw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          float lTV = 0.0F;
          float lTW = 0.0F;
          
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(49500);
            try
            {
              float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue("transY")).floatValue();
              this.lTW += f - this.lTV;
              AppBrandDesktopDragView.f(AppBrandDesktopDragView.this).getBackUpFooterRect().top = ((int)(i + f));
              ad.v("MicroMsg.AppBrandDesktopDragView", "alvinluo transBackFooterAnim totalValue: %f, top: %d", new Object[] { Float.valueOf(this.lTW), Integer.valueOf(AppBrandDesktopDragView.f(AppBrandDesktopDragView.this).getBackUpFooterRect().top) });
              AppBrandDesktopDragView.f(AppBrandDesktopDragView.this).setExtraBottomHeight(paramInt - (int)this.lTW);
              AppBrandDesktopDragView.f(AppBrandDesktopDragView.this).requestLayout();
              this.lTV = f;
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
        this.cHw.setDuration(300L);
        this.cHw.start();
        AppMethodBeat.o(49506);
        return;
        bool = false;
        break;
      }
    }
  }
  
  public void setViewWidth(int paramInt)
  {
    this.aNI = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract int brP();
  }
  
  public static abstract interface b
  {
    public abstract void cJ(Object paramObject);
    
    public abstract void cK(Object paramObject);
    
    public abstract void cL(Object paramObject);
    
    public abstract void g(int paramInt1, int paramInt2, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView
 * JD-Core Version:    0.7.0.1
 */