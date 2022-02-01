package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import androidx.appcompat.view.menu.h.a;
import androidx.appcompat.view.menu.o.a;
import androidx.core.g.aa;

public abstract interface n
{
  public abstract void O(int paramInt);
  
  public abstract void a(Menu paramMenu, o.a parama);
  
  public abstract void a(o.a parama, h.a parama1);
  
  public abstract void a(w paramw);
  
  public abstract int aC();
  
  public abstract aa b(int paramInt, long paramLong);
  
  public abstract int bg();
  
  public abstract boolean cC();
  
  public abstract boolean cI();
  
  public abstract boolean cJ();
  
  public abstract boolean cK();
  
  public abstract boolean cL();
  
  public abstract void cM();
  
  public abstract void cU();
  
  public abstract ViewGroup dE();
  
  public abstract boolean dF();
  
  public abstract void dG();
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.widget.n
 * JD-Core Version:    0.7.0.1
 */