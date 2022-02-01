package androidx.core.g;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class b
{
  public a MD;
  public b MF;
  private final Context mContext;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void X(boolean paramBoolean)
  {
    if (this.MD != null) {
      this.MD.N(paramBoolean);
    }
  }
  
  public void a(b paramb)
  {
    if (this.MF != null) {
      new StringBuilder("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ").append(getClass().getSimpleName()).append(" instance while it is still in use somewhere else?");
    }
    this.MF = paramb;
  }
  
  public void b(SubMenu paramSubMenu) {}
  
  public View c(MenuItem paramMenuItem)
  {
    return cw();
  }
  
  public abstract View cw();
  
  public boolean cx()
  {
    return false;
  }
  
  public boolean cy()
  {
    return false;
  }
  
  public boolean hasSubMenu()
  {
    return false;
  }
  
  public boolean isVisible()
  {
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void N(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void cv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.g.b
 * JD-Core Version:    0.7.0.1
 */