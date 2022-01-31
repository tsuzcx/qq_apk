package com.tencent.mm;

import com.tencent.mm.api.e;
import com.tencent.mm.api.o;
import com.tencent.mm.cf.h.d;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.sdk.e.i;
import java.util.HashMap;

public class PluginFunctionMsg
  extends f
  implements o, com.tencent.mm.kernel.api.a
{
  private static HashMap<Integer, h.d> btR = new HashMap();
  
  static
  {
    String str = i.a(e.buS, "FunctionMsgItem");
    btR.put(Integer.valueOf("FunctionMsgItem".hashCode()), new h.d()
    {
      public final String[] rK()
      {
        return this.btS;
      }
    });
  }
  
  public HashMap<Integer, h.d> collectDatabaseFactory()
  {
    return btR;
  }
  
  public void configure(com.tencent.mm.kernel.b.g paramg)
  {
    super.configure(paramg);
    com.tencent.mm.kernel.g.a(h.class, getReceiver());
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg) {}
  
  public com.tencent.mm.v.a getReceiver()
  {
    return com.tencent.mm.v.a.dBr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.PluginFunctionMsg
 * JD-Core Version:    0.7.0.1
 */