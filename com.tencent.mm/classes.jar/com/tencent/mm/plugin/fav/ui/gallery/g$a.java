package com.tencent.mm.plugin.fav.ui.gallery;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;

public abstract interface g$a
  extends a<g.b>
{
  public abstract void I(boolean paramBoolean, int paramInt);
  
  public abstract void MN(int paramInt);
  
  public abstract void a(f.b paramb);
  
  public abstract RecyclerView.a c(FavoriteImageServer paramFavoriteImageServer);
  
  public abstract boolean dSE();
  
  public abstract void dSF();
  
  public abstract void dSG();
  
  public abstract <T extends RecyclerView.a> T dSN();
  
  public abstract <T extends RecyclerView.LayoutManager> T fT(Context paramContext);
  
  public abstract RecyclerView.h gl(Context paramContext);
  
  public abstract void onResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.gallery.g.a
 * JD-Core Version:    0.7.0.1
 */