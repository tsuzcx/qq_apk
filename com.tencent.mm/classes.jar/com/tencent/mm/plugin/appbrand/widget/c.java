package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.dynamicbackground.view.DynamicBackgroundGLSurfaceView;
import com.tencent.mm.g.a.kc;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.desktop.AppBrandDesktopContainer;
import com.tencent.mm.plugin.appbrand.widget.desktop.a.e;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.ConversationAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.MenuAppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.d.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.d.b;
import com.tencent.mm.sdk.platformtools.ad;

public final class c
  implements com.tencent.mm.plugin.appbrand.widget.recentview.d
{
  public final com.tencent.mm.plugin.appbrand.widget.header.c a(Context paramContext, ListView paramListView, HeaderContainer paramHeaderContainer)
  {
    AppMethodBeat.i(49366);
    paramContext = new com.tencent.mm.plugin.appbrand.widget.desktop.a(paramContext, paramListView, paramHeaderContainer);
    AppMethodBeat.o(49366);
    return paramContext;
  }
  
  public final AppBrandRecentView a(Context paramContext, d.b paramb, d.a parama)
  {
    AppMethodBeat.i(49362);
    if (paramb == d.b.nov)
    {
      paramb = new ConversationAppBrandRecentView(paramContext);
      paramb.setSceneFactory(parama);
      parama = new FrameLayout.LayoutParams(-1, (int)paramContext.getResources().getDimension(2131165832));
      paramb.setPadding(0, (int)paramContext.getResources().getDimension(2131165834), 0, 0);
      paramb.setLayoutParams(parama);
      AppMethodBeat.o(49362);
      return paramb;
    }
    if (paramb == d.b.nou)
    {
      paramb = new MenuAppBrandRecentView(paramContext);
      paramb.setSceneFactory(parama);
      parama = new FrameLayout.LayoutParams(-1, (int)paramContext.getResources().getDimension(2131165832));
      paramb.setPadding(0, (int)paramContext.getResources().getDimension(2131165834), 0, 0);
      paramb.setLayoutParams(parama);
      AppMethodBeat.o(49362);
      return paramb;
    }
    AppMethodBeat.o(49362);
    return null;
  }
  
  public final void bCb()
  {
    AppMethodBeat.i(49363);
    ad.i("MicroMsg.AppBrandRecentViewService", "[hideAppBrandRecentView] delay:%s type:%s", new Object[] { Integer.valueOf(300), Integer.valueOf(8) });
    if (((h)g.ajz().ajb()).akw())
    {
      kc localkc = new kc();
      localkc.dxb.delay = 300;
      localkc.dxb.type = 8;
      com.tencent.mm.sdk.b.a.IbL.l(localkc);
    }
    AppMethodBeat.o(49363);
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.recentview.b bCc()
  {
    AppMethodBeat.i(49364);
    com.tencent.mm.plugin.appbrand.widget.recentview.b localb = new com.tencent.mm.plugin.appbrand.widget.recentview.b();
    AppMethodBeat.o(49364);
    return localb;
  }
  
  public final void bCd()
  {
    AppMethodBeat.i(49367);
    com.tencent.mm.plugin.appbrand.widget.desktop.b.bCJ();
    AppMethodBeat.o(49367);
  }
  
  public final boolean bCe()
  {
    AppMethodBeat.i(49368);
    boolean bool = com.tencent.mm.plugin.appbrand.widget.desktop.b.adI();
    AppMethodBeat.o(49368);
    return bool;
  }
  
  public final HeaderContainer dU(Context paramContext)
  {
    AppMethodBeat.i(49365);
    paramContext = new AppBrandDesktopContainer(paramContext);
    AppMethodBeat.o(49365);
    return paramContext;
  }
  
  public final View dV(Context paramContext)
  {
    AppMethodBeat.i(49369);
    com.tencent.mm.dynamicbackground.model.d locald = com.tencent.mm.dynamicbackground.model.d.gfz;
    com.tencent.mm.dynamicbackground.model.d.a(new e());
    com.tencent.mm.dynamicbackground.a.c.a(com.tencent.mm.plugin.appbrand.widget.desktop.a.d.mZl);
    paramContext = new DynamicBackgroundGLSurfaceView(paramContext, (byte)0);
    AppMethodBeat.o(49369);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.c
 * JD-Core Version:    0.7.0.1
 */