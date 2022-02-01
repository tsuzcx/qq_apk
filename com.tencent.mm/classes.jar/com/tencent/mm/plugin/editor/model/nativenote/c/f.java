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
    AppMethodBeat.i(189237);
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(189237);
      return null;
    }
    try
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof LinearLayoutManager))
      {
        paramRecyclerView = ((LinearLayoutManager)paramRecyclerView).findViewByPosition(paramInt);
        AppMethodBeat.o(189237);
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
  
  public static c ee(View paramView)
  {
    AppMethodBeat.i(181924);
    if (paramView == null)
    {
      AppMethodBeat.o(181924);
      return null;
    }
    WXRTEditText localWXRTEditText1 = (WXRTEditText)paramView.findViewById(d.e.dTc);
    WXRTEditText localWXRTEditText2 = (WXRTEditText)paramView.findViewById(d.e.duF);
    paramView = (WXRTEditText)paramView.findViewById(d.e.duD);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.c.f
 * JD-Core Version:    0.7.0.1
 */