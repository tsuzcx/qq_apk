package com.google.android.material.internal;

import android.content.Context;
import android.view.SubMenu;
import androidx.appcompat.view.menu.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
  extends androidx.appcompat.view.menu.h
{
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  public final SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(209275);
    paramCharSequence = (j)a(paramInt1, paramInt2, paramInt3, paramCharSequence);
    h localh = new h(this.mContext, this, paramCharSequence);
    paramCharSequence.b(localh);
    AppMethodBeat.o(209275);
    return localh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.internal.f
 * JD-Core Version:    0.7.0.1
 */