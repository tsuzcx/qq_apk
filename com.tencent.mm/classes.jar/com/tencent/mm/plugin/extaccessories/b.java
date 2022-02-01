package com.tencent.mm.plugin.extaccessories;

import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.pv;
import com.tencent.mm.g.a.pv.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.e;
import java.util.HashMap;

public final class b
  implements aw
{
  String gcW;
  private a pMC;
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24545);
    ad.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories reset");
    if (this.pMC == null) {
      this.pMC = new a();
    }
    a.ESL.c(this.pMC);
    az.afE().m(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24540);
        if (!az.afw())
        {
          AppMethodBeat.o(24540);
          return;
        }
        if (bt.isNullOrNil(b.this.gcW))
        {
          AppMethodBeat.o(24540);
          return;
        }
        long l = System.currentTimeMillis();
        bt.z(b.this.gcW + "image/spen/", "spen_", 259200000L);
        ad.d("MicroMsg.extaccessories.SubCoreExtAccessories", "deleteOutOfDateFile cost %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(24540);
      }
    }, 5000L);
    AppMethodBeat.o(24545);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24546);
    ad.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories release");
    if (this.pMC != null) {
      a.ESL.d(this.pMC);
    }
    AppMethodBeat.o(24546);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(24544);
    az.arV();
    this.gcW = com.tencent.mm.model.c.getAccPath();
    e locale = new e(this.gcW);
    if (!locale.exists()) {
      locale.mkdirs();
    }
    locale = new e(this.gcW + "image/spen/");
    if (!locale.exists()) {
      locale.mkdirs();
    }
    AppMethodBeat.o(24544);
  }
  
  public static final class a
    extends com.tencent.mm.sdk.b.c<pv>
  {
    public a()
    {
      AppMethodBeat.i(161363);
      this.__eventId = pv.class.getName().hashCode();
      AppMethodBeat.o(161363);
    }
    
    private boolean a(pv parampv)
    {
      AppMethodBeat.i(24542);
      if (!(parampv instanceof pv))
      {
        ad.f("MicroMsg.extaccessories.SubCoreExtAccessories", "mismatched event");
        AppMethodBeat.o(24542);
        return false;
      }
      ad.d("MicroMsg.extaccessories.SubCoreExtAccessories", "RegistSpenBuddyEvent");
      if ((parampv.dvv != null) && (parampv.dvv.dvx != null) && (parampv.dvv.dvw != null)) {}
      try
      {
        new SlookWritingBuddy(parampv.dvv.dvx).setImageWritingListener(new SubCoreExtAccessories.RegistSpenBuddyEventListener.1(this, parampv));
        AppMethodBeat.o(24542);
        return true;
      }
      catch (Exception parampv)
      {
        for (;;)
        {
          ad.e("MicroMsg.extaccessories.SubCoreExtAccessories", "exception in writingBuddy %s", new Object[] { parampv.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.extaccessories.b
 * JD-Core Version:    0.7.0.1
 */