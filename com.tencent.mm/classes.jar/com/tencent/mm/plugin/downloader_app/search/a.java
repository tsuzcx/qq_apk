package com.tencent.mm.plugin.downloader_app.search;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import java.util.ArrayList;

public final class a
  extends RecyclerView.a<a.a>
{
  ArrayList<b> hka = new ArrayList();
  DownloadSearchListView iSy;
  Context mContext;
  
  a(Context paramContext, DownloadSearchListView paramDownloadSearchListView)
  {
    this.mContext = paramContext;
    this.iSy = paramDownloadSearchListView;
  }
  
  public final int getItemCount()
  {
    return this.hka.size();
  }
  
  public final int getItemViewType(int paramInt)
  {
    return ((b)this.hka.get(paramInt)).type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.a
 * JD-Core Version:    0.7.0.1
 */