package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import androidx.appcompat.view.i;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.h.a;
import androidx.appcompat.view.menu.o.a;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.b;
import androidx.appcompat.widget.ad;
import androidx.appcompat.widget.n;
import androidx.core.g.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class g
  extends ActionBar
{
  private final Toolbar.b hA;
  n ht;
  boolean hu;
  Window.Callback hv;
  private boolean hw;
  private boolean hx;
  private ArrayList<Object> hy;
  private final Runnable hz;
  
  g(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback)
  {
    AppMethodBeat.i(238447);
    this.hy = new ArrayList();
    this.hz = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(238423);
        g localg = g.this;
        Menu localMenu = localg.getMenu();
        if ((localMenu instanceof h)) {}
        for (h localh = (h)localMenu;; localh = null)
        {
          if (localh != null) {
            localh.ce();
          }
          try
          {
            localMenu.clear();
            if ((!localg.hv.onCreatePanelMenu(0, localMenu)) || (!localg.hv.onPreparePanel(0, null, localMenu))) {
              localMenu.clear();
            }
            return;
          }
          finally
          {
            if (localh == null) {
              break;
            }
            localh.cf();
            AppMethodBeat.o(238423);
          }
        }
        AppMethodBeat.o(238423);
      }
    };
    this.hA = new Toolbar.b()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(238431);
        boolean bool = g.this.hv.onMenuItemSelected(0, paramAnonymousMenuItem);
        AppMethodBeat.o(238431);
        return bool;
      }
    };
    this.ht = new ad(paramToolbar, false);
    this.hv = new c(paramCallback);
    this.ht.setWindowCallback(this.hv);
    paramToolbar.setOnMenuItemClickListener(this.hA);
    this.ht.setWindowTitle(paramCharSequence);
    AppMethodBeat.o(238447);
  }
  
  private void f(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(238460);
    int i = this.ht.aC();
    this.ht.O(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
    AppMethodBeat.o(238460);
  }
  
  public final void N(int paramInt)
  {
    AppMethodBeat.i(238450);
    setCustomView(LayoutInflater.from(this.ht.getContext()).inflate(paramInt, this.ht.dE(), false));
    AppMethodBeat.o(238450);
  }
  
  @SuppressLint({"WrongConstant"})
  public final void O(int paramInt)
  {
    AppMethodBeat.i(238459);
    f(paramInt, -1);
    AppMethodBeat.o(238459);
  }
  
  public final void a(View paramView, ActionBar.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(238449);
    if (paramView != null) {
      paramView.setLayoutParams(paramLayoutParams);
    }
    this.ht.setCustomView(paramView);
    AppMethodBeat.o(238449);
  }
  
  public final int aC()
  {
    AppMethodBeat.i(238469);
    int i = this.ht.aC();
    AppMethodBeat.o(238469);
    return i;
  }
  
  public final Context aD()
  {
    AppMethodBeat.i(238456);
    Context localContext = this.ht.getContext();
    AppMethodBeat.o(238456);
    return localContext;
  }
  
  public final boolean aE()
  {
    AppMethodBeat.i(238474);
    boolean bool = this.ht.cC();
    AppMethodBeat.o(238474);
    return bool;
  }
  
  public final boolean aF()
  {
    AppMethodBeat.i(238475);
    boolean bool = this.ht.cL();
    AppMethodBeat.o(238475);
    return bool;
  }
  
  public final boolean aG()
  {
    AppMethodBeat.i(238476);
    this.ht.dE().removeCallbacks(this.hz);
    w.a(this.ht.dE(), this.hz);
    AppMethodBeat.o(238476);
    return true;
  }
  
  public final boolean c(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(238478);
    if (paramKeyEvent.getAction() == 1) {
      aE();
    }
    AppMethodBeat.o(238478);
    return true;
  }
  
  public final boolean collapseActionView()
  {
    AppMethodBeat.i(238477);
    if (this.ht.dF())
    {
      this.ht.dG();
      AppMethodBeat.o(238477);
      return true;
    }
    AppMethodBeat.o(238477);
    return false;
  }
  
  public final void e(float paramFloat)
  {
    AppMethodBeat.i(238454);
    w.j(this.ht.dE(), paramFloat);
    AppMethodBeat.o(238454);
  }
  
  public final View getCustomView()
  {
    AppMethodBeat.i(238467);
    View localView = this.ht.getCustomView();
    AppMethodBeat.o(238467);
    return localView;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(238470);
    int i = this.ht.getHeight();
    AppMethodBeat.o(238470);
    return i;
  }
  
  final Menu getMenu()
  {
    AppMethodBeat.i(238484);
    if (!this.hw)
    {
      this.ht.a(new a(), new b());
      this.hw = true;
    }
    Menu localMenu = this.ht.getMenu();
    AppMethodBeat.o(238484);
    return localMenu;
  }
  
  public final CharSequence getTitle()
  {
    AppMethodBeat.i(238468);
    CharSequence localCharSequence = this.ht.getTitle();
    AppMethodBeat.o(238468);
    return localCharSequence;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(238472);
    this.ht.setVisibility(8);
    AppMethodBeat.o(238472);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(238473);
    if (this.ht.getVisibility() == 0)
    {
      AppMethodBeat.o(238473);
      return true;
    }
    AppMethodBeat.o(238473);
    return false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(238457);
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(238457);
  }
  
  final void onDestroy()
  {
    AppMethodBeat.i(238482);
    this.ht.dE().removeCallbacks(this.hz);
    AppMethodBeat.o(238482);
  }
  
  public final boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(238481);
    Menu localMenu = getMenu();
    if (localMenu != null)
    {
      int i;
      if (paramKeyEvent != null)
      {
        i = paramKeyEvent.getDeviceId();
        if (KeyCharacterMap.load(i).getKeyboardType() == 1) {
          break label73;
        }
      }
      label73:
      for (boolean bool = true;; bool = false)
      {
        localMenu.setQwertyMode(bool);
        bool = localMenu.performShortcut(paramInt, paramKeyEvent, 0);
        AppMethodBeat.o(238481);
        return bool;
        i = -1;
        break;
      }
    }
    AppMethodBeat.o(238481);
    return false;
  }
  
  public final void r(boolean paramBoolean)
  {
    AppMethodBeat.i(238461);
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      f(i, 2);
      AppMethodBeat.o(238461);
      return;
    }
  }
  
  public final void s(boolean paramBoolean)
  {
    AppMethodBeat.i(238462);
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      f(i, 4);
      AppMethodBeat.o(238462);
      return;
    }
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(238465);
    this.ht.setBackgroundDrawable(paramDrawable);
    AppMethodBeat.o(238465);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(238448);
    a(paramView, new ActionBar.LayoutParams(-2, -2));
    AppMethodBeat.o(238448);
  }
  
  public final void setIcon(int paramInt)
  {
    AppMethodBeat.i(238451);
    this.ht.setIcon(paramInt);
    AppMethodBeat.o(238451);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    AppMethodBeat.i(238453);
    this.ht.setLogo(paramDrawable);
    AppMethodBeat.o(238453);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(238458);
    this.ht.setWindowTitle(paramCharSequence);
    AppMethodBeat.o(238458);
  }
  
  public final void show()
  {
    AppMethodBeat.i(238471);
    this.ht.setVisibility(0);
    AppMethodBeat.o(238471);
  }
  
  public final void t(boolean paramBoolean)
  {
    AppMethodBeat.i(238463);
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      f(i, 8);
      AppMethodBeat.o(238463);
      return;
    }
  }
  
  public final void u(boolean paramBoolean)
  {
    AppMethodBeat.i(238464);
    if (paramBoolean) {}
    for (int i = 16;; i = 0)
    {
      f(i, 16);
      AppMethodBeat.o(238464);
      return;
    }
  }
  
  public final void v(boolean paramBoolean) {}
  
  public final void w(boolean paramBoolean) {}
  
  public final void x(boolean paramBoolean)
  {
    AppMethodBeat.i(238483);
    if (paramBoolean == this.hx)
    {
      AppMethodBeat.o(238483);
      return;
    }
    this.hx = paramBoolean;
    int j = this.hy.size();
    int i = 0;
    while (i < j)
    {
      this.hy.get(i);
      i += 1;
    }
    AppMethodBeat.o(238483);
  }
  
  final class a
    implements o.a
  {
    private boolean gr;
    
    a() {}
    
    public final void a(h paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(238437);
      if (this.gr)
      {
        AppMethodBeat.o(238437);
        return;
      }
      this.gr = true;
      g.this.ht.cU();
      if (g.this.hv != null) {
        g.this.hv.onPanelClosed(108, paramh);
      }
      this.gr = false;
      AppMethodBeat.o(238437);
    }
    
    public final boolean c(h paramh)
    {
      AppMethodBeat.i(238435);
      if (g.this.hv != null)
      {
        g.this.hv.onMenuOpened(108, paramh);
        AppMethodBeat.o(238435);
        return true;
      }
      AppMethodBeat.o(238435);
      return false;
    }
  }
  
  final class b
    implements h.a
  {
    b() {}
    
    public final void a(h paramh)
    {
      AppMethodBeat.i(238441);
      if (g.this.hv != null)
      {
        if (g.this.ht.cJ())
        {
          g.this.hv.onPanelClosed(108, paramh);
          AppMethodBeat.o(238441);
          return;
        }
        if (g.this.hv.onPreparePanel(0, null, paramh)) {
          g.this.hv.onMenuOpened(108, paramh);
        }
      }
      AppMethodBeat.o(238441);
    }
    
    public final boolean a(h paramh, MenuItem paramMenuItem)
    {
      return false;
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
      AppMethodBeat.i(238446);
      if (paramInt == 0)
      {
        localView = new View(g.this.ht.getContext());
        AppMethodBeat.o(238446);
        return localView;
      }
      View localView = super.onCreatePanelView(paramInt);
      AppMethodBeat.o(238446);
      return localView;
    }
    
    public final boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      AppMethodBeat.i(238445);
      boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
      if ((bool) && (!g.this.hu))
      {
        g.this.ht.cM();
        g.this.hu = true;
      }
      AppMethodBeat.o(238445);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.app.g
 * JD-Core Version:    0.7.0.1
 */