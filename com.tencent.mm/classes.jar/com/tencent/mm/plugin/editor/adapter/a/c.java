package com.tencent.mm.plugin.editor.adapter.a;

import android.util.SparseIntArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.d.f;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;

public final class c
{
  private static final int xwO = d.f.xwq;
  private static final int xwP = d.f.xwo;
  public SparseIntArray xwQ;
  
  public c()
  {
    AppMethodBeat.i(181646);
    this.xwQ = new SparseIntArray();
    this.xwQ.put(1, xwO);
    this.xwQ.put(2, xwP);
    this.xwQ.put(4, xwP);
    this.xwQ.put(6, xwP);
    this.xwQ.put(0, xwP);
    this.xwQ.put(-1, xwP);
    AppMethodBeat.o(181646);
  }
  
  public static a a(int paramInt, View paramView, j paramj)
  {
    AppMethodBeat.i(181647);
    switch (paramInt)
    {
    case 3: 
    case 5: 
    default: 
      AppMethodBeat.o(181647);
      return null;
    case 1: 
      paramView = new f(paramView, paramj);
      AppMethodBeat.o(181647);
      return paramView;
    case 0: 
      paramView = new g(paramView, paramj);
      AppMethodBeat.o(181647);
      return paramView;
    case 2: 
      paramView = new b(paramView, paramj);
      AppMethodBeat.o(181647);
      return paramView;
    case 4: 
      paramView = new i(paramView, paramj);
      AppMethodBeat.o(181647);
      return paramView;
    case 6: 
      paramView = new h(paramView, paramj);
      AppMethodBeat.o(181647);
      return paramView;
    }
    paramView = new e(paramView, paramj);
    AppMethodBeat.o(181647);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.c
 * JD-Core Version:    0.7.0.1
 */