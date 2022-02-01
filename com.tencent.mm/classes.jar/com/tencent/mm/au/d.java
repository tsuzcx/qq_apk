package com.tencent.mm.au;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class d
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private b hfE;
  private c hfF;
  
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
  
  private static d ayd()
  {
    AppMethodBeat.i(20534);
    az.arP();
    com.tencent.mm.plugin.subapp.a locala = (com.tencent.mm.plugin.subapp.a)bz.ut("plugin.subapp");
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
      locald = (d)locala.ash(d.class.getName());
      break;
    }
  }
  
  public static b aye()
  {
    AppMethodBeat.i(20535);
    g.afz().aeD();
    if (ayd().hfE == null)
    {
      localObject = ayd();
      az.arV();
      ((d)localObject).hfE = new b(com.tencent.mm.model.c.afg());
    }
    Object localObject = ayd().hfE;
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
    if (this.hfF == null) {
      this.hfF = new c();
    }
    com.tencent.mm.model.ar.a.gMW = this.hfF;
    ad.i("SubCoreGetContact", "summergetcontac onAccountPostReset setGetContact[%s]", new Object[] { this.hfF });
    g.b(h.class, new com.tencent.mm.pluginsdk.ui.applet.c());
    g.b(i.class, new p());
    AppMethodBeat.o(20536);
  }
  
  public void onAccountRelease() {}
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.au.d
 * JD-Core Version:    0.7.0.1
 */