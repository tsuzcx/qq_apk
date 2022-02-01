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
  u ZH;
  boolean ZI;
  Window.Callback ZJ;
  private boolean ZK;
  private boolean ZL;
  private ArrayList<Object> ZM = new ArrayList();
  private final Runnable ZN = new Runnable()
  {
    public final void run()
    {
      g localg = g.this;
      Menu localMenu = localg.getMenu();
      if ((localMenu instanceof h)) {}
      for (localh = (h)localMenu;; localh = null)
      {
        if (localh != null) {
          localh.hR();
        }
        try
        {
          localMenu.clear();
          if ((!localg.ZJ.onCreatePanelMenu(0, localMenu)) || (!localg.ZJ.onPreparePanel(0, null, localMenu))) {
            localMenu.clear();
          }
          return;
        }
        finally
        {
          if (localh == null) {
            break;
          }
          localh.hS();
        }
      }
    }
  };
  private final Toolbar.b ZO = new Toolbar.b()
  {
    public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
    {
      return g.this.ZJ.onMenuItemSelected(0, paramAnonymousMenuItem);
    }
  };
  
  g(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback)
  {
    this.ZH = new ba(paramToolbar, false);
    this.ZJ = new c(paramCallback);
    this.ZH.setWindowCallback(this.ZJ);
    paramToolbar.setOnMenuItemClickListener(this.ZO);
    this.ZH.setWindowTitle(paramCharSequence);
  }
  
  private void setDisplayOptions(int paramInt1, int paramInt2)
  {
    int i = this.ZH.getDisplayOptions();
    this.ZH.setDisplayOptions(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public final void Q(boolean paramBoolean) {}
  
  public final void R(boolean paramBoolean) {}
  
  public final void S(boolean paramBoolean)
  {
    if (paramBoolean == this.ZL) {}
    for (;;)
    {
      return;
      this.ZL = paramBoolean;
      int j = this.ZM.size();
      int i = 0;
      while (i < j)
      {
        this.ZM.get(i);
        i += 1;
      }
    }
  }
  
  public final boolean b(KeyEvent paramKeyEvent)
  {
    if (paramKeyEvent.getAction() == 1) {
      gp();
    }
    return true;
  }
  
  public final boolean collapseActionView()
  {
    if (this.ZH.hasExpandedActionView())
    {
      this.ZH.collapseActionView();
      return true;
    }
    return false;
  }
  
  public final View getCustomView()
  {
    return this.ZH.getCustomView();
  }
  
  public final int getDisplayOptions()
  {
    return this.ZH.getDisplayOptions();
  }
  
  public final int getHeight()
  {
    return this.ZH.getHeight();
  }
  
  final Menu getMenu()
  {
    if (!this.ZK)
    {
      this.ZH.a(new a(), new b());
      this.ZK = true;
    }
    return this.ZH.getMenu();
  }
  
  public final Context getThemedContext()
  {
    return this.ZH.getContext();
  }
  
  public final CharSequence getTitle()
  {
    return this.ZH.getTitle();
  }
  
  public final void gk()
  {
    this.ZH.setIcon(2131234429);
  }
  
  public final void gl()
  {
    setDisplayOptions(0, 2);
  }
  
  public final void gm()
  {
    setDisplayOptions(0, 8);
  }
  
  public final void gn()
  {
    setDisplayOptions(16, 16);
  }
  
  public final boolean gp()
  {
    return this.ZH.showOverflowMenu();
  }
  
  public final boolean gq()
  {
    return this.ZH.hideOverflowMenu();
  }
  
  public final boolean gr()
  {
    this.ZH.jt().removeCallbacks(this.ZN);
    t.b(this.ZH.jt(), this.ZN);
    return true;
  }
  
  public final void hide()
  {
    this.ZH.setVisibility(8);
  }
  
  public final boolean isShowing()
  {
    return this.ZH.getVisibility() == 0;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
  }
  
  final void onDestroy()
  {
    this.ZH.jt().removeCallbacks(this.ZN);
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
    this.ZH.setBackgroundDrawable(paramDrawable);
  }
  
  public final void setCustomView(int paramInt)
  {
    setCustomView(LayoutInflater.from(this.ZH.getContext()).inflate(paramInt, this.ZH.jt(), false));
  }
  
  public final void setCustomView(View paramView)
  {
    ActionBar.LayoutParams localLayoutParams = new ActionBar.LayoutParams(-2);
    if (paramView != null) {
      paramView.setLayoutParams(localLayoutParams);
    }
    this.ZH.setCustomView(paramView);
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
    t.k(this.ZH.jt(), paramFloat);
  }
  
  public final void setHomeActionContentDescription(int paramInt)
  {
    this.ZH.setNavigationContentDescription(paramInt);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    this.ZH.setLogo(paramDrawable);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    this.ZH.setWindowTitle(paramCharSequence);
  }
  
  public final void show()
  {
    this.ZH.setVisibility(0);
  }
  
  final class a
    implements o.a
  {
    private boolean YJ;
    
    a() {}
    
    public final void a(h paramh, boolean paramBoolean)
    {
      if (this.YJ) {
        return;
      }
      this.YJ = true;
      g.this.ZH.dismissPopupMenus();
      if (g.this.ZJ != null) {
        g.this.ZJ.onPanelClosed(108, paramh);
      }
      this.YJ = false;
    }
    
    public final boolean d(h paramh)
    {
      if (g.this.ZJ != null)
      {
        g.this.ZJ.onMenuOpened(108, paramh);
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
      if (g.this.ZJ != null)
      {
        if (!g.this.ZH.isOverflowMenuShowing()) {
          break label41;
        }
        g.this.ZJ.onPanelClosed(108, paramh);
      }
      label41:
      while (!g.this.ZJ.onPreparePanel(0, null, paramh)) {
        return;
      }
      g.this.ZJ.onMenuOpened(108, paramh);
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
        return new View(g.this.ZH.getContext());
      }
      return super.onCreatePanelView(paramInt);
    }
    
    public final boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
      if ((bool) && (!g.this.ZI))
      {
        g.this.ZH.iu();
        g.this.ZI = true;
      }
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.g
 * JD-Core Version:    0.7.0.1
 */