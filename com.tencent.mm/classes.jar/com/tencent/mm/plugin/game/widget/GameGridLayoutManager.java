package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class GameGridLayoutManager
  extends GridLayoutManager
{
  public GameGridLayoutManager()
  {
    super(2, 1);
  }
  
  public GameGridLayoutManager(Context paramContext)
  {
    super(4);
  }
  
  public void onLayoutChildren(RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(275391);
    try
    {
      super.onLayoutChildren(paramn, params);
      AppMethodBeat.o(275391);
      return;
    }
    catch (IndexOutOfBoundsException paramn)
    {
      Log.e("MicroMsg.GameGridLayoutManager", "meet a IOOBE in RecyclerView");
      AppMethodBeat.o(275391);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.GameGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */