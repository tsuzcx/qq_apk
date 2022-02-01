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
    AppMethodBeat.i(239784);
    MenuItem localMenuItem = b(((a)this.lv).add(paramInt));
    AppMethodBeat.o(239784);
    return localMenuItem;
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(239789);
    MenuItem localMenuItem = b(((a)this.lv).add(paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(239789);
    return localMenuItem;
  }
  
  public MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(239786);
    paramCharSequence = b(((a)this.lv).add(paramInt1, paramInt2, paramInt3, paramCharSequence));
    AppMethodBeat.o(239786);
    return paramCharSequence;
  }
  
  public MenuItem add(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(239783);
    paramCharSequence = b(((a)this.lv).add(paramCharSequence));
    AppMethodBeat.o(239783);
    return paramCharSequence;
  }
  
  public int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    AppMethodBeat.i(239799);
    MenuItem[] arrayOfMenuItem = null;
    if (paramArrayOfMenuItem != null) {
      arrayOfMenuItem = new MenuItem[paramArrayOfMenuItem.length];
    }
    paramInt2 = ((a)this.lv).addIntentOptions(paramInt1, paramInt2, paramInt3, paramComponentName, paramArrayOfIntent, paramIntent, paramInt4, arrayOfMenuItem);
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
    AppMethodBeat.o(239799);
    return paramInt2;
  }
  
  public SubMenu addSubMenu(int paramInt)
  {
    AppMethodBeat.i(239793);
    SubMenu localSubMenu = a(((a)this.lv).addSubMenu(paramInt));
    AppMethodBeat.o(239793);
    return localSubMenu;
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(239798);
    SubMenu localSubMenu = a(((a)this.lv).addSubMenu(paramInt1, paramInt2, paramInt3, paramInt4));
    AppMethodBeat.o(239798);
    return localSubMenu;
  }
  
  public SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(239795);
    paramCharSequence = a(((a)this.lv).addSubMenu(paramInt1, paramInt2, paramInt3, paramCharSequence));
    AppMethodBeat.o(239795);
    return paramCharSequence;
  }
  
  public SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(239791);
    paramCharSequence = a(((a)this.lv).addSubMenu(paramCharSequence));
    AppMethodBeat.o(239791);
    return paramCharSequence;
  }
  
  public void clear()
  {
    AppMethodBeat.i(239804);
    bT();
    ((a)this.lv).clear();
    AppMethodBeat.o(239804);
  }
  
  public void close()
  {
    AppMethodBeat.i(239825);
    ((a)this.lv).close();
    AppMethodBeat.o(239825);
  }
  
  public MenuItem findItem(int paramInt)
  {
    AppMethodBeat.i(239818);
    MenuItem localMenuItem = b(((a)this.lv).findItem(paramInt));
    AppMethodBeat.o(239818);
    return localMenuItem;
  }
  
  public MenuItem getItem(int paramInt)
  {
    AppMethodBeat.i(239823);
    MenuItem localMenuItem = b(((a)this.lv).getItem(paramInt));
    AppMethodBeat.o(239823);
    return localMenuItem;
  }
  
  public boolean hasVisibleItems()
  {
    AppMethodBeat.i(239816);
    boolean bool = ((a)this.lv).hasVisibleItems();
    AppMethodBeat.o(239816);
    return bool;
  }
  
  public boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(239830);
    boolean bool = ((a)this.lv).isShortcutKey(paramInt, paramKeyEvent);
    AppMethodBeat.o(239830);
    return bool;
  }
  
  public boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(239832);
    boolean bool = ((a)this.lv).performIdentifierAction(paramInt1, paramInt2);
    AppMethodBeat.o(239832);
    return bool;
  }
  
  public boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    AppMethodBeat.i(239827);
    boolean bool = ((a)this.lv).performShortcut(paramInt1, paramKeyEvent, paramInt2);
    AppMethodBeat.o(239827);
    return bool;
  }
  
  public void removeGroup(int paramInt)
  {
    AppMethodBeat.i(239802);
    ab(paramInt);
    ((a)this.lv).removeGroup(paramInt);
    AppMethodBeat.o(239802);
  }
  
  public void removeItem(int paramInt)
  {
    AppMethodBeat.i(239800);
    ac(paramInt);
    ((a)this.lv).removeItem(paramInt);
    AppMethodBeat.o(239800);
  }
  
  public void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(239806);
    ((a)this.lv).setGroupCheckable(paramInt, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(239806);
  }
  
  public void setGroupEnabled(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(239814);
    ((a)this.lv).setGroupEnabled(paramInt, paramBoolean);
    AppMethodBeat.o(239814);
  }
  
  public void setGroupVisible(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(239809);
    ((a)this.lv).setGroupVisible(paramInt, paramBoolean);
    AppMethodBeat.o(239809);
  }
  
  public void setQwertyMode(boolean paramBoolean)
  {
    AppMethodBeat.i(239835);
    ((a)this.lv).setQwertyMode(paramBoolean);
    AppMethodBeat.o(239835);
  }
  
  public int size()
  {
    AppMethodBeat.i(239821);
    int i = ((a)this.lv).size();
    AppMethodBeat.o(239821);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.view.menu.r
 * JD-Core Version:    0.7.0.1
 */