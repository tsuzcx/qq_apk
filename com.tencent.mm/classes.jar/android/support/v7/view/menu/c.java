package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.a.a.b;
import android.support.v4.e.a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Map;

abstract class c<T>
  extends d<T>
{
  Map<b, MenuItem> Vh;
  Map<android.support.v4.a.a.c, SubMenu> Vi;
  final Context mContext;
  
  c(Context paramContext, T paramT)
  {
    super(paramT);
    this.mContext = paramContext;
  }
  
  final SubMenu a(SubMenu paramSubMenu)
  {
    if ((paramSubMenu instanceof android.support.v4.a.a.c))
    {
      android.support.v4.a.a.c localc = (android.support.v4.a.a.c)paramSubMenu;
      if (this.Vi == null) {
        this.Vi = new a();
      }
      SubMenu localSubMenu = (SubMenu)this.Vi.get(localc);
      paramSubMenu = localSubMenu;
      if (localSubMenu == null)
      {
        paramSubMenu = new v(this.mContext, localc);
        this.Vi.put(localc, paramSubMenu);
      }
      return paramSubMenu;
    }
    return paramSubMenu;
  }
  
  final MenuItem b(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof b))
    {
      b localb = (b)paramMenuItem;
      if (this.Vh == null) {
        this.Vh = new a();
      }
      MenuItem localMenuItem = (MenuItem)this.Vh.get(paramMenuItem);
      paramMenuItem = localMenuItem;
      if (localMenuItem == null)
      {
        paramMenuItem = q.a(this.mContext, localb);
        this.Vh.put(localb, paramMenuItem);
      }
      return paramMenuItem;
    }
    return paramMenuItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.c
 * JD-Core Version:    0.7.0.1
 */