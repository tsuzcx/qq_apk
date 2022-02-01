package com.tencent.mm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.g.a;
import com.tencent.mm.api.i;
import com.tencent.mm.api.y;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.ad;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.r.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;

public class PluginFunctionMsg
  extends f
  implements y, com.tencent.mm.kernel.api.a, c
{
  private static HashMap<Integer, h.b> djv;
  private b dju;
  
  static
  {
    AppMethodBeat.i(114094);
    djv = new HashMap();
    String str = MAutoStorage.getCreateSQLs(i.info, "FunctionMsgItem");
    djv.put(Integer.valueOf("FunctionMsgItem".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return this.djx;
      }
    });
    AppMethodBeat.o(114094);
  }
  
  public PluginFunctionMsg()
  {
    AppMethodBeat.i(114088);
    this.dju = new b();
    AppMethodBeat.o(114088);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return djv;
  }
  
  public void configure(g paramg)
  {
    AppMethodBeat.i(114089);
    super.configure(paramg);
    h.b(k.class, getReceiver());
    AppMethodBeat.o(114089);
  }
  
  public void execute(g paramg)
  {
    AppMethodBeat.i(114090);
    if (paramg.aIE()) {
      ((m)h.ae(m.class)).addSyncDoCmdCallback(new ad()
      {
        public final void aU(Object paramAnonymousObject)
        {
          AppMethodBeat.i(114085);
          PluginFunctionMsg.this.getReceiver();
          com.tencent.mm.u.a.jQz = true;
          if (com.tencent.mm.u.a.isInit)
          {
            com.tencent.mm.u.a.aDY();
            com.tencent.mm.u.a.isInit = false;
          }
          Log.i("FunctionMsg.FunctionMsgEngine", "[beforeSyncDoCmd] isInit:" + com.tencent.mm.u.a.isInit);
          AppMethodBeat.o(114085);
        }
        
        public final void aV(Object paramAnonymousObject)
        {
          AppMethodBeat.i(114086);
          PluginFunctionMsg.this.getReceiver();
          com.tencent.mm.u.a.aDW();
          AppMethodBeat.o(114086);
        }
        
        public final void aW(Object paramAnonymousObject)
        {
          AppMethodBeat.i(114087);
          PluginFunctionMsg.this.getReceiver();
          com.tencent.mm.u.a.jQz = false;
          com.tencent.mm.u.a.aDX();
          Log.i("FunctionMsg.FunctionMsgEngine", "[finishSyncDoCmd] check time:%s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
          AppMethodBeat.o(114087);
        }
      });
    }
    AppMethodBeat.o(114090);
  }
  
  public com.tencent.mm.u.a getReceiver()
  {
    return com.tencent.mm.u.a.jQF;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(114091);
    g.a.a(this.dju);
    AppMethodBeat.o(114091);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(114092);
    g.a.b(this.dju);
    AppMethodBeat.o(114092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.PluginFunctionMsg
 * JD-Core Version:    0.7.0.1
 */