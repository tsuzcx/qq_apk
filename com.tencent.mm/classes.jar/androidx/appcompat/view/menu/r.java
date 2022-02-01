package androidx.appcompat.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.core.a.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

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
    AppMethodBeat.i(200908);
    MenuItem localMenuItem = b(((a)this.mr).add(paramInt));
    AppMethodBeat.o(200908);
    return localMenuItem;
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(200928);
    MenuItem localMenuItem = b(((a)this.mr).add(paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(200928);
    return localMenuItem;
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200918);
    paramCharSequence = b(((a)this.mr).add(paramInt1, paramInt2, paramInt3, paramCharSequence));
    AppMethodBeat.o(200918);
    return paramCharSequence;
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200900);
    paramCharSequence = b(((a)this.mr).add(paramCharSequence));
    AppMethodBeat.o(200900);
    return paramCharSequence;
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    AppMethodBeat.i(200987);
    MenuItem[] arrayOfMenuItem = null;
    if (paramArrayOfMenuItem != null) {
      arrayOfMenuItem = new MenuItem[paramArrayOfMenuItem.length];
    }
    paramInt2 = ((a)this.mr).addIntentOptions(paramInt1, paramInt2, paramInt3, paramComponentName, paramArrayOfIntent, paramIntent, paramInt4, arrayOfMenuItem);
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
    AppMethodBeat.o(200987);
    return paramInt2;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    AppMethodBeat.i(200947);
    SubMenu localSubMenu = a(((a)this.mr).addSubMenu(paramInt));
    AppMethodBeat.o(200947);
    return localSubMenu;
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(200973);
    SubMenu localSubMenu = a(((a)this.mr).addSubMenu(paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(200973);
    return localSubMenu;
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200965);
    paramCharSequence = a(((a)this.mr).addSubMenu(paramInt1, paramInt2, paramInt3, paramCharSequence));
    AppMethodBeat.o(200965);
    return paramCharSequence;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(200937);
    paramCharSequence = a(((a)this.mr).addSubMenu(paramCharSequence));
    AppMethodBeat.o(200937);
    return paramCharSequence;
  }
  
  public void clear()
  {
    AppMethodBeat.i(201015);
    cM();
    ((a)this.mr).clear();
    AppMethodBeat.o(201015);
  }
  
  public void close()
  {
    AppMethodBeat.i(201070);
    ((a)this.mr).close();
    AppMethodBeat.o(201070);
  }
  
  public MenuItem findItem(int paramInt)
  {
    AppMethodBeat.i(201048);
    MenuItem localMenuItem = b(((a)this.mr).findItem(paramInt));
    AppMethodBeat.o(201048);
    return localMenuItem;
  }
  
  public MenuItem getItem(int paramInt)
  {
    AppMethodBeat.i(201065);
    MenuItem localMenuItem = b(((a)this.mr).getItem(paramInt));
    AppMethodBeat.o(201065);
    return localMenuItem;
  }
  
  public boolean hasVisibleItems()
  {
    AppMethodBeat.i(201043);
    boolean bool = ((a)this.mr).hasVisibleItems();
    AppMethodBeat.o(201043);
    return bool;
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(201080);
    boolean bool = ((a)this.mr).isShortcutKey(paramInt, paramKeyEvent);
    AppMethodBeat.o(201080);
    return bool;
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(201087);
    boolean bool = ((a)this.mr).performIdentifierAction(paramInt1, paramInt2);
    AppMethodBeat.o(201087);
    return bool;
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    AppMethodBeat.i(201075);
    boolean bool = ((a)this.mr).performShortcut(paramInt1, paramKeyEvent, paramInt2);
    AppMethodBeat.o(201075);
    return bool;
  }
  
  public void removeGroup(int paramInt)
  {
    AppMethodBeat.i(201004);
    Z(paramInt);
    ((a)this.mr).removeGroup(paramInt);
    AppMethodBeat.o(201004);
  }
  
  public void removeItem(int paramInt)
  {
    AppMethodBeat.i(200995);
    aa(paramInt);
    ((a)this.mr).removeItem(paramInt);
    AppMethodBeat.o(200995);
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(201025);
    ((a)this.mr).setGroupCheckable(paramInt, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(201025);
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(201037);
    ((a)this.mr).setGroupEnabled(paramInt, paramBoolean);
    AppMethodBeat.o(201037);
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(201031);
    ((a)this.mr).setGroupVisible(paramInt, paramBoolean);
    AppMethodBeat.o(201031);
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    AppMethodBeat.i(201092);
    ((a)this.mr).setQwertyMode(paramBoolean);
    AppMethodBeat.o(201092);
  }
  
  public int size()
  {
    AppMethodBeat.i(201058);
    int i = ((a)this.mr).size();
    AppMethodBeat.o(201058);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     androidx.appcompat.view.menu.r
 * JD-Core Version:    0.7.0.1
 */