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
import android.support.v4.view.u;
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
  private static final int[] jV = { 16842912 };
  private static final int[] kh = { -16842910 };
  private Drawable kA;
  private int kB;
  private int[] kC;
  BottomNavigationPresenter kD;
  h kE;
  int ka;
  final TransitionSet ki;
  private final int kj;
  private final int kk;
  private final int kl;
  private final int km;
  private final int kn;
  private final View.OnClickListener ko;
  private final l.a<BottomNavigationItemView> kp = new l.c(5);
  public boolean kq;
  BottomNavigationItemView[] kr;
  int ks = 0;
  int kt = 0;
  private ColorStateList ku;
  private int kv;
  private ColorStateList kw;
  private final ColorStateList kx;
  private int ky;
  private int kz;
  
  public BottomNavigationMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResources();
    this.kj = paramContext.getDimensionPixelSize(2131166140);
    this.kk = paramContext.getDimensionPixelSize(2131166141);
    this.kl = paramContext.getDimensionPixelSize(2131166134);
    this.km = paramContext.getDimensionPixelSize(2131166135);
    this.kn = paramContext.getDimensionPixelSize(2131166138);
    this.kx = bD();
    this.ki = new AutoTransition();
    this.ki.ao(0);
    this.ki.h(115L);
    this.ki.c(new b());
    this.ki.c(new e());
    this.ko = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = ((BottomNavigationItemView)paramAnonymousView).getItemData();
        if (!BottomNavigationMenuView.b(BottomNavigationMenuView.this).a(paramAnonymousView, BottomNavigationMenuView.a(BottomNavigationMenuView.this), 0)) {
          paramAnonymousView.setChecked(true);
        }
      }
    };
    this.kC = new int[5];
  }
  
  private BottomNavigationItemView getNewItem()
  {
    BottomNavigationItemView localBottomNavigationItemView2 = (BottomNavigationItemView)this.kp.acquire();
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
    this.kE = paramh;
  }
  
  public final ColorStateList bD()
  {
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(16842808, (TypedValue)localObject, true)) {}
    ColorStateList localColorStateList;
    do
    {
      return null;
      localColorStateList = a.m(getContext(), ((TypedValue)localObject).resourceId);
    } while (!getContext().getTheme().resolveAttribute(2130968830, (TypedValue)localObject, true));
    int i = ((TypedValue)localObject).data;
    int j = localColorStateList.getDefaultColor();
    localObject = kh;
    int[] arrayOfInt1 = jV;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int k = localColorStateList.getColorForState(kh, j);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { k, i, j });
  }
  
  public final void bE()
  {
    removeAllViews();
    Object localObject1;
    if (this.kr != null)
    {
      localObject1 = this.kr;
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2 != null) {
          this.kp.release(localObject2);
        }
        i += 1;
      }
    }
    if (this.kE.size() == 0)
    {
      this.ks = 0;
      this.kt = 0;
      this.kr = null;
      return;
    }
    this.kr = new BottomNavigationItemView[this.kE.size()];
    boolean bool = m(this.ka, this.kE.jdMethod_if().size());
    int i = 0;
    if (i < this.kE.size())
    {
      this.kD.kH = true;
      this.kE.getItem(i).setCheckable(true);
      this.kD.kH = false;
      localObject1 = getNewItem();
      this.kr[i] = localObject1;
      ((BottomNavigationItemView)localObject1).setIconTintList(this.ku);
      ((BottomNavigationItemView)localObject1).setIconSize(this.kv);
      ((BottomNavigationItemView)localObject1).setTextColor(this.kx);
      ((BottomNavigationItemView)localObject1).setTextAppearanceInactive(this.ky);
      ((BottomNavigationItemView)localObject1).setTextAppearanceActive(this.kz);
      ((BottomNavigationItemView)localObject1).setTextColor(this.kw);
      if (this.kA != null) {
        ((BottomNavigationItemView)localObject1).setItemBackground(this.kA);
      }
      for (;;)
      {
        ((BottomNavigationItemView)localObject1).setShifting(bool);
        ((BottomNavigationItemView)localObject1).setLabelVisibilityMode(this.ka);
        ((BottomNavigationItemView)localObject1).a((j)this.kE.getItem(i));
        ((BottomNavigationItemView)localObject1).setItemPosition(i);
        ((BottomNavigationItemView)localObject1).setOnClickListener(this.ko);
        addView((View)localObject1);
        i += 1;
        break;
        ((BottomNavigationItemView)localObject1).setItemBackground(this.kB);
      }
    }
    this.kt = Math.min(this.kE.size() - 1, this.kt);
    this.kE.getItem(this.kt).setChecked(true);
  }
  
  public ColorStateList getIconTintList()
  {
    return this.ku;
  }
  
  public Drawable getItemBackground()
  {
    if ((this.kr != null) && (this.kr.length > 0)) {
      return this.kr[0].getBackground();
    }
    return this.kA;
  }
  
  @Deprecated
  public int getItemBackgroundRes()
  {
    return this.kB;
  }
  
  public int getItemIconSize()
  {
    return this.kv;
  }
  
  public int getItemTextAppearanceActive()
  {
    return this.kz;
  }
  
  public int getItemTextAppearanceInactive()
  {
    return this.ky;
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.kw;
  }
  
  public int getLabelVisibilityMode()
  {
    return this.ka;
  }
  
  public int getSelectedItemId()
  {
    return this.ks;
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
        if (u.Z(this) != 1) {
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
    int j = this.kE.jdMethod_if().size();
    int m = getChildCount();
    int n = View.MeasureSpec.makeMeasureSpec(this.kn, 1073741824);
    Object localObject;
    label158:
    int k;
    if ((m(this.ka, j)) && (this.kq))
    {
      localObject = getChildAt(this.kt);
      paramInt2 = this.km;
      paramInt1 = paramInt2;
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.kl, -2147483648), n);
        paramInt1 = Math.max(paramInt2, ((View)localObject).getMeasuredWidth());
      }
      if (((View)localObject).getVisibility() != 8)
      {
        paramInt2 = 1;
        paramInt2 = j - paramInt2;
        j = Math.min(i1 - this.kk * paramInt2, Math.min(paramInt1, this.kl));
        if (paramInt2 != 0) {
          break label264;
        }
        paramInt1 = i;
        k = Math.min((i1 - j) / paramInt1, this.kj);
        paramInt1 = i1 - j - paramInt2 * k;
        paramInt2 = 0;
        label187:
        if (paramInt2 >= m) {
          break label396;
        }
        if (getChildAt(paramInt2).getVisibility() == 8) {
          break label275;
        }
        localObject = this.kC;
        if (paramInt2 != this.kt) {
          break label269;
        }
        i = j;
        label223:
        localObject[paramInt2] = i;
        if (paramInt1 <= 0) {
          break label282;
        }
        localObject = this.kC;
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
        this.kC[paramInt2] = 0;
      }
    }
    else
    {
      if (j == 0)
      {
        paramInt1 = paramInt2;
        k = Math.min(i1 / paramInt1, this.kl);
        paramInt2 = i1 - k * j;
        paramInt1 = 0;
        label316:
        if (paramInt1 >= m) {
          break label396;
        }
        if (getChildAt(paramInt1).getVisibility() == 8) {
          break label384;
        }
        this.kC[paramInt1] = k;
        i = paramInt2;
        if (paramInt2 > 0)
        {
          localObject = this.kC;
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
        this.kC[paramInt1] = 0;
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
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.kC[paramInt1], 1073741824), n);
        ((View)localObject).getLayoutParams().width = ((View)localObject).getMeasuredWidth();
        i = paramInt2 + ((View)localObject).getMeasuredWidth();
      }
      paramInt1 += 1;
    }
    setMeasuredDimension(View.resolveSizeAndState(paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), 0), View.resolveSizeAndState(this.kn, n, 0));
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.ku = paramColorStateList;
    if (this.kr != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.kr;
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
    this.kA = paramDrawable;
    if (this.kr != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.kr;
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
    this.kB = paramInt;
    if (this.kr != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.kr;
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
    this.kq = paramBoolean;
  }
  
  public void setItemIconSize(int paramInt)
  {
    this.kv = paramInt;
    if (this.kr != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.kr;
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
    this.kz = paramInt;
    if (this.kr != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.kr;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i];
        localBottomNavigationItemView.setTextAppearanceActive(paramInt);
        if (this.kw != null) {
          localBottomNavigationItemView.setTextColor(this.kw);
        }
        i += 1;
      }
    }
  }
  
  public void setItemTextAppearanceInactive(int paramInt)
  {
    this.ky = paramInt;
    if (this.kr != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.kr;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i];
        localBottomNavigationItemView.setTextAppearanceInactive(paramInt);
        if (this.kw != null) {
          localBottomNavigationItemView.setTextColor(this.kw);
        }
        i += 1;
      }
    }
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.kw = paramColorStateList;
    if (this.kr != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.kr;
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
    this.ka = paramInt;
  }
  
  public void setPresenter(BottomNavigationPresenter paramBottomNavigationPresenter)
  {
    this.kD = paramBottomNavigationPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.internal.BottomNavigationMenuView
 * JD-Core Version:    0.7.0.1
 */