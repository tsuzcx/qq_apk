package com.tencent.mm.plugin.editor.model.nativenote.c;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;

public final class f
{
  public static c dO(View paramView)
  {
    AppMethodBeat.i(181924);
    if (paramView == null)
    {
      AppMethodBeat.o(181924);
      return null;
    }
    WXRTEditText localWXRTEditText1 = (WXRTEditText)paramView.findViewById(2131304265);
    WXRTEditText localWXRTEditText2 = (WXRTEditText)paramView.findViewById(2131297580);
    paramView = (WXRTEditText)paramView.findViewById(2131297578);
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
  
  public static View e(RecyclerView paramRecyclerView, int paramInt)
  {
    AppMethodBeat.i(181923);
    if (paramRecyclerView == null)
    {
      AppMethodBeat.o(181923);
      return null;
    }
    try
    {
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if ((paramRecyclerView instanceof LinearLayoutManager))
      {
        paramRecyclerView = ((LinearLayoutManager)paramRecyclerView).bY(paramInt);
        AppMethodBeat.o(181923);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.c.f
 * JD-Core Version:    0.7.0.1
 */