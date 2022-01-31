package com.tencent.mm.ar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.ui.applet.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public class d
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private b fDd;
  private c fDe;
  
  static
  {
    AppMethodBeat.i(16491);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("GETCONTACTINFO_TABLE".hashCode()), new d.1());
    AppMethodBeat.o(16491);
  }
  
  private static d ahc()
  {
    AppMethodBeat.i(16488);
    aw.aat();
    com.tencent.mm.plugin.subapp.a locala = (com.tencent.mm.plugin.subapp.a)bw.pF("plugin.subapp");
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
      AppMethodBeat.o(16488);
      return locald;
      locald = (d)locala.adN(d.class.getName());
      break;
    }
  }
  
  public static b ahd()
  {
    AppMethodBeat.i(16489);
    com.tencent.mm.kernel.g.RJ().QQ();
    if (ahc().fDd == null)
    {
      localObject = ahc();
      aw.aaz();
      ((d)localObject).fDd = new b(com.tencent.mm.model.c.Rq());
    }
    Object localObject = ahc().fDd;
    AppMethodBeat.o(16489);
    return localObject;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(16490);
    if (this.fDe == null) {
      this.fDe = new c();
    }
    com.tencent.mm.model.ao.a.flI = this.fDe;
    ab.i("SubCoreGetContact", "summergetcontac onAccountPostReset setGetContact[%s]", new Object[] { this.fDe });
    com.tencent.mm.kernel.g.b(com.tencent.mm.pluginsdk.g.class, new com.tencent.mm.pluginsdk.ui.applet.c());
    com.tencent.mm.kernel.g.b(i.class, new h());
    AppMethodBeat.o(16490);
  }
  
  public void onAccountRelease() {}
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ar.d
 * JD-Core Version:    0.7.0.1
 */