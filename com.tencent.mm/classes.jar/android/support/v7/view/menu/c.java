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
  Map<b, MenuItem> afk;
  Map<android.support.v4.a.a.c, SubMenu> afl;
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
      if (this.afl == null) {
        this.afl = new a();
      }
      SubMenu localSubMenu = (SubMenu)this.afl.get(localc);
      paramSubMenu = localSubMenu;
      if (localSubMenu == null)
      {
        paramSubMenu = new v(this.mContext, localc);
        this.afl.put(localc, paramSubMenu);
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
      if (this.afk == null) {
        this.afk = new a();
      }
      MenuItem localMenuItem = (MenuItem)this.afk.get(paramMenuItem);
      paramMenuItem = localMenuItem;
      if (localMenuItem == null)
      {
        paramMenuItem = q.a(this.mContext, localb);
        this.afk.put(localb, paramMenuItem);
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