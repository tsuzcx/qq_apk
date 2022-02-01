package com.tencent.mm.at;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.cc;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.applet.p;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class d
  implements az
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private b ibG;
  private ab ibH;
  
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
  
  private static d aIr()
  {
    AppMethodBeat.i(20534);
    bc.aCa();
    com.tencent.mm.plugin.subapp.a locala = (com.tencent.mm.plugin.subapp.a)cc.Ca("plugin.subapp");
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
      locald = (d)locala.aDN(d.class.getName());
      break;
    }
  }
  
  public static b aIs()
  {
    AppMethodBeat.i(20535);
    g.ajP().aiU();
    if (aIr().ibG == null)
    {
      localObject = aIr();
      bc.aCg();
      ((d)localObject).ibG = new b(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = aIr().ibG;
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
    if (this.ibH == null) {
      this.ibH = new ab(new c());
    }
    com.tencent.mm.model.au.a.hIG = this.ibH;
    ae.i("SubCoreGetContact", "summergetcontac onAccountPostReset setGetContact[%s]", new Object[] { this.ibH });
    g.b(i.class, new com.tencent.mm.pluginsdk.ui.applet.c());
    g.b(j.class, new p());
    AppMethodBeat.o(20536);
  }
  
  public void onAccountRelease() {}
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.at.d
 * JD-Core Version:    0.7.0.1
 */