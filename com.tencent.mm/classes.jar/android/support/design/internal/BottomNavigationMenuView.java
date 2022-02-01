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
  private static final int[] gZ = { 16842912 };
  private static final int[] hl = { -16842910 };
  private ColorStateList hA;
  private final ColorStateList hB;
  private int hC;
  private int hD;
  private Drawable hE;
  private int hF;
  private int[] hG;
  BottomNavigationPresenter hH;
  h hI;
  int he;
  final TransitionSet hm;
  private final int hn;
  private final int ho;
  private final int hp;
  private final int hq;
  private final int hr;
  private final View.OnClickListener hs;
  private final l.a<BottomNavigationItemView> ht = new l.c(5);
  public boolean hu;
  BottomNavigationItemView[] hv;
  int hw = 0;
  int hx = 0;
  private ColorStateList hy;
  private int hz;
  
  public BottomNavigationMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResources();
    this.hn = paramContext.getDimensionPixelSize(2131166099);
    this.ho = paramContext.getDimensionPixelSize(2131166100);
    this.hp = paramContext.getDimensionPixelSize(2131166093);
    this.hq = paramContext.getDimensionPixelSize(2131166094);
    this.hr = paramContext.getDimensionPixelSize(2131166097);
    this.hB = bf();
    this.hm = new AutoTransition();
    this.hm.ao(0);
    this.hm.f(115L);
    this.hm.c(new b());
    this.hm.c(new e());
    this.hs = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = ((BottomNavigationItemView)paramAnonymousView).getItemData();
        if (!BottomNavigationMenuView.b(BottomNavigationMenuView.this).a(paramAnonymousView, BottomNavigationMenuView.a(BottomNavigationMenuView.this), 0)) {
          paramAnonymousView.setChecked(true);
        }
      }
    };
    this.hG = new int[5];
  }
  
  static boolean f(int paramInt1, int paramInt2)
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
  
  private BottomNavigationItemView getNewItem()
  {
    BottomNavigationItemView localBottomNavigationItemView2 = (BottomNavigationItemView)this.ht.acquire();
    BottomNavigationItemView localBottomNavigationItemView1 = localBottomNavigationItemView2;
    if (localBottomNavigationItemView2 == null) {
      localBottomNavigationItemView1 = new BottomNavigationItemView(getContext());
    }
    return localBottomNavigationItemView1;
  }
  
  public final void a(h paramh)
  {
    this.hI = paramh;
  }
  
  public final ColorStateList bf()
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
    localObject = hl;
    int[] arrayOfInt1 = gZ;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int k = localColorStateList.getColorForState(hl, j);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { k, i, j });
  }
  
  public final void bg()
  {
    removeAllViews();
    Object localObject1;
    if (this.hv != null)
    {
      localObject1 = this.hv;
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2 != null) {
          this.ht.release(localObject2);
        }
        i += 1;
      }
    }
    if (this.hI.size() == 0)
    {
      this.hw = 0;
      this.hx = 0;
      this.hv = null;
      return;
    }
    this.hv = new BottomNavigationItemView[this.hI.size()];
    boolean bool = f(this.he, this.hI.hx().size());
    int i = 0;
    if (i < this.hI.size())
    {
      this.hH.hL = true;
      this.hI.getItem(i).setCheckable(true);
      this.hH.hL = false;
      localObject1 = getNewItem();
      this.hv[i] = localObject1;
      ((BottomNavigationItemView)localObject1).setIconTintList(this.hy);
      ((BottomNavigationItemView)localObject1).setIconSize(this.hz);
      ((BottomNavigationItemView)localObject1).setTextColor(this.hB);
      ((BottomNavigationItemView)localObject1).setTextAppearanceInactive(this.hC);
      ((BottomNavigationItemView)localObject1).setTextAppearanceActive(this.hD);
      ((BottomNavigationItemView)localObject1).setTextColor(this.hA);
      if (this.hE != null) {
        ((BottomNavigationItemView)localObject1).setItemBackground(this.hE);
      }
      for (;;)
      {
        ((BottomNavigationItemView)localObject1).setShifting(bool);
        ((BottomNavigationItemView)localObject1).setLabelVisibilityMode(this.he);
        ((BottomNavigationItemView)localObject1).a((j)this.hI.getItem(i));
        ((BottomNavigationItemView)localObject1).setItemPosition(i);
        ((BottomNavigationItemView)localObject1).setOnClickListener(this.hs);
        addView((View)localObject1);
        i += 1;
        break;
        ((BottomNavigationItemView)localObject1).setItemBackground(this.hF);
      }
    }
    this.hx = Math.min(this.hI.size() - 1, this.hx);
    this.hI.getItem(this.hx).setChecked(true);
  }
  
  public ColorStateList getIconTintList()
  {
    return this.hy;
  }
  
  public Drawable getItemBackground()
  {
    if ((this.hv != null) && (this.hv.length > 0)) {
      return this.hv[0].getBackground();
    }
    return this.hE;
  }
  
  @Deprecated
  public int getItemBackgroundRes()
  {
    return this.hF;
  }
  
  public int getItemIconSize()
  {
    return this.hz;
  }
  
  public int getItemTextAppearanceActive()
  {
    return this.hD;
  }
  
  public int getItemTextAppearanceInactive()
  {
    return this.hC;
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.hA;
  }
  
  public int getLabelVisibilityMode()
  {
    return this.he;
  }
  
  public int getSelectedItemId()
  {
    return this.hw;
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
    int j = this.hI.hx().size();
    int m = getChildCount();
    int n = View.MeasureSpec.makeMeasureSpec(this.hr, 1073741824);
    Object localObject;
    label158:
    int k;
    if ((f(this.he, j)) && (this.hu))
    {
      localObject = getChildAt(this.hx);
      paramInt2 = this.hq;
      paramInt1 = paramInt2;
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.hp, -2147483648), n);
        paramInt1 = Math.max(paramInt2, ((View)localObject).getMeasuredWidth());
      }
      if (((View)localObject).getVisibility() != 8)
      {
        paramInt2 = 1;
        paramInt2 = j - paramInt2;
        j = Math.min(i1 - this.ho * paramInt2, Math.min(paramInt1, this.hp));
        if (paramInt2 != 0) {
          break label264;
        }
        paramInt1 = i;
        k = Math.min((i1 - j) / paramInt1, this.hn);
        paramInt1 = i1 - j - paramInt2 * k;
        paramInt2 = 0;
        label187:
        if (paramInt2 >= m) {
          break label396;
        }
        if (getChildAt(paramInt2).getVisibility() == 8) {
          break label275;
        }
        localObject = this.hG;
        if (paramInt2 != this.hx) {
          break label269;
        }
        i = j;
        label223:
        localObject[paramInt2] = i;
        if (paramInt1 <= 0) {
          break label282;
        }
        localObject = this.hG;
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
        this.hG[paramInt2] = 0;
      }
    }
    else
    {
      if (j == 0)
      {
        paramInt1 = paramInt2;
        k = Math.min(i1 / paramInt1, this.hp);
        paramInt2 = i1 - k * j;
        paramInt1 = 0;
        label316:
        if (paramInt1 >= m) {
          break label396;
        }
        if (getChildAt(paramInt1).getVisibility() == 8) {
          break label384;
        }
        this.hG[paramInt1] = k;
        i = paramInt2;
        if (paramInt2 > 0)
        {
          localObject = this.hG;
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
        this.hG[paramInt1] = 0;
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
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.hG[paramInt1], 1073741824), n);
        ((View)localObject).getLayoutParams().width = ((View)localObject).getMeasuredWidth();
        i = paramInt2 + ((View)localObject).getMeasuredWidth();
      }
      paramInt1 += 1;
    }
    setMeasuredDimension(View.resolveSizeAndState(paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), 0), View.resolveSizeAndState(this.hr, n, 0));
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.hy = paramColorStateList;
    if (this.hv != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.hv;
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
    this.hE = paramDrawable;
    if (this.hv != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.hv;
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
    this.hF = paramInt;
    if (this.hv != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.hv;
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
    this.hu = paramBoolean;
  }
  
  public void setItemIconSize(int paramInt)
  {
    this.hz = paramInt;
    if (this.hv != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.hv;
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
    this.hD = paramInt;
    if (this.hv != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.hv;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i];
        localBottomNavigationItemView.setTextAppearanceActive(paramInt);
        if (this.hA != null) {
          localBottomNavigationItemView.setTextColor(this.hA);
        }
        i += 1;
      }
    }
  }
  
  public void setItemTextAppearanceInactive(int paramInt)
  {
    this.hC = paramInt;
    if (this.hv != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.hv;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i];
        localBottomNavigationItemView.setTextAppearanceInactive(paramInt);
        if (this.hA != null) {
          localBottomNavigationItemView.setTextColor(this.hA);
        }
        i += 1;
      }
    }
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.hA = paramColorStateList;
    if (this.hv != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.hv;
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
    this.he = paramInt;
  }
  
  public void setPresenter(BottomNavigationPresenter paramBottomNavigationPresenter)
  {
    this.hH = paramBottomNavigationPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.internal.BottomNavigationMenuView
 * JD-Core Version:    0.7.0.1
 */