package android.support.v4.view;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class b
{
  public a EH;
  public b EI;
  private final Context mContext;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void E(boolean paramBoolean)
  {
    if (this.EH != null) {
      this.EH.F(paramBoolean);
    }
  }
  
  public void a(b paramb)
  {
    if (this.EI != null) {
      new StringBuilder("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ").append(getClass().getSimpleName()).append(" instance while it is still in use somewhere else?");
    }
    this.EI = paramb;
  }
  
  public boolean hasSubMenu()
  {
    return false;
  }
  
  public boolean isVisible()
  {
    return true;
  }
  
  public abstract View onCreateActionView();
  
  public View onCreateActionView(MenuItem paramMenuItem)
  {
    return onCreateActionView();
  }
  
  public boolean onPerformDefaultAction()
  {
    return false;
  }
  
  public void onPrepareSubMenu(SubMenu paramSubMenu) {}
  
  public boolean overridesItemVisibility()
  {
    return false;
  }
  
  public static abstract interface a
  {
    public abstract void F(boolean paramBoolean);
  }
  
  public static abstract interface b
  {
    public abstract void dg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.b
 * JD-Core Version:    0.7.0.1
 */