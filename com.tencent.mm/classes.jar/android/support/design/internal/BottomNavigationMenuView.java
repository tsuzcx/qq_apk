package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.design.a.d;
import android.support.transition.AutoTransition;
import android.support.transition.TransitionSet;
import android.support.v4.f.k.a;
import android.support.v4.f.k.c;
import android.support.v4.view.b.b;
import android.support.v4.view.q;
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
  private boolean cQ = true;
  final TransitionSet cX;
  private final int cY;
  private final int cZ;
  private final int da;
  private final int db;
  private final k.a<BottomNavigationItemView> dc = new k.c(5);
  BottomNavigationItemView[] dd;
  int de = 0;
  int dg = 0;
  private ColorStateList dh;
  private ColorStateList di;
  private int dj;
  private int[] dk;
  BottomNavigationPresenter dl;
  h dm;
  private final View.OnClickListener mOnClickListener;
  
  public BottomNavigationMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResources();
    this.cY = paramContext.getDimensionPixelSize(a.d.design_bottom_navigation_item_max_width);
    this.cZ = paramContext.getDimensionPixelSize(a.d.design_bottom_navigation_item_min_width);
    this.da = paramContext.getDimensionPixelSize(a.d.design_bottom_navigation_active_item_max_width);
    this.db = paramContext.getDimensionPixelSize(a.d.design_bottom_navigation_height);
    this.cX = new AutoTransition();
    this.cX.V(0);
    this.cX.i(115L);
    this.cX.b(new b());
    this.cX.d(new e());
    this.mOnClickListener = new BottomNavigationMenuView.1(this);
    this.dk = new int[5];
  }
  
  private BottomNavigationItemView getNewItem()
  {
    BottomNavigationItemView localBottomNavigationItemView2 = (BottomNavigationItemView)this.dc.de();
    BottomNavigationItemView localBottomNavigationItemView1 = localBottomNavigationItemView2;
    if (localBottomNavigationItemView2 == null) {
      localBottomNavigationItemView1 = new BottomNavigationItemView(getContext());
    }
    return localBottomNavigationItemView1;
  }
  
  public final void U()
  {
    removeAllViews();
    Object localObject1;
    int i;
    if (this.dd != null)
    {
      localObject1 = this.dd;
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        this.dc.D(localObject2);
        i += 1;
      }
    }
    if (this.dm.size() == 0)
    {
      this.de = 0;
      this.dg = 0;
      this.dd = null;
      return;
    }
    this.dd = new BottomNavigationItemView[this.dm.size()];
    if (this.dm.size() > 3) {}
    for (boolean bool = true;; bool = false)
    {
      this.cQ = bool;
      i = 0;
      while (i < this.dm.size())
      {
        this.dl.dp = true;
        this.dm.getItem(i).setCheckable(true);
        this.dl.dp = false;
        localObject1 = getNewItem();
        this.dd[i] = localObject1;
        ((BottomNavigationItemView)localObject1).setIconTintList(this.dh);
        ((BottomNavigationItemView)localObject1).setTextColor(this.di);
        ((BottomNavigationItemView)localObject1).setItemBackground(this.dj);
        ((BottomNavigationItemView)localObject1).setShiftingMode(this.cQ);
        ((BottomNavigationItemView)localObject1).a((j)this.dm.getItem(i));
        ((BottomNavigationItemView)localObject1).setItemPosition(i);
        ((BottomNavigationItemView)localObject1).setOnClickListener(this.mOnClickListener);
        addView((View)localObject1);
        i += 1;
      }
    }
    this.dg = Math.min(this.dm.size() - 1, this.dg);
    this.dm.getItem(this.dg).setChecked(true);
  }
  
  public final void a(h paramh)
  {
    this.dm = paramh;
  }
  
  public ColorStateList getIconTintList()
  {
    return this.dh;
  }
  
  public int getItemBackgroundRes()
  {
    return this.dj;
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.di;
  }
  
  public int getSelectedItemId()
  {
    return this.de;
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
        if (q.Q(this) != 1) {
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
    int n = View.MeasureSpec.makeMeasureSpec(this.db, 1073741824);
    int k;
    int m;
    Object localObject;
    int i;
    if (this.cQ)
    {
      paramInt1 = j - 1;
      k = Math.min(paramInt2 - this.cZ * paramInt1, this.da);
      m = Math.min((paramInt2 - k) / paramInt1, this.cY);
      paramInt1 = paramInt2 - k - paramInt1 * m;
      paramInt2 = 0;
      if (paramInt2 >= j) {
        break label228;
      }
      localObject = this.dk;
      if (paramInt2 == this.dg)
      {
        i = k;
        label102:
        localObject[paramInt2] = i;
        if (paramInt1 <= 0) {
          break label333;
        }
        localObject = this.dk;
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
        k = Math.min(paramInt2 / paramInt1, this.da);
        paramInt2 -= k * j;
        paramInt1 = 0;
        while (paramInt1 < j)
        {
          this.dk[paramInt1] = k;
          i = paramInt2;
          if (paramInt2 > 0)
          {
            localObject = this.dk;
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
          ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.dk[paramInt1], 1073741824), n);
          ((View)localObject).getLayoutParams().width = ((View)localObject).getMeasuredWidth();
          i = paramInt2 + ((View)localObject).getMeasuredWidth();
        }
        paramInt1 += 1;
      }
      setMeasuredDimension(View.resolveSizeAndState(paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), 0), View.resolveSizeAndState(this.db, n, 0));
      return;
    }
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.dh = paramColorStateList;
    if (this.dd == null) {}
    for (;;)
    {
      return;
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.dd;
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
    this.dj = paramInt;
    if (this.dd == null) {}
    for (;;)
    {
      return;
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.dd;
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
    this.di = paramColorStateList;
    if (this.dd == null) {}
    for (;;)
    {
      return;
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.dd;
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
    this.dl = paramBottomNavigationPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.internal.BottomNavigationMenuView
 * JD-Core Version:    0.7.0.1
 */