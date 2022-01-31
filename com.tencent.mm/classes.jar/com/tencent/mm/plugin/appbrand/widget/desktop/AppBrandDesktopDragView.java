package com.tencent.mm.plugin.appbrand.widget.desktop;

import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
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
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.c;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.w;
import java.util.List;

public class AppBrandDesktopDragView
  extends DragFeatureView
{
  private int asY;
  private List iQp;
  private HeaderContainer jbP;
  private List jdJ;
  private int jdK;
  private boolean jdL;
  private boolean jdM;
  private b jdN;
  private int jdO;
  private boolean jdP;
  private boolean jdQ;
  private a jdR;
  private e jdS;
  private ValueAnimator kO;
  private int paddingLeft;
  private int paddingTop;
  
  public AppBrandDesktopDragView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(133758);
    this.jdK = 0;
    this.jdL = false;
    this.jdM = false;
    this.jdN = null;
    this.jdO = 0;
    this.paddingLeft = 0;
    this.paddingTop = 0;
    this.jdP = false;
    this.jdQ = false;
    this.asY = 0;
    init();
    AppMethodBeat.o(133758);
  }
  
  public AppBrandDesktopDragView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(133759);
    this.jdK = 0;
    this.jdL = false;
    this.jdM = false;
    this.jdN = null;
    this.jdO = 0;
    this.paddingLeft = 0;
    this.paddingTop = 0;
    this.jdP = false;
    this.jdQ = false;
    this.asY = 0;
    init();
    AppMethodBeat.o(133759);
  }
  
  private int bw(Object paramObject)
  {
    AppMethodBeat.i(133765);
    int i;
    if (this.jdL) {
      if ((this.jdR != null) && (this.jdR.aPq() - 1 >= b.axA())) {
        i = 1;
      }
    }
    while (i != 0)
    {
      ab.i("MicroMsg.AppBrandDesktopDragView", "alvinluo checkCanInsert current: %d, over limit: %d", new Object[] { Integer.valueOf(this.jdR.aPq()), Integer.valueOf(b.axA()) });
      AppMethodBeat.o(133765);
      return 2;
      i = 0;
      continue;
      if ((this.jdR != null) && (this.jdR.aPq() >= b.axA())) {
        i = 1;
      } else {
        i = 0;
      }
    }
    if ((paramObject instanceof AppBrandDesktopView.c))
    {
      paramObject = (AppBrandDesktopView.c)paramObject;
      if (paramObject.jfk != null)
      {
        if (j.a.nk(paramObject.jfk.hcr))
        {
          if (paramObject.jfk.hcP <= System.currentTimeMillis() / 1000L)
          {
            AppMethodBeat.o(133765);
            return 0;
          }
          AppMethodBeat.o(133765);
          return 1;
        }
        AppMethodBeat.o(133765);
        return 0;
      }
    }
    AppMethodBeat.o(133765);
    return 99;
  }
  
  private float getOffsetX()
  {
    AppMethodBeat.i(133768);
    float f2 = d.dn(getContext());
    float f1 = this.asY / 2;
    f2 /= 2.0F;
    float f3 = this.paddingLeft;
    AppMethodBeat.o(133768);
    return f3 - (f1 - f2);
  }
  
  private float getOffsetY()
  {
    AppMethodBeat.i(133769);
    float f = -(a.fromDPToPix(getContext(), 32) + (d.dq(getContext()) * 1.5F - d.dq(getContext())) / 2.0F);
    AppMethodBeat.o(133769);
    return f;
  }
  
  private void init()
  {
    AppMethodBeat.i(133760);
    this.paddingTop = getResources().getDimensionPixelOffset(2131427772);
    AppMethodBeat.o(133760);
  }
  
  private void m(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(133762);
    if ((paramView.getVisibility() == 0) && (paramBoolean))
    {
      AppMethodBeat.o(133762);
      return;
    }
    if ((paramBoolean) && (this.jdQ))
    {
      AppMethodBeat.o(133762);
      return;
    }
    if ((paramView.getVisibility() != 0) && (!paramBoolean))
    {
      AppMethodBeat.o(133762);
      return;
    }
    if ((!paramBoolean) && (this.jdP))
    {
      AppMethodBeat.o(133762);
      return;
    }
    if (paramBoolean)
    {
      this.jdQ = true;
      paramView.setScaleX(0.1F);
      paramView.setScaleY(0.1F);
      paramView.setVisibility(0);
      paramView.animate().scaleX(1.0F).scaleY(1.0F).setDuration(200L).setListener(new AppBrandDesktopDragView.5(this)).start();
      AppMethodBeat.o(133762);
      return;
    }
    this.jdP = true;
    paramView.setScaleX(1.0F);
    paramView.setScaleY(1.0F);
    paramView.setVisibility(0);
    paramView.animate().scaleX(0.0F).scaleY(0.0F).setDuration(200L).setListener(new AppBrandDesktopDragView.6(this, paramView)).start();
    AppMethodBeat.o(133762);
  }
  
  protected final c N(RecyclerView.v paramv)
  {
    AppMethodBeat.i(133761);
    if ((paramv != null) && (paramv.aky == 2))
    {
      this.jdL = false;
      paramv = new com.tencent.mm.plugin.appbrand.widget.desktop.a.d(this, this.jdJ, this.iQp, new AppBrandDesktopDragView.1(this));
      i = getResources().getDimensionPixelSize(2131427854);
      j = this.paddingLeft;
      paramv.paddingTop = i;
      paramv.paddingLeft = j;
      paramv.jfK = getRecyclerScrollComputer();
      paramv.jix = new AppBrandDesktopDragView.2(this);
      AppMethodBeat.o(133761);
      return paramv;
    }
    this.jdL = true;
    paramv = new com.tencent.mm.plugin.appbrand.widget.desktop.a.e(this, this.iQp, new AppBrandDesktopDragView.3(this));
    paramv.jfK = getRecyclerScrollComputer();
    paramv.jix = new AppBrandDesktopDragView.4(this);
    int i = getResources().getDimensionPixelSize(2131427854);
    int j = this.paddingLeft;
    paramv.paddingTop = i;
    paramv.paddingLeft = j;
    AppMethodBeat.o(133761);
    return paramv;
  }
  
  protected final View a(e parame)
  {
    AppMethodBeat.i(133767);
    View localView1 = w.hM(getContext()).inflate(2130969971, null, false);
    localView1.setLayoutParams(new RecyclerView.LayoutParams(-2, -2));
    this.jdS = new e(localView1);
    e locale = this.jdS;
    View localView2 = parame.aku;
    localView1 = locale.aku;
    localView1.setScaleX(1.0F);
    localView1.setScaleY(1.0F);
    localView1.setAlpha(1.0F);
    localView1.setVisibility(0);
    int[] arrayOfInt = new int[2];
    localView2.getLocationOnScreen(arrayOfInt);
    locale.ivs.setImageDrawable(parame.ivs.getDrawable());
    locale.ivs.setBackground(parame.ivs.getBackground());
    locale.jfu.setText(parame.jfu.getText());
    locale.jfu.setVisibility(parame.jfu.getVisibility());
    locale.jfv.setVisibility(4);
    float f1 = d.dq(getContext());
    float f2 = f1 * 1.5F + a.fromDPToPix(getContext(), 8) * 2;
    ab.i("MicroMsg.AppBrandDesktopDragView", "alvinluo fillFloatView iconLayout: %f", new Object[] { Float.valueOf(f2) });
    localView1.findViewById(2131825399).getLayoutParams().height = ((int)f2);
    locale.jft.getLayoutParams().height = ((int)f2);
    locale.jft.getLayoutParams().width = ((int)f1 + (int)(a.ap(getContext(), 2131427854) * 2 * d.dr(getContext())));
    locale.ivs.getLayoutParams().width = ((int)f1);
    locale.ivs.getLayoutParams().height = ((int)f1);
    locale.jfs.getLayoutParams().width = ((int)f1);
    locale.jfs.getLayoutParams().height = ((int)f1);
    parame = locale.jfv.getLayoutParams();
    if ((parame instanceof RelativeLayout.LayoutParams))
    {
      ((RelativeLayout.LayoutParams)parame).topMargin = (a.fromDPToPix(getContext(), 6) + (int)(f1 * 0.5F / 2.0F));
      parame.width = ((int)(getContext().getResources().getDimensionPixelSize(2131427772) * d.dr(getContext())));
      parame.height = ((int)(getContext().getResources().getDimensionPixelSize(2131427772) * d.dr(getContext())));
    }
    float f3 = (f1 * 1.5F - f1) / 2.0F;
    f2 = arrayOfInt[0] + getOffsetX();
    f3 = arrayOfInt[1] + this.paddingTop - f3 - a.fromDPToPix(getContext(), 48);
    localView1.findViewById(2131825397).setVisibility(4);
    localView1.findViewById(2131821540).animate().alpha(0.5F).setDuration(300L).setListener(null).start();
    ek(false);
    localView1.findViewById(2131821540).animate().scaleX(1.5F).scaleY(1.5F).setDuration(300L).setListener(new AppBrandDesktopDragView.7(this)).start();
    parame = (ImageView)localView1.findViewById(2131823387);
    parame.getLayoutParams().height = ((int)(a.fromDPToPix(getContext(), 24) * d.dr(getContext())));
    parame.getLayoutParams().width = ((int)(a.fromDPToPix(getContext(), 24) * d.dr(getContext())));
    parame.setTranslationY(-f1 * 0.5F / 2.0F);
    parame.setTranslationX(f1 * 0.5F / 2.0F);
    localView1.setTranslationX(f2);
    localView1.setTranslationY(f3);
    ab.i("MicroMsg.AppBrandDesktopDragView", "alvinluo fillFloatView offsetX: %f, transX: %f, transY: %f", new Object[] { Float.valueOf(getOffsetX()), Float.valueOf(f2), Float.valueOf(f3) });
    AppMethodBeat.o(133767);
    return localView1;
  }
  
  protected final RecyclerView.v e(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    AppMethodBeat.i(133766);
    getRecyclerView().getGlobalVisibleRect(this.mRect);
    if (!this.mRect.contains((int)paramFloat1, (int)paramFloat2))
    {
      AppMethodBeat.o(133766);
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
      localv = getRecyclerView().bb(getRecyclerView().getChildAt(k));
      localObject2 = localObject1;
      j = i;
      if (localv.aky != 7)
      {
        localObject2 = localObject1;
        j = i;
        if (localv.aky != 3)
        {
          localObject2 = localObject1;
          j = i;
          if (localv.aky != 8)
          {
            localv.aku.getGlobalVisibleRect(this.mRect);
            localObject2 = localObject1;
            j = i;
            if (this.mRect.contains((int)paramFloat1, (int)paramFloat2)) {
              if (2 == localv.aky)
              {
                RecyclerView localRecyclerView = (RecyclerView)localv.aku.findViewById(2131821195);
                j = 0;
                label195:
                if (j < localRecyclerView.getAdapter().getItemCount())
                {
                  localObject2 = localRecyclerView.bQ(j);
                  if ((localObject2 == null) || (((RecyclerView.v)localObject2).aku == null)) {
                    break label435;
                  }
                  ((RecyclerView.v)localObject2).aku.getGlobalVisibleRect(this.mRect);
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
          AppMethodBeat.o(133766);
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
        AppMethodBeat.o(133766);
        return localObject1;
      }
      if (!paramBoolean)
      {
        i = getRecyclerView().getChildCount() - 1;
        while (i >= 0)
        {
          localObject1 = getRecyclerView().bb(getRecyclerView().getChildAt(i));
          if (this.jdL)
          {
            if (((RecyclerView.v)localObject1).aky == 1)
            {
              AppMethodBeat.o(133766);
              return localObject1;
            }
          }
          else if (((RecyclerView.v)localObject1).aky == 7)
          {
            AppMethodBeat.o(133766);
            return localObject1;
          }
          i -= 1;
        }
      }
      AppMethodBeat.o(133766);
      return null;
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(133764);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    getGlobalVisibleRect(this.jfD);
    this.jfD.set(this.jfD.left, this.jfD.bottom - this.jfx - (int)(getContext().getResources().getDimensionPixelSize(2131428454) * 1.0F) - 40, this.jfD.right, this.jfD.bottom - this.jfx);
    ab.i("MicroMsg.AppBrandDesktopDragView", "alvinluo bottomRect: %s", new Object[] { this.jfD });
    getRecyclerView().getGlobalVisibleRect(this.jfE);
    this.jfE.set(this.jfE.left, 0, this.jfE.right, this.jfE.top + this.jfx);
    AppMethodBeat.o(133764);
  }
  
  public void setAppBrandCounter(a parama)
  {
    this.jdR = parama;
  }
  
  public void setCollectionCallback(b paramb)
  {
    this.jdN = paramb;
  }
  
  public void setCollectionStartPosition(int paramInt)
  {
    this.jdK = paramInt;
  }
  
  public void setCopyList(List paramList)
  {
    this.jdJ = paramList;
  }
  
  public void setHeaderContainer(HeaderContainer paramHeaderContainer)
  {
    this.jbP = paramHeaderContainer;
  }
  
  public void setItemPadding(int paramInt)
  {
    this.paddingLeft = paramInt;
  }
  
  public void setList(List paramList)
  {
    this.iQp = paramList;
  }
  
  protected void setRubbishViewVisible(int paramInt)
  {
    AppMethodBeat.i(133763);
    super.setRubbishViewVisible(paramInt);
    boolean bool;
    float f;
    if (paramInt == 0)
    {
      bool = true;
      f = getResources().getDimension(2131428643) * 1.0F;
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
        ab.v("MicroMsg.AppBrandDesktopDragView", "alvinluo transBackFooterAnim isShow: %b, offset: %f, extraBottomHeight: %d", new Object[] { Boolean.valueOf(bool), Float.valueOf(f), Integer.valueOf(paramInt) });
        this.kO = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("transY", new float[] { 0.0F, f }) });
        int i = this.jbP.getBackUpFooterRect().top;
        this.kO.addUpdateListener(new AppBrandDesktopDragView.8(this, i, paramInt));
        this.kO.setDuration(300L);
        this.kO.start();
        AppMethodBeat.o(133763);
        return;
        bool = false;
        break;
      }
    }
  }
  
  public void setViewWidth(int paramInt)
  {
    this.asY = paramInt;
  }
  
  public static abstract interface a
  {
    public abstract int aPq();
  }
  
  public static abstract interface b
  {
    public abstract void bx(Object paramObject);
    
    public abstract void by(Object paramObject);
    
    public abstract void bz(Object paramObject);
    
    public abstract void g(int paramInt1, int paramInt2, Object paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopDragView
 * JD-Core Version:    0.7.0.1
 */