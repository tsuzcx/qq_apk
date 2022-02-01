package com.tencent.mm.plugin.editor.adapter;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
  extends RecyclerView.a<com.tencent.mm.plugin.editor.adapter.a.a>
{
  private final String TAG;
  private j qNG;
  private com.tencent.mm.plugin.editor.adapter.a.c qOl;
  
  public b(j paramj)
  {
    AppMethodBeat.i(181638);
    this.TAG = "MicroMsg.EditorAdapter";
    this.qNG = paramj;
    this.qOl = new com.tencent.mm.plugin.editor.adapter.a.c();
    AppMethodBeat.o(181638);
  }
  
  private void a(com.tencent.mm.plugin.editor.adapter.a.a parama, int paramInt)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        AppMethodBeat.i(181641);
        com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().Fw(paramInt);
        if ((locala != null) && (locala.getType() == parama.cCY()))
        {
          parama.a(locala, paramInt, locala.getType());
          AppMethodBeat.o(181641);
          return;
        }
        if (locala == null)
        {
          Log.e("MicroMsg.EditorAdapter", "onBindViewHolder, item is null %b, position is %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramInt) });
          AppMethodBeat.o(181641);
        }
        else
        {
          bool = false;
        }
      }
      finally {}
    }
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(181639);
    int i = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().size();
    AppMethodBeat.o(181639);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(181640);
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().Fw(paramInt);
    if (locala != null)
    {
      paramInt = locala.getType();
      AppMethodBeat.o(181640);
      return paramInt;
    }
    Log.e("MicroMsg.EditorAdapter", "getItemViewType, item is null, position is %d", new Object[] { Integer.valueOf(paramInt) });
    AppMethodBeat.o(181640);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.b
 * JD-Core Version:    0.7.0.1
 */