package com.tencent.mm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.e.a;
import com.tencent.mm.api.v;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.w;
import com.tencent.mm.s.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.u.e;
import java.util.HashMap;

public class PluginFunctionMsg
  extends f
  implements v, com.tencent.mm.kernel.api.a, c
{
  private static HashMap<Integer, h.b> cGR;
  private b cGQ;
  
  static
  {
    AppMethodBeat.i(114094);
    cGR = new HashMap();
    String str = com.tencent.mm.sdk.e.j.getCreateSQLs(com.tencent.mm.api.h.info, "FunctionMsgItem");
    cGR.put(Integer.valueOf("FunctionMsgItem".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return this.cGT;
      }
    });
    AppMethodBeat.o(114094);
  }
  
  public PluginFunctionMsg()
  {
    AppMethodBeat.i(114088);
    this.cGQ = new b();
    AppMethodBeat.o(114088);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return cGR;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(114089);
    super.configure(paramg);
    com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.messenger.foundation.a.h.class, getReceiver());
    AppMethodBeat.o(114089);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(114090);
    if (paramg.agu()) {
      ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.j.class)).addSyncDoCmdCallback(new w()
      {
        public final void aJ(Object paramAnonymousObject)
        {
          AppMethodBeat.i(114085);
          PluginFunctionMsg.this.getReceiver();
          if (com.tencent.mm.u.a.csX)
          {
            com.tencent.mm.u.a.acH();
            com.tencent.mm.u.a.csX = false;
          }
          ad.i("FunctionMsg.FunctionMsgEngine", "[beforeSyncDoCmd] isInit:" + com.tencent.mm.u.a.csX);
          AppMethodBeat.o(114085);
        }
        
        public final void aK(Object paramAnonymousObject)
        {
          AppMethodBeat.i(114086);
          PluginFunctionMsg.this.getReceiver();
          if (com.tencent.mm.u.a.acG())
          {
            com.tencent.mm.u.a.fTk.acJ();
            com.tencent.mm.u.a.cGs = System.currentTimeMillis();
            com.tencent.mm.u.a.fTl = false;
            ad.i("FunctionMsg.FunctionMsgEngine", "[afterSyncDoCmd] check time:%s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
          }
          AppMethodBeat.o(114086);
        }
        
        public final void aL(Object paramAnonymousObject)
        {
          AppMethodBeat.i(114087);
          PluginFunctionMsg.this.getReceiver();
          if (com.tencent.mm.u.a.acG())
          {
            com.tencent.mm.u.a.fTk.acJ();
            com.tencent.mm.u.a.cGs = System.currentTimeMillis();
            com.tencent.mm.u.a.fTl = false;
            ad.i("FunctionMsg.FunctionMsgEngine", "[finishSyncDoCmd] check time:%s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
          }
          AppMethodBeat.o(114087);
        }
      });
    }
    AppMethodBeat.o(114090);
  }
  
  public com.tencent.mm.u.a getReceiver()
  {
    return com.tencent.mm.u.a.fTn;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(114091);
    e.a.a(this.cGQ);
    AppMethodBeat.o(114091);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(114092);
    e.a.b(this.cGQ);
    AppMethodBeat.o(114092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.PluginFunctionMsg
 * JD-Core Version:    0.7.0.1
 */