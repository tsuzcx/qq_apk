package com.tencent.mm.plugin.editor.adapter;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class CollectEditorLinearLayoutManager
  extends LinearLayoutManager
{
  private final int sNb;
  public int xwJ;
  public boolean xwK;
  
  public CollectEditorLinearLayoutManager()
  {
    AppMethodBeat.i(181634);
    this.sNb = com.tencent.mm.compatible.util.j.getKeyBordHeightPx(MMApplicationContext.getContext(), true);
    this.xwJ = -1;
    this.xwK = false;
    AppMethodBeat.o(181634);
  }
  
  public CollectEditorLinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    AppMethodBeat.i(181635);
    this.sNb = com.tencent.mm.compatible.util.j.getKeyBordHeightPx(MMApplicationContext.getContext(), true);
    this.xwJ = -1;
    this.xwK = false;
    AppMethodBeat.o(181635);
  }
  
  public final int b(RecyclerView.s params)
  {
    if (this.xwJ > 0) {
      return this.xwJ;
    }
    return 900;
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(270824);
    try
    {
      super.onLayoutChildren(paramn, params);
      AppMethodBeat.o(270824);
      return;
    }
    catch (Exception paramn)
    {
      Log.printErrStackTrace("MicroMsg.CollectEditorLinearLayoutManager", paramn, "", new Object[0]);
      AppMethodBeat.o(270824);
    }
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    int j = 1;
    AppMethodBeat.i(270823);
    if (!this.xwK)
    {
      paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
      AppMethodBeat.o(270823);
      return paramInt;
    }
    int i;
    if (paramInt < 0) {
      if (com.tencent.mm.plugin.editor.model.nativenote.manager.j.cg(49.0F) <= Math.abs(paramInt)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (paramInt > 0) {
        if (this.sNb + com.tencent.mm.plugin.editor.model.nativenote.manager.j.cg(49.0F) < paramInt) {
          i = j;
        }
      }
      for (;;)
      {
        if ((i != 0) && (this.xwK))
        {
          AppMethodBeat.o(270823);
          return 0;
          i = 0;
          break;
          i = 0;
          continue;
        }
        try
        {
          paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
          AppMethodBeat.o(270823);
          return paramInt;
        }
        catch (Exception paramn)
        {
          AppMethodBeat.o(270823);
          return 0;
        }
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.CollectEditorLinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */