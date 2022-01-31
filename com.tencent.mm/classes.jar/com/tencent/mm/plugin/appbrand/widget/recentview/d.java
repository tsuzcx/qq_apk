package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.widget.ListView;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;

@e(com.tencent.mm.plugin.appbrand.a.b.class)
public abstract interface d
  extends com.tencent.mm.kernel.c.a
{
  public abstract com.tencent.mm.plugin.appbrand.widget.header.a a(Context paramContext, ListView paramListView, HeaderContainer paramHeaderContainer);
  
  public abstract AppBrandRecentView a(Context paramContext, d.b paramb, d.a parama);
  
  public abstract b aqW();
  
  public abstract void cE(Context paramContext);
  
  public abstract HeaderContainer cF(Context paramContext);
  
  public abstract void ci(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.d
 * JD-Core Version:    0.7.0.1
 */