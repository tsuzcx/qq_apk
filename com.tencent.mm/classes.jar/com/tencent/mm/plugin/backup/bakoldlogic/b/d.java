package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.a;
import java.util.HashMap;

public final class d
  extends a
{
  private static String TAG = "MicroMsg.BakOldItemFactory";
  private static d myn;
  private HashMap<Integer, j> muP;
  
  public static d byc()
  {
    AppMethodBeat.i(21843);
    if (myn == null)
    {
      locald = new d();
      myn = locald;
      a(locald);
    }
    d locald = myn;
    AppMethodBeat.o(21843);
    return locald;
  }
  
  public final void bvO()
  {
    myn = null;
  }
  
  public final j wm(int paramInt)
  {
    AppMethodBeat.i(21844);
    if (this.muP == null)
    {
      this.muP = new HashMap();
      this.muP.put(Integer.valueOf(3), new e());
      this.muP.put(Integer.valueOf(47), new c());
      this.muP.put(Integer.valueOf(49), new b());
      this.muP.put(Integer.valueOf(34), new h());
      localObject = new g();
      this.muP.put(Integer.valueOf(43), localObject);
      this.muP.put(Integer.valueOf(44), localObject);
      this.muP.put(Integer.valueOf(62), localObject);
      localObject = new f();
      this.muP.put(Integer.valueOf(48), localObject);
      this.muP.put(Integer.valueOf(42), localObject);
      this.muP.put(Integer.valueOf(66), localObject);
      this.muP.put(Integer.valueOf(10000), localObject);
      this.muP.put(Integer.valueOf(1), localObject);
      this.muP.put(Integer.valueOf(37), localObject);
      this.muP.put(Integer.valueOf(40), localObject);
      this.muP.put(Integer.valueOf(50), localObject);
    }
    Object localObject = (j)this.muP.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(21844);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.d
 * JD-Core Version:    0.7.0.1
 */