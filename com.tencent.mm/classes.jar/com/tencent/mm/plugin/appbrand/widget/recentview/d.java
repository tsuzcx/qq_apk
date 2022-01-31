package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;

@e(com.tencent.mm.plugin.appbrand.a.c.class)
public abstract interface d
  extends a
{
  public abstract com.tencent.mm.plugin.appbrand.widget.header.c a(Context paramContext, ListView paramListView, HeaderContainer paramHeaderContainer);
  
  public abstract AppBrandRecentView a(Context paramContext, b paramb, a parama);
  
  public abstract void aOA();
  
  public abstract boolean aOB();
  
  public abstract void aOy();
  
  public abstract b aOz();
  
  public abstract HeaderContainer dj(Context paramContext);
  
  public abstract View dk(Context paramContext);
  
  public static abstract interface a
  {
    public abstract LocalUsageInfo aJB();
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(114948);
      jvK = new b("TYPE_MENU", 0);
      jvL = new b("TYPE_CONVERSATION", 1);
      jvM = new b[] { jvK, jvL };
      AppMethodBeat.o(114948);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.d
 * JD-Core Version:    0.7.0.1
 */