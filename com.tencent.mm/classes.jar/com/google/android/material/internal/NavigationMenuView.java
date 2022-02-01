package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.view.menu.h;
import androidx.appcompat.view.menu.p;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class NavigationMenuView
  extends RecyclerView
  implements p
{
  public NavigationMenuView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NavigationMenuView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(209326);
    setLayoutManager(new LinearLayoutManager(1, false));
    AppMethodBeat.o(209326);
  }
  
  public final void g(h paramh) {}
  
  public int getWindowAnimations()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.internal.NavigationMenuView
 * JD-Core Version:    0.7.0.1
 */