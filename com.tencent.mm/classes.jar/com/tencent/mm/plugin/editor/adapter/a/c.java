package com.tencent.mm.plugin.editor.adapter.a;

import android.util.SparseIntArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;

public final class c
{
  private static final int qOn = 2131493896;
  private static final int qOo = 2131493889;
  public SparseIntArray qOp;
  
  public c()
  {
    AppMethodBeat.i(181646);
    this.qOp = new SparseIntArray();
    this.qOp.put(1, qOn);
    this.qOp.put(2, qOo);
    this.qOp.put(4, qOo);
    this.qOp.put(6, qOo);
    this.qOp.put(0, qOo);
    this.qOp.put(-1, qOo);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.c
 * JD-Core Version:    0.7.0.1
 */