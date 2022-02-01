package com.tencent.luggage.h.a.a;

import android.content.Context;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.menu.a.b;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/skyline/wxa/menu/MenuDelegate_SwitchRender;", "Lcom/tencent/mm/plugin/appbrand/menu/base/BaseSecondaryMenuDelegate;", "Lcom/tencent/luggage/sdk/jsapi/component/AppBrandPageViewLU;", "()V", "getTitle", "", "context", "Landroid/content/Context;", "pageView", "appId", "performItemClick", "", "shouldShow", "", "luggage-skyline-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements b<com.tencent.luggage.sdk.b.a.c>
{
  private static final void a(Context paramContext, com.tencent.luggage.sdk.b.a.c paramc)
  {
    AppMethodBeat.i(220074);
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramc, "$pageView");
    Toast.makeText(paramContext, (CharSequence)"renderer: NONE", 0).show();
    paramc.aqZ().finish();
    AppMethodBeat.o(220074);
  }
  
  private static final void a(Context paramContext, com.tencent.luggage.sdk.b.a.c paramc, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(220088);
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramc, "$pageView");
    switch (paramMenuItem.getItemId())
    {
    default: 
      com.tencent.luggage.h.c.mw(0);
      h.ahAA.bk(new a..ExternalSyntheticLambda2(paramContext, paramc));
      AppMethodBeat.o(220088);
      return;
    case 0: 
      com.tencent.luggage.h.c.mw(0);
      h.ahAA.bk(new a..ExternalSyntheticLambda3(paramContext, paramc));
      AppMethodBeat.o(220088);
      return;
    case 1: 
      com.tencent.luggage.h.c.mw(1);
      h.ahAA.bk(new a..ExternalSyntheticLambda4(paramContext, paramc));
      AppMethodBeat.o(220088);
      return;
    }
    com.tencent.luggage.h.c.mw(2);
    h.ahAA.bk(new a..ExternalSyntheticLambda5(paramContext, paramc));
    AppMethodBeat.o(220088);
  }
  
  private static final void a(com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(220071);
    params.c(0, (CharSequence)"WebView");
    params.c(1, (CharSequence)"FlutterTextureView");
    params.c(2, (CharSequence)"FlutterSurfaceView");
    AppMethodBeat.o(220071);
  }
  
  private static final void b(Context paramContext, com.tencent.luggage.sdk.b.a.c paramc)
  {
    AppMethodBeat.i(220075);
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramc, "$pageView");
    Toast.makeText(paramContext, (CharSequence)"renderer: FlutterTextureView", 0).show();
    paramc.aqZ().finish();
    AppMethodBeat.o(220075);
  }
  
  private static final void c(Context paramContext, com.tencent.luggage.sdk.b.a.c paramc)
  {
    AppMethodBeat.i(220079);
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramc, "$pageView");
    Toast.makeText(paramContext, (CharSequence)"renderer: FlutterSurfaceView", 0).show();
    paramc.aqZ().finish();
    AppMethodBeat.o(220079);
  }
  
  private static final void d(Context paramContext, com.tencent.luggage.sdk.b.a.c paramc)
  {
    AppMethodBeat.i(220083);
    kotlin.g.b.s.u(paramContext, "$context");
    kotlin.g.b.s.u(paramc, "$pageView");
    Toast.makeText(paramContext, (CharSequence)"renderer: WEBVIEW", 0).show();
    paramc.aqZ().finish();
    AppMethodBeat.o(220083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.h.a.a.a
 * JD-Core Version:    0.7.0.1
 */