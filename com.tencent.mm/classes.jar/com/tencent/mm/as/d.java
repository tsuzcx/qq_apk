package com.tencent.mm.as;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.af;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.ci;
import com.tencent.mm.plugin.subapp.SubCoreSubapp;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.j;
import com.tencent.mm.pluginsdk.ui.applet.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class d
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private b oFG;
  private af oFH;
  
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
  
  private static d bJv()
  {
    AppMethodBeat.i(20534);
    bh.bCt();
    SubCoreSubapp localSubCoreSubapp = (SubCoreSubapp)ci.Ka("plugin.subapp");
    d locald;
    if (localSubCoreSubapp == null)
    {
      locald = null;
      if (locald != null) {
        break label71;
      }
      locald = new d();
      localSubCoreSubapp.b(d.class.getName(), locald);
    }
    label71:
    for (;;)
    {
      AppMethodBeat.o(20534);
      return locald;
      locald = (d)localSubCoreSubapp.bcy(d.class.getName());
      break;
    }
  }
  
  public static b bJw()
  {
    AppMethodBeat.i(20535);
    h.baC().aZJ();
    if (bJv().oFG == null)
    {
      localObject = bJv();
      bh.bCz();
      ((d)localObject).oFG = new b(com.tencent.mm.model.c.getDataDB());
    }
    Object localObject = bJv().oFG;
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
    if (this.oFH == null) {
      this.oFH = new af(new c());
    }
    com.tencent.mm.model.az.a.okP = this.oFH;
    Log.i("SubCoreGetContact", "summergetcontac onAccountPostReset setGetContact[%s]", new Object[] { this.oFH });
    h.b(i.class, new com.tencent.mm.pluginsdk.ui.applet.c());
    h.b(j.class, new p());
    AppMethodBeat.o(20536);
  }
  
  public void onAccountRelease() {}
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.as.d
 * JD-Core Version:    0.7.0.1
 */