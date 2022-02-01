package com.tencent.mm.plugin.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.be;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class Plugin
  implements d
{
  public n createApplication()
  {
    AppMethodBeat.i(111228);
    n local1 = new n()
    {
      public final void a(l paramAnonymousl) {}
      
      public final void a(m paramAnonymousm) {}
    };
    AppMethodBeat.o(111228);
    return local1;
  }
  
  public be createSubCore()
  {
    AppMethodBeat.i(111229);
    be local2 = new be()
    {
      public final void clearPluginData(int paramAnonymousInt) {}
      
      public final HashMap<Integer, h.b> getBaseDBFactories()
      {
        return null;
      }
      
      public final void onAccountPostReset(boolean paramAnonymousBoolean) {}
      
      public final void onAccountRelease() {}
      
      public final void onSdcardMount(boolean paramAnonymousBoolean) {}
    };
    AppMethodBeat.o(111229);
    return local2;
  }
  
  public c getContactWidgetFactory()
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.Plugin
 * JD-Core Version:    0.7.0.1
 */