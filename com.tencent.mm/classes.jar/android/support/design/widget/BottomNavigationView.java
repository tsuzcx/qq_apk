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
import android.support.v4.view.u;
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
  private final BottomNavigationPresenter kD = new BottomNavigationPresenter();
  private final h kE;
  private final BottomNavigationMenuView kG;
  private MenuInflater nN;
  private b nO;
  private a nP;
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968694);
  }
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.kE = new a(paramContext);
    this.kG = new BottomNavigationMenuView(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    this.kG.setLayoutParams(localLayoutParams);
    this.kD.kG = this.kG;
    this.kD.id = 1;
    this.kG.setPresenter(this.kD);
    this.kE.a(this.kD);
    this.kD.a(getContext(), this.kE);
    paramAttributeSet = f.b(paramContext, paramAttributeSet, a.a.BottomNavigationView, paramInt, 2131821682, new int[] { 6, 5 });
    if (paramAttributeSet.hasValue(4)) {
      this.kG.setIconTintList(paramAttributeSet.getColorStateList(4));
    }
    for (;;)
    {
      setItemIconSize(paramAttributeSet.getDimensionPixelSize(3, getResources().getDimensionPixelSize(2131166139)));
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
        u.l(this, paramAttributeSet.getDimensionPixelSize(0, 0));
      }
      setLabelVisibilityMode(paramAttributeSet.getInteger(8, -1));
      setItemHorizontalTranslationEnabled(paramAttributeSet.getBoolean(2, true));
      paramInt = paramAttributeSet.getResourceId(1, 0);
      this.kG.setItemBackgroundRes(paramInt);
      if (paramAttributeSet.hasValue(9))
      {
        paramInt = paramAttributeSet.getResourceId(9, 0);
        this.kD.kH = true;
        getMenuInflater().inflate(paramInt, this.kE);
        this.kD.kH = false;
        this.kD.p(true);
      }
      paramAttributeSet.ayy.recycle();
      addView(this.kG, localLayoutParams);
      if (Build.VERSION.SDK_INT < 21)
      {
        paramAttributeSet = new View(paramContext);
        paramAttributeSet.setBackgroundColor(b.n(paramContext, 2131100247));
        paramAttributeSet.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131166143)));
        addView(paramAttributeSet);
      }
      this.kE.a(new h.a()
      {
        public final boolean a(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
        {
          if ((BottomNavigationView.a(BottomNavigationView.this) != null) && (paramAnonymousMenuItem.getItemId() == BottomNavigationView.this.getSelectedItemId())) {
            BottomNavigationView.a(BottomNavigationView.this);
          }
          while ((BottomNavigationView.b(BottomNavigationView.this) != null) && (!BottomNavigationView.b(BottomNavigationView.this).cc())) {
            return true;
          }
          return false;
        }
        
        public final void b(h paramAnonymoush) {}
      });
      return;
      this.kG.setIconTintList(this.kG.bD());
    }
  }
  
  private MenuInflater getMenuInflater()
  {
    if (this.nN == null) {
      this.nN = new g(getContext());
    }
    return this.nN;
  }
  
  public Drawable getItemBackground()
  {
    return this.kG.getItemBackground();
  }
  
  @Deprecated
  public int getItemBackgroundResource()
  {
    return this.kG.getItemBackgroundRes();
  }
  
  public int getItemIconSize()
  {
    return this.kG.getItemIconSize();
  }
  
  public ColorStateList getItemIconTintList()
  {
    return this.kG.getIconTintList();
  }
  
  public int getItemTextAppearanceActive()
  {
    return this.kG.getItemTextAppearanceActive();
  }
  
  public int getItemTextAppearanceInactive()
  {
    return this.kG.getItemTextAppearanceInactive();
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.kG.getItemTextColor();
  }
  
  public int getLabelVisibilityMode()
  {
    return this.kG.getLabelVisibilityMode();
  }
  
  public int getMaxItemCount()
  {
    return 5;
  }
  
  public Menu getMenu()
  {
    return this.kE;
  }
  
  public int getSelectedItemId()
  {
    return this.kG.getSelectedItemId();
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.Pm);
    this.kE.dispatchRestoreInstanceState(paramParcelable.nR);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.nR = new Bundle();
    this.kE.e(localSavedState.nR);
    return localSavedState;
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    this.kG.setItemBackground(paramDrawable);
  }
  
  public void setItemBackgroundResource(int paramInt)
  {
    this.kG.setItemBackgroundRes(paramInt);
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    if (this.kG.kq != paramBoolean)
    {
      this.kG.setItemHorizontalTranslationEnabled(paramBoolean);
      this.kD.p(false);
    }
  }
  
  public void setItemIconSize(int paramInt)
  {
    this.kG.setItemIconSize(paramInt);
  }
  
  public void setItemIconSizeRes(int paramInt)
  {
    setItemIconSize(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconTintList(ColorStateList paramColorStateList)
  {
    this.kG.setIconTintList(paramColorStateList);
  }
  
  public void setItemTextAppearanceActive(int paramInt)
  {
    this.kG.setItemTextAppearanceActive(paramInt);
  }
  
  public void setItemTextAppearanceInactive(int paramInt)
  {
    this.kG.setItemTextAppearanceInactive(paramInt);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.kG.setItemTextColor(paramColorStateList);
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    if (this.kG.getLabelVisibilityMode() != paramInt)
    {
      this.kG.setLabelVisibilityMode(paramInt);
      this.kD.p(false);
    }
  }
  
  public void setOnNavigationItemReselectedListener(a parama)
  {
    this.nP = parama;
  }
  
  public void setOnNavigationItemSelectedListener(b paramb)
  {
    this.nO = paramb;
  }
  
  public void setSelectedItemId(int paramInt)
  {
    MenuItem localMenuItem = this.kE.findItem(paramInt);
    if ((localMenuItem != null) && (!this.kE.a(localMenuItem, this.kD, 0))) {
      localMenuItem.setChecked(true);
    }
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    Bundle nR;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.nR = paramParcel.readBundle(paramClassLoader);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeBundle(this.nR);
    }
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract boolean cc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.BottomNavigationView
 * JD-Core Version:    0.7.0.1
 */