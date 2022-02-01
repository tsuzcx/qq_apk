package android.support.design.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.support.transition.AutoTransition;
import android.support.transition.TransitionSet;
import android.support.v4.e.l.a;
import android.support.v4.e.l.c;
import android.support.v4.view.b.b;
import android.support.v4.view.t;
import android.support.v7.c.a.a;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.support.v7.view.menu.p;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import java.util.ArrayList;

public class BottomNavigationMenuView
  extends ViewGroup
  implements p
{
  private static final int[] jT = { 16842912 };
  private static final int[] kf = { -16842910 };
  int jY;
  private int[] kA;
  BottomNavigationPresenter kB;
  h kC;
  final TransitionSet kg;
  private final int kh;
  private final int ki;
  private final int kj;
  private final int kk;
  private final int kl;
  private final View.OnClickListener km;
  private final l.a<BottomNavigationItemView> kn = new l.c(5);
  public boolean ko;
  BottomNavigationItemView[] kp;
  int kq = 0;
  int kr = 0;
  private ColorStateList ks;
  private int kt;
  private ColorStateList ku;
  private final ColorStateList kv;
  private int kw;
  private int kx;
  private Drawable ky;
  private int kz;
  
  public BottomNavigationMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResources();
    this.kh = paramContext.getDimensionPixelSize(2131166099);
    this.ki = paramContext.getDimensionPixelSize(2131166100);
    this.kj = paramContext.getDimensionPixelSize(2131166093);
    this.kk = paramContext.getDimensionPixelSize(2131166094);
    this.kl = paramContext.getDimensionPixelSize(2131166097);
    this.kv = bB();
    this.kg = new AutoTransition();
    this.kg.ao(0);
    this.kg.h(115L);
    this.kg.c(new b());
    this.kg.c(new e());
    this.km = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = ((BottomNavigationItemView)paramAnonymousView).getItemData();
        if (!BottomNavigationMenuView.b(BottomNavigationMenuView.this).a(paramAnonymousView, BottomNavigationMenuView.a(BottomNavigationMenuView.this), 0)) {
          paramAnonymousView.setChecked(true);
        }
      }
    };
    this.kA = new int[5];
  }
  
  private BottomNavigationItemView getNewItem()
  {
    BottomNavigationItemView localBottomNavigationItemView2 = (BottomNavigationItemView)this.kn.acquire();
    BottomNavigationItemView localBottomNavigationItemView1 = localBottomNavigationItemView2;
    if (localBottomNavigationItemView2 == null) {
      localBottomNavigationItemView1 = new BottomNavigationItemView(getContext());
    }
    return localBottomNavigationItemView1;
  }
  
  static boolean m(int paramInt1, int paramInt2)
  {
    if (paramInt1 == -1) {
      if (paramInt2 <= 3) {}
    }
    while (paramInt1 == 0)
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final void a(h paramh)
  {
    this.kC = paramh;
  }
  
  public final ColorStateList bB()
  {
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(16842808, (TypedValue)localObject, true)) {}
    ColorStateList localColorStateList;
    do
    {
      return null;
      localColorStateList = a.m(getContext(), ((TypedValue)localObject).resourceId);
    } while (!getContext().getTheme().resolveAttribute(2130968815, (TypedValue)localObject, true));
    int i = ((TypedValue)localObject).data;
    int j = localColorStateList.getDefaultColor();
    localObject = kf;
    int[] arrayOfInt1 = jT;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int k = localColorStateList.getColorForState(kf, j);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { k, i, j });
  }
  
  public final void bC()
  {
    removeAllViews();
    Object localObject1;
    if (this.kp != null)
    {
      localObject1 = this.kp;
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2 != null) {
          this.kn.release(localObject2);
        }
        i += 1;
      }
    }
    if (this.kC.size() == 0)
    {
      this.kq = 0;
      this.kr = 0;
      this.kp = null;
      return;
    }
    this.kp = new BottomNavigationItemView[this.kC.size()];
    boolean bool = m(this.jY, this.kC.hV().size());
    int i = 0;
    if (i < this.kC.size())
    {
      this.kB.kF = true;
      this.kC.getItem(i).setCheckable(true);
      this.kB.kF = false;
      localObject1 = getNewItem();
      this.kp[i] = localObject1;
      ((BottomNavigationItemView)localObject1).setIconTintList(this.ks);
      ((BottomNavigationItemView)localObject1).setIconSize(this.kt);
      ((BottomNavigationItemView)localObject1).setTextColor(this.kv);
      ((BottomNavigationItemView)localObject1).setTextAppearanceInactive(this.kw);
      ((BottomNavigationItemView)localObject1).setTextAppearanceActive(this.kx);
      ((BottomNavigationItemView)localObject1).setTextColor(this.ku);
      if (this.ky != null) {
        ((BottomNavigationItemView)localObject1).setItemBackground(this.ky);
      }
      for (;;)
      {
        ((BottomNavigationItemView)localObject1).setShifting(bool);
        ((BottomNavigationItemView)localObject1).setLabelVisibilityMode(this.jY);
        ((BottomNavigationItemView)localObject1).a((j)this.kC.getItem(i));
        ((BottomNavigationItemView)localObject1).setItemPosition(i);
        ((BottomNavigationItemView)localObject1).setOnClickListener(this.km);
        addView((View)localObject1);
        i += 1;
        break;
        ((BottomNavigationItemView)localObject1).setItemBackground(this.kz);
      }
    }
    this.kr = Math.min(this.kC.size() - 1, this.kr);
    this.kC.getItem(this.kr).setChecked(true);
  }
  
  public ColorStateList getIconTintList()
  {
    return this.ks;
  }
  
  public Drawable getItemBackground()
  {
    if ((this.kp != null) && (this.kp.length > 0)) {
      return this.kp[0].getBackground();
    }
    return this.ky;
  }
  
  @Deprecated
  public int getItemBackgroundRes()
  {
    return this.kz;
  }
  
  public int getItemIconSize()
  {
    return this.kt;
  }
  
  public int getItemTextAppearanceActive()
  {
    return this.kx;
  }
  
  public int getItemTextAppearanceInactive()
  {
    return this.kw;
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.ku;
  }
  
  public int getLabelVisibilityMode()
  {
    return this.jY;
  }
  
  public int getSelectedItemId()
  {
    return this.kq;
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
        if (t.Y(this) != 1) {
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
    paramInt2 = 1;
    int i = 1;
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int j = this.kC.hV().size();
    int m = getChildCount();
    int n = View.MeasureSpec.makeMeasureSpec(this.kl, 1073741824);
    Object localObject;
    label158:
    int k;
    if ((m(this.jY, j)) && (this.ko))
    {
      localObject = getChildAt(this.kr);
      paramInt2 = this.kk;
      paramInt1 = paramInt2;
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.kj, -2147483648), n);
        paramInt1 = Math.max(paramInt2, ((View)localObject).getMeasuredWidth());
      }
      if (((View)localObject).getVisibility() != 8)
      {
        paramInt2 = 1;
        paramInt2 = j - paramInt2;
        j = Math.min(i1 - this.ki * paramInt2, Math.min(paramInt1, this.kj));
        if (paramInt2 != 0) {
          break label264;
        }
        paramInt1 = i;
        k = Math.min((i1 - j) / paramInt1, this.kh);
        paramInt1 = i1 - j - paramInt2 * k;
        paramInt2 = 0;
        label187:
        if (paramInt2 >= m) {
          break label396;
        }
        if (getChildAt(paramInt2).getVisibility() == 8) {
          break label275;
        }
        localObject = this.kA;
        if (paramInt2 != this.kr) {
          break label269;
        }
        i = j;
        label223:
        localObject[paramInt2] = i;
        if (paramInt1 <= 0) {
          break label282;
        }
        localObject = this.kA;
        localObject[paramInt2] += 1;
        paramInt1 -= 1;
      }
      label264:
      label269:
      label275:
      label282:
      for (;;)
      {
        paramInt2 += 1;
        break label187;
        paramInt2 = 0;
        break;
        paramInt1 = paramInt2;
        break label158;
        i = k;
        break label223;
        this.kA[paramInt2] = 0;
      }
    }
    else
    {
      if (j == 0)
      {
        paramInt1 = paramInt2;
        k = Math.min(i1 / paramInt1, this.kj);
        paramInt2 = i1 - k * j;
        paramInt1 = 0;
        label316:
        if (paramInt1 >= m) {
          break label396;
        }
        if (getChildAt(paramInt1).getVisibility() == 8) {
          break label384;
        }
        this.kA[paramInt1] = k;
        i = paramInt2;
        if (paramInt2 > 0)
        {
          localObject = this.kA;
          localObject[paramInt1] += 1;
        }
      }
      for (i = paramInt2 - 1;; i = paramInt2)
      {
        paramInt1 += 1;
        paramInt2 = i;
        break label316;
        paramInt1 = j;
        break;
        label384:
        this.kA[paramInt1] = 0;
      }
    }
    label396:
    paramInt1 = 0;
    for (paramInt2 = 0; paramInt1 < m; paramInt2 = i)
    {
      localObject = getChildAt(paramInt1);
      i = paramInt2;
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.kA[paramInt1], 1073741824), n);
        ((View)localObject).getLayoutParams().width = ((View)localObject).getMeasuredWidth();
        i = paramInt2 + ((View)localObject).getMeasuredWidth();
      }
      paramInt1 += 1;
    }
    setMeasuredDimension(View.resolveSizeAndState(paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), 0), View.resolveSizeAndState(this.kl, n, 0));
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.ks = paramColorStateList;
    if (this.kp != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.kp;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setIconTintList(paramColorStateList);
        i += 1;
      }
    }
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    this.ky = paramDrawable;
    if (this.kp != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.kp;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setItemBackground(paramDrawable);
        i += 1;
      }
    }
  }
  
  public void setItemBackgroundRes(int paramInt)
  {
    this.kz = paramInt;
    if (this.kp != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.kp;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setItemBackground(paramInt);
        i += 1;
      }
    }
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    this.ko = paramBoolean;
  }
  
  public void setItemIconSize(int paramInt)
  {
    this.kt = paramInt;
    if (this.kp != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.kp;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setIconSize(paramInt);
        i += 1;
      }
    }
  }
  
  public void setItemTextAppearanceActive(int paramInt)
  {
    this.kx = paramInt;
    if (this.kp != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.kp;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i];
        localBottomNavigationItemView.setTextAppearanceActive(paramInt);
        if (this.ku != null) {
          localBottomNavigationItemView.setTextColor(this.ku);
        }
        i += 1;
      }
    }
  }
  
  public void setItemTextAppearanceInactive(int paramInt)
  {
    this.kw = paramInt;
    if (this.kp != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.kp;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i];
        localBottomNavigationItemView.setTextAppearanceInactive(paramInt);
        if (this.ku != null) {
          localBottomNavigationItemView.setTextColor(this.ku);
        }
        i += 1;
      }
    }
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.ku = paramColorStateList;
    if (this.kp != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.kp;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setTextColor(paramColorStateList);
        i += 1;
      }
    }
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    this.jY = paramInt;
  }
  
  public void setPresenter(BottomNavigationPresenter paramBottomNavigationPresenter)
  {
    this.kB = paramBottomNavigationPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.internal.BottomNavigationMenuView
 * JD-Core Version:    0.7.0.1
 */