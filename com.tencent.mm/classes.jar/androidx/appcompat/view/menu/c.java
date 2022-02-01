package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.b.a;
import androidx.core.a.a.b;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class c<T>
  extends d<T>
{
  private Map<b, MenuItem> lt;
  private Map<androidx.core.a.a.c, SubMenu> lu;
  final Context mContext;
  
  c(Context paramContext, T paramT)
  {
    super(paramT);
    this.mContext = paramContext;
  }
  
  final SubMenu a(SubMenu paramSubMenu)
  {
    if ((paramSubMenu instanceof androidx.core.a.a.c))
    {
      androidx.core.a.a.c localc = (androidx.core.a.a.c)paramSubMenu;
      if (this.lu == null) {
        this.lu = new a();
      }
      SubMenu localSubMenu = (SubMenu)this.lu.get(localc);
      paramSubMenu = localSubMenu;
      if (localSubMenu == null)
      {
        paramSubMenu = new v(this.mContext, localc);
        this.lu.put(localc, paramSubMenu);
      }
      return paramSubMenu;
    }
    return paramSubMenu;
  }
  
  final void ab(int paramInt)
  {
    if (this.lt == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.lt.keySet().iterator();
      while (localIterator.hasNext()) {
        if (paramInt == ((MenuItem)localIterator.next()).getGroupId()) {
          localIterator.remove();
        }
      }
    }
  }
  
  final void ac(int paramInt)
  {
    if (this.lt == null) {}
    Iterator localIterator;
    do
    {
      return;
      while (!localIterator.hasNext()) {
        localIterator = this.lt.keySet().iterator();
      }
    } while (paramInt != ((MenuItem)localIterator.next()).getItemId());
    localIterator.remove();
  }
  
  final MenuItem b(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof b))
    {
      b localb = (b)paramMenuItem;
      if (this.lt == null) {
        this.lt = new a();
      }
      MenuItem localMenuItem = (MenuItem)this.lt.get(paramMenuItem);
      paramMenuItem = localMenuItem;
      if (localMenuItem == null)
      {
        paramMenuItem = q.a(this.mContext, localb);
        this.lt.put(localb, paramMenuItem);
      }
      return paramMenuItem;
    }
    return paramMenuItem;
  }
  
  final void bT()
  {
    if (this.lt != null) {
      this.lt.clear();
    }
    if (this.lu != null) {
      this.lu.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.menu.c
 * JD-Core Version:    0.7.0.1
 */