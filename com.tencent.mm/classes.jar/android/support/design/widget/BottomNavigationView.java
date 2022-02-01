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
  private final BottomNavigationPresenter iK = new BottomNavigationPresenter();
  private final h iL;
  private final BottomNavigationMenuView iN;
  private MenuInflater lS;
  private b lT;
  private a lU;
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968689);
  }
  
  public BottomNavigationView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.iL = new a(paramContext);
    this.iN = new BottomNavigationMenuView(paramContext);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    this.iN.setLayoutParams(localLayoutParams);
    this.iK.iN = this.iN;
    this.iK.id = 1;
    this.iN.setPresenter(this.iK);
    this.iL.a(this.iK);
    this.iK.a(getContext(), this.iL);
    paramAttributeSet = f.b(paramContext, paramAttributeSet, a.a.BottomNavigationView, paramInt, 2131821634, new int[] { 6, 5 });
    if (paramAttributeSet.hasValue(4)) {
      this.iN.setIconTintList(paramAttributeSet.getColorStateList(4));
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
      this.iN.setItemBackgroundRes(paramInt);
      if (paramAttributeSet.hasValue(9))
      {
        paramInt = paramAttributeSet.getResourceId(9, 0);
        this.iK.iO = true;
        getMenuInflater().inflate(paramInt, this.iL);
        this.iK.iO = false;
        this.iK.p(true);
      }
      paramAttributeSet.awJ.recycle();
      addView(this.iN, localLayoutParams);
      if (Build.VERSION.SDK_INT < 21)
      {
        paramAttributeSet = new View(paramContext);
        paramAttributeSet.setBackgroundColor(b.n(paramContext, 2131100213));
        paramAttributeSet.setLayoutParams(new FrameLayout.LayoutParams(-1, getResources().getDimensionPixelSize(2131166102)));
        addView(paramAttributeSet);
      }
      this.iL.a(new h.a()
      {
        public final boolean a(h paramAnonymoush, MenuItem paramAnonymousMenuItem)
        {
          if ((BottomNavigationView.a(BottomNavigationView.this) != null) && (paramAnonymousMenuItem.getItemId() == BottomNavigationView.this.getSelectedItemId())) {
            BottomNavigationView.a(BottomNavigationView.this);
          }
          while ((BottomNavigationView.b(BottomNavigationView.this) != null) && (!BottomNavigationView.b(BottomNavigationView.this).bL())) {
            return true;
          }
          return false;
        }
        
        public final void b(h paramAnonymoush) {}
      });
      return;
      this.iN.setIconTintList(this.iN.bm());
    }
  }
  
  private MenuInflater getMenuInflater()
  {
    if (this.lS == null) {
      this.lS = new g(getContext());
    }
    return this.lS;
  }
  
  public Drawable getItemBackground()
  {
    return this.iN.getItemBackground();
  }
  
  @Deprecated
  public int getItemBackgroundResource()
  {
    return this.iN.getItemBackgroundRes();
  }
  
  public int getItemIconSize()
  {
    return this.iN.getItemIconSize();
  }
  
  public ColorStateList getItemIconTintList()
  {
    return this.iN.getIconTintList();
  }
  
  public int getItemTextAppearanceActive()
  {
    return this.iN.getItemTextAppearanceActive();
  }
  
  public int getItemTextAppearanceInactive()
  {
    return this.iN.getItemTextAppearanceInactive();
  }
  
  public ColorStateList getItemTextColor()
  {
    return this.iN.getItemTextColor();
  }
  
  public int getLabelVisibilityMode()
  {
    return this.iN.getLabelVisibilityMode();
  }
  
  public int getMaxItemCount()
  {
    return 5;
  }
  
  public Menu getMenu()
  {
    return this.iL;
  }
  
  public int getSelectedItemId()
  {
    return this.iN.getSelectedItemId();
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.Nj);
    this.iL.dispatchRestoreInstanceState(paramParcelable.lW);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.lW = new Bundle();
    this.iL.e(localSavedState.lW);
    return localSavedState;
  }
  
  public void setItemBackground(Drawable paramDrawable)
  {
    this.iN.setItemBackground(paramDrawable);
  }
  
  public void setItemBackgroundResource(int paramInt)
  {
    this.iN.setItemBackgroundRes(paramInt);
  }
  
  public void setItemHorizontalTranslationEnabled(boolean paramBoolean)
  {
    if (this.iN.ix != paramBoolean)
    {
      this.iN.setItemHorizontalTranslationEnabled(paramBoolean);
      this.iK.p(false);
    }
  }
  
  public void setItemIconSize(int paramInt)
  {
    this.iN.setItemIconSize(paramInt);
  }
  
  public void setItemIconSizeRes(int paramInt)
  {
    setItemIconSize(getResources().getDimensionPixelSize(paramInt));
  }
  
  public void setItemIconTintList(ColorStateList paramColorStateList)
  {
    this.iN.setIconTintList(paramColorStateList);
  }
  
  public void setItemTextAppearanceActive(int paramInt)
  {
    this.iN.setItemTextAppearanceActive(paramInt);
  }
  
  public void setItemTextAppearanceInactive(int paramInt)
  {
    this.iN.setItemTextAppearanceInactive(paramInt);
  }
  
  public void setItemTextColor(ColorStateList paramColorStateList)
  {
    this.iN.setItemTextColor(paramColorStateList);
  }
  
  public void setLabelVisibilityMode(int paramInt)
  {
    if (this.iN.getLabelVisibilityMode() != paramInt)
    {
      this.iN.setLabelVisibilityMode(paramInt);
      this.iK.p(false);
    }
  }
  
  public void setOnNavigationItemReselectedListener(a parama)
  {
    this.lU = parama;
  }
  
  public void setOnNavigationItemSelectedListener(b paramb)
  {
    this.lT = paramb;
  }
  
  public void setSelectedItemId(int paramInt)
  {
    MenuItem localMenuItem = this.iL.findItem(paramInt);
    if ((localMenuItem != null) && (!this.iL.a(localMenuItem, this.iK, 0))) {
      localMenuItem.setChecked(true);
    }
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    Bundle lW;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.lW = paramParcel.readBundle(paramClassLoader);
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeBundle(this.lW);
    }
  }
  
  public static abstract interface a {}
  
  public static abstract interface b
  {
    public abstract boolean bL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.widget.BottomNavigationView
 * JD-Core Version:    0.7.0.1
 */