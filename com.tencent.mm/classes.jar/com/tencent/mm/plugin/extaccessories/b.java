package com.tencent.mm.plugin.extaccessories;

import com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.sj;
import com.tencent.mm.f.a.sj.a;
import com.tencent.mm.model.be;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.model.ch;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.vfs.q;
import java.util.HashMap;

public final class b
  implements be
{
  String kcB;
  private a wuD;
  
  public static b dhJ()
  {
    AppMethodBeat.i(276216);
    bh.beC();
    b localb2 = (b)ch.RZ("plugin.extaccessories");
    b localb1 = localb2;
    if (localb2 == null)
    {
      Log.w("MicroMsg.extaccessories.SubCoreExtAccessories", "not found in MMCore, new one");
      localb1 = new b();
      bh.beC().a("plugin.extaccessories", localb1);
    }
    AppMethodBeat.o(276216);
    return localb1;
  }
  
  public final void clearPluginData(int paramInt) {}
  
  public final HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public final void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(24545);
    Log.d("MicroMsg.extaccessories.SubCoreExtAccessories", "SubCoreExtAccessories reset");
    if (this.wuD == null) {
      this.wuD = new a();
    }
    EventCenter.instance.addListener(this.wuD);
    bh.aHJ().postToWorkerDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(24540);
        if (!bh.aHB())
        {
          AppMethodBeat.o(24540);
          return;
        }
        if (Util.isNullOrNil(b.a(b.this)))
        {
          AppMethodBeat.o(24540);
          return;
        }
        long l = System.currentTimeMillis();
        Util.deleteOutOfDateFile(b.a(b.this) + "image/spen/", "spen_", 259200000L);
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
    if (this.wuD != null) {
      EventCenter.instance.removeListener(this.wuD);
    }
    AppMethodBeat.o(24546);
  }
  
  public final void onSdcardMount(boolean paramBoolean)
  {
    AppMethodBeat.i(24544);
    bh.beI();
    this.kcB = c.getAccPath();
    q localq = new q(this.kcB);
    if (!localq.ifE()) {
      localq.ifL();
    }
    localq = new q(this.kcB + "image/spen/");
    if (!localq.ifE()) {
      localq.ifL();
    }
    AppMethodBeat.o(24544);
  }
  
  public static final class a
    extends IListener<sj>
  {
    public a()
    {
      AppMethodBeat.i(161363);
      this.__eventId = sj.class.getName().hashCode();
      AppMethodBeat.o(161363);
    }
    
    private boolean a(sj paramsj)
    {
      AppMethodBeat.i(24542);
      if (!(paramsj instanceof sj))
      {
        Log.f("MicroMsg.extaccessories.SubCoreExtAccessories", "mismatched event");
        AppMethodBeat.o(24542);
        return false;
      }
      Log.d("MicroMsg.extaccessories.SubCoreExtAccessories", "RegistSpenBuddyEvent");
      if ((paramsj.fRQ != null) && (paramsj.fRQ.fRS != null) && (paramsj.fRQ.fRR != null)) {}
      try
      {
        new SlookWritingBuddy(paramsj.fRQ.fRS).setImageWritingListener(new SubCoreExtAccessories.RegistSpenBuddyEventListener.1(this, paramsj));
        AppMethodBeat.o(24542);
        return true;
      }
      catch (Exception paramsj)
      {
        for (;;)
        {
          Log.e("MicroMsg.extaccessories.SubCoreExtAccessories", "exception in writingBuddy %s", new Object[] { paramsj.getMessage() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.extaccessories.b
 * JD-Core Version:    0.7.0.1
 */