package com.tencent.mm.au;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.ca;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.applet.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class d
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private b hYO;
  private aa hYP;
  
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
  
  private static d aIa()
  {
    AppMethodBeat.i(20534);
    ba.aBK();
    com.tencent.mm.plugin.subapp.a locala = (com.tencent.mm.plugin.subapp.a)ca.By("plugin.subapp");
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
      locald = (d)locala.aCu(d.class.getName());
      break;
    }
  }
  
  public static b aIb()
  {
    AppMethodBeat.i(20535);
    g.ajA().aiF();
    if (aIa().hYO == null)
    {
      localObject = aIa();
      ba.aBQ();
      ((d)localObject).hYO = new b(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = aIa().hYO;
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
    if (this.hYP == null) {
      this.hYP = new aa(new c());
    }
    com.tencent.mm.model.as.a.hFO = this.hYP;
    ad.i("SubCoreGetContact", "summergetcontac onAccountPostReset setGetContact[%s]", new Object[] { this.hYP });
    g.b(i.class, new com.tencent.mm.pluginsdk.ui.applet.c());
    g.b(j.class, new p());
    AppMethodBeat.o(20536);
  }
  
  public void onAccountRelease() {}
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.au.d
 * JD-Core Version:    0.7.0.1
 */