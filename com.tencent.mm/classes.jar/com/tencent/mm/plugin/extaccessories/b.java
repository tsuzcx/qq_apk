package com.tencent.mm.plugin.extaccessories;

import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qe;
import com.tencent.mm.g.a.qe.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.az;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.e;
import java.util.HashMap;

public final class b
  implements aw
{
  String ghC;
  private a qvk;
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24545);
    ac.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories reset");
    if (this.qvk == null) {
      this.qvk = new a();
    }
    a.GpY.c(this.qvk);
    az.agU().m(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24540);
        if (!az.agM())
        {
          AppMethodBeat.o(24540);
          return;
        }
        if (bs.isNullOrNil(b.this.ghC))
        {
          AppMethodBeat.o(24540);
          return;
        }
        long l = System.currentTimeMillis();
        bs.z(b.this.ghC + "image/spen/", "spen_", 259200000L);
        ac.d("MicroMsg.extaccessories.SubCoreExtAccessories", "deleteOutOfDateFile cost %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(24540);
      }
    }, 5000L);
    AppMethodBeat.o(24545);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24546);
    ac.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories release");
    if (this.qvk != null) {
      a.GpY.d(this.qvk);
    }
    AppMethodBeat.o(24546);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(24544);
    az.ayM();
    this.ghC = com.tencent.mm.model.c.getAccPath();
    e locale = new e(this.ghC);
    if (!locale.exists()) {
      locale.mkdirs();
    }
    locale = new e(this.ghC + "image/spen/");
    if (!locale.exists()) {
      locale.mkdirs();
    }
    AppMethodBeat.o(24544);
  }
  
  public static final class a
    extends com.tencent.mm.sdk.b.c<qe>
  {
    public a()
    {
      AppMethodBeat.i(161363);
      this.__eventId = qe.class.getName().hashCode();
      AppMethodBeat.o(161363);
    }
    
    private boolean a(qe paramqe)
    {
      AppMethodBeat.i(24542);
      if (!(paramqe instanceof qe))
      {
        ac.f("MicroMsg.extaccessories.SubCoreExtAccessories", "mismatched event");
        AppMethodBeat.o(24542);
        return false;
      }
      ac.d("MicroMsg.extaccessories.SubCoreExtAccessories", "RegistSpenBuddyEvent");
      if ((paramqe.dth != null) && (paramqe.dth.dtj != null) && (paramqe.dth.dti != null)) {}
      try
      {
        new SlookWritingBuddy(paramqe.dth.dtj).setImageWritingListener(new SubCoreExtAccessories.RegistSpenBuddyEventListener.1(this, paramqe));
        AppMethodBeat.o(24542);
        return true;
      }
      catch (Exception paramqe)
      {
        for (;;)
        {
          ac.e("MicroMsg.extaccessories.SubCoreExtAccessories", "exception in writingBuddy %s", new Object[] { paramqe.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.extaccessories.b
 * JD-Core Version:    0.7.0.1
 */