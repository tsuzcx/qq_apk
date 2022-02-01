package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ca;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class e
  implements ax
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private ar uVZ;
  private d uWa;
  
  static
  {
    AppMethodBeat.i(26141);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("CONTACT_LABEL_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ar.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("CONTACT_LABEL_CACHE_TABLE".hashCode()), new e.2());
    AppMethodBeat.o(26141);
  }
  
  public e()
  {
    AppMethodBeat.i(26136);
    this.uWa = new d();
    AppMethodBeat.o(26136);
  }
  
  private static e dfm()
  {
    AppMethodBeat.i(26137);
    ba.aBK();
    e locale2 = (e)ca.By("plugin.label");
    e locale1 = locale2;
    if (locale2 == null)
    {
      locale1 = locale2;
      if (locale2 != null) {}
    }
    try
    {
      locale1 = new e();
      ba.aBK().a("plugin.label", locale1);
      return locale1;
    }
    finally
    {
      AppMethodBeat.o(26137);
    }
  }
  
  public static ar dfn()
  {
    AppMethodBeat.i(26140);
    g.ajA().aiF();
    if (dfm().uVZ == null)
    {
      localObject = dfm();
      ba.aBQ();
      ((e)localObject).uVZ = new ar(c.getDataDB());
    }
    Object localObject = dfm().uVZ;
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
    com.tencent.mm.plugin.label.a.a.uWb = localb;
    com.tencent.mm.ay.b.iep = localb;
    com.tencent.mm.sdk.b.a.IbL.c(this.uWa);
    AppMethodBeat.o(26138);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(26139);
    com.tencent.mm.plugin.label.a.a.uWb = null;
    com.tencent.mm.sdk.b.a.IbL.d(this.uWa);
    AppMethodBeat.o(26139);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.e
 * JD-Core Version:    0.7.0.1
 */