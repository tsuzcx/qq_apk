package com.tencent.mm.plugin.editor.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.n;
import android.support.v7.widget.RecyclerView.s;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.i;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class CollectEditorLinearLayoutManager
  extends LinearLayoutManager
{
  private final int oXi;
  public int qOi;
  public boolean qOj;
  
  public CollectEditorLinearLayoutManager()
  {
    AppMethodBeat.i(181634);
    this.oXi = i.getKeyBordHeightPx(MMApplicationContext.getContext(), true);
    this.qOi = -1;
    this.qOj = false;
    AppMethodBeat.o(181634);
  }
  
  public CollectEditorLinearLayoutManager(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    AppMethodBeat.i(181635);
    this.oXi = i.getKeyBordHeightPx(MMApplicationContext.getContext(), true);
    this.qOi = -1;
    this.qOj = false;
    AppMethodBeat.o(181635);
  }
  
  public final int b(RecyclerView.s params)
  {
    if (this.qOi > 0) {
      return this.qOi;
    }
    return 900;
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(181637);
    try
    {
      super.onLayoutChildren(paramn, params);
      AppMethodBeat.o(181637);
      return;
    }
    catch (Exception paramn)
    {
      Log.printErrStackTrace("MicroMsg.CollectEditorLinearLayoutManager", paramn, "", new Object[0]);
      AppMethodBeat.o(181637);
    }
  }
  
  public int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    int j = 1;
    AppMethodBeat.i(181636);
    if (!this.qOj)
    {
      paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
      AppMethodBeat.o(181636);
      return paramInt;
    }
    int i;
    if (paramInt < 0) {
      if (j.be(49.0F) <= Math.abs(paramInt)) {
        i = 1;
      }
    }
    for (;;)
    {
      if (paramInt > 0) {
        if (this.oXi + j.be(49.0F) < paramInt) {
          i = j;
        }
      }
      for (;;)
      {
        if ((i != 0) && (this.qOj))
        {
          AppMethodBeat.o(181636);
          return 0;
          i = 0;
          break;
          i = 0;
          continue;
        }
        try
        {
          paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
          AppMethodBeat.o(181636);
          return paramInt;
        }
        catch (Exception paramn)
        {
          AppMethodBeat.o(181636);
          return 0;
        }
      }
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.CollectEditorLinearLayoutManager
 * JD-Core Version:    0.7.0.1
 */