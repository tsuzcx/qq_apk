package com.tencent.mm.plugin.editor.adapter.a;

import android.support.v7.widget.RecyclerView.w;
import android.view.View;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;

public abstract class a
  extends RecyclerView.w
{
  protected j prJ;
  
  public a(View paramView, j paramj)
  {
    super(paramView);
    this.prJ = paramj;
  }
  
  public abstract void a(com.tencent.mm.plugin.editor.model.a.a parama, int paramInt1, int paramInt2);
  
  public abstract int cdT();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.a
 * JD-Core Version:    0.7.0.1
 */