package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.a.a.c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

final class v
  extends r
  implements SubMenu
{
  v(Context paramContext, c paramc)
  {
    super(paramContext, paramc);
  }
  
  public final void clearHeader()
  {
    ((c)this.aeZ).clearHeader();
  }
  
  public final MenuItem getItem()
  {
    return b(((c)this.aeZ).getItem());
  }
  
  public final SubMenu setHeaderIcon(int paramInt)
  {
    ((c)this.aeZ).setHeaderIcon(paramInt);
    return this;
  }
  
  public final SubMenu setHeaderIcon(Drawable paramDrawable)
  {
    ((c)this.aeZ).setHeaderIcon(paramDrawable);
    return this;
  }
  
  public final SubMenu setHeaderTitle(int paramInt)
  {
    ((c)this.aeZ).setHeaderTitle(paramInt);
    return this;
  }
  
  public final SubMenu setHeaderTitle(CharSequence paramCharSequence)
  {
    ((c)this.aeZ).setHeaderTitle(paramCharSequence);
    return this;
  }
  
  public final SubMenu setHeaderView(View paramView)
  {
    ((c)this.aeZ).setHeaderView(paramView);
    return this;
  }
  
  public final SubMenu setIcon(int paramInt)
  {
    ((c)this.aeZ).setIcon(paramInt);
    return this;
  }
  
  public final SubMenu setIcon(Drawable paramDrawable)
  {
    ((c)this.aeZ).setIcon(paramDrawable);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.v
 * JD-Core Version:    0.7.0.1
 */