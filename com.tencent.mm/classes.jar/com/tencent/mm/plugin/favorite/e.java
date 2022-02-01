package com.tencent.mm.plugin.favorite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.pluginsdk.model.app.m;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.pluginsdk.ui.applet.o.a;
import com.tencent.mm.pluginsdk.ui.applet.y.a;
import com.tencent.mm.pluginsdk.ui.tools.a;

public final class e
  implements ab
{
  public final int Yn(String paramString)
  {
    AppMethodBeat.i(24607);
    int i = q.aAJ(paramString);
    AppMethodBeat.o(24607);
    return i;
  }
  
  public final int a(k.b paramb, WXMediaMessage paramWXMediaMessage, String paramString)
  {
    AppMethodBeat.i(24604);
    int i = m.a(paramb, paramWXMediaMessage, paramString, 0, null);
    AppMethodBeat.o(24604);
    return i;
  }
  
  public final int a(WXMediaMessage paramWXMediaMessage, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(24603);
    int i = m.a(paramWXMediaMessage, paramString1, paramString2, paramString3, 3, null);
    AppMethodBeat.o(24603);
    return i;
  }
  
  public final void a(Context paramContext, String paramString, g paramg, boolean paramBoolean, y.a parama)
  {
    AppMethodBeat.i(24608);
    o.a locala = new o.a(paramContext);
    locala.dL(paramString);
    d.a(locala, paramContext, paramg);
    d.b(locala, paramContext, paramg);
    locala.i(Boolean.valueOf(paramBoolean)).UL(2131755884).a(parama).ijc.show();
    AppMethodBeat.o(24608);
  }
  
  public final void b(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(24606);
    a.a(paramActivity, paramInt1, paramInt2, paramIntent, true, 2131761623, 2131761624, 2);
    AppMethodBeat.o(24606);
  }
  
  public final void b(Activity paramActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(24605);
    a.b(paramActivity, paramString1, paramString2, 2);
    AppMethodBeat.o(24605);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.favorite.e
 * JD-Core Version:    0.7.0.1
 */