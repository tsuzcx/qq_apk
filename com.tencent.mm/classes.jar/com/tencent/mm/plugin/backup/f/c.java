package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class c
  extends com.tencent.mm.plugin.backup.b.a
{
  private static String TAG = "MicroMsg.BackupItemFactory";
  private static c oNE;
  private HashMap<Integer, l> oNF;
  
  public static c cfW()
  {
    AppMethodBeat.i(21510);
    if (oNE == null)
    {
      localc = new c();
      oNE = localc;
      a(localc);
    }
    c localc = oNE;
    AppMethodBeat.o(21510);
    return localc;
  }
  
  private void cfX()
  {
    AppMethodBeat.i(21512);
    this.oNF = new HashMap();
    this.oNF.put(Integer.valueOf(3), new d());
    this.oNF.put(Integer.valueOf(47), new b());
    this.oNF.put(Integer.valueOf(49), new a());
    this.oNF.put(Integer.valueOf(34), new g());
    Object localObject = new f();
    this.oNF.put(Integer.valueOf(43), localObject);
    this.oNF.put(Integer.valueOf(44), localObject);
    this.oNF.put(Integer.valueOf(62), localObject);
    localObject = new e();
    this.oNF.put(Integer.valueOf(48), localObject);
    this.oNF.put(Integer.valueOf(42), localObject);
    this.oNF.put(Integer.valueOf(66), localObject);
    this.oNF.put(Integer.valueOf(10000), localObject);
    this.oNF.put(Integer.valueOf(1), localObject);
    this.oNF.put(Integer.valueOf(37), localObject);
    this.oNF.put(Integer.valueOf(40), localObject);
    this.oNF.put(Integer.valueOf(50), localObject);
    AppMethodBeat.o(21512);
  }
  
  public final l Bh(int paramInt)
  {
    AppMethodBeat.i(21511);
    if (this.oNF == null) {
      cfX();
    }
    l locall = (l)this.oNF.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(21511);
    return locall;
  }
  
  public final void ceH()
  {
    oNE = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.c
 * JD-Core Version:    0.7.0.1
 */