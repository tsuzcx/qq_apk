package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.an;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class e
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private an tTx;
  private d tTy;
  
  static
  {
    AppMethodBeat.i(26141);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("CONTACT_LABEL_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return an.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("CONTACT_LABEL_CACHE_TABLE".hashCode()), new e.2());
    AppMethodBeat.o(26141);
  }
  
  public e()
  {
    AppMethodBeat.i(26136);
    this.tTy = new d();
    AppMethodBeat.o(26136);
  }
  
  private static e cWb()
  {
    AppMethodBeat.i(26137);
    az.ayG();
    e locale2 = (e)bz.yz("plugin.label");
    e locale1 = locale2;
    if (locale2 == null)
    {
      locale1 = locale2;
      if (locale2 != null) {}
    }
    try
    {
      locale1 = new e();
      az.ayG().a("plugin.label", locale1);
      return locale1;
    }
    finally
    {
      AppMethodBeat.o(26137);
    }
  }
  
  public static an cWc()
  {
    AppMethodBeat.i(26140);
    g.agP().afT();
    if (cWb().tTx == null)
    {
      localObject = cWb();
      az.ayM();
      ((e)localObject).tTx = new an(c.agw());
    }
    Object localObject = cWb().tTx;
    AppMethodBeat.o(26140);
    return localObject;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(26138);
    b localb = new b();
    com.tencent.mm.plugin.label.a.a.tTz = localb;
    com.tencent.mm.ax.b.hLu = localb;
    com.tencent.mm.sdk.b.a.GpY.c(this.tTy);
    AppMethodBeat.o(26138);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(26139);
    com.tencent.mm.plugin.label.a.a.tTz = null;
    com.tencent.mm.sdk.b.a.GpY.d(this.tTy);
    AppMethodBeat.o(26139);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.e
 * JD-Core Version:    0.7.0.1
 */