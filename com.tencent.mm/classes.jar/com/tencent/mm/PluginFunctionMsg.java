package com.tencent.mm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.api.h;
import com.tencent.mm.api.v;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.z;
import com.tencent.mm.s.b;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.u.e;
import java.util.HashMap;

public class PluginFunctionMsg
  extends f
  implements v, com.tencent.mm.kernel.api.a, c
{
  private static HashMap<Integer, h.b> cPO;
  private b cPN;
  
  static
  {
    AppMethodBeat.i(114094);
    cPO = new HashMap();
    String str = j.getCreateSQLs(h.info, "FunctionMsgItem");
    cPO.put(Integer.valueOf("FunctionMsgItem".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return this.cPQ;
      }
    });
    AppMethodBeat.o(114094);
  }
  
  public PluginFunctionMsg()
  {
    AppMethodBeat.i(114088);
    this.cPN = new b();
    AppMethodBeat.o(114088);
  }
  
  public HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return cPO;
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
    if (paramg.akL()) {
      ((k)com.tencent.mm.kernel.g.ab(k.class)).addSyncDoCmdCallback(new z()
      {
        public final void aI(Object paramAnonymousObject)
        {
          AppMethodBeat.i(114085);
          PluginFunctionMsg.this.getReceiver();
          if (com.tencent.mm.u.a.cBE)
          {
            com.tencent.mm.u.a.agH();
            com.tencent.mm.u.a.cBE = false;
          }
          ae.i("FunctionMsg.FunctionMsgEngine", "[beforeSyncDoCmd] isInit:" + com.tencent.mm.u.a.cBE);
          AppMethodBeat.o(114085);
        }
        
        public final void aJ(Object paramAnonymousObject)
        {
          AppMethodBeat.i(114086);
          PluginFunctionMsg.this.getReceiver();
          if (com.tencent.mm.u.a.agG())
          {
            com.tencent.mm.u.a.gta.agJ();
            com.tencent.mm.u.a.cPp = System.currentTimeMillis();
            com.tencent.mm.u.a.gtb = false;
            ae.i("FunctionMsg.FunctionMsgEngine", "[afterSyncDoCmd] check time:%s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
          }
          AppMethodBeat.o(114086);
        }
        
        public final void aK(Object paramAnonymousObject)
        {
          AppMethodBeat.i(114087);
          PluginFunctionMsg.this.getReceiver();
          if (com.tencent.mm.u.a.agG())
          {
            com.tencent.mm.u.a.gta.agJ();
            com.tencent.mm.u.a.cPp = System.currentTimeMillis();
            com.tencent.mm.u.a.gtb = false;
            ae.i("FunctionMsg.FunctionMsgEngine", "[finishSyncDoCmd] check time:%s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
          }
          AppMethodBeat.o(114087);
        }
      });
    }
    AppMethodBeat.o(114090);
  }
  
  public com.tencent.mm.u.a getReceiver()
  {
    return com.tencent.mm.u.a.gtd;
  }
  
  public void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(114091);
    d.a.a(this.cPN);
    AppMethodBeat.o(114091);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(114092);
    d.a.b(this.cPN);
    AppMethodBeat.o(114092);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.PluginFunctionMsg
 * JD-Core Version:    0.7.0.1
 */