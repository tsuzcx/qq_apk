package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.mm.plugin.fav.ui.o;

public abstract interface g$a
  extends a<g.b>
{
  public abstract void K(boolean paramBoolean, int paramInt);
  
  public abstract void LQ(int paramInt);
  
  public abstract void a(f.b paramb);
  
  public abstract RecyclerView.a c(o paramo);
  
  public abstract boolean dlO();
  
  public abstract void dlP();
  
  public abstract void dlQ();
  
  public abstract <T extends RecyclerView.a> T dlX();
  
  public abstract <T extends RecyclerView.LayoutManager> T eW(Context paramContext);
  
  public abstract RecyclerView.h fn(Context paramContext);
  
  public abstract void onResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.g.a
 * JD-Core Version:    0.7.0.1
 */