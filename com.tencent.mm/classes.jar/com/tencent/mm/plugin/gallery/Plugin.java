package com.tencent.mm.plugin.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class Plugin
  implements d
{
  public m createApplication()
  {
    AppMethodBeat.i(111228);
    m local1 = new m()
    {
      public final void a(k paramAnonymousk) {}
      
      public final void a(l paramAnonymousl) {}
    };
    AppMethodBeat.o(111228);
    return local1;
  }
  
  public aw createSubCore()
  {
    AppMethodBeat.i(111229);
    aw local2 = new aw()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.Plugin
 * JD-Core Version:    0.7.0.1
 */