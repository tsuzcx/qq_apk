package com.tencent.mm.plugin.backup.bakoldlogic.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.b.a;
import java.util.HashMap;

public final class d
  extends a
{
  private static String TAG = "MicroMsg.BakOldItemFactory";
  private static d rTc;
  private HashMap<Integer, j> rPB;
  
  public static d cuj()
  {
    AppMethodBeat.i(21843);
    if (rTc == null)
    {
      locald = new d();
      rTc = locald;
      a(locald);
    }
    d locald = rTc;
    AppMethodBeat.o(21843);
    return locald;
  }
  
  public final j EU(int paramInt)
  {
    AppMethodBeat.i(21844);
    if (this.rPB == null)
    {
      this.rPB = new HashMap();
      this.rPB.put(Integer.valueOf(3), new e());
      this.rPB.put(Integer.valueOf(47), new c());
      this.rPB.put(Integer.valueOf(49), new b());
      this.rPB.put(Integer.valueOf(34), new h());
      localObject = new g();
      this.rPB.put(Integer.valueOf(43), localObject);
      this.rPB.put(Integer.valueOf(44), localObject);
      this.rPB.put(Integer.valueOf(62), localObject);
      localObject = new f();
      this.rPB.put(Integer.valueOf(48), localObject);
      this.rPB.put(Integer.valueOf(42), localObject);
      this.rPB.put(Integer.valueOf(66), localObject);
      this.rPB.put(Integer.valueOf(10000), localObject);
      this.rPB.put(Integer.valueOf(1), localObject);
      this.rPB.put(Integer.valueOf(37), localObject);
      this.rPB.put(Integer.valueOf(40), localObject);
      this.rPB.put(Integer.valueOf(50), localObject);
    }
    Object localObject = (j)this.rPB.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(21844);
    return localObject;
  }
  
  public final void crU()
  {
    rTc = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.b.d
 * JD-Core Version:    0.7.0.1
 */