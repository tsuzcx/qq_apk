package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.cg;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.applet.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class d
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private b iWE;
  private af iWF;
  
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
  
  private static d bcl()
  {
    AppMethodBeat.i(20534);
    bg.aVz();
    com.tencent.mm.plugin.subapp.a locala = (com.tencent.mm.plugin.subapp.a)cg.KG("plugin.subapp");
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
      locald = (d)locala.aSI(d.class.getName());
      break;
    }
  }
  
  public static b bcm()
  {
    AppMethodBeat.i(20535);
    g.aAf().azk();
    if (bcl().iWE == null)
    {
      localObject = bcl();
      bg.aVF();
      ((d)localObject).iWE = new b(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = bcl().iWE;
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
    if (this.iWF == null) {
      this.iWF = new af(new c());
    }
    com.tencent.mm.model.ay.a.iDq = this.iWF;
    Log.i("SubCoreGetContact", "summergetcontac onAccountPostReset setGetContact[%s]", new Object[] { this.iWF });
    g.b(i.class, new com.tencent.mm.pluginsdk.ui.applet.c());
    g.b(j.class, new p());
    AppMethodBeat.o(20536);
  }
  
  public void onAccountRelease() {}
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.at.d
 * JD-Core Version:    0.7.0.1
 */