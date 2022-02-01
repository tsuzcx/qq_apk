package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.d;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.c;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.ad;
import java.util.List;

public class AppBrandDesktopDragView
  extends DragFeatureView
{
  private int aIj;
  private List rbc;
  private boolean rpA;
  private boolean rpB;
  private Rect rpC;
  d rpD;
  private a rpz;
  
  public AppBrandDesktopDragView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49501);
    this.rpz = null;
    this.aIj = 0;
    this.rpA = true;
    this.rpB = false;
    this.rpC = new Rect();
    AppMethodBeat.o(49501);
  }
  
  public AppBrandDesktopDragView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49502);
    this.rpz = null;
    this.aIj = 0;
    this.rpA = true;
    this.rpB = false;
    this.rpC = new Rect();
    AppMethodBeat.o(49502);
  }
  
  protected final boolean N(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(275615);
    if (this.rqw.amo == 1)
    {
      AppMethodBeat.o(275615);
      return false;
    }
    boolean bool = super.N(paramMotionEvent);
    AppMethodBeat.o(275615);
    return bool;
  }
  
  protected final c cnn()
  {
    AppMethodBeat.i(275613);
    com.tencent.mm.plugin.appbrand.widget.desktop.a.d locald = new com.tencent.mm.plugin.appbrand.widget.desktop.a.d(this, this.rbc, new e()
    {
      public final float cno()
      {
        AppMethodBeat.i(49477);
        float f = AppBrandDesktopDragView.b(AppBrandDesktopDragView.this);
        AppMethodBeat.o(49477);
        return f;
      }
      
      public final float cnp()
      {
        AppMethodBeat.i(49478);
        float f = AppBrandDesktopDragView.c(AppBrandDesktopDragView.this);
        AppMethodBeat.o(49478);
        return f;
      }
      
      public final boolean cnq()
      {
        AppMethodBeat.i(264738);
        boolean bool = AppBrandDesktopDragView.d(AppBrandDesktopDragView.this);
        AppMethodBeat.o(264738);
        return bool;
      }
      
      public final View dk(View paramAnonymousView)
      {
        AppMethodBeat.i(49476);
        paramAnonymousView = paramAnonymousView.findViewById(au.f.icon_layout);
        AppMethodBeat.o(49476);
        return paramAnonymousView;
      }
      
      public final Object j(Object paramAnonymousObject, int paramAnonymousInt)
      {
        AppMethodBeat.i(264737);
        if (AppBrandDesktopDragView.a(AppBrandDesktopDragView.this) != null) {
          AppBrandDesktopDragView.a(AppBrandDesktopDragView.this).d(paramAnonymousInt, true, false);
        }
        if ((paramAnonymousObject instanceof AppBrandDesktopView.a))
        {
          paramAnonymousObject = (AppBrandDesktopView.a)paramAnonymousObject;
          AppBrandDesktopView.a locala = new AppBrandDesktopView.a(paramAnonymousObject.type);
          locala.rqa = paramAnonymousObject.rqa;
          AppMethodBeat.o(264737);
          return locala;
        }
        AppMethodBeat.o(264737);
        return paramAnonymousObject;
      }
    });
    locald.rqJ = getRecyclerScrollComputer();
    locald.rqV = new com.tencent.mm.plugin.appbrand.widget.desktop.a.a()
    {
      public final View P(RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(282099);
        AppBrandDesktopDragView localAppBrandDesktopDragView = AppBrandDesktopDragView.this;
        Object localObject = (d)paramAnonymousv;
        paramAnonymousv = ad.kS(localAppBrandDesktopDragView.getContext()).inflate(au.g.layout_appbrand_desktop_float_view, null, false);
        paramAnonymousv.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
        localAppBrandDesktopDragView.rpD = new d(paramAnonymousv);
        d locald = localAppBrandDesktopDragView.rpD;
        paramAnonymousv = locald.amk;
        paramAnonymousv.setScaleX(1.0F);
        paramAnonymousv.setScaleY(1.0F);
        paramAnonymousv.setAlpha(1.0F);
        paramAnonymousv.setVisibility(0);
        int[] arrayOfInt = new int[2];
        ((d)localObject).qps.getLocationOnScreen(arrayOfInt);
        locald.qps.setImageDrawable(((d)localObject).qps.getDrawable());
        locald.qps.setBackground(((d)localObject).qps.getBackground());
        locald.rqk.setText(((d)localObject).rqk.getText());
        locald.rqk.setVisibility(((d)localObject).rqk.getVisibility());
        locald.rql.setVisibility(4);
        float f1 = b.ey(localAppBrandDesktopDragView.getContext());
        float f2 = 1.5F * f1 + com.tencent.mm.ci.a.fromDPToPix(localAppBrandDesktopDragView.getContext(), 8) * 2;
        Log.i("MicroMsg.AppBrandDesktopDragView", "alvinluo fillFloatView iconLayout: %f", new Object[] { Float.valueOf(f2) });
        paramAnonymousv.findViewById(au.f.icon_root_layout).getLayoutParams().height = ((int)f2);
        locald.rqj.getLayoutParams().height = ((int)f2);
        locald.rqj.getLayoutParams().width = ((int)f1 + (int)(com.tencent.mm.ci.a.aZ(localAppBrandDesktopDragView.getContext(), au.d.SmallPadding) * 2 * b.ez(localAppBrandDesktopDragView.getContext())));
        locald.qps.getLayoutParams().width = ((int)f1);
        locald.qps.getLayoutParams().height = ((int)f1);
        locald.rqi.getLayoutParams().width = ((int)f1);
        locald.rqi.getLayoutParams().height = ((int)f1);
        localObject = locald.rql.getLayoutParams();
        if ((localObject instanceof RelativeLayout.LayoutParams))
        {
          ((RelativeLayout.LayoutParams)localObject).topMargin = (com.tencent.mm.ci.a.fromDPToPix(localAppBrandDesktopDragView.getContext(), 6) + (int)(f1 * 0.5F / 2.0F));
          ((ViewGroup.LayoutParams)localObject).width = ((int)(localAppBrandDesktopDragView.getContext().getResources().getDimensionPixelSize(au.d.LargePadding) * b.ez(localAppBrandDesktopDragView.getContext())));
          ((ViewGroup.LayoutParams)localObject).height = ((int)(localAppBrandDesktopDragView.getContext().getResources().getDimensionPixelSize(au.d.LargePadding) * b.ez(localAppBrandDesktopDragView.getContext())));
        }
        arrayOfInt[0] = ((int)(arrayOfInt[0] + f1 / 2.0F));
        arrayOfInt[1] = ((int)(arrayOfInt[1] + f1 / 2.0F));
        f2 = arrayOfInt[0];
        f2 = localAppBrandDesktopDragView.getOffsetX() + f2;
        float f3 = arrayOfInt[1];
        f3 = localAppBrandDesktopDragView.getOffsetY() + f3;
        paramAnonymousv.findViewById(au.f.app_brand_tips_layout).setVisibility(4);
        paramAnonymousv.findViewById(au.f.icon_layout).animate().alpha(0.5F).setDuration(300L).setListener(null).start();
        localAppBrandDesktopDragView.in(false);
        paramAnonymousv.findViewById(au.f.icon_layout).animate().scaleX(1.5F).scaleY(1.5F).setDuration(300L).setListener(new AppBrandDesktopDragView.3(localAppBrandDesktopDragView)).start();
        localObject = (ImageView)paramAnonymousv.findViewById(au.f.status_icon);
        ((ImageView)localObject).getLayoutParams().height = ((int)(com.tencent.mm.ci.a.fromDPToPix(localAppBrandDesktopDragView.getContext(), 24) * b.ez(localAppBrandDesktopDragView.getContext())));
        ((ImageView)localObject).getLayoutParams().width = ((int)(com.tencent.mm.ci.a.fromDPToPix(localAppBrandDesktopDragView.getContext(), 24) * b.ez(localAppBrandDesktopDragView.getContext())));
        ((ImageView)localObject).setTranslationY(-f1 * 0.5F / 2.0F);
        ((ImageView)localObject).setTranslationX(f1 * 0.5F / 2.0F);
        paramAnonymousv.setTranslationX(f2);
        paramAnonymousv.setTranslationY(f3);
        Log.i("MicroMsg.AppBrandDesktopDragView", "alvinluo fillFloatView offsetX: %f, transX: %f, transY: %f", new Object[] { Float.valueOf(localAppBrandDesktopDragView.getOffsetX()), Float.valueOf(f2), Float.valueOf(f3) });
        AppMethodBeat.o(282099);
        return paramAnonymousv;
      }
      
      public final boolean Q(RecyclerView.v paramAnonymousv)
      {
        return (paramAnonymousv.amo == 2) || (paramAnonymousv.amo == 1);
      }
      
      public final boolean R(RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(282104);
        if ((AppBrandDesktopDragView.f(AppBrandDesktopDragView.this)) && ((paramAnonymousv.amo == 2) || (paramAnonymousv.amo == 5)))
        {
          AppMethodBeat.o(282104);
          return true;
        }
        AppMethodBeat.o(282104);
        return false;
      }
      
      public final void U(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(282101);
        if (AppBrandDesktopDragView.a(AppBrandDesktopDragView.this) != null) {
          AppBrandDesktopDragView.a(AppBrandDesktopDragView.this).d(paramAnonymousInt, false, paramAnonymousBoolean);
        }
        AppMethodBeat.o(282101);
      }
      
      public final void cS(Object paramAnonymousObject)
      {
        AppMethodBeat.i(282106);
        if (((paramAnonymousObject instanceof AppBrandDesktopView.a)) && (AppBrandDesktopDragView.a(AppBrandDesktopDragView.this) != null)) {
          AppBrandDesktopDragView.a(AppBrandDesktopDragView.this).cT(paramAnonymousObject);
        }
        AppMethodBeat.o(282106);
      }
      
      public final void e(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(282100);
        if (AppBrandDesktopDragView.a(AppBrandDesktopDragView.this) != null)
        {
          paramAnonymousView.getGlobalVisibleRect(AppBrandDesktopDragView.e(AppBrandDesktopDragView.this));
          AppBrandDesktopDragView.a(AppBrandDesktopDragView.this).Q(paramAnonymousFloat1, paramAnonymousFloat2);
        }
        AppMethodBeat.o(282100);
      }
      
      public final void f(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(282103);
        if (((paramAnonymousObject instanceof AppBrandDesktopView.a)) && (((AppBrandDesktopView.a)paramAnonymousObject).type == 2) && (AppBrandDesktopDragView.a(AppBrandDesktopDragView.this) != null)) {
          AppBrandDesktopDragView.a(AppBrandDesktopDragView.this).g(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
        }
        AppMethodBeat.o(282103);
      }
      
      public final void k(Object paramAnonymousObject, int paramAnonymousInt)
      {
        AppMethodBeat.i(282105);
        if (((paramAnonymousObject instanceof AppBrandDesktopView.a)) && (AppBrandDesktopDragView.a(AppBrandDesktopDragView.this) != null))
        {
          if (((AppBrandDesktopView.a)paramAnonymousObject).type == 1)
          {
            AppBrandDesktopDragView.a(AppBrandDesktopDragView.this).m(paramAnonymousObject, paramAnonymousInt);
            AppMethodBeat.o(282105);
            return;
          }
          AppBrandDesktopDragView.a(AppBrandDesktopDragView.this).l(paramAnonymousObject, paramAnonymousInt);
        }
        AppMethodBeat.o(282105);
      }
    };
    AppMethodBeat.o(275613);
    return locald;
  }
  
  protected final RecyclerView.v e(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(275617);
    getRecyclerView().getGlobalVisibleRect(this.mRect);
    if (!this.mRect.contains((int)paramFloat1, (int)paramFloat2))
    {
      AppMethodBeat.o(275617);
      return null;
    }
    int i = 0;
    Object localObject = null;
    RecyclerView.v localv;
    if (i < getRecyclerView().getChildCount())
    {
      localv = getRecyclerView().aQ(getRecyclerView().getChildAt(i));
      if ((localv.amo != 5) && (localv.amo != 3))
      {
        localv.amk.getGlobalVisibleRect(this.mRect);
        localObject = localv;
        if (this.mRect.contains((int)paramFloat1, (int)paramFloat2))
        {
          i = 1;
          localObject = localv;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        AppMethodBeat.o(275617);
        return localv;
        i += 1;
        break;
      }
      if ((!paramBoolean) && (((paramFloat1 > this.mRect.right) && (paramFloat2 > this.mRect.top)) || (paramFloat2 > this.mRect.bottom)))
      {
        AppMethodBeat.o(275617);
        return localObject;
      }
      AppMethodBeat.o(275617);
      return null;
      localv = null;
      i = j;
    }
  }
  
  float getOffsetX()
  {
    AppMethodBeat.i(49511);
    float f = -this.aIj / 2.0F;
    AppMethodBeat.o(49511);
    return f;
  }
  
  float getOffsetY()
  {
    AppMethodBeat.i(49512);
    float f2 = b.ey(getContext());
    float f3 = com.tencent.mm.ci.a.fromDPToPix(getContext(), 8) * 2;
    float f1 = com.tencent.mm.ci.a.fromDPToPix(getContext(), 40);
    f2 = (f2 * 1.5F + f3) / 2.0F;
    AppMethodBeat.o(49512);
    return 0.0F - f1 - f2;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49507);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    getGlobalVisibleRect(this.rqA);
    this.rqA.set(this.rqA.left, this.rqA.bottom - this.rqt - (int)(getContext().getResources().getDimensionPixelSize(au.d.header_up_helper) * 1.0F) - 40, this.rqA.right, this.rqA.bottom - this.rqt);
    Log.i("MicroMsg.AppBrandDesktopDragView", "alvinluo bottomRect: %s", new Object[] { this.rqA });
    getRecyclerView().getGlobalVisibleRect(this.rqB);
    this.rqB.set(this.rqB.left, 0, this.rqB.right, this.rqB.top + this.rqt);
    AppMethodBeat.o(49507);
  }
  
  public void setAppBrandDragCallback(a parama)
  {
    this.rpz = parama;
  }
  
  public void setCanMyWeAppMove(boolean paramBoolean)
  {
    this.rpA = paramBoolean;
  }
  
  public void setList(List paramList)
  {
    this.rbc = paramList;
  }
  
  protected void setRubbishViewVisible(int paramInt)
  {
    AppMethodBeat.i(49506);
    super.setRubbishViewVisible(paramInt);
    AppMethodBeat.o(49506);
  }
  
  public void setShouldDoDeleteAnimation(boolean paramBoolean)
  {
    this.rpB = paramBoolean;
  }
  
  public void setViewWidth(int paramInt)
  {
    this.aIj = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void Q(float paramFloat1, float paramFloat2);
    
    public abstract void cT(Object paramObject);
    
    public abstract void d(int paramInt, boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void g(int paramInt1, int paramInt2, Object paramObject);
    
    public abstract void l(Object paramObject, int paramInt);
    
    public abstract void m(Object paramObject, int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView
 * JD-Core Version:    0.7.0.1
 */