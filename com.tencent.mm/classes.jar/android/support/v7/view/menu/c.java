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
  Map<b, MenuItem> aeX;
  Map<android.support.v4.a.a.c, SubMenu> aeY;
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
      if (this.aeY == null) {
        this.aeY = new a();
      }
      SubMenu localSubMenu = (SubMenu)this.aeY.get(localc);
      paramSubMenu = localSubMenu;
      if (localSubMenu == null)
      {
        paramSubMenu = new v(this.mContext, localc);
        this.aeY.put(localc, paramSubMenu);
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
      if (this.aeX == null) {
        this.aeX = new a();
      }
      MenuItem localMenuItem = (MenuItem)this.aeX.get(paramMenuItem);
      paramMenuItem = localMenuItem;
      if (localMenuItem == null)
      {
        paramMenuItem = q.a(this.mContext, localb);
        this.aeX.put(localb, paramMenuItem);
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