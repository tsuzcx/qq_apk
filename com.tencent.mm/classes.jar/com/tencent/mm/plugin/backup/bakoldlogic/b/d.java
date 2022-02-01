package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.a;
import java.util.HashMap;

public final class d
  extends a
{
  private static String TAG = "MicroMsg.BakOldItemFactory";
  private static d oRd;
  private HashMap<Integer, j> oNF;
  
  public static d cgY()
  {
    AppMethodBeat.i(21843);
    if (oRd == null)
    {
      locald = new d();
      oRd = locald;
      a(locald);
    }
    d locald = oRd;
    AppMethodBeat.o(21843);
    return locald;
  }
  
  public final j Bt(int paramInt)
  {
    AppMethodBeat.i(21844);
    if (this.oNF == null)
    {
      this.oNF = new HashMap();
      this.oNF.put(Integer.valueOf(3), new e());
      this.oNF.put(Integer.valueOf(47), new c());
      this.oNF.put(Integer.valueOf(49), new b());
      this.oNF.put(Integer.valueOf(34), new h());
      localObject = new g();
      this.oNF.put(Integer.valueOf(43), localObject);
      this.oNF.put(Integer.valueOf(44), localObject);
      this.oNF.put(Integer.valueOf(62), localObject);
      localObject = new f();
      this.oNF.put(Integer.valueOf(48), localObject);
      this.oNF.put(Integer.valueOf(42), localObject);
      this.oNF.put(Integer.valueOf(66), localObject);
      this.oNF.put(Integer.valueOf(10000), localObject);
      this.oNF.put(Integer.valueOf(1), localObject);
      this.oNF.put(Integer.valueOf(37), localObject);
      this.oNF.put(Integer.valueOf(40), localObject);
      this.oNF.put(Integer.valueOf(50), localObject);
    }
    Object localObject = (j)this.oNF.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(21844);
    return localObject;
  }
  
  public final void ceH()
  {
    oRd = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.d
 * JD-Core Version:    0.7.0.1
 */