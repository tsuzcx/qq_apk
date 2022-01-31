package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.u;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.o.a;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;

public abstract interface w
{
  public abstract void a(o.a parama, h.a parama1);
  
  public abstract void a(aq paramaq);
  
  public abstract void a(Menu paramMenu, o.a parama);
  
  public abstract u c(int paramInt, long paramLong);
  
  public abstract void collapseActionView();
  
  public abstract void dismissPopupMenus();
  
  public abstract boolean fE();
  
  public abstract boolean fF();
  
  public abstract void fG();
  
  public abstract Context getContext();
  
  public abstract View getCustomView();
  
  public abstract int getDisplayOptions();
  
  public abstract int getHeight();
  
  public abstract Menu getMenu();
  
  public abstract int getNavigationMode();
  
  public abstract CharSequence getTitle();
  
  public abstract int getVisibility();
  
  public abstract ViewGroup gz();
  
  public abstract boolean hasExpandedActionView();
  
  public abstract boolean hideOverflowMenu();
  
  public abstract boolean isOverflowMenuShowing();
  
  public abstract void setBackgroundDrawable(Drawable paramDrawable);
  
  public abstract void setCollapsible(boolean paramBoolean);
  
  public abstract void setCustomView(View paramView);
  
  public abstract void setDisplayOptions(int paramInt);
  
  public abstract void setIcon(int paramInt);
  
  public abstract void setIcon(Drawable paramDrawable);
  
  public abstract void setLogo(int paramInt);
  
  public abstract void setLogo(Drawable paramDrawable);
  
  public abstract void setNavigationContentDescription(int paramInt);
  
  public abstract void setVisibility(int paramInt);
  
  public abstract void setWindowCallback(Window.Callback paramCallback);
  
  public abstract void setWindowTitle(CharSequence paramCharSequence);
  
  public abstract boolean showOverflowMenu();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.widget.w
 * JD-Core Version:    0.7.0.1
 */