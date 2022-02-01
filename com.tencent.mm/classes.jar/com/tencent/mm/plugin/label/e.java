package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ch;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class e
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private ax Edg;
  private d Edh;
  
  static
  {
    AppMethodBeat.i(26141);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("CONTACT_LABEL_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ax.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("CONTACT_LABEL_CACHE_TABLE".hashCode()), new e.2());
    AppMethodBeat.o(26141);
  }
  
  public e()
  {
    AppMethodBeat.i(26136);
    this.Edh = new d();
    AppMethodBeat.o(26136);
  }
  
  private static e eLc()
  {
    AppMethodBeat.i(26137);
    bh.beC();
    e locale2 = (e)ch.RZ("plugin.label");
    e locale1 = locale2;
    if (locale2 == null)
    {
      locale1 = locale2;
      if (locale2 != null) {}
    }
    try
    {
      locale1 = new e();
      bh.beC().a("plugin.label", locale1);
      return locale1;
    }
    finally
    {
      AppMethodBeat.o(26137);
    }
  }
  
  public static ax eLd()
  {
    AppMethodBeat.i(26140);
    h.aHE().aGH();
    if (eLc().Edg == null)
    {
      localObject = eLc();
      bh.beI();
      ((e)localObject).Edg = new ax(c.getDataDB());
    }
    Object localObject = eLc().Edg;
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
    com.tencent.mm.plugin.label.a.a.Edi = localb;
    com.tencent.mm.ba.b.lSC = localb;
    EventCenter.instance.addListener(this.Edh);
    AppMethodBeat.o(26138);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(26139);
    com.tencent.mm.plugin.label.a.a.Edi = null;
    EventCenter.instance.removeListener(this.Edh);
    AppMethodBeat.o(26139);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.e
 * JD-Core Version:    0.7.0.1
 */