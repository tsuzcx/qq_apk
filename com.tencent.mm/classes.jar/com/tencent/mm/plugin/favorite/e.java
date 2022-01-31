package com.tencent.mm.plugin.favorite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.applet.g.a;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.pluginsdk.ui.tools.a;
import com.tencent.mm.ui.widget.b.c;

public final class e
  implements ab
{
  public final int NS(String paramString)
  {
    AppMethodBeat.i(20531);
    int i = o.alm(paramString);
    AppMethodBeat.o(20531);
    return i;
  }
  
  public final int a(j.b paramb, WXMediaMessage paramWXMediaMessage, String paramString)
  {
    AppMethodBeat.i(20528);
    int i = l.a(paramb, paramWXMediaMessage, paramString);
    AppMethodBeat.o(20528);
    return i;
  }
  
  public final int a(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(20527);
    int i = l.a(paramWXMediaMessage, paramString1, paramString2, paramString3, 3, null);
    AppMethodBeat.o(20527);
    return i;
  }
  
  public final void a(Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(20529);
    a.a(paramActivity, paramString1, paramString2, 2);
    AppMethodBeat.o(20529);
  }
  
  public final void a(Context paramContext, String paramString, g paramg, boolean paramBoolean, q.a parama)
  {
    AppMethodBeat.i(20532);
    g.a locala = new g.a(paramContext);
    locala.cq(paramString);
    d.a(locala, paramContext, paramg);
    d.b(locala, paramContext, paramg);
    locala.i(Boolean.valueOf(paramBoolean)).LU(2131297067).a(parama).gwf.show();
    AppMethodBeat.o(20532);
  }
  
  public final void b(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(20530);
    a.a(paramActivity, paramInt1, paramInt2, paramIntent, true, 2131301863, 2131301864, 2);
    AppMethodBeat.o(20530);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.e
 * JD-Core Version:    0.7.0.1
 */