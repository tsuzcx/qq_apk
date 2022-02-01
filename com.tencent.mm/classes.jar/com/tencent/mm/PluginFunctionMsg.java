package com.tencent.mm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.g.a;
import com.tencent.mm.api.y;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.z;
import com.tencent.mm.r.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.u.e;
import java.util.HashMap;

public class PluginFunctionMsg
  extends f
  implements y, com.tencent.mm.kernel.api.a, c
{
  private static HashMap<Integer, h.b> dgj;
  private b dgi;
  
  static
  {
    AppMethodBeat.i(114094);
    dgj = new HashMap();
    String str = MAutoStorage.getCreateSQLs(com.tencent.mm.api.i.info, "FunctionMsgItem");
    dgj.put(Integer.valueOf("FunctionMsgItem".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return this.dgl;
      }
    });
    AppMethodBeat.o(114094);
  }
  
  public PluginFunctionMsg()
  {
    AppMethodBeat.i(114088);
    this.dgi = new b();
    AppMethodBeat.o(114088);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return dgj;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(114089);
    super.configure(paramg);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.foundation.a.i.class, getReceiver());
    AppMethodBeat.o(114089);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(114090);
    if (paramg.aBb()) {
      ((k)com.tencent.mm.kernel.g.af(k.class)).addSyncDoCmdCallback(new z()
      {
        public final void aQ(Object paramAnonymousObject)
        {
          AppMethodBeat.i(114085);
          PluginFunctionMsg.this.getReceiver();
          if (com.tencent.mm.u.a.isInit)
          {
            com.tencent.mm.u.a.awG();
            com.tencent.mm.u.a.isInit = false;
          }
          Log.i("FunctionMsg.FunctionMsgEngine", "[beforeSyncDoCmd] isInit:" + com.tencent.mm.u.a.isInit);
          AppMethodBeat.o(114085);
        }
        
        public final void aR(Object paramAnonymousObject)
        {
          AppMethodBeat.i(114086);
          PluginFunctionMsg.this.getReceiver();
          if (com.tencent.mm.u.a.awF())
          {
            com.tencent.mm.u.a.heK.awI();
            com.tencent.mm.u.a.dfO = System.currentTimeMillis();
            com.tencent.mm.u.a.heL = false;
            Log.i("FunctionMsg.FunctionMsgEngine", "[afterSyncDoCmd] check time:%s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
          }
          AppMethodBeat.o(114086);
        }
        
        public final void aS(Object paramAnonymousObject)
        {
          AppMethodBeat.i(114087);
          PluginFunctionMsg.this.getReceiver();
          if (com.tencent.mm.u.a.awF())
          {
            com.tencent.mm.u.a.heK.awI();
            com.tencent.mm.u.a.dfO = System.currentTimeMillis();
            com.tencent.mm.u.a.heL = false;
            Log.i("FunctionMsg.FunctionMsgEngine", "[finishSyncDoCmd] check time:%s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
          }
          AppMethodBeat.o(114087);
        }
      });
    }
    AppMethodBeat.o(114090);
  }
  
  public com.tencent.mm.u.a getReceiver()
  {
    return com.tencent.mm.u.a.heN;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(114091);
    g.a.a(this.dgi);
    AppMethodBeat.o(114091);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(114092);
    g.a.b(this.dgi);
    AppMethodBeat.o(114092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.PluginFunctionMsg
 * JD-Core Version:    0.7.0.1
 */