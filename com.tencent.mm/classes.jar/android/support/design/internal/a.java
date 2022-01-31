package android.support.design.internal;

import android.content.Context;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.view.MenuItem;
import android.view.SubMenu;

public final class a
  extends h
{
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  public final MenuItem a(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    if (size() + 1 > 5) {
      throw new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
    }
    fX();
    paramCharSequence = super.a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    if ((paramCharSequence instanceof j)) {
      ((j)paramCharSequence).W(true);
    }
    fY();
    return paramCharSequence;
  }
  
  public final SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("BottomNavigationView does not support submenus");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     android.support.design.internal.a
 * JD-Core Version:    0.7.0.1
 */