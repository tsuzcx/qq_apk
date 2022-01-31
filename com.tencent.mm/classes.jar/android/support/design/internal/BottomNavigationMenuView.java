package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.transition.AutoTransition;
import android.support.transition.TransitionSet;
import android.support.v4.e.k.a;
import android.support.v4.e.k.c;
import android.support.v4.view.b.b;
import android.support.v4.view.t;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.p;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public class BottomNavigationMenuView
  extends ViewGroup
  implements p
{
  private boolean dU = true;
  final TransitionSet eb;
  private final int ec;
  private final int ed;
  private final int ee;
  private final int ef;
  private final k.a<BottomNavigationItemView> eg = new k.c(5);
  BottomNavigationItemView[] eh;
  int ei = 0;
  int ej = 0;
  private ColorStateList ek;
  private ColorStateList el;
  private int em;
  private int[] eo;
  BottomNavigationPresenter ep;
  h eq;
  private final View.OnClickListener mOnClickListener;
  
  public BottomNavigationMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResources();
    this.ec = paramContext.getDimensionPixelSize(2131428282);
    this.ed = paramContext.getDimensionPixelSize(2131428283);
    this.ee = paramContext.getDimensionPixelSize(2131428278);
    this.ef = paramContext.getDimensionPixelSize(2131428281);
    this.eb = new AutoTransition();
    this.eb.U(0);
    this.eb.f(115L);
    this.eb.b(new b());
    this.eb.d(new e());
    this.mOnClickListener = new BottomNavigationMenuView.1(this);
    this.eo = new int[5];
  }
  
  private BottomNavigationItemView getNewItem()
  {
    BottomNavigationItemView localBottomNavigationItemView2 = (BottomNavigationItemView)this.eg.acquire();
    BottomNavigationItemView localBottomNavigationItemView1 = localBottomNavigationItemView2;
    if (localBottomNavigationItemView2 == null) {
      localBottomNavigationItemView1 = new BottomNavigationItemView(getContext());
    }
    return localBottomNavigationItemView1;
  }
  
  public final void a(h paramh)
  {
    this.eq = paramh;
  }
  
  public final void aF()
  {
    removeAllViews();
    Object localObject1;
    int i;
    if (this.eh != null)
    {
      localObject1 = this.eh;
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        this.eg.release(localObject2);
        i += 1;
      }
    }
    if (this.eq.size() == 0)
    {
      this.ei = 0;
      this.ej = 0;
      this.eh = null;
      return;
    }
    this.eh = new BottomNavigationItemView[this.eq.size()];
    if (this.eq.size() > 3) {}
    for (boolean bool = true;; bool = false)
    {
      this.dU = bool;
      i = 0;
      while (i < this.eq.size())
      {
        this.ep.et = true;
        this.eq.getItem(i).setCheckable(true);
        this.ep.et = false;
        localObject1 = getNewItem();
        this.eh[i] = localObject1;
        ((BottomNavigationItemView)localObject1).setIconTintList(this.ek);
        ((BottomNavigationItemView)localObject1).setTextColor(this.el);
        ((BottomNavigationItemView)localObject1).setItemBackground(this.em);
        ((BottomNavigationItemView)localObject1).setShiftingMode(this.dU);
        ((BottomNavigationItemView)localObject1).a((j)this.eq.getItem(i));
        ((BottomNavigationItemView)localObject1).setItemPosition(i);
        ((BottomNavigationItemView)localObject1).setOnClickListener(this.mOnClickListener);
        addView((View)localObject1);
        i += 1;
      }
    }
    this.ej = Math.min(this.eq.size() - 1, this.ej);
    this.eq.getItem(this.ej).setChecked(true);
  }
  
  public ColorStateList getIconTintList()
  {
    return this.ek;
  }
  
  public int getItemBackgroundRes()
  {
    return this.em;
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.el;
  }
  
  public int getSelectedItemId()
  {
    return this.ei;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = getChildCount();
    int j = paramInt3 - paramInt1;
    paramInt4 -= paramInt2;
    paramInt1 = 0;
    paramInt2 = 0;
    if (paramInt1 < i)
    {
      View localView = getChildAt(paramInt1);
      paramInt3 = paramInt2;
      if (localView.getVisibility() != 8)
      {
        if (t.T(this) != 1) {
          break label97;
        }
        localView.layout(j - paramInt2 - localView.getMeasuredWidth(), 0, j - paramInt2, paramInt4);
      }
      for (;;)
      {
        paramInt3 = paramInt2 + localView.getMeasuredWidth();
        paramInt1 += 1;
        paramInt2 = paramInt3;
        break;
        label97:
        localView.layout(paramInt2, 0, localView.getMeasuredWidth() + paramInt2, paramInt4);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = View.MeasureSpec.getSize(paramInt1);
    int j = getChildCount();
    int n = View.MeasureSpec.makeMeasureSpec(this.ef, 1073741824);
    int k;
    int m;
    Object localObject;
    int i;
    if (this.dU)
    {
      paramInt1 = j - 1;
      k = Math.min(paramInt2 - this.ed * paramInt1, this.ee);
      m = Math.min((paramInt2 - k) / paramInt1, this.ec);
      paramInt1 = paramInt2 - k - paramInt1 * m;
      paramInt2 = 0;
      if (paramInt2 >= j) {
        break label228;
      }
      localObject = this.eo;
      if (paramInt2 == this.ej)
      {
        i = k;
        label102:
        localObject[paramInt2] = i;
        if (paramInt1 <= 0) {
          break label333;
        }
        localObject = this.eo;
        localObject[paramInt2] += 1;
        paramInt1 -= 1;
      }
    }
    label333:
    for (;;)
    {
      paramInt2 += 1;
      break;
      i = m;
      break label102;
      if (j == 0) {}
      for (paramInt1 = 1;; paramInt1 = j)
      {
        k = Math.min(paramInt2 / paramInt1, this.ee);
        paramInt2 -= k * j;
        paramInt1 = 0;
        while (paramInt1 < j)
        {
          this.eo[paramInt1] = k;
          i = paramInt2;
          if (paramInt2 > 0)
          {
            localObject = this.eo;
            localObject[paramInt1] += 1;
            i = paramInt2 - 1;
          }
          paramInt1 += 1;
          paramInt2 = i;
        }
      }
      label228:
      paramInt1 = 0;
      for (paramInt2 = 0; paramInt1 < j; paramInt2 = i)
      {
        localObject = getChildAt(paramInt1);
        i = paramInt2;
        if (((View)localObject).getVisibility() != 8)
        {
          ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.eo[paramInt1], 1073741824), n);
          ((View)localObject).getLayoutParams().width = ((View)localObject).getMeasuredWidth();
          i = paramInt2 + ((View)localObject).getMeasuredWidth();
        }
        paramInt1 += 1;
      }
      setMeasuredDimension(View.resolveSizeAndState(paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), 0), View.resolveSizeAndState(this.ef, n, 0));
      return;
    }
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.ek = paramColorStateList;
    if (this.eh == null) {}
    for (;;)
    {
      return;
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.eh;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setIconTintList(paramColorStateList);
        i += 1;
      }
    }
  }
  
  public void setItemBackgroundRes(int paramInt)
  {
    this.em = paramInt;
    if (this.eh == null) {}
    for (;;)
    {
      return;
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.eh;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setItemBackground(paramInt);
        i += 1;
      }
    }
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.el = paramColorStateList;
    if (this.eh == null) {}
    for (;;)
    {
      return;
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.eh;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setTextColor(paramColorStateList);
        i += 1;
      }
    }
  }
  
  public void setPresenter(BottomNavigationPresenter paramBottomNavigationPresenter)
  {
    this.ep = paramBottomNavigationPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.internal.BottomNavigationMenuView
 * JD-Core Version:    0.7.0.1
 */