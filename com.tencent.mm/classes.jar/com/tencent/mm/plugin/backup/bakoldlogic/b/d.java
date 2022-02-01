package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.a;
import java.util.HashMap;

public final class d
  extends a
{
  private static String TAG = "MicroMsg.BakOldItemFactory";
  private static d nAL;
  private HashMap<Integer, j> nxn;
  
  public static d bJh()
  {
    AppMethodBeat.i(21843);
    if (nAL == null)
    {
      locald = new d();
      nAL = locald;
      a(locald);
    }
    d locald = nAL;
    AppMethodBeat.o(21843);
    return locald;
  }
  
  public final void bGS()
  {
    nAL = null;
  }
  
  public final j xJ(int paramInt)
  {
    AppMethodBeat.i(21844);
    if (this.nxn == null)
    {
      this.nxn = new HashMap();
      this.nxn.put(Integer.valueOf(3), new e());
      this.nxn.put(Integer.valueOf(47), new c());
      this.nxn.put(Integer.valueOf(49), new b());
      this.nxn.put(Integer.valueOf(34), new h());
      localObject = new g();
      this.nxn.put(Integer.valueOf(43), localObject);
      this.nxn.put(Integer.valueOf(44), localObject);
      this.nxn.put(Integer.valueOf(62), localObject);
      localObject = new f();
      this.nxn.put(Integer.valueOf(48), localObject);
      this.nxn.put(Integer.valueOf(42), localObject);
      this.nxn.put(Integer.valueOf(66), localObject);
      this.nxn.put(Integer.valueOf(10000), localObject);
      this.nxn.put(Integer.valueOf(1), localObject);
      this.nxn.put(Integer.valueOf(37), localObject);
      this.nxn.put(Integer.valueOf(40), localObject);
      this.nxn.put(Integer.valueOf(50), localObject);
    }
    Object localObject = (j)this.nxn.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(21844);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.d
 * JD-Core Version:    0.7.0.1
 */