package com.tencent.mm.plugin.editor.model.nativenote.c;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.d.e;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;

public final class f
{
  public static View c(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(270817);
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(270817);
      return null;
    }
    try
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof LinearLayoutManager))
      {
        paramRecyclerView = ((LinearLayoutManager)paramRecyclerView).findViewByPosition(paramInt);
        AppMethodBeat.o(270817);
        return paramRecyclerView;
      }
    }
    catch (Exception paramRecyclerView)
    {
      for (;;)
      {
        paramRecyclerView = null;
      }
    }
  }
  
  public static c eX(View paramView)
  {
    AppMethodBeat.i(181924);
    if (paramView == null)
    {
      AppMethodBeat.o(181924);
      return null;
    }
    WXRTEditText localWXRTEditText1 = (WXRTEditText)paramView.findViewById(d.e.fVi);
    WXRTEditText localWXRTEditText2 = (WXRTEditText)paramView.findViewById(d.e.fuX);
    paramView = (WXRTEditText)paramView.findViewById(d.e.fuV);
    if (localWXRTEditText1 != null) {
      paramView = new c(localWXRTEditText1);
    }
    for (;;)
    {
      AppMethodBeat.o(181924);
      return paramView;
      if ((localWXRTEditText2 != null) && (paramView != null)) {
        paramView = new c(localWXRTEditText2, paramView);
      } else {
        paramView = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.c.f
 * JD-Core Version:    0.7.0.1
 */