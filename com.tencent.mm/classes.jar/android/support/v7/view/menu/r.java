package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.a.a.a;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class r
  extends c<a>
  implements Menu
{
  r(Context paramContext, a parama)
  {
    super(paramContext, parama);
  }
  
  public MenuItem add(int paramInt)
  {
    return b(((a)this.aeZ).add(paramInt));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return b(((a)this.aeZ).add(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return b(((a)this.aeZ).add(paramInt1, paramInt2, paramInt3, paramCharSequence));
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    return b(((a)this.aeZ).add(paramCharSequence));
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    MenuItem[] arrayOfMenuItem = null;
    if (paramArrayOfMenuItem != null) {
      arrayOfMenuItem = new MenuItem[paramArrayOfMenuItem.length];
    }
    paramInt2 = ((a)this.aeZ).addIntentOptions(paramInt1, paramInt2, paramInt3, paramComponentName, paramArrayOfIntent, paramIntent, paramInt4, arrayOfMenuItem);
    if (arrayOfMenuItem != null)
    {
      paramInt1 = 0;
      paramInt3 = arrayOfMenuItem.length;
      while (paramInt1 < paramInt3)
      {
        paramArrayOfMenuItem[paramInt1] = b(arrayOfMenuItem[paramInt1]);
        paramInt1 += 1;
      }
    }
    return paramInt2;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    return a(((a)this.aeZ).addSubMenu(paramInt));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return a(((a)this.aeZ).addSubMenu(paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return a(((a)this.aeZ).addSubMenu(paramInt1, paramInt2, paramInt3, paramCharSequence));
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return a(((a)this.aeZ).addSubMenu(paramCharSequence));
  }
  
  public void clear()
  {
    if (this.aeX != null) {
      this.aeX.clear();
    }
    if (this.aeY != null) {
      this.aeY.clear();
    }
    ((a)this.aeZ).clear();
  }
  
  public void close()
  {
    ((a)this.aeZ).close();
  }
  
  public MenuItem findItem(int paramInt)
  {
    return b(((a)this.aeZ).findItem(paramInt));
  }
  
  public MenuItem getItem(int paramInt)
  {
    return b(((a)this.aeZ).getItem(paramInt));
  }
  
  public boolean hasVisibleItems()
  {
    return ((a)this.aeZ).hasVisibleItems();
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return ((a)this.aeZ).isShortcutKey(paramInt, paramKeyEvent);
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return ((a)this.aeZ).performIdentifierAction(paramInt1, paramInt2);
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    return ((a)this.aeZ).performShortcut(paramInt1, paramKeyEvent, paramInt2);
  }
  
  public void removeGroup(int paramInt)
  {
    if (this.aeX != null)
    {
      Iterator localIterator = this.aeX.keySet().iterator();
      while (localIterator.hasNext()) {
        if (paramInt == ((MenuItem)localIterator.next()).getGroupId()) {
          localIterator.remove();
        }
      }
    }
    ((a)this.aeZ).removeGroup(paramInt);
  }
  
  public void removeItem(int paramInt)
  {
    if (this.aeX != null)
    {
      Iterator localIterator = this.aeX.keySet().iterator();
      while (localIterator.hasNext()) {
        if (paramInt == ((MenuItem)localIterator.next()).getItemId()) {
          localIterator.remove();
        }
      }
    }
    ((a)this.aeZ).removeItem(paramInt);
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    ((a)this.aeZ).setGroupCheckable(paramInt, paramBoolean1, paramBoolean2);
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    ((a)this.aeZ).setGroupEnabled(paramInt, paramBoolean);
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    ((a)this.aeZ).setGroupVisible(paramInt, paramBoolean);
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    ((a)this.aeZ).setQwertyMode(paramBoolean);
  }
  
  public int size()
  {
    return ((a)this.aeZ).size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.view.menu.r
 * JD-Core Version:    0.7.0.1
 */