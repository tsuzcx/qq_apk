package com.tencent.mm.plugin.masssend;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.masssend.model.g;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.n;

public class Plugin
  implements d
{
  private c vyV;
  
  public Plugin()
  {
    AppMethodBeat.i(26340);
    this.vyV = new c()
    {
      public final com.tencent.mm.pluginsdk.c.a al(Context paramAnonymousContext, String paramAnonymousString)
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
  
  public be createSubCore()
  {
    AppMethodBeat.i(26342);
    g localg = new g();
    AppMethodBeat.o(26342);
    return localg;
  }
  
  public c getContactWidgetFactory()
  {
    return this.vyV;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.Plugin
 * JD-Core Version:    0.7.0.1
 */