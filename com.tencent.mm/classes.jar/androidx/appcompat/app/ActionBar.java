package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.appcompat.a.j;
import androidx.appcompat.view.b;
import androidx.appcompat.view.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class ActionBar
{
  public void A(boolean paramBoolean) {}
  
  public void B(boolean paramBoolean) {}
  
  public abstract void L(int paramInt);
  
  public abstract void M(int paramInt);
  
  public b a(b.a parama)
  {
    return null;
  }
  
  public abstract void a(View paramView, LayoutParams paramLayoutParams);
  
  public abstract int bu();
  
  public Context bw()
  {
    return null;
  }
  
  public boolean bx()
  {
    return false;
  }
  
  public boolean by()
  {
    return false;
  }
  
  public boolean bz()
  {
    return false;
  }
  
  public boolean c(KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean collapseActionView()
  {
    return false;
  }
  
  public void g(float paramFloat)
  {
    if (paramFloat != 0.0F) {
      throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
    }
  }
  
  public abstract View getCustomView();
  
  public abstract int getHeight();
  
  public abstract CharSequence getTitle();
  
  public abstract void hide();
  
  public abstract boolean isShowing();
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  void onDestroy() {}
  
  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public abstract void setBackgroundDrawable(Drawable paramDrawable);
  
  public abstract void setCustomView(View paramView);
  
  public void setHideOnContentScrollEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
    }
  }
  
  public abstract void setIcon(int paramInt);
  
  public abstract void setLogo(Drawable paramDrawable);
  
  public void setWindowTitle(CharSequence paramCharSequence) {}
  
  public abstract void show();
  
  public abstract void v(boolean paramBoolean);
  
  public abstract void w(boolean paramBoolean);
  
  public abstract void x(boolean paramBoolean);
  
  public abstract void y(boolean paramBoolean);
  
  public void z(boolean paramBoolean) {}
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int fl;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
      this.fl = 0;
      this.fl = 8388627;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(200440);
      this.fl = 0;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.ActionBarLayout);
      this.fl = paramContext.getInt(a.j.ActionBarLayout_android_layout_gravity, 0);
      paramContext.recycle();
      AppMethodBeat.o(200440);
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
      this.fl = 0;
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.fl = 0;
      this.fl = paramLayoutParams.fl;
    }
  }
  
  @Deprecated
  public static abstract class a
  {
    public abstract CharSequence getContentDescription();
    
    public abstract View getCustomView();
    
    public abstract Drawable getIcon();
    
    public abstract CharSequence getText();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.app.ActionBar
 * JD-Core Version:    0.7.0.1
 */