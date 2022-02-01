package android.support.v7.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v4.view.t;
import android.support.v7.view.i;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.h.a;
import android.support.v7.view.menu.o.a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.b;
import android.support.v7.widget.ba;
import android.support.v7.widget.u;
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
  u XS;
  boolean XT;
  Window.Callback XU;
  private boolean XV;
  private boolean XW;
  private ArrayList<Object> XX = new ArrayList();
  private final Runnable XY = new Runnable()
  {
    public final void run()
    {
      g localg = g.this;
      Menu localMenu = localg.getMenu();
      if ((localMenu instanceof h)) {}
      for (localh = (h)localMenu;; localh = null)
      {
        if (localh != null) {
          localh.hB();
        }
        try
        {
          localMenu.clear();
          if ((!localg.XU.onCreatePanelMenu(0, localMenu)) || (!localg.XU.onPreparePanel(0, null, localMenu))) {
            localMenu.clear();
          }
          return;
        }
        finally
        {
          if (localh == null) {
            break;
          }
          localh.hC();
        }
      }
    }
  };
  private final Toolbar.b XZ = new Toolbar.b()
  {
    public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      return g.this.XU.onMenuItemSelected(0, paramAnonymousMenuItem);
    }
  };
  
  g(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback)
  {
    this.XS = new ba(paramToolbar, false);
    this.XU = new c(paramCallback);
    this.XS.setWindowCallback(this.XU);
    paramToolbar.setOnMenuItemClickListener(this.XZ);
    this.XS.setWindowTitle(paramCharSequence);
  }
  
  private void setDisplayOptions(int paramInt1, int paramInt2)
  {
    int i = this.XS.getDisplayOptions();
    this.XS.setDisplayOptions(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public final void Q(boolean paramBoolean) {}
  
  public final void R(boolean paramBoolean) {}
  
  public final void S(boolean paramBoolean)
  {
    if (paramBoolean == this.XW) {}
    for (;;)
    {
      return;
      this.XW = paramBoolean;
      int j = this.XX.size();
      int i = 0;
      while (i < j)
      {
        this.XX.get(i);
        i += 1;
      }
    }
  }
  
  public final boolean b(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 1) {
      fX();
    }
    return true;
  }
  
  public final boolean collapseActionView()
  {
    if (this.XS.hasExpandedActionView())
    {
      this.XS.collapseActionView();
      return true;
    }
    return false;
  }
  
  public final void fS()
  {
    this.XS.setIcon(2131234429);
  }
  
  public final void fT()
  {
    setDisplayOptions(0, 2);
  }
  
  public final void fU()
  {
    setDisplayOptions(0, 8);
  }
  
  public final void fV()
  {
    setDisplayOptions(16, 16);
  }
  
  public final boolean fX()
  {
    return this.XS.showOverflowMenu();
  }
  
  public final boolean fY()
  {
    return this.XS.hideOverflowMenu();
  }
  
  public final boolean fZ()
  {
    this.XS.jd().removeCallbacks(this.XY);
    t.b(this.XS.jd(), this.XY);
    return true;
  }
  
  public final View getCustomView()
  {
    return this.XS.getCustomView();
  }
  
  public final int getDisplayOptions()
  {
    return this.XS.getDisplayOptions();
  }
  
  public final int getHeight()
  {
    return this.XS.getHeight();
  }
  
  final Menu getMenu()
  {
    if (!this.XV)
    {
      this.XS.a(new a(), new b());
      this.XV = true;
    }
    return this.XS.getMenu();
  }
  
  public final Context getThemedContext()
  {
    return this.XS.getContext();
  }
  
  public final CharSequence getTitle()
  {
    return this.XS.getTitle();
  }
  
  public final void hide()
  {
    this.XS.setVisibility(8);
  }
  
  public final boolean isShowing()
  {
    return this.XS.getVisibility() == 0;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  final void onDestroy()
  {
    this.XS.jd().removeCallbacks(this.XY);
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
    this.XS.setBackgroundDrawable(paramDrawable);
  }
  
  public final void setCustomView(int paramInt)
  {
    setCustomView(LayoutInflater.from(this.XS.getContext()).inflate(paramInt, this.XS.jd(), false));
  }
  
  public final void setCustomView(View paramView)
  {
    ActionBar.LayoutParams localLayoutParams = new ActionBar.LayoutParams(-2);
    if (paramView != null) {
      paramView.setLayoutParams(localLayoutParams);
    }
    this.XS.setCustomView(paramView);
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
    t.k(this.XS.jd(), paramFloat);
  }
  
  public final void setHomeActionContentDescription(int paramInt)
  {
    this.XS.setNavigationContentDescription(paramInt);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    this.XS.setLogo(paramDrawable);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    this.XS.setWindowTitle(paramCharSequence);
  }
  
  public final void show()
  {
    this.XS.setVisibility(0);
  }
  
  final class a
    implements o.a
  {
    private boolean WU;
    
    a() {}
    
    public final void a(h paramh, boolean paramBoolean)
    {
      if (this.WU) {
        return;
      }
      this.WU = true;
      g.this.XS.dismissPopupMenus();
      if (g.this.XU != null) {
        g.this.XU.onPanelClosed(108, paramh);
      }
      this.WU = false;
    }
    
    public final boolean d(h paramh)
    {
      if (g.this.XU != null)
      {
        g.this.XU.onMenuOpened(108, paramh);
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
      if (g.this.XU != null)
      {
        if (!g.this.XS.isOverflowMenuShowing()) {
          break label41;
        }
        g.this.XU.onPanelClosed(108, paramh);
      }
      label41:
      while (!g.this.XU.onPreparePanel(0, null, paramh)) {
        return;
      }
      g.this.XU.onMenuOpened(108, paramh);
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
        return new View(g.this.XS.getContext());
      }
      return super.onCreatePanelView(paramInt);
    }
    
    public final boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
      if ((bool) && (!g.this.XT))
      {
        g.this.XS.ic();
        g.this.XT = true;
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.g
 * JD-Core Version:    0.7.0.1
 */