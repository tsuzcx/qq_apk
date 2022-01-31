package com.tencent.mm.plugin.game.ui;

import android.support.v7.widget.RecyclerView.a;
import com.tencent.mm.plugin.game.model.e;
import java.util.LinkedList;

public final class GameIndexListView$b
  extends RecyclerView.a<GameIndexListView.b.a>
{
  LinkedList<e> lbV = new LinkedList();
  
  public GameIndexListView$b(GameIndexListView paramGameIndexListView) {}
  
  public final int getItemCount()
  {
    return this.lbV.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    return ((e)this.lbV.get(paramInt)).type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexListView.b
 * JD-Core Version:    0.7.0.1
 */