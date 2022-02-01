package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import androidx.appcompat.view.menu.h.a;
import androidx.appcompat.view.menu.o.a;
import androidx.core.g.ad;

public abstract interface n
{
  public abstract void M(int paramInt);
  
  public abstract void a(Menu paramMenu, o.a parama);
  
  public abstract void a(o.a parama, h.a parama1);
  
  public abstract void a(w paramw);
  
  public abstract ad b(int paramInt, long paramLong);
  
  public abstract int bZ();
  
  public abstract int bu();
  
  public abstract boolean dB();
  
  public abstract boolean dC();
  
  public abstract boolean dD();
  
  public abstract boolean dE();
  
  public abstract void dF();
  
  public abstract void dN();
  
  public abstract boolean dv();
  
  public abstract ViewGroup eD();
  
  public abstract boolean eE();
  
  public abstract void eF();
  
  public abstract Context getContext();
  
  public abstract View getCustomView();
  
  public abstract int getHeight();
  
  public abstract Menu getMenu();
  
  public abstract CharSequence getTitle();
  
  public abstract int getVisibility();
  
  public abstract void setBackgroundDrawable(Drawable paramDrawable);
  
  public abstract void setCollapsible(boolean paramBoolean);
  
  public abstract void setCustomView(View paramView);
  
  public abstract void setIcon(int paramInt);
  
  public abstract void setIcon(Drawable paramDrawable);
  
  public abstract void setLogo(int paramInt);
  
  public abstract void setLogo(Drawable paramDrawable);
  
  public abstract void setVisibility(int paramInt);
  
  public abstract void setWindowCallback(Window.Callback paramCallback);
  
  public abstract void setWindowTitle(CharSequence paramCharSequence);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.widget.n
 * JD-Core Version:    0.7.0.1
 */