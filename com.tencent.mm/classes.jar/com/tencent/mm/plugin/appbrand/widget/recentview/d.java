package com.tencent.mm.plugin.appbrand.widget.recentview;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;

@e(com.tencent.mm.plugin.appbrand.api.c.class)
public abstract interface d
  extends a
{
  public abstract com.tencent.mm.plugin.appbrand.widget.header.c a(Context paramContext, ListView paramListView, HeaderContainer paramHeaderContainer);
  
  public abstract AppBrandRecentView a(Context paramContext, d.b paramb, d.a parama);
  
  public abstract void bCb();
  
  public abstract b bCc();
  
  public abstract void bCd();
  
  public abstract boolean bCe();
  
  public abstract HeaderContainer dU(Context paramContext);
  
  public abstract View dV(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recentview.d
 * JD-Core Version:    0.7.0.1
 */