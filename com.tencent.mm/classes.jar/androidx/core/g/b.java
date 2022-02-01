package androidx.core.g;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class b
{
  private a bsH;
  private b.b bsI;
  private final Context mContext;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final void a(a parama)
  {
    this.bsH = parama;
  }
  
  public void a(b.b paramb)
  {
    if (this.bsI != null) {
      new StringBuilder("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ").append(getClass().getSimpleName()).append(" instance while it is still in use somewhere else?");
    }
    this.bsI = paramb;
  }
  
  public final void aD(boolean paramBoolean)
  {
    if (this.bsH != null) {
      this.bsH.R(paramBoolean);
    }
  }
  
  public void b(SubMenu paramSubMenu) {}
  
  public View c(MenuItem paramMenuItem)
  {
    return dp();
  }
  
  public abstract View dp();
  
  public boolean dq()
  {
    return false;
  }
  
  public boolean dr()
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
  
  public final void reset()
  {
    this.bsI = null;
    this.bsH = null;
  }
  
  public static abstract interface a
  {
    public abstract void R(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.g.b
 * JD-Core Version:    0.7.0.1
 */