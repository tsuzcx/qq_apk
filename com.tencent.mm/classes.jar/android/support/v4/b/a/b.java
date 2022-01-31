package android.support.v4.b.a;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.MenuItem;
import android.view.View;

public abstract interface b
  extends MenuItem
{
  public abstract b a(android.support.v4.view.b paramb);
  
  public abstract boolean collapseActionView();
  
  public abstract android.support.v4.view.b cv();
  
  public abstract boolean expandActionView();
  
  public abstract b g(CharSequence paramCharSequence);
  
  public abstract View getActionView();
  
  public abstract int getAlphabeticModifiers();
  
  public abstract CharSequence getContentDescription();
  
  public abstract ColorStateList getIconTintList();
  
  public abstract PorterDuff.Mode getIconTintMode();
  
  public abstract int getNumericModifiers();
  
  public abstract CharSequence getTooltipText();
  
  public abstract b h(CharSequence paramCharSequence);
  
  public abstract boolean isActionViewExpanded();
  
  public abstract MenuItem setActionView(int paramInt);
  
  public abstract MenuItem setActionView(View paramView);
  
  public abstract MenuItem setAlphabeticShortcut(char paramChar, int paramInt);
  
  public abstract MenuItem setIconTintList(ColorStateList paramColorStateList);
  
  public abstract MenuItem setIconTintMode(PorterDuff.Mode paramMode);
  
  public abstract MenuItem setNumericShortcut(char paramChar, int paramInt);
  
  public abstract MenuItem setShortcut(char paramChar1, char paramChar2, int paramInt1, int paramInt2);
  
  public abstract void setShowAsAction(int paramInt);
  
  public abstract MenuItem setShowAsActionFlags(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.b.a.b
 * JD-Core Version:    0.7.0.1
 */