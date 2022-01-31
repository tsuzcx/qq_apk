package com.tencent.mm;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.q;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.e.j;
import java.util.HashMap;

public class PluginFunctionMsg
  extends com.tencent.mm.kernel.b.f
  implements q, com.tencent.mm.kernel.api.a
{
  private static HashMap<Integer, h.d> bVb;
  
  static
  {
    AppMethodBeat.i(35444);
    bVb = new HashMap();
    String str = j.getCreateSQLs(com.tencent.mm.api.f.info, "FunctionMsgItem");
    bVb.put(Integer.valueOf("FunctionMsgItem".hashCode()), new PluginFunctionMsg.2(new String[] { str }));
    AppMethodBeat.o(35444);
  }
  
  public HashMap<Integer, h.d> collectDatabaseFactory()
  {
    return bVb;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(35442);
    super.configure(paramg);
    com.tencent.mm.kernel.g.b(h.class, getReceiver());
    AppMethodBeat.o(35442);
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(141040);
    if (paramg.SD()) {
      ((i)com.tencent.mm.kernel.g.E(i.class)).a(new PluginFunctionMsg.1(this));
    }
    AppMethodBeat.o(141040);
  }
  
  public com.tencent.mm.u.a getReceiver()
  {
    return com.tencent.mm.u.a.eyI;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.PluginFunctionMsg
 * JD-Core Version:    0.7.0.1
 */