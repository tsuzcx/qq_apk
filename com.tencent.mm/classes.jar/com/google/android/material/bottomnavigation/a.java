package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends h
{
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  public final MenuItem a(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(209644);
    if (size() + 1 > 5)
    {
      paramCharSequence = new IllegalArgumentException("Maximum number of items supported by BottomNavigationView is 5. Limit can be checked with BottomNavigationView#getMaxItemCount()");
      AppMethodBeat.o(209644);
      throw paramCharSequence;
    }
    cX();
    paramCharSequence = super.a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    if ((paramCharSequence instanceof j)) {
      ((j)paramCharSequence).M(true);
    }
    cY();
    AppMethodBeat.o(209644);
    return paramCharSequence;
  }
  
  public final SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(209631);
    paramCharSequence = new UnsupportedOperationException("BottomNavigationView does not support submenus");
    AppMethodBeat.o(209631);
    throw paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.bottomnavigation.a
 * JD-Core Version:    0.7.0.1
 */