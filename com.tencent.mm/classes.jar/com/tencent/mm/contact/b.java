package com.tencent.mm.contact;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dp;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ab;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.threadpool.i;
import java.util.Iterator;
import java.util.List;

public final class b
  implements MStorageEx.IOnStorageChange
{
  public static b maH;
  private volatile boolean maI;
  private volatile boolean maJ;
  public boolean maK;
  private IListener<dp> maL;
  
  static
  {
    AppMethodBeat.i(233777);
    maH = new b();
    AppMethodBeat.o(233777);
  }
  
  private b()
  {
    AppMethodBeat.i(233768);
    this.maK = true;
    this.maL = new ContactUpgradeHelper.1(this, com.tencent.mm.app.f.hfK);
    this.maJ = com.tencent.mm.kernel.h.baE().ban().getBoolean(at.a.adhq, false);
    this.maL.alive();
    AppMethodBeat.o(233768);
  }
  
  public final boolean aRG()
  {
    return (this.maJ) && (this.maK);
  }
  
  public final void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(233785);
    if (!(paramObject instanceof String))
    {
      Log.d("MicroMsg.ContactUpgradeHelper", "onNotifyChange obj not String event:%d stg:%s obj:%s", new Object[] { Integer.valueOf(paramInt), paramMStorageEx, paramObject });
      AppMethodBeat.o(233785);
      return;
    }
    Log.i("MicroMsg.ContactUpgradeHelper", "onNotifyChange %s", new Object[] { (String)paramObject });
    if ((paramMStorageEx instanceof bx))
    {
      if (this.maI)
      {
        AppMethodBeat.o(233785);
        return;
      }
      if (this.maI)
      {
        Log.i("MicroMsg.ContactUpgradeHelper", "refreshUserName, init done!");
        AppMethodBeat.o(233785);
        return;
      }
      if (this.maJ)
      {
        Log.i("MicroMsg.ContactUpgradeHelper", "refreshUserName, updateUserNameFlag is already done!");
        AppMethodBeat.o(233785);
        return;
      }
      this.maI = true;
      com.tencent.threadpool.h.ahAA.bn(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(233769);
          Iterator localIterator = ab.bBS().iterator();
          while (localIterator.hasNext())
          {
            au localau = (au)localIterator.next();
            localau.hs(at.bvQ(localau.field_username));
            com.tencent.mm.kernel.h.baF();
            ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().d(localau.field_username, localau);
          }
          com.tencent.mm.kernel.h.baE().ban().set(at.a.adhq, Boolean.TRUE);
          b.a(b.this);
          Log.i("MicroMsg.ContactUpgradeHelper", "refreshUserName, updateUserNameFlag done!");
          AppMethodBeat.o(233769);
        }
      });
    }
    AppMethodBeat.o(233785);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.contact.b
 * JD-Core Version:    0.7.0.1
 */