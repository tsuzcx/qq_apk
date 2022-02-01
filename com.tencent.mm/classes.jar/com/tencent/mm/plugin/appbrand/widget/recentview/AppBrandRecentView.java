package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public abstract class AppBrandRecentView
  extends RecyclerView
{
  private e ney;
  d.a nsc;
  
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
  
  public abstract b getOnItemClickListener();
  
  public e getRefreshListener()
  {
    return this.ney;
  }
  
  public d.a getSceneFactory()
  {
    return this.nsc;
  }
  
  public abstract void refresh();
  
  public abstract void release();
  
  public abstract void setDataQuery(c paramc);
  
  public abstract void setOnItemClickListener(b paramb);
  
  public void setRefreshListener(e parame)
  {
    this.ney = parame;
  }
  
  public void setSceneFactory(d.a parama)
  {
    this.nsc = parama;
  }
  
  public static abstract interface a<T>
  {
    public abstract void a(MenuItem paramMenuItem, int paramInt, T paramT);
  }
  
  public static abstract interface b
  {
    public abstract boolean a(View paramView, a parama, float paramFloat1, float paramFloat2);
    
    public abstract boolean b(View paramView, a parama, float paramFloat1, float paramFloat2);
  }
  
  public static abstract interface c<T>
  {
    public abstract List<T> wm(int paramInt);
  }
  
  public static abstract interface d
  {
    public abstract void bEp();
  }
  
  public static abstract interface e
  {
    public abstract void uT(int paramInt);
  }
  
  public static enum f
  {
    static
    {
      AppMethodBeat.i(153240);
      nsd = new f("RECENT_APP_BRAND", 0);
      nse = new f("MY_APP_BRAND", 1);
      nsf = new f[] { nsd, nse };
      AppMethodBeat.o(153240);
    }
    
    private f() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView
 * JD-Core Version:    0.7.0.1
 */