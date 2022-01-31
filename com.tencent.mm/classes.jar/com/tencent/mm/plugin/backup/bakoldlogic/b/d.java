package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.a;
import java.util.HashMap;

public final class d
  extends a
{
  private static String TAG = "MicroMsg.BakOldItemFactory";
  private static d jGU;
  private HashMap<Integer, j> jDv;
  
  public static d aUT()
  {
    AppMethodBeat.i(17786);
    if (jGU == null)
    {
      locald = new d();
      jGU = locald;
      a(locald);
    }
    d locald = jGU;
    AppMethodBeat.o(17786);
    return locald;
  }
  
  public final void aSG()
  {
    jGU = null;
  }
  
  public final j rA(int paramInt)
  {
    AppMethodBeat.i(17787);
    if (this.jDv == null)
    {
      this.jDv = new HashMap();
      this.jDv.put(Integer.valueOf(3), new e());
      this.jDv.put(Integer.valueOf(47), new c());
      this.jDv.put(Integer.valueOf(49), new b());
      this.jDv.put(Integer.valueOf(34), new h());
      localObject = new g();
      this.jDv.put(Integer.valueOf(43), localObject);
      this.jDv.put(Integer.valueOf(44), localObject);
      this.jDv.put(Integer.valueOf(62), localObject);
      localObject = new f();
      this.jDv.put(Integer.valueOf(48), localObject);
      this.jDv.put(Integer.valueOf(42), localObject);
      this.jDv.put(Integer.valueOf(66), localObject);
      this.jDv.put(Integer.valueOf(10000), localObject);
      this.jDv.put(Integer.valueOf(1), localObject);
      this.jDv.put(Integer.valueOf(37), localObject);
      this.jDv.put(Integer.valueOf(40), localObject);
      this.jDv.put(Integer.valueOf(50), localObject);
    }
    Object localObject = (j)this.jDv.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(17787);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.d
 * JD-Core Version:    0.7.0.1
 */