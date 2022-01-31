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
  u PY;
  boolean PZ;
  Window.Callback Qa;
  private boolean Qb;
  private boolean Qc;
  private ArrayList<Object> Qd = new ArrayList();
  private final Runnable Qe = new Runnable()
  {
    public final void run()
    {
      g localg = g.this;
      Menu localMenu = localg.getMenu();
      if ((localMenu instanceof h)) {}
      for (localh = (h)localMenu;; localh = null)
      {
        if (localh != null) {
          localh.fX();
        }
        try
        {
          localMenu.clear();
          if ((!localg.Qa.onCreatePanelMenu(0, localMenu)) || (!localg.Qa.onPreparePanel(0, null, localMenu))) {
            localMenu.clear();
          }
          return;
        }
        finally
        {
          if (localh == null) {
            break;
          }
          localh.fY();
        }
      }
    }
  };
  private final Toolbar.b Qf = new Toolbar.b()
  {
    public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      return g.this.Qa.onMenuItemSelected(0, paramAnonymousMenuItem);
    }
  };
  
  g(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback)
  {
    this.PY = new ba(paramToolbar, false);
    this.Qa = new c(paramCallback);
    this.PY.setWindowCallback(this.Qa);
    paramToolbar.setOnMenuItemClickListener(this.Qf);
    this.PY.setWindowTitle(paramCharSequence);
  }
  
  private void setDisplayOptions(int paramInt1, int paramInt2)
  {
    int i = this.PY.getDisplayOptions();
    this.PY.setDisplayOptions(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public final void K(boolean paramBoolean) {}
  
  public final void L(boolean paramBoolean) {}
  
  public final void M(boolean paramBoolean)
  {
    if (paramBoolean == this.Qc) {}
    for (;;)
    {
      return;
      this.Qc = paramBoolean;
      int j = this.Qd.size();
      int i = 0;
      while (i < j)
      {
        this.Qd.get(i);
        i += 1;
      }
    }
  }
  
  public final boolean b(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 1) {
      ex();
    }
    return true;
  }
  
  public final boolean collapseActionView()
  {
    if (this.PY.hasExpandedActionView())
    {
      this.PY.collapseActionView();
      return true;
    }
    return false;
  }
  
  public final void es()
  {
    this.PY.setIcon(2130840999);
  }
  
  public final void et()
  {
    setDisplayOptions(0, 2);
  }
  
  public final void eu()
  {
    setDisplayOptions(0, 8);
  }
  
  public final void ev()
  {
    setDisplayOptions(16, 16);
  }
  
  public final boolean ex()
  {
    return this.PY.showOverflowMenu();
  }
  
  public final boolean ey()
  {
    return this.PY.hideOverflowMenu();
  }
  
  public final boolean ez()
  {
    this.PY.hz().removeCallbacks(this.Qe);
    t.b(this.PY.hz(), this.Qe);
    return true;
  }
  
  public final View getCustomView()
  {
    return this.PY.getCustomView();
  }
  
  public final int getDisplayOptions()
  {
    return this.PY.getDisplayOptions();
  }
  
  public final int getHeight()
  {
    return this.PY.getHeight();
  }
  
  final Menu getMenu()
  {
    if (!this.Qb)
    {
      this.PY.a(new a(), new b());
      this.Qb = true;
    }
    return this.PY.getMenu();
  }
  
  public final Context getThemedContext()
  {
    return this.PY.getContext();
  }
  
  public final CharSequence getTitle()
  {
    return this.PY.getTitle();
  }
  
  public final void hide()
  {
    this.PY.setVisibility(8);
  }
  
  public final boolean isShowing()
  {
    return this.PY.getVisibility() == 0;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  final void onDestroy()
  {
    this.PY.hz().removeCallbacks(this.Qe);
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
    this.PY.setBackgroundDrawable(paramDrawable);
  }
  
  public final void setCustomView(int paramInt)
  {
    setCustomView(LayoutInflater.from(this.PY.getContext()).inflate(paramInt, this.PY.hz(), false));
  }
  
  public final void setCustomView(View paramView)
  {
    ActionBar.LayoutParams localLayoutParams = new ActionBar.LayoutParams(-2);
    if (paramView != null) {
      paramView.setLayoutParams(localLayoutParams);
    }
    this.PY.setCustomView(paramView);
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
    t.i(this.PY.hz(), paramFloat);
  }
  
  public final void setHomeActionContentDescription(int paramInt)
  {
    this.PY.setNavigationContentDescription(paramInt);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    this.PY.setLogo(paramDrawable);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    this.PY.setWindowTitle(paramCharSequence);
  }
  
  public final void show()
  {
    this.PY.setVisibility(0);
  }
  
  final class a
    implements o.a
  {
    private boolean OV;
    
    a() {}
    
    public final void a(h paramh, boolean paramBoolean)
    {
      if (this.OV) {
        return;
      }
      this.OV = true;
      g.this.PY.dismissPopupMenus();
      if (g.this.Qa != null) {
        g.this.Qa.onPanelClosed(108, paramh);
      }
      this.OV = false;
    }
    
    public final boolean d(h paramh)
    {
      if (g.this.Qa != null)
      {
        g.this.Qa.onMenuOpened(108, paramh);
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
      if (g.this.Qa != null)
      {
        if (!g.this.PY.isOverflowMenuShowing()) {
          break label41;
        }
        g.this.Qa.onPanelClosed(108, paramh);
      }
      label41:
      while (!g.this.Qa.onPreparePanel(0, null, paramh)) {
        return;
      }
      g.this.Qa.onMenuOpened(108, paramh);
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
        return new View(g.this.PY.getContext());
      }
      return super.onCreatePanelView(paramInt);
    }
    
    public final boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
      if ((bool) && (!g.this.PZ))
      {
        g.this.PY.gz();
        g.this.PZ = true;
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.g
 * JD-Core Version:    0.7.0.1
 */