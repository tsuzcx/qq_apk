package android.support.v7.app;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.view.b;
import android.support.v7.view.b.a;
import android.support.v7.view.g;
import android.support.v7.view.i;
import android.support.v7.view.menu.h;
import android.support.v7.widget.ax;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

abstract class e
  extends d
{
  private static boolean OH;
  private static final boolean OI;
  private static final int[] OJ;
  CharSequence BM;
  final Window Nk;
  final Window.Callback OL;
  final Window.Callback OM;
  final c OO;
  boolean OP;
  boolean OQ;
  boolean OR;
  boolean OS;
  boolean OT;
  private boolean OU;
  boolean OV;
  MenuInflater fe;
  ActionBar mActionBar;
  final Context mContext;
  
  static
  {
    if (Build.VERSION.SDK_INT < 21) {}
    for (boolean bool = true;; bool = false)
    {
      OI = bool;
      if ((bool) && (!OH))
      {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
        {
          public final void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
          {
            int j = 0;
            int i = j;
            Object localObject;
            if ((paramAnonymousThrowable instanceof Resources.NotFoundException))
            {
              localObject = paramAnonymousThrowable.getMessage();
              i = j;
              if (localObject != null) {
                if (!((String)localObject).contains("drawable"))
                {
                  i = j;
                  if (!((String)localObject).contains("Drawable")) {}
                }
                else
                {
                  i = 1;
                }
              }
            }
            if (i != 0)
            {
              localObject = new Resources.NotFoundException(paramAnonymousThrowable.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
              ((Throwable)localObject).initCause(paramAnonymousThrowable.getCause());
              ((Throwable)localObject).setStackTrace(paramAnonymousThrowable.getStackTrace());
              this.OW.uncaughtException(paramAnonymousThread, (Throwable)localObject);
              return;
            }
            this.OW.uncaughtException(paramAnonymousThread, paramAnonymousThrowable);
          }
        });
        OH = true;
      }
      OJ = new int[] { 16842836 };
      return;
    }
  }
  
  e(Context paramContext, Window paramWindow, c paramc)
  {
    this.mContext = paramContext;
    this.Nk = paramWindow;
    this.OO = paramc;
    this.OL = this.Nk.getCallback();
    if ((this.OL instanceof b)) {
      throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }
    this.OM = a(this.OL);
    this.Nk.setCallback(this.OM);
    paramContext = ax.a(paramContext, null, OJ);
    paramWindow = paramContext.cr(0);
    if (paramWindow != null) {
      this.Nk.setBackgroundDrawable(paramWindow);
    }
    paramContext.alZ.recycle();
  }
  
  Window.Callback a(Window.Callback paramCallback)
  {
    return new b(paramCallback);
  }
  
  abstract void aS(int paramInt);
  
  abstract boolean aT(int paramInt);
  
  abstract b b(b.a parama);
  
  abstract boolean dispatchKeyEvent(KeyEvent paramKeyEvent);
  
  public boolean eh()
  {
    return false;
  }
  
  abstract void ej();
  
  final Context ek()
  {
    Context localContext = null;
    Object localObject = getSupportActionBar();
    if (localObject != null) {
      localContext = ((ActionBar)localObject).getThemedContext();
    }
    localObject = localContext;
    if (localContext == null) {
      localObject = this.mContext;
    }
    return localObject;
  }
  
  public final a.a getDrawerToggleDelegate()
  {
    return new a();
  }
  
  public final MenuInflater getMenuInflater()
  {
    if (this.fe == null)
    {
      ej();
      if (this.mActionBar == null) {
        break label43;
      }
    }
    label43:
    for (Context localContext = this.mActionBar.getThemedContext();; localContext = this.mContext)
    {
      this.fe = new g(localContext);
      return this.fe;
    }
  }
  
  public final ActionBar getSupportActionBar()
  {
    ej();
    return this.mActionBar;
  }
  
  abstract void i(CharSequence paramCharSequence);
  
  public void onDestroy()
  {
    this.OV = true;
  }
  
  abstract boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent);
  
  public void onSaveInstanceState(Bundle paramBundle) {}
  
  public void onStart()
  {
    this.OU = true;
  }
  
  public void onStop()
  {
    this.OU = false;
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    this.BM = paramCharSequence;
    i(paramCharSequence);
  }
  
  private final class a
    implements a.a
  {
    a() {}
    
    public final void aR(int paramInt)
    {
      ActionBar localActionBar = e.this.getSupportActionBar();
      if (localActionBar != null) {
        localActionBar.setHomeActionContentDescription(paramInt);
      }
    }
  }
  
  class b
    extends i
  {
    b(Window.Callback paramCallback)
    {
      super();
    }
    
    public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
    {
      return (e.this.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
    }
    
    public boolean dispatchKeyShortcutEvent(KeyEvent paramKeyEvent)
    {
      return (super.dispatchKeyShortcutEvent(paramKeyEvent)) || (e.this.onKeyShortcut(paramKeyEvent.getKeyCode(), paramKeyEvent));
    }
    
    public void onContentChanged() {}
    
    public boolean onCreatePanelMenu(int paramInt, Menu paramMenu)
    {
      if ((paramInt == 0) && (!(paramMenu instanceof h))) {
        return false;
      }
      return super.onCreatePanelMenu(paramInt, paramMenu);
    }
    
    public boolean onMenuOpened(int paramInt, Menu paramMenu)
    {
      super.onMenuOpened(paramInt, paramMenu);
      e.this.aT(paramInt);
      return true;
    }
    
    public void onPanelClosed(int paramInt, Menu paramMenu)
    {
      super.onPanelClosed(paramInt, paramMenu);
      e.this.aS(paramInt);
    }
    
    public boolean onPreparePanel(int paramInt, View paramView, Menu paramMenu)
    {
      h localh;
      boolean bool1;
      if ((paramMenu instanceof h))
      {
        localh = (h)paramMenu;
        if ((paramInt != 0) || (localh != null)) {
          break label34;
        }
        bool1 = false;
      }
      label34:
      boolean bool2;
      do
      {
        return bool1;
        localh = null;
        break;
        if (localh != null) {
          localh.VQ = true;
        }
        bool2 = super.onPreparePanel(paramInt, paramView, paramMenu);
        bool1 = bool2;
      } while (localh == null);
      localh.VQ = false;
      return bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.e
 * JD-Core Version:    0.7.0.1
 */