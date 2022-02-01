package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.a.a;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.internal.BottomNavigationPresenter;
import android.support.design.internal.a;
import android.support.design.internal.f;
import android.support.v4.content.b;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.t;
import android.support.v7.view.g;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.widget.az;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class BottomNavigationView
  extends FrameLayout
{
  private final BottomNavigationPresenter kB = new BottomNavigationPresenter();
  private final h kC;
  private final BottomNavigationMenuView kE;
  private MenuInflater nL;
  private b nM;
  private a nN;
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968689);
  }
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.kC = new a(paramContext);
    this.kE = new BottomNavigationMenuView(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    this.kE.setLayoutParams(localLayoutParams);
    this.kB.kE = this.kE;
    this.kB.id = 1;
    this.kE.setPresenter(this.kB);
    this.kC.a(this.kB);
    this.kB.a(getContext(), this.kC);
    paramAttributeSet = f.b(paramContext, paramAttributeSet, a.a.BottomNavigationView, paramInt, 2131821634, new int[] { 6, 5 });
    if (paramAttributeSet.hasValue(4)) {
      this.kE.setIconTintList(paramAttributeSet.getColorStateList(4));
    }
    for (;;)
    {
      setItemIconSize(paramAttributeSet.getDimensionPixelSize(3, getResources().getDimensionPixelSize(2131166098)));
      if (paramAttributeSet.hasValue(6)) {
        setItemTextAppearanceInactive(paramAttributeSet.getResourceId(6, 0));
      }
      if (paramAttributeSet.hasValue(5)) {
        setItemTextAppearanceActive(paramAttributeSet.getResourceId(5, 0));
      }
      if (paramAttributeSet.hasValue(7)) {
        setItemTextColor(paramAttributeSet.getColorStateList(7));
      }
      if (paramAttributeSet.hasValue(0)) {
        t.k(this, paramAttributeSet.getDimensionPixelSize(0, 0));
      }
      setLabelVisibilityMode(paramAttributeSet.getInteger(8, -1));
      setItemHorizontalTranslationEnabled(paramAttributeSet.getBoolean(2, true));
      paramInt = paramAttributeSet.getResourceId(1, 0);
      this.kE.setItemBackgroundRes(paramInt);
      if (paramAttributeSet.hasValue(9))
      {
        paramInt = paramAttributeSet.getResourceId(9, 0);
        this.kB.kF = true;
        getMenuInflater().inflate(paramInt, this.kC);
        this.kB.kF = false;
        this.kB.p(true);
      }
      paramAttributeSet.ayA.recycle();
      addView(this.kE, localLayoutParams);
      if (Build.VERSION.SDK_INT < 21)
      {
        paramAttributeSet = new View(paramContext);
        paramAttributeSet.setBackgroundColor(b.n(paramContext, 2131100213));
        paramAttributeSet.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131166102)));
        addView(paramAttributeSet);
      }
      this.kC.a(new h.a()
      {
        public final boolean a(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
        {
          if ((BottomNavigationView.a(BottomNavigationView.this) != null) && (paramAnonymousMenuItem.getItemId() == BottomNavigationView.this.getSelectedItemId())) {
            BottomNavigationView.a(BottomNavigationView.this);
          }
          while ((BottomNavigationView.b(BottomNavigationView.this) != null) && (!BottomNavigationView.b(BottomNavigationView.this).ca())) {
            return true;
          }
          return false;
        }
        
        public final void b(h paramAnonymoush) {}
      });
      return;
      this.kE.setIconTintList(this.kE.bB());
    }
  }
  
  private MenuInflater getMenuInflater()
  {
    if (this.nL == null) {
      this.nL = new g(getContext());
    }
    return this.nL;
  }
  
  public Drawable getItemBackground()
  {
    return this.kE.getItemBackground();
  }
  
  @Deprecated
  public int getItemBackgroundResource()
  {
    return this.kE.getItemBackgroundRes();
  }
  
  public int getItemIconSize()
  {
    return this.kE.getItemIconSize();
  }
  
  public ColorStateList getItemIconTintList()
  {
    return this.kE.getIconTintList();
  }
  
  public int getItemTextAppearanceActive()
  {
    return this.kE.getItemTextAppearanceActive();
  }
  
  public int getItemTextAppearanceInactive()
  {
    return this.kE.getItemTextAppearanceInactive();
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.kE.getItemTextColor();
  }
  
  public int getLabelVisibilityMode()
  {
    return this.kE.getLabelVisibilityMode();
  }
  
  public int getMaxItemCount()
  {
    return 5;
  }
  
  public Menu getMenu()
  {
    return this.kC;
  }
  
  public int getSelectedItemId()
  {
    return this.kE.getSelectedItemId();
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.Pa);
    this.kC.dispatchRestoreInstanceState(paramParcelable.nP);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.nP = new Bundle();
    this.kC.e(localSavedState.nP);
    return localSavedState;
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    this.kE.setItemBackground(paramDrawable);
  }
  
  public void setItemBackgroundResource(int paramInt)
  {
    this.kE.setItemBackgroundRes(paramInt);
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    if (this.kE.ko != paramBoolean)
    {
      this.kE.setItemHorizontalTranslationEnabled(paramBoolean);
      this.kB.p(false);
    }
  }
  
  public void setItemIconSize(int paramInt)
  {
    this.kE.setItemIconSize(paramInt);
  }
  
  public void setItemIconSizeRes(int paramInt)
  {
    setItemIconSize(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconTintList(ColorStateList paramColorStateList)
  {
    this.kE.setIconTintList(paramColorStateList);
  }
  
  public void setItemTextAppearanceActive(int paramInt)
  {
    this.kE.setItemTextAppearanceActive(paramInt);
  }
  
  public void setItemTextAppearanceInactive(int paramInt)
  {
    this.kE.setItemTextAppearanceInactive(paramInt);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.kE.setItemTextColor(paramColorStateList);
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    if (this.kE.getLabelVisibilityMode() != paramInt)
    {
      this.kE.setLabelVisibilityMode(paramInt);
      this.kB.p(false);
    }
  }
  
  public void setOnNavigationItemReselectedListener(a parama)
  {
    this.nN = parama;
  }
  
  public void setOnNavigationItemSelectedListener(b paramb)
  {
    this.nM = paramb;
  }
  
  public void setSelectedItemId(int paramInt)
  {
    MenuItem localMenuItem = this.kC.findItem(paramInt);
    if ((localMenuItem != null) && (!this.kC.a(localMenuItem, this.kB, 0))) {
      localMenuItem.setChecked(true);
    }
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    Bundle nP;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.nP = paramParcel.readBundle(paramClassLoader);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeBundle(this.nP);
    }
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract boolean ca();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.BottomNavigationView
 * JD-Core Version:    0.7.0.1
 */