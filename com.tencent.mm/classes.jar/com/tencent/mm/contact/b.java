package com.tencent.mm.contact;

import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.df;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.Iterator;
import java.util.List;

public final class b
  implements MStorageEx.IOnStorageChange
{
  public static b jxn;
  private volatile boolean jxo;
  private volatile boolean jxp;
  public boolean jxq;
  private IListener<df> jxr;
  
  static
  {
    AppMethodBeat.i(240350);
    jxn = new b();
    AppMethodBeat.o(240350);
  }
  
  private b()
  {
    AppMethodBeat.i(240344);
    this.jxq = true;
    this.jxr = new IListener() {};
    this.jxp = com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.VEf, false);
    this.jxr.alive();
    AppMethodBeat.o(240344);
  }
  
  public final boolean axg()
  {
    return (this.jxp) && (this.jxq);
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(240345);
    if (!(paramObject instanceof String))
    {
      Log.d("MicroMsg.ContactUpgradeHelper", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(240345);
      return;
    }
    Log.i("MicroMsg.ContactUpgradeHelper", "onNotifyChange %s", new Object[] { (String)paramObject });
    if ((paramMStorageEx instanceof bv))
    {
      if (this.jxo)
      {
        AppMethodBeat.o(240345);
        return;
      }
      if (this.jxo)
      {
        Log.i("MicroMsg.ContactUpgradeHelper", "refreshUserName, init done!");
        AppMethodBeat.o(240345);
        return;
      }
      if (this.jxp)
      {
        Log.i("MicroMsg.ContactUpgradeHelper", "refreshUserName, updateUserNameFlag is already done!");
        AppMethodBeat.o(240345);
        return;
      }
      this.jxo = true;
      com.tencent.e.h.ZvG.bf(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(240134);
          Iterator localIterator = ab.beb().iterator();
          while (localIterator.hasNext())
          {
            as localas = (as)localIterator.next();
            localas.Fa(ar.bvF(localas.field_username));
            com.tencent.mm.kernel.h.aHH();
            ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().c(localas.field_username, localas);
          }
          com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VEf, Boolean.TRUE);
          b.a(b.this);
          Log.i("MicroMsg.ContactUpgradeHelper", "refreshUserName, updateUserNameFlag done!");
          AppMethodBeat.o(240134);
        }
      });
    }
    AppMethodBeat.o(240345);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.contact.b
 * JD-Core Version:    0.7.0.1
 */