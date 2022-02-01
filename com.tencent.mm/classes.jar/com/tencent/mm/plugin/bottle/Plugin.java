package com.tencent.mm.plugin.bottle;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.n;

public final class Plugin
  implements com.tencent.mm.pluginsdk.b.d
{
  private c pkO;
  
  public Plugin()
  {
    AppMethodBeat.i(22640);
    this.pkO = new c()
    {
      public final com.tencent.mm.pluginsdk.b.a ak(Context paramAnonymousContext, String paramAnonymousString)
      {
        return null;
      }
    };
    AppMethodBeat.o(22640);
  }
  
  public final n createApplication()
  {
    AppMethodBeat.i(22641);
    a locala = new a();
    AppMethodBeat.o(22641);
    return locala;
  }
  
  public final bd createSubCore()
  {
    AppMethodBeat.i(22642);
    com.tencent.mm.plugin.bottle.a.d locald = new com.tencent.mm.plugin.bottle.a.d();
    AppMethodBeat.o(22642);
    return locald;
  }
  
  public final c getContactWidgetFactory()
  {
    return this.pkO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.Plugin
 * JD-Core Version:    0.7.0.1
 */