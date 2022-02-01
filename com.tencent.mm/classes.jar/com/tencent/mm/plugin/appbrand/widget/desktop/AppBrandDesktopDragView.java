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
import com.tencent.mm.plugin.appbrand.ba.d;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.c;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.af;
import java.util.List;

public class AppBrandDesktopDragView
  extends DragFeatureView
{
  private List eXW;
  private int mViewWidth;
  private a uzK;
  private b uzL;
  private boolean uzM;
  private boolean uzN;
  private Rect uzO;
  d uzP;
  
  public AppBrandDesktopDragView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(49501);
    this.uzK = null;
    this.uzL = null;
    this.mViewWidth = 0;
    this.uzM = true;
    this.uzN = false;
    this.uzO = new Rect();
    AppMethodBeat.o(49501);
  }
  
  public AppBrandDesktopDragView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(49502);
    this.uzK = null;
    this.uzL = null;
    this.mViewWidth = 0;
    this.uzM = true;
    this.uzN = false;
    this.uzO = new Rect();
    AppMethodBeat.o(49502);
  }
  
  protected final boolean P(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(324308);
    if (this.uAG.caO == 1)
    {
      AppMethodBeat.o(324308);
      return false;
    }
    boolean bool = super.P(paramMotionEvent);
    AppMethodBeat.o(324308);
    return bool;
  }
  
  protected final c cPj()
  {
    AppMethodBeat.i(324302);
    com.tencent.mm.plugin.appbrand.widget.desktop.a.d locald = new com.tencent.mm.plugin.appbrand.widget.desktop.a.d(this, this.eXW, new e()
    {
      public final float cPk()
      {
        AppMethodBeat.i(49477);
        float f = AppBrandDesktopDragView.b(AppBrandDesktopDragView.this);
        AppMethodBeat.o(49477);
        return f;
      }
      
      public final float cPl()
      {
        AppMethodBeat.i(49478);
        float f = AppBrandDesktopDragView.c(AppBrandDesktopDragView.this);
        AppMethodBeat.o(49478);
        return f;
      }
      
      public final boolean cPm()
      {
        AppMethodBeat.i(324209);
        boolean bool = AppBrandDesktopDragView.d(AppBrandDesktopDragView.this);
        AppMethodBeat.o(324209);
        return bool;
      }
      
      public final View dV(View paramAnonymousView)
      {
        AppMethodBeat.i(49476);
        paramAnonymousView = paramAnonymousView.findViewById(ba.f.icon_layout);
        AppMethodBeat.o(49476);
        return paramAnonymousView;
      }
      
      public final View dW(View paramAnonymousView)
      {
        AppMethodBeat.i(324199);
        paramAnonymousView = paramAnonymousView.findViewById(ba.f.icon);
        AppMethodBeat.o(324199);
        return paramAnonymousView;
      }
      
      public final Object l(Object paramAnonymousObject, int paramAnonymousInt)
      {
        AppMethodBeat.i(324189);
        if (AppBrandDesktopDragView.a(AppBrandDesktopDragView.this) != null) {
          AppBrandDesktopDragView.a(AppBrandDesktopDragView.this).d(paramAnonymousInt, true, false);
        }
        if ((paramAnonymousObject instanceof AppBrandDesktopView.a))
        {
          paramAnonymousObject = (AppBrandDesktopView.a)paramAnonymousObject;
          AppBrandDesktopView.a locala = new AppBrandDesktopView.a(paramAnonymousObject.type);
          locala.uAl = paramAnonymousObject.uAl;
          AppMethodBeat.o(324189);
          return locala;
        }
        AppMethodBeat.o(324189);
        return paramAnonymousObject;
      }
    });
    locald.uAT = getRecyclerScrollComputer();
    locald.uBf = new com.tencent.mm.plugin.appbrand.widget.desktop.a.a()
    {
      public final View M(RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(324226);
        AppBrandDesktopDragView localAppBrandDesktopDragView = AppBrandDesktopDragView.this;
        Object localObject = (d)paramAnonymousv;
        paramAnonymousv = af.mU(localAppBrandDesktopDragView.getContext()).inflate(ba.g.layout_appbrand_desktop_float_view, null, false);
        paramAnonymousv.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
        localAppBrandDesktopDragView.uzP = new d(paramAnonymousv);
        d locald = localAppBrandDesktopDragView.uzP;
        paramAnonymousv = locald.caK;
        paramAnonymousv.setScaleX(1.0F);
        paramAnonymousv.setScaleY(1.0F);
        paramAnonymousv.setAlpha(1.0F);
        paramAnonymousv.setVisibility(0);
        int[] arrayOfInt = new int[2];
        ((d)localObject).ttT.getLocationOnScreen(arrayOfInt);
        locald.ttT.setImageDrawable(((d)localObject).ttT.getDrawable());
        locald.ttT.setBackground(((d)localObject).ttT.getBackground());
        locald.uAv.setText(((d)localObject).uAv.getText());
        locald.uAv.setVisibility(((d)localObject).uAv.getVisibility());
        locald.uAw.setVisibility(4);
        float f1 = b.fu(localAppBrandDesktopDragView.getContext());
        float f2 = 1.5F * f1 + com.tencent.mm.cd.a.fromDPToPix(localAppBrandDesktopDragView.getContext(), 8) * 2;
        Log.i("MicroMsg.AppBrandDesktopDragView", "alvinluo fillFloatView iconLayout: %f", new Object[] { Float.valueOf(f2) });
        paramAnonymousv.findViewById(ba.f.icon_root_layout).getLayoutParams().height = ((int)f2);
        locald.uAu.getLayoutParams().height = ((int)f2);
        locald.uAu.getLayoutParams().width = ((int)f1 + (int)(com.tencent.mm.cd.a.bs(localAppBrandDesktopDragView.getContext(), ba.d.SmallPadding) * 2 * b.getScaleSize(localAppBrandDesktopDragView.getContext())));
        locald.ttT.getLayoutParams().width = ((int)f1);
        locald.ttT.getLayoutParams().height = ((int)f1);
        locald.uAt.getLayoutParams().width = ((int)f1);
        locald.uAt.getLayoutParams().height = ((int)f1);
        localObject = locald.uAw.getLayoutParams();
        if ((localObject instanceof RelativeLayout.LayoutParams))
        {
          ((RelativeLayout.LayoutParams)localObject).topMargin = (com.tencent.mm.cd.a.fromDPToPix(localAppBrandDesktopDragView.getContext(), 6) + (int)(f1 * 0.5F / 2.0F));
          ((ViewGroup.LayoutParams)localObject).width = ((int)(localAppBrandDesktopDragView.getContext().getResources().getDimensionPixelSize(ba.d.LargePadding) * b.getScaleSize(localAppBrandDesktopDragView.getContext())));
          ((ViewGroup.LayoutParams)localObject).height = ((int)(localAppBrandDesktopDragView.getContext().getResources().getDimensionPixelSize(ba.d.LargePadding) * b.getScaleSize(localAppBrandDesktopDragView.getContext())));
        }
        arrayOfInt[0] = ((int)(arrayOfInt[0] + f1 / 2.0F));
        arrayOfInt[1] = ((int)(arrayOfInt[1] + f1 / 2.0F));
        f2 = arrayOfInt[0];
        f2 = localAppBrandDesktopDragView.getOffsetX() + f2;
        float f3 = arrayOfInt[1];
        f3 = localAppBrandDesktopDragView.getOffsetY() + f3;
        paramAnonymousv.findViewById(ba.f.app_brand_tips_layout).setVisibility(4);
        paramAnonymousv.findViewById(ba.f.icon_layout).animate().alpha(0.5F).setDuration(300L).setListener(null).start();
        localAppBrandDesktopDragView.jr(false);
        paramAnonymousv.findViewById(ba.f.icon_layout).animate().scaleX(1.5F).scaleY(1.5F).setDuration(300L).setListener(new AppBrandDesktopDragView.3(localAppBrandDesktopDragView)).start();
        localObject = (ImageView)paramAnonymousv.findViewById(ba.f.status_icon);
        ((ImageView)localObject).getLayoutParams().height = ((int)(com.tencent.mm.cd.a.fromDPToPix(localAppBrandDesktopDragView.getContext(), 24) * b.getScaleSize(localAppBrandDesktopDragView.getContext())));
        ((ImageView)localObject).getLayoutParams().width = ((int)(com.tencent.mm.cd.a.fromDPToPix(localAppBrandDesktopDragView.getContext(), 24) * b.getScaleSize(localAppBrandDesktopDragView.getContext())));
        ((ImageView)localObject).setTranslationY(-f1 * 0.5F / 2.0F);
        ((ImageView)localObject).setTranslationX(f1 * 0.5F / 2.0F);
        paramAnonymousv.setTranslationX(f2);
        paramAnonymousv.setTranslationY(f3);
        Log.i("MicroMsg.AppBrandDesktopDragView", "alvinluo fillFloatView offsetX: %f, transX: %f, transY: %f", new Object[] { Float.valueOf(localAppBrandDesktopDragView.getOffsetX()), Float.valueOf(f2), Float.valueOf(f3) });
        AppMethodBeat.o(324226);
        return paramAnonymousv;
      }
      
      public final boolean N(RecyclerView.v paramAnonymousv)
      {
        return (paramAnonymousv.caO == 2) || (paramAnonymousv.caO == 1);
      }
      
      public final void ak(int paramAnonymousInt, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(324232);
        if (AppBrandDesktopDragView.a(AppBrandDesktopDragView.this) != null) {
          AppBrandDesktopDragView.a(AppBrandDesktopDragView.this).d(paramAnonymousInt, false, paramAnonymousBoolean);
        }
        AppMethodBeat.o(324232);
      }
      
      public final boolean cPn()
      {
        return false;
      }
      
      public final int[] cPo()
      {
        AppMethodBeat.i(324274);
        if (AppBrandDesktopDragView.f(AppBrandDesktopDragView.this) == null)
        {
          AppMethodBeat.o(324274);
          return null;
        }
        int[] arrayOfInt = AppBrandDesktopDragView.f(AppBrandDesktopDragView.this).cPr();
        AppMethodBeat.o(324274);
        return arrayOfInt;
      }
      
      public final ImageView cPp()
      {
        AppMethodBeat.i(324282);
        if (AppBrandDesktopDragView.f(AppBrandDesktopDragView.this) == null)
        {
          AppMethodBeat.o(324282);
          return null;
        }
        ImageView localImageView = AppBrandDesktopDragView.f(AppBrandDesktopDragView.this).cPp();
        AppMethodBeat.o(324282);
        return localImageView;
      }
      
      public final int cPq()
      {
        AppMethodBeat.i(324298);
        int i = AppBrandDesktopDragView.f(AppBrandDesktopDragView.this).cPq();
        AppMethodBeat.o(324298);
        return i;
      }
      
      public final void e(View paramAnonymousView, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(324228);
        if (AppBrandDesktopDragView.a(AppBrandDesktopDragView.this) != null)
        {
          paramAnonymousView.getGlobalVisibleRect(AppBrandDesktopDragView.e(AppBrandDesktopDragView.this));
          AppBrandDesktopDragView.a(AppBrandDesktopDragView.this).aw(paramAnonymousFloat1, paramAnonymousFloat2);
        }
        AppMethodBeat.o(324228);
      }
      
      public final boolean e(RecyclerView paramAnonymousRecyclerView, RecyclerView.v paramAnonymousv)
      {
        AppMethodBeat.i(324246);
        if (AppBrandDesktopDragView.f(AppBrandDesktopDragView.this) != null)
        {
          if ((AppBrandDesktopDragView.g(AppBrandDesktopDragView.this)) && ((paramAnonymousv.caO == 2) || (paramAnonymousv.caO == 5) || (AppBrandDesktopDragView.f(AppBrandDesktopDragView.this).j(paramAnonymousRecyclerView))))
          {
            AppMethodBeat.o(324246);
            return true;
          }
          AppMethodBeat.o(324246);
          return false;
        }
        if ((AppBrandDesktopDragView.g(AppBrandDesktopDragView.this)) && ((paramAnonymousv.caO == 2) || (paramAnonymousv.caO == 5)))
        {
          AppMethodBeat.o(324246);
          return true;
        }
        AppMethodBeat.o(324246);
        return false;
      }
      
      public final void eo(Object paramAnonymousObject)
      {
        AppMethodBeat.i(324265);
        if (((paramAnonymousObject instanceof AppBrandDesktopView.a)) && (AppBrandDesktopDragView.a(AppBrandDesktopDragView.this) != null)) {
          AppBrandDesktopDragView.a(AppBrandDesktopDragView.this).ep(paramAnonymousObject);
        }
        AppMethodBeat.o(324265);
      }
      
      public final void f(int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
      {
        AppMethodBeat.i(324237);
        if (((paramAnonymousObject instanceof AppBrandDesktopView.a)) && (((AppBrandDesktopView.a)paramAnonymousObject).type == 2) && (AppBrandDesktopDragView.a(AppBrandDesktopDragView.this) != null)) {
          AppBrandDesktopDragView.a(AppBrandDesktopDragView.this).g(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousObject);
        }
        AppMethodBeat.o(324237);
      }
      
      public final boolean i(RecyclerView paramAnonymousRecyclerView)
      {
        AppMethodBeat.i(324291);
        if (AppBrandDesktopDragView.f(AppBrandDesktopDragView.this) == null)
        {
          Log.i("MicroMsg.AppBrandDesktopDragView", "jacob InAreaFalse");
          AppMethodBeat.o(324291);
          return false;
        }
        if ((AppBrandDesktopDragView.f(AppBrandDesktopDragView.this).cPs()) && (AppBrandDesktopDragView.f(AppBrandDesktopDragView.this).k(paramAnonymousRecyclerView)))
        {
          AppMethodBeat.o(324291);
          return true;
        }
        AppMethodBeat.o(324291);
        return false;
      }
      
      public final void m(Object paramAnonymousObject, int paramAnonymousInt)
      {
        AppMethodBeat.i(324260);
        if (((paramAnonymousObject instanceof AppBrandDesktopView.a)) && (AppBrandDesktopDragView.a(AppBrandDesktopDragView.this) != null))
        {
          if (((AppBrandDesktopView.a)paramAnonymousObject).type == 1)
          {
            AppBrandDesktopDragView.a(AppBrandDesktopDragView.this).o(paramAnonymousObject, paramAnonymousInt);
            AppMethodBeat.o(324260);
            return;
          }
          AppBrandDesktopDragView.a(AppBrandDesktopDragView.this).n(paramAnonymousObject, paramAnonymousInt);
        }
        AppMethodBeat.o(324260);
      }
    };
    AppMethodBeat.o(324302);
    return locald;
  }
  
  float getOffsetX()
  {
    AppMethodBeat.i(49511);
    float f = -this.mViewWidth / 2.0F;
    AppMethodBeat.o(49511);
    return f;
  }
  
  float getOffsetY()
  {
    AppMethodBeat.i(49512);
    float f3 = b.fu(getContext());
    float f4 = com.tencent.mm.cd.a.fromDPToPix(getContext(), 8) * 2;
    float f1 = -0.0F;
    float f2 = com.tencent.mm.cd.a.fromDPToPix(getContext(), 40);
    f3 = (f3 * 1.5F + f4) / 2.0F;
    AppMethodBeat.o(49512);
    return f1 - f2 - f3;
  }
  
  protected final RecyclerView.v i(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(324339);
    getRecyclerView().getGlobalVisibleRect(this.mRect);
    if (!this.mRect.contains((int)paramFloat1, (int)paramFloat2))
    {
      AppMethodBeat.o(324339);
      return null;
    }
    int i = 0;
    Object localObject = null;
    RecyclerView.v localv;
    if (i < getRecyclerView().getChildCount())
    {
      localv = getRecyclerView().bj(getRecyclerView().getChildAt(i));
      if ((localv.caO != 5) && (localv.caO != 3))
      {
        localv.caK.getGlobalVisibleRect(this.mRect);
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
        AppMethodBeat.o(324339);
        return localv;
        i += 1;
        break;
      }
      if ((!paramBoolean) && (((paramFloat1 > this.mRect.right) && (paramFloat2 > this.mRect.top)) || (paramFloat2 > this.mRect.bottom)))
      {
        AppMethodBeat.o(324339);
        return localObject;
      }
      AppMethodBeat.o(324339);
      return null;
      localv = null;
      i = j;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(49507);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    getGlobalVisibleRect(this.uAJ);
    this.uAJ.set(this.uAJ.left, this.uAJ.bottom - this.uAD - (int)(getContext().getResources().getDimensionPixelSize(ba.d.header_up_helper) * 1.0F) - 40, this.uAJ.right, this.uAJ.bottom - this.uAD);
    Log.i("MicroMsg.AppBrandDesktopDragView", "alvinluo bottomRect: %s", new Object[] { this.uAJ });
    getRecyclerView().getGlobalVisibleRect(this.uAK);
    this.uAK.set(this.uAK.left, 0, this.uAK.right, this.uAK.top + this.uAD);
    AppMethodBeat.o(49507);
  }
  
  public void setAppBrandDragCallback(a parama)
  {
    this.uzK = parama;
  }
  
  public void setCanMyWeAppMove(boolean paramBoolean)
  {
    this.uzM = paramBoolean;
  }
  
  public void setList(List paramList)
  {
    this.eXW = paramList;
  }
  
  protected void setRubbishViewVisible(int paramInt)
  {
    AppMethodBeat.i(49506);
    super.setRubbishViewVisible(paramInt);
    AppMethodBeat.o(49506);
  }
  
  public void setSectionCallback(b paramb)
  {
    this.uzL = paramb;
  }
  
  public void setShouldDoDeleteAnimation(boolean paramBoolean)
  {
    this.uzN = paramBoolean;
  }
  
  public void setViewWidth(int paramInt)
  {
    this.mViewWidth = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void aw(float paramFloat1, float paramFloat2);
    
    public abstract void d(int paramInt, boolean paramBoolean1, boolean paramBoolean2);
    
    public abstract void ep(Object paramObject);
    
    public abstract void g(int paramInt1, int paramInt2, Object paramObject);
    
    public abstract void n(Object paramObject, int paramInt);
    
    public abstract void o(Object paramObject, int paramInt);
  }
  
  public static abstract interface b
  {
    public abstract ImageView cPp();
    
    public abstract int cPq();
    
    public abstract int[] cPr();
    
    public abstract boolean cPs();
    
    public abstract boolean j(RecyclerView paramRecyclerView);
    
    public abstract boolean k(RecyclerView paramRecyclerView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView
 * JD-Core Version:    0.7.0.1
 */