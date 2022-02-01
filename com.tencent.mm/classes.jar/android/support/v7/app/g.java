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
  u WX;
  boolean WY;
  Window.Callback WZ;
  private boolean Xa;
  private boolean Xb;
  private ArrayList<Object> Xc = new ArrayList();
  private final Runnable Xd = new Runnable()
  {
    public final void run()
    {
      g localg = g.this;
      Menu localMenu = localg.getMenu();
      if ((localMenu instanceof h)) {}
      for (localh = (h)localMenu;; localh = null)
      {
        if (localh != null) {
          localh.ht();
        }
        try
        {
          localMenu.clear();
          if ((!localg.WZ.onCreatePanelMenu(0, localMenu)) || (!localg.WZ.onPreparePanel(0, null, localMenu))) {
            localMenu.clear();
          }
          return;
        }
        finally
        {
          if (localh == null) {
            break;
          }
          localh.hu();
        }
      }
    }
  };
  private final Toolbar.b Xe = new Toolbar.b()
  {
    public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      return g.this.WZ.onMenuItemSelected(0, paramAnonymousMenuItem);
    }
  };
  
  g(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback)
  {
    this.WX = new ba(paramToolbar, false);
    this.WZ = new c(paramCallback);
    this.WX.setWindowCallback(this.WZ);
    paramToolbar.setOnMenuItemClickListener(this.Xe);
    this.WX.setWindowTitle(paramCharSequence);
  }
  
  private void setDisplayOptions(int paramInt1, int paramInt2)
  {
    int i = this.WX.getDisplayOptions();
    this.WX.setDisplayOptions(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public final void Q(boolean paramBoolean) {}
  
  public final void R(boolean paramBoolean) {}
  
  public final void S(boolean paramBoolean)
  {
    if (paramBoolean == this.Xb) {}
    for (;;)
    {
      return;
      this.Xb = paramBoolean;
      int j = this.Xc.size();
      int i = 0;
      while (i < j)
      {
        this.Xc.get(i);
        i += 1;
      }
    }
  }
  
  public final boolean b(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 1) {
      fP();
    }
    return true;
  }
  
  public final boolean collapseActionView()
  {
    if (this.WX.hasExpandedActionView())
    {
      this.WX.collapseActionView();
      return true;
    }
    return false;
  }
  
  public final void fK()
  {
    this.WX.setIcon(2131234429);
  }
  
  public final void fL()
  {
    setDisplayOptions(0, 2);
  }
  
  public final void fM()
  {
    setDisplayOptions(0, 8);
  }
  
  public final void fN()
  {
    setDisplayOptions(16, 16);
  }
  
  public final boolean fP()
  {
    return this.WX.showOverflowMenu();
  }
  
  public final boolean fQ()
  {
    return this.WX.hideOverflowMenu();
  }
  
  public final boolean fR()
  {
    this.WX.iV().removeCallbacks(this.Xd);
    t.b(this.WX.iV(), this.Xd);
    return true;
  }
  
  public final View getCustomView()
  {
    return this.WX.getCustomView();
  }
  
  public final int getDisplayOptions()
  {
    return this.WX.getDisplayOptions();
  }
  
  public final int getHeight()
  {
    return this.WX.getHeight();
  }
  
  final Menu getMenu()
  {
    if (!this.Xa)
    {
      this.WX.a(new a(), new b());
      this.Xa = true;
    }
    return this.WX.getMenu();
  }
  
  public final Context getThemedContext()
  {
    return this.WX.getContext();
  }
  
  public final CharSequence getTitle()
  {
    return this.WX.getTitle();
  }
  
  public final void hide()
  {
    this.WX.setVisibility(8);
  }
  
  public final boolean isShowing()
  {
    return this.WX.getVisibility() == 0;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  final void onDestroy()
  {
    this.WX.iV().removeCallbacks(this.Xd);
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
    this.WX.setBackgroundDrawable(paramDrawable);
  }
  
  public final void setCustomView(int paramInt)
  {
    setCustomView(LayoutInflater.from(this.WX.getContext()).inflate(paramInt, this.WX.iV(), false));
  }
  
  public final void setCustomView(View paramView)
  {
    ActionBar.LayoutParams localLayoutParams = new ActionBar.LayoutParams(-2);
    if (paramView != null) {
      paramView.setLayoutParams(localLayoutParams);
    }
    this.WX.setCustomView(paramView);
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
    t.k(this.WX.iV(), paramFloat);
  }
  
  public final void setHomeActionContentDescription(int paramInt)
  {
    this.WX.setNavigationContentDescription(paramInt);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    this.WX.setLogo(paramDrawable);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    this.WX.setWindowTitle(paramCharSequence);
  }
  
  public final void show()
  {
    this.WX.setVisibility(0);
  }
  
  final class a
    implements o.a
  {
    private boolean VZ;
    
    a() {}
    
    public final void a(h paramh, boolean paramBoolean)
    {
      if (this.VZ) {
        return;
      }
      this.VZ = true;
      g.this.WX.dismissPopupMenus();
      if (g.this.WZ != null) {
        g.this.WZ.onPanelClosed(108, paramh);
      }
      this.VZ = false;
    }
    
    public final boolean d(h paramh)
    {
      if (g.this.WZ != null)
      {
        g.this.WZ.onMenuOpened(108, paramh);
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
      if (g.this.WZ != null)
      {
        if (!g.this.WX.isOverflowMenuShowing()) {
          break label41;
        }
        g.this.WZ.onPanelClosed(108, paramh);
      }
      label41:
      while (!g.this.WZ.onPreparePanel(0, null, paramh)) {
        return;
      }
      g.this.WZ.onMenuOpened(108, paramh);
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
        return new View(g.this.WX.getContext());
      }
      return super.onCreatePanelView(paramInt);
    }
    
    public final boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
      if ((bool) && (!g.this.WY))
      {
        g.this.WX.hU();
        g.this.WY = true;
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.g
 * JD-Core Version:    0.7.0.1
 */