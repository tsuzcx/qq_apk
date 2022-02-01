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
import androidx.core.f.e.a;
import androidx.core.f.e.c;
import androidx.core.g.z;
import androidx.g.a.a.b;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionSet;
import com.google.android.material.a.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class BottomNavigationMenuView
  extends ViewGroup
  implements p
{
  private static final int[] xk = { 16842912 };
  private static final int[] xl = { -16842910 };
  final TransitionSet dpS;
  private final int dpT;
  private final int dpU;
  private final int dpV;
  private final int dpW;
  private final int dpX;
  private final View.OnClickListener dpY;
  private final e.a<BottomNavigationItemView> dpZ;
  boolean dqa;
  BottomNavigationItemView[] dqb;
  int dqc;
  int dqd;
  private ColorStateList dqe;
  private ColorStateList dqf;
  private final ColorStateList dqg;
  private Drawable dqh;
  private int dqi;
  private int[] dqj;
  BottomNavigationPresenter dqk;
  h hP;
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
    AppMethodBeat.i(209669);
    this.dpZ = new e.c(5);
    this.dqc = 0;
    this.dqd = 0;
    paramContext = getResources();
    this.dpT = paramContext.getDimensionPixelSize(a.d.design_bottom_navigation_item_max_width);
    this.dpU = paramContext.getDimensionPixelSize(a.d.design_bottom_navigation_item_min_width);
    this.dpV = paramContext.getDimensionPixelSize(a.d.design_bottom_navigation_active_item_max_width);
    this.dpW = paramContext.getDimensionPixelSize(a.d.design_bottom_navigation_active_item_min_width);
    this.dpX = paramContext.getDimensionPixelSize(a.d.design_bottom_navigation_height);
    this.dqg = VJ();
    this.dpS = new AutoTransition();
    this.dpS.gJ(0);
    this.dpS.bD(115L);
    this.dpS.b(new b());
    this.dpS.c(new com.google.android.material.internal.j());
    this.dpY = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(209664);
        paramAnonymousView = ((BottomNavigationItemView)paramAnonymousView).getItemData();
        if (!BottomNavigationMenuView.b(BottomNavigationMenuView.this).a(paramAnonymousView, BottomNavigationMenuView.a(BottomNavigationMenuView.this), 0)) {
          paramAnonymousView.setChecked(true);
        }
        AppMethodBeat.o(209664);
      }
    };
    this.dqj = new int[5];
    AppMethodBeat.o(209669);
  }
  
  static boolean cu(int paramInt1, int paramInt2)
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
    AppMethodBeat.i(209675);
    BottomNavigationItemView localBottomNavigationItemView2 = (BottomNavigationItemView)this.dpZ.acquire();
    BottomNavigationItemView localBottomNavigationItemView1 = localBottomNavigationItemView2;
    if (localBottomNavigationItemView2 == null) {
      localBottomNavigationItemView1 = new BottomNavigationItemView(getContext());
    }
    AppMethodBeat.o(209675);
    return localBottomNavigationItemView1;
  }
  
  public final ColorStateList VJ()
  {
    AppMethodBeat.i(209966);
    Object localObject = new TypedValue();
    if (!getContext().getTheme().resolveAttribute(16842808, (TypedValue)localObject, true))
    {
      AppMethodBeat.o(209966);
      return null;
    }
    ColorStateList localColorStateList = a.l(getContext(), ((TypedValue)localObject).resourceId);
    if (!getContext().getTheme().resolveAttribute(a.a.colorPrimary, (TypedValue)localObject, true))
    {
      AppMethodBeat.o(209966);
      return null;
    }
    int i = ((TypedValue)localObject).data;
    int j = localColorStateList.getDefaultColor();
    localObject = xl;
    int[] arrayOfInt1 = xk;
    int[] arrayOfInt2 = EMPTY_STATE_SET;
    int k = localColorStateList.getColorForState(xl, j);
    localColorStateList = new ColorStateList(new int[][] { localObject, arrayOfInt1, arrayOfInt2 }, new int[] { k, i, j });
    AppMethodBeat.o(209966);
    return localColorStateList;
  }
  
  public final void VK()
  {
    AppMethodBeat.i(209995);
    removeAllViews();
    Object localObject1;
    if (this.dqb != null)
    {
      localObject1 = this.dqb;
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        if (localObject2 != null) {
          this.dpZ.release(localObject2);
        }
        i += 1;
      }
    }
    if (this.hP.size() == 0)
    {
      this.dqc = 0;
      this.dqd = 0;
      this.dqb = null;
      AppMethodBeat.o(209995);
      return;
    }
    this.dqb = new BottomNavigationItemView[this.hP.size()];
    boolean bool = cu(this.labelVisibilityMode, this.hP.db().size());
    int i = 0;
    if (i < this.hP.size())
    {
      this.dqk.dqn = true;
      this.hP.getItem(i).setCheckable(true);
      this.dqk.dqn = false;
      localObject1 = getNewItem();
      this.dqb[i] = localObject1;
      ((BottomNavigationItemView)localObject1).setIconTintList(this.dqe);
      ((BottomNavigationItemView)localObject1).setIconSize(this.itemIconSize);
      ((BottomNavigationItemView)localObject1).setTextColor(this.dqg);
      ((BottomNavigationItemView)localObject1).setTextAppearanceInactive(this.itemTextAppearanceInactive);
      ((BottomNavigationItemView)localObject1).setTextAppearanceActive(this.itemTextAppearanceActive);
      ((BottomNavigationItemView)localObject1).setTextColor(this.dqf);
      if (this.dqh != null) {
        ((BottomNavigationItemView)localObject1).setItemBackground(this.dqh);
      }
      for (;;)
      {
        ((BottomNavigationItemView)localObject1).setShifting(bool);
        ((BottomNavigationItemView)localObject1).setLabelVisibilityMode(this.labelVisibilityMode);
        ((BottomNavigationItemView)localObject1).a((androidx.appcompat.view.menu.j)this.hP.getItem(i));
        ((BottomNavigationItemView)localObject1).setItemPosition(i);
        ((BottomNavigationItemView)localObject1).setOnClickListener(this.dpY);
        addView((View)localObject1);
        i += 1;
        break;
        ((BottomNavigationItemView)localObject1).setItemBackground(this.dqi);
      }
    }
    this.dqd = Math.min(this.hP.size() - 1, this.dqd);
    this.hP.getItem(this.dqd).setChecked(true);
    AppMethodBeat.o(209995);
  }
  
  public final void g(h paramh)
  {
    this.hP = paramh;
  }
  
  public ColorStateList getIconTintList()
  {
    return this.dqe;
  }
  
  public Drawable getItemBackground()
  {
    AppMethodBeat.i(209925);
    if ((this.dqb != null) && (this.dqb.length > 0))
    {
      localDrawable = this.dqb[0].getBackground();
      AppMethodBeat.o(209925);
      return localDrawable;
    }
    Drawable localDrawable = this.dqh;
    AppMethodBeat.o(209925);
    return localDrawable;
  }
  
  @Deprecated
  public int getItemBackgroundRes()
  {
    return this.dqi;
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
    return this.dqf;
  }
  
  public int getLabelVisibilityMode()
  {
    return this.labelVisibilityMode;
  }
  
  public int getSelectedItemId()
  {
    return this.dqc;
  }
  
  public int getWindowAnimations()
  {
    return 0;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(209767);
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
        if (z.U(this) != 1) {
          break label103;
        }
        localView.layout(j - paramInt2 - localView.getMeasuredWidth(), 0, j - paramInt2, paramInt4);
      }
      for (;;)
      {
        paramInt3 = paramInt2 + localView.getMeasuredWidth();
        paramInt1 += 1;
        paramInt2 = paramInt3;
        break;
        label103:
        localView.layout(paramInt2, 0, localView.getMeasuredWidth() + paramInt2, paramInt4);
      }
    }
    AppMethodBeat.o(209767);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt2 = 1;
    int i = 1;
    AppMethodBeat.i(209751);
    int i1 = View.MeasureSpec.getSize(paramInt1);
    int j = this.hP.db().size();
    int m = getChildCount();
    int n = View.MeasureSpec.makeMeasureSpec(this.dpX, 1073741824);
    Object localObject;
    label164:
    int k;
    if ((cu(this.labelVisibilityMode, j)) && (this.dqa))
    {
      localObject = getChildAt(this.dqd);
      paramInt2 = this.dpW;
      paramInt1 = paramInt2;
      if (((View)localObject).getVisibility() != 8)
      {
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.dpV, -2147483648), n);
        paramInt1 = Math.max(paramInt2, ((View)localObject).getMeasuredWidth());
      }
      if (((View)localObject).getVisibility() != 8)
      {
        paramInt2 = 1;
        paramInt2 = j - paramInt2;
        j = Math.min(i1 - this.dpU * paramInt2, Math.min(paramInt1, this.dpV));
        if (paramInt2 != 0) {
          break label270;
        }
        paramInt1 = i;
        k = Math.min((i1 - j) / paramInt1, this.dpT);
        paramInt1 = i1 - j - paramInt2 * k;
        paramInt2 = 0;
        label193:
        if (paramInt2 >= m) {
          break label402;
        }
        if (getChildAt(paramInt2).getVisibility() == 8) {
          break label281;
        }
        localObject = this.dqj;
        if (paramInt2 != this.dqd) {
          break label275;
        }
        i = j;
        label229:
        localObject[paramInt2] = i;
        if (paramInt1 <= 0) {
          break label288;
        }
        localObject = this.dqj;
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
        this.dqj[paramInt2] = 0;
      }
    }
    else
    {
      if (j == 0)
      {
        paramInt1 = paramInt2;
        k = Math.min(i1 / paramInt1, this.dpV);
        paramInt2 = i1 - k * j;
        paramInt1 = 0;
        label322:
        if (paramInt1 >= m) {
          break label402;
        }
        if (getChildAt(paramInt1).getVisibility() == 8) {
          break label390;
        }
        this.dqj[paramInt1] = k;
        i = paramInt2;
        if (paramInt2 > 0)
        {
          localObject = this.dqj;
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
        this.dqj[paramInt1] = 0;
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
        ((View)localObject).measure(View.MeasureSpec.makeMeasureSpec(this.dqj[paramInt1], 1073741824), n);
        ((View)localObject).getLayoutParams().width = ((View)localObject).getMeasuredWidth();
        i = paramInt2 + ((View)localObject).getMeasuredWidth();
      }
      paramInt1 += 1;
    }
    setMeasuredDimension(View.resolveSizeAndState(paramInt2, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824), 0), View.resolveSizeAndState(this.dpX, n, 0));
    AppMethodBeat.o(209751);
  }
  
  public void setIconTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209791);
    this.dqe = paramColorStateList;
    if (this.dqb != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.dqb;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setIconTintList(paramColorStateList);
        i += 1;
      }
    }
    AppMethodBeat.o(209791);
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    AppMethodBeat.i(209915);
    this.dqh = paramDrawable;
    if (this.dqb != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.dqb;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setItemBackground(paramDrawable);
        i += 1;
      }
    }
    AppMethodBeat.o(209915);
  }
  
  public void setItemBackgroundRes(int paramInt)
  {
    AppMethodBeat.i(209895);
    this.dqi = paramInt;
    if (this.dqb != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.dqb;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setItemBackground(paramInt);
        i += 1;
      }
    }
    AppMethodBeat.o(209895);
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    this.dqa = paramBoolean;
  }
  
  public void setItemIconSize(int paramInt)
  {
    AppMethodBeat.i(209816);
    this.itemIconSize = paramInt;
    if (this.dqb != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.dqb;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setIconSize(paramInt);
        i += 1;
      }
    }
    AppMethodBeat.o(209816);
  }
  
  public void setItemTextAppearanceActive(int paramInt)
  {
    AppMethodBeat.i(209877);
    this.itemTextAppearanceActive = paramInt;
    if (this.dqb != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.dqb;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i];
        localBottomNavigationItemView.setTextAppearanceActive(paramInt);
        if (this.dqf != null) {
          localBottomNavigationItemView.setTextColor(this.dqf);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(209877);
  }
  
  public void setItemTextAppearanceInactive(int paramInt)
  {
    AppMethodBeat.i(209860);
    this.itemTextAppearanceInactive = paramInt;
    if (this.dqb != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.dqb;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        BottomNavigationItemView localBottomNavigationItemView = arrayOfBottomNavigationItemView[i];
        localBottomNavigationItemView.setTextAppearanceInactive(paramInt);
        if (this.dqf != null) {
          localBottomNavigationItemView.setTextColor(this.dqf);
        }
        i += 1;
      }
    }
    AppMethodBeat.o(209860);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209837);
    this.dqf = paramColorStateList;
    if (this.dqb != null)
    {
      BottomNavigationItemView[] arrayOfBottomNavigationItemView = this.dqb;
      int j = arrayOfBottomNavigationItemView.length;
      int i = 0;
      while (i < j)
      {
        arrayOfBottomNavigationItemView[i].setTextColor(paramColorStateList);
        i += 1;
      }
    }
    AppMethodBeat.o(209837);
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    this.labelVisibilityMode = paramInt;
  }
  
  public void setPresenter(BottomNavigationPresenter paramBottomNavigationPresenter)
  {
    this.dqk = paramBottomNavigationPresenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.BottomNavigationMenuView
 * JD-Core Version:    0.7.0.1
 */