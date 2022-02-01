package com.tencent.mm.plugin.gallery;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bd;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.b.d;
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
  
  public bd createSubCore()
  {
    AppMethodBeat.i(111229);
    bd local2 = new bd()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.Plugin
 * JD-Core Version:    0.7.0.1
 */