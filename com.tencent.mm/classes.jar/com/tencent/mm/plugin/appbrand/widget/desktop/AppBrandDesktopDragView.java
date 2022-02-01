package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
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
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.c;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.d.a;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.e;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aa;
import java.util.List;

public class AppBrandDesktopDragView
  extends DragFeatureView
{
  private int aYN;
  private List nZr;
  private List omN;
  private int omO;
  private boolean omP;
  private boolean omQ;
  private b omR;
  private int omS;
  private boolean omT;
  private boolean omU;
  private boolean omV;
  private boolean omW;
  private a omX;
  private d omY;
  private int paddingLeft;
  private int paddingTop;
  
  public AppBrandDesktopDragView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49501);
    this.omO = 0;
    this.omP = false;
    this.omQ = false;
    this.omR = null;
    this.omS = 0;
    this.paddingLeft = 0;
    this.paddingTop = 0;
    this.omT = false;
    this.omU = false;
    this.omV = true;
    this.omW = true;
    this.aYN = 0;
    init();
    AppMethodBeat.o(49501);
  }
  
  public AppBrandDesktopDragView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49502);
    this.omO = 0;
    this.omP = false;
    this.omQ = false;
    this.omR = null;
    this.omS = 0;
    this.paddingLeft = 0;
    this.paddingTop = 0;
    this.omT = false;
    this.omU = false;
    this.omV = true;
    this.omW = true;
    this.aYN = 0;
    init();
    AppMethodBeat.o(49502);
  }
  
  private int cR(Object paramObject)
  {
    AppMethodBeat.i(49508);
    int i;
    if (this.omP) {
      if ((this.omX != null) && (this.omX.caq() - 1 >= a.byo())) {
        i = 1;
      }
    }
    while (i != 0)
    {
      Log.i("MicroMsg.AppBrandDesktopDragView", "alvinluo checkCanInsert current: %d, over limit: %d", new Object[] { Integer.valueOf(this.omX.caq()), Integer.valueOf(a.byo()) });
      AppMethodBeat.o(49508);
      return 2;
      i = 0;
      continue;
      if ((this.omX != null) && (this.omX.caq() >= a.byo())) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((paramObject instanceof AppBrandDesktopView.c))
    {
      paramObject = (AppBrandDesktopView.c)paramObject;
      if (paramObject.ooj != null)
      {
        if (j.a.vP(paramObject.ooj.iOo))
        {
          if (paramObject.ooj.kWb <= System.currentTimeMillis() / 1000L)
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
    float f = -this.aYN / 2.0F;
    AppMethodBeat.o(49511);
    return f;
  }
  
  private float getOffsetY()
  {
    AppMethodBeat.i(49512);
    float f2 = b.ey(getContext());
    float f3 = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8) * 2;
    float f1 = com.tencent.mm.cb.a.fromDPToPix(getContext(), 40);
    f2 = (f2 * 1.5F + f3) / 2.0F;
    AppMethodBeat.o(49512);
    return 0.0F - f1 - f2;
  }
  
  private void init()
  {
    AppMethodBeat.i(49503);
    this.paddingTop = getResources().getDimensionPixelOffset(2131165498);
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
    if ((paramBoolean) && (this.omU))
    {
      AppMethodBeat.o(49505);
      return;
    }
    if ((paramView.getVisibility() != 0) && (!paramBoolean))
    {
      AppMethodBeat.o(49505);
      return;
    }
    if ((!paramBoolean) && (this.omT))
    {
      AppMethodBeat.o(49505);
      return;
    }
    if (paramBoolean)
    {
      this.omU = true;
      paramView.setScaleX(0.1F);
      paramView.setScaleY(0.1F);
      paramView.setVisibility(0);
      paramView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(200L).setListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49496);
          AppBrandDesktopDragView.f(AppBrandDesktopDragView.this);
          AppMethodBeat.o(49496);
        }
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(49495);
          AppBrandDesktopDragView.f(AppBrandDesktopDragView.this);
          AppMethodBeat.o(49495);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
      }).start();
      AppMethodBeat.o(49505);
      return;
    }
    this.omT = true;
    paramView.setScaleX(1.0F);
    paramView.setScaleY(1.0F);
    paramView.setVisibility(0);
    paramView.animate().scaleX(0.0F).scaleY(0.0F).setDuration(200L).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(49498);
        AppBrandDesktopDragView.g(AppBrandDesktopDragView.this);
        paramView.setVisibility(4);
        AppMethodBeat.o(49498);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(49497);
        AppBrandDesktopDragView.g(AppBrandDesktopDragView.this);
        paramView.setVisibility(4);
        AppMethodBeat.o(49497);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    }).start();
    AppMethodBeat.o(49505);
  }
  
  protected final c P(RecyclerView.v paramv)
  {
    AppMethodBeat.i(49504);
    if ((paramv != null) && (paramv.auw == 2))
    {
      this.omP = false;
      paramv = new com.tencent.mm.plugin.appbrand.widget.desktop.a.d(this, this.omN, this.nZr, new d.a()
      {
        public final boolean K(Object paramAnonymousObject1, Object paramAnonymousObject2)
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
            if ((paramAnonymousObject2.ooj != null) && (paramAnonymousObject1.ooj != null) && (!Util.isNullOrNil(paramAnonymousObject2.ooj.username)) && (!Util.isNullOrNil(paramAnonymousObject1.ooj.username)))
            {
              paramAnonymousObject1 = paramAnonymousObject1.ooj;
              paramAnonymousObject2 = paramAnonymousObject2.ooj;
              if ((paramAnonymousObject2 != null) && (!Util.isNullOrNil(paramAnonymousObject2.username)) && (paramAnonymousObject2.username.equals(paramAnonymousObject1.username)) && (paramAnonymousObject2.iOo == paramAnonymousObject1.iOo))
              {
                i = 1;
                if (i == 0) {
                  break label157;
                }
              }
            }
            label157:
            for (int i = 1;; i = 0)
            {
              if (i == 0) {
                break label162;
              }
              AppMethodBeat.o(49481);
              return true;
              i = 0;
              break;
            }
          }
          label162:
          AppMethodBeat.o(49481);
          return false;
        }
        
        public final View cQ(View paramAnonymousView)
        {
          AppMethodBeat.i(49476);
          paramAnonymousView = paramAnonymousView.findViewById(2131302498);
          AppMethodBeat.o(49476);
          return paramAnonymousView;
        }
        
        public final Object cS(Object paramAnonymousObject)
        {
          AppMethodBeat.i(49475);
          if ((paramAnonymousObject instanceof AppBrandDesktopView.c))
          {
            paramAnonymousObject = (AppBrandDesktopView.c)paramAnonymousObject;
            AppBrandDesktopView.c localc = new AppBrandDesktopView.c(1);
            localc.ooj = paramAnonymousObject.ooj;
            localc.position = paramAnonymousObject.position;
            AppMethodBeat.o(49475);
            return localc;
          }
          AppMethodBeat.o(49475);
          return paramAnonymousObject;
        }
        
        public final float cam()
        {
          AppMethodBeat.i(49477);
          float f = AppBrandDesktopDragView.a(AppBrandDesktopDragView.this);
          AppMethodBeat.o(49477);
          return f;
        }
        
        public final float can()
        {
          AppMethodBeat.i(49478);
          float f = AppBrandDesktopDragView.b(AppBrandDesktopDragView.this);
          AppMethodBeat.o(49478);
          return f;
        }
        
        public final void cao()
        {
          AppMethodBeat.i(49479);
          Log.d("MicroMsg.AppBrandDesktopDragView", "alvinluo onInsert");
          AppBrandDesktopDragView.a(AppBrandDesktopDragView.this, true);
          AppMethodBeat.o(49479);
        }
        
        public final void cap()
        {
          AppMethodBeat.i(49480);
          Log.d("MicroMsg.AppBrandDesktopDragView", "alvinluo onCancelInsert");
          AppBrandDesktopDragView.a(AppBrandDesktopDragView.this, false);
          AppMethodBeat.o(49480);
        }
        
        public final void i(Object paramAnonymousObject, int paramAnonymousInt)
        {
          if ((paramAnonymousObject instanceof AppBrandDesktopView.c)) {
            ((AppBrandDesktopView.c)paramAnonymousObject).position = paramAnonymousInt;
          }
        }
      });
      i = getResources().getDimensionPixelSize(2131165586);
      j = this.paddingLeft;
      paramv.paddingTop = i;
      paramv.paddingLeft = j;
      paramv.ooV = getRecyclerScrollComputer();
      paramv.opC = new com.tencent.mm.plugin.appbrand.widget.desktop.a.a()
      {
        public final View Q(RecyclerView.v paramAnonymousv)
        {
          AppMethodBeat.i(227750);
          if ((paramAnonymousv instanceof d))
          {
            paramAnonymousv = AppBrandDesktopDragView.this.a((d)paramAnonymousv);
            AppMethodBeat.o(227750);
            return paramAnonymousv;
          }
          AppMethodBeat.o(227750);
          return null;
        }
        
        public final boolean R(RecyclerView.v paramAnonymousv)
        {
          AppMethodBeat.i(227751);
          if ((paramAnonymousv.auw == 2) && (AppBrandDesktopDragView.d(AppBrandDesktopDragView.this)))
          {
            AppMethodBeat.o(227751);
            return true;
          }
          AppMethodBeat.o(227751);
          return false;
        }
        
        public final boolean S(RecyclerView.v paramAnonymousv)
        {
          return (paramAnonymousv == null) || (paramAnonymousv.auw == 2) || (paramAnonymousv.auw == 10) || (paramAnonymousv.auw == 11);
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
        
        public final void b(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(49485);
          if ((paramAnonymousBoolean) && (AppBrandDesktopDragView.c(AppBrandDesktopDragView.this) != null)) {
            AppBrandDesktopDragView.c(AppBrandDesktopDragView.this).cU(paramAnonymousObject);
          }
          AppMethodBeat.o(49485);
        }
        
        public final boolean c(RecyclerView.v paramAnonymousv, Object paramAnonymousObject)
        {
          AppMethodBeat.i(49486);
          if (AppBrandDesktopDragView.a(AppBrandDesktopDragView.this, paramAnonymousObject) != 0)
          {
            Log.e("MicroMsg.AppBrandDesktopDragView", "alvinluo checkCanInsert can't insert");
            AppMethodBeat.o(49486);
            return false;
          }
          if ((paramAnonymousv.auw == 1) || (paramAnonymousv.auw == 2) || (paramAnonymousv.auw == 7))
          {
            AppMethodBeat.o(49486);
            return true;
          }
          AppMethodBeat.o(49486);
          return false;
        }
        
        public final void cR(View paramAnonymousView)
        {
          AppMethodBeat.i(49484);
          if (paramAnonymousView != null)
          {
            View localView = paramAnonymousView.findViewById(2131308398);
            if (localView != null) {
              localView.setVisibility(4);
            }
            paramAnonymousView = paramAnonymousView.findViewById(2131296927);
            if (paramAnonymousView != null) {
              paramAnonymousView.setVisibility(4);
            }
          }
          AppMethodBeat.o(49484);
        }
        
        public final void cT(Object paramAnonymousObject)
        {
          AppMethodBeat.i(49487);
          if ((paramAnonymousObject instanceof AppBrandDesktopView.c))
          {
            ((AppBrandDesktopView.c)paramAnonymousObject).type = 2;
            if (AppBrandDesktopDragView.c(AppBrandDesktopDragView.this) != null) {
              AppBrandDesktopDragView.c(AppBrandDesktopDragView.this).cW(paramAnonymousObject);
            }
          }
          AppMethodBeat.o(49487);
        }
      };
      AppMethodBeat.o(49504);
      return paramv;
    }
    this.omP = true;
    paramv = new e(this, this.nZr, new f()
    {
      public final View cQ(View paramAnonymousView)
      {
        AppMethodBeat.i(49489);
        paramAnonymousView = paramAnonymousView.findViewById(2131302498);
        AppMethodBeat.o(49489);
        return paramAnonymousView;
      }
      
      public final Object cS(Object paramAnonymousObject)
      {
        AppMethodBeat.i(49488);
        if ((paramAnonymousObject instanceof AppBrandDesktopView.c))
        {
          paramAnonymousObject = (AppBrandDesktopView.c)paramAnonymousObject;
          AppBrandDesktopView.c localc = new AppBrandDesktopView.c(1);
          localc.ooj = paramAnonymousObject.ooj;
          AppMethodBeat.o(49488);
          return localc;
        }
        AppMethodBeat.o(49488);
        return paramAnonymousObject;
      }
      
      public final float cam()
      {
        AppMethodBeat.i(49490);
        float f = AppBrandDesktopDragView.a(AppBrandDesktopDragView.this);
        AppMethodBeat.o(49490);
        return f;
      }
      
      public final float can()
      {
        AppMethodBeat.i(49491);
        float f = AppBrandDesktopDragView.b(AppBrandDesktopDragView.this);
        AppMethodBeat.o(49491);
        return f;
      }
      
      public final void i(Object paramAnonymousObject, int paramAnonymousInt)
      {
        if ((paramAnonymousObject instanceof AppBrandDesktopView.c)) {
          ((AppBrandDesktopView.c)paramAnonymousObject).position = paramAnonymousInt;
        }
      }
    });
    paramv.ooV = getRecyclerScrollComputer();
    paramv.opC = new com.tencent.mm.plugin.appbrand.widget.desktop.a.a()
    {
      public final View Q(RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(227752);
        paramAnonymousv = AppBrandDesktopDragView.this.a((d)paramAnonymousv);
        AppMethodBeat.o(227752);
        return paramAnonymousv;
      }
      
      public final boolean R(RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(227753);
        if ((paramAnonymousv.auw == 1) && (AppBrandDesktopDragView.e(AppBrandDesktopDragView.this)))
        {
          AppMethodBeat.o(227753);
          return true;
        }
        AppMethodBeat.o(227753);
        return false;
      }
      
      public final boolean S(RecyclerView.v paramAnonymousv)
      {
        return false;
      }
      
      public final void a(RecyclerView.v paramAnonymousv, View paramAnonymousView, Object paramAnonymousObject, int paramAnonymousInt) {}
      
      public final void b(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(49493);
        if (AppBrandDesktopDragView.c(AppBrandDesktopDragView.this) != null) {
          AppBrandDesktopDragView.c(AppBrandDesktopDragView.this).f(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
        }
        AppMethodBeat.o(49493);
      }
      
      public final boolean c(RecyclerView.v paramAnonymousv, Object paramAnonymousObject)
      {
        return (paramAnonymousv.auw == 1) || (paramAnonymousv.auw == 7);
      }
      
      public final void cR(View paramAnonymousView) {}
      
      public final void cT(Object paramAnonymousObject)
      {
        AppMethodBeat.i(49494);
        if (((paramAnonymousObject instanceof AppBrandDesktopView.c)) && (AppBrandDesktopDragView.c(AppBrandDesktopDragView.this) != null)) {
          AppBrandDesktopDragView.c(AppBrandDesktopDragView.this).cV(paramAnonymousObject);
        }
        AppMethodBeat.o(49494);
      }
    };
    int i = getResources().getDimensionPixelSize(2131165586);
    int j = this.paddingLeft;
    paramv.paddingTop = i;
    paramv.paddingLeft = j;
    AppMethodBeat.o(49504);
    return paramv;
  }
  
  protected final View a(d paramd)
  {
    AppMethodBeat.i(49510);
    View localView = aa.jQ(getContext()).inflate(2131495163, null, false);
    localView.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
    this.omY = new d(localView);
    d locald = this.omY;
    localView = locald.aus;
    localView.setScaleX(1.0F);
    localView.setScaleY(1.0F);
    localView.setAlpha(1.0F);
    localView.setVisibility(0);
    int[] arrayOfInt = new int[2];
    paramd.nnL.getLocationOnScreen(arrayOfInt);
    locald.nnL.setImageDrawable(paramd.nnL.getDrawable());
    locald.nnL.setBackground(paramd.nnL.getBackground());
    locald.ooD.setText(paramd.ooD.getText());
    locald.ooD.setVisibility(paramd.ooD.getVisibility());
    locald.ooE.setVisibility(4);
    float f1 = b.ey(getContext());
    float f2 = 1.5F * f1 + com.tencent.mm.cb.a.fromDPToPix(getContext(), 8) * 2;
    Log.i("MicroMsg.AppBrandDesktopDragView", "alvinluo fillFloatView iconLayout: %f", new Object[] { Float.valueOf(f2) });
    localView.findViewById(2131302507).getLayoutParams().height = ((int)f2);
    locald.ooC.getLayoutParams().height = ((int)f2);
    locald.ooC.getLayoutParams().width = ((int)f1 + (int)(com.tencent.mm.cb.a.aH(getContext(), 2131165586) * 2 * b.ez(getContext())));
    locald.nnL.getLayoutParams().width = ((int)f1);
    locald.nnL.getLayoutParams().height = ((int)f1);
    locald.ooB.getLayoutParams().width = ((int)f1);
    locald.ooB.getLayoutParams().height = ((int)f1);
    paramd = locald.ooE.getLayoutParams();
    if ((paramd instanceof RelativeLayout.LayoutParams))
    {
      ((RelativeLayout.LayoutParams)paramd).topMargin = (com.tencent.mm.cb.a.fromDPToPix(getContext(), 6) + (int)(f1 * 0.5F / 2.0F));
      paramd.width = ((int)(getContext().getResources().getDimensionPixelSize(2131165498) * b.ez(getContext())));
      paramd.height = ((int)(getContext().getResources().getDimensionPixelSize(2131165498) * b.ez(getContext())));
    }
    arrayOfInt[0] = ((int)(arrayOfInt[0] + f1 / 2.0F));
    arrayOfInt[1] = ((int)(arrayOfInt[1] + f1 / 2.0F));
    f2 = arrayOfInt[0];
    f2 = getOffsetX() + f2;
    float f3 = arrayOfInt[1];
    f3 = getOffsetY() + f3;
    localView.findViewById(2131296927).setVisibility(4);
    localView.findViewById(2131302498).animate().alpha(0.5F).setDuration(300L).setListener(null).start();
    hx(false);
    localView.findViewById(2131302498).animate().scaleX(1.5F).scaleY(1.5F).setDuration(300L).setListener(new Animator.AnimatorListener()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(49499);
        AppBrandDesktopDragView.this.hx(true);
        AppMethodBeat.o(49499);
      }
      
      public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
      
      public final void onAnimationStart(Animator paramAnonymousAnimator) {}
    }).start();
    paramd = (ImageView)localView.findViewById(2131308398);
    paramd.getLayoutParams().height = ((int)(com.tencent.mm.cb.a.fromDPToPix(getContext(), 24) * b.ez(getContext())));
    paramd.getLayoutParams().width = ((int)(com.tencent.mm.cb.a.fromDPToPix(getContext(), 24) * b.ez(getContext())));
    paramd.setTranslationY(-f1 * 0.5F / 2.0F);
    paramd.setTranslationX(f1 * 0.5F / 2.0F);
    localView.setTranslationX(f2);
    localView.setTranslationY(f3);
    Log.i("MicroMsg.AppBrandDesktopDragView", "alvinluo fillFloatView offsetX: %f, transX: %f, transY: %f", new Object[] { Float.valueOf(getOffsetX()), Float.valueOf(f2), Float.valueOf(f3) });
    AppMethodBeat.o(49510);
    return localView;
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
      localv = getRecyclerView().bi(getRecyclerView().getChildAt(k));
      localObject2 = localObject1;
      j = i;
      if (localv.auw != 7)
      {
        localObject2 = localObject1;
        j = i;
        if (localv.auw != 3)
        {
          localObject2 = localObject1;
          j = i;
          if (localv.auw != 8)
          {
            localv.aus.getGlobalVisibleRect(this.mRect);
            localObject2 = localObject1;
            j = i;
            if (this.mRect.contains((int)paramFloat1, (int)paramFloat2)) {
              if (2 == localv.auw)
              {
                RecyclerView localRecyclerView = (RecyclerView)localv.aus.findViewById(2131306610);
                j = 0;
                label195:
                if (j < localRecyclerView.getAdapter().getItemCount())
                {
                  localObject2 = localRecyclerView.ch(j);
                  if ((localObject2 == null) || (((RecyclerView.v)localObject2).aus == null)) {
                    break label435;
                  }
                  ((RecyclerView.v)localObject2).aus.getGlobalVisibleRect(this.mRect);
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
          localObject1 = getRecyclerView().bi(getRecyclerView().getChildAt(i));
          if (this.omP)
          {
            if (((RecyclerView.v)localObject1).auw == 1)
            {
              AppMethodBeat.o(49509);
              return localObject1;
            }
          }
          else if (((RecyclerView.v)localObject1).auw == 7)
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
    getGlobalVisibleRect(this.ooO);
    this.ooO.set(this.ooO.left, this.ooO.bottom - this.ooH - (int)(getContext().getResources().getDimensionPixelSize(2131166508) * 1.0F) - 40, this.ooO.right, this.ooO.bottom - this.ooH);
    Log.i("MicroMsg.AppBrandDesktopDragView", "alvinluo bottomRect: %s", new Object[] { this.ooO });
    getRecyclerView().getGlobalVisibleRect(this.ooP);
    this.ooP.set(this.ooP.left, 0, this.ooP.right, this.ooP.top + this.ooH);
    AppMethodBeat.o(49507);
  }
  
  public void setAppBrandCounter(a parama)
  {
    this.omX = parama;
  }
  
  public void setCollectionCallback(b paramb)
  {
    this.omR = paramb;
  }
  
  public void setCollectionStartPosition(int paramInt)
  {
    this.omO = paramInt;
  }
  
  public void setCopyList(List paramList)
  {
    this.omN = paramList;
  }
  
  public void setItemPadding(int paramInt)
  {
    this.paddingLeft = paramInt;
  }
  
  public void setList(List paramList)
  {
    this.nZr = paramList;
  }
  
  public void setMyListDragEnable(boolean paramBoolean)
  {
    this.omW = paramBoolean;
  }
  
  public void setRecentListDragEnable(boolean paramBoolean)
  {
    this.omV = paramBoolean;
  }
  
  protected void setRubbishViewVisible(int paramInt)
  {
    AppMethodBeat.i(49506);
    super.setRubbishViewVisible(paramInt);
    AppMethodBeat.o(49506);
  }
  
  public void setViewWidth(int paramInt)
  {
    this.aYN = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract int caq();
  }
  
  public static abstract interface b
  {
    public abstract void cU(Object paramObject);
    
    public abstract void cV(Object paramObject);
    
    public abstract void cW(Object paramObject);
    
    public abstract void f(int paramInt1, int paramInt2, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView
 * JD-Core Version:    0.7.0.1
 */