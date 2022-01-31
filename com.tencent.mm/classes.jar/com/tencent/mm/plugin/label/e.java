package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ai;
import java.util.HashMap;

public class e
  implements at
{
  private static HashMap<Integer, h.d> baseDBFactories;
  private ai nXU;
  private d nXV;
  
  static
  {
    AppMethodBeat.i(22519);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("CONTACT_LABEL_TABLE".hashCode()), new e.1());
    baseDBFactories.put(Integer.valueOf("CONTACT_LABEL_CACHE_TABLE".hashCode()), new h.d()
    {
      public final String[] getSQLs()
      {
        return ah.SQL_CREATE;
      }
    });
    AppMethodBeat.o(22519);
  }
  
  public e()
  {
    AppMethodBeat.i(22514);
    this.nXV = new d();
    AppMethodBeat.o(22514);
  }
  
  private static e bKT()
  {
    AppMethodBeat.i(22515);
    aw.aat();
    e locale2 = (e)bw.pF("plugin.label");
    e locale1 = locale2;
    if (locale2 == null)
    {
      locale1 = locale2;
      if (locale2 != null) {}
    }
    try
    {
      locale1 = new e();
      aw.aat().a("plugin.label", locale1);
      return locale1;
    }
    finally
    {
      AppMethodBeat.o(22515);
    }
  }
  
  public static ai bKU()
  {
    AppMethodBeat.i(22518);
    g.RJ().QQ();
    if (bKT().nXU == null)
    {
      localObject = bKT();
      aw.aaz();
      ((e)localObject).nXU = new ai(c.Rq());
    }
    Object localObject = bKT().nXU;
    AppMethodBeat.o(22518);
    return localObject;
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return baseDBFactories;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(22516);
    b localb = new b();
    com.tencent.mm.plugin.label.a.a.nXW = localb;
    com.tencent.mm.av.b.fHW = localb;
    com.tencent.mm.sdk.b.a.ymk.c(this.nXV);
    AppMethodBeat.o(22516);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(22517);
    com.tencent.mm.plugin.label.a.a.nXW = null;
    com.tencent.mm.sdk.b.a.ymk.d(this.nXV);
    AppMethodBeat.o(22517);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.e
 * JD-Core Version:    0.7.0.1
 */