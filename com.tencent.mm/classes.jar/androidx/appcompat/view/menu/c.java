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
  final Context mContext;
  private Map<b, MenuItem> mp;
  private Map<androidx.core.a.a.c, SubMenu> mq;
  
  c(Context paramContext, T paramT)
  {
    super(paramT);
    this.mContext = paramContext;
  }
  
  final void Z(int paramInt)
  {
    if (this.mp == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = this.mp.keySet().iterator();
      while (localIterator.hasNext()) {
        if (paramInt == ((MenuItem)localIterator.next()).getGroupId()) {
          localIterator.remove();
        }
      }
    }
  }
  
  final SubMenu a(SubMenu paramSubMenu)
  {
    if ((paramSubMenu instanceof androidx.core.a.a.c))
    {
      androidx.core.a.a.c localc = (androidx.core.a.a.c)paramSubMenu;
      if (this.mq == null) {
        this.mq = new a();
      }
      SubMenu localSubMenu = (SubMenu)this.mq.get(localc);
      paramSubMenu = localSubMenu;
      if (localSubMenu == null)
      {
        paramSubMenu = new v(this.mContext, localc);
        this.mq.put(localc, paramSubMenu);
      }
      return paramSubMenu;
    }
    return paramSubMenu;
  }
  
  final void aa(int paramInt)
  {
    if (this.mp == null) {}
    Iterator localIterator;
    do
    {
      return;
      while (!localIterator.hasNext()) {
        localIterator = this.mp.keySet().iterator();
      }
    } while (paramInt != ((MenuItem)localIterator.next()).getItemId());
    localIterator.remove();
  }
  
  final MenuItem b(MenuItem paramMenuItem)
  {
    if ((paramMenuItem instanceof b))
    {
      b localb = (b)paramMenuItem;
      if (this.mp == null) {
        this.mp = new a();
      }
      MenuItem localMenuItem = (MenuItem)this.mp.get(paramMenuItem);
      paramMenuItem = localMenuItem;
      if (localMenuItem == null)
      {
        paramMenuItem = q.a(this.mContext, localb);
        this.mp.put(localb, paramMenuItem);
      }
      return paramMenuItem;
    }
    return paramMenuItem;
  }
  
  final void cM()
  {
    if (this.mp != null) {
      this.mp.clear();
    }
    if (this.mq != null) {
      this.mq.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.appcompat.view.menu.c
 * JD-Core Version:    0.7.0.1
 */