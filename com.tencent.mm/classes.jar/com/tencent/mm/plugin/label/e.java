package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.c;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class e
  implements aw
{
  private static HashMap<Integer, h.b> baseDBFactories;
  private ak sLS;
  private d sLT;
  
  static
  {
    AppMethodBeat.i(26141);
    HashMap localHashMap = new HashMap();
    baseDBFactories = localHashMap;
    localHashMap.put(Integer.valueOf("CONTACT_LABEL_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return ak.SQL_CREATE;
      }
    });
    baseDBFactories.put(Integer.valueOf("CONTACT_LABEL_CACHE_TABLE".hashCode()), new e.2());
    AppMethodBeat.o(26141);
  }
  
  public e()
  {
    AppMethodBeat.i(26136);
    this.sLT = new d();
    AppMethodBeat.o(26136);
  }
  
  private static e cIQ()
  {
    AppMethodBeat.i(26137);
    az.arP();
    e locale2 = (e)bz.ut("plugin.label");
    e locale1 = locale2;
    if (locale2 == null)
    {
      locale1 = locale2;
      if (locale2 != null) {}
    }
    try
    {
      locale1 = new e();
      az.arP().a("plugin.label", locale1);
      return locale1;
    }
    finally
    {
      AppMethodBeat.o(26137);
    }
  }
  
  public static ak cIR()
  {
    AppMethodBeat.i(26140);
    g.afz().aeD();
    if (cIQ().sLS == null)
    {
      localObject = cIQ();
      az.arV();
      ((e)localObject).sLS = new ak(c.afg());
    }
    Object localObject = cIQ().sLS;
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
    com.tencent.mm.plugin.label.a.a.sLU = localb;
    com.tencent.mm.ay.b.hkR = localb;
    com.tencent.mm.sdk.b.a.ESL.c(this.sLT);
    AppMethodBeat.o(26138);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(26139);
    com.tencent.mm.plugin.label.a.a.sLU = null;
    com.tencent.mm.sdk.b.a.ESL.d(this.sLT);
    AppMethodBeat.o(26139);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.label.e
 * JD-Core Version:    0.7.0.1
 */