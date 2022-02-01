package com.tencent.mm.plugin.editor.adapter;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class CollectEditorLinearLayoutManager
  extends LinearLayoutManager
{
  private final int pIk;
  public int uqm;
  public boolean uqn;
  
  public CollectEditorLinearLayoutManager()
  {
    AppMethodBeat.i(181634);
    this.pIk = i.getKeyBordHeightPx(MMApplicationContext.getContext(), true);
    this.uqm = -1;
    this.uqn = false;
    AppMethodBeat.o(181634);
  }
  
  public CollectEditorLinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    AppMethodBeat.i(181635);
    this.pIk = i.getKeyBordHeightPx(MMApplicationContext.getContext(), true);
    this.uqm = -1;
    this.uqn = false;
    AppMethodBeat.o(181635);
  }
  
  public final int b(RecyclerView.s params)
  {
    if (this.uqm > 0) {
      return this.uqm;
    }
    return 900;
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(188797);
    try
    {
      super.onLayoutChildren(paramn, params);
      AppMethodBeat.o(188797);
      return;
    }
    catch (Exception paramn)
    {
      Log.printErrStackTrace("MicroMsg.CollectEditorLinearLayoutManager", paramn, "", new Object[0]);
      AppMethodBeat.o(188797);
    }
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    int j = 1;
    AppMethodBeat.i(188794);
    if (!this.uqn)
    {
      paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
      AppMethodBeat.o(188794);
      return paramInt;
    }
    int i;
    if (paramInt < 0) {
      if (j.bd(49.0F) <= Math.abs(paramInt)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (paramInt > 0) {
        if (this.pIk + j.bd(49.0F) < paramInt) {
          i = j;
        }
      }
      for (;;)
      {
        if ((i != 0) && (this.uqn))
        {
          AppMethodBeat.o(188794);
          return 0;
          i = 0;
          break;
          i = 0;
          continue;
        }
        try
        {
          paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
          AppMethodBeat.o(188794);
          return paramInt;
        }
        catch (Exception paramn)
        {
          AppMethodBeat.o(188794);
          return 0;
        }
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.CollectEditorLinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */