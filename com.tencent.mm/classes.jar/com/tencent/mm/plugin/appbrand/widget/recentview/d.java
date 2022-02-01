package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;

@e(com.tencent.mm.plugin.appbrand.a.c.class)
public abstract interface d
  extends a
{
  public abstract com.tencent.mm.plugin.appbrand.widget.header.c a(Context paramContext, ListView paramListView, HeaderContainer paramHeaderContainer);
  
  public abstract AppBrandRecentView a(Context paramContext, b paramb, d.a parama);
  
  public abstract void bqV();
  
  public abstract b bqW();
  
  public abstract void bqX();
  
  public abstract boolean bqY();
  
  public abstract HeaderContainer dM(Context paramContext);
  
  public abstract View dN(Context paramContext);
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(153259);
      mlW = new b("TYPE_MENU", 0);
      mlX = new b("TYPE_CONVERSATION", 1);
      mlY = new b[] { mlW, mlX };
      AppMethodBeat.o(153259);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.d
 * JD-Core Version:    0.7.0.1
 */