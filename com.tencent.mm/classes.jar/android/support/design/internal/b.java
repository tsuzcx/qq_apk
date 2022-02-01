package android.support.design.internal;

import android.content.Context;
import android.support.v7.view.menu.h;
import android.support.v7.view.menu.j;
import android.view.SubMenu;

public final class b
  extends h
{
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public final SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    paramCharSequence = (j)a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    d locald = new d(this.mContext, this, paramCharSequence);
    paramCharSequence.b(locald);
    return locald;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.internal.b
 * JD-Core Version:    0.7.0.1
 */