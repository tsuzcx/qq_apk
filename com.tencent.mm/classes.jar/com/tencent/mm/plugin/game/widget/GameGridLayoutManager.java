package com.tencent.mm.plugin.game.widget;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.o;
import android.support.v7.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class GameGridLayoutManager
  extends GridLayoutManager
{
  public GameGridLayoutManager()
  {
    super(2, 1);
  }
  
  public GameGridLayoutManager(byte paramByte)
  {
    super(4);
  }
  
  public final void c(RecyclerView.o paramo, RecyclerView.s params)
  {
    AppMethodBeat.i(42619);
    try
    {
      super.c(paramo, params);
      AppMethodBeat.o(42619);
      return;
    }
    catch (IndexOutOfBoundsException paramo)
    {
      ad.e("MicroMsg.GameGridLayoutManager", "meet a IOOBE in RecyclerView");
      AppMethodBeat.o(42619);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.GameGridLayoutManager
 * JD-Core Version:    0.7.0.1
 */