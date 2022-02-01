package com.tencent.mm.plugin.extaccessories;

import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qq;
import com.tencent.mm.g.a.qq.a;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bc;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.k;
import java.util.HashMap;

public final class b
  implements az
{
  String gDT;
  private a rnd;
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24545);
    ae.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories reset");
    if (this.rnd == null) {
      this.rnd = new a();
    }
    a.IvT.c(this.rnd);
    bc.ajU().n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24540);
        if (!bc.ajM())
        {
          AppMethodBeat.o(24540);
          return;
        }
        if (bu.isNullOrNil(b.this.gDT))
        {
          AppMethodBeat.o(24540);
          return;
        }
        long l = System.currentTimeMillis();
        bu.n(b.this.gDT + "image/spen/", "spen_", 259200000L);
        ae.d("MicroMsg.extaccessories.SubCoreExtAccessories", "deleteOutOfDateFile cost %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(24540);
      }
    }, 5000L);
    AppMethodBeat.o(24545);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24546);
    ae.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories release");
    if (this.rnd != null) {
      a.IvT.d(this.rnd);
    }
    AppMethodBeat.o(24546);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(24544);
    bc.aCg();
    this.gDT = com.tencent.mm.model.c.getAccPath();
    k localk = new k(this.gDT);
    if (!localk.exists()) {
      localk.mkdirs();
    }
    localk = new k(this.gDT + "image/spen/");
    if (!localk.exists()) {
      localk.mkdirs();
    }
    AppMethodBeat.o(24544);
  }
  
  public static final class a
    extends com.tencent.mm.sdk.b.c<qq>
  {
    public a()
    {
      AppMethodBeat.i(161363);
      this.__eventId = qq.class.getName().hashCode();
      AppMethodBeat.o(161363);
    }
    
    private boolean a(qq paramqq)
    {
      AppMethodBeat.i(24542);
      if (!(paramqq instanceof qq))
      {
        ae.f("MicroMsg.extaccessories.SubCoreExtAccessories", "mismatched event");
        AppMethodBeat.o(24542);
        return false;
      }
      ae.d("MicroMsg.extaccessories.SubCoreExtAccessories", "RegistSpenBuddyEvent");
      if ((paramqq.dGo != null) && (paramqq.dGo.dGq != null) && (paramqq.dGo.dGp != null)) {}
      try
      {
        new SlookWritingBuddy(paramqq.dGo.dGq).setImageWritingListener(new SubCoreExtAccessories.RegistSpenBuddyEventListener.1(this, paramqq));
        AppMethodBeat.o(24542);
        return true;
      }
      catch (Exception paramqq)
      {
        for (;;)
        {
          ae.e("MicroMsg.extaccessories.SubCoreExtAccessories", "exception in writingBuddy %s", new Object[] { paramqq.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.extaccessories.b
 * JD-Core Version:    0.7.0.1
 */