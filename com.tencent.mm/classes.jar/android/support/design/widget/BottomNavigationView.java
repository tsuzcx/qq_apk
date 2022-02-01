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
  private final BottomNavigationPresenter hH = new BottomNavigationPresenter();
  private final h hI;
  private final BottomNavigationMenuView hK;
  private MenuInflater kT;
  private b kU;
  private a kV;
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968689);
  }
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.hI = new a(paramContext);
    this.hK = new BottomNavigationMenuView(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    this.hK.setLayoutParams(localLayoutParams);
    this.hH.hK = this.hK;
    this.hH.id = 1;
    this.hK.setPresenter(this.hH);
    this.hI.a(this.hH);
    this.hH.a(getContext(), this.hI);
    paramAttributeSet = f.b(paramContext, paramAttributeSet, a.a.BottomNavigationView, paramInt, 2131821634, new int[] { 6, 5 });
    if (paramAttributeSet.hasValue(4)) {
      this.hK.setIconTintList(paramAttributeSet.getColorStateList(4));
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
      this.hK.setItemBackgroundRes(paramInt);
      if (paramAttributeSet.hasValue(9))
      {
        paramInt = paramAttributeSet.getResourceId(9, 0);
        this.hH.hL = true;
        getMenuInflater().inflate(paramInt, this.hI);
        this.hH.hL = false;
        this.hH.p(true);
      }
      paramAttributeSet.avP.recycle();
      addView(this.hK, localLayoutParams);
      if (Build.VERSION.SDK_INT < 21)
      {
        paramAttributeSet = new View(paramContext);
        paramAttributeSet.setBackgroundColor(b.n(paramContext, 2131100213));
        paramAttributeSet.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131166102)));
        addView(paramAttributeSet);
      }
      this.hI.a(new h.a()
      {
        public final boolean a(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
        {
          if ((BottomNavigationView.a(BottomNavigationView.this) != null) && (paramAnonymousMenuItem.getItemId() == BottomNavigationView.this.getSelectedItemId())) {
            BottomNavigationView.a(BottomNavigationView.this);
          }
          while ((BottomNavigationView.b(BottomNavigationView.this) != null) && (!BottomNavigationView.b(BottomNavigationView.this).bE())) {
            return true;
          }
          return false;
        }
        
        public final void b(h paramAnonymoush) {}
      });
      return;
      this.hK.setIconTintList(this.hK.bf());
    }
  }
  
  private MenuInflater getMenuInflater()
  {
    if (this.kT == null) {
      this.kT = new g(getContext());
    }
    return this.kT;
  }
  
  public Drawable getItemBackground()
  {
    return this.hK.getItemBackground();
  }
  
  @Deprecated
  public int getItemBackgroundResource()
  {
    return this.hK.getItemBackgroundRes();
  }
  
  public int getItemIconSize()
  {
    return this.hK.getItemIconSize();
  }
  
  public ColorStateList getItemIconTintList()
  {
    return this.hK.getIconTintList();
  }
  
  public int getItemTextAppearanceActive()
  {
    return this.hK.getItemTextAppearanceActive();
  }
  
  public int getItemTextAppearanceInactive()
  {
    return this.hK.getItemTextAppearanceInactive();
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.hK.getItemTextColor();
  }
  
  public int getLabelVisibilityMode()
  {
    return this.hK.getLabelVisibilityMode();
  }
  
  public int getMaxItemCount()
  {
    return 5;
  }
  
  public Menu getMenu()
  {
    return this.hI;
  }
  
  public int getSelectedItemId()
  {
    return this.hK.getSelectedItemId();
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.Mm);
    this.hI.dispatchRestoreInstanceState(paramParcelable.kX);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.kX = new Bundle();
    this.hI.e(localSavedState.kX);
    return localSavedState;
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    this.hK.setItemBackground(paramDrawable);
  }
  
  public void setItemBackgroundResource(int paramInt)
  {
    this.hK.setItemBackgroundRes(paramInt);
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    if (this.hK.hu != paramBoolean)
    {
      this.hK.setItemHorizontalTranslationEnabled(paramBoolean);
      this.hH.p(false);
    }
  }
  
  public void setItemIconSize(int paramInt)
  {
    this.hK.setItemIconSize(paramInt);
  }
  
  public void setItemIconSizeRes(int paramInt)
  {
    setItemIconSize(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconTintList(ColorStateList paramColorStateList)
  {
    this.hK.setIconTintList(paramColorStateList);
  }
  
  public void setItemTextAppearanceActive(int paramInt)
  {
    this.hK.setItemTextAppearanceActive(paramInt);
  }
  
  public void setItemTextAppearanceInactive(int paramInt)
  {
    this.hK.setItemTextAppearanceInactive(paramInt);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.hK.setItemTextColor(paramColorStateList);
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    if (this.hK.getLabelVisibilityMode() != paramInt)
    {
      this.hK.setLabelVisibilityMode(paramInt);
      this.hH.p(false);
    }
  }
  
  public void setOnNavigationItemReselectedListener(a parama)
  {
    this.kV = parama;
  }
  
  public void setOnNavigationItemSelectedListener(b paramb)
  {
    this.kU = paramb;
  }
  
  public void setSelectedItemId(int paramInt)
  {
    MenuItem localMenuItem = this.hI.findItem(paramInt);
    if ((localMenuItem != null) && (!this.hI.a(localMenuItem, this.hH, 0))) {
      localMenuItem.setChecked(true);
    }
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    Bundle kX;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.kX = paramParcel.readBundle(paramClassLoader);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeBundle(this.kX);
    }
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract boolean bE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.widget.BottomNavigationView
 * JD-Core Version:    0.7.0.1
 */