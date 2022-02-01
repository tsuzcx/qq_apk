package com.tencent.mm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.d.a;
import com.tencent.mm.api.h;
import com.tencent.mm.api.v;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.y;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.t.b;
import com.tencent.mm.v.e;
import java.util.HashMap;

public class PluginFunctionMsg
  extends f
  implements v, com.tencent.mm.kernel.api.a, c
{
  private static HashMap<Integer, h.b> cPe;
  private b cPd;
  
  static
  {
    AppMethodBeat.i(114094);
    cPe = new HashMap();
    String str = j.getCreateSQLs(h.info, "FunctionMsgItem");
    cPe.put(Integer.valueOf("FunctionMsgItem".hashCode()), new PluginFunctionMsg.2(new String[] { str }));
    AppMethodBeat.o(114094);
  }
  
  public PluginFunctionMsg()
  {
    AppMethodBeat.i(114088);
    this.cPd = new b();
    AppMethodBeat.o(114088);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return cPe;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(114089);
    super.configure(paramg);
    com.tencent.mm.kernel.g.b(i.class, getReceiver());
    AppMethodBeat.o(114089);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(114090);
    if (paramg.akw()) {
      ((k)com.tencent.mm.kernel.g.ab(k.class)).addSyncDoCmdCallback(new y()
      {
        public final void aI(Object paramAnonymousObject)
        {
          AppMethodBeat.i(114085);
          PluginFunctionMsg.this.getReceiver();
          if (com.tencent.mm.v.a.cAX)
          {
            com.tencent.mm.v.a.agt();
            com.tencent.mm.v.a.cAX = false;
          }
          ad.i("FunctionMsg.FunctionMsgEngine", "[beforeSyncDoCmd] isInit:" + com.tencent.mm.v.a.cAX);
          AppMethodBeat.o(114085);
        }
        
        public final void aJ(Object paramAnonymousObject)
        {
          AppMethodBeat.i(114086);
          PluginFunctionMsg.this.getReceiver();
          if (com.tencent.mm.v.a.ags())
          {
            com.tencent.mm.v.a.gqA.agv();
            com.tencent.mm.v.a.cOF = System.currentTimeMillis();
            com.tencent.mm.v.a.gqB = false;
            ad.i("FunctionMsg.FunctionMsgEngine", "[afterSyncDoCmd] check time:%s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
          }
          AppMethodBeat.o(114086);
        }
        
        public final void aK(Object paramAnonymousObject)
        {
          AppMethodBeat.i(114087);
          PluginFunctionMsg.this.getReceiver();
          if (com.tencent.mm.v.a.ags())
          {
            com.tencent.mm.v.a.gqA.agv();
            com.tencent.mm.v.a.cOF = System.currentTimeMillis();
            com.tencent.mm.v.a.gqB = false;
            ad.i("FunctionMsg.FunctionMsgEngine", "[finishSyncDoCmd] check time:%s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
          }
          AppMethodBeat.o(114087);
        }
      });
    }
    AppMethodBeat.o(114090);
  }
  
  public com.tencent.mm.v.a getReceiver()
  {
    return com.tencent.mm.v.a.gqD;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(114091);
    d.a.a(this.cPd);
    AppMethodBeat.o(114091);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(114092);
    d.a.b(this.cPd);
    AppMethodBeat.o(114092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.PluginFunctionMsg
 * JD-Core Version:    0.7.0.1
 */