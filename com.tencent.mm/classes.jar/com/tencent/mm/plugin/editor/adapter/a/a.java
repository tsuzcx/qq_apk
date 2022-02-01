package com.tencent.mm.plugin.editor.adapter.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;

public abstract class a
  extends RecyclerView.v
{
  protected j xvq;
  
  public a(View paramView, j paramj)
  {
    super(paramView);
    this.xvq = paramj;
  }
  
  public abstract void a(com.tencent.mm.plugin.editor.model.a.a parama, int paramInt1, int paramInt2);
  
  public abstract int dvW();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.a
 * JD-Core Version:    0.7.0.1
 */