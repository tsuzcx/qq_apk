package android.support.v4.view;

import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;

public final class h
{
  @Deprecated
  public static MenuItem a(MenuItem paramMenuItem, a parama)
  {
    paramMenuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener()
    {
      public final boolean onMenuItemActionCollapse(MenuItem paramAnonymousMenuItem)
      {
        return this.NS.fe();
      }
      
      public final boolean onMenuItemActionExpand(MenuItem paramAnonymousMenuItem)
      {
        return this.NS.fd();
      }
    });
  }
  
  @Deprecated
  public static abstract interface a
  {
    public abstract boolean fd();
    
    public abstract boolean fe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v4.view.h
 * JD-Core Version:    0.7.0.1
 */