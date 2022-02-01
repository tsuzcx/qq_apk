package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public final class c
  extends com.tencent.mm.plugin.backup.b.a
{
  private static String TAG = "MicroMsg.BackupItemFactory";
  private static c vaP;
  private HashMap<Integer, l> vaQ;
  
  public static c cVS()
  {
    AppMethodBeat.i(21510);
    if (vaP == null)
    {
      localc = new c();
      vaP = localc;
      a(localc);
    }
    c localc = vaP;
    AppMethodBeat.o(21510);
    return localc;
  }
  
  private void cVT()
  {
    AppMethodBeat.i(21512);
    this.vaQ = new HashMap();
    this.vaQ.put(Integer.valueOf(3), new d());
    this.vaQ.put(Integer.valueOf(47), new b());
    this.vaQ.put(Integer.valueOf(49), new a());
    this.vaQ.put(Integer.valueOf(34), new g());
    Object localObject = new f();
    this.vaQ.put(Integer.valueOf(43), localObject);
    this.vaQ.put(Integer.valueOf(44), localObject);
    this.vaQ.put(Integer.valueOf(62), localObject);
    localObject = new e();
    this.vaQ.put(Integer.valueOf(48), localObject);
    this.vaQ.put(Integer.valueOf(42), localObject);
    this.vaQ.put(Integer.valueOf(66), localObject);
    this.vaQ.put(Integer.valueOf(10000), localObject);
    this.vaQ.put(Integer.valueOf(1), localObject);
    this.vaQ.put(Integer.valueOf(37), localObject);
    this.vaQ.put(Integer.valueOf(40), localObject);
    this.vaQ.put(Integer.valueOf(50), localObject);
    AppMethodBeat.o(21512);
  }
  
  public final l Fj(int paramInt)
  {
    AppMethodBeat.i(21511);
    if (this.vaQ == null) {
      cVT();
    }
    l locall = (l)this.vaQ.get(Integer.valueOf(paramInt));
    AppMethodBeat.o(21511);
    return locall;
  }
  
  public final void cUE()
  {
    vaP = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.c
 * JD-Core Version:    0.7.0.1
 */