package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ci;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.az;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class d
  implements be
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private az JUf;
  private PostTaskGetContactLabelListListener JUg;
  
  static
  {
    AppMethodBeat.i(26141);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("CONTACT_LABEL_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return az.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("CONTACT_LABEL_CACHE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ay.SQL_CREATE;
      }
    });
    AppMethodBeat.o(26141);
  }
  
  public d()
  {
    AppMethodBeat.i(26136);
    this.JUg = new PostTaskGetContactLabelListListener();
    AppMethodBeat.o(26136);
  }
  
  private static d fSZ()
  {
    AppMethodBeat.i(26137);
    bh.bCt();
    d locald2 = (d)ci.Ka("plugin.label");
    d locald1 = locald2;
    if (locald2 == null)
    {
      locald1 = locald2;
      if (locald2 != null) {}
    }
    try
    {
      locald1 = new d();
      bh.bCt().a("plugin.label", locald1);
      return locald1;
    }
    finally
    {
      AppMethodBeat.o(26137);
    }
  }
  
  public static az fTa()
  {
    AppMethodBeat.i(26140);
    h.baC().aZJ();
    if (fSZ().JUf == null)
    {
      localObject = fSZ();
      bh.bCz();
      ((d)localObject).JUf = new az(c.getDataDB());
    }
    Object localObject = fSZ().JUf;
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
    com.tencent.mm.plugin.label.a.a.JUh = localb;
    com.tencent.mm.av.b.oLo = localb;
    this.JUg.alive();
    AppMethodBeat.o(26138);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(26139);
    com.tencent.mm.plugin.label.a.a.JUh = null;
    this.JUg.dead();
    AppMethodBeat.o(26139);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.d
 * JD-Core Version:    0.7.0.1
 */