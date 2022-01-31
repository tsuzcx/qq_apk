package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.j;

public final class b
  extends RecyclerView.a<b.a>
{
  h<j> iTQ = new h();
  private boolean iTR = true;
  private boolean iTS = false;
  private boolean iTT = false;
  private boolean iTU = false;
  private Context mContext;
  
  public b(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public final int getItemCount()
  {
    return this.iTQ.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    return ((j)this.iTQ.get(paramInt)).type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.b
 * JD-Core Version:    0.7.0.1
 */