package com.tencent.mm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f.a;
import com.tencent.mm.api.j;
import com.tencent.mm.api.z;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.o.b;
import com.tencent.mm.plugin.messenger.foundation.a.ad;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h.b;
import java.util.HashMap;
import kotlin.g.b.s;

public class PluginFunctionMsg
  extends f
  implements z, com.tencent.mm.kernel.api.a, c
{
  private static HashMap<Integer, h.b> fjr;
  private b fjq;
  
  static
  {
    AppMethodBeat.i(114094);
    fjr = new HashMap();
    String str = MAutoStorage.getCreateSQLs(j.info, "FunctionMsgItem");
    fjr.put(Integer.valueOf("FunctionMsgItem".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return PluginFunctionMsg.this;
      }
    });
    AppMethodBeat.o(114094);
  }
  
  public PluginFunctionMsg()
  {
    AppMethodBeat.i(114088);
    this.fjq = new b();
    AppMethodBeat.o(114088);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return fjr;
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
    if (paramg.bbA()) {
      ((m)h.ax(m.class)).addSyncDoCmdCallback(new ad()
      {
        public final void cq(Object paramAnonymousObject)
        {
          AppMethodBeat.i(114085);
          PluginFunctionMsg.this.getReceiver();
          com.tencent.mm.s.a.mpH = true;
          if (com.tencent.mm.s.a.isInit)
          {
            com.tencent.mm.s.a.aXb();
            com.tencent.mm.s.a.isInit = false;
          }
          Log.i("FunctionMsg.FunctionMsgEngine", s.X("[beforeSyncDoCmd] isInit:", Boolean.valueOf(com.tencent.mm.s.a.isInit)));
          AppMethodBeat.o(114085);
        }
        
        public final void cr(Object paramAnonymousObject)
        {
          AppMethodBeat.i(114086);
          PluginFunctionMsg.this.getReceiver();
          com.tencent.mm.s.a.aWZ();
          AppMethodBeat.o(114086);
        }
        
        public final void cs(Object paramAnonymousObject)
        {
          AppMethodBeat.i(114087);
          PluginFunctionMsg.this.getReceiver();
          com.tencent.mm.s.a.mpH = false;
          com.tencent.mm.s.a.aXa();
          Log.i("FunctionMsg.FunctionMsgEngine", "[finishSyncDoCmd] check time:%s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
          AppMethodBeat.o(114087);
        }
      });
    }
    AppMethodBeat.o(114090);
  }
  
  public com.tencent.mm.s.a getReceiver()
  {
    return com.tencent.mm.s.a.mpG;
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(114091);
    f.a.a(this.fjq);
    AppMethodBeat.o(114091);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(114092);
    f.a.b(this.fjq);
    AppMethodBeat.o(114092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.PluginFunctionMsg
 * JD-Core Version:    0.7.0.1
 */