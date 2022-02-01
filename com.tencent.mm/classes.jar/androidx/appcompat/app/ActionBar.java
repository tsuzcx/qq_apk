package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import androidx.appcompat.view.b;
import androidx.appcompat.view.b.a;

public abstract class ActionBar
{
  public abstract void N(int paramInt);
  
  public abstract void O(int paramInt);
  
  public b a(b.a parama)
  {
    return null;
  }
  
  public abstract void a(View paramView, ActionBar.LayoutParams paramLayoutParams);
  
  public abstract int aC();
  
  public Context aD()
  {
    return null;
  }
  
  public boolean aE()
  {
    return false;
  }
  
  public boolean aF()
  {
    return false;
  }
  
  public boolean aG()
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
  
  public void e(float paramFloat)
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
  
  public abstract void r(boolean paramBoolean);
  
  public abstract void s(boolean paramBoolean);
  
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
  
  public abstract void t(boolean paramBoolean);
  
  public abstract void u(boolean paramBoolean);
  
  public void v(boolean paramBoolean) {}
  
  public void w(boolean paramBoolean) {}
  
  public void x(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.appcompat.app.ActionBar
 * JD-Core Version:    0.7.0.1
 */