package com.tencent.mm.plugin.extaccessories;

import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qp;
import com.tencent.mm.g.a.qp.a;
import com.tencent.mm.model.ax;
import com.tencent.mm.model.ba;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.e;
import java.util.HashMap;

public final class b
  implements ax
{
  String gBm;
  private a rfa;
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24545);
    ad.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories reset");
    if (this.rfa == null) {
      this.rfa = new a();
    }
    a.IbL.c(this.rfa);
    ba.ajF().n(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24540);
        if (!ba.ajx())
        {
          AppMethodBeat.o(24540);
          return;
        }
        if (bt.isNullOrNil(b.this.gBm))
        {
          AppMethodBeat.o(24540);
          return;
        }
        long l = System.currentTimeMillis();
        bt.n(b.this.gBm + "image/spen/", "spen_", 259200000L);
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
    if (this.rfa != null) {
      a.IbL.d(this.rfa);
    }
    AppMethodBeat.o(24546);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(24544);
    ba.aBQ();
    this.gBm = com.tencent.mm.model.c.getAccPath();
    e locale = new e(this.gBm);
    if (!locale.exists()) {
      locale.mkdirs();
    }
    locale = new e(this.gBm + "image/spen/");
    if (!locale.exists()) {
      locale.mkdirs();
    }
    AppMethodBeat.o(24544);
  }
  
  public static final class a
    extends com.tencent.mm.sdk.b.c<qp>
  {
    public a()
    {
      AppMethodBeat.i(161363);
      this.__eventId = qp.class.getName().hashCode();
      AppMethodBeat.o(161363);
    }
    
    private boolean a(qp paramqp)
    {
      AppMethodBeat.i(24542);
      if (!(paramqp instanceof qp))
      {
        ad.f("MicroMsg.extaccessories.SubCoreExtAccessories", "mismatched event");
        AppMethodBeat.o(24542);
        return false;
      }
      ad.d("MicroMsg.extaccessories.SubCoreExtAccessories", "RegistSpenBuddyEvent");
      if ((paramqp.dFj != null) && (paramqp.dFj.dFl != null) && (paramqp.dFj.dFk != null)) {}
      try
      {
        new SlookWritingBuddy(paramqp.dFj.dFl).setImageWritingListener(new SubCoreExtAccessories.RegistSpenBuddyEventListener.1(this, paramqp));
        AppMethodBeat.o(24542);
        return true;
      }
      catch (Exception paramqp)
      {
        for (;;)
        {
          ad.e("MicroMsg.extaccessories.SubCoreExtAccessories", "exception in writingBuddy %s", new Object[] { paramqp.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.extaccessories.b
 * JD-Core Version:    0.7.0.1
 */