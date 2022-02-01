package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class e
  implements bd
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private ax yBQ;
  private d yBR;
  
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
    this.yBR = new d();
    AppMethodBeat.o(26136);
  }
  
  private static e ece()
  {
    AppMethodBeat.i(26137);
    bg.aVz();
    e locale2 = (e)cg.KG("plugin.label");
    e locale1 = locale2;
    if (locale2 == null)
    {
      locale1 = locale2;
      if (locale2 != null) {}
    }
    try
    {
      locale1 = new e();
      bg.aVz().a("plugin.label", locale1);
      return locale1;
    }
    finally
    {
      AppMethodBeat.o(26137);
    }
  }
  
  public static ax ecf()
  {
    AppMethodBeat.i(26140);
    g.aAf().azk();
    if (ece().yBQ == null)
    {
      localObject = ece();
      bg.aVF();
      ((e)localObject).yBQ = new ax(c.getDataDB());
    }
    Object localObject = ece().yBQ;
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
    com.tencent.mm.plugin.label.a.a.yBS = localb;
    com.tencent.mm.ax.b.jcc = localb;
    EventCenter.instance.addListener(this.yBR);
    AppMethodBeat.o(26138);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(26139);
    com.tencent.mm.plugin.label.a.a.yBS = null;
    EventCenter.instance.removeListener(this.yBR);
    AppMethodBeat.o(26139);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.label.e
 * JD-Core Version:    0.7.0.1
 */