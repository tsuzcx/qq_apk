package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v7.view.i;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.o.a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.b;
import android.support.v7.widget.ba;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import java.util.ArrayList;

final class g
  extends ActionBar
{
  android.support.v7.widget.u ZU;
  boolean ZV;
  Window.Callback ZW;
  private boolean ZX;
  private boolean ZY;
  private ArrayList<Object> ZZ = new ArrayList();
  private final Runnable aaa = new Runnable()
  {
    public final void run()
    {
      g localg = g.this;
      Menu localMenu = localg.getMenu();
      if ((localMenu instanceof h)) {}
      for (localh = (h)localMenu;; localh = null)
      {
        if (localh != null) {
          localh.ia();
        }
        try
        {
          localMenu.clear();
          if ((!localg.ZW.onCreatePanelMenu(0, localMenu)) || (!localg.ZW.onPreparePanel(0, null, localMenu))) {
            localMenu.clear();
          }
          return;
        }
        finally
        {
          if (localh == null) {
            break;
          }
          localh.ib();
        }
      }
    }
  };
  private final Toolbar.b aab = new Toolbar.b()
  {
    public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      return g.this.ZW.onMenuItemSelected(0, paramAnonymousMenuItem);
    }
  };
  
  g(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback)
  {
    this.ZU = new ba(paramToolbar, false);
    this.ZW = new c(paramCallback);
    this.ZU.setWindowCallback(this.ZW);
    paramToolbar.setOnMenuItemClickListener(this.aab);
    this.ZU.setWindowTitle(paramCharSequence);
  }
  
  private void setDisplayOptions(int paramInt1, int paramInt2)
  {
    int i = this.ZU.getDisplayOptions();
    this.ZU.setDisplayOptions(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public final void P(boolean paramBoolean) {}
  
  public final void Q(boolean paramBoolean) {}
  
  public final void R(boolean paramBoolean)
  {
    if (paramBoolean == this.ZY) {}
    for (;;)
    {
      return;
      this.ZY = paramBoolean;
      int j = this.ZZ.size();
      int i = 0;
      while (i < j)
      {
        this.ZZ.get(i);
        i += 1;
      }
    }
  }
  
  public final void a(View paramView, ActionBar.LayoutParams paramLayoutParams)
  {
    if (paramView != null) {
      paramView.setLayoutParams(paramLayoutParams);
    }
    this.ZU.setCustomView(paramView);
  }
  
  public final boolean b(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 1) {
      gw();
    }
    return true;
  }
  
  public final boolean collapseActionView()
  {
    if (this.ZU.hasExpandedActionView())
    {
      this.ZU.collapseActionView();
      return true;
    }
    return false;
  }
  
  public final View getCustomView()
  {
    return this.ZU.getCustomView();
  }
  
  public final int getDisplayOptions()
  {
    return this.ZU.getDisplayOptions();
  }
  
  public final int getHeight()
  {
    return this.ZU.getHeight();
  }
  
  final Menu getMenu()
  {
    if (!this.ZX)
    {
      this.ZU.a(new a(), new b());
      this.ZX = true;
    }
    return this.ZU.getMenu();
  }
  
  public final Context getThemedContext()
  {
    return this.ZU.getContext();
  }
  
  public final CharSequence getTitle()
  {
    return this.ZU.getTitle();
  }
  
  public final void gr()
  {
    this.ZU.setIcon(2131235359);
  }
  
  public final void gs()
  {
    setDisplayOptions(0, 2);
  }
  
  public final void gt()
  {
    setDisplayOptions(0, 8);
  }
  
  public final void gu()
  {
    setDisplayOptions(16, 16);
  }
  
  public final boolean gw()
  {
    return this.ZU.showOverflowMenu();
  }
  
  public final boolean gx()
  {
    return this.ZU.hideOverflowMenu();
  }
  
  public final boolean gy()
  {
    this.ZU.jC().removeCallbacks(this.aaa);
    android.support.v4.view.u.b(this.ZU.jC(), this.aaa);
    return true;
  }
  
  public final void hide()
  {
    this.ZU.setVisibility(8);
  }
  
  public final boolean isShowing()
  {
    return this.ZU.getVisibility() == 0;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  final void onDestroy()
  {
    this.ZU.jC().removeCallbacks(this.aaa);
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
    this.ZU.setBackgroundDrawable(paramDrawable);
  }
  
  public final void setCustomView(int paramInt)
  {
    setCustomView(LayoutInflater.from(this.ZU.getContext()).inflate(paramInt, this.ZU.jC(), false));
  }
  
  public final void setCustomView(View paramView)
  {
    a(paramView, new ActionBar.LayoutParams(-2, -2));
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
    android.support.v4.view.u.l(this.ZU.jC(), paramFloat);
  }
  
  public final void setHomeActionContentDescription(int paramInt)
  {
    this.ZU.setNavigationContentDescription(paramInt);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    this.ZU.setLogo(paramDrawable);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.ZU.setTitle(paramCharSequence);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    this.ZU.setWindowTitle(paramCharSequence);
  }
  
  public final void show()
  {
    this.ZU.setVisibility(0);
  }
  
  final class a
    implements o.a
  {
    private boolean YW;
    
    a() {}
    
    public final void a(h paramh, boolean paramBoolean)
    {
      if (this.YW) {
        return;
      }
      this.YW = true;
      g.this.ZU.dismissPopupMenus();
      if (g.this.ZW != null) {
        g.this.ZW.onPanelClosed(108, paramh);
      }
      this.YW = false;
    }
    
    public final boolean d(h paramh)
    {
      if (g.this.ZW != null)
      {
        g.this.ZW.onMenuOpened(108, paramh);
        return true;
      }
      return false;
    }
  }
  
  final class b
    implements h.a
  {
    b() {}
    
    public final boolean a(h paramh, MenuItem paramMenuItem)
    {
      return false;
    }
    
    public final void b(h paramh)
    {
      if (g.this.ZW != null)
      {
        if (!g.this.ZU.isOverflowMenuShowing()) {
          break label41;
        }
        g.this.ZW.onPanelClosed(108, paramh);
      }
      label41:
      while (!g.this.ZW.onPreparePanel(0, null, paramh)) {
        return;
      }
      g.this.ZW.onMenuOpened(108, paramh);
    }
  }
  
  final class c
    extends i
  {
    public c(Window.Callback paramCallback)
    {
      super();
    }
    
    public final View onCreatePanelView(int paramInt)
    {
      if (paramInt == 0) {
        return new View(g.this.ZU.getContext());
      }
      return super.onCreatePanelView(paramInt);
    }
    
    public final boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
      if ((bool) && (!g.this.ZV))
      {
        g.this.ZU.iD();
        g.this.ZV = true;
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.g
 * JD-Core Version:    0.7.0.1
 */