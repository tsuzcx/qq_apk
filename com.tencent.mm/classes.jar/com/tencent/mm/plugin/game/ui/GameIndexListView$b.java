package com.tencent.mm.plugin.game.ui;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.d;
import java.util.LinkedList;

public final class GameIndexListView$b
  extends RecyclerView.a<GameIndexListView.b.a>
{
  LinkedList<d> nzQ;
  
  public GameIndexListView$b(GameIndexListView paramGameIndexListView)
  {
    AppMethodBeat.i(111975);
    this.nzQ = new LinkedList();
    AppMethodBeat.o(111975);
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(111977);
    int i = this.nzQ.size();
    AppMethodBeat.o(111977);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(111976);
    paramInt = ((d)this.nzQ.get(paramInt)).type;
    AppMethodBeat.o(111976);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexListView.b
 * JD-Core Version:    0.7.0.1
 */