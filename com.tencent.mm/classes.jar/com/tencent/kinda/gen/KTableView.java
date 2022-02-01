package com.tencent.kinda.gen;

import java.util.ArrayList;

public abstract interface KTableView
  extends KView
{
  public abstract void setCells(ArrayList<KTableViewCellManager> paramArrayList);
  
  public abstract void setEnableFooterRefreshView(boolean paramBoolean);
  
  public abstract void setFooterRefreshViewLoadMoreCallbackImpl(VoidCallback paramVoidCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.KTableView
 * JD-Core Version:    0.7.0.1
 */