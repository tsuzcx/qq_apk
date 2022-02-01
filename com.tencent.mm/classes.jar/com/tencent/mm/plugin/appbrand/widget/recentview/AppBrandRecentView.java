package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class AppBrandRecentView
  extends RecyclerView
{
  private AppBrandRecentView.e lWG;
  d.a mkv;
  
  public AppBrandRecentView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AppBrandRecentView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public abstract RecyclerView.a getAdapter();
  
  public abstract int getCount();
  
  public abstract AppBrandRecentView.b getOnItemClickListener();
  
  public AppBrandRecentView.e getRefreshListener()
  {
    return this.lWG;
  }
  
  public d.a getSceneFactory()
  {
    return this.mkv;
  }
  
  public abstract void refresh();
  
  public abstract void release();
  
  public abstract void setDataQuery(AppBrandRecentView.c paramc);
  
  public abstract void setOnItemClickListener(AppBrandRecentView.b paramb);
  
  public void setRefreshListener(AppBrandRecentView.e parame)
  {
    this.lWG = parame;
  }
  
  public void setSceneFactory(d.a parama)
  {
    this.mkv = parama;
  }
  
  public static enum f
  {
    static
    {
      AppMethodBeat.i(153240);
      mkw = new f("RECENT_APP_BRAND", 0);
      mkx = new f("MY_APP_BRAND", 1);
      mky = new f[] { mkw, mkx };
      AppMethodBeat.o(153240);
    }
    
    private f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */