package com.tencent.mm.plugin.extaccessories;

import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rk;
import com.tencent.mm.g.a.rk.a;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.o;
import java.util.HashMap;

public final class b
  implements bd
{
  String hqG;
  private a sOI;
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24545);
    Log.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories reset");
    if (this.sOI == null) {
      this.sOI = new a();
    }
    EventCenter.instance.addListener(this.sOI);
    bg.aAk().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24540);
        if (!bg.aAc())
        {
          AppMethodBeat.o(24540);
          return;
        }
        if (Util.isNullOrNil(b.this.hqG))
        {
          AppMethodBeat.o(24540);
          return;
        }
        long l = System.currentTimeMillis();
        Util.deleteOutOfDateFile(b.this.hqG + "image/spen/", "spen_", 259200000L);
        Log.d("MicroMsg.extaccessories.SubCoreExtAccessories", "deleteOutOfDateFile cost %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        AppMethodBeat.o(24540);
      }
    }, 5000L);
    AppMethodBeat.o(24545);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(24546);
    Log.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories release");
    if (this.sOI != null) {
      EventCenter.instance.removeListener(this.sOI);
    }
    AppMethodBeat.o(24546);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(24544);
    bg.aVF();
    this.hqG = c.getAccPath();
    o localo = new o(this.hqG);
    if (!localo.exists()) {
      localo.mkdirs();
    }
    localo = new o(this.hqG + "image/spen/");
    if (!localo.exists()) {
      localo.mkdirs();
    }
    AppMethodBeat.o(24544);
  }
  
  public static final class a
    extends IListener<rk>
  {
    public a()
    {
      AppMethodBeat.i(161363);
      this.__eventId = rk.class.getName().hashCode();
      AppMethodBeat.o(161363);
    }
    
    private boolean a(rk paramrk)
    {
      AppMethodBeat.i(24542);
      if (!(paramrk instanceof rk))
      {
        Log.f("MicroMsg.extaccessories.SubCoreExtAccessories", "mismatched event");
        AppMethodBeat.o(24542);
        return false;
      }
      Log.d("MicroMsg.extaccessories.SubCoreExtAccessories", "RegistSpenBuddyEvent");
      if ((paramrk.dXZ != null) && (paramrk.dXZ.dYb != null) && (paramrk.dXZ.dYa != null)) {}
      try
      {
        new SlookWritingBuddy(paramrk.dXZ.dYb).setImageWritingListener(new SubCoreExtAccessories.RegistSpenBuddyEventListener.1(this, paramrk));
        AppMethodBeat.o(24542);
        return true;
      }
      catch (Exception paramrk)
      {
        for (;;)
        {
          Log.e("MicroMsg.extaccessories.SubCoreExtAccessories", "exception in writingBuddy %s", new Object[] { paramrk.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.extaccessories.b
 * JD-Core Version:    0.7.0.1
 */