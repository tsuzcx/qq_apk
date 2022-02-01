package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.appcompat.a.a;
import androidx.appcompat.a.a.a;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.p;
import androidx.core.f.f.a;
import androidx.core.f.f.c;
import androidx.core.g.w;
import androidx.f.a.a.b;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionSet;
import com.google.android.material.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class BottomNavigationMenuView
  extends ViewGroup
  implements p
{
  private static final int[] wo = { 16842912 };
  private static final int[] wp = { -16842910 };
  final TransitionSet bwP;
  private final int bwQ;
  private final int bwR;
  private final int bwS;
  private final int bwT;
  private final int bwU;
  private final View.OnClickListener bwV;
  private final f.a<BottomNavigationItemView> bwW;
  boolean bwX;
  BottomNavigationItemView[] bwY;
  int bwZ;
  int bxa;
  private ColorStateList bxb;
  private ColorStateList bxc;
  private final ColorStateList bxd;
  private Drawable bxe;
  private int bxf;
  private int[] bxg;
  BottomNavigationPresenter bxh;
  h gU;
  private int itemIconSize;
  private int itemTextAppearanceActive;
  private int itemTextAppearanceInactive;
  int labelVisibilityMode;
  
  public BottomNavigationMenuView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BottomNavigationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(235147);
    this.bwW = new f.c(5);
    this.bwZ = 0;
    this.bxa = 0;
    paramContext = getResources();
    this.bwQ = paramContext.getDimensionPixelSize(a.d.design_bottom_navigation_item_max_width);
    this.bwR = paramContext.getDimensionPixelSize(a.d.design_bottom_navigation_item_min_width);
    this.bwS = paramContext.getDimensionPixelSize(a.d.design_bottom_navigation_active_item_max_width);
    this.bwT = paramContext.getDimensionPixelSize(a.d.design_bottom_navigation_active_item_min_width);
    this.bwU = paramContext.getDimensionPixelSize(a.d.design_bottom_navigation_height);
    this.bxd = wk();
    this.bwP = new AutoTransition();
    this.bwP.dz(0);
    this.bwP.r(115L);
    this.bwP.b(new b());
    this.bwP.c(new com.google.android.material.internal.j());
    this.bwV = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(235131);
        paramAnonymousView = ((BottomNavigationItemView)paramAnonymousView).getItemData();
        if (!BottomNavigationMenuView.b(BottomNavigationMenuView.this).a(paramAnonymousView, BottomNavigationMenuView.a(BottomNavigationMenuView.this), 0)) {
          paramAnonymousView.setChecked(true);
        }
        AppMethodBeat.o(235131);
      }
    };
    this.bxg = new int[5];
    AppMethodBeat.o(235147);
  }
  
  static boolean bz(int paramInt1, int paramInt2)
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
    AppMethodBeat.i(235186);
    BottomNavigationItemView localBottomNavigationItemView2 = (BottomNavigationItemView)this.bwW.acquire();
    BottomNavigationItemView localBottomNavigationItemView1 = localBottomNavigationItemView2;
    if (localBottomNavigationItemView2 == null) {
      localBottomNavigationItemView1 = new BottomNavigationItemView(getContext());
    }
    AppMethodBeat.o(235186);
    return localBottomNavigationItemView1;
  }
  
  public final void g(h paramh)
  {
    this.gU = paramh;
  }
  
  public ColorStateList getIconTintList()
  {
    return this.bxb;
  }
  
  public Drawable getItemBackground()
  {
    AppMethodBeat.i(235176);
    if ((this.bwY != null) && (this.bwY.length > 0))
    {
      localDrawable = this.bwY[0].getBackground();
      AppMethodBeat.o(235176);
      return localDrawable;
    }
    Drawable localDrawable = this.bxe;
    AppMethodBeat.o(235176);
    return localDrawable;
  }
  
  @Deprecated
  public int getItemBackgroundRes()
  {
    return this.bxf;
  }
  
  public int getItemIconSize()
  {
    return this.itemIconSize;
  }
  
  public int getItemTextAppearanceActive()
  {
    return this.itemTextAppearanceActive;
  }
  
  public int getItemTextAppearanceInactive()
  {
    return this.itemTextAppearanceInactive;
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.bxc;
  }
  
  public int getLabelVisibilityMode()
  {
    return this.labelVisibilityMode;
  }
  
  public int getSelectedItemId()
  {
    return this.bwZ;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(235153);
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
        if (w.I(this) != 1) {
          break label102;
        }
        localView.layout(j - paramInt2 - localView.getMeasuredWidth(), 0, j - paramInt2, paramInt4);
      }
      for (;;)
      {
        paramInt3 = paramInt2 + localView.getMeasuredWidth();
        paramInt1 += 1;
        paramInt2 = paramInt3;
        break;
        label102:
        localView.layout(paramInt2, 0, localView.getMeasuredWidth() + paramInt2, paramInt4);
      }
    }
    AppMethodBeat.o(235153);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = 1;
    int i = 1;
    AppMethodBeat.i(235152);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int j = this.gU.ci().size();
    int m = getChildCount();
    int n = View.MeasureSpec.makeMeasureSpec(this.bwU, 1073741824);
    Object localObject;
    label164:
    int k;
    if ((bz(this.labelVisibilityMode, j)) && (this.bwX))
    {
      localObject = getChildAt(this.bxa);
      paramInt2 = this.bwT;
      paramInt1 = paramInt2;
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.bwS, -2147483648), n);
        paramInt1 = Math.max(paramInt2, ((View)localObject).getMeasuredWidth());
      }
      if (((View)localObject).getVisibility() != 8)
      {
        paramInt2 = 1;
        paramInt2 = j - paramInt2;
        j = Math.min(i1 - this.bwR * paramInt2, Math.min(paramInt1, this.bwS));
        if (paramInt2 != 0) {
          break label270;
        }
        paramInt1 = i;
        k = Math.min((i1 - j) / paramInt1, this.bwQ);
        paramInt1 = i1 - j - paramInt2 * k;
        paramInt2 = 0;
        label193:
        if (paramInt2 >= m) {
          break label402;
        }
        if (getChildAt(paramInt2).getVisibility() == 8) {
          break label281;
        }
        localObject = this.bxg;
        if (paramInt2 != this.bxa) {
          break label275;
        }
        i = j;
        label229:
        localObject[paramInt2] = i;
        if (paramInt1 <= 0) {
          break label288;
        }
        localObject = this.bxg;
        localObject[paramInt2] += 1;
        paramInt1 -= 1;
      }
      label270:
      label275:
      label281:
      label288:
      for (;;)
      {
        paramInt2 += 1;
        break label193;
        paramInt2 = 0;
        break;
        paramInt1 = paramInt2;
        break label164;
        i = k;
        break label229;
        this.bxg[paramInt2] = 0;
      }
    }
    else
    {
      if (j == 0)
      {
        paramInt1 = paramInt2;
        k = Math.min(i1 / paramInt1, this.bwS);
        paramInt2 = i1 - k * j;
        paramInt1 = 0;
        label322:
        if (paramInt1 >= m) {
          break label402;
        }
        if (getChildAt(paramInt1).getVisibility() == 8) {
          break label390;
        }
        this.bxg[paramInt1] = k;
        i = paramInt2;
        if (paramInt2 > 0)
        {
          localObject = this.bxg;
          localObject[paramInt1] += 1;
        }
      }
      for (i = paramInt2 - 1;; i = paramInt2)
      {
        paramInt1 += 1;
        paramInt2 = i;
        break label322;
        paramInt1 = j;
        break;
        label390:
        this.bxg[paramInt1] = 0;
      }
    }
    label402:
    paramInt1 = 0;
    for (paramInt2 = 0; paramInt1 < m; paramInt2 = i)
    {
      localObject = getChildAt(paramInt1);
      i = paramInt2;
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.bxg[paramInt1], 1073741824), n);
        ((View)localObject).getLayoutParams().width = ((View)localObject).getMeasuredWidth();
        i = paramInt2 + ((View)localObject).getMeasuredWidth();
      }
      paramInt1 += 1;
    }
    setMeasuredDimension(View.resolveSizeAndState(paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), 0), View.resolveSizeAndState(this.bwU, n, 0));
    AppMethodBeat.o(235152);
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(235155);
    this.bxb = paramColorStateList;
    if (this.bwY != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.bwY;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setIconTintList(paramColorStateList);
        i += 1;
      }
    }
    AppMethodBeat.o(235155);
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    AppMethodBeat.i(235174);
    this.bxe = paramDrawable;
    if (this.bwY != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.bwY;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setItemBackground(paramDrawable);
        i += 1;
      }
    }
    AppMethodBeat.o(235174);
  }
  
  public void setItemBackgroundRes(int paramInt)
  {
    AppMethodBeat.i(235171);
    this.bxf = paramInt;
    if (this.bwY != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.bwY;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setItemBackground(paramInt);
        i += 1;
      }
    }
    AppMethodBeat.o(235171);
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    this.bwX = paramBoolean;
  }
  
  public void setItemIconSize(int paramInt)
  {
    AppMethodBeat.i(235158);
    this.itemIconSize = paramInt;
    if (this.bwY != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.bwY;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setIconSize(paramInt);
        i += 1;
      }
    }
    AppMethodBeat.o(235158);
  }
  
  public void setItemTextAppearanceActive(int paramInt)
  {
    AppMethodBeat.i(235168);
    this.itemTextAppearanceActive = paramInt;
    if (this.bwY != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.bwY;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i];
        localBottomNavigationItemView.setTextAppearanceActive(paramInt);
        if (this.bxc != null) {
          localBottomNavigationItemView.setTextColor(this.bxc);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(235168);
  }
  
  public void setItemTextAppearanceInactive(int paramInt)
  {
    AppMethodBeat.i(235163);
    this.itemTextAppearanceInactive = paramInt;
    if (this.bwY != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.bwY;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i];
        localBottomNavigationItemView.setTextAppearanceInactive(paramInt);
        if (this.bxc != null) {
          localBottomNavigationItemView.setTextColor(this.bxc);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(235163);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(235160);
    this.bxc = paramColorStateList;
    if (this.bwY != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.bwY;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setTextColor(paramColorStateList);
        i += 1;
      }
    }
    AppMethodBeat.o(235160);
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    this.labelVisibilityMode = paramInt;
  }
  
  public void setPresenter(BottomNavigationPresenter paramBottomNavigationPresenter)
  {
    this.bxh = paramBottomNavigationPresenter;
  }
  
  public final ColorStateList wk()
  {
    AppMethodBeat.i(235180);
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(16842808, (TypedValue)localObject, true))
    {
      AppMethodBeat.o(235180);
      return null;
    }
    ColorStateList localColorStateList = a.l(getContext(), ((TypedValue)localObject).resourceId);
    if (!getContext().getTheme().resolveAttribute(a.a.colorPrimary, (TypedValue)localObject, true))
    {
      AppMethodBeat.o(235180);
      return null;
    }
    int i = ((TypedValue)localObject).data;
    int j = localColorStateList.getDefaultColor();
    localObject = wp;
    int[] arrayOfInt1 = wo;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int k = localColorStateList.getColorForState(wp, j);
    localColorStateList = new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { k, i, j });
    AppMethodBeat.o(235180);
    return localColorStateList;
  }
  
  public final void wl()
  {
    AppMethodBeat.i(235184);
    removeAllViews();
    Object localObject1;
    if (this.bwY != null)
    {
      localObject1 = this.bwY;
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2 != null) {
          this.bwW.release(localObject2);
        }
        i += 1;
      }
    }
    if (this.gU.size() == 0)
    {
      this.bwZ = 0;
      this.bxa = 0;
      this.bwY = null;
      AppMethodBeat.o(235184);
      return;
    }
    this.bwY = new BottomNavigationItemView[this.gU.size()];
    boolean bool = bz(this.labelVisibilityMode, this.gU.ci().size());
    int i = 0;
    if (i < this.gU.size())
    {
      this.bxh.bxk = true;
      this.gU.getItem(i).setCheckable(true);
      this.bxh.bxk = false;
      localObject1 = getNewItem();
      this.bwY[i] = localObject1;
      ((BottomNavigationItemView)localObject1).setIconTintList(this.bxb);
      ((BottomNavigationItemView)localObject1).setIconSize(this.itemIconSize);
      ((BottomNavigationItemView)localObject1).setTextColor(this.bxd);
      ((BottomNavigationItemView)localObject1).setTextAppearanceInactive(this.itemTextAppearanceInactive);
      ((BottomNavigationItemView)localObject1).setTextAppearanceActive(this.itemTextAppearanceActive);
      ((BottomNavigationItemView)localObject1).setTextColor(this.bxc);
      if (this.bxe != null) {
        ((BottomNavigationItemView)localObject1).setItemBackground(this.bxe);
      }
      for (;;)
      {
        ((BottomNavigationItemView)localObject1).setShifting(bool);
        ((BottomNavigationItemView)localObject1).setLabelVisibilityMode(this.labelVisibilityMode);
        ((BottomNavigationItemView)localObject1).a((androidx.appcompat.view.menu.j)this.gU.getItem(i));
        ((BottomNavigationItemView)localObject1).setItemPosition(i);
        ((BottomNavigationItemView)localObject1).setOnClickListener(this.bwV);
        addView((View)localObject1);
        i += 1;
        break;
        ((BottomNavigationItemView)localObject1).setItemBackground(this.bxf);
      }
    }
    this.bxa = Math.min(this.gU.size() - 1, this.bxa);
    this.gU.getItem(this.bxa).setChecked(true);
    AppMethodBeat.o(235184);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationMenuView
 * JD-Core Version:    0.7.0.1
 */