package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.a.a.a;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

public abstract class ActionBar
{
  public void Q(boolean paramBoolean) {}
  
  public void R(boolean paramBoolean) {}
  
  public void S(boolean paramBoolean) {}
  
  public b a(b.a parama)
  {
    return null;
  }
  
  public boolean b(KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean collapseActionView()
  {
    return false;
  }
  
  public abstract void fS();
  
  public abstract void fT();
  
  public abstract void fU();
  
  public abstract void fV();
  
  public void fW()
  {
    throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
  }
  
  public boolean fX()
  {
    return false;
  }
  
  public boolean fY()
  {
    return false;
  }
  
  public boolean fZ()
  {
    return false;
  }
  
  public abstract View getCustomView();
  
  public abstract int getDisplayOptions();
  
  public abstract int getHeight();
  
  public Context getThemedContext()
  {
    return null;
  }
  
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
  
  public abstract void setCustomView(int paramInt);
  
  public abstract void setCustomView(View paramView);
  
  public abstract void setDisplayHomeAsUpEnabled(boolean paramBoolean);
  
  public abstract void setDisplayOptions(int paramInt);
  
  public void setElevation(float paramFloat)
  {
    if (paramFloat != 0.0F) {
      throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
    }
  }
  
  public void setHomeActionContentDescription(int paramInt) {}
  
  public abstract void setLogo(Drawable paramDrawable);
  
  public void setWindowTitle(CharSequence paramCharSequence) {}
  
  public abstract void show();
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    public int gravity = 0;
    
    public LayoutParams(int paramInt)
    {
      super(-2);
      this.gravity = 8388627;
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.ActionBarLayout);
      this.gravity = paramContext.getInt(0, 0);
      paramContext.recycle();
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
      this.gravity = paramLayoutParams.gravity;
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.ActionBar
 * JD-Core Version:    0.7.0.1
 */