package mqq.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.InputQueue.Callback;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceHolder.Callback2;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public class Window4FragmentTitle
  extends Window
{
  private ViewGroup mContentParent;
  private ViewGroup mDecor;
  private LayoutInflater mLayoutInflater;
  
  public Window4FragmentTitle(Context paramContext)
  {
    super(paramContext);
    this.mLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  private ViewGroup createScreenTitle()
  {
    Object localObject2 = getContext();
    FrameLayout localFrameLayout = new FrameLayout((Context)localObject2);
    LinearLayout localLinearLayout = new LinearLayout((Context)localObject2);
    localLinearLayout.setOrientation(1);
    Object localObject1 = new FrameLayout((Context)localObject2);
    ((FrameLayout)localObject1).setId(16908310);
    localObject2 = new FrameLayout((Context)localObject2);
    ((FrameLayout)localObject2).setId(16908290);
    localLinearLayout.addView((View)localObject1, new LinearLayout.LayoutParams(-1, -2));
    localObject1 = new LinearLayout.LayoutParams(-1, 0);
    ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
    localLinearLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    localFrameLayout.addView(localLinearLayout, new FrameLayout.LayoutParams(-1, -1));
    return localFrameLayout;
  }
  
  private void installDecor()
  {
    this.mDecor = createScreenTitle();
    this.mDecor.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    this.mContentParent = ((ViewGroup)findViewById(16908290));
  }
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams) {}
  
  public void closeAllPanels() {}
  
  public void closePanel(int paramInt) {}
  
  public View getCurrentFocus()
  {
    return null;
  }
  
  public View getDecorView()
  {
    if (this.mDecor == null) {
      installDecor();
    }
    return this.mDecor;
  }
  
  public LayoutInflater getLayoutInflater()
  {
    return this.mLayoutInflater;
  }
  
  public int getNavigationBarColor()
  {
    return 0;
  }
  
  public int getStatusBarColor()
  {
    return 0;
  }
  
  public int getVolumeControlStream()
  {
    return 0;
  }
  
  public boolean hasContentView()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.mContentParent != null)
    {
      bool1 = bool2;
      if (this.mContentParent.getChildCount() > 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void invalidatePanelMenu(int paramInt) {}
  
  public boolean isFloating()
  {
    return false;
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  protected void onActive() {}
  
  public void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public void openPanel(int paramInt, KeyEvent paramKeyEvent) {}
  
  public View peekDecorView()
  {
    return getDecorView();
  }
  
  public boolean performContextMenuIdentifierAction(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public boolean performPanelIdentifierAction(int paramInt1, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  public boolean performPanelShortcut(int paramInt1, int paramInt2, KeyEvent paramKeyEvent, int paramInt3)
  {
    return false;
  }
  
  public void restoreHierarchyState(Bundle paramBundle) {}
  
  public Bundle saveHierarchyState()
  {
    return null;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (this.mDecor != null) {
      this.mDecor.setBackgroundDrawable(paramDrawable);
    }
  }
  
  public void setChildDrawable(int paramInt, Drawable paramDrawable) {}
  
  public void setChildInt(int paramInt1, int paramInt2) {}
  
  public void setContentView(int paramInt)
  {
    if (this.mContentParent == null) {
      installDecor();
    }
    for (;;)
    {
      this.mLayoutInflater.inflate(paramInt, this.mContentParent);
      return;
      this.mContentParent.removeAllViews();
    }
  }
  
  public void setContentView(View paramView)
  {
    setContentView(paramView, new ViewGroup.LayoutParams(-1, -1));
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    if (this.mContentParent == null) {
      installDecor();
    }
    for (;;)
    {
      this.mContentParent.addView(paramView, paramLayoutParams);
      return;
      this.mContentParent.removeAllViews();
    }
  }
  
  public void setDecorCaptionShade(int paramInt) {}
  
  public void setFeatureDrawable(int paramInt, Drawable paramDrawable) {}
  
  public void setFeatureDrawableAlpha(int paramInt1, int paramInt2) {}
  
  public void setFeatureDrawableResource(int paramInt1, int paramInt2) {}
  
  public void setFeatureDrawableUri(int paramInt, Uri paramUri) {}
  
  public void setFeatureInt(int paramInt1, int paramInt2)
  {
    if (this.mContentParent == null) {}
    FrameLayout localFrameLayout;
    do
    {
      do
      {
        return;
      } while (paramInt1 != 7);
      localFrameLayout = (FrameLayout)findViewById(16908310);
    } while (localFrameLayout == null);
    this.mLayoutInflater.inflate(paramInt2, localFrameLayout);
  }
  
  public void setNavigationBarColor(int paramInt) {}
  
  public void setResizingCaptionDrawable(Drawable paramDrawable) {}
  
  public void setStatusBarColor(int paramInt) {}
  
  public void setTitle(CharSequence paramCharSequence) {}
  
  public void setTitleColor(int paramInt) {}
  
  public void setVolumeControlStream(int paramInt) {}
  
  public boolean superDispatchGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean superDispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean superDispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public boolean superDispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public boolean superDispatchTrackballEvent(MotionEvent paramMotionEvent)
  {
    return false;
  }
  
  public void takeInputQueue(InputQueue.Callback paramCallback) {}
  
  public void takeKeyEvents(boolean paramBoolean) {}
  
  public void takeSurface(SurfaceHolder.Callback2 paramCallback2) {}
  
  public void togglePanel(int paramInt, KeyEvent paramKeyEvent) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     mqq.app.Window4FragmentTitle
 * JD-Core Version:    0.7.0.1
 */