package androidx.appcompat.app;

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
import androidx.core.g.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class g
  extends ActionBar
{
  n iq;
  boolean ir;
  Window.Callback is;
  private boolean it;
  private boolean iu;
  private ArrayList<Object> iw;
  private final Runnable ix;
  private final Toolbar.b iy;
  
  g(Toolbar paramToolbar, CharSequence paramCharSequence, Window.Callback paramCallback)
  {
    AppMethodBeat.i(200539);
    this.iw = new ArrayList();
    this.ix = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(200620);
        g localg = g.this;
        Menu localMenu = localg.getMenu();
        if ((localMenu instanceof h)) {}
        for (h localh = (h)localMenu;; localh = null)
        {
          if (localh != null) {
            localh.cX();
          }
          try
          {
            localMenu.clear();
            if ((!localg.is.onCreatePanelMenu(0, localMenu)) || (!localg.is.onPreparePanel(0, null, localMenu))) {
              localMenu.clear();
            }
            return;
          }
          finally
          {
            if (localh == null) {
              break;
            }
            localh.cY();
            AppMethodBeat.o(200620);
          }
        }
        AppMethodBeat.o(200620);
      }
    };
    this.iy = new Toolbar.b()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(200622);
        boolean bool = g.this.is.onMenuItemSelected(0, paramAnonymousMenuItem);
        AppMethodBeat.o(200622);
        return bool;
      }
    };
    this.iq = new ad(paramToolbar, false);
    this.is = new c(paramCallback);
    this.iq.setWindowCallback(this.is);
    paramToolbar.setOnMenuItemClickListener(this.iy);
    this.iq.setWindowTitle(paramCharSequence);
    AppMethodBeat.o(200539);
  }
  
  private void k(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200551);
    int i = this.iq.bu();
    this.iq.M(i & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
    AppMethodBeat.o(200551);
  }
  
  public final void A(boolean paramBoolean) {}
  
  public final void B(boolean paramBoolean)
  {
    AppMethodBeat.i(201002);
    if (paramBoolean == this.iu)
    {
      AppMethodBeat.o(201002);
      return;
    }
    this.iu = paramBoolean;
    int j = this.iw.size();
    int i = 0;
    while (i < j)
    {
      this.iw.get(i);
      i += 1;
    }
    AppMethodBeat.o(201002);
  }
  
  public final void L(int paramInt)
  {
    AppMethodBeat.i(200593);
    setCustomView(LayoutInflater.from(this.iq.getContext()).inflate(paramInt, this.iq.eD(), false));
    AppMethodBeat.o(200593);
  }
  
  public final void M(int paramInt)
  {
    AppMethodBeat.i(200706);
    k(paramInt, -1);
    AppMethodBeat.o(200706);
  }
  
  public final void a(View paramView, ActionBar.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(200582);
    if (paramView != null) {
      paramView.setLayoutParams(paramLayoutParams);
    }
    this.iq.setCustomView(paramView);
    AppMethodBeat.o(200582);
  }
  
  public final int bu()
  {
    AppMethodBeat.i(200830);
    int i = this.iq.bu();
    AppMethodBeat.o(200830);
    return i;
  }
  
  public final Context bw()
  {
    AppMethodBeat.i(200644);
    Context localContext = this.iq.getContext();
    AppMethodBeat.o(200644);
    return localContext;
  }
  
  public final boolean bx()
  {
    AppMethodBeat.i(200894);
    boolean bool = this.iq.dv();
    AppMethodBeat.o(200894);
    return bool;
  }
  
  public final boolean by()
  {
    AppMethodBeat.i(200905);
    boolean bool = this.iq.dE();
    AppMethodBeat.o(200905);
    return bool;
  }
  
  public final boolean bz()
  {
    AppMethodBeat.i(200922);
    this.iq.eD().removeCallbacks(this.ix);
    z.b(this.iq.eD(), this.ix);
    AppMethodBeat.o(200922);
    return true;
  }
  
  public final boolean c(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(200949);
    if (paramKeyEvent.getAction() == 1) {
      bx();
    }
    AppMethodBeat.o(200949);
    return true;
  }
  
  public final boolean collapseActionView()
  {
    AppMethodBeat.i(200939);
    if (this.iq.eE())
    {
      this.iq.eF();
      AppMethodBeat.o(200939);
      return true;
    }
    AppMethodBeat.o(200939);
    return false;
  }
  
  public final void g(float paramFloat)
  {
    AppMethodBeat.i(200632);
    z.k(this.iq.eD(), paramFloat);
    AppMethodBeat.o(200632);
  }
  
  public final View getCustomView()
  {
    AppMethodBeat.i(200805);
    View localView = this.iq.getCustomView();
    AppMethodBeat.o(200805);
    return localView;
  }
  
  public final int getHeight()
  {
    AppMethodBeat.i(200843);
    int i = this.iq.getHeight();
    AppMethodBeat.o(200843);
    return i;
  }
  
  final Menu getMenu()
  {
    AppMethodBeat.i(201017);
    if (!this.it)
    {
      this.iq.a(new a(), new b());
      this.it = true;
    }
    Menu localMenu = this.iq.getMenu();
    AppMethodBeat.o(201017);
    return localMenu;
  }
  
  public final CharSequence getTitle()
  {
    AppMethodBeat.i(200820);
    CharSequence localCharSequence = this.iq.getTitle();
    AppMethodBeat.o(200820);
    return localCharSequence;
  }
  
  public final void hide()
  {
    AppMethodBeat.i(200868);
    this.iq.setVisibility(8);
    AppMethodBeat.o(200868);
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(200882);
    if (this.iq.getVisibility() == 0)
    {
      AppMethodBeat.o(200882);
      return true;
    }
    AppMethodBeat.o(200882);
    return false;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(200678);
    super.onConfigurationChanged(paramConfiguration);
    AppMethodBeat.o(200678);
  }
  
  final void onDestroy()
  {
    AppMethodBeat.i(200977);
    this.iq.eD().removeCallbacks(this.ix);
    AppMethodBeat.o(200977);
  }
  
  public final boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(200963);
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
        AppMethodBeat.o(200963);
        return bool;
        i = -1;
        break;
      }
    }
    AppMethodBeat.o(200963);
    return false;
  }
  
  public final void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(200787);
    this.iq.setBackgroundDrawable(paramDrawable);
    AppMethodBeat.o(200787);
  }
  
  public final void setCustomView(View paramView)
  {
    AppMethodBeat.i(200566);
    a(paramView, new ActionBar.LayoutParams(-2, -2));
    AppMethodBeat.o(200566);
  }
  
  public final void setIcon(int paramInt)
  {
    AppMethodBeat.i(200609);
    this.iq.setIcon(paramInt);
    AppMethodBeat.o(200609);
  }
  
  public final void setLogo(Drawable paramDrawable)
  {
    AppMethodBeat.i(200619);
    this.iq.setLogo(paramDrawable);
    AppMethodBeat.o(200619);
  }
  
  public final void setWindowTitle(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200694);
    this.iq.setWindowTitle(paramCharSequence);
    AppMethodBeat.o(200694);
  }
  
  public final void show()
  {
    AppMethodBeat.i(200856);
    this.iq.setVisibility(0);
    AppMethodBeat.o(200856);
  }
  
  public final void v(boolean paramBoolean)
  {
    AppMethodBeat.i(200719);
    if (paramBoolean) {}
    for (int i = 2;; i = 0)
    {
      k(i, 2);
      AppMethodBeat.o(200719);
      return;
    }
  }
  
  public final void w(boolean paramBoolean)
  {
    AppMethodBeat.i(200735);
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      k(i, 4);
      AppMethodBeat.o(200735);
      return;
    }
  }
  
  public final void x(boolean paramBoolean)
  {
    AppMethodBeat.i(200752);
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      k(i, 8);
      AppMethodBeat.o(200752);
      return;
    }
  }
  
  public final void y(boolean paramBoolean)
  {
    AppMethodBeat.i(200769);
    if (paramBoolean) {}
    for (int i = 16;; i = 0)
    {
      k(i, 16);
      AppMethodBeat.o(200769);
      return;
    }
  }
  
  public final void z(boolean paramBoolean) {}
  
  final class a
    implements o.a
  {
    private boolean hm;
    
    a() {}
    
    public final void a(h paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(200565);
      if (this.hm)
      {
        AppMethodBeat.o(200565);
        return;
      }
      this.hm = true;
      g.this.iq.dN();
      if (g.this.is != null) {
        g.this.is.onPanelClosed(108, paramh);
      }
      this.hm = false;
      AppMethodBeat.o(200565);
    }
    
    public final boolean c(h paramh)
    {
      AppMethodBeat.i(200554);
      if (g.this.is != null)
      {
        g.this.is.onMenuOpened(108, paramh);
        AppMethodBeat.o(200554);
        return true;
      }
      AppMethodBeat.o(200554);
      return false;
    }
  }
  
  final class b
    implements h.a
  {
    b() {}
    
    public final void a(h paramh)
    {
      AppMethodBeat.i(200579);
      if (g.this.is != null)
      {
        if (g.this.iq.dC())
        {
          g.this.is.onPanelClosed(108, paramh);
          AppMethodBeat.o(200579);
          return;
        }
        if (g.this.is.onPreparePanel(0, null, paramh)) {
          g.this.is.onMenuOpened(108, paramh);
        }
      }
      AppMethodBeat.o(200579);
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
      AppMethodBeat.i(200581);
      if (paramInt == 0)
      {
        localView = new View(g.this.iq.getContext());
        AppMethodBeat.o(200581);
        return localView;
      }
      View localView = super.onCreatePanelView(paramInt);
      AppMethodBeat.o(200581);
      return localView;
    }
    
    public final boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      AppMethodBeat.i(200571);
      boolean bool = super.onPreparePanel(paramInt, paramView, paramMenu);
      if ((bool) && (!g.this.ir))
      {
        g.this.iq.dF();
        g.this.ir = true;
      }
      AppMethodBeat.o(200571);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.appcompat.app.g
 * JD-Core Version:    0.7.0.1
 */