package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v4.view.q;
import android.support.v7.view.i;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.o.a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.b;
import android.support.v7.widget.ay;
import android.support.v7.widget.w;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import java.util.ArrayList;

final class l
  extends ActionBar
{
  w Qq;
  boolean Qr;
  Window.Callback Qs;
  private boolean Qt;
  private boolean Qu;
  private ArrayList<Object> Qv = new ArrayList();
  private final Runnable Qw = new Runnable()
  {
    public final void run()
    {
      l locall = l.this;
      Menu localMenu = locall.getMenu();
      if ((localMenu instanceof h)) {}
      for (localh = (h)localMenu;; localh = null)
      {
        if (localh != null) {
          localh.fh();
        }
        try
        {
          localMenu.clear();
          if ((!locall.Qs.onCreatePanelMenu(0, localMenu)) || (!locall.Qs.onPreparePanel(0, null, localMenu))) {
            localMenu.clear();
          }
          return;
        }
        finally
        {
          if (localh == null) {
            break;
          }
          localh.fi();
        }
      }
    }
  };
  private final Toolbar.b Qx = new Toolbar.b()
  {
    public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      return l.this.Qs.onMenuItemSelected(0, paramAnonymousMenuItem);
    }
  };
  
  l(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback)
  {
    this.Qq = new ay(paramToolbar, false);
    this.Qs = new c(paramCallback);
    this.Qq.setWindowCallback(this.Qs);
    paramToolbar.setOnMenuItemClickListener(this.Qx);
    this.Qq.setWindowTitle(paramCharSequence);
  }
  
  private void setDisplayOptions(int paramInt1, int paramInt2)
  {
    int i = this.Qq.getDisplayOptions();
    this.Qq.setDisplayOptions(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public final void L(boolean paramBoolean) {}
  
  public final void M(boolean paramBoolean) {}
  
  public final void N(boolean paramBoolean)
  {
    if (paramBoolean == this.Qu) {}
    for (;;)
    {
      return;
      this.Qu = paramBoolean;
      int j = this.Qv.size();
      int i = 0;
      while (i < j)
      {
        this.Qv.get(i);
        i += 1;
      }
    }
  }
  
  public final boolean b(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 1) {
      eb();
    }
    return true;
  }
  
  public final boolean collapseActionView()
  {
    if (this.Qq.hasExpandedActionView())
    {
      this.Qq.collapseActionView();
      return true;
    }
    return false;
  }
  
  public final void dY()
  {
    setDisplayOptions(0, 2);
  }
  
  public final void dZ()
  {
    setDisplayOptions(0, 8);
  }
  
  public final void ea()
  {
    setDisplayOptions(16, 16);
  }
  
  public final boolean eb()
  {
    return this.Qq.showOverflowMenu();
  }
  
  public final boolean ec()
  {
    return this.Qq.hideOverflowMenu();
  }
  
  public final boolean ed()
  {
    this.Qq.gz().removeCallbacks(this.Qw);
    q.b(this.Qq.gz(), this.Qw);
    return true;
  }
  
  public final View getCustomView()
  {
    return this.Qq.getCustomView();
  }
  
  public final int getDisplayOptions()
  {
    return this.Qq.getDisplayOptions();
  }
  
  public final int getHeight()
  {
    return this.Qq.getHeight();
  }
  
  final Menu getMenu()
  {
    if (!this.Qt)
    {
      this.Qq.a(new a(), new b());
      this.Qt = true;
    }
    return this.Qq.getMenu();
  }
  
  public final Context getThemedContext()
  {
    return this.Qq.getContext();
  }
  
  public final CharSequence getTitle()
  {
    return this.Qq.getTitle();
  }
  
  public final void hide()
  {
    this.Qq.setVisibility(8);
  }
  
  public final boolean isShowing()
  {
    return this.Qq.getVisibility() == 0;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  final void onDestroy()
  {
    this.Qq.gz().removeCallbacks(this.Qw);
  }
  
  public final boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = false;
    Menu localMenu = getMenu();
    int i;
    if (localMenu != null)
    {
      if (paramKeyEvent == null) {
        break label61;
      }
      i = paramKeyEvent.getDeviceId();
      if (KeyCharacterMap.load(i).getKeyboardType() == 1) {
        break label66;
      }
    }
    label61:
    label66:
    for (bool = true;; bool = false)
    {
      localMenu.setQwertyMode(bool);
      bool = localMenu.performShortcut(paramInt, paramKeyEvent, 0);
      return bool;
      i = -1;
      break;
    }
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    this.Qq.setBackgroundDrawable(paramDrawable);
  }
  
  public final void setCustomView(int paramInt)
  {
    setCustomView(LayoutInflater.from(this.Qq.getContext()).inflate(paramInt, this.Qq.gz(), false));
  }
  
  public final void setCustomView(View paramView)
  {
    ActionBar.LayoutParams localLayoutParams = new ActionBar.LayoutParams();
    if (paramView != null) {
      paramView.setLayoutParams(localLayoutParams);
    }
    this.Qq.setCustomView(paramView);
  }
  
  public final void setDisplayHomeAsUpEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      setDisplayOptions(i, 4);
      return;
    }
  }
  
  @SuppressLint({"WrongConstant"})
  public final void setDisplayOptions(int paramInt)
  {
    setDisplayOptions(paramInt, -1);
  }
  
  public final void setElevation(float paramFloat)
  {
    q.h(this.Qq.gz(), paramFloat);
  }
  
  public final void setHomeActionContentDescription(int paramInt)
  {
    this.Qq.setNavigationContentDescription(paramInt);
  }
  
  public final void setIcon(int paramInt)
  {
    this.Qq.setIcon(paramInt);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    this.Qq.setLogo(paramDrawable);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    this.Qq.setWindowTitle(paramCharSequence);
  }
  
  public final void show()
  {
    this.Qq.setVisibility(0);
  }
  
  private final class a
    implements o.a
  {
    private boolean Pz;
    
    a() {}
    
    public final void a(h paramh, boolean paramBoolean)
    {
      if (this.Pz) {
        return;
      }
      this.Pz = true;
      l.this.Qq.dismissPopupMenus();
      if (l.this.Qs != null) {
        l.this.Qs.onPanelClosed(108, paramh);
      }
      this.Pz = false;
    }
    
    public final boolean d(h paramh)
    {
      if (l.this.Qs != null)
      {
        l.this.Qs.onMenuOpened(108, paramh);
        return true;
      }
      return false;
    }
  }
  
  private final class b
    implements h.a
  {
    b() {}
    
    public final boolean a(h paramh, MenuItem paramMenuItem)
    {
      return false;
    }
    
    public final void b(h paramh)
    {
      if (l.this.Qs != null)
      {
        if (!l.this.Qq.isOverflowMenuShowing()) {
          break label41;
        }
        l.this.Qs.onPanelClosed(108, paramh);
      }
      label41:
      while (!l.this.Qs.onPreparePanel(0, null, paramh)) {
        return;
      }
      l.this.Qs.onMenuOpened(108, paramh);
    }
  }
  
  private final class c
    extends i
  {
    public c(Window.Callback paramCallback)
    {
      super();
    }
    
    public final View onCreatePanelView(int paramInt)
    {
      if (paramInt == 0) {
        return new View(l.this.Qq.getContext());
      }
      return super.onCreatePanelView(paramInt);
    }
    
    public final boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
      if ((bool) && (!l.this.Qr))
      {
        l.this.Qq.fG();
        l.this.Qr = true;
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.l
 * JD-Core Version:    0.7.0.1
 */