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
  private static final int[] hY = { 16842912 };
  private static final int[] il = { -16842910 };
  int iA = 0;
  private ColorStateList iB;
  private int iC;
  private ColorStateList iD;
  private final ColorStateList iE;
  private int iF;
  private int iG;
  private Drawable iH;
  private int iI;
  private int[] iJ;
  BottomNavigationPresenter iK;
  h iL;
  int ie;
  final TransitionSet im;
  private final int io;
  private final int iq;
  private final int ir;
  private final int is;
  private final int it;
  private final View.OnClickListener iu;
  private final l.a<BottomNavigationItemView> iw = new l.c(5);
  public boolean ix;
  BottomNavigationItemView[] iy;
  int iz = 0;
  
  public BottomNavigationMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = getResources();
    this.io = paramContext.getDimensionPixelSize(2131166099);
    this.iq = paramContext.getDimensionPixelSize(2131166100);
    this.ir = paramContext.getDimensionPixelSize(2131166093);
    this.is = paramContext.getDimensionPixelSize(2131166094);
    this.it = paramContext.getDimensionPixelSize(2131166097);
    this.iE = bm();
    this.im = new AutoTransition();
    this.im.ao(0);
    this.im.h(115L);
    this.im.c(new b());
    this.im.c(new e());
    this.iu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = ((BottomNavigationItemView)paramAnonymousView).getItemData();
        if (!BottomNavigationMenuView.b(BottomNavigationMenuView.this).a(paramAnonymousView, BottomNavigationMenuView.a(BottomNavigationMenuView.this), 0)) {
          paramAnonymousView.setChecked(true);
        }
      }
    };
    this.iJ = new int[5];
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
    BottomNavigationItemView localBottomNavigationItemView2 = (BottomNavigationItemView)this.iw.acquire();
    BottomNavigationItemView localBottomNavigationItemView1 = localBottomNavigationItemView2;
    if (localBottomNavigationItemView2 == null) {
      localBottomNavigationItemView1 = new BottomNavigationItemView(getContext());
    }
    return localBottomNavigationItemView1;
  }
  
  public final void a(h paramh)
  {
    this.iL = paramh;
  }
  
  public final ColorStateList bm()
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
    localObject = il;
    int[] arrayOfInt1 = hY;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int k = localColorStateList.getColorForState(il, j);
    return new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { k, i, j });
  }
  
  public final void bn()
  {
    removeAllViews();
    Object localObject1;
    if (this.iy != null)
    {
      localObject1 = this.iy;
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2 != null) {
          this.iw.release(localObject2);
        }
        i += 1;
      }
    }
    if (this.iL.size() == 0)
    {
      this.iz = 0;
      this.iA = 0;
      this.iy = null;
      return;
    }
    this.iy = new BottomNavigationItemView[this.iL.size()];
    boolean bool = f(this.ie, this.iL.hF().size());
    int i = 0;
    if (i < this.iL.size())
    {
      this.iK.iO = true;
      this.iL.getItem(i).setCheckable(true);
      this.iK.iO = false;
      localObject1 = getNewItem();
      this.iy[i] = localObject1;
      ((BottomNavigationItemView)localObject1).setIconTintList(this.iB);
      ((BottomNavigationItemView)localObject1).setIconSize(this.iC);
      ((BottomNavigationItemView)localObject1).setTextColor(this.iE);
      ((BottomNavigationItemView)localObject1).setTextAppearanceInactive(this.iF);
      ((BottomNavigationItemView)localObject1).setTextAppearanceActive(this.iG);
      ((BottomNavigationItemView)localObject1).setTextColor(this.iD);
      if (this.iH != null) {
        ((BottomNavigationItemView)localObject1).setItemBackground(this.iH);
      }
      for (;;)
      {
        ((BottomNavigationItemView)localObject1).setShifting(bool);
        ((BottomNavigationItemView)localObject1).setLabelVisibilityMode(this.ie);
        ((BottomNavigationItemView)localObject1).a((j)this.iL.getItem(i));
        ((BottomNavigationItemView)localObject1).setItemPosition(i);
        ((BottomNavigationItemView)localObject1).setOnClickListener(this.iu);
        addView((View)localObject1);
        i += 1;
        break;
        ((BottomNavigationItemView)localObject1).setItemBackground(this.iI);
      }
    }
    this.iA = Math.min(this.iL.size() - 1, this.iA);
    this.iL.getItem(this.iA).setChecked(true);
  }
  
  public ColorStateList getIconTintList()
  {
    return this.iB;
  }
  
  public Drawable getItemBackground()
  {
    if ((this.iy != null) && (this.iy.length > 0)) {
      return this.iy[0].getBackground();
    }
    return this.iH;
  }
  
  @Deprecated
  public int getItemBackgroundRes()
  {
    return this.iI;
  }
  
  public int getItemIconSize()
  {
    return this.iC;
  }
  
  public int getItemTextAppearanceActive()
  {
    return this.iG;
  }
  
  public int getItemTextAppearanceInactive()
  {
    return this.iF;
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.iD;
  }
  
  public int getLabelVisibilityMode()
  {
    return this.ie;
  }
  
  public int getSelectedItemId()
  {
    return this.iz;
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
    int j = this.iL.hF().size();
    int m = getChildCount();
    int n = View.MeasureSpec.makeMeasureSpec(this.it, 1073741824);
    Object localObject;
    label158:
    int k;
    if ((f(this.ie, j)) && (this.ix))
    {
      localObject = getChildAt(this.iA);
      paramInt2 = this.is;
      paramInt1 = paramInt2;
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.ir, -2147483648), n);
        paramInt1 = Math.max(paramInt2, ((View)localObject).getMeasuredWidth());
      }
      if (((View)localObject).getVisibility() != 8)
      {
        paramInt2 = 1;
        paramInt2 = j - paramInt2;
        j = Math.min(i1 - this.iq * paramInt2, Math.min(paramInt1, this.ir));
        if (paramInt2 != 0) {
          break label264;
        }
        paramInt1 = i;
        k = Math.min((i1 - j) / paramInt1, this.io);
        paramInt1 = i1 - j - paramInt2 * k;
        paramInt2 = 0;
        label187:
        if (paramInt2 >= m) {
          break label396;
        }
        if (getChildAt(paramInt2).getVisibility() == 8) {
          break label275;
        }
        localObject = this.iJ;
        if (paramInt2 != this.iA) {
          break label269;
        }
        i = j;
        label223:
        localObject[paramInt2] = i;
        if (paramInt1 <= 0) {
          break label282;
        }
        localObject = this.iJ;
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
        this.iJ[paramInt2] = 0;
      }
    }
    else
    {
      if (j == 0)
      {
        paramInt1 = paramInt2;
        k = Math.min(i1 / paramInt1, this.ir);
        paramInt2 = i1 - k * j;
        paramInt1 = 0;
        label316:
        if (paramInt1 >= m) {
          break label396;
        }
        if (getChildAt(paramInt1).getVisibility() == 8) {
          break label384;
        }
        this.iJ[paramInt1] = k;
        i = paramInt2;
        if (paramInt2 > 0)
        {
          localObject = this.iJ;
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
        this.iJ[paramInt1] = 0;
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
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.iJ[paramInt1], 1073741824), n);
        ((View)localObject).getLayoutParams().width = ((View)localObject).getMeasuredWidth();
        i = paramInt2 + ((View)localObject).getMeasuredWidth();
      }
      paramInt1 += 1;
    }
    setMeasuredDimension(View.resolveSizeAndState(paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), 0), View.resolveSizeAndState(this.it, n, 0));
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    this.iB = paramColorStateList;
    if (this.iy != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.iy;
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
    this.iH = paramDrawable;
    if (this.iy != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.iy;
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
    this.iI = paramInt;
    if (this.iy != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.iy;
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
    this.ix = paramBoolean;
  }
  
  public void setItemIconSize(int paramInt)
  {
    this.iC = paramInt;
    if (this.iy != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.iy;
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
    this.iG = paramInt;
    if (this.iy != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.iy;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i];
        localBottomNavigationItemView.setTextAppearanceActive(paramInt);
        if (this.iD != null) {
          localBottomNavigationItemView.setTextColor(this.iD);
        }
        i += 1;
      }
    }
  }
  
  public void setItemTextAppearanceInactive(int paramInt)
  {
    this.iF = paramInt;
    if (this.iy != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.iy;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i];
        localBottomNavigationItemView.setTextAppearanceInactive(paramInt);
        if (this.iD != null) {
          localBottomNavigationItemView.setTextColor(this.iD);
        }
        i += 1;
      }
    }
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.iD = paramColorStateList;
    if (this.iy != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.iy;
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
    this.ie = paramInt;
  }
  
  public void setPresenter(BottomNavigationPresenter paramBottomNavigationPresenter)
  {
    this.iK = paramBottomNavigationPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.internal.BottomNavigationMenuView
 * JD-Core Version:    0.7.0.1
 */