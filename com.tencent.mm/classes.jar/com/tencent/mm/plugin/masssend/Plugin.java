package com.tencent.mm.plugin.masssend;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ax;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  private c nUl;
  
  public Plugin()
  {
    AppMethodBeat.i(26340);
    this.nUl = new c()
    {
      public final com.tencent.mm.pluginsdk.b.a aa(Context paramAnonymousContext, String paramAnonymousString)
      {
        AppMethodBeat.i(26339);
        paramAnonymousContext = new com.tencent.mm.plugin.masssend.ui.a(paramAnonymousContext);
        AppMethodBeat.o(26339);
        return paramAnonymousContext;
      }
    };
    AppMethodBeat.o(26340);
  }
  
  public n createApplication()
  {
    AppMethodBeat.i(26341);
    a locala = new a();
    AppMethodBeat.o(26341);
    return locala;
  }
  
  public ax createSubCore()
  {
    AppMethodBeat.i(26342);
    h localh = new h();
    AppMethodBeat.o(26342);
    return localh;
  }
  
  public c getContactWidgetFactory()
  {
    return this.nUl;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.Plugin
 * JD-Core Version:    0.7.0.1
 */