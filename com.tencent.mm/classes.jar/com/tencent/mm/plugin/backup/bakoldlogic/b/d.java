package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.a;
import java.util.HashMap;

public final class d
  extends a
{
  private static String TAG = "MicroMsg.BakOldItemFactory";
  private static d ves;
  private HashMap<Integer, j> vaQ;
  
  public static d cWT()
  {
    AppMethodBeat.i(21843);
    if (ves == null)
    {
      locald = new d();
      ves = locald;
      a(locald);
    }
    d locald = ves;
    AppMethodBeat.o(21843);
    return locald;
  }
  
  public final j Fv(int paramInt)
  {
    AppMethodBeat.i(21844);
    if (this.vaQ == null)
    {
      this.vaQ = new HashMap();
      this.vaQ.put(Integer.valueOf(3), new e());
      this.vaQ.put(Integer.valueOf(47), new c());
      this.vaQ.put(Integer.valueOf(49), new b());
      this.vaQ.put(Integer.valueOf(34), new h());
      localObject = new g();
      this.vaQ.put(Integer.valueOf(43), localObject);
      this.vaQ.put(Integer.valueOf(44), localObject);
      this.vaQ.put(Integer.valueOf(62), localObject);
      localObject = new f();
      this.vaQ.put(Integer.valueOf(48), localObject);
      this.vaQ.put(Integer.valueOf(42), localObject);
      this.vaQ.put(Integer.valueOf(66), localObject);
      this.vaQ.put(Integer.valueOf(10000), localObject);
      this.vaQ.put(Integer.valueOf(1), localObject);
      this.vaQ.put(Integer.valueOf(37), localObject);
      this.vaQ.put(Integer.valueOf(40), localObject);
      this.vaQ.put(Integer.valueOf(50), localObject);
    }
    Object localObject = (j)this.vaQ.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(21844);
    return localObject;
  }
  
  public final void cUE()
  {
    ves = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.d
 * JD-Core Version:    0.7.0.1
 */