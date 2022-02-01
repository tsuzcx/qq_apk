package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.p;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class d
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private b hGh;
  private c hGi;
  
  static
  {
    AppMethodBeat.i(20537);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("GETCONTACTINFO_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return b.SQL_CREATE;
      }
    });
    AppMethodBeat.o(20537);
  }
  
  private static d aEV()
  {
    AppMethodBeat.i(20534);
    az.ayG();
    com.tencent.mm.plugin.subapp.a locala = (com.tencent.mm.plugin.subapp.a)bz.yz("plugin.subapp");
    d locald;
    if (locala == null)
    {
      locald = null;
      if (locald != null) {
        break label71;
      }
      locald = new d();
      locala.b(d.class.getName(), locald);
    }
    label71:
    for (;;)
    {
      AppMethodBeat.o(20534);
      return locald;
      locald = (d)locala.axq(d.class.getName());
      break;
    }
  }
  
  public static b aEW()
  {
    AppMethodBeat.i(20535);
    g.agP().afT();
    if (aEV().hGh == null)
    {
      localObject = aEV();
      az.ayM();
      ((d)localObject).hGh = new b(com.tencent.mm.model.c.agw());
    }
    Object localObject = aEV().hGh;
    AppMethodBeat.o(20535);
    return localObject;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(20536);
    if (this.hGi == null) {
      this.hGi = new c();
    }
    com.tencent.mm.model.ar.a.hnw = this.hGi;
    ac.i("SubCoreGetContact", "summergetcontac onAccountPostReset setGetContact[%s]", new Object[] { this.hGi });
    g.b(h.class, new com.tencent.mm.pluginsdk.ui.applet.c());
    g.b(i.class, new p());
    AppMethodBeat.o(20536);
  }
  
  public void onAccountRelease() {}
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.at.d
 * JD-Core Version:    0.7.0.1
 */